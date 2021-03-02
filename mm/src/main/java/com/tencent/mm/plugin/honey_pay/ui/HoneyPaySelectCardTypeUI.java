package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoneyPaySelectCardTypeUI extends HoneyPayBaseUI {
    private LinearLayout yma;
    private List<cak> ymb;
    private int ymc;
    private cal ymd;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64845);
        this.wwG = R.color.ul;
        super.onCreate(bundle);
        addSceneEndListener(2618);
        addSceneEndListener(2926);
        setMMTitle(R.string.e17);
        ArrayList<HoneyPayCardType> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_card_type_list");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.ymb = new ArrayList();
            try {
                for (HoneyPayCardType honeyPayCardType : parcelableArrayListExtra) {
                    cak cak = new cak();
                    cak.parseFrom(honeyPayCardType.zy);
                    this.ymb.add(cak);
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", e2, "", new Object[0]);
            }
        }
        initView();
        refreshView();
        AppMethodBeat.o(64845);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64846);
        this.yma = (LinearLayout) $(R.id.dsy);
        AppMethodBeat.o(64846);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64847);
        removeSceneEndListener(2618);
        removeSceneEndListener(2926);
        super.onDestroy();
        AppMethodBeat.o(64847);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needExecuteBackListener() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64848);
        if (qVar instanceof b) {
            final b bVar = (b) qVar;
            bVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64841);
                    HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, bVar.yjy.LjF, bVar.yjy.LjE, bVar.yjy.LjG, bVar.yjy.LjH, bVar.username, bVar.yjy.yPK, bVar.yjy.qGB);
                    AppMethodBeat.o(64841);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(64848);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.auv;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64849);
        if (i2 == 1) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", stringExtra);
                Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", stringExtra);
                b bVar = new b(stringExtra, this.ymc);
                bVar.t(this);
                doSceneProgress(bVar, true);
            } else {
                Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64849);
    }

    private void refreshView() {
        View view;
        AppMethodBeat.i(64850);
        this.yma.removeAllViews();
        if (this.ymb == null || this.ymb.isEmpty()) {
            AppMethodBeat.o(64850);
            return;
        }
        for (cak cak : this.ymb) {
            a aVar = new a(this, (byte) 0);
            if (cak.LWF == null) {
                AppCompatActivity context = getContext();
                View inflate = LayoutInflater.from(context).inflate(R.layout.aut, (ViewGroup) this.yma, false);
                aVar.a(inflate, cak);
                view = inflate;
            } else {
                AppCompatActivity context2 = getContext();
                View inflate2 = LayoutInflater.from(context2).inflate(R.layout.auu, (ViewGroup) this.yma, false);
                aVar.a(inflate2, cak);
                aVar.ykj = (CdnImageView) inflate2.findViewById(R.id.dsw);
                aVar.ymh = (TextView) inflate2.findViewById(R.id.dsx);
                aVar.ykj.setUrl(cak.LWF.icon);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) cak.LWF.MfC);
                spannableStringBuilder.append((CharSequence) cak.LWF.MfD);
                spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a(cak, context2) {
                    /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.AnonymousClass1 */
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ cak ymj;

                    {
                        this.ymj = r2;
                        this.val$context = r3;
                    }

                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                    public final void dF(View view) {
                        AppMethodBeat.i(64842);
                        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
                        if (!Util.isNullOrNil(this.ymj.LWF.url)) {
                            f.p(this.val$context, this.ymj.LWF.url, false);
                        }
                        AppMethodBeat.o(64842);
                    }
                }), cak.LWF.MfC.length(), spannableStringBuilder.length(), 34);
                aVar.ymh.setOnTouchListener(new o(context2));
                aVar.ymh.setClickable(true);
                aVar.ymh.setText(spannableStringBuilder);
                view = inflate2;
            }
            this.yma.addView(view);
        }
        AppMethodBeat.o(64850);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public CdnImageView ykj;
        public TextView ykt;
        public CdnImageView ymf;
        public TextView ymg;
        public TextView ymh;
        public ImageView ymi;

        private a() {
        }

        /* synthetic */ a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void a(View view, final cak cak) {
            AppMethodBeat.i(64844);
            this.ymf = (CdnImageView) view.findViewById(R.id.dst);
            this.ykt = (TextView) view.findViewById(R.id.dsv);
            this.ymg = (TextView) view.findViewById(R.id.dsu);
            this.ymi = (ImageView) view.findViewById(R.id.dss);
            this.ymf.setImageResource(c.aB(cak.nHh, cak.MfE));
            this.ykt.setText(cak.pTn);
            this.ymg.setText(cak.pWf);
            if (cak.MfE) {
                Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
                view.setEnabled(false);
                this.ykt.setEnabled(false);
                this.ymg.setEnabled(false);
                this.ymi.setVisibility(8);
                AppMethodBeat.o(64844);
                return;
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64843);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
                    if (HoneyPaySelectCardTypeUI.this.ymd != null) {
                        HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.this.ymd);
                    } else {
                        HoneyPaySelectCardTypeUI.this.ymc = cak.nHh;
                        HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI$CardTypeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64843);
                }
            });
            AppMethodBeat.o(64844);
        }
    }

    static /* synthetic */ void a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, long j2, long j3, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(64851);
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to give card");
        Intent intent = new Intent(honeyPaySelectCardTypeUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j2);
        intent.putExtra("key_min_credit_line", j3);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        intent.putExtra("key_wishing", str4);
        intent.putExtra("key_icon_url", str5);
        intent.putExtra("key_cardtype", honeyPaySelectCardTypeUI.ymc);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPaySelectCardTypeUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI", "gotoGiveCardUI", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPaySelectCardTypeUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPaySelectCardTypeUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPaySelectCardTypeUI", "gotoGiveCardUI", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64851);
    }

    static /* synthetic */ void a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, cal cal) {
        AppMethodBeat.i(64852);
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "do realname guide");
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
        c.a(honeyPaySelectCardTypeUI, bundle, cal, true);
        AppMethodBeat.o(64852);
    }

    static /* synthetic */ void b(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI) {
        AppMethodBeat.i(64853);
        Log.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to select contact");
        Intent intent = new Intent();
        intent.putExtra("list_attr", u.Q(16, 1, 2, 4, 16384));
        intent.putExtra("block_contact", z.aTY());
        intent.putExtra("titile", honeyPaySelectCardTypeUI.getString(R.string.e18));
        com.tencent.mm.br.c.c(honeyPaySelectCardTypeUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(64853);
    }
}
