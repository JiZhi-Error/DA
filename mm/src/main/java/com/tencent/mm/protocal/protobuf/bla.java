package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bla extends a {
    public int KHs;
    public dqi LTV;
    public int LTW;
    public int LTX;
    public int LTY = 1;
    public int LTZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101809);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LTV == null) {
                b bVar = new b("Not all required fields were included: ChatroomId");
                AppMethodBeat.o(101809);
                throw bVar;
            }
            if (this.LTV != null) {
                aVar.ni(1, this.LTV.computeSize());
                this.LTV.writeFields(aVar);
            }
            aVar.aM(2, this.KHs);
            aVar.aM(3, this.LTW);
            aVar.aM(4, this.LTX);
            aVar.aM(5, this.LTY);
            aVar.aM(6, this.LTZ);
            AppMethodBeat.o(101809);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LTV != null ? g.a.a.a.nh(1, this.LTV.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KHs) + g.a.a.b.b.a.bu(3, this.LTW) + g.a.a.b.b.a.bu(4, this.LTX) + g.a.a.b.b.a.bu(5, this.LTY) + g.a.a.b.b.a.bu(6, this.LTZ);
            AppMethodBeat.o(101809);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LTV == null) {
                b bVar2 = new b("Not all required fields were included: ChatroomId");
                AppMethodBeat.o(101809);
                throw bVar2;
            }
            AppMethodBeat.o(101809);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bla bla = (bla) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        bla.LTV = dqi;
                    }
                    AppMethodBeat.o(101809);
                    return 0;
                case 2:
                    bla.KHs = aVar3.UbS.zi();
                    AppMethodBeat.o(101809);
                    return 0;
                case 3:
                    bla.LTW = aVar3.UbS.zi();
                    AppMethodBeat.o(101809);
                    return 0;
                case 4:
                    bla.LTX = aVar3.UbS.zi();
                    AppMethodBeat.o(101809);
                    return 0;
                case 5:
                    bla.LTY = aVar3.UbS.zi();
                    AppMethodBeat.o(101809);
                    return 0;
                case 6:
                    bla.LTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(101809);
                    return 0;
                default:
                    AppMethodBeat.o(101809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101809);
            return -1;
        }
    }
}
