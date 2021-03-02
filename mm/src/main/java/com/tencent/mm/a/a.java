package com.tencent.mm.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static AbstractC0239a dgB = null;
    public static int dgC = 0;

    /* renamed from: com.tencent.mm.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0239a {
        void cg(int i2, int i3);

        String getStack();
    }

    public static PendingIntent set(Context context, int i2, int i3, long j2, Intent intent, int i4) {
        AppMethodBeat.i(182032);
        PendingIntent a2 = a(context, i2, i3, j2, intent, i4, true);
        AppMethodBeat.o(182032);
        return a2;
    }

    public static PendingIntent a(Context context, int i2, int i3, long j2, Intent intent, int i4, boolean z) {
        PendingIntent activity;
        AppMethodBeat.i(185210);
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[4] = Integer.valueOf(i4);
        objArr[5] = Uq();
        Log.i("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", objArr);
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", Integer.valueOf(i2));
            AppMethodBeat.o(185210);
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", Integer.valueOf(i2));
            AppMethodBeat.o(185210);
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            AppMethodBeat.o(185210);
            return null;
        } else {
            if (z) {
                activity = PendingIntent.getBroadcast(context, i2, intent, i4);
            } else {
                activity = PendingIntent.getActivity(context, i2, intent, i4);
            }
            try {
                alarmManager.set(i3, j2, activity);
            } catch (Exception e2) {
                Log.e("MicroMsg.AlarmHelper", "set Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                if (dgB != null) {
                    AbstractC0239a aVar = dgB;
                    Uq();
                    aVar.cg(i2, 1);
                }
            }
            AppMethodBeat.o(185210);
            return activity;
        }
    }

    public static PendingIntent a(Context context, int i2, long j2, Intent intent) {
        AppMethodBeat.i(186105);
        PendingIntent b2 = b(context, i2, j2, intent);
        AppMethodBeat.o(186105);
        return b2;
    }

    private static PendingIntent b(Context context, int i2, long j2, Intent intent) {
        AppMethodBeat.i(186106);
        Object[] objArr = new Object[6];
        objArr[0] = 2;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[4] = 268435456;
        objArr[5] = Uq();
        Log.i("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", objArr);
        dgC++;
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", Integer.valueOf(i2));
            AppMethodBeat.o(186106);
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", Integer.valueOf(i2));
            AppMethodBeat.o(186106);
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            AppMethodBeat.o(186106);
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 268435456);
            try {
                alarmManager.setExact(2, j2, broadcast);
            } catch (Exception e2) {
                Log.e("MicroMsg.AlarmHelper", "setExact Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                if (dgB != null) {
                    AbstractC0239a aVar = dgB;
                    Uq();
                    aVar.cg(i2, 1);
                }
            }
            AppMethodBeat.o(186106);
            return broadcast;
        }
    }

    public static PendingIntent a(Context context, int i2, int i3, long j2, long j3, Intent intent) {
        AppMethodBeat.i(182034);
        PendingIntent b2 = b(context, i2, i3, j2, j3, intent);
        AppMethodBeat.o(182034);
        return b2;
    }

    private static PendingIntent b(Context context, int i2, int i3, long j2, long j3, Intent intent) {
        AppMethodBeat.i(186107);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(j3);
        objArr[4] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[5] = 268435456;
        objArr[6] = Uq();
        Log.i("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s stack:%s)", objArr);
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", Integer.valueOf(i2));
            AppMethodBeat.o(186107);
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", Integer.valueOf(i2));
            AppMethodBeat.o(186107);
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            AppMethodBeat.o(186107);
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 268435456);
            try {
                alarmManager.setRepeating(i3, j2, j3, broadcast);
            } catch (Exception e2) {
                Log.e("MicroMsg.AlarmHelper", "setRepeating Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                if (dgB != null) {
                    AbstractC0239a aVar = dgB;
                    Uq();
                    aVar.cg(i2, 1);
                }
            }
            AppMethodBeat.o(186107);
            return broadcast;
        }
    }

    public static void cancel(Context context, int i2, PendingIntent pendingIntent) {
        AppMethodBeat.i(182035);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = pendingIntent != null ? "no null" : BuildConfig.COMMAND;
        Log.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", objArr);
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", Integer.valueOf(i2));
            AppMethodBeat.o(182035);
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", Integer.valueOf(i2));
            AppMethodBeat.o(182035);
            return;
        }
        try {
            alarmManager.cancel(pendingIntent);
            AppMethodBeat.o(182035);
        } catch (Exception e2) {
            Log.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            if (dgB != null) {
                AbstractC0239a aVar = dgB;
                Uq();
                aVar.cg(i2, 2);
            }
            AppMethodBeat.o(182035);
        }
    }

    public static PendingIntent b(Context context, int i2, Intent intent) {
        AppMethodBeat.i(182036);
        PendingIntent a2 = a(context, i2, intent, 536870912);
        AppMethodBeat.o(182036);
        return a2;
    }

    private static PendingIntent a(Context context, int i2, Intent intent, int i3) {
        AppMethodBeat.i(182037);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[2] = Integer.valueOf(i3);
        Log.i("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", Integer.valueOf(i2));
            AppMethodBeat.o(182037);
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            AppMethodBeat.o(182037);
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, i3);
            AppMethodBeat.o(182037);
            return broadcast;
        }
    }

    private static boolean isRequestCodeValid(int i2) {
        if (i2 < 100 || i2 > 119) {
            return false;
        }
        return true;
    }

    private static String Uq() {
        AppMethodBeat.i(215246);
        if (dgB != null) {
            String stack = dgB.getStack();
            AppMethodBeat.o(215246);
            return stack;
        }
        String mMStack = Util.getStack().toString();
        AppMethodBeat.o(215246);
        return mMStack;
    }

    public static void c(Context context, Intent intent) {
        AppMethodBeat.i(186108);
        Log.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", 111, intent, 268435456);
        if (context == null) {
            Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", 111);
            AppMethodBeat.o(186108);
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", 111);
            AppMethodBeat.o(186108);
            return;
        }
        try {
            alarmManager.cancel(a(context, 111, intent, 268435456));
            AppMethodBeat.o(186108);
        } catch (Exception e2) {
            Log.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            if (dgB != null) {
                AbstractC0239a aVar = dgB;
                Uq();
                aVar.cg(111, 2);
            }
            AppMethodBeat.o(186108);
        }
    }
}
