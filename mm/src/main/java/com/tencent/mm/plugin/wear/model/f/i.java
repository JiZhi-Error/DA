package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private boolean Iy = true;
    private ArrayList<Integer> IyI;

    public i() {
    }

    public i(ArrayList<Integer> arrayList) {
        this.IyI = arrayList;
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearCancelNotificationTask";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30129);
        Log.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", this.IyI);
        ezc ezc = new ezc();
        if (this.IyI != null) {
            ezc.NvD.addAll(this.IyI);
        }
        ezc.NvE = this.Iy;
        try {
            a.fVQ();
            r.a(20004, ezc.toByteArray(), false);
            AppMethodBeat.o(30129);
        } catch (IOException e2) {
            AppMethodBeat.o(30129);
        }
    }
}
