package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mz extends dop {
    public int KND;
    public long KRC;
    public String KRD;
    public String KRE;
    public long KRi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212227);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.KRC);
            if (this.KRD != null) {
                aVar.e(4, this.KRD);
            }
            if (this.KRE != null) {
                aVar.e(5, this.KRE);
            }
            aVar.bb(18, this.KRi);
            aVar.aM(22, this.KND);
            AppMethodBeat.o(212227);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.KRC);
            if (this.KRD != null) {
                nh += g.a.a.b.b.a.f(4, this.KRD);
            }
            if (this.KRE != null) {
                nh += g.a.a.b.b.a.f(5, this.KRE);
            }
            int r = nh + g.a.a.b.b.a.r(18, this.KRi) + g.a.a.b.b.a.bu(22, this.KND);
            AppMethodBeat.o(212227);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212227);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mz mzVar = (mz) objArr[1];
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
                        mzVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(212227);
                    return 0;
                case 2:
                    mzVar.KRC = aVar3.UbS.zl();
                    AppMethodBeat.o(212227);
                    return 0;
                case 4:
                    mzVar.KRD = aVar3.UbS.readString();
                    AppMethodBeat.o(212227);
                    return 0;
                case 5:
                    mzVar.KRE = aVar3.UbS.readString();
                    AppMethodBeat.o(212227);
                    return 0;
                case 18:
                    mzVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(212227);
                    return 0;
                case 22:
                    mzVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(212227);
                    return 0;
                default:
                    AppMethodBeat.o(212227);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212227);
            return -1;
        }
    }
}
