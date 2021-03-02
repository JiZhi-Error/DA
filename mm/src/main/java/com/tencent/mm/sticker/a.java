package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/sticker/BaseJsonObject;", "", "()V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "Companion", "plugin-sticker_release"})
public abstract class a {
    public static final C2063a NMI = new C2063a((byte) 0);
    private static final String TAG = TAG;

    public a au(JSONObject jSONObject) {
        p.h(jSONObject, "jsonObj");
        return this;
    }

    public JSONObject toJson() {
        return new JSONObject();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/sticker/BaseJsonObject$Companion;", "", "()V", "TAG", "", "parseJson", "", "jsonFile", "obj", "Lcom/tencent/mm/sticker/BaseJsonObject;", "saveJson", "plugin-sticker_release"})
    /* renamed from: com.tencent.mm.sticker.a$a  reason: collision with other inner class name */
    public static final class C2063a {
        private C2063a() {
        }

        public /* synthetic */ C2063a(byte b2) {
            this();
        }

        public static void a(String str, a aVar) {
            AppMethodBeat.i(105885);
            p.h(str, "jsonFile");
            p.h(aVar, "obj");
            try {
                JSONObject FE = h.FE(s.boY(str));
                p.g(FE, "jsonObj");
                aVar.au(FE);
                AppMethodBeat.o(105885);
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(105885);
            }
        }

        public static void a(a aVar, String str) {
            AppMethodBeat.i(105886);
            p.h(aVar, "obj");
            p.h(str, "jsonFile");
            try {
                String jSONObject = aVar.toJson().toString();
                p.g(jSONObject, "obj.toJson().toString()");
                Charset charset = d.UTF_8;
                if (jSONObject == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(105886);
                    throw tVar;
                }
                byte[] bytes = jSONObject.getBytes(charset);
                p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                s.C(str, bytes);
                AppMethodBeat.o(105886);
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(105886);
            }
        }
    }
}
