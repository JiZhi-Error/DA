package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class egf extends a {
    public dqe KEP;
    public String KNW;
    public cyf MTe;
    public ccy Nge;
    public LinkedList<ehf> Ngf = new LinkedList<>();
    public LinkedList<ehf> Ngg = new LinkedList<>();
    public ccy Ngh;
    public dlp Ngi;
    public dqd Ngj;

    public egf() {
        AppMethodBeat.i(91707);
        AppMethodBeat.o(91707);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91708);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nge != null) {
                aVar.ni(1, this.Nge.computeSize());
                this.Nge.writeFields(aVar);
            }
            aVar.e(2, 8, this.Ngf);
            aVar.e(3, 8, this.Ngg);
            if (this.Ngh != null) {
                aVar.ni(4, this.Ngh.computeSize());
                this.Ngh.writeFields(aVar);
            }
            if (this.Ngi != null) {
                aVar.ni(5, this.Ngi.computeSize());
                this.Ngi.writeFields(aVar);
            }
            if (this.KNW != null) {
                aVar.e(6, this.KNW);
            }
            if (this.MTe != null) {
                aVar.ni(7, this.MTe.computeSize());
                this.MTe.writeFields(aVar);
            }
            if (this.KEP != null) {
                aVar.ni(8, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            if (this.Ngj != null) {
                aVar.ni(9, this.Ngj.computeSize());
                this.Ngj.writeFields(aVar);
            }
            AppMethodBeat.o(91708);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Nge != null ? g.a.a.a.nh(1, this.Nge.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Ngf) + g.a.a.a.c(3, 8, this.Ngg);
            if (this.Ngh != null) {
                nh += g.a.a.a.nh(4, this.Ngh.computeSize());
            }
            if (this.Ngi != null) {
                nh += g.a.a.a.nh(5, this.Ngi.computeSize());
            }
            if (this.KNW != null) {
                nh += g.a.a.b.b.a.f(6, this.KNW);
            }
            if (this.MTe != null) {
                nh += g.a.a.a.nh(7, this.MTe.computeSize());
            }
            if (this.KEP != null) {
                nh += g.a.a.a.nh(8, this.KEP.computeSize());
            }
            if (this.Ngj != null) {
                nh += g.a.a.a.nh(9, this.Ngj.computeSize());
            }
            AppMethodBeat.o(91708);
            return nh;
        } else if (i2 == 2) {
            this.Ngf.clear();
            this.Ngg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91708);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egf egf = (egf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccy.populateBuilderWithField(aVar4, ccy, a.getNextFieldNumber(aVar4))) {
                        }
                        egf.Nge = ccy;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        egf.Ngf.add(ehf);
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf2.populateBuilderWithField(aVar6, ehf2, a.getNextFieldNumber(aVar6))) {
                        }
                        egf.Ngg.add(ehf2);
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ccy ccy2 = new ccy();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ccy2.populateBuilderWithField(aVar7, ccy2, a.getNextFieldNumber(aVar7))) {
                        }
                        egf.Ngh = ccy2;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dlp dlp = new dlp();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dlp.populateBuilderWithField(aVar8, dlp, a.getNextFieldNumber(aVar8))) {
                        }
                        egf.Ngi = dlp;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 6:
                    egf.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91708);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cyf cyf = new cyf();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cyf.populateBuilderWithField(aVar9, cyf, a.getNextFieldNumber(aVar9))) {
                        }
                        egf.MTe = cyf;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqe.populateBuilderWithField(aVar10, dqe, a.getNextFieldNumber(aVar10))) {
                        }
                        egf.KEP = dqe;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dqd dqd = new dqd();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dqd.populateBuilderWithField(aVar11, dqd, a.getNextFieldNumber(aVar11))) {
                        }
                        egf.Ngj = dqd;
                    }
                    AppMethodBeat.o(91708);
                    return 0;
                default:
                    AppMethodBeat.o(91708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91708);
            return -1;
        }
    }
}
