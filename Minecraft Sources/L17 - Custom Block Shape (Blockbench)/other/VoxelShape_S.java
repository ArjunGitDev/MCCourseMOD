Stream.of(
Block.makeCuboidShape(3.552713678800501e-15, 14, 0.17647058823529704, 2, 16, 2.176470588235297),
Block.makeCuboidShape(14, 14, 14.176470588235297, 15.999999999999996, 16, 16.176470588235293),
Block.makeCuboidShape(3.552713678800501e-15, 14, 14.176470588235297, 2, 16, 16.176470588235293),
Block.makeCuboidShape(14, 14, 0.17647058823529704, 15.999999999999996, 16, 2.176470588235297),
Block.makeCuboidShape(1, 2, 1.176470588235297, 15, 14, 15.176470588235297),
Block.makeCuboidShape(3.552713678800501e-15, 0, 0.17647058823529704, 2, 2, 2.176470588235297),
Block.makeCuboidShape(14, 0, 14.176470588235297, 15.999999999999996, 2, 16.176470588235293),
Block.makeCuboidShape(3.552713678800501e-15, 0, 14.176470588235297, 2, 2, 16.176470588235293),
Block.makeCuboidShape(14, 0, 0.17647058823529704, 15.999999999999996, 2, 2.176470588235297),
Block.makeCuboidShape(14, 2, 14.176470588235297, 15.999999999999996, 14, 16.176470588235293),
Block.makeCuboidShape(2, 14, 0.17647058823529704, 14, 15, 1.176470588235297),
Block.makeCuboidShape(3.552713678800501e-15, 14, 2.176470588235297, 1, 15, 14.176470588235297),
Block.makeCuboidShape(15, 14, 2.176470588235297, 15.999999999999996, 15, 14.176470588235297),
Block.makeCuboidShape(2, 14, 14.176470588235297, 14, 16, 16.176470588235293),
Block.makeCuboidShape(3.552713678800501e-15, 2, 14.176470588235297, 2, 14, 16.176470588235293),
Block.makeCuboidShape(15, 2, 0.17647058823529704, 15.999999999999996, 14, 1.176470588235297),
Block.makeCuboidShape(3.552713678800501e-15, 2, 0.17647058823529704, 1, 14, 1.176470588235297)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});