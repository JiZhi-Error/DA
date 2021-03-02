package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0013\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0001J\u0011\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\nH\u0001J\u0011\u0010 \u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0001J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\nH\u0001J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0001J\b\u0010#\u001a\u00020\nH\u0016J\u0011\u0010$\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\nH\u0001J\b\u0010%\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006&"}, hxF = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/SerialDescriptor;", "original", "(Lkotlinx/serialization/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "name", "", "getName", "()Ljava/lang/String;", "serialName", "getSerialName", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "getElementAnnotations", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "getElementName", "getEntityAnnotations", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class bb implements n {
    private final String TXI = (this.TYR.hOz() + "?");
    private final n TYR;

    @Override // kotlinx.a.n
    public final String awc(int i2) {
        AppMethodBeat.i(225556);
        String awc = this.TYR.awc(i2);
        AppMethodBeat.o(225556);
        return awc;
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        AppMethodBeat.i(225554);
        n awd = this.TYR.awd(i2);
        AppMethodBeat.o(225554);
        return awd;
    }

    @Override // kotlinx.a.n
    public final int buF(String str) {
        AppMethodBeat.i(225555);
        p.h(str, "name");
        int buF = this.TYR.buF(str);
        AppMethodBeat.o(225555);
        return buF;
    }

    @Override // kotlinx.a.n
    public final s hOA() {
        AppMethodBeat.i(225553);
        s hOA = this.TYR.hOA();
        AppMethodBeat.o(225553);
        return hOA;
    }

    @Override // kotlinx.a.n
    public final int hOC() {
        AppMethodBeat.i(225552);
        int hOC = this.TYR.hOC();
        AppMethodBeat.o(225552);
        return hOC;
    }

    public bb(n nVar) {
        p.h(nVar, "original");
        AppMethodBeat.i(225551);
        this.TYR = nVar;
        AppMethodBeat.o(225551);
    }

    @Override // kotlinx.a.n
    public final String hOz() {
        return this.TXI;
    }

    @Override // kotlinx.a.n
    public final boolean hOB() {
        return true;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225548);
        if (this == obj) {
            AppMethodBeat.o(225548);
            return true;
        } else if (!(obj instanceof bb)) {
            AppMethodBeat.o(225548);
            return false;
        } else if (!p.j(this.TYR, ((bb) obj).TYR)) {
            AppMethodBeat.o(225548);
            return false;
        } else {
            AppMethodBeat.o(225548);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(225549);
        String sb = new StringBuilder().append(this.TYR).append('?').toString();
        AppMethodBeat.o(225549);
        return sb;
    }

    public final int hashCode() {
        AppMethodBeat.i(225550);
        int hashCode = this.TYR.hashCode() * 31;
        AppMethodBeat.o(225550);
        return hashCode;
    }
}
