package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class v {
    public static cjp iCu = new cjp();
    public static f<String, String> iCv = new h(100);

    private static boolean HS(String str) {
        AppMethodBeat.i(101741);
        if (str.toLowerCase().endsWith("@chatroom")) {
            AppMethodBeat.o(101741);
            return true;
        } else if (str.toLowerCase().endsWith("@im.chatroom")) {
            AppMethodBeat.o(101741);
            return true;
        } else {
            AppMethodBeat.o(101741);
            return false;
        }
    }

    public static boolean HT(String str) {
        AppMethodBeat.i(101742);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101742);
            return false;
        }
        boolean gBx = Kd.gBx();
        AppMethodBeat.o(101742);
        return gBx;
    }

    public static boolean g(String str, Map<String, String> map) {
        AppMethodBeat.i(101743);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101743);
            return false;
        }
        for (String str2 : Kd.bax()) {
            map.put(str2, Kd.getDisplayName(str2));
        }
        AppMethodBeat.o(101743);
        return true;
    }

    public static boolean HU(String str) {
        AppMethodBeat.i(101744);
        String Kf = ((c) g.af(c.class)).aSX().Kf(str);
        String aTY = z.aTY();
        if (Util.isNullOrNil(Kf) || Util.isNullOrNil(aTY) || !Kf.equals(aTY)) {
            AppMethodBeat.o(101744);
            return false;
        }
        AppMethodBeat.o(101744);
        return true;
    }

    public static void a(String str, ah ahVar, boolean z) {
        AppMethodBeat.i(101745);
        ahVar.AL(z);
        ((c) g.af(c.class)).aSX().update(ahVar, new String[0]);
        String aTY = z.aTY();
        b.bhF(str).b(str, aTY, z).aJu();
        cpi cpi = new cpi();
        cpi.KGO = str;
        cpi.UserName = aTY;
        cpi.Mvf = 1;
        cpi.Cyb = z ? 1 : 2;
        ((l) g.af(l.class)).aSM().d(new k.a(49, cpi));
        AppMethodBeat.o(101745);
    }

    public static String HV(String str) {
        String str2;
        AppMethodBeat.i(101746);
        if (str == null || !HS(str)) {
            AppMethodBeat.o(101746);
            return "";
        }
        List<String> Ic = Ic(str);
        String str3 = "";
        int i2 = 0;
        while (Ic != null && i2 < Ic.size()) {
            String str4 = Ic.get(i2);
            if (str4.length() > 0) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(str4);
                if (Kn == null) {
                    str2 = str3 + str4;
                } else {
                    str2 = str3 + Kn.arI();
                }
                if (i2 < Ic.size() - 1) {
                    str2 = str2 + MMApplicationContext.getContext().getString(R.string.awt);
                }
            } else {
                str2 = str3;
            }
            i2++;
            str3 = str2;
        }
        AppMethodBeat.o(101746);
        return str3;
    }

    public static String an(List<String> list) {
        AppMethodBeat.i(101747);
        String e2 = e(list, -1);
        AppMethodBeat.o(101747);
        return e2;
    }

    public static String e(List<String> list, int i2) {
        String str;
        AppMethodBeat.i(101748);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(101748);
            return "";
        }
        String str2 = "";
        int i3 = i2 - 1;
        int i4 = 0;
        while (true) {
            if (i4 >= list.size()) {
                break;
            }
            String str3 = list.get(i4);
            if (str3.length() > 0) {
                str = str2 + ((l) g.af(l.class)).aSN().Kn(str3).arJ();
                if (i4 == i3 && i4 < list.size()) {
                    str2 = str + "...";
                    break;
                } else if (i4 < list.size() - 1) {
                    str = str + MMApplicationContext.getContext().getString(R.string.awt);
                }
            } else {
                str = str2;
            }
            i4++;
            str2 = str;
        }
        AppMethodBeat.o(101748);
        return str2;
    }

    public static boolean HW(String str) {
        AppMethodBeat.i(101749);
        boolean C = C(str, false);
        AppMethodBeat.o(101749);
        return C;
    }

    public static boolean C(String str, boolean z) {
        AppMethodBeat.i(194522);
        String str2 = (String) g.aAh().azQ().get(2, (Object) null);
        List<String> Ic = Ic(str);
        if (Ic == null) {
            Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            if (z) {
                Log.w("MicroMsg.ChatroomMembersLogic", "isInChatRoom temp change");
                AppMethodBeat.o(194522);
                return true;
            }
            AppMethodBeat.o(194522);
            return false;
        } else if (Ic.size() == 0 || !Ic.contains(str2)) {
            Log.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + Ic.size() + " ");
            AppMethodBeat.o(194522);
            return false;
        } else {
            AppMethodBeat.o(194522);
            return true;
        }
    }

    public static boolean HX(String str) {
        AppMethodBeat.i(101750);
        if (!ab.Iw(str)) {
            AppMethodBeat.o(101750);
            return false;
        } else if (!((c) g.af(c.class)).aSX().Ki(str)) {
            Log.d("MicroMsg.ChatroomMembersLogic", "state is die");
            AppMethodBeat.o(101750);
            return true;
        } else {
            List<String> Kh = ((c) g.af(c.class)).aSX().Kh(str);
            if (Kh == null || Kh.size() == 0) {
                AppMethodBeat.o(101750);
                return true;
            }
            AppMethodBeat.o(101750);
            return false;
        }
    }

    public static boolean HY(String str) {
        AppMethodBeat.i(101751);
        if (!ab.Iw(str)) {
            AppMethodBeat.o(101751);
            return false;
        }
        Log.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
        ap aSX = ((c) g.af(c.class)).aSX();
        ah Kd = aSX.Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101751);
            return false;
        }
        Kd.field_roomflag = 1;
        boolean replace = aSX.replace(Kd);
        AppMethodBeat.o(101751);
        return replace;
    }

    public static boolean a(String str, String str2, xg xgVar, int i2, int i3, String str3, a aVar, IEvent iEvent) {
        boolean z;
        boolean z2;
        com.tencent.mm.k.a.a.b bje;
        AppMethodBeat.i(194523);
        if (str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@im.chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) {
            bv aSN = ((l) g.af(l.class)).aSN();
            ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
            if (Kd != null) {
                aVar.dTg = Kd.gBt();
            } else {
                aVar.dTg = 0;
            }
            ArrayList arrayList = new ArrayList();
            boolean z3 = false;
            Log.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + xgVar.gsq);
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = 0;
            while (true) {
                z = z3;
                if (i4 >= xgVar.gsq) {
                    break;
                }
                xh xhVar = xgVar.Lin.get(i4);
                as Kn = aSN.Kn(xhVar.UserName);
                if (Kn == null) {
                    Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    com.tencent.mm.k.a.a.b bVar = new com.tencent.mm.k.a.a.b();
                    bVar.userName = xhVar.UserName;
                    bVar.gCx = xhVar.Liu;
                    bVar.gCw = xhVar.Lit;
                    if (xgVar.Lio == 0) {
                        bVar.gCv = xhVar.Liq;
                        if (!Util.isNullOrNil(xhVar.Lis)) {
                            i Mx = p.aYB().Mx(xhVar.UserName);
                            if (Mx == null) {
                                Mx = new i();
                                Mx.username = xhVar.UserName;
                            }
                            Mx.iKX = xhVar.Lir;
                            Mx.iKW = xhVar.Lis;
                            Mx.fuz = 3;
                            Mx.fv(!Util.isNullOrNil(xhVar.Lir));
                            p.aYB().b(Mx);
                        }
                    }
                    if (!(Kd == null || (bje = Kd.bje(xhVar.UserName)) == null)) {
                        bVar.gCv = bje.gCv;
                        bVar.gCx = Util.isNullOrNil(bVar.gCx) ? bje.gCx : bVar.gCx;
                    }
                    aVar.gCs.add(bVar);
                    ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bM(xhVar.Liw, xhVar.Lix);
                    if (((int) Kn.gMZ) == 0) {
                        Kn.setUsername(xhVar.UserName);
                        if (xhVar.oUJ != null) {
                            Kn.setNickname(xhVar.oUJ);
                        }
                        Kn.BN(xhVar.Liw);
                        Kn.BM(xhVar.Lix);
                        Kn.aqP();
                        aSN.ap(Kn);
                        z = true;
                    }
                    arrayList.add(Kn.field_username);
                }
                z3 = z;
                i4++;
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + iEvent + " publish: " + z + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z) {
                ag(str, aVar.dTg);
            } else if (Kd == null) {
                ag(str, 0);
            }
            ah Kd2 = ((c) g.af(c.class)).aSX().Kd(str);
            if (Kd2 == null) {
                Kd2 = new ah();
            }
            int i5 = Kd2.field_chatroomStatus;
            long currentTimeMillis2 = System.currentTimeMillis();
            Kd2.field_chatroomname = str;
            Kd2.field_roomowner = str2;
            ah iE = Kd2.iE(arrayList);
            iE.field_chatroomStatus = i2;
            iE.field_displayname = an(arrayList);
            if (xgVar.Lio != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            iE.a(str3, aVar, z2).field_memberCount = arrayList.size();
            if (i3 != -1) {
                Kd2.field_chatroomVersion = i3;
            }
            int i6 = Kd2.field_memberCount;
            if (aTU() && !Util.isNullOrNil(str)) {
                if (MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(str, false)) {
                    Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", str);
                } else {
                    a(str, str2, i6, i2, null);
                }
            }
            boolean a2 = a(Kd2);
            if (a2 && i2 != i5) {
                ab.IC(str);
            }
            Object[] objArr = new Object[6];
            objArr[0] = Boolean.valueOf(a2);
            objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis2);
            objArr[2] = Boolean.valueOf(Kd2.gBu());
            objArr[3] = Integer.valueOf(Kd2.gBr() == null ? 0 : Kd2.gBr().dTg);
            objArr[4] = Integer.valueOf(Kd2.gBr() == null ? 0 : Kd2.gBr().gCu);
            objArr[5] = Integer.valueOf(i2);
            Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s chatroomStatus:%s", objArr);
            if (Kd2.gBu()) {
                Log.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(Kd2.gBt()));
                bc bcVar = new bc();
                bcVar.dEl.username = str;
                EventCenter.instance.publish(bcVar);
            }
            AppMethodBeat.o(194523);
            return a2;
        }
        Log.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + xgVar.gsq);
        AppMethodBeat.o(194523);
        return false;
    }

    private static void ag(String str, int i2) {
        AppMethodBeat.i(194524);
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
            b.bhF(str).H(str, i2).aJu();
            AppMethodBeat.o(194524);
            return;
        }
        cjo cjo = new cjo();
        cjo.chatroomName = str;
        cjo.dTg = i2;
        iCu.Mpi.addFirst(cjo);
        try {
            MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", iCu.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + e2.getMessage());
        }
        Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetail " + cjo.chatroomName + " " + cjo.dTg);
        AppMethodBeat.o(194524);
    }

    public static void fr(boolean z) {
        AppMethodBeat.i(194525);
        Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail ".concat(String.valueOf(z)));
        if (z && iCu.Mpi.isEmpty()) {
            AppMethodBeat.o(194525);
        } else if (z || Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.model.v.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194521);
                    Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + v.iCu.Mpi.size());
                    if (v.iCu.Mpi.isEmpty()) {
                        byte[] decodeBytes = MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).decodeBytes("detail");
                        if (decodeBytes == null) {
                            AppMethodBeat.o(194521);
                            return;
                        }
                        cjp cjp = new cjp();
                        try {
                            cjp.parseFrom(decodeBytes);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + e2.getMessage());
                        }
                        v.iCu.Mpi.addAll(cjp.Mpi);
                    }
                    if (v.iCu.Mpi.isEmpty()) {
                        Log.i("MicroMsg.ChatroomMembersLogic", "getChatroomMemberDetails is null");
                        AppMethodBeat.o(194521);
                        return;
                    }
                    Log.i("MicroMsg.ChatroomMembersLogic", "start Conversation:" + v.iCu.Mpi.size());
                    ArrayList arrayList = new ArrayList();
                    Iterator<cjo> it = v.iCu.Mpi.iterator();
                    while (it.hasNext()) {
                        cjo next = it.next();
                        if (((l) g.af(l.class)).aST().bjY(next.chatroomName) != null) {
                            b.bhF(next.chatroomName).H(next.chatroomName, next.dTg).aJu();
                            arrayList.add(next);
                            Log.i("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + next.chatroomName + " " + next.dTg);
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        v.iCu.Mpi.remove((cjo) it2.next());
                    }
                    Log.i("MicroMsg.ChatroomMembersLogic", "delete " + arrayList.size() + " " + v.iCu.Mpi.size());
                    try {
                        MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", v.iCu.toByteArray());
                    } catch (IOException e3) {
                        Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + e3.getMessage());
                    }
                    Log.i("MicroMsg.ChatroomMembersLogic", "end Conversation");
                    arrayList.clear();
                    Iterator<cjo> it3 = v.iCu.Mpi.iterator();
                    while (it3.hasNext()) {
                        cjo next2 = it3.next();
                        b.bhF(next2.chatroomName).H(next2.chatroomName, next2.dTg).aJu();
                        arrayList.add(next2);
                    }
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        v.iCu.Mpi.remove((cjo) it4.next());
                    }
                    Log.i("MicroMsg.ChatroomMembersLogic", "delete " + arrayList.size() + " " + v.iCu.Mpi.size());
                    try {
                        MultiProcessMMKV.getMMKV("getChatroomMemberDetail_" + com.tencent.mm.kernel.a.azs()).encode("detail", v.iCu.toByteArray());
                        AppMethodBeat.o(194521);
                    } catch (IOException e4) {
                        Log.e("MicroMsg.ChatroomMembersLogic", "checkGetChatroomMemberDetail " + e4.getMessage());
                        AppMethodBeat.o(194521);
                    }
                }
            }, "MicroMsg.ChatroomMembersLogic");
            AppMethodBeat.o(194525);
        } else {
            AppMethodBeat.o(194525);
        }
    }

    static {
        AppMethodBeat.i(101775);
        AppMethodBeat.o(101775);
    }

    public static boolean a(String str, xg xgVar) {
        AppMethodBeat.i(101753);
        if (xgVar == null) {
            Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            AppMethodBeat.o(101753);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            AppMethodBeat.o(101753);
            return false;
        } else if (ab.Eq(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", str);
            AppMethodBeat.o(101753);
            return false;
        } else {
            String a2 = z.a(xgVar.Lip);
            if (Util.isNullOrNil(a2)) {
                AppMethodBeat.o(101753);
                return false;
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", a2, Integer.valueOf(xgVar.Lin.size()));
            ah Kd = ((c) g.af(c.class)).aSX().Kd(a2);
            if (Kd != null && xgVar.Lin.size() > 0 && Kd.bax().contains(xgVar.Lin.get(0).UserName)) {
                String str2 = xgVar.Lin.get(0).UserName;
                com.tencent.mm.k.a.a.b bje = Kd.bje(str2);
                if (bje != null) {
                    Log.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", str2, bje.gCv);
                    bje.gCx = xgVar.Lin.get(0).Liu;
                    a(Kd);
                } else {
                    Log.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", str2);
                }
                AppMethodBeat.o(101753);
                return true;
            } else if (Kd == null || xgVar.Lin.size() <= 0) {
                if (xgVar.Lin.size() <= 0) {
                    Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (Kd != null) {
                    Log.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                AppMethodBeat.o(101753);
                return false;
            } else {
                bd bdVar = new bd();
                bdVar.dEm.username = xgVar.Lin.get(0).UserName;
                bdVar.dEm.dEn = xgVar.Lin.get(0).Liu;
                iCv.put(a2 + "#" + bdVar.dEm.username, bdVar.dEm.dEn);
                EventCenter.instance.publish(bdVar);
                AppMethodBeat.o(101753);
                return false;
            }
        }
    }

    public static String aF(String str, String str2) {
        AppMethodBeat.i(101754);
        String str3 = str2 + "#" + str;
        if (iCv.checkAndUpTime(str3)) {
            String str4 = iCv.get(str3);
            AppMethodBeat.o(101754);
            return str4;
        }
        AppMethodBeat.o(101754);
        return "";
    }

    public static boolean a(ah ahVar) {
        AppMethodBeat.i(101755);
        if (ahVar == null) {
            Log.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            AppMethodBeat.o(101755);
            return false;
        }
        boolean replace = ((c) g.af(c.class)).aSX().replace(ahVar);
        if (replace) {
            aG(ahVar.field_chatroomname, ahVar.field_roomowner);
        }
        AppMethodBeat.o(101755);
        return replace;
    }

    private static void aG(String str, String str2) {
        AppMethodBeat.i(101756);
        Log.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", 1);
        bv aSN = ((l) g.af(l.class)).aSN();
        as Kn = aSN.Kn(str);
        if (((int) Kn.gMZ) != 0 && !Util.isNullOrNil(str2) && !Util.isNullOrNil(z.aTY())) {
            if (str2.equals(z.aTY())) {
                Kn.oS(1);
            } else {
                Kn.oS(0);
            }
            aSN.c(str, Kn);
        }
        AppMethodBeat.o(101756);
    }

    public static boolean a(String str, afg afg) {
        AppMethodBeat.i(101757);
        if (!HS(str) || afg.gsq == 0) {
            Log.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + afg.gsq);
            AppMethodBeat.o(101757);
            return false;
        }
        ap aSX = ((c) g.af(c.class)).aSX();
        ah Kd = aSX.Kd(str);
        List<String> bji = ah.bji(Kd.field_memberlist);
        Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + bji.size());
        Iterator<afq> it = afg.KGQ.iterator();
        while (it.hasNext()) {
            bji.remove(z.a(it.next().Lqp));
        }
        Log.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + bji.size());
        ah iE = Kd.iE(bji);
        iE.field_displayname = an(bji);
        iE.field_memberCount = bji.size();
        boolean replace = aSX.replace(Kd);
        Log.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(replace)));
        AppMethodBeat.o(101757);
        return replace;
    }

    public static boolean a(String str, ct ctVar) {
        as a2;
        AppMethodBeat.i(101758);
        if (!HS(str) || ctVar.gsq == 0) {
            Log.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + ctVar.gsq);
            AppMethodBeat.o(101758);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        bv aSN = ((l) g.af(l.class)).aSN();
        for (int i2 = 0; i2 < ctVar.gsq; i2++) {
            String a3 = z.a(ctVar.KGQ.get(i2).Lqp);
            if (ctVar.KGQ.get(i2).MuH == 0) {
                if (Util.isNullOrNil(a3)) {
                    Log.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    as Kn = aSN.Kn(a3);
                    if (((int) Kn.gMZ) != 0) {
                        Kn.aqP();
                        aSN.c(Kn.field_username, Kn);
                        a2 = Kn;
                    } else {
                        a2 = a(Kn, ctVar.KGQ.get(i2));
                        aSN.ap(a2);
                    }
                    arrayList.add(a2.field_username);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            boolean a4 = a(str, arrayList, (String) null);
            AppMethodBeat.o(101758);
            return a4;
        }
        AppMethodBeat.o(101758);
        return false;
    }

    public static boolean HZ(String str) {
        AppMethodBeat.i(101759);
        if (!str.toLowerCase().endsWith("@groupcard")) {
            Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
            AppMethodBeat.o(101759);
            return false;
        }
        bv aSN = ((l) g.af(l.class)).aSN();
        if (aSN.bjN(str)) {
            aSN.aNa(str);
        } else {
            Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
        }
        boolean Ib = Ib(str);
        AppMethodBeat.o(101759);
        return Ib;
    }

    public static boolean Ia(String str) {
        AppMethodBeat.i(101760);
        if (!HS(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
            AppMethodBeat.o(101760);
            return false;
        }
        bv aSN = ((l) g.af(l.class)).aSN();
        if (aSN.bjN(str)) {
            aSN.aNa(str);
        } else {
            Log.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
        }
        boolean Ib = Ib(str);
        AppMethodBeat.o(101760);
        return Ib;
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List list;
        int i2 = 0;
        AppMethodBeat.i(101761);
        ap aSX = ((c) g.af(c.class)).aSX();
        ah Ke = aSX.Ke(str);
        if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            list = Ic(str);
        } else {
            list = new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                linkedList.add(list.get(i3));
            }
            while (i2 < arrayList.size()) {
                if (!list.contains(arrayList.get(i2))) {
                    linkedList.add(arrayList.get(i2));
                }
                i2++;
            }
            if (!Util.isNullOrNil(str2)) {
                Ke.field_roomowner = str2;
            }
            ah iE = Ke.iE(linkedList);
            iE.field_displayname = an(linkedList);
            iE.field_memberCount = linkedList.size();
            boolean replace = aSX.replace(Ke);
            AppMethodBeat.o(101761);
            return replace;
        }
        while (i2 < arrayList.size()) {
            linkedList.add(arrayList.get(i2));
            i2++;
        }
        if (!Util.isNullOrNil(str2)) {
            Ke.field_roomowner = str2;
        }
        ah iE2 = Ke.iE(linkedList);
        iE2.field_displayname = an(linkedList);
        iE2.field_memberCount = linkedList.size();
        Ke.field_roomowner = str2;
        boolean replace2 = aSX.replace(Ke);
        Log.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(replace2)));
        AppMethodBeat.o(101761);
        return replace2;
    }

    private static boolean Ib(String str) {
        AppMethodBeat.i(101762);
        boolean Kj = ((c) g.af(c.class)).aSX().Kj(str);
        AppMethodBeat.o(101762);
        return Kj;
    }

    public static List<String> Ic(String str) {
        AppMethodBeat.i(101763);
        if (str == null) {
            Log.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            AppMethodBeat.o(101763);
            return null;
        } else if (!HS(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            AppMethodBeat.o(101763);
            return null;
        } else {
            List<String> Kh = ((c) g.af(c.class)).aSX().Kh(str);
            AppMethodBeat.o(101763);
            return Kh;
        }
    }

    public static List<String> Id(String str) {
        AppMethodBeat.i(101764);
        if (!str.toLowerCase().endsWith("@chatroom")) {
            Log.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
            AppMethodBeat.o(101764);
            return null;
        }
        List<String> Kh = ((c) g.af(c.class)).aSX().Kh(str);
        AppMethodBeat.o(101764);
        return Kh;
    }

    public static int Ie(String str) {
        AppMethodBeat.i(101765);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ap aSX = ((c) g.af(c.class)).aSX();
            if (aSX != null) {
                int Kk = aSX.Kk(str);
                Log.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(101765);
                return Kk;
            }
            Log.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(101765);
            return 0;
        } catch (Throwable th) {
            Log.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(101765);
            throw th;
        }
    }

    public static List<String> If(String str) {
        int i2 = 0;
        AppMethodBeat.i(101766);
        if (!HS(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
            AppMethodBeat.o(101766);
            return null;
        }
        List<String> Ic = Ic(str);
        if (Ic == null || Ic.size() <= 0) {
            AppMethodBeat.o(101766);
            return null;
        }
        String str2 = (String) g.aAh().azQ().get(2, (Object) null);
        Assert.assertTrue(str2 != null && str2.length() > 0);
        while (true) {
            if (i2 >= Ic.size()) {
                break;
            } else if (Ic.get(i2).equals(str2)) {
                Ic.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        if (Ic.size() <= 0) {
            AppMethodBeat.o(101766);
            return null;
        }
        AppMethodBeat.o(101766);
        return Ic;
    }

    public static as a(as asVar, coo coo) {
        AppMethodBeat.i(101767);
        asVar.setUsername(z.a(coo.Lqp));
        asVar.setNickname(z.a(coo.Lqp));
        asVar.BF(z.a(coo.Lqp));
        asVar.BG(z.a(coo.LpB));
        asVar.nj(coo.kdY);
        asVar.BD(z.a(coo.MuI));
        asVar.BJ(z.a(coo.MuJ));
        asVar.BI(z.a(coo.LpB));
        asVar.nl(coo.LoM);
        asVar.nn(coo.kec);
        asVar.Cb(RegionCodeDecoder.bq(coo.keh, coo.kdZ, coo.kea));
        asVar.BV(coo.keb);
        AppMethodBeat.o(101767);
        return asVar;
    }

    public static String ah(String str, String str2) {
        AppMethodBeat.i(101768);
        ap aSX = ((c) g.af(c.class)).aSX();
        if (aSX == null) {
            Log.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
            AppMethodBeat.o(101768);
            return null;
        }
        ah Kd = aSX.Kd(str2);
        if (Kd == null) {
            AppMethodBeat.o(101768);
            return null;
        }
        String displayName = Kd.getDisplayName(str);
        AppMethodBeat.o(101768);
        return displayName;
    }

    public static String Ig(String str) {
        AppMethodBeat.i(101769);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101769);
            return null;
        }
        String str2 = Kd.field_chatroomnotice;
        AppMethodBeat.o(101769);
        return str2;
    }

    public static boolean Ih(String str) {
        AppMethodBeat.i(194526);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            Log.w("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo member is null");
            AppMethodBeat.o(194526);
            return false;
        }
        Log.i("MicroMsg.ChatroomMembersLogic", "isNeedUpdateChatroomInfo old:%s new:%s", Integer.valueOf(Kd.field_oldChatroomVersion), Integer.valueOf(Kd.field_chatroomVersion));
        if (Kd.field_oldChatroomVersion < Kd.field_chatroomVersion) {
            AppMethodBeat.o(194526);
            return true;
        }
        AppMethodBeat.o(194526);
        return false;
    }

    public static String Ii(String str) {
        AppMethodBeat.i(101771);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101771);
            return null;
        }
        String str2 = Kd.field_chatroomnoticeEditor;
        AppMethodBeat.o(101771);
        return str2;
    }

    public static long Ij(String str) {
        AppMethodBeat.i(101772);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101772);
            return -1;
        }
        long j2 = Kd.field_chatroomnoticePublishTime;
        AppMethodBeat.o(101772);
        return j2;
    }

    public static void a(String str, String str2, String str3, long j2, int i2, int i3) {
        AppMethodBeat.i(101773);
        ap aSX = ((c) g.af(c.class)).aSX();
        ah Kd = aSX.Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101773);
            return;
        }
        String str4 = Kd.field_chatroomnotice;
        Kd.field_oldChatroomVersion = i2;
        Kd.field_chatroomnoticePublishTime = j2;
        Kd.field_chatroomnoticeEditor = str3;
        Kd.field_chatroomnotice = str2;
        Kd.field_chatroomStatus = i3;
        aSX.replace(Kd);
        if (Util.isNullOrNil(str2) && !Util.isNullOrNil(str4)) {
            g.aAi();
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            long j3 = Kn.fve;
            Kn.yz(0);
            g.aAi();
            ((l) g.af(l.class)).aSN().ao(Kn);
            Log.i("MicroMsg.ChatroomMembersLogic", "clear room card, oldInfoId %s", Long.valueOf(j3));
            if (j3 != 0) {
                ((t) g.af(t.class)).r(str, j3);
            }
        }
        AppMethodBeat.o(101773);
    }

    public static void ah(String str, int i2) {
        AppMethodBeat.i(101774);
        ap aSX = ((c) g.af(c.class)).aSX();
        ah Kd = aSX.Kd(str);
        if (Kd == null) {
            AppMethodBeat.o(101774);
            return;
        }
        a gBy = Kd.gBy();
        gBy.type = i2;
        Kd.a(str, gBy, false);
        aSX.replace(Kd);
        AppMethodBeat.o(101774);
    }

    public static void aTR() {
        AppMethodBeat.i(184633);
        PluginNewTips.removeLocalNewTipsCallback(d.ADs);
        AppMethodBeat.o(184633);
    }

    public static void a(String str, PluginNewTips.a aVar) {
        AppMethodBeat.i(184634);
        if (!aTU()) {
            AppMethodBeat.o(184634);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(184634);
        } else if (MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean(str, false)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member isHandle", str);
            AppMethodBeat.o(184634);
        } else {
            ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
            if (Kd == null) {
                Log.e("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom %s member is null", str);
                AppMethodBeat.o(184634);
                return;
            }
            a(str, Kd.field_roomowner, Kd.field_memberCount, Kd.field_chatroomStatus, aVar);
            AppMethodBeat.o(184634);
        }
    }

    private static void a(String str, String str2, int i2, int i3, PluginNewTips.a aVar) {
        int i4 = 1;
        AppMethodBeat.i(184635);
        if (ab.Ix(str) && (((long) i3) & 131072) != 131072 && (((long) i3) & 65536) == 65536) {
            MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean(str, true);
            boolean bkC = com.tencent.mm.openim.room.a.a.bkC();
            int aTT = aTT();
            Log.i("MicroMsg.ChatroomMembersLogic", "handleAssociateOpenImChatroom chatRoomName:%s chatroomOwner:%s chatroomStatus:%s isInstallWeWork:%s maxNum:%s", str, Util.nullAs(str2, BuildConfig.COMMAND), Integer.valueOf(i3), Boolean.valueOf(bkC), Integer.valueOf(aTT));
            if (!bkC || i2 >= aTT || !Util.isEqual(str2, z.aTY())) {
                if (bkC) {
                    i4 = 0;
                }
                if (!Util.isEqual(str2, z.aTY())) {
                    i4 |= 2;
                }
                if (i2 >= aTT) {
                    i4 |= 4;
                }
                ai(str, i4);
            } else {
                com.tencent.mm.plugin.newtips.a.exl();
                com.tencent.mm.plugin.newtips.a.i.b(d.ADs, aVar);
                MultiProcessMMKV.getMMKV("room_upgrade_to_wework").putBoolean("enter_show", true);
                String string = MMApplicationContext.getResources().getString(R.string.awz);
                String string2 = MMApplicationContext.getResources().getString(R.string.ax1);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(string).append(" ");
                stringBuffer.append("<_wc_custom_link_ href=\"weixin://weixingroupupdate?roomname=").append(str).append("\">").append(string2).append("</_wc_custom_link_>");
                ca caVar = new ca();
                caVar.nv(0);
                caVar.Cy(str);
                caVar.setStatus(3);
                caVar.setContent(stringBuffer.toString());
                caVar.setCreateTime(bp.C(str, System.currentTimeMillis() / 1000));
                caVar.setType(10000);
                caVar.setFlag(caVar.field_flag | 8);
                bp.x(caVar);
                ai(str, 0);
                AppMethodBeat.o(184635);
                return;
            }
        }
        AppMethodBeat.o(184635);
    }

    public static boolean aTS() {
        AppMethodBeat.i(184636);
        boolean z = MultiProcessMMKV.getMMKV("room_upgrade_to_wework").getBoolean("enter_show", false);
        AppMethodBeat.o(184636);
        return z;
    }

    public static int aTT() {
        AppMethodBeat.i(184637);
        int i2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("AssociateChatRoomLocalCheckMaxMemberCount", 200);
        AppMethodBeat.o(184637);
        return i2;
    }

    public static boolean aTU() {
        AppMethodBeat.i(194527);
        if (((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMForwardUpgradeChatRoomSwitch", 0) == 1) {
            AppMethodBeat.o(194527);
            return true;
        }
        AppMethodBeat.o(194527);
        return false;
    }

    private static void ai(String str, int i2) {
        AppMethodBeat.i(184638);
        eu euVar = new eu();
        euVar.rS(str);
        euVar.eEu = (long) i2;
        euVar.bfK();
        AppMethodBeat.o(184638);
    }

    public static void Ik(String str) {
        boolean z;
        AppMethodBeat.i(194528);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail username is null");
            AppMethodBeat.o(194528);
            return;
        }
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd != null) {
            if (Kd.field_oldChatroomVersion < Kd.field_chatroomVersion) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.ChatroomMembersLogic", "checkUpdateChatRoomInfoDetail() %s update, stack:%s", str, Util.getStack().toString());
                jj jjVar = new jj();
                jjVar.dOd.dOe = str;
                EventCenter.instance.publish(jjVar);
            }
        }
        AppMethodBeat.o(194528);
    }
}
