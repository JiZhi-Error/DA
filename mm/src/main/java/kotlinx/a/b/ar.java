package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0004J\u0014\u0010\u0011\u001a\u00020\u0002*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0004R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, hxF = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "rootName", "(Ljava/lang/String;)V", "getRootName", "()Ljava/lang/String;", "composeName", "parentName", "childName", "elementName", "desc", "Lkotlinx/serialization/SerialDescriptor;", FirebaseAnalytics.b.INDEX, "", "nested", "nestedName", "getTag", "kotlinx-serialization-runtime"})
public abstract class ar extends bg<String> {
    private final String TYG;

    public /* synthetic */ ar() {
        this("");
    }

    private ar(String str) {
        p.h(str, "rootName");
        this.TYG = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final String l(n nVar, int i2) {
        p.h(nVar, "$this$getTag");
        String m = m(nVar, i2);
        p.h(m, "nestedName");
        String str = (String) hOJ();
        if (str == null) {
            str = this.TYG;
        }
        return oE(str, m);
    }

    public String m(n nVar, int i2) {
        p.h(nVar, "desc");
        return nVar.awc(i2);
    }

    public String oE(String str, String str2) {
        p.h(str, "parentName");
        p.h(str2, "childName");
        return str.length() == 0 ? str2 : str + '.' + str2;
    }
}
