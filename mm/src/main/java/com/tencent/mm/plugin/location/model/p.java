package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p extends e {
    @Override // com.tencent.mm.model.e, com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(55754);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(55754);
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        String a2 = z.a(deVar.KHl);
        String a3 = z.a(deVar.KHm);
        String str = ((String) g.aAh().azQ().get(2, null)).equals(a2) ? a3 : a2;
        String a4 = z.a(deVar.KHn);
        Log.d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(a4)));
        Map<String, String> parseXml = XmlParser.parseXml(a4, "sysmsg", null);
        if (parseXml != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("talk  " + str + APLogFileUtil.SEPARATOR_LINE);
                stringBuffer.append("from fromUser " + a2 + APLogFileUtil.SEPARATOR_LINE);
                stringBuffer.append("from toUser " + a3 + APLogFileUtil.SEPARATOR_LINE);
                String str2 = parseXml.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                double aCY = aCY(parseXml.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                stringBuffer.append("lat " + aCY + APLogFileUtil.SEPARATOR_LINE);
                double aCY2 = aCY(parseXml.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                stringBuffer.append("lng " + aCY2 + APLogFileUtil.SEPARATOR_LINE);
                stringBuffer.append("times " + Util.getInt(parseXml.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + APLogFileUtil.SEPARATOR_LINE);
                int i2 = 0;
                while (true) {
                    String str3 = parseXml.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i2 == 0 ? "" : Integer.valueOf(i2))) + ".username");
                    if (Util.isNullOrNil(str3)) {
                        break;
                    }
                    i2++;
                    linkedList.add(str3);
                }
                stringBuffer.append("userNameList size " + linkedList.size() + APLogFileUtil.SEPARATOR_LINE);
                Log.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                String str4 = null;
                String str5 = null;
                if (str.equals(n.ecR().rgD)) {
                    str4 = fk(linkedList);
                    if (Util.isNullOrNil(str4)) {
                        str5 = fl(linkedList);
                    }
                }
                n.ecS().a(str, linkedList, aCY, aCY2, str2, str4, str5);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TrackMsgExtension", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(55754);
        return null;
    }

    private static double aCY(String str) {
        AppMethodBeat.i(55755);
        if (str == null) {
            AppMethodBeat.o(55755);
            return 0.0d;
        }
        double d2 = Util.getDouble(str, 0.0d);
        AppMethodBeat.o(55755);
        return d2;
    }

    private static String fk(List<String> list) {
        boolean z;
        AppMethodBeat.i(55756);
        List<String> ecY = n.ecR().ecY();
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            Iterator<String> it = ecY.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                linkedList.add(str);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(55756);
            return null;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str2 = (String) linkedList.get(i2);
            if (!str2.equals(com.tencent.mm.model.z.aTY())) {
                AppMethodBeat.o(55756);
                return str2;
            }
        }
        AppMethodBeat.o(55756);
        return null;
    }

    private static String fl(List<String> list) {
        boolean z;
        AppMethodBeat.i(55757);
        List<String> ecY = n.ecR().ecY();
        LinkedList linkedList = new LinkedList();
        for (String str : ecY) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                linkedList.add(str);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(55757);
            return null;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str2 = (String) linkedList.get(i2);
            if (!str2.equals(com.tencent.mm.model.z.aTY())) {
                AppMethodBeat.o(55757);
                return str2;
            }
        }
        AppMethodBeat.o(55757);
        return null;
    }
}
