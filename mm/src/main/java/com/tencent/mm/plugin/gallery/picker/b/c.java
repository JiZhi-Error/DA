package com.tencent.mm.plugin.gallery.picker.b;

import android.media.ExifInterface;
import android.support.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/generator/PhotoExifUtil;", "", "()V", "TAG", "", "keepPhotoExifInfo", "", "source", "dst", "plugin-gallery_release"})
public final class c {
    public static final c UXg = new c();

    static {
        AppMethodBeat.i(261889);
        AppMethodBeat.o(261889);
    }

    private c() {
    }

    public static void lm(String str, String str2) {
        AppMethodBeat.i(261888);
        p.h(str, "source");
        p.h(str2, "dst");
        ExifInterface exifInterface = new ExifInterface(s.k(str, false));
        String attribute = exifInterface.getAttribute(a.TAG_GPS_LONGITUDE);
        String attribute2 = exifInterface.getAttribute(a.TAG_GPS_LATITUDE);
        String attribute3 = exifInterface.getAttribute(a.TAG_GPS_LONGITUDE_REF);
        String attribute4 = exifInterface.getAttribute(a.TAG_GPS_LATITUDE_REF);
        String attribute5 = exifInterface.getAttribute(a.TAG_GPS_DEST_LONGITUDE);
        String attribute6 = exifInterface.getAttribute(a.TAG_GPS_DEST_LONGITUDE_REF);
        ExifInterface exifInterface2 = new ExifInterface(s.k(str2, false));
        if (attribute != null) {
            exifInterface2.setAttribute(a.TAG_GPS_LONGITUDE, attribute);
        }
        if (attribute2 != null) {
            exifInterface2.setAttribute(a.TAG_GPS_LATITUDE, attribute2);
        }
        if (attribute3 != null) {
            exifInterface2.setAttribute(a.TAG_GPS_LONGITUDE_REF, attribute3);
        }
        if (attribute4 != null) {
            exifInterface2.setAttribute(a.TAG_GPS_LATITUDE_REF, attribute4);
        }
        if (attribute5 != null) {
            exifInterface2.setAttribute(a.TAG_GPS_DEST_LONGITUDE, attribute5);
        }
        if (attribute6 != null) {
            exifInterface2.setAttribute(a.TAG_GPS_DEST_LONGITUDE_REF, attribute6);
        }
        try {
            exifInterface2.saveAttributes();
            AppMethodBeat.o(261888);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.PhotoExifUtil", e2, "saveAttributes error!", new Object[0]);
            AppMethodBeat.o(261888);
        }
    }
}
