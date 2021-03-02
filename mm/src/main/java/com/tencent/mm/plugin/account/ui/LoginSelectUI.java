package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class LoginSelectUI extends MMPreference {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bg;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.b2m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(196871);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.afz);
        if (getListView() != null) {
            getListView().setBackgroundColor(getContext().getResources().getColor(R.color.f3045c));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getListView().getLayoutParams();
            layoutParams.width = at.aH(getContext(), R.dimen.ck);
            layoutParams.gravity = 1;
            getListView().setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(196871);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(196872);
        String str = preference.mKey;
        if (str.equals("phone_and_pad")) {
            c.V(this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            overridePendingTransition(R.anim.dn, R.anim.s);
            h.INSTANCE.Ip(1);
        } else if (str.equals("only_pad")) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.INSTANCE.Ip(0);
        }
        AppMethodBeat.o(196872);
        return false;
    }
}
