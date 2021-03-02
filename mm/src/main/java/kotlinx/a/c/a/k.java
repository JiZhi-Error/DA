package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.a;
import kotlinx.a.b.b;
import kotlinx.a.c.i;
import kotlinx.a.c.m;
import kotlinx.a.c.s;
import kotlinx.a.f;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\u0004\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0002\u001a%\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a<\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\u00132\u0006\u0010\u0014\u001a\u0002H\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\b¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, hxF = {"checkKind", "", "kind", "Lkotlinx/serialization/SerialKind;", "validateIfSealed", "serializer", "Lkotlinx/serialization/KSerializer;", "actualSerializer", "", "classDiscriminator", "", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonInput;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonInput;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonOutput;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kotlinx-serialization-runtime"})
public final class k {
    public static final <T> T a(m mVar, f<T> fVar) {
        AppMethodBeat.i(225678);
        p.h(mVar, "$this$decodeSerializableValuePolymorphic");
        p.h(fVar, "deserializer");
        if (!(fVar instanceof b) || mVar.hOQ().TZf.TZy) {
            T a2 = fVar.a(mVar);
            AppMethodBeat.o(225678);
            return a2;
        }
        kotlinx.a.c.f hOR = mVar.hOR();
        if (!(hOR instanceof s)) {
            IllegalStateException illegalStateException = new IllegalStateException(("Expected " + aa.bp(s.class) + " but found " + aa.bp(hOR.getClass())).toString());
            AppMethodBeat.o(225678);
            throw illegalStateException;
        }
        s sVar = (s) hOR;
        String a3 = i.a((kotlinx.a.c.f) ae.e(sVar, mVar.hOQ().TZf.TZz));
        Map<String, kotlinx.a.c.f> map = sVar.TZX;
        if (map == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlinx.serialization.json.JsonElement>");
            AppMethodBeat.o(225678);
            throw tVar;
        }
        af.fd(map).remove(mVar.hOQ().TZf.TZz);
        h<? extends T> a4 = ((b) fVar).a((a) mVar, a3);
        if (a4 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
            AppMethodBeat.o(225678);
            throw tVar2;
        }
        T t = (T) q.a(mVar.hOQ(), sVar, a4);
        AppMethodBeat.o(225678);
        return t;
    }
}
