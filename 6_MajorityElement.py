'''
@author: codork
@date: 06-05-2020
@problem: Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
'''

import math

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[math.floor(len(nums)/2)]
