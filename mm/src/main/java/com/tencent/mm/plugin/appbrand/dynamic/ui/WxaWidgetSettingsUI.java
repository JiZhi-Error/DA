package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int dMe;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(121515);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(121512);
                WxaWidgetSettingsUI.this.finish();
                AppMethodBeat.o(121512);
                return false;
            }
        });
        setMMTitle(R.string.j6b);
        this.appId = getIntent().getStringExtra("app_id");
        this.dMe = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.g46);
        DebuggerInfo Yv = b.Yv(this.appId);
        mMSwitchBtn.setCheck(Yv != null && Yv.lnd);
        mMSwitchBtn.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121513);
                DebuggerInfo Yv = b.Yv(WxaWidgetSettingsUI.this.appId);
                if (Yv == null) {
                    Yv = new DebuggerInfo();
                    b.a(WxaWidgetSettingsUI.this.appId, Yv);
                }
                Yv.lnd = z;
                AppMethodBeat.o(121513);
            }
        });
        MMSwitchBtn mMSwitchBtn2 = (MMSwitchBtn) findViewById(R.id.dye);
        if ((Yv != null && Yv.lnb) || j.a.sE(this.dMe)) {
            z = true;
        }
        mMSwitchBtn2.setCheck(z);
        mMSwitchBtn2.setEnabled(j.a.vP(this.dMe));
        mMSwitchBtn2.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121514);
                DebuggerInfo Yv = b.Yv(WxaWidgetSettingsUI.this.appId);
                if (Yv == null) {
                    Yv = new DebuggerInfo();
                    b.a(WxaWidgetSettingsUI.this.appId, Yv);
                }
                Yv.lnb = z;
                AppMethodBeat.o(121514);
            }
        });
        AppMethodBeat.o(121515);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cd4;
    }
}
