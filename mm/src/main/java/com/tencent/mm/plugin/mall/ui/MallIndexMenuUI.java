package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mall.a.h;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.List;

public class MallIndexMenuUI extends MMPreference implements i {
    private static final String zlf = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf1");
    private f screen;
    private int zjs;
    private List<dan> zlB;
    private HashMap<String, dam> zlC = new HashMap<>();
    private boolean zlD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexMenuUI() {
        AppMethodBeat.i(66069);
        AppMethodBeat.o(66069);
    }

    static {
        AppMethodBeat.i(213559);
        AppMethodBeat.o(213559);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66070);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getActionbarColor());
        this.zlD = getIntent().getBooleanExtra("key_default_show_currency", false);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexMenuUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66068);
                MallIndexMenuUI.this.finish();
                AppMethodBeat.o(66068);
                return true;
            }
        });
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.ew0);
        g.azz().a(1754, this);
        g.azz().a(new h(), 0);
        AppMethodBeat.o(66070);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(66071);
        super.onDestroy();
        g.azz().b(1754, this);
        AppMethodBeat.o(66071);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x041c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r18, int r19, java.lang.String r20, com.tencent.mm.ak.q r21) {
        /*
        // Method dump skipped, instructions count: 1130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallIndexMenuUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(66074);
        if (i2 == 1) {
            g.aAi();
            this.zjs = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
            if (i3 == -1) {
                if (z.aUp()) {
                    finish();
                    AppMethodBeat.o(66074);
                    return;
                }
                finish();
                sd sdVar = new sd();
                sdVar.dYH.context = getContext();
                EventCenter.instance.publish(sdVar);
            }
        }
        AppMethodBeat.o(66074);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0053  */
    @Override // com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f r13, com.tencent.mm.ui.base.preference.Preference r14) {
        /*
        // Method dump skipped, instructions count: 930
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallIndexMenuUI.onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f, com.tencent.mm.ui.base.preference.Preference):boolean");
    }
}
