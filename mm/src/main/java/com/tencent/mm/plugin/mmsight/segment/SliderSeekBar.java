package com.tencent.mm.plugin.mmsight.segment;

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

public class SliderSeekBar extends View {
    private View.OnTouchListener aZa;
    private Paint borderPaint;
    private int padding;
    private int rc;
    protected float zxA;
    private int zxB;
    private float zxC;
    private int zxD;
    private Paint zxE;
    private float zxF;
    private Paint zxG;
    private Paint zxH;
    private int zxI;
    private float zxJ;
    private float zxK;
    private float zxL;
    protected int zxM;
    private Rect zxN;
    private Rect zxO;
    protected boolean zxP;
    private boolean zxr;
    boolean zxs;
    private int zxt;
    private int zxu;
    private boolean zxv;
    private boolean zxw;
    protected Drawable zxx;
    protected Drawable zxy;
    protected int zxz;
    private a zzA;

    public interface a {
        void eky();

        void ekz();

        void rj(boolean z);
    }

    static /* synthetic */ boolean a(SliderSeekBar sliderSeekBar, boolean z) {
        AppMethodBeat.i(187072);
        boolean re = sliderSeekBar.re(z);
        AppMethodBeat.o(187072);
        return re;
    }

    public SliderSeekBar(Context context) {
        this(context, null);
        AppMethodBeat.i(94449);
        AppMethodBeat.o(94449);
    }

    public SliderSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SliderSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(187064);
        this.zxr = false;
        this.zxs = false;
        this.zxv = false;
        this.zxw = false;
        this.zxC = -1.0f;
        this.zxK = -1.0f;
        this.zxL = -1.0f;
        this.padding = 0;
        this.zxP = true;
        this.aZa = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.AnonymousClass2 */
            float deo;
            float dep;
            int zxQ = -1;
            int zxR = -1;
            int zxS;
            int zxT;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                boolean z2;
                AppMethodBeat.i(94445);
                if (!SliderSeekBar.this.zxr) {
                    AppMethodBeat.o(94445);
                    return false;
                }
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 5:
                        this.zxT = motionEvent.getActionIndex();
                        this.zxS = motionEvent.getPointerId(this.zxT);
                        this.deo = motionEvent.getX(this.zxT);
                        this.dep = motionEvent.getY(this.zxT);
                        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.zxx, this.deo, this.dep)) {
                            if (SliderSeekBar.a(SliderSeekBar.this, true)) {
                                AppMethodBeat.o(94445);
                                return false;
                            }
                            if (SliderSeekBar.this.zzA != null) {
                                SliderSeekBar.this.zzA.eky();
                            }
                            this.zxQ = this.zxS;
                            SliderSeekBar.this.zxK = (float) SliderSeekBar.this.zxx.getBounds().left;
                            SliderSeekBar.a(SliderSeekBar.this, true, true);
                            AppMethodBeat.o(94445);
                            return true;
                        } else if (!SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.zxy, this.deo, this.dep)) {
                            AppMethodBeat.o(94445);
                            return false;
                        } else if (SliderSeekBar.a(SliderSeekBar.this, false)) {
                            AppMethodBeat.o(94445);
                            return false;
                        } else {
                            if (SliderSeekBar.this.zzA != null) {
                                SliderSeekBar.this.zzA.eky();
                            }
                            this.zxR = this.zxS;
                            SliderSeekBar.this.zxL = (float) SliderSeekBar.this.zxy.getBounds().right;
                            SliderSeekBar.a(SliderSeekBar.this, false, true);
                            AppMethodBeat.o(94445);
                            return true;
                        }
                    case 1:
                    case 3:
                    case 6:
                        this.zxS = motionEvent.getPointerId(motionEvent.getActionIndex());
                        if (this.zxS == this.zxQ || this.zxS == this.zxR) {
                            if (SliderSeekBar.this.zzA != null) {
                                SliderSeekBar.this.zzA.ekz();
                            }
                            SliderSeekBar.a(SliderSeekBar.this, this.zxS == this.zxQ, false);
                            if (this.zxS == this.zxQ) {
                                this.zxQ = -1;
                            } else {
                                this.zxR = -1;
                            }
                            SliderSeekBar.this.zxv = false;
                            AppMethodBeat.o(94445);
                            return true;
                        }
                        AppMethodBeat.o(94445);
                        return false;
                    case 2:
                        if (!SliderSeekBar.a(SliderSeekBar.this, true) && !SliderSeekBar.a(SliderSeekBar.this, false)) {
                            AppMethodBeat.o(94445);
                            return false;
                        } else if (SliderSeekBar.this.zxs) {
                            AppMethodBeat.o(94445);
                            return true;
                        } else {
                            this.zxT = 0;
                            boolean z3 = false;
                            while (this.zxT < motionEvent.getPointerCount()) {
                                this.zxS = motionEvent.getPointerId(this.zxT);
                                if (this.zxS == this.zxQ || this.zxS == this.zxR) {
                                    SliderSeekBar sliderSeekBar = SliderSeekBar.this;
                                    if (this.zxS == this.zxQ) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    boolean b2 = sliderSeekBar.b(z, motionEvent.getX(this.zxT));
                                    if (SliderSeekBar.this.zxw && b2 && !SliderSeekBar.this.zxv) {
                                        SliderSeekBar.this.performHapticFeedback(0, 2);
                                    }
                                    SliderSeekBar.this.zxv = b2;
                                    if (SliderSeekBar.this.zzA != null) {
                                        a aVar = SliderSeekBar.this.zzA;
                                        if (this.zxS == this.zxQ) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        aVar.rj(z2);
                                    }
                                    z3 = true;
                                }
                                this.zxT++;
                            }
                            AppMethodBeat.o(94445);
                            return z3;
                        }
                    case 4:
                    default:
                        AppMethodBeat.o(94445);
                        return false;
                }
            }
        };
        init();
        AppMethodBeat.o(187064);
    }

    /* access modifiers changed from: protected */
    public void init() {
        AppMethodBeat.i(187065);
        this.zxz = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.zxA = ((float) this.zxz) * 0.5f;
        this.zxM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        ekC();
        this.zxB = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
        this.zxD = com.tencent.mm.cb.a.aG(getContext(), R.dimen.anl);
        this.zxC = -1.0f;
        this.zxE = new Paint();
        this.zxE.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.BW_BG_100));
        this.zxE.setAlpha(102);
        this.zxG = new Paint();
        this.zxG.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.BW_0));
        this.zxG.setAlpha(102);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.BW_BG_100));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.rc = gz(getContext());
        this.borderPaint.setStrokeWidth((float) this.rc);
        this.zxF = ((float) this.rc) * 0.5f;
        this.zxH = new Paint();
        this.zxH.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.BW_BG_100));
        this.zxH.setStyle(Paint.Style.STROKE);
        this.zxI = gz(getContext());
        this.zxJ = ((float) this.zxI) * 0.5f;
        this.zxH.setStrokeWidth((float) this.zxI);
        this.zxH.setAlpha(178);
        setOnTouchListener(this.aZa);
        AppMethodBeat.o(187065);
    }

    private static int gz(Context context) {
        AppMethodBeat.i(94450);
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        AppMethodBeat.o(94450);
        return round;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(94451);
        if (this.zxC > 0.0f) {
            float width = ((float) getWidth()) * this.zxC;
            canvas.drawRect(width - (((float) this.zxB) * 0.5f), 0.0f, (((float) this.zxB) * 0.5f) + width, (float) getHeight(), this.zxE);
        }
        if (!this.zxr) {
            AppMethodBeat.o(94451);
            return;
        }
        int centerX = this.zxx.getBounds().centerX();
        int centerX2 = this.zxy.getBounds().centerX();
        if ((re(true) || re(false)) && this.zxP) {
            canvas.drawRect(((float) this.padding) + this.zxJ, this.zxJ, ((float) (getWidth() - this.padding)) - this.zxJ, ((float) getBottom()) - this.zxJ, this.zxH);
        }
        if (this.zxx.getBounds().left > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.zxG);
        }
        if (this.zxy.getBounds().right < getWidth()) {
            canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.zxG);
        }
        if (this.zxP) {
            canvas.drawLine((float) centerX, this.zxF, (float) centerX2, this.zxF, this.borderPaint);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.zxF, (float) centerX2, ((float) getHeight()) - this.zxF, this.borderPaint);
        }
        this.zxx.draw(canvas);
        this.zxy.draw(canvas);
        AppMethodBeat.o(94451);
    }

    public void setCursorPos(float f2) {
        AppMethodBeat.i(94452);
        if (!this.zxr) {
            AppMethodBeat.o(94452);
            return;
        }
        this.zxC = f2;
        invalidate();
        AppMethodBeat.o(94452);
    }

    public final void ao(final int i2, final int i3, final int i4) {
        AppMethodBeat.i(187066);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(94444);
                if (i2 <= SliderSeekBar.this.zxz * 2) {
                    IllegalStateException illegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                    AppMethodBeat.o(94444);
                    throw illegalStateException;
                }
                SliderSeekBar.this.zxr = true;
                SliderSeekBar.this.padding = i4;
                SliderSeekBar.this.zxt = Math.min(i2, SliderSeekBar.this.getWidth() - (i4 * 2));
                SliderSeekBar.this.zxu = Math.max(i3, 0);
                SliderSeekBar.b(SliderSeekBar.this);
                if (SliderSeekBar.this.zxN == null && SliderSeekBar.this.zxO == null) {
                    SliderSeekBar.this.zxN = new Rect(SliderSeekBar.this.zxx.getBounds().left, SliderSeekBar.this.zxx.getBounds().top, SliderSeekBar.this.zxx.getBounds().right, SliderSeekBar.this.zxx.getBounds().bottom);
                    SliderSeekBar.this.zxO = new Rect(SliderSeekBar.this.zxy.getBounds().left, SliderSeekBar.this.zxy.getBounds().top, SliderSeekBar.this.zxy.getBounds().right, SliderSeekBar.this.zxy.getBounds().bottom);
                }
                SliderSeekBar.this.invalidate();
                AppMethodBeat.o(94444);
            }
        });
        AppMethodBeat.o(187066);
    }

    public final void ekA() {
        this.zxs = true;
    }

    public final void ekB() {
        this.zxs = false;
    }

    public void setMaskColor(int i2) {
        AppMethodBeat.i(187067);
        this.zxG.setColor(i2);
        AppMethodBeat.o(187067);
    }

    public void setCursorColor(int i2) {
        AppMethodBeat.i(187068);
        this.zxE.setColor(i2);
        AppMethodBeat.o(187068);
    }

    public void setCursorWidth(int i2) {
        this.zxB = i2;
    }

    public void setEnableHapticAtEdge(boolean z) {
        this.zxw = z;
    }

    private boolean re(boolean z) {
        AppMethodBeat.i(94453);
        if (z) {
            boolean z2 = ((b) this.zxx).isPressed;
            AppMethodBeat.o(94453);
            return z2;
        }
        boolean z3 = ((b) this.zxy).isPressed;
        AppMethodBeat.o(94453);
        return z3;
    }

    public final boolean b(boolean z, float f2) {
        float f3;
        float min;
        boolean z2;
        AppMethodBeat.i(187069);
        if (!this.zxr || this.zxx == null || this.zxy == null || this.zxx.getBounds().width() <= 0 || this.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(187069);
            return false;
        }
        if (z) {
            min = (float) (this.zxy.getBounds().left - this.zxu);
            f3 = (float) Math.max(this.padding, this.zxy.getBounds().left - this.zxt);
        } else {
            f3 = (float) (this.zxx.getBounds().right + this.zxu);
            min = (float) Math.min(getWidth() - this.padding, this.zxx.getBounds().right + this.zxt);
        }
        float max = Math.max(f3, Math.min(f2, min));
        if (max == f3 || max == min) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            Rect bounds = this.zxx.getBounds();
            bounds.offsetTo((int) Math.ceil((double) (max - ((float) this.zxz))), 0);
            this.zxx.setBounds(bounds);
        } else {
            Rect bounds2 = this.zxy.getBounds();
            bounds2.offsetTo((int) Math.floor((double) max), 0);
            this.zxy.setBounds(bounds2);
        }
        postInvalidate();
        AppMethodBeat.o(187069);
        return z2;
    }

    public int getLeftSliderBound() {
        AppMethodBeat.i(94454);
        int i2 = this.zxx.getBounds().right;
        AppMethodBeat.o(94454);
        return i2;
    }

    public int getRightSliderBound() {
        AppMethodBeat.i(94455);
        int i2 = this.zxy.getBounds().left;
        AppMethodBeat.o(94455);
        return i2;
    }

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
            AppMethodBeat.i(94446);
            if (this.isPressed) {
                drawable = this.zxV;
            } else {
                drawable = this.zxW;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
            AppMethodBeat.o(94446);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(94447);
            this.zxV.setAlpha(i2);
            this.zxW.setAlpha(i2);
            AppMethodBeat.o(94447);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(94448);
            this.zxV.setColorFilter(colorFilter);
            this.zxW.setColorFilter(colorFilter);
            AppMethodBeat.o(94448);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public void setOnSliderTouchListener(a aVar) {
        this.zzA = aVar;
    }

    public final void reset() {
        AppMethodBeat.i(94456);
        if (!(this.zxN == null || this.zxO == null)) {
            Rect rect = new Rect(this.zxN.left, this.zxN.top, this.zxN.right, this.zxN.bottom);
            Rect rect2 = new Rect(this.zxO.left, this.zxO.top, this.zxO.right, this.zxO.bottom);
            this.zxx.setBounds(rect);
            this.zxy.setBounds(rect2);
            this.zxC = 0.0f;
            postInvalidate();
        }
        AppMethodBeat.o(94456);
    }

    public void ekC() {
        AppMethodBeat.i(187070);
        this.zxx = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxy = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxP = true;
        postInvalidate();
        AppMethodBeat.o(187070);
    }

    static /* synthetic */ void b(SliderSeekBar sliderSeekBar) {
        AppMethodBeat.i(187071);
        if (sliderSeekBar.zxP) {
            sliderSeekBar.zxx.setBounds(sliderSeekBar.padding, 0, sliderSeekBar.padding + sliderSeekBar.zxz, sliderSeekBar.getHeight());
            sliderSeekBar.zxy.setBounds((sliderSeekBar.padding + sliderSeekBar.zxt) - sliderSeekBar.zxz, 0, sliderSeekBar.zxt + sliderSeekBar.padding, sliderSeekBar.getHeight());
            AppMethodBeat.o(187071);
            return;
        }
        sliderSeekBar.zxx.setBounds(sliderSeekBar.padding - sliderSeekBar.zxz, 0, sliderSeekBar.padding, sliderSeekBar.getHeight());
        sliderSeekBar.zxy.setBounds(sliderSeekBar.padding + sliderSeekBar.zxt, 0, sliderSeekBar.zxt + sliderSeekBar.padding + sliderSeekBar.zxz, sliderSeekBar.getHeight());
        AppMethodBeat.o(187071);
    }

    static /* synthetic */ void a(SliderSeekBar sliderSeekBar, boolean z, boolean z2) {
        b bVar;
        AppMethodBeat.i(187073);
        if (!sliderSeekBar.zxr || sliderSeekBar.zxx == null || sliderSeekBar.zxy == null || sliderSeekBar.zxx.getBounds().width() <= 0 || sliderSeekBar.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(187073);
            return;
        }
        if (z) {
            bVar = (b) sliderSeekBar.zxx;
        } else {
            bVar = (b) sliderSeekBar.zxy;
        }
        if (bVar.isPressed != z2) {
            bVar.isPressed = z2;
            SliderSeekBar.this.invalidate();
        }
        sliderSeekBar.postInvalidate();
        AppMethodBeat.o(187073);
    }

    static /* synthetic */ boolean a(SliderSeekBar sliderSeekBar, Drawable drawable, float f2, float f3) {
        AppMethodBeat.i(187074);
        if (!sliderSeekBar.zxr || drawable == null) {
            AppMethodBeat.o(187074);
            return false;
        }
        Rect bounds = drawable.getBounds();
        if (f3 > ((float) (bounds.bottom + sliderSeekBar.zxM)) || f3 < ((float) (bounds.top - sliderSeekBar.zxM)) || f2 < ((float) (bounds.left - sliderSeekBar.zxM)) || f2 > ((float) (bounds.right + sliderSeekBar.zxM))) {
            AppMethodBeat.o(187074);
            return false;
        }
        AppMethodBeat.o(187074);
        return true;
    }
}
