package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Parcelable.Creator<PluginDescription> CREATOR = new Parcelable.Creator<PluginDescription>() {
        /* class com.tencent.mm.compatible.loader.PluginDescription.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PluginDescription[] newArray(int i2) {
            return new PluginDescription[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PluginDescription createFromParcel(Parcel parcel) {
            AppMethodBeat.i(155829);
            PluginDescription pluginDescription = new PluginDescription(parcel);
            AppMethodBeat.o(155829);
            return pluginDescription;
        }
    };
    public final int gKN;
    public final String md5;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(155830);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.gKN);
        AppMethodBeat.o(155830);
    }

    static {
        AppMethodBeat.i(155833);
        AppMethodBeat.o(155833);
    }

    protected PluginDescription(Parcel parcel) {
        AppMethodBeat.i(155831);
        this.name = (String) m.checkNotNull(parcel.readString());
        this.url = (String) m.checkNotNull(parcel.readString());
        this.md5 = (String) m.checkNotNull(parcel.readString());
        this.version = (String) m.checkNotNull(parcel.readString());
        this.size = parcel.readInt();
        this.gKN = parcel.readInt();
        AppMethodBeat.o(155831);
    }

    public String toString() {
        AppMethodBeat.i(155832);
        String format = String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", this.name, this.url, this.md5, this.version, Integer.valueOf(this.size), Integer.valueOf(this.gKN));
        AppMethodBeat.o(155832);
        return format;
    }
}
