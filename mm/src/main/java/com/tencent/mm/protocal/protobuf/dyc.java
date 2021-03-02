package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dyc extends dop {
    public LinkedList<Integer> MNJ = new LinkedList<>();
    public int MNK;
    public String dNI;

    public dyc() {
        AppMethodBeat.i(123650);
        AppMethodBeat.o(123650);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123651);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.e(3, 2, this.MNJ);
            aVar.aM(4, this.MNK);
            AppMethodBeat.o(123651);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(3, 2, this.MNJ) + g.a.a.b.b.a.bu(4, this.MNK);
            AppMethodBeat.o(123651);
            return c2;
        } else if (i2 == 2) {
            this.MNJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123651);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyc dyc = (dyc) objArr[1];
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
                        dyc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123651);
                    return 0;
                case 2:
                    dyc.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123651);
                    return 0;
                case 3:
                    dyc.MNJ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(123651);
                    return 0;
                case 4:
                    dyc.MNK = aVar3.UbS.zi();
                    AppMethodBeat.o(123651);
                    return 0;
                default:
                    AppMethodBeat.o(123651);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123651);
            return -1;
        }
    }
}
