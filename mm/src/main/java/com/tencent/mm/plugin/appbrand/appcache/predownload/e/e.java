package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public class e extends c<f> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(f.iBg, "PredownloadIssueLaunchWxaAppResponse")};

    static {
        AppMethodBeat.i(44442);
        AppMethodBeat.o(44442);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.iBg, "PredownloadIssueLaunchWxaAppResponse", f.INDEX_CREATE);
    }

    public final boolean a(byte[] bArr, String str, List<Integer> list, long j2, long j3) {
        boolean insert;
        AppMethodBeat.i(44440);
        if (Util.isNullOrNil(bArr) || Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", str);
            AppMethodBeat.o(44440);
            return false;
        } else if (Util.isNullOrNil(list)) {
            Log.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", str);
            AppMethodBeat.o(44440);
            return false;
        } else {
            boolean z = true;
            for (Integer num : list) {
                int intValue = num.intValue();
                f fVar = new f();
                fVar.field_appId = str;
                fVar.field_scene = intValue;
                boolean z2 = get(fVar, new String[0]);
                fVar.field_launchProtoBlob = bArr;
                fVar.field_startTime = j2;
                fVar.field_endTime = j3;
                if (z2) {
                    insert = update(fVar, new String[0]);
                } else {
                    insert = insert(fVar);
                }
                z = insert & z;
            }
            Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", str, Integer.valueOf(list.size()), Boolean.valueOf(z));
            AppMethodBeat.o(44440);
            return z;
        }
    }

    public final Pair<che, Long> bd(String str, int i2) {
        AppMethodBeat.i(44441);
        try {
            long nowSecond = Util.nowSecond();
            f fVar = new f();
            fVar.field_appId = str;
            fVar.field_scene = i2;
            if (get(fVar, new String[0])) {
                Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", str, Integer.valueOf(i2), Long.valueOf(fVar.field_startTime), Long.valueOf(fVar.field_endTime));
                if (fVar.field_startTime <= nowSecond && nowSecond <= fVar.field_endTime) {
                    che che = new che();
                    che.parseFrom(fVar.field_launchProtoBlob);
                    if (che.MmA.LjS.zy.length > 0) {
                        Pair<che, Long> create = Pair.create(che, Long.valueOf(fVar.field_reportId));
                        AppMethodBeat.o(44441);
                        return create;
                    }
                    Log.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", str, Integer.valueOf(i2));
                }
            }
            Pair<che, Long> create2 = Pair.create(null, -1L);
            AppMethodBeat.o(44441);
            return create2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", e2, "get with appId(%s) scene(%d)", str, Integer.valueOf(i2));
            Pair<che, Long> create3 = Pair.create(null, -1L);
            AppMethodBeat.o(44441);
            return create3;
        }
    }
}
