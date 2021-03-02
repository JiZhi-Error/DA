package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KindaLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaLocationManagerImpl implements KindaLocationManager {
    private static final String TAG = "KindaLocationManagerImpl";

    @Override // com.tencent.kinda.gen.KindaLocationManager
    public String getEncryptInfo(boolean z, boolean z2) {
        AppMethodBeat.i(18453);
        String str = "";
        bf fQy = k.fQy();
        if (fQy != null) {
            str = fQy.KEF;
        }
        Log.i(TAG, "getEncryptInfo return: ".concat(String.valueOf(str)));
        AppMethodBeat.o(18453);
        return str;
    }

    @Override // com.tencent.kinda.gen.KindaLocationManager
    public String getCellInfo() {
        AppMethodBeat.i(18454);
        String str = "";
        bf fQy = k.fQy();
        if (fQy != null) {
            str = fQy.KEH;
        }
        Log.i(TAG, "getCellInfo return: ".concat(String.valueOf(str)));
        AppMethodBeat.o(18454);
        return str;
    }

    @Override // com.tencent.kinda.gen.KindaLocationManager
    public String getEncryptKey() {
        AppMethodBeat.i(18455);
        String str = "";
        bf fQy = k.fQy();
        if (fQy != null) {
            str = fQy.KEG;
        }
        Log.i(TAG, "getEncryptKey return: ".concat(String.valueOf(str)));
        AppMethodBeat.o(18455);
        return str;
    }
}
