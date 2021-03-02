package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KScrollView;
import com.tencent.kinda.gen.KScrollViewOnScrollCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.MMScrollView;

public class MMKScrollView extends MMKViewLayout<MMScrollView> implements KScrollView {
    @Override // com.tencent.kinda.framework.widget.base.MMKViewLayout, com.tencent.kinda.framework.widget.base.MMKViewLayout, com.tencent.kinda.framework.widget.base.MMKView
    public MMScrollView createView(Context context) {
        AppMethodBeat.i(19113);
        MMScrollView mMScrollView = new MMScrollView(context);
        mMScrollView.setOverScrollMode(2);
        mMScrollView.setFillViewport(true);
        AppMethodBeat.o(19113);
        return mMScrollView;
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void scrollTo(KView kView) {
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setContent(KView kView) {
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setContentInsect(float f2, float f3, float f4, float f5) {
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setVertical(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public boolean getVertical() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setShowScrollBar(boolean z) {
        AppMethodBeat.i(19114);
        ((MMScrollView) getView()).setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(19114);
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public boolean getShowScrollBar() {
        AppMethodBeat.i(19115);
        boolean isVerticalScrollBarEnabled = ((MMScrollView) getView()).isVerticalScrollBarEnabled();
        AppMethodBeat.o(19115);
        return isVerticalScrollBarEnabled;
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setOnScrollCallback(final KScrollViewOnScrollCallback kScrollViewOnScrollCallback) {
        AppMethodBeat.i(19116);
        if (kScrollViewOnScrollCallback != null) {
            ((MMScrollView) getView()).setOnScrollListener(new MMScrollView.a() {
                /* class com.tencent.kinda.framework.widget.base.MMKScrollView.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.ui.MMScrollView.a
                public void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(19112);
                    kScrollViewOnScrollCallback.onScroll((float) i2, (float) i3);
                    AppMethodBeat.o(19112);
                }
            });
        }
        AppMethodBeat.o(19116);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKViewLayout, com.tencent.kinda.gen.KViewLayout
    public void addView(KView kView, int i2) {
        AppMethodBeat.i(19117);
        if (kView instanceof MMKViewLayout) {
            Log.printDebugStack("MMKViewLayout", "%s addView: %s, childCount: %s %s", this, kView, Integer.valueOf(((MMKViewLayout) kView).childList.size()), Integer.valueOf(this.childList.size()));
        } else {
            Log.printDebugStack("MMKViewLayout", "%s addView: %s, childCount: %s", this, kView, Integer.valueOf(this.childList.size()));
        }
        this.childList.add((MMKView) kView);
        ((MMScrollView) getView()).addView(((MMKView) kView).getView());
        float marginLeft = kView.getMarginLeft();
        float marginRight = kView.getMarginRight();
        float marginTop = kView.getMarginTop();
        float marginBottom = kView.getMarginBottom();
        if (((MMKView) kView).getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((MMKView) kView).getView().getLayoutParams();
            marginLayoutParams.topMargin = (int) MMKViewUtil.dpToPx(this.mContext, marginTop);
            marginLayoutParams.bottomMargin = (int) MMKViewUtil.dpToPx(this.mContext, marginBottom);
            marginLayoutParams.leftMargin = (int) MMKViewUtil.dpToPx(this.mContext, marginLeft);
            marginLayoutParams.rightMargin = (int) MMKViewUtil.dpToPx(this.mContext, marginRight);
            ((MMKView) kView).getView().setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(19117);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKViewLayout, com.tencent.kinda.gen.KViewLayout
    public void removeView(KView kView) {
        AppMethodBeat.i(19118);
        this.childList.remove(((MMKView) kView).getView());
        ((MMScrollView) getView()).removeView(((MMKView) kView).getView());
        AppMethodBeat.o(19118);
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setScrollToDimissKeyboardEnabled(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public boolean getScrollToDimissKeyboardEnabled() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public KPoint getContentOffset() {
        AppMethodBeat.i(214561);
        int E = a.E(((MMScrollView) getView()).getContext(), ((MMScrollView) getView()).getScrollX());
        int E2 = a.E(((MMScrollView) getView()).getContext(), ((MMScrollView) getView()).getScrollY());
        KPoint kPoint = new KPoint((float) E, (float) E2);
        Log.printDebugStack("MMKViewLayout", "getContentOffset  X: %s, Y: %s", Integer.valueOf(E), Integer.valueOf(E2));
        AppMethodBeat.o(214561);
        return kPoint;
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setContentOffset(KPoint kPoint) {
        AppMethodBeat.i(214562);
        final int dpToPx = (int) MMKViewUtil.dpToPx(((MMScrollView) getView()).getContext(), (float) ((int) kPoint.getX()));
        final int dpToPx2 = (int) MMKViewUtil.dpToPx(((MMScrollView) getView()).getContext(), (float) ((int) kPoint.getY()));
        ((MMScrollView) getView()).postDelayed(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.MMKScrollView.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(214560);
                ((MMScrollView) MMKScrollView.this.getView()).scrollBy(dpToPx, dpToPx2);
                AppMethodBeat.o(214560);
            }
        }, 150);
        Log.printDebugStack("MMKViewLayout", "setContentOffset  X: %s, Y: %s", Integer.valueOf(dpToPx), Integer.valueOf(dpToPx2));
        AppMethodBeat.o(214562);
    }

    @Override // com.tencent.kinda.gen.KScrollView
    public void setContentOffset(KPoint kPoint, boolean z) {
        AppMethodBeat.i(214563);
        setContentOffset(kPoint);
        AppMethodBeat.o(214563);
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public float getHeight() {
        AppMethodBeat.i(214564);
        if (KindaContext.get() != null) {
            DisplayMetrics displayMetrics = KindaContext.get().getResources().getDisplayMetrics();
            int pxToDp = (int) MMKViewUtil.pxToDp(((MMScrollView) getView()).getContext(), (float) ((MMScrollView) getView()).getHeight());
            int pxToDp2 = (int) MMKViewUtil.pxToDp(((MMScrollView) getView()).getContext(), (float) displayMetrics.heightPixels);
            Log.printDebugStack("MMKViewLayout", "getView() - %s scroolviewheight: %s,screenheight: %s", this, Integer.valueOf(pxToDp), Integer.valueOf(pxToDp2));
            float min = (float) Math.min(pxToDp, pxToDp2);
            AppMethodBeat.o(214564);
            return min;
        }
        AppMethodBeat.o(214564);
        return 0.0f;
    }
}
