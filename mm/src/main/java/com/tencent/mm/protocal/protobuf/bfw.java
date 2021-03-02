package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfw extends a {
    public LinkedList<bfv> LPA = new LinkedList<>();
    public exf LPz;

    public bfw() {
        AppMethodBeat.i(200200);
        AppMethodBeat.o(200200);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200201);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LPz != null) {
                aVar.ni(1, this.LPz.computeSize());
                this.LPz.writeFields(aVar);
            }
            aVar.e(2, 8, this.LPA);
            AppMethodBeat.o(200201);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LPz != null ? g.a.a.a.nh(1, this.LPz.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LPA);
            AppMethodBeat.o(200201);
            return nh;
        } else if (i2 == 2) {
            this.LPA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200201);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfw bfw = (bfw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        exf exf = new exf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = exf.populateBuilderWithField(aVar4, exf, a.getNextFieldNumber(aVar4))) {
                        }
                        bfw.LPz = exf;
                    }
                    AppMethodBeat.o(200201);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bfv bfv = new bfv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfv.populateBuilderWithField(aVar5, bfv, a.getNextFieldNumber(aVar5))) {
                        }
                        bfw.LPA.add(bfv);
                    }
                    AppMethodBeat.o(200201);
                    return 0;
                default:
                    AppMethodBeat.o(200201);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200201);
            return -1;
        }
    }
}
