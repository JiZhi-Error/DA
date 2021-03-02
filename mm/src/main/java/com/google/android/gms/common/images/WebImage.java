package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new WebImageCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getWidth", id = 3)
    private final int zzps;
    @SafeParcelable.Field(getter = "getHeight", id = 4)
    private final int zzpt;
    @SafeParcelable.Field(getter = "getUrl", id = 2)
    private final Uri zzpu;

    static {
        AppMethodBeat.i(11746);
        AppMethodBeat.o(11746);
    }

    @SafeParcelable.Constructor
    WebImage(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4) {
        this.zzal = i2;
        this.zzpu = uri;
        this.zzps = i3;
        this.zzpt = i4;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i2, int i3) {
        this(1, uri, i2, i3);
        AppMethodBeat.i(11738);
        if (uri == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("url cannot be null");
            AppMethodBeat.o(11738);
            throw illegalArgumentException;
        } else if (i2 < 0 || i3 < 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("width and height must not be negative");
            AppMethodBeat.o(11738);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(11738);
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(zza(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        AppMethodBeat.i(11739);
        AppMethodBeat.o(11739);
    }

    private static Uri zza(JSONObject jSONObject) {
        AppMethodBeat.i(11740);
        Uri uri = null;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(11740);
        return uri;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(11743);
        if (this == obj) {
            AppMethodBeat.o(11743);
            return true;
        } else if (obj == null || !(obj instanceof WebImage)) {
            AppMethodBeat.o(11743);
            return false;
        } else {
            WebImage webImage = (WebImage) obj;
            if (Objects.equal(this.zzpu, webImage.zzpu) && this.zzps == webImage.zzps && this.zzpt == webImage.zzpt) {
                AppMethodBeat.o(11743);
                return true;
            }
            AppMethodBeat.o(11743);
            return false;
        }
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final Uri getUrl() {
        return this.zzpu;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        AppMethodBeat.i(11744);
        int hashCode = Objects.hashCode(this.zzpu, Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt));
        AppMethodBeat.o(11744);
        return hashCode;
    }

    public final JSONObject toJson() {
        AppMethodBeat.i(11742);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zzpu.toString());
            jSONObject.put("width", this.zzps);
            jSONObject.put("height", this.zzpt);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(11742);
        return jSONObject;
    }

    public final String toString() {
        AppMethodBeat.i(11741);
        String format = String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt), this.zzpu.toString());
        AppMethodBeat.o(11741);
        return format;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11745);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11745);
    }
}
