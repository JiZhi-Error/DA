package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ems extends dop {
    public int KXC;
    public int NkO;
    public int NkP;
    public int NkQ;
    public int bDZ;
    public int scene;
    public String session_id;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123664);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.scene);
            aVar.aM(3, this.NkO);
            aVar.aM(4, this.KXC);
            aVar.aM(5, this.NkP);
            aVar.aM(6, this.NkQ);
            if (this.username != null) {
                aVar.e(7, this.username);
            }
            aVar.aM(8, this.bDZ);
            if (this.session_id != null) {
                aVar.e(9, this.session_id);
            }
            AppMethodBeat.o(123664);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.NkO) + g.a.a.b.b.a.bu(4, this.KXC) + g.a.a.b.b.a.bu(5, this.NkP) + g.a.a.b.b.a.bu(6, this.NkQ);
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(7, this.username);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.bDZ);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(9, this.session_id);
            }
            AppMethodBeat.o(123664);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123664);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ems ems = (ems) objArr[1];
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
                        ems.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123664);
                    return 0;
                case 2:
                    ems.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 3:
                    ems.NkO = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 4:
                    ems.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 5:
                    ems.NkP = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 6:
                    ems.NkQ = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 7:
                    ems.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123664);
                    return 0;
                case 8:
                    ems.bDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123664);
                    return 0;
                case 9:
                    ems.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(123664);
                    return 0;
                default:
                    AppMethodBeat.o(123664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123664);
            return -1;
        }
    }
}
