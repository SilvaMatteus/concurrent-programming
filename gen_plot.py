import matplotlib.pyplot as plt

def create(timelist):
    plt.boxplot(timelist)
    plt.savefig('b_plot_resp_time.png')

if __name__ == '__main__':
    pass
