package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.memory.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J/\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0002J.\u0010\u000f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J&\u0010\u0011\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "T", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "libimageloader_release"})
public final class a<T> extends e<T, Bitmap> {
    private static final String TAG = TAG;
    private static final int hYM = 50;
    public static final C0399a hYN = new C0399a((byte) 0);
    private final b<Bitmap> hYL = new b<>(hYM, getClass());

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.c.a, java.lang.Object] */
    @Override // com.tencent.mm.loader.b.b.e
    public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        p.h(aVar, "url");
        p.h(bitmap2, "value");
        this.hYL.put(b(aVar, aVar2), bitmap2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "getMAX_DEFAULT_BITMAP_SIZE", "()I", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.b.b.a$a  reason: collision with other inner class name */
    public static final class C0399a {
        private C0399a() {
        }

        public /* synthetic */ C0399a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final e<Bitmap> a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2) {
        p.h(aVar, "url");
        Bitmap bitmap = this.hYL.get(b(aVar, aVar2));
        if (bitmap != null) {
            return new e<>(bitmap);
        }
        return null;
    }

    @Override // com.tencent.mm.loader.b.b.e
    public final void a(com.tencent.mm.loader.h.a.a<T> aVar) {
        p.h(aVar, "url");
        this.hYL.remove(b(aVar, null));
    }
}
