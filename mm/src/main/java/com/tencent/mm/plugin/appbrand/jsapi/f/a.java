package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public final class a {
    private static int jjN = -1;
    private static int jjS = 0;
    private static boolean kDf = false;
    public static int[] lWg = {R.string.a1k, R.string.a1k, R.string.a1i, R.string.a1j, R.string.a1k};

    public static int l(String str, String str2, boolean z) {
        String str3;
        AppMethodBeat.i(226842);
        jjN = p.Un(str2).jjN;
        jjS = p.Un(str2).jjS;
        boolean z2 = p.Un(str2).kDf;
        kDf = z2;
        if (!z2 || jjN == -1 || jjS == 0) {
            Log.i(str, "invalid login,isWXOnline: %b , iconType : %d ,clientVersion: %d", Boolean.valueOf(kDf), Integer.valueOf(jjN), Integer.valueOf(jjS));
            AppMethodBeat.o(226842);
            return 2;
        } else if (jjN == 1 || jjN == 2) {
            JSONObject Zc = b.Zc(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_handoff_version_wrapper, ""));
            if (jjN == 2) {
                str3 = "mac_appbrand";
            } else {
                str3 = "windows_appbrand";
            }
            if (z) {
                str3 = str3 + "_game";
            }
            String str4 = str3 + "_version";
            if (Zc == null || !Zc.has(str3) || !Zc.has(str4)) {
                Log.i(str, "xclient data format wrong ,jsonObject:".concat(String.valueOf(Zc)));
                AppMethodBeat.o(226842);
                return 4;
            }
            int optInt = Zc.optInt(str3, 0);
            int optInt2 = Zc.optInt(str4, 0);
            if (1 != optInt || optInt2 == 0) {
                Log.i(str, "pc not supported ,iconType: %d ,isGame :%b", Integer.valueOf(jjN), Boolean.valueOf(z));
                AppMethodBeat.o(226842);
                return 4;
            } else if (jjS < optInt2) {
                Log.i(str, "version is old,clientVersion: %d ,isGame :%b", Integer.valueOf(jjS), Boolean.valueOf(z));
                AppMethodBeat.o(226842);
                return 3;
            } else {
                AppMethodBeat.o(226842);
                return 0;
            }
        } else {
            Log.i(str, "invalid login,iconType:" + jjN);
            AppMethodBeat.o(226842);
            return 2;
        }
    }

    public static void dQ(final Context context) {
        AppMethodBeat.i(226843);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.f.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(226840);
                Toast makeText = Toast.makeText(context, "", 3000);
                View inflate = View.inflate(context, R.layout.pd, null);
                ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_outlined_colorful_handoff_success);
                final TextView textView = (TextView) inflate.findViewById(R.id.ird);
                textView.setText(context.getString(R.string.a1l));
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.f.a.AnonymousClass1.AnonymousClass1 */

                    public final void onGlobalLayout() {
                        AppMethodBeat.i(226839);
                        if (textView.getLineCount() > 1) {
                            textView.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.bd));
                        }
                        textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AppMethodBeat.o(226839);
                    }
                });
                makeText.setGravity(17, 0, 0);
                makeText.setView(inflate);
                makeText.show();
                AppMethodBeat.o(226840);
            }
        });
        AppMethodBeat.o(226843);
    }

    public static void ad(final Context context, final String str) {
        AppMethodBeat.i(226844);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.f.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(226841);
                Toast makeText = Toast.makeText(context, "", 3000);
                View inflate = View.inflate(context, R.layout.c33, null);
                ((TextView) inflate.findViewById(R.id.ird)).setText(str);
                makeText.setGravity(17, 0, 0);
                makeText.setView(inflate);
                makeText.show();
                AppMethodBeat.o(226841);
            }
        });
        AppMethodBeat.o(226844);
    }
}
