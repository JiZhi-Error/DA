package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;

public final class k implements w {
    public boolean taE = true;
    public boolean taF = true;

    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e7 A[SYNTHETIC, Splitter:B:72:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f2 A[SYNTHETIC, Splitter:B:78:0x01f2] */
    @Override // com.tencent.mm.plugin.fav.a.w
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(com.tencent.mm.plugin.fav.a.g r13) {
        /*
        // Method dump skipped, instructions count: 930
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.a.k.u(com.tencent.mm.plugin.fav.a.g):boolean");
    }

    public static boolean i(aml aml) {
        AppMethodBeat.i(103407);
        if (aml == null) {
            AppMethodBeat.o(103407);
            return true;
        }
        switch (aml.dataType) {
            case 2:
            case 8:
                if (!new o(b.d(aml)).exists()) {
                    AppMethodBeat.o(103407);
                    return true;
                }
                AppMethodBeat.o(103407);
                return false;
            case 3:
                AppMethodBeat.o(103407);
                return true;
            case 4:
                if (new o(b.d(aml)).exists()) {
                    AppMethodBeat.o(103407);
                    return false;
                }
                boolean isNullOrNil = Util.isNullOrNil(aml.Lvu);
                AppMethodBeat.o(103407);
                return isNullOrNil;
            case 7:
            case 29:
                if (!Util.isNullOrNil(aml.Lvu) || !Util.isNullOrNil(aml.Lvw) || !Util.isNullOrNil(aml.Lvy) || !Util.isNullOrNil(aml.Lvy)) {
                    AppMethodBeat.o(103407);
                    return false;
                }
                AppMethodBeat.o(103407);
                return true;
            case 15:
                if (Util.safeParseInt(h.aqJ().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    Log.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    AppMethodBeat.o(103407);
                    return true;
                } else if (new o(b.d(aml)).exists()) {
                    AppMethodBeat.o(103407);
                    return false;
                } else {
                    AppMethodBeat.o(103407);
                    return true;
                }
            default:
                AppMethodBeat.o(103407);
                return false;
        }
    }

    public static boolean v(g gVar) {
        AppMethodBeat.i(103408);
        if (gVar == null) {
            AppMethodBeat.o(103408);
            return false;
        } else if (gVar.field_itemStatus <= 0 || b.g(gVar)) {
            g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(gVar.field_localId);
            o oVar = new o(b.d(b.c(gVar)));
            switch (gVar.field_type) {
                case 2:
                case 8:
                    if (!oVar.exists()) {
                        AppMethodBeat.o(103408);
                        return true;
                    }
                    break;
                case 4:
                    if (Util.isNullOrNil(b.c(gVar).Lvu) && !oVar.exists()) {
                        AppMethodBeat.o(103408);
                        return true;
                    }
                case 14:
                case 18:
                    if (gVar.field_id > 0 || DY == null) {
                        if (gVar.field_favProto != null && gVar.field_favProto.ppH.size() > 1) {
                            Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                            while (it.hasNext()) {
                                aml next = it.next();
                                if (!Util.isNullOrNil(next.KuR) && !Util.isNullOrNil(next.Lvp) && !s.YS(b.d(next))) {
                                    AppMethodBeat.o(103408);
                                    return true;
                                }
                            }
                            break;
                        } else {
                            AppMethodBeat.o(103408);
                            return false;
                        }
                    } else {
                        AppMethodBeat.o(103408);
                        return false;
                    }
                case 16:
                    if (Util.safeParseInt(h.aqJ().getValue("SIGHTCannotTransmitForFav")) != 0) {
                        Log.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                        AppMethodBeat.o(103408);
                        return false;
                    } else if (!oVar.exists()) {
                        AppMethodBeat.o(103408);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.o(103408);
            return false;
        } else {
            AppMethodBeat.o(103408);
            return false;
        }
    }
}
