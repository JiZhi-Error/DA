package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fy extends dop {
    public int KIJ;
    public int KIK;
    public int KIL;
    public long KIM;
    public int KJJ;
    public int KJL;
    public long KJO;
    public String content;
    public int pTI;
    public int scene;
    public String session_id;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103199);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.bb(5, this.KJO);
            aVar.aM(6, this.pTI);
            aVar.aM(7, this.KJJ);
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            aVar.aM(9, this.scene);
            aVar.aM(10, this.KIL);
            aVar.aM(11, this.KIK);
            aVar.aM(12, this.KIJ);
            if (this.session_id != null) {
                aVar.e(13, this.session_id);
            }
            aVar.bb(14, this.KIM);
            aVar.aM(15, this.KJL);
            AppMethodBeat.o(103199);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.content != null) {
                nh += g.a.a.b.b.a.f(4, this.content);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.KJO) + g.a.a.b.b.a.bu(6, this.pTI) + g.a.a.b.b.a.bu(7, this.KJJ);
            if (this.title != null) {
                r += g.a.a.b.b.a.f(8, this.title);
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.scene) + g.a.a.b.b.a.bu(10, this.KIL) + g.a.a.b.b.a.bu(11, this.KIK) + g.a.a.b.b.a.bu(12, this.KIJ);
            if (this.session_id != null) {
                bu += g.a.a.b.b.a.f(13, this.session_id);
            }
            int r2 = bu + g.a.a.b.b.a.r(14, this.KIM) + g.a.a.b.b.a.bu(15, this.KJL);
            AppMethodBeat.o(103199);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103199);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fy fyVar = (fy) objArr[1];
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
                        fyVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103199);
                    return 0;
                case 2:
                    fyVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103199);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(103199);
                    return -1;
                case 4:
                    fyVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(103199);
                    return 0;
                case 5:
                    fyVar.KJO = aVar3.UbS.zl();
                    AppMethodBeat.o(103199);
                    return 0;
                case 6:
                    fyVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 7:
                    fyVar.KJJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 8:
                    fyVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(103199);
                    return 0;
                case 9:
                    fyVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 10:
                    fyVar.KIL = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 11:
                    fyVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 12:
                    fyVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
                case 13:
                    fyVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103199);
                    return 0;
                case 14:
                    fyVar.KIM = aVar3.UbS.zl();
                    AppMethodBeat.o(103199);
                    return 0;
                case 15:
                    fyVar.KJL = aVar3.UbS.zi();
                    AppMethodBeat.o(103199);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103199);
            return -1;
        }
    }
}
