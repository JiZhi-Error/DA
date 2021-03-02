package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dgd extends dop {
    public SKBuiltinBuffer_t KKZ;
    public SKBuiltinBuffer_t KPW;
    public int KQy;
    public String MrO;
    public String MyQ;
    public String UserName;
    public String oTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(232380);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KPW == null) {
                b bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(232380);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.MyQ != null) {
                aVar.e(3, this.MyQ);
            }
            if (this.MrO != null) {
                aVar.e(4, this.MrO);
            }
            if (this.KPW != null) {
                aVar.ni(5, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            aVar.aM(6, this.KQy);
            if (this.oTI != null) {
                aVar.e(7, this.oTI);
            }
            if (this.KKZ != null) {
                aVar.ni(8, this.KKZ.computeSize());
                this.KKZ.writeFields(aVar);
            }
            AppMethodBeat.o(232380);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.MyQ != null) {
                nh += g.a.a.b.b.a.f(3, this.MyQ);
            }
            if (this.MrO != null) {
                nh += g.a.a.b.b.a.f(4, this.MrO);
            }
            if (this.KPW != null) {
                nh += g.a.a.a.nh(5, this.KPW.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KQy);
            if (this.oTI != null) {
                bu += g.a.a.b.b.a.f(7, this.oTI);
            }
            if (this.KKZ != null) {
                bu += g.a.a.a.nh(8, this.KKZ.computeSize());
            }
            AppMethodBeat.o(232380);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPW == null) {
                b bVar2 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(232380);
                throw bVar2;
            }
            AppMethodBeat.o(232380);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgd dgd = (dgd) objArr[1];
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
                        dgd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(232380);
                    return 0;
                case 2:
                    dgd.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(232380);
                    return 0;
                case 3:
                    dgd.MyQ = aVar3.UbS.readString();
                    AppMethodBeat.o(232380);
                    return 0;
                case 4:
                    dgd.MrO = aVar3.UbS.readString();
                    AppMethodBeat.o(232380);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dgd.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(232380);
                    return 0;
                case 6:
                    dgd.KQy = aVar3.UbS.zi();
                    AppMethodBeat.o(232380);
                    return 0;
                case 7:
                    dgd.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(232380);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        dgd.KKZ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(232380);
                    return 0;
                default:
                    AppMethodBeat.o(232380);
                    return -1;
            }
        } else {
            AppMethodBeat.o(232380);
            return -1;
        }
    }
}
