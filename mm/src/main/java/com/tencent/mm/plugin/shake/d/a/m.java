package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class m {

    public static class e {
        public String dVu;
        public String link;
        public String thumbUrl;
        public String title;

        private e() {
        }

        public static e aNr(String str) {
            e eVar;
            AppMethodBeat.i(28345);
            Map<String, String> parseXml = XmlParser.parseXml(str, "h5url", null);
            if (parseXml != null) {
                try {
                    e eVar2 = new e();
                    eVar2.title = Util.nullAsNil(parseXml.get(".h5url.title"));
                    eVar2.thumbUrl = Util.nullAsNil(parseXml.get(".h5url.thumburl"));
                    eVar2.link = Util.nullAsNil(parseXml.get(".h5url.link"));
                    eVar2.dVu = Util.nullAsNil(parseXml.get(".h5url.username"));
                    eVar = eVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    eVar = null;
                }
            } else {
                eVar = null;
            }
            AppMethodBeat.o(28345);
            return eVar;
        }
    }

    public static class f {
        public String Dje;
        public String nickName;
        public String userName;

        private f() {
        }

        public static f aNs(String str) {
            f fVar;
            AppMethodBeat.i(28346);
            Map<String, String> parseXml = XmlParser.parseXml(str, "bizprofile", null);
            if (parseXml != null) {
                try {
                    f fVar2 = new f();
                    fVar2.nickName = Util.nullAsNil(parseXml.get(".bizprofile.nickname"));
                    fVar2.userName = Util.nullAsNil(parseXml.get(".bizprofile.username"));
                    fVar2.Dje = Util.nullAsNil(parseXml.get(".bizprofile.showchat"));
                    fVar = fVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    fVar = null;
                }
            } else {
                fVar = null;
            }
            AppMethodBeat.o(28346);
            return fVar;
        }
    }

    public static class b {
        public String Djc;
        public String price;
        public String thumbUrl;
        public String title;

        private b() {
        }

        public static b aNo(String str) {
            b bVar;
            AppMethodBeat.i(28342);
            Map<String, String> parseXml = XmlParser.parseXml(str, "nativepay", null);
            if (parseXml != null) {
                try {
                    b bVar2 = new b();
                    bVar2.title = Util.nullAsNil(parseXml.get(".nativepay.title"));
                    bVar2.thumbUrl = Util.nullAsNil(parseXml.get(".nativepay.thumburl"));
                    bVar2.Djc = Util.nullAsNil(parseXml.get(".nativepay.wx_pay_url"));
                    bVar2.price = Util.nullAsNil(parseXml.get(".nativepay.price"));
                    bVar = bVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    bVar = null;
                }
            } else {
                bVar = null;
            }
            AppMethodBeat.o(28342);
            return bVar;
        }
    }

    public static class c {
        public String id;
        public String thumbUrl;
        public String title;

        private c() {
        }

        public static c aNp(String str) {
            c cVar;
            AppMethodBeat.i(28343);
            Map<String, String> parseXml = XmlParser.parseXml(str, "product", null);
            if (parseXml != null) {
                try {
                    c cVar2 = new c();
                    cVar2.title = Util.nullAsNil(parseXml.get(".product.title"));
                    cVar2.thumbUrl = Util.nullAsNil(parseXml.get(".product.thumburl"));
                    cVar2.id = Util.nullAsNil(parseXml.get(".product.product_id"));
                    cVar = cVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    cVar = null;
                }
            } else {
                cVar = null;
            }
            AppMethodBeat.o(28343);
            return cVar;
        }
    }

    public static class d {
        public String Djd;
        public String thumbUrl;
        public String title;
        public String username;

        private d() {
        }

        public static d aNq(String str) {
            d dVar;
            AppMethodBeat.i(28344);
            Map<String, String> parseXml = XmlParser.parseXml(str, "tempsession", null);
            if (parseXml != null) {
                try {
                    d dVar2 = new d();
                    dVar2.title = Util.nullAsNil(parseXml.get(".tempsession.title"));
                    dVar2.thumbUrl = Util.nullAsNil(parseXml.get(".tempsession.thumburl"));
                    dVar2.username = Util.nullAsNil(parseXml.get(".tempsession.username"));
                    dVar2.Djd = Util.nullAsNil(parseXml.get(".tempsession.deeplinkjumpurl"));
                    dVar = dVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    dVar = null;
                }
            } else {
                dVar = null;
            }
            AppMethodBeat.o(28344);
            return dVar;
        }
    }

    public static class a {
        public String path;
        public String thumbUrl;
        public String title;
        public String username;
        public int version;

        private a() {
        }

        public static a aNn(String str) {
            a aVar;
            AppMethodBeat.i(28341);
            Map<String, String> parseXml = XmlParser.parseXml(str, "program", null);
            if (parseXml != null) {
                try {
                    a aVar2 = new a();
                    aVar2.title = Util.nullAsNil(parseXml.get(".program.title"));
                    aVar2.thumbUrl = Util.nullAsNil(parseXml.get(".program.thumburl"));
                    aVar2.username = Util.nullAsNil(parseXml.get(".program.username"));
                    aVar2.path = Util.nullAsNil(parseXml.get(".program.path"));
                    aVar2.version = Util.getInt(parseXml.get(".program.version"), 0);
                    aVar = aVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e2, "", new Object[0]);
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            AppMethodBeat.o(28341);
            return aVar;
        }
    }
}
