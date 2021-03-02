package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "lastTabIndex", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "tabRedText", "Landroid/widget/TextView;", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTabMargin", "", "onTabInflated", "setTabRedDot", "redDotText", "", "isTabSelected", "", "plugin-finder_release"})
public final class a extends c {
    private TextView wBM;
    private k wBN;
    private bdo wBO;
    private final int wyL = ((FinderTabStateCacheVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();

    public a(int i2) {
        super(i2);
        AppMethodBeat.i(256110);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        AppMethodBeat.o(256110);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final int getLayoutId() {
        return R.layout.ahk;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final void u(ViewGroup viewGroup) {
        AppMethodBeat.i(256106);
        if (viewGroup != null) {
            this.titleTv = (TextView) viewGroup.findViewById(R.id.ifz);
            this.wBM = (TextView) viewGroup.findViewById(R.id.ifx);
        }
        Log.i("Finder.FinderTab", "onTabInflated lastTabIndex:" + this.wyL + " index:" + this.index);
        if (this.wyL != this.index) {
            FinderNotifyUIC.a aVar = FinderNotifyUIC.wyQ;
            String My = FinderNotifyUIC.a.My(this.index);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            this.wBN = ((PluginFinder) ah).getRedDotManager().asX(My);
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            this.wBO = ((PluginFinder) ah2).getRedDotManager().asW(My);
        }
        AppMethodBeat.o(256106);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final void by(String str, boolean z) {
        AppMethodBeat.i(256107);
        TextView textView = this.wBM;
        if (textView == null) {
            AppMethodBeat.o(256107);
        } else if (Util.isNullOrNil(str)) {
            textView.setVisibility(4);
            textView.setText("");
            AppMethodBeat.o(256107);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
            AppMethodBeat.o(256107);
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public final int[] cXC() {
        return new int[]{0, 4};
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c
    public final void v(ViewGroup viewGroup) {
        AppMethodBeat.i(256108);
        p.h(viewGroup, "tabView");
        super.v(viewGroup);
        e.a aVar = e.wtE;
        Log.i(e.TAG, "onTabUnSelected real");
        by("", true);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        f redDotManager = ((PluginFinder) ah).getRedDotManager();
        FinderNotifyUIC.a aVar2 = FinderNotifyUIC.wyQ;
        redDotManager.asV(FinderNotifyUIC.a.My(this.index));
        AppMethodBeat.o(256108);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c
    public final void t(ViewGroup viewGroup) {
        AppMethodBeat.i(256109);
        p.h(viewGroup, "tabView");
        super.t(viewGroup);
        if (viewGroup.getContext() instanceof MMActivity) {
            y yVar = y.vXH;
            k kVar = this.wBN;
            bdo bdo = this.wBO;
            Context context = viewGroup.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(256109);
                throw tVar;
            }
            MMActivity mMActivity = (MMActivity) context;
            if (!(kVar == null || bdo == null || mMActivity == null)) {
                j jVar = j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(mMActivity);
                j.a("5", kVar, bdo, 3, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
        }
        AppMethodBeat.o(256109);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c
    public final int dHM() {
        return this.wyL;
    }
}
