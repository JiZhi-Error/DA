package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wm extends dop {
    public int LhC;
    public String LhD;
    public int LhE;
    public b Lha;
    public String url;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200192);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LhC);
            aVar.aM(3, this.yRL);
            if (this.LhD != null) {
                aVar.e(4, this.LhD);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.aM(6, this.LhE);
            if (this.Lha != null) {
                aVar.c(7, this.Lha);
            }
            AppMethodBeat.o(200192);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LhC) + g.a.a.b.b.a.bu(3, this.yRL);
            if (this.LhD != null) {
                nh += g.a.a.b.b.a.f(4, this.LhD);
            }
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(5, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LhE);
            if (this.Lha != null) {
                bu += g.a.a.b.b.a.b(7, this.Lha);
            }
            AppMethodBeat.o(200192);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200192);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wm wmVar = (wm) objArr[1];
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
                        wmVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(200192);
                    return 0;
                case 2:
                    wmVar.LhC = aVar3.UbS.zi();
                    AppMethodBeat.o(200192);
                    return 0;
                case 3:
                    wmVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(200192);
                    return 0;
                case 4:
                    wmVar.LhD = aVar3.UbS.readString();
                    AppMethodBeat.o(200192);
                    return 0;
                case 5:
                    wmVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(200192);
                    return 0;
                case 6:
                    wmVar.LhE = aVar3.UbS.zi();
                    AppMethodBeat.o(200192);
                    return 0;
                case 7:
                    wmVar.Lha = aVar3.UbS.hPo();
                    AppMethodBeat.o(200192);
                    return 0;
                default:
                    AppMethodBeat.o(200192);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200192);
            return -1;
        }
    }
}
