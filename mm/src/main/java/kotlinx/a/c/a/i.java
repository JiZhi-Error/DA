package kotlinx.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.a;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lkotlinx/serialization/json/internal/JsonTreeListInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", FirebaseAnalytics.b.INDEX, "kotlinx-serialization-runtime"})
final class i extends a {
    private final b Uap;
    private int currentIndex = -1;
    private final int size = this.Uap.TZn.size();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(a aVar, b bVar) {
        super(aVar, bVar, (byte) 0);
        p.h(aVar, "json");
        p.h(bVar, "value");
        AppMethodBeat.i(225717);
        this.Uap = bVar;
        AppMethodBeat.o(225717);
    }

    @Override // kotlinx.a.b.ar
    public final String m(n nVar, int i2) {
        AppMethodBeat.i(225714);
        p.h(nVar, "desc");
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(225714);
        return valueOf;
    }

    @Override // kotlinx.a.a
    public final int b(n nVar) {
        AppMethodBeat.i(225716);
        p.h(nVar, "descriptor");
        if (this.currentIndex < this.size - 1) {
            this.currentIndex++;
            int i2 = this.currentIndex;
            AppMethodBeat.o(225716);
            return i2;
        }
        AppMethodBeat.o(225716);
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.a.c.a.a
    public final f buH(String str) {
        AppMethodBeat.i(225715);
        p.h(str, "tag");
        f awe = this.Uap.awe(Integer.parseInt(str));
        AppMethodBeat.o(225715);
        return awe;
    }

    @Override // kotlinx.a.c.a.a
    public final /* bridge */ /* synthetic */ f hOU() {
        return this.Uap;
    }
}
