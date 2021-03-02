package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lkotlinx/serialization/json/JsonDecodingException;", "Lkotlinx/serialization/json/JsonException;", "offset", "", "message", "", "(ILjava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class e extends k {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(int i2, String str) {
        super("Unexpected JSON token at offset " + i2 + ": " + str);
        p.h(str, "message");
        AppMethodBeat.i(225845);
        AppMethodBeat.o(225845);
    }
}
