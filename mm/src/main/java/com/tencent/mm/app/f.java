package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;

public final class f {
    private static final String dkw = (ar.NSe + "channel_history.cfg");

    static {
        AppMethodBeat.i(19439);
        AppMethodBeat.o(19439);
    }

    public static void Wh() {
        AppMethodBeat.i(19437);
        if (!Wi()) {
            Log.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
            AppMethodBeat.o(19437);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile dB = s.dB(dkw, true);
            long length = dB.length();
            Log.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", Long.valueOf(length), Integer.valueOf(ChannelUtil.channelId));
            if (length <= 0) {
                Log.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                if (dB != null) {
                    try {
                        dB.close();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", "");
                        AppMethodBeat.o(19437);
                        return;
                    }
                }
                AppMethodBeat.o(19437);
                return;
            }
            String readLine = dB.readLine();
            int i2 = ChannelUtil.channelId;
            int i3 = ChannelUtil.channelId;
            ChannelUtil.historyChannelId = ChannelUtil.channelId;
            String str = "";
            if (!Util.isNullOrNil(readLine)) {
                str = str + readLine + ",";
                i3 = Util.getInt(readLine, 0);
                if (i3 != ChannelUtil.channelId) {
                    ChannelUtil.historyChannelId = i3;
                    Log.i("MicroMsg.ChannelHistory", "real correct final channelid: " + ChannelUtil.channelId);
                }
            }
            if (MMApplicationContext.sIsRevChange) {
                while (true) {
                    String readLine2 = dB.readLine();
                    if (Util.isNullOrNil(readLine2)) {
                        break;
                    }
                    str = str + readLine2 + ",";
                    i3 = Util.getInt(readLine2, 0);
                }
                Log.i("MicroMsg.ChannelHistory", "channel list: %s", str);
                if (i3 != i2) {
                    dB.seek(length);
                    dB.write(String.format("%d\n", Integer.valueOf(i2)).getBytes());
                    Log.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", Integer.valueOf(i3), Integer.valueOf(i2));
                }
            }
            if (dB != null) {
                try {
                    dB.close();
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.ChannelHistory", e3, "Close ChannelHistory History file failed.", "");
                    AppMethodBeat.o(19437);
                    return;
                }
            }
            AppMethodBeat.o(19437);
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Open ChannelHistory History file failed.", "");
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Close ChannelHistory History file failed.", "");
                    AppMethodBeat.o(19437);
                    return;
                }
            }
            AppMethodBeat.o(19437);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                    Log.printErrStackTrace("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", "");
                }
            }
            AppMethodBeat.o(19437);
            throw th;
        }
    }

    private static boolean Wi() {
        AppMethodBeat.i(19438);
        boolean exists = new o(dkw).exists();
        AppMethodBeat.o(19438);
        return exists;
    }

    public static void bF(Context context) {
        AppMethodBeat.i(19436);
        ChannelUtil.setupChannelId(context);
        try {
            a fO = a.fO(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(fO == null || fO.djf == null)) {
                Log.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (fO.djf.channelId != 0) {
                    ChannelUtil.channelId = fO.djf.channelId;
                    Log.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            Log.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", e3.getMessage());
        }
        Log.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", Integer.valueOf(ChannelUtil.channelId), MMApplicationContext.getProcessName());
        if (!Wi()) {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = s.dB(dkw, true);
                randomAccessFile.write(String.format("%d\n", Integer.valueOf(ChannelUtil.channelId)).getBytes());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", "");
                    }
                }
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                        Log.printErrStackTrace("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", "");
                    }
                }
            } catch (Throwable th) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e7) {
                        Log.printErrStackTrace("MicroMsg.ChannelHistory", e7, "Close ChannelHistory History file failed.", "");
                    }
                }
                AppMethodBeat.o(19436);
                throw th;
            }
        }
        d cg = d.cg(context);
        if (!(cg == null || cg.glq == -1)) {
            ChannelUtil.channelId = cg.glq;
        }
        AppMethodBeat.o(19436);
    }
}
