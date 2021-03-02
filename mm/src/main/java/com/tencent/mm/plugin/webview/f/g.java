package com.tencent.mm.plugin.webview.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.webview.d.p;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class g {
    public Map<String, a> Jce;
    private JsapiPermissionWrapper Jcf;
    private GeneralControlWrapper Jcg;
    private final JsapiPermissionWrapper Jch = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper Jci = GeneralControlWrapper.Kzh;
    private Map<String, HashMap<String, epn>> Jcq = new HashMap();
    private b Jcr;

    public interface b {
        String fZK();

        String fZL();
    }

    public g(b bVar) {
        AppMethodBeat.i(224492);
        this.Jcr = bVar;
        Log.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.Jcf + ", hardcodeGenCtrl = " + this.Jcg);
        this.Jce = new HashMap();
        AppMethodBeat.o(224492);
    }

    public final void a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(224493);
        this.Jcf = jsapiPermissionWrapper;
        if (ac.jOx == null || ac.jOx.length() == 0) {
            Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                int i2 = Util.getInt(ac.jOx, 0);
                if (i2 < 0) {
                    Log.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.Jcf = new JsapiPermissionWrapper(i2);
                    Log.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.Jcf);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e2.getMessage());
                this.Jcf = null;
            }
        }
        this.Jcg = generalControlWrapper;
        if (ac.jOy == null || ac.jOy.length() == 0) {
            Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
            AppMethodBeat.o(224493);
            return;
        }
        try {
            int i3 = Util.getInt(ac.jOy, 0);
            Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(i3));
            bgt bgt = new bgt();
            bgt.LQC = i3;
            this.Jcg = new GeneralControlWrapper(bgt);
        } catch (Exception e3) {
            Log.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", e3.getMessage());
            this.Jcg = null;
        }
        Log.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.Jcg);
        AppMethodBeat.o(224493);
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        boolean z = false;
        AppMethodBeat.i(224494);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewPermission", "update fail, url is null");
            AppMethodBeat.o(224494);
            return;
        }
        if (generalControlWrapper != null) {
            if ((generalControlWrapper.Kzi & 524288) != 0) {
                z = true;
            }
            Log.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(z)));
        }
        c.cN(str, z);
        String aYy = aYy(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.Jch;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.Jci;
        }
        Log.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + aYy);
        this.Jce.put(aYy, new a(jsapiPermissionWrapper, generalControlWrapper));
        AppMethodBeat.o(224494);
    }

    public final boolean has(String str) {
        AppMethodBeat.i(224495);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewPermission", "has fail, url is null");
            AppMethodBeat.o(224495);
            return false;
        }
        String aYy = aYy(str);
        if (this.Jce == null) {
            Log.e("MicroMsg.WebViewPermission", "has fail, permMap is null");
            AppMethodBeat.o(224495);
            return false;
        }
        a aVar = this.Jce.get(aYy);
        if (aVar == null || aVar.IBv == this.Jch || aVar.Jcj == this.Jci) {
            AppMethodBeat.o(224495);
            return false;
        }
        AppMethodBeat.o(224495);
        return true;
    }

    public final JsapiPermissionWrapper gdH() {
        String str;
        a aVar;
        JsapiPermissionWrapper gtN;
        boolean z;
        int ePA;
        AppMethodBeat.i(224496);
        if (this.Jcf != null) {
            Log.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.Jcf);
            JsapiPermissionWrapper jsapiPermissionWrapper = this.Jcf;
            AppMethodBeat.o(224496);
            return jsapiPermissionWrapper;
        }
        if (this.Jcr != null) {
            aVar = aZJ(this.Jcr.fZK());
            String fZL = this.Jcr.fZL();
            if (!Util.isNullOrNil(fZL)) {
                if (aVar == null) {
                    aVar = aZJ(fZL);
                }
                str = z.bfK(fZL);
            } else {
                str = fZL;
            }
        } else {
            str = null;
            aVar = null;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper2 = aVar != null ? aVar.IBv : null;
        if (str != null && this.Jcq.containsKey(str)) {
            if (jsapiPermissionWrapper2 == null) {
                gtN = new JsapiPermissionWrapper(new byte[0]);
                z = false;
            } else {
                gtN = jsapiPermissionWrapper2.gtN();
                z = true;
            }
            HashMap<String, epn> hashMap = this.Jcq.get(str);
            for (String str2 : hashMap.keySet()) {
                c.g bgb = com.tencent.mm.protocal.c.bgb(str2);
                if (bgb != null) {
                    ePA = bgb.gtt();
                } else {
                    p pVar = p.ISk;
                    com.tencent.mm.plugin.webview.d.c.a aYo = p.aYo(str2);
                    ePA = aYo != null ? aYo.ePA() : -1;
                }
                if (ePA >= 0) {
                    int aiW = z ? gtN.aiW(ePA) : 2;
                    int i2 = hashMap.get(str2).state;
                    if (aiW == 0) {
                        gtN.a(ePA, (byte) 0);
                    } else if (aiW == 2) {
                        gtN.a(ePA, (byte) i2);
                    } else {
                        gtN.a(ePA, (byte) aiW);
                    }
                }
            }
            jsapiPermissionWrapper2 = gtN;
        }
        if (jsapiPermissionWrapper2 == null) {
            JsapiPermissionWrapper jsapiPermissionWrapper3 = this.Jch;
            AppMethodBeat.o(224496);
            return jsapiPermissionWrapper3;
        }
        AppMethodBeat.o(224496);
        return jsapiPermissionWrapper2;
    }

    private static boolean agg(int i2) {
        return i2 == 0 || i2 == 2;
    }

    private a aZJ(String str) {
        AppMethodBeat.i(224497);
        if (!Util.isNullOrNil(str) && this.Jce != null) {
            String aYy = aYy(str);
            if (this.Jce.containsKey(aYy)) {
                a aVar = this.Jce.get(aYy);
                AppMethodBeat.o(224497);
                return aVar;
            }
        }
        AppMethodBeat.o(224497);
        return null;
    }

    public final void aR(Bundle bundle) {
        AppMethodBeat.i(224498);
        String string = bundle.getString("jsapi_preverify_commit_url");
        String string2 = bundle.getString("jsapi_preverify_current_url");
        m(bundle, string);
        if (!Util.isEqual(string, string2)) {
            m(bundle, string2);
        }
        AppMethodBeat.o(224498);
    }

    private void m(Bundle bundle, String str) {
        AppMethodBeat.i(263529);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("jsapi_preverify_fun_list");
        String bfK = z.bfK(z.aYy(str));
        if (!this.Jcq.containsKey(bfK)) {
            this.Jcq.put(bfK, new HashMap<>());
        }
        HashMap<String, epn> hashMap = this.Jcq.get(bfK);
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                epn epn = new epn();
                epn.parseFrom(bundle.getByteArray(next));
                if (agg(epn.state)) {
                    Log.w("MicroMsg.WebViewPermission", "skip update control bytes by preverify, %s, %d, %d", next, Integer.valueOf(epn.state), Integer.valueOf(epn.Nnk));
                } else {
                    hashMap.put(next, epn);
                    Log.i("MicroMsg.WebViewPermission", "update control bytes by preverify, %s, %d, %d", next, Integer.valueOf(epn.state), Integer.valueOf(epn.Nnk));
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebViewPermission", e2, "parse preverify info", new Object[0]);
            }
        }
        AppMethodBeat.o(263529);
    }

    public final GeneralControlWrapper gdI() {
        a aVar;
        GeneralControlWrapper generalControlWrapper = null;
        AppMethodBeat.i(224499);
        if (this.Jcg != null) {
            Log.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.Jcg);
            GeneralControlWrapper generalControlWrapper2 = this.Jcg;
            AppMethodBeat.o(224499);
            return generalControlWrapper2;
        }
        if (this.Jcr != null) {
            aVar = aZJ(this.Jcr.fZK());
            if (aVar == null) {
                aVar = aZJ(this.Jcr.fZL());
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            generalControlWrapper = aVar.Jcj;
        }
        if (generalControlWrapper == null) {
            GeneralControlWrapper generalControlWrapper3 = this.Jci;
            AppMethodBeat.o(224499);
            return generalControlWrapper3;
        }
        AppMethodBeat.o(224499);
        return generalControlWrapper;
    }

    public final boolean aZK(String str) {
        AppMethodBeat.i(224500);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, url = ".concat(String.valueOf(str)));
            AppMethodBeat.o(224500);
            return false;
        }
        String aYy = aYy(str);
        if (this.Jce == null) {
            Log.e("MicroMsg.WebViewPermission", "hasJsPerm fail, permMap is null");
            AppMethodBeat.o(224500);
            return false;
        }
        a aVar = this.Jce.get(aYy);
        Log.i("MicroMsg.WebViewPermission", "edw hasJsPerm, jsPerm = " + (aVar == null ? null : aVar.IBv) + ", url = " + aYy);
        if (aVar == null || aVar.IBv == null || aVar.IBv.equals(this.Jch)) {
            AppMethodBeat.o(224500);
            return false;
        }
        AppMethodBeat.o(224500);
        return true;
    }

    private static String aYy(String str) {
        AppMethodBeat.i(224501);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(224501);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(224501);
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
            AppMethodBeat.i(224491);
            String str = "Permission: jsPerm = " + this.IBv + ", genCtrl = " + this.Jcj;
            AppMethodBeat.o(224491);
            return str;
        }
    }
}
