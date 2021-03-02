package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J3\u0010\u001f\u001a\u00020 \"\u0006\b\u0000\u0010!\u0018\u00012\u0006\u0010\"\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010#\u001a\u00020\u0015H\bJ0\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00102\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010#\u001a\u00020\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lkotlinx/serialization/SerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "T", "elementName", "isOptional", "descriptor", "kotlinx-serialization-runtime"})
public final class o {
    boolean TXC;
    final List<String> TXD = new ArrayList();
    private final Set<String> TXE = new HashSet();
    final List<n> TXF = new ArrayList();
    final List<List<Annotation>> TXG = new ArrayList();
    final List<Boolean> TXH = new ArrayList();
    private final String TXI;
    List<? extends Annotation> TiF = v.SXr;

    public o(String str) {
        p.h(str, "serialName");
        AppMethodBeat.i(225384);
        this.TXI = str;
        AppMethodBeat.o(225384);
    }

    private void a(String str, n nVar, List<? extends Annotation> list) {
        AppMethodBeat.i(225382);
        p.h(str, "elementName");
        p.h(nVar, "descriptor");
        p.h(list, "annotations");
        if (!this.TXE.add(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Element with name '" + str + "' is already registered").toString());
            AppMethodBeat.o(225382);
            throw illegalArgumentException;
        }
        this.TXD.add(str);
        this.TXF.add(nVar);
        this.TXG.add(list);
        this.TXH.add(Boolean.FALSE);
        AppMethodBeat.o(225382);
    }

    public static /* synthetic */ void a(o oVar, String str, n nVar) {
        AppMethodBeat.i(225383);
        oVar.a(str, nVar, v.SXr);
        AppMethodBeat.o(225383);
    }
}
