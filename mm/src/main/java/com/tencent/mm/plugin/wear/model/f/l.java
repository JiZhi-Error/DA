package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ezw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private int jiX;
    private String talker;

    public l(int i2, String str) {
        this.jiX = i2;
        this.talker = str;
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearVoipControllerTask";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30134);
        switch (this.jiX) {
            case 20010:
                ezw ezw = new ezw();
                ezw.MRZ = this.talker;
                ezw.oUJ = h.aWo(this.talker);
                try {
                    a.fVQ();
                    r.a(this.jiX, ezw.toByteArray(), false);
                    AppMethodBeat.o(30134);
                    return;
                } catch (IOException e2) {
                    AppMethodBeat.o(30134);
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.fVQ();
                    r.a(this.jiX, this.talker.getBytes("utf8"), false);
                    AppMethodBeat.o(30134);
                    return;
                } catch (UnsupportedEncodingException e3) {
                    break;
                }
        }
        AppMethodBeat.o(30134);
    }
}
