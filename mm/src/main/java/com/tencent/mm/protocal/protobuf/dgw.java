package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dgw extends dop {
    public long MLr;
    public long MLs;
    public long offset;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91638);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.MLr);
            aVar.bb(3, this.offset);
            aVar.bb(4, this.MLs);
            AppMethodBeat.o(91638);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.MLr) + g.a.a.b.b.a.r(3, this.offset) + g.a.a.b.b.a.r(4, this.MLs);
            AppMethodBeat.o(91638);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91638);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgw dgw = (dgw) objArr[1];
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
                        dgw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91638);
                    return 0;
                case 2:
                    dgw.MLr = aVar3.UbS.zl();
                    AppMethodBeat.o(91638);
                    return 0;
                case 3:
                    dgw.offset = aVar3.UbS.zl();
                    AppMethodBeat.o(91638);
                    return 0;
                case 4:
                    dgw.MLs = aVar3.UbS.zl();
                    AppMethodBeat.o(91638);
                    return 0;
                default:
                    AppMethodBeat.o(91638);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91638);
            return -1;
        }
    }
}
