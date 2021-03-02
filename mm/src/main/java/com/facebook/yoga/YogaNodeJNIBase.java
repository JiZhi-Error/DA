package com.facebook.yoga;

import java.util.ArrayList;
import java.util.List;

public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private static final byte BORDER = 4;
    private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;
    private float[] arr;
    private YogaBaselineFunction mBaselineFunction;
    private List<YogaNodeJNIBase> mChildren;
    private Object mData;
    private boolean mHasNewLayout;
    private int mLayoutDirection;
    private YogaMeasureFunction mMeasureFunction;
    protected long mNativePointer;
    private YogaNodeJNIBase mOwner;

    private YogaNodeJNIBase(long j2) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j2 == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.mNativePointer = j2;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    YogaNodeJNIBase(YogaConfig yogaConfig) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) yogaConfig).mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public int getChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        return this.mChildren.size();
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getChildAt(int i2) {
        if (this.mChildren != null) {
            return this.mChildren.get(i2);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.facebook.yoga.YogaNode
    public void addChildAt(YogaNode yogaNode, int i2) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        if (yogaNodeJNIBase.mOwner != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(4);
        }
        this.mChildren.add(i2, yogaNodeJNIBase);
        yogaNodeJNIBase.mOwner = this;
        YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setIsReferenceBaseline(boolean z) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, z);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
    }

    public void swapChildAt(YogaNode yogaNode, int i2) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        this.mChildren.remove(i2);
        this.mChildren.add(i2, yogaNodeJNIBase);
        yogaNodeJNIBase.mOwner = this;
        YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            for (int i2 = 0; i2 < yogaNodeJNIBase.getChildCount(); i2++) {
                yogaNodeJNIBase.swapChildAt(yogaNodeJNIBase.getChildAt(i2).cloneWithChildren(), i2);
            }
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeClearChildrenJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase removeChildAt(int i2) {
        if (this.mChildren == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase remove = this.mChildren.remove(i2);
        remove.mOwner = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, remove.mNativePointer);
        return remove;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Override // com.facebook.yoga.YogaNode
    @Deprecated
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    @Override // com.facebook.yoga.YogaNode
    public int indexOf(YogaNode yogaNode) {
        if (this.mChildren == null) {
            return -1;
        }
        return this.mChildren.indexOf(yogaNode);
    }

    @Override // com.facebook.yoga.YogaNode
    public void calculateLayout(float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i2)).mChildren;
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i3 = 0; i3 < yogaNodeJNIBaseArr.length; i3++) {
            jArr[i3] = yogaNodeJNIBaseArr[i3].mNativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, f2, f3, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.facebook.yoga.YogaNode
    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
    }

    public void dirtyAllDescendants() {
        YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void copyStyle(YogaNode yogaNode) {
        YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase) yogaNode).mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setDirection(YogaDirection yogaDirection) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, yogaDirection.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, yogaFlexDirection.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setJustifyContent(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, yogaJustify.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAlignItems(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAlignSelf(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAlignContent(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPositionType(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, yogaPositionType.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaWrap getWrap() {
        return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setWrap(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, yogaWrap.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setOverflow(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, yogaOverflow.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setDisplay(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, yogaDisplay.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlex(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexGrow(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexShrink(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexBasis(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexBasisPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getMargin(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMargin(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMarginPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMarginAuto(YogaEdge yogaEdge) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, yogaEdge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getPadding(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPadding(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPaddingPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public float getBorder(YogaEdge yogaEdge) {
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, yogaEdge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setBorder(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getPosition(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPosition(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPositionPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMinWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMinWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMinHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMinHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMaxWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMaxWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMaxHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMaxHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAspectRatio(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        this.mMeasureFunction = yogaMeasureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.mNativePointer, yogaMeasureFunction != null);
    }

    public final long measure(float f2, int i2, float f3, int i3) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f2, YogaMeasureMode.fromInt(i2), f3, YogaMeasureMode.fromInt(i3));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.facebook.yoga.YogaNode
    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.mBaselineFunction = yogaBaselineFunction;
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(this.mNativePointer, yogaBaselineFunction != null);
    }

    public final float baseline(float f2, float f3) {
        return this.mBaselineFunction.baseline(this, f2, f3);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isMeasureDefined() {
        return this.mMeasureFunction != null;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isBaselineDefined() {
        return this.mBaselineFunction != null;
    }

    @Override // com.facebook.yoga.YogaNode
    public void setData(Object obj) {
        this.mData = obj;
    }

    @Override // com.facebook.yoga.YogaNode
    public Object getData() {
        return this.mData;
    }

    @Override // com.facebook.yoga.YogaNode
    public void print() {
        YogaNative.jni_YGNodePrintJNI(this.mNativePointer);
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        if (this.mChildren == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        this.mChildren.remove(i2);
        this.mChildren.add(i2, yogaNodeJNIBase);
        yogaNodeJNIBase.mOwner = this;
        return yogaNodeJNIBase.mNativePointer;
    }

    private static YogaValue valueFromLong(long j2) {
        return new YogaValue(Float.intBitsToFloat((int) j2), (int) (j2 >> 32));
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutX() {
        if (this.arr != null) {
            return this.arr[3];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutY() {
        if (this.arr != null) {
            return this.arr[4];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutWidth() {
        if (this.arr != null) {
            return this.arr[1];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutHeight() {
        if (this.arr != null) {
            return this.arr[2];
        }
        return 0.0f;
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        return this.arr != null && (((int) this.arr[0]) & 8) == 8;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutMargin(YogaEdge yogaEdge) {
        if (this.arr == null || (((int) this.arr[0]) & 1) != 1) {
            return 0.0f;
        }
        switch (yogaEdge) {
            case LEFT:
                return this.arr[6];
            case TOP:
                return this.arr[7];
            case RIGHT:
                return this.arr[8];
            case BOTTOM:
                return this.arr[9];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[8] : this.arr[6];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[6] : this.arr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutPadding(YogaEdge yogaEdge) {
        int i2 = 0;
        if (this.arr == null || (((int) this.arr[0]) & 2) != 2) {
            return 0.0f;
        }
        if ((((int) this.arr[0]) & 1) != 1) {
            i2 = 4;
        }
        int i3 = 10 - i2;
        switch (yogaEdge) {
            case LEFT:
                return this.arr[i3];
            case TOP:
                return this.arr[i3 + 1];
            case RIGHT:
                return this.arr[i3 + 2];
            case BOTTOM:
                return this.arr[i3 + 3];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i3 + 2] : this.arr[i3];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i3] : this.arr[i3 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutBorder(YogaEdge yogaEdge) {
        int i2 = 0;
        if (this.arr == null || (((int) this.arr[0]) & 4) != 4) {
            return 0.0f;
        }
        int i3 = 14 - ((((int) this.arr[0]) & 1) == 1 ? 0 : 4);
        if ((((int) this.arr[0]) & 2) != 2) {
            i2 = 4;
        }
        int i4 = i3 - i2;
        switch (yogaEdge) {
            case LEFT:
                return this.arr[i4];
            case TOP:
                return this.arr[i4 + 1];
            case RIGHT:
                return this.arr[i4 + 2];
            case BOTTOM:
                return this.arr[i4 + 3];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i4 + 2] : this.arr[i4];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i4] : this.arr[i4 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        return YogaDirection.fromInt(this.arr != null ? (int) this.arr[5] : this.mLayoutDirection);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean hasNewLayout() {
        if (this.arr == null) {
            return this.mHasNewLayout;
        }
        if ((((int) this.arr[0]) & 16) == 16) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.yoga.YogaNode
    public void markLayoutSeen() {
        if (this.arr != null) {
            this.arr[0] = (float) (((int) this.arr[0]) & -17);
        }
        this.mHasNewLayout = false;
    }
}
