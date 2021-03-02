package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.at;

public class MMSwitchBtn extends View {
    private float FcB;
    private float FcC;
    private int QDA;
    private int QDB;
    private String QDC;
    private String QDD;
    private b QDE = new b(this, (byte) 0);
    private a QDF;
    private long QDk;
    private int QDl;
    private int QDm;
    private int QDn;
    private boolean QDo = false;
    private boolean QDp = false;
    private float QDq;
    private float QDr;
    private int QDs;
    private int QDt;
    private int QDu;
    private int QDv;
    public boolean QDw = false;
    private RectF QDx = new RectF();
    private RectF QDy = new RectF();
    private int QDz;
    private int edgePadding;
    private int maxHeight;
    private int maxWidth;
    private Paint qvj = new Paint(1);
    private int rZ;

    public interface a {
        void onStatusChange(boolean z);
    }

    static /* synthetic */ void e(MMSwitchBtn mMSwitchBtn) {
        AppMethodBeat.i(159281);
        mMSwitchBtn.gYT();
        AppMethodBeat.o(159281);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159269);
        init();
        d(context.obtainStyledAttributes(attributeSet, a.C0296a.MMSwitchBtn));
        AppMethodBeat.o(159269);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159270);
        init();
        d(context.obtainStyledAttributes(attributeSet, a.C0296a.MMSwitchBtn));
        AppMethodBeat.o(159270);
    }

    public MMSwitchBtn(Context context) {
        super(context);
        AppMethodBeat.i(159271);
        init();
        AppMethodBeat.o(159271);
    }

    private void init() {
        AppMethodBeat.i(159272);
        this.edgePadding = getResources().getDimensionPixelSize(R.dimen.kb);
        this.QDq = (float) getResources().getDimensionPixelSize(R.dimen.ki);
        this.QDr = (float) getResources().getDimensionPixelSize(R.dimen.kh);
        this.QDs = getResources().getColor(R.color.am);
        this.QDt = getResources().getColor(R.color.aar);
        this.QDu = getResources().getColor(R.color.aas);
        this.QDv = getResources().getColor(R.color.fs);
        this.QDA = this.QDu;
        this.QDz = this.QDt;
        this.QDB = this.QDs;
        this.rZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        AppMethodBeat.o(159272);
    }

    private void d(TypedArray typedArray) {
        AppMethodBeat.i(159273);
        this.QDA = typedArray.getColor(2, this.QDu);
        this.QDz = typedArray.getColor(0, this.QDt);
        this.QDB = typedArray.getColor(4, this.QDs);
        this.QDC = typedArray.getString(3);
        this.QDD = typedArray.getString(1);
        typedArray.recycle();
        AppMethodBeat.o(159273);
    }

    public final boolean isCheck() {
        return this.QDw;
    }

    public void setCheck(boolean z) {
        String string;
        AppMethodBeat.i(159274);
        if (this.QDw != z) {
            clearAnimation();
            this.QDw = z;
            gYS();
            this.QDo = false;
            invalidate();
        }
        if (z) {
            string = getContext().getString(R.string.hjt);
        } else {
            string = getContext().getString(R.string.hk4);
        }
        setContentDescription(string);
        AppMethodBeat.o(159274);
    }

    public void setSwitchListener(a aVar) {
        this.QDF = aVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159275);
        super.onLayout(z, i2, i3, i4, i5);
        this.maxWidth = i4 - i2;
        this.maxHeight = i5 - i3;
        this.QDm = (this.maxWidth - ((int) (this.QDr * 2.0f))) - (this.edgePadding * 2);
        this.QDl = this.QDm / 2;
        this.QDn = getResources().getDimensionPixelSize(R.dimen.kg);
        if (this.QDn < this.maxHeight) {
            this.QDx.top = (float) ((this.maxHeight - this.QDn) / 2);
            this.QDx.bottom = this.QDx.top + ((float) this.QDn);
        } else {
            this.QDx.top = 0.0f;
            this.QDx.bottom = (float) this.maxHeight;
        }
        this.QDx.left = 0.0f;
        this.QDx.right = (float) this.maxWidth;
        gYS();
        this.qvj.setStyle(Paint.Style.FILL);
        this.qvj.setColor(this.QDt);
        AppMethodBeat.o(159275);
    }

    private void gYS() {
        if (this.QDn < this.maxHeight) {
            this.QDy.top = (float) (((this.maxHeight - this.QDn) / 2) + this.edgePadding);
            this.QDy.bottom = (this.QDy.top + ((float) this.QDn)) - ((float) (this.edgePadding * 2));
        } else {
            this.QDy.top = (float) this.edgePadding;
            this.QDy.bottom = (float) (this.maxHeight - this.edgePadding);
        }
        if (this.QDw) {
            this.QDy.left = (float) (this.QDm + this.edgePadding);
            this.QDy.right = (float) (this.maxWidth - this.edgePadding);
            return;
        }
        this.QDy.left = (float) this.edgePadding;
        this.QDy.right = (float) (((int) (this.QDr * 2.0f)) + this.edgePadding);
    }

    private void gYT() {
        if (this.QDy.left < ((float) this.edgePadding)) {
            this.QDy.left = (float) this.edgePadding;
        }
        if (this.QDy.left > ((float) (this.QDm + this.edgePadding))) {
            this.QDy.left = (float) (this.QDm + this.edgePadding);
        }
        this.QDy.right = this.QDy.left + ((float) ((int) (this.QDr * 2.0f)));
    }

    private void CT(boolean z) {
        AppMethodBeat.i(159276);
        this.QDo = true;
        this.QDE.reset();
        if (z) {
            this.QDE.QDG = (((long) this.QDm) - ((long) this.QDy.left)) + ((long) this.edgePadding);
            this.QDE.direction = 1;
        } else {
            this.QDE.QDG = (long) this.QDy.left;
            this.QDE.direction = 0;
        }
        this.QDE.f1558me = this.QDy.left;
        this.QDE.setDuration((80 * this.QDE.QDG) / ((long) this.QDm));
        startAnimation(this.QDE);
        AppMethodBeat.o(159276);
    }

    private void lu(boolean z) {
        AppMethodBeat.i(159277);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(159277);
    }

    private void gYa() {
        AppMethodBeat.i(159278);
        if (this.QDy.left > ((float) this.QDl)) {
            CT(true);
            AppMethodBeat.o(159278);
            return;
        }
        CT(false);
        AppMethodBeat.o(159278);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(159279);
        if (this.QDo) {
            AppMethodBeat.o(159279);
        } else if (!isEnabled()) {
            AppMethodBeat.o(159279);
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.FcB = motionEvent.getX();
                    this.FcC = motionEvent.getY();
                    this.QDk = SystemClock.elapsedRealtime();
                    this.QDp = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.QDk < 300) {
                        CT(!this.QDw);
                    } else {
                        gYa();
                    }
                    lu(false);
                    this.QDp = false;
                    break;
                case 2:
                    if (this.QDp) {
                        lu(true);
                        float x = motionEvent.getX() - this.FcB;
                        RectF rectF = this.QDy;
                        rectF.left = x + rectF.left;
                        gYT();
                    } else {
                        float x2 = motionEvent.getX() - this.FcB;
                        float y = motionEvent.getY() - this.FcC;
                        if (Math.abs(x2) >= ((float) this.rZ) / 10.0f) {
                            if (y == 0.0f) {
                                y = 1.0f;
                            }
                            if (Math.abs(x2 / y) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.QDp = true;
                            lu(true);
                        }
                    }
                    this.FcB = motionEvent.getX();
                    this.FcC = motionEvent.getY();
                    break;
                case 3:
                    if (this.QDp) {
                        gYa();
                    }
                    lu(false);
                    this.QDp = false;
                    break;
            }
            if (this.QDp) {
                invalidate();
            }
            AppMethodBeat.o(159279);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        AppMethodBeat.i(159280);
        if (!isEnabled()) {
            i2 = this.QDv;
            this.qvj.setAlpha(38);
        } else {
            i2 = this.QDz;
            this.qvj.setAlpha(255);
        }
        this.qvj.setColor(i2);
        canvas.drawRoundRect(this.QDx, this.QDq, this.QDq, this.qvj);
        this.qvj.setColor(this.QDA);
        this.qvj.setAlpha(Math.min(255, (int) (((this.QDy.left - ((float) this.edgePadding)) / ((float) this.QDm)) * 255.0f)));
        canvas.drawRoundRect(this.QDx, this.QDq, this.QDq, this.qvj);
        this.qvj.setColor(this.QDB);
        canvas.drawRoundRect(this.QDy, this.QDr, this.QDr, this.qvj);
        if (!(this.QDC == null || this.QDD == null)) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(R.dimen.k6));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getResources().getColor(R.color.ag2));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.QDy.left - ((float) this.edgePadding)) / ((float) this.QDm)) * 255.0f));
            Rect rect = new Rect();
            paint.getTextBounds(this.QDC, 0, this.QDC.length(), rect);
            paint.setAlpha(min);
            float fromDPToPix = (((this.QDx.left + this.QDx.right) / 2.0f) - this.QDr) + ((float) at.fromDPToPix(getContext(), 1));
            float height = ((((float) rect.height()) / 2.0f) + ((this.QDx.top + this.QDx.bottom) / 2.0f)) - ((float) at.fromDPToPix(getContext(), 1));
            canvas.drawText(this.QDC, fromDPToPix, height, paint);
            paint.setAlpha(255 - min);
            canvas.drawText(this.QDD, (((this.QDx.left + this.QDx.right) / 2.0f) + this.QDr) - ((float) at.fromDPToPix(getContext(), 1)), height, paint);
        }
        AppMethodBeat.o(159280);
    }

    /* access modifiers changed from: package-private */
    public class b extends Animation {
        long QDG;
        int direction;

        /* renamed from: me  reason: collision with root package name */
        float f1558me;

        /* synthetic */ b(MMSwitchBtn mMSwitchBtn, byte b2) {
            this();
        }

        private b() {
            AppMethodBeat.i(159267);
            this.direction = 0;
            this.f1558me = 0.0f;
            this.QDG = 0;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new Animation.AnimationListener(MMSwitchBtn.this) {
                /* class com.tencent.mm.ui.widget.MMSwitchBtn.b.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    boolean z = true;
                    AppMethodBeat.i(159266);
                    if (MMSwitchBtn.this.QDw != (b.this.direction == 1)) {
                        MMSwitchBtn mMSwitchBtn = MMSwitchBtn.this;
                        if (b.this.direction != 1) {
                            z = false;
                        }
                        mMSwitchBtn.QDw = z;
                        MMSwitchBtn.this.post(new Runnable() {
                            /* class com.tencent.mm.ui.widget.MMSwitchBtn.b.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(159265);
                                if (MMSwitchBtn.this.QDF != null) {
                                    MMSwitchBtn.this.QDF.onStatusChange(MMSwitchBtn.this.QDw);
                                }
                                AppMethodBeat.o(159265);
                            }
                        });
                    }
                    MMSwitchBtn.this.QDo = false;
                    AppMethodBeat.o(159266);
                }
            });
            AppMethodBeat.o(159267);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(159268);
            if (this.direction == 0) {
                MMSwitchBtn.this.QDy.left = this.f1558me - (((float) this.QDG) * f2);
            } else {
                MMSwitchBtn.this.QDy.left = this.f1558me + (((float) this.QDG) * f2);
            }
            MMSwitchBtn.e(MMSwitchBtn.this);
            MMSwitchBtn.this.invalidate();
            AppMethodBeat.o(159268);
        }
    }
}
