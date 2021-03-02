package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Parcelable.Creator<WepkgPreloadFile> CREATOR = new Parcelable.Creator<WepkgPreloadFile>() {
        /* class com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WepkgPreloadFile[] newArray(int i2) {
            return new WepkgPreloadFile[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WepkgPreloadFile createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110719);
            WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile(parcel);
            AppMethodBeat.o(110719);
            return wepkgPreloadFile;
        }
    };
    public int JMZ;
    public boolean JNA;
    public String JNn;
    public long createTime;
    public String downloadUrl;
    public String filePath;
    public String hhD;
    public String key;
    public String md5;
    public String mimeType;
    public int size;
    public String version;

    public WepkgPreloadFile() {
    }

    public WepkgPreloadFile(Parcel parcel) {
        AppMethodBeat.i(110720);
        this.key = parcel.readString();
        this.hhD = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.JNn = parcel.readString();
        this.mimeType = parcel.readString();
        this.md5 = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.JMZ = parcel.readInt();
        this.JNA = parcel.readByte() != 0;
        this.createTime = parcel.readLong();
        AppMethodBeat.o(110720);
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.key = cVar.field_key;
            this.hhD = cVar.field_pkgId;
            this.version = cVar.field_version;
            this.filePath = cVar.field_filePath;
            this.JNn = cVar.field_rid;
            this.mimeType = cVar.field_mimeType;
            this.md5 = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.size = cVar.field_size;
            this.JMZ = cVar.field_downloadNetType;
            this.JNA = cVar.field_completeDownload;
            this.createTime = cVar.field_createTime;
        }
    }

    public final JSONObject gkT() {
        AppMethodBeat.i(110721);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("pkgId", this.hhD);
            jSONObject.put("version", this.version);
            jSONObject.put("filePath", this.filePath);
            jSONObject.put("rid", this.JNn);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.md5);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.JMZ);
            jSONObject.put("completeDownload", this.JNA);
            jSONObject.put("createTime", this.createTime);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(110721);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(110722);
        parcel.writeString(this.key);
        parcel.writeString(this.hhD);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.JNn);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.md5);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.JMZ);
        parcel.writeByte((byte) (this.JNA ? 1 : 0));
        parcel.writeLong(this.createTime);
        AppMethodBeat.o(110722);
    }

    static {
        AppMethodBeat.i(110723);
        AppMethodBeat.o(110723);
    }
}
