package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cfr extends dop {
    public String MlA;
    public LinkedList<String> MlD = new LinkedList<>();
    public LinkedList<Integer> MlE = new LinkedList<>();

    public cfr() {
        AppMethodBeat.i(124524);
        AppMethodBeat.o(124524);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124525);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MlA != null) {
                aVar.e(2, this.MlA);
            }
            aVar.e(3, 1, this.MlD);
            aVar.e(4, 2, this.MlE);
            AppMethodBeat.o(124525);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MlA != null) {
                nh += g.a.a.b.b.a.f(2, this.MlA);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.MlD) + g.a.a.a.c(4, 2, this.MlE);
            AppMethodBeat.o(124525);
            return c2;
        } else if (i2 == 2) {
            this.MlD.clear();
            this.MlE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124525);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfr cfr = (cfr) objArr[1];
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
                        cfr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124525);
                    return 0;
                case 2:
                    cfr.MlA = aVar3.UbS.readString();
                    AppMethodBeat.o(124525);
                    return 0;
                case 3:
                    cfr.MlD.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124525);
                    return 0;
                case 4:
                    cfr.MlE.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(124525);
                    return 0;
                default:
                    AppMethodBeat.o(124525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124525);
            return -1;
        }
    }
}
