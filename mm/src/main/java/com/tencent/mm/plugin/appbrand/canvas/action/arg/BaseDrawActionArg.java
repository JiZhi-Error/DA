package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONObject;

public abstract class BaseDrawActionArg implements DrawActionArg {
    public String method;

    public BaseDrawActionArg(Parcel parcel) {
        this.method = parcel.readString();
    }

    public BaseDrawActionArg() {
    }

    @Deprecated
    public BaseDrawActionArg(Parcel parcel, byte b2) {
        i(parcel);
    }

    public boolean bzk() {
        return false;
    }

    @Deprecated
    public void i(Parcel parcel) {
        this.method = parcel.readString();
    }

    public void parse(JSONObject jSONObject) {
        this.method = jSONObject.optString(FirebaseAnalytics.b.METHOD);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.method);
    }

    public String toString() {
        return String.format("method %s", this.method);
    }

    public boolean a(d dVar, Canvas canvas) {
        return false;
    }

    public void reset() {
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseDrawActionArg)) {
            return false;
        }
        BaseDrawActionArg baseDrawActionArg = (BaseDrawActionArg) obj;
        if (this.method != baseDrawActionArg.method) {
            return this.method != null && this.method.equals(baseDrawActionArg.method);
        }
        return true;
    }
}
