package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cce extends a {
    public int Mia;
    public cch Mib;
    public ccg Mic;
    public ccf Mid;
    public ccd Mie;
    public cci Mif;
    public ccj Mig;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32324);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mia);
            if (this.Mib != null) {
                aVar.ni(2, this.Mib.computeSize());
                this.Mib.writeFields(aVar);
            }
            if (this.Mic != null) {
                aVar.ni(3, this.Mic.computeSize());
                this.Mic.writeFields(aVar);
            }
            if (this.Mid != null) {
                aVar.ni(4, this.Mid.computeSize());
                this.Mid.writeFields(aVar);
            }
            if (this.Mie != null) {
                aVar.ni(5, this.Mie.computeSize());
                this.Mie.writeFields(aVar);
            }
            if (this.Mif != null) {
                aVar.ni(6, this.Mif.computeSize());
                this.Mif.writeFields(aVar);
            }
            if (this.Mig != null) {
                aVar.ni(7, this.Mig.computeSize());
                this.Mig.writeFields(aVar);
            }
            AppMethodBeat.o(32324);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mia) + 0;
            if (this.Mib != null) {
                bu += g.a.a.a.nh(2, this.Mib.computeSize());
            }
            if (this.Mic != null) {
                bu += g.a.a.a.nh(3, this.Mic.computeSize());
            }
            if (this.Mid != null) {
                bu += g.a.a.a.nh(4, this.Mid.computeSize());
            }
            if (this.Mie != null) {
                bu += g.a.a.a.nh(5, this.Mie.computeSize());
            }
            if (this.Mif != null) {
                bu += g.a.a.a.nh(6, this.Mif.computeSize());
            }
            if (this.Mig != null) {
                bu += g.a.a.a.nh(7, this.Mig.computeSize());
            }
            AppMethodBeat.o(32324);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32324);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cce cce = (cce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cce.Mia = aVar3.UbS.zi();
                    AppMethodBeat.o(32324);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cch cch = new cch();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cch.populateBuilderWithField(aVar4, cch, a.getNextFieldNumber(aVar4))) {
                        }
                        cce.Mib = cch;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccg ccg = new ccg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccg.populateBuilderWithField(aVar5, ccg, a.getNextFieldNumber(aVar5))) {
                        }
                        cce.Mic = ccg;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ccf ccf = new ccf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ccf.populateBuilderWithField(aVar6, ccf, a.getNextFieldNumber(aVar6))) {
                        }
                        cce.Mid = ccf;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ccd ccd = new ccd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ccd.populateBuilderWithField(aVar7, ccd, a.getNextFieldNumber(aVar7))) {
                        }
                        cce.Mie = ccd;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cci cci = new cci();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cci.populateBuilderWithField(aVar8, cci, a.getNextFieldNumber(aVar8))) {
                        }
                        cce.Mif = cci;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ccj ccj = new ccj();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ccj.populateBuilderWithField(aVar9, ccj, a.getNextFieldNumber(aVar9))) {
                        }
                        cce.Mig = ccj;
                    }
                    AppMethodBeat.o(32324);
                    return 0;
                default:
                    AppMethodBeat.o(32324);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32324);
            return -1;
        }
    }
}
