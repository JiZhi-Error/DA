package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class baq extends dop {
    public LinkedList<String> Gbc = new LinkedList<>();
    public int LCN;
    public int LKa;
    public float LKc;
    public float LKd;
    public int LKe;
    public FinderObjectDesc LKf;
    public long LKg;
    public long LKh;
    public LinkedList<String> LKi = new LinkedList<>();
    public b LKj;
    public String LKk;
    public int LKl;
    public aoq attachmentList;
    public String clientId;
    public float dTj;
    public String groupId;
    public float latitude;
    public int originalFlag;
    public String refObjectNonceId;
    public long twd;
    public aov uli;
    public String username;

    public baq() {
        AppMethodBeat.i(169036);
        AppMethodBeat.o(169036);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169037);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.LKf != null) {
                aVar.ni(3, this.LKf.computeSize());
                this.LKf.writeFields(aVar);
            }
            if (this.clientId != null) {
                aVar.e(4, this.clientId);
            }
            aVar.bb(5, this.LKg);
            if (this.refObjectNonceId != null) {
                aVar.e(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.E(8, this.dTj);
            aVar.E(9, this.latitude);
            aVar.E(10, this.LKc);
            aVar.E(11, this.LKd);
            aVar.aM(12, this.LKe);
            aVar.e(13, 1, this.Gbc);
            aVar.aM(14, this.originalFlag);
            aVar.bb(15, this.LKh);
            aVar.e(16, 1, this.LKi);
            if (this.LKj != null) {
                aVar.c(17, this.LKj);
            }
            if (this.groupId != null) {
                aVar.e(18, this.groupId);
            }
            if (this.attachmentList != null) {
                aVar.ni(20, this.attachmentList.computeSize());
                this.attachmentList.writeFields(aVar);
            }
            if (this.LKk != null) {
                aVar.e(21, this.LKk);
            }
            aVar.aM(22, this.LKl);
            aVar.aM(23, this.LKa);
            aVar.bb(24, this.twd);
            aVar.aM(25, this.LCN);
            AppMethodBeat.o(169037);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.LKf != null) {
                nh += g.a.a.a.nh(3, this.LKf.computeSize());
            }
            if (this.clientId != null) {
                nh += g.a.a.b.b.a.f(4, this.clientId);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.LKg);
            if (this.refObjectNonceId != null) {
                r += g.a.a.b.b.a.f(6, this.refObjectNonceId);
            }
            if (this.uli != null) {
                r += g.a.a.a.nh(7, this.uli.computeSize());
            }
            int fS = r + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.fS(11) + 4 + g.a.a.b.b.a.bu(12, this.LKe) + g.a.a.a.c(13, 1, this.Gbc) + g.a.a.b.b.a.bu(14, this.originalFlag) + g.a.a.b.b.a.r(15, this.LKh) + g.a.a.a.c(16, 1, this.LKi);
            if (this.LKj != null) {
                fS += g.a.a.b.b.a.b(17, this.LKj);
            }
            if (this.groupId != null) {
                fS += g.a.a.b.b.a.f(18, this.groupId);
            }
            if (this.attachmentList != null) {
                fS += g.a.a.a.nh(20, this.attachmentList.computeSize());
            }
            if (this.LKk != null) {
                fS += g.a.a.b.b.a.f(21, this.LKk);
            }
            int bu = fS + g.a.a.b.b.a.bu(22, this.LKl) + g.a.a.b.b.a.bu(23, this.LKa) + g.a.a.b.b.a.r(24, this.twd) + g.a.a.b.b.a.bu(25, this.LCN);
            AppMethodBeat.o(169037);
            return bu;
        } else if (i2 == 2) {
            this.Gbc.clear();
            this.LKi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169037);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            baq baq = (baq) objArr[1];
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
                        baq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169037);
                    return 0;
                case 2:
                    baq.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169037);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObjectDesc.populateBuilderWithField(aVar5, finderObjectDesc, dop.getNextFieldNumber(aVar5))) {
                        }
                        baq.LKf = finderObjectDesc;
                    }
                    AppMethodBeat.o(169037);
                    return 0;
                case 4:
                    baq.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(169037);
                    return 0;
                case 5:
                    baq.LKg = aVar3.UbS.zl();
                    AppMethodBeat.o(169037);
                    return 0;
                case 6:
                    baq.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169037);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aov.populateBuilderWithField(aVar6, aov, dop.getNextFieldNumber(aVar6))) {
                        }
                        baq.uli = aov;
                    }
                    AppMethodBeat.o(169037);
                    return 0;
                case 8:
                    baq.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169037);
                    return 0;
                case 9:
                    baq.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169037);
                    return 0;
                case 10:
                    baq.LKc = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169037);
                    return 0;
                case 11:
                    baq.LKd = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169037);
                    return 0;
                case 12:
                    baq.LKe = aVar3.UbS.zi();
                    AppMethodBeat.o(169037);
                    return 0;
                case 13:
                    baq.Gbc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169037);
                    return 0;
                case 14:
                    baq.originalFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169037);
                    return 0;
                case 15:
                    baq.LKh = aVar3.UbS.zl();
                    AppMethodBeat.o(169037);
                    return 0;
                case 16:
                    baq.LKi.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169037);
                    return 0;
                case 17:
                    baq.LKj = aVar3.UbS.hPo();
                    AppMethodBeat.o(169037);
                    return 0;
                case 18:
                    baq.groupId = aVar3.UbS.readString();
                    AppMethodBeat.o(169037);
                    return 0;
                case 19:
                default:
                    AppMethodBeat.o(169037);
                    return -1;
                case 20:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aoq aoq = new aoq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aoq.populateBuilderWithField(aVar7, aoq, dop.getNextFieldNumber(aVar7))) {
                        }
                        baq.attachmentList = aoq;
                    }
                    AppMethodBeat.o(169037);
                    return 0;
                case 21:
                    baq.LKk = aVar3.UbS.readString();
                    AppMethodBeat.o(169037);
                    return 0;
                case 22:
                    baq.LKl = aVar3.UbS.zi();
                    AppMethodBeat.o(169037);
                    return 0;
                case 23:
                    baq.LKa = aVar3.UbS.zi();
                    AppMethodBeat.o(169037);
                    return 0;
                case 24:
                    baq.twd = aVar3.UbS.zl();
                    AppMethodBeat.o(169037);
                    return 0;
                case 25:
                    baq.LCN = aVar3.UbS.zi();
                    AppMethodBeat.o(169037);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169037);
            return -1;
        }
    }
}
