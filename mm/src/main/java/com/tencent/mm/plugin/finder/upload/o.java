package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u001c\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/HalfMediaLogic;", "", "()V", "TAG", "", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "fillBack", "", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "fullMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfMediaList", "Ljava/util/LinkedList;", "splitMedia", "rootMedia", "plugin-finder_release"})
public final class o {
    private static final String TAG = TAG;
    private static final f.a.AbstractC1209a uIo = new a();
    public static final o vTw = new o();

    static {
        AppMethodBeat.i(253134);
        AppMethodBeat.o(253134);
    }

    private o() {
    }

    public static void a(cjl cjl, LinkedList<cjl> linkedList) {
        AppMethodBeat.i(253132);
        p.h(cjl, "rootMedia");
        p.h(linkedList, "halfMediaList");
        cjl.MoW = "fillback_" + System.currentTimeMillis();
        car car = cjl.MoX;
        if (car != null) {
            Log.i(TAG, "split " + cjl.MoW);
            cjl cjl2 = new cjl();
            try {
                cjl2.parseFrom(cjl.toByteArray());
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                cjl2 = null;
            }
            cjl cjl3 = cjl2;
            if (cjl3 != null) {
                cjl3.thumbUrl = car.thumbUrl;
                cjl3.width = car.width;
                cjl3.height = car.height;
                cjl3.MfU = car.MfU;
                String str = car.xve;
                if (!(str == null || str.length() == 0)) {
                    cjl3.url = car.xve;
                    cjl3.mediaId = MD5Util.getMD5String(cjl3.url);
                } else if (cjl.mediaType == 2) {
                    cjl3.url = cjl.url;
                    cjl3.mediaId = MD5Util.getMD5String(cjl3.url) + "_split";
                    Log.e(TAG, "splitMedia image half null!");
                }
                cjl3.coverUrl = "";
                cjl3.MoR = "";
                cjl3.MoY = true;
                linkedList.add(cjl3);
                AppMethodBeat.o(253132);
                return;
            }
            AppMethodBeat.o(253132);
            return;
        }
        AppMethodBeat.o(253132);
    }

    public static void a(FinderMedia finderMedia, cjl cjl, LinkedList<cjl> linkedList) {
        T t;
        aco aco;
        aty aty = null;
        AppMethodBeat.i(253133);
        p.h(finderMedia, "media");
        p.h(cjl, "fullMedia");
        p.h(linkedList, "halfMediaList");
        Log.i(TAG, "fillBack " + cjl.MoW);
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(cjl.MoW, next.MoW)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            finderMedia.url = cjl.MoM;
            finderMedia.thumbUrl = cjl.MoN;
            finderMedia.md5sum = cjl.md5sum;
            finderMedia.width = cjl.width;
            finderMedia.height = cjl.height;
            finderMedia.fileSize = cjl.fileSize;
            finderMedia.bitrate = cjl.bitrate;
            finderMedia.full_url = cjl.MoM;
            finderMedia.full_thumb_url = cjl.MoT;
            finderMedia.full_md5sum = cjl.md5sum;
            finderMedia.full_width = cjl.width;
            finderMedia.full_height = cjl.height;
            finderMedia.full_file_size = cjl.fileSize;
            finderMedia.full_bitrate = cjl.bitrate;
            Log.i(TAG, "no half");
            Log.i(TAG, "media.url:" + finderMedia.url);
            Log.i(TAG, "media.thumbUrl:" + finderMedia.thumbUrl);
            Log.i(TAG, "media.full_url:" + finderMedia.full_url);
            Log.i(TAG, "media.full_thumb_url:" + finderMedia.full_thumb_url);
        } else {
            finderMedia.url = t2.MoM;
            finderMedia.thumbUrl = t2.MoN;
            finderMedia.md5sum = t2.md5sum;
            finderMedia.width = t2.width;
            finderMedia.height = t2.height;
            finderMedia.fileSize = t2.fileSize;
            finderMedia.bitrate = t2.bitrate;
            finderMedia.full_url = cjl.MoM;
            finderMedia.full_thumb_url = cjl.MoT;
            finderMedia.full_md5sum = cjl.md5sum;
            finderMedia.full_width = cjl.width;
            finderMedia.full_height = cjl.height;
            finderMedia.full_file_size = cjl.fileSize;
            finderMedia.full_bitrate = cjl.bitrate;
            Log.i(TAG, "half");
            Log.i(TAG, "media.url:" + finderMedia.url);
            Log.i(TAG, "media.thumbUrl:" + finderMedia.thumbUrl);
            Log.i(TAG, "media.full_url:" + finderMedia.full_url);
            Log.i(TAG, "media.full_thumb_url:" + finderMedia.full_thumb_url);
        }
        finderMedia.coverUrl = cjl.MoP;
        Log.i(TAG, "media.coverUrl:" + finderMedia.coverUrl);
        aty aty2 = cjl.MoU;
        if (aty2 != null) {
            acn acn = cjl.MfU;
            if (!(acn == null || (aco = acn.Gxw) == null)) {
                float f2 = finderMedia.full_width / ((float) aco.xlg);
                float f3 = finderMedia.full_height / ((float) aco.xlh);
                aty2.left *= f2;
                aty2.top *= f3;
                aty2.right = f2 * aty2.right;
                aty2.bottom = f3 * aty2.bottom;
            }
            aty = aty2;
        }
        finderMedia.half_rect = aty;
        AppMethodBeat.o(253133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/upload/HalfMediaLogic$onCdnDownloadCallback$1", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "onFinish", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "tmpFilePath", "", "plugin-finder_release"})
    public static final class a implements f.a.AbstractC1209a {
        a() {
        }
    }

    public static f.a.AbstractC1209a dBk() {
        return uIo;
    }
}
