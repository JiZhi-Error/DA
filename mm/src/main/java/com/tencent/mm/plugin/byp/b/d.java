package com.tencent.mm.plugin.byp.b;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\nH\u0016J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendText;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "text", "msgId", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getMsg", "()Lcom/tencent/mm/storage/MsgInfo;", "getMsgInfoClientId", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class d extends a {
    private static final boolean cWq;
    public static final a pPD = new a((byte) 0);
    public final ca dCM;
    private final int fuQ;
    private final long msgId;
    private final String pPy;
    private final String pPz;
    private final String session_id;
    private final String text;

    public /* synthetic */ d(String str, String str2, String str3, String str4) {
        this(3, str, str2, str3, str4, -1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, long r14) {
        /*
        // Method dump skipped, instructions count: 383
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.byp.b.d.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final long crU() {
        AppMethodBeat.i(199115);
        long ajL = this.dCM.ajL();
        AppMethodBeat.o(199115);
        return ajL;
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(int i2, int i3, String str, sr srVar) {
        AppMethodBeat.i(199116);
        p.h(srVar, "resp");
        Log.e("Byp.CgiBypSendText", "[onSendFailed] bizType=" + this.fuQ + " sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy + " text=" + (cWq ? this.text : ""));
        this.dCM.setStatus(5);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().a(this.dCM.ajL(), this.dCM);
        AppMethodBeat.o(199116);
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(sr srVar) {
        AppMethodBeat.i(199117);
        p.h(srVar, "resp");
        ca caVar = this.dCM;
        caVar.setStatus(2);
        caVar.yF(srVar.LaI);
        if (cWq && srVar.LaI == 0) {
            Toast.makeText(MMApplicationContext.getContext(), "svr id is zero!", 1).show();
        }
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().a(this.dCM.ajL(), this.dCM);
        Log.i("Byp.CgiBypSendText", "[onSendSuccessfully] bizType=" + this.fuQ + " msgSvrId=" + srVar.LaI + " text=" + (cWq ? this.text : "") + " sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy);
        AppMethodBeat.o(199117);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendText$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(199119);
        if (BuildInfo.DEBUG) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(199119);
    }
}
