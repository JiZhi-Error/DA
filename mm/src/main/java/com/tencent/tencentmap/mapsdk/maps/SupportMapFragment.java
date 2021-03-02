package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportMapFragment extends Fragment {
    private boolean isOnTop = false;
    private TencentMap mTencentMap;
    protected MapView mapV = null;

    public static SupportMapFragment newInstance(Context context) {
        AppMethodBeat.i(181028);
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        supportMapFragment.initMap(context);
        AppMethodBeat.o(181028);
        return supportMapFragment;
    }

    /* access modifiers changed from: protected */
    public void initMap(Context context) {
        AppMethodBeat.i(181029);
        this.mapV = onCreateMapView(context, null);
        AppMethodBeat.o(181029);
    }

    public TencentMap getMap() {
        AppMethodBeat.i(181030);
        if (this.mTencentMap == null) {
            this.mTencentMap = this.mapV.getMap();
        }
        TencentMap tencentMap = this.mTencentMap;
        AppMethodBeat.o(181030);
        return tencentMap;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(181031);
        if (this.mapV == null) {
            this.mapV = onCreateMapView(getActivity().getBaseContext(), null);
        }
        this.mapV.setOnTop(this.isOnTop);
        MapView mapView = this.mapV;
        AppMethodBeat.o(181031);
        return mapView;
    }

    /* access modifiers changed from: protected */
    public MapView onCreateMapView(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(181032);
        MapView mapView = new MapView(context, tencentMapOptions);
        AppMethodBeat.o(181032);
        return mapView;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(181033);
        this.mapV.onResume();
        super.onResume();
        AppMethodBeat.o(181033);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(181034);
        this.mapV.onPause();
        super.onPause();
        AppMethodBeat.o(181034);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        AppMethodBeat.i(181035);
        this.mapV.onDestroy();
        super.onDestroyView();
        AppMethodBeat.o(181035);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(181036);
        this.mapV.onDestroy();
        super.onDestroy();
        this.mapV = null;
        AppMethodBeat.o(181036);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        AppMethodBeat.i(181037);
        this.mapV.onStart();
        super.onStart();
        AppMethodBeat.o(181037);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        AppMethodBeat.i(181038);
        this.mapV.onStop();
        super.onStop();
        AppMethodBeat.o(181038);
    }

    @Override // android.support.v4.app.Fragment
    public void onLowMemory() {
        AppMethodBeat.i(181039);
        super.onLowMemory();
        AppMethodBeat.o(181039);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(181040);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(181040);
    }

    @Override // android.support.v4.app.Fragment
    public void setArguments(Bundle bundle) {
        AppMethodBeat.i(181041);
        super.setArguments(bundle);
        AppMethodBeat.o(181041);
    }

    public void setOnTop(boolean z) {
        this.isOnTop = z;
    }
}
