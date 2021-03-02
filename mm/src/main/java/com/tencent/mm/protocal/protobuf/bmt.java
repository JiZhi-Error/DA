package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bmt extends a {
    public String ProductID;
    public SKBuiltinBuffer_t ReqBuf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ProductID == null) {
                b bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(104796);
                throw bVar;
            } else if (this.ReqBuf == null) {
                b bVar2 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104796);
                throw bVar2;
            } else {
                if (this.ProductID != null) {
                    aVar.e(1, this.ProductID);
                }
                if (this.ReqBuf != null) {
                    aVar.ni(2, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                AppMethodBeat.o(104796);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.ProductID != null ? g.a.a.b.b.a.f(1, this.ProductID) + 0 : 0;
            if (this.ReqBuf != null) {
                f2 += g.a.a.a.nh(2, this.ReqBuf.computeSize());
            }
            AppMethodBeat.o(104796);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ProductID == null) {
                b bVar3 = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(104796);
                throw bVar3;
            } else if (this.ReqBuf == null) {
                b bVar4 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104796);
                throw bVar4;
            } else {
                AppMethodBeat.o(104796);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmt bmt = (bmt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmt.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(104796);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bmt.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104796);
                    return 0;
                default:
                    AppMethodBeat.o(104796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104796);
            return -1;
        }
    }
}
