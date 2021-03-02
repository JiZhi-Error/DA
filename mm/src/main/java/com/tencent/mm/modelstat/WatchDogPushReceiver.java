package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(151145);
        if (intent == null) {
            Log.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            AppMethodBeat.o(151145);
            return;
        }
        int intExtra = intent.getIntExtra("type", 0);
        Log.d("MicroMsg.WatchDogPushReceiver", "onReceive type:".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            a.C0484a aVar = new a.C0484a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (!booleanExtra) {
                aVar.jGp = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.jGo = intent.getLongExtra("dataLen", 0);
            }
            aVar.cCv = intent.getLongExtra("cost", 0);
            aVar.count = intent.getLongExtra("doSceneCount", 0);
            Log.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.jGo + " rx:" + aVar.jGp + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.count == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                Log.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.count + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
                AppMethodBeat.o(151145);
                return;
            }
            AppMethodBeat.o(151145);
            return;
        }
        if (!(intExtra == 2 || intExtra == 3 || intExtra == 4)) {
            if (intExtra != 5 || !CrashReportFactory.hasDebuger()) {
                if (intExtra == 6) {
                    Log.appenderFlush();
                }
            } else if (intent.getIntExtra("jni", 1) == 1) {
                Assert.assertTrue("test errlog push " + new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date()), false);
                AppMethodBeat.o(151145);
                return;
            } else {
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.o(151145);
                return;
            }
        }
        AppMethodBeat.o(151145);
    }

    private static String getClassName() {
        AppMethodBeat.i(151146);
        if (Util.isNullOrNil(className)) {
            className = MMApplicationContext.getSourcePackageName() + ".modelstat.WatchDogPushReceiver";
        }
        String str = className;
        AppMethodBeat.o(151146);
        return str;
    }

    public static void a(h hVar) {
        AppMethodBeat.i(151147);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
        intent.putExtra("type", 1);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("beginTime", hVar.beginTime);
        intent.putExtra("endTime", hVar.endTime);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("dataLen", hVar.jod);
        intent.putExtra("isSend", hVar.ehd);
        intent.putExtra("cost", hVar.cCv);
        intent.putExtra("doSceneCount", hVar.joe);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(151147);
    }

    public static void bgp() {
        AppMethodBeat.i(151148);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
        intent.putExtra("type", 3);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(151148);
    }

    public static void tZ(int i2) {
        AppMethodBeat.i(151149);
        if (!CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(151149);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
        intent.putExtra("type", 5);
        intent.putExtra("jni", i2);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(151149);
    }

    public static void bgq() {
        AppMethodBeat.i(151150);
        if (!CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(151150);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
        intent.putExtra("type", 7);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(151150);
    }
}
