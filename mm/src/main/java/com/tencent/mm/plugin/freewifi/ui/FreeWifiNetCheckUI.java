package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public class FreeWifiNetCheckUI extends MMActivity {
    private int channel;
    private Intent intent;
    private String key;
    private boolean rHi = true;
    private int scene;
    private MTimerHandler timer;
    ImageView wSb;
    private final int wSe = 1;
    private final int wSf = 2;
    private int[] wSh = {R.drawable.bdp, R.drawable.bdq, R.drawable.bdr, R.drawable.bds, R.drawable.bdt};
    MMHandler wSi = new MMHandler() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.AnonymousClass1 */

        /* renamed from: i  reason: collision with root package name */
        int f1504i = 0;

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25093);
            if (message.what == 1) {
                if (this.f1504i >= FreeWifiNetCheckUI.this.wSh.length) {
                    this.f1504i = 0;
                }
                FreeWifiNetCheckUI.this.wSb.setImageResource(FreeWifiNetCheckUI.this.wSh[this.f1504i]);
                this.f1504i++;
            } else if (message.what == 2) {
                FreeWifiNetCheckUI.this.wSb.setImageResource(FreeWifiNetCheckUI.this.wSh[FreeWifiNetCheckUI.this.wSh.length - 1]);
            }
            super.handleMessage(message);
            AppMethodBeat.o(25093);
        }
    };
    private a wSp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiNetCheckUI() {
        AppMethodBeat.i(25102);
        AppMethodBeat.o(25102);
    }

    static /* synthetic */ void e(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.i(25112);
        freeWifiNetCheckUI.dOh();
        AppMethodBeat.o(25112);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25104);
        super.onCreate(bundle);
        setMMTitle(R.string.dip);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25094);
                FreeWifiNetCheckUI.this.finish();
                AppMethodBeat.o(25094);
                return true;
            }
        });
        this.intent = getIntent();
        m.av(this.intent);
        this.key = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.key, d.dNf());
        this.wSb = (ImageView) findViewById(R.id.d_2);
        this.timer = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(25095);
                FreeWifiNetCheckUI.this.wSi.sendEmptyMessage(1);
                AppMethodBeat.o(25095);
                return true;
            }
        }, true);
        this.timer.startTimer(200);
        AppMethodBeat.o(25104);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0030  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 670
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.onResume():void");
    }

    private void dOh() {
        AppMethodBeat.i(25106);
        if (Util.isNullOrNil(this.key)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            AppMethodBeat.o(25106);
            return;
        }
        this.wSp = new a(this, this.key, this.channel);
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", m.aw(getIntent()), Integer.valueOf(m.ax(this.intent)), this.key, Integer.valueOf(this.channel));
        this.wSp.connect();
        AppMethodBeat.o(25106);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aml;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25107);
        super.onDestroy();
        if (this.wSp != null) {
            this.wSp = null;
        }
        this.timer.stopTimer();
        AppMethodBeat.o(25107);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25108);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.o(25108);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25108);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25109);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25109);
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.rHi = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25100);
                            FreeWifiNetCheckUI freeWifiNetCheckUI = FreeWifiNetCheckUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            freeWifiNetCheckUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FreeWifiNetCheckUI.this.finish();
                            AppMethodBeat.o(25100);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25101);
                            FreeWifiNetCheckUI.this.finish();
                            AppMethodBeat.o(25101);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(25109);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25103);
        if (this.timer != null) {
            this.timer.stopTimer();
        }
        this.wSi.sendEmptyMessage(2);
        super.finish();
        AppMethodBeat.o(25103);
    }

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        AppMethodBeat.i(25110);
        Intent intent2 = new Intent();
        intent2.putExtra("free_wifi_error_ui_error_msg", str);
        intent2.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent2.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        a bl = new a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI", "toErrorUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        freeWifiNetCheckUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI", "toErrorUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(25110);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.i(25111);
        Intent intent2 = new Intent();
        intent2.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        a bl = new a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI", "toFreeWifiNoWifiUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        freeWifiNetCheckUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(freeWifiNetCheckUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI", "toFreeWifiNoWifiUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(25111);
    }
}
