package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;

public class AudioMixInputParameters {
    protected AudioTapProcessor audioTapProcessor;
    protected String audioTimePitchAlgorithm;
    protected int trackID;
    protected ArrayList<VolumeRange> volumeRanges = new ArrayList<>();

    public static class VolumeRange {
        public float endVolume;
        public float startVolume;
        public CMTimeRange timeRange;
    }

    public AudioMixInputParameters(int i2, String str) {
        AppMethodBeat.i(217853);
        this.trackID = i2;
        this.audioTimePitchAlgorithm = str;
        AppMethodBeat.o(217853);
    }

    public VolumeRange getVolumeRampAtTimeRange(CMTime cMTime) {
        AppMethodBeat.i(217854);
        Iterator<VolumeRange> it = this.volumeRanges.iterator();
        while (it.hasNext()) {
            VolumeRange next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                AppMethodBeat.o(217854);
                return next;
            }
        }
        AppMethodBeat.o(217854);
        return null;
    }

    public float getVolumeAtTime(CMTime cMTime) {
        VolumeRange volumeRange;
        AppMethodBeat.i(217855);
        long timeUs = cMTime.getTimeUs();
        Iterator<VolumeRange> it = this.volumeRanges.iterator();
        while (true) {
            if (!it.hasNext()) {
                volumeRange = null;
                break;
            }
            volumeRange = it.next();
            if (timeUs >= volumeRange.timeRange.getStart().getTimeUs() && timeUs < volumeRange.timeRange.getEnd().getTimeUs()) {
                break;
            }
        }
        if (volumeRange == null) {
            AppMethodBeat.o(217855);
            return 1.0f;
        }
        float timeUs2 = (((1.0f * ((float) (timeUs - volumeRange.timeRange.getStart().getTimeUs()))) / ((float) volumeRange.timeRange.getDuration().getTimeUs())) * (volumeRange.endVolume - volumeRange.startVolume)) + volumeRange.startVolume;
        AppMethodBeat.o(217855);
        return timeUs2;
    }

    public int getTrackID() {
        return this.trackID;
    }

    public String getAudioTimePitchAlgorithm() {
        return this.audioTimePitchAlgorithm;
    }

    public AudioTapProcessor getAudioTapProcessor() {
        return this.audioTapProcessor;
    }

    public boolean containsTime(CMTime cMTime) {
        AppMethodBeat.i(217856);
        Iterator<VolumeRange> it = this.volumeRanges.iterator();
        while (it.hasNext()) {
            if (it.next().timeRange.containsTime(cMTime)) {
                AppMethodBeat.o(217856);
                return true;
            }
        }
        AppMethodBeat.o(217856);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(217857);
        String str = "AudioMixInputParameters{trackID=" + this.trackID + ", audioTimePitchAlgorithm='" + this.audioTimePitchAlgorithm + '\'' + ", audioTapProcessor=" + this.audioTapProcessor + ", volumeRanges=" + this.volumeRanges + '}';
        AppMethodBeat.o(217857);
        return str;
    }
}
