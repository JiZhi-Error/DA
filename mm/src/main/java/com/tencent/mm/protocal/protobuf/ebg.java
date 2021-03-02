package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebg extends dop {
    public int BsF;
    public int BsG;
    public int ExtFlag;
    public String KHk;
    public SKBuiltinBuffer_t KMS;
    public int Llx;
    public String MD5;
    public ekv MID;
    public int MsU;
    public int MsV;
    public int NaX;
    public int NaY;
    public int NaZ;
    public String izX;
    public String jfi;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125830);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KMS == null) {
                b bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(125830);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.BsG);
            aVar.aM(17, this.NaX);
            aVar.aM(4, this.BsF);
            if (this.KMS != null) {
                aVar.ni(5, this.KMS.computeSize());
                this.KMS.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(6, this.izX);
            }
            aVar.aM(7, this.MsU);
            aVar.aM(8, this.MsV);
            if (this.KHk != null) {
                aVar.e(9, this.KHk);
            }
            aVar.aM(10, this.NaY);
            aVar.aM(11, this.Llx);
            if (this.MID != null) {
                aVar.ni(12, this.MID.computeSize());
                this.MID.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(13, this.jfi);
            }
            aVar.aM(14, this.ExtFlag);
            if (this.MD5 != null) {
                aVar.e(15, this.MD5);
            }
            aVar.aM(16, this.NaZ);
            AppMethodBeat.o(125830);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.BsG) + g.a.a.b.b.a.bu(17, this.NaX) + g.a.a.b.b.a.bu(4, this.BsF);
            if (this.KMS != null) {
                nh += g.a.a.a.nh(5, this.KMS.computeSize());
            }
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(6, this.izX);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.MsU) + g.a.a.b.b.a.bu(8, this.MsV);
            if (this.KHk != null) {
                bu += g.a.a.b.b.a.f(9, this.KHk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.NaY) + g.a.a.b.b.a.bu(11, this.Llx);
            if (this.MID != null) {
                bu2 += g.a.a.a.nh(12, this.MID.computeSize());
            }
            if (this.jfi != null) {
                bu2 += g.a.a.b.b.a.f(13, this.jfi);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.ExtFlag);
            if (this.MD5 != null) {
                bu3 += g.a.a.b.b.a.f(15, this.MD5);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(16, this.NaZ);
            AppMethodBeat.o(125830);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMS == null) {
                b bVar2 = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(125830);
                throw bVar2;
            }
            AppMethodBeat.o(125830);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebg ebg = (ebg) objArr[1];
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
                        ebg.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125830);
                    return 0;
                case 2:
                    ebg.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 3:
                    ebg.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 4:
                    ebg.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ebg.KMS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125830);
                    return 0;
                case 6:
                    ebg.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125830);
                    return 0;
                case 7:
                    ebg.MsU = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 8:
                    ebg.MsV = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 9:
                    ebg.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(125830);
                    return 0;
                case 10:
                    ebg.NaY = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 11:
                    ebg.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ekv ekv = new ekv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ekv.populateBuilderWithField(aVar6, ekv, dop.getNextFieldNumber(aVar6))) {
                        }
                        ebg.MID = ekv;
                    }
                    AppMethodBeat.o(125830);
                    return 0;
                case 13:
                    ebg.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(125830);
                    return 0;
                case 14:
                    ebg.ExtFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 15:
                    ebg.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(125830);
                    return 0;
                case 16:
                    ebg.NaZ = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                case 17:
                    ebg.NaX = aVar3.UbS.zi();
                    AppMethodBeat.o(125830);
                    return 0;
                default:
                    AppMethodBeat.o(125830);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125830);
            return -1;
        }
    }
}
