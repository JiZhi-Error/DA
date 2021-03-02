package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dgb extends dop {
    public String HWx;
    public int HuF;
    public String HuS;
    public String MJh;
    public int MKM;
    public int MKN;
    public int MKO;
    public String Mnk;
    public String Mnl;
    public String dDj;
    public int yba;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91636);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Mnl != null) {
                aVar.e(2, this.Mnl);
            }
            aVar.aM(3, this.MKM);
            aVar.aM(4, this.yba);
            if (this.Mnk != null) {
                aVar.e(5, this.Mnk);
            }
            if (this.MJh != null) {
                aVar.e(7, this.MJh);
            }
            aVar.aM(8, this.HuF);
            if (this.dDj != null) {
                aVar.e(9, this.dDj);
            }
            if (this.HWx != null) {
                aVar.e(10, this.HWx);
            }
            aVar.aM(11, this.MKN);
            aVar.aM(12, this.MKO);
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91636);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Mnl != null) {
                nh += g.a.a.b.b.a.f(2, this.Mnl);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MKM) + g.a.a.b.b.a.bu(4, this.yba);
            if (this.Mnk != null) {
                bu += g.a.a.b.b.a.f(5, this.Mnk);
            }
            if (this.MJh != null) {
                bu += g.a.a.b.b.a.f(7, this.MJh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.HuF);
            if (this.dDj != null) {
                bu2 += g.a.a.b.b.a.f(9, this.dDj);
            }
            if (this.HWx != null) {
                bu2 += g.a.a.b.b.a.f(10, this.HWx);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.MKN) + g.a.a.b.b.a.bu(12, this.MKO);
            if (this.HuS != null) {
                bu3 += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91636);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91636);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgb dgb = (dgb) objArr[1];
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
                        dgb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91636);
                    return 0;
                case 2:
                    dgb.Mnl = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                case 3:
                    dgb.MKM = aVar3.UbS.zi();
                    AppMethodBeat.o(91636);
                    return 0;
                case 4:
                    dgb.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(91636);
                    return 0;
                case 5:
                    dgb.Mnk = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                case 7:
                    dgb.MJh = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                case 8:
                    dgb.HuF = aVar3.UbS.zi();
                    AppMethodBeat.o(91636);
                    return 0;
                case 9:
                    dgb.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                case 10:
                    dgb.HWx = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                case 11:
                    dgb.MKN = aVar3.UbS.zi();
                    AppMethodBeat.o(91636);
                    return 0;
                case 12:
                    dgb.MKO = aVar3.UbS.zi();
                    AppMethodBeat.o(91636);
                    return 0;
                case 100:
                    dgb.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91636);
                    return 0;
                default:
                    AppMethodBeat.o(91636);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91636);
            return -1;
        }
    }
}
