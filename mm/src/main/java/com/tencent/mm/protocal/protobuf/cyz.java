package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyz extends a {
    public chl MlQ;
    public aah MlR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117884);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MlQ != null) {
                aVar.ni(1, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            if (this.MlR != null) {
                aVar.ni(2, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            AppMethodBeat.o(117884);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MlQ != null ? g.a.a.a.nh(1, this.MlQ.computeSize()) + 0 : 0;
            if (this.MlR != null) {
                nh += g.a.a.a.nh(2, this.MlR.computeSize());
            }
            AppMethodBeat.o(117884);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117884);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyz cyz = (cyz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        cyz.MlQ = chl;
                    }
                    AppMethodBeat.o(117884);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aah.populateBuilderWithField(aVar5, aah, a.getNextFieldNumber(aVar5))) {
                        }
                        cyz.MlR = aah;
                    }
                    AppMethodBeat.o(117884);
                    return 0;
                default:
                    AppMethodBeat.o(117884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117884);
            return -1;
        }
    }
}
