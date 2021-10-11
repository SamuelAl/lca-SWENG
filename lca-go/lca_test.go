package main

import "testing"

func TestSingleNodeTree(t *testing.T) {
	root := NewTreeNode(0)
	want := root.value
	if got := FindLCA(root, 0, 0).node.value; got != 0 {
		t.Fatalf("FindLCA(%v, %d, %d): got = %d, want = %d", root, 0, 0, got, want)
	}
}

func TestMultiNodeTree(t *testing.T) {
	root := createSampleTree()

	tests := []struct {
		name    string
		nodeA   int
		nodeB   int
		wantLCA int
	}{
		{
			name:    "Root is LCA of itself and descendant",
			nodeA:   0,
			nodeB:   1,
			wantLCA: 0,
		},
		{
			name:    "Root is LCA of direct descendants",
			nodeA:   2,
			nodeB:   1,
			wantLCA: 0,
		},
		{
			name:    "1 is LCA of direct descendants",
			nodeA:   3,
			nodeB:   5,
			wantLCA: 1,
		},
		{
			name:    "1 is LCA of itseld and descendant",
			nodeA:   1,
			nodeB:   5,
			wantLCA: 1,
		},
	}

	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			if got := FindLCA(root, test.nodeA, test.nodeB).node.value; got != test.wantLCA {
				t.Fatalf("FindLCA(%v, %d, %d): got = %d, want = %d", root, test.nodeA, test.nodeB, got, test.wantLCA)
			}
		})
	}
}

func TestDegenerateTree(t *testing.T) {
	root := createDegenerateTree()

	tests := []struct {
		name    string
		nodeA   int
		nodeB   int
		wantLCA int
	}{
		{
			name:    "Root is LCA of itself and descendant",
			nodeA:   0,
			nodeB:   1,
			wantLCA: 0,
		},
		{
			name:    "Root is LCA of itself and descendants",
			nodeA:   2,
			nodeB:   0,
			wantLCA: 0,
		},
		{
			name:    "1 is LCA of itself and direct descendant",
			nodeA:   1,
			nodeB:   2,
			wantLCA: 1,
		},
	}

	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			if got := FindLCA(root, test.nodeA, test.nodeB).node.value; got != test.wantLCA {
				t.Fatalf("FindLCA(%v, %d, %d): got = %d, want = %d", root, test.nodeA, test.nodeB, got, test.wantLCA)
			}
		})
	}
}

func createDegenerateTree() *TreeNode {
	root := NewTreeNode(0)
	child1 := NewTreeNode(1)
	child2 := NewTreeNode(2)

	root.AddChild(child1)
	child1.AddChild(child2)

	return root
}
