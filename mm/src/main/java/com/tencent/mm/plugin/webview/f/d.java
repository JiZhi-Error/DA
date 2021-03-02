package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class d {
    Map<String, a> Jce = new HashMap();
    private JsapiPermissionWrapper Jcf = null;
    private GeneralControlWrapper Jcg;
    final JsapiPermissionWrapper Jch = new JsapiPermissionWrapper(2);
    final GeneralControlWrapper Jci = GeneralControlWrapper.Kzh;

    public d() {
        AppMethodBeat.i(224483);
        if (ac.jOx == null || ac.jOx.length() == 0) {
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                int i2 = Util.getInt(ac.jOx, 0);
                if (i2 < 0) {
                    Log.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.Jcf = new JsapiPermissionWrapper(i2);
                    Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Jcf);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e2.getMessage());
                this.Jcf = null;
            }
        }
        this.Jcg = null;
        if (ac.jOy == null || ac.jOy.length() == 0) {
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                int i3 = Util.getInt(ac.jOy, 0);
                Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(i3));
                bgt bgt = new bgt();
                bgt.LQC = i3;
                this.Jcg = new GeneralControlWrapper(bgt);
            } catch (Exception e3) {
                Log.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", e3.getMessage());
                this.Jcg = null;
            }
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Jcg);
        }
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + ((Object) null) + ", hardcodeGenCtrl = " + ((Object) null));
        AppMethodBeat.o(224483);
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(224484);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
            AppMethodBeat.o(224484);
            return;
        }
        String aYy = aYy(str);
        Log.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + aYy);
        this.Jce.put(aYy, new a(jsapiPermissionWrapper, generalControlWrapper));
        AppMethodBeat.o(224484);
    }

    public final JsapiPermissionWrapper aZE(String str) {
        AppMethodBeat.i(224485);
        if (this.Jcf != null) {
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.Jcf);
            JsapiPermissionWrapper jsapiPermissionWrapper = this.Jcf;
            AppMethodBeat.o(224485);
            return jsapiPermissionWrapper;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(str)));
            JsapiPermissionWrapper jsapiPermissionWrapper2 = this.Jch;
            AppMethodBeat.o(224485);
            return jsapiPermissionWrapper2;
        } else {
            String aYy = aYy(str);
            if (this.Jce == null) {
                Log.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
                JsapiPermissionWrapper jsapiPermissionWrapper3 = this.Jch;
                AppMethodBeat.o(224485);
                return jsapiPermissionWrapper3;
            }
            a aVar = this.Jce.get(aYy);
            if (aVar == null) {
                JsapiPermissionWrapper jsapiPermissionWrapper4 = this.Jch;
                AppMethodBeat.o(224485);
                return jsapiPermissionWrapper4;
            }
            JsapiPermissionWrapper jsapiPermissionWrapper5 = aVar.IBv;
            AppMethodBeat.o(224485);
            return jsapiPermissionWrapper5;
        }
    }

    public final GeneralControlWrapper aZF(String str) {
        AppMethodBeat.i(224486);
        if (this.Jcg != null) {
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Jcg);
            GeneralControlWrapper generalControlWrapper = this.Jcg;
            AppMethodBeat.o(224486);
            return generalControlWrapper;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(str)));
            GeneralControlWrapper generalControlWrapper2 = this.Jci;
            AppMethodBeat.o(224486);
            return generalControlWrapper2;
        } else {
            String aYy = aYy(str);
            a aVar = this.Jce.get(aYy);
            Log.i("MicroMsg.LuggageGetA8KeyPermission", "edw getGenCtrl, genCtrl = " + (aVar == null ? null : aVar.Jcj) + ", url = " + aYy);
            if (aVar == null) {
                GeneralControlWrapper generalControlWrapper3 = this.Jci;
                AppMethodBeat.o(224486);
                return generalControlWrapper3;
            }
            GeneralControlWrapper generalControlWrapper4 = aVar.Jcj;
            AppMethodBeat.o(224486);
            return generalControlWrapper4;
        }
    }

    static String aYy(String str) {
        AppMethodBeat.i(224487);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(224487);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(224487);
        return substring;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public JsapiPermissionWrapper IBv;
        public GeneralControlWrapper Jcj;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.IBv = jsapiPermissionWrapper;
            this.Jcj = generalControlWrapper;
        }

        public final String toString() {
            AppMethodBeat.i(224482);
            String str = "Permission: jsPerm = " + this.IBv + ", genCtrl = " + this.Jcj;
            AppMethodBeat.o(224482);
            return str;
        }
    }
}
