package com.tencent.mm.plugin.ball.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;

@com.tencent.mm.ui.base.a(7)
public class FloatBallProxyUI extends MMActivity {
    private d nUK;
    private BallInfo oWE = null;
    private e oXS;
    private int oXT = 0;
    private boolean oXU = false;
    private boolean oXV = false;
    private boolean oXW = false;

    public interface a {
        void eU(int i2, int i3);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static void a(int i2, a aVar) {
        AppMethodBeat.i(217048);
        a(null, i2, null, false, aVar);
        AppMethodBeat.o(217048);
    }

    public static void a(Context context, final int i2, BallInfo ballInfo, boolean z, final a aVar) {
        Context context2;
        AppMethodBeat.i(217049);
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, FloatBallProxyUI.class);
        if (ballInfo != null) {
            intent.putExtra("key_ball_info", ballInfo);
        }
        intent.putExtra("key_can_message_ball", z);
        intent.putExtra("key_proxy_mode", i2);
        intent.putExtra("key_result_callback", new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper())) {
            /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(106282);
                if (aVar != null) {
                    aVar.eU(i2, i2);
                }
                AppMethodBeat.o(106282);
            }
        });
        if (!(context2 instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context2.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(217049);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(106289);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(106289);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106290);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        r.e(getWindow());
        r.d(getWindow(), false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
        }
        this.oXT = getIntent().getIntExtra("key_proxy_mode", 1);
        switch (this.oXT) {
            case 1:
                BJ(R.string.dcw);
                break;
            case 2:
                this.oXS = new e((Context) this, 1, true);
                this.oXS.o(getString(R.string.dda), 17);
                this.oXS.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(106283);
                        mVar.clear();
                        mVar.a(0, -65536, FloatBallProxyUI.this.getString(R.string.dd1));
                        mVar.a(1, WebView.NIGHT_MODE_COLOR, FloatBallProxyUI.this.getString(R.string.dcz));
                        AppMethodBeat.o(106283);
                    }
                };
                this.oXS.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(106284);
                        if (menuItem.getItemId() == 0) {
                            Log.i("MicroMsg.FloatBallProxyUI", "click remove all balls");
                            FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
                            FloatBallProxyUI.this.finish();
                            AppMethodBeat.o(106284);
                            return;
                        }
                        Log.i("MicroMsg.FloatBallProxyUI", "click cancel remove all balls");
                        FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
                        FloatBallProxyUI.this.finish();
                        AppMethodBeat.o(106284);
                    }
                };
                this.oXS.PGl = new e.b() {
                    /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(106285);
                        Log.i("MicroMsg.FloatBallProxyUI", "dismiss bottom sheet");
                        FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
                        FloatBallProxyUI.this.finish();
                        AppMethodBeat.o(106285);
                    }
                };
                this.oXS.dGm();
                break;
            case 3:
                BJ(R.string.ddb);
                break;
        }
        this.oWE = (BallInfo) getIntent().getParcelableExtra("key_ball_info");
        this.oXW = getIntent().getBooleanExtra("key_can_message_ball", false);
        AppMethodBeat.o(106290);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(217050);
        super.onPause();
        Log.i("MicroMsg.FloatBallProxyUI", "alvinluo onPause proxyType: %d, hasConfirmed: %b, canAddMessageBall: %b, ballInfo: %s", Integer.valueOf(this.oXT), Boolean.valueOf(this.oXV), Boolean.valueOf(this.oXW), this.oWE);
        if (this.oXT == 1 && !this.oXV && this.oXW && this.oWE != null) {
            com.tencent.mm.plugin.ball.service.d.ciB().t(this.oWE);
        }
        AppMethodBeat.o(217050);
    }

    private void BJ(int i2) {
        AppMethodBeat.i(217051);
        String string = getResources().getString(i2);
        String string2 = getResources().getString(R.string.dcx);
        this.oXV = false;
        this.nUK = h.a(this, string, "", string2, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106286);
                Log.i("MicroMsg.FloatBallProxyUI", "click ok");
                FloatBallProxyUI.this.oXV = true;
                FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
                FloatBallProxyUI.this.finish();
                AppMethodBeat.o(106286);
            }
        });
        this.nUK.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.AnonymousClass6 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(106287);
                Log.i("MicroMsg.FloatBallProxyUI", "dismiss dialog");
                FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
                FloatBallProxyUI.this.finish();
                AppMethodBeat.o(106287);
            }
        });
        AppMethodBeat.o(217051);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(106291);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(106291);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106292);
        super.onDestroy();
        if (this.nUK != null && this.nUK.isShowing()) {
            this.nUK.dismiss();
            this.nUK = null;
        }
        if (this.oXS != null && this.oXS.isShowing()) {
            this.oXS.bMo();
            this.oXS = null;
        }
        AppMethodBeat.o(106292);
    }

    static /* synthetic */ void a(FloatBallProxyUI floatBallProxyUI, int i2) {
        AppMethodBeat.i(106293);
        if (floatBallProxyUI.oXU) {
            Log.i("MicroMsg.FloatBallProxyUI", "sendResult, has sent result, resultCode:%s", Integer.valueOf(i2));
            AppMethodBeat.o(106293);
            return;
        }
        ResultReceiver resultReceiver = (ResultReceiver) floatBallProxyUI.getIntent().getParcelableExtra("key_result_callback");
        if (resultReceiver != null) {
            floatBallProxyUI.oXU = true;
            Log.i("MicroMsg.FloatBallProxyUI", "sendResult, resultCode:%s", Integer.valueOf(i2));
            resultReceiver.send(i2, null);
        }
        AppMethodBeat.o(106293);
    }
}
