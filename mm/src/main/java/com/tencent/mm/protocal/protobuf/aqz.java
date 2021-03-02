package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqz extends dop {
    public String LCL;
    public String LCM;
    public String clientId;
    public String url;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209386);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.clientId != null) {
                aVar.e(2, this.clientId);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.LCL != null) {
                aVar.e(4, this.LCL);
            }
            if (this.LCM != null) {
                aVar.e(5, this.LCM);
            }
            if (this.BaseRequest != null) {
                aVar.ni(6, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            AppMethodBeat.o(209386);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.clientId != null) {
                f2 += g.a.a.b.b.a.f(2, this.clientId);
            }
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.LCL != null) {
                f2 += g.a.a.b.b.a.f(4, this.LCL);
            }
            if (this.LCM != null) {
                f2 += g.a.a.b.b.a.f(5, this.LCM);
            }
            if (this.BaseRequest != null) {
                f2 += g.a.a.a.nh(6, this.BaseRequest.computeSize());
            }
            AppMethodBeat.o(209386);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209386);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqz aqz = (aqz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqz.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209386);
                    return 0;
                case 2:
                    aqz.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(209386);
                    return 0;
                case 3:
                    aqz.url = aVar3.UbS.readString();
                    AppMethodBeat.o(209386);
                    return 0;
                case 4:
                    aqz.LCL = aVar3.UbS.readString();
                    AppMethodBeat.o(209386);
                    return 0;
                case 5:
                    aqz.LCM = aVar3.UbS.readString();
                    AppMethodBeat.o(209386);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        aqz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209386);
                    return 0;
                default:
                    AppMethodBeat.o(209386);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209386);
            return -1;
        }
    }
}
