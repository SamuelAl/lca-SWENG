package main

import "fmt"

func main() {
	fmt.Println("Finding the LCA!")

	tree := createSampleTree()
	solution := FindLCA(tree, 3, 5)
	fmt.Printf("LCA(3, 5) = %v", solution.node.value)
}

func createSampleTree() *TreeNode {
	root := NewTreeNode(0)
	child1 := NewTreeNode(1)
	child2 := NewTreeNode(2)
	child3 := NewTreeNode(3)
	child4 := NewTreeNode(4)
	child5 := NewTreeNode(5)

	root.AddChild(child1)
	root.AddChild(child2)
	child1.AddChild(child3)
	child1.AddChild(child4)
	child1.AddChild(child5)

	return root
}
