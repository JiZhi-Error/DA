package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ahv extends dop {
    public int Brl;
    public long Brn;
    public int BsF;
    public int BsG;
    public int LrC;
    public int LrD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127170);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.Brl);
            aVar.aM(3, this.BsF);
            aVar.aM(4, this.BsG);
            aVar.aM(5, this.LrC);
            aVar.aM(6, this.LrD);
            aVar.bb(7, this.Brn);
            AppMethodBeat.o(127170);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Brl) + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.BsG) + g.a.a.b.b.a.bu(5, this.LrC) + g.a.a.b.b.a.bu(6, this.LrD) + g.a.a.b.b.a.r(7, this.Brn);
            AppMethodBeat.o(127170);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127170);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahv ahv = (ahv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ahv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(127170);
                    return 0;
                case 2:
                    ahv.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(127170);
                    return 0;
                case 3:
                    ahv.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(127170);
                    return 0;
                case 4:
                    ahv.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(127170);
                    return 0;
                case 5:
                    ahv.LrC = aVar3.UbS.zi();
                    AppMethodBeat.o(127170);
                    return 0;
                case 6:
                    ahv.LrD = aVar3.UbS.zi();
                    AppMethodBeat.o(127170);
                    return 0;
                case 7:
                    ahv.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(127170);
                    return 0;
                default:
                    AppMethodBeat.o(127170);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127170);
            return -1;
        }
    }
}
