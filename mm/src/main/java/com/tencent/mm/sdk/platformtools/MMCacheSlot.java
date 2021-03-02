package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "", "()V", "id", "", "getId$libcompatible_release", "()J", "setId$libcompatible_release", "(J)V", "keys", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getKeys$libcompatible_release", "()Ljava/util/HashSet;", "libcompatible_release"})
public final class MMCacheSlot {
    private long id;
    private final HashSet<String> keys = new HashSet<>();

    public MMCacheSlot() {
        AppMethodBeat.i(156370);
        AppMethodBeat.o(156370);
    }

    public final long getId$libcompatible_release() {
        return this.id;
    }

    public final void setId$libcompatible_release(long j2) {
        this.id = j2;
    }

    public final HashSet<String> getKeys$libcompatible_release() {
        return this.keys;
    }
}
