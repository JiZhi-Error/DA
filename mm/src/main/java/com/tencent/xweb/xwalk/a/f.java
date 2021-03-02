package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import org.xwalk.core.XWalkEnvironment;

public final class f extends m {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_PPT;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String ata(int i2) {
        AppMethodBeat.i(157184);
        String dA = dA(i2, "pptreader.apk");
        AppMethodBeat.o(157184);
        return dA;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvg() {
        return "com.tencent.xweb.xfiles.ppt.PPTReader";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvh() {
        return "com.tencent.xweb.xfiles.ppt.PPTReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final int atb(int i2) {
        if (i2 == 1) {
            return TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02;
        }
        return 203;
    }
}
