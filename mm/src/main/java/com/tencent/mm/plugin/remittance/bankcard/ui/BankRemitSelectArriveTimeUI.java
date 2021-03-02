package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectArriveTimeUI extends MMPreference {
    private List<EnterTimeParcel> Clr;
    private List<Preference> Cls;
    private int Clt;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67573);
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.f0)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.brt);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.fm));
            }
            View findViewById2 = customView.findViewById(16908308);
            if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                ((TextView) findViewById2).setTextColor(getResources().getColor(R.color.a2x));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.f0));
        }
        BankRemitBaseUI.aC(this);
        getContentView().setFitsSystemWindows(true);
        setMMTitle(R.string.ac0);
        this.Clr = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.Clt = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(R.color.f0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67572);
                BankRemitSelectArriveTimeUI.this.finish();
                AppMethodBeat.o(67572);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(67573);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67574);
        this.screen = getPreferenceScreen();
        if (this.Clr != null && this.Clr.size() > 0) {
            this.Cls = new ArrayList();
            for (int i2 = 0; i2 < this.Clr.size(); i2++) {
                EnterTimeParcel enterTimeParcel = this.Clr.get(i2);
                Log.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", Integer.valueOf(enterTimeParcel.Cjg));
                Preference preference = new Preference(this);
                preference.setLayoutResource(R.layout.ij);
                preference.OZw = false;
                preference.setKey(new StringBuilder().append(enterTimeParcel.Cjg).toString());
                preference.setTitle(enterTimeParcel.Cjh);
                if (enterTimeParcel.Cjg == this.Clt) {
                    preference.setWidgetLayoutResource(R.layout.b_m);
                } else {
                    preference.setWidgetLayoutResource(R.layout.b_n);
                }
                if (enterTimeParcel.Cjj == 0) {
                    if (!Util.isNullOrNil(enterTimeParcel.Cji)) {
                        preference.setSummary(enterTimeParcel.Cji);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.screen.c(preference);
                this.Cls.add(preference);
            }
        }
        AppMethodBeat.o(67574);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.layout.ik;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(67575);
        for (Preference preference2 : this.Cls) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(R.layout.b_m);
            } else {
                preference2.setWidgetLayoutResource(R.layout.b_n);
            }
        }
        this.screen.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            Log.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
            AppMethodBeat.o(67575);
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.Cjg);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(67575);
        }
        return false;
    }
}
