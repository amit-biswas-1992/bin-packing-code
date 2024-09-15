import pandas as pd
import matplotlib.pyplot as plt
# from scipy.interpolate import make_interp_spline, BSpline, interp1d
import numpy as np


def logarithm_graph():
    # dataset = pd.read_csv("ExecutionTimeReport.csv")
    dataset = pd.read_csv("RequiredBinReport.csv")
    # x = df.index
    df = dataset
    x = df[df.columns[0]]
    x = [np.log10(int(num)) for num in x]
    print(x)

    y1 = df[df.columns[1]]
    y2 = df[df.columns[2]]
    y3 = df[df.columns[3]]
    y4 = df[df.columns[4]]
    y5 = df[df.columns[5]]
    y6 = df[df.columns[6]]

    plt.style.use('bmh')
    plt.plot(x, y1, label='FF')
    plt.plot(x, y2, label='FFD')
    plt.plot(x, y3, label='NF')
    plt.plot(x, y4, label='NFD')
    plt.plot(x, y5, label='BF')
    plt.plot(x, y6, label='WF')

    plt.xlabel("log n", font='consolas',  fontsize=16, color='crimson')
    # plt.ylabel("Running Time (ns)", font='consolas', fontsize=16, color='crimson')
    plt.ylabel("Required Bins", font='consolas', fontsize=16, color='crimson')
    plt.title("Bin Packing Algorithm (Log Scale)", font='consolas', fontsize=18 )
    plt.legend(loc=2, fontsize=12)

    plt.grid(color = 'gray', linestyle = '--', linewidth = 0.2)
    plt.tight_layout()

    plt.gcf().set_size_inches(16, 10)
    plt.gcf().savefig("output.png", dpi=100)

    plt.show()


# def linear_graph():
#     # dataset = pd.read_csv()
#     dataset = pd.read_csv("ExecutionTimeReport.csv")
#     # dataset = pd.read_csv("RequiredBinReport.csv")
#     # df = dataset.T
#     # x = df.index.values
#     # x = [int(num) for num in x]
#     df = dataset
#     x = df[df.columns[0]]
#     print(x)

#     y1 = df[df.columns[1]]
#     y2 = df[df.columns[2]]
#     y3 = df[df.columns[3]]
#     y4 = df[df.columns[4]]
#     y5 = df[df.columns[5]]
#     y6 = df[df.columns[6]]

#     plt.style.use('bmh')
#     plt.plot(x, y1, label='FF')
#     plt.plot(x, y2, label='FFD')
#     plt.plot(x, y3, label='NF')
#     plt.plot(x, y4, label='NFD')
#     plt.plot(x, y5, label='BF')
#     plt.plot(x, y6, label='WF')


#     plt.xlabel("Items (n)", font='consolas',  fontsize=16, color='crimson')
#     plt.ylabel("Running Time (ns)", font='consolas', fontsize=16, color='crimson')
#     # plt.ylabel("Required Bins", font='consolas', fontsize=16, color='crimson')
#     plt.title("Bin Packing Algorithm (Linear Scale)", font='consolas', fontsize=18 )
#     plt.legend(loc=2, fontsize=12)

#     plt.grid(color = 'gray', linestyle = '--', linewidth = 0.2)
#     plt.tight_layout()

#     plt.gcf().set_size_inches(16, 10)
#     plt.gcf().savefig("output.png", dpi=300)

#     plt.show()


logarithm_graph()
# linear_graph("ExecutionTimeReport.csv")
# linear_graph()

