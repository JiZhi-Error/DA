package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ua extends a {
    public String KDM;
    public String LcO;
    public String LcP;
    public String LcQ;
    public String LcR;
    public String LcS;
    public LinkedList<tz> LcT = new LinkedList<>();
    public int LcU;
    public String LcV;
    public String LcW;
    public String LcX;
    public int LcY;
    public String LcZ;
    public int Lda;
    public String Ldb;
    public int Ldc;
    public String Ldd;
    public un Lde;
    public String Ldf;
    public String Ldg;

    public ua() {
        AppMethodBeat.i(113951);
        AppMethodBeat.o(113951);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113952);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KDM != null) {
                aVar.e(1, this.KDM);
            }
            if (this.LcO != null) {
                aVar.e(2, this.LcO);
            }
            if (this.LcP != null) {
                aVar.e(3, this.LcP);
            }
            if (this.LcQ != null) {
                aVar.e(4, this.LcQ);
            }
            if (this.LcR != null) {
                aVar.e(5, this.LcR);
            }
            if (this.LcS != null) {
                aVar.e(6, this.LcS);
            }
            aVar.e(7, 8, this.LcT);
            aVar.aM(8, this.LcU);
            if (this.LcV != null) {
                aVar.e(9, this.LcV);
            }
            if (this.LcW != null) {
                aVar.e(10, this.LcW);
            }
            if (this.LcX != null) {
                aVar.e(11, this.LcX);
            }
            aVar.aM(12, this.LcY);
            if (this.LcZ != null) {
                aVar.e(13, this.LcZ);
            }
            aVar.aM(14, this.Lda);
            if (this.Ldb != null) {
                aVar.e(15, this.Ldb);
            }
            aVar.aM(16, this.Ldc);
            if (this.Ldd != null) {
                aVar.e(17, this.Ldd);
            }
            if (this.Lde != null) {
                aVar.ni(18, this.Lde.computeSize());
                this.Lde.writeFields(aVar);
            }
            if (this.Ldf != null) {
                aVar.e(19, this.Ldf);
            }
            if (this.Ldg != null) {
                aVar.e(20, this.Ldg);
            }
            AppMethodBeat.o(113952);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KDM != null ? g.a.a.b.b.a.f(1, this.KDM) + 0 : 0;
            if (this.LcO != null) {
                f2 += g.a.a.b.b.a.f(2, this.LcO);
            }
            if (this.LcP != null) {
                f2 += g.a.a.b.b.a.f(3, this.LcP);
            }
            if (this.LcQ != null) {
                f2 += g.a.a.b.b.a.f(4, this.LcQ);
            }
            if (this.LcR != null) {
                f2 += g.a.a.b.b.a.f(5, this.LcR);
            }
            if (this.LcS != null) {
                f2 += g.a.a.b.b.a.f(6, this.LcS);
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.LcT) + g.a.a.b.b.a.bu(8, this.LcU);
            if (this.LcV != null) {
                c2 += g.a.a.b.b.a.f(9, this.LcV);
            }
            if (this.LcW != null) {
                c2 += g.a.a.b.b.a.f(10, this.LcW);
            }
            if (this.LcX != null) {
                c2 += g.a.a.b.b.a.f(11, this.LcX);
            }
            int bu = c2 + g.a.a.b.b.a.bu(12, this.LcY);
            if (this.LcZ != null) {
                bu += g.a.a.b.b.a.f(13, this.LcZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.Lda);
            if (this.Ldb != null) {
                bu2 += g.a.a.b.b.a.f(15, this.Ldb);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.Ldc);
            if (this.Ldd != null) {
                bu3 += g.a.a.b.b.a.f(17, this.Ldd);
            }
            if (this.Lde != null) {
                bu3 += g.a.a.a.nh(18, this.Lde.computeSize());
            }
            if (this.Ldf != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Ldf);
            }
            if (this.Ldg != null) {
                bu3 += g.a.a.b.b.a.f(20, this.Ldg);
            }
            AppMethodBeat.o(113952);
            return bu3;
        } else if (i2 == 2) {
            this.LcT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113952);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ua uaVar = (ua) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    uaVar.KDM = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 2:
                    uaVar.LcO = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 3:
                    uaVar.LcP = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 4:
                    uaVar.LcQ = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 5:
                    uaVar.LcR = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 6:
                    uaVar.LcS = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        tz tzVar = new tz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tzVar.populateBuilderWithField(aVar4, tzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        uaVar.LcT.add(tzVar);
                    }
                    AppMethodBeat.o(113952);
                    return 0;
                case 8:
                    uaVar.LcU = aVar3.UbS.zi();
                    AppMethodBeat.o(113952);
                    return 0;
                case 9:
                    uaVar.LcV = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 10:
                    uaVar.LcW = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 11:
                    uaVar.LcX = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 12:
                    uaVar.LcY = aVar3.UbS.zi();
                    AppMethodBeat.o(113952);
                    return 0;
                case 13:
                    uaVar.LcZ = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 14:
                    uaVar.Lda = aVar3.UbS.zi();
                    AppMethodBeat.o(113952);
                    return 0;
                case 15:
                    uaVar.Ldb = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 16:
                    uaVar.Ldc = aVar3.UbS.zi();
                    AppMethodBeat.o(113952);
                    return 0;
                case 17:
                    uaVar.Ldd = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        un unVar = new un();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = unVar.populateBuilderWithField(aVar5, unVar, a.getNextFieldNumber(aVar5))) {
                        }
                        uaVar.Lde = unVar;
                    }
                    AppMethodBeat.o(113952);
                    return 0;
                case 19:
                    uaVar.Ldf = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                case 20:
                    uaVar.Ldg = aVar3.UbS.readString();
                    AppMethodBeat.o(113952);
                    return 0;
                default:
                    AppMethodBeat.o(113952);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113952);
            return -1;
        }
    }
}
