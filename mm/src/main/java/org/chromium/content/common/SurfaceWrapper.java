package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SurfaceWrapper implements Parcelable {
    public static final Parcelable.Creator<SurfaceWrapper> CREATOR = new Parcelable.Creator<SurfaceWrapper>() {
        /* class org.chromium.content.common.SurfaceWrapper.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final SurfaceWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(53755);
            SurfaceWrapper surfaceWrapper = new SurfaceWrapper((Surface) Surface.CREATOR.createFromParcel(parcel));
            AppMethodBeat.o(53755);
            return surfaceWrapper;
        }

        @Override // android.os.Parcelable.Creator
        public final SurfaceWrapper[] newArray(int i2) {
            return new SurfaceWrapper[i2];
        }
    };
    private final Surface mSurface;

    public SurfaceWrapper(Surface surface) {
        this.mSurface = surface;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(53750);
        this.mSurface.writeToParcel(parcel, 0);
        AppMethodBeat.o(53750);
    }

    static {
        AppMethodBeat.i(53751);
        AppMethodBeat.o(53751);
    }
}
