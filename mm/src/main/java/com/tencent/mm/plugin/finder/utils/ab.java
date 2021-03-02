package com.tencent.mm.plugin.finder.utils;

import android.media.ExifInterface;
import android.support.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.sharp.jni.QLog;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "", "exif", "Landroid/media/ExifInterface;", "(Landroid/media/ExifInterface;)V", "Latitude", "", "getLatitude", "()Ljava/lang/Float;", "setLatitude", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "Longitude", "getLongitude", "setLongitude", "TAG", "", "isValid", "", "()Z", "setValid", "(Z)V", "convertToDegree", "stringDMS", "(Ljava/lang/String;)Ljava/lang/Float;", "toString", "plugin-finder_release"})
public final class ab {
    private final String TAG = "Finder.GeoDegree";
    private boolean daZ;
    Float vYk;
    Float vYl;

    public ab(ExifInterface exifInterface) {
        p.h(exifInterface, "exif");
        AppMethodBeat.i(167973);
        String attribute = exifInterface.getAttribute(a.TAG_GPS_LATITUDE);
        String attribute2 = exifInterface.getAttribute(a.TAG_GPS_LATITUDE_REF);
        String attribute3 = exifInterface.getAttribute(a.TAG_GPS_LONGITUDE);
        String attribute4 = exifInterface.getAttribute(a.TAG_GPS_LONGITUDE_REF);
        if (!(attribute == null || attribute2 == null || attribute3 == null || attribute4 == null)) {
            this.daZ = true;
            if (p.j(attribute2, "N")) {
                this.vYk = awx(attribute);
            } else {
                Float awx = awx(attribute);
                if (awx == null) {
                    p.hyc();
                }
                this.vYk = Float.valueOf(0.0f - awx.floatValue());
            }
            if (p.j(attribute4, QLog.TAG_REPORTLEVEL_USER)) {
                this.vYl = awx(attribute3);
                AppMethodBeat.o(167973);
                return;
            }
            Float awx2 = awx(attribute3);
            if (awx2 == null) {
                p.hyc();
            }
            this.vYl = Float.valueOf(0.0f - awx2.floatValue());
        }
        AppMethodBeat.o(167973);
    }

    private final Float awx(String str) {
        AppMethodBeat.i(167971);
        try {
            Object[] array = new k(",").q(str, 3).toArray(new String[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(167971);
                throw tVar;
            }
            String[] strArr = (String[]) array;
            Object[] array2 = new k(FilePathGenerator.ANDROID_DIR_SEP).q(strArr[0], 2).toArray(new String[0]);
            if (array2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(167971);
                throw tVar2;
            }
            String[] strArr2 = (String[]) array2;
            double parseDouble = Double.parseDouble(strArr2[0]) / Double.parseDouble(strArr2[1]);
            Object[] array3 = new k(FilePathGenerator.ANDROID_DIR_SEP).q(strArr[1], 2).toArray(new String[0]);
            if (array3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(167971);
                throw tVar3;
            }
            String[] strArr3 = (String[]) array3;
            double parseDouble2 = Double.parseDouble(strArr3[0]) / Double.parseDouble(strArr3[1]);
            Object[] array4 = new k(FilePathGenerator.ANDROID_DIR_SEP).q(strArr[2], 2).toArray(new String[0]);
            if (array4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(167971);
                throw tVar4;
            }
            String[] strArr4 = (String[]) array4;
            Float valueOf = Float.valueOf((float) (((Double.parseDouble(strArr4[0]) / Double.parseDouble(strArr4[1])) / 3600.0d) + parseDouble + (parseDouble2 / 60.0d)));
            AppMethodBeat.o(167971);
            return valueOf;
        } catch (Throwable th) {
            Log.printErrStackTrace(this.TAG, th, "convertToDegree", new Object[0]);
            AppMethodBeat.o(167971);
            return null;
        }
    }

    public final String toString() {
        AppMethodBeat.i(167972);
        String str = String.valueOf(this.vYk) + ", " + String.valueOf(this.vYl);
        AppMethodBeat.o(167972);
        return str;
    }
}
