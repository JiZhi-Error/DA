package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a {
    public static final a JFQ = new a();
    public c IIu;
    public com.tencent.mm.plugin.welab.d.a JFR;
    public Map<String, b> JFS = new HashMap();
    public b JFT;

    public a() {
        AppMethodBeat.i(146200);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        AppMethodBeat.o(146200);
    }

    static {
        AppMethodBeat.i(146208);
        AppMethodBeat.o(146208);
    }

    public static a gjg() {
        return JFQ;
    }

    public static String a(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(146201);
        String str = "";
        b bby = JFQ.bby(aVar.field_LabsAppId);
        if (bby != null) {
            str = bby.gjm();
            Log.i("WelabMgr", "get appName from opener , appid %s, appName %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = aVar.bbH("field_Title");
        }
        AppMethodBeat.o(146201);
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(146202);
        String str = "";
        b bby = JFQ.bby(aVar.field_LabsAppId);
        if (bby != null) {
            str = bby.gjl();
            Log.i("WelabMgr", "get icon url from opener , appid %s, url %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = aVar.field_Icon;
        }
        AppMethodBeat.o(146202);
        return str;
    }

    private b bby(String str) {
        AppMethodBeat.i(146203);
        b bVar = this.JFS.get(str);
        AppMethodBeat.o(146203);
        return bVar;
    }

    public final List<com.tencent.mm.plugin.welab.d.a.a> gjh() {
        AppMethodBeat.i(146205);
        List<com.tencent.mm.plugin.welab.d.a.a> gjn = this.JFR.gjn();
        Iterator<com.tencent.mm.plugin.welab.d.a.a> it = gjn.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.d.a.a next = it.next();
            if (!next.isRunning() || (!(next.field_Switch == 2 || next.field_Switch == 1) || "labs1de6f3".equals(next.field_LabsAppId))) {
                it.remove();
            }
        }
        Log.i("WelabMgr", "online lab %s", gjn.toString());
        AppMethodBeat.o(146205);
        return gjn;
    }

    public final com.tencent.mm.plugin.welab.d.a.a bbz(String str) {
        AppMethodBeat.i(146206);
        com.tencent.mm.plugin.welab.d.a aVar = this.JFR;
        com.tencent.mm.plugin.welab.d.a.a aVar2 = new com.tencent.mm.plugin.welab.d.a.a();
        aVar2.field_LabsAppId = str;
        aVar.get(aVar2, new String[0]);
        AppMethodBeat.o(146206);
        return aVar2;
    }

    public static void io(List<com.tencent.mm.plugin.welab.d.a.a> list) {
        AppMethodBeat.i(146207);
        if (!list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList();
            for (com.tencent.mm.plugin.welab.d.a.a aVar : list) {
                if (!aVar.gjq() && !aVar.isExpired()) {
                    arrayList.add(aVar.field_LabsAppId);
                }
            }
            qt qtVar = new qt();
            qtVar.dXj.dXk = arrayList;
            EventCenter.instance.publish(qtVar);
            for (String str : arrayList) {
                if ("labs_nearbylife".equals(str)) {
                    EventCenter.instance.publish(new my());
                    AppMethodBeat.o(146207);
                    return;
                }
            }
        }
        AppMethodBeat.o(146207);
    }
}
