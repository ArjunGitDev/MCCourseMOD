Stream.of(
Block.makeCuboidShape(13.911764705882351, 14, 0.08823529411765207, 15.911764705882351, 16, 2.0882352941176485),
Block.makeCuboidShape(-0.08823529411764497, 14, 14.088235294117649, 1.9117647058823515, 16, 16.088235294117645),
Block.makeCuboidShape(-0.08823529411764497, 14, 0.08823529411765207, 1.9117647058823515, 16, 2.0882352941176485),
Block.makeCuboidShape(13.911764705882351, 14, 14.088235294117649, 15.911764705882351, 16, 16.088235294117645),
Block.makeCuboidShape(0.9117647058823515, 2, 1.0882352941176485, 14.911764705882351, 14, 15.088235294117649),
Block.makeCuboidShape(13.911764705882351, 0, 0.08823529411765207, 15.911764705882351, 2, 2.0882352941176485),
Block.makeCuboidShape(-0.08823529411764497, 0, 14.088235294117649, 1.9117647058823515, 2, 16.088235294117645),
Block.makeCuboidShape(-0.08823529411764497, 0, 0.08823529411765207, 1.9117647058823515, 2, 2.0882352941176485),
Block.makeCuboidShape(13.911764705882351, 0, 14.088235294117649, 15.911764705882351, 2, 16.088235294117645),
Block.makeCuboidShape(-0.08823529411764497, 2, 14.088235294117649, 1.9117647058823515, 14, 16.088235294117645),
Block.makeCuboidShape(14.911764705882351, 14, 2.0882352941176485, 15.911764705882351, 15, 14.088235294117649),
Block.makeCuboidShape(1.9117647058823515, 14, 0.08823529411765207, 13.911764705882351, 15, 1.0882352941176485),
Block.makeCuboidShape(1.9117647058823515, 14, 15.088235294117649, 13.911764705882351, 15, 16.088235294117645),
Block.makeCuboidShape(-0.08823529411764497, 14, 2.0882352941176485, 1.9117647058823515, 16, 14.088235294117649),
Block.makeCuboidShape(-0.08823529411764497, 2, 0.08823529411765207, 1.9117647058823515, 14, 2.0882352941176485),
Block.makeCuboidShape(14.911764705882351, 2, 15.088235294117649, 15.911764705882351, 14, 16.088235294117645),
Block.makeCuboidShape(14.911764705882351, 2, 0.08823529411765207, 15.911764705882351, 14, 1.0882352941176485)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});