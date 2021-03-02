package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;
import kotlinx.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f\u0001\u0003\"#$¨\u0006%"}, hxF = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;Lkotlinx/serialization/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getElementAnnotations", "", "", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"})
public abstract class an implements n {
    private final String TXI;
    private final int TXQ;
    private final n TYE;
    private final n TYF;

    private an(String str, n nVar, n nVar2) {
        this.TXI = str;
        this.TYE = nVar;
        this.TYF = nVar2;
        this.TXQ = 2;
    }

    public /* synthetic */ an(String str, n nVar, n nVar2, byte b2) {
        this(str, nVar, nVar2);
    }

    @Override // kotlinx.a.n
    public final boolean hOB() {
        return false;
    }

    @Override // kotlinx.a.n
    public final String hOz() {
        return this.TXI;
    }

    @Override // kotlinx.a.n
    public final s hOA() {
        return w.c.TXU;
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
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        switch (i2) {
            case 0:
                return this.TYE;
            case 1:
                return this.TYF;
            default:
                throw new IndexOutOfBoundsException("Map descriptor has only one child element, index: ".concat(String.valueOf(i2)));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof an)) {
            return false;
        }
        if (!p.j(this.TXI, ((an) obj).TXI)) {
            return false;
        }
        if (!p.j(this.TYE, ((an) obj).TYE)) {
            return false;
        }
        return !(p.j(this.TYF, ((an) obj).TYF) ^ true);
    }

    public int hashCode() {
        return (((this.TXI.hashCode() * 31) + this.TYE.hashCode()) * 31) + this.TYF.hashCode();
    }
}
