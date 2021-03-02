package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class SupportProcessIPCService extends BaseIPCService {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":support");

    static {
        AppMethodBeat.i(225238);
        AppMethodBeat.o(225238);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }
}
