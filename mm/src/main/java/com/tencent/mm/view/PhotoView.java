package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;

public class PhotoView extends AppCompatImageView {
    private Matrix OUN = new Matrix();
    private GestureDetector PO;
    private boolean QEq;
    private boolean RkA;
    private boolean RkB;
    private float RkC;
    private float RkD;
    private int RkE;
    private int RkF;
    private float RkG;
    private float RkH;
    private RectF RkI = new RectF();
    private RectF RkJ = new RectF();
    private RectF RkK = new RectF();
    private PointF RkL = new PointF();
    private PointF RkM = new PointF();
    private PointF RkN = new PointF();
    private h RkO = new h();
    private RectF RkP;
    private Info RkQ;
    private long RkR;
    private Runnable RkS;
    private View.OnLongClickListener RkT;
    private i RkU;
    private e RkV = new e() {
        /* class com.tencent.mm.view.PhotoView.AnonymousClass1 */

        @Override // com.tencent.mm.view.PhotoView.e
        public final void v(float f2, float f3, float f4) {
            AppMethodBeat.i(164250);
            PhotoView.this.RkC += f2;
            if (PhotoView.this.Rkz) {
                PhotoView.this.RkD += f2;
                PhotoView.this.Rko.postRotate(f2, f3, f4);
                AppMethodBeat.o(164250);
                return;
            }
            if (Math.abs(PhotoView.this.RkC) >= ((float) PhotoView.this.Rkh)) {
                PhotoView.this.Rkz = true;
                PhotoView.this.RkC = 0.0f;
            }
            AppMethodBeat.o(164250);
        }
    };
    private ScaleGestureDetector.OnScaleGestureListener RkW = new ScaleGestureDetector.OnScaleGestureListener() {
        /* class com.tencent.mm.view.PhotoView.AnonymousClass2 */

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            AppMethodBeat.i(164251);
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                AppMethodBeat.o(164251);
                return false;
            }
            PhotoView.this.dhh *= scaleFactor;
            PhotoView.this.Rko.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            PhotoView.g(PhotoView.this);
            AppMethodBeat.o(164251);
            return true;
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };
    private Runnable RkX = new Runnable() {
        /* class com.tencent.mm.view.PhotoView.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(164252);
            if (PhotoView.this.hEZ != null) {
                PhotoView.this.hEZ.onClick(PhotoView.this);
            }
            AppMethodBeat.o(164252);
        }
    };
    private GestureDetector.OnGestureListener RkY = new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.view.PhotoView.AnonymousClass4 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(206183);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(206183);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(164253);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            if (PhotoView.this.RkT != null) {
                PhotoView.this.RkT.onLongClick(PhotoView.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(164253);
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(164254);
            PhotoView.this.Rkw = false;
            PhotoView.this.Rkt = false;
            PhotoView.this.Rkz = false;
            PhotoView.this.removeCallbacks(PhotoView.this.RkX);
            AppMethodBeat.o(164254);
            return false;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float f4;
            float f5;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            AppMethodBeat.i(164255);
            if (PhotoView.this.Rkt) {
                AppMethodBeat.o(164255);
                return false;
            } else if (!PhotoView.this.RkA && !PhotoView.this.RkB) {
                AppMethodBeat.o(164255);
                return false;
            } else if (PhotoView.this.RkO.isRunning) {
                AppMethodBeat.o(164255);
                return false;
            } else {
                if (((float) Math.round(PhotoView.this.RkJ.left)) >= PhotoView.this.xsQ.left || ((float) Math.round(PhotoView.this.RkJ.right)) <= PhotoView.this.xsQ.right) {
                    f4 = 0.0f;
                } else {
                    f4 = f2;
                }
                if (((float) Math.round(PhotoView.this.RkJ.top)) >= PhotoView.this.xsQ.top || ((float) Math.round(PhotoView.this.RkJ.bottom)) <= PhotoView.this.xsQ.bottom) {
                    f5 = 0.0f;
                } else {
                    f5 = f3;
                }
                if (PhotoView.this.Rkz || PhotoView.this.RkD % 90.0f != 0.0f) {
                    float f6 = (float) (((int) (PhotoView.this.RkD / 90.0f)) * 90);
                    float f7 = PhotoView.this.RkD % 90.0f;
                    if (f7 > 45.0f) {
                        f6 += 90.0f;
                    } else if (f7 < -45.0f) {
                        f6 -= 90.0f;
                    }
                    PhotoView.this.RkO.mb((int) PhotoView.this.RkD, (int) f6);
                    PhotoView.this.RkD = f6;
                }
                PhotoView.a(PhotoView.this, PhotoView.this.RkJ);
                h hVar = PhotoView.this.RkO;
                hVar.auo = f4 < 0.0f ? Integer.MAX_VALUE : 0;
                int abs = (int) (f4 > 0.0f ? Math.abs(PhotoView.this.RkJ.left) : PhotoView.this.RkJ.right - PhotoView.this.xsQ.right);
                if (f4 < 0.0f) {
                    abs = Integer.MAX_VALUE - abs;
                }
                int i8 = f4 < 0.0f ? abs : 0;
                if (f4 < 0.0f) {
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = abs;
                }
                if (f4 < 0.0f) {
                    i3 = Integer.MAX_VALUE - i8;
                } else {
                    i3 = abs;
                }
                hVar.aup = f5 < 0.0f ? Integer.MAX_VALUE : 0;
                int abs2 = (int) (f5 > 0.0f ? Math.abs(PhotoView.this.RkJ.top) : PhotoView.this.RkJ.bottom - PhotoView.this.xsQ.bottom);
                if (f5 < 0.0f) {
                    abs2 = Integer.MAX_VALUE - abs2;
                }
                int i9 = f5 < 0.0f ? abs2 : 0;
                if (f5 < 0.0f) {
                    i4 = Integer.MAX_VALUE;
                } else {
                    i4 = abs2;
                }
                if (f5 < 0.0f) {
                    i5 = Integer.MAX_VALUE - i9;
                } else {
                    i5 = abs2;
                }
                if (f4 == 0.0f) {
                    i2 = 0;
                    i8 = 0;
                }
                if (f5 == 0.0f) {
                    i4 = 0;
                    i9 = 0;
                }
                OverScroller overScroller = hVar.xsO;
                int i10 = hVar.auo;
                int i11 = hVar.aup;
                int i12 = (int) f4;
                int i13 = (int) f5;
                if (Math.abs(i3) < PhotoView.this.Rkl * 2) {
                    i6 = 0;
                } else {
                    i6 = PhotoView.this.Rkl;
                }
                if (Math.abs(i5) < PhotoView.this.Rkl * 2) {
                    i7 = 0;
                } else {
                    i7 = PhotoView.this.Rkl;
                }
                overScroller.fling(i10, i11, i12, i13, i8, i2, i9, i4, i6, i7);
                PhotoView.this.RkO.start();
                boolean onFling = super.onFling(motionEvent, motionEvent2, f2, f3);
                AppMethodBeat.o(164255);
                return onFling;
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float f4;
            float f5;
            AppMethodBeat.i(164256);
            if (PhotoView.this.RkO.isRunning) {
                PhotoView.this.RkO.stop();
            }
            if (PhotoView.this.cK(f2)) {
                if (f2 >= 0.0f || PhotoView.this.RkJ.left - f2 <= PhotoView.this.xsQ.left) {
                    f5 = f2;
                } else {
                    f5 = PhotoView.this.RkJ.left;
                }
                if (f5 > 0.0f && PhotoView.this.RkJ.right - f5 < PhotoView.this.xsQ.right) {
                    f5 = PhotoView.this.RkJ.right - PhotoView.this.xsQ.right;
                }
                PhotoView.this.Rko.postTranslate(-f5, 0.0f);
                PhotoView.this.RkE = (int) (((float) PhotoView.this.RkE) - f5);
            } else if (PhotoView.this.RkA || PhotoView.this.Rkt || PhotoView.this.Rkw) {
                PhotoView.t(PhotoView.this);
                if (!PhotoView.this.Rkt) {
                    if (f2 < 0.0f && PhotoView.this.RkJ.left - f2 > PhotoView.this.RkK.left) {
                        f2 = PhotoView.a(PhotoView.this, PhotoView.this.RkJ.left - PhotoView.this.RkK.left, f2);
                    }
                    if (f2 > 0.0f && PhotoView.this.RkJ.right - f2 < PhotoView.this.RkK.right) {
                        f2 = PhotoView.a(PhotoView.this, PhotoView.this.RkJ.right - PhotoView.this.RkK.right, f2);
                    }
                }
                PhotoView.this.RkE = (int) (((float) PhotoView.this.RkE) - f2);
                PhotoView.this.Rko.postTranslate(-f2, 0.0f);
                PhotoView.this.Rkw = true;
            }
            if (PhotoView.this.cL(f3)) {
                if (f3 >= 0.0f || PhotoView.this.RkJ.top - f3 <= PhotoView.this.xsQ.top) {
                    f4 = f3;
                } else {
                    f4 = PhotoView.this.RkJ.top;
                }
                if (f4 > 0.0f && PhotoView.this.RkJ.bottom - f4 < PhotoView.this.xsQ.bottom) {
                    f4 = PhotoView.this.RkJ.bottom - PhotoView.this.xsQ.bottom;
                }
                PhotoView.this.Rko.postTranslate(0.0f, -f4);
                PhotoView.this.RkF = (int) (((float) PhotoView.this.RkF) - f4);
            } else if (PhotoView.this.RkB || PhotoView.this.Rkw || PhotoView.this.Rkt) {
                PhotoView.t(PhotoView.this);
                if (!PhotoView.this.Rkt) {
                    if (f3 < 0.0f && PhotoView.this.RkJ.top - f3 > PhotoView.this.RkK.top) {
                        f3 = PhotoView.b(PhotoView.this, PhotoView.this.RkJ.top - PhotoView.this.RkK.top, f3);
                    }
                    if (f3 > 0.0f && PhotoView.this.RkJ.bottom - f3 < PhotoView.this.RkK.bottom) {
                        f3 = PhotoView.b(PhotoView.this, PhotoView.this.RkJ.bottom - PhotoView.this.RkK.bottom, f3);
                    }
                }
                PhotoView.this.Rko.postTranslate(0.0f, -f3);
                PhotoView.this.RkF = (int) (((float) PhotoView.this.RkF) - f3);
                PhotoView.this.Rkw = true;
            }
            PhotoView.g(PhotoView.this);
            AppMethodBeat.o(164256);
            return true;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(164257);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            PhotoView.this.postDelayed(PhotoView.this.RkX, 250);
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(164257);
            return false;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            float f2;
            float f3;
            AppMethodBeat.i(164258);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            PhotoView.this.RkO.stop();
            float width = PhotoView.this.RkJ.left + (PhotoView.this.RkJ.width() / 2.0f);
            float height = PhotoView.this.RkJ.top + (PhotoView.this.RkJ.height() / 2.0f);
            PhotoView.this.RkM.set(width, height);
            PhotoView.this.RkN.set(width, height);
            PhotoView.this.RkE = 0;
            PhotoView.this.RkF = 0;
            if (PhotoView.this.Rky) {
                f2 = PhotoView.this.dhh;
                f3 = 1.0f;
            } else {
                f2 = PhotoView.this.dhh;
                f3 = PhotoView.this.Rkj;
                PhotoView.this.RkM.set(motionEvent.getX(), motionEvent.getY());
            }
            PhotoView.this.xt.reset();
            PhotoView.this.xt.postTranslate(-PhotoView.this.RkI.left, -PhotoView.this.RkI.top);
            PhotoView.this.xt.postTranslate(PhotoView.this.RkN.x, PhotoView.this.RkN.y);
            PhotoView.this.xt.postTranslate(-PhotoView.this.RkG, -PhotoView.this.RkH);
            PhotoView.this.xt.postRotate(PhotoView.this.RkD, PhotoView.this.RkN.x, PhotoView.this.RkN.y);
            PhotoView.this.xt.postScale(f3, f3, PhotoView.this.RkM.x, PhotoView.this.RkM.y);
            PhotoView.this.xt.postTranslate((float) PhotoView.this.RkE, (float) PhotoView.this.RkF);
            PhotoView.this.xt.mapRect(PhotoView.this.dgT, PhotoView.this.RkI);
            PhotoView.a(PhotoView.this, PhotoView.this.dgT);
            PhotoView.this.Rky = !PhotoView.this.Rky;
            PhotoView.this.RkO.aD(f2, f3);
            PhotoView.this.RkO.start();
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(164258);
            return false;
        }
    };
    private Rect RkZ = new Rect();
    private int Rkh;
    private int Rki;
    private float Rkj;
    private int Rkk = 0;
    private int Rkl = 0;
    private int Rkm = 0;
    private int Rkn = 500;
    private Matrix Rko = new Matrix();
    private Matrix Rkp = new Matrix();
    private f Rkq;
    private ScaleGestureDetector Rkr;
    private ImageView.ScaleType Rks;
    private boolean Rkt;
    private boolean Rku;
    private boolean Rkv;
    private boolean Rkw;
    private boolean Rkx = false;
    private boolean Rky;
    private boolean Rkz;
    private boolean ded = false;
    private RectF dgT = new RectF();
    private float dhh = 1.0f;
    private View.OnClickListener hEZ;
    private boolean isInit;
    private RectF xsQ = new RectF();
    private Matrix xt = new Matrix();

    public interface a {
        float hfP();
    }

    /* access modifiers changed from: package-private */
    public interface e {
        void v(float f2, float f3, float f4);
    }

    public static class i {
        public RectF BZm;
        Matrix Rlp;
        public Matrix Rlq;
        Matrix Rlr;
        RectF Rls;
        public RectF Rlt;
        RectF Rlu;
        RectF Rlv;
        PointF Rlw;
        PointF Rlx;
        PointF Rly;
        Matrix rM;
    }

    static /* synthetic */ void a(PhotoView photoView, RectF rectF) {
        AppMethodBeat.i(164320);
        photoView.n(rectF);
        AppMethodBeat.o(164320);
    }

    static /* synthetic */ void g(PhotoView photoView) {
        AppMethodBeat.i(164319);
        photoView.hfO();
        AppMethodBeat.o(164319);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164283);
        init();
        AppMethodBeat.o(164283);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164284);
        init();
        AppMethodBeat.o(164284);
    }

    private void init() {
        AppMethodBeat.i(164285);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.Rks == null) {
            this.Rks = ImageView.ScaleType.CENTER_INSIDE;
        }
        this.Rkq = new f(this.RkV);
        this.PO = new GestureDetector(getContext(), this.RkY);
        this.Rkr = new ScaleGestureDetector(getContext(), this.RkW);
        float f2 = getResources().getDisplayMetrics().density;
        this.Rkk = (int) (f2 * 30.0f);
        this.Rkl = (int) (f2 * 30.0f);
        this.Rkm = (int) (f2 * 140.0f);
        this.Rkh = 35;
        this.Rki = 200;
        this.Rkj = 3.0f;
        AppMethodBeat.o(164285);
    }

    public long getDefaultAnimDuring() {
        return 200;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(164286);
        super.setOnClickListener(onClickListener);
        this.hEZ = onClickListener;
        AppMethodBeat.o(164286);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        AppMethodBeat.i(164287);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            AppMethodBeat.o(164287);
            return;
        }
        if (scaleType != this.Rks) {
            this.Rks = scaleType;
            if (this.isInit) {
                hfF();
            }
        }
        AppMethodBeat.o(164287);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.RkT = onLongClickListener;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.RkO.Rln.Rlb = interpolator;
    }

    public int getAnimaDuring() {
        return this.Rki;
    }

    public void setAnimaDuring(int i2) {
        this.Rki = i2;
    }

    public void setMaxScale(float f2) {
        this.Rkj = f2;
    }

    public float getMaxScale() {
        return this.Rkj;
    }

    public void setMaxAnimFromWaiteTime(int i2) {
        this.Rkn = i2;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageResource(int i2) {
        AppMethodBeat.i(164288);
        Drawable drawable = null;
        try {
            drawable = getResources().getDrawable(i2);
        } catch (Exception e2) {
        }
        setImageDrawable(drawable);
        AppMethodBeat.o(164288);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z = false;
        AppMethodBeat.i(164289);
        super.setImageDrawable(drawable);
        if (drawable == null) {
            this.Rku = false;
            AppMethodBeat.o(164289);
            return;
        }
        if ((drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) || ((drawable.getMinimumWidth() > 0 && drawable.getMinimumHeight() > 0) || (drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0))) {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(164289);
            return;
        }
        if (!this.Rku) {
            this.Rku = true;
        }
        hfF();
        AppMethodBeat.o(164289);
    }

    private static int H(Drawable drawable) {
        AppMethodBeat.i(164290);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = drawable.getMinimumWidth();
        }
        if (intrinsicWidth <= 0) {
            intrinsicWidth = drawable.getBounds().width();
        }
        AppMethodBeat.o(164290);
        return intrinsicWidth;
    }

    private static int I(Drawable drawable) {
        AppMethodBeat.i(164291);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = drawable.getMinimumHeight();
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = drawable.getBounds().height();
        }
        AppMethodBeat.o(164291);
        return intrinsicHeight;
    }

    private void hfF() {
        float f2;
        float f3 = 1.0f;
        AppMethodBeat.i(164292);
        if (!this.Rku) {
            AppMethodBeat.o(164292);
        } else if (!this.Rkv) {
            AppMethodBeat.o(164292);
        } else {
            if (this.RkP != null) {
                this.RkP.setEmpty();
            }
            this.OUN.reset();
            this.Rko.reset();
            this.Rkp.reset();
            this.xt.reset();
            this.Rky = false;
            Drawable drawable = getDrawable();
            int width = getWidth();
            int height = getHeight();
            int H = H(drawable);
            int I = I(drawable);
            this.RkI.set(0.0f, 0.0f, (float) H, (float) I);
            int i2 = (width - H) / 2;
            int i3 = (height - I) / 2;
            if (H > width) {
                f2 = ((float) width) / ((float) H);
            } else {
                f2 = 1.0f;
            }
            if (I > height) {
                f3 = ((float) height) / ((float) I);
            }
            if (f2 >= f3) {
                f2 = f3;
            }
            this.OUN.reset();
            this.OUN.postTranslate((float) i2, (float) i3);
            this.OUN.postScale(f2, f2, this.RkL.x, this.RkL.y);
            this.OUN.mapRect(this.RkI);
            this.RkG = this.RkI.width() / 2.0f;
            this.RkH = this.RkI.height() / 2.0f;
            this.RkM.set(this.RkL);
            this.RkN.set(this.RkM);
            hfO();
            switch (AnonymousClass5.Av[this.Rks.ordinal()]) {
                case 1:
                    hfG();
                    break;
                case 2:
                    hfH();
                    break;
                case 3:
                    hfI();
                    break;
                case 4:
                    hfJ();
                    break;
                case 5:
                    hfK();
                    break;
                case 6:
                    hfL();
                    break;
                case 7:
                    hfM();
                    break;
            }
            this.isInit = true;
            if (this.RkQ != null && System.currentTimeMillis() - this.RkR < ((long) this.Rkn)) {
                a(this.RkQ);
            }
            this.RkQ = null;
            if (this.RkU != null) {
                a(this.RkU);
                setImageMatrix(this.Rkp);
                this.RkU = null;
            }
            AppMethodBeat.o(164292);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.view.PhotoView$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] Av = new int[ImageView.ScaleType.values().length];

        static {
            AppMethodBeat.i(164259);
            try {
                Av[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Av[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Av[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Av[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Av[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Av[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                Av[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
                AppMethodBeat.o(164259);
            } catch (NoSuchFieldError e8) {
                AppMethodBeat.o(164259);
            }
        }
    }

    private void hfG() {
        AppMethodBeat.i(164293);
        if (!this.Rku) {
            AppMethodBeat.o(164293);
        } else if (!this.Rkv) {
            AppMethodBeat.o(164293);
        } else {
            Drawable drawable = getDrawable();
            int H = H(drawable);
            int I = I(drawable);
            if (((float) H) > this.xsQ.width() || ((float) I) > this.xsQ.height()) {
                float width = ((float) H) / this.RkJ.width();
                float height = ((float) I) / this.RkJ.height();
                if (width <= height) {
                    width = height;
                }
                this.dhh = width;
                this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
                hfO();
                hfN();
            }
            AppMethodBeat.o(164293);
        }
    }

    private void hfH() {
        AppMethodBeat.i(164294);
        if (this.RkJ.width() < this.xsQ.width() || this.RkJ.height() < this.xsQ.height()) {
            float width = this.xsQ.width() / this.RkJ.width();
            float height = this.xsQ.height() / this.RkJ.height();
            if (width <= height) {
                width = height;
            }
            this.dhh = width;
            this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
            hfO();
            hfN();
        }
        AppMethodBeat.o(164294);
    }

    private void hfI() {
        AppMethodBeat.i(164295);
        if (this.RkJ.width() > this.xsQ.width() || this.RkJ.height() > this.xsQ.height()) {
            float width = this.xsQ.width() / this.RkJ.width();
            float height = this.xsQ.height() / this.RkJ.height();
            if (width >= height) {
                width = height;
            }
            this.dhh = width;
            this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
            hfO();
            hfN();
        }
        AppMethodBeat.o(164295);
    }

    private void hfJ() {
        AppMethodBeat.i(164296);
        if (this.RkJ.width() < this.xsQ.width()) {
            this.dhh = this.xsQ.width() / this.RkJ.width();
            this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
            hfO();
            hfN();
        }
        AppMethodBeat.o(164296);
    }

    private void hfK() {
        AppMethodBeat.i(164297);
        hfJ();
        float f2 = -this.RkJ.top;
        this.Rko.postTranslate(0.0f, f2);
        hfO();
        hfN();
        this.RkF = (int) (f2 + ((float) this.RkF));
        AppMethodBeat.o(164297);
    }

    private void hfL() {
        AppMethodBeat.i(164298);
        hfJ();
        float f2 = this.xsQ.bottom - this.RkJ.bottom;
        this.RkF = (int) (((float) this.RkF) + f2);
        this.Rko.postTranslate(0.0f, f2);
        hfO();
        hfN();
        AppMethodBeat.o(164298);
    }

    private void hfM() {
        AppMethodBeat.i(164299);
        this.Rko.postScale(this.xsQ.width() / this.RkJ.width(), this.xsQ.height() / this.RkJ.height(), this.RkL.x, this.RkL.y);
        hfO();
        hfN();
        AppMethodBeat.o(164299);
    }

    private void hfN() {
        AppMethodBeat.i(164300);
        Drawable drawable = getDrawable();
        this.RkI.set(0.0f, 0.0f, (float) H(drawable), (float) I(drawable));
        this.OUN.set(this.Rkp);
        this.OUN.mapRect(this.RkI);
        this.RkG = this.RkI.width() / 2.0f;
        this.RkH = this.RkI.height() / 2.0f;
        this.dhh = 1.0f;
        this.RkE = 0;
        this.RkF = 0;
        this.Rko.reset();
        AppMethodBeat.o(164300);
    }

    private void hfO() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(164301);
        this.Rkp.set(this.OUN);
        this.Rkp.postConcat(this.Rko);
        setImageMatrix(this.Rkp);
        this.Rko.mapRect(this.RkJ, this.RkI);
        if (this.RkJ.width() > this.xsQ.width()) {
            z = true;
        } else {
            z = false;
        }
        this.RkA = z;
        if (this.RkJ.height() <= this.xsQ.height()) {
            z2 = false;
        }
        this.RkB = z2;
        AppMethodBeat.o(164301);
    }

    private void a(i iVar) {
        AppMethodBeat.i(164302);
        this.Rkp = iVar.Rlq;
        this.Rko = iVar.Rlp;
        this.OUN = iVar.Rlr;
        this.xt = iVar.rM;
        this.RkG = iVar.Rls.width() / 2.0f;
        this.RkH = iVar.Rls.height() / 2.0f;
        if (!this.xsQ.isEmpty()) {
            iVar.BZm.set(this.xsQ);
            iVar.Rlw = this.RkL;
        }
        this.xsQ = iVar.BZm;
        this.RkI = iVar.Rls;
        this.RkJ = iVar.Rlt;
        this.dgT = iVar.Rlu;
        this.RkK = iVar.Rlv;
        this.RkL = iVar.Rlw;
        this.RkM = iVar.Rlx;
        this.RkN = iVar.Rly;
        AppMethodBeat.o(164302);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r6 != 0) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0042, code lost:
        if (r5 != 0) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.PhotoView.onMeasure(int, int):void");
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.i(164304);
        super.setAdjustViewBounds(z);
        this.QEq = z;
        AppMethodBeat.o(164304);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164305);
        super.onSizeChanged(i2, i3, i4, i5);
        Log.i("PhotoView", "[onSizeChanged] w:%s, h:%s, oldw:%s, oldh:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        this.xsQ.set(0.0f, 0.0f, (float) i2, (float) i3);
        this.RkL.set((float) (i2 / 2), (float) (i3 / 2));
        if (!this.Rkv) {
            this.Rkv = true;
            hfF();
        }
        AppMethodBeat.o(164305);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(164306);
        canvas.save();
        if (this.RkP != null) {
            canvas.clipRect(this.RkP);
        }
        super.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(164306);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164307);
        if (this.ded) {
            this.RkP = null;
            int actionMasked = motionEvent.getActionMasked();
            if (motionEvent.getPointerCount() >= 2) {
                this.Rkt = true;
            }
            GestureDetector gestureDetector = this.PO;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if (this.Rkx) {
                f fVar = this.Rkq;
                switch (motionEvent.getActionMasked()) {
                    case 2:
                        if (motionEvent.getPointerCount() > 1) {
                            fVar.Rle = fVar.az(motionEvent);
                            double degrees = Math.toDegrees(Math.atan((double) fVar.Rle)) - Math.toDegrees(Math.atan((double) fVar.Rld));
                            if (Math.abs(degrees) <= 120.0d) {
                                fVar.Rlc.v((float) degrees, (fVar.x2 + fVar.x1) / 2.0f, (fVar.y2 + fVar.y1) / 2.0f);
                            }
                            fVar.Rld = fVar.Rle;
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (motionEvent.getPointerCount() == 2) {
                            fVar.Rld = fVar.az(motionEvent);
                            break;
                        }
                        break;
                }
            }
            this.Rkr.onTouchEvent(motionEvent);
            if ((actionMasked == 1 || actionMasked == 3) && !this.RkO.isRunning) {
                if (this.Rkz || this.RkD % 90.0f != 0.0f) {
                    float f2 = (float) (((int) (this.RkD / 90.0f)) * 90);
                    float f3 = this.RkD % 90.0f;
                    if (f3 > 45.0f) {
                        f2 += 90.0f;
                    } else if (f3 < -45.0f) {
                        f2 -= 90.0f;
                    }
                    this.RkO.mb((int) this.RkD, (int) f2);
                    this.RkD = f2;
                }
                float f4 = this.dhh;
                if (this.dhh < 1.0f) {
                    f4 = 1.0f;
                    this.RkO.aD(this.dhh, 1.0f);
                } else if (this.dhh > this.Rkj) {
                    f4 = this.Rkj;
                    this.RkO.aD(this.dhh, this.Rkj);
                }
                float width = this.RkJ.left + (this.RkJ.width() / 2.0f);
                float height = this.RkJ.top + (this.RkJ.height() / 2.0f);
                this.RkM.set(width, height);
                this.RkN.set(width, height);
                this.RkE = 0;
                this.RkF = 0;
                this.xt.reset();
                this.xt.postTranslate(-this.RkI.left, -this.RkI.top);
                this.xt.postTranslate(width - this.RkG, height - this.RkH);
                this.xt.postScale(f4, f4, width, height);
                this.xt.postRotate(this.RkD, width, height);
                this.xt.mapRect(this.dgT, this.RkI);
                n(this.dgT);
                this.RkO.start();
            }
            AppMethodBeat.o(164307);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(164307);
        return onTouchEvent;
    }

    private void n(RectF rectF) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(164308);
        if (rectF.width() <= this.xsQ.width()) {
            if (!p(rectF)) {
                i2 = -((int) (((this.xsQ.width() - rectF.width()) / 2.0f) - rectF.left));
            }
            i2 = 0;
        } else if (rectF.left > this.xsQ.left) {
            i2 = (int) (rectF.left - this.xsQ.left);
        } else {
            if (rectF.right < this.xsQ.right) {
                i2 = (int) (rectF.right - this.xsQ.right);
            }
            i2 = 0;
        }
        if (rectF.height() <= this.xsQ.height()) {
            if (!o(rectF)) {
                i3 = -((int) (((this.xsQ.height() - rectF.height()) / 2.0f) - rectF.top));
            }
        } else if (rectF.top > this.xsQ.top) {
            i3 = (int) (rectF.top - this.xsQ.top);
        } else if (rectF.bottom < this.xsQ.bottom) {
            i3 = (int) (rectF.bottom - this.xsQ.bottom);
        }
        if (!(i2 == 0 && i3 == 0)) {
            if (!this.RkO.xsO.isFinished()) {
                this.RkO.xsO.abortAnimation();
            }
            this.RkO.ma(-i2, -i3);
        }
        AppMethodBeat.o(164308);
    }

    private boolean o(RectF rectF) {
        AppMethodBeat.i(164309);
        if (Math.abs(((float) Math.round(rectF.top)) - ((this.xsQ.height() - rectF.height()) / 2.0f)) < 1.0f) {
            AppMethodBeat.o(164309);
            return true;
        }
        AppMethodBeat.o(164309);
        return false;
    }

    private boolean p(RectF rectF) {
        AppMethodBeat.i(164310);
        if (Math.abs(((float) Math.round(rectF.left)) - ((this.xsQ.width() - rectF.width()) / 2.0f)) < 1.0f) {
            AppMethodBeat.o(164310);
            return true;
        }
        AppMethodBeat.o(164310);
        return false;
    }

    public final boolean cK(float f2) {
        AppMethodBeat.i(164311);
        if (this.RkJ.width() <= this.xsQ.width()) {
            AppMethodBeat.o(164311);
            return false;
        } else if (f2 < 0.0f && ((float) Math.round(this.RkJ.left)) - f2 >= this.xsQ.left) {
            AppMethodBeat.o(164311);
            return false;
        } else if (f2 <= 0.0f || ((float) Math.round(this.RkJ.right)) - f2 > this.xsQ.right) {
            AppMethodBeat.o(164311);
            return true;
        } else {
            AppMethodBeat.o(164311);
            return false;
        }
    }

    public final boolean cL(float f2) {
        AppMethodBeat.i(164312);
        if (this.RkJ.height() <= this.xsQ.height()) {
            AppMethodBeat.o(164312);
            return false;
        } else if (f2 < 0.0f && ((float) Math.round(this.RkJ.top)) - f2 >= this.xsQ.top) {
            AppMethodBeat.o(164312);
            return false;
        } else if (f2 <= 0.0f || ((float) Math.round(this.RkJ.bottom)) - f2 > this.xsQ.bottom) {
            AppMethodBeat.o(164312);
            return true;
        } else {
            AppMethodBeat.o(164312);
            return false;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        AppMethodBeat.i(164313);
        if (this.Rkt) {
            AppMethodBeat.o(164313);
            return true;
        }
        boolean cK = cK((float) i2);
        AppMethodBeat.o(164313);
        return cK;
    }

    public boolean canScrollVertically(int i2) {
        AppMethodBeat.i(164314);
        if (this.Rkt) {
            AppMethodBeat.o(164314);
            return true;
        }
        boolean cL = cL((float) i2);
        AppMethodBeat.o(164314);
        return cL;
    }

    class c implements Interpolator {
        Interpolator Rlb;

        /* synthetic */ c(PhotoView photoView, byte b2) {
            this();
        }

        private c() {
            AppMethodBeat.i(164267);
            this.Rlb = new DecelerateInterpolator();
            AppMethodBeat.o(164267);
        }

        public final float getInterpolation(float f2) {
            AppMethodBeat.i(164268);
            if (this.Rlb != null) {
                float interpolation = this.Rlb.getInterpolation(f2);
                AppMethodBeat.o(164268);
                return interpolation;
            }
            AppMethodBeat.o(164268);
            return f2;
        }
    }

    /* access modifiers changed from: package-private */
    public class h implements Runnable {
        OverScroller Rlf;
        Scroller Rlg;
        Scroller Rlh;
        Scroller Rli;
        a Rlj;
        int Rlk;
        int Rll;
        RectF Rlm = new RectF();
        c Rln = new c(PhotoView.this, (byte) 0);
        int auo;
        int aup;
        boolean isRunning;
        OverScroller xsO;

        h() {
            AppMethodBeat.i(164273);
            Context context = PhotoView.this.getContext();
            this.Rlf = new OverScroller(context, this.Rln);
            this.Rlg = new Scroller(context, this.Rln);
            this.xsO = new OverScroller(context, this.Rln);
            this.Rlh = new Scroller(context, this.Rln);
            this.Rli = new Scroller(context, this.Rln);
            AppMethodBeat.o(164273);
        }

        /* access modifiers changed from: package-private */
        public final void ma(int i2, int i3) {
            AppMethodBeat.i(164274);
            this.Rlk = 0;
            this.Rll = 0;
            this.Rlf.startScroll(0, 0, i2, i3, PhotoView.this.Rki);
            AppMethodBeat.o(164274);
        }

        /* access modifiers changed from: package-private */
        public final void aD(float f2, float f3) {
            AppMethodBeat.i(164275);
            this.Rlg.startScroll((int) (f2 * 10000.0f), 0, (int) ((f3 - f2) * 10000.0f), 0, PhotoView.this.Rki);
            AppMethodBeat.o(164275);
        }

        /* access modifiers changed from: package-private */
        public final void a(float f2, float f3, float f4, float f5, int i2, a aVar) {
            AppMethodBeat.i(164276);
            this.Rlh.startScroll((int) (f2 * 10000.0f), (int) (f3 * 10000.0f), (int) (f4 * 10000.0f), (int) (10000.0f * f5), i2);
            this.Rlj = aVar;
            AppMethodBeat.o(164276);
        }

        /* access modifiers changed from: package-private */
        public final void mb(int i2, int i3) {
            AppMethodBeat.i(164277);
            this.Rli.startScroll(i2, 0, i3 - i2, 0, PhotoView.this.Rki);
            AppMethodBeat.o(164277);
        }

        /* access modifiers changed from: package-private */
        public final void start() {
            AppMethodBeat.i(164278);
            this.isRunning = true;
            hfR();
            AppMethodBeat.o(164278);
        }

        /* access modifiers changed from: package-private */
        public final void stop() {
            AppMethodBeat.i(164279);
            PhotoView.this.removeCallbacks(this);
            this.Rlf.abortAnimation();
            this.Rlg.abortAnimation();
            this.xsO.abortAnimation();
            this.Rli.abortAnimation();
            this.isRunning = false;
            AppMethodBeat.o(164279);
        }

        public final void run() {
            boolean z;
            boolean z2 = true;
            boolean z3 = false;
            AppMethodBeat.i(164280);
            if (this.Rlg.computeScrollOffset()) {
                PhotoView.this.dhh = ((float) this.Rlg.getCurrX()) / 10000.0f;
                z = false;
            } else {
                z = true;
            }
            if (this.Rlf.computeScrollOffset()) {
                int currX = this.Rlf.getCurrX() - this.Rlk;
                int currY = this.Rlf.getCurrY() - this.Rll;
                PhotoView.this.RkE = currX + PhotoView.this.RkE;
                PhotoView.this.RkF = currY + PhotoView.this.RkF;
                this.Rlk = this.Rlf.getCurrX();
                this.Rll = this.Rlf.getCurrY();
                z = false;
            }
            if (this.xsO.computeScrollOffset()) {
                int currX2 = this.xsO.getCurrX() - this.auo;
                int currY2 = this.xsO.getCurrY() - this.aup;
                this.auo = this.xsO.getCurrX();
                this.aup = this.xsO.getCurrY();
                PhotoView.this.RkE = currX2 + PhotoView.this.RkE;
                PhotoView.this.RkF = currY2 + PhotoView.this.RkF;
                z = false;
            }
            if (this.Rli.computeScrollOffset()) {
                PhotoView.this.RkD = (float) this.Rli.getCurrX();
                z = false;
            }
            if (this.Rlh.computeScrollOffset() || PhotoView.this.RkP != null) {
                float currX3 = ((float) this.Rlh.getCurrX()) / 10000.0f;
                float currY3 = ((float) this.Rlh.getCurrY()) / 10000.0f;
                PhotoView.this.xt.setScale(currX3, currY3, (PhotoView.this.RkJ.left + PhotoView.this.RkJ.right) / 2.0f, this.Rlj.hfP());
                PhotoView.this.xt.mapRect(this.Rlm, PhotoView.this.RkJ);
                if (currX3 == 1.0f) {
                    this.Rlm.left = PhotoView.this.xsQ.left;
                    this.Rlm.right = PhotoView.this.xsQ.right;
                }
                if (currY3 == 1.0f) {
                    this.Rlm.top = PhotoView.this.xsQ.top;
                    this.Rlm.bottom = PhotoView.this.xsQ.bottom;
                }
                PhotoView.this.RkP = this.Rlm;
            }
            if (!z) {
                hfQ();
                hfR();
                AppMethodBeat.o(164280);
                return;
            }
            this.isRunning = false;
            if (PhotoView.this.RkA) {
                if (PhotoView.this.RkJ.left > 0.0f) {
                    PhotoView.this.RkE = (int) (((float) PhotoView.this.RkE) - PhotoView.this.RkJ.left);
                } else if (PhotoView.this.RkJ.right < PhotoView.this.xsQ.width()) {
                    PhotoView.this.RkE -= (int) (PhotoView.this.xsQ.width() - PhotoView.this.RkJ.right);
                }
                z3 = true;
            }
            if (!PhotoView.this.RkB) {
                z2 = z3;
            } else if (PhotoView.this.RkJ.top > 0.0f) {
                PhotoView.this.RkF = (int) (((float) PhotoView.this.RkF) - PhotoView.this.RkJ.top);
            } else if (PhotoView.this.RkJ.bottom < PhotoView.this.xsQ.height()) {
                PhotoView.this.RkF -= (int) (PhotoView.this.xsQ.height() - PhotoView.this.RkJ.bottom);
            }
            if (z2) {
                hfQ();
            }
            PhotoView.this.invalidate();
            if (PhotoView.this.RkS != null) {
                PhotoView.this.post(new Runnable() {
                    /* class com.tencent.mm.view.PhotoView.h.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(164272);
                        PhotoView.this.RkS.run();
                        PhotoView.this.RkS = null;
                        PhotoView.this.invalidate();
                        AppMethodBeat.o(164272);
                    }
                });
            }
            AppMethodBeat.o(164280);
        }

        private void hfQ() {
            AppMethodBeat.i(164281);
            PhotoView.this.Rko.reset();
            PhotoView.this.Rko.postTranslate(-PhotoView.this.RkI.left, -PhotoView.this.RkI.top);
            PhotoView.this.Rko.postTranslate(PhotoView.this.RkN.x, PhotoView.this.RkN.y);
            PhotoView.this.Rko.postTranslate(-PhotoView.this.RkG, -PhotoView.this.RkH);
            PhotoView.this.Rko.postRotate(PhotoView.this.RkD, PhotoView.this.RkN.x, PhotoView.this.RkN.y);
            PhotoView.this.Rko.postScale(PhotoView.this.dhh, PhotoView.this.dhh, PhotoView.this.RkM.x, PhotoView.this.RkM.y);
            PhotoView.this.Rko.postTranslate((float) PhotoView.this.RkE, (float) PhotoView.this.RkF);
            PhotoView.g(PhotoView.this);
            AppMethodBeat.o(164281);
        }

        private void hfR() {
            AppMethodBeat.i(164282);
            if (this.isRunning) {
                PhotoView.this.post(this);
            }
            AppMethodBeat.o(164282);
        }
    }

    public Info getInfo() {
        AppMethodBeat.i(164315);
        Rect rect = new Rect();
        int[] iArr = new int[2];
        Rect rect2 = this.RkZ;
        Rect rect3 = new Rect();
        getGlobalVisibleRect(rect3);
        if (!rect2.isEmpty() && rect3.bottom - getHeight() < rect2.top) {
            rect3.top = rect3.bottom - getHeight();
        }
        iArr[0] = rect3.left;
        iArr[1] = rect3.top;
        iArr[0] = (int) (((float) iArr[0]) + 0.5f);
        iArr[1] = (int) (((float) iArr[1]) + 0.5f);
        rect.set(iArr[0] + ((int) this.RkJ.left), iArr[1] + ((int) this.RkJ.top), iArr[0] + ((int) this.RkJ.right), iArr[1] + ((int) this.RkJ.bottom));
        Info info = new Info(rect, this.RkJ, this.xsQ, this.RkI, this.RkL, this.dhh, this.RkD, this.Rks, this.RkZ);
        AppMethodBeat.o(164315);
        return info;
    }

    public void setGlobalVisibleView(View view) {
        AppMethodBeat.i(164316);
        view.getGlobalVisibleRect(this.RkZ);
        AppMethodBeat.o(164316);
    }

    private void reset() {
        AppMethodBeat.i(164317);
        this.Rko.reset();
        hfO();
        this.dhh = 1.0f;
        this.RkE = 0;
        this.RkF = 0;
        AppMethodBeat.o(164317);
    }

    public class g implements a {
        public g() {
        }

        @Override // com.tencent.mm.view.PhotoView.a
        public final float hfP() {
            AppMethodBeat.i(164271);
            float f2 = PhotoView.this.RkJ.top;
            AppMethodBeat.o(164271);
            return f2;
        }
    }

    public class b implements a {
        public b() {
        }

        @Override // com.tencent.mm.view.PhotoView.a
        public final float hfP() {
            AppMethodBeat.i(164260);
            float f2 = PhotoView.this.RkJ.bottom;
            AppMethodBeat.o(164260);
            return f2;
        }
    }

    public class d implements a {
        public d() {
        }

        @Override // com.tencent.mm.view.PhotoView.a
        public final float hfP() {
            AppMethodBeat.i(164269);
            float f2 = (PhotoView.this.RkJ.top + PhotoView.this.RkJ.bottom) / 2.0f;
            AppMethodBeat.o(164269);
            return f2;
        }
    }

    private void a(Info info) {
        AppMethodBeat.i(164318);
        if (this.isInit) {
            reset();
            this.RkZ.set(info.RkZ);
            Info info2 = getInfo();
            float width = info.RkJ.width() / info2.RkJ.width();
            float height = info.RkJ.height() / info2.RkJ.height();
            if (width >= height) {
                width = height;
            }
            float width2 = info.nYV.left + (info.nYV.width() / 2.0f);
            float height2 = info.nYV.top + (info.nYV.height() / 2.0f);
            float width3 = info2.nYV.left + (info2.nYV.width() / 2.0f);
            float height3 = (info2.nYV.height() / 2.0f) + info2.nYV.top;
            this.Rko.reset();
            this.Rko.postTranslate(width2 - width3, height2 - height3);
            this.Rko.postScale(width, width, width2, height2);
            this.Rko.postRotate(info.RkD, width2, height2);
            hfO();
            this.RkM.set(width2, height2);
            this.RkN.set(width2, height2);
            this.RkO.ma((int) (-(width2 - width3)), (int) (-(height2 - height3)));
            this.RkO.aD(width, 1.0f);
            this.RkO.mb((int) info.RkD, 0);
            if (info.xsQ.width() < info.RkJ.width() || info.xsQ.height() < info.RkJ.height()) {
                float width4 = info.xsQ.width() / info.RkJ.width();
                float height4 = info.xsQ.height() / info.RkJ.height();
                if (width4 > 1.0f) {
                    width4 = 1.0f;
                }
                if (height4 > 1.0f) {
                    height4 = 1.0f;
                }
                a gVar = info.Rks == ImageView.ScaleType.FIT_START ? new g() : info.Rks == ImageView.ScaleType.FIT_END ? new b() : new d();
                this.RkO.a(width4, height4, 1.0f - width4, 1.0f - height4, this.Rki / 3, gVar);
                this.xt.setScale(width4, height4, (this.RkJ.left + this.RkJ.right) / 2.0f, gVar.hfP());
                this.xt.mapRect(this.RkO.Rlm, this.RkJ);
                this.RkP = this.RkO.Rlm;
            }
            this.RkO.start();
            AppMethodBeat.o(164318);
            return;
        }
        this.RkQ = info;
        this.RkR = System.currentTimeMillis();
        AppMethodBeat.o(164318);
    }

    public static class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
            /* class com.tencent.mm.view.PhotoView.Info.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Info[] newArray(int i2) {
                return new Info[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Info createFromParcel(Parcel parcel) {
                AppMethodBeat.i(164261);
                Info info = new Info(parcel);
                AppMethodBeat.o(164261);
                return info;
            }
        };
        float RkD;
        RectF RkI = new RectF();
        RectF RkJ = new RectF();
        PointF RkL = new PointF();
        Rect RkZ = new Rect();
        ImageView.ScaleType Rks;
        float dhh;
        public RectF nYV = new RectF();
        RectF xsQ = new RectF();

        public Info(Rect rect, RectF rectF, RectF rectF2, RectF rectF3, PointF pointF, float f2, float f3, ImageView.ScaleType scaleType, Rect rect2) {
            AppMethodBeat.i(164262);
            this.nYV.set(rect);
            this.RkJ.set(rectF);
            this.xsQ.set(rectF2);
            this.dhh = f2;
            this.Rks = scaleType;
            this.RkD = f3;
            this.RkI.set(rectF3);
            this.RkL.set(pointF);
            this.RkZ.set(rect2);
            AppMethodBeat.o(164262);
        }

        public String toString() {
            AppMethodBeat.i(164263);
            String str = "Info{mRect=" + this.nYV + ", mImgRect=" + this.RkJ + ", mWidgetRect=" + this.xsQ + ", mBaseRect=" + this.RkI + ", mScale=" + this.dhh + '}';
            AppMethodBeat.o(164263);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(164264);
            parcel.writeParcelable(this.nYV, i2);
            parcel.writeParcelable(this.RkJ, i2);
            parcel.writeParcelable(this.xsQ, i2);
            parcel.writeParcelable(this.RkI, i2);
            parcel.writeParcelable(this.RkL, i2);
            parcel.writeParcelable(this.RkZ, i2);
            parcel.writeFloat(this.dhh);
            parcel.writeFloat(this.RkD);
            parcel.writeInt(this.Rks == null ? -1 : this.Rks.ordinal());
            AppMethodBeat.o(164264);
        }

        protected Info(Parcel parcel) {
            AppMethodBeat.i(164265);
            this.nYV = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
            this.RkJ = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
            this.xsQ = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
            this.RkI = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
            this.RkL = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
            this.RkZ = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.dhh = parcel.readFloat();
            this.RkD = parcel.readFloat();
            int readInt = parcel.readInt();
            this.Rks = readInt == -1 ? null : ImageView.ScaleType.values()[readInt];
            AppMethodBeat.o(164265);
        }

        static {
            AppMethodBeat.i(164266);
            AppMethodBeat.o(164266);
        }
    }

    public class f {
        e Rlc;
        float Rld;
        float Rle;
        float x1;
        float x2;
        float y1;
        float y2;

        public f(e eVar) {
            this.Rlc = eVar;
        }

        /* access modifiers changed from: package-private */
        public final float az(MotionEvent motionEvent) {
            AppMethodBeat.i(164270);
            this.x1 = motionEvent.getX(0);
            this.y1 = motionEvent.getY(0);
            this.x2 = motionEvent.getX(1);
            this.y2 = motionEvent.getY(1);
            float f2 = (this.y2 - this.y1) / (this.x2 - this.x1);
            AppMethodBeat.o(164270);
            return f2;
        }
    }

    static /* synthetic */ void t(PhotoView photoView) {
        AppMethodBeat.i(164321);
        if (!photoView.Rkw) {
            RectF rectF = photoView.xsQ;
            RectF rectF2 = photoView.RkJ;
            RectF rectF3 = photoView.RkK;
            float f2 = rectF.left > rectF2.left ? rectF.left : rectF2.left;
            float f3 = rectF.right < rectF2.right ? rectF.right : rectF2.right;
            if (f2 > f3) {
                rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
                AppMethodBeat.o(164321);
                return;
            }
            float f4 = rectF.top > rectF2.top ? rectF.top : rectF2.top;
            float f5 = rectF.bottom < rectF2.bottom ? rectF.bottom : rectF2.bottom;
            if (f4 > f5) {
                rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
                AppMethodBeat.o(164321);
                return;
            }
            rectF3.set(f2, f4, f3, f5);
        }
        AppMethodBeat.o(164321);
    }

    static /* synthetic */ float a(PhotoView photoView, float f2, float f3) {
        AppMethodBeat.i(164322);
        float abs = (Math.abs(Math.abs(f2) - ((float) photoView.Rkm)) / ((float) photoView.Rkm)) * f3;
        AppMethodBeat.o(164322);
        return abs;
    }

    static /* synthetic */ float b(PhotoView photoView, float f2, float f3) {
        AppMethodBeat.i(164323);
        float abs = (Math.abs(Math.abs(f2) - ((float) photoView.Rkm)) / ((float) photoView.Rkm)) * f3;
        AppMethodBeat.o(164323);
        return abs;
    }
}
