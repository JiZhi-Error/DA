package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.vlog.model.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class d extends b {
    public static final a GBG = new a((byte) 0);
    private Bitmap GBF;

    static {
        AppMethodBeat.i(110972);
        AppMethodBeat.o(110972);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(int i2, int i3, int i4, q qVar) {
        super(i2, i3, i4, qVar);
        p.h(qVar, "material");
        AppMethodBeat.i(110971);
        AppMethodBeat.o(110971);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void O(long j2, boolean z) {
        Bitmap bitmap;
        AppMethodBeat.i(110968);
        if (!z || (bitmap = this.GBF) == null) {
            AppMethodBeat.o(110968);
            return;
        }
        Log.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + bitmap + ", width:" + bitmap.getWidth() + ", height:" + bitmap.getHeight());
        c.a aVar = c.ilt;
        c.a.c(bitmap, this.Gxi);
        bitmap.recycle();
        this.GBF = null;
        AppMethodBeat.o(110968);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void resume() {
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void wC(boolean z) {
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void prepare() {
        this.bcY = true;
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void KV(long j2) {
        Object[] objArr;
        Bitmap bitmap;
        android.support.e.a aVar;
        Throwable th;
        Bitmap bitmap2;
        Integer num = null;
        Throwable th2 = null;
        AppMethodBeat.i(183779);
        if (this.GBl) {
            AppMethodBeat.o(183779);
            return;
        }
        this.GBl = true;
        e eVar = e.GBH;
        a aUf = e.aUf(this.GBm.path);
        if (aUf != null) {
            Log.i("MicroMsg.VLogImagePlayer", "prepare get info from cache");
            this.width = aUf.width;
            this.height = aUf.height;
            this.dYT = aUf.dYT;
            objArr = 1;
        } else {
            objArr = null;
        }
        if (objArr == null || this.GBF == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.GBm.path, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            options.inSampleSize = BitmapUtil.calculateInSampleSize(i2, i3, this.hEp, this.hEq);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = MMBitmapFactory.decodeFile(this.GBm.path, options);
            if (decodeFile == null || decodeFile.isRecycled()) {
                bitmap = null;
            } else {
                if (decodeFile.getWidth() % 2 == 1) {
                    bitmap2 = Bitmap.createBitmap(decodeFile.getWidth() + 1, decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
                    if (bitmap2 == null) {
                        p.hyc();
                    }
                    Canvas canvas = new Canvas(bitmap2);
                    canvas.drawARGB(0, 0, 0, 0);
                    canvas.drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
                } else {
                    bitmap2 = decodeFile;
                }
                bitmap = bitmap2;
            }
            if (bitmap == null) {
                p.hyc();
            }
            this.width = bitmap.getWidth();
            this.height = bitmap.getHeight();
            Log.i("MicroMsg.VLogImagePlayer", "prepare,oriWidth:" + i2 + "  oriHeight:" + i3 + " drawWidth:" + this.hEp + ", drawHeight:" + this.hEq + ", width:" + this.width + ", height:" + this.height);
            InputStream openRead = s.openRead(this.GBm.path);
            if (openRead != null) {
                InputStream inputStream = openRead;
                try {
                    android.support.e.a aVar2 = new android.support.e.a(inputStream);
                    x xVar = x.SXb;
                    b.a(inputStream, null);
                    aVar = aVar2;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    b.a(inputStream, th2);
                    AppMethodBeat.o(183779);
                    throw th;
                }
            } else {
                aVar = null;
            }
            if (aVar != null) {
                num = Integer.valueOf(aVar.l(android.support.e.a.TAG_ORIENTATION));
            }
            if (num != null && num.intValue() == 6) {
                this.dYT = 3;
                Log.i("MicroMsg.VLogImagePlayer", "image rotate 90");
            } else if (num != null && num.intValue() == 3) {
                this.dYT = 2;
                Log.i("MicroMsg.VLogImagePlayer", "image rotate 180");
            } else if (num != null && num.intValue() == 8) {
                this.dYT = 1;
                Log.i("MicroMsg.VLogImagePlayer", "image rotate 270");
            }
            this.GBF = bitmap;
            e eVar2 = e.GBH;
            e.p(this.GBm.path, this.width, this.height, this.dYT);
            Log.i("MicroMsg.VLogImagePlayer", "[prepare] image play time = ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            AppMethodBeat.o(183779);
            return;
        }
        Log.i("MicroMsg.VLogImagePlayer", "prepare finish get from cache");
        Log.i("MicroMsg.VLogImagePlayer", "prepare drawWidth:" + this.hEp + ", drawHeight:" + this.hEq + ", width:" + this.width + ", height:" + this.height);
        AppMethodBeat.o(183779);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void stop() {
        this.GBl = false;
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void release() {
        AppMethodBeat.i(110970);
        this.GBl = false;
        Bitmap bitmap = this.GBF;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.GBF = null;
        this.bcY = false;
        AppMethodBeat.o(110970);
    }
}
