package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class MailMMWebView extends MMWebViewWithJsApi implements h {
    private View DeR;
    private boolean JAg;
    private View JAh;
    private boolean JAi;
    private boolean JAj;
    private float deo;
    private float dep;

    public static /* synthetic */ void bQ(Context context) {
        AppMethodBeat.i(82286);
        kI(context);
        AppMethodBeat.o(82286);
    }

    public MailMMWebView(Context context) {
        this(context, null, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(82270);
        this.JAg = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(82270);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public final boolean gik() {
        return this.JAg;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public final void gil() {
        this.JAg = false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(82271);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.deo = x;
                this.dep = y;
                if (this.JAh == null || ((int) this.dep) >= getVisibleTitleBarHeight()) {
                    if (this.DeR != null && this.DeR.getVisibility() == 0 && this.dep + ((float) getBottomHeight()) > ((float) getHeight())) {
                        this.JAj = true;
                        break;
                    }
                } else {
                    this.JAi = true;
                    break;
                }
                break;
            case 2:
                if (Math.abs(y - this.dep) > 50.0f && this.JAi) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.deo, this.dep + ((float) webScrollY));
                    this.JAh.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.deo, this.dep);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.JAi && this.JAh != null) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            boolean dispatchTouchEvent = this.JAh.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(82271);
            return dispatchTouchEvent;
        } else if (!this.JAj || this.DeR == null) {
            boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(82271);
            return dispatchTouchEvent2;
        } else {
            motionEvent.setLocation(x, (y + ((float) getBottomHeight())) - ((float) getHeight()));
            boolean dispatchTouchEvent3 = this.DeR.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(82271);
            return dispatchTouchEvent3;
        }
    }

    @Override // com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView
    public void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(82272);
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i3;
        super.onWebViewScrollChanged(i2, i3, i4, i5);
        invalidate();
        if (contentHeight - height < getBottomHeight()) {
            if (Math.abs(contentHeight - height) > 20) {
                gin();
                zu(false);
            } else {
                zu(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            gim();
        }
        AppMethodBeat.o(82272);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public void setEmbeddedTitleBarCompat(View view) {
        AppMethodBeat.i(82273);
        setEmbeddedTitleBarSinceJellyBean(view);
        AppMethodBeat.o(82273);
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(82274);
        int viewHeightWithTitleBar = getViewHeightWithTitleBar() - getVisibleTitleBarHeight();
        AppMethodBeat.o(82274);
        return viewHeightWithTitleBar;
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.i(82275);
        int max = Math.max(getWebScrollY() - getTitleHeight(), 0);
        AppMethodBeat.o(82275);
        return max;
    }

    public int getVisibleTitleBarHeight() {
        AppMethodBeat.i(82276);
        int max = Math.max(getTitleHeight() - getWebScrollY(), 0);
        AppMethodBeat.o(82276);
        return max;
    }

    @Override // com.tencent.xweb.WebView
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean drawChild;
        AppMethodBeat.i(82277);
        if (view == this.JAh) {
            int webScrollY = getWebScrollY();
            canvas.save();
            canvas.translate(0.0f, (float) (-webScrollY));
            drawChild = super.drawChild(canvas, view, j2);
            canvas.restore();
        } else {
            drawChild = super.drawChild(canvas, view, j2);
        }
        AppMethodBeat.o(82277);
        return drawChild;
    }

    public int getTitleHeight() {
        AppMethodBeat.i(82278);
        if (this.JAh != null) {
            int height = this.JAh.getHeight();
            AppMethodBeat.o(82278);
            return height;
        }
        AppMethodBeat.o(82278);
        return 0;
    }

    public int getBottomHeight() {
        AppMethodBeat.i(82279);
        if (this.DeR != null) {
            int height = this.DeR.getHeight();
            AppMethodBeat.o(82279);
            return height;
        }
        AppMethodBeat.o(82279);
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public final void gim() {
        AppMethodBeat.i(82280);
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
        AppMethodBeat.o(82280);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public final void gin() {
        AppMethodBeat.i(82281);
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) getBottomHeight()) / getScale())) + ");", null);
        AppMethodBeat.o(82281);
    }

    private int getViewHeightWithTitleBar() {
        AppMethodBeat.i(82282);
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        AppMethodBeat.o(82282);
        return height;
    }

    private void setEmbeddedTitleBarSinceJellyBean(View view) {
        AppMethodBeat.i(82283);
        if (view != null) {
            if (this.JAh != null) {
                removeView(this.JAh);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.JAh = new a(getContext());
            ((a) this.JAh).addView(view, new FrameLayout.LayoutParams(-1, -2));
            this.JAh.setBackgroundColor(getContext().getResources().getColor(R.color.afz));
            addView(this.JAh, layoutParams);
        }
        AppMethodBeat.o(82283);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public final void zu(boolean z) {
        AppMethodBeat.i(82284);
        if (this.DeR != null) {
            if (z) {
                this.DeR.setVisibility(0);
                AppMethodBeat.o(82284);
                return;
            }
            this.DeR.setVisibility(4);
        }
        AppMethodBeat.o(82284);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.h
    public void setEmbeddedBottomBar(View view) {
        AppMethodBeat.i(82285);
        if (view != null) {
            if (this.DeR != null) {
                removeView(this.DeR);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            this.DeR = new a(getContext());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((a) this.DeR).addView(view, layoutParams3);
            addView(this.DeR, layoutParams);
            this.DeR.setVisibility(4);
        }
        AppMethodBeat.o(82285);
    }

    /* access modifiers changed from: package-private */
    public class a extends FrameLayout {
        public a(Context context) {
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(82267);
            if (MailMMWebView.this.JAi || MailMMWebView.this.JAj) {
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        MailMMWebView.this.JAi = false;
                        MailMMWebView.this.JAj = false;
                        break;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(82267);
                return true;
            }
            AppMethodBeat.o(82267);
            return false;
        }

        /* access modifiers changed from: protected */
        public final void onSizeChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(82268);
            super.onSizeChanged(i2, i3, i4, i5);
            if (this != MailMMWebView.this.JAh || MailMMWebView.this.getTitleHeight() <= 0) {
                if (this == MailMMWebView.this.DeR && MailMMWebView.this.getBottomHeight() > 0) {
                    MailMMWebView.this.gin();
                }
                AppMethodBeat.o(82268);
                return;
            }
            MailMMWebView.this.gim();
            AppMethodBeat.o(82268);
        }
    }
}
