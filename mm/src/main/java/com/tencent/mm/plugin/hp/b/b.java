package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b {
    private static long ymo = 0;

    public static void dYV() {
        AppMethodBeat.i(117387);
        h.INSTANCE.idkeyStat(338, 9, 1, false);
        AppMethodBeat.o(117387);
    }

    public static void Mg(int i2) {
        AppMethodBeat.i(117388);
        Log.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i2) {
            case 0:
                h.INSTANCE.idkeyStat(338, 0, 1, false);
                break;
            case 1:
                h.INSTANCE.idkeyStat(338, 20, 1, false);
                break;
            case 2:
                h.INSTANCE.idkeyStat(614, 0, 1, false);
                break;
        }
        ymo = Util.currentTicks();
        AppMethodBeat.o(117388);
    }

    public static void OP(int i2) {
        AppMethodBeat.i(117389);
        long ticksToNow = Util.ticksToNow(ymo);
        Log.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", Long.valueOf(ticksToNow));
        switch (i2) {
            case 1:
                h.INSTANCE.idkeyStat(338, 40, 1, false);
                break;
        }
        if (ticksToNow < 0) {
            Log.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
            AppMethodBeat.o(117389);
        } else if (ticksToNow <= 5000) {
            h.INSTANCE.aw(338, 1, 43);
            AppMethodBeat.o(117389);
        } else if (ticksToNow <= Util.MILLSECONDS_OF_MINUTE) {
            h.INSTANCE.aw(338, 1, 44);
            AppMethodBeat.o(117389);
        } else if (ticksToNow <= 180000) {
            h.INSTANCE.aw(338, 1, 45);
            AppMethodBeat.o(117389);
        } else {
            h.INSTANCE.aw(338, 1, 46);
            AppMethodBeat.o(117389);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OQ(int i2) {
        AppMethodBeat.i(117390);
        Log.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i2) {
            case 0:
                h.INSTANCE.idkeyStat(338, 41, 1, false);
                AppMethodBeat.o(117390);
                return;
            case 1:
                h.INSTANCE.idkeyStat(338, 42, 1, false);
                AppMethodBeat.o(117390);
                return;
            case 2:
                h.INSTANCE.idkeyStat(614, 3, 1, false);
                break;
        }
        AppMethodBeat.o(117390);
    }

    public static void qj(boolean z) {
        AppMethodBeat.i(117391);
        Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        h.INSTANCE.aw(338, 2, 71);
        if (z) {
            h.INSTANCE.idkeyStat(338, 7, 1, true);
        }
        AppMethodBeat.o(117391);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OR(int i2) {
        AppMethodBeat.i(117392);
        Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i2) {
            case -26:
                h.INSTANCE.idkeyStat(338, 83, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -25:
                h.INSTANCE.idkeyStat(338, 82, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -24:
                h.INSTANCE.idkeyStat(338, 81, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -23:
                h.INSTANCE.idkeyStat(338, 79, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -22:
                h.INSTANCE.idkeyStat(338, 80, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -21:
                h.INSTANCE.idkeyStat(338, 77, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -20:
                h.INSTANCE.idkeyStat(338, 76, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -7:
                h.INSTANCE.idkeyStat(338, 84, 1, false);
                break;
            case -6:
                h.INSTANCE.idkeyStat(338, 78, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -5:
                h.INSTANCE.idkeyStat(338, 85, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -4:
                h.INSTANCE.idkeyStat(338, 74, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -3:
                h.INSTANCE.idkeyStat(338, 73, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -2:
                h.INSTANCE.idkeyStat(338, 75, 1, false);
                AppMethodBeat.o(117392);
                return;
            case -1:
                h.INSTANCE.idkeyStat(338, 72, 1, false);
                AppMethodBeat.o(117392);
                return;
        }
        AppMethodBeat.o(117392);
    }

    public static void aD(Intent intent) {
        AppMethodBeat.i(117393);
        KVCommCrossProcessReceiver.eOA();
        Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            h.INSTANCE.aw(338, 6, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            AppMethodBeat.o(117393);
        } else if (ShareIntentUtil.getStringExtra(intent, "patch_path_extra") == null) {
            h.INSTANCE.aw(338, 6, 128);
            AppMethodBeat.o(117393);
        } else {
            h.INSTANCE.idkeyStat(338, 6, 1, true);
            AppMethodBeat.o(117393);
        }
    }

    public static void C(long j2, boolean z) {
        AppMethodBeat.i(117394);
        if (z) {
            h.INSTANCE.idkeyStat(338, 3, 1, true);
        }
        if (z) {
            h.INSTANCE.idkeyStat(338, 101, 1, false);
        } else {
            h.INSTANCE.idkeyStat(338, 103, 1, false);
        }
        Log.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", Long.valueOf(j2));
        if (j2 < 0) {
            Log.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
            AppMethodBeat.o(117394);
        } else if (j2 <= 5000) {
            if (z) {
                h.INSTANCE.idkeyStat(338, 117, 1, false);
                AppMethodBeat.o(117394);
                return;
            }
            h.INSTANCE.idkeyStat(338, 122, 1, false);
            AppMethodBeat.o(117394);
        } else if (j2 <= 10000) {
            if (z) {
                h.INSTANCE.idkeyStat(338, 118, 1, false);
                AppMethodBeat.o(117394);
                return;
            }
            h.INSTANCE.idkeyStat(338, 123, 1, false);
            AppMethodBeat.o(117394);
        } else if (j2 <= 30000) {
            if (z) {
                h.INSTANCE.idkeyStat(338, 119, 1, false);
                AppMethodBeat.o(117394);
                return;
            }
            h.INSTANCE.idkeyStat(338, 124, 1, false);
            AppMethodBeat.o(117394);
        } else if (j2 > Util.MILLSECONDS_OF_MINUTE) {
            if (j2 >= Util.MILLSECONDS_OF_HOUR) {
                h.INSTANCE.idkeyStat(338, 133, 1, false);
            }
            if (z) {
                h.INSTANCE.idkeyStat(338, 121, 1, false);
                AppMethodBeat.o(117394);
                return;
            }
            h.INSTANCE.idkeyStat(338, 126, 1, false);
            AppMethodBeat.o(117394);
        } else if (z) {
            h.INSTANCE.idkeyStat(338, 120, 1, false);
            AppMethodBeat.o(117394);
        } else {
            h.INSTANCE.idkeyStat(338, 125, 1, false);
            AppMethodBeat.o(117394);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OS(int i2) {
        AppMethodBeat.i(117395);
        Log.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i2));
        switch (i2) {
            case -8:
                h.INSTANCE.aw(338, 107, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
                break;
            case -7:
                h.INSTANCE.aw(338, 107, 113);
                AppMethodBeat.o(117395);
                return;
            case -6:
                h.INSTANCE.aw(338, 107, 112);
                AppMethodBeat.o(117395);
                return;
            case -5:
                h.INSTANCE.aw(338, 107, 111);
                AppMethodBeat.o(117395);
                return;
            case -4:
                h.INSTANCE.aw(338, 107, 110);
                AppMethodBeat.o(117395);
                return;
            case -3:
                h.INSTANCE.aw(338, 107, 109);
                AppMethodBeat.o(117395);
                return;
            case -2:
                h.INSTANCE.aw(338, 107, 129);
                AppMethodBeat.o(117395);
                return;
            case -1:
                h.INSTANCE.aw(338, 107, 108);
                AppMethodBeat.o(117395);
                return;
        }
        AppMethodBeat.o(117395);
    }

    public static void k(Throwable th) {
        AppMethodBeat.i(117396);
        h.INSTANCE.idkeyStat(338, 104, 1, false);
        h.INSTANCE.e("Tinker", "Tinker Exception:apply tinker occur unknown exception " + MMUncaughtExceptionHandler.getExceptionCauseString(th), null);
        AppMethodBeat.o(117396);
    }

    public static void l(Throwable th) {
        AppMethodBeat.i(117397);
        if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL)) {
            h.INSTANCE.idkeyStat(338, 134, 1, false);
        } else if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL)) {
            h.INSTANCE.idkeyStat(338, 135, 1, false);
            h.INSTANCE.e("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + MMUncaughtExceptionHandler.getExceptionCauseString(th), null);
        } else {
            h.INSTANCE.idkeyStat(338, 105, 1, false);
            h.INSTANCE.e("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + MMUncaughtExceptionHandler.getExceptionCauseString(th), null);
        }
        com.tencent.mm.plugin.hp.c.a.m(th);
        AppMethodBeat.o(117397);
    }

    public static void dYW() {
        AppMethodBeat.i(117398);
        h.INSTANCE.idkeyStat(338, 106, 1, false);
        AppMethodBeat.o(117398);
    }

    public static void dYX() {
        AppMethodBeat.i(117399);
        h.INSTANCE.idkeyStat(338, 116, 1, false);
        AppMethodBeat.o(117399);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OT(int i2) {
        AppMethodBeat.i(117400);
        switch (i2) {
            case 1:
                h.INSTANCE.idkeyStat(338, 130, 1, false);
                AppMethodBeat.o(117400);
                return;
            case 3:
                h.INSTANCE.idkeyStat(338, 114, 1, false);
                AppMethodBeat.o(117400);
                return;
            case 5:
                h.INSTANCE.idkeyStat(338, 115, 1, false);
                AppMethodBeat.o(117400);
                return;
            case 6:
                h.INSTANCE.idkeyStat(338, 132, 1, false);
                AppMethodBeat.o(117400);
                return;
            case 7:
                h.INSTANCE.idkeyStat(338, 136, 1, false);
                break;
        }
        AppMethodBeat.o(117400);
    }

    public static void D(long j2, boolean z) {
        AppMethodBeat.i(117401);
        h.INSTANCE.idkeyStat(338, 4, 1, false);
        if (!z) {
            h.INSTANCE.idkeyStat(338, 159, 1, false);
            AppMethodBeat.o(117401);
            return;
        }
        Log.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", Long.valueOf(j2));
        if (j2 < 0) {
            Log.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
            AppMethodBeat.o(117401);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.hp.tinker.b ii = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION);
            SharedPreferences dZh = com.tencent.mm.plugin.hp.tinker.b.dZh();
            String OW = ii.OW(3);
            if (!dZh.contains(OW)) {
                ii.aq(3, j2);
                dZh.edit().putLong(OW, j2).commit();
            }
        }
        if (j2 <= 500) {
            h.INSTANCE.idkeyStat(338, 177, 1, false);
            AppMethodBeat.o(117401);
        } else if (j2 <= 1000) {
            h.INSTANCE.idkeyStat(338, 178, 1, false);
            AppMethodBeat.o(117401);
        } else if (j2 <= 3000) {
            h.INSTANCE.idkeyStat(338, 179, 1, false);
            AppMethodBeat.o(117401);
        } else if (j2 <= 5000) {
            h.INSTANCE.idkeyStat(338, 180, 1, false);
            AppMethodBeat.o(117401);
        } else {
            h.INSTANCE.idkeyStat(338, 181, 1, false);
            AppMethodBeat.o(117401);
        }
    }

    public static void a(Throwable th, int i2) {
        boolean z = false;
        AppMethodBeat.i(117402);
        switch (i2) {
            case -4:
                h.INSTANCE.idkeyStat(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains(ShareConstants.CHECK_RES_INSTALL_FAIL)) {
                    h.INSTANCE.idkeyStat(338, 184, 1, false);
                    break;
                } else {
                    h.INSTANCE.idkeyStat(338, 190, 1, false);
                    z = true;
                    break;
                }
            case -2:
                if (!th.getMessage().contains(ShareConstants.CHECK_DEX_INSTALL_FAIL)) {
                    h.INSTANCE.idkeyStat(338, 161, 1, false);
                    Log.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                } else {
                    h.INSTANCE.idkeyStat(338, 189, 1, false);
                    Log.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                    z = true;
                    break;
                }
            case -1:
                h.INSTANCE.idkeyStat(338, 160, 1, false);
                break;
        }
        if (!z) {
            String exceptionCauseString = MMUncaughtExceptionHandler.getExceptionCauseString(th);
            if (i2 == -4) {
                Context context = MMApplicationContext.getContext();
                String checkTinkerLastUncaughtCrash = SharePatchFileUtil.checkTinkerLastUncaughtCrash(context);
                if (!ShareTinkerInternals.isNullOrNil(checkTinkerLastUncaughtCrash)) {
                    exceptionCauseString = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(checkTinkerLastUncaughtCrash));
                    SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(context));
                }
            }
            h.INSTANCE.e("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(exceptionCauseString)), null);
        }
        AppMethodBeat.o(117402);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void K(boolean z, int i2) {
        AppMethodBeat.i(117403);
        Log.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i2));
        if (z) {
            h.INSTANCE.idkeyStat(338, 170, 1, false);
        }
        switch (i2) {
            case -8:
                h.INSTANCE.aw(338, 169, 186);
                break;
            case -7:
                h.INSTANCE.aw(338, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                AppMethodBeat.o(117403);
                return;
            case -6:
                h.INSTANCE.aw(338, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
                AppMethodBeat.o(117403);
                return;
            case -5:
                h.INSTANCE.aw(338, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
                AppMethodBeat.o(117403);
                return;
            case -4:
                h.INSTANCE.aw(338, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
                AppMethodBeat.o(117403);
                return;
            case -3:
                h.INSTANCE.aw(338, 169, 172);
                AppMethodBeat.o(117403);
                return;
            case -2:
                h.INSTANCE.aw(338, 107, 182);
                AppMethodBeat.o(117403);
                return;
            case -1:
                h.INSTANCE.aw(338, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1);
                AppMethodBeat.o(117403);
                return;
        }
        AppMethodBeat.o(117403);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OU(int i2) {
        AppMethodBeat.i(117404);
        switch (i2) {
            case 1:
                h.INSTANCE.idkeyStat(338, 166, 1, false);
                AppMethodBeat.o(117404);
                return;
            case 2:
                h.INSTANCE.idkeyStat(338, 167, 1, false);
                AppMethodBeat.o(117404);
                return;
            case 3:
                h.INSTANCE.idkeyStat(338, 164, 1, false);
                AppMethodBeat.o(117404);
                return;
            case 4:
                h.INSTANCE.idkeyStat(338, 183, 1, false);
                AppMethodBeat.o(117404);
                return;
            case 5:
                h.INSTANCE.idkeyStat(338, 165, 1, false);
                AppMethodBeat.o(117404);
                return;
            case 6:
                h.INSTANCE.idkeyStat(338, 187, 1, false);
                break;
        }
        AppMethodBeat.o(117404);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void OV(int i2) {
        AppMethodBeat.i(117405);
        switch (i2) {
            case 3:
                h.INSTANCE.idkeyStat(338, 162, 1, false);
                AppMethodBeat.o(117405);
                return;
            case 5:
                h.INSTANCE.idkeyStat(338, 163, 1, false);
                AppMethodBeat.o(117405);
                return;
            case 6:
                h.INSTANCE.idkeyStat(338, 185, 1, false);
                break;
        }
        AppMethodBeat.o(117405);
    }

    public static void dYY() {
        AppMethodBeat.i(117406);
        h.INSTANCE.idkeyStat(338, 168, 1, false);
        AppMethodBeat.o(117406);
    }

    public static void dYZ() {
        AppMethodBeat.i(117407);
        h.INSTANCE.idkeyStat(338, 5, 1, false);
        AppMethodBeat.o(117407);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, Throwable th) {
        AppMethodBeat.i(117408);
        switch (i2) {
            case 0:
                h.INSTANCE.idkeyStat(338, 193, 1, false);
                break;
            case 1:
                h.INSTANCE.idkeyStat(338, 191, 1, false);
                h.INSTANCE.e("Tinker", "Tinker Exception:interpret occur instruction exception " + MMUncaughtExceptionHandler.getExceptionCauseString(th), null);
                AppMethodBeat.o(117408);
                return;
            case 2:
                h.INSTANCE.idkeyStat(338, 192, 1, false);
                h.INSTANCE.e("Tinker", "Tinker Exception:interpret occur command exception " + MMUncaughtExceptionHandler.getExceptionCauseString(th), null);
                AppMethodBeat.o(117408);
                return;
        }
        AppMethodBeat.o(117408);
    }

    /* renamed from: com.tencent.mm.plugin.hp.b.b$b  reason: collision with other inner class name */
    public enum EnumC1436b {
        SCENE_PATCH(0),
        SCENE_LOAD(1),
        SCENE_CHECK(2);
        
        public final int value;

        public static EnumC1436b valueOf(String str) {
            AppMethodBeat.i(117385);
            EnumC1436b bVar = (EnumC1436b) Enum.valueOf(EnumC1436b.class, str);
            AppMethodBeat.o(117385);
            return bVar;
        }

        static {
            AppMethodBeat.i(117386);
            AppMethodBeat.o(117386);
        }

        private EnumC1436b(int i2) {
            this.value = i2;
        }
    }

    public enum a {
        FAILED(0),
        SUCCESS(1);
        
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(117382);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(117382);
            return aVar;
        }

        static {
            AppMethodBeat.i(117383);
            AppMethodBeat.o(117383);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static void e(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(117409);
        h.INSTANCE.a(15974, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE);
        Log.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(117409);
    }
}
