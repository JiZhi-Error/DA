package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fw extends dop {
    public int KIJ;
    public int KIK;
    public int KIL;
    public String KJM;
    public int pTI;
    public String request_id;
    public int scene;
    public String session_id;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103197);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.request_id != null) {
                aVar.e(3, this.request_id);
            }
            if (this.KJM != null) {
                aVar.e(4, this.KJM);
            }
            aVar.aM(5, this.scene);
            aVar.aM(6, this.KIL);
            aVar.aM(7, this.KIK);
            aVar.aM(8, this.pTI);
            aVar.aM(10, this.KIJ);
            if (this.session_id != null) {
                aVar.e(11, this.session_id);
            }
            AppMethodBeat.o(103197);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.request_id != null) {
                nh += g.a.a.b.b.a.f(3, this.request_id);
            }
            if (this.KJM != null) {
                nh += g.a.a.b.b.a.f(4, this.KJM);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.scene) + g.a.a.b.b.a.bu(6, this.KIL) + g.a.a.b.b.a.bu(7, this.KIK) + g.a.a.b.b.a.bu(8, this.pTI) + g.a.a.b.b.a.bu(10, this.KIJ);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(11, this.session_id);
            }
            AppMethodBeat.o(103197);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103197);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fw fwVar = (fw) objArr[1];
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
                        fwVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103197);
                    return 0;
                case 2:
                    fwVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103197);
                    return 0;
                case 3:
                    fwVar.request_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103197);
                    return 0;
                case 4:
                    fwVar.KJM = aVar3.UbS.readString();
                    AppMethodBeat.o(103197);
                    return 0;
                case 5:
                    fwVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103197);
                    return 0;
                case 6:
                    fwVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(103197);
                    return 0;
                case 7:
                    fwVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103197);
                    return 0;
                case 8:
                    fwVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(103197);
                    return 0;
                case 9:
                default:
                    AppMethodBeat.o(103197);
                    return -1;
                case 10:
                    fwVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103197);
                    return 0;
                case 11:
                    fwVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103197);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103197);
            return -1;
        }
    }
}
