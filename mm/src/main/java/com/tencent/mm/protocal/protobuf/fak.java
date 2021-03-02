package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class fak extends a {
    public LinkedList<fai> NwC = new LinkedList<>();
    public boolean NwD;
    public boolean NwE;
    public boolean NwF;
    public String appId;
    public String dPJ;
    public int hDa;
    public long jsm;
    public String pDI;
    public String pFJ;
    public int pmN;
    public String url;

    public fak() {
        AppMethodBeat.i(224552);
        AppMethodBeat.o(224552);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224553);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url == null) {
                b bVar = new b("Not all required fields were included: url");
                AppMethodBeat.o(224553);
                throw bVar;
            }
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            aVar.bb(2, this.jsm);
            aVar.cc(3, this.NwD);
            aVar.cc(4, this.NwE);
            if (this.pDI != null) {
                aVar.e(5, this.pDI);
            }
            if (this.pFJ != null) {
                aVar.e(6, this.pFJ);
            }
            if (this.dPJ != null) {
                aVar.e(7, this.dPJ);
            }
            aVar.cc(8, this.NwF);
            aVar.e(9, 8, this.NwC);
            aVar.aM(10, this.hDa);
            aVar.aM(11, this.pmN);
            if (this.appId != null) {
                aVar.e(12, this.appId);
            }
            AppMethodBeat.o(224553);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0) + g.a.a.b.b.a.r(2, this.jsm) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1;
            if (this.pDI != null) {
                f2 += g.a.a.b.b.a.f(5, this.pDI);
            }
            if (this.pFJ != null) {
                f2 += g.a.a.b.b.a.f(6, this.pFJ);
            }
            if (this.dPJ != null) {
                f2 += g.a.a.b.b.a.f(7, this.dPJ);
            }
            int fS = f2 + g.a.a.b.b.a.fS(8) + 1 + g.a.a.a.c(9, 8, this.NwC) + g.a.a.b.b.a.bu(10, this.hDa) + g.a.a.b.b.a.bu(11, this.pmN);
            if (this.appId != null) {
                fS += g.a.a.b.b.a.f(12, this.appId);
            }
            AppMethodBeat.o(224553);
            return fS;
        } else if (i2 == 2) {
            this.NwC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.url == null) {
                b bVar2 = new b("Not all required fields were included: url");
                AppMethodBeat.o(224553);
                throw bVar2;
            }
            AppMethodBeat.o(224553);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fak fak = (fak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fak.url = aVar3.UbS.readString();
                    AppMethodBeat.o(224553);
                    return 0;
                case 2:
                    fak.jsm = aVar3.UbS.zl();
                    AppMethodBeat.o(224553);
                    return 0;
                case 3:
                    fak.NwD = aVar3.UbS.yZ();
                    AppMethodBeat.o(224553);
                    return 0;
                case 4:
                    fak.NwE = aVar3.UbS.yZ();
                    AppMethodBeat.o(224553);
                    return 0;
                case 5:
                    fak.pDI = aVar3.UbS.readString();
                    AppMethodBeat.o(224553);
                    return 0;
                case 6:
                    fak.pFJ = aVar3.UbS.readString();
                    AppMethodBeat.o(224553);
                    return 0;
                case 7:
                    fak.dPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(224553);
                    return 0;
                case 8:
                    fak.NwF = aVar3.UbS.yZ();
                    AppMethodBeat.o(224553);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fai fai = new fai();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fai.populateBuilderWithField(aVar4, fai, a.getNextFieldNumber(aVar4))) {
                        }
                        fak.NwC.add(fai);
                    }
                    AppMethodBeat.o(224553);
                    return 0;
                case 10:
                    fak.hDa = aVar3.UbS.zi();
                    AppMethodBeat.o(224553);
                    return 0;
                case 11:
                    fak.pmN = aVar3.UbS.zi();
                    AppMethodBeat.o(224553);
                    return 0;
                case 12:
                    fak.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(224553);
                    return 0;
                default:
                    AppMethodBeat.o(224553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224553);
            return -1;
        }
    }
}
