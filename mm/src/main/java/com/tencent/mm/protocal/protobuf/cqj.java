package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cqj extends dop {
    public String MvX;
    public int MvY;
    public int MvZ;
    public int Mwa;
    public String dNI;
    public int eaQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(74664);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.MvX != null) {
                aVar.e(3, this.MvX);
            }
            aVar.aM(4, this.MvY);
            aVar.aM(5, this.MvZ);
            aVar.aM(6, this.Mwa);
            aVar.aM(7, this.eaQ);
            AppMethodBeat.o(74664);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.MvX != null) {
                nh += g.a.a.b.b.a.f(3, this.MvX);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MvY) + g.a.a.b.b.a.bu(5, this.MvZ) + g.a.a.b.b.a.bu(6, this.Mwa) + g.a.a.b.b.a.bu(7, this.eaQ);
            AppMethodBeat.o(74664);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(74664);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cqj cqj = (cqj) objArr[1];
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
                        cqj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(74664);
                    return 0;
                case 2:
                    cqj.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(74664);
                    return 0;
                case 3:
                    cqj.MvX = aVar3.UbS.readString();
                    AppMethodBeat.o(74664);
                    return 0;
                case 4:
                    cqj.MvY = aVar3.UbS.zi();
                    AppMethodBeat.o(74664);
                    return 0;
                case 5:
                    cqj.MvZ = aVar3.UbS.zi();
                    AppMethodBeat.o(74664);
                    return 0;
                case 6:
                    cqj.Mwa = aVar3.UbS.zi();
                    AppMethodBeat.o(74664);
                    return 0;
                case 7:
                    cqj.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(74664);
                    return 0;
                default:
                    AppMethodBeat.o(74664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(74664);
            return -1;
        }
    }
}
