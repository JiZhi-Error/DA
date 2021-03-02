package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.j;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004J\u0012\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001f\u001a\u00020\u0004J\u0012\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020/J\u0010\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020)J\"\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020<2\u0006\u0010(\u001a\u00020)J\u000e\u0010=\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0004J@\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020\u0006J2\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010D\u001a\u00020H2\u0006\u0010G\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020/J\u000e\u0010K\u001a\u00020L2\u0006\u0010(\u001a\u00020)J\u000e\u0010M\u001a\u00020L2\u0006\u0010(\u001a\u00020)J\u0006\u0010N\u001a\u00020\u001dJ\u000e\u0010N\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004J\u001a\u0010O\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020:2\u0006\u0010P\u001a\u00020QH\u0002J \u0010R\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020QH\u0002J\u001a\u0010V\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020:2\u0006\u0010U\u001a\u00020WH\u0002J \u0010X\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020WH\u0002J\u001a\u0010Y\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020:2\u0006\u0010U\u001a\u00020ZH\u0002J \u0010[\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020ZH\u0002J\u001e\u0010\\\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020TJ0\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010(\u001a\u00020)2\u0006\u00109\u001a\u00020:2\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u0006J\u001a\u0010b\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020:2\u0006\u0010U\u001a\u00020cH\u0002J \u0010d\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020cH\u0002J\u001a\u0010e\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020:2\u0006\u0010U\u001a\u00020cH\u0002J \u0010f\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020cH\u0002J&\u0010g\u001a\u00020H2\u0006\u0010?\u001a\u00020@2\u0006\u0010h\u001a\u00020/2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002J\u000e\u0010i\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010j\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010k\u001a\u00020-J\u0016\u0010l\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil;", "", "()V", "TAG", "", "damp", "", "getDamp", "()I", "setDamp", "(I)V", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "validAreaRect", "getValidAreaRect", "setValidAreaRect", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "visibleRect", "getVisibleRect", "checkMD5", "", "file", "destMD5", "cleanExpiredTask", "", "cleanNullData", "taskId", "cleanUnAvailableData", "convertBundleToJson", "bundle", "Landroid/os/Bundle;", "convertJsonToBundle", "jsonStr", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getLastDataIfNoMix", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "limitTime", "", "getRemuxTask", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "baseItemData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "context", "Landroid/content/Context;", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "getUserData", "insertRemuxTask", "videoMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "editorData", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "extraConfig", "expiredTime", "blurBgPath", "scene", "", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "onUnSerializeStoryDataDrawingRect", "", "onUnSerializeStoryDataValidRect", "reStartMix", "reshowEmojiEditorItem", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "item", "reshowLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "reshowLyricsItem", "reshowPositionEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "targetWidth", "targetHeight", "targetRotation", "reshowTextEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "reshowTextItem", "reshowTipEditorItem", "reshowTipItem", "serializeStoryDataToByteArray", "timeStamp", "signVideoMixTime", "updateByLocal", "editData", "updateRemuxTaskState", "state", "plugin-recordvideo_release"})
public final class e {
    private static final d BJm;
    private static Rect BKm = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private static Rect BKn = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private static int BKo = 54;
    public static final e BKp = new e();
    private static final Rect vPN = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);

    static {
        AppMethodBeat.i(75216);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginVideoEditor.class);
        p.g(ah, "MMKernel.plugin(PluginVideoEditor::class.java)");
        BJm = ((PluginVideoEditor) ah).getVideoEditorDataStorage();
        AppMethodBeat.o(75216);
    }

    private e() {
    }

    public static Rect eIR() {
        return BKm;
    }

    public static Rect eIS() {
        return BKn;
    }

    public static Rect getVisibleRect() {
        return vPN;
    }

    public static int eIT() {
        return BKo;
    }

    public static String a(VideoMixer videoMixer, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list, ald ald, long j2, String str, int i2) {
        AppMethodBeat.i(75194);
        p.h(videoMixer, "videoMixer");
        p.h(list, "editorData");
        p.h(ald, "extraConfig");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = new c();
            cVar.field_taskId = MD5Util.getMD5String(new StringBuilder().append(cVar.hashCode() & Integer.MAX_VALUE).append('#').append(currentTimeMillis).toString());
            cVar.field_timeStamp = currentTimeMillis;
            cVar.field_mixRetryTime = 0;
            cVar.field_baseItemData = a(videoMixer, currentTimeMillis, list);
            c.b bVar = c.b.BKk;
            cVar.field_status = c.b.eIO();
            if (j2 > 2592000000L) {
                j2 = 2592000000L;
            }
            cVar.field_expiredTime = j2;
            VideoMixer.MixConfig eJf = videoMixer.eJf();
            cVar.field_targetWidth = eJf.videoWidth;
            cVar.field_targetHeight = eJf.videoHeight;
            cVar.field_videoBitrate = eJf.videoBitrate;
            cVar.field_audioBitrate = eJf.audioBitrate;
            cVar.field_audioSampleRate = eJf.audioSampleRate;
            cVar.field_audioChannelCount = eJf.audioChannelCount;
            cVar.field_frameRate = eJf.videoFrameRate;
            cVar.field_videoRotate = eJf.ihS;
            cVar.field_extraConfig = ald.toByteArray();
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            cVar.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.eKW().eJN();
            CaptureDataManager captureDataManager = CaptureDataManager.BOb;
            p.g(captureDataManager, "CaptureDataManager.INSTANCE");
            cVar.field_userData = au(captureDataManager.getExtData());
            if (str == null) {
                str = "";
            }
            cVar.field_blurBgPath = str;
            cVar.field_fromScene = i2;
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + eJf + ", ret:" + BJm.insert(cVar));
            a aVar = a.BKb;
            String str2 = cVar.field_taskId;
            p.g(str2, "videoEditorData.field_taskId");
            a.bT(i2, str2);
            String str3 = cVar.field_taskId;
            AppMethodBeat.o(75194);
            return str3;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", e2, "", new Object[0]);
            AppMethodBeat.o(75194);
            return null;
        }
    }

    public static /* synthetic */ String a(byte[] bArr, VideoMixer.MixConfig mixConfig, byte[] bArr2) {
        AppMethodBeat.i(75196);
        String a2 = a(bArr, mixConfig, bArr2, 6);
        AppMethodBeat.o(75196);
        return a2;
    }

    public static String a(byte[] bArr, VideoMixer.MixConfig mixConfig, byte[] bArr2, int i2) {
        AppMethodBeat.i(75195);
        p.h(bArr, "baseItemData");
        p.h(mixConfig, "mixConfig");
        p.h(bArr2, "extraConfig");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = new c();
            cVar.field_taskId = MD5Util.getMD5String(new StringBuilder().append(cVar.hashCode() & Integer.MAX_VALUE).append('#').append(currentTimeMillis).toString());
            cVar.field_timeStamp = currentTimeMillis;
            cVar.field_mixRetryTime = 0;
            aio aio = new aio();
            try {
                aio.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                aio = null;
            }
            aio aio2 = aio;
            if (aio2 != null) {
                aio2.timeStamp = currentTimeMillis;
                aio2.LrZ = a(aio2);
            }
            cVar.field_baseItemData = aio2 != null ? aio2.toByteArray() : null;
            c.b bVar = c.b.BKk;
            cVar.field_status = c.b.eIO();
            cVar.field_expiredTime = 2592000000L;
            cVar.field_targetWidth = mixConfig.videoWidth;
            cVar.field_targetHeight = mixConfig.videoHeight;
            cVar.field_videoBitrate = mixConfig.videoBitrate;
            cVar.field_audioBitrate = mixConfig.audioBitrate;
            cVar.field_audioSampleRate = mixConfig.audioSampleRate;
            cVar.field_audioChannelCount = mixConfig.audioChannelCount;
            cVar.field_frameRate = mixConfig.videoFrameRate;
            cVar.field_videoRotate = mixConfig.ihS;
            cVar.field_extraConfig = bArr2;
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            cVar.field_reportInfo = com.tencent.mm.plugin.recordvideo.d.c.eKW().eJN();
            CaptureDataManager captureDataManager = CaptureDataManager.BOb;
            p.g(captureDataManager, "CaptureDataManager.INSTANCE");
            cVar.field_userData = au(captureDataManager.getExtData());
            cVar.field_blurBgPath = "";
            cVar.field_fromScene = i2;
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "insertRemuxTask:" + mixConfig + ", ret:" + BJm.insert(cVar));
            a aVar = a.BKb;
            String str = cVar.field_taskId;
            p.g(str, "videoEditorData.field_taskId");
            a.bT(i2, str);
            String str2 = cVar.field_taskId;
            AppMethodBeat.o(75195);
            return str2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.mix_background.VideoEditStorageUtil", e3, "", new Object[0]);
            AppMethodBeat.o(75195);
            return null;
        }
    }

    public static c aLf(String str) {
        AppMethodBeat.i(75197);
        p.h(str, "taskId");
        c aLe = BJm.aLe(str);
        AppMethodBeat.o(75197);
        return aLe;
    }

    public static void aLg(String str) {
        AppMethodBeat.i(75198);
        p.h(str, "taskId");
        c aLe = BJm.aLe(str);
        if (aLe != null) {
            aLe.field_mixRetryTime++;
            BJm.a(str, aLe);
            AppMethodBeat.o(75198);
            return;
        }
        AppMethodBeat.o(75198);
    }

    public static void fk(String str, int i2) {
        AppMethodBeat.i(75199);
        p.h(str, "taskId");
        c aLe = BJm.aLe(str);
        if (aLe != null) {
            aLe.field_status = i2;
            BJm.a(str, aLe);
            AppMethodBeat.o(75199);
            return;
        }
        AppMethodBeat.o(75199);
    }

    public static void eIU() {
        AppMethodBeat.i(75200);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "clean expired task, num:".concat(String.valueOf(BJm.db.delete(d.TABLE, "timeStamp< ?-expiredTime", new String[]{new StringBuilder().append(System.currentTimeMillis()).toString()}))));
        AppMethodBeat.o(75200);
    }

    public static /* synthetic */ c eIV() {
        AppMethodBeat.i(75201);
        c HX = BJm.HX(System.currentTimeMillis());
        AppMethodBeat.o(75201);
        return HX;
    }

    private static byte[] a(VideoMixer videoMixer, long j2, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list) {
        long j3;
        AppMethodBeat.i(75202);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "is running serialize the videoEditorInfo to bytearray");
        aio aio = new aio();
        com.tencent.mm.plugin.recordvideo.b.c cVar = videoMixer.BKP.BKI;
        float[] fArr = videoMixer.BKP.BKV;
        float[] fArr2 = videoMixer.BKP.BKW;
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "input the timeStamp is ".concat(String.valueOf(j2)));
        if (cVar.BMY == 3) {
            j.a aVar = j.ijn;
            if (s.YS(j.a.Hp(cVar.BMT))) {
                j.a aVar2 = j.ijn;
                aio.LrT = j.a.Hp(cVar.BMT);
            }
        }
        aio.timeStamp = j2;
        if (cVar.BMV == -1) {
            j3 = 0;
        } else {
            j3 = cVar.BMV;
        }
        aio.startTime = j3;
        aio.endTime = cVar.BMW;
        aio.thumbPath = cVar.BMU;
        aio.videoPath = cVar.BMT;
        aio.iqf = cVar.iqf;
        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(cVar.BMT);
        if (aNx != null && (cVar.BMW == -1 || cVar.BMW == 0)) {
            aio.endTime = (long) aNx.videoDuration;
        }
        if (!Util.isNullOrNil(cVar.BMZ)) {
            com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            aio.endTime = (long) com.tencent.mm.plugin.recordvideo.b.e.eJs();
        }
        aio.endTime = aio.endTime > 0 ? aio.endTime : 0;
        aio.Lsc.addAll(cVar.BMZ);
        aio.idq = cVar.BMY;
        aio.LrU = (int) fArr[0];
        aio.LrW = (int) fArr[1];
        aio.LrV = (int) fArr[2];
        aio.LrX = (int) fArr[3];
        aio.Lna = new LinkedList<>();
        if (fArr2 != null) {
            aio.Lse = (int) fArr2[0];
            aio.Lsg = (int) fArr2[1];
            aio.Lsf = (int) fArr2[2];
            aio.Lsh = (int) fArr2[3];
        }
        AudioCacheInfo audioCacheInfo = cVar.uPh;
        if (audioCacheInfo != null) {
            aio.iiv = audioCacheInfo.cachePath;
            aio.BOX = audioCacheInfo.BOX;
            aio.musicUrl = audioCacheInfo.musicUrl;
            aio.aXa = audioCacheInfo.aXa;
            aio.BPa = audioCacheInfo.BPa;
            aio.Lsa = audioCacheInfo.position;
            aio.Lsb = audioCacheInfo.BPd;
        }
        aio.LrZ = a(aio);
        for (T t : list) {
            jn jnVar = new jn();
            jnVar.dataType = t.Cex.value;
            jnVar.KOd = z.aC(t.eMk().toByteArray());
            aio.Lna.add(jnVar);
        }
        byte[] byteArray = aio.toByteArray();
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "storyEditorItem " + aio.videoPath + " thumb " + aio.thumbPath + " and result " + s.YS(aio.thumbPath) + " music " + aio.iiv + " ret " + Util.getSizeKB(((long) byteArray.length) * 1) + '}');
        p.g(byteArray, "ret");
        AppMethodBeat.o(75202);
        return byteArray;
    }

    public static void aLh(String str) {
        AppMethodBeat.i(75203);
        p.h(str, "taskId");
        d dVar = BJm;
        p.h(str, "taskId");
        dVar.db.delete(d.TABLE, "taskId=?", new String[]{String.valueOf(str)});
        AppMethodBeat.o(75203);
    }

    public static void aLi(String str) {
        byte[] bArr;
        String str2;
        String str3 = null;
        AppMethodBeat.i(75204);
        p.h(str, "taskId");
        c aLe = BJm.aLe(str);
        aio aio = new aio();
        if (aLe != null) {
            bArr = aLe.field_baseItemData;
        } else {
            bArr = null;
        }
        try {
            aio.parseFrom(bArr);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        Log.printInfoStack("MicroMsg.mix_background.VideoEditStorageUtil", "cleanUnAvailableData, videoPath " + aio2 + "?.videoPath", new Object[0]);
        if (aio2 != null && aio2.iqf) {
            s.deleteFile(aio2.videoPath);
        }
        s.deleteFile(aio2 != null ? aio2.LrT : null);
        if (aio2 != null) {
            str2 = aio2.iiv;
        } else {
            str2 = null;
        }
        s.deleteFile(str2);
        if (aio2 != null) {
            str3 = aio2.thumbPath;
        }
        s.deleteFile(str3);
        AppMethodBeat.o(75204);
    }

    public static void aLj(String str) {
        AppMethodBeat.i(75205);
        p.h(str, "taskId");
        c aLe = BJm.aLe(str);
        if (aLe != null) {
            aLe.field_mixRetryTime = 0;
            c.b bVar = c.b.BKk;
            aLe.field_status = c.b.eIO();
            BJm.a(aLe.bjl(), aLe);
            f fVar = f.BKw;
            f.a(aLe, null);
        }
        AppMethodBeat.o(75205);
    }

    public static void eIW() {
        AppMethodBeat.i(75206);
        f fVar = f.BKw;
        f.eIX();
        AppMethodBeat.o(75206);
    }

    private static edo a(aio aio) {
        AppMethodBeat.i(75207);
        p.h(aio, "storyEditorProtoData");
        edo edo = new edo();
        edo.NdT = s.bhK(aio.LrT);
        edo.NdS = s.bhK(aio.iiv);
        if (!Util.isNullOrNil(aio.Lsc)) {
            edo.NdR = "";
            edo.NdV = "";
            Iterator<String> it = aio.Lsc.iterator();
            while (it.hasNext()) {
                edo.NdV += s.bhK(it.next());
            }
        } else {
            edo.NdR = s.bhK(aio.videoPath);
            edo.NdV = "";
        }
        if (com.tencent.matrix.trace.g.b.eP(edo.NdR)) {
            edo.NdR = "";
        }
        edo.NdU = s.bhK(aio.thumbPath);
        AppMethodBeat.o(75207);
        return edo;
    }

    public static ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a(LinkedList<jn> linkedList, Context context) {
        AppMethodBeat.i(75208);
        p.h(linkedList, "baseItemData");
        p.h(context, "context");
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList = new ArrayList<>();
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "get the editor data which is waiting for run mixing");
        for (T t : linkedList) {
            int i2 = t.dataType;
            if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TEXT.value) {
                q qVar = new q(t);
                r rVar = new r(context);
                p.h(qVar, "item");
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c cVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(rVar.c(qVar), qVar.gT);
                ain ain = new ain();
                ain.start = qVar.Cev.getStart();
                ain.boX = qVar.Cev.getEnd();
                cVar.Cgj = ain;
                arrayList.add(cVar);
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.EMOJI.value) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn) t);
                EmojiInfo emojiInfo = eVar.gWm;
                if (emojiInfo == null) {
                    p.hyc();
                }
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e eVar2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(emojiInfo, eVar.gT);
                ain ain2 = new ain();
                ain2.start = eVar.Cev.getStart();
                ain2.boX = eVar.Cev.getEnd();
                eVar2.Cgj = ain2;
                arrayList.add(eVar2);
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.p pVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(context);
                k kVar = new k(t);
                p.h(kVar, "item");
                arrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(pVar.b(kVar), kVar.gT));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TIP.value) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.s sVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(context);
                q qVar2 = new q(t);
                p.h(qVar2, "item");
                arrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(sVar.c(qVar2), qVar2.gT));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.LYRICS.value) {
                arrayList.add(new m(context).b(new com.tencent.mm.plugin.recordvideo.ui.editor.item.l(t)));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION.value) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION;
                SKBuiltinBuffer_t sKBuiltinBuffer_t = t.KOd;
                p.g(sKBuiltinBuffer_t, "it.itemData");
                com.tencent.mm.bw.b buffer = sKBuiltinBuffer_t.getBuffer();
                p.g(buffer, "it.itemData.buffer");
                byte[] bArr = buffer.zy;
                p.g(bArr, "it.itemData.buffer.bytes");
                arrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(dVar, bArr)));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION.value) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar2 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION;
                SKBuiltinBuffer_t sKBuiltinBuffer_t2 = t.KOd;
                p.g(sKBuiltinBuffer_t2, "it.itemData");
                com.tencent.mm.bw.b buffer2 = sKBuiltinBuffer_t2.getBuffer();
                p.g(buffer2, "it.itemData.buffer");
                byte[] bArr2 = buffer2.zy;
                p.g(bArr2, "it.itemData.buffer.bytes");
                arrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(dVar2, bArr2)));
            }
        }
        AppMethodBeat.o(75208);
        return arrayList;
    }

    public static float[] b(aio aio) {
        AppMethodBeat.i(75209);
        p.h(aio, "storyEditorProtoData");
        float[] fArr = {(float) aio.LrU, (float) aio.LrW, (float) aio.LrV, (float) aio.LrX};
        AppMethodBeat.o(75209);
        return fArr;
    }

    public static float[] c(aio aio) {
        AppMethodBeat.i(237238);
        p.h(aio, "storyEditorProtoData");
        float[] fArr = {(float) aio.Lse, (float) aio.Lsg, (float) aio.Lsf, (float) aio.Lsh};
        AppMethodBeat.o(237238);
        return fArr;
    }

    public static void a(aio aio, Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(75210);
        p.h(aio, "storyEditorProtoData");
        p.h(context, "context");
        p.h(viewGroup, "itemLayout");
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story which has editor item");
        LinkedList<jn> linkedList = aio.Lna;
        p.g(linkedList, "storyEditorProtoData.baseItemData");
        for (T t : linkedList) {
            int i2 = t.dataType;
            if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TEXT.value) {
                MMHandlerThread.postToMainThread(new a(t, context, viewGroup, aio));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.EMOJI.value) {
                MMHandlerThread.postToMainThread(new b(t, context, viewGroup, aio));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value) {
                MMHandlerThread.postToMainThread(new c(t, context, viewGroup, aio));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TIP.value) {
                MMHandlerThread.postToMainThread(new d(t, context, viewGroup, aio));
            } else if (i2 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.LYRICS.value) {
                MMHandlerThread.postToMainThread(new RunnableC1643e(t, context, viewGroup, aio));
            }
        }
        AppMethodBeat.o(75210);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$1"})
    static final class a implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ jn BKq;
        final /* synthetic */ ViewGroup BKr;
        final /* synthetic */ aio BKs;

        a(jn jnVar, Context context, ViewGroup viewGroup, aio aio) {
            this.BKq = jnVar;
            this.$context$inlined = context;
            this.BKr = viewGroup;
            this.BKs = aio;
        }

        public final void run() {
            AppMethodBeat.i(75189);
            e eVar = e.BKp;
            Context context = this.$context$inlined;
            ViewGroup viewGroup = this.BKr;
            jn jnVar = this.BKq;
            p.g(jnVar, LocaleUtil.ITALIAN);
            e.a(context, viewGroup, new q(jnVar));
            AppMethodBeat.o(75189);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$2"})
    static final class b implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ jn BKq;
        final /* synthetic */ ViewGroup BKr;
        final /* synthetic */ aio BKs;

        b(jn jnVar, Context context, ViewGroup viewGroup, aio aio) {
            this.BKq = jnVar;
            this.$context$inlined = context;
            this.BKr = viewGroup;
            this.BKs = aio;
        }

        public final void run() {
            AppMethodBeat.i(75190);
            e eVar = e.BKp;
            Context context = this.$context$inlined;
            ViewGroup viewGroup = this.BKr;
            jn jnVar = this.BKq;
            p.g(jnVar, LocaleUtil.ITALIAN);
            e.a(context, viewGroup, new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(jnVar));
            AppMethodBeat.o(75190);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$3"})
    static final class c implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ jn BKq;
        final /* synthetic */ ViewGroup BKr;
        final /* synthetic */ aio BKs;

        c(jn jnVar, Context context, ViewGroup viewGroup, aio aio) {
            this.BKq = jnVar;
            this.$context$inlined = context;
            this.BKr = viewGroup;
            this.BKs = aio;
        }

        public final void run() {
            AppMethodBeat.i(75191);
            e eVar = e.BKp;
            Context context = this.$context$inlined;
            ViewGroup viewGroup = this.BKr;
            jn jnVar = this.BKq;
            p.g(jnVar, LocaleUtil.ITALIAN);
            e.a(context, viewGroup, new k(jnVar));
            AppMethodBeat.o(75191);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$4"})
    static final class d implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ jn BKq;
        final /* synthetic */ ViewGroup BKr;
        final /* synthetic */ aio BKs;

        d(jn jnVar, Context context, ViewGroup viewGroup, aio aio) {
            this.BKq = jnVar;
            this.$context$inlined = context;
            this.BKr = viewGroup;
            this.BKs = aio;
        }

        public final void run() {
            AppMethodBeat.i(75192);
            e eVar = e.BKp;
            Context context = this.$context$inlined;
            ViewGroup viewGroup = this.BKr;
            jn jnVar = this.BKq;
            p.g(jnVar, LocaleUtil.ITALIAN);
            e.b(context, viewGroup, new q(jnVar));
            AppMethodBeat.o(75192);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/background/VideoEditStorageUtil$reshowStoryDataEditorItem$1$5"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.background.e$e  reason: collision with other inner class name */
    static final class RunnableC1643e implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ jn BKq;
        final /* synthetic */ ViewGroup BKr;
        final /* synthetic */ aio BKs;

        RunnableC1643e(jn jnVar, Context context, ViewGroup viewGroup, aio aio) {
            this.BKq = jnVar;
            this.$context$inlined = context;
            this.BKr = viewGroup;
            this.BKs = aio;
        }

        public final void run() {
            AppMethodBeat.i(75193);
            long j2 = this.BKs.endTime - this.BKs.startTime;
            jn jnVar = this.BKq;
            p.g(jnVar, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.recordvideo.ui.editor.item.l lVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l(jnVar);
            lVar.Ij(j2);
            e eVar = e.BKp;
            e.a(this.$context$inlined, this.BKr, lVar);
            AppMethodBeat.o(75193);
        }
    }

    public static com.tencent.mm.plugin.recordvideo.ui.editor.b.g a(aio aio, Context context, int i2, int i3, int i4) {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c2;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c3;
        AppMethodBeat.i(237239);
        p.h(aio, "storyEditorProtoData");
        p.h(context, "context");
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "reshow the fake story as frame retriever");
        ArrayList arrayList = new ArrayList();
        LinkedList<jn> linkedList = aio.Lna;
        p.g(linkedList, "storyEditorProtoData.baseItemData");
        for (T t : linkedList) {
            int i5 = t.dataType;
            if (i5 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TEXT.value) {
                p.g(t, LocaleUtil.ITALIAN);
                q qVar = new q(t);
                Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
                if (!qVar.isValid()) {
                    c3 = null;
                } else {
                    r rVar = new r(context);
                    rVar.b(qVar);
                    c3 = rVar.c((Matrix) null);
                }
                if (c3 != null) {
                    arrayList.add(c3);
                }
            } else if (i5 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.EMOJI.value) {
                p.g(t, LocaleUtil.ITALIAN);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn) t);
                Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji editor item");
                f fVar = new f(context);
                fVar.a(eVar);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c4 = fVar.c(null);
                if (c4 != null) {
                    arrayList.add(c4);
                }
            } else if (i5 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeM.value) {
                p.g(t, LocaleUtil.ITALIAN);
                k kVar = new k(t);
                Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
                com.tencent.mm.plugin.recordvideo.ui.editor.item.p pVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(context);
                pVar.a(kVar);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c5 = pVar.c(null);
                if (c5 != null) {
                    arrayList.add(c5);
                }
            } else if (i5 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TIP.value) {
                p.g(t, LocaleUtil.ITALIAN);
                q qVar2 = new q(t);
                Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text editor item");
                if (!qVar2.isValid()) {
                    c2 = null;
                } else {
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.s sVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(context);
                    sVar.b(qVar2);
                    c2 = sVar.c((Matrix) null);
                }
                if (c2 != null) {
                    arrayList.add(c2);
                }
            } else if (i5 == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.LYRICS.value) {
                p.g(t, LocaleUtil.ITALIAN);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.l lVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.l(t);
                lVar.Ij(aio.endTime - aio.startTime);
                Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position editor item");
                m mVar = new m(context);
                mVar.a(lVar);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c6 = mVar.c(null);
                if (c6 != null) {
                    arrayList.add(c6);
                }
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(237239);
            return null;
        } else if (i3 == 0 || i2 == 0) {
            Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "error width " + i2 + " height " + i3);
            AppMethodBeat.o(237239);
            return null;
        } else {
            com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
            String str = aio.videoPath;
            p.g(str, "storyEditorProtoData.videoPath");
            d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(str);
            if (aio.iqf || aLQ == null || aLQ.Cio) {
                com.tencent.mm.plugin.recordvideo.ui.editor.b.g gVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(aio), c(aio), arrayList, i2, i3, 0, 0, i4, false, null, 768));
                AppMethodBeat.o(237239);
                return gVar;
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.b.g gVar2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(b(aio), c(aio), arrayList, i2, i3, aLQ.width, aLQ.height, i4, false, null, 768));
            AppMethodBeat.o(237239);
            return gVar2;
        }
    }

    public static ald aLk(String str) {
        AppMethodBeat.i(237240);
        p.h(str, "taskId");
        c aLf = aLf(str);
        if (aLf == null) {
            AppMethodBeat.o(237240);
            return null;
        }
        ald ald = new ald();
        try {
            ald.parseFrom(aLf.field_extraConfig);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            ald = null;
        }
        ald ald2 = ald;
        AppMethodBeat.o(237240);
        return ald2;
    }

    public static Bundle aLl(String str) {
        AppMethodBeat.i(75214);
        Bundle bundle = new Bundle();
        if (str != null) {
            if (!(str.length() == 0)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                p.g(keys, "jsonObject.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof String) {
                        bundle.putString(next, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(next, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(next, ((Number) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(next, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(next, ((Character) obj).charValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(next, ((Number) obj).floatValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(next, ((Number) obj).shortValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(next, ((Number) obj).doubleValue());
                    } else {
                        bundle.putString(next, obj.toString());
                    }
                }
                AppMethodBeat.o(75214);
                return bundle;
            }
        }
        AppMethodBeat.o(75214);
        return bundle;
    }

    private static String au(Bundle bundle) {
        AppMethodBeat.i(75215);
        if (bundle == null) {
            AppMethodBeat.o(75215);
            return "";
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.o(75215);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            Object obj = bundle.get(str);
            if (obj instanceof List) {
                jSONObject.put(str, new JSONArray((Collection) obj));
            } else {
                jSONObject.put(str, bundle.get(str));
            }
        }
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "jsonObject.toString()");
        AppMethodBeat.o(75215);
        return jSONObject2;
    }

    public static final /* synthetic */ void a(Context context, ViewGroup viewGroup, q qVar) {
        AppMethodBeat.i(237241);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text item view");
        if (qVar.isValid()) {
            r rVar = new r(context);
            viewGroup.addView(rVar, new RelativeLayout.LayoutParams(-1, -1));
            rVar.b(qVar);
        }
        AppMethodBeat.o(237241);
    }

    public static final /* synthetic */ void a(Context context, ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar) {
        AppMethodBeat.i(237242);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the emoji item view");
        f fVar = new f(context);
        viewGroup.addView(fVar, new RelativeLayout.LayoutParams(-1, -1));
        fVar.a(eVar);
        fVar.resume();
        AppMethodBeat.o(237242);
    }

    public static final /* synthetic */ void a(Context context, ViewGroup viewGroup, k kVar) {
        AppMethodBeat.i(237243);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position item view");
        com.tencent.mm.plugin.recordvideo.ui.editor.item.p pVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p(context);
        viewGroup.addView(pVar, new RelativeLayout.LayoutParams(-1, -1));
        pVar.a(kVar);
        AppMethodBeat.o(237243);
    }

    public static final /* synthetic */ void b(Context context, ViewGroup viewGroup, q qVar) {
        AppMethodBeat.i(237244);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the text item view");
        if (qVar.isValid()) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.s sVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(context);
            viewGroup.addView(sVar, new RelativeLayout.LayoutParams(-1, -1));
            sVar.b(qVar);
        }
        AppMethodBeat.o(237244);
    }

    public static final /* synthetic */ void a(Context context, ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.ui.editor.item.l lVar) {
        AppMethodBeat.i(237245);
        Log.i("MicroMsg.mix_background.VideoEditStorageUtil", "fake story reshow the position item view");
        m mVar = new m(context);
        viewGroup.addView(mVar, new RelativeLayout.LayoutParams(-1, -1));
        mVar.a(lVar);
        AppMethodBeat.o(237245);
    }
}
