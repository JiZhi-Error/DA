package com.tencent.mm.ui.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.ar;

public class BaseLuggageActivity extends BaseActivity implements f.e {
    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(204437);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(204437);
        return resources;
    }

    @Override // com.tencent.mm.ui.BaseActivity
    public int getLayoutId() {
        return R.layout.dp;
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(131598);
        super.onActivityResult(i2, i3, intent);
        f.aK(this).onActivityResult(i2, i3, intent);
        AppMethodBeat.o(131598);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(131599);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        f.aK(this).b(i2, iArr);
        AppMethodBeat.o(131599);
    }

    /* access modifiers changed from: protected */
    public final void hideActionbarLine() {
        AppMethodBeat.i(131600);
        if (Build.VERSION.SDK_INT >= 21 && getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0.0f);
        }
        AppMethodBeat.o(131600);
    }

    public void setRequestedOrientation(int i2) {
        AppMethodBeat.i(131601);
        try {
            super.setRequestedOrientation(i2);
            AppMethodBeat.o(131601);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.BaseLuggageActivity", th, "AndroidOSafety.safety uncaught", new Object[0]);
            AppMethodBeat.o(131601);
        }
    }

    private static boolean ne(String str, String str2) {
        AppMethodBeat.i(176010);
        if (str == null || str2 == null) {
            AppMethodBeat.o(176010);
            return false;
        }
        boolean isEqual = Util.isEqual(str.toLowerCase(), str2.toLowerCase());
        AppMethodBeat.o(176010);
        return isEqual;
    }

    private static boolean blR(String str) {
        AppMethodBeat.i(176011);
        String str2 = Build.MODEL;
        String str3 = Build.DEVICE;
        if (str2 == null && str3 == null) {
            AppMethodBeat.o(176011);
            return false;
        } else if (ne(str2, str) || ne(str3, str)) {
            AppMethodBeat.o(176011);
            return true;
        } else {
            AppMethodBeat.o(176011);
            return false;
        }
    }

    public final void setNavigationbarColor(int i2) {
        boolean z;
        int i3;
        AppMethodBeat.i(176012);
        if (Build.VERSION.SDK_INT >= 26) {
            if (blR("y83a") || blR("y83") || blR("v1732a") || blR("v1732t")) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                getWindow().setNavigationBarColor(i2);
                boolean aln = ar.aln(i2);
                View decorView = getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (aln) {
                    i3 = systemUiVisibility & -17;
                } else {
                    i3 = systemUiVisibility | 16;
                }
                decorView.setSystemUiVisibility(i3);
            }
        }
        AppMethodBeat.o(176012);
    }
}
