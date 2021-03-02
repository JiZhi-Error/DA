package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    a.az Suh;
    Map<String, d> Sui = new ConcurrentHashMap();

    public static TalkRoom a(String str, String str2, Integer num, int i2, long j2, a.az azVar, a.bb[] bbVarArr, a.bc[] bcVarArr) {
        AppMethodBeat.i(199664);
        b.d("tagorewang:TalkRoom:create", "create groupId: ", str, " tmpId: ", str2);
        TalkRoom talkRoom = new TalkRoom(str, num, azVar);
        talkRoom.bre(str2);
        setRoomId(i2);
        OM(j2);
        int length = bbVarArr == null ? 0 : bbVarArr.length;
        int length2 = bcVarArr == null ? 0 : bcVarArr.length;
        for (int i3 = 0; i3 != length; i3++) {
            a.bb bbVar = bbVarArr[i3];
            if (bbVar == null) {
                b.w("tagorewang:TalkRoom:create", "null member info, index: ", Integer.valueOf(i3));
            } else {
                a.bc bcVar = null;
                int i4 = 0;
                while (true) {
                    if (i4 == length2) {
                        break;
                    }
                    bcVar = bcVarArr[i4];
                    if (bcVar != null && bcVar.KBb == bbVar.KBb) {
                        b.d("tagorewang:TalkRoom:create", "member info: ", bbVar, " profile: ", bcVar);
                        break;
                    }
                    bcVar = null;
                    i4++;
                }
                talkRoom.a(new d(bbVar, bcVar));
            }
        }
        b.d("tagorewang:TalkRoom:create", "did create");
        AppMethodBeat.o(199664);
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i2, long j2, a.az azVar, a.bb[] bbVarArr, a.bc[] bcVarArr) {
        int length;
        AppMethodBeat.i(199665);
        if (talkRoom == null) {
            b.w("tagorewang:TalkRoom:update", "updateAll null");
            AppMethodBeat.o(199665);
            return null;
        }
        b.d("tagorewang:TalkRoom:update", "updateAll groupId: ", str, " tmpId: ", str2);
        talkRoom.c(str, num);
        talkRoom.bre(str2);
        setRoomId(i2);
        OM(j2);
        talkRoom.b(azVar);
        int length2 = bbVarArr == null ? 0 : bbVarArr.length;
        if (bcVarArr == null) {
            length = 0;
        } else {
            length = bcVarArr.length;
        }
        if (length2 == 0 && length == 0) {
            b.w("tagorewang:TalkRoom:update", "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array.");
            AppMethodBeat.o(199665);
            return talkRoom;
        }
        HashSet<String> hashSet = new HashSet(talkRoom.Sui.keySet());
        hashSet.remove(com.tencent.pb.a.a.a.hjq());
        for (int i3 = 0; i3 != length2; i3++) {
            a.bb bbVar = bbVarArr[i3];
            if (bbVar == null) {
                b.w("tagorewang:TalkRoom:update", "null member info, index: ", Integer.valueOf(i3));
            } else {
                d brf = talkRoom.brf(bbVar.dLN);
                if (brf == null) {
                    b.d("tagorewang:TalkRoom:update", "add new member");
                    brf = new d(bbVar);
                    talkRoom.a(brf);
                } else {
                    brf.a(bbVar);
                }
                hashSet.remove(brf.hra());
            }
        }
        for (String str3 : hashSet) {
            b.d("tagorewang:TalkRoom:update", "keyset", str3);
            b.d("tagorewang:TalkRoom", "remove", talkRoom.Sui.remove(str3));
        }
        if (hashSet.size() > 0) {
            b.w("tagorewang:TalkRoom:update", "updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size()));
        }
        b.d("tagorewang:TalkRoom:update", "did updateAll");
        AppMethodBeat.o(199665);
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, a.az azVar) {
        AppMethodBeat.i(199666);
        c(str, num);
        b(azVar);
        AppMethodBeat.o(199666);
    }

    public static boolean hqL() {
        return false;
    }

    private void bre(String str) {
        AppMethodBeat.i(62565);
        if (j.bru(str)) {
            this.RGY = str;
        }
        AppMethodBeat.o(62565);
    }

    public final int hqM() {
        if (this.RCJ == 0) {
            return 0;
        }
        return this.RCJ;
    }

    private void c(String str, Integer num) {
        AppMethodBeat.i(62566);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62566);
            return;
        }
        if (j.bru(str)) {
            this.RGY = str;
        } else {
            this.zHD = str;
        }
        if (num != null) {
            this.RCJ = num.intValue();
        }
        AppMethodBeat.o(62566);
    }

    public static int hqN() {
        AppMethodBeat.i(62567);
        int hrA = j.hrA();
        AppMethodBeat.o(62567);
        return hrA;
    }

    private static void setRoomId(int i2) {
        AppMethodBeat.i(62568);
        b.d("tagorewang:TalkRoom", "setRoomId: ", Integer.valueOf(i2));
        AppMethodBeat.o(62568);
    }

    public static long fHV() {
        AppMethodBeat.i(62569);
        long hrB = j.hrB();
        AppMethodBeat.o(62569);
        return hrB;
    }

    private static void OM(long j2) {
        AppMethodBeat.i(62570);
        b.d("tagorewang:TalkRoom", "setRoomKey: ", Long.valueOf(j2));
        AppMethodBeat.o(62570);
    }

    private static a.v a(a.az azVar) {
        AppMethodBeat.i(199667);
        if (azVar != null) {
            try {
                if (azVar.RFJ != null) {
                    byte[] bArr = azVar.RFJ;
                    a.v vVar = (a.v) e.a(new a.v(), bArr, bArr.length);
                    AppMethodBeat.o(199667);
                    return vVar;
                }
            } catch (Exception e2) {
                b.w("tagorewang:TalkRoom", "toPlayItemInfo err: ", e2);
                AppMethodBeat.o(199667);
                return null;
            }
        }
        AppMethodBeat.o(199667);
        return null;
    }

    private String hqO() {
        AppMethodBeat.i(62572);
        if (this.Suh == null || TextUtils.isEmpty(this.Suh.name)) {
            ArrayList arrayList = new ArrayList(this.Sui.values());
            arrayList.remove(this.Sui.get(com.tencent.pb.a.a.a.hjq()));
            List<d> kh = kh(arrayList);
            b.i("tagorewang:TalkRoom", "getOtherMembers size: ", Integer.valueOf(kh.size()), " all size: ", Integer.valueOf(this.Sui.size()));
            StringBuilder sb = new StringBuilder();
            if (kh != null) {
                int size = kh.size();
                for (int i2 = 0; i2 != size; i2++) {
                    try {
                        sb.append(kh.get(i2).getDisplayName());
                        if (i2 != size - 1) {
                            sb.append((char) 12289);
                        }
                    } catch (Exception e2) {
                        b.w("tagorewang:TalkRoom", "updateRoomNameIfEmpty err and continue: ", e2);
                    }
                }
            }
            if (sb.toString().length() > 0) {
                String sb2 = sb.toString();
                AppMethodBeat.o(62572);
                return sb2;
            }
        }
        if (this.Suh == null || TextUtils.isEmpty(this.Suh.name)) {
            b.w("tagorewang:TalkRoom", "updateRoomNameIfEmpty still empty, groupId: ", this.zHD, " tmpId: ", this.RGY);
            AppMethodBeat.o(62572);
            return null;
        }
        String str = this.Suh.name;
        AppMethodBeat.o(62572);
        return str;
    }

    private void b(a.az azVar) {
        AppMethodBeat.i(199668);
        if (azVar == null) {
            AppMethodBeat.o(199668);
            return;
        }
        try {
            this.zHE = azVar.RFQ;
            this.RGZ = azVar.RFP;
            if (!(this.Suh == null || azVar.dLt == 0)) {
                a.v a2 = a(azVar);
                a.v a3 = a(this.Suh);
                if (a2 == null) {
                    azVar.RFJ = this.Suh.RFJ;
                } else if (a2.REo == 0 || a2.REo != a3.REo) {
                    b.w("tagorewang:TalkRoom", "setRoomInfo bad id: ", Integer.valueOf(a3.REo), " -> ", Integer.valueOf(a2.REo));
                    azVar.RFJ = this.Suh.RFJ;
                }
            }
            this.Suh = azVar;
            AppMethodBeat.o(199668);
        } catch (Exception e2) {
            b.w("tagorewang:TalkRoom", "setRoomInfo assert failed: ", e2);
            this.Suh = azVar;
            AppMethodBeat.o(199668);
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(62574);
        this.Sui.put(dVar.hra(), dVar);
        AppMethodBeat.o(62574);
    }

    public final List<d> hqQ() {
        AppMethodBeat.i(62576);
        ArrayList arrayList = new ArrayList(this.Sui.values());
        AppMethodBeat.o(62576);
        return arrayList;
    }

    private static List<d> kh(List<d> list) {
        AppMethodBeat.i(62577);
        if (list.isEmpty()) {
            AppMethodBeat.o(62577);
        } else {
            Collections.sort(list, new a());
            AppMethodBeat.o(62577);
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Comparator<d> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(d dVar, d dVar2) {
            return 0;
        }
    }

    public final d brf(String str) {
        AppMethodBeat.i(62578);
        d dVar = this.Sui.get(str);
        AppMethodBeat.o(62578);
        return dVar;
    }

    public final d hqR() {
        AppMethodBeat.i(62579);
        d dVar = this.Sui.get(com.tencent.pb.a.a.a.hjq());
        AppMethodBeat.o(62579);
        return dVar;
    }

    public final List<a.bb> hqS() {
        AppMethodBeat.i(62580);
        List<a.bb> hqT = hqT();
        AppMethodBeat.o(62580);
        return hqT;
    }

    public final List<a.bb> hqT() {
        AppMethodBeat.i(62581);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, d> entry : this.Sui.entrySet()) {
            arrayList.add(entry.getValue().Sup);
        }
        AppMethodBeat.o(62581);
        return arrayList;
    }

    @Override // com.tencent.pb.talkroom.sdk.MultiTalkGroup
    public String toString() {
        String str;
        AppMethodBeat.i(62582);
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("groupId: ").append(this.zHD);
            sb.append(" tmpId: ").append(this.RGY);
            sb.append(" routeId: ").append(this.RCJ);
            StringBuilder append = sb.append(" room name: ");
            if (this.Suh == null || TextUtils.isEmpty(this.Suh.name)) {
                str = hqO();
            } else {
                str = this.Suh.name;
            }
            append.append(str);
        } catch (Exception e2) {
            sb.append(" broken by " + e2.getMessage());
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(62582);
        return sb2;
    }

    public final MultiTalkGroup hqU() {
        String str;
        AppMethodBeat.i(62583);
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.zHD = this.zHD;
        multiTalkGroup.RGY = this.RGY;
        multiTalkGroup.RCJ = this.RCJ;
        multiTalkGroup.zHE = this.zHE;
        multiTalkGroup.RGZ = this.RGZ;
        ArrayList arrayList = new ArrayList();
        List<d> hqQ = hqQ();
        if (hqQ.size() > 0) {
            for (d dVar : hqQ) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.RHb = dVar.hra();
                    if (dVar.Sup != null) {
                        str = dVar.Sup.RGr;
                    } else {
                        str = "";
                    }
                    multiTalkGroupMember.RHc = str;
                    multiTalkGroupMember.bDZ = dVar.Sup != null ? dVar.Sup.bDZ : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    multiTalkGroupMember.RGf = (dVar.Sup == null || dVar.Sup.RGf == 0) ? 0 : dVar.Sup.RGf;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.RHa = arrayList;
        AppMethodBeat.o(62583);
        return multiTalkGroup;
    }

    public final List<d> hqP() {
        AppMethodBeat.i(62575);
        List<d> kh = kh(new ArrayList(this.Sui.values()));
        d hqR = hqR();
        kh.remove(hqR);
        kh.add(0, hqR);
        d dVar = this.Sui.get(90100);
        if (dVar != null) {
            kh.remove(dVar);
            kh.add(dVar);
        }
        AppMethodBeat.o(62575);
        return kh;
    }
}
