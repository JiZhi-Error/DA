package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cj implements h {
    private Map<String, List<a>> iFV = new HashMap();
    private Map<String, List<a>> iFW = new HashMap();
    private Map<String, List<q>> iFX = new HashMap();
    private Map<String, p> iFY = new ConcurrentHashMap();

    public interface a {
        void a(h.a aVar);

        void a(h.c cVar);
    }

    public cj() {
        AppMethodBeat.i(42988);
        AppMethodBeat.o(42988);
    }

    @Deprecated
    public final void a(String str, a aVar, boolean z) {
        LinkedList linkedList;
        AppMethodBeat.i(42989);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(42989);
            return;
        }
        Map<String, List<a>> map = z ? this.iFW : this.iFV;
        synchronized (map) {
            try {
                List<a> list = map.get(str);
                if (list == null) {
                    LinkedList linkedList2 = new LinkedList();
                    map.put(str, linkedList2);
                    linkedList = linkedList2;
                } else {
                    linkedList = list;
                }
            } finally {
                AppMethodBeat.o(42989);
            }
        }
        synchronized (linkedList) {
            try {
                if (!linkedList.contains(aVar)) {
                    linkedList.add(aVar);
                }
            } finally {
                AppMethodBeat.o(42989);
            }
        }
    }

    @Deprecated
    public final void b(String str, a aVar, boolean z) {
        List<a> list;
        AppMethodBeat.i(42990);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(42990);
            return;
        }
        Map<String, List<a>> map = z ? this.iFW : this.iFV;
        synchronized (map) {
            try {
                list = map.get(str);
            } finally {
                AppMethodBeat.o(42990);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(aVar);
                } finally {
                    AppMethodBeat.o(42990);
                }
            }
            return;
        }
        AppMethodBeat.o(42990);
    }

    public final void a(String str, q qVar) {
        LinkedList linkedList;
        AppMethodBeat.i(42991);
        if (Util.isNullOrNil(str) || qVar == null) {
            AppMethodBeat.o(42991);
            return;
        }
        synchronized (this.iFX) {
            try {
                List<q> list = this.iFX.get(str);
                if (list == null) {
                    LinkedList linkedList2 = new LinkedList();
                    this.iFX.put(str, linkedList2);
                    linkedList = linkedList2;
                } else {
                    linkedList = list;
                }
            } finally {
                AppMethodBeat.o(42991);
            }
        }
        synchronized (linkedList) {
            try {
                if (!linkedList.contains(qVar)) {
                    linkedList.add(qVar);
                }
            } finally {
                AppMethodBeat.o(42991);
            }
        }
    }

    public final void b(String str, q qVar) {
        List<q> list;
        AppMethodBeat.i(42992);
        if (Util.isNullOrNil(str) || qVar == null) {
            AppMethodBeat.o(42992);
            return;
        }
        synchronized (this.iFX) {
            try {
                list = this.iFX.get(str);
            } finally {
                AppMethodBeat.o(42992);
            }
        }
        if (list != null) {
            synchronized (list) {
                try {
                    list.remove(qVar);
                } finally {
                    AppMethodBeat.o(42992);
                }
            }
            return;
        }
        AppMethodBeat.o(42992);
    }

    public final void a(String str, p pVar) {
        AppMethodBeat.i(42993);
        if (Util.isNullOrNil(str) || pVar == null) {
            AppMethodBeat.o(42993);
            return;
        }
        if (this.iFY.containsKey(str)) {
            Log.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, Util.getStack());
        }
        this.iFY.put(str, pVar);
        AppMethodBeat.o(42993);
    }

    public final void b(String str, p pVar) {
        AppMethodBeat.i(42994);
        if (Util.isNullOrNil(str) || pVar == null) {
            AppMethodBeat.o(42994);
            return;
        }
        synchronized (this.iFY) {
            try {
                this.iFY.remove(str);
            } finally {
                AppMethodBeat.o(42994);
            }
        }
    }

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        Map<String, String> map;
        String str;
        List<q> list;
        AppMethodBeat.i(42995);
        de deVar = aVar.heO;
        switch (deVar.xKb) {
            case 10001:
                a(z.a(deVar.KHl), aVar, false);
                e.INSTANCE.kvStat(10395, String.valueOf(deVar.Brn));
                AppMethodBeat.o(42995);
                return null;
            case 10002:
                String a2 = z.a(deVar.KHn);
                if (Util.isNullOrNil(a2)) {
                    Log.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    AppMethodBeat.o(42995);
                    return null;
                }
                if (a2.startsWith(SemiXml.MAGIC_HEAD)) {
                    Map<String, String> decode = SemiXml.decode(a2);
                    if (decode == null) {
                        Log.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        AppMethodBeat.o(42995);
                        return null;
                    }
                    map = decode;
                    str = "brand_service";
                } else {
                    int indexOf = a2.indexOf("<sysmsg");
                    if (indexOf != -1) {
                        String substring = a2.substring(indexOf);
                        Log.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a2, substring);
                        Map<String, String> parseXml = XmlParser.parseXml(substring, "sysmsg", null);
                        if (parseXml == null) {
                            Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                            AppMethodBeat.o(42995);
                            return null;
                        }
                        map = parseXml;
                        str = parseXml.get(".sysmsg.$type");
                    } else {
                        int indexOf2 = a2.indexOf("<appmsg");
                        if (indexOf2 != -1) {
                            Log.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
                            String substring2 = a2.substring(indexOf2);
                            Log.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a2, substring2);
                            Map<String, String> parseXml2 = XmlParser.parseXml(substring2, "appmsg", null);
                            if (parseXml2 == null) {
                                Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                                AppMethodBeat.o(42995);
                                return null;
                            }
                            map = parseXml2;
                            str = parseXml2.get(".appmsg.title");
                        } else {
                            Log.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
                            AppMethodBeat.o(42995);
                            return null;
                        }
                    }
                }
                Log.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a2, str);
                if (str != null) {
                    a(str, aVar, true);
                    synchronized (this.iFX) {
                        try {
                            list = this.iFX.get(str);
                        } finally {
                            AppMethodBeat.o(42995);
                        }
                    }
                    if (list == null || list.isEmpty()) {
                        Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            try {
                                for (q qVar : list) {
                                    qVar.onNewXmlReceived(str, map, aVar);
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(42995);
                                throw th;
                            }
                        }
                    }
                    p pVar = this.iFY.get(str);
                    if (pVar != null) {
                        h.b a3 = pVar.a(str, map, aVar);
                        AppMethodBeat.o(42995);
                        return a3;
                    }
                    Log.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                return null;
            default:
                Log.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(deVar.xKb));
                AppMethodBeat.o(42995);
                return null;
        }
    }

    @Deprecated
    private void a(String str, h.a aVar, boolean z) {
        List<a> list;
        AppMethodBeat.i(42996);
        Map<String, List<a>> map = z ? this.iFW : this.iFV;
        synchronized (map) {
            try {
                list = map.get(str);
            } finally {
                AppMethodBeat.o(42996);
            }
        }
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            AppMethodBeat.o(42996);
            return;
        }
        Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a aVar2 : list) {
            aVar2.a(aVar);
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        List<a> list;
        AppMethodBeat.i(42997);
        if (cVar == null || cVar.iMe == null) {
            AppMethodBeat.o(42997);
            return;
        }
        Log.i("MicroMsg.SysCmdMsgExtension", "delete subType:%s, msgId:%s", cVar.iMe, cVar.iMf);
        String str = cVar.iMe;
        Map<String, List<a>> map = this.iFW;
        synchronized (map) {
            try {
                list = map.get(str);
            } finally {
                AppMethodBeat.o(42997);
            }
        }
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            AppMethodBeat.o(42997);
            return;
        }
        Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a aVar : list) {
            aVar.a(cVar);
        }
    }
}
