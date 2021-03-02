package com.tencent.mm.plugin.location_soso;

import android.graphics.Color;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.e;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.HashMap;
import java.util.Map;

public class ViewManager implements e {
    private Map<Marker, TencentMap.OnInfoWindowClickListener> mInfoWindowClickMap = new HashMap();
    private Map<Marker, TencentMap.OnMarkerClickListener> mMarkerClickMap = new HashMap();
    private Map<View, Marker> mMarkerMap = new HashMap();
    private TencentMap mTencentMap;

    public ViewManager(TencentMap tencentMap) {
        AppMethodBeat.i(146603);
        this.mTencentMap = tencentMap;
        this.mTencentMap.setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() {
            /* class com.tencent.mm.plugin.location_soso.ViewManager.AnonymousClass1 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                AppMethodBeat.i(146601);
                TencentMap.OnMarkerClickListener onMarkerClickListener = (TencentMap.OnMarkerClickListener) ViewManager.this.mMarkerClickMap.get(marker);
                if (onMarkerClickListener != null) {
                    boolean onMarkerClick = onMarkerClickListener.onMarkerClick(marker);
                    AppMethodBeat.o(146601);
                    return onMarkerClick;
                }
                AppMethodBeat.o(146601);
                return false;
            }
        });
        this.mTencentMap.setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener() {
            /* class com.tencent.mm.plugin.location_soso.ViewManager.AnonymousClass2 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(146602);
                TencentMap.OnInfoWindowClickListener onInfoWindowClickListener = (TencentMap.OnInfoWindowClickListener) ViewManager.this.mInfoWindowClickMap.get(marker);
                if (onInfoWindowClickListener != null) {
                    onInfoWindowClickListener.onInfoWindowClick(marker);
                }
                AppMethodBeat.o(146602);
            }
        });
        AppMethodBeat.o(146603);
    }

    public void addView(View view, double d2, double d3) {
        AppMethodBeat.i(146604);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146604);
            return;
        }
        this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d2, d3)).markerView(view)));
        AppMethodBeat.o(146604);
    }

    public void addPinView(View view, double d2, double d3) {
        AppMethodBeat.i(146605);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146605);
            return;
        }
        this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d2, d3)).anchor(0.5f, 0.5f).markerView(view)));
        AppMethodBeat.o(146605);
    }

    public void removeView(View view) {
        AppMethodBeat.i(146606);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146606);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        if (marker != null) {
            marker.remove();
            this.mMarkerClickMap.remove(marker);
            this.mInfoWindowClickMap.remove(marker);
        }
        AppMethodBeat.o(146606);
    }

    public void updateViewLayout(View view, double d2, double d3, boolean z) {
        AppMethodBeat.i(146607);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146607);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        marker.setVisible(view.getVisibility() == 0);
        marker.setPosition(new LatLng(d2, d3));
        if (z) {
            marker.setMarkerView(view);
        }
        marker.setAnchor(0.5f, 1.0f);
        AppMethodBeat.o(146607);
    }

    public void updateLocationPinLayout(View view, double d2, double d3, boolean z) {
        AppMethodBeat.i(146608);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146608);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        if (marker == null) {
            AppMethodBeat.o(146608);
            return;
        }
        marker.setVisible(view.getVisibility() == 0);
        marker.setPosition(new LatLng(d2, d3));
        if (z) {
            marker.setMarkerView(view);
        }
        marker.setAnchor(0.5f, 0.5f);
        AppMethodBeat.o(146608);
    }

    public void updateRotation(View view, float f2) {
        AppMethodBeat.i(146609);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146609);
            return;
        }
        this.mMarkerMap.get(view).setRotation(f2);
        AppMethodBeat.o(146609);
    }

    public void toggleViewVisible(View view) {
        AppMethodBeat.i(146610);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146610);
            return;
        }
        this.mMarkerMap.get(view).setVisible(view.getVisibility() == 0);
        AppMethodBeat.o(146610);
    }

    public void updateMarkerView(View view) {
        AppMethodBeat.i(146611);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146611);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        if (marker != null) {
            marker.setMarkerView(view);
        }
        AppMethodBeat.o(146611);
    }

    public void setMarker2Top(View view) {
        AppMethodBeat.i(146612);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146612);
            return;
        }
        this.mMarkerMap.get(view).set2Top();
        AppMethodBeat.o(146612);
    }

    public void setMarkerClick(View view, TencentMap.OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(146613);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146613);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        if (marker != null) {
            this.mMarkerClickMap.put(marker, onMarkerClickListener);
        }
        AppMethodBeat.o(146613);
    }

    public void setInfoWindowClick(View view, TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.i(146614);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146614);
            return;
        }
        Marker marker = this.mMarkerMap.get(view);
        if (marker != null) {
            this.mInfoWindowClickMap.put(marker, onInfoWindowClickListener);
        }
        AppMethodBeat.o(146614);
    }

    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(146615);
        this.mTencentMap.setInfoWindowAdapter(infoWindowAdapter);
        AppMethodBeat.o(146615);
    }

    public void showInfoWindowByView(View view) {
        AppMethodBeat.i(146616);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146616);
            return;
        }
        this.mMarkerMap.get(view).showInfoWindow();
        AppMethodBeat.o(146616);
    }

    public void setMarkerTag(View view, String str) {
        AppMethodBeat.i(146617);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(146617);
            return;
        }
        this.mMarkerMap.get(view).setTag(str);
        AppMethodBeat.o(146617);
    }

    public Circle drawAccuracyCircle(double d2, double d3, double d4) {
        AppMethodBeat.i(146618);
        if (this.mTencentMap != null) {
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(new LatLng(d2, d3));
            circleOptions.radius(d4);
            circleOptions.strokeColor(Color.parseColor("#00FFFFFF"));
            circleOptions.strokeWidth(0.0f);
            circleOptions.fillColor(Color.parseColor("#4D1485EE"));
            Circle addCircle = this.mTencentMap.addCircle(circleOptions);
            AppMethodBeat.o(146618);
            return addCircle;
        }
        AppMethodBeat.o(146618);
        return null;
    }

    public void destroy() {
        AppMethodBeat.i(146619);
        if (this.mMarkerMap != null) {
            this.mMarkerMap.clear();
            this.mMarkerClickMap.clear();
            this.mInfoWindowClickMap.clear();
        }
        AppMethodBeat.o(146619);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(146620);
        if (this.mTencentMap != null) {
            this.mTencentMap.animateCamera(cameraUpdate);
        }
        AppMethodBeat.o(146620);
    }

    public void enableDarkMode() {
        AppMethodBeat.i(182825);
        if (this.mTencentMap != null) {
            this.mTencentMap.setMapType(1008);
        }
        AppMethodBeat.o(182825);
    }

    public void disableDarkMode() {
        AppMethodBeat.i(182826);
        if (this.mTencentMap != null) {
            this.mTencentMap.setMapType(1000);
        }
        AppMethodBeat.o(182826);
    }
}
