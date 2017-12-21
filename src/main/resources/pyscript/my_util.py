import sys
import pandas as pd

def adder(a, b):    
	
	
	mysql_cn= MySQLdb.connect(host='localhost', port=3306,user='root', passwd='root', db='mftp')
	df = pd.read_sql('select * from model_perform;', con=mysql_cn)    
	mysql_cn.close()
	print("fdsfdsfsdfdfdsfsda")
	return df  

