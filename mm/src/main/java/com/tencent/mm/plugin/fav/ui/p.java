package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import java.util.List;

public final class p {

    public interface a {
        void cVU();
    }

    public static void a(Activity activity, boolean z, Intent intent) {
        AppMethodBeat.i(107057);
        Bundle bundle = null;
        if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(activity, new Pair[0]).toBundle();
        }
        if (z) {
            intent.putExtra("key_search_type", 2);
            b.a(activity, ".ui.FavSearchUI", intent, 4103, bundle);
            AppMethodBeat.o(107057);
            return;
        }
        b.a(activity, ".ui.FavSearchUI", intent, bundle);
        AppMethodBeat.o(107057);
    }

    public static void b(Activity activity, boolean z, Intent intent) {
        AppMethodBeat.i(107058);
        Bundle bundle = null;
        if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(activity, new Pair[0]).toBundle();
        }
        if (z) {
            intent.putExtra("key_search_type", 2);
            b.a(activity, ".ui.FavFilterUI", intent, 4103, bundle);
            AppMethodBeat.o(107058);
            return;
        }
        b.a(activity, ".ui.FavFilterUI", intent, bundle);
        AppMethodBeat.o(107058);
    }

    public static boolean b(Context context, int i2, com.tencent.mm.plugin.fav.ui.a.b bVar, g gVar) {
        int i3 = 0;
        AppMethodBeat.i(107059);
        if (i2 == 4105) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 1);
            intent.putExtra("mutil_select_is_ret", true);
            if (bVar.cWp() == 1) {
                g gVar2 = bVar.mE(false).get(0);
                intent.putExtra("select_fav_local_id", gVar2.field_localId);
                if (gVar2.tad) {
                    intent.putExtra("select_fav_fake_local_id", gVar2.dLb);
                }
                if (!(gVar2 == null || Ic(gVar2.field_type) == -1)) {
                    intent.putExtra("Retr_Msg_Type", Ic(gVar2.field_type));
                }
                if (bVar.mE(false).get(0) != null && bVar.mE(false).get(0).field_type == 3) {
                    h.cD(context, context.getString(R.string.cbu));
                    AppMethodBeat.o(107059);
                    return false;
                }
            } else {
                intent.putExtra("Retr_Msg_Type", 17);
                k kVar = new k();
                for (g gVar3 : bVar.mE(false)) {
                    if (!kVar.u(gVar3)) {
                        i3++;
                    }
                }
                intent.putExtra("select_fav_select_count", i3);
            }
            c.c(context, ".ui.transmit.SelectConversationUI", intent, 4105);
            AppMethodBeat.o(107059);
            return true;
        } else if (i2 == 4106) {
            Intent intent2 = new Intent();
            intent2.putExtra("Select_Conv_Type", 3);
            intent2.putExtra("scene_from", 1);
            intent2.putExtra("mutil_select_is_ret", true);
            if (gVar != null) {
                intent2.putExtra("select_fav_local_id", gVar.field_localId);
                if (gVar.tad) {
                    intent2.putExtra("select_fav_fake_local_id", gVar.dLb);
                }
                if (gVar.field_type == 19) {
                    intent2.putExtra("appbrand_params", c.F(gVar));
                }
            }
            if (!(gVar == null || Ic(gVar.field_type) == -1)) {
                intent2.putExtra("Retr_Msg_Type", Ic(gVar.field_type));
            }
            c.c(context, ".ui.transmit.SelectConversationUI", intent2, 4106);
            AppMethodBeat.o(107059);
            return true;
        } else {
            AppMethodBeat.o(107059);
            return false;
        }
    }

    public static void a(Activity activity, final List<g> list, final a aVar) {
        AppMethodBeat.i(107060);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(107060);
            return;
        }
        final q a2 = h.a((Context) activity, activity.getString(R.string.c99), false, (DialogInterface.OnCancelListener) null);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.p.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(107055);
                b.dD(list);
                if (aVar != null) {
                    aVar.cVU();
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.p.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107053);
                        a2.dismiss();
                        AppMethodBeat.o(107053);
                    }

                    public final String toString() {
                        AppMethodBeat.i(107054);
                        String str = super.toString() + "|batchDelFavItems";
                        AppMethodBeat.o(107054);
                        return str;
                    }
                });
                AppMethodBeat.o(107055);
            }
        });
        AppMethodBeat.o(107060);
    }

    public static void a(final Activity activity, List<g> list, String str, String str2, String str3) {
        AppMethodBeat.i(107061);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(107061);
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(107061);
        } else {
            k kVar = new k();
            LinkedList linkedList = new LinkedList();
            for (g gVar : list) {
                if (!kVar.u(gVar)) {
                    linkedList.add(gVar);
                }
            }
            if (linkedList.isEmpty()) {
                Log.i(str3, "after filter, nothing");
                h.cD(activity, activity.getString(R.string.cbu));
                AppMethodBeat.o(107061);
                return;
            }
            final q a2 = h.a((Context) activity, activity.getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            l.a(activity, str2, str, linkedList, new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.p.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(107056);
                    a2.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.r(activity, activity.getString(R.string.c8o));
                    AppMethodBeat.o(107056);
                }
            });
            AppMethodBeat.o(107061);
        }
    }

    private static int Ic(int i2) {
        if (i2 == 1) {
            return 4;
        }
        if (i2 == 2) {
            return 0;
        }
        if (i2 == 16) {
            return 11;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 14) {
            return 13;
        }
        if (i2 == 6) {
            return 9;
        }
        if (i2 == 8) {
            return 3;
        }
        return 2;
    }
}
