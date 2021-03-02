package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dze extends dop {
    public long Id;
    public dmo KHJ;
    public SKBuiltinBuffer_t MYJ;
    public SKBuiltinBuffer_t MYK;
    public int MYL;
    public int Scene;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125766);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.Id);
            aVar.aM(3, this.Scene);
            if (this.MYJ != null) {
                aVar.ni(4, this.MYJ.computeSize());
                this.MYJ.writeFields(aVar);
            }
            aVar.aM(5, this.xub);
            if (this.MYK != null) {
                aVar.ni(6, this.MYK.computeSize());
                this.MYK.writeFields(aVar);
            }
            aVar.aM(7, this.MYL);
            if (this.KHJ != null) {
                aVar.ni(8, this.KHJ.computeSize());
                this.KHJ.writeFields(aVar);
            }
            AppMethodBeat.o(125766);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.Id) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.MYJ != null) {
                nh += g.a.a.a.nh(4, this.MYJ.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.xub);
            if (this.MYK != null) {
                bu += g.a.a.a.nh(6, this.MYK.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.MYL);
            if (this.KHJ != null) {
                bu2 += g.a.a.a.nh(8, this.KHJ.computeSize());
            }
            AppMethodBeat.o(125766);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125766);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dze dze = (dze) objArr[1];
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
                        dze.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125766);
                    return 0;
                case 2:
                    dze.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(125766);
                    return 0;
                case 3:
                    dze.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125766);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dze.MYJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125766);
                    return 0;
                case 5:
                    dze.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125766);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        dze.MYK = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125766);
                    return 0;
                case 7:
                    dze.MYL = aVar3.UbS.zi();
                    AppMethodBeat.o(125766);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dmo dmo = new dmo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dmo.populateBuilderWithField(aVar7, dmo, dop.getNextFieldNumber(aVar7))) {
                        }
                        dze.KHJ = dmo;
                    }
                    AppMethodBeat.o(125766);
                    return 0;
                default:
                    AppMethodBeat.o(125766);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125766);
            return -1;
        }
    }
}
