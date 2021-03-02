package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u0015J\u001a\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H\u0002J \u0010@\u001a\u00020A2\u0006\u00108\u001a\u0002092\u0006\u0010B\u001a\u0002072\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010C\u001a\u00020\u0012H\u0016J$\u0010D\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u0002092\b\b\u0002\u0010B\u001a\u000207H\u0002J\u0010\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020HH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "fakeImagesList", "", "blurBgPath", "validRect", "(ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FIILjava/util/ArrayList;Ljava/lang/String;[F)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getFakeImagesList", "setFakeImagesList", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "getValidRect", "setValidRect", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideoBySizeAndRotation", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "isLandVideoOnlyBySize", "setSize", "", "config", "toString", "videoConfigForFile", "videoPath", "videoConfigForPhotoToVideo", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "Companion", "EncodeConfig", "plugin-recordvideo_release"})
public final class f {
    public static final a BNs = new a((byte) 0);
    public float[] BKV;
    public float[] BKW;
    public String BLa;
    public boolean BNc;
    public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> BNn;
    public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> BNo;
    public int BNp;
    public int BNq;
    public ArrayList<String> BNr;
    public AudioCacheInfo wgG;

    static {
        AppMethodBeat.i(75378);
        AppMethodBeat.o(75378);
    }

    public f(boolean z, AudioCacheInfo audioCacheInfo, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList2, float[] fArr, int i2, int i3, ArrayList<String> arrayList3, String str, float[] fArr2) {
        p.h(arrayList, "editItems");
        p.h(arrayList2, "editData");
        p.h(fArr, "drawingRect");
        p.h(arrayList3, "fakeImagesList");
        p.h(fArr2, "validRect");
        AppMethodBeat.i(237255);
        this.BNc = z;
        this.wgG = audioCacheInfo;
        this.BNn = arrayList;
        this.BNo = arrayList2;
        this.BKV = fArr;
        this.BNp = i2;
        this.BNq = i3;
        this.BNr = arrayList3;
        this.BLa = str;
        this.BKW = fArr2;
        AppMethodBeat.o(237255);
    }

    public /* synthetic */ f(boolean z, AudioCacheInfo audioCacheInfo, ArrayList arrayList, ArrayList arrayList2, float[] fArr, ArrayList arrayList3, float[] fArr2) {
        this(z, audioCacheInfo, arrayList, arrayList2, fArr, 0, 0, arrayList3, null, fArr2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$Companion;", "", "()V", "TAG", "", "VIDEO_BITRATE_TOLERANT", "", "VIDEO_DURATION_TOLERANT_MS", "VIDEO_FPS_TOLERANT_RATIO", "", "VIDEO_LENGTH_TOLERANT", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final b a(RecordConfigProvider recordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        boolean z;
        VideoTransPara videoTransPara;
        AppMethodBeat.i(163420);
        if (recordConfigProvider == null || bVar == null) {
            Log.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
            b bVar2 = new b((byte) 0);
            AppMethodBeat.o(163420);
            return bVar2;
        }
        ArrayList<String> arrayList = bVar.iqm;
        if (arrayList == null || arrayList.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            VideoTransPara videoTransPara2 = recordConfigProvider.BOm;
            p.g(videoTransPara2, "configProvider.videoParam");
            b bVar3 = new b((byte) 0);
            e.BNm.eJv();
            e eVar = e.BNm;
            bVar3.targetWidth = e.getWidth();
            e eVar2 = e.BNm;
            bVar3.targetHeight = e.getHeight();
            e eVar3 = e.BNm;
            bVar3.frameRate = e.getFrameRate();
            float a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_imagevideo_bitrate_multiple, 2.0f);
            if (a2 <= 1.0f) {
                a2 = 1.0f;
            }
            bVar3.audioBitrate = videoTransPara2.audioBitrate;
            bVar3.audioSampleRate = videoTransPara2.audioSampleRate;
            bVar3.audioChannelCount = videoTransPara2.audioChannelCount;
            bVar3.videoBitrate = (int) (a2 * ((float) videoTransPara2.videoBitrate));
            bVar3.ihS = 0;
            bVar3.BNt = true;
            bVar3.BNu = true;
            AppMethodBeat.o(163420);
            return bVar3;
        }
        if (recordConfigProvider.BOm == null) {
            e baZ = e.baZ();
            p.g(baZ, "SubCoreVideoControl.getCore()");
            recordConfigProvider.BOm = baZ.bbc();
        }
        VideoTransPara videoTransPara3 = recordConfigProvider.BOm;
        if ((videoTransPara3 != null && videoTransPara3.iTg == 1) || ((videoTransPara = recordConfigProvider.BOm) != null && videoTransPara.iTg == 2)) {
            VideoTransPara videoTransPara4 = recordConfigProvider.BOm;
            if (videoTransPara4 != null) {
                VideoTransPara videoTransPara5 = recordConfigProvider.BOm;
                videoTransPara4.videoBitrate = (videoTransPara5 != null ? Integer.valueOf(videoTransPara5.iTp) : null).intValue();
            }
            StringBuilder sb = new StringBuilder("match aba switch, target videoBitrate:");
            VideoTransPara videoTransPara6 = recordConfigProvider.BOm;
            Log.i("MicroMsg.RemuxMediaEditConfig", sb.append(videoTransPara6 != null ? Integer.valueOf(videoTransPara6.videoBitrate) : null).toString());
        }
        if (!this.BNn.isEmpty() || this.wgG != null || this.BNc) {
            b bVar4 = new b((byte) 0);
            bVar4.BNt = true;
            bVar4.BNu = true;
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by add editItems " + this.BNn);
            b a3 = a(bVar.iqd, recordConfigProvider, bVar4);
            AppMethodBeat.o(163420);
            return a3;
        } else if (this.BNp - 80 >= 0 || this.BNq + 80 <= bVar.iqg) {
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + this.BNq + "  reMuxStartTimeMs:" + this.BNp);
            b bVar5 = new b((byte) 0);
            bVar5.BNt = true;
            bVar5.BNu = true;
            b a4 = a(bVar.iqd, recordConfigProvider, bVar5);
            AppMethodBeat.o(163420);
            return a4;
        } else {
            boolean isH265Video = r.isH265Video(bVar.iqd);
            Log.i("MicroMsg.RemuxMediaEditConfig", "generateTargetConfig, isH265File:".concat(String.valueOf(isH265Video)));
            if (isH265Video) {
                Log.i("MicroMsg.RemuxMediaEditConfig", "force remux h265 file");
                b bVar6 = new b((byte) 0);
                bVar6.BNt = true;
                b a5 = a(bVar.iqd, recordConfigProvider, bVar6);
                AppMethodBeat.o(163420);
                return a5;
            } else if (recordConfigProvider.remuxType != 2 || !this.BNn.isEmpty()) {
                b a6 = a(bVar.iqd, recordConfigProvider, new b((byte) 0));
                AppMethodBeat.o(163420);
                return a6;
            } else {
                b bVar7 = new b((byte) 0);
                AppMethodBeat.o(163420);
                return bVar7;
            }
        }
    }

    private static b a(String str, RecordConfigProvider recordConfigProvider, b bVar) {
        AppMethodBeat.i(75374);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(75374);
            return bVar;
        }
        d dVar = d.Cin;
        if (str == null) {
            p.hyc();
        }
        d.a aLQ = d.aLQ(str);
        if (aLQ != null) {
            bVar.audioBitrate = recordConfigProvider.BOm.audioBitrate;
            bVar.audioSampleRate = recordConfigProvider.BOm.audioSampleRate;
            bVar.videoBitrate = aLQ.videoBitrate;
            bVar.ihS = aLQ.dYT;
            bVar.audioChannelCount = recordConfigProvider.BOm.audioChannelCount;
            Log.d("MicroMsg.RemuxMediaEditConfig", "video info : ".concat(String.valueOf(aLQ)));
            if (aLQ.videoBitrate - 200000 > recordConfigProvider.BOm.videoBitrate) {
                bVar.videoBitrate = recordConfigProvider.BOm.videoBitrate;
                bVar.BNt = true;
                Log.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + aLQ.videoBitrate + "  " + recordConfigProvider.BOm.videoBitrate);
            }
            a(recordConfigProvider, bVar, aLQ);
            int i2 = aLQ.fps;
            if (((float) aLQ.fps) > ((float) recordConfigProvider.BOm.fps) * 1.5f && recordConfigProvider.BOm.fps >= 0) {
                i2 = recordConfigProvider.BOm.fps;
            }
            bVar.frameRate = i2;
        }
        bVar.videoBitrate = recordConfigProvider.BOm.videoBitrate;
        VideoTransPara videoTransPara = recordConfigProvider != null ? recordConfigProvider.BOm : null;
        if (videoTransPara != null && videoTransPara.iTh == 2) {
            bVar.idF = videoTransPara.idF;
            bVar.idG = videoTransPara.idG;
            bVar.iTh = videoTransPara.iTh;
            Log.i("MicroMsg.RemuxMediaEditConfig", "ABA: Min/Max QP Methods:videoBitrate [%d]  minQP [%d]  maxQP [%d]", Integer.valueOf(bVar.videoBitrate), Integer.valueOf(bVar.idF), Integer.valueOf(bVar.idG));
        }
        b eJw = bVar.eJw();
        AppMethodBeat.o(75374);
        return eJw;
    }

    private static void a(RecordConfigProvider recordConfigProvider, b bVar, d.a aVar) {
        int i2;
        int i3;
        AppMethodBeat.i(163421);
        int i4 = recordConfigProvider.BOm.width;
        int i5 = recordConfigProvider.BOm.height;
        boolean a2 = a(aVar);
        if (a2) {
            i2 = i4;
            i3 = i5;
        } else {
            i2 = i5;
            i3 = i4;
        }
        if (recordConfigProvider.BOp == 1) {
            Point az = ao.az(MMApplicationContext.getContext());
            int i6 = az.y;
            recordConfigProvider.BOm.height = (i6 * recordConfigProvider.BOm.width) / az.x;
            int i7 = aVar.width - 32;
            int i8 = aVar.height - 32;
            if (i7 > i3 || i8 > i2) {
                bVar.targetWidth = i3;
                bVar.targetHeight = i2;
                bVar.BNt = true;
                Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + aVar.width + "  " + bVar.targetWidth);
            } else {
                bVar.targetHeight = aVar.height;
                bVar.targetWidth = aVar.width;
            }
        } else if (recordConfigProvider.BOp == 2) {
            int i9 = aVar.width;
            int i10 = aVar.height;
            if (!(i9 == i3 && i10 == i2)) {
                bVar.BNt = true;
                Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
            }
            bVar.targetWidth = i3;
            bVar.targetHeight = i2;
        } else if (recordConfigProvider.BOp == 4) {
            int i11 = aVar.width - 32;
            int i12 = aVar.height - 32;
            bVar.targetHeight = aVar.height;
            bVar.targetWidth = aVar.width;
            if (a2) {
                if (i12 > i2) {
                    bVar.targetHeight = i2;
                    bVar.targetWidth = (i2 * i11) / i12;
                    bVar.BNt = true;
                    Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
                }
            } else if (i11 > i3) {
                bVar.targetWidth = i3;
                bVar.targetHeight = (i3 * i12) / i11;
                bVar.BNt = true;
                Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
        } else if (recordConfigProvider.BOp == 3) {
            bVar.targetWidth = aVar.width;
            bVar.targetHeight = aVar.height;
        }
        if (recordConfigProvider.BOH && b(aVar)) {
            bVar.targetWidth = Math.min(recordConfigProvider.BOm.width, recordConfigProvider.BOm.height);
            bVar.targetHeight = Math.max(recordConfigProvider.BOm.width, recordConfigProvider.BOm.height);
        }
        AppMethodBeat.o(163421);
    }

    private static boolean b(d.a aVar) {
        return (aVar.dYT == 90 || aVar.dYT == 270) ? aVar.height > aVar.width : aVar.width > aVar.height;
    }

    public final String toString() {
        AppMethodBeat.i(75375);
        String str = "RemuxMediaEditConfig(muteOrigin=" + this.BNc + ", audioCacheInfo=" + this.wgG + ", editItems=" + this.BNn + ", drawingRect=" + Arrays.toString(this.BKV) + ", reMuxStartTimeMs=" + this.BNp + ", reMuxEndTimeMs=" + this.BNq + ')';
        AppMethodBeat.o(75375);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u0006\u00100\u001a\u00020\u0000J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\b\u0010B\u001a\u00020CH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "minQP", "maxQP", "qpSwitch", "(IIIIIIIIZZIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getMaxQP", "setMaxQP", "getMinQP", "setMinQP", "getNeedRemux", "setNeedRemux", "getQpSwitch", "setQpSwitch", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-recordvideo_release"})
    public static final class b {
        public boolean BNt;
        public boolean BNu;
        public int audioBitrate;
        public int audioChannelCount;
        public int audioSampleRate;
        public int frameRate;
        public int iTh;
        public int idF;
        public int idG;
        public int ihS;
        public int targetHeight;
        public int targetWidth;
        public int videoBitrate;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.targetWidth == bVar.targetWidth && this.targetHeight == bVar.targetHeight && this.videoBitrate == bVar.videoBitrate && this.audioBitrate == bVar.audioBitrate && this.frameRate == bVar.frameRate && this.ihS == bVar.ihS && this.audioSampleRate == bVar.audioSampleRate && this.audioChannelCount == bVar.audioChannelCount && this.BNt == bVar.BNt && this.BNu == bVar.BNu && this.idF == bVar.idF && this.idG == bVar.idG && this.iTh == bVar.iTh)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            int i3 = ((((((((((((((this.targetWidth * 31) + this.targetHeight) * 31) + this.videoBitrate) * 31) + this.audioBitrate) * 31) + this.frameRate) * 31) + this.ihS) * 31) + this.audioSampleRate) * 31) + this.audioChannelCount) * 31;
            boolean z = this.BNt;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i4 + i3) * 31;
            boolean z2 = this.BNu;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return ((((((i7 + i2) * 31) + this.idF) * 31) + this.idG) * 31) + this.iTh;
        }

        private b() {
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.videoBitrate = 0;
            this.audioBitrate = 0;
            this.frameRate = 0;
            this.ihS = 0;
            this.audioSampleRate = 0;
            this.audioChannelCount = 1;
            this.BNt = false;
            this.BNu = false;
            this.idF = 0;
            this.idG = 0;
            this.iTh = 0;
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public final b eJw() {
            AppMethodBeat.i(163419);
            if (this.targetWidth % 16 != 0) {
                this.targetWidth = com.tencent.mm.plugin.mmsight.d.QH(this.targetWidth);
            }
            if (this.targetHeight % 16 != 0) {
                this.targetHeight = com.tencent.mm.plugin.mmsight.d.QH(this.targetHeight);
            }
            AppMethodBeat.o(163419);
            return this;
        }

        public final String toString() {
            AppMethodBeat.i(75373);
            String str = "EncodeConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", needRemux=" + this.BNt + ", change=" + this.BNu + ", qpmin=" + this.idF + ", qpmax=" + this.idG + ')';
            AppMethodBeat.o(75373);
            return str;
        }
    }

    private static boolean a(d.a aVar) {
        return aVar.width > aVar.height;
    }
}
