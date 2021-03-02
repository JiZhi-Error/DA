package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etq extends dop {
    public SKBuiltinBuffer_t KMS;
    public int LsZ;
    public long Lta;
    public int MKr;
    public int NqM;
    public int NqN;
    public int NqO;
    public int NqP;
    public int NqQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115876);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KMS == null) {
                b bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(115876);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.MKr);
            aVar.aM(5, this.NqM);
            aVar.aM(6, this.NqN);
            aVar.aM(7, this.NqO);
            aVar.aM(8, this.NqP);
            aVar.aM(9, this.NqQ);
            if (this.KMS != null) {
                aVar.ni(10, this.KMS.computeSize());
                this.KMS.writeFields(aVar);
            }
            AppMethodBeat.o(115876);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.b.b.a.bu(5, this.NqM) + g.a.a.b.b.a.bu(6, this.NqN) + g.a.a.b.b.a.bu(7, this.NqO) + g.a.a.b.b.a.bu(8, this.NqP) + g.a.a.b.b.a.bu(9, this.NqQ);
            if (this.KMS != null) {
                nh += g.a.a.a.nh(10, this.KMS.computeSize());
            }
            AppMethodBeat.o(115876);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMS == null) {
                b bVar2 = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(115876);
                throw bVar2;
            }
            AppMethodBeat.o(115876);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etq etq = (etq) objArr[1];
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
                        etq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115876);
                    return 0;
                case 2:
                    etq.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 3:
                    etq.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115876);
                    return 0;
                case 4:
                    etq.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 5:
                    etq.NqM = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 6:
                    etq.NqN = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 7:
                    etq.NqO = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 8:
                    etq.NqP = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 9:
                    etq.NqQ = aVar3.UbS.zi();
                    AppMethodBeat.o(115876);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        etq.KMS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(115876);
                    return 0;
                default:
                    AppMethodBeat.o(115876);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115876);
            return -1;
        }
    }
}
