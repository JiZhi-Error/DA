package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private float CBe;
    private float CBf;
    private VelocityTracker CBg = null;
    private boolean EHq = false;
    private boolean EHr = false;
    private boolean EHs = false;
    private View.OnTouchListener HeV;
    private g OTU;
    public l OTV;
    private boolean OTW = false;
    private boolean OTX = false;
    private boolean OTY = false;
    private boolean OTZ = false;
    private boolean OUa = false;
    private int OUb = 0;
    private b OUc;
    private f OUd;
    private d OUe;
    private a OUf;
    private boolean OUg = false;
    private ViewPager.OnPageChangeListener OUh = null;
    private float OUi = 0.0f;
    private boolean OUj = false;
    private MotionEvent OUk;
    private long OUl = 0;
    private boolean OUm = true;
    private c OUn;
    private GestureDetector.SimpleOnGestureListener OUo = new e(this, (byte) 0);
    private View.OnLongClickListener OUp = new View.OnLongClickListener() {
        /* class com.tencent.mm.ui.base.MMViewPager.AnonymousClass3 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(142262);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (MMViewPager.this.OUe != null) {
                MMViewPager.this.OUe.bmu();
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(142262);
            return true;
        }
    };
    private final int OUq = 60;
    private final int OUr = 500;
    private float aZg = 0.0f;
    private float aZh = 0.0f;
    private int afB = -1;
    private int apZ = -1;
    private int auo;
    private int aup;
    private float dhm;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private GestureDetector mDJ;
    private int mEX;
    private int mEY;
    private VelocityTracker mVelocityTracker;
    private WxImageView xpO;
    private boolean xsN = false;
    private OverScroller xsO;
    private RectF xsQ = new RectF();
    private float xsS;
    private boolean xsT = false;
    private boolean xsU = false;
    private boolean xsV = false;
    private boolean xsW = false;

    public interface a {
        boolean ab(MotionEvent motionEvent);
    }

    public interface c {
        void S(float f2, float f3);

        void ao(float f2, float f3);
    }

    public interface d {
        void bmu();
    }

    public interface f {
        void bmt();

        void dSr();
    }

    static /* synthetic */ boolean c(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(205255);
        boolean b2 = b(motionEvent, motionEvent2);
        AppMethodBeat.o(205255);
        return b2;
    }

    static /* synthetic */ boolean g(MMViewPager mMViewPager) {
        AppMethodBeat.i(142309);
        boolean gLl = mMViewPager.gLl();
        AppMethodBeat.o(142309);
        return gLl;
    }

    static /* synthetic */ void h(MMViewPager mMViewPager) {
        AppMethodBeat.i(142310);
        mMViewPager.gLk();
        AppMethodBeat.o(142310);
    }

    static /* synthetic */ void w(MMViewPager mMViewPager) {
        AppMethodBeat.i(205257);
        mMViewPager.dSC();
        AppMethodBeat.o(205257);
    }

    /* access modifiers changed from: package-private */
    public abstract class b {
        protected boolean dgZ = false;

        public abstract void play();

        public b() {
        }

        public final boolean deQ() {
            return this.dgZ;
        }
    }

    /* access modifiers changed from: package-private */
    public class i extends b {
        float[] xtd = new float[9];

        public i() {
            super();
            AppMethodBeat.i(142275);
            AppMethodBeat.o(142275);
        }

        @Override // com.tencent.mm.ui.base.MMViewPager.b
        public final void play() {
            AppMethodBeat.i(142276);
            MMViewPager.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMViewPager.i.AnonymousClass1 */

                public final void run() {
                    float f2;
                    float f3;
                    AppMethodBeat.i(142274);
                    MMViewPager.this.OTU.getImageMatrix().getValues(i.this.xtd);
                    float f4 = i.this.xtd[2];
                    float scale = MMViewPager.this.OTU.getScale() * ((float) MMViewPager.this.OTU.getImageWidth());
                    if (scale < ((float) MMViewPager.this.mEX)) {
                        f2 = (((float) MMViewPager.this.mEX) / 2.0f) - (scale / 2.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    float f5 = f2 - f4;
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        f5 = -((WxImageView) MMViewPager.this.OTU).getTranslationX();
                    }
                    if (f5 >= 0.0f) {
                        i.this.dgZ = true;
                        f3 = f5;
                    } else if (Math.abs(f5) <= 5.0f) {
                        i.this.dgZ = true;
                        f3 = f5;
                    } else {
                        f3 = (-((float) (((double) Math.abs(f5)) - Math.pow(Math.sqrt((double) Math.abs(f5)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMViewPager.this.OTU.au(f3, 0.0f);
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.OTU).translate(f3, 0.0f);
                    }
                    AppMethodBeat.o(142274);
                }
            });
            AppMethodBeat.o(142276);
        }
    }

    /* access modifiers changed from: package-private */
    public class j extends b {
        float[] xtd = new float[9];

        public j() {
            super();
            AppMethodBeat.i(142278);
            AppMethodBeat.o(142278);
        }

        @Override // com.tencent.mm.ui.base.MMViewPager.b
        public final void play() {
            AppMethodBeat.i(142279);
            MMViewPager.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMViewPager.j.AnonymousClass1 */

                public final void run() {
                    float abs;
                    AppMethodBeat.i(142277);
                    MMViewPager.this.OTU.getImageMatrix().getValues(j.this.xtd);
                    float imageWidth = ((float) MMViewPager.this.OTU.getImageWidth()) * MMViewPager.this.OTU.getScale();
                    float f2 = j.this.xtd[2] + imageWidth;
                    float f3 = (float) MMViewPager.this.mEX;
                    if (imageWidth < ((float) MMViewPager.this.mEX)) {
                        f3 = (((float) MMViewPager.this.mEX) / 2.0f) + (imageWidth / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        f4 = -((WxImageView) MMViewPager.this.OTU).getTranslationX();
                    }
                    if (f4 <= 0.0f) {
                        j.this.dgZ = true;
                        abs = f4;
                    } else if (Math.abs(f4) <= 5.0f) {
                        j.this.dgZ = true;
                        abs = f4;
                    } else {
                        abs = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMViewPager.this.OTU.au(abs, 0.0f);
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.OTU).translate(abs, 0.0f);
                    }
                    AppMethodBeat.o(142277);
                }
            });
            AppMethodBeat.o(142279);
        }
    }

    /* access modifiers changed from: package-private */
    public class k extends b {
        float[] xtd = new float[9];

        public k() {
            super();
            AppMethodBeat.i(142281);
            AppMethodBeat.o(142281);
        }

        @Override // com.tencent.mm.ui.base.MMViewPager.b
        public final void play() {
            AppMethodBeat.i(142282);
            MMViewPager.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMViewPager.k.AnonymousClass1 */

                public final void run() {
                    float f2;
                    float f3;
                    AppMethodBeat.i(142280);
                    MMViewPager.this.OTU.getImageMatrix().getValues(k.this.xtd);
                    float f4 = k.this.xtd[5];
                    float scale = MMViewPager.this.OTU.getScale() * ((float) MMViewPager.this.OTU.getImageHeight());
                    if (scale < ((float) MMViewPager.this.mEY)) {
                        f2 = (((float) MMViewPager.this.mEY) / 2.0f) - (scale / 2.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    float f5 = f2 - f4;
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        f5 = -((WxImageView) MMViewPager.this.OTU).getTranslationY();
                    }
                    if (f5 >= 0.0f) {
                        k.this.dgZ = true;
                        f3 = f5;
                    } else if (Math.abs(f5) <= 5.0f) {
                        k.this.dgZ = true;
                        f3 = f5;
                    } else {
                        f3 = (-((float) (((double) Math.abs(f5)) - Math.pow(Math.sqrt((double) Math.abs(f5)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMViewPager.this.OTU.au(0.0f, f3);
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.OTU).translate(0.0f, f3);
                    }
                    AppMethodBeat.o(142280);
                }
            });
            AppMethodBeat.o(142282);
        }
    }

    /* access modifiers changed from: package-private */
    public class g extends b {
        float[] xtd = new float[9];

        public g() {
            super();
            AppMethodBeat.i(142269);
            AppMethodBeat.o(142269);
        }

        @Override // com.tencent.mm.ui.base.MMViewPager.b
        public final void play() {
            AppMethodBeat.i(142270);
            MMViewPager.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMViewPager.g.AnonymousClass1 */

                public final void run() {
                    float abs;
                    AppMethodBeat.i(142268);
                    MMViewPager.this.OTU.getImageMatrix().getValues(g.this.xtd);
                    float imageHeight = ((float) MMViewPager.this.OTU.getImageHeight()) * MMViewPager.this.OTU.getScale();
                    float f2 = g.this.xtd[5] + imageHeight;
                    float f3 = (float) MMViewPager.this.mEY;
                    if (imageHeight < ((float) MMViewPager.this.mEY)) {
                        f3 = (((float) MMViewPager.this.mEY) / 2.0f) + (imageHeight / 2.0f);
                    }
                    float f4 = f3 - f2;
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        f4 = -((WxImageView) MMViewPager.this.OTU).getTranslationY();
                    }
                    if (f4 <= 0.0f) {
                        g.this.dgZ = true;
                        abs = f4;
                    } else if (Math.abs(f4) <= 5.0f) {
                        g.this.dgZ = true;
                        abs = f4;
                    } else {
                        abs = ((float) (((double) Math.abs(f4)) - Math.pow(Math.sqrt((double) Math.abs(f4)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMViewPager.this.OTU.au(0.0f, abs);
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.OTU).translate(0.0f, abs);
                    }
                    AppMethodBeat.o(142268);
                }
            });
            AppMethodBeat.o(142270);
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends b {
        float[] xtd = new float[9];

        public h() {
            super();
            AppMethodBeat.i(142272);
            AppMethodBeat.o(142272);
        }

        @Override // com.tencent.mm.ui.base.MMViewPager.b
        public final void play() {
            AppMethodBeat.i(142273);
            MMViewPager.this.handler.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMViewPager.h.AnonymousClass1 */

                public final void run() {
                    float f2;
                    float f3;
                    float f4;
                    AppMethodBeat.i(142271);
                    MMViewPager.this.OTU.getImageMatrix().getValues(h.this.xtd);
                    float scale = MMViewPager.this.OTU.getScale() * ((float) MMViewPager.this.OTU.getImageWidth());
                    float imageHeight = ((float) MMViewPager.this.OTU.getImageHeight()) * MMViewPager.this.OTU.getScale();
                    float f5 = h.this.xtd[2];
                    float f6 = h.this.xtd[5];
                    float f7 = h.this.xtd[2] + scale;
                    float f8 = h.this.xtd[5] + imageHeight;
                    float f9 = 0.0f;
                    float f10 = (float) MMViewPager.this.mEY;
                    float f11 = 0.0f;
                    float f12 = (float) MMViewPager.this.mEX;
                    if (imageHeight < ((float) MMViewPager.this.mEY)) {
                        f9 = (((float) MMViewPager.this.mEY) / 2.0f) - (imageHeight / 2.0f);
                        f2 = (((float) MMViewPager.this.mEY) / 2.0f) + (imageHeight / 2.0f);
                    } else {
                        f2 = f10;
                    }
                    float f13 = f9 - f6;
                    float f14 = f2 - f8;
                    if (f13 >= 0.0f) {
                        if (f14 > 0.0f) {
                            f13 = f14;
                        } else {
                            f13 = 0.0f;
                        }
                    }
                    if (scale < ((float) MMViewPager.this.mEX)) {
                        float f15 = (((float) MMViewPager.this.mEX) / 2.0f) - (scale / 2.0f);
                        f3 = (((float) MMViewPager.this.mEX) / 2.0f) + (scale / 2.0f);
                        f11 = f15;
                    } else {
                        f3 = f12;
                    }
                    float f16 = f11 - f5;
                    float f17 = f3 - f7;
                    if (f16 >= 0.0f) {
                        if (f17 > 0.0f) {
                            f16 = f17;
                        } else {
                            f16 = 0.0f;
                        }
                    }
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        f16 = ((WxImageView) MMViewPager.this.OTU).getTranslationX();
                        f13 = ((WxImageView) MMViewPager.this.OTU).getTranslationY();
                    }
                    if (Math.abs(f16) > 5.0f || Math.abs(f13) > 5.0f) {
                        if (f16 >= 0.0f) {
                            f16 = ((float) (((double) Math.abs(f16)) - Math.pow(Math.sqrt((double) Math.abs(f16)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            f16 = (-((float) (((double) Math.abs(f16)) - Math.pow(Math.sqrt((double) Math.abs(f16)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (f13 >= 0.0f) {
                            f4 = ((float) (((double) Math.abs(f13)) - Math.pow(Math.sqrt((double) Math.abs(f13)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            f4 = (-((float) (((double) Math.abs(f13)) - Math.pow(Math.sqrt((double) Math.abs(f13)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        h.this.dgZ = true;
                        f4 = f13;
                    }
                    MMViewPager.this.OTU.au(f16, f4);
                    if (MMViewPager.this.OTU instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.OTU).translate(-f16, -f4);
                    }
                    AppMethodBeat.o(142271);
                }
            });
            AppMethodBeat.o(142273);
        }
    }

    public void setSingleClickOverListener(f fVar) {
        this.OUd = fVar;
    }

    public void setLongClickOverListener(d dVar) {
        this.OUe = dVar;
    }

    public void setDoubleClickListener(a aVar) {
        this.OUf = aVar;
    }

    public void setSingleMode(boolean z) {
        this.OUg = z;
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(142284);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(142284);
    }

    private void dSC() {
        AppMethodBeat.i(142285);
        this.OTV.removeMessages(1);
        AppMethodBeat.o(142285);
    }

    private void dSD() {
        AppMethodBeat.i(142286);
        dSC();
        l lVar = this.OTV;
        lVar.xtj = 15;
        lVar.sendEmptyMessageDelayed(1, 15);
        AppMethodBeat.o(142286);
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.OUh = onPageChangeListener;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142287);
        setStaticTransformationsEnabled(true);
        this.OTV = new l(new WeakReference(this));
        this.mDJ = new GestureDetector(context, new e(this, (byte) 0));
        this.xsO = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.OUb = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.ui.base.MMViewPager.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(142258);
                MMViewPager.this.afB = MMViewPager.this.apZ;
                MMViewPager.this.apZ = i2;
                if (MMViewPager.this.OUh != null) {
                    MMViewPager.this.OUh.onPageSelected(i2);
                }
                if (MMViewPager.g(MMViewPager.this)) {
                    MMViewPager.h(MMViewPager.this);
                    AppMethodBeat.o(142258);
                    return;
                }
                MMViewPager.this.xpO = null;
                AppMethodBeat.o(142258);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                AppMethodBeat.i(142259);
                if (MMViewPager.this.OUh != null) {
                    MMViewPager.this.OUh.onPageScrolled(i2, f2, i3);
                }
                MMViewPager.this.OUi = f2;
                if (i3 == 0 && MMViewPager.this.afB != -1) {
                    MMViewPager.c(MMViewPager.this, MMViewPager.this.afB);
                }
                AppMethodBeat.o(142259);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
                AppMethodBeat.i(142260);
                if (MMViewPager.this.OUh != null) {
                    MMViewPager.this.OUh.onPageScrollStateChanged(i2);
                }
                if (i2 == 0) {
                    MMViewPager.this.OUi = 0.0f;
                }
                AppMethodBeat.o(142260);
            }
        });
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.MMViewPager.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.i(142261);
                Log.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", Integer.valueOf(MMViewPager.this.getCurrentItem()));
                if (MMViewPager.this.HeV != null) {
                    z = MMViewPager.this.HeV.onTouch(view, motionEvent);
                } else {
                    z = false;
                }
                g selectedImageView = MMViewPager.this.getSelectedImageView();
                if (selectedImageView == null) {
                    MMViewPager.a(MMViewPager.this, motionEvent);
                    MMViewPager.this.OUk = null;
                    GestureDetector gestureDetector = MMViewPager.this.mDJ;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    if (MMViewPager.this.xsN || MMViewPager.this.EHq) {
                        AppMethodBeat.o(142261);
                        return true;
                    }
                    AppMethodBeat.o(142261);
                    return z;
                }
                MMViewPager.this.OTU = selectedImageView;
                boolean c2 = MMViewPager.c(MMViewPager.this, motionEvent);
                if (MMViewPager.this.OUk != null) {
                    MMViewPager.this.OUk.recycle();
                }
                MMViewPager.this.OUk = MotionEvent.obtainNoHistory(motionEvent);
                GestureDetector gestureDetector2 = MMViewPager.this.mDJ;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, bl2.axQ(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, gestureDetector2.onTouchEvent((MotionEvent) bl2.pG(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                MMViewPager.this.computeScroll();
                if (c2 || z) {
                    AppMethodBeat.o(142261);
                    return true;
                }
                AppMethodBeat.o(142261);
                return false;
            }
        });
        AppMethodBeat.o(142287);
    }

    private void gLk() {
        AppMethodBeat.i(142288);
        this.xpO = getSelectedWxImageView();
        if (this.xpO != null) {
            Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
            this.xpO.setGestureDetectorListener(this.OUo);
            this.xpO.setOnLongClickListener(this.OUp);
        }
        AppMethodBeat.o(142288);
    }

    private boolean gLl() {
        AppMethodBeat.i(142289);
        g selectedImageView = getSelectedImageView();
        if (selectedImageView == null || !(selectedImageView instanceof WxImageView)) {
            AppMethodBeat.o(142289);
            return false;
        }
        AppMethodBeat.o(142289);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(142290);
        try {
            Log.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", Integer.valueOf(motionEvent.getAction()));
            if (this.xpO == null) {
                gLk();
            }
            z = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(142290);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMViewPager", e2, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
            AppMethodBeat.o(142290);
        }
        return z;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142291);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        this.OUj = false;
        if (!gLl()) {
            AppMethodBeat.o(142291);
        } else if (onInterceptTouchEvent) {
            AppMethodBeat.o(142291);
        } else {
            if (this.CBg == null) {
                this.CBg = VelocityTracker.obtain();
            }
            this.CBg.addMovement(motionEvent);
            VelocityTracker velocityTracker = this.CBg;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            int yVelocity = (int) velocityTracker.getYVelocity();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.CBe = motionEvent.getRawX();
                    this.CBf = motionEvent.getRawY();
                    onInterceptTouchEvent = false;
                    break;
                case 1:
                    onInterceptTouchEvent = false;
                    break;
                case 2:
                    if (!this.OUg) {
                        float rawX = motionEvent.getRawX() - this.CBe;
                        Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", Float.valueOf(rawX), Float.valueOf(motionEvent.getRawY() - this.CBf), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                        if (Math.abs(rawX) <= 250.0f && Math.abs(yVelocity) > Math.abs(xVelocity) && Math.abs(yVelocity) > 0) {
                            Log.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", Integer.valueOf(motionEvent.getAction()));
                            onInterceptTouchEvent = true;
                            break;
                        } else {
                            onInterceptTouchEvent = false;
                            break;
                        }
                    } else {
                        onInterceptTouchEvent = true;
                        break;
                    }
                    break;
                default:
                    onInterceptTouchEvent = false;
                    break;
            }
            if (onInterceptTouchEvent) {
                this.aZg = motionEvent.getRawX();
                this.aZh = motionEvent.getRawY();
                this.xsS = this.xpO.getScale();
            }
            this.OUj = onInterceptTouchEvent;
            AppMethodBeat.o(142291);
        }
        return onInterceptTouchEvent;
    }

    public void setGalleryScaleListener(c cVar) {
        this.OUn = cVar;
    }

    public void setEnableGalleryScale(boolean z) {
        this.OUm = z;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.HeV = onTouchListener;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142292);
        super.onMeasure(i2, i3);
        this.mEX = View.MeasureSpec.getSize(i2);
        this.mEY = View.MeasureSpec.getSize(i3);
        this.xsQ.set(0.0f, 0.0f, (float) this.mEX, (float) this.mEY);
        AppMethodBeat.o(142292);
    }

    private boolean gLm() {
        AppMethodBeat.i(142293);
        Log.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
        if (this.OTX) {
            AppMethodBeat.o(142293);
            return true;
        }
        this.OTY = true;
        AppMethodBeat.o(142293);
        return false;
    }

    private boolean a(float f2, View view, float f3) {
        AppMethodBeat.i(142294);
        if (getAdapter().getItemPosition(view) == firstItemPosForDetermine() || this.OUg) {
            if (this.OTU instanceof WxImageView) {
                float translationX = ((WxImageView) this.OTU).getTranslationX();
                float f4 = f3 * 0.3f;
                Log.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", Float.valueOf(f4), Float.valueOf(translationX));
                if (f4 < 0.0f && translationX - f4 > 0.0f) {
                    this.OTZ = true;
                }
                if (this.OTZ) {
                    ((WxImageView) this.OTU).translate(-f4, 0.0f);
                    AppMethodBeat.o(142294);
                    return true;
                }
                AppMethodBeat.o(142294);
                return false;
            } else if (this.OTZ) {
                if (f3 < 0.0f) {
                    if (f2 <= this.xsQ.left) {
                        this.OTU.au(-f3, 0.0f);
                    } else if (f2 > this.xsQ.left && f2 < ((float) this.mEX) * 0.3f) {
                        this.OTU.au(-(f3 * 0.3f), 0.0f);
                        AppMethodBeat.o(142294);
                        return true;
                    } else if (this.OUg && f2 > this.xsQ.left) {
                        this.OTU.au(-(f3 * 0.3f), 0.0f);
                        AppMethodBeat.o(142294);
                        return true;
                    }
                }
                AppMethodBeat.o(142294);
                return false;
            } else if (f3 < 0.0f) {
                if (f2 > 0.0f) {
                    this.OTZ = true;
                }
                if (f2 <= this.xsQ.left) {
                    this.OTU.au(-f3, 0.0f);
                } else if (f2 > this.xsQ.left && f2 < ((float) this.mEX) * 0.3f) {
                    this.OTU.au(-(f3 * 0.3f), 0.0f);
                    AppMethodBeat.o(142294);
                    return true;
                } else if (this.OUg && f2 > this.xsQ.left) {
                    this.OTU.au(-(f3 * 0.3f), 0.0f);
                    AppMethodBeat.o(142294);
                    return true;
                }
            }
        }
        if (this.OTY || this.OTX) {
            AppMethodBeat.o(142294);
            return false;
        }
        this.OTZ = false;
        AppMethodBeat.o(142294);
        return false;
    }

    private boolean b(float f2, View view, float f3) {
        AppMethodBeat.i(142295);
        if (getAdapter().getItemPosition(view) == lastItemPosForDetermine() || this.OUg) {
            if (this.OTU instanceof WxImageView) {
                float translationX = ((WxImageView) this.OTU).getTranslationX();
                float f4 = f3 * 0.3f;
                if (f4 > 0.0f && translationX - f4 < 0.0f) {
                    this.OUa = true;
                }
                if (this.OUa) {
                    ((WxImageView) this.OTU).translate(-f4, 0.0f);
                    AppMethodBeat.o(142295);
                    return true;
                }
                AppMethodBeat.o(142295);
                return false;
            } else if (this.OUa) {
                if (f3 > 0.0f) {
                    if (f2 >= ((float) this.mEX)) {
                        this.OTU.au(-f3, 0.0f);
                    } else if (f2 > ((float) this.mEX) * 0.7f && f2 < ((float) this.mEX)) {
                        this.OTU.au(-(f3 * 0.3f), 0.0f);
                        AppMethodBeat.o(142295);
                        return true;
                    } else if (this.OUg && f2 < ((float) this.mEX)) {
                        this.OTU.au(-(f3 * 0.3f), 0.0f);
                    }
                }
                AppMethodBeat.o(142295);
                return false;
            } else if (f3 > 0.0f) {
                if (f2 < ((float) this.mEX)) {
                    this.OUa = true;
                }
                if (f2 >= ((float) this.mEX)) {
                    this.OTU.au(-f3, 0.0f);
                } else if (f2 > ((float) this.mEX) * 0.7f && f2 < ((float) this.mEX)) {
                    this.OTU.au(-(f3 * 0.3f), 0.0f);
                    AppMethodBeat.o(142295);
                    return true;
                } else if (this.OUg && f2 < ((float) this.mEX)) {
                    this.OTU.au(-(f3 * 0.3f), 0.0f);
                }
            }
        }
        if (this.OTY || this.OTX) {
            AppMethodBeat.o(142295);
            return false;
        }
        this.OUa = false;
        AppMethodBeat.o(142295);
        return false;
    }

    private boolean a(float f2, float f3, View view, float f4) {
        AppMethodBeat.i(142296);
        if (b(f3, view, f4)) {
            AppMethodBeat.o(142296);
            return true;
        } else if (a(f2, view, f4)) {
            AppMethodBeat.o(142296);
            return true;
        } else {
            AppMethodBeat.o(142296);
            return false;
        }
    }

    public View getSelectedView() {
        AppMethodBeat.i(142297);
        View abm = ((v) getAdapter()).abm(getCurrentItem());
        AppMethodBeat.o(142297);
        return abm;
    }

    public g getSelectedImageView() {
        AppMethodBeat.i(142298);
        MultiTouchImageView selectedMultiTouchImageView = getSelectedMultiTouchImageView();
        if (selectedMultiTouchImageView != null) {
            AppMethodBeat.o(142298);
            return selectedMultiTouchImageView;
        }
        WxImageView selectedWxImageView = getSelectedWxImageView();
        AppMethodBeat.o(142298);
        return selectedWxImageView;
    }

    private MultiTouchImageView getSelectedMultiTouchImageView() {
        AppMethodBeat.i(142299);
        MultiTouchImageView NQ = ((v) getAdapter()).NQ(getCurrentItem());
        AppMethodBeat.o(142299);
        return NQ;
    }

    private WxImageView getSelectedWxImageView() {
        AppMethodBeat.i(142300);
        WxImageView NR = ((v) getAdapter()).NR(getCurrentItem());
        if (NR != null) {
            WxImageView wxImageView = NR;
            AppMethodBeat.o(142300);
            return wxImageView;
        }
        AppMethodBeat.o(142300);
        return null;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void setAdapter(q qVar) {
        AppMethodBeat.i(142301);
        if (qVar instanceof v) {
            super.setAdapter(qVar);
            AppMethodBeat.o(142301);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("must be MMViewPagerAdapter");
        AppMethodBeat.o(142301);
        throw illegalArgumentException;
    }

    private int getCurrentX() {
        AppMethodBeat.i(142302);
        if (getAdapter() == null) {
            AppMethodBeat.o(142302);
            return -1;
        }
        int scrollX = getScrollX() - (this.mEX * ((getAdapter().getCount() - getCurrentItem()) - 1));
        AppMethodBeat.o(142302);
        return scrollX;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(142303);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.o(142303);
            return false;
        } else if (motionEvent.getX() - motionEvent2.getX() < 0.0f) {
            AppMethodBeat.o(142303);
            return true;
        } else {
            AppMethodBeat.o(142303);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void computeScroll() {
        int i2 = 0;
        AppMethodBeat.i(142304);
        super.computeScroll();
        if (this.OTU == null) {
            AppMethodBeat.o(142304);
            return;
        }
        float scale = this.OTU.getScale() * ((float) this.OTU.getImageWidth());
        float scale2 = this.OTU.getScale() * ((float) this.OTU.getImageHeight());
        if (this.xsO.computeScrollOffset()) {
            int currX = this.xsO.getCurrX() - this.auo;
            int currY = this.xsO.getCurrY() - this.aup;
            this.auo = this.xsO.getCurrX();
            this.aup = this.xsO.getCurrY();
            float[] fArr = new float[9];
            this.OTU.getImageMatrix().getValues(fArr);
            float f2 = fArr[2];
            float f3 = scale + f2;
            float f4 = fArr[5];
            float f5 = f4 + scale2;
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
            if (scale2 >= ((float) this.mEY)) {
                i2 = currY;
            }
            this.OTU.au((float) currX, (float) i2);
            postInvalidate();
        }
        AppMethodBeat.o(142304);
    }

    public int getScreenWidth() {
        return this.mEX;
    }

    class e extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(205254);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205254);
            return onContextClick;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205253);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205253);
            return onSingleTapUp;
        }

        private e() {
        }

        /* synthetic */ e(MMViewPager mMViewPager, byte b2) {
            this();
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(142263);
            if (MMViewPager.this.OUd != null) {
                MMViewPager.this.OUd.bmt();
            }
            AppMethodBeat.o(142263);
            return true;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(142264);
            if (MMViewPager.this.xsO != null) {
                MMViewPager.this.xsO.forceFinished(true);
            }
            boolean onDown = super.onDown(motionEvent);
            AppMethodBeat.o(142264);
            return onDown;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(142265);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            MMViewPager.this.EHs = true;
            if (MMViewPager.this.OUe != null) {
                MMViewPager.this.OUe.bmu();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(142265);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(142266);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            if (MMViewPager.this.OTU == null) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(142266);
                return false;
            } else if (MMViewPager.this.OUf == null || !MMViewPager.this.OUf.ab(motionEvent)) {
                if (MMViewPager.this.OTU.getScale() <= MMViewPager.this.OTU.getScaleRate()) {
                    MMViewPager.this.OTU.y(f.j(motionEvent, 0), f.k(motionEvent, 0));
                } else {
                    MMViewPager.this.OTU.at(f.j(motionEvent, 0), f.k(motionEvent, 0));
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(142266);
                return true;
            } else {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(142266);
                return true;
            }
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float f4;
            AppMethodBeat.i(142267);
            Log.d("MicroMsg.MMViewPager", "onFling");
            g selectedImageView = MMViewPager.this.getSelectedImageView();
            if (selectedImageView != null) {
                Log.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
                if (selectedImageView instanceof MultiTouchImageView) {
                    selectedImageView = (MultiTouchImageView) selectedImageView;
                } else if (selectedImageView instanceof WxImageView) {
                    selectedImageView = (WxImageView) selectedImageView;
                }
                float scale = selectedImageView.getScale() * ((float) selectedImageView.getImageWidth());
                float scale2 = selectedImageView.getScale() * ((float) selectedImageView.getImageHeight());
                if (selectedImageView.gKw() || selectedImageView.gKx() || ((int) scale) > MMViewPager.this.mEX || ((int) scale2) > MMViewPager.this.mEY) {
                    float[] fArr = new float[9];
                    selectedImageView.getImageMatrix().getValues(fArr);
                    float f5 = fArr[2];
                    float f6 = f5 + scale;
                    float f7 = fArr[5];
                    float f8 = f7 + scale2;
                    Log.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(MMViewPager.c(motionEvent, motionEvent2)), Float.valueOf(f2), Float.valueOf(f3));
                    if (((float) Math.round(f5)) >= MMViewPager.this.xsQ.left || ((float) Math.round(f6)) <= MMViewPager.this.xsQ.right) {
                        f4 = 0.0f;
                    } else {
                        f4 = f2;
                    }
                    if (((float) Math.round(f7)) >= MMViewPager.this.xsQ.top || ((float) Math.round(f8)) <= MMViewPager.this.xsQ.bottom) {
                        f3 = 0.0f;
                    }
                    MMViewPager.this.xsO.fling(MMViewPager.this.xsO.getCurrX(), MMViewPager.this.xsO.getCurrY(), (int) f4, (int) f3, (int) (MMViewPager.this.xsQ.right - scale), (int) (MMViewPager.this.xsQ.right + scale), (int) (MMViewPager.this.xsQ.bottom - scale2), (int) (MMViewPager.this.xsQ.bottom + scale2), 0, 0);
                    if ((!MMViewPager.c(motionEvent, motionEvent2) || f5 < 0.0f) && (MMViewPager.c(motionEvent, motionEvent2) || f6 > ((float) MMViewPager.this.mEX))) {
                        AppMethodBeat.o(142267);
                        return false;
                    }
                }
            }
            if (MMViewPager.this.xsN) {
                AppMethodBeat.o(142267);
                return false;
            }
            boolean a2 = MMViewPager.a(MMViewPager.this, motionEvent, motionEvent2, f2);
            AppMethodBeat.o(142267);
            return a2;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(142305);
        if (z) {
            super.onFocusChanged(z, i2, rect);
        }
        AppMethodBeat.o(142305);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(142306);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(142306);
    }

    public boolean isFocused() {
        return true;
    }

    public static class l extends MMHandler {
        WeakReference<MMViewPager> xoV;
        long xtj;

        public l(WeakReference<MMViewPager> weakReference) {
            this.xoV = weakReference;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            MMViewPager mMViewPager;
            AppMethodBeat.i(142283);
            super.handleMessage(message);
            removeMessages(message.what);
            if (!(this.xoV == null || (mMViewPager = this.xoV.get()) == null || message.what != 1)) {
                if (mMViewPager.OUc == null || mMViewPager.OUc.deQ()) {
                    MMViewPager.w(mMViewPager);
                } else {
                    mMViewPager.OUc.play();
                    sendEmptyMessageDelayed(message.what, this.xtj);
                    AppMethodBeat.o(142283);
                    return;
                }
            }
            AppMethodBeat.o(142283);
        }
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public int firstItemPosForDetermine() {
        AppMethodBeat.i(142307);
        int firstItemPosForDetermine = ((v) getAdapter()).firstItemPosForDetermine();
        if (firstItemPosForDetermine >= 0) {
            AppMethodBeat.o(142307);
            return firstItemPosForDetermine;
        }
        int firstItemPosForDetermine2 = super.firstItemPosForDetermine();
        AppMethodBeat.o(142307);
        return firstItemPosForDetermine2;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public int lastItemPosForDetermine() {
        AppMethodBeat.i(142308);
        int lastItemPosForDetermine = ((v) getAdapter()).lastItemPosForDetermine();
        if (lastItemPosForDetermine >= 0) {
            AppMethodBeat.o(142308);
            return lastItemPosForDetermine;
        }
        int lastItemPosForDetermine2 = super.lastItemPosForDetermine();
        AppMethodBeat.o(142308);
        return lastItemPosForDetermine2;
    }

    public int getXDown() {
        return (int) this.aZg;
    }

    public int getYDown() {
        return (int) this.aZh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r0 == null) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.tencent.mm.ui.base.MMViewPager r6, int r7) {
        /*
            r5 = 142311(0x22be7, float:1.9942E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.lang.String r0 = "MicroMsg.MMViewPager"
            java.lang.String r1 = "alvinluo resetImageViewSize position: %d"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r2[r3] = r4
            com.tencent.mm.sdk.platformtools.Log.d(r0, r1, r2)
            android.support.v4.view.q r0 = r6.getAdapter()
            com.tencent.mm.ui.base.v r0 = (com.tencent.mm.ui.base.v) r0
            if (r0 == 0) goto L_0x0037
            com.tencent.mm.ui.base.MultiTouchImageView r1 = r0.NQ(r7)
            if (r1 == 0) goto L_0x0031
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.gKy()
        L_0x002d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        L_0x0031:
            com.tencent.mm.ui.base.WxImageView r0 = r0.NR(r7)
            if (r0 != 0) goto L_0x0028
        L_0x0037:
            r0 = 0
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.MMViewPager.c(com.tencent.mm.ui.base.MMViewPager, int):void");
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent) {
        AppMethodBeat.i(142312);
        if (mMViewPager.mVelocityTracker == null) {
            mMViewPager.mVelocityTracker = VelocityTracker.obtain();
        }
        mMViewPager.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                mMViewPager.aZg = motionEvent.getX();
                mMViewPager.aZh = motionEvent.getY();
                break;
            case 1:
                mMViewPager.EHs = false;
                if (mMViewPager.EHr) {
                    if (mMViewPager.OUm && mMViewPager.OUn != null) {
                        mMViewPager.OUn.S(0.0f, 0.0f);
                    }
                    mMViewPager.EHq = false;
                    AppMethodBeat.o(142312);
                    return true;
                } else if (mMViewPager.EHq) {
                    if (mMViewPager.OUd != null) {
                        mMViewPager.OUd.dSr();
                    }
                    mMViewPager.EHq = false;
                    AppMethodBeat.o(142312);
                    return true;
                }
                break;
            case 2:
                float x = motionEvent.getX() - mMViewPager.aZg;
                float y = motionEvent.getY() - mMViewPager.aZh;
                VelocityTracker velocityTracker = mMViewPager.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (mMViewPager.OUm && mMViewPager.OUn != null) {
                    mMViewPager.OUn.ao(x, y);
                    if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.EHs || mMViewPager.OTY) && !mMViewPager.EHq) {
                        mMViewPager.EHq = false;
                    } else {
                        mMViewPager.OUn.S(x, y);
                        mMViewPager.EHq = true;
                    }
                    if (y > 200.0f) {
                        mMViewPager.EHr = false;
                    } else {
                        mMViewPager.EHr = true;
                    }
                }
                if (mMViewPager.mVelocityTracker != null) {
                    mMViewPager.mVelocityTracker.recycle();
                    mMViewPager.mVelocityTracker = null;
                    break;
                }
                break;
        }
        AppMethodBeat.o(142312);
        return false;
    }

    static /* synthetic */ boolean c(MMViewPager mMViewPager, MotionEvent motionEvent) {
        float x;
        float y;
        boolean z;
        float f2;
        float f3;
        int i2;
        boolean z2;
        AppMethodBeat.i(142313);
        boolean z3 = false;
        if (mMViewPager.mVelocityTracker == null) {
            mMViewPager.mVelocityTracker = VelocityTracker.obtain();
        }
        if (mMViewPager.OTU instanceof WxImageView) {
            ((WxImageView) mMViewPager.OTU).setGestureDetectorListener(mMViewPager.OUo);
            ((WxImageView) mMViewPager.OTU).setOnLongClickListener(mMViewPager.OUp);
            if (mMViewPager.OUg) {
                WxImageView wxImageView = (WxImageView) mMViewPager.OTU;
                if (wxImageView.hkD != null) {
                    z2 = wxImageView.hkD.onTouchEvent(motionEvent);
                } else {
                    z2 = false;
                }
                int action = motionEvent.getAction() & 255;
                if (!(!z2 || action == 1 || action == 6)) {
                    AppMethodBeat.o(142313);
                    return true;
                }
            }
        }
        mMViewPager.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMViewPager", "ACTION_DOWN");
                mMViewPager.OTU.gKA();
                float[] fArr = new float[9];
                mMViewPager.OTU.getImageMatrix().getValues(fArr);
                if (((float) Math.round(fArr[5])) < mMViewPager.xsQ.top) {
                    mMViewPager.OTW = true;
                } else {
                    mMViewPager.OTW = false;
                }
                mMViewPager.aZg = motionEvent.getX();
                mMViewPager.aZh = motionEvent.getY();
                mMViewPager.dhm = 0.0f;
                mMViewPager.xsS = mMViewPager.OTU.getScale();
                mMViewPager.xsN = false;
                mMViewPager.OUl = System.currentTimeMillis();
                break;
            case 1:
                Log.d("MicroMsg.MMViewPager", "ACTION_UP");
                mMViewPager.OTX = false;
                mMViewPager.OTY = false;
                mMViewPager.EHs = false;
                if ((mMViewPager.xsV || mMViewPager.xsW || mMViewPager.OTZ || mMViewPager.OUa) && (mMViewPager.xsT || mMViewPager.xsU)) {
                    mMViewPager.OUc = new h();
                    mMViewPager.dSD();
                    mMViewPager.xsV = false;
                    mMViewPager.xsW = false;
                    mMViewPager.OTZ = false;
                    mMViewPager.OUa = false;
                    mMViewPager.xsT = false;
                    mMViewPager.xsU = false;
                } else {
                    if (mMViewPager.OTZ || mMViewPager.xsV) {
                        mMViewPager.OTZ = false;
                        mMViewPager.xsV = false;
                        mMViewPager.OUc = new i();
                        mMViewPager.dSD();
                    }
                    if (mMViewPager.OUa || mMViewPager.xsW) {
                        mMViewPager.OUa = false;
                        mMViewPager.xsW = false;
                        mMViewPager.OUc = new j();
                        mMViewPager.dSD();
                    }
                    if (mMViewPager.xsT) {
                        mMViewPager.xsT = false;
                        mMViewPager.OUc = new k();
                        mMViewPager.dSD();
                    }
                    if (mMViewPager.xsU) {
                        mMViewPager.xsU = false;
                        mMViewPager.OUc = new g();
                        mMViewPager.dSD();
                    }
                }
                mMViewPager.dhm = 0.0f;
                mMViewPager.xsS = mMViewPager.OTU.getScale();
                if (!mMViewPager.EHr) {
                    if (!mMViewPager.EHq || mMViewPager.OTW) {
                        if (mMViewPager.OUg) {
                            z3 = true;
                            break;
                        }
                    } else {
                        if (mMViewPager.OUd != null) {
                            mMViewPager.OUd.dSr();
                        }
                        z3 = true;
                        mMViewPager.EHq = false;
                        break;
                    }
                } else {
                    if (mMViewPager.OUn != null && mMViewPager.OUm) {
                        mMViewPager.OUn.S(0.0f, 0.0f);
                    }
                    mMViewPager.EHq = false;
                    break;
                }
                break;
            case 2:
                Log.d("MicroMsg.MMViewPager", "ACTION_MOVE");
                if (f.ai(motionEvent) != 2) {
                    boolean z4 = false;
                    if (mMViewPager.OTU instanceof WxImageView) {
                        x = motionEvent.getRawX() - mMViewPager.aZg;
                        y = motionEvent.getRawY() - mMViewPager.aZh;
                        z4 = true;
                    } else {
                        x = motionEvent.getX() - mMViewPager.aZg;
                        y = motionEvent.getY() - mMViewPager.aZh;
                    }
                    VelocityTracker velocityTracker = mMViewPager.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    int yVelocity = (int) velocityTracker.getYVelocity();
                    if (mMViewPager.OUm && mMViewPager.OUn != null && !mMViewPager.OTW && !mMViewPager.xsN && mMViewPager.xsS <= mMViewPager.OTU.getScaleRate()) {
                        mMViewPager.OUn.ao(x, y);
                        if (xVelocity != 0 || yVelocity != 0 || !z4 || !mMViewPager.OUj) {
                            i2 = xVelocity;
                        } else {
                            Log.i("MicroMsg.MMViewPager", "ACTION_MOVE use interceptTracker velocityX: %d, velocityY: %d", Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                            VelocityTracker velocityTracker2 = mMViewPager.CBg;
                            velocityTracker2.addMovement(motionEvent);
                            velocityTracker2.computeCurrentVelocity(1000);
                            i2 = (int) velocityTracker2.getXVelocity();
                            yVelocity = (int) velocityTracker2.getYVelocity();
                        }
                        if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(i2) || yVelocity <= 0 || mMViewPager.EHs || mMViewPager.OTY) && !mMViewPager.EHq) {
                            mMViewPager.EHq = false;
                        } else {
                            mMViewPager.OUn.S(x, y);
                            mMViewPager.EHq = true;
                        }
                        if (y > 200.0f) {
                            mMViewPager.EHr = false;
                        } else {
                            mMViewPager.EHr = true;
                        }
                    }
                    if (mMViewPager.mVelocityTracker != null) {
                        mMViewPager.mVelocityTracker.recycle();
                        mMViewPager.mVelocityTracker = null;
                    }
                    if (mMViewPager.OUk == null || !(mMViewPager.OUk.getAction() == 0 || mMViewPager.OUk.getAction() == 2 || mMViewPager.OUk.getAction() == 5 || mMViewPager.OUk.getAction() == 261)) {
                        z = false;
                    } else {
                        float j2 = f.j(mMViewPager.OUk, 0) - f.j(motionEvent, 0);
                        float k2 = f.k(mMViewPager.OUk, 0) - f.k(motionEvent, 0);
                        if (mMViewPager.gLl()) {
                            if (!mMViewPager.EHq) {
                                View selectedView = mMViewPager.getSelectedView();
                                z = false;
                                if (Math.abs(j2) >= Math.abs(k2) || mMViewPager.OTZ || mMViewPager.OUa) {
                                    mMViewPager.OTY = true;
                                    if (mMViewPager.a(0.0f, selectedView, j2)) {
                                        z = true;
                                    }
                                    if (mMViewPager.b(0.0f, selectedView, j2)) {
                                        z = true;
                                    }
                                }
                                if (Math.abs(j2) < Math.abs(k2) && mMViewPager.OTU.getScale() * ((float) mMViewPager.OTU.getImageHeight()) >= ((float) mMViewPager.mEY)) {
                                    float translationY = ((WxImageView) mMViewPager.OTU).getTranslationY();
                                    float translationY2 = ((WxImageView) mMViewPager.OTU).getTranslationY();
                                    Log.i("MicroMsg.MMViewPager", "alvinluo onScrollUpDown translateTop: %f, translateBottom: %f", Float.valueOf(translationY), Float.valueOf(translationY2));
                                    if (k2 != 0.0f) {
                                        mMViewPager.OTX = true;
                                        if (k2 < 0.0f) {
                                            if (translationY - k2 > 0.0f) {
                                                mMViewPager.xsT = true;
                                            }
                                        } else if (k2 > 0.0f && translationY2 + k2 < 0.0f) {
                                            mMViewPager.xsU = true;
                                        }
                                        ((WxImageView) mMViewPager.OTU).translate(0.0f, -(k2 * 0.3f));
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                            z = false;
                        } else if (mMViewPager.xsN || mMViewPager.EHq) {
                            z = true;
                        } else if (j2 == 0.0f && k2 == 0.0f) {
                            z = true;
                        } else {
                            View selectedView2 = mMViewPager.getSelectedView();
                            float[] fArr2 = new float[9];
                            mMViewPager.OTU.getImageMatrix().getValues(fArr2);
                            float scale = mMViewPager.OTU.getScale() * ((float) mMViewPager.OTU.getImageWidth());
                            float scale2 = mMViewPager.OTU.getScale() * ((float) mMViewPager.OTU.getImageHeight());
                            float f4 = fArr2[2];
                            float f5 = f4 + scale;
                            float f6 = fArr2[5];
                            float f7 = f6 + scale2;
                            if (((int) scale) > mMViewPager.mEX || ((int) scale2) > mMViewPager.mEY) {
                                if (((int) scale) > mMViewPager.mEX || ((int) scale2) <= mMViewPager.mEY) {
                                    if (((int) scale) <= mMViewPager.mEX || ((int) scale2) > mMViewPager.mEY) {
                                        if (Math.abs(k2) > Math.abs(j2)) {
                                            float f8 = 0.0f;
                                            float f9 = 0.0f;
                                            if (j2 != 0.0f) {
                                                mMViewPager.OTY = true;
                                                if (j2 < 0.0f) {
                                                    if (f4 > mMViewPager.xsQ.left) {
                                                        mMViewPager.xsV = true;
                                                    }
                                                    if (f4 <= mMViewPager.xsQ.left || f5 < ((float) mMViewPager.mEX)) {
                                                        f8 = j2;
                                                    } else if (f4 > mMViewPager.xsQ.left && f4 < ((float) mMViewPager.mEX) * 0.3f) {
                                                        f8 = 0.3f * j2;
                                                    }
                                                } else {
                                                    if (f5 < mMViewPager.xsQ.right) {
                                                        mMViewPager.xsW = true;
                                                    }
                                                    if (f4 > 0.0f || f5 >= ((float) mMViewPager.mEX)) {
                                                        f8 = j2;
                                                    } else if (f5 > ((float) mMViewPager.mEX) * 0.7f && f5 < ((float) mMViewPager.mEX)) {
                                                        f8 = 0.3f * j2;
                                                    }
                                                }
                                            }
                                            if (k2 != 0.0f) {
                                                mMViewPager.OTX = true;
                                                if (k2 < 0.0f) {
                                                    if (f6 > mMViewPager.xsQ.top) {
                                                        mMViewPager.xsT = true;
                                                    }
                                                    if (f6 <= mMViewPager.xsQ.top || f7 < ((float) mMViewPager.mEY)) {
                                                        f9 = k2;
                                                    } else if (f6 > mMViewPager.xsQ.top && f6 < ((float) mMViewPager.mEY) * 0.3f) {
                                                        f9 = 0.3f * k2;
                                                    }
                                                } else {
                                                    if (f7 < mMViewPager.xsQ.bottom) {
                                                        mMViewPager.xsU = true;
                                                    }
                                                    if (f6 > 0.0f || f7 >= ((float) mMViewPager.mEY)) {
                                                        f9 = k2;
                                                    } else if (f7 > ((float) mMViewPager.mEY) * 0.7f && f7 < ((float) mMViewPager.mEY)) {
                                                        f9 = 0.3f * k2;
                                                    }
                                                }
                                            }
                                            mMViewPager.OTU.au(-f8, -f9);
                                            z = true;
                                        } else if (mMViewPager.a(f4, f5, selectedView2, j2)) {
                                            z = true;
                                        } else {
                                            if (j2 > 0.0f) {
                                                if (f5 <= ((float) mMViewPager.mEX)) {
                                                    z = mMViewPager.gLm();
                                                }
                                            } else if (f4 >= 0.0f) {
                                                z = mMViewPager.gLm();
                                            }
                                            if (!mMViewPager.OTY || ((((double) mMViewPager.OUi) < 0.06d && j2 > 0.0f && f5 > ((float) mMViewPager.mEX)) || ((((double) mMViewPager.OUi) > 0.94d || mMViewPager.OUi == 0.0f) && j2 < 0.0f && f4 < 0.0f))) {
                                                float f10 = -j2;
                                                if (j2 < 0.0f) {
                                                    if (f4 < 0.0f && f4 - j2 > 0.0f) {
                                                        f2 = -f4;
                                                    }
                                                    f2 = f10;
                                                } else {
                                                    if (f5 > ((float) mMViewPager.mEX) && f5 - j2 < ((float) mMViewPager.mEX)) {
                                                        f2 = ((float) mMViewPager.mEX) - f5;
                                                    }
                                                    f2 = f10;
                                                }
                                                float f11 = -k2;
                                                if (k2 < 0.0f) {
                                                    if (f6 < 0.0f && f6 + f11 > 0.0f) {
                                                        f11 = -f6;
                                                    }
                                                } else if (f7 > ((float) mMViewPager.mEY) && f7 + f11 < ((float) mMViewPager.mEY)) {
                                                    f11 = ((float) mMViewPager.mEY) - f7;
                                                }
                                                mMViewPager.OTU.au(f2, f11);
                                                z = true;
                                            }
                                            z = false;
                                        }
                                    } else if (mMViewPager.a(f4, f5, selectedView2, j2)) {
                                        z = true;
                                    } else {
                                        if (j2 > 0.0f) {
                                            if (f5 <= ((float) mMViewPager.mEX)) {
                                                z = mMViewPager.gLm();
                                            }
                                        } else if (f4 >= 0.0f) {
                                            z = mMViewPager.gLm();
                                        }
                                        if (!mMViewPager.OTY || ((((double) mMViewPager.OUi) < 0.06d && j2 > 0.0f && f5 > ((float) mMViewPager.mEX)) || ((((double) mMViewPager.OUi) > 0.94d || mMViewPager.OUi == 0.0f) && j2 < 0.0f && f4 < 0.0f))) {
                                            float f12 = -j2;
                                            if (j2 < 0.0f) {
                                                if (f4 < 0.0f && f4 - j2 > 0.0f) {
                                                    f12 = -f4;
                                                }
                                            } else if (f5 > ((float) mMViewPager.mEX) && f5 - j2 < ((float) mMViewPager.mEX)) {
                                                f12 = ((float) mMViewPager.mEX) - f5;
                                            }
                                            mMViewPager.OTU.au(f12, 0.0f);
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    }
                                } else if (Math.abs(k2) > Math.abs(j2)) {
                                    if (mMViewPager.OTY || mMViewPager.OTZ || mMViewPager.OUa) {
                                        z = true;
                                    } else {
                                        mMViewPager.OTX = true;
                                        float f13 = 0.0f;
                                        if (k2 < 0.0f) {
                                            if (f6 > mMViewPager.xsQ.top) {
                                                mMViewPager.xsT = true;
                                            }
                                            if (f6 <= mMViewPager.xsQ.top || f7 < ((float) mMViewPager.mEY)) {
                                                f3 = -k2;
                                            } else {
                                                if (f6 > mMViewPager.xsQ.top && f6 < ((float) mMViewPager.mEY) * 0.3f) {
                                                    f3 = -(k2 * 0.3f);
                                                }
                                                f3 = 0.0f;
                                            }
                                        } else {
                                            if (f7 < mMViewPager.xsQ.bottom) {
                                                mMViewPager.xsU = true;
                                            }
                                            if (f6 > 0.0f || f7 >= ((float) mMViewPager.mEY)) {
                                                f3 = -k2;
                                            } else {
                                                if (f7 > ((float) mMViewPager.mEY) * 0.7f && f7 < ((float) mMViewPager.mEY)) {
                                                    f3 = -(k2 * 0.3f);
                                                }
                                                f3 = 0.0f;
                                            }
                                        }
                                        if (j2 < 0.0f && f4 > mMViewPager.xsQ.left) {
                                            mMViewPager.xsV = true;
                                            f13 = -(0.3f * j2);
                                        } else if (j2 > 0.0f && f5 < mMViewPager.xsQ.right) {
                                            mMViewPager.xsW = true;
                                            f13 = -(0.3f * j2);
                                        }
                                        mMViewPager.OTU.au(f13, f3);
                                        z = true;
                                    }
                                } else if (mMViewPager.a(f4, f5, selectedView2, j2)) {
                                    z = true;
                                } else {
                                    if (j2 > 0.0f) {
                                        if (f5 <= ((float) mMViewPager.mEX)) {
                                            z = mMViewPager.gLm();
                                        }
                                    } else if (f4 >= 0.0f) {
                                        z = mMViewPager.gLm();
                                    }
                                    if (!mMViewPager.OTY) {
                                        float f14 = -j2;
                                        if (j2 < 0.0f) {
                                            if (f4 < 0.0f && f4 - j2 > 0.0f) {
                                                f14 = -f4;
                                            }
                                        } else if (f5 > ((float) mMViewPager.mEX) && f5 - j2 < ((float) mMViewPager.mEX)) {
                                            f14 = ((float) mMViewPager.mEX) - f5;
                                        }
                                        mMViewPager.OTU.au(f14, 0.0f);
                                    }
                                    z = true;
                                }
                            } else if (mMViewPager.a(f4, f5, selectedView2, j2)) {
                                z = true;
                            } else {
                                if (j2 > 0.0f) {
                                    if (f5 <= ((float) mMViewPager.mEX)) {
                                        z = mMViewPager.gLm();
                                    }
                                } else if (f4 >= 0.0f) {
                                    z = mMViewPager.gLm();
                                }
                                if (!mMViewPager.OTY) {
                                    float f15 = -j2;
                                    if (j2 < 0.0f) {
                                        if (f4 < 0.0f && f4 - j2 > 0.0f) {
                                            f15 = -f4;
                                        }
                                    } else if (f5 > ((float) mMViewPager.mEX) && f5 - j2 < ((float) mMViewPager.mEX)) {
                                        f15 = ((float) mMViewPager.mEX) - f5;
                                    }
                                    mMViewPager.OTU.au(f15, 0.0f);
                                }
                                z = true;
                            }
                        }
                        if (!z && mMViewPager.OTU != null && !(mMViewPager.OTU instanceof WxImageView)) {
                            mMViewPager.setLastMotion(f.j(mMViewPager.OUk, 0), f.k(mMViewPager.OUk, 0));
                        }
                    }
                    if (mMViewPager.OUg && !z) {
                        z3 = true;
                        break;
                    } else {
                        z3 = z;
                        break;
                    }
                } else {
                    mMViewPager.xsN = true;
                    float j3 = f.j(motionEvent, 0) - f.j(motionEvent, 1);
                    float k3 = f.k(motionEvent, 0) - f.k(motionEvent, 1);
                    float sqrt = (float) Math.sqrt((double) ((j3 * j3) + (k3 * k3)));
                    if (mMViewPager.dhm == 0.0f) {
                        mMViewPager.dhm = sqrt;
                    } else {
                        float f16 = sqrt / mMViewPager.dhm;
                        if (mMViewPager.xsN) {
                            mMViewPager.OTU.r(f16 * mMViewPager.xsS, j3 + f.j(motionEvent, 1), k3 + f.k(motionEvent, 1));
                            mMViewPager.OTU.gKz();
                        }
                    }
                    z3 = true;
                    break;
                }
                break;
            case 5:
                Log.d("MicroMsg.MMViewPager", "ACTION_POINTER_DOWN");
                mMViewPager.dhm = 0.0f;
                mMViewPager.xsS = mMViewPager.OTU.getScale();
                mMViewPager.xsN = true;
                z3 = true;
                if (!mMViewPager.isFakeDragging()) {
                    mMViewPager.beginFakeDrag();
                    break;
                }
                break;
            case 6:
                Log.d("MicroMsg.MMViewPager", "ACTION_POINTER_UP");
                mMViewPager.dhm = 0.0f;
                mMViewPager.xsS = mMViewPager.OTU.getScale();
                mMViewPager.xsN = true;
                if (mMViewPager.isFakeDragging()) {
                    mMViewPager.endFakeDrag();
                }
                if (mMViewPager.xsS < mMViewPager.OTU.getScaleRate()) {
                    mMViewPager.OTU.at((f.j(motionEvent, 0) - f.j(motionEvent, 1)) + f.j(motionEvent, 1), (f.k(motionEvent, 0) - f.k(motionEvent, 1)) + f.k(motionEvent, 1));
                }
                if (mMViewPager.xsS > mMViewPager.OTU.getDoubleTabScale() * 2.0f) {
                    float j4 = f.j(motionEvent, 0) - f.j(motionEvent, 1);
                    float k4 = f.k(motionEvent, 0) - f.k(motionEvent, 1);
                    mMViewPager.OTU.setMaxZoomLimit(mMViewPager.OTU.getDoubleTabScale() * 2.0f);
                    mMViewPager.OTU.r(mMViewPager.OTU.getDoubleTabScale() * 2.0f, j4 + f.j(motionEvent, 1), k4 + f.k(motionEvent, 1));
                    mMViewPager.OTU.gKz();
                    break;
                }
                break;
        }
        Log.i("MicroMsg.MMViewPager", "alvinluo onTouchImageView consumed: %b", Boolean.valueOf(z3));
        AppMethodBeat.o(142313);
        return z3;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent, MotionEvent motionEvent2, float f2) {
        AppMethodBeat.i(205256);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.o(205256);
            return false;
        }
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b2 = b(motionEvent, motionEvent2);
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        if (Math.abs(f2) <= 500.0f) {
            AppMethodBeat.o(205256);
            return false;
        } else if (abs < 60.0f) {
            AppMethodBeat.o(205256);
            return false;
        } else if (abs < abs2) {
            AppMethodBeat.o(205256);
            return false;
        } else {
            if (b2) {
                mMViewPager.onKeyDown(21, null);
            } else {
                mMViewPager.onKeyDown(22, null);
            }
            AppMethodBeat.o(205256);
            return true;
        }
    }
}
