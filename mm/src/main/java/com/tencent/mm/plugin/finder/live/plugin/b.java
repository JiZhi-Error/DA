package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.g;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b*\u0001B\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020EJ\n\u0010G\u001a\u0004\u0018\u00010;H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020;H\u0002J\u0006\u0010K\u001a\u00020EJ\u0016\u0010L\u001a\u00020E2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020;0NH\u0002J(\u0010O\u001a\u00020E2\u0006\u0010P\u001a\u00020I2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020;0R2\b\b\u0002\u0010S\u001a\u000204H\u0002J\u0010\u0010T\u001a\u00020E2\u0006\u0010U\u001a\u00020;H\u0016J\u0018\u0010V\u001a\u00020E2\u0006\u0010W\u001a\u00020I2\u0006\u0010U\u001a\u00020;H\u0002J\u0018\u0010X\u001a\u00020E2\u0006\u0010U\u001a\u00020;2\u0006\u0010Y\u001a\u000204H\u0016J\u0010\u0010Z\u001a\u00020E2\b\b\u0002\u0010Y\u001a\u000204J\u0014\u0010[\u001a\u00020E2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020;0NR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u00109\u001a\u0012\u0012\u0004\u0012\u00020;0:j\b\u0012\u0004\u0012\u00020;`<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001a\u00020BX\u0004¢\u0006\u0004\n\u0002\u0010C¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget;", "", "bullet", "Landroid/view/ViewGroup;", "commentList", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/view/ViewGroup;Landroid/support/v7/widget/RecyclerView;)V", "ANIMATION_DURATION", "", "getANIMATION_DURATION", "()I", "BULLET_COMMENT_MAX_LENGTH", "getBULLET_COMMENT_MAX_LENGTH", "BULLET_FLY_DISTANCE", "", "getBULLET_FLY_DISTANCE", "()F", "D_0_5_A", "getD_0_5_A", "D_1_5_A", "getD_1_5_A", "STAY_DURATION", "getSTAY_DURATION", "UPDATE_DURATION", "getUPDATE_DURATION", "bulletContentTv", "Landroid/widget/TextView;", "getBulletContentTv", "()Landroid/widget/TextView;", "setBulletContentTv", "(Landroid/widget/TextView;)V", "bulletInAnim", "Landroid/animation/ObjectAnimator;", "getBulletInAnim", "()Landroid/animation/ObjectAnimator;", "setBulletInAnim", "(Landroid/animation/ObjectAnimator;)V", "bulletOutAnim", "getBulletOutAnim", "setBulletOutAnim", "bulletUpdateAnim", "Landroid/view/ViewPropertyAnimator;", "getBulletUpdateAnim", "()Landroid/view/ViewPropertyAnimator;", "setBulletUpdateAnim", "(Landroid/view/ViewPropertyAnimator;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "haveNextBullet", "", "getHaveNextBullet", "()Z", "setHaveNextBullet", "(Z)V", "localBullet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getLocalBullet", "()Ljava/util/ArrayList;", "setLocalBullet", "(Ljava/util/ArrayList;)V", "sysSpan", "com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1;", "adjustMargin", "", "clearLocalBullet", "getNextBulletComment", "getPrintMsg", "", "item", "hideBulletComment", "mergeBulletComment", "remote", "", "printMsgList", "prefix", "msgList", "", "debugPrint", "setBulletComment", "liveMsg", "setContent", "msg", "showBulletComment", "pushAnim", "showNextBullet", "updateBulletComment", "bulletCommentList", "plugin-finder_release"})
public final class b {
    private final int ANIMATION_DURATION = 500;
    private final int ulA = 2000;
    private final float ulB = -500.0f;
    private final int ulC = 1000;
    final int ulD;
    private final int ulE;
    private final int ulF;
    ViewGroup ulG;
    TextView ulH;
    ObjectAnimator ulI;
    ObjectAnimator ulJ;
    ViewPropertyAnimator ulK;
    ArrayList<awq> ulL;
    boolean ulM;
    private final C1190b ulN;
    final ViewGroup ulO;
    final RecyclerView ulP;

    public b(ViewGroup viewGroup, RecyclerView recyclerView) {
        p.h(viewGroup, "bullet");
        p.h(recyclerView, "commentList");
        AppMethodBeat.i(246381);
        this.ulO = viewGroup;
        this.ulP = recyclerView;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.ulD = com.tencent.mm.plugin.finder.storage.c.dvd();
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        this.ulE = context.getResources().getDimensionPixelSize(R.dimen.bt);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        this.ulF = context2.getResources().getDimensionPixelSize(R.dimen.c5);
        this.ulG = this.ulO;
        View findViewById = this.ulG.findViewById(R.id.afi);
        p.g(findViewById, "container.findViewById(R…_comment_item_content_tv)");
        this.ulH = (TextView) findViewById;
        this.ulL = new ArrayList<>();
        this.ulN = new C1190b();
        this.ulG.setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ulG, "alpha", 1.0f, 0.0f);
        p.g(ofFloat, "ObjectAnimator.ofFloat(container, \"alpha\", 1f, 0f)");
        this.ulJ = ofFloat;
        this.ulJ.setDuration((long) this.ANIMATION_DURATION);
        this.ulJ.addListener(new Animator.AnimatorListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.b.AnonymousClass1 */
            final /* synthetic */ b ulQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ulQ = r1;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(246368);
                Object target = this.ulQ.ulJ.getTarget();
                if (target == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(246368);
                    throw tVar;
                }
                ((View) target).setVisibility(8);
                AppMethodBeat.o(246368);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ulG, "translationX", this.ulB, 0.0f);
        p.g(ofFloat2, "ObjectAnimator.ofFloat(c… BULLET_FLY_DISTANCE, 0f)");
        this.ulI = ofFloat2;
        this.ulI.setDuration((long) (this.ANIMATION_DURATION + this.ulA));
        this.ulI.setInterpolator(new DecelerateInterpolator());
        this.ulI.setEvaluator(new c(this.ANIMATION_DURATION, this.ulA));
        this.ulI.addListener(new Animator.AnimatorListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.b.AnonymousClass2 */
            final /* synthetic */ b ulQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ulQ = r1;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(246369);
                if (!this.ulQ.ulM) {
                    this.ulQ.ulJ.start();
                    AppMethodBeat.o(246369);
                    return;
                }
                this.ulQ.np(false);
                AppMethodBeat.o(246369);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(246370);
                Object target = this.ulQ.ulI.getTarget();
                if (target == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(246370);
                    throw tVar;
                }
                View view = (View) target;
                view.setAlpha(1.0f);
                view.setVisibility(0);
                AppMethodBeat.o(246370);
            }
        });
        ViewPropertyAnimator listener = this.ulG.animate().setDuration((long) this.ulC).setListener(new AnimatorListenerAdapter(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.b.AnonymousClass3 */
            final /* synthetic */ b ulQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ulQ = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(246371);
                if (!this.ulQ.ulM) {
                    this.ulQ.ulJ.start();
                    AppMethodBeat.o(246371);
                    return;
                }
                this.ulQ.np(false);
                AppMethodBeat.o(246371);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(246372);
                this.ulQ.ulG.setAlpha(1.0f);
                this.ulQ.ulG.setVisibility(0);
                AppMethodBeat.o(246372);
            }
        });
        p.g(listener, "container.animate().setD…            }\n\n        })");
        this.ulK = listener;
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        if (b.a.aDp()) {
            this.ulH.setTextSize(1, 15.0f);
            AppMethodBeat.o(246381);
            return;
        }
        this.ulH.setTextSize(1, 17.0f);
        AppMethodBeat.o(246381);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.plugin.b$b  reason: collision with other inner class name */
    public static final class C1190b extends CharacterStyle {
        C1190b() {
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(246374);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.ua);
            if (textPaint != null) {
                textPaint.setColor(color);
            }
            if (textPaint != null) {
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(246374);
                return;
            }
            AppMethodBeat.o(246374);
        }
    }

    public final void dgJ() {
        AppMethodBeat.i(246376);
        this.ulG.setVisibility(8);
        this.ulI.cancel();
        this.ulJ.cancel();
        this.ulK.cancel();
        AppMethodBeat.o(246376);
    }

    public final void dZ(List<awq> list) {
        AppMethodBeat.i(246377);
        p.h(list, "bulletCommentList");
        d.h(new c(this, list));
        AppMethodBeat.o(246377);
    }

    public final void np(boolean z) {
        AppMethodBeat.i(246378);
        d.h(new a(this, z));
        AppMethodBeat.o(246378);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, awq awq) {
        int i2;
        m mVar;
        String str2;
        AppMethodBeat.i(246379);
        avn avn = awq.LHp;
        avi avi = avn != null ? avn.LDK : null;
        if (avi != null) {
            i2 = avi.LFX;
        } else {
            i2 = 0;
        }
        Log.i("Finder.LiveCommentPlugin", "attachBadgeInfo badgeLevel:".concat(String.valueOf(i2)));
        if (i2 == 1) {
            String string = this.ulG.getContext().getString(R.string.cxk, Integer.valueOf(i2));
            p.g(string, "container.context.getStr…_badge_level, badgeLevel)");
            m mVar2 = new m(com.tencent.mm.pluginsdk.ui.span.l.c(this.ulG.getContext(), string + str));
            com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
            g bd = com.tencent.mm.plugin.finder.utils.m.bd(i2, string);
            bd.ag(string, string, String.valueOf(i2));
            if (avi != null) {
                str2 = avi.LFY;
            } else {
                str2 = null;
            }
            bd.atC(str2);
            mVar2.a(bd, string, 0);
            ViewParent parent = this.ulH.getParent();
            if (!(parent instanceof RelativeLayout)) {
                parent = null;
            }
            RelativeLayout relativeLayout = (RelativeLayout) parent;
            if (relativeLayout != null) {
                relativeLayout.setPadding(this.ulE, relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
                mVar = mVar2;
            } else {
                mVar = mVar2;
            }
        } else {
            m mVar4 = new m(com.tencent.mm.pluginsdk.ui.span.l.c(this.ulG.getContext(), str));
            ViewParent parent2 = this.ulH.getParent();
            if (!(parent2 instanceof RelativeLayout)) {
                parent2 = null;
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) parent2;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(this.ulF, relativeLayout2.getPaddingTop(), relativeLayout2.getPaddingRight(), relativeLayout2.getPaddingBottom());
                mVar = mVar4;
            } else {
                mVar = mVar4;
            }
        }
        this.ulH.setText(mVar);
        AppMethodBeat.o(246379);
    }

    static void b(String str, List<? extends awq> list, boolean z) {
        AppMethodBeat.i(246380);
        if (list.isEmpty()) {
            AppMethodBeat.o(246380);
            return;
        }
        if (z) {
            y yVar = y.vXH;
            if (!y.dCM()) {
                AppMethodBeat.o(246380);
                return;
            }
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Log.i("Finder.LiveCommentPlugin", str + " msg:" + com.tencent.mm.ac.g.bN(list.get(i2)));
        }
        AppMethodBeat.o(246380);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ulQ;
        final /* synthetic */ List ulS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, List list) {
            super(0);
            this.ulQ = bVar;
            this.ulS = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246375);
            b bVar = this.ulQ;
            List list = this.ulS;
            Log.i("Finder.LiveCommentPlugin", "before merge local size:" + bVar.ulL.size() + ",remote size:" + list.size() + ",max length:" + bVar.ulD);
            b.b("before", bVar.ulL, true);
            if (list.size() > 0) {
                if (list.size() <= bVar.ulD - bVar.ulL.size()) {
                    bVar.ulL.addAll(list);
                } else if (list.size() >= bVar.ulD) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : bVar.ulL) {
                        if (!p.j(t.username, z.aTY())) {
                            arrayList.add(t);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    bVar.ulL.removeAll(arrayList2);
                    bVar.ulL.addAll(list);
                    b.b("drop", arrayList2, false);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t2 : bVar.ulL) {
                        if (p.j(t2.username, z.aTY())) {
                            arrayList3.add(t2);
                        }
                    }
                    ArrayList arrayList4 = arrayList3;
                    bVar.ulL.removeAll(arrayList4);
                    int size = (bVar.ulD - list.size()) - arrayList4.size();
                    if (size <= 0) {
                        bVar.ulL = new ArrayList<>();
                    } else {
                        while (bVar.ulL.size() > size) {
                            awq remove = bVar.ulL.remove(0);
                            p.g(remove, "localBullet.removeAt(0)");
                            awq awq = remove;
                            Log.i("Finder.LiveCommentPlugin", "drop msg:" + (awq.nickname + ':' + awq.content));
                        }
                    }
                    bVar.ulL.addAll(arrayList4);
                    bVar.ulL.addAll(list);
                }
                Log.i("Finder.LiveCommentPlugin", "after merge local size:" + bVar.ulL.size() + ",remote size:" + list.size());
                b.b("after", bVar.ulL, true);
            }
            if (this.ulQ.ulO.getVisibility() != 0) {
                this.ulQ.np(true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246375);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ulQ;
        final /* synthetic */ boolean ulR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, boolean z) {
            super(0);
            this.ulQ = bVar;
            this.ulR = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            awq awq;
            FinderContact finderContact;
            String str;
            boolean z;
            FinderContact finderContact2;
            String str2;
            int i2;
            AppMethodBeat.i(246373);
            b bVar = this.ulQ;
            if (bVar.ulL.size() > 0) {
                awq remove = bVar.ulL.remove(0);
                bVar.ulM = bVar.ulL.size() > 0;
                awq = remove;
            } else {
                awq = null;
            }
            Log.i("Finder.LiveCommentPlugin", "[getNextBulletComment] size:" + bVar.ulL.size() + ", haveNextBullet:" + bVar.ulM);
            if (awq != null) {
                b bVar2 = this.ulQ;
                boolean z2 = this.ulR;
                p.h(awq, "liveMsg");
                Log.i("Finder.LiveCommentPlugin", "show bullet comment:" + awq.content);
                bVar2.dgJ();
                RecyclerView.a adapter = bVar2.ulP.getAdapter();
                if (adapter != null) {
                    p.g(adapter, LocaleUtil.ITALIAN);
                    if (adapter.getItemCount() > 0) {
                        v.a aVar = v.uoz;
                        i2 = (int) v.uot;
                    } else {
                        i2 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = bVar2.ulO.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246373);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
                }
                p.h(awq, "liveMsg");
                int i3 = awq.type;
                o.c cVar = o.c.hGH;
                if (i3 == o.c.aFp()) {
                    String str3 = awq.username;
                    if ((str3 == null || str3.length() == 0) || p.j(awq.username, z.aTY())) {
                        z = false;
                    } else {
                        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                        String str4 = awq.username;
                        if (str4 == null) {
                            str4 = "";
                        }
                        z = com.tencent.mm.plugin.finder.utils.m.isFriend(str4);
                    }
                    Log.i("Finder.LiveCommentPlugin", "setBulletComment " + awq.nickname + " is friend:" + z);
                    com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    TextView textView = bVar2.ulH;
                    avn avn = awq.LHp;
                    String string = bVar2.ulG.getContext().getString(R.string.cxp, com.tencent.mm.plugin.finder.convert.d.e(textView, new SpannableString((avn == null || (finderContact2 = avn.contact) == null || (str2 = finderContact2.nickname) == null) ? "" : str2)));
                    p.g(string, "container.context.getString(resId,showName)");
                    bVar2.a(string, awq);
                } else {
                    o.c cVar2 = o.c.hGH;
                    if (i3 == o.c.aFv()) {
                        com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                        TextView textView2 = bVar2.ulH;
                        avn avn2 = awq.LHp;
                        String string2 = bVar2.ulG.getContext().getString(R.string.d07, com.tencent.mm.plugin.finder.convert.d.e(textView2, new SpannableString((avn2 == null || (finderContact = avn2.contact) == null || (str = finderContact.nickname) == null) ? "" : str)));
                        p.g(string2, "container.context.getStr…or_shopping, privateName)");
                        bVar2.a(string2, awq);
                    }
                }
                if (z2) {
                    bVar2.ulI.start();
                } else {
                    bVar2.ulK.start();
                }
            } else {
                this.ulQ.ulJ.start();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246373);
            return xVar;
        }
    }
}
