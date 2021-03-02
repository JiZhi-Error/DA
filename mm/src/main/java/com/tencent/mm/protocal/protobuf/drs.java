package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drs extends dop {
    public dqi Lqk;
    public int MJj;
    public int MUl;
    public int OpCode;
    public SKBuiltinBuffer_t ReqBuf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152682);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(152682);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lqk != null) {
                aVar.ni(2, this.Lqk.computeSize());
                this.Lqk.writeFields(aVar);
            }
            aVar.aM(3, this.OpCode);
            if (this.ReqBuf != null) {
                aVar.ni(4, this.ReqBuf.computeSize());
                this.ReqBuf.writeFields(aVar);
            }
            aVar.aM(5, this.MJj);
            aVar.aM(6, this.MUl);
            AppMethodBeat.o(152682);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lqk != null) {
                nh += g.a.a.a.nh(2, this.Lqk.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.OpCode);
            if (this.ReqBuf != null) {
                bu += g.a.a.a.nh(4, this.ReqBuf.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MJj) + g.a.a.b.b.a.bu(6, this.MUl);
            AppMethodBeat.o(152682);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar2 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(152682);
                throw bVar2;
            }
            AppMethodBeat.o(152682);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drs drs = (drs) objArr[1];
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
                        drs.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152682);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        drs.Lqk = dqi;
                    }
                    AppMethodBeat.o(152682);
                    return 0;
                case 3:
                    drs.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(152682);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        drs.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152682);
                    return 0;
                case 5:
                    drs.MJj = aVar3.UbS.zi();
                    AppMethodBeat.o(152682);
                    return 0;
                case 6:
                    drs.MUl = aVar3.UbS.zi();
                    AppMethodBeat.o(152682);
                    return 0;
                default:
                    AppMethodBeat.o(152682);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152682);
            return -1;
        }
    }
}
