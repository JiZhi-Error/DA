package com.tencent.mm.plugin.thumbplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJT\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0010Jn\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/TPUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateVideoContainsLayoutParams", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "width", "", "height", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "", "getMediaRate", "hwRate", "plugin-thumbplayer_release"})
public final class a {
    public static final a Ggt = new a();

    static {
        AppMethodBeat.i(238615);
        AppMethodBeat.o(238615);
    }

    private a() {
    }

    public static Bundle k(Context context, int i2, int i3) {
        float f2 = 0.5625f;
        AppMethodBeat.i(238613);
        p.h(context, "context");
        if (context instanceof Activity) {
            context = ((Activity) context).getBaseContext();
        }
        p.g(context, "baseContext");
        Resources resources = context.getResources();
        p.g(resources, "baseContext.resources");
        int i4 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = context.getResources();
        p.g(resources2, "baseContext.resources");
        int min = Math.min(i4, resources2.getDisplayMetrics().heightPixels);
        float f3 = (((float) i3) * 1.0f) / ((float) i2);
        Bundle bundle = new Bundle();
        bundle.putInt("scaleType", ImageView.ScaleType.CENTER_CROP.ordinal());
        if (Math.abs(i2 - i3) <= 10) {
            bundle.putInt("width", min);
            bundle.putInt("height", min);
        } else {
            if (f3 >= 0.5625f) {
                if (f3 < 1.0f) {
                    f2 = f3;
                } else if (f3 < 1.3166667f) {
                    f2 = f3;
                } else {
                    f2 = 1.3166667f;
                }
            }
            bundle.putInt("width", min);
            bundle.putInt("height", (int) (f2 * ((float) min)));
        }
        AppMethodBeat.o(238613);
        return bundle;
    }

    public static h a(String str, String str2, String str3, int i2, String str4, String str5, String str6, h.a aVar, String str7) {
        AppMethodBeat.i(238614);
        p.h(str, "mediaId");
        p.h(str2, "url");
        p.h(str3, "path");
        p.h(str4, "fileFormat");
        p.h(str5, "urlToken");
        p.h(str7, "tag");
        h hVar = new h();
        hVar.taskName = "task_TPPlayUtil";
        hVar.field_mediaId = str;
        hVar.url = str2 + str5;
        hVar.gqC = 60;
        hVar.gqD = 60;
        hVar.gqU = 1;
        hVar.gqP = 8;
        hVar.grb = 0;
        hVar.field_requestVideoFormat = i2;
        hVar.field_fullpath = str3;
        hVar.concurrentCount = 4;
        hVar.connectionCount = 4;
        hVar.snsCipherKey = str6;
        hVar.gre = aVar;
        hVar.grc = true;
        hVar.grd = true;
        Log.i(str7, "[createVideoPlayCDNTask] finder video, reqFormat=" + i2 + " fileFormat=" + str4 + ", decodeKey=" + str6 + ' ' + str5 + " mediaId=" + str + " url=" + hVar.url + ' ');
        AppMethodBeat.o(238614);
        return hVar;
    }
}
