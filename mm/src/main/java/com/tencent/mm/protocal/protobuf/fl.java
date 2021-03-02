package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fl extends dop {
    public int KIJ;
    public int KIK;
    public int KIL;
    public long KIM;
    public int offset;
    public int pTI;
    public int scene;
    public String session_id;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103189);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.aM(4, this.offset);
            aVar.aM(6, this.pTI);
            aVar.aM(7, this.scene);
            aVar.aM(8, this.KIL);
            aVar.aM(9, this.KIK);
            aVar.aM(10, this.KIJ);
            if (this.session_id != null) {
                aVar.e(11, this.session_id);
            }
            aVar.bb(12, this.KIM);
            AppMethodBeat.o(103189);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.offset) + g.a.a.b.b.a.bu(6, this.pTI) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.KIL) + g.a.a.b.b.a.bu(9, this.KIK) + g.a.a.b.b.a.bu(10, this.KIJ);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(11, this.session_id);
            }
            int r = bu + g.a.a.b.b.a.r(12, this.KIM);
            AppMethodBeat.o(103189);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103189);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fl flVar = (fl) objArr[1];
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
                        flVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103189);
                    return 0;
                case 2:
                    flVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103189);
                    return 0;
                case 3:
                case 5:
                default:
                    AppMethodBeat.o(103189);
                    return -1;
                case 4:
                    flVar.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 6:
                    flVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 7:
                    flVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 8:
                    flVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 9:
                    flVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 10:
                    flVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103189);
                    return 0;
                case 11:
                    flVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103189);
                    return 0;
                case 12:
                    flVar.KIM = aVar3.UbS.zl();
                    AppMethodBeat.o(103189);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103189);
            return -1;
        }
    }
}
