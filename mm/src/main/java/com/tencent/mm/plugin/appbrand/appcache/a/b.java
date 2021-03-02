package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.j.a.c.k;

public interface b<_Request extends a, _Response, _Progress extends k> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0544b {
        void bwD();
    }

    public interface c {
        void bwE();
    }

    public interface a<_Response, _Progress> {
        void a(String str, EnumC0543a aVar, _Response _response);

        void cr(_Progress _progress);

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b$a$a  reason: collision with other inner class name */
        public enum EnumC0543a {
            OK(0),
            FAILED(101),
            LOCAL_FILE_NOT_FOUND(102),
            PKG_INTEGRITY_FAILED(104),
            PKG_INVALID(105),
            SEVER_FILE_NOT_FOUND(106),
            DISK_FULL(110),
            ENV_ERR(200);
            
            public final int code;

            public static EnumC0543a valueOf(String str) {
                AppMethodBeat.i(90673);
                EnumC0543a aVar = (EnumC0543a) Enum.valueOf(EnumC0543a.class, str);
                AppMethodBeat.o(90673);
                return aVar;
            }

            static {
                AppMethodBeat.i(90674);
                AppMethodBeat.o(90674);
            }

            private EnumC0543a(int i2) {
                this.code = i2;
            }

            public final int bwv() {
                return this.code;
            }
        }
    }
}
