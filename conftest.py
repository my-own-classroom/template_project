import json
import pytest

def pytest_addoption(parser):
    parser.addoption("--name", action="store", default="", help="file name")
    parser.addoption("--json_file", action="store", default="test_data.json", help="json data file name")

def pytest_generate_tests(metafunc):
    if 'data_array' in metafunc.fixturenames:
        name = metafunc.config.getoption('name')
        json_file = metafunc.config.getoption('json_file')
        with open(json_file) as f:
            data = json.load(f)
        data_array = []
        for key, val in data.iteritems():
            data_line = []
            for inner_key, inner_val in val.iteritems():
                for element in inner_val:
                    data_line.append(element)

            data_array.append(data_line)

        for element in data_array:
            element.insert(0, name)

        metafunc.parametrize("data_array", data_array)
