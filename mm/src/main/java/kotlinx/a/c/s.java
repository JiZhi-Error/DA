package kotlinx.a.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 42\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u00014B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0001J\u0011\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0001H\u0001J\u001f\u0010 \u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0001J\u0013\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0013\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u0003H\u0003J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001d\u001a\u00020\u0003J\"\u0010(\u001a\u0002H)\"\n\b\u0000\u0010)\u0018\u0001*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0003H\b¢\u0006\u0002\u0010*J$\u0010+\u001a\u0004\u0018\u0001H)\"\n\b\u0000\u0010)\u0018\u0001*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0003H\b¢\u0006\u0002\u0010*J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010.\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020\u0003J\u0010\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010\u001d\u001a\u00020\u0003J\b\u00101\u001a\u00020\u0013H\u0016J\t\u00102\u001a\u00020\u001cH\u0001J\b\u00103\u001a\u00020\u0003H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n0\tX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0012\u0010\u0012\u001a\u00020\u0013X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00065"}, hxF = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "jsonObject", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", "key", "containsValue", "value", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "get", "getArray", "Lkotlinx/serialization/json/JsonArray;", "getArrayOrNull", "getAs", "J", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class s extends f implements Map<String, f>, kotlin.g.b.a.a {
    public static final a TZY = new a((byte) 0);
    private final s TZW = this;
    public final Map<String, f> TZX;

    static {
        AppMethodBeat.i(225823);
        AppMethodBeat.o(225823);
    }

    public final void clear() {
        AppMethodBeat.i(225832);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225832);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.function.BiFunction] */
    @Override // java.util.Map
    public final /* synthetic */ f compute(String str, BiFunction<? super String, ? super f, ? extends f> biFunction) {
        AppMethodBeat.i(225837);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225837);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.function.Function] */
    @Override // java.util.Map
    public final /* synthetic */ f computeIfAbsent(String str, Function<? super String, ? extends f> function) {
        AppMethodBeat.i(225838);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225838);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.function.BiFunction] */
    @Override // java.util.Map
    public final /* synthetic */ f computeIfPresent(String str, BiFunction<? super String, ? super f, ? extends f> biFunction) {
        AppMethodBeat.i(225839);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225839);
        throw unsupportedOperationException;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(225831);
        boolean isEmpty = this.TZX.isEmpty();
        AppMethodBeat.o(225831);
        return isEmpty;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    @Override // java.util.Map
    public final /* synthetic */ f merge(String str, f fVar, BiFunction<? super f, ? super f, ? extends f> biFunction) {
        AppMethodBeat.i(225840);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225840);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map
    public final /* synthetic */ f put(String str, f fVar) {
        AppMethodBeat.i(225841);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225841);
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends f> map) {
        AppMethodBeat.i(225833);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225833);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map
    public final /* synthetic */ f putIfAbsent(String str, f fVar) {
        AppMethodBeat.i(225842);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225842);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Map
    public final f remove(Object obj) {
        AppMethodBeat.i(225834);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225834);
        throw unsupportedOperationException;
    }

    public final boolean remove(Object obj, Object obj2) {
        AppMethodBeat.i(225835);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225835);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map
    public final /* synthetic */ f replace(String str, f fVar) {
        AppMethodBeat.i(225844);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225844);
        throw unsupportedOperationException;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // java.util.Map
    public final /* synthetic */ boolean replace(String str, f fVar, f fVar2) {
        AppMethodBeat.i(225843);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225843);
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> biFunction) {
        AppMethodBeat.i(225836);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225836);
        throw unsupportedOperationException;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, hxF = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "Lkotlinx/serialization/json/JsonElement;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Map.Entry<? extends String, ? extends f>, String> {
        public static final b TZZ = new b();

        static {
            AppMethodBeat.i(225757);
            AppMethodBeat.o(225757);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Map.Entry<? extends String, ? extends f> entry) {
            AppMethodBeat.i(225756);
            Map.Entry<? extends String, ? extends f> entry2 = entry;
            p.h(entry2, "<name for destructuring parameter 0>");
            String str = "\"" + ((String) entry2.getKey()) + "\":" + ((f) entry2.getValue());
            AppMethodBeat.o(225756);
            return str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends kotlinx.a.c.f> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Map<String, ? extends f> map) {
        super((byte) 0);
        p.h(map, "content");
        AppMethodBeat.i(225822);
        this.TZX = map;
        AppMethodBeat.o(225822);
    }

    public final boolean containsKey(Object obj) {
        AppMethodBeat.i(225828);
        if (!(obj instanceof String)) {
            AppMethodBeat.o(225828);
            return false;
        }
        String str = (String) obj;
        p.h(str, "key");
        boolean containsKey = this.TZX.containsKey(str);
        AppMethodBeat.o(225828);
        return containsKey;
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.i(225829);
        if (!(obj instanceof f)) {
            AppMethodBeat.o(225829);
            return false;
        }
        f fVar = (f) obj;
        p.h(fVar, "value");
        boolean containsValue = this.TZX.containsValue(fVar);
        AppMethodBeat.o(225829);
        return containsValue;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Map
    public final f get(Object obj) {
        AppMethodBeat.i(225830);
        if (!(obj instanceof String)) {
            AppMethodBeat.o(225830);
            return null;
        }
        String str = (String) obj;
        p.h(str, "key");
        f fVar = this.TZX.get(str);
        AppMethodBeat.o(225830);
        return fVar;
    }

    public final String toString() {
        AppMethodBeat.i(225819);
        String a2 = j.a(this.TZX.entrySet(), ",", "{", "}", 0, (CharSequence) null, b.TZZ, 24);
        AppMethodBeat.o(225819);
        return a2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225820);
        boolean j2 = p.j(this.TZX, obj);
        AppMethodBeat.o(225820);
        return j2;
    }

    public final int hashCode() {
        AppMethodBeat.i(225821);
        int hashCode = this.TZX.hashCode();
        AppMethodBeat.o(225821);
        return hashCode;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, f>> entrySet() {
        AppMethodBeat.i(225824);
        Set<Map.Entry<String, f>> entrySet = this.TZX.entrySet();
        AppMethodBeat.o(225824);
        return entrySet;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        AppMethodBeat.i(225825);
        Set<String> keySet = this.TZX.keySet();
        AppMethodBeat.o(225825);
        return keySet;
    }

    public final /* bridge */ int size() {
        AppMethodBeat.i(225826);
        int size = this.TZX.size();
        AppMethodBeat.o(225826);
        return size;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<f> values() {
        AppMethodBeat.i(225827);
        Collection<f> values = this.TZX.values();
        AppMethodBeat.o(225827);
        return values;
    }
}
