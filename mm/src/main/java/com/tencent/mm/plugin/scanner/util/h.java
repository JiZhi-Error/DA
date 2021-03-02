package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\rJ\b\u0010\"\u001a\u00020\u0007H\u0002J\u0006\u0010#\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020\u001bJ\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class h {
    public static final a CTS = new a((byte) 0);
    public boolean CNE;
    public long CTI = 5000;
    public long CTJ = 1000;
    public float CTK = 2.0f;
    public boolean CTL;
    public int CTM;
    public boolean CTN;
    public boolean CTO;
    public float CTP = 0.8f;
    public long CTQ;
    public boolean CTR;
    private MultiProcessMMKV cQe;
    public long dUy;
    public boolean isRetry;
    public long mTimeout;
    public long viC;

    static {
        AppMethodBeat.i(161061);
        AppMethodBeat.o(161061);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager$Companion;", "", "()V", "DEFAULT_MAX_TIMEOUT_IN_MS", "", "DEFAULT_MIN_TIMEOUT_IN_MS", "DEFAULT_TEXTURE_SCALED_FACTOR", "", "DEFAULT_TIMEOUT_FACTOR", "MMKV_FILE_KEY_POSTFIX", "", "MMKV_KEY_SCAN_CODE_RETRY_TIMEOUT", "RETRY_REOPEN_CAMERA", "RETRY_USING_TEXTURE", "TAG", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public h() {
        long j2;
        AppMethodBeat.i(161060);
        StringBuilder sb = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        this.cQe = MultiProcessMMKV.getSingleMMKV(sb.append(com.tencent.mm.kernel.a.ayV()).append("_scan_code_retry").toString());
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        if (multiProcessMMKV != null) {
            j2 = multiProcessMMKV.getLong("scan_code_retry_timeout", 5000);
        } else {
            j2 = 5000;
        }
        this.mTimeout = j2;
        this.CTM = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_retry_scheme, 0);
        this.CTI = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_retry_max_timeout, 5000L);
        this.CTJ = 1000;
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_retry_timeout_factor, 200);
        this.CTK = ((float) a2) / 100.0f;
        this.mTimeout = Math.max(this.CTJ, this.mTimeout);
        this.mTimeout = Math.min(this.CTI, this.mTimeout);
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_retry_texture_scale_factor, 80);
        if (a3 != 0) {
            this.CTP = ((float) a3) / 100.0f;
            this.CTP = Math.min(1.0f, this.CTP);
        }
        if (this.CTM == 1) {
            this.CTN = true;
            this.CTO = false;
        } else if (this.CTM == 2) {
            this.CTN = false;
            this.CTO = true;
        }
        Log.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", Integer.valueOf(this.CTM), Long.valueOf(this.CTI), Long.valueOf(this.CTJ), Long.valueOf(this.mTimeout), Integer.valueOf(a2), Float.valueOf(this.CTK), Integer.valueOf(a3), Float.valueOf(this.CTP), Boolean.valueOf(this.CTN), Boolean.valueOf(this.CTO));
        AppMethodBeat.o(161060);
    }

    public final void IE(long j2) {
        AppMethodBeat.i(161059);
        Log.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", Long.valueOf(j2));
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        if (multiProcessMMKV != null) {
            multiProcessMMKV.putLong("scan_code_retry_timeout", j2);
        }
        MultiProcessMMKV multiProcessMMKV2 = this.cQe;
        if (multiProcessMMKV2 != null) {
            multiProcessMMKV2.apply();
            AppMethodBeat.o(161059);
            return;
        }
        AppMethodBeat.o(161059);
    }

    public final boolean Xc(int i2) {
        if (i2 == 1) {
            return this.CTN;
        }
        if (i2 == 2) {
            return this.CTO;
        }
        return false;
    }
}
