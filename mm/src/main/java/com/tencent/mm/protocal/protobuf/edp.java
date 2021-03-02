package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class edp extends a {
    public long Id;
    public String Lrr;
    public eea NdL;
    public LinkedList<Integer> NdW = new LinkedList<>();
    public int Ndu;

    public edp() {
        AppMethodBeat.i(118447);
        AppMethodBeat.o(118447);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118448);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Id);
            if (this.Lrr != null) {
                aVar.e(2, this.Lrr);
            }
            if (this.NdL != null) {
                aVar.ni(3, this.NdL.computeSize());
                this.NdL.writeFields(aVar);
            }
            aVar.aM(4, this.Ndu);
            aVar.f(5, 2, this.NdW);
            AppMethodBeat.o(118448);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            if (this.Lrr != null) {
                r += g.a.a.b.b.a.f(2, this.Lrr);
            }
            if (this.NdL != null) {
                r += g.a.a.a.nh(3, this.NdL.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.Ndu) + g.a.a.a.d(5, 2, this.NdW);
            AppMethodBeat.o(118448);
            return bu;
        } else if (i2 == 2) {
            this.NdW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118448);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edp edp = (edp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    edp.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(118448);
                    return 0;
                case 2:
                    edp.Lrr = aVar3.UbS.readString();
                    AppMethodBeat.o(118448);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eea eea = new eea();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eea.populateBuilderWithField(aVar4, eea, a.getNextFieldNumber(aVar4))) {
                        }
                        edp.NdL = eea;
                    }
                    AppMethodBeat.o(118448);
                    return 0;
                case 4:
                    edp.Ndu = aVar3.UbS.zi();
                    AppMethodBeat.o(118448);
                    return 0;
                case 5:
                    edp.NdW = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(118448);
                    return 0;
                default:
                    AppMethodBeat.o(118448);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118448);
            return -1;
        }
    }
}
