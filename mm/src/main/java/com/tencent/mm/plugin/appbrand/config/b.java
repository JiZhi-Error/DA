package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.h.j;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements m {
    public boolean cBF = false;
    public String iJP;
    private C0566b lbH;
    private C0566b lbI;
    private Map<String, d> lbJ;
    private Map<String, d> lbK;
    private Map<String, e> lbL;
    private g lbM;
    private g lbN;
    c lbO;
    public a lbP;
    public Boolean lbQ = null;
    public Boolean lbR = Boolean.FALSE;
    public Set<String> lbS;
    public JSONArray lbT;
    public ArrayList<String> lbU;
    public boolean lbV = false;
    public JSONObject lbW;
    public JSONObject lbX;
    private JSONObject lbY;
    private JSONObject lbZ;
    private JSONObject lca;
    private JSONObject lcb;
    public String lcc;

    public static class a {
        public String cBG = "portrait";
        public boolean lcd = true;
    }

    public static class c {
        public int egB;
        public int lce;
        public int lcf;
        public int lcg;
    }

    public static class f {
        public String lch;
        public String lci;
        public double lcj = -1.0d;
        public String lck;
        public String lcl;
    }

    public final d WV(String str) {
        AppMethodBeat.i(134764);
        if (!TextUtils.isEmpty(str)) {
            if (!this.lbJ.containsKey(str)) {
                str = n.Wf(str);
            }
            if (this.lbJ.containsKey(str)) {
                if (!j.cDv.isDarkMode() || this.lbK == null || !this.lbK.containsKey(str)) {
                    d dVar = this.lbJ.get(str);
                    AppMethodBeat.o(134764);
                    return dVar;
                }
                d dVar2 = this.lbK.get(str);
                AppMethodBeat.o(134764);
                return dVar2;
            }
        }
        d a2 = a((JSONObject) null, (i) this.lbH);
        AppMethodBeat.o(134764);
        return a2;
    }

    public final boolean bzD() {
        AppMethodBeat.i(185194);
        if (!bzE() || !j.cDv.isDarkMode()) {
            AppMethodBeat.o(185194);
            return false;
        }
        AppMethodBeat.o(185194);
        return true;
    }

    public final boolean bzE() {
        AppMethodBeat.i(219307);
        if (this.lbX == null || this.lbX.length() <= 0) {
            AppMethodBeat.o(219307);
            return false;
        }
        AppMethodBeat.o(219307);
        return true;
    }

    public final a bzH() {
        return this.lbP;
    }

    public final e WW(String str) {
        AppMethodBeat.i(134767);
        e eVar = this.lbL.get(str);
        AppMethodBeat.o(134767);
        return eVar;
    }

    public static boolean isDarkMode() {
        AppMethodBeat.i(259547);
        boolean isDarkMode = j.cDv.isDarkMode();
        AppMethodBeat.o(259547);
        return isDarkMode;
    }

    public final String bzI() {
        AppMethodBeat.i(134769);
        if (!Util.isNullOrNil(this.lcc)) {
            String str = this.lcc;
            AppMethodBeat.o(134769);
            return str;
        }
        AppMethodBeat.o(134769);
        return "index.html";
    }

    public static b cS(String str, String str2) {
        AppMethodBeat.i(134770);
        b b2 = b(str, str2, "{}", false, false);
        AppMethodBeat.o(134770);
        return b2;
    }

    public static b b(String str, String str2, String str3, boolean z, boolean z2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        boolean z3 = true;
        AppMethodBeat.i(134771);
        b bVar = new b();
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandAppConfig", e2.getMessage());
            jSONObject = new JSONObject();
        }
        if (jSONObject.length() != 0) {
            bVar.lbR = Boolean.TRUE;
        }
        bVar.lcc = jSONObject.optString("entryPagePath");
        bVar.iJP = jSONObject.optString("referrerPolicy");
        bVar.lbH = b(jSONObject.optJSONObject("global"), z2);
        bVar.lbJ = a(jSONObject.optJSONObject("page"), bVar.lbH);
        bVar.lbL = B(jSONObject.optJSONObject("permission"));
        bVar.lbM = C(jSONObject.optJSONObject("tabBar"));
        JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
        c cVar = new c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.egB = optJSONObject.optInt(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        cVar.lce = optJSONObject.optInt("connectSocket");
        cVar.lcg = optJSONObject.optInt("downloadFile");
        cVar.lcf = optJSONObject.optInt("uploadFile");
        bVar.lbO = cVar;
        a aVar = new a();
        aVar.cBG = jSONObject.optString("deviceOrientation", "portrait");
        aVar.lcd = jSONObject.optBoolean("showStatusBar", false);
        bVar.lbP = aVar;
        if (jSONObject.has("useCommandBuffer")) {
            bVar.lbQ = Boolean.valueOf(jSONObject.optBoolean("useCommandBuffer", false));
        }
        bVar.lbS = i(jSONObject.optJSONArray("requiredBackgroundModes"));
        bVar.lbT = jSONObject.optJSONArray("preloadResources");
        bVar.lbU = j(jSONObject.optJSONArray("preloadSubpackages"));
        bVar.lbV = jSONObject.optBoolean("manualHideSplashScreen", false);
        bVar.cBF = jSONObject.optBoolean("resizable", false);
        try {
            if (TextUtils.isEmpty(str3) || "{}".equals(str3)) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = new JSONObject(str3);
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.AppBrandAppConfig", "parse darkMode appId:%s, e:%s", str, e3);
            jSONObject2 = new JSONObject();
        }
        StringBuilder sb = new StringBuilder("darkModeJson is Empty = ");
        if (jSONObject2.length() != 0) {
            z3 = false;
        }
        Log.i("MicroMsg.AppBrandAppConfig", sb.append(z3).toString());
        if (jSONObject2.length() != 0) {
            bVar.lbI = b(jSONObject2.optJSONObject("global"), z2);
            bVar.lbN = C(jSONObject2.optJSONObject("tabBar"));
            bVar.lbK = a(jSONObject2.optJSONObject("page"), bVar.lbI);
        }
        bVar.lbW = jSONObject;
        bVar.lbY = jSONObject.optJSONObject("page");
        bVar.lca = jSONObject.optJSONObject("preloadRule");
        if (bVar.lbW != null) {
            c.a(str, bVar.lbW, z);
        }
        bVar.lbX = jSONObject2;
        bVar.lbZ = jSONObject2.optJSONObject("page");
        bVar.lcb = jSONObject2.optJSONObject("preloadRule");
        bVar.lcb = jSONObject2.optJSONObject("preloadRule");
        if (jSONObject2.length() > 0) {
            try {
                String str4 = j.cDv.isDarkMode() ? "dark" : "light";
                bVar.lbX.put("theme", str4);
                bVar.lbW.put("theme", str4);
            } catch (JSONException e4) {
                Log.printErrStackTrace("MicroMsg.AppBrandAppConfig", e4, "", new Object[0]);
            }
        }
        if (bVar.lbX != null) {
            c.a(str, bVar.lbX, z);
        }
        AppMethodBeat.o(134771);
        return bVar;
    }

    private static C0566b b(JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(134772);
        C0566b bVar = new C0566b(jSONObject, z);
        AppMethodBeat.o(134772);
        return bVar;
    }

    private static Map<String, d> a(JSONObject jSONObject, C0566b bVar) {
        AppMethodBeat.i(134773);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(134773);
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.optJSONObject(next), (i) bVar));
        }
        AppMethodBeat.o(134773);
        return hashMap;
    }

    private static Map<String, e> B(JSONObject jSONObject) {
        AppMethodBeat.i(134774);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(134774);
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                try {
                    hashMap.put(next, new e(next, optJSONObject));
                } catch (JSONException e2) {
                    Log.e("MicroMsg.AppBrandAppConfig", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(134774);
        return hashMap;
    }

    private static d a(JSONObject jSONObject, i iVar) {
        AppMethodBeat.i(134775);
        d dVar = new d(jSONObject, iVar);
        AppMethodBeat.o(134775);
        return dVar;
    }

    private static g C(JSONObject jSONObject) {
        AppMethodBeat.i(134776);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        g gVar = new g(jSONObject);
        AppMethodBeat.o(134776);
        return gVar;
    }

    private static Set<String> i(JSONArray jSONArray) {
        AppMethodBeat.i(134777);
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            AppMethodBeat.o(134777);
            return hashSet;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (!Util.isNullOrNil(optString)) {
                hashSet.add(optString);
            }
        }
        AppMethodBeat.o(134777);
        return hashSet;
    }

    private static ArrayList<String> j(JSONArray jSONArray) {
        AppMethodBeat.i(134778);
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            AppMethodBeat.o(134778);
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("root");
                if (!Util.isNullOrNil(optString)) {
                    if (!optString.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        optString = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(optString));
                    }
                    if (!optString.endsWith(".js") && !optString.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        optString = optString + FilePathGenerator.ANDROID_DIR_SEP;
                    }
                    arrayList.add(optString);
                }
            }
        }
        AppMethodBeat.o(134778);
        return arrayList;
    }

    public static abstract class i {
        static final JSONObject lcE = new JSONObject();
        private static final i lct = new i() {
            /* class com.tencent.mm.plugin.appbrand.config.b.i.AnonymousClass1 */
        };
        public boolean cBF;
        public final String lcA;
        public final String lcB;
        public final f lcC;
        public final String lcD;
        public final String lci;
        public final double lcj;
        public final String lck;
        public final String lcl;
        public final String lco;
        public final String lcu;
        public final String lcv;
        public final boolean lcw;
        public final boolean lcx;
        public final boolean lcy;
        public final boolean lcz;

        /* synthetic */ i(byte b2) {
            this();
        }

        private i() {
            this.lcj = 1.0d;
            this.cBF = false;
            this.lcl = null;
            this.lck = null;
            this.lcu = BuildConfig.KINDA_DEFAULT;
            this.lci = "#000000";
            this.lcv = null;
            this.lcw = false;
            this.lco = null;
            this.lcx = false;
            this.lcy = false;
            this.lcz = false;
            this.lcA = null;
            this.lcB = null;
            this.lcC = new f();
            this.lcD = null;
        }

        public i(JSONObject jSONObject, i iVar, boolean z) {
            String optString;
            f fVar;
            this.lcj = 1.0d;
            this.cBF = false;
            iVar = iVar == null ? lct : iVar;
            jSONObject = jSONObject == null ? lcE : jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            optJSONObject = optJSONObject == null ? lcE : optJSONObject;
            this.lcl = optJSONObject.optString("navigationBarTitleText", iVar.lcl);
            this.lck = optJSONObject.optString("navigationBarTextStyle", iVar.lck);
            if (z) {
                optString = "custom";
            } else {
                optString = optJSONObject.optString("navigationStyle", iVar.lcu);
            }
            this.lcu = optString;
            this.lci = optJSONObject.optString("navigationBarBackgroundColor", iVar.lci);
            this.lco = optJSONObject.optString("backgroundColor", iVar.lco);
            this.lcy = optJSONObject.optBoolean("enablePullDownRefresh", iVar.lcy);
            this.lcA = optJSONObject.optString("backgroundTextStyle", iVar.lcA);
            this.lcx = optJSONObject.optBoolean("enableFullScreen", iVar.lcx);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("navigationBarRightButton");
            optJSONObject2 = optJSONObject2 == null ? lcE : optJSONObject2;
            this.lcz = optJSONObject.optBoolean("disableSwipeBack", iVar.lcz);
            this.lcw = optJSONObject2.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, iVar.lcw);
            this.lcv = optJSONObject2.optString("customButtonIconData", iVar.lcv);
            this.lcB = optJSONObject.optString("pageOrientation", iVar.lcB);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("singlePage");
            optJSONObject3 = optJSONObject3 == null ? jSONObject.optJSONObject("singlePage") : optJSONObject3;
            f fVar2 = new f();
            if (optJSONObject3 == null) {
                fVar = fVar2;
            } else {
                fVar2.lch = optJSONObject3.optString("navigationBarFit", null);
                fVar2.lci = optJSONObject3.optString("navigationBarBackgroundColor", "");
                fVar2.lcj = optJSONObject3.optDouble("navigationBarBackgroundAlpha", -1.0d);
                fVar2.lck = optJSONObject3.optString("navigationBarTextStyle", "");
                fVar2.lcl = optJSONObject3.optString("navigationBarTitleText", "");
                fVar = fVar2;
            }
            this.lcC = fVar;
            this.cBF = optJSONObject.optBoolean("resizable", false);
            this.lcD = optJSONObject.optString("visualEffectInBackground", iVar.lcD);
        }

        public i(JSONObject jSONObject, i iVar) {
            this(jSONObject, iVar, false);
        }

        public final boolean bzL() {
            return "custom".equalsIgnoreCase(this.lcu);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.b$b  reason: collision with other inner class name */
    public static class C0566b extends i {
        public C0566b(JSONObject jSONObject, boolean z) {
            this(jSONObject, z, (byte) 0);
        }

        private C0566b(JSONObject jSONObject, boolean z, byte b2) {
            super(jSONObject, null, z);
            AppMethodBeat.i(178576);
            (jSONObject == null ? i.lcE : jSONObject).optJSONObject("window");
            AppMethodBeat.o(178576);
        }
    }

    public static final class e {
        public final String desc;
        public final String name;

        public e(String str, JSONObject jSONObject) {
            AppMethodBeat.i(134757);
            this.name = str;
            this.desc = jSONObject.getString("desc");
            AppMethodBeat.o(134757);
        }

        public final String toString() {
            AppMethodBeat.i(134758);
            String str = "Permission{name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
            AppMethodBeat.o(134758);
            return str;
        }
    }

    public static class d extends i {
        public d(JSONObject jSONObject, i iVar) {
            super(jSONObject, iVar);
        }
    }

    public static class g {
        private static final g lcr = new g();
        public final String ixw;
        public final String lcm;
        public final String lcn;
        public final String lco;
        public final String lcp;
        public final boolean lcq;
        public final ArrayList<h> lj;

        static {
            AppMethodBeat.i(134762);
            AppMethodBeat.o(134762);
        }

        private g() {
            AppMethodBeat.i(134759);
            this.lj = new ArrayList<>();
            this.lcm = "";
            this.ixw = "";
            this.lcn = "";
            this.lco = "";
            this.lcp = "";
            this.lcq = false;
            AppMethodBeat.o(134759);
        }

        public g(JSONObject jSONObject) {
            AppMethodBeat.i(134760);
            this.lj = new ArrayList<>();
            g gVar = lcr;
            this.lcm = jSONObject.optString("position", gVar.lcm);
            this.ixw = jSONObject.optString("color", gVar.ixw);
            this.lcn = jSONObject.optString("selectedColor", gVar.lcn);
            this.lco = jSONObject.optString("backgroundColor", gVar.lco);
            this.lcp = jSONObject.optString("borderStyle", gVar.lcp);
            this.lcq = jSONObject.optBoolean("custom", gVar.lcq);
            this.lj.addAll(gVar.lj);
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    h D = b.D(jSONArray.getJSONObject(i2));
                    Iterator<h> it = this.lj.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (TextUtils.equals(it.next().url, D.url)) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.lj.add(D);
                }
                AppMethodBeat.o(134760);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandAppConfig", e2.getMessage());
                AppMethodBeat.o(134760);
            }
        }

        public final boolean WX(String str) {
            AppMethodBeat.i(134761);
            Iterator<h> it = this.lj.iterator();
            while (it.hasNext()) {
                if (it.next().url.equals(l.dM(str))) {
                    AppMethodBeat.o(134761);
                    return true;
                }
            }
            AppMethodBeat.o(134761);
            return false;
        }
    }

    public static class h {
        public final String icon;
        public final String lcs;
        public final String text;
        public final String url;

        public h(JSONObject jSONObject) {
            AppMethodBeat.i(134763);
            this.url = jSONObject.optString("pagePath");
            this.text = jSONObject.optString("text");
            this.icon = jSONObject.optString("iconData");
            this.lcs = jSONObject.optString("selectedIconData");
            AppMethodBeat.o(134763);
        }
    }

    public final C0566b bzF() {
        AppMethodBeat.i(134765);
        if (!j.cDv.isDarkMode() || this.lbI == null) {
            C0566b bVar = this.lbH;
            AppMethodBeat.o(134765);
            return bVar;
        }
        C0566b bVar2 = this.lbI;
        AppMethodBeat.o(134765);
        return bVar2;
    }

    public final g bzG() {
        AppMethodBeat.i(134766);
        if (!j.cDv.isDarkMode() || this.lbN == null) {
            g gVar = this.lbM;
            AppMethodBeat.o(134766);
            return gVar;
        }
        g gVar2 = this.lbN;
        AppMethodBeat.o(134766);
        return gVar2;
    }

    public final JSONObject bzJ() {
        AppMethodBeat.i(134779);
        if (!j.cDv.isDarkMode() || this.lbZ == null || this.lbZ.length() == 0) {
            JSONObject jSONObject = this.lbY;
            AppMethodBeat.o(134779);
            return jSONObject;
        }
        JSONObject jSONObject2 = this.lbZ;
        AppMethodBeat.o(134779);
        return jSONObject2;
    }

    public final JSONObject bzK() {
        AppMethodBeat.i(134780);
        if (!j.cDv.isDarkMode() || this.lcb == null || this.lcb.length() == 0) {
            JSONObject jSONObject = this.lca;
            AppMethodBeat.o(134780);
            return jSONObject;
        }
        JSONObject jSONObject2 = this.lcb;
        AppMethodBeat.o(134780);
        return jSONObject2;
    }

    static /* synthetic */ h D(JSONObject jSONObject) {
        AppMethodBeat.i(134781);
        h hVar = new h(jSONObject);
        AppMethodBeat.o(134781);
        return hVar;
    }
}
