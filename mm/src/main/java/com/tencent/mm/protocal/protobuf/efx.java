package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class efx extends a {
    public String KGX;
    public String Mmv;
    public feo NfS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153307);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mmv == null) {
                b bVar = new b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(153307);
                throw bVar;
            }
            if (this.Mmv != null) {
                aVar.e(1, this.Mmv);
            }
            if (this.NfS != null) {
                aVar.ni(2, this.NfS.computeSize());
                this.NfS.writeFields(aVar);
            }
            if (this.KGX != null) {
                aVar.e(3, this.KGX);
            }
            AppMethodBeat.o(153307);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mmv != null ? g.a.a.b.b.a.f(1, this.Mmv) + 0 : 0;
            if (this.NfS != null) {
                f2 += g.a.a.a.nh(2, this.NfS.computeSize());
            }
            if (this.KGX != null) {
                f2 += g.a.a.b.b.a.f(3, this.KGX);
            }
            AppMethodBeat.o(153307);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Mmv == null) {
                b bVar2 = new b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(153307);
                throw bVar2;
            }
            AppMethodBeat.o(153307);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efx efx = (efx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efx.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(153307);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        feo feo = new feo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = feo.populateBuilderWithField(aVar4, feo, a.getNextFieldNumber(aVar4))) {
                        }
                        efx.NfS = feo;
                    }
                    AppMethodBeat.o(153307);
                    return 0;
                case 3:
                    efx.KGX = aVar3.UbS.readString();
                    AppMethodBeat.o(153307);
                    return 0;
                default:
                    AppMethodBeat.o(153307);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153307);
            return -1;
        }
    }
}
