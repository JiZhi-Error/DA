package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class p extends a {
    public String Url;
    public String iAa;
    public String izS;
    public String izX;
    public o izY;
    public n izZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116411);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.izX != null) {
                aVar.e(1, this.izX);
            }
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            if (this.izS != null) {
                aVar.e(3, this.izS);
            }
            if (this.izY != null) {
                aVar.ni(4, this.izY.computeSize());
                this.izY.writeFields(aVar);
            }
            if (this.izZ != null) {
                aVar.ni(5, this.izZ.computeSize());
                this.izZ.writeFields(aVar);
            }
            if (this.iAa != null) {
                aVar.e(6, this.iAa);
            }
            AppMethodBeat.o(116411);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.izX != null ? g.a.a.b.b.a.f(1, this.izX) + 0 : 0;
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(2, this.Url);
            }
            if (this.izS != null) {
                f2 += g.a.a.b.b.a.f(3, this.izS);
            }
            if (this.izY != null) {
                f2 += g.a.a.a.nh(4, this.izY.computeSize());
            }
            if (this.izZ != null) {
                f2 += g.a.a.a.nh(5, this.izZ.computeSize());
            }
            if (this.iAa != null) {
                f2 += g.a.a.b.b.a.f(6, this.iAa);
            }
            AppMethodBeat.o(116411);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116411);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pVar.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(116411);
                    return 0;
                case 2:
                    pVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(116411);
                    return 0;
                case 3:
                    pVar.izS = aVar3.UbS.readString();
                    AppMethodBeat.o(116411);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        o oVar = new o();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pVar.izY = oVar;
                    }
                    AppMethodBeat.o(116411);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        n nVar = new n();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nVar.populateBuilderWithField(aVar5, nVar, a.getNextFieldNumber(aVar5))) {
                        }
                        pVar.izZ = nVar;
                    }
                    AppMethodBeat.o(116411);
                    return 0;
                case 6:
                    pVar.iAa = aVar3.UbS.readString();
                    AppMethodBeat.o(116411);
                    return 0;
                default:
                    AppMethodBeat.o(116411);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116411);
            return -1;
        }
    }
}
