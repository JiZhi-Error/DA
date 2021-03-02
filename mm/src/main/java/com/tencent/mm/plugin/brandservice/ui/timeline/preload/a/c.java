package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.plugin.webview.h.a;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static void aij(String str) {
        AppMethodBeat.i(6194);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
            AppMethodBeat.o(6194);
            return;
        }
        gb gbVar = new gb();
        gbVar.Url = str;
        a.pl(50);
        a.pl(56);
        a(gbVar, 0);
        AppMethodBeat.o(6194);
    }

    static void a(final gb gbVar, final int i2) {
        AppMethodBeat.i(6195);
        aa.a(a(gbVar).aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(6192);
                Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                gd gdVar = (gd) dVar.iLL.iLR;
                if (i2 == 0 && i3 == 0 && gdVar != null) {
                    if (i2 > 0) {
                        a.pl(57);
                    }
                    Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", gbVar.Url);
                    a.pl(51);
                } else if (i3 != 50001) {
                    if (i2 > 0) {
                        a.pl(58);
                    }
                    a.pl(52);
                    if (com.tencent.mm.plugin.brandservice.d.clp().a(new a(gbVar))) {
                        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                } else if (i2 < 3) {
                    c.a(gbVar, i2 + 1);
                } else {
                    a.pl(52);
                    a.pl(59);
                    if (com.tencent.mm.plugin.brandservice.d.clp().a(new a(gbVar))) {
                        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                }
                AppMethodBeat.o(6192);
                return 0;
            }
        });
        AppMethodBeat.o(6195);
    }

    public static void coh() {
        AppMethodBeat.i(6196);
        Cursor query = com.tencent.mm.plugin.brandservice.d.clp().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
        final LinkedList linkedList = new LinkedList();
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            linkedList.add(aVar);
        }
        query.close();
        final LinkedList<gb> cK = cK(linkedList);
        if (cK.size() <= 0) {
            com.tencent.mm.plugin.brandservice.d.clp().cJ(linkedList);
            Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
            AppMethodBeat.o(6196);
            return;
        }
        a.pl(53);
        aa.a(c(cK, 1).aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(6193);
                Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                gd gdVar = (gd) dVar.iLL.iLR;
                if (i2 == 0 && i3 == 0 && gdVar != null) {
                    Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", Integer.valueOf(cK.size()));
                    a.pl(54);
                    com.tencent.mm.plugin.brandservice.d.clp().cJ(linkedList);
                } else {
                    Log.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", Integer.valueOf(cK.size()));
                    a.pl(55);
                }
                AppMethodBeat.o(6193);
                return 0;
            }
        });
        AppMethodBeat.o(6196);
    }

    private static LinkedList<gb> cK(List<a> list) {
        AppMethodBeat.i(6197);
        LinkedList<gb> linkedList = new LinkedList<>();
        if (list.size() > 0) {
            Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", Integer.valueOf(list.size()));
            for (a aVar : list) {
                if (Util.isNullOrNil(aVar.field_url)) {
                    Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
                } else if (System.currentTimeMillis() - aVar.field_reportTime >= g.pBc) {
                    a.kh(60, 1);
                } else {
                    gb gbVar = new gb();
                    gbVar.Url = aVar.field_url;
                    gbVar.KJQ = aVar.field_reportTime;
                    linkedList.add(gbVar);
                    Log.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", gbVar.Url, Long.valueOf(gbVar.KJQ));
                }
            }
        }
        AppMethodBeat.o(6197);
        return linkedList;
    }

    private static d.a a(gb gbVar) {
        AppMethodBeat.i(6198);
        LinkedList linkedList = new LinkedList();
        linkedList.add(gbVar);
        d.a c2 = c(linkedList, 0);
        AppMethodBeat.o(6198);
        return c2;
    }

    private static d.a c(LinkedList<gb> linkedList, int i2) {
        AppMethodBeat.i(6199);
        d.a aVar = new d.a();
        aVar.funcId = 2998;
        aVar.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        gc gcVar = new gc();
        gcVar.KJT = linkedList;
        gcVar.KJU = i2;
        aVar.iLN = gcVar;
        aVar.iLO = new gd();
        AppMethodBeat.o(6199);
        return aVar;
    }
}
