package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkn extends dop {
    public long LdA;
    public String Ldn;
    public int Leq;
    public double latitude;
    public double longitude;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114015);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Ldn != null) {
                aVar.e(2, this.Ldn);
            }
            aVar.e(3, this.latitude);
            aVar.e(4, this.longitude);
            aVar.bb(5, this.LdA);
            aVar.aM(6, this.Leq);
            aVar.aM(7, this.scene);
            AppMethodBeat.o(114015);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Ldn != null) {
                nh += g.a.a.b.b.a.f(2, this.Ldn);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.fS(4) + 8 + g.a.a.b.b.a.r(5, this.LdA) + g.a.a.b.b.a.bu(6, this.Leq) + g.a.a.b.b.a.bu(7, this.scene);
            AppMethodBeat.o(114015);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114015);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkn bkn = (bkn) objArr[1];
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
                        bkn.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114015);
                    return 0;
                case 2:
                    bkn.Ldn = aVar3.UbS.readString();
                    AppMethodBeat.o(114015);
                    return 0;
                case 3:
                    bkn.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(114015);
                    return 0;
                case 4:
                    bkn.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(114015);
                    return 0;
                case 5:
                    bkn.LdA = aVar3.UbS.zl();
                    AppMethodBeat.o(114015);
                    return 0;
                case 6:
                    bkn.Leq = aVar3.UbS.zi();
                    AppMethodBeat.o(114015);
                    return 0;
                case 7:
                    bkn.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(114015);
                    return 0;
                default:
                    AppMethodBeat.o(114015);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114015);
            return -1;
        }
    }
}
