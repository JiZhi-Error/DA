package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class c {
    public static HashMap<String, Object> F(g gVar) {
        AppMethodBeat.i(235280);
        amj amj = gVar.field_favProto.Lxf;
        aml c2 = b.c(gVar);
        String format = String.format("file://%s", b.a(c2));
        if (!s.YS(format)) {
            format = String.format("file://%s", b.d(c2));
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("desc", gVar.field_favProto.title);
        hashMap.put("type", 2);
        hashMap.put("title", gVar.field_favProto.title);
        hashMap.put("app_id", amj.appId);
        hashMap.put("pkg_type", Integer.valueOf(amj.dMe));
        hashMap.put("pkg_version", Integer.valueOf(amj.version));
        hashMap.put("img_url", format);
        hashMap.put("is_dynamic", Boolean.FALSE);
        hashMap.put("cache_key", "");
        hashMap.put("path", amj.dCx);
        hashMap.put("subType", Integer.valueOf(amj.subType));
        Log.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", format);
        AppMethodBeat.o(235280);
        return hashMap;
    }

    public static boolean a(amj amj) {
        if (amj == null) {
            return false;
        }
        return amj.type == 3 || amj.lyE == 1;
    }
}
