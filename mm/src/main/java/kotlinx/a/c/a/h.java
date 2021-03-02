package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.bj;
import kotlinx.a.c.a;
import kotlinx.a.c.e;
import kotlinx.a.c.f;
import kotlinx.a.c.s;
import kotlinx.a.j;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "endStructure", "", "kotlinx-serialization-runtime"})
class h extends a {
    private final s Uao;
    private int position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(a aVar, s sVar) {
        super(aVar, sVar, (byte) 0);
        p.h(aVar, "json");
        p.h(sVar, "value");
        AppMethodBeat.i(225658);
        this.Uao = sVar;
        AppMethodBeat.o(225658);
    }

    @Override // kotlinx.a.c.a.a
    public /* synthetic */ f hOU() {
        AppMethodBeat.i(225657);
        s hPe = hPe();
        AppMethodBeat.o(225657);
        return hPe;
    }

    public s hPe() {
        return this.Uao;
    }

    @Override // kotlinx.a.a
    public int b(n nVar) {
        boolean z;
        AppMethodBeat.i(225654);
        p.h(nVar, "descriptor");
        while (this.position < nVar.hOC()) {
            int i2 = this.position;
            this.position = i2 + 1;
            String k = l(nVar, i2);
            s hPe = hPe();
            p.h(k, "key");
            if (!(hPe instanceof s) || !hPe.TZX.containsKey(k)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                int i3 = this.position - 1;
                AppMethodBeat.o(225654);
                return i3;
            }
        }
        AppMethodBeat.o(225654);
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.a.c.a.a
    public f buH(String str) {
        AppMethodBeat.i(225655);
        p.h(str, "tag");
        f fVar = (f) ae.e(hPe(), str);
        AppMethodBeat.o(225655);
        return fVar;
    }

    @Override // kotlinx.a.a, kotlinx.a.c.a.a, kotlinx.a.b.bg
    public void a(n nVar) {
        AppMethodBeat.i(225656);
        p.h(nVar, "descriptor");
        if (this.TZf.TZr || (nVar.hOA() instanceof j)) {
            AppMethodBeat.o(225656);
            return;
        }
        Set<String> e2 = bj.e(nVar);
        for (String str : hPe().keySet()) {
            if (!e2.contains(str)) {
                String sVar = hPe().toString();
                p.h(str, "key");
                p.h(sVar, "input");
                e eVar = new e(-1, "JSON encountered unknown key: '" + str + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys.\n JSON input: " + kotlinx.a.c.l.hW(sVar, -1));
                AppMethodBeat.o(225656);
                throw eVar;
            }
        }
        AppMethodBeat.o(225656);
    }
}
