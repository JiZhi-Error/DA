package com.tencent.tencentmap.mapsdk.maps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(12)
public class MapFragment extends Fragment {
    private boolean isOnTop = true;
    private TencentMap mTencentMap;
    protected MapView mapV = null;

    public static MapFragment newInstance(Context context) {
        AppMethodBeat.i(180986);
        MapFragment mapFragment = new MapFragment();
        mapFragment.initMap(context);
        AppMethodBeat.o(180986);
        return mapFragment;
    }

    /* access modifiers changed from: protected */
    public void initMap(Context context) {
        AppMethodBeat.i(180987);
        if (this.mapV == null) {
            this.mapV = onCreateMapView(context.getApplicationContext(), null);
        }
        AppMethodBeat.o(180987);
    }

    public TencentMap getMap() {
        AppMethodBeat.i(180988);
        if (this.mTencentMap == null) {
            this.mTencentMap = this.mapV.getMap();
        }
        TencentMap tencentMap = this.mTencentMap;
        AppMethodBeat.o(180988);
        return tencentMap;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        AppMethodBeat.i(180989);
        super.onAttach(activity);
        AppMethodBeat.o(180989);
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.i(180990);
        super.onInflate(activity, attributeSet, bundle);
        AppMethodBeat.o(180990);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(180991);
        super.onCreate(bundle);
        AppMethodBeat.o(180991);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(180992);
        if (this.mapV == null) {
            this.mapV = onCreateMapView(getActivity().getBaseContext(), null);
        }
        this.mapV.setOnTop(this.isOnTop);
        MapView mapView = this.mapV;
        AppMethodBeat.o(180992);
        return mapView;
    }

    /* access modifiers changed from: protected */
    public MapView onCreateMapView(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(180993);
        MapView mapView = new MapView(context, tencentMapOptions);
        AppMethodBeat.o(180993);
        return mapView;
    }

    public void onResume() {
        AppMethodBeat.i(180994);
        this.mapV.onResume();
        super.onResume();
        AppMethodBeat.o(180994);
    }

    public void onPause() {
        AppMethodBeat.i(180995);
        this.mapV.onPause();
        super.onPause();
        AppMethodBeat.o(180995);
    }

    public void onDestroyView() {
        AppMethodBeat.i(180996);
        this.mapV.onDestroy();
        super.onDestroyView();
        AppMethodBeat.o(180996);
    }

    public void onDestroy() {
        AppMethodBeat.i(180997);
        this.mapV.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(180997);
    }

    public void onStart() {
        AppMethodBeat.i(180998);
        this.mapV.onStart();
        super.onStart();
        AppMethodBeat.o(180998);
    }

    public void onStop() {
        AppMethodBeat.i(180999);
        this.mapV.onStop();
        super.onStop();
        AppMethodBeat.o(180999);
    }

    public void onLowMemory() {
        AppMethodBeat.i(181000);
        super.onLowMemory();
        AppMethodBeat.o(181000);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(181001);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(181001);
    }

    public void setArguments(Bundle bundle) {
        AppMethodBeat.i(181002);
        super.setArguments(bundle);
        AppMethodBeat.o(181002);
    }

    public void setOnTop(boolean z) {
        this.isOnTop = z;
    }
}
