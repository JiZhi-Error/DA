package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcToActionArg extends PathActionArg {
    public static final Parcelable.Creator<PathArcToActionArg> CREATOR = new Parcelable.Creator<PathArcToActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcToActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathArcToActionArg[] newArray(int i2) {
            return new PathArcToActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathArcToActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145282);
            PathArcToActionArg pathArcToActionArg = new PathArcToActionArg(parcel);
            AppMethodBeat.o(145282);
            return pathArcToActionArg;
        }
    };

    public PathArcToActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(145283);
        AppMethodBeat.o(145283);
    }

    public PathArcToActionArg() {
    }
}
