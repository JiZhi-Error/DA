package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public String gqB;
    public String qGp;
    public long qGq;
    public String qGr;
    public int qGs;
    public int qGt;
    public String qGu;
    public o qGv;
    public String qGw;
    public String qGx;
    public boolean qGy;
    public LinkedList<a> qGz = new LinkedList<>();

    public c() {
        AppMethodBeat.i(153060);
        AppMethodBeat.o(153060);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153061);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.gqB != null) {
                aVar.e(1, this.gqB);
            }
            if (this.qGp != null) {
                aVar.e(2, this.qGp);
            }
            aVar.bb(3, this.qGq);
            if (this.qGr != null) {
                aVar.e(4, this.qGr);
            }
            aVar.aM(6, this.qGs);
            aVar.aM(7, this.qGt);
            if (this.qGu != null) {
                aVar.e(8, this.qGu);
            }
            if (this.qGv != null) {
                aVar.ni(9, this.qGv.computeSize());
                this.qGv.writeFields(aVar);
            }
            if (this.qGw != null) {
                aVar.e(10, this.qGw);
            }
            if (this.qGx != null) {
                aVar.e(11, this.qGx);
            }
            aVar.cc(12, this.qGy);
            aVar.e(13, 8, this.qGz);
            AppMethodBeat.o(153061);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.gqB != null ? g.a.a.b.b.a.f(1, this.gqB) + 0 : 0;
            if (this.qGp != null) {
                f2 += g.a.a.b.b.a.f(2, this.qGp);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.qGq);
            if (this.qGr != null) {
                r += g.a.a.b.b.a.f(4, this.qGr);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.qGs) + g.a.a.b.b.a.bu(7, this.qGt);
            if (this.qGu != null) {
                bu += g.a.a.b.b.a.f(8, this.qGu);
            }
            if (this.qGv != null) {
                bu += g.a.a.a.nh(9, this.qGv.computeSize());
            }
            if (this.qGw != null) {
                bu += g.a.a.b.b.a.f(10, this.qGw);
            }
            if (this.qGx != null) {
                bu += g.a.a.b.b.a.f(11, this.qGx);
            }
            int fS = bu + g.a.a.b.b.a.fS(12) + 1 + g.a.a.a.c(13, 8, this.qGz);
            AppMethodBeat.o(153061);
            return fS;
        } else if (i2 == 2) {
            this.qGz.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153061);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.gqB = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 2:
                    cVar.qGp = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 3:
                    cVar.qGq = aVar3.UbS.zl();
                    AppMethodBeat.o(153061);
                    return 0;
                case 4:
                    cVar.qGr = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(153061);
                    return -1;
                case 6:
                    cVar.qGs = aVar3.UbS.zi();
                    AppMethodBeat.o(153061);
                    return 0;
                case 7:
                    cVar.qGt = aVar3.UbS.zi();
                    AppMethodBeat.o(153061);
                    return 0;
                case 8:
                    cVar.qGu = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        o oVar = new o();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.qGv = oVar;
                    }
                    AppMethodBeat.o(153061);
                    return 0;
                case 10:
                    cVar.qGw = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 11:
                    cVar.qGx = aVar3.UbS.readString();
                    AppMethodBeat.o(153061);
                    return 0;
                case 12:
                    cVar.qGy = aVar3.UbS.yZ();
                    AppMethodBeat.o(153061);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar5 = new a();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aVar5.populateBuilderWithField(aVar6, aVar5, a.getNextFieldNumber(aVar6))) {
                        }
                        cVar.qGz.add(aVar5);
                    }
                    AppMethodBeat.o(153061);
                    return 0;
            }
        } else {
            AppMethodBeat.o(153061);
            return -1;
        }
    }
}
