// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class TestEntity extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer legBackRight;
	private final ModelRenderer legBackLeft;

	public TestEntity() {
		textureWidth = 71;
		textureHeight = 45;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 3.0F, -4.0F);
		head.setTextureOffset(1, 2).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(26, 3).addBox(3.0F, -6.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(26, 2).addBox(-4.0F, -6.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 1.5F);
		body.setTextureOffset(0, 28).addBox(-5.0F, -22.0F, -7.5F, 10.0F, 10.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(30, 10).addBox(-4.0F, -21.0F, -5.5F, 8.0F, 8.0F, 12.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-3.0F, 12.5F, -4.0F);
		legFrontRight.setTextureOffset(63, 32).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(3.0F, 12.5F, -4.0F);
		legFrontLeft.setTextureOffset(63, 32).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-3.0F, 11.0F, 7.0F);
		legBackRight.setTextureOffset(63, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(3.0F, 11.0F, 7.0F);
		legBackLeft.setTextureOffset(63, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}