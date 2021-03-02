package com.tencent.tav.asset;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AsynchronousKeyValueLoading;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composition<CTrack extends CompositionTrack> extends Asset {
    protected List<CTrack> tracks = new ArrayList();

    protected Composition() {
        AppMethodBeat.i(217639);
        AppMethodBeat.o(217639);
    }

    protected Composition(URL url) {
        super(url);
        AppMethodBeat.i(217640);
        AppMethodBeat.o(217640);
    }

    protected Composition(String str) {
        super(str);
        AppMethodBeat.i(217641);
        AppMethodBeat.o(217641);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.asset.Asset
    public CMTime getVideoDuration() {
        AppMethodBeat.i(217642);
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<CTrack> it = this.tracks.iterator();
        while (true) {
            CMTime cMTime2 = cMTime;
            if (it.hasNext()) {
                CTrack next = it.next();
                if (next.getMediaType() == 1) {
                    CMTime duration = next.getDuration();
                    if (duration.bigThan(cMTime2)) {
                        cMTime2 = duration;
                    }
                }
                cMTime = cMTime2;
            } else {
                AppMethodBeat.o(217642);
                return cMTime2;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.asset.Asset
    public CMTime getAudioDuration() {
        AppMethodBeat.i(217643);
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<CTrack> it = this.tracks.iterator();
        while (true) {
            CMTime cMTime2 = cMTime;
            if (it.hasNext()) {
                CTrack next = it.next();
                if (next.getMediaType() == 2) {
                    CMTime duration = next.getDuration();
                    if (duration.bigThan(cMTime2)) {
                        cMTime2 = duration;
                    }
                }
                cMTime = cMTime2;
            } else {
                AppMethodBeat.o(217643);
                return cMTime2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List<CTrack extends com.tencent.tav.asset.CompositionTrack> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.util.List<CTrack extends com.tencent.tav.asset.CompositionTrack> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.asset.Asset
    @TargetApi(16)
    public void createTracks() {
        AppMethodBeat.i(217644);
        int trackCount = this.extractor.getTrackCount();
        if (this.tracks == null) {
            this.tracks = new ArrayList();
        }
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = this.extractor.getTrackFormat(i2).getString("mime");
            if (string.startsWith("video/")) {
                int i3 = this.trackIndex;
                this.trackIndex = i3 + 1;
                this.tracks.add(new CompositionTrack(this, i3, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration())));
            } else if (string.startsWith("audio/")) {
                int i4 = this.trackIndex;
                this.trackIndex = i4 + 1;
                this.tracks.add(new CompositionTrack(this, i4, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration())));
            }
        }
        Logger.e(Asset.TAG, " Composition createTracks finish, has track count: " + this.tracks);
        AppMethodBeat.o(217644);
    }

    @Override // com.tencent.tav.asset.Asset
    public List<CTrack> getTracks() {
        AppMethodBeat.i(217645);
        new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
        List<CTrack> list = this.tracks;
        AppMethodBeat.o(217645);
        return list;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public int statusOfValueForKey(String str) {
        return 1;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public void loadValuesAsynchronouslyForKeys(List<String> list, AsynchronousKeyValueLoading.loadCallback loadcallback) {
    }

    public String toString() {
        AppMethodBeat.i(217646);
        String str = "Composition{\ntracks=" + this.tracks + "\ntrackCount=" + this.trackCount + '}';
        AppMethodBeat.o(217646);
        return str;
    }
}
