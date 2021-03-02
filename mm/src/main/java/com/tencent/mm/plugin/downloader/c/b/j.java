package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class j extends a {
    public String gqB;
    public m qGW;
    public String qGX;
    public long qGq;
    public String qGu;
    public String qGx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153070);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.gqB == null) {
                b bVar = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(153070);
                throw bVar;
            }
            if (this.gqB != null) {
                aVar.e(1, this.gqB);
            }
            aVar.bb(2, this.qGq);
            if (this.qGW != null) {
                aVar.ni(3, this.qGW.computeSize());
                this.qGW.writeFields(aVar);
            }
            if (this.qGX != null) {
                aVar.e(4, this.qGX);
            }
            if (this.qGx != null) {
                aVar.e(5, this.qGx);
            }
            if (this.qGu != null) {
                aVar.e(6, this.qGu);
            }
            AppMethodBeat.o(153070);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.gqB != null ? g.a.a.b.b.a.f(1, this.gqB) + 0 : 0) + g.a.a.b.b.a.r(2, this.qGq);
            if (this.qGW != null) {
                f2 += g.a.a.a.nh(3, this.qGW.computeSize());
            }
            if (this.qGX != null) {
                f2 += g.a.a.b.b.a.f(4, this.qGX);
            }
            if (this.qGx != null) {
                f2 += g.a.a.b.b.a.f(5, this.qGx);
            }
            if (this.qGu != null) {
                f2 += g.a.a.b.b.a.f(6, this.qGu);
            }
            AppMethodBeat.o(153070);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.gqB == null) {
                b bVar2 = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(153070);
                throw bVar2;
            }
            AppMethodBeat.o(153070);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.gqB = aVar3.UbS.readString();
                    AppMethodBeat.o(153070);
                    return 0;
                case 2:
                    jVar.qGq = aVar3.UbS.zl();
                    AppMethodBeat.o(153070);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = new m();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.qGW = mVar;
                    }
                    AppMethodBeat.o(153070);
                    return 0;
                case 4:
                    jVar.qGX = aVar3.UbS.readString();
                    AppMethodBeat.o(153070);
                    return 0;
                case 5:
                    jVar.qGx = aVar3.UbS.readString();
                    AppMethodBeat.o(153070);
                    return 0;
                case 6:
                    jVar.qGu = aVar3.UbS.readString();
                    AppMethodBeat.o(153070);
                    return 0;
                default:
                    AppMethodBeat.o(153070);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153070);
            return -1;
        }
    }
}
