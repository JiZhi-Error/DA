package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import org.xwalk.core.XWalkEnvironment;

public final class b extends m {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String ata(int i2) {
        AppMethodBeat.i(157173);
        String dA = dA(i2, "excelreader.apk");
        AppMethodBeat.o(157173);
        return dA;
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvg() {
        return "com.tencent.xweb.xfiles.excel.ExcelReader";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final String hvh() {
        return "com.tencent.xweb.xfiles.excel.ExcelReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.a.m
    public final int atb(int i2) {
        if (i2 == 1) {
            return TbsListener.ErrorCode.TPATCH_FAIL;
        }
        return 100;
    }
}
