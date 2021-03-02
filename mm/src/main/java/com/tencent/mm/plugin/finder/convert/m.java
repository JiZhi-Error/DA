package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.Cif;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B'\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class m extends com.tencent.mm.view.recyclerview.e<g> {
    public static final a tBu = new a((byte) 0);
    private final kotlin.g.a.a<x> tBs;
    private final kotlin.g.a.a<x> tBt;

    static {
        AppMethodBeat.i(165390);
        AppMethodBeat.o(165390);
    }

    public /* synthetic */ m(kotlin.g.a.a aVar) {
        this(aVar, null);
    }

    public m(kotlin.g.a.a<x> aVar, kotlin.g.a.a<x> aVar2) {
        this.tBs = aVar;
        this.tBt = aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, g gVar, int i2, int i3, boolean z, List list) {
        boolean z2;
        AppMethodBeat.i(165388);
        g gVar2 = gVar;
        p.h(hVar, "holder");
        p.h(gVar2, "item");
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        view.setVisibility(0);
        g gVar3 = (g) hVar.hgv();
        if (y.a(y.vXH, gVar2.dLS, 0, 2) && (gVar2.dLS == 3 || gVar2.dLS == 1)) {
            View view2 = hVar.aus;
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            view2.setBackgroundColor(context.getResources().getColor(R.color.rv));
            TextView textView = (TextView) hVar.Mn(R.id.h5w);
            if (textView != null) {
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                textView.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_2));
            }
        }
        if (gVar3 == null || gVar3.type != -2) {
            View Mn = hVar.Mn(R.id.e_u);
            if (Mn != null) {
                Mn.setVisibility(8);
            }
            View Mn2 = hVar.Mn(R.id.c2t);
            if (Mn2 != null) {
                Mn2.setVisibility(0);
            }
            View Mn3 = hVar.Mn(R.id.ip9);
            if (Mn3 != null) {
                Mn3.setVisibility(0);
            }
            CharSequence charSequence = gVar2.uNQ;
            if (charSequence == null || charSequence.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                View Mn4 = hVar.Mn(R.id.glc);
                if (Mn4 != null) {
                    Mn4.setVisibility(0);
                }
                View Mn5 = hVar.Mn(R.id.h5w);
                if (Mn5 != null) {
                    Mn5.setVisibility(8);
                }
                View Mn6 = hVar.Mn(R.id.h5u);
                if (Mn6 != null) {
                    Mn6.setVisibility(8);
                }
                View Mn7 = hVar.Mn(R.id.dkh);
                if (Mn7 != null) {
                    Mn7.setVisibility(8);
                    AppMethodBeat.o(165388);
                    return;
                }
                AppMethodBeat.o(165388);
                return;
            }
            View Mn8 = hVar.Mn(R.id.glc);
            if (Mn8 != null) {
                Mn8.setVisibility(8);
            }
            View Mn9 = hVar.Mn(R.id.h5w);
            if (Mn9 != null) {
                Mn9.setVisibility(0);
            }
            if (gVar3 == null || gVar3.type != -1) {
                View Mn10 = hVar.Mn(R.id.h5u);
                if (Mn10 != null) {
                    Mn10.setVisibility(8);
                }
                hVar.e(R.id.h5w, gVar2.uNQ);
                switch (gVar2.dLS) {
                    case 1:
                    case 3:
                        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
                        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
                        if (((ad) af).dxX()) {
                            Context context3 = hVar.getContext();
                            p.g(context3, "holder.context");
                            ((TextView) hVar.Mn(R.id.h5w)).setText(context3.getResources().getString(R.string.d3g));
                            break;
                        } else {
                            y yVar = y.vXH;
                            int i4 = gVar2.dLS;
                            View Mn11 = hVar.Mn(R.id.h5w);
                            p.g(Mn11, "holder.getView<TextView>(R.id.retry_tip)");
                            y.a(i4, (TextView) Mn11, new c(hVar));
                            AppMethodBeat.o(165388);
                            return;
                        }
                    case 1001:
                    case 1005:
                        View Mn12 = hVar.Mn(R.id.h8v);
                        p.g(Mn12, "holder.getView<View>(R.id.root)");
                        Mn12.setBackground(hVar.getContext().getDrawable(R.color.BW_100));
                        switch (gVar2.uNP) {
                            case 1000:
                                View Mn13 = hVar.Mn(R.id.h5w);
                                p.g(Mn13, "holder.getView<TextView>(R.id.retry_tip)");
                                ((TextView) Mn13).setText(gVar2.uNQ);
                                break;
                            case 2000:
                                y yVar2 = y.vXH;
                                View Mn14 = hVar.Mn(R.id.h5w);
                                p.g(Mn14, "holder.getView<TextView>(R.id.retry_tip)");
                                y.a((TextView) Mn14, gVar2.uNQ.toString(), new d(gVar2));
                                AppMethodBeat.o(165388);
                                return;
                            default:
                                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(ad.class);
                                p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
                                if (((ad) af2).dxX()) {
                                    View Mn15 = hVar.Mn(R.id.h5w);
                                    p.g(Mn15, "holder.getView<TextView>(R.id.retry_tip)");
                                    Context context4 = hVar.getContext();
                                    p.g(context4, "holder.context");
                                    ((TextView) Mn15).setText(context4.getResources().getString(R.string.d3g));
                                    break;
                                } else {
                                    y yVar3 = y.vXH;
                                    View Mn16 = hVar.Mn(R.id.h5w);
                                    p.g(Mn16, "holder.getView<TextView>(R.id.retry_tip)");
                                    y.a((TextView) Mn16, new e(hVar));
                                    AppMethodBeat.o(165388);
                                    return;
                                }
                        }
                }
                View Mn17 = hVar.Mn(R.id.dkh);
                p.g(Mn17, "holder.getView<View>(R.id.go_to_tab_arrow)");
                Mn17.setVisibility(8);
                AppMethodBeat.o(165388);
                return;
            }
            View Mn18 = hVar.Mn(R.id.h5u);
            if (Mn18 != null) {
                Mn18.setVisibility(0);
            }
            View Mn19 = hVar.Mn(R.id.dkh);
            if (Mn19 != null) {
                Mn19.setVisibility(8);
            }
            Context context5 = hVar.getContext();
            p.g(context5, "holder.context");
            hVar.e(R.id.h5w, context5.getResources().getString(R.string.dak));
            AppMethodBeat.o(165388);
            return;
        }
        View Mn20 = hVar.Mn(R.id.e_u);
        if (Mn20 != null) {
            Mn20.setVisibility(0);
        }
        View Mn21 = hVar.Mn(R.id.c2t);
        if (Mn21 != null) {
            Mn21.setVisibility(8);
        }
        hVar.Mn(R.id.e_v).setOnClickListener(new b(this));
        AppMethodBeat.o(165388);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.akh;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ m tBv;

        f(m mVar, h hVar) {
            this.tBv = mVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165386);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g gVar = (g) this.qhp.hgv();
            if (gVar != null && gVar.type == -1) {
                View Mn = this.qhp.Mn(R.id.ip9);
                if (Mn != null) {
                    Mn.setVisibility(8);
                }
                View Mn2 = this.qhp.Mn(R.id.glc);
                if (Mn2 != null) {
                    Mn2.setVisibility(0);
                }
                kotlin.g.a.a aVar = this.tBv.tBs;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165386);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165387);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        hVar.aus.setOnClickListener(new f(this, hVar));
        AppMethodBeat.o(165387);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ m tBv;

        b(m mVar) {
            this.tBv = mVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242868);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a aVar = this.tBv.tBt;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242868);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h qhp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(0);
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            bbn dIx;
            AppMethodBeat.i(242869);
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
            AppMethodBeat.o(242869);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g tBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.tBw = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(242870);
            kotlin.g.a.a<x> aVar = this.tBw.uGD;
            if (aVar != null) {
                aVar.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(242870);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h qhp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super(0);
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242871);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.Z(context, new Intent());
            x xVar = x.SXb;
            AppMethodBeat.o(242871);
            return xVar;
        }
    }
}
