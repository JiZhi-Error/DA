package com.tencent.mm.plugin.appbrand.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.Map;

public enum a {
    INSTANCE;

    public static a valueOf(String str) {
        AppMethodBeat.i(174715);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(174715);
        return aVar;
    }

    static {
        AppMethodBeat.i(174716);
        AppMethodBeat.o(174716);
    }

    public static Intent M(Context context, int i2) {
        String str;
        AppMethodBeat.i(21061);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        intent.putExtra("neverGetA8Key", true);
        intent.setClass(context, AppBrandSearchUI.class);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("title", context.getString(R.string.lc));
        intent.putExtra("searchbar_tips", context.getString(R.string.lc));
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i2);
        Map<String, String> br = com.tencent.mm.plugin.websearch.c.a.br(i2, true);
        String aXE = b.aXE();
        br.put("WASessionId", aXE);
        br.put("sessionId", aXE);
        br.put("subSessionId", aXE);
        intent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.bd(br));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", aXE);
        intent.putExtra("sessionId", aXE);
        intent.putExtra("subSessionId", aXE);
        ao azQ = g.aAh().azQ();
        if (i2 == 52) {
            Object obj = azQ.get(ar.a.USERINFO_WXA_SEARCH_FROM_DESKTOP_MORE_INPUT_HINT_CONTENT_STRING_SYNC, (Object) null);
            if (obj instanceof String) {
                str = (String) obj;
            }
            str = "";
        } else {
            Object obj2 = azQ.get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, (Object) null);
            if (obj2 != null && (obj2 instanceof String)) {
                str = (String) obj2;
            }
            str = "";
        }
        intent.putExtra("key_search_input_hint", str);
        intent.putExtra("key_alpha_in", !(context instanceof Activity));
        intent.putExtra("key_preload_biz", 5);
        AppMethodBeat.o(21061);
        return intent;
    }
}
