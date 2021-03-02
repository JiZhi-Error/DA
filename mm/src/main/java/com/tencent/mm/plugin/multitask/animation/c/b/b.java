package com.tencent.mm.plugin.multitask.animation.c.b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.c.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u000200H\u0002J\"\u00106\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0002J\"\u00108\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u00109\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010:\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "anim", "delay", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initMaskView", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreate", "refreshPosition", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class b extends com.tencent.mm.plugin.multitask.animation.c.a.b {
    public static final a AaM = new a((byte) 0);
    com.tencent.mm.plugin.multitask.b.b AaE;
    com.tencent.mm.plugin.multitask.animation.c.a.c AaG;
    com.tencent.mm.plugin.multitask.animation.c.a.d AaH;
    com.tencent.mm.plugin.multitask.c.c AaI;
    long AaJ = -1;
    boolean AaK = true;
    boolean AaL;
    protected com.tencent.mm.plugin.multitask.a.a Aak;

    static {
        AppMethodBeat.i(200519);
        AppMethodBeat.o(200519);
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(200520);
        bVar.h(3, false, false);
        AppMethodBeat.o(200520);
    }

    public static final /* synthetic */ void a(b bVar, int i2, boolean z, com.tencent.mm.plugin.multitask.c.c cVar) {
        AppMethodBeat.i(200521);
        bVar.a(i2, z, cVar);
        AppMethodBeat.o(200521);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.multitask.a.a eqL() {
        AppMethodBeat.i(200513);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (aVar == null) {
            p.btv("pageAdapter");
        }
        AppMethodBeat.o(200513);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.multitask.animation.c.a.b
    public final void a(com.tencent.mm.plugin.multitask.a.a aVar, com.tencent.mm.plugin.multitask.b.b bVar, com.tencent.mm.plugin.multitask.c.c cVar) {
        float density;
        Resources resources;
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(200514);
        p.h(aVar, "pageAdapter");
        p.h(bVar, "multiTaskHelper");
        this.Aak = aVar;
        this.AaE = bVar;
        this.AaI = cVar;
        com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
        if (aVar2 == null) {
            p.btv("pageAdapter");
        }
        aVar2.a(new g(this, bVar));
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
            this.AaG = c.b.a(chG, new C1508b(), loadInterpolator);
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
            AppMethodBeat.o(200514);
            return;
        }
        AppMethodBeat.o(200514);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
    public static final class g implements a.AbstractC1499a {
        final /* synthetic */ b AaS;
        final /* synthetic */ com.tencent.mm.plugin.multitask.b.b Abh;

        g(b bVar, com.tencent.mm.plugin.multitask.b.b bVar2) {
            this.AaS = bVar;
            this.Abh = bVar2;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void aY(float f2) {
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void n(MotionEvent motionEvent) {
            AppMethodBeat.i(200509);
            p.h(motionEvent, "event");
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.AaS.AaG;
            if (cVar != null) {
                cVar.k(motionEvent);
                AppMethodBeat.o(200509);
                return;
            }
            AppMethodBeat.o(200509);
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int jJ(boolean z) {
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqD() {
            AppMethodBeat.i(200510);
            boolean eqS = this.Abh.eqS();
            AppMethodBeat.o(200510);
            return eqS;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean eqF() {
            Boolean bool;
            AppMethodBeat.i(200511);
            if (this.AaS.AaJ == -1) {
                b bVar = this.AaS;
                com.tencent.mm.plugin.multitask.b.b bVar2 = this.Abh;
                if (bVar2 != null) {
                    bool = Boolean.valueOf(bVar2.eqW());
                } else {
                    bool = null;
                }
                bVar.AaK = bool.booleanValue();
                this.AaS.AaJ = 0;
            }
            boolean z = this.AaS.AaK;
            AppMethodBeat.o(200511);
            return z;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final boolean j(MotionEvent motionEvent) {
            AppMethodBeat.i(200512);
            p.h(motionEvent, "ev");
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.AaS.AaG;
            if (cVar != null) {
                boolean j2 = cVar.j(motionEvent);
                AppMethodBeat.o(200512);
                return j2;
            }
            AppMethodBeat.o(200512);
            return false;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final int eqE() {
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.AaS.AaG;
            if (cVar != null) {
                return cVar.Aas;
            }
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.AbstractC1499a
        public final void RF(int i2) {
        }
    }

    private final void RJ(int i2) {
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar;
        String str = null;
        AppMethodBeat.i(200516);
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
                    AppMethodBeat.o(200516);
                    throw tVar;
                }
                String[] strArr = (String[]) array;
                if (strArr == null || strArr.length != 4 || (cVar = this.AaG) == null) {
                    AppMethodBeat.o(200516);
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
                AppMethodBeat.o(200516);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "refreshPosition, get pos failed, %s", e2.getMessage());
                AppMethodBeat.o(200516);
            }
        } else {
            AppMethodBeat.o(200516);
        }
    }

    private final void h(int i2, boolean z, boolean z2) {
        com.tencent.mm.plugin.multitask.c.c cVar;
        com.tencent.mm.plugin.multitask.c.c cVar2;
        Rect rect;
        com.tencent.mm.plugin.multitask.c.c cVar3;
        AppMethodBeat.i(200517);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (aVar == null) {
            p.btv("pageAdapter");
        }
        if (aVar.bCI()) {
            if (MMHandlerThread.isMainThread()) {
                com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
                if (aVar2 == null) {
                    p.btv("pageAdapter");
                }
                aVar2.a(new c(this));
                if (z2) {
                    MMHandlerThread.postToMainThread(new h(this, i2, z));
                    AppMethodBeat.o(200517);
                    return;
                }
                com.tencent.mm.plugin.multitask.animation.c.a.c cVar4 = this.AaG;
                if (cVar4 != null) {
                    rect = cVar4.Aay;
                } else {
                    rect = null;
                }
                if (rect != null) {
                    a(i2, z, this.AaI);
                    AppMethodBeat.o(200517);
                } else if (this.AaI == null || (cVar3 = this.AaI) == null) {
                    AppMethodBeat.o(200517);
                } else {
                    cVar3.RL(i2);
                    AppMethodBeat.o(200517);
                }
            } else if (this.AaI == null || (cVar2 = this.AaI) == null) {
                AppMethodBeat.o(200517);
            } else {
                cVar2.RL(i2);
                AppMethodBeat.o(200517);
            }
        } else if (this.AaI == null || (cVar = this.AaI) == null) {
            AppMethodBeat.o(200517);
        } else {
            cVar.RL(i2);
            AppMethodBeat.o(200517);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$doPrepareTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
    public static final class c implements a.b {
        final /* synthetic */ b AaS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.AaS = bVar;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.b
        public final void ei(boolean z) {
            com.tencent.mm.plugin.multitask.b.b bVar;
            crt hWn;
            fho fho;
            AppMethodBeat.i(259529);
            if (z || (bVar = this.AaS.AaE) == null || (hWn = bVar.hWn()) == null || (fho = hWn.VjZ) == null) {
                AppMethodBeat.o(259529);
                return;
            }
            fho.VjY = false;
            AppMethodBeat.o(259529);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ b AaS;
        final /* synthetic */ int Abd;
        final /* synthetic */ boolean UYZ;

        h(b bVar, int i2, boolean z) {
            this.AaS = bVar;
            this.Abd = i2;
            this.UYZ = z;
        }

        public final void run() {
            Rect rect;
            com.tencent.mm.plugin.multitask.c.c cVar;
            AppMethodBeat.i(259530);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaS.AaG;
            if (cVar2 != null) {
                rect = cVar2.Aay;
            } else {
                rect = null;
            }
            if (rect != null) {
                b.a(this.AaS, this.Abd, this.UYZ, this.AaS.AaI);
                AppMethodBeat.o(259530);
            } else if (this.AaS.AaI == null || (cVar = this.AaS.AaI) == null) {
                AppMethodBeat.o(259530);
            } else {
                cVar.RL(this.Abd);
                AppMethodBeat.o(259530);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010f, code lost:
        if ((r1 != null ? r1.getParent() : null) == null) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(int r15, boolean r16, com.tencent.mm.plugin.multitask.c.c r17) {
        /*
        // Method dump skipped, instructions count: 641
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.animation.c.b.b.a(int, boolean, com.tencent.mm.plugin.multitask.c.c):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "onUpdate"})
    public static final class d implements b.a {
        final /* synthetic */ b AaS;
        final /* synthetic */ boolean AaT;
        final /* synthetic */ Rect AaU;
        final /* synthetic */ int AaX;
        final /* synthetic */ int AaY;
        final /* synthetic */ int AaZ;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ float wrG;

        d(b bVar, boolean z, int i2, int i3, float f2, Rect rect, int i4, int i5, int i6) {
            this.AaS = bVar;
            this.AaT = z;
            this.cKE = i2;
            this.cKF = i3;
            this.wrG = f2;
            this.AaU = rect;
            this.AaX = i4;
            this.AaY = i5;
            this.AaZ = i6;
        }

        @Override // com.tencent.mm.ui.c.a.b.a
        public final void by(float f2) {
            float width;
            float f3;
            float f4;
            float f5;
            AppMethodBeat.i(200505);
            if (!this.AaT) {
                f3 = (float) this.cKE;
                f5 = (1.0f / this.wrG) * (((((float) this.cKF) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * f2;
                f4 = ((float) this.cKF) - f5;
                width = 0.0f;
            } else {
                width = (((((float) this.cKE) * this.wrG) - ((float) this.AaU.width())) / 2.0f) * f2 * (1.0f / this.wrG);
                f3 = ((float) this.cKE) - width;
                f4 = ((float) this.cKF) - 0.0f;
                f5 = 0.0f;
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = this.AaS.AaH;
            if (dVar != null) {
                dVar.setMaskAlpha((int) (255.0f * f2));
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = this.AaS.AaH;
            if (dVar2 != null) {
                dVar2.o(width, f5, f3, f4);
            }
            d.a aVar = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
            float f6 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * f2) / this.wrG;
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = this.AaS.AaH;
            if (dVar3 != null) {
                dVar3.a(f6, f6, f6, f6, f6, f6, f6, f6);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar4 = this.AaS.AaH;
            if (dVar4 != null) {
                dVar4.setPivotX((float) this.AaX);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar5 = this.AaS.AaH;
            if (dVar5 != null) {
                dVar5.setPivotY((float) this.AaY);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar6 = this.AaS.AaH;
            if (dVar6 != null) {
                dVar6.setRotate(((float) this.AaZ) * f2);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar7 = this.AaS.AaH;
            if (dVar7 != null) {
                dVar7.postInvalidate();
                AppMethodBeat.o(200505);
                return;
            }
            AppMethodBeat.o(200505);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ b AaS;
        final /* synthetic */ int Abd;
        final /* synthetic */ Bitmap Abf;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        e(b bVar, com.tencent.mm.plugin.multitask.c.c cVar, Bitmap bitmap, int i2) {
            this.AaS = bVar;
            this.zZX = cVar;
            this.Abf = bitmap;
            this.Abd = i2;
        }

        public final void run() {
            AppMethodBeat.i(200506);
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = this.AaS.AaH;
            if (dVar != null) {
                dVar.setTranslationX(0.0f);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = this.AaS.AaH;
            if (dVar2 != null) {
                dVar2.setTranslationY(0.0f);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar3 = this.AaS.AaH;
            if (dVar3 != null) {
                dVar3.setScaleX(1.0f);
            }
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar4 = this.AaS.AaH;
            if (dVar4 != null) {
                dVar4.setScaleY(1.0f);
            }
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                cVar.a(this.Abf, false, this.Abd);
                AppMethodBeat.o(200506);
                return;
            }
            AppMethodBeat.o(200506);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ b AaS;
        final /* synthetic */ int Abd;
        final /* synthetic */ Bitmap Abf;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        f(b bVar, com.tencent.mm.plugin.multitask.c.c cVar, Bitmap bitmap, int i2) {
            this.AaS = bVar;
            this.zZX = cVar;
            this.Abf = bitmap;
            this.Abd = i2;
        }

        public final void run() {
            AppMethodBeat.i(200508);
            this.AaS.AaL = false;
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitask.animation.c.b.b.f.AnonymousClass1 */
                final /* synthetic */ f Abg;

                {
                    this.Abg = r1;
                }

                public final void run() {
                    AppMethodBeat.i(200507);
                    com.tencent.mm.plugin.multitask.c.c cVar = this.Abg.zZX;
                    if (cVar != null) {
                        cVar.g(this.Abg.Abf, this.Abg.Abd);
                        AppMethodBeat.o(200507);
                        return;
                    }
                    AppMethodBeat.o(200507);
                }
            });
            AppMethodBeat.o(200508);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000eH\u0002J\"\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tH\u0016J\u001a\u0010+\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010$2\u0006\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0005H\u0016J2\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0016J2\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0016J8\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0016J\u001a\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010$2\u0006\u0010?\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mFractor", "", "getMFractor", "()F", "setMFractor", "(F)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.c.b.b$b  reason: collision with other inner class name */
    final class C1508b extends c.a implements b.AbstractC2081b {
        private int AaN = -1;
        private int AaO = -1;
        private float AaP;
        private Rect AaQ;
        private final int AaR = 400;
        private boolean iGD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1508b() {
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final boolean c(View view, int i2) {
            AppMethodBeat.i(200497);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = b.this.AaG;
            if (cVar != null) {
                boolean RH = cVar.RH(i2);
                AppMethodBeat.o(200497);
                return RH;
            }
            AppMethodBeat.o(200497);
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
            AppMethodBeat.i(200498);
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar2 = b.this.AaH;
            if (dVar2 != null) {
                bitmap = dVar2.getContentBitmap();
            } else {
                bitmap = null;
            }
            if (dVar == null || bitmap == null) {
                AppMethodBeat.o(200498);
                return false;
            }
            com.tencent.mm.plugin.multitask.b.b bVar = b.this.AaE;
            boolean eqP = bVar != null ? bVar.eqP() : false;
            int width = (int) (((float) bitmap.getWidth()) * 1.25f);
            int height = (int) (((float) bitmap.getHeight()) * 1.25f);
            Rect rect2 = new Rect(0, 0, width, height);
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = b.this.AaG;
            if (cVar == null || (rect = cVar.Aay) == null) {
                rect = new Rect();
            }
            int width2 = rect.left + (rect.width() / 2);
            int height2 = rect.top + (rect.height() / 2);
            float width3 = eqP ? ((float) rect.width()) / ((float) height) : ((float) rect.width()) / ((float) width);
            float height3 = eqP ? ((float) rect.height()) / ((float) width) : ((float) rect.width()) / ((float) width);
            float width4 = ((float) (width2 - (rect2.left + (rect2.width() / 2)))) * width3;
            float height4 = ((float) (height2 - ((rect2.height() / 2) + rect2.top))) * width3;
            int i2 = eqP ? 90 : 0;
            if (eqP) {
                dVar.setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
            com.tencent.mm.ui.c.a.a.gu(dVar).a(new a(eqP, width, height, width3, rect, height3, dVar, width2, height2, i2, this, f2)).aJ(new RunnableC1509b(dVar, bitmap, this, f2)).cp(width3).cq(width3).cn(width4).co(height4).c(new AccelerateInterpolator()).gKg().start();
            AppMethodBeat.o(200498);
            return true;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$1"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.b.b$b$a */
        public static final class a implements b.a {
            final /* synthetic */ boolean AaT;
            final /* synthetic */ Rect AaU;
            final /* synthetic */ float AaV;
            final /* synthetic */ com.tencent.mm.plugin.multitask.animation.c.a.d AaW;
            final /* synthetic */ int AaX;
            final /* synthetic */ int AaY;
            final /* synthetic */ int AaZ;
            final /* synthetic */ C1508b Aba;
            final /* synthetic */ float Abb;
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ float wrG;

            a(boolean z, int i2, int i3, float f2, Rect rect, float f3, com.tencent.mm.plugin.multitask.animation.c.a.d dVar, int i4, int i5, int i6, C1508b bVar, float f4) {
                this.AaT = z;
                this.cKE = i2;
                this.cKF = i3;
                this.wrG = f2;
                this.AaU = rect;
                this.AaV = f3;
                this.AaW = dVar;
                this.AaX = i4;
                this.AaY = i5;
                this.AaZ = i6;
                this.Aba = bVar;
                this.Abb = f4;
            }

            @Override // com.tencent.mm.ui.c.a.b.a
            public final void by(float f2) {
                float f3;
                float height;
                float f4;
                float f5;
                AppMethodBeat.i(200492);
                float f6 = this.Abb + ((1.0f - this.Abb) * f2);
                if (!this.AaT) {
                    f4 = (float) this.cKE;
                    f5 = (1.0f / this.wrG) * (((((float) this.cKF) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * f6;
                    f3 = ((float) this.cKF) - f5;
                    height = 0.0f;
                } else {
                    f3 = (float) this.cKF;
                    height = (((((float) this.cKE) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * f6 * (1.0f / this.AaV);
                    f4 = ((float) this.cKE) - height;
                    f5 = 0.0f;
                }
                this.AaW.setPivotX((float) this.AaX);
                this.AaW.setPivotY((float) this.AaY);
                this.AaW.setMaskAlpha((int) (255.0f * f6));
                this.AaW.o(height, f5, f4, f3);
                d.a aVar = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                float f7 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * f6) / this.wrG;
                this.AaW.a(f7, f7, f7, f7, f7, f7, f7, f7);
                this.AaW.setRotate(((float) this.AaZ) * f2);
                this.AaW.postInvalidate();
                AppMethodBeat.o(200492);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$2"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.b.b$b$b  reason: collision with other inner class name */
        public static final class RunnableC1509b implements Runnable {
            final /* synthetic */ com.tencent.mm.plugin.multitask.animation.c.a.d AaW;
            final /* synthetic */ C1508b Aba;
            final /* synthetic */ float Abb;
            final /* synthetic */ Bitmap cKG;

            RunnableC1509b(com.tencent.mm.plugin.multitask.animation.c.a.d dVar, Bitmap bitmap, C1508b bVar, float f2) {
                this.AaW = dVar;
                this.cKG = bitmap;
                this.Aba = bVar;
                this.Abb = f2;
            }

            public final void run() {
                AppMethodBeat.i(200494);
                this.AaW.setVisibility(8);
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.multitask.animation.c.b.b.C1508b.RunnableC1509b.AnonymousClass1 */
                    final /* synthetic */ RunnableC1509b Abc;

                    {
                        this.Abc = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(200493);
                        com.tencent.mm.plugin.multitask.c.c cVar = b.this.AaI;
                        if (cVar != null) {
                            cVar.g(this.Abc.cKG, 3);
                            AppMethodBeat.o(200493);
                            return;
                        }
                        AppMethodBeat.o(200493);
                    }
                });
                AppMethodBeat.o(200494);
            }
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void b(View view, float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(200499);
            Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, xvel: %f, yvel: %f", Float.valueOf(f2), Float.valueOf(f3));
            if (this.iGD) {
                Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, isFinish!");
                AppMethodBeat.o(200499);
            } else if (Math.abs(f2) <= ((float) this.AaR) || !bx(this.AaP)) {
                MMHandlerThread.postToMainThread(new c(this));
                b.this.AaJ = -1;
                View contentView = b.this.eqL().getContentView();
                if (contentView != null) {
                    contentView.setVisibility(0);
                }
                b.this.eqL();
                b.this.eqL().sj(true);
                AppMethodBeat.o(200499);
            } else {
                this.iGD = true;
                Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, auto add multitask!");
                AppMethodBeat.o(200499);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.b.b$b$c */
        static final class c implements Runnable {
            final /* synthetic */ C1508b Aba;

            c(C1508b bVar) {
                this.Aba = bVar;
            }

            public final void run() {
                ViewParent viewParent;
                ViewParent viewParent2 = null;
                AppMethodBeat.i(200495);
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
                            AppMethodBeat.o(200495);
                            throw tVar;
                        }
                        ((ViewGroup) viewParent2).removeView(b.this.AaH);
                    }
                }
                AppMethodBeat.o(200495);
            }
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final int RI(int i2) {
            return 0;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void L(int i2) {
            AppMethodBeat.i(200500);
            Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewDragStateChanged, state:".concat(String.valueOf(i2)));
            AppMethodBeat.o(200500);
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(boolean z) {
            AppMethodBeat.i(200501);
            Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onComplete");
            AppMethodBeat.o(200501);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void eqJ() {
            AppMethodBeat.i(200502);
            Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured");
            if (this.iGD) {
                Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured, isFinish!");
                AppMethodBeat.o(200502);
                return;
            }
            b.a(b.this);
            this.AaN = -1;
            this.AaO = -1;
            AppMethodBeat.o(200502);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void a(float f2, float f3, int i2, int i3, int i4, int i5) {
            com.tencent.mm.plugin.multitask.animation.c.a.d dVar;
            Rect rect;
            Rect rect2;
            int i6;
            AppMethodBeat.i(200503);
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
                    float f4 = (f2 / ((float) width)) / 3.0f;
                    com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = b.this.AaG;
                    if (cVar2 == null || (rect2 = cVar2.Aay) == null) {
                        rect2 = new Rect();
                    }
                    float width2 = ((float) rect2.width()) / ((float) width);
                    int width3 = rect2.left + (rect2.width() / 2);
                    int height2 = rect2.top + (rect2.height() / 2);
                    if (f4 > 1.0f) {
                        f4 = 1.0f;
                    } else if (f4 < 0.0f) {
                        f4 = 0.0f;
                    }
                    float f5 = 1.0f - (f4 * (1.0f - width2));
                    float f6 = f5 > 1.0f ? 1.0f : f5 < 0.0f ? 0.0f : f5;
                    float f7 = (1.0f - f6) / (1.0f - width2);
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
                    this.AaP = f7;
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
                        float f14 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * f7) / f6;
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
                            dVar13.setScaleX(f6);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar14 = b.this.AaH;
                        if (dVar14 != null) {
                            dVar14.setScaleY(f6);
                        }
                        com.tencent.mm.plugin.multitask.animation.c.a.d dVar15 = b.this.AaH;
                        if (dVar15 != null) {
                            dVar15.postInvalidate();
                            AppMethodBeat.o(200503);
                            return;
                        }
                        AppMethodBeat.o(200503);
                        return;
                    }
                    this.iGD = true;
                    if (!bx(f7)) {
                        MMHandlerThread.postToMainThread(new d(this));
                    }
                    AppMethodBeat.o(200503);
                    return;
                }
            }
            AppMethodBeat.o(200503);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.c.b.b$b$d */
        static final class d implements Runnable {
            final /* synthetic */ C1508b Aba;

            d(C1508b bVar) {
                this.Aba = bVar;
            }

            public final void run() {
                AppMethodBeat.i(200496);
                com.tencent.mm.plugin.multitask.c.c cVar = b.this.AaI;
                if (cVar != null) {
                    com.tencent.mm.plugin.multitask.animation.c.a.d dVar = b.this.AaH;
                    cVar.g(dVar != null ? dVar.getContentBitmap() : null, 3);
                    AppMethodBeat.o(200496);
                    return;
                }
                AppMethodBeat.o(200496);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$Companion;", "", "()V", "MAX_FLING_VELOCITY", "", "MIN_FLING_VELOCITY", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.multitask.animation.c.a.b
    public final void RG(int i2) {
        AppMethodBeat.i(200515);
        h(i2, true, true);
        AppMethodBeat.o(200515);
    }
}
