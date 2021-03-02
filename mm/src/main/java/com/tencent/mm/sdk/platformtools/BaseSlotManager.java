package com.tencent.mm.sdk.platformtools;

import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\fH$¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0002\u0010!J\u000b\u0010\"\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0004H$¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0004H$J\u0006\u0010(\u001a\u00020\u0018J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0004H$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00020\f*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0006*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlot", "()Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"})
public abstract class BaseSlotManager<T> {
    private final int SLOT_SIZE;
    private final String prefix;
    private final long soltSeconds;
    private final long[] verifiedCache;

    public BaseSlotManager() {
        this(0, 0, 3, null);
    }

    /* access modifiers changed from: protected */
    public abstract void clearSlot(long j2, T t);

    /* access modifiers changed from: protected */
    public abstract boolean containsKey(T t, String str);

    /* access modifiers changed from: protected */
    public abstract T getSlotByKey(String str, long j2);

    /* access modifiers changed from: protected */
    public abstract void remarkSlot(String str, long j2);

    /* access modifiers changed from: protected */
    public abstract boolean verifySlot(String str, long j2);

    public BaseSlotManager(long j2, int i2) {
        this.soltSeconds = j2;
        this.SLOT_SIZE = i2;
        this.prefix = "_slots_id" + (this.soltSeconds == 900 ? "" : "_" + this.soltSeconds) + '_';
        int i3 = this.SLOT_SIZE;
        long[] jArr = new long[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i4] = -1;
        }
        this.verifiedCache = jArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseSlotManager(long j2, int i2, int i3, j jVar) {
        this((i3 & 1) != 0 ? 900 : j2, (i3 & 2) != 0 ? 3 : i2);
    }

    /* access modifiers changed from: private */
    public final int getToSlot(long j2) {
        return (int) (((j2 % ((long) this.SLOT_SIZE)) + ((long) this.SLOT_SIZE)) % 3);
    }

    /* access modifiers changed from: protected */
    public String getPrefix() {
        return this.prefix;
    }

    /* access modifiers changed from: private */
    public final String getKey(int i2) {
        return getPrefix() + (i2 % this.SLOT_SIZE);
    }

    private final long getCurrentSlotId() {
        return MMSlotKt.now() / (this.soltSeconds * 1000);
    }

    public static /* synthetic */ Object getSlotByKey$default(BaseSlotManager baseSlotManager, String str, long j2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSlotByKey");
        }
        if ((i2 & 2) != 0) {
            j2 = -1;
        }
        return baseSlotManager.getSlotByKey(str, j2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: com.tencent.mm.sdk.platformtools.BaseSlotManager<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void verifyAllSlot() {
        long currentSlotId = getCurrentSlotId();
        long j2 = currentSlotId - 1;
        long j3 = currentSlotId + 1;
        if (j2 <= j3) {
            while (true) {
                int toSlot = getToSlot(j2);
                String key = getKey(toSlot);
                if (this.verifiedCache[toSlot] != j2) {
                    if (!verifySlot(key, j2)) {
                        clearSlot(j2, getSlotByKey$default(this, key, 0, 2, null));
                        if (j2 == currentSlotId) {
                            remarkSlot(key, j2);
                        }
                    }
                    this.verifiedCache[toSlot] = j2;
                }
                if (j2 != j3) {
                    j2 = 1 + j2;
                } else {
                    return;
                }
            }
        }
    }

    public final T findSlot(String str) {
        p.h(str, "key");
        verifyAllSlot();
        long currentSlotId = getCurrentSlotId();
        BaseSlotManager$findSlot$1 baseSlotManager$findSlot$1 = new BaseSlotManager$findSlot$1(this);
        T t = (T) baseSlotManager$findSlot$1.invoke(currentSlotId, str);
        if (t != null) {
            return t;
        }
        T t2 = (T) baseSlotManager$findSlot$1.invoke(currentSlotId - 1, str);
        if (t2 == null) {
            return null;
        }
        return t2;
    }

    public final T getSlot() {
        verifyAllSlot();
        long currentSlotId = getCurrentSlotId();
        return getSlotByKey(getKey(getToSlot(currentSlotId)), currentSlotId);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.mm.sdk.platformtools.BaseSlotManager<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void clearAll() {
        int i2 = 0;
        int i3 = this.SLOT_SIZE;
        if (i3 >= 0) {
            while (true) {
                clearSlot(-1, getSlotByKey$default(this, getKey(i2), 0, 2, null));
                if (i2 != i3) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
