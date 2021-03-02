package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;

public class SelectSexUI extends MMPreference {
    private int fuA = -1;
    private f screen;
    private SelectPreference vNQ;
    private SelectPreference vNR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c5;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73948);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(73948);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73949);
        this.screen = getPreferenceScreen();
        this.vNQ = (SelectPreference) this.screen.bmg("select_male");
        this.vNR = (SelectPreference) this.screen.bmg("select_female");
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(12290, (Object) null), 0);
        if (nullAs == 1) {
            this.vNQ.isSelected = true;
        } else if (nullAs == 2) {
            this.vNR.isSelected = true;
        }
        setMMTitle(R.string.git);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelectSexUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73946);
                SelectSexUI.this.hideVKB();
                SelectSexUI.this.finish();
                AppMethodBeat.o(73946);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelectSexUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73947);
                SelectSexUI.a(SelectSexUI.this);
                SelectSexUI.this.finish();
                AppMethodBeat.o(73947);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(73949);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(73950);
        String str = preference.mKey;
        if (str.equals("select_male")) {
            this.fuA = 1;
            this.vNQ.isSelected = true;
            this.vNR.isSelected = false;
            fVar.notifyDataSetChanged();
        } else if (str.equals("select_female")) {
            this.fuA = 2;
            this.vNQ.isSelected = false;
            this.vNR.isSelected = true;
            fVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(73950);
        return false;
    }

    static /* synthetic */ void a(SelectSexUI selectSexUI) {
        AppMethodBeat.i(73951);
        bz aWj = bz.aWj();
        if (selectSexUI.fuA != -1) {
            aWj.fuA = selectSexUI.fuA;
        }
        ((l) g.af(l.class)).aSM().d(new k.a(1, bz.a(aWj)));
        AppMethodBeat.o(73951);
    }
}
