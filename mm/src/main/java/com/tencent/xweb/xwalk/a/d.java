package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class d extends m {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String ata(int i2) {
        AppMethodBeat.i(219103);
        String dA = dA(i2, "officereader.apk");
        AppMethodBeat.o(219103);
        return dA;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvg() {
        return "com.tencent.xweb.xfiles.office.OfficeReader";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvh() {
        return "com.tencent.xweb.xfiles.office.OfficeReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final int atb(int i2) {
        if (i2 == 1) {
        }
        return 100;
    }
}
