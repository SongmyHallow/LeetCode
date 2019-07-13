package GetNext;
public class Solution{
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null)   return null;
        // 右子树不为空，返回右子树第一个左子树
        if(pNode.right != null){
            TreeLinkNode inx = pNode.right;
            while(inx != null){
                if(inx.left != null){
                    inx = inx.left;
                }
                else{
                    break;
                }
            }
            return inx;
        }
        else if(pNode.left !=null && pNode.right == null){
            return pNode.next;
        }
        else{
            // 只有一个节点的树
            if(pNode.next==null){
                return null;
            }
            // 左叶子，返回父节点
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            // 右叶子，分情况，有特殊情况
            else{
                TreeLinkNode inx = pNode.next;
                // 找到根节点
                while(inx != null){
                    if(inx.next!=null){
                        inx = inx.next;
                    }
                    else{
                        break;
                    }
                }
                // 斜树
                if(inx==pNode){
                    return null;
                }
                while(inx != null){
                    if(inx.right!=null){
                        inx = inx.right;
                    }
                    else{
                        break;
                    }
                }
                // 中序遍历最后一个节点
                if(inx == pNode){
                    return null;
                }
                else{
                    return pNode.next.next;
                }
            }
        }
    }

}