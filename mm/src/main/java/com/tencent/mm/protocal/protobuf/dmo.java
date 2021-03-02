package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dmo extends a {
    public int MQc;
    public SKBuiltinBuffer_t MQd;
    public SKBuiltinBuffer_t MQe;
    public SKBuiltinBuffer_t MQf;
    public SKBuiltinBuffer_t MQg;
    public long MQh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125760);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MQc);
            if (this.MQd != null) {
                aVar.ni(2, this.MQd.computeSize());
                this.MQd.writeFields(aVar);
            }
            if (this.MQe != null) {
                aVar.ni(3, this.MQe.computeSize());
                this.MQe.writeFields(aVar);
            }
            if (this.MQf != null) {
                aVar.ni(4, this.MQf.computeSize());
                this.MQf.writeFields(aVar);
            }
            if (this.MQg != null) {
                aVar.ni(5, this.MQg.computeSize());
                this.MQg.writeFields(aVar);
            }
            aVar.bb(6, this.MQh);
            AppMethodBeat.o(125760);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MQc) + 0;
            if (this.MQd != null) {
                bu += g.a.a.a.nh(2, this.MQd.computeSize());
            }
            if (this.MQe != null) {
                bu += g.a.a.a.nh(3, this.MQe.computeSize());
            }
            if (this.MQf != null) {
                bu += g.a.a.a.nh(4, this.MQf.computeSize());
            }
            if (this.MQg != null) {
                bu += g.a.a.a.nh(5, this.MQg.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.MQh);
            AppMethodBeat.o(125760);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125760);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmo dmo = (dmo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dmo.MQc = aVar3.UbS.zi();
                    AppMethodBeat.o(125760);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dmo.MQd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125760);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        dmo.MQe = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125760);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar6, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar6))) {
                        }
                        dmo.MQf = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(125760);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar7, sKBuiltinBuffer_t4, a.getNextFieldNumber(aVar7))) {
                        }
                        dmo.MQg = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(125760);
                    return 0;
                case 6:
                    dmo.MQh = aVar3.UbS.zl();
                    AppMethodBeat.o(125760);
                    return 0;
                default:
                    AppMethodBeat.o(125760);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125760);
            return -1;
        }
    }
}
