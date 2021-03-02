package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class ad {
    public static String cf(String str, long j2) {
        AppMethodBeat.i(232912);
        String f2 = f(q.bcR().H(str, j2));
        if (f2 != null) {
            AppMethodBeat.o(232912);
            return f2;
        }
        AppMethodBeat.o(232912);
        return null;
    }

    public static String cg(String str, long j2) {
        AppMethodBeat.i(232913);
        String f2 = f(q.bcR().G(str, j2));
        if (f2 != null) {
            AppMethodBeat.o(232913);
            return f2;
        }
        AppMethodBeat.o(232913);
        return null;
    }

    private static String f(g gVar) {
        String str;
        AppMethodBeat.i(34823);
        if (gVar != null) {
            if (!gVar.bcv() || (str = gVar.iXm) == null || !s.YS(str)) {
                String o = q.bcR().o(gVar.iXm, null, null);
                if (o == null || !s.YS(o)) {
                    String o2 = q.bcR().o(gVar.iXo, null, null);
                    if (o2 != null && s.YS(o2)) {
                        AppMethodBeat.o(34823);
                        return o2;
                    }
                } else {
                    AppMethodBeat.o(34823);
                    return o;
                }
            } else {
                AppMethodBeat.o(34823);
                return str;
            }
        }
        AppMethodBeat.o(34823);
        return null;
    }

    public static String b(ca caVar, k.b bVar) {
        c bdx;
        AppMethodBeat.i(34824);
        String str = "";
        if (bVar != null && !Util.isNullOrNil(bVar.dCK) && (bdx = ao.cgO().bdx(bVar.dCK)) != null && bdx.deQ() && s.YS(bdx.field_fileFullPath)) {
            str = bdx.field_fileFullPath;
        }
        if (!Util.isNullOrNil(str)) {
            Log.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
            AppMethodBeat.o(34824);
        } else {
            if (caVar != null) {
                str = q.bcR().R(caVar.field_imgPath, true);
            }
            Log.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
            AppMethodBeat.o(34824);
        }
        return str;
    }
}
