package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI extends MMActivity implements n.a {
    String appId;
    int dMe;
    String id;
    ConsolePanel lpy;
    int pkgVersion;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(121485);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(121483);
                WidgetConsoleUI.this.finish();
                AppMethodBeat.o(121483);
                return false;
            }
        });
        setMMTitle(R.string.j5r);
        this.lpy = (ConsolePanel) findViewById(R.id.b_w);
        if (!bCt()) {
            finish();
            AppMethodBeat.o(121485);
            return;
        }
        AppMethodBeat.o(121485);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(121486);
        super.onNewIntent(intent);
        if (!bCt()) {
            finish();
            AppMethodBeat.o(121486);
            return;
        }
        AppMethodBeat.o(121486);
    }

    private boolean bCt() {
        AppMethodBeat.i(121487);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.dMe = intent.getIntExtra("pkg_type", 0);
        this.pkgVersion = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", stringExtra));
        if (Util.isNullOrNil(stringExtra)) {
            AppMethodBeat.o(121487);
            return false;
        } else if (stringExtra.equals(this.id)) {
            AppMethodBeat.o(121487);
            return true;
        } else {
            ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().b(this.id, this);
            ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().a(stringExtra, this);
            this.id = stringExtra;
            d.a(this.lpy);
            AppMethodBeat.o(121487);
            return true;
        }
    }

    @Override // com.tencent.mm.modelappbrand.n.a
    public final void sF(int i2) {
        final String str;
        AppMethodBeat.i(121488);
        switch (i2) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(121484);
                WidgetConsoleUI.this.setMMTitle(String.format("%s%s", WidgetConsoleUI.this.getString(R.string.j5r), str));
                Toast.makeText(WidgetConsoleUI.this.getContext(), String.format("%s%s", WidgetConsoleUI.this.id, str), 1).show();
                AppMethodBeat.o(121484);
            }
        });
        AppMethodBeat.o(121488);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(121489);
        super.onDestroy();
        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().b(this.id, this);
        d.b(this.lpy);
        AppMethodBeat.o(121489);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(121490);
        if (isFinishing() || activityHasDestroyed()) {
            AppMethodBeat.o(121490);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        overridePendingTransition(resourceId, resourceId2);
        AppMethodBeat.o(121490);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cch;
    }
}
