package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.s;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class Updater extends LinearLayout implements i, a {
    private int NEo;
    private i NFA;
    private q NFv = null;
    private boolean NFw = false;
    private boolean NFx = false;
    private boolean NFy = false;
    private i NFz;
    private boolean dEF;

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        AppMethodBeat.i(32749);
        bg.azz().a(11, this);
        h.INSTANCE.idkeyStat(405, 42, 1, true);
        AppMethodBeat.o(32749);
    }

    public final void onStop() {
        AppMethodBeat.i(32750);
        h.INSTANCE.idkeyStat(405, 43, 1, true);
        cancel();
        AppMethodBeat.o(32750);
    }

    public static Updater e(Context context, final DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(32751);
        if (context == null) {
            AppMethodBeat.o(32751);
            return null;
        } else if (!(context instanceof Activity) || (!((Activity) context).isFinishing() && ((Activity) context).getWindow() != null)) {
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
            bg.getNotification().cancel(34);
            Log.i("MicroMsg.Updater", "showWithProgress");
            Updater updater = (Updater) View.inflate(context, R.layout.c4v, null);
            updater.onStart();
            q b2 = q.b(context, context.getString(R.string.hso), true, 0, null);
            b2.setCancelable(true);
            b2.setOnCancelListener(new DialogInterface.OnCancelListener(updater) {
                /* class com.tencent.mm.sandbox.updater.Updater.AnonymousClass1 */
                final /* synthetic */ Updater NFB;

                {
                    this.NFB = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(32744);
                    bg.getNotification().cancel(99);
                    h.INSTANCE.idkeyStat(405, 47, 1, true);
                    Updater.ajz(2);
                    this.NFB.onStop();
                    if (!this.NFB.NFw && onCancelListener != null) {
                        onCancelListener.onCancel(dialogInterface);
                    }
                    AppMethodBeat.o(32744);
                }
            });
            try {
                updater.NFv = b2;
                updater.NFv.show();
                updater.dEF = true;
                h.INSTANCE.idkeyStat(405, 46, 1, true);
                AppMethodBeat.o(32751);
                return updater;
            } catch (Exception e2) {
                Log.e("MicroMsg.Updater", "exception in showWithProgress, ", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.Updater", e2, "", new Object[0]);
                AppMethodBeat.o(32751);
                return null;
            }
        } else {
            Log.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            AppMethodBeat.o(32751);
            return null;
        }
    }

    public static Updater f(Context context, final DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(32752);
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
        bg.getNotification().cancel(34);
        Log.i("MicroMsg.Updater", "show update dialog");
        Updater updater = (Updater) View.inflate(context, R.layout.c4v, null);
        updater.onStart();
        q b2 = q.b(context, "", true, 0, null);
        b2.setCancelable(true);
        b2.setOnCancelListener(new DialogInterface.OnCancelListener(updater) {
            /* class com.tencent.mm.sandbox.updater.Updater.AnonymousClass2 */
            final /* synthetic */ Updater NFB;

            {
                this.NFB = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(32745);
                bg.getNotification().cancel(99);
                h.INSTANCE.idkeyStat(405, 49, 1, true);
                Updater.ajz(2);
                this.NFB.onStop();
                if (!this.NFB.NFw && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                AppMethodBeat.o(32745);
            }
        });
        h.INSTANCE.idkeyStat(405, 48, 1, true);
        updater.NFv = b2;
        updater.dEF = false;
        AppMethodBeat.o(32752);
        return updater;
    }

    public static Updater jt(Context context) {
        AppMethodBeat.i(32753);
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
        bg.getNotification().cancel(34);
        h.INSTANCE.idkeyStat(405, 50, 1, true);
        Log.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.NFx = true;
        AppMethodBeat.o(32753);
        return updater;
    }

    public static void gC(Context context) {
        AppMethodBeat.i(32754);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(context, AppInstallerUI.class));
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(32754);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(32755);
        if (i2 == 0 && i3 == 0) {
            h.INSTANCE.idkeyStat(405, 51, 1, true);
            Log.i("MicroMsg.Updater", "isShow " + this.dEF);
            if (!this.dEF && this.NFv != null) {
                this.NFv.show();
            }
            this.NFw = true;
            if (this.NFv != null) {
                this.NFv.cancel();
            }
            final com.tencent.mm.sandbox.a.a aVar = (com.tencent.mm.sandbox.a.a) qVar;
            bg.azz().a(new bu(new bu.a() {
                /* class com.tencent.mm.sandbox.updater.Updater.AnonymousClass3 */

                @Override // com.tencent.mm.model.bu.a
                public final void a(final g gVar) {
                    long j2;
                    AppMethodBeat.i(32747);
                    if (gVar == null) {
                        h.INSTANCE.idkeyStat(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    bg.getNotification().cancel(34);
                    Log.i("MicroMsg.Updater", "go to update, isSilenceDownload:%s", Boolean.valueOf(Updater.this.NFx));
                    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted")) {
                        Log.e("MicroMsg.Updater", "no sdcard.");
                        h.INSTANCE.idkeyStat(405, 53, 1, true);
                        Updater.this.NFx = false;
                    }
                    int gvS = aVar.gvS();
                    com.tencent.mm.d.i fR = com.tencent.mm.d.i.fR(aVar.gvU());
                    String iw = com.tencent.mm.pluginsdk.i.g.iw(Updater.this.getContext());
                    i.a aVar = null;
                    if (fR != null) {
                        aVar = fR.fQ(iw);
                    }
                    if (aVar == null) {
                        j2 = (long) gvS;
                    } else {
                        j2 = (long) (aVar.size + gvS);
                    }
                    if (!e.yV(j2)) {
                        Log.e("MicroMsg.Updater", "no enough space.");
                        h.INSTANCE.idkeyStat(405, 54, 1, true);
                        Updater.this.NFx = false;
                    }
                    if ((ChannelUtil.updateMode & 1) != 0) {
                        Log.i("MicroMsg.Updater", "channel pack, not silence download.");
                        h.INSTANCE.idkeyStat(405, 55, 1, true);
                        Updater.this.NFx = false;
                    }
                    if (Updater.this.NEo == 2 && !Updater.this.NFy) {
                        String gnt = j.gnt();
                        if (c.aFr(aVar.gvT()) != null && !Util.isNullOrNil(gnt) && gnt.equals(aVar.gvT())) {
                            Log.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", gnt);
                            h.INSTANCE.idkeyStat(405, 56, 1, true);
                            AppMethodBeat.o(32747);
                            return;
                        }
                    }
                    bwo eln = aVar.eln();
                    if (eln == null || eln.Mcs == 0 || Util.isNullOrNil(eln.Mct)) {
                        if (Updater.this.NFx) {
                            Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            h.INSTANCE.idkeyStat(405, 58, 1, true);
                            bg.azz().a(725, Updater.this.NFz = new com.tencent.mm.ak.i() {
                                /* class com.tencent.mm.sandbox.updater.Updater.AnonymousClass3.AnonymousClass1 */

                                /* JADX WARNING: Removed duplicated region for block: B:14:0x0083  */
                                @Override // com.tencent.mm.ak.i
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
                                    /*
                                    // Method dump skipped, instructions count: 253
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.updater.Updater.AnonymousClass3.AnonymousClass1.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
                                }
                            });
                            bg.azz().a(new r(), 0);
                        } else {
                            Log.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.a(Updater.this, intent, gVar, aVar);
                            Log.i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(Updater.this.NEo));
                            if (Updater.this.NEo == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                h.INSTANCE.idkeyStat(405, 60, 1, true);
                            } else {
                                h.INSTANCE.idkeyStat(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            Context context = Updater.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        if (Updater.this.NEo != 3) {
                            com.tencent.mm.y.c.axV().A(262145, true);
                        }
                        b.gmN();
                        AppMethodBeat.o(32747);
                        return;
                    }
                    String str = eln.Mct;
                    Context context2 = Updater.this.getContext();
                    String string = context2.getString(R.string.yb);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.setFlags(872415232);
                    PendingIntent activity = PendingIntent.getActivity(Updater.this.getContext(), 0, intent2, 268435456);
                    s.c g2 = com.tencent.mm.bq.a.cd(Updater.this.getContext(), "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g("");
                    g2.Hv = activity;
                    g2.as(com.tencent.mm.bq.a.ezb());
                    Notification build = g2.build();
                    build.flags |= 16;
                    ((NotificationManager) context2.getSystemService("notification")).notify(99, build);
                    j.gwq();
                    h.INSTANCE.idkeyStat(405, 57, 1, true);
                    AppMethodBeat.o(32747);
                }
            }), 0);
            onStop();
            AppMethodBeat.o(32755);
            return;
        }
        h.INSTANCE.idkeyStat(405, 62, 1, true);
        if (this.NFv != null) {
            q qVar2 = this.NFv;
            if (qVar2.olQ != null) {
                qVar2.olQ.setVisibility(8);
            }
            final TextView textView = (TextView) this.NFv.findViewById(R.id.fgd);
            if (i2 == 4 && i3 == -18) {
                EventCenter.instance.publish(new bt());
                t azz = bg.azz();
                AnonymousClass4 r3 = new com.tencent.mm.ak.i() {
                    /* class com.tencent.mm.sandbox.updater.Updater.AnonymousClass4 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(32748);
                        bg.azz().b(3899, Updater.this.NFA);
                        Updater.this.NFz = null;
                        if (i2 == 0 && i3 == 0) {
                            cxz cxz = ((cxw) ((d) qVar.getReqResp()).iLL.iLR).MCM;
                            f fVar = new f(cxz);
                            if (cxz == null || cxz.MCR != 3) {
                                if (Updater.this.NFv.findViewById(R.id.fgc) != null) {
                                    Updater.this.NFv.findViewById(R.id.fgc).setVisibility(8);
                                }
                                if (textView != null) {
                                    h.INSTANCE.idkeyStat(405, 63, 1, true);
                                    textView.setText(R.string.hst);
                                }
                                AppMethodBeat.o(32748);
                                return;
                            }
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            if (f.aBK(fVar.clientVersion)) {
                                String str2 = Util.isNullOrNil(fVar.ynz) ? HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : fVar.ynz;
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setClassName(Updater.this.getContext().getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                                intent2.putExtra("rawUrl", str2);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("vertical_scroll", true);
                                intent2.setFlags(872415232);
                                Context context = Updater.this.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else {
                                Updater.this.a(intent, fVar);
                                Context context2 = Updater.this.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            if (Updater.this.NFv != null) {
                                Updater.this.NFv.cancel();
                            }
                            Updater.this.onStop();
                            AppMethodBeat.o(32748);
                            return;
                        }
                        if (Updater.this.NFv.findViewById(R.id.fgc) != null) {
                            Updater.this.NFv.findViewById(R.id.fgc).setVisibility(8);
                        }
                        if (textView != null) {
                            h.INSTANCE.idkeyStat(405, 63, 1, true);
                            textView.setText(R.string.hst);
                        }
                        AppMethodBeat.o(32748);
                    }
                };
                this.NFA = r3;
                azz.a(3899, r3);
            } else if (textView != null) {
                h.INSTANCE.idkeyStat(405, 64, 1, true);
                textView.setText(R.string.hsj);
                l.p(textView, 1);
            }
        }
        j.gwu();
        cancel();
        AppMethodBeat.o(32755);
    }

    public final void a(Intent intent, f fVar) {
        boolean z;
        String str;
        String str2;
        AppMethodBeat.i(32756);
        intent.putExtra("intent_short_ips", getShortIps());
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
        intent.putExtra("intent_update_type", 3);
        if (fVar.ynu == null || fVar.ynu.isEmpty() || !fVar.ynu.containsKey(4)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            HashMap<Integer, LinkedList<crl>> hashMap = fVar.ynu;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList<crl> linkedList = hashMap.get(4);
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        crl crl = linkedList.get(i2);
                        if (crl.lang.equalsIgnoreCase(BuildConfig.KINDA_DEFAULT)) {
                            str2 = new String(Base64.decode(crl.content, 0));
                        } else if (crl.lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage())) {
                            str = new String(Base64.decode(crl.content, 0));
                            break;
                        } else {
                            str2 = str;
                        }
                        i2++;
                        str = str2;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra("intent_extra_desc", str);
        intent.putExtra("intent_extra_md5", fVar.pkL);
        intent.putExtra("intent_extra_size", fVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{fVar.pkK});
        intent.putExtra("intent_extra_patchInfo", fVar.gwj());
        intent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
        intent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
        AppMethodBeat.o(32756);
    }

    private void cancel() {
        AppMethodBeat.i(32757);
        bg.azz().b(11, this);
        AppMethodBeat.o(32757);
    }

    private String[] getShortIps() {
        AppMethodBeat.i(32758);
        if (ac.jOk == null || ac.jOk.length() <= 0) {
            String string = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List<o> bgd = o.bgd(string);
            String[] strArr = new String[bgd.size()];
            for (int i2 = 0; i2 < bgd.size(); i2++) {
                strArr[i2] = bgd.get(i2).yFq;
            }
            AppMethodBeat.o(32758);
            return strArr;
        }
        String[] strArr2 = {ac.jOk};
        AppMethodBeat.o(32758);
        return strArr2;
    }

    @Override // com.tencent.mm.plugin.p.a
    public final void update(int i2) {
        AppMethodBeat.i(32759);
        bB(i2, false);
        AppMethodBeat.o(32759);
    }

    public final void bB(int i2, boolean z) {
        AppMethodBeat.i(32760);
        Log.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(i2)));
        this.NEo = i2;
        this.NFy = z;
        h.INSTANCE.idkeyStat(405, 44, 1, true);
        bg.azz().a(new com.tencent.mm.sandbox.a.a(i2), 0);
        AppMethodBeat.o(32760);
    }

    public static void h(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(32761);
        Intent intent = new Intent(MMApplicationContext.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i2);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
        intent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        h.INSTANCE.idkeyStat(405, 45, 1, true);
        com.tencent.mm.br.c.m(intent, "sandbox");
        AppMethodBeat.o(32761);
    }

    public static void ajz(int i2) {
        AppMethodBeat.i(32762);
        if (!bg.aAc()) {
            AppMethodBeat.o(32762);
            return;
        }
        Log.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(i2)));
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new n(i2));
        AppMethodBeat.o(32762);
    }

    static /* synthetic */ void a(Updater updater, Intent intent, g gVar, com.tencent.mm.sandbox.a.a aVar) {
        AppMethodBeat.i(32763);
        intent.putExtra("intent_short_ips", updater.getShortIps());
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
        intent.putExtra("intent_extra_session", gVar.aZh().qe(1));
        intent.putExtra("intent_extra_cookie", gVar.aZh().aZa());
        intent.putExtra("intent_extra_ecdhkey", gVar.aZh().aZc());
        intent.putExtra("intent_extra_uin", gVar.aZh().getUin());
        intent.putExtra("intent_update_type", updater.NEo);
        intent.putExtra("intent_extra_desc", ((bwo) aVar.rr.iLL.iLR).Mco);
        intent.putExtra("intent_extra_md5", aVar.gvT());
        intent.putExtra("intent_extra_size", aVar.gvS());
        intent.putExtra("intent_extra_download_url", aVar.elm());
        intent.putExtra("intent_extra_patchInfo", aVar.gvU());
        intent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
        intent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
        String nullAsNil = Util.nullAsNil(z.b(((bwo) aVar.rr.iLL.iLR).Mcv));
        Log.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", nullAsNil, Util.getStack());
        intent.putExtra("intent_extra_extinfo", nullAsNil);
        AppMethodBeat.o(32763);
    }
}
