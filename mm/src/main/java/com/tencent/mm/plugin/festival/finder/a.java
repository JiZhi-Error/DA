package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.g;
import com.tencent.mm.live.b.o;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.finder.t;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t*\u0001>\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010@\u001a\u00020AH\u0016J\u0006\u0010B\u001a\u00020AJ\n\u0010C\u001a\u0004\u0018\u000107H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u000207H\u0002J\u0006\u0010G\u001a\u00020AJ\u0016\u0010H\u001a\u00020A2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002070JH\u0002J(\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020E2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002070N2\b\b\u0002\u0010O\u001a\u000200H\u0002J\u0010\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u000207H\u0016J\u0018\u0010R\u001a\u00020A2\u0006\u0010Q\u001a\u0002072\u0006\u0010S\u001a\u000200H\u0016J\u0010\u0010T\u001a\u00020A2\b\b\u0002\u0010S\u001a\u000200J\u0014\u0010U\u001a\u00020A2\f\u0010V\u001a\b\u0012\u0004\u0012\u0002070JR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`8X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u00020>X\u0004¢\u0006\u0004\n\u0002\u0010?¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/BulletCommentWidget;", "", "bullet", "Landroid/view/ViewGroup;", "commentList", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/view/ViewGroup;Landroid/support/v7/widget/RecyclerView;)V", "ANIMATION_DURATION", "", "getANIMATION_DURATION", "()I", "BULLET_COMMENT_MAX_LENGTH", "getBULLET_COMMENT_MAX_LENGTH", "BULLET_FLY_DISTANCE", "", "getBULLET_FLY_DISTANCE", "()F", "STAY_DURATION", "getSTAY_DURATION", "UPDATE_DURATION", "getUPDATE_DURATION", "bulletContentTv", "Landroid/widget/TextView;", "getBulletContentTv", "()Landroid/widget/TextView;", "setBulletContentTv", "(Landroid/widget/TextView;)V", "bulletInAnim", "Landroid/animation/ObjectAnimator;", "getBulletInAnim", "()Landroid/animation/ObjectAnimator;", "setBulletInAnim", "(Landroid/animation/ObjectAnimator;)V", "bulletOutAnim", "getBulletOutAnim", "setBulletOutAnim", "bulletUpdateAnim", "Landroid/view/ViewPropertyAnimator;", "getBulletUpdateAnim", "()Landroid/view/ViewPropertyAnimator;", "setBulletUpdateAnim", "(Landroid/view/ViewPropertyAnimator;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "haveNextBullet", "", "getHaveNextBullet", "()Z", "setHaveNextBullet", "(Z)V", "localBullet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getLocalBullet", "()Ljava/util/ArrayList;", "setLocalBullet", "(Ljava/util/ArrayList;)V", "sysSpan", "com/tencent/mm/plugin/festival/finder/BulletCommentWidget$sysSpan$1", "Lcom/tencent/mm/plugin/festival/finder/BulletCommentWidget$sysSpan$1;", "adjustMargin", "", "clearLocalBullet", "getNextBulletComment", "getPrintMsg", "", "item", "hideBulletComment", "mergeBulletComment", "remote", "", "printMsgList", "prefix", "msgList", "", "debugPrint", "setBulletComment", "liveMsg", "showBulletComment", "pushAnim", "showNextBullet", "updateBulletComment", "bulletCommentList", "plugin-festival_release"})
public final class a {
    private final int ANIMATION_DURATION = 500;
    private final b Uqb;
    private final int ulA = 2000;
    private final float ulB = -500.0f;
    private final int ulC = 1000;
    final int ulD;
    ViewGroup ulG;
    TextView ulH;
    ObjectAnimator ulI;
    ObjectAnimator ulJ;
    ViewPropertyAnimator ulK;
    ArrayList<awq> ulL;
    boolean ulM;
    final ViewGroup ulO;
    final RecyclerView ulP;

    public a(ViewGroup viewGroup, RecyclerView recyclerView) {
        p.h(viewGroup, "bullet");
        p.h(recyclerView, "commentList");
        AppMethodBeat.i(261994);
        this.ulO = viewGroup;
        this.ulP = recyclerView;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.ulD = com.tencent.mm.plugin.finder.storage.c.dvd();
        this.ulG = this.ulO;
        View findViewById = this.ulG.findViewById(R.id.afi);
        p.g(findViewById, "container.findViewById(R…_comment_item_content_tv)");
        this.ulH = (TextView) findViewById;
        this.ulL = new ArrayList<>();
        this.Uqb = new b();
        this.ulG.setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ulG, "alpha", 1.0f, 0.0f);
        p.g(ofFloat, "ObjectAnimator.ofFloat(container, \"alpha\", 1f, 0f)");
        this.ulJ = ofFloat;
        this.ulJ.setDuration((long) this.ANIMATION_DURATION);
        this.ulJ.addListener(new Animator.AnimatorListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.a.AnonymousClass1 */
            final /* synthetic */ a Uqc;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.Uqc = r1;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(261982);
                Object target = this.Uqc.ulJ.getTarget();
                if (target == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(261982);
                    throw tVar;
                }
                ((View) target).setVisibility(8);
                AppMethodBeat.o(261982);
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
        this.ulI.setEvaluator(new b(this.ANIMATION_DURATION, this.ulA, (byte) 0));
        this.ulI.addListener(new Animator.AnimatorListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.a.AnonymousClass2 */
            final /* synthetic */ a Uqc;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.Uqc = r1;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(261983);
                if (!this.Uqc.ulM) {
                    this.Uqc.ulJ.start();
                    AppMethodBeat.o(261983);
                    return;
                }
                this.Uqc.np(false);
                AppMethodBeat.o(261983);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(261984);
                Object target = this.Uqc.ulI.getTarget();
                if (target == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(261984);
                    throw tVar;
                }
                View view = (View) target;
                view.setAlpha(1.0f);
                view.setVisibility(0);
                AppMethodBeat.o(261984);
            }
        });
        ViewPropertyAnimator listener = this.ulG.animate().setDuration((long) this.ulC).setListener(new AnimatorListenerAdapter(this) {
            /* class com.tencent.mm.plugin.festival.finder.a.AnonymousClass3 */
            final /* synthetic */ a Uqc;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.Uqc = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(261985);
                if (!this.Uqc.ulM) {
                    this.Uqc.ulJ.start();
                    AppMethodBeat.o(261985);
                    return;
                }
                this.Uqc.np(false);
                AppMethodBeat.o(261985);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(261986);
                this.Uqc.ulG.setAlpha(1.0f);
                this.Uqc.ulG.setVisibility(0);
                AppMethodBeat.o(261986);
            }
        });
        p.g(listener, "container.animate().setD…            }\n\n        })");
        this.ulK = listener;
        this.ulH.setTextSize(1, 15.0f);
        AppMethodBeat.o(261994);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/BulletCommentWidget$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-festival_release"})
    public static final class b extends CharacterStyle {
        b() {
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(261988);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.ua);
            if (textPaint != null) {
                textPaint.setColor(color);
            }
            if (textPaint != null) {
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(261988);
                return;
            }
            AppMethodBeat.o(261988);
        }
    }

    public final void dgJ() {
        AppMethodBeat.i(261990);
        this.ulG.setVisibility(8);
        this.ulI.cancel();
        this.ulJ.cancel();
        this.ulK.cancel();
        AppMethodBeat.o(261990);
    }

    public final void dZ(List<awq> list) {
        AppMethodBeat.i(261991);
        p.h(list, "bulletCommentList");
        d.h(new c(this, list));
        AppMethodBeat.o(261991);
    }

    public final void np(boolean z) {
        AppMethodBeat.i(261992);
        d.h(new C1053a(this, z));
        AppMethodBeat.o(261992);
    }

    static void b(String str, List<? extends awq> list, boolean z) {
        AppMethodBeat.i(261993);
        if (list.isEmpty()) {
            AppMethodBeat.o(261993);
            return;
        }
        if (z) {
            y yVar = y.vXH;
            if (!y.dCM()) {
                AppMethodBeat.o(261993);
                return;
            }
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Log.i("Finder.LiveCommentPlugin", str + " msg:" + g.bN(list.get(i2)));
        }
        AppMethodBeat.o(261993);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Uqc;
        final /* synthetic */ List ulS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, List list) {
            super(0);
            this.Uqc = aVar;
            this.ulS = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261989);
            a aVar = this.Uqc;
            List list = this.ulS;
            Log.i("Finder.LiveCommentPlugin", "before merge local size:" + aVar.ulL.size() + ",remote size:" + list.size() + ",max length:" + aVar.ulD);
            a.b("before", aVar.ulL, true);
            if (list.size() > 0) {
                if (list.size() <= aVar.ulD - aVar.ulL.size()) {
                    aVar.ulL.addAll(list);
                } else if (list.size() >= aVar.ulD) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : aVar.ulL) {
                        if (!p.j(t.username, z.aTY())) {
                            arrayList.add(t);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    aVar.ulL.removeAll(arrayList2);
                    aVar.ulL.addAll(list);
                    a.b("drop", arrayList2, false);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t2 : aVar.ulL) {
                        if (p.j(t2.username, z.aTY())) {
                            arrayList3.add(t2);
                        }
                    }
                    ArrayList arrayList4 = arrayList3;
                    aVar.ulL.removeAll(arrayList4);
                    int size = (aVar.ulD - list.size()) - arrayList4.size();
                    if (size <= 0) {
                        aVar.ulL = new ArrayList<>();
                    } else {
                        while (aVar.ulL.size() > size) {
                            awq remove = aVar.ulL.remove(0);
                            p.g(remove, "localBullet.removeAt(0)");
                            awq awq = remove;
                            Log.i("Finder.LiveCommentPlugin", "drop msg:" + (awq.nickname + ':' + awq.content));
                        }
                    }
                    aVar.ulL.addAll(arrayList4);
                    aVar.ulL.addAll(list);
                }
                Log.i("Finder.LiveCommentPlugin", "after merge local size:" + aVar.ulL.size() + ",remote size:" + list.size());
                a.b("after", aVar.ulL, true);
            }
            if (this.Uqc.ulO.getVisibility() != 0) {
                this.Uqc.np(true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261989);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.festival.finder.a$a  reason: collision with other inner class name */
    public static final class C1053a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Uqc;
        final /* synthetic */ boolean ulR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1053a(a aVar, boolean z) {
            super(0);
            this.Uqc = aVar;
            this.ulR = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            awq awq;
            FinderContact finderContact;
            FinderContact finderContact2;
            boolean z;
            String str;
            FinderContact finderContact3;
            FinderContact finderContact4;
            int i2;
            String str2 = null;
            AppMethodBeat.i(261987);
            a aVar = this.Uqc;
            if (aVar.ulL.size() > 0) {
                awq remove = aVar.ulL.remove(0);
                aVar.ulM = aVar.ulL.size() > 0;
                awq = remove;
            } else {
                awq = null;
            }
            Log.i("Finder.LiveCommentPlugin", "[getNextBulletComment] size:" + aVar.ulL.size() + ", haveNextBullet:" + aVar.ulM);
            if (awq != null) {
                a aVar2 = this.Uqc;
                boolean z2 = this.ulR;
                p.h(awq, "liveMsg");
                Log.i("Finder.LiveCommentPlugin", "show bullet comment:" + awq.content);
                aVar2.dgJ();
                RecyclerView.a adapter = aVar2.ulP.getAdapter();
                if (adapter != null) {
                    p.g(adapter, LocaleUtil.ITALIAN);
                    if (adapter.getItemCount() > 0) {
                        t.a aVar3 = t.UsE;
                        i2 = (int) t.uot;
                    } else {
                        i2 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = aVar2.ulO.getLayoutParams();
                    if (layoutParams == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(261987);
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
                        m mVar = m.vVH;
                        String str4 = awq.username;
                        if (str4 == null) {
                            str4 = "";
                        }
                        z = m.isFriend(str4);
                    }
                    Log.i("Finder.LiveCommentPlugin", "setBulletComment " + awq.nickname + " is friend:" + z);
                    com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    TextView textView = aVar2.ulH;
                    ax axVar = ax.UuB;
                    avn avn = awq.LHp;
                    if (avn == null || (finderContact4 = avn.contact) == null) {
                        str = null;
                    } else {
                        str = finderContact4.username;
                    }
                    avn avn2 = awq.LHp;
                    if (!(avn2 == null || (finderContact3 = avn2.contact) == null)) {
                        str2 = finderContact3.nickname;
                    }
                    aVar2.ulH.setText(new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(aVar2.ulG.getContext(), aVar2.ulG.getContext().getString(R.string.cxp, com.tencent.mm.plugin.finder.convert.d.e(textView, ax.cC(str, str2))))));
                } else {
                    o.c cVar2 = o.c.hGH;
                    if (i3 == o.c.aFv()) {
                        ax axVar2 = ax.UuB;
                        avn avn3 = awq.LHp;
                        String str5 = (avn3 == null || (finderContact2 = avn3.contact) == null) ? null : finderContact2.username;
                        avn avn4 = awq.LHp;
                        if (!(avn4 == null || (finderContact = avn4.contact) == null)) {
                            str2 = finderContact.nickname;
                        }
                        String Gb = d.Gb(ax.cC(str5, str2));
                        StringBuilder sb = new StringBuilder();
                        com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                        aVar2.ulH.setText(new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(aVar2.ulG.getContext(), aVar2.ulG.getContext().getString(R.string.d07, sb.append(com.tencent.mm.plugin.finder.convert.d.e(aVar2.ulH, Gb)).append("**").toString()))));
                    }
                }
                if (z2) {
                    aVar2.ulI.start();
                } else {
                    aVar2.ulK.start();
                }
            } else {
                this.Uqc.ulJ.start();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261987);
            return xVar;
        }
    }
}
