package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class of extends a {
    public int Gaz;
    public int KJJ;
    public int KSR;
    public int KSS;
    public int KTH;
    public int KTI;
    public acf KTJ;
    public int KTK;
    public int KTL;
    public int KTM = 0;
    public int KTN;
    public String content;
    public String iwv;
    public String openid;
    public String qFU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103203);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KTH);
            aVar.aM(2, this.KJJ);
            if (this.openid != null) {
                aVar.e(3, this.openid);
            }
            if (this.qFU != null) {
                aVar.e(4, this.qFU);
            }
            if (this.iwv != null) {
                aVar.e(5, this.iwv);
            }
            if (this.content != null) {
                aVar.e(6, this.content);
            }
            aVar.aM(7, this.Gaz);
            aVar.aM(8, this.KTI);
            aVar.aM(9, this.KSR);
            aVar.aM(10, this.KSS);
            if (this.KTJ != null) {
                aVar.ni(11, this.KTJ.computeSize());
                this.KTJ.writeFields(aVar);
            }
            aVar.aM(12, this.KTK);
            aVar.aM(13, this.KTL);
            aVar.aM(14, this.KTM);
            aVar.aM(15, this.KTN);
            AppMethodBeat.o(103203);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KTH) + 0 + g.a.a.b.b.a.bu(2, this.KJJ);
            if (this.openid != null) {
                bu += g.a.a.b.b.a.f(3, this.openid);
            }
            if (this.qFU != null) {
                bu += g.a.a.b.b.a.f(4, this.qFU);
            }
            if (this.iwv != null) {
                bu += g.a.a.b.b.a.f(5, this.iwv);
            }
            if (this.content != null) {
                bu += g.a.a.b.b.a.f(6, this.content);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Gaz) + g.a.a.b.b.a.bu(8, this.KTI) + g.a.a.b.b.a.bu(9, this.KSR) + g.a.a.b.b.a.bu(10, this.KSS);
            if (this.KTJ != null) {
                bu2 += g.a.a.a.nh(11, this.KTJ.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.KTK) + g.a.a.b.b.a.bu(13, this.KTL) + g.a.a.b.b.a.bu(14, this.KTM) + g.a.a.b.b.a.bu(15, this.KTN);
            AppMethodBeat.o(103203);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103203);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            of ofVar = (of) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ofVar.KTH = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 2:
                    ofVar.KJJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 3:
                    ofVar.openid = aVar3.UbS.readString();
                    AppMethodBeat.o(103203);
                    return 0;
                case 4:
                    ofVar.qFU = aVar3.UbS.readString();
                    AppMethodBeat.o(103203);
                    return 0;
                case 5:
                    ofVar.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(103203);
                    return 0;
                case 6:
                    ofVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(103203);
                    return 0;
                case 7:
                    ofVar.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 8:
                    ofVar.KTI = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 9:
                    ofVar.KSR = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 10:
                    ofVar.KSS = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acf acf = new acf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acf.populateBuilderWithField(aVar4, acf, a.getNextFieldNumber(aVar4))) {
                        }
                        ofVar.KTJ = acf;
                    }
                    AppMethodBeat.o(103203);
                    return 0;
                case 12:
                    ofVar.KTK = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 13:
                    ofVar.KTL = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 14:
                    ofVar.KTM = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                case 15:
                    ofVar.KTN = aVar3.UbS.zi();
                    AppMethodBeat.o(103203);
                    return 0;
                default:
                    AppMethodBeat.o(103203);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103203);
            return -1;
        }
    }
}
