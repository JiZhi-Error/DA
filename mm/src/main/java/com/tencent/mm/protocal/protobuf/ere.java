package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ere extends a {
    public LinkedList<cyk> MWl = new LinkedList<>();
    public String NoL;
    public String NoR;
    public String aPi;
    public int action;
    public int type;
    public String viewId;

    public ere() {
        AppMethodBeat.i(220729);
        AppMethodBeat.o(220729);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220730);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.viewId != null) {
                aVar.e(1, this.viewId);
            }
            aVar.aM(2, this.type);
            if (this.aPi != null) {
                aVar.e(3, this.aPi);
            }
            aVar.aM(4, this.action);
            aVar.e(5, 8, this.MWl);
            if (this.NoL != null) {
                aVar.e(6, this.NoL);
            }
            if (this.NoR != null) {
                aVar.e(7, this.NoR);
            }
            AppMethodBeat.o(220730);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.viewId != null ? g.a.a.b.b.a.f(1, this.viewId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.aPi != null) {
                f2 += g.a.a.b.b.a.f(3, this.aPi);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.action) + g.a.a.a.c(5, 8, this.MWl);
            if (this.NoL != null) {
                bu += g.a.a.b.b.a.f(6, this.NoL);
            }
            if (this.NoR != null) {
                bu += g.a.a.b.b.a.f(7, this.NoR);
            }
            AppMethodBeat.o(220730);
            return bu;
        } else if (i2 == 2) {
            this.MWl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220730);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ere ere = (ere) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ere.viewId = aVar3.UbS.readString();
                    AppMethodBeat.o(220730);
                    return 0;
                case 2:
                    ere.type = aVar3.UbS.zi();
                    AppMethodBeat.o(220730);
                    return 0;
                case 3:
                    ere.aPi = aVar3.UbS.readString();
                    AppMethodBeat.o(220730);
                    return 0;
                case 4:
                    ere.action = aVar3.UbS.zi();
                    AppMethodBeat.o(220730);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyk cyk = new cyk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyk.populateBuilderWithField(aVar4, cyk, a.getNextFieldNumber(aVar4))) {
                        }
                        ere.MWl.add(cyk);
                    }
                    AppMethodBeat.o(220730);
                    return 0;
                case 6:
                    ere.NoL = aVar3.UbS.readString();
                    AppMethodBeat.o(220730);
                    return 0;
                case 7:
                    ere.NoR = aVar3.UbS.readString();
                    AppMethodBeat.o(220730);
                    return 0;
                default:
                    AppMethodBeat.o(220730);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220730);
            return -1;
        }
    }
}
