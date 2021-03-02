package com.tencent.mm.plugin.ipcall.ui;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String krY;
    private String mCountryCode;
    private String yvn;
    private String yvo;
    private String yvp;
    private int yvq;
    private int yvr;
    private j yyW;
    private b yyX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25984);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().addFlags(6946944);
        this.krY = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.yvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.yvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.yvp = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.yvq = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.yvr = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        Log.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, Integer.valueOf(this.yvq), Integer.valueOf(this.yvr));
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, (String) null, (String) null);
        Log.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
        if (!a2) {
            AppMethodBeat.o(25984);
            return;
        }
        init();
        AppMethodBeat.o(25984);
    }

    private void init() {
        AppMethodBeat.i(25985);
        i.eaq().ear();
        this.yyW = new j(this);
        this.yyW.yzI = this;
        this.yyW.b(this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, this.yvq, this.yvr);
        bsw();
        AppMethodBeat.o(25985);
    }

    private void bsw() {
        AppMethodBeat.i(185748);
        this.yyX = new b(new e(this));
        this.yyX.G(9, "VOIPFloatBall");
        AppMethodBeat.o(185748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(25986);
        super.onStop();
        Log.i("MicroMsg.IPCallTalkUI", "onStop");
        if (this.yyW != null) {
            j jVar = this.yyW;
            if (jVar.yzS && !jVar.yzR) {
                i.eax().dZS();
            }
        }
        AppMethodBeat.o(25986);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25987);
        super.onDestroy();
        setScreenEnable(true);
        if (this.yyW != null) {
            j jVar = this.yyW;
            Log.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.yzH.yof = null;
            i.eav().gte = null;
            i.eav().a((a.b) null);
            i.eav().a((j) null);
            com.tencent.mm.plugin.ipcall.model.c.b eav = i.eav();
            eav.yqr.yqC = null;
            d dVar = eav.yqr;
            dVar.qUq.removeSensorCallBack();
            dVar.qUp.stopShake();
            jVar.yzG = null;
            jVar.yzI = null;
        }
        if (this.yyX != null) {
            this.yyX.onDestroy();
        }
        AppMethodBeat.o(25987);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awp;
    }

    @Override // com.tencent.mm.plugin.ipcall.ui.j.a
    public final void qC(boolean z) {
        AppMethodBeat.i(25988);
        if (!z) {
            AppMethodBeat.o(25988);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(25981);
                IPCallTalkUI.this.setResult(-1, new Intent());
                IPCallTalkUI.this.finish();
                AppMethodBeat.o(25981);
            }
        }, 3000);
        AppMethodBeat.o(25988);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            r3 = -1
            r2 = 25989(0x6585, float:3.6418E-41)
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.plugin.ipcall.ui.j r1 = r4.yyW
            if (r1 == 0) goto L_0x0042
            com.tencent.mm.plugin.ipcall.model.f r1 = com.tencent.mm.plugin.ipcall.model.i.eaw()
            boolean r1 = r1.eam()
            if (r1 == 0) goto L_0x0040
            r1 = 25
            if (r5 != r1) goto L_0x002d
            com.tencent.mm.plugin.ipcall.model.c.b r1 = com.tencent.mm.plugin.ipcall.model.i.eav()
            int r1 = r1.eaL()
            if (r1 == r3) goto L_0x0040
            com.tencent.mm.plugin.audio.c.a.AX(r1)
            r1 = r0
        L_0x0027:
            if (r1 == 0) goto L_0x0042
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x002c:
            return r0
        L_0x002d:
            r1 = 24
            if (r5 != r1) goto L_0x0040
            com.tencent.mm.plugin.ipcall.model.c.b r1 = com.tencent.mm.plugin.ipcall.model.i.eav()
            int r1 = r1.eaL()
            if (r1 == r3) goto L_0x0040
            com.tencent.mm.plugin.audio.c.a.AW(r1)
            r1 = r0
            goto L_0x0027
        L_0x0040:
            r1 = 0
            goto L_0x0027
        L_0x0042:
            boolean r0 = super.onKeyDown(r5, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        boolean z;
        AppMethodBeat.i(25990);
        Log.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.yyW != null) {
            j jVar = this.yyW;
            boolean hasWindowFocus = hasWindowFocus();
            Log.d("MicroMsg.TalkUIController", "onPause");
            boolean inKeyguardRestrictedInputMode = ((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            boolean isScreenOn = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).isScreenOn();
            if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
                z = true;
            } else {
                z = false;
            }
            jVar.yzS = z;
        }
        if (this.yyX != null) {
            this.yyX.aGj();
            f.e(false, true, true);
        }
        AppMethodBeat.o(25990);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25991);
        if (this.yyW != null) {
            this.yyW.yzR = true;
        }
        super.finish();
        AppMethodBeat.o(25991);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25992);
        Log.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.yyW != null) {
            Log.d("MicroMsg.TalkUIController", "onResume");
            bg.getNotification().cancel(42);
        }
        if (this.yyX != null) {
            this.yyX.aGf();
            f.e(true, false, true);
        }
        AppMethodBeat.o(25992);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25993);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25993);
            return;
        }
        Log.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25982);
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                            IPCallTalkUI iPCallTalkUI = IPCallTalkUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallTalkUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallTalkUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            iPCallTalkUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(iPCallTalkUI, "com/tencent/mm/plugin/ipcall/ui/IPCallTalkUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(25982);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25983);
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                            AppMethodBeat.o(25983);
                        }
                    });
                    break;
                } else {
                    init();
                    AppMethodBeat.o(25993);
                    return;
                }
        }
        AppMethodBeat.o(25993);
    }
}
