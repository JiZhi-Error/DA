package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.af.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class WalletBankcardDetailUI extends WalletBaseUI {
    protected TextView HDa;
    private TextView HDb;
    private View HDc;
    protected LinearLayout HDd;
    protected LinearLayout HDe;
    protected LinearLayout HDf;
    protected Bankcard Hww;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.i(69097);
        walletBankcardDetailUI.xS(true);
        AppMethodBeat.o(69097);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c80;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69087);
        super.onCreate(bundle);
        addSceneEndListener(h.CTRL_INDEX);
        setMMTitle(R.string.i82);
        initView();
        AppMethodBeat.o(69087);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69088);
        super.onResume();
        AppMethodBeat.o(69088);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69089);
        removeSceneEndListener(h.CTRL_INDEX);
        super.onDestroy();
        AppMethodBeat.o(69089);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69090);
        this.Hww = (Bankcard) getInput().getParcelable("key_bankcard");
        if (this.Hww == null) {
            AppMethodBeat.o(69090);
            return;
        }
        this.HDd = (LinearLayout) findViewById(R.id.jdr);
        this.HDe = (LinearLayout) findViewById(R.id.jdy);
        this.HDf = (LinearLayout) findViewById(R.id.jdw);
        this.HDb = (TextView) findViewById(R.id.jdu);
        this.HDc = findViewById(R.id.je3);
        this.HDc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(69077);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.p(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.Hww.field_repay_url, false);
                a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69077);
            }
        });
        if (1 == this.Hww.field_bankcardState) {
            fNX();
            AppMethodBeat.o(69090);
            return;
        }
        if (this.Hww.fQe()) {
            xR(true);
            this.HDa = (TextView) findViewById(R.id.jdq);
            s.fOg();
            s.fOh();
            this.HDa.setVisibility(8);
        } else {
            xR(false);
            this.HDa = (TextView) findViewById(R.id.jdv);
            s.fOg();
            s.fOh();
            this.HDa.setVisibility(8);
        }
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69082);
                s.fOg();
                ArrayList<Bankcard> fRE = s.fOh().fRE();
                if (fRE != null && fRE.size() > 1) {
                    s.fOg();
                    s.fOh();
                }
                ArrayList arrayList = new ArrayList();
                com.tencent.mm.ui.base.h.b(WalletBankcardDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletBankcardDetailUI.this.getString(R.string.ie8), new h.d() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(69081);
                        switch (i2) {
                            case 0:
                                WalletBankcardDetailUI.a(WalletBankcardDetailUI.this);
                                break;
                        }
                        AppMethodBeat.o(69081);
                    }
                });
                AppMethodBeat.o(69082);
                return true;
            }
        });
        AppMethodBeat.o(69090);
    }

    /* access modifiers changed from: protected */
    public final void xR(boolean z) {
        AppMethodBeat.i(69091);
        if (z) {
            this.HDd.setVisibility(8);
            this.HDe.setVisibility(0);
            ((TextView) findViewById(R.id.jdp)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69078);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletBankcardDetailUI.this.showDialog(0);
                    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69078);
                }
            });
            ((TextView) findViewById(R.id.je1)).setText(f.d(this.Hww.field_onceQuotaKind, (String) null));
            ((TextView) findViewById(R.id.je2)).setText(f.d(this.Hww.field_onceQuotaVirtual, (String) null));
            ((TextView) findViewById(R.id.jdz)).setText(f.d(this.Hww.field_dayQuotaKind, (String) null));
            ((TextView) findViewById(R.id.je0)).setText(f.d(this.Hww.field_dayQuotaVirtual, (String) null));
            if (!Util.isNullOrNil(this.Hww.field_repay_url)) {
                this.HDb.setVisibility(0);
                this.HDc.setVisibility(0);
            }
            AppMethodBeat.o(69091);
            return;
        }
        this.HDd.setVisibility(8);
        this.HDe.setVisibility(8);
        this.HDf.setVisibility(0);
        AppMethodBeat.o(69091);
    }

    /* access modifiers changed from: protected */
    public final void fNX() {
        AppMethodBeat.i(69092);
        this.HDd.setVisibility(0);
        this.HDe.setVisibility(8);
        ((TextView) findViewById(R.id.jds)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(69079);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBankcardDetailUI.this.showDialog(0);
                a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69079);
            }
        });
        ((TextView) findViewById(R.id.je5)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(69080);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.wallet_core.a.l(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.getInput());
                a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69080);
            }
        });
        AppMethodBeat.o(69092);
    }

    private void xS(boolean z) {
        AppMethodBeat.i(69093);
        if (z.aUo() || z || ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).fUF()) {
            getInput().putBoolean("offline_pay", false);
            com.tencent.mm.wallet_core.a.l(this, getInput());
            AppMethodBeat.o(69093);
            return;
        }
        f.aqm(0);
        com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.i84, -1, (int) R.string.i83, (int) R.string.i85, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69083);
                ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).l(WalletBankcardDetailUI.this, 1);
                f.aqm(1);
                AppMethodBeat.o(69083);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69084);
                WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                f.aqm(2);
                AppMethodBeat.o(69084);
            }
        });
        AppMethodBeat.o(69093);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    @Deprecated
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(69094);
        Dialog a2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.i7p), getResources().getStringArray(R.array.ax), "", new h.d() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(69085);
                switch (i2) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + WalletBankcardDetailUI.this.getString(R.string.i7o)));
                        intent.addFlags(268435456);
                        WalletBankcardDetailUI walletBankcardDetailUI = WalletBankcardDetailUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(walletBankcardDetailUI, bl.axQ(), "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletBankcardDetailUI.startActivity((Intent) bl.pG(0));
                        a.a(walletBankcardDetailUI, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                AppMethodBeat.o(69085);
            }
        });
        AppMethodBeat.o(69094);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69095);
        if (i2 == 0 && i3 == 0) {
            if (!(qVar instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
                if (qVar instanceof com.tencent.mm.plugin.wallet.bind.a.a) {
                    com.tencent.mm.plugin.wallet.bind.a.a aVar = (com.tencent.mm.plugin.wallet.bind.a.a) qVar;
                    Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.HCt);
                    switch (aVar.HCt) {
                        case 2:
                        case 3:
                            final int i4 = aVar.HCt;
                            com.tencent.mm.ui.base.h.a((Context) this, aVar.HCu, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.AnonymousClass9 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69086);
                                    if (i4 == 2) {
                                        WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                                    }
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(69086);
                                }
                            });
                            break;
                        default:
                            xS(false);
                            break;
                    }
                }
            } else if (this.HDa != null) {
                this.HDa.setVisibility(0);
            }
        } else if (qVar instanceof com.tencent.mm.plugin.wallet.bind.a.a) {
            Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            xS(false);
            AppMethodBeat.o(69095);
            return true;
        }
        AppMethodBeat.o(69095);
        return false;
    }

    static /* synthetic */ void a(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.i(69096);
        walletBankcardDetailUI.doSceneProgress(new com.tencent.mm.plugin.wallet.bind.a.a(walletBankcardDetailUI.Hww.field_bankcardType, walletBankcardDetailUI.Hww.field_bindSerial), true);
        AppMethodBeat.o(69096);
    }
}
