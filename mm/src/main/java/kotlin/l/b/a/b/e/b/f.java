package kotlin.l.b.a.b.e.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.h.i;

public final class f {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.b.h.i$f<M extends kotlin.l.b.a.b.h.i$c<M>, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends i.c<M>, T> T a(i.c<M> cVar, i.f<M, T> fVar) {
        AppMethodBeat.i(59069);
        p.h(cVar, "$this$getExtensionOrNull");
        p.h(fVar, ShareConstants.MEDIA_EXTENSION);
        if (cVar.c(fVar)) {
            T t = (T) cVar.e(fVar);
            AppMethodBeat.o(59069);
            return t;
        }
        AppMethodBeat.o(59069);
        return null;
    }
}
