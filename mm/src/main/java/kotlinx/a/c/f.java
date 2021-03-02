package kotlinx.a.c;

import kotlin.g.b.aa;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\b7\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0001\u0003\u0013\u000f\u0007¨\u0006\u001d"}, hxF = {"Lkotlinx/serialization/json/JsonElement;", "", "()V", "isNull", "", "()Z", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "jsonNull", "Lkotlinx/serialization/json/JsonNull;", "getJsonNull", "()Lkotlinx/serialization/json/JsonNull;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "primitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitive", "()Lkotlinx/serialization/json/JsonPrimitive;", "contains", "key", "", "error", "", "element", "Companion", "kotlinx-serialization-runtime"})
public abstract class f {
    public static final a TZF = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, hxF = {"Lkotlinx/serialization/json/JsonElement$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private f() {
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    public v hOP() {
        throw new k("Element " + aa.bp(getClass()) + " is not a " + "JsonPrimitive");
    }
}
