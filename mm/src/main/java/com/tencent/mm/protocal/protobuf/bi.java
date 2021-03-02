package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bi extends a {
    public ehf KEN;
    public ehf KEO;
    public dqe KEP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91342);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KEN != null) {
                aVar.ni(1, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            if (this.KEO != null) {
                aVar.ni(2, this.KEO.computeSize());
                this.KEO.writeFields(aVar);
            }
            if (this.KEP != null) {
                aVar.ni(3, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            AppMethodBeat.o(91342);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KEN != null ? g.a.a.a.nh(1, this.KEN.computeSize()) + 0 : 0;
            if (this.KEO != null) {
                nh += g.a.a.a.nh(2, this.KEO.computeSize());
            }
            if (this.KEP != null) {
                nh += g.a.a.a.nh(3, this.KEP.computeSize());
            }
            AppMethodBeat.o(91342);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91342);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bi biVar = (bi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        biVar.KEN = ehf;
                    }
                    AppMethodBeat.o(91342);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf2.populateBuilderWithField(aVar5, ehf2, a.getNextFieldNumber(aVar5))) {
                        }
                        biVar.KEO = ehf2;
                    }
                    AppMethodBeat.o(91342);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqe.populateBuilderWithField(aVar6, dqe, a.getNextFieldNumber(aVar6))) {
                        }
                        biVar.KEP = dqe;
                    }
                    AppMethodBeat.o(91342);
                    return 0;
                default:
                    AppMethodBeat.o(91342);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91342);
            return -1;
        }
    }
}
