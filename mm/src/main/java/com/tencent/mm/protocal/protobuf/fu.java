package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fu extends dop {
    public int KIJ;
    public int KIK;
    public int KIL;
    public int KJJ;
    public int KJK;
    public int KJL;
    public String openid;
    public int pTI;
    public int scene;
    public String session_id;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(177339);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.aM(5, this.KJJ);
            if (this.openid != null) {
                aVar.e(6, this.openid);
            }
            aVar.aM(7, this.KJK);
            aVar.aM(8, this.pTI);
            aVar.aM(9, this.KJL);
            aVar.aM(10, this.scene);
            aVar.aM(11, this.KIL);
            aVar.aM(12, this.KIK);
            aVar.aM(13, this.KIJ);
            if (this.session_id != null) {
                aVar.e(14, this.session_id);
            }
            AppMethodBeat.o(177339);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KJJ);
            if (this.openid != null) {
                bu += g.a.a.b.b.a.f(6, this.openid);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KJK) + g.a.a.b.b.a.bu(8, this.pTI) + g.a.a.b.b.a.bu(9, this.KJL) + g.a.a.b.b.a.bu(10, this.scene) + g.a.a.b.b.a.bu(11, this.KIL) + g.a.a.b.b.a.bu(12, this.KIK) + g.a.a.b.b.a.bu(13, this.KIJ);
            if (this.session_id != null) {
                bu2 += g.a.a.b.b.a.f(14, this.session_id);
            }
            AppMethodBeat.o(177339);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(177339);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fu fuVar = (fu) objArr[1];
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
                        fuVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(177339);
                    return 0;
                case 2:
                    fuVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(177339);
                    return 0;
                case 3:
                case 4:
                default:
                    AppMethodBeat.o(177339);
                    return -1;
                case 5:
                    fuVar.KJJ = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 6:
                    fuVar.openid = aVar3.UbS.readString();
                    AppMethodBeat.o(177339);
                    return 0;
                case 7:
                    fuVar.KJK = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 8:
                    fuVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 9:
                    fuVar.KJL = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 10:
                    fuVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 11:
                    fuVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 12:
                    fuVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 13:
                    fuVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(177339);
                    return 0;
                case 14:
                    fuVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(177339);
                    return 0;
            }
        } else {
            AppMethodBeat.o(177339);
            return -1;
        }
    }
}
