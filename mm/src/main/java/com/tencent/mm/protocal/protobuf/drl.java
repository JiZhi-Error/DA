package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drl extends dop {
    public String category;
    public String mac;
    public String userName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32419);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.mac == null) {
                b bVar = new b("Not all required fields were included: mac");
                AppMethodBeat.o(32419);
                throw bVar;
            } else if (this.userName == null) {
                b bVar2 = new b("Not all required fields were included: userName");
                AppMethodBeat.o(32419);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.mac != null) {
                    aVar.e(2, this.mac);
                }
                if (this.userName != null) {
                    aVar.e(3, this.userName);
                }
                if (this.category != null) {
                    aVar.e(4, this.category);
                }
                AppMethodBeat.o(32419);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.mac != null) {
                nh += g.a.a.b.b.a.f(2, this.mac);
            }
            if (this.userName != null) {
                nh += g.a.a.b.b.a.f(3, this.userName);
            }
            if (this.category != null) {
                nh += g.a.a.b.b.a.f(4, this.category);
            }
            AppMethodBeat.o(32419);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.mac == null) {
                b bVar3 = new b("Not all required fields were included: mac");
                AppMethodBeat.o(32419);
                throw bVar3;
            } else if (this.userName == null) {
                b bVar4 = new b("Not all required fields were included: userName");
                AppMethodBeat.o(32419);
                throw bVar4;
            } else {
                AppMethodBeat.o(32419);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drl drl = (drl) objArr[1];
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
                        drl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32419);
                    return 0;
                case 2:
                    drl.mac = aVar3.UbS.readString();
                    AppMethodBeat.o(32419);
                    return 0;
                case 3:
                    drl.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(32419);
                    return 0;
                case 4:
                    drl.category = aVar3.UbS.readString();
                    AppMethodBeat.o(32419);
                    return 0;
                default:
                    AppMethodBeat.o(32419);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32419);
            return -1;
        }
    }
}
