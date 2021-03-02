package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Parcelable.Creator<WepkgVersion> CREATOR = new Parcelable.Creator<WepkgVersion>() {
        /* class com.tencent.mm.plugin.wepkg.model.WepkgVersion.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WepkgVersion[] newArray(int i2) {
            return new WepkgVersion[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WepkgVersion createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110759);
            WepkgVersion wepkgVersion = new WepkgVersion(parcel);
            AppMethodBeat.o(110759);
            return wepkgVersion;
        }
    };
    public int JMZ;
    public boolean JNP;
    public long JNQ;
    public long JNR;
    public int JNS;
    public int JNT;
    public long JNU;
    public boolean JNV;
    public boolean JNW;
    public boolean JNX;
    public int JNY;
    public String appId;
    public String charset;
    public long createTime;
    public String domain;
    public String downloadUrl;
    public int eij;
    public String hhD;
    public String md5;
    public String pkgPath;
    public String version;

    public WepkgVersion() {
    }

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(110760);
        this.hhD = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.pkgPath = parcel.readString();
        this.JNP = parcel.readByte() != 0;
        this.JNQ = parcel.readLong();
        this.JNR = parcel.readLong();
        this.JNS = parcel.readInt();
        this.domain = parcel.readString();
        this.md5 = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.JNT = parcel.readInt();
        this.JMZ = parcel.readInt();
        this.JNU = parcel.readLong();
        this.createTime = parcel.readLong();
        this.charset = parcel.readString();
        this.JNV = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.JNW = z;
        this.JNX = parcel.readByte() == 0 ? false : z2;
        this.JNY = parcel.readInt();
        this.eij = parcel.readInt();
        AppMethodBeat.o(110760);
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.hhD = eVar.field_pkgId;
            this.appId = eVar.field_appId;
            this.version = eVar.field_version;
            this.pkgPath = eVar.field_pkgPath;
            this.JNP = eVar.field_disableWvCache;
            this.JNQ = eVar.field_clearPkgTime;
            this.JNR = eVar.field_checkIntervalTime;
            this.JNS = eVar.field_packMethod;
            this.domain = eVar.field_domain;
            this.md5 = eVar.field_md5;
            this.downloadUrl = eVar.field_downloadUrl;
            this.JNT = eVar.field_pkgSize;
            this.JMZ = eVar.field_downloadNetType;
            this.JNU = eVar.field_nextCheckTime;
            this.createTime = eVar.field_createTime;
            this.charset = eVar.field_charset;
            this.JNV = eVar.field_bigPackageReady;
            this.JNW = eVar.field_preloadFilesReady;
            this.JNX = eVar.field_preloadFilesAtomic;
            this.JNY = eVar.field_totalDownloadCount;
            this.eij = eVar.field_downloadTriggerType;
        }
    }

    public final JSONObject gkT() {
        AppMethodBeat.i(110761);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.pkgPath);
            jSONObject.put("disableWvCache", this.JNP);
            jSONObject.put("clearPkgTime", this.JNQ);
            jSONObject.put("checkIntervalTime", this.JNR);
            jSONObject.put("packMethod", this.JNS);
            jSONObject.put("domain", this.domain);
            jSONObject.put("md5", this.md5);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.JNT);
            jSONObject.put("downloadNetType", this.JMZ);
            jSONObject.put("nextCheckTime", this.JNU);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.JNV);
            jSONObject.put("preloadFilesReady", this.JNW);
            jSONObject.put("preloadFilesAtomic", this.JNX);
            jSONObject.put("totalDownloadCount", this.JNY);
            jSONObject.put("downloadTriggerType", this.eij);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(110761);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(110762);
        parcel.writeString(this.hhD);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.pkgPath);
        parcel.writeByte((byte) (this.JNP ? 1 : 0));
        parcel.writeLong(this.JNQ);
        parcel.writeLong(this.JNR);
        parcel.writeInt(this.JNS);
        parcel.writeString(this.domain);
        parcel.writeString(this.md5);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.JNT);
        parcel.writeInt(this.JMZ);
        parcel.writeLong(this.JNU);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.JNV ? 1 : 0));
        if (this.JNW) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        if (!this.JNX) {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        parcel.writeInt(this.JNY);
        parcel.writeInt(this.eij);
        AppMethodBeat.o(110762);
    }

    static {
        AppMethodBeat.i(110763);
        AppMethodBeat.o(110763);
    }
}
