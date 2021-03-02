package com.tencent.mm.plugin.downloader_app.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {

    public interface b {
        void a(EnumC0947a aVar, long j2);
    }

    public interface c {
        void bEx();
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.api.a$a  reason: collision with other inner class name */
    public enum EnumC0947a {
        OK,
        FAIL,
        WAIT_FOR_WIFI,
        CANCEL;

        public static EnumC0947a valueOf(String str) {
            AppMethodBeat.i(153081);
            EnumC0947a aVar = (EnumC0947a) Enum.valueOf(EnumC0947a.class, str);
            AppMethodBeat.o(153081);
            return aVar;
        }

        static {
            AppMethodBeat.i(153082);
            AppMethodBeat.o(153082);
        }
    }
}
