package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;

public class SnsPermissionUI extends MMPreference implements i {
    private as BhU = null;
    private boolean BhV = false;
    private boolean BhW = false;
    private long BhX = 0;
    private int BhY = 0;
    private boolean EHB = false;
    private boolean EHC = false;
    private boolean EHD = false;
    private int scene = 0;
    private f screen;
    public q tipDialog = null;
    private String userName = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SnsPermissionUI snsPermissionUI) {
        AppMethodBeat.i(98983);
        snsPermissionUI.onStop();
        AppMethodBeat.o(98983);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98974);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(291, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.EHB = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.BhX = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        Log.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", Integer.valueOf(this.scene));
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        if (this.BhU == null) {
            Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", this.userName);
            finish();
        }
        this.BhU.setUsername(this.userName);
        initView();
        this.BhY = eEU();
        AppMethodBeat.o(98974);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98975);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.o(98975);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98975);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98976);
        super.onDestroy();
        a.jRu.WZ();
        g.aAi();
        g.aAg().hqi.b(291, this);
        if (!(this.BhX == 0 || this.BhX == -1)) {
            vl vlVar = new vl();
            vlVar.ebH.ebI = this.BhW;
            vlVar.ebH.dNa = this.BhX;
            EventCenter.instance.publish(vlVar);
        }
        long currentTicks = Util.currentTicks();
        int eEU = eEU();
        ir wr = new ir().wq(this.userName).wr(r.Jb(this.BhX));
        wr.eki = this.BhY;
        wr.ePy = eEU;
        wr.enq = 5;
        wr.bfK();
        Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", Integer.valueOf(this.BhY), Integer.valueOf(eEU), Long.valueOf(Util.ticksToNow(currentTicks)));
        if (this.EHD) {
            boolean aKt = aKt(this.userName);
            if (this.EHC && !aKt) {
                e eVar = e.DUQ;
                e.fG(this.userName, 2);
                AppMethodBeat.o(98976);
                return;
            } else if (this.EHC || !aKt) {
                e eVar2 = e.DUQ;
                e.fG(this.userName, 1);
            } else {
                e eVar3 = e.DUQ;
                e.fG(this.userName, 3);
                AppMethodBeat.o(98976);
                return;
            }
        }
        AppMethodBeat.o(98976);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d0;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98977);
        this.screen = getPreferenceScreen();
        if (this.BhU == null || !as.bjp(this.userName) || !"3552365301".equals(this.BhU.field_openImAppid)) {
            setMMTitle(R.string.h9b);
        } else {
            setMMTitle(R.string.h9c);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsPermissionUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98972);
                SnsPermissionUI.this.hideVKB();
                SnsPermissionUI.this.setResult(-1, new Intent());
                SnsPermissionUI.this.finish();
                AppMethodBeat.o(98972);
                return true;
            }
        });
        this.EHC = aKt(this.userName);
        dmp();
        AppMethodBeat.o(98977);
    }

    private void dmp() {
        boolean z = false;
        AppMethodBeat.i(98978);
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        this.BhU.setUsername(this.userName);
        boolean arB = this.BhU.arB();
        boolean aKt = aKt(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("sns_outside_permiss");
        checkBoxPreference.setChecked(arB);
        int i2 = this.BhU.fuA;
        Log.d("MicroMsg.SnsPermissionUI", "sex:%d", Integer.valueOf(i2));
        if (i2 == 1) {
            checkBoxPreference.setTitle(R.string.h99);
        } else if (i2 == 2) {
            checkBoxPreference.setTitle(R.string.h98);
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("sns_black_permiss");
        if (i2 == 1) {
            checkBoxPreference2.setTitle(R.string.h59);
        } else if (i2 == 2) {
            checkBoxPreference2.setTitle(R.string.h58);
        }
        checkBoxPreference2.setChecked(aKt);
        if (!c.oR(this.BhU.field_type)) {
            this.screen.bmi("sns_black_permiss");
        }
        PreferenceFooterCategory preferenceFooterCategory = (PreferenceFooterCategory) this.screen.bmg("sns_openim_desc_footer");
        if (as.bjp(this.userName) && "3552365301".equals(this.BhU.field_openImAppid)) {
            z = true;
        }
        this.EHD = z;
        if (this.EHD) {
            this.screen.m38do("sns_outside_permiss", true);
            preferenceFooterCategory.setSummary(R.string.h9_);
        } else {
            this.screen.m38do("sns_openim_desc_footer", true);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(98978);
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(98979);
        s JL = aj.faU().JL(5);
        if (Util.isNullOrNil(JL.field_memberList)) {
            AppMethodBeat.o(98979);
            return false;
        }
        boolean contains = Util.stringsToList(JL.field_memberList.split(",")).contains(str);
        AppMethodBeat.o(98979);
        return contains;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(98980);
        Log.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        if (qVar.getType() == 291) {
            Log.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            dmp();
            if (this.BhV) {
                this.BhW = true;
            }
        }
        AppMethodBeat.o(98980);
    }

    private int eEU() {
        AppMethodBeat.i(98982);
        int i2 = 0;
        if (this.BhU != null) {
            if (this.BhU.arB()) {
                i2 = 1;
            }
            if (aKt(this.userName)) {
                i2 |= 2;
            }
        }
        AppMethodBeat.o(98982);
        return i2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        AppMethodBeat.i(98981);
        String str = preference.mKey;
        if (str.equals("sns_outside_permiss")) {
            vx vxVar = new vx();
            vxVar.ebX.ebZ = true;
            vxVar.ebX.ebY = false;
            vxVar.ebX.username = this.userName;
            EventCenter.instance.publish(vxVar);
            if (this.BhU.arB()) {
                ab.w(this.BhU);
            } else {
                ab.v(this.BhU);
            }
            AppMethodBeat.o(98981);
            return true;
        } else if (str.equals("sns_black_permiss")) {
            vx vxVar2 = new vx();
            vxVar2.ebX.ebZ = false;
            vxVar2.ebX.ebY = true;
            vxVar2.ebX.username = this.userName;
            EventCenter.instance.publish(vxVar2);
            boolean aKt = aKt(this.userName);
            String str2 = this.userName;
            if (aKt) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (i2 == 1 && 5 == 5) {
                this.BhV = true;
                this.BhW = false;
            } else {
                this.BhV = false;
                this.BhW = false;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            final x xVar = new x(i2, 5, "", linkedList.size(), linkedList, this.scene);
            g.aAi();
            g.aAg().hqi.a(xVar, 0);
            getString(R.string.zb);
            this.tipDialog = h.a((Context) this, getString(R.string.has), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsPermissionUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(98973);
                    SnsPermissionUI.a(SnsPermissionUI.this);
                    g.aAi();
                    g.aAg().hqi.a(xVar);
                    AppMethodBeat.o(98973);
                }
            });
            AppMethodBeat.o(98981);
            return true;
        } else {
            AppMethodBeat.o(98981);
            return false;
        }
    }
}
