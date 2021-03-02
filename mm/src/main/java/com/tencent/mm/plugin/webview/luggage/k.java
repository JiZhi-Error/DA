package com.tencent.mm.plugin.webview.luggage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class k extends FrameLayout {
    private int Dn;
    protected View mContentView;
    private boolean mDisabled = true;
    private int mTouchSlop;
    protected FrameLayout nms;
    protected View nrE;
    protected FrameLayout nrF;
    private boolean nrG = false;
    private boolean nrH = false;
    private boolean nrI = false;
    private boolean nrJ = false;
    private int nrK;
    private int nrL;
    private ObjectAnimator nrN = null;

    public k(Context context) {
        super(context);
        AppMethodBeat.i(78359);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(78359);
    }

    public void l(View view, View view2) {
        AppMethodBeat.i(78360);
        removeAllViews();
        this.nrE = view;
        this.nrF = new FrameLayout(getContext());
        this.nrF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.nrF.addView(view);
        this.mContentView = view2;
        this.nms = new FrameLayout(getContext());
        this.nms.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.nms.addView(view2);
        addView(this.nrF);
        addView(this.nms);
        AppMethodBeat.o(78360);
    }

    public void setPullDownEnabled(boolean z) {
        this.mDisabled = !z;
    }

    public void setNeedStay(boolean z) {
        this.nrG = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(78361);
        if (this.mDisabled) {
            boolean z = this.nrJ;
            AppMethodBeat.o(78361);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            AppMethodBeat.o(78361);
            return false;
        } else if (this.nrI) {
            AppMethodBeat.o(78361);
            return true;
        } else {
            switch (action) {
                case 0:
                    if (MN()) {
                        this.nrK = (int) motionEvent.getX();
                        this.nrL = (int) motionEvent.getY();
                        this.Dn = (int) motionEvent.getY();
                        break;
                    }
                    break;
                case 2:
                    if (MN()) {
                        int x = ((int) motionEvent.getX()) - this.nrK;
                        int y = ((int) motionEvent.getY()) - this.nrL;
                        if (Math.abs(y) > this.mTouchSlop && Math.abs(y) > Math.abs(x) && y > 0) {
                            this.nrI = true;
                            AppMethodBeat.o(78361);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(78361);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(78362);
        if (this.mDisabled) {
            if (this.nrJ) {
                bRQ();
            }
            boolean z = this.nrJ;
            AppMethodBeat.o(78362);
            return z;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Dn = (int) motionEvent.getY();
                AppMethodBeat.o(78362);
                return true;
            case 1:
            case 3:
                if (this.nms.getTranslationY() <= ((float) getOpenHeight()) || !this.nrG) {
                    bRQ();
                } else {
                    yN(getStayHeight());
                    if (!this.nrH) {
                        bRR();
                    }
                    this.nrI = true;
                    this.nrH = true;
                    this.nrJ = true;
                }
                AppMethodBeat.o(78362);
                return true;
            case 2:
                int y = ((int) motionEvent.getY()) - this.Dn;
                int i2 = y >> 1;
                int maxOverScrollDistance = getMaxOverScrollDistance();
                if (i2 <= maxOverScrollDistance) {
                    maxOverScrollDistance = i2;
                }
                if (this.nrH) {
                    maxOverScrollDistance += getStayHeight();
                }
                int max = Math.max(maxOverScrollDistance, 0);
                Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(y), Integer.valueOf(max));
                this.nms.setTranslationY((float) Math.min(getMaxOverScrollDistance(), max));
                yM(max);
                AppMethodBeat.o(78362);
                return true;
            default:
                AppMethodBeat.o(78362);
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public void bRQ() {
        AppMethodBeat.i(78363);
        yN(0);
        this.nrI = false;
        this.nrH = false;
        this.nrJ = false;
        AppMethodBeat.o(78363);
    }

    /* access modifiers changed from: protected */
    public void bRR() {
    }

    /* access modifiers changed from: protected */
    public void yM(int i2) {
    }

    public void setPullDownBackgroundColor(int i2) {
        AppMethodBeat.i(78364);
        this.nrF.setBackgroundColor(i2);
        AppMethodBeat.o(78364);
    }

    private boolean MN() {
        AppMethodBeat.i(78365);
        Log.d("MicroMsg.AppBrandPullDownView", "canOverScroll, scrollY = %d, topY = %d", Integer.valueOf(this.mContentView.getScrollY()), Integer.valueOf(this.mContentView.getTop()));
        if (this.mContentView instanceof WebView) {
            if (((WebView) this.mContentView).getWebScrollY() == 0) {
                AppMethodBeat.o(78365);
                return true;
            }
            AppMethodBeat.o(78365);
            return false;
        } else if (this.mContentView instanceof RecyclerView) {
            if (((LinearLayoutManager) ((RecyclerView) this.mContentView).getLayoutManager()).ks() == 0 && this.mContentView.getScrollY() == 0) {
                AppMethodBeat.o(78365);
                return true;
            }
            AppMethodBeat.o(78365);
            return false;
        } else if (this.mContentView.getScrollY() == 0) {
            AppMethodBeat.o(78365);
            return true;
        } else {
            AppMethodBeat.o(78365);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxOverScrollDistance() {
        AppMethodBeat.i(78366);
        int height = getHeight();
        AppMethodBeat.o(78366);
        return height;
    }

    /* access modifiers changed from: protected */
    public int getOpenHeight() {
        AppMethodBeat.i(78367);
        int height = this.nrE.getHeight();
        AppMethodBeat.o(78367);
        return height;
    }

    /* access modifiers changed from: protected */
    public int getStayHeight() {
        AppMethodBeat.i(78368);
        int height = this.nrE.getHeight();
        AppMethodBeat.o(78368);
        return height;
    }

    private void yN(int i2) {
        AppMethodBeat.i(78369);
        int translationY = (int) this.nms.getTranslationY();
        if (translationY == i2) {
            AppMethodBeat.o(78369);
            return;
        }
        Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", Integer.valueOf(translationY), Integer.valueOf(i2));
        if (this.nrN != null) {
            this.nrN.cancel();
        }
        long abs = (long) ((((float) Math.abs(translationY - i2)) / ((float) getStayHeight())) * 250.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nms, "translationY", (float) translationY, (float) i2);
        ofFloat.setDuration(Math.min(abs, 250L));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.webview.luggage.k.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(78358);
                k.this.yM((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(78358);
            }
        });
        this.nrN = ofFloat;
        AppMethodBeat.o(78369);
    }
}
