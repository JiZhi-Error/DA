package com.tencent.mm.plugin.performance.diagnostic.c;

import android.os.Process;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.b.a;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.plugin.performance.diagnostic.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.n.d;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a<PthreadHook, a> implements a.AbstractC1570a {
    private static final o ATV;
    private static final o ATW;
    private static final long ATX = (BuildInfo.IS_FLAVOR_RED ? 300000 : 1800000);
    private static final Set<String> ATY = new HashSet();
    private static String TAG = "MicroMsg.PthreadHookLogic";
    public final a ATZ = new a(this);

    public b() {
        AppMethodBeat.i(201078);
        AppMethodBeat.o(201078);
    }

    static {
        AppMethodBeat.i(201087);
        String eBE = eBE();
        TAG += eBE;
        String str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
        String str2 = str + FilePathGenerator.ANDROID_DIR_SEP + eBE + Process.myPid() + "_pthread_hook.json";
        ATV = new o(str);
        ATW = new o(str2);
        Log.i(TAG, "init dump file path = %s", str2);
        AppMethodBeat.o(201087);
    }

    @Override // com.tencent.mm.plugin.performance.a.c, com.tencent.mm.plugin.performance.diagnostic.a
    public final void eBD() {
        AppMethodBeat.i(201079);
        Log.i(TAG, "onRegistered: %s", "PthreadHook");
        c.ATi.a("pthread", this);
        com.tencent.mm.plugin.performance.b.a.AUa.b(this);
        AppMethodBeat.o(201079);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final void a(a.c cVar) {
        int i2;
        AppMethodBeat.i(201080);
        h.INSTANCE.n(1571, 12, 1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey(1376, 12, 1);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 70;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 71;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            i2 = 72;
        } else {
            i2 = -1;
        }
        IDKey iDKey2 = new IDKey(1376, i2, 1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(201080);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final String eBH() {
        AppMethodBeat.i(201082);
        StringBuilder sb = new StringBuilder();
        sb.append("hook=").append(this.ATZ.eBZ()).append(",thread=").append(this.ATZ.eCm()).append("\t");
        String sb2 = sb.toString();
        AppMethodBeat.o(201082);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final String eBI() {
        return "PthreadHook";
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final void eCj() {
        int i2;
        AppMethodBeat.i(201083);
        com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_diagnostic_pthread_hook_expt_cmd, "<cmd><diagnostic><PthreadHook\n enable='1' process='" + eBM() + "' duration='24' hook='.*\\.so$' thread='.*'/></diagnostic></cmd>"));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey(1376, 10, 1);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 50;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 51;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            i2 = 52;
        } else {
            i2 = -1;
        }
        IDKey iDKey2 = new IDKey(1376, i2, 1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(201083);
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final double eCk() {
        AppMethodBeat.i(201084);
        double a2 = 1.0d / ((double) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_diagnostic_pthread_hook_expt_rate_denominator, -1L));
        AppMethodBeat.o(201084);
        return a2;
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final long eCl() {
        AppMethodBeat.i(201085);
        long minutes = TimeUnit.DAYS.toMinutes(1);
        AppMethodBeat.o(201085);
        return minutes;
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final void hd(boolean z) {
        AppMethodBeat.i(201081);
        Log.i(TAG, "memory dump begin");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            o oVar = ATV;
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            PthreadHook pthreadHook = PthreadHook.SyB;
            String z2 = aa.z(ATW.her());
            if (HookManager.Syn.Syo) {
                pthreadHook.dumpNative(z2);
            }
            Log.i(TAG, "dump path = %s", aa.z(ATW.her()));
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "something wrong when dumping", new Object[0]);
        }
        Log.i(TAG, "memory dump end, cost = %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        o oVar2 = new o(aa.z(ATW.her()));
        Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", oVar2.getName(), com.tencent.mm.plugin.performance.c.HF(oVar2.lastModified()));
        try {
            JSONArray jSONArray = new JSONObject(com.tencent.mm.plugin.performance.c.a(aa.z(oVar2.her()), d.UTF_8)).getJSONArray("PthreadHook");
            long currentTimeMillis2 = System.currentTimeMillis();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long j2 = Util.getLong(jSONObject.getString("hash"), 0);
                String string = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
                String string2 = jSONObject.getString("java");
                int i3 = Util.getInt(jSONObject.getString("count"), 0);
                JSONArray jSONArray2 = jSONObject.getJSONArray("threads");
                Log.i(TAG, "------------------------------- hash= %d -------------------------------", Long.valueOf(j2));
                Log.i(TAG, "native\n\t%s", string.replace(";", "\n\t"));
                Log.i(TAG, "java\n\t%s", string2.replace(";", "\n\t"));
                Log.i(TAG, "ThreadCount = %d", Integer.valueOf(i3));
                ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    StringBuilder sb = new StringBuilder();
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                    sb.append("{").append(jSONObject2.getString("tid")).append("-").append(jSONObject2.getString("name")).append("}");
                    String sb2 = sb.toString();
                    arrayList.add(sb2);
                    if (!ATY.contains(sb2)) {
                        hashSet.add(sb2);
                    }
                }
                Log.i(TAG, "==> leaked threads : %s", arrayList.toString().replace(",", ""));
                if (!hashSet.isEmpty()) {
                    h.INSTANCE.a(19816, 0, Long.valueOf(currentTimeMillis2), Long.valueOf(j2), string, string2, Integer.valueOf(i3), arrayList.toString().replace(",", ""), MMApplicationContext.getProcessName());
                    ATY.addAll(hashSet);
                    Log.i(TAG, "reported %s", hashSet);
                }
            }
            if (WeChatEnvironment.isMonkeyEnv() || WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                com.tencent.mm.plugin.performance.c.T(oVar2);
            }
            oVar2.delete();
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "report kv error", new Object[0]);
            oVar2.delete();
        } catch (Throwable th) {
            oVar2.delete();
            AppMethodBeat.o(201081);
            throw th;
        }
        Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", oVar2.getName(), com.tencent.mm.plugin.performance.c.HF(oVar2.lastModified()));
        AppMethodBeat.o(201081);
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final String Lb() {
        return "PthreadHook";
    }

    /* Return type fixed from 'com.tencent.mm.plugin.performance.diagnostic.a$a' to match base method */
    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final /* bridge */ /* synthetic */ a eBG() {
        return this.ATZ;
    }

    /* Return type fixed from 'com.tencent.wxperf.jni.a' to match base method */
    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final /* synthetic */ PthreadHook eBF() {
        AppMethodBeat.i(201086);
        String eBZ = this.ATZ.eBZ();
        String eCa = this.ATZ.eCa();
        String eCm = this.ATZ.eCm();
        String[] split = eBZ.split(";");
        String[] split2 = eCa == null ? new String[0] : eCa.split(";");
        String[] split3 = eCm == null ? new String[]{".*"} : eCm.split(";");
        Log.i(TAG, "hookRegex = %s", Arrays.toString(split));
        Log.i(TAG, "ignoreRegex = %s", Arrays.toString(split2));
        Log.i(TAG, "threadRegex = %s", Arrays.toString(split3));
        PthreadHook pthreadHook = PthreadHook.SyB;
        for (String str : split) {
            if (TextUtils.isEmpty(str)) {
                com.tencent.stubs.logger.Log.e("Wxperf.Pthread", "so regex is empty");
            } else {
                pthreadHook.Syt.add(str);
            }
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2)) {
                pthreadHook.Syu.add(str2);
            }
        }
        for (String str3 : split3) {
            if (TextUtils.isEmpty(str3)) {
                com.tencent.stubs.logger.Log.e("Wxperf.Pthread", "thread regex is empty!!!");
            } else {
                pthreadHook.SyC.add(str3);
            }
        }
        AppMethodBeat.o(201086);
        return pthreadHook;
    }
}
