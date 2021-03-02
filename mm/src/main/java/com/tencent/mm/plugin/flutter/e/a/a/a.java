package com.tencent.mm.plugin.flutter.e.a.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.ui.plugin.caption.e;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J*\u0010'\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u0006\u0010.\u001a\u00020\u0005J\b\u0010/\u001a\u00020\u0010H\u0002J,\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020\u0010J\b\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0001\u00109\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\t2v\u0010\u0003\u001ar\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012'\u0012%\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004R~\u0010\u0003\u001ar\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012'\u0012%\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/CaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", Scopes.PROFILE, "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-flutter_release"})
public final class a implements i {
    public static final C1361a wJE = new C1361a((byte) 0);
    public String filePath = "";
    public r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> hFV;
    private volatile boolean ife;
    private c igg;
    private int jcu;
    private int profile = 2;
    private int sampleRate = 44100;
    public boolean tUq;
    private boolean wJA;
    public boolean wJB = true;
    public int wJC;
    private int wJD = 1;
    private e wJx;
    private ArrayList<sy> wJy = new ArrayList<>();
    private ByteBuffer wJz;

    static {
        AppMethodBeat.i(241048);
        AppMethodBeat.o(241048);
    }

    public a() {
        AppMethodBeat.i(241047);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3835, this);
        AppMethodBeat.o(241047);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/CaptionDataManager$Companion;", "", "()V", "CAPTION_EXTRACTOR_ERROR", "", "CAPTION_NO_AUDIO", "CAPTION_RESULT_ERROR", "CAPTION_RESULT_LOAD_MORE", "CAPTION_RESULT_OK", "FLUTTER_TAG", "", "REQUEST_VOICE_SIZE", "TAG", "plugin-flutter_release"})
    /* renamed from: com.tencent.mm.plugin.flutter.e.a.a.a$a  reason: collision with other inner class name */
    public static final class C1361a {
        private C1361a() {
        }

        public /* synthetic */ C1361a(byte b2) {
            this();
        }
    }

    public final int axp(String str) {
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        String str2;
        AppMethodBeat.i(241043);
        try {
            if (this.igg == null) {
                this.igg = new c();
                c cVar = this.igg;
                if (cVar != null) {
                    cVar.setDataSource(str);
                }
                c cVar2 = this.igg;
                int trackCount = cVar2 != null ? cVar2.getTrackCount() : 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= trackCount) {
                        mediaFormat = null;
                        break;
                    }
                    c cVar3 = this.igg;
                    if (cVar3 != null) {
                        mediaFormat2 = cVar3.getTrackFormat(i2);
                    } else {
                        mediaFormat2 = null;
                    }
                    if (mediaFormat2 != null) {
                        str2 = mediaFormat2.getString("mime");
                    } else {
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2) || str2 == null || !n.J(str2, "audio/", false)) {
                        i2++;
                    } else {
                        c cVar4 = this.igg;
                        if (cVar4 != null) {
                            cVar4.selectTrack(i2);
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
                    AppMethodBeat.o(241043);
                    return -2;
                }
                long j2 = mediaFormat.getLong("durationUs");
                int integer = mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                this.profile = mediaFormat.getInteger(Scopes.PROFILE, this.profile);
                this.sampleRate = mediaFormat.getInteger("sample-rate", this.sampleRate);
                this.wJD = mediaFormat.getInteger("channel-count", this.wJD);
                float f2 = 2.0f * ((((float) integer) * ((((float) j2) / 1000.0f) / 1000.0f)) / 8.0f);
                float f3 = ((((float) j2) / 1000.0f) / 20.0f) * 7.0f;
                this.wJz = ByteBuffer.allocateDirect((int) (f2 + f3));
                StringBuilder append = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
                ByteBuffer byteBuffer = this.wJz;
                Log.i("MicroMsg.EditCaptionDataManager", append.append(byteBuffer != null ? Integer.valueOf(byteBuffer.capacity()) : null).append(", voiceSize:").append(f2).append(", adtsSize:").append(f3).append(", duration:").append(j2).append(", bitrate:").append(integer).toString());
                AppMethodBeat.o(241043);
                return 0;
            }
            Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
            AppMethodBeat.o(241043);
            return 0;
        } catch (Exception e2) {
            c cVar6 = this.igg;
            if (cVar6 != null) {
                cVar6.release();
            }
            this.igg = null;
            Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", e2, "", new Object[0]);
            this.wJC = -3;
            AppMethodBeat.o(241043);
            return -3;
        }
    }

    private final void a(int i2, com.tencent.mm.bw.b bVar, int i3, int i4) {
        com.tencent.mm.bw.b bVar2;
        String str;
        Integer num = null;
        AppMethodBeat.i(241044);
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
        AppMethodBeat.o(241044);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(241045);
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
            AppMethodBeat.o(241045);
            throw tVar;
        }
        if (p.j(((e) qVar).filePath, this.filePath) && !this.ife) {
            Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            int i4 = ((e) qVar).GKp;
            if (i2 == 0 && i3 == 0) {
                this.wJy = ((e) qVar).GLj;
                Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e) qVar).jlm + " isLastRequest:" + ((e) qVar).GLk + " progress:" + ((e) qVar).getProgress());
                Log.i("MicroMsg.EditCaptionDataManager", "\n");
                if (((e) qVar).GLk) {
                    if (((e) qVar).getProgress() >= 100) {
                        this.tUq = false;
                        r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar = this.hFV;
                        if (rVar != null) {
                            rVar.invoke(Integer.valueOf(i4), this.filePath, 0, this.wJy);
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(Boolean.TRUE);
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(this.filePath);
                        ArrayList arrayList4 = new ArrayList();
                        ArrayList arrayList5 = new ArrayList();
                        ArrayList arrayList6 = new ArrayList();
                        int i5 = 0;
                        for (T t : this.wJy) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                j.hxH();
                            }
                            T t2 = t;
                            Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + i5 + ": start:" + t2.LaT + " end:" + t2.LaU + " text:" + t2.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                            arrayList4.add(t2.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                            arrayList5.add(Long.valueOf(t2.LaT));
                            arrayList6.add(Long.valueOf(t2.LaU));
                            i5 = i6;
                        }
                        arrayList.add(arrayList2);
                        arrayList.add(arrayList3);
                        arrayList.add(arrayList4);
                        arrayList.add(arrayList5);
                        arrayList.add(arrayList6);
                        h.INSTANCE.dN(1565, 15);
                        Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
                        o.a aVar = o.wKI;
                        o.a.dMh().t("onGetCaptionDaraCompleted", arrayList);
                        release();
                        AppMethodBeat.o(241045);
                        return;
                    }
                    r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar2 = this.hFV;
                    if (rVar2 != null) {
                        rVar2.invoke(Integer.valueOf(i4), this.filePath, 0, this.wJy);
                    }
                    Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
                    e eVar = this.wJx;
                    if (eVar == null) {
                        p.hyc();
                    }
                    a(i4, null, eVar.jlm, 0);
                    AppMethodBeat.o(241045);
                    return;
                }
            } else if (((e) qVar).GLk) {
                this.wJC = -1;
                this.tUq = false;
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                arrayList8.add(Boolean.FALSE);
                ArrayList arrayList9 = new ArrayList();
                arrayList9.add(this.filePath);
                ArrayList arrayList10 = new ArrayList();
                ArrayList arrayList11 = new ArrayList();
                ArrayList arrayList12 = new ArrayList();
                int i7 = 0;
                for (T t3 : this.wJy) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        j.hxH();
                    }
                    T t4 = t3;
                    Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + i7 + ": start:" + t4.LaT + " end:" + t4.LaU + " text:" + t4.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    arrayList10.add(t4.LaS.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    arrayList11.add(Long.valueOf(t4.LaT));
                    arrayList12.add(Long.valueOf(t4.LaU));
                    i7 = i8;
                }
                arrayList7.add(arrayList8);
                arrayList7.add(arrayList9);
                arrayList7.add(arrayList10);
                arrayList7.add(arrayList11);
                arrayList7.add(arrayList12);
                h.INSTANCE.dN(1565, 15);
                Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
                o.a aVar2 = o.wKI;
                o.a.dMh().t("onGetCaptionDaraCompleted", arrayList7);
                release();
                r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> rVar3 = this.hFV;
                if (rVar3 != null) {
                    rVar3.invoke(Integer.valueOf(i4), this.filePath, -1, null);
                }
                this.wJB = true;
            }
        }
        AppMethodBeat.o(241045);
    }

    private void release() {
        AppMethodBeat.i(241046);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3835, this);
        try {
            this.ife = true;
            c cVar = this.igg;
            if (cVar != null) {
                cVar.release();
            }
            this.igg = null;
            AppMethodBeat.o(241046);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", e2, "", new Object[0]);
            AppMethodBeat.o(241046);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.flutter.plugins.video.api.CaptionDataManager$voiceTransLate$1", f = "CaptionDataManager.kt", hxM = {}, m = "invokeSuspend")
    public static final class b extends kotlin.d.b.a.j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ int $type;
        int label;
        private ai p$;
        final /* synthetic */ a wJF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, d dVar) {
            super(2, dVar);
            this.wJF = aVar;
            this.$type = i2;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(241041);
            p.h(dVar, "completion");
            b bVar = new b(this.wJF, this.$type, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(241041);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(241042);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(241042);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(241040);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    a.a(this.wJF);
                    a.a(this.wJF, this.$type);
                    x xVar = x.SXb;
                    AppMethodBeat.o(241040);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(241040);
                    throw illegalStateException;
            }
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        int i2;
        AppMethodBeat.i(241049);
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
        AppMethodBeat.o(241049);
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(241050);
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
            AppMethodBeat.o(241050);
            return;
        }
        AppMethodBeat.o(241050);
    }
}
