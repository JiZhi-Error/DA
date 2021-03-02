package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;
import kotlinx.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0001\u0006\u001d\u001e\u001f !\"¨\u0006#"}, hxF = {"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "elementDesc", "(Lkotlinx/serialization/SerialDescriptor;)V", "getElementDesc", "()Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getElementAnnotations", "", "", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "name", "", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "kotlinx-serialization-runtime"})
public abstract class ah implements n {
    private final int TXQ;
    private final n TYw;

    private ah(n nVar) {
        this.TYw = nVar;
        this.TXQ = 1;
    }

    public /* synthetic */ ah(n nVar, byte b2) {
        this(nVar);
    }

    @Override // kotlinx.a.n
    public final boolean hOB() {
        return false;
    }

    @Override // kotlinx.a.n
    public final s hOA() {
        return w.b.TXT;
    }

    @Override // kotlinx.a.n
    public final int hOC() {
        return this.TXQ;
    }

    @Override // kotlinx.a.n
    public final String awc(int i2) {
        return String.valueOf(i2);
    }

    @Override // kotlinx.a.n
    public final int buF(String str) {
        p.h(str, "name");
        Integer buA = kotlin.n.n.buA(str);
        if (buA != null) {
            return buA.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid list index");
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        if (i2 == 0) {
            return this.TYw;
        }
        throw new IndexOutOfBoundsException("List descriptor has only one child element, index: ".concat(String.valueOf(i2)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ah)) {
            return false;
        }
        return p.j(this.TYw, ((ah) obj).TYw) && p.j(hOz(), ((ah) obj).hOz());
    }

    public int hashCode() {
        return (this.TYw.hashCode() * 31) + hOz().hashCode();
    }
}
