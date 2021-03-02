package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;

public final class e {
    public static void l(final Context context, final String str, final boolean z) {
        int i2 = 1;
        AppMethodBeat.i(33811);
        yw ywVar = new yw();
        ywVar.efe.dCl = str;
        ywVar.efe.action = z ? 2 : 1;
        ywVar.efe.option = 2;
        EventCenter.instance.publish(ywVar);
        LinkedList linkedList = new LinkedList();
        eft eft = new eft();
        eft.NfM = str;
        if (!z) {
            i2 = 0;
        }
        eft.NfL = i2;
        eft.oUv = 3;
        linkedList.add(eft);
        bg.azz().a(1176, new i() {
            /* class com.tencent.mm.ui.appbrand.e.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                int i4 = 1;
                AppMethodBeat.i(33809);
                bg.azz().b(1176, this);
                Log.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.TRUE);
                if (i2 == 0 && i3 == 0) {
                    AppMethodBeat.o(33809);
                    return;
                }
                u.makeText(context, (int) R.string.fhd, 0).show();
                yw ywVar = new yw();
                ywVar.efe.dCl = str;
                yw.a aVar = ywVar.efe;
                if (!z) {
                    i4 = 2;
                }
                aVar.action = i4;
                ywVar.efe.option = 2;
                EventCenter.instance.publish(ywVar);
                AppMethodBeat.o(33809);
            }
        });
        bg.azz().a(new com.tencent.mm.modelappbrand.q(linkedList), 0);
        AppMethodBeat.o(33811);
    }

    public static String blX(String str) {
        AppMethodBeat.i(33812);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(33812);
            return null;
        }
        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
        if (Xk == null || Xk.bAn() == null) {
            Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.o(33812);
            return null;
        }
        String str2 = Xk.bAn().lgA;
        AppMethodBeat.o(33812);
        return str2;
    }

    public static String Xw(String str) {
        AppMethodBeat.i(33813);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(33813);
            return null;
        }
        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
        if (Xk == null || Xk.bAn() == null) {
            Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.o(33813);
            return null;
        }
        String str2 = Xk.field_appId;
        AppMethodBeat.o(33813);
        return str2;
    }

    public static String blY(String str) {
        AppMethodBeat.i(33814);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(33814);
            return null;
        }
        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
        if (Xk != null) {
            String str2 = Xk.field_nickname;
            AppMethodBeat.o(33814);
            return str2;
        }
        Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        AppMethodBeat.o(33814);
        return null;
    }
}
