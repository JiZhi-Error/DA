package com.tencent.mm.plugin.textstatus.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "", "subTypeShowName", "", "typeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubTypeShowName", "()Ljava/lang/String;", "getTypeName", "plugin-textstatus_release"})
public final class j {
    final String Vdd;
    final String typeName;

    public j(String str, String str2) {
        p.h(str, "subTypeShowName");
        p.h(str2, "typeName");
        AppMethodBeat.i(258351);
        this.Vdd = str;
        this.typeName = str2;
        AppMethodBeat.o(258351);
    }
}
