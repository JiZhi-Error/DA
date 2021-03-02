package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private AbstractC1660a CxG;
    private int CxH;
    private int CxI;
    private int CxJ;
    private int CxK;

    /* renamed from: com.tencent.mm.plugin.report.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1660a {
    }

    static {
        AppMethodBeat.i(143784);
        AppMethodBeat.o(143784);
    }

    public a() {
        this.CxG = null;
        this.CxH = 0;
        this.CxI = 1;
        this.CxJ = 2;
        this.CxK = 3;
        this.CxG = null;
    }

    public final void a(cbi cbi, int i2) {
        String str;
        AppMethodBeat.i(143781);
        Log.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:".concat(String.valueOf(i2)));
        if (cbi == null) {
            Log.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
            AppMethodBeat.o(143781);
        } else if (this.CxH != cbi.Mhc) {
            StringBuilder sb = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            int i3 = cbi.Mhc;
            if (this.CxI == i3) {
                str = "服务器过载";
            } else if (this.CxJ == i3) {
                str = "服务器没有配置表";
            } else if (this.CxK == i3) {
                str = "服务器配置表错误";
            } else {
                str = "非法的错误类型";
            }
            Log.e("MicroMsg.HeavyUserIDMappingStg", sb.append(str).append(",version:").append(cbi.Mha).toString());
            AppMethodBeat.o(143781);
        } else {
            int Wi = Wi(i2);
            int i4 = cbi.Mha;
            if (Wi == i4) {
                Log.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:".concat(String.valueOf(i4)));
                AppMethodBeat.o(143781);
                return;
            }
            Log.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + Wi(i2) + ", svr:" + i4);
            Log.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + cbi.Mha + ", ret:" + cbi.Mhc + ", size: " + cbi.Mhb.size());
            try {
                byte[] byteArray = cbi.toByteArray();
                synchronized (lock) {
                    try {
                        Log.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + cbi.Mha);
                        s.e(ar.NSe + filename, byteArray, byteArray.length);
                    } finally {
                        AppMethodBeat.o(143781);
                    }
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e2, "", new Object[0]);
                AppMethodBeat.o(143781);
            }
        }
    }

    public static cbi eOy() {
        byte[] aW;
        AppMethodBeat.i(143782);
        Log.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            try {
                aW = s.aW(ar.NSe + filename, 0, -1);
            } catch (Throwable th) {
                AppMethodBeat.o(143782);
                throw th;
            }
        }
        if (aW == null) {
            Log.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            AppMethodBeat.o(143782);
            return null;
        }
        cbi cbi = new cbi();
        try {
            cbi.parseFrom(aW);
            Log.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + cbi.Mha + ", ret:" + cbi.Mhc + ", size: " + cbi.Mhb.size());
            AppMethodBeat.o(143782);
            return cbi;
        } catch (Throwable th2) {
            Log.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", th2, "", new Object[0]);
            AppMethodBeat.o(143782);
            return null;
        }
    }

    public static int Wi(int i2) {
        AppMethodBeat.i(143783);
        Log.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:".concat(String.valueOf(i2)));
        cbi eOy = eOy();
        if (eOy == null) {
            AppMethodBeat.o(143783);
            return 0;
        }
        int i3 = eOy.Mha;
        Log.i("MicroMsg.HeavyUserIDMappingStg", "version:".concat(String.valueOf(i3)));
        AppMethodBeat.o(143783);
        return i3;
    }
}
