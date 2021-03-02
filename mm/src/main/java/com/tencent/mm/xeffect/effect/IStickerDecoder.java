package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.util.Size;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 15}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "", "destroy", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"})
public interface IStickerDecoder {
    void destroy();

    long duration();

    Bitmap getFrame();

    void seekTo(long j2);

    Size size();
}
