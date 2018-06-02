import requests
import matplotlib.pyplot as plt

from time import sleep
from os import system


def compile():
    # run script for buid.
    pass

def do_many_gets():
    # Do work to force the httpd.
    # Get the file:
    #   GET http://localhost:8000/test_file.txt

    respose_list = []
    # Do stuff.
    return respose_list

def convert_response_num(resp_num):
    return str(resp_num) + '\n'

def create_output_file(response_list):
    # Save .png with the boxplot.
    time_list = [resp.elapsed.total_seconds() for resp in response_list]
    plt.boxplot(time_list)
    plt.savefig('b_plot_resp_time.png')

    # Save raw file.
    time_list = map(convert_response_num, time_list)
    with open('raw_experiments_output.txt', 'w') as file_:
        file_.writelines(time_list)

def main():
    # Run Experiments!
    compile()
    response_list = do_many_gets()
    create_output_file(response_list)

if __name__ == '__main__':
    main()
