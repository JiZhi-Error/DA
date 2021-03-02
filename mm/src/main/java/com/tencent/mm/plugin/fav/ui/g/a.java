package com.tencent.mm.plugin.fav.ui.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a extends f {
    private String mFilePath = "";
    private String nhr = "";
    private int qpr = 0;

    public a(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        AppMethodBeat.i(107289);
        if (Util.isNullOrNil(this.mFilePath) || s.YS(this.mFilePath)) {
            AppMethodBeat.o(107289);
            return true;
        }
        AppMethodBeat.o(107289);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(107290);
        Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", this.mFilePath);
        super.aGi();
        if (!(this.oXA == null || this.oXA.getActivity() == null)) {
            this.oXA.getActivity().finish();
        }
        AppMethodBeat.o(107290);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(107291);
        Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", this.mFilePath);
        super.bCB();
        AppMethodBeat.o(107291);
    }

    public final void gH(String str, String str2) {
        AppMethodBeat.i(107292);
        Log.i("MicroMsg.FilesFloatBall.FavoriteFilePFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", str, str2, 2);
        this.mFilePath = str;
        this.nhr = str2;
        this.qpr = 2;
        super.G(4, b.agW(str));
        if (this.oWE.jkf != null) {
            this.oWE.jkf.putString("filePath", str);
            this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
            this.oWE.jkf.putString("fileExt", str2);
            this.oWE.jkf.putInt("sence", 2);
            cit();
        }
        AppMethodBeat.o(107292);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }
}
