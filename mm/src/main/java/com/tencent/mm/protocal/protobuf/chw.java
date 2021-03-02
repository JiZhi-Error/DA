package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class chw extends a {
    public ctg Mno;
    public LinkedList<chv> Mnp = new LinkedList<>();
    public cht Mnq;

    public chw() {
        AppMethodBeat.i(200212);
        AppMethodBeat.o(200212);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200213);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mno != null) {
                aVar.ni(1, this.Mno.computeSize());
                this.Mno.writeFields(aVar);
            }
            aVar.e(2, 8, this.Mnp);
            if (this.Mnq != null) {
                aVar.ni(3, this.Mnq.computeSize());
                this.Mnq.writeFields(aVar);
            }
            AppMethodBeat.o(200213);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Mno != null ? g.a.a.a.nh(1, this.Mno.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Mnp);
            if (this.Mnq != null) {
                nh += g.a.a.a.nh(3, this.Mnq.computeSize());
            }
            AppMethodBeat.o(200213);
            return nh;
        } else if (i2 == 2) {
            this.Mnp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200213);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chw chw = (chw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ctg ctg = new ctg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ctg.populateBuilderWithField(aVar4, ctg, a.getNextFieldNumber(aVar4))) {
                        }
                        chw.Mno = ctg;
                    }
                    AppMethodBeat.o(200213);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        chv chv = new chv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = chv.populateBuilderWithField(aVar5, chv, a.getNextFieldNumber(aVar5))) {
                        }
                        chw.Mnp.add(chv);
                    }
                    AppMethodBeat.o(200213);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cht cht = new cht();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cht.populateBuilderWithField(aVar6, cht, a.getNextFieldNumber(aVar6))) {
                        }
                        chw.Mnq = cht;
                    }
                    AppMethodBeat.o(200213);
                    return 0;
                default:
                    AppMethodBeat.o(200213);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200213);
            return -1;
        }
    }
}
