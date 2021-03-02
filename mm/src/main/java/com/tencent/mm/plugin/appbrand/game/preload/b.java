package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    private static String ltO;

    public static String bDt() {
        IPCString iPCString;
        AppMethodBeat.i(45277);
        if (!Util.isNullOrNil(ltO)) {
            String str = ltO;
            AppMethodBeat.o(45277);
            return str;
        }
        try {
            iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class);
        } catch (Exception e2) {
            Log.e("MicroMsg.WAGameLoadingImgPathRetriever", "retrieve ipc ex = %s", e2);
            iPCString = null;
        }
        if (iPCString == null) {
            String aKJ = com.tencent.mm.loader.j.b.aKJ();
            if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
            }
            String str2 = aKJ + "appbrand/loadingurl";
            AppMethodBeat.o(45277);
            return str2;
        }
        String str3 = iPCString.value;
        ltO = str3;
        AppMethodBeat.o(45277);
        return str3;
    }

    static final class a implements k<IPCVoid, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(45276);
            String str = g.aAh().cachePath;
            if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str + FilePathGenerator.ANDROID_DIR_SEP;
            }
            IPCString iPCString = new IPCString(str + "appbrand/loadingurl");
            AppMethodBeat.o(45276);
            return iPCString;
        }
    }
}
