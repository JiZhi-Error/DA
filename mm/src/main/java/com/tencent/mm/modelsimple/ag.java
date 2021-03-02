package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.C2396if;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag extends q implements m {
    private int businessType;
    private i callback;
    private s iMO;
    int jkC;
    private int jkD;
    private int jkE;
    private String jkF;
    private SKBuiltinBuffer_t jkG;
    private byte[] jkH;
    private String uri;

    private ag(int i2, int i3, String str, int i4, SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr, int i5) {
        int i6 = -1;
        AppMethodBeat.i(222851);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i4);
        objArr[3] = Integer.valueOf(sKBuiltinBuffer_t == null ? -1 : sKBuiltinBuffer_t.getILen());
        objArr[4] = Integer.valueOf(bArr != null ? bArr.length : i6);
        Log.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", objArr);
        this.jkC = i2;
        this.jkE = i3;
        this.jkF = str;
        this.businessType = i4;
        this.jkG = sKBuiltinBuffer_t;
        this.jkH = bArr;
        this.iMO = new y(i3, str, i4, sKBuiltinBuffer_t, bArr);
        this.jkD = i5;
        this.uri = str;
        AppMethodBeat.o(222851);
    }

    public ag(C2396if ifVar) {
        this(ifVar.xMB, ifVar.KMq, ifVar.KMs, ifVar.xMB, ifVar.KMo, ifVar.KMr.getBufferToBytes(), 0);
        AppMethodBeat.i(134207);
        AppMethodBeat.o(134207);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(134208);
        int type = this.iMO.getType();
        AppMethodBeat.o(134208);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134209);
        this.callback = iVar;
        this.jkD++;
        Log.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", iVar, Integer.valueOf(this.jkD), this.uri);
        e.INSTANCE.idkeyStat(148, 129, 1, false);
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(134209);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, final byte[] bArr) {
        AppMethodBeat.i(134210);
        Log.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(this.jkD), this.uri);
        if (!(i3 == 0 && i4 == 0) && this.jkD < 3) {
            tM(i4);
            if (i4 == -1 || i4 == -446) {
                Log.i("MicroMsg.NetsceneAxAuth", "summerauth do NetsceneAxAuth");
                if (!com.tencent.mm.kernel.g.azz().a(new ag(this.jkC, this.jkE, this.jkF, this.businessType, this.jkG, this.jkH, this.jkD), 0)) {
                    Log.i("MicroMsg.NetsceneAxAuth", "send axauth failed %s ", this.uri);
                    this.callback.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(134210);
                    return;
                }
            }
        }
        if (this.jkD >= 3) {
            Log.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", Integer.valueOf(this.jkD), this.uri);
        }
        final ie ieVar = ((y.b) sVar.getRespObj()).KAo;
        com.tencent.mm.kernel.g.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.modelsimple.ag.AnonymousClass1 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(134205);
                if (gVar == null) {
                    Log.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
                    AppMethodBeat.o(134205);
                } else if (gVar.aZh() == null) {
                    Log.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
                    AppMethodBeat.o(134205);
                } else {
                    try {
                        gVar.aZh().b(ag.this.jkC, ieVar.toByteArray(), bArr);
                        Log.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", Integer.valueOf(ag.this.jkC), Integer.valueOf(ieVar.toByteArray().length), Integer.valueOf(bArr.length));
                        AppMethodBeat.o(134205);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.NetsceneAxAuth", "exception:%s", Util.stackTraceToString(e2));
                        AppMethodBeat.o(134205);
                    }
                }
            }
        }), 0);
        this.callback.onSceneEnd(i3, i4, str, this);
        tM(i3);
        if (i3 != 0) {
            e.INSTANCE.idkeyStat(148, 131, 1, false);
        }
        AppMethodBeat.o(134210);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    private static void tM(int i2) {
        AppMethodBeat.i(134211);
        switch (i2) {
            case -446:
                e.INSTANCE.idkeyStat(148, 137, 1, false);
                AppMethodBeat.o(134211);
                return;
            case -104:
                e.INSTANCE.idkeyStat(148, 136, 1, false);
                AppMethodBeat.o(134211);
                return;
            case -13:
                e.INSTANCE.idkeyStat(148, 135, 1, false);
                AppMethodBeat.o(134211);
                return;
            case -3:
                e.INSTANCE.idkeyStat(148, 134, 1, false);
                AppMethodBeat.o(134211);
                return;
            case -2:
                e.INSTANCE.idkeyStat(148, 133, 1, false);
                AppMethodBeat.o(134211);
                return;
            case -1:
                e.INSTANCE.idkeyStat(148, 132, 1, false);
                AppMethodBeat.o(134211);
                return;
            case 0:
                e.INSTANCE.idkeyStat(148, 130, 1, false);
                AppMethodBeat.o(134211);
                return;
            default:
                e.INSTANCE.idkeyStat(148, 138, 1, false);
                AppMethodBeat.o(134211);
                return;
        }
    }
}
