
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def count_unival_subtrees(root):

    count = [0]  

    def is_unival(node):
        if not node:
            return True

        left_unival = is_unival(node.left)
        right_unival = is_unival(node.right)

        if not left_unival or not right_unival:
            return False

        if node.left and node.left.val != node.val:
            return False
        if node.right and node.right.val != node.val:
            return False

        count[0] += 1
        return True

    is_unival(root)
    return count[0]


if __name__ == "__main__":
    root = Node(0,
                Node(1),
                Node(0,
                     Node(1, Node(1), Node(1)),
                     Node(0)))

    print("Count of Unival Subtrees:", count_unival_subtrees(root))
