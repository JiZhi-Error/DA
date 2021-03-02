package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.animation.b.c;
import com.tencent.mm.plugin.multitask.c.c;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J>\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J<\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper;", "", "()V", "TAG", "", "doMaskAnimation", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "ballPos", "Landroid/graphics/Point;", "snapBlt", "Landroid/graphics/Bitmap;", "isManual", "", "lastSwipePosX", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "doTransform", "startTransform", "plugin-multitask_release"})
public final class a {
    public static final a zZV = new a();

    static {
        AppMethodBeat.i(200399);
        AppMethodBeat.o(200399);
    }

    private a() {
    }

    public static void a(com.tencent.mm.plugin.multitask.a.a aVar, Point point, Bitmap bitmap, boolean z, float f2, com.tencent.mm.plugin.multitask.c.c cVar) {
        AppMethodBeat.i(200398);
        PlaySound.play(MMApplicationContext.getContext(), R.string.j06);
        if (aVar.bCI()) {
            aVar.a(new b(cVar, point, aVar, bitmap, z, f2));
            AppMethodBeat.o(200398);
            return;
        }
        MMHandlerThread.postToMainThread(new c(cVar));
        AppMethodBeat.o(200398);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
    public static final class b implements a.b {
        final /* synthetic */ Point Aaa;
        final /* synthetic */ com.tencent.mm.plugin.multitask.a.a Aab;
        final /* synthetic */ Bitmap Aac;
        final /* synthetic */ float Aad;
        final /* synthetic */ boolean vcf;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        b(com.tencent.mm.plugin.multitask.c.c cVar, Point point, com.tencent.mm.plugin.multitask.a.a aVar, Bitmap bitmap, boolean z, float f2) {
            this.zZX = cVar;
            this.Aaa = point;
            this.Aab = aVar;
            this.Aac = bitmap;
            this.vcf = z;
            this.Aad = f2;
        }

        @Override // com.tencent.mm.plugin.multitask.a.a.b
        public final void ei(boolean z) {
            AppMethodBeat.i(200396);
            if (!z) {
                Log.i("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
                MMHandlerThread.postToMainThread(new RunnableC1503a(this));
                AppMethodBeat.o(200396);
                return;
            }
            MMHandlerThread.postToMainThread(new RunnableC1504b(this));
            AppMethodBeat.o(200396);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.b.a$b$a  reason: collision with other inner class name */
        static final class RunnableC1503a implements Runnable {
            final /* synthetic */ b Aae;

            RunnableC1503a(b bVar) {
                this.Aae = bVar;
            }

            public final void run() {
                AppMethodBeat.i(200394);
                com.tencent.mm.plugin.multitask.c.c cVar = this.Aae.zZX;
                if (cVar != null) {
                    cVar.RL(0);
                    AppMethodBeat.o(200394);
                    return;
                }
                AppMethodBeat.o(200394);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.b.a$b$b  reason: collision with other inner class name */
        static final class RunnableC1504b implements Runnable {
            final /* synthetic */ b Aae;

            RunnableC1504b(b bVar) {
                this.Aae = bVar;
            }

            public final void run() {
                AppMethodBeat.i(200395);
                if (this.Aae.Aaa != null) {
                    a aVar = a.zZV;
                    a.b(this.Aae.Aab, this.Aae.Aaa, this.Aae.Aac, this.Aae.vcf, this.Aae.Aad, this.Aae.zZX);
                    AppMethodBeat.o(200395);
                    return;
                }
                com.tencent.mm.plugin.multitask.c.c cVar = this.Aae.zZX;
                if (cVar != null) {
                    cVar.RL(0);
                    AppMethodBeat.o(200395);
                    return;
                }
                AppMethodBeat.o(200395);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        c(com.tencent.mm.plugin.multitask.c.c cVar) {
            this.zZX = cVar;
        }

        public final void run() {
            AppMethodBeat.i(200397);
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                cVar.RL(0);
                AppMethodBeat.o(200397);
                return;
            }
            AppMethodBeat.o(200397);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doMaskAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.b.a$a  reason: collision with other inner class name */
    public static final class C1501a extends AnimatorListenerAdapter {
        final /* synthetic */ c zZW;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;
        final /* synthetic */ Bitmap zZY;

        C1501a(c cVar, com.tencent.mm.plugin.multitask.c.c cVar2, Bitmap bitmap) {
            this.zZW = cVar;
            this.zZX = cVar2;
            this.zZY = bitmap;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitask.animation.b.a$a$a  reason: collision with other inner class name */
        static final class RunnableC1502a implements Runnable {
            final /* synthetic */ C1501a zZZ;

            RunnableC1502a(C1501a aVar) {
                this.zZZ = aVar;
            }

            public final void run() {
                AppMethodBeat.i(200391);
                if (this.zZZ.zZW.getParent() != null) {
                    ViewParent parent = this.zZZ.zZW.getParent();
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(200391);
                        throw tVar;
                    }
                    ((ViewGroup) parent).removeView(this.zZZ.zZW);
                }
                AppMethodBeat.o(200391);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(200392);
            p.h(animator, "animation");
            MMHandlerThread.postToMainThread(new RunnableC1502a(this));
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                c.a.a(cVar, this.zZY);
                AppMethodBeat.o(200392);
                return;
            }
            AppMethodBeat.o(200392);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(200393);
            p.h(animator, "animation");
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                c.a.a(cVar, this.zZY, false, 6);
                AppMethodBeat.o(200393);
                return;
            }
            AppMethodBeat.o(200393);
        }
    }

    public static final /* synthetic */ void b(com.tencent.mm.plugin.multitask.a.a aVar, Point point, Bitmap bitmap, boolean z, float f2, com.tencent.mm.plugin.multitask.c.c cVar) {
        AppMethodBeat.i(200400);
        Log.i("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doMaskAnimation, ballPos(x:%d, y:%d), lastSwipePosX:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f2));
        if (aVar.getMaskView() == null) {
            Log.w("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doMaskAnimation, page mask view is null");
            if (cVar != null) {
                cVar.RL(0);
                AppMethodBeat.o(200400);
                return;
            }
            AppMethodBeat.o(200400);
        } else if (aVar.getContentView() == null) {
            Log.w("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doMaskAnimation, page content view is null");
            if (cVar != null) {
                cVar.RL(0);
                AppMethodBeat.o(200400);
                return;
            }
            AppMethodBeat.o(200400);
        } else if (aVar.chG() == null) {
            Log.w("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doMaskAnimation, page root view is null");
            if (cVar != null) {
                cVar.RL(0);
                AppMethodBeat.o(200400);
                return;
            }
            AppMethodBeat.o(200400);
        } else {
            Bitmap bitmap2 = aVar.getBitmap();
            if (bitmap2 == null || bitmap2.isRecycled() || bitmap2.getWidth() == 0 || bitmap2.getHeight() == 0) {
                Log.w("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doMaskAnimation, page get bitmap is null");
                if (cVar != null) {
                    cVar.RL(0);
                    AppMethodBeat.o(200400);
                    return;
                }
                AppMethodBeat.o(200400);
                return;
            }
            if (z) {
                bitmap = bitmap2;
            }
            c cVar2 = new c(aVar.getActivity(), bitmap2);
            cVar2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            int i2 = point.x;
            int i3 = point.y;
            cVar2.pcW = i2;
            cVar2.pcX = i3;
            cVar2.pcV = f.oYK / 2;
            cVar2.setContentStartPosX((int) f2);
            cVar2.setListener(new C1501a(cVar2, cVar, bitmap));
            ViewGroup chG = aVar.chG();
            if (chG != null) {
                chG.addView(cVar2, chG.getChildCount());
            }
            View contentView = aVar.getContentView();
            if (contentView != null) {
                contentView.setVisibility(8);
            }
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            cVar2.pcZ = cVar2.pcY > 0;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("canvasTranslationX", cVar2.pcY < cVar2.pcW ? cVar2.pcY : cVar2.pcW, -cVar2.pcY);
            int i4 = cVar2.pcW;
            if (cVar2.pcZ) {
                i4 = cVar2.pcY < cVar2.pcW ? cVar2.pcW - cVar2.pcY : cVar2.pcY;
            }
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("translationX", i4, i4), PropertyValuesHolder.ofInt("translationY", 0, cVar2.pcX), PropertyValuesHolder.ofFloat("scaleX", 1.0f, (2.0f * ((float) cVar2.pcV)) / ((float) cVar2.mWidth)), PropertyValuesHolder.ofFloat("scaleY", 1.0f, (2.0f * ((float) cVar2.pcV)) / ((float) cVar2.mHeight)), ofInt, PropertyValuesHolder.ofInt("bgAlpha", 255, 0));
            p.g(ofPropertyValuesHolder, "transformAnimator");
            ofPropertyValuesHolder.setDuration(250L);
            ofPropertyValuesHolder.setInterpolator(linearInterpolator);
            ofPropertyValuesHolder.addUpdateListener(new c.b(cVar2));
            ofPropertyValuesHolder.addListener(new c.C1506c(cVar2));
            ofPropertyValuesHolder.start();
            AppMethodBeat.o(200400);
        }
    }
}
