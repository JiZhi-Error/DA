package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.priority.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class b {
    public static void a(ca caVar, int i2, double d2) {
        AppMethodBeat.i(87852);
        if (!((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HL(caVar.field_msgId)) {
            e.INSTANCE.idkeyStat(957, 0, 1, false);
            if (a.hL(i2, 8)) {
                e.INSTANCE.idkeyStat(957, 1, 1, false);
            }
            if (a.hL(i2, 4)) {
                e.INSTANCE.idkeyStat(957, 2, 1, false);
            }
            if (a.hL(i2, 2)) {
                e.INSTANCE.idkeyStat(957, 3, 1, false);
            }
            if (a.hL(i2, 16)) {
                e.INSTANCE.idkeyStat(957, 4, 1, false);
            }
            if (a.hL(i2, 1)) {
                e.INSTANCE.idkeyStat(957, 5, 1, false);
            }
            if (a.hL(i2, 32)) {
                e.INSTANCE.idkeyStat(957, 6, 1, false);
            }
            if (a.hL(i2, 64)) {
                e.INSTANCE.idkeyStat(957, 7, 1, false);
            }
            if (a.hL(i2, 128)) {
                e.INSTANCE.idkeyStat(957, 8, 1, false);
            }
            ic icVar = new ic();
            icVar.KMm = caVar.field_msgId;
            icVar.KLZ = caVar.field_talker;
            if (ab.Eq(caVar.field_talker)) {
                icVar.KMa = Util.nullAs(bp.Ks(caVar.field_content), "");
            } else {
                icVar.KMa = caVar.field_talker;
            }
            icVar.KMb = 1;
            icVar.KMc = caVar.field_createTime;
            icVar.KMd = i2;
            icVar.oTW = 1;
            icVar.KMe = 0;
            icVar.KMf = caVar.field_msgSvrId;
            icVar.KMn = 0;
            icVar.KMj = d2;
            icVar.KMk = 1;
            c c2CMsgAutoDownloadImgStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(1, icVar.KMm);
            c2CMsgAutoDownloadImgStorage.AYx.bindString(2, icVar.KLZ);
            c2CMsgAutoDownloadImgStorage.AYx.bindString(3, icVar.KMa);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(4, (long) icVar.KMb);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(5, icVar.KMc);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(6, (long) icVar.KMd);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(7, (long) icVar.oTW);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(8, icVar.KMe);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(9, icVar.KMf);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(10, (long) icVar.KMn);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(11, icVar.KMi);
            c2CMsgAutoDownloadImgStorage.AYx.bindDouble(12, icVar.KMj);
            c2CMsgAutoDownloadImgStorage.AYx.bindLong(13, (long) icVar.KMk);
            c2CMsgAutoDownloadImgStorage.AYx.execute();
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", Long.valueOf(caVar.field_msgId), caVar.field_talker, Integer.valueOf(i2), 1, Double.valueOf(d2), 1);
            c.a(3, icVar.KMc, 1, icVar);
            if (ab.Eq(caVar.field_talker)) {
                ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jp(icVar.KLZ, "@all");
            }
            ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jp(caVar.field_talker, icVar.KMa);
            AppMethodBeat.o(87852);
            return;
        }
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", Long.valueOf(caVar.field_msgId), caVar.field_talker, 1);
        ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(caVar.field_msgId, i2, 1);
        AppMethodBeat.o(87852);
    }
}
