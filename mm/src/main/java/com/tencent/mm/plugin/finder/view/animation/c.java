package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;

public final class c {
    private static final int[] wrA = new int[2];
    public static final c wrB = new c();

    static {
        AppMethodBeat.i(168461);
        AppMethodBeat.o(168461);
    }

    private c() {
    }

    public static final /* synthetic */ void b(FinderCommentInfo finderCommentInfo, ImageView imageView) {
        AppMethodBeat.i(255177);
        a(finderCommentInfo, imageView);
        AppMethodBeat.o(255177);
    }

    public static void ei(View view) {
        AppMethodBeat.i(168459);
        p.h(view, "view");
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", 1.0f, 1.05f, 1.0f, 0.95f, 1.0f));
        ofPropertyValuesHolder.setDuration(500L).addUpdateListener(new b(view));
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(168459);
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View hCI;

        b(View view) {
            this.hCI = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(168455);
            Object animatedValue = valueAnimator.getAnimatedValue("scale");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(168455);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            Log.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(floatValue)));
            this.hCI.setScaleX(floatValue);
            this.hCI.setScaleY(floatValue);
            AppMethodBeat.o(168455);
        }
    }

    public static /* synthetic */ void a(View view, float f2, MotionEvent motionEvent, boolean z, int i2) {
        AppMethodBeat.i(255173);
        if ((i2 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            motionEvent = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        a(view, f2, motionEvent, z, 0.0f);
        AppMethodBeat.o(255173);
    }

    public static void a(View view, float f2, MotionEvent motionEvent, boolean z, float f3) {
        AppMethodBeat.i(255172);
        p.h(view, "view");
        if (view.getVisibility() == 0) {
            AppMethodBeat.o(255172);
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.post(new d(motionEvent, view, f3, f2, z));
        AppMethodBeat.o(255172);
    }

    public static final class d implements Runnable {
        final /* synthetic */ View hCI;
        final /* synthetic */ MotionEvent wrE;
        final /* synthetic */ float wrF;
        final /* synthetic */ float wrG;
        final /* synthetic */ boolean wrH;

        d(MotionEvent motionEvent, View view, float f2, float f3, boolean z) {
            this.wrE = motionEvent;
            this.hCI = view;
            this.wrF = f2;
            this.wrG = f3;
            this.wrH = z;
        }

        public final void run() {
            AppMethodBeat.i(255171);
            if (this.wrE != null) {
                this.hCI.setTranslationX(0.0f);
                this.hCI.setTranslationY(0.0f);
                View view = this.hCI;
                c cVar = c.wrB;
                view.getLocationInWindow(c.wrA);
                View view2 = this.hCI;
                float x = this.wrE.getX();
                c cVar2 = c.wrB;
                view2.setTranslationX((x - ((float) c.wrA[0])) - ((float) (this.hCI.getWidth() / 2)));
                View view3 = this.hCI;
                float y = this.wrE.getY();
                c cVar3 = c.wrB;
                view3.setTranslationY(((y - ((float) c.wrA[1])) - ((float) (this.hCI.getHeight() / 2))) + this.wrF);
            }
            this.hCI.setAlpha(1.0f);
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", this.wrG * 0.5f, this.wrG * 1.75f, this.wrG * 1.25f, this.wrG * 1.5f), PropertyValuesHolder.ofFloat("alpha", 0.7f, 0.5f, 0.8f, 1.0f));
            ofPropertyValuesHolder.setDuration(500L).addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                /* class com.tencent.mm.plugin.finder.view.animation.c.d.AnonymousClass1 */
                final /* synthetic */ d wrI;

                {
                    this.wrI = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(255167);
                    Object animatedValue = valueAnimator.getAnimatedValue("scale");
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                        AppMethodBeat.o(255167);
                        throw tVar;
                    }
                    float floatValue = ((Float) animatedValue).floatValue();
                    Object animatedValue2 = valueAnimator.getAnimatedValue("alpha");
                    if (animatedValue2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.Float");
                        AppMethodBeat.o(255167);
                        throw tVar2;
                    }
                    float floatValue2 = ((Float) animatedValue2).floatValue();
                    this.wrI.hCI.setScaleX(floatValue);
                    this.wrI.hCI.setScaleY(floatValue);
                    this.wrI.hCI.setAlpha(floatValue2);
                    AppMethodBeat.o(255167);
                }
            });
            ofPropertyValuesHolder.addListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.finder.view.animation.c.d.AnonymousClass2 */
                final /* synthetic */ d wrI;

                {
                    this.wrI = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                /* renamed from: com.tencent.mm.plugin.finder.view.animation.c$d$2$a */
                public static final class a implements Animator.AnimatorListener {
                    final /* synthetic */ AnonymousClass2 wrJ;

                    a(AnonymousClass2 r1) {
                        this.wrJ = r1;
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(255169);
                        this.wrJ.wrI.hCI.setScaleX(1.0f);
                        this.wrJ.wrI.hCI.setScaleY(1.0f);
                        this.wrJ.wrI.hCI.setAlpha(1.0f);
                        this.wrJ.wrI.hCI.setTranslationX(0.0f);
                        this.wrJ.wrI.hCI.setTranslationY(0.0f);
                        this.wrJ.wrI.hCI.setVisibility(8);
                        if (this.wrJ.wrI.wrH) {
                            this.wrJ.wrI.hCI.post(new RunnableC1333a(this));
                        }
                        AppMethodBeat.o(255169);
                    }

                    /* renamed from: com.tencent.mm.plugin.finder.view.animation.c$d$2$a$a */
                    static final class RunnableC1333a implements Runnable {
                        final /* synthetic */ a wrK;

                        RunnableC1333a(a aVar) {
                            this.wrK = aVar;
                        }

                        public final void run() {
                            AppMethodBeat.i(255168);
                            ViewParent parent = this.wrK.wrJ.wrI.hCI.getParent();
                            if (parent == null) {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                                AppMethodBeat.o(255168);
                                throw tVar;
                            }
                            ((ViewGroup) parent).removeView(this.wrK.wrJ.wrI.hCI);
                            AppMethodBeat.o(255168);
                        }
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                    }
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(255170);
                    this.wrI.hCI.animate().alpha(0.0f).setStartDelay(300).setListener(new a(this)).start();
                    AppMethodBeat.o(255170);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }
            });
            ofPropertyValuesHolder.start();
            AppMethodBeat.o(255171);
        }
    }

    public static void c(LinkedList<FinderCommentInfo> linkedList, List<View> list, View view, boolean z) {
        float fromDPToPix;
        View view2;
        Context context;
        Resources resources;
        AppMethodBeat.i(255174);
        p.h(linkedList, "likeList");
        p.h(list, "avatarLayoutList");
        p.h(view, "parent");
        int size = linkedList.size();
        if (size == 0) {
            AppMethodBeat.o(255174);
            return;
        }
        if (z) {
            View view3 = list.get(0);
            fromDPToPix = (view3 == null || (context = view3.getContext()) == null || (resources = context.getResources()) == null) ? 0.0f : resources.getDimension(R.dimen.cf);
        } else {
            View view4 = list.get(0);
            fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix(view4 != null ? view4.getContext() : null, 14);
        }
        if (size == 1 && (view2 = list.get(0)) != null) {
            view2.setVisibility(0);
        }
        if (size == 2 || size == 3) {
            if (size > list.size()) {
                AppMethodBeat.o(255174);
                return;
            }
            int i2 = size - 2;
            if (i2 >= 0) {
                int i3 = 0;
                while (true) {
                    View view5 = list.get(i3);
                    if (view5 != null) {
                        view5.setVisibility(0);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            View view6 = list.get(0);
            if (view6 != null) {
                view6.setVisibility(0);
            }
            if (view6 == null) {
                p.hyc();
            }
            a(view6, "alpha", 0.0f, 1.0f, (Animator.AnimatorListener) null);
            for (int i4 = 1; i4 < size; i4++) {
                View view7 = list.get(i4);
                if (view7 != null) {
                    a(view7, "translationX", -fromDPToPix, 0.0f, (Animator.AnimatorListener) null);
                }
            }
            View findViewById = view.findViewById(R.id.gtq);
            View findViewById2 = view.findViewById(R.id.gtn);
            if (findViewById != null) {
                a(findViewById, "translationX", -fromDPToPix, 0.0f, (Animator.AnimatorListener) null);
            }
            if (findViewById2 != null) {
                a(findViewById2, "translationX", -fromDPToPix, 0.0f, (Animator.AnimatorListener) null);
            }
        }
        if (size > 3) {
            z.f fVar = new z.f();
            fVar.SYG = (T) view.findViewById(R.id.daj);
            T t = fVar.SYG;
            p.g(t, "avatarExtra");
            t.setVisibility(0);
            FinderCommentInfo finderCommentInfo = linkedList.get(0);
            p.g(finderCommentInfo, "likeList[0]");
            View findViewById3 = fVar.SYG.findViewById(R.id.daf);
            p.g(findViewById3, "avatarExtra.findViewById(R.id.friend_avatar_extra)");
            a(finderCommentInfo, (ImageView) findViewById3);
            FinderCommentInfo finderCommentInfo2 = linkedList.get(1);
            p.g(finderCommentInfo2, "likeList[1]");
            FinderCommentInfo finderCommentInfo3 = finderCommentInfo2;
            View view8 = list.get(0);
            if (view8 == null) {
                p.hyc();
            }
            View findViewById4 = view8.findViewById(R.id.da_);
            p.g(findViewById4, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
            a(finderCommentInfo3, (ImageView) findViewById4);
            FinderCommentInfo finderCommentInfo4 = linkedList.get(2);
            p.g(finderCommentInfo4, "likeList[2]");
            FinderCommentInfo finderCommentInfo5 = finderCommentInfo4;
            View view9 = list.get(1);
            if (view9 == null) {
                p.hyc();
            }
            View findViewById5 = view9.findViewById(R.id.dab);
            p.g(findViewById5, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
            a(finderCommentInfo5, (ImageView) findViewById5);
            FinderCommentInfo finderCommentInfo6 = linkedList.get(3);
            p.g(finderCommentInfo6, "likeList[3]");
            FinderCommentInfo finderCommentInfo7 = finderCommentInfo6;
            View view10 = list.get(2);
            if (view10 == null) {
                p.hyc();
            }
            View findViewById6 = view10.findViewById(R.id.dad);
            p.g(findViewById6, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
            a(finderCommentInfo7, (ImageView) findViewById6);
            for (T t2 : list) {
                if (t2 != null) {
                    t2.setVisibility(0);
                }
            }
            for (int i5 = 0; i5 < 2; i5++) {
                View view11 = list.get(i5);
                if (view11 != null) {
                    a(view11, "translationX", 0.0f, fromDPToPix, (Animator.AnimatorListener) null);
                }
            }
            View view12 = list.get(2);
            if (view12 == null) {
                p.hyc();
            }
            a(view12, "alpha", 1.0f, 0.0f, (Animator.AnimatorListener) null);
            T t3 = fVar.SYG;
            p.g(t3, "avatarExtra");
            a(t3, "alpha", 0.0f, 1.0f, new C1332c(list, fVar, linkedList));
        }
        AppMethodBeat.o(255174);
    }

    /* renamed from: com.tencent.mm.plugin.finder.view.animation.c$c */
    public static final class C1332c implements Animator.AnimatorListener {
        final /* synthetic */ List tBi;
        final /* synthetic */ z.f wrC;
        final /* synthetic */ LinkedList wrD;

        C1332c(List list, z.f fVar, LinkedList linkedList) {
            this.tBi = list;
            this.wrC = fVar;
            this.wrD = linkedList;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255166);
            for (View view : this.tBi) {
                if (view != null) {
                    view.setTranslationX(0.0f);
                }
                if (view != null) {
                    view.setAlpha(1.0f);
                }
            }
            T t = this.wrC.SYG;
            p.g(t, "avatarExtra");
            t.setVisibility(8);
            T t2 = this.wrC.SYG;
            p.g(t2, "avatarExtra");
            t2.setTranslationX(0.0f);
            c cVar = c.wrB;
            Object obj = this.wrD.get(0);
            p.g(obj, "likeList[0]");
            FinderCommentInfo finderCommentInfo = (FinderCommentInfo) obj;
            Object obj2 = this.tBi.get(0);
            if (obj2 == null) {
                p.hyc();
            }
            View findViewById = ((View) obj2).findViewById(R.id.da_);
            p.g(findViewById, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
            c.b(finderCommentInfo, (ImageView) findViewById);
            c cVar2 = c.wrB;
            Object obj3 = this.wrD.get(1);
            p.g(obj3, "likeList[1]");
            FinderCommentInfo finderCommentInfo2 = (FinderCommentInfo) obj3;
            Object obj4 = this.tBi.get(1);
            if (obj4 == null) {
                p.hyc();
            }
            View findViewById2 = ((View) obj4).findViewById(R.id.dab);
            p.g(findViewById2, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
            c.b(finderCommentInfo2, (ImageView) findViewById2);
            c cVar3 = c.wrB;
            Object obj5 = this.wrD.get(2);
            p.g(obj5, "likeList[2]");
            FinderCommentInfo finderCommentInfo3 = (FinderCommentInfo) obj5;
            Object obj6 = this.tBi.get(2);
            if (obj6 == null) {
                p.hyc();
            }
            View findViewById3 = ((View) obj6).findViewById(R.id.dad);
            p.g(findViewById3, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
            c.b(finderCommentInfo3, (ImageView) findViewById3);
            AppMethodBeat.o(255166);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private static void a(View view, String str, float f2, float f3, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(255175);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f2, f3);
        p.g(ofFloat, "tranX");
        ofFloat.setDuration(500L);
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        } else {
            ofFloat.addListener(new a(view));
        }
        ofFloat.start();
        AppMethodBeat.o(255175);
    }

    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ View hCI;

        a(View view) {
            this.hCI = view;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255164);
            if (animator != null) {
                animator.cancel();
                AppMethodBeat.o(255164);
                return;
            }
            AppMethodBeat.o(255164);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255165);
            this.hCI.setVisibility(0);
            AppMethodBeat.o(255165);
        }
    }

    private static void a(FinderCommentInfo finderCommentInfo, ImageView imageView) {
        AppMethodBeat.i(255176);
        if (p.j(finderCommentInfo.username, com.tencent.mm.model.z.aTY())) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsq().value().intValue() == 1) {
                a.b.c(imageView, com.tencent.mm.model.z.aTY());
                AppMethodBeat.o(255176);
                return;
            }
            a.b.d(imageView, com.tencent.mm.model.z.aTY(), 0.0f);
            AppMethodBeat.o(255176);
            return;
        }
        m mVar = m.uJa;
        com.tencent.mm.loader.d<o> dkc = m.dkc();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(finderCommentInfo.headUrl);
        m mVar2 = m.uJa;
        dkc.a(aVar, imageView, m.a(m.a.RECT_AVATAR));
        AppMethodBeat.o(255176);
    }
}
