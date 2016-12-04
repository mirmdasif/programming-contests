package net.asifhossain.datastructure;

/**
 * Trie for strings contain characters 'a' 'b' 'c'
 * @author asif.hossain
 * @since 3/31/15
 */
@SuppressWarnings("unused")
public class TernaryTrie {

    public static final int NUM_ELEMENTS= 3;
    
    Node root = new Node();

    public void add(String str) {
        
        Node currentNode = root;
        
        for (int i = 0; i < str.length() ; i++) {
            
            if (currentNode.childNodes[str.charAt(i)-'a'] == null ) {
                
                currentNode = currentNode.childNodes[str.charAt(i)-'a'] = new Node();
            }
            else {
                currentNode = currentNode.childNodes[str.charAt(i)-'a'];
            }
        }
        currentNode.value++;
    }


    public boolean dfsSearch(Node node, String str, int countChange, int depth) {

        if (str.length() == depth) {
            
            if (node.value > 0 && countChange == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        
        for (int i=0; i < NUM_ELEMENTS; i++) {

            int changeInCurrentSubTree = countChange;
            
            if (node.childNodes[i] == null)
                continue;
            
            if (str.charAt(depth) != 'a'+i) {
                changeInCurrentSubTree++;
            }
            
            // Subtree with only one change is allowed
            if (changeInCurrentSubTree<2) {
                if (dfsSearch(node.childNodes[i],str,changeInCurrentSubTree,depth+1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean contains(String str) {
        return dfsSearch(root,str,0,0);
    }

    private class Node {
        Node[] childNodes = new Node[NUM_ELEMENTS];
        int value;
    }    
}
