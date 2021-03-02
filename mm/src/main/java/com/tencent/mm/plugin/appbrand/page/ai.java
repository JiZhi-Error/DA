package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ai extends FrameLayout {
    private int Dn;
    public boolean mDisabled = true;
    private int mTouchSlop;
    FrameLayout nms;
    View nrE;
    FrameLayout nrF;
    private boolean nrG = false;
    private boolean nrH = false;
    private boolean nrI = false;
    private boolean nrJ = false;
    private int nrK;
    private int nrL;
    private boolean nrM = false;
    private ObjectAnimator nrN = null;

    public ai(Context context) {
        super(context);
        AppMethodBeat.i(135211);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(135211);
    }

    public void setPullDownEnabled(boolean z) {
        this.mDisabled = !z;
    }

    public void setNeedStay(boolean z) {
        this.nrG = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(135212);
        if (this.mDisabled) {
            boolean z = this.nrJ;
            AppMethodBeat.o(135212);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.nrI = false;
            this.nrM = false;
            AppMethodBeat.o(135212);
            return false;
        } else if (action != 2 || !this.nrI) {
            switch (action) {
                case 0:
                    if (MN()) {
                        this.nrK = (int) motionEvent.getX();
                        this.nrL = (int) motionEvent.getY();
                        this.Dn = (int) motionEvent.getY();
                        this.nrI = false;
                        this.nrM = true;
                        break;
                    }
                    break;
                case 2:
                    if (MN()) {
                        if (!this.nrM) {
                            this.nrK = (int) motionEvent.getX();
                            this.nrL = (int) motionEvent.getY();
                            this.Dn = (int) motionEvent.getY();
                            this.nrI = false;
                            this.nrM = true;
                            AppMethodBeat.o(135212);
                            return false;
                        }
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        int i2 = x - this.nrK;
                        int i3 = y - this.nrL;
                        if (Math.abs(i3) > this.mTouchSlop && Math.abs(i3) > Math.abs(i2) && i3 > 0) {
                            this.nrK = x;
                            this.nrL = y;
                            this.nrI = true;
                            this.nrM = false;
                            AppMethodBeat.o(135212);
                            return true;
                        }
                    }
                    break;
            }
            if (this.nrI || this.nrJ) {
                AppMethodBeat.o(135212);
                return true;
            }
            AppMethodBeat.o(135212);
            return false;
        } else {
            AppMethodBeat.o(135212);
            return true;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(135213);
        if (this.mDisabled) {
            if (this.nrJ) {
                bRQ();
            }
            boolean z = this.nrJ;
            AppMethodBeat.o(135213);
            return z;
        } else if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (MN() || this.nrJ) {
                        this.nrL = (int) motionEvent.getY();
                        this.nrK = (int) motionEvent.getX();
                        this.Dn = (int) motionEvent.getY();
                        this.nrM = true;
                        AppMethodBeat.o(135213);
                        return true;
                    }
                case 1:
                case 3:
                    this.nrM = false;
                    if (this.nms.getTranslationY() > ((float) getOpenHeight()) && this.nrG) {
                        bRP();
                        AppMethodBeat.o(135213);
                        return true;
                    } else if (this.nrI || this.nrJ) {
                        bRQ();
                        AppMethodBeat.o(135213);
                        return true;
                    }
                    break;
                case 2:
                    if (this.nrI || this.nrJ) {
                        if (!this.nrM) {
                            this.nrL = (int) motionEvent.getY();
                            this.nrK = (int) motionEvent.getX();
                            this.Dn = (int) motionEvent.getY();
                            this.nrM = true;
                            AppMethodBeat.o(135213);
                            return true;
                        }
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
                        AppMethodBeat.o(135213);
                        return true;
                    }
            }
            AppMethodBeat.o(135213);
            return false;
        } else {
            AppMethodBeat.o(135213);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void bRP() {
        AppMethodBeat.i(135214);
        yN(getStayHeight());
        if (!this.nrH) {
            bRR();
        }
        this.nrI = true;
        this.nrH = true;
        this.nrJ = true;
        AppMethodBeat.o(135214);
    }

    /* access modifiers changed from: protected */
    public final void bRQ() {
        AppMethodBeat.i(135215);
        yN(0);
        if (this.nrH) {
            bRS();
        }
        this.nrI = false;
        this.nrH = false;
        this.nrJ = false;
        AppMethodBeat.o(135215);
    }

    /* access modifiers changed from: protected */
    public void bRR() {
    }

    /* access modifiers changed from: protected */
    public void bRS() {
    }

    /* access modifiers changed from: protected */
    public void yM(int i2) {
    }

    public void setPullDownBackgroundColor(int i2) {
        AppMethodBeat.i(135216);
        this.nrF.setBackgroundColor(i2);
        AppMethodBeat.o(135216);
    }

    public int getPullDownBackgroundColor() {
        AppMethodBeat.i(178618);
        Drawable background = this.nrF.getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            AppMethodBeat.o(178618);
            return color;
        }
        AppMethodBeat.o(178618);
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean MN() {
        return false;
    }

    private int getMaxOverScrollDistance() {
        AppMethodBeat.i(135217);
        int height = getHeight();
        AppMethodBeat.o(135217);
        return height;
    }

    /* access modifiers changed from: protected */
    public int getOpenHeight() {
        AppMethodBeat.i(135218);
        int height = this.nrE.getHeight();
        AppMethodBeat.o(135218);
        return height;
    }

    /* access modifiers changed from: protected */
    public int getStayHeight() {
        AppMethodBeat.i(135219);
        int height = this.nrE.getHeight();
        AppMethodBeat.o(135219);
        return height;
    }

    private void yN(int i2) {
        AppMethodBeat.i(135220);
        int translationY = (int) this.nms.getTranslationY();
        if (translationY == i2) {
            AppMethodBeat.o(135220);
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
            /* class com.tencent.mm.plugin.appbrand.page.ai.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(135210);
                ai.this.yM((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(135210);
            }
        });
        this.nrN = ofFloat;
        AppMethodBeat.o(135220);
    }
}
