package com.tencent.mm.plugin.multitask.animation.c.c;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.animation.c.a.c;
import com.tencent.mm.plugin.multitask.animation.c.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.c.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004H\u0002J\b\u00104\u001a\u000200H\u0002J*\u00105\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0002J\"\u00108\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u00109\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\b\u0010:\u001a\u000200H\u0002J\u0010\u0010;\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "exitAnim", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initMaskView", "enterAnim", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreate", "refreshPosition", "resetView", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class b extends com.tencent.mm.plugin.multitask.animation.c.a.b {
    public static final a Abj = new a((byte) 0);
    private com.tencent.mm.plugin.multitask.b.b AaE;
    com.tencent.mm.plugin.multitask.animation.c.a.c AaG;
    com.tencent.mm.plugin.multitask.animation.c.a.d AaH;
    com.tencent.mm.plugin.multitask.c.c AaI;
    long AaJ = -1;
    boolean AaK = true;
    boolean AaL;
    protected com.tencent.mm.plugin.multitask.a.a Aak;

    static {
        AppMethodBeat.i(200551);
        AppMethodBeat.o(200551);
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(200552);
        bVar.aJ(3, false);
        AppMethodBeat.o(200552);
    }

    public static final /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(200554);
        bVar.eqM();
        AppMethodBeat.o(200554);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.multitask.a.a eqL() {
        AppMethodBeat.i(200545);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (aVar == null) {
            p.btv("pageAdapter");
        }
        AppMethodBeat.o(200545);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.multitask.animation.c.a.b
    public final void a(com.tencent.mm.plugin.multitask.a.a aVar, com.tencent.mm.plugin.multitask.b.b bVar, com.tencent.mm.plugin.multitask.c.c cVar) {
        float density;
        Resources resources;
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(200546);
        p.h(aVar, "pageAdapter");
        p.h(bVar, "multiTaskHelper");
        this.Aak = aVar;
        this.AaE = bVar;
        this.AaI = cVar;
        com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
        if (aVar2 == null) {
            p.btv("pageAdapter");
        }
        if (aVar2 != null) {
            aVar2.a(new g(this, bVar));
        }
        com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
        if (aVar3 == null) {
            p.btv("pageAdapter");
        }
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(aVar3.getActivity(), R.anim.co);
        com.tencent.mm.plugin.multitask.a.a aVar4 = this.Aak;
        if (aVar4 == null) {
            p.btv("pageAdapter");
        }
        ViewGroup chG = aVar4.chG();
        if (chG != null) {
            c.b bVar2 = com.tencent.mm.plugin.multitask.animation.c.a.c.Aaz;
            p.g(loadInterpolator, "interpolator");
            this.AaG = c.b.a(chG, new C1510b(), loadInterpolator);
        }
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
        if (cVar2 != null) {
            cVar2.WJ = 1;
        }
        com.tencent.mm.plugin.multitask.a.a aVar5 = this.Aak;
        if (aVar5 == null) {
            p.btv("pageAdapter");
        }
        Activity activity = aVar5.getActivity();
        if (activity == null || (resources = activity.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            com.tencent.mm.plugin.multitask.a.a aVar6 = this.Aak;
            if (aVar6 == null) {
                p.btv("pageAdapter");
            }
            density = com.tencent.mm.cb.a.getDensity(aVar6.getActivity());
        } else {
            density = displayMetrics.density;
        }
        float f2 = 100.0f * density;
        float f3 = density * 300.0f;
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar3 = this.AaG;
        if (cVar3 != null) {
            cVar3.Aau = f2;
        }
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar4 = this.AaG;
        if (cVar4 != null) {
            cVar4.Aat = f3;
            AppMethodBeat.o(200546);
            return;
        }
        AppMethodBeat.o(200546);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
    public static final class g implements a.AbstractC1499a {
        final /* synthetic */ com.tencent.mm.plugin.multitask.b.b Abh;
        final /* synthetic */ b Abk;

        g(b bVar, com.tencent.mm.plugin.multitask.b.b bVar2) {
            this.Abk = bVar;
            this.Abh = bVar2;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void aY(float f2) {
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void n(MotionEvent motionEvent) {
            AppMethodBeat.i(200541);
            p.h(motionEvent, "event");
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.Abk.AaG;
            if (cVar != null) {
                cVar.k(motionEvent);
                AppMethodBeat.o(200541);
                return;
            }
            AppMethodBeat.o(200541);
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int jJ(boolean z) {
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqD() {
            AppMethodBeat.i(200542);
            boolean eqS = this.Abh.eqS();
            AppMethodBeat.o(200542);
            return eqS;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean j(MotionEvent motionEvent) {
            AppMethodBeat.i(200543);
            p.h(motionEvent, "ev");
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.Abk.AaG;
            if (cVar != null) {
                boolean j2 = cVar.j(motionEvent);
                AppMethodBeat.o(200543);
                return j2;
            }
            AppMethodBeat.o(200543);
            return false;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int eqE() {
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.Abk.AaG;
            if (cVar != null) {
                return cVar.Aas;
            }
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void RF(int i2) {
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqF() {
            Boolean bool;
            AppMethodBeat.i(200544);
            if (this.Abk.AaJ == -1) {
                b bVar = this.Abk;
                com.tencent.mm.plugin.multitask.b.b bVar2 = this.Abh;
                if (bVar2 != null) {
                    bool = Boolean.valueOf(bVar2.eqW());
                } else {
                    bool = null;
                }
                bVar.AaK = bool.booleanValue();
                this.Abk.AaJ = 0;
            }
            boolean z = this.Abk.AaK;
            AppMethodBeat.o(200544);
            return z;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.animation.c.a.b
    public final void RG(int i2) {
        AppMethodBeat.i(200547);
        aJ(i2, true);
        AppMethodBeat.o(200547);
    }

    private final void aJ(int i2, boolean z) {
        com.tencent.mm.plugin.multitask.c.c cVar;
        AppMethodBeat.i(200548);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (aVar == null) {
            p.btv("pageAdapter");
        }
        if (aVar.bCI()) {
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
            if (aVar2 == null) {
                p.btv("pageAdapter");
            }
            if (aVar2.bPv()) {
                com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
                if (aVar3 == null) {
                    p.btv("pageAdapter");
                }
                aVar3.a((a.b) null);
            }
            MMHandlerThread.postToMainThread(new c(this, i2, z));
            AppMethodBeat.o(200548);
        } else if (this.AaI == null || (cVar = this.AaI) == null) {
            AppMethodBeat.o(200548);
        } else {
            cVar.RL(i2);
            AppMethodBeat.o(200548);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ int Abd;
        final /* synthetic */ b Abk;
        final /* synthetic */ boolean Abn;

        c(b bVar, int i2, boolean z) {
            this.Abk = bVar;
            this.Abd = i2;
            this.Abn = z;
        }

        public final void run() {
            Rect rect;
            com.tencent.mm.plugin.multitask.c.c cVar;
            AppMethodBeat.i(200536);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.Abk.AaG;
            if (cVar2 != null) {
                rect = cVar2.Aay;
            } else {
                rect = null;
            }
            if (rect != null) {
                b.a(this.Abk, this.Abd, this.Abn, this.Abk.AaI);
                AppMethodBeat.o(200536);
            } else if (this.Abk.AaI == null || (cVar = this.Abk.AaI) == null) {
                AppMethodBeat.o(200536);
            } else {
                cVar.RL(this.Abd);
                AppMethodBeat.o(200536);
            }
        }
    }

    private final void RJ(int i2) {
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar;
        String str = null;
        AppMethodBeat.i(200549);
        com.tencent.mm.plugin.multitask.b.b bVar = this.AaE;
        String RK = bVar != null ? bVar.RK(i2) : null;
        if (Util.isNullOrNil(RK)) {
            if (i2 == 4) {
                com.tencent.mm.plugin.multitask.b.b bVar2 = this.AaE;
                if (bVar2 != null) {
                    str = bVar2.eqQ();
                }
                RK = str;
            } else {
                com.tencent.mm.plugin.multitask.b.b bVar3 = this.AaE;
                if (bVar3 != null) {
                    str = bVar3.getPosition();
                }
                RK = str;
            }
        }
        if (RK != null) {
            try {
                Object[] array = new k(",").q(RK, 0).toArray(new String[0]);
                if (array == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(200549);
                    throw tVar;
                }
                String[] strArr = (String[]) array;
                if (strArr == null || strArr.length != 4 || (cVar = this.AaG) == null) {
                    AppMethodBeat.o(200549);
                    return;
                }
                Integer valueOf = Integer.valueOf(strArr[0]);
                p.g(valueOf, "Integer.valueOf(posVec[0])");
                int intValue = valueOf.intValue();
                Integer valueOf2 = Integer.valueOf(strArr[1]);
                p.g(valueOf2, "Integer.valueOf(posVec[1])");
                int intValue2 = valueOf2.intValue();
                Integer valueOf3 = Integer.valueOf(strArr[2]);
                p.g(valueOf3, "Integer.valueOf(posVec[2])");
                int intValue3 = valueOf3.intValue();
                Integer valueOf4 = Integer.valueOf(strArr[3]);
                p.g(valueOf4, "Integer.valueOf(posVec[3])");
                cVar.m(new Rect(intValue, intValue2, intValue3, valueOf4.intValue()));
                AppMethodBeat.o(200549);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "refreshPosition, get pos failed, %s", e2.getMessage());
                AppMethodBeat.o(200549);
            }
        } else {
            AppMethodBeat.o(200549);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "onUpdate"})
    public static final class d implements b.a {
        final /* synthetic */ Rect AaU;
        final /* synthetic */ int AaX;
        final /* synthetic */ int AaY;
        final /* synthetic */ b Abk;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ float wrG;

        d(b bVar, int i2, int i3, float f2, Rect rect, int i4, int i5) {
            this.Abk = bVar;
            this.cKE = i2;
            this.cKF = i3;
            this.wrG = f2;
            this.AaU = rect;
            this.AaX = i4;
            this.AaY = i5;
        }

        @Override // com.tencent.mm.ui.c.a.b.a
        public final void by(float f2) {
            AppMethodBeat.i(200537);
            float f3 = (float) this.cKE;
            float height = (((((float) this.cKF) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * f2 * (1.0f / this.wrG);
            float f4 = ((float) this.cKF) - height;
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = this.Abk.AaH;
            if (dVar != null) {
                dVar.setMaskAlpha((int) (255.0f * f2));
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = this.Abk.AaH;
            if (dVar2 != null) {
                dVar2.o(0.0f, height, f3, f4);
            }
            d.a aVar = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
            float f5 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * f2) / this.wrG;
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = this.Abk.AaH;
            if (dVar3 != null) {
                dVar3.a(f5, f5, f5, f5, f5, f5, f5, f5);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar4 = this.Abk.AaH;
            if (dVar4 != null) {
                dVar4.setPivotX((float) this.AaX);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar5 = this.Abk.AaH;
            if (dVar5 != null) {
                dVar5.setPivotY((float) this.AaY);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar6 = this.Abk.AaH;
            if (dVar6 != null) {
                dVar6.postInvalidate();
                AppMethodBeat.o(200537);
                return;
            }
            AppMethodBeat.o(200537);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ int Abd;
        final /* synthetic */ Bitmap Abf;
        final /* synthetic */ b Abk;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        e(b bVar, com.tencent.mm.plugin.multitask.c.c cVar, Bitmap bitmap, int i2) {
            this.Abk = bVar;
            this.zZX = cVar;
            this.Abf = bitmap;
            this.Abd = i2;
        }

        public final void run() {
            AppMethodBeat.i(200538);
            b.b(this.Abk);
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                cVar.a(this.Abf, false, this.Abd);
                AppMethodBeat.o(200538);
                return;
            }
            AppMethodBeat.o(200538);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ Bitmap Aac;
        final /* synthetic */ int Abd;
        final /* synthetic */ b Abk;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        f(b bVar, com.tencent.mm.plugin.multitask.c.c cVar, Bitmap bitmap, int i2) {
            this.Abk = bVar;
            this.zZX = cVar;
            this.Aac = bitmap;
            this.Abd = i2;
        }

        public final void run() {
            AppMethodBeat.i(200540);
            this.Abk.AaL = false;
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitask.animation.c.c.b.f.AnonymousClass1 */
                final /* synthetic */ f Abo;

                {
                    this.Abo = r1;
                }

                public final void run() {
                    ViewParent viewParent;
                    ViewParent viewParent2 = null;
                    AppMethodBeat.i(200539);
                    com.tencent.mm.plugin.multitask.c.c cVar = this.Abo.zZX;
                    if (cVar != null) {
                        cVar.g(this.Abo.Aac, this.Abo.Abd);
                    }
                    if (this.Abo.Abk.AaH != null) {
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar = this.Abo.Abk.AaH;
                        if (dVar != null) {
                            viewParent = dVar.getParent();
                        } else {
                            viewParent = null;
                        }
                        if (viewParent != null) {
                            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = this.Abo.Abk.AaH;
                            if (dVar2 != null) {
                                viewParent2 = dVar2.getParent();
                            }
                            if (viewParent2 == null) {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                                AppMethodBeat.o(200539);
                                throw tVar;
                            }
                            ((ViewGroup) viewParent2).removeView(this.Abo.Abk.AaH);
                        }
                    }
                    AppMethodBeat.o(200539);
                }
            });
            AppMethodBeat.o(200540);
        }
    }

    private final void eqM() {
        AppMethodBeat.i(200550);
        com.tencent.mm.plugin.multitask.animation.c.a.d dVar = this.AaH;
        if (dVar != null) {
            dVar.setTranslationX(0.0f);
        }
        com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = this.AaH;
        if (dVar2 != null) {
            dVar2.setTranslationY(0.0f);
        }
        com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = this.AaH;
        if (dVar3 != null) {
            dVar3.setScaleX(1.0f);
        }
        com.tencent.mm.plugin.multitask.animation.c.a.d dVar4 = this.AaH;
        if (dVar4 != null) {
            dVar4.setScaleY(1.0f);
            AppMethodBeat.o(200550);
            return;
        }
        AppMethodBeat.o(200550);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0016J\u001a\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010(\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0005H\u0016J2\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0016J2\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010\u001f2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001cH\u0016J8\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0016J\u001a\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010\u001f2\u0006\u0010:\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.c.c.b$b  reason: collision with other inner class name */
    final class C1510b extends c.a implements b.AbstractC2081b {
        private int AaN = -1;
        private int AaO = -1;
        private Rect AaQ;
        private final int AaR = 400;
        private boolean iGD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1510b() {
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final boolean c(View view, int i2) {
            AppMethodBeat.i(200529);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = b.this.AaG;
            if (cVar != null) {
                boolean RH = cVar.RH(i2);
                AppMethodBeat.o(200529);
                return RH;
            }
            AppMethodBeat.o(200529);
            return false;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final int awM() {
            return 1;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void l(View view, int i2, int i3, int i4, int i5) {
        }

        private final boolean bx(float f2) {
            Bitmap bitmap;
            Rect rect;
            AppMethodBeat.i(200530);
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
            if (dVar2 != null) {
                bitmap = dVar2.getContentBitmap();
            } else {
                bitmap = null;
            }
            if (dVar == null || bitmap == null) {
                AppMethodBeat.o(200530);
                return false;
            }
            int width = (int) (((float) bitmap.getWidth()) * 1.25f);
            int height = (int) (((float) bitmap.getHeight()) * 1.25f);
            Rect rect2 = new Rect(0, 0, width, height);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = b.this.AaG;
            if (cVar == null || (rect = cVar.Aay) == null) {
                rect = new Rect();
            }
            int width2 = (rect.width() / 2) + rect.left;
            int height2 = (rect.height() / 2) + rect.top;
            float width3 = ((float) rect.width()) / ((float) width);
            com.tencent.mm.ui.c.a.a.gu(dVar).a(new a(width, height, width3, rect, dVar, width2, height2, this, f2)).aJ(new RunnableC1511b(bitmap, this, f2)).cp(width3).cq(width3).cn(((float) (width2 - (rect2.left + (rect2.width() / 2)))) * width3).co(((float) (height2 - ((rect2.height() / 2) + rect2.top))) * width3).c(new AccelerateInterpolator()).gKg().start();
            AppMethodBeat.o(200530);
            return true;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$1"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.c.b$b$a */
        public static final class a implements b.a {
            final /* synthetic */ Rect AaU;
            final /* synthetic */ com.tencent.mm.plugin.multitask.animation.c.a.d AaW;
            final /* synthetic */ int AaX;
            final /* synthetic */ int AaY;
            final /* synthetic */ float Abb;
            final /* synthetic */ C1510b Abl;
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ float wrG;

            a(int i2, int i3, float f2, Rect rect, com.tencent.mm.plugin.multitask.animation.c.a.d dVar, int i4, int i5, C1510b bVar, float f3) {
                this.cKE = i2;
                this.cKF = i3;
                this.wrG = f2;
                this.AaU = rect;
                this.AaW = dVar;
                this.AaX = i4;
                this.AaY = i5;
                this.Abl = bVar;
                this.Abb = f3;
            }

            @Override // com.tencent.mm.ui.c.a.b.a
            public final void by(float f2) {
                AppMethodBeat.i(200524);
                float f3 = this.Abb + ((1.0f - this.Abb) * f2);
                float height = (((((float) this.cKF) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * f3 * (1.0f / this.wrG);
                this.AaW.setPivotX((float) this.AaX);
                this.AaW.setPivotY((float) this.AaY);
                this.AaW.setMaskAlpha((int) (255.0f * f3));
                this.AaW.o(0.0f, height, (float) this.cKE, ((float) this.cKF) - height);
                d.a aVar = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                float f4 = (f3 * ((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS)) / this.wrG;
                this.AaW.a(f4, f4, f4, f4, f4, f4, f4, f4);
                this.AaW.postInvalidate();
                AppMethodBeat.o(200524);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$2"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.c.b$b$b  reason: collision with other inner class name */
        public static final class RunnableC1511b implements Runnable {
            final /* synthetic */ float Abb;
            final /* synthetic */ C1510b Abl;
            final /* synthetic */ Bitmap cKG;

            RunnableC1511b(Bitmap bitmap, C1510b bVar, float f2) {
                this.cKG = bitmap;
                this.Abl = bVar;
                this.Abb = f2;
            }

            public final void run() {
                AppMethodBeat.i(200526);
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.multitask.animation.c.c.b.C1510b.RunnableC1511b.AnonymousClass1 */
                    final /* synthetic */ RunnableC1511b Abm;

                    {
                        this.Abm = r1;
                    }

                    public final void run() {
                        ViewParent viewParent;
                        ViewParent viewParent2 = null;
                        AppMethodBeat.i(200525);
                        com.tencent.mm.plugin.multitask.c.c cVar = b.this.AaI;
                        if (cVar != null) {
                            cVar.g(this.Abm.cKG, 3);
                        }
                        if (b.this.AaH != null) {
                            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
                            if (dVar != null) {
                                viewParent = dVar.getParent();
                            } else {
                                viewParent = null;
                            }
                            if (viewParent != null) {
                                com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
                                if (dVar2 != null) {
                                    viewParent2 = dVar2.getParent();
                                }
                                if (viewParent2 == null) {
                                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                                    AppMethodBeat.o(200525);
                                    throw tVar;
                                }
                                ((ViewGroup) viewParent2).removeView(b.this.AaH);
                            }
                        }
                        AppMethodBeat.o(200525);
                    }
                });
                AppMethodBeat.o(200526);
            }
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void b(View view, float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(200531);
            if (this.iGD) {
                AppMethodBeat.o(200531);
            } else if (Math.abs(f2) <= ((float) this.AaR) || !bx(0.0f)) {
                MMHandlerThread.postToMainThread(new c(this));
                b.this.AaJ = -1;
                View contentView = b.this.eqL().getContentView();
                if (contentView != null) {
                    contentView.setVisibility(0);
                    AppMethodBeat.o(200531);
                    return;
                }
                AppMethodBeat.o(200531);
            } else {
                this.iGD = true;
                Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewReleased, auto add multitask!");
                AppMethodBeat.o(200531);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.c.b$b$c */
        static final class c implements Runnable {
            final /* synthetic */ C1510b Abl;

            c(C1510b bVar) {
                this.Abl = bVar;
            }

            public final void run() {
                ViewParent viewParent;
                ViewParent viewParent2 = null;
                AppMethodBeat.i(200527);
                if (b.this.AaH != null) {
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
                    if (dVar != null) {
                        viewParent = dVar.getParent();
                    } else {
                        viewParent = null;
                    }
                    if (viewParent != null) {
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
                        if (dVar2 != null) {
                            viewParent2 = dVar2.getParent();
                        }
                        if (viewParent2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(200527);
                            throw tVar;
                        }
                        ((ViewGroup) viewParent2).removeView(b.this.AaH);
                    }
                }
                AppMethodBeat.o(200527);
            }
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final int RI(int i2) {
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void L(int i2) {
            AppMethodBeat.i(200532);
            Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewDragStateChanged, state:".concat(String.valueOf(i2)));
            AppMethodBeat.o(200532);
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(boolean z) {
            AppMethodBeat.i(200533);
            Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onComplete");
            AppMethodBeat.o(200533);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void eqJ() {
            AppMethodBeat.i(200534);
            Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewCaptured");
            b.a(b.this);
            this.AaN = -1;
            this.AaO = -1;
            this.iGD = false;
            AppMethodBeat.o(200534);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void a(float f2, float f3, int i2, int i3, int i4, int i5) {
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar;
            Rect rect;
            Rect rect2;
            float f4;
            int i6;
            AppMethodBeat.i(200535);
            if (b.this.AaH != null && ((dVar = b.this.AaH) == null || dVar.getWidth() != 0)) {
                com.tencent.mm.plugin.multitask.animation.c.a.c cVar = b.this.AaG;
                if (cVar != null) {
                    rect = cVar.Aay;
                } else {
                    rect = null;
                }
                if (rect != null) {
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
                    int width = dVar2 != null ? dVar2.getWidth() : 0;
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = b.this.AaH;
                    int height = dVar3 != null ? dVar3.getHeight() : 0;
                    if (this.AaQ == null) {
                        this.AaQ = com.tencent.mm.plugin.multitask.f.c.eA(b.this.AaH);
                    }
                    if (this.AaN == -1 && this.AaO == -1) {
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar4 = b.this.AaH;
                        this.AaN = dVar4 != null ? (int) dVar4.getTranslationX() : 0;
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar5 = b.this.AaH;
                        this.AaO = dVar5 != null ? (int) dVar5.getTranslationY() : 0;
                    }
                    float f5 = (f2 / ((float) width)) / 3.0f;
                    com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = b.this.AaG;
                    if (cVar2 == null || (rect2 = cVar2.Aay) == null) {
                        rect2 = new Rect();
                    }
                    float width2 = ((float) rect2.width()) / ((float) width);
                    int width3 = rect2.left + (rect2.width() / 2);
                    int height2 = rect2.top + (rect2.height() / 2);
                    if (f5 > 1.0f) {
                        f5 = 1.0f;
                    } else if (f5 < 0.0f) {
                        f5 = 0.0f;
                    }
                    float f6 = 1.0f - (f5 * (1.0f - width2));
                    if (f6 > 1.0f) {
                        f4 = 1.0f;
                    } else {
                        f4 = f6;
                    }
                    float f7 = (1.0f - f4) / (1.0f - width2);
                    if (f7 > 1.0f) {
                        f7 = 1.0f;
                    } else if (f7 < 0.0f) {
                        f7 = 0.0f;
                    }
                    float f8 = (float) width3;
                    Rect rect3 = this.AaQ;
                    int i7 = rect3 != null ? rect3.left : 0;
                    Rect rect4 = this.AaQ;
                    float width4 = f8 - ((float) (i7 + ((rect4 != null ? rect4.width() : 0) / 2)));
                    float f9 = (float) height2;
                    Rect rect5 = this.AaQ;
                    int i8 = rect5 != null ? rect5.top : 0;
                    Rect rect6 = this.AaQ;
                    if (rect6 != null) {
                        i6 = rect6.height();
                    } else {
                        i6 = 0;
                    }
                    float f10 = ((float) this.AaN) + (width4 * width2 * f7);
                    float f11 = ((float) this.AaO) + ((f9 - ((float) (i8 + (i6 / 2)))) * width2 * f7);
                    if (f7 < 0.16f || this.iGD) {
                        float f12 = (float) width;
                        float height3 = (((((float) height) * width2) - ((float) rect2.height())) / 2.0f) * f7 * (1.0f / width2);
                        float f13 = ((float) height) - height3;
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar6 = b.this.AaH;
                        if (dVar6 != null) {
                            dVar6.setMaskAlpha((int) (255.0f * f7));
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar7 = b.this.AaH;
                        if (dVar7 != null) {
                            dVar7.o(0.0f, height3, f12, f13);
                        }
                        d.a aVar = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                        float f14 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * f7) / f4;
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar8 = b.this.AaH;
                        if (dVar8 != null) {
                            dVar8.a(f14, f14, f14, f14, f14, f14, f14, f14);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar9 = b.this.AaH;
                        if (dVar9 != null) {
                            dVar9.setPivotX((float) width3);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar10 = b.this.AaH;
                        if (dVar10 != null) {
                            dVar10.setPivotY((float) height2);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar11 = b.this.AaH;
                        if (dVar11 != null) {
                            dVar11.setTranslationX(f10);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar12 = b.this.AaH;
                        if (dVar12 != null) {
                            dVar12.setTranslationY(f11);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar13 = b.this.AaH;
                        if (dVar13 != null) {
                            dVar13.setScaleX(f4);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar14 = b.this.AaH;
                        if (dVar14 != null) {
                            dVar14.setScaleY(f4);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar15 = b.this.AaH;
                        if (dVar15 != null) {
                            dVar15.postInvalidate();
                        }
                        Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "touchX: %f, touchY: %f, dx: %d, dy: %d, transX: %f, transY: %f, scale: %f ", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f4));
                        AppMethodBeat.o(200535);
                        return;
                    }
                    this.iGD = true;
                    if (!bx(f7)) {
                        MMHandlerThread.postToMainThread(new d(this));
                    }
                    AppMethodBeat.o(200535);
                    return;
                }
            }
            AppMethodBeat.o(200535);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.c.b$b$d */
        static final class d implements Runnable {
            final /* synthetic */ C1510b Abl;

            d(C1510b bVar) {
                this.Abl = bVar;
            }

            public final void run() {
                ViewParent viewParent;
                ViewParent viewParent2;
                Bitmap bitmap;
                AppMethodBeat.i(200528);
                com.tencent.mm.plugin.multitask.c.c cVar = b.this.AaI;
                if (cVar != null) {
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
                    if (dVar != null) {
                        bitmap = dVar.getContentBitmap();
                    } else {
                        bitmap = null;
                    }
                    cVar.g(bitmap, 3);
                }
                if (b.this.AaH != null) {
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
                    if (dVar2 != null) {
                        viewParent = dVar2.getParent();
                    } else {
                        viewParent = null;
                    }
                    if (viewParent != null) {
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = b.this.AaH;
                        if (dVar3 != null) {
                            viewParent2 = dVar3.getParent();
                        } else {
                            viewParent2 = null;
                        }
                        if (viewParent2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(200528);
                            throw tVar;
                        }
                        ((ViewGroup) viewParent2).removeView(b.this.AaH);
                    }
                }
                AppMethodBeat.o(200528);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$Companion;", "", "()V", "MAX_FLING_VELOCITY", "", "MIN_FLING_VELOCITY", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f1, code lost:
        if ((r0 != null ? r0.getParent() : null) == null) goto L_0x00f3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.multitask.animation.c.c.b r11, int r12, boolean r13, com.tencent.mm.plugin.multitask.c.c r14) {
        /*
        // Method dump skipped, instructions count: 527
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.animation.c.c.b.a(com.tencent.mm.plugin.multitask.animation.c.c.b, int, boolean, com.tencent.mm.plugin.multitask.c.c):void");
    }
}
