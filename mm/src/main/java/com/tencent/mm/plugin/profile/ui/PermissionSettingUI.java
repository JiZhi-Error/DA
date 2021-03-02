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

public class PermissionSettingUI extends MMActivity implements i {
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
    private long enterTime = System.currentTimeMillis();
    private int scene = 0;
    public q tipDialog = null;
    private String userName = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PermissionSettingUI() {
        AppMethodBeat.i(27369);
        AppMethodBeat.o(27369);
    }

    static /* synthetic */ boolean aKu(String str) {
        AppMethodBeat.i(27379);
        boolean aKt = aKt(str);
        AppMethodBeat.o(27379);
        return aKt;
    }

    static /* synthetic */ void b(PermissionSettingUI permissionSettingUI) {
        AppMethodBeat.i(27378);
        permissionSettingUI.dmp();
        AppMethodBeat.o(27378);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27370);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(291, this);
        g.aAi();
        g.aAg().hqi.a(d.CTRL_INDEX, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.BhX = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        Log.d("MicroMsg.SnsPermissionUI", "PermissionSettingUI, scene:%d", Integer.valueOf(this.scene));
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        if (this.BhU == null) {
            Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", this.userName);
            finish();
        }
        this.BhU.setUsername(this.userName);
        initView();
        ke keVar = new ke();
        keVar.dPe.dKy = 1;
        EventCenter.instance.publish(keVar);
        this.BhY = eEU();
        h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 19, 1, this.userName);
        AppMethodBeat.o(27370);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(27371);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.o(27371);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(27371);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27372);
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
        Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", Integer.valueOf(this.BhY), Integer.valueOf(eEU), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(27372);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bht;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(27373);
        if (this.BhU == null || !as.bjp(this.userName) || !"3552365301".equals(this.BhU.field_openImAppid)) {
            setMMTitle(R.string.flj);
        } else {
            setMMTitle(R.string.h9c);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27363);
                PermissionSettingUI.this.hideVKB();
                PermissionSettingUI.this.setResult(-1, new Intent());
                PermissionSettingUI.this.finish();
                AppMethodBeat.o(27363);
                return true;
            }
        });
        this.BhQ = (WeImageView) findViewById(R.id.ihp);
        this.BhR = (WeImageView) findViewById(R.id.hzp);
        this.BhO = (MMSwitchBtn) findViewById(R.id.g0p).findViewById(R.id.g0t);
        this.BhP = (MMSwitchBtn) findViewById(R.id.hwu).findViewById(R.id.g10);
        ((View) this.BhQ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(27364);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!PermissionSettingUI.this.BhU.arD()) {
                    PermissionSettingUI.this.BhU.arh();
                    ab.F(PermissionSettingUI.this.BhU);
                    PermissionSettingUI.b(PermissionSettingUI.this);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI.this.getIntent())), 20, 3, PermissionSettingUI.this.userName);
                }
                a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27364);
            }
        });
        ((View) ((View) this.BhR.getParent()).getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(27365);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (PermissionSettingUI.this.BhU.arD()) {
                    PermissionSettingUI.this.BhU.ari();
                    ab.F(PermissionSettingUI.this.BhU);
                    PermissionSettingUI.b(PermissionSettingUI.this);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI.this.getIntent())), 20, 2, PermissionSettingUI.this.userName);
                }
                a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27365);
            }
        });
        this.BhO.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(27366);
                vx vxVar = new vx();
                vxVar.ebX.ebZ = true;
                vxVar.ebX.ebY = false;
                vxVar.ebX.username = PermissionSettingUI.this.userName;
                EventCenter.instance.publish(vxVar);
                if (PermissionSettingUI.this.BhU.arB()) {
                    ab.w(PermissionSettingUI.this.BhU);
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI.this.getIntent())), 21, 2, PermissionSettingUI.this.userName);
                } else {
                    h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI.this.getIntent())), 21, 3, PermissionSettingUI.this.userName);
                    ab.v(PermissionSettingUI.this.BhU);
                }
                PermissionSettingUI.b(PermissionSettingUI.this);
                AppMethodBeat.o(27366);
            }
        });
        this.BhP.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                int i2;
                AppMethodBeat.i(27367);
                vx vxVar = new vx();
                vxVar.ebX.ebZ = false;
                vxVar.ebX.ebY = true;
                vxVar.ebX.username = PermissionSettingUI.this.userName;
                boolean aKu = PermissionSettingUI.aKu(PermissionSettingUI.this.userName);
                vxVar.ebX.eca = aKu;
                PermissionSettingUI.a(PermissionSettingUI.this, PermissionSettingUI.this.userName, aKu ? 2 : 1);
                EventCenter.instance.publish(vxVar);
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(PermissionSettingUI.this.getIntent()));
                objArr[1] = 22;
                if (aKu) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = PermissionSettingUI.this.userName;
                hVar.a(16055, objArr);
                AppMethodBeat.o(27367);
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
        AppMethodBeat.o(27373);
    }

    private void dmp() {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        AppMethodBeat.i(27374);
        g.aAi();
        this.BhU = ((l) g.af(l.class)).aSN().Kn(this.userName);
        this.BhU.setUsername(this.userName);
        this.BhQ.setVisibility(this.BhU.arD() ? 0 : 8);
        if (this.BhR != null) {
            WeImageView weImageView = this.BhR;
            if (this.BhU.arD()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            weImageView.setVisibility(i4);
        }
        View findViewById = findViewById(R.id.g0r);
        if (!this.BhS || !this.BhU.arD()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        t tVar = t.Vay;
        t.hU(findViewById(R.id.g0s));
        boolean arB = this.BhU.arB();
        boolean aKt = aKt(this.userName);
        this.BhO.setCheck(arB);
        int i5 = this.BhU.fuA;
        Log.d("MicroMsg.SnsPermissionUI", "sex:%d", Integer.valueOf(i5));
        TextView textView = (TextView) findViewById(R.id.g0u);
        if (i5 == 1) {
            textView.setText(R.string.h99);
        } else if (i5 == 2) {
            textView.setText(R.string.h98);
        }
        TextView textView2 = (TextView) findViewById(R.id.g11);
        if (i5 == 1) {
            textView2.setText(R.string.h59);
        } else if (i5 == 2) {
            textView2.setText(R.string.h58);
        }
        this.BhP.setCheck(aKt);
        View view = (View) ((View) this.BhR.getParent()).getParent();
        if (this.BhT) {
            z = false;
        }
        view.setClickable(z);
        ((TextView) findViewById(R.id.hzq)).setTextColor(this.BhT ? getResources().getColor(R.color.uj) : getResources().getColor(R.color.a2x));
        View findViewById2 = findViewById(R.id.ihq);
        if (this.BhU.arD()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        t tVar2 = t.Vay;
        t.hV(findViewById2);
        if (!as.bjp(this.userName) || !"3552365301".equals(this.BhU.field_openImAppid)) {
            findViewById(R.id.g0q).setVisibility(8);
            AppMethodBeat.o(27374);
            return;
        }
        findViewById(R.id.ihs).setVisibility(8);
        findViewById(R.id.g0p).setVisibility(8);
        findViewById(R.id.g0q).setVisibility(0);
        AppMethodBeat.o(27374);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(27376);
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
                            ((TextView) findViewById(R.id.ihq)).setText(str2);
                        } else {
                            ((TextView) findViewById(R.id.ihq)).getText().toString();
                        }
                        dmp();
                        f.a aVar = new f.a(this);
                        aVar.bow(cxn.MBY.MBZ.get(i4).iAc).Dq(true).boB(getString(R.string.fpo)).apa(R.string.fpp);
                        aVar.c(new f.c() {
                            /* class com.tencent.mm.plugin.profile.ui.PermissionSettingUI.AnonymousClass6 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(27368);
                                PermissionSettingUI.this.hideVKB();
                                if (!z) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(PermissionSettingUI.this));
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    c.b(PermissionSettingUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                }
                                AppMethodBeat.o(27368);
                            }
                        }).show();
                        AppMethodBeat.o(27376);
                        return;
                    } else if (cxn.MBY != null && cxn.MBY.LRr.get(i4).intValue() == 0 && !this.BhU.arD()) {
                        g.aAh().azQ().set(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, (Object) 0);
                    }
                }
            }
        }
        AppMethodBeat.o(27376);
    }

    private int eEU() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(27377);
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
        AppMethodBeat.o(27377);
        return i3;
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(27375);
        boolean aKt = o.DCP.aKt(str);
        AppMethodBeat.o(27375);
        return aKt;
    }

    static /* synthetic */ void a(PermissionSettingUI permissionSettingUI, String str, int i2) {
        AppMethodBeat.i(27380);
        if (i2 == 1 && 5 == 5) {
            permissionSettingUI.BhV = true;
            permissionSettingUI.BhW = false;
        } else {
            permissionSettingUI.BhV = false;
            permissionSettingUI.BhW = false;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        pr prVar = new pr();
        prVar.dVH.list = linkedList;
        prVar.dVH.dJY = i2;
        prVar.dVH.dVI = 5;
        prVar.dVH.scene = permissionSettingUI.scene;
        EventCenter.instance.publish(prVar);
        if (permissionSettingUI.tipDialog != null) {
            permissionSettingUI.tipDialog.dismiss();
        }
        permissionSettingUI.getString(R.string.zb);
        permissionSettingUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) permissionSettingUI, permissionSettingUI.getString(R.string.bac), true, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(27380);
    }
}
