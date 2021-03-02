package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URI;
import java.net.URL;

public final class n implements a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private boolean enable;
    private f screen;

    static /* synthetic */ void a(n nVar, Context context2) {
        AppMethodBeat.i(231882);
        nVar.A(context2, false);
        AppMethodBeat.o(231882);
    }

    public n(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        String str2;
        AppMethodBeat.i(27210);
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27210);
            return false;
        } else if ("contact_info_go_to_sync".equals(str)) {
            if (q.s(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(268435456);
                Context context2 = this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(launchIntentForPackage);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                h.a(this.context, (int) R.string.bea, (int) R.string.zb, (int) R.string.tm, (int) R.string.sz, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.n.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27207);
                        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
                        if (ChannelUtil.channelId == 1) {
                            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
                            if (Util.isIntentAvailable(n.this.context, addFlags)) {
                                Context context = n.this.context;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(addFlags);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(27207);
                                return;
                            }
                            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
                        }
                        try {
                            URL url = new URL(str);
                            URL url2 = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                            g.a aVar = new g.a();
                            aVar.all("qqpim.apk");
                            aVar.alj(url2.toString());
                            aVar.kS(true);
                            aVar.Fl(1);
                            com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
                            AppMethodBeat.o(27207);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", e2.toString());
                            AppMethodBeat.o(27207);
                        }
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(27210);
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_remind_me_syncing");
            bg.aVF();
            c.azQ().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            if (checkBoxPreference.isChecked()) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            cf.I(6, str2);
            AppMethodBeat.o(27210);
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            A(this.context, true);
            AppMethodBeat.o(27210);
            return true;
        } else if (str.equals("contact_info_qqsync_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.n.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27206);
                    n.a(n.this, n.this.context);
                    AppMethodBeat.o(27206);
                }
            }, null);
            AppMethodBeat.o(27210);
            return true;
        } else {
            AppMethodBeat.o(27210);
            return false;
        }
    }

    private void A(Context context2, final boolean z) {
        AppMethodBeat.i(27211);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final com.tencent.mm.ui.base.q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.n.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(27209);
                n.sJ(z);
                if (!z) {
                    n.access$300();
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.profile.ui.n.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(27208);
                        a2.dismiss();
                        AppMethodBeat.o(27208);
                    }
                });
                AppMethodBeat.o(27209);
            }
        });
        AppMethodBeat.o(27211);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(27212);
        bg.aVF();
        c.azQ().add(this);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.ac);
        cCt();
        AppMethodBeat.o(27212);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27213);
        bg.aVF();
        c.azQ().remove(this);
        AppMethodBeat.o(27213);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27214);
        if (this.enable != z.aUy()) {
            cCt();
        }
        AppMethodBeat.o(27214);
    }

    private void cCt() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(27215);
        this.enable = z.aUy();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bec));
        helperHeaderPreference.updateStatus(this.enable ? 1 : 0);
        f fVar = this.screen;
        if (!this.enable) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_go_to_sync", z);
        f fVar2 = this.screen;
        if (!this.enable) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar2.m38do("contact_info_remind_me_syncing_tip", z2);
        this.screen.m38do("contact_info_qqsync_install", this.enable);
        f fVar3 = this.screen;
        if (this.enable) {
            z3 = false;
        }
        fVar3.m38do("contact_info_qqsync_uninstall", z3);
        AppMethodBeat.o(27215);
    }

    static /* synthetic */ void sJ(boolean z) {
        int i2;
        AppMethodBeat.i(231883);
        cf.I(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
        int aUl = z.aUl();
        if (z) {
            i2 = aUl & -129;
        } else {
            i2 = aUl | 128;
        }
        bg.aVF();
        c.azQ().set(34, Integer.valueOf(i2));
        bg.aVF();
        c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
        AppMethodBeat.o(231883);
    }

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(231884);
        bp.Kx("qqsync");
        bg.aVF();
        c.aST().bjW("qqsync");
        AppMethodBeat.o(231884);
    }
}
