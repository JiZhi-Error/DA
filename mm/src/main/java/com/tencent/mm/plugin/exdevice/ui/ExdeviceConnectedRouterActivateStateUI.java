package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String dGL;
    private String dGP;
    private TextView rHA;
    private TextView rHB;
    private b<a> rHC = new b<a>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(final int i2, final int i3, String str, a aVar) {
            AppMethodBeat.i(23986);
            try {
                Log.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (ExdeviceConnectedRouterActivateStateUI.this.isFinishing()) {
                    Log.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                    AppMethodBeat.o(23986);
                    return;
                }
                ExdeviceConnectedRouterActivateStateUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(23985);
                        if (i3 == 0 && (i2 == 0 || i2 == 4)) {
                            ExdeviceConnectedRouterActivateStateUI.this.GE(2);
                            AppMethodBeat.o(23985);
                        } else if (i2 != 4) {
                            ExdeviceConnectedRouterActivateStateUI.this.GE(4);
                            AppMethodBeat.o(23985);
                        } else if (i3 == 90000) {
                            ExdeviceConnectedRouterActivateStateUI.this.GE(3);
                            AppMethodBeat.o(23985);
                        } else {
                            ExdeviceConnectedRouterActivateStateUI.this.GE(5);
                            AppMethodBeat.o(23985);
                        }
                    }
                });
                AppMethodBeat.o(23986);
            } catch (Exception e2) {
                Log.d("MicroMsg.ConnectedRouterActivateStateUi", e2.toString());
                AppMethodBeat.o(23986);
            }
        }
    };
    private final int rHy = 90000;
    private ExdeviceConnectedRouterStateView rHz;
    private String rxP;
    private String ssid;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceConnectedRouterActivateStateUI() {
        AppMethodBeat.i(23989);
        AppMethodBeat.o(23989);
    }

    static /* synthetic */ void a(ExdeviceConnectedRouterActivateStateUI exdeviceConnectedRouterActivateStateUI) {
        AppMethodBeat.i(23996);
        exdeviceConnectedRouterActivateStateUI.cLI();
        AppMethodBeat.o(23996);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23990);
        super.onCreate(bundle);
        Log.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle(R.string.bzw);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23987);
                ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
                AppMethodBeat.o(23987);
                return true;
            }
        });
        this.rHz = (ExdeviceConnectedRouterStateView) findViewById(R.id.c5o);
        this.rHA = (TextView) findViewById(R.id.c5n);
        this.rHB = (TextView) findViewById(R.id.c5p);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.dGL = parse.getQueryParameter("deviceid");
            this.dGP = parse.getQueryParameter("devicetype");
            this.rxP = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (Util.isNullOrNil(this.dGL) || Util.isNullOrNil(this.dGP) || Util.isNullOrNil(this.rxP) || Util.isNullOrNil(this.appId)) {
                Log.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", parse.toString());
                finish();
            }
            this.ssid = parse.getQueryParameter(TPDownloadProxyEnum.USER_SSID);
            Log.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", parse.toString(), this.dGL, this.dGP, this.rxP, this.ssid);
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e2) {
            Log.d("MicroMsg.ConnectedRouterActivateStateUi", e2.toString());
        }
        GE(1);
        bg.azz().a(new a(this.dGL, this.dGP, this.rxP, this.appId, this.rHC), 0);
        AppMethodBeat.o(23990);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(23991);
        super.onResume();
        AppMethodBeat.o(23991);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void GE(int i2) {
        AppMethodBeat.i(23992);
        this.rHz.setOnClickListener(null);
        Log.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.rHz.setImageResource(R.raw.connected_router_state_normal);
                this.rHz.setState(1);
                this.rHA.setText(R.string.bzq);
                break;
            case 2:
                this.rHz.setImageResource(R.raw.connected_router_state_succ);
                this.rHz.setState(2);
                this.rHA.setText(getString(R.string.bzu, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(R.string.bzp), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.AnonymousClass3 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(23988);
                        ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
                        AppMethodBeat.o(23988);
                        return true;
                    }
                });
                AppMethodBeat.o(23992);
                return;
            case 3:
                this.rHz.setImageResource(R.raw.connected_router_state_error);
                this.rHz.setState(3);
                this.rHz.rHF = 2;
                this.rHA.setText(R.string.bzr);
                this.rHB.setText(getString(R.string.bzs, new Object[]{this.ssid}));
                AppMethodBeat.o(23992);
                return;
            case 4:
                this.rHz.setImageResource(R.raw.connected_router_state_error);
                this.rHz.setState(3);
                this.rHz.rHF = 2;
                this.rHA.setText(R.string.bzr);
                this.rHB.setText(getString(R.string.bzt));
                AppMethodBeat.o(23992);
                return;
            case 5:
                this.rHz.setImageResource(R.raw.connected_router_state_error);
                this.rHz.setState(3);
                this.rHz.rHF = 2;
                this.rHA.setText(R.string.bzr);
                this.rHB.setText(getString(R.string.bzv));
                AppMethodBeat.o(23992);
                return;
        }
        AppMethodBeat.o(23992);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4h;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(23993);
        super.onDestroy();
        AppMethodBeat.o(23993);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(23994);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            cLI();
            AppMethodBeat.o(23994);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(23994);
        return onKeyDown;
    }

    private void cLI() {
        AppMethodBeat.i(23995);
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        Log.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        c.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(23995);
    }
}
