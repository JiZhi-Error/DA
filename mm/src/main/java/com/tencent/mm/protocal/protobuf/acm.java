package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acm extends a {
    public dlh LmZ;
    public LinkedList<jn> Lna = new LinkedList<>();
    public boolean Lnb;
    public dlh Lnc;

    public acm() {
        AppMethodBeat.i(201286);
        AppMethodBeat.o(201286);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201287);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LmZ != null) {
                aVar.ni(1, this.LmZ.computeSize());
                this.LmZ.writeFields(aVar);
            }
            aVar.e(2, 8, this.Lna);
            aVar.cc(3, this.Lnb);
            if (this.Lnc != null) {
                aVar.ni(4, this.Lnc.computeSize());
                this.Lnc.writeFields(aVar);
            }
            AppMethodBeat.o(201287);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LmZ != null ? g.a.a.a.nh(1, this.LmZ.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Lna) + g.a.a.b.b.a.fS(3) + 1;
            if (this.Lnc != null) {
                nh += g.a.a.a.nh(4, this.Lnc.computeSize());
            }
            AppMethodBeat.o(201287);
            return nh;
        } else if (i2 == 2) {
            this.Lna.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201287);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acm acm = (acm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlh dlh = new dlh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlh.populateBuilderWithField(aVar4, dlh, a.getNextFieldNumber(aVar4))) {
                        }
                        acm.LmZ = dlh;
                    }
                    AppMethodBeat.o(201287);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jn jnVar = new jn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jnVar.populateBuilderWithField(aVar5, jnVar, a.getNextFieldNumber(aVar5))) {
                        }
                        acm.Lna.add(jnVar);
                    }
                    AppMethodBeat.o(201287);
                    return 0;
                case 3:
                    acm.Lnb = aVar3.UbS.yZ();
                    AppMethodBeat.o(201287);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dlh dlh2 = new dlh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dlh2.populateBuilderWithField(aVar6, dlh2, a.getNextFieldNumber(aVar6))) {
                        }
                        acm.Lnc = dlh2;
                    }
                    AppMethodBeat.o(201287);
                    return 0;
                default:
                    AppMethodBeat.o(201287);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201287);
            return -1;
        }
    }
}
