package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends f {
    private String mFilePath = "";
    private String nhr = "";
    private int qpr = 0;

    public d(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(123453);
        Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", this.mFilePath);
        super.aGi();
        if (!(this.oXA == null || this.oXA.getActivity() == null)) {
            this.oXA.getActivity().finish();
        }
        AppMethodBeat.o(123453);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(123454);
        Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", this.mFilePath);
        super.bCB();
        AppMethodBeat.o(123454);
    }

    public final void I(String str, String str2, int i2) {
        AppMethodBeat.i(123455);
        Log.i("MicroMsg.FilesFloatBall.ChooseMsgFilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s ", str, str2);
        this.mFilePath = str;
        this.nhr = str2;
        this.qpr = i2;
        super.G(4, b.agW(str));
        ciw().hDa = 4;
        ciw().oWx = this.qpr;
        cit();
        if (this.oWE.jkf != null) {
            this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
            this.oWE.jkf.putString("filePath", str);
            this.oWE.jkf.putString("fileExt", str2);
            this.oWE.jkf.putInt("sence", i2);
            cit();
        }
        AppMethodBeat.o(123455);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }
}
