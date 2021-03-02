package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpf extends dop {
    public String Lso;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104805);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lso == null) {
                b bVar = new b("Not all required fields were included: LensId");
                AppMethodBeat.o(104805);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lso != null) {
                aVar.e(2, this.Lso);
            }
            AppMethodBeat.o(104805);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lso != null) {
                nh += g.a.a.b.b.a.f(2, this.Lso);
            }
            AppMethodBeat.o(104805);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lso == null) {
                b bVar2 = new b("Not all required fields were included: LensId");
                AppMethodBeat.o(104805);
                throw bVar2;
            }
            AppMethodBeat.o(104805);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpf bpf = (bpf) objArr[1];
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
                        bpf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104805);
                    return 0;
                case 2:
                    bpf.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104805);
                    return 0;
                default:
                    AppMethodBeat.o(104805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104805);
            return -1;
        }
    }
}
