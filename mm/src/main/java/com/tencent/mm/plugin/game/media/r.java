package com.tencent.mm.plugin.game.media;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.SoftReference;

public class r {
    private static final f<String, Bitmap> gnw = new b(100, r.class);

    static {
        AppMethodBeat.i(41178);
        AppMethodBeat.o(41178);
    }

    public static Bitmap aAa(String str) {
        boolean z;
        AppMethodBeat.i(41176);
        Bitmap aT = gnw.aT(str);
        if (aT == null || aT.isRecycled()) {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
            if (createVideoThumbnail == null || createVideoThumbnail.isRecycled()) {
                AppMethodBeat.o(41176);
                return null;
            }
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(createVideoThumbnail, 537, 402, 2);
            Object[] objArr = new Object[1];
            if (gnw.put(str, extractThumbnail) == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.SimpleVideoAnalyzer", "createVideoThumbail, too big size = %b", objArr);
            AppMethodBeat.o(41176);
            return extractThumbnail;
        }
        AppMethodBeat.o(41176);
        return aT;
    }

    public static void i(ImageView imageView, final String str) {
        AppMethodBeat.i(41177);
        Bitmap bitmap = gnw.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, not from cache, size = %d", Integer.valueOf(gnw.size()));
            final SoftReference softReference = new SoftReference(imageView);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.r.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
                    r0 = (android.widget.ImageView) r0.get();
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r4 = this;
                        r3 = 41175(0xa0d7, float:5.7698E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                        java.lang.String r0 = r7
                        android.graphics.Bitmap r1 = com.tencent.mm.plugin.game.media.r.aAa(r0)
                        if (r1 == 0) goto L_0x002a
                        boolean r0 = r1.isRecycled()
                        if (r0 != 0) goto L_0x002a
                        java.lang.ref.SoftReference r0 = r0
                        if (r0 == 0) goto L_0x002a
                        java.lang.ref.SoftReference r0 = r0
                        java.lang.Object r0 = r0.get()
                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                        if (r0 == 0) goto L_0x002a
                        com.tencent.mm.plugin.game.media.r$1$1 r2 = new com.tencent.mm.plugin.game.media.r$1$1
                        r2.<init>(r0, r1)
                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                    L_0x002a:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.media.r.AnonymousClass1.run():void");
                }
            });
            AppMethodBeat.o(41177);
            return;
        }
        Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, from cache");
        imageView.setImageBitmap(bitmap);
        AppMethodBeat.o(41177);
    }
}
