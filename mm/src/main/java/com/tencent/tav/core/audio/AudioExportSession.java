package com.tencent.tav.core.audio;

import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;

public class AudioExportSession {
    public static int SEGMENT_DURATION_US = GmsVersion.VERSION_LONGHORN;

    public static IAudioExportTask generateAudioAssetExportTask(Asset asset, String str) {
        AppMethodBeat.i(217981);
        AudioExportTask audioExportTask = new AudioExportTask(new AudioSourceComposition(asset), str);
        AppMethodBeat.o(217981);
        return audioExportTask;
    }

    public static IAudioExportTask generateAudioTrackExportTask(AssetTrack assetTrack, String str) {
        AppMethodBeat.i(217982);
        AudioExportTask audioExportTask = new AudioExportTask(new AudioSourceTrack(assetTrack), str);
        AppMethodBeat.o(217982);
        return audioExportTask;
    }
}
