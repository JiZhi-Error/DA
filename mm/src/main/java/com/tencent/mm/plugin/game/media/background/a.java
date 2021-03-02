package com.tencent.mm.plugin.game.media.background;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.plugin.game.media.q;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static void a(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        AppMethodBeat.i(41185);
        int i2 = bundle.getInt("key_video_from", 0);
        RecordMediaReportInfo eJJ = captureVideoNormalModel.eJJ();
        HashMap hashMap = new HashMap();
        hashMap.put("videoid", s.bhK(captureVideoNormalModel.videoPath));
        hashMap.put("costtime", eJJ.y("KEY_REMUX_VIDEO_COST_MS_INT", 0));
        hashMap.put("origtime", Integer.valueOf(bundle.getInt("key_raw_video_duration", 0)));
        hashMap.put("cliptime", Integer.valueOf(Util.videoMsToSec(captureVideoNormalModel.BOd.longValue())));
        hashMap.put("origsize", Integer.valueOf(bundle.getInt("key_raw_video_size", 0)));
        hashMap.put("remuxsize", Integer.valueOf((int) s.boW(captureVideoNormalModel.videoPath)));
        hashMap.put("hasexpre", eJJ.y("KEY_ADD_EMOJI_COUNT_INT", 0));
        hashMap.put("hasword", eJJ.y("KEY_ADD_TEXT_COUNT_INT", 0));
        hashMap.put("hasmusic", 1);
        if (((Integer) eJJ.y("KEY_MUSIC_ID_INT", -1)).intValue() == -1) {
            hashMap.put("hasmusic", 0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : hashMap.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append(":");
            stringBuffer.append(entry.getValue());
            stringBuffer.append(", ");
        }
        Log.i("MicroMsg.Haowan.ActionAfterVideoEdited", "remuxResult:%b, statistic:[%s]", captureVideoNormalModel.BOc, stringBuffer.toString());
        int i3 = bundle.getInt("game_haowan_source_scene_id", 0);
        if (!captureVideoNormalModel.BOc.booleanValue()) {
            Log.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video remux error");
            com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8763, 2, 56, i3, com.tencent.mm.game.report.b.a.c(i2, hashMap));
            AppMethodBeat.o(41185);
            return;
        }
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8763, 2, 48, i3, com.tencent.mm.game.report.b.a.c(i2, hashMap));
        AppMethodBeat.o(41185);
    }

    public static int c(RecordMediaReportInfo recordMediaReportInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(41188);
        if (recordMediaReportInfo == null) {
            AppMethodBeat.o(41188);
            return 0;
        }
        boolean z4 = ((Integer) recordMediaReportInfo.y("KEY_ADD_EMOJI_COUNT_INT", 0)).intValue() != 0;
        if (((Integer) recordMediaReportInfo.y("KEY_ADD_TEXT_COUNT_INT", 0)).intValue() != 0) {
            z = true;
        } else {
            z = false;
        }
        if (((Integer) recordMediaReportInfo.y("KEY_SELECT_MUSIC_INT", 0)).intValue() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        long intValue = (long) ((Integer) recordMediaReportInfo.y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", 0)).intValue();
        long intValue2 = (long) ((Integer) recordMediaReportInfo.y("KEY_VIDEO_CROP_DURATION_MS_INT", 0)).intValue();
        if (intValue == 0 || intValue2 == 0 || intValue == intValue2) {
            z3 = false;
        } else {
            z3 = true;
        }
        int c2 = q.c(z4, z, z2, z3);
        Log.i("MicroMsg.Haowan.ActionAfterVideoEdited", "hasEmoji:%b, hasText:%b, hasMusic:%b, hasCut:%b, editFlag:%d", Boolean.valueOf(z4), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(c2));
        AppMethodBeat.o(41188);
        return c2;
    }

    public static void aAb(String str) {
        AppMethodBeat.i(41189);
        String exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
        Log.i("MicroMsg.Haowan.ActionAfterVideoEdited", "auto save video :%s", exportImagePath);
        s.nw(str, exportImagePath);
        AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
        AppMethodBeat.o(41189);
    }

    public static WebViewJSSDKVideoItem hI(String str, String str2) {
        AppMethodBeat.i(41191);
        WebViewJSSDKVideoItem aAc = aAc(str);
        if (aAc == null) {
            AppMethodBeat.o(41191);
            return null;
        }
        WebViewJSSDKFileItem aYO = ao.gcQ().aYO(hJ(str2, str));
        if (aYO != null) {
            aAc.lPx = aYO.laR;
        }
        AppMethodBeat.o(41191);
        return aAc;
    }

    public static String hJ(String str, String str2) {
        AppMethodBeat.i(41192);
        if (TextUtils.isEmpty(str)) {
            o oVar = new o(str2);
            String name = oVar.getName();
            String str3 = null;
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str3 = name.substring(0, name.lastIndexOf("."));
            }
            if (!TextUtils.isEmpty(str3)) {
                str = oVar.getParent() + FilePathGenerator.ANDROID_DIR_SEP + str3 + ".jpeg";
            } else {
                str = oVar.getParent() + "microMsg_" + System.currentTimeMillis() + ".jpeg";
            }
        }
        if (!new o(str).exists()) {
            Log.i("MicroMsg.Haowan.ActionAfterVideoEdited", "create new thumb path:%s!", str);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str2, 1);
            if (createVideoThumbnail == null) {
                Log.e("MicroMsg.Haowan.ActionAfterVideoEdited", "createVideoThumbnail bitmap fail for path:%s!", str);
                AppMethodBeat.o(41192);
                return "";
            }
            try {
                BitmapUtil.saveBitmapToImage(ThumbnailUtils.extractThumbnail(createVideoThumbnail, ab.CTRL_INDEX, 400, 2), 30, Bitmap.CompressFormat.JPEG, str, true);
            } catch (IOException e2) {
                Log.e("MicroMsg.Haowan.ActionAfterVideoEdited", "saveBitmapToImage exist IOException:" + e2.getMessage());
            }
        } else {
            Log.i("MicroMsg.Haowan.ActionAfterVideoEdited", "file is exist for path:%s!", str);
        }
        if (!TextUtils.isEmpty(str)) {
            WebViewJSSDKFileItem ma = WebViewJSSDKFileItem.ma(str, str);
            ma.laV = true;
            ma.mediaType = 1;
            g.gdv().a(ma);
            String str4 = ma.dJX;
            AppMethodBeat.o(41192);
            return str4;
        }
        AppMethodBeat.o(41192);
        return "";
    }

    public static WebViewJSSDKVideoItem aAc(String str) {
        AppMethodBeat.i(41193);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str);
        if (aNx == null) {
            Log.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video after edited is error");
            AppMethodBeat.o(41193);
            return null;
        }
        WebViewJSSDKVideoItem byz = WebViewJSSDKFileItem.byz(str);
        byz.duration = aNx.getVideoDuration();
        byz.width = aNx.width;
        byz.height = aNx.height;
        byz.size = (int) s.boW(str);
        g.gdv().a(byz);
        AppMethodBeat.o(41193);
        return byz;
    }

    public static void a(String str, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(41186);
        if (!str.equals(captureVideoNormalModel.videoPath)) {
            s.boN(s.boZ(str));
            if (s.nw(captureVideoNormalModel.videoPath, str) > 0) {
                captureVideoNormalModel.videoPath = str;
            }
        }
        AppMethodBeat.o(41186);
    }

    public static void b(String str, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(41187);
        if (!str.equals(captureVideoNormalModel.thumbPath)) {
            s.boN(s.boZ(str));
            if (s.nw(captureVideoNormalModel.thumbPath, str) > 0) {
                captureVideoNormalModel.thumbPath = str;
            }
        }
        AppMethodBeat.o(41187);
    }

    public static String a(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(41190);
        WebViewJSSDKVideoItem aAc = aAc(captureVideoNormalModel.videoPath);
        if (aAc == null) {
            AppMethodBeat.o(41190);
            return null;
        }
        String hJ = hJ(captureVideoNormalModel.thumbPath, captureVideoNormalModel.videoPath);
        WebViewJSSDKFileItem aYO = ao.gcQ().aYO(hJ);
        if (aYO != null) {
            aAc.lPx = aYO.laR;
        }
        aAc.jkf.putInt("mark_edit_flag", c(captureVideoNormalModel.eJJ()));
        String c2 = ay.c(aAc.dJX, hJ, aAc.duration, aAc.height, aAc.width, aAc.size);
        AppMethodBeat.o(41190);
        return c2;
    }
}
