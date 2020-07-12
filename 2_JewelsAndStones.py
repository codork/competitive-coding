'''
@author: codork
@date: 03-05-2020
@problem: You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
'''
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        J = list(J)
        S = list(S)
        count = 0

        for stone in S:
            if stone in J:
                count += 1

        return count
