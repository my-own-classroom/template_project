import json
import pytest
import subprocess
 
 
with open('test_data.json') as f:
    data = json.load(f)
 
data_array = []

for key, val in data.iteritems():
    if key != 'file_list':
        data_line = []
        for inner_key, inner_val in val.iteritems():
            for element in inner_val:
                data_line.append(element)
        data_array.append(data_line)


for key, val in data.iteritems():
    if key == 'file_list':
        for file_name in val:
            for element in data_array:
                element.insert(0, file_name)

data_array_res = [tuple(row) for row in data_array]
 
 
def run_command(command):
    process = subprocess.Popen(command,
                               stdout=subprocess.PIPE,
                               stderr=subprocess.STDOUT, shell=True)

    stdout, stderr = process.communicate()
    return stdout

 
 
@pytest.mark.parametrize("lab_file, input_param1, input_param2, input_param3, expected", data_array_res)
def test(lab_file, input_param1, input_param2, input_param3, expected):
    actual = run_command(["java", "-jar", lab_file, input_param1, input_param2, input_param3])
    assert actual.rstrip() == expected, "failed"
