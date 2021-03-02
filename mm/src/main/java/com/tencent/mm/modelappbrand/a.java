package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.appbrand.api.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean Ll(String str) {
        AppMethodBeat.i(2618);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(2618);
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject != null) {
                if (optJSONObject.optInt("openWxaByBizQRCode", 0) > 0) {
                    AppMethodBeat.o(2618);
                    return true;
                }
                AppMethodBeat.o(2618);
                return false;
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(2618);
        return false;
    }

    public static boolean b(k.b bVar) {
        return (bVar.type == 33 && (bVar.izk == 2 || bVar.izk == 3)) || bVar.type == 36;
    }

    public static boolean c(k.b bVar) {
        return bVar.type == 44;
    }

    private static void a(wq wqVar, k.b bVar) {
        wqVar.ecI.appId = bVar.izj;
        wqVar.ecI.userName = bVar.izi;
        wqVar.ecI.ecK = bVar.izh;
        wqVar.ecI.ecL = bVar.izz;
        wqVar.ecI.ecO = bVar.izl;
        wqVar.ecI.appVersion = bVar.izA;
        wqVar.ecI.ecP = bVar.izz != 0;
    }

    public static void a(String str, String str2, boolean z, k.b bVar, Bundle bundle) {
        AppMethodBeat.i(2619);
        wq wqVar = new wq();
        a(wqVar, bVar);
        b(wqVar, bVar);
        wqVar.ecI.scene = z ? 1008 : 1007;
        wqVar.ecI.dCw = str + (z ? ":".concat(String.valueOf(str2)) : "") + ":" + bVar.izn;
        wqVar.ecI.dFP = bundle;
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(2619);
    }

    public static void a(String str, int i2, k.b bVar, Bundle bundle) {
        AppMethodBeat.i(2620);
        wq wqVar = new wq();
        a(wqVar, bVar);
        b(wqVar, bVar);
        wqVar.ecI.scene = i2;
        if (i2 == 1074 || i2 == 1157) {
            wqVar.ecI.dCw = str;
        }
        wqVar.ecI.dFP = bundle;
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(2620);
    }

    public static void b(String str, String str2, boolean z, k.b bVar, Bundle bundle) {
        int i2 = 2;
        AppMethodBeat.i(2621);
        if (TextUtils.isEmpty(bVar.izo)) {
            Log.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", str, str2, Boolean.valueOf(z));
            a(str, str2, z, bVar, bundle);
            AppMethodBeat.o(2621);
            return;
        }
        wq wqVar = new wq();
        a(wqVar, bVar);
        b(wqVar, bVar);
        wqVar.ecI.scene = 1044;
        wqVar.ecI.dCw = bVar.izn;
        wq.a aVar = wqVar.ecI;
        if (!z) {
            i2 = 1;
        }
        aVar.ecU = i2;
        wq.a aVar2 = wqVar.ecI;
        if (z) {
            str2 = str;
        }
        aVar2.ecV = str2;
        wqVar.ecI.ecR.cyr = bVar.izo;
        wqVar.ecI.ecR.cyq = str;
        wqVar.ecI.dFP = bundle;
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(2621);
    }

    private static void b(wq wqVar, k.b bVar) {
        AppMethodBeat.i(2622);
        if (bVar != null) {
            com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
            if (aVar != null && !Util.isNullOrNil(aVar.ive)) {
                wqVar.ecI.eda = aVar.ive;
            }
            if (aVar != null) {
                j jVar = new j();
                jVar.ivg = aVar.ivg;
                wqVar.ecI.edb = jVar.bua();
            }
        }
        AppMethodBeat.o(2622);
    }
}
