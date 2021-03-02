package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.h;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.smtt.sdk.WebView;

public abstract class a extends View {
    public static final int[] RoQ = {-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private Bitmap RoA;
    private Bitmap RoB;
    private Bitmap RoC;
    private Bitmap RoD;
    private Bitmap RoE;
    private Bitmap RoF;
    protected Bitmap RoG;
    protected Bitmap RoH;
    protected int RoI = -1;
    protected int RoJ = -1;
    private Rect[] RoK;
    private Rect[] RoL;
    protected Rect RoM;
    protected boolean RoN;
    protected Paint RoO;
    protected Paint RoP;
    protected boolean RoR = false;
    protected int RoS = -1;
    protected int RoT = -1;
    private boolean RoU = true;
    private final float Roz = getResources().getDimension(R.dimen.a48);
    private b drS;
    private Paint hog;
    protected int oEI = -1;

    /* access modifiers changed from: protected */
    public abstract Bitmap a(h hVar, boolean z);

    public void setHideFooter(boolean z) {
        this.RoR = z;
    }

    public final boolean hgg() {
        return this.RoR;
    }

    public a(Context context, b bVar) {
        super(context);
        setId(R.id.a2e);
        this.drS = bVar;
        hgh();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        A(canvas);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (true) {
                    if (i2 >= getFeatureCount()) {
                        break;
                    } else if (this.RoK[i2].contains(x, y)) {
                        this.RoS = i2;
                        postInvalidate();
                        break;
                    } else {
                        if (hgi()) {
                            if (this.RoM == null || !this.RoM.contains(x, y)) {
                                mc(x, y);
                            } else {
                                this.RoN = true;
                                postInvalidate();
                            }
                        }
                        i2++;
                    }
                }
                break;
            case 1:
            case 3:
                int i3 = 0;
                while (true) {
                    if (i3 < getFeatureCount()) {
                        if (this.RoK[i3].contains(x, y) && this.RoS == i3) {
                            if (apX(i3)) {
                                if (this.RoS != this.oEI) {
                                    this.oEI = this.RoS;
                                } else {
                                    this.oEI = -1;
                                }
                            }
                            if (!this.RoR) {
                                this.RoJ = this.RoI;
                                if (apX(i3)) {
                                    this.RoI = this.oEI;
                                    getPresenter().getSelectedFeatureListener().a(apW(this.oEI));
                                } else {
                                    this.RoI = i3;
                                    getPresenter().getSelectedFeatureListener().a(apW(i3));
                                }
                            }
                        }
                        i3++;
                    }
                }
                if (hgi()) {
                    if (this.RoM == null || !this.RoM.contains(x, y) || !this.RoN) {
                        md(x, y);
                    } else {
                        getPresenter().getSelectedFeatureListener().a(apW(this.oEI), -1, null);
                    }
                }
                this.RoN = false;
                this.RoS = -1;
                requestLayout();
                postInvalidate();
                break;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int dimension = (int) getResources().getDimension(R.dimen.a4a);
        if (hgi()) {
            dimension += getDetailHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(dimension, 1073741824));
        hgj();
    }

    /* access modifiers changed from: protected */
    public b getPresenter() {
        return this.drS;
    }

    /* access modifiers changed from: protected */
    public void hgh() {
        this.RoO = new Paint(1);
        this.RoO.setColor(-16711936);
        this.RoP = new Paint(1);
        this.RoP.setColor(getResources().getColor(R.color.m9));
        this.RoP.setStrokeWidth(0.6f);
        this.hog = new Paint(1);
        this.hog.setStyle(Paint.Style.FILL);
        this.hog.setStrokeCap(Paint.Cap.ROUND);
        this.RoH = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.undo_press));
        this.RoG = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.undo_normal));
        this.RoA = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.doodle_unselected));
        this.RoB = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.doodle_selected));
        this.RoC = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.text_unselected));
        this.RoD = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.text_selected));
        this.RoE = BitmapFactory.decodeResource(getResources(), R.drawable.emoji_unselected);
        this.RoF = BitmapFactory.decodeResource(getResources(), R.drawable.emoji_selected);
    }

    /* access modifiers changed from: protected */
    public void mc(int i2, int i3) {
        switch (apW(this.oEI)) {
            case DOODLE:
                if (this.RoL != null) {
                    for (int i4 = 0; i4 < this.RoL.length; i4++) {
                        if (this.RoL[i4].contains(i2, i3)) {
                            this.RoT = i4;
                            this.RoU = false;
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void md(int i2, int i3) {
        switch (apW(this.oEI)) {
            case DOODLE:
                int i4 = 0;
                while (this.RoL != null && i4 < this.RoL.length) {
                    if (!this.RoL[i4].contains(i2, i3) || i4 != this.RoT) {
                        i4++;
                    } else {
                        getPresenter().getSelectedFeatureListener().a(h.DOODLE, i4, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    private boolean hgi() {
        return getDetailHeight() > 0;
    }

    private Bitmap b(h hVar, boolean z) {
        Bitmap bitmap = null;
        switch (hVar) {
            case DOODLE:
                if (!z) {
                    bitmap = this.RoA;
                    break;
                } else {
                    bitmap = this.RoB;
                    break;
                }
            case TEXT:
                if (!z) {
                    bitmap = this.RoC;
                    break;
                } else {
                    bitmap = this.RoD;
                    break;
                }
            case EMOJI:
                if (!z) {
                    bitmap = this.RoE;
                    break;
                } else {
                    bitmap = this.RoF;
                    break;
                }
        }
        if (bitmap == null) {
            return a(hVar, z);
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    public int getFeatureCount() {
        return getPresenter().getFeatures().length;
    }

    /* access modifiers changed from: protected */
    public float getIconWidth() {
        Bitmap b2 = b(h.DOODLE, false);
        if (b2 == null) {
            return 0.0f;
        }
        return (float) b2.getWidth();
    }

    public int getColor(int i2) {
        if (i2 < 0 || i2 >= RoQ.length) {
            return -65536;
        }
        return RoQ[i2];
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.Roz);
    }

    /* access modifiers changed from: protected */
    public float getWidthSpacing() {
        return ((((float) getMeasuredWidth()) - (((float) getFeatureCount()) * getIconWidth())) - ((float) getPaddingLeftAndRight())) / ((float) (getFeatureCount() - 1));
    }

    /* access modifiers changed from: protected */
    public float getHeightSpacing() {
        return (((float) (getMeasuredHeight() - getDetailHeight())) - getIconWidth()) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public int getDetailHeight() {
        if (apW(this.oEI) == h.DOODLE) {
            return (int) getResources().getDimension(R.dimen.a4_);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final h apW(int i2) {
        if (i2 < 0 || i2 >= getFeatureCount()) {
            return h.DEFAULT;
        }
        return getPresenter().getFeatures()[i2];
    }

    /* access modifiers changed from: protected */
    public void hgj() {
        if (this.RoK == null) {
            this.RoK = new Rect[getFeatureCount()];
        }
        int iconWidth = (int) (this.Roz + (getIconWidth() / 2.0f));
        int iconWidth2 = (int) getIconWidth();
        for (int i2 = 0; i2 < getFeatureCount(); i2++) {
            this.RoK[i2] = new Rect(iconWidth - iconWidth2, getDetailHeight(), iconWidth + iconWidth2, getDetailHeight() + getMeasuredHeight());
            iconWidth = (int) (((float) iconWidth) + getWidthSpacing() + getIconWidth());
        }
        if (apW(this.oEI) == h.DOODLE) {
            hgk();
        }
    }

    private void hgk() {
        if (this.RoL == null) {
            this.RoL = new Rect[RoQ.length];
        }
        if (this.RoM == null) {
            this.RoM = new Rect();
        }
        float dimension = getResources().getDimension(R.dimen.a0r);
        float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.RoG.getWidth())) - ((2.0f * dimension) * ((float) RoQ.length))) / ((float) RoQ.length);
        int i2 = (int) (dimension * 2.0f);
        int paddingLeftAndRight = (int) (((float) (getPaddingLeftAndRight() / 2)) + dimension + 5.0f);
        int detailHeight = (int) (((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension);
        for (int i3 = 0; i3 < RoQ.length; i3++) {
            this.RoL[i3] = new Rect(paddingLeftAndRight - i2, detailHeight - i2, paddingLeftAndRight + i2, detailHeight + i2);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + (2.0f * dimension) + measuredWidth);
        }
        int measuredWidth2 = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.RoG.getWidth() / 2);
        this.RoM.set(measuredWidth2 - this.RoG.getWidth(), 0, measuredWidth2 + this.RoG.getWidth(), getDetailHeight());
    }

    /* access modifiers changed from: protected */
    public void A(Canvas canvas) {
        if (hgi()) {
            canvas.drawLine(0.0f, (float) getDetailHeight(), (float) getMeasuredWidth(), (float) getDetailHeight(), this.RoP);
            B(canvas);
        }
        float f2 = this.Roz;
        float heightSpacing = getHeightSpacing() + ((float) getDetailHeight());
        for (int i2 = 0; i2 < getFeatureCount(); i2++) {
            Bitmap b2 = b(getPresenter().getFeatures()[i2], this.RoS == i2 || i2 == this.oEI);
            if (b2 != null) {
                canvas.drawBitmap(b2, f2, heightSpacing, (Paint) null);
            }
            f2 += getWidthSpacing() + getIconWidth();
        }
    }

    /* access modifiers changed from: protected */
    public void B(Canvas canvas) {
        if (apW(this.oEI) == h.DOODLE) {
            float dimension = getResources().getDimension(R.dimen.a0r);
            float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.RoG.getWidth())) - ((2.0f * dimension) * ((float) RoQ.length))) / ((float) RoQ.length);
            float ao = ((float) com.tencent.mm.cl.a.ao(1.5f)) + ((float) (getPaddingLeftAndRight() / 2)) + dimension;
            float detailHeight = ((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension;
            for (int i2 = 0; i2 < RoQ.length; i2++) {
                float f2 = 0.0f;
                if (this.RoT == i2) {
                    f2 = (float) com.tencent.mm.cl.a.ao(2.0f);
                    this.RoU = false;
                } else if (this.RoU && i2 == 2) {
                    f2 = (float) com.tencent.mm.cl.a.ao(2.0f);
                }
                this.hog.setColor(-1);
                canvas.drawCircle(ao, detailHeight, ((float) com.tencent.mm.cl.a.ao(1.5f)) + dimension + f2, this.hog);
                this.hog.setColor(RoQ[i2]);
                canvas.drawCircle(ao, detailHeight, f2 + dimension, this.hog);
                ao += (2.0f * dimension) + measuredWidth;
            }
            Paint paint = new Paint();
            if (XX()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(160);
            }
            canvas.drawBitmap((!this.RoN || !XX()) ? this.RoG : this.RoH, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.RoG.getWidth()), (float) ((getDetailHeight() - this.RoG.getHeight()) / 2), paint);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean XX() {
        com.tencent.mm.e.b c2 = getPresenter().c(getCurFeatureType());
        if (c2 == null) {
            return false;
        }
        return c2.XX();
    }

    /* access modifiers changed from: protected */
    public boolean apX(int i2) {
        switch (apW(i2)) {
            case DOODLE:
                return true;
            case TEXT:
            case EMOJI:
            default:
                return false;
        }
    }

    public h getCurFeatureType() {
        return apW(this.RoI);
    }

    public void setCurFeatureType(h hVar) {
        int i2 = 0;
        while (true) {
            if (i2 >= getFeatureCount()) {
                i2 = -1;
                break;
            } else if (getPresenter().getFeatures()[i2] == hVar) {
                break;
            } else {
                i2++;
            }
        }
        if (apX(i2)) {
            this.oEI = i2;
        } else {
            this.oEI = -1;
        }
        this.RoI = i2;
        requestLayout();
        invalidate();
    }

    public final void hgl() {
        this.RoJ = this.RoI;
    }

    public final void hgm() {
        this.RoI = this.RoJ;
        requestLayout();
        invalidate();
    }

    public void setFooterVisible(boolean z) {
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.n);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.view.footer.a.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9401);
                    a.this.setVisibility(0);
                    AppMethodBeat.o(9401);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(loadAnimation);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.o);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.view.footer.a.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(9402);
                a.this.setVisibility(8);
                AppMethodBeat.o(9402);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(loadAnimation2);
    }
}
