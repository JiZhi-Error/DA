package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class j {
    private static volatile j hnf;
    Map<String, BaseIPCService> hng = new HashMap();

    private j() {
        AppMethodBeat.i(158752);
        AppMethodBeat.o(158752);
    }

    public static j aya() {
        AppMethodBeat.i(158753);
        if (hnf == null) {
            synchronized (j.class) {
                try {
                    if (hnf == null) {
                        hnf = new j();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158753);
                    throw th;
                }
            }
        }
        j jVar = hnf;
        AppMethodBeat.o(158753);
        return jVar;
    }

    public final BaseIPCService Fs(String str) {
        AppMethodBeat.i(158754);
        BaseIPCService baseIPCService = this.hng.get(str);
        AppMethodBeat.o(158754);
        return baseIPCService;
    }
}
