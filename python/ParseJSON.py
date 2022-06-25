import csv
import json

f = open("/Users/aarat/Downloads/peak_sales_2020_10_03.json", "r")
js = json.load(f)
f.close()
fileNames = ["peak_sales.csv", "peak_stores.csv", "peak_customers.csv", "peak_line_items.csv"]

mode = 'w'
# Code For Adding The Header!
for file in fileNames:
    # OPTIONAL!!
    # if os.path.exists(file):
    #     mode = 'a'
    # else:
    #     mode = 'w'

    with open(file, mode) as csvFile:
        if file == "peak_sales.csv":
            writer = csv.writer(csvFile)
            writer.writerow(["sale_id", "sale_date", "sub_total", "tax", "total_amount"])
        elif file == "peak_stores.csv":
            writer = csv.writer(csvFile)
            writer.writerow(["sale_id", "location_id", "name", "street", "city", "state", "zip"])
        elif file == "peak_customers.csv":
            writer = csv.writer(csvFile)
            writer.writerow(["sale_id", "customer_id", "first_name", "last_name", "city", "state", "zip"])
        else:
            writer = csv.writer(csvFile)
            writer.writerow(["sale_id", "line_item_id", "product_id", "price", "quantity", "taxable"])
mode = 'a'
for data in js['sales']:
    for file in fileNames:
        with open(file, mode) as csvFile:
            if file == "peak_sales.csv":
                writer = csv.writer(csvFile)
                writer.writerow([data['sale_id'], data['sale_date'], data['sub_total'], data['tax'], data['total_amount']])
            elif file == "peak_stores.csv":
                writer = csv.writer(csvFile)
                writer.writerow([data['sale_id'], data['pickup_from']['location_id'], data['pickup_from']['name'], data['pickup_from']['street'], data['pickup_from']['city'], data['pickup_from']['state'], data['pickup_from']['zip']])
            elif file == "peak_customers.csv":
                writer = csv.writer(csvFile)
                writer.writerow([data['sale_id'], data['deliver_to']['customer_id'], data['deliver_to']['first_name'], data['deliver_to']['last_name'], data['deliver_to']['city'], data['deliver_to']['state'], data['deliver_to']['zip']])
            else:
                writer = csv.writer(csvFile)
                for item in data['line_items']:
                    dic = dict(item)
                    writer.writerow([data['sale_id'], data['line_items'].__len__(), dic['product_id'], dic['price'], dic['quantity'], dic['taxable']])

