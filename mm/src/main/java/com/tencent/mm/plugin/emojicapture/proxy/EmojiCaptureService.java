package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import com.tencent.wxmm.v2helper;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService extends MMService {
    public static final a rrH = new a((byte) 0);
    private final String TAG = "MicroMsg.EmojiCaptureService";

    static {
        AppMethodBeat.i(v2helper.EMethodSetPlayerPreCorrectCofOn);
        AppMethodBeat.o(v2helper.EMethodSetPlayerPreCorrectCofOn);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(418);
        super.onCreate();
        Log.i(this.TAG, "onCreate: ");
        if (d.oD(26)) {
            startForeground(-2564, com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").as(com.tencent.mm.bq.a.ezb()).g(MMApplicationContext.getContext().getString(R.string.brm)).build());
        }
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.a.cJA();
        EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.rrF;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.rrE.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(b.rrI);
            AppMethodBeat.o(418);
            return;
        }
        AppMethodBeat.o(418);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b rrI = new b();

        static {
            AppMethodBeat.i(417);
            AppMethodBeat.o(417);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(416);
            AppMethodBeat.o(416);
        }
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(419);
        super.onDestroy();
        Log.i(this.TAG, "onDestroy: ");
        gxF();
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.a.cJB();
        AppMethodBeat.o(419);
    }
}
