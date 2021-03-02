package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private boolean EHq = false;
    private boolean EHr = false;
    private boolean EHs = false;
    private boolean OTW = false;
    private boolean OTX = false;
    private boolean OTY = false;
    private boolean OTZ = false;
    private boolean OUa = false;
    private final int OUq = 60;
    private final int OUr = 500;
    private l QuB;
    private l QuC;
    private l QuD;
    private a QuE;
    private f QuF;
    private c QuG;
    private e QuH;
    private boolean QuI = true;
    private b QuJ;
    private float aZg = 0.0f;
    private float aZh = 0.0f;
    private int auo;
    private int aup;
    private int count = 0;
    private float dhm;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private MultiTouchImageView lTJ;
    private int mEX;
    private int mEY;
    private VelocityTracker mVelocityTracker;
    private long xsI = 0;
    private long xsJ = 0;
    private float xsK = 0.0f;
    private float xsL = 0.0f;
    private long xsM = 0;
    private boolean xsN = false;
    private OverScroller xsO;
    private GestureDetector xsP;
    private RectF xsQ = new RectF();
    private float xsS;
    private boolean xsT = false;
    private boolean xsU = false;
    private boolean xsV = false;
    private boolean xsW = false;

    public interface b {
        void S(float f2, float f3);

        void T(float f2, float f3);
    }

    public interface c {
        void bmu();
    }

    public interface e {
    }

    public interface f {
        void bmt();
    }

    static /* synthetic */ void S(MMGestureGallery mMGestureGallery) {
        AppMethodBeat.i(143154);
        mMGestureGallery.dSC();
        AppMethodBeat.o(143154);
    }

    static /* synthetic */ int v(MMGestureGallery mMGestureGallery) {
        int i2 = mMGestureGallery.count;
        mMGestureGallery.count = i2 + 1;
        return i2;
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

    class i extends a {
        float[] xtd = new float[9];

        public i() {
            super();
            AppMethodBeat.i(143124);
            AppMethodBeat.o(143124);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.a
        public final void play() {
            AppMethodBeat.i(143125);
            MMGestureGallery.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.MMGestureGallery.i.AnonymousClass1 */

                public final void run() {
                    float f2;
                    AppMethodBeat.i(143123);
                    MMGestureGallery.this.lTJ.getImageMatrix().getValues(i.this.xtd);
                    float f3 = i.this.xtd[2];
                    float scale = MMGestureGallery.this.lTJ.getScale() * ((float) MMGestureGallery.this.lTJ.getImageWidth());
                    if (scale < ((float) MMGestureGallery.this.mEX)) {
                        f2 = (((float) MMGestureGallery.this.mEX) / 2.0f) - (scale / 2.0f);
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
                    MMGestureGallery.this.lTJ.au(f4, 0.0f);
                    AppMethodBeat.o(143123);
                }
            });
            AppMethodBeat.o(143125);
        }
    }

    class j extends a {
        float[] xtd = new float[9];

        public j() {
            super();
            AppMethodBeat.i(143127);
            AppMethodBeat.o(143127);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.a
        public final void play() {
            AppMethodBeat.i(143128);
            MMGestureGallery.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.MMGestureGallery.j.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(143126);
                    MMGestureGallery.this.lTJ.getImageMatrix().getValues(j.this.xtd);
                    float imageWidth = ((float) MMGestureGallery.this.lTJ.getImageWidth()) * MMGestureGallery.this.lTJ.getScale();
                    float f2 = j.this.xtd[2] + imageWidth;
                    float f3 = (float) MMGestureGallery.this.mEX;
                    if (imageWidth < ((float) MMGestureGallery.this.mEX)) {
                        f3 = (((float) MMGestureGallery.this.mEX) / 2.0f) + (imageWidth / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (f4 <= 0.0f) {
                        j.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        j.this.dgZ = true;
                    } else {
                        f4 = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMGestureGallery.this.lTJ.au(f4, 0.0f);
                    AppMethodBeat.o(143126);
                }
            });
            AppMethodBeat.o(143128);
        }
    }

    class k extends a {
        float[] xtd = new float[9];

        public k() {
            super();
            AppMethodBeat.i(143130);
            AppMethodBeat.o(143130);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.a
        public final void play() {
            AppMethodBeat.i(143131);
            MMGestureGallery.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.MMGestureGallery.k.AnonymousClass1 */

                public final void run() {
                    float f2;
                    AppMethodBeat.i(143129);
                    MMGestureGallery.this.lTJ.getImageMatrix().getValues(k.this.xtd);
                    float f3 = k.this.xtd[5];
                    float scale = MMGestureGallery.this.lTJ.getScale() * ((float) MMGestureGallery.this.lTJ.getImageHeight());
                    if (scale < ((float) MMGestureGallery.this.mEY)) {
                        f2 = (((float) MMGestureGallery.this.mEY) / 2.0f) - (scale / 2.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    float f4 = f2 - f3;
                    if (f4 >= 0.0f) {
                        k.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        k.this.dgZ = true;
                    } else {
                        f4 = (-((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMGestureGallery.this.lTJ.au(0.0f, f4);
                    AppMethodBeat.o(143129);
                }
            });
            AppMethodBeat.o(143131);
        }
    }

    class g extends a {
        float[] xtd = new float[9];

        public g() {
            super();
            AppMethodBeat.i(143118);
            AppMethodBeat.o(143118);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.a
        public final void play() {
            AppMethodBeat.i(143119);
            MMGestureGallery.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.MMGestureGallery.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(143117);
                    MMGestureGallery.this.lTJ.getImageMatrix().getValues(g.this.xtd);
                    float imageHeight = ((float) MMGestureGallery.this.lTJ.getImageHeight()) * MMGestureGallery.this.lTJ.getScale();
                    float f2 = g.this.xtd[5] + imageHeight;
                    float f3 = (float) MMGestureGallery.this.mEY;
                    if (imageHeight < ((float) MMGestureGallery.this.mEY)) {
                        f3 = (((float) MMGestureGallery.this.mEY) / 2.0f) + (imageHeight / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (f4 <= 0.0f) {
                        g.this.dgZ = true;
                    } else if (Math.abs(f4) <= 5.0f) {
                        g.this.dgZ = true;
                    } else {
                        f4 = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMGestureGallery.this.lTJ.au(0.0f, f4);
                    AppMethodBeat.o(143117);
                }
            });
            AppMethodBeat.o(143119);
        }
    }

    class h extends a {
        float[] xtd = new float[9];

        public h() {
            super();
            AppMethodBeat.i(143121);
            AppMethodBeat.o(143121);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.a
        public final void play() {
            AppMethodBeat.i(143122);
            MMGestureGallery.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.MMGestureGallery.h.AnonymousClass1 */

                public final void run() {
                    float f2;
                    float f3;
                    AppMethodBeat.i(143120);
                    MMGestureGallery.this.lTJ.getImageMatrix().getValues(h.this.xtd);
                    float scale = MMGestureGallery.this.lTJ.getScale() * ((float) MMGestureGallery.this.lTJ.getImageWidth());
                    float imageHeight = ((float) MMGestureGallery.this.lTJ.getImageHeight()) * MMGestureGallery.this.lTJ.getScale();
                    float f4 = h.this.xtd[2];
                    float f5 = h.this.xtd[5];
                    float f6 = h.this.xtd[2] + scale;
                    float f7 = h.this.xtd[5] + imageHeight;
                    float f8 = 0.0f;
                    float f9 = (float) MMGestureGallery.this.mEY;
                    float f10 = 0.0f;
                    float f11 = (float) MMGestureGallery.this.mEX;
                    if (imageHeight < ((float) MMGestureGallery.this.mEY)) {
                        f8 = (((float) MMGestureGallery.this.mEY) / 2.0f) - (imageHeight / 2.0f);
                        f2 = (((float) MMGestureGallery.this.mEY) / 2.0f) + (imageHeight / 2.0f);
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
                    if (scale < ((float) MMGestureGallery.this.mEX)) {
                        float f14 = (((float) MMGestureGallery.this.mEX) / 2.0f) - (scale / 2.0f);
                        f3 = (((float) MMGestureGallery.this.mEX) / 2.0f) + (scale / 2.0f);
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
                        h.this.dgZ = true;
                    }
                    MMGestureGallery.this.lTJ.au(f15, f12);
                    AppMethodBeat.o(143120);
                }
            });
            AppMethodBeat.o(143122);
        }
    }

    public void setSingleClickOverListener(f fVar) {
        this.QuF = fVar;
    }

    public void setLongClickOverListener(c cVar) {
        this.QuG = cVar;
    }

    public void setScrollLeftRightListener(e eVar) {
        this.QuH = eVar;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143137);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(143137);
    }

    private void dSC() {
        AppMethodBeat.i(143138);
        this.QuB.removeMessages(1);
        AppMethodBeat.o(143138);
    }

    public void setGalleryScaleListener(b bVar) {
        this.QuJ = bVar;
    }

    public void setLoadQuit(boolean z) {
        this.QuI = z;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143139);
        setStaticTransformationsEnabled(true);
        this.xsP = new GestureDetector(context, new d(this, (byte) 0));
        this.QuB = new l(new WeakReference(this));
        this.QuC = new l(new WeakReference(this));
        this.QuD = new l(new WeakReference(this));
        this.xsO = new OverScroller(context, new DecelerateInterpolator(2.0f));
        float f2 = getResources().getDisplayMetrics().density;
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.MMGestureGallery.AnonymousClass1 */

            private void gXG() {
                AppMethodBeat.i(143113);
                gXH();
                MMGestureGallery.this.QuD.m(2, 500, 0);
                AppMethodBeat.o(143113);
            }

            private void gXH() {
                AppMethodBeat.i(143114);
                MMGestureGallery.this.QuD.removeMessages(2);
                AppMethodBeat.o(143114);
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143115);
                if (MMGestureGallery.this.mVelocityTracker == null) {
                    MMGestureGallery.this.mVelocityTracker = VelocityTracker.obtain();
                }
                MMGestureGallery.this.mVelocityTracker.addMovement(motionEvent);
                View selectedView = MMGestureGallery.this.getSelectedView();
                if (selectedView != null) {
                    if (motionEvent.getAction() == 0) {
                        MMGestureGallery.this.aZg = motionEvent.getX();
                        MMGestureGallery.this.aZh = motionEvent.getY();
                    }
                    if (motionEvent.getAction() == 1) {
                        if (MMGestureGallery.this.EHr) {
                            if (MMGestureGallery.this.QuJ != null) {
                                MMGestureGallery.this.QuJ.S(0.0f, 0.0f);
                            }
                            MMGestureGallery.this.EHq = false;
                        }
                        if (MMGestureGallery.this.EHq && !MMGestureGallery.this.OTW) {
                            MMGestureGallery.this.QuC.S(0, true);
                            MMGestureGallery.this.EHq = false;
                        }
                    }
                    if (motionEvent.getAction() == 2 && com.tencent.mm.ui.base.f.ai(motionEvent) < 2) {
                        VelocityTracker velocityTracker = MMGestureGallery.this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        int xVelocity = (int) velocityTracker.getXVelocity();
                        int yVelocity = (int) velocityTracker.getYVelocity();
                        float x = motionEvent.getX() - MMGestureGallery.this.aZg;
                        float y = motionEvent.getY() - MMGestureGallery.this.aZh;
                        if (MMGestureGallery.this.QuJ != null && !MMGestureGallery.this.OTW && !MMGestureGallery.this.xsN) {
                            MMGestureGallery.this.QuJ.T(x, y);
                            if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || MMGestureGallery.this.EHs) && !MMGestureGallery.this.EHq) {
                                MMGestureGallery.this.EHq = false;
                            } else {
                                MMGestureGallery.this.QuJ.S(x, y);
                                MMGestureGallery.this.EHq = true;
                            }
                            if (y > 200.0f) {
                                MMGestureGallery.this.EHr = false;
                            } else {
                                MMGestureGallery.this.EHr = true;
                            }
                        }
                        if (MMGestureGallery.this.mVelocityTracker != null) {
                            MMGestureGallery.this.mVelocityTracker.recycle();
                            MMGestureGallery.this.mVelocityTracker = null;
                        }
                    }
                }
                if (selectedView instanceof ViewGroup) {
                    if (motionEvent.getAction() == 0) {
                        MMGestureGallery.this.xsK = com.tencent.mm.ui.base.f.j(motionEvent, 0);
                        MMGestureGallery.this.xsL = com.tencent.mm.ui.base.f.k(motionEvent, 0);
                    }
                    View findViewById = selectedView.findViewById(R.id.dup);
                    if (findViewById != null && findViewById.getVisibility() == 0 && !(findViewById instanceof MultiTouchImageView)) {
                        if (motionEvent.getAction() == 0) {
                            gXG();
                        }
                        if (motionEvent.getAction() == 1) {
                            gXH();
                        }
                    }
                    View findViewById2 = selectedView.findViewById(R.id.j54);
                    if (findViewById2 != null && findViewById2.getVisibility() == 0 && !(findViewById2 instanceof MultiTouchImageView)) {
                        if (motionEvent.getAction() == 0) {
                            gXG();
                        }
                        if (motionEvent.getAction() == 1) {
                            gXH();
                        }
                    }
                    View findViewById3 = selectedView.findViewById(R.id.j6y);
                    if (findViewById3 != null && findViewById3.getVisibility() == 0) {
                        if (motionEvent.getAction() == 0) {
                            gXG();
                        }
                        if (motionEvent.getAction() == 1) {
                            gXH();
                        }
                    }
                    View findViewById4 = selectedView.findViewById(R.id.dvp);
                    if ((findViewById4 == null || findViewById4.getVisibility() == 8) && MMGestureGallery.this.QuI && MMGestureGallery.this.QuF != null && motionEvent.getAction() == 1 && Math.abs(MMGestureGallery.this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) < 10.0f && !MMGestureGallery.this.EHs) {
                        CI(true);
                    }
                    if (motionEvent.getAction() == 1) {
                        MMGestureGallery.this.EHs = false;
                    }
                    if (findViewById4 == null || (selectedView = findViewById4.findViewById(R.id.dup)) == null) {
                        AppMethodBeat.o(143115);
                        return false;
                    }
                }
                if (selectedView instanceof MultiTouchImageView) {
                    MMGestureGallery.this.lTJ = (MultiTouchImageView) selectedView;
                    Log.d("dktest", "MMGestureGallery onTouch event.getAction():" + motionEvent.getAction());
                    if (motionEvent.getAction() == 0) {
                        gXG();
                        MMGestureGallery.this.lTJ.gKA();
                        MMGestureGallery.this.dhm = 0.0f;
                        MMGestureGallery.this.xsS = MMGestureGallery.this.lTJ.getScale();
                        Log.d("dktest", "originalScale :" + MMGestureGallery.this.xsS);
                        MMGestureGallery.this.xsN = false;
                        MMGestureGallery.v(MMGestureGallery.this);
                        if (MMGestureGallery.this.count == 1) {
                            MMGestureGallery.this.xsI = System.currentTimeMillis();
                            MMGestureGallery.this.xsK = com.tencent.mm.ui.base.f.j(motionEvent, 0);
                            MMGestureGallery.this.xsL = com.tencent.mm.ui.base.f.k(motionEvent, 0);
                        } else if (MMGestureGallery.this.count == 2) {
                            MMGestureGallery.this.xsM = System.currentTimeMillis();
                            if (MMGestureGallery.this.xsM - MMGestureGallery.this.xsJ >= 350) {
                                MMGestureGallery.this.count = 1;
                            } else if (Math.abs(MMGestureGallery.this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f || Math.abs(MMGestureGallery.this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) >= 35.0f) {
                                MMGestureGallery.this.count = 1;
                            } else {
                                MMGestureGallery.this.count = 0;
                                Log.d("MicroMsg.MMGestureGallery", "double click!");
                                float scale = MMGestureGallery.this.lTJ.getScale();
                                Log.i("MicroMsg.MMGestureGallery", "currentScale:%f, scale:%f", Float.valueOf(scale), Float.valueOf(MMGestureGallery.this.lTJ.getScaleRate()));
                                if (scale <= MMGestureGallery.this.lTJ.getScaleRate()) {
                                    MMGestureGallery.this.lTJ.y(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                                } else if (MMGestureGallery.this.lTJ.getOriginScale() <= 0.0f) {
                                    MMGestureGallery.this.lTJ.at(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                                    MMGestureGallery.this.lTJ.gKz();
                                } else if (((double) scale) <= ((double) MMGestureGallery.this.lTJ.getOriginScale()) + 0.05d) {
                                    MMGestureGallery.this.lTJ.y(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                                } else {
                                    MMGestureGallery.this.lTJ.av(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                                }
                            }
                        }
                    }
                    if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
                        gXH();
                        MMGestureGallery.this.dhm = 0.0f;
                        MMGestureGallery.this.xsS = MMGestureGallery.this.lTJ.getScale();
                        MMGestureGallery.this.xsN = true;
                        Log.i("MicroMsg.MMGestureGallery", "originalScale:%f, scale:%f", Float.valueOf(MMGestureGallery.this.xsS), Float.valueOf(MMGestureGallery.this.lTJ.getScaleRate()));
                        if (MMGestureGallery.this.xsS < MMGestureGallery.this.lTJ.getScaleRate()) {
                            float j2 = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            float k = com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1);
                            float originScale = MMGestureGallery.this.lTJ.getOriginScale();
                            if (originScale <= 0.0f) {
                                MMGestureGallery.this.lTJ.at(j2 + com.tencent.mm.ui.base.f.j(motionEvent, 1), k + com.tencent.mm.ui.base.f.k(motionEvent, 1));
                            } else if (((double) MMGestureGallery.this.xsS) <= ((double) originScale) + 0.05d) {
                                MMGestureGallery.this.lTJ.aw(j2 + com.tencent.mm.ui.base.f.j(motionEvent, 1), k + com.tencent.mm.ui.base.f.k(motionEvent, 1));
                            }
                        }
                        if (MMGestureGallery.this.xsS > MMGestureGallery.this.lTJ.getDoubleTabScale() * 2.0f) {
                            float j3 = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            float k2 = com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1);
                            MMGestureGallery.this.lTJ.setMaxZoomLimit(MMGestureGallery.this.lTJ.getDoubleTabScale() * 2.0f);
                            MMGestureGallery.this.lTJ.r(MMGestureGallery.this.lTJ.getDoubleTabScale() * 2.0f, j3 + com.tencent.mm.ui.base.f.j(motionEvent, 1), k2 + com.tencent.mm.ui.base.f.k(motionEvent, 1));
                            MMGestureGallery.this.lTJ.gKz();
                        }
                    }
                    if (motionEvent.getAction() == 1) {
                        gXH();
                        MMGestureGallery.this.OTX = false;
                        MMGestureGallery.this.OTY = false;
                        MMGestureGallery.this.EHs = false;
                        if ((MMGestureGallery.this.xsV || MMGestureGallery.this.xsW || MMGestureGallery.this.OTZ || MMGestureGallery.this.OUa) && (MMGestureGallery.this.xsT || MMGestureGallery.this.xsU)) {
                            MMGestureGallery.this.QuE = new h();
                            MMGestureGallery.H(MMGestureGallery.this);
                            MMGestureGallery.this.xsV = false;
                            MMGestureGallery.this.xsW = false;
                            MMGestureGallery.this.OTZ = false;
                            MMGestureGallery.this.OUa = false;
                            MMGestureGallery.this.xsT = false;
                            MMGestureGallery.this.xsU = false;
                        } else {
                            if (MMGestureGallery.this.OTZ || MMGestureGallery.this.xsV) {
                                MMGestureGallery.this.OTZ = false;
                                MMGestureGallery.this.xsV = false;
                                MMGestureGallery.this.QuE = new i();
                                MMGestureGallery.H(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.OUa || MMGestureGallery.this.xsW) {
                                MMGestureGallery.this.OUa = false;
                                MMGestureGallery.this.xsW = false;
                                MMGestureGallery.this.QuE = new j();
                                MMGestureGallery.H(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.xsT) {
                                MMGestureGallery.this.xsT = false;
                                MMGestureGallery.this.QuE = new k();
                                MMGestureGallery.H(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.xsU) {
                                MMGestureGallery.this.xsU = false;
                                MMGestureGallery.this.QuE = new g();
                                MMGestureGallery.H(MMGestureGallery.this);
                            }
                        }
                        MMGestureGallery.this.dhm = 0.0f;
                        MMGestureGallery.this.xsS = MMGestureGallery.this.lTJ.getScale();
                        if (MMGestureGallery.this.count == 1) {
                            MMGestureGallery.this.xsJ = System.currentTimeMillis();
                            if (MMGestureGallery.this.xsJ - MMGestureGallery.this.xsI >= 350) {
                                MMGestureGallery.this.count = 0;
                                Log.d("MicroMsg.MMGestureGallery", "single long click over!");
                            } else if (Math.abs(MMGestureGallery.this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) < 10.0f) {
                                CI(false);
                            }
                        }
                    }
                    if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
                        MMGestureGallery.this.dhm = 0.0f;
                        MMGestureGallery.this.xsS = MMGestureGallery.this.lTJ.getScale();
                        MMGestureGallery.this.xsN = true;
                    }
                    if (motionEvent.getAction() == 2) {
                        if (com.tencent.mm.ui.base.f.ai(motionEvent) == 2) {
                            gXH();
                            if (MMGestureGallery.this.OTY || MMGestureGallery.this.OTZ || MMGestureGallery.this.OUa) {
                                AppMethodBeat.o(143115);
                                return true;
                            }
                            MMGestureGallery.this.xsN = true;
                            MMGestureGallery.this.count = 0;
                            float j4 = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            float k3 = com.tencent.mm.ui.base.f.k(motionEvent, 0) - com.tencent.mm.ui.base.f.k(motionEvent, 1);
                            float sqrt = (float) Math.sqrt((double) ((j4 * j4) + (k3 * k3)));
                            if (MMGestureGallery.this.dhm == 0.0f) {
                                MMGestureGallery.this.dhm = sqrt;
                            } else {
                                float f2 = sqrt / MMGestureGallery.this.dhm;
                                if (MMGestureGallery.this.xsN) {
                                    MMGestureGallery.this.lTJ.r(f2 * MMGestureGallery.this.xsS, j4 + com.tencent.mm.ui.base.f.j(motionEvent, 1), com.tencent.mm.ui.base.f.k(motionEvent, 1) + k3);
                                    MMGestureGallery.this.lTJ.gKz();
                                }
                            }
                        } else if (Math.abs(MMGestureGallery.this.xsK - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 35.0f || Math.abs(MMGestureGallery.this.xsL - com.tencent.mm.ui.base.f.k(motionEvent, 0)) > 35.0f) {
                            gXH();
                            MMGestureGallery.this.count = 0;
                        }
                    }
                }
                AppMethodBeat.o(143115);
                return false;
            }

            private void CI(boolean z) {
                AppMethodBeat.i(143116);
                MMGestureGallery.this.QuC.S(350, z);
                AppMethodBeat.o(143116);
            }
        });
        AppMethodBeat.o(143139);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143140);
        super.onMeasure(i2, i3);
        this.mEX = View.MeasureSpec.getSize(i2);
        this.mEY = View.MeasureSpec.getSize(i3);
        this.xsQ.set(0.0f, 0.0f, (float) this.mEX, (float) this.mEY);
        Log.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.mEX + " height:" + this.mEY);
        AppMethodBeat.o(143140);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(143141);
        if (this.OTX) {
            AppMethodBeat.o(143141);
            return true;
        }
        this.OTY = true;
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f2, f3);
        AppMethodBeat.o(143141);
        return onScroll;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x02d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScroll(android.view.MotionEvent r10, android.view.MotionEvent r11, float r12, float r13) {
        /*
        // Method dump skipped, instructions count: 1016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.MMGestureGallery.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(143144);
        if (this.xsO != null) {
            this.xsO.forceFinished(true);
        }
        boolean onDown = super.onDown(motionEvent);
        AppMethodBeat.o(143144);
        return onDown;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float f4;
        AppMethodBeat.i(143145);
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(R.id.dvp);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f2);
                AppMethodBeat.o(143145);
                return false;
            }
            selectedView = findViewById.findViewById(R.id.dup);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f2);
                AppMethodBeat.o(143145);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageWidth());
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageHeight());
            Log.d("MicroMsg.MMGestureGallery", "width: %f, height: %f.", Float.valueOf(scale), Float.valueOf(scale2));
            if (multiTouchImageView.aXq || multiTouchImageView.aXp || ((int) scale) > this.mEX || ((int) scale2) > this.mEY) {
                float[] fArr = new float[9];
                multiTouchImageView.getImageMatrix().getValues(fArr);
                float f5 = fArr[2];
                float f6 = f5 + scale;
                float f7 = fArr[5];
                float f8 = f7 + scale2;
                Log.d("MicroMsg.MMGestureGallery", "left: %f, right: %f, top: %f, bottom: %f, velocityX: %f, velocityY: %f.", Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f2), Float.valueOf(f3));
                if (((float) Math.round(f5)) >= this.xsQ.left || ((float) Math.round(f6)) <= this.xsQ.right) {
                    f4 = 0.0f;
                } else {
                    f4 = f2;
                }
                if (((float) Math.round(f7)) >= this.xsQ.top || ((float) Math.round(f8)) <= this.xsQ.bottom) {
                    f3 = 0.0f;
                }
                if (((float) Math.round(f7)) < this.xsQ.top) {
                    this.OTW = true;
                } else {
                    this.OTW = false;
                }
                int i2 = (int) (this.xsQ.right - scale);
                int i3 = (int) (this.xsQ.right + scale);
                int i4 = (int) (this.xsQ.bottom - scale2);
                int i5 = (int) (this.xsQ.bottom + scale2);
                Log.d("MicroMsg.MMGestureGallery", "minX: %d, maxX: %d, minY: %d, maxY: %d.", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                Log.d("MicroMsg.MMGestureGallery", "vx: %f, vy: %f.", Float.valueOf(f4), Float.valueOf(f3));
                this.xsO.forceFinished(true);
                this.xsO.fling(this.xsO.getCurrX(), this.xsO.getCurrY(), (int) f4, (int) f3, i2, i3, i4, i5, 0, 0);
            }
        }
        if (this.xsN) {
            AppMethodBeat.o(143145);
            return true;
        }
        a(motionEvent, motionEvent2, f2);
        AppMethodBeat.o(143145);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(143146);
        this.EHs = true;
        super.onLongPress(motionEvent);
        AppMethodBeat.o(143146);
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(143147);
        if (motionEvent.getX() - motionEvent2.getX() < 0.0f) {
            AppMethodBeat.o(143147);
            return true;
        }
        AppMethodBeat.o(143147);
        return false;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2) {
        AppMethodBeat.i(143148);
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b2 = b(motionEvent, motionEvent2);
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        if (Math.abs(f2) <= 500.0f) {
            AppMethodBeat.o(143148);
        } else if (abs < 60.0f) {
            AppMethodBeat.o(143148);
        } else if (abs < abs2) {
            AppMethodBeat.o(143148);
        } else if (b2) {
            onKeyDown(21, null);
            AppMethodBeat.o(143148);
        } else {
            onKeyDown(22, null);
            AppMethodBeat.o(143148);
        }
    }

    public int getScreenWidth() {
        return this.mEX;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(143149);
        GestureDetector gestureDetector = this.xsP;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        Log.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.lTJ = (MultiTouchImageView) selectedView;
                    float scale = this.lTJ.getScale() * ((float) this.lTJ.getImageWidth());
                    float scale2 = this.lTJ.getScale() * ((float) this.lTJ.getImageHeight());
                    if (((int) scale) <= this.mEX && ((int) scale2) <= this.mEY) {
                        Log.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    } else {
                        float[] fArr = new float[9];
                        this.lTJ.getImageMatrix().getValues(fArr);
                        float f2 = fArr[5];
                        Log.d("dktest", "onTouchEvent top:" + f2 + " height:" + scale2 + " bottom:" + (f2 + scale2));
                        break;
                    }
                }
                break;
        }
        computeScroll();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(143149);
        return onTouchEvent;
    }

    class d extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(205373);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205373);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(205372);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(205372);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205371);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205371);
            return onSingleTapUp;
        }

        private d() {
        }

        /* synthetic */ d(MMGestureGallery mMGestureGallery, byte b2) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(205370);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205370);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(143150);
        if (z) {
            super.onFocusChanged(z, i2, rect);
        }
        AppMethodBeat.o(143150);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(143151);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(143151);
    }

    public void computeScroll() {
        AppMethodBeat.i(143152);
        Log.d("MicroMsg.MMGestureGallery", "computeScrollOffset: %s.", Boolean.valueOf(this.xsO.computeScrollOffset()));
        if (this.lTJ == null) {
            AppMethodBeat.o(143152);
            return;
        }
        if (this.xsO.computeScrollOffset()) {
            Log.d("MicroMsg.MMGestureGallery", "mFlingScroller.getCurrX(): %s, mFlingScroller.getCurrY(): %s.", Integer.valueOf(this.xsO.getCurrX()), Integer.valueOf(this.xsO.getCurrY()));
            int currX = this.xsO.getCurrX() - this.auo;
            int currY = this.xsO.getCurrY() - this.aup;
            Log.d("MicroMsg.MMGestureGallery", " scrollX: %s, scrollY: %s, mLastFlingX: %s, mLastFlingY: %s.", Integer.valueOf(currX), Integer.valueOf(currY), Integer.valueOf(this.auo), Integer.valueOf(this.aup));
            this.auo = this.xsO.getCurrX();
            this.aup = this.xsO.getCurrY();
            float scale = this.lTJ.getScale() * ((float) this.lTJ.getImageWidth());
            float scale2 = this.lTJ.getScale() * ((float) this.lTJ.getImageHeight());
            float[] fArr = new float[9];
            this.lTJ.getImageMatrix().getValues(fArr);
            float f2 = fArr[2];
            float f3 = scale + f2;
            float f4 = fArr[5];
            float f5 = f4 + scale2;
            Log.d("MicroMsg.MMGestureGallery", "left: %s, right: %s, top: %s, bottom: %s.", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
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
            if (scale2 < ((float) this.mEY)) {
                currY = 0;
            }
            this.lTJ.au((float) currX, (float) currY);
            postInvalidate();
        }
        AppMethodBeat.o(143152);
    }

    public boolean isFocused() {
        return true;
    }

    public static class l extends MMHandler {
        private boolean edG;
        WeakReference<MMGestureGallery> xoV;
        private long xtj;

        public l(WeakReference<MMGestureGallery> weakReference) {
            this.xoV = weakReference;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
            r0 = r5.xoV.get();
         */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r6) {
            /*
            // Method dump skipped, instructions count: 149
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.MMGestureGallery.l.handleMessage(android.os.Message):void");
        }

        public final void m(int i2, long j2, long j3) {
            AppMethodBeat.i(143135);
            this.xtj = j3;
            sendEmptyMessageDelayed(i2, j2);
            AppMethodBeat.o(143135);
        }

        public final void S(long j2, boolean z) {
            AppMethodBeat.i(143136);
            this.edG = z;
            m(0, j2, 0);
            AppMethodBeat.o(143136);
        }
    }

    public int getXDown() {
        return (int) this.aZg;
    }

    public int getYDown() {
        return (int) this.aZh;
    }

    private boolean a(float f2, float f3, View view, float f4) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(143142);
        if (this.OTY || this.OTX) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.OUa) {
                    if (f4 > 0.0f) {
                        if (f3 >= ((float) this.mEX)) {
                            this.lTJ.au(-f4, 0.0f);
                        } else if (f3 > ((float) this.mEX) * 0.7f && f3 < ((float) this.mEY)) {
                            this.lTJ.au(-(f4 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f4 > 0.0f) {
                    if (f3 < ((float) this.mEX)) {
                        this.OUa = true;
                    }
                    if (f3 >= ((float) this.mEX)) {
                        this.lTJ.au(-f4, 0.0f);
                    } else if (f3 > ((float) this.mEX) * 0.7f && f3 < ((float) this.mEY)) {
                        this.lTJ.au(-(f4 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.OUa = false;
            z = false;
        }
        if (z) {
            AppMethodBeat.o(143142);
            return true;
        }
        if (this.OTY || this.OTX) {
            z2 = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.OTZ) {
                    if (f4 < 0.0f) {
                        if (f2 > 0.0f && f2 < ((float) this.mEX) * 0.3f) {
                            this.lTJ.au(-(f4 * 0.3f), 0.0f);
                        } else if (f2 <= 0.0f) {
                            this.lTJ.au(-f4, 0.0f);
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else if (f4 < 0.0f) {
                    if (f2 > 0.0f) {
                        this.OTZ = true;
                    }
                    if (f2 > 0.0f && f2 < ((float) this.mEX) * 0.3f) {
                        this.lTJ.au(-(f4 * 0.3f), 0.0f);
                    } else if (f2 <= 0.0f) {
                        this.lTJ.au(-f4, 0.0f);
                    }
                    z2 = true;
                }
            }
            this.OTZ = false;
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(143142);
            return true;
        }
        AppMethodBeat.o(143142);
        return false;
    }

    static /* synthetic */ void H(MMGestureGallery mMGestureGallery) {
        AppMethodBeat.i(143153);
        mMGestureGallery.dSC();
        mMGestureGallery.QuB.m(1, 15, 15);
        AppMethodBeat.o(143153);
    }
}
