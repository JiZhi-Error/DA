package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class hj extends a {
    public String KKT;
    public eoq KKU;
    public String KKV;
    public drd KKW;
    public String scope;
    public int state;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147757);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.KKT != null) {
                aVar.e(2, this.KKT);
            }
            aVar.aM(3, this.state);
            if (this.KKU != null) {
                aVar.ni(4, this.KKU.computeSize());
                this.KKU.writeFields(aVar);
            }
            if (this.KKV != null) {
                aVar.e(5, this.KKV);
            }
            if (this.KKW != null) {
                aVar.ni(6, this.KKW.computeSize());
                this.KKW.writeFields(aVar);
            }
            AppMethodBeat.o(147757);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.scope != null ? g.a.a.b.b.a.f(1, this.scope) + 0 : 0;
            if (this.KKT != null) {
                f2 += g.a.a.b.b.a.f(2, this.KKT);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.state);
            if (this.KKU != null) {
                bu += g.a.a.a.nh(4, this.KKU.computeSize());
            }
            if (this.KKV != null) {
                bu += g.a.a.b.b.a.f(5, this.KKV);
            }
            if (this.KKW != null) {
                bu += g.a.a.a.nh(6, this.KKW.computeSize());
            }
            AppMethodBeat.o(147757);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147757);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hj hjVar = (hj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hjVar.scope = aVar3.UbS.readString();
                    AppMethodBeat.o(147757);
                    return 0;
                case 2:
                    hjVar.KKT = aVar3.UbS.readString();
                    AppMethodBeat.o(147757);
                    return 0;
                case 3:
                    hjVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(147757);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eoq eoq = new eoq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eoq.populateBuilderWithField(aVar4, eoq, a.getNextFieldNumber(aVar4))) {
                        }
                        hjVar.KKU = eoq;
                    }
                    AppMethodBeat.o(147757);
                    return 0;
                case 5:
                    hjVar.KKV = aVar3.UbS.readString();
                    AppMethodBeat.o(147757);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        drd drd = new drd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = drd.populateBuilderWithField(aVar5, drd, a.getNextFieldNumber(aVar5))) {
                        }
                        hjVar.KKW = drd;
                    }
                    AppMethodBeat.o(147757);
                    return 0;
                default:
                    AppMethodBeat.o(147757);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147757);
            return -1;
        }
    }
}
