package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class d {
    LruCache<String, WeakReference<Bitmap>> cache = new LruCache<>(50);
    Context context;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    QueueWorkerThread ytV = new QueueWorkerThread(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());

    public d(Context context2) {
        AppMethodBeat.i(25637);
        this.context = context2;
        AppMethodBeat.o(25637);
    }

    public final void a(final String str, final String str2, final ImageView imageView) {
        AppMethodBeat.i(25638);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || imageView == null) {
            AppMethodBeat.o(25638);
            return;
        }
        final String in = in(str, str2);
        imageView.setTag(in);
        if (!b(str, str2, imageView)) {
            this.ytV.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.plugin.ipcall.ui.d.AnonymousClass1 */
                private boolean htV = false;

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean doInBackground() {
                    AppMethodBeat.i(25631);
                    Bitmap bd = a.bd(d.this.context, str);
                    if (bd != null) {
                        d.this.cache.put(in, new WeakReference<>(bd));
                        this.htV = true;
                        d.a(d.this, imageView, in, bd);
                    }
                    AppMethodBeat.o(25631);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    AppMethodBeat.i(25632);
                    if (!this.htV) {
                        d dVar = d.this;
                        String str = str;
                        String str2 = str2;
                        dVar.ytV.add(new QueueWorkerThread.ThreadObject(str2, imageView, d.in(str, str2)) {
                            /* class com.tencent.mm.plugin.ipcall.ui.d.AnonymousClass2 */
                            final /* synthetic */ String gtu;
                            final /* synthetic */ ImageView iaq;
                            final /* synthetic */ String val$key;

                            {
                                this.gtu = r2;
                                this.iaq = r3;
                                this.val$key = r4;
                            }

                            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                            public final boolean doInBackground() {
                                AppMethodBeat.i(25633);
                                Bitmap a2 = c.a(this.gtu, false, -1, null);
                                if (a2 == null) {
                                    p.aYn();
                                    a2 = e.Mn(this.gtu);
                                }
                                d.a(d.this, this.iaq, this.val$key, a2);
                                AppMethodBeat.o(25633);
                                return true;
                            }

                            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                            public final boolean onPostExecute() {
                                return false;
                            }
                        });
                    }
                    AppMethodBeat.o(25632);
                    return true;
                }
            });
        }
        AppMethodBeat.o(25638);
    }

    public final void d(final String str, final ImageView imageView) {
        AppMethodBeat.i(25639);
        if (Util.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(25639);
            return;
        }
        final String aCj = aCj(str);
        imageView.setTag(aCj);
        if (!e(str, imageView)) {
            this.ytV.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.plugin.ipcall.ui.d.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean doInBackground() {
                    AppMethodBeat.i(25634);
                    d.a(d.this, imageView, aCj, a.bd(d.this.context, str));
                    AppMethodBeat.o(25634);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    return true;
                }
            });
        }
        AppMethodBeat.o(25639);
    }

    private boolean e(String str, ImageView imageView) {
        AppMethodBeat.i(25640);
        boolean h2 = h(aCj(str), imageView);
        AppMethodBeat.o(25640);
        return h2;
    }

    public final void f(final String str, final ImageView imageView) {
        AppMethodBeat.i(25641);
        if (Util.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(25641);
            return;
        }
        final String aCi = aCi(str);
        imageView.setTag(aCi);
        if (!g(str, imageView)) {
            this.ytV.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.plugin.ipcall.ui.d.AnonymousClass4 */

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean doInBackground() {
                    AppMethodBeat.i(25635);
                    Bitmap a2 = c.a(str, false, -1, null);
                    if (a2 == null) {
                        p.aYn();
                        a2 = e.Mn(str);
                    }
                    d.a(d.this, imageView, aCi, a2);
                    AppMethodBeat.o(25635);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    return false;
                }
            });
        }
        AppMethodBeat.o(25641);
    }

    private boolean g(String str, ImageView imageView) {
        AppMethodBeat.i(25642);
        boolean h2 = h(aCi(str), imageView);
        AppMethodBeat.o(25642);
        return h2;
    }

    private boolean b(String str, String str2, ImageView imageView) {
        AppMethodBeat.i(25643);
        boolean h2 = h(in(str, str2), imageView);
        AppMethodBeat.o(25643);
        return h2;
    }

    private boolean h(String str, ImageView imageView) {
        Bitmap bitmap;
        AppMethodBeat.i(25644);
        WeakReference<Bitmap> weakReference = this.cache.get(str);
        if (weakReference == null || (bitmap = weakReference.get()) == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str)) {
            AppMethodBeat.o(25644);
            return false;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(25644);
        return true;
    }

    private static String aCi(String str) {
        AppMethodBeat.i(25645);
        String str2 = str + "@username";
        AppMethodBeat.o(25645);
        return str2;
    }

    private static String aCj(String str) {
        AppMethodBeat.i(25646);
        String str2 = str + "@contactId";
        AppMethodBeat.o(25646);
        return str2;
    }

    public static String in(String str, String str2) {
        AppMethodBeat.i(25647);
        String str3 = str + "@" + str2 + "@contactId@username";
        AppMethodBeat.o(25647);
        return str3;
    }

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        AppMethodBeat.i(25648);
        if (bitmap != null) {
            dVar.cache.put(str, new WeakReference<>(bitmap));
            dVar.hAk.post(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.d.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(25636);
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(25636);
                }
            });
        }
        AppMethodBeat.o(25648);
    }
}
