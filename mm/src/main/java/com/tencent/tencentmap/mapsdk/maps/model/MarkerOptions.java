package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MarkerOptions {
    private boolean bFlat = false;
    private BitmapDescriptor bitmapDesctor;
    private boolean boDragable;
    private boolean boInfoWindowEnable = true;
    private boolean boVisible = true;
    private String contentDescription;
    private float fAlpha = 1.0f;
    private float fAngle = 0.0f;
    private float fanchorU = 0.5f;
    private float fanchorV = 0.5f;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    private boolean mClockwise = true;
    private IndoorInfo mIndoorInfo;
    private float mInfowindowAnchorU = 0.5f;
    private float mInfowindowAnchorV = 1.0f;
    private int mInfowindowOffsetX = 0;
    private int mInfowindowOffsetY = 0;
    private boolean mIsFastLoad = true;
    private boolean mIsViewInfowindow = false;
    private Object mTag;
    private LatLng mlatlng;
    private String strSnippet;
    private String strtitle = "";
    private float zIndex = 0.0f;

    public MarkerOptions(LatLng latLng) {
        this.mlatlng = latLng;
    }

    @Deprecated
    public MarkerOptions() {
    }

    public MarkerOptions position(LatLng latLng) {
        this.mlatlng = latLng;
        return this;
    }

    public MarkerOptions infoWindowEnable(boolean z) {
        this.boInfoWindowEnable = z;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDesctor = bitmapDescriptor;
        return this;
    }

    public MarkerOptions anchor(float f2, float f3) {
        this.fanchorU = f2;
        this.fanchorV = f3;
        return this;
    }

    public MarkerOptions title(String str) {
        this.strtitle = str;
        return this;
    }

    public MarkerOptions rotation(float f2) {
        this.fAngle = f2;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.strSnippet = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.boDragable = z;
        return this;
    }

    public MarkerOptions alpha(float f2) {
        this.fAlpha = f2;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.bFlat = z;
        return this;
    }

    public MarkerOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    public MarkerOptions indoorInfo(IndoorInfo indoorInfo) {
        this.mIndoorInfo = indoorInfo;
        return this;
    }

    public MarkerOptions tag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return false;
    }

    public LatLng getPosition() {
        return this.mlatlng;
    }

    public String getTitle() {
        return this.strtitle;
    }

    public String getSnippet() {
        return this.strSnippet;
    }

    public BitmapDescriptor getIcon() {
        AppMethodBeat.i(173263);
        BitmapDescriptor bitmapDescriptor = this.bitmapDesctor;
        AppMethodBeat.o(173263);
        return bitmapDescriptor;
    }

    public float getAnchorU() {
        return this.fanchorU;
    }

    public float getAnchorV() {
        return this.fanchorV;
    }

    public boolean isDraggable() {
        return this.boDragable;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public boolean isInfoWindowEnable() {
        return this.boInfoWindowEnable;
    }

    public float getAlpha() {
        return this.fAlpha;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public boolean isFlat() {
        return this.bFlat;
    }

    public float getRotation() {
        return this.fAngle;
    }

    public MarkerOptions clockwise(boolean z) {
        this.mClockwise = z;
        return this;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public MarkerOptions infoWindowAnchor(float f2, float f3) {
        this.mInfowindowAnchorU = f2;
        this.mInfowindowAnchorV = f3;
        return this;
    }

    public float getInfoWindowAnchorU() {
        return this.mInfowindowAnchorU;
    }

    public float getInfoWindowAnchorV() {
        return this.mInfowindowAnchorV;
    }

    public MarkerOptions infoWindowOffset(int i2, int i3) {
        this.mInfowindowOffsetX = i2;
        this.mInfowindowOffsetY = i3;
        return this;
    }

    public int getInfoWindowOffsetX() {
        return this.mInfowindowOffsetX;
    }

    public int getInfowindowOffsetY() {
        return this.mInfowindowOffsetY;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(173264);
        if (parcel == null) {
            AppMethodBeat.o(173264);
            return;
        }
        if (this.mlatlng != null) {
            parcel.writeString(this.mlatlng.toString());
        }
        AppMethodBeat.o(173264);
    }

    public Object getTag() {
        return this.mTag;
    }

    public boolean isFastLoad() {
        return this.mIsFastLoad;
    }

    public MarkerOptions fastLoad(boolean z) {
        this.mIsFastLoad = z;
        return this;
    }

    public MarkerOptions contentDescription(String str) {
        this.contentDescription = str;
        return this;
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public MarkerOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public MarkerOptions viewInfoWindow(boolean z) {
        this.mIsViewInfowindow = z;
        return this;
    }

    public boolean isViewInfowindow() {
        return this.mIsViewInfowindow;
    }
}
