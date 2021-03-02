package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tavkit.component.TAVExporter;
import junit.framework.Assert;

public class AlertActivity extends AppCompatActivity {
    private static d.a Kfg;
    private DialogInterface.OnCancelListener CJj;
    private boolean OwV = false;
    private DialogInterface.OnDismissListener ebe;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        Window window;
        AppMethodBeat.i(159083);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(17170445));
        }
        this.OwV = getIntent().getBooleanExtra("dialog_show_top", false);
        Assert.assertNotNull(Kfg);
        if (Kfg != null) {
            Kfg.mContext = this;
            this.ebe = Kfg.QNF.XZ;
            this.CJj = Kfg.QNF.XY;
            Kfg.a(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.ui.AlertActivity.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(159081);
                    if (AlertActivity.this.ebe != null) {
                        AlertActivity.this.ebe.onDismiss(dialogInterface);
                    }
                    AlertActivity.this.finish();
                    AppMethodBeat.o(159081);
                }
            });
            Kfg.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.AlertActivity.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(159082);
                    if (AlertActivity.this.CJj != null) {
                        AlertActivity.this.CJj.onCancel(dialogInterface);
                    }
                    AlertActivity.this.finish();
                    AppMethodBeat.o(159082);
                }
            });
            d hbn = Kfg.hbn();
            if (this.OwV && (window = hbn.getWindow()) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    window.setType(2038);
                } else {
                    window.setType(2002);
                }
                as.d("MicroMsg.AlertActivity", "show top window not null!!", new Object[0]);
            }
            hbn.show();
            if (!hbn.isShowing()) {
                as.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
                finish();
            }
        }
        AppMethodBeat.o(159083);
    }

    public static void a(d.a aVar) {
        Kfg = aVar;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(159084);
        overridePendingTransition(0, 0);
        super.onPause();
        AppMethodBeat.o(159084);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(159085);
        super.onDestroy();
        Kfg = null;
        AppMethodBeat.o(159085);
    }
}
