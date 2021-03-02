package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MultiGestureImageView extends LinearLayout {
    private int auo;
    private int aup;
    private int count = 0;
    private float dhm;
    private int mEX;
    private int mEY;
    private MultiTouchImageView xsH;
    private long xsI = 0;
    private long xsJ = 0;
    private float xsK = 0.0f;
    private float xsL = 0.0f;
    private long xsM = 0;
    private boolean xsN = false;
    private OverScroller xsO;
    private GestureDetector xsP;
    private RectF xsQ = new RectF();
    private a xsR;
    private float xsS;
    private boolean xsT = false;
    private boolean xsU = false;
    private boolean xsV = false;
    private boolean xsW = false;
    private j xsX;
    private j xsY;
    private j xsZ;
    private d xta;
    private b xtb;

    public interface b {
    }

    public interface d {
    }

    static /* synthetic */ void e(MultiGestureImageView multiGestureImageView) {
        AppMethodBeat.i(111782);
        multiGestureImageView.dSC();
        AppMethodBeat.o(111782);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111768);
        init(context, attributeSet);
        AppMethodBeat.o(111768);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(111769);
        init(context, attributeSet);
        AppMethodBeat.o(111769);
    }

    public void setSingleClickOverListener(d dVar) {
        this.xta = dVar;
    }

    public void setLongClickOverListener(b bVar) {
        this.xtb = bVar;
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(111770);
        this.xsH = new MultiTouchImageView(context, attributeSet);
        this.xsP = new GestureDetector(context, new c(this, (byte) 0));
        this.xsO = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.xsH.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(this.xsH);
        this.xsX = new j(new WeakReference(this));
        this.xsY = new j(new WeakReference(this));
        this.xsZ = new j(new WeakReference(this));
        AppMethodBeat.o(111770);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(111771);
        super.onMeasure(i2, i3);
        this.mEX = View.MeasureSpec.getSize(i2);
        this.mEY = View.MeasureSpec.getSize(i3);
        this.xsQ.set(0.0f, 0.0f, (float) this.mEX, (float) this.mEY);
        Log.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.mEX + " height:" + this.mEY);
        AppMethodBeat.o(111771);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(111772);
        GestureDetector gestureDetector = this.xsP;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (motionEvent.getAction() == 0) {
            this.xsO.forceFinished(true);
            this.xsZ.removeMessages(2);
            this.xsZ.m(2, 500, 0);
            this.xsH.gKA();
            this.count++;
            if (this.count == 1) {
                this.xsI = System.currentTimeMillis();
                this.xsK = com.tencent.mm.ui.base.f.j(motionEvent, 0);
                this.xsL = com.tencent.mm.ui.base.f.k(motionEvent, 0);
            } else if (this.count == 2) {
                this.xsM = System.currentTimeMillis();
                if (this.xsM - this.xsJ >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f || Math.abs(this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    Log.d("MicroMsg.MultiGestureImageView", "double click!");
                    if (this.xsH.getScale() <= this.xsH.getScaleRate()) {
                        this.xsH.y(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                    } else {
                        this.xsH.at(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                        this.xsH.gKz();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
            this.xsZ.removeMessages(2);
            this.dhm = 0.0f;
            this.xsS = this.xsH.getScale();
            this.xsN = true;
            if (this.xsS < this.xsH.getScaleRate()) {
                this.xsH.at((com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1), (com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1)) + com.tencent.mm.ui.base.f.k(motionEvent, 1));
            }
            if (this.xsS > this.xsH.getDoubleTabScale()) {
                this.xsH.y((com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1), (com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1)) + com.tencent.mm.ui.base.f.k(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.xsZ.removeMessages(2);
            if ((this.xsV || this.xsW) && (this.xsT || this.xsU)) {
                this.xsR = new f(this.xsH);
                dSD();
                this.xsV = false;
                this.xsW = false;
                this.xsT = false;
                this.xsU = false;
            } else {
                if (this.xsV) {
                    this.xsV = false;
                    this.xsR = new g(this.xsH);
                    dSD();
                }
                if (this.xsW) {
                    this.xsW = false;
                    this.xsR = new h(this.xsH);
                    dSD();
                }
                if (this.xsT) {
                    this.xsT = false;
                    this.xsR = new i(this.xsH);
                    dSD();
                }
                if (this.xsU) {
                    this.xsU = false;
                    this.xsR = new e(this.xsH);
                    dSD();
                }
            }
            this.dhm = 0.0f;
            this.xsS = this.xsH.getScale();
            if (this.count == 1) {
                this.xsJ = System.currentTimeMillis();
                if (this.xsJ - this.xsI >= 350) {
                    this.count = 0;
                    Log.d("MicroMsg.MultiGestureImageView", "single long click over!");
                } else if (Math.abs(this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f && Math.abs(this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) < 10.0f) {
                    j jVar = this.xsY;
                    jVar.edG = false;
                    jVar.m(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
            this.dhm = 0.0f;
            this.xsS = this.xsH.getScale();
            this.xsN = true;
        }
        if (motionEvent.getAction() == 2) {
            if (com.tencent.mm.ui.base.f.ai(motionEvent) == 2) {
                this.xsZ.removeMessages(2);
                this.xsN = true;
                this.count = 0;
                float j2 = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                float k = com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((j2 * j2) + (k * k)));
                if (this.dhm == 0.0f) {
                    this.dhm = sqrt;
                } else {
                    float f2 = sqrt / this.dhm;
                    if (this.xsN) {
                        this.xsH.r(f2 * this.xsS, j2 + com.tencent.mm.ui.base.f.j(motionEvent, 1), k + com.tencent.mm.ui.base.f.k(motionEvent, 1));
                        this.xsH.gKz();
                    }
                }
            } else if (Math.abs(this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 10.0f || Math.abs(this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) > 10.0f) {
                this.xsZ.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        AppMethodBeat.o(111772);
        return true;
    }

    public void computeScroll() {
        int i2 = 0;
        AppMethodBeat.i(111773);
        if (this.xsH == null) {
            AppMethodBeat.o(111773);
            return;
        }
        if (this.xsO.computeScrollOffset()) {
            int currX = this.xsO.getCurrX() - this.auo;
            int currY = this.xsO.getCurrY() - this.aup;
            this.auo = this.xsO.getCurrX();
            this.aup = this.xsO.getCurrY();
            float scale = this.xsH.getScale();
            float imageWidth = ((float) this.xsH.getImageWidth()) * scale;
            float imageHeight = scale * ((float) this.xsH.getImageHeight());
            float[] fArr = new float[9];
            this.xsH.getImageMatrix().getValues(fArr);
            float f2 = fArr[2];
            float f3 = imageWidth + f2;
            float f4 = fArr[5];
            float f5 = f4 + imageHeight;
            if (currX < 0 && ((float) currX) < this.xsQ.right - ((float) Math.round(f3))) {
                currX = (int) (this.xsQ.right - ((float) Math.round(f3)));
            }
            if (currX > 0 && ((float) currX) > this.xsQ.left - ((float) Math.round(f2))) {
                currX = (int) (this.xsQ.left - ((float) Math.round(f2)));
            }
            if (currY < 0 && ((float) currY) < this.xsQ.bottom - ((float) Math.round(f5))) {
                currY = (int) (this.xsQ.bottom - ((float) Math.round(f5)));
            }
            if (currY > 0 && ((float) currY) > this.xsQ.top - ((float) Math.round(f4))) {
                currY = (int) (this.xsQ.top - ((float) Math.round(f4)));
            }
            if (((float) Math.round(f2)) >= this.xsQ.left || ((float) Math.round(f3)) <= this.xsQ.right) {
                currX = 0;
            } else if (((float) Math.round(f4)) >= this.xsQ.top || ((float) Math.round(f5)) <= this.xsQ.bottom) {
                currY = 0;
            }
            if (imageHeight >= ((float) this.mEY)) {
                i2 = currY;
            }
            this.xsH.au((float) currX, (float) i2);
            postInvalidate();
        }
        AppMethodBeat.o(111773);
    }

    /* access modifiers changed from: package-private */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(257766);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257766);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(257765);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(257765);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(257764);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257764);
            return onSingleTapUp;
        }

        private c() {
        }

        /* synthetic */ c(MultiGestureImageView multiGestureImageView, byte b2) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(257763);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(257763);
            return true;
        }
    }

    public class j extends MMHandler {
        boolean edG;
        WeakReference<MultiGestureImageView> oi;
        private long xtj;

        public j(WeakReference<MultiGestureImageView> weakReference) {
            this.oi = weakReference;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
            r0 = r5.oi.get();
         */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r6) {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.view.MultiGestureImageView.j.handleMessage(android.os.Message):void");
        }

        public final void m(int i2, long j2, long j3) {
            AppMethodBeat.i(111767);
            this.xtj = j3;
            sendEmptyMessageDelayed(i2, j2);
            AppMethodBeat.o(111767);
        }
    }

    private void dSC() {
        AppMethodBeat.i(111774);
        this.xsX.removeMessages(1);
        AppMethodBeat.o(111774);
    }

    private void dSD() {
        AppMethodBeat.i(111775);
        dSC();
        this.xsX.m(1, 15, 15);
        AppMethodBeat.o(111775);
    }

    /* access modifiers changed from: package-private */
    public abstract class a {
        protected boolean dgZ = false;

        public abstract void play();

        public a() {
        }

        public final boolean deQ() {
            return this.dgZ;
        }
    }

    class g extends a {
        MultiTouchImageView lTJ;
        float[] xtd = new float[9];

        public g(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(111756);
            this.lTJ = multiTouchImageView;
            AppMethodBeat.o(111756);
        }

        @Override // com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a
        public final void play() {
            AppMethodBeat.i(111757);
            MultiGestureImageView.this.xsH.getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g.AnonymousClass1 */

                public final void run() {
                    float f2;
                    AppMethodBeat.i(111755);
                    g.this.lTJ.getImageMatrix().getValues(g.this.xtd);
                    float f3 = g.this.xtd[2];
                    float scale = g.this.lTJ.getScale() * ((float) g.this.lTJ.getImageWidth());
                    if (scale < ((float) MultiGestureImageView.this.mEX)) {
                        f2 = (((float) MultiGestureImageView.this.mEX) / 2.0f) - (scale / 2.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    float f4 = f2 - f3;
                    if (f4 >= 0.0f) {
                        g.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        g.this.dgZ = true;
                    } else {
                        f4 = (-((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    g.this.lTJ.au(f4, 0.0f);
                    AppMethodBeat.o(111755);
                }
            });
            AppMethodBeat.o(111757);
        }
    }

    class h extends a {
        MultiTouchImageView lTJ;
        float[] xtd = new float[9];

        public h(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(111759);
            this.lTJ = multiTouchImageView;
            AppMethodBeat.o(111759);
        }

        @Override // com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a
        public final void play() {
            AppMethodBeat.i(111760);
            MultiGestureImageView.this.xsH.getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(111758);
                    h.this.lTJ.getImageMatrix().getValues(h.this.xtd);
                    float imageWidth = ((float) h.this.lTJ.getImageWidth()) * h.this.lTJ.getScale();
                    float f2 = h.this.xtd[2] + imageWidth;
                    float f3 = (float) MultiGestureImageView.this.mEX;
                    if (imageWidth < ((float) MultiGestureImageView.this.mEX)) {
                        f3 = (((float) MultiGestureImageView.this.mEX) / 2.0f) + (imageWidth / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (f4 <= 0.0f) {
                        h.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        h.this.dgZ = true;
                    } else {
                        f4 = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    h.this.lTJ.au(f4, 0.0f);
                    AppMethodBeat.o(111758);
                }
            });
            AppMethodBeat.o(111760);
        }
    }

    class i extends a {
        MultiTouchImageView lTJ;
        float[] xtd = new float[9];

        public i(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(111762);
            this.lTJ = multiTouchImageView;
            AppMethodBeat.o(111762);
        }

        @Override // com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a
        public final void play() {
            AppMethodBeat.i(111763);
            MultiGestureImageView.this.xsH.getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.view.MultiGestureImageView.i.AnonymousClass1 */

                public final void run() {
                    float f2;
                    AppMethodBeat.i(111761);
                    i.this.lTJ.getImageMatrix().getValues(i.this.xtd);
                    float f3 = i.this.xtd[5];
                    float scale = i.this.lTJ.getScale() * ((float) i.this.lTJ.getImageHeight());
                    if (scale < ((float) MultiGestureImageView.this.mEY)) {
                        f2 = (((float) MultiGestureImageView.this.mEY) / 2.0f) - (scale / 2.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    float f4 = f2 - f3;
                    if (f4 >= 0.0f) {
                        i.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        i.this.dgZ = true;
                    } else {
                        f4 = (-((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    i.this.lTJ.au(0.0f, f4);
                    AppMethodBeat.o(111761);
                }
            });
            AppMethodBeat.o(111763);
        }
    }

    class e extends a {
        MultiTouchImageView lTJ;
        float[] xtd = new float[9];

        public e(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(111750);
            this.lTJ = multiTouchImageView;
            AppMethodBeat.o(111750);
        }

        @Override // com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a
        public final void play() {
            AppMethodBeat.i(111751);
            MultiGestureImageView.this.xsH.getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(111749);
                    e.this.lTJ.getImageMatrix().getValues(e.this.xtd);
                    float imageHeight = ((float) e.this.lTJ.getImageHeight()) * e.this.lTJ.getScale();
                    float f2 = e.this.xtd[5] + imageHeight;
                    float f3 = (float) MultiGestureImageView.this.mEY;
                    if (imageHeight < ((float) MultiGestureImageView.this.mEY)) {
                        f3 = (((float) MultiGestureImageView.this.mEY) / 2.0f) + (imageHeight / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (f4 <= 0.0f) {
                        e.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        e.this.dgZ = true;
                    } else {
                        f4 = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    e.this.lTJ.au(0.0f, f4);
                    AppMethodBeat.o(111749);
                }
            });
            AppMethodBeat.o(111751);
        }
    }

    class f extends a {
        MultiTouchImageView lTJ;
        float[] xtd = new float[9];

        public f(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(111753);
            this.lTJ = multiTouchImageView;
            AppMethodBeat.o(111753);
        }

        @Override // com.tencent.mm.plugin.gallery.view.MultiGestureImageView.a
        public final void play() {
            AppMethodBeat.i(111754);
            MultiGestureImageView.this.xsH.getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.view.MultiGestureImageView.f.AnonymousClass1 */

                public final void run() {
                    float f2;
                    float f3;
                    AppMethodBeat.i(111752);
                    f.this.lTJ.getImageMatrix().getValues(f.this.xtd);
                    float scale = f.this.lTJ.getScale() * ((float) f.this.lTJ.getImageWidth());
                    float imageHeight = ((float) f.this.lTJ.getImageHeight()) * f.this.lTJ.getScale();
                    float f4 = f.this.xtd[2];
                    float f5 = f.this.xtd[5];
                    float f6 = f.this.xtd[2] + scale;
                    float f7 = f.this.xtd[5] + imageHeight;
                    float f8 = 0.0f;
                    float f9 = (float) MultiGestureImageView.this.mEY;
                    float f10 = 0.0f;
                    float f11 = (float) MultiGestureImageView.this.mEX;
                    if (imageHeight < ((float) MultiGestureImageView.this.mEY)) {
                        f8 = (((float) MultiGestureImageView.this.mEY) / 2.0f) - (imageHeight / 2.0f);
                        f2 = (((float) MultiGestureImageView.this.mEY) / 2.0f) + (imageHeight / 2.0f);
                    } else {
                        f2 = f9;
                    }
                    float f12 = f8 - f5;
                    float f13 = f2 - f7;
                    if (f12 >= 0.0f) {
                        if (f13 > 0.0f) {
                            f12 = f13;
                        } else {
                            f12 = 0.0f;
                        }
                    }
                    if (scale < ((float) MultiGestureImageView.this.mEX)) {
                        float f14 = (((float) MultiGestureImageView.this.mEX) / 2.0f) - (scale / 2.0f);
                        f3 = (((float) MultiGestureImageView.this.mEX) / 2.0f) + (scale / 2.0f);
                        f10 = f14;
                    } else {
                        f3 = f11;
                    }
                    float f15 = f10 - f4;
                    float f16 = f3 - f6;
                    if (f15 >= 0.0f) {
                        if (f16 > 0.0f) {
                            f15 = f16;
                        } else {
                            f15 = 0.0f;
                        }
                    }
                    if (Math.abs(f15) > 5.0f || Math.abs(f12) > 5.0f) {
                        if (f15 >= 0.0f) {
                            f15 = ((float) (((double) Math.abs(f15)) - Math.pow(Math.sqrt((double) Math.abs(f15)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            f15 = (-((float) (((double) Math.abs(f15)) - Math.pow(Math.sqrt((double) Math.abs(f15)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (f12 >= 0.0f) {
                            f12 = ((float) (((double) Math.abs(f12)) - Math.pow(Math.sqrt((double) Math.abs(f12)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            f12 = (-((float) (((double) Math.abs(f12)) - Math.pow(Math.sqrt((double) Math.abs(f12)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        f.this.dgZ = true;
                    }
                    f.this.lTJ.au(f15, f12);
                    AppMethodBeat.o(111752);
                }
            });
            AppMethodBeat.o(111754);
        }
    }

    public void setEnableHorLongBmpMode(boolean z) {
        AppMethodBeat.i(111776);
        this.xsH.setEnableHorLongBmpMode(z);
        AppMethodBeat.o(111776);
    }

    public int getImageWidth() {
        AppMethodBeat.i(111777);
        int imageWidth = this.xsH.getImageWidth();
        AppMethodBeat.o(111777);
        return imageWidth;
    }

    public void setImageWidth(int i2) {
        AppMethodBeat.i(111778);
        this.xsH.setImageWidth(i2);
        AppMethodBeat.o(111778);
    }

    public int getImageHeight() {
        AppMethodBeat.i(111779);
        int imageHeight = this.xsH.getImageHeight();
        AppMethodBeat.o(111779);
        return imageHeight;
    }

    public void setImageHeight(int i2) {
        AppMethodBeat.i(111780);
        this.xsH.setImageHeight(i2);
        AppMethodBeat.o(111780);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(111781);
        this.xsH.setImageBitmap(bitmap);
        this.xsH.gKy();
        AppMethodBeat.o(111781);
    }
}
