package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r`\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "alphaAnimators", "Ljava/util/HashMap;", "", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashMap;", "isRunningAnimation", "", "pendingAnimationType", "addAnimation", "", "view", "Landroid/view/View;", "show", "cancelAnimation", "doAlphaAnimation", "finishAnimation", "getViewIdName", "hideAnimation", "release", "releaseAllAnimators", "releaseViewAnimator", "runNextAnimation", "showAnimation", "Type", "app_release"})
public final class m {
    private static HashMap<Integer, Integer> PCV = new HashMap<>();
    private static HashMap<Integer, Boolean> PCW = new HashMap<>();
    private static HashMap<Integer, ValueAnimator> PCX = new HashMap<>();
    public static final m PCY = new m();

    static {
        AppMethodBeat.i(231304);
        AppMethodBeat.o(231304);
    }

    private m() {
    }

    public static final void gE(View view) {
        AppMethodBeat.i(231296);
        p.h(view, "view");
        D(view, true);
        AppMethodBeat.o(231296);
    }

    public static final void gF(View view) {
        AppMethodBeat.i(231297);
        p.h(view, "view");
        D(view, false);
        AppMethodBeat.o(231297);
    }

    public static final void gG(View view) {
        AppMethodBeat.i(231299);
        Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo cancelAnimation view: %s", view);
        if (view != null) {
            PCV.remove(Integer.valueOf(view.hashCode()));
            ValueAnimator valueAnimator = PCX.get(Integer.valueOf(view.hashCode()));
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            gH(view);
            AppMethodBeat.o(231299);
            return;
        }
        AppMethodBeat.o(231299);
    }

    private static void D(View view, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(231300);
        Boolean bool = PCW.get(Integer.valueOf(view.hashCode()));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        p.g(bool, "isRunningAnimation[view.hashCode()] ?: false");
        boolean booleanValue = bool.booleanValue();
        Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo addAnimation view: %s, isRunning: %b, show: %b", view, Boolean.valueOf(booleanValue), Boolean.valueOf(z));
        if (!booleanValue) {
            E(view, z);
            AppMethodBeat.o(231300);
            return;
        }
        HashMap<Integer, Integer> hashMap = PCV;
        Integer valueOf = Integer.valueOf(view.hashCode());
        if (!z) {
            i2 = 0;
        }
        hashMap.put(valueOf, Integer.valueOf(i2));
        AppMethodBeat.o(231300);
    }

    private static void E(View view, boolean z) {
        ValueAnimator valueAnimator;
        float f2 = 1.0f;
        AppMethodBeat.i(231301);
        PCW.put(Integer.valueOf(view.hashCode()), Boolean.TRUE);
        float f3 = z ? 0.0f : 1.0f;
        if (!z) {
            f2 = 0.0f;
        }
        ValueAnimator valueAnimator2 = PCX.get(Integer.valueOf(view.hashCode()));
        if (valueAnimator2 == null) {
            valueAnimator = new ValueAnimator();
            PCX.put(Integer.valueOf(view.hashCode()), valueAnimator);
        } else {
            valueAnimator = valueAnimator2;
        }
        Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation show: %b, view: %s", Boolean.valueOf(z), getViewIdName(view));
        valueAnimator.removeAllListeners();
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.setFloatValues(f3, f2);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(150L);
        valueAnimator.addUpdateListener(new a(f3, f2, view, z));
        valueAnimator.addListener(new b(f3, f2, view, z));
        valueAnimator.start();
        AppMethodBeat.o(231301);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$1"})
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float PCZ;
        final /* synthetic */ float PDa;
        final /* synthetic */ boolean PDb;
        final /* synthetic */ View tBN;

        a(float f2, float f3, View view, boolean z) {
            this.PCZ = f2;
            this.PDa = f3;
            this.tBN = view;
            this.PDb = z;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(231292);
            View view = this.tBN;
            p.g(valueAnimator, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(231292);
                throw tVar;
            }
            view.setAlpha(((Float) animatedValue).floatValue());
            AppMethodBeat.o(231292);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "app_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ float PCZ;
        final /* synthetic */ float PDa;
        final /* synthetic */ boolean PDb;
        private boolean isCancelled;
        final /* synthetic */ View tBN;

        b(float f2, float f3, View view, boolean z) {
            this.PCZ = f2;
            this.PDa = f3;
            this.tBN = view;
            this.PDb = z;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(231293);
            super.onAnimationEnd(animator);
            this.tBN.setVisibility((!this.PDb || this.isCancelled) ? 8 : 0);
            this.tBN.setAlpha(1.0f);
            Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation end, show: %b, cancelled: %b, view: %s", Boolean.valueOf(this.PDb), Boolean.valueOf(this.isCancelled), this.tBN);
            m mVar = m.PCY;
            m.gI(this.tBN);
            m mVar2 = m.PCY;
            m.gJ(this.tBN);
            AppMethodBeat.o(231293);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(231294);
            super.onAnimationStart(animator);
            Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation start, show: %b, view: %s", Boolean.valueOf(this.PDb), this.tBN);
            AppMethodBeat.o(231294);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(231295);
            super.onAnimationCancel(animator);
            this.isCancelled = true;
            this.tBN.setVisibility(8);
            this.tBN.setAlpha(1.0f);
            Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation cancel, show: %b, view: %s", Boolean.valueOf(this.PDb), this.tBN);
            m mVar = m.PCY;
            m.gI(this.tBN);
            AppMethodBeat.o(231295);
        }
    }

    private static void gH(View view) {
        AppMethodBeat.i(231302);
        ValueAnimator valueAnimator = PCX.get(Integer.valueOf(view.hashCode()));
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            AppMethodBeat.o(231302);
            return;
        }
        AppMethodBeat.o(231302);
    }

    private static String getViewIdName(View view) {
        AppMethodBeat.i(231303);
        String resourceEntryName = view.getResources().getResourceEntryName(view.getId());
        if (resourceEntryName == null) {
            resourceEntryName = "";
        }
        AppMethodBeat.o(231303);
        return resourceEntryName;
    }

    public static final void release() {
        AppMethodBeat.i(231298);
        for (Map.Entry<Integer, ValueAnimator> entry : PCX.entrySet()) {
            ValueAnimator value = entry.getValue();
            value.removeAllUpdateListeners();
            value.removeAllListeners();
        }
        PCX.clear();
        PCV.clear();
        PCW.clear();
        AppMethodBeat.o(231298);
    }

    public static final /* synthetic */ void gI(View view) {
        AppMethodBeat.i(231305);
        PCW.remove(Integer.valueOf(view.hashCode()));
        AppMethodBeat.o(231305);
    }

    public static final /* synthetic */ void gJ(View view) {
        boolean z = true;
        AppMethodBeat.i(231306);
        Integer remove = PCV.remove(Integer.valueOf(view.hashCode()));
        if (remove == null) {
            gH(view);
            AppMethodBeat.o(231306);
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(remove.intValue() == 1);
        Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo runNextAnimation show: %b", objArr);
        if (remove.intValue() != 1) {
            z = false;
        }
        if (z) {
            view.setVisibility(0);
        }
        E(view, z);
        AppMethodBeat.o(231306);
    }
}
