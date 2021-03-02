package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class auo extends dop {
    public int LFt;
    public String LFu;
    public LinkedList<Integer> LFv = new LinkedList<>();
    public long commentId;
    public long hFK;
    public String objectNonceId;
    public int opType;
    public int scene;
    public String sessionBuffer;
    public long tsR;
    public int uFa;
    public aov uli;
    public String username;
    public int vkk;

    public auo() {
        AppMethodBeat.i(209481);
        AppMethodBeat.o(209481);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169002);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.hFK);
            aVar.bb(3, this.commentId);
            aVar.aM(4, this.opType);
            aVar.bb(5, this.tsR);
            aVar.aM(6, this.LFt);
            if (this.username != null) {
                aVar.e(7, this.username);
            }
            aVar.aM(8, this.scene);
            if (this.objectNonceId != null) {
                aVar.e(9, this.objectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(10, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.sessionBuffer != null) {
                aVar.e(11, this.sessionBuffer);
            }
            if (this.LFu != null) {
                aVar.e(12, this.LFu);
            }
            aVar.aM(13, this.vkk);
            aVar.aM(14, this.uFa);
            aVar.e(15, 2, this.LFv);
            AppMethodBeat.o(169002);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.hFK) + g.a.a.b.b.a.r(3, this.commentId) + g.a.a.b.b.a.bu(4, this.opType) + g.a.a.b.b.a.r(5, this.tsR) + g.a.a.b.b.a.bu(6, this.LFt);
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(7, this.username);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.scene);
            if (this.objectNonceId != null) {
                bu += g.a.a.b.b.a.f(9, this.objectNonceId);
            }
            if (this.uli != null) {
                bu += g.a.a.a.nh(10, this.uli.computeSize());
            }
            if (this.sessionBuffer != null) {
                bu += g.a.a.b.b.a.f(11, this.sessionBuffer);
            }
            if (this.LFu != null) {
                bu += g.a.a.b.b.a.f(12, this.LFu);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.vkk) + g.a.a.b.b.a.bu(14, this.uFa) + g.a.a.a.c(15, 2, this.LFv);
            AppMethodBeat.o(169002);
            return bu2;
        } else if (i2 == 2) {
            this.LFv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169002);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auo auo = (auo) objArr[1];
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
                        auo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169002);
                    return 0;
                case 2:
                    auo.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(169002);
                    return 0;
                case 3:
                    auo.commentId = aVar3.UbS.zl();
                    AppMethodBeat.o(169002);
                    return 0;
                case 4:
                    auo.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(169002);
                    return 0;
                case 5:
                    auo.tsR = aVar3.UbS.zl();
                    AppMethodBeat.o(169002);
                    return 0;
                case 6:
                    auo.LFt = aVar3.UbS.zi();
                    AppMethodBeat.o(169002);
                    return 0;
                case 7:
                    auo.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169002);
                    return 0;
                case 8:
                    auo.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(169002);
                    return 0;
                case 9:
                    auo.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169002);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        auo.uli = aov;
                    }
                    AppMethodBeat.o(169002);
                    return 0;
                case 11:
                    auo.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(169002);
                    return 0;
                case 12:
                    auo.LFu = aVar3.UbS.readString();
                    AppMethodBeat.o(169002);
                    return 0;
                case 13:
                    auo.vkk = aVar3.UbS.zi();
                    AppMethodBeat.o(169002);
                    return 0;
                case 14:
                    auo.uFa = aVar3.UbS.zi();
                    AppMethodBeat.o(169002);
                    return 0;
                case 15:
                    auo.LFv.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(169002);
                    return 0;
                default:
                    AppMethodBeat.o(169002);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169002);
            return -1;
        }
    }
}
