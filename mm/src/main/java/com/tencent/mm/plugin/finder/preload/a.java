package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J&\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/FinderPreloadTransform;", "", "()V", "TAG", "", "buildPreloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "info", "transform", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "source", "", SharePatchInfo.FINGER_PRINT, "plugin-finder_release"})
public final class a {
    public static final a uTO = new a();

    static {
        AppMethodBeat.i(249502);
        AppMethodBeat.o(249502);
    }

    private a() {
    }

    public static void a(baw baw, List<? extends FinderObject> list, int i2) {
        String str;
        AppMethodBeat.i(249500);
        p.h(list, "list");
        StringBuilder sb = new StringBuilder("[transform] info=");
        if (baw != null) {
            p.h(baw, "$this$print");
            str = "[preloadId=" + baw.uUw + " hotFeed=" + baw.LKA.size() + ']';
        } else {
            str = null;
        }
        Log.i("Finder.PreloadTransform", sb.append(str).append(" list=").append(list.size()).append(" source=").append(i2).toString());
        com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) g.ah(PluginFinder.class)).getMediaPreloadModel();
        baw a2 = a(baw);
        HashMap<Long, FinderObject> hashMap = new HashMap<>();
        for (T t : list) {
            FinderObjectDesc finderObjectDesc = t.objectDesc;
            if (finderObjectDesc != null && finderObjectDesc.mediaType == 4) {
                hashMap.put(Long.valueOf(t.id), t);
            }
        }
        mediaPreloadModel.a(a2, hashMap);
        AppMethodBeat.o(249500);
    }

    public static baw a(baw baw) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(249501);
        if (baw == null) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_LAST_PRELOAD_INFO_STRING_SYNC, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(249501);
                throw tVar;
            }
            byte[] decodeHexString = Util.decodeHexString((String) obj);
            StringBuilder sb = new StringBuilder("[buildPreloadInfo] buffer isEmpty? ");
            p.g(decodeHexString, "buffer");
            if (decodeHexString.length == 0) {
                z = true;
            } else {
                z = false;
            }
            Log.i("Finder.PreloadTransform", sb.append(z).toString());
            if (decodeHexString.length != 0) {
                z2 = false;
            }
            if (z2) {
                baw baw2 = new baw();
                AppMethodBeat.o(249501);
                return baw2;
            }
            baw = new baw();
            baw.parseFrom(decodeHexString);
        }
        AppMethodBeat.o(249501);
        return baw;
    }
}
