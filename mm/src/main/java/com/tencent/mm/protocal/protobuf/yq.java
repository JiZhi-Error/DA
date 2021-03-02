package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yq extends dop {
    public String LjI;
    public String LjJ;
    public String LjK;
    public String LjL;
    public String LjM;
    public long LjN;
    public String LjO;
    public String LjP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32161);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LjI != null) {
                aVar.e(2, this.LjI);
            }
            if (this.LjJ != null) {
                aVar.e(3, this.LjJ);
            }
            if (this.LjK != null) {
                aVar.e(4, this.LjK);
            }
            if (this.LjL != null) {
                aVar.e(5, this.LjL);
            }
            if (this.LjM != null) {
                aVar.e(6, this.LjM);
            }
            aVar.bb(7, this.LjN);
            if (this.LjO != null) {
                aVar.e(8, this.LjO);
            }
            if (this.LjP != null) {
                aVar.e(9, this.LjP);
            }
            AppMethodBeat.o(32161);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LjI != null) {
                nh += g.a.a.b.b.a.f(2, this.LjI);
            }
            if (this.LjJ != null) {
                nh += g.a.a.b.b.a.f(3, this.LjJ);
            }
            if (this.LjK != null) {
                nh += g.a.a.b.b.a.f(4, this.LjK);
            }
            if (this.LjL != null) {
                nh += g.a.a.b.b.a.f(5, this.LjL);
            }
            if (this.LjM != null) {
                nh += g.a.a.b.b.a.f(6, this.LjM);
            }
            int r = nh + g.a.a.b.b.a.r(7, this.LjN);
            if (this.LjO != null) {
                r += g.a.a.b.b.a.f(8, this.LjO);
            }
            if (this.LjP != null) {
                r += g.a.a.b.b.a.f(9, this.LjP);
            }
            AppMethodBeat.o(32161);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32161);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yq yqVar = (yq) objArr[1];
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
                        yqVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32161);
                    return 0;
                case 2:
                    yqVar.LjI = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 3:
                    yqVar.LjJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 4:
                    yqVar.LjK = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 5:
                    yqVar.LjL = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 6:
                    yqVar.LjM = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 7:
                    yqVar.LjN = aVar3.UbS.zl();
                    AppMethodBeat.o(32161);
                    return 0;
                case 8:
                    yqVar.LjO = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                case 9:
                    yqVar.LjP = aVar3.UbS.readString();
                    AppMethodBeat.o(32161);
                    return 0;
                default:
                    AppMethodBeat.o(32161);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32161);
            return -1;
        }
    }
}
