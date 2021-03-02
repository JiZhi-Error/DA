package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPTrackInfo {
    public static final int TP_MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int TP_MEDIA_TRACK_TYPE_SUBTITLE = 3;
    public static final int TP_MEDIA_TRACK_TYPE_UNKNOW = 0;
    public static final int TP_MEDIA_TRACK_TYPE_VIDEO = 1;
    public boolean isExclusive = true;
    public boolean isInternal = true;
    public boolean isSelected = false;
    public String name = "";
    public int trackType = 0;

    public int getTrackType() {
        return this.trackType;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(189049);
        if (obj == null || !(obj instanceof TPTrackInfo)) {
            AppMethodBeat.o(189049);
            return false;
        } else if (!this.name.equals(((TPTrackInfo) obj).name) || this.trackType != ((TPTrackInfo) obj).trackType) {
            AppMethodBeat.o(189049);
            return false;
        } else {
            AppMethodBeat.o(189049);
            return true;
        }
    }
}
