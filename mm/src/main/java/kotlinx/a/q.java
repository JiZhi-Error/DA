package kotlinx.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00060"}, hxF = {"Lkotlinx/serialization/SerialDescriptorImpl;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/SerialKind;", "elementsCount", "", "builder", "Lkotlinx/serialization/SerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/SerialKind;ILkotlinx/serialization/SerialDescriptorBuilder;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "()I", "isNullable", "", "()Z", "getKind", "()Lkotlinx/serialization/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "getElementAnnotations", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class q implements n {
    private final boolean TXC;
    private final String TXI;
    final String[] TXK;
    final n[] TXL;
    private final List<Annotation>[] TXM;
    private final boolean[] TXN;
    private final Map<String, Integer> TXO;
    private final s TXP;
    private final int TXQ;
    private final List<Annotation> TiF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends kotlin.g.b.q implements b<Integer, String> {
        final /* synthetic */ q TXR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(1);
            this.TXR = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Integer num) {
            AppMethodBeat.i(225622);
            int intValue = num.intValue();
            String str = this.TXR.TXK[intValue] + ": " + this.TXR.TXL[intValue].hOz();
            AppMethodBeat.o(225622);
            return str;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: java.util.List<? extends java.lang.annotation.Annotation>, java.util.List<java.lang.annotation.Annotation> */
    public q(String str, s sVar, int i2, o oVar) {
        p.h(str, "serialName");
        p.h(sVar, "kind");
        p.h(oVar, "builder");
        AppMethodBeat.i(225371);
        this.TXI = str;
        this.TXP = sVar;
        this.TXQ = i2;
        this.TXC = oVar.TXC;
        this.TiF = oVar.TiF;
        Object[] array = oVar.TXD.toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(225371);
            throw tVar;
        }
        this.TXK = (String[]) array;
        Object[] array2 = oVar.TXF.toArray(new n[0]);
        if (array2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(225371);
            throw tVar2;
        }
        this.TXL = (n[]) array2;
        Object[] array3 = oVar.TXG.toArray(new List[0]);
        if (array3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(225371);
            throw tVar3;
        }
        this.TXM = (List[]) array3;
        this.TXN = j.s((Collection<Boolean>) oVar.TXH);
        Iterable<y> Z = e.Z(this.TXK);
        ArrayList arrayList = new ArrayList(j.a(Z, 10));
        for (y yVar : Z) {
            arrayList.add(s.U(yVar.value, Integer.valueOf(yVar.index)));
        }
        this.TXO = ae.E(arrayList);
        AppMethodBeat.o(225371);
    }

    @Override // kotlinx.a.n
    public final String hOz() {
        return this.TXI;
    }

    @Override // kotlinx.a.n
    public final s hOA() {
        return this.TXP;
    }

    @Override // kotlinx.a.n
    public final int hOC() {
        return this.TXQ;
    }

    @Override // kotlinx.a.n
    public final boolean hOB() {
        return this.TXC;
    }

    @Override // kotlinx.a.n
    public final String awc(int i2) {
        return this.TXK[i2];
    }

    @Override // kotlinx.a.n
    public final int buF(String str) {
        AppMethodBeat.i(225367);
        p.h(str, "name");
        Integer num = this.TXO.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(225367);
            return intValue;
        }
        AppMethodBeat.o(225367);
        return -3;
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        return this.TXL[i2];
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225368);
        if (this == obj) {
            AppMethodBeat.o(225368);
            return true;
        } else if (!(obj instanceof n)) {
            AppMethodBeat.o(225368);
            return false;
        } else if (!p.j(this.TXI, ((n) obj).hOz())) {
            AppMethodBeat.o(225368);
            return false;
        } else {
            AppMethodBeat.o(225368);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(225369);
        int hashCode = this.TXI.hashCode();
        AppMethodBeat.o(225369);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(225370);
        String a2 = j.a(kotlin.k.j.mY(0, this.TXQ), ", ", this.TXI + '(', ")", 0, (CharSequence) null, new a(this), 24);
        AppMethodBeat.o(225370);
        return a2;
    }
}
