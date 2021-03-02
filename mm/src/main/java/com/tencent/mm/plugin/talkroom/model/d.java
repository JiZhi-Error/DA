package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        boolean z;
        String str;
        String str2;
        int i2 = 1;
        AppMethodBeat.i(29456);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(29456);
        } else if (deVar.xKb != 56) {
            Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(deVar.xKb));
            AppMethodBeat.o(29456);
        } else {
            String a2 = z.a(deVar.KHl);
            String a3 = z.a(deVar.KHm);
            bg.aVF();
            if (!((String) c.azQ().get(2, (Object) null)).equals(a2)) {
                a3 = a2;
            }
            bg.aVF();
            as Kn = c.aSN().Kn(a3);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                bg.aVF();
                c.aSN().ap(new as(a3));
            }
            String a4 = z.a(deVar.KHn);
            Log.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(a4)));
            Map<String, String> parseXml = XmlParser.parseXml(a4, "talkroominfo", null);
            if (parseXml != null) {
                try {
                    if (aSU(parseXml.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        aSU(parseXml.get(".talkroominfo.sysmsgtype"));
                        z = true;
                    } else {
                        z = false;
                    }
                    LinkedList<egs> linkedList = new LinkedList<>();
                    aSU(parseXml.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        String str3 = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str4 = parseXml.get(str3 + ".username");
                        if (Util.isNullOrNil(str4)) {
                            break;
                        }
                        int aSU = aSU(parseXml.get(str3 + ".memberid"));
                        egs egs = new egs();
                        egs.UserName = str4;
                        egs.NgD = aSU;
                        linkedList.add(egs);
                        i3++;
                    }
                    if (a3.equals(b.ftN().FQv)) {
                        str2 = fk(linkedList);
                        str = Util.isNullOrNil(str2) ? fl(linkedList) : null;
                    } else {
                        str = null;
                        str2 = null;
                    }
                    e ftO = b.ftO();
                    if (z) {
                        i2 = 0;
                    }
                    ftO.a(a3, linkedList, str2, str, i2);
                    AppMethodBeat.o(29456);
                } catch (Exception e2) {
                    Log.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    Log.printErrStackTrace("MicroMsg.TalkRoomExtension", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(29456);
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }

    private static int aSU(String str) {
        int i2 = 0;
        AppMethodBeat.i(29457);
        if (!Util.isNullOrNil(str)) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomExtension", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(29457);
        return i2;
    }

    private static String fk(List<egs> list) {
        boolean z;
        AppMethodBeat.i(29458);
        List ecY = b.ftN().ecY();
        LinkedList linkedList = new LinkedList();
        for (egs egs : list) {
            Iterator it = ecY.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((egs) it.next()).UserName.equals(egs.UserName)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                linkedList.add(egs.UserName);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(29458);
            return null;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str = (String) linkedList.get(i2);
            if (!str.equals(com.tencent.mm.model.z.aTY())) {
                AppMethodBeat.o(29458);
                return str;
            }
        }
        AppMethodBeat.o(29458);
        return null;
    }

    private static String fl(List<egs> list) {
        boolean z;
        AppMethodBeat.i(29459);
        List<egs> ecY = b.ftN().ecY();
        LinkedList linkedList = new LinkedList();
        for (egs egs : ecY) {
            Iterator<egs> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().UserName.equals(egs.UserName)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                linkedList.add(egs.UserName);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(29459);
            return null;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str = (String) linkedList.get(i2);
            if (!str.equals(com.tencent.mm.model.z.aTY())) {
                AppMethodBeat.o(29459);
                return str;
            }
        }
        AppMethodBeat.o(29459);
        return null;
    }
}
