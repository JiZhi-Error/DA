package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhi extends dop {
    public String CpP;
    public int HuF;
    public String HuS;
    public String MJh;
    public int MKM;
    public String MLF;
    public int MLG;
    public int yba;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91641);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MLF != null) {
                aVar.e(2, this.MLF);
            }
            if (this.CpP != null) {
                aVar.e(3, this.CpP);
            }
            aVar.aM(4, this.MKM);
            aVar.aM(5, this.yba);
            if (this.MJh != null) {
                aVar.e(6, this.MJh);
            }
            aVar.aM(7, this.HuF);
            aVar.aM(8, this.MLG);
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91641);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MLF != null) {
                nh += g.a.a.b.b.a.f(2, this.MLF);
            }
            if (this.CpP != null) {
                nh += g.a.a.b.b.a.f(3, this.CpP);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MKM) + g.a.a.b.b.a.bu(5, this.yba);
            if (this.MJh != null) {
                bu += g.a.a.b.b.a.f(6, this.MJh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.HuF) + g.a.a.b.b.a.bu(8, this.MLG);
            if (this.HuS != null) {
                bu2 += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91641);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91641);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhi dhi = (dhi) objArr[1];
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
                        dhi.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91641);
                    return 0;
                case 2:
                    dhi.MLF = aVar3.UbS.readString();
                    AppMethodBeat.o(91641);
                    return 0;
                case 3:
                    dhi.CpP = aVar3.UbS.readString();
                    AppMethodBeat.o(91641);
                    return 0;
                case 4:
                    dhi.MKM = aVar3.UbS.zi();
                    AppMethodBeat.o(91641);
                    return 0;
                case 5:
                    dhi.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(91641);
                    return 0;
                case 6:
                    dhi.MJh = aVar3.UbS.readString();
                    AppMethodBeat.o(91641);
                    return 0;
                case 7:
                    dhi.HuF = aVar3.UbS.zi();
                    AppMethodBeat.o(91641);
                    return 0;
                case 8:
                    dhi.MLG = aVar3.UbS.zi();
                    AppMethodBeat.o(91641);
                    return 0;
                case 100:
                    dhi.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91641);
                    return 0;
                default:
                    AppMethodBeat.o(91641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91641);
            return -1;
        }
    }
}
