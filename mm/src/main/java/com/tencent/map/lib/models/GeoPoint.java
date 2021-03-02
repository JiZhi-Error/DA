package com.tencent.map.lib.models;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

@Keep
public class GeoPoint implements Parcelable {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator<GeoPoint>() {
        /* class com.tencent.map.lib.models.GeoPoint.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeoPoint[] newArray(int i2) {
            return new GeoPoint[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoPoint createFromParcel(Parcel parcel) {
            AppMethodBeat.i(180739);
            GeoPoint geoPoint = new GeoPoint(parcel);
            AppMethodBeat.o(180739);
            return geoPoint;
        }
    };
    private int mLatitudeE6;
    private int mLongitudeE6;

    public GeoPoint() {
        this.mLatitudeE6 = -85000001;
        this.mLongitudeE6 = -180000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
    }

    public GeoPoint(int i2, int i3) {
        this.mLatitudeE6 = i2;
        this.mLongitudeE6 = i3;
    }

    public GeoPoint(LatLng latLng) {
        AppMethodBeat.i(193494);
        this.mLatitudeE6 = (int) (latLng.latitude * 1000000.0d);
        this.mLongitudeE6 = (int) (latLng.longitude * 1000000.0d);
        AppMethodBeat.o(193494);
    }

    public static GeoPoint from(LatLng latLng) {
        AppMethodBeat.i(193495);
        if (latLng == null) {
            AppMethodBeat.o(193495);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(latLng);
        AppMethodBeat.o(193495);
        return geoPoint;
    }

    public static List<GeoPoint> from(List<LatLng> list) {
        AppMethodBeat.i(193496);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList(0);
            AppMethodBeat.o(193496);
            return arrayList;
        }
        int size = list.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            LatLng latLng = list.get(i2);
            if (latLng != null) {
                arrayList2.add(from(latLng));
            }
        }
        AppMethodBeat.o(193496);
        return arrayList2;
    }

    public int getLatitudeE6() {
        return this.mLatitudeE6;
    }

    public int getLongitudeE6() {
        return this.mLongitudeE6;
    }

    public void setLatitudeE6(int i2) {
        this.mLatitudeE6 = i2;
    }

    public void setLongitudeE6(int i2) {
        this.mLongitudeE6 = i2;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        AppMethodBeat.i(180740);
        this.mLatitudeE6 = geoPoint.getLatitudeE6();
        this.mLongitudeE6 = geoPoint.getLongitudeE6();
        AppMethodBeat.o(180740);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.mLatitudeE6 == geoPoint.mLatitudeE6 && this.mLongitudeE6 == geoPoint.mLongitudeE6) {
            return true;
        }
        return false;
    }

    public String toString() {
        AppMethodBeat.i(180741);
        String str = this.mLatitudeE6 + "," + this.mLongitudeE6;
        AppMethodBeat.o(180741);
        return str;
    }

    public static GeoPoint formString(String str) {
        AppMethodBeat.i(180742);
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length == 2) {
                    geoPoint.mLatitudeE6 = Integer.parseInt(split[0]);
                    geoPoint.mLongitudeE6 = Integer.parseInt(split[1]);
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(180742);
        return geoPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(180743);
        parcel.writeInt(this.mLatitudeE6);
        parcel.writeInt(this.mLongitudeE6);
        AppMethodBeat.o(180743);
    }

    static {
        AppMethodBeat.i(180746);
        AppMethodBeat.o(180746);
    }

    private GeoPoint(Parcel parcel) {
        AppMethodBeat.i(180744);
        this.mLatitudeE6 = parcel.readInt();
        this.mLongitudeE6 = parcel.readInt();
        AppMethodBeat.o(180744);
    }

    public LatLng toLatLng() {
        AppMethodBeat.i(180745);
        LatLng latLng = new LatLng(((double) this.mLatitudeE6) / 1000000.0d, ((double) this.mLongitudeE6) / 1000000.0d);
        AppMethodBeat.o(180745);
        return latLng;
    }

    public Point toPoint() {
        AppMethodBeat.i(193497);
        Point point = new Point(getLongitudeE6(), getLatitudeE6());
        AppMethodBeat.o(193497);
        return point;
    }
}
