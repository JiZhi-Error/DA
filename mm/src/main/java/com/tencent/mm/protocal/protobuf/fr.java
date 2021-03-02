package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fr extends dop {
    public int KIJ;
    public int KIK;
    public int KIL;
    public int scene;
    public String session_id;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103193);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.aM(3, this.scene);
            aVar.aM(4, this.KIL);
            aVar.aM(5, this.KIK);
            aVar.aM(6, this.KIJ);
            if (this.session_id != null) {
                aVar.e(7, this.session_id);
            }
            AppMethodBeat.o(103193);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.KIL) + g.a.a.b.b.a.bu(5, this.KIK) + g.a.a.b.b.a.bu(6, this.KIJ);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(7, this.session_id);
            }
            AppMethodBeat.o(103193);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103193);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fr frVar = (fr) objArr[1];
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
                        frVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103193);
                    return 0;
                case 2:
                    frVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103193);
                    return 0;
                case 3:
                    frVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103193);
                    return 0;
                case 4:
                    frVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(103193);
                    return 0;
                case 5:
                    frVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103193);
                    return 0;
                case 6:
                    frVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103193);
                    return 0;
                case 7:
                    frVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103193);
                    return 0;
                default:
                    AppMethodBeat.o(103193);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103193);
            return -1;
        }
    }
}
