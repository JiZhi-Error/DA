package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "downloadMgr", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "getDownloadMgr", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "setDownloadMgr", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;)V", "isEnablePlayInMobileNet", "", "videoService", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "getVideoService", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "setVideoService", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;)V", "isNetworkEnable", "isWifi", "setEnablePlayInMobileNet", "", "enable", "Companion", "plugin-flutter_release"})
public final class e {
    private static e wLr;
    public static final a wLs = new a((byte) 0);
    private final String TAG = "MicroMsg.FlutterVideoPlayerMgr";
    boolean wLo;
    b wLp;
    c wLq;

    static {
        AppMethodBeat.i(241178);
        AppMethodBeat.o(241178);
    }

    public e() {
        AppMethodBeat.i(241177);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        this.wLp = new b(context);
        this.wLq = new c();
        AppMethodBeat.o(241177);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "getInstance", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final e dMk() {
            AppMethodBeat.i(241174);
            e eVar = e.wLr;
            if (eVar != null) {
                AppMethodBeat.o(241174);
            } else {
                synchronized (this) {
                    try {
                        eVar = e.wLr;
                        if (eVar == null) {
                            eVar = new e();
                            e.wLr = eVar;
                        }
                    } finally {
                        AppMethodBeat.o(241174);
                    }
                }
            }
            return eVar;
        }
    }

    public static boolean dMi() {
        AppMethodBeat.i(241175);
        if (MMApplicationContext.getContext() != null) {
            boolean isNetAvailable = NetUtil.isNetAvailable(MMApplicationContext.getContext());
            AppMethodBeat.o(241175);
            return isNetAvailable;
        }
        AppMethodBeat.o(241175);
        return false;
    }

    public static boolean cGF() {
        AppMethodBeat.i(241176);
        if (MMApplicationContext.getContext() != null) {
            boolean isWifi = NetUtil.isWifi(MMApplicationContext.getContext());
            AppMethodBeat.o(241176);
            return isWifi;
        }
        AppMethodBeat.o(241176);
        return false;
    }
}
