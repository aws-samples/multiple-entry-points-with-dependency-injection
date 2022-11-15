#!/bin/bash

sed 's/{username}/'"$(whoami)"'/' $1