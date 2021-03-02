package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.je;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.z;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    private boolean OyA = false;
    private boolean OyB = false;
    private boolean OyC = false;
    private String OyD;
    private int OyE = 0;
    private int Oyx;
    private LinkedList<dqi> Oyy;
    private boolean Oyz = false;
    private String appId;
    private String dIQ;
    private String dJw;
    private String extInfo;
    private int fromScene;
    private boolean iGD = false;
    private int scene;
    private int source;
    private String wZz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.i(32984);
        checkCanSubscribeBizUI.gGP();
        AppMethodBeat.o(32984);
    }

    static /* synthetic */ void c(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.i(32985);
        checkCanSubscribeBizUI.gGR();
        AppMethodBeat.o(32985);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32969);
        super.onCreate(bundle);
        hideTitleView();
        if (!bg.aVG() || bg.azj()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.o(32969);
            return;
        }
        bg.azz().a(605, this);
        ((l) g.af(l.class)).aSN().add(this);
        ag.bah().add(this);
        if (bCt()) {
            String str = this.appId;
            String str2 = this.dJw;
            String str3 = this.extInfo;
            int i2 = this.Oyx;
            LinkedList<dqi> linkedList = this.Oyy;
            String str4 = this.dIQ;
            int i3 = this.source;
            int i4 = this.scene;
            d.a aVar = new d.a();
            aVar.iLN = new yf();
            aVar.iLO = new yg();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.funcId = 605;
            d aXF = aVar.aXF();
            yf yfVar = (yf) aXF.iLK.iLR;
            yfVar.hik = str;
            yfVar.xNG = str2;
            yfVar.xNU = str3;
            yfVar.Ljf = i2;
            yfVar.Ljg = linkedList;
            yfVar.Ljh = null;
            yfVar.Lji = str4;
            yfVar.xub = i3;
            yfVar.Scene = i4;
            Log.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i4));
            aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.ui.CheckCanSubscribeBizUI.AnonymousClass2 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(32967);
                    yg ygVar = (yg) dVar.iLL.iLR;
                    CheckCanSubscribeBizUI.this.wZz = ygVar.Ljj;
                    if (i2 == 0 && i3 == 0 && !Util.isNullOrNil(ygVar.Ljj) && !Util.isNullOrNil(ygVar.xNG)) {
                        CheckCanSubscribeBizUI.this.dJw = ygVar.xNG;
                        CheckCanSubscribeBizUI.this.OyD = ygVar.Ljk;
                        CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                        AppMethodBeat.o(32967);
                    } else if (z.a.a(CheckCanSubscribeBizUI.this, i2, i3, str, 7)) {
                        CheckCanSubscribeBizUI.this.setResult(5);
                        CheckCanSubscribeBizUI.this.finish();
                        AppMethodBeat.o(32967);
                    } else {
                        CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
                        CheckCanSubscribeBizUI.this.setResult(3);
                        CheckCanSubscribeBizUI.this.finish();
                        AppMethodBeat.o(32967);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(32969);
            return;
        }
        setResult(2);
        gGS();
        finish();
        AppMethodBeat.o(32969);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(32970);
        super.onStart();
        AppMethodBeat.o(32970);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(32971);
        super.onResume();
        AppMethodBeat.o(32971);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(32972);
        super.onDestroy();
        if (this.Oyy != null) {
            this.Oyy.clear();
        }
        if (bg.aAc()) {
            bg.azz().b(605, this);
            ag.bah().remove(this);
            ((l) g.af(l.class)).aSN().remove(this);
        }
        AppMethodBeat.o(32972);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(32973);
        super.onPause();
        AppMethodBeat.o(32973);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.axe;
    }

    private boolean bCt() {
        AppMethodBeat.i(32974);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            AppMethodBeat.o(32974);
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.dJw = intent.getStringExtra("toUserName");
        if (Util.isNullOrNil(this.dJw)) {
            Log.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            AppMethodBeat.o(32974);
            return false;
        }
        this.extInfo = intent.getStringExtra(IssueStorage.COLUMN_EXT_INFO);
        this.source = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.OyE = intent.getIntExtra("jump_profile_type", 0);
        switch (this.source) {
            case 1:
                if (!Util.isNullOrNil(this.appId)) {
                    this.fromScene = 68;
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                        AppMethodBeat.o(32974);
                        return false;
                    }
                    this.Oyy = new LinkedList<>();
                    for (int i2 = 0; i2 < stringArrayListExtra.size(); i2++) {
                        String str = stringArrayListExtra.get(i2);
                        if (!Util.isNullOrNil(str)) {
                            Log.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", Integer.valueOf(i2), str);
                            this.Oyy.add(com.tencent.mm.platformtools.z.Su(str));
                        }
                    }
                    if (this.Oyy.size() != 0) {
                        this.Oyx = this.Oyy.size();
                        break;
                    } else {
                        Log.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        AppMethodBeat.o(32974);
                        return false;
                    }
                } else {
                    Log.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                    AppMethodBeat.o(32974);
                    return false;
                }
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                Log.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", Integer.valueOf(this.source));
                AppMethodBeat.o(32974);
                return false;
        }
        this.dIQ = intent.getStringExtra("fromURL");
        AppMethodBeat.o(32974);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(32975);
        Log.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        if (qVar.getType() != 605) {
            if (qVar.getType() == 233) {
                bg.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.modelsimple.l lVar = (com.tencent.mm.modelsimple.l) qVar;
                    int beS = lVar.beS();
                    Log.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", Integer.valueOf(beS));
                    if (beS == 15) {
                        String beQ = lVar.beQ();
                        Log.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", Integer.valueOf(beS), beQ);
                        je jeVar = new je();
                        jeVar.dNT.actionCode = beS;
                        jeVar.dNT.result = beQ;
                        jeVar.dNT.context = this;
                        EventCenter.instance.asyncPublish(jeVar, Looper.myLooper());
                        finish();
                        AppMethodBeat.o(32975);
                        return;
                    }
                    gGR();
                    AppMethodBeat.o(32975);
                    return;
                }
                gGR();
                AppMethodBeat.o(32975);
                return;
            }
            Log.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", Integer.valueOf(qVar.getType()));
        }
        AppMethodBeat.o(32975);
    }

    private synchronized void gGP() {
        AppMethodBeat.i(32976);
        Log.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.Oyz);
        if (this.scene == 1) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.OyD);
            c.b(this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
            AppMethodBeat.o(32976);
        } else if (this.scene == 0 && this.OyE == 1) {
            if (this.OyB) {
                Log.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
                AppMethodBeat.o(32976);
            } else {
                this.OyB = true;
                bg.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
                bg.azz().a(new com.tencent.mm.modelsimple.l(this.extInfo, (String) null, 4, 0, (int) System.currentTimeMillis(), new byte[0]), 0);
                AppMethodBeat.o(32976);
            }
        } else if (!gGQ() || !this.Oyz) {
            if (this.Oyz && !this.OyB) {
                Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
                as Kn = ((l) g.af(l.class)).aSN().Kn(this.dJw);
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", this.fromScene);
                intent2.putExtra("Verify_ticket", this.wZz);
                if (Kn != null) {
                    intent2.putExtra("Contact_Alias", Kn.ajx());
                    intent2.putExtra("Contact_Nick", Kn.field_nickname);
                    intent2.putExtra("Contact_Signature", Kn.signature);
                    intent2.putExtra("Contact_RegionCode", Kn.fuO);
                    intent2.putExtra("Contact_Sex", Kn.fuA);
                    intent2.putExtra("Contact_VUser_Info", Kn.fuN);
                    intent2.putExtra("Contact_VUser_Info_Flag", Kn.field_verifyFlag);
                    intent2.putExtra("Contact_KWeibo_flag", Kn.field_weiboFlag);
                    intent2.putExtra("Contact_KWeibo", Kn.fuM);
                    intent2.putExtra("Contact_KWeiboNick", Kn.field_weiboNickname);
                }
                e.s(intent2, this.dJw);
                if (!this.OyA) {
                    setResult(-1);
                    this.OyB = true;
                    c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    finish();
                }
            }
            AppMethodBeat.o(32976);
        } else {
            if (!this.OyB) {
                Log.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", this.dJw);
                putExtra.putExtra("finish_direct", true);
                if (Util.isNullOrNil(this.dJw)) {
                    e.a(putExtra, this.dJw);
                }
                putExtra.setClass(this, ChattingUI.class);
                if (!this.OyA) {
                    setResult(-1);
                    this.OyB = true;
                    a bl = new a().bl(putExtra);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/CheckCanSubscribeBizUI", "jumpToChattingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                }
            }
            AppMethodBeat.o(32976);
        }
    }

    private synchronized boolean gGQ() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(32977);
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.dJw);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            Log.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.api.c cVar = null;
        if (!z) {
            cVar = com.tencent.mm.al.g.fJ(this.dJw);
        }
        if (cVar == null || cVar.Uz()) {
            Log.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + cVar + ") is null or should update.");
            z = true;
        }
        if (this.OyC) {
            if (Kn == null) {
                this.Oyz = false;
                setResult(5);
                gGS();
                finish();
                AppMethodBeat.o(32977);
                z2 = false;
            } else {
                this.Oyz = true;
                this.iGD = true;
                if (!com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    AppMethodBeat.o(32977);
                    z2 = false;
                }
                this.Oyz = true;
                this.iGD = true;
                AppMethodBeat.o(32977);
                z2 = true;
            }
        } else if (z) {
            if (this.Oyz) {
                setResult(5);
                gGS();
                finish();
            } else {
                ay.a.iDq.a(this.dJw, "", new ay.b.a() {
                    /* class com.tencent.mm.ui.CheckCanSubscribeBizUI.AnonymousClass1 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(32966);
                        if (!z) {
                            CheckCanSubscribeBizUI.this.OyC = true;
                            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                        }
                        AppMethodBeat.o(32966);
                    }
                });
            }
            AppMethodBeat.o(32977);
            z2 = false;
        } else {
            if (!com.tencent.mm.contact.c.oR(Kn.field_type)) {
                Log.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
                this.Oyz = true;
                AppMethodBeat.o(32977);
                z2 = false;
            }
            this.Oyz = true;
            this.iGD = true;
            AppMethodBeat.o(32977);
            z2 = true;
        }
        return z2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(32978);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            this.OyA = true;
            if (this.OyB) {
                AppMethodBeat.o(32978);
                return true;
            }
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(32978);
        return onKeyDown;
    }

    private void gGR() {
        AppMethodBeat.i(32979);
        Toast.makeText(this, getString(R.string.hve), 1).show();
        cLI();
        AppMethodBeat.o(32979);
    }

    private void gGS() {
        AppMethodBeat.i(32980);
        Toast.makeText(this, (int) R.string.g0d, 1).show();
        cLI();
        AppMethodBeat.o(32980);
    }

    private void cLI() {
        AppMethodBeat.i(32981);
        if (this.source == 1) {
            LauncherUI.jI(this);
        }
        AppMethodBeat.o(32981);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(final String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(32982);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.ui.CheckCanSubscribeBizUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(32968);
                Log.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.this.dJw + ", userName = " + str);
                if (CheckCanSubscribeBizUI.this.dJw.equals(str)) {
                    CheckCanSubscribeBizUI.this.Oyz = true;
                    if (!CheckCanSubscribeBizUI.this.iGD) {
                        CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                    }
                }
                AppMethodBeat.o(32968);
            }
        });
        AppMethodBeat.o(32982);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(32983);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(32983);
            return;
        }
        onNotifyChange((String) obj, null);
        AppMethodBeat.o(32983);
    }
}
