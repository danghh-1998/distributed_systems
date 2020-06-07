cmake_minimum_required(VERSION 3.16)
project(parallel_programming C)

set(CMAKE_C_STANDARD 99)
set(CMAKE_C_FLAGS -pthread)

add_executable(parallel_programming dead-lock.c)