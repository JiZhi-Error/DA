package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import java.lang.reflect.Field;
import java.util.Arrays;

public final class TencentMapOptions {
    public static final int LOGO_POSITION_BOTTOM_CENTER = 4;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
    public static final int LOGO_POSITION_TOP_CENTER = 5;
    public static final int LOGO_POSITION_TOP_LEFT = 3;
    public static final int LOGO_POSITION_TOP_RIGHT = 2;
    public static final int SCALEVIEW_POSITION_BOTTOM_CENTER = 4;
    public static final int SCALEVIEW_POSITION_BOTTOM_LEFT = 0;
    public static final int SCALEVIEW_POSITION_BOTTOM_RIGHT = 1;
    public static final int SCALEVIEW_POSITION_TOP_CENTER = 5;
    public static final int SCALEVIEW_POSITION_TOP_LEFT = 3;
    public static final int SCALEVIEW_POSITION_TOP_RIGHT = 2;
    public static final int ZOOM_POSITION_BOTTOM_LEFT = 0;
    public static final int ZOOM_POSITION_BOTTOM_RIGHT = 1;
    public static final int ZOOM_POSITION_TOP_LEFT = 3;
    public static final int ZOOM_POSITION_TOP_RIGHT = 2;
    private String customAssetsPath;
    private String customLocalPath;
    private boolean isEnableMultipleInfoWindow = false;
    private boolean isHandDrawMapEnable = false;
    private String mCustomCacheRootPath;
    private String mCustomUserId;
    private String[] mDebugTags;
    private Object mExtSurface;
    private int mExtSurfaceHeight;
    private int mExtSurfaceWidth;
    private boolean mForceHttps = true;
    private Callback<TencentMap> mMapCallback;
    private float mMapFrameRate = 60.0f;
    private IMapKernel mMapKernel;
    private String mMapKey;
    private MapViewType mMapViewType;
    private AdapterType mNetAdapterType = AdapterType.DEFAULT;
    private Bundle mNetParams;
    private boolean mOfflineMapEnable;
    private OverSeaSource mOverSeaSource = OverSeaSource.DEFAULT;
    private Object mProtocolDataDesc;
    private int mProtocolFrom;
    private String mSatelliteVersion = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String mSubId;
    private String mSubKey;
    private TrafficStyle mTrafficStyle;
    private Typeface mUserTypeface;

    public interface IMapKernel {
        String name();
    }

    public final boolean isForceHttps() {
        return this.mForceHttps;
    }

    public final TencentMapOptions setForceHttps(boolean z) {
        this.mForceHttps = z;
        return this;
    }

    public final String getCustomAssetsPath() {
        return this.customAssetsPath;
    }

    public final TencentMapOptions setCustomAssetsPath(String str) {
        this.customAssetsPath = str;
        return this;
    }

    public final String getCustomLocalPath() {
        return this.customLocalPath;
    }

    public final TencentMapOptions setCustomLocalPath(String str) {
        this.customLocalPath = str;
        return this;
    }

    public final String getCustomCacheRootPath() {
        return this.mCustomCacheRootPath;
    }

    public final TencentMapOptions setCustomCacheRootPath(String str) {
        this.mCustomCacheRootPath = str;
        return this;
    }

    public final TencentMapOptions setHandDrawMapEnable(boolean z) {
        this.isHandDrawMapEnable = z;
        return this;
    }

    public final boolean isHandDrawMapEnable() {
        return this.isHandDrawMapEnable;
    }

    public final Object getExtSurface() {
        return this.mExtSurface;
    }

    public final TencentMapOptions setExtSurface(Object obj) {
        AppMethodBeat.i(193600);
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
            this.mExtSurface = obj;
            AppMethodBeat.o(193600);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
        AppMethodBeat.o(193600);
        throw illegalArgumentException;
    }

    public final TencentMapOptions setTypeface(Typeface typeface) {
        AppMethodBeat.i(193601);
        setTypeface(typeface, false);
        AppMethodBeat.o(193601);
        return this;
    }

    private void setTypeface(Typeface typeface, boolean z) {
        AppMethodBeat.i(181044);
        if (typeface == null) {
            AppMethodBeat.o(181044);
        } else if (z) {
            try {
                Field declaredField = Typeface.class.getDeclaredField("DEFAULT");
                declaredField.setAccessible(true);
                declaredField.set(Typeface.DEFAULT, typeface);
                AppMethodBeat.o(181044);
            } catch (NoSuchFieldException e2) {
                AppMethodBeat.o(181044);
            } catch (IllegalAccessException e3) {
                AppMethodBeat.o(181044);
            }
        } else {
            this.mUserTypeface = typeface;
            AppMethodBeat.o(181044);
        }
    }

    public final Typeface getTypeface() {
        return this.mUserTypeface == null ? Typeface.DEFAULT : this.mUserTypeface;
    }

    public final String[] getDebugTags() {
        return this.mDebugTags;
    }

    public final TencentMapOptions setExtSurfaceDimension(int i2, int i3) {
        this.mExtSurfaceWidth = i2;
        this.mExtSurfaceHeight = i3;
        return this;
    }

    public final int getExtSurfaceWidth() {
        return this.mExtSurfaceWidth;
    }

    public final int getExtSurfaceHeight() {
        return this.mExtSurfaceHeight;
    }

    public final TencentMapOptions setSubInfo(String str, String str2) {
        AppMethodBeat.i(193602);
        if (str != null) {
            this.mSubKey = str.trim();
        } else {
            this.mSubKey = "";
        }
        if (str2 != null) {
            this.mSubId = str2.trim();
        } else {
            this.mSubId = "";
        }
        AppMethodBeat.o(193602);
        return this;
    }

    public final String getSubId() {
        return this.mSubId;
    }

    public final String getSubKey() {
        return this.mSubKey;
    }

    public final TencentMapOptions setMapKey(String str) {
        this.mMapKey = str;
        return this;
    }

    public final String getMapKey() {
        return this.mMapKey;
    }

    public final TencentMapOptions openDebugLogByTags(String... strArr) {
        this.mDebugTags = strArr;
        return this;
    }

    public final TencentMapOptions setMultipleInfoWindowEnable(boolean z) {
        this.isEnableMultipleInfoWindow = z;
        return this;
    }

    public final boolean isMultipleInfoWindowEnable() {
        return this.isEnableMultipleInfoWindow;
    }

    public final TencentMapOptions setSatelliteVersion(String str) {
        this.mSatelliteVersion = str;
        return this;
    }

    public final String getSatelliteVersion() {
        return this.mSatelliteVersion;
    }

    public final TencentMapOptions setMapViewType(MapViewType mapViewType) {
        this.mMapViewType = mapViewType;
        return this;
    }

    public final MapViewType getMapViewType() {
        return this.mMapViewType;
    }

    public final TencentMapOptions setMapKernel(IMapKernel iMapKernel) {
        this.mMapKernel = iMapKernel;
        return this;
    }

    public final IMapKernel getMapKernel() {
        return this.mMapKernel;
    }

    public final TencentMapOptions setServiceProtocol(int i2, Object obj) {
        this.mProtocolFrom = i2;
        this.mProtocolDataDesc = obj;
        return this;
    }

    public final int getProtocolFrom() {
        return this.mProtocolFrom;
    }

    public final Object getProtocolDataDesc() {
        return this.mProtocolDataDesc;
    }

    public final TencentMapOptions setNetAdapter(AdapterType adapterType, Bundle bundle) {
        this.mNetAdapterType = adapterType;
        this.mNetParams = bundle;
        return this;
    }

    public final AdapterType getNetAdapterType() {
        return this.mNetAdapterType;
    }

    public final Bundle getNetParams() {
        return this.mNetParams;
    }

    public final TencentMapOptions setCustomUserID(String str) {
        this.mCustomUserId = str;
        return this;
    }

    public final String getCustomUserId() {
        return this.mCustomUserId;
    }

    public final TencentMapOptions setGetMapAsync(Callback<TencentMap> callback) {
        this.mMapCallback = callback;
        return this;
    }

    public final Callback<TencentMap> getMapAsyncCallback() {
        return this.mMapCallback;
    }

    public final TencentMapOptions setOfflineMapEnable(boolean z) {
        this.mOfflineMapEnable = z;
        return this;
    }

    public final boolean isOfflineMapEnable() {
        return this.mOfflineMapEnable;
    }

    public final TencentMapOptions setOverSeaSource(OverSeaSource overSeaSource) {
        this.mOverSeaSource = overSeaSource;
        return this;
    }

    public final OverSeaSource getOverSeaSource() {
        return this.mOverSeaSource;
    }

    public final TrafficStyle getTrafficStyle() {
        return this.mTrafficStyle;
    }

    public final TencentMapOptions setTrafficStyle(TrafficStyle trafficStyle) {
        this.mTrafficStyle = trafficStyle;
        return this;
    }

    public final float getMapFrameRate() {
        return this.mMapFrameRate;
    }

    public final TencentMapOptions setMapFrameRate(float f2) {
        this.mMapFrameRate = f2;
        return this;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(181046);
        if (this == obj) {
            AppMethodBeat.o(181046);
            return true;
        } else if (!(obj instanceof TencentMapOptions)) {
            AppMethodBeat.o(181046);
            return false;
        } else {
            TencentMapOptions tencentMapOptions = (TencentMapOptions) obj;
            if (this.isHandDrawMapEnable != tencentMapOptions.isHandDrawMapEnable) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mExtSurfaceWidth != tencentMapOptions.mExtSurfaceWidth) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mExtSurfaceHeight != tencentMapOptions.mExtSurfaceHeight) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.isEnableMultipleInfoWindow != tencentMapOptions.isEnableMultipleInfoWindow) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mProtocolFrom != tencentMapOptions.mProtocolFrom) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mOfflineMapEnable != tencentMapOptions.mOfflineMapEnable) {
                AppMethodBeat.o(181046);
                return false;
            } else if (Float.compare(tencentMapOptions.mMapFrameRate, this.mMapFrameRate) != 0) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.customAssetsPath == null ? tencentMapOptions.customAssetsPath != null : !this.customAssetsPath.equals(tencentMapOptions.customAssetsPath)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.customLocalPath == null ? tencentMapOptions.customLocalPath != null : !this.customLocalPath.equals(tencentMapOptions.customLocalPath)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mCustomCacheRootPath == null ? tencentMapOptions.mCustomCacheRootPath != null : !this.mCustomCacheRootPath.equals(tencentMapOptions.mCustomCacheRootPath)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mExtSurface == null ? tencentMapOptions.mExtSurface != null : !this.mExtSurface.equals(tencentMapOptions.mExtSurface)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mSubId == null ? tencentMapOptions.mSubId != null : !this.mSubId.equals(tencentMapOptions.mSubId)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mSubKey == null ? tencentMapOptions.mSubKey != null : !this.mSubKey.equals(tencentMapOptions.mSubKey)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mMapKey == null ? tencentMapOptions.mMapKey != null : !this.mMapKey.equals(tencentMapOptions.mMapKey)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (!Arrays.equals(this.mDebugTags, tencentMapOptions.mDebugTags)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mSatelliteVersion == null ? tencentMapOptions.mSatelliteVersion != null : !this.mSatelliteVersion.equals(tencentMapOptions.mSatelliteVersion)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mMapViewType != tencentMapOptions.mMapViewType) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mMapKernel == null ? tencentMapOptions.mMapKernel != null : !this.mMapKernel.equals(tencentMapOptions.mMapKernel)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mUserTypeface == null ? tencentMapOptions.mUserTypeface != null : !this.mUserTypeface.equals(tencentMapOptions.mUserTypeface)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mProtocolDataDesc == null ? tencentMapOptions.mProtocolDataDesc != null : !this.mProtocolDataDesc.equals(tencentMapOptions.mProtocolDataDesc)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mNetAdapterType != tencentMapOptions.mNetAdapterType) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mNetParams == null ? tencentMapOptions.mNetParams != null : !this.mNetParams.equals(tencentMapOptions.mNetParams)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mCustomUserId == null ? tencentMapOptions.mCustomUserId != null : !this.mCustomUserId.equals(tencentMapOptions.mCustomUserId)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mMapCallback == null ? tencentMapOptions.mMapCallback != null : !this.mMapCallback.equals(tencentMapOptions.mMapCallback)) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mOverSeaSource != tencentMapOptions.mOverSeaSource) {
                AppMethodBeat.o(181046);
                return false;
            } else if (this.mTrafficStyle != null) {
                boolean equals = this.mTrafficStyle.equals(tencentMapOptions.mTrafficStyle);
                AppMethodBeat.o(181046);
                return equals;
            } else if (tencentMapOptions.mTrafficStyle == null) {
                AppMethodBeat.o(181046);
                return true;
            } else {
                AppMethodBeat.o(181046);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21 = 1;
        int i22 = 0;
        AppMethodBeat.i(181047);
        int hashCode = (this.customAssetsPath != null ? this.customAssetsPath.hashCode() : 0) * 31;
        if (this.customLocalPath != null) {
            i2 = this.customLocalPath.hashCode();
        } else {
            i2 = 0;
        }
        int i23 = (i2 + hashCode) * 31;
        if (this.mCustomCacheRootPath != null) {
            i3 = this.mCustomCacheRootPath.hashCode();
        } else {
            i3 = 0;
        }
        int i24 = (i3 + i23) * 31;
        if (this.isHandDrawMapEnable) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i25 = (i4 + i24) * 31;
        if (this.mExtSurface != null) {
            i5 = this.mExtSurface.hashCode();
        } else {
            i5 = 0;
        }
        int i26 = (((((i5 + i25) * 31) + this.mExtSurfaceWidth) * 31) + this.mExtSurfaceHeight) * 31;
        if (this.mSubId != null) {
            i6 = this.mSubId.hashCode();
        } else {
            i6 = 0;
        }
        int i27 = (i6 + i26) * 31;
        if (this.mSubKey != null) {
            i7 = this.mSubKey.hashCode();
        } else {
            i7 = 0;
        }
        int i28 = (i7 + i27) * 31;
        if (this.mMapKey != null) {
            i8 = this.mMapKey.hashCode();
        } else {
            i8 = 0;
        }
        int i29 = (i8 + i28) * 31;
        if (this.isEnableMultipleInfoWindow) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        int hashCode2 = (((i9 + i29) * 31) + Arrays.hashCode(this.mDebugTags)) * 31;
        if (this.mSatelliteVersion != null) {
            i10 = this.mSatelliteVersion.hashCode();
        } else {
            i10 = 0;
        }
        int i30 = (i10 + hashCode2) * 31;
        if (this.mMapViewType != null) {
            i11 = this.mMapViewType.hashCode();
        } else {
            i11 = 0;
        }
        int i31 = (i11 + i30) * 31;
        if (this.mMapKernel != null) {
            i12 = this.mMapKernel.hashCode();
        } else {
            i12 = 0;
        }
        int i32 = (i12 + i31) * 31;
        if (this.mUserTypeface != null) {
            i13 = this.mUserTypeface.hashCode();
        } else {
            i13 = 0;
        }
        int i33 = (((i13 + i32) * 31) + this.mProtocolFrom) * 31;
        if (this.mProtocolDataDesc != null) {
            i14 = this.mProtocolDataDesc.hashCode();
        } else {
            i14 = 0;
        }
        int i34 = (i14 + i33) * 31;
        if (this.mNetAdapterType != null) {
            i15 = this.mNetAdapterType.hashCode();
        } else {
            i15 = 0;
        }
        int i35 = (i15 + i34) * 31;
        if (this.mNetParams != null) {
            i16 = this.mNetParams.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i16 + i35) * 31;
        if (this.mCustomUserId != null) {
            i17 = this.mCustomUserId.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i17 + i36) * 31;
        if (this.mMapCallback != null) {
            i18 = this.mMapCallback.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i18 + i37) * 31;
        if (!this.mOfflineMapEnable) {
            i21 = 0;
        }
        int i39 = (i38 + i21) * 31;
        if (this.mOverSeaSource != null) {
            i19 = this.mOverSeaSource.hashCode();
        } else {
            i19 = 0;
        }
        int i40 = (i19 + i39) * 31;
        if (this.mTrafficStyle != null) {
            i20 = this.mTrafficStyle.hashCode();
        } else {
            i20 = 0;
        }
        int i41 = (i20 + i40) * 31;
        if (this.mMapFrameRate != 0.0f) {
            i22 = Float.floatToIntBits(this.mMapFrameRate);
        }
        int i42 = i41 + i22;
        AppMethodBeat.o(181047);
        return i42;
    }

    public final String toString() {
        AppMethodBeat.i(193603);
        StringBuffer stringBuffer = new StringBuffer("TencentMapOptions{");
        stringBuffer.append("customAssetsPath='").append(this.customAssetsPath).append('\'');
        stringBuffer.append(", customLocalPath='").append(this.customLocalPath).append('\'');
        stringBuffer.append(", mCustomCacheRootPath='").append(this.mCustomCacheRootPath).append('\'');
        stringBuffer.append(", isHandDrawMapEnable=").append(this.isHandDrawMapEnable);
        stringBuffer.append(", mExtSurface=").append(this.mExtSurface);
        stringBuffer.append(", mExtSurfaceWidth=").append(this.mExtSurfaceWidth);
        stringBuffer.append(", mExtSurfaceHeight=").append(this.mExtSurfaceHeight);
        stringBuffer.append(", mSubId='").append(this.mSubId).append('\'');
        stringBuffer.append(", mSubKey='").append(this.mSubKey).append('\'');
        stringBuffer.append(", mMapKey='").append(this.mMapKey).append('\'');
        stringBuffer.append(", isEnableMultipleInfoWindow=").append(this.isEnableMultipleInfoWindow);
        stringBuffer.append(", mDebugTags=").append(this.mDebugTags == null ? BuildConfig.COMMAND : Arrays.asList(this.mDebugTags).toString());
        stringBuffer.append(", mSatelliteVersion='").append(this.mSatelliteVersion).append('\'');
        stringBuffer.append(", mMapViewType=").append(this.mMapViewType);
        stringBuffer.append(", mMapKernel=").append(this.mMapKernel);
        stringBuffer.append(", mUserTypeface=").append(this.mUserTypeface);
        stringBuffer.append(", mProtocolFrom=").append(this.mProtocolFrom);
        stringBuffer.append(", mProtocolDataDesc=").append(this.mProtocolDataDesc);
        stringBuffer.append(", mNetAdapterType=").append(this.mNetAdapterType);
        stringBuffer.append(", mNetParams=").append(this.mNetParams);
        stringBuffer.append(", mCustomUserId='").append(this.mCustomUserId).append('\'');
        stringBuffer.append(", mMapCallback=").append(this.mMapCallback);
        stringBuffer.append(", mOfflineMapEnable=").append(this.mOfflineMapEnable);
        stringBuffer.append(", mOverSeaSource=").append(this.mOverSeaSource);
        stringBuffer.append(", mTrafficStyle=").append(this.mTrafficStyle);
        stringBuffer.append(", mMapFrameRate=").append(this.mMapFrameRate);
        stringBuffer.append('}');
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193603);
        return stringBuffer2;
    }
}
