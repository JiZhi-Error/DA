package com.tencent.mm.plugin.performance.diagnostic.b;

import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.b.a;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.wxperf.jni.memory.MemoryHook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.n.d;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a<MemoryHook, a> implements a.AbstractC1570a {
    private static final o ATN;
    private static final o ATO;
    private static final o ATP;
    private static String TAG = "MicroMsg.MemoryHookLogic";
    public final a ATQ = new a(this);
    private c.a ATR;

    public b() {
        AppMethodBeat.i(124959);
        AppMethodBeat.o(124959);
    }

    static {
        AppMethodBeat.i(124967);
        String eBE = eBE();
        TAG += eBE;
        String str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
        String str2 = str + FilePathGenerator.ANDROID_DIR_SEP + eBE + Process.myPid() + "_memory_hook.log";
        String str3 = str + FilePathGenerator.ANDROID_DIR_SEP + eBE + Process.myPid() + "_memory_hook.json";
        ATN = new o(str);
        ATO = new o(str2);
        ATP = new o(str3);
        Log.i(TAG, "init dump file path = %s", str2);
        Log.i(TAG, "init json file path = %s", str3);
        AppMethodBeat.o(124967);
    }

    @Override // com.tencent.mm.plugin.performance.a.c, com.tencent.mm.plugin.performance.diagnostic.a
    public final void eBD() {
        AppMethodBeat.i(201059);
        Log.i(TAG, "onRegistered: %s", "MemoryHook");
        com.tencent.mm.plugin.performance.diagnostic.c.ATi.a("memory", this);
        com.tencent.mm.plugin.performance.b.a.AUa.b(this);
        AppMethodBeat.o(201059);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final void a(a.c cVar) {
        int i2;
        AppMethodBeat.i(201060);
        Log.i(TAG, "onHookEnabled: source = %s", cVar.name());
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey(1571, 2, 1);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 40;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 41;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            i2 = 42;
        } else {
            i2 = -1;
        }
        IDKey iDKey2 = new IDKey(1571, i2, 1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(201060);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final void hd(boolean z) {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(201061);
        if (z) {
            if (Debug.getNativeHeapAllocatedSize() > 524288000) {
                jo(null, aa.z(ATP.her()));
            }
            eCi();
            AppMethodBeat.o(201061);
            return;
        }
        jo(aa.z(ATO.her()), aa.z(ATP.her()));
        eCi();
        String str = TAG;
        o oVar = ATO;
        Log.i(str, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", oVar.getName(), com.tencent.mm.plugin.performance.c.HF(oVar.lastModified()));
        if (oVar.exists()) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(s.ao(oVar)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        Log.i(str, readLine);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            Log.printErrStackTrace(str, e, "", new Object[0]);
                            Util.qualityClose(bufferedReader);
                            oVar.delete();
                            Log.i(str, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", oVar.getName(), com.tencent.mm.plugin.performance.c.HF(oVar.lastModified()));
                            AppMethodBeat.o(201061);
                        } catch (Throwable th2) {
                            th = th2;
                            Util.qualityClose(bufferedReader);
                            oVar.delete();
                            AppMethodBeat.o(201061);
                            throw th;
                        }
                    }
                }
                if (WeChatEnvironment.isMonkeyEnv() || WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    com.tencent.mm.plugin.performance.c.T(oVar);
                }
                Util.qualityClose(bufferedReader);
                oVar.delete();
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
                Log.printErrStackTrace(str, e, "", new Object[0]);
                Util.qualityClose(bufferedReader);
                oVar.delete();
                Log.i(str, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", oVar.getName(), com.tencent.mm.plugin.performance.c.HF(oVar.lastModified()));
                AppMethodBeat.o(201061);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                Util.qualityClose(bufferedReader);
                oVar.delete();
                AppMethodBeat.o(201061);
                throw th;
            }
        }
        Log.i(str, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", oVar.getName(), com.tencent.mm.plugin.performance.c.HF(oVar.lastModified()));
        AppMethodBeat.o(201061);
    }

    public final void a(c.a aVar) {
        AppMethodBeat.i(201062);
        this.ATR = aVar;
        hd(false);
        AppMethodBeat.o(201062);
    }

    private static void jo(String str, String str2) {
        AppMethodBeat.i(201063);
        Log.i(TAG, "memory dump begin");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            o oVar = ATN;
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            MemoryHook.Sys.dump(str, str2);
            Log.i(TAG, "dump path = %s, json path = %s", aa.z(ATO.her()), aa.z(ATP.her()));
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "something wrong when dumping", new Object[0]);
        }
        Log.i(TAG, "memory dump end, cost = %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(201063);
    }

    private void m(JSONObject jSONObject, String str) {
        AppMethodBeat.i(201064);
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray.length() <= 0) {
            Log.i(TAG, "report nothing");
            AppMethodBeat.o(201064);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("mmap".equalsIgnoreCase(str) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        arrayList.add(MMApplicationContext.getProcessName());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String[] split = jSONObject2.getString("so").split(FilePathGenerator.ANDROID_DIR_SEP);
            arrayList.add(split[split.length - 1]);
            arrayList.add(jSONObject2.getString("size"));
            JSONArray jSONArray2 = jSONObject2.getJSONArray("top_stacks");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                arrayList.add(jSONObject3.getString(SharePluginInfo.ISSUE_KEY_STACK));
                arrayList.add(jSONObject3.getString("size"));
            }
        }
        while (arrayList.size() < 26) {
            arrayList.add("");
        }
        arrayList.add(String.valueOf(Debug.getNativeHeapAllocatedSize()));
        if (this.ATR != null) {
            boolean z = this.ATR.cPB || !this.ATR.AXr.isEmpty();
            arrayList.add(z ? "1" : "2");
            arrayList.add(String.valueOf(this.ATR.AXD));
            Log.i(TAG, "dumpAndReport: isForeground=%s, bgDuration=%s", Boolean.valueOf(z), Long.valueOf(this.ATR.AXD));
        }
        h hVar = h.INSTANCE;
        h.r(21217, arrayList);
        Log.d(TAG, "report: %s", Arrays.toString(arrayList.toArray()));
        AppMethodBeat.o(201064);
    }

    private void eCi() {
        AppMethodBeat.i(201065);
        try {
            JSONObject jSONObject = new JSONObject(com.tencent.mm.plugin.performance.c.a(aa.z(ATP.her()), d.UTF_8));
            m(jSONObject, "NativeHeap");
            m(jSONObject, "mmap");
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "reportKV", new Object[0]);
        } finally {
            ATP.delete();
            AppMethodBeat.o(201065);
        }
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final String eBH() {
        AppMethodBeat.i(201066);
        StringBuilder sb = new StringBuilder();
        sb.append("hook=").append(this.ATQ.eBZ()).append(",stack=").append(this.ATQ.eCb()).append(",mmap=").append(this.ATQ.eCg()).append("\t");
        String sb2 = sb.toString();
        AppMethodBeat.o(201066);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final String eBI() {
        return "MemoryHook";
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final void eCj() {
        int i2;
        AppMethodBeat.i(201067);
        Log.i(TAG, "dice action !");
        if (!BuildInfo.IS_ARM64) {
            Log.i(TAG, "not enable for 32-bit device");
            AppMethodBeat.o(201067);
            return;
        }
        com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_diagnostic_memory_hook_expt_cmd, "<cmd><diagnostic><MemoryHook enable='1' source='expt' process='" + eBM() + "' duration='24' hook='.*com\\.tencent\\.mm.*\\.so$' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>"));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey(1571, 0, 1);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 20;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 21;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            i2 = 22;
        } else {
            i2 = -1;
        }
        IDKey iDKey2 = new IDKey(1571, i2, 1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(201067);
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final double eCk() {
        AppMethodBeat.i(201068);
        double a2 = 1.0d / ((double) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_diagnostic_memory_hook_expt_rate_denominator, -1L));
        AppMethodBeat.o(201068);
        return a2;
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final long eCl() {
        AppMethodBeat.i(201069);
        long minutes = TimeUnit.DAYS.toMinutes(1);
        AppMethodBeat.o(201069);
        return minutes;
    }

    @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
    public final String Lb() {
        return "MemoryHook";
    }

    /* Return type fixed from 'com.tencent.mm.plugin.performance.diagnostic.a$a' to match base method */
    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final /* bridge */ /* synthetic */ a eBG() {
        return this.ATQ;
    }

    /* Return type fixed from 'com.tencent.wxperf.jni.a' to match base method */
    @Override // com.tencent.mm.plugin.performance.diagnostic.a
    public final /* synthetic */ MemoryHook eBF() {
        AppMethodBeat.i(201070);
        String eBZ = this.ATQ.eBZ();
        String eCa = this.ATQ.eCa();
        boolean eCb = this.ATQ.eCb();
        int eCc = this.ATQ.eCc();
        int eCd = this.ATQ.eCd();
        double eCe = this.ATQ.eCe();
        boolean eCf = this.ATQ.eCf();
        boolean eCg = this.ATQ.eCg();
        int eCh = this.ATQ.eCh();
        Log.i(TAG, "hook:%s, ignore:%s, enableStacktrace:%s, min:%d, max:%d, sampling:%f, extreme:%s, mmap:%s, stacklog:%s", eBZ, eCa, Boolean.valueOf(eCb), Integer.valueOf(eCc), Integer.valueOf(eCd), Double.valueOf(eCe), Boolean.valueOf(eCf), Boolean.valueOf(eCg), Integer.valueOf(eCh));
        if (TextUtils.isEmpty(eBZ)) {
            Log.e(TAG, "ERROR(MemoryHook): hook regex is blank");
            AppMethodBeat.o(201070);
            return null;
        }
        String[] split = eBZ.split(";");
        String[] split2 = eCa.split(";");
        MemoryHook memoryHook = MemoryHook.Sys;
        for (String str : split) {
            if (TextUtils.isEmpty(str)) {
                com.tencent.stubs.logger.Log.e("Wxperf.Memory", "thread regex is empty!!!");
            } else {
                memoryHook.Syt.add(str);
            }
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2)) {
                memoryHook.Syu.add(str2);
            }
        }
        memoryHook.Syz = eCb;
        memoryHook.Syv = eCc;
        memoryHook.Syw = eCd;
        if (memoryHook.Syy < 0.0d || memoryHook.Syy > 1.0d) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sampling should be between 0 and 1: ".concat(String.valueOf(eCe)));
            AppMethodBeat.o(201070);
            throw illegalArgumentException;
        }
        memoryHook.Syy = eCe;
        memoryHook.Syx = eCh;
        memoryHook.SyA = eCg;
        AppMethodBeat.o(201070);
        return memoryHook;
    }
}
