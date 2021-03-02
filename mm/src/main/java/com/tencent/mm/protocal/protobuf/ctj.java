package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ctj extends dop {
    public SKBuiltinBuffer_t Myi;
    public SKBuiltinBuffer_t Myj;
    public String UserName;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133181);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Myi == null) {
                b bVar = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(133181);
                throw bVar;
            } else if (this.Myj == null) {
                b bVar2 = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(133181);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.UserName != null) {
                    aVar.e(2, this.UserName);
                }
                if (this.Myi != null) {
                    aVar.ni(3, this.Myi.computeSize());
                    this.Myi.writeFields(aVar);
                }
                if (this.Myj != null) {
                    aVar.ni(4, this.Myj.computeSize());
                    this.Myj.writeFields(aVar);
                }
                if (this.rBI != null) {
                    aVar.e(5, this.rBI);
                }
                AppMethodBeat.o(133181);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.Myi != null) {
                nh += g.a.a.a.nh(3, this.Myi.computeSize());
            }
            if (this.Myj != null) {
                nh += g.a.a.a.nh(4, this.Myj.computeSize());
            }
            if (this.rBI != null) {
                nh += g.a.a.b.b.a.f(5, this.rBI);
            }
            AppMethodBeat.o(133181);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Myi == null) {
                b bVar3 = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(133181);
                throw bVar3;
            } else if (this.Myj == null) {
                b bVar4 = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(133181);
                throw bVar4;
            } else {
                AppMethodBeat.o(133181);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctj ctj = (ctj) objArr[1];
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
                        ctj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133181);
                    return 0;
                case 2:
                    ctj.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(133181);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ctj.Myi = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133181);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        ctj.Myj = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133181);
                    return 0;
                case 5:
                    ctj.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(133181);
                    return 0;
                default:
                    AppMethodBeat.o(133181);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133181);
            return -1;
        }
    }
}
