package com.tencent.thumbplayer.api.composition;

import java.util.List;

public interface ITPMediaTrack extends ITPMediaAsset {
    int addTrackClip(ITPMediaTrackClip iTPMediaTrackClip);

    List<ITPMediaTrackClip> getAllTrackClips();

    long getTimelineDurationMs();

    ITPMediaTrackClip getTrackClip(int i2);

    int getTrackId();

    int insertTrackClip(ITPMediaTrackClip iTPMediaTrackClip, int i2);

    void removeAllTrackClips();

    boolean removeTrackClip(ITPMediaTrackClip iTPMediaTrackClip);

    boolean swapTrackClip(int i2, int i3);
}
