package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ahx extends dop {
    public int Brl;
    public long Brn;
    public String KGO;
    public String KIz;
    public int KUy;
    public int KZk;
    public long LrE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148652);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            aVar.aM(1, this.Brl);
            aVar.aM(2, this.KZk);
            aVar.aM(3, this.KUy);
            if (this.KIz != null) {
                aVar.e(4, this.KIz);
            }
            if (this.BaseRequest != null) {
                aVar.ni(5, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(6, this.Brn);
            if (this.KGO != null) {
                aVar.e(7, this.KGO);
            }
            aVar.bb(8, this.LrE);
            AppMethodBeat.o(148652);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brl) + 0 + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.KUy);
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(4, this.KIz);
            }
            if (this.BaseRequest != null) {
                bu += g.a.a.a.nh(5, this.BaseRequest.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.Brn);
            if (this.KGO != null) {
                r += g.a.a.b.b.a.f(7, this.KGO);
            }
            int r2 = r + g.a.a.b.b.a.r(8, this.LrE);
            AppMethodBeat.o(148652);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(148652);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahx ahx = (ahx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahx.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(148652);
                    return 0;
                case 2:
                    ahx.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148652);
                    return 0;
                case 3:
                    ahx.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(148652);
                    return 0;
                case 4:
                    ahx.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(148652);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ahx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148652);
                    return 0;
                case 6:
                    ahx.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(148652);
                    return 0;
                case 7:
                    ahx.KGO = aVar3.UbS.readString();
                    AppMethodBeat.o(148652);
                    return 0;
                case 8:
                    ahx.LrE = aVar3.UbS.zl();
                    AppMethodBeat.o(148652);
                    return 0;
                default:
                    AppMethodBeat.o(148652);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148652);
            return -1;
        }
    }
}
