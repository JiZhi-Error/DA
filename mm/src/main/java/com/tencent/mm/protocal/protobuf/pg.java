package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class pg extends dop {
    public long KOx;
    public String KSV;
    public b KVZ;
    public int KWb;
    public int KWc;
    public int KWd;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124443);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KSV != null) {
                aVar.e(2, this.KSV);
            }
            aVar.aM(3, this.KWb);
            if (this.KVZ != null) {
                aVar.c(4, this.KVZ);
            }
            aVar.aM(5, this.KWc);
            aVar.bb(6, this.KOx);
            aVar.aM(7, this.KWd);
            aVar.aM(8, this.Scene);
            AppMethodBeat.o(124443);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KSV != null) {
                nh += g.a.a.b.b.a.f(2, this.KSV);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KWb);
            if (this.KVZ != null) {
                bu += g.a.a.b.b.a.b(4, this.KVZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KWc) + g.a.a.b.b.a.r(6, this.KOx) + g.a.a.b.b.a.bu(7, this.KWd) + g.a.a.b.b.a.bu(8, this.Scene);
            AppMethodBeat.o(124443);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124443);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pg pgVar = (pg) objArr[1];
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
                        pgVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124443);
                    return 0;
                case 2:
                    pgVar.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(124443);
                    return 0;
                case 3:
                    pgVar.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(124443);
                    return 0;
                case 4:
                    pgVar.KVZ = aVar3.UbS.hPo();
                    AppMethodBeat.o(124443);
                    return 0;
                case 5:
                    pgVar.KWc = aVar3.UbS.zi();
                    AppMethodBeat.o(124443);
                    return 0;
                case 6:
                    pgVar.KOx = aVar3.UbS.zl();
                    AppMethodBeat.o(124443);
                    return 0;
                case 7:
                    pgVar.KWd = aVar3.UbS.zi();
                    AppMethodBeat.o(124443);
                    return 0;
                case 8:
                    pgVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124443);
                    return 0;
                default:
                    AppMethodBeat.o(124443);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124443);
            return -1;
        }
    }
}
