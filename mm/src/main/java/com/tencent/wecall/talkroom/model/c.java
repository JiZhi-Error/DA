package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static boolean DEBUG = false;
    public static boolean Suk = false;
    private static final d<c> Sul = new d<c>() {
        /* class com.tencent.wecall.talkroom.model.c.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.pb.common.c.d
        public final /* synthetic */ c oR() {
            AppMethodBeat.i(62790);
            c cVar = new c((byte) 0);
            AppMethodBeat.o(62790);
            return cVar;
        }
    };
    private Map<String, TalkRoom> Sum;
    private Map<String, String> Sun;
    g Suo;

    /* synthetic */ c(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(62716);
        AppMethodBeat.o(62716);
    }

    public static c hqY() {
        AppMethodBeat.i(62701);
        c cVar = Sul.get();
        AppMethodBeat.o(62701);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(62702);
        this.Sum = new HashMap();
        this.Sun = new HashMap();
        b.d("TalkRoomManager", "asyncLoadCache");
        AppMethodBeat.o(62702);
    }

    public final boolean dG(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(62703);
        if (TextUtils.isEmpty(str)) {
            b.w("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            AppMethodBeat.o(62703);
            return false;
        }
        TalkRoom brg = brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            AppMethodBeat.o(62703);
            return false;
        }
        List<d> hqP = brg.hqP();
        if (hqP == null) {
            b.w("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            AppMethodBeat.o(62703);
            return false;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (d dVar : hqP) {
            if (dVar != null) {
                dVar.hra();
                TalkRoom.hqL();
                if (dVar.getState() != 10) {
                    z2 = z3;
                } else if (dVar.isSelf()) {
                    z2 = true;
                } else {
                    z2 = z3;
                    z4 = true;
                }
                if (z && z4) {
                    AppMethodBeat.o(62703);
                    return true;
                } else if (!z2 || !z4) {
                    z3 = z2;
                } else {
                    b.w("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    AppMethodBeat.o(62703);
                    return true;
                }
            }
        }
        AppMethodBeat.o(62703);
        return false;
    }

    public final TalkRoom brg(String str) {
        AppMethodBeat.i(62704);
        TalkRoom talkRoom = this.Sum.get(str);
        if (talkRoom == null && j.bru(str)) {
            talkRoom = this.Sum.get(this.Sun.get(str));
        }
        AppMethodBeat.o(62704);
        return talkRoom;
    }

    public final void brh(String str) {
        String str2;
        AppMethodBeat.i(62705);
        try {
            TalkRoom brg = brg(str);
            if (brg == null) {
                b.w("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
                AppMethodBeat.o(62705);
                return;
            }
            d brf = brg.brf(a.hjq());
            if (brf != null) {
                brf.Sup.status = 20;
                brf.Sup.qrD = -1;
            }
            Object[] objArr = new Object[2];
            objArr[0] = "resetRoomTempInfo groupId: ";
            if (brg.zHD == null) {
                str2 = "";
            } else {
                str2 = brg.zHD;
            }
            objArr[1] = str2;
            b.d("tagorewang:TalkRoom", objArr);
            hqZ();
            AppMethodBeat.o(62705);
        } catch (Throwable th) {
            b.w("TalkRoomManager", "handleRoomExit: ", th);
            AppMethodBeat.o(62705);
        }
    }

    public final int bri(String str) {
        AppMethodBeat.i(62706);
        if (TextUtils.isEmpty(str)) {
            b.w("TalkRoomManager", "getSelfMemberId invalid groupId");
            AppMethodBeat.o(62706);
            return -1;
        }
        TalkRoom brg = brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            AppMethodBeat.o(62706);
            return -1;
        }
        d brf = brg.brf(a.hjq());
        if (brf != null) {
            b.w("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.hjq(), " memberId: ", Integer.valueOf(brf.getMemberId()));
            int memberId = brf.getMemberId();
            AppMethodBeat.o(62706);
            return memberId;
        }
        b.w("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        AppMethodBeat.o(62706);
        return -1;
    }

    public final int brj(String str) {
        AppMethodBeat.i(62707);
        if (TextUtils.isEmpty(str)) {
            b.w("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            AppMethodBeat.o(62707);
            return 0;
        }
        TalkRoom brg = brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
            AppMethodBeat.o(62707);
            return 0;
        }
        int hqM = brg.hqM();
        AppMethodBeat.o(62707);
        return hqM;
    }

    public final boolean e(String str, String str2, String... strArr) {
        AppMethodBeat.i(62708);
        b.d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!j.bru(str)) {
            b.w("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            AppMethodBeat.o(62708);
            return false;
        } else if (strArr == null || strArr.length == 0) {
            b.w("TalkRoomManager", "newTmpGroup empty uuid array");
            AppMethodBeat.o(62708);
            return false;
        } else {
            try {
                a.az azVar = new a.az();
                azVar.dLt = 0;
                azVar.RFQ = str2;
                azVar.RFP = com.tencent.pb.a.a.a.hjq();
                TalkRoom talkRoom = new TalkRoom(str, null, azVar);
                int length = strArr.length;
                for (int i2 = 0; i2 != length; i2++) {
                    String str3 = strArr[i2];
                    a.bb bbVar = new a.bb();
                    bbVar.dLN = str3;
                    bbVar.RGr = com.tencent.pb.a.a.a.hjq();
                    bbVar.status = 20;
                    bbVar.qrD = -1;
                    bbVar.RGf = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(bbVar, new a.bc()));
                }
                this.Sum.put(str, talkRoom);
                hqZ();
                AppMethodBeat.o(62708);
                return true;
            } catch (Exception e2) {
                b.w("TalkRoomManager", "newTmpGroup err: ", e2);
                AppMethodBeat.o(62708);
                return false;
            }
        }
    }

    public final boolean a(String str, String str2, Integer num, int i2, long j2, a.az azVar, a.bb[] bbVarArr, a.bc[] bcVarArr, boolean z, boolean z2) {
        String str3;
        AppMethodBeat.i(199681);
        b.d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z2));
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            b.w("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            AppMethodBeat.o(199681);
            return false;
        }
        if (j.bru(str2)) {
            this.Sun.put(str2, str3);
        }
        TalkRoom talkRoom = this.Sum.get(str3);
        if (TextUtils.isEmpty(str2) || talkRoom == null || azVar == null || azVar.dLt == 100) {
            if (talkRoom == null) {
                if (j.bru(str2)) {
                    talkRoom = this.Sum.get(str2);
                }
                if (talkRoom != null) {
                    this.Sum.put(str3, talkRoom);
                }
            }
            if (talkRoom != null && z2) {
                int hrA = j.hrA();
                long hrB = j.hrB();
                b.d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(hrA), " and roomKey: ", Long.valueOf(j2));
                if (hrA != 0 && hrA != i2) {
                    b.w("TalkRoomManager", "diff roomId: ", Integer.valueOf(hrA), " -> ", Integer.valueOf(i2));
                    AppMethodBeat.o(199681);
                    return false;
                } else if (!(0 == hrB || hrB == j2)) {
                    b.w("TalkRoomManager", "diff roomKey: ", Long.valueOf(hrB), " -> ", Long.valueOf(j2));
                    AppMethodBeat.o(199681);
                    return false;
                }
            }
            if (talkRoom == null) {
                b.d("TalkRoomManager", "newOrUpdateGroup create groupId: ", str3);
                this.Sum.put(str3, TalkRoom.a(str3, str2, num, i2, j2, azVar, bbVarArr, bcVarArr));
            } else {
                b.d("TalkRoomManager", "newOrUpdateGroup update groupId: ", str3);
                TalkRoom.a(talkRoom, str3, str2, num, i2, j2, azVar, bbVarArr, bcVarArr);
            }
            if (this.Suo != null && z) {
                this.Suo.f(brn(str3));
            }
            hqZ();
            AppMethodBeat.o(199681);
            return true;
        }
        b.w("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
        AppMethodBeat.o(199681);
        return false;
    }

    private static void hqZ() {
        AppMethodBeat.i(62710);
        b.d("TalkRoomManager", "asyncWriteBackCache");
        AppMethodBeat.o(62710);
    }

    public final int brk(String str) {
        AppMethodBeat.i(62711);
        TalkRoom brg = brg(str);
        if (brg == null) {
            AppMethodBeat.o(62711);
            return 0;
        }
        int size = brg.Sui.size();
        b.d("TalkRoomManager", "getGroupMemberSize groupid: ", str, " size: ", Integer.valueOf(size));
        AppMethodBeat.o(62711);
        return size;
    }

    public final String M(String str, int i2, long j2) {
        AppMethodBeat.i(62712);
        if (i2 == 0 && j2 == 0) {
            b.w("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            AppMethodBeat.o(62712);
            return null;
        }
        TalkRoom brg = brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
            AppMethodBeat.o(62712);
            return null;
        }
        d brf = brg.brf(com.tencent.pb.a.a.a.hjq());
        if (brf == null) {
            b.w("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
            AppMethodBeat.o(62712);
            return null;
        }
        a.bb bbVar = brf.Sup;
        if (bbVar == null) {
            b.w("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
            AppMethodBeat.o(62712);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",");
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(j2);
        stringBuffer.append(",");
        stringBuffer.append(bbVar.RGh);
        b.w("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(62712);
        return stringBuffer2;
    }

    public static boolean brl(String str) {
        AppMethodBeat.i(62713);
        TalkRoom brg = hqY().brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "isMySelfExit talkRoom is null");
            AppMethodBeat.o(62713);
            return true;
        }
        d hqR = brg.hqR();
        if (hqR == null || 20 == hqR.getState()) {
            AppMethodBeat.o(62713);
            return true;
        }
        AppMethodBeat.o(62713);
        return false;
    }

    public static int brm(String str) {
        int i2;
        AppMethodBeat.i(62714);
        TalkRoom brg = hqY().brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            AppMethodBeat.o(62714);
            return 0;
        }
        d hqR = brg.hqR();
        if (hqR == null || hqR.Sup == null) {
            i2 = 0;
        } else {
            i2 = hqR.Sup.bDZ;
        }
        b.w("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i2));
        AppMethodBeat.o(62714);
        return i2;
    }

    public final MultiTalkGroup brn(String str) {
        AppMethodBeat.i(62715);
        TalkRoom brg = brg(str);
        if (brg == null) {
            AppMethodBeat.o(62715);
            return null;
        }
        MultiTalkGroup hqU = brg.hqU();
        AppMethodBeat.o(62715);
        return hqU;
    }

    public final String hJ(String str, int i2) {
        AppMethodBeat.i(199682);
        if (TextUtils.isEmpty(str)) {
            b.w("TalkRoomManager", "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i2));
            AppMethodBeat.o(199682);
            return "";
        }
        TalkRoom brg = brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getUsrNameByMemberId talkRoom is null groupId: ", str, " memberId: ", Integer.valueOf(i2));
            AppMethodBeat.o(199682);
            return "";
        }
        for (a.bb bbVar : brg.hqT()) {
            if (bbVar != null && bbVar.qrD == i2) {
                b.d("TalkRoomManager", "getUsrNameByMemberId wxUserName:", bbVar.dLN, " groupId: ", str, " memberId: ", Integer.valueOf(i2));
                if (bbVar.dLN == null) {
                    AppMethodBeat.o(199682);
                    return "";
                }
                String str2 = bbVar.dLN;
                AppMethodBeat.o(199682);
                return str2;
            }
        }
        AppMethodBeat.o(199682);
        return "";
    }
}
