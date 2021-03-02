package com.tencent.mm.plugin.finder.live.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.live.component.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0018\u00104\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0018\u00105\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0018\u00106\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0012\u00107\u001a\u0002002\b\b\u0002\u00108\u001a\u00020\u0010H\u0002J\"\u00109\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\bH\u0002J\u0010\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020*H\u0016J\b\u0010?\u001a\u000200H\u0016J\b\u0010@\u001a\u000200H\u0016J\u0010\u0010A\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010B\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010C\u001a\u000200H\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0018\u0010H\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0010\u0010I\u001a\u0002002\u0006\u0010:\u001a\u00020;H\u0002J*\u0010J\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\b2\b\b\u0002\u0010L\u001a\u00020\u001eH\u0002J\u0018\u0010M\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\u0018\u0010N\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\b\u0010O\u001a\u000200H\u0002J\u0010\u0010P\u001a\u0002002\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010E\u001a\u00020FH\u0003J \u0010S\u001a\u0002002\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u001eH\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BUBBLE_COMPUTING_STAY_DURATION", "", "getBUBBLE_COMPUTING_STAY_DURATION", "()I", "BUBBLE_STAY_DURATION", "getBUBBLE_STAY_DURATION", "COMPUTING_GET_RECORD_TIME_LIMIT", "getCOMPUTING_GET_RECORD_TIME_LIMIT", "LOTTERY_BUBBLE_CLOSE_TAG", "", "TAG", "getTAG", "()Ljava/lang/String;", "closeBubbleTask", "Ljava/lang/Runnable;", "computingGetLotteryRecordTimes", "getComputingGetLotteryRecordTimes", "setComputingGetLotteryRecordTimes", "(I)V", "remainTimeSecond", "getRemainTimeSecond", "setRemainTimeSecond", "statusResume", "", "getStatusResume", "()Z", "setStatusResume", "(Z)V", "timerLotteryId", "getTimerLotteryId", "setTimerLotteryId", "(Ljava/lang/String;)V", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "customerOpenCard", "", "doLotteryBubbleComputingLogic", "statusChange", "newLottery", "doLotteryBubbleDoneLogic", "doLotteryCardComputingLogic", "doLotteryCardDoneLogic", "endTimer", "msg", "getBubbleStayDuration", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "stayTime", "onAttach", "callback", "onBubbleClick", "onDetach", "onTimerEnd", "onTimerRuning", "onTimerUpdate", "resumeStatus", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "showComputingBubble", "showFinishBubble", "startTimer", "statusChangeAction", "lotteryStatus", "resumeState", "updateBubble", "updateCard", "updateLotteryRecord", "updateStatus", "updateStatusImpl", "Lcom/tencent/mm/plugin/finder/live/component/LotteryUpdateStatus;", "updateTimer", "plugin-finder_release"})
public final class b implements a.AbstractC1176a {
    final String TAG = "FinderLiveLotteryBubblePresenter";
    final com.tencent.mm.live.c.b hOp;
    final com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
    private MTimerHandler timerThread;
    a.b ugh;
    String ugi = "";
    private int ugj;
    private final int ugk = 10;
    volatile boolean ugl;
    private final int ugm;
    private final int ugn;
    private final String ugo;
    private final Runnable ugp;
    int ugq;

    public b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, com.tencent.mm.live.c.b bVar) {
        p.h(gVar, "liveData");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(245906);
        this.liveData = gVar;
        this.hOp = bVar;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.ugm = com.tencent.mm.plugin.finder.storage.c.dvn().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.ugn = com.tencent.mm.plugin.finder.storage.c.dvo().value().intValue();
        this.ugo = "LOTTERY_BUBBLE_CLOSE_TAG";
        this.ugp = new a(this);
        this.timerThread = new MTimerHandler("LiveLotteryBubble::Timer", (MTimerHandler.CallBack) new e(this), true);
        AppMethodBeat.o(245906);
    }

    public static final /* synthetic */ void a(b bVar, boolean z, boolean z2, int i2, boolean z3) {
        AppMethodBeat.i(245908);
        bVar.b(z, z2, i2, z3);
        AppMethodBeat.o(245908);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(a.b bVar) {
        AppMethodBeat.i(245904);
        a.b bVar2 = bVar;
        p.h(bVar2, "callback");
        Log.i(this.TAG, "onAttach");
        this.ugh = bVar2;
        a.b bVar3 = this.ugh;
        if (bVar3 != null) {
            bVar3.initView();
            AppMethodBeat.o(245904);
            return;
        }
        AppMethodBeat.o(245904);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ b ugr;

        a(b bVar) {
            this.ugr = bVar;
        }

        public final void run() {
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar;
            com.tencent.mm.live.c.b bVar;
            AppMethodBeat.i(245887);
            if (this.ugr.hOp instanceof FinderBaseLivePluginLayout) {
                com.tencent.mm.live.c.b bVar2 = this.ugr.hOp;
                if (!(bVar2 instanceof FinderBaseLivePluginLayout)) {
                    bVar2 = null;
                }
                FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) bVar2;
                if (finderBaseLivePluginLayout != null && !finderBaseLivePluginLayout.isDestroyed() && (((iVar = this.ugr.liveData.uEa) == null || iVar.uhD != 1) && (bVar = this.ugr.hOp) != null)) {
                    b.C0376b.a(bVar, b.c.hND);
                }
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.component.b.a.AnonymousClass1 */
                final /* synthetic */ a ugs;

                {
                    this.ugs = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    String str;
                    awi awi;
                    AppMethodBeat.i(245886);
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.ugs.ugr.liveData.uEa;
                    if (iVar != null) {
                        iVar.uFv = true;
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.ugs.ugr.liveData.uEa;
                    if (iVar2 == null || !iVar2.uFu) {
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.ugs.ugr.liveData;
                        com.tencent.mm.plugin.finder.live.viewmodel.i iVar3 = this.ugs.ugr.liveData.uEa;
                        if (iVar3 == null || (awi = iVar3.tWe) == null) {
                            str = null;
                        } else {
                            str = awi.id;
                        }
                        gVar.bj(str, this.ugs.ugr.liveData.djh());
                    }
                    Log.i(this.ugs.ugr.TAG, "closeBubbleTask running lotteryInfo:" + this.ugs.ugr.liveData.uEa);
                    x xVar = x.SXb;
                    AppMethodBeat.o(245886);
                    return xVar;
                }
            });
            AppMethodBeat.o(245887);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class e implements MTimerHandler.CallBack {
        final /* synthetic */ b ugr;

        e(b bVar) {
            this.ugr = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(245891);
            com.tencent.mm.ac.d.h(new c(this.ugr));
            AppMethodBeat.o(245891);
            return true;
        }
    }

    private final void att(String str) {
        AppMethodBeat.i(245896);
        Log.i(this.TAG, str + ":endTimer remainTimeSecond:" + this.ugq + ", timerLotteryId:" + this.ugi);
        this.timerThread.stopTimer();
        AppMethodBeat.o(245896);
    }

    /* access modifiers changed from: package-private */
    public final void dfc() {
        AppMethodBeat.i(245897);
        att("onTimerEnd");
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.liveData.uEa;
        if (iVar != null) {
            if (iVar.uhD == 1) {
                b(true, false, 2, false);
            }
            AppMethodBeat.o(245897);
            return;
        }
        AppMethodBeat.o(245897);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.AbstractC1176a
    public final void b(com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
        AppMethodBeat.i(245898);
        p.h(iVar, "lotteryInfoWrapper");
        com.tencent.mm.ac.d.h(new d(this, iVar));
        AppMethodBeat.o(245898);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.AbstractC1176a
    public final void a(com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
        AppMethodBeat.i(245899);
        p.h(iVar, "lotteryInfoWrapper");
        com.tencent.mm.ac.d.h(new i(this, iVar));
        AppMethodBeat.o(245899);
    }

    private final void b(boolean z, boolean z2, int i2, boolean z3) {
        awi awi;
        awi awi2;
        boolean z4;
        awi awi3;
        awi awi4;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar2;
        awi awi5;
        awi awi6;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar3;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar4;
        awi awi7;
        String str;
        awi awi8;
        AppMethodBeat.i(245900);
        this.ugl = true;
        com.tencent.f.h.RTc.bqo(this.ugo);
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar5 = this.liveData.uEa;
        if (iVar5 != null) {
            iVar5.uhD = i2;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar6 = this.liveData.uEa;
        if (iVar6 != null && iVar6.uhD == 4) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar7 = this.liveData.uEa;
            if (iVar7 == null || (awi8 = iVar7.tWe) == null) {
                str = null;
            } else {
                str = awi8.id;
            }
            gVar.bj(str, false);
        }
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar8 = this.liveData.uEa;
        if (iVar8 != null) {
            awi = iVar8.tWe;
        } else {
            awi = null;
        }
        Log.i(this.TAG, "updateTimer statusChange:" + z + ",newLottery:" + z2 + ",lotteryInfo is null:" + (awi == null) + ",timerStoped:" + this.timerThread.stopped() + ",resumeState:" + z3);
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar9 = this.liveData.uEa;
        if (iVar9 == null || iVar9.uhD != 1 || awi == null) {
            att("updateTimer");
        } else if (z2 || z3) {
            att("startTimer");
            m mVar = m.vVH;
            this.ugq = m.ag(awi.LHa, awi.iqg, awi.LHb);
            if (this.ugq > 0) {
                String str2 = awi.id;
                if (str2 == null) {
                    str2 = "";
                }
                this.ugi = str2;
                this.timerThread.startTimer(1000);
            } else {
                this.ugi = "";
                dfc();
            }
            Log.i(this.TAG, "startTimer id:" + awi.id + " remainTimeSecond:" + this.ugq + ", timerLotteryId:" + this.ugi);
        }
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar10 = this.liveData.uEa;
        Integer valueOf = iVar10 != null ? Integer.valueOf(iVar10.uhD) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            b.C0376b.a(this.hOp, b.c.hNC);
            if (z) {
                a.b bVar = this.ugh;
                if (bVar != null) {
                    bVar.H(new f(this));
                }
            } else {
                a.b bVar2 = this.ugh;
                if (bVar2 != null) {
                    bVar2.I(new g(this));
                }
            }
        } else {
            if (valueOf != null && valueOf.intValue() == 4) {
                Log.i(this.TAG, "cancel LotteryBubble!");
            } else if (valueOf != null && valueOf.intValue() == 2) {
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar11 = this.liveData.uEa;
                boolean cW = com.tencent.mm.ac.d.cW((iVar11 == null || (awi5 = iVar11.tWe) == null) ? 0 : awi5.extFlag, 1);
                m mVar2 = m.vVH;
                Log.i(this.TAG, "doLotteryBubbleComputingLogic isAnchor:" + m.dBP() + " participated:" + cW);
                a.b bVar3 = this.ugh;
                if (bVar3 != null) {
                    bVar3.dfa();
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                Boolean valueOf2 = (gVar2 == null || (iVar2 = gVar2.uEa) == null) ? null : Boolean.valueOf(iVar2.uFt);
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
                Boolean valueOf3 = (gVar3 == null || (iVar = gVar3.uEa) == null) ? null : Boolean.valueOf(iVar.uFu);
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar12 = this.liveData.uEa;
                if (iVar12 != null) {
                    awi4 = iVar12.tWe;
                } else {
                    awi4 = null;
                }
                String str3 = awi4 != null ? awi4.id : null;
                int a2 = a(z, awi4, this.ugn);
                Log.i(this.TAG, "showComputingBubble localLotteryId:" + str3 + ",statusChange:" + z + ",newLottery:" + z2 + ",BUBBLE_COMPUTING_STAY_DURATION:" + this.ugn + ",delayDuration:" + a2 + ",lastDoneLottery:" + valueOf2 + ",cardShowing:" + valueOf3);
                if (str3 != null && a2 > 0) {
                    com.tencent.f.h.RTc.bqo(this.ugo);
                    com.tencent.f.h.RTc.a(this.ugp, (long) a2, this.ugo);
                    b.C0376b.a(this.hOp, b.c.hNC);
                }
            } else if (valueOf != null && valueOf.intValue() == 3) {
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar13 = this.liveData.uEa;
                boolean cW2 = com.tencent.mm.ac.d.cW((iVar13 == null || (awi7 = iVar13.tWe) == null) ? 0 : awi7.extFlag, 1);
                m mVar3 = m.vVH;
                Log.i(this.TAG, "doLotteryBubbleDoneLogic isAnchor:" + m.dBP() + " participated:" + cW2);
                com.tencent.f.h.RTc.bqo(this.ugo);
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
                Boolean valueOf4 = (gVar4 == null || (iVar4 = gVar4.uEa) == null) ? null : Boolean.valueOf(iVar4.uFt);
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = this.liveData;
                Boolean valueOf5 = (gVar5 == null || (iVar3 = gVar5.uEa) == null) ? null : Boolean.valueOf(iVar3.uFu);
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar14 = this.liveData.uEa;
                if (iVar14 != null) {
                    awi6 = iVar14.tWe;
                } else {
                    awi6 = null;
                }
                String str4 = awi6 != null ? awi6.id : null;
                int a3 = a(z, awi6, this.ugm);
                Log.i(this.TAG, "showFinishBubble localLotteryId:" + str4 + ",statusChange:" + z + ",newLottery:" + z2 + ",BUBBLE_STAY_DURATION:" + this.ugm + ",delayDuration:" + a3 + ",lastDoneLottery:" + valueOf4 + ",cardShowing:" + valueOf5);
                if (str4 == null || a3 <= 0) {
                    b.C0376b.a(this.hOp, b.c.hND);
                } else {
                    a.b bVar4 = this.ugh;
                    if (bVar4 != null) {
                        bVar4.dfb();
                    }
                    com.tencent.f.h.RTc.a(this.ugp, (long) a3, this.ugo);
                    b.C0376b.a(this.hOp, b.c.hNC);
                }
            }
            b.C0376b.a(this.hOp, b.c.hND);
        }
        String str5 = this.TAG;
        StringBuilder sb = new StringBuilder("updateCard localStatus:");
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar15 = this.liveData.uEa;
        Log.i(str5, sb.append(iVar15 != null ? Integer.valueOf(iVar15.uhD) : null).toString());
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar16 = this.liveData.uEa;
        Integer valueOf6 = iVar16 != null ? Integer.valueOf(iVar16.uhD) : null;
        if (valueOf6 == null || valueOf6.intValue() != 1) {
            if (valueOf6 != null && valueOf6.intValue() == 4) {
                b.C0376b.a(this.hOp, b.c.hNH);
                AppMethodBeat.o(245900);
                return;
            } else if (valueOf6 != null && valueOf6.intValue() == 2) {
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar17 = this.liveData.uEa;
                boolean cW3 = com.tencent.mm.ac.d.cW((iVar17 == null || (awi2 = iVar17.tWe) == null) ? 0 : awi2.extFlag, 1);
                m mVar4 = m.vVH;
                boolean dBP = m.dBP();
                boolean isLiveStarted = this.liveData.isLiveStarted();
                String str6 = this.TAG;
                StringBuilder append = new StringBuilder("doLotteryCardComputingLogic liveState:").append(this.liveData.uEg).append(",isAnchor:").append(dBP).append(" localStatus:");
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar18 = this.liveData.uEa;
                Log.i(str6, append.append(iVar18 != null ? Integer.valueOf(iVar18.uhD) : null).append(",participated:").append(cW3).append(",statusChange:").append(z).append(",computingGetLotteryRecordTimes:").append(this.ugj).toString());
                if (!z || !isLiveStarted || (!dBP && !cW3)) {
                    if (isLiveStarted) {
                        int i3 = this.ugj;
                        this.ugj = i3 + 1;
                        if (i3 < this.ugk) {
                            dfd();
                        }
                    }
                    b.C0376b.a(this.hOp, b.c.hNH);
                    AppMethodBeat.o(245900);
                    return;
                }
                dfd();
                com.tencent.mm.live.c.b bVar5 = this.hOp;
                b.c cVar = b.c.hNE;
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", true);
                bVar5.statusChange(cVar, bundle);
                AppMethodBeat.o(245900);
                return;
            } else if (valueOf6 == null) {
                AppMethodBeat.o(245900);
                return;
            } else if (valueOf6.intValue() == 3) {
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar19 = this.liveData.uEa;
                boolean cW4 = com.tencent.mm.ac.d.cW((iVar19 == null || (awi3 = iVar19.tWe) == null) ? 0 : awi3.extFlag, 1);
                m mVar5 = m.vVH;
                boolean dBP2 = m.dBP();
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar20 = this.liveData.uEa;
                if (iVar20 != null) {
                    z4 = iVar20.uFs;
                } else {
                    z4 = false;
                }
                boolean isLiveStarted2 = this.liveData.isLiveStarted();
                Log.i(this.TAG, "doLotteryCardDoneLogic liveState:" + this.liveData.uEg + ",isAnchor:" + dBP2 + " participated:" + cW4 + ",statusChange:" + z + ", haveLottering:" + z4);
                if (z4 || !isLiveStarted2 || !z || (!cW4 && !dBP2)) {
                    b.C0376b.a(this.hOp, b.c.hNH);
                } else {
                    dfd();
                    com.tencent.mm.live.c.b bVar6 = this.hOp;
                    b.c cVar2 = b.c.hNE;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", true);
                    bVar6.statusChange(cVar2, bundle2);
                    AppMethodBeat.o(245900);
                    return;
                }
            }
        }
        AppMethodBeat.o(245900);
    }

    private final int a(boolean z, awi awi, int i2) {
        AppMethodBeat.i(245901);
        int i3 = i2 * 1000;
        if (!z) {
            int aWB = cl.aWB();
            int i4 = aWB - (awi != null ? awi.iqg : aWB);
            if (i4 <= 0) {
                i3 = i2 * 1000;
            } else if (1 <= i4 && i2 > i4) {
                i3 = (i2 - i4) * 1000;
            } else {
                i3 = 0;
                Log.i(this.TAG, "getBubbleStayDuration serverTime:" + aWB + ",finishDuration:" + i4);
            }
        }
        AppMethodBeat.o(245901);
        return i3;
    }

    private final void dfd() {
        String str;
        awi awi;
        String str2;
        AppMethodBeat.i(245902);
        if (this.hOp instanceof FinderBaseLivePluginLayout) {
            com.tencent.mm.live.c.b bVar = this.hOp;
            if (!(bVar instanceof FinderBaseLivePluginLayout)) {
                bVar = null;
            }
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) bVar;
            if (finderBaseLivePluginLayout != null) {
                s finderLiveAssistant = finderBaseLivePluginLayout.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.liveData.uEa;
                    if (iVar == null || (awi = iVar.tWe) == null || (str2 = awi.id) == null) {
                        str = "";
                    } else {
                        str = str2;
                    }
                    finderLiveAssistant.a(str, (com.tencent.mm.bw.b) null, new h(this));
                    AppMethodBeat.o(245902);
                    return;
                }
                AppMethodBeat.o(245902);
                return;
            }
        }
        AppMethodBeat.o(245902);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter$updateLotteryRecord$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class h implements o.a {
        final /* synthetic */ b ugr;

        h(b bVar) {
            this.ugr = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(245894);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.ugr.liveData.a(avy.tWe);
                this.ugr.liveData.d(avy);
            }
            AppMethodBeat.o(245894);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter$customerOpenCard$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.component.b$b  reason: collision with other inner class name */
    public static final class C1177b implements o.a {
        final /* synthetic */ b ugr;

        C1177b(b bVar) {
            this.ugr = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(245888);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.ugr.liveData.a(avy.tWe);
                this.ugr.liveData.d(avy);
            }
            b.C0376b.a(this.ugr.hOp, b.c.hNG);
            com.tencent.mm.live.c.b bVar = this.ugr.hOp;
            b.c cVar = b.c.hNE;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
            bVar.statusChange(cVar, bundle);
            AppMethodBeat.o(245888);
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(245905);
        Log.i(this.TAG, "onDetach " + Util.getStack());
        this.ugh = null;
        att("onDetach");
        com.tencent.f.h.RTc.bqo(this.ugo);
        AppMethodBeat.o(245905);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ugr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar) {
            super(0);
            this.ugr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245892);
            Log.i(this.ugr.TAG, "showPrepareLottery finish!");
            x xVar = x.SXb;
            AppMethodBeat.o(245892);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ugr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar) {
            super(0);
            this.ugr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245893);
            Log.i(this.ugr.TAG, "resumeLotteryBubble finish!");
            x xVar = x.SXb;
            AppMethodBeat.o(245893);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ugr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.ugr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            a.b bVar;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar;
            awi awi;
            AppMethodBeat.i(245889);
            b bVar2 = this.ugr;
            bVar2.ugq--;
            String str = this.ugr.ugi;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                String str2 = this.ugr.ugi;
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.ugr.liveData.uEa;
                if (p.j(str2, (iVar2 == null || (awi = iVar2.tWe) == null) ? null : awi.id) && (iVar = this.ugr.liveData.uEa) != null) {
                    iVar.uFr = this.ugr.ugq;
                }
            }
            if (this.ugr.ugq >= 0) {
                b bVar3 = this.ugr;
                int i2 = this.ugr.ugq;
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar3 = bVar3.liveData.uEa;
                if (!(iVar3 == null || iVar3.uhD != 1 || (bVar = bVar3.ugh) == null)) {
                    u.a aVar = u.hIn;
                    bVar.ats(u.a.a(i2, ":", false, false, false, 24));
                }
                b.C0376b.a(bVar3.hOp, b.c.hNH);
            }
            if (this.ugr.ugq <= 0) {
                this.ugr.dfc();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245889);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ugr;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.i ugt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
            super(0);
            this.ugr = bVar;
            this.ugt = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245890);
            Log.i(this.ugr.TAG, "resumeStatus statusResume:" + this.ugr.ugl + ",lotteryInfo:" + this.ugt);
            if (this.ugt.tWe != null && !this.ugr.ugl) {
                this.ugr.ugl = true;
                g a2 = b.a(this.ugr, this.ugt);
                a2.uhF = true;
                Log.i(this.ugr.TAG, "resumeStatus ".concat(String.valueOf(a2)));
                b.a(this.ugr, a2.uhB, a2.uhC, a2.uhE, a2.uhF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245890);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ugr;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.i ugt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(b bVar, com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
            super(0);
            this.ugr = bVar;
            this.ugt = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245895);
            if (this.ugt.tWe != null) {
                g a2 = b.a(this.ugr, this.ugt);
                Log.i(this.ugr.TAG, "updateStatus ".concat(String.valueOf(a2)));
                if (a2.uhB) {
                    b.a(this.ugr, a2.uhB, a2.uhC, a2.uhE, a2.uhF);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245895);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.AbstractC1176a
    public final void deZ() {
        s finderLiveAssistant;
        String str;
        awi awi;
        String str2;
        AppMethodBeat.i(245903);
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.liveData.uEa;
        if (iVar != null && iVar.uhD == 3) {
            com.tencent.mm.live.c.b bVar = this.hOp;
            b.c cVar = b.c.hNE;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
            bVar.statusChange(cVar, bundle);
        } else if (this.hOp instanceof FinderBaseLivePluginLayout) {
            com.tencent.mm.live.c.b bVar2 = this.hOp;
            if (!(bVar2 instanceof FinderBaseLivePluginLayout)) {
                bVar2 = null;
            }
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) bVar2;
            if (!(finderBaseLivePluginLayout == null || (finderLiveAssistant = finderBaseLivePluginLayout.getFinderLiveAssistant()) == null)) {
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.liveData.uEa;
                if (iVar2 == null || (awi = iVar2.tWe) == null || (str2 = awi.id) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                finderLiveAssistant.a(str, (com.tencent.mm.bw.b) null, new C1177b(this));
            }
        }
        if (this.hOp.getLiveRole() == 1) {
            k kVar = k.vkd;
            k.a(s.f.CLICK_LUCKY_BAG, "");
            AppMethodBeat.o(245903);
            return;
        }
        if (this.hOp.getLiveRole() == 0) {
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.CLICK_LUCKY_BAG, "");
        }
        AppMethodBeat.o(245903);
    }

    public static final /* synthetic */ g a(b bVar, com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
        String str;
        boolean z;
        int i2;
        int i3;
        int i4;
        awi awi;
        boolean z2;
        boolean z3;
        awi awi2;
        awi awi3;
        awi awi4;
        boolean z4 = false;
        AppMethodBeat.i(245907);
        g gVar = new g((byte) 0);
        String str2 = (iVar == null || (awi4 = iVar.tWe) == null) ? null : awi4.id;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = bVar.liveData.uEa;
        if (iVar2 == null || (awi3 = iVar2.tWe) == null) {
            str = null;
        } else {
            str = awi3.id;
        }
        if (bVar.liveData.uEa != null) {
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || !(!p.j(str2, str))) {
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = bVar.liveData;
                p.h(iVar, "lotteryInfoWrapper");
                com.tencent.mm.ac.d.h(new g.k(gVar2, iVar));
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar3 = bVar.liveData.uEa;
                i3 = (iVar3 == null || (awi2 = iVar3.tWe) == null) ? 0 : awi2.uhE;
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar4 = bVar.liveData.uEa;
                if (iVar4 != null) {
                    i2 = iVar4.uhD;
                } else {
                    i2 = 0;
                }
                if (i3 != i2) {
                    switch (i2) {
                        case 1:
                            z3 = true;
                            break;
                        case 2:
                            if (i3 != 3 && i3 != 4) {
                                z3 = false;
                                break;
                            } else {
                                z3 = true;
                                break;
                            }
                            break;
                        case 3:
                            z3 = false;
                            break;
                    }
                    z = z3;
                    gVar.uhB = z;
                    gVar.uhC = z4;
                    gVar.uhE = i3;
                    gVar.uhD = i2;
                    AppMethodBeat.o(245907);
                    return gVar;
                }
                z3 = false;
                z = z3;
                gVar.uhB = z;
                gVar.uhC = z4;
                gVar.uhE = i3;
                gVar.uhD = i2;
                AppMethodBeat.o(245907);
                return gVar;
            }
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = bVar.liveData;
        p.h(iVar, "lotteryInfoWrapper");
        com.tencent.mm.ac.d.h(new g.f(gVar3, iVar));
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar5 = bVar.liveData.uEa;
        if (iVar5 == null || (awi = iVar5.tWe) == null) {
            i3 = 0;
        } else {
            i3 = awi.uhE;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar6 = bVar.liveData.uEa;
        if (iVar6 != null) {
            i4 = iVar6.uhD;
        } else {
            i4 = 0;
        }
        bVar.ugj = 0;
        i2 = i4;
        z4 = true;
        z = true;
        gVar.uhB = z;
        gVar.uhC = z4;
        gVar.uhE = i3;
        gVar.uhD = i2;
        AppMethodBeat.o(245907);
        return gVar;
    }
}
