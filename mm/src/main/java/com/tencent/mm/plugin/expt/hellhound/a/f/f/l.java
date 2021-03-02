package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class l {
    public static final a sIR = new a((byte) 0);

    static {
        AppMethodBeat.i(221140);
        AppMethodBeat.o(221140);
    }

    public static final void Bt(long j2) {
        AppMethodBeat.i(221142);
        a.Bt(j2);
        AppMethodBeat.o(221142);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "reportIdKey", "id", "reportKv", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void Bt(long j2) {
            AppMethodBeat.i(221139);
            h.INSTANCE.idkeyStat(932, j2, 1, false);
            AppMethodBeat.o(221139);
        }
    }

    public static final void t(long j2, int i2) {
        AppMethodBeat.i(221141);
        kg kgVar = new kg();
        kgVar.lN((int) j2);
        kgVar.lO(i2);
        kgVar.bfK();
        AppMethodBeat.o(221141);
    }
}
