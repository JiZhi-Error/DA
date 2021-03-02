package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ba.b;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.pay.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;

public class PermissionSettingUI2 extends MMActivity implements i {
    private MMSwitchBtn BhO;
    private MMSwitchBtn BhP;
    private WeImageView BhQ;
    private WeImageView BhR;
    private boolean BhS = false;
    private boolean BhT = false;
    private as BhU = null;
    private boolean BhV = false;
    private boolean BhW = false;
    private long BhX = 0;
    private int BhY = 0;
    private TextView Bia;
    private long enterTime = System.currentTimeMillis();
    private int scene = 0;
    public q tipDialog = null;
    private String userName = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PermissionSettingUI2() {
        AppMethodBeat.i(179661);
        AppMethodBeat.o(179661);
    }

    static /* synthetic */ boolean aKv(String str) {
        AppMethodBeat.i(179671);
        boolean aKt = aKt(str);
        AppMethodBeat.o(179671);
        return aKt;
    }

    static /* synthetic */ void b(PermissionSettingUI2 permissionSettingUI2) {
        AppMethodBeat.i(179670);
        permissionSettingUI2.dmp();
        AppMethodBeat.o(179670);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(179662);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(291, this);
        g.aAi();
        g.aAg().hqi.a(d.CTRL_INDEX, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.BhX = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        Log.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", Integer.valueOf(this.scene));
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        if (this.BhU == null) {
            Log.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", this.userName);
            finish();
        }
        this.BhU.setUsername(this.userName);
        initView();
        ke keVar = new ke();
        keVar.dPe.dKy = 1;
        EventCenter.instance.publish(keVar);
        this.BhY = eEU();
        h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 19, 1, this.userName);
        AppMethodBeat.o(179662);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(179663);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsPermissionUI2", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.o(179663);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(179663);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(179664);
        super.onDestroy();
        g.aAi();
        g.aAg().hqi.b(291, this);
        g.aAi();
        g.aAg().hqi.b(d.CTRL_INDEX, this);
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
        wr.enq = this.scene;
        wr.ePz = (int) (System.currentTimeMillis() - this.enterTime);
        wr.bfK();
        Log.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", Integer.valueOf(this.BhY), Integer.valueOf(eEU), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(179664);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhu;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(179665);
        if (this.BhU == null || !as.bjp(this.userName) || !"3552365301".equals(this.BhU.field_openImAppid)) {
            setMMTitle(R.string.flj);
        } else {
            setMMTitle(R.string.h9c);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(179654);
                PermissionSettingUI2.this.hideVKB();
                PermissionSettingUI2.this.setResult(-1, new Intent());
                PermissionSettingUI2.this.finish();
                AppMethodBeat.o(179654);
                return true;
            }
        });
        this.BhQ = (WeImageView) findViewById(R.id.ihp);
        this.BhR = (WeImageView) findViewById(R.id.hzp);
        this.BhO = (MMSwitchBtn) findViewById(R.id.g0p).findViewById(R.id.g0t);
        this.BhP = (MMSwitchBtn) findViewById(R.id.hwu).findViewById(R.id.g10);
        this.Bia = (TextView) findViewById(R.id.ihq);
        t tVar = t.Vay;
        t.hV(this.Bia);
        ((View) this.BhQ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(179655);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!PermissionSettingUI2.this.BhU.arD()) {
                    PermissionSettingUI2.this.BhU.arh();
                    ab.F(PermissionSettingUI2.this.BhU);
                    PermissionSettingUI2.b(PermissionSettingUI2.this);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent())), 20, 3, PermissionSettingUI2.this.userName);
                }
                a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179655);
            }
        });
        ((View) ((View) this.BhR.getParent()).getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(179656);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (PermissionSettingUI2.this.BhU.arD()) {
                    PermissionSettingUI2.this.BhU.ari();
                    ab.F(PermissionSettingUI2.this.BhU);
                    PermissionSettingUI2.b(PermissionSettingUI2.this);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent())), 20, 2, PermissionSettingUI2.this.userName);
                }
                a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179656);
            }
        });
        this.BhO.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(179657);
                vx vxVar = new vx();
                vxVar.ebX.ebZ = true;
                vxVar.ebX.ebY = false;
                vxVar.ebX.username = PermissionSettingUI2.this.userName;
                EventCenter.instance.publish(vxVar);
                if (PermissionSettingUI2.this.BhU.arB()) {
                    ab.w(PermissionSettingUI2.this.BhU);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent())), 21, 2, PermissionSettingUI2.this.userName);
                } else {
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent())), 21, 3, PermissionSettingUI2.this.userName);
                    ab.v(PermissionSettingUI2.this.BhU);
                }
                PermissionSettingUI2.b(PermissionSettingUI2.this);
                AppMethodBeat.o(179657);
            }
        });
        this.BhP.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                int i2;
                AppMethodBeat.i(179658);
                vx vxVar = new vx();
                vxVar.ebX.ebZ = false;
                vxVar.ebX.ebY = true;
                vxVar.ebX.username = PermissionSettingUI2.this.userName;
                boolean aKv = PermissionSettingUI2.aKv(PermissionSettingUI2.this.userName);
                vxVar.ebX.eca = aKv;
                PermissionSettingUI2.a(PermissionSettingUI2.this, PermissionSettingUI2.this.userName, aKv ? 2 : 1);
                EventCenter.instance.publish(vxVar);
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent()));
                objArr[1] = 22;
                if (aKv) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = PermissionSettingUI2.this.userName;
                hVar.a(16055, objArr);
                AppMethodBeat.o(179658);
            }
        });
        findViewById(R.id.fkw).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(179659);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                PermissionSettingUI2.this.findViewById(R.id.g0p).setVisibility(0);
                PermissionSettingUI2.this.findViewById(R.id.hwu).setVisibility(0);
                PermissionSettingUI2.this.findViewById(R.id.btc).setVisibility(8);
                h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI2.this.getIntent())), 23, 1, PermissionSettingUI2.this.userName);
                a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179659);
            }
        });
        if (((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMSocialBlackListFlag", BuildInfo.DEBUG ? 1 : 0) != 1) {
            z = false;
        }
        this.BhS = z;
        if (!this.BhS) {
            findViewById(R.id.ihs).setVisibility(8);
        }
        dmp();
        AppMethodBeat.o(179665);
    }

    private void dmp() {
        int i2;
        int i3;
        int i4;
        int color;
        boolean z = true;
        AppMethodBeat.i(179666);
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        this.BhU.setUsername(this.userName);
        this.BhQ.setVisibility(this.BhU.arD() ? 0 : 8);
        WeImageView weImageView = this.BhR;
        if (this.BhU.arD()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        weImageView.setVisibility(i2);
        View findViewById = findViewById(R.id.g0r);
        if (!this.BhS || !this.BhU.arD()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        TextView textView = this.Bia;
        if (this.BhU.arD()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        boolean arB = this.BhU.arB();
        boolean aKt = aKt(this.userName);
        this.BhO.setCheck(arB);
        int i5 = this.BhU.fuA;
        Log.d("MicroMsg.SnsPermissionUI2", "sex:%d", Integer.valueOf(i5));
        TextView textView2 = (TextView) findViewById(R.id.g0u);
        if (i5 == 1) {
            textView2.setText(R.string.h99);
        } else if (i5 == 2) {
            textView2.setText(R.string.h98);
        }
        TextView textView3 = (TextView) findViewById(R.id.g11);
        if (i5 == 1) {
            textView3.setText(R.string.h59);
        } else if (i5 == 2) {
            textView3.setText(R.string.h58);
        }
        this.BhP.setCheck(aKt);
        View view = (View) ((View) this.BhR.getParent()).getParent();
        if (this.BhT) {
            z = false;
        }
        view.setClickable(z);
        TextView textView4 = (TextView) findViewById(R.id.hzq);
        if (this.BhT) {
            color = getResources().getColor(R.color.uj);
        } else {
            color = getResources().getColor(R.color.a2x);
        }
        textView4.setTextColor(color);
        if (!as.bjp(this.userName) || !"3552365301".equals(this.BhU.field_openImAppid)) {
            findViewById(R.id.g0q).setVisibility(8);
            AppMethodBeat.o(179666);
            return;
        }
        findViewById(R.id.ihs).setVisibility(8);
        findViewById(R.id.g0p).setVisibility(8);
        findViewById(R.id.g0q).setVisibility(0);
        AppMethodBeat.o(179666);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(179668);
        Log.i("MicroMsg.SnsPermissionUI2", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        if (qVar.getType() == 291) {
            Log.d("MicroMsg.SnsPermissionUI2", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            dmp();
            if (this.BhV) {
                this.BhW = true;
            }
        }
        if (qVar.getType() == 681) {
            List<k.b> list = ((com.tencent.mm.ba.b) qVar).jgc;
            cxn cxn = ((b.c) ((com.tencent.mm.ba.b) qVar).jgb.getRespObj()).jgg;
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).getCmdId() == 72) {
                    if (cxn.MBY != null && cxn.MBY.LRr.get(i4).intValue() == -3400) {
                        this.BhT = true;
                        g.aAh().azQ().set(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, (Object) 1);
                        this.BhU.arh();
                        ab.F(this.BhU);
                        String str2 = cxn.MBY.MBZ.get(i4).iAc;
                        if (!Util.isNullOrNil(str2)) {
                            this.Bia.setText(str2);
                        } else {
                            ((TextView) findViewById(R.id.ihq)).getText().toString();
                        }
                        dmp();
                        f.a aVar = new f.a(this);
                        aVar.bow(cxn.MBY.MBZ.get(i4).iAc).Dq(true).boB(getString(R.string.fpo)).apa(R.string.fpp);
                        aVar.c(new f.c() {
                            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.AnonymousClass7 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(179660);
                                PermissionSettingUI2.this.hideVKB();
                                if (!z) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(PermissionSettingUI2.this));
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    c.b(PermissionSettingUI2.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                }
                                AppMethodBeat.o(179660);
                            }
                        }).show();
                        AppMethodBeat.o(179668);
                        return;
                    } else if (cxn.MBY != null && cxn.MBY.LRr.get(i4).intValue() == 0 && !this.BhU.arD()) {
                        g.aAh().azQ().set(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, (Object) 0);
                    }
                }
            }
        }
        AppMethodBeat.o(179668);
    }

    private int eEU() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(179669);
        if (this.BhU != null && !this.BhU.arD()) {
            if (!this.BhU.arB()) {
                i2 = 0;
            }
            if (aKt(this.userName)) {
                i3 = i2 | 2;
            } else {
                i3 = i2;
            }
            if (i3 == 0) {
                i3 = 4;
            }
        } else if (this.BhU != null) {
            if (g.aAh().azQ().getInt(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, 0) == 1) {
                i3 = 6;
            } else {
                i3 = 5;
            }
        }
        AppMethodBeat.o(179669);
        return i3;
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(179667);
        boolean aKt = o.DCP.aKt(str);
        AppMethodBeat.o(179667);
        return aKt;
    }

    static /* synthetic */ void a(PermissionSettingUI2 permissionSettingUI2, String str, int i2) {
        AppMethodBeat.i(179672);
        if (i2 == 1 && 5 == 5) {
            permissionSettingUI2.BhV = true;
            permissionSettingUI2.BhW = false;
        } else {
            permissionSettingUI2.BhV = false;
            permissionSettingUI2.BhW = false;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        pr prVar = new pr();
        prVar.dVH.list = linkedList;
        prVar.dVH.dJY = i2;
        prVar.dVH.dVI = 5;
        prVar.dVH.scene = permissionSettingUI2.scene;
        EventCenter.instance.publish(prVar);
        permissionSettingUI2.getString(R.string.zb);
        permissionSettingUI2.tipDialog = com.tencent.mm.ui.base.h.a((Context) permissionSettingUI2, permissionSettingUI2.getString(R.string.bac), true, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(179672);
    }
}
