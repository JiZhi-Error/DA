package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j extends IListener<ju> {
    public j() {
        AppMethodBeat.i(161645);
        this.__eventId = ju.class.getName().hashCode();
        AppMethodBeat.o(161645);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ju juVar) {
        boolean z = false;
        AppMethodBeat.i(103769);
        ju juVar2 = juVar;
        if (juVar2 == null) {
            Log.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            AppMethodBeat.o(103769);
            return false;
        }
        f fVar = f.INSTANCE;
        boolean fg = f.fg(MMApplicationContext.getContext());
        f fVar2 = f.INSTANCE;
        boolean cSX = f.cSX();
        if (!fg) {
            juVar2.dOI.dOK = 10001;
            juVar2.dOI.dOL = "No front camera";
            b.bq(10001, "No front camera");
        } else if (!cSX) {
            juVar2.dOI.dOK = 10002;
            juVar2.dOI.dOL = "No necessary model found";
            b.bq(10002, "No necessary model found");
        } else {
            f fVar3 = f.INSTANCE;
            if (!f.cSW()) {
                juVar2.dOI.dOK = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
                juVar2.dOI.dOL = "Not support pad";
                b.bq(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "Not support pad");
            } else {
                juVar2.dOI.dOL = "ok";
                b.bq(0, "ok");
            }
        }
        juVar2.dOI.dOM = 1;
        ju.a aVar = juVar2.dOI;
        if (fg && cSX) {
            z = true;
        }
        aVar.dOJ = z;
        AppMethodBeat.o(103769);
        return true;
    }
}
