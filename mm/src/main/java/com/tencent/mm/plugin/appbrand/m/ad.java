package com.tencent.mm.plugin.appbrand.m;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class ad {
    public static String bDt() {
        AppMethodBeat.i(47023);
        String bMK = bMK();
        s.boN(bMK);
        AppMethodBeat.o(47023);
        return bMK;
    }

    public static String bMK() {
        AppMethodBeat.i(47024);
        String str = b.aKB() + "appbrand/jscache";
        AppMethodBeat.o(47024);
        return str;
    }

    @Deprecated
    public static String bML() {
        IPCString iPCString;
        AppMethodBeat.i(47025);
        try {
            iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class);
        } catch (Exception e2) {
            Log.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", e2);
            iPCString = null;
        }
        if (iPCString == null) {
            AppMethodBeat.o(47025);
            return null;
        }
        String str = iPCString.value;
        AppMethodBeat.o(47025);
        return str;
    }

    @Deprecated
    public static String bMM() {
        AppMethodBeat.i(47026);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!absolutePath.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            absolutePath = absolutePath + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str = absolutePath + "tencent/MicroMsg/wxajscache";
        AppMethodBeat.o(47026);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<IPCVoid, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(47022);
            String str = g.aAh().cachePath;
            if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str + FilePathGenerator.ANDROID_DIR_SEP;
            }
            IPCString iPCString = new IPCString(str + "appbrand/jscache");
            AppMethodBeat.o(47022);
            return iPCString;
        }
    }
}
