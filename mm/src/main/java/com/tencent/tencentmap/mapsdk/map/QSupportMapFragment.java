package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.rastercore.LogHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QSupportMapFragment extends Fragment {
    private MapView mapView;

    public static QSupportMapFragment newInstance() {
        AppMethodBeat.i(87487);
        QSupportMapFragment qSupportMapFragment = new QSupportMapFragment();
        AppMethodBeat.o(87487);
        return qSupportMapFragment;
    }

    public MapView getMapView() {
        return this.mapView;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        AppMethodBeat.i(87488);
        super.onAttach(activity);
        AppMethodBeat.o(87488);
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.i(87489);
        super.onInflate(activity, attributeSet, bundle);
        AppMethodBeat.o(87489);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(87490);
        super.onCreate(bundle);
        AppMethodBeat.o(87490);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(87491);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (this.mapView == null) {
            this.mapView = new MapView(layoutInflater.getContext());
            this.mapView.onCreate(bundle);
        }
        LogHelper.v("js", "QSupportMapFragment onCreateView ");
        MapView mapView2 = this.mapView;
        AppMethodBeat.o(87491);
        return mapView2;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(87492);
        super.onResume();
        this.mapView.onResume();
        AppMethodBeat.o(87492);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(87493);
        super.onPause();
        this.mapView.onPause();
        AppMethodBeat.o(87493);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        AppMethodBeat.i(87494);
        this.mapView.onDestroyView();
        super.onDestroyView();
        AppMethodBeat.o(87494);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(87495);
        this.mapView.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(87495);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(87496);
        this.mapView.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(87496);
    }

    @Override // android.support.v4.app.Fragment
    public void setArguments(Bundle bundle) {
        AppMethodBeat.i(87497);
        super.setArguments(bundle);
        AppMethodBeat.o(87497);
    }
}
