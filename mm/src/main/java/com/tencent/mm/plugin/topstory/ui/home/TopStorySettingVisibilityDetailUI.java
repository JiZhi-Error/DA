package com.tencent.mm.plugin.topstory.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
public class TopStorySettingVisibilityDetailUI extends MMPreference implements i {
    protected long DJc;
    protected String EJW = "";
    protected ContactListExpandPreference.a EJY = new ContactListExpandPreference.a() {
        /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass6 */

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void og(int i2) {
            AppMethodBeat.i(125998);
            String aio = TopStorySettingVisibilityDetailUI.this.gtU.aio(i2);
            Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + i2 + " userName : " + aio);
            g.aAi();
            if (Util.nullAs((String) g.aAh().azQ().get(2, (Object) null), "").equals(aio)) {
                h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(R.string.g76), "", true);
                AppMethodBeat.o(125998);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.DM(aio);
            if (!(TopStorySettingVisibilityDetailUI.this.EJW + " " + Util.listToString(TopStorySettingVisibilityDetailUI.this.qLQ, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5) || TopStorySettingVisibilityDetailUI.this.DJc == 0) {
                TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.o(125998);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.o(125998);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void oh(int i2) {
            AppMethodBeat.i(125999);
            Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(i2)));
            TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
            AppMethodBeat.o(125999);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void e(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(236388);
            String aio = TopStorySettingVisibilityDetailUI.this.gtU.aio(i2);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", aio);
            c.b(TopStorySettingVisibilityDetailUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(236388);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void amF() {
            AppMethodBeat.i(126001);
            if (TopStorySettingVisibilityDetailUI.this.gtU != null) {
                TopStorySettingVisibilityDetailUI.this.gtU.gpE();
            }
            AppMethodBeat.o(126001);
        }
    };
    protected Preference Gln;
    protected Preference Glo;
    protected List<String> Glp = new ArrayList();
    protected List<String> Glq = new ArrayList();
    private Set<com.tencent.mm.plugin.topstory.a.c.i> Glr = new HashSet();
    protected ContactListExpandPreference gtU;
    protected String md5 = "";
    protected List<String> qLQ = new ArrayList();
    protected f screen;
    protected q tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStorySettingVisibilityDetailUI() {
        AppMethodBeat.i(126003);
        AppMethodBeat.o(126003);
    }

    static /* synthetic */ void a(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.i(126017);
        topStorySettingVisibilityDetailUI.fyt();
        AppMethodBeat.o(126017);
    }

    static /* synthetic */ boolean b(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.i(126018);
        boolean fys = topStorySettingVisibilityDetailUI.fys();
        AppMethodBeat.o(126018);
        return fys;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d7;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(126004);
        if ("revert_pref".equals(preference.mKey)) {
            h.c(this, getString(R.string.hqe), "", getString(R.string.hqk), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125993);
                    for (String str : TopStorySettingVisibilityDetailUI.this.Glq) {
                        TopStorySettingVisibilityDetailUI.this.qLQ.remove(str);
                    }
                    if (TopStorySettingVisibilityDetailUI.this.gtU != null) {
                        TopStorySettingVisibilityDetailUI.this.gtU.fm(TopStorySettingVisibilityDetailUI.this.qLQ);
                        TopStorySettingVisibilityDetailUI.this.gtU.notifyChanged();
                    }
                    TopStorySettingVisibilityDetailUI.this.Glq.clear();
                    TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
                    TopStorySettingVisibilityDetailUI.this.updateTitle();
                    AppMethodBeat.o(125993);
                }
            }, null);
        }
        AppMethodBeat.o(126004);
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126005);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("k_topstory_user_list");
        if (!Util.isNullOrNil(stringExtra)) {
            this.Glp = Arrays.asList(stringExtra.split(","));
            for (String str : this.Glp) {
                if (!Util.isNullOrNil(str)) {
                    this.qLQ.add(str);
                }
            }
        }
        initView();
        this.DJc = (long) getIntent().getIntExtra("k_topstory_type", 0);
        if (this.DJc == 1) {
            this.EJW = getString(R.string.hqn);
            this.Gln.setTitle(R.string.hqo);
        } else {
            this.EJW = getString(R.string.hqc);
            this.Gln.setTitle(R.string.hqd);
        }
        g.azz().a(2859, this);
        enableOptionMenu(false);
        updateTitle();
        this.md5 = this.EJW + " " + Util.listToString(this.qLQ, ",");
        AppMethodBeat.o(126005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(126006);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.azz().b(2859, this);
        super.onDestroy();
        AppMethodBeat.o(126006);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(126007);
        this.screen = getPreferenceScreen();
        this.gtU = (ContactListExpandPreference) this.screen.bmg("roominfo_contact_anchor");
        if (this.gtU != null) {
            this.gtU.a(this.screen, this.gtU.mKey);
            this.gtU.zU(true).zV(true);
            this.gtU.H(null, this.qLQ);
            this.gtU.a(new s.b() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass5 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.s.b
                public final boolean oi(int i2) {
                    AppMethodBeat.i(125997);
                    if (!TopStorySettingVisibilityDetailUI.this.gtU.ail(i2)) {
                        Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(i2)));
                    }
                    AppMethodBeat.o(125997);
                    return true;
                }
            });
            this.gtU.a(this.EJY);
        }
        this.Gln = this.screen.bmg("desc");
        this.Glo = this.screen.bmg("revert_pref");
        this.screen.m38do("revert_pref", true);
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125994);
                TopStorySettingVisibilityDetailUI.b(TopStorySettingVisibilityDetailUI.this);
                AppMethodBeat.o(125994);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125995);
                TopStorySettingVisibilityDetailUI.this.edF();
                AppMethodBeat.o(125995);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(126007);
    }

    private boolean fys() {
        AppMethodBeat.i(126008);
        if ((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) {
            finish();
            AppMethodBeat.o(126008);
            return true;
        }
        int i2 = R.string.hqe;
        if (this.tipDialog != null) {
            i2 = R.string.hqg;
        }
        h.c(this, getString(i2), "", getString(R.string.hqk), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(125996);
                TopStorySettingVisibilityDetailUI.this.finish();
                AppMethodBeat.o(125996);
            }
        }, null);
        AppMethodBeat.o(126008);
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(126009);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            fys();
            AppMethodBeat.o(126009);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(126009);
        return dispatchKeyEvent;
    }

    /* access modifiers changed from: protected */
    public final void updateTitle() {
        AppMethodBeat.i(126010);
        setMMTitle(this.EJW + "(" + this.qLQ.size() + ")");
        AppMethodBeat.o(126010);
    }

    @SuppressLint({"StringFormatMatches"})
    private void fyt() {
        AppMethodBeat.i(126011);
        if (this.Glq.isEmpty()) {
            this.screen.m38do("revert_pref", true);
            AppMethodBeat.o(126011);
            return;
        }
        this.screen.m38do("revert_pref", false);
        this.Glo.setTitle(getString(R.string.hqh, new Object[]{Integer.valueOf(this.Glq.size())}));
        AppMethodBeat.o(126011);
    }

    /* access modifiers changed from: protected */
    public final void DM(String str) {
        AppMethodBeat.i(126012);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
        if (str == null || str.equals("")) {
            AppMethodBeat.o(126012);
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
        this.Glq.clear();
        fyt();
        updateTitle();
        AppMethodBeat.o(126012);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(126013);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(126013);
            return;
        }
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(126013);
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Contact");
                Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", stringExtra);
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
                if (z) {
                    h.c(this, getString(R.string.di), "", true);
                    AppMethodBeat.o(126013);
                    return;
                }
                ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
                if (stringsToList == null) {
                    AppMethodBeat.o(126013);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("App_MsgId");
                if (Util.isNullOrNil(stringExtra2) || !stringExtra2.equals("fromSns")) {
                    r(stringsToList, true);
                } else {
                    r(stringsToList, false);
                }
                if (!(this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) || this.DJc == 0) {
                    enableOptionMenu(true);
                    AppMethodBeat.o(126013);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.o(126013);
                return;
            default:
                AppMethodBeat.o(126013);
                return;
        }
    }

    private void r(List<String> list, boolean z) {
        AppMethodBeat.i(126014);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", objArr);
        g.aAi();
        bv aSN = ((l) g.af(l.class)).aSN();
        String aTY = z.aTY();
        for (String str : list) {
            if (!this.qLQ.contains(str) && !aTY.equals(str)) {
                if (com.tencent.mm.contact.c.oR(aSN.Kn(str).field_type) || !z) {
                    this.qLQ.add(str);
                    this.Glq.add(str);
                }
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
        fyt();
        updateTitle();
        AppMethodBeat.o(126014);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        int i4;
        AppMethodBeat.i(126016);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar instanceof com.tencent.mm.plugin.topstory.a.c.i) {
            com.tencent.mm.plugin.topstory.a.c.i iVar = (com.tencent.mm.plugin.topstory.a.c.i) qVar;
            boolean z2 = i2 == 0 && i3 == 0;
            if (!z2 || (i4 = ((abu) iVar.rr.iLL.iLR).BaseResponse.Ret) == 0) {
                z = z2;
            } else {
                Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", Integer.valueOf(i4));
                z = false;
            }
            Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", Boolean.valueOf(z));
            if (!z) {
                iVar.jgF++;
                if (iVar.jgF < 2) {
                    com.tencent.mm.plugin.topstory.a.c.i iVar2 = new com.tencent.mm.plugin.topstory.a.c.i(iVar);
                    g.aAg().hqi.a(iVar2, 0);
                    this.Glr.add(iVar2);
                }
            }
            if (this.Glr.contains(qVar)) {
                this.Glr.remove(qVar);
                Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", Integer.valueOf(this.Glr.size()));
                if (this.Glr.isEmpty()) {
                    if (this.tipDialog != null) {
                        this.tipDialog.dismiss();
                        this.tipDialog = null;
                    }
                    finish();
                }
            }
        }
        AppMethodBeat.o(126016);
    }

    /* access modifiers changed from: protected */
    public final void edF() {
        boolean z;
        AppMethodBeat.i(126015);
        if (g.aAe().azG().aBb()) {
            int aYS = g.azz().aYS();
            z = aYS == 4 || aYS == 6;
        } else {
            z = NetStatusUtil.isConnected(MMApplicationContext.getContext()) ? true : false;
        }
        if (!z) {
            u.makeText(this, (int) R.string.hqj, 0).show();
            AppMethodBeat.o(126015);
        } else if (!(this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) || this.DJc == 0) {
            if (this.DJc == 1) {
                com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd.clear();
                com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd.addAll(this.qLQ);
                com.tencent.mm.plugin.topstory.a.b.a.fxV().fxX();
            } else {
                com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN.clear();
                com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN.addAll(this.qLQ);
                com.tencent.mm.plugin.topstory.a.b.a.fxV().fxW();
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.qLQ) {
                if (!this.Glp.contains(str)) {
                    arrayList.add(str);
                    if (this.DJc == 1) {
                        arrayList2.add(3);
                    } else {
                        arrayList2.add(1);
                    }
                }
            }
            for (String str2 : this.Glp) {
                if (!this.qLQ.contains(str2)) {
                    arrayList.add(str2);
                    if (this.DJc == 1) {
                        arrayList2.add(4);
                    } else {
                        arrayList2.add(2);
                    }
                }
            }
            getString(R.string.zb);
            this.tipDialog = h.a((Context) this, getString(R.string.hqm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(126002);
                    for (com.tencent.mm.plugin.topstory.a.c.i iVar : TopStorySettingVisibilityDetailUI.this.Glr) {
                        g.aAg().hqi.a(iVar);
                    }
                    AppMethodBeat.o(126002);
                }
            });
            this.Glr.clear();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                arrayList3.clear();
                arrayList4.clear();
                int i3 = 0;
                while (i2 < arrayList.size() && i3 < 50) {
                    arrayList3.add(arrayList.get(i2));
                    arrayList4.add(arrayList2.get(i2));
                    i2++;
                    i3++;
                }
                this.Glr.add(new com.tencent.mm.plugin.topstory.a.c.i(arrayList3, arrayList4));
            }
            Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", Integer.valueOf(this.Glr.size()));
            for (com.tencent.mm.plugin.topstory.a.c.i iVar : this.Glr) {
                g.aAg().hqi.a(iVar, 0);
            }
            AppMethodBeat.o(126015);
        } else {
            finish();
            AppMethodBeat.o(126015);
        }
    }

    static /* synthetic */ void c(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        int i2 = 2;
        AppMethodBeat.i(126019);
        String listToString = Util.listToString(topStorySettingVisibilityDetailUI.qLQ, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", topStorySettingVisibilityDetailUI.getString(R.string.g4));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.u.ll(com.tencent.mm.ui.contact.u.Q(com.tencent.mm.ui.contact.u.Q(com.tencent.mm.ui.contact.u.PWT, 1024), 524288), TPMediaCodecProfileLevel.HEVCMainTierLevel62));
        intent.putExtra("always_select_contact", listToString);
        if (topStorySettingVisibilityDetailUI.DJc == 1) {
            i2 = 1;
        }
        intent.putExtra("topstory_import_type", i2);
        c.c(topStorySettingVisibilityDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(126019);
    }
}
