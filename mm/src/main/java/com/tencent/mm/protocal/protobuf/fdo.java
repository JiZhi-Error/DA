package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fdo extends dop {
    public acc KOF;
    public LinkedList<fdq> Nzk = new LinkedList<>();

    public fdo() {
        AppMethodBeat.i(225301);
        AppMethodBeat.o(225301);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225302);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.Nzk);
            if (this.KOF != null) {
                aVar.ni(3, this.KOF.computeSize());
                this.KOF.writeFields(aVar);
            }
            AppMethodBeat.o(225302);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Nzk);
            if (this.KOF != null) {
                nh += g.a.a.a.nh(3, this.KOF.computeSize());
            }
            AppMethodBeat.o(225302);
            return nh;
        } else if (i2 == 2) {
            this.Nzk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225302);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdo fdo = (fdo) objArr[1];
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
                        fdo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(225302);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdq fdq = new fdq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdq.populateBuilderWithField(aVar5, fdq, dop.getNextFieldNumber(aVar5))) {
                        }
                        fdo.Nzk.add(fdq);
                    }
                    AppMethodBeat.o(225302);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        acc acc = new acc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = acc.populateBuilderWithField(aVar6, acc, dop.getNextFieldNumber(aVar6))) {
                        }
                        fdo.KOF = acc;
                    }
                    AppMethodBeat.o(225302);
                    return 0;
                default:
                    AppMethodBeat.o(225302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225302);
            return -1;
        }
    }
}
