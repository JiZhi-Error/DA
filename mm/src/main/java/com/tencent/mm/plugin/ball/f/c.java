package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {

    public interface a {
        void ha(boolean z);
    }

    public static void a(Context context, int i2, boolean z, a aVar) {
        AppMethodBeat.i(106333);
        if (b.cx(context)) {
            Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
            a(aVar, true);
            AppMethodBeat.o(106333);
            return;
        }
        String str = null;
        switch (i2) {
            case 6:
                str = "req_perm_cnt";
                break;
            case 16:
                str = "req_perm_cnt_game_download";
                break;
        }
        if (str != null) {
            e.ciJ();
            int agV = e.agV(str);
            Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission from type:%d reqCnt: %d", Integer.valueOf(i2), Integer.valueOf(agV));
            if (agV >= 3) {
                a(aVar, false);
                AppMethodBeat.o(106333);
                return;
            }
            e.ciJ();
            e.cz(str, agV + 1);
        }
        a(context, P(context, i2), z, aVar);
        AppMethodBeat.o(106333);
    }

    private static void a(Context context, String str, boolean z, final a aVar) {
        AppMethodBeat.i(106334);
        if (b.cx(context)) {
            Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
            a(aVar, true);
            AppMethodBeat.o(106334);
            return;
        }
        RequestFloatWindowPermissionDialog.a(context, str, new RequestFloatWindowPermissionDialog.a() {
            /* class com.tencent.mm.plugin.ball.f.c.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(106330);
                Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission granted");
                requestFloatWindowPermissionDialog.finish();
                c.a(aVar, true);
                AppMethodBeat.o(106330);
            }

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(106331);
                Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission refused");
                requestFloatWindowPermissionDialog.finish();
                c.a(aVar, false);
                AppMethodBeat.o(106331);
            }

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(186121);
                boolean cx = b.cx(MMApplicationContext.getContext());
                Log.w("MicroMsg.FloatBallPermissionUtil", "onResultCancel ok:%b", Boolean.valueOf(cx));
                requestFloatWindowPermissionDialog.finish();
                c.a(aVar, cx);
                AppMethodBeat.o(186121);
            }
        }, z, com.tencent.mm.bq.a.apJ());
        AppMethodBeat.o(106334);
    }

    private static String P(Context context, int i2) {
        String string;
        AppMethodBeat.i(106335);
        switch (i2) {
            case 1:
                string = context.getString(R.string.dd3);
                break;
            case 2:
            case 5:
                string = context.getString(R.string.dd_);
                break;
            case 3:
                string = context.getString(R.string.dd9);
                break;
            case 4:
                string = context.getString(R.string.dd6);
                break;
            case 6:
                string = context.getString(R.string.dd8);
                break;
            case 7:
                string = context.getString(R.string.dd7);
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                string = context.getString(R.string.dd2);
                break;
            case 16:
                string = context.getString(R.string.dd5);
                break;
            case 17:
                string = context.getString(R.string.dd4);
                break;
            case 18:
                string = context.getString(R.string.dd8);
                break;
        }
        AppMethodBeat.o(106335);
        return string;
    }

    static void a(a aVar, boolean z) {
        AppMethodBeat.i(106336);
        if (aVar != null) {
            aVar.ha(z);
        }
        AppMethodBeat.o(106336);
    }
}
