package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bhx extends a {
    public dbj LSi;
    public LinkedList<dbj> LSj = new LinkedList<>();

    public bhx() {
        AppMethodBeat.i(123570);
        AppMethodBeat.o(123570);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123571);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LSi != null) {
                aVar.ni(1, this.LSi.computeSize());
                this.LSi.writeFields(aVar);
            }
            aVar.e(2, 8, this.LSj);
            AppMethodBeat.o(123571);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LSi != null ? g.a.a.a.nh(1, this.LSi.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LSj);
            AppMethodBeat.o(123571);
            return nh;
        } else if (i2 == 2) {
            this.LSj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123571);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhx bhx = (bhx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbj dbj = new dbj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbj.populateBuilderWithField(aVar4, dbj, a.getNextFieldNumber(aVar4))) {
                        }
                        bhx.LSi = dbj;
                    }
                    AppMethodBeat.o(123571);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dbj dbj2 = new dbj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dbj2.populateBuilderWithField(aVar5, dbj2, a.getNextFieldNumber(aVar5))) {
                        }
                        bhx.LSj.add(dbj2);
                    }
                    AppMethodBeat.o(123571);
                    return 0;
                default:
                    AppMethodBeat.o(123571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123571);
            return -1;
        }
    }
}
