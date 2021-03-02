package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private String bssid;
    private String ssid;
    private MTimerHandler timer;
    private ImageView wSb;
    private TextView wSc;
    private Button wSd;
    private final int wSe = 1;
    private final int wSf = 2;
    private final int wSg = 3;
    private int[] wSh = {R.drawable.bdp, R.drawable.bdq, R.drawable.bdr, R.drawable.bds, R.drawable.bdt};
    MMHandler wSi = new MMHandler() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass1 */

        /* renamed from: i  reason: collision with root package name */
        int f1503i = 0;

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25067);
            if (message.what == 1) {
                if (this.f1503i >= FreeWifiManufacturerLoadingUI.this.wSh.length) {
                    this.f1503i = 0;
                }
                FreeWifiManufacturerLoadingUI.this.wSb.setImageResource(FreeWifiManufacturerLoadingUI.this.wSh[this.f1503i]);
                this.f1503i++;
            } else if (message.what == 2) {
                FreeWifiManufacturerLoadingUI.this.wSb.setImageResource(FreeWifiManufacturerLoadingUI.this.wSh[FreeWifiManufacturerLoadingUI.this.wSh.length - 1]);
            } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
                FreeWifiManufacturerLoadingUI.this.wSc.setText(message.obj.toString());
            }
            super.handleMessage(message);
            AppMethodBeat.o(25067);
        }
    };
    MMHandler wSj = new MMHandler();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiManufacturerLoadingUI() {
        AppMethodBeat.i(25077);
        AppMethodBeat.o(25077);
    }

    static /* synthetic */ void a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, int i2, String str) {
        AppMethodBeat.i(25086);
        freeWifiManufacturerLoadingUI.bv(i2, str);
        AppMethodBeat.o(25086);
    }

    static /* synthetic */ void a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        AppMethodBeat.i(25087);
        freeWifiManufacturerLoadingUI.aye(str);
        AppMethodBeat.o(25087);
    }

    static /* synthetic */ void e(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(25090);
        freeWifiManufacturerLoadingUI.dOd();
        AppMethodBeat.o(25090);
    }

    private void dOd() {
        AppMethodBeat.i(25078);
        if (this.timer != null) {
            this.timer.stopTimer();
        }
        this.wSi.sendEmptyMessage(2);
        AppMethodBeat.o(25078);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amk;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25079);
        dOd();
        super.finish();
        AppMethodBeat.o(25079);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25080);
        super.onCreate(bundle);
        setMMTitle(R.string.dip);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.wSb = (ImageView) findViewById(R.id.d_j);
        this.wSc = (TextView) findViewById(R.id.d_k);
        this.wSd = (Button) findViewById(R.id.d_l);
        this.wSd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25069);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FreeWifiManufacturerLoadingUI.this.wSj.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(25068);
                        FreeWifiManufacturerLoadingUI.this.wSd.setVisibility(4);
                        AppMethodBeat.o(25068);
                    }
                }, 0);
                FreeWifiManufacturerLoadingUI.this.dOe();
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25069);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25070);
                FreeWifiManufacturerLoadingUI.this.finish();
                AppMethodBeat.o(25070);
                return true;
            }
        });
        dOe();
        AppMethodBeat.o(25080);
    }

    public final void dOe() {
        AppMethodBeat.i(25081);
        this.wSi.sendEmptyMessage(1);
        if (this.timer != null) {
            this.timer.stopTimer();
        }
        this.timer = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(25071);
                FreeWifiManufacturerLoadingUI.this.wSi.sendEmptyMessage(1);
                AppMethodBeat.o(25071);
                return true;
            }
        }, true);
        this.timer.startTimer(200);
        ayd(this.ssid);
        AppMethodBeat.o(25081);
    }

    private void ayd(final String str) {
        AppMethodBeat.i(25082);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass5 */
            private int wSm = 0;
            private final int wSn = 5;

            public final void run() {
                AppMethodBeat.i(25072);
                Context context = MMApplicationContext.getContext();
                if (context == null) {
                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
                    AppMethodBeat.o(25072);
                    return;
                }
                if (!m.dML() || !m.axM("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str)) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + str);
                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(R.string.dig));
                    int dMv = new com.tencent.mm.plugin.freewifi.b(str, context).dMv();
                    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=".concat(String.valueOf(dMv)));
                    if (dMv != 0) {
                        FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, dMv, "An attempt to switch to special portal ap failed. connectRet=".concat(String.valueOf(dMv)));
                        AppMethodBeat.o(25072);
                        return;
                    }
                }
                dOg();
                AppMethodBeat.o(25072);
            }

            private void dOf() {
                AppMethodBeat.i(25073);
                Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
                this.wSm++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e2) {
                    Log.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e2.getMessage());
                }
                dOg();
                AppMethodBeat.o(25073);
            }

            /* JADX WARNING: Removed duplicated region for block: B:101:0x02bb A[SYNTHETIC, Splitter:B:101:0x02bb] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0142 A[Catch:{ all -> 0x02b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x029c A[SYNTHETIC, Splitter:B:92:0x029c] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void dOg() {
                /*
                // Method dump skipped, instructions count: 732
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass5.dOg():void");
            }
        });
        AppMethodBeat.o(25082);
    }

    private void bv(int i2, String str) {
        AppMethodBeat.i(25083);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", Integer.valueOf(i2), str);
        if (i2 != 0) {
            dOd();
            if (i2 == 1154) {
                aye(getString(R.string.die) + "(031" + k.b.ManufacturerConnectLoading.wNO + "-" + Math.abs(i2) + ")");
                AppMethodBeat.o(25083);
                return;
            }
            aye(getString(R.string.did) + "(031" + k.b.ManufacturerConnectLoading.wNO + "-" + Math.abs(i2) + ")");
            this.wSj.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(25075);
                    FreeWifiManufacturerLoadingUI.this.wSd.setVisibility(0);
                    AppMethodBeat.o(25075);
                }
            }, 0);
        }
        AppMethodBeat.o(25083);
    }

    private void aye(String str) {
        AppMethodBeat.i(25084);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.wSi.sendMessage(obtain);
        AppMethodBeat.o(25084);
    }

    private static String getTopActivityName(Context context) {
        AppMethodBeat.i(25085);
        try {
            String className = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity.getClassName();
            Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =".concat(String.valueOf(className)));
            AppMethodBeat.o(25085);
            return className;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e2, "", new Object[0]);
            AppMethodBeat.o(25085);
            return "(null)";
        }
    }

    static /* synthetic */ String I(InputStream inputStream) {
        AppMethodBeat.i(25088);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                sb.append(readLine2);
            } else {
                Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + sb.toString());
                String axL = m.axL(readLine);
                AppMethodBeat.o(25088);
                return axL;
            }
        }
    }

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, final String str) {
        AppMethodBeat.i(25089);
        freeWifiManufacturerLoadingUI.bv(0, "");
        freeWifiManufacturerLoadingUI.aye(freeWifiManufacturerLoadingUI.getString(R.string.dif));
        freeWifiManufacturerLoadingUI.dOd();
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : ".concat(String.valueOf(str)));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(25076);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_bottom", false);
                intent.putExtra("allow_wx_schema_url", true);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("stastic_scene", 7);
                intent.putExtra("neverBlockLocalRequest", true);
                if (FreeWifiManufacturerLoadingUI.g(FreeWifiManufacturerLoadingUI.this)) {
                    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(25076);
            }
        });
        AppMethodBeat.o(25089);
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(25091);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(freeWifiManufacturerLoadingUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI", "toSuccUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        freeWifiManufacturerLoadingUI.startActivity((Intent) bl.pG(0));
        a.a(freeWifiManufacturerLoadingUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI", "toSuccUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(R.anim.eq, R.anim.en);
        AppMethodBeat.o(25091);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(25092);
        String topActivityName = getTopActivityName(MMApplicationContext.getContext());
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : ".concat(String.valueOf(topActivityName)));
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = topActivityName != null && topActivityName.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(25092);
        return z;
    }
}
