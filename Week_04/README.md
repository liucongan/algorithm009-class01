
深度优先搜索和广度优先搜索(deep first or breadth first)
# dfs模版1
def dfs(node):
	if node in visited:
		return
	visited.add(node)
	# process current node
	dfs(node.left)
	dfs(node.right)
	
# dfs模版2
def DFS(self, root):
	if root in None:
		return None
	visited, stack = [], [root]
	while stack:
		node = stack.pop()
		visited.add(node)
		process(node)
		nodes = generate_related_nodes(node)
		stack.push(nodes)



二分查找

left, right = 0, len(array)-1
while left <= right:
	mid = left + (right - left)//2
	if array[mid] == target:
		# find the target
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid - 1  