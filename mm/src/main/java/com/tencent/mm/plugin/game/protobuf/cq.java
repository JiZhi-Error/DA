package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cq extends a {
    public g xIz;
    public String xMA;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41804);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIz == null) {
                b bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41804);
                throw bVar;
            } else if (this.xMA == null) {
                b bVar2 = new b("Not all required fields were included: Rank");
                AppMethodBeat.o(41804);
                throw bVar2;
            } else {
                if (this.xIz != null) {
                    aVar.ni(1, this.xIz.computeSize());
                    this.xIz.writeFields(aVar);
                }
                if (this.xMA != null) {
                    aVar.e(2, this.xMA);
                }
                AppMethodBeat.o(41804);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.xIz != null ? g.a.a.a.nh(1, this.xIz.computeSize()) + 0 : 0;
            if (this.xMA != null) {
                nh += g.a.a.b.b.a.f(2, this.xMA);
            }
            AppMethodBeat.o(41804);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xIz == null) {
                b bVar3 = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41804);
                throw bVar3;
            } else if (this.xMA == null) {
                b bVar4 = new b("Not all required fields were included: Rank");
                AppMethodBeat.o(41804);
                throw bVar4;
            } else {
                AppMethodBeat.o(41804);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cq cqVar = (cq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cqVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41804);
                    return 0;
                case 2:
                    cqVar.xMA = aVar3.UbS.readString();
                    AppMethodBeat.o(41804);
                    return 0;
                default:
                    AppMethodBeat.o(41804);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41804);
            return -1;
        }
    }
}
