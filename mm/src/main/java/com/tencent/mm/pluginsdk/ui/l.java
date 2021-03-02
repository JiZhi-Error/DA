package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;

public final class l extends Drawable {
    private Drawable Kda = null;
    private Interpolator Kdb = new LinearInterpolator();
    private Interpolator Kdc = new AccelerateDecelerateInterpolator();
    private int Kdd;
    private int Kde;
    private int Kdf;
    private int Kdg;
    private int Kdh;
    private int Kdi;
    private float Kdj = 0.0f;
    private float Kdk = 5.0f;
    private int Kdl;
    private int Kdm;
    private RectF Kdn;
    private ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 100.0f);
    private Context context;
    private int currentState = 2;
    private float mj = -90.0f;
    private float mk = 0.0f;
    private Paint paint = new Paint(1);
    private Random random = new Random(System.currentTimeMillis());
    private float xIk = 0.0f;
    private int xfc = 0;
    private int xfd = 0;
    private int xfe;
    private int xff;
    private int xfg;
    private int xfh;
    private int xfi = 0;
    private boolean xfj = false;
    private int xfk;

    public l(Context context2) {
        AppMethodBeat.i(31245);
        this.animator.setInterpolator(this.Kdb);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.l.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(31244);
                l.this.xIk = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                l.this.invalidateSelf();
                AppMethodBeat.o(31244);
            }
        });
        this.Kdn = new RectF();
        this.context = context2;
        this.xfc = a.n(context2, R.color.afp);
        this.xfd = a.n(context2, R.color.a2t);
        this.Kda = context2.getResources().getDrawable(R.raw.voiceinput_icon_button);
        this.Kdf = a.aH(context2, R.dimen.aoh);
        this.Kdg = a.aH(context2, R.dimen.aog);
        this.Kdh = a.aH(context2, R.dimen.ao7);
        this.xfi = a.aH(context2, R.dimen.aob);
        this.xfe = a.n(context2, R.color.ad7);
        this.Kde = a.aH(context2, R.dimen.ao9);
        this.Kdi = a.aH(context2, R.dimen.ao8);
        this.xfh = a.n(context2, R.color.ad8);
        this.Kdl = this.Kdi;
        this.Kdm = this.Kdl;
        this.xfk = a.aH(context2, R.dimen.aoa);
        this.xff = a.aH(context2, R.dimen.aoa);
        this.xfg = a.aH(context2, R.dimen.ao_);
        this.Kdd = a.aH(context2, R.dimen.aoi);
        AppMethodBeat.o(31245);
    }

    public final void goW() {
        AppMethodBeat.i(31246);
        Log.d("MicroMsg.VoiceInputDrawable", "longClickState %s", Integer.valueOf(this.currentState));
        this.currentState = 7;
        this.animator.cancel();
        this.xIk = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(31246);
    }

    public final void dPL() {
        AppMethodBeat.i(31247);
        Log.d("MicroMsg.VoiceInputDrawable", "readyState %s", Integer.valueOf(this.currentState));
        this.currentState = 2;
        this.animator.cancel();
        this.xIk = 0.0f;
        this.mj = -90.0f;
        this.Kdj = 0.0f;
        this.mk = 0.0f;
        this.Kdk = 5.0f;
        invalidateSelf();
        AppMethodBeat.o(31247);
    }

    public final void goX() {
        AppMethodBeat.i(31248);
        Log.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", Integer.valueOf(this.currentState));
        this.currentState = 6;
        this.animator.cancel();
        this.xIk = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(31248);
    }

    public final void zP(boolean z) {
        AppMethodBeat.i(31249);
        Log.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", 0, Boolean.valueOf(z));
        if (!z) {
            this.currentState = 3;
        }
        this.xfj = true;
        invalidateSelf();
        AppMethodBeat.o(31249);
    }

    public final void aic(int i2) {
        boolean z = true;
        AppMethodBeat.i(31250);
        Log.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i2));
        if (i2 >= 28) {
            z = false;
        }
        this.xfj = z;
        invalidateSelf();
        AppMethodBeat.o(31250);
    }

    public final void goY() {
        AppMethodBeat.i(31251);
        Log.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", Integer.valueOf(this.currentState));
        this.currentState = 4;
        this.animator.cancel();
        this.xIk = 0.0f;
        this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animator.setDuration(1000L);
        this.animator.setRepeatCount(-1);
        this.animator.start();
        AppMethodBeat.o(31251);
    }

    public final void goZ() {
        AppMethodBeat.i(31252);
        Log.d("MicroMsg.VoiceInputDrawable", "disableState %s", Integer.valueOf(this.currentState));
        this.currentState = 5;
        this.animator.cancel();
        this.xIk = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(31252);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(31253);
        if ((this.currentState == 6 || this.currentState == 7) && !s(canvas)) {
            int width = canvas.getWidth() >> 1;
            int height = canvas.getHeight() >> 1;
            this.paint.setShader(null);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.xfe);
            if (this.currentState == 7) {
                if (this.xfj) {
                    this.xfk -= 4;
                } else {
                    this.xfk += 4;
                }
                this.xfk = Math.min(Math.max(this.xff, this.xfk), this.xfg);
                canvas.drawCircle((float) width, (float) height, (float) this.xfk, this.paint);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.xff, this.paint);
            }
        }
        if (this.Kda != null && !s(canvas)) {
            if (this.currentState == 5) {
                this.Kda.setColorFilter(this.xfd, PorterDuff.Mode.SRC_ATOP);
            } else {
                this.Kda.setColorFilter(this.xfc, PorterDuff.Mode.SRC_ATOP);
            }
            int width2 = canvas.getWidth() / 2;
            int height2 = canvas.getHeight() / 2;
            this.Kda.setBounds(width2 - this.xfi, height2 - this.xfi, width2 + this.xfi, height2 + this.xfi);
            this.Kda.draw(canvas);
        }
        if (this.currentState == 4 && canvas != null) {
            this.paint.setColor(this.xfc);
            this.paint.setStrokeWidth((float) this.Kdd);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.clearShadowLayer();
            this.paint.setShader(null);
            this.Kdn.left = (float) ((canvas.getWidth() / 2) - this.Kdi);
            this.Kdn.top = (float) ((canvas.getHeight() / 2) - this.Kdi);
            this.Kdn.right = (float) ((canvas.getWidth() / 2) + this.Kdi);
            this.Kdn.bottom = (float) ((canvas.getHeight() / 2) + this.Kdi);
            canvas.drawArc(this.Kdn, this.mj, this.mk, false, this.paint);
            this.mj += this.Kdj;
            this.mk += this.Kdk;
            if (this.mk >= 360.0f) {
                this.Kdk = -this.Kdk;
                this.Kdj = 5.0f;
            } else if (this.mk <= 0.0f) {
                this.Kdk = -this.Kdk;
                this.Kdj = 0.0f;
                this.mj = -90.0f;
                this.mk = 0.0f;
            }
        }
        if ((this.currentState == 6 || this.currentState == 7) && !s(canvas)) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.xfh);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.xfi, this.paint);
        }
        AppMethodBeat.o(31253);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(31254);
        if (this.context == null) {
            AppMethodBeat.o(31254);
            return 0;
        }
        int jn = a.jn(this.context);
        AppMethodBeat.o(31254);
        return jn;
    }

    public final int getIntrinsicHeight() {
        return this.xfi * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean s(Canvas canvas) {
        AppMethodBeat.i(31255);
        if (canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0) {
            AppMethodBeat.o(31255);
            return true;
        }
        AppMethodBeat.o(31255);
        return false;
    }
}
