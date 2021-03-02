package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

public abstract class OverSeaTileProvider extends UrlTileProvider {
    private String mProviderName;
    private int mProviderVersion;

    public abstract Bitmap getLogo(boolean z);

    public OverSeaTileProvider(String str, int i2) {
        this.mProviderName = str;
        this.mProviderVersion = i2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("图源名不能为空");
        }
    }

    public final String getProviderName() {
        return this.mProviderName;
    }

    public final int getProviderVersion() {
        return this.mProviderVersion;
    }

    public boolean onDayNightChange(boolean z) {
        return false;
    }

    public boolean onLanguageChange(Language language) {
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("OverSeaProvider{");
        stringBuffer.append("mProviderName='").append(this.mProviderName).append('\'');
        stringBuffer.append(", mProviderVersion=").append(this.mProviderVersion);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
