package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ezh;
import java.io.IOException;

public final class k extends c {
    private int code;
    private String msg;

    public k(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30133);
        ezh ezh = new ezh();
        switch (this.code) {
            case 0:
                ezh.NcY = 0;
                break;
            case 6:
                ezh.NcY = 196610;
                break;
            case 7:
                ezh.NcY = 196615;
                break;
            case 8:
                ezh.NcY = 196614;
                break;
            case 9:
                ezh.NcY = 196613;
                break;
        }
        ezh.MVg = this.msg;
        try {
            a.fVQ();
            r.a(20016, ezh.toByteArray(), true);
            AppMethodBeat.o(30133);
        } catch (IOException e2) {
            AppMethodBeat.o(30133);
        }
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
