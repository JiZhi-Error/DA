package com.tencent.mm.plugin.scanner.box;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0006R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "", "()V", "appMsgDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "Lkotlin/collections/HashMap;", "clear", "", "getAppMsgData", "key", "putAppMsgData", "shareInfo", "ScanBoxShareInfo", "plugin-scan_release"})
public final class m {
    final HashMap<String, a> CDe = new HashMap<>();

    public m() {
        AppMethodBeat.i(240291);
        AppMethodBeat.o(240291);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "", "appMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "imageUrl", "", "(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;)V", "getAppMsg", "()Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "getImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-scan_release"})
    public static final class a {
        final WXMediaMessage CDf;
        final String imageUrl;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.imageUrl, r4.imageUrl) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 240290(0x3aaa2, float:3.36718E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.scanner.box.m.a
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.scanner.box.m$a r4 = (com.tencent.mm.plugin.scanner.box.m.a) r4
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage r0 = r3.CDf
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage r1 = r4.CDf
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.imageUrl
                java.lang.String r1 = r4.imageUrl
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.m.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(240289);
            WXMediaMessage wXMediaMessage = this.CDf;
            int hashCode = (wXMediaMessage != null ? wXMediaMessage.hashCode() : 0) * 31;
            String str = this.imageUrl;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(240289);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(240288);
            String str = "ScanBoxShareInfo(appMsg=" + this.CDf + ", imageUrl=" + this.imageUrl + ")";
            AppMethodBeat.o(240288);
            return str;
        }

        public a(WXMediaMessage wXMediaMessage, String str) {
            this.CDf = wXMediaMessage;
            this.imageUrl = str;
        }
    }
}
