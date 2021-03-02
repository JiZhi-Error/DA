package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class g {
    public static final a sFI = new a((byte) 0);

    static {
        AppMethodBeat.i(220957);
        AppMethodBeat.o(220957);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LiveStateDao$Companion;", "", "()V", "MMKV_KEY", "", "getNoticeStartTime", "", "setNoticeStartTime", "", "value", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void Hg(int i2) {
            AppMethodBeat.i(220955);
            String valueOf = String.valueOf(i2);
            Charset charset = d.UTF_8;
            if (valueOf == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(220955);
                throw tVar;
            }
            byte[] bytes = valueOf.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            b.o("hell_live_state_mkv_key", bytes);
            AppMethodBeat.o(220955);
        }

        public static int cPm() {
            int i2 = 0;
            AppMethodBeat.i(220956);
            byte[] bytes = b.getBytes("hell_live_state_mkv_key");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    try {
                        i2 = Integer.parseInt(new String(bytes, d.UTF_8));
                        AppMethodBeat.o(220956);
                    } catch (Exception e2) {
                        AppMethodBeat.o(220956);
                    }
                    return i2;
                }
            }
            AppMethodBeat.o(220956);
            return i2;
        }
    }
}
