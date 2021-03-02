package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.HashMap;
import java.util.Map;

public final class au implements ab {
    private static MStorageEvent<ab, Bundle> Plk = new MStorageEvent<ab, Bundle>() {
        /* class com.tencent.mm.ui.chatting.au.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(ab abVar, Bundle bundle) {
            AppMethodBeat.i(34975);
            abVar.bu(bundle);
            AppMethodBeat.o(34975);
        }
    };
    private final Map<String, ShowMessageFromWX.Req> Pln = new HashMap();
    private Context context;

    static {
        AppMethodBeat.i(34983);
        AppMethodBeat.o(34983);
    }

    public au(Context context2) {
        AppMethodBeat.i(34978);
        this.context = context2;
        AppMethodBeat.o(34978);
    }

    public static void bv(Bundle bundle) {
        AppMethodBeat.i(34979);
        Plk.event(bundle);
        Plk.doNotify();
        AppMethodBeat.o(34979);
    }

    @Override // com.tencent.mm.ui.chatting.ab
    public final void bu(Bundle bundle) {
        AppMethodBeat.i(34980);
        Log.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"))));
        ShowMessageFromWX.Resp resp = new ShowMessageFromWX.Resp(bundle);
        Log.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (this.Pln.get(resp.transaction) == null) {
            Log.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.o(34980);
            return;
        }
        this.Pln.remove(resp.transaction);
        AppMethodBeat.o(34980);
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        AppMethodBeat.i(34981);
        a(str, wXMediaMessage, str2, str3, null);
        AppMethodBeat.o(34981);
    }

    public final void a(final String str, final WXMediaMessage wXMediaMessage, final String str2, final String str3, final al alVar) {
        AppMethodBeat.i(34982);
        Log.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", str, str3);
        a.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.au.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(34977);
                final ShowMessageFromWX.Req c2 = h.c(au.this.context, wXMediaMessage, str3);
                h.a(au.this.context, str, str2, c2, 0, new al() {
                    /* class com.tencent.mm.ui.chatting.au.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.model.app.al
                    public final void v(boolean z, boolean z2) {
                        AppMethodBeat.i(232953);
                        if (z) {
                            au.this.Pln.put(c2.transaction, c2);
                        }
                        if (alVar != null) {
                            alVar.v(z, z2);
                        }
                        AppMethodBeat.o(232953);
                    }
                }, null);
                AppMethodBeat.o(34977);
            }
        });
        AppMethodBeat.o(34982);
    }
}
