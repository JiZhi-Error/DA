package com.tencent.mapsdk.rastercore;

import android.content.Context;
import com.d.a.a.a.a.a;
import com.d.a.a.a.a.d;
import com.d.a.a.a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class MapProvider {
    private TencentMapOptions mTencentMapOptions;

    public IMapView getMapView(Context context, TencentMapOptions tencentMapOptions) {
        IMapView jVar;
        AppMethodBeat.i(217189);
        int i2 = 0;
        this.mTencentMapOptions = tencentMapOptions;
        if (this.mTencentMapOptions != null) {
            i2 = this.mTencentMapOptions.getMapType();
        }
        switch (i2) {
            case 0:
                LogHelper.e("maptype", "glmapview");
                jVar = new d(context, this.mTencentMapOptions);
                break;
            case 1:
                jVar = new j(context, this.mTencentMapOptions);
                LogHelper.e("maptype", "maprenderlayer");
                break;
            case 2:
                jVar = new a(context, this.mTencentMapOptions);
                LogHelper.e("maptype", "texturemapview");
                break;
            default:
                jVar = new d(context, this.mTencentMapOptions);
                break;
        }
        AppMethodBeat.o(217189);
        return jVar;
    }

    public static String getMapSdkPath() {
        AppMethodBeat.i(217190);
        String str = b.aKK() + "mapsdk";
        if (!s.YS(str)) {
            s.boN(str);
        }
        Log.d("MapProvider", "path:%s", str);
        AppMethodBeat.o(217190);
        return str;
    }
}
