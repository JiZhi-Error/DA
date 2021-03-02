package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class h extends IListener<pr> {
    public h() {
        AppMethodBeat.i(160636);
        this.__eventId = pr.class.getName().hashCode();
        AppMethodBeat.o(160636);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(pr prVar) {
        AppMethodBeat.i(94903);
        pr prVar2 = prVar;
        if (!(prVar2 instanceof pr)) {
            Log.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            AppMethodBeat.o(94903);
            return false;
        } else if (prVar2.dVH.list == null) {
            Log.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            AppMethodBeat.o(94903);
            return false;
        } else if (prVar2.dVH.dLQ) {
            Log.i("MicroMsg.PostSnsTagMemberOptionListener", "tag list is local %s", Boolean.valueOf(prVar2.dVH.dLQ));
            s JL = aj.faU().JL(prVar2.dVH.dVI);
            JL.field_tagId = prVar2.dVH.dVI;
            ArrayList<String> arrayList = new ArrayList();
            if (!Util.isNullOrNil(JL.field_memberList)) {
                arrayList.addAll(Util.stringsToList(JL.field_memberList.split(",")));
            }
            for (String str : prVar2.dVH.list) {
                arrayList.add(str);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : arrayList) {
                if (!Util.isNullOrNil(str2)) {
                    stringBuffer.append(str2 + ",");
                }
            }
            JL.field_memberList = stringBuffer.toString();
            aj.faU().a(JL);
            AppMethodBeat.o(94903);
            return true;
        } else {
            x xVar = new x(prVar2.dVH.dJY, prVar2.dVH.dVI, "", prVar2.dVH.list.size(), prVar2.dVH.list, prVar2.dVH.scene);
            Log.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + prVar2.dVH.dJY + " memberList " + prVar2.dVH.list.size() + " scene " + prVar2.dVH.scene);
            g.aAg().hqi.a(xVar, 0);
            AppMethodBeat.o(94903);
            return true;
        }
    }
}
