package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ToolsMpProcessIPCService extends BaseIPCService {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":toolsmp");

    static {
        AppMethodBeat.i(225239);
        AppMethodBeat.o(225239);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }
}
