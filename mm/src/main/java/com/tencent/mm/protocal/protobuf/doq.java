package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class doq extends dop {
    public int Cjg;
    public String Cjt;
    public String Cju;
    public String KKI;
    public int KYp;
    public String MBV;
    public int MRP;
    public String MRQ;
    public int MRR;
    public int MRS;
    public b MRT;
    public String dDj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72581);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Cjt != null) {
                aVar.e(2, this.Cjt);
            }
            if (this.Cju != null) {
                aVar.e(3, this.Cju);
            }
            if (this.dDj != null) {
                aVar.e(4, this.dDj);
            }
            aVar.aM(5, this.Cjg);
            aVar.aM(6, this.MRP);
            if (this.MRQ != null) {
                aVar.e(7, this.MRQ);
            }
            aVar.aM(8, this.MRR);
            aVar.aM(9, this.MRS);
            if (this.KKI != null) {
                aVar.e(10, this.KKI);
            }
            if (this.MBV != null) {
                aVar.e(11, this.MBV);
            }
            if (this.MRT != null) {
                aVar.c(12, this.MRT);
            }
            aVar.aM(13, this.KYp);
            AppMethodBeat.o(72581);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Cjt != null) {
                nh += g.a.a.b.b.a.f(2, this.Cjt);
            }
            if (this.Cju != null) {
                nh += g.a.a.b.b.a.f(3, this.Cju);
            }
            if (this.dDj != null) {
                nh += g.a.a.b.b.a.f(4, this.dDj);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Cjg) + g.a.a.b.b.a.bu(6, this.MRP);
            if (this.MRQ != null) {
                bu += g.a.a.b.b.a.f(7, this.MRQ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MRR) + g.a.a.b.b.a.bu(9, this.MRS);
            if (this.KKI != null) {
                bu2 += g.a.a.b.b.a.f(10, this.KKI);
            }
            if (this.MBV != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MBV);
            }
            if (this.MRT != null) {
                bu2 += g.a.a.b.b.a.b(12, this.MRT);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.KYp);
            AppMethodBeat.o(72581);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72581);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doq doq = (doq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        doq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72581);
                    return 0;
                case 2:
                    doq.Cjt = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 3:
                    doq.Cju = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 4:
                    doq.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 5:
                    doq.Cjg = aVar3.UbS.zi();
                    AppMethodBeat.o(72581);
                    return 0;
                case 6:
                    doq.MRP = aVar3.UbS.zi();
                    AppMethodBeat.o(72581);
                    return 0;
                case 7:
                    doq.MRQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 8:
                    doq.MRR = aVar3.UbS.zi();
                    AppMethodBeat.o(72581);
                    return 0;
                case 9:
                    doq.MRS = aVar3.UbS.zi();
                    AppMethodBeat.o(72581);
                    return 0;
                case 10:
                    doq.KKI = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 11:
                    doq.MBV = aVar3.UbS.readString();
                    AppMethodBeat.o(72581);
                    return 0;
                case 12:
                    doq.MRT = aVar3.UbS.hPo();
                    AppMethodBeat.o(72581);
                    return 0;
                case 13:
                    doq.KYp = aVar3.UbS.zi();
                    AppMethodBeat.o(72581);
                    return 0;
                default:
                    AppMethodBeat.o(72581);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72581);
            return -1;
        }
    }
}
