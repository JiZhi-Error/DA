package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aij extends a {
    public LinkedList<aii> LrQ = new LinkedList<>();
    public String script;
    public String syg;
    public int syj;
    public int syk;
    public int syl;
    public int syn;
    public int syo;
    public int syp;
    public int syq;
    public String syr;
    public String sys;

    public aij() {
        AppMethodBeat.i(220691);
        AppMethodBeat.o(220691);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220692);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.syg != null) {
                aVar.e(1, this.syg);
            }
            aVar.aM(2, this.syj);
            aVar.aM(3, this.syk);
            aVar.aM(4, this.syl);
            aVar.e(5, 8, this.LrQ);
            aVar.aM(6, this.syn);
            aVar.aM(7, this.syq);
            if (this.script != null) {
                aVar.e(8, this.script);
            }
            if (this.syr != null) {
                aVar.e(9, this.syr);
            }
            aVar.aM(10, this.syp);
            aVar.aM(11, this.syo);
            if (this.sys != null) {
                aVar.e(12, this.sys);
            }
            AppMethodBeat.o(220692);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.syg != null ? g.a.a.b.b.a.f(1, this.syg) + 0 : 0) + g.a.a.b.b.a.bu(2, this.syj) + g.a.a.b.b.a.bu(3, this.syk) + g.a.a.b.b.a.bu(4, this.syl) + g.a.a.a.c(5, 8, this.LrQ) + g.a.a.b.b.a.bu(6, this.syn) + g.a.a.b.b.a.bu(7, this.syq);
            if (this.script != null) {
                f2 += g.a.a.b.b.a.f(8, this.script);
            }
            if (this.syr != null) {
                f2 += g.a.a.b.b.a.f(9, this.syr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(10, this.syp) + g.a.a.b.b.a.bu(11, this.syo);
            if (this.sys != null) {
                bu += g.a.a.b.b.a.f(12, this.sys);
            }
            AppMethodBeat.o(220692);
            return bu;
        } else if (i2 == 2) {
            this.LrQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220692);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aij aij = (aij) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aij.syg = aVar3.UbS.readString();
                    AppMethodBeat.o(220692);
                    return 0;
                case 2:
                    aij.syj = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 3:
                    aij.syk = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 4:
                    aij.syl = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aii aii = new aii();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aii.populateBuilderWithField(aVar4, aii, a.getNextFieldNumber(aVar4))) {
                        }
                        aij.LrQ.add(aii);
                    }
                    AppMethodBeat.o(220692);
                    return 0;
                case 6:
                    aij.syn = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 7:
                    aij.syq = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 8:
                    aij.script = aVar3.UbS.readString();
                    AppMethodBeat.o(220692);
                    return 0;
                case 9:
                    aij.syr = aVar3.UbS.readString();
                    AppMethodBeat.o(220692);
                    return 0;
                case 10:
                    aij.syp = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 11:
                    aij.syo = aVar3.UbS.zi();
                    AppMethodBeat.o(220692);
                    return 0;
                case 12:
                    aij.sys = aVar3.UbS.readString();
                    AppMethodBeat.o(220692);
                    return 0;
                default:
                    AppMethodBeat.o(220692);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220692);
            return -1;
        }
    }
}
