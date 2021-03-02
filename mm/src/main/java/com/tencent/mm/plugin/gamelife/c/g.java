package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class g {
    private static final String TAG = TAG;
    public static final a ybA = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0014\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBlackList", "", "userName", "getChatSessionData", "sessionIdList", "Ljava/util/LinkedList;", "getChatSessionId", "fromUserName", "toUserName", "getChatUserInfo", "userNameList", "setBlackList", "switch", "", "associateWxGameAccount", "setChatSessionData", "sessionId", "mask", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void h(String str, boolean z, boolean z2) {
            AppMethodBeat.i(241289);
            p.h(str, "userName");
            Log.i(g.TAG, "setBlackList, userName = " + str + ", swith = " + z + ", associateWxGameAccount = " + z2);
            new e(str, z, z2).aYI();
            AppMethodBeat.o(241289);
        }

        public static void d(String str, long j2, boolean z) {
            AppMethodBeat.i(241290);
            p.h(str, "sessionId");
            Log.i(g.TAG, "setChatSessionData, sessionId = " + str + ", mask = " + j2 + ", switch = " + z);
            new f(str, j2, z).aYI();
            AppMethodBeat.o(241290);
        }
    }

    static {
        AppMethodBeat.i(241291);
        AppMethodBeat.o(241291);
    }
}
