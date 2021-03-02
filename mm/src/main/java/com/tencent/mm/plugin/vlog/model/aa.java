package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class aa {
    public static final aa Gzi = new aa();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(190657);
        AppMethodBeat.o(190657);
    }

    private aa() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-vlog_release"})
    public static final class a implements ILog {
        a() {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void i(String str, String str2) {
            AppMethodBeat.i(190645);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.i(sb.append(aa.TAG).append(':').append(str).toString(), str2);
            AppMethodBeat.o(190645);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void w(String str, String str2) {
            AppMethodBeat.i(190646);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.w(sb.append(aa.TAG).append(':').append(str).toString(), String.valueOf(str2));
            AppMethodBeat.o(190646);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void v(String str, String str2) {
            AppMethodBeat.i(190647);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.v(sb.append(aa.TAG).append(':').append(str).toString(), String.valueOf(str2));
            AppMethodBeat.o(190647);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void e(String str, String str2) {
            AppMethodBeat.i(190648);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.e(sb.append(aa.TAG).append(':').append(str).toString(), String.valueOf(str2));
            AppMethodBeat.o(190648);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void e(String str, String str2, Throwable th) {
            AppMethodBeat.i(190649);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.printErrStackTrace(sb.append(aa.TAG).append(':').append(str).toString(), th, String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(190649);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void d(String str, String str2) {
            AppMethodBeat.i(190650);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.d(sb.append(aa.TAG).append(':').append(str).toString(), String.valueOf(str2));
            AppMethodBeat.o(190650);
        }
    }

    public static void efp() {
        AppMethodBeat.i(190656);
        Logger.setLogProxy(new a());
        Logger.setLevel(2);
        Logger.setLevel(2);
        Logger.setLevel(2);
        com.tencent.mm.videocomposition.c.b bVar = com.tencent.mm.videocomposition.c.b.Rii;
        com.tencent.mm.videocomposition.c.b.a(new b());
        AppMethodBeat.o(190656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-vlog_release"})
    public static final class b implements b.a {
        b() {
        }

        @Override // com.tencent.mm.videocomposition.c.b.a
        public final void lh(String str, String str2) {
            AppMethodBeat.i(190651);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.d(sb.append(aa.TAG).append(':').append(str).toString(), str2);
            AppMethodBeat.o(190651);
        }

        @Override // com.tencent.mm.videocomposition.c.b.a
        public final void li(String str, String str2) {
            AppMethodBeat.i(190652);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.e(sb.append(aa.TAG).append(':').append(str).toString(), str2);
            AppMethodBeat.o(190652);
        }

        @Override // com.tencent.mm.videocomposition.c.b.a
        public final void lj(String str, String str2) {
            AppMethodBeat.i(190653);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.i(sb.append(aa.TAG).append(':').append(str).toString(), str2);
            AppMethodBeat.o(190653);
        }

        @Override // com.tencent.mm.videocomposition.c.b.a
        public final void lk(String str, String str2) {
            AppMethodBeat.i(190654);
            StringBuilder sb = new StringBuilder();
            aa aaVar = aa.Gzi;
            Log.v(sb.append(aa.TAG).append(':').append(str).toString(), str2);
            AppMethodBeat.o(190654);
        }

        @Override // com.tencent.mm.videocomposition.c.b.a
        public final void aTZ(String str) {
            AppMethodBeat.i(190655);
            aa aaVar = aa.Gzi;
            Log.w(aa.TAG, str);
            AppMethodBeat.o(190655);
        }
    }
}
