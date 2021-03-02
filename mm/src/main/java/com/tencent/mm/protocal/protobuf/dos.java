package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dos extends dop {
    public int KBv;
    public long MBH;
    public int MRV;
    public int MRW;
    public String dNI;
    public int yPJ;
    public String yPK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91671);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.aM(3, this.yPJ);
            aVar.aM(4, this.KBv);
            aVar.bb(5, this.MBH);
            aVar.aM(6, this.MRV);
            if (this.yPK != null) {
                aVar.e(7, this.yPK);
            }
            aVar.aM(8, this.MRW);
            AppMethodBeat.o(91671);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.yPJ) + g.a.a.b.b.a.bu(4, this.KBv) + g.a.a.b.b.a.r(5, this.MBH) + g.a.a.b.b.a.bu(6, this.MRV);
            if (this.yPK != null) {
                bu += g.a.a.b.b.a.f(7, this.yPK);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MRW);
            AppMethodBeat.o(91671);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91671);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dos dos = (dos) objArr[1];
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
                        dos.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91671);
                    return 0;
                case 2:
                    dos.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(91671);
                    return 0;
                case 3:
                    dos.yPJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91671);
                    return 0;
                case 4:
                    dos.KBv = aVar3.UbS.zi();
                    AppMethodBeat.o(91671);
                    return 0;
                case 5:
                    dos.MBH = aVar3.UbS.zl();
                    AppMethodBeat.o(91671);
                    return 0;
                case 6:
                    dos.MRV = aVar3.UbS.zi();
                    AppMethodBeat.o(91671);
                    return 0;
                case 7:
                    dos.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(91671);
                    return 0;
                case 8:
                    dos.MRW = aVar3.UbS.zi();
                    AppMethodBeat.o(91671);
                    return 0;
                default:
                    AppMethodBeat.o(91671);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91671);
            return -1;
        }
    }
}
