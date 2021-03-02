package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.h;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class m extends g {
    protected Class SIp = null;
    protected Class SIq = null;
    protected int SIr = -1;
    ValueCallback<Pair<Integer, String>> SIs = new ValueCallback<Pair<Integer, String>>() {
        /* class com.tencent.xweb.xwalk.a.m.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Pair<Integer, String> pair) {
            AppMethodBeat.i(219104);
            Pair<Integer, String> pair2 = pair;
            switch (((Integer) pair2.first).intValue()) {
                case 0:
                    Log.v(m.this.getPluginName(), (String) pair2.second);
                    AppMethodBeat.o(219104);
                    return;
                case 1:
                    Log.d(m.this.getPluginName(), (String) pair2.second);
                    AppMethodBeat.o(219104);
                    return;
                case 2:
                    Log.i(m.this.getPluginName(), (String) pair2.second);
                    AppMethodBeat.o(219104);
                    return;
                case 3:
                    Log.w(m.this.getPluginName(), (String) pair2.second);
                    AppMethodBeat.o(219104);
                    return;
                case 4:
                    Log.e(m.this.getPluginName(), (String) pair2.second);
                    break;
            }
            AppMethodBeat.o(219104);
        }
    };
    ValueCallback<Pair<Integer, String>> SIt = new ValueCallback<Pair<Integer, String>>() {
        /* class com.tencent.xweb.xwalk.a.m.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Pair<Integer, String> pair) {
            AppMethodBeat.i(157198);
            Pair<Integer, String> pair2 = pair;
            switch (((Integer) pair2.first).intValue()) {
                case 0:
                    try {
                        String[] split = ((String) pair2.second).split(":");
                        if (split.length == 3) {
                            h.s(Long.parseLong(split[0]), (long) Integer.parseInt(split[1]), (long) Integer.parseInt(split[2]));
                        }
                        AppMethodBeat.o(157198);
                        return;
                    } catch (Exception e2) {
                        Log.e(m.this.getPluginName(), "idkeyReport parse error: " + ((String) pair2.second));
                        AppMethodBeat.o(157198);
                        return;
                    }
                case 1:
                    try {
                        String[] split2 = ((String) pair2.second).split(":");
                        if (split2.length == 2) {
                            int parseInt = Integer.parseInt(split2[0]);
                            String str = split2[1];
                            if (parseInt == 17565 || parseInt == 17564) {
                                str = m.this.SHU + "," + split2[1];
                            }
                            h.dz(parseInt, str);
                        }
                        AppMethodBeat.o(157198);
                        return;
                    } catch (Exception e3) {
                        Log.e(m.this.getPluginName(), "setKVLog parse error: " + ((String) pair2.second));
                        break;
                    }
            }
            AppMethodBeat.o(157198);
        }
    };

    public abstract String ata(int i2);

    public abstract int atb(int i2);

    public abstract String hvg();

    public abstract String hvh();

    private void hvv() {
        synchronized (this) {
            int hvk = hvk();
            if (this.SIp == null || this.SIq == null || this.SIr != hvk) {
                Log.i(getPluginName(), "load class of version ".concat(String.valueOf(hvk)));
                ClassLoader bx = i.bx(ata(hvk), ath(hvk), null);
                this.SIp = bx.loadClass(hvg());
                this.SIq = bx.loadClass(hvh());
                this.SIr = hvk;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c(String str, ValueCallback<Integer> valueCallback, int i2) {
        if (str == null || str.isEmpty()) {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equalsIgnoreCase(getPluginName())) {
                str = "ppt";
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equalsIgnoreCase(getPluginName())) {
                str = "pdf";
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equalsIgnoreCase(getPluginName())) {
                str = "doc";
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equalsIgnoreCase(getPluginName())) {
                str = "xls";
            } else {
                Log.e(getPluginName(), "onReceiveValueProcess unknown fileExt");
            }
        }
        int i3 = this.SHU;
        if (i3 > 0 && (i2 == -3 || i2 == -13)) {
            synchronized (this) {
                this.SIp = null;
                this.SIq = null;
                this.SIr = -1;
            }
            Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i3)));
            String atd = atd(i3);
            atc(-1);
            if (atd != null && !atd.isEmpty()) {
                c.bsB(atd);
            }
        }
        f.aZ(str, i3, i2);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Integer.valueOf(i2));
        }
    }

    private String ath(int i2) {
        String atd = atd(i2);
        if (atd != null && !atd.isEmpty()) {
            return atd + File.separator + ShareConstants.DEX_PATH;
        }
        Log.e(getPluginName(), "getDexDir, versionDir is empty");
        return "";
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final String ca(int i2, boolean z) {
        String atd = atd(i2);
        if (atd == null || atd.isEmpty()) {
            return "";
        }
        if (!z) {
            return atd + File.separator + getPluginName() + ".zip";
        }
        return atd + File.separator + getPluginName() + ".patch";
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final boolean hvi() {
        return false;
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final int a(com.tencent.xweb.xwalk.updater.c cVar) {
        Log.i(getPluginName(), "performInstall version " + cVar.version);
        boolean b2 = b(cVar);
        if (!b2) {
            Log.e(getPluginName(), "performInstall unZipAndCheck failed");
            h.dM(getPluginName(), cVar.SJc);
            return -1;
        }
        if (cVar.SJc) {
            try {
                b2 = c(cVar);
            } catch (Exception e2) {
                Log.e(getPluginName(), "performInstall doPatch error: ", e2);
            }
            if (!b2) {
                Log.e(getPluginName(), "performInstall doPatch failed, delete all");
                h.bsJ(getPluginName());
                String atd = atd(cVar.version);
                if (atd.isEmpty()) {
                    return -1;
                }
                c.bsB(atd);
                return -1;
            }
        }
        String ata = ata(cVar.version);
        String ath = ath(cVar.version);
        File file = new File(ath);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        }
        try {
            String a2 = a(i.bx(ata, ath, null));
            bsR(a2);
            String[] split = a2.split(",");
            y.hsF().a(split, f.a.NONE);
            y.hsF().a(split, f.c.none);
            e.ah(split);
            hvm();
            String ate = ate(cVar.version);
            if (ate != null && !ate.isEmpty()) {
                c.bsB(ate);
            }
            atc(cVar.version);
            Log.i(getPluginName(), "performInstall version " + this.SHU + " success");
            return 0;
        } catch (Exception e3) {
            h.dN(getPluginName(), cVar.SJc);
            Log.e(getPluginName(), "performInstall error: " + e3.getMessage());
            return -1;
        }
    }

    public final boolean dS(String str, boolean z) {
        String string;
        if (this.SHU < 0) {
            Log.i(getPluginName(), "isSupport, not installed");
            return false;
        }
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "getSupportFormat, context is null");
            string = "";
        } else {
            SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
            if (sharedPreferencesForPluginVersionInfo == null) {
                Log.e(getPluginName(), "getSupportFormat, sp is null");
                string = "";
            } else {
                string = sharedPreferencesForPluginVersionInfo.getString(XWalkEnvironment.SP_KEY_PLUGIN_SUPPORT_FORMATS, "");
            }
        }
        if (string.isEmpty() && z) {
            try {
                string = a((ClassLoader) null);
                bsR(string);
            } catch (Exception e2) {
                Log.e(getPluginName(), "isSupport error: " + e2.getMessage());
                return false;
            }
        }
        return string.toLowerCase().contains(str.toLowerCase());
    }

    private String a(ClassLoader classLoader) {
        Class<?> cls;
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(hvh());
            } catch (Exception e2) {
                Log.e(getPluginName(), "loadSupportFormatsFromPlugin error: " + e2.getMessage());
                return "";
            }
        } else {
            hvv();
            cls = this.SIq;
        }
        Method method = cls.getMethod("getSupportFormats", new Class[0]);
        method.setAccessible(true);
        String str = (String) method.invoke(null, new Object[0]);
        if (str == null) {
            return "";
        }
        return str;
    }

    private boolean bsR(String str) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "saveSupportFormats, context is null");
            return false;
        }
        SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (sharedPreferencesForPluginVersionInfo == null) {
            Log.e(getPluginName(), "saveSupportFormats, sp is null");
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferencesForPluginVersionInfo.edit();
        edit.putString(XWalkEnvironment.SP_KEY_PLUGIN_SUPPORT_FORMATS, str);
        boolean commit = edit.commit();
        Log.i(getPluginName(), "loadSupportFormat, ret = " + commit + ", formats: " + str);
        return commit;
    }

    public final boolean a(HashMap<String, String> hashMap, Activity activity, ViewGroup viewGroup, ValueCallback<Pair<String, Object>> valueCallback, final ValueCallback<Integer> valueCallback2) {
        int i2;
        if (activity == null || viewGroup == null) {
            Log.e(getPluginName(), "readFile params is null");
            c("", valueCallback2, -5);
            return false;
        }
        final String str = hashMap.get("file_ext");
        if (str == null || str.isEmpty()) {
            Log.e(getPluginName(), "readFile fileExt is null");
            c("", valueCallback2, -5);
            return false;
        }
        int i3 = this.SHU;
        if (i3 <= 0) {
            Log.e(getPluginName(), "readFile plugin not installed");
            c(str, valueCallback2, -2);
            return false;
        }
        if (valueCallback != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int atb = atb(i2);
        if (i3 < atb) {
            Log.e(getPluginName(), "readFile plugin version is too old, require: ".concat(String.valueOf(atb)));
            c(str, valueCallback2, -11);
            return false;
        }
        Log.i(getPluginName(), "readFile by xweb, plugin version ".concat(String.valueOf(i3)));
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equalsIgnoreCase(getPluginName())) {
            mQ(i3, 1068);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equalsIgnoreCase(getPluginName())) {
            mQ(i3, 1071);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equalsIgnoreCase(getPluginName())) {
            mQ(i3, 1069);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equalsIgnoreCase(getPluginName())) {
            mQ(i3, 1070);
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equalsIgnoreCase(getPluginName())) {
            mQ(i3, 1544);
        } else {
            Log.e(getPluginName(), "unknown report id");
        }
        try {
            hashMap.put("cache_dir", ate(i3));
            hashMap.put("res_dir", atf(i3));
            hvv();
            if (valueCallback != null) {
                Method method = this.SIp.getMethod("readFile", Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class);
                method.setAccessible(true);
                e.onStart(str);
                method.invoke(null, activity, viewGroup, this.SIp.getClassLoader(), hashMap, valueCallback, this.SIs, this.SIt, new ValueCallback<Integer>() {
                    /* class com.tencent.xweb.xwalk.a.m.AnonymousClass3 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Integer num) {
                        AppMethodBeat.i(157199);
                        Integer num2 = num;
                        Log.i(m.this.getPluginName(), "readFile onReceiveValue: ".concat(String.valueOf(num2)));
                        e.Hn(str);
                        m.this.c(str, valueCallback2, num2.intValue());
                        AppMethodBeat.o(157199);
                    }
                });
            } else {
                Method method2 = this.SIp.getMethod("readFile", Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class);
                method2.setAccessible(true);
                e.onStart(str);
                method2.invoke(null, activity, viewGroup, this.SIp.getClassLoader(), hashMap, this.SIs, this.SIt, new ValueCallback<Integer>() {
                    /* class com.tencent.xweb.xwalk.a.m.AnonymousClass4 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Integer num) {
                        AppMethodBeat.i(219105);
                        Integer num2 = num;
                        Log.i(m.this.getPluginName(), "readFile onReceiveValue: ".concat(String.valueOf(num2)));
                        e.Hn(str);
                        m.this.c(str, valueCallback2, num2.intValue());
                        AppMethodBeat.o(219105);
                    }
                });
            }
            return true;
        } catch (Exception e2) {
            Log.e(getPluginName(), "readFile error: " + e2.getMessage());
            f.a(getPluginName(), i3, "invoke error ", e2);
            c(str, valueCallback2, -3);
            return false;
        }
    }

    public final void D(HashMap<String, String> hashMap) {
        if (this.SIp == null) {
            Log.e(getPluginName(), "finishReadFile error, loadedReaderClass is null");
            return;
        }
        try {
            Method method = this.SIp.getMethod("finishReadFile", HashMap.class);
            method.setAccessible(true);
            method.invoke(null, hashMap);
        } catch (Exception e2) {
            Log.e(getPluginName(), "finishReadFile error: " + e2.getMessage());
        }
    }

    public final h.b E(HashMap<String, Object> hashMap) {
        if (this.SIp == null) {
            Log.e(getPluginName(), "getViewStatus error, loadedReaderClass is null");
            return null;
        }
        try {
            Method method = this.SIp.getMethod("getViewStatus", HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (!(invoke instanceof HashMap)) {
                return null;
            }
            HashMap hashMap2 = (HashMap) invoke;
            Object obj = hashMap2.get("get_index");
            Object obj2 = hashMap2.get("get_zoom");
            Object obj3 = hashMap2.get("get_x");
            Object obj4 = hashMap2.get("get_y");
            if ((obj instanceof Integer) && (obj2 instanceof Float) && (obj3 instanceof Integer) && (obj4 instanceof Integer)) {
                return new h.b(((Integer) obj).intValue(), ((Float) obj2).floatValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
            }
            Log.e(getPluginName(), "getViewStatus error, value invalid");
            return null;
        } catch (Exception e2) {
            Log.e(getPluginName(), "getViewStatus error: " + e2.getMessage());
            return null;
        }
    }

    public final boolean F(HashMap<String, Object> hashMap) {
        if (this.SIp == null) {
            Log.e(getPluginName(), "setViewToStatus error, loadedReaderClass is null");
            return false;
        }
        try {
            Method method = this.SIp.getMethod("setViewToStatus", HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e2) {
            Log.e(getPluginName(), "setViewToStatus error: " + e2.getMessage());
            return false;
        }
    }

    public final boolean G(HashMap<String, Object> hashMap) {
        if (this.SIp == null) {
            Log.e(getPluginName(), "requestThumbnail error, loadedReaderClass is null");
            return false;
        }
        try {
            Method method = this.SIp.getMethod("requestThumbnail", HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e2) {
            Log.e(getPluginName(), "requestThumbnail error: " + e2.getMessage());
            return false;
        }
    }

    public final Object H(HashMap<String, Object> hashMap) {
        if (this.SIp == null) {
            Log.e(getPluginName(), "generalInvoke error, loadedReaderClass is null");
            return null;
        }
        try {
            Method method = this.SIp.getMethod("generalInvoke", HashMap.class);
            method.setAccessible(true);
            return method.invoke(null, hashMap);
        } catch (Exception e2) {
            Log.e(getPluginName(), "generalInvoke error: " + e2.getMessage());
            return null;
        }
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final void hvj() {
        int i2 = this.SHU;
        if (i2 < 0) {
            Log.i(getPluginName(), "checkFiles, not installed");
        } else if (!cb(i2, true)) {
            Log.e(getPluginName(), "checkFiles failed, abandon version ".concat(String.valueOf(i2)));
            com.tencent.xweb.util.h.bsK(getPluginName());
            String atd = atd(i2);
            atc(-1);
            if (atd != null && !atd.isEmpty()) {
                c.bsB(atd);
            }
        }
    }
}
