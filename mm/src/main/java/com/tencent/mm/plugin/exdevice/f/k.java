package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class k extends i {
    public b oTm;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23493);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.oTm == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(23493);
                throw bVar;
            }
            if (this.rCb != null) {
                aVar.ni(1, this.rCb.computeSize());
                this.rCb.writeFields(aVar);
            }
            if (this.oTm != null) {
                aVar.c(2, this.oTm);
            }
            aVar.aM(3, this.oUv);
            AppMethodBeat.o(23493);
            return 0;
        } else if (i2 == 1) {
            int nh = this.rCb != null ? g.a.a.a.nh(1, this.rCb.computeSize()) + 0 : 0;
            if (this.oTm != null) {
                nh += g.a.a.b.b.a.b(2, this.oTm);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oUv);
            AppMethodBeat.o(23493);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = i.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = i.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTm == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(23493);
                throw bVar2;
            }
            AppMethodBeat.o(23493);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, i.getNextFieldNumber(aVar4))) {
                        }
                        kVar.rCb = dVar;
                    }
                    AppMethodBeat.o(23493);
                    return 0;
                case 2:
                    kVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(23493);
                    return 0;
                case 3:
                    kVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(23493);
                    return 0;
                default:
                    AppMethodBeat.o(23493);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23493);
            return -1;
        }
    }
}
