package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static final a BOL = new a();

    private a() {
    }

    static {
        AppMethodBeat.i(101522);
        AppMethodBeat.o(101522);
    }

    public static boolean a(Context context, int i2, int i3, int i4, RecordConfigProvider recordConfigProvider, int i5, int i6) {
        AppMethodBeat.i(168713);
        Intent a2 = a((Activity) context, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", i5);
        if (a2 == null) {
            AppMethodBeat.o(168713);
            return false;
        }
        a2.putExtra("KEY_PARAMS_CONFIG", recordConfigProvider);
        a2.putExtra("KEY_PARAMS_TO_WHERE", i5);
        a2.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", i6);
        a2.putExtra("KEY_PARAMS_EXIT_ANIM", i4);
        Log.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
        ((Activity) context).startActivityForResult(a2, i2);
        h(context, i3, i4);
        AppMethodBeat.o(168713);
        return true;
    }

    public static boolean a(Context context, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(101517);
        Intent a2 = a((Activity) context, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 2);
        if (a2 == null) {
            AppMethodBeat.o(101517);
            return false;
        }
        a2.putExtra("KEY_PARAMS_CONFIG", recordConfigProvider);
        a2.putExtra("KEY_PARAMS_TO_WHERE", 2);
        a2.putExtra("KEY_PARAMS_EXIT_ANIM", -1);
        Log.i("MicroMsg.VideoCaptureJumper", "configProvider : $provider");
        ((Activity) context).startActivityForResult(a2, 121);
        h(context, R.anim.ei, -1);
        AppMethodBeat.o(101517);
        return true;
    }

    public static boolean a(Context context, int i2, int i3, int i4, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(101518);
        Intent a2 = a((Activity) context, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
        if (a2 == null) {
            AppMethodBeat.o(101518);
            return false;
        }
        a2.putExtra("KEY_PARAMS_CONFIG", recordConfigProvider);
        a2.putExtra("KEY_PARAMS_TO_WHERE", 0);
        a2.putExtra("KEY_PARAMS_EXIT_ANIM", i4);
        Log.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", recordConfigProvider);
        ((Activity) context).startActivityForResult(a2, i2);
        h(context, i3, i4);
        AppMethodBeat.o(101518);
        return true;
    }

    public static boolean a(Context context, int i2, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(101519);
        Intent a2 = a((Activity) context, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 0);
        if (a2 == null) {
            AppMethodBeat.o(101519);
            return false;
        }
        a2.putExtra("KEY_PARAMS_CONFIG", recordConfigProvider);
        a2.putExtra("KEY_PARAMS_TO_WHERE", 0);
        a2.putExtra("KEY_PARAMS_EXIT_ANIM", R.anim.ej);
        a2.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 0);
        Log.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", recordConfigProvider);
        ((Activity) context).startActivityForResult(a2, i2);
        h(context, R.anim.ei, R.anim.ej);
        AppMethodBeat.o(101519);
        return true;
    }

    private static Intent a(Activity activity, String str, int i2) {
        Intent intent;
        Boolean bool;
        AppMethodBeat.i(101520);
        if (i2 == 0) {
            if (com.tencent.mm.q.a.o(activity, true) || com.tencent.mm.q.a.cC(activity) || com.tencent.mm.q.a.cA(activity)) {
                Log.i("MicroMsg.VideoCaptureJumper", "startStoryCapture, voip or multitalk running");
                bool = Boolean.FALSE;
            } else if (!(activity instanceof Activity) || b.a(activity, "android.permission.CAMERA", 16, "", "")) {
                Log.i("MicroMsg.VideoCaptureJumper", "startStoryCapture %s", Util.getStack().toString());
                bool = Boolean.TRUE;
            } else {
                Log.i("MicroMsg.VideoCaptureJumper", "not get enough permission checkCamera");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                Log.i("MicroMsg.VideoCaptureJumper", "not get enough permission");
                AppMethodBeat.o(101520);
                return null;
            }
        }
        try {
            intent = new Intent(activity, Class.forName(str));
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.VideoCaptureJumper", e2, "buildIntent failed!", new Object[0]);
            intent = null;
        }
        AppMethodBeat.o(101520);
        return intent;
    }

    private static void h(Context context, int i2, int i3) {
        AppMethodBeat.i(101521);
        if (!(i2 == -1 || i3 == -1)) {
            ((Activity) context).overridePendingTransition(i2, -1);
        }
        AppMethodBeat.o(101521);
    }
}
