package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J@\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ap extends e<ai> {
    @SuppressLint({"UseSparseArrays"})
    private static final SparseArray<Integer> tEs = new SparseArray<>();
    public static final a tEt = new a((byte) 0);
    private final int dLS;

    public ap(int i2) {
        this.dLS = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, ai aiVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243140);
        ai aiVar2 = aiVar;
        p.h(hVar, "holder");
        p.h(aiVar2, "item");
        tEs.put(this.dLS, Integer.valueOf(i2));
        if (aiVar2.uOu == 1) {
            hVar.mf(R.id.hgd, 8);
            hVar.mf(R.id.cf8, 0);
            hVar.e(R.id.cf8, aiVar2.uOt);
            k kVar = k.vfA;
            k kVar2 = k.vfA;
            int Kw = k.Kw(this.dLS);
            ei eiVar = new ei();
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            eiVar.qV(cMD);
            eiVar.afy();
            eiVar.afz();
            eiVar.afA();
            eiVar.lS((long) Kw);
            eiVar.bfK();
            k.a(eiVar);
            AppMethodBeat.o(243140);
            return;
        }
        if (aiVar2.uOu == 2) {
            View Mn = hVar.Mn(R.id.hgd);
            View Mn2 = hVar.Mn(R.id.cf8);
            hVar.e(R.id.cf8, aiVar2.uOt);
            y yVar = y.vXH;
            y.hT(Mn2);
            Mn.setOnClickListener(new b(this, hVar));
        }
        AppMethodBeat.o(243140);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.y;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int Is(int i2) {
            AppMethodBeat.i(243137);
            Object obj = ap.tEs.get(i2);
            p.g(obj, "positionMap[tabType]");
            int intValue = ((Number) obj).intValue();
            AppMethodBeat.o(243137);
            return intValue;
        }
    }

    static {
        AppMethodBeat.i(243141);
        AppMethodBeat.o(243141);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243139);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.cf9);
        p.g(Mn, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
        Context context = hVar.getContext();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((TextView) Mn).setText(context.getString(R.string.da8, com.tencent.mm.plugin.finder.storage.c.dsg()));
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            View Mn2 = hVar.Mn(R.id.cf9);
            p.g(Mn2, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
            ((TextView) Mn2).setVisibility(8);
            AppMethodBeat.o(243139);
            return;
        }
        View Mn3 = hVar.Mn(R.id.cf9);
        p.g(Mn3, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
        ((TextView) Mn3).setVisibility(0);
        AppMethodBeat.o(243139);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ ap tEu;

        b(ap apVar, h hVar) {
            this.tEu = apVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243138);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ap.aa(context, this.qhp.lR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243138);
        }
    }

    public static final /* synthetic */ void aa(Context context, int i2) {
        bbn dIx;
        AppMethodBeat.i(243142);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (!(fH == null || (dIx = fH.dIx()) == null)) {
            k kVar = k.vfA;
            k.a(2, 2, i2, dIx);
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243142);
            throw tVar;
        }
        ViewModel viewModel = com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderHomeUIC.class);
        p.g(viewModel, "UICProvider.of(context a…inderHomeUIC::class.java)");
        Bundle bundle = new Bundle();
        bundle.putInt("Source", 4);
        ((FinderHomeUIC) viewModel).p(4, bundle);
        AppMethodBeat.o(243142);
    }
}
