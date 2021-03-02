package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", DownloadInfo.CONTENTTYPE, "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"})
public final class e implements com.tencent.mm.av.a.c.a {
    public static final a Kes = new a((byte) 0);
    private long Keo;
    private long Kep;
    private long Keq;
    private long Ker;
    private String contentType;
    private int from;
    private String id;
    private int scene;
    private String url;

    static {
        AppMethodBeat.i(124838);
        AppMethodBeat.o(124838);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        AppMethodBeat.i(124837);
        this.from = -1;
        this.id = "";
        this.url = "";
        this.scene = i2;
        this.id = String.valueOf(hashCode());
        AppMethodBeat.o(124837);
    }

    @Override // com.tencent.mm.av.a.c.a
    public final void OZ(String str) {
        AppMethodBeat.i(124832);
        this.url = str;
        this.Keo = System.currentTimeMillis();
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", this.id, Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.dd(5, str);
        }
        AppMethodBeat.o(124832);
    }

    @Override // com.tencent.mm.av.a.c.a
    public final void bdx() {
        AppMethodBeat.i(124833);
        this.Kep = System.currentTimeMillis();
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", this.id, Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.de(5, this.url);
        }
        AppMethodBeat.o(124833);
    }

    @Override // com.tencent.mm.av.a.c.a
    public final void a(String str, b bVar) {
        AppMethodBeat.i(124834);
        this.contentType = bVar != null ? bVar.contentType : null;
        this.from = bVar != null ? bVar.from : -1;
        this.Keq = System.currentTimeMillis();
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", this.id, Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.dd(6, str);
        }
        if (gpg()) {
            Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", this.id, this.contentType, str);
            f fVar = f.Ket;
            f.beH(this.contentType);
        }
        AppMethodBeat.o(124834);
    }

    @Override // com.tencent.mm.av.a.c.a
    public final void N(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.i(124835);
        this.Ker = System.currentTimeMillis();
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.de(6, this.url);
        }
        if (gpg()) {
            Object[] objArr = new Object[4];
            objArr[0] = this.id;
            objArr[1] = Long.valueOf(this.Ker - this.Keq);
            objArr[2] = Boolean.valueOf(bitmap == null);
            objArr[3] = bitmap != null ? Boolean.valueOf(bitmap.isRecycled()) : null;
            Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeEnd id: %s, decode cost: %d ms, bitmap == null: %b, recycled: %s", objArr);
            if (bitmap == null || bitmap.isRecycled()) {
                z = false;
            }
            f fVar = f.Ket;
            f.da(this.contentType, z);
            f fVar2 = f.Ket;
            f.bS(this.contentType, this.Ker - this.Keq);
            g gVar2 = g.Kev;
            if (g.beK(this.contentType) && !z) {
                f fVar3 = f.Ket;
                f.aL(this.url, 2, this.scene);
            }
        }
        AppMethodBeat.o(124835);
    }

    private final boolean gpg() {
        AppMethodBeat.i(124836);
        if (this.from == 2) {
            g gVar = g.Kev;
            if (g.aif(this.scene)) {
                AppMethodBeat.o(124836);
                return true;
            }
        }
        AppMethodBeat.o(124836);
        return false;
    }
}
