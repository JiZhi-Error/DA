package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cua extends dop {
    public int Lqj;
    public String Mzp;
    public int Mzq;
    public LinkedList<String> Mzr = new LinkedList<>();

    public cua() {
        AppMethodBeat.i(82457);
        AppMethodBeat.o(82457);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82458);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Mzp != null) {
                aVar.e(2, this.Mzp);
            }
            aVar.aM(3, this.Mzq);
            aVar.e(4, 1, this.Mzr);
            aVar.aM(5, this.Lqj);
            AppMethodBeat.o(82458);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Mzp != null) {
                nh += g.a.a.b.b.a.f(2, this.Mzp);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Mzq) + g.a.a.a.c(4, 1, this.Mzr) + g.a.a.b.b.a.bu(5, this.Lqj);
            AppMethodBeat.o(82458);
            return bu;
        } else if (i2 == 2) {
            this.Mzr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82458);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cua cua = (cua) objArr[1];
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
                        cua.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82458);
                    return 0;
                case 2:
                    cua.Mzp = aVar3.UbS.readString();
                    AppMethodBeat.o(82458);
                    return 0;
                case 3:
                    cua.Mzq = aVar3.UbS.zi();
                    AppMethodBeat.o(82458);
                    return 0;
                case 4:
                    cua.Mzr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82458);
                    return 0;
                case 5:
                    cua.Lqj = aVar3.UbS.zi();
                    AppMethodBeat.o(82458);
                    return 0;
                default:
                    AppMethodBeat.o(82458);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82458);
            return -1;
        }
    }
}
