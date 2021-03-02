package com.tencent.mm.ui.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.chatting.g.a;
import org.json.JSONObject;

public class QbCallBackBroadcast extends BroadcastReceiver {
    private static Runnable Vmg = new Runnable() {
        /* class com.tencent.mm.ui.tools.QbCallBackBroadcast.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(39121);
            if (aa.hYc() != null) {
                Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, onEnterPage");
                aa.hYc().bCA();
                aa.hYc().Dw(true);
                aa.hYc().dhz();
                AppMethodBeat.o(39121);
                return;
            }
            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, FilesFloatBallHelper is null");
            AppMethodBeat.o(39121);
        }
    };

    public void onReceive(Context context, Intent intent) {
        String str;
        int i2;
        String str2;
        String str3;
        AppMethodBeat.i(39122);
        if (intent == null) {
            Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() intent == null");
            AppMethodBeat.o(39122);
            return;
        }
        g.aAi();
        if (!g.aAf().azp()) {
            Log.w("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "account not init.");
            AppMethodBeat.o(39122);
            return;
        }
        Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() %s %s", intent, intent.getExtras());
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        int i3 = 0;
        if (intent.hasExtra("thirdCtx")) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("thirdCtx"));
                str4 = jSONObject.getString("type");
                str5 = jSONObject.getString("filePath");
                str6 = jSONObject.getString("fileExt");
                i3 = jSONObject.getInt("sence");
                str7 = jSONObject.getString("verify");
            } catch (Exception e2) {
                Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() thirdCtx Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
            Log.d("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() type:%s filePath:%s fileExt:%s sence:%s", str4, str5, str6, Integer.valueOf(i3));
        }
        String str8 = (String) g.aAh().azQ().get(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_STRING_SYNC, "");
        boolean z = false;
        if (!Util.isNullOrNil(str8)) {
            String[] split = str8.split(",");
            int length = split.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (Util.isEqual(split[i4], str7)) {
                    z = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (!z) {
            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() originVerify:%s verifyKey:%s", str8, str7);
            AppMethodBeat.o(39122);
            return;
        }
        int i5 = g.aAh().azQ().getInt(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_USE_FREQUENCY_INT_SYNC, 0);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_qb_verify_use_frequency_sw, 0);
        if (Util.isEqual(a2, 1)) {
            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "qb verify frequency use %s", Integer.valueOf(i5));
            if (a2 >= 50) {
                AppMethodBeat.o(39122);
                return;
            }
            g.aAh().azQ().set(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_USE_FREQUENCY_INT_SYNC, Integer.valueOf(i5 + 1));
        }
        if (intent.hasExtra("change_file")) {
            str = intent.getStringExtra("change_file");
        } else {
            str = "";
        }
        if (intent.hasExtra("menuId")) {
            i2 = intent.getIntExtra("menuId", -1);
        } else {
            i2 = -1;
        }
        if (!Util.isEqual(i2, 11)) {
            str = str5;
        }
        if (!a.isFileExist(str)) {
            Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath(%s) not exitst", str);
            AppMethodBeat.o(39122);
            return;
        }
        if (intent.hasExtra("activity_status")) {
            str2 = intent.getStringExtra("activity_status");
        } else {
            str2 = "";
        }
        if (intent.hasExtra("readProgress")) {
            str3 = intent.getStringExtra("readProgress");
        } else {
            str3 = "";
        }
        if (Util.isEqual(str4, "qb")) {
            aa hYc = aa.hYc();
            h gsv = h.gsv();
            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "id:%s hasCurrentBall:%s activityStatus:%s  curFilePath:%s readState:%s", Integer.valueOf(i2), Boolean.valueOf(gsv.eqW()), str2, str, str3);
            switch (i2) {
                case 1:
                    if (Util.isEqual(str, gsv.mFilePath)) {
                        if (!gsv.eqW()) {
                            gsv.ic(true);
                            AppMethodBeat.o(39122);
                            return;
                        }
                        Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall() == true", str5);
                        AppMethodBeat.o(39122);
                        return;
                    }
                    break;
                case 3:
                    HandOffFile fromMultiTask = HandOffFile.fromMultiTask(gsv.Abp);
                    if (fromMultiTask != null) {
                        fromMultiTask.setHandOffType(1);
                        fromMultiTask.setKey(HandOff.generateKey(1, 1));
                        ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(fromMultiTask);
                        AppMethodBeat.o(39122);
                        return;
                    }
                    break;
                case 4:
                    if (Util.isEqual(str, gsv.mFilePath)) {
                        gsv.ic(true);
                        Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() filePath:%s hasCurrentBall:%b", str5, Boolean.valueOf(gsv.eqW()));
                        AppMethodBeat.o(39122);
                        return;
                    }
                    break;
                case 10:
                    if (Util.isEqual(str, gsv.mFilePath)) {
                        if (Util.isEqual(str2, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonBackground");
                            MMHandlerThread.removeRunnable(Vmg);
                            hYc.aGj();
                            gsv.aGj();
                            g.aAh().azQ().set(ar.a.USERINFO_MULTITASK_LAST_SHOW_ID_AND_TIME_STRING_SYNC, "");
                            hYc.hYd();
                            hYc.Dw(false);
                            if (!AppForegroundDelegate.INSTANCE.cPB) {
                                hYc.cjk();
                            }
                            HandOffFile fromMultiTask2 = HandOffFile.fromMultiTask(gsv.Abp);
                            if (fromMultiTask2 != null) {
                                ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).i(fromMultiTask2);
                            }
                            AppMethodBeat.o(39122);
                            return;
                        } else if (Util.isEqual(str2, "1")) {
                            Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "QBonForeground");
                            MMHandlerThread.postToMainThread(Vmg);
                            HandOffFile fromMultiTask3 = HandOffFile.fromMultiTask(gsv.Abp);
                            if (fromMultiTask3 != null) {
                                fromMultiTask3.setHandOffType(1);
                                fromMultiTask3.setKey(HandOff.generateKey(1, 1));
                                ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).h(fromMultiTask3);
                            }
                            AppMethodBeat.o(39122);
                            return;
                        }
                    }
                    break;
                case 11:
                    if (!Util.isEqual(str, gsv.mFilePath)) {
                        gsv.I(str, h.akC(str), gsv.qpr);
                        hYc.onDestroy();
                        hYc.I(str, h.akC(str), hYc.qpr);
                        AppMethodBeat.o(39122);
                        return;
                    }
                    break;
                case 12:
                    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "readState:%s", str3);
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            gsv.dkj();
                            Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setStart");
                        }
                        if (str3.equals("1")) {
                            gsv.CB = true;
                            Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "setEnded mEnded:%b", Boolean.TRUE);
                            gsv.erc();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(39122);
            return;
        }
        Log.e("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "onReceive() unknow source(type:%s)", str4);
        AppMethodBeat.o(39122);
    }

    static {
        AppMethodBeat.i(39123);
        AppMethodBeat.o(39123);
    }
}
