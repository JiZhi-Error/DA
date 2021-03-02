package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class i extends IListener<yq> {
    public i() {
        AppMethodBeat.i(161393);
        this.__eventId = yq.class.getName().hashCode();
        AppMethodBeat.o(161393);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(yq yqVar) {
        AppMethodBeat.i(26373);
        List<cyb> list = yqVar.eeU.eeV;
        if (list == null || list.size() <= 0) {
            Log.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
            AppMethodBeat.o(26373);
        } else {
            byte[] a2 = z.a(list.get(0).KIA);
            if (a2 == null || a2.length == 0) {
                AppMethodBeat.o(26373);
            } else {
                String str = new String(a2);
                Log.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:".concat(String.valueOf(str)));
                h.ehG().aDM(str);
                AppMethodBeat.o(26373);
            }
        }
        return false;
    }
}
