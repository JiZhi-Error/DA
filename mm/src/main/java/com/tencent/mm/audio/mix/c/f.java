package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static final Long duM = 2592000000L;
    public static final Long duN = 604800000L;
    public static final Long duO = 259200000L;
    public static final Long duP = 172800000L;
    public static final Long duQ = Long.valueOf((long) Util.MILLSECONDS_OF_DAY);
    public static final Long duR = 43200000L;
    public static final Long duS = 240000L;
    public static final Long duT = duQ;
    public static final Long duU = Long.valueOf((long) Util.MILLSECONDS_OF_MINUTE);
    public static long duW = 0;
    public String appId;
    private List<String> duV = new ArrayList(10);

    static {
        AppMethodBeat.i(136779);
        AppMethodBeat.o(136779);
    }

    public f() {
        AppMethodBeat.i(136775);
        AppMethodBeat.o(136775);
    }

    public class a extends j {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.audio.mix.d.j
        public final void run() {
            AppMethodBeat.i(136774);
            f.a(f.this);
            i.b(this);
            AppMethodBeat.o(136774);
        }
    }

    private void gI(String str) {
        AppMethodBeat.i(136776);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", str);
            AppMethodBeat.o(136776);
            return;
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
            AppMethodBeat.o(136776);
            return;
        }
        for (String str2 : list) {
            if (gJ(str2)) {
                b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
            } else {
                String str3 = str + File.separator + str2;
                File file2 = new File(str3);
                if (!file2.exists()) {
                    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
                } else if (file2.isDirectory()) {
                    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete subFilePath:%s", str3);
                    gI(str3);
                } else if (System.currentTimeMillis() - file2.lastModified() > duP.longValue()) {
                    b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", file2.getName(), file2.getAbsolutePath());
                    file2.delete();
                }
            }
        }
        AppMethodBeat.o(136776);
    }

    private boolean gJ(String str) {
        AppMethodBeat.i(136777);
        for (String str2 : this.duV) {
            if (str.contains(str2)) {
                AppMethodBeat.o(136777);
                return true;
            }
        }
        AppMethodBeat.o(136777);
        return false;
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(136778);
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "clean mix convert file");
        fVar.gI(aa.z(com.tencent.mm.audio.mix.i.a.ZW().mUri));
        AppMethodBeat.o(136778);
    }
}
