package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bkx extends a {
    public String LTF;
    public we LTL;
    public String LTM;
    public boolean LTN;
    public int LTO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114024);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LTL != null) {
                aVar.ni(1, this.LTL.computeSize());
                this.LTL.writeFields(aVar);
            }
            if (this.LTF != null) {
                aVar.e(2, this.LTF);
            }
            if (this.LTM != null) {
                aVar.e(3, this.LTM);
            }
            aVar.cc(4, this.LTN);
            aVar.aM(5, this.LTO);
            AppMethodBeat.o(114024);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LTL != null ? g.a.a.a.nh(1, this.LTL.computeSize()) + 0 : 0;
            if (this.LTF != null) {
                nh += g.a.a.b.b.a.f(2, this.LTF);
            }
            if (this.LTM != null) {
                nh += g.a.a.b.b.a.f(3, this.LTM);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.LTO);
            AppMethodBeat.o(114024);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114024);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkx bkx = (bkx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        we weVar = new we();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = weVar.populateBuilderWithField(aVar4, weVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bkx.LTL = weVar;
                    }
                    AppMethodBeat.o(114024);
                    return 0;
                case 2:
                    bkx.LTF = aVar3.UbS.readString();
                    AppMethodBeat.o(114024);
                    return 0;
                case 3:
                    bkx.LTM = aVar3.UbS.readString();
                    AppMethodBeat.o(114024);
                    return 0;
                case 4:
                    bkx.LTN = aVar3.UbS.yZ();
                    AppMethodBeat.o(114024);
                    return 0;
                case 5:
                    bkx.LTO = aVar3.UbS.zi();
                    AppMethodBeat.o(114024);
                    return 0;
                default:
                    AppMethodBeat.o(114024);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114024);
            return -1;
        }
    }
}
