package com.tencent.mm.plugin.flutter.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.share.internal.ShareConstants;
import com.tencent.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.flutter.e.a.a.a;
import com.tencent.mm.plugin.flutter.e.a.a.c;
import com.tencent.mm.plugin.flutter.e.a.a.d;
import com.tencent.mm.plugin.flutter.e.a.a.e;
import com.tencent.mm.plugin.flutter.e.a.a.f;
import com.tencent.mm.plugin.flutter.e.a.a.g;
import com.tencent.mm.plugin.flutter.e.a.a.h;
import com.tencent.mm.plugin.flutter.e.a.a.i;
import com.tencent.mm.plugin.flutter.e.a.a.j;
import com.tencent.mm.plugin.flutter.e.a.a.k;
import com.tencent.mm.plugin.flutter.e.a.a.l;
import com.tencent.mm.plugin.flutter.e.a.a.m;
import com.tencent.mm.plugin.flutter.e.a.a.n;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 g2\u00020\u0001:\u0001gB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020/H\u0016J\u0012\u00100\u001a\u0002012\b\u0010\u0005\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u0002062\b\u0010\u0005\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u00020;2\b\u0010&\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0005\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020A2\b\u0010&\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\u0004H\u0016J\u0012\u0010K\u001a\u00020L2\b\u0010\u0005\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020OH\u0016J\u0012\u0010P\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010R\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010S\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020TH\u0016J\u001c\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020W2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YJ\u0012\u0010[\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010]\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010^H\u0016J\u0012\u0010_\u001a\u00020`2\b\u0010\u0005\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010b\u001a\u00020`2\b\u0010\u0005\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010c\u001a\u00020W2\b\u0010&\u001a\u0004\u0018\u00010dH\u0016J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020fH\u0016¨\u0006h"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/MMVideoEditorCompositionApiPlugin;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoEditorCompositionApi;", "()V", "DeleteEmoji", "", "arg", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$DeleteEmojiRequest;", "MoveEmojiToFront", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MoveEmojiToFrontRequest;", "addMember", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioLrcInfo;", "addMember10", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionInfoProto;", "addMember2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioInfo;", "addMember3", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchResponse;", "addMember4", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchLrcInfo;", "addMember5", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionDataResponse;", "addMember6", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TrackInfoProtoFlutter;", "addMember7", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoTemplateInfoProto;", "addMember8", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionOutputConfig;", "addMember9", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "bitmapToBase64", "", "bitmap", "Landroid/graphics/Bitmap;", "checkFontFamilyRes", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$FontFamilyResResponse;", "checkTransitionRes", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionResResponse;", "doMusicSearchRequest", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchRequest;", "downloadMusic", "info", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicDownloadInfo;", "getAudioRecommend", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendRequest;", "getCaptionData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CaptionDataRequest;", "getCustomEmojiCapture", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureEmojiResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureEmojiRequest;", "getCustomEmojiCaptureMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureMd5ListResponse;", "getCustomEmojiData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiNormalResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiDataRequest;", "getCustomEmojiMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiMd5Data;", "getEmojiDataBase64", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataBase64Response;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataBase64Request;", "getEmojiGIFData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiGIFDataResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiGIFDataRequest;", "getEmojiMd5ListByProductId", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiInfoMd5Response;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiInfoMd5Request;", "getFontDataResponse", "getGroupProductId", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiProductIdResponse;", "getNetWorkType", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IntReply;", "getSystemEmojiMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SystemEmojiMd5Response;", "getTransitionData", "getVideoGOPStr", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$StringResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoGOPStrRequest;", "idkeyStat", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IdkeyRequest;", "improveVideoQuality", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$BoolRequest;", "jumpToPostUI", "jumpToPostUI2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IntRequest;", "loadEmoji", "response", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataResponse;", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "saveImageByteToPath", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SaveImageByteToPath;", "showeEmojiGroupDetail", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$ShoweEmojiGroupDetailRequest;", "simple", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SimpleReply;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SimpleRequest;", "simple2", "testEmoji", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataRequest;", "textToSpeech", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TextToSpeechRequest;", "Companion", "plugin-flutter_release"})
public final class a extends b.as {
    public static final C1360a wJw = new C1360a((byte) 0);

    static {
        AppMethodBeat.i(241039);
        AppMethodBeat.o(241039);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/MMVideoEditorCompositionApiPlugin$Companion;", "", "()V", "TAG", "", "plugin-flutter_release"})
    /* renamed from: com.tencent.mm.plugin.flutter.e.a.a$a  reason: collision with other inner class name */
    public static final class C1360a {
        private C1360a() {
        }

        public /* synthetic */ C1360a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.d.b.as
    public final b.aj a(b.ak akVar) {
        AppMethodBeat.i(240999);
        b.aj ajVar = new b.aj();
        if (akVar == null) {
            ajVar.bpS("fail");
        } else {
            new StringBuilder("arg.requestName").append(akVar.hjZ());
            ajVar.bpS("wecaht success");
        }
        AppMethodBeat.o(240999);
        return ajVar;
    }

    @Override // com.tencent.d.b.as
    public final b.aj b(b.ak akVar) {
        AppMethodBeat.i(241000);
        b.aj ajVar = new b.aj();
        if (akVar == null) {
            ajVar.bpS("fail");
        } else {
            new StringBuilder("arg.requestName").append(akVar.hjZ());
            ajVar.bpS("wecaht success");
        }
        AppMethodBeat.o(241000);
        return ajVar;
    }

    @Override // com.tencent.d.b.as
    public final b.s a(b.r rVar) {
        AppMethodBeat.i(241001);
        b.s sVar = new b.s();
        new StringBuilder("emoji request ").append(rVar.hjQ());
        sVar.bpP("emoji response from java!");
        h.a aVar = h.wKb;
        h.a.dLW();
        for (EmojiGroupInfo emojiGroupInfo : h.dLS()) {
            new StringBuilder("produce id is ").append(emojiGroupInfo.hYf());
        }
        AppMethodBeat.o(241001);
        return sVar;
    }

    @Override // com.tencent.d.b.as
    public final b.x dLw() {
        AppMethodBeat.i(241002);
        h.a aVar = h.wKb;
        h.a.dLW();
        List<EmojiGroupInfo> dLS = h.dLS();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b.x xVar = new b.x();
        for (EmojiGroupInfo emojiGroupInfo : dLS) {
            arrayList.add(emojiGroupInfo.field_productID);
            arrayList2.add(emojiGroupInfo.field_packName);
            arrayList3.add(emojiGroupInfo.field_packGrayIconUrl);
        }
        xVar.by(arrayList);
        xVar.bz(arrayList2);
        xVar.bx(arrayList3);
        AppMethodBeat.o(241002);
        return xVar;
    }

    @Override // com.tencent.d.b.as
    public final b.w a(b.v vVar) {
        Long l = null;
        AppMethodBeat.i(241003);
        h.a aVar = h.wKb;
        h.a.dLW();
        List<EmojiInfo> axq = h.axq(vVar.getProductId());
        b.w wVar = new b.w();
        wVar.bw(new ArrayList());
        for (EmojiInfo emojiInfo : axq) {
            wVar.hjR().add(emojiInfo.getMd5());
        }
        h.a aVar2 = h.wKb;
        h.a.dLW();
        PersonalDesigner axw = h.axw(vVar.getProductId());
        wVar.bpR(axw != null ? axw.HeadUrl : null);
        wVar.bpQ(axw != null ? axw.Name : null);
        if (axw != null) {
            l = Long.valueOf((long) axw.DesignerUin);
        }
        wVar.o(l);
        AppMethodBeat.o(241003);
        return wVar;
    }

    @Override // com.tencent.d.b.as
    public final b.q a(b.p pVar) {
        boolean z;
        AppMethodBeat.i(241004);
        b.q qVar = new b.q();
        h.a aVar = h.wKb;
        h.a.dLW();
        String productId = pVar.getProductId();
        p.g(productId, "request.productId");
        String hjP = pVar.hjP();
        p.g(hjP, "request.emojiMd5");
        p.h(productId, "productId");
        p.h(hjP, "md5");
        List<EmojiInfo> axq = h.axq(productId);
        c cVar = new c();
        Iterator<EmojiInfo> it = axq.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EmojiInfo next = it.next();
            if (p.j(next.getMd5(), hjP)) {
                cVar.zy = h.ab(next.A(g.aAe().azG().aAZ(), 480));
                if (next.field_catalog == EmojiGroupInfo.VkO) {
                    z = true;
                } else {
                    z = false;
                }
                cVar.wJQ = Boolean.valueOf(z);
            }
        }
        qVar.cS(cVar.zy);
        qVar.v(cVar.wJQ);
        h.a aVar2 = h.wKb;
        h.a.dLW();
        String hjP2 = pVar.hjP();
        p.g(hjP2, "request.emojiMd5");
        qVar.bpO(h.axv(hjP2));
        AppMethodBeat.o(241004);
        return qVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.o oVar) {
        AppMethodBeat.i(241005);
        Long hjC = oVar.hjC();
        if (hjC != null) {
            i.dLX().br((int) hjC.longValue(), oVar.getMd5());
            AppMethodBeat.o(241005);
            return;
        }
        AppMethodBeat.o(241005);
    }

    @Override // com.tencent.d.b.as
    public final void a(b.ac acVar) {
        AppMethodBeat.i(241006);
        Long hjC = acVar.hjC();
        if (hjC != null) {
            i.dLX().bs((int) hjC.longValue(), acVar.getMd5());
            AppMethodBeat.o(241006);
            return;
        }
        AppMethodBeat.o(241006);
    }

    @Override // com.tencent.d.b.as
    public final b.d a(b.c cVar) {
        AppMethodBeat.i(241007);
        new b.d();
        f.a aVar = f.wJV;
        f dLQ = f.a.dLQ();
        String path = cVar.getPath();
        p.g(path, "request.path");
        Long hjA = cVar.hjA();
        p.g(hjA, "request.startTime");
        long longValue = hjA.longValue();
        Long hjB = cVar.hjB();
        p.g(hjB, "request.endTime");
        long longValue2 = hjB.longValue();
        p.h(path, "videoPath");
        Log.i(dLQ.TAG, "getRecommendAudio111");
        p.h(path, "videoPath");
        Log.i(dLQ.TAG, "startGetRecommendAudio");
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 19);
        Log.i(dLQ.vRb, "start to get music recommend");
        dLQ.wJS = new com.tencent.mm.plugin.recordvideo.model.audio.h(dLQ.wJT, path, longValue, longValue2, com.tencent.mm.plugin.recordvideo.b.i.Finder.ordinal());
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar2 = dLQ.wJS;
        if (aVar2 != null) {
            aVar2.callback = new f.d(dLQ);
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar3 = dLQ.wJS;
        if (aVar3 != null) {
            aVar3.qdn = false;
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar4 = dLQ.wJS;
        if (aVar4 != null) {
            aVar4.eJQ();
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar5 = dLQ.wJS;
        if (aVar5 != null) {
            aVar5.cJk();
        }
        b.d dVar = new b.d();
        AppMethodBeat.o(241007);
        return dVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.af afVar) {
        AppMethodBeat.i(241008);
        if (afVar.getName() != null) {
            k.a aVar = k.wKs;
            if (k.dLZ() == null) {
                k.e(new k((byte) 0));
            }
            k dLZ = k.dLZ();
            if (dLZ == null) {
                p.hyc();
            }
            String name = afVar.getName();
            p.g(name, "request.name");
            int longValue = (int) afVar.hjX().longValue();
            p.h(name, "researchString");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 22);
            Log.i(dLZ.vRb, "start to search music");
            Log.i(dLZ.TAG, "music search name: " + name + ", offset: " + longValue);
            new com.tencent.mm.plugin.recordvideo.model.audio.f(dLZ.wKp, name, longValue, dLZ.wKq, (byte) 0).aYI().b(new k.b(dLZ, name));
        }
        AppMethodBeat.o(241008);
    }

    @Override // com.tencent.d.b.as
    public final b.u a(b.t tVar) {
        Long l;
        Long l2 = null;
        AppMethodBeat.i(241009);
        p.h(tVar, "arg");
        b.u uVar = new b.u();
        h.a aVar = h.wKb;
        h.a.dLW();
        String md5 = tVar.getMd5();
        p.g(md5, "arg.md5");
        uVar.setData(h.axr(md5));
        h.a aVar2 = h.wKb;
        h.a.dLW();
        String md52 = tVar.getMd5();
        p.g(md52, "arg.md5");
        d axs = h.axs(md52);
        Integer num = axs.irm;
        if (num != null) {
            l = Long.valueOf((long) num.intValue());
        } else {
            l = null;
        }
        uVar.m(l);
        Integer num2 = axs.irl;
        if (num2 != null) {
            l2 = Long.valueOf((long) num2.intValue());
        }
        uVar.n(l2);
        AppMethodBeat.o(241009);
        return uVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLx() {
        AppMethodBeat.i(241010);
        m.a aVar = m.wKB;
        if (m.dMe() == null) {
            m.a(new m((byte) 0));
        }
        m dMe = m.dMe();
        if (dMe == null) {
            p.hyc();
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("name", "无转场");
        hashMap.put("data", "wu.svg");
        hashMap.put("effectPath", "");
        arrayList.add(hashMap);
        Iterator<m.b> it = dMe.wKy.iterator();
        while (it.hasNext()) {
            m.b next = it.next();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("name", next.name);
            hashMap2.put("data", next.wKC);
            hashMap2.put("effectPath", next.assetPath);
            arrayList.add(hashMap2);
        }
        o.a aVar2 = o.wKI;
        o.a.dMh().t("onTransitionResourceGetted", arrayList);
        AppMethodBeat.o(241010);
    }

    @Override // com.tencent.d.b.as
    public final b.n a(b.l lVar) {
        AppMethodBeat.i(241011);
        b.n nVar = new b.n();
        h.a aVar = h.wKb;
        h.a.dLW();
        nVar.cS(h.axu(lVar.getMd5()));
        AppMethodBeat.o(241011);
        return nVar;
    }

    @Override // com.tencent.d.b.as
    public final b.y dLy() {
        AppMethodBeat.i(241012);
        b.y yVar = new b.y();
        l.a aVar = com.tencent.mm.plugin.flutter.e.a.a.l.wKw;
        yVar.w(Boolean.valueOf(l.a.dMc().dMa()));
        AppMethodBeat.o(241012);
        return yVar;
    }

    @Override // com.tencent.d.b.as
    public final b.ar dLz() {
        Boolean bool;
        AppMethodBeat.i(241013);
        b.ar arVar = new b.ar();
        n.a aVar = n.wKF;
        if (n.dMf() == null) {
            n.a(new n((byte) 0));
        }
        n dMf = n.dMf();
        if (dMf == null) {
            p.hyc();
        }
        if (dMf != null) {
            if (!com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 16);
                Log.d(dMf.vRb, "start to download transition");
                com.tencent.mm.plugin.recordvideo.res.f.BYo.BYa = new n.b(dMf);
            }
            com.tencent.mm.plugin.recordvideo.res.f.BYo.bbA();
            bool = Boolean.valueOf(com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ);
        } else {
            bool = null;
        }
        arVar.w(Boolean.valueOf(bool.booleanValue()));
        AppMethodBeat.o(241013);
        return arVar;
    }

    @Override // com.tencent.d.b.as
    public final b.m dLA() {
        AppMethodBeat.i(241014);
        b.m mVar = new b.m();
        h.a aVar = h.wKb;
        h.a.dLW();
        List<EmojiInfo> dLT = h.dLT();
        ArrayList arrayList = new ArrayList();
        for (EmojiInfo emojiInfo : dLT) {
            arrayList.add(emojiInfo.getMd5());
        }
        mVar.bw(arrayList);
        AppMethodBeat.o(241014);
        return mVar;
    }

    @Override // com.tencent.d.b.as
    public final b.am dLB() {
        AppMethodBeat.i(241015);
        b.am amVar = new b.am();
        h.a aVar = h.wKb;
        h.a.dLW();
        amVar.bw(h.dLU());
        AppMethodBeat.o(241015);
        return amVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.ad adVar) {
        AppMethodBeat.i(241016);
        AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
        audioCacheInfo.BOX = (int) adVar.hjV().longValue();
        audioCacheInfo.musicUrl = adVar.hjW();
        audioCacheInfo.cachePath = adVar.azM();
        f.a aVar = f.wJV;
        f dLQ = f.a.dLQ();
        p.h(audioCacheInfo, "info");
        Log.i(dLQ.TAG, "downloadMusic : " + audioCacheInfo.cachePath + ", " + audioCacheInfo.BOX);
        i.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
        com.tencent.mm.plugin.recordvideo.model.audio.i iVar = com.tencent.mm.plugin.recordvideo.model.audio.i.BPK;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        iVar.a(context, audioCacheInfo, new f.c(dLQ));
        AppMethodBeat.o(241016);
    }

    @Override // com.tencent.d.b.as
    public final b.k dLC() {
        AppMethodBeat.i(241017);
        b.k kVar = new b.k();
        ArrayList<EmojiInfo> dU = j.auL().dU(false);
        ArrayList arrayList = new ArrayList();
        Iterator<EmojiInfo> it = dU.iterator();
        while (it.hasNext()) {
            EmojiInfo next = it.next();
            p.g(next, "info");
            arrayList.add(next.getMd5());
        }
        kVar.bw(arrayList);
        AppMethodBeat.o(241017);
        return kVar;
    }

    @Override // com.tencent.d.b.as
    public final b.aa dLD() {
        AppMethodBeat.i(241018);
        b.aa aaVar = new b.aa();
        aaVar.p(Long.valueOf((long) e.bAX()));
        AppMethodBeat.o(241018);
        return aaVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.ah ahVar) {
        Bitmap decodeByteArray;
        boolean z = true;
        AppMethodBeat.i(241019);
        com.tencent.mm.plugin.flutter.e.a.a.p pVar = new com.tencent.mm.plugin.flutter.e.a.a.p();
        byte[] hjY = ahVar.hjY();
        String path = ahVar.getPath();
        p.g(path, "request.path");
        p.h(path, "path");
        if (hjY == null) {
            Log.e(pVar.TAG, "bytesToBitmap save image data is null");
            decodeByteArray = null;
        } else {
            new BitmapFactory.Options().inMutable = true;
            decodeByteArray = BitmapFactory.decodeByteArray(hjY, 0, hjY.length);
        }
        if (decodeByteArray == null || org.apache.commons.b.g.eP(path)) {
            String str = pVar.TAG;
            StringBuilder sb = new StringBuilder("bitmap or path null: ");
            if (decodeByteArray != null) {
                z = false;
            }
            Log.e(str, sb.append(z).append(", ").append(org.apache.commons.b.g.eP(path)).toString());
            AppMethodBeat.o(241019);
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        try {
            Log.i(pVar.TAG, "save pat: ".concat(String.valueOf(path)));
            decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.write(new byte[1052672]);
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(241019);
        } catch (Exception e2) {
            Log.e(pVar.TAG, "saveImageToPath error: " + e2.getLocalizedMessage());
            try {
                fileOutputStream.close();
                decodeByteArray.recycle();
                AppMethodBeat.o(241019);
            } catch (Exception e3) {
                AppMethodBeat.o(241019);
            }
        }
    }

    @Override // com.tencent.d.b.as
    public final void a(b.g gVar) {
        AppMethodBeat.i(241020);
        com.tencent.mm.plugin.flutter.e.a.a.j jVar = new com.tencent.mm.plugin.flutter.e.a.a.j();
        if (gVar != null) {
            p.h(gVar, "compositionInfo");
            Log.i(jVar.TAG, "jumpToPostUI: " + gVar.aQn());
            com.tencent.mm.plugin.flutter.e.a.a.j.wKk = new acn();
            com.tencent.mm.plugin.flutter.e.a.a.j.wKj = gVar;
            acn acn = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
            if (acn == null) {
                p.btv("cp");
            }
            if (acn == null) {
                p.hyc();
            }
            jVar.a(acn, gVar);
            acn acn2 = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
            if (acn2 == null) {
                p.btv("cp");
            }
            if (acn2 == null) {
                p.hyc();
            }
            com.tencent.mm.videocomposition.n composition = com.tencent.mm.plugin.vlog.model.i.d(acn2, new EffectManager()).getComposition();
            acn acn3 = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
            if (acn3 == null) {
                p.btv("cp");
            }
            if (acn3 == null) {
                p.hyc();
            }
            composition.c(acn3.Gxw.targetWidth, new j.b(gVar));
        }
        AppMethodBeat.o(241020);
    }

    @Override // com.tencent.d.b.as
    public final void a(b.ab abVar) {
        byte[] bArr;
        String str = null;
        AppMethodBeat.i(241021);
        p.h(abVar, "arg");
        com.tencent.mm.plugin.flutter.e.a.a.j jVar = new com.tencent.mm.plugin.flutter.e.a.a.j();
        Long hjS = abVar.hjS();
        p.g(hjS, "arg.id");
        long longValue = hjS.longValue();
        Bitmap bitmap = com.tencent.mm.plugin.flutter.e.a.a.j.wKi;
        if (bitmap == null) {
            p.btv("thumb");
        }
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        b.g gVar = com.tencent.mm.plugin.flutter.e.a.a.j.wKj;
        if (gVar == null) {
            p.btv("compositionInfo2");
        }
        BitmapUtil.saveBitmapToImage(bitmap, 60, compressFormat, gVar != null ? gVar.aQn() : null, true);
        Intent intent = new Intent();
        acn acn = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
        if (acn == null) {
            p.btv("cp");
        }
        if (acn != null) {
            bArr = acn.toByteArray();
        } else {
            bArr = null;
        }
        intent.putExtra("video_composition", bArr);
        intent.putExtra("postType", 4);
        intent.putExtra("postMediaList", kotlin.a.j.ac(""));
        intent.putExtra("postTypeList", kotlin.a.j.ac(4));
        String[] strArr = new String[1];
        b.g gVar2 = com.tencent.mm.plugin.flutter.e.a.a.j.wKj;
        if (gVar2 == null) {
            p.btv("compositionInfo2");
        }
        if (gVar2 != null) {
            str = gVar2.aQn();
        }
        strArr[0] = str;
        intent.putExtra("postThumbList", kotlin.a.j.ac(strArr));
        intent.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, jVar.postId);
        intent.putExtra("key_finder_post_from", 5);
        intent.putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
        intent.putExtra("KEY_FINDER_POST_EXPORT_START_TIME", longValue);
        intent.addFlags(268435456);
        intent.setClass(MMApplicationContext.getContext(), FinderPostUI.class);
        Context context = MMApplicationContext.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI", "jumpToPostUI2", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI", "jumpToPostUI2", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFlutter.class);
        p.g(ah, "MMKernel.plugin(PluginFlutter::class.java)");
        com.tencent.mm.plugin.flutter.b.a flutterEngineMgr = ((PluginFlutter) ah).getFlutterEngineMgr();
        p.g(flutterEngineMgr, "MMKernel.plugin(PluginFl…ss.java).flutterEngineMgr");
        com.tencent.mm.plugin.flutter.ui.a dLs = flutterEngineMgr.dLs();
        p.g(dLs, "MMKernel.plugin(PluginFl…ngineMgr.currentContainer");
        Activity activity = dLs.getActivity();
        if (activity instanceof MMFlutterActivity) {
            activity.setResult(-1);
        }
        activity.finish();
        AppMethodBeat.o(241021);
    }

    @Override // com.tencent.d.b.as
    public final void a(b.f fVar) {
        AppMethodBeat.i(241022);
        p.h(fVar, "arg");
        g.a aVar = com.tencent.mm.plugin.flutter.e.a.a.g.wJZ;
        if (com.tencent.mm.plugin.flutter.e.a.a.g.dLR() == null) {
            com.tencent.mm.plugin.flutter.e.a.a.g.a(new com.tencent.mm.plugin.flutter.e.a.a.g((byte) 0));
        }
        com.tencent.mm.plugin.flutter.e.a.a.g dLR = com.tencent.mm.plugin.flutter.e.a.a.g.dLR();
        if (dLR == null) {
            p.hyc();
        }
        int longValue = (int) fVar.hjC().longValue();
        String filePath = fVar.getFilePath();
        p.g(filePath, "arg.filePath");
        p.h(filePath, "filePath");
        com.tencent.mm.plugin.flutter.e.a.a.a aVar2 = new com.tencent.mm.plugin.flutter.e.a.a.a();
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 14);
        Log.i(dLR.TAG, "start to get caption result");
        p.h(filePath, "filePath");
        Log.i("MicroMsg.EditCaptionDataManager", "[" + aVar2.hashCode() + "]prepare translate file:" + filePath);
        if (aVar2.wJB || !p.j(filePath, aVar2.filePath)) {
            aVar2.wJB = false;
            aVar2.tUq = true;
            aVar2.hFV = null;
            aVar2.filePath = filePath;
            int axp = aVar2.axp(filePath);
            if (axp != 0) {
                aVar2.tUq = false;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Boolean.TRUE);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(filePath);
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                arrayList.add(arrayList2);
                arrayList.add(arrayList3);
                arrayList.add(arrayList4);
                arrayList.add(arrayList5);
                arrayList.add(arrayList6);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 15);
                Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
                o.a aVar3 = o.wKI;
                o.a.dMh().t("onGetCaptionDaraCompleted", arrayList);
                AppMethodBeat.o(241022);
                return;
            }
            aVar2.wJC = axp;
            kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new a.b(aVar2, longValue, null), 2);
        }
        AppMethodBeat.o(241022);
    }

    @Override // com.tencent.d.b.as
    public final void dLE() {
        int i2 = 0;
        AppMethodBeat.i(241023);
        l.a aVar = com.tencent.mm.plugin.flutter.e.a.a.l.wKw;
        if (l.a.dMc().dMa()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (com.tencent.mm.plugin.recordvideo.res.e.BYn.BXZ) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", BuildConfig.KINDA_DEFAULT);
                jSONObject.put("key", BuildConfig.KINDA_DEFAULT);
                jSONObject.put("path", BuildConfig.KINDA_DEFAULT);
                arrayList3.add(jSONObject);
                JSONArray eLn = com.tencent.mm.plugin.recordvideo.res.e.BYn.eLn();
                if (eLn != null) {
                    int length = eLn.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList3.add(eLn.optJSONObject(i3));
                    }
                }
                for (Object obj : arrayList3) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    JSONObject jSONObject2 = (JSONObject) obj;
                    String optString = jSONObject2.optString("name");
                    String str = com.tencent.mm.plugin.recordvideo.res.e.BYn.eLk() + jSONObject2.optString("path");
                    if (!p.j(optString, BuildConfig.KINDA_DEFAULT)) {
                        arrayList.add(optString);
                        arrayList2.add(str);
                    }
                    i2 = i4;
                }
            }
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(arrayList);
            arrayList4.add(arrayList2);
            o.a aVar2 = o.wKI;
            o.a.dMh().t("getFontData", arrayList4);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(241023);
    }

    @Override // com.tencent.d.b.as
    public final void dLF() {
        AppMethodBeat.i(241024);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241024);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final b.j a(b.i iVar) {
        AppMethodBeat.i(241025);
        b.j jVar = new b.j();
        h.a aVar = h.wKb;
        h.a.dLW();
        jVar.cS(h.axu(iVar.getMd5()));
        AppMethodBeat.o(241025);
        return jVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.ai aiVar) {
        AppMethodBeat.i(241026);
        h.a aVar = h.wKb;
        h.a.dLW();
        h.axt(aiVar.getProductId());
        AppMethodBeat.o(241026);
    }

    @Override // com.tencent.d.b.as
    public final void a(b.z zVar) {
        AppMethodBeat.i(241027);
        p.h(zVar, "arg");
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Long hjS = zVar.hjS();
        p.g(hjS, "arg.id");
        long longValue = hjS.longValue();
        Long hjT = zVar.hjT();
        p.g(hjT, "arg.key");
        long longValue2 = hjT.longValue();
        Long hjU = zVar.hjU();
        p.g(hjU, "arg.value");
        hVar.n(longValue, longValue2, hjU.longValue());
        AppMethodBeat.o(241027);
    }

    @Override // com.tencent.d.b.as
    public final b.al a(b.at atVar) {
        AppMethodBeat.i(241028);
        b.al alVar = new b.al();
        ArrayList hkb = atVar.hkb();
        ArrayList arrayList = new ArrayList();
        if (hkb != null) {
            Iterator it = hkb.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(241028);
                    throw tVar;
                }
                arrayList.add((String) next);
            }
        }
        alVar.bpT(e.eK(arrayList));
        AppMethodBeat.o(241028);
        return alVar;
    }

    @Override // com.tencent.d.b.as
    public final void a(b.an anVar) {
        AppMethodBeat.i(241029);
        p.h(anVar, "arg");
        String text = anVar.getText();
        String hka = anVar.hka();
        p.g(hka, "uniqueString");
        com.tencent.mm.plugin.flutter.e.a.a.b bVar = new com.tencent.mm.plugin.flutter.e.a.a.b(hka);
        p.g(text, "speechText");
        p.h(text, "text");
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        Log.i("vison", "doNetRequest");
        com.tencent.mm.plugin.vlog.ui.plugin.read.b bVar2 = new com.tencent.mm.plugin.vlog.ui.plugin.read.b(aUg, text);
        int i2 = com.tencent.mm.plugin.flutter.e.a.a.b.wJJ;
        com.tencent.mm.plugin.flutter.e.a.a.b.wJJ = i2 + 1;
        bVar.wJG = i2;
        bVar2.wJG = bVar.wJG;
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(bVar2);
        AppMethodBeat.o(241029);
    }

    @Override // com.tencent.d.b.as
    public final void dLG() {
        AppMethodBeat.i(241030);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241030);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLH() {
        AppMethodBeat.i(241031);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241031);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLI() {
        AppMethodBeat.i(241032);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241032);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLJ() {
        AppMethodBeat.i(241033);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241033);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLK() {
        AppMethodBeat.i(241034);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241034);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLL() {
        AppMethodBeat.i(241035);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241035);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLM() {
        AppMethodBeat.i(241036);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241036);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLN() {
        AppMethodBeat.i(241037);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241037);
        throw nVar;
    }

    @Override // com.tencent.d.b.as
    public final void dLO() {
        AppMethodBeat.i(241038);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
        AppMethodBeat.o(241038);
        throw nVar;
    }
}
