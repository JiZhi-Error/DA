package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d extends t {
    private final a JUM;
    private final Intent JUN;
    private final y JUO = new y();

    public d(Bundle bundle) {
        AppMethodBeat.i(109457);
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.JUM = a.TencentMap;
        } else {
            a ahC = a.ahC(bundle.getInt("key_map_app", a.TencentMap.code));
            if (a(MMApplicationContext.getContext(), ahC, null) == null) {
                this.JUM = a.TencentMap;
            } else {
                this.JUM = ahC;
            }
        }
        if (this.JUM == a.TencentMap) {
            this.JUN = null;
            AppMethodBeat.o(109457);
            return;
        }
        this.JUN = (Intent) bundle.getParcelable("key_target_intent");
        AppMethodBeat.o(109457);
    }

    public enum a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int code;

        public static a valueOf(String str) {
            AppMethodBeat.i(109454);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(109454);
            return aVar;
        }

        static {
            AppMethodBeat.i(109456);
            AppMethodBeat.o(109456);
        }

        private a(int i2) {
            this.code = i2;
        }

        public final String getPackage() {
            AppMethodBeat.i(109455);
            switch (this) {
                case TencentMap:
                    AppMethodBeat.o(109455);
                    return "com.tencent.map";
                case GoogleMap:
                    AppMethodBeat.o(109455);
                    return "com.google.android.apps.maps";
                case SogouMap:
                    AppMethodBeat.o(109455);
                    return "com.sogou.map.android.maps";
                case BaiduMap:
                    AppMethodBeat.o(109455);
                    return "com.baidu.BaiduMap";
                case AutonaviMap:
                    AppMethodBeat.o(109455);
                    return "com.autonavi.minimap";
                default:
                    AppMethodBeat.o(109455);
                    return "com.tencent.map";
            }
        }

        public static a ahC(int i2) {
            switch (i2) {
                case 0:
                    return TencentMap;
                case 1:
                    return GoogleMap;
                case 2:
                    return SogouMap;
                case 3:
                    return BaiduMap;
                case 4:
                    return AutonaviMap;
                default:
                    return TencentMap;
            }
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        AppMethodBeat.i(109458);
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", Float.valueOf(0.0f), Float.valueOf(0.0f))));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (Util.isNullOrNil(queryIntentActivities)) {
            AppMethodBeat.o(109458);
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (!(resolveInfo == null || resolveInfo.activityInfo == null || !aVar.getPackage().equals(resolveInfo.activityInfo.packageName))) {
                AppMethodBeat.o(109458);
                return resolveInfo;
            }
        }
        AppMethodBeat.o(109458);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean in(Context context) {
        AppMethodBeat.i(109459);
        if (this.JUM == a.TencentMap) {
            boolean in = this.JUO.in(context);
            AppMethodBeat.o(109459);
            return in;
        } else if (a(context, this.JUM, this.JUN) != null) {
            AppMethodBeat.o(109459);
            return true;
        } else {
            AppMethodBeat.o(109459);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean bdn(String str) {
        AppMethodBeat.i(109460);
        boolean equals = this.JUM.getPackage().equals(str);
        AppMethodBeat.o(109460);
        return equals;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String blB() {
        if (this.JUM == a.TencentMap) {
            return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
        }
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String gmq() {
        if (this.JUM == a.TencentMap) {
            return "TencentMap.apk";
        }
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final u.a gmr() {
        AppMethodBeat.i(109461);
        if (this.JUM == a.TencentMap) {
            u.a gmr = this.JUO.gmr();
            AppMethodBeat.o(109461);
            return gmr;
        }
        u.a aVar = new u.a();
        aVar.JVD = -1;
        aVar.JVA = -1;
        ResolveInfo a2 = a(MMApplicationContext.getContext(), this.JUM, this.JUN);
        if (a2 != null) {
            aVar.JVE = c(MMApplicationContext.getContext(), a2);
        }
        AppMethodBeat.o(109461);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String c(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(109462);
        String c2 = this.JUO.c(context, resolveInfo);
        AppMethodBeat.o(109462);
        return c2;
    }
}
