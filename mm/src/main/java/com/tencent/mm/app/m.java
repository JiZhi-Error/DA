package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class m implements Log.Logger {
    /* synthetic */ m(byte b2) {
        this();
    }

    static final class a {
        static final m dle = new m((byte) 0);

        static {
            AppMethodBeat.i(123465);
            AppMethodBeat.o(123465);
        }
    }

    public static m Wp() {
        return a.dle;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.stubs.logger.Log.Logger
    public final void println(int i2, String str, String str2) {
        AppMethodBeat.i(123466);
        switch (i2) {
            case 2:
                com.tencent.mm.sdk.platformtools.Log.v(str, str2);
                AppMethodBeat.o(123466);
                return;
            case 3:
                com.tencent.mm.sdk.platformtools.Log.d(str, str2);
                AppMethodBeat.o(123466);
                return;
            case 4:
                com.tencent.mm.sdk.platformtools.Log.i(str, str2);
                AppMethodBeat.o(123466);
                return;
            case 5:
                com.tencent.mm.sdk.platformtools.Log.w(str, str2);
                AppMethodBeat.o(123466);
                return;
            case 6:
                com.tencent.mm.sdk.platformtools.Log.e(str, str2);
                break;
        }
        AppMethodBeat.o(123466);
    }

    @Override // com.tencent.stubs.logger.Log.Logger
    public final boolean isLoggable(String str, int i2) {
        return true;
    }

    private m() {
    }
}
