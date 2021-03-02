package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TimeCropSliderSeekBar extends View {
    private a GLW;
    private Paint GLX;
    private Paint GLY;
    private int GLZ;
    private int GMa;
    private boolean GMb;
    private View.OnTouchListener aZa;
    private Paint borderPaint;
    private int padding;
    private int rc;
    private float zxA;
    private int zxB;
    private float zxC;
    private int zxD;
    private Paint zxE;
    private float zxF;
    private Paint zxH;
    private int zxI;
    private float zxJ;
    private float zxK;
    private float zxL;
    private int zxM;
    private Rect zxN;
    private Rect zxO;
    private boolean zxP;
    private boolean zxr;
    private boolean zxs;
    private int zxt;
    private int zxu;
    private boolean zxv;
    private boolean zxw;
    private Drawable zxx;
    private Drawable zxy;
    private int zxz;

    public interface a {
        void ekz();

        void fEi();
    }

    static /* synthetic */ boolean a(TimeCropSliderSeekBar timeCropSliderSeekBar, boolean z) {
        AppMethodBeat.i(190469);
        boolean re = timeCropSliderSeekBar.re(z);
        AppMethodBeat.o(190469);
        return re;
    }

    static /* synthetic */ void c(TimeCropSliderSeekBar timeCropSliderSeekBar) {
        AppMethodBeat.i(190467);
        timeCropSliderSeekBar.fEh();
        AppMethodBeat.o(190467);
    }

    public TimeCropSliderSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeCropSliderSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(190455);
        this.zxr = false;
        this.zxs = false;
        this.zxv = false;
        this.zxw = false;
        this.zxC = -1.0f;
        this.GLZ = 0;
        this.GMa = 0;
        this.zxK = -1.0f;
        this.zxL = -1.0f;
        this.padding = 0;
        this.GMb = true;
        this.zxP = true;
        this.aZa = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar.AnonymousClass2 */
            boolean GMd = false;
            float GMe;
            float GMf;
            float deo;
            float dep;
            boolean gZT = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(190451);
                if (!TimeCropSliderSeekBar.this.zxr) {
                    AppMethodBeat.o(190451);
                    return false;
                }
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.deo = motionEvent.getX();
                        this.dep = motionEvent.getY();
                        this.GMe = (float) TimeCropSliderSeekBar.this.zxx.getBounds().centerX();
                        this.GMf = (float) TimeCropSliderSeekBar.this.zxy.getBounds().centerX();
                        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.deo, this.dep)) {
                            this.GMd = true;
                            this.gZT = true;
                            AppMethodBeat.o(190451);
                            return true;
                        } else if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.this.zxx, this.deo, this.dep)) {
                            if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true)) {
                                AppMethodBeat.o(190451);
                                return false;
                            }
                            if (TimeCropSliderSeekBar.this.GLW != null) {
                                a unused = TimeCropSliderSeekBar.this.GLW;
                            }
                            TimeCropSliderSeekBar.this.zxK = (float) TimeCropSliderSeekBar.this.zxx.getBounds().left;
                            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
                            this.gZT = true;
                            AppMethodBeat.o(190451);
                            return true;
                        } else if (!TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.this.zxy, this.deo, this.dep)) {
                            AppMethodBeat.o(190451);
                            return false;
                        } else if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false)) {
                            AppMethodBeat.o(190451);
                            return false;
                        } else {
                            if (TimeCropSliderSeekBar.this.GLW != null) {
                                a unused2 = TimeCropSliderSeekBar.this.GLW;
                            }
                            TimeCropSliderSeekBar.this.zxL = (float) TimeCropSliderSeekBar.this.zxy.getBounds().right;
                            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
                            this.gZT = true;
                            AppMethodBeat.o(190451);
                            return true;
                        }
                    case 1:
                    case 3:
                        if (!this.gZT) {
                            AppMethodBeat.o(190451);
                            return false;
                        }
                        if (TimeCropSliderSeekBar.this.GLW != null) {
                            a aVar = TimeCropSliderSeekBar.this.GLW;
                            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
                            aVar.ekz();
                        }
                        TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
                        TimeCropSliderSeekBar.this.zxv = false;
                        this.gZT = false;
                        this.GMd = false;
                        AppMethodBeat.o(190451);
                        return true;
                    case 2:
                        if (!this.gZT) {
                            AppMethodBeat.o(190451);
                            return false;
                        } else if (this.GMd) {
                            float x = motionEvent.getX() - this.deo;
                            if (x > 0.0f) {
                                float min = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.GMf + x) - this.GMf, x);
                                TimeCropSliderSeekBar.this.b(false, this.GMf + min);
                                TimeCropSliderSeekBar.this.b(true, min + this.GMe);
                            } else {
                                float max = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.GMe + x) - this.GMe, x);
                                TimeCropSliderSeekBar.this.b(true, this.GMe + max);
                                TimeCropSliderSeekBar.this.b(false, max + this.GMf);
                            }
                            TimeCropSliderSeekBar.this.GLW.fEi();
                            AppMethodBeat.o(190451);
                            return true;
                        } else if (TimeCropSliderSeekBar.this.zxs) {
                            AppMethodBeat.o(190451);
                            return true;
                        } else {
                            boolean b2 = TimeCropSliderSeekBar.this.b(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), motionEvent.getX());
                            if (TimeCropSliderSeekBar.this.zxw && b2 && !TimeCropSliderSeekBar.this.zxv) {
                                TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
                            }
                            TimeCropSliderSeekBar.this.zxv = b2;
                            if (TimeCropSliderSeekBar.this.GLW != null) {
                                TimeCropSliderSeekBar.this.GLW.fEi();
                            }
                            AppMethodBeat.o(190451);
                            return true;
                        }
                    default:
                        AppMethodBeat.o(190451);
                        return false;
                }
            }
        };
        this.zxz = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.zxA = ((float) this.zxz) * 0.5f;
        this.zxM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        this.zxx = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxy = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxP = true;
        postInvalidate();
        this.zxB = com.tencent.mm.cb.a.fromDPToPix(getContext(), 2);
        this.zxD = com.tencent.mm.cb.a.aG(getContext(), R.dimen.anl);
        this.zxC = -1.0f;
        this.zxE = new Paint();
        this.zxE.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.am));
        this.zxE.setAlpha(102);
        this.GLX = new Paint();
        this.GLX.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        this.GLX.setAlpha(102);
        this.GLY = new Paint();
        this.GLY.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.Orange));
        this.GLY.setAlpha(102);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.afz));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.rc = gz(getContext());
        this.borderPaint.setStrokeWidth((float) this.rc);
        this.zxF = ((float) this.rc) * 0.5f;
        this.zxH = new Paint();
        this.zxH.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.afz));
        this.zxH.setStyle(Paint.Style.STROKE);
        this.zxI = gz(getContext());
        this.zxJ = ((float) this.zxI) * 0.5f;
        this.zxH.setStrokeWidth((float) this.zxI);
        this.zxH.setAlpha(178);
        setOnTouchListener(this.aZa);
        AppMethodBeat.o(190455);
    }

    private static int gz(Context context) {
        AppMethodBeat.i(190456);
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        AppMethodBeat.o(190456);
        return round;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(190457);
        if (this.zxC > 0.0f) {
            float width = ((float) getWidth()) * this.zxC;
            canvas.drawRect(width - (((float) this.zxB) * 0.5f), (float) this.GLZ, (((float) this.zxB) * 0.5f) + width, (float) ((this.zxP ? getHeight() : this.GMa) + this.GLZ), this.zxE);
        }
        if (!this.zxr) {
            AppMethodBeat.o(190457);
            return;
        }
        int centerX = this.zxx.getBounds().centerX();
        int centerX2 = this.zxy.getBounds().centerX();
        if ((re(true) || re(false)) && this.zxP) {
            canvas.drawRect(this.zxJ + ((float) this.padding), this.zxJ, ((float) (getWidth() - this.padding)) - this.zxJ, ((float) getBottom()) - this.zxJ, this.zxH);
        }
        if (this.zxx.getBounds().left > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.GLX);
        }
        if (this.zxy.getBounds().right < getWidth()) {
            canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.GLX);
        }
        if (this.GMb && this.GMa != 0) {
            canvas.drawRect((float) centerX, (float) (this.GLZ - getTop()), (float) centerX2, (float) ((this.GLZ + this.GMa) - getTop()), this.GLY);
        }
        if (this.zxP) {
            canvas.drawLine((float) centerX, this.zxF, (float) centerX2, this.zxF, this.borderPaint);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.zxF, (float) centerX2, ((float) getHeight()) - this.zxF, this.borderPaint);
        }
        this.zxx.draw(canvas);
        this.zxy.draw(canvas);
        AppMethodBeat.o(190457);
    }

    public void setCursorPos(float f2) {
        AppMethodBeat.i(190458);
        if (!this.zxr) {
            AppMethodBeat.o(190458);
            return;
        }
        this.zxC = f2;
        invalidate();
        AppMethodBeat.o(190458);
    }

    public final void ao(final int i2, final int i3, final int i4) {
        AppMethodBeat.i(190459);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(190450);
                if (i2 <= TimeCropSliderSeekBar.this.zxz * 2) {
                    IllegalStateException illegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                    AppMethodBeat.o(190450);
                    throw illegalStateException;
                }
                TimeCropSliderSeekBar.this.zxr = true;
                TimeCropSliderSeekBar.this.padding = i4;
                TimeCropSliderSeekBar.this.zxt = Math.min(i2, TimeCropSliderSeekBar.this.getWidth() - (i4 * 2));
                TimeCropSliderSeekBar.this.zxu = Math.max(i3, TimeCropSliderSeekBar.this.zxz * 2);
                TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this);
                if (TimeCropSliderSeekBar.this.zxN == null && TimeCropSliderSeekBar.this.zxO == null) {
                    TimeCropSliderSeekBar.this.zxN = new Rect(TimeCropSliderSeekBar.this.zxx.getBounds().left, TimeCropSliderSeekBar.this.zxx.getBounds().top, TimeCropSliderSeekBar.this.zxx.getBounds().right, TimeCropSliderSeekBar.this.zxx.getBounds().bottom);
                    TimeCropSliderSeekBar.this.zxO = new Rect(TimeCropSliderSeekBar.this.zxy.getBounds().left, TimeCropSliderSeekBar.this.zxy.getBounds().top, TimeCropSliderSeekBar.this.zxy.getBounds().right, TimeCropSliderSeekBar.this.zxy.getBounds().bottom);
                }
                TimeCropSliderSeekBar.this.invalidate();
                AppMethodBeat.o(190450);
            }
        });
        AppMethodBeat.o(190459);
    }

    public void setContentTop(int i2) {
        this.GLZ = i2;
    }

    public void setContentHeight(int i2) {
        this.GMa = i2;
    }

    public final void ekA() {
        this.zxs = true;
    }

    public final void ekB() {
        this.zxs = false;
    }

    public void setMaskColor(int i2) {
        AppMethodBeat.i(190460);
        this.GLX.setColor(i2);
        AppMethodBeat.o(190460);
    }

    public void setEnableHapticAtEdge(boolean z) {
        this.zxw = z;
    }

    private boolean re(boolean z) {
        AppMethodBeat.i(190461);
        if (z) {
            boolean z2 = ((b) this.zxx).isPressed;
            AppMethodBeat.o(190461);
            return z2;
        }
        boolean z3 = ((b) this.zxy).isPressed;
        AppMethodBeat.o(190461);
        return z3;
    }

    public final boolean b(boolean z, float f2) {
        float f3;
        float min;
        boolean z2;
        AppMethodBeat.i(190462);
        if (!this.zxr || this.zxx == null || this.zxy == null || this.zxx.getBounds().width() <= 0 || this.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(190462);
            return false;
        }
        if (z) {
            min = this.zxA + ((float) (this.zxy.getBounds().right - this.zxu));
            f3 = Math.max((float) this.padding, ((float) (this.zxy.getBounds().right - this.zxt)) - this.zxA);
        } else {
            f3 = ((float) (this.zxx.getBounds().left + this.zxu)) - this.zxA;
            min = Math.min((float) (getWidth() - this.padding), ((float) (this.zxx.getBounds().left + this.zxt)) + this.zxA);
        }
        float max = Math.max(f3, Math.min(f2, min));
        if (max == f3 || max == min) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            Rect bounds = this.zxx.getBounds();
            bounds.offsetTo((int) Math.ceil((double) (max - this.zxA)), 0);
            this.zxx.setBounds(bounds);
        } else {
            Rect bounds2 = this.zxy.getBounds();
            bounds2.offsetTo((int) Math.floor((double) (max - this.zxA)), 0);
            this.zxy.setBounds(bounds2);
        }
        postInvalidate();
        AppMethodBeat.o(190462);
        return z2;
    }

    public int getLeftSliderBound() {
        AppMethodBeat.i(190463);
        int i2 = (int) (((float) this.zxx.getBounds().left) + this.zxA);
        AppMethodBeat.o(190463);
        return i2;
    }

    public int getRightSliderBound() {
        AppMethodBeat.i(190464);
        int i2 = (int) (((float) this.zxy.getBounds().right) - this.zxA);
        AppMethodBeat.o(190464);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public class b extends Drawable {
        boolean isPressed = false;
        private Drawable zxV;
        private Drawable zxW;

        public b(Drawable drawable, Drawable drawable2) {
            this.zxV = drawable;
            this.zxW = drawable2;
            this.isPressed = false;
        }

        public final void draw(Canvas canvas) {
            Drawable drawable;
            AppMethodBeat.i(190452);
            if (this.isPressed) {
                drawable = this.zxV;
            } else {
                drawable = this.zxW;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
            AppMethodBeat.o(190452);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(190453);
            this.zxV.setAlpha(i2);
            this.zxW.setAlpha(i2);
            AppMethodBeat.o(190453);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(190454);
            this.zxV.setColorFilter(colorFilter);
            this.zxW.setColorFilter(colorFilter);
            AppMethodBeat.o(190454);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public void setOnSliderTouchListener(a aVar) {
        this.GLW = aVar;
    }

    public final void fEg() {
        AppMethodBeat.i(190465);
        this.zxx = new b(com.tencent.mm.cb.a.l(getContext(), R.drawable.icon_filled_clip_border), com.tencent.mm.cb.a.l(getContext(), R.drawable.icon_filled_clip_border));
        this.zxy = new b(com.tencent.mm.cb.a.l(getContext(), R.drawable.icon_filled_clip_border), com.tencent.mm.cb.a.l(getContext(), R.drawable.icon_filled_clip_border));
        this.zxP = false;
        this.zxz = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        this.zxA = ((float) this.zxz) * 0.5f;
        this.zxM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        fEh();
        postInvalidate();
        AppMethodBeat.o(190465);
    }

    private void fEh() {
        AppMethodBeat.i(190466);
        this.zxx.setBounds(this.padding - (this.zxz / 2), 0, this.padding + (this.zxz / 2), getHeight());
        this.zxy.setBounds((this.padding + this.zxt) - (this.zxz / 2), 0, this.zxt + this.padding + (this.zxz / 2), getHeight());
        AppMethodBeat.o(190466);
    }

    static /* synthetic */ float a(TimeCropSliderSeekBar timeCropSliderSeekBar, float f2) {
        AppMethodBeat.i(190468);
        float min = Math.min(Math.max((float) timeCropSliderSeekBar.padding, f2), (float) (timeCropSliderSeekBar.getWidth() - timeCropSliderSeekBar.padding));
        AppMethodBeat.o(190468);
        return min;
    }

    static /* synthetic */ void a(TimeCropSliderSeekBar timeCropSliderSeekBar, boolean z, boolean z2) {
        b bVar;
        AppMethodBeat.i(190470);
        if (!timeCropSliderSeekBar.zxr || timeCropSliderSeekBar.zxx == null || timeCropSliderSeekBar.zxy == null || timeCropSliderSeekBar.zxx.getBounds().width() <= 0 || timeCropSliderSeekBar.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(190470);
            return;
        }
        if (z) {
            bVar = (b) timeCropSliderSeekBar.zxx;
        } else {
            bVar = (b) timeCropSliderSeekBar.zxy;
        }
        if (bVar.isPressed != z2) {
            bVar.isPressed = z2;
            TimeCropSliderSeekBar.this.invalidate();
        }
        timeCropSliderSeekBar.postInvalidate();
        AppMethodBeat.o(190470);
    }

    static /* synthetic */ boolean a(TimeCropSliderSeekBar timeCropSliderSeekBar, float f2, float f3) {
        AppMethodBeat.i(190471);
        if (f2 <= ((float) timeCropSliderSeekBar.zxx.getBounds().right) || f2 >= ((float) timeCropSliderSeekBar.zxy.getBounds().left) || f3 <= ((float) timeCropSliderSeekBar.GLZ) || f3 >= ((float) (timeCropSliderSeekBar.GLZ + timeCropSliderSeekBar.GMa))) {
            AppMethodBeat.o(190471);
            return false;
        }
        AppMethodBeat.o(190471);
        return true;
    }

    static /* synthetic */ boolean a(TimeCropSliderSeekBar timeCropSliderSeekBar, Drawable drawable, float f2, float f3) {
        AppMethodBeat.i(190472);
        if (!timeCropSliderSeekBar.zxr || drawable == null) {
            AppMethodBeat.o(190472);
            return false;
        }
        Rect bounds = drawable.getBounds();
        if (f3 > ((float) (bounds.bottom + timeCropSliderSeekBar.zxM)) || f3 < ((float) (bounds.top - timeCropSliderSeekBar.zxM)) || f2 < ((float) (bounds.left - timeCropSliderSeekBar.zxM)) || f2 > ((float) (bounds.right + timeCropSliderSeekBar.zxM))) {
            AppMethodBeat.o(190472);
            return false;
        }
        AppMethodBeat.o(190472);
        return true;
    }
}
