package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class axa extends a {
    public long LHD;
    public int LHE;
    public avn uBm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209553);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.uBm != null) {
                aVar.ni(1, this.uBm.computeSize());
                this.uBm.writeFields(aVar);
            }
            aVar.bb(2, this.LHD);
            aVar.aM(3, this.LHE);
            AppMethodBeat.o(209553);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.uBm != null ? g.a.a.a.nh(1, this.uBm.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LHD) + g.a.a.b.b.a.bu(3, this.LHE);
            AppMethodBeat.o(209553);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209553);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axa axa = (axa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        axa.uBm = avn;
                    }
                    AppMethodBeat.o(209553);
                    return 0;
                case 2:
                    axa.LHD = aVar3.UbS.zl();
                    AppMethodBeat.o(209553);
                    return 0;
                case 3:
                    axa.LHE = aVar3.UbS.zi();
                    AppMethodBeat.o(209553);
                    return 0;
                default:
                    AppMethodBeat.o(209553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209553);
            return -1;
        }
    }
}
