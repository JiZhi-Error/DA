package com.tencent.mm.p;

import android.content.Context;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class a {
    public static int gRa = -1;
    public static final long[] gRb = {17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L};
    public static final long[] gRc = {DownloadHelper.SAVE_LENGTH, 314572800, 314572800, 314572800, 314572800};

    public static int ats() {
        long j2;
        int i2;
        AppMethodBeat.i(150029);
        long j3 = 0;
        long j4 = 0;
        double d2 = 0.0d;
        try {
            StatFs statFs = new StatFs(g.getDataDirectory().getPath());
            j3 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            j2 = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            j4 = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
            d2 = ((double) j3) / ((double) j2);
        } catch (Exception e2) {
            j2 = 0;
            Log.e("MicroMsg.DbChecker", "get db spare space error");
        }
        if (j2 > 0) {
            if (j3 < 52428800) {
                i2 = 2;
            } else {
                if (gRa < 0) {
                    gRa = gRb.length - 1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= gRb.length) {
                            break;
                        } else if (j2 < gRb[i3]) {
                            gRa = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (j3 < gRc[gRa]) {
                    i2 = 1;
                }
            }
            Log.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j4), Double.valueOf(d2), Integer.valueOf(gRa));
            AppMethodBeat.o(150029);
            return i2;
        }
        i2 = 0;
        Log.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j4), Double.valueOf(d2), Integer.valueOf(gRa));
        AppMethodBeat.o(150029);
        return i2;
    }

    public static void b(Context context, long j2) {
        AppMethodBeat.i(150030);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("db_check_tip_time", j2).commit();
        AppMethodBeat.o(150030);
    }
}
