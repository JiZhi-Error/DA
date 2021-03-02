package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum n {
    ;
    
    private static final a leP = new a((byte) 0);
    private static final a leQ = new a((byte) 0);

    static {
        AppMethodBeat.i(147003);
        AppMethodBeat.o(147003);
    }

    public static n valueOf(String str) {
        AppMethodBeat.i(146998);
        n nVar = (n) Enum.valueOf(n.class, str);
        AppMethodBeat.o(146998);
        return nVar;
    }

    public static void bw(String str, int i2) {
        AppMethodBeat.i(146999);
        leP.put(str, i2);
        AppMethodBeat.o(146999);
    }

    public static int Xg(String str) {
        int i2;
        AppMethodBeat.i(147000);
        int Xi = leP.Xi(str);
        if (Xi <= 0) {
            WxaAttributes wxaAttributes = null;
            try {
                ab.bAu();
                wxaAttributes = ab.e(str, "dynamicInfo");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", e2, "queryWithAppId(%s)", str);
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (wxaAttributes == null) {
                i2 = -1;
            } else {
                i2 = wxaAttributes.bAo().lgD.cza;
            }
            objArr[1] = Integer.valueOf(i2);
            Log.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", objArr);
            if (wxaAttributes != null) {
                Xi = wxaAttributes.bAo().lgD.cza;
            } else {
                Xi = 5;
            }
            bw(str, Xi);
        }
        int i3 = Xi * 1048576;
        AppMethodBeat.o(147000);
        return i3;
    }

    public static void bx(String str, int i2) {
        AppMethodBeat.i(147001);
        leQ.put(str, i2);
        AppMethodBeat.o(147001);
    }

    public static int Xh(String str) {
        int i2;
        AppMethodBeat.i(147002);
        int Xi = leQ.Xi(str);
        if (Xi <= 0) {
            WxaAttributes wxaAttributes = null;
            try {
                ab.bAu();
                wxaAttributes = ab.e(str, "dynamicInfo");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", e2, "queryWithAppId(%s)", str);
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (wxaAttributes == null) {
                i2 = -1;
            } else {
                i2 = wxaAttributes.bAo().lgD.lgF;
            }
            objArr[1] = Integer.valueOf(i2);
            Log.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", objArr);
            if (wxaAttributes != null) {
                Xi = wxaAttributes.bAo().lgD.lgF;
            } else {
                Xi = 5;
            }
            bx(str, Xi);
        }
        int i3 = Xi * 1048576;
        AppMethodBeat.o(147002);
        return i3;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final SparseIntArray leS;

        private a() {
            AppMethodBeat.i(146994);
            this.leS = new SparseIntArray();
            AppMethodBeat.o(146994);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void put(String str, int i2) {
            AppMethodBeat.i(146995);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(146995);
                return;
            }
            synchronized (this.leS) {
                try {
                    this.leS.put(str.hashCode(), i2);
                } finally {
                    AppMethodBeat.o(146995);
                }
            }
        }

        public final int Xi(String str) {
            int i2 = -1;
            AppMethodBeat.i(146996);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(146996);
            } else {
                synchronized (this.leS) {
                    try {
                        i2 = this.leS.get(str.hashCode(), -1);
                    } finally {
                        AppMethodBeat.o(146996);
                    }
                }
            }
            return i2;
        }
    }
}
