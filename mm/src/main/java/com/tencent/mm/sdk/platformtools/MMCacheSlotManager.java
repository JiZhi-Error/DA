package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0014R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlot;", "()V", "caches", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "clearSlot", "slotId", "", "slot", "contains", "", "containsKey", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public final class MMCacheSlotManager extends BaseSlotManager<MMCacheSlot> {
    private final HashMap<String, MMCacheSlot> caches = new HashMap<>();

    public MMCacheSlotManager() {
        super(60, 0, 2, null);
        AppMethodBeat.i(156378);
        AppMethodBeat.o(156378);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final /* bridge */ /* synthetic */ void clearSlot(long j2, MMCacheSlot mMCacheSlot) {
        AppMethodBeat.i(156371);
        clearSlot(j2, mMCacheSlot);
        AppMethodBeat.o(156371);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final /* bridge */ /* synthetic */ boolean containsKey(MMCacheSlot mMCacheSlot, String str) {
        AppMethodBeat.i(156375);
        boolean containsKey = containsKey(mMCacheSlot, str);
        AppMethodBeat.o(156375);
        return containsKey;
    }

    /* access modifiers changed from: protected */
    public final void clearSlot(long j2, MMCacheSlot mMCacheSlot) {
        AppMethodBeat.i(215481);
        p.h(mMCacheSlot, "slot");
        mMCacheSlot.getKeys$libcompatible_release().clear();
        AppMethodBeat.o(215481);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final MMCacheSlot getSlotByKey(String str, long j2) {
        AppMethodBeat.i(215482);
        p.h(str, "slotKey");
        if (!this.caches.containsKey(str)) {
            this.caches.put(str, new MMCacheSlot());
        }
        MMCacheSlot mMCacheSlot = this.caches.get(str);
        if (mMCacheSlot == null) {
            p.hyc();
        }
        MMCacheSlot mMCacheSlot2 = mMCacheSlot;
        AppMethodBeat.o(215482);
        return mMCacheSlot2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final void remarkSlot(String str, long j2) {
        AppMethodBeat.i(156373);
        p.h(str, "slotKey");
        MMCacheSlot mMCacheSlot = this.caches.get(str);
        if (mMCacheSlot != null) {
            mMCacheSlot.setId$libcompatible_release(j2);
            AppMethodBeat.o(156373);
            return;
        }
        AppMethodBeat.o(156373);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final boolean verifySlot(String str, long j2) {
        AppMethodBeat.i(156374);
        p.h(str, "slotKey");
        MMCacheSlot mMCacheSlot = this.caches.get(str);
        if (mMCacheSlot == null || mMCacheSlot.getId$libcompatible_release() != j2) {
            AppMethodBeat.o(156374);
            return false;
        }
        AppMethodBeat.o(156374);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean containsKey(MMCacheSlot mMCacheSlot, String str) {
        AppMethodBeat.i(215483);
        p.h(mMCacheSlot, "slot");
        p.h(str, "key");
        boolean contains = mMCacheSlot.getKeys$libcompatible_release().contains(str);
        AppMethodBeat.o(215483);
        return contains;
    }

    public final void add(String str) {
        AppMethodBeat.i(156376);
        p.h(str, "key");
        ((MMCacheSlot) getSlot()).getKeys$libcompatible_release().add(str);
        AppMethodBeat.o(156376);
    }

    public final boolean contains(String str) {
        AppMethodBeat.i(156377);
        p.h(str, "key");
        if (findSlot(str) != null) {
            AppMethodBeat.o(156377);
            return true;
        }
        AppMethodBeat.o(156377);
        return false;
    }
}
