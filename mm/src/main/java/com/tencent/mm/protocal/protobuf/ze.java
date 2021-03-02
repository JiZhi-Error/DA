package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ze extends dop {
    public int KHd;
    public String KPJ;
    public bf Lcc;
    public String Ljk;
    public String Lkp;
    public String Lkq;
    public String Lkr;
    public String Lks;
    public int Lkt;
    public String Lku;
    public int Lkv;
    public String Lkw;
    public String UserName;
    public String jfi;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91416);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.Lkp != null) {
                aVar.e(3, this.Lkp);
            }
            if (this.KPJ != null) {
                aVar.e(4, this.KPJ);
            }
            if (this.Lkq != null) {
                aVar.e(5, this.Lkq);
            }
            if (this.Lkr != null) {
                aVar.e(6, this.Lkr);
            }
            if (this.Lks != null) {
                aVar.e(7, this.Lks);
            }
            if (this.Ljk != null) {
                aVar.e(8, this.Ljk);
            }
            aVar.aM(9, this.Lkt);
            if (this.Lcc != null) {
                aVar.ni(10, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            if (this.Lku != null) {
                aVar.e(11, this.Lku);
            }
            if (this.UserName != null) {
                aVar.e(12, this.UserName);
            }
            if (this.xut != null) {
                aVar.e(13, this.xut);
            }
            aVar.aM(14, this.KHd);
            aVar.aM(15, this.Lkv);
            if (this.Lkw != null) {
                aVar.e(16, this.Lkw);
            }
            AppMethodBeat.o(91416);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.Lkp != null) {
                nh += g.a.a.b.b.a.f(3, this.Lkp);
            }
            if (this.KPJ != null) {
                nh += g.a.a.b.b.a.f(4, this.KPJ);
            }
            if (this.Lkq != null) {
                nh += g.a.a.b.b.a.f(5, this.Lkq);
            }
            if (this.Lkr != null) {
                nh += g.a.a.b.b.a.f(6, this.Lkr);
            }
            if (this.Lks != null) {
                nh += g.a.a.b.b.a.f(7, this.Lks);
            }
            if (this.Ljk != null) {
                nh += g.a.a.b.b.a.f(8, this.Ljk);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.Lkt);
            if (this.Lcc != null) {
                bu += g.a.a.a.nh(10, this.Lcc.computeSize());
            }
            if (this.Lku != null) {
                bu += g.a.a.b.b.a.f(11, this.Lku);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(12, this.UserName);
            }
            if (this.xut != null) {
                bu += g.a.a.b.b.a.f(13, this.xut);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.KHd) + g.a.a.b.b.a.bu(15, this.Lkv);
            if (this.Lkw != null) {
                bu2 += g.a.a.b.b.a.f(16, this.Lkw);
            }
            AppMethodBeat.o(91416);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ze zeVar = (ze) objArr[1];
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
                        zeVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91416);
                    return 0;
                case 2:
                    zeVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 3:
                    zeVar.Lkp = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 4:
                    zeVar.KPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 5:
                    zeVar.Lkq = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 6:
                    zeVar.Lkr = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 7:
                    zeVar.Lks = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 8:
                    zeVar.Ljk = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 9:
                    zeVar.Lkt = aVar3.UbS.zi();
                    AppMethodBeat.o(91416);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        zeVar.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91416);
                    return 0;
                case 11:
                    zeVar.Lku = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 12:
                    zeVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 13:
                    zeVar.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                case 14:
                    zeVar.KHd = aVar3.UbS.zi();
                    AppMethodBeat.o(91416);
                    return 0;
                case 15:
                    zeVar.Lkv = aVar3.UbS.zi();
                    AppMethodBeat.o(91416);
                    return 0;
                case 16:
                    zeVar.Lkw = aVar3.UbS.readString();
                    AppMethodBeat.o(91416);
                    return 0;
                default:
                    AppMethodBeat.o(91416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91416);
            return -1;
        }
    }
}
