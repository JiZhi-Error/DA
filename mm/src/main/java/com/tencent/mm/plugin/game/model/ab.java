package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class ab extends x {
    private bs xHf;

    public ab(a aVar) {
        AppMethodBeat.i(41535);
        if (aVar == null) {
            this.xHf = new bs();
            AppMethodBeat.o(41535);
            return;
        }
        this.xHf = (bs) aVar;
        AppMethodBeat.o(41535);
    }

    public ab(byte[] bArr) {
        AppMethodBeat.i(41536);
        this.xHf = new bs();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41536);
            return;
        }
        try {
            this.xHf.parseFrom(bArr);
            AppMethodBeat.o(41536);
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", e2.getMessage());
            AppMethodBeat.o(41536);
        }
    }

    public final v dVN() {
        if (this.xHf != null) {
            return this.xHf.xLP;
        }
        return null;
    }

    public final bf dVO() {
        if (this.xHf != null) {
            return this.xHf.xLQ;
        }
        return null;
    }
}
