package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.protocal.protobuf.ach;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "commData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "api-protocol_release"})
public final class ParcelableMultiTaskData implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public ach kHu;

    static {
        AppMethodBeat.i(194312);
        AppMethodBeat.o(194312);
    }

    public ParcelableMultiTaskData() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParcelableMultiTaskData(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(194311);
        Object a2 = c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
        if (a2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CommonMultiTaskData");
            AppMethodBeat.o(194311);
            throw tVar;
        }
        this.kHu = (ach) a2;
        AppMethodBeat.o(194311);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194310);
        p.h(parcel, "dest");
        c.a(this.kHu, parcel);
        AppMethodBeat.o(194310);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "api-protocol_release"})
    public static final class a implements Parcelable.Creator<ParcelableMultiTaskData> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParcelableMultiTaskData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194309);
            p.h(parcel, "source");
            ParcelableMultiTaskData parcelableMultiTaskData = new ParcelableMultiTaskData(parcel);
            AppMethodBeat.o(194309);
            return parcelableMultiTaskData;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParcelableMultiTaskData[] newArray(int i2) {
            return new ParcelableMultiTaskData[i2];
        }
    }
}
