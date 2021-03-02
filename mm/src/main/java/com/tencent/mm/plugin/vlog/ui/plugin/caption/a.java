package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.a.j;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J*\u0010'\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u0006\u0010.\u001a\u00020\u0005J\b\u0010/\u001a\u00020\u0010H\u0002J,\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020\u0010J\b\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0001\u00109\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\t2t\u0010\u0003\u001ap\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012'\u0012%\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0004R~\u0010\u0003\u001ar\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012'\u0012%\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", Scopes.PROFILE, "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"})
public final class a implements i {
    private static long GJV;
    public static final C1862a GJW = new C1862a((byte) 0);
    String filePath = "";
    r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> hFV;
    volatile boolean ife;
    c igg;
    private int jcu;
    private int profile = 2;
    private int sampleRate = 44100;
    boolean tUq;
    private boolean wJA;
    boolean wJB = true;
    int wJC;
    private int wJD = 1;
    private e wJx;
    ArrayList<sy> wJy = new ArrayList<>();
    private ByteBuffer wJz;

    static {
        AppMethodBeat.i(191605);
        AppMethodBeat.o(191605);
    }

    public a() {
        AppMethodBeat.i(191604);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3835, this);
        AppMethodBeat.o(191604);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager$Companion;", "", "()V", "BASE_CAPTION_ID", "", "CAPTION_EXTRACTOR_ERROR", "", "CAPTION_NO_AUDIO", "CAPTION_RESULT_ERROR", "CAPTION_RESULT_LOAD_MORE", "CAPTION_RESULT_OK", "DefaultAudioBitrate", "REQUEST_VOICE_SIZE", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.a$a  reason: collision with other inner class name */
    public static final class C1862a {
        private C1862a() {
        }

        public /* synthetic */ C1862a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final int axp(String str) {
        MediaFormat mediaFormat;
        long j2;
        long j3;
        int i2;
        Integer num;
        MediaFormat mediaFormat2;
        String str2;
        AppMethodBeat.i(191601);
        try {
            if (this.igg == null) {
                this.igg = new c();
                c cVar = this.igg;
                if (cVar != null) {
                    cVar.setDataSource(str);
                }
                c cVar2 = this.igg;
                int trackCount = cVar2 != null ? cVar2.getTrackCount() : 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        mediaFormat = null;
                        break;
                    }
                    c cVar3 = this.igg;
                    if (cVar3 != null) {
                        mediaFormat2 = cVar3.getTrackFormat(i3);
                    } else {
                        mediaFormat2 = null;
                    }
                    if (mediaFormat2 != null) {
                        str2 = mediaFormat2.getString("mime");
                    } else {
                        str2 = null;
                    }
                    Log.i("MicroMsg.EditCaptionDataManager", "track mime:".concat(String.valueOf(str2)));
                    if (TextUtils.isEmpty(str2) || str2 == null || !n.J(str2, "audio/", false)) {
                        i3++;
                    } else {
                        c cVar4 = this.igg;
                        if (cVar4 != null) {
                            cVar4.selectTrack(i3);
                            mediaFormat = mediaFormat2;
                        } else {
                            mediaFormat = mediaFormat2;
                        }
                    }
                }
                if (mediaFormat == null) {
                    Log.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
                    c cVar5 = this.igg;
                    if (cVar5 != null) {
                        cVar5.release();
                    }
                    this.igg = null;
                    this.wJC = -2;
                    AppMethodBeat.o(191601);
                    return -2;
                }
                MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(str);
                Log.i("MicroMsg.EditCaptionDataManager", "audio format:" + mediaFormat + ", videoInfo:" + aTV);
                if (aTV != null) {
                    j2 = aTV.duration;
                } else {
                    j2 = 0;
                }
                long j4 = j2 * 1000;
                p.h(mediaFormat, "$this$getLong");
                p.h("durationUs", "name");
                if (mediaFormat.containsKey("durationUs")) {
                    j3 = mediaFormat.getLong("durationUs");
                } else {
                    j3 = j4;
                }
                if (aTV != null) {
                    i2 = aTV.audioBitrate;
                } else {
                    i2 = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
                }
                int c2 = u.c(mediaFormat, FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i2);
                this.profile = u.c(mediaFormat, Scopes.PROFILE, this.profile);
                this.sampleRate = u.c(mediaFormat, "sample-rate", this.sampleRate);
                this.wJD = u.c(mediaFormat, "channel-count", this.wJD);
                float f2 = 2.0f * ((((float) c2) * ((((float) j3) / 1000.0f) / 1000.0f)) / 8.0f);
                float f3 = ((((float) j3) / 1000.0f) / 20.0f) * 7.0f;
                this.wJz = ByteBuffer.allocateDirect((int) (f2 + f3));
                StringBuilder append = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
                ByteBuffer byteBuffer = this.wJz;
                if (byteBuffer != null) {
                    num = Integer.valueOf(byteBuffer.capacity());
                } else {
                    num = null;
                }
                Log.i("MicroMsg.EditCaptionDataManager", append.append(num).append(", voiceSize:").append(f2).append(", adtsSize:").append(f3).append(", duration:").append(j3).append(", bitrate:").append(c2).toString());
                AppMethodBeat.o(191601);
                return 0;
            }
            Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
            AppMethodBeat.o(191601);
            return 0;
        } catch (Exception e2) {
            c cVar6 = this.igg;
            if (cVar6 != null) {
                cVar6.release();
            }
            this.igg = null;
            Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", e2, "", new Object[0]);
            this.wJC = -3;
            AppMethodBeat.o(191601);
            return -3;
        }
    }

    private final void a(int i2, com.tencent.mm.bw.b bVar, int i3, int i4) {
        com.tencent.mm.bw.b bVar2;
        String str;
        Integer num = null;
        AppMethodBeat.i(191602);
        int i5 = this.jcu;
        e eVar = this.wJx;
        if (eVar != null) {
            bVar2 = eVar.GLl;
        } else {
            bVar2 = null;
        }
        e eVar2 = new e(i2, bVar, i3, i4, i5, bVar2);
        StringBuilder append = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
        com.tencent.mm.bw.b bVar3 = eVar2.GLl;
        if (bVar3 != null) {
            str = bVar3.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } else {
            str = null;
        }
        StringBuilder append2 = append.append(str).append(" seq:").append(i3).append(" size:");
        if (bVar != null) {
            num = Integer.valueOf(bVar.zy.length);
        }
        Log.i("MicroMsg.EditCaptionDataManager", append2.append(num).append(" offset:").append(i4).toString());
        eVar2.setFilePath(this.filePath);
        this.wJx = eVar2;
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(this.wJx);
        AppMethodBeat.o(191602);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        int i4;
        AppMethodBeat.i(191603);
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
            AppMethodBeat.o(191603);
            throw tVar;
        }
        if (p.j(((e) qVar).filePath, this.filePath) && !this.ife) {
            Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            int i5 = ((e) qVar).GKp;
            if (i2 == 0 && i3 == 0) {
                this.wJy = ((e) qVar).GLj;
                Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e) qVar).jlm + " isLastRequest:" + ((e) qVar).GLk + " progress:" + ((e) qVar).getProgress());
                int i6 = 0;
                for (T t : this.wJy) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + i6 + ": start:" + t2.LaT + " end:" + t2.LaU + " text:" + t2.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    if (((e) qVar).GLk && ((e) qVar).getProgress() >= 100) {
                        long j2 = GJV + 1;
                        GJV = j2;
                        t2.id = j2;
                    }
                    i6 = i7;
                }
                Log.i("MicroMsg.EditCaptionDataManager", "\n");
                if (((e) qVar).GLk) {
                    if (((e) qVar).getProgress() >= 100) {
                        this.tUq = false;
                        r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar = this.hFV;
                        if (rVar != null) {
                            Integer valueOf = Integer.valueOf(i5);
                            String str2 = this.filePath;
                            if (!this.wJy.isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                i4 = 0;
                            } else {
                                i4 = -2;
                            }
                            rVar.invoke(valueOf, str2, Integer.valueOf(i4), this.wJy);
                            AppMethodBeat.o(191603);
                            return;
                        }
                        AppMethodBeat.o(191603);
                        return;
                    }
                    r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar2 = this.hFV;
                    if (rVar2 != null) {
                        rVar2.invoke(Integer.valueOf(i5), this.filePath, 0, this.wJy);
                    }
                    Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
                    e eVar = this.wJx;
                    if (eVar == null) {
                        p.hyc();
                    }
                    a(i5, null, eVar.jlm, 0);
                    AppMethodBeat.o(191603);
                    return;
                }
            } else if (((e) qVar).GLk) {
                this.wJC = -1;
                this.tUq = false;
                r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar3 = this.hFV;
                if (rVar3 != null) {
                    rVar3.invoke(Integer.valueOf(i5), this.filePath, -1, null);
                }
                this.wJB = true;
            }
        }
        AppMethodBeat.o(191603);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.vlog.ui.plugin.caption.EditCaptionDataManager$voiceTransLate$1", f = "EditCaptionDataManager.kt", hxM = {}, m = "invokeSuspend")
    public static final class b extends kotlin.d.b.a.j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ int $type;
        final /* synthetic */ a GJX;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, int i2, d dVar) {
            super(2, dVar);
            this.GJX = aVar;
            this.$type = i2;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(191599);
            p.h(dVar, "completion");
            b bVar = new b(this.GJX, this.$type, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(191599);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(191600);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(191600);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(191598);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    a.a(this.GJX);
                    a.a(this.GJX, this.$type);
                    x xVar = x.SXb;
                    AppMethodBeat.o(191598);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(191598);
                    throw illegalStateException;
            }
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        int i2;
        AppMethodBeat.i(191606);
        if (!aVar.wJA) {
            long currentTicks = Util.currentTicks();
            ByteBuffer byteBuffer = aVar.wJz;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
            ByteBuffer byteBuffer2 = aVar.wJz;
            if (byteBuffer2 != null) {
                byteBuffer2.position(0);
            }
            while (!aVar.ife) {
                try {
                    c cVar = aVar.igg;
                    if ((cVar != null ? cVar.getSampleTrackIndex() : -1) < 0) {
                        break;
                    }
                    ByteBuffer byteBuffer3 = aVar.wJz;
                    if (byteBuffer3 != null) {
                        c cVar2 = aVar.igg;
                        if (cVar2 != null) {
                            i2 = cVar2.readSampleData(byteBuffer3, aVar.jcu + 7);
                        } else {
                            i2 = -1;
                        }
                        if (i2 > 2) {
                            com.tencent.mm.plugin.mmsight.model.a.a(byteBuffer3, aVar.jcu, i2 + 7, aVar.profile, aVar.sampleRate, aVar.wJD);
                            aVar.jcu += i2 + 7;
                        }
                        c cVar3 = aVar.igg;
                        if (cVar3 != null) {
                            cVar3.advance();
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", e2, "loadAudioTrackData error:" + e2.getMessage(), new Object[0]);
                }
            }
            Log.i("MicroMsg.EditCaptionDataManager", "[" + aVar.hashCode() + "]load audio track size:" + aVar.jcu + " cost:" + Util.ticksToNow(currentTicks));
            aVar.wJA = true;
        }
        AppMethodBeat.o(191606);
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(191607);
        int i3 = 0;
        long currentTicks = Util.currentTicks();
        int i4 = 1;
        while (i3 < aVar.jcu) {
            int i5 = 167116 + i3;
            if (i5 > aVar.jcu) {
                i5 = aVar.jcu;
            }
            ByteBuffer byteBuffer = aVar.wJz;
            if (byteBuffer != null) {
                byteBuffer.position(i3);
            }
            byte[] bArr = new byte[(i5 - i3)];
            ByteBuffer byteBuffer2 = aVar.wJz;
            if (byteBuffer2 != null) {
                byteBuffer2.get(bArr);
            }
            aVar.a(i2, new com.tencent.mm.bw.b(bArr), i4, i3);
            i4++;
            i3 = i5;
        }
        Log.i("MicroMsg.EditCaptionDataManager", "[" + aVar.hashCode() + "]do net cost:" + Util.ticksToNow(currentTicks));
        ByteBuffer byteBuffer3 = aVar.wJz;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
            AppMethodBeat.o(191607);
            return;
        }
        AppMethodBeat.o(191607);
    }
}
