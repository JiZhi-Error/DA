package com.tencent.mm.plugin.gif;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class c {
    private static c ydI;
    f<String, WeakReference<e>> ydJ = new com.tencent.mm.memory.a.c(10);
    f<String, WeakReference<b>> ydK = new com.tencent.mm.memory.a.c(new f.b<String, WeakReference<b>>() {
        /* class com.tencent.mm.plugin.gif.c.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, WeakReference<b> weakReference, WeakReference<b> weakReference2) {
            b bVar;
            AppMethodBeat.i(104584);
            WeakReference<b> weakReference3 = weakReference;
            if (!(weakReference3 == null || (bVar = weakReference3.get()) == null || !(bVar instanceof d))) {
                Log.i("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "recycle bitmap:%s", bVar.toString());
                bVar.recycle();
            }
            AppMethodBeat.o(104584);
        }
    });

    public c() {
        AppMethodBeat.i(104585);
        AppMethodBeat.o(104585);
    }

    public static synchronized c dXx() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(104586);
            if (ydI == null) {
                synchronized (c.class) {
                    try {
                        if (ydI == null) {
                            ydI = new c();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(104586);
                        throw th;
                    }
                }
            }
            cVar = ydI;
            AppMethodBeat.o(104586);
        }
        return cVar;
    }

    public final b aBd(String str) {
        AppMethodBeat.i(104587);
        b bVar = null;
        if (this.ydK.get(str) != null) {
            bVar = this.ydK.get(str).get();
        }
        AppMethodBeat.o(104587);
        return bVar;
    }

    public final b hT(String str, String str2) {
        AppMethodBeat.i(104588);
        b bVar = null;
        if (this.ydK.get(str) != null) {
            bVar = this.ydK.get(str).get();
        }
        if (bVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (ImgUtil.isWXGF(str2)) {
                bVar = new h(str2);
            } else {
                bVar = new d(str2);
            }
            Log.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.ydK.put(str, new WeakReference<>(bVar));
        }
        AppMethodBeat.o(104588);
        return bVar;
    }

    public final b c(Resources resources, int i2) {
        b bVar;
        AppMethodBeat.i(104589);
        if (this.ydK.get(null) != null) {
            bVar = this.ydK.get(null).get();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            bVar = new d(resources, i2);
            this.ydK.put(null, new WeakReference<>(bVar));
        }
        AppMethodBeat.o(104589);
        return bVar;
    }

    public final b s(String str, byte[] bArr) {
        b bVar = null;
        AppMethodBeat.i(104590);
        if (bArr == null) {
            AppMethodBeat.o(104590);
        } else {
            if (this.ydK.get(str) != null) {
                bVar = this.ydK.get(str).get();
            }
            if (bVar == null) {
                if (!ImgUtil.isWXGF(bArr) || !((PluginEmoji) g.ah(PluginEmoji.class)).getEmojiMgr().cFP()) {
                    bVar = new d(bArr);
                } else {
                    bVar = new h(bArr);
                }
                this.ydK.put(str, new WeakReference<>(bVar));
            }
            if (!bVar.isRunning()) {
                bVar.reset();
            }
            AppMethodBeat.o(104590);
        }
        return bVar;
    }
}
