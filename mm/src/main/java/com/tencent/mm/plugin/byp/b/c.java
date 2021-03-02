package com.tencent.mm.plugin.byp.b;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendImage;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/modelimage/CdnImageSendMsgParams;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelimage/CdnImageSendMsgParams;)V", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class c extends a {
    private static final boolean cWq;
    public static final a pPC = new a((byte) 0);
    private final int fuQ;
    private final com.tencent.mm.av.c pPB;
    private final String pPy;
    private final String pPz;
    private final String session_id;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.tencent.mm.av.c r13) {
        /*
        // Method dump skipped, instructions count: 863
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.byp.b.c.<init>(int, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.av.c):void");
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(sr srVar) {
        AppMethodBeat.i(199111);
        p.h(srVar, "resp");
        Log.i("Byp.CgiBypSendImage", "[onSendSuccessfully] bizType=" + this.fuQ + " msgSvrId=" + srVar.LaI + "  sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy);
        this.pPB.iWY.a(srVar.LaI, cl.aWB(), 0, 0, "");
        AppMethodBeat.o(199111);
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(int i2, int i3, String str, sr srVar) {
        AppMethodBeat.i(199112);
        p.h(srVar, "resp");
        Log.e("Byp.CgiBypSendImage", "[onSendFailed] bizType=" + this.fuQ + " sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy + " errCode:" + i3 + " errMsg:" + str);
        this.pPB.iWY.a(srVar.LaI, cl.aWB(), i2, i3, "");
        AppMethodBeat.o(199112);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendImage$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(199114);
        if (BuildInfo.DEBUG) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(199114);
    }
}
