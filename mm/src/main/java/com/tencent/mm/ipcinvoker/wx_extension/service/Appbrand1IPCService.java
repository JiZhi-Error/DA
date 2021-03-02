package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class Appbrand1IPCService extends BaseIPCService {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":appbrand1");

    static {
        AppMethodBeat.i(225232);
        AppMethodBeat.o(225232);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }
}
