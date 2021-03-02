package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public interface h {
    public static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);

    ByteBuffer ZL(String str);

    String n(ByteBuffer byteBuffer);

    public static class a {
        static final Map<String, h> lUN;

        static void init() {
        }

        static {
            AppMethodBeat.i(128865);
            HashMap hashMap = new HashMap();
            lUN = hashMap;
            hashMap.put("ascii", new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass1 */
                private final Charset yX = Charset.forName("US-ASCII");

                {
                    AppMethodBeat.i(128849);
                    AppMethodBeat.o(128849);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128850);
                    String str = new String(d.p(byteBuffer), this.yX);
                    AppMethodBeat.o(128850);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128851);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.yX));
                    AppMethodBeat.o(128851);
                    return wrap;
                }
            });
            lUN.put("base64", new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128852);
                    String str = new String(Base64.encode(d.p(byteBuffer), 2), UTF_8);
                    AppMethodBeat.o(128852);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128853);
                    ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(str.getBytes(UTF_8), 2));
                    AppMethodBeat.o(128853);
                    return wrap;
                }
            });
            lUN.put("hex", new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128854);
                    String bigInteger = new BigInteger(1, d.p(byteBuffer)).toString(16);
                    AppMethodBeat.o(128854);
                    return bigInteger;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128855);
                    ByteBuffer wrap = ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
                    AppMethodBeat.o(128855);
                    return wrap;
                }
            });
            final Charset forName = Charset.forName("ISO-10646-UCS-2");
            AnonymousClass4 r1 = new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128856);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(d.p(byteBuffer), forName);
                    AppMethodBeat.o(128856);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128857);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.o(128857);
                    return order;
                }
            };
            lUN.put("ucs2", r1);
            lUN.put("ucs-2", r1);
            final Charset forName2 = Charset.forName("UTF-16LE");
            AnonymousClass5 r12 = new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128858);
                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                    String str = new String(d.p(byteBuffer), forName2);
                    AppMethodBeat.o(128858);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128859);
                    ByteBuffer order = ByteBuffer.wrap(str.getBytes(forName2)).order(ByteOrder.LITTLE_ENDIAN);
                    AppMethodBeat.o(128859);
                    return order;
                }
            };
            lUN.put("utf16le", r12);
            lUN.put("utf-16le", r12);
            AnonymousClass6 r0 = new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128860);
                    String str = new String(d.p(byteBuffer), UTF_8);
                    AppMethodBeat.o(128860);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128861);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(UTF_8));
                    AppMethodBeat.o(128861);
                    return wrap;
                }
            };
            lUN.put("utf8", r0);
            lUN.put(ProtocolPackage.ServerEncoding, r0);
            AnonymousClass7 r02 = new h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.h.a.AnonymousClass7 */
                private final Charset lUQ = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);

                {
                    AppMethodBeat.i(128862);
                    AppMethodBeat.o(128862);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final String n(ByteBuffer byteBuffer) {
                    AppMethodBeat.i(128863);
                    String str = new String(d.p(byteBuffer), this.lUQ);
                    AppMethodBeat.o(128863);
                    return str;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.file.h
                public final ByteBuffer ZL(String str) {
                    AppMethodBeat.i(128864);
                    ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(this.lUQ));
                    AppMethodBeat.o(128864);
                    return wrap;
                }
            };
            lUN.put("latin1", r02);
            lUN.put("binary", r02);
            AppMethodBeat.o(128865);
        }
    }
}
