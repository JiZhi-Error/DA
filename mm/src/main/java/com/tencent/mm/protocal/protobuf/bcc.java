package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bcc extends a {
    public int FVr;
    public String Kib;
    public String LLm;
    public String LLn;
    public int LLo;
    public String LLp;
    public String LLq;
    public atv LLr;
    public atp LLs;
    public int jjN;
    public String qfq;
    public int recommendType;
    public bda ttR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209670);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qfq != null) {
                aVar.e(1, this.qfq);
            }
            if (this.LLm != null) {
                aVar.e(2, this.LLm);
            }
            if (this.LLn != null) {
                aVar.e(3, this.LLn);
            }
            aVar.aM(4, this.FVr);
            aVar.aM(5, this.LLo);
            if (this.LLp != null) {
                aVar.e(6, this.LLp);
            }
            if (this.LLq != null) {
                aVar.e(7, this.LLq);
            }
            if (this.Kib != null) {
                aVar.e(8, this.Kib);
            }
            aVar.aM(9, this.jjN);
            if (this.LLr != null) {
                aVar.ni(10, this.LLr.computeSize());
                this.LLr.writeFields(aVar);
            }
            if (this.ttR != null) {
                aVar.ni(11, this.ttR.computeSize());
                this.ttR.writeFields(aVar);
            }
            if (this.LLs != null) {
                aVar.ni(12, this.LLs.computeSize());
                this.LLs.writeFields(aVar);
            }
            aVar.aM(13, this.recommendType);
            AppMethodBeat.o(209670);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.qfq != null ? g.a.a.b.b.a.f(1, this.qfq) + 0 : 0;
            if (this.LLm != null) {
                f2 += g.a.a.b.b.a.f(2, this.LLm);
            }
            if (this.LLn != null) {
                f2 += g.a.a.b.b.a.f(3, this.LLn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.FVr) + g.a.a.b.b.a.bu(5, this.LLo);
            if (this.LLp != null) {
                bu += g.a.a.b.b.a.f(6, this.LLp);
            }
            if (this.LLq != null) {
                bu += g.a.a.b.b.a.f(7, this.LLq);
            }
            if (this.Kib != null) {
                bu += g.a.a.b.b.a.f(8, this.Kib);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.jjN);
            if (this.LLr != null) {
                bu2 += g.a.a.a.nh(10, this.LLr.computeSize());
            }
            if (this.ttR != null) {
                bu2 += g.a.a.a.nh(11, this.ttR.computeSize());
            }
            if (this.LLs != null) {
                bu2 += g.a.a.a.nh(12, this.LLs.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.recommendType);
            AppMethodBeat.o(209670);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209670);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcc bcc = (bcc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcc.qfq = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 2:
                    bcc.LLm = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 3:
                    bcc.LLn = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 4:
                    bcc.FVr = aVar3.UbS.zi();
                    AppMethodBeat.o(209670);
                    return 0;
                case 5:
                    bcc.LLo = aVar3.UbS.zi();
                    AppMethodBeat.o(209670);
                    return 0;
                case 6:
                    bcc.LLp = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 7:
                    bcc.LLq = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 8:
                    bcc.Kib = aVar3.UbS.readString();
                    AppMethodBeat.o(209670);
                    return 0;
                case 9:
                    bcc.jjN = aVar3.UbS.zi();
                    AppMethodBeat.o(209670);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        atv atv = new atv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = atv.populateBuilderWithField(aVar4, atv, a.getNextFieldNumber(aVar4))) {
                        }
                        bcc.LLr = atv;
                    }
                    AppMethodBeat.o(209670);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bda bda = new bda();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bda.populateBuilderWithField(aVar5, bda, a.getNextFieldNumber(aVar5))) {
                        }
                        bcc.ttR = bda;
                    }
                    AppMethodBeat.o(209670);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        atp atp = new atp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = atp.populateBuilderWithField(aVar6, atp, a.getNextFieldNumber(aVar6))) {
                        }
                        bcc.LLs = atp;
                    }
                    AppMethodBeat.o(209670);
                    return 0;
                case 13:
                    bcc.recommendType = aVar3.UbS.zi();
                    AppMethodBeat.o(209670);
                    return 0;
                default:
                    AppMethodBeat.o(209670);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209670);
            return -1;
        }
    }
}
