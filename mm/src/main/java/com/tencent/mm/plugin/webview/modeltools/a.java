package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.browser.b;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a {
    public WeakReference<j> Jaq = null;

    public final void c(Activity activity, String str) {
        AppMethodBeat.i(79107);
        if (activity == null || activity.isFinishing() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(79107);
            return;
        }
        if (!str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            str = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str));
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            if (!Util.isOverseasUser(activity) && !ChannelUtil.isGPVersion()) {
                activity.startActivityForResult(b.a(activity, intent, str), 6);
                AppMethodBeat.o(79107);
            } else if (d.oD(29)) {
                PendingIntent.getActivity(activity, 0, intent, 134217728).send(activity, 1, null, new PendingIntent.OnFinished() {
                    /* class com.tencent.mm.plugin.webview.modeltools.a.AnonymousClass2 */

                    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                        AppMethodBeat.i(211025);
                        Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", Integer.valueOf(i2), str);
                        AppMethodBeat.o(211025);
                    }
                }, null);
                AppMethodBeat.o(79107);
            } else {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(79107);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e2.getMessage());
            AppMethodBeat.o(79107);
        }
    }

    public final boolean d(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(79109);
        if (2 == i2) {
            if (-1 == i3 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Bundle bundleExtra = intent.getBundleExtra("transferback");
                boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                Log.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", stringExtra);
                u.gmF();
                r rVar = (r) u.A(0, null);
                if (rVar.bdn(stringExtra)) {
                    if (rVar.in(activity)) {
                        rVar.cg(activity, bundleExtra.getString("targeturl"));
                    } else {
                        Intent intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                        intent2.setPackage(stringExtra);
                        intent2.addFlags(524288);
                        if (d.oD(29)) {
                            try {
                                PendingIntent.getActivity(activity, 0, intent2, 134217728).send(activity, 1, null, new PendingIntent.OnFinished() {
                                    /* class com.tencent.mm.plugin.webview.modeltools.a.AnonymousClass3 */

                                    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                                        AppMethodBeat.i(211026);
                                        Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", Integer.valueOf(i2), str);
                                        AppMethodBeat.o(211026);
                                    }
                                }, null);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e2.getMessage());
                            }
                        } else {
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    }
                    if (booleanExtra) {
                        h.INSTANCE.a(10998, 4, 2);
                    } else {
                        h.INSTANCE.a(10998, 4, 1);
                    }
                } else {
                    Intent intent3 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent3.setPackage(stringExtra);
                    intent3.addFlags(524288);
                    try {
                        if (d.oD(29)) {
                            PendingIntent.getActivity(activity, 0, intent3, 134217728).send(activity, 1, null, new PendingIntent.OnFinished() {
                                /* class com.tencent.mm.plugin.webview.modeltools.a.AnonymousClass4 */

                                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                                    AppMethodBeat.i(211027);
                                    Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", Integer.valueOf(i2), str);
                                    AppMethodBeat.o(211027);
                                }
                            }, null);
                        } else {
                            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl2.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl2.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    } catch (Exception e3) {
                        Log.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", e3.getMessage());
                    }
                    h.INSTANCE.a(10998, 5);
                    if (booleanExtra) {
                        h.INSTANCE.a(10998, 5, 2);
                    } else {
                        h.INSTANCE.a(10998, 5, 1);
                    }
                }
            }
            AppMethodBeat.o(79109);
            return true;
        } else if (i2 == 6) {
            if (i3 == -1) {
                int intExtra = intent != null ? intent.getIntExtra("browser_setting_result", 0) : 0;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Boolean.valueOf(intent != null);
                objArr[2] = Integer.valueOf(intExtra);
                Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser onActivityResult resultCode: %d, data != null: %b, settingResult: %d", objArr);
                if (!(this.Jaq == null || this.Jaq.get() == null || intent == null || intExtra != 1)) {
                    j jVar = this.Jaq.get();
                    j.a aVar = new j.a();
                    if (aVar.JgL == null) {
                        aVar.JgL = new Bundle();
                    }
                    if (intent.getExtras() != null) {
                        aVar.JgL.putAll(intent.getExtras());
                    }
                    jVar.Jgo.put(Integer.valueOf(aVar.nfG), aVar);
                    jVar.cpD();
                }
            } else if (i3 == 0) {
                if (!(!(intent != null && intent.getBooleanExtra("show_webview_menu", false)) || this.Jaq == null || this.Jaq.get() == null)) {
                    Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser cancel and show webview menu");
                    this.Jaq.get().cpD();
                }
            }
            AppMethodBeat.o(79109);
            return true;
        } else {
            AppMethodBeat.o(79109);
            return false;
        }
    }
}
