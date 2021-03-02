package com.tencent.tavkit.composition.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AudioTapProcessor;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public class TAVAudioTapProcessor implements AudioTapProcessor {
    private List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
    private HashMap<String, AudioTapProcessor> audioTapProcessorHashMap = new HashMap<>();
    private AudioInfo destAudioInfo;

    public TAVAudioTapProcessor(List<TAVAudioConfigurationSegment> list) {
        AppMethodBeat.i(197501);
        this.audioConfigurationSegmentList = list;
        AppMethodBeat.o(197501);
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo) {
        AppMethodBeat.i(197502);
        this.destAudioInfo = audioInfo;
        for (TAVAudioConfigurationSegment tAVAudioConfigurationSegment : this.audioConfigurationSegmentList) {
            if (tAVAudioConfigurationSegment != null && tAVAudioConfigurationSegment.compositionTimeRange.containsTime(cMTime)) {
                TAVAudioConfiguration tAVAudioConfiguration = tAVAudioConfigurationSegment.audioConfiguration;
                if (tAVAudioConfiguration.getNodes() != null) {
                    for (TAVAudioProcessorNode tAVAudioProcessorNode : tAVAudioConfiguration.getNodes()) {
                        String identifier = tAVAudioProcessorNode.getIdentifier();
                        AudioTapProcessor audioTapProcessor = this.audioTapProcessorHashMap.get(identifier);
                        if (audioTapProcessor == null) {
                            audioTapProcessor = tAVAudioProcessorNode.createAudioProcessor();
                            this.audioTapProcessorHashMap.put(identifier, audioTapProcessor);
                        }
                        if (audioTapProcessor != null) {
                            byteBuffer = audioTapProcessor.processAudioPCM(cMTime, byteBuffer, audioInfo);
                            this.destAudioInfo = audioTapProcessor.getDestAudioInfo();
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(197502);
        return byteBuffer;
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public AudioInfo getDestAudioInfo() {
        return this.destAudioInfo;
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public void release() {
        AppMethodBeat.i(197503);
        for (AudioTapProcessor audioTapProcessor : this.audioTapProcessorHashMap.values()) {
            audioTapProcessor.release();
        }
        AppMethodBeat.o(197503);
    }

    public String toString() {
        AppMethodBeat.i(197504);
        String str = "TAVAudioTapProcessor{audioConfigurationSegmentList=" + this.audioConfigurationSegmentList + ", audioTapProcessorHashMap=" + this.audioTapProcessorHashMap + '}';
        AppMethodBeat.o(197504);
        return str;
    }
}
