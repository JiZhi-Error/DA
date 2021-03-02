package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bxb extends dop {
    public String rJH;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32278);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(32278);
                throw bVar;
            } else if (this.rJH == null) {
                b bVar2 = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(32278);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.username != null) {
                    aVar.e(2, this.username);
                }
                if (this.rJH != null) {
                    aVar.e(3, this.rJH);
                }
                AppMethodBeat.o(32278);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.rJH != null) {
                nh += g.a.a.b.b.a.f(3, this.rJH);
            }
            AppMethodBeat.o(32278);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar3 = new b("Not all required fields were included: username");
                AppMethodBeat.o(32278);
                throw bVar3;
            } else if (this.rJH == null) {
                b bVar4 = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(32278);
                throw bVar4;
            } else {
                AppMethodBeat.o(32278);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bxb bxb = (bxb) objArr[1];
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
                        bxb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32278);
                    return 0;
                case 2:
                    bxb.username = aVar3.UbS.readString();
                    AppMethodBeat.o(32278);
                    return 0;
                case 3:
                    bxb.rJH = aVar3.UbS.readString();
                    AppMethodBeat.o(32278);
                    return 0;
                default:
                    AppMethodBeat.o(32278);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32278);
            return -1;
        }
    }
}
