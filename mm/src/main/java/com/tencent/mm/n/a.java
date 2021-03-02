package com.tencent.mm.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/config/AlbumConfigControl;", "", "()V", "KEY_C2C", "", "KEY_SNS", "TAG", "getC2CSelectMaxDuration", "", "getSNSSelectMaxDuration", "plugin-videologic_release"})
public final class a {
    public static final a gLV = new a();

    static {
        AppMethodBeat.i(240897);
        AppMethodBeat.o(240897);
    }

    private a() {
    }

    public static int apH() {
        AppMethodBeat.i(240895);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("LimitationOnSight");
        Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration getDynamicConfig:".concat(String.valueOf(value)));
        if (!TextUtils.isEmpty(value)) {
            try {
                JSONObject optJSONObject = new JSONObject(value).optJSONObject("kSightLimitationMaxDurationKey");
                int optInt = optJSONObject != null ? optJSONObject.optInt("c2c") : 300;
                Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration result:%d", Integer.valueOf(optInt));
                if (optInt <= 15) {
                    AppMethodBeat.o(240895);
                    return 300;
                }
                AppMethodBeat.o(240895);
                return optInt;
            } catch (Exception e2) {
                Log.e("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration parse Json error!");
            }
        }
        Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration default result:%d", 300);
        AppMethodBeat.o(240895);
        return 300;
    }

    public static int apI() {
        AppMethodBeat.i(240896);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("LimitationOnSight");
        Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration getDynamicConfig:".concat(String.valueOf(value)));
        if (!TextUtils.isEmpty(value)) {
            try {
                JSONObject optJSONObject = new JSONObject(value).optJSONObject("kSightLimitationMaxDurationKey");
                int optInt = optJSONObject != null ? optJSONObject.optInt("sns") : 300;
                Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration result:%d", Integer.valueOf(optInt));
                if (optInt <= 15) {
                    AppMethodBeat.o(240896);
                    return 300;
                }
                AppMethodBeat.o(240896);
                return optInt;
            } catch (Exception e2) {
                Log.e("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration parse Json error!");
            }
        }
        Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration default result:%d", 300);
        AppMethodBeat.o(240896);
        return 300;
    }
}
