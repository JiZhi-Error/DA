package com.tencent.mm.plugin.finder.storage.config.item.booleantype;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "_keyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "plugin-finder_release"})
public final class a extends b<Boolean> {
    public /* synthetic */ a(boolean z, String str) {
        this(z, str, "");
        AppMethodBeat.i(251942);
        AppMethodBeat.o(251942);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(boolean z, String str, String str2) {
        super(Boolean.valueOf(z), str);
        p.h(str, "_title");
        p.h(str2, "_keyName");
        AppMethodBeat.i(251941);
        b(str2, new ArrayList(j.listOf((Object[]) new Boolean[]{Boolean.FALSE, Boolean.TRUE})), new ArrayList(j.listOf((Object[]) new String[]{"false", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE})));
        AppMethodBeat.o(251941);
    }
}
