package com.tencent.mm.plugin.fav.ui.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class a extends c {
    private String mFilePath = "";
    private aoe nhp = new aoe();
    private String nhr = "";
    private int qpr = 0;

    public a(com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        AppMethodBeat.i(235385);
        AppMethodBeat.o(235385);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        AppMethodBeat.i(235386);
        if (Util.isNullOrNil(this.mFilePath) || s.YS(this.mFilePath)) {
            AppMethodBeat.o(235386);
            return true;
        }
        AppMethodBeat.o(235386);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    public final void gH(String str, String str2) {
        AppMethodBeat.i(235387);
        Log.i("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", str, str2, 2);
        this.mFilePath = str;
        this.nhr = str2;
        this.qpr = 2;
        super.G(4, b.agW(str));
        this.nhp.filePath = str;
        this.nhp.LzM = s.boW(str);
        this.nhp.gCr = str2;
        this.nhp.qoX = 2;
        this.nhp.LzL = false;
        try {
            this.Abp.field_data = this.nhp.toByteArray();
        } catch (IOException e2) {
            Log.e("MicroMsg.FilesFloatBall.FavoriteFilePMultiTaskHelper", "handleMultiTaskInfoClicked", e2);
        }
        eqX();
        AppMethodBeat.o(235387);
    }
}
