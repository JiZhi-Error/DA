package com.tencent.mm.model.a;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class f {
    private static void KT(String str) {
        AppMethodBeat.i(153094);
        Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", str);
        if (g.aWT().aWR()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra("content", str);
            MMApplicationContext.getContext().sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
            AppMethodBeat.o(153094);
            return;
        }
        Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
        AppMethodBeat.o(153094);
    }

    private static void a(e eVar, boolean z) {
        AppMethodBeat.i(153095);
        if (eVar == null || !g.aWT().aWR()) {
            Log.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            AppMethodBeat.o(153095);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) (z ? sb.append("TestPointStart:") : sb.append("TestPointEnd:")));
        sb.append(g.aWT().iGz.iGw);
        sb.append("_");
        sb.append(eVar.id);
        sb.append("_");
        sb.append(eVar.iGB);
        sb.append("_");
        sb.append(eVar.iGB);
        sb.append("_");
        sb.append(eVar.iGC);
        sb.append("_");
        sb.append(eVar.result);
        sb.append("_");
        sb.append(eVar.igp);
        KT(sb.toString());
        AppMethodBeat.o(153095);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(153096);
        if (eVar != null && g.aWT().aWR()) {
            String str = g.aWT().iGz.iGw;
            String str2 = eVar.id;
            String str3 = eVar.id;
            String sb = new StringBuilder().append(eVar.endTime - eVar.startTime).toString();
            String str4 = eVar.result;
            String str5 = eVar.iGB;
            long j2 = eVar.igp;
            Log.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", str, str2, str5, str3, sb, str4, Long.valueOf(j2));
            h.INSTANCE.a(11394, str, str2, str5, str3, sb, str4, Long.valueOf(j2));
        }
        AppMethodBeat.o(153096);
    }

    public static void KU(String str) {
        AppMethodBeat.i(153097);
        Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        KT("TestCaseID:".concat(String.valueOf(str)));
        AppMethodBeat.o(153097);
    }

    public static void KV(String str) {
        AppMethodBeat.i(153098);
        if (g.aWT().KR(str) != null) {
            Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", str);
            g.aWT().KR(str).iGC = System.currentTimeMillis();
            g.aWT().KR(str).startTime = System.currentTimeMillis();
            g.aWT().KR(str).iGD = false;
            g.aWT().KR(str).result = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            a(g.aWT().KR(str), true);
        }
        AppMethodBeat.o(153098);
    }

    public static void KW(String str) {
        AppMethodBeat.i(153099);
        if (g.aWT().KR(str) != null && !g.aWT().KR(str).iGD) {
            Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", str);
            g.aWT().KR(str).iGC = System.currentTimeMillis();
            g.aWT().KR(str).endTime = System.currentTimeMillis();
            g.aWT().KR(str).iGD = true;
            a(g.aWT().KR(str));
            a(g.aWT().KR(str), false);
        }
        AppMethodBeat.o(153099);
    }
}
