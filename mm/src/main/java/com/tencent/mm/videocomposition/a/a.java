package com.tencent.mm.videocomposition.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.videocomposition.d;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/videocomposition/audio/AudioResampleProcessor;", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "resampleFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "(Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;)V", "getResampleFactory", "()Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "createAudioProcessorNode", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
public final class a implements b {
    final c RhA;

    public a(c cVar) {
        p.h(cVar, "resampleFactory");
        AppMethodBeat.i(216795);
        this.RhA = cVar;
        AppMethodBeat.o(216795);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/videocomposition/audio/AudioResampleProcessor$createAudioProcessorNode$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "video_composition_release"})
    /* renamed from: com.tencent.mm.videocomposition.a.a$a  reason: collision with other inner class name */
    public static final class C2155a implements TAVAudioProcessorNode {
        final /* synthetic */ d Gxg;
        final /* synthetic */ a RhB;

        C2155a(a aVar, d dVar) {
            this.RhB = aVar;
            this.Gxg = dVar;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
        public final String getIdentifier() {
            return this.Gxg.path;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
        public final TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor() {
            AppMethodBeat.i(216793);
            TAVAudioProcessorNode.TAVAudioProcessorEffect a2 = this.RhB.RhA.a(this.Gxg);
            AppMethodBeat.o(216793);
            return a2;
        }
    }

    @Override // com.tencent.mm.videocomposition.a.b
    public final TAVAudioProcessorNode f(d dVar) {
        AppMethodBeat.i(216794);
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        C2155a aVar = new C2155a(this, dVar);
        AppMethodBeat.o(216794);
        return aVar;
    }
}
