package kotlinx.a.b;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.a;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J%\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, hxF = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/CompositeDecoder;", "(Lkotlinx/serialization/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializer", "klassName", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serialize", "", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public abstract class b<T> implements h<T> {
    public abstract kotlin.l.b<T> hOy();

    @Override // kotlinx.a.f
    public final T a(c cVar, T t) {
        p.h(cVar, "decoder");
        p.h(t, "old");
        return (T) h.a.a(this, cVar);
    }

    @Override // kotlinx.a.v
    public final void a(g gVar, T t) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(t, "value");
        h<? extends T> b2 = b(gVar, t);
        n fWv = fWv();
        kotlinx.a.b b3 = gVar.b(fWv, new h[0]);
        b3.a(fWv(), b2.fWv().hOz());
        n fWv2 = fWv();
        if (b2 == null) {
            throw new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
        }
        b3.a(fWv2, 1, b2, t);
        b3.a(fWv);
    }

    @Override // kotlinx.a.f
    public final T a(c cVar) {
        p.h(cVar, "decoder");
        n fWv = fWv();
        a a2 = cVar.a(fWv, new h[0]);
        T t = null;
        String str = null;
        while (true) {
            int b2 = a2.b(fWv());
            if (b2 != -1) {
                if (b2 == 0) {
                    str = a2.i(fWv(), b2);
                } else if (b2 != 1) {
                    StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                    if (str == null) {
                        str = "unknown class";
                    }
                    throw new kotlinx.a.t(sb.append((Object) str).append("\n Expected 0, 1 or READ_DONE(-1), but found ").append(b2).toString(), (byte) 0);
                } else if (str == null) {
                    throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                } else {
                    t = (T) a2.a(fWv(), b2, a(a2, str));
                }
            } else if (t == null) {
                throw new IllegalArgumentException("Polymorphic value has not been read for class ".concat(String.valueOf(str)).toString());
            } else {
                a2.a(fWv);
                return t;
            }
        }
    }

    public h<? extends T> a(a aVar, String str) {
        p.h(aVar, "decoder");
        p.h(str, "klassName");
        h<? extends T> a2 = aVar.hOk().a((kotlin.l.b) hOy(), str);
        if (a2 != null) {
            return a2;
        }
        c.a(str, hOy());
        throw null;
    }

    public h<? extends T> b(g gVar, T t) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(t, "value");
        h<? extends T> a2 = gVar.hOk().a((kotlin.l.b) hOy(), (Object) t);
        if (a2 != null) {
            return a2;
        }
        kotlin.l.b bp = aa.bp(t.getClass());
        kotlin.l.b<T> hOy = hOy();
        p.h(bp, "subClass");
        p.h(hOy, "baseClass");
        c.a(bp.toString(), hOy);
        throw null;
    }
}
