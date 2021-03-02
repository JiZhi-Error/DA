package com.robinhood.ticker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.robinhood.ticker.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.HashSet;

public class TickerView extends View {
    private static final Interpolator cgY = new AccelerateDecelerateInterpolator();
    private final ValueAnimator animator = ValueAnimator.ofFloat(1.0f);
    private final f cgE = new f(this.cgU);
    protected final Paint cgU = new TextPaint(1);
    private final e cgZ = new e(this.cgE);
    private final Rect cha = new Rect();
    private int chb;
    private int chc;
    private long chd;
    private long che;
    private Interpolator chf;
    private boolean chg;
    private String chh;
    private int gravity;
    private String text;
    private int textColor;
    private float textSize;
    private int textStyle;

    static /* synthetic */ void b(TickerView tickerView) {
        AppMethodBeat.i(39884);
        tickerView.IR();
        AppMethodBeat.o(39884);
    }

    public enum a {
        ANY,
        UP,
        DOWN;

        public static a valueOf(String str) {
            AppMethodBeat.i(39862);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(39862);
            return aVar;
        }

        static {
            AppMethodBeat.i(39863);
            AppMethodBeat.o(39863);
        }
    }

    static {
        AppMethodBeat.i(39885);
        AppMethodBeat.o(39885);
    }

    public TickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39866);
        b(context, attributeSet, 0);
        AppMethodBeat.o(39866);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39867);
        b(context, attributeSet, i2);
        AppMethodBeat.o(39867);
    }

    private void b(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(39868);
        b bVar = new b(context.getResources());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.TickerView, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, b.a.TickerView);
            bVar.c(obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        }
        bVar.c(obtainStyledAttributes);
        this.chf = cgY;
        this.che = (long) obtainStyledAttributes.getInt(11, 350);
        this.chg = obtainStyledAttributes.getBoolean(10, false);
        this.gravity = bVar.gravity;
        if (bVar.shadowColor != 0) {
            this.cgU.setShadowLayer(bVar.shadowRadius, bVar.ly, bVar.lz, bVar.shadowColor);
        }
        if (bVar.textStyle != 0) {
            this.textStyle = bVar.textStyle;
            setTypeface(this.cgU.getTypeface());
        }
        setTextColor(bVar.textColor);
        setTextSize(bVar.textSize);
        switch (obtainStyledAttributes.getInt(12, 0)) {
            case 1:
                setCharacterLists("0123456789");
                break;
            case 2:
                setCharacterLists("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            default:
                if (isInEditMode()) {
                    setCharacterLists("0123456789");
                    break;
                }
                break;
        }
        int i3 = obtainStyledAttributes.getInt(13, 0);
        switch (i3) {
            case 0:
                this.cgE.cgX = a.ANY;
                break;
            case 1:
                this.cgE.cgX = a.UP;
                break;
            case 2:
                this.cgE.cgX = a.DOWN;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: ".concat(String.valueOf(i3)));
                AppMethodBeat.o(39868);
                throw illegalArgumentException;
        }
        if (IQ()) {
            setText(bVar.text, false);
        } else {
            this.chh = bVar.text;
        }
        obtainStyledAttributes.recycle();
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.robinhood.ticker.TickerView.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(39859);
                TickerView.this.cgZ.setAnimationProgress(valueAnimator.getAnimatedFraction());
                TickerView.b(TickerView.this);
                TickerView.this.invalidate();
                AppMethodBeat.o(39859);
            }
        });
        this.animator.addListener(new AnimatorListenerAdapter() {
            /* class com.robinhood.ticker.TickerView.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(39860);
                TickerView.this.cgZ.onAnimationEnd();
                TickerView.b(TickerView.this);
                TickerView.this.invalidate();
                AppMethodBeat.o(39860);
            }
        });
        AppMethodBeat.o(39868);
    }

    /* access modifiers changed from: package-private */
    public class b {
        int gravity;
        float ly;
        float lz;
        int shadowColor;
        float shadowRadius;
        String text;
        int textColor = WebView.NIGHT_MODE_COLOR;
        float textSize;
        int textStyle;

        b(Resources resources) {
            AppMethodBeat.i(39864);
            this.textSize = TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics());
            this.gravity = 8388611;
            AppMethodBeat.o(39864);
        }

        /* access modifiers changed from: package-private */
        public final void c(TypedArray typedArray) {
            AppMethodBeat.i(39865);
            this.gravity = typedArray.getInt(4, this.gravity);
            this.shadowColor = typedArray.getColor(6, this.shadowColor);
            this.ly = typedArray.getFloat(7, this.ly);
            this.lz = typedArray.getFloat(8, this.lz);
            this.shadowRadius = typedArray.getFloat(9, this.shadowRadius);
            this.text = typedArray.getString(5);
            this.textColor = typedArray.getColor(3, this.textColor);
            this.textSize = typedArray.getDimension(1, this.textSize);
            this.textStyle = typedArray.getInt(2, this.textStyle);
            AppMethodBeat.o(39865);
        }
    }

    public void setCharacterLists(String... strArr) {
        AppMethodBeat.i(39869);
        e eVar = this.cgZ;
        eVar.cgD = new c[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            eVar.cgD[i2] = new c(strArr[i2]);
        }
        eVar.cgT = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            eVar.cgT.addAll(eVar.cgD[i3].cgA.keySet());
        }
        if (this.chh != null) {
            setText(this.chh, false);
            this.chh = null;
        }
        AppMethodBeat.o(39869);
    }

    private boolean IQ() {
        return this.cgZ.cgD != null;
    }

    public void setText(String str) {
        AppMethodBeat.i(39870);
        setText(str, !TextUtils.isEmpty(this.text));
        AppMethodBeat.o(39870);
    }

    public final void setText(String str, boolean z) {
        AppMethodBeat.i(39871);
        if (TextUtils.equals(str, this.text)) {
            AppMethodBeat.o(39871);
            return;
        }
        this.text = str;
        this.cgZ.b(str == null ? new char[0] : str.toCharArray());
        setContentDescription(str);
        if (z) {
            if (this.animator.isRunning()) {
                this.animator.cancel();
            }
            this.animator.setStartDelay(this.chd);
            this.animator.setDuration(this.che);
            this.animator.setInterpolator(this.chf);
            this.animator.start();
            AppMethodBeat.o(39871);
            return;
        }
        this.cgZ.setAnimationProgress(1.0f);
        this.cgZ.onAnimationEnd();
        IR();
        invalidate();
        AppMethodBeat.o(39871);
    }

    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(39872);
        if (this.textColor != i2) {
            this.textColor = i2;
            this.cgU.setColor(this.textColor);
            invalidate();
        }
        AppMethodBeat.o(39872);
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(39873);
        if (this.textSize != f2) {
            this.textSize = f2;
            this.cgU.setTextSize(f2);
            IU();
        }
        AppMethodBeat.o(39873);
    }

    public Typeface getTypeface() {
        AppMethodBeat.i(39874);
        Typeface typeface = this.cgU.getTypeface();
        AppMethodBeat.o(39874);
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(39875);
        if (this.textStyle == 3) {
            typeface = Typeface.create(typeface, 3);
        } else if (this.textStyle == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (this.textStyle == 2) {
            typeface = Typeface.create(typeface, 2);
        }
        this.cgU.setTypeface(typeface);
        IU();
        AppMethodBeat.o(39875);
    }

    public long getAnimationDelay() {
        return this.chd;
    }

    public void setAnimationDelay(long j2) {
        this.chd = j2;
    }

    public long getAnimationDuration() {
        return this.che;
    }

    public void setAnimationDuration(long j2) {
        this.che = j2;
    }

    public Interpolator getAnimationInterpolator() {
        return this.chf;
    }

    public void setAnimationInterpolator(Interpolator interpolator) {
        this.chf = interpolator;
    }

    public void setPreferredScrollingDirection(a aVar) {
        this.cgE.cgX = aVar;
    }

    public int getGravity() {
        return this.gravity;
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(39876);
        if (this.gravity != i2) {
            this.gravity = i2;
            invalidate();
        }
        AppMethodBeat.o(39876);
    }

    public void setAnimateMeasurementChange(boolean z) {
        this.chg = z;
    }

    public boolean getAnimateMeasurementChange() {
        return this.chg;
    }

    private void IR() {
        boolean z = true;
        AppMethodBeat.i(39877);
        boolean z2 = this.chb != IS();
        if (this.chc == IT()) {
            z = false;
        }
        if (z2 || z) {
            requestLayout();
        }
        AppMethodBeat.o(39877);
    }

    private int IS() {
        AppMethodBeat.i(39878);
        int IM = ((int) (this.chg ? this.cgZ.IM() : this.cgZ.IO())) + getPaddingLeft() + getPaddingRight();
        AppMethodBeat.o(39878);
        return IM;
    }

    private int IT() {
        AppMethodBeat.i(39879);
        int paddingTop = ((int) this.cgE.cgK) + getPaddingTop() + getPaddingBottom();
        AppMethodBeat.o(39879);
        return paddingTop;
    }

    private void IU() {
        AppMethodBeat.i(39880);
        this.cgE.invalidate();
        IR();
        invalidate();
        AppMethodBeat.o(39880);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(39881);
        this.chb = IS();
        this.chc = IT();
        setMeasuredDimension(resolveSize(this.chb, i2), resolveSize(this.chc, i3));
        AppMethodBeat.o(39881);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(39882);
        super.onSizeChanged(i2, i3, i4, i5);
        this.cha.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        AppMethodBeat.o(39882);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39883);
        super.onDraw(canvas);
        canvas.save();
        float IM = this.cgZ.IM();
        float f2 = this.cgE.cgK;
        int i2 = this.gravity;
        Rect rect = this.cha;
        int width = rect.width();
        int height = rect.height();
        float f3 = (i2 & 16) == 16 ? ((((float) height) - f2) / 2.0f) + ((float) rect.top) : 0.0f;
        float f4 = (i2 & 1) == 1 ? ((float) rect.left) + ((((float) width) - IM) / 2.0f) : 0.0f;
        if ((i2 & 48) == 48) {
            f3 = 0.0f;
        }
        if ((i2 & 80) == 80) {
            f3 = ((float) rect.top) + (((float) height) - f2);
        }
        if ((i2 & 8388611) == 8388611) {
            f4 = 0.0f;
        }
        if ((i2 & 8388613) == 8388613) {
            f4 = ((float) rect.left) + (((float) width) - IM);
        }
        canvas.translate(f4, f3);
        canvas.clipRect(0.0f, 0.0f, IM, f2);
        canvas.translate(0.0f, this.cgE.cgW);
        e eVar = this.cgZ;
        Paint paint = this.cgU;
        int size = eVar.cgS.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = eVar.cgS.get(i3);
            if (d.a(canvas, paint, dVar.cgH, dVar.cgI, dVar.cgJ)) {
                if (dVar.cgI >= 0) {
                    dVar.cgF = dVar.cgH[dVar.cgI];
                }
                dVar.cgP = dVar.cgJ;
            }
            d.a(canvas, paint, dVar.cgH, dVar.cgI + 1, dVar.cgJ - dVar.cgK);
            d.a(canvas, paint, dVar.cgH, dVar.cgI - 1, dVar.cgJ + dVar.cgK);
            canvas.translate(dVar.IM(), 0.0f);
        }
        canvas.restore();
        AppMethodBeat.o(39883);
    }
}
