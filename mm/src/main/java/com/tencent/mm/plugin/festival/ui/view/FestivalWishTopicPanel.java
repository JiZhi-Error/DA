package com.tencent.mm.plugin.festival.ui.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.festival.model.ah;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.av;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u0010\u001e\u001a\u00020\tJ\u0014\u0010\u001f\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!J\u0006\u0010\"\u001a\u00020\tR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onHideCallback", "Lkotlin/Function0;", "", "getOnHideCallback", "()Lkotlin/jvm/functions/Function0;", "setOnHideCallback", "(Lkotlin/jvm/functions/Function0;)V", "onShowCallback", "getOnShowCallback", "setOnShowCallback", "panelHeight", "", "selectCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalTopic;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "genTopicLine", "Landroid/view/View;", "topicOne", "topicTwo", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "setTopics", "topics", "", "show", "Companion", "plugin-festival_release"})
public final class FestivalWishTopicPanel extends LinearLayout {
    @Deprecated
    public static final a UFS = new a((byte) 0);
    private final int Kjk;
    private kotlin.g.a.a<x> UFP;
    private kotlin.g.a.a<x> UFQ;
    private kotlin.g.a.b<? super ah, x> UFR;
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(263466);
        AppMethodBeat.o(263466);
    }

    private View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(263467);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(263467);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalWishTopicPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(263465);
        int aD = av.aD(context);
        LayoutInflater.from(context).inflate(R.layout.ceo, (ViewGroup) this, true);
        this.Kjk = (av.az(context).y / 2) + aD;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.k2o);
        p.g(linearLayout, "topicContainer");
        int paddingLeft = linearLayout.getPaddingLeft();
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.k2o);
        p.g(linearLayout2, "topicContainer");
        int paddingTop = linearLayout2.getPaddingTop();
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.k2o);
        p.g(linearLayout3, "topicContainer");
        ((LinearLayout) _$_findCachedViewById(R.id.k2o)).setPadding(paddingLeft, paddingTop, linearLayout3.getPaddingRight(), aD);
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(R.id.k2t);
        p.g(linearLayout4, "topicPanelRoot");
        linearLayout4.getLayoutParams().height = this.Kjk;
        ((RelativeLayout) _$_findCachedViewById(R.id.k2s)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.ui.view.FestivalWishTopicPanel.AnonymousClass1 */
            final /* synthetic */ FestivalWishTopicPanel UFT;

            {
                this.UFT = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(263455);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<ah, x> selectCallback = this.UFT.getSelectCallback();
                if (selectCallback != null) {
                    selectCallback.invoke(null);
                }
                this.UFT.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(263455);
            }
        });
        AppMethodBeat.o(263465);
    }

    public final kotlin.g.a.a<x> getOnHideCallback() {
        return this.UFP;
    }

    public final void setOnHideCallback(kotlin.g.a.a<x> aVar) {
        this.UFP = aVar;
    }

    public final kotlin.g.a.a<x> getOnShowCallback() {
        return this.UFQ;
    }

    public final void setOnShowCallback(kotlin.g.a.a<x> aVar) {
        this.UFQ = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.festival.model.ah, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.festival.model.ah, kotlin.x> */
    public final kotlin.g.a.b<ah, x> getSelectCallback() {
        return this.UFR;
    }

    public final void setSelectCallback(kotlin.g.a.b<? super ah, x> bVar) {
        this.UFR = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$show$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ FestivalWishTopicPanel UFT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e(FestivalWishTopicPanel festivalWishTopicPanel) {
            this.UFT = festivalWishTopicPanel;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(263459);
            p.h(animator, "animation");
            AppMethodBeat.o(263459);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263460);
            p.h(animator, "animation");
            this.UFT.setVisibility(0);
            kotlin.g.a.a<x> onShowCallback = this.UFT.getOnShowCallback();
            if (onShowCallback != null) {
                onShowCallback.invoke();
                AppMethodBeat.o(263460);
                return;
            }
            AppMethodBeat.o(263460);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(263461);
            p.h(animator, "animation");
            AppMethodBeat.o(263461);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(263462);
            p.h(animator, "animation");
            AppMethodBeat.o(263462);
        }
    }

    public final void hide() {
        AppMethodBeat.i(263463);
        if (getVisibility() != 0) {
            AppMethodBeat.o(263463);
            return;
        }
        animate().translationY((float) av.az(getContext()).y).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new d(this)).start();
        AppMethodBeat.o(263463);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$hide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ FestivalWishTopicPanel UFT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FestivalWishTopicPanel festivalWishTopicPanel) {
            this.UFT = festivalWishTopicPanel;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263458);
            this.UFT.setVisibility(8);
            kotlin.g.a.a<x> onHideCallback = this.UFT.getOnHideCallback();
            if (onHideCallback != null) {
                onHideCallback.invoke();
                AppMethodBeat.o(263458);
                return;
            }
            AppMethodBeat.o(263458);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void setTopics(List<? extends ah> list) {
        ah ahVar;
        AppMethodBeat.i(263464);
        p.h(list, "topics");
        if (list.isEmpty()) {
            Log.i("FestivalWishTopicPanel", "topic list empty");
            AppMethodBeat.o(263464);
            return;
        }
        ((LinearLayout) _$_findCachedViewById(R.id.k2o)).removeAllViews();
        kotlin.k.d a2 = j.a((kotlin.k.d) kotlin.a.j.r((Collection<?>) list), 2);
        int i2 = a2.SYU;
        int i3 = a2.SYV;
        int i4 = a2.lCq;
        if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
            while (true) {
                ah ahVar2 = (ah) list.get(i2);
                if (i2 + 1 < list.size()) {
                    ahVar = (ah) list.get(i2 + 1);
                } else {
                    ahVar = null;
                }
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cen, (ViewGroup) this, false);
                p.g(inflate, "container");
                TextView textView = (TextView) inflate.findViewById(R.id.k2r);
                p.g(textView, "container.topicOneTv");
                textView.setText("#" + ahVar2.field_topic);
                TextView textView2 = (TextView) inflate.findViewById(R.id.k2q);
                p.g(textView2, "container.topicOneNumTv");
                y yVar = y.vXH;
                textView2.setText(y.RN(ahVar2.field_count));
                ((LinearLayout) inflate.findViewById(R.id.k2p)).setOnClickListener(new c(this, ahVar2));
                if (ahVar != null) {
                    TextView textView3 = (TextView) inflate.findViewById(R.id.k2w);
                    p.g(textView3, "container.topicTwoTv");
                    textView3.setText("#" + ahVar.field_topic);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.k2v);
                    p.g(textView4, "container.topicTwoNumTv");
                    y yVar2 = y.vXH;
                    textView4.setText(y.RN(ahVar.field_count));
                    ((LinearLayout) inflate.findViewById(R.id.k2u)).setOnClickListener(new b(this, inflate, ahVar));
                } else {
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.k2u);
                    p.g(linearLayout, "container.topicTwoArea");
                    linearLayout.setVisibility(8);
                }
                ((LinearLayout) _$_findCachedViewById(R.id.k2o)).addView(inflate);
                if (i2 == i3) {
                    break;
                }
                i2 += i4;
            }
        }
        AppMethodBeat.o(263464);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FestivalWishTopicPanel UFT;
        final /* synthetic */ ah UFW;

        c(FestivalWishTopicPanel festivalWishTopicPanel, ah ahVar) {
            this.UFT = festivalWishTopicPanel;
            this.UFW = ahVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263457);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$genTopicLine$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<ah, x> selectCallback = this.UFT.getSelectCallback();
            if (selectCallback != null) {
                selectCallback.invoke(this.UFW);
            }
            this.UFT.hide();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$genTopicLine$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263457);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$genTopicLine$2$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FestivalWishTopicPanel UFT;
        final /* synthetic */ View UFU;
        final /* synthetic */ ah UFV;

        b(FestivalWishTopicPanel festivalWishTopicPanel, View view, ah ahVar) {
            this.UFT = festivalWishTopicPanel;
            this.UFU = view;
            this.UFV = ahVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263456);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$genTopicLine$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<ah, x> selectCallback = this.UFT.getSelectCallback();
            if (selectCallback != null) {
                selectCallback.invoke(this.UFV);
            }
            this.UFT.hide();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/view/FestivalWishTopicPanel$genTopicLine$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263456);
        }
    }
}
