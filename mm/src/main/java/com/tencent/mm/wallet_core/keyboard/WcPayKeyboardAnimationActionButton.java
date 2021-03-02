package com.tencent.mm.wallet_core.keyboard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayKeyboardAnimationActionButton extends View {
    AnimatorSet CPA = new AnimatorSet();
    private int GyC;
    private int GyD;
    private int Lcf = getResources().getColor(R.color.ag5);
    private int Lcg = getResources().getColor(R.color.afp);
    private ColorStateList RsF;
    private ColorStateList RsG;
    private int RsH = 17;
    private int RsI;
    private int RsJ;
    private int RsK;
    private int RsL;
    private int RsM;
    private int RsN;
    private int RsO = 300;
    private int RsP = 300;
    String RsQ = "";
    private float RsR;
    private float RsS;
    boolean RsT = true;
    private int RsU;
    private int RsV;
    private RectF RsW = new RectF();
    private Rect RsX = new Rect();
    private ObjectAnimator RsY;
    private ValueAnimator RsZ;
    private ValueAnimator Rta;
    private ObjectAnimator Rtb;
    private ValueAnimator Rtc;
    private ValueAnimator Rtd;
    AnimatorSet Rte = new AnimatorSet();
    private Paint cgU;
    private Context context;
    private int height;
    private Paint lup;
    private int width;

    public WcPayKeyboardAnimationActionButton(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(72701);
        init();
        AppMethodBeat.o(72701);
    }

    public WcPayKeyboardAnimationActionButton(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(72702);
        init();
        AppMethodBeat.o(72702);
    }

    private void init() {
        AppMethodBeat.i(72703);
        amZ();
        hhg();
        AppMethodBeat.o(72703);
    }

    private void amZ() {
        AppMethodBeat.i(72704);
        this.context = MMApplicationContext.getContext();
        this.RsI = a.fromDPToPix(this.context, 4);
        this.RsJ = a.fromDPToPix(this.context, 16);
        this.RsK = a.fromDPToPix(this.context, 64);
        this.RsL = a.fromDPToPix(this.context, 96);
        this.RsF = getResources().getColorStateList(R.color.afp);
        this.RsG = getResources().getColorStateList(R.color.ag5);
        AppMethodBeat.o(72704);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(72705);
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(72705);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(72706);
        super.onDraw(canvas);
        int[] drawableState = getDrawableState();
        int colorForState = this.RsG.getColorForState(drawableState, this.Lcf);
        int colorForState2 = this.RsF.getColorForState(drawableState, this.Lcg);
        this.cgU.setColor(colorForState);
        this.lup.setColor(colorForState2);
        this.RsW.left = 0.0f;
        this.RsW.top = (float) ((this.height - this.RsM) / 2);
        this.RsW.right = (float) this.RsN;
        this.RsW.bottom = (float) ((this.height + this.RsM) / 2);
        Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", Float.valueOf(this.RsW.left), Float.valueOf(this.RsW.top), Float.valueOf(this.RsW.right), Float.valueOf(this.RsW.bottom), Integer.valueOf(this.RsI));
        canvas.drawRoundRect(this.RsW, (float) this.RsI, (float) this.RsI, this.lup);
        this.RsX.left = 0;
        this.RsX.top = 0;
        this.RsX.right = this.RsN;
        this.RsX.bottom = this.height;
        Paint.FontMetricsInt fontMetricsInt = this.cgU.getFontMetricsInt();
        canvas.drawText(this.RsQ, (float) this.RsX.centerX(), (float) ((((this.RsX.bottom + this.RsX.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2), this.cgU);
        AppMethodBeat.o(72706);
    }

    private void hgW() {
        AppMethodBeat.i(72707);
        this.RsS = getTranslationX();
        this.RsR = this.RsS - ((float) this.RsJ);
        AppMethodBeat.o(72707);
    }

    private void T(int i2, int i3, int i4, int i5) {
        this.GyC = i2;
        this.GyD = i3;
        this.RsU = i4;
        this.RsV = i5;
    }

    public final void hgX() {
        AppMethodBeat.i(72708);
        U(this.GyC, this.GyD, this.RsU, this.RsV);
        AppMethodBeat.o(72708);
    }

    public final void U(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(72709);
        if (this.RsT) {
            this.RsT = false;
            T(i2, i3, i4, i5);
            hgW();
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        layoutParams.bottomMargin = i4;
        setLayoutParams(layoutParams);
        this.width = i2;
        this.height = i3;
        Log.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", Integer.valueOf(this.width), Integer.valueOf(this.height));
        this.RsN = i2;
        hgZ();
        AppMethodBeat.o(72709);
    }

    public final boolean hgY() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(72710);
        if (this.CPA == null) {
            z = false;
        } else if (this.Rta == null || this.RsZ == null || this.RsY == null) {
            z = false;
        } else {
            z = this.CPA.isRunning();
        }
        if (this.Rte == null) {
            z2 = false;
        } else if (this.Rtd == null || this.Rtc == null || this.Rtb == null) {
            z2 = false;
        } else {
            z2 = this.Rte.isRunning();
        }
        if (z || z2) {
            AppMethodBeat.o(72710);
            return true;
        }
        AppMethodBeat.o(72710);
        return false;
    }

    private void hgZ() {
        AppMethodBeat.i(72711);
        hha();
        hhb();
        hhc();
        this.CPA = new AnimatorSet();
        this.CPA.play(this.Rta).with(this.RsY);
        AppMethodBeat.o(72711);
    }

    private void hha() {
        AppMethodBeat.i(72712);
        if (this.RsY == null) {
            this.RsY = ObjectAnimator.ofFloat(this, "translationX", this.RsS, this.RsR);
            this.RsY.setDuration((long) this.RsO);
            this.RsY.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AppMethodBeat.o(72712);
    }

    private void hhb() {
        AppMethodBeat.i(72713);
        this.RsM = this.height;
        if (this.Rta == null) {
            this.Rta = ValueAnimator.ofInt(this.height, this.RsK);
            this.Rta.setDuration((long) this.RsP);
            this.Rta.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(72698);
                    WcPayKeyboardAnimationActionButton.this.RsM = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", Integer.valueOf(WcPayKeyboardAnimationActionButton.this.RsM));
                    WcPayKeyboardAnimationActionButton.this.invalidate();
                    AppMethodBeat.o(72698);
                }
            });
        }
        AppMethodBeat.o(72713);
    }

    private void hhc() {
        AppMethodBeat.i(72714);
        this.RsN = this.width;
        if (this.RsZ == null) {
            this.RsZ = ValueAnimator.ofInt(this.width, this.RsL);
            this.RsZ.setDuration((long) this.RsP);
            this.RsZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(72699);
                    WcPayKeyboardAnimationActionButton.this.RsN = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", Integer.valueOf(WcPayKeyboardAnimationActionButton.this.RsN));
                    WcPayKeyboardAnimationActionButton.this.invalidate();
                    AppMethodBeat.o(72699);
                }
            });
        }
        AppMethodBeat.o(72714);
    }

    public final void hhd() {
        AppMethodBeat.i(72715);
        hhe();
        hhf();
        this.Rte = new AnimatorSet();
        this.Rte.play(this.Rtd).with(this.Rtb);
        AppMethodBeat.o(72715);
    }

    private void hhe() {
        AppMethodBeat.i(72716);
        if (this.Rtb == null) {
            this.Rtb = ObjectAnimator.ofFloat(this, "translationX", this.RsR, this.RsS);
            this.Rtb.setDuration((long) this.RsO);
            this.Rtb.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AppMethodBeat.o(72716);
    }

    private void hhf() {
        AppMethodBeat.i(72717);
        this.RsM = this.RsK;
        if (this.Rtd == null) {
            this.Rtd = ValueAnimator.ofInt(this.RsK, this.height);
            this.Rtd.setDuration((long) this.RsP);
            this.Rtd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(72700);
                    WcPayKeyboardAnimationActionButton.this.RsM = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", Integer.valueOf(WcPayKeyboardAnimationActionButton.this.RsM));
                    WcPayKeyboardAnimationActionButton.this.invalidate();
                    AppMethodBeat.o(72700);
                }
            });
        }
        AppMethodBeat.o(72717);
    }

    private void hhg() {
        AppMethodBeat.i(72718);
        this.lup = new Paint();
        this.lup.setStrokeWidth(4.0f);
        this.lup.setStyle(Paint.Style.FILL);
        this.lup.setAntiAlias(true);
        this.lup.setColor(this.Lcg);
        this.cgU = new Paint(1);
        this.cgU.setTextSize(((float) a.fromDPToPix(this.context, this.RsH)) * a.ez(this.context));
        this.cgU.setColor(this.Lcf);
        this.cgU.setTextAlign(Paint.Align.CENTER);
        this.cgU.setAntiAlias(true);
        this.cgU.setFakeBoldText(true);
        AppMethodBeat.o(72718);
    }

    public final void hhh() {
        AppMethodBeat.i(72719);
        this.RsI = a.fromDPToPix(this.context, 4);
        this.RsM = this.height;
        this.RsN = this.width;
        setTranslationX(getTranslationX() + ((float) this.RsJ));
        invalidate();
        AppMethodBeat.o(72719);
    }
}
