package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/qbar/WxQBarPoint;", "Lcom/tencent/qbar/QbarNative$QBarPoint;", "Landroid/os/Parcelable;", "()V", "point", "(Lcom/tencent/qbar/QbarNative$QBarPoint;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "scan-sdk_release"})
public final class WxQBarPoint extends QbarNative.QBarPoint implements Parcelable {
    public static final a CREATOR = new a((byte) 0);

    static {
        AppMethodBeat.i(176221);
        AppMethodBeat.o(176221);
    }

    public WxQBarPoint() {
    }

    public WxQBarPoint(QbarNative.QBarPoint qBarPoint) {
        AppMethodBeat.i(176219);
        if (qBarPoint == null) {
            AppMethodBeat.o(176219);
            return;
        }
        this.point_cnt = qBarPoint.point_cnt;
        this.x0 = qBarPoint.x0;
        this.x1 = qBarPoint.x1;
        this.x2 = qBarPoint.x2;
        this.x3 = qBarPoint.x3;
        this.y0 = qBarPoint.y0;
        this.y1 = qBarPoint.y1;
        this.y2 = qBarPoint.y2;
        this.y3 = qBarPoint.y3;
        AppMethodBeat.o(176219);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WxQBarPoint(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(176220);
        this.point_cnt = parcel.readInt();
        this.x0 = parcel.readFloat();
        this.x1 = parcel.readFloat();
        this.x2 = parcel.readFloat();
        this.x3 = parcel.readFloat();
        this.y0 = parcel.readFloat();
        this.y1 = parcel.readFloat();
        this.y2 = parcel.readFloat();
        this.y3 = parcel.readFloat();
        AppMethodBeat.o(176220);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(176218);
        p.h(parcel, "parcel");
        parcel.writeInt(this.point_cnt);
        parcel.writeFloat(this.x0);
        parcel.writeFloat(this.x1);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.x3);
        parcel.writeFloat(this.y0);
        parcel.writeFloat(this.y1);
        parcel.writeFloat(this.y2);
        parcel.writeFloat(this.y3);
        AppMethodBeat.o(176218);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/qbar/WxQBarPoint$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/WxQBarPoint;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/WxQBarPoint;", "scan-sdk_release"})
    public static final class a implements Parcelable.Creator<WxQBarPoint> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxQBarPoint createFromParcel(Parcel parcel) {
            AppMethodBeat.i(176217);
            p.h(parcel, "parcel");
            WxQBarPoint wxQBarPoint = new WxQBarPoint(parcel);
            AppMethodBeat.o(176217);
            return wxQBarPoint;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxQBarPoint[] newArray(int i2) {
            return new WxQBarPoint[i2];
        }
    }
}
