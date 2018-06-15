import requests
import sys

from time import sleep
from os import system


def do_many_gets():
    # Do work to force the httpd.
    # Get the file:
    #   GET http://localhost:8000/test_file.txt

    respose_list = []
    for i in xrange(10):
        respose_list.append(requests.get('http://localhost:8000/myfile.txt'))
    return respose_list

def convert_response_num(resp_num):
    return str(resp_num) + '\n'

def create_output_file(response_list, p_number):
    time_list = [resp.elapsed.total_seconds() for resp in response_list]

    # Save raw file.
    time_list = map(convert_response_num, time_list)
    with open('raw_experiments_output' + p_number + '.txt', 'w') as file_:
        file_.writelines(time_list)

def main():
    # Run Experiments!
    response_list = do_many_gets()
    create_output_file(response_list, p_number=sys.argv[1])

if __name__ == '__main__':
    main()
