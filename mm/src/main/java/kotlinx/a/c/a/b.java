package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.d;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0016JF\u0010\r\u001a\u00020\u0006\"\b\b\u0000\u0010\u000e*\u00020\b\"\b\b\u0001\u0010\u000f*\u0002H\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lkotlinx/serialization/json/internal/ContextValidator;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "discriminator", "", "(Ljava/lang/String;)V", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "kotlinx-serialization-runtime"})
public final class b implements d {
    private final String Uag;

    public b(String str) {
        p.h(str, "discriminator");
        AppMethodBeat.i(225677);
        this.Uag = str;
        AppMethodBeat.o(225677);
    }

    @Override // kotlinx.a.d.d
    public final <T> void a(kotlin.l.b<T> bVar, h<T> hVar) {
        AppMethodBeat.i(225675);
        p.h(bVar, "kClass");
        p.h(hVar, "serializer");
        AppMethodBeat.o(225675);
    }

    @Override // kotlinx.a.d.d
    public final <Base, Sub extends Base> void a(kotlin.l.b<Base> bVar, kotlin.l.b<Sub> bVar2, h<Sub> hVar) {
        AppMethodBeat.i(225676);
        p.h(bVar, "baseClass");
        p.h(bVar2, "actualClass");
        p.h(hVar, "actualSerializer");
        n fWv = hVar.fWv();
        int hOC = fWv.hOC();
        for (int i2 = 0; i2 < hOC; i2++) {
            String awc = fWv.awc(i2);
            if (p.j(awc, this.Uag)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Polymorphic serializer for " + bVar2 + " has property '" + awc + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                AppMethodBeat.o(225676);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(225676);
    }
}
