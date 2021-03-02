package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class ai {
    private static ConcurrentHashMap<String, Bitmap> CHs = new ConcurrentHashMap<>();
    public static final ai CHt = new ai();

    static {
        AppMethodBeat.i(120966);
        AppMethodBeat.o(120966);
    }

    private ai() {
    }

    public static final void r(String str, Bitmap bitmap) {
        AppMethodBeat.i(120963);
        p.h(str, "path");
        CHs.put(str, bitmap);
        AppMethodBeat.o(120963);
    }

    public static final Bitmap aMD(String str) {
        AppMethodBeat.i(120964);
        p.h(str, "path");
        Bitmap bitmap = CHs.get(str);
        AppMethodBeat.o(120964);
        return bitmap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a CHu = new a();

        static {
            AppMethodBeat.i(120962);
            AppMethodBeat.o(120962);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(120961);
            ai aiVar = ai.CHt;
            ai.eQp();
            AppMethodBeat.o(120961);
        }
    }

    public static final void clear() {
        AppMethodBeat.i(120965);
        h.RTc.aX(a.CHu);
        AppMethodBeat.o(120965);
    }

    public static final /* synthetic */ void eQp() {
        AppMethodBeat.i(120967);
        Enumeration<String> keys = CHs.keys();
        p.g(keys, "key");
        p.h(keys, "$this$iterator");
        n.a aVar = new n.a(keys);
        while (aVar.hasNext()) {
            String str = (String) aVar.next();
            Bitmap bitmap = CHs.get(str);
            if (bitmap != null && !bitmap.isRecycled()) {
                Log.d("MicroMsg.ScanTranslationDataHelper", "alvinluo recycle bitmap %s", str);
                bitmap.recycle();
            }
        }
        CHs.clear();
        AppMethodBeat.o(120967);
    }
}
