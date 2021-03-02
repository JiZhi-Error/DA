package com.tencent.mm.plugin.textstatus.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/cgi/TextStatusOption;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "TextStatusOptionNo", "TextStatusOptionBlur", "plugin-textstatus_release"})
public enum a {
    TextStatusOptionNo(0),
    TextStatusOptionBlur(1);
    
    public final long value;

    public static a valueOf(String str) {
        AppMethodBeat.i(216232);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(216232);
        return aVar;
    }

    private a(long j2) {
        this.value = j2;
    }

    static {
        AppMethodBeat.i(216230);
        AppMethodBeat.o(216230);
    }
}
