package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eag extends a {
    public dqi MZA;
    public int MZz;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125797);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MZz);
            if (this.MZA != null) {
                aVar.ni(2, this.MZA.computeSize());
                this.MZA.writeFields(aVar);
            }
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(125797);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MZz) + 0;
            if (this.MZA != null) {
                bu += g.a.a.a.nh(2, this.MZA.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(125797);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125797);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eag eag = (eag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eag.MZz = aVar3.UbS.zi();
                    AppMethodBeat.o(125797);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        eag.MZA = dqi;
                    }
                    AppMethodBeat.o(125797);
                    return 0;
                case 3:
                    eag.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125797);
                    return 0;
                default:
                    AppMethodBeat.o(125797);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125797);
            return -1;
        }
    }
}
