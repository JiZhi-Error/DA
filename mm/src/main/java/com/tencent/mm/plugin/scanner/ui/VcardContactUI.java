package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.webkit.URLUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> COQ = new ArrayList<>();
    private static int COS = 1;
    private static int COT = 1;
    private al COP;
    private h COR;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(52013);
        AppMethodBeat.o(52013);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(52006);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(52006);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        al alVar;
        AppMethodBeat.i(52008);
        this.COR = new h(this);
        this.screen = getPreferenceScreen();
        this.COP = al.CHN;
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.VcardContactUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(52004);
                VcardContactUI.this.finish();
                AppMethodBeat.o(52004);
                return true;
            }
        });
        setMMTitle("");
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.d9);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.screen.bmg("v_contact_info_header");
        if (!(vcardContactUserHeaderPreference == null || (alVar = this.COP) == null)) {
            if (!Util.isNullOrNil(alVar.CHw.bGg())) {
                vcardContactUserHeaderPreference.fullName = alVar.CHw.bGg();
            }
            if (!Util.isNullOrNil(alVar.nickName)) {
                vcardContactUserHeaderPreference.nickName = alVar.nickName;
            }
            if (!Util.isNullOrNil(alVar.CHK)) {
                vcardContactUserHeaderPreference.CHK = alVar.CHK;
            }
            if (!Util.isNullOrNil(alVar.title)) {
                vcardContactUserHeaderPreference.title = alVar.title;
            }
        }
        this.screen.bmi("c_contact_info_wx_id");
        if (!Util.isNullOrNil(this.COP.lRD)) {
            VcardContactLinkPreference vcardContactLinkPreference = (VcardContactLinkPreference) this.screen.bmg("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.COP.lRD);
                vcardContactLinkPreference.BC(false);
                vcardContactLinkPreference.OYB = false;
                COS += 2;
                COT += 2;
            }
        } else {
            this.screen.bmi("v_contact_info_photo_uri");
            this.screen.bmi("v_category_photo_uri");
        }
        al.a aVar = this.COP.CHD;
        if (aVar != null && aVar.bGg().length() > 0) {
            jQ(aVar.bGg(), getContext().getString(R.string.hup));
        }
        al.a aVar2 = this.COP.CHE;
        if (aVar2 != null && aVar2.bGg().length() > 0) {
            jQ(aVar2.bGg(), getContext().getString(R.string.hv2));
        }
        al.a aVar3 = this.COP.CHB;
        if (aVar3 != null && aVar3.bGg().length() > 0) {
            jQ(aVar3.bGg(), getContext().getString(R.string.huk));
        }
        al.a aVar4 = this.COP.CHC;
        if (aVar4 != null && aVar4.bGg().length() > 0) {
            jQ(aVar4.bGg(), getContext().getString(R.string.huk));
        }
        List<String> list = this.COP.CHH;
        if (list != null && list.size() > 0) {
            g(list, "WorkTel", getContext().getString(R.string.hv3));
        }
        List<String> list2 = this.COP.CHG;
        if (list2 != null && list2.size() > 0) {
            g(list2, "HomeTel", getContext().getString(R.string.hur));
        }
        List<String> list3 = this.COP.CHI;
        if (list3 != null && list3.size() > 0) {
            g(list3, "VideoTEL", getContext().getString(R.string.hv0));
        }
        List<String> list4 = this.COP.CHJ;
        if (list4 != null && list4.size() > 0) {
            g(list4, "NormalTel", getContext().getString(R.string.huu));
        }
        List<String> list5 = this.COP.CHF;
        if (list5 != null && list5.size() > 0) {
            g(list5, "CellTel", getContext().getString(R.string.hun));
        }
        if (!Util.isNullOrNil(this.COP.lRL)) {
            KeyValuePreference keyValuePreference = (KeyValuePreference) this.screen.bmg("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.COP.lRL);
                keyValuePreference.BC(false);
                keyValuePreference.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_org");
        }
        if (!Util.isNullOrNil(this.COP.CHL)) {
            KeyValuePreference keyValuePreference2 = (KeyValuePreference) this.screen.bmg("v_contact_info_agent");
            if (keyValuePreference2 != null) {
                keyValuePreference2.setSummary(this.COP.CHL);
                keyValuePreference2.BC(false);
                keyValuePreference2.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_agent");
        }
        if (!Util.isNullOrNil(this.COP.url)) {
            VcardContactLinkPreference vcardContactLinkPreference2 = (VcardContactLinkPreference) this.screen.bmg("v_contact_info_home_page");
            if (vcardContactLinkPreference2 != null) {
                vcardContactLinkPreference2.setSummary(this.COP.url);
                vcardContactLinkPreference2.BC(false);
                vcardContactLinkPreference2.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_home_page");
            this.screen.bmi("v_category_home_page");
        }
        if (!Util.isNullOrNil(this.COP.fuD)) {
            VcardContactLinkPreference vcardContactLinkPreference3 = (VcardContactLinkPreference) this.screen.bmg("v_contact_info_email");
            if (vcardContactLinkPreference3 != null) {
                vcardContactLinkPreference3.setSummary(this.COP.fuD);
                vcardContactLinkPreference3.BC(false);
                vcardContactLinkPreference3.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_email");
        }
        if (!Util.isNullOrNil(this.COP.CHA)) {
            KeyValuePreference keyValuePreference3 = (KeyValuePreference) this.screen.bmg("v_contact_info_birthday");
            if (keyValuePreference3 != null) {
                keyValuePreference3.setSummary(this.COP.CHA);
                keyValuePreference3.BC(false);
                keyValuePreference3.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_birthday");
            this.screen.bmi("v_category_birthday");
        }
        if (!Util.isNullOrNil(this.COP.CHM)) {
            KeyValuePreference keyValuePreference4 = (KeyValuePreference) this.screen.bmg("v_contact_info_remark");
            if (keyValuePreference4 != null) {
                keyValuePreference4.setSummary(this.COP.CHM);
                keyValuePreference4.BC(false);
                keyValuePreference4.OYB = true;
            }
        } else {
            this.screen.bmi("v_contact_info_remark");
            this.screen.bmi("v_category_remark");
        }
        if (this.COP.CHy == null || !this.COP.CHy.igV.contains(ShareConstants.MEDIA_URI)) {
            this.screen.bmi("v_contact_info_logo");
            this.screen.bmi("v_category_logo");
            AppMethodBeat.o(52008);
            return;
        }
        VcardContactLinkPreference vcardContactLinkPreference4 = (VcardContactLinkPreference) this.screen.bmg("v_contact_info_logo");
        vcardContactLinkPreference4.setSummary(this.COP.CHy.CHQ);
        vcardContactLinkPreference4.OYB = false;
        vcardContactLinkPreference4.BC(false);
        AppMethodBeat.o(52008);
    }

    private void g(List<String> list, String str, String str2) {
        AppMethodBeat.i(52009);
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                VcardContactLinkPreference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!COQ.contains(str + String.valueOf(str3))) {
                    COQ.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle(str2);
                vcardContactLinkPreference.setLayoutResource(R.layout.b8j);
                vcardContactLinkPreference.setSummary(str3);
                vcardContactLinkPreference.BC(false);
                vcardContactLinkPreference.OYB = true;
                vcardContactLinkPreference.gLK();
                this.screen.a(vcardContactLinkPreference, COS);
            }
        }
        AppMethodBeat.o(52009);
    }

    private void jQ(String str, String str2) {
        AppMethodBeat.i(52010);
        KeyValuePreference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle(str2);
        keyValuePreference.setLayoutResource(R.layout.b8j);
        keyValuePreference.BC(false);
        keyValuePreference.setSummary(str);
        keyValuePreference.OYB = false;
        keyValuePreference.gLK();
        this.screen.a(keyValuePreference, COT);
        AppMethodBeat.o(52010);
    }

    private static void a(List<String> list, Intent intent, int i2, int i3) {
        AppMethodBeat.i(52011);
        for (String str : list) {
            if (i3 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i2);
            } else if (i3 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i2);
            } else if (i3 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i2);
            }
        }
        AppMethodBeat.o(52011);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(52007);
        if (preference.mKey.equals("add_vcard_contact")) {
            h.a(this, "", new String[]{getString(R.string.huj), getString(R.string.hui)}, "", new h.d() {
                /* class com.tencent.mm.plugin.scanner.ui.VcardContactUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(52005);
                    switch (i2) {
                        case 0:
                            cf.aWl().f(10238, 1);
                            Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI vcardContactUI = VcardContactUI.this;
                            a bl = new a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            vcardContactUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(52005);
                            return;
                        case 1:
                            cf.aWl().f(10239, 1);
                            Intent intent2 = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
                            intent2.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(VcardContactUI.this, intent2);
                            VcardContactUI vcardContactUI2 = VcardContactUI.this;
                            a bl2 = new a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI2, bl2.axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            vcardContactUI2.startActivity((Intent) bl2.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI2, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            break;
                    }
                    AppMethodBeat.o(52005);
                }
            });
            AppMethodBeat.o(52007);
            return true;
        }
        if (preference.mKey.equals("v_contact_info_photo_uri") || preference.mKey.equals("v_contact_info_home_page") || preference.mKey.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0 && URLUtil.isNetworkUrl(charSequence)) {
                h hVar = this.COR;
                if (!hVar.BiQ.stopped()) {
                    Log.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    Log.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    hVar.url = charSequence;
                    String str = (String) g.aAh().azQ().get(46, (Object) null);
                    if (str == null || str.length() == 0) {
                        hVar.b(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        g.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, hVar);
                        hVar.CPb = new l(charSequence, (String) null, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                        g.azz().a(hVar.CPb, 0);
                        hVar.BiQ.startTimer(3000);
                    }
                }
                AppMethodBeat.o(52007);
                return true;
            }
        } else if (COQ.contains(preference.mKey) && !preference.mKey.toLowerCase().contains("fax")) {
            final String trim = preference.getSummary().toString().trim();
            if (trim != null && trim.length() > 0) {
                h.a(this, "", new String[]{getString(R.string.baf)}, "", new h.d() {
                    /* class com.tencent.mm.plugin.scanner.ui.VcardContactUI.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(52002);
                        switch (i2) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse(WebView.SCHEME_TEL + trim));
                                VcardContactUI vcardContactUI = VcardContactUI.this;
                                a bl = new a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                vcardContactUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                break;
                        }
                        AppMethodBeat.o(52002);
                    }
                });
                AppMethodBeat.o(52007);
                return true;
            }
        } else if (preference.mKey.equals("v_contact_info_email")) {
            final String charSequence2 = preference.getSummary().toString();
            h.a(this, "", new String[]{getContext().getString(R.string.gjy), getContext().getString(R.string.gjx)}, "", new h.d() {
                /* class com.tencent.mm.plugin.scanner.ui.VcardContactUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(52003);
                    switch (i2) {
                        case 0:
                            Intent intent = new Intent();
                            String[] strArr = {charSequence2 + " " + charSequence2};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            c.b(VcardContactUI.this, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.o(52003);
                            return;
                        case 1:
                            Intent intent2 = new Intent("android.intent.action.SEND");
                            intent2.setType("text/plain");
                            intent2.putExtra("android.intent.extra.EMAIL", new String[]{charSequence2});
                            VcardContactUI vcardContactUI = VcardContactUI.this;
                            a bl = new a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$2", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            vcardContactUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(vcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$2", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            break;
                    }
                    AppMethodBeat.o(52003);
                }
            });
        }
        AppMethodBeat.o(52007);
        return false;
    }

    static /* synthetic */ void a(VcardContactUI vcardContactUI, Intent intent) {
        al.a aVar;
        int i2 = 2;
        AppMethodBeat.i(52012);
        intent.setFlags(268435456);
        String bGg = vcardContactUI.COP.CHw.bGg();
        if (!Util.isNullOrNil(bGg)) {
            intent.putExtra("name", bGg);
        } else {
            Log.e("MicroMsg.scanner.VardContactUI", "no contact user name");
        }
        List<String> list = vcardContactUI.COP.CHF;
        if (list == null || list.size() <= 0) {
            i2 = 1;
        } else {
            a(list, intent, 2, 1);
        }
        List<String> list2 = vcardContactUI.COP.CHG;
        if (list2 != null && list2.size() > 0) {
            a(list2, intent, 1, i2);
            i2++;
        }
        List<String> list3 = vcardContactUI.COP.CHH;
        if (list3 != null && list3.size() > 0) {
            a(list3, intent, 3, i2);
            i2++;
        }
        List<String> list4 = vcardContactUI.COP.CHJ;
        if (list4 != null && list4.size() > 0) {
            a(list4, intent, 7, i2);
            i2++;
        }
        List<String> list5 = vcardContactUI.COP.CHI;
        if (list5 != null && list5.size() > 0) {
            a(list5, intent, 0, i2);
        }
        if (!Util.isNullOrNil(vcardContactUI.COP.lRL)) {
            intent.putExtra("company", vcardContactUI.COP.lRL);
        }
        if (!Util.isNullOrNil(vcardContactUI.COP.CHM)) {
            intent.putExtra("notes", vcardContactUI.COP.CHM);
        }
        if (!Util.isNullOrNil(vcardContactUI.COP.fuD)) {
            intent.putExtra(Scopes.EMAIL, vcardContactUI.COP.fuD);
        }
        if (!Util.isNullOrNil(vcardContactUI.COP.title)) {
            intent.putExtra("job_title", vcardContactUI.COP.title);
        }
        al alVar = vcardContactUI.COP;
        if (alVar.CHC != null && alVar.CHC.bGg().length() > 0) {
            aVar = alVar.CHC;
        } else if (alVar.CHD != null && alVar.CHD.bGg().length() > 0) {
            aVar = alVar.CHD;
        } else if (alVar.CHE != null && alVar.CHE.bGg().length() > 0) {
            aVar = alVar.CHE;
        } else if (alVar.CHB == null || alVar.CHB.bGg().length() <= 0) {
            aVar = null;
        } else {
            aVar = alVar.CHB;
        }
        if (aVar != null && aVar.bGg().length() > 0) {
            intent.putExtra("postal", aVar.bGg());
        }
        AppMethodBeat.o(52012);
    }
}
