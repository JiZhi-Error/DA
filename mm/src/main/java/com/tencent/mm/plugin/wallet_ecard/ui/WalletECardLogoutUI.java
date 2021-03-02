package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.ejh;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import org.xwalk.core.Log;

public class WalletECardLogoutUI extends WalletECardBaseUI {
    private View FTX;
    private TextView Iqs;
    private LinearLayout Iqt;
    private Button Iqu;
    private String dQl;
    private String dQm;
    private TextView jUR;
    private TextView mPa;
    private CdnImageView ymf;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71786);
        super.onCreate(bundle);
        addSceneEndListener(2931);
        initView();
        setMMTitle(R.string.bpu);
        Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
        g gVar = new g();
        gVar.t(this);
        doSceneProgress(gVar, true);
        AppMethodBeat.o(71786);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71787);
        this.mPa = (TextView) findViewById(R.id.byq);
        this.Iqs = (TextView) findViewById(R.id.byp);
        this.Iqt = (LinearLayout) findViewById(R.id.byo);
        this.jUR = (TextView) findViewById(R.id.byj);
        this.ymf = (CdnImageView) findViewById(R.id.byl);
        this.FTX = findViewById(R.id.byn);
        this.Iqu = (Button) findViewById(R.id.bym);
        this.Iqu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71782);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardLogoutUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletECardLogoutUI.a(WalletECardLogoutUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardLogoutUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71782);
            }
        });
        AppMethodBeat.o(71787);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71788);
        super.onDestroy();
        removeSceneEndListener(2931);
        AppMethodBeat.o(71788);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71789);
        if (qVar instanceof g) {
            final g gVar = (g) qVar;
            gVar.a(new r.a() {
                /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(71783);
                    WalletECardLogoutUI.this.dQm = gVar.IpY.ANo;
                    WalletECardLogoutUI.this.dQl = gVar.IpY.dDj;
                    WalletECardLogoutUI.a(WalletECardLogoutUI.this, gVar.IpY);
                    AppMethodBeat.o(71783);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
            AppMethodBeat.o(71789);
            return true;
        }
        AppMethodBeat.o(71789);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0h;
    }

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI) {
        AppMethodBeat.i(71790);
        Log.i("MicroMsg.WalletECardLogoutUI", "do logout");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_show_detail", false);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = walletECardLogoutUI.dQm;
        bankcard.field_bankcardType = walletECardLogoutUI.dQl;
        bundle.putParcelable("key_bankcard", bankcard);
        bundle.putInt("scene", 2);
        bundle.putString("key_check_pwd_title", walletECardLogoutUI.getString(R.string.ib5));
        com.tencent.mm.wallet_core.a.a(walletECardLogoutUI, com.tencent.mm.plugin.wallet.bind.a.class, bundle);
        AppMethodBeat.o(71790);
    }

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI, dhb dhb) {
        AppMethodBeat.i(71791);
        if (!Util.isNullOrNil(dhb.MLy)) {
            walletECardLogoutUI.setMMTitle(dhb.MLy);
        }
        if (!Util.isNullOrNil(dhb.MLz)) {
            walletECardLogoutUI.mPa.setText(dhb.MLz);
        }
        if (!Util.isNullOrNil(dhb.iwv)) {
            walletECardLogoutUI.ymf.setUrl(dhb.iwv);
        }
        if (dhb.MLA != null) {
            ti tiVar = dhb.MLA;
            if (!Util.isNullOrNil(tiVar.LbV)) {
                walletECardLogoutUI.Iqs.setText(tiVar.LbV);
            }
            if (tiVar.LbW != null) {
                Iterator<String> it = tiVar.LbW.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(walletECardLogoutUI).inflate(R.layout.a0g, (ViewGroup) walletECardLogoutUI.Iqt, false);
                    ((TextView) linearLayout.findViewById(R.id.byi)).setText(next);
                    walletECardLogoutUI.Iqt.addView(linearLayout);
                }
            }
        }
        if (dhb.MLD != null) {
            Log.i("MicroMsg.WalletECardLogoutUI", "show trade detail");
            final ejh ejh = dhb.MLD;
            if (!Util.isNullOrNil(ejh.title)) {
                com.tencent.mm.plugin.wallet_core.ui.q qVar = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
                    /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                    public final void dF(View view) {
                        AppMethodBeat.i(71784);
                        f.p(WalletECardLogoutUI.this.getContext(), ejh.yUB, false);
                        AppMethodBeat.o(71784);
                    }
                });
                SpannableString spannableString = new SpannableString(ejh.title);
                spannableString.setSpan(qVar, 0, spannableString.length(), 18);
                walletECardLogoutUI.jUR.setClickable(true);
                walletECardLogoutUI.jUR.setOnTouchListener(new o(walletECardLogoutUI));
                walletECardLogoutUI.jUR.setText(spannableString);
                walletECardLogoutUI.jUR.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(71785);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71785);
                    }
                });
                walletECardLogoutUI.jUR.setVisibility(0);
            }
        }
        walletECardLogoutUI.FTX.setVisibility(8);
        AppMethodBeat.o(71791);
    }
}
