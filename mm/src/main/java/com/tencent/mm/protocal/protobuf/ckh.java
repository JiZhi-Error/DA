package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ckh extends a {
    public int KQy;
    public SKBuiltinBuffer_t MpF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(232379);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MpF == null) {
                b bVar = new b("Not all required fields were included: NotifyData");
                AppMethodBeat.o(232379);
                throw bVar;
            }
            if (this.MpF != null) {
                aVar.ni(1, this.MpF.computeSize());
                this.MpF.writeFields(aVar);
            }
            aVar.aM(2, this.KQy);
            AppMethodBeat.o(232379);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MpF != null ? g.a.a.a.nh(1, this.MpF.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KQy);
            AppMethodBeat.o(232379);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MpF == null) {
                b bVar2 = new b("Not all required fields were included: NotifyData");
                AppMethodBeat.o(232379);
                throw bVar2;
            }
            AppMethodBeat.o(232379);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckh ckh = (ckh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ckh.MpF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(232379);
                    return 0;
                case 2:
                    ckh.KQy = aVar3.UbS.zi();
                    AppMethodBeat.o(232379);
                    return 0;
                default:
                    AppMethodBeat.o(232379);
                    return -1;
            }
        } else {
            AppMethodBeat.o(232379);
            return -1;
        }
    }
}
