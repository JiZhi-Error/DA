package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;

public final class i {
    public a Akw;
    private h Akx = new h() {
        /* class com.tencent.mm.plugin.music.model.i.AnonymousClass1 */

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            return null;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            AppMethodBeat.i(63009);
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            Log.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", objArr);
            final com.tencent.mm.plugin.music.model.e.a aVar = (com.tencent.mm.plugin.music.model.e.a) view.getTag();
            if (!(bVar.bitmap == null || aVar == null)) {
                i.this.a(aVar, bVar.bitmap);
                final int[] aK = ao.aK(bVar.bitmap);
                if (!aVar.G(aK)) {
                    o.euD().aw(aVar.field_musicId, aK[0], aK[1]);
                }
                if (i.this.Akw != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.music.model.i.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(63008);
                            i.this.Akw.a(aVar, aK);
                            AppMethodBeat.o(63008);
                        }
                    });
                }
            }
            AppMethodBeat.o(63009);
        }
    };
    public MMHandler Aky = new MMHandler(Looper.getMainLooper());
    public f<String, Bitmap> gnw = new com.tencent.mm.memory.a.b(5, getClass());

    public interface a {
        void a(com.tencent.mm.plugin.music.model.e.a aVar, int[] iArr);
    }

    public i() {
        AppMethodBeat.i(63011);
        AppMethodBeat.o(63011);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.music.model.e.a r7, com.tencent.mm.pluginsdk.ui.applet.CdnImageView r8, android.content.Context r9, boolean r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 584
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.model.i.a(com.tencent.mm.plugin.music.model.e.a, com.tencent.mm.pluginsdk.ui.applet.CdnImageView, android.content.Context, boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, Bitmap bitmap) {
        AppMethodBeat.i(63013);
        Log.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", aVar.field_musicId);
        this.gnw.put(aVar.field_musicId, bitmap);
        AppMethodBeat.o(63013);
    }

    class b implements Runnable {
        com.tencent.mm.plugin.music.model.e.a AkC;

        b(com.tencent.mm.plugin.music.model.e.a aVar) {
            this.AkC = aVar;
        }

        public final void run() {
            AppMethodBeat.i(63010);
            cnb cnb = new cnb();
            cnb.Id = this.AkC.field_songMediaId;
            cnb.Msz = this.AkC.field_songAlbumUrl;
            cnb.MsA = this.AkC.field_songAlbumType;
            cnb.Url = cnb.Msz;
            Bitmap b2 = o.DCM.b(cnb);
            if (b2 != null) {
                Bitmap fastblur = BitmapUtil.fastblur(b2, 10);
                i.this.a(this.AkC, fastblur);
                int[] aK = ao.aK(fastblur);
                if (!this.AkC.G(aK)) {
                    this.AkC = o.euD().aw(this.AkC.field_musicId, aK[0], aK[1]);
                }
                if (!(i.this.Akw == null || this.AkC == null)) {
                    i.this.Akw.a(this.AkC, aK);
                }
            }
            AppMethodBeat.o(63010);
        }
    }
}
