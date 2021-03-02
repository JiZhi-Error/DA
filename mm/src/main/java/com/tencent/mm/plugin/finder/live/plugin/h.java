package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.widget.c;
import com.tencent.mm.plugin.finder.live.widget.s;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010)\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "lotteryWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "hideOption", "option", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "shoppingEntranceView", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateApplyLinkInfo", "Companion", "plugin-finder_release"})
public final class h extends d {
    private static final int ums = 1;
    private static final int umt = 2;
    public static final a umu = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveAnchorBottomOptionPlugin";
    private final s ULi;
    private final com.tencent.mm.live.c.b hOp;
    public final c ump;
    private final com.tencent.mm.plugin.finder.live.widget.b umq;
    private final com.tencent.mm.plugin.finder.live.widget.a umr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246420);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.hql);
        p.g(findViewById, "root.findViewById(R.id.s…pping_entrance_container)");
        this.ump = new c((ViewGroup) findViewById, this.hOp, this);
        View findViewById2 = viewGroup.findViewById(R.id.ecb);
        p.g(findViewById2, "root.findViewById(R.id.link_entrance_container)");
        this.umq = new com.tencent.mm.plugin.finder.live.widget.b((ViewGroup) findViewById2, this.hOp, this);
        View findViewById3 = viewGroup.findViewById(R.id.k0s);
        p.g(findViewById3, "root.findViewById(R.id.l…money_entrance_container)");
        this.ULi = new s((ViewGroup) findViewById3, this.hOp, this);
        View findViewById4 = viewGroup.findViewById(R.id.etj);
        p.g(findViewById4, "root.findViewById(R.id.lottery_entrance_container)");
        this.umr = new com.tencent.mm.plugin.finder.live.widget.a((ViewGroup) findViewById4, this.hOp, this);
        if (!isLandscape()) {
            viewGroup.post(new Runnable() {
                /* class com.tencent.mm.plugin.finder.live.plugin.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(246411);
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246411);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
                    AppMethodBeat.o(246411);
                }
            });
        }
        AppMethodBeat.o(246420);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin$Companion;", "", "()V", "OPTION_LOTTERY", "", "getOPTION_LOTTERY", "()I", "OPTION_MIC", "getOPTION_MIC", "OPTION_SHOPPING", "getOPTION_SHOPPING", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246421);
        AppMethodBeat.o(246421);
    }

    public final void dgN() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(246414);
        c cVar = this.ump;
        if (cVar.uFw.getLiveData().uit) {
            cVar.rg(0);
        } else {
            cVar.rg(8);
        }
        this.umq.dju();
        com.tencent.mm.plugin.finder.live.widget.a aVar = this.umr;
        if (aVar.uFw.getLiveData().uEe) {
            aVar.rg(0);
        } else {
            aVar.rg(8);
        }
        Log.i(aVar.TAG, "checkVisible:" + aVar.uFw.getLiveData().uEe);
        s sVar = this.ULi;
        a.C0381a aVar2 = com.tencent.mm.live.core.core.c.a.hAj;
        if (a.C0381a.aDp() || !sVar.uFw.getLiveData().hTX()) {
            sVar.hwr.setVisibility(8);
        } else {
            sVar.hwr.setVisibility(0);
        }
        if (this.ump.hwr.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (this.umq.hwr.getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (this.umr.hwr.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    if (this.ULi.hwr.getVisibility() != 0) {
                        z4 = false;
                    }
                    if (!z4) {
                        rg(8);
                        AppMethodBeat.o(246414);
                        return;
                    }
                }
            }
        }
        rg(0);
        AppMethodBeat.o(246414);
    }

    public final void dgO() {
        AppMethodBeat.i(246415);
        com.tencent.mm.plugin.finder.live.widget.b bVar = this.umq;
        e eVar = bVar.uFw.getLiveData().uEB;
        Log.i(bVar.TAG, "updateApplyLinkInfo newApplyCount:" + bVar.uFw.getLiveData().hTU() + ", curLinkUser:" + eVar);
        TextView textView = bVar.uFB;
        p.g(textView, "linkMicTip");
        textView.setVisibility(4);
        TextView textView2 = bVar.UQR;
        p.g(textView2, "linkMicPkTip");
        textView2.setVisibility(4);
        if (eVar == null) {
            if (bVar.uFw.getLiveData().hTV() > 0) {
                TextView textView3 = bVar.UQR;
                p.g(textView3, "linkMicPkTip");
                textView3.setVisibility(0);
                k kVar = k.vkd;
                s.x xVar = s.x.LINKMIC_ICON_READDOT_EXPOSE;
                TextView textView4 = bVar.UQR;
                p.g(textView4, "linkMicPkTip");
                CharSequence text = textView4.getText();
                if (!(text instanceof String)) {
                    text = null;
                }
                k.a(xVar, (String) text, -1, -1);
            } else if (bVar.uFw.getLiveData().hTU() > 0) {
                TextView textView5 = bVar.uFB;
                p.g(textView5, "linkMicTip");
                y yVar = y.vXH;
                textView5.setText(y.LU(bVar.uFw.getLiveData().hTU()));
                TextView textView6 = bVar.uFB;
                p.g(textView6, "linkMicTip");
                textView6.setVisibility(0);
                k kVar2 = k.vkd;
                s.x xVar2 = s.x.LINKMIC_ICON_READDOT_EXPOSE;
                TextView textView7 = bVar.uFB;
                p.g(textView7, "linkMicTip");
                CharSequence text2 = textView7.getText();
                if (!(text2 instanceof String)) {
                    text2 = null;
                }
                k.a(xVar2, (String) text2, -1, -1);
            }
        }
        bVar.djv();
        AppMethodBeat.o(246415);
    }

    public final void dgP() {
        AppMethodBeat.i(246416);
        d.h(new b(this));
        AppMethodBeat.o(246416);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246417);
        p.h(cVar, "status");
        switch (i.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.umq.dju();
                break;
        }
        AppMethodBeat.o(246417);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void ai(Bundle bundle) {
        String str;
        AppMethodBeat.i(260548);
        com.tencent.mm.plugin.finder.live.widget.a aVar = this.umr;
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, com.tencent.mm.plugin.finder.live.widget.a.uFx)) {
            aVar.djt();
        }
        AppMethodBeat.o(260548);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(246419);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("onActivityResult requestCode:").append(i2).append(",resultCode is ok:");
        if (i3 == -1) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str, append.append(z).toString());
        com.tencent.mm.plugin.finder.live.widget.a aVar = this.umr;
        String str2 = aVar.TAG;
        StringBuilder append2 = new StringBuilder("onActivityResult requestCode:").append(i2).append(",resultCode is ok:");
        if (i3 != -1) {
            z2 = false;
        }
        Log.i(str2, append2.append(z2).toString());
        if (i2 == 1002 && i3 == -1) {
            b.C0376b.a(aVar.hOp, b.c.hNA);
        }
        AppMethodBeat.o(246419);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h umv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.umv = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246413);
            this.umv.umq.djv();
            x xVar = x.SXb;
            AppMethodBeat.o(246413);
            return xVar;
        }
    }
}
