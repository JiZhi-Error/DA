package com.tencent.mm.plugin.game.luggage.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch;", "", "()V", "Companion", "luggage-game_release"})
public final class b {
    private static final String TAG = TAG;
    private static final String xxk = (MMApplicationContext.getApplicationId() + ":lite");
    public static final a xxl = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion;", "", "()V", "LITE_PROCESS_NAME", "", "TAG", "dispatchEventFromMMProcess", "", "data", "Landroid/os/Bundle;", "IPCLiteAppDispatchEventTask", "luggage-game_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void am(Bundle bundle) {
            AppMethodBeat.i(187037);
            p.h(bundle, "data");
            Log.i(b.TAG, "dispatchEventFromMMProcess");
            if (MMApplicationContext.isProcessExist(b.xxk)) {
                Log.i(b.TAG, "process alive");
                h.a(b.xxk, bundle, C1398a.class, null);
            }
            AppMethodBeat.o(187037);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/jsevent/LiteAppIpcEventDispatch$Companion$IPCLiteAppDispatchEventTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "luggage-game_release"})
        /* renamed from: com.tencent.mm.plugin.game.luggage.c.b$a$a  reason: collision with other inner class name */
        public static final class C1398a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
                String str = null;
                AppMethodBeat.i(187036);
                Bundle bundle2 = bundle;
                String string = bundle2 != null ? bundle2.getString("name") : null;
                if (bundle2 != null) {
                    str = bundle2.getString("data");
                }
                Log.i(b.TAG, "invoke, ".concat(String.valueOf(string)));
                if (string != null) {
                    LiteAppCenter.onEventTriggered(string, str);
                }
                AppMethodBeat.o(187036);
            }
        }
    }

    static {
        AppMethodBeat.i(187038);
        AppMethodBeat.o(187038);
    }
}
