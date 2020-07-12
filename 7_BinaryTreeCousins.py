'''
@author: codork
@date: 07-05-2020
@problem: In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def find(self, root: TreeNode, key: int, parent: TreeNode, depth: int):
        if root == None:
            return [False, parent, depth]
        if root.val == key:
            return [True, parent, depth]
        res = self.find(root.left, key, root, depth+1)
        if res[0] == True:
            return res
        res = self.find(root.right, key, root, depth+1)
        return res

        '''if root == None or (root.left == None and root.right == None):
            return False, None
        if root.left != None:
            if root.left.val == key:
                return True, root
        if root.right != None:
            if root.right.val == key:
                return True, root
        res, par = self.find(root.left, key)
        if res == True:
            return res, par
        else:
            res, par = self.find(root.right, key)
        return res, par
        '''



    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        resx = self.find(root, x, root, 0)
        resy = self.find(root, y, root, 0)

        if resx[0] == True and resy[0] == True: #and resx[1] != None and resy[1] != None:
            if resx[1].val != resy[1].val and resx[2] == resy[2]:
                return True
        return False
