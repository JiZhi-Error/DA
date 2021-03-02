package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderLiveWeCoinHotConstract$ViewCallback$initView$2 implements View.OnClickListener {
    final /* synthetic */ FinderLiveWeCoinHotConstract.ViewCallback uXY;

    FinderLiveWeCoinHotConstract$ViewCallback$initView$2(FinderLiveWeCoinHotConstract.ViewCallback viewCallback) {
        this.uXY = viewCallback;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(249843);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        FinderLiveWeCoinHotConstract.ViewCallback.b(this.uXY).finish();
        m mVar = m.vVH;
        if (m.dBP()) {
            k kVar = k.vkd;
            k.a(s.e.SEE_GIFT_LIST, String.valueOf(s.i.RETRUN_LIVE_CLOSE_UI.action));
        }
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249843);
    }
}
