package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.R;

public final class a {
    public Context mContext;

    public static a ab(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    public final int hB() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            return 5;
        }
        if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            return 4;
        }
        if (i2 >= 360) {
            return 3;
        }
        return 2;
    }

    public final boolean hC() {
        return this.mContext.getResources().getBoolean(R.bool.f3039a);
    }

    public final boolean hD() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
}
