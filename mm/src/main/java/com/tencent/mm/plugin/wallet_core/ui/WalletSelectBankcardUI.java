package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private TextView IjT;
    private MaxListView IjU;
    private a IjV = null;
    private String IjW = null;
    private boolean IjX = true;
    private String IjY = null;
    private List<Bankcard> IjZ = null;
    private int mScene = 0;
    private TextView qyy;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71227);
        super.onCreate(bundle);
        setMMTitle(R.string.i7j);
        this.mScene = getInput().getInt("key_scene", 0);
        this.IjW = getInput().getString("key_top_tips");
        this.IjX = getInput().getBoolean("key_is_show_new_bankcard", true);
        this.IjY = getInput().getString("bottom_tips");
        this.IjZ = getInput().getParcelableArrayList("key_showing_bankcards");
        if (this.IjZ == null) {
            this.IjZ = t.fQI().fRE();
        }
        this.IjT = (TextView) findViewById(R.id.ir2);
        this.IjU = (MaxListView) findViewById(R.id.a1t);
        this.qyy = (TextView) findViewById(R.id.abj);
        if (!Util.isNullOrNil(this.IjW)) {
            this.IjT.setVisibility(0);
            this.IjT.setText(this.IjW);
        } else {
            this.IjT.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.IjY)) {
            this.qyy.setVisibility(0);
            this.qyy.setText(this.IjY);
        } else {
            this.qyy.setVisibility(8);
        }
        if (this.mScene == 0) {
            this.qyy.setVisibility(0);
            l lVar = new l(this);
            lVar.IgH = new l.a() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                public final void onClick(View view) {
                    AppMethodBeat.i(71220);
                    Log.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
                    f.cM(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(R.string.i7o));
                    AppMethodBeat.o(71220);
                }
            };
            String string = getString(R.string.irw);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(lVar, string.length() - 14, string.length(), 33);
            this.qyy.setText(spannableString);
            this.qyy.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.IjV = new a(this, (byte) 0);
        this.IjU.setAdapter((ListAdapter) this.IjV);
        this.IjU.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(71223);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSelectBankcardUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i2);
                if (bankcard != null) {
                    h.a((Context) WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(R.string.iry, new Object[]{bankcard.field_desc, bankcard.field_mobile}), WalletSelectBankcardUI.this.getString(R.string.is0), WalletSelectBankcardUI.this.getString(R.string.irx), WalletSelectBankcardUI.this.getString(R.string.irz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71221);
                            WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11977, 0, 0, 0, 0, 1, 0);
                            AppMethodBeat.o(71221);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71222);
                            WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                            AppMethodBeat.o(71222);
                        }
                    });
                } else {
                    WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSelectBankcardUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(71223);
            }
        });
        AppMethodBeat.o(71227);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WalletSelectBankcardUI walletSelectBankcardUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(71224);
            if (WalletSelectBankcardUI.this.IjX) {
                if (WalletSelectBankcardUI.this.IjZ == null) {
                    AppMethodBeat.o(71224);
                    return 1;
                }
                int size = WalletSelectBankcardUI.this.IjZ.size() + 1;
                AppMethodBeat.o(71224);
                return size;
            } else if (WalletSelectBankcardUI.this.IjZ == null) {
                AppMethodBeat.o(71224);
                return 0;
            } else {
                int size2 = WalletSelectBankcardUI.this.IjZ.size();
                AppMethodBeat.o(71224);
                return size2;
            }
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(71225);
            if (WalletSelectBankcardUI.this.IjZ == null || WalletSelectBankcardUI.this.IjZ.size() <= i2) {
                AppMethodBeat.o(71225);
                return null;
            }
            Object obj = WalletSelectBankcardUI.this.IjZ.get(i2);
            AppMethodBeat.o(71225);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1920a aVar;
            AppMethodBeat.i(71226);
            Bankcard bankcard = (Bankcard) getItem(i2);
            if (view == null) {
                view = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(R.layout.ca0, viewGroup, false);
                C1920a aVar2 = new C1920a();
                aVar2.Ikd = (TextView) view.findViewById(R.id.a1g);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1920a) view.getTag();
            }
            if (bankcard != null) {
                aVar.Ikd.setText(bankcard.field_desc);
            } else {
                aVar.Ikd.setText(R.string.is2);
            }
            AppMethodBeat.o(71226);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI$a$a  reason: collision with other inner class name */
        class C1920a {
            TextView Ikd;

            C1920a() {
            }
        }
    }

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        AppMethodBeat.i(71228);
        walletSelectBankcardUI.getInput().putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.getNetController().r(new Object[0]);
        AppMethodBeat.o(71228);
    }
}
