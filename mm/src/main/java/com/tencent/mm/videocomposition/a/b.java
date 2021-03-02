package com.tencent.mm.videocomposition.a;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.videocomposition.d;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "", "createAudioProcessorNode", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
public interface b {
    TAVAudioProcessorNode f(d dVar);
}
