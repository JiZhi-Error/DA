package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpy extends dpc {
    public int KCC;
    public SKBuiltinBuffer_t LXP;
    public int LXQ;
    public SKBuiltinBuffer_t LXR;
    public String LXS;
    public SKBuiltinBuffer_t LXT;
    public String UUID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(232374);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(232374);
                throw bVar;
            } else if (this.LXP == null) {
                b bVar2 = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(232374);
                throw bVar2;
            } else if (this.LXR == null) {
                b bVar3 = new b("Not all required fields were included: NotifyKey");
                AppMethodBeat.o(232374);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LXP != null) {
                    aVar.ni(2, this.LXP.computeSize());
                    this.LXP.writeFields(aVar);
                }
                if (this.UUID != null) {
                    aVar.e(3, this.UUID);
                }
                aVar.aM(4, this.LXQ);
                if (this.LXR != null) {
                    aVar.ni(5, this.LXR.computeSize());
                    this.LXR.writeFields(aVar);
                }
                aVar.aM(6, this.KCC);
                if (this.LXS != null) {
                    aVar.e(7, this.LXS);
                }
                if (this.LXT != null) {
                    aVar.ni(8, this.LXT.computeSize());
                    this.LXT.writeFields(aVar);
                }
                AppMethodBeat.o(232374);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LXP != null) {
                nh += g.a.a.a.nh(2, this.LXP.computeSize());
            }
            if (this.UUID != null) {
                nh += g.a.a.b.b.a.f(3, this.UUID);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LXQ);
            if (this.LXR != null) {
                bu += g.a.a.a.nh(5, this.LXR.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KCC);
            if (this.LXS != null) {
                bu2 += g.a.a.b.b.a.f(7, this.LXS);
            }
            if (this.LXT != null) {
                bu2 += g.a.a.a.nh(8, this.LXT.computeSize());
            }
            AppMethodBeat.o(232374);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(232374);
                throw bVar4;
            } else if (this.LXP == null) {
                b bVar5 = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(232374);
                throw bVar5;
            } else if (this.LXR == null) {
                b bVar6 = new b("Not all required fields were included: NotifyKey");
                AppMethodBeat.o(232374);
                throw bVar6;
            } else {
                AppMethodBeat.o(232374);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpy bpy = (bpy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bpy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(232374);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bpy.LXP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(232374);
                    return 0;
                case 3:
                    bpy.UUID = aVar3.UbS.readString();
                    AppMethodBeat.o(232374);
                    return 0;
                case 4:
                    bpy.LXQ = aVar3.UbS.zi();
                    AppMethodBeat.o(232374);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bpy.LXR = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(232374);
                    return 0;
                case 6:
                    bpy.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(232374);
                    return 0;
                case 7:
                    bpy.LXS = aVar3.UbS.readString();
                    AppMethodBeat.o(232374);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bpy.LXT = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(232374);
                    return 0;
                default:
                    AppMethodBeat.o(232374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(232374);
            return -1;
        }
    }
}
