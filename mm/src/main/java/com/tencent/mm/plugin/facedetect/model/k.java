package com.tencent.mm.plugin.facedetect.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.sdk.event.IListener;

public final class k extends IListener<sf> {
    public k() {
        AppMethodBeat.i(161646);
        this.__eventId = sf.class.getName().hashCode();
        AppMethodBeat.o(161646);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(sf sfVar) {
        AppMethodBeat.i(103770);
        sf sfVar2 = sfVar;
        if (sfVar2 == null) {
            AppMethodBeat.o(103770);
            return false;
        }
        sf.b bVar = sfVar2.dYP;
        f fVar = f.INSTANCE;
        bVar.dYN = f.a(sfVar2.dYO.context, sfVar2.dYO.extras, sfVar2.dYO.dYQ);
        if (!sfVar2.dYP.dYN) {
            sfVar2.dYP.extras = new Bundle();
            sfVar2.dYP.extras.putInt("err_code", 90001);
            sfVar2.dYP.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(103770);
        return true;
    }
}
