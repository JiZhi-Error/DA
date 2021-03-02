package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public static boolean a(cz czVar) {
        int i2;
        AppMethodBeat.i(106604);
        if (!(czVar.dFZ.dGb == null || czVar.dFZ.dGb.ppH == null)) {
            Iterator<aml> it = czVar.dFZ.dGb.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                if ((next.Lwh == null || next.Lwh.Lxi == null) && (((i2 = next.dataType) == 2 || i2 == 4 || i2 == 15 || i2 == 8) && Util.isNullOrNil(next.KuR))) {
                    if (Util.isNullOrNil(next.LvL)) {
                        AppMethodBeat.o(106604);
                        return false;
                    } else if (!s.YS(next.LvL)) {
                        AppMethodBeat.o(106604);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(106604);
        return true;
    }

    static int b(cz czVar) {
        String str;
        AppMethodBeat.i(106605);
        g gVar = new g();
        gVar.field_favProto = czVar.dFZ.dGb;
        gVar.field_sessionId = czVar.dFZ.sessionId;
        if (!b(gVar, czVar.dFZ.dGf)) {
            g asb = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().asb(gVar.field_sourceId);
            if (asb != null) {
                com.tencent.mm.plugin.fav.a.b.DN(asb.field_localId);
            }
            AppMethodBeat.o(106605);
        } else {
            gVar.field_flag = 0;
            gVar.field_updateTime = System.currentTimeMillis();
            gVar.field_localId = System.currentTimeMillis();
            com.tencent.mm.plugin.fav.a.b.DN(gVar.field_localId);
            gVar.field_type = czVar.dFZ.type;
            if (czVar.dFZ.desc == null || czVar.dFZ.desc.length() < 10001) {
                gVar.field_favProto.bhe(czVar.dFZ.desc);
            } else {
                Log.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                gVar.field_favProto.bhe(czVar.dFZ.desc.substring(0, 10001));
            }
            gVar.field_xml = g.t(gVar);
            D(gVar);
            com.tencent.mm.plugin.fav.a.b.j(gVar);
            gVar.arR("MicroMsg.Fav.FavAddService");
            if (5 == czVar.dFZ.type) {
                String str2 = "";
                if (gVar.field_favProto.LwS != null) {
                    str2 = gVar.field_favProto.LwS.LyC;
                }
                if (gVar.field_favProto.Lya == null || !Util.isNullOrNil(str2)) {
                    str = str2;
                } else {
                    str = gVar.field_favProto.Lya.link;
                }
                ((ae) com.tencent.mm.kernel.g.af(ae.class)).add(str);
            }
            AppMethodBeat.o(106605);
        }
        return 0;
    }

    public static void C(g gVar) {
        AppMethodBeat.i(106606);
        gVar.field_updateTime = System.currentTimeMillis();
        if (!com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            gVar.field_localId = System.currentTimeMillis();
        }
        D(gVar);
        com.tencent.mm.plugin.fav.a.b.j(gVar);
        AppMethodBeat.o(106606);
    }

    private static void D(g gVar) {
        AppMethodBeat.i(106607);
        h.DQ(gVar.field_localId);
        if (gVar.field_favProto.ppH.size() > 0) {
            ThreadPool.post(new a(gVar), "AddFavService_copy");
            AppMethodBeat.o(106607);
            return;
        }
        gVar.field_itemStatus = 9;
        if (!com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(gVar);
        } else {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, new String[0]);
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
        AppMethodBeat.o(106607);
    }

    private static boolean b(g gVar, int i2) {
        AppMethodBeat.i(106608);
        anh anh = gVar.field_favProto.Lya;
        if (anh != null) {
            gVar.field_sourceId = anh.Lyi;
            if (E(gVar)) {
                Log.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                AppMethodBeat.o(106608);
                return false;
            }
            switch (anh.sourceType) {
                case 1:
                    if (!ab.IT(gVar.field_fromUser)) {
                        if (!ab.Eq(gVar.field_fromUser)) {
                            gVar.field_sourceType = 21;
                            break;
                        } else {
                            gVar.field_sourceType = 22;
                            break;
                        }
                    } else {
                        gVar.field_sourceType = 23;
                        break;
                    }
                case 2:
                default:
                    gVar.field_sourceType = anh.sourceType;
                    break;
                case 3:
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                gVar.field_sourceType = anh.sourceType;
                                break;
                            } else {
                                gVar.field_sourceType = 26;
                                break;
                            }
                        } else {
                            gVar.field_sourceType = 25;
                            break;
                        }
                    } else {
                        gVar.field_sourceType = 24;
                        break;
                    }
            }
            gVar.field_fromUser = anh.dRL;
            gVar.field_toUser = anh.toUser;
            gVar.field_sourceId = anh.Lyi;
            gVar.field_sourceCreateTime = anh.createTime;
        }
        Log.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", gVar.field_fromUser, gVar.field_toUser, gVar.field_sourceId, Integer.valueOf(gVar.field_sourceType));
        AppMethodBeat.o(106608);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        g tbr;

        public a(g gVar) {
            this.tbr = gVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d1  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01da  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0205  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 561
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.b.a.run():void");
        }
    }

    private static boolean E(g gVar) {
        AppMethodBeat.i(106609);
        if (gVar.field_sourceId == null || gVar.field_sourceId.equals("")) {
            AppMethodBeat.o(106609);
            return false;
        }
        g asb = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().asb(gVar.field_sourceId);
        if (asb != null && asb.field_id > 0) {
            HZ(asb.field_id);
        }
        if (asb != null) {
            AppMethodBeat.o(106609);
            return true;
        }
        AppMethodBeat.o(106609);
        return false;
    }

    private static void HZ(int i2) {
        AppMethodBeat.i(106610);
        if (i2 <= 0) {
            Log.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", Integer.valueOf(i2));
            AppMethodBeat.o(106610);
            return;
        }
        LinkedList linkedList = new LinkedList();
        cps cps = new cps();
        cps.MvI = 1;
        cps.MvJ = (int) (System.currentTimeMillis() / 1000);
        linkedList.add(cps);
        com.tencent.mm.kernel.g.azz().a(new am(i2, linkedList, null), 0);
        AppMethodBeat.o(106610);
    }
}
