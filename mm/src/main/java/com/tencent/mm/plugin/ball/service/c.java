package com.tencent.mm.plugin.ball.service;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "enableReport", "", "Ljava/lang/Boolean;", "lastExitPageInfo", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "markExitPage", "", "pageType", "", "hasFloatBall", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", AppMeasurement.Param.TIMESTAMP, "", "addMessageBallResult", "updateEnableReport", "Companion", "ExitPageInfo", "plugin-ball_release"})
public final class c implements com.tencent.mm.plugin.ball.c.a {
    private static final f iax = g.a(k.SYNCHRONIZED, b.oWN);
    public static final a oWM = new a((byte) 0);
    private volatile C0852c oWK;
    private Boolean oWL;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
    public static final class a {
        public static c ciA() {
            AppMethodBeat.i(217155);
            f fVar = c.iax;
            a aVar = c.oWM;
            c cVar = (c) fVar.getValue();
            AppMethodBeat.o(217155);
            return cVar;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(217159);
        AppMethodBeat.o(217159);
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void d(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(217156);
        Log.d("MicroMsg.FloatBallReportService", "alvinluo markExitPage pageType: %d, hasFloatBall: %b, isSupportMessageBall: %b", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        this.oWK = new C0852c(i2, z, z2, System.currentTimeMillis());
        AppMethodBeat.o(217156);
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void l(long j2, int i2) {
        AppMethodBeat.i(217157);
        if (this.oWL == null) {
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enter_chatting_from_notification_report_enable, 0);
            this.oWL = Boolean.valueOf(a2 == 1 || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG);
            Log.i("MicroMsg.FloatBallReportService", "alvinluo updateEnableReport config: %d, enable: %b", Integer.valueOf(a2), this.oWL);
        }
        if (p.j(this.oWL, Boolean.FALSE)) {
            AppMethodBeat.o(217157);
        } else if (this.oWK == null) {
            h.INSTANCE.a(20041, -1, 0, 0);
            AppMethodBeat.o(217157);
        } else {
            try {
                C0852c cVar = this.oWK;
                if (cVar == null) {
                    p.hyc();
                }
                long j3 = j2 - cVar.timestamp;
                C0852c cVar2 = this.oWK;
                if (cVar2 == null) {
                    p.hyc();
                }
                if (cVar2.oWO) {
                    i2 = 4;
                } else {
                    C0852c cVar3 = this.oWK;
                    if (cVar3 == null) {
                        p.hyc();
                    }
                    if (!cVar3.oWP) {
                        i2 = 3;
                    }
                }
                Object[] objArr = new Object[3];
                C0852c cVar4 = this.oWK;
                if (cVar4 == null) {
                    p.hyc();
                }
                objArr[0] = Integer.valueOf(cVar4.pageType);
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Long.valueOf(j3);
                Log.d("MicroMsg.FloatBallReportService", "alvinluo onEnterChattingFromNotification type: %d, addMessageBallResult: %d, timeDiff: %d", objArr);
                h hVar = h.INSTANCE;
                Object[] objArr2 = new Object[4];
                objArr2[0] = 0;
                objArr2[1] = Integer.valueOf(i2);
                objArr2[2] = Long.valueOf(j3);
                C0852c cVar5 = this.oWK;
                if (cVar5 == null) {
                    p.hyc();
                }
                objArr2[3] = Integer.valueOf(cVar5.pageType);
                hVar.a(20041, objArr2);
                this.oWK = null;
                AppMethodBeat.o(217157);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatBallReportService", e2, "onEnterChattingFromNotification exception", new Object[0]);
                this.oWK = null;
                AppMethodBeat.o(217157);
            }
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void jK(boolean z) {
        AppMethodBeat.i(217158);
        Log.i("MicroMsg.FloatBallReportService", "alvinluo markWechatForeground %b", Boolean.valueOf(z));
        if (!z) {
            this.oWK = null;
        }
        AppMethodBeat.o(217158);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportService$ExitPageInfo;", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", AppMeasurement.Param.TIMESTAMP, "", "(IZZJ)V", "getHasFloatBall", "()Z", "getPageType", "()I", "getTimestamp", "()J", "plugin-ball_release"})
    /* renamed from: com.tencent.mm.plugin.ball.service.c$c  reason: collision with other inner class name */
    public static final class C0852c {
        final boolean oWO;
        final boolean oWP;
        final int pageType;
        final long timestamp;

        public C0852c(int i2, boolean z, boolean z2, long j2) {
            this.pageType = i2;
            this.oWO = z;
            this.oWP = z2;
            this.timestamp = j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportService;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<c> {
        public static final b oWN = new b();

        static {
            AppMethodBeat.i(217154);
            AppMethodBeat.o(217154);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(217153);
            c cVar = new c();
            AppMethodBeat.o(217153);
            return cVar;
        }
    }
}
