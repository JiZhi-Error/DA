package com.d.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.d.a.a.a.a.l;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.UrlTileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i implements TencentMap, TencentMap.InfoWindowAdapter, TencentMap.OnCameraChangeListener, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedCallback, TencentMap.OnMapLongClickListener, TencentMap.OnMarkerClickListener, TencentMap.OnMarkerDragListener {
    private HashMap<Integer, e> SJQ = new HashMap<>();
    List<Marker> SJR = new ArrayList();
    private boolean SJS = false;
    private TencentMapGestureListener SJT;
    private TencentMap.InfoWindowAdapter SJU;
    List<TencentMap.InfoWindowAdapter> SJV;
    private TencentMap.OnMarkerDraggedListener SJW;
    List<TencentMap.OnMarkerDraggedListener> SJX;
    private TencentMap.OnMapLoadedListener SJY;
    List<TencentMap.OnMapLoadedListener> SJZ;
    private TencentMap.OnInfoWindowClickListener SKa;
    List<TencentMap.OnInfoWindowClickListener> SKb;
    private TencentMap.OnMarkerClickListener SKc;
    List<TencentMap.OnMarkerClickListener> SKd;
    private TencentMap.OnMapCameraChangeListener SKe;
    List<TencentMap.OnMapCameraChangeListener> SKf;
    private TencentMap.OnMapClickListener SKg;
    List<TencentMap.OnMapClickListener> SKh;
    private TencentMap.OnMapLongClickListener SKi;
    List<TencentMap.OnMapLongClickListener> SKj;
    private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;

    public i(com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap) {
        AppMethodBeat.i(217416);
        this.mTencentMap = tencentMap;
        this.mTencentMap.setInfoWindowAdapter(this);
        this.mTencentMap.setOnMarkerDragListener(this);
        this.mTencentMap.setOnMapLoadedCallback(this);
        this.mTencentMap.setOnInfoWindowClickListener(this);
        this.mTencentMap.setOnMarkerClickListener(this);
        this.mTencentMap.setOnCameraChangeListener(this);
        this.mTencentMap.setOnMapClickListener(this);
        this.mTencentMap.setOnMapLongClickListener(this);
        AppMethodBeat.o(217416);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.MapController
    public final void setCenter(LatLng latLng) {
        AppMethodBeat.i(217417);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217417);
            return;
        }
        if (latLng != null) {
            this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude())));
        }
        AppMethodBeat.o(217417);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.MapController
    public final void setZoom(int i2) {
        AppMethodBeat.i(217418);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217418);
            return;
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo((float) i2));
        AppMethodBeat.o(217418);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final Circle addCircle(CircleOptions circleOptions) {
        com.tencent.tencentmap.mapsdk.maps.model.CircleOptions circleOptions2 = null;
        AppMethodBeat.i(217419);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217419);
            return null;
        } else if (circleOptions == null) {
            AppMethodBeat.o(217419);
            return null;
        } else {
            com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
            if (circleOptions != null) {
                circleOptions2 = new com.tencent.tencentmap.mapsdk.maps.model.CircleOptions();
                com.tencent.tencentmap.mapsdk.maps.model.LatLng c2 = l.c(circleOptions.getCenter());
                if (c2 != null) {
                    circleOptions2.center(c2);
                }
                circleOptions2.center(l.c(circleOptions.getCenter())).fillColor(circleOptions.getFillColor()).radius(circleOptions.getRadius()).strokeColor(circleOptions.getStrokeColor()).strokeWidth(circleOptions.getStrokeWidth()).visible(circleOptions.isVisible()).zIndex((int) circleOptions.getZIndex()).level(circleOptions.getLevel());
            }
            b bVar = new b(tencentMap.addCircle(circleOptions2));
            AppMethodBeat.o(217419);
            return bVar;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final com.tencent.mapsdk.raster.model.Marker addMarker(MarkerOptions markerOptions) {
        com.tencent.tencentmap.mapsdk.maps.model.LatLng c2;
        com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions markerOptions2 = null;
        AppMethodBeat.i(217420);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217420);
            return null;
        } else if (markerOptions == null) {
            AppMethodBeat.o(217420);
            return null;
        } else {
            com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
            if (!(markerOptions == null || (c2 = l.c(markerOptions.getPosition())) == null)) {
                com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions markerOptions3 = new com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions(c2);
                markerOptions3.alpha(markerOptions.getAlpha()).visible(markerOptions.isVisible()).draggable(markerOptions.isDraggable()).anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV()).rotation(markerOptions.getRotation()).indoorInfo(l.a(markerOptions.getIndoorInfo())).zIndex((float) markerOptions.getZIndex()).level(markerOptions.getLevel()).flat(markerOptions.isFlat()).clockwise(markerOptions.isFlat() != markerOptions.isClockwise()).infoWindowOffset(markerOptions.getInfoWindowOffsetX(), markerOptions.getInfowindowOffsetY()).contentDescription(markerOptions.getContentDescription());
                if (markerOptions.getIcon() != null) {
                    markerOptions3.icon(BitmapDescriptorFactory.fromBitmap(markerOptions.getIcon().getBitmap()));
                }
                if (markerOptions.getMarkerView() != null) {
                    markerOptions3.icon(BitmapDescriptorFactory.fromView(markerOptions.getMarkerView()));
                }
                if (markerOptions.getSnippet() != null) {
                    markerOptions3.snippet(markerOptions.getSnippet());
                }
                if (markerOptions.getTitle() != null) {
                    markerOptions3.title(markerOptions.getTitle());
                }
                if (markerOptions.getTag() != null) {
                    markerOptions3.tag(markerOptions.getTag());
                }
                markerOptions2 = markerOptions3;
            }
            e eVar = new e(this, tencentMap.addMarker(markerOptions2));
            this.SJQ.put(Integer.valueOf(eVar.getId().hashCode()), eVar);
            AppMethodBeat.o(217420);
            return eVar;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        AppMethodBeat.i(217421);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217421);
            return null;
        } else if (polylineOptions == null) {
            AppMethodBeat.o(217421);
            return null;
        } else {
            f fVar = new f(this.mTencentMap.addPolyline(l.a(polylineOptions)));
            AppMethodBeat.o(217421);
            return fVar;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions polygonOptions2 = null;
        AppMethodBeat.i(217422);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217422);
            return null;
        } else if (polygonOptions == null) {
            AppMethodBeat.o(217422);
            return null;
        } else {
            com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
            if (polygonOptions != null) {
                com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions polygonOptions3 = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
                List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> kl = l.kl(polygonOptions.getPoints());
                if (kl != null && kl.size() > 2) {
                    polygonOptions3.addAll(kl);
                    polygonOptions3.visible(polygonOptions.isVisible()).zIndex((int) polygonOptions.getZIndex()).level(polygonOptions.getLevel()).strokeWidth(polygonOptions.getStrokeWidth()).strokeColor(polygonOptions.getStrokeColor()).fillColor(polygonOptions.getFillColor());
                    polygonOptions2 = polygonOptions3;
                }
            }
            g gVar = new g(tencentMap.addPolygon(polygonOptions2));
            AppMethodBeat.o(217422);
            return gVar;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.MapController
    public final void animateTo(LatLng latLng) {
        AppMethodBeat.i(217423);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217423);
            return;
        }
        if (latLng != null) {
            this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(latLng)));
        }
        AppMethodBeat.o(217423);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.MapController
    @Deprecated
    public final void animateTo(LatLng latLng, final Runnable runnable) {
        AppMethodBeat.i(217424);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217424);
            return;
        }
        if (latLng != null) {
            this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(latLng)), new TencentMap.CancelableCallback() {
                /* class com.d.a.a.a.a.i.AnonymousClass1 */

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public final void onFinish() {
                    AppMethodBeat.i(217394);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(217394);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public final void onCancel() {
                    AppMethodBeat.i(217395);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(217395);
                }
            });
        }
        AppMethodBeat.o(217424);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.MapController
    public final void animateTo(LatLng latLng, long j2, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(217425);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217425);
            return;
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(latLng)), j2, new TencentMap.CancelableCallback() {
            /* class com.d.a.a.a.a.i.AnonymousClass2 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
            public final void onFinish() {
                AppMethodBeat.i(217396);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.o(217396);
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
            public final void onCancel() {
                AppMethodBeat.i(217397);
                cancelableCallback.onCancel();
                AppMethodBeat.o(217397);
            }
        });
        AppMethodBeat.o(217425);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void clearAllOverlays() {
        AppMethodBeat.i(217426);
        if (this.mTencentMap != null) {
            this.mTencentMap.clear();
        }
        AppMethodBeat.o(217426);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final boolean clearCache() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final LatLng getMapCenter() {
        AppMethodBeat.i(217427);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217427);
            return null;
        }
        this.mTencentMap.getCameraPosition();
        LatLng a2 = l.a(this.mTencentMap.getCameraPosition().target);
        AppMethodBeat.o(217427);
        return a2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final int getZoomLevel() {
        AppMethodBeat.i(217428);
        if (this.mTencentMap == null || this.mTencentMap.getCameraPosition() == null) {
            AppMethodBeat.o(217428);
            return -1;
        }
        int i2 = (int) this.mTencentMap.getCameraPosition().zoom;
        AppMethodBeat.o(217428);
        return i2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final int getMaxZoomLevel() {
        AppMethodBeat.i(217429);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217429);
            return 19;
        }
        int maxZoomLevel = (int) this.mTencentMap.getMaxZoomLevel();
        AppMethodBeat.o(217429);
        return maxZoomLevel;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final int getMinZoomLevel() {
        AppMethodBeat.i(217430);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217430);
            return 4;
        }
        int minZoomLevel = (int) this.mTencentMap.getMinZoomLevel();
        AppMethodBeat.o(217430);
        return minZoomLevel;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final String getVersion() {
        AppMethodBeat.i(217431);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217431);
            return null;
        }
        String version = this.mTencentMap.getVersion();
        AppMethodBeat.o(217431);
        return version;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final boolean isAppKeyAvailable() {
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final boolean isSatelliteEnabled() {
        return this.SJS;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setSatelliteEnabled(boolean z) {
        AppMethodBeat.i(217432);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217432);
            return;
        }
        this.SJS = z;
        this.mTencentMap.setSatelliteEnabled(z);
        AppMethodBeat.o(217432);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void moveCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(217433);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217433);
            return;
        }
        if (cameraUpdate != null) {
            this.mTencentMap.moveCamera(l.a(cameraUpdate, this.mTencentMap));
        }
        AppMethodBeat.o(217433);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void animateCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(217434);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217434);
            return;
        }
        if (cameraUpdate != null) {
            this.mTencentMap.animateCamera(l.a(cameraUpdate, this.mTencentMap));
        }
        AppMethodBeat.o(217434);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void animateCamera(CameraUpdate cameraUpdate, long j2, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(217435);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217435);
            return;
        }
        if (cameraUpdate != null) {
            this.mTencentMap.animateCamera(l.a(cameraUpdate, this.mTencentMap), j2, new TencentMap.CancelableCallback() {
                /* class com.d.a.a.a.a.i.AnonymousClass3 */

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public final void onFinish() {
                    AppMethodBeat.i(217398);
                    if (cancelableCallback != null) {
                        cancelableCallback.onFinish();
                    }
                    AppMethodBeat.o(217398);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public final void onCancel() {
                    AppMethodBeat.i(217399);
                    if (cancelableCallback != null) {
                        cancelableCallback.onCancel();
                    }
                    AppMethodBeat.o(217399);
                }
            });
        }
        AppMethodBeat.o(217435);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void scrollBy(float f2, float f3) {
        AppMethodBeat.i(217436);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217436);
            return;
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(f2, f3));
        AppMethodBeat.o(217436);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void scrollBy(float f2, float f3, long j2, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(217437);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217437);
            return;
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(f2, f3), new TencentMap.CancelableCallback() {
            /* class com.d.a.a.a.a.i.AnonymousClass4 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
            public final void onFinish() {
                AppMethodBeat.i(217400);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.o(217400);
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
            public final void onCancel() {
                AppMethodBeat.i(217401);
                if (cancelableCallback != null) {
                    cancelableCallback.onCancel();
                }
                AppMethodBeat.o(217401);
            }
        });
        AppMethodBeat.o(217437);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void zoomIn() {
        AppMethodBeat.i(217438);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217438);
            return;
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
        AppMethodBeat.o(217438);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void zoomInFixing(int i2, int i3) {
        AppMethodBeat.i(217439);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217439);
            return;
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0f, new Point(i2, i3)));
        AppMethodBeat.o(217439);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void zoomOut() {
        AppMethodBeat.i(217440);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217440);
            return;
        }
        this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
        AppMethodBeat.o(217440);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void zoomOutFixing(int i2, int i3) {
        AppMethodBeat.i(217441);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217441);
            return;
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0f, new Point(i2, i3)));
        AppMethodBeat.o(217441);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap, com.tencent.tencentmap.mapsdk.map.MapController
    public final void zoomToSpan(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(217442);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217442);
            return;
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(latLng), l.c(latLng2)), 0));
        AppMethodBeat.o(217442);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap, com.tencent.tencentmap.mapsdk.map.MapController
    public final void zoomToSpan(double d2, double d3) {
        AppMethodBeat.i(217443);
        zoomToSpan(new LatLng(getMapCenter().getLatitude() - (d2 / 2.0d), getMapCenter().getLongitude() + (d3 / 2.0d)), new LatLng(getMapCenter().getLatitude() + (d2 / 2.0d), getMapCenter().getLongitude() - (d3 / 2.0d)));
        AppMethodBeat.o(217443);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(217444);
        if (infoWindowAdapter == null && this.SJU != null) {
            removeInfoWindowAdapter(this.SJU);
        }
        this.SJU = infoWindowAdapter;
        addInfoWindowAdapter(this.SJU);
        AppMethodBeat.o(217444);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(217445);
        if (infoWindowAdapter == null) {
            AppMethodBeat.o(217445);
            return;
        }
        if (this.SJV == null) {
            this.SJV = new LinkedList();
        }
        this.SJV.add(infoWindowAdapter);
        AppMethodBeat.o(217445);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(217446);
        if (infoWindowAdapter == null || this.SJV == null) {
            AppMethodBeat.o(217446);
            return;
        }
        this.SJV.remove(infoWindowAdapter);
        AppMethodBeat.o(217446);
    }

    private e a(Marker marker) {
        AppMethodBeat.i(217447);
        if (marker == null) {
            AppMethodBeat.o(217447);
            return null;
        }
        e eVar = this.SJQ.get(Integer.valueOf(marker.getId().hashCode()));
        AppMethodBeat.o(217447);
        return eVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener onMarkerDraggedListener) {
        AppMethodBeat.i(217448);
        if (onMarkerDraggedListener == null && this.SJW != null) {
            removeOnMarkerDraggedListener(this.SJW);
        }
        this.SJW = onMarkerDraggedListener;
        addOnMarkerDraggedListener(this.SJW);
        AppMethodBeat.o(217448);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener onMarkerDraggedListener) {
        AppMethodBeat.i(217449);
        if (onMarkerDraggedListener == null) {
            AppMethodBeat.o(217449);
            return;
        }
        if (this.SJX == null) {
            this.SJX = new LinkedList();
        }
        this.SJX.add(onMarkerDraggedListener);
        AppMethodBeat.o(217449);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener onMarkerDraggedListener) {
        AppMethodBeat.i(217450);
        if (onMarkerDraggedListener == null || this.SJX == null) {
            AppMethodBeat.o(217450);
            return;
        }
        this.SJX.remove(onMarkerDraggedListener);
        AppMethodBeat.o(217450);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener onMapLoadedListener) {
        AppMethodBeat.i(217451);
        if (onMapLoadedListener == null && this.SJY != null) {
            removeOnMapLoadedListener(this.SJY);
        }
        this.SJY = onMapLoadedListener;
        addOnMapLoadedListener(this.SJY);
        AppMethodBeat.o(217451);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener onMapLoadedListener) {
        AppMethodBeat.i(217452);
        if (onMapLoadedListener == null) {
            AppMethodBeat.o(217452);
            return;
        }
        if (this.SJZ == null) {
            this.SJZ = new LinkedList();
        }
        this.SJZ.add(onMapLoadedListener);
        AppMethodBeat.o(217452);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener onMapLoadedListener) {
        AppMethodBeat.i(217453);
        if (onMapLoadedListener == null || this.SJZ == null) {
            AppMethodBeat.o(217453);
            return;
        }
        this.SJZ.remove(onMapLoadedListener);
        AppMethodBeat.o(217453);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.i(217454);
        if (onInfoWindowClickListener == null && this.SKa != null) {
            remmoveOnInfoWindowClickListener(this.SKa);
        }
        this.SKa = onInfoWindowClickListener;
        addOnInfoWindowClickListener(this.SKa);
        AppMethodBeat.o(217454);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.i(217455);
        if (onInfoWindowClickListener == null) {
            AppMethodBeat.o(217455);
            return;
        }
        if (this.SKb == null) {
            this.SKb = new LinkedList();
        }
        this.SKb.add(onInfoWindowClickListener);
        AppMethodBeat.o(217455);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void remmoveOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.i(217456);
        if (onInfoWindowClickListener == null || this.SKb == null) {
            AppMethodBeat.o(217456);
            return;
        }
        this.SKb.remove(onInfoWindowClickListener);
        AppMethodBeat.o(217456);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(217457);
        if (onMarkerClickListener == null && this.SKc != null) {
            removeOnMarkerClickListener(this.SKc);
        }
        this.SKc = onMarkerClickListener;
        addOnMarkerClickListener(this.SKc);
        AppMethodBeat.o(217457);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(217458);
        if (onMarkerClickListener == null) {
            AppMethodBeat.o(217458);
            return;
        }
        if (this.SKd == null) {
            this.SKd = new LinkedList();
        }
        this.SKd.add(onMarkerClickListener);
        AppMethodBeat.o(217458);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(217459);
        if (onMarkerClickListener == null || this.SKd == null) {
            AppMethodBeat.o(217459);
            return;
        }
        this.SKd.remove(onMarkerClickListener);
        AppMethodBeat.o(217459);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener onMapCameraChangeListener) {
        AppMethodBeat.i(217460);
        if (onMapCameraChangeListener == null && this.SKe != null) {
            removeOnMapCameraChangeListener(this.SKe);
        }
        this.SKe = onMapCameraChangeListener;
        addOnMapCameraChangeListener(this.SKe);
        AppMethodBeat.o(217460);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener onMapCameraChangeListener) {
        AppMethodBeat.i(217461);
        if (onMapCameraChangeListener == null) {
            AppMethodBeat.o(217461);
            return;
        }
        if (this.SKf == null) {
            this.SKf = new LinkedList();
        }
        this.SKf.add(onMapCameraChangeListener);
        AppMethodBeat.o(217461);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener onMapCameraChangeListener) {
        AppMethodBeat.i(217462);
        if (onMapCameraChangeListener == null || this.SKf == null) {
            AppMethodBeat.o(217462);
            return;
        }
        this.SKf.remove(onMapCameraChangeListener);
        AppMethodBeat.o(217462);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        AppMethodBeat.i(217463);
        if (onMapClickListener == null && this.SKg != null) {
            removeOnMapClickListener(this.SKg);
        }
        this.SKg = onMapClickListener;
        addOnMapClickListener(this.SKg);
        AppMethodBeat.o(217463);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        AppMethodBeat.i(217464);
        if (onMapClickListener == null) {
            AppMethodBeat.o(217464);
            return;
        }
        if (this.SKh == null) {
            this.SKh = new LinkedList();
        }
        this.SKh.add(onMapClickListener);
        AppMethodBeat.o(217464);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        AppMethodBeat.i(217465);
        if (onMapClickListener == null || this.SKh == null) {
            AppMethodBeat.o(217465);
            return;
        }
        this.SKh.remove(onMapClickListener);
        AppMethodBeat.o(217465);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        AppMethodBeat.i(217466);
        if (onMapLongClickListener == null && this.SKi != null) {
            removeOnMapLongClickListener(this.SKi);
        }
        this.SKi = onMapLongClickListener;
        addOnMapLongClickListener(this.SKi);
        AppMethodBeat.o(217466);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void addOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        AppMethodBeat.i(217467);
        if (onMapLongClickListener == null) {
            AppMethodBeat.o(217467);
            return;
        }
        if (this.SKj == null) {
            this.SKj = new LinkedList();
        }
        this.SKj.add(onMapLongClickListener);
        AppMethodBeat.o(217467);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        AppMethodBeat.i(217468);
        if (onMapLongClickListener == null || this.SKj == null) {
            AppMethodBeat.o(217468);
            return;
        }
        this.SKj.remove(onMapLongClickListener);
        AppMethodBeat.o(217468);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnMapPoiClickListener(final TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        AppMethodBeat.i(217469);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217469);
            return;
        }
        this.mTencentMap.setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener() {
            /* class com.d.a.a.a.a.i.AnonymousClass5 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener
            public final void onClicked(MapPoi mapPoi) {
                com.tencent.mapsdk.raster.model.MapPoi mapPoi2;
                AppMethodBeat.i(217402);
                if (onMapPoiClickListener != null) {
                    TencentMap.OnMapPoiClickListener onMapPoiClickListener = onMapPoiClickListener;
                    if (mapPoi == null) {
                        mapPoi2 = null;
                    } else if (mapPoi instanceof IndoorMapPoi) {
                        IndoorMapPoi indoorMapPoi = (IndoorMapPoi) mapPoi;
                        mapPoi2 = new com.tencent.mapsdk.raster.model.IndoorMapPoi(indoorMapPoi.getName(), l.a(indoorMapPoi.getPosition()), indoorMapPoi.getBuildingId(), indoorMapPoi.getBuildingName(), indoorMapPoi.getFloorName());
                    } else {
                        mapPoi2 = new com.tencent.mapsdk.raster.model.MapPoi(mapPoi.getName(), l.a(mapPoi.getPosition()));
                    }
                    onMapPoiClickListener.onClicked(mapPoi2);
                }
                AppMethodBeat.o(217402);
            }
        });
        AppMethodBeat.o(217469);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setMapStyle(int i2) {
        AppMethodBeat.i(217470);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217470);
            return;
        }
        this.mTencentMap.setMapStyle(i2);
        AppMethodBeat.o(217470);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setOnIndoorStateChangeListener(final TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        AppMethodBeat.i(217471);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217471);
            return;
        }
        this.mTencentMap.setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener() {
            /* class com.d.a.a.a.a.i.AnonymousClass6 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorBuildingFocused() {
                AppMethodBeat.i(217403);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(217403);
                    return false;
                }
                boolean onIndoorBuildingFocused = onIndoorStateChangeListener.onIndoorBuildingFocused();
                AppMethodBeat.o(217403);
                return onIndoorBuildingFocused;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                ArrayList arrayList;
                com.tencent.mapsdk.raster.model.IndoorBuilding indoorBuilding2;
                AppMethodBeat.i(217404);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(217404);
                    return false;
                }
                TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener = onIndoorStateChangeListener;
                if (indoorBuilding == null) {
                    indoorBuilding2 = null;
                } else {
                    List<IndoorLevel> levels = indoorBuilding.getLevels();
                    if (levels == null) {
                        arrayList = null;
                    } else {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(levels);
                        arrayList = new ArrayList();
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            IndoorLevel indoorLevel = (IndoorLevel) it.next();
                            if (indoorLevel == null) {
                                arrayList = null;
                                break;
                            }
                            arrayList.add(new com.tencent.mapsdk.raster.model.IndoorLevel(indoorLevel.getName()));
                        }
                    }
                    if (arrayList == null) {
                        indoorBuilding2 = null;
                    } else {
                        indoorBuilding2 = new com.tencent.mapsdk.raster.model.IndoorBuilding(indoorBuilding.getBuidlingId(), indoorBuilding.getBuildingName(), arrayList, indoorBuilding.getActiveLevelIndex());
                    }
                }
                boolean onIndoorLevelActivated = onIndoorStateChangeListener.onIndoorLevelActivated(indoorBuilding2);
                AppMethodBeat.o(217404);
                return onIndoorLevelActivated;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorBuildingDeactivated() {
                AppMethodBeat.i(217405);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(217405);
                    return false;
                }
                boolean onIndoorBuildingDeactivated = onIndoorStateChangeListener.onIndoorBuildingDeactivated();
                AppMethodBeat.o(217405);
                return onIndoorBuildingDeactivated;
            }
        });
        AppMethodBeat.o(217471);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setIndoorEnabled(boolean z) {
        AppMethodBeat.i(217472);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217472);
            return;
        }
        this.mTencentMap.setIndoorEnabled(z);
        AppMethodBeat.o(217472);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setIndoorFloor(int i2) {
        AppMethodBeat.i(217473);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217473);
            return;
        }
        this.mTencentMap.setIndoorFloor(i2);
        AppMethodBeat.o(217473);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setIndoorFloor(String str, String str2) {
        AppMethodBeat.i(217474);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217474);
            return;
        }
        this.mTencentMap.setIndoorFloor(str, str2);
        AppMethodBeat.o(217474);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setIndoorMaskColor(int i2) {
        AppMethodBeat.i(217475);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217475);
            return;
        }
        this.mTencentMap.setIndoorMaskColor(i2);
        AppMethodBeat.o(217475);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final String getActivedIndoorBuilding(LatLng latLng) {
        AppMethodBeat.i(217476);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217476);
            return null;
        }
        String activedIndoorBuilding = this.mTencentMap.getActivedIndoorBuilding(l.c(latLng));
        AppMethodBeat.o(217476);
        return activedIndoorBuilding;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final String[] getActivedIndoorFloorNames() {
        AppMethodBeat.i(217477);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217477);
            return null;
        }
        String[] activedIndoorFloorNames = this.mTencentMap.getActivedIndoorFloorNames();
        AppMethodBeat.o(217477);
        return activedIndoorFloorNames;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final int getIndoorFloorId() {
        AppMethodBeat.i(217478);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217478);
            return 0;
        }
        int indoorFloorId = this.mTencentMap.getIndoorFloorId();
        AppMethodBeat.o(217478);
        return indoorFloorId;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void enableMultipleInfowindow(boolean z) {
        AppMethodBeat.i(217479);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217479);
            return;
        }
        this.mTencentMap.enableMultipleInfowindow(z);
        AppMethodBeat.o(217479);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(217480);
        if (this.mTencentMap == null || tencentMapGestureListener == null) {
            AppMethodBeat.o(217480);
            return;
        }
        if (this.SJT != null) {
            this.mTencentMap.removeTencentMapGestureListener(this.SJT);
        }
        this.SJT = new TencentMapGestureListener() {
            /* class com.d.a.a.a.a.i.AnonymousClass7 */

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onDoubleTap(float f2, float f3) {
                AppMethodBeat.i(217406);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217406);
                    return false;
                }
                boolean onDoubleTap = tencentMapGestureListener.onDoubleTap(f2, f3);
                AppMethodBeat.o(217406);
                return onDoubleTap;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onSingleTap(float f2, float f3) {
                AppMethodBeat.i(217407);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217407);
                    return false;
                }
                boolean onSingleTap = tencentMapGestureListener.onSingleTap(f2, f3);
                AppMethodBeat.o(217407);
                return onSingleTap;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onFling(float f2, float f3) {
                AppMethodBeat.i(217408);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217408);
                    return false;
                }
                boolean onFling = tencentMapGestureListener.onFling(f2, f3);
                AppMethodBeat.o(217408);
                return onFling;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onScroll(float f2, float f3) {
                AppMethodBeat.i(217409);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217409);
                    return false;
                }
                boolean onScroll = tencentMapGestureListener.onScroll(f2, f3);
                AppMethodBeat.o(217409);
                return onScroll;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onLongPress(float f2, float f3) {
                AppMethodBeat.i(217410);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217410);
                    return false;
                }
                boolean onLongPress = tencentMapGestureListener.onLongPress(f2, f3);
                AppMethodBeat.o(217410);
                return onLongPress;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onDown(float f2, float f3) {
                AppMethodBeat.i(217411);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217411);
                    return false;
                }
                boolean onDown = tencentMapGestureListener.onDown(f2, f3);
                AppMethodBeat.o(217411);
                return onDown;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final boolean onUp(float f2, float f3) {
                AppMethodBeat.i(217412);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217412);
                    return false;
                }
                boolean onUp = tencentMapGestureListener.onUp(f2, f3);
                AppMethodBeat.o(217412);
                return onUp;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
            public final void onMapStable() {
                AppMethodBeat.i(217413);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(217413);
                    return;
                }
                tencentMapGestureListener.onMapStable();
                AppMethodBeat.o(217413);
            }
        };
        this.mTencentMap.setTencentMapGestureListener(this.SJT);
        AppMethodBeat.o(217480);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(217481);
        this.mTencentMap.removeTencentMapGestureListener(this.SJT);
        AppMethodBeat.o(217481);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setForeignLanguage(Language language) {
        com.tencent.tencentmap.mapsdk.maps.model.Language language2;
        AppMethodBeat.i(217482);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217482);
            return;
        }
        com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
        if (language != null) {
            switch (l.AnonymousClass3.SKu[language.ordinal()]) {
                case 1:
                    language2 = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
                    break;
                case 2:
                    language2 = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
                    break;
            }
            tencentMap.setForeignLanguage(language2);
            AppMethodBeat.o(217482);
        }
        language2 = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
        tencentMap.setForeignLanguage(language2);
        AppMethodBeat.o(217482);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final CameraPosition getCameraPosition() {
        AppMethodBeat.i(217483);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217483);
            return null;
        }
        CameraPosition a2 = l.a(this.mTencentMap.getCameraPosition());
        AppMethodBeat.o(217483);
        return a2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final String getDebugError() {
        AppMethodBeat.i(217484);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217484);
            return null;
        }
        String debugError = this.mTencentMap.getDebugError();
        AppMethodBeat.o(217484);
        return debugError;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions tileOverlayOptions2 = null;
        TileProvider r0 = null;
        AppMethodBeat.i(217485);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217485);
            return null;
        } else if (tileOverlayOptions == null) {
            AppMethodBeat.o(217485);
            return null;
        } else {
            com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
            if (tileOverlayOptions != null) {
                com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions tileOverlayOptions3 = new com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions();
                com.tencent.mapsdk.raster.model.TileProvider tileProvider = tileOverlayOptions.getTileProvider();
                if (tileProvider != null) {
                    if (tileProvider instanceof UrlTileProvider) {
                        r0 = new com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider(((UrlTileProvider) tileProvider).mWidth, ((UrlTileProvider) tileProvider).mHeight, tileProvider) {
                            /* class com.d.a.a.a.a.l.AnonymousClass1 */
                            final /* synthetic */ com.tencent.mapsdk.raster.model.TileProvider SKt;

                            {
                                this.SKt = r3;
                            }

                            @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
                            public final URL getTileUrl(int i2, int i3, int i4) {
                                AppMethodBeat.i(217537);
                                URL tileUrl = ((UrlTileProvider) this.SKt).getTileUrl(i2, i3, i4);
                                AppMethodBeat.o(217537);
                                return tileUrl;
                            }
                        };
                    } else {
                        r0 = new TileProvider(tileProvider) {
                            /* class com.d.a.a.a.a.l.AnonymousClass2 */
                            final /* synthetic */ com.tencent.mapsdk.raster.model.TileProvider SKt;

                            {
                                this.SKt = r1;
                            }

                            @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
                            public final Tile getTile(int i2, int i3, int i4) {
                                AppMethodBeat.i(217538);
                                com.tencent.mapsdk.raster.model.Tile tile = this.SKt.getTile(i2, i3, i4);
                                if (tile == null) {
                                    AppMethodBeat.o(217538);
                                    return null;
                                }
                                Tile tile2 = new Tile(tile.mWidth, tile.mHeight, tile.mData);
                                AppMethodBeat.o(217538);
                                return tile2;
                            }
                        };
                    }
                }
                tileOverlayOptions2 = tileOverlayOptions3.tileProvider(r0).diskCacheDir(tileOverlayOptions.getDiskCacheDir()).versionInfo(tileOverlayOptions.getVersionInfo()).zIndex(tileOverlayOptions.getZIndex()).betterQuality(tileOverlayOptions.isBetterQuality());
            }
            k kVar = new k(tencentMap.addTileOverlay(tileOverlayOptions2));
            AppMethodBeat.o(217485);
            return kVar;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setPoisEnabled(boolean z) {
        AppMethodBeat.i(217486);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217486);
            return;
        }
        this.mTencentMap.setPoisEnabled(z);
        AppMethodBeat.o(217486);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setMapType(int i2) {
        AppMethodBeat.i(217487);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217487);
            return;
        }
        this.mTencentMap.setMapType(i2);
        AppMethodBeat.o(217487);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final int getMapType() {
        AppMethodBeat.i(217488);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217488);
            return 1000;
        }
        int mapType = this.mTencentMap.getMapType();
        AppMethodBeat.o(217488);
        return mapType;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final Projection getProjection() {
        AppMethodBeat.i(217489);
        h hVar = new h(this.mTencentMap);
        AppMethodBeat.o(217489);
        return hVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions customLayerOptions2 = null;
        AppMethodBeat.i(217490);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217490);
            return null;
        }
        com.tencent.tencentmap.mapsdk.maps.TencentMap tencentMap = this.mTencentMap;
        if (customLayerOptions != null) {
            customLayerOptions2 = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(customLayerOptions.getLayerId());
        }
        c cVar = new c(tencentMap.addCustomLayer(customLayerOptions2));
        AppMethodBeat.o(217490);
        return cVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void stopAnimation() {
        AppMethodBeat.i(217491);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217491);
            return;
        }
        this.mTencentMap.stopAnimation();
        AppMethodBeat.o(217491);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void getScreenShot(final TencentMap.OnScreenShotListener onScreenShotListener) {
        AppMethodBeat.i(217492);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217492);
            return;
        }
        this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback() {
            /* class com.d.a.a.a.a.i.AnonymousClass8 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
            public final void onSnapshotReady(Bitmap bitmap) {
                AppMethodBeat.i(217414);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.o(217414);
            }
        });
        AppMethodBeat.o(217492);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    @Deprecated
    public final void getScreenShot(final TencentMap.OnScreenShotListener onScreenShotListener, Rect rect) {
        AppMethodBeat.i(217493);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217493);
            return;
        }
        this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback() {
            /* class com.d.a.a.a.a.i.AnonymousClass9 */

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
            public final void onSnapshotReady(Bitmap bitmap) {
                AppMethodBeat.i(217415);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.o(217415);
            }
        });
        AppMethodBeat.o(217493);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setTrafficEnabled(boolean z) {
        AppMethodBeat.i(217494);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217494);
            return;
        }
        this.mTencentMap.setTrafficEnabled(z);
        AppMethodBeat.o(217494);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final boolean isTrafficEnabled() {
        AppMethodBeat.i(217495);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217495);
            return false;
        }
        boolean isTrafficEnabled = this.mTencentMap.isTrafficEnabled();
        AppMethodBeat.o(217495);
        return isTrafficEnabled;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    @Deprecated
    public final void setErrorListener(TencentMap.OnErrorListener onErrorListener) {
        if (this.mTencentMap == null) {
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void set3DEnable(boolean z) {
        AppMethodBeat.i(217496);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217496);
            return;
        }
        this.mTencentMap.setBuildingEnable(z);
        AppMethodBeat.o(217496);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setMapAnchor(float f2, float f3) {
        AppMethodBeat.i(217497);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217497);
            return;
        }
        this.mTencentMap.setCameraCenterProportion(f2, f3, false);
        this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
        AppMethodBeat.o(217497);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setHandDrawMapEnable(boolean z) {
        AppMethodBeat.i(217498);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217498);
            return;
        }
        this.mTencentMap.setHandDrawMapEnable(z);
        AppMethodBeat.o(217498);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final boolean isHandDrawMapEnable() {
        AppMethodBeat.i(217499);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217499);
            return false;
        }
        boolean isHandDrawMapEnable = this.mTencentMap.isHandDrawMapEnable();
        AppMethodBeat.o(217499);
        return isHandDrawMapEnable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker r6) {
        /*
            r5 = this;
            r4 = 217500(0x3519c, float:3.04782E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.d.a.a.a.a.e r1 = r5.a(r6)
            r0 = 0
            java.util.List<com.tencent.tencentmap.mapsdk.map.TencentMap$InfoWindowAdapter> r2 = r5.SJV
            if (r2 == 0) goto L_0x0027
            java.util.List<com.tencent.tencentmap.mapsdk.map.TencentMap$InfoWindowAdapter> r2 = r5.SJV
            java.util.Iterator r2 = r2.iterator()
        L_0x0015:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r0 = r2.next()
            com.tencent.tencentmap.mapsdk.map.TencentMap$InfoWindowAdapter r0 = (com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter) r0
            android.view.View r0 = r0.getInfoWindow(r1)
            if (r0 == 0) goto L_0x0015
        L_0x0027:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.a.a.a.i.getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker):android.view.View");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    public final View getInfoContents(Marker marker) {
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition cameraPosition) {
        AppMethodBeat.i(217501);
        CameraPosition a2 = l.a(cameraPosition);
        if (this.SKf != null) {
            for (TencentMap.OnMapCameraChangeListener onMapCameraChangeListener : this.SKf) {
                onMapCameraChangeListener.onCameraChange(a2);
            }
        }
        AppMethodBeat.o(217501);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition cameraPosition) {
        AppMethodBeat.i(217502);
        CameraPosition a2 = l.a(cameraPosition);
        if (this.SKf != null) {
            for (TencentMap.OnMapCameraChangeListener onMapCameraChangeListener : this.SKf) {
                onMapCameraChangeListener.onCameraChangeFinish(a2);
            }
        }
        AppMethodBeat.o(217502);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public final void onInfoWindowClick(Marker marker) {
        AppMethodBeat.i(217503);
        e a2 = a(marker);
        if (this.SKb != null) {
            for (TencentMap.OnInfoWindowClickListener onInfoWindowClickListener : this.SKb) {
                onInfoWindowClickListener.onInfoWindowClick(a2);
            }
        }
        AppMethodBeat.o(217503);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public final void onInfoWindowClickLocation(int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
    public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng) {
        AppMethodBeat.i(217504);
        LatLng a2 = l.a(latLng);
        if (this.SKh != null) {
            for (TencentMap.OnMapClickListener onMapClickListener : this.SKh) {
                onMapClickListener.onMapClick(a2);
            }
        }
        AppMethodBeat.o(217504);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
    public final void onMapLoaded() {
        AppMethodBeat.i(217505);
        if (this.SJZ != null) {
            for (TencentMap.OnMapLoadedListener onMapLoadedListener : this.SJZ) {
                onMapLoadedListener.onMapLoaded();
            }
        }
        AppMethodBeat.o(217505);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener
    public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng) {
        AppMethodBeat.i(217506);
        LatLng a2 = l.a(latLng);
        if (this.SKj != null) {
            for (TencentMap.OnMapLongClickListener onMapLongClickListener : this.SKj) {
                onMapLongClickListener.onMapLongClick(a2);
            }
        }
        AppMethodBeat.o(217506);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker r6) {
        /*
            r5 = this;
            r4 = 217507(0x351a3, float:3.04792E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.d.a.a.a.a.e r1 = r5.a(r6)
            r0 = 0
            java.util.List<com.tencent.tencentmap.mapsdk.map.TencentMap$OnMarkerClickListener> r2 = r5.SKd
            if (r2 == 0) goto L_0x0027
            java.util.List<com.tencent.tencentmap.mapsdk.map.TencentMap$OnMarkerClickListener> r2 = r5.SKd
            java.util.Iterator r2 = r2.iterator()
        L_0x0015:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r0 = r2.next()
            com.tencent.tencentmap.mapsdk.map.TencentMap$OnMarkerClickListener r0 = (com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener) r0
            boolean r0 = r0.onMarkerClick(r1)
            if (r0 == 0) goto L_0x0015
        L_0x0027:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.a.a.a.i.onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker):boolean");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener
    public final void onMarkerDragStart(Marker marker) {
        AppMethodBeat.i(217508);
        e a2 = a(marker);
        if (this.SJX != null) {
            for (TencentMap.OnMarkerDraggedListener onMarkerDraggedListener : this.SJX) {
                onMarkerDraggedListener.onMarkerDragStart(a2);
            }
        }
        AppMethodBeat.o(217508);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener
    public final void onMarkerDrag(Marker marker) {
        AppMethodBeat.i(217509);
        e a2 = a(marker);
        if (this.SJX != null) {
            for (TencentMap.OnMarkerDraggedListener onMarkerDraggedListener : this.SJX) {
                onMarkerDraggedListener.onMarkerDrag(a2);
            }
        }
        AppMethodBeat.o(217509);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener
    public final void onMarkerDragEnd(Marker marker) {
        AppMethodBeat.i(217510);
        e a2 = a(marker);
        if (this.SJX != null) {
            for (TencentMap.OnMarkerDraggedListener onMarkerDraggedListener : this.SJX) {
                onMarkerDraggedListener.onMarkerDragEnd(a2);
            }
        }
        AppMethodBeat.o(217510);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setMaxZoomLevel(int i2) {
        AppMethodBeat.i(217511);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217511);
            return;
        }
        this.mTencentMap.setMaxZoomLevel(i2);
        AppMethodBeat.o(217511);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setMinZoomLevel(int i2) {
        AppMethodBeat.i(217512);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217512);
            return;
        }
        this.mTencentMap.setMinZoomLevel(i2);
        AppMethodBeat.o(217512);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        AppMethodBeat.i(217513);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217513);
            return null;
        } else if (groundOverlayOptions == null) {
            AppMethodBeat.o(217513);
            return null;
        } else {
            GroundOverlay addGroundOverlay = this.mTencentMap.addGroundOverlay(groundOverlayOptions);
            AppMethodBeat.o(217513);
            return addGroundOverlay;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void showBuilding(boolean z) {
        AppMethodBeat.i(217514);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217514);
            return;
        }
        this.mTencentMap.showBuilding(z);
        AppMethodBeat.o(217514);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap
    public final void setBuilding3dEffectEnable(boolean z) {
        AppMethodBeat.i(217515);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(217515);
            return;
        }
        this.mTencentMap.setBuilding3dEffectEnable(z);
        AppMethodBeat.o(217515);
    }
}
