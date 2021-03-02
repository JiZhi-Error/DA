package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderLiveWeCoinHotConstract$ViewCallback$initView$3 implements View.OnClickListener {
    final /* synthetic */ FinderLiveWeCoinHotConstract.ViewCallback uXY;

    FinderLiveWeCoinHotConstract$ViewCallback$initView$3(FinderLiveWeCoinHotConstract.ViewCallback viewCallback) {
        this.uXY = viewCallback;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(249844);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        m mVar = m.vVH;
        if (m.dBP()) {
            k kVar = k.vkd;
            k.a(s.e.SEE_GIFT_LIST, String.valueOf(s.i.CLICK_FETCH_INCOME.action));
        }
        c cVar = (c) g.af(c.class);
        MMActivity b2 = FinderLiveWeCoinHotConstract.ViewCallback.b(this.uXY);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.expt.b.c.class);
        p.g(af, "MMKernel.service(IHellBizService::class.java)");
        String cMG = ((com.tencent.mm.plugin.expt.b.c) af).cMG();
        if (cMG == null) {
            cMG = "";
        }
        cVar.bN(b2, cMG);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249844);
    }
}
