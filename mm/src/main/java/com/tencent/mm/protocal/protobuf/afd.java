package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class afd extends dop {
    public String KGO;
    public LinkedList<String> KGP = new LinkedList<>();

    public afd() {
        AppMethodBeat.i(138171);
        AppMethodBeat.o(138171);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(138172);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KGO == null) {
                b bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(138172);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KGO != null) {
                aVar.e(2, this.KGO);
            }
            aVar.e(3, 1, this.KGP);
            AppMethodBeat.o(138172);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KGO != null) {
                nh += g.a.a.b.b.a.f(2, this.KGO);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.KGP);
            AppMethodBeat.o(138172);
            return c2;
        } else if (i2 == 2) {
            this.KGP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KGO == null) {
                b bVar2 = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(138172);
                throw bVar2;
            }
            AppMethodBeat.o(138172);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            afd afd = (afd) objArr[1];
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
                        afd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(138172);
                    return 0;
                case 2:
                    afd.KGO = aVar3.UbS.readString();
                    AppMethodBeat.o(138172);
                    return 0;
                case 3:
                    afd.KGP.add(aVar3.UbS.readString());
                    AppMethodBeat.o(138172);
                    return 0;
                default:
                    AppMethodBeat.o(138172);
                    return -1;
            }
        } else {
            AppMethodBeat.o(138172);
            return -1;
        }
    }
}
