package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Map;

public class SettingsPrivacyUI extends MMPreference {
    private boolean DaT = false;
    private boolean DdA = false;
    private boolean DdB = false;
    private boolean DdC = false;
    private boolean DdD = true;
    private eel DdE = null;
    private int DdF = e.k.Ozj;
    private final String DdG = "timeline_live_list_show";
    private final String DdH = "profile_finder_like_show";
    private boolean Ddl = true;
    private long Ddy;
    private boolean Ddz = false;
    private String gna = "";
    boolean guq = false;
    private HashMap<Integer, Integer> kbt = new HashMap<>();
    private long qAb;
    private f screen;
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsPrivacyUI() {
        AppMethodBeat.i(74347);
        AppMethodBeat.o(74347);
    }

    static /* synthetic */ void a(SettingsPrivacyUI settingsPrivacyUI, CheckBoxPreference checkBoxPreference, boolean z) {
        AppMethodBeat.i(256595);
        settingsPrivacyUI.a(checkBoxPreference, z);
        AppMethodBeat.o(256595);
    }

    static /* synthetic */ void i(SettingsPrivacyUI settingsPrivacyUI) {
        AppMethodBeat.i(74359);
        settingsPrivacyUI.dmp();
        AppMethodBeat.o(74359);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(74348);
        a aVar = new a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(74348);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(74349);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        this.status = z.aUc();
        this.qAb = z.aUd();
        this.Ddy = ((aj) g.ah(aj.class)).getFinderSwitchApi().dCq();
        this.gna = z.aTY();
        this.DdE = ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
        this.DdD = this.DdE.NeF == 0;
        this.DdF = getIntent().getIntExtra("enter_scene", e.k.Ozj);
        Log.d("MicroMsg.SettingPrivacy", "story Notify:%s", Boolean.valueOf(this.DdD));
        initView();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14098, 9);
        if (this.DdF == e.k.Ozk || this.DdF == e.k.Ozl) {
            ebj ebj = new ebj();
            if (o.DCN != null) {
                ebj = o.DCN.aNV(this.gna);
            }
            if (ebj != null) {
                int i2 = ebj.Nbc;
                int i3 = ebj.Nbd;
                this.Ddz = i3 == 4320 && (i2 & 4096) > 0;
                if (i3 != 72 || (i2 & 4096) <= 0) {
                    z = false;
                } else {
                    z = true;
                }
                this.DdA = z;
                if (i3 != 720 || (i2 & 4096) <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.DdC = z2;
                if ((i2 & 2048) <= 0) {
                    z3 = false;
                }
                this.DdB = z3;
            }
            eTu();
        }
        AppMethodBeat.o(74349);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74350);
        super.onResume();
        this.status = z.aUc();
        this.qAb = z.aUd();
        this.Ddy = ((aj) g.ah(aj.class)).getFinderSwitchApi().dCq();
        dmp();
        if (!this.guq) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!Util.isNullOrNil(stringExtra)) {
                final int bmj = this.screen.bmj(stringExtra);
                setSelection(bmj - 3);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74343);
                        View a2 = ((a) SettingsPrivacyUI.this.screen).a(bmj, SettingsPrivacyUI.this.getListView());
                        if (a2 != null) {
                            com.tencent.mm.ui.i.a.c(SettingsPrivacyUI.this.getContext(), a2);
                        }
                        AppMethodBeat.o(74343);
                    }
                }, 10);
            }
            this.guq = true;
        }
        AppMethodBeat.o(74350);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74351);
        super.onPause();
        g.aAh().azQ().set(7, Integer.valueOf(this.status));
        g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
        ((aj) g.ah(aj.class)).getFinderSwitchApi().Gf(this.Ddy);
        for (Map.Entry<Integer, Integer> entry : this.kbt.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            bfx bfx = new bfx();
            bfx.LPB = intValue;
            bfx.BsD = intValue2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.kbt.clear();
        AppMethodBeat.o(74351);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74352);
        super.onDestroy();
        AppMethodBeat.o(74352);
    }

    private void eTu() {
        AppMethodBeat.i(74354);
        ebj ebj = new ebj();
        if (o.DCN != null) {
            ebj = o.DCN.aNV(this.gna);
        }
        if (ebj == null) {
            Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.o(74354);
            return;
        }
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue();
        if (intValue > ((Integer) g.aAh().azQ().get(ar.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue()) {
            g.aAh().azQ().set(ar.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            dmp();
        }
        d.a aVar = new d.a(getContext());
        aVar.aoW(R.string.sz);
        aVar.aoO(R.string.bb4);
        View inflate = View.inflate(getContext(), R.layout.b7l, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ifm);
        View.OnClickListener r5 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(74345);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    TextView textView = (TextView) linearLayout.getChildAt(i2);
                    if (R.id.ipe != textView.getId()) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                    }
                }
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                ebj ebj = new ebj();
                if (o.DCN != null) {
                    ebj = o.DCN.aNV(SettingsPrivacyUI.this.gna);
                }
                if (ebj == null) {
                    Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74345);
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                Log.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue));
                if (intValue == 0) {
                    if (SettingsPrivacyUI.this.DdF == e.k.Ozk) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14090, 4);
                    }
                    SettingsPrivacyUI.this.Ddz = false;
                    SettingsPrivacyUI.this.DdA = true;
                    SettingsPrivacyUI.this.DdC = false;
                    SettingsPrivacyUI.this.DdB = true;
                } else if (intValue == 1) {
                    if (SettingsPrivacyUI.this.DdF == e.k.Ozk) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14090, 5);
                    }
                    SettingsPrivacyUI.this.Ddz = true;
                    SettingsPrivacyUI.this.DdA = false;
                    SettingsPrivacyUI.this.DdC = false;
                    SettingsPrivacyUI.this.DdB = true;
                } else if (intValue == 3) {
                    SettingsPrivacyUI.this.Ddz = false;
                    SettingsPrivacyUI.this.DdA = false;
                    SettingsPrivacyUI.this.DdC = true;
                    SettingsPrivacyUI.this.DdB = true;
                } else {
                    if (SettingsPrivacyUI.this.DdF == e.k.Ozk) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14090, 6);
                    }
                    SettingsPrivacyUI.this.Ddz = false;
                    SettingsPrivacyUI.this.DdA = false;
                    SettingsPrivacyUI.this.DdC = false;
                    SettingsPrivacyUI.this.DdB = true;
                }
                if (o.DCN != null) {
                    o.DCN.a(SettingsPrivacyUI.this.gna, SettingsPrivacyUI.this.Ddz, SettingsPrivacyUI.this.DdA, SettingsPrivacyUI.this.DdB, SettingsPrivacyUI.this.DdC);
                }
                if (o.DCN != null) {
                    ebj b2 = o.DCN.b(SettingsPrivacyUI.this.gna, SettingsPrivacyUI.this.Ddz, SettingsPrivacyUI.this.DdA, SettingsPrivacyUI.this.DdB, SettingsPrivacyUI.this.DdC);
                    if (b2 == null) {
                        Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(74345);
                        return;
                    }
                    Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b2.toString());
                    ((l) g.af(l.class)).aSM().d(new k.a(51, b2));
                }
                view.post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74344);
                        ((Dialog) linearLayout.getTag()).dismiss();
                        SettingsPrivacyUI.i(SettingsPrivacyUI.this);
                        AppMethodBeat.o(74344);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74345);
            }
        };
        a(linearLayout, R.string.bb6, 1, this.Ddz, r5);
        a(linearLayout, R.string.bb7, 3, this.DdC, r5);
        a(linearLayout, R.string.bb8, 0, this.DdA, r5);
        a(linearLayout, R.string.bb5, 2, !this.Ddz && !this.DdA && !this.DdC, r5);
        aVar.hs(inflate);
        d hbn = aVar.hbn();
        linearLayout.setTag(hbn);
        hbn.show();
        addDialog(hbn);
        AppMethodBeat.o(74354);
    }

    private void a(LinearLayout linearLayout, int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        AppMethodBeat.i(74355);
        TextView textView = (TextView) View.inflate(getContext(), R.layout.bkg, null);
        textView.setText(i2);
        textView.setTag(Integer.valueOf(i3));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
        }
        AppMethodBeat.o(74355);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        PreferenceTitleCategory preferenceTitleCategory;
        AppMethodBeat.i(74356);
        setMMTitle(R.string.gmz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74346);
                SettingsPrivacyUI.this.hideVKB();
                SettingsPrivacyUI.this.finish();
                AppMethodBeat.o(74346);
                return true;
            }
        });
        Log.i("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status) + "extStatus: " + Long.toBinaryString(this.qAb) + " FinderSetting: " + Long.toBinaryString(this.Ddy));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_need_verify");
        checkBoxPreference.OZw = false;
        checkBoxPreference.setChecked(UM(32));
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.OZw = false;
        if (str == null || str.length() <= 0) {
            this.screen.e(checkBoxPreference2);
        } else {
            checkBoxPreference2.setChecked(!UM(256));
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) this.screen.bmg("settings_find_google_contact");
        checkBoxPreference3.OZw = false;
        if (!UM(1048576)) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference3.setChecked(z);
        String str2 = (String) g.aAh().azQ().get(208903, (Object) null);
        if (!Util.isOverseasUser(this) || TextUtils.isEmpty(str2)) {
            this.screen.e(checkBoxPreference3);
        }
        if (p.fvC() && (preferenceTitleCategory = (PreferenceTitleCategory) this.screen.bmg("settings_add_friends_timeline_tip")) != null) {
            preferenceTitleCategory.setTitle(R.string.jdt);
        }
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) this.screen.bmg("timeline_live_list_show");
        checkBoxPreference4.OZw = false;
        boolean z5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_sns_live_list, 1) == 1;
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            z5 = true;
        }
        if (z5) {
            if (!((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || ((ad) g.af(ad.class)).dxY()) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
            if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_FINDER_SNS_LIVE_LIST_SETTING_ENABLE_INT_SYNC, (Object) 0)).intValue() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!showFinderEntry || z3 || !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            Log.i("MicroMsg.SettingPrivacy", "timeline_live_list_show " + z3 + "," + showFinderEntry + "," + z4);
        }
        if (z5) {
            if ((this.qAb & 17592186044416L) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBoxPreference4.setChecked(!z2);
            this.screen.m38do("timeline_live_list_show", false);
        } else {
            this.screen.m38do("timeline_live_list_show", true);
        }
        final CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) this.screen.bmg("profile_finder_like_show");
        checkBoxPreference5.OZw = false;
        a(checkBoxPreference5, ((aj) g.ah(aj.class)).getFinderSwitchApi().a(new af.a<Boolean>() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.i.a.af.a
            public final /* synthetic */ void bn(Boolean bool) {
                AppMethodBeat.i(256593);
                SettingsPrivacyUI.a(SettingsPrivacyUI.this, checkBoxPreference5, bool.booleanValue());
                AppMethodBeat.o(256593);
            }
        }));
        if (!((Boolean) g.aAh().azQ().get(335873, Boolean.TRUE)).booleanValue() || !o.DCP.eZm()) {
            this.screen.m38do("edit_timeline_group", true);
        }
        this.screen.m38do("settings_unfamiliar_contact", true);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74356);
    }

    private void a(CheckBoxPreference checkBoxPreference, boolean z) {
        AppMethodBeat.i(256594);
        if (z) {
            checkBoxPreference.setChecked(!((aj) g.ah(aj.class)).getFinderSwitchApi().dCr());
            this.screen.m38do("profile_finder_like_show", false);
            AppMethodBeat.o(256594);
            return;
        }
        this.screen.m38do("profile_finder_like_show", true);
        AppMethodBeat.o(256594);
    }

    private boolean UM(int i2) {
        return (this.status & i2) != 0;
    }

    private boolean l(boolean z, int i2, int i3) {
        AppMethodBeat.i(74357);
        Log.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            this.status |= i2;
        } else {
            this.status &= i2 ^ -1;
        }
        this.kbt.put(Integer.valueOf(i3), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(74357);
        return true;
    }

    private void dmp() {
        ebj ebj;
        boolean z;
        boolean z2;
        CheckBoxPreference checkBoxPreference;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        AppMethodBeat.i(74358);
        ebj ebj2 = new ebj();
        eel storyUserInfo = ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUserInfo();
        if (o.DCN != null) {
            ebj = o.DCN.aNV(this.gna);
        } else {
            ebj = ebj2;
        }
        if (ebj == null) {
            Log.e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.o(74358);
            return;
        }
        int i2 = ebj.Nbc;
        int i3 = ebj.Nbd;
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("timeline_stranger_show");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.OZw = false;
            this.DaT = (i2 & 1) > 0;
            if (!this.DaT) {
                checkBoxPreference2.setChecked(true);
            } else {
                checkBoxPreference2.setChecked(false);
            }
        }
        IconPreference iconPreference = (IconPreference) this.screen.bmg("timeline_recent_show_select");
        if (iconPreference != null) {
            iconPreference.OZw = false;
            if (i3 != 4320 || (i2 & 4096) <= 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.Ddz = z4;
            if (i3 != 72 || (i2 & 4096) <= 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.DdA = z5;
            if (i3 != 720 || (i2 & 4096) <= 0) {
                z6 = false;
            } else {
                z6 = true;
            }
            this.DdC = z6;
            if ((i2 & 2048) > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.DdB = z7;
            if (this.Ddz) {
                iconPreference.setSummary(R.string.bb6);
            } else if (this.DdA) {
                iconPreference.setSummary(R.string.bb8);
            } else if (this.DdC) {
                iconPreference.setSummary(R.string.bb7);
            } else {
                iconPreference.setSummary(R.string.bb5);
            }
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue();
            int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue();
            Log.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            if (intValue > intValue2) {
                iconPreference.alF(0);
            } else {
                iconPreference.alF(8);
            }
        }
        if (!c.aZU("sns") || (z.aUl() & 32768) != 0) {
            z = false;
        } else {
            z = true;
        }
        this.Ddl = z;
        StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.Ddl).append(", install ").append(c.aZU("sns")).append(", flag ");
        if ((z.aUl() & 32768) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.SettingPrivacy", append.append(z2).toString());
        if (this.Ddl) {
            this.screen.m38do("settings_story_notify", false);
        } else {
            this.screen.m38do("settings_story_notify", true);
        }
        if (this.Ddl && (checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_story_notify")) != null) {
            checkBoxPreference.OZw = false;
            if (storyUserInfo.NeF == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.DdD = z3;
            if (this.DdD) {
                checkBoxPreference.setChecked(true);
            } else {
                checkBoxPreference.setChecked(false);
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74358);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        int i3;
        boolean z;
        int i4 = 2;
        boolean z2 = false;
        boolean z3 = true;
        AppMethodBeat.i(74353);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        getDefaultSharedPreferences();
        if (str.equals("settings_need_verify")) {
            boolean l = l(((CheckBoxPreference) fVar.bmg("settings_need_verify")).isChecked(), 32, 4);
            AppMethodBeat.o(74353);
            return l;
        } else if (str.equals("settings_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            } else {
                z = false;
            }
            boolean l2 = l(z, 256, 7);
            AppMethodBeat.o(74353);
            return l2;
        } else if (str.equals("settings_about_blacklist")) {
            ah Kb = ai.Kb(getString(R.string.dvk));
            Intent intent = new Intent();
            intent.putExtra("filter_type", Kb.getType());
            intent.putExtra("titile", getString(R.string.gt3));
            intent.putExtra("list_attr", 32768);
            com.tencent.mm.plugin.setting.c.jRt.h(this, intent);
            AppMethodBeat.o(74353);
            return true;
        } else {
            if (str.equals("timline_outside_permiss")) {
                Intent intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4L);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                c.b(this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                c.V(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                Intent intent3 = new Intent();
                intent3.putExtra("k_sns_tag_id", 5L);
                intent3.putExtra("k_sns_from_settings_about_sns", 2);
                intent3.putExtra("k_tag_detail_sns_block_scene", 8);
                c.b(this, "sns", ".ui.SnsTagDetailUI", intent3);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.DaT) {
                    z3 = false;
                }
                this.DaT = z3;
                if (o.DCN != null) {
                    o.DCN.cf(this.gna, this.DaT);
                }
                if (o.DCN != null) {
                    ebj cg = o.DCN.cg(this.gna, this.DaT);
                    o.DCN.a(this.gna, cg);
                    if (cg == null) {
                        Log.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        AppMethodBeat.o(74353);
                        return false;
                    }
                    Log.d("MicroMsg.SettingPrivacy", "dancy userinfo " + cg.toString());
                    ((l) g.af(l.class)).aSM().d(new k.a(51, cg));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) fVar.bmg("settings_find_google_contact")).isChecked()) {
                    z2 = true;
                }
                l(z2, 1048576, 29);
                AppMethodBeat.o(74353);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsAddMeUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(74353);
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                eTu();
            } else if (str.equals("settings_unfamiliar_contact")) {
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, UnfamiliarContactUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "gotoUnfamiliarContactUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str.equals("settings_auth_manage")) {
                if (WeChatBrands.Business.Entries.MeSetPrivacyPermissions.checkAvailable(this)) {
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsManageAuthUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else if (str.equals("settings_story_notify")) {
                this.DdD = !this.DdD;
                if (this.DdD) {
                    this.DdE.NeF = 0;
                } else {
                    this.DdE.NeF = 1;
                }
                ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(this.gna, this.DdE);
                ((l) g.af(l.class)).aSM().d(new k.a(71, this.DdE));
                dmp();
                AppMethodBeat.o(74353);
                return true;
            } else if (str.equals("timeline_live_list_show")) {
                boolean isChecked = ((CheckBoxPreference) fVar.bmg("timeline_live_list_show")).isChecked();
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis());
                if (isChecked) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                objArr[1] = Integer.valueOf(i3);
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21529, String.format("%s,%s", objArr));
                Log.i("MicroMsg.SettingPrivacy", "switch ext change : open = " + isChecked + " item value = 17592186044416 functionId = 60");
                if (isChecked) {
                    this.qAb &= -17592186044417L;
                } else {
                    this.qAb |= 17592186044416L;
                }
                if (isChecked) {
                    i4 = 1;
                }
                this.kbt.put(60, Integer.valueOf(i4));
                AppMethodBeat.o(74353);
                return true;
            } else if (str.equals("profile_finder_like_show")) {
                boolean isChecked2 = ((CheckBoxPreference) fVar.bmg("profile_finder_like_show")).isChecked();
                Object[] objArr2 = new Object[1];
                if (isChecked2) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr2[0] = Integer.valueOf(i2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(22136, String.format("%s", objArr2));
                Log.i("MicroMsg.SettingPrivacy", "switch ext change : open = " + isChecked2 + " item value = 1 functionId = 62");
                if (isChecked2) {
                    this.Ddy &= -2;
                } else {
                    this.Ddy |= 1;
                }
                if (isChecked2) {
                    i4 = 1;
                }
                this.kbt.put(62, Integer.valueOf(i4));
                AppMethodBeat.o(74353);
                return true;
            }
            AppMethodBeat.o(74353);
            return false;
        }
    }
}
