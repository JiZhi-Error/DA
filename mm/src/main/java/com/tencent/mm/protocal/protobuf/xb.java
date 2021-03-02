package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class xb extends dop {
    public String KFI;
    public String Lih;
    public boolean Lii;
    public int Lij;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125716);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KFI != null) {
                aVar.e(2, this.KFI);
            }
            if (this.Lih != null) {
                aVar.e(3, this.Lih);
            }
            aVar.cc(4, this.Lii);
            aVar.aM(5, this.Lij);
            AppMethodBeat.o(125716);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KFI != null) {
                nh += g.a.a.b.b.a.f(2, this.KFI);
            }
            if (this.Lih != null) {
                nh += g.a.a.b.b.a.f(3, this.Lih);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.Lij);
            AppMethodBeat.o(125716);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xb xbVar = (xb) objArr[1];
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
                        xbVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125716);
                    return 0;
                case 2:
                    xbVar.KFI = aVar3.UbS.readString();
                    AppMethodBeat.o(125716);
                    return 0;
                case 3:
                    xbVar.Lih = aVar3.UbS.readString();
                    AppMethodBeat.o(125716);
                    return 0;
                case 4:
                    xbVar.Lii = aVar3.UbS.yZ();
                    AppMethodBeat.o(125716);
                    return 0;
                case 5:
                    xbVar.Lij = aVar3.UbS.zi();
                    AppMethodBeat.o(125716);
                    return 0;
                default:
                    AppMethodBeat.o(125716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125716);
            return -1;
        }
    }
}
