package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.b;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0011\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalStrangerAvatarLoaderDiskCache;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDiskCacheListener;", "()V", "TAG", "", "clear", "", "opts", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "createFilePath", "Lcom/tencent/mm/vfs/VFSFile;", "url", "delete", "", "exists", "get", "Ljava/io/InputStream;", "save", "data", "", "setFileNameCreator", "creator", "Lcom/tencent/mm/modelimage/loader/listener/IImageFileNameCreatorListener;", "plugin-festival_release"})
public final class x implements b {
    public static final x UyY = new x();

    static {
        AppMethodBeat.i(263071);
        AppMethodBeat.o(263071);
    }

    private x() {
    }

    public static o bxw(String str) {
        AppMethodBeat.i(263068);
        p.h(str, "url");
        l lVar = l.Uyp;
        o oVar = new o(l.gWT(), MD5Util.getMD5String(str) + "_avt.dat");
        AppMethodBeat.o(263068);
        return oVar;
    }

    @Override // com.tencent.mm.av.a.c.b
    public final boolean a(String str, byte[] bArr, c cVar) {
        return true;
    }

    @Override // com.tencent.mm.av.a.c.b
    public final boolean c(String str, c cVar) {
        boolean z;
        AppMethodBeat.i(263069);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(263069);
            return false;
        }
        Log.d("MicroMsg.FestivalStrangerAvatarLoaderDiskCache", "delete(" + str + ')');
        boolean delete = bxw(str).delete();
        AppMethodBeat.o(263069);
        return delete;
    }

    @Override // com.tencent.mm.av.a.c.b
    public final void bdw() {
    }

    @Override // com.tencent.mm.av.a.c.b
    public final InputStream d(String str, c cVar) {
        InputStream inputStream;
        AppMethodBeat.i(263070);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(263070);
            return null;
        }
        o bxw = bxw(str);
        if (!bxw.isFile() || !bxw.exists()) {
            inputStream = null;
        } else {
            inputStream = s.ao(bxw);
        }
        Log.d("MicroMsg.FestivalStrangerAvatarLoaderDiskCache", "get(" + str + ") return:" + inputStream);
        AppMethodBeat.o(263070);
        return inputStream;
    }

    @Override // com.tencent.mm.av.a.c.b
    public final void a(g gVar) {
    }
}
