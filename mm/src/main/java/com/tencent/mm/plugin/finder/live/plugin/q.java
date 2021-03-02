package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.cgi.m;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u00108\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u00109\u001a\u00020\bH\u0002J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\b\u0010D\u001a\u00020\u001bH\u0016J\b\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020/H\u0002J\u0018\u0010H\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010I\u001a\u00020\u001b2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0010\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\bH\u0002J\u0012\u0010N\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0002J0\u0010O\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002J\u0012\u0010T\u001a\u00020\u001b2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R,\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R,\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_UI", "", "getDONE_UI", "()I", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelBtn", "Landroid/widget/TextView;", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneNobodyAttend", "doneNobodyAttendDesc", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerRv", "Landroid/support/v7/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "runningContainer", "statementTips", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "anchorDoneAction", "anchorLotteryCancelled", "anchorLotteryComputing", "anchorLotteryDone", "anchorLotteryRunning", "lcoalRemainTime", "anchorOpenCard", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneView", "initRunningView", "initView", "onCancelBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "setLotteryDesc", "updateCountDown", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "plugin-finder_release"})
public final class q extends an {
    final String TAG = "FinderLiveLotteryAnchorCardPlugin";
    final com.tencent.mm.live.c.b hOp;
    TextView jCB;
    TextView kaq;
    View qdl;
    private View unA;
    private TextView unB;
    private TextView unC;
    private TextView unD;
    private TextView unE;
    private RecyclerView unF;
    TextView unG;
    private TextView unH;
    com.tencent.mm.plugin.finder.live.view.adapter.f unI;
    boolean unJ;
    final kotlin.g.a.b<awi, x> unK = new c(this);
    final kotlin.g.a.b<awi, x> unL = new d(this);
    final int unt;
    private final int unu = 1;
    final int unv = 10;
    private View unw;
    TextView unx;
    TextView uny;
    private View unz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<awi, x> {
        final /* synthetic */ q unM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(q qVar) {
            super(1);
            this.unM = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(awi awi) {
            String str;
            awi awi2;
            awi awi3;
            awi awi4;
            String str2 = null;
            AppMethodBeat.i(246491);
            awi awi5 = awi;
            p.h(awi5, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.unM.getLiveData().uEa;
            Integer valueOf = iVar != null ? Integer.valueOf(iVar.uhD) : null;
            String str3 = awi5.id;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.unM.getLiveData().uEa;
            if (iVar2 == null || (awi4 = iVar2.tWe) == null) {
                str = null;
            } else {
                str = awi4.id;
            }
            avy avy = this.unM.getLiveData().uEc;
            if (!(avy == null || (awi3 = avy.tWe) == null)) {
                str2 = awi3.id;
            }
            Log.i(this.unM.TAG, "computingAnimCallback,localStatus:" + valueOf + ", callbakcId:" + str3 + ",recordId:" + str2 + ",localId id:" + str);
            if (valueOf != null && valueOf.intValue() == 2) {
                q qVar = this.unM;
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar3 = this.unM.getLiveData().uEa;
                if (!(iVar3 == null || (awi2 = iVar3.tWe) == null)) {
                    awi5 = awi2;
                }
                q.a(qVar, awi5);
            }
            this.unM.O(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.q.c.AnonymousClass1 */
                final /* synthetic */ c unP;

                {
                    this.unP = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(246490);
                    b.C0376b.a(this.unP.unM.hOp, b.c.hNG);
                    x xVar = x.SXb;
                    AppMethodBeat.o(246490);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(246491);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<awi, x> {
        final /* synthetic */ q unM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(q qVar) {
            super(1);
            this.unM = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(awi awi) {
            String str;
            String str2;
            awi awi2;
            awi awi3;
            awi awi4;
            Long l = null;
            AppMethodBeat.i(246493);
            final awi awi5 = awi;
            p.h(awi5, LocaleUtil.ITALIAN);
            avy avy = this.unM.getLiveData().uEc;
            Long valueOf = avy != null ? Long.valueOf(avy.liveId) : null;
            avy avy2 = this.unM.getLiveData().uEc;
            if (avy2 == null || (awi4 = avy2.tWe) == null) {
                str = null;
            } else {
                str = awi4.id;
            }
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.unM.getLiveData().uEa;
            if (iVar == null || (awi3 = iVar.tWe) == null) {
                str2 = null;
            } else {
                str2 = awi3.id;
            }
            Log.i(this.unM.TAG, "doneAnimCallback curRecordLiveId" + valueOf + ",curRecordLotteryId:" + str + ",callbakcId:" + awi5.id + ",localId:" + str2 + ",lottering:" + this.unM.urT);
            awe awe = this.unM.getLiveData().liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            }
            long longValue = l.longValue();
            if (valueOf != null && valueOf.longValue() == longValue) {
                String str3 = str;
                if (!(str3 == null || str3.length() == 0) && p.j(str, str2)) {
                    q.b(this.unM, awi5);
                    x xVar = x.SXb;
                    AppMethodBeat.o(246493);
                    return xVar;
                }
            }
            q qVar = this.unM;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.unM.getLiveData().uEa;
            if (iVar2 == null || (awi2 = iVar2.tWe) == null) {
                awi2 = awi5;
            }
            q.a(qVar, awi2);
            this.unM.O(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.q.d.AnonymousClass1 */
                final /* synthetic */ d unQ;

                {
                    this.unQ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(246492);
                    q.b(this.unQ.unM, awi5);
                    x xVar = x.SXb;
                    AppMethodBeat.o(246492);
                    return xVar;
                }
            });
            x xVar2 = x.SXb;
            AppMethodBeat.o(246493);
            return xVar2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246508);
        this.hOp = bVar;
        AppMethodBeat.o(246508);
    }

    public static final /* synthetic */ void a(q qVar, avy avy) {
        AppMethodBeat.i(246509);
        qVar.a(avy);
        AppMethodBeat.o(246509);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final void initView() {
        TextView textView;
        TextView textView2;
        TextPaint textPaint;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextPaint textPaint2;
        TextView textView6;
        TextPaint textPaint3;
        TextView textView7;
        RecyclerView recyclerView;
        TextView textView8;
        TextView textView9;
        AppMethodBeat.i(246502);
        super.initView();
        this.unw = this.hwr.findViewById(R.id.h9x);
        View view = this.unw;
        this.jCB = view != null ? (TextView) view.findViewById(R.id.bmr) : null;
        View view2 = this.unw;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.bo5);
        } else {
            textView = null;
        }
        this.unx = textView;
        View view3 = this.unw;
        if (view3 != null) {
            textView2 = (TextView) view3.findViewById(R.id.bo0);
        } else {
            textView2 = null;
        }
        this.uny = textView2;
        TextView textView10 = this.uny;
        if (textView10 != null) {
            textPaint = textView10.getPaint();
        } else {
            textPaint = null;
        }
        ao.a(textPaint, 0.8f);
        View view4 = this.unw;
        if (view4 != null) {
            textView3 = (TextView) view4.findViewById(R.id.ai8);
        } else {
            textView3 = null;
        }
        this.kaq = textView3;
        TextView textView11 = this.kaq;
        if (textView11 != null) {
            textView11.setOnClickListener(new f(this));
        }
        this.unz = this.hwr.findViewById(R.id.bt4);
        View view5 = this.unz;
        this.unA = view5 != null ? view5.findViewById(R.id.jo4) : null;
        View view6 = this.unz;
        if (view6 != null) {
            textView4 = (TextView) view6.findViewById(R.id.g09);
        } else {
            textView4 = null;
        }
        this.unC = textView4;
        View view7 = this.unz;
        if (view7 != null) {
            textView5 = (TextView) view7.findViewById(R.id.g08);
        } else {
            textView5 = null;
        }
        this.unB = textView5;
        TextView textView12 = this.unB;
        if (textView12 != null) {
            textPaint2 = textView12.getPaint();
        } else {
            textPaint2 = null;
        }
        ao.a(textPaint2, 0.8f);
        View view8 = this.unz;
        if (view8 != null) {
            textView6 = (TextView) view8.findViewById(R.id.jo3);
        } else {
            textView6 = null;
        }
        this.unD = textView6;
        TextView textView13 = this.unD;
        if (textView13 != null) {
            textPaint3 = textView13.getPaint();
        } else {
            textPaint3 = null;
        }
        ao.a(textPaint3, 0.8f);
        View view9 = this.unz;
        if (view9 != null) {
            textView7 = (TextView) view9.findViewById(R.id.iu9);
        } else {
            textView7 = null;
        }
        this.unE = textView7;
        View view10 = this.unz;
        if (view10 != null) {
            recyclerView = (RecyclerView) view10.findViewById(R.id.jo8);
        } else {
            recyclerView = null;
        }
        this.unF = recyclerView;
        this.unI = new com.tencent.mm.plugin.finder.live.view.adapter.f(getLiveData());
        RecyclerView recyclerView2 = this.unF;
        if (recyclerView2 != null) {
            this.hwr.getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
            recyclerView2.setAdapter(this.unI);
            recyclerView2.a(new e(this));
        }
        View view11 = this.unz;
        this.qdl = view11 != null ? view11.findViewById(R.id.jo5) : null;
        View view12 = this.unz;
        if (view12 != null) {
            textView8 = (TextView) view12.findViewById(R.id.ep1);
        } else {
            textView8 = null;
        }
        this.unG = textView8;
        View view13 = this.unz;
        if (view13 != null) {
            textView9 = (TextView) view13.findViewById(R.id.i53);
        } else {
            textView9 = null;
        }
        this.unH = textView9;
        AppMethodBeat.o(246502);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ q unM;

        f(q qVar) {
            this.unM = qVar;
        }

        public final void onClick(View view) {
            Long l;
            int i2;
            awi awi;
            awi awi2;
            awg awg;
            AppMethodBeat.i(246496);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q qVar = this.unM;
            awe awe = qVar.getLiveData().liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            } else {
                l = null;
            }
            long longValue = l.longValue();
            long j2 = qVar.getLiveData().hFK;
            String str = qVar.getLiveData().hwg;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = qVar.getLiveData().uEa;
            if (iVar == null || (awi2 = iVar.tWe) == null || (awg = awi2.LGn) == null) {
                i2 = 0;
            } else {
                i2 = awg.LGY;
            }
            m.b bVar2 = m.ukW;
            int i3 = m.ukV;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = qVar.getLiveData().uEa;
            new m(longValue, j2, str, 0, "", i2, "", i3, (iVar2 == null || (awi = iVar2.tWe) == null) ? 0 : awi.ugF, new g(qVar)).aYI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246496);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        final /* synthetic */ q unM;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(246495);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(246495);
        }

        e(q qVar) {
            this.unM = qVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Integer num;
            awk awk;
            LinkedList<awh> linkedList;
            awi awi;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(246494);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(recyclerView);
            bVar2.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar2.axR());
            p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(246494);
                throw tVar;
            }
            int kv = ((LinearLayoutManager) layoutManager).kv();
            q qVar = this.unM;
            com.tencent.mm.plugin.finder.live.view.adapter.f fVar = qVar.unI;
            if (fVar != null) {
                avy avy = qVar.getLiveData().uEc;
                if (avy == null || avy.continueFlag != 1 || kv < 0 || kv < fVar.getItemCount() - qVar.unv) {
                    qVar.Jk(8);
                } else {
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar = qVar.getLiveData().uEa;
                    String str = (iVar == null || (awi = iVar.tWe) == null) ? null : awi.id;
                    if (!qVar.unJ && str != null) {
                        String str2 = qVar.TAG;
                        StringBuilder sb = new StringBuilder("load more product,product size:");
                        avy avy2 = qVar.getLiveData().uEc;
                        if (avy2 == null || (awk = avy2.LGt) == null || (linkedList = awk.LHf) == null) {
                            num = null;
                        } else {
                            num = Integer.valueOf(linkedList.size());
                        }
                        Log.i(str2, sb.append(num).toString());
                        qVar.unJ = true;
                        qVar.Jk(0);
                        o oVar = o.ujN;
                        s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            avy avy3 = qVar.getLiveData().uEc;
                            if (avy3 != null) {
                                bVar = avy3.lastBuffer;
                            }
                            finderLiveAssistant.a(str, bVar, new b(qVar, kv));
                        }
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(246494);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final void a(boolean z, com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
        AppMethodBeat.i(246504);
        p.h(iVar, "lotteryInfoWrapper");
        super.a(z, iVar);
        com.tencent.mm.ac.d.h(new a(this, iVar, z));
        AppMethodBeat.o(246504);
    }

    /* access modifiers changed from: package-private */
    public final void m(TextView textView) {
        awi awi;
        String str;
        String str2;
        int i2;
        Integer num;
        boolean z;
        awg awg;
        awg awg2;
        AppMethodBeat.i(246505);
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = getLiveData().uEa;
        if (iVar != null) {
            awi = iVar.tWe;
        } else {
            awi = null;
        }
        if (awi != null) {
            str = awi.description;
        } else {
            str = null;
        }
        if (awi == null || (awg2 = awi.LGn) == null) {
            str2 = null;
        } else {
            str2 = awg2.LGZ;
        }
        if (awi != null) {
            i2 = awi.ugF;
        } else {
            i2 = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str + '\n');
        }
        if (awi == null || (awg = awi.LGn) == null) {
            num = null;
        } else {
            num = Integer.valueOf(awg.LGY);
        }
        if (num != null && num.intValue() == 1) {
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                StringBuilder sb2 = new StringBuilder();
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                sb.append(sb2.append(context.getResources().getString(R.string.cux)).append((char) 65292).toString());
            } else if (str2 != null) {
                StringBuilder sb3 = new StringBuilder();
                ae aeVar = ae.SYK;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                String string = context2.getResources().getString(R.string.cuw);
                p.g(string, "root.context.resources.g…ottery_card_desc_comment)");
                String format = String.format(string, Arrays.copyOf(new Object[]{str2}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                sb.append(sb3.append(format).append((char) 65292).toString());
            }
        } else if (num != null && num.intValue() == 2) {
            StringBuilder sb4 = new StringBuilder();
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            sb.append(sb4.append(context3.getResources().getString(R.string.cvo)).append((char) 65292).toString());
        }
        if (i2 > 0) {
            ae aeVar2 = ae.SYK;
            Context context4 = this.hwr.getContext();
            p.g(context4, "root.context");
            String string2 = context4.getResources().getString(R.string.cv5);
            p.g(string2, "root.context.resources.g…e_lottery_desc_winnercnt)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            sb.append(String.valueOf(format2));
            if (textView != null) {
                textView.setText(sb.toString());
            }
            if (textView != null) {
                textView.setVisibility(0);
                AppMethodBeat.o(246505);
                return;
            }
            AppMethodBeat.o(246505);
            return;
        }
        Log.i(this.TAG, "setLotteryDesc winnerCnt:".concat(String.valueOf(i2)));
        if (textView != null) {
            textView.setVisibility(8);
            AppMethodBeat.o(246505);
            return;
        }
        AppMethodBeat.o(246505);
    }

    /* access modifiers changed from: package-private */
    public final void Jk(int i2) {
        AppMethodBeat.i(246506);
        com.tencent.mm.ac.d.h(new j(this, i2));
        AppMethodBeat.o(246506);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class b implements o.a {
        final /* synthetic */ q unM;
        final /* synthetic */ int unO;

        b(q qVar, int i2) {
            this.unM = qVar;
            this.unO = i2;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(246489);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.unM.getLiveData().a(avy.tWe);
                this.unM.getLiveData().d(avy);
                q.a(this.unM);
            }
            this.unM.Jk(8);
            this.unM.unJ = false;
            AppMethodBeat.o(246489);
        }
    }

    private final void a(avy avy) {
        LinkedList<awh> linkedList;
        awk awk;
        AppMethodBeat.i(246507);
        awi awi = avy != null ? avy.tWe : null;
        if (awi != null) {
            TextView textView = this.unD;
            if (textView != null) {
                ae aeVar = ae.SYK;
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                String string = context.getResources().getString(R.string.cw1);
                p.g(string, "root.context.resources.g…ive_lottery_winner_count)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(awi.LHc)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
            }
            TextView textView2 = this.unE;
            if (textView2 != null) {
                ae aeVar2 = ae.SYK;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                String string2 = context2.getResources().getString(R.string.cvs);
                p.g(string2, "root.context.resources.g…ottery_participate_count)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(awi.trl)}, 1));
                p.g(format2, "java.lang.String.format(format, *args)");
                textView2.setText(format2);
            }
        } else {
            Log.e(this.TAG, "updateWinnerList error lotteryInfo is empty!");
        }
        com.tencent.mm.plugin.finder.live.view.adapter.f fVar = this.unI;
        if (fVar != null) {
            if (avy == null || (awk = avy.LGt) == null) {
                linkedList = null;
            } else {
                linkedList = awk.LHf;
            }
            fVar.an(linkedList);
        }
        com.tencent.mm.plugin.finder.live.view.adapter.f fVar2 = this.unI;
        if (fVar2 != null) {
            fVar2.notifyDataSetChanged();
            AppMethodBeat.o(246507);
            return;
        }
        AppMethodBeat.o(246507);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class i implements o.a {
        final /* synthetic */ q unM;
        final /* synthetic */ String unU;

        i(q qVar, String str) {
            this.unM = qVar;
            this.unU = str;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(246500);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.unM.getLiveData().a(avy.tWe);
                this.unM.getLiveData().d(avy);
                q.a(this.unM);
            }
            AppMethodBeat.o(246500);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$onCancelBtnClick$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
    public static final class g implements m.a {
        final /* synthetic */ q unM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(q qVar) {
            this.unM = qVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.m.a
        public final void a(int i2, int i3, String str, avp avp) {
            AppMethodBeat.i(246498);
            p.h(avp, "resp");
            com.tencent.mm.ac.d.h(new a(this, i2, i3, avp));
            AppMethodBeat.o(246498);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ int $errType;
            final /* synthetic */ g unS;
            final /* synthetic */ avp unT;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(g gVar, int i2, int i3, avp avp) {
                super(0);
                this.unS = gVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.unT = avp;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                String string;
                AppMethodBeat.i(246497);
                if (this.$errType == 0 && this.$errCode == 0) {
                    if (this.unT.tWe == null) {
                        com.tencent.mm.ac.d.h(new g.b(this.unS.unM.getLiveData()));
                    } else {
                        this.unS.unM.getLiveData().a(this.unT.tWe);
                    }
                    b.C0376b.a(this.unS.unM.hOp, b.c.hNB);
                    Context context = this.unS.unM.hwr.getContext();
                    p.g(context, "root.context");
                    string = context.getResources().getString(R.string.cuv);
                    p.g(string, "root.context.resources.g…r_live_lottery_cancelled)");
                    if (this.unS.unM.hOp.getLiveRole() == 1) {
                        k kVar = k.vkd;
                        k.a(s.f.CANCEL_LOTTERY, "");
                    }
                } else {
                    Context context2 = this.unS.unM.hwr.getContext();
                    p.g(context2, "root.context");
                    string = context2.getResources().getString(R.string.cuu);
                    p.g(string, "root.context.resources.g…live_lottery_cancel_fail)");
                }
                u.makeText(this.unS.unM.hwr.getContext(), string, 0).show();
                x xVar = x.SXb;
                AppMethodBeat.o(246497);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int uhP;
        final /* synthetic */ q unM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(q qVar, int i2) {
            super(0);
            this.unM = qVar;
            this.uhP = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246501);
            View view = this.unM.qdl;
            if (view != null) {
                view.setVisibility(this.uhP);
            }
            TextView textView = this.unM.unG;
            if (textView != null) {
                textView.setVisibility(this.uhP);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246501);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success = true;
        final /* synthetic */ q unM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(q qVar) {
            super(0);
            this.unM = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            avy avy;
            awk awk;
            LinkedList<awh> linkedList;
            AppMethodBeat.i(246499);
            String str = this.unM.TAG;
            StringBuilder append = new StringBuilder("load more winner finish,success:").append(this.$success).append(",product size:");
            avy avy2 = this.unM.getLiveData().uEc;
            Log.i(str, append.append((avy2 == null || (awk = avy2.LGt) == null || (linkedList = awk.LHf) == null) ? null : Integer.valueOf(linkedList.size())).toString());
            if (this.$success && (avy = this.unM.getLiveData().uEc) != null) {
                q.a(this.unM, avy);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246499);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.i ugt;
        final /* synthetic */ q unM;
        final /* synthetic */ boolean unN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar, com.tencent.mm.plugin.finder.live.viewmodel.i iVar, boolean z) {
            super(0);
            this.unM = qVar;
            this.ugt = iVar;
            this.unN = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            int i2;
            String str2 = null;
            AppMethodBeat.i(246488);
            awi awi = this.ugt.tWe;
            if (awi != null) {
                int i3 = this.ugt.uhD;
                int i4 = this.ugt.uFr;
                String str3 = this.unM.TAG;
                StringBuilder sb = new StringBuilder("anchorOpenCard id:");
                if (awi != null) {
                    str = awi.id;
                } else {
                    str = null;
                }
                Log.i(str3, sb.append(str).append(", status:").append(i3).append(",statusChange:").append(this.unN).append(",haveLottering:").append(this.ugt.uFs).append(",,localRemainTime:").append(i4).toString());
                switch (i3) {
                    case 1:
                        this.unM.Jj(this.unM.unt);
                        q qVar = this.unM;
                        qVar.m(qVar.jCB);
                        int i5 = awi.LHa;
                        int i6 = awi.iqg;
                        int i7 = awi.LHb;
                        int i8 = awi.trl;
                        if (i4 < 0 || i4 >= i6 - i5) {
                            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                            i2 = com.tencent.mm.plugin.finder.utils.m.ag(i5, i6, i7);
                        } else {
                            i2 = i4;
                        }
                        TextView textView = qVar.unx;
                        if (textView != null) {
                            ae aeVar = ae.SYK;
                            Context context = qVar.hwr.getContext();
                            p.g(context, "root.context");
                            String string = context.getResources().getString(R.string.cv1);
                            p.g(string, "root.context.resources.g…r_live_lottery_countdown)");
                            u.a aVar = com.tencent.mm.live.b.u.hIn;
                            String format = String.format(string, Arrays.copyOf(new Object[]{u.a.a(i2, ":", false, false, false, 24)}, 1));
                            p.g(format, "java.lang.String.format(format, *args)");
                            textView.setText(format);
                        }
                        if (i8 > 0) {
                            TextView textView2 = qVar.uny;
                            if (textView2 != null) {
                                ae aeVar2 = ae.SYK;
                                Context context2 = qVar.hwr.getContext();
                                p.g(context2, "root.context");
                                String string2 = context2.getResources().getString(R.string.cup);
                                p.g(string2, "root.context.resources.g…nder_live_lottery_attend)");
                                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i8)}, 1));
                                p.g(format2, "java.lang.String.format(format, *args)");
                                textView2.setText(format2);
                            }
                        } else {
                            TextView textView3 = qVar.uny;
                            if (textView3 != null) {
                                Context context3 = qVar.hwr.getContext();
                                p.g(context3, "root.context");
                                textView3.setText(context3.getResources().getString(R.string.cvq));
                            }
                        }
                        if (awi.trl > 0) {
                            TextView textView4 = qVar.kaq;
                            if (textView4 != null) {
                                textView4.setVisibility(8);
                            }
                        } else {
                            TextView textView5 = qVar.kaq;
                            if (textView5 != null) {
                                textView5.setVisibility(0);
                            }
                        }
                        this.unM.rg(0);
                        break;
                    case 2:
                        this.unM.a(this.ugt, awi, i3, this.unM.unK);
                        break;
                    case 3:
                        this.unM.a(this.ugt, awi, i3, this.unM.unL);
                        break;
                    case 4:
                        String str4 = this.unM.TAG;
                        StringBuilder sb2 = new StringBuilder("anchorLotteryCancelled id:");
                        if (awi != null) {
                            str2 = awi.id;
                        }
                        Log.i(str4, sb2.append(str2).toString());
                        this.unM.rg(8);
                        break;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246488);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void Jj(int i2) {
        AppMethodBeat.i(246503);
        Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(i2)));
        if (i2 == this.unu) {
            View view = this.unw;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.unz;
            if (view2 != null) {
                view2.setVisibility(0);
                AppMethodBeat.o(246503);
                return;
            }
            AppMethodBeat.o(246503);
            return;
        }
        View view3 = this.unw;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.unz;
        if (view4 != null) {
            view4.setVisibility(8);
            AppMethodBeat.o(246503);
            return;
        }
        AppMethodBeat.o(246503);
    }

    public static final /* synthetic */ void a(q qVar) {
        AppMethodBeat.i(246510);
        com.tencent.mm.ac.d.h(new h(qVar));
        AppMethodBeat.o(246510);
    }

    public static final /* synthetic */ void a(q qVar, awi awi) {
        TextView textView;
        AppMethodBeat.i(246511);
        qVar.Jj(qVar.unt);
        String str = awi.description;
        if (!(str == null || (textView = qVar.jCB) == null)) {
            textView.setText(str);
        }
        TextView textView2 = qVar.unx;
        if (textView2 != null) {
            Context context = qVar.hwr.getContext();
            p.g(context, "root.context");
            textView2.setText(context.getResources().getString(R.string.cum));
        }
        if (awi.trl > 0) {
            TextView textView3 = qVar.uny;
            if (textView3 != null) {
                ae aeVar = ae.SYK;
                Context context2 = qVar.hwr.getContext();
                p.g(context2, "root.context");
                String string = context2.getResources().getString(R.string.cup);
                p.g(string, "root.context.resources.g…nder_live_lottery_attend)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(awi.trl)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                textView3.setText(format);
            }
        } else {
            TextView textView4 = qVar.uny;
            if (textView4 != null) {
                Context context3 = qVar.hwr.getContext();
                p.g(context3, "root.context");
                textView4.setText(context3.getResources().getString(R.string.cvq));
            }
        }
        TextView textView5 = qVar.kaq;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        qVar.rg(0);
        View view = qVar.urV;
        if (view != null) {
            view.setVisibility(0);
            AppMethodBeat.o(246511);
            return;
        }
        AppMethodBeat.o(246511);
    }

    public static final /* synthetic */ void b(q qVar, awi awi) {
        int i2;
        String str;
        awi awi2;
        awk awk;
        LinkedList<awh> linkedList;
        awi awi3;
        com.tencent.mm.bw.b bVar = null;
        AppMethodBeat.i(246512);
        if (qVar.getLiveData().isLiveStarted()) {
            qVar.Jj(qVar.unu);
            avy avy = qVar.getLiveData().uEc;
            if (!(avy == null || (awi3 = avy.tWe) == null)) {
                awi = awi3;
            }
            if (awi.trl > 0) {
                TextView textView = qVar.unC;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = qVar.unB;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                View view = qVar.unA;
                if (view != null) {
                    view.setVisibility(0);
                }
                TextView textView3 = qVar.unD;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = qVar.unE;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                RecyclerView recyclerView = qVar.unF;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                avy avy2 = qVar.getLiveData().uEc;
                if (avy2 == null || (awk = avy2.LGt) == null || (linkedList = awk.LHf) == null) {
                    i2 = 0;
                } else {
                    i2 = linkedList.size();
                }
                Log.i(qVar.TAG, "parseWinnerList winnerListSize:".concat(String.valueOf(i2)));
                if (i2 > 0) {
                    qVar.a(avy2);
                } else {
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar = qVar.getLiveData().uEa;
                    if (iVar == null || (awi2 = iVar.tWe) == null) {
                        str = null;
                    } else {
                        str = awi2.id;
                    }
                    Log.i(qVar.TAG, "parseWinnerList record is empty!lotteryId:".concat(String.valueOf(str)));
                    if (str != null) {
                        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            avy avy3 = qVar.getLiveData().uEc;
                            if (avy3 != null) {
                                bVar = avy3.lastBuffer;
                            }
                            finderLiveAssistant.a(str, bVar, new i(qVar, str));
                        }
                    }
                }
                TextView textView5 = qVar.unH;
                if (textView5 != null) {
                    Context context = qVar.hwr.getContext();
                    p.g(context, "root.context");
                    textView5.setText(context.getResources().getString(R.string.cvv));
                }
            } else {
                qVar.m(qVar.unC);
                TextView textView6 = qVar.unB;
                if (textView6 != null) {
                    Context context2 = qVar.hwr.getContext();
                    p.g(context2, "root.context");
                    textView6.setText(context2.getResources().getString(R.string.cvr));
                }
                TextView textView7 = qVar.unB;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                View view2 = qVar.unA;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView8 = qVar.unD;
                if (textView8 != null) {
                    textView8.setVisibility(8);
                }
                TextView textView9 = qVar.unE;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                RecyclerView recyclerView2 = qVar.unF;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                }
                TextView textView10 = qVar.unH;
                if (textView10 != null) {
                    Context context3 = qVar.hwr.getContext();
                    p.g(context3, "root.context");
                    textView10.setText(context3.getResources().getString(R.string.cvz));
                }
            }
            View view3 = qVar.urV;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            qVar.rg(0);
            AppMethodBeat.o(246512);
            return;
        }
        qVar.rg(8);
        Log.i(qVar.TAG, "anchorDoneAction liveStatus:" + qVar.getLiveData().uEg);
        AppMethodBeat.o(246512);
    }
}
