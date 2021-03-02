package com.tencent.mm.plugin.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, GameRegionPreference.a> xVH;
    public boolean xYX;
    private Map<String, Boolean> xYY;

    /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: com.tencent.mm.plugin.game.e.a$a */
    public static class C1396a {
        private static a xYZ = new a((byte) 0);

        static {
            AppMethodBeat.i(42482);
            AppMethodBeat.o(42482);
        }
    }

    private a() {
        AppMethodBeat.i(42483);
        this.xYX = false;
        this.xYY = new ConcurrentHashMap();
        AppMethodBeat.o(42483);
    }

    public final synchronized void clearCache() {
        AppMethodBeat.i(42484);
        if (this.xVH != null) {
            this.xVH.clear();
        }
        this.xYX = false;
        AppMethodBeat.o(42484);
    }

    public final synchronized void dWL() {
        AppMethodBeat.i(42485);
        if (this.xVH != null) {
            for (GameRegionPreference.a aVar : this.xVH.values()) {
                aVar.isSelected = false;
            }
        }
        AppMethodBeat.o(42485);
    }

    public final synchronized void dWM() {
        String str;
        AppMethodBeat.i(42486);
        if (this.xVH == null) {
            this.xVH = new LinkedHashMap();
        }
        if (this.xVH.size() <= 0) {
            InputStream inputStream = null;
            try {
                inputStream = MMApplicationContext.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Log.e("MicroMsg.GameCacheUtil", "exception:%s", Util.stackTraceToString(e2));
                    }
                }
            } catch (IOException e3) {
                Log.e("MicroMsg.GameCacheUtil", "exception:%s", Util.stackTraceToString(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = "";
                    } catch (IOException e4) {
                        Log.e("MicroMsg.GameCacheUtil", "exception:%s", Util.stackTraceToString(e4));
                        str = "";
                    }
                } else {
                    str = "";
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        Log.e("MicroMsg.GameCacheUtil", "exception:%s", Util.stackTraceToString(e5));
                    }
                }
                AppMethodBeat.o(42486);
                throw th;
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (int i2 = 0; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split("\\|");
                if (split2.length < 4) {
                    Log.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", split[i2]);
                } else {
                    GameRegionPreference.a aVar = new GameRegionPreference.a();
                    aVar.xVE = split2[0];
                    aVar.xVF = split2[1];
                    aVar.xVG = split2[2];
                    aVar.fuO = split2[3];
                    aVar.isSelected = false;
                    aVar.isDefault = false;
                    this.xVH.put(aVar.fuO, aVar);
                }
            }
            GameRegionPreference.a aVar2 = this.xVH.get(e.dUS());
            if (aVar2 != null) {
                aVar2.xVE = e.dUT();
                aVar2.xVF = e.dUU();
                aVar2.xVG = e.dUV();
                aVar2.isDefault = true;
            }
        }
        AppMethodBeat.o(42486);
    }

    public final synchronized Map<String, GameRegionPreference.a> dWN() {
        Map<String, GameRegionPreference.a> map;
        AppMethodBeat.i(42487);
        dWM();
        map = this.xVH;
        AppMethodBeat.o(42487);
        return map;
    }

    public final synchronized boolean aAF(String str) {
        boolean z;
        AppMethodBeat.i(42488);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42488);
            z = false;
        } else if (!this.xYY.containsKey(str) || !this.xYY.get(str).booleanValue()) {
            Log.i("MicroMsg.GameCacheUtil", "download entrance image start : %s", str);
            this.xYY.put(str, Boolean.TRUE);
            AppMethodBeat.o(42488);
            z = true;
        } else {
            AppMethodBeat.o(42488);
            z = false;
        }
        return z;
    }

    public final synchronized void aAG(String str) {
        AppMethodBeat.i(42489);
        if (!Util.isNullOrNil(str) && this.xYY.containsKey(str)) {
            Log.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", str);
            this.xYY.remove(str);
        }
        AppMethodBeat.o(42489);
    }
}
