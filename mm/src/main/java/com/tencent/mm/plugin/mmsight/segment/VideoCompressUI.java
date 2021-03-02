package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bk.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private static int gsi;
    private d gVN = new d(this);
    private VideoTransPara jtV;
    private String thumbPath;
    private String videoPath;
    private ProgressDialog zzG;
    private int[] zzH = new int[34];
    private a zzI = new a(this, (byte) 0);
    private boolean zzJ;
    private Runnable zzK = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.AnonymousClass2 */

        public final void run() {
            Point point;
            int i2;
            int i3;
            AppMethodBeat.i(107699);
            try {
                VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.this.videoPath);
                Intent intent = new Intent();
                Point F = VideoCompressUI.F(VideoCompressUI.this.zzI.videoWidth, VideoCompressUI.this.zzI.videoHeight, VideoCompressUI.this.jtV.width, VideoCompressUI.this.jtV.height);
                boolean z = false;
                String mP4CprtH = SightVideoJNI.getMP4CprtH(VideoCompressUI.this.videoPath);
                if (mP4CprtH != null) {
                    Log.i("MicroMsg.VideoCompressUI", "ABA: the metadata flag of video is : %s", mP4CprtH);
                    if (mP4CprtH.length() >= 17 && mP4CprtH.substring(0, 17).equals("AdaptiveBitrateUP") && !VideoCompressUI.this.zzJ) {
                        z = true;
                    }
                }
                if ((VideoCompressUI.b(VideoCompressUI.this, VideoCompressUI.this.jtV) || F != null) && !z) {
                    if (F == null) {
                        point = new Point(VideoCompressUI.this.zzI.videoWidth, VideoCompressUI.this.zzI.videoHeight);
                    } else {
                        point = F;
                    }
                    String unused = VideoCompressUI.this.videoPath;
                    String ekD = VideoCompressUI.ekD();
                    if (VideoCompressUI.this.jtV.iTg == 2) {
                        VideoCompressUI.this.zzH = AdaptiveAdjustBitrate.a(VideoCompressUI.this.videoPath, point.y, point.x, VideoCompressUI.this.jtV.fps, VideoCompressUI.this.jtV.videoBitrate, 0.0f, 0.0f, 2, VideoCompressUI.this.jtV.iTi, VideoCompressUI.this.jtV.iTj, VideoCompressUI.this.jtV.iTk, VideoCompressUI.this.jtV.iTl, VideoCompressUI.this.jtV.iTm, VideoCompressUI.this.jtV.iTn, VideoCompressUI.this.jtV.iTo, false);
                        VideoCompressUI.this.jtV.videoBitrate = VideoCompressUI.this.zzH[0] * 1000;
                        point.x = VideoCompressUI.this.zzH[1];
                        point.y = VideoCompressUI.this.zzH[2];
                        Log.i("MicroMsg.VideoCompressUI", "ABA: VideoCompressUI Send directly: [%d], [%d], [%d] ", Integer.valueOf(VideoCompressUI.this.jtV.videoBitrate), Integer.valueOf(point.x), Integer.valueOf(point.y));
                    }
                    if (VideoCompressUI.this.jtV.iTh == 1 || VideoCompressUI.this.jtV.iTh == 2) {
                        Log.i("MicroMsg.VideoCompressUI", "ABA: Using Min Max QP Limitation: [%d], [%d] ", Integer.valueOf(VideoCompressUI.this.jtV.idF), Integer.valueOf(VideoCompressUI.this.jtV.idG));
                        i3 = VideoCompressUI.this.jtV.idF;
                        i2 = VideoCompressUI.this.jtV.idG;
                    } else {
                        i3 = 0;
                        i2 = 51;
                    }
                    boolean z2 = VideoCompressUI.this.zzI.videoWidth >= 2000 || VideoCompressUI.this.zzI.videoHeight >= 2000;
                    Log.i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", Integer.valueOf(VideoCompressUI.this.zzI.videoWidth), Integer.valueOf(VideoCompressUI.this.zzI.videoHeight), point, VideoCompressUI.this.videoPath, ekD, Boolean.valueOf(VideoCompressUI.this.zzJ), Boolean.valueOf(z2));
                    int unused2 = VideoCompressUI.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, CommonUtils.MAX_TIMEOUT_MS, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI");
                    Log.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(VideoCompressUI.gsi));
                    if (VideoCompressUI.this.zzJ || z2) {
                        Log.i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
                        VideoCompressUI.this.jtV.width = point.x;
                        VideoCompressUI.this.jtV.height = point.y;
                        e.a(VideoCompressUI.this.videoPath, ekD, VideoCompressUI.this.jtV);
                    } else {
                        SightVideoJNI.remuxingVFS(VideoCompressUI.this.videoPath, ekD, point.x, point.y, VideoCompressUI.this.jtV.videoBitrate, VideoCompressUI.this.jtV.iSV, 8, VideoCompressUI.this.jtV.iSU, 25.0f, (float) VideoCompressUI.this.jtV.fps, null, 0, false, i3, i2);
                    }
                    if (VideoCompressUI.gsi != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.gsi);
                        Log.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", Integer.valueOf(VideoCompressUI.gsi));
                        int unused3 = VideoCompressUI.gsi = 0;
                    }
                    if (VideoCompressUI.this.jtV.iTh > 0) {
                        SightVideoJNI.addReportMetadata(ekD, VideoCompressUI.this.zzH, 0, VideoCompressUI.this.jtV.iTh);
                    } else if (VideoCompressUI.this.jtV.iTg == 2) {
                        SightVideoJNI.addReportMetadata(ekD, VideoCompressUI.this.zzH, VideoCompressUI.this.jtV.iTg, 0);
                    }
                    intent.putExtra("K_SEGMENTVIDEOPATH", ekD);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, ekD, null));
                } else {
                    Log.i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
                    intent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.this.videoPath);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.this.videoPath, VideoCompressUI.this.thumbPath));
                }
                VideoCompressUI.this.setResult(-1, intent);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoCompressUI", e2, "video compress failed e [%s]", e2.getMessage());
            } finally {
                VideoCompressUI.this.finish();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107698);
                        if (VideoCompressUI.this.zzG != null) {
                            VideoCompressUI.this.zzG.dismiss();
                        }
                        AppMethodBeat.o(107698);
                    }
                });
                AppMethodBeat.o(107699);
            }
        }
    };

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoCompressUI() {
        AppMethodBeat.i(107701);
        AppMethodBeat.o(107701);
    }

    static /* synthetic */ String a(VideoCompressUI videoCompressUI, String str, String str2) {
        AppMethodBeat.i(107709);
        String iK = videoCompressUI.iK(str, str2);
        AppMethodBeat.o(107709);
        return iK;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107702);
        super.onCreate(bundle);
        setContentView(R.layout.hl);
        Intent intent = getIntent();
        if (intent == null || Util.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            AppMethodBeat.o(107702);
            return;
        }
        this.zzG = h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        this.videoPath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.thumbPath = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(107697);
                VideoCompressUI.this.jtV = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
                if (VideoCompressUI.this.jtV == null) {
                    Log.e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
                    VideoCompressUI.this.setResult(0);
                    VideoCompressUI.this.finish();
                    AppMethodBeat.o(107697);
                    return;
                }
                ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                ThreadPool.post(VideoCompressUI.this.zzK, "video_remuxing_if_needed");
                AppMethodBeat.o(107697);
            }
        });
        AppMethodBeat.o(107702);
    }

    private String iK(String str, String str2) {
        Exception e2;
        AppMethodBeat.i(107703);
        if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(107703);
        } else {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
                a.C0304a j2 = com.tencent.mm.compatible.i.a.j(this, intent);
                if (!(j2 == null || j2.bitmap == null)) {
                    String str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmpThumb/";
                    if (s.YS(str3)) {
                        s.dy(str3, true);
                    }
                    s.boN(str3);
                    String str4 = str3 + "video_send_preprocess_thumb_" + System.currentTimeMillis() + ".jpg";
                    Log.i("MicroMsg.VideoCompressUI", "thumbPath: %s", str4);
                    try {
                        BitmapUtil.saveBitmapToImage(j2.bitmap, 80, Bitmap.CompressFormat.JPEG, str4, true);
                        str2 = str4;
                    } catch (Exception e3) {
                        e2 = e3;
                        str2 = str4;
                        Log.printErrStackTrace("MicroMsg.VideoCompressUI", e2, "get thumb error: %s", e2.getMessage());
                        AppMethodBeat.o(107703);
                        return str2;
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                Log.printErrStackTrace("MicroMsg.VideoCompressUI", e2, "get thumb error: %s", e2.getMessage());
                AppMethodBeat.o(107703);
                return str2;
            }
            AppMethodBeat.o(107703);
        }
        return str2;
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(107704);
        super.onDestroy();
        if (this.gVN != null) {
            this.gVN.release();
        }
        AppMethodBeat.o(107704);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public int audioBitRate;
        public String jkQ;
        public String jkR;
        public int jkS;
        public int videoBitRate;
        public int videoFrameRate;
        public int videoHeight;
        public int videoIFrameInterval;
        public int videoWidth;

        private a() {
            this.jkS = -1;
            this.videoHeight = -1;
            this.videoWidth = -1;
            this.videoBitRate = -1;
            this.videoIFrameInterval = -1;
            this.videoFrameRate = -1;
            this.audioBitRate = -1;
        }

        /* synthetic */ a(VideoCompressUI videoCompressUI, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(107700);
            String str = "VideoAnalysisStruct{videoTrackMime='" + this.jkQ + '\'' + ", audioTrackMime='" + this.jkR + '\'' + ", durationMs=" + this.jkS + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.videoIFrameInterval + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
            AppMethodBeat.o(107700);
            return str;
        }
    }

    static /* synthetic */ void a(VideoCompressUI videoCompressUI, String str) {
        com.tencent.mm.plugin.sight.base.a aNx;
        String string;
        AppMethodBeat.i(107705);
        c cVar = new c();
        try {
            cVar.setDataSource(str);
            int trackCount = cVar.gLF.getTrackCount();
            MediaFormat mediaFormat = null;
            MediaFormat mediaFormat2 = null;
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = cVar.getTrackFormat(i2);
                if (trackFormat.containsKey("mime")) {
                    String string2 = trackFormat.getString("mime");
                    Log.i("MicroMsg.VideoCompressUI", "find video mime : %s", string2);
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
                }
            }
            if (videoCompressUI.zzI != null && videoCompressUI.zzI.jkS == -1) {
                if (mediaFormat2 != null) {
                    videoCompressUI.zzI.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    videoCompressUI.zzI.jkS = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                    videoCompressUI.zzI.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                    videoCompressUI.zzI.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                    videoCompressUI.zzI.jkQ = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    videoCompressUI.zzI.videoIFrameInterval = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                    videoCompressUI.zzI.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                    if (!Util.isNullOrNil(videoCompressUI.zzI.jkQ) && videoCompressUI.zzI.jkQ.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                        videoCompressUI.zzJ = true;
                    }
                }
                if (mediaFormat != null) {
                    videoCompressUI.zzI.audioBitRate = !mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    a aVar = videoCompressUI.zzI;
                    if (!mediaFormat.containsKey("mime")) {
                        string = "";
                    } else {
                        string = mediaFormat.getString("mime");
                    }
                    aVar.jkR = string;
                }
                if ((videoCompressUI.zzI.videoBitRate <= 0 || videoCompressUI.zzI.videoHeight <= 0 || videoCompressUI.zzI.videoWidth <= 0 || videoCompressUI.zzI.jkS <= 0) && (aNx = com.tencent.mm.plugin.sight.base.e.aNx(str)) != null) {
                    if (aNx.videoBitrate > 0) {
                        videoCompressUI.zzI.videoBitRate = aNx.videoBitrate;
                    }
                    if (aNx.height > 0) {
                        videoCompressUI.zzI.videoHeight = aNx.height;
                    }
                    if (aNx.width > 0) {
                        videoCompressUI.zzI.videoWidth = aNx.width;
                    }
                    if (aNx.videoDuration > 0) {
                        videoCompressUI.zzI.jkS = aNx.videoDuration;
                    }
                }
                Log.i("MicroMsg.VideoCompressUI", "videoAnalysis result: %s", videoCompressUI.zzI);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.VideoCompressUI", "Video extractor init failed. video path = [%s] e = [%s]", str, e2.getMessage());
        } finally {
            cVar.gLF.release();
            AppMethodBeat.o(107705);
        }
    }

    static /* synthetic */ Point F(int i2, int i3, int i4, int i5) {
        int min;
        int i6;
        AppMethodBeat.i(107706);
        if (i2 > i3 && i4 < i5) {
            int max = Math.max(i4, i5);
            i5 = Math.min(i4, i5);
            i4 = max;
        }
        Log.i("MicroMsg.VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i2 + "], decoderOutputHeight = [" + i3 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
        if (i2 > i4 || i3 > i5) {
            int max2 = Math.max(i2, i3);
            int min2 = Math.min(i2, i3);
            int max3 = Math.max(i4, i5);
            int min3 = Math.min(i4, i5);
            if (max2 % 16 != 0 || Math.abs(max2 - max3) >= 16 || min2 % 16 != 0 || Math.abs(min2 - min3) >= 16) {
                int i7 = max2 / 2;
                int i8 = min2 / 2;
                if (i7 % 16 != 0 || Math.abs(i7 - max3) >= 16 || i8 % 16 != 0 || Math.abs(i8 - min3) >= 16) {
                    Point point = new Point();
                    if (i2 < i3) {
                        i6 = Math.min(i4, i5);
                        min = (int) (((double) i3) / ((((double) i2) * 1.0d) / ((double) i6)));
                    } else {
                        min = Math.min(i4, i5);
                        i6 = (int) (((double) i2) / ((((double) i3) * 1.0d) / ((double) min)));
                    }
                    if (min % 2 != 0) {
                        min++;
                    }
                    if (i6 % 2 != 0) {
                        i6++;
                    }
                    Log.i("MicroMsg.VideoCompressUI", "calc scale, outputsize: %s %s", Integer.valueOf(i6), Integer.valueOf(min));
                    point.x = i6;
                    point.y = min;
                    AppMethodBeat.o(107706);
                    return point;
                }
                Log.i("MicroMsg.VideoCompressUI", "calc scale, double ratio divide by 16");
                int i9 = i2 / 2;
                int i10 = i3 / 2;
                if (i9 % 2 != 0) {
                    i9++;
                }
                if (i10 % 2 != 0) {
                    i10++;
                }
                Point point2 = new Point(i9, i10);
                AppMethodBeat.o(107706);
                return point2;
            }
            Log.i("MicroMsg.VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            AppMethodBeat.o(107706);
            return null;
        }
        Log.i("MicroMsg.VideoCompressUI", "calc scale, small or equal to spec size");
        AppMethodBeat.o(107706);
        return null;
    }

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(107707);
        if (videoTransPara == null) {
            Log.e("MicroMsg.VideoCompressUI", "hy: given target trans param is null");
            z = false;
        } else if (videoTransPara.videoBitrate < videoCompressUI.zzI.videoBitRate) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            z3 = true;
        }
        if (!videoCompressUI.zzJ) {
            z2 = z3;
        }
        AppMethodBeat.o(107707);
        return z2;
    }

    static /* synthetic */ String ekD() {
        AppMethodBeat.i(107708);
        String str = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmp/";
        if (s.YS(str)) {
            s.dy(str, true);
        }
        s.boN(str);
        String str2 = str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4";
        Log.i("MicroMsg.VideoCompressUI", "initAndGetTmpPath: %s", str2);
        AppMethodBeat.o(107708);
        return str2;
    }
}
