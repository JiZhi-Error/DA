package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.a.j;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "", "name", "", "width", "", "height", "durationMs", "", "thumbPath", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "getFilePath", "Companion", "plugin-mv_release"})
public final class a {
    private static final String Apg;
    private static int Aph = -1;
    private static final List<a> Api = j.listOf(new a("mv_default_bg_video.mp4"));
    public static final C1542a Apj = new C1542a((byte) 0);
    private static final String TAG = TAG;
    public long durationMs;
    public final int height;
    public final String name;
    String thumbPath;
    public final int width;

    private /* synthetic */ a(String str) {
        this(str, "");
        AppMethodBeat.i(256745);
        AppMethodBeat.o(256745);
    }

    private a(String str, String str2) {
        p.h(str, "name");
        p.h(str2, "thumbPath");
        AppMethodBeat.i(256744);
        this.name = str;
        this.width = c.CTRL_INDEX;
        this.height = 1080;
        this.durationMs = 5000;
        this.thumbPath = str2;
        AppMethodBeat.o(256744);
    }

    public final String getFilePath() {
        AppMethodBeat.i(256743);
        String str = Apg + FilePathGenerator.ANDROID_DIR_SEP + this.name;
        AppMethodBeat.o(256743);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo$Companion;", "", "()V", "DefaultVideos", "", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "getDefaultVideos", "()Ljava/util/List;", "MusicDefaultVideoRoot", "", "getMusicDefaultVideoRoot", "()Ljava/lang/String;", "TAG", "lastRandomIndex", "", "checkCopyAssets", "", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", k.NAME, "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.a.a$a  reason: collision with other inner class name */
    public static final class C1542a {
        private C1542a() {
        }

        public /* synthetic */ C1542a(byte b2) {
            this();
        }

        public static void a(AssetManager assetManager, String str, String str2) {
            Throwable th;
            Throwable th2;
            Throwable th3;
            Throwable th4 = null;
            AppMethodBeat.i(256742);
            Log.i(a.TAG, "copyAssets: assetsPath:" + str + " localPath:" + str2);
            try {
                String[] list = assetManager.list(str);
                if (list == null) {
                    AppMethodBeat.o(256742);
                    return;
                }
                p.g(list, "assets.list(assetsPath) ?: return");
                if (list.length == 0) {
                    InputStream open = assetManager.open(str);
                    try {
                        InputStream inputStream = open;
                        OutputStream LM = s.LM(str2);
                        try {
                            OutputStream outputStream = LM;
                            p.g(inputStream, "input");
                            p.g(outputStream, "output");
                            kotlin.f.a.f(inputStream, outputStream);
                            b.a(LM, null);
                            b.a(open, null);
                            AppMethodBeat.o(256742);
                        } catch (Throwable th5) {
                            th2 = th5;
                            th3 = th;
                            b.a(LM, th3);
                            AppMethodBeat.o(256742);
                            throw th2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th4 = th;
                        b.a(open, th4);
                        AppMethodBeat.o(256742);
                        throw th;
                    }
                } else {
                    s.boN(str2);
                    for (String str3 : list) {
                        C1542a aVar = a.Apj;
                        a(assetManager, str + '/' + str3, str2 + '/' + str3);
                    }
                    AppMethodBeat.o(256742);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, "copyAssets", new Object[0]);
                AppMethodBeat.o(256742);
            }
        }
    }

    static {
        AppMethodBeat.i(256746);
        StringBuilder sb = new StringBuilder();
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Apg = sb.append(context.getCacheDir().toString()).append("/mv_video").toString();
        AppMethodBeat.o(256746);
    }
}
