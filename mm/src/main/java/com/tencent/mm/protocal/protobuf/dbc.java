package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dbc extends dop {
    public SKBuiltinBuffer_t MGc;
    public int MhQ;
    public int MhR;
    public SKBuiltinBuffer_t MhS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91610);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MhS == null) {
                b bVar = new b("Not all required fields were included: ReqText");
                AppMethodBeat.o(91610);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MhQ);
            aVar.aM(3, this.MhR);
            if (this.MhS != null) {
                aVar.ni(4, this.MhS.computeSize());
                this.MhS.writeFields(aVar);
            }
            if (this.MGc != null) {
                aVar.ni(5, this.MGc.computeSize());
                this.MGc.writeFields(aVar);
            }
            AppMethodBeat.o(91610);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MhQ) + g.a.a.b.b.a.bu(3, this.MhR);
            if (this.MhS != null) {
                nh += g.a.a.a.nh(4, this.MhS.computeSize());
            }
            if (this.MGc != null) {
                nh += g.a.a.a.nh(5, this.MGc.computeSize());
            }
            AppMethodBeat.o(91610);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MhS == null) {
                b bVar2 = new b("Not all required fields were included: ReqText");
                AppMethodBeat.o(91610);
                throw bVar2;
            }
            AppMethodBeat.o(91610);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbc dbc = (dbc) objArr[1];
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
                        dbc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91610);
                    return 0;
                case 2:
                    dbc.MhQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91610);
                    return 0;
                case 3:
                    dbc.MhR = aVar3.UbS.zi();
                    AppMethodBeat.o(91610);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dbc.MhS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(91610);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        dbc.MGc = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(91610);
                    return 0;
                default:
                    AppMethodBeat.o(91610);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91610);
            return -1;
        }
    }
}
