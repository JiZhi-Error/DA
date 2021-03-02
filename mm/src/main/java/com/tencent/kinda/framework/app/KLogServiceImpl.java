package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KLogService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KLogServiceImpl implements KLogService {
    @Override // com.tencent.kinda.gen.KLogService
    public void verbose(String str, String str2) {
        AppMethodBeat.i(18342);
        Log.v(str, str2);
        AppMethodBeat.o(18342);
    }

    @Override // com.tencent.kinda.gen.KLogService
    public void debug(String str, String str2) {
        AppMethodBeat.i(18343);
        Log.d(str, str2);
        AppMethodBeat.o(18343);
    }

    @Override // com.tencent.kinda.gen.KLogService
    public void info(String str, String str2) {
        AppMethodBeat.i(18344);
        Log.i(str, str2);
        AppMethodBeat.o(18344);
    }

    @Override // com.tencent.kinda.gen.KLogService
    public void warning(String str, String str2) {
        AppMethodBeat.i(18345);
        Log.w(str, str2);
        AppMethodBeat.o(18345);
    }

    @Override // com.tencent.kinda.gen.KLogService
    public void error(String str, String str2) {
        AppMethodBeat.i(18346);
        Log.e(str, str2);
        AppMethodBeat.o(18346);
    }
}
