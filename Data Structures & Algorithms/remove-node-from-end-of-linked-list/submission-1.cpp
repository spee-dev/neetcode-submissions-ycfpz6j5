/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head==NULL||head->next==NULL)return NULL;
        int N=0;
        ListNode* temp=head;
        while(temp!=NULL){
            N++;
            temp=temp->next;
        }
        int remove_i=N-n;
        if(remove_i==0){
            return head->next;
        }
        ListNode* cur=head;
        for(int i=0;i<N-1;i++){
            if((i+1)==remove_i){
                cur->next=cur->next->next;
            }
            cur=cur->next;
        }
        return head;
    }
};
