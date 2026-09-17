/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null &&  head.next == null) return true;

        List<Integer> arr = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        
        boolean ans = isPalindrome(arr);
        return ans;
    }

    public boolean isPalindrome(List<Integer> arr) {

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {

            if (!arr.get(left).equals(arr.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}