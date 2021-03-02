package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ewr extends a {
    public SKBuiltinBuffer_t KQA;
    public String KQw;
    public String KQx;
    public String Num;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133206);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KQA == null) {
                b bVar = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(133206);
                throw bVar;
            }
            if (this.KQw != null) {
                aVar.e(1, this.KQw);
            }
            if (this.KQx != null) {
                aVar.e(2, this.KQx);
            }
            if (this.Num != null) {
                aVar.e(3, this.Num);
            }
            if (this.KQA != null) {
                aVar.ni(4, this.KQA.computeSize());
                this.KQA.writeFields(aVar);
            }
            AppMethodBeat.o(133206);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KQw != null ? g.a.a.b.b.a.f(1, this.KQw) + 0 : 0;
            if (this.KQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.KQx);
            }
            if (this.Num != null) {
                f2 += g.a.a.b.b.a.f(3, this.Num);
            }
            if (this.KQA != null) {
                f2 += g.a.a.a.nh(4, this.KQA.computeSize());
            }
            AppMethodBeat.o(133206);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KQA == null) {
                b bVar2 = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(133206);
                throw bVar2;
            }
            AppMethodBeat.o(133206);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewr ewr = (ewr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ewr.KQw = aVar3.UbS.readString();
                    AppMethodBeat.o(133206);
                    return 0;
                case 2:
                    ewr.KQx = aVar3.UbS.readString();
                    AppMethodBeat.o(133206);
                    return 0;
                case 3:
                    ewr.Num = aVar3.UbS.readString();
                    AppMethodBeat.o(133206);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ewr.KQA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133206);
                    return 0;
                default:
                    AppMethodBeat.o(133206);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133206);
            return -1;
        }
    }
}
