package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class xt extends dop {
    public int KKA;
    public long KMg;
    public String KMh;
    public String LbJ;
    public String xNG;
    public String xNH;
    public String xuB;
    public String xuz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(9586);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xNH != null) {
                aVar.e(2, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(3, this.xNG);
            }
            aVar.bb(4, this.KMg);
            if (this.LbJ != null) {
                aVar.e(5, this.LbJ);
            }
            if (this.xuB != null) {
                aVar.e(6, this.xuB);
            }
            aVar.aM(7, this.KKA);
            if (this.KMh != null) {
                aVar.e(8, this.KMh);
            }
            if (this.xuz != null) {
                aVar.e(9, this.xuz);
            }
            AppMethodBeat.o(9586);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(2, this.xNH);
            }
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(3, this.xNG);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.KMg);
            if (this.LbJ != null) {
                r += g.a.a.b.b.a.f(5, this.LbJ);
            }
            if (this.xuB != null) {
                r += g.a.a.b.b.a.f(6, this.xuB);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.KKA);
            if (this.KMh != null) {
                bu += g.a.a.b.b.a.f(8, this.KMh);
            }
            if (this.xuz != null) {
                bu += g.a.a.b.b.a.f(9, this.xuz);
            }
            AppMethodBeat.o(9586);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(9586);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xt xtVar = (xt) objArr[1];
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
                        xtVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(9586);
                    return 0;
                case 2:
                    xtVar.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                case 3:
                    xtVar.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                case 4:
                    xtVar.KMg = aVar3.UbS.zl();
                    AppMethodBeat.o(9586);
                    return 0;
                case 5:
                    xtVar.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                case 6:
                    xtVar.xuB = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                case 7:
                    xtVar.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(9586);
                    return 0;
                case 8:
                    xtVar.KMh = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                case 9:
                    xtVar.xuz = aVar3.UbS.readString();
                    AppMethodBeat.o(9586);
                    return 0;
                default:
                    AppMethodBeat.o(9586);
                    return -1;
            }
        } else {
            AppMethodBeat.o(9586);
            return -1;
        }
    }
}
