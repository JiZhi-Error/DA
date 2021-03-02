package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends IListener<yt> {
    public q() {
        AppMethodBeat.i(160641);
        this.__eventId = yt.class.getName().hashCode();
        AppMethodBeat.o(160641);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(yt ytVar) {
        AppMethodBeat.i(94917);
        yt ytVar2 = ytVar;
        if (!(ytVar2 instanceof yt)) {
            Log.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
            AppMethodBeat.o(94917);
            return false;
        }
        if (ytVar2.eeX.eeZ instanceof w) {
            w wVar = (w) ytVar2.eeX.eeZ;
            int i2 = wVar.DJa;
            LinkedList<eaw> linkedList = wVar.DIZ;
            ytVar2.eeY.state = i2;
            if (i2 == 2) {
                if (linkedList != null && linkedList.size() > 0) {
                    aj.faU().JM(7);
                }
                if (linkedList != null) {
                    Iterator<eaw> it = linkedList.iterator();
                    while (it.hasNext()) {
                        eaw next = it.next();
                        if (next.Nar == 7) {
                            s sVar = new s();
                            w.a(sVar, next);
                            aj.faU().a(sVar);
                        }
                    }
                }
            }
            if (i2 != 1) {
                s JL = aj.faU().JL(7);
                yt.b bVar = ytVar2.eeY;
                LinkedList linkedList2 = new LinkedList();
                if (JL.field_memberList != null) {
                    for (String str : JL.field_memberList.split(",")) {
                        linkedList2.add(str);
                    }
                }
                bVar.efa = linkedList2;
            }
        }
        AppMethodBeat.o(94917);
        return true;
    }
}
