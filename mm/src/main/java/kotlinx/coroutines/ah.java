package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, hxF = {"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"})
public final class ah extends kotlin.d.a {
    public static final a TTW = new a((byte) 0);
    final String name;

    static {
        AppMethodBeat.i(118179);
        AppMethodBeat.o(118179);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118181);
        if (this == obj || ((obj instanceof ah) && p.j(this.name, ((ah) obj).name))) {
            AppMethodBeat.o(118181);
            return true;
        }
        AppMethodBeat.o(118181);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(118180);
        String str = this.name;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(118180);
            return hashCode;
        }
        AppMethodBeat.o(118180);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lkotlinx/coroutines/CoroutineName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineName;", "()V", "kotlinx-coroutines-core"})
    public static final class a implements f.c<ah> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String toString() {
        AppMethodBeat.i(118178);
        String str = "CoroutineName(" + this.name + ')';
        AppMethodBeat.o(118178);
        return str;
    }
}
