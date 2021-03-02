package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ews extends a {
    public SKBuiltinBuffer_t KHp;
    public SKBuiltinBuffer_t KQA;
    public String KQw;
    public String Num;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133207);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KQA == null) {
                b bVar = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(133207);
                throw bVar;
            } else if (this.KHp == null) {
                b bVar2 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(133207);
                throw bVar2;
            } else {
                if (this.Num != null) {
                    aVar.e(1, this.Num);
                }
                if (this.KQA != null) {
                    aVar.ni(2, this.KQA.computeSize());
                    this.KQA.writeFields(aVar);
                }
                if (this.KQw != null) {
                    aVar.e(3, this.KQw);
                }
                if (this.KHp != null) {
                    aVar.ni(4, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                AppMethodBeat.o(133207);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Num != null ? g.a.a.b.b.a.f(1, this.Num) + 0 : 0;
            if (this.KQA != null) {
                f2 += g.a.a.a.nh(2, this.KQA.computeSize());
            }
            if (this.KQw != null) {
                f2 += g.a.a.b.b.a.f(3, this.KQw);
            }
            if (this.KHp != null) {
                f2 += g.a.a.a.nh(4, this.KHp.computeSize());
            }
            AppMethodBeat.o(133207);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KQA == null) {
                b bVar3 = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(133207);
                throw bVar3;
            } else if (this.KHp == null) {
                b bVar4 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(133207);
                throw bVar4;
            } else {
                AppMethodBeat.o(133207);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ews ews = (ews) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ews.Num = aVar3.UbS.readString();
                    AppMethodBeat.o(133207);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ews.KQA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133207);
                    return 0;
                case 3:
                    ews.KQw = aVar3.UbS.readString();
                    AppMethodBeat.o(133207);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        ews.KHp = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133207);
                    return 0;
                default:
                    AppMethodBeat.o(133207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133207);
            return -1;
        }
    }
}
