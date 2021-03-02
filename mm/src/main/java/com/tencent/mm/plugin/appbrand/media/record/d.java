package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    public static final Long duO = 259200000L;
    public static final Long duQ = Long.valueOf((long) Util.MILLSECONDS_OF_DAY);
    public static final Long duR = 43200000L;
    public static final Long duS = 240000L;
    private static List<String> duV = new ArrayList(10);
    public static long duW = 0;
    public static final Long ndq = Long.valueOf((long) Util.MILLSECONDS_OF_MINUTE);
    public static final Long ndr = duQ;

    static {
        AppMethodBeat.i(146323);
        AppMethodBeat.o(146323);
    }

    public static void bOU() {
        AppMethodBeat.i(146320);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - duW <= ndr.longValue()) {
            Log.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
            AppMethodBeat.o(146320);
            return;
        }
        Log.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
        duW = currentTimeMillis;
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.media.record.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(146319);
                d.access$000();
                AppMethodBeat.o(146319);
            }
        }, "AudioRecordCacheClean");
        AppMethodBeat.o(146320);
    }

    static /* synthetic */ void access$000() {
        boolean z;
        AppMethodBeat.i(146322);
        Log.i("MicroMsg.Record.AudioRecordCacheClean", "clean audio record file");
        o oVar = new o(b.aKJ(), "AudioRecord");
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.i("MicroMsg.Record.AudioRecordCacheClean", "AudioRecord is not exist or not Directory");
            AppMethodBeat.o(146322);
            return;
        }
        String[] list = oVar.list();
        if (list == null || list.length == 0) {
            Log.i("MicroMsg.Record.AudioRecordCacheClean", "none files exist");
            AppMethodBeat.o(146322);
            return;
        }
        for (String str : list) {
            Iterator<String> it = duV.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.contains(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                Log.i("MicroMsg.Record.AudioRecordCacheClean", "file is the block file, don't delete");
            } else {
                o oVar2 = new o(oVar + FilePathGenerator.ANDROID_DIR_SEP + str);
                if (!oVar2.exists()) {
                    Log.i("MicroMsg.Record.AudioRecordCacheClean", "file not exist");
                } else if (oVar2.isDirectory()) {
                    Log.i("MicroMsg.Record.AudioRecordCacheClean", "file is directory, don't delete");
                } else if (System.currentTimeMillis() - oVar2.lastModified() > duO.longValue()) {
                    Log.e("MicroMsg.Record.AudioRecordCacheClean", "Clean 3 days file in record file name=%s, path:%s", oVar2.getName(), aa.z(oVar2.her()));
                    oVar2.delete();
                } else {
                    Log.i("MicroMsg.Record.AudioRecordCacheClean", "not delete the file, file is in valid time for 3 day");
                }
            }
        }
        AppMethodBeat.o(146322);
    }
}
