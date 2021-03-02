package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjc extends a {
    public cjd Mot;
    public ciz Mou;
    public cja Mov;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196383);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mot != null) {
                aVar.ni(1, this.Mot.computeSize());
                this.Mot.writeFields(aVar);
            }
            if (this.Mou != null) {
                aVar.ni(2, this.Mou.computeSize());
                this.Mou.writeFields(aVar);
            }
            if (this.Mov != null) {
                aVar.ni(3, this.Mov.computeSize());
                this.Mov.writeFields(aVar);
            }
            AppMethodBeat.o(196383);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mot != null ? g.a.a.a.nh(1, this.Mot.computeSize()) + 0 : 0;
            if (this.Mou != null) {
                nh += g.a.a.a.nh(2, this.Mou.computeSize());
            }
            if (this.Mov != null) {
                nh += g.a.a.a.nh(3, this.Mov.computeSize());
            }
            AppMethodBeat.o(196383);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196383);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjc cjc = (cjc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjd cjd = new cjd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjd.populateBuilderWithField(aVar4, cjd, a.getNextFieldNumber(aVar4))) {
                        }
                        cjc.Mot = cjd;
                    }
                    AppMethodBeat.o(196383);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ciz ciz = new ciz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ciz.populateBuilderWithField(aVar5, ciz, a.getNextFieldNumber(aVar5))) {
                        }
                        cjc.Mou = ciz;
                    }
                    AppMethodBeat.o(196383);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cja cja = new cja();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cja.populateBuilderWithField(aVar6, cja, a.getNextFieldNumber(aVar6))) {
                        }
                        cjc.Mov = cja;
                    }
                    AppMethodBeat.o(196383);
                    return 0;
                default:
                    AppMethodBeat.o(196383);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196383);
            return -1;
        }
    }
}
