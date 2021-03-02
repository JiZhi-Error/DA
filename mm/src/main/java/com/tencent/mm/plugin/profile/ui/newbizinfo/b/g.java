package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    public static void a(qa qaVar, Context context, String str) {
        AppMethodBeat.i(27582);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", qaVar.value);
        intent.putExtra("geta8key_username", str);
        intent.putExtra("geta8key_scene", 59);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(27582);
    }

    public static void b(qa qaVar, Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(27583);
        if (Util.isNullOrNil(qaVar.value)) {
            Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", Integer.valueOf(qaVar.id));
            AppMethodBeat.o(27583);
            return;
        }
        Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", qaVar.value);
        try {
            JSONObject jSONObject = new JSONObject(qaVar.value);
            com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1102;
            appBrandStatObject.dCw = str;
            r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
            String optString = jSONObject.optString("userName");
            String optString2 = jSONObject.optString("pagePath");
            if (fJ != null) {
                str2 = fJ.field_appId;
            }
            rVar.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str2);
            AppMethodBeat.o(27583);
        } catch (JSONException e2) {
            AppMethodBeat.o(27583);
        }
    }

    public static void c(qa qaVar, Context context, String str) {
        AppMethodBeat.i(231963);
        if (Util.isNullOrNil(qaVar.value)) {
            Log.d("MicroMsg.NewBizInfoUtil", "jumpToSearch serviceInfo.id: %s value is null", Integer.valueOf(qaVar.id));
            AppMethodBeat.o(231963);
            return;
        }
        String str2 = qaVar.value;
        Log.i("MicroMsg.NewBizInfoUtil", "jumpToSearch username: %s, suggestData: %s", str, str2);
        Intent fXX = ai.fXX();
        fXX.putExtra("ftsneedkeyboard", true);
        fXX.putExtra("ftsbizscene", 76);
        fXX.putExtra("ftsType", 2);
        Map<String, String> h2 = ai.h(76, false, 2);
        h2.put("userName", str);
        if (!Util.isNullOrNil(str2)) {
            h2.put("thirdExtParam", str2);
        }
        fXX.putExtra("rawUrl", ai.bd(h2));
        fXX.putExtra("key_load_js_without_delay", true);
        fXX.putExtra("ftsbizusername", str);
        fXX.addFlags(67108864);
        c.b(context, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
        AppMethodBeat.o(231963);
    }

    public static int Vb(int i2) {
        switch (i2) {
            case 17:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                return 2;
            case 30:
            case 45:
                return 4;
            case 39:
            case 87:
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                return 3;
            case 42:
            case 43:
            case n.CTRL_INDEX:
                return 1;
            default:
                return 0;
        }
    }

    public static int bQ(int i2, String str) {
        AppMethodBeat.i(27584);
        if (str == null || !ab.IT(str)) {
            switch (i2) {
                case 1:
                case 2:
                    AppMethodBeat.o(27584);
                    return i2;
                case 3:
                case 4:
                case 5:
                case 8:
                case 10:
                default:
                    AppMethodBeat.o(27584);
                    return 0;
                case 6:
                case 7:
                case 9:
                case 11:
                case 12:
                case 13:
                    AppMethodBeat.o(27584);
                    return 3;
            }
        } else {
            AppMethodBeat.o(27584);
            return 3;
        }
    }
}
