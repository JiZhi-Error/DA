package com.tencent.tencentmap.mapsdk.vector.compat.utils;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MarkerManager implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMarkerClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final TencentMap f2818a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Collection> f2819b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Marker, Collection> f2820c = new HashMap();

    public MarkerManager(TencentMap tencentMap) {
        AppMethodBeat.i(199496);
        this.f2818a = tencentMap;
        AppMethodBeat.o(199496);
    }

    public Collection a() {
        AppMethodBeat.i(199497);
        Collection collection = new Collection();
        AppMethodBeat.o(199497);
        return collection;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        AppMethodBeat.i(199498);
        Collection collection = this.f2820c.get(marker);
        if (collection == null || collection.f2825e == null) {
            AppMethodBeat.o(199498);
            return null;
        }
        View infoWindow = collection.f2825e.getInfoWindow(marker);
        AppMethodBeat.o(199498);
        return infoWindow;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
    public void onInfoWindowDettached(Marker marker, View view) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        AppMethodBeat.i(199499);
        Collection collection = this.f2820c.get(marker);
        if (!(collection == null || collection.f2823c == null)) {
            collection.f2823c.onInfoWindowClick(marker);
        }
        AppMethodBeat.o(199499);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        AppMethodBeat.i(199500);
        Collection collection = this.f2820c.get(marker);
        if (collection == null || collection.f2824d == null) {
            AppMethodBeat.o(199500);
            return false;
        }
        boolean onMarkerClick = collection.f2824d.onMarkerClick(marker);
        AppMethodBeat.o(199500);
        return onMarkerClick;
    }

    public boolean a(Marker marker) {
        AppMethodBeat.i(199501);
        Collection collection = this.f2820c.get(marker);
        if (collection == null || !collection.a(marker)) {
            AppMethodBeat.o(199501);
            return false;
        }
        AppMethodBeat.o(199501);
        return true;
    }

    public class Collection {

        /* renamed from: b  reason: collision with root package name */
        private final Set<Marker> f2822b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private TencentMap.OnInfoWindowClickListener f2823c;

        /* renamed from: d  reason: collision with root package name */
        private TencentMap.OnMarkerClickListener f2824d;

        /* renamed from: e  reason: collision with root package name */
        private TencentMap.InfoWindowAdapter f2825e;

        public Collection() {
            AppMethodBeat.i(199637);
            AppMethodBeat.o(199637);
        }

        public Marker a(MarkerOptions markerOptions) {
            AppMethodBeat.i(199638);
            Marker addMarker = MarkerManager.this.f2818a.addMarker(markerOptions);
            this.f2822b.add(addMarker);
            MarkerManager.this.f2820c.put(addMarker, this);
            AppMethodBeat.o(199638);
            return addMarker;
        }

        public boolean a(Marker marker) {
            AppMethodBeat.i(199639);
            if (this.f2822b.remove(marker)) {
                MarkerManager.this.f2820c.remove(marker);
                marker.remove();
                AppMethodBeat.o(199639);
                return true;
            }
            AppMethodBeat.o(199639);
            return false;
        }

        public void a() {
            AppMethodBeat.i(199640);
            for (Marker marker : this.f2822b) {
                marker.remove();
                MarkerManager.this.f2820c.remove(marker);
            }
            this.f2822b.clear();
            AppMethodBeat.o(199640);
        }

        public java.util.Collection<Marker> getMarkers() {
            AppMethodBeat.i(199641);
            java.util.Collection<Marker> unmodifiableCollection = Collections.unmodifiableCollection(this.f2822b);
            AppMethodBeat.o(199641);
            return unmodifiableCollection;
        }

        public void a(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
            this.f2823c = onInfoWindowClickListener;
        }

        public void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
            this.f2824d = onMarkerClickListener;
        }

        public void a(TencentMap.InfoWindowAdapter infoWindowAdapter) {
            this.f2825e = infoWindowAdapter;
        }
    }
}
