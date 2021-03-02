package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public final class z {
    private static boolean OHu = false;
    static ProgressDialog gtM = null;
    static SecurityImage kdp = null;

    static /* synthetic */ boolean bk(Activity activity) {
        AppMethodBeat.i(232644);
        boolean bj = bj(activity);
        AppMethodBeat.o(232644);
        return bj;
    }

    public static d a(final Activity activity, String str, final String str2, final Intent intent) {
        AppMethodBeat.i(33449);
        ma maVar = new ma();
        maVar.dRA.status = 0;
        maVar.dRA.bDZ = 1;
        EventCenter.instance.publish(maVar);
        d a2 = h.a(activity, str, activity.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.z.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(33438);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 23, 1, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4023, String.format("%b|%s", Boolean.valueOf(Util.isNullOrNil(str2)), str2));
                bg.hold();
                if (Util.isNullOrNil(str2)) {
                    Activity activity = activity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/MMErrorProcessor$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/MMErrorProcessor$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    b.az(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    c.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                t.ds(activity);
                AppMethodBeat.o(33438);
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.z.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(232637);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 24, 1, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4024, String.format("%b|%s", Boolean.valueOf(Util.isNullOrNil(str2)), str2));
                Activity activity = activity;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/MMErrorProcessor$4", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/MMErrorProcessor$4", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                b.az(activity, intent);
                t.ds(activity);
                AppMethodBeat.o(232637);
            }
        });
        AppMethodBeat.o(33449);
        return a2;
    }

    public static void bi(final Activity activity) {
        AppMethodBeat.i(232643);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.z.AnonymousClass3 */

            public final void run() {
                boolean z = true;
                boolean z2 = false;
                AppMethodBeat.i(232639);
                if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi")) != 0) {
                    AppMethodBeat.o(232639);
                    return;
                }
                bg.aVF();
                boolean z3 = (((Integer) com.tencent.mm.model.c.azQ().get(7, 0)).intValue() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0;
                if (!NetStatusUtil.isWifi(activity) || !z3) {
                    z = false;
                }
                if ((ChannelUtil.updateMode & 1) != 0) {
                    Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                } else {
                    Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    z2 = z;
                }
                if (z2 && g.gnw()) {
                    activity.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.ui.z.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232638);
                            if (z.bk(activity)) {
                                Log.d("MicroMsg.MMErrorProcessor", "we got an unfinished silence download");
                            }
                            AppMethodBeat.o(232638);
                        }
                    });
                }
                AppMethodBeat.o(232639);
            }
        }, "Thread-checkUnfinishSilenceDownload");
        AppMethodBeat.o(232643);
    }

    public static boolean jP(final Context context) {
        AppMethodBeat.i(33451);
        final String gnt = g.gnt();
        final int gnu = g.gnu();
        Log.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", gnt, Integer.valueOf(gnu));
        if (Util.isNullOrNil(gnt) || g.gnv()) {
            AppMethodBeat.o(33451);
            return false;
        }
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.z.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(232641);
                if (gnu == 4 && com.tencent.mm.pluginsdk.model.app.b.gmM() == null) {
                    Log.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                    AppMethodBeat.o(232641);
                    return;
                }
                if (!(com.tencent.mm.plugin.p.d.elq() == null || com.tencent.mm.plugin.p.d.elq().aFr(gnt) == null)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.z.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232640);
                            if (com.tencent.mm.plugin.p.d.elq() != null) {
                                com.tencent.mm.plugin.p.d.elq().gC(context);
                            }
                            AppMethodBeat.o(232640);
                        }
                    });
                }
                AppMethodBeat.o(232641);
            }
        });
        AppMethodBeat.o(33451);
        return true;
    }

    public static boolean c(final Activity activity, int i2, int i3) {
        AppMethodBeat.i(33452);
        Log.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.KyO), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.updateMode));
        if (i2 != 4) {
            AppMethodBeat.o(33452);
            return false;
        }
        switch (i3) {
            case ShareConstants.ERROR_LOAD_PATCH_VERSION_LIB_DIRECTORY_NOT_EXIST /*{ENCODED_INT: -17}*/:
                long j2 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                Log.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j2), Long.valueOf(Util.secondsToNow(j2)));
                if (j2 != -1 && Util.secondsToNow(j2) < 86400) {
                    AppMethodBeat.o(33452);
                    return true;
                } else if ((ChannelUtil.updateMode & 2) != 0) {
                    Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    AppMethodBeat.o(33452);
                    return true;
                } else {
                    Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    String value = com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi");
                    bg.aVF();
                    boolean z = ((((Integer) com.tencent.mm.model.c.azQ().get(7, 0)).intValue() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0) && (Util.isNullOrNil(value) || Util.safeParseInt(value) == 0);
                    if ((ChannelUtil.updateMode & 1) != 0) {
                        Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                        z = false;
                    } else {
                        Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    }
                    if (Util.safeParseInt(value) != 0) {
                        Log.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                    }
                    Log.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                    if (z) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 40, 1, true);
                        boolean bj = bj(activity);
                        AppMethodBeat.o(33452);
                        return bj;
                    } else if (com.tencent.mm.plugin.p.d.elq() != null) {
                        com.tencent.mm.plugin.p.a d2 = com.tencent.mm.plugin.p.d.elq().d(activity, new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.z.AnonymousClass6 */
                            final /* synthetic */ Intent kjP = null;

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(232642);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 39, 1, true);
                                if (this.kjP != null) {
                                    activity.finish();
                                    Activity activity = activity;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.kjP);
                                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/MMErrorProcessor$8", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    activity.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/MMErrorProcessor$8", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    b.az(activity, this.kjP);
                                }
                                AppMethodBeat.o(232642);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 38, 1, true);
                        d2.update(2);
                        AppMethodBeat.o(33452);
                        return true;
                    } else {
                        AppMethodBeat.o(33452);
                        return false;
                    }
                }
            case -16:
                if (com.tencent.mm.plugin.p.d.elq() != null) {
                    com.tencent.mm.plugin.p.a d3 = com.tencent.mm.plugin.p.d.elq().d(activity, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.z.AnonymousClass5 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(33442);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 37, 1, true);
                            activity.finish();
                            MMAppMgr.n(activity, true);
                            AppMethodBeat.o(33442);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 36, 1, true);
                    d3.update(1);
                    AppMethodBeat.o(33452);
                    return true;
                }
                AppMethodBeat.o(33452);
                return false;
            default:
                AppMethodBeat.o(33452);
                return false;
        }
    }

    private static boolean bj(Activity activity) {
        AppMethodBeat.i(33453);
        com.tencent.mm.pluginsdk.model.app.b gmM = com.tencent.mm.pluginsdk.model.app.b.gmM();
        if (gmM != null) {
            gmM.gmP();
            Log.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            AppMethodBeat.o(33453);
            return true;
        } else if (com.tencent.mm.plugin.p.d.elq() != null) {
            com.tencent.mm.plugin.p.d.elq().gB(activity).update(2);
            AppMethodBeat.o(33453);
            return true;
        } else {
            AppMethodBeat.o(33453);
            return false;
        }
    }

    public static class a {
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static boolean a(final Context context, int i2, int i3, String str, int i4) {
            AnonymousClass1 r0;
            AppMethodBeat.i(33447);
            switch (i2) {
                case 1:
                    if ((i4 & 2) != 0 && bg.azz().aYT()) {
                        bg.azz().getNetworkServerIp();
                        new StringBuilder().append(i3);
                    } else if (((i4 & 1) == 0 || !ag.dm(context) || !m.iC(context)) && ((i4 & 4) == 0 || !NetStatusUtil.isWap(context) || !MMAppMgr.jN(context))) {
                        Toast.makeText(context, context.getString(R.string.deo, 1, Integer.valueOf(i3)), 1).show();
                    }
                    AppMethodBeat.o(33447);
                    return true;
                case 2:
                    Toast.makeText(context, context.getString(R.string.dep, 2, Integer.valueOf(i3)), 1).show();
                    AppMethodBeat.o(33447);
                    return true;
                case 3:
                    AppMethodBeat.o(33447);
                    return true;
                case 4:
                    if (com.tencent.mm.plugin.account.ui.a.dJ(i2, i3)) {
                        AppMethodBeat.o(33447);
                        return true;
                    }
                    final com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Log.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i3), Integer.valueOf(Dk.dDG), Dk.url, Dk.desc);
                        if (!Util.isNullOrNil(Dk.url)) {
                            r0 = new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.z.a.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(33446);
                                    Intent intent = new Intent();
                                    StringBuilder sb = new StringBuilder(Dk.url);
                                    sb.append("&wechat_real_lang=" + LocaleUtil.getApplicationLanguage());
                                    intent.putExtra("rawUrl", sb.toString());
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("needRedirect", false);
                                    intent.putExtra("neverGetA8Key", true);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                    c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.o(33446);
                                }
                            };
                        } else {
                            r0 = null;
                        }
                        if (Dk.a(context, r0, null)) {
                            AppMethodBeat.o(33447);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(33447);
            return false;
        }
    }
}
