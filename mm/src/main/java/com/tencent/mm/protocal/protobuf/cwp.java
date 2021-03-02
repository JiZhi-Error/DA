package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cwp extends dop {
    public SKBuiltinBuffer_t MBy;
    public int dML;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152655);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MBy == null) {
                b bVar = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(152655);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.dML);
            if (this.MBy != null) {
                aVar.ni(3, this.MBy.computeSize());
                this.MBy.writeFields(aVar);
            }
            AppMethodBeat.o(152655);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dML);
            if (this.MBy != null) {
                nh += g.a.a.a.nh(3, this.MBy.computeSize());
            }
            AppMethodBeat.o(152655);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MBy == null) {
                b bVar2 = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(152655);
                throw bVar2;
            }
            AppMethodBeat.o(152655);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cwp cwp = (cwp) objArr[1];
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
                        cwp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152655);
                    return 0;
                case 2:
                    cwp.dML = aVar3.UbS.zi();
                    AppMethodBeat.o(152655);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        cwp.MBy = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152655);
                    return 0;
                default:
                    AppMethodBeat.o(152655);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152655);
            return -1;
        }
    }
}
