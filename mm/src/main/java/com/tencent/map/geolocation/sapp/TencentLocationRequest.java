package com.tencent.map.geolocation.sapp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TencentLocationRequest {
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;
    public boolean mAllowCache;
    public boolean mAllowDirection;
    public boolean mAllowGps;
    public long mExpirationTime;
    public Bundle mExtras;
    public boolean mIndoorLocationMode;
    public long mInterval;
    public int mNumUpdates;
    public String mQQ;
    public int mRequestLevel;
    public String mSmallAppKey;

    public TencentLocationRequest() {
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        AppMethodBeat.i(223085);
        tencentLocationRequest.mInterval = tencentLocationRequest2.mInterval;
        tencentLocationRequest.mRequestLevel = tencentLocationRequest2.mRequestLevel;
        tencentLocationRequest.mAllowCache = tencentLocationRequest2.mAllowCache;
        tencentLocationRequest.mAllowDirection = tencentLocationRequest2.mAllowDirection;
        tencentLocationRequest.mExpirationTime = tencentLocationRequest2.mExpirationTime;
        tencentLocationRequest.mNumUpdates = tencentLocationRequest2.mNumUpdates;
        tencentLocationRequest.mIndoorLocationMode = tencentLocationRequest2.mIndoorLocationMode;
        tencentLocationRequest.mAllowGps = tencentLocationRequest2.mAllowGps;
        tencentLocationRequest.mQQ = tencentLocationRequest2.mQQ;
        tencentLocationRequest.mSmallAppKey = tencentLocationRequest2.mSmallAppKey;
        tencentLocationRequest.mExtras.clear();
        tencentLocationRequest.mExtras.putAll(tencentLocationRequest2.mExtras);
        AppMethodBeat.o(223085);
    }

    public static TencentLocationRequest create() {
        AppMethodBeat.i(223086);
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.mInterval = 10000;
        tencentLocationRequest.mRequestLevel = 1;
        tencentLocationRequest.mAllowCache = true;
        tencentLocationRequest.mAllowDirection = false;
        tencentLocationRequest.mIndoorLocationMode = false;
        tencentLocationRequest.mExpirationTime = 0;
        tencentLocationRequest.mNumUpdates = Integer.MAX_VALUE;
        tencentLocationRequest.mAllowGps = true;
        tencentLocationRequest.mQQ = "";
        tencentLocationRequest.mSmallAppKey = "";
        tencentLocationRequest.mExtras = new Bundle();
        AppMethodBeat.o(223086);
        return tencentLocationRequest;
    }

    private boolean isAllowedLevel(int i2) {
        return i2 == 0 || i2 == 1 || i2 == 3 || i2 == 4 || i2 == 7;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public final long getInterval() {
        return this.mInterval;
    }

    public final String getPhoneNumber() {
        AppMethodBeat.i(223091);
        String string = this.mExtras.getString("phoneNumber");
        if (string == null) {
            string = "";
        }
        AppMethodBeat.o(223091);
        return string;
    }

    public final String getQQ() {
        return this.mQQ;
    }

    public final int getRequestLevel() {
        return this.mRequestLevel;
    }

    public final String getSmallAppKey() {
        return this.mSmallAppKey;
    }

    public final long getmExpirationTime() {
        return this.mExpirationTime;
    }

    public final boolean isAllowCache() {
        return this.mAllowCache;
    }

    public final boolean isAllowDirection() {
        return this.mAllowDirection;
    }

    public final boolean isAllowGPS() {
        return this.mAllowGps;
    }

    public final boolean isIndoorLocationMode() {
        return this.mIndoorLocationMode;
    }

    public final TencentLocationRequest setAllowCache(boolean z) {
        this.mAllowCache = z;
        return this;
    }

    public final TencentLocationRequest setAllowDirection(boolean z) {
        this.mAllowDirection = z;
        return this;
    }

    public final TencentLocationRequest setAllowGPS(boolean z) {
        this.mAllowGps = z;
        return this;
    }

    public final TencentLocationRequest setIndoorLocationMode(boolean z) {
        this.mIndoorLocationMode = z;
        return this;
    }

    public final TencentLocationRequest setInterval(long j2) {
        AppMethodBeat.i(223087);
        if (j2 >= 0) {
            this.mInterval = j2;
            AppMethodBeat.o(223087);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("interval should >= 0");
        AppMethodBeat.o(223087);
        throw illegalArgumentException;
    }

    public final TencentLocationRequest setPhoneNumber(String str) {
        AppMethodBeat.i(223090);
        if (str == null) {
            str = "";
        }
        this.mExtras.putString("phoneNumber", str);
        AppMethodBeat.o(223090);
        return this;
    }

    public final TencentLocationRequest setQQ(String str) {
        this.mQQ = str;
        return this;
    }

    public final TencentLocationRequest setRequestLevel(int i2) {
        AppMethodBeat.i(223088);
        if (isAllowedLevel(i2)) {
            this.mRequestLevel = i2;
            AppMethodBeat.o(223088);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("request_level: " + i2 + " not supported!");
        AppMethodBeat.o(223088);
        throw illegalArgumentException;
    }

    public final TencentLocationRequest setSmallAppKey(String str) {
        AppMethodBeat.i(223089);
        if (!TextUtils.isEmpty(str)) {
            this.mSmallAppKey = str;
        }
        AppMethodBeat.o(223089);
        return this;
    }

    public final void setmExpirationTime(long j2) {
        this.mExpirationTime = j2;
    }

    public final String toString() {
        AppMethodBeat.i(223092);
        String str = "TencentLocationRequest {interval=" + this.mInterval + "ms,level=" + this.mRequestLevel + ",allowCache=" + this.mAllowCache + ",allowGps=" + this.mAllowGps + ",allowDirection=" + this.mAllowDirection + ",QQ=" + this.mQQ + "}";
        AppMethodBeat.o(223092);
        return str;
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        AppMethodBeat.i(223084);
        this.mInterval = tencentLocationRequest.mInterval;
        this.mRequestLevel = tencentLocationRequest.mRequestLevel;
        this.mAllowCache = tencentLocationRequest.mAllowCache;
        this.mAllowDirection = tencentLocationRequest.mAllowDirection;
        this.mExpirationTime = tencentLocationRequest.mExpirationTime;
        this.mNumUpdates = tencentLocationRequest.mNumUpdates;
        this.mAllowGps = tencentLocationRequest.mAllowGps;
        this.mIndoorLocationMode = tencentLocationRequest.mIndoorLocationMode;
        this.mQQ = tencentLocationRequest.mQQ;
        this.mSmallAppKey = tencentLocationRequest.mSmallAppKey;
        this.mExtras = new Bundle();
        this.mExtras.putAll(tencentLocationRequest.mExtras);
        AppMethodBeat.o(223084);
    }
}
