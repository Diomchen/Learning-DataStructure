public class Solution1 {
    public ListNode remove(ListNode head,int val){
//1。第一种方法
//        if(head == null)
//            return null;
//
//        ListNode res = remove(head.next,val);
//        if(head.val == val){
//            return res;
//        }
//        else{
//            head.next = res;
//            return head;
//        }

//2。第二种方法
        if(head == null){
            return null;
        }
        head.next = remove(head.next,val);
        if(head.val == val){
            return head.next;
        }
        else{
            return head;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,5,9,4,7,8,6,2,5};
//        ListNode t = new ListNode(arr);

    }

}
