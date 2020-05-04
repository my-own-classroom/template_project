import pytest
import subprocess

def run_command(command):
    process = subprocess.Popen(command,
                               stdout=subprocess.PIPE,
                               stderr=subprocess.STDOUT)

    stdout, stderr = process.communicate()
    return stdout


def test(data_array):
    actual = run_command(["java", "-jar", data_array[0], data_array[1], data_array[2], data_array[3]])
    assert actual.rstrip() == data_array[4], "failed"
