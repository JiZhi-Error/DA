package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Set;

public final class a {
    public static Set<String> jkO;

    public static Intent a(int i2, WXMediaMessage wXMediaMessage, String str, String str2, boolean z, Bundle bundle) {
        int i3;
        String str3;
        AppMethodBeat.i(231571);
        Log.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        Log.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
        WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i3 = 2;
                break;
            case 2:
                i3 = 1;
                break;
            case 3:
                i3 = 4;
                break;
            case 4:
                i3 = 5;
                break;
            case 5:
            case 6:
                i3 = 3;
                break;
            case 7:
                i3 = 3;
                break;
            case 38:
            case 39:
                i3 = 15;
                break;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                i3 = 42;
                break;
            default:
                i3 = -1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("KThrid_app", true);
        Log.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i3 + " " + iMediaObject.type());
        intent.putExtra("Ksnsupload_appid", str);
        intent.putExtra("Ksnsupload_appname", str2);
        intent.putExtra("Ksnsupload_open_sdk_version", i2);
        intent.putExtra("KSnsAction", true);
        intent.putExtra("need_result", true);
        intent.putExtra("Ksnsupload_app_is_game", z);
        Bundle bundle2 = new Bundle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle2);
        intent.putExtra("Ksnsupload_timeline", bundle2);
        if (i3 == -1) {
            Log.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            AppMethodBeat.o(231571);
            return null;
        }
        switch (iMediaObject.type()) {
            case 1:
                intent.putExtra("Kdescription", ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                AppMethodBeat.o(231571);
                return intent;
            case 2:
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", ((WXImageObject) iMediaObject).imagePath);
                AppMethodBeat.o(231571);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String nullAs = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                if (tN(3) == -1) {
                    Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
                    AppMethodBeat.o(231571);
                    return null;
                }
                Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", nullAs);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                AppMethodBeat.o(231571);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                String nullAs2 = Util.nullAs(!Util.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, "");
                if (tN(3) == -1) {
                    Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
                    AppMethodBeat.o(231571);
                    return null;
                }
                intent.putExtra("Ksnsupload_link", nullAs2);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                AppMethodBeat.o(231571);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", Util.nullAs(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                AppMethodBeat.o(231571);
                return intent;
            case 6:
                Log.e("MicroMsg.ShareSnsImpl", "file is not support!");
                AppMethodBeat.o(231571);
                return null;
            case 7:
                AppMethodBeat.o(231571);
                return null;
            case 38:
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                String str4 = ((WXVideoFileObject) iMediaObject).filePath;
                String str5 = "";
                String bhK = s.bhK(str4);
                if (Util.isNullOrNil(str5) || !s.YS(str5)) {
                    StringBuilder sb = new StringBuilder();
                    bg.aVF();
                    str5 = sb.append(c.getAccSnsTmpPath()).append(bhK).toString();
                    try {
                        Bitmap PF = PF(str4);
                        if (PF != null) {
                            Log.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(PF.getWidth()), Integer.valueOf(PF.getHeight()));
                            BitmapUtil.saveBitmapToImage(PF, 80, Bitmap.CompressFormat.JPEG, str5, true);
                            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str5);
                            Log.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                        } else {
                            Log.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", str4);
                            AppMethodBeat.o(231571);
                            return null;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e2.getMessage());
                    }
                }
                intent.putExtra("KSightPath", str4);
                intent.putExtra("KSightThumbPath", str5);
                intent.putExtra("sight_md5", bhK);
                AppMethodBeat.o(231571);
                return intent;
            case 39:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                String str6 = wXGameVideoFileObject.filePath;
                String str7 = wXGameVideoFileObject.videoUrl;
                String str8 = wXGameVideoFileObject.thumbUrl;
                Log.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", str6, "", str7, str8);
                String bhK2 = s.bhK(str6);
                if (Util.isNullOrNil("") || !s.YS("")) {
                    StringBuilder sb2 = new StringBuilder();
                    bg.aVF();
                    str3 = sb2.append(c.getAccSnsTmpPath()).append(bhK2).toString();
                    try {
                        Bitmap PF2 = PF(str6);
                        if (PF2 != null) {
                            Log.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(PF2.getWidth()), Integer.valueOf(PF2.getHeight()));
                            BitmapUtil.saveBitmapToImage(PF2, 80, Bitmap.CompressFormat.JPEG, str3, true);
                            BitmapFactory.Options imageOptions2 = BitmapUtil.getImageOptions(str3);
                            Log.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(imageOptions2.outWidth), Integer.valueOf(imageOptions2.outHeight));
                        } else {
                            Log.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", str6);
                            AppMethodBeat.o(231571);
                            return null;
                        }
                    } catch (Exception e3) {
                        Log.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e3.getMessage());
                    }
                } else {
                    str3 = "";
                }
                intent.putExtra("KSightPath", str6);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", bhK2);
                intent.putExtra("KSightCdnUrl", str7);
                intent.putExtra("KSightCdnThumbUrl", str8);
                AppMethodBeat.o(231571);
                return intent;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                String nullAs3 = Util.nullAs(((WXMusicVideoObject) iMediaObject).musicUrl, "");
                if (tN(76) == -1) {
                    Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
                    AppMethodBeat.o(231571);
                    return null;
                }
                intent.putExtra("Ksnsupload_link", nullAs3);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 25);
                intent.putExtra("ksnsis_music", true);
                if (bundle != null) {
                    intent.putExtra("music_mv_cover_url", bundle.getString("music_mv_cover_url", ""));
                }
                AppMethodBeat.o(231571);
                return intent;
            default:
                Log.e("MicroMsg.ShareSnsImpl", "none type not support!");
                AppMethodBeat.o(231571);
                return null;
        }
    }

    private static int tN(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 38:
                return 6;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                return 5;
            default:
                return -1;
        }
    }

    private static Bitmap PF(String str) {
        AppMethodBeat.i(20652);
        vq vqVar = new vq();
        vqVar.ebN.ebP = str;
        EventCenter.instance.publish(vqVar);
        Bitmap bitmap = (Bitmap) vqVar.ebO.result;
        AppMethodBeat.o(20652);
        return bitmap;
    }

    /* renamed from: com.tencent.mm.modelsns.a$a  reason: collision with other inner class name */
    public static class C0455a {
        public String jkP;
        public String jkQ;
        public String jkR;
        public int jkS = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoIFrameInterval = -1;
        public int videoWidth = -1;

        public static C0455a PG(String str) {
            String string;
            AppMethodBeat.i(20650);
            com.tencent.mm.compatible.i.c cVar = new com.tencent.mm.compatible.i.c();
            C0455a aVar = new C0455a();
            aVar.jkP = str;
            try {
                cVar.setDataSource(s.k(str, false));
                int trackCount = cVar.gLF.getTrackCount();
                MediaFormat mediaFormat = null;
                MediaFormat mediaFormat2 = null;
                for (int i2 = 0; i2 < trackCount; i2++) {
                    MediaFormat trackFormat = cVar.getTrackFormat(i2);
                    if (trackFormat.containsKey("mime")) {
                        String string2 = trackFormat.getString("mime");
                        Log.i("MicroMsg.ShareSnsImpl", "find video mime : %s", string2);
                        if (string2 != null) {
                            if (string2.startsWith("video/")) {
                                if (mediaFormat2 == null) {
                                    mediaFormat2 = trackFormat;
                                }
                            } else if (string2.startsWith("audio/") && mediaFormat == null) {
                                mediaFormat = trackFormat;
                            }
                            if (!(mediaFormat == null || mediaFormat2 == null)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Log.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
                    }
                }
                if (mediaFormat2 != null) {
                    aVar.jkS = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                    aVar.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                    aVar.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                    aVar.jkQ = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    aVar.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    aVar.videoIFrameInterval = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                    aVar.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                }
                if (mediaFormat != null) {
                    if (!mediaFormat.containsKey("mime")) {
                        string = "";
                    } else {
                        string = mediaFormat.getString("mime");
                    }
                    aVar.jkR = string;
                }
                cVar.gLF.release();
            } catch (Exception e2) {
                Log.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", str, e2.getMessage());
                cVar.gLF.release();
            } catch (Throwable th) {
                cVar.gLF.release();
                AppMethodBeat.o(20650);
                throw th;
            }
            AppMethodBeat.o(20650);
            return aVar;
        }
    }
}
