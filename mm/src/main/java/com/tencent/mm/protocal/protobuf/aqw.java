package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqw extends a {
    public int LCH;
    public LinkedList<bbz> LCI = new LinkedList<>();
    public int continueFlag;
    public String dPI;
    public int offset;
    public String query;
    public b tVM;
    public LinkedList<FinderObject> tbD = new LinkedList<>();

    public aqw() {
        AppMethodBeat.i(168958);
        AppMethodBeat.o(168958);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168959);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.query != null) {
                aVar.e(1, this.query);
            }
            aVar.aM(2, this.offset);
            aVar.aM(3, this.continueFlag);
            aVar.e(4, 8, this.tbD);
            if (this.tVM != null) {
                aVar.c(5, this.tVM);
            }
            aVar.aM(6, this.LCH);
            if (this.dPI != null) {
                aVar.e(7, this.dPI);
            }
            aVar.e(8, 8, this.LCI);
            AppMethodBeat.o(168959);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.query != null ? g.a.a.b.b.a.f(1, this.query) + 0 : 0) + g.a.a.b.b.a.bu(2, this.offset) + g.a.a.b.b.a.bu(3, this.continueFlag) + g.a.a.a.c(4, 8, this.tbD);
            if (this.tVM != null) {
                f2 += g.a.a.b.b.a.b(5, this.tVM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.LCH);
            if (this.dPI != null) {
                bu += g.a.a.b.b.a.f(7, this.dPI);
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.LCI);
            AppMethodBeat.o(168959);
            return c2;
        } else if (i2 == 2) {
            this.tbD.clear();
            this.LCI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168959);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqw aqw = (aqw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqw.query = aVar3.UbS.readString();
                    AppMethodBeat.o(168959);
                    return 0;
                case 2:
                    aqw.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(168959);
                    return 0;
                case 3:
                    aqw.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168959);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        aqw.tbD.add(finderObject);
                    }
                    AppMethodBeat.o(168959);
                    return 0;
                case 5:
                    aqw.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(168959);
                    return 0;
                case 6:
                    aqw.LCH = aVar3.UbS.zi();
                    AppMethodBeat.o(168959);
                    return 0;
                case 7:
                    aqw.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(168959);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bbz bbz = new bbz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bbz.populateBuilderWithField(aVar5, bbz, a.getNextFieldNumber(aVar5))) {
                        }
                        aqw.LCI.add(bbz);
                    }
                    AppMethodBeat.o(168959);
                    return 0;
                default:
                    AppMethodBeat.o(168959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168959);
            return -1;
        }
    }
}
