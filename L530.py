class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class L530:
    def __init__(self):
        self.prev = None
        self.minDiff = float('inf')

    def getMinimumDifference(self, root: TreeNode) -> int:
        self.inorder(root)
        return self.minDiff

    def inorder(self, root: TreeNode):
        if not root:
            return

        self.inorder(root.left)

        if self.prev is not None:
            self.minDiff = min(self.minDiff, abs(root.val - self.prev))

        self.prev = root.val
        self.inorder(root.right)
