package com.tencent.mm.loader.b.b;

import com.tencent.mm.loader.h.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J/\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fH¦\u0002J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fJ3\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fH&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "T", "R", "", "()V", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getImageKey", "", "uriValue", "put", "key", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "libimageloader_release"})
public abstract class e<T, R> {
    public abstract com.tencent.mm.loader.h.e<R> a(a<T> aVar, com.tencent.mm.loader.e.c.a<R> aVar2);

    public abstract void a(a<T> aVar);

    public abstract void a(a<T> aVar, com.tencent.mm.loader.e.c.a<R> aVar2, R r);

    public static String b(a<T> aVar, com.tencent.mm.loader.e.c.a<R> aVar2) {
        if (aVar == null || !aVar.isLegal()) {
            return null;
        }
        if (aVar2 != null) {
            String aVar3 = aVar.toString();
            p.g(aVar3, "uriValue.toString()");
            String Hi = aVar2.Hi(aVar3);
            if (Hi != null) {
                return Hi;
            }
        }
        String aVar4 = aVar.toString();
        p.g(aVar4, "uriValue.toString()");
        return aVar4;
    }
}
