package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyb extends a {
    public SKBuiltinBuffer_t KIA;
    public SKBuiltinBuffer_t MDa;
    public String Md5;
    public String Name;
    public String PackName;
    public int Version;
    public int oUq;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152659);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xNF);
            aVar.aM(2, this.Version);
            if (this.Name != null) {
                aVar.e(3, this.Name);
            }
            aVar.aM(4, this.oUq);
            if (this.KIA != null) {
                aVar.ni(5, this.KIA.computeSize());
                this.KIA.writeFields(aVar);
            }
            if (this.PackName != null) {
                aVar.e(6, this.PackName);
            }
            if (this.MDa != null) {
                aVar.ni(7, this.MDa.computeSize());
                this.MDa.writeFields(aVar);
            }
            if (this.Md5 != null) {
                aVar.e(8, this.Md5);
            }
            AppMethodBeat.o(152659);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNF) + 0 + g.a.a.b.b.a.bu(2, this.Version);
            if (this.Name != null) {
                bu += g.a.a.b.b.a.f(3, this.Name);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.oUq);
            if (this.KIA != null) {
                bu2 += g.a.a.a.nh(5, this.KIA.computeSize());
            }
            if (this.PackName != null) {
                bu2 += g.a.a.b.b.a.f(6, this.PackName);
            }
            if (this.MDa != null) {
                bu2 += g.a.a.a.nh(7, this.MDa.computeSize());
            }
            if (this.Md5 != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Md5);
            }
            AppMethodBeat.o(152659);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152659);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyb cyb = (cyb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyb.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(152659);
                    return 0;
                case 2:
                    cyb.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(152659);
                    return 0;
                case 3:
                    cyb.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(152659);
                    return 0;
                case 4:
                    cyb.oUq = aVar3.UbS.zi();
                    AppMethodBeat.o(152659);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cyb.KIA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152659);
                    return 0;
                case 6:
                    cyb.PackName = aVar3.UbS.readString();
                    AppMethodBeat.o(152659);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        cyb.MDa = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152659);
                    return 0;
                case 8:
                    cyb.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(152659);
                    return 0;
                default:
                    AppMethodBeat.o(152659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152659);
            return -1;
        }
    }
}
