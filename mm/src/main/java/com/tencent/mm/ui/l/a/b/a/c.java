package com.tencent.mm.ui.l.a.b.a;

import android.util.Pair;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.aa;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.ui.l.a.g;
import java.util.List;
import org.json.JSONObject;

public final class c extends d<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "shakeVisibleBubblesAndAvatars";
    private static final float[] Qmk = {15.0f, 12.0f, 9.0f, 6.0f, 3.0f};
    private static final long[] Qml = {0, 50, 100, 150, 200};
    private Animation Qmm = null;
    private Animation Qmn = null;
    private final AnimationSet[] Qmo = new AnimationSet[5];
    private final AnimationSet[] Qmp = new AnimationSet[5];
    private final AnimationSet[] Qmq = new AnimationSet[5];
    private final AnimationSet[] Qmr = new AnimationSet[5];
    private final AnimationSet[] Qms = new AnimationSet[5];
    private final AnimationSet[] Qmt = new AnimationSet[5];
    private boolean Vme = false;

    public c() {
        AppMethodBeat.i(259050);
        AppMethodBeat.o(259050);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(g gVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(234441);
        final g gVar2 = gVar;
        Log.i("MicroMsg.JsApiShakeBubblesAndAvatars", "hy: request shake the bubble and avatar");
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.ui.l.a.b.a.c.AnonymousClass1 */

            public final void run() {
                View mainContainerView;
                AnimationSet animationSet;
                AppMethodBeat.i(234438);
                e eVar = gVar2.QlN;
                com.tencent.mm.ui.chatting.e.a gWG = eVar != null ? eVar.gWG() : null;
                if (gWG == null) {
                    Log.e("MicroMsg.JsApiShakeBubblesAndAvatars", "hy: chatting released!");
                    c.a(c.this, gVar2, i2, "chatting released");
                    AppMethodBeat.o(234438);
                    return;
                }
                if (!c.this.Vme) {
                    eVar.a(new e.a() {
                        /* class com.tencent.mm.ui.l.a.b.a.c.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.l.a.e.a
                        public final void onPause() {
                            AppMethodBeat.i(259047);
                            Log.i("MicroMsg.JsApiShakeBubblesAndAvatars", "hy: on component pause, trigger reset");
                            c.b(c.this);
                            AppMethodBeat.o(259047);
                        }

                        @Override // com.tencent.mm.ui.l.a.e.a
                        public final void onDestroy() {
                            AppMethodBeat.i(259048);
                            c.this.Vme = false;
                            AppMethodBeat.o(259048);
                        }
                    });
                    c.this.Vme = true;
                }
                if (c.this.Qmm == null || c.this.Qmn == null || c.this.Qmo[0] == null || c.this.Qmp[0] == null || c.this.Qmq[0] == null || c.this.Qmr[0] == null || c.this.Qms[0] == null || c.this.Qmt[0] == null) {
                    c.this.Qmm = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.cl);
                    c.this.Qmn = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.cm);
                    c.this.Qmm.setAnimationListener(new b((byte) 0));
                    c.this.Qmn.setAnimationListener(new b((byte) 0));
                    c.k(c.this);
                }
                List<Pair<Long, c.a>> a2 = com.tencent.mm.ui.l.b.a.a(gWG, true);
                if (a2 == null) {
                    Log.e("MicroMsg.JsApiShakeBubblesAndAvatars", "hy: no visible views");
                    c.a(c.this, gVar2, i2, "no visible views!");
                    AppMethodBeat.o(234438);
                    return;
                }
                boolean optBoolean = jSONObject.optBoolean("isFrom", false);
                for (Pair<Long, c.a> pair : a2) {
                    c.a aVar = (c.a) pair.second;
                    if (aVar instanceof aa.a) {
                        mainContainerView = ((aa.a) aVar).jxm;
                    } else {
                        mainContainerView = aVar.getMainContainerView();
                    }
                    ChattingAvatarImageView chattingAvatarImageView = aVar.avatarIV;
                    int size = (a2.size() - a2.indexOf(aVar)) - 1;
                    if (size >= c.Qmk.length) {
                        size = c.Qmk.length - 1;
                    }
                    if (c.this.Qmo[size] == null) {
                        c.k(c.this);
                    }
                    if (mainContainerView != null) {
                        if (aVar.chattingItem.gTT()) {
                            animationSet = optBoolean ? c.this.Qmq[size] : c.this.Qmt[size];
                        } else {
                            animationSet = optBoolean ? c.this.Qmp[size] : c.this.Qms[size];
                        }
                        mainContainerView.startAnimation(animationSet);
                    }
                    if (chattingAvatarImageView != null) {
                        chattingAvatarImageView.startAnimation(optBoolean ? c.this.Qmo[size] : c.this.Qmr[size]);
                    }
                }
                AppMethodBeat.o(234438);
            }
        });
        gVar2.i(i2, h("ok", null));
        AppMethodBeat.o(234441);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public float Qmw;
        public long buq;
        public long duration;

        public a(float f2, long j2, long j3) {
            this.Qmw = f2;
            this.duration = j2;
            this.buq = j3;
        }
    }

    private static void c(Animation animation) {
        AppMethodBeat.i(259051);
        if (animation != null) {
            animation.reset();
        }
        AppMethodBeat.o(259051);
    }

    private static void a(AnimationSet[] animationSetArr) {
        AppMethodBeat.i(259052);
        for (AnimationSet animationSet : animationSetArr) {
            List<Animation> animations = animationSet.getAnimations();
            if (animations != null) {
                for (Animation animation : animations) {
                    c(animation);
                }
            }
            c(animationSet);
        }
        AppMethodBeat.o(259052);
    }

    /* access modifiers changed from: package-private */
    public static class b implements Animation.AnimationListener {
        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(259049);
            animation.reset();
            AppMethodBeat.o(259049);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    private static AnimationSet a(a[] aVarArr, float f2) {
        AppMethodBeat.i(234439);
        AnimationSet animationSet = new AnimationSet(false);
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            a aVar = aVarArr[i2];
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, aVar.Qmw, 1, f2, 1, 0.0f);
            rotateAnimation.setDuration(aVar.duration);
            rotateAnimation.setStartOffset(aVar.buq);
            if (i2 == 0) {
                rotateAnimation.setInterpolator(new AccelerateInterpolator());
            } else if (i2 == aVarArr.length - 1) {
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
            } else {
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            animationSet.addAnimation(rotateAnimation);
        }
        AppMethodBeat.o(234439);
        return animationSet;
    }

    static /* synthetic */ void a(c cVar, f fVar, int i2, String str) {
        AppMethodBeat.i(259053);
        fVar.i(i2, cVar.h("fail: ".concat(String.valueOf(str)), null));
        AppMethodBeat.o(259053);
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(259054);
        c(cVar.Qmm);
        c(cVar.Qmn);
        a(cVar.Qmo);
        a(cVar.Qmp);
        a(cVar.Qmq);
        a(cVar.Qmr);
        a(cVar.Qms);
        a(cVar.Qmt);
        AppMethodBeat.o(259054);
    }

    static /* synthetic */ void k(c cVar) {
        AppMethodBeat.i(259055);
        Log.i("MicroMsg.JsApiShakeBubblesAndAvatars", "zbq: first time to create and load animation");
        for (int i2 = 0; i2 < 5; i2++) {
            float f2 = Qmk[i2];
            long j2 = Qml[i2];
            a[] aVarArr = {new a(f2, 50, j2), new a(-2.0f * f2, 100, 50 + j2), new a(2.0f * f2, 100, 150 + j2), new a(-2.0f * f2, 100, 250 + j2), new a(f2, 50, 350 + j2)};
            AnimationSet a2 = a(aVarArr, 0.0f);
            a2.addAnimation(cVar.Qmm);
            cVar.Qmp[i2] = a2;
            cVar.Qmp[i2].setAnimationListener(new b((byte) 0));
            AnimationSet a3 = a(aVarArr, 0.0f);
            a3.addAnimation(cVar.Qmn);
            cVar.Qms[i2] = a3;
            cVar.Qms[i2].setAnimationListener(new b((byte) 0));
            AnimationSet a4 = a(aVarArr, 1.0f);
            a4.addAnimation(cVar.Qmm);
            cVar.Qmq[i2] = a4;
            cVar.Qmq[i2].setAnimationListener(new b((byte) 0));
            AnimationSet a5 = a(aVarArr, 1.0f);
            a5.addAnimation(cVar.Qmn);
            cVar.Qmt[i2] = a5;
            cVar.Qmt[i2].setAnimationListener(new b((byte) 0));
            a[] aVarArr2 = {new a(f2, 34, j2), new a(-2.0f * f2, 67, 34 + j2), new a(2.0f * f2, 67, 101 + j2), new a(-2.0f * f2, 67, 168 + j2), new a(2.0f * f2, 67, 235 + j2), new a(-2.0f * f2, 67, 312 + j2), new a(f2, 34, 379 + j2)};
            AnimationSet a6 = a(aVarArr2, 0.5f);
            a6.addAnimation(cVar.Qmm);
            cVar.Qmo[i2] = a6;
            cVar.Qmo[i2].setAnimationListener(new b((byte) 0));
            AnimationSet a7 = a(aVarArr2, 0.5f);
            a7.addAnimation(cVar.Qmn);
            cVar.Qmr[i2] = a7;
            cVar.Qmr[i2].setAnimationListener(new b((byte) 0));
        }
        AppMethodBeat.o(259055);
    }
}
