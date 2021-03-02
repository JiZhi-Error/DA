package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class a extends c {
    private String mFilePath = "";
    private aoe nhp = new aoe();
    private String nhr = "";
    private int qpr = 0;

    public a(com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        AppMethodBeat.i(237149);
        AppMethodBeat.o(237149);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    public final void I(String str, String str2, int i2) {
        AppMethodBeat.i(237150);
        Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", str, str2);
        this.mFilePath = str;
        this.nhr = str2;
        this.qpr = i2;
        super.G(4, g.aGI(str));
        this.nhp.filePath = str;
        this.nhp.LzM = s.boW(str);
        this.nhp.gCr = str2;
        this.nhp.qoX = i2;
        this.nhp.LzL = false;
        try {
            this.Abp.field_data = this.nhp.toByteArray();
        } catch (IOException e2) {
            Log.e("MicroMsg.FilesFloatBall.ChooseMsgFilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", e2);
        }
        eqX();
        AppMethodBeat.o(237150);
    }
}
