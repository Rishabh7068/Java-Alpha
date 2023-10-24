public class Pre {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node currNode = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new Node();
            } else {
                currNode.children[idx].freq++;
            }
            currNode = currNode.children[idx];
        }
        currNode.eow = true;
    }

    public static String ans = "";

    public static void findLongest(Node root, StringBuilder tem) {
        if (root == null) {
            return;
        }

        Node curr = root;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].eow == true) {
                char ch = (char) (i + 'a');
                tem.append(ch);
                if (tem.length() > ans.length()) {
                    ans = tem.toString();
                }
                findLongest(curr.children[i], tem);
                // back track
                tem.deleteCharAt(tem.length() - 1);

            }
        }
    }

    public static void main(String[] args) {
        String str[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (String s : str) {
            insert(s);
        }

        findLongest(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
