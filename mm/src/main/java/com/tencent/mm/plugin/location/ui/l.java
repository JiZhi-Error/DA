package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

public final class l implements c {
    public boolean dJM = false;
    public boolean isVisible = true;
    public String kHV;
    private Context mContext;
    public ViewManager mViewManager;
    private String yFq;
    public double yFu = 1000000.0d;
    public double yFv = 1000000.0d;
    public boolean yHP = true;
    private View yHQ;
    private TextView yHs;
    private ProgressBar yHt;
    private String yHw = "";
    public final String yKL = "info_window_tag";
    public ImageView yKM;
    public FrameLayout yKN;
    private TextView yKO;
    public boolean yKP;

    public l(d dVar, Context context) {
        AppMethodBeat.i(55993);
        this.mContext = context;
        this.yKP = false;
        this.yKM = new ImageView(context);
        this.yKM.setBackgroundResource(R.drawable.aij);
        this.yKM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.yKN = (FrameLayout) View.inflate(context, R.layout.b6g, null);
        this.yKM.setImageResource(R.drawable.cb0);
        this.yHQ = this.yKN;
        this.mViewManager = (ViewManager) dVar.getViewManager();
        AppMethodBeat.o(55993);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public final void setText(String str) {
        AppMethodBeat.i(55994);
        this.yFq = str;
        String str2 = this.yFq;
        this.yHs = (TextView) this.yKN.findViewById(R.id.eqx);
        this.yHt = (ProgressBar) this.yKN.findViewById(R.id.eqg);
        this.yKO = (TextView) this.yKN.findViewById(R.id.eqp);
        if (str2 == null || str2.equals("")) {
            this.yHt.setVisibility(0);
        } else {
            this.yHt.setVisibility(8);
            this.yHs.setVisibility(0);
            this.yHs.setText(str2);
        }
        if (this.kHV == null || this.kHV.equals("")) {
            this.yKO.setText("");
            this.yKO.setVisibility(8);
        } else {
            this.yKO.setVisibility(0);
            this.yKO.setText(this.kHV);
        }
        if (this.yHP) {
            this.mViewManager.updateViewLayout(this.yKM, this.yFu, this.yFv, false);
            if (this.yKP) {
                this.mViewManager.showInfoWindowByView(this.yKM);
            }
        }
        AppMethodBeat.o(55994);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public final String getPreText() {
        return this.yHw;
    }

    public class a implements TencentMap.InfoWindowAdapter {
        private a() {
        }

        public /* synthetic */ a(l lVar, byte b2) {
            this();
        }

        @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.i(55992);
            Log.i("ZItemOverlay", "get info window: %s", Integer.valueOf(l.this.yKN.getVisibility()));
            if ("info_window_tag".equals(marker.getTag())) {
                FrameLayout frameLayout = l.this.yKN;
                AppMethodBeat.o(55992);
                return frameLayout;
            }
            AppMethodBeat.o(55992);
            return null;
        }

        @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
        public final void onInfoWindowDettached(Marker marker, View view) {
        }
    }
}
