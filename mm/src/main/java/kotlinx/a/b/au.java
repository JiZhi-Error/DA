package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.r;
import kotlinx.a.s;
import kotlinx.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020.J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0016H\u0002J\u0013\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0007H\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u0007H\u0016J\u0010\u00109\u001a\u00020.2\u0006\u00104\u001a\u00020\u0007H\u0016J\u000e\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\fJ\b\u0010>\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100 X\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006?"}, hxF = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "()I", "flags", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "getElementAnnotations", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"})
public class au implements n {
    private final String TXI;
    private final int TXQ = 6;
    private int TYJ = -1;
    final String[] TYK;
    private final List<Annotation>[] TYL;
    private final f TYM;
    private final u<?> TYN;
    private boolean[] flags;

    /* access modifiers changed from: package-private */
    public final Map<String, Integer> hOG() {
        AppMethodBeat.i(225520);
        Map<String, Integer> map = (Map) this.TYM.getValue();
        AppMethodBeat.o(225520);
        return map;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Map.Entry<? extends String, ? extends Integer>, String> {
        final /* synthetic */ au TYO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(au auVar) {
            super(1);
            this.TYO = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Map.Entry<? extends String, ? extends Integer> entry) {
            AppMethodBeat.i(225513);
            Map.Entry<? extends String, ? extends Integer> entry2 = entry;
            p.h(entry2, LocaleUtil.ITALIAN);
            String str = ((String) entry2.getKey()) + ": " + this.TYO.awd(((Number) entry2.getValue()).intValue()).hOz();
            AppMethodBeat.o(225513);
            return str;
        }
    }

    public au(String str, u<?> uVar) {
        p.h(str, "serialName");
        AppMethodBeat.i(225527);
        this.TXI = str;
        this.TYN = uVar;
        int i2 = this.TXQ;
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = "[UNINITIALIZED]";
        }
        this.TYK = strArr;
        this.TYL = new List[this.TXQ];
        this.flags = new boolean[this.TXQ];
        this.TYM = g.ah(new a(this));
        AppMethodBeat.o(225527);
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
        return this.TXQ;
    }

    @Override // kotlinx.a.n
    public final s hOA() {
        return w.a.TXS;
    }

    public final void dV(String str, boolean z) {
        AppMethodBeat.i(225521);
        p.h(str, "name");
        String[] strArr = this.TYK;
        this.TYJ++;
        strArr[this.TYJ] = str;
        this.flags[this.TYJ] = z;
        this.TYL[this.TYJ] = null;
        AppMethodBeat.o(225521);
    }

    @Override // kotlinx.a.n
    public final n awd(int i2) {
        h<?> hVar;
        n fWv;
        AppMethodBeat.i(225522);
        u<?> uVar = this.TYN;
        if (uVar == null || (hVar = uVar.fWw()[i2]) == null || (fWv = hVar.fWv()) == null) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(this.TXI + " descriptor has only " + this.TXQ + " elements, index: " + i2);
            AppMethodBeat.o(225522);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(225522);
        return fWv;
    }

    @Override // kotlinx.a.n
    public final String awc(int i2) {
        return this.TYK[i2];
    }

    @Override // kotlinx.a.n
    public final int buF(String str) {
        AppMethodBeat.i(225523);
        p.h(str, "name");
        Integer num = hOG().get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(225523);
            return intValue;
        }
        AppMethodBeat.o(225523);
        return -3;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(225524);
        if (this == obj) {
            AppMethodBeat.o(225524);
            return true;
        } else if (!(obj instanceof n)) {
            AppMethodBeat.o(225524);
            return false;
        } else if (!p.j(this.TXI, ((n) obj).hOz())) {
            AppMethodBeat.o(225524);
            return false;
        } else if (!p.j(r.d(this), r.d((n) obj))) {
            AppMethodBeat.o(225524);
            return false;
        } else {
            AppMethodBeat.o(225524);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(225526);
        String a2 = j.a(hOG().entrySet(), ", ", this.TXI + '(', ")", 0, (CharSequence) null, new b(this), 24);
        AppMethodBeat.o(225526);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Map<String, ? extends Integer>> {
        final /* synthetic */ au TYO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(au auVar) {
            super(0);
            this.TYO = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<String, ? extends Integer> invoke() {
            AppMethodBeat.i(225508);
            au auVar = this.TYO;
            HashMap hashMap = new HashMap();
            int length = auVar.TYK.length;
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(auVar.TYK[i2], Integer.valueOf(i2));
            }
            HashMap hashMap2 = hashMap;
            AppMethodBeat.o(225508);
            return hashMap2;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(225525);
        int hashCode = (this.TXI.hashCode() * 31) + r.d(this).hashCode();
        AppMethodBeat.o(225525);
        return hashCode;
    }
}
