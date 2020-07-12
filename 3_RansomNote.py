'''
@author: codork
@date: 03-05-2020
@problem: Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.
'''

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        ransomNote = (list)(ransomNote)
        magazine = (list)(magazine)

        for char in ransomNote:
            if char in magazine:
                magazine.remove(char)
            else:
                return False

        return True