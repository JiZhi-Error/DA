package com.tencent.mm.loader.b.b;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.loader.h.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J/\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fH\u0002J3\u0010\u0010\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache;", "T", "R", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "Companion", "libimageloader_release"})
public final class c<T, R> extends e<T, R> {
    private static final String TAG = TAG;
    private static final int hYM = 50;
    public static final a hYT = new a((byte) 0);
    private final d<String, R> hYS = new d<>(hYM);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "getMAX_DEFAULT_BITMAP_SIZE", "()I", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final e<R> a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.e.c.a<R> aVar2) {
        p.h(aVar, "url");
        R r = this.hYS.get(b(aVar, aVar2));
        if (r != null) {
            return new e<>(r);
        }
        return null;
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final void a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.e.c.a<R> aVar2, R r) {
        p.h(aVar, "url");
        this.hYS.put(b(aVar, aVar2), r);
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final void a(com.tencent.mm.loader.h.a.a<T> aVar) {
        p.h(aVar, "url");
        this.hYS.remove(b(aVar, null));
    }
}
