package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String dNI;
    public String qGA;
    public String qGB;
    public String qGC;
    public int qGD;
    public h qGE;
    public String qGF;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153062);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI == null) {
                b bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(153062);
                throw bVar;
            } else if (this.qGA == null) {
                b bVar2 = new b("Not all required fields were included: app_name");
                AppMethodBeat.o(153062);
                throw bVar2;
            } else {
                if (this.dNI != null) {
                    aVar.e(1, this.dNI);
                }
                if (this.qGA != null) {
                    aVar.e(2, this.qGA);
                }
                if (this.qGB != null) {
                    aVar.e(3, this.qGB);
                }
                if (this.qGC != null) {
                    aVar.e(4, this.qGC);
                }
                aVar.aM(5, this.qGD);
                aVar.aM(6, this.status);
                if (this.qGE != null) {
                    aVar.ni(7, this.qGE.computeSize());
                    this.qGE.writeFields(aVar);
                }
                if (this.qGF != null) {
                    aVar.e(8, this.qGF);
                }
                AppMethodBeat.o(153062);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.qGA != null) {
                f2 += g.a.a.b.b.a.f(2, this.qGA);
            }
            if (this.qGB != null) {
                f2 += g.a.a.b.b.a.f(3, this.qGB);
            }
            if (this.qGC != null) {
                f2 += g.a.a.b.b.a.f(4, this.qGC);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.qGD) + g.a.a.b.b.a.bu(6, this.status);
            if (this.qGE != null) {
                bu += g.a.a.a.nh(7, this.qGE.computeSize());
            }
            if (this.qGF != null) {
                bu += g.a.a.b.b.a.f(8, this.qGF);
            }
            AppMethodBeat.o(153062);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dNI == null) {
                b bVar3 = new b("Not all required fields were included: appid");
                AppMethodBeat.o(153062);
                throw bVar3;
            } else if (this.qGA == null) {
                b bVar4 = new b("Not all required fields were included: app_name");
                AppMethodBeat.o(153062);
                throw bVar4;
            } else {
                AppMethodBeat.o(153062);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(153062);
                    return 0;
                case 2:
                    dVar.qGA = aVar3.UbS.readString();
                    AppMethodBeat.o(153062);
                    return 0;
                case 3:
                    dVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(153062);
                    return 0;
                case 4:
                    dVar.qGC = aVar3.UbS.readString();
                    AppMethodBeat.o(153062);
                    return 0;
                case 5:
                    dVar.qGD = aVar3.UbS.zi();
                    AppMethodBeat.o(153062);
                    return 0;
                case 6:
                    dVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(153062);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h hVar = new h();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qGE = hVar;
                    }
                    AppMethodBeat.o(153062);
                    return 0;
                case 8:
                    dVar.qGF = aVar3.UbS.readString();
                    AppMethodBeat.o(153062);
                    return 0;
                default:
                    AppMethodBeat.o(153062);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153062);
            return -1;
        }
    }
}
