package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.component.a;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0006\u0010 \u001a\u00020\u001eJ\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0006\u0010'\u001a\u00020\u001eR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "cacheVisible", "", "getCacheVisible", "()Z", "setCacheVisible", "(Z)V", "isLuckyMoneyShowing", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "canClearScreen", "printLotteryInfo", "", NativeProtocol.WEB_DIALOG_ACTION, "resumeLottery", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateLottery", "Companion", "plugin-finder_release"})
public final class al extends d {
    private static final float UMC = MMApplicationContext.getResources().getDimension(R.dimen.bw);
    public static final c UMD = new c((byte) 0);
    private final String TAG = "FinderLiveLotteryBubblePlugin";
    private boolean UMB;
    private final com.tencent.mm.live.c.b hOp;
    a.AbstractC1176a ugA = new com.tencent.mm.plugin.finder.live.component.b(getLiveData(), this.hOp);
    private a.b ugh;
    private volatile boolean urL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public al(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246840);
        this.hOp = bVar;
        ViewGroup viewGroup2 = viewGroup;
        Context context = viewGroup.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246840);
            throw tVar;
        }
        this.ugh = new com.tencent.mm.plugin.finder.live.component.c(viewGroup2, (MMActivity) context, this.ugA);
        a.AbstractC1176a aVar = this.ugA;
        if (aVar != null) {
            a.b bVar2 = this.ugh;
            if (bVar2 == null) {
                p.hyc();
            }
            aVar.onAttach(bVar2);
        }
        m mVar = m.vVH;
        m.a((d) this, true);
        Log.i(this.TAG, "enable :" + getLiveData().uEe + ",useUpdateStrategy:" + getLiveData().uFd);
        AppMethodBeat.o(246840);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$Companion;", "", "()V", "ON_LUCKY_MONEY_BUBBLE_SHOWN_TRANSLATION_Y", "", "TRANSLATION_DURATION", "", "plugin-finder_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260657);
        AppMethodBeat.o(260657);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246835);
        super.unMount();
        a.AbstractC1176a aVar = this.ugA;
        if (aVar != null) {
            aVar.onDetach();
            AppMethodBeat.o(246835);
            return;
        }
        AppMethodBeat.o(246835);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(246836);
        p.h(cVar, "status");
        switch (am.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                atM("FINDER_LIVE_CREATE_LOTTERY_SUCCESS");
                dht();
                AppMethodBeat.o(246836);
                return;
            case 2:
                atM("FINDER_LIVE_CANCEL_LOTTERY_SUCCESS");
                dht();
                AppMethodBeat.o(246836);
                return;
            case 3:
                this.urL = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false) : false;
                Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.urL + ",screenclear:" + getLiveData().uDR);
                atM("FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.urL);
                if (!this.urL) {
                    rg(0);
                } else if (!getLiveData().uDR) {
                    this.ulW = 65535;
                    rg(this.ulV);
                }
                if (this.UMB && this.hwr.getVisibility() == 0) {
                    this.hwr.setTranslationY(UMC);
                }
                if (this.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.EXPOSURE_BLESS_BAG, "");
                    AppMethodBeat.o(246836);
                    return;
                }
                break;
            case 4:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
                }
                this.urL = z;
                Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.urL + ",screenclear:" + getLiveData().uDR);
                atM("FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.urL);
                if (this.urL) {
                    this.ulW = 8;
                    rg(this.ulV);
                    AppMethodBeat.o(246836);
                    return;
                }
                rg(8);
                AppMethodBeat.o(246836);
                return;
            case 5:
                atM("FINDER_LIVE_LOTTERY_UPDATE");
                dht();
                AppMethodBeat.o(246836);
                return;
            case 6:
                this.UMB = true;
                AppMethodBeat.o(246836);
                return;
            case 7:
                this.UMB = false;
                if (this.hwr.getVisibility() == 0) {
                    ObjectAnimator.ofFloat(this.hwr, "translationY", this.hwr.getTranslationY(), 0.0f).setDuration(500L).start();
                    AppMethodBeat.o(246836);
                    return;
                }
                break;
            case 8:
                a.AbstractC1176a aVar = this.ugA;
                if (aVar != null) {
                    aVar.onDetach();
                    AppMethodBeat.o(246836);
                    return;
                }
                break;
        }
        AppMethodBeat.o(246836);
    }

    public final void dht() {
        AppMethodBeat.i(246837);
        d.h(new b(this));
        AppMethodBeat.o(246837);
    }

    public final void dhu() {
        AppMethodBeat.i(246838);
        d.h(new a(this));
        AppMethodBeat.o(246838);
    }

    private final void atM(String str) {
        awi awi;
        AppMethodBeat.i(246839);
        i iVar = getLiveData().uEa;
        if (iVar != null) {
            awi = iVar.tWe;
        } else {
            awi = null;
        }
        if (awi == null) {
            Log.i(this.TAG, str + " lotteryInfo is empty!");
        }
        AppMethodBeat.o(246839);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ al urM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(al alVar) {
            super(0);
            this.urM = alVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            awi awi;
            String str;
            awi awi2;
            String str2 = null;
            AppMethodBeat.i(246834);
            if (this.urM.getLiveData().isLiveStarted()) {
                i iVar = (i) j.kt(this.urM.getLiveData().uDZ);
                if (iVar != null) {
                    awi = iVar.tWe;
                } else {
                    awi = null;
                }
                if (awi == null || Util.isNullOrNil(awi.id)) {
                    String str3 = this.urM.TAG;
                    StringBuilder sb = new StringBuilder("updateLottery error firstLotteryInfo id:");
                    if (awi != null) {
                        str = awi.id;
                    } else {
                        str = null;
                    }
                    StringBuilder append = sb.append(str).append(",local lottery id:");
                    i iVar2 = this.urM.getLiveData().uEa;
                    if (!(iVar2 == null || (awi2 = iVar2.tWe) == null)) {
                        str2 = awi2.id;
                    }
                    Log.i(str3, append.append(str2).toString());
                    if (!this.urM.getLiveData().uDZ.isEmpty()) {
                        this.urM.getLiveData().uDZ.removeFirst();
                    }
                } else {
                    a.AbstractC1176a aVar = this.urM.ugA;
                    if (aVar != null) {
                        aVar.a(iVar);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246834);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ al urM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(al alVar) {
            super(0);
            this.urM = alVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            awi awi;
            String str;
            awi awi2;
            String str2 = null;
            AppMethodBeat.i(246833);
            if (this.urM.getLiveData().isLiveStarted()) {
                i iVar = (i) j.kt(this.urM.getLiveData().uDZ);
                if (iVar != null) {
                    awi = iVar.tWe;
                } else {
                    awi = null;
                }
                if (awi != null && !Util.isNullOrNil(awi.id)) {
                    a.AbstractC1176a aVar = this.urM.ugA;
                    if (aVar != null) {
                        aVar.b(iVar);
                    }
                } else if (!this.urM.getLiveData().uDZ.isEmpty()) {
                    this.urM.getLiveData().uDZ.removeFirst();
                }
                String str3 = this.urM.TAG;
                StringBuilder sb = new StringBuilder("resumeLottery firstLotteryInfo id:");
                if (awi != null) {
                    str = awi.id;
                } else {
                    str = null;
                }
                StringBuilder append = sb.append(str).append(",lottery id:");
                i iVar2 = this.urM.getLiveData().uEa;
                if (!(iVar2 == null || (awi2 = iVar2.tWe) == null)) {
                    str2 = awi2.id;
                }
                Log.i(str3, append.append(str2).toString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246833);
            return xVar;
        }
    }
}
