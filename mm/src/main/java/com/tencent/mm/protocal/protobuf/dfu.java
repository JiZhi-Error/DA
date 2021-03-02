package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfu extends dop {
    public int LsZ;
    public long Lta;
    public String MKC;
    public int MKD;
    public int MKE;
    public long MKf;
    public long MKi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32390);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MKC == null) {
                b bVar = new b("Not all required fields were included: FromUsername");
                AppMethodBeat.o(32390);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MKC != null) {
                aVar.e(2, this.MKC);
            }
            aVar.aM(3, this.LsZ);
            aVar.bb(4, this.Lta);
            aVar.bb(5, this.MKf);
            aVar.aM(6, this.MKD);
            aVar.bb(7, this.MKi);
            aVar.aM(8, this.MKE);
            AppMethodBeat.o(32390);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta) + g.a.a.b.b.a.r(5, this.MKf) + g.a.a.b.b.a.bu(6, this.MKD) + g.a.a.b.b.a.r(7, this.MKi) + g.a.a.b.b.a.bu(8, this.MKE);
            AppMethodBeat.o(32390);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MKC == null) {
                b bVar2 = new b("Not all required fields were included: FromUsername");
                AppMethodBeat.o(32390);
                throw bVar2;
            }
            AppMethodBeat.o(32390);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfu dfu = (dfu) objArr[1];
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
                        dfu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32390);
                    return 0;
                case 2:
                    dfu.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(32390);
                    return 0;
                case 3:
                    dfu.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32390);
                    return 0;
                case 4:
                    dfu.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32390);
                    return 0;
                case 5:
                    dfu.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(32390);
                    return 0;
                case 6:
                    dfu.MKD = aVar3.UbS.zi();
                    AppMethodBeat.o(32390);
                    return 0;
                case 7:
                    dfu.MKi = aVar3.UbS.zl();
                    AppMethodBeat.o(32390);
                    return 0;
                case 8:
                    dfu.MKE = aVar3.UbS.zi();
                    AppMethodBeat.o(32390);
                    return 0;
                default:
                    AppMethodBeat.o(32390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32390);
            return -1;
        }
    }
}
