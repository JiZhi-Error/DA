package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> DoK = new com.tencent.mm.memory.a.c(24);
    private Bitmap DoL;

    public abstract void s(String str, Bitmap bitmap);

    public final Bitmap z(String str, String str2, boolean z) {
        if (Util.isNullOrNil(str)) {
            return eVX();
        }
        Bitmap bitmap = this.DoK.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        a aVar = new a((byte) 0);
        aVar.key = str;
        aVar.path = str2;
        aVar.DoM = z;
        aVar.DoN = new WeakReference<>(this);
        if (z) {
            bg.aAk().postToWorker(aVar);
        } else {
            aVar.run();
            Bitmap bitmap2 = this.DoK.get(str);
            if (bitmap2 != null) {
                return bitmap2;
            }
        }
        return eVX();
    }

    private Bitmap eVX() {
        if (this.DoL == null) {
            this.DoL = BitmapUtil.getBitmapNative((int) R.raw.panel_icon_pic);
        }
        return this.DoL;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Runnable {
        boolean DoM;
        WeakReference<c> DoN;
        String key;
        String path;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(28693);
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(this.path);
            c cVar = this.DoN.get();
            if (cVar != null) {
                if (!Util.isNullOrNil(this.key) && bitmapNative != null) {
                    cVar.DoK.put(this.key, bitmapNative);
                }
                b bVar = new b((byte) 0);
                bVar.key = this.key;
                bVar.xqp = bitmapNative;
                bVar.DoN = this.DoN;
                if (this.DoM) {
                    MMHandlerThread.postToMainThread(bVar);
                }
            }
            AppMethodBeat.o(28693);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Runnable {
        WeakReference<c> DoN;
        String key;
        Bitmap xqp;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(28694);
            c cVar = this.DoN.get();
            if (cVar != null) {
                cVar.s(this.key, this.xqp);
            }
            AppMethodBeat.o(28694);
        }
    }
}
