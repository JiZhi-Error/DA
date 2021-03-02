package com.tencent.tencentmap.mapsdk.map;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapOptions {
    public static final int GL_MAP_VIEW = 0;
    public static final int MAP_RENDER_LAYER = 2;
    public static final int TEXTURE_MAP_VIEW = 1;
    private boolean enableHandDrawMap = false;
    private boolean isMutipleInfowindowEnabled = false;
    private Object mExtSurface;
    private int mExtSurfaceHeight;
    private int mExtSurfaceWidth;
    private int mMapType = 0;
    private String mSubId;
    private String mSubKey;

    public void setMapType(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            this.mMapType = i2;
        }
    }

    public int getMapType() {
        return this.mMapType;
    }

    public Object getExtSurface() {
        return this.mExtSurface;
    }

    public void setExtSurface(Object obj) {
        AppMethodBeat.i(87485);
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
            this.mExtSurface = obj;
            AppMethodBeat.o(87485);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
        AppMethodBeat.o(87485);
        throw illegalArgumentException;
    }

    public final void setExtSurfaceDimension(int i2, int i3) {
        this.mExtSurfaceWidth = i2;
        this.mExtSurfaceHeight = i3;
    }

    public final int getExtSurfaceWidth() {
        return this.mExtSurfaceWidth;
    }

    public final int getExtSurfaceHeight() {
        return this.mExtSurfaceHeight;
    }

    @Deprecated
    public TencentMapOptions enableHandDrawMap(boolean z) {
        AppMethodBeat.i(87486);
        setHandDrawMapEnable(z);
        AppMethodBeat.o(87486);
        return this;
    }

    public void setHandDrawMapEnable(boolean z) {
        this.enableHandDrawMap = z;
    }

    public boolean isHandDrawMapEnable() {
        return this.enableHandDrawMap;
    }

    public final void setSubInfo(String str, String str2) {
        this.mSubId = str2;
        this.mSubKey = str;
    }

    public final String getSubId() {
        return this.mSubId;
    }

    public final String getSubKey() {
        return this.mSubKey;
    }

    public boolean isMutipleInfowindowEnabled() {
        return this.isMutipleInfowindowEnabled;
    }

    public void setMutipleInfowindowEnabled(boolean z) {
        this.isMutipleInfowindowEnabled = z;
    }
}
