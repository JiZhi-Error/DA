package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.n.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J,\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020\u0004J0\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020,2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\rJ\u0012\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J\n\u00102\u001a\u00020\u0004*\u000203J\u0014\u00104\u001a\u000205*\u0002062\b\b\u0002\u00107\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkDeviceIsConfiguration", "", "videoPath", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "checkMediaRatio", "width", "", "height", "checkSelectedVideo", "context", "Landroid/content/Context;", "checkThumbFileExist", "thumbFile", "convertMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "originMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "fullThumbUrl", "halfRect", "Landroid/graphics/Rect;", "getMediaInfo", "path", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "resize2Even", "value", "getUniqId", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "prefix", "VideoMediaItem", "plugin-finder_release"})
public final class i {
    private static final String TAG = TAG;
    public static final i vSX = new i();

    static {
        AppMethodBeat.i(167785);
        AppMethodBeat.o(167785);
    }

    private i() {
    }

    public static void a(FinderFeedReportObject finderFeedReportObject, String str) {
        AppMethodBeat.i(253103);
        p.h(finderFeedReportObject, "$this$print");
        p.h(str, "prefix");
        Log.i("Finder.FinderFeedReportObject", str + " remux:" + finderFeedReportObject.mediaProcessCost + ",upload:" + finderFeedReportObject.uploadCost + ",uploadSize:" + (finderFeedReportObject.uploadMediaTotalSize / 1024) + "KB,taskTotal:" + finderFeedReportObject.postTaskCost + ",repost:" + finderFeedReportObject.clickRepostCount);
        AppMethodBeat.o(253103);
    }

    public static cjm dBh() {
        AppMethodBeat.i(167779);
        cjm cjm = new cjm();
        cjm.clientId = "FinderLocal_" + System.nanoTime();
        AppMethodBeat.o(167779);
        return cjm;
    }

    public static boolean avZ(String str) {
        AppMethodBeat.i(167780);
        p.h(str, "thumbFile");
        if (s.YS(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            if (options.outWidth > 0 && options.outHeight > 0) {
                AppMethodBeat.o(167780);
                return true;
            }
        }
        AppMethodBeat.o(167780);
        return false;
    }

    public static /* synthetic */ cjl hb(String str, String str2) {
        AppMethodBeat.i(253105);
        cjl ha = ha(str, str2);
        AppMethodBeat.o(253105);
        return ha;
    }

    public static cjl ha(String str, String str2) {
        AppMethodBeat.i(253104);
        p.h(str, "filePath");
        p.h(str2, "thumbUrl");
        Log.i(TAG, "gen img media url %s, thumbUrl %s", str, str2);
        cjl cjl = new cjl();
        cjl.mediaType = 2;
        Exif fromFile = Exif.fromFile(str);
        p.g(fromFile, "Exif.fromFile(filePath)");
        if (fromFile.getOrientationInDegree() != 0) {
            al alVar = al.waC;
            String awA = al.awA(str);
            if (s.YS(awA)) {
                str = awA;
            }
        }
        cjl.url = str;
        cjl.thumbUrl = str2;
        cjl.MoR = str2;
        cjl.mediaId = MD5Util.getMD5String(cjl.url);
        y yVar = y.vXH;
        String str3 = cjl.url;
        if (str3 == null) {
            str3 = "";
        }
        Point awm = y.awm(str3);
        cjl.width = (float) awm.x;
        cjl.height = (float) awm.y;
        cjl.MoL = 1;
        cjl.MoO = false;
        AppMethodBeat.o(253104);
        return cjl;
    }

    public static cjl hc(String str, String str2) {
        AppMethodBeat.i(167782);
        p.h(str, "filePath");
        p.h(str2, "thumbUrl");
        Log.i(TAG, "gen img media url %s, thumbUrl %s", str, str2);
        cjl cjl = new cjl();
        cjl.mediaType = 7;
        if (SightVideoJNI.getMp4RotateVFS(str) != 0) {
            al alVar = al.waC;
            String awA = al.awA(str);
            if (s.YS(awA)) {
                str = awA;
            }
        }
        cjl.url = str;
        cjl.thumbUrl = str2;
        cjl.mediaId = MD5Util.getMD5String(cjl.url);
        y yVar = y.vXH;
        String str3 = cjl.url;
        if (str3 == null) {
            str3 = "";
        }
        Point awm = y.awm(str3);
        cjl.width = (float) awm.x;
        cjl.height = (float) awm.y;
        cjl.MoL = 1;
        AppMethodBeat.o(167782);
        return cjl;
    }

    public static /* synthetic */ cjl a(String str, String str2, cjx cjx) {
        AppMethodBeat.i(253107);
        cjl a2 = a(str, str2, cjx, "");
        AppMethodBeat.o(253107);
        return a2;
    }

    public static cjl a(String str, String str2, cjx cjx, String str3) {
        AppMethodBeat.i(253106);
        p.h(str, "filePath");
        p.h(str2, "thumbUrl");
        p.h(str3, "coverUrl");
        Log.i(TAG, "gen video media url %s, thumbUrl %s", str, str2);
        cjl cjl = new cjl();
        cjl.mediaType = 4;
        cjl.url = str;
        cjl.thumbUrl = str2;
        cjl.mediaId = MD5Util.getMD5String(str);
        cjl.fileSize = (int) s.boW(str);
        cjl.coverUrl = str3;
        y yVar = y.vXH;
        com.tencent.mm.plugin.sight.base.a awl = y.awl(str);
        if (awl != null) {
            cjl.width = (float) awl.width;
            cjl.height = (float) awl.height;
            cjl.bitrate = awl.videoBitrate;
            cjl.videoDuration = awl.getVideoDuration();
            if (cjx != null && cjx.iqg > 0) {
                cjl.videoDuration = cjx.iqg / 1000;
            }
        }
        cjl.MoL = 1;
        if (cjx == null) {
            cjl.MoO = false;
        } else {
            cjl.MoO = true;
            cjl.width = (float) cjx.width;
            cjl.height = (float) cjx.height;
            cjl.uOR = cjx;
        }
        AppMethodBeat.o(253106);
        return cjl;
    }

    private static int Lt(int i2) {
        if (i2 % 2 != 0) {
            return i2 - 1;
        }
        return i2;
    }

    public static cjl a(acn acn, String str, String str2, String str3, Rect rect) {
        AppMethodBeat.i(253108);
        p.h(acn, "info");
        p.h(str, "thumbUrl");
        p.h(str2, "fullThumbUrl");
        p.h(str3, "coverUrl");
        Log.i(TAG, "getFakeVideoMedia  info:" + acn + "  thumbUrl:" + str);
        cjl cjl = new cjl();
        cjl.url = "";
        cjl.mediaType = 4;
        cjl.thumbUrl = str;
        cjl.MoR = str2;
        cjl.coverUrl = str3;
        cjl.mediaId = MD5Util.getMD5String(acn.Lnd.get(0).path);
        cjl.width = (float) acn.Gxw.targetWidth;
        cjl.height = (float) acn.Gxw.targetHeight;
        cjl.MfU = acn;
        cjl.MoO = false;
        cjl.uOR = new cjx();
        if (rect == null) {
            cjl.thumbUrl = str2;
            dlh dlh = acn.Gxw.Lnm;
            int intValue = dlh.Msu.get(2).intValue();
            Integer num = dlh.Msu.get(0);
            p.g(num, "cropRect.values[0]");
            int intValue2 = intValue - num.intValue();
            int intValue3 = dlh.Msu.get(3).intValue();
            Integer num2 = dlh.Msu.get(1);
            p.g(num2, "cropRect.values[1]");
            acn.Gxw.targetHeight = Lt(((intValue3 - num2.intValue()) * acn.Gxw.targetWidth) / intValue2);
        } else {
            aty aty = new aty();
            aty.left = (float) rect.left;
            aty.top = (float) rect.top;
            aty.right = (float) rect.right;
            aty.bottom = (float) rect.bottom;
            cjl.MoU = aty;
            if (acn.Lnk) {
                car car = new car();
                car.thumbUrl = str;
                car.width = (float) rect.width();
                car.height = (float) rect.height();
                acn acn2 = new acn();
                acn2.parseFrom(acn.toByteArray());
                aco aco = acn2.Gxw;
                StringBuilder sb = new StringBuilder();
                p.g(o.bhi(), "SubCoreVideo.getCore()");
                aco.rpE = sb.append(o.getAccVideoPath()).append("vsg_half_output_").append(System.currentTimeMillis()).append(".mp4").toString();
                acn2.Gxw.targetWidth = Lt((int) (car.width * acn2.Gxw.Lnn));
                acn2.Gxw.targetHeight = Lt((int) (car.height * acn2.Gxw.Lnn));
                car.MfU = acn2;
                cjl.MoX = car;
            }
            dlh dlh2 = acn.Gxw.Lnm;
            dlh2.Msu.set(0, 0);
            dlh2.Msu.set(1, 0);
            dlh2.Msu.set(2, Integer.valueOf(acn.Gxw.xlg));
            dlh2.Msu.set(3, Integer.valueOf(acn.Gxw.xlh));
        }
        AppMethodBeat.o(253108);
        return cjl;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static Point dK(String str, int i2) {
        AppMethodBeat.i(167784);
        c cVar = c.vCb;
        int dqN = c.dqN();
        if (!Util.isNullOrNil(str)) {
            switch (i2) {
                case 2:
                case 7:
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapUtil.decodeFile(str, options);
                    Exif fromFile = Exif.fromFile(str);
                    p.g(fromFile, "Exif.fromFile(filePath)");
                    if (fromFile.getOrientationInDegree() % TXLiveConstants.RENDER_ROTATION_180 != 0) {
                        int i3 = options.outHeight;
                        options.outHeight = options.outWidth;
                        options.outWidth = i3;
                    }
                    int min = Math.min(options.outWidth, options.outHeight);
                    int min2 = Math.min(min, dqN);
                    if (min == options.outWidth) {
                        Point point = new Point(min2, (int) (((float) options.outHeight) * ((((float) min2) * 1.0f) / ((float) options.outWidth))));
                        AppMethodBeat.o(167784);
                        return point;
                    }
                    Point point2 = new Point((int) (((float) options.outWidth) * ((((float) min2) * 1.0f) / ((float) options.outHeight))), min2);
                    AppMethodBeat.o(167784);
                    return point2;
                case 4:
                case 6:
                    y yVar = y.vXH;
                    if (str == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.sight.base.a awl = y.awl(str);
                    if (awl != null) {
                        int min3 = Math.min(awl.width, awl.height);
                        int min4 = Math.min(min3, dqN);
                        if (min3 == awl.width) {
                            Point point3 = new Point(min4, (int) (((float) awl.height) * ((((float) min4) * 1.0f) / ((float) awl.width))));
                            AppMethodBeat.o(167784);
                            return point3;
                        }
                        Point point4 = new Point((int) (((float) awl.width) * ((((float) min4) * 1.0f) / ((float) awl.height))), min4);
                        AppMethodBeat.o(167784);
                        return point4;
                    }
                    break;
            }
        }
        Point point5 = new Point(dqN, dqN);
        AppMethodBeat.o(167784);
        return point5;
    }

    public static String v(FinderItem finderItem) {
        AppMethodBeat.i(253109);
        p.h(finderItem, "$this$getUniqId");
        String str = z.aTY() + "_" + finderItem.m21getCreateTime() + "_" + finderItem.getLocalId();
        AppMethodBeat.o(253109);
        return str;
    }

    public static azk a(clp clp) {
        String str;
        AppMethodBeat.i(253110);
        if (clp == null) {
            AppMethodBeat.o(253110);
            return null;
        }
        azk azk = new azk();
        azk.wWb = String.valueOf(clp.MqO);
        azk.LJh = clp.jTB;
        azk.name = clp.MqW;
        LinkedList<String> linkedList = clp.MqX;
        if (linkedList != null) {
            str = (String) j.kt(linkedList);
        } else {
            str = null;
        }
        azk.artist = str;
        azk.LJi = clp.MqU;
        AppMethodBeat.o(253110);
        return azk;
    }

    public static boolean ayX(String str) {
        AppMethodBeat.i(261417);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_album_device_configuration, "");
        if (TextUtils.isEmpty(a2)) {
            AppMethodBeat.o(261417);
            return false;
        }
        Log.i(TAG, "devices configuration: %s", a2);
        Log.i(TAG, "android version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
        try {
            JSONObject jSONObject = new JSONObject(a2);
            String optString = jSONObject.optString("devices");
            int optInt = jSONObject.optInt("maxsize");
            JSONArray jSONArray = new JSONArray(optString);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (n.I(Build.MANUFACTURER, optJSONObject.optString("brand"), true) && n.I(Build.MODEL, optJSONObject.optString("model"), true)) {
                    long boW = s.boW(str);
                    if (optInt == 0 || boW <= ((long) (optInt * 1024 * 1024))) {
                        int optInt2 = optJSONObject.optInt("androidVersion");
                        if (-1 == optInt2) {
                            Log.i(TAG, "hit devices all version, manufacturer: %s, brand: %s, model: %s", Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                            AppMethodBeat.o(261417);
                            return true;
                        } else if (Build.VERSION.SDK_INT == optInt2) {
                            Log.i(TAG, "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL);
                            AppMethodBeat.o(261417);
                            return true;
                        }
                    } else {
                        Log.i(TAG, "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", Long.valueOf(boW), Integer.valueOf(optInt), str);
                        AppMethodBeat.o(261417);
                        return false;
                    }
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace(TAG, e2, "parse json error", new Object[0]);
        }
        AppMethodBeat.o(261417);
        return false;
    }

    public static a bxY(String str) {
        AppMethodBeat.i(261418);
        try {
            String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(str);
            Log.i(TAG, "get simple mp4 info %s", simpleMp4InfoVFS);
            JSONObject jSONObject = new JSONObject(simpleMp4InfoVFS);
            a aVar = new a();
            aVar.bya(str);
            aVar.jkS = jSONObject.getInt("videoDuration");
            aVar.videoHeight = jSONObject.getInt("videoHeight");
            aVar.videoWidth = jSONObject.getInt("videoWidth");
            aVar.videoBitRate = jSONObject.getInt("videoBitrate");
            aVar.videoFrameRate = jSONObject.getInt("videoFPS");
            aVar.ihS = SightVideoJNI.getMp4RotateVFS(str);
            aVar.videoIFrameInterval = 0;
            aVar.jkQ = com.tencent.mm.plugin.gallery.a.b.azg(jSONObject.getString("videoType"));
            aVar.jkR = com.tencent.mm.plugin.gallery.a.b.azg(jSONObject.getString("audioType"));
            AppMethodBeat.o(261418);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "loadItemFromSimpleMP4Info fail", new Object[0]);
            AppMethodBeat.o(261418);
            return null;
        }
    }

    public static a bxZ(String str) {
        String string;
        String string2;
        AppMethodBeat.i(261419);
        com.tencent.mm.compatible.i.c cVar = new com.tencent.mm.compatible.i.c();
        try {
            cVar.setDataSource(str);
            int trackCount = cVar.getTrackCount();
            MediaFormat mediaFormat = null;
            MediaFormat mediaFormat2 = null;
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = cVar.getTrackFormat(i2);
                p.g(trackFormat, "extractor.getTrackFormat(i)");
                if (trackFormat.containsKey("mime")) {
                    String string3 = trackFormat.getString("mime");
                    Log.d(TAG, "find video mime : %s", string3);
                    if (string3 != null) {
                        if (n.J(string3, "video/", false)) {
                            if (mediaFormat2 == null) {
                                mediaFormat2 = trackFormat;
                            }
                        } else if (n.J(string3, "audio/", false) && mediaFormat == null) {
                            mediaFormat = trackFormat;
                        }
                        if (!(mediaFormat == null || mediaFormat2 == null)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Log.d(TAG, "find video mime : not found.");
                }
            }
            a aVar = new a();
            aVar.bya(str);
            if (mediaFormat2 != null) {
                aVar.jkS = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                aVar.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                aVar.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                if (!mediaFormat2.containsKey("mime")) {
                    string2 = "";
                } else {
                    string2 = mediaFormat2.getString("mime");
                }
                aVar.jkQ = string2;
                aVar.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                aVar.videoIFrameInterval = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                aVar.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                aVar.ihS = SightVideoJNI.getMp4RotateVFS(str);
            }
            if (mediaFormat != null) {
                if (!mediaFormat.containsKey("mime")) {
                    string = "";
                } else {
                    string = mediaFormat.getString("mime");
                }
                aVar.jkR = string;
            }
            Log.i(TAG, "loadItemFromExtractor mediaItem: %s", aVar);
            Log.i(TAG, "mediaItem format:%s, videoPath:%s", mediaFormat2, str);
            return aVar;
        } catch (Exception e2) {
            Log.i(TAG, "Video extractor init failed. video path = [%s] e = [%s]", str, e2.getMessage());
            return null;
        } finally {
            cVar.release();
            AppMethodBeat.o(261419);
        }
    }

    public static boolean gl(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return false;
        }
        float f2 = ((float) i2) / ((float) i3);
        if (f2 > 3.0f || f2 < 0.33333334f) {
            return false;
        }
        return true;
    }

    public static boolean a(a aVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(261420);
        if (n.I(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, aVar.jkQ, true) && f.ejb()) {
            z = true;
        } else if (n.I("video/avc", aVar.jkQ, true)) {
            z = true;
        } else {
            z = false;
        }
        if (!Util.isNullOrNil(aVar.jkR) && !n.I(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, aVar.jkR, true)) {
            Log.i(TAG, "audioTrack invalid, " + aVar.jkR);
            z = false;
        }
        if (!r.Ql(aVar.xiW)) {
            z2 = z;
        } else if (Util.isNullOrNil(aVar.jkQ) || !f.aFg(aVar.jkQ) || Util.isNullOrNil(aVar.jkR) || !f.aFg(aVar.jkR)) {
            Log.i(TAG, "qt video cannot decode");
            z2 = false;
        } else {
            Log.i(TAG, "qt video can decode");
        }
        AppMethodBeat.o(261420);
        return z2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "", "()V", "audioTrackMime", "", "getAudioTrackMime", "()Ljava/lang/String;", "setAudioTrackMime", "(Ljava/lang/String;)V", "durationMs", "", "getDurationMs", "()I", "setDurationMs", "(I)V", "mOriginalPath", "getMOriginalPath", "setMOriginalPath", "videoBitRate", "getVideoBitRate", "setVideoBitRate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoIFrameInterval", "getVideoIFrameInterval", "setVideoIFrameInterval", "videoRotate", "getVideoRotate", "setVideoRotate", "videoTrackMime", "getVideoTrackMime", "setVideoTrackMime", "videoWidth", "getVideoWidth", "setVideoWidth", "plugin-finder_release"})
    public static final class a {
        int ihS = -1;
        public String jkQ;
        public String jkR;
        int jkS = -1;
        int videoBitRate = -1;
        int videoFrameRate = -1;
        public int videoHeight = -1;
        int videoIFrameInterval = -1;
        public int videoWidth = -1;
        public String xiW = "";

        public final void bya(String str) {
            AppMethodBeat.i(261416);
            p.h(str, "<set-?>");
            this.xiW = str;
            AppMethodBeat.o(261416);
        }
    }
}
