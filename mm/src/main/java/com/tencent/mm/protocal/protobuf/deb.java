package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class deb extends dop {
    public String HuS;
    public int MJd;
    public int MJe;
    public ja MJf;
    public int MJg;
    public String MJh;
    public int yba;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91624);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MJd);
            aVar.aM(3, this.MJe);
            if (this.MJf != null) {
                aVar.ni(4, this.MJf.computeSize());
                this.MJf.writeFields(aVar);
            }
            aVar.aM(5, this.yba);
            aVar.aM(6, this.MJg);
            if (this.MJh != null) {
                aVar.e(7, this.MJh);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91624);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MJd) + g.a.a.b.b.a.bu(3, this.MJe);
            if (this.MJf != null) {
                nh += g.a.a.a.nh(4, this.MJf.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.yba) + g.a.a.b.b.a.bu(6, this.MJg);
            if (this.MJh != null) {
                bu += g.a.a.b.b.a.f(7, this.MJh);
            }
            if (this.HuS != null) {
                bu += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91624);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91624);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            deb deb = (deb) objArr[1];
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
                        deb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91624);
                    return 0;
                case 2:
                    deb.MJd = aVar3.UbS.zi();
                    AppMethodBeat.o(91624);
                    return 0;
                case 3:
                    deb.MJe = aVar3.UbS.zi();
                    AppMethodBeat.o(91624);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ja jaVar = new ja();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jaVar.populateBuilderWithField(aVar5, jaVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        deb.MJf = jaVar;
                    }
                    AppMethodBeat.o(91624);
                    return 0;
                case 5:
                    deb.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(91624);
                    return 0;
                case 6:
                    deb.MJg = aVar3.UbS.zi();
                    AppMethodBeat.o(91624);
                    return 0;
                case 7:
                    deb.MJh = aVar3.UbS.readString();
                    AppMethodBeat.o(91624);
                    return 0;
                case 100:
                    deb.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91624);
                    return 0;
                default:
                    AppMethodBeat.o(91624);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91624);
            return -1;
        }
    }
}
