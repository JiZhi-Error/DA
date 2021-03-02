package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import org.json.JSONObject;

public final class d extends a {
    public d() {
        super(8);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(g gVar, m mVar, coq coq) {
        AppMethodBeat.i(83105);
        String appId = gVar.ITw.getAppId();
        String string = gVar.mParams.getString("shortcut_user_name");
        if (!gVar.mParams.getBoolean("from_shortcut", false) && !Util.isNullOrNil(appId) && !Util.isNullOrNil(string)) {
            mVar.d(coq.KWb, coq.Title + "__" + coq.ThumbUrl);
        }
        AppMethodBeat.o(83105);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(final Context context, final g gVar, coq coq) {
        AppMethodBeat.i(83106);
        String string = gVar.mParams.getString("shortcut_user_name");
        String appId = gVar.ITw.getAppId();
        if (Util.isNullOrNil(string) || Util.isNullOrNil(appId)) {
            AppMethodBeat.o(83106);
            return;
        }
        final AddShortcutTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = appId;
        addShortcutTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(83104);
                addShortcutTask.bDK();
                gVar.ctS.a(new com.tencent.luggage.d.d() {
                    /* class com.tencent.mm.plugin.game.luggage.e.a.d.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.luggage.d.d
                    public final String name() {
                        return "onAddShortcutStatus";
                    }

                    @Override // com.tencent.luggage.d.d
                    public final JSONObject Ld() {
                        AppMethodBeat.i(83102);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("success", addShortcutTask.success);
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.o(83102);
                        return jSONObject;
                    }
                });
                if (addShortcutTask.success) {
                    h.a(context, (int) R.string.j42, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.luggage.e.a.d.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(83103);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(83103);
                        }
                    });
                    AppMethodBeat.o(83104);
                    return;
                }
                Toast.makeText(context, context.getString(R.string.j41), 0).show();
                AppMethodBeat.o(83104);
            }
        };
        addShortcutTask.bDJ();
        AppBrandMainProcessService.a(addShortcutTask);
        AppMethodBeat.o(83106);
    }
}
