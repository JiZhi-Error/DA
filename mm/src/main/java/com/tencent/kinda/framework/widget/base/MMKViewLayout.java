package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewLayout;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class MMKViewLayout<Layout extends ViewGroup> extends MMKView<Layout> implements KViewLayout {
    protected static final String TAG = "MMKViewLayout";
    public ArrayList<MMKView> childList = new ArrayList<>();

    public MMKViewLayout() {
        AppMethodBeat.i(19265);
        AppMethodBeat.o(19265);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public Layout createView(Context context) {
        AppMethodBeat.i(19266);
        YogaLayout yogaLayout = new YogaLayout(context);
        this.flexAttr.setYogaNode(yogaLayout.getYogaNode());
        AppMethodBeat.o(19266);
        return yogaLayout;
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void addView(KView kView) {
        AppMethodBeat.i(19267);
        addView(kView, node().getChildCount());
        AppMethodBeat.o(19267);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void addView(KView kView, int i2) {
        AppMethodBeat.i(19268);
        if (getView() != null) {
            KView unWrapRealObj = KindaAnimatorViewProxy.unWrapRealObj(kView);
            if (unWrapRealObj instanceof MMKView) {
                Log.printDebugStack(TAG, "%s addview this %s | child %s | childparent %s | childCount: %s", this, getView(), ((MMKView) unWrapRealObj).getView(), ((MMKView) unWrapRealObj).getView().getParent(), Integer.valueOf(this.childList.size()));
                if (getView() instanceof YogaLayout) {
                    ((YogaLayout) getView()).addView(((MMKView) unWrapRealObj).getView(), ((MMKView) unWrapRealObj).node());
                } else {
                    ((ViewGroup) getView()).addView(((MMKView) unWrapRealObj).getView());
                }
                this.childList.add((MMKView) unWrapRealObj);
                AppMethodBeat.o(19268);
                return;
            }
            Log.e(TAG, "error error %s child %s %s", getView(), unWrapRealObj, Boolean.valueOf(unWrapRealObj instanceof MMKView));
        }
        AppMethodBeat.o(19268);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void removeView(KView kView) {
        AppMethodBeat.i(19269);
        if (getView() != null && (kView instanceof MMKView)) {
            ((ViewGroup) getView()).removeView(((MMKView) kView).getView());
            this.childList.remove(kView);
        }
        AppMethodBeat.o(19269);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void removeAllViews() {
        AppMethodBeat.i(19270);
        ((ViewGroup) getView()).removeAllViews();
        AppMethodBeat.o(19270);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.i(214568);
        ((ViewGroup) getView()).setFocusable(true);
        ((ViewGroup) getView()).setFocusableInTouchMode(true);
        AppMethodBeat.o(214568);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setFlexDirection(FlexDirection flexDirection) {
        AppMethodBeat.i(19271);
        this.flexAttr.setFlexDirection(flexDirection);
        AppMethodBeat.o(19271);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public FlexDirection getFlexDirection() {
        AppMethodBeat.i(19272);
        FlexDirection flexDirection = this.flexAttr.getFlexDirection();
        AppMethodBeat.o(19272);
        return flexDirection;
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setJustifyContent(Justify justify) {
        AppMethodBeat.i(19273);
        this.flexAttr.setJustifyContent(justify);
        AppMethodBeat.o(19273);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public Justify getJustifyContent() {
        AppMethodBeat.i(19274);
        Justify justifyContent = this.flexAttr.getJustifyContent();
        AppMethodBeat.o(19274);
        return justifyContent;
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setFlexWrap(Wrap wrap) {
        AppMethodBeat.i(19275);
        this.flexAttr.setFlexWrap(wrap);
        AppMethodBeat.o(19275);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public Wrap getFlexWrap() {
        AppMethodBeat.i(19276);
        Wrap flexWrap = this.flexAttr.getFlexWrap();
        AppMethodBeat.o(19276);
        return flexWrap;
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setAlignItems(Align align) {
        AppMethodBeat.i(19277);
        this.flexAttr.setAlignItems(align);
        AppMethodBeat.o(19277);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public Align getAlignItems() {
        AppMethodBeat.i(19278);
        Align alignItems = this.flexAttr.getAlignItems();
        AppMethodBeat.o(19278);
        return alignItems;
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public void setAlignContent(Align align) {
        AppMethodBeat.i(19279);
        this.flexAttr.setAlignContent(align);
        AppMethodBeat.o(19279);
    }

    @Override // com.tencent.kinda.gen.KViewLayout
    public Align getAlignContent() {
        AppMethodBeat.i(19280);
        Align alignContent = this.flexAttr.getAlignContent();
        AppMethodBeat.o(19280);
        return alignContent;
    }
}
