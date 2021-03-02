package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.bj.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.List;

public final class j implements h.a, a {
    private List<a.AbstractC2017a> peZ = new ArrayList();

    public j() {
        AppMethodBeat.i(22360);
        AppMethodBeat.o(22360);
    }

    @Override // com.tencent.mm.pluginsdk.h.a
    public final void XA(String str) {
        AppMethodBeat.i(22361);
        Log.i("MicroMsg.DeleteContactService", "delete contact %s", str);
        ((l) g.af(l.class)).eis().b(new d(str));
        ((l) g.af(l.class)).eis().a(4, this);
        AppMethodBeat.o(22361);
    }

    @Override // com.tencent.mm.pluginsdk.h.a
    public final void a(a.AbstractC2017a aVar) {
        AppMethodBeat.i(22362);
        this.peZ.add(aVar);
        AppMethodBeat.o(22362);
    }

    @Override // com.tencent.mm.pluginsdk.h.a
    public final void b(a.AbstractC2017a aVar) {
        AppMethodBeat.i(22363);
        this.peZ.remove(aVar);
        AppMethodBeat.o(22363);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h.a
    public final void a(int i2, cxl cxl, k.b bVar) {
        AppMethodBeat.i(231634);
        try {
            Log.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", Integer.valueOf(i2), cxl.Title, cxl.iAc);
            if (bVar.getCmdId() == 4) {
                String a2 = z.a(((afh) new afh().parseFrom(bVar.getBuffer())).Lqk);
                Log.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", a2, Integer.valueOf(i2));
                as Kn = ((l) g.af(l.class)).aSN().Kn(a2);
                if (i2 == 0) {
                    ab.IV(a2);
                    bp.a(a2, (bp.a) null);
                    ((l) g.af(l.class)).aST().bjW(a2);
                    c.f(0, a2);
                    c.f(0, Kn.field_encryptUsername);
                } else {
                    Kn.aqQ();
                    ((l) g.af(l.class)).aSN().c(a2, Kn);
                }
                for (a.AbstractC2017a aVar : this.peZ) {
                    aVar.a(a2, i2, cxl);
                }
            }
            AppMethodBeat.o(231634);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.DeleteContactService", e2, "BaseProtoBuf parseFrom error!", new Object[0]);
            AppMethodBeat.o(231634);
        }
    }
}
