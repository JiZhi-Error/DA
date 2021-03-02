package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, hxF = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "kotlin-reflection"})
public final class af {
    private final int TbM;
    ClassLoader TbN;
    private final WeakReference<ClassLoader> nsR;

    public af(ClassLoader classLoader) {
        p.h(classLoader, "classLoader");
        AppMethodBeat.i(56567);
        this.nsR = new WeakReference<>(classLoader);
        this.TbM = System.identityHashCode(classLoader);
        this.TbN = classLoader;
        AppMethodBeat.o(56567);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56565);
        if (!(obj instanceof af) || this.nsR.get() != ((af) obj).nsR.get()) {
            AppMethodBeat.o(56565);
            return false;
        }
        AppMethodBeat.o(56565);
        return true;
    }

    public final int hashCode() {
        return this.TbM;
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(56566);
        ClassLoader classLoader = this.nsR.get();
        if (classLoader == null || (str = classLoader.toString()) == null) {
            str = "<null>";
        }
        AppMethodBeat.o(56566);
        return str;
    }
}
