package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asv extends dop {
    public apc LAv;
    public aov LBM;
    public avk LDR;
    public b LDs;
    public String LER;
    public float dTj;
    public float latitude;
    public long object_id;
    public String object_nonce_id;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209427);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.bb(4, this.object_id);
            if (this.object_nonce_id != null) {
                aVar.e(5, this.object_nonce_id);
            }
            aVar.E(6, this.dTj);
            aVar.E(7, this.latitude);
            aVar.aM(8, this.scene);
            if (this.LAv != null) {
                aVar.ni(9, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            if (this.LDR != null) {
                aVar.ni(10, this.LDR.computeSize());
                this.LDR.writeFields(aVar);
            }
            if (this.LER != null) {
                aVar.e(11, this.LER);
            }
            AppMethodBeat.o(209427);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.object_id);
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(5, this.object_nonce_id);
            }
            int fS = r + g.a.a.b.b.a.fS(6) + 4 + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.bu(8, this.scene);
            if (this.LAv != null) {
                fS += g.a.a.a.nh(9, this.LAv.computeSize());
            }
            if (this.LDR != null) {
                fS += g.a.a.a.nh(10, this.LDR.computeSize());
            }
            if (this.LER != null) {
                fS += g.a.a.b.b.a.f(11, this.LER);
            }
            AppMethodBeat.o(209427);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209427);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asv asv = (asv) objArr[1];
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
                        asv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209427);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        asv.LBM = aov;
                    }
                    AppMethodBeat.o(209427);
                    return 0;
                case 3:
                    asv.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209427);
                    return 0;
                case 4:
                    asv.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209427);
                    return 0;
                case 5:
                    asv.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209427);
                    return 0;
                case 6:
                    asv.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209427);
                    return 0;
                case 7:
                    asv.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209427);
                    return 0;
                case 8:
                    asv.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209427);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        asv.LAv = apc;
                    }
                    AppMethodBeat.o(209427);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        avk avk = new avk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = avk.populateBuilderWithField(aVar7, avk, dop.getNextFieldNumber(aVar7))) {
                        }
                        asv.LDR = avk;
                    }
                    AppMethodBeat.o(209427);
                    return 0;
                case 11:
                    asv.LER = aVar3.UbS.readString();
                    AppMethodBeat.o(209427);
                    return 0;
                default:
                    AppMethodBeat.o(209427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209427);
            return -1;
        }
    }
}
