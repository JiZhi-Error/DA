package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ov extends a {
    public String KQV;
    public int KTf;
    public LinkedList<ou> KVw = new LinkedList<>();
    public pf KVx;

    public ov() {
        AppMethodBeat.i(124435);
        AppMethodBeat.o(124435);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124436);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KVw);
            aVar.aM(3, this.KTf);
            if (this.KQV != null) {
                aVar.e(4, this.KQV);
            }
            if (this.KVx != null) {
                aVar.ni(5, this.KVx.computeSize());
                this.KVx.writeFields(aVar);
            }
            AppMethodBeat.o(124436);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KVw) + 0 + g.a.a.b.b.a.bu(3, this.KTf);
            if (this.KQV != null) {
                c2 += g.a.a.b.b.a.f(4, this.KQV);
            }
            if (this.KVx != null) {
                c2 += g.a.a.a.nh(5, this.KVx.computeSize());
            }
            AppMethodBeat.o(124436);
            return c2;
        } else if (i2 == 2) {
            this.KVw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124436);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ov ovVar = (ov) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ou ouVar = new ou();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ouVar.populateBuilderWithField(aVar4, ouVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ovVar.KVw.add(ouVar);
                    }
                    AppMethodBeat.o(124436);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(124436);
                    return -1;
                case 3:
                    ovVar.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(124436);
                    return 0;
                case 4:
                    ovVar.KQV = aVar3.UbS.readString();
                    AppMethodBeat.o(124436);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        pf pfVar = new pf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = pfVar.populateBuilderWithField(aVar5, pfVar, a.getNextFieldNumber(aVar5))) {
                        }
                        ovVar.KVx = pfVar;
                    }
                    AppMethodBeat.o(124436);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124436);
            return -1;
        }
    }
}
