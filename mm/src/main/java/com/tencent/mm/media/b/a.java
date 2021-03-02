package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "STRING_SPILT", "", "supportedHardcodeEncoder", "", "[Ljava/lang/String;", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", Scopes.PROFILE, "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"})
public class a {
    public static final C0411a idw = new C0411a((byte) 0);
    private final String idu = ";";
    private String[] idv = {"OMX.oppo.h264.encoder"};

    static {
        AppMethodBeat.i(93516);
        AppMethodBeat.o(93516);
    }

    public a() {
        boolean z;
        AppMethodBeat.i(93515);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_supported_hardcode_encoder, "");
        p.g(a2, "supportedHardcodeEncoderList");
        Object[] array = n.b(a2, new String[]{this.idu}).toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(93515);
            throw tVar;
        }
        this.idv = (String[]) array;
        Log.i("MicroMsg.VideoCodecConfig", "supportedHardcodeEncoderList : " + a2 + "  supportedHardcodeEncoder size:" + this.idv.length);
        if (this.idv.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            b bVar = b.idz;
            b.eT(false);
        }
        AppMethodBeat.o(93515);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/config/BaseCodecConfig$Companion;", "", "()V", "AVC_MIME_TYPE", "", "HEVC_MIME_TYPE", "TAG", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.b.a$a  reason: collision with other inner class name */
    public static final class C0411a {
        private C0411a() {
        }

        public /* synthetic */ C0411a(byte b2) {
            this();
        }
    }

    public final MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.i(93513);
        p.h(str, "mimeType");
        int codecCount = MediaCodecList.getCodecCount();
        Log.i("MicroMsg.VideoCodecConfig", "numCodec:".concat(String.valueOf(codecCount)));
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            p.g(codecInfoAt, "codecInfo");
            if (codecInfoAt.isEncoder()) {
                Log.i("MicroMsg.VideoCodecConfig", "config to use supportedHardcodeEncoder:" + Arrays.toString(this.idv));
                String[] strArr = this.idv;
                for (String str2 : strArr) {
                    if (codecInfoAt != null && n.I(codecInfoAt.getName(), str2, true)) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        p.g(supportedTypes, "types");
                        int length = supportedTypes.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            Log.i("MicroMsg.VideoCodecConfig", "hardcodeEncoder: " + codecInfoAt.getName() + "  type:" + supportedTypes[i3]);
                            if (n.I(supportedTypes[i3], str, true)) {
                                b bVar = b.idz;
                                b.eT(true);
                                AppMethodBeat.o(93513);
                                return codecInfoAt;
                            }
                        }
                        Log.i("MicroMsg.VideoCodecConfig", "selectCodec from hardcodeEncoder " + this.idv + ": " + codecInfoAt.getName());
                    }
                }
                continue;
            }
        }
        for (int i4 = 0; i4 < codecCount; i4++) {
            MediaCodecInfo codecInfoAt2 = MediaCodecList.getCodecInfoAt(i4);
            p.g(codecInfoAt2, "codecInfo");
            if (codecInfoAt2.isEncoder()) {
                String[] supportedTypes2 = codecInfoAt2.getSupportedTypes();
                p.g(supportedTypes2, "types");
                int length2 = supportedTypes2.length;
                for (int i5 = 0; i5 < length2; i5++) {
                    Log.i("MicroMsg.VideoCodecConfig", "selectCodec:  " + codecCount + "  type: " + supportedTypes2[i5]);
                    if (n.I(supportedTypes2[i5], str, true)) {
                        AppMethodBeat.o(93513);
                        return codecInfoAt2;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(93513);
        return null;
    }

    public static void a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, String str) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z;
        AppMethodBeat.i(93514);
        p.h(mediaCodecInfo, "codecInfo");
        p.h(mediaFormat, "mediaFormat");
        p.h(str, "mimeType");
        if (d.oD(23)) {
            try {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                if (!(capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null)) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.level = 0;
                    codecProfileLevel.profile = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                        int i2 = codecProfileLevel2.profile;
                        int i3 = codecProfileLevel2.level;
                        Log.i("MicroMsg.VideoCodecConfig", "profile: %s, level: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                        switch (i2) {
                            case 1:
                            case 2:
                            case 8:
                                z = true;
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z && i2 >= codecProfileLevel.profile && i3 >= codecProfileLevel.level) {
                            codecProfileLevel.profile = i2;
                            codecProfileLevel.level = i3;
                        }
                    }
                    Log.i("MicroMsg.VideoCodecConfig", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        mediaFormat.setInteger("level", codecProfileLevel.level);
                        AppMethodBeat.o(93514);
                        return;
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoCodecConfig", "trySetProfile error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(93514);
    }
}
