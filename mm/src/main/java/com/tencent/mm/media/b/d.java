package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020\u0003J\b\u0010<\u001a\u00020%H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0004R\u001a\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\u001c\u0010-\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u00100\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR\u001a\u00103\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\b\"\u0004\b5\u0010\nR\u001a\u00106\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0004¨\u0006>"}, hxF = {"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configToFormat", "Landroid/media/MediaFormat;", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"})
public final class d extends a {
    public static final a idI = new a((byte) 0);
    public int bitrate;
    private int colorFormat;
    public int frameRate;
    public int idB;
    public boolean idC;
    public boolean idD;
    private boolean idE;
    public int idF;
    public int idG;
    private MediaCodecInfo idH;
    public String mimeType;
    public String name;
    public int targetHeight;
    public int targetWidth;

    static {
        AppMethodBeat.i(93521);
        AppMethodBeat.o(93521);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/config/VideoCodecConfig$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ d() {
        this(false);
    }

    public d(boolean z) {
        AppMethodBeat.i(93520);
        this.colorFormat = EncoderWriter.OUTPUT_VIDEO_COLOR_FORMAT;
        this.idB = 1;
        this.mimeType = "video/avc";
        Log.i("MicroMsg.VideoCodecConfig", "init, enableHevc:".concat(String.valueOf(z)));
        if (z) {
            this.idH = selectCodec(TPDecoderType.TP_CODEC_MIMETYPE_HEVC);
            if (this.idH == null) {
                Log.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
                this.idH = selectCodec("video/avc");
                this.mimeType = "video/avc";
                h.INSTANCE.n(1280, 61, 1);
            } else {
                StringBuilder sb = new StringBuilder("success select hevc codec:");
                MediaCodecInfo mediaCodecInfo = this.idH;
                Log.i("MicroMsg.VideoCodecConfig", sb.append(mediaCodecInfo != null ? mediaCodecInfo.getName() : null).toString());
                this.mimeType = TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
                h.INSTANCE.n(1280, 60, 1);
            }
        } else {
            this.idH = selectCodec("video/avc");
            this.mimeType = "video/avc";
        }
        if (this.idH == null) {
            h.INSTANCE.n(1047, 0, 1);
            this.idC = true;
            AppMethodBeat.o(93520);
            return;
        }
        MediaCodecInfo mediaCodecInfo2 = this.idH;
        if (mediaCodecInfo2 == null) {
            p.hyc();
        }
        this.name = mediaCodecInfo2.getName();
        this.idB = ((b) g.af(b.class)).a(b.a.clicfg_media_iframe, 1);
        Log.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.idB);
        AppMethodBeat.o(93520);
    }

    public final MediaFormat aLU() {
        MultiProcessMMKV mmkv;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        AppMethodBeat.i(93518);
        Log.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.targetWidth + ", targetHeight:" + this.targetHeight + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.colorFormat + ", iFrameInterval:" + this.idB + ", value: minQP:" + this.idF + ", maxQP:" + this.idG);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mimeType, this.targetWidth, this.targetHeight);
        MediaCodecInfo mediaCodecInfo = this.idH;
        if (mediaCodecInfo == null) {
            p.hyc();
        }
        p.g(createVideoFormat, "mediaFormat");
        a(mediaCodecInfo, createVideoFormat, this.mimeType);
        MediaCodecInfo mediaCodecInfo2 = this.idH;
        if (mediaCodecInfo2 == null) {
            p.hyc();
        }
        String str = this.mimeType;
        p.h(mediaCodecInfo2, "codecInfo");
        p.h(createVideoFormat, "mediaFormat");
        p.h(str, "mimeType");
        try {
            if (!(!com.tencent.mm.compatible.util.d.oD(21) || (capabilitiesForType = mediaCodecInfo2.getCapabilitiesForType(str)) == null || (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) == null)) {
                if (encoderCapabilities.isBitrateModeSupported(1)) {
                    Log.i("MicroMsg.VideoCodecConfig", "support vbr bitrate mode");
                    createVideoFormat.setInteger("bitrate-mode", 1);
                } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                    Log.i("MicroMsg.VideoCodecConfig", "support cbr bitrate mode");
                    createVideoFormat.setInteger("bitrate-mode", 2);
                } else {
                    Log.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", e2.getMessage());
        }
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        createVideoFormat.setInteger("frame-rate", this.frameRate);
        createVideoFormat.setInteger("color-format", this.colorFormat);
        createVideoFormat.setInteger("i-frame-interval", this.idB);
        if (this.idD) {
            Log.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", createVideoFormat.toString());
            createVideoFormat.setInteger("bitrate-mode", 0);
        }
        if (!(this.idF == 0 || this.idG == 0 || (mmkv = MultiProcessMMKV.getMMKV("HardcoderQP")) == null)) {
            String decodeString = mmkv.decodeString("HCMinQPKey", null);
            String decodeString2 = mmkv.decodeString("HCMaxQPKey", null);
            if (!(decodeString == null || decodeString2 == null)) {
                createVideoFormat.setInteger(decodeString2, this.idG);
                createVideoFormat.setInteger(decodeString, this.idF);
                this.idE = true;
                Log.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + decodeString + ", max:" + decodeString2 + ", value: minQP:" + this.idF + ", maxQP:" + this.idG);
            }
        }
        Log.i("MicroMsg.VideoCodecConfig", "mediaFormat: %s", createVideoFormat);
        AppMethodBeat.o(93518);
        return createVideoFormat;
    }

    public final String toString() {
        AppMethodBeat.i(93519);
        String str = "VideoCodecConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.colorFormat + ", iFrameInterval=" + this.idB + ", name=" + this.name + ", initError=" + this.idC + ", forceCQ=" + this.idD + ", codecInfo=" + this.idH + ')';
        AppMethodBeat.o(93519);
        return str;
    }
}
