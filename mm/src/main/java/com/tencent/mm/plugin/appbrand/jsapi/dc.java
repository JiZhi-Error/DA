package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"TAG", "", "createThumbFile", "Lcom/tencent/mm/vfs/VFSFile;", "videoPath", "getThumbPathWorkaround", "thumbPath", "parseVideoDurationS", "", "plugin-appbrand-integration_release"})
public final class dc {
    public static final String dm(String str, String str2) {
        AppMethodBeat.i(228299);
        p.h(str, "videoPath");
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            o Zk = Zk(str);
            if (Zk != null) {
                String absolutePath = Zk.getAbsolutePath();
                AppMethodBeat.o(228299);
                return absolutePath;
            }
            AppMethodBeat.o(228299);
            return null;
        }
        AppMethodBeat.o(228299);
        return str2;
    }

    public static final int Zj(String str) {
        int i2;
        AppMethodBeat.i(228300);
        p.h(str, "videoPath");
        try {
            d dVar = new d();
            dVar.setDataSource(str);
            long j2 = Util.getLong(dVar.extractMetadata(9), 0);
            dVar.release();
            i2 = Util.videoMsToSec(j2);
        } catch (Exception e2) {
            i2 = 0;
        }
        Log.i("MicroMsg.AppBrand.SendVideoCommons", "parseVideoDurationS, duration: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(228300);
        return i2;
    }

    private static final o Zk(String str) {
        AppMethodBeat.i(228301);
        o oVar = new o(str + ".jpg");
        try {
            Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
            if (PF != null) {
                BitmapUtil.saveBitmapToImage(PF, 100, Bitmap.CompressFormat.JPEG, oVar.getAbsolutePath(), true);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.SendVideoCommons", "createThumbFile, fail since ".concat(String.valueOf(e2)));
            oVar = null;
        }
        AppMethodBeat.o(228301);
        return oVar;
    }
}
