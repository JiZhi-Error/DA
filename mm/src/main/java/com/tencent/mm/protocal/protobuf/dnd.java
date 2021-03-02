package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dnd extends dop {
    public SKBuiltinBuffer_t KLQ;
    public b MQx;
    public int dYp;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133192);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MQx == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: clientCheckData");
                AppMethodBeat.o(133192);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MQx != null) {
                aVar.c(2, this.MQx);
            }
            aVar.aM(3, this.dYp);
            if (this.KLQ != null) {
                aVar.ni(4, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            aVar.bb(5, this.timestamp);
            AppMethodBeat.o(133192);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MQx != null) {
                nh += g.a.a.b.b.a.b(2, this.MQx);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.dYp);
            if (this.KLQ != null) {
                bu += g.a.a.a.nh(4, this.KLQ.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(5, this.timestamp);
            AppMethodBeat.o(133192);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MQx == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: clientCheckData");
                AppMethodBeat.o(133192);
                throw bVar2;
            }
            AppMethodBeat.o(133192);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnd dnd = (dnd) objArr[1];
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
                        dnd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133192);
                    return 0;
                case 2:
                    dnd.MQx = aVar3.UbS.hPo();
                    AppMethodBeat.o(133192);
                    return 0;
                case 3:
                    dnd.dYp = aVar3.UbS.zi();
                    AppMethodBeat.o(133192);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dnd.KLQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133192);
                    return 0;
                case 5:
                    dnd.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(133192);
                    return 0;
                default:
                    AppMethodBeat.o(133192);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133192);
            return -1;
        }
    }
}
