package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bny extends dop {
    public int BsF;
    public int BsG;
    public int LWm;
    public int LWn;
    public String LWo;
    public int LWp;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152570);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            aVar.aM(3, this.LWm);
            aVar.aM(4, this.LWn);
            if (this.LWo != null) {
                aVar.e(5, this.LWo);
            }
            aVar.aM(6, this.BsF);
            aVar.aM(7, this.BsG);
            aVar.aM(8, this.LWp);
            AppMethodBeat.o(152570);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LWm) + g.a.a.b.b.a.bu(4, this.LWn);
            if (this.LWo != null) {
                bu += g.a.a.b.b.a.f(5, this.LWo);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.LWp);
            AppMethodBeat.o(152570);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152570);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bny bny = (bny) objArr[1];
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
                        bny.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152570);
                    return 0;
                case 2:
                    bny.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152570);
                    return 0;
                case 3:
                    bny.LWm = aVar3.UbS.zi();
                    AppMethodBeat.o(152570);
                    return 0;
                case 4:
                    bny.LWn = aVar3.UbS.zi();
                    AppMethodBeat.o(152570);
                    return 0;
                case 5:
                    bny.LWo = aVar3.UbS.readString();
                    AppMethodBeat.o(152570);
                    return 0;
                case 6:
                    bny.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152570);
                    return 0;
                case 7:
                    bny.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152570);
                    return 0;
                case 8:
                    bny.LWp = aVar3.UbS.zi();
                    AppMethodBeat.o(152570);
                    return 0;
                default:
                    AppMethodBeat.o(152570);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152570);
            return -1;
        }
    }
}
