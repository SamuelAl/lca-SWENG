package main

type TreeNode struct {
	value    int
	children []*TreeNode
}

type Solution struct {
	node *TreeNode
}

func NewTreeNode(value int) *TreeNode {
	return &TreeNode{
		value:    value,
		children: make([]*TreeNode, 0),
	}
}

func (node *TreeNode) AddChild(child *TreeNode) {
	node.children = append(node.children, child)
}

func FindLCA(root *TreeNode, a, b int) *Solution {
	solution := &Solution{
		node: nil,
	}
	FindLCARecursive(root, a, b, solution)
	return solution
}

func FindLCARecursive(curr *TreeNode, a, b int, solution *Solution) int {
	count := 0
	if solution.node != nil {
		return count
	}
	if curr == nil {
		return count
	}

	if curr.value == a || curr.value == b {
		count++
	}

	for _, child := range curr.children {
		newCount := FindLCARecursive(child, a, b, solution)
		if solution.node != nil {
			return count
		}
		count += newCount
		if count >= 2 && solution.node == nil {
			solution.node = curr
			return count
		}
	}
	return count
}
