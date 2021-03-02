package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private ListView GP;
    private ArrayList<Bankcard> Hva;
    private Bankcard Hvb;
    private String Hvc;
    private int Hvm = 0;
    private TextView HwI;
    private b HwJ;
    private int gwE = 0;
    private ArrayList<a> mData = new ArrayList<>();
    private int whv = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletSelectBankcardModeUI() {
        AppMethodBeat.i(68732);
        AppMethodBeat.o(68732);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68733);
        super.onCreate(bundle);
        setResult(0);
        this.gwE = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.whv = getIntent().getIntExtra("key_select_index", -1);
        Log.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.gwE);
        initView();
        AppMethodBeat.o(68733);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68734);
        setMMTitle(R.string.i7j);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68727);
                WalletSelectBankcardModeUI.this.setResult(0);
                WalletSelectBankcardModeUI.this.finish();
                AppMethodBeat.o(68727);
                return true;
            }
        });
        this.HwI = (TextView) findViewById(R.id.ji7);
        if (this.gwE == 0) {
            this.HwI.setText(R.string.isf);
        } else if (this.gwE == 1) {
            this.HwI.setText(R.string.isg);
        }
        this.GP = (ListView) findViewById(R.id.je8);
        this.HwJ = new b();
        this.GP.setAdapter((ListAdapter) this.HwJ);
        this.GP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(68728);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WalletSelectBankcardModeUI.this.whv = i2;
                WalletSelectBankcardModeUI.this.HwJ.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i2);
                WalletSelectBankcardModeUI.this.setResult(-1, intent);
                Log.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(i2)));
                WalletSelectBankcardModeUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(68728);
            }
        });
        this.mData.clear();
        this.Hvc = getString(R.string.i7_);
        if (this.gwE == 0) {
            s.fOg();
            an fOh = s.fOh();
            this.Hva = fOh.fRG();
            this.Hvb = fOh.a(this.Hva, null, false, true);
            if (fOh.IbO != null) {
                this.Hvm = fOh.IbO.Hvm;
                Log.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.Hvm);
            } else {
                this.Hvm = 0;
                Log.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.Hva == null || this.Hva.size() <= 0) {
                Log.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                Log.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.Hva.size());
                Iterator<Bankcard> it = this.Hva.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    Bankcard next = it.next();
                    a aVar = new a((byte) 0);
                    aVar.title = next.field_desc;
                    if (next.field_fetch_charge_rate <= 0.0d || this.Hvm != 1) {
                        Log.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + next.field_desc + " field_fetch_charge_rate is " + next.field_fetch_charge_rate + " is_show_charge is " + this.Hvm);
                    } else if (!TextUtils.isEmpty(next.field_fetch_charge_info)) {
                        aVar.pWf = next.field_fetch_charge_info;
                    } else {
                        aVar.pWf = getString(R.string.i64) + (next.field_fetch_charge_rate * 100.0d) + "%";
                    }
                    this.mData.add(aVar);
                    if (this.whv == -1 && this.Hvb != null && this.Hvb.equals(next)) {
                        this.whv = i2;
                    }
                    i2++;
                }
                if (this.whv == -1 && this.Hvb == null) {
                    this.whv = i2;
                }
            }
            a aVar2 = new a((byte) 0);
            aVar2.title = this.Hvc;
            aVar2.pWf = "";
            this.mData.add(aVar2);
        }
        this.HwJ.notifyDataSetChanged();
        AppMethodBeat.o(68734);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String pWf;
        public String title;

        private a() {
            this.title = "";
            this.pWf = "";
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ViewHolder"})
    public class b extends BaseAdapter {
        b() {
        }

        public final int getCount() {
            AppMethodBeat.i(68729);
            int size = WalletSelectBankcardModeUI.this.mData.size();
            AppMethodBeat.o(68729);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(68730);
            View inflate = View.inflate(WalletSelectBankcardModeUI.this, R.layout.c_z, null);
            a aVar = (a) WalletSelectBankcardModeUI.this.mData.get(i2);
            TextView textView = (TextView) inflate.findViewById(R.id.a20);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.hix);
            ((TextView) inflate.findViewById(R.id.a21)).setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.pWf)) {
                textView.setVisibility(0);
                textView.setText(aVar.pWf);
            } else {
                textView.setVisibility(8);
            }
            if (WalletSelectBankcardModeUI.this.whv == i2) {
                imageView.setImageResource(R.raw.radio_on);
            } else {
                imageView.setImageResource(R.raw.radio_off);
            }
            AppMethodBeat.o(68730);
            return inflate;
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(68731);
            a aVar = (a) WalletSelectBankcardModeUI.this.mData.get(i2);
            AppMethodBeat.o(68731);
            return aVar;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_y;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68735);
        if (i2 == 4) {
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(68735);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
