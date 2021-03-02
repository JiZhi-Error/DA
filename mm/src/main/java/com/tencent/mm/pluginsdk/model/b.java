package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageLoader;", "", "()V", "TAG", "", "loadImage", "", "msgId", "", "msgIndex", "", "item", "Lcom/tencent/mm/message/BizReaderItem;", "scene", "url", "view", "Landroid/widget/ImageView;", "cellPosition", "isPreload", "", "options", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "imageLoaderListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "imageLoadListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "ImageLoadListenerWrapper", "plugin-biz_release"})
public final class b {
    public static final b JUJ = new b();

    static {
        AppMethodBeat.i(124831);
        AppMethodBeat.o(124831);
    }

    private b() {
    }

    public static void a(long j2, int i2, v vVar, String str, ImageView imageView, int i3, boolean z, c cVar, h hVar) {
        String str2;
        long currentTimeMillis;
        AppMethodBeat.i(124830);
        if (str == null) {
            AppMethodBeat.o(124830);
            return;
        }
        a aVar = a.JUl;
        String bdl = a.bdl(str);
        if (imageView != null) {
            imageView.setTag(R.id.a5g, str);
        }
        Object[] objArr = new Object[5];
        objArr[0] = imageView != null ? Integer.valueOf(imageView.hashCode()) : null;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = bdl;
        objArr[3] = str;
        if (cVar != null) {
            str2 = cVar.bdi();
        } else {
            str2 = null;
        }
        objArr[4] = str2;
        Log.d("MicroMsg.BizImageLoader", "alvinluo BizImage loadImage imageView: %s, isPreload: %b, id: %s, url: %s, fullPath: %s", objArr);
        g gVar = g.Kev;
        if (g.aig(1) && !z) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (vVar != null) {
                a aVar2 = a.JUl;
                p.h(vVar, "item");
                p.h(str, "url");
                if (!(str.length() == 0) && a.AbY.get(str) == null) {
                    String str3 = a.JUh.get(a.al(j2, i2));
                    a.b bVar = new a.b(str);
                    if (currentTimeMillis2 != 0) {
                        currentTimeMillis = currentTimeMillis2;
                    } else {
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    bVar.position = i3;
                    if (str3 != null) {
                        bVar.bdm(str3);
                    }
                    bVar.aQ(1, currentTimeMillis);
                    a.AbY.put(str, bVar);
                    if (a.JUj) {
                        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo startLoad flinging id: %s, url: %s", a.bdl(str), str);
                        bVar.aQ(9, currentTimeMillis);
                    }
                }
                a aVar3 = a.JUl;
                a.d(8, str, currentTimeMillis2);
            }
        }
        q.bcV().a(str, imageView, cVar, null, new a(str, hVar));
        AppMethodBeat.o(124830);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageLoader$ImageLoadListenerWrapper;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "scene", "", "url", "", "imageLoadListener", "(ILjava/lang/String;Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;)V", "id", "getImageLoadListener", "()Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "getScene", "()I", "getUrl", "()Ljava/lang/String;", "onImageLoadFinish", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-biz_release"})
    public static final class a implements h {
        private final h Akx;
        private final String id;
        private final int scene = 1;
        private final String url;

        public a(String str, h hVar) {
            byte[] bArr;
            AppMethodBeat.i(124829);
            this.url = str;
            this.Akx = hVar;
            String str2 = this.url;
            if (str2 != null) {
                Charset charset = d.UTF_8;
                if (str2 == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(124829);
                    throw tVar;
                }
                bArr = str2.getBytes(charset);
                p.g(bArr, "(this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(bArr);
            this.id = messageDigest == null ? "-1" : messageDigest;
            AppMethodBeat.o(124829);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
            AppMethodBeat.i(124826);
            h hVar = this.Akx;
            if (hVar != null) {
                hVar.b(str, view);
                AppMethodBeat.o(124826);
                return;
            }
            AppMethodBeat.o(124826);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            AppMethodBeat.i(124827);
            g gVar = g.Kev;
            if (g.aig(this.scene)) {
                a aVar = a.JUl;
                a.dd(7, str);
            }
            h hVar = this.Akx;
            Bitmap a2 = hVar != null ? hVar.a(str, view, bVar) : null;
            g gVar2 = g.Kev;
            if (g.aig(this.scene)) {
                a aVar2 = a.JUl;
                a.de(7, str);
            }
            AppMethodBeat.o(124827);
            return a2;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            AppMethodBeat.i(124828);
            p.h(str, "url");
            h hVar = this.Akx;
            if (hVar != null) {
                hVar.b(str, view, bVar);
            }
            g gVar = g.Kev;
            if (g.aig(this.scene)) {
                a aVar = a.JUl;
                p.h(str, "url");
                a.v(new a.e(str, System.currentTimeMillis(), bVar));
            }
            AppMethodBeat.o(124828);
        }
    }
}
