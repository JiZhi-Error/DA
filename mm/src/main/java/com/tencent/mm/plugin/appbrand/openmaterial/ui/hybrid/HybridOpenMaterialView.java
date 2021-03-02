package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public class HybridOpenMaterialView extends RelativeLayout implements com.tencent.mm.vending.e.a {
    private static final int nmo = at.aH(MMApplicationContext.getContext(), R.dimen.cr);
    private static final int nmp = at.aH(MMApplicationContext.getContext(), R.dimen.ce);
    private final VelocityTracker mVelocityTracker;
    private float nmA;
    private float nmB;
    private float nmC;
    private float nmD;
    private float nmE;
    private final LinkedList<Integer> nmF;
    private int nmG;
    private float nmH;
    private boolean nmI;
    private float nmJ;
    private boolean nmK;
    private boolean nmL;
    private boolean nmM;
    private boolean nmN;
    private LinearLayout nmq;
    private LinearLayout nmr;
    private FrameLayout nms;
    private MMWebView nmt;
    private final boolean nmu;
    private a nmv;
    private boolean nmw;
    private int nmx;
    private int nmy;
    private int nmz;

    public interface a {
        void bQd();

        void yH(int i2);
    }

    static /* synthetic */ void f(HybridOpenMaterialView hybridOpenMaterialView) {
        AppMethodBeat.i(227257);
        hybridOpenMaterialView.bQn();
        AppMethodBeat.o(227257);
    }

    static {
        AppMethodBeat.i(227258);
        AppMethodBeat.o(227258);
    }

    public HybridOpenMaterialView(Context context) {
        this(context, null);
    }

    public HybridOpenMaterialView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HybridOpenMaterialView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(227243);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.nmv = null;
        this.nmw = true;
        this.nmx = 0;
        this.nmy = 0;
        this.nmz = 0;
        this.nmA = 0.0f;
        this.nmB = 0.0f;
        this.nmC = 0.0f;
        this.nmD = 0.0f;
        this.nmE = 0.0f;
        this.nmF = new LinkedList<>();
        this.nmG = -1;
        this.nmH = 0.0f;
        this.nmI = false;
        this.nmJ = 0.0f;
        this.nmK = true;
        this.nmL = false;
        this.nmM = false;
        this.nmN = false;
        LayoutInflater.from(context).inflate(R.layout.bh1, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.g4h);
        this.nmq = (LinearLayout) findViewById(R.id.g4f);
        this.nmr = (LinearLayout) findViewById(R.id.g4i);
        this.nms = (FrameLayout) findViewById(R.id.g4g);
        setFitsSystemWindows(true);
        this.nmu = isLandscape();
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(227224);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "init, touch outside");
                if (HybridOpenMaterialView.this.nmw) {
                    HybridOpenMaterialView.this.hide();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227224);
            }
        });
        this.nmr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(227229);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227229);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass5 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(227230);
                HybridOpenMaterialView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                HybridOpenMaterialView.b(HybridOpenMaterialView.this);
                AppMethodBeat.o(227230);
            }
        });
        AppMethodBeat.o(227243);
    }

    public final ViewGroup.LayoutParams bQm() {
        AppMethodBeat.i(227244);
        if (this.nmu) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "generateMyLayoutParams, windowVisibleRect: ".concat(String.valueOf(rect)));
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((((float) rect.right) * 1.0f) / 2.0f), -1);
            AppMethodBeat.o(227244);
            return layoutParams;
        }
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        AppMethodBeat.o(227244);
        return layoutParams2;
    }

    public void setTitleView(View view) {
        AppMethodBeat.i(227245);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setTitleView");
        this.nmr.addView(view, -1, -1);
        AppMethodBeat.o(227245);
    }

    public void setContentView(MMWebView mMWebView) {
        AppMethodBeat.i(227246);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "setContentView");
        this.nms.addView(mMWebView, -1, -1);
        mMWebView.a(new MMWebView.e() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.MMWebView.e
            public final void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
                boolean z = true;
                AppMethodBeat.i(227231);
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onWebViewScrollChanged, l: %d, t: %d, oldl: %d, oldt: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                HybridOpenMaterialView hybridOpenMaterialView = HybridOpenMaterialView.this;
                if (i3 != 0) {
                    z = false;
                }
                hybridOpenMaterialView.nmK = z;
                AppMethodBeat.o(227231);
            }
        });
        this.nmt = mMWebView;
        AppMethodBeat.o(227246);
    }

    public void setListener(a aVar) {
        this.nmv = aVar;
    }

    public final void show() {
        float f2;
        AppMethodBeat.i(227247);
        this.nmM = true;
        if (this.nmu) {
            f2 = (float) this.nmy;
        } else {
            f2 = (float) this.nmz;
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, from: %d, to: %d", Integer.valueOf(this.nmx), Integer.valueOf((int) f2));
        if (this.nmt != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nmt.getLayoutParams();
            if (!(-1 == layoutParams.width && -1 == layoutParams.height)) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.nmt.setLayoutParams(layoutParams);
            }
            this.nmt.setBackgroundColor(getResources().getColor(R.color.f3044b));
        }
        this.nmq.setTranslationY((float) this.nmx);
        this.nmq.animate().translationY(f2).setDuration(300).setInterpolator(new DecelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass8 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(227235);
                HybridOpenMaterialView.this.nmJ = HybridOpenMaterialView.this.nmq.getTranslationY();
                HybridOpenMaterialView.f(HybridOpenMaterialView.this);
                AppMethodBeat.o(227235);
            }
        }).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass7 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(227232);
                HybridOpenMaterialView.this.nmN = true;
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, onAnimationStart");
                if (HybridOpenMaterialView.this.nmv != null) {
                    a unused = HybridOpenMaterialView.this.nmv;
                }
                AppMethodBeat.o(227232);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(227233);
                HybridOpenMaterialView.this.nmN = false;
                HybridOpenMaterialView.this.nmL = HybridOpenMaterialView.this.nmu;
                AppMethodBeat.o(227233);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(227234);
                HybridOpenMaterialView.this.nmN = false;
                AppMethodBeat.o(227234);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.o(227247);
    }

    public final void hide() {
        AppMethodBeat.i(227248);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, from: %f, to: %d", Float.valueOf(this.nmq.getTranslationY()), Integer.valueOf(this.nmx));
        this.nmM = false;
        this.nmq.animate().translationY((float) this.nmx).setDuration(this.nmL ? 500 : 300).setInterpolator(new AccelerateInterpolator()).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass10 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(227240);
                HybridOpenMaterialView.this.nmJ = HybridOpenMaterialView.this.nmq.getTranslationY();
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, curWholeContentAreaTranslationY: %f", Float.valueOf(HybridOpenMaterialView.this.nmJ));
                HybridOpenMaterialView.f(HybridOpenMaterialView.this);
                AppMethodBeat.o(227240);
            }
        }).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass9 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(227237);
                HybridOpenMaterialView.this.nmN = true;
                AppMethodBeat.o(227237);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(227238);
                HybridOpenMaterialView.this.nmN = false;
                HybridOpenMaterialView.this.nmL = false;
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "hide, onAnimationEnd");
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(227236);
                        if (HybridOpenMaterialView.this.nmv != null) {
                            HybridOpenMaterialView.this.nmv.bQd();
                        }
                        AppMethodBeat.o(227236);
                    }
                });
                AppMethodBeat.o(227238);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(227239);
                HybridOpenMaterialView.this.nmN = false;
                AppMethodBeat.o(227239);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.o(227248);
    }

    public void setAllowScroll2Hide(boolean z) {
        this.nmw = z;
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
        AppMethodBeat.i(227249);
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dead");
        if (this.nmt != null) {
            this.nmt.destroy();
        }
        AppMethodBeat.o(227249);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(227250);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, ev: " + motionEvent.getAction());
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (onInterceptTouchEvent) {
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, super intercept");
            AppMethodBeat.o(227250);
            return true;
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.nmF.addFirst(0);
                this.nmA = motionEvent.getX();
                this.nmB = motionEvent.getY();
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, down, x: %f, y: %f, curTranslationY: %f", Float.valueOf(this.nmA), Float.valueOf(this.nmB), Float.valueOf(this.nmJ));
                break;
            case 1:
                onInterceptTouchEvent = false;
                this.nmF.clear();
                this.nmG = -1;
                this.nmH = 0.0f;
                this.nmI = false;
                break;
            case 2:
                int i2 = 0;
                if (this.nmF.isEmpty()) {
                    Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, empty activePointerIds");
                } else {
                    i2 = this.nmF.getFirst().intValue();
                }
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                if (findPointerIndex < 0) {
                    Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, invalid pointerIndex");
                    findPointerIndex = 0;
                }
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, activePointerId: %d, pointerIndex: %d", Integer.valueOf(i2), Integer.valueOf(findPointerIndex));
                if (motionEvent.getY(findPointerIndex) < this.nmq.getTranslationY()) {
                    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, outside");
                    onInterceptTouchEvent = false;
                    break;
                } else {
                    float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.nmA);
                    float y = motionEvent.getY(findPointerIndex) - this.nmB;
                    float abs2 = Math.abs(y);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float abs3 = Math.abs(this.mVelocityTracker.getXVelocity());
                    float abs4 = Math.abs(this.mVelocityTracker.getYVelocity());
                    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, disXFromDown: %f, rawDisYFromDown: %f, xVelocity: %f, yVelocity: %f", Float.valueOf(abs), Float.valueOf(y), Float.valueOf(abs3), Float.valueOf(abs4));
                    if (abs2 >= 5.0f && abs2 > abs && abs4 > 0.0f && abs4 > abs3) {
                        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, move, vertical, isShown: %b, isFullScreenShown: %b, isWebViewScroll2Top: %b", Boolean.valueOf(this.nmM), Boolean.valueOf(this.nmL), Boolean.valueOf(this.nmK));
                        if (this.nmM) {
                            if (!this.nmL) {
                                if (0.0f <= y) {
                                    z = this.nmK;
                                    onInterceptTouchEvent = z;
                                    break;
                                } else {
                                    onInterceptTouchEvent = true;
                                    break;
                                }
                            } else if (0.0f <= y) {
                                onInterceptTouchEvent = this.nmK;
                                break;
                            } else {
                                onInterceptTouchEvent = false;
                                break;
                            }
                        }
                    }
                    z = onInterceptTouchEvent;
                    onInterceptTouchEvent = z;
                }
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onInterceptTouchEvent, intercept: ".concat(String.valueOf(onInterceptTouchEvent)));
        AppMethodBeat.o(227250);
        return onInterceptTouchEvent;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean z;
        int intValue;
        boolean z2 = true;
        AppMethodBeat.i(227251);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, event: " + motionEvent.getAction());
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.nmF.addFirst(0);
                this.nmC = motionEvent.getX();
                this.nmD = motionEvent.getY();
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, down, x: %f, y: %f", Float.valueOf(this.nmC), Float.valueOf(this.nmD));
                AppMethodBeat.o(227251);
                return true;
            case 1:
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isFullScreenShown: " + this.nmL);
                if (this.nmN) {
                    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleTouchUp, isAnimating");
                } else if (this.nmL) {
                    if (0.0f >= this.nmE || 0.15f * ((float) this.nmx) > Math.abs(this.nmE)) {
                        z2 = false;
                    }
                    if (!z2 || !this.nmw) {
                        bQo();
                    } else {
                        hide();
                    }
                } else {
                    if (0.0f >= this.nmE || 0.15f * ((float) this.nmx) > Math.abs(this.nmE)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z || !this.nmw) {
                        if (0.0f <= this.nmE || 0.05f * ((float) this.nmx) > Math.abs(this.nmE)) {
                            z2 = false;
                        }
                        if (z2) {
                            bQo();
                        } else {
                            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2HalfScreen");
                            d(this.nmq.getTranslationY(), (float) this.nmz, false);
                        }
                    } else {
                        hide();
                    }
                }
                this.nmC = 0.0f;
                this.nmD = 0.0f;
                this.nmF.clear();
                this.nmG = -1;
                this.nmH = 0.0f;
                this.nmI = false;
                break;
            case 2:
                if (this.nmF.isEmpty()) {
                    Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId not exist");
                    intValue = 0;
                } else {
                    intValue = this.nmF.getFirst().intValue();
                }
                int findPointerIndex = motionEvent.findPointerIndex(intValue);
                if (findPointerIndex < 0) {
                    Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, pointerIndex is illegal");
                    findPointerIndex = 0;
                }
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, activePointerId: %d, pointerIndex: %d", Integer.valueOf(intValue), Integer.valueOf(findPointerIndex));
                if (0.0f != this.nmC || 0.0f != this.nmD) {
                    if (!(-1 == this.nmG || this.nmG == intValue)) {
                        this.nmH = this.nmE;
                        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, active pointerId changed, disMoveFromDownExceptCurPointerId: " + this.nmH);
                    }
                    float x = motionEvent.getX(findPointerIndex) - this.nmC;
                    float y = (motionEvent.getY(findPointerIndex) - this.nmD) + this.nmH;
                    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, rawDisXFromDown: %f, rawDisYFromDown: %f", Float.valueOf(x), Float.valueOf(y));
                    if (Math.abs(y) > Math.abs(x)) {
                        if (this.nmI && 0.0f > y) {
                            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, dispatchTouchEvent2Child");
                            h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass11 */

                                public final void run() {
                                    AppMethodBeat.i(227241);
                                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                                    obtain.setAction(1);
                                    HybridOpenMaterialView.this.dispatchTouchEvent(obtain);
                                    MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                                    obtain2.setAction(0);
                                    HybridOpenMaterialView.this.dispatchTouchEvent(obtain2);
                                    AppMethodBeat.o(227241);
                                }
                            });
                        } else if (this.nmw || 0.0f >= y) {
                            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll");
                            if (this.nmN) {
                                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, isAnimating");
                            } else {
                                this.nmE = 0.68f * y;
                                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, disMoveFromDown: %f, curWholeContentAreaTranslationY: %f", Float.valueOf(this.nmE), Float.valueOf(this.nmJ));
                                float min = Math.min((float) this.nmx, Math.max((float) this.nmy, this.nmJ + this.nmE));
                                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "handleScroll, newTranslationY: ".concat(String.valueOf(min)));
                                this.nmq.setTranslationY(min);
                                bQn();
                            }
                            if (((float) this.nmy) >= this.nmq.getTranslationY()) {
                                this.nmI = true;
                                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, scroll to top, mayDispatchTouchEvent2Child");
                            }
                        }
                    }
                    this.nmE = y;
                    this.nmG = intValue;
                    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, move, lastActivePointerId: %d", Integer.valueOf(this.nmG));
                    break;
                } else {
                    this.nmF.addFirst(0);
                    this.nmC = motionEvent.getX(findPointerIndex);
                    this.nmD = motionEvent.getY(findPointerIndex);
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                this.nmF.addFirst(Integer.valueOf(pointerId));
                this.nmC = motionEvent.getX(actionIndex);
                this.nmD = motionEvent.getY(actionIndex);
                Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer down, pointerId: %d, x: %f, y: %f", Integer.valueOf(pointerId), Float.valueOf(this.nmC), Float.valueOf(this.nmD));
                break;
            case 6:
                int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.nmF.remove(Integer.valueOf(pointerId2));
                Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "onTouchEvent, pointer up, pointerId: %d", Integer.valueOf(pointerId2));
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(227251);
        return onTouchEvent;
    }

    private void bQn() {
        AppMethodBeat.i(227252);
        MMWebView mMWebView = this.nmt;
        if (mMWebView == null) {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, contentArea is null");
            AppMethodBeat.o(227252);
            return;
        }
        int max = Math.max(0, (int) (((float) mMWebView.getHeight()) - this.nmq.getTranslationY()));
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "dispatchContentVisibleHeightChange, visibleHeight: ".concat(String.valueOf(max)));
        if (this.nmv != null) {
            this.nmv.yH(max);
        }
        AppMethodBeat.o(227252);
    }

    private void bQo() {
        AppMethodBeat.i(227253);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "switch2FullScreen");
        d(this.nmq.getTranslationY(), (float) this.nmy, true);
        AppMethodBeat.o(227253);
    }

    private void d(float f2, float f3, final boolean z) {
        AppMethodBeat.i(227254);
        if (f3 == f2) {
            this.nmL = z;
            this.nmJ = f3;
            AppMethodBeat.o(227254);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(227225);
                HybridOpenMaterialView.this.nmq.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                HybridOpenMaterialView.f(HybridOpenMaterialView.this);
                AppMethodBeat.o(227225);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(227226);
                HybridOpenMaterialView.this.nmN = true;
                AppMethodBeat.o(227226);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(227227);
                HybridOpenMaterialView.this.nmN = false;
                HybridOpenMaterialView.this.nmL = z;
                HybridOpenMaterialView.this.nmJ = HybridOpenMaterialView.this.nmq.getTranslationY();
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "animateSwitch, curWholeContentAreaTranslationY: " + HybridOpenMaterialView.this.nmJ);
                AppMethodBeat.o(227227);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(227228);
                HybridOpenMaterialView.this.nmN = false;
                AppMethodBeat.o(227228);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
        AppMethodBeat.o(227254);
    }

    private boolean isLandscape() {
        boolean z = false;
        AppMethodBeat.i(227255);
        try {
            if (2 == getContext().getResources().getConfiguration().orientation) {
                z = true;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.HybridOpenMaterialView", "isLandscape fail since ".concat(String.valueOf(e2)));
        }
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "isLandscape: ".concat(String.valueOf(z)));
        AppMethodBeat.o(227255);
        return z;
    }

    private int getFullScreenTopRemainPx() {
        if (this.nmu) {
            return nmp;
        }
        return nmo;
    }

    public static abstract class b implements a {
        @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.a
        public void bQd() {
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.a
        public void yH(int i2) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public final Size nmR;
        public final int nmS;

        public c(Context context) {
            AppMethodBeat.i(227242);
            Point az = au.az(context);
            this.nmR = new Size(az.x, az.y);
            this.nmS = au.aD(context);
            Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "ScreenInfo#<init>, navigationBarHeight: " + this.nmS);
            AppMethodBeat.o(227242);
        }
    }

    static /* synthetic */ void b(HybridOpenMaterialView hybridOpenMaterialView) {
        int i2;
        int i3;
        AppMethodBeat.i(227256);
        c cVar = new c(hybridOpenMaterialView.getContext());
        int height = cVar.nmR.getHeight();
        Rect rect = new Rect();
        hybridOpenMaterialView.getWindowVisibleDisplayFrame(rect);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, windowVisibleRect: ".concat(String.valueOf(rect)));
        int width = rect.width();
        int height2 = rect.height();
        if (hybridOpenMaterialView.nmu) {
            if (width > height2) {
                i2 = height2;
                i3 = width;
            }
            i2 = width;
            i3 = height2;
        } else {
            if (width <= height2) {
                i2 = height2;
                i3 = width;
            }
            i2 = width;
            i3 = height2;
        }
        Size size = new Size(i3, i2);
        Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "calculateWindowSizeWorkaround, windowSize: ".concat(String.valueOf(size)));
        int min = Math.min(size.getHeight(), height);
        hybridOpenMaterialView.nmy = Math.max(0, hybridOpenMaterialView.getFullScreenTopRemainPx() - (height - (cVar.nmS + min)));
        hybridOpenMaterialView.nmJ = (float) min;
        hybridOpenMaterialView.nmq.setTranslationY(hybridOpenMaterialView.nmJ);
        hybridOpenMaterialView.bQn();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, screenHeight: %d, windowHeight: %d, fullScreenWholeContentAreaTranslationY: %d, curWholeContentAreaTranslationY: %f", Integer.valueOf(height), Integer.valueOf(min), Integer.valueOf(hybridOpenMaterialView.nmy), Float.valueOf(hybridOpenMaterialView.nmJ));
        hybridOpenMaterialView.nmx = hybridOpenMaterialView.nmq.getMeasuredHeight();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, wholeContentAreaHeight: " + hybridOpenMaterialView.nmx);
        int measuredHeight = hybridOpenMaterialView.nmr.getMeasuredHeight();
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, titleAreaHeight: ".concat(String.valueOf(measuredHeight)));
        if (hybridOpenMaterialView.nmt != null) {
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, compute");
            int i4 = hybridOpenMaterialView.nmx - measuredHeight;
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, compute, contentAreaHeight: ".concat(String.valueOf(i4)));
            if (hybridOpenMaterialView.nmt.getMeasuredHeight() != i4) {
                Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, compute, set contentArea height");
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) hybridOpenMaterialView.nmt.getLayoutParams();
                layoutParams.height = i4;
                hybridOpenMaterialView.nmt.setLayoutParams(layoutParams);
            }
            hybridOpenMaterialView.nmz = min - (height / 2);
            hybridOpenMaterialView.nmz = Math.max(0, hybridOpenMaterialView.nmz);
            Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "doSomeCalculateAfterLayout, halfScreenWholeContentAreaTranslationY: " + hybridOpenMaterialView.nmz);
        }
        AppMethodBeat.o(227256);
    }
}
