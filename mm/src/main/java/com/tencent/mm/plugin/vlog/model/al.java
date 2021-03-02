package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", OpenSDKTool4Assistant.EXTRA_UIN, "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class al {
    public static final List<ln> GAa = new ArrayList();
    public static ah GAb = null;
    public static final al GAc = new al();
    private static long GzZ = 0;
    public static final String TAG = TAG;
    private static long uin;
    private static long ulj;
    private static long vgi = -1;

    static {
        AppMethodBeat.i(110954);
        AppMethodBeat.o(110954);
    }

    private al() {
    }

    public static void ax(long j2, long j3) {
        AppMethodBeat.i(110951);
        ulj = j2;
        uin = j3;
        GzZ = 1;
        Log.i(TAG, "configure vlogreporter: requestId = " + j2 + ", uin = " + j3 + ", businessId = 1");
        AppMethodBeat.o(110951);
    }

    public static void a(ah ahVar) {
        ah ahVar2;
        AppMethodBeat.i(110952);
        long currentTimeMillis = System.currentTimeMillis();
        if (!(vgi == -1 || (ahVar2 = GAb) == null)) {
            ln lnVar = new ln();
            lnVar.KPe = ahVar2.GzP;
            lnVar.KPf = 1;
            lnVar.KPg = currentTimeMillis - vgi;
            lnVar.KPh = System.currentTimeMillis();
            lnVar.dNP = ahVar2.fBK();
            lnVar.DYl = ahVar2.fBJ();
            lnVar.KPi = ahVar2.fBL();
            GAa.add(lnVar);
            Log.i(TAG, "record watch: vlogscriptModel = " + ahVar2 + ", watch time = " + lnVar.KPg + LocaleUtil.MALAY);
        }
        vgi = currentTimeMillis;
        GAb = ahVar;
        AppMethodBeat.o(110952);
    }

    public static void eKh() {
        AppMethodBeat.i(110953);
        if (!GAa.isEmpty()) {
            Log.i(TAG, "do send result: behavior size = " + GAa.size());
            b aAg = g.aAg();
            p.g(aAg, "network()");
            aAg.azz().b(new c(ulj, uin, GzZ, GAa));
            GAa.clear();
        }
        ulj = 0;
        uin = 0;
        GzZ = 0;
        vgi = -1;
        GAb = null;
        AppMethodBeat.o(110953);
    }
}
