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

public class EditSliderSeekBar extends View {
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
    private Paint zxG;
    private Paint zxH;
    private int zxI;
    private float zxJ;
    private float zxK;
    private float zxL;
    private int zxM;
    private Rect zxN;
    private Rect zxO;
    private boolean zxP;
    private a zxq;
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
        void c(boolean z, float f2);

        void rf(boolean z);

        void rg(boolean z);
    }

    static /* synthetic */ boolean a(EditSliderSeekBar editSliderSeekBar, boolean z) {
        AppMethodBeat.i(187060);
        boolean re = editSliderSeekBar.re(z);
        AppMethodBeat.o(187060);
        return re;
    }

    public EditSliderSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditSliderSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(187049);
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
            /* class com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.AnonymousClass1 */
            float deo;
            float dep;
            int zxQ = -1;
            int zxR = -1;
            int zxS;
            int zxT;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                boolean z2;
                boolean z3;
                AppMethodBeat.i(187045);
                if (!EditSliderSeekBar.this.zxr) {
                    AppMethodBeat.o(187045);
                    return false;
                }
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 5:
                        this.zxT = motionEvent.getActionIndex();
                        this.zxS = motionEvent.getPointerId(this.zxT);
                        this.deo = motionEvent.getX(this.zxT);
                        this.dep = motionEvent.getY(this.zxT);
                        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.this.zxx, this.deo, this.dep)) {
                            if (EditSliderSeekBar.a(EditSliderSeekBar.this, true)) {
                                AppMethodBeat.o(187045);
                                return false;
                            }
                            if (EditSliderSeekBar.this.zxq != null) {
                                EditSliderSeekBar.this.zxq.rf(true);
                            }
                            this.zxQ = this.zxS;
                            EditSliderSeekBar.this.zxK = (float) EditSliderSeekBar.this.zxx.getBounds().left;
                            EditSliderSeekBar.a(EditSliderSeekBar.this, true, true);
                            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                            AppMethodBeat.o(187045);
                            return true;
                        } else if (!EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.this.zxy, this.deo, this.dep)) {
                            AppMethodBeat.o(187045);
                            return false;
                        } else if (EditSliderSeekBar.a(EditSliderSeekBar.this, false)) {
                            AppMethodBeat.o(187045);
                            return false;
                        } else {
                            if (EditSliderSeekBar.this.zxq != null) {
                                EditSliderSeekBar.this.zxq.rf(false);
                            }
                            this.zxR = this.zxS;
                            EditSliderSeekBar.this.zxL = (float) EditSliderSeekBar.this.zxy.getBounds().right;
                            EditSliderSeekBar.a(EditSliderSeekBar.this, false, true);
                            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                            AppMethodBeat.o(187045);
                            return true;
                        }
                    case 1:
                    case 3:
                    case 6:
                        this.zxS = motionEvent.getPointerId(motionEvent.getActionIndex());
                        if (this.zxS == this.zxQ || this.zxS == this.zxR) {
                            if (EditSliderSeekBar.this.zxq != null) {
                                EditSliderSeekBar.this.zxq.rg(this.zxS == this.zxQ);
                            }
                            EditSliderSeekBar editSliderSeekBar = EditSliderSeekBar.this;
                            if (this.zxS == this.zxQ) {
                                z = true;
                            } else {
                                z = false;
                            }
                            EditSliderSeekBar.a(editSliderSeekBar, z, false);
                            if (this.zxS == this.zxQ) {
                                this.zxQ = -1;
                            } else {
                                this.zxR = -1;
                            }
                            EditSliderSeekBar.this.zxv = false;
                            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                            AppMethodBeat.o(187045);
                            return true;
                        }
                        AppMethodBeat.o(187045);
                        return false;
                    case 2:
                        if (!EditSliderSeekBar.a(EditSliderSeekBar.this, true) && !EditSliderSeekBar.a(EditSliderSeekBar.this, false)) {
                            AppMethodBeat.o(187045);
                            return false;
                        } else if (EditSliderSeekBar.this.zxs) {
                            AppMethodBeat.o(187045);
                            return true;
                        } else {
                            this.zxT = 0;
                            boolean z4 = false;
                            while (this.zxT < motionEvent.getPointerCount()) {
                                this.zxS = motionEvent.getPointerId(this.zxT);
                                if (this.zxS == this.zxQ || this.zxS == this.zxR) {
                                    EditSliderSeekBar editSliderSeekBar2 = EditSliderSeekBar.this;
                                    if (this.zxS == this.zxQ) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    boolean b2 = editSliderSeekBar2.b(z2, motionEvent.getX(this.zxT));
                                    if (EditSliderSeekBar.this.zxw && b2 && !EditSliderSeekBar.this.zxv) {
                                        EditSliderSeekBar.this.performHapticFeedback(0, 2);
                                    }
                                    EditSliderSeekBar.this.zxv = b2;
                                    if (EditSliderSeekBar.this.zxq != null) {
                                        int[] iArr = new int[2];
                                        EditSliderSeekBar.this.getLocationOnScreen(iArr);
                                        if (this.zxS == this.zxQ) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        EditSliderSeekBar.this.zxq.c(z3, (z3 ? (float) (iArr[0] + EditSliderSeekBar.this.getLeftSliderBound()) : (float) (iArr[0] + EditSliderSeekBar.this.getRightSliderBound())) + ((float) EditSliderSeekBar.this.padding));
                                    }
                                    z4 = true;
                                }
                                this.zxT++;
                            }
                            if (z4) {
                                EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            AppMethodBeat.o(187045);
                            return z4;
                        }
                    case 4:
                    default:
                        AppMethodBeat.o(187045);
                        return false;
                }
            }
        };
        this.zxz = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.zxA = ((float) this.zxz) * 0.5f;
        this.zxM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.zxx = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxy = new b(com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.cb.a.l(getContext(), R.raw.video_clip_slider_normal));
        this.zxP = true;
        postInvalidate();
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
        AppMethodBeat.o(187049);
    }

    private static int gz(Context context) {
        AppMethodBeat.i(187050);
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        AppMethodBeat.o(187050);
        return round;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(187051);
        if (this.zxC > 0.0f) {
            float width = ((float) getWidth()) * this.zxC;
            canvas.drawRect(width - (((float) this.zxB) * 0.5f), 0.0f, (((float) this.zxB) * 0.5f) + width, (float) getHeight(), this.zxE);
        }
        if (!this.zxr) {
            AppMethodBeat.o(187051);
            return;
        }
        int centerX = this.zxx.getBounds().centerX();
        int centerX2 = this.zxy.getBounds().centerX();
        if ((re(true) || re(false)) && this.zxP) {
            canvas.drawRect(((float) this.padding) + this.zxJ, this.zxJ, ((float) (getWidth() - this.padding)) - this.zxJ, ((float) getBottom()) - this.zxJ, this.zxH);
        }
        if (this.zxx.getBounds().left > 0) {
            canvas.drawRect((float) this.padding, 0.0f, (float) centerX, (float) getHeight(), this.zxG);
        }
        if (this.zxy.getBounds().right < getWidth()) {
            canvas.drawRect((float) centerX2, 0.0f, (float) (getWidth() - this.padding), (float) getHeight(), this.zxG);
        }
        if (this.zxP) {
            canvas.drawLine((float) centerX, this.zxF, (float) centerX2, this.zxF, this.borderPaint);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.zxF, (float) centerX2, ((float) getHeight()) - this.zxF, this.borderPaint);
        }
        this.zxx.draw(canvas);
        this.zxy.draw(canvas);
        AppMethodBeat.o(187051);
    }

    public void setCursorPos(float f2) {
        AppMethodBeat.i(187052);
        if (!this.zxr) {
            AppMethodBeat.o(187052);
            return;
        }
        this.zxC = f2;
        invalidate();
        AppMethodBeat.o(187052);
    }

    public final void ao(int i2, int i3, int i4) {
        AppMethodBeat.i(187053);
        if (i2 <= this.zxz * 2) {
            IllegalStateException illegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
            AppMethodBeat.o(187053);
            throw illegalStateException;
        }
        this.zxr = true;
        this.padding = i4;
        this.zxt = i2;
        this.zxu = i3;
        this.zxx.setBounds(this.padding - this.zxz, 0, this.padding, getHeight());
        this.zxy.setBounds(this.padding + this.zxt, 0, this.zxt + this.padding + this.zxz, getHeight());
        if (this.zxN == null && this.zxO == null) {
            this.zxN = new Rect(this.zxx.getBounds().left, this.zxx.getBounds().top, this.zxx.getBounds().right, this.zxx.getBounds().bottom);
            this.zxO = new Rect(this.zxy.getBounds().left, this.zxy.getBounds().top, this.zxy.getBounds().right, this.zxy.getBounds().bottom);
        }
        invalidate();
        AppMethodBeat.o(187053);
    }

    public final void ekn() {
        AppMethodBeat.i(187054);
        this.zxr = false;
        this.zxt = 0;
        this.zxu = 0;
        this.zxx.setBounds(0, 0, 0, 0);
        this.zxy.setBounds(0, 0, 0, 0);
        invalidate();
        AppMethodBeat.o(187054);
    }

    public void setMaskColor(int i2) {
        AppMethodBeat.i(187055);
        this.zxG.setColor(i2);
        AppMethodBeat.o(187055);
    }

    public void setEnableHapticAtEdge(boolean z) {
        this.zxw = z;
    }

    private boolean re(boolean z) {
        AppMethodBeat.i(187056);
        if (z) {
            boolean z2 = ((b) this.zxx).isPressed;
            AppMethodBeat.o(187056);
            return z2;
        }
        boolean z3 = ((b) this.zxy).isPressed;
        AppMethodBeat.o(187056);
        return z3;
    }

    public final boolean b(boolean z, float f2) {
        float f3;
        float min;
        boolean z2;
        AppMethodBeat.i(187057);
        if (!this.zxr || this.zxx == null || this.zxy == null || this.zxx.getBounds().width() <= 0 || this.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(187057);
            return false;
        }
        if (z) {
            min = (float) (this.zxy.getBounds().left - this.zxu);
            f3 = (float) Math.max(this.padding, this.zxy.getBounds().left - this.zxt);
        } else {
            f3 = (float) (this.zxx.getBounds().right + this.zxu);
            min = (float) Math.min(this.padding + this.zxt, this.zxx.getBounds().right + this.zxt);
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
        AppMethodBeat.o(187057);
        return z2;
    }

    public int getLeftSliderBound() {
        AppMethodBeat.i(187058);
        int i2 = this.zxx.getBounds().right - this.padding;
        AppMethodBeat.o(187058);
        return i2;
    }

    public int getRightSliderBound() {
        AppMethodBeat.i(187059);
        int i2 = this.zxy.getBounds().left - this.padding;
        AppMethodBeat.o(187059);
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
            AppMethodBeat.i(187046);
            if (this.isPressed) {
                drawable = this.zxV;
            } else {
                drawable = this.zxW;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
            AppMethodBeat.o(187046);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(187047);
            this.zxV.setAlpha(i2);
            this.zxW.setAlpha(i2);
            AppMethodBeat.o(187047);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(187048);
            this.zxV.setColorFilter(colorFilter);
            this.zxW.setColorFilter(colorFilter);
            AppMethodBeat.o(187048);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public void setOnSliderTouchListener(a aVar) {
        this.zxq = aVar;
    }

    static /* synthetic */ void a(EditSliderSeekBar editSliderSeekBar, boolean z, boolean z2) {
        b bVar;
        AppMethodBeat.i(187061);
        if (!editSliderSeekBar.zxr || editSliderSeekBar.zxx == null || editSliderSeekBar.zxy == null || editSliderSeekBar.zxx.getBounds().width() <= 0 || editSliderSeekBar.zxy.getBounds().width() <= 0) {
            AppMethodBeat.o(187061);
            return;
        }
        if (z) {
            bVar = (b) editSliderSeekBar.zxx;
        } else {
            bVar = (b) editSliderSeekBar.zxy;
        }
        if (bVar.isPressed != z2) {
            bVar.isPressed = z2;
            EditSliderSeekBar.this.invalidate();
        }
        editSliderSeekBar.postInvalidate();
        AppMethodBeat.o(187061);
    }

    static /* synthetic */ boolean a(EditSliderSeekBar editSliderSeekBar, Drawable drawable, float f2, float f3) {
        AppMethodBeat.i(187062);
        if (!editSliderSeekBar.zxr || drawable == null) {
            AppMethodBeat.o(187062);
            return false;
        }
        Rect bounds = drawable.getBounds();
        if (f3 > ((float) (bounds.bottom + editSliderSeekBar.zxM)) || f3 < ((float) (bounds.top - editSliderSeekBar.zxM)) || f2 < ((float) (bounds.left - editSliderSeekBar.zxM)) || f2 > ((float) (bounds.right + editSliderSeekBar.zxM))) {
            AppMethodBeat.o(187062);
            return false;
        }
        AppMethodBeat.o(187062);
        return true;
    }
}
