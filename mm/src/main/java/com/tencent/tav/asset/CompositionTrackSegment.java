package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTimeRange;
import java.net.URL;

public class CompositionTrackSegment extends AssetTrackSegment {
    private String sourcePath;
    private int sourceTrackID;
    private int sourceType;
    private URL url;

    public CompositionTrackSegment(String str, int i2, CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, int i3) {
        super(cMTimeRange, cMTimeRange2);
        this.sourcePath = str;
        this.sourceType = i3;
        this.sourceTrackID = i2;
        this.empty = false;
    }

    public CompositionTrackSegment(CMTimeRange cMTimeRange) {
        super(cMTimeRange, cMTimeRange);
        AppMethodBeat.i(217652);
        this.empty = true;
        AppMethodBeat.o(217652);
    }

    public void updateTargetTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217653);
        this.scaleDuration = cMTimeRange.getDuration().clone();
        this.timeRange = cMTimeRange.clone();
        this.timeMapping.setTarget(cMTimeRange);
        AppMethodBeat.o(217653);
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public URL getUrl() {
        return this.url;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public int getSourceTrackID() {
        return this.sourceTrackID;
    }

    public String toString() {
        AppMethodBeat.i(217654);
        String str = "CompositionTrackSegment{sourcePath='" + this.sourcePath + '\'' + ", sourceTrackID=" + this.sourceTrackID + ", timeMapping=" + this.timeMapping + '}';
        AppMethodBeat.o(217654);
        return str;
    }
}
