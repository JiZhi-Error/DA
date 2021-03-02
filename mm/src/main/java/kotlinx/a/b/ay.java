package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, hxF = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"})
public final class ay implements n {
    private final String TXI;
    private final kotlinx.a.l TYP;

    public ay(String str, kotlinx.a.l lVar) {
        p.h(str, "serialName");
        p.h(lVar, "kind");
        AppMethodBeat.i(225458);
        this.TXI = str;
        this.TYP = lVar;
        AppMethodBeat.o(225458);
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
    public final int hOC() {
        return 0;
    }

    @Override // kotlinx.a.n
    public final String awc(int i2) {
        AppMethodBeat.i(225453);
        hOH();
        AppMethodBeat.o(225453);
        throw null;
    }

    @Override // kotlinx.a.n
    public final int buF(String str) {
        AppMethodBeat.i(225454);
        p.h(str, "name");
        hOH();
        AppMethodBeat.o(225454);
        throw null;
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        AppMethodBeat.i(225455);
        hOH();
        AppMethodBeat.o(225455);
        throw null;
    }

    public final String toString() {
        AppMethodBeat.i(225456);
        String str = "PrimitiveDescriptor(" + this.TXI + ')';
        AppMethodBeat.o(225456);
        return str;
    }

    private static Void hOH() {
        AppMethodBeat.i(225457);
        IllegalStateException illegalStateException = new IllegalStateException("Primitive descriptor does not have elements");
        AppMethodBeat.o(225457);
        throw illegalStateException;
    }

    @Override // kotlinx.a.n
    public final /* bridge */ /* synthetic */ s hOA() {
        return this.TYP;
    }
}
