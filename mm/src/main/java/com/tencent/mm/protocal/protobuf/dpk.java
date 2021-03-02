package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dpk extends dop {
    public int CreateTime;
    public String KIz;
    public int MSH;
    public int MSI;
    public int MSJ;
    public long MSK;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32415);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KIz != null) {
                aVar.e(2, this.KIz);
            }
            aVar.aM(3, this.MSH);
            aVar.aM(4, this.CreateTime);
            aVar.aM(5, this.MSI);
            if (this.xNH != null) {
                aVar.e(6, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(7, this.xNG);
            }
            aVar.aM(8, this.MSJ);
            aVar.bb(9, this.MSK);
            AppMethodBeat.o(32415);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KIz != null) {
                nh += g.a.a.b.b.a.f(2, this.KIz);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MSH) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MSI);
            if (this.xNH != null) {
                bu += g.a.a.b.b.a.f(6, this.xNH);
            }
            if (this.xNG != null) {
                bu += g.a.a.b.b.a.f(7, this.xNG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MSJ) + g.a.a.b.b.a.r(9, this.MSK);
            AppMethodBeat.o(32415);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32415);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpk dpk = (dpk) objArr[1];
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
                        dpk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32415);
                    return 0;
                case 2:
                    dpk.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(32415);
                    return 0;
                case 3:
                    dpk.MSH = aVar3.UbS.zi();
                    AppMethodBeat.o(32415);
                    return 0;
                case 4:
                    dpk.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(32415);
                    return 0;
                case 5:
                    dpk.MSI = aVar3.UbS.zi();
                    AppMethodBeat.o(32415);
                    return 0;
                case 6:
                    dpk.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32415);
                    return 0;
                case 7:
                    dpk.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32415);
                    return 0;
                case 8:
                    dpk.MSJ = aVar3.UbS.zi();
                    AppMethodBeat.o(32415);
                    return 0;
                case 9:
                    dpk.MSK = aVar3.UbS.zl();
                    AppMethodBeat.o(32415);
                    return 0;
                default:
                    AppMethodBeat.o(32415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32415);
            return -1;
        }
    }
}
