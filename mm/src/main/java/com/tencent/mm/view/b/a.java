package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a extends View {
    protected float Rkj;
    private Runnable RnA;
    protected float RnB;
    private boolean RnC = true;
    protected boolean RnD = true;
    protected boolean RnE = false;
    protected Matrix Rnu;
    protected Matrix Rnv;
    protected Rect Rnw;
    protected Rect Rnx;
    protected Rect Rny;
    private Rect Rnz;
    private com.tencent.mm.bt.b drS;
    protected Matrix drT;
    protected Rect drU;
    private boolean dsY = false;
    protected Rect hof;
    private float hol = 1.0f;
    private float riK;
    private float riL;
    float[] values = new float[9];

    public interface b {
        void Yh();

        void onStart();
    }

    public com.tencent.mm.bt.b getPresenter() {
        return this.drS;
    }

    public void setTouchEnable(boolean z) {
        this.RnD = z;
    }

    public a(Context context, com.tencent.mm.bt.b bVar) {
        super(context);
        AppMethodBeat.i(9379);
        this.drS = bVar;
        this.drT = new Matrix();
        this.Rnu = new Matrix();
        this.drU = new Rect();
        this.Rnw = new Rect();
        this.Rnx = new Rect();
        this.hof = new Rect();
        this.Rny = new Rect();
        Bitmap gtm = bVar.gtm();
        if (gtm != null) {
            this.hof.set(0, 0, gtm.getWidth(), gtm.getHeight());
            this.drU.set(this.hof);
            this.Rny.set(this.hof);
        }
        if (!hgb() && bVar.getConfig().rect != null) {
            Rect rect = bVar.getConfig().rect;
            this.drU.set(0, 0, rect.width(), rect.height());
            this.drT.postTranslate(0.0f, (float) rect.top);
        }
        AppMethodBeat.o(9379);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(9380);
        super.onLayout(z, i2, i3, i4, i5);
        Log.i("changelcai", "[onLayout] %s=%s=%s=%s=%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (z) {
            this.Rnw.set(i2, i3, i4, i5);
            this.Rnx.set(this.Rnw);
        }
        getPresenter().ate();
        AppMethodBeat.o(9380);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(9381);
        super.onDraw(canvas);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.setMatrix(this.drT);
        getPresenter().onDraw(canvas);
        AppMethodBeat.o(9381);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9382);
        if (getPresenter().gtn()) {
            aB(motionEvent);
        }
        if (!getPresenter().R(motionEvent) && hgb()) {
            if (!getPresenter().gte()) {
                AppMethodBeat.o(9382);
                return false;
            }
            aA(motionEvent);
        }
        AppMethodBeat.o(9382);
        return true;
    }

    /* access modifiers changed from: protected */
    public void aA(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: protected */
    public boolean hga() {
        return this.RnC;
    }

    public void setOneFingerMoveEnable(boolean z) {
        this.RnC = z;
    }

    public boolean hgb() {
        return true;
    }

    public Rect getAliveRect() {
        return this.drU;
    }

    public Matrix getMainMatrix() {
        return this.drT;
    }

    public void setForceMatrix(Matrix matrix) {
        this.Rnv = matrix;
    }

    public float getInitScale() {
        AppMethodBeat.i(9383);
        if (hgb()) {
            float f2 = this.hol;
            AppMethodBeat.o(9383);
            return f2;
        }
        AppMethodBeat.o(9383);
        return 1.0f;
    }

    public void setInitScale(float f2) {
        this.hol = f2;
    }

    public Rect getBoardRect() {
        AppMethodBeat.i(9384);
        if (this.Rnw == null) {
            this.Rnw = new Rect();
        }
        Rect rect = this.Rnw;
        AppMethodBeat.o(9384);
        return rect;
    }

    public Rect getRawBoardRect() {
        return this.Rnx;
    }

    public final void u(Rect rect) {
        this.Rnw = rect;
    }

    public final void DF(boolean z) {
        this.RnE = z;
    }

    /* access modifiers changed from: protected */
    public final void aB(MotionEvent motionEvent) {
        AppMethodBeat.i(204759);
        if (motionEvent.getAction() == 0) {
            this.riK = motionEvent.getX();
            this.riL = motionEvent.getY();
        }
        if (motionEvent.getAction() == 1) {
            removeCallbacks(this.RnA);
            long j2 = 0;
            if (this.dsY) {
                j2 = 700;
            }
            if (getPresenter().gti().XS() != com.tencent.mm.e.a.EMOJI_AND_TEXT) {
                AnonymousClass1 r2 = new Runnable() {
                    /* class com.tencent.mm.view.b.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(9372);
                        if (a.this.getPresenter().gth().diT) {
                            a.this.getPresenter().gth().setFooterVisible(false);
                            a.this.getPresenter().gth().setActionBarVisible(false);
                            AppMethodBeat.o(9372);
                            return;
                        }
                        a.this.getPresenter().gth().setFooterVisible(true);
                        a.this.getPresenter().gth().setActionBarVisible(true);
                        AppMethodBeat.o(9372);
                    }
                };
                this.RnA = r2;
                postDelayed(r2, j2);
            } else {
                getPresenter().gth().DC(true);
                if (getPresenter().gth().diT) {
                    getPresenter().gth().setFooterVisible(false);
                    getPresenter().gth().setActionBarVisible(false);
                } else if (!getPresenter().gth().hfx()) {
                    getPresenter().gth().setFooterVisible(true);
                    getPresenter().gth().setActionBarVisible(true);
                }
                getPresenter().gth().getBaseFooterView().hgm();
            }
            this.dsY = false;
            AppMethodBeat.o(204759);
            return;
        }
        if (motionEvent.getAction() == 2) {
            if (Math.abs(motionEvent.getX() - this.riK) >= 3.0f || Math.abs(motionEvent.getY() - this.riL) >= 3.0f) {
                this.dsY = true;
                removeCallbacks(this.RnA);
                if (getPresenter().gth().diT) {
                    getPresenter().gth().setFooterVisible(false);
                    getPresenter().gth().setActionBarVisible(false);
                }
            }
            this.riK = motionEvent.getX();
            this.riL = motionEvent.getY();
        }
        AppMethodBeat.o(204759);
    }

    public final void hgc() {
        float height;
        float width;
        float height2;
        float width2;
        float width3;
        AppMethodBeat.i(9385);
        Log.i("MicroMsg.BaseBoardView", "adaptImage execute guess only by first time");
        Rect rawImageRect = getRawImageRect();
        if (b(this.drT) % 180.0f == 0.0f) {
            height = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
        } else {
            height = (((float) rawImageRect.height()) * 1.0f) / ((float) rawImageRect.width());
        }
        if (height < (((float) getBoardRect().width()) * 1.0f) / ((float) getBoardRect().height())) {
            height2 = ((float) getBoardRect().width()) / height;
            width = (float) getBoardRect().height();
        } else {
            width = ((float) getBoardRect().width()) / height;
            height2 = (float) getBoardRect().height();
        }
        if (b(this.drT) % 180.0f == 0.0f) {
            width2 = (1.0f * width) / ((float) rawImageRect.height());
        } else {
            width2 = (1.0f * width) / ((float) rawImageRect.width());
        }
        if (b(this.drT) % 180.0f == 0.0f) {
            width3 = (height2 * 1.0f) / ((float) rawImageRect.height());
        } else {
            width3 = (height2 * 1.0f) / ((float) rawImageRect.width());
        }
        this.drT.postScale(width2, width2, (float) rawImageRect.centerX(), (float) rawImageRect.centerY());
        RectF curImageRect = getCurImageRect();
        this.drT.postTranslate((float) (getBoardRect().centerX() - ((int) curImageRect.centerX())), (float) (getBoardRect().centerY() - ((int) curImageRect.centerY())));
        this.Rnu.set(this.drT);
        this.Rkj = e(this.Rnu) * 3.0f;
        this.RnB = e(this.Rnu) * 1.0f;
        if (this.Rkj < width3) {
            this.Rkj = width3 * 1.2f;
        }
        AppMethodBeat.o(9385);
    }

    public final void hgd() {
        AppMethodBeat.i(204760);
        this.drT.reset();
        hgc();
        AppMethodBeat.o(204760);
    }

    public final void a(b bVar, float f2, boolean z) {
        float height;
        float width;
        float width2;
        AppMethodBeat.i(9386);
        Log.i("MicroMsg.BaseBoardView", "adaptImageWithAnim");
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        int centerY = (int) curImageRect.centerY();
        int centerX2 = getBoardRect().centerX() - centerX;
        int centerY2 = getBoardRect().centerY() - centerY;
        if (f2 % 180.0f == 0.0f) {
            height = (curImageRect.width() * 1.0f) / curImageRect.height();
        } else {
            height = (curImageRect.height() * 1.0f) / curImageRect.width();
        }
        if (height < (((float) getBoardRect().width()) * 1.0f) / ((float) getBoardRect().height())) {
            getBoardRect().width();
            width = (float) getBoardRect().height();
        } else {
            getBoardRect().height();
            width = ((float) getBoardRect().width()) / height;
        }
        if (f2 % 180.0f == 0.0f) {
            width2 = (width * 1.0f) / curImageRect.height();
        } else {
            width2 = (width * 1.0f) / curImageRect.width();
        }
        C2161a aVar = new C2161a(width2, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f2, z);
        aVar.RnJ = bVar;
        aVar.play();
        AppMethodBeat.o(9386);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.view.b.a$a  reason: collision with other inner class name */
    public class C2161a extends com.tencent.mm.c.b {
        private float RnG;
        private float RnH;
        boolean RnI;
        b RnJ;
        float SM;
        private ValueAnimator dgN;
        float dhh;
        float dhi;
        float dhj;

        public C2161a(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
            this.dhh = f2;
            this.RnG = f3;
            this.RnH = f4;
            this.dhi = f5;
            this.dhj = f6;
            this.SM = f7;
            this.RnI = z;
        }

        public final void play() {
            AppMethodBeat.i(9377);
            this.dgN = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", 0.0f, 166.0f), PropertyValuesHolder.ofFloat("deltaX", 0.0f, this.RnG), PropertyValuesHolder.ofFloat("deltaY", 0.0f, this.RnH), PropertyValuesHolder.ofFloat("rotation", 0.0f, this.SM));
            this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.view.b.a.C2161a.AnonymousClass1 */
                float RnK = 0.0f;
                float dhd = 0.0f;
                float dhe = 0.0f;
                float dhm = ((float) Math.pow((double) C2161a.this.dhh, 0.10000000149011612d));
                int scaleCount = 0;

                {
                    AppMethodBeat.i(9373);
                    AppMethodBeat.o(9373);
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(9374);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
                    if (this.scaleCount < 10) {
                        a.this.drT.postScale(this.dhm, this.dhm, (float) a.this.getBoardRect().centerX(), (float) a.this.getBoardRect().centerY());
                        this.scaleCount++;
                    }
                    C2161a.this.dhi += floatValue2 - this.dhe;
                    C2161a.this.dhj += floatValue - this.dhd;
                    a.this.drT.postTranslate(C2161a.this.dhi - a.this.getCurImageRect().centerX(), C2161a.this.dhj - a.this.getCurImageRect().centerY());
                    if (C2161a.this.SM != 0.0f) {
                        a.this.drT.postRotate(floatValue3 - this.RnK, C2161a.this.dhi, C2161a.this.dhj);
                    }
                    a.this.postInvalidate();
                    this.dhd = floatValue;
                    this.dhe = floatValue2;
                    this.RnK = floatValue3;
                    AppMethodBeat.o(9374);
                }
            });
            this.dgN.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.view.b.a.C2161a.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(9375);
                    Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationStart");
                    if (C2161a.this.RnJ != null) {
                        C2161a.this.RnJ.onStart();
                    }
                    C2161a.this.dgZ = false;
                    AppMethodBeat.o(9375);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(9376);
                    if (C2161a.this.RnJ != null) {
                        C2161a.this.RnJ.Yh();
                    }
                    Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationEnd");
                    C2161a.this.dgZ = true;
                    a.this.Rnu.set(a.this.drT);
                    a.this.RnB = a.this.e(a.this.Rnu) * 1.0f;
                    if (C2161a.this.RnI) {
                        a.this.Rkj = a.this.e(a.this.Rnu) * 3.0f;
                        C2161a.a(C2161a.this);
                    }
                    AppMethodBeat.o(9376);
                }

                public final void onAnimationCancel(Animator animator) {
                    C2161a.this.dgZ = true;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.dgN.setInterpolator(new LinearInterpolator());
            this.dgN.setDuration(166L);
            this.dgN.start();
            AppMethodBeat.o(9377);
        }

        static /* synthetic */ void a(C2161a aVar) {
            float height;
            float width;
            AppMethodBeat.i(9378);
            Rect rawImageRect = a.this.getRawImageRect();
            float width2 = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
            if (width2 < (((float) a.this.getBoardRect().width()) * 1.0f) / ((float) a.this.getBoardRect().height())) {
                height = ((float) a.this.getBoardRect().width()) / width2;
                a.this.getBoardRect().height();
            } else {
                height = (float) a.this.getBoardRect().height();
                a.this.getBoardRect().width();
            }
            if (a.this.b(a.this.drT) % 180.0f == 0.0f) {
                width = (height * 1.0f) / ((float) rawImageRect.height());
            } else {
                width = (height * 1.0f) / ((float) rawImageRect.width());
            }
            if (a.this.Rkj < width) {
                a.this.Rkj = width * 1.2f;
            }
            AppMethodBeat.o(9378);
        }
    }

    public RectF getCurImageRect() {
        AppMethodBeat.i(9387);
        RectF rectF = new RectF(getRawImageRect());
        this.drT.mapRect(rectF);
        AppMethodBeat.o(9387);
        return rectF;
    }

    public Rect getRawLayoutRect() {
        AppMethodBeat.i(204761);
        if (this.Rnz == null) {
            this.Rnz = getPresenter().getConfig().diV;
        }
        Rect rect = this.Rnz;
        AppMethodBeat.o(204761);
        return rect;
    }

    public final void v(Rect rect) {
        AppMethodBeat.i(9388);
        this.hof.set(rect);
        this.drU.set(rect);
        Log.i("MicroMsg.BaseBoardView", "[resetImageRect] rect %s", rect.flattenToString());
        AppMethodBeat.o(9388);
    }

    public Rect getRawImageRect() {
        return this.hof;
    }

    public Rect getImageBitmapRect() {
        return this.Rny;
    }

    public float getMinScale() {
        return this.RnB;
    }

    public float getMaxScale() {
        return this.Rkj;
    }

    private float a(Matrix matrix, int i2) {
        AppMethodBeat.i(9389);
        matrix.getValues(this.values);
        float f2 = this.values[i2];
        AppMethodBeat.o(9389);
        return f2;
    }

    /* access modifiers changed from: protected */
    public final float e(Matrix matrix) {
        AppMethodBeat.i(9390);
        float a2 = a(matrix, 3);
        float a3 = a(matrix, 0);
        float sqrt = (float) Math.sqrt((double) ((a2 * a2) + (a3 * a3)));
        AppMethodBeat.o(9390);
        return sqrt;
    }

    public float getCurScale() {
        AppMethodBeat.i(9391);
        float e2 = e(this.drT);
        AppMethodBeat.o(9391);
        return e2;
    }

    public final float b(Matrix matrix) {
        AppMethodBeat.i(9392);
        float round = (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
        AppMethodBeat.o(9392);
        return round;
    }
}
