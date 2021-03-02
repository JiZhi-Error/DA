package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendEmoij;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "msgId", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/storage/emotion/EmojiInfo;J)V", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class b extends a {
    private static final boolean cWq;
    public static final a pPA = new a((byte) 0);
    private final EmojiInfo dEz;
    private final int fuQ = 3;
    private final long msgId;
    private final String pPy;
    private final String pPz;
    private final String session_id;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(java.lang.String r8, java.lang.String r9, java.lang.String r10, com.tencent.mm.storage.emotion.EmojiInfo r11, long r12) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.byp.b.b.<init>(java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.storage.emotion.EmojiInfo, long):void");
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(sr srVar) {
        AppMethodBeat.i(199107);
        p.h(srVar, "resp");
        Log.i("Byp.CgiBypSendEmoij", "[onSendSuccessfully] bizType=" + this.fuQ + " msgSvrId=" + srVar.LaI + "  sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy);
        AppMethodBeat.o(199107);
    }

    @Override // com.tencent.mm.plugin.byp.b.a
    public final void a(int i2, int i3, String str, sr srVar) {
        AppMethodBeat.i(199108);
        p.h(srVar, "resp");
        Log.e("Byp.CgiBypSendEmoij", "[onSendFailed] bizType=" + this.fuQ + " sessionId=" + this.session_id + " toUsername=" + this.pPz + " fromUsername=" + this.pPy + " errCode:" + i3 + " errMsg:" + str);
        AppMethodBeat.o(199108);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendEmoij$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(199110);
        if (BuildInfo.DEBUG) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(199110);
    }
}
