package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.c.o;
import kotlinx.a.c.q;
import kotlinx.a.c.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lkotlinx/serialization/json/internal/JsonParser;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonReader;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "isString", "kotlinx-serialization-runtime"})
public final class d {
    private final boolean TZs;
    private final f Uaj;

    public d(kotlinx.a.c.d dVar, f fVar) {
        p.h(dVar, "configuration");
        p.h(fVar, "reader");
        AppMethodBeat.i(225727);
        this.Uaj = fVar;
        this.TZs = dVar.TZs;
        AppMethodBeat.o(225727);
    }

    private final f hOV() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(225723);
        f fVar = this.Uaj;
        if (fVar.Ual != 6) {
            fVar.ib("Expected start of the object", fVar.Uam);
            AppMethodBeat.o(225723);
            throw null;
        }
        this.Uaj.hPc();
        f fVar2 = this.Uaj;
        if (this.Uaj.Ual != 4) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.Uaj.zaD;
        if (!z) {
            fVar2.ib("Unexpected leading comma", i2);
            AppMethodBeat.o(225723);
            throw null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z3 = false;
        while (this.Uaj.hOY()) {
            String hOZ = this.TZs ? this.Uaj.hOZ() : this.Uaj.hPa();
            f fVar3 = this.Uaj;
            if (fVar3.Ual != 5) {
                fVar3.ib("Expected ':'", fVar3.Uam);
                AppMethodBeat.o(225723);
                throw null;
            }
            this.Uaj.hPc();
            linkedHashMap.put(hOZ, hOX());
            if (this.Uaj.Ual != 4) {
                f fVar4 = this.Uaj;
                if (fVar4.Ual != 7) {
                    fVar4.ib("Expected end of the object or comma", fVar4.Uam);
                    AppMethodBeat.o(225723);
                    throw null;
                }
                z3 = false;
            } else {
                this.Uaj.hPc();
                z3 = true;
            }
        }
        f fVar5 = this.Uaj;
        if (z3 || this.Uaj.Ual != 7) {
            z2 = false;
        }
        int i3 = this.Uaj.zaD;
        if (!z2) {
            fVar5.ib("Expected end of the object", i3);
            AppMethodBeat.o(225723);
            throw null;
        }
        this.Uaj.hPc();
        s sVar = new s(linkedHashMap);
        AppMethodBeat.o(225723);
        return sVar;
    }

    private final f hOW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(225724);
        f fVar = this.Uaj;
        if (fVar.Ual != 8) {
            fVar.ib("Expected start of the array", fVar.Uam);
            AppMethodBeat.o(225724);
            throw null;
        }
        this.Uaj.hPc();
        f fVar2 = this.Uaj;
        if (this.Uaj.Ual != 4) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.Uaj.zaD;
        if (!z) {
            fVar2.ib("Unexpected leading comma", i2);
            AppMethodBeat.o(225724);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        while (this.Uaj.hOY()) {
            arrayList.add(hOX());
            if (this.Uaj.Ual != 4) {
                f fVar3 = this.Uaj;
                if (fVar3.Ual != 9) {
                    fVar3.ib("Expected end of the array or comma", fVar3.Uam);
                    AppMethodBeat.o(225724);
                    throw null;
                }
                z3 = false;
            } else {
                this.Uaj.hPc();
                z3 = true;
            }
        }
        f fVar4 = this.Uaj;
        if (z3) {
            z2 = false;
        }
        int i3 = this.Uaj.zaD;
        if (!z2) {
            fVar4.ib("Unexpected trailing comma", i3);
            AppMethodBeat.o(225724);
            throw null;
        }
        this.Uaj.hPc();
        b bVar = new b(arrayList);
        AppMethodBeat.o(225724);
        return bVar;
    }

    private final f Fc(boolean z) {
        AppMethodBeat.i(225725);
        o oVar = new o((this.TZs || !z) ? this.Uaj.hOZ() : this.Uaj.hPa(), z);
        AppMethodBeat.o(225725);
        return oVar;
    }

    public final f hOX() {
        AppMethodBeat.i(225726);
        if (!this.Uaj.hOY()) {
            f.a(this.Uaj, "Can't begin reading value from here");
            AppMethodBeat.o(225726);
            throw null;
        }
        switch (this.Uaj.Ual) {
            case 0:
                f Fc = Fc(false);
                AppMethodBeat.o(225726);
                return Fc;
            case 1:
                f Fc2 = Fc(true);
                AppMethodBeat.o(225726);
                return Fc2;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
            default:
                f.a(this.Uaj, "Can't begin reading element, unexpected token");
                AppMethodBeat.o(225726);
                throw null;
            case 6:
                f hOV = hOV();
                AppMethodBeat.o(225726);
                return hOV;
            case 8:
                f hOW = hOW();
                AppMethodBeat.o(225726);
                return hOW;
            case 10:
                q qVar = q.TZU;
                this.Uaj.hPc();
                q qVar2 = qVar;
                AppMethodBeat.o(225726);
                return qVar2;
        }
    }
}
