package com.tencent.mm.plugin.performance.diagnostic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.performance.diagnostic.a.AbstractC1572a;
import com.tencent.mm.plugin.performance.diagnostic.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.a;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a<HOOK extends com.tencent.wxperf.jni.a, CONFIG extends AbstractC1572a> implements com.tencent.mm.plugin.performance.a.c, c.a, ICrashReporter.ICrashReportExtraMessageGetter {
    private static String TAG = "MicroMsg.BaseHookLogic";
    private final b ASf = new b(this);

    /* access modifiers changed from: protected */
    public abstract HOOK eBF();

    public abstract CONFIG eBG();

    /* access modifiers changed from: protected */
    public abstract String eBH();

    /* access modifiers changed from: protected */
    public abstract String eBI();

    public abstract void hd(boolean z);

    public a() {
        c.ATi.a(eBI(), this);
        CrashReportFactory.addCrashReportExtraMessageGetter(this);
    }

    static {
        TAG += eBE();
    }

    public enum c {
        PUSH,
        AUTO,
        EXPT;

        public static c valueOf(String str) {
            AppMethodBeat.i(201025);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(201025);
            return cVar;
        }

        static {
            AppMethodBeat.i(201026);
            AppMethodBeat.o(201026);
        }
    }

    public static String eBE() {
        String processName = MMApplicationContext.getProcessName();
        if (MMApplicationContext.isMainProcess()) {
            return "_MM_";
        }
        if (MMApplicationContext.isToolsProcess()) {
            return "_tools_";
        }
        if (MMApplicationContext.isToolsMpProcess()) {
            return "_mp_";
        }
        if (processName.contains(":appbrand0")) {
            return "_appbrand0_";
        }
        if (processName.contains(":appbrand1")) {
            return "_appbrand1_";
        }
        if (processName.contains(":appbrand2")) {
            return "_appbrand2_";
        }
        if (processName.contains(":appbrand3")) {
            return "_appbrand3_";
        }
        if (processName.contains(":appbrand4")) {
            return "_appbrand4_";
        }
        String[] split = processName.split(":");
        if (split == null || split.length < 2) {
            return "_others_";
        }
        return "_" + split[1] + "_";
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public void eBD() {
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final void aA(Map<String, String> map) {
        String str = map.get(eBG().ASj);
        if (TextUtils.isEmpty(str) || c.PUSH.name().equalsIgnoreCase(str)) {
            b(map, c.PUSH);
        } else if (!eBG().eBO() && c.AUTO.name().equalsIgnoreCase(str)) {
            a(map, c.AUTO);
        } else if (!eBG().eBO() && c.EXPT.name().equalsIgnoreCase(str)) {
            a(map, c.EXPT);
        }
    }

    private void a(Map<String, String> map, c cVar) {
        if (eBL()) {
            b(map, cVar);
            return;
        }
        Log.e(TAG, "[%s] crash too many times, disable the hook", eBI());
        eBG().eBP();
    }

    private void b(Map<String, String> map, c cVar) {
        Log.i(TAG, "[%s] processCmd: [%s]", eBI(), map);
        boolean eBO = eBG().eBO();
        eBG().aB(map);
        boolean eBO2 = eBG().eBO();
        if (!eBO && eBO2 && eBG().eBW()) {
            com.tencent.mm.plugin.expansions.a.cMr();
            Log.i(TAG, "[%s] hook immediately", eBI());
            try {
                HookManager.Syn.hsa().a(eBF()).hrZ();
                a(cVar);
                eBK();
                this.ASf.install();
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "[%s] do hook error", eBI());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final HOOK eBJ() {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.diagnostic.a.eBJ():com.tencent.wxperf.jni.a");
    }

    private void eBK() {
        final String str = TAG + "-repeat";
        final long eBV = eBG().eBV();
        h.RTc.bqo(str);
        if (eBV < 0) {
            Log.i(TAG, "[%s] dump cycle is negative. just disable repeating dump", eBI());
            return;
        }
        h.RTc.a(new Runnable() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(201018);
                if (a.this.eBG().eBO()) {
                    a.this.hd(false);
                    h.RTc.a(this, eBV, str);
                }
                AppMethodBeat.o(201018);
            }
        }, eBV, str);
    }

    private boolean eBL() {
        if (BuildInfo.CLIENT_VERSION_INT != eBG().eBS()) {
            eBG().eBT();
        }
        boolean z = eBG().eBU() >= 3 && !BuildInfo.DEBUG && !WeChatEnvironment.hasDebugger();
        if (z) {
            Log.e(TAG, "[%s] crash too many times, disable hook", eBI());
            eBG().eBP();
        }
        return !z;
    }

    protected static String eBM() {
        if (MMApplicationContext.isMainProcess()) {
            return "mm";
        }
        if (MMApplicationContext.isAppBrandProcess()) {
            return "appbrand";
        }
        if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            return "tools";
        }
        return "";
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.c.a
    public final void eBN() {
        if (eBG().eBO()) {
            this.ASf.HH(System.currentTimeMillis());
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter
    public final String getCrashReportExtraMessage() {
        Log.e(TAG, "[%s] crash happened", eBI());
        boolean eBO = eBG().eBO();
        int eBU = eBG().eBU();
        StringBuilder append = new StringBuilder(eBI()).append(":");
        append.append("\nenable=").append(eBO);
        if (eBO) {
            try {
                hd(true);
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "error onCrash", new Object[0]);
            }
            eBU++;
            append.append(",").append(eBH()).append(",begin:").append(com.tencent.mm.plugin.performance.c.HF(eBG().eBQ())).append(",crash times:").append(eBU);
            eBG().eBT();
        }
        if (eBO && eBU >= 3) {
            eBG().eBP();
            Log.e(TAG, "[%s] crash happens 3 times, disable hook: %s", eBI(), eBI());
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1376, 1, 1);
        }
        return append.toString();
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final String eBC() {
        return ".cmd.diagnostic." + eBI();
    }

    /* renamed from: com.tencent.mm.plugin.performance.diagnostic.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC1572a {
        protected final String ASj;
        private final String ASk;
        private final String ASl;
        private final String ASm;
        private final String ASn;
        private final String ASo;
        private final String ASp;
        private final String ASq;
        private final String ASr;
        private final String ASs;
        protected MultiProcessMMKV djK = MultiProcessMMKV.getMMKV("diagnostic_storage");

        public AbstractC1572a(a<? extends com.tencent.wxperf.jni.a, ? extends AbstractC1572a> aVar) {
            this.ASs = aVar.eBI();
            this.ASj = aVar.eBC() + ".$source";
            this.ASk = aVar.eBC() + ".$enable";
            this.ASl = aVar.eBC() + ".$duration";
            this.ASm = aVar.eBC() + ".begin";
            this.ASn = aVar.eBC() + ".$multiprocess";
            this.ASo = aVar.eBC() + ".$process";
            this.ASp = aVar.eBC() + ".clientversion";
            this.ASq = aVar.eBC() + ".crash";
            this.ASr = aVar.eBC() + ".$dumpcycle";
        }

        public void aB(Map<String, String> map) {
            Log.i(a.TAG, "convert and save config");
            this.djK.encode(this.ASk, "1".equals(map.get(this.ASk)));
            this.djK.encode(this.ASl, Util.getInt(map.get(this.ASl), 0));
            this.djK.encode(this.ASm, System.currentTimeMillis());
            this.djK.encode(this.ASn, "1".equals(map.get(this.ASn)));
            this.djK.encode(this.ASo, map.get(this.ASo));
            this.djK.encode(this.ASp, BuildInfo.CLIENT_VERSION_INT);
        }

        public final boolean eBO() {
            return this.djK.decodeBool(this.ASk, false);
        }

        public final void eBP() {
            this.djK.encode(this.ASk, false);
        }

        public final int Up(int i2) {
            return this.djK.decodeInt(this.ASl, i2);
        }

        public final void HG(long j2) {
            this.djK.encode(this.ASm, j2);
        }

        public final long eBQ() {
            return this.djK.decodeLong(this.ASm, 0);
        }

        @Deprecated
        private boolean eBR() {
            return this.djK.decodeBool(this.ASn, false);
        }

        public final String getTargetProcess() {
            return this.djK.decodeString(this.ASo, "");
        }

        public final int eBS() {
            return this.djK.decodeInt(this.ASp, -1);
        }

        public final void eBT() {
            this.djK.encode(this.ASq, 0);
        }

        public final int eBU() {
            return this.djK.decodeInt(this.ASq, 0);
        }

        public long eBV() {
            return TimeUnit.MINUTES.toMillis(this.djK.decodeLong(this.ASr, 30));
        }

        public final boolean eBW() {
            boolean eBR = eBR();
            String targetProcess = getTargetProcess();
            Log.i(a.TAG, "[%s] filterProcess: target process is %s, current process is %s", this.ASs, targetProcess, MMApplicationContext.getProcessName());
            if (targetProcess.contains("all")) {
                return true;
            }
            if (TextUtils.isEmpty(targetProcess) && eBR) {
                return true;
            }
            if ((targetProcess.contains("mm") || TextUtils.isEmpty(targetProcess)) && MMApplicationContext.isMainProcess()) {
                return true;
            }
            if (!targetProcess.contains("appbrand") || !MMApplicationContext.isAppBrandProcess()) {
                return targetProcess.contains("tools") && (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess());
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends BroadcastReceiver {
        private final String ACTION;
        private boolean ASt;
        private final a<? extends com.tencent.wxperf.jni.a, ? extends AbstractC1572a> ASu;
        private long ASv;

        public b(a<? extends com.tencent.wxperf.jni.a, ? extends AbstractC1572a> aVar) {
            AppMethodBeat.i(201020);
            this.ASu = aVar;
            this.ACTION = "com.tencent.mm.report." + aVar.eBI();
            AppMethodBeat.o(201020);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void install() {
            AppMethodBeat.i(201021);
            if (this.ASt) {
                AppMethodBeat.o(201021);
            } else {
                MMApplicationContext.getContext().registerReceiver(this, new IntentFilter(this.ACTION), ConstantsAPI.WXApp.WXAPP_BROADCAST_PERMISSION, null);
                this.ASt = true;
                Log.i(a.TAG, "register Reporter for [%s]", this.ASu.eBI());
                AppMethodBeat.o(201021);
            }
        }

        /* access modifiers changed from: package-private */
        public final void HH(long j2) {
            AppMethodBeat.i(201022);
            Log.d(a.TAG, "[%s] report token: %s", this.ASu.eBI(), Long.valueOf(j2));
            Intent intent = new Intent(this.ACTION);
            intent.putExtra("PARAM_KEY_TOKEN", j2);
            MMApplicationContext.getContext().sendBroadcast(intent, ConstantsAPI.WXApp.WXAPP_BROADCAST_PERMISSION);
            AppMethodBeat.o(201022);
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(201023);
            long longExtra = intent.getLongExtra("PARAM_KEY_TOKEN", 0);
            String action = intent.getAction();
            Log.i(a.TAG, "[%s] received token [%s], action [%s]", this.ASu.eBI(), Long.valueOf(longExtra), action);
            if (longExtra == 0) {
                Log.e(a.TAG, "[%s] ERR: report token should not be 0", this.ASu.eBI());
                AppMethodBeat.o(201023);
            } else if (longExtra <= this.ASv) {
                Log.i(a.TAG, "[%s] already reported, xfer to next process, token [%s]", this.ASu.eBI(), Long.valueOf(longExtra));
                AppMethodBeat.o(201023);
            } else {
                this.ASv = longExtra;
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.performance.diagnostic.a.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(201019);
                        Log.d(a.TAG, "[%s] report async", b.this.ASu.eBI());
                        b.this.ASu.hd(false);
                        Log.d(a.TAG, "[%s] report done.", b.this.ASu.eBI());
                        AppMethodBeat.o(201019);
                    }
                }, "HookReporter");
                AppMethodBeat.o(201023);
            }
        }
    }
}
