package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Locale;

public final class h {
    MMWebView Jbj;
    public String Jbk;
    c Jbl;
    private MMHandler.Callback Jbm = new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.webview.modeltools.h.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(79188);
            switch (message.what) {
                case 1:
                    Bitmap bitmap = h.this.Jbj.getBitmap();
                    if (bitmap != null) {
                        ThreadPool.post(new b(bitmap), "ViewCaptureHelper_SaveBitmap");
                        h.this.Jbj = null;
                        break;
                    }
                    break;
                case 2:
                    if (h.this.Jbl != null) {
                        h.this.Jbl.abF(h.this.Jbk);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(79188);
            return false;
        }
    };
    MMHandler kAn = new MMHandler(Looper.getMainLooper(), this.Jbm);

    public interface c {
        void abF(String str);
    }

    final class b implements Runnable {
        private Bitmap mBitmap;

        public b(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(79191);
            h.this.Jbk = String.format(Locale.US, "%s%s_%08x.jpg", com.tencent.mm.loader.j.b.aKJ(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()));
            try {
                BitmapUtil.saveBitmapToImage(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.Jbk, true);
            } catch (IOException e2) {
                Log.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e2.getMessage());
                h.this.Jbk = null;
            }
            Log.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", this.mBitmap.toString());
            this.mBitmap.recycle();
            h.this.kAn.sendEmptyMessage(2);
            AppMethodBeat.o(79191);
        }
    }

    public h() {
        AppMethodBeat.i(79192);
        AppMethodBeat.o(79192);
    }

    public final void a(MMWebView mMWebView, c cVar) {
        AppMethodBeat.i(79193);
        this.Jbj = mMWebView;
        this.Jbl = cVar;
        this.kAn.sendEmptyMessage(1);
        AppMethodBeat.o(79193);
    }

    public final void gdA() {
        AppMethodBeat.i(79194);
        ThreadPool.post(new a(this, (byte) 0), "ViewCaptureHelper_DeleteBitmap");
        AppMethodBeat.o(79194);
    }

    /* access modifiers changed from: package-private */
    public final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(79190);
            if (h.this.Jbk == null) {
                AppMethodBeat.o(79190);
                return;
            }
            o[] b2 = new o(h.this.Jbk).heq().b(new w() {
                /* class com.tencent.mm.plugin.webview.modeltools.h.a.AnonymousClass1 */

                @Override // com.tencent.mm.vfs.w
                public final boolean accept(o oVar, String str) {
                    AppMethodBeat.i(211029);
                    boolean matches = str.matches(".+_.+.\\.jpg");
                    AppMethodBeat.o(211029);
                    return matches;
                }
            });
            if (b2 != null) {
                int length = b2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Log.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", Boolean.valueOf(b2[i2].delete()));
                }
            }
            h.this.Jbk = null;
            AppMethodBeat.o(79190);
        }
    }
}
