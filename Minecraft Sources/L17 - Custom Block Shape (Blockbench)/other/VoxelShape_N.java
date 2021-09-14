Stream.of(
Block.makeCuboidShape(14, 14, 14, 15.999999999999998, 16, 16),
Block.makeCuboidShape(1.7763568394002505e-15, 14, 3.552713678800501e-15, 2, 16, 2),
Block.makeCuboidShape(14, 14, 3.552713678800501e-15, 15.999999999999998, 16, 2),
Block.makeCuboidShape(1.7763568394002505e-15, 14, 14, 2, 16, 16),
Block.makeCuboidShape(1, 2, 1, 15, 14, 15),
Block.makeCuboidShape(14, 0, 14, 15.999999999999998, 2, 16),
Block.makeCuboidShape(1.7763568394002505e-15, 0, 3.552713678800501e-15, 2, 2, 2),
Block.makeCuboidShape(14, 0, 3.552713678800501e-15, 15.999999999999998, 2, 2),
Block.makeCuboidShape(1.7763568394002505e-15, 0, 14, 2, 2, 16),
Block.makeCuboidShape(1.7763568394002505e-15, 2, 3.552713678800501e-15, 2, 14, 2),
Block.makeCuboidShape(2, 14, 15, 14, 15, 16),
Block.makeCuboidShape(15, 14, 2, 15.999999999999998, 15, 14),
Block.makeCuboidShape(1.7763568394002505e-15, 14, 2, 1, 15, 14),
Block.makeCuboidShape(2, 14, 3.552713678800501e-15, 14, 16, 2),
Block.makeCuboidShape(14, 2, 3.552713678800501e-15, 15.999999999999998, 14, 2),
Block.makeCuboidShape(1.7763568394002505e-15, 2, 15, 1, 14, 16),
Block.makeCuboidShape(15, 2, 15, 15.999999999999998, 14, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});