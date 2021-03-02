package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements i, MStorageEx.IOnStorageChange {
    protected long DJc;
    protected String EJW = "";
    private boolean EJX = false;
    protected ContactListExpandPreference.a EJY = new ContactListExpandPreference.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass9 */

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void og(int i2) {
            AppMethodBeat.i(99176);
            String aio = SnsTagDetailUI.this.gtU.aio(i2);
            Log.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i2 + " userName : " + aio);
            g.aAi();
            if (Util.nullAs((String) g.aAh().azQ().get(2, (Object) null), "").equals(aio)) {
                h.n(SnsTagDetailUI.this.getContext(), R.string.g76, R.string.zb);
                AppMethodBeat.o(99176);
                return;
            }
            SnsTagDetailUI.this.DM(aio);
            if (!(SnsTagDetailUI.this.EJW + " " + Util.listToString(SnsTagDetailUI.this.qLQ, ",")).equals(SnsTagDetailUI.this.md5) || SnsTagDetailUI.this.DJc == 0) {
                SnsTagDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.o(99176);
                return;
            }
            SnsTagDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.o(99176);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void oh(int i2) {
            AppMethodBeat.i(99177);
            Log.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(i2)));
            SnsTagDetailUI.a(SnsTagDetailUI.this);
            AppMethodBeat.o(99177);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void e(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(203657);
            String aio = SnsTagDetailUI.this.gtU.aio(i2);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", aio);
            if (SnsTagDetailUI.this.DJc == 4) {
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
            } else if (SnsTagDetailUI.this.DJc == 5) {
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
            }
            a.jRt.c(intent, SnsTagDetailUI.this);
            AppMethodBeat.o(203657);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void amF() {
            AppMethodBeat.i(99179);
            if (SnsTagDetailUI.this.gtU != null) {
                SnsTagDetailUI.this.gtU.gpE();
            }
            AppMethodBeat.o(99179);
        }
    };
    protected PreferenceTitleCategory Vba;
    protected PreferenceTitleCategory Vbb;
    protected ContactListExpandPreference gtU;
    protected String md5 = "";
    protected List<String> qLQ = new ArrayList();
    protected int scene = 0;
    protected f screen;
    protected q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagDetailUI() {
        AppMethodBeat.i(99180);
        AppMethodBeat.o(99180);
    }

    /* access modifiers changed from: protected */
    public void fhH() {
        AppMethodBeat.i(99181);
        Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(291, this);
        g.aAi();
        g.aAg().hqi.a(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.audio.h.CTRL_INDEX, this);
        g.aAi();
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this);
        if (aj.faU().ffg().size() == 0) {
            g.aAi();
            g.aAg().hqi.a(new w(1), 0);
            this.EJX = true;
        }
        AppMethodBeat.o(99181);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99182);
        super.onCreate(bundle);
        fhH();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.DJc = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.DJc == 4) {
            this.EJW = getString(R.string.hak);
        } else if (this.DJc == 5) {
            this.EJW = getString(R.string.haw);
        } else {
            this.EJW = aj.faU().JL(this.DJc).field_tagName;
        }
        if (this.DJc == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.EJW = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
            bv faC = aj.faC();
            String aTY = z.aTY();
            ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            if (stringsToList != null) {
                for (String str : stringsToList) {
                    if (!this.qLQ.contains(str) && c.oR(faC.Kn(str).field_type) && !aTY.equals(str)) {
                        this.qLQ.add(str);
                    }
                }
            }
        } else {
            this.qLQ = fhL();
        }
        if (this.EJW == null || this.EJW.equals("")) {
            this.EJW = getString(R.string.haj);
            this.EJW = an.aPl(getString(R.string.haj));
        }
        initView();
        fiL();
        updateTitle();
        if (this.DJc < 6) {
            this.screen.bmi("delete_tag_name");
            this.screen.bmi("delete_tag_name_category");
            if (this.DJc > 0) {
                this.screen.bmi("settings_tag_name");
                this.screen.bmi("settings_tag_name_category");
            }
        }
        if (this.DJc == 4) {
            this.screen.bmi("black");
            this.screen.bmi("group");
        } else if (this.DJc == 5) {
            this.screen.bmi("outside");
            this.screen.bmi("group");
        } else {
            this.screen.bmi("black");
            this.screen.bmi("outside");
        }
        if (this.DJc == 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.md5 = this.EJW + " " + Util.listToString(this.qLQ, ",");
        AppMethodBeat.o(99182);
    }

    /* access modifiers changed from: protected */
    public void fhI() {
        AppMethodBeat.i(99183);
        Log.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(291, this);
        g.aAi();
        g.aAg().hqi.b(l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.h.CTRL_INDEX, this);
        g.aAi();
        if (g.aAf().azp()) {
            g.aAi();
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
        }
        AppMethodBeat.o(99183);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99184);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        fhI();
        super.onDestroy();
        AppMethodBeat.o(99184);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d5;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(99185);
        super.onResume();
        fiL();
        AppMethodBeat.o(99185);
    }

    /* access modifiers changed from: protected */
    public final void updateTitle() {
        AppMethodBeat.i(99187);
        setMMTitle(this.EJW + "(" + this.qLQ.size() + ")");
        AppMethodBeat.o(99187);
    }

    private void fiL() {
        AppMethodBeat.i(99188);
        Preference bmg = this.screen.bmg("settings_tag_name");
        if (bmg != null) {
            if (this.EJW.length() > 20) {
                this.EJW = this.EJW.substring(0, 20);
            }
            bmg.setSummary(this.EJW);
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(99188);
    }

    /* access modifiers changed from: protected */
    public void fhJ() {
        AppMethodBeat.i(99189);
        if (this.DJc != 0) {
            g.aAi();
            g.aAg().hqi.a(new y(this.DJc, this.EJW), 0);
        }
        getString(R.string.zb);
        this.tipDialog = h.a((Context) this, getString(R.string.has), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(99189);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(99190);
        this.screen = getPreferenceScreen();
        this.gtU = (ContactListExpandPreference) this.screen.bmg("roominfo_contact_anchor");
        if (this.gtU != null) {
            this.gtU.a(this.screen, this.gtU.mKey);
            this.gtU.zU(true).zV(true);
            this.gtU.H(null, this.qLQ);
            this.gtU.a(new s.b() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.s.b
                public final boolean oi(int i2) {
                    AppMethodBeat.i(99170);
                    if (!SnsTagDetailUI.this.gtU.ail(i2)) {
                        Log.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(i2)));
                    }
                    AppMethodBeat.o(99170);
                    return true;
                }
            });
            this.gtU.a(this.EJY);
        }
        if (p.fvC()) {
            this.Vba = (PreferenceTitleCategory) this.screen.bmg("outside");
            if (this.Vba != null) {
                this.Vba.setTitle(R.string.jdy);
            }
            this.Vbb = (PreferenceTitleCategory) this.screen.bmg("black");
            if (this.Vbb != null) {
                this.Vbb.setTitle(R.string.jdx);
            }
        }
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99172);
                if (!(SnsTagDetailUI.this.EJW + " " + Util.listToString(SnsTagDetailUI.this.qLQ, ",")).equals(SnsTagDetailUI.this.md5) || SnsTagDetailUI.this.DJc == 0) {
                    h.a(SnsTagDetailUI.this, (int) R.string.ha5, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(99171);
                            SnsTagDetailUI.this.finish();
                            AppMethodBeat.o(99171);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(99172);
                } else {
                    SnsTagDetailUI.this.finish();
                    AppMethodBeat.o(99172);
                }
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99173);
                SnsTagDetailUI.this.edF();
                AppMethodBeat.o(99173);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(99190);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(99191);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            if (!(this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) || this.DJc == 0) {
                h.a(this, (int) R.string.ha5, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(99174);
                        SnsTagDetailUI.this.finish();
                        AppMethodBeat.o(99174);
                    }
                }, (DialogInterface.OnClickListener) null);
            } else {
                finish();
            }
            AppMethodBeat.o(99191);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(99191);
        return dispatchKeyEvent;
    }

    /* access modifiers changed from: protected */
    public void edF() {
        AppMethodBeat.i(99192);
        if ((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) && this.DJc != 0) {
            finish();
            AppMethodBeat.o(99192);
        } else if (aj.faU().K(this.DJc, this.EJW)) {
            h.c(this, getString(R.string.ha_, new Object[]{this.EJW}), getString(R.string.zb), true);
            AppMethodBeat.o(99192);
        } else {
            final x xVar = new x(3, this.DJc, this.EJW, this.qLQ.size(), this.qLQ, this.scene);
            g.aAi();
            g.aAg().hqi.a(xVar, 0);
            getString(R.string.zb);
            this.tipDialog = h.a((Context) this, getString(R.string.has), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(99175);
                    g.aAi();
                    g.aAg().hqi.a(xVar);
                    AppMethodBeat.o(99175);
                }
            });
            AppMethodBeat.o(99192);
        }
    }

    /* access modifiers changed from: protected */
    public List<String> fhL() {
        AppMethodBeat.i(99193);
        List<String> linkedList = new LinkedList<>();
        com.tencent.mm.plugin.sns.storage.s JL = aj.faU().JL(this.DJc);
        if (JL.field_memberList != null && !JL.field_memberList.equals("")) {
            linkedList = Util.stringsToList(JL.field_memberList.split(","));
        }
        AppMethodBeat.o(99193);
        return linkedList;
    }

    /* access modifiers changed from: protected */
    public void DM(String str) {
        AppMethodBeat.i(99194);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(99194);
            return;
        }
        this.qLQ.remove(str);
        if (this.gtU != null) {
            this.gtU.fm(this.qLQ);
            this.gtU.notifyChanged();
        }
        if (this.qLQ.size() == 0 && this.gtU != null) {
            this.gtU.gpE();
            this.gtU.zU(true).zV(false);
            this.screen.notifyDataSetChanged();
        } else if (this.gtU != null) {
            this.gtU.zU(true).zV(true);
        }
        updateTitle();
        AppMethodBeat.o(99194);
    }

    /* access modifiers changed from: protected */
    public void hc(List<String> list) {
        AppMethodBeat.i(99195);
        bv faC = aj.faC();
        String aTY = z.aTY();
        for (String str : list) {
            if (!this.qLQ.contains(str) && c.oR(faC.Kn(str).field_type) && !aTY.equals(str)) {
                this.qLQ.add(str);
            }
        }
        if (this.gtU != null) {
            this.gtU.fm(this.qLQ);
            this.gtU.notifyChanged();
        }
        if (this.qLQ.size() > 0) {
            this.gtU.zU(true).zV(true);
        } else {
            this.gtU.zU(true).zV(false);
        }
        updateTitle();
        AppMethodBeat.o(99195);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(99196);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(99196);
            return;
        }
        switch (i2) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (Util.nullAsNil(z.aTY()).equals(stringExtra)) {
                        z = true;
                    } else if (this.qLQ == null) {
                        z = false;
                    } else {
                        z = false;
                        for (String str : this.qLQ) {
                            z = str.equals(stringExtra) ? true : z;
                        }
                    }
                    if (!z) {
                        ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
                        if (stringsToList != null) {
                            hc(stringsToList);
                            break;
                        } else {
                            AppMethodBeat.o(99196);
                            return;
                        }
                    } else {
                        h.c(this, getString(R.string.di, new Object[]{0, 0}), getString(R.string.zb), true);
                        AppMethodBeat.o(99196);
                        return;
                    }
                } else {
                    AppMethodBeat.o(99196);
                    return;
                }
            case 2:
                String stringExtra2 = intent.getStringExtra("k_sns_tag_name");
                if (stringExtra2 != null) {
                    this.EJW = stringExtra2;
                }
                updateTitle();
                Log.d("MicroMsg.SnsTagDetailUI", "updateName " + this.EJW);
                break;
            default:
                AppMethodBeat.o(99196);
                return;
        }
        if (!(this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) || this.DJc == 0) {
            enableOptionMenu(true);
            AppMethodBeat.o(99196);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(99197);
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (qVar.getType()) {
            case com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX:
                finish();
                AppMethodBeat.o(99197);
                return;
            case 291:
                finish();
                AppMethodBeat.o(99197);
                return;
            case l.CTRL_INDEX:
                if (this.gtU != null && this.EJX && !(this instanceof SnsBlackDetailUI)) {
                    Log.d("MicroMsg.SnsTagDetailUI", "update form net");
                    w wVar = (w) qVar;
                    ArrayList arrayList = new ArrayList();
                    if (!Util.isNullOrNil(wVar.Jp(this.DJc))) {
                        for (int i4 = 0; i4 < wVar.Jp(this.DJc).size(); i4++) {
                            String str2 = wVar.Jp(this.DJc).get(i4);
                            if (str2 != null) {
                                arrayList.add(str2);
                            }
                        }
                    }
                    this.md5 = this.EJW + " " + Util.listToString(arrayList, ",");
                    new LinkedList();
                    List<String> list = this.qLQ;
                    this.qLQ = fhL();
                    if (list != null) {
                        for (String str3 : list) {
                            if (!this.qLQ.contains(str3)) {
                                this.qLQ.add(str3);
                            }
                        }
                    }
                    this.gtU.fm(this.qLQ);
                    this.gtU.notifyChanged();
                    break;
                }
        }
        AppMethodBeat.o(99197);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(99186);
        String str = preference.mKey;
        if (str.equals("settings_tag_name") && (this.DJc >= 6 || this.DJc == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", Util.nullAs(this.EJW, " "));
            a.jRt.a(intent, (Activity) this);
        }
        if (str.equals("delete_tag_name")) {
            h.a(this, (int) R.string.gl4, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(99169);
                    SnsTagDetailUI.this.fhJ();
                    AppMethodBeat.o(99169);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(99186);
        return false;
    }

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        AppMethodBeat.i(99198);
        String listToString = Util.listToString(snsTagDetailUI.qLQ, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(R.string.g4));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        intent.putExtra("list_attr", u.ll(u.Q(u.PWT, 1024), TPMediaCodecProfileLevel.HEVCMainTierLevel62));
        intent.putExtra("always_select_contact", listToString);
        com.tencent.mm.br.c.c(snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(99198);
    }
}
