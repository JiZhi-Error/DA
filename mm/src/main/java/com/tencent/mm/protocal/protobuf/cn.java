package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cn extends dop {
    public b KGH;
    public int KGI;
    public String dNI;
    public String fileid;
    public String nickname;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152481);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.KGH != null) {
                aVar.c(3, this.KGH);
            }
            if (this.fileid != null) {
                aVar.e(4, this.fileid);
            }
            aVar.aM(5, this.KGI);
            if (this.dNI != null) {
                aVar.e(6, this.dNI);
            }
            AppMethodBeat.o(152481);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.nickname != null) {
                nh += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.KGH != null) {
                nh += g.a.a.b.b.a.b(3, this.KGH);
            }
            if (this.fileid != null) {
                nh += g.a.a.b.b.a.f(4, this.fileid);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KGI);
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(6, this.dNI);
            }
            AppMethodBeat.o(152481);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cn cnVar = (cn) objArr[1];
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
                        cnVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152481);
                    return 0;
                case 2:
                    cnVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(152481);
                    return 0;
                case 3:
                    cnVar.KGH = aVar3.UbS.hPo();
                    AppMethodBeat.o(152481);
                    return 0;
                case 4:
                    cnVar.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(152481);
                    return 0;
                case 5:
                    cnVar.KGI = aVar3.UbS.zi();
                    AppMethodBeat.o(152481);
                    return 0;
                case 6:
                    cnVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(152481);
                    return 0;
                default:
                    AppMethodBeat.o(152481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152481);
            return -1;
        }
    }
}
