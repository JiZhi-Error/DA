package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class tc extends a {
    public int Lbi;
    public int Lbj;
    public int Lbk;
    public int Lbl;
    public LinkedList<dqi> Lbm = new LinkedList<>();
    public String Lbn;
    public SKBuiltinBuffer_t Lbo;
    public int Lbp;
    public int Lbq;
    public LinkedList<dqi> Lbr = new LinkedList<>();
    public LinkedList<td> Lbs = new LinkedList<>();
    public LinkedList<td> Lbt = new LinkedList<>();
    public int Lbu;
    public int Lbv;
    public int rBx;

    public tc() {
        AppMethodBeat.i(133162);
        AppMethodBeat.o(133162);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133163);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lbo == null) {
                b bVar = new b("Not all required fields were included: AuthKey");
                AppMethodBeat.o(133163);
                throw bVar;
            }
            aVar.aM(1, this.Lbi);
            aVar.aM(2, this.rBx);
            aVar.aM(3, this.Lbj);
            aVar.aM(4, this.Lbk);
            aVar.aM(5, this.Lbl);
            aVar.e(6, 8, this.Lbm);
            if (this.Lbn != null) {
                aVar.e(7, this.Lbn);
            }
            if (this.Lbo != null) {
                aVar.ni(8, this.Lbo.computeSize());
                this.Lbo.writeFields(aVar);
            }
            aVar.aM(9, this.Lbp);
            aVar.aM(10, this.Lbq);
            aVar.e(11, 8, this.Lbr);
            aVar.e(12, 8, this.Lbs);
            aVar.e(13, 8, this.Lbt);
            aVar.aM(14, this.Lbu);
            aVar.aM(15, this.Lbv);
            AppMethodBeat.o(133163);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lbi) + 0 + g.a.a.b.b.a.bu(2, this.rBx) + g.a.a.b.b.a.bu(3, this.Lbj) + g.a.a.b.b.a.bu(4, this.Lbk) + g.a.a.b.b.a.bu(5, this.Lbl) + g.a.a.a.c(6, 8, this.Lbm);
            if (this.Lbn != null) {
                bu += g.a.a.b.b.a.f(7, this.Lbn);
            }
            if (this.Lbo != null) {
                bu += g.a.a.a.nh(8, this.Lbo.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Lbp) + g.a.a.b.b.a.bu(10, this.Lbq) + g.a.a.a.c(11, 8, this.Lbr) + g.a.a.a.c(12, 8, this.Lbs) + g.a.a.a.c(13, 8, this.Lbt) + g.a.a.b.b.a.bu(14, this.Lbu) + g.a.a.b.b.a.bu(15, this.Lbv);
            AppMethodBeat.o(133163);
            return bu2;
        } else if (i2 == 2) {
            this.Lbm.clear();
            this.Lbr.clear();
            this.Lbs.clear();
            this.Lbt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lbo == null) {
                b bVar2 = new b("Not all required fields were included: AuthKey");
                AppMethodBeat.o(133163);
                throw bVar2;
            }
            AppMethodBeat.o(133163);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tc tcVar = (tc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tcVar.Lbi = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 2:
                    tcVar.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 3:
                    tcVar.Lbj = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 4:
                    tcVar.Lbk = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 5:
                    tcVar.Lbl = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        tcVar.Lbm.add(dqi);
                    }
                    AppMethodBeat.o(133163);
                    return 0;
                case 7:
                    tcVar.Lbn = aVar3.UbS.readString();
                    AppMethodBeat.o(133163);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        tcVar.Lbo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133163);
                    return 0;
                case 9:
                    tcVar.Lbp = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 10:
                    tcVar.Lbq = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, a.getNextFieldNumber(aVar6))) {
                        }
                        tcVar.Lbr.add(dqi2);
                    }
                    AppMethodBeat.o(133163);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        td tdVar = new td();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = tdVar.populateBuilderWithField(aVar7, tdVar, a.getNextFieldNumber(aVar7))) {
                        }
                        tcVar.Lbs.add(tdVar);
                    }
                    AppMethodBeat.o(133163);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        td tdVar2 = new td();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = tdVar2.populateBuilderWithField(aVar8, tdVar2, a.getNextFieldNumber(aVar8))) {
                        }
                        tcVar.Lbt.add(tdVar2);
                    }
                    AppMethodBeat.o(133163);
                    return 0;
                case 14:
                    tcVar.Lbu = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                case 15:
                    tcVar.Lbv = aVar3.UbS.zi();
                    AppMethodBeat.o(133163);
                    return 0;
                default:
                    AppMethodBeat.o(133163);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133163);
            return -1;
        }
    }
}
