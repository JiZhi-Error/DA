package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class h extends a {
    public b oTm;
    public int oUv;
    public c rCa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23492);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rCa == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BasePush");
                AppMethodBeat.o(23492);
                throw bVar;
            } else if (this.oTm == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(23492);
                throw bVar2;
            } else {
                if (this.rCa != null) {
                    aVar.ni(1, this.rCa.computeSize());
                    this.rCa.writeFields(aVar);
                }
                if (this.oTm != null) {
                    aVar.c(2, this.oTm);
                }
                aVar.aM(3, this.oUv);
                AppMethodBeat.o(23492);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.rCa != null ? g.a.a.a.nh(1, this.rCa.computeSize()) + 0 : 0;
            if (this.oTm != null) {
                nh += g.a.a.b.b.a.b(2, this.oTm);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oUv);
            AppMethodBeat.o(23492);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.rCa == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: BasePush");
                AppMethodBeat.o(23492);
                throw bVar3;
            } else if (this.oTm == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(23492);
                throw bVar4;
            } else {
                AppMethodBeat.o(23492);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.rCa = cVar;
                    }
                    AppMethodBeat.o(23492);
                    return 0;
                case 2:
                    hVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(23492);
                    return 0;
                case 3:
                    hVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(23492);
                    return 0;
                default:
                    AppMethodBeat.o(23492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23492);
            return -1;
        }
    }
}
