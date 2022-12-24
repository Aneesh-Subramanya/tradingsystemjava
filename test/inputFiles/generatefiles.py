import math
import numpy as np
import random
from datetime import date

num = 1000

# https://www.treasurydirect.gov/auctions/upcoming/
# https://www.cmegroup.com/education/courses/introduction-to-treasuries/how-can-you-measure-risk-in-treasuries.html
USTs = [
    '91282CFX4',
    '91282CGA3',
    '91282CFZ9',
    '91282CFY2',
    '91282CFV8',
    '912810TM0',
    '912810TL2',
]

def writeToFile(file, quotes):
    file = open(file, 'w')
    for quote in quotes:
        file.write(quote + "\n")
    file.close()

def convertToBondQuotes(decimal):
    percentage = math.floor(decimal)
    fraction = decimal - percentage
    xy = math.floor(fraction / (1/32))
    z = math.floor((fraction - xy/32) / (1/256))
    z = str(z) if z != 4 else '+'
    quote = "{:d}-{:02d}{:s}".format(percentage, xy, z)
    return quote
    
# CUSIP BIDSIZE BID OFFER OFFERSIZE
def generatemarketdatatxt(USTs):
    quotes = []
    for UST in USTs:
        midsUp = np.arange(99, 101, 1/256)
        midsDown = np.arange(101, 99, -1/256)
        mids = np.append(midsUp, midsDown)
        topOfBookSpreads = [1/128, 2/128, 3/128, 4/128, 3/128, 2/128, 1/128]
        bidSizes = [10000000, 20000000, 30000000, 40000000, 50000000]
        offerSizes = [10000000, 20000000, 30000000, 40000000, 50000000]
        for i in range(num):
            topOfBookSpread = topOfBookSpreads[i%len(topOfBookSpreads)]
            spreads = [topOfBookSpread, topOfBookSpread+1/128, topOfBookSpread+2/128, topOfBookSpread+3/128, topOfBookSpread+4/128]
            mid = mids[i%len(mids)]
            for j in range(5):
                spread = spreads[j]
                bid = convertToBondQuotes(mid - spread/2)
                offer = convertToBondQuotes(mid + spread/2)
                # midStr = convertToBondQuotes((mid - spread/2 + mid + spread/2)/2)
                quote = [UST, str(bidSizes[j]), bid, offer, str(offerSizes[j])]
                quotes.append(' '.join(quote))
            quotes.append("")
            if i % 100000 == 0:
                print(UST, i)
            
    # print(quotes)
    writeToFile('marketdata.txt', quotes)

# CUSIP BID OFFER
def generatepricestxt(USTs):
    prices = []
    for UST in USTs:
        midsUp = np.arange(99, 101, 1/256)
        midsDown = np.arange(101, 99, -1/256)
        mids = np.append(midsUp, midsDown)
        spreads = [1/128, 1/64]
        for i in range(num):
            spread = spreads[i%len(spreads)]
            mid = mids[i%len(mids)]
            bid = convertToBondQuotes(mid - spread/2)
            offer = convertToBondQuotes(mid + spread/2)
            price = [UST, bid, offer]
            prices.append(' '.join(price))
        prices.append("")
    
    # print(prices)
    writeToFile('prices.txt', prices)

# CUSIP BOOK1 DIRECTION BOOK2 QTY PRICE
def generatetradestxt(USTs):
    trades = []
    books = ['TRSY1', 'TRSY2', 'TRSY3']
    directions = ['BUY', 'SELL']
    prices = [99, 100]
    qtys = [10000000, 20000000, 30000000, 40000000, 50000000, 50000000, 40000000, 30000000, 20000000, 10000000]
    for UST in USTs:
        for i in range(10):
            [book] = random.sample(books, 1)
            direction = directions[i%len(directions)]
            price = convertToBondQuotes(prices[i%len(prices)])
            qty = qtys[i%len(qtys)]
            trade = [UST, book, direction, str(qty), price]
            trades.append(' '.join(trade))
        trades.append("")
    
    # print(trades)
    writeToFile('trades.txt', trades)

# CUSIP DIRECTION QTY STATE
def generateinquiriestxt(USTs):
    inquiries = []
    directions = ['BUY', 'SELL']
    qtys = [10000000, 20000000, 30000000, 40000000, 50000000, 50000000, 40000000, 30000000, 20000000, 10000000]
    state = 'RECEIVED'
    counter = 1
    for UST in USTs:
        for i in range(10):
            inquiryId = "INQ" + date.today().strftime("%y%m%d") + str(counter).zfill(5)
            direction = directions[i%len(directions)]
            qty = qtys[i%len(qtys)]
            inquiry = [inquiryId, UST, direction, str(qty), state]
            inquiries.append(' '.join(inquiry))
        inquiries.append("")
    
    # print(inquiries)
    writeToFile('inquiries.txt', inquiries)

generatemarketdatatxt(USTs)
generatepricestxt(USTs)
generatetradestxt(USTs)
generateinquiriestxt(USTs)
