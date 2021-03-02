package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a extends c {
    private String mFilePath = "";
    private aoe nhp = new aoe();
    private AppBrandTaskProxyUI nhq = null;
    private String nhr = "";

    public a(com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        AppMethodBeat.i(227199);
        AppMethodBeat.o(227199);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPr() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void ib(boolean z) {
        AppMethodBeat.i(227200);
        if (z) {
            Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
            b(null, true);
            this.nhq.b((AppBrandProxyUIProcessTask.ProcessResult) null);
        }
        AppMethodBeat.o(227200);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, AppBrandTaskProxyUI appBrandTaskProxyUI) {
        AppMethodBeat.i(227201);
        Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s ", str, str2);
        this.mFilePath = str;
        this.nhr = str2;
        this.nhq = appBrandTaskProxyUI;
        super.G(4, b.agW(str));
        this.nhp.LzL = false;
        this.nhp.filePath = str;
        this.nhp.gCr = str2;
        this.nhp.appId = str3;
        this.nhp.processName = str4;
        this.nhp.lwF = z;
        this.nhp.qoX = 0;
        try {
            this.Abp.field_data = this.nhp.toByteArray();
        } catch (IOException e2) {
            Log.e("MicroMsg.AppBrandFilesMultiTaskHelper", "handleMultiTaskInfoClicked", e2);
        }
        eqX();
        AppMethodBeat.o(227201);
    }

    public final void acQ(String str) {
        AppMethodBeat.i(227202);
        Log.i("MicroMsg.AppBrandFilesMultiTaskHelper", "update processName: %s", str);
        if (this.nhp != null) {
            this.nhp.processName = str;
            try {
                this.Abp.field_data = this.nhp.toByteArray();
            } catch (IOException e2) {
                Log.e("MicroMsg.AppBrandFilesMultiTaskHelper", "updateAppid", e2);
            }
        }
        eqX();
        AppMethodBeat.o(227202);
    }
}
