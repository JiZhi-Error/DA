package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class arr extends dop {
    public long LDa;
    public int LDb;
    public String LDc;
    public int LDd;
    public float dTj;
    public int direction;
    public String finderUsername;
    public long hFK;
    public b lastBuffer;
    public float latitude;
    public b likeBuffer;
    public String objectNonceId;
    public int scene;
    public long tuf;
    public long tuj;
    public int tum;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168973);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.hFK);
            aVar.bb(3, this.LDa);
            aVar.aM(4, this.LDb);
            if (this.lastBuffer != null) {
                aVar.c(5, this.lastBuffer);
            }
            aVar.bb(6, this.tuf);
            if (this.finderUsername != null) {
                aVar.e(7, this.finderUsername);
            }
            aVar.bb(8, this.tuj);
            aVar.aM(9, this.scene);
            aVar.aM(10, this.direction);
            if (this.LDc != null) {
                aVar.e(11, this.LDc);
            }
            if (this.objectNonceId != null) {
                aVar.e(12, this.objectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(13, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.aM(14, this.LDd);
            aVar.aM(15, this.tum);
            if (this.likeBuffer != null) {
                aVar.c(16, this.likeBuffer);
            }
            aVar.E(17, this.dTj);
            aVar.E(18, this.latitude);
            AppMethodBeat.o(168973);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.hFK) + g.a.a.b.b.a.r(3, this.LDa) + g.a.a.b.b.a.bu(4, this.LDb);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(5, this.lastBuffer);
            }
            int r = nh + g.a.a.b.b.a.r(6, this.tuf);
            if (this.finderUsername != null) {
                r += g.a.a.b.b.a.f(7, this.finderUsername);
            }
            int r2 = r + g.a.a.b.b.a.r(8, this.tuj) + g.a.a.b.b.a.bu(9, this.scene) + g.a.a.b.b.a.bu(10, this.direction);
            if (this.LDc != null) {
                r2 += g.a.a.b.b.a.f(11, this.LDc);
            }
            if (this.objectNonceId != null) {
                r2 += g.a.a.b.b.a.f(12, this.objectNonceId);
            }
            if (this.uli != null) {
                r2 += g.a.a.a.nh(13, this.uli.computeSize());
            }
            int bu = r2 + g.a.a.b.b.a.bu(14, this.LDd) + g.a.a.b.b.a.bu(15, this.tum);
            if (this.likeBuffer != null) {
                bu += g.a.a.b.b.a.b(16, this.likeBuffer);
            }
            int fS = bu + g.a.a.b.b.a.fS(17) + 4 + g.a.a.b.b.a.fS(18) + 4;
            AppMethodBeat.o(168973);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168973);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arr arr = (arr) objArr[1];
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
                        arr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168973);
                    return 0;
                case 2:
                    arr.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(168973);
                    return 0;
                case 3:
                    arr.LDa = aVar3.UbS.zl();
                    AppMethodBeat.o(168973);
                    return 0;
                case 4:
                    arr.LDb = aVar3.UbS.zi();
                    AppMethodBeat.o(168973);
                    return 0;
                case 5:
                    arr.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168973);
                    return 0;
                case 6:
                    arr.tuf = aVar3.UbS.zl();
                    AppMethodBeat.o(168973);
                    return 0;
                case 7:
                    arr.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(168973);
                    return 0;
                case 8:
                    arr.tuj = aVar3.UbS.zl();
                    AppMethodBeat.o(168973);
                    return 0;
                case 9:
                    arr.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(168973);
                    return 0;
                case 10:
                    arr.direction = aVar3.UbS.zi();
                    AppMethodBeat.o(168973);
                    return 0;
                case 11:
                    arr.LDc = aVar3.UbS.readString();
                    AppMethodBeat.o(168973);
                    return 0;
                case 12:
                    arr.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(168973);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        arr.uli = aov;
                    }
                    AppMethodBeat.o(168973);
                    return 0;
                case 14:
                    arr.LDd = aVar3.UbS.zi();
                    AppMethodBeat.o(168973);
                    return 0;
                case 15:
                    arr.tum = aVar3.UbS.zi();
                    AppMethodBeat.o(168973);
                    return 0;
                case 16:
                    arr.likeBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168973);
                    return 0;
                case 17:
                    arr.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(168973);
                    return 0;
                case 18:
                    arr.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(168973);
                    return 0;
                default:
                    AppMethodBeat.o(168973);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168973);
            return -1;
        }
    }
}
