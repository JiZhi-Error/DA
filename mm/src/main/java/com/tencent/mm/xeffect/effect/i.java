package com.tencent.mm.xeffect.effect;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "", "start", "", "end", "(JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getStart", "setStart", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "renderlib_release"})
public final class i {
    public long boX;
    public long start;

    public /* synthetic */ i() {
        this(0, TPAudioFrame.TP_CH_STEREO_RIGHT);
    }

    public i(long j2, long j3) {
        this.start = j2;
        this.boX = j3;
    }
}
