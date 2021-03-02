package com.tencent.mm.plugin.downloader_app.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;

public final class a implements com.tencent.mm.pluginsdk.b.a {
    private as contact;
    Context context;
    private boolean enable;
    private CheckBoxPreference qNr;
    private CheckBoxPreference qNs;
    private f screen;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(9093);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.x);
        this.qNr = (CheckBoxPreference) fVar.bmg("contact_info_top_downloader");
        this.qNs = (CheckBoxPreference) fVar.bmg("contact_info_not_disturb");
        cCt();
        AppMethodBeat.o(9093);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(9094);
        if ("contact_info_go_to_downloader".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.contact.field_username);
            intent.putExtra("finish_direct", true);
            c.f(this.context, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_downloader_manager".equals(str)) {
            ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.context, (Intent) null, (a.c) null);
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_common_problem".equals(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("KPublisherId", "custom_menu");
            intent2.putExtra("pre_username", this.contact.field_username);
            intent2.putExtra("prePublishId", "custom_menu");
            intent2.putExtra("preUsername", this.contact.field_username);
            intent2.putExtra("preChatName", this.contact.field_username);
            intent2.putExtra("preChatTYPE", ac.aJ(this.contact.field_username, this.contact.field_username));
            intent2.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent2.putExtra("geta8key_username", this.contact.field_username);
            intent2.putExtra("from_scence", 1);
            c.b(this.context, "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_top_downloader".equals(str)) {
            if (this.qNr.isChecked()) {
                ab.E(this.contact.field_username, true);
            } else {
                ab.F(this.contact.field_username, true);
            }
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.qNs.isChecked()) {
                ab.z(this.contact);
            } else {
                ab.A(this.contact);
            }
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_clear_data".equals(str)) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(9087);
                    bp.Kx("downloaderapp");
                    AppMethodBeat.o(9087);
                }
            }, null);
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_downloader_install".equals(str)) {
            A(this.context, true);
            AppMethodBeat.o(9094);
            return true;
        } else if ("contact_info_downloader_uninstall".equals(str)) {
            if (((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBP()) {
                h.c(this.context, this.context.getString(R.string.bp4), this.context.getString(R.string.bp5), this.context.getString(R.string.bp3), this.context.getString(R.string.bop), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(9088);
                        g.af(com.tencent.mm.plugin.downloader_app.api.c.class);
                        a.this.A(a.this.context, false);
                        AppMethodBeat.o(9088);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(9089);
                        ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(a.this.context, (Intent) null, (a.c) null);
                        AppMethodBeat.o(9089);
                    }
                });
            } else {
                h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(9090);
                        g.af(com.tencent.mm.plugin.downloader_app.api.c.class);
                        a.this.A(a.this.context, false);
                        AppMethodBeat.o(9090);
                    }
                }, null);
            }
            AppMethodBeat.o(9094);
            return true;
        } else {
            AppMethodBeat.o(9094);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public final void cCt() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(9095);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.boj));
        this.enable = z.aUE();
        helperHeaderPreference.updateStatus(this.enable ? 1 : 0);
        this.screen.m38do("contact_info_downloader_install", this.enable);
        f fVar = this.screen;
        if (!this.enable) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_downloader_uninstall", z);
        f fVar2 = this.screen;
        if (!this.enable) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar2.m38do("contact_info_go_to_downloader", z2);
        f fVar3 = this.screen;
        if (!this.enable) {
            z3 = true;
        } else {
            z3 = false;
        }
        fVar3.m38do("contact_info_downloader_manager", z3);
        this.screen.m38do("contact_info_common_problem", true);
        f fVar4 = this.screen;
        if (!this.enable) {
            z4 = true;
        } else {
            z4 = false;
        }
        fVar4.m38do("contact_info_top_downloader", z4);
        f fVar5 = this.screen;
        if (!this.enable) {
            z5 = true;
        } else {
            z5 = false;
        }
        fVar5.m38do("contact_info_not_disturb", z5);
        f fVar6 = this.screen;
        if (!this.enable) {
            z6 = true;
        } else {
            z6 = false;
        }
        fVar6.m38do("contact_info_clear_data", z6);
        if (this.enable) {
            if (((l) g.af(l.class)).aST().bkg(this.contact.field_username)) {
                this.qNr.setChecked(true);
            } else {
                this.qNr.setChecked(false);
            }
            if (this.contact.Zx()) {
                this.qNs.setChecked(true);
                AppMethodBeat.o(9095);
                return;
            }
            this.qNs.setChecked(false);
        }
        AppMethodBeat.o(9095);
    }

    /* access modifiers changed from: package-private */
    public final void A(final Context context2, final boolean z) {
        AppMethodBeat.i(9096);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass5 */

            public final void run() {
                int i2;
                AppMethodBeat.i(9092);
                boolean z = z;
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -134217729;
                } else {
                    i2 = aUl | 134217728;
                }
                g.aAh().azQ().set(34, Integer.valueOf(i2));
                dbw dbw = new dbw();
                dbw.KEc = 134217728;
                dbw.MGK = z ? 0 : 1;
                ((l) g.af(l.class)).aSM().d(new k.a(39, dbw));
                if (!z) {
                    bp.Kx("downloaderapp");
                    ((l) g.af(l.class)).aST().bjW("downloaderapp");
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader_app.d.a.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(9091);
                        a.this.cCt();
                        a2.dismiss();
                        if (z) {
                            ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBQ();
                            Bundle bundleExtra = ((Activity) context2).getIntent().getBundleExtra("download_params");
                            if (bundleExtra != null) {
                                ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(context2, new Intent().putExtras(bundleExtra), (a.c) null);
                            }
                        }
                        AppMethodBeat.o(9091);
                    }
                }, 1000);
                AppMethodBeat.o(9092);
            }
        });
        AppMethodBeat.o(9096);
    }
}
