package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;

public final class NativeCrash {
    private static c RAD;
    private static a RAE;
    private static final Charset RAF = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);

    public interface a {
        boolean hiF();
    }

    public interface c {
        boolean onCrashDumped(int i2, String str, String str2);
    }

    private static native void nativeCustomInfo(byte[] bArr);

    private static native void nativeInit(String str, int i2, int i3, boolean z);

    private static native void nativeResetCustomInfo();

    public static c hiC() {
        return RAD;
    }

    public static c a(c cVar) {
        c cVar2 = RAD;
        RAD = cVar;
        return cVar2;
    }

    public static a hiD() {
        return RAE;
    }

    static {
        AppMethodBeat.i(40117);
        AppMethodBeat.o(40117);
    }

    public static void bpJ(String str) {
        AppMethodBeat.i(196955);
        if (!InitializationProbe.libLoaded) {
            System.loadLibrary("wechatcrash");
        }
        nativeInit(str, 1871, 2048, false);
        AppMethodBeat.o(196955);
    }

    public static void EJ(String str) {
        String str2;
        AppMethodBeat.i(40114);
        if (str == null) {
            AppMethodBeat.o(40114);
            return;
        }
        if (!str.endsWith("\n")) {
            str2 = str + "\n\u0000";
        } else {
            str2 = str + (char) 0;
        }
        nativeCustomInfo(str2.getBytes(RAF));
        AppMethodBeat.o(40114);
    }

    public static void hiE() {
        AppMethodBeat.i(40115);
        nativeResetCustomInfo();
        AppMethodBeat.o(40115);
    }

    static class b implements Runnable {
        final c RAD;
        final a RAE;
        Throwable RAG = null;
        final String RAH;
        final String RAI;
        boolean cqT = false;
        final int mStatus;

        b(boolean z, int i2, String str, String str2) {
            AppMethodBeat.i(196952);
            if (z) {
                this.RAD = null;
                this.RAE = NativeCrash.hiD();
            } else {
                this.RAD = NativeCrash.hiC();
                this.RAE = null;
            }
            this.mStatus = i2;
            this.RAH = str;
            this.RAI = str2;
            AppMethodBeat.o(196952);
        }

        /* access modifiers changed from: package-private */
        public final boolean ij() {
            AppMethodBeat.i(196953);
            if (this.RAD == null && this.RAE == null) {
                AppMethodBeat.o(196953);
                return false;
            }
            Thread thread = new Thread(this, "NativeCrash Dump Callback");
            thread.start();
            thread.join(5000);
            if (this.RAG != null) {
                Throwable th = this.RAG;
                AppMethodBeat.o(196953);
                throw th;
            }
            boolean z = this.cqT;
            AppMethodBeat.o(196953);
            return z;
        }

        public final void run() {
            AppMethodBeat.i(196954);
            try {
                if (this.RAE != null) {
                    this.cqT = this.RAE.hiF();
                    AppMethodBeat.o(196954);
                } else if (this.RAD != null) {
                    this.cqT = this.RAD.onCrashDumped(this.mStatus, this.RAH, this.RAI);
                    AppMethodBeat.o(196954);
                } else {
                    this.cqT = false;
                    AppMethodBeat.o(196954);
                }
            } catch (Throwable th) {
                this.RAG = th;
                AppMethodBeat.o(196954);
            }
        }
    }

    @Keep
    private static boolean onCrashDumped(int i2, String str, String str2) {
        AppMethodBeat.i(196956);
        boolean ij = new b(false, i2, str, str2).ij();
        AppMethodBeat.o(196956);
        return ij;
    }

    @Keep
    private static boolean onANRDumped(int i2, String str) {
        AppMethodBeat.i(196957);
        boolean ij = new b(true, i2, null, str).ij();
        AppMethodBeat.o(196957);
        return ij;
    }

    private NativeCrash() {
    }
}
