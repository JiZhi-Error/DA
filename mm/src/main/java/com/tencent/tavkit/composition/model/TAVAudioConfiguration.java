package com.tencent.tavkit.composition.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.util.ArrayList;
import java.util.List;

public class TAVAudioConfiguration {
    private VolumeEdge endVolumeEdge;
    private final List<TAVAudioProcessorNode> nodes;
    private VolumeEdge startVolumeEdge;
    private float volume;
    private List<VolumeEdge> volumeEdges;

    public TAVAudioConfiguration() {
        this(1.0f);
    }

    public TAVAudioConfiguration(float f2) {
        this(f2, null, null);
    }

    public TAVAudioConfiguration(List<VolumeEdge> list) {
        this(1.0f, null, list);
    }

    public TAVAudioConfiguration(float f2, List<TAVAudioProcessorNode> list) {
        this(f2, list, null);
    }

    public TAVAudioConfiguration(float f2, List<TAVAudioProcessorNode> list, List<VolumeEdge> list2) {
        AppMethodBeat.i(197559);
        this.volume = f2;
        this.nodes = new ArrayList();
        if (list != null) {
            this.nodes.addAll(list);
        }
        this.volumeEdges = new ArrayList();
        if (list2 != null) {
            this.volumeEdges.addAll(list2);
        }
        AppMethodBeat.o(197559);
    }

    public void addVolumeEdge(VolumeEdge volumeEdge) {
        AppMethodBeat.i(197560);
        if (volumeEdge == null) {
            AppMethodBeat.o(197560);
            return;
        }
        if (this.volumeEdges == null) {
            this.volumeEdges = new ArrayList();
        }
        this.volumeEdges.add(0, volumeEdge);
        AppMethodBeat.o(197560);
    }

    public void setVolume(float f2) {
        this.volume = f2;
    }

    public float getVolume() {
        return this.volume;
    }

    public float getVolume(CMTime cMTime) {
        AppMethodBeat.i(197561);
        if (this.startVolumeEdge != null && this.startVolumeEdge.getTimeRange() != null && this.startVolumeEdge.getTimeRange().containsTime(cMTime)) {
            float volume2 = this.startVolumeEdge.getVolume(cMTime.sub(this.startVolumeEdge.getTimeRange().getStart()));
            AppMethodBeat.o(197561);
            return volume2;
        } else if (this.endVolumeEdge == null || this.endVolumeEdge.getTimeRange() == null || !this.endVolumeEdge.getTimeRange().containsTime(cMTime)) {
            if (this.volumeEdges != null && !this.volumeEdges.isEmpty()) {
                for (VolumeEdge volumeEdge : this.volumeEdges) {
                    if (!(volumeEdge == null || volumeEdge.getTimeRange() == null || !volumeEdge.getTimeRange().containsTime(cMTime))) {
                        float volume3 = volumeEdge.getVolume(cMTime.sub(volumeEdge.getTimeRange().getStart()));
                        AppMethodBeat.o(197561);
                        return volume3;
                    }
                }
            }
            float f2 = this.volume;
            AppMethodBeat.o(197561);
            return f2;
        } else {
            float volume4 = this.endVolumeEdge.getVolume(cMTime.sub(this.endVolumeEdge.getTimeRange().getStart()));
            AppMethodBeat.o(197561);
            return volume4;
        }
    }

    public List<TAVAudioProcessorNode> getNodes() {
        return this.nodes;
    }

    public void addAudioProcessorNode(TAVAudioProcessorNode tAVAudioProcessorNode) {
        AppMethodBeat.i(197562);
        this.nodes.add(tAVAudioProcessorNode);
        AppMethodBeat.o(197562);
    }

    public void setAudioProcessorNodes(List<TAVAudioProcessorNode> list) {
        AppMethodBeat.i(197563);
        this.nodes.clear();
        if (list != null) {
            this.nodes.addAll(list);
        }
        AppMethodBeat.o(197563);
    }

    public TAVAudioConfiguration clone() {
        AppMethodBeat.i(197564);
        TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration(this.volume, this.nodes);
        AppMethodBeat.o(197564);
        return tAVAudioConfiguration;
    }

    public VolumeEdge getStartVolumeEdge() {
        return this.startVolumeEdge;
    }

    public void setStartVolumeEdge(VolumeEdge volumeEdge) {
        this.startVolumeEdge = volumeEdge;
    }

    public VolumeEdge getEndVolumeEdge() {
        return this.endVolumeEdge;
    }

    public void setEndVolumeEdge(VolumeEdge volumeEdge) {
        this.endVolumeEdge = volumeEdge;
    }

    public String toString() {
        AppMethodBeat.i(197565);
        String str = "TAVAudioConfiguration{volume=" + this.volume + ", startVolumeEdge=" + this.startVolumeEdge + ", endVolumeEdge=" + this.endVolumeEdge + ", nodes=" + this.nodes + '}';
        AppMethodBeat.o(197565);
        return str;
    }

    public static class VolumeEdge {
        private float endVolume;
        private float startVolume;
        private CMTimeRange timeRange;

        public VolumeEdge() {
        }

        public VolumeEdge(CMTime cMTime, float f2, float f3) {
            AppMethodBeat.i(197555);
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
            this.startVolume = f2;
            this.endVolume = f3;
            AppMethodBeat.o(197555);
        }

        public VolumeEdge(CMTimeRange cMTimeRange, float f2, float f3) {
            this.timeRange = cMTimeRange;
            this.startVolume = f2;
            this.endVolume = f3;
        }

        public void setTimeRange(CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }

        public CMTimeRange getTimeRange() {
            return this.timeRange;
        }

        public CMTime getDuration() {
            AppMethodBeat.i(197556);
            if (this.timeRange != null) {
                CMTime duration = this.timeRange.getDuration();
                AppMethodBeat.o(197556);
                return duration;
            }
            CMTime cMTime = CMTime.CMTimeZero;
            AppMethodBeat.o(197556);
            return cMTime;
        }

        public float getStartVolume() {
            return this.startVolume;
        }

        public float getEndVolume() {
            return this.endVolume;
        }

        public void setDuration(CMTime cMTime) {
            AppMethodBeat.i(197557);
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
            AppMethodBeat.o(197557);
        }

        public void setStartVolume(float f2) {
            this.startVolume = f2;
        }

        public void setEndVolume(float f2) {
            this.endVolume = f2;
        }

        public float getVolume(CMTime cMTime) {
            AppMethodBeat.i(197558);
            long timeUs = cMTime.getTimeUs();
            float timeUs2 = (((((float) timeUs) * 1.0f) / ((float) getDuration().getTimeUs())) * (this.endVolume - this.startVolume)) + this.startVolume;
            AppMethodBeat.o(197558);
            return timeUs2;
        }
    }
}
