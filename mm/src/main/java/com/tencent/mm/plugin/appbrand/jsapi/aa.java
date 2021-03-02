package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public class aa extends s {
    private static final int CTRL_INDEX = 494;
    private static final String NAME = "onViewDidResize";

    public final void a(ac acVar, int i2, int i3, int i4, int i5, int i6, e.b bVar, Map<String, Object> map) {
        AppMethodBeat.i(182988);
        HashMap hashMap = new HashMap(10);
        hashMap.put("windowWidth", Integer.valueOf(g.zB(i3)));
        hashMap.put("windowHeight", Integer.valueOf(g.zB(i4)));
        hashMap.put("screenWidth", Integer.valueOf(g.zB(i5)));
        hashMap.put("screenHeight", Integer.valueOf(g.zB(i6)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("size", hashMap);
        hashMap2.put("changedWebviewIds", new int[]{i2});
        if (a.contains(e.b.nEs, bVar)) {
            hashMap2.put("deviceOrientation", "landscape");
        } else if (e.b.PORTRAIT == bVar) {
            hashMap2.put("deviceOrientation", "portrait");
        }
        if (map != null) {
            hashMap2.put("pageOrientation", new HashMap(map));
        }
        String obj = h.v(hashMap2).toString();
        Log.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", getName(), acVar.getAppId(), acVar.lBI, obj);
        Zg(obj).b(acVar, acVar.getComponentId()).bEo();
        Zg(obj).b(acVar.NY(), acVar.getComponentId()).bEo();
        AppMethodBeat.o(182988);
    }
}
