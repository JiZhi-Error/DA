package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableComposition extends Composition<MutableCompositionTrack> {
    public MutableComposition() {
        AppMethodBeat.i(217655);
        setNaturalSize(new CGSize(0.0f, 0.0f));
        AppMethodBeat.o(217655);
    }

    @Override // com.tencent.tav.asset.Asset
    public MutableCompositionTrack trackWithTrackID(int i2) {
        AppMethodBeat.i(217656);
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            if (mutableCompositionTrack != null && mutableCompositionTrack.getTrackID() == i2) {
                AppMethodBeat.o(217656);
                return mutableCompositionTrack;
            }
        }
        AppMethodBeat.o(217656);
        return null;
    }

    @Override // com.tencent.tav.asset.Asset
    public List<MutableCompositionTrack> tracksWithMediaType(int i2) {
        AppMethodBeat.i(217657);
        ArrayList arrayList = new ArrayList();
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            if (mutableCompositionTrack != null && mutableCompositionTrack.getMediaType() == i2) {
                arrayList.add(mutableCompositionTrack);
            }
        }
        AppMethodBeat.o(217657);
        return arrayList;
    }

    @Override // com.tencent.tav.asset.Composition, com.tencent.tav.asset.Asset
    public List<MutableCompositionTrack> getTracks() {
        AppMethodBeat.i(217658);
        new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
        List<MutableCompositionTrack> list = this.tracks;
        AppMethodBeat.o(217658);
        return list;
    }

    public void setNaturalSize(CGSize cGSize) {
        AppMethodBeat.i(217659);
        this.naturalSize = cGSize;
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            if (mutableCompositionTrack != null && mutableCompositionTrack.getMediaType() == 1 && mutableCompositionTrack.getNaturalSize() == null) {
                mutableCompositionTrack.setNaturalSize(cGSize);
            }
        }
        AppMethodBeat.o(217659);
    }

    @Override // com.tencent.tav.asset.Asset
    public CGSize getNaturalSize() {
        AppMethodBeat.i(217660);
        if (this.naturalSize.equals(CGSize.CGSizeZero)) {
            for (CompositionTrack compositionTrack : this.tracks) {
                if (compositionTrack.enabled) {
                    CGSize naturalSize = compositionTrack.getNaturalSize();
                    AppMethodBeat.o(217660);
                    return naturalSize;
                }
            }
        }
        CGSize cGSize = this.naturalSize;
        AppMethodBeat.o(217660);
        return cGSize;
    }

    public void setPreferRotation(int i2) {
        this.preferRotation = i2;
    }

    @Override // com.tencent.tav.asset.Asset
    public int getPreferRotation() {
        AppMethodBeat.i(217661);
        if (this.preferRotation == 0) {
            for (CompositionTrack compositionTrack : this.tracks) {
                if (compositionTrack.enabled) {
                    int preferredRotation = compositionTrack.getPreferredRotation();
                    AppMethodBeat.o(217661);
                    return preferredRotation;
                }
            }
        }
        int i2 = this.preferRotation;
        AppMethodBeat.o(217661);
        return i2;
    }

    public void setPreferredVolume(float f2) {
        this.preferredVolume = f2;
    }

    public boolean insertTimeRange(CMTimeRange cMTimeRange, Asset asset, CMTime cMTime) {
        boolean z;
        AppMethodBeat.i(217662);
        if (cMTimeRange.getDuration().value <= 0 || asset == null || asset.getTrackCount() == 0) {
            AppMethodBeat.o(217662);
            return false;
        }
        List tracks = asset.getTracks();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < tracks.size(); i2++) {
            AssetTrack assetTrack = (AssetTrack) tracks.get(i2);
            int i3 = i2;
            while (true) {
                if (i3 >= this.tracks.size()) {
                    z = false;
                    break;
                }
                MutableCompositionTrack mutableCompositionTrack = (MutableCompositionTrack) this.tracks.get(i3);
                if (mutableCompositionTrack.getMediaType() != assetTrack.getMediaType()) {
                    i3++;
                } else if (!mutableCompositionTrack.insertTimeRange(cMTimeRange, assetTrack, cMTime)) {
                    AppMethodBeat.o(217662);
                    return false;
                } else {
                    arrayList.add(Integer.valueOf(mutableCompositionTrack.getTrackID()));
                    z = true;
                }
            }
            if (!z) {
                int mediaType = assetTrack.getMediaType();
                int i4 = this.trackIndex;
                this.trackIndex = i4 + 1;
                MutableCompositionTrack addMutableTrackWithMediaType = addMutableTrackWithMediaType(mediaType, i4);
                if (!addMutableTrackWithMediaType.insertTimeRange(cMTimeRange, assetTrack, cMTime)) {
                    AppMethodBeat.o(217662);
                    return false;
                }
                arrayList.add(Integer.valueOf(addMutableTrackWithMediaType.getTrackID()));
            }
        }
        for (MutableCompositionTrack mutableCompositionTrack2 : this.tracks) {
            if (!arrayList.contains(Integer.valueOf(mutableCompositionTrack2.getTrackID()))) {
                mutableCompositionTrack2.insertEmptyTimeRange(cMTimeRange);
            }
        }
        AppMethodBeat.o(217662);
        return true;
    }

    public void insertEmptyTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217663);
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            mutableCompositionTrack.insertEmptyTimeRange(cMTimeRange);
        }
        AppMethodBeat.o(217663);
    }

    public void removeTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217664);
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            mutableCompositionTrack.removeTimeRange(cMTimeRange);
        }
        AppMethodBeat.o(217664);
    }

    public void scaleTimeRange(CMTimeRange cMTimeRange, CMTime cMTime) {
        AppMethodBeat.i(217665);
        for (MutableCompositionTrack mutableCompositionTrack : this.tracks) {
            mutableCompositionTrack.scaleTimeRange(cMTimeRange, cMTime);
        }
        AppMethodBeat.o(217665);
    }

    public MutableCompositionTrack addMutableTrackWithMediaType(int i2, int i3) {
        AppMethodBeat.i(217666);
        MutableCompositionTrack mutableCompositionTrack = new MutableCompositionTrack(i2, getCorrectTrackID(i3));
        mutableCompositionTrack.setNaturalSize(getNaturalSize());
        this.tracks.add(mutableCompositionTrack);
        this.trackCount++;
        AppMethodBeat.o(217666);
        return mutableCompositionTrack;
    }

    public void removeTrack(CompositionTrack compositionTrack) {
        AppMethodBeat.i(217667);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.tracks.size()) {
                if (((MutableCompositionTrack) this.tracks.get(i3)) == compositionTrack) {
                    this.tracks.remove(i3);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(217667);
                return;
            }
        }
    }

    public MutableCompositionTrack mutableTrackCompatibleWithTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(217668);
        if (assetTrack == null || assetTrack.getAsset() == null) {
            AppMethodBeat.o(217668);
            return null;
        }
        MutableCompositionTrack mutableCompositionTrack = new MutableCompositionTrack(assetTrack.getMediaType(), getCorrectTrackID(-1));
        mutableCompositionTrack.insertTimeRange(assetTrack.getTimeRange(), assetTrack, CMTime.CMTimeZero);
        mutableCompositionTrack.setPreferredTransform(assetTrack.getPreferredTransform());
        mutableCompositionTrack.setPreferredRotation(assetTrack.getPreferredRotation());
        mutableCompositionTrack.setPreferredVolume(assetTrack.getPreferredVolume());
        AppMethodBeat.o(217668);
        return mutableCompositionTrack;
    }

    private int getCorrectTrackID(int i2) {
        boolean z;
        AppMethodBeat.i(217669);
        Iterator it = this.tracks.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((MutableCompositionTrack) it.next()).getTrackID() == i2) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z && i2 > 0) {
            AppMethodBeat.o(217669);
            return i2;
        } else if (i2 == -1) {
            int i3 = this.trackIndex;
            this.trackIndex = i3 + 1;
            AppMethodBeat.o(217669);
            return i3;
        } else if (this.trackIndex >= i2) {
            int i4 = this.trackIndex;
            this.trackIndex = i4 + 1;
            AppMethodBeat.o(217669);
            return i4;
        } else {
            this.trackIndex = i2;
            int i5 = this.trackIndex;
            AppMethodBeat.o(217669);
            return i5;
        }
    }
}
