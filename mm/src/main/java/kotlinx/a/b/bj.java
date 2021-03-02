package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0001H\u0000\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t*\u0006\u0012\u0002\b\u00030\bH\b\u001a\u0018\u0010\n\u001a\u00020\u000b*\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, hxF = {"defer", "Lkotlinx/serialization/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/KSerializer;", "T", "readExactNBytes", "", "Ljava/io/InputStream;", "Lkotlinx/io/InputStream;", "bytes", "", "kotlinx-serialization-runtime"})
public final class bj {
    public static final Set<String> e(n nVar) {
        AppMethodBeat.i(225472);
        p.h(nVar, "$this$cachedSerialNames");
        if (nVar instanceof au) {
            Set<String> keySet = ((au) nVar).hOG().keySet();
            AppMethodBeat.o(225472);
            return keySet;
        }
        HashSet hashSet = new HashSet(nVar.hOC());
        int hOC = nVar.hOC();
        for (int i2 = 0; i2 < hOC; i2++) {
            hashSet.add(nVar.awc(i2));
        }
        HashSet hashSet2 = hashSet;
        AppMethodBeat.o(225472);
        return hashSet2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, hxF = {"kotlinx/serialization/internal/UtilKt$defer$1", "Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", FirebaseAnalytics.b.INDEX, "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-runtime"})
    public static final class a implements n {
        private final f TZc;
        final /* synthetic */ kotlin.g.a.a TZd;

        private final n hOM() {
            AppMethodBeat.i(225424);
            n nVar = (n) this.TZc.getValue();
            AppMethodBeat.o(225424);
            return nVar;
        }

        a(kotlin.g.a.a aVar) {
            this.TZd = aVar;
            AppMethodBeat.i(225431);
            this.TZc = g.ah(aVar);
            AppMethodBeat.o(225431);
        }

        @Override // kotlinx.a.n
        public final boolean hOB() {
            return false;
        }

        @Override // kotlinx.a.n
        public final String hOz() {
            AppMethodBeat.i(225425);
            String hOz = hOM().hOz();
            AppMethodBeat.o(225425);
            return hOz;
        }

        @Override // kotlinx.a.n
        public final s hOA() {
            AppMethodBeat.i(225426);
            s hOA = hOM().hOA();
            AppMethodBeat.o(225426);
            return hOA;
        }

        @Override // kotlinx.a.n
        public final int hOC() {
            AppMethodBeat.i(225427);
            int hOC = hOM().hOC();
            AppMethodBeat.o(225427);
            return hOC;
        }

        @Override // kotlinx.a.n
        public final String awc(int i2) {
            AppMethodBeat.i(225428);
            String awc = hOM().awc(i2);
            AppMethodBeat.o(225428);
            return awc;
        }

        @Override // kotlinx.a.n
        public final int buF(String str) {
            AppMethodBeat.i(225429);
            p.h(str, "name");
            int buF = hOM().buF(str);
            AppMethodBeat.o(225429);
            return buF;
        }

        @Override // kotlinx.a.n
        public final n awd(int i2) {
            AppMethodBeat.i(225430);
            n awd = hOM().awd(i2);
            AppMethodBeat.o(225430);
            return awd;
        }
    }

    public static final n ap(kotlin.g.a.a<? extends n> aVar) {
        AppMethodBeat.i(225473);
        p.h(aVar, "deferred");
        a aVar2 = new a(aVar);
        AppMethodBeat.o(225473);
        return aVar2;
    }
}
