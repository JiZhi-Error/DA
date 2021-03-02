package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Set;

public final class a {

    /* renamed from: com.tencent.mm.plugin.location.model.a$a  reason: collision with other inner class name */
    public static class C1461a {
        Set<Long> yFC;
        private c.a yFD = new c.a() {
            /* class com.tencent.mm.plugin.location.model.a.C1461a.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
                if (r0.length() > 0) goto L_0x007e;
             */
            @Override // com.tencent.mm.modelgeo.c.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(com.tencent.mm.modelgeo.Addr r12) {
                /*
                // Method dump skipped, instructions count: 431
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.a.C1461a.AnonymousClass1.b(com.tencent.mm.modelgeo.Addr):void");
            }
        };

        public C1461a() {
            AppMethodBeat.i(55679);
            AppMethodBeat.o(55679);
        }

        public final void ecJ() {
            AppMethodBeat.i(55680);
            if (this.yFC != null) {
                this.yFC.clear();
            }
            c.bbX().a(this.yFD);
            AppMethodBeat.o(55680);
        }

        public final String[] az(ca caVar) {
            boolean z;
            int Kp;
            int Kp2;
            boolean z2 = true;
            AppMethodBeat.i(55681);
            String[] strArr = new String[2];
            String str = caVar.field_content;
            if (Util.isNullOrNil(str)) {
                strArr[0] = "";
                strArr[1] = "";
                AppMethodBeat.o(55681);
                return strArr;
            }
            if (caVar.field_isSend == 0) {
                z = true;
            } else {
                z = false;
            }
            if (ab.Eq(caVar.field_talker) && z && (Kp2 = bp.Kp(str)) != -1) {
                str = str.substring(Kp2 + 1).trim();
            }
            ca.b aEL = ((l) g.af(l.class)).eiy().aEL(str);
            if (aEL.gEa()) {
                String str2 = aEL.label;
                String str3 = aEL.kHV;
                strArr[0] = str2;
                strArr[1] = str3;
            } else {
                strArr[0] = aEL.label;
                strArr[1] = "";
            }
            if (Util.isNullOrNil(strArr[0]) && Util.isNullOrNil(strArr[1])) {
                Log.i("MicroMsg.LocationServer", "pull from sever");
                long j2 = caVar.field_msgId;
                if (this.yFC != null && !this.yFC.contains(Long.valueOf(j2))) {
                    String str4 = caVar.field_content;
                    if (caVar.field_isSend != 0) {
                        z2 = false;
                    }
                    if (ab.Eq(caVar.field_talker) && z2 && (Kp = bp.Kp(str4)) != -1) {
                        str4 = str4.substring(Kp + 1).trim();
                    }
                    ca.b bkB = ca.b.bkB(str4);
                    this.yFC.add(Long.valueOf(j2));
                    c.bbX().a(bkB.yFu, bkB.yFv, this.yFD, Long.valueOf(caVar.field_msgId));
                }
            }
            AppMethodBeat.o(55681);
            return strArr;
        }
    }
}
