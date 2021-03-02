package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class p implements h {
    /* JADX WARNING: Removed duplicated region for block: B:104:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b0  */
    @Override // com.tencent.mm.ak.h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ak.h.b b(com.tencent.mm.ak.h.a r11) {
        /*
        // Method dump skipped, instructions count: 861
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.p.b(com.tencent.mm.ak.h$a):com.tencent.mm.ak.h$b");
    }

    public static final class a {
        public static int GXR = 1;
        public static int GXS = 2;
        public static int GXT = 3;
        public static int GXU = 4;
        public static int GXV = 5;
        public static int GXW = 0;
        public static int GXX = 1;
        public int GXO;
        public long GXP;
        public int GXQ;
        public int status;

        public final boolean fGY() {
            return this.GXQ == GXW;
        }

        public final boolean fGZ() {
            return this.status == GXV;
        }

        public final boolean parse(String str) {
            AppMethodBeat.i(114961);
            this.GXQ = GXW;
            try {
                Map<String, String> parseXml = XmlParser.parseXml(str, "voipinvitemsg", null);
                if (parseXml != null) {
                    if (parseXml.get(".voipinvitemsg.roomid") != null) {
                        this.GXO = Util.getInt(parseXml.get(".voipinvitemsg.roomid"), 0);
                    }
                    if (parseXml.get(".voipinvitemsg.key") != null) {
                        this.GXP = Util.getLong(parseXml.get(".voipinvitemsg.key"), 0);
                    }
                    if (parseXml.get(".voipinvitemsg.status") != null) {
                        this.status = Util.getInt(parseXml.get(".voipinvitemsg.status"), 0);
                    }
                    if (parseXml.get(".voipinvitemsg.invitetype") != null) {
                        this.GXQ = Util.getInt(parseXml.get(".voipinvitemsg.invitetype"), 0);
                    }
                    AppMethodBeat.o(114961);
                    return true;
                }
                AppMethodBeat.o(114961);
                return false;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoipExtension", e2, "", new Object[0]);
                Log.e("MicroMsg.VoipExtension", "parse voip message error: %s", e2.getMessage());
                AppMethodBeat.o(114961);
                return false;
            }
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
