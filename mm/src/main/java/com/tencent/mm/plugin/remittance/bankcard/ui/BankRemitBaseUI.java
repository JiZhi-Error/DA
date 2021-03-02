package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.reflect.Field;

public abstract class BankRemitBaseUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dYP();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67500);
                if (BankRemitBaseUI.this.needConfirmFinish()) {
                    BankRemitBaseUI.this.hideVKB();
                    BankRemitBaseUI.this.showDialog(1000);
                } else {
                    BankRemitBaseUI.this.finish();
                }
                AppMethodBeat.o(67500);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dYP() {
    }

    public static int aC(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(8192);
            return 3;
        } else if (aD(activity)) {
            return 1;
        } else {
            if (d(activity.getWindow())) {
                return 2;
            }
            return 0;
        }
    }

    private static boolean d(Window window) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    private static boolean aD(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    return true;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(8192);
                return true;
            } catch (Exception e2) {
                return true;
            }
        } catch (Exception e3) {
            return false;
        }
    }
}
