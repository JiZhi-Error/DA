package com.huawei.easygo.sdk.module;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EasyGoRet {
    public int code = 0;
    public Bundle result = new Bundle();

    public EasyGoRet(com.huawei.easygo.module.EasyGoRet easyGoRet) {
        AppMethodBeat.i(190214);
        if (easyGoRet != null) {
            this.code = easyGoRet.code;
            this.result = easyGoRet.result;
        }
        AppMethodBeat.o(190214);
    }

    public EasyGoRet(int i2, Bundle bundle) {
        AppMethodBeat.i(190215);
        this.code = i2;
        this.result = bundle;
        AppMethodBeat.o(190215);
    }
}
