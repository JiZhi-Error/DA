package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dzx extends a {
    public int CreateTime;
    public SKBuiltinBuffer_t MYW;
    public String Username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125786);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MYW == null) {
                b bVar = new b("Not all required fields were included: HBBuffer");
                AppMethodBeat.o(125786);
                throw bVar;
            }
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            aVar.aM(2, this.CreateTime);
            if (this.MYW != null) {
                aVar.ni(3, this.MYW.computeSize());
                this.MYW.writeFields(aVar);
            }
            AppMethodBeat.o(125786);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.CreateTime);
            if (this.MYW != null) {
                f2 += g.a.a.a.nh(3, this.MYW.computeSize());
            }
            AppMethodBeat.o(125786);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MYW == null) {
                b bVar2 = new b("Not all required fields were included: HBBuffer");
                AppMethodBeat.o(125786);
                throw bVar2;
            }
            AppMethodBeat.o(125786);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzx dzx = (dzx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzx.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(125786);
                    return 0;
                case 2:
                    dzx.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(125786);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dzx.MYW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125786);
                    return 0;
                default:
                    AppMethodBeat.o(125786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125786);
            return -1;
        }
    }
}
