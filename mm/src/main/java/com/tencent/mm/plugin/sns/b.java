package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class b extends IListener<fv> {
    public b() {
        AppMethodBeat.i(160630);
        this.__eventId = fv.class.getName().hashCode();
        AppMethodBeat.o(160630);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(fv fvVar) {
        AppMethodBeat.i(94885);
        fv fvVar2 = fvVar;
        if (!(fvVar2 instanceof fv)) {
            Log.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            AppMethodBeat.o(94885);
            return false;
        } else if (fvVar2.dJe.dJg == null) {
            AppMethodBeat.o(94885);
            return false;
        } else {
            SnsInfo snsInfo = new SnsInfo();
            snsInfo.convertFrom(fvVar2.dJe.dJg);
            if (snsInfo.localid <= 0) {
                Log.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                AppMethodBeat.o(94885);
                return false;
            }
            TimeLineObject timeLine = snsInfo.getTimeLine();
            fvVar2.dJf.mediaType = 0;
            fvVar2.dJf.dJo = 0;
            fvVar2.dJf.dJp = 0;
            fvVar2.dJf.dJm = new LinkedList();
            fvVar2.dJf.dJn = new LinkedList();
            if (timeLine.ContentObj != null) {
                fvVar2.dJf.mediaType = timeLine.ContentObj.LoU;
                if (timeLine.ContentObj.LoU != 1 && timeLine.ContentObj.LoU != 7 && timeLine.ContentObj.LoU != 8) {
                    fvVar2.dJf.dJm.add(timeLine.ContentObj.Url);
                } else if (timeLine.ContentObj.LoV != null) {
                    for (int i2 = 0; i2 < timeLine.ContentObj.LoV.size(); i2++) {
                        List list = fvVar2.dJf.dJm;
                        aj.faL();
                        list.add(g.s(timeLine.ContentObj.LoV.get(i2)));
                        List list2 = fvVar2.dJf.dJn;
                        aj.faL();
                        list2.add(g.t(timeLine.ContentObj.LoV.get(i2)));
                        if (i2 == 0 && timeLine.ContentObj.LoV.get(i2) != null) {
                            fvVar2.dJf.dJo = (int) timeLine.ContentObj.LoV.get(i2).MsB.Mto;
                            fvVar2.dJf.dJp = (int) timeLine.ContentObj.LoV.get(i2).MsB.Mtp;
                        }
                    }
                }
            }
            fvVar2.dJf.dJl = fvVar2.dJf.dJm.size();
            fvVar2.dJf.dJi = snsInfo.localid;
            fvVar2.dJf.dJh = snsInfo.getUserName();
            fvVar2.dJf.dJj = timeLine.ContentDesc;
            fvVar2.dJf.dJk = (long) timeLine.CreateTime;
            AppMethodBeat.o(94885);
            return true;
        }
    }
}
