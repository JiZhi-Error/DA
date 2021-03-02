package com.tencent.mm.dynamicbackground.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/dynamicbackground/util/DynamicBgAssetsManager;", "", "()V", "TAG", "", "checkDirectory", "", "context", "Landroid/content/Context;", "copyFileFromAssets", "srcFileName", "dstFileName", "getSavedFileDirectory", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "dynamicbg_release"})
public final class b {
    private static final String TAG = TAG;
    public static final b gRt = new b();

    static {
        AppMethodBeat.i(103093);
        AppMethodBeat.o(103093);
    }

    private b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f A[SYNTHETIC, Splitter:B:21:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8 A[SYNTHETIC, Splitter:B:37:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd A[Catch:{ Exception -> 0x00c4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void j(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.dynamicbackground.a.b.j(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static String cF(Context context) {
        AppMethodBeat.i(103092);
        p.h(context, "context");
        StringBuilder sb = new StringBuilder();
        File filesDir = context.getFilesDir();
        p.g(filesDir, "context.filesDir");
        String sb2 = sb.append(filesDir.getParent()).append(File.separator).append("appbrand/glsl/").toString();
        AppMethodBeat.o(103092);
        return sb2;
    }
}
