package linkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();

        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        
        return false;
    }
}