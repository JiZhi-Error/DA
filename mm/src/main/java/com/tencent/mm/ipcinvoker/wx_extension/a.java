package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof d;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(146403);
        d dVar = (d) obj;
        c.a(dVar.iLK.iLR, parcel);
        if (MMApplicationContext.isMMProcess()) {
            c.a(dVar.iLL.iLR, parcel);
        } else {
            parcel.writeString(dVar.iLL.iLR.getClass().getName());
        }
        parcel.writeString(dVar.getUri());
        parcel.writeInt(dVar.getType());
        parcel.writeInt(dVar.iLK.cmdId);
        parcel.writeInt(dVar.iLL.cmdId);
        parcel.writeInt(dVar.getTimeOut());
        AppMethodBeat.o(146403);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        AppMethodBeat.i(146404);
        d.a aVar = new d.a();
        aVar.iLN = (com.tencent.mm.bw.a) c.a(c.class.getName(), parcel);
        if (MMApplicationContext.isMMProcess()) {
            try {
                aVar.iLO = (com.tencent.mm.bw.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e2) {
                Log.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", e2);
                aVar.iLO = new com.tencent.mm.bw.a();
            }
        } else {
            com.tencent.mm.bw.a aVar2 = (com.tencent.mm.bw.a) c.a(c.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bw.a();
            }
            aVar.iLO = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.funcId = parcel.readInt();
        aVar.iLP = parcel.readInt();
        aVar.respCmdId = parcel.readInt();
        aVar.timeout = parcel.readInt();
        d aXF = aVar.aXF();
        AppMethodBeat.o(146404);
        return aXF;
    }
}
