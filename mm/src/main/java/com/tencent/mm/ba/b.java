package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.pay.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class b extends q implements m {
    private i callback;
    public a jgb;
    public final List<k.b> jgc = new ArrayList();

    public b(List<k.b> list) {
        AppMethodBeat.i(43049);
        this.jgc.addAll(list);
        this.jgb = new a();
        ((C0277b) this.jgb.getReqObj()).jgf.MyZ = az(list);
        AppMethodBeat.o(43049);
    }

    private static abo az(List<k.b> list) {
        AppMethodBeat.i(43050);
        abo abo = new abo();
        for (k.b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            abn abn = new abn();
            abn.Lms = bVar.getCmdId();
            abn.Lmt = new SKBuiltinBuffer_t().setBuffer(buffer);
            abo.oTA.add(abn);
        }
        abo.oTz = list.size();
        Log.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        AppMethodBeat.o(43050);
        return abo;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(43051);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.jgb, this);
        AppMethodBeat.o(43051);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public int securityLimitCount() {
        return 5;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(43052);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(43052);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return d.CTRL_INDEX;
    }

    public static class a extends o {
        private final C0277b jgd = new C0277b();
        private final c jge = new c();

        public a() {
            AppMethodBeat.i(43044);
            AppMethodBeat.o(43044);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jgd;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jge;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return d.CTRL_INDEX;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    /* renamed from: com.tencent.mm.ba.b$b  reason: collision with other inner class name */
    static class C0277b extends l.d implements l.b {
        public cxm jgf = new cxm();

        C0277b() {
            AppMethodBeat.i(43045);
            AppMethodBeat.o(43045);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(43046);
            byte[] byteArray = this.jgf.toByteArray();
            AppMethodBeat.o(43046);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return d.CTRL_INDEX;
        }
    }

    public static class c extends l.e implements l.c {
        public cxn jgg = new cxn();

        public c() {
            AppMethodBeat.i(43047);
            AppMethodBeat.o(43047);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(43048);
            this.jgg = (cxn) new cxn().parseFrom(bArr);
            int i2 = this.jgg.Ret;
            AppMethodBeat.o(43048);
            return i2;
        }
    }
}
