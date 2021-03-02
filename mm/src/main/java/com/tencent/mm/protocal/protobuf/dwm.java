package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dwm extends dop {
    public String Bri;
    public SKBuiltinBuffer_t KKZ;
    public int MWL;
    public String rBz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134257);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.rBz != null) {
                aVar.e(2, this.rBz);
            }
            if (this.Bri != null) {
                aVar.e(3, this.Bri);
            }
            if (this.KKZ != null) {
                aVar.ni(4, this.KKZ.computeSize());
                this.KKZ.writeFields(aVar);
            }
            aVar.aM(5, this.MWL);
            AppMethodBeat.o(134257);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.rBz != null) {
                nh += g.a.a.b.b.a.f(2, this.rBz);
            }
            if (this.Bri != null) {
                nh += g.a.a.b.b.a.f(3, this.Bri);
            }
            if (this.KKZ != null) {
                nh += g.a.a.a.nh(4, this.KKZ.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MWL);
            AppMethodBeat.o(134257);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(134257);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dwm dwm = (dwm) objArr[1];
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
                        dwm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(134257);
                    return 0;
                case 2:
                    dwm.rBz = aVar3.UbS.readString();
                    AppMethodBeat.o(134257);
                    return 0;
                case 3:
                    dwm.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(134257);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dwm.KKZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(134257);
                    return 0;
                case 5:
                    dwm.MWL = aVar3.UbS.zi();
                    AppMethodBeat.o(134257);
                    return 0;
                default:
                    AppMethodBeat.o(134257);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134257);
            return -1;
        }
    }
}
