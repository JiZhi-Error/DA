package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public String qGG;
    public LinkedList<String> qGH = new LinkedList<>();
    public String qGI;
    public String qGJ;
    public LinkedList<String> qGK = new LinkedList<>();
    public n qGL;
    public f qGM;

    public e() {
        AppMethodBeat.i(153063);
        AppMethodBeat.o(153063);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153064);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qGG != null) {
                aVar.e(1, this.qGG);
            }
            aVar.e(2, 1, this.qGH);
            if (this.qGI != null) {
                aVar.e(3, this.qGI);
            }
            if (this.qGJ != null) {
                aVar.e(4, this.qGJ);
            }
            aVar.e(5, 1, this.qGK);
            if (this.qGL != null) {
                aVar.ni(6, this.qGL.computeSize());
                this.qGL.writeFields(aVar);
            }
            if (this.qGM != null) {
                aVar.ni(7, this.qGM.computeSize());
                this.qGM.writeFields(aVar);
            }
            AppMethodBeat.o(153064);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.qGG != null ? g.a.a.b.b.a.f(1, this.qGG) + 0 : 0) + g.a.a.a.c(2, 1, this.qGH);
            if (this.qGI != null) {
                f2 += g.a.a.b.b.a.f(3, this.qGI);
            }
            if (this.qGJ != null) {
                f2 += g.a.a.b.b.a.f(4, this.qGJ);
            }
            int c2 = f2 + g.a.a.a.c(5, 1, this.qGK);
            if (this.qGL != null) {
                c2 += g.a.a.a.nh(6, this.qGL.computeSize());
            }
            if (this.qGM != null) {
                c2 += g.a.a.a.nh(7, this.qGM.computeSize());
            }
            AppMethodBeat.o(153064);
            return c2;
        } else if (i2 == 2) {
            this.qGH.clear();
            this.qGK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153064);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.qGG = aVar3.UbS.readString();
                    AppMethodBeat.o(153064);
                    return 0;
                case 2:
                    eVar.qGH.add(aVar3.UbS.readString());
                    AppMethodBeat.o(153064);
                    return 0;
                case 3:
                    eVar.qGI = aVar3.UbS.readString();
                    AppMethodBeat.o(153064);
                    return 0;
                case 4:
                    eVar.qGJ = aVar3.UbS.readString();
                    AppMethodBeat.o(153064);
                    return 0;
                case 5:
                    eVar.qGK.add(aVar3.UbS.readString());
                    AppMethodBeat.o(153064);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        n nVar = new n();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.qGL = nVar;
                    }
                    AppMethodBeat.o(153064);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        f fVar = new f();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fVar.populateBuilderWithField(aVar5, fVar, a.getNextFieldNumber(aVar5))) {
                        }
                        eVar.qGM = fVar;
                    }
                    AppMethodBeat.o(153064);
                    return 0;
                default:
                    AppMethodBeat.o(153064);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153064);
            return -1;
        }
    }
}
