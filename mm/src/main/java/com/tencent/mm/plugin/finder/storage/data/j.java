package com.tencent.mm.plugin.finder.storage.data;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.h.a;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\t\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\n\u001a\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b*\b\u0012\u0004\u0012\u00020\t0\u000b\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b*\b\u0012\u0004\u0012\u00020\n0\u000b\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "mediaSize", "Landroid/util/Size;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isFullscreen", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Ljava/util/LinkedList;", "toLongVideoLocal", "plugin-finder_release"})
public final class j {
    private static final h<String, String> vGp = new h<>(200);

    public static final LinkedList<cjl> aA(LinkedList<FinderMedia> linkedList) {
        AppMethodBeat.i(167063);
        p.h(linkedList, "$this$toLocal");
        LinkedList<cjl> linkedList2 = new LinkedList<>();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(a((FinderMedia) it.next()));
        }
        AppMethodBeat.o(167063);
        return linkedList2;
    }

    static {
        AppMethodBeat.i(167065);
        AppMethodBeat.o(167065);
    }

    public static final cjl a(FinderMedia finderMedia) {
        AppMethodBeat.i(167064);
        p.h(finderMedia, "$this$toLocal");
        cjl cjl = new cjl();
        cjl.url = finderMedia.url;
        cjl.thumbUrl = finderMedia.thumbUrl;
        cjl.mediaType = finderMedia.mediaType;
        cjl.videoDuration = finderMedia.videoDuration;
        cjl.width = finderMedia.width;
        cjl.height = finderMedia.height;
        cjl.md5sum = finderMedia.md5sum;
        cjl.fileSize = finderMedia.fileSize;
        cjl.bitrate = finderMedia.bitrate;
        z.f fVar = new z.f();
        synchronized (vGp) {
            try {
                fVar.SYG = (T) ((String) vGp.get(finderMedia.url));
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(167064);
            }
        }
        if (fVar.SYG == null) {
            fVar.SYG = finderMedia.url == null ? (T) "" : (T) MD5Util.getMD5String(Util.nullAs(finderMedia.url, ""));
            synchronized (vGp) {
                try {
                    vGp.x(finderMedia.url, fVar.SYG);
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        cjl.mediaId = fVar.SYG;
        aty aty = finderMedia.half_rect;
        if (aty != null) {
            cjx cjx = new cjx();
            erf erf = new erf();
            erf.left = (int) aty.left;
            erf.top = (int) aty.top;
            erf.right = (int) aty.right;
            erf.bottom = (int) aty.bottom;
            cjx.Mpq = erf;
            cjl.uOR = cjx;
        }
        cjl.MoQ = ((long) finderMedia.videoDuration) * 1000;
        cjl.spec = finderMedia.spec;
        cjl.coverUrl = finderMedia.coverUrl;
        cjl.decodeKey = finderMedia.decodeKey;
        cjl.hot_flag = finderMedia.hot_flag;
        cjl.url_token = finderMedia.url_token;
        cjl.thumb_url_token = finderMedia.thumb_url_token;
        cjl.cover_url_token = finderMedia.cover_url_token;
        cjl.codec_info = finderMedia.codec_info;
        cjl.MoR = finderMedia.full_thumb_url;
        cjl.MoS = finderMedia.full_thumb_url_token;
        cjl.MoU = finderMedia.half_rect;
        AppMethodBeat.o(167064);
        return cjl;
    }

    public static final cjl a(cod cod) {
        LinkedList<ayh> linkedList;
        AppMethodBeat.i(252005);
        p.h(cod, "$this$toLocal");
        cjl cjl = new cjl();
        cjl.url = cod.url;
        cjl.mediaType = 4;
        cjl.thumbUrl = cod.thumbUrl;
        cjl.videoDuration = cod.Mur;
        if (cod.Mus == 0) {
            cjl.MoQ = ((long) cod.Mur) * 1000;
        } else {
            cjl.MoQ = cod.Mus;
        }
        z.f fVar = new z.f();
        synchronized (vGp) {
            try {
                fVar.SYG = (T) ((String) vGp.get(cod.url));
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(252005);
            }
        }
        if (fVar.SYG == null) {
            fVar.SYG = cod.url == null ? (T) "" : (T) MD5Util.getMD5String(Util.nullAs(cod.url, ""));
            synchronized (vGp) {
                try {
                    vGp.x(cod.url, fVar.SYG);
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        cjl.MoL = 3;
        cjl.mediaId = fVar.SYG;
        cjl.width = cod.width;
        cjl.height = cod.height;
        cjl.md5sum = cod.md5sum;
        cjl.fileSize = cod.fileSize;
        cjl.bitrate = cod.bitrate;
        ayi ayi = cod.Muv;
        if (ayi == null || (linkedList = ayi.LIz) == null) {
            linkedList = new LinkedList<>();
        }
        cjl.spec = linkedList;
        cjl.decodeKey = cod.decodeKey;
        cjl.coverUrl = cod.coverUrl;
        cjl.url_token = cod.viB;
        cjl.cover_url_token = cod.Mut;
        cjl.thumb_url_token = cod.Ghs;
        cjl.hot_flag = cod.hot_flag;
        AppMethodBeat.o(252005);
        return cjl;
    }

    public static final LinkedList<cjl> aB(LinkedList<cod> linkedList) {
        AppMethodBeat.i(252006);
        p.h(linkedList, "$this$toLongVideoLocal");
        LinkedList<cjl> linkedList2 = new LinkedList<>();
        int i2 = 0;
        for (T t : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            linkedList2.add(a((cod) t));
            i2 = i3;
        }
        AppMethodBeat.o(252006);
        return linkedList2;
    }

    public static final Size a(cjl cjl, boolean z) {
        aty aty;
        AppMethodBeat.i(252007);
        p.h(cjl, "$this$mediaSize");
        if (z || (aty = cjl.MoU) == null || aty.right <= aty.left || aty.bottom <= aty.top) {
            Size size = new Size((int) cjl.width, (int) cjl.height);
            AppMethodBeat.o(252007);
            return size;
        }
        Size size2 = new Size(a.cR(aty.right - aty.left), a.cR(aty.bottom - aty.top));
        AppMethodBeat.o(252007);
        return size2;
    }
}
