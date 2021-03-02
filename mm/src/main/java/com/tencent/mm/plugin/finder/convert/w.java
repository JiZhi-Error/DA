package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J@\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refresh", "plugin-finder_release"})
public final class w extends e<v> {
    private final boolean tDa;
    private final kotlin.g.a.a<Boolean> tDb;
    final kotlin.g.a.b<Boolean, x> tDc;
    private final kotlin.g.a.a<x> tDd;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public w(boolean z, kotlin.g.a.a<Boolean> aVar, kotlin.g.a.b<? super Boolean, x> bVar, kotlin.g.a.a<x> aVar2) {
        p.h(aVar, "isSelfLike");
        p.h(bVar, "selfLikeClick");
        p.h(aVar2, "onRefresh");
        AppMethodBeat.i(243030);
        this.tDa = z;
        this.tDb = aVar;
        this.tDc = bVar;
        this.tDd = aVar2;
        AppMethodBeat.o(243030);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, v vVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243028);
        v vVar2 = vVar;
        p.h(hVar, "holder");
        p.h(vVar2, "item");
        TextView textView = (TextView) hVar.Mn(R.id.cmq);
        Context context = hVar.getContext();
        String str = vVar2.uOk.nickName;
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, str != null ? str : "");
        p.g(textView, "nickNameTv");
        textView.setText(c2);
        ImageView imageView = (ImageView) hVar.Mn(R.id.cmm);
        if (p.j(vVar2.uOk.dMW, z.aTY())) {
            com.tencent.mm.ui.g.a.a.c(imageView, z.aTY());
        } else {
            m mVar = m.uJa;
            d<o> dkb = m.dkb();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(vVar2.uOk.iAR);
            p.g(imageView, "avatarIv");
            m mVar2 = m.uJa;
            dkb.a(aVar, imageView, m.a(m.a.WX_AVATAR));
        }
        a(vVar2, hVar);
        AppMethodBeat.o(243028);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ajr;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243027);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243027);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ v tBC;
        final /* synthetic */ w tDe;

        a(w wVar, v vVar, h hVar) {
            this.tDe = wVar;
            this.tBC = vVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243025);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tDe.tDc.invoke(Boolean.FALSE);
            this.tDe.a(this.tBC, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243025);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ v tBC;
        final /* synthetic */ w tDe;

        b(w wVar, v vVar, h hVar) {
            this.tDe = wVar;
            this.tBC = vVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243026);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tDe.tDc.invoke(Boolean.TRUE);
            this.tDe.a(this.tBC, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243026);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, h hVar) {
        AppMethodBeat.i(243029);
        if (!this.tDa || !p.j(vVar.uOk.dMW, z.aTY())) {
            View Mn = hVar.Mn(R.id.g7f);
            if (Mn != null) {
                Mn.setVisibility(0);
            }
            View Mn2 = hVar.Mn(R.id.hj_);
            if (Mn2 != null) {
                Mn2.setVisibility(8);
            }
            View Mn3 = hVar.Mn(R.id.ebj);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
            }
            View Mn4 = hVar.Mn(R.id.jre);
            if (Mn4 != null) {
                Mn4.setVisibility(8);
            }
            View Mn5 = hVar.Mn(R.id.cl3);
            if (Mn5 != null) {
                Mn5.setVisibility(8);
                AppMethodBeat.o(243029);
                return;
            }
            AppMethodBeat.o(243029);
        } else if (this.tDb.invoke().booleanValue()) {
            View Mn6 = hVar.Mn(R.id.g7f);
            if (Mn6 != null) {
                Mn6.setVisibility(8);
            }
            View Mn7 = hVar.Mn(R.id.hj_);
            if (Mn7 != null) {
                Mn7.setVisibility(0);
            }
            View Mn8 = hVar.Mn(R.id.ebj);
            if (Mn8 != null) {
                Mn8.setVisibility(0);
            }
            View Mn9 = hVar.Mn(R.id.jre);
            if (Mn9 != null) {
                Mn9.setVisibility(8);
            }
            View Mn10 = hVar.Mn(R.id.cl3);
            if (Mn10 != null) {
                Mn10.setOnClickListener(new a(this, vVar, hVar));
                AppMethodBeat.o(243029);
                return;
            }
            AppMethodBeat.o(243029);
        } else {
            View Mn11 = hVar.Mn(R.id.ebj);
            if (Mn11 != null) {
                Mn11.setVisibility(8);
            }
            View Mn12 = hVar.Mn(R.id.jre);
            if (Mn12 != null) {
                Mn12.setVisibility(0);
            }
            View Mn13 = hVar.Mn(R.id.jre);
            if (Mn13 != null) {
                Mn13.setOnClickListener(new b(this, vVar, hVar));
            }
            this.tDd.invoke();
            AppMethodBeat.o(243029);
        }
    }
}
