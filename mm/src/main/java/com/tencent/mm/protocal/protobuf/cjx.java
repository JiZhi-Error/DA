package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjx extends a {
    public erf Mpq;
    public bej Mpr;
    public erf Mps;
    public int dvv;
    public int height;
    public int iqg;
    public int retryCount;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169087);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mpq != null) {
                aVar.ni(1, this.Mpq.computeSize());
                this.Mpq.writeFields(aVar);
            }
            if (this.Mpr != null) {
                aVar.ni(2, this.Mpr.computeSize());
                this.Mpr.writeFields(aVar);
            }
            aVar.aM(3, this.dvv);
            aVar.aM(4, this.iqg);
            aVar.aM(5, this.width);
            aVar.aM(6, this.height);
            if (this.Mps != null) {
                aVar.ni(7, this.Mps.computeSize());
                this.Mps.writeFields(aVar);
            }
            aVar.aM(8, this.retryCount);
            AppMethodBeat.o(169087);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mpq != null ? g.a.a.a.nh(1, this.Mpq.computeSize()) + 0 : 0;
            if (this.Mpr != null) {
                nh += g.a.a.a.nh(2, this.Mpr.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.dvv) + g.a.a.b.b.a.bu(4, this.iqg) + g.a.a.b.b.a.bu(5, this.width) + g.a.a.b.b.a.bu(6, this.height);
            if (this.Mps != null) {
                bu += g.a.a.a.nh(7, this.Mps.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.retryCount);
            AppMethodBeat.o(169087);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169087);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjx cjx = (cjx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erf erf = new erf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erf.populateBuilderWithField(aVar4, erf, a.getNextFieldNumber(aVar4))) {
                        }
                        cjx.Mpq = erf;
                    }
                    AppMethodBeat.o(169087);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bej bej = new bej();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bej.populateBuilderWithField(aVar5, bej, a.getNextFieldNumber(aVar5))) {
                        }
                        cjx.Mpr = bej;
                    }
                    AppMethodBeat.o(169087);
                    return 0;
                case 3:
                    cjx.dvv = aVar3.UbS.zi();
                    AppMethodBeat.o(169087);
                    return 0;
                case 4:
                    cjx.iqg = aVar3.UbS.zi();
                    AppMethodBeat.o(169087);
                    return 0;
                case 5:
                    cjx.width = aVar3.UbS.zi();
                    AppMethodBeat.o(169087);
                    return 0;
                case 6:
                    cjx.height = aVar3.UbS.zi();
                    AppMethodBeat.o(169087);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        erf erf2 = new erf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = erf2.populateBuilderWithField(aVar6, erf2, a.getNextFieldNumber(aVar6))) {
                        }
                        cjx.Mps = erf2;
                    }
                    AppMethodBeat.o(169087);
                    return 0;
                case 8:
                    cjx.retryCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169087);
                    return 0;
                default:
                    AppMethodBeat.o(169087);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169087);
            return -1;
        }
    }
}
