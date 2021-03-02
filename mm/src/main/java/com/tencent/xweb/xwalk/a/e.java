package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class e extends m {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_PDF;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String ata(int i2) {
        AppMethodBeat.i(157180);
        String dA = dA(i2, "pdfreader.apk");
        AppMethodBeat.o(157180);
        return dA;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvg() {
        return "com.tencent.xweb.xfiles.pdf.PDFReader";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvh() {
        return "com.tencent.xweb.xfiles.pdf.PDFReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final int atb(int i2) {
        if (i2 == 1) {
            return 250;
        }
        return 100;
    }
}
