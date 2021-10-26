java_binary(
    name = "LCARunner",
    srcs = ["src/App.java"],
    main_class = "App",
    deps = [":lca"],
)

java_library(
    name = "lca",
    srcs = [
        "src/LCA.java",
        "src/DirectedEdge.java",
        "src/EdgeWeightedDigraph.java",
        ]
)

java_test(
    name = "lca_test",
    srcs = ["tests/LCATest.java"],
    test_class = "LCATest",
    deps = [":lca"]
)