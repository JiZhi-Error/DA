package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public int IxY = 0;
    a IxZ;
    public int id = 0;
    public String md5 = "";
    public String talker = "";

    /* access modifiers changed from: protected */
    public final Object clone() {
        AppMethodBeat.i(30012);
        f fVar = new f();
        fVar.id = this.id;
        fVar.talker = this.talker;
        fVar.md5 = this.md5;
        fVar.IxY = this.IxY;
        fVar.IxZ = this.IxZ;
        AppMethodBeat.o(30012);
        return fVar;
    }

    public final String toString() {
        AppMethodBeat.i(30013);
        String str = "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.md5 + ", ignoreInWatch=" + this.IxY + ", status=" + this.IxZ + "]";
        AppMethodBeat.o(30013);
        return str;
    }

    public enum a {
        INIT,
        SHOWING,
        IGNORE,
        REPLY;

        public static a valueOf(String str) {
            AppMethodBeat.i(30010);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(30010);
            return aVar;
        }

        static {
            AppMethodBeat.i(30011);
            AppMethodBeat.o(30011);
        }
    }
}
