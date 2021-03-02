package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "contentOrNull", "getContentOrNull", "jsonNull", "getJsonNull", "()Lkotlinx/serialization/json/JsonNull;", "kotlinx-serialization-runtime"})
public final class q extends v {
    private static final q TZT;
    public static final q TZU;
    private static final String content = BuildConfig.COMMAND;

    static {
        AppMethodBeat.i(225632);
        q qVar = new q();
        TZU = qVar;
        TZT = qVar;
        AppMethodBeat.o(225632);
    }

    private q() {
        super((byte) 0);
    }

    @Override // kotlinx.a.c.v
    public final String getContent() {
        return content;
    }
}
