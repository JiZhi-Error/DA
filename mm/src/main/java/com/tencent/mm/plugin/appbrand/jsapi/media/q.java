package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants;", "", "Capture", "MediaEnum", "MediaType", "SourceType", "plugin-appbrand-integration_release"})
public interface q {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
    public enum d implements b {
        ALBUM(1),
        CAMERA(2);
        
        public static final a meE = new a((byte) 0);
        private final int cSx;

        public static d valueOf(String str) {
            AppMethodBeat.i(50579);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(50579);
            return dVar;
        }

        private d(int i2) {
            this.cSx = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final int getFlag() {
            return this.cSx;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final /* synthetic */ String getName() {
            AppMethodBeat.i(50577);
            String name = name();
            AppMethodBeat.o(50577);
            return name;
        }

        static {
            AppMethodBeat.i(50576);
            AppMethodBeat.o(50576);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "FRONT", "BACK", "Companion", "plugin-appbrand-integration_release"})
    public enum a implements b {
        FRONT(1),
        BACK(2);
        
        public static final C0679a meu = new C0679a((byte) 0);
        private final int cSx;

        public static a valueOf(String str) {
            AppMethodBeat.i(50568);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(50568);
            return aVar;
        }

        private a(int i2) {
            this.cSx = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final int getFlag() {
            return this.cSx;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final /* synthetic */ String getName() {
            AppMethodBeat.i(50566);
            String name = name();
            AppMethodBeat.o(50566);
            return name;
        }

        static {
            AppMethodBeat.i(50565);
            AppMethodBeat.o(50565);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.q$a$a  reason: collision with other inner class name */
        public static final class C0679a {
            private C0679a() {
            }

            public /* synthetic */ C0679a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", ShareConstants.IMAGE_URL, ShareConstants.VIDEO_URL, "Companion", "plugin-appbrand-integration_release"})
    public enum c implements b {
        mex(1),
        mey(2);
        
        public static final a meA = new a((byte) 0);
        final int cSx;

        public static c valueOf(String str) {
            AppMethodBeat.i(50575);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(50575);
            return cVar;
        }

        private c(int i2) {
            this.cSx = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final int getFlag() {
            return this.cSx;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.q.b
        public final /* synthetic */ String getName() {
            AppMethodBeat.i(50573);
            String name = name();
            AppMethodBeat.o(50573);
            return name;
        }

        static {
            AppMethodBeat.i(50572);
            AppMethodBeat.o(50572);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "", "flag", "", "getFlag", "()I", "name", "", "getName", "()Ljava/lang/String;", "contains", "", "flags", "equals", "Parser", "plugin-appbrand-integration_release"})
    public interface b {
        public static final C0680b mev = C0680b.mew;

        int getFlag();

        String getName();

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static boolean a(b bVar, int i2) {
                AppMethodBeat.i(50569);
                if (i2 == bVar.getFlag()) {
                    AppMethodBeat.o(50569);
                    return true;
                }
                AppMethodBeat.o(50569);
                return false;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum$Parser;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "field", "", BuildConfig.KINDA_DEFAULT, "enums", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;)I", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.q$b$b  reason: collision with other inner class name */
        public static final class C0680b {
            static final /* synthetic */ C0680b mew = new C0680b();

            static {
                AppMethodBeat.i(50571);
                AppMethodBeat.o(50571);
            }

            private C0680b() {
            }

            public static int a(JSONObject jSONObject, String str, String str2, b[] bVarArr) {
                int i2;
                AppMethodBeat.i(50570);
                p.h(jSONObject, "json");
                p.h(str, "field");
                p.h(str2, BuildConfig.KINDA_DEFAULT);
                p.h(bVarArr, "enums");
                String optString = jSONObject.optString(str, str2);
                int i3 = 0;
                for (b bVar : bVarArr) {
                    p.g(optString, "value");
                    String str3 = optString;
                    String name = bVar.getName();
                    if (name == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(50570);
                        throw tVar;
                    }
                    String lowerCase = name.toLowerCase();
                    p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (n.a((CharSequence) str3, (CharSequence) lowerCase, false)) {
                        i2 = bVar.getFlag() | i3;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
                AppMethodBeat.o(50570);
                return i3;
            }
        }
    }
}
