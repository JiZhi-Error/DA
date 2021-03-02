package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ctc extends a {
    public ccb KQj;
    public qy KQk;
    public ctb KQl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133180);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KQj != null) {
                aVar.ni(1, this.KQj.computeSize());
                this.KQj.writeFields(aVar);
            }
            if (this.KQl != null) {
                aVar.ni(2, this.KQl.computeSize());
                this.KQl.writeFields(aVar);
            }
            if (this.KQk != null) {
                aVar.ni(3, this.KQk.computeSize());
                this.KQk.writeFields(aVar);
            }
            AppMethodBeat.o(133180);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KQj != null ? g.a.a.a.nh(1, this.KQj.computeSize()) + 0 : 0;
            if (this.KQl != null) {
                nh += g.a.a.a.nh(2, this.KQl.computeSize());
            }
            if (this.KQk != null) {
                nh += g.a.a.a.nh(3, this.KQk.computeSize());
            }
            AppMethodBeat.o(133180);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133180);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctc ctc = (ctc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccb ccb = new ccb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccb.populateBuilderWithField(aVar4, ccb, a.getNextFieldNumber(aVar4))) {
                        }
                        ctc.KQj = ccb;
                    }
                    AppMethodBeat.o(133180);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ctb ctb = new ctb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ctb.populateBuilderWithField(aVar5, ctb, a.getNextFieldNumber(aVar5))) {
                        }
                        ctc.KQl = ctb;
                    }
                    AppMethodBeat.o(133180);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        qy qyVar = new qy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = qyVar.populateBuilderWithField(aVar6, qyVar, a.getNextFieldNumber(aVar6))) {
                        }
                        ctc.KQk = qyVar;
                    }
                    AppMethodBeat.o(133180);
                    return 0;
                default:
                    AppMethodBeat.o(133180);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133180);
            return -1;
        }
    }
}
