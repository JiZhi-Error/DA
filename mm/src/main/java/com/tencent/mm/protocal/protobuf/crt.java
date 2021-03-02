package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class crt extends a {
    public String MwB;
    public String MwM;
    public crr MwN;
    public crp MwO;
    public crs MwP;
    public fho VjZ;
    public int dUm;
    public String sGQ;
    public long viC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208707);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sGQ != null) {
                aVar.e(1, this.sGQ);
            }
            aVar.bb(2, this.viC);
            if (this.MwM != null) {
                aVar.e(3, this.MwM);
            }
            aVar.aM(4, this.dUm);
            if (this.MwB != null) {
                aVar.e(5, this.MwB);
            }
            if (this.MwN != null) {
                aVar.ni(6, this.MwN.computeSize());
                this.MwN.writeFields(aVar);
            }
            if (this.MwO != null) {
                aVar.ni(7, this.MwO.computeSize());
                this.MwO.writeFields(aVar);
            }
            if (this.MwP != null) {
                aVar.ni(8, this.MwP.computeSize());
                this.MwP.writeFields(aVar);
            }
            if (this.VjZ != null) {
                aVar.ni(9, this.VjZ.computeSize());
                this.VjZ.writeFields(aVar);
            }
            AppMethodBeat.o(208707);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.sGQ != null ? g.a.a.b.b.a.f(1, this.sGQ) + 0 : 0) + g.a.a.b.b.a.r(2, this.viC);
            if (this.MwM != null) {
                f2 += g.a.a.b.b.a.f(3, this.MwM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.dUm);
            if (this.MwB != null) {
                bu += g.a.a.b.b.a.f(5, this.MwB);
            }
            if (this.MwN != null) {
                bu += g.a.a.a.nh(6, this.MwN.computeSize());
            }
            if (this.MwO != null) {
                bu += g.a.a.a.nh(7, this.MwO.computeSize());
            }
            if (this.MwP != null) {
                bu += g.a.a.a.nh(8, this.MwP.computeSize());
            }
            if (this.VjZ != null) {
                bu += g.a.a.a.nh(9, this.VjZ.computeSize());
            }
            AppMethodBeat.o(208707);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crt crt = (crt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    crt.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(208707);
                    return 0;
                case 2:
                    crt.viC = aVar3.UbS.zl();
                    AppMethodBeat.o(208707);
                    return 0;
                case 3:
                    crt.MwM = aVar3.UbS.readString();
                    AppMethodBeat.o(208707);
                    return 0;
                case 4:
                    crt.dUm = aVar3.UbS.zi();
                    AppMethodBeat.o(208707);
                    return 0;
                case 5:
                    crt.MwB = aVar3.UbS.readString();
                    AppMethodBeat.o(208707);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        crr crr = new crr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = crr.populateBuilderWithField(aVar4, crr, a.getNextFieldNumber(aVar4))) {
                        }
                        crt.MwN = crr;
                    }
                    AppMethodBeat.o(208707);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        crp crp = new crp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = crp.populateBuilderWithField(aVar5, crp, a.getNextFieldNumber(aVar5))) {
                        }
                        crt.MwO = crp;
                    }
                    AppMethodBeat.o(208707);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        crs crs = new crs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = crs.populateBuilderWithField(aVar6, crs, a.getNextFieldNumber(aVar6))) {
                        }
                        crt.MwP = crs;
                    }
                    AppMethodBeat.o(208707);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fho fho = new fho();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fho.populateBuilderWithField(aVar7, fho, a.getNextFieldNumber(aVar7))) {
                        }
                        crt.VjZ = fho;
                    }
                    AppMethodBeat.o(208707);
                    return 0;
                default:
                    AppMethodBeat.o(208707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208707);
            return -1;
        }
    }
}
