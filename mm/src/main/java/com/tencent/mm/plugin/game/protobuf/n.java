package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class n extends a {
    public String xJt;
    public String xJu;
    public int xJv;
    public b xJw;
    public ds xJx;
    public int xJy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41714);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJu != null) {
                aVar.e(1, this.xJu);
            }
            aVar.aM(2, this.xJv);
            if (this.xJw != null) {
                aVar.ni(3, this.xJw.computeSize());
                this.xJw.writeFields(aVar);
            }
            if (this.xJx != null) {
                aVar.ni(4, this.xJx.computeSize());
                this.xJx.writeFields(aVar);
            }
            aVar.aM(5, this.xJy);
            if (this.xJt != null) {
                aVar.e(6, this.xJt);
            }
            AppMethodBeat.o(41714);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xJu != null ? g.a.a.b.b.a.f(1, this.xJu) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xJv);
            if (this.xJw != null) {
                f2 += g.a.a.a.nh(3, this.xJw.computeSize());
            }
            if (this.xJx != null) {
                f2 += g.a.a.a.nh(4, this.xJx.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.xJy);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(6, this.xJt);
            }
            AppMethodBeat.o(41714);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41714);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nVar.xJu = aVar3.UbS.readString();
                    AppMethodBeat.o(41714);
                    return 0;
                case 2:
                    nVar.xJv = aVar3.UbS.zi();
                    AppMethodBeat.o(41714);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        b bVar = new b();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nVar.xJw = bVar;
                    }
                    AppMethodBeat.o(41714);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ds dsVar = new ds();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dsVar.populateBuilderWithField(aVar5, dsVar, a.getNextFieldNumber(aVar5))) {
                        }
                        nVar.xJx = dsVar;
                    }
                    AppMethodBeat.o(41714);
                    return 0;
                case 5:
                    nVar.xJy = aVar3.UbS.zi();
                    AppMethodBeat.o(41714);
                    return 0;
                case 6:
                    nVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41714);
                    return 0;
                default:
                    AppMethodBeat.o(41714);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41714);
            return -1;
        }
    }
}
