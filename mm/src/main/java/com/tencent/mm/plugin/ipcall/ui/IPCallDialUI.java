package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.c;
import com.tencent.mm.plugin.ipcall.ui.b;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements i, b.a {
    private TextView hXv;
    private String krY;
    private String mCountryCode;
    private DialPad ysX;
    private TextView ysY;
    private EditText ysZ;
    private View yta;
    private ImageButton ytb;
    private View ytc;
    private TextView ytd;
    private TextView yte;
    private b yvm;
    private String yvn;
    private String yvo;
    private String yvp;
    private int yvq = 0;
    private int yvr = 0;
    private int yvs = -1;
    private LinkedList<ewj> yvt;
    com.tencent.mm.plugin.ipcall.model.e.b yvu;
    c yvv;
    private IListener yvw = new IListener<yk>() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.AnonymousClass2 */

        {
            AppMethodBeat.i(161388);
            this.__eventId = yk.class.getName().hashCode();
            AppMethodBeat.o(161388);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yk ykVar) {
            AppMethodBeat.i(25743);
            yk ykVar2 = ykVar;
            if (ykVar2 instanceof yk) {
                String str = ykVar2.eeH.countryCode;
                if (IPCallDialUI.this.yvm != null && !Util.isNullOrNil(str)) {
                    IPCallDialUI.this.yvm.aCe(str);
                }
            }
            AppMethodBeat.o(25743);
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallDialUI() {
        AppMethodBeat.i(25746);
        AppMethodBeat.o(25746);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25747);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.yvw);
        bg.azz().a(807, this);
        bg.azz().a(746, this);
        getWindow().addFlags(131072);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25742);
                IPCallDialUI.this.finish();
                AppMethodBeat.o(25742);
                return true;
            }
        }, R.raw.actionbar_quit_webview_icon);
        this.krY = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.yvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.yvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.yvp = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.yvq = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        Log.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, Integer.valueOf(this.yvq));
        if (!Util.isNullOrNil(this.yvn)) {
            this.yvn = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.yvn);
        }
        if (Util.isNullOrNil(this.mCountryCode)) {
            if (com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn)) {
                if (Util.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.yvn))) {
                    this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCz(this.yvn);
                } else {
                    Log.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.yvr = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.yvo);
                    intent.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
                    intent.putExtra("IPCallTalkUI_nickname", this.krY);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.yvn);
                    intent.putExtra("IPCallTalkUI_dialScene", this.yvq);
                    intent.putExtra("IPCallTalkUI_countryType", this.yvr);
                    startActivityForResult(intent, 1001);
                    finish();
                    AppMethodBeat.o(25747);
                    return;
                }
            }
            this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.ebO();
        }
        if (this.yvq != 1) {
            this.yvs = 0;
            this.yvr = 3;
            this.yvu = new com.tencent.mm.plugin.ipcall.model.e.b(this.yvn, this.mCountryCode, "", Util.getSimCountryCode(this), this.yvq);
            bg.azz().a(this.yvu, 0);
        } else {
            this.yvs = -1;
            this.yvr = 4;
        }
        init();
        AppMethodBeat.o(25747);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(25748);
        super.onStart();
        this.yvv = new c();
        bg.azz().a(this.yvv, 0);
        AppMethodBeat.o(25748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25749);
        Log.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
        AppMethodBeat.o(25749);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awn;
    }

    private void init() {
        AppMethodBeat.i(25750);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, (String) null, (String) null);
        Log.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (!a2) {
            AppMethodBeat.o(25750);
            return;
        }
        setMMTitle(R.string.e6b);
        setVolumeControlStream(1);
        this.ysX = (DialPad) findViewById(R.id.bqi);
        this.ysY = (TextView) findViewById(R.id.bgo);
        this.ytc = findViewById(R.id.bgm);
        this.ysZ = (EditText) findViewById(R.id.gb2);
        this.yta = findViewById(R.id.gb1);
        this.hXv = (TextView) findViewById(R.id.bqm);
        this.ytb = (ImageButton) findViewById(R.id.bq3);
        this.ytd = (TextView) findViewById(R.id.bgq);
        this.yte = (TextView) findViewById(R.id.bq6);
        this.yvm = new b(this, this.ysZ, this.ysY, this.yta, this.ysX, this.ytb, this.hXv, this.ytc, this.ytd, this.yte);
        this.yvm.ysW = this;
        if (!Util.isNullOrNil(this.yvn)) {
            this.yvm.es(this.yvn, -1);
        }
        if (!Util.isNullOrNil(this.mCountryCode)) {
            this.yvm.aCe(this.mCountryCode);
        }
        if (!Util.isNullOrNil(this.yvn) && !Util.isNullOrNil(this.mCountryCode)) {
            this.yvm.ebd();
        }
        this.yvm.bb(this.yvt);
        AppMethodBeat.o(25750);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(25751);
        super.onActivityResult(i2, i3, intent);
        b bVar = this.yvm;
        Log.d("MicroMsg.DialPadController", "onActivityResult");
        if (i2 == 100 && i3 == 100) {
            String nullAs = Util.nullAs(intent.getStringExtra("country_name"), "");
            String nullAs2 = Util.nullAs(intent.getStringExtra("couttry_code"), "");
            Log.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", nullAs2, nullAs);
            if (!Util.isNullOrNil(nullAs2) && !Util.isNullOrNil(nullAs)) {
                bVar.ytf = nullAs;
                bVar.ytg = "+".concat(String.valueOf(nullAs2));
                bVar.ysY.setText(bVar.ytg);
                bVar.yth = bVar.im(nullAs2.replace("+", ""), bVar.yth);
                bVar.es(bVar.yth, -1);
                bVar.ytl = false;
            }
            AppMethodBeat.o(25751);
            return;
        }
        if (i2 == 1001 && i3 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.gte.setResult(-1, intent);
            bVar.gte.finish();
        }
        AppMethodBeat.o(25751);
    }

    @Override // com.tencent.mm.plugin.ipcall.ui.b.a
    public final void u(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(25752);
        Log.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", str, str2, str3, str4);
        if (!com.tencent.mm.plugin.ipcall.a.c.gq(this)) {
            AppMethodBeat.o(25752);
        } else if (com.tencent.mm.plugin.ipcall.model.c.ead().OY(Util.getInt(str, -1))) {
            h.c(this, getString(R.string.ami), getString(R.string.amj), true);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(12058, str);
            AppMethodBeat.o(25752);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12059, 0, 0, 0, 0, 1);
            Intent intent = new Intent(this, IPCallTalkUI.class);
            intent.putExtra("IPCallTalkUI_contactId", str3);
            intent.putExtra("IPCallTalkUI_countryCode", str);
            intent.putExtra("IPCallTalkUI_nickname", str4);
            intent.putExtra("IPCallTalkUI_phoneNumber", str2);
            intent.putExtra("IPCallTalkUI_dialScene", this.yvq);
            intent.putExtra("IPCallTalkUI_countryType", this.yvr);
            startActivityForResult(intent, 1001);
            AppMethodBeat.o(25752);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25753);
        super.onDestroy();
        if (this.yvm != null) {
            this.yvm.ysW = null;
        }
        EventCenter.instance.removeListener(this.yvw);
        bg.azz().b(807, this);
        bg.azz().b(746, this);
        AppMethodBeat.o(25753);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25754);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25754);
            return;
        }
        Log.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25744);
                            dialogInterface.dismiss();
                            IPCallDialUI iPCallDialUI = IPCallDialUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallDialUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallDialUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            iPCallDialUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallDialUI, "com/tencent/mm/plugin/ipcall/ui/IPCallDialUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(25744);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25745);
                            dialogInterface.dismiss();
                            IPCallDialUI.this.finish();
                            AppMethodBeat.o(25745);
                        }
                    });
                    break;
                } else {
                    init();
                    AppMethodBeat.o(25754);
                    return;
                }
        }
        AppMethodBeat.o(25754);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(25755);
        if (qVar instanceof com.tencent.mm.plugin.ipcall.model.e.b) {
            if (i2 == 0 && i3 == 0 && qVar == this.yvu) {
                if (this.yvu.yrq != null) {
                    Log.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", Integer.valueOf(this.yvu.yrq.LjQ), this.yvu.yrq.MKj, this.yvu.yrq.yAf);
                }
                if (this.yvs != 2) {
                    this.yvs = 1;
                    this.yvr = 1;
                    com.tencent.mm.plugin.ipcall.model.e.b bVar = this.yvu;
                    if (bVar.yrq == null || bVar.yrq.LjQ != 2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        AppMethodBeat.o(25755);
                        return;
                    }
                    com.tencent.mm.plugin.ipcall.model.e.b bVar2 = this.yvu;
                    if (bVar2.yrq == null || !(bVar2.yrq.LjQ == 1 || bVar2.yrq.LjQ == 0)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        if (this.yvu.yrq == null || Util.isNullOrNil(this.yvu.yrq.yAf)) {
                            Log.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.yvm != null) {
                            Log.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", this.yvu.yrq.yAf, this.mCountryCode);
                            this.mCountryCode = this.yvu.yrq.yAf;
                            this.yvm.aCe(this.yvu.yrq.yAf);
                        }
                    }
                    if (!(this.yvu.yrq == null || Util.isNullOrNil(this.yvu.yrq.MKj) || this.yvm == null)) {
                        Log.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", this.yvu.yrq.MKj, this.yvn);
                        this.yvn = this.yvu.yrq.MKj;
                        this.yvm.es(this.yvu.yrq.MKj, -1);
                        AppMethodBeat.o(25755);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
                    AppMethodBeat.o(25755);
                    return;
                }
            }
        } else if (qVar instanceof c) {
            if (i2 == 0 && i3 == 0) {
                this.yvt = ((c) qVar).yrs.Mdr;
            } else {
                this.yvt = null;
            }
            if (this.yvm != null) {
                this.yvm.bb(this.yvt);
            }
        }
        AppMethodBeat.o(25755);
    }

    @Override // com.tencent.mm.plugin.ipcall.ui.b.a
    public final void aCf(String str) {
        AppMethodBeat.i(25756);
        Log.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", str, this.mCountryCode);
        if (!(this.yvs == 2 || this.yvs == -1 || this.mCountryCode.equals(str))) {
            ebm();
        }
        AppMethodBeat.o(25756);
    }

    @Override // com.tencent.mm.plugin.ipcall.ui.b.a
    public final void aCg(String str) {
        AppMethodBeat.i(25757);
        Log.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", str, this.yvn);
        if (!(this.yvs == 2 || this.yvs == -1 || this.yvn.equals(str))) {
            ebm();
        }
        AppMethodBeat.o(25757);
    }

    private void ebm() {
        AppMethodBeat.i(25758);
        Log.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.yvs = 2;
        if (this.yvr == 1) {
            this.yvr = 2;
            AppMethodBeat.o(25758);
            return;
        }
        this.yvr = 4;
        AppMethodBeat.o(25758);
    }
}
