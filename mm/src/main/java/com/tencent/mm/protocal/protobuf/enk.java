package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enk extends dop {
    public int BsF;
    public int BsG;
    public SKBuiltinBuffer_t BsI;
    public SKBuiltinBuffer_t KLQ;
    public int LWp;
    public String Nll;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152717);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152717);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.BsF);
            aVar.aM(3, this.BsG);
            aVar.aM(4, this.LWp);
            if (this.BsI != null) {
                aVar.ni(5, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            if (this.Nll != null) {
                aVar.e(6, this.Nll);
            }
            if (this.UserName != null) {
                aVar.e(7, this.UserName);
            }
            if (this.KLQ != null) {
                aVar.ni(8, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            AppMethodBeat.o(152717);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.BsF) + g.a.a.b.b.a.bu(3, this.BsG) + g.a.a.b.b.a.bu(4, this.LWp);
            if (this.BsI != null) {
                nh += g.a.a.a.nh(5, this.BsI.computeSize());
            }
            if (this.Nll != null) {
                nh += g.a.a.b.b.a.f(6, this.Nll);
            }
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(7, this.UserName);
            }
            if (this.KLQ != null) {
                nh += g.a.a.a.nh(8, this.KLQ.computeSize());
            }
            AppMethodBeat.o(152717);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152717);
                throw bVar2;
            }
            AppMethodBeat.o(152717);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enk enk = (enk) objArr[1];
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
                        enk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152717);
                    return 0;
                case 2:
                    enk.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152717);
                    return 0;
                case 3:
                    enk.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152717);
                    return 0;
                case 4:
                    enk.LWp = aVar3.UbS.zi();
                    AppMethodBeat.o(152717);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        enk.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152717);
                    return 0;
                case 6:
                    enk.Nll = aVar3.UbS.readString();
                    AppMethodBeat.o(152717);
                    return 0;
                case 7:
                    enk.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152717);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        enk.KLQ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152717);
                    return 0;
                default:
                    AppMethodBeat.o(152717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152717);
            return -1;
        }
    }
}
