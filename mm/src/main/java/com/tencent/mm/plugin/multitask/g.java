package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J&\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskKeyUtil;", "", "()V", "TAG", "", "generateMultiImageCacheKey", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "generateMultiTaskKeyForAppBrand", "appId", "versionType", "", "generateMultiTaskKeyForAppBrandLocation", "generateMultiTaskKeyForAppBrandVOIP", "generateMultiTaskKeyForFiles", "filePath", "generateMultiTaskKeyForGameDownload", "generateMultiTaskKeyForHome", "generateMultiTaskKeyForLive", "generateMultiTaskKeyForMinusScreen", "generateMultiTaskKeyForMoreWebPage", "rawUrl", "generateMultiTaskKeyForMusic", "songName", "singer", FFmpegMetadataRetriever.METADATA_KEY_ALBUM, "generateMultiTaskKeyForSnapShotMinusScreen", "generateMultiTaskKeyForTopStoryHorizontal", "generateMultiTaskKeyForTopStoryVertical", "generateMultiTaskKeyForVOIP", "generateMultiTaskKeyForWebPage", "plugin-multitask_release"})
public final class g {
    public static final g zZj = new g();

    static {
        AppMethodBeat.i(200296);
        AppMethodBeat.o(200296);
    }

    private g() {
    }

    public static final String az(String str, String str2, String str3) {
        AppMethodBeat.i(200290);
        ae aeVar = ae.SYK;
        String format = String.format("%s_%s_%s", Arrays.copyOf(new Object[]{str, str2, str3}, 3));
        p.g(format, "java.lang.String.format(format, *args)");
        String mD5String = MD5Util.getMD5String(format);
        p.g(mD5String, "MD5Util.getMD5String(Str…songName, singer, album))");
        AppMethodBeat.o(200290);
        return mD5String;
    }

    public static final String aGG(String str) {
        AppMethodBeat.i(200291);
        ae aeVar = ae.SYK;
        String format = String.format("%s", Arrays.copyOf(new Object[]{str}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        String mD5String = MD5Util.getMD5String(format);
        p.g(mD5String, "MD5Util.getMD5String(String.format(\"%s\", rawUrl))");
        AppMethodBeat.o(200291);
        return mD5String;
    }

    public static final String aGH(String str) {
        AppMethodBeat.i(200292);
        ae aeVar = ae.SYK;
        String format = String.format("%s#%s", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), str}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        String mD5String = MD5Util.getMD5String(format);
        p.g(mD5String, "MD5Util.getMD5String(Str…entTimeMillis(), rawUrl))");
        AppMethodBeat.o(200292);
        return mD5String;
    }

    public static final String eP(String str, int i2) {
        AppMethodBeat.i(200293);
        ae aeVar = ae.SYK;
        Locale locale = Locale.US;
        p.g(locale, "Locale.US");
        String format = String.format(locale, "%s#%d", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2)}, 2));
        p.g(format, "java.lang.String.format(locale, format, *args)");
        AppMethodBeat.o(200293);
        return format;
    }

    public static final String aGI(String str) {
        AppMethodBeat.i(200294);
        ae aeVar = ae.SYK;
        String format = String.format("%s", Arrays.copyOf(new Object[]{str}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        String mD5String = MD5Util.getMD5String(format);
        p.g(mD5String, "MD5Util.getMD5String(Str…g.format(\"%s\", filePath))");
        AppMethodBeat.o(200294);
        return mD5String;
    }

    public static String eqw() {
        return "MultiTaskForMinusScreen";
    }

    public static String eqx() {
        return "MultiTaskForSnapshotMinusScreen";
    }

    public static String e(String str, c cVar) {
        AppMethodBeat.i(200295);
        p.h(str, "path");
        p.h(cVar, "imageLoaderOptions");
        if (cVar.bdl()) {
            str = str + "round" + cVar.bdm();
        }
        if (!Util.isNullOrNil(cVar.bdn())) {
            str = str + cVar.bdn();
        }
        String str2 = str + "size" + cVar.bdj() + cVar.bdk();
        AppMethodBeat.o(200295);
        return str2;
    }

    public static String eqy() {
        return "Home";
    }
}
