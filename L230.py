class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class L230(object):

    def __init__(self):
        self.count = 0
        self.result = None

    def kthSmallest(self, root, k):
        self.k = k
        self.inorder(root)
        return self.result

    def inorder(self, root):
        if not root or self.result is not None:
            return
        
        # Left subtree
        self.inorder(root.left)

        # Visit current node
        self.count += 1
        if self.count is self.k:
            self.result = root.val
            return
        
        # Right subtree
        self.inorder(root.right)
