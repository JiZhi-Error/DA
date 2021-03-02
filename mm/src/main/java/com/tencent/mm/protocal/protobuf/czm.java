package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class czm extends dop {
    public String LQv;
    public bf Lcc;
    public String Lkp;
    public String Lkq;
    public String Lkr;
    public String Lks;
    public String MEM;
    public String MEN;
    public String MEO;
    public String MEP;
    public String MEQ;
    public String jfi;
    public String xMq;
    public String xuk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91571);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.MEM != null) {
                aVar.e(3, this.MEM);
            }
            if (this.LQv != null) {
                aVar.e(4, this.LQv);
            }
            if (this.Lkp != null) {
                aVar.e(5, this.Lkp);
            }
            if (this.MEN != null) {
                aVar.e(6, this.MEN);
            }
            if (this.Lkq != null) {
                aVar.e(7, this.Lkq);
            }
            if (this.Lkr != null) {
                aVar.e(8, this.Lkr);
            }
            if (this.Lks != null) {
                aVar.e(9, this.Lks);
            }
            if (this.MEO != null) {
                aVar.e(10, this.MEO);
            }
            if (this.Lcc != null) {
                aVar.ni(11, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            if (this.MEP != null) {
                aVar.e(12, this.MEP);
            }
            if (this.xuk != null) {
                aVar.e(13, this.xuk);
            }
            if (this.xMq != null) {
                aVar.e(14, this.xMq);
            }
            if (this.MEQ != null) {
                aVar.e(15, this.MEQ);
            }
            AppMethodBeat.o(91571);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.MEM != null) {
                nh += g.a.a.b.b.a.f(3, this.MEM);
            }
            if (this.LQv != null) {
                nh += g.a.a.b.b.a.f(4, this.LQv);
            }
            if (this.Lkp != null) {
                nh += g.a.a.b.b.a.f(5, this.Lkp);
            }
            if (this.MEN != null) {
                nh += g.a.a.b.b.a.f(6, this.MEN);
            }
            if (this.Lkq != null) {
                nh += g.a.a.b.b.a.f(7, this.Lkq);
            }
            if (this.Lkr != null) {
                nh += g.a.a.b.b.a.f(8, this.Lkr);
            }
            if (this.Lks != null) {
                nh += g.a.a.b.b.a.f(9, this.Lks);
            }
            if (this.MEO != null) {
                nh += g.a.a.b.b.a.f(10, this.MEO);
            }
            if (this.Lcc != null) {
                nh += g.a.a.a.nh(11, this.Lcc.computeSize());
            }
            if (this.MEP != null) {
                nh += g.a.a.b.b.a.f(12, this.MEP);
            }
            if (this.xuk != null) {
                nh += g.a.a.b.b.a.f(13, this.xuk);
            }
            if (this.xMq != null) {
                nh += g.a.a.b.b.a.f(14, this.xMq);
            }
            if (this.MEQ != null) {
                nh += g.a.a.b.b.a.f(15, this.MEQ);
            }
            AppMethodBeat.o(91571);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91571);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czm czm = (czm) objArr[1];
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
                        czm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91571);
                    return 0;
                case 2:
                    czm.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 3:
                    czm.MEM = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 4:
                    czm.LQv = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 5:
                    czm.Lkp = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 6:
                    czm.MEN = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 7:
                    czm.Lkq = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 8:
                    czm.Lkr = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 9:
                    czm.Lks = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 10:
                    czm.MEO = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        czm.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91571);
                    return 0;
                case 12:
                    czm.MEP = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 13:
                    czm.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 14:
                    czm.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                case 15:
                    czm.MEQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91571);
                    return 0;
                default:
                    AppMethodBeat.o(91571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91571);
            return -1;
        }
    }
}
