package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class lv extends dop {
    public String IaW;
    public String KPu;
    public String KPv;
    public String KPw;
    public int dUS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72422);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KPu != null) {
                aVar.e(2, this.KPu);
            }
            if (this.KPv != null) {
                aVar.e(3, this.KPv);
            }
            if (this.IaW != null) {
                aVar.e(4, this.IaW);
            }
            if (this.KPw != null) {
                aVar.e(5, this.KPw);
            }
            aVar.aM(7, this.dUS);
            AppMethodBeat.o(72422);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPu != null) {
                nh += g.a.a.b.b.a.f(2, this.KPu);
            }
            if (this.KPv != null) {
                nh += g.a.a.b.b.a.f(3, this.KPv);
            }
            if (this.IaW != null) {
                nh += g.a.a.b.b.a.f(4, this.IaW);
            }
            if (this.KPw != null) {
                nh += g.a.a.b.b.a.f(5, this.KPw);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.dUS);
            AppMethodBeat.o(72422);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72422);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            lv lvVar = (lv) objArr[1];
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
                        lvVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72422);
                    return 0;
                case 2:
                    lvVar.KPu = aVar3.UbS.readString();
                    AppMethodBeat.o(72422);
                    return 0;
                case 3:
                    lvVar.KPv = aVar3.UbS.readString();
                    AppMethodBeat.o(72422);
                    return 0;
                case 4:
                    lvVar.IaW = aVar3.UbS.readString();
                    AppMethodBeat.o(72422);
                    return 0;
                case 5:
                    lvVar.KPw = aVar3.UbS.readString();
                    AppMethodBeat.o(72422);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(72422);
                    return -1;
                case 7:
                    lvVar.dUS = aVar3.UbS.zi();
                    AppMethodBeat.o(72422);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72422);
            return -1;
        }
    }
}
