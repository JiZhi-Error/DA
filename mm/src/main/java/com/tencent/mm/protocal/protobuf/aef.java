package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aef extends dop {
    public String LjD;
    public String LjH;
    public String LpC;
    public long LpD;
    public int nHh;
    public String yPK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72466);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LpC != null) {
                aVar.e(2, this.LpC);
            }
            aVar.bb(3, this.LpD);
            if (this.LjD != null) {
                aVar.e(4, this.LjD);
            }
            if (this.LjH != null) {
                aVar.e(5, this.LjH);
            }
            aVar.aM(6, this.nHh);
            if (this.yPK != null) {
                aVar.e(7, this.yPK);
            }
            AppMethodBeat.o(72466);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LpC != null) {
                nh += g.a.a.b.b.a.f(2, this.LpC);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.LpD);
            if (this.LjD != null) {
                r += g.a.a.b.b.a.f(4, this.LjD);
            }
            if (this.LjH != null) {
                r += g.a.a.b.b.a.f(5, this.LjH);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.nHh);
            if (this.yPK != null) {
                bu += g.a.a.b.b.a.f(7, this.yPK);
            }
            AppMethodBeat.o(72466);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72466);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aef aef = (aef) objArr[1];
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
                        aef.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72466);
                    return 0;
                case 2:
                    aef.LpC = aVar3.UbS.readString();
                    AppMethodBeat.o(72466);
                    return 0;
                case 3:
                    aef.LpD = aVar3.UbS.zl();
                    AppMethodBeat.o(72466);
                    return 0;
                case 4:
                    aef.LjD = aVar3.UbS.readString();
                    AppMethodBeat.o(72466);
                    return 0;
                case 5:
                    aef.LjH = aVar3.UbS.readString();
                    AppMethodBeat.o(72466);
                    return 0;
                case 6:
                    aef.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(72466);
                    return 0;
                case 7:
                    aef.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(72466);
                    return 0;
                default:
                    AppMethodBeat.o(72466);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72466);
            return -1;
        }
    }
}
