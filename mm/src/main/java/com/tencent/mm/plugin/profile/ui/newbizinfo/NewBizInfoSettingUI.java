package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.al.l;
import com.tencent.mm.api.c;
import com.tencent.mm.ba.e;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.a;
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;

public class NewBizInfoSettingUI extends MMPreference {
    private static final String Bff = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?username=%s&from=1#wechat_redirect");
    private c Bdk;
    d Bfe;
    private long BjU;
    private long BjV;
    private ISubscribeMsgService BjW;
    private as contact;
    private c.b dhv;
    private boolean guh;
    private dvm iOA;
    private SubscribeMsgRequestResult iQF;
    private boolean isDeleteCancel;
    private int kgm;
    private f screen;
    private SharedPreferences sp = null;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewBizInfoSettingUI() {
        AppMethodBeat.i(27567);
        b bVar = b.jza;
        this.BjW = b.Ru("name_biz");
        this.Bfe = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        AppMethodBeat.o(27567);
    }

    static /* synthetic */ void a(NewBizInfoSettingUI newBizInfoSettingUI, c cVar, boolean z) {
        AppMethodBeat.i(27577);
        newBizInfoSettingUI.a(cVar, z);
        AppMethodBeat.o(27577);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(27568);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        this.BjV = System.currentTimeMillis() / 1000;
        setMMTitle(R.string.b_w);
        setTitleDividerVis(false);
        hideActionbarLine();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27557);
                NewBizInfoSettingUI.this.finish();
                AppMethodBeat.o(27557);
                return true;
            }
        });
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(nullAsNil);
        this.Bdk = g.fJ(nullAsNil);
        Object[] objArr = new Object[3];
        objArr[0] = nullAsNil;
        objArr[1] = Boolean.valueOf(this.contact != null);
        if (this.Bdk != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", objArr);
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.BjU = getIntent().getLongExtra("key_profile_enter_timestamp", 0);
        initView();
        sN(true);
        AppMethodBeat.o(27568);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27569);
        super.onDestroy();
        sN(false);
        AppMethodBeat.o(27569);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(27570);
        if (this.Bdk != null) {
            this.dhv = this.Bdk.cG(false);
        }
        if (this.Bdk == null) {
            this.screen.m38do("contact_is_mute", true);
        } else if (this.Bdk.UC()) {
            this.screen.m38do("contact_is_mute", false);
        } else {
            this.screen.m38do("contact_is_mute", true);
        }
        this.screen.m38do("contact_info_subscribe_msg", true);
        if (!(this.contact == null || !com.tencent.mm.contact.c.oR(this.contact.field_type) || this.Bdk == null || !this.Bdk.UC() || this.BjW == null)) {
            this.BjW.a(this.Bdk.field_username, new a() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass2 */

                @Override // com.tencent.mm.msgsubscription.api.a
                public final void i(int i2, int i3, String str) {
                    AppMethodBeat.i(231959);
                    Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    NewBizInfoSettingUI.this.screen.m38do("contact_info_subscribe_msg", true);
                    AppMethodBeat.o(231959);
                }

                @Override // com.tencent.mm.msgsubscription.api.a
                public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                    boolean z = true;
                    AppMethodBeat.i(231958);
                    boolean z2 = subscribeMsgRequestResult.jyp;
                    Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onSuccess size: %d, showEntry: %b", Integer.valueOf(subscribeMsgRequestResult.jyk.size()), Boolean.valueOf(subscribeMsgRequestResult.jyp));
                    f fVar = NewBizInfoSettingUI.this.screen;
                    if (z2) {
                        z = false;
                    }
                    fVar.m38do("contact_info_subscribe_msg", z);
                    NewBizInfoSettingUI.this.iQF = subscribeMsgRequestResult;
                    AppMethodBeat.o(231958);
                }
            });
        }
        this.guh = this.contact.Zx();
        sG(this.guh);
        Log.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)));
        if (getIntent() == null || !getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", this.contact.field_username);
                eEq();
                if (UL(this.kgm)) {
                    if (this.Bdk == null) {
                        Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
                        AppMethodBeat.o(27570);
                        return;
                    }
                    ((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
                    this.screen.m38do("contact_info_subscribe_bizinfo", false);
                }
            } else if (this.Bdk != null) {
                ((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
                if (this.Bdk.Ux()) {
                    if (this.dhv == null && this.Bdk != null) {
                        this.dhv = this.Bdk.cG(false);
                    }
                    if (this.dhv == null || !this.dhv.UR() || !com.tencent.mm.br.c.aZU("brandservice")) {
                        this.screen.m38do("contact_info_template_recv", true);
                    } else {
                        this.screen.m38do("contact_info_template_recv", false);
                    }
                } else {
                    this.screen.m38do("contact_info_template_recv", true);
                }
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_locate");
                if (this.Bdk.cG(false).UB()) {
                    checkBoxPreference.setChecked(this.Bdk.Uy());
                    AppMethodBeat.o(27570);
                    return;
                }
                this.screen.m38do("contact_info_locate", true);
                checkBoxPreference.setChecked(this.Bdk.Uy());
                AppMethodBeat.o(27570);
                return;
            }
            AppMethodBeat.o(27570);
            return;
        }
        Log.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() == null) {
            z = false;
        } else {
            String stringExtra = getIntent().getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID);
            String stringExtra2 = getIntent().getStringExtra("device_type");
            dv dvVar = new dv();
            dvVar.dGR.dGL = stringExtra;
            dvVar.dGR.dGP = stringExtra2;
            EventCenter.instance.publish(dvVar);
            z = dvVar.dGS.dGT;
        }
        Log.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(z));
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type) || !z) {
            Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", this.contact.field_username);
            eEq();
            if (UL(this.kgm)) {
                if (this.Bdk == null) {
                    Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
                    AppMethodBeat.o(27570);
                    return;
                }
                ((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
                this.screen.m38do("contact_info_subscribe_bizinfo", false);
            }
            AppMethodBeat.o(27570);
        } else if (this.Bdk != null) {
            ((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("contact_info_locate");
            if (this.Bdk.cG(false).UB()) {
                checkBoxPreference2.setChecked(this.Bdk.Uy());
            } else {
                this.screen.m38do("contact_info_locate", true);
                checkBoxPreference2.setChecked(this.Bdk.Uy());
            }
            if (this.Bdk.Ux()) {
                if (this.dhv == null && this.Bdk != null) {
                    this.dhv = this.Bdk.cG(false);
                }
                if (this.dhv == null || !this.dhv.UR() || !com.tencent.mm.br.c.aZU("brandservice")) {
                    this.screen.m38do("contact_info_template_recv", true);
                    AppMethodBeat.o(27570);
                    return;
                }
                this.screen.m38do("contact_info_template_recv", false);
                AppMethodBeat.o(27570);
                return;
            }
            this.screen.m38do("contact_info_template_recv", true);
            AppMethodBeat.o(27570);
        } else {
            this.screen.m38do("contact_info_subscribe_bizinfo", true);
            this.screen.m38do("contact_info_locate", true);
            this.screen.m38do("contact_info_template_recv", true);
            this.screen.m38do("contact_info_subscribe_msg", true);
            AppMethodBeat.o(27570);
        }
    }

    private void eEq() {
        AppMethodBeat.i(27571);
        if (this.contact == null || !com.tencent.mm.contact.c.oR(this.contact.field_type) || ab.Jf(this.contact.field_username) || ab.JM(this.contact.field_username)) {
            this.screen.m38do("contact_is_mute", true);
        } else if (this.Bdk == null || !this.Bdk.UC()) {
            this.screen.m38do("contact_is_mute", true);
        } else {
            this.screen.m38do("contact_is_mute", false);
        }
        this.screen.m38do("contact_info_verifyuser_weibo", true);
        this.screen.m38do("contact_info_subscribe_bizinfo", true);
        this.screen.m38do("contact_info_template_recv", true);
        this.screen.m38do("contact_info_locate", true);
        AppMethodBeat.o(27571);
    }

    private void a(c cVar, boolean z) {
        AppMethodBeat.i(27572);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("contact_info_locate");
        cpe cpe = new cpe();
        cpe.kem = cVar.field_brandFlag;
        cpe.UserName = this.contact.field_username;
        if (UL(this.kgm)) {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new k.a(58, cpe));
        } else {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new k.a(47, cpe));
        }
        ag.bah().update(cVar, new String[0]);
        checkBoxPreference.setChecked(cVar.Ux());
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(cVar.Uy());
        }
        if (z) {
            initView();
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(27572);
    }

    private void sG(boolean z) {
        AppMethodBeat.i(27573);
        if (this.contact != null) {
            if (this.sp == null) {
                this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_is_mute");
            if (!z || this.Bdk == null || !this.Bdk.UC()) {
                setTitleMuteIconVisibility(8);
                if (checkBoxPreference != null) {
                    this.sp.edit().putBoolean("contact_is_mute", false).commit();
                }
            } else {
                setTitleMuteIconVisibility(0);
                if (checkBoxPreference != null) {
                    this.sp.edit().putBoolean("contact_is_mute", true).commit();
                }
            }
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(z);
                this.screen.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(27573);
    }

    private static boolean UL(int i2) {
        if (i2 == 81 || i2 == 92 || i2 == 93 || i2 == 94) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bq;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27575);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1001 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("key_need_update", false);
            ISubscribeMsgService.Companion.SubscribeMsgListWrapper subscribeMsgListWrapper = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper) intent.getParcelableExtra("key_biz_data");
            if (!(!booleanExtra || subscribeMsgListWrapper == null || this.Bdk == null || this.BjW == null)) {
                com.tencent.mm.msgsubscription.api.c cVar = new com.tencent.mm.msgsubscription.api.c();
                cVar.setUsername(Util.nullAs(this.Bdk.field_username, ""));
                cVar.jyV.addAll(subscribeMsgListWrapper.jyV);
                cVar.jzb = subscribeMsgListWrapper.jyW;
                cVar.jze = new a() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass6 */

                    @Override // com.tencent.mm.msgsubscription.api.a
                    public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                        AppMethodBeat.i(27561);
                        Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
                        NewBizInfoSettingUI.b(NewBizInfoSettingUI.this, subscribeMsgRequestResult);
                        AppMethodBeat.o(27561);
                    }

                    @Override // com.tencent.mm.msgsubscription.api.a
                    public final void i(int i2, int i3, String str) {
                        AppMethodBeat.i(27562);
                        Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.o(27562);
                    }
                };
                this.BjW.a(cVar);
            }
        }
        AppMethodBeat.o(27575);
    }

    static {
        AppMethodBeat.i(231962);
        AppMethodBeat.o(231962);
    }

    private void sN(boolean z) {
        AppMethodBeat.i(27576);
        if (this.contact == null) {
            AppMethodBeat.o(27576);
            return;
        }
        if (this.Bdk != null && this.Bdk.UC()) {
            dws dws = new dws();
            dws.MWN = this.contact.Zx() ? 1 : 0;
            dws.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
            ag.bat();
            l.a(this.contact.field_username, dws, z ? 15 : 16);
        }
        AppMethodBeat.o(27576);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        AppMethodBeat.i(27574);
        String str = preference.mKey;
        Log.i("MicroMsg.NewBizInfoSettingUI", str + " item has been clicked!");
        if ("contact_info_locate".endsWith(str)) {
            final c cVar = this.Bdk;
            if (cVar == null) {
                AppMethodBeat.o(27574);
                return true;
            }
            if (cVar.Uy()) {
                cVar.field_brandFlag &= -5;
            } else {
                this.Bfe = h.a(this, getString(R.string.axr, new Object[]{this.contact.arJ()}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27558);
                        cVar.field_hadAlert = 1;
                        cVar.field_brandFlag |= 4;
                        NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, cVar, true);
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizInfoSettingUI.this.contact.field_username, bb.CTRL_INDEX, NewBizInfoSettingUI.this.BjU);
                        AppMethodBeat.o(27558);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27559);
                        cVar.field_hadAlert = 1;
                        NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, cVar, false);
                        AppMethodBeat.o(27559);
                    }
                });
            }
            a(cVar, false);
            if (((CheckBoxPreference) fVar.bmg("contact_info_locate")).isChecked()) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, bu.CTRL_INDEX, this.BjU);
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 907, this.BjU);
            }
        }
        if ("contact_info_add_shortcut_btn".equals(str)) {
            Log.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
            com.tencent.mm.plugin.base.model.b.ai(this, this.contact.field_username);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(27566);
                    if (NewBizInfoSettingUI.this.isFinishing()) {
                        AppMethodBeat.o(27566);
                        return;
                    }
                    com.tencent.mm.plugin.base.model.b.ah(NewBizInfoSettingUI.this, NewBizInfoSettingUI.this.contact.field_username);
                    com.tencent.mm.plugin.base.model.b.K(NewBizInfoSettingUI.this);
                    AppMethodBeat.o(27566);
                }
            }, 1000);
        }
        if ("contact_info_clear_msg".equals(str)) {
            if (this.Bdk != null && this.Bdk.UC()) {
                this.iOA = new dvm();
                this.iOA.MWC = 0;
                az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(this.contact.field_username);
                if (bjY != null) {
                    this.iOA.MWA = bjY.field_unReadCount;
                }
                ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(this.contact.field_username);
                if (aEx != null) {
                    this.iOA.MWB = aEx.getType();
                    if (this.iOA.MWA > 0) {
                        this.iOA.MWz = ((int) (System.currentTimeMillis() - aEx.field_createTime)) / 1000;
                    }
                }
            }
            h.c(this, getString(R.string.b_7), "", getString(R.string.b_6), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27560);
                    NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizInfoSettingUI.this.contact.field_username, com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, NewBizInfoSettingUI.this.BjU);
                    NewBizInfoSettingUI.e(NewBizInfoSettingUI.this);
                    AppMethodBeat.o(27560);
                }
            }, null);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 909, this.BjU);
        }
        if ("contact_is_mute".endsWith(str)) {
            this.guh = !this.guh;
            if (this.guh) {
                ab.z(this.contact);
            } else {
                ab.A(this.contact);
            }
            sG(this.guh);
        }
        if ("contact_info_template_recv".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("enterprise_biz_name", this.Bdk.field_username);
            com.tencent.mm.br.c.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
        }
        if ("contact_info_subscribe_msg".equals(str) && this.iQF != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_biz_username", this.Bdk.field_username);
            intent2.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
            intent2.putExtra("key_biz_nickname", aa.getDisplayName(this.Bdk.field_username));
            intent2.putExtra("key_biz_data", this.iQF);
            intent2.putExtra("key_need_update", false);
            intent2.putExtra("key_enter_scene", 1);
            com.tencent.mm.br.c.c(this, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", intent2, 1001);
        }
        if ("contact_info_subscribe_bizinfo".endsWith(str)) {
            c cVar2 = this.Bdk;
            if (cVar2 == null) {
                AppMethodBeat.o(27574);
                return true;
            }
            if (cVar2.Ux()) {
                cVar2.field_brandFlag |= 1;
                if (this.dhv == null && cVar2 != null) {
                    this.dhv = cVar2.cG(false);
                }
                if (this.dhv == null || !this.dhv.UR() || !com.tencent.mm.br.c.aZU("brandservice")) {
                    fVar.m38do("contact_info_template_recv", true);
                } else {
                    fVar.m38do("contact_info_template_recv", false);
                }
                com.tencent.mm.plugin.brandservice.ui.timeline.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.a.pqG;
                com.tencent.mm.plugin.brandservice.ui.timeline.a.r(cVar2.field_username, System.currentTimeMillis() / 1000, this.BjV);
            } else {
                cVar2.field_brandFlag &= -2;
                fVar.m38do("contact_info_template_recv", true);
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = cVar2.field_username;
            objArr[1] = 1;
            if (cVar2.Ux()) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = 0;
            hVar.a(13307, objArr);
            a(cVar2, false);
            if (((CheckBoxPreference) fVar.bmg("contact_info_subscribe_bizinfo")).isChecked()) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 901, this.BjU);
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 902, this.BjU);
            }
        }
        AppMethodBeat.o(27574);
        return false;
    }

    static /* synthetic */ void d(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.i(27579);
        final boolean z = newBizInfoSettingUI.Bdk != null && newBizInfoSettingUI.Bdk.UD();
        final String str = newBizInfoSettingUI.contact.field_username;
        bg.aVF();
        ca aEw = com.tencent.mm.model.c.aSQ().aEw(str);
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new e(str, aEw.field_msgSvrId));
        newBizInfoSettingUI.isDeleteCancel = false;
        newBizInfoSettingUI.getString(R.string.zb);
        newBizInfoSettingUI.tipDialog = h.a((Context) newBizInfoSettingUI, newBizInfoSettingUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(27563);
                NewBizInfoSettingUI.this.isDeleteCancel = true;
                AppMethodBeat.o(27563);
            }
        });
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.AnonymousClass8 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(27564);
                boolean z = NewBizInfoSettingUI.this.isDeleteCancel;
                AppMethodBeat.o(27564);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(27565);
                if (NewBizInfoSettingUI.this.tipDialog != null) {
                    NewBizInfoSettingUI.this.tipDialog.dismiss();
                    NewBizInfoSettingUI.this.tipDialog = null;
                }
                if (z) {
                    com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class);
                    u.biP(str);
                }
                AppMethodBeat.o(27565);
            }
        });
        ag.ban().aEn(str);
        AppMethodBeat.o(27579);
    }

    static /* synthetic */ void e(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.i(231960);
        if (!(newBizInfoSettingUI.contact == null || newBizInfoSettingUI.Bdk == null || !newBizInfoSettingUI.Bdk.UC())) {
            ag.bat();
            l.a(newBizInfoSettingUI.contact.field_username, 17, 0, 0.0f, 0.0f, 0, null, 0, newBizInfoSettingUI.iOA, null);
        }
        AppMethodBeat.o(231960);
    }

    static /* synthetic */ void b(NewBizInfoSettingUI newBizInfoSettingUI, SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(231961);
        if (newBizInfoSettingUI.iQF != null) {
            ArrayList<SubscribeMsgTmpItem> arrayList = newBizInfoSettingUI.iQF.jyk;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                SubscribeMsgTmpItem subscribeMsgTmpItem = arrayList.get(i2);
                if (subscribeMsgTmpItem != null) {
                    for (int i3 = 0; i3 < subscribeMsgRequestResult.jyk.size(); i3++) {
                        SubscribeMsgTmpItem subscribeMsgTmpItem2 = subscribeMsgRequestResult.jyk.get(i3);
                        if (subscribeMsgTmpItem2 != null && subscribeMsgTmpItem.ixM.equals(subscribeMsgTmpItem2.ixM)) {
                            subscribeMsgTmpItem.jyB = subscribeMsgTmpItem2.jyB;
                        }
                    }
                }
            }
            newBizInfoSettingUI.iQF.jyo = subscribeMsgRequestResult.jyo;
        }
        AppMethodBeat.o(231961);
    }
}
