package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class f implements i<Object> {
    public static final f SSk = new f();

    static {
        AppMethodBeat.i(9882);
        AppMethodBeat.o(9882);
    }

    private f() {
    }

    @Override // io.flutter.plugin.a.i
    public final ByteBuffer eP(Object obj) {
        AppMethodBeat.i(9880);
        if (obj == null) {
            AppMethodBeat.o(9880);
            return null;
        }
        Object wrap = h.wrap(obj);
        if (wrap instanceof String) {
            p pVar = p.SSt;
            ByteBuffer btr = p.btr(JSONObject.quote((String) wrap));
            AppMethodBeat.o(9880);
            return btr;
        }
        p pVar2 = p.SSt;
        ByteBuffer btr2 = p.btr(wrap.toString());
        AppMethodBeat.o(9880);
        return btr2;
    }

    @Override // io.flutter.plugin.a.i
    public final Object J(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9881);
        if (byteBuffer == null) {
            AppMethodBeat.o(9881);
            return null;
        }
        try {
            p pVar = p.SSt;
            JSONTokener jSONTokener = new JSONTokener(p.P(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid JSON");
                AppMethodBeat.o(9881);
                throw illegalArgumentException;
            }
            AppMethodBeat.o(9881);
            return nextValue;
        } catch (JSONException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid JSON", e2);
            AppMethodBeat.o(9881);
            throw illegalArgumentException2;
        }
    }
}
