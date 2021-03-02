package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.kinda.R;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class YogaLayout extends ViewGroup {
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutParams layoutParams;
        AppMethodBeat.i(18237);
        this.mYogaNode = YogaNodeFactory.create();
        this.mYogaNodes = new HashMap();
        this.mYogaNode.setData(this);
        this.mYogaNode.setMeasureFunction(new ViewMeasureFunction());
        if (attributeSet != null) {
            layoutParams = new LayoutParams(context, attributeSet);
        } else {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        applyLayoutParams(layoutParams, this.mYogaNode, this);
        AppMethodBeat.o(18237);
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public YogaNode getYogaNodeForView(View view) {
        AppMethodBeat.i(18238);
        YogaNode yogaNode = this.mYogaNodes.get(view);
        AppMethodBeat.o(18238);
        return yogaNode;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        YogaNode create;
        YogaNode yogaNode;
        AppMethodBeat.i(18239);
        this.mYogaNode.setMeasureFunction(null);
        if (view instanceof VirtualYogaLayout) {
            ((VirtualYogaLayout) view).transferChildren(this);
            this.mYogaNode.addChildAt(((VirtualYogaLayout) view).getYogaNode(), this.mYogaNode.getChildCount());
            AppMethodBeat.o(18239);
            return;
        }
        super.addView(view, i2, layoutParams);
        if (this.mYogaNodes.containsKey(view)) {
            AppMethodBeat.o(18239);
            return;
        }
        if (view instanceof YogaLayout) {
            yogaNode = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.mYogaNodes.containsKey(view)) {
                create = this.mYogaNodes.get(view);
            } else {
                create = YogaNodeFactory.create();
            }
            create.setData(view);
            create.setMeasureFunction(new ViewMeasureFunction());
            yogaNode = create;
        }
        applyLayoutParams((LayoutParams) view.getLayoutParams(), yogaNode, view);
        this.mYogaNodes.put(view, yogaNode);
        this.mYogaNode.addChildAt(yogaNode, this.mYogaNode.getChildCount());
        AppMethodBeat.o(18239);
    }

    public void addView(View view, YogaNode yogaNode) {
        AppMethodBeat.i(207061);
        this.mYogaNode.setMeasureFunction(null);
        if (!(view instanceof YogaLayout)) {
            yogaNode.setData(view);
            yogaNode.setMeasureFunction(new ViewMeasureFunction());
        }
        this.mYogaNodes.put(view, yogaNode);
        this.mYogaNode.addChildAt(yogaNode, this.mYogaNode.getChildCount());
        super.addView(view, getChildCount(), new LayoutParams(-1, -1));
        AppMethodBeat.o(207061);
    }

    public void removeView(View view) {
        AppMethodBeat.i(18241);
        removeViewFromYogaTree(view, false);
        super.removeView(view);
        AppMethodBeat.o(18241);
    }

    public void removeViewAt(int i2) {
        AppMethodBeat.i(18242);
        removeViewFromYogaTree(getChildAt(i2), false);
        super.removeViewAt(i2);
        AppMethodBeat.o(18242);
    }

    public void removeViewInLayout(View view) {
        AppMethodBeat.i(18243);
        removeViewFromYogaTree(view, true);
        super.removeViewInLayout(view);
        AppMethodBeat.o(18243);
    }

    public void removeViews(int i2, int i3) {
        AppMethodBeat.i(18244);
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            removeViewFromYogaTree(getChildAt(i4), false);
        }
        super.removeViews(i2, i3);
        AppMethodBeat.o(18244);
    }

    public void removeViewsInLayout(int i2, int i3) {
        AppMethodBeat.i(18245);
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            removeViewFromYogaTree(getChildAt(i4), true);
        }
        super.removeViewsInLayout(i2, i3);
        AppMethodBeat.o(18245);
    }

    public void removeAllViews() {
        AppMethodBeat.i(18246);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            removeViewFromYogaTree(getChildAt(i2), false);
        }
        super.removeAllViews();
        AppMethodBeat.o(18246);
    }

    public void removeAllViewsInLayout() {
        AppMethodBeat.i(18247);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            removeViewFromYogaTree(getChildAt(i2), true);
        }
        super.removeAllViewsInLayout();
        AppMethodBeat.o(18247);
    }

    public void invalidate(View view) {
        AppMethodBeat.i(18248);
        if (this.mYogaNodes.containsKey(view)) {
            this.mYogaNodes.get(view).dirty();
            AppMethodBeat.o(18248);
            return;
        }
        int childCount = this.mYogaNode.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            YogaNode childAt = this.mYogaNode.getChildAt(i2);
            if (childAt.getData() instanceof YogaLayout) {
                ((YogaLayout) childAt.getData()).invalidate(view);
            }
        }
        invalidate();
        AppMethodBeat.o(18248);
    }

    private void removeViewFromYogaTree(View view, boolean z) {
        AppMethodBeat.i(18249);
        YogaNode yogaNode = this.mYogaNodes.get(view);
        if (yogaNode == null) {
            AppMethodBeat.o(18249);
            return;
        }
        YogaNode owner = yogaNode.getOwner();
        int i2 = 0;
        while (true) {
            if (i2 >= owner.getChildCount()) {
                break;
            } else if (owner.getChildAt(i2).equals(yogaNode)) {
                owner.removeChildAt(i2);
                break;
            } else {
                i2++;
            }
        }
        yogaNode.setData(null);
        this.mYogaNodes.remove(view);
        if (z) {
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
        AppMethodBeat.o(18249);
    }

    private void applyLayoutRecursive(YogaNode yogaNode, float f2, float f3) {
        AppMethodBeat.i(18250);
        View view = (View) yogaNode.getData();
        if (!(view == null || view == this)) {
            if (view.getVisibility() == 8) {
                AppMethodBeat.o(18250);
                return;
            }
            int round = Math.round(yogaNode.getLayoutX() + f2);
            int round2 = Math.round(yogaNode.getLayoutY() + f3);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int childCount = yogaNode.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (equals(view)) {
                applyLayoutRecursive(yogaNode.getChildAt(i2), f2, f3);
            } else if (!(view instanceof YogaLayout)) {
                applyLayoutRecursive(yogaNode.getChildAt(i2), yogaNode.getLayoutX() + f2, yogaNode.getLayoutY() + f3);
            }
        }
        AppMethodBeat.o(18250);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(18251);
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - i3, 1073741824));
        }
        applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
        AppMethodBeat.o(18251);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(18252);
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(i2, i3);
        }
        setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
        AppMethodBeat.o(18252);
    }

    private void createLayout(int i2, int i3) {
        AppMethodBeat.i(18253);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == 1073741824) {
            this.mYogaNode.setHeight((float) size2);
        }
        if (mode == 1073741824) {
            this.mYogaNode.setWidth((float) size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxHeight((float) size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxWidth((float) size);
        }
        if (mode2 == 0) {
            this.mYogaNode.setHeightAuto();
        }
        this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        AppMethodBeat.o(18253);
    }

    protected static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view) {
        AppMethodBeat.i(18254);
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            yogaNode.setDirection(YogaDirection.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                yogaNode.setPadding(YogaEdge.LEFT, (float) rect.left);
                yogaNode.setPadding(YogaEdge.TOP, (float) rect.top);
                yogaNode.setPadding(YogaEdge.RIGHT, (float) rect.right);
                yogaNode.setPadding(YogaEdge.BOTTOM, (float) rect.bottom);
            }
        }
        for (int i2 = 0; i2 < layoutParams.numericAttributes.size(); i2++) {
            int keyAt = layoutParams.numericAttributes.keyAt(i2);
            float floatValue = layoutParams.numericAttributes.valueAt(i2).floatValue();
            if (keyAt == 0) {
                yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == 1) {
                yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == 2) {
                yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == 3) {
                yogaNode.setAspectRatio(floatValue);
            } else if (keyAt == 8) {
                yogaNode.setBorder(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 11) {
                yogaNode.setBorder(YogaEdge.TOP, floatValue);
            } else if (keyAt == 9) {
                yogaNode.setBorder(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 5) {
                yogaNode.setBorder(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 10) {
                yogaNode.setBorder(YogaEdge.START, floatValue);
            } else if (keyAt == 6) {
                yogaNode.setBorder(YogaEdge.END, floatValue);
            } else if (keyAt == 7) {
                yogaNode.setBorder(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 12) {
                yogaNode.setBorder(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 4) {
                yogaNode.setBorder(YogaEdge.ALL, floatValue);
            } else if (keyAt == 13) {
                yogaNode.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == 14) {
                yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
            } else if (keyAt == 15) {
                yogaNode.setFlex(floatValue);
            } else if (keyAt == 16) {
                yogaNode.setFlexBasis(floatValue);
            } else if (keyAt == 17) {
                yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == 18) {
                yogaNode.setFlexGrow(floatValue);
            } else if (keyAt == 19) {
                yogaNode.setFlexShrink(floatValue);
            } else if (keyAt == 20) {
                yogaNode.setHeight(floatValue);
            } else if (keyAt == 26) {
                yogaNode.setMargin(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 21) {
                yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
            } else if (keyAt == 29) {
                yogaNode.setMargin(YogaEdge.TOP, floatValue);
            } else if (keyAt == 27) {
                yogaNode.setMargin(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 23) {
                yogaNode.setMargin(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 28) {
                yogaNode.setMargin(YogaEdge.START, floatValue);
            } else if (keyAt == 24) {
                yogaNode.setMargin(YogaEdge.END, floatValue);
            } else if (keyAt == 25) {
                yogaNode.setMargin(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 30) {
                yogaNode.setMargin(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 22) {
                yogaNode.setMargin(YogaEdge.ALL, floatValue);
            } else if (keyAt == 31) {
                yogaNode.setMaxHeight(floatValue);
            } else if (keyAt == 32) {
                yogaNode.setMaxWidth(floatValue);
            } else if (keyAt == 33) {
                yogaNode.setMinHeight(floatValue);
            } else if (keyAt == 34) {
                yogaNode.setMinWidth(floatValue);
            } else if (keyAt == 35) {
                yogaNode.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
            } else if (keyAt == 40) {
                yogaNode.setPadding(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 43) {
                yogaNode.setPadding(YogaEdge.TOP, floatValue);
            } else if (keyAt == 41) {
                yogaNode.setPadding(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 37) {
                yogaNode.setPadding(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 42) {
                yogaNode.setPadding(YogaEdge.START, floatValue);
            } else if (keyAt == 38) {
                yogaNode.setPadding(YogaEdge.END, floatValue);
            } else if (keyAt == 39) {
                yogaNode.setPadding(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 44) {
                yogaNode.setPadding(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 36) {
                yogaNode.setPadding(YogaEdge.ALL, floatValue);
            } else if (keyAt == 49) {
                yogaNode.setPosition(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 52) {
                yogaNode.setPosition(YogaEdge.TOP, floatValue);
            } else if (keyAt == 50) {
                yogaNode.setPosition(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 46) {
                yogaNode.setPosition(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 51) {
                yogaNode.setPosition(YogaEdge.START, floatValue);
            } else if (keyAt == 47) {
                yogaNode.setPosition(YogaEdge.END, floatValue);
            } else if (keyAt == 48) {
                yogaNode.setPosition(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 54) {
                yogaNode.setPosition(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 45) {
                yogaNode.setPosition(YogaEdge.ALL, floatValue);
            } else if (keyAt == 53) {
                yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
            } else if (keyAt == 55) {
                yogaNode.setWidth(floatValue);
            } else if (keyAt == 56) {
                yogaNode.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
            }
        }
        for (int i3 = 0; i3 < layoutParams.stringAttributes.size(); i3++) {
            int keyAt2 = layoutParams.stringAttributes.keyAt(i3);
            String valueAt = layoutParams.stringAttributes.valueAt(i3);
            if (valueAt.equals("auto")) {
                if (keyAt2 == 26) {
                    yogaNode.setMarginAuto(YogaEdge.LEFT);
                } else if (keyAt2 == 29) {
                    yogaNode.setMarginAuto(YogaEdge.TOP);
                } else if (keyAt2 == 27) {
                    yogaNode.setMarginAuto(YogaEdge.RIGHT);
                } else if (keyAt2 == 23) {
                    yogaNode.setMarginAuto(YogaEdge.BOTTOM);
                } else if (keyAt2 == 28) {
                    yogaNode.setMarginAuto(YogaEdge.START);
                } else if (keyAt2 == 24) {
                    yogaNode.setMarginAuto(YogaEdge.END);
                } else if (keyAt2 == 25) {
                    yogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
                } else if (keyAt2 == 30) {
                    yogaNode.setMarginAuto(YogaEdge.VERTICAL);
                } else if (keyAt2 == 22) {
                    yogaNode.setMarginAuto(YogaEdge.ALL);
                }
            }
            if (valueAt.endsWith("%")) {
                float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                if (keyAt2 == 16) {
                    yogaNode.setFlexBasisPercent(parseFloat);
                } else if (keyAt2 == 20) {
                    yogaNode.setHeightPercent(parseFloat);
                } else if (keyAt2 == 26) {
                    yogaNode.setMarginPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 29) {
                    yogaNode.setMarginPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 27) {
                    yogaNode.setMarginPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 23) {
                    yogaNode.setMarginPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 28) {
                    yogaNode.setMarginPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 24) {
                    yogaNode.setMarginPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 25) {
                    yogaNode.setMarginPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 30) {
                    yogaNode.setMarginPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 22) {
                    yogaNode.setMarginPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 31) {
                    yogaNode.setMaxHeightPercent(parseFloat);
                } else if (keyAt2 == 32) {
                    yogaNode.setMaxWidthPercent(parseFloat);
                } else if (keyAt2 == 33) {
                    yogaNode.setMinHeightPercent(parseFloat);
                } else if (keyAt2 == 34) {
                    yogaNode.setMinWidthPercent(parseFloat);
                } else if (keyAt2 == 40) {
                    yogaNode.setPaddingPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 43) {
                    yogaNode.setPaddingPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 41) {
                    yogaNode.setPaddingPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 37) {
                    yogaNode.setPaddingPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 42) {
                    yogaNode.setPaddingPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 38) {
                    yogaNode.setPaddingPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 39) {
                    yogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 44) {
                    yogaNode.setPaddingPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 36) {
                    yogaNode.setPaddingPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 49) {
                    yogaNode.setPositionPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 52) {
                    yogaNode.setPositionPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 50) {
                    yogaNode.setPositionPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 46) {
                    yogaNode.setPositionPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 51) {
                    yogaNode.setPositionPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 47) {
                    yogaNode.setPositionPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 48) {
                    yogaNode.setPositionPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 54) {
                    yogaNode.setPositionPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 45) {
                    yogaNode.setPositionPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 55) {
                    yogaNode.setWidthPercent(parseFloat);
                }
            }
        }
        AppMethodBeat.o(18254);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(18255);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(18255);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(18256);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        AppMethodBeat.o(18256);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(18257);
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        AppMethodBeat.o(18257);
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        SparseArray<Float> numericAttributes;
        SparseArray<String> stringAttributes;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            AppMethodBeat.i(18233);
            if (layoutParams instanceof LayoutParams) {
                this.numericAttributes = ((LayoutParams) layoutParams).numericAttributes.clone();
                this.stringAttributes = ((LayoutParams) layoutParams).stringAttributes.clone();
                AppMethodBeat.o(18233);
                return;
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) this.width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) this.height));
            }
            AppMethodBeat.o(18233);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            AppMethodBeat.i(18234);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i2 >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) i2));
            }
            if (i3 >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) i3));
            }
            AppMethodBeat.o(18234);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(18235);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.yoga);
            if (this.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) this.width));
            }
            if (this.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) this.height));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                if (typedValue.type == 5) {
                    this.numericAttributes.put(index, Float.valueOf((float) obtainStyledAttributes.getDimensionPixelSize(index, 0)));
                } else if (typedValue.type == 3) {
                    this.stringAttributes.put(index, obtainStyledAttributes.getString(index));
                } else {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getFloat(index, 0.0f)));
                }
            }
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(18235);
        }
    }

    public static class ViewMeasureFunction implements YogaMeasureFunction {
        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            AppMethodBeat.i(18236);
            View view = (View) yogaNode.getData();
            if (view == null || (view instanceof YogaLayout)) {
                long make = YogaMeasureOutput.make(0, 0);
                AppMethodBeat.o(18236);
                return make;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f3, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
            long make2 = YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
            AppMethodBeat.o(18236);
            return make2;
        }

        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                return 1073741824;
            }
            return 0;
        }
    }
}
