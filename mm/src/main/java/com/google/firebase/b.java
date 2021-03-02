package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private final String bKy;
    public final String bKz;
    public final String zzs;
    private final String zzt;
    private final String zzu;
    private final String zzw;
    private final String zzx;

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(4063);
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.zzs = str;
        this.bKy = str2;
        this.zzt = str3;
        this.zzu = str4;
        this.bKz = str5;
        this.zzw = str6;
        this.zzx = str7;
        AppMethodBeat.o(4063);
    }

    public static b an(Context context) {
        AppMethodBeat.i(4064);
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            AppMethodBeat.o(4064);
            return null;
        }
        b bVar = new b(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
        AppMethodBeat.o(4064);
        return bVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4065);
        if (!(obj instanceof b)) {
            AppMethodBeat.o(4065);
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equal(this.zzs, bVar.zzs) || !Objects.equal(this.bKy, bVar.bKy) || !Objects.equal(this.zzt, bVar.zzt) || !Objects.equal(this.zzu, bVar.zzu) || !Objects.equal(this.bKz, bVar.bKz) || !Objects.equal(this.zzw, bVar.zzw) || !Objects.equal(this.zzx, bVar.zzx)) {
            AppMethodBeat.o(4065);
            return false;
        }
        AppMethodBeat.o(4065);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(4066);
        int hashCode = Objects.hashCode(this.zzs, this.bKy, this.zzt, this.zzu, this.bKz, this.zzw, this.zzx);
        AppMethodBeat.o(4066);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(4067);
        String toStringHelper = Objects.toStringHelper(this).add("applicationId", this.zzs).add("apiKey", this.bKy).add("databaseUrl", this.zzt).add("gcmSenderId", this.bKz).add("storageBucket", this.zzw).add("projectId", this.zzx).toString();
        AppMethodBeat.o(4067);
        return toStringHelper;
    }
}
