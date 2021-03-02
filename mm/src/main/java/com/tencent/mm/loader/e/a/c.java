package com.tencent.mm.loader.e.a;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
public class c extends b {
    private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";

    @Override // com.tencent.mm.loader.d.d
    public e<Bitmap> a(g<?> gVar, f<?, Bitmap> fVar, a aVar) {
        Bitmap bitmap;
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(aVar, "input");
        InputStream aKu = aVar.aKu();
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("InputStreamBitmapProducer");
        if (aKu != null) {
            bitmap = com.tencent.mm.loader.l.a.a(gVar, aKu, fVar.hXX.hZz, fVar.hXX.hZA);
        } else {
            bitmap = null;
        }
        if (aKu != null) {
            aKu.reset();
            Exif fromStream = Exif.fromStream(aKu);
            p.g(fromStream, "Exif.fromStream(inputStream)");
            int orientationInDegree = fromStream.getOrientationInDegree();
            Log.i(this.TAG, "read exif rotate degree %d", Integer.valueOf(orientationInDegree));
            bitmap = BitmapUtil.rotate(bitmap, ((float) orientationInDegree) * 1.0f);
        }
        x xVar = x.SXb;
        cVar.aBw();
        Log.i(this.TAG, "InputStreamBitmapProducer decode bitmap done " + bitmap + " from input " + aVar);
        return new e<>(bitmap);
    }
}
