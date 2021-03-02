package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b {
    protected int channelId;
    private int dHO = 1;
    protected String pFJ;
    protected int source;
    protected String ssid;
    private FreeWifiStateView wQJ;
    private TextView wQK;
    private TextView wQL;
    private Button wQM;
    protected Button wQN;
    protected String wQO;
    protected FreeWifiNetworkReceiver wQP;
    protected boolean wQQ = false;
    private boolean wQR = false;
    private MTimerHandler wQS = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(24969);
            if (!Util.isNullOrNil(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.dHO = FreeWifiActivateStateUI.this.dNP();
                Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.this.dHO));
                FreeWifiActivateStateUI.this.wQT.stopTimer();
                if (FreeWifiActivateStateUI.this.dHO != 2) {
                    FreeWifiActivateStateUI.this.dNT();
                    FreeWifiActivateStateUI.this.dNR();
                    d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
                }
            }
            AppMethodBeat.o(24969);
            return false;
        }
    }, false);
    private MTimerHandler wQT = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(24970);
            if (d.axS(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.a(NetworkInfo.State.CONNECTED);
                FreeWifiActivateStateUI.this.wQT.stopTimer();
                AppMethodBeat.o(24970);
                return false;
            }
            AppMethodBeat.o(24970);
            return true;
        }
    }, true);
    private MStorage.IOnStorageChange wQU = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(24971);
            FreeWifiActivateStateUI.this.dHO = FreeWifiActivateStateUI.this.dNP();
            FreeWifiActivateStateUI.this.GE(FreeWifiActivateStateUI.this.dHO);
            AppMethodBeat.o(24971);
        }
    };

    /* access modifiers changed from: protected */
    public abstract void bpf();

    /* access modifiers changed from: protected */
    public abstract void dNO();

    /* access modifiers changed from: protected */
    public abstract int dNP();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0055  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (!Util.isNullOrNil(this.ssid)) {
            dNV();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24972);
                FreeWifiActivateStateUI.this.goBack();
                AppMethodBeat.o(24972);
                return true;
            }
        });
        this.wQJ = (FreeWifiStateView) findViewById(R.id.d_4);
        this.wQK = (TextView) findViewById(R.id.d_5);
        this.wQL = (TextView) findViewById(R.id.d_6);
        if (this.source == 3) {
            this.wQL.setText(getString(R.string.f0d, new Object[]{this.ssid}));
        } else {
            this.wQL.setText(getString(R.string.b9j, new Object[]{this.ssid}));
        }
        this.wQM = (Button) findViewById(R.id.gs5);
        this.wQM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(24973);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FreeWifiActivateStateUI.this.dNP() == 2) {
                    FreeWifiActivateStateUI.this.finish();
                } else {
                    d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
                    FreeWifiActivateStateUI.this.wQQ = false;
                    FreeWifiActivateStateUI.this.dNV();
                }
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24973);
            }
        });
        this.wQN = (Button) findViewById(R.id.dp6);
        this.wQN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(24974);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String string = FreeWifiActivateStateUI.this.getString(R.string.di3);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(FreeWifiActivateStateUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24974);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void dNR() {
        if (this.wQP != null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
            this.wQP.wOS = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void dNS() {
        if (this.wQP == null) {
            dNU();
        }
        this.wQP.wOT = this;
    }

    /* access modifiers changed from: protected */
    public final void dNT() {
        if (this.wQP != null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
            this.wQP.wOT = null;
        }
    }

    private void dNU() {
        this.wQP = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.wQP, intentFilter);
    }

    /* access modifiers changed from: protected */
    public final void dNV() {
        if (!d.isWifiEnabled()) {
            this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.wQT.startTimer(1000);
            Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(24975);
                    FreeWifiActivateStateUI.d(FreeWifiActivateStateUI.this);
                    AppMethodBeat.o(24975);
                }
            });
            return;
        }
        this.dHO = dNP();
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.dHO));
        if (this.dHO != 2) {
            this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.wQT.startTimer(1000);
            if (d.axS(this.ssid)) {
                dNW();
            } else {
                j.dNq().dMZ().post(new Runnable() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(24976);
                        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiActivateStateUI.this.ssid);
                        FreeWifiActivateStateUI.this.dNO();
                        AppMethodBeat.o(24976);
                    }
                });
            }
        } else {
            GE(this.dHO);
        }
    }

    /* access modifiers changed from: protected */
    public final void GE(int i2) {
        this.wQJ.setOnClickListener(null);
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", Integer.valueOf(i2));
        switch (i2) {
            case -2014:
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                this.wQJ.setImageResource(R.drawable.bdx);
                this.wQJ.setState(3);
                this.wQK.setText(R.string.di8);
                this.wQK.setVisibility(0);
                this.wQL.setText(R.string.di9);
                this.wQL.setVisibility(0);
                break;
            case 1:
                this.wQJ.setImageResource(R.drawable.bdy);
                this.wQJ.setState(1);
                this.wQK.setText(R.string.b9g);
                break;
            case 2:
                this.wQJ.setImageResource(R.drawable.bdw);
                this.wQJ.setState(2);
                this.wQK.setText(R.string.b9f);
                this.wQM.setVisibility(0);
                this.wQM.setText(R.string.dhg);
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                if (this.source == 1 || this.source == 5 || this.source == 4) {
                    this.wQM.setVisibility(4);
                    final com.tencent.mm.plugin.freewifi.g.c aya = j.dNn().aya(this.ssid);
                    if (aya != null && !Util.isNullOrNil(aya.field_showUrl) && !this.wQR) {
                        this.wQR = true;
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.AnonymousClass9 */

                            public final void run() {
                                AppMethodBeat.i(24977);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", aya.field_showUrl + "&lang=" + LocaleUtil.loadApplicationLanguage(FreeWifiActivateStateUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), FreeWifiActivateStateUI.this));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                c.b(FreeWifiActivateStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", intent.getStringExtra("rawUrl"));
                                FreeWifiActivateStateUI.this.finish();
                                AppMethodBeat.o(24977);
                            }
                        }, 1000);
                    }
                }
                c.report();
                return;
            case 3:
                this.wQJ.setImageResource(R.drawable.bdy);
                this.wQJ.setState(3);
                this.wQJ.rHF = 2;
                this.wQK.setText(R.string.b9k);
                this.wQM.setVisibility(0);
                this.wQM.setText(R.string.dil);
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                return;
            default:
                this.wQJ.setImageResource(R.drawable.bdy);
                this.wQK.setText(R.string.b9g);
                if (this.source != 3) {
                    this.wQL.setText(getString(R.string.b9j, new Object[]{this.ssid}));
                    break;
                } else {
                    this.wQL.setText(getString(R.string.f0d, new Object[]{this.ssid}));
                    break;
                }
        }
        this.wQM.setVisibility(8);
    }

    private void dNW() {
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.wQQ));
        if (this.wQQ) {
            Log.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
            return;
        }
        this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
        this.wQT.startTimer(1000);
        bpf();
        this.wQQ = true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        j.dNn().remove(this.wQU);
        dNR();
        dNT();
        if (this.wQP != null) {
            unregisterReceiver(this.wQP);
        }
        this.wQS.stopTimer();
        this.wQT.stopTimer();
        j.dNq().release();
    }

    @Override // com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b
    public final void Nf(int i2) {
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
            case 1:
            case 2:
            default:
                return;
            case 3:
                dNR();
                dNV();
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        goBack();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void goBack() {
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            g.jRt.h(new Intent(), this);
        }
    }

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.wQP == null) {
            freeWifiActivateStateUI.dNU();
        }
        freeWifiActivateStateUI.wQP.wOS = freeWifiActivateStateUI;
        d.dNa();
    }
}
