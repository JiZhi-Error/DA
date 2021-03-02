package com.tencent.xweb.xwalk.a;

import com.huawei.easygo.sdk.constant.EasyGoCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class n extends m {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_WORD;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String ata(int i2) {
        AppMethodBeat.i(157201);
        String dA = dA(i2, "wordreader.apk");
        AppMethodBeat.o(157201);
        return dA;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvg() {
        return "com.tencent.xweb.xfiles.word.WordReader";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvh() {
        return "com.tencent.xweb.xfiles.word.WordReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final int atb(int i2) {
        if (i2 == 1) {
            return EasyGoCode.InvokedErrCode.SECURITY_EXCEPTION;
        }
        return 100;
    }
}
