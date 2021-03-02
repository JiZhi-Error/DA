package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010H\u001a\u00020#H\u0016J\u0010\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020\bH\u0002J\u0010\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\bH\u0002J\b\u0010M\u001a\u00020#H\u0002J\b\u0010N\u001a\u00020#H\u0002J\b\u0010O\u001a\u00020#H\u0016J\b\u0010P\u001a\u00020#H\u0002J\b\u0010Q\u001a\u00020=H\u0002J\b\u0010R\u001a\u00020#H\u0002J\u0010\u0010S\u001a\u00020#2\u0006\u0010T\u001a\u00020=H\u0002J\u0018\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020=2\u0006\u0010W\u001a\u00020XH\u0016J\u0012\u0010Y\u001a\u00020#2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0010\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020\bH\u0002J0\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\bH\u0002J\u0012\u0010d\u001a\u00020#2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0010\u0010e\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010f\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010g\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010h\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010i\u001a\u00020=H\u0002J\u0012\u0010j\u001a\u00020#2\b\b\u0002\u0010k\u001a\u00020=H\u0002J\u0018\u0010l\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\bH\u0002J\u0018\u0010m\u001a\u00020#2\u0006\u0010V\u001a\u00020=2\u0006\u0010W\u001a\u00020XH\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R,\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R,\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_NO_WIN_UI", "", "getDONE_NO_WIN_UI", "()I", "DONE_WINNER_LIST_UI", "getDONE_WINNER_LIST_UI", "DONE_WIN_UI", "getDONE_WIN_UI", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "UNDEFINE_UI", "getUNDEFINE_UI", "attendBtn", "Landroid/widget/TextView;", "attendedBtn", "chaseWayTip", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "curLotteryUIState", "getCurLotteryUIState", "setCurLotteryUIState", "(I)V", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneLotteryBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "doneNoWin", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerLotteryResultContainer", "doneWinnerRv", "Landroid/support/v7/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "lotteryArrow", "lotteryDetail", "lotteryDetailContainer", "runningContainer", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "winnerAvatar", "Landroid/widget/ImageView;", "winnerNickname", "winnerTips", "changeToUnvisible", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneDetailView", "initRunningView", "initView", "initWinnerListView", "isDoneUIShowing", "onAttendBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "updateCountDown", "localRemainTime", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "visitorDoneAction", "visitorLotteryCancelled", "visitorLotteryComputing", "visitorLotteryDone", "fromUpdate", "visitorLotteryDoneWinnerList", "showBackIcon", "visitorLotteryRunning", "visitorOpenCard", "plugin-finder_release"})
public final class by extends an {
    final String TAG = "FinderLiveLotteryVisitorCardPlugin";
    final com.tencent.mm.live.c.b hOp;
    TextView jCB;
    View qdl;
    private View unA;
    private TextView unD;
    private TextView unE;
    private RecyclerView unF;
    TextView unG;
    com.tencent.mm.plugin.finder.live.view.adapter.f unI;
    boolean unJ;
    final kotlin.g.a.b<awi, x> unK = new b(this);
    final kotlin.g.a.b<awi, x> unL = new c(this);
    final int unt;
    final int unv = 10;
    private View unw;
    TextView unx;
    TextView uny;
    private View unz;
    private final int uvA = 3;
    private volatile int uvB = this.uvx;
    TextView uvC;
    TextView uvD;
    WeImageView uvE;
    private View uvF;
    private TextView uvG;
    private TextView uvH;
    private ImageView uvI;
    private TextView uvJ;
    private TextView uvK;
    View uvL;
    private TextView uvM;
    private View uvN;
    private final int uvx = -1;
    private final int uvy = 1;
    private final int uvz = 2;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<awi, x> {
        final /* synthetic */ by uvO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(by byVar) {
            super(1);
            this.uvO = byVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(awi awi) {
            awi awi2;
            Integer num;
            String str;
            awi awi3;
            String str2 = null;
            AppMethodBeat.i(247179);
            awi awi4 = awi;
            p.h(awi4, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.uvO.getLiveData().uEa;
            if (iVar != null) {
                awi2 = iVar.tWe;
            } else {
                awi2 = null;
            }
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.uvO.getLiveData().uEa;
            if (iVar2 != null) {
                num = Integer.valueOf(iVar2.uhD);
            } else {
                num = null;
            }
            String str3 = awi4.id;
            if (awi2 != null) {
                str = awi2.id;
            } else {
                str = null;
            }
            avy avy = this.uvO.getLiveData().uEc;
            if (!(avy == null || (awi3 = avy.tWe) == null)) {
                str2 = awi3.id;
            }
            Log.i(this.uvO.TAG, "computingAnimCallback,localStatus:" + num + ", callbakcId:" + str3 + ",localId:" + str + ",recordId:" + str2);
            if (num != null && num.intValue() == 2) {
                by byVar = this.uvO;
                if (awi2 != null) {
                    awi4 = awi2;
                }
                by.a(byVar, awi4);
            }
            this.uvO.O(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.by.b.AnonymousClass1 */
                final /* synthetic */ b uvP;

                {
                    this.uvP = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247178);
                    b.C0376b.a(this.uvP.uvO.hOp, b.c.hNG);
                    x xVar = x.SXb;
                    AppMethodBeat.o(247178);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247179);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<awi, x> {
        final /* synthetic */ by uvO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(by byVar) {
            super(1);
            this.uvO = byVar;
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
            AppMethodBeat.i(247181);
            final awi awi5 = awi;
            p.h(awi5, LocaleUtil.ITALIAN);
            avy avy = this.uvO.getLiveData().uEc;
            Long valueOf = avy != null ? Long.valueOf(avy.liveId) : null;
            avy avy2 = this.uvO.getLiveData().uEc;
            if (avy2 == null || (awi4 = avy2.tWe) == null) {
                str = null;
            } else {
                str = awi4.id;
            }
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.uvO.getLiveData().uEa;
            if (iVar == null || (awi3 = iVar.tWe) == null) {
                str2 = null;
            } else {
                str2 = awi3.id;
            }
            Log.i(this.uvO.TAG, "doneAnimCallback curRecordLiveId" + valueOf + ",curRecordLotteryId:" + str + ",callbakcId:" + awi5.id + ",localId:" + str2 + ",lottering:" + this.uvO.urT);
            awe awe = this.uvO.getLiveData().liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            }
            long longValue = l.longValue();
            if (valueOf != null && valueOf.longValue() == longValue) {
                String str3 = str;
                if (!(str3 == null || str3.length() == 0) && p.j(str, str2)) {
                    by.b(this.uvO, awi5);
                    x xVar = x.SXb;
                    AppMethodBeat.o(247181);
                    return xVar;
                }
            }
            by byVar = this.uvO;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = this.uvO.getLiveData().uEa;
            if (iVar2 == null || (awi2 = iVar2.tWe) == null) {
                awi2 = awi5;
            }
            by.a(byVar, awi2);
            this.uvO.O(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.by.c.AnonymousClass1 */
                final /* synthetic */ c uvQ;

                {
                    this.uvQ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247180);
                    by.b(this.uvQ.uvO, awi5);
                    x xVar = x.SXb;
                    AppMethodBeat.o(247180);
                    return xVar;
                }
            });
            x xVar2 = x.SXb;
            AppMethodBeat.o(247181);
            return xVar2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public by(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247203);
        this.hOp = bVar;
        AppMethodBeat.o(247203);
    }

    public static final /* synthetic */ void a(by byVar, avy avy) {
        AppMethodBeat.i(247205);
        byVar.a(avy);
        AppMethodBeat.o(247205);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final void initView() {
        TextPaint textPaint;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        WeImageView weImageView;
        TextView textView5;
        TextPaint textPaint2;
        TextView textView6;
        RecyclerView recyclerView;
        TextView textView7;
        TextView textView8;
        TextPaint textPaint3;
        TextView textView9;
        TextPaint textPaint4;
        ImageView imageView;
        TextView textView10;
        TextView textView11;
        View view;
        View view2 = null;
        AppMethodBeat.i(247194);
        super.initView();
        this.unw = this.hwr.findViewById(R.id.h9x);
        View view3 = this.unw;
        this.jCB = view3 != null ? (TextView) view3.findViewById(R.id.bmr) : null;
        TextView textView12 = this.jCB;
        if (textView12 != null) {
            textPaint = textView12.getPaint();
        } else {
            textPaint = null;
        }
        ao.a(textPaint, 0.8f);
        View view4 = this.unw;
        if (view4 != null) {
            textView = (TextView) view4.findViewById(R.id.bo5);
        } else {
            textView = null;
        }
        this.unx = textView;
        View view5 = this.unw;
        if (view5 != null) {
            textView2 = (TextView) view5.findViewById(R.id.bo0);
        } else {
            textView2 = null;
        }
        this.uny = textView2;
        View view6 = this.unw;
        if (view6 != null) {
            textView3 = (TextView) view6.findViewById(R.id.dnc);
        } else {
            textView3 = null;
        }
        this.uvD = textView3;
        View view7 = this.unw;
        if (view7 != null) {
            textView4 = (TextView) view7.findViewById(R.id.ve);
        } else {
            textView4 = null;
        }
        this.uvC = textView4;
        TextView textView13 = this.uvC;
        if (textView13 != null) {
            textView13.setOnClickListener(new f(this));
        }
        this.unz = this.hwr.findViewById(R.id.bt4);
        View view8 = this.unz;
        this.unA = view8 != null ? view8.findViewById(R.id.jo4) : null;
        View view9 = this.unA;
        if (view9 != null) {
            weImageView = (WeImageView) view9.findViewById(R.id.et8);
        } else {
            weImageView = null;
        }
        this.uvE = weImageView;
        WeImageView weImageView2 = this.uvE;
        if (weImageView2 != null) {
            weImageView2.setVisibility(0);
        }
        WeImageView weImageView3 = this.uvE;
        if (weImageView3 != null) {
            weImageView3.post(new h(this));
        }
        WeImageView weImageView4 = this.uvE;
        if (weImageView4 != null) {
            weImageView4.setOnClickListener(new i(this));
        }
        View view10 = this.unA;
        if (view10 != null) {
            textView5 = (TextView) view10.findViewById(R.id.jo3);
        } else {
            textView5 = null;
        }
        this.unD = textView5;
        TextView textView14 = this.unD;
        if (textView14 != null) {
            textPaint2 = textView14.getPaint();
        } else {
            textPaint2 = null;
        }
        ao.a(textPaint2, 0.8f);
        View view11 = this.unA;
        if (view11 != null) {
            textView6 = (TextView) view11.findViewById(R.id.iu9);
        } else {
            textView6 = null;
        }
        this.unE = textView6;
        View view12 = this.unA;
        if (view12 != null) {
            recyclerView = (RecyclerView) view12.findViewById(R.id.jo8);
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
            recyclerView2.a(new g(this));
        }
        View view13 = this.unA;
        this.qdl = view13 != null ? view13.findViewById(R.id.jo5) : null;
        View view14 = this.unA;
        if (view14 != null) {
            textView7 = (TextView) view14.findViewById(R.id.ep1);
        } else {
            textView7 = null;
        }
        this.unG = textView7;
        View view15 = this.unz;
        this.uvF = view15 != null ? view15.findViewById(R.id.etr) : null;
        View view16 = this.uvF;
        if (view16 != null) {
            textView8 = (TextView) view16.findViewById(R.id.g06);
        } else {
            textView8 = null;
        }
        this.uvG = textView8;
        TextView textView15 = this.uvG;
        if (textView15 != null) {
            textPaint3 = textView15.getPaint();
        } else {
            textPaint3 = null;
        }
        ao.a(textPaint3, 0.8f);
        View view17 = this.uvF;
        if (view17 != null) {
            textView9 = (TextView) view17.findViewById(R.id.jo9);
        } else {
            textView9 = null;
        }
        this.uvH = textView9;
        TextView textView16 = this.uvH;
        if (textView16 != null) {
            textPaint4 = textView16.getPaint();
        } else {
            textPaint4 = null;
        }
        ao.a(textPaint4, 0.8f);
        View view18 = this.uvF;
        if (view18 != null) {
            imageView = (ImageView) view18.findViewById(R.id.jo1);
        } else {
            imageView = null;
        }
        this.uvI = imageView;
        View view19 = this.uvF;
        if (view19 != null) {
            textView10 = (TextView) view19.findViewById(R.id.jo6);
        } else {
            textView10 = null;
        }
        this.uvJ = textView10;
        View view20 = this.uvF;
        if (view20 != null) {
            textView11 = (TextView) view20.findViewById(R.id.ar7);
        } else {
            textView11 = null;
        }
        this.uvK = textView11;
        View view21 = this.uvF;
        if (view21 != null) {
            view = view21.findViewById(R.id.etc);
        } else {
            view = null;
        }
        this.uvL = view;
        View view22 = this.uvL;
        if (view22 != null) {
            view22.post(new d(this));
        }
        View view23 = this.uvL;
        if (view23 != null) {
            view23.setOnClickListener(new e(this));
        }
        View view24 = this.uvF;
        this.uvM = view24 != null ? (TextView) view24.findViewById(R.id.etb) : null;
        View view25 = this.uvF;
        if (view25 != null) {
            view2 = view25.findViewById(R.id.et7);
        }
        this.uvN = view2;
        AppMethodBeat.o(247194);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ by uvO;

        f(by byVar) {
            this.uvO = byVar;
        }

        public final void onClick(View view) {
            awi awi;
            awg awg;
            Integer num;
            awi awi2;
            awg awg2;
            awi awi3;
            awg awg3;
            String str = null;
            AppMethodBeat.i(247184);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            by byVar = this.uvO;
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = byVar.getLiveData().uEa;
            Integer valueOf = (iVar == null || (awi3 = iVar.tWe) == null || (awg3 = awi3.LGn) == null) ? null : Integer.valueOf(awg3.LGY);
            if (valueOf != null && valueOf.intValue() == 1) {
                byVar.rg(8);
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = byVar.getLiveData().uEa;
                if (!(iVar2 == null || (awi = iVar2.tWe) == null || (awg = awi.LGn) == null)) {
                    str = awg.LGZ;
                }
                if (str != null) {
                    com.tencent.mm.live.c.b bVar2 = byVar.hOp;
                    b.c cVar = b.c.hNi;
                    Bundle bundle = new Bundle();
                    bundle.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", str);
                    bVar2.statusChange(cVar, bundle);
                } else {
                    b.C0376b.a(byVar.hOp, b.c.hNi);
                }
            } else if (valueOf != null && valueOf.intValue() == 2) {
                byVar.rg(8);
                b.C0376b.a(byVar.hOp, b.c.hNI);
            } else {
                String str2 = byVar.TAG;
                StringBuilder sb = new StringBuilder("onAttendBtnClick type:");
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar3 = byVar.getLiveData().uEa;
                if (iVar3 == null || (awi2 = iVar3.tWe) == null || (awg2 = awi2.LGn) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(awg2.LGY);
                }
                Log.i(str2, sb.append(num).toString());
            }
            if (byVar.hOp.getLiveRole() == 0) {
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.CLICK_JOIN_LOTTERY, str);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247184);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ by uvO;

        h(by byVar) {
            this.uvO = byVar;
        }

        public final void run() {
            AppMethodBeat.i(247187);
            Rect rect = new Rect();
            WeImageView weImageView = this.uvO.uvE;
            if (weImageView != null) {
                weImageView.getHitRect(rect);
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.cb);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            WeImageView weImageView2 = this.uvO.uvE;
            ViewParent parent = weImageView2 != null ? weImageView2.getParent() : null;
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(247187);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uvO.uvE));
            AppMethodBeat.o(247187);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ by uvO;

        i(by byVar) {
            this.uvO = byVar;
        }

        public final void onClick(View view) {
            awi awi;
            AppMethodBeat.i(247188);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.uvO.getLiveData().uEa;
            if (!(iVar == null || (awi = iVar.tWe) == null)) {
                this.uvO.a(awi, false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247188);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class g extends RecyclerView.l {
        final /* synthetic */ by uvO;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(247186);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(247186);
        }

        g(by byVar) {
            this.uvO = byVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Integer num;
            awk awk;
            LinkedList<awh> linkedList;
            awi awi;
            com.tencent.mm.bw.b bVar = null;
            AppMethodBeat.i(247185);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(recyclerView);
            bVar2.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar2.axR());
            p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(247185);
                throw tVar;
            }
            int kv = ((LinearLayoutManager) layoutManager).kv();
            by byVar = this.uvO;
            com.tencent.mm.plugin.finder.live.view.adapter.f fVar = byVar.unI;
            if (fVar != null) {
                avy avy = byVar.getLiveData().uEc;
                if (avy == null || avy.continueFlag != 1 || kv < 0 || kv < fVar.getItemCount() - byVar.unv) {
                    byVar.Jk(8);
                } else {
                    com.tencent.mm.plugin.finder.live.viewmodel.i iVar = byVar.getLiveData().uEa;
                    String str = (iVar == null || (awi = iVar.tWe) == null) ? null : awi.id;
                    if (!byVar.unJ && str != null) {
                        String str2 = byVar.TAG;
                        StringBuilder sb = new StringBuilder("load more product,product size:");
                        avy avy2 = byVar.getLiveData().uEc;
                        if (avy2 == null || (awk = avy2.LGt) == null || (linkedList = awk.LHf) == null) {
                            num = null;
                        } else {
                            num = Integer.valueOf(linkedList.size());
                        }
                        Log.i(str2, sb.append(num).toString());
                        byVar.unJ = true;
                        byVar.Jk(0);
                        o oVar = o.ujN;
                        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            avy avy3 = byVar.getLiveData().uEc;
                            if (avy3 != null) {
                                bVar = avy3.lastBuffer;
                            }
                            finderLiveAssistant.a(str, bVar, new a(byVar, kv));
                        }
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(247185);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ by uvO;

        d(by byVar) {
            this.uvO = byVar;
        }

        public final void run() {
            AppMethodBeat.i(247182);
            Rect rect = new Rect();
            View view = this.uvO.uvL;
            if (view != null) {
                view.getHitRect(rect);
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            View view2 = this.uvO.uvL;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(247182);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uvO.uvL));
            AppMethodBeat.o(247182);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ by uvO;

        e(by byVar) {
            this.uvO = byVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247183);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uvO.ny(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247183);
        }
    }

    private final void a(avy avy) {
        awk awk;
        Integer num;
        Integer num2;
        LinkedList<awh> linkedList = null;
        AppMethodBeat.i(247196);
        awi awi = avy != null ? avy.tWe : null;
        TextView textView = this.unD;
        if (textView != null) {
            ae aeVar = ae.SYK;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            String string = context.getResources().getString(R.string.cw1);
            p.g(string, "root.context.resources.g…ive_lottery_winner_count)");
            Object[] objArr = new Object[1];
            if (awi != null) {
                num2 = Integer.valueOf(awi.LHc);
            } else {
                num2 = null;
            }
            objArr[0] = num2;
            String format = String.format(string, Arrays.copyOf(objArr, 1));
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
            Object[] objArr2 = new Object[1];
            if (awi != null) {
                num = Integer.valueOf(awi.trl);
            } else {
                num = null;
            }
            objArr2[0] = num;
            String format2 = String.format(string2, Arrays.copyOf(objArr2, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            textView2.setText(format2);
        }
        com.tencent.mm.plugin.finder.live.view.adapter.f fVar = this.unI;
        if (fVar != null) {
            if (!(avy == null || (awk = avy.LGt) == null)) {
                linkedList = awk.LHf;
            }
            fVar.an(linkedList);
        }
        com.tencent.mm.plugin.finder.live.view.adapter.f fVar2 = this.unI;
        if (fVar2 != null) {
            fVar2.notifyDataSetChanged();
            AppMethodBeat.o(247196);
            return;
        }
        AppMethodBeat.o(247196);
    }

    private final void b(avy avy) {
        int i2;
        String str;
        awi awi;
        awk awk;
        LinkedList<awh> linkedList;
        com.tencent.mm.bw.b bVar = null;
        AppMethodBeat.i(247197);
        if (avy == null || (awk = avy.LGt) == null || (linkedList = awk.LHf) == null) {
            i2 = 0;
        } else {
            i2 = linkedList.size();
        }
        Log.i(this.TAG, "parseWinnerList winnerListSize:".concat(String.valueOf(i2)));
        if (i2 > 0) {
            a(avy);
            AppMethodBeat.o(247197);
            return;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = getLiveData().uEa;
        if (iVar == null || (awi = iVar.tWe) == null) {
            str = null;
        } else {
            str = awi.id;
        }
        Log.i(this.TAG, "parseWinnerList record is empty!lotteryId:".concat(String.valueOf(str)));
        if (str != null) {
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                avy avy2 = getLiveData().uEc;
                if (avy2 != null) {
                    bVar = avy2.lastBuffer;
                }
                finderLiveAssistant.a(str, bVar, new k(this, str));
                AppMethodBeat.o(247197);
                return;
            }
        }
        AppMethodBeat.o(247197);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class k implements o.a {
        final /* synthetic */ String unU;
        final /* synthetic */ by uvO;

        k(by byVar, String str) {
            this.uvO = byVar;
            this.unU = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
            r1 = r0.tWe;
         */
        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r4, int r5, java.lang.String r6, com.tencent.mm.protocal.protobuf.avy r7) {
            /*
                r3 = this;
                r2 = 247191(0x3c597, float:3.46388E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.lang.String r0 = "resp"
                kotlin.g.b.p.h(r7, r0)
                if (r4 != 0) goto L_0x002d
                if (r5 != 0) goto L_0x002d
                com.tencent.mm.plugin.finder.live.plugin.by r0 = r3.uvO
                com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r0.getLiveData()
                com.tencent.mm.protocal.protobuf.awi r1 = r7.tWe
                r0.a(r1)
                com.tencent.mm.plugin.finder.live.plugin.by r0 = r3.uvO
                com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r0.getLiveData()
                r0.d(r7)
                com.tencent.mm.plugin.finder.live.plugin.by r0 = r3.uvO
                com.tencent.mm.plugin.finder.live.plugin.by.a(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return
            L_0x002d:
                com.tencent.mm.plugin.finder.live.plugin.by r0 = r3.uvO
                com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r0.getLiveData()
                com.tencent.mm.plugin.finder.live.viewmodel.i r0 = r0.uEa
                if (r0 == 0) goto L_0x0049
                com.tencent.mm.protocal.protobuf.awi r1 = r0.tWe
                if (r1 == 0) goto L_0x0049
                com.tencent.mm.plugin.finder.live.plugin.by$k$1 r0 = new com.tencent.mm.plugin.finder.live.plugin.by$k$1
                r0.<init>(r1, r3)
                kotlin.g.a.a r0 = (kotlin.g.a.a) r0
                com.tencent.mm.ac.d.h(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            L_0x0049:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.by.k.a(int, int, java.lang.String, com.tencent.mm.protocal.protobuf.avy):void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void Jk(int i2) {
        AppMethodBeat.i(247198);
        com.tencent.mm.ac.d.h(new l(this, i2));
        AppMethodBeat.o(247198);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class a implements o.a {
        final /* synthetic */ int unO;
        final /* synthetic */ by uvO;

        a(by byVar, int i2) {
            this.uvO = byVar;
            this.unO = i2;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(247177);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.uvO.getLiveData().a(avy.tWe);
                this.uvO.getLiveData().d(avy);
                by.a(this.uvO);
            }
            this.uvO.Jk(8);
            this.uvO.unJ = false;
            AppMethodBeat.o(247177);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final void a(boolean z, com.tencent.mm.plugin.finder.live.viewmodel.i iVar) {
        AppMethodBeat.i(247199);
        p.h(iVar, "lotteryInfoWrapper");
        super.a(z, iVar);
        com.tencent.mm.ac.d.h(new m(this, iVar, z));
        AppMethodBeat.o(247199);
    }

    /* access modifiers changed from: package-private */
    public final void ny(boolean z) {
        int i2;
        awi awi;
        awi awi2;
        AppMethodBeat.i(247201);
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = getLiveData().uEa;
        int i3 = (iVar == null || (awi2 = iVar.tWe) == null) ? 0 : awi2.LHc;
        com.tencent.mm.plugin.finder.live.viewmodel.i iVar2 = getLiveData().uEa;
        if (iVar2 == null || (awi = iVar2.tWe) == null) {
            i2 = 0;
        } else {
            i2 = awi.trl;
        }
        Log.i(this.TAG, "visitorLotteryDoneWinnerList realWinnerCnt:" + i3 + ",participateCount:" + i2);
        Jj(this.uvy);
        TextView textView = this.unD;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.unE;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        RecyclerView recyclerView = this.unF;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        b(getLiveData().uEc);
        if (z) {
            WeImageView weImageView = this.uvE;
            if (weImageView != null) {
                weImageView.setVisibility(0);
            }
        } else {
            WeImageView weImageView2 = this.uvE;
            if (weImageView2 != null) {
                weImageView2.setVisibility(8);
            }
        }
        com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.CLICK_WIN_LIST, "");
        AppMethodBeat.o(247201);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.an
    public final void dhx() {
        AppMethodBeat.i(247202);
        super.dhx();
        this.uvB = this.uvx;
        AppMethodBeat.o(247202);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int uhP;
        final /* synthetic */ by uvO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(by byVar, int i2) {
            super(0);
            this.uvO = byVar;
            this.uhP = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247192);
            View view = this.uvO.qdl;
            if (view != null) {
                view.setVisibility(this.uhP);
            }
            TextView textView = this.uvO.unG;
            if (textView != null) {
                textView.setVisibility(this.uhP);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247192);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success = true;
        final /* synthetic */ by uvO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(by byVar) {
            super(0);
            this.uvO = byVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            avy avy;
            awk awk;
            LinkedList<awh> linkedList;
            AppMethodBeat.i(247189);
            String str = this.uvO.TAG;
            StringBuilder append = new StringBuilder("load more winner finish,success:").append(this.$success).append(",product size:");
            avy avy2 = this.uvO.getLiveData().uEc;
            Log.i(str, append.append((avy2 == null || (awk = avy2.LGt) == null || (linkedList = awk.LHf) == null) ? null : Integer.valueOf(linkedList.size())).toString());
            if (this.$success && (avy = this.uvO.getLiveData().uEc) != null) {
                by.a(this.uvO, avy);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247189);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.i ugt;
        final /* synthetic */ boolean unN;
        final /* synthetic */ by uvO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(by byVar, com.tencent.mm.plugin.finder.live.viewmodel.i iVar, boolean z) {
            super(0);
            this.uvO = byVar;
            this.ugt = iVar;
            this.unN = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Integer num;
            boolean z;
            boolean z2;
            int i2;
            awi awi;
            awg awg;
            String str = null;
            AppMethodBeat.i(247193);
            awi awi2 = this.ugt.tWe;
            if (awi2 != null) {
                int i3 = this.ugt.uhD;
                int i4 = this.ugt.uFr;
                awi awi3 = this.ugt.tWe;
                Log.i(this.uvO.TAG, "visitorOpenCard id:" + awi2.id + ", status:" + i3 + ",participated:" + com.tencent.mm.ac.d.cW(awi3 != null ? awi3.extFlag : 0, 1) + ",statusChange:" + this.unN + ",localRemainTime:" + i4);
                switch (i3) {
                    case 1:
                        by byVar = this.uvO;
                        String str2 = awi2.description;
                        awg awg2 = awi2.LGn;
                        String str3 = awg2 != null ? awg2.LGZ : null;
                        int i5 = awi2.ugF;
                        StringBuilder sb = new StringBuilder();
                        if (str2 != null) {
                            sb.append(str2 + '\n');
                        }
                        com.tencent.mm.plugin.finder.live.viewmodel.i iVar = byVar.getLiveData().uEa;
                        if (iVar == null || (awi = iVar.tWe) == null || (awg = awi.LGn) == null) {
                            num = null;
                        } else {
                            num = Integer.valueOf(awg.LGY);
                        }
                        if (num != null && num.intValue() == 1) {
                            String str4 = str3;
                            if (str4 == null || str4.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                StringBuilder sb2 = new StringBuilder();
                                Context context = byVar.hwr.getContext();
                                p.g(context, "root.context");
                                sb.append(sb2.append(context.getResources().getString(R.string.cux)).append((char) 65292).toString());
                            } else if (str3 != null) {
                                StringBuilder sb3 = new StringBuilder();
                                ae aeVar = ae.SYK;
                                Context context2 = byVar.hwr.getContext();
                                p.g(context2, "root.context");
                                String string = context2.getResources().getString(R.string.cuw);
                                p.g(string, "root.context.resources.g…ottery_card_desc_comment)");
                                String format = String.format(string, Arrays.copyOf(new Object[]{str3}, 1));
                                p.g(format, "java.lang.String.format(format, *args)");
                                sb.append(sb3.append(format).append((char) 65292).toString());
                            }
                        } else if (num != null && num.intValue() == 2) {
                            StringBuilder sb4 = new StringBuilder();
                            Context context3 = byVar.hwr.getContext();
                            p.g(context3, "root.context");
                            sb.append(sb4.append(context3.getResources().getString(R.string.cvo)).append((char) 65292).toString());
                        }
                        Integer valueOf = Integer.valueOf(i5);
                        valueOf.intValue();
                        if (i5 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Integer num2 = z2 ? valueOf : null;
                        if (num2 != null) {
                            int intValue = num2.intValue();
                            ae aeVar2 = ae.SYK;
                            Context context4 = byVar.hwr.getContext();
                            p.g(context4, "root.context");
                            String string2 = context4.getResources().getString(R.string.cv5);
                            p.g(string2, "root.context.resources.g…e_lottery_desc_winnercnt)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(intValue)}, 1));
                            p.g(format2, "java.lang.String.format(format, *args)");
                            sb.append(String.valueOf(format2));
                            TextView textView = byVar.jCB;
                            if (textView != null) {
                                textView.setText(sb.toString());
                            }
                        }
                        if (com.tencent.mm.ac.d.cW(awi2.extFlag, 1)) {
                            TextView textView2 = byVar.uvD;
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            }
                            TextView textView3 = byVar.uvD;
                            if (textView3 != null) {
                                Context context5 = byVar.hwr.getContext();
                                p.g(context5, "root.context");
                                textView3.setText(context5.getResources().getString(R.string.cr6));
                            }
                            TextView textView4 = byVar.uvC;
                            if (textView4 != null) {
                                textView4.setVisibility(8);
                            }
                        } else {
                            TextView textView5 = byVar.uvD;
                            if (textView5 != null) {
                                textView5.setVisibility(8);
                            }
                            TextView textView6 = byVar.uvC;
                            if (textView6 != null) {
                                textView6.setVisibility(0);
                            }
                            TextView textView7 = byVar.uvC;
                            if (textView7 != null) {
                                textView7.setEnabled(true);
                            }
                            TextView textView8 = byVar.uvC;
                            if (textView8 != null) {
                                Context context6 = byVar.hwr.getContext();
                                p.g(context6, "root.context");
                                textView8.setTextColor(context6.getResources().getColor(R.color.am));
                            }
                        }
                        int i6 = awi2.LHa;
                        int i7 = awi2.iqg;
                        int i8 = awi2.LHb;
                        int i9 = awi2.trl;
                        if (i4 < 0 || i4 >= i7 - i6) {
                            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                            i2 = com.tencent.mm.plugin.finder.utils.m.ag(i6, i7, i8);
                        } else {
                            i2 = i4;
                        }
                        TextView textView9 = byVar.unx;
                        if (textView9 != null) {
                            ae aeVar3 = ae.SYK;
                            Context context7 = byVar.hwr.getContext();
                            p.g(context7, "root.context");
                            String string3 = context7.getResources().getString(R.string.cv1);
                            p.g(string3, "root.context.resources.g…r_live_lottery_countdown)");
                            u.a aVar = u.hIn;
                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{u.a.a(i2, ":", false, false, false, 24)}, 1));
                            p.g(format3, "java.lang.String.format(format, *args)");
                            textView9.setText(format3);
                        }
                        if (i9 > 0) {
                            TextView textView10 = byVar.uny;
                            if (textView10 != null) {
                                ae aeVar4 = ae.SYK;
                                Context context8 = byVar.hwr.getContext();
                                p.g(context8, "root.context");
                                String string4 = context8.getResources().getString(R.string.cup);
                                p.g(string4, "root.context.resources.g…nder_live_lottery_attend)");
                                String format4 = String.format(string4, Arrays.copyOf(new Object[]{Integer.valueOf(i9)}, 1));
                                p.g(format4, "java.lang.String.format(format, *args)");
                                textView10.setText(format4);
                            }
                            TextView textView11 = byVar.uny;
                            if (textView11 != null) {
                                textView11.setVisibility(0);
                            }
                        } else {
                            TextView textView12 = byVar.uny;
                            if (textView12 != null) {
                                textView12.setVisibility(8);
                            }
                        }
                        this.uvO.Jj(this.uvO.unt);
                        this.uvO.rg(0);
                        break;
                    case 2:
                        this.uvO.a(this.ugt, awi2, i3, this.uvO.unK);
                        break;
                    case 3:
                        this.uvO.a(this.ugt, awi2, i3, this.uvO.unL);
                        break;
                    case 4:
                        by byVar2 = this.uvO;
                        String str5 = byVar2.TAG;
                        StringBuilder sb5 = new StringBuilder("visitorLotteryCancelled id:");
                        if (awi2 != null) {
                            str = awi2.id;
                        }
                        Log.i(str5, sb5.append(str).toString());
                        com.tencent.mm.live.c.b bVar = byVar2.hOp;
                        b.c cVar = b.c.hNJ;
                        Bundle bundle = new Bundle();
                        Context context9 = MMApplicationContext.getContext();
                        p.g(context9, "MMApplicationContext.getContext()");
                        bundle.putString("PARAM_FINDER_LIVE_ALERT_DIALOG_CONTENT", context9.getResources().getString(R.string.cqq));
                        bVar.statusChange(cVar, bundle);
                        this.uvO.rg(8);
                        break;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247193);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void Jj(int i2) {
        AppMethodBeat.i(247195);
        Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(i2)));
        this.uvB = i2;
        if (i2 == this.unt) {
            View view = this.unw;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.unz;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.urW;
            if (view3 != null) {
                view3.setBackgroundResource(R.drawable.icon_live_lottery_card_bg);
                AppMethodBeat.o(247195);
                return;
            }
            AppMethodBeat.o(247195);
        } else if (i2 == this.uvy) {
            View view4 = this.unw;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View view5 = this.unz;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            View view6 = this.unA;
            if (view6 != null) {
                view6.setVisibility(0);
            }
            View view7 = this.uvF;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            View view8 = this.urW;
            if (view8 != null) {
                view8.setBackgroundResource(R.drawable.icon_live_lottery_card_bg);
                AppMethodBeat.o(247195);
                return;
            }
            AppMethodBeat.o(247195);
        } else if (i2 == this.uvz) {
            View view9 = this.unw;
            if (view9 != null) {
                view9.setVisibility(8);
            }
            View view10 = this.unz;
            if (view10 != null) {
                view10.setVisibility(0);
            }
            View view11 = this.unA;
            if (view11 != null) {
                view11.setVisibility(8);
            }
            View view12 = this.uvF;
            if (view12 != null) {
                view12.setVisibility(0);
            }
            TextView textView = this.uvG;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.uvH;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageView imageView = this.uvI;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView3 = this.uvJ;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            View view13 = this.urW;
            if (view13 != null) {
                view13.setBackgroundResource(R.drawable.icon_live_lottery_card_bg);
            }
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.SHOW_WIN_RESULT_CARD, String.valueOf(s.bc.NO_WIN.result));
            AppMethodBeat.o(247195);
        } else {
            if (i2 == this.uvA) {
                View view14 = this.unw;
                if (view14 != null) {
                    view14.setVisibility(8);
                }
                View view15 = this.unz;
                if (view15 != null) {
                    view15.setVisibility(0);
                }
                View view16 = this.unA;
                if (view16 != null) {
                    view16.setVisibility(8);
                }
                View view17 = this.uvF;
                if (view17 != null) {
                    view17.setVisibility(0);
                }
                TextView textView4 = this.uvG;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                TextView textView5 = this.uvH;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                ImageView imageView2 = this.uvI;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                TextView textView6 = this.uvJ;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                View view18 = this.urW;
                if (view18 != null) {
                    view18.setBackgroundResource(R.drawable.icon_live_lottery_card_winner_bg);
                }
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.SHOW_WIN_RESULT_CARD, String.valueOf(s.bc.WIN.result));
            }
            AppMethodBeat.o(247195);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(awi awi, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(247200);
        if (this.hwr.getVisibility() == 0 && (this.uvB == this.uvA || this.uvB == this.uvz || this.uvB == this.uvy)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i(this.TAG, "visitorLotteryDone fromUpdate:" + z + ",isDoneUIShowing:" + z2);
        if (!z || !z2) {
            boolean cW = com.tencent.mm.ac.d.cW(awi.extFlag, 2);
            boolean cW2 = com.tencent.mm.ac.d.cW(awi.extFlag, 1);
            int i2 = awi.trl;
            int i3 = awi.LHc;
            String aUa = z.aUa();
            if (cW) {
                Jj(this.uvA);
                ImageView imageView = this.uvI;
                if (imageView != null) {
                    a.b.c(imageView, z.aTY());
                }
                TextView textView = this.uvJ;
                if (textView != null) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), aUa));
                }
                getLiveData().uEd = true;
                TextView textView2 = this.uvK;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    z3 = true;
                } else {
                    z3 = true;
                }
            } else if (cW2) {
                Jj(this.uvz);
                TextView textView3 = this.uvG;
                if (textView3 != null) {
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    textView3.setText(context.getResources().getString(R.string.cvp));
                }
                TextView textView4 = this.uvK;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                    z3 = true;
                } else {
                    z3 = true;
                }
            } else if (i3 <= 0 || i2 < i3) {
                Jj(this.uvz);
                TextView textView5 = this.uvG;
                if (textView5 != null) {
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    textView5.setText(context2.getResources().getString(R.string.cvr));
                }
                TextView textView6 = this.uvK;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.SHOW_WIN_RESULT_CARD, String.valueOf(s.bc.NO_JOIN.result));
                z3 = false;
            } else {
                ny(false);
                TextView textView7 = this.uvK;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.SHOW_WIN_RESULT_CARD, String.valueOf(s.bc.NO_JOIN.result));
                z3 = true;
            }
            if (i3 <= 0 || i2 < i3) {
                View view = this.uvN;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                View view2 = this.uvN;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            if (z3) {
                TextView textView8 = this.uvM;
                if (textView8 != null) {
                    ae aeVar = ae.SYK;
                    Context context3 = this.hwr.getContext();
                    p.g(context3, "root.context");
                    String string = context3.getResources().getString(R.string.cvw);
                    p.g(string, "root.context.resources.g…nder_live_lottery_result)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)}, 2));
                    p.g(format, "java.lang.String.format(format, *args)");
                    textView8.setText(format);
                }
            } else {
                TextView textView9 = this.uvM;
                if (textView9 != null) {
                    ae aeVar2 = ae.SYK;
                    Context context4 = this.hwr.getContext();
                    p.g(context4, "root.context");
                    String string2 = context4.getResources().getString(R.string.cvz);
                    p.g(string2, "root.context.resources.g…r_live_lottery_statement)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)}, 2));
                    p.g(format2, "java.lang.String.format(format, *args)");
                    textView9.setText(format2);
                }
            }
            Log.i(this.TAG, "visitorLotteryDone isWin:" + cW + ",participateCnt:" + i2 + ",realWinnerCnt:" + i3 + ",haveLotteryResult:" + z3);
            AppMethodBeat.o(247200);
            return;
        }
        AppMethodBeat.o(247200);
    }

    public static final /* synthetic */ void a(by byVar) {
        AppMethodBeat.i(247204);
        com.tencent.mm.ac.d.h(new j(byVar));
        AppMethodBeat.o(247204);
    }

    public static final /* synthetic */ void a(by byVar, awi awi) {
        Integer num;
        boolean z;
        boolean z2;
        Integer num2;
        AppMethodBeat.i(247206);
        byVar.Jj(byVar.unt);
        String str = awi.description;
        awg awg = awi.LGn;
        String str2 = awg != null ? awg.LGZ : null;
        int i2 = awi.ugF;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str + '\n');
        }
        awg awg2 = awi.LGn;
        if (awg2 != null) {
            num = Integer.valueOf(awg2.LGY);
        } else {
            num = null;
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
                Context context = byVar.hwr.getContext();
                p.g(context, "root.context");
                sb.append(sb2.append(context.getResources().getString(R.string.cux)).append((char) 65292).toString());
            } else if (str2 != null) {
                StringBuilder sb3 = new StringBuilder();
                ae aeVar = ae.SYK;
                Context context2 = byVar.hwr.getContext();
                p.g(context2, "root.context");
                String string = context2.getResources().getString(R.string.cuw);
                p.g(string, "root.context.resources.g…ottery_card_desc_comment)");
                String format = String.format(string, Arrays.copyOf(new Object[]{str2}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                sb.append(sb3.append(format).append((char) 65292).toString());
            }
        } else if (num != null && num.intValue() == 2) {
            StringBuilder sb4 = new StringBuilder();
            Context context3 = byVar.hwr.getContext();
            p.g(context3, "root.context");
            sb.append(sb4.append(context3.getResources().getString(R.string.cvo)).append((char) 65292).toString());
        }
        Integer valueOf = Integer.valueOf(i2);
        valueOf.intValue();
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            num2 = valueOf;
        } else {
            num2 = null;
        }
        if (num2 != null) {
            int intValue = num2.intValue();
            ae aeVar2 = ae.SYK;
            Context context4 = byVar.hwr.getContext();
            p.g(context4, "root.context");
            String string2 = context4.getResources().getString(R.string.cv5);
            p.g(string2, "root.context.resources.g…e_lottery_desc_winnercnt)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(intValue)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            sb.append(String.valueOf(format2));
            TextView textView = byVar.jCB;
            if (textView != null) {
                textView.setText(sb.toString());
            }
        }
        if (com.tencent.mm.ac.d.cW(awi.extFlag, 1)) {
            TextView textView2 = byVar.uvD;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = byVar.uvD;
            if (textView3 != null) {
                Context context5 = byVar.hwr.getContext();
                p.g(context5, "root.context");
                textView3.setText(context5.getResources().getString(R.string.cr6));
            }
            TextView textView4 = byVar.uvC;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            TextView textView5 = byVar.uvD;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = byVar.uvC;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            TextView textView7 = byVar.uvC;
            if (textView7 != null) {
                textView7.setEnabled(false);
            }
            TextView textView8 = byVar.uvC;
            if (textView8 != null) {
                Context context6 = byVar.hwr.getContext();
                p.g(context6, "root.context");
                textView8.setTextColor(context6.getResources().getColor(R.color.BW_0_Alpha_0_1_5));
            }
        }
        TextView textView9 = byVar.unx;
        if (textView9 != null) {
            Context context7 = byVar.hwr.getContext();
            p.g(context7, "root.context");
            textView9.setText(context7.getResources().getString(R.string.cum));
        }
        if (awi.trl > 0) {
            TextView textView10 = byVar.uny;
            if (textView10 != null) {
                ae aeVar3 = ae.SYK;
                Context context8 = byVar.hwr.getContext();
                p.g(context8, "root.context");
                String string3 = context8.getResources().getString(R.string.cup);
                p.g(string3, "root.context.resources.g…nder_live_lottery_attend)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(awi.trl)}, 1));
                p.g(format3, "java.lang.String.format(format, *args)");
                textView10.setText(format3);
            }
            TextView textView11 = byVar.uny;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
        } else {
            TextView textView12 = byVar.uny;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
        }
        View view = byVar.urV;
        if (view != null) {
            view.setVisibility(0);
        }
        byVar.rg(0);
        AppMethodBeat.o(247206);
    }

    public static final /* synthetic */ void b(by byVar, awi awi) {
        awi awi2;
        AppMethodBeat.i(247207);
        if (byVar.getLiveData().isLiveStarted()) {
            View view = byVar.urV;
            if (view != null) {
                view.setVisibility(0);
            }
            com.tencent.mm.plugin.finder.live.viewmodel.i iVar = byVar.getLiveData().uEa;
            if (!(iVar == null || (awi2 = iVar.tWe) == null)) {
                awi = awi2;
            }
            byVar.a(awi, true);
            byVar.rg(0);
            AppMethodBeat.o(247207);
            return;
        }
        Log.i(byVar.TAG, "visitorDoneAction liveStatus:" + byVar.getLiveData().uEg);
        AppMethodBeat.o(247207);
    }
}
