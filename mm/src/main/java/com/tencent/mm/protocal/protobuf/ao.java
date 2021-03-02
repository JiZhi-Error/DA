package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ao extends dop {
    public String KDf;
    public String KDg;
    public int KDh;
    public LinkedList<um> KDk = new LinkedList<>();
    public int eaQ;

    public ao() {
        AppMethodBeat.i(113924);
        AppMethodBeat.o(113924);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113925);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KDk);
            aVar.aM(3, this.eaQ);
            if (this.KDf != null) {
                aVar.e(4, this.KDf);
            }
            if (this.KDg != null) {
                aVar.e(5, this.KDg);
            }
            aVar.aM(6, this.KDh);
            AppMethodBeat.o(113925);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KDk) + g.a.a.b.b.a.bu(3, this.eaQ);
            if (this.KDf != null) {
                nh += g.a.a.b.b.a.f(4, this.KDf);
            }
            if (this.KDg != null) {
                nh += g.a.a.b.b.a.f(5, this.KDg);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KDh);
            AppMethodBeat.o(113925);
            return bu;
        } else if (i2 == 2) {
            this.KDk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113925);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ao aoVar = (ao) objArr[1];
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
                        aoVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(113925);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        um umVar = new um();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = umVar.populateBuilderWithField(aVar5, umVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        aoVar.KDk.add(umVar);
                    }
                    AppMethodBeat.o(113925);
                    return 0;
                case 3:
                    aoVar.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(113925);
                    return 0;
                case 4:
                    aoVar.KDf = aVar3.UbS.readString();
                    AppMethodBeat.o(113925);
                    return 0;
                case 5:
                    aoVar.KDg = aVar3.UbS.readString();
                    AppMethodBeat.o(113925);
                    return 0;
                case 6:
                    aoVar.KDh = aVar3.UbS.zi();
                    AppMethodBeat.o(113925);
                    return 0;
                default:
                    AppMethodBeat.o(113925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113925);
            return -1;
        }
    }
}
