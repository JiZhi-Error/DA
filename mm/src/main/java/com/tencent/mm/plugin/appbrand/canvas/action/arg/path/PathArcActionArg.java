package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcActionArg extends PathActionArg {
    public static final Parcelable.Creator<PathArcActionArg> CREATOR = new Parcelable.Creator<PathArcActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathArcActionArg[] newArray(int i2) {
            return new PathArcActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathArcActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145280);
            PathArcActionArg pathArcActionArg = new PathArcActionArg(parcel);
            AppMethodBeat.o(145280);
            return pathArcActionArg;
        }
    };

    public PathArcActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(145281);
        AppMethodBeat.o(145281);
    }

    public PathArcActionArg() {
    }
}
