package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.model.bh;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J@\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J \u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "itemPosition", "", "observer", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class bx extends e<bh> {
    public static final a tFr = new a((byte) 0);
    private int kf = -1;
    private final Observer<h.a> tFo = new b(this);
    private WxRecyclerAdapter<?> tFp;
    private bh tFq;

    static {
        AppMethodBeat.i(243234);
        AppMethodBeat.o(243234);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class b<T> implements Observer<h.a> {
        final /* synthetic */ bx tFs;

        b(bx bxVar) {
            this.tFs = bxVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            bh bhVar;
            String str;
            bdo atl;
            AppMethodBeat.i(243225);
            h.a aVar2 = aVar;
            if (aVar2 == null || (bhVar = this.tFs.tFq) == null) {
                AppMethodBeat.o(243225);
                return;
            }
            k kVar = aVar2.tKT;
            if (kVar == null || (atl = kVar.atl("TLWxPrivateMsgBubble")) == null) {
                str = null;
            } else {
                str = atl.qGB;
            }
            bhVar.sessionId = str;
            Log.i("Finder.PrivateMsgNotifyConvert", "isShow=" + aVar2.dEF + ' ' + bhVar.sessionId);
            WxRecyclerAdapter wxRecyclerAdapter = this.tFs.tFp;
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.Or((long) bhVar.hashCode());
            }
            WxRecyclerAdapter wxRecyclerAdapter2 = this.tFs.tFp;
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.ci(this.tFs.kf);
                AppMethodBeat.o(243225);
                return;
            }
            AppMethodBeat.o(243225);
        }
    }

    public bx() {
        AppMethodBeat.i(243233);
        AppMethodBeat.o(243233);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, bh bhVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243231);
        a(hVar, bhVar, i2);
        AppMethodBeat.o(243231);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3120j;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(243228);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        this.tFp = wxRecyclerAdapter;
        h hVar = h.tKR;
        h.daX().observeForever(this.tFo);
        AppMethodBeat.o(243228);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243229);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        h hVar = h.tKR;
        h.daX().removeObserver(this.tFo);
        AppMethodBeat.o(243229);
    }

    public final void a(com.tencent.mm.view.recyclerview.h hVar, bh bhVar, int i2) {
        String str;
        k kVar;
        AppMethodBeat.i(243230);
        p.h(hVar, "holder");
        p.h(bhVar, "item");
        this.tFq = bhVar;
        this.kf = i2;
        h hVar2 = h.tKR;
        h.a value = h.daX().getValue();
        if (value == null || !value.dEF) {
            View Mn = hVar.Mn(R.id.fmk);
            if (Mn != null) {
                Mn.setVisibility(8);
                AppMethodBeat.o(243230);
                return;
            }
            AppMethodBeat.o(243230);
            return;
        }
        View Mn2 = hVar.Mn(R.id.fmk);
        p.g(Mn2, "holder.getView<View>(R.id.msg_layout)");
        Mn2.setVisibility(0);
        h hVar3 = h.tKR;
        h.a value2 = h.daX().getValue();
        bdo atl = (value2 == null || (kVar = value2.tKT) == null) ? null : kVar.atl("TLWxPrivateMsgBubble");
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        k asX = ((PluginFinder) ah).getRedDotManager().asX("TLWxPrivateMsgBubble");
        if (atl != null) {
            str = atl.qGB;
        } else {
            str = null;
        }
        String avi = ((aa) g.af(aa.class)).avi(str);
        if (avi != null) {
            ay.a.aVo().a(avi, null, new c(avi, hVar, asX, atl));
            hVar.Mn(R.id.fmk).setOnClickListener(new d(hVar, asX, atl));
            AppMethodBeat.o(243230);
            return;
        }
        AppMethodBeat.o(243230);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$1"})
    public static final class c implements ay.b.a {
        final /* synthetic */ String naX;
        final /* synthetic */ k tFt;
        final /* synthetic */ bdo tFu;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        c(String str, com.tencent.mm.view.recyclerview.h hVar, k kVar, bdo bdo) {
            this.naX = str;
            this.tzq = hVar;
            this.tFt = kVar;
            this.tFu = bdo;
        }

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(243226);
            Log.i("Finder.PrivateMsgNotifyConvert", "[getNow] username=" + str + " succ=" + z);
            com.tencent.mm.ui.g.a.a.d((ImageView) this.tzq.Mn(R.id.fm7), this.naX);
            AppMethodBeat.o(243226);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$2"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ k tFt;
        final /* synthetic */ bdo tFu;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        d(com.tencent.mm.view.recyclerview.h hVar, k kVar, bdo bdo) {
            this.tzq = hVar;
            this.tFt = kVar;
            this.tFu = bdo;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243227);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(this.tFt == null || this.tFu == null)) {
                j jVar = j.vft;
                k kVar = this.tFt;
                bdo bdo = this.tFu;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = this.tzq.getContext();
                p.g(context, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                j.a("7", kVar, bdo, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.tzq.getContext();
            p.g(context2, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.fB(context2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243227);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(243232);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243232);
    }
}
