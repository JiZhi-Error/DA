package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VirtualYogaLayout extends ViewGroup {
    private final List<View> mChildren;
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public VirtualYogaLayout(Context context) {
        super(context);
        AppMethodBeat.i(18223);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = YogaNodeFactory.create();
        AppMethodBeat.o(18223);
    }

    public VirtualYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VirtualYogaLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(18224);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = YogaNodeFactory.create();
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(context, attributeSet), this.mYogaNode, this);
        AppMethodBeat.o(18224);
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(18225);
        if (view instanceof VirtualYogaLayout) {
            ((VirtualYogaLayout) view).transferChildren(this);
            this.mYogaNode.addChildAt(((VirtualYogaLayout) view).getYogaNode(), this.mYogaNode.getChildCount());
            AppMethodBeat.o(18225);
            return;
        }
        YogaNode create = YogaNodeFactory.create();
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(layoutParams), create, view);
        create.setData(view);
        create.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
        this.mYogaNode.addChildAt(create, this.mYogaNode.getChildCount());
        addView(view, create);
        AppMethodBeat.o(18225);
    }

    public void addView(View view, YogaNode yogaNode) {
        AppMethodBeat.i(18226);
        this.mChildren.add(view);
        this.mYogaNodes.put(view, yogaNode);
        AppMethodBeat.o(18226);
    }

    /* access modifiers changed from: protected */
    public void transferChildren(ViewGroup viewGroup) {
        AppMethodBeat.i(18227);
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.mChildren) {
                ((VirtualYogaLayout) viewGroup).addView(view, this.mYogaNodes.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.mChildren) {
                ((YogaLayout) viewGroup).addView(view2, this.mYogaNodes.get(view2));
            }
        } else {
            RuntimeException runtimeException = new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
            AppMethodBeat.o(18227);
            throw runtimeException;
        }
        this.mChildren.clear();
        AppMethodBeat.o(18227);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(18228);
        RuntimeException runtimeException = new RuntimeException("Attempting to layout a VirtualYogaLayout");
        AppMethodBeat.o(18228);
        throw runtimeException;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(18229);
        YogaLayout.LayoutParams layoutParams = new YogaLayout.LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(18229);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(18230);
        YogaLayout.LayoutParams layoutParams = new YogaLayout.LayoutParams(-1, -1);
        AppMethodBeat.o(18230);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(18231);
        YogaLayout.LayoutParams layoutParams2 = new YogaLayout.LayoutParams(layoutParams);
        AppMethodBeat.o(18231);
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.LayoutParams;
    }
}
