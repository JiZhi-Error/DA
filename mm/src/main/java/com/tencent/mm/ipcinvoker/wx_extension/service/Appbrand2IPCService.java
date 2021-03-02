package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class Appbrand2IPCService extends BaseIPCService {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":appbrand2");

    static {
        AppMethodBeat.i(225233);
        AppMethodBeat.o(225233);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }
}
