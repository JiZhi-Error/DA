package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class j {
    public final Object SxX;
    public final String method;

    public j(String str, Object obj) {
        this.method = str;
        this.SxX = obj;
    }

    public final <T> T btq(String str) {
        AppMethodBeat.i(9850);
        if (this.SxX == null) {
            AppMethodBeat.o(9850);
            return null;
        } else if (this.SxX instanceof Map) {
            T t = (T) ((Map) this.SxX).get(str);
            AppMethodBeat.o(9850);
            return t;
        } else if (this.SxX instanceof JSONObject) {
            T t2 = (T) ((JSONObject) this.SxX).opt(str);
            AppMethodBeat.o(9850);
            return t2;
        } else {
            ClassCastException classCastException = new ClassCastException();
            AppMethodBeat.o(9850);
            throw classCastException;
        }
    }
}
