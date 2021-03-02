package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private int dTz = 0;
    private RcptItem kvb = null;
    private RcptItem kvc = null;
    private List<RcptItem> kvd;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletMultiRcptSelectUI walletMultiRcptSelectUI) {
        AppMethodBeat.i(21018);
        walletMultiRcptSelectUI.bqr();
        AppMethodBeat.o(21018);
    }

    private void bqr() {
        AppMethodBeat.i(21009);
        switch (this.dTz) {
            case 1:
                this.kvb = null;
                this.dTz = 0;
                break;
            case 2:
                this.kvc = null;
                this.dTz = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.dTz);
        intent.putExtra("key_province", this.kvb);
        intent.putExtra("key_city", this.kvc);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(21009);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21010);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(21010);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(21011);
        super.onResume();
        AppMethodBeat.o(21011);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21012);
        super.onDestroy();
        AppMethodBeat.o(21012);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        List<RcptItem> TC;
        int i2 = R.string.fw;
        AppMethodBeat.i(21013);
        Intent intent = getIntent();
        if (intent != null) {
            i2 = intent.getIntExtra("ui_title", R.string.fw);
        }
        setMMTitle(i2);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21008);
                WalletMultiRcptSelectUI.a(WalletMultiRcptSelectUI.this);
                AppMethodBeat.o(21008);
                return true;
            }
        });
        y(intent);
        List<RcptItem> list = a.bqd().ksZ;
        if (list == null || list.isEmpty()) {
            Log.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
            a.bqd().bqe();
        }
        switch (this.dTz) {
            case 0:
                a.bqb();
                TC = a.bqd().ksZ;
                break;
            case 1:
                if (this.kvb != null && !Util.isNullOrNil(this.kvb.code)) {
                    a.bqb();
                    TC = a.bqd().TB(this.kvb.code);
                    break;
                }
            case 2:
                if (this.kvc != null && !Util.isNullOrNil(this.kvc.code)) {
                    a.bqb();
                    TC = a.bqd().TC(this.kvc.code);
                    break;
                }
            default:
                a.bqb();
                TC = a.bqd().ksZ;
                break;
        }
        this.kvd = TC;
        if (this.kvd == null || this.kvd.size() <= 0) {
            Log.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.o(21013);
            return;
        }
        this.screen.removeAll();
        for (int i3 = 0; i3 < this.kvd.size(); i3++) {
            if (this.kvd.get(i3) != null && !Util.isNullOrNil(this.kvd.get(i3).name)) {
                RcptPreference rcptPreference = new RcptPreference(this);
                RcptItem rcptItem = this.kvd.get(i3);
                if (rcptItem == null || Util.isNullOrNil(rcptItem.name)) {
                    Log.e("MicroMsg.RcptPreference", "setZoneItem item = null");
                } else {
                    rcptPreference.setKey(rcptItem.code + rcptPreference.hashCode());
                    rcptPreference.kuR = rcptItem;
                }
                this.screen.c(rcptPreference);
            }
        }
        this.screen.c(new PreferenceSmallCategory(this));
        AppMethodBeat.o(21013);
    }

    private void y(Intent intent) {
        AppMethodBeat.i(21014);
        if (intent == null) {
            Log.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            AppMethodBeat.o(21014);
            return;
        }
        this.dTz = intent.getIntExtra("key_stage", 0);
        this.kvb = (RcptItem) intent.getParcelableExtra("key_province");
        this.kvc = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.bqb();
            this.kvb = a.bqd().TD(stringExtra);
            if (this.kvb != null) {
                this.dTz = 1;
            }
        }
        String stringExtra2 = intent.getStringExtra("extra_city");
        if (stringExtra2 != null && 1 == this.dTz) {
            a.bqb();
            this.kvc = a.bqd().cd(this.kvb.code, stringExtra2);
            if (this.kvc != null) {
                this.dTz = 2;
            }
        }
        AppMethodBeat.o(21014);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f4  */
    @Override // com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f r9, com.tencent.mm.ui.base.preference.Preference r10) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI.onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f, com.tencent.mm.ui.base.preference.Preference):boolean");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(21016);
        bqr();
        super.onBackPressed();
        AppMethodBeat.o(21016);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(21017);
        switch (i2) {
            case 1:
                if (i3 != -1) {
                    y(intent);
                    break;
                } else {
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(21017);
                    return;
                }
        }
        AppMethodBeat.o(21017);
    }
}
