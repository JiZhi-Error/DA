package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;

@i
public class ContactInfoUI extends MMPreference implements com.tencent.mm.ak.i, f.a, n.a, g, e, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    private boolean BdA = false;
    String BdB = null;
    private String BdC = "";
    private PullDownListView BdD = null;
    private boolean BdE = false;
    private AbsStoryGallery BdF = null;
    private AbsStoryMuteView BdG = null;
    private boolean BdH = false;
    private boolean BdI = false;
    private boolean BdJ = false;
    private boolean BdK = false;
    private int BdL = 0;
    private com.tencent.mm.plugin.textstatus.a.b BdM = null;
    private View.OnClickListener BdN = null;
    private PullDownListView.IPullDownCallback BdO = new PullDownListView.IPullDownCallback() {
        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass1 */

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostOpen(boolean z) {
            AppMethodBeat.i(26960);
            if (ContactInfoUI.this.BdF != null) {
                Log.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
                ContactInfoUI.this.BdF.ar(z, true);
                ContactInfoUI.this.hideTitleView();
                ContactInfoUI.b(ContactInfoUI.this);
            }
            AppMethodBeat.o(26960);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostClose() {
            AppMethodBeat.i(26961);
            if (ContactInfoUI.this.BdF != null) {
                Log.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
                ContactInfoUI.this.BdF.vI(true);
                ContactInfoUI.this.showTitleView();
                ContactInfoUI.c(ContactInfoUI.this);
            }
            AppMethodBeat.o(26961);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEk() {
            AppMethodBeat.i(26962);
            if (ContactInfoUI.this.BdF != null) {
                ContactInfoUI.this.BdF.fmO();
            }
            AppMethodBeat.o(26962);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEl() {
            AppMethodBeat.i(26963);
            if (ContactInfoUI.this.BdF != null) {
                ContactInfoUI.this.BdF.fmP();
            }
            AppMethodBeat.o(26963);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEm() {
            AppMethodBeat.i(26964);
            Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
            ContactInfoUI.this.BdG.fmV();
            AppMethodBeat.o(26964);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEn() {
            AppMethodBeat.i(26965);
            ContactInfoUI.this.BdG.fmW();
            AppMethodBeat.o(26965);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UC(int i2) {
            AppMethodBeat.i(26966);
            if (ContactInfoUI.this.BdF != null) {
                ContactInfoUI.this.BdF.aaB(i2);
            }
            AppMethodBeat.o(26966);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UD(int i2) {
            AppMethodBeat.i(26967);
            if (ContactInfoUI.this.BdF != null) {
                ContactInfoUI.this.BdF.aaC(i2);
            }
            AppMethodBeat.o(26967);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UE(int i2) {
        }
    };
    private PullDownListView.IPullDownCallback BdP = new PullDownListView.IPullDownCallback() {
        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass6 */

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostOpen(boolean z) {
            NormalProfileHeaderPreference normalProfileHeaderPreference;
            d eEI;
            AppMethodBeat.i(231834);
            if (ContactInfoUI.this.BdM != null) {
                ContactInfoUI.this.BdM.onPostOpen(z);
            }
            if (!(ContactInfoUI.this.screen == null || (normalProfileHeaderPreference = (NormalProfileHeaderPreference) ContactInfoUI.this.screen.bmg("contact_profile_header_normal")) == null || (eEI = normalProfileHeaderPreference.eEI()) == null)) {
                eEI.onPostOpen(z);
            }
            AppMethodBeat.o(231834);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostClose() {
            NormalProfileHeaderPreference normalProfileHeaderPreference;
            d eEI;
            AppMethodBeat.i(231835);
            if (ContactInfoUI.this.BdM != null) {
                ContactInfoUI.this.BdM.onPostClose();
            }
            if (!(ContactInfoUI.this.screen == null || (normalProfileHeaderPreference = (NormalProfileHeaderPreference) ContactInfoUI.this.screen.bmg("contact_profile_header_normal")) == null || (eEI = normalProfileHeaderPreference.eEI()) == null)) {
                eEI.onPostClose();
            }
            AppMethodBeat.o(231835);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEk() {
            NormalProfileHeaderPreference normalProfileHeaderPreference;
            d eEI;
            AppMethodBeat.i(231836);
            if (ContactInfoUI.this.BdM != null) {
                ContactInfoUI.this.BdM.eEk();
                if (!(ContactInfoUI.this.screen == null || (normalProfileHeaderPreference = (NormalProfileHeaderPreference) ContactInfoUI.this.screen.bmg("contact_profile_header_normal")) == null || (eEI = normalProfileHeaderPreference.eEI()) == null)) {
                    eEI.eEk();
                }
            }
            AppMethodBeat.o(231836);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEl() {
            NormalProfileHeaderPreference normalProfileHeaderPreference;
            d eEI;
            AppMethodBeat.i(231837);
            if (ContactInfoUI.this.BdM != null) {
                ContactInfoUI.this.BdM.eEl();
                if (!(ContactInfoUI.this.screen == null || (normalProfileHeaderPreference = (NormalProfileHeaderPreference) ContactInfoUI.this.screen.bmg("contact_profile_header_normal")) == null || (eEI = normalProfileHeaderPreference.eEI()) == null)) {
                    eEI.eEl();
                }
            }
            AppMethodBeat.o(231837);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEm() {
            AppMethodBeat.i(231838);
            Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
            if (ContactInfoUI.this.BdG != null) {
                ContactInfoUI.this.BdG.fmV();
            }
            AppMethodBeat.o(231838);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEn() {
            AppMethodBeat.i(231839);
            if (ContactInfoUI.this.BdG != null) {
                ContactInfoUI.this.BdG.fmW();
            }
            AppMethodBeat.o(231839);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UC(int i2) {
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UD(int i2) {
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UE(int i2) {
        }
    };
    private View BdQ;
    private View BdR;
    private c.a BdS;
    private boolean BdT = false;
    private ContactWidgetTabBizInfo BdU = null;
    private com.tencent.mm.pluginsdk.b.a Bdv;
    private NormalProfileHeaderPreference Bdw;
    private boolean Bdx;
    private boolean Bdy;
    private byte[] Bdz;
    private as contact;
    private boolean iqo = false;
    private int kgm;
    private com.tencent.mm.pluginsdk.ui.span.i ptq = new com.tencent.mm.pluginsdk.ui.span.i() {
        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass7 */

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object a(u uVar) {
            AppMethodBeat.i(231840);
            switch (uVar.type) {
                case 1:
                case 25:
                case 30:
                case 31:
                    if (ContactInfoUI.this.contact != null) {
                        String str = ContactInfoUI.this.contact.field_username;
                        AppMethodBeat.o(231840);
                        return str;
                    }
                    AppMethodBeat.o(231840);
                    return null;
                default:
                    AppMethodBeat.o(231840);
                    return null;
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object b(u uVar) {
            AppMethodBeat.i(231841);
            if (uVar.type == 45) {
                String str = new String(Base64.decode(uVar.url, 0));
                String str2 = new String(Base64.decode(Util.nullAs((String) uVar.ba(String.class), ""), 0));
                Log.d("MicroMsg.ContactInfoUI", "appId:%s,path:%s", str, str2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1082;
                if (ContactInfoUI.this.contact != null) {
                    appBrandStatObject.dCw = ContactInfoUI.this.contact.field_username + "|2";
                }
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(ContactInfoUI.this.getContext(), (String) null, str, 0, 0, str2, appBrandStatObject);
            }
            AppMethodBeat.o(231841);
            return null;
        }
    };
    private String roomId = "";
    private com.tencent.mm.ui.base.preference.f screen;
    private long viC = 0;
    private String wZz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactInfoUI() {
        AppMethodBeat.i(26982);
        AppMethodBeat.o(26982);
    }

    static /* synthetic */ void c(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(27010);
        contactInfoUI.eEh();
        AppMethodBeat.o(27010);
    }

    static /* synthetic */ void p(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(231851);
        contactInfoUI.eEi();
        AppMethodBeat.o(231851);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEb() {
        AppMethodBeat.i(26983);
        Log.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
        this.BdH = false;
        if (this.BdD != null && !this.BdD.isVisible) {
            showTitleView();
            eEh();
            this.BdD.hbX();
        }
        eEj();
        AppMethodBeat.o(26983);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEc() {
        AppMethodBeat.i(26984);
        Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
        this.BdH = true;
        if (this.BdD != null && this.BdD.isVisible) {
            eEj();
        }
        AppMethodBeat.o(26984);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEd() {
        AppMethodBeat.i(26985);
        Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
        this.BdD.hbX();
        AppMethodBeat.o(26985);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.e
    public final void eEe() {
        AppMethodBeat.i(231848);
        Log.i("MicroMsg.ContactInfoUI", "statusUINoStatus");
        this.BdI = false;
        if (this.BdD != null && !this.BdD.isVisible) {
            showTitleView();
            eEh();
            this.BdD.hbX();
        }
        eEj();
        AppMethodBeat.o(231848);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.e
    public final void eEf() {
        AppMethodBeat.i(231849);
        Log.i("MicroMsg.ContactInfoUI", "statusUIHasStatus");
        this.BdI = true;
        if (this.BdD != null && this.BdD.isVisible) {
            eEj();
        }
        AppMethodBeat.o(231849);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ao;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ee  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.ContactInfoUI.onCreate(android.os.Bundle):void");
    }

    private void eEg() {
        AppMethodBeat.i(26987);
        if (this.BdQ == null || !com.tencent.mm.ui.statusbar.c.Qow) {
            AppMethodBeat.o(26987);
            return;
        }
        com.tencent.mm.ui.statusbar.c bt = com.tencent.mm.ui.statusbar.c.bt(this);
        AnonymousClass8 r1 = new c.a() {
            /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.statusbar.c.a
            public final void yf(int i2) {
                AppMethodBeat.i(231842);
                if (ContactInfoUI.this.BdH || ContactInfoUI.this.BdI) {
                    ContactInfoUI.this.BdQ.setPadding(0, i2, 0, 0);
                }
                AppMethodBeat.o(231842);
            }
        };
        this.BdS = r1;
        bt.a(r1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.e(getWindow());
        AppMethodBeat.o(26987);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(26988);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.iqo = false;
        } else if (configuration.orientation == 2) {
            this.iqo = true;
        }
        if (this.BdD != null && !this.BdD.isVisible) {
            this.BdD.hbX();
        }
        eEj();
        AppMethodBeat.o(26988);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26989);
        h hVar = h.FuH;
        h.fqi().eRK = 0;
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            bg.aVF();
            com.tencent.mm.model.c.aSN().remove(this);
            bg.aVF();
            com.tencent.mm.model.c.aSO().b(this);
            bg.aVF();
            com.tencent.mm.model.c.aSP().b(this);
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.Bdv == null);
        Log.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", objArr);
        if (this.Bdv != null) {
            this.Bdv.cCs();
        }
        if (this.Bdv instanceof com.tencent.mm.pluginsdk.b.b) {
            ((com.tencent.mm.pluginsdk.b.b) this.Bdv).axa();
        }
        if (o.DCM != null) {
            o.DCM.aI(this);
        }
        super.onDestroy();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(273, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(291, this);
        if (this.BdF != null) {
            this.BdF.onDestroy();
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 18, 1, this.contact.field_username);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17283, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), this.contact.field_username, Boolean.valueOf(this.BdH), Boolean.valueOf(this.BdK), Integer.valueOf(this.contact.uin), Integer.valueOf(this.BdL));
        if (this.BdM != null) {
            this.BdM.fvv();
        }
        AppMethodBeat.o(26989);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(26990);
        com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
        ag.bah().add(this);
        super.onResume();
        View focusedChild = ((ViewGroup) getContentView()).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            Log.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", Integer.valueOf(focusedChild.getId()));
        }
        this.BdD = (PullDownListView) getListView();
        if (this.BdF != null) {
            this.BdF.onResume();
        }
        if (this.screen != null) {
            this.Bdw = (NormalProfileHeaderPreference) this.screen.bmg("contact_profile_header_normal");
            if (this.Bdw != null) {
                this.Bdw.b(this.BdH, this.BdR.getHeight(), this.BdI);
            }
        }
        if ((this.Bdv instanceof c) || (this.Bdv instanceof ContactWidgetTabBizInfo)) {
            this.Bdv.a(this.screen, this.contact, this.Bdx, this.kgm);
        }
        l.a(this.ptq);
        if (this.BdM != null) {
            this.BdM.fvw();
        }
        AppMethodBeat.o(26990);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(26991);
        super.onStart();
        if (this.BdF != null) {
            this.BdF.onStart();
        }
        AppMethodBeat.o(26991);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        AppMethodBeat.i(26992);
        super.onRestart();
        this.BdT = false;
        AppMethodBeat.o(26992);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26993);
        com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
        ag.bah().remove(this);
        super.onPause();
        bg.aAk().postAtFrontOfQueueToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(231843);
                bg.aVF();
                com.tencent.mm.model.c.azQ().gBI();
                AppMethodBeat.o(231843);
            }
        });
        if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false)) {
            com.tencent.mm.plugin.newtips.a.exl();
            com.tencent.mm.plugin.newtips.a.i.aw(com.tencent.mm.plugin.newtips.a.d.ADd, getActivityBrowseTimeMs());
        } else if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false)) {
            com.tencent.mm.plugin.newtips.a.exl();
            com.tencent.mm.plugin.newtips.a.i.aw(com.tencent.mm.plugin.newtips.a.d.ADb, getActivityBrowseTimeMs());
        }
        eEh();
        if (this.BdF != null) {
            this.BdF.onPause();
        }
        if ((this.Bdv instanceof c) || (this.Bdv instanceof ContactWidgetTabBizInfo)) {
            this.Bdv.cCs();
        }
        l.b(this.ptq);
        if (this.BdM != null) {
            this.BdM.fvx();
        }
        AppMethodBeat.o(26993);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(26994);
        super.onStop();
        if (this.BdF != null) {
            this.BdF.onStop();
        }
        AppMethodBeat.o(26994);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public String getIdentString() {
        AppMethodBeat.i(26995);
        if (this.contact == null || ((int) this.contact.gMZ) == 0 || Util.isNullOrNil(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "";
        }
        Log.i("MicroMsg.ContactInfoUI", "getIdentityString %s", this.contact.field_username);
        if (com.tencent.mm.al.g.DQ(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_EnterpriseChat";
        } else if (com.tencent.mm.al.g.Ng(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_EnterpriseFatherBiz";
        } else if (com.tencent.mm.al.g.Nf(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_EnterpriseChildBiz";
        } else if (this.contact.gBM()) {
            AppMethodBeat.o(26995);
            return "_bizContact";
        } else if (ab.Eq(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_chatroom";
        } else if (ab.IG(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_bottle";
        } else if (ab.IH(this.contact.field_username)) {
            AppMethodBeat.o(26995);
            return "_QQ";
        } else if (ab.JE(this.contact.field_username)) {
            String str = "_" + this.contact.field_username;
            AppMethodBeat.o(26995);
            return str;
        } else {
            AppMethodBeat.o(26995);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:383:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0f68  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 4673
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.ContactInfoUI.initView():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26997);
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            getIntent().putExtra("CONTACT_INFO_UI_SOURCE", intent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
        }
        if (i3 != -1 || intent == null || !intent.getBooleanExtra("_delete_ok_", false)) {
            if (this.Bdv != null) {
                this.Bdv.onActivityResult(i2, i3, intent);
            }
            AppMethodBeat.o(26997);
            return;
        }
        setResult(-1, getIntent().putExtra("_delete_ok_", true));
        finish();
        AppMethodBeat.o(26997);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(26999);
        if (obj == null || !(obj instanceof String)) {
            Log.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(26999);
            return;
        }
        onNotifyChange((String) obj, null);
        AppMethodBeat.o(26999);
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        private WeakReference<ContactInfoUI> cMO;
        private String goe;

        a(ContactInfoUI contactInfoUI, String str) {
            AppMethodBeat.i(26978);
            this.cMO = new WeakReference<>(contactInfoUI);
            this.goe = str;
            AppMethodBeat.o(26978);
        }

        public final void run() {
            AppMethodBeat.i(26979);
            ContactInfoUI contactInfoUI = this.cMO.get();
            Log.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", this.goe);
            if (contactInfoUI == null || contactInfoUI.isFinishing() || contactInfoUI.isDestroyed()) {
                AppMethodBeat.o(26979);
                return;
            }
            Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", Boolean.valueOf(contactInfoUI.Bdy), contactInfoUI.contact.field_username, this.goe);
            if (contactInfoUI.contact != null && !Util.isNullOrNil(contactInfoUI.contact.field_username) && (contactInfoUI.contact.field_username.equals(this.goe) || contactInfoUI.contact.field_username.equals(as.bjz(this.goe)))) {
                contactInfoUI.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
                if (contactInfoUI.Bdv != null) {
                    contactInfoUI.Bdv.cCs();
                    contactInfoUI.screen.removeAll();
                }
                contactInfoUI.initView();
            }
            AppMethodBeat.o(26979);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(27000);
        new MMHandler().post(new a(this, str));
        AppMethodBeat.o(27000);
    }

    static class c implements Runnable {
        private cn BdY;
        private WeakReference<ContactInfoUI> cMO;

        c(ContactInfoUI contactInfoUI, cn cnVar) {
            AppMethodBeat.i(26980);
            this.cMO = new WeakReference<>(contactInfoUI);
            this.BdY = cnVar;
            AppMethodBeat.o(26980);
        }

        public final void run() {
            AppMethodBeat.i(26981);
            ContactInfoUI contactInfoUI = this.cMO.get();
            Log.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", this.BdY);
            if (contactInfoUI == null || contactInfoUI.isFinishing() || contactInfoUI.isDestroyed()) {
                AppMethodBeat.o(26981);
                return;
            }
            Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", Boolean.valueOf(contactInfoUI.Bdy), contactInfoUI.contact.field_username, this.BdY);
            if (contactInfoUI.contact != null && this.BdY != null && !Util.isNullOrNil(contactInfoUI.contact.field_username) && contactInfoUI.contact.field_username.equals(this.BdY.field_encryptUsername) && !ab.JF(contactInfoUI.contact.field_username)) {
                contactInfoUI.contact.BD(this.BdY.field_conRemark);
                contactInfoUI.getIntent().putExtra("Contact_User", contactInfoUI.contact.field_username);
                if (contactInfoUI.Bdv != null) {
                    contactInfoUI.Bdv.cCs();
                    contactInfoUI.screen.removeAll();
                }
                contactInfoUI.initView();
            }
            AppMethodBeat.o(26981);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n.a
    public final void a(cn cnVar) {
        AppMethodBeat.i(27001);
        MMHandlerThread.postToMainThread(new c(this, cnVar));
        AppMethodBeat.o(27001);
    }

    static class b implements Runnable {
        private bq BdX;
        private WeakReference<ContactInfoUI> cMO;

        b(ContactInfoUI contactInfoUI, bq bqVar) {
            AppMethodBeat.i(231846);
            this.cMO = new WeakReference<>(contactInfoUI);
            this.BdX = bqVar;
            AppMethodBeat.o(231846);
        }

        public final void run() {
            String str;
            AppMethodBeat.i(231847);
            ContactInfoUI contactInfoUI = this.cMO.get();
            Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange user: %s", this.BdX);
            if (contactInfoUI == null || contactInfoUI.isFinishing() || contactInfoUI.isDestroyed()) {
                AppMethodBeat.o(231847);
                return;
            }
            Object[] objArr = new Object[3];
            objArr[0] = contactInfoUI.contact.field_username;
            if (this.BdX != null) {
                str = this.BdX.field_encryptUsername;
            } else {
                str = "";
            }
            objArr[1] = str;
            objArr[2] = this.BdX.field_username;
            Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange contact.user:%s, notify.user:%s, friendUser:%s", objArr);
            if (contactInfoUI.contact != null && this.BdX != null && !Util.isNullOrNil(contactInfoUI.contact.field_username) && contactInfoUI.contact.field_username.equals(this.BdX.field_encryptUsername) && !ab.JF(contactInfoUI.contact.field_username)) {
                String str2 = this.BdX.field_username;
                if (!Util.isNullOrNil(str2) && !str2.equals(contactInfoUI.contact.field_username)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1430, 4);
                }
                if (!Util.isNullOrNil(str2)) {
                    contactInfoUI.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str2);
                }
                contactInfoUI.getIntent().putExtra("Contact_User", contactInfoUI.contact.field_username);
                Log.i("MicroMsg.ContactInfoUI", "new contact user:%s", contactInfoUI.contact.field_username);
                if (contactInfoUI.Bdv != null) {
                    contactInfoUI.Bdv.cCs();
                    contactInfoUI.screen.removeAll();
                }
                contactInfoUI.initView();
            }
            AppMethodBeat.o(231847);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f.a
    public final void a(bq bqVar) {
        AppMethodBeat.i(231850);
        MMHandlerThread.postToMainThread(new b(this, bqVar));
        AppMethodBeat.o(231850);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(27002);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(27002);
            return;
        }
        Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 19:
                if (iArr[0] == 0) {
                    NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.eEL();
                    }
                    AppMethodBeat.o(27002);
                    return;
                }
                int i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i3), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26975);
                            dialogInterface.dismiss();
                            ContactInfoUI contactInfoUI = ContactInfoUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            contactInfoUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(26975);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass12 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26976);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(26976);
                        }
                    });
                }
                AppMethodBeat.o(27002);
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(231845);
                            ContactInfoUI contactInfoUI = ContactInfoUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            contactInfoUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(231845);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    NormalUserFooterPreference normalUserFooterPreference2 = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
                    if (normalUserFooterPreference2 != null) {
                        normalUserFooterPreference2.eEK();
                    }
                    AppMethodBeat.o(27002);
                    return;
                }
        }
        AppMethodBeat.o(27002);
    }

    private void eEh() {
        AppMethodBeat.i(27003);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.o(27003);
            return;
        }
        getWindow().clearFlags(1024);
        AppMethodBeat.o(27003);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(27004);
        Log.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (273 != qVar.getType() || this.contact == null || !(this.Bdv instanceof com.tencent.mm.plugin.profile.a) || !Util.isEqual(this.contact.field_username, ((com.tencent.mm.plugin.story.f.a.i) qVar).userName)) {
            if (291 == qVar.getType() && this.contact != null) {
                new MMHandler().post(new a(this, this.contact.field_username));
            }
            AppMethodBeat.o(27004);
            return;
        }
        int i4 = ((com.tencent.mm.plugin.story.f.a.i) qVar).source;
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        if (i4 == com.tencent.mm.plugin.story.i.a.FvB) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.BdK = (i2 == 0 || i2 == 4) && i3 != 315;
        }
        this.BdL = ((com.tencent.mm.plugin.story.f.a.i) qVar).wHW;
        AppMethodBeat.o(27004);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(27005);
        if ((this.BdF == null || !this.BdF.onBackPressed()) && !getSupportFragmentManager().isDestroyed()) {
            super.onBackPressed();
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1501, this.kgm, this.viC);
        AppMethodBeat.o(27005);
    }

    private void eEi() {
        AppMethodBeat.i(27006);
        if (this.iqo) {
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), getResources().getString(R.string.hiq), 0).show();
            AppMethodBeat.o(27006);
            return;
        }
        if (this.BdH && this.BdD != null) {
            this.BdD.hbY();
        }
        AppMethodBeat.o(27006);
    }

    private void eEj() {
        String str;
        NormalProfileHeaderPreference normalProfileHeaderPreference;
        boolean z = true;
        AppMethodBeat.i(27007);
        Log.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s %s %s", Boolean.valueOf(this.BdE), Boolean.valueOf(this.BdH), Boolean.valueOf(this.BdJ), Boolean.valueOf(this.BdI));
        if (this.BdH && !this.iqo) {
            eEg();
            setActionbarColor(getContext().getResources().getColor(R.color.ac_));
            setMMTitle("");
            if (this.BdD != null) {
                this.BdD.setBackground(at.aN(getContext(), R.attr.v2));
                this.BdD.setSupportOverscroll(true);
            }
            if (this.BdR != null) {
                this.BdR.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(231832);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
                        ContactInfoUI.p(ContactInfoUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(231832);
                    }
                });
            }
        } else if (this.BdI) {
            eEg();
            setActionbarColor(getContext().getResources().getColor(R.color.ac_));
            setMMTitle("");
            if (this.BdD != null) {
                this.BdD.setBackground(null);
                if (this.contact == null) {
                    str = "";
                } else {
                    str = this.contact.field_username;
                }
                this.BdD.setSupportOverscroll(!TextUtils.isEmpty(str) && ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).isHasStatusThumb(str));
                this.BdD.setNeedHover(true);
            }
            if (this.BdR != null) {
                this.BdR.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.ContactInfoUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(231833);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root2");
                        if (TextUtils.equals(ContactInfoUI.this.getIntent().getStringExtra("Contact_User"), com.tencent.mm.plugin.auth.a.a.ceA())) {
                            ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).goUnReadMsgPage(ContactInfoUI.this);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(231833);
                    }
                });
            }
        } else {
            getWindow().clearFlags(Integer.MIN_VALUE);
            setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
            setMMTitle("");
            if (this.BdD != null) {
                this.BdD.setBackground(at.aN(getContext(), R.attr.v3));
                this.BdD.setSupportOverscroll(false);
            }
            if (this.BdQ != null) {
                this.BdQ.setPadding(0, 0, 0, 0);
            }
        }
        if (!(this.screen == null || (normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.screen.bmg("contact_profile_header_normal")) == null)) {
            if (!this.BdH || this.iqo) {
                z = false;
            }
            normalProfileHeaderPreference.b(z, this.BdR.getHeight(), this.BdI);
        }
        AppMethodBeat.o(27007);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(27008);
        h hVar = h.FuH;
        h.fqi().eQv = 0;
        super.finish();
        AppMethodBeat.o(27008);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(26998);
        String str = preference.mKey;
        Log.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.Bdv != null) {
            this.Bdv.alD(str);
        }
        if (preference != null) {
            if (preference.mKey.equals("contact_info_sns")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 3, 1, this.contact.field_username);
            } else if (preference.mKey.equals("contact_info_more")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 6, 1, this.contact.field_username);
            }
        }
        if (preference instanceof NormalProfileHeaderPreference) {
            eEi();
        }
        AppMethodBeat.o(26998);
        return false;
    }

    static /* synthetic */ void b(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(27009);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            contactInfoUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.o(27009);
            return;
        }
        contactInfoUI.getWindow().setFlags(1024, 1024);
        AppMethodBeat.o(27009);
    }
}
