package com.tencent.mm.plugin.messenger.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public abstract class e {
    private e.c zqT = new e.c() {
        /* class com.tencent.mm.plugin.messenger.d.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.a.e.c
        public final void a(Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(194499);
            e.this.b(map, aVar);
            AppMethodBeat.o(194499);
        }

        @Override // com.tencent.mm.plugin.messenger.a.e.c
        public final void b(String str, Map<String, String> map, Bundle bundle) {
            AppMethodBeat.i(194500);
            if (map == null) {
                Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
                AppMethodBeat.o(194500);
                return;
            }
            Log.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", str);
            e.this.c(str, map, bundle);
            AppMethodBeat.o(194500);
        }
    };

    /* access modifiers changed from: protected */
    public abstract void b(Map<String, String> map, h.a aVar);

    /* access modifiers changed from: protected */
    public abstract void c(String str, Map<String, String> map, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract String eiU();

    public e() {
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a(eiU(), this.zqT);
    }

    public final void release() {
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).b(eiU(), this.zqT);
    }

    protected static String n(Map<String, String> map, String str) {
        String str2;
        int i2 = 0;
        while (true) {
            String str3 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
            if (i2 != 0) {
                str2 = str3 + i2;
            } else {
                str2 = str3;
            }
            if (Util.isNullOrNil(map.get(str2))) {
                return null;
            }
            if (Util.isEqual(map.get(str2 + ".$type"), str)) {
                return str2;
            }
            i2++;
        }
    }
}
