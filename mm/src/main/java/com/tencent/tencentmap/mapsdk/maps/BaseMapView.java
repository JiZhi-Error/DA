package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MapKernel;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public abstract class BaseMapView extends FrameLayout {

    public interface MapViewProxy {
        TencentMap getMap();

        boolean isTouchable();

        void onCreated();

        void onDestroy();

        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        void onPause();

        void onRestart();

        void onResume();

        void onSizeChanged(int i2, int i3, int i4, int i5);

        void onStart();

        void onStop();

        void onSurfaceChanged(Object obj, int i2, int i3);

        boolean onTouchEvent(MotionEvent motionEvent);

        void onUpdateOptions(TencentMapOptions tencentMapOptions);

        void setOnTop(boolean z);
    }

    public abstract TencentMap getMap();

    public abstract TencentMap getMap(TencentMapOptions tencentMapOptions);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onRestart();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public BaseMapView(Context context) {
        super(context);
    }

    public BaseMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public TencentMapOptions.IMapKernel getMapKernel() {
        return MapKernel.Vector;
    }

    /* access modifiers changed from: protected */
    public MapViewType getViewType() {
        return MapViewType.SurfaceView;
    }
}
