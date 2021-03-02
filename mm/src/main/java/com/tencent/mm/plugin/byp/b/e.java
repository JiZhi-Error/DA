package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.i.d;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J<\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendVideo;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "fakeScene", "Lcom/tencent/mm/modelvideo/NetSceneUploadVideoForCdn;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelvideo/NetSceneUploadVideoForCdn;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-byp_release"})
public final class e extends a {
    private static final boolean cWq;
    public static final a pPF = new a((byte) 0);
    private final int fuQ;
    private final h pPE;
    private final String pPy;
    private final String pPz;
    private final String session_id;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, com.tencent.mm.modelvideo.h r11) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.byp.b.e.<init>(int, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.modelvideo.h):void");
    }

    @Override // com.tencent.mm.plugin.byp.b.a, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(199120);
        s QN = u.QN(this.pPE.getFileName());
        if (QN == null) {
            Log.e("Byp.CgiBypSendVideo", "null == info %s", this.pPE.getFileName());
            this.pPE.jaD.dq(3, -1);
            AppMethodBeat.o(199120);
            return -1;
        }
        eoc a2 = this.pPE.a(QN, iVar);
        this.pPv.Lav = a2.KHq;
        so soVar = this.pPv.Laz;
        soVar.aeskey = a2.LbJ;
        soVar.url = a2.NlS;
        soVar.type = 43;
        soVar.length = a2.NlP;
        soVar.LaB = a2.MXo;
        soVar.LaC = a2.Mir;
        soVar.gTB = a2.Mip;
        soVar.Lan = a2.NlH;
        soVar.ETL = a2.NlJ;
        soVar.ETM = a2.NlI;
        soVar.md5 = a2.NlU;
        soVar.LaE = a2.Nme;
        d dVar = this.pPE.jaC;
        soVar.LaD = String.valueOf(dVar != null ? Integer.valueOf(dVar.field_videoFormat) : null);
        Log.i("Byp.CgiBypSendVideo", "[doScene] " + soVar.ETL + ':' + soVar.ETM + ", " + this.pPE.getFileName());
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(199120);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.byp.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(199121);
        p.h(sVar, "rr");
        eod eod = new eod();
        com.tencent.mm.bw.a aYK = ((com.tencent.mm.ak.d) sVar).aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
            AppMethodBeat.o(199121);
            throw tVar;
        }
        sr srVar = (sr) aYK;
        eod.Brn = srVar.LaI;
        Log.i("Byp.CgiBypSendVideo", "[onCgiBack] errType=" + i3 + " errCode=" + i4 + " errMsg=" + str + " newmsgid=" + srVar.LaI);
        this.pPE.a(i3, i4, str, eod, this);
        AppMethodBeat.o(199121);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendVideo$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(199123);
        if (BuildInfo.DEBUG) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(199123);
    }
}
