package kotlinx.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.a;
import kotlinx.a.c.f;
import kotlinx.a.c.o;
import kotlinx.a.c.s;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, hxF = {"Lkotlinx/serialization/json/internal/JsonTreeMapInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", FirebaseAnalytics.b.INDEX, "endStructure", "", "kotlinx-serialization-runtime"})
final class j extends h {
    private final s Uao;
    private final List<String> Uaq = kotlin.a.j.p(this.Uao.keySet());
    private int position = -1;
    private final int size = (this.Uaq.size() * 2);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, s sVar) {
        super(aVar, sVar);
        p.h(aVar, "json");
        p.h(sVar, "value");
        AppMethodBeat.i(225653);
        this.Uao = sVar;
        AppMethodBeat.o(225653);
    }

    @Override // kotlinx.a.c.a.h
    public final s hPe() {
        return this.Uao;
    }

    @Override // kotlinx.a.b.ar
    public final String m(n nVar, int i2) {
        AppMethodBeat.i(225649);
        p.h(nVar, "desc");
        String str = this.Uaq.get(i2 / 2);
        AppMethodBeat.o(225649);
        return str;
    }

    @Override // kotlinx.a.c.a.h, kotlinx.a.a
    public final int b(n nVar) {
        AppMethodBeat.i(225650);
        p.h(nVar, "descriptor");
        if (this.position < this.size - 1) {
            this.position++;
            int i2 = this.position;
            AppMethodBeat.o(225650);
            return i2;
        }
        AppMethodBeat.o(225650);
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.a.c.a.h, kotlinx.a.c.a.a
    public final f buH(String str) {
        AppMethodBeat.i(225651);
        p.h(str, "tag");
        if (this.position % 2 == 0) {
            o oVar = new o(str);
            AppMethodBeat.o(225651);
            return oVar;
        }
        f fVar = (f) ae.e(this.Uao, str);
        AppMethodBeat.o(225651);
        return fVar;
    }

    @Override // kotlinx.a.c.a.h, kotlinx.a.a, kotlinx.a.c.a.a, kotlinx.a.b.bg
    public final void a(n nVar) {
        AppMethodBeat.i(225652);
        p.h(nVar, "descriptor");
        AppMethodBeat.o(225652);
    }

    @Override // kotlinx.a.c.a.h, kotlinx.a.c.a.a
    public final /* bridge */ /* synthetic */ f hOU() {
        return this.Uao;
    }
}
