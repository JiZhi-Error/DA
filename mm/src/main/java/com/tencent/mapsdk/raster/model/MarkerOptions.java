package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public final class MarkerOptions {
    private float alpha = 1.0f;
    private int anchorOffsetX;
    private int anchorOffsetY;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private BitmapDescriptor bitmapDescriptor;
    private String contentDescription;
    private Animation hidingAnination;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    protected String id;
    private Animation infoWindowHideAnimation;
    private Animation infoWindowShowAnimation;
    private boolean isClockwise = true;
    private boolean isDraggable = false;
    private boolean isFlat = false;
    private boolean isGps = false;
    private boolean isVisible = true;
    private LatLng latLng;
    private IndoorInfo mIndoorInfo;
    private View markerView;
    private float rotation = 0.0f;
    private Animation showingAnination;
    private String snippet;
    private Object tag;
    private String title;
    private int zIndex;

    public final MarkerOptions position(LatLng latLng2) {
        this.latLng = latLng2;
        return this;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        return this;
    }

    public final MarkerOptions anchor(float f2, float f3) {
        this.anchorU = f2;
        this.anchorV = f3;
        return this;
    }

    public final MarkerOptions alpha(float f2) {
        this.alpha = f2;
        return this;
    }

    public final MarkerOptions rotation(float f2) {
        this.rotation = f2;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.isDraggable = z;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final MarkerOptions tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public final LatLng getPosition() {
        return this.latLng;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final View getMarkerView() {
        return this.markerView;
    }

    public final MarkerOptions markerView(View view) {
        this.markerView = view;
        return this;
    }

    public final Animation getInfoWindowShowAnimation() {
        return this.infoWindowShowAnimation;
    }

    public final MarkerOptions infoWindowShowAnimation(Animation animation) {
        this.infoWindowShowAnimation = animation;
        return this;
    }

    public final Animation getShowingAnination() {
        return this.showingAnination;
    }

    public final MarkerOptions setShowingAnination(Animation animation) {
        this.showingAnination = animation;
        return this;
    }

    public final Animation getHidingAnination() {
        return this.hidingAnination;
    }

    public final MarkerOptions setHidingAnination(Animation animation) {
        this.hidingAnination = animation;
        return this;
    }

    public final Animation getInfoWindowHideAnimation() {
        return this.infoWindowHideAnimation;
    }

    public final MarkerOptions infoWindowHideAnimation(Animation animation) {
        this.infoWindowHideAnimation = animation;
        return this;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final MarkerOptions zIndex(int i2) {
        this.zIndex = i2;
        return this;
    }

    public final MarkerOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public final int getZIndex() {
        return this.zIndex;
    }

    public final int getLevel() {
        return this.iLevel;
    }

    public final IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public final MarkerOptions indoorInfo(IndoorInfo indoorInfo) {
        this.mIndoorInfo = indoorInfo;
        return this;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final MarkerOptions flat(boolean z) {
        this.isFlat = z;
        return this;
    }

    public final boolean isClockwise() {
        return this.isClockwise;
    }

    public final MarkerOptions clockwise(boolean z) {
        this.isClockwise = z;
        return this;
    }

    public final MarkerOptions infoWindowOffset(int i2, int i3) {
        this.anchorOffsetX = i2;
        this.anchorOffsetY = i3;
        return this;
    }

    public final int getInfoWindowOffsetX() {
        return this.anchorOffsetX;
    }

    public final int getInfowindowOffsetY() {
        return this.anchorOffsetY;
    }

    public final MarkerOptions contentDescription(String str) {
        this.contentDescription = str;
        return this;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }
}
