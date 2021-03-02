package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy extends a {
    private static CaptureMMProxy zta;
    private static String ztb = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        zta = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return zta;
    }

    public CaptureMMProxy(d dVar) {
        super(dVar);
    }

    public String getAccVideoPath() {
        AppMethodBeat.i(89320);
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        Log.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + ztb);
        if (!Util.isNullOrNil(str)) {
            ztb = str;
        }
        if (!Util.isNullOrNil(ztb)) {
            String str2 = ztb;
            AppMethodBeat.o(89320);
            return str2;
        }
        AppMethodBeat.o(89320);
        return str;
    }

    public String getSubCoreImageFullPath(String str) {
        AppMethodBeat.i(89321);
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", str);
        Log.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(str2)));
        AppMethodBeat.o(89321);
        return str2;
    }

    public Object get(ar.a aVar, Object obj) {
        AppMethodBeat.i(89322);
        Log.i("MicroMsg.CaptureMMProxy", "get %s %s", aVar, obj);
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, obj);
        Log.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", aVar, obj, REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(89322);
            return obj;
        }
        AppMethodBeat.o(89322);
        return REMOTE_CALL;
    }

    public int getInt(ar.a aVar, int i2) {
        AppMethodBeat.i(89323);
        Log.i("MicroMsg.CaptureMMProxy", "getInt %s %s", aVar, Integer.valueOf(i2));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Integer.valueOf(i2));
        Log.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", aVar, Integer.valueOf(i2), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(89323);
            return i2;
        }
        int i3 = Util.getInt(REMOTE_CALL.toString(), i2);
        AppMethodBeat.o(89323);
        return i3;
    }

    public boolean getBoolean(ar.a aVar, boolean z) {
        AppMethodBeat.i(89324);
        Log.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", aVar, Boolean.valueOf(z));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Boolean.valueOf(z));
        Log.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", aVar, Boolean.valueOf(z), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(89324);
            return z;
        }
        boolean z2 = Util.getBoolean(REMOTE_CALL.toString(), z);
        AppMethodBeat.o(89324);
        return z2;
    }

    public boolean set(ar.a aVar, Object obj) {
        AppMethodBeat.i(89325);
        Log.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", aVar, obj);
        boolean booleanValue = ((Boolean) REMOTE_CALL("setConfigStorage", aVar, obj)).booleanValue();
        AppMethodBeat.o(89325);
        return booleanValue;
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        AppMethodBeat.i(89326);
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        Log.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(parcelable)));
        VideoTransPara videoTransPara = (VideoTransPara) parcelable;
        AppMethodBeat.o(89326);
        return videoTransPara;
    }

    public VideoTransPara getGameVideoTransPara(int i2) {
        AppMethodBeat.i(89327);
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getGameVideoTransParaInMM", Integer.valueOf(i2));
        Log.d("MicroMsg.CaptureMMProxy", "getGameVideoTransPara() returned: ".concat(String.valueOf(parcelable)));
        VideoTransPara videoTransPara = (VideoTransPara) parcelable;
        AppMethodBeat.o(89327);
        return videoTransPara;
    }

    public String getDeviceInfoConfig() {
        AppMethodBeat.i(89328);
        String str = (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
        Log.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", str);
        AppMethodBeat.o(89328);
        return str;
    }

    public String getDynamicConfig(String str) {
        AppMethodBeat.i(89329);
        String str2 = (String) REMOTE_CALL("getDynamicConfigInMM", str);
        Log.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", str, str2);
        AppMethodBeat.o(89329);
        return str2;
    }

    public byte[] getWeixinMeta() {
        AppMethodBeat.i(89330);
        byte[] bArr = (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
        Log.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", bArr);
        AppMethodBeat.o(89330);
        return bArr;
    }

    public boolean checkUseMMVideoPlayer() {
        AppMethodBeat.i(89331);
        Object REMOTE_CALL = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
        if (REMOTE_CALL != null) {
            Log.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", REMOTE_CALL);
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.o(89331);
            return booleanValue;
        }
        AppMethodBeat.o(89331);
        return true;
    }

    public void clearArtistCache() {
        AppMethodBeat.i(89332);
        REMOTE_CALL("clearArtistCacheInMM", new Object[0]);
        AppMethodBeat.o(89332);
    }

    public boolean useMediaRecordNew() {
        AppMethodBeat.i(89333);
        Object REMOTE_CALL = REMOTE_CALL("useMediaRecordNewInMM", new Object[0]);
        if (REMOTE_CALL != null) {
            Log.i("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM[%b]", REMOTE_CALL);
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.o(89333);
            return booleanValue;
        }
        AppMethodBeat.o(89333);
        return true;
    }

    @f
    public Boolean useMediaRecordNewInMM() {
        AppMethodBeat.i(89334);
        Log.d("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM() called");
        Boolean valueOf = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_jump_to_record_media, true));
        AppMethodBeat.o(89334);
        return valueOf;
    }

    @f
    public void clearArtistCacheInMM() {
        AppMethodBeat.i(89335);
        Log.d("MicroMsg.CaptureMMProxy", "clearArtistCacheInMM() called");
        ab.diQ.Uo().Un();
        AppMethodBeat.o(89335);
    }

    @f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        AppMethodBeat.i(89336);
        Log.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        VideoTransPara bbc = e.baZ().bbc();
        Log.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(bbc)));
        AppMethodBeat.o(89336);
        return bbc;
    }

    @f
    public VideoTransPara getGameVideoTransParaInMM(int i2) {
        AppMethodBeat.i(89337);
        Log.d("MicroMsg.CaptureMMProxy", "getGameVideoTransParaInMM() called");
        VideoTransPara sV = e.baZ().sV(i2);
        Log.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(sV)));
        AppMethodBeat.o(89337);
        return sV;
    }

    @f
    public boolean checkUseMMVideoPlayerInMM() {
        AppMethodBeat.i(89338);
        Log.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
        e.baZ();
        boolean bbm = e.bbm();
        Log.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(bbm)));
        AppMethodBeat.o(89338);
        return bbm;
    }

    @f
    public String getAccVideoPathInMM() {
        AppMethodBeat.i(89339);
        Log.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        o.bhi();
        String accVideoPath = o.getAccVideoPath();
        AppMethodBeat.o(89339);
        return accVideoPath;
    }

    @f
    public String getSubCoreImageFullPathInMM(String str) {
        AppMethodBeat.i(89340);
        Log.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", str);
        String fullPath = q.bcR().getFullPath(str);
        AppMethodBeat.o(89340);
        return fullPath;
    }

    @f
    public Object getConfigStorage(int i2, Object obj) {
        AppMethodBeat.i(89341);
        ar.a aVar = ((ar.a[]) ar.a.class.getEnumConstants())[i2];
        Log.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", aVar, obj);
        g.aAi();
        Object obj2 = g.aAh().azQ().get(aVar, obj);
        AppMethodBeat.o(89341);
        return obj2;
    }

    @f
    public boolean setConfigStorage(int i2, Object obj) {
        AppMethodBeat.i(89342);
        ar.a aVar = ((ar.a[]) ar.a.class.getEnumConstants())[i2];
        Log.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", aVar, obj);
        g.aAi();
        g.aAh().azQ().set(aVar, obj);
        AppMethodBeat.o(89342);
        return true;
    }

    @f
    public String getDeviceInfoConfigInMM() {
        AppMethodBeat.i(89343);
        g.aAi();
        String gEu = g.aAh().azR().gEu();
        AppMethodBeat.o(89343);
        return gEu;
    }

    @f
    public String getDynamicConfigInMM(String str) {
        AppMethodBeat.i(89344);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue(str);
        AppMethodBeat.o(89344);
        return value;
    }

    @f
    public byte[] getWeixinMetaDataInMM() {
        AppMethodBeat.i(89345);
        byte[] weixinMeta = e.baZ().getWeixinMeta();
        AppMethodBeat.o(89345);
        return weixinMeta;
    }

    @Override // com.tencent.mm.remoteservice.a
    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(89346);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (objArr[i2] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i2), (Bundle) objArr[i2]);
            } else if (objArr[i2] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i2), (Parcelable) objArr[i2]);
            } else if (objArr[i2] instanceof ar.a) {
                Log.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", Integer.valueOf(((ar.a) objArr[i2]).ordinal()));
                bundle.putInt(String.valueOf(i2), ((ar.a) objArr[i2]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i2), (Serializable) objArr[i2]);
            }
        }
        AppMethodBeat.o(89346);
        return bundle;
    }

    @Override // com.tencent.mm.remoteservice.a, com.tencent.mm.remoteservice.b
    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(89347);
        Log.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            Method[] methods = getClass().getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.o(89347);
                            return;
                        }
                        if ("getConfigStorage".equals(str)) {
                            Log.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(89347);
        } catch (Exception e2) {
            Log.e("MicroMsg.CaptureMMProxy", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(89347);
        }
    }
}
