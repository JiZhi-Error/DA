package com.tencent.mm.sdk.vendor;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;

public class Meizu {
    public static void hideMeizuSmartBar(Activity activity, View view) {
        AppMethodBeat.i(214375);
        if (!hasSmartBar()) {
            AppMethodBeat.o(214375);
        } else if (activity.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(214375);
        } else {
            activity.getWindow().setFlags(1024, 1024);
            activity.getWindow().addFlags(2048);
            view.setPadding(0, getStatusBarHeight(activity), 0, 0);
            AppMethodBeat.o(214375);
        }
    }

    public static boolean hasSmartBar() {
        AppMethodBeat.i(153481);
        try {
            boolean booleanValue = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            AppMethodBeat.o(153481);
            return booleanValue;
        } catch (Exception e2) {
            if (Build.DEVICE.equals("mx2")) {
                AppMethodBeat.o(153481);
                return true;
            } else if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                AppMethodBeat.o(153481);
                return false;
            } else {
                AppMethodBeat.o(153481);
                return false;
            }
        }
    }

    private static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(175933);
        int D = n.D(context, 0);
        AppMethodBeat.o(175933);
        return D;
    }
}
