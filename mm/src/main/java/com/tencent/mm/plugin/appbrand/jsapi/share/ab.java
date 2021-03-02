package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "SUCCESS", "CANCEL", "FAIL", "Companion", "plugin-appbrand-integration_release"})
public enum ab {
    SUCCESS(0),
    CANCEL(1),
    FAIL(2);
    
    public static final a msY = new a((byte) 0);
    final int msX;

    public static ab valueOf(String str) {
        AppMethodBeat.i(228552);
        ab abVar = (ab) Enum.valueOf(ab.class, str);
        AppMethodBeat.o(228552);
        return abVar;
    }

    private ab(int i2) {
        this.msX = i2;
    }

    static {
        AppMethodBeat.i(228550);
        AppMethodBeat.o(228550);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "flattenVal", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ab xo(int i2) {
            AppMethodBeat.i(228549);
            ab[] values = ab.values();
            for (ab abVar : values) {
                if (i2 == abVar.msX) {
                    AppMethodBeat.o(228549);
                    return abVar;
                }
            }
            AppMethodBeat.o(228549);
            return null;
        }
    }
}
