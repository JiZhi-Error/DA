package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

public class GetQRCodeInfoUI extends MMBaseActivity implements i {
    private f CYG;
    private ProgressDialog gtM = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73835);
        super.onCreate(bundle);
        setContentView(R.layout.a3o);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            AppMethodBeat.o(73835);
            return;
        }
        String nullAsNil = Util.nullAsNil(data.getHost());
        String nullAsNil2 = Util.nullAsNil(data.getScheme());
        if ((!"http".equals(nullAsNil2) || !WeChatHosts.domainString(R.string.e2m).equals(nullAsNil)) && (!"weixin".equals(nullAsNil2) || !"qr".equals(nullAsNil))) {
            finish();
            AppMethodBeat.o(73835);
            return;
        }
        g.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.AnonymousClass1 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(73831);
                if (gVar == null) {
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(73831);
                } else if (!g.aAc() || a.azj()) {
                    c.jRt.o(new Intent(), GetQRCodeInfoUI.this);
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(73831);
                } else {
                    GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
                    AppMethodBeat.o(73831);
                }
            }
        }), 0);
        AppMethodBeat.o(73835);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(73836);
        super.onResume();
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.ft), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(73832);
                GetQRCodeInfoUI.this.finish();
                AppMethodBeat.o(73832);
            }
        });
        AppMethodBeat.o(73836);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(73837);
        super.onDestroy();
        if (this.CYG != null) {
            g.azz().a(this.CYG);
        }
        g.azz().b(106, this);
        AppMethodBeat.o(73837);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(73838);
        Log.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 4 && i3 == -2004) {
            h.a(this, (int) R.string.fsc, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73833);
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(73833);
                }
            });
            AppMethodBeat.o(73838);
        } else if (i2 == 0 && i3 == 0) {
            drt eiq = ((f) qVar).eiq();
            String a2 = z.a(eiq.Lqk);
            p.aYn().h(a2, z.a(eiq.KHp));
            ((k) g.af(k.class)).a(new Intent(), eiq, 30);
            if (Util.nullAsNil(a2).length() > 0) {
                if ((eiq.MmK & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, a2 + ",30");
                }
                com.tencent.mm.br.c.d(this, Scopes.PROFILE, ".ui.ContactInfoUI", 1);
            }
            AppMethodBeat.o(73838);
        } else {
            h.d(this, getString(R.string.dg3, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73834);
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(73834);
                }
            });
            AppMethodBeat.o(73838);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(73839);
        c.jRt.o(new Intent(), this);
        finish();
        AppMethodBeat.o(73839);
    }

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        AppMethodBeat.i(73840);
        if (!Util.isNullOrNil(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith(com.tencent.mm.plugin.scanner.g.CAe)) {
                str2 = str.substring(com.tencent.mm.plugin.scanner.g.CAe.length()) + "@qr";
            } else if (str.startsWith(com.tencent.mm.plugin.scanner.g.CAd)) {
                str2 = str.substring(com.tencent.mm.plugin.scanner.g.CAd.length()) + "@qr";
            }
            g.azz().a(106, getQRCodeInfoUI);
            getQRCodeInfoUI.CYG = new f(str2, 5);
            g.azz().a(getQRCodeInfoUI.CYG, 0);
        }
        AppMethodBeat.o(73840);
    }
}
