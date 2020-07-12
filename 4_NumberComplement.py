'''
@author: codork
@date: 06-05-2020
@problem: Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
'''

class Solution:
    def complement(self, n):
        if n == 0:
            return 1
        elif n == 1:
            return 0

    def findComplement(self, num: int) -> int:
        if num == 0:
            return 1
        elif num == 1:
            return 0

        binstack = []
        rem = num
        while (num != 0 and num != 1):
            rem = num % 2
            num = num // 2
            binstack.append(rem)
        binstack.append(num)
        comp = list(map(self.complement, binstack))
        result = 0
        for i in range(len(comp)):
            result = result + comp[i] * pow(2, i)
        return result
