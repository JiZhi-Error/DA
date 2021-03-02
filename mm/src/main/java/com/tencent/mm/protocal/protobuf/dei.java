package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public class dei extends a {
    public int MJq;
    public boolean MJr;
    public boolean MJs;
    public boolean MJt;
    public boolean MJu;
    public boolean MJv;
    public boolean MJw;
    public String hFF = "";
    public int id;
    public int iwc;
    public int pCV;
    public boolean pCb;
    public int pHw;
    public int pmM;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224540);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url == null) {
                b bVar = new b("Not all required fields were included: url");
                AppMethodBeat.o(224540);
                throw bVar;
            } else if (this.hFF == null) {
                b bVar2 = new b("Not all required fields were included: uid");
                AppMethodBeat.o(224540);
                throw bVar2;
            } else {
                aVar.aM(1, this.id);
                if (this.url != null) {
                    aVar.e(2, this.url);
                }
                aVar.aM(3, this.iwc);
                aVar.aM(4, this.pCV);
                aVar.aM(5, this.pmM);
                aVar.aM(6, this.pHw);
                aVar.aM(7, this.MJq);
                if (this.hFF != null) {
                    aVar.e(8, this.hFF);
                }
                aVar.cc(9, this.MJr);
                aVar.cc(10, this.MJs);
                aVar.cc(11, this.MJt);
                aVar.cc(12, this.MJu);
                aVar.cc(13, this.MJv);
                aVar.cc(14, this.pCb);
                aVar.cc(15, this.MJw);
                AppMethodBeat.o(224540);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(2, this.url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.iwc) + g.a.a.b.b.a.bu(4, this.pCV) + g.a.a.b.b.a.bu(5, this.pmM) + g.a.a.b.b.a.bu(6, this.pHw) + g.a.a.b.b.a.bu(7, this.MJq);
            if (this.hFF != null) {
                bu2 += g.a.a.b.b.a.f(8, this.hFF);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.fS(12) + 1 + g.a.a.b.b.a.fS(13) + 1 + g.a.a.b.b.a.fS(14) + 1 + g.a.a.b.b.a.fS(15) + 1;
            AppMethodBeat.o(224540);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.url == null) {
                b bVar3 = new b("Not all required fields were included: url");
                AppMethodBeat.o(224540);
                throw bVar3;
            } else if (this.hFF == null) {
                b bVar4 = new b("Not all required fields were included: uid");
                AppMethodBeat.o(224540);
                throw bVar4;
            } else {
                AppMethodBeat.o(224540);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dei dei = (dei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dei.id = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 2:
                    dei.url = aVar3.UbS.readString();
                    AppMethodBeat.o(224540);
                    return 0;
                case 3:
                    dei.iwc = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 4:
                    dei.pCV = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 5:
                    dei.pmM = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 6:
                    dei.pHw = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 7:
                    dei.MJq = aVar3.UbS.zi();
                    AppMethodBeat.o(224540);
                    return 0;
                case 8:
                    dei.hFF = aVar3.UbS.readString();
                    AppMethodBeat.o(224540);
                    return 0;
                case 9:
                    dei.MJr = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 10:
                    dei.MJs = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 11:
                    dei.MJt = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 12:
                    dei.MJu = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 13:
                    dei.MJv = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 14:
                    dei.pCb = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                case 15:
                    dei.MJw = aVar3.UbS.yZ();
                    AppMethodBeat.o(224540);
                    return 0;
                default:
                    AppMethodBeat.o(224540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224540);
            return -1;
        }
    }
}
