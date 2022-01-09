class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {        
        if(root == null) return 0
        
        var maxWidth = 0
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(root to 1)
        
        while(queue.isNotEmpty()){
            var begin = 0
            var end = 0
            var len = queue.size
            for(i in 0 until len){
                val current = queue.poll()
                if(i == 0) begin = current.second
                if(i == len - 1) end = current.second
                current.first.left?.let {
                    queue.add(it to current.second * 2)
                }
                
                current.first.right?.let {
                    queue.add(it to current.second * 2 + 1)
                }                
            }
            
            val width = end - begin + 1
            maxWidth = maxOf(maxWidth, width)
        }
        
        return maxWidth
    }
}
