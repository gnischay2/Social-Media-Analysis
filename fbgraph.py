import matplotlib.pyplot as plt
import numpy as np
import wave
import sys
import csv

comp1=[];
comp2=[];
f = open('facebook.csv', 'rt')
f2 = open('graph.txt','r')
g = f2.readline()
g=g.rstrip('\n')
line = f2.readline()
line2=int(line[:1])
line4 = f2.readline()
line3=int(line4[:1])
print line2
print line3
try:
    reader = csv.reader(f)
    for row in reader:
        if row[0]==g:
            comp1.append(float(row[line2]));
            print comp2.append(float(row[line3]));
finally:
    f.close()
    plt.figure(1)
    plt.title('Like Graph')
    plt.stem(comp1,comp2,'-',bottom=0)
    #plt.plot(comp1,comp2)
    plt.show()
