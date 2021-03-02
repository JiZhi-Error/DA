package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class hz extends a {
    public ia KLV;
    public hx KLW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133148);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLV == null) {
                b bVar = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(133148);
                throw bVar;
            } else if (this.KLW == null) {
                b bVar2 = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(133148);
                throw bVar2;
            } else {
                if (this.KLV != null) {
                    aVar.ni(1, this.KLV.computeSize());
                    this.KLV.writeFields(aVar);
                }
                if (this.KLW != null) {
                    aVar.ni(2, this.KLW.computeSize());
                    this.KLW.writeFields(aVar);
                }
                AppMethodBeat.o(133148);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KLV != null ? g.a.a.a.nh(1, this.KLV.computeSize()) + 0 : 0;
            if (this.KLW != null) {
                nh += g.a.a.a.nh(2, this.KLW.computeSize());
            }
            AppMethodBeat.o(133148);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KLV == null) {
                b bVar3 = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(133148);
                throw bVar3;
            } else if (this.KLW == null) {
                b bVar4 = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(133148);
                throw bVar4;
            } else {
                AppMethodBeat.o(133148);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hz hzVar = (hz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ia iaVar = new ia();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iaVar.populateBuilderWithField(aVar4, iaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hzVar.KLV = iaVar;
                    }
                    AppMethodBeat.o(133148);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        hx hxVar = new hx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = hxVar.populateBuilderWithField(aVar5, hxVar, a.getNextFieldNumber(aVar5))) {
                        }
                        hzVar.KLW = hxVar;
                    }
                    AppMethodBeat.o(133148);
                    return 0;
                default:
                    AppMethodBeat.o(133148);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133148);
            return -1;
        }
    }
}
