package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l {
    private String dCw;
    public b nJe;
    public int nJf;
    public String nJg;
    private long nJh;
    public a nJi;

    public final String toString() {
        AppMethodBeat.i(48148);
        String str = "kv_13917{scene=" + this.nJe.value + ", appCount=" + this.nJf + ", nearbyListId='" + this.nJg + '\'' + ", clickTime=" + this.nJh + ", sceneNote='" + this.dCw + '\'' + ", openType=" + this.nJi.value + '}';
        AppMethodBeat.o(48148);
        return str;
    }

    public final void report() {
        AppMethodBeat.i(48149);
        if (this.nJe == null || this.nJi == null) {
            AppMethodBeat.o(48149);
            return;
        }
        Log.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
        this.nJh = Util.nowMilliSecond();
        h.INSTANCE.a(13917, s.k(Integer.valueOf(this.nJe.value), Integer.valueOf(this.nJf), this.nJg, Long.valueOf(this.nJh), this.dCw, Integer.valueOf(this.nJi.value)));
        AppMethodBeat.o(48149);
    }

    public enum b {
        DESKTOP_SEARCH(1),
        RESUME_FROM_WEAPP_EXIT(2),
        BOTTOM_ENTRANCE_IN_DESKTOP(3),
        TOP_ENTRANCE_IN_DESKTOP(4);
        
        public final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(48146);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(48146);
            return bVar;
        }

        static {
            AppMethodBeat.i(48147);
            AppMethodBeat.o(48147);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public enum a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3),
        NEARBY_MINI_PROGRAM(4);
        
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(48143);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48143);
            return aVar;
        }

        static {
            AppMethodBeat.i(48144);
            AppMethodBeat.o(48144);
        }

        private a(int i2) {
            this.value = i2;
        }
    }
}
