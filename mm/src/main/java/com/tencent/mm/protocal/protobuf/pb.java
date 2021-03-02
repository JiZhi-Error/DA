package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class pb extends dop {
    public int KND;
    public b KRc;
    public String KRf;
    public int KVV;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118407);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KRc != null) {
                aVar.c(2, this.KRc);
            }
            aVar.aM(3, this.source);
            aVar.aM(4, this.KVV);
            if (this.KRf != null) {
                aVar.e(5, this.KRf);
            }
            aVar.aM(6, this.KND);
            AppMethodBeat.o(118407);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KRc != null) {
                nh += g.a.a.b.b.a.b(2, this.KRc);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.bu(4, this.KVV);
            if (this.KRf != null) {
                bu += g.a.a.b.b.a.f(5, this.KRf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KND);
            AppMethodBeat.o(118407);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118407);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pb pbVar = (pb) objArr[1];
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
                        pbVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(118407);
                    return 0;
                case 2:
                    pbVar.KRc = aVar3.UbS.hPo();
                    AppMethodBeat.o(118407);
                    return 0;
                case 3:
                    pbVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(118407);
                    return 0;
                case 4:
                    pbVar.KVV = aVar3.UbS.zi();
                    AppMethodBeat.o(118407);
                    return 0;
                case 5:
                    pbVar.KRf = aVar3.UbS.readString();
                    AppMethodBeat.o(118407);
                    return 0;
                case 6:
                    pbVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(118407);
                    return 0;
                default:
                    AppMethodBeat.o(118407);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118407);
            return -1;
        }
    }
}
