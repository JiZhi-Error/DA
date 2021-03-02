package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cnm extends dop {
    public String LOd;
    public cnh MtV;
    public String MtW;
    public int scene;
    public long twJ;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209740);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MtV != null) {
                aVar.ni(2, this.MtV.computeSize());
                this.MtV.writeFields(aVar);
            }
            aVar.bb(3, this.twJ);
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            if (this.LOd != null) {
                aVar.e(5, this.LOd);
            }
            if (this.MtW != null) {
                aVar.e(6, this.MtW);
            }
            aVar.aM(7, this.scene);
            AppMethodBeat.o(209740);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MtV != null) {
                nh += g.a.a.a.nh(2, this.MtV.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(3, this.twJ);
            if (this.username != null) {
                r += g.a.a.b.b.a.f(4, this.username);
            }
            if (this.LOd != null) {
                r += g.a.a.b.b.a.f(5, this.LOd);
            }
            if (this.MtW != null) {
                r += g.a.a.b.b.a.f(6, this.MtW);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.scene);
            AppMethodBeat.o(209740);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209740);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnm cnm = (cnm) objArr[1];
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
                        cnm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209740);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cnh cnh = new cnh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cnh.populateBuilderWithField(aVar5, cnh, dop.getNextFieldNumber(aVar5))) {
                        }
                        cnm.MtV = cnh;
                    }
                    AppMethodBeat.o(209740);
                    return 0;
                case 3:
                    cnm.twJ = aVar3.UbS.zl();
                    AppMethodBeat.o(209740);
                    return 0;
                case 4:
                    cnm.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209740);
                    return 0;
                case 5:
                    cnm.LOd = aVar3.UbS.readString();
                    AppMethodBeat.o(209740);
                    return 0;
                case 6:
                    cnm.MtW = aVar3.UbS.readString();
                    AppMethodBeat.o(209740);
                    return 0;
                case 7:
                    cnm.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209740);
                    return 0;
                default:
                    AppMethodBeat.o(209740);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209740);
            return -1;
        }
    }
}
