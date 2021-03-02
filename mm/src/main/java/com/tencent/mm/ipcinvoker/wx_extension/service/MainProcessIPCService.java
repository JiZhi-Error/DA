package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MainProcessIPCService extends BaseIPCService {
    public static final String dkO = MMApplicationContext.getPackageName();

    static {
        AppMethodBeat.i(225237);
        AppMethodBeat.o(225237);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }
}
