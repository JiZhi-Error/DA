package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.app.Activity;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0006\u0010&\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020\u001bJ\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "swipeToMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "<set-?>", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "floatIndicatorView", "getFloatIndicatorView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "indicatorBottomMargin", "", "indicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "indicatorRightMargin", "isIndicatorHit", "", "isIndicatorShowing", "isLandscape", "isWillSwipedBack", "lastPosXWhenSwipeReleased", "", "swipeStartTime", "", "attachFloatIndicatorView", "", "calculateIndicatorBottomMargin", "checkShowIndicator", "scrollPercent", "createFloatIndicator", "detachFloatIndicatorView", "hideIndicator", "markIsIndicatorHitByTouchEvent", "event", "Landroid/view/MotionEvent;", "showIndicator", "start", "stop", "updateLayoutMargins", "updateOrientation", "Companion", "plugin-multitask_release"})
public final class b {
    public static final a Aam = new a((byte) 0);
    public FloatMultiTaskIndicatorView Aaj = new FloatMultiTaskIndicatorView(this.Aak.getActivity(), null, 6, (byte) 0);
    public final com.tencent.mm.plugin.multitask.a.a Aak;
    private final e Aal;
    private boolean iqo;
    private float oXQ;
    private boolean oYA;
    private long oYB = -1;
    private int oYv;
    private int oYw;
    private FrameLayout.LayoutParams oYx;
    private boolean oYy;
    private boolean oYz;

    static {
        AppMethodBeat.i(200441);
        AppMethodBeat.o(200441);
    }

    public b(com.tencent.mm.plugin.multitask.a.a aVar, e eVar) {
        Integer num;
        Integer num2 = null;
        p.h(aVar, "pageAdapter");
        AppMethodBeat.i(200440);
        this.Aak = aVar;
        this.Aal = eVar;
        FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aaj;
        if (floatMultiTaskIndicatorView != null) {
            floatMultiTaskIndicatorView.setOnOrientationChangedListener(new C1513b(this));
        }
        jX(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) > com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
        this.oYx = new FrameLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams layoutParams = this.oYx;
        if (layoutParams != null) {
            layoutParams.gravity = 8388693;
        }
        FrameLayout.LayoutParams layoutParams2 = this.oYx;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = this.oYw;
        }
        FrameLayout.LayoutParams layoutParams3 = this.oYx;
        if (layoutParams3 != null) {
            layoutParams3.rightMargin = this.oYv;
        }
        FloatMultiTaskIndicatorView floatMultiTaskIndicatorView2 = this.Aaj;
        if (floatMultiTaskIndicatorView2 != null) {
            floatMultiTaskIndicatorView2.setLayoutParams(this.oYx);
        }
        Object[] objArr = new Object[2];
        FrameLayout.LayoutParams layoutParams4 = this.oYx;
        if (layoutParams4 != null) {
            num = Integer.valueOf(layoutParams4.rightMargin);
        } else {
            num = null;
        }
        objArr[0] = num;
        FrameLayout.LayoutParams layoutParams5 = this.oYx;
        objArr[1] = layoutParams5 != null ? Integer.valueOf(layoutParams5.bottomMargin) : num2;
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", objArr);
        AppMethodBeat.o(200440);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(200442);
        bVar.jX(z);
        AppMethodBeat.o(200442);
    }

    public static final /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(200444);
        bVar.bKU();
        AppMethodBeat.o(200444);
    }

    public static final /* synthetic */ int k(b bVar) {
        AppMethodBeat.i(200445);
        int cjc = bVar.cjc();
        AppMethodBeat.o(200445);
        return cjc;
    }

    public static final /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(200447);
        bVar.cjd();
        AppMethodBeat.o(200447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$createFloatIndicator$1", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.swipeahead.b$b  reason: collision with other inner class name */
    public static final class C1513b implements FloatMultiTaskIndicatorView.b {
        final /* synthetic */ b Aan;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1513b(b bVar) {
            this.Aan = bVar;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView.b
        public final void jY(boolean z) {
            Integer num;
            Integer num2 = null;
            AppMethodBeat.i(200428);
            Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged, isLandscape:%s", Boolean.valueOf(z));
            b.a(this.Aan, z);
            FrameLayout.LayoutParams layoutParams = this.Aan.oYx;
            if (layoutParams != null) {
                layoutParams.bottomMargin = this.Aan.oYw;
            }
            FrameLayout.LayoutParams layoutParams2 = this.Aan.oYx;
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = this.Aan.oYv;
            }
            FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aan.Aaj;
            if (floatMultiTaskIndicatorView != null) {
                floatMultiTaskIndicatorView.setLayoutParams(this.Aan.oYx);
            }
            Object[] objArr = new Object[2];
            FrameLayout.LayoutParams layoutParams3 = this.Aan.oYx;
            if (layoutParams3 != null) {
                num = Integer.valueOf(layoutParams3.rightMargin);
            } else {
                num = null;
            }
            objArr[0] = num;
            FrameLayout.LayoutParams layoutParams4 = this.Aan.oYx;
            if (layoutParams4 != null) {
                num2 = Integer.valueOf(layoutParams4.bottomMargin);
            }
            objArr[1] = num2;
            Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", objArr);
            AppMethodBeat.o(200428);
        }
    }

    private final void jX(boolean z) {
        AppMethodBeat.i(200435);
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "updateOrientation, isLandscape:%b", Boolean.valueOf(z));
        this.iqo = z;
        bKU();
        AppMethodBeat.o(200435);
    }

    private final void bKU() {
        AppMethodBeat.i(200436);
        Activity activity = this.Aak.getActivity();
        if (activity != null) {
            f.eG(activity);
        }
        if (this.iqo) {
            this.oYw = -f.oYP;
            this.oYv = cjc() - f.oYP;
            AppMethodBeat.o(200436);
            return;
        }
        this.oYv = -f.oYP;
        this.oYw = cjc() - f.oYP;
        AppMethodBeat.o(200436);
    }

    private final int cjc() {
        AppMethodBeat.i(200437);
        if (this.Aak.chH() >= 0) {
            int chH = this.Aak.chH();
            AppMethodBeat.o(200437);
            return chH;
        }
        int i2 = f.oYU;
        AppMethodBeat.o(200437);
        return i2;
    }

    public final void start() {
        int i2;
        int i3;
        AppMethodBeat.i(200438);
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "start FloatIndicatorController");
        cjd();
        this.oYB = -1;
        this.oYy = false;
        this.oYz = false;
        this.oYA = false;
        if (!this.Aak.bPp()) {
            AppMethodBeat.o(200438);
            return;
        }
        this.Aak.a(new d(this));
        if (this.Aaj != null) {
            FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aaj;
            if (floatMultiTaskIndicatorView != null) {
                floatMultiTaskIndicatorView.setVisibility(8);
            }
            ViewGroup chG = this.Aak.chG();
            try {
                FloatMultiTaskIndicatorView floatMultiTaskIndicatorView2 = this.Aaj;
                if ((floatMultiTaskIndicatorView2 != null ? floatMultiTaskIndicatorView2.getParent() : null) == null) {
                    if (chG != null) {
                        i2 = chG.getChildCount();
                    } else {
                        i2 = 0;
                    }
                    if (chG != null) {
                        int childCount = chG.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i3 = i2;
                                break;
                            } else if (chG.getChildAt(i4) instanceof SwipeBackLayout) {
                                i3 = i4 + 1;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    } else {
                        i3 = i2;
                    }
                    if (chG != null) {
                        chG.addView(this.Aaj, i3);
                        AppMethodBeat.o(200438);
                        return;
                    }
                    AppMethodBeat.o(200438);
                    return;
                }
                Log.w("MicroMsg.FloatMultiTaskIndicatorController", "attachFloatIndicatorView, already attached");
                AppMethodBeat.o(200438);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", e2, "attachFloatIndicatorView exception:%s", e2);
            }
        }
        AppMethodBeat.o(200438);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$start$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
    public static final class d implements a.AbstractC1499a {
        final /* synthetic */ b Aan;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(b bVar) {
            this.Aan = bVar;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void aY(float f2) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.i(200430);
            if (this.Aan.oYA) {
                AppMethodBeat.o(200430);
                return;
            }
            if (this.Aan.oYB < 0) {
                this.Aan.oYB = Util.nowMilliSecond();
            }
            if (b.a(this.Aan, f2)) {
                if (!this.Aan.oYz) {
                    b.g(this.Aan);
                }
                if (!this.Aan.oYy) {
                    float f5 = (f2 - 0.1f) / 0.3f;
                    if (f5 >= 0.0f) {
                        f4 = f5;
                    }
                    if (f4 <= 1.0f) {
                        f3 = f4;
                    }
                    int i2 = (int) (f3 * ((float) f.oYP));
                    if (this.Aan.iqo) {
                        this.Aan.oYw = (-f.oYP) + i2;
                        this.Aan.oYv = i2 + (b.k(this.Aan) - f.oYP);
                    } else {
                        this.Aan.oYv = (-f.oYP) + i2;
                        this.Aan.oYw = i2 + (b.k(this.Aan) - f.oYP);
                    }
                    FrameLayout.LayoutParams layoutParams = this.Aan.oYx;
                    if (layoutParams != null) {
                        layoutParams.bottomMargin = this.Aan.oYw;
                    }
                    FrameLayout.LayoutParams layoutParams2 = this.Aan.oYx;
                    if (layoutParams2 != null) {
                        layoutParams2.rightMargin = this.Aan.oYv;
                    }
                    FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aan.Aaj;
                    if (floatMultiTaskIndicatorView != null) {
                        floatMultiTaskIndicatorView.setLayoutParams(this.Aan.oYx);
                    }
                }
                b.l(this.Aan);
                AppMethodBeat.o(200430);
                return;
            }
            b.m(this.Aan);
            AppMethodBeat.o(200430);
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void n(MotionEvent motionEvent) {
            Animator animator;
            Animator animator2;
            AppMethodBeat.i(200431);
            p.h(motionEvent, "event");
            boolean z = this.Aan.oYy;
            b.a(this.Aan, motionEvent);
            if (this.Aan.oYz && this.Aan.oYy != z) {
                if (this.Aan.oYy) {
                    FrameLayout.LayoutParams layoutParams = this.Aan.oYx;
                    if (layoutParams != null) {
                        layoutParams.bottomMargin = this.Aan.oYw;
                    }
                    FrameLayout.LayoutParams layoutParams2 = this.Aan.oYx;
                    if (layoutParams2 != null) {
                        layoutParams2.rightMargin = this.Aan.oYv;
                    }
                    FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aan.Aaj;
                    if (floatMultiTaskIndicatorView != null) {
                        floatMultiTaskIndicatorView.setLayoutParams(this.Aan.oYx);
                    }
                }
                FloatMultiTaskIndicatorView floatMultiTaskIndicatorView2 = this.Aan.Aaj;
                if (floatMultiTaskIndicatorView2 != null) {
                    if (this.Aan.oYy) {
                        if (floatMultiTaskIndicatorView2.paT != null) {
                            if (floatMultiTaskIndicatorView2.pcn) {
                                Vibrator vibrator = floatMultiTaskIndicatorView2.paT;
                                if (vibrator != null) {
                                    vibrator.vibrate(new long[]{0, 10, 100, 10}, -1);
                                }
                            } else {
                                Vibrator vibrator2 = floatMultiTaskIndicatorView2.paT;
                                if (vibrator2 != null) {
                                    vibrator2.vibrate(10);
                                }
                            }
                        }
                        if (floatMultiTaskIndicatorView2.pcn) {
                            ImageView imageView = floatMultiTaskIndicatorView2.pch;
                            if (imageView != null) {
                                imageView.setImageDrawable(com.tencent.mm.svg.a.a.h(floatMultiTaskIndicatorView2.getResources(), R.raw.multitask_indicator_full_scale_icon));
                            }
                        } else {
                            ImageView imageView2 = floatMultiTaskIndicatorView2.pch;
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(com.tencent.mm.svg.a.a.h(floatMultiTaskIndicatorView2.getResources(), R.raw.multitask_indicator_scale_icon));
                            }
                        }
                        Animator animator3 = floatMultiTaskIndicatorView2.pck;
                        if (!(animator3 == null || !animator3.isRunning() || (animator2 = floatMultiTaskIndicatorView2.pck) == null)) {
                            animator2.cancel();
                        }
                        ImageView imageView3 = floatMultiTaskIndicatorView2.pcg;
                        if (imageView3 != null) {
                            imageView3.setScaleX(f.oYQ);
                        }
                        ImageView imageView4 = floatMultiTaskIndicatorView2.pcg;
                        if (imageView4 != null) {
                            imageView4.setScaleY(f.oYQ);
                        }
                        ImageView imageView5 = floatMultiTaskIndicatorView2.pch;
                        if (imageView5 != null) {
                            imageView5.setScaleX(f.oYQ);
                        }
                        ImageView imageView6 = floatMultiTaskIndicatorView2.pch;
                        if (imageView6 != null) {
                            imageView6.setScaleY(f.oYQ);
                        }
                    } else {
                        if (floatMultiTaskIndicatorView2.pcn) {
                            ImageView imageView7 = floatMultiTaskIndicatorView2.pch;
                            if (imageView7 != null) {
                                imageView7.setImageDrawable(com.tencent.mm.svg.a.a.h(floatMultiTaskIndicatorView2.getResources(), R.raw.multitask_indicator_full_icon));
                            }
                        } else {
                            ImageView imageView8 = floatMultiTaskIndicatorView2.pch;
                            if (imageView8 != null) {
                                imageView8.setImageDrawable(com.tencent.mm.svg.a.a.h(floatMultiTaskIndicatorView2.getResources(), R.raw.multitask_indicator_icon));
                            }
                        }
                        Animator animator4 = floatMultiTaskIndicatorView2.pcl;
                        if (!(animator4 == null || !animator4.isRunning() || (animator = floatMultiTaskIndicatorView2.pcl) == null)) {
                            animator.cancel();
                        }
                        ImageView imageView9 = floatMultiTaskIndicatorView2.pcg;
                        if (imageView9 != null) {
                            imageView9.setScaleX(1.0f);
                        }
                        ImageView imageView10 = floatMultiTaskIndicatorView2.pcg;
                        if (imageView10 != null) {
                            imageView10.setScaleY(1.0f);
                        }
                        ImageView imageView11 = floatMultiTaskIndicatorView2.pch;
                        if (imageView11 != null) {
                            imageView11.setScaleX(1.0f);
                        }
                        ImageView imageView12 = floatMultiTaskIndicatorView2.pch;
                        if (imageView12 != null) {
                            imageView12.setScaleY(1.0f);
                        }
                    }
                }
            }
            this.Aan.oXQ = motionEvent.getRawX();
            AppMethodBeat.o(200431);
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int jJ(boolean z) {
            AppMethodBeat.i(200432);
            Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", Boolean.valueOf(z), Boolean.valueOf(this.Aan.oYy));
            this.Aan.oYB = -1;
            this.Aan.oYA = z;
            b.m(this.Aan);
            if (!z) {
                this.Aan.oYy = false;
                AppMethodBeat.o(200432);
                return 1;
            }
            if (this.Aan.oYy) {
                this.Aan.oYy = false;
                Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, swipe to float ball");
                e eVar = this.Aan.Aal;
                Integer valueOf = eVar != null ? Integer.valueOf(eVar.bz(this.Aan.oXQ)) : null;
                if (valueOf != null) {
                    int intValue = valueOf.intValue();
                    if (intValue == 2) {
                        this.Aan.oYA = false;
                        AppMethodBeat.o(200432);
                        return 2;
                    }
                    AppMethodBeat.o(200432);
                    return intValue;
                }
            }
            AppMethodBeat.o(200432);
            return 1;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean j(MotionEvent motionEvent) {
            AppMethodBeat.i(200433);
            p.h(motionEvent, "ev");
            AppMethodBeat.o(200433);
            return false;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int eqE() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void RF(int i2) {
            e eVar;
            AppMethodBeat.i(200434);
            if (i2 != 1 || (eVar = this.Aan.Aal) == null) {
                AppMethodBeat.o(200434);
                return;
            }
            eVar.erf();
            AppMethodBeat.o(200434);
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqF() {
            return true;
        }
    }

    private final void cjd() {
        AppMethodBeat.i(200439);
        if (!this.oYz) {
            AppMethodBeat.o(200439);
            return;
        }
        if (this.Aaj != null) {
            FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aaj;
            if (floatMultiTaskIndicatorView != null) {
                floatMultiTaskIndicatorView.setVisibility(8);
            }
            this.oYz = false;
        }
        AppMethodBeat.o(200439);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b Aan;

        public c(b bVar) {
            this.Aan = bVar;
        }

        public final void run() {
            ViewParent viewParent = null;
            AppMethodBeat.i(200429);
            if (this.Aan.Aaj != null) {
                try {
                    FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = this.Aan.Aaj;
                    if ((floatMultiTaskIndicatorView != null ? floatMultiTaskIndicatorView.getParent() : null) != null) {
                        FloatMultiTaskIndicatorView floatMultiTaskIndicatorView2 = this.Aan.Aaj;
                        if (floatMultiTaskIndicatorView2 != null) {
                            viewParent = floatMultiTaskIndicatorView2.getParent();
                        }
                        if (viewParent == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(200429);
                            throw tVar;
                        }
                        ((ViewGroup) viewParent).removeView(this.Aan.Aaj);
                        AppMethodBeat.o(200429);
                        return;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", e2, "detachFloatIndicatorView exception:%s", e2);
                }
            }
            AppMethodBeat.o(200429);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$Companion;", "", "()V", "HIDE_INDICATOR_SWIPE_PERCENT", "", "SHOW_FULL_INDICATOR_SWIPE_PERCENT", "SHOW_INDICATOR_SWIPE_DURATION_THRESHOLD", "", "SHOW_INDICATOR_SWIPE_PERCENT", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ boolean a(b bVar, float f2) {
        AppMethodBeat.i(200443);
        if ((bVar.oYy || (f2 >= 0.1f && f2 < 0.9f)) && Util.nowMilliSecond() - bVar.oYB > 200) {
            AppMethodBeat.o(200443);
            return true;
        }
        AppMethodBeat.o(200443);
        return false;
    }

    public static final /* synthetic */ void l(b bVar) {
        AppMethodBeat.i(200446);
        if (!bVar.oYz && bVar.Aaj != null) {
            FloatMultiTaskIndicatorView floatMultiTaskIndicatorView = bVar.Aaj;
            if (floatMultiTaskIndicatorView != null) {
                floatMultiTaskIndicatorView.setVisibility(0);
            }
            bVar.oYz = true;
        }
        AppMethodBeat.o(200446);
    }

    public static final /* synthetic */ void a(b bVar, MotionEvent motionEvent) {
        AppMethodBeat.i(200448);
        if (!bVar.oYz) {
            bVar.oYy = false;
            AppMethodBeat.o(200448);
            return;
        }
        bVar.oYy = com.tencent.mm.plugin.multitask.f.c.q(bVar.Aaj, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        AppMethodBeat.o(200448);
    }
}
