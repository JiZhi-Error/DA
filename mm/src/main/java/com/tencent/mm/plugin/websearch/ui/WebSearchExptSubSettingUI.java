package com.tencent.mm.plugin.websearch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.util.c;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-websearch_release"})
public final class WebSearchExptSubSettingUI extends MMPreference {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        T t;
        AppMethodBeat.i(201739);
        super.onCreate(bundle);
        setBackBtn(new a(this));
        String stringExtra = getIntent().getStringExtra("groupKey");
        c cVar = c.QYz;
        LinkedList<akn> linkedList = c.hda().Ltx;
        p.g(linkedList, "ExptSettingLogic.exptSettingConfig.groups");
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.key, stringExtra)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            setMMTitle(t2.title);
            LinkedList<ako> linkedList2 = t2.iAd;
            p.g(linkedList2, "group.items");
            for (T t3 : linkedList2) {
                switch (t3.type) {
                    case 1:
                        Preference preference = new Preference(this);
                        c cVar2 = c.QYz;
                        p.g(stringExtra, "groupKey");
                        String str = t3.key;
                        p.g(str, "item.key");
                        preference.setKey(c.np(stringExtra, str));
                        preference.setTitle(t3.title);
                        getPreferenceScreen().c(preference);
                        break;
                    default:
                        CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                        c cVar3 = c.QYz;
                        p.g(stringExtra, "groupKey");
                        String str2 = t3.key;
                        p.g(str2, "item.key");
                        checkBoxPreference.setKey(c.np(stringExtra, str2));
                        checkBoxPreference.setTitle(t3.title);
                        c cVar4 = c.QYz;
                        String key = checkBoxPreference.getKey();
                        p.g(key, "key");
                        checkBoxPreference.setChecked(p.j("1", c.axY(key)));
                        getPreferenceScreen().c(checkBoxPreference);
                        break;
                }
            }
            AppMethodBeat.o(201739);
            return;
        }
        finish();
        AppMethodBeat.o(201739);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WebSearchExptSubSettingUI IGE;

        a(WebSearchExptSubSettingUI webSearchExptSubSettingUI) {
            this.IGE = webSearchExptSubSettingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201738);
            this.IGE.finish();
            AppMethodBeat.o(201738);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(201740);
        if (preference != null) {
            if (preference instanceof CheckBoxPreference) {
                c cVar = c.QYz;
                String key = ((CheckBoxPreference) preference).getKey();
                p.g(key, "it.key");
                if (c.nq(key, ((CheckBoxPreference) preference).isChecked() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO) && com.tencent.mm.pluginsdk.i.c.gnr() != null) {
                    com.tencent.mm.pluginsdk.i.c.gnr().bV(MMApplicationContext.getContext());
                }
            } else {
                Intent intent = new Intent(this, WebSearchExptSubValueSettingUI.class);
                intent.putExtra("valueKey", preference.getKey());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        AppMethodBeat.o(201740);
        return true;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.dm;
    }
}
