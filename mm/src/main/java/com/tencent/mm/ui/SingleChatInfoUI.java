package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.view.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.f.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ag;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.i.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.x;

@i
public class SingleChatInfoUI extends MMPreference implements com.tencent.mm.bh.a {
    private static boolean isDeleteCancel = false;
    private CheckBoxPreference OKW;
    final com.tencent.mm.plugin.appbrand.ac.i<Boolean> OKX = new com.tencent.mm.plugin.appbrand.ac.i<>();
    private com.tencent.mm.plugin.appbrand.ac.i<Boolean> OKY = new com.tencent.mm.plugin.appbrand.ac.i<>();
    private aa.b OKZ = null;
    private MStorage.IOnStorageChange OLa = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(232723);
            SingleChatInfoUI.c(SingleChatInfoUI.this);
            AppMethodBeat.o(232723);
        }
    };
    private as contact;
    private ContactListExpandPreference gtU;
    private CheckBoxPreference gtV;
    private CheckBoxPreference gtX;
    private boolean guh;
    private int guj = -1;
    private boolean gul = false;
    private e gup = new e(new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass1 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    });
    boolean guq = false;
    private String guu = "";
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private f screen;
    private SharedPreferences sp = null;
    private String talker;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SingleChatInfoUI() {
        AppMethodBeat.i(33732);
        AppMethodBeat.o(33732);
    }

    static /* synthetic */ void a(SingleChatInfoUI singleChatInfoUI, ProgressDialog progressDialog) {
        AppMethodBeat.i(258922);
        singleChatInfoUI.b(progressDialog);
        AppMethodBeat.o(258922);
    }

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        AppMethodBeat.i(33746);
        singleChatInfoUI.gJD();
        AppMethodBeat.o(33746);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33733);
        super.onCreate(bundle);
        ((b) g.af(b.class)).dMm().add(this.OLa);
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.gul = getIntent().getBooleanExtra("fromChatting", false);
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.talker);
        if (this.contact == null) {
            Log.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", this.talker);
            finish();
            AppMethodBeat.o(33733);
            return;
        }
        this.guu = getPackageName() + "_preferences";
        initView();
        ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B(this.contact.field_username, 3, cl.aWz() / 1000);
        if (!as.bju(this.talker)) {
            this.screen.m38do("room_add_blacklist", true);
        } else {
            this.screen.m38do("room_search_chatting_content", true);
            this.screen.m38do("room_set_chatting_background", true);
            this.screen.m38do("room_placed_to_the_top", true);
            this.screen.m38do("force_notify", true);
            this.screen.m38do("seperate_line_between_force_notify_and_background", true);
            this.screen.m38do("seperate_line_between_background_and_clear_history", true);
            ((PluginGameLife) g.ah(PluginGameLife.class)).initGameLifeSingleChatInfoUI(getContext(), this.talker, new c.a() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.gamelife.c.a
                public final void U(boolean z, boolean z2) {
                    AppMethodBeat.i(258918);
                    SingleChatInfoUI.this.OKY.value = (T) Boolean.valueOf(z2);
                    SingleChatInfoUI.this.OKX.value = (T) Boolean.valueOf(z);
                    SingleChatInfoUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232720);
                            if (!(SingleChatInfoUI.this.OKY == null || SingleChatInfoUI.this.OKY.value == null)) {
                                SingleChatInfoUI.this.sp.edit().putBoolean("room_add_blacklist", SingleChatInfoUI.this.OKY.value.booleanValue()).commit();
                            }
                            SingleChatInfoUI.this.screen.notifyDataSetChanged();
                            AppMethodBeat.o(232720);
                        }
                    });
                    AppMethodBeat.o(258918);
                }
            });
        }
        if (as.avl(this.talker)) {
            this.OKZ = new aa.b() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass6 */

                /* JADX WARNING: Removed duplicated region for block: B:10:0x004a  */
                @Override // com.tencent.mm.plugin.i.a.aa.b
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void er(java.util.List<com.tencent.mm.protocal.protobuf.azj> r8) {
                    /*
                    // Method dump skipped, instructions count: 134
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass6.er(java.util.List):void");
                }
            };
            LinkedList<azi> linkedList = new LinkedList<>();
            azi azi = new azi();
            String avi = ((aa) g.af(aa.class)).avi(this.talker);
            if (as.bjt(avi)) {
                azi.scene = 2;
            } else {
                azi.scene = 1;
            }
            azi.sessionId = this.talker;
            azi.dJw = avi;
            linkedList.add(azi);
            ((aa) g.af(aa.class)).a(linkedList, this.OKZ);
            this.screen.m38do("room_placed_to_the_top", true);
            String avi2 = ((aa) g.af(aa.class)).avi(this.talker);
            d dVar = d.vdp;
            d.e dnH = d.dnH();
            long j2 = as.bjt(avi2) ? 1 : 2;
            String str = this.talker == null ? "" : this.talker;
            if (avi2 == null) {
                avi2 = "";
            }
            p.h(str, "chatName");
            p.h(avi2, "talkUserName");
            dnH.vdx = j2;
            dnH.vdD = str;
            dnH.vdz = avi2;
            dnH.vdB = String.valueOf(cl.aWA());
        }
        AppMethodBeat.o(33733);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(33734);
        amy();
        if (this.gtU != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.gtU.H(this.talker, linkedList);
            if (as.avl(this.talker)) {
                this.gtU.zU(false);
                this.gtU.zV(false);
            }
            if (as.bju(this.talker)) {
                this.gtU.zU(false);
                this.gtU.zV(false);
            }
            this.gtU.zT(true);
        }
        boolean avl = as.avl(this.talker);
        this.screen.m38do("room_accept_message", !avl);
        if (avl) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("room_accept_message");
            checkBoxPreference.setTitle(R.string.aum);
            checkBoxPreference.setChecked(((m) g.af(m.class)).avc(this.talker));
            checkBoxPreference.OZw = false;
            this.screen.notifyDataSetChanged();
        }
        gJD();
        this.screen.notifyDataSetChanged();
        super.onResume();
        if (!this.guq) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!Util.isNullOrNil(stringExtra)) {
                final int bmj = this.screen.bmj(stringExtra);
                setSelection(bmj - 3);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(232724);
                        View a2 = ((com.tencent.mm.ui.base.preference.a) SingleChatInfoUI.this.screen).a(bmj, SingleChatInfoUI.this.getListView());
                        if (a2 != null) {
                            com.tencent.mm.ui.i.a.c(SingleChatInfoUI.this.getContext(), a2);
                        }
                        AppMethodBeat.o(232724);
                    }
                }, 10);
            }
            this.guq = true;
        }
        AppMethodBeat.o(33734);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(33735);
        super.onPause();
        AppMethodBeat.o(33735);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        bbn bbn;
        AppMethodBeat.i(33736);
        ((b) g.af(b.class)).dMm().remove(this.OLa);
        com.tencent.mm.ui.i.a.dismiss();
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.b(this);
        }
        super.onDestroy();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        if (FinderReporterUIC.a.fH(getContext()) != null) {
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC.a.fH(getContext()).gv(0, 0);
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            bbn = FinderReporterUIC.a.fH(getContext()).dIx();
        } else {
            bbn = null;
        }
        d dVar = d.vdp;
        d.e dnH = d.dnH();
        bi biVar = new bi();
        if (bbn != null) {
            String str = bbn.sessionId;
            if (str == null) {
                str = "";
            }
            biVar.jh(str);
            String str2 = bbn.sGE;
            if (str2 == null) {
                str2 = "";
            }
            biVar.ji(str2);
        }
        String str3 = biVar.els;
        if (str3 == null) {
            str3 = "";
        }
        biVar.jh(str3);
        String str4 = biVar.esd;
        if (str4 == null) {
            str4 = "";
        }
        biVar.ji(str4);
        biVar.esf = biVar.x("chatSessionid", dnH.vdB, true);
        biVar.esb = dnH.vdx;
        biVar.esh = biVar.x("chatName", dnH.vdD, true);
        biVar.esc = biVar.x("talkerUsername", dnH.vdz, true);
        biVar.esu = dnH.vdN;
        biVar.esl = dnH.vdH;
        biVar.esv = dnH.vdM;
        biVar.esw = dnH.vdL;
        biVar.bfK();
        d dVar2 = d.vdp;
        d.a(dnH.TAG, biVar);
        dnH.vdx = 0;
        dnH.vdD = "";
        dnH.vdz = "";
        dnH.vdH = 0;
        dnH.vdL = 0;
        dnH.vdM = 0;
        dnH.vdN = 0;
        AppMethodBeat.o(33736);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(33737);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(33737);
            return;
        }
        switch (i2) {
            case 2:
                if (i3 == -1) {
                    finish();
                    AppMethodBeat.o(33737);
                    return;
                }
                AppMethodBeat.o(33737);
                return;
            default:
                AppMethodBeat.o(33737);
                return;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean bkg;
        AppMethodBeat.i(33738);
        if (this.contact == null) {
            Log.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
            finish();
        }
        this.screen = getPreferenceScreen();
        setMMTitle(getString(R.string.g_b));
        this.gtU = (ContactListExpandPreference) this.screen.bmg("roominfo_contact_anchor");
        this.gtU.a(this.screen, this.gtU.mKey);
        this.gtU.zU(true).zV(false);
        if (this.contact != null && this.contact.field_deleteFlag == 1) {
            this.gtU.zU(false);
        }
        if (!u.gVd() && this.contact != null && as.bjp(this.contact.field_username)) {
            this.gtU.zU(false);
        }
        this.gtV = (CheckBoxPreference) this.screen.bmg("room_notify_new_msg");
        this.gtX = (CheckBoxPreference) this.screen.bmg("room_placed_to_the_top");
        this.screen.m38do("force_notify", !com.tencent.mm.contact.c.oR(this.contact.field_type));
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.contact != null) {
            if (as.avl(this.talker)) {
                bkg = ((n) g.af(n.class)).avg(this.talker);
            } else {
                bg.aVF();
                bkg = com.tencent.mm.model.c.aST().bkg(this.contact.field_username);
            }
            this.sp.edit().putBoolean("room_placed_to_the_top", bkg).commit();
            this.guh = this.contact.Zx();
            this.sp.edit().putBoolean("room_notify_new_msg", this.guh).commit();
        } else {
            this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
            this.guh = false;
        }
        if (as.avl(this.talker)) {
            this.screen.m38do("room_search_chatting_content", true);
            this.screen.m38do("force_notify", true);
        }
        bg.aVF();
        this.guj = com.tencent.mm.model.c.aSQ().aEN(this.talker);
        this.screen.notifyDataSetChanged();
        if (this.gtU != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.gtU.H(this.talker, linkedList);
            getListView().setOnScrollListener(this.gup);
            this.gtU.a(this.gup);
            this.gtU.a(new ContactListExpandPreference.a() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass9 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void og(int i2) {
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void e(ViewGroup viewGroup, int i2) {
                    AppMethodBeat.i(232725);
                    String aio = SingleChatInfoUI.this.gtU.aio(i2);
                    String nullAsNil = Util.nullAsNil(SingleChatInfoUI.this.gtU.aiq(i2));
                    if (Util.isNullOrNil(nullAsNil)) {
                        bg.aVF();
                        cn aEZ = com.tencent.mm.model.c.aSO().aEZ(aio);
                        if (aEZ != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
                            nullAsNil = aEZ.field_conRemark;
                        }
                    }
                    if (Util.isNullOrNil(aio)) {
                        AppMethodBeat.o(232725);
                    } else if (as.avl(SingleChatInfoUI.this.talker)) {
                        d dVar = d.vdp;
                        d.e dnH = d.dnH();
                        dnH.vdH++;
                        Log.i(dnH.TAG, "incChatInfoClickCount:" + dnH.vdH);
                        String avi = ((aa) g.af(aa.class)).avi(SingleChatInfoUI.this.talker);
                        if (as.bjt(avi)) {
                            Intent intent = new Intent();
                            intent.putExtra("finder_username", avi);
                            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                            FinderReporterUIC.a.a(viewGroup.getContext(), intent, 0, 10, false);
                            ((aj) g.ah(aj.class)).enterFinderProfileUI(viewGroup.getContext(), intent);
                            AppMethodBeat.o(232725);
                            return;
                        }
                        Intent intent2 = new Intent();
                        ah ava = ((m) g.af(m.class)).ava(avi);
                        n.a aVar2 = com.tencent.mm.plugin.finder.view.n.wpY;
                        n.a.a(ava, intent2);
                        intent2.putExtra("IsPoster", true);
                        n.a aVar3 = com.tencent.mm.plugin.finder.view.n.wpY;
                        n.a.a(viewGroup.getContext(), intent2, (kotlin.g.a.b<? super String, x>) null);
                        AppMethodBeat.o(232725);
                    } else if (as.bju(SingleChatInfoUI.this.talker)) {
                        ((PluginGameLife) g.ah(PluginGameLife.class)).enterGameLifeProfileUI(SingleChatInfoUI.this.getContext(), SingleChatInfoUI.this.talker, com.tencent.mm.plugin.gamelife.a.xZX);
                        AppMethodBeat.o(232725);
                    } else {
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", aio);
                        intent3.putExtra("Contact_RemarkName", nullAsNil);
                        intent3.putExtra("Contact_Nick", Util.nullAsNil(SingleChatInfoUI.this.gtU.aip(i2)));
                        intent3.putExtra("Contact_RoomMember", true);
                        intent3.putExtra("CONTACT_INFO_UI_SOURCE", 9);
                        as Kn = ((l) g.af(l.class)).aSN().Kn(aio);
                        if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            com.tencent.mm.ui.contact.e.a(intent3, aio);
                        }
                        intent3.putExtra("Kdel_from", 0);
                        com.tencent.mm.br.c.b(SingleChatInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent3, 0);
                        AppMethodBeat.o(232725);
                    }
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void amF() {
                    AppMethodBeat.i(232726);
                    if (SingleChatInfoUI.this.gtU != null) {
                        SingleChatInfoUI.this.gtU.gpE();
                    }
                    AppMethodBeat.o(232726);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void oh(int i2) {
                    AppMethodBeat.i(232727);
                    SingleChatInfoUI.f(SingleChatInfoUI.this);
                    AppMethodBeat.o(232727);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(232728);
                SingleChatInfoUI.this.finish();
                AppMethodBeat.o(232728);
                return true;
            }
        });
        AppMethodBeat.o(33738);
    }

    private void gJD() {
        AppMethodBeat.i(33739);
        this.OKW = (CheckBoxPreference) this.screen.bmg("force_notify");
        if (as.bjp(this.contact.field_username) || z.Im(this.contact.field_username)) {
            this.screen.m38do("force_notify", true);
            AppMethodBeat.o(33739);
            return;
        }
        long axB = ((b) g.af(b.class)).axB(this.contact.field_username);
        boolean byf = ((b) g.af(b.class)).byf(this.contact.field_username);
        this.OKW.setChecked(byf);
        this.OKW.xZ(byf);
        if (this.OKW.isChecked()) {
            this.OKW.setSummary(getResources().getString(R.string.dh7, new SimpleDateFormat("HH:mm").format(new Date(axB))));
        } else {
            this.OKW.setSummary((CharSequence) null);
            setTitleMuteIconVisibility(this.contact.Zx() ? 0 : 8);
        }
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.sp.edit().putBoolean("force_notify", this.OKW.isChecked()).commit();
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(33739);
    }

    /* access modifiers changed from: package-private */
    public static class a implements DialogInterface.OnCancelListener {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(33731);
            boolean unused = SingleChatInfoUI.isDeleteCancel = true;
            AppMethodBeat.o(33731);
        }
    }

    private void b(final ProgressDialog progressDialog) {
        AppMethodBeat.i(33741);
        bp.a(this.contact.field_username, new bp.a() {
            /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass2 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(258914);
                boolean z = SingleChatInfoUI.isDeleteCancel;
                AppMethodBeat.o(258914);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(258915);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(258915);
            }
        });
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(258917);
                com.tencent.mm.modelmulti.p.bdS().tE(7);
                AppMethodBeat.o(258917);
            }
        });
        AppMethodBeat.o(33741);
    }

    private void amy() {
        AppMethodBeat.i(33742);
        if (as.avl(this.talker) || as.bju(this.talker)) {
            this.screen.m38do(this.gtV.mKey, true);
            AppMethodBeat.o(33742);
            return;
        }
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.guh = this.contact.Zx();
        if (this.guh) {
            setTitleMuteIconVisibility(0);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(33742);
    }

    @Override // com.tencent.mm.bh.a
    public final void h(String str, String str2, String str3) {
        AppMethodBeat.i(33743);
        if (str.equals(this.talker) && this.gtU != null) {
            this.gtU.notifyChanged();
        }
        AppMethodBeat.o(33743);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(33744);
        com.tencent.mm.ui.base.preference.a aVar = new com.tencent.mm.ui.base.preference.a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(33744);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        long j2 = 1;
        boolean z = true;
        AppMethodBeat.i(33740);
        String str = preference.mKey;
        if (str.equals("room_notify_new_msg")) {
            if (this.guh) {
                z = false;
            }
            this.guh = z;
            if (this.guh) {
                ab.z(this.contact);
            } else {
                ab.A(this.contact);
            }
            this.contact = ((l) g.af(l.class)).aSN().Kn(this.talker);
            if (this.sp == null) {
                this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.sp.edit().putBoolean("room_notify_new_msg", this.guh).commit();
            amy();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.guu, 0);
            if (this.contact != null) {
                if (as.avl(this.talker)) {
                    com.tencent.mm.plugin.i.a.n nVar = (com.tencent.mm.plugin.i.a.n) g.af(com.tencent.mm.plugin.i.a.n.class);
                    String str2 = this.contact.field_username;
                    if (((com.tencent.mm.plugin.i.a.n) g.af(com.tencent.mm.plugin.i.a.n.class)).avg(this.talker)) {
                        z = false;
                    }
                    nVar.bt(str2, z);
                } else {
                    bg.aVF();
                    if (com.tencent.mm.model.c.aST().bkg(this.contact.field_username)) {
                        ab.F(this.contact.field_username, true);
                    } else {
                        ab.E(this.contact.field_username, true);
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    bg.aVF();
                    edit.putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.aST().bkg(this.contact.field_username)).commit();
                }
            }
        } else if (str.equals("force_notify")) {
            if (!this.OKW.isChecked()) {
                ((b) g.af(b.class)).aS(this.contact.field_username + "@wxcontact", 3);
                this.OKW.setSummary((CharSequence) null);
            } else {
                com.tencent.mm.plugin.forcenotify.f.a aVar = com.tencent.mm.plugin.forcenotify.f.a.UWN;
                com.tencent.mm.plugin.forcenotify.f.a.a(getContext(), 1, new a.AbstractC1365a() {
                    /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass11 */

                    @Override // com.tencent.mm.plugin.forcenotify.f.a.AbstractC1365a
                    public final void dQ(boolean z) {
                        AppMethodBeat.i(258921);
                        if (z) {
                            ((b) g.af(b.class)).axA(SingleChatInfoUI.this.contact.field_username);
                            long axB = ((b) g.af(b.class)).axB(SingleChatInfoUI.this.contact.field_username);
                            SingleChatInfoUI.this.OKW.setSummary(SingleChatInfoUI.this.getResources().getString(R.string.dh7, new SimpleDateFormat("HH:mm").format(new Date(axB))));
                            AppMethodBeat.o(258921);
                            return;
                        }
                        SingleChatInfoUI.this.OKW.xZ(false);
                        AppMethodBeat.o(258921);
                    }
                });
            }
        } else if (str.equals("room_set_chatting_background")) {
            Intent intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra(ch.COL_USERNAME, this.contact.field_username);
            com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 2);
        } else if (str.equals("room_search_chatting_content")) {
            Intent intent2 = new Intent();
            intent2.putExtra("detail_username", this.talker);
            com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", intent2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 1, 0, 0, 0, 0, 0, 0, 0, 0);
        } else if (str.equals("room_clear_chatting_history")) {
            d dVar = d.vdp;
            d.e dnH = d.dnH();
            dnH.vdM++;
            Log.i(dnH.TAG, "incClearHistoryCount:" + dnH.vdM);
            com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.deh, new Object[]{this.contact.arJ()}), "", getString(R.string.t2), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(258916);
                    SingleChatInfoUI.j(SingleChatInfoUI.this);
                    AppMethodBeat.o(258916);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        } else if (str.equals("room_expose")) {
            d dVar2 = d.vdp;
            d.e dnH2 = d.dnH();
            dnH2.vdL++;
            Log.i(dnH2.TAG, "incCompanionCount:" + dnH2.vdL);
            Intent intent3 = new Intent();
            intent3.putExtra("showShare", false);
            if (as.bju(this.talker)) {
                ((PluginGameLife) g.ah(PluginGameLife.class)).enterExpose(getContext(), intent3, this.talker);
            } else {
                if (as.avl(this.talker)) {
                    intent3.putExtra("rawUrl", String.format(e.C2115e.OyU, 61));
                } else {
                    intent3.putExtra("rawUrl", String.format(e.C2115e.OyU, 39));
                }
                intent3.putExtra("k_username", this.talker);
                com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent3);
            }
        } else if (str.equals("chat_app_brand")) {
            Intent intent4 = new Intent();
            intent4.putExtra("Chat_User", this.talker);
            com.tencent.mm.br.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent4);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 25, 1, true);
        } else if (str.equals("room_accept_message")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("room_accept_message");
            if (checkBoxPreference != null) {
                String avi = ((aa) g.af(aa.class)).avi(this.talker);
                boolean isChecked = checkBoxPreference.isChecked();
                if (as.bjt(avi)) {
                    ((q) g.af(q.class)).v(isChecked, this.talker);
                } else {
                    ((ag) g.af(ag.class)).w(isChecked, this.talker);
                }
                d dVar3 = d.vdp;
                d.e dnH3 = d.dnH();
                if (!isChecked) {
                    j2 = 0;
                }
                dnH3.vdN = j2;
            }
        } else if (str.equals("room_add_blacklist") && as.bju(this.talker)) {
            ((c) g.ah(c.class)).dealBlackList(getContext(), this.talker, this.OKY, this.OKX, new c.b() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass14 */

                @Override // com.tencent.mm.plugin.gamelife.c.b
                public final void mM(final boolean z) {
                    AppMethodBeat.i(258920);
                    SingleChatInfoUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass14.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(258919);
                            SingleChatInfoUI.this.OKY.value = (T) Boolean.valueOf(z);
                            SingleChatInfoUI.this.sp.edit().putBoolean("room_add_blacklist", z).commit();
                            SingleChatInfoUI.this.screen.notifyDataSetChanged();
                            AppMethodBeat.o(258919);
                        }
                    });
                    AppMethodBeat.o(258920);
                }
            });
        }
        AppMethodBeat.o(33740);
        return false;
    }

    static /* synthetic */ void a(SingleChatInfoUI singleChatInfoUI, boolean z) {
        AppMethodBeat.i(232732);
        boolean avl = as.avl(singleChatInfoUI.talker);
        singleChatInfoUI.screen.m38do("room_accept_message", !avl);
        if (avl) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) singleChatInfoUI.screen.bmg("room_accept_message");
            checkBoxPreference.setTitle(R.string.aum);
            checkBoxPreference.setChecked(z);
            checkBoxPreference.OZw = false;
            singleChatInfoUI.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(232732);
    }

    static /* synthetic */ void f(SingleChatInfoUI singleChatInfoUI) {
        AppMethodBeat.i(232733);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10170, "1");
        LinkedList linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(z.aTY());
        String listToString = Util.listToString(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.string.g2));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", u.PWU);
        intent.putExtra("always_select_contact", listToString);
        intent.putExtra("menu_mode", 2);
        intent.putExtra("scene", 2);
        intent.putExtra("create_group_recommend", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(singleChatInfoUI, bl.axQ(), "com/tencent/mm/ui/SingleChatInfoUI", "launchGroupChat", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        singleChatInfoUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(singleChatInfoUI, "com/tencent/mm/ui/SingleChatInfoUI", "launchGroupChat", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(232733);
    }

    static /* synthetic */ void j(SingleChatInfoUI singleChatInfoUI) {
        String str;
        AppMethodBeat.i(258923);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 6, 2, singleChatInfoUI.talker);
        isDeleteCancel = false;
        singleChatInfoUI.getString(R.string.zb);
        final ProgressDialog a2 = com.tencent.mm.ui.base.h.a((Context) singleChatInfoUI, singleChatInfoUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new a((byte) 0));
        if (!isDeleteCancel) {
            str = com.tencent.mm.pluginsdk.wallet.d.bfO(singleChatInfoUI.contact.field_username);
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            a2.dismiss();
            com.tencent.mm.ui.base.h.a(singleChatInfoUI, false, singleChatInfoUI.getString(R.string.iba, new Object[]{str}), null, singleChatInfoUI.getString(R.string.dvh), singleChatInfoUI.getString(R.string.b5r), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(232729);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 6, 4, SingleChatInfoUI.this.talker);
                    boolean unused = SingleChatInfoUI.isDeleteCancel = true;
                    if (!SingleChatInfoUI.this.gul) {
                        LauncherUI instance = LauncherUI.getInstance();
                        if (instance != null) {
                            instance.startChatting(SingleChatInfoUI.this.contact.field_username, null, true);
                        }
                        AppMethodBeat.o(232729);
                        return;
                    }
                    SingleChatInfoUI.this.finish();
                    AppMethodBeat.o(232729);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.SingleChatInfoUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(33730);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 6, 3, SingleChatInfoUI.this.talker);
                    a2.show();
                    boolean unused = SingleChatInfoUI.isDeleteCancel = false;
                    SingleChatInfoUI.a(SingleChatInfoUI.this, a2);
                    AppMethodBeat.o(33730);
                }
            }, -1, R.color.cd);
            AppMethodBeat.o(258923);
            return;
        }
        singleChatInfoUI.b(a2);
        AppMethodBeat.o(258923);
    }
}
