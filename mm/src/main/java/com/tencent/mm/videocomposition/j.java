package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.TextureInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "texture", "Lcom/tencent/tav/coremedia/TextureInfo;", "(Lcom/tencent/mm/videocomposition/CompositionTrack;Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "setTrack", "(Lcom/tencent/mm/videocomposition/CompositionTrack;)V", "video_composition_release"})
public final class j {
    public d GzA;
    public TextureInfo texture;

    public j(d dVar, TextureInfo textureInfo) {
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        p.h(textureInfo, "texture");
        AppMethodBeat.i(216758);
        this.GzA = dVar;
        this.texture = textureInfo;
        AppMethodBeat.o(216758);
    }
}
