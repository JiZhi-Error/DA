package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ala extends dop {
    public String KEb;
    public String KQa;
    public String KQf;
    public int LtW;
    public int LtX;
    public String LtY;
    public String LtZ;
    public String Lua;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256407);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.KEb != null) {
                aVar.e(3, this.KEb);
            }
            aVar.aM(4, this.LtW);
            aVar.aM(5, this.LtX);
            if (this.KQa != null) {
                aVar.e(6, this.KQa);
            }
            if (this.LtY != null) {
                aVar.e(7, this.LtY);
            }
            if (this.KQf != null) {
                aVar.e(8, this.KQf);
            }
            if (this.LtZ != null) {
                aVar.e(9, this.LtZ);
            }
            if (this.Lua != null) {
                aVar.e(10, this.Lua);
            }
            AppMethodBeat.o(256407);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.oUJ != null) {
                nh += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.KEb != null) {
                nh += g.a.a.b.b.a.f(3, this.KEb);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LtW) + g.a.a.b.b.a.bu(5, this.LtX);
            if (this.KQa != null) {
                bu += g.a.a.b.b.a.f(6, this.KQa);
            }
            if (this.LtY != null) {
                bu += g.a.a.b.b.a.f(7, this.LtY);
            }
            if (this.KQf != null) {
                bu += g.a.a.b.b.a.f(8, this.KQf);
            }
            if (this.LtZ != null) {
                bu += g.a.a.b.b.a.f(9, this.LtZ);
            }
            if (this.Lua != null) {
                bu += g.a.a.b.b.a.f(10, this.Lua);
            }
            AppMethodBeat.o(256407);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256407);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ala ala = (ala) objArr[1];
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
                        ala.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(256407);
                    return 0;
                case 2:
                    ala.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 3:
                    ala.KEb = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 4:
                    ala.LtW = aVar3.UbS.zi();
                    AppMethodBeat.o(256407);
                    return 0;
                case 5:
                    ala.LtX = aVar3.UbS.zi();
                    AppMethodBeat.o(256407);
                    return 0;
                case 6:
                    ala.KQa = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 7:
                    ala.LtY = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 8:
                    ala.KQf = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 9:
                    ala.LtZ = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                case 10:
                    ala.Lua = aVar3.UbS.readString();
                    AppMethodBeat.o(256407);
                    return 0;
                default:
                    AppMethodBeat.o(256407);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256407);
            return -1;
        }
    }
}
