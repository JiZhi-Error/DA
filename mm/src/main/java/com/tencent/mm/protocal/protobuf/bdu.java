package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bdu extends a {
    public String LNA;
    public bds dMU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209707);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dMU != null) {
                aVar.ni(1, this.dMU.computeSize());
                this.dMU.writeFields(aVar);
            }
            if (this.LNA != null) {
                aVar.e(2, this.LNA);
            }
            AppMethodBeat.o(209707);
            return 0;
        } else if (i2 == 1) {
            int nh = this.dMU != null ? g.a.a.a.nh(1, this.dMU.computeSize()) + 0 : 0;
            if (this.LNA != null) {
                nh += g.a.a.b.b.a.f(2, this.LNA);
            }
            AppMethodBeat.o(209707);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdu bdu = (bdu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bds bds = new bds();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bds.populateBuilderWithField(aVar4, bds, a.getNextFieldNumber(aVar4))) {
                        }
                        bdu.dMU = bds;
                    }
                    AppMethodBeat.o(209707);
                    return 0;
                case 2:
                    bdu.LNA = aVar3.UbS.readString();
                    AppMethodBeat.o(209707);
                    return 0;
                default:
                    AppMethodBeat.o(209707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209707);
            return -1;
        }
    }
}
