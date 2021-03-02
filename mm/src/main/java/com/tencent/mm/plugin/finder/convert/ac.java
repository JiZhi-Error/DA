package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.Cif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J@\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedFooterNoMoreData;", "tabType", "", "(I)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ac extends e<com.tencent.mm.plugin.finder.model.e> {
    private final int dLS;

    public ac(int i2) {
        this.dLS = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.e eVar, int i2, int i3, boolean z, List list) {
        String string;
        AppMethodBeat.i(243081);
        p.h(hVar, "holder");
        p.h(eVar, "item");
        View Mn = hVar.Mn(R.id.dkh);
        p.g(Mn, "holder.getView<View>(R.id.go_to_tab_arrow)");
        Mn.setVisibility(0);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        int dimension = (int) context.getResources().getDimension(R.dimen.ce);
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        int color = context2.getResources().getColor(R.color.v6);
        TextView textView = (TextView) hVar.Mn(R.id.h5w);
        p.g(textView, LocaleUtil.ITALIAN);
        if (y.a(y.vXH, this.dLS, 0, 2)) {
            textView.setTextColor(color);
            hVar.aus.setPadding(0, dimension, 0, dimension);
            string = hVar.getContext().getString(R.string.coy);
        } else {
            string = hVar.getContext().getString(R.string.d3g);
        }
        textView.setText(string);
        if (y.a(y.vXH, this.dLS, 0, 2)) {
            ((WeImageView) hVar.Mn(R.id.dkh)).setIconColor(color);
        }
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            View Mn2 = hVar.Mn(R.id.dkh);
            p.g(Mn2, "holder.getView<View>(R.id.go_to_tab_arrow)");
            Mn2.setVisibility(8);
            AppMethodBeat.o(243081);
        } else if (y.a(y.vXH, this.dLS, 0, 2)) {
            hVar.aus.setOnClickListener(new a(hVar));
            AppMethodBeat.o(243081);
        } else {
            y yVar = y.vXH;
            int i4 = this.dLS;
            View Mn3 = hVar.Mn(R.id.h5w);
            p.g(Mn3, "holder.getView<TextView>(R.id.retry_tip)");
            y.a(i4, (TextView) Mn3, new b(hVar));
            AppMethodBeat.o(243081);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.akg;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243080);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243080);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;

        a(h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            bbn dIx;
            AppMethodBeat.i(243078);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (!(fH == null || (dIx = fH.dIx()) == null)) {
                k kVar = k.vfA;
                k.e(dIx);
            }
            Cif ifVar = new Cif();
            ifVar.dMQ.dLS = 4;
            EventCenter.instance.publish(ifVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243078);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h qhp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            bbn dIx;
            AppMethodBeat.i(243079);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (!(fH == null || (dIx = fH.dIx()) == null)) {
                k kVar = k.vfA;
                k.e(dIx);
            }
            Cif ifVar = new Cif();
            ifVar.dMQ.dLS = 4;
            EventCenter.instance.publish(ifVar);
            x xVar = x.SXb;
            AppMethodBeat.o(243079);
            return xVar;
        }
    }
}
