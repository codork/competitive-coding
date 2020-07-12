'''
@author: codork
@date: 05-05-2020
@problem: Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
'''
class Solution:
    def firstUniqChar(self, s: str) -> int:
        string = list(s)
        while(string):
            char = string.pop(0)
            if char in string:
                string = list(filter(lambda a: a != char, string))
            else:
                return s.index(char)
        if len(string) == 0:
            return -1
