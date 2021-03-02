package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a {
    public static ArrayList<d> a(String str, String str2, String str3, String str4, Map<String, String> map, List<c> list) {
        AppMethodBeat.i(23497);
        Log.d("MicroMsg.ExdeviceMsgXmlParser", str3);
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.o(23497);
            return null;
        }
        k.b aD = k.b.aD(str3, str4);
        if (aD != null) {
            Map<String, String> map2 = aD.iwG;
            ArrayList<d> arrayList = new ArrayList<>();
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(map2 == null);
            Log.d("MicroMsg.ExdeviceMsgXmlParser", "map is null :%s", objArr);
            if (map2 != null && !map2.isEmpty()) {
                Log.d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", map2.toString());
                int i2 = 0;
                while (true) {
                    String str5 = map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                    if (Util.isNullOrNil(str5)) {
                        break;
                    }
                    String str6 = map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname");
                    StringBuilder sb = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
                    String valueOf = i2 == 0 ? "" : Integer.valueOf(i2);
                    c cVar = new c();
                    cVar.field_appusername = str2;
                    cVar.field_username = str5;
                    cVar.field_rankID = str;
                    cVar.field_step = Util.getInt(map2.get(sb.append(valueOf).append(".step").toString()), 0);
                    list.add(cVar);
                    map.put(str5, str6);
                    i2++;
                }
                Log.i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", Integer.valueOf(i2));
                int i3 = 0;
                while (true) {
                    String str7 = map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".username");
                    String str8 = map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".nickname");
                    if (Util.isNullOrNil(str7)) {
                        Log.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i3));
                        AppMethodBeat.o(23497);
                        return arrayList;
                    }
                    String str9 = map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".rank.rankdisplay");
                    int i4 = Util.getInt(map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".score.scoredisplay"), 0);
                    d dVar = new d();
                    dVar.field_appusername = str2;
                    dVar.field_rankID = str;
                    dVar.field_username = str7;
                    dVar.field_ranknum = Util.getInt(str9, 0);
                    dVar.field_score = i4;
                    dVar.field_selfLikeState = 2;
                    dVar.field_likecount = 0;
                    arrayList.add(dVar);
                    map.put(str7, str8);
                    i3++;
                }
            }
        }
        AppMethodBeat.o(23497);
        return null;
    }

    public static void b(String str, String str2, Map<String, String> map) {
        Map<String, String> map2;
        int i2 = 0;
        AppMethodBeat.i(23498);
        Log.d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            AppMethodBeat.o(23498);
            return;
        }
        k.b aD = k.b.aD(str, str2);
        if (aD != null && (map2 = aD.iwG) != null && !map2.isEmpty()) {
            int i3 = 0;
            while (true) {
                String str3 = map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".username");
                if (Util.isNullOrNil(str3)) {
                    break;
                }
                map.put(str3, map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".nickname"));
                i3++;
            }
            while (true) {
                String str4 = map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                String str5 = map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname");
                if (Util.isNullOrNil(str4)) {
                    break;
                }
                map.put(str4, str5);
                i2++;
            }
        }
        AppMethodBeat.o(23498);
    }
}
