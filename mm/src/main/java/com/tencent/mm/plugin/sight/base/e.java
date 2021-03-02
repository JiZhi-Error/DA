package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class e {
    private static int zst = 0;
    private static int zsu = 0;

    public static boolean eVu() {
        AppMethodBeat.i(133599);
        if (ae.gKv.gKh == 0) {
            AppMethodBeat.o(133599);
            return false;
        }
        boolean oD = d.oD(14);
        AppMethodBeat.o(133599);
        return oD;
    }

    public static String aFl(String str) {
        AppMethodBeat.i(133600);
        String str2 = Util.nullAs(str, "") + ".thumb";
        AppMethodBeat.o(133600);
        return str2;
    }

    public static String aNv(String str) {
        AppMethodBeat.i(133601);
        String str2 = Util.nullAs(str, "") + ".soundmp4";
        AppMethodBeat.o(133601);
        return str2;
    }

    public static Bitmap az(String str, int i2, int i3) {
        AppMethodBeat.i(133602);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133602);
            return null;
        }
        Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            Log.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", str);
        } else {
            createVideoThumbnail = BitmapUtil.extractThumbNail(createVideoThumbnail, i3, i2, true, true);
        }
        AppMethodBeat.o(133602);
        return createVideoThumbnail;
    }

    public static boolean aNw(String str) {
        AppMethodBeat.i(133603);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            AppMethodBeat.o(133603);
            return false;
        }
        long currentTicks = Util.currentTicks();
        d dVar = new d();
        int isSightOkVFS = SightVideoJNI.isSightOkVFS(str, dVar.Dmj, dVar.Dmk, dVar.Dml, dVar.Dmn, dVar.Dmm, dVar.Dmm.length);
        Log.d("MicroMsg.SightUtil", "ashu::check sight use %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
        if (isSightOkVFS == 0) {
            AppMethodBeat.o(133603);
            return true;
        }
        AppMethodBeat.o(133603);
        return false;
    }

    public static String eVv() {
        String str;
        AppMethodBeat.i(133604);
        StringBuilder sb = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb);
        Context context = MMApplicationContext.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
        stringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
        stringBuilderPrinter.println("#accinfo.env=" + (CrashReportFactory.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.KyI);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.KyJ);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.KyK);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.KyL);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.KyM);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
        try {
            String absolutePath = Environment.getDataDirectory().getAbsolutePath();
            StatFs statFs = new StatFs(absolutePath);
            StatFs statFs2 = new StatFs(b.aKD());
            str = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", Integer.valueOf(((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass()), absolutePath, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), b.aKD(), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
        } catch (Exception e2) {
            Log.e("MicroMsg.SightUtil", "check data size failed :%s", e2.getMessage());
            str = "";
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(str)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        String sb2 = sb.toString();
        AppMethodBeat.o(133604);
        return sb2;
    }

    public static String aFm(String str) {
        AppMethodBeat.i(133605);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n".concat(String.valueOf(a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
        stringBuffer.append("size: " + Util.getSizeKB(s.boW(str)) + ":" + str + "\n");
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!Util.isNullOrNil(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(r.isH265Video(str));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(133605);
        return stringBuffer2;
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        AppMethodBeat.i(133606);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(str);
            Log.d("MicroMsg.SightUtil", "get simple mp4 info %s", simpleMp4InfoVFS);
            JSONObject jSONObject = new JSONObject(simpleMp4InfoVFS);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append("\n");
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value)))).append("\n");
            stringBuffer.append("videoDuration: ").append(pInt.value).append("\n");
            stringBuffer.append("videoFPS: ").append(pInt4.value).append("\n");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SightUtil", e2, "get media info error", new Object[0]);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(133606);
        return stringBuffer2;
    }

    public static a aNx(String str) {
        AppMethodBeat.i(133607);
        a cc = cc(str, false);
        AppMethodBeat.o(133607);
        return cc;
    }

    public static a cc(String str, boolean z) {
        a aVar = null;
        AppMethodBeat.i(201788);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(201788);
        } else if (!s.YS(str)) {
            AppMethodBeat.o(201788);
        } else {
            aVar = new a();
            try {
                String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(str, z);
                Log.d("MicroMsg.SightUtil", "get simple mp4 info %s", simpleMp4InfoVFS);
                JSONObject jSONObject = new JSONObject(simpleMp4InfoVFS);
                aVar.videoDuration = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.frameRate = (int) jSONObject.getDouble("videoFPS");
                aVar.videoBitrate = jSONObject.getInt("videoBitrate");
                aVar.audioBitrate = jSONObject.getInt("audioBitrate");
                aVar.audioChannel = jSONObject.getInt("audioChannel");
                aVar.Cip = jSONObject.getInt("useABA");
                aVar.Cir = jSONObject.getInt("useMinMaxQP");
                aVar.Ciq = jSONObject.getInt("bitrateAdaptiveUp");
                aVar.audioSampleRate = jSONObject.getInt("aacSampleRate");
                aVar.pixelFormat = jSONObject.optInt("pixelFormat", -1);
            } catch (Exception e2) {
                Log.e("MicroMsg.SightUtil", "get media info error %s", e2.toString());
            }
            Log.i("MicroMsg.SightUtil", "get media %s", aVar);
            AppMethodBeat.o(201788);
        }
        return aVar;
    }
}
