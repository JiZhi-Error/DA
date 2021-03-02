package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import java.util.HashMap;
import java.util.LinkedList;

public final class g {
    protected HashMap<String, Long> Pyp = new HashMap<>();
    private QueueWorkerThread iOL = new QueueWorkerThread(1, "chatting-image-gallery-preload-loader");
    private int mScrollState = 0;
    protected f<String, Bitmap> xqj = new b(4, new f.b<String, Bitmap>() {
        /* class com.tencent.mm.ui.chatting.gallery.g.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(36074);
            g.this.Pyp.remove(str);
            AppMethodBeat.o(36074);
        }
    }, getClass());
    public LinkedList<String> xql = new LinkedList<>();
    private boolean xqn = false;

    public g() {
        AppMethodBeat.i(36076);
        AppMethodBeat.o(36076);
    }

    public static final class a {
        public static g Pyr = new g();

        static {
            AppMethodBeat.i(36075);
            AppMethodBeat.o(36075);
        }
    }

    public final void dSj() {
        AppMethodBeat.i(36077);
        this.xqj.a(new f.a<String, Bitmap>() {
            /* class com.tencent.mm.ui.chatting.gallery.g.AnonymousClass2 */
        });
        AppMethodBeat.o(36077);
    }
}
