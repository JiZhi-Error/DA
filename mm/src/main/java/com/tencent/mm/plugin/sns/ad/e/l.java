package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class l {

    public static class a {
        protected LinkedList<cg> DsY = new LinkedList<>();

        public a() {
            AppMethodBeat.i(201941);
            AppMethodBeat.o(201941);
        }

        public final a m(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(201942);
            try {
                cg cgVar = new cg();
                cgVar.KGy = 13298;
                cgVar.xvg = System.currentTimeMillis() / 1000;
                String str3 = "";
                if (!TextUtils.isEmpty(str)) {
                    str3 = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                }
                String str4 = str3 + "," + i2 + "," + i3 + "," + str2;
                cgVar.KGz = new b(str4.getBytes());
                this.DsY.add(cgVar);
                Log.i("SnsAdLogItemReportHelper", "add logItem:".concat(String.valueOf(str4)));
            } catch (Throwable th) {
                Log.e("SnsAdLogItemReportHelper", "appendDelLogItem, exp=" + th.toString());
            }
            AppMethodBeat.o(201942);
            return this;
        }

        public final void report() {
            AppMethodBeat.i(201943);
            LinkedList<cg> linkedList = this.DsY;
            if (linkedList.size() > 0) {
                Log.i("SnsAdLogItemReportHelper", "report, logList.size=" + linkedList.size());
                try {
                    g.aAi();
                    g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.l(linkedList), 0);
                    AppMethodBeat.o(201943);
                } catch (Throwable th) {
                    Log.e("SnsAdLogItemReportHelper", "report, exp=" + th.toString());
                    AppMethodBeat.o(201943);
                }
            } else {
                Log.e("SnsAdLogItemReportHelper", "report, logList.size=0");
                AppMethodBeat.o(201943);
            }
        }
    }
}
