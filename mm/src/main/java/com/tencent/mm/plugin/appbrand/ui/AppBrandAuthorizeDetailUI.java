package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI extends MMPreference {
    private int mAT;
    private boolean nRl = false;
    private f nRm;
    private Preference nRn;
    private AppBrandAuthPreference nRo;
    private AppBrandAuthPreference nRp;
    private AppBrandAuthPreference nRq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(AppBrandAuthorizeDetailUI appBrandAuthorizeDetailUI) {
        AppMethodBeat.i(48526);
        appBrandAuthorizeDetailUI.bWK();
        AppMethodBeat.o(48526);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.f3181h;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        String str;
        boolean z;
        AppMethodBeat.i(48522);
        fixStatusbar(true);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48521);
                AppBrandAuthorizeDetailUI.a(AppBrandAuthorizeDetailUI.this);
                AppBrandAuthorizeDetailUI.this.finish();
                AppMethodBeat.o(48521);
                return false;
            }
        });
        if (getIntent() == null || Util.isNullOrNil(getIntent().getStringExtra("key_title"))) {
            setMMTitle(R.string.ix);
        } else {
            setMMTitle(getIntent().getStringExtra("key_title"));
        }
        this.nRm = getPreferenceScreen();
        this.nRm.removeAll();
        if (getIntent() == null || Util.isNullOrNil(getIntent().getStringExtra("key_desc"))) {
            str = null;
        } else {
            str = String.format(getString(R.string.j1), getIntent().getStringExtra("key_desc"));
        }
        if (!Util.isNullOrNil(str)) {
            this.nRn = new Preference(this);
            this.nRn.setTitle(str);
            this.nRn.setLayoutResource(R.layout.eq);
            this.nRm.c(this.nRn);
        }
        this.nRo = new AppBrandAuthPreference(this);
        this.nRo.setKey("none");
        this.nRo.wd(R.string.iv);
        this.nRm.c(this.nRo);
        this.nRp = new AppBrandAuthPreference(this);
        this.nRp.setKey("foreground");
        this.nRp.wd(R.string.iu);
        this.nRm.c(this.nRp);
        if (getIntent() != null) {
            z = getIntent().getBooleanExtra("key_three_state", false);
        } else {
            z = false;
        }
        if (z) {
            this.nRq = new AppBrandAuthPreference(this);
            this.nRq.setKey("both");
            this.nRq.wd(R.string.it);
            this.nRm.c(this.nRq);
        }
        if (getIntent() != null && getIntent().hasExtra("key_state")) {
            this.mAT = getIntent().getIntExtra("key_state", 0);
        }
        switch (this.mAT) {
            case 1:
                this.nRp.setChecked(true);
                break;
            case 2:
                if (this.nRq != null) {
                    this.nRq.setChecked(true);
                    break;
                }
                break;
            default:
                this.nRo.setChecked(true);
                break;
        }
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(48522);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(48523);
        bWK();
        super.onBackPressed();
        AppMethodBeat.o(48523);
    }

    private void bWK() {
        AppMethodBeat.i(48524);
        if (this.nRl) {
            Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", Integer.valueOf(this.mAT));
            Intent intent = new Intent();
            intent.putExtra("key_result_state", this.mAT);
            setResult(-1, intent);
            AppMethodBeat.o(48524);
            return;
        }
        setResult(0, null);
        AppMethodBeat.o(48524);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(48525);
        Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", preference.mKey);
        if (preference instanceof AppBrandAuthPreference) {
            this.nRl = true;
            if (preference.mKey.equalsIgnoreCase("both")) {
                this.mAT = 2;
                this.nRo.setChecked(false);
                this.nRp.setChecked(false);
                if (this.nRq != null) {
                    this.nRq.setChecked(true);
                }
            } else if (preference.mKey.equalsIgnoreCase("foreground")) {
                this.mAT = 1;
                this.nRp.setChecked(true);
                this.nRo.setChecked(false);
                if (this.nRq != null) {
                    this.nRq.setChecked(false);
                }
            } else {
                this.mAT = 0;
                this.nRo.setChecked(true);
                this.nRp.setChecked(false);
                if (this.nRq != null) {
                    this.nRq.setChecked(false);
                }
            }
            this.nRm.notifyDataSetChanged();
        }
        AppMethodBeat.o(48525);
        return false;
    }
}
