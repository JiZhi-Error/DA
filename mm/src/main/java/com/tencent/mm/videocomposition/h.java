package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"})
public final class h {
    public static final h Rhg = new h();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(216752);
        AppMethodBeat.o(216752);
    }

    private h() {
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"})
    public static final class a implements ILog {
        a() {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void i(String str, String str2) {
            AppMethodBeat.i(216745);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            b.i(sb.append(h.TAG).append(':').append(str).toString(), String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216745);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void w(String str, String str2) {
            AppMethodBeat.i(216746);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            sb.append(h.TAG).append(':').append(str);
            b.s(String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216746);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void v(String str, String str2) {
            AppMethodBeat.i(216747);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            b.v(sb.append(h.TAG).append(':').append(str).toString(), String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216747);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void e(String str, String str2) {
            AppMethodBeat.i(216748);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            b.e(sb.append(h.TAG).append(':').append(str).toString(), String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216748);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void e(String str, String str2, Throwable th) {
            AppMethodBeat.i(216749);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            b.printErrStackTrace(sb.append(h.TAG).append(':').append(str).toString(), th, String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216749);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public final void d(String str, String str2) {
            AppMethodBeat.i(216750);
            StringBuilder sb = new StringBuilder();
            h hVar = h.Rhg;
            b.d(sb.append(h.TAG).append(':').append(str).toString(), String.valueOf(str2), new Object[0]);
            AppMethodBeat.o(216750);
        }
    }

    public static void efp() {
        AppMethodBeat.i(216751);
        Logger.setLogProxy(new a());
        Logger.setLevel(2);
        AppMethodBeat.o(216751);
    }
}
