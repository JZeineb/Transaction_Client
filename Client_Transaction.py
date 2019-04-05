# -*- coding: utf-8 -*-


@author: LENOVO
"""


from faker import Faker
import pandas as pd
import random  # For client id , transaction id
from faker.providers import date_time
from faker.providers import BaseProvider


# Create a new Faker providers for the operation's type (Debit, Credit)

class operationProvider(BaseProvider):
    
    @staticmethod
    def operation():
        operations = ['Debit','Credit']
        return random.choice(operations)
    


fake = Faker()
fake.add_provider(date_time)
fake.add_provider(operationProvider)

# Create a Client's DataFrame 

def client(num=1):
    output = [{"id":random.randint(0,500),
               "name":fake.name(),
               "address":fake.address().replace("\n"," ")} for x in range(num)]
    return output

df = pd.DataFrame(client(500))
print(df)

# Create a Transaction's DataFrame

def transaction(num=1):
    output = [{"id_client":random.randint(0,500),
               "id_transaction":random.randint(0,500),
               "number_transaction":random.randint(1,300),
               "time":fake.am_pm(),
               "type_operation":fake.operation()} for x in range(num)]
    return output

df1 = pd.DataFrame(transaction(500))
print(df1)

# Export DataFrame to csvfile
            
df.to_csv("ClientBank.csv",sep=";",index=False)
df1.to_csv("TransactionBank.csv",sep=";",index=False)