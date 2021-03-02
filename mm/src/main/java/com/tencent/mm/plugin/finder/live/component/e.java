package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.component.d;
import com.tencent.mm.plugin.finder.live.model.cgi.m;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "desc", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "durationValid", "", "liveId", "", "lotteryType", "lotteryTypeValid", "nonceId", "objectId", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "winnerCnt", "winnerNumberValid", "wording", "checkDesc", "checkDuration", "checkWinnerNumber", "winnerNumber", "chooseLotteryType", "", "type", "createLottery", "isCommentEnabel", "onAttach", "callback", "onDetach", "setLotteryDesc", "setLotteyDuration", "setLotteyType", "setLotteyWording", "setWinnerNumber", "cnt", "Companion", "plugin-finder_release"})
public final class e implements d.a {
    private static final int MAX_STRING_LENGTH = 10;
    private static final int ugJ = 0;
    private static final int ugK = c.dvp();
    private static final int ugL = Integer.MAX_VALUE;
    public static final a ugM = new a((byte) 0);
    private final String TAG = "FinderLiveLotteryCreatePresenter";
    private final Activity activity;
    private String dQx = "";
    private String desc = "";
    private int duration;
    private long hFK = this.activity.getIntent().getLongExtra("KEY_PARAMS_OBJECT_ID", 0);
    private String hwg = "";
    private long liveId = this.activity.getIntent().getLongExtra("KEY_PARAMS_LIVE_ID", 0);
    d.b ugD;
    private int ugE = 1;
    private int ugF;
    private boolean ugG;
    private boolean ugH;
    private boolean ugI;

    public e(Activity activity2) {
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(245931);
        this.activity = activity2;
        String stringExtra = this.activity.getIntent().getStringExtra("KEY_PARAMS_NONCE_ID");
        this.hwg = stringExtra == null ? "" : stringExtra;
        AppMethodBeat.o(245931);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(d.b bVar) {
        AppMethodBeat.i(245927);
        d.b bVar2 = bVar;
        p.h(bVar2, "callback");
        this.ugD = bVar2;
        d.b bVar3 = this.ugD;
        if (bVar3 != null) {
            bVar3.initView();
            AppMethodBeat.o(245927);
            return;
        }
        AppMethodBeat.o(245927);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$Companion;", "", "()V", "MAX_RURATION", "", "getMAX_RURATION", "()I", "MAX_STRING_LENGTH", "getMAX_STRING_LENGTH", "MAX_WINNER_NUMBER", "getMAX_WINNER_NUMBER", "MIN_DURATION", "getMIN_DURATION", "MIN_STRING_LENGTH", "getMIN_STRING_LENGTH", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245932);
        c cVar = c.vCb;
        AppMethodBeat.o(245932);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void IZ(int i2) {
        AppMethodBeat.i(245921);
        this.ugE = i2;
        Jc(this.ugE);
        AppMethodBeat.o(245921);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void atu(String str) {
        AppMethodBeat.i(245922);
        p.h(str, "wording");
        this.dQx = str;
        Jc(this.ugE);
        AppMethodBeat.o(245922);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void Ja(int i2) {
        AppMethodBeat.i(245923);
        this.duration = i2;
        Jc(this.ugE);
        AppMethodBeat.o(245923);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void Jb(int i2) {
        AppMethodBeat.i(245924);
        this.ugF = i2;
        Jc(this.ugE);
        AppMethodBeat.o(245924);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void atv(String str) {
        AppMethodBeat.i(245925);
        p.h(str, "desc");
        this.desc = str;
        Jc(this.ugE);
        AppMethodBeat.o(245925);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$createLottery$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
    public static final class b implements m.a {
        final /* synthetic */ e ugN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(e eVar) {
            this.ugN = eVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.m.a
        public final void a(int i2, int i3, String str, avp avp) {
            AppMethodBeat.i(245920);
            p.h(avp, "resp");
            com.tencent.mm.ac.d.h(new a(this, i2, i3, avp, str));
            AppMethodBeat.o(245920);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ b UJM;
            final /* synthetic */ avp unT;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, int i2, int i3, avp avp, String str) {
                super(0);
                this.UJM = bVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.unT = avp;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260389);
                if (this.$errType == 0 && this.$errCode == 0) {
                    k kVar = k.vkd;
                    k.a(s.f.START_LOTTERY_SUCCESS, this.UJM.ugN.ugE + '@' + this.UJM.ugN.dQx + ';' + this.UJM.ugN.duration + ';' + this.UJM.ugN.ugF + ';' + this.UJM.ugN.desc);
                    o oVar = o.ujN;
                    g dfZ = o.dfZ();
                    if (dfZ != null) {
                        dfZ.djg();
                    }
                    awi awi = this.unT.tWe;
                    if (awi != null) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(awi);
                        o oVar2 = o.ujN;
                        g dfZ2 = o.dfZ();
                        if (dfZ2 != null) {
                            g.h(dfZ2, linkedList);
                        }
                        o oVar3 = o.ujN;
                        g dfZ3 = o.dfZ();
                        if (dfZ3 != null) {
                            dfZ3.uEd = true;
                        }
                    }
                    d.b bVar = this.UJM.ugN.ugD;
                    if (bVar != null) {
                        bVar.destroy();
                    }
                    this.UJM.ugN.activity.setResult(-1);
                    this.UJM.ugN.activity.finish();
                } else {
                    d.b bVar2 = this.UJM.ugN.ugD;
                    if (bVar2 != null) {
                        bVar2.a(this.$errCode, this.$errMsg, this.unT);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260389);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        this.ugD = null;
    }

    private final void Jc(int i2) {
        boolean z = true;
        AppMethodBeat.i(245928);
        Log.i(this.TAG, "chooseLotteryType type:".concat(String.valueOf(i2)));
        this.ugH = Jd(this.duration);
        this.ugI = Je(this.ugF);
        switch (i2) {
            case 1:
            case 2:
            case 3:
                this.ugG = true;
                d.b bVar = this.ugD;
                if (bVar != null) {
                    boolean z2 = this.ugH;
                    if (this.duration <= ugK) {
                        z = false;
                    }
                    bVar.N(z2, z);
                }
                boolean z3 = this.ugG & this.ugH & this.ugI;
                d.b bVar2 = this.ugD;
                if (bVar2 != null) {
                    bVar2.nk(z3);
                    AppMethodBeat.o(245928);
                    return;
                }
                AppMethodBeat.o(245928);
                return;
            default:
                this.ugG = false;
                d.b bVar3 = this.ugD;
                if (bVar3 != null) {
                    bVar3.nk(false);
                    AppMethodBeat.o(245928);
                    return;
                }
                AppMethodBeat.o(245928);
                return;
        }
    }

    private final boolean Jd(int i2) {
        AppMethodBeat.i(245929);
        boolean z = false;
        int i3 = ugJ + 1;
        int i4 = ugK;
        if (i3 <= i2 && i4 >= i2) {
            z = true;
        }
        Log.i(this.TAG, "checkDuration duration:" + i2 + " valid:" + z);
        AppMethodBeat.o(245929);
        return z;
    }

    private final boolean Je(int i2) {
        AppMethodBeat.i(245930);
        boolean z = false;
        int i3 = ugL;
        if (1 <= i2 && i3 >= i2) {
            z = true;
        }
        Log.i(this.TAG, "checkWinnerNumber winnerNumber:" + i2 + " valid:" + z);
        AppMethodBeat.o(245930);
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.a
    public final void dff() {
        int i2;
        boolean z;
        String str;
        boolean z2 = false;
        AppMethodBeat.i(245926);
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        if (dfZ != null) {
            i2 = dfZ.uDA;
        } else {
            i2 = 0;
        }
        if (!com.tencent.mm.ac.d.cW(i2, 8)) {
            z = true;
        } else {
            z = false;
        }
        if (z || this.ugE != 1) {
            long j2 = this.liveId;
            long j3 = this.hFK;
            String str2 = this.hwg;
            int i3 = this.duration;
            String str3 = this.desc;
            int i4 = this.ugE;
            String str4 = this.dQx;
            m.b bVar = m.ukW;
            new m(j2, j3, str2, i3, str3, i4, str4, m.dgF(), this.ugF, new b(this)).aYI();
            AppMethodBeat.o(245926);
            return;
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = context.getResources().getString(R.string.cr3);
        p.g(string, "MMApplicationContext.get…_any_comemnt_lottery_ban)");
        String str5 = this.dQx;
        if (str5 == null || str5.length() == 0) {
            z2 = true;
        }
        if (!z2) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            str = context2.getResources().getString(R.string.czf);
            p.g(str, "MMApplicationContext.get…cial_comemnt_lottery_ban)");
        } else {
            str = string;
        }
        d.b bVar2 = this.ugD;
        if (bVar2 != null) {
            bVar2.atw(str);
            AppMethodBeat.o(245926);
            return;
        }
        AppMethodBeat.o(245926);
    }
}
