package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class u {
    public int backgroundColor;
    public String chatroomName;
    public ca dTX = null;
    public Object data;
    public int end;
    public int fRg;
    public int fromScene = 0;
    public int linkColor;
    public String mSessionId;
    public int start;
    public String tOw;
    public Object tXF;
    public int type;
    public String url;
    public String username;

    @Deprecated
    public u(int i2, int i3) {
        this.start = i2;
        this.end = i3;
        this.url = null;
        this.type = 0;
        this.data = null;
    }

    public u(String str, int i2, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i2;
    }

    public final <T> T ba(Class<T> cls) {
        AppMethodBeat.i(152234);
        if (cls.isInstance(this.data)) {
            T cast = cls.cast(this.data);
            AppMethodBeat.o(152234);
            return cast;
        }
        AppMethodBeat.o(152234);
        return null;
    }

    public final int hashCode() {
        AppMethodBeat.i(152235);
        int hashCode = super.hashCode();
        if (!Util.isNullOrNil(this.url)) {
            hashCode += this.url.hashCode();
        }
        int i2 = hashCode + this.type + this.end + this.start;
        if (this.data != null) {
            i2 += this.data.hashCode();
        }
        AppMethodBeat.o(152235);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(152236);
        if (!(obj instanceof u)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(152236);
            return equals;
        } else if (hashCode() == ((u) obj).hashCode()) {
            AppMethodBeat.o(152236);
            return true;
        } else {
            AppMethodBeat.o(152236);
            return false;
        }
    }
}
