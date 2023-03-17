class Trie {

        TrieNode head;
        Set<String> set;
        public Trie() {
            head = new TrieNode();
            set = new HashSet<>();
        }

        public void insert(String word) {
            TrieNode temp = head;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (temp.children[c] == null) {
                    temp.children[c] = new TrieNode();
                }
                temp = temp.children[c];
            }
            set.add(word);
        }

        public boolean search(String word) {
            return set.contains(word);
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = head;
            for (int i = 0; i < prefix.length(); i++) {
                if (temp.children[prefix.charAt(i) - 'a'] == null) return false;
                else temp = temp.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }

    static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
