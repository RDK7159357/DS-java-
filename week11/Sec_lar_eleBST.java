package week11;

class Node4 {
    int key;
    Node4 left, right;

    public Node4(int key) {
        this.key = key;
        left = right = null;
    }
}

class SecLargestBST {
    Node4 root;

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    private Node4 insertRec(Node4 node, int key) {
        if (node == null) {
            return new Node4(key);
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    // Find the second largest element in the BST
    void findSecondLargest() {
        if (root == null || (root.left == null && root.right == null)) {
            System.out.println("Tree must have at least two nodes.");
            return;
        }
        int[] result = {0}; // Counter to track the number of nodes visited
        secondLargestUtil(root, result);
    }

    private void secondLargestUtil(Node4 node, int[] count) {
        if (node == null || count[0] >= 2) {
            return;
        }

        // Traverse the right subtree first
        secondLargestUtil(node.right, count);

        // Increment count and check if this is the second largest
        count[0]++;
        if (count[0] == 2) {
            System.out.println("The second largest element is " + node.key);
            return;
        }

        // Traverse the left subtree
        secondLargestUtil(node.left, count);
    }

    public static void main(String[] args) {
        SecLargestBST tree = new SecLargestBST();

        /* Construct the following BST
                  50
               /     \
             30       70
            /  \     /  \
          20   40   60   80 
        */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Find the second largest element
        tree.findSecondLargest();
    }
}
