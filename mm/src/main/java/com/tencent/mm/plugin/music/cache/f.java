package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class f implements b {
    private static long duW = 0;
    private List<String> duV = new ArrayList(10);

    public f(List<String> list) {
        AppMethodBeat.i(137172);
        if (!list.isEmpty()) {
            this.duV.addAll(list);
        }
        AppMethodBeat.o(137172);
    }

    private boolean gJ(String str) {
        AppMethodBeat.i(137174);
        for (String str2 : this.duV) {
            if (str.contains(str2)) {
                AppMethodBeat.o(137174);
                return true;
            }
        }
        AppMethodBeat.o(137174);
        return false;
    }

    @Override // com.tencent.mm.plugin.music.cache.b
    public final void etC() {
        long j2 = 0;
        AppMethodBeat.i(137173);
        if (duW == 0) {
            if (e.etK()) {
                j2 = ((c) b.aS(c.class)).etF();
            } else {
                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            }
            duW = j2;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - duW <= AiG.longValue()) {
            Log.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
            AppMethodBeat.o(137173);
            return;
        }
        duW = currentTimeMillis;
        Log.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.cache.f.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(137171);
                long j2 = currentTimeMillis;
                if (e.etK()) {
                    ((c) b.aS(c.class)).Hn(j2);
                }
                f.a(f.this);
                AppMethodBeat.o(137171);
            }
        }, "PieceCacheCleanController");
        AppMethodBeat.o(137173);
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(137175);
        Log.i("MicroMsg.Music.PieceCacheCleanController", "clean music piece file");
        String accPath = e.getAccPath();
        String str = accPath.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? accPath + "music" : accPath + "/music";
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.i("MicroMsg.Music.PieceCacheCleanController", "musicFolder is not exist or not Directory");
            AppMethodBeat.o(137175);
            return;
        }
        String[] list = oVar.list();
        if (list == null || list.length == 0) {
            Log.i("MicroMsg.Music.PieceCacheCleanController", "none files exist");
            AppMethodBeat.o(137175);
            return;
        }
        for (String str2 : list) {
            if (fVar.gJ(str2)) {
                Log.i("MicroMsg.Music.PieceCacheCleanController", "file is the block file, don't delete");
            } else {
                o oVar2 = new o(str + FilePathGenerator.ANDROID_DIR_SEP + str2);
                if (!oVar2.exists()) {
                    Log.i("MicroMsg.Music.PieceCacheCleanController", "file not exist");
                } else if (oVar2.isDirectory()) {
                    Log.i("MicroMsg.Music.PieceCacheCleanController", "file is directory, don't delete");
                } else if (System.currentTimeMillis() - oVar2.lastModified() > duM.longValue()) {
                    Log.e("MicroMsg.Music.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", oVar2.getName(), aa.z(oVar2.her()));
                    oVar2.delete();
                    if (str2.startsWith("piece")) {
                        Log.e("MicroMsg.Music.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
                        if (e.etK()) {
                            ((c) b.aS(c.class)).aHu(str2);
                        }
                    }
                } else {
                    Log.i("MicroMsg.Music.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
                }
            }
        }
        AppMethodBeat.o(137175);
    }
}
