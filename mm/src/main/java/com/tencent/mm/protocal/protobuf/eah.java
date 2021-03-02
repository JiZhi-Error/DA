package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eah extends dop {
    public SKBuiltinBuffer_t KLQ;
    public int MZB;
    public LinkedList<eae> MZC = new LinkedList<>();

    public eah() {
        AppMethodBeat.i(125798);
        AppMethodBeat.o(125798);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125799);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MZB);
            aVar.e(3, 8, this.MZC);
            if (this.KLQ != null) {
                aVar.ni(4, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            AppMethodBeat.o(125799);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MZB) + g.a.a.a.c(3, 8, this.MZC);
            if (this.KLQ != null) {
                nh += g.a.a.a.nh(4, this.KLQ.computeSize());
            }
            AppMethodBeat.o(125799);
            return nh;
        } else if (i2 == 2) {
            this.MZC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eah eah = (eah) objArr[1];
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
                        eah.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125799);
                    return 0;
                case 2:
                    eah.MZB = aVar3.UbS.zi();
                    AppMethodBeat.o(125799);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eae eae = new eae();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eae.populateBuilderWithField(aVar5, eae, dop.getNextFieldNumber(aVar5))) {
                        }
                        eah.MZC.add(eae);
                    }
                    AppMethodBeat.o(125799);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        eah.KLQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125799);
                    return 0;
                default:
                    AppMethodBeat.o(125799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125799);
            return -1;
        }
    }
}
