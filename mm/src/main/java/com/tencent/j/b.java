package com.tencent.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Size;
import com.tencent.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.aa;
import com.tencent.mm.xeffect.effect.ab;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.j;
import com.tencent.mm.xeffect.effect.r;
import com.tencent.mm.xeffect.effect.u;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExtension;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;
import io.flutter.view.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010'H\u0016J(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0012\u0010/\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000104H\u0016J\u0012\u00105\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u00109\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010H\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020K2\b\u0010\"\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u00020N2\b\u0010\"\u001a\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001a\u00020Q2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010R\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J \u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010X\u001a\u00020)2\u0006\u0010\\\u001a\u00020]H\u0016J\u0012\u0010^\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020]H\u0016J\u001c\u0010c\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010d\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010e\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010f\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010g\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010h\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010iH\u0016J\u0012\u0010j\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010kH\u0016J\u0014\u0010l\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010m\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010n\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010o\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010pH\u0016J\u0012\u0010q\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010rH\u0016J\u0012\u0010s\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010t\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010uH\u0016J\u0012\u0010v\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010w\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010xH\u0016J\u0012\u0010y\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010zH\u0016J\u0012\u0010{\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010|H\u0016J\u0012\u0010}\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010~H\u0016J\u0013\u0010\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0016\u0010\u0001\u001a\u0004\u0018\u00010!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0013\u0010\u0001\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u000107H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010zH\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010zH\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020!2\t\u0010\"\u001a\u0005\u0018\u00010\u0001H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/video_editor_videocomposition/VideoCompositionApiPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$VideoCompositionApi;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "()V", "compositionDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/video_editor_videocomposition/VideoCompositionPluginData;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "effectManagerDataMap", "Lcom/tencent/video_editor_videocomposition/EffectManagerData;", "eventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "exportChannel", "Lio/flutter/plugin/common/EventChannel;", "handler", "Landroid/os/Handler;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "playerCallbackChannel", "playerMap", "Lcom/tencent/video_editor_videocomposition/VideoCompositionPlayerPluginData;", "random", "Ljava/util/Random;", "textureRegistry", "Lio/flutter/view/TextureRegistry;", "thumbListChannel", "trackMap", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "addEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$BoolReply;", "arg", "Lcom/tencent/pigeon/VideoCompositionPluginApi$AddEffectRequest;", "addTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackRequest;", "bringToFront", "Lcom/tencent/pigeon/VideoCompositionPluginApi$BringToFrontRequest;", "callbackFrameData", "", "time", "bitmap", "Landroid/graphics/Bitmap;", "trackId", "compositionId", "cancelExport", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CancelExportRequest;", "clearEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$ClearEffectRequest;", "compositionSetPlayRange", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPlayRangeRequest;", "create", "Lcom/tencent/pigeon/VideoCompositionPluginApi$IntReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$IntRequest;", "createComposition", "createEffectByBinary", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectByBinaryRequest;", "createEffectByPath", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectByPathRequest;", "createEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectManagerRequest;", "createPlayer", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreatePlayerRequest;", "createTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateTrackRequest;", "destroyEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$DestroyEffectManagerRequest;", AssetExtension.SCENE_EXPORT, "Lcom/tencent/pigeon/VideoCompositionPluginApi$ExportRequest;", "getCompositionDuration", "getCompositionLabel", "Lcom/tencent/pigeon/VideoCompositionPluginApi$GetCompositionLabelRequest;", "getPAGInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGInfoReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGInfoRequest;", "getPAGTemplateInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGTemplateInfoReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGTemplateInfoRequest;", "getTrackInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackInfoReply;", "getVieoEnhancementEnabled", "Lcom/tencent/pigeon/VideoCompositionPluginApi$GetVideoEnhancementEnabledRequest;", "isGif", "", "bytes", "", "onAttachedToEngine", "applicationContext", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onCancel", "arguments", "", "onDetachedFromEngine", "p0", "onListen", "sink", "playerPause", "playerRefreshSurface", "playerRelease", "playerSeek", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SeekRequest;", "playerSetLoop", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetLoopRequest;", "playerSetPlayRange", "playerStart", "playerStop", "playerUpdateComposition", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateCompositionRequest;", "playerUpdateDisplaySize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateDisplaySizeRequest;", "release", "removeEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RemoveEffectRequest;", "removeTrack", "requestTrackThumbs", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackThumbsRequest;", "setCompositionRenderArea", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RenderAreaRequest;", "setEffectLayout", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectLayoutRequest;", "setEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectManagerRequest;", "setEffectParams", "Lcom/tencent/pigeon/VideoCompositionPluginApi$EffectParamsRequest;", "setEffectSize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectSizeRequest;", "setEffectText", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectTextRequest;", "setEffectTimeRange", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectTimeRangeRequest;", "setEnableOriginSound", "Lcom/tencent/pigeon/VideoCompositionPluginApi$EnableOriginSoundRequest;", "setPAGEffectCheckMarker", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPAGEffectCheckMarkerRequest;", "setPAGTemplateText", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPAGTemplateTextRequest;", "setPlayerCallback", "setPlayerProfileCallback", "setRenderSize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RenderSizeRequest;", "setTrackCropArea", "setTrackInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackInfoRequest;", "setTrackRenderArea", "setVideoEnhancement", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetVideoEnhancementRequest;", "setVideoEnhancementEffectJsonConfig", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetVideoEnhancementEffectJsonConfigRequest;", "updateCropRect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateRectRequest;", "updateTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateTrackRequest;", "Companion", "video_editor_videocomposition_release"})
public final class b extends a.at implements io.flutter.embedding.engine.plugins.a, d.c {
    public static final a StI = new a((byte) 0);
    private io.flutter.view.c StA;
    private final HashMap<Long, d> StB = new HashMap<>();
    private final HashMap<Long, com.tencent.mm.videocomposition.d> StC = new HashMap<>();
    private final HashMap<Long, a> StD = new HashMap<>();
    private io.flutter.plugin.a.d StE;
    private d.a StF;
    private k StG;
    private k StH;
    private Context context;
    private Handler handler;
    private final Random random = new Random();
    private final HashMap<Long, c> uPC = new HashMap<>();
    private k wJr;

    static {
        AppMethodBeat.i(199370);
        AppMethodBeat.o(199370);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$export$1$1"})
    static final class c extends q implements m<Boolean, Integer, x> {
        final /* synthetic */ b StJ;
        final /* synthetic */ a.n StN;
        final /* synthetic */ d StO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, a.n nVar, d dVar) {
            super(2);
            this.StJ = bVar;
            this.StN = nVar;
            this.StO = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Integer num) {
            AppMethodBeat.i(199293);
            final boolean booleanValue = bool.booleanValue();
            final int intValue = num.intValue();
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.c.AnonymousClass1 */
                final /* synthetic */ c StP;

                {
                    this.StP = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199292);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", this.StP.StO.id);
                    jSONObject.put("success", booleanValue);
                    jSONObject.put("retCode", intValue);
                    d.a aVar = this.StP.StJ.StF;
                    if (aVar != null) {
                        aVar.ba(jSONObject.toString());
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199292);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(199293);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "progress", "", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$export$1$2"})
    static final class d extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ b StJ;
        final /* synthetic */ a.n StN;
        final /* synthetic */ d StO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, a.n nVar, d dVar) {
            super(1);
            this.StJ = bVar;
            this.StN = nVar;
            this.StO = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(199295);
            final float floatValue = f2.floatValue();
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.d.AnonymousClass1 */
                final /* synthetic */ d StQ;

                {
                    this.StQ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199294);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", this.StQ.StO.id);
                    jSONObject.put("progress", Float.valueOf(floatValue));
                    d.a aVar = this.StQ.StJ.StF;
                    if (aVar != null) {
                        aVar.ba(jSONObject.toString());
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199294);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(199295);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012:\u0010\u0002\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003j\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005`\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "labels", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$getCompositionLabel$1$1"})
    static final class e extends q implements kotlin.g.a.b<HashMap<String, Pair<Integer, Long>>, x> {
        final /* synthetic */ n GLI;
        final /* synthetic */ b StJ;
        final /* synthetic */ d StS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar, n nVar, b bVar) {
            super(1);
            this.StS = dVar;
            this.GLI = nVar;
            this.StJ = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(HashMap<String, Pair<Integer, Long>> hashMap) {
            AppMethodBeat.i(199297);
            final HashMap<String, Pair<Integer, Long>> hashMap2 = hashMap;
            p.h(hashMap2, "labels");
            d dVar = this.StS;
            p.h(hashMap2, "value");
            if (!hashMap2.isEmpty()) {
                dVar.Sue.clear();
                dVar.Sue.putAll(hashMap2);
            }
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.e.AnonymousClass1 */
                final /* synthetic */ e StT;

                {
                    this.StT = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199296);
                    o[] oVarArr = new o[2];
                    oVarArr[0] = s.U("id", Long.valueOf(this.StT.GLI.id));
                    HashMap hashMap = hashMap2;
                    ArrayList arrayList = new ArrayList(hashMap.size());
                    for (Map.Entry entry : hashMap.entrySet()) {
                        arrayList.add(ae.e(s.U("path", entry.getKey()), s.U("label", ((Pair) entry.getValue()).first), s.U("cost", ((Pair) entry.getValue()).second)));
                    }
                    oVarArr[1] = s.U("labels", arrayList);
                    Map e2 = ae.e(oVarArr);
                    new StringBuilder("onGetCompositionLabel, retData:").append(e2);
                    k kVar = this.StT.StJ.wJr;
                    if (kVar != null) {
                        kVar.a("getCompositionLabel", e2, null);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199296);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(199297);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$requestTrackThumbs$1$1"})
    static final class f extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ b StJ;
        final /* synthetic */ z.d StV;
        final /* synthetic */ com.tencent.mm.videocomposition.c StW;
        final /* synthetic */ a.ao StX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(z.d dVar, com.tencent.mm.videocomposition.c cVar, b bVar, a.ao aoVar) {
            super(2);
            this.StV = dVar;
            this.StW = cVar;
            this.StJ = bVar;
            this.StX = aoVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(199299);
            long longValue = l.longValue();
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                b bVar = this.StJ;
                Long l2 = this.StX.RHm;
                p.g(l2, "arg.id");
                b.a(bVar, longValue, bitmap2, l2.longValue());
            }
            this.StV.SYE++;
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.f.AnonymousClass1 */
                final /* synthetic */ f StY;

                {
                    this.StY = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199298);
                    if (this.StY.StV.SYE >= this.StY.StX.cTo.length) {
                        this.StY.StW.destroy();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199298);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(199299);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$Companion;", "", "()V", "TAG", "", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "video_editor_videocomposition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(199369);
        AppMethodBeat.o(199369);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(199312);
        p.h(bVar, "p0");
        this.context = null;
        this.handler = null;
        k kVar = this.wJr;
        if (kVar != null) {
            kVar.a(null);
        }
        this.wJr = null;
        io.flutter.plugin.a.d dVar = this.StE;
        if (dVar != null) {
            dVar.a(null);
        }
        this.StE = null;
        k kVar2 = this.StG;
        if (kVar2 != null) {
            kVar2.a(null);
        }
        this.StG = null;
        k kVar3 = this.StH;
        if (kVar3 != null) {
            kVar3.a(null);
        }
        this.StH = null;
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        com.tencent.mm.videocomposition.c.Asq.evictAll();
        AppMethodBeat.o(199312);
    }

    @Override // com.tencent.d.a.at
    public final a.b b(a.x xVar) {
        AppMethodBeat.i(199313);
        a.b bVar = new a.b();
        if (xVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            com.tencent.mm.videocomposition.d dVar = this.StC.get(xVar.RHm);
            if (dVar != null) {
                dVar.iiw.set((int) xVar.RHN.doubleValue(), (int) xVar.RHO.doubleValue(), (int) xVar.RHP.doubleValue(), (int) xVar.RHQ.doubleValue());
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199313);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b c(a.x xVar) {
        AppMethodBeat.i(199314);
        a.b bVar = new a.b();
        if (xVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            com.tencent.mm.videocomposition.d dVar = this.StC.get(xVar.RHm);
            if (dVar != null) {
                dVar.Rha.set((int) xVar.RHN.doubleValue(), (int) xVar.RHO.doubleValue(), (int) xVar.RHP.doubleValue(), (int) xVar.RHQ.doubleValue());
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199314);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b f(a.r rVar) {
        AppMethodBeat.i(199315);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(rVar.RHm);
            if (cVar != null) {
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.pause();
                    bVar.BOc = Boolean.TRUE;
                } else {
                    bVar.BOc = Boolean.FALSE;
                }
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199315);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.am amVar) {
        long j2;
        AppMethodBeat.i(199316);
        a.b bVar = new a.b();
        com.tencent.mm.videocomposition.d dVar = this.StC.get(amVar.RHp);
        if (dVar == null) {
            bVar.BOc = Boolean.FALSE;
            AppMethodBeat.o(199316);
            return bVar;
        }
        p.g(dVar, "trackMap[arg.trackId] ?:…eturn reply\n            }");
        Long l = amVar.RHq;
        p.g(l, "arg.startTimeMs");
        dVar.KO(l.longValue());
        Long l2 = amVar.RHr;
        p.g(l2, "arg.endTimeMs");
        dVar.KP(l2.longValue());
        Long l3 = amVar.RHs;
        if (l3 != null) {
            j2 = l3.longValue();
        } else {
            j2 = 0;
        }
        dVar.KQ(j2);
        Long l4 = amVar.RHt;
        p.g(l4, "arg.trackEndTimeMs");
        dVar.KR(l4.longValue());
        if (!p.j(dVar.Rhc.path, amVar.RIg)) {
            dVar.Rhc.GAn = null;
        }
        com.tencent.mm.videocomposition.k kVar = dVar.Rhc;
        String str = amVar.RIg;
        p.g(str, "arg.transitionPath");
        kVar.setPath(str);
        com.tencent.mm.videocomposition.k kVar2 = dVar.Rhc;
        Long l5 = amVar.RIh;
        p.g(l5, "arg.transitionDuration");
        kVar2.duration = l5.longValue();
        dVar.dYT = (int) amVar.RIi.longValue();
        dVar.volume = (float) amVar.RIj.doubleValue();
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199316);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.c cVar) {
        ad adVar;
        AppMethodBeat.i(199317);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(cVar.RHk);
        if (!(aVar == null || (adVar = aVar.Sty.get(cVar.RHl)) == null)) {
            aVar.wet.Ou(adVar.id);
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199317);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ap apVar) {
        com.tencent.mm.videocomposition.play.a aVar;
        AppMethodBeat.i(199318);
        a.b bVar = new a.b();
        d dVar = this.StB.get(apVar.RHW);
        c cVar = this.uPC.get(apVar.RHo);
        if (!(dVar == null || cVar == null || (aVar = cVar.RhC) == null)) {
            n nVar = dVar.Gez;
            Boolean bool = apVar.RIk;
            p.g(bool, "arg.playAfterUpdate");
            boolean booleanValue = bool.booleanValue();
            Long l = apVar.RIl;
            p.g(l, "arg.seekTo");
            com.tencent.mm.videocomposition.play.a.a(aVar, nVar, booleanValue, l.longValue(), 4);
        }
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199318);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q a(a.r rVar) {
        AppMethodBeat.i(199319);
        a.q qVar = new a.q();
        if (rVar == null) {
            qVar.RHG = -1L;
        } else {
            d dVar = new d();
            Long l = rVar.RHm;
            p.g(l, "arg.id");
            dVar.id = l.longValue();
            n nVar = dVar.Gez;
            Long l2 = rVar.RHm;
            p.g(l2, "arg.id");
            nVar.id = l2.longValue();
            Long l3 = rVar.RHm;
            p.g(l3, "arg.id");
            this.StB.put(l3, dVar);
            qVar.RHG = rVar.RHm;
        }
        AppMethodBeat.o(199319);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.an anVar) {
        AppMethodBeat.i(199320);
        a.b bVar = new a.b();
        if (anVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            d dVar = this.StB.get(anVar.RHm);
            if (dVar == null) {
                bVar.BOc = Boolean.FALSE;
                AppMethodBeat.o(199320);
                return bVar;
            }
            com.tencent.mm.videocomposition.d dVar2 = this.StC.get(anVar.RHp);
            if (dVar2 != null) {
                Long l = anVar.RHp;
                p.g(l, "arg.trackId");
                p.g(dVar2, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
                dVar.StC.put(l, dVar2);
                dVar.Gez.e(dVar2);
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199320);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.as asVar) {
        AppMethodBeat.i(199321);
        a.b bVar = new a.b();
        d dVar = this.StB.get(asVar.RHm);
        if (dVar == null) {
            bVar.BOc = Boolean.FALSE;
            AppMethodBeat.o(199321);
            return bVar;
        }
        dVar.StC.remove(asVar.RHp);
        com.tencent.mm.videocomposition.d dVar2 = this.StC.get(asVar.RHp);
        if (dVar2 != null) {
            n nVar = dVar.Gez;
            int longValue = (int) asVar.RIm.longValue();
            p.g(dVar2, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            p.h(dVar2, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            int size = nVar.Gzn.size();
            if (longValue >= 0 && size > longValue) {
                nVar.Gzn.set(longValue, dVar2);
            }
        }
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199321);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b b(a.an anVar) {
        AppMethodBeat.i(199322);
        a.b bVar = new a.b();
        if (anVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            d dVar = this.StB.get(anVar.RHm);
            if (dVar == null) {
                bVar.BOc = Boolean.FALSE;
                AppMethodBeat.o(199322);
                return bVar;
            }
            dVar.StC.remove(anVar.RHp);
            com.tencent.mm.videocomposition.d dVar2 = this.StC.get(anVar.RHp);
            if (dVar2 != null) {
                n nVar = dVar.Gez;
                p.g(dVar2, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
                p.h(dVar2, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
                nVar.Gzn.remove(dVar2);
            }
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199322);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.af afVar) {
        AppMethodBeat.i(199323);
        a.b bVar = new a.b();
        c cVar = this.uPC.get(afVar.RHo);
        if (cVar != null) {
            com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
            if (aVar != null) {
                Boolean bool = afVar.RIa;
                p.g(bool, "arg.loop");
                aVar.setLoop(bool.booleanValue());
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        } else {
            bVar.BOc = Boolean.FALSE;
        }
        AppMethodBeat.o(199323);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b g(a.r rVar) {
        AppMethodBeat.i(199324);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(rVar.RHm);
            if (cVar != null) {
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.stop();
                    bVar.BOc = Boolean.TRUE;
                } else {
                    bVar.BOc = Boolean.FALSE;
                }
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199324);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b hjz() {
        AppMethodBeat.i(199325);
        a.b bVar = new a.b();
        AppMethodBeat.o(199325);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.m mVar) {
        AppMethodBeat.i(199326);
        a.b bVar = new a.b();
        d dVar = this.StB.get(mVar.RHm);
        if (dVar != null) {
            n nVar = dVar.Gez;
            if (nVar != null) {
                Boolean bool = mVar.RHx;
                p.g(bool, "arg.enable");
                nVar.wB(bool.booleanValue());
                x xVar = x.SXb;
            }
            bVar.BOc = Boolean.TRUE;
        } else {
            bVar.BOc = Boolean.FALSE;
        }
        AppMethodBeat.o(199326);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.al b(a.r rVar) {
        AppMethodBeat.i(199327);
        a.al alVar = new a.al();
        if (rVar == null) {
            AppMethodBeat.o(199327);
            return alVar;
        }
        com.tencent.mm.videocomposition.d dVar = this.StC.get(rVar.RHm);
        if (dVar == null) {
            AppMethodBeat.o(199327);
            return alVar;
        }
        p.g(dVar, "trackMap[arg.id] ?: run …   return reply\n        }");
        alVar.RHq = Long.valueOf(dVar.startTimeMs);
        alVar.RHr = Long.valueOf(dVar.endTimeMs);
        alVar.RHs = Long.valueOf(dVar.GGz);
        alVar.RHt = Long.valueOf(dVar.GGA);
        alVar.RId = Long.valueOf(dVar.GJB);
        alVar.RIf = Long.valueOf((long) dVar.Gzv);
        alVar.RIe = Long.valueOf((long) dVar.Gzu);
        AppMethodBeat.o(199327);
        return alVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b i(a.r rVar) {
        com.tencent.mm.videocomposition.play.a aVar;
        AppMethodBeat.i(199328);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(rVar.RHm);
            if (!(cVar == null || (aVar = cVar.RhC) == null)) {
                aVar.hft();
            }
        }
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199328);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q a(a.i iVar) {
        c.a aVar;
        long j2;
        com.tencent.mm.videocomposition.play.a aVar2 = null;
        AppMethodBeat.i(199329);
        a.q qVar = new a.q();
        d dVar = this.StB.get(iVar.RHm);
        c cVar = this.uPC.get(iVar.RHo);
        if (cVar != null) {
            aVar = cVar.Sud;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (cVar != null) {
                aVar2 = cVar.RhC;
            }
            if (aVar2 != null) {
                c.a aVar3 = cVar.Sud;
                if (aVar3 != null) {
                    j2 = aVar3.hxb();
                } else {
                    j2 = 0;
                }
                qVar.RHG = Long.valueOf(j2);
                new StringBuilder("createPlayer2 ").append(iVar.RHm).append(", reply ").append(qVar.RHG);
                AppMethodBeat.o(199329);
                return qVar;
            }
        }
        Long l = iVar.RHo;
        if (l.longValue() <= 0 || dVar == null) {
            qVar.RHG = -1L;
            new StringBuilder("createPlayer3 ").append(iVar.RHm).append(", reply ").append(qVar.RHG);
            AppMethodBeat.o(199329);
            return qVar;
        }
        n nVar = dVar.Gez;
        c cVar2 = new c();
        p.g(l, "playerId");
        cVar2.id = l.longValue();
        this.uPC.put(l, cVar2);
        io.flutter.view.c cVar3 = this.StA;
        if (cVar3 != null) {
            c.a hwY = cVar3.hwY();
            cVar2.Sud = hwY;
            Size hfp = nVar.hfp();
            com.tencent.mm.videocomposition.play.a aVar4 = new com.tencent.mm.videocomposition.play.a(nVar);
            SurfaceTexture surfaceTexture = hwY.surfaceTexture();
            cVar2.Gii = surfaceTexture;
            if (hfp.getWidth() > 0 && hfp.getHeight() > 0) {
                surfaceTexture.setDefaultBufferSize(hfp.getWidth(), hfp.getHeight());
                p.g(surfaceTexture, "surfaceTexture");
                aVar4.c(surfaceTexture, hfp.getWidth(), hfp.getHeight());
            }
            cVar2.RhC = aVar4;
            qVar.RHG = Long.valueOf(hwY.hxb());
            new StringBuilder("createPlayer4 ").append(iVar.RHm).append(", reply ").append(qVar.RHG);
        } else {
            qVar.RHG = -1L;
            new StringBuilder("createPlayer5 ").append(iVar.RHm).append(", reply ").append(qVar.RHG);
        }
        new StringBuilder("createPlayer6 ").append(iVar.RHm).append(", reply ").append(qVar.RHG);
        AppMethodBeat.o(199329);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ar arVar) {
        AppMethodBeat.i(199330);
        a.b bVar = new a.b();
        d dVar = this.StB.get(arVar.RHm);
        if (dVar != null) {
            dVar.Gez.t(new Rect((int) arVar.RHN.doubleValue(), (int) arVar.RHO.doubleValue(), (int) arVar.RHP.doubleValue(), (int) arVar.RHQ.doubleValue()));
        } else {
            bVar.BOc = Boolean.FALSE;
        }
        AppMethodBeat.o(199330);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.z zVar) {
        AppMethodBeat.i(199331);
        a.b bVar = new a.b();
        c cVar = this.uPC.get(zVar.RHo);
        if (cVar != null) {
            com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
            if (aVar != null) {
                Long l = zVar.RHR;
                p.g(l, "arg.timeMs");
                aVar.seekTo(l.longValue());
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        } else {
            bVar.BOc = Boolean.FALSE;
        }
        AppMethodBeat.o(199331);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.aq aqVar) {
        SurfaceTexture surfaceTexture;
        AppMethodBeat.i(199332);
        a.b bVar = new a.b();
        c cVar = this.uPC.get(aqVar.RHo);
        if (cVar == null) {
            bVar.BOc = Boolean.FALSE;
            AppMethodBeat.o(199332);
            return bVar;
        }
        p.g(cVar, "playerMap[arg.playerId] …eturn reply\n            }");
        com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
        if (aVar == null || aVar.RhI) {
            com.tencent.mm.videocomposition.play.a aVar2 = cVar.RhC;
            if (aVar2 != null) {
                aVar2.lX((int) aqVar.RHy.longValue(), (int) aqVar.RHz.longValue());
            }
        } else {
            com.tencent.mm.videocomposition.play.a aVar3 = cVar.RhC;
            if (!(aVar3 == null || (surfaceTexture = cVar.Gii) == null)) {
                surfaceTexture.setDefaultBufferSize((int) aqVar.RHy.longValue(), (int) aqVar.RHz.longValue());
                aVar3.c(surfaceTexture, (int) aqVar.RHy.longValue(), (int) aqVar.RHz.longValue());
            }
            cVar.RhC = aVar3;
        }
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199332);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q a(a.j jVar) {
        AppMethodBeat.i(199333);
        a.q qVar = new a.q();
        String str = jVar.path;
        p.g(str, "arg.path");
        com.tencent.mm.videocomposition.d dVar = new com.tencent.mm.videocomposition.d(str, (int) jVar.RHn.longValue());
        Long l = jVar.RHp;
        p.g(l, "arg.trackId");
        dVar.id = l.longValue();
        Long l2 = jVar.RHq;
        p.g(l2, "arg.startTimeMs");
        dVar.KO(l2.longValue());
        Long l3 = jVar.RHr;
        p.g(l3, "arg.endTimeMs");
        dVar.KP(l3.longValue());
        Long l4 = jVar.RHs;
        p.g(l4, "arg.trackStartTimeMs");
        dVar.KQ(l4.longValue());
        Long l5 = jVar.RHt;
        p.g(l5, "arg.trackEndTimeMs");
        dVar.KR(l5.longValue());
        Long l6 = jVar.RHp;
        p.g(l6, "arg.trackId");
        this.StC.put(l6, dVar);
        qVar.RHG = jVar.RHp;
        AppMethodBeat.o(199333);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.y yVar) {
        AppMethodBeat.i(199334);
        a.b bVar = new a.b();
        d dVar = this.StB.get(yVar.RHm);
        if (dVar != null) {
            n nVar = dVar.Gez;
            if (nVar != null) {
                nVar.lW((int) yVar.RHy.longValue(), (int) yVar.RHz.longValue());
                x xVar = x.SXb;
            }
            bVar.BOc = Boolean.TRUE;
        } else {
            bVar.BOc = Boolean.FALSE;
        }
        AppMethodBeat.o(199334);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q c(a.r rVar) {
        AppMethodBeat.i(199335);
        a.q qVar = new a.q();
        if (rVar == null) {
            qVar.RHG = -1L;
        } else {
            d dVar = this.StB.get(rVar.RHm);
            if (dVar != null) {
                qVar.RHG = Long.valueOf(dVar.Gez.getDurationMs());
            }
        }
        AppMethodBeat.o(199335);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.x xVar) {
        AppMethodBeat.i(199336);
        a.b bVar = new a.b();
        if (xVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            d dVar = this.StB.get(xVar.RHm);
            if (dVar != null) {
                n nVar = dVar.Gez;
                Rect rect = new Rect((int) xVar.RHN.doubleValue(), (int) xVar.RHO.doubleValue(), (int) xVar.RHP.doubleValue(), (int) xVar.RHQ.doubleValue());
                p.h(rect, "rect");
                com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setDisplayScreenCoordinate: ".concat(String.valueOf(rect)), new Object[0]);
                com.tencent.mm.videocomposition.b.g gVar = nVar.Rhs;
                if (gVar != null) {
                    gVar.lY(rect.width(), rect.height());
                }
                nVar.viewRect.set(rect);
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199336);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ai aiVar) {
        AppMethodBeat.i(199337);
        a.b bVar = new a.b();
        if (aiVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            d dVar = this.StB.get(aiVar.RHm);
            if (dVar != null) {
                n nVar = dVar.Gez;
                Long l = aiVar.RIc;
                p.g(l, "arg.start");
                long longValue = l.longValue();
                Long l2 = aiVar.end;
                p.g(l2, "arg.end");
                nVar.at(longValue, l2.longValue());
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199337);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b e(a.r rVar) {
        AppMethodBeat.i(199338);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(rVar.RHm);
            if (cVar != null) {
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.start();
                    bVar.BOc = Boolean.TRUE;
                } else {
                    bVar.BOc = Boolean.FALSE;
                }
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199338);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b h(a.r rVar) {
        AppMethodBeat.i(199339);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(rVar.RHm);
            if (cVar != null) {
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.release();
                }
                cVar.RhC = null;
                cVar.RhH = null;
                c.a aVar2 = cVar.Sud;
                if (aVar2 != null) {
                    aVar2.release();
                }
                SurfaceTexture surfaceTexture = cVar.Gii;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                this.uPC.remove(Long.valueOf(cVar.id));
                bVar.BOc = Boolean.TRUE;
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199339);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b b(a.ai aiVar) {
        AppMethodBeat.i(199340);
        a.b bVar = new a.b();
        if (aiVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            c cVar = this.uPC.get(aiVar.RHm);
            if (cVar != null) {
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    Long l = aiVar.RIc;
                    p.g(l, "arg.start");
                    long longValue = l.longValue();
                    Long l2 = aiVar.end;
                    p.g(l2, "arg.end");
                    aVar.at(longValue, l2.longValue());
                    bVar.BOc = Boolean.TRUE;
                } else {
                    bVar.BOc = Boolean.FALSE;
                }
            } else {
                bVar.BOc = Boolean.FALSE;
            }
        }
        AppMethodBeat.o(199340);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final void a(a.n nVar) {
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(199341);
        d dVar = this.StB.get(nVar.RHm);
        if (dVar == null) {
            p.hyc();
        }
        p.g(dVar, "compositionDataMap[arg.id]!!");
        d dVar2 = dVar;
        n nVar2 = dVar2.Gez;
        Size size = new Size((int) nVar.RHy.longValue(), (int) nVar.RHz.longValue());
        int longValue = (int) nVar.RHA.longValue();
        int longValue2 = (int) nVar.RHB.longValue();
        Long l = nVar.RHC;
        if (l != null) {
            i2 = (int) l.longValue();
        } else {
            i2 = 1;
        }
        Long l2 = nVar.RHD;
        if (l2 != null) {
            i3 = (int) l2.longValue();
        } else {
            i3 = 48000;
        }
        Long l3 = nVar.RHE;
        if (l3 != null) {
            i4 = (int) l3.longValue();
        } else {
            i4 = 44100;
        }
        Long l4 = nVar.RHF;
        if (l4 != null) {
            i5 = (int) l4.longValue();
        }
        n.b bVar = new n.b(size, longValue, longValue2, i2, i3, i4, i5);
        new StringBuilder("export crop rect ").append(nVar2.hfq());
        String str = nVar.path;
        p.g(str, "arg.path");
        nVar2.a(str, bVar, new c(this, nVar, dVar2), new d(this, nVar, dVar2));
        AppMethodBeat.o(199341);
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.d dVar) {
        n nVar;
        AssetExportSession assetExportSession;
        AppMethodBeat.i(199342);
        a.b bVar = new a.b();
        d dVar2 = this.StB.get(dVar.RHm);
        if (!(dVar2 == null || (nVar = dVar2.Gez) == null || (assetExportSession = nVar.exportSession) == null)) {
            assetExportSession.cancelExport();
        }
        bVar.BOc = Boolean.TRUE;
        AppMethodBeat.o(199342);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final void a(a.ao aoVar) {
        AppMethodBeat.i(199343);
        com.tencent.mm.videocomposition.d dVar = this.StC.get(aoVar.RHm);
        if (dVar != null) {
            c.a aVar = com.tencent.mm.videocomposition.c.RgU;
            p.g(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            p.h(dVar, "$this$copy");
            com.tencent.mm.videocomposition.d dVar2 = new com.tencent.mm.videocomposition.d(dVar.path, dVar.type);
            dVar2.id = dVar.id;
            dVar2.iiw.set(dVar.iiw);
            dVar2.Rha.set(dVar.Rha);
            dVar2.KQ(dVar.GGz);
            dVar2.KR(dVar.GGA);
            dVar2.KO(dVar.startTimeMs);
            dVar2.KP(dVar.endTimeMs);
            dVar2.GJB = dVar.GJB;
            dVar2.Gzu = dVar.Gzu;
            dVar2.Gzv = dVar.Gzv;
            com.tencent.mm.videocomposition.k kVar = dVar.Rhc;
            p.h(kVar, "$this$copy");
            com.tencent.mm.videocomposition.k kVar2 = new com.tencent.mm.videocomposition.k(kVar.path, kVar.GAn, kVar.duration);
            long j2 = kVar.startTime;
            if (kVar2.startTime != j2) {
                kVar2.startTime = j2;
                kVar2.bGB = true;
            }
            kVar2.endTime = kVar.endTime;
            kVar2.bGB = kVar.bGB;
            p.h(kVar2, "<set-?>");
            dVar2.Rhc = kVar2;
            dVar2.volume = dVar.volume;
            com.tencent.mm.videocomposition.c b2 = c.a.b(dVar2);
            b2.setSize((int) aoVar.RHy.longValue(), (int) aoVar.RHz.longValue());
            z.d dVar3 = new z.d();
            dVar3.SYE = 0;
            long[] jArr = aoVar.cTo;
            p.g(jArr, "arg.times");
            b2.b(kotlin.a.e.h(jArr), new f(dVar3, b2, this, aoVar));
            AppMethodBeat.o(199343);
            return;
        }
        AppMethodBeat.o(199343);
    }

    @Override // com.tencent.d.a.at
    public final void k(a.r rVar) {
        x xVar;
        AppMethodBeat.i(199344);
        if (rVar == null) {
            AppMethodBeat.o(199344);
            return;
        }
        c cVar = this.uPC.get(rVar.RHm);
        if (cVar != null) {
            if (cVar.RhC != null) {
                if (cVar.RhH != null) {
                    AppMethodBeat.o(199344);
                    return;
                }
                cVar.RhH = new g(cVar, this);
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.setPlayerCallback(cVar.RhH);
                    xVar = x.SXb;
                } else {
                    xVar = null;
                }
                if (xVar != null) {
                    AppMethodBeat.o(199344);
                    return;
                }
            }
            AppMethodBeat.o(199344);
            return;
        }
        AppMethodBeat.o(199344);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000w\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b¸\u0006\f"}, hxF = {"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setPlayerCallback$1$1$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$1"})
    public static final class g implements a.C2159a.AbstractC2160a {
        final /* synthetic */ b StJ;
        final /* synthetic */ c StZ;

        g(c cVar, b bVar) {
            this.StZ = cVar;
            this.StJ = bVar;
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dET() {
            AppMethodBeat.i(199300);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayCompleted");
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199300);
                return;
            }
            AppMethodBeat.o(199300);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEV() {
            AppMethodBeat.i(199301);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayError");
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199301);
                return;
            }
            AppMethodBeat.o(199301);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEU() {
            AppMethodBeat.i(199302);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayFirstFrame");
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199302);
                return;
            }
            AppMethodBeat.o(199302);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void Go(long j2) {
            AppMethodBeat.i(199303);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayProgress");
            jSONObject.put("progress", j2);
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199303);
                return;
            }
            AppMethodBeat.o(199303);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dER() {
            AppMethodBeat.i(199304);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayStarted");
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199304);
                return;
            }
            AppMethodBeat.o(199304);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dES() {
            AppMethodBeat.i(199305);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playerId", this.StZ.id);
            jSONObject.put("playerEvent", "onPlayStop");
            k kVar = this.StJ.StG;
            if (kVar != null) {
                kVar.a("playerCallback", jSONObject.toString(), null);
                AppMethodBeat.o(199305);
                return;
            }
            AppMethodBeat.o(199305);
        }
    }

    @Override // com.tencent.d.a.at
    public final void l(a.r rVar) {
        AppMethodBeat.i(199345);
        if (rVar == null) {
            AppMethodBeat.o(199345);
            return;
        }
        c cVar = this.uPC.get(rVar.RHm);
        if (cVar != null) {
            if (cVar.RhC != null) {
                if (cVar.RhE != null) {
                    AppMethodBeat.o(199345);
                    return;
                }
                cVar.RhE = new h(cVar, this);
                com.tencent.mm.videocomposition.play.a aVar = cVar.RhC;
                if (aVar != null) {
                    aVar.RhE = cVar.RhE;
                    AppMethodBeat.o(199345);
                    return;
                }
            }
            AppMethodBeat.o(199345);
            return;
        }
        AppMethodBeat.o(199345);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\b"}, hxF = {"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setPlayerProfileCallback$1$1$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$2"})
    public static final class h implements a.C2159a.c {
        final /* synthetic */ b StJ;
        final /* synthetic */ c StZ;

        h(c cVar, b bVar) {
            this.StZ = cVar;
            this.StJ = bVar;
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.c
        public final void Lc(final long j2) {
            AppMethodBeat.i(199308);
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.h.AnonymousClass1 */
                final /* synthetic */ h Sua;

                {
                    this.Sua = r3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199306);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("playerId", this.Sua.StZ.id);
                    jSONObject.put("profileEvent", "onUpdateComposition");
                    jSONObject.put("cost", j2);
                    k kVar = this.Sua.StJ.StG;
                    if (kVar != null) {
                        kVar.a("playerProfileCallback", jSONObject.toString(), null);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199306);
                    return xVar;
                }
            });
            AppMethodBeat.o(199308);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.c
        public final void Ld(final long j2) {
            AppMethodBeat.i(199309);
            com.tencent.mm.videocomposition.c.c.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.j.b.h.AnonymousClass2 */
                final /* synthetic */ h Sua;

                {
                    this.Sua = r3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(199307);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("playerId", this.Sua.StZ.id);
                    jSONObject.put("profileEvent", "onSeek");
                    jSONObject.put("cost", j2);
                    k kVar = this.Sua.StJ.StG;
                    if (kVar != null) {
                        kVar.a("playerProfileCallback", jSONObject.toString(), null);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(199307);
                    return xVar;
                }
            });
            AppMethodBeat.o(199309);
        }
    }

    @Override // com.tencent.d.a.at
    public final a.b j(a.r rVar) {
        HashMap<Long, com.tencent.mm.videocomposition.d> hashMap;
        AppMethodBeat.i(199346);
        a.b bVar = new a.b();
        if (rVar == null) {
            bVar.BOc = Boolean.FALSE;
        } else {
            d dVar = this.StB.get(rVar.RHm);
            if (!(dVar == null || (hashMap = dVar.StC) == null)) {
                hashMap.clear();
            }
            this.StB.remove(rVar.RHm);
            c.a aVar = com.tencent.mm.videocomposition.c.RgU;
            com.tencent.mm.videocomposition.c.Asq.evictAll();
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199346);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q hjx() {
        AppMethodBeat.i(199347);
        a.q qVar = new a.q();
        qVar.RHG = 0L;
        a aVar = new a();
        UUID randomUUID = UUID.randomUUID();
        p.g(randomUUID, "UUID.randomUUID()");
        long mostSignificantBits = randomUUID.getMostSignificantBits() & MAlarmHandler.NEXT_FIRE_INTERVAL;
        this.StD.put(Long.valueOf(mostSignificantBits), aVar);
        qVar.RHG = Long.valueOf(mostSignificantBits);
        AppMethodBeat.o(199347);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ab abVar) {
        EffectManager effectManager;
        AppMethodBeat.i(199348);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        d dVar = this.StB.get(abVar.RHW);
        a aVar = this.StD.get(abVar.RHk);
        if (dVar != null) {
            n nVar = dVar.Gez;
            if (aVar != null) {
                effectManager = aVar.wet;
            } else {
                effectManager = null;
            }
            nVar.GAw = effectManager;
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199348);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q a(a.g gVar) {
        AppMethodBeat.i(199349);
        a.q qVar = new a.q();
        qVar.RHG = 0L;
        a aVar = this.StD.get(gVar.RHk);
        if (aVar != null) {
            j jVar = (j) kotlin.a.e.f(j.values(), (int) gVar.RHn.longValue());
            if (jVar == null) {
                AppMethodBeat.o(199349);
                return qVar;
            }
            EffectManager effectManager = aVar.wet;
            String str = gVar.path;
            p.g(str, "arg.path");
            ad a2 = effectManager.a(jVar, str);
            if (a2 != null) {
                aVar.Sty.put(Long.valueOf(a2.ptr), a2);
                qVar.RHG = Long.valueOf(a2.ptr);
            }
        }
        AppMethodBeat.o(199349);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q a(a.f fVar) {
        AppMethodBeat.i(199350);
        a.q qVar = new a.q();
        qVar.RHG = 0L;
        a aVar = this.StD.get(fVar.RHk);
        if (aVar != null) {
            j jVar = (j) kotlin.a.e.f(j.values(), (int) fVar.RHn.longValue());
            if (jVar == null) {
                AppMethodBeat.o(199350);
                return qVar;
            }
            EffectManager effectManager = aVar.wet;
            byte[] bArr = fVar.zy;
            p.g(bArr, "arg.bytes");
            ad a2 = effectManager.a(jVar, bArr);
            if (a2 != null) {
                aVar.Sty.put(Long.valueOf(a2.ptr), a2);
                qVar.RHG = Long.valueOf(a2.ptr);
            }
        }
        AppMethodBeat.o(199350);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.q d(a.r rVar) {
        AppMethodBeat.i(199351);
        a.q qVar = new a.q();
        if (rVar == null) {
            qVar.RHG = -1L;
        } else {
            d dVar = this.StB.get(rVar.RHm);
            if (dVar != null) {
                qVar.RHG = Long.valueOf(dVar.Gez.getDurationMs());
            }
        }
        AppMethodBeat.o(199351);
        return qVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ae aeVar) {
        ad adVar;
        AppMethodBeat.i(199352);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(aeVar.RHk);
        if (!(aVar == null || (adVar = aVar.Sty.get(aeVar.RHl)) == null)) {
            Long l = aeVar.RHq;
            p.g(l, "arg.startTimeMs");
            long longValue = l.longValue();
            Long l2 = aeVar.RHr;
            p.g(l2, "arg.endTimeMs");
            adVar.aH(longValue, l2.longValue());
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199352);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.aa aaVar) {
        AppMethodBeat.i(199353);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(aaVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(aaVar.RHl);
            if (!(adVar instanceof com.tencent.mm.xeffect.effect.p)) {
                adVar = null;
            }
            com.tencent.mm.xeffect.effect.p pVar = (com.tencent.mm.xeffect.effect.p) adVar;
            if (pVar != null) {
                pVar.a(new com.tencent.mm.xeffect.effect.f((int) aaVar.RHS.longValue(), (int) aaVar.RHT.longValue(), (float) aaVar.RHU.doubleValue(), (float) aaVar.RHV.doubleValue()));
                bVar.BOc = Boolean.TRUE;
            }
        }
        AppMethodBeat.o(199353);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ad adVar) {
        AppMethodBeat.i(199354);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(adVar.RHk);
        if (aVar != null) {
            ad adVar2 = aVar.Sty.get(adVar.RHl);
            if (!(adVar2 instanceof ab)) {
                adVar2 = null;
            }
            ab abVar = (ab) adVar2;
            if (abVar != null) {
                String str = adVar.text;
                p.g(str, "arg.text");
                String str2 = adVar.fontFamily;
                p.g(str2, "arg.fontFamily");
                Boolean bool = adVar.RHY;
                p.g(bool, "arg.italic");
                boolean booleanValue = bool.booleanValue();
                Boolean bool2 = adVar.RHZ;
                p.g(bool2, "arg.bold");
                abVar.a(new com.tencent.mm.xeffect.effect.h(str, (float) adVar.RHX.doubleValue(), str2, booleanValue, bool2.booleanValue()));
                bVar.BOc = Boolean.TRUE;
            }
        }
        AppMethodBeat.o(199354);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ac acVar) {
        AppMethodBeat.i(199355);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(acVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(acVar.RHl);
            if (!(adVar instanceof aa)) {
                adVar = null;
            }
            aa aaVar = (aa) adVar;
            if (aaVar != null) {
                aaVar.setSize((int) acVar.RHy.longValue(), (int) acVar.RHz.longValue());
                bVar.BOc = Boolean.TRUE;
            }
        }
        AppMethodBeat.o(199355);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.C0132a aVar) {
        ad adVar;
        AppMethodBeat.i(199356);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar2 = this.StD.get(aVar.RHk);
        if (!(aVar2 == null || (adVar = aVar2.Sty.get(aVar.RHl)) == null)) {
            aVar2.wet.a(adVar);
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199356);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.w wVar) {
        ad adVar;
        AppMethodBeat.i(199357);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(wVar.RHk);
        if (!(aVar == null || (adVar = aVar.Sty.get(wVar.RHl)) == null)) {
            aVar.wet.Ot(adVar.id);
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199357);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.e eVar) {
        AppMethodBeat.i(199358);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(eVar.RHk);
        if (aVar != null) {
            aVar.wet.hiv();
            aVar.Sty.clear();
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199358);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.k kVar) {
        AppMethodBeat.i(199359);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a remove = this.StD.remove(kVar.RHk);
        if (remove != null) {
            remove.wet.destroy();
            remove.Sty.clear();
            bVar.BOc = Boolean.TRUE;
        }
        AppMethodBeat.o(199359);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.s a(a.t tVar) {
        AppMethodBeat.i(199360);
        a.s sVar = new a.s();
        a aVar = this.StD.get(tVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(tVar.RHl);
            if (!(adVar instanceof r)) {
                adVar = null;
            }
            r rVar = (r) adVar;
            if (rVar != null) {
                sVar.RHy = Long.valueOf((long) rVar.ApT.getWidth());
                sVar.RHz = Long.valueOf((long) rVar.ApT.getHeight());
                sVar.RHH = Long.valueOf((long) rVar.RyV);
                sVar.RHI = Long.valueOf(rVar.RyW);
            }
        }
        AppMethodBeat.o(199360);
        return sVar;
    }

    @Override // com.tencent.d.a.at
    public final a.u a(a.v vVar) {
        AppMethodBeat.i(199361);
        a.u uVar = new a.u();
        a aVar = this.StD.get(vVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(vVar.RHl);
            if (!(adVar instanceof u)) {
                adVar = null;
            }
            u uVar2 = (u) adVar;
            if (uVar2 != null) {
                com.tencent.mm.xeffect.effect.q qVar = (com.tencent.mm.xeffect.effect.q) kotlin.a.e.f(com.tencent.mm.xeffect.effect.q.values(), (int) vVar.RHL.longValue());
                if (qVar == null) {
                    AppMethodBeat.o(199361);
                    return uVar;
                }
                Boolean bool = vVar.RHM;
                p.g(bool, "arg.checkMarker");
                boolean booleanValue = bool.booleanValue();
                p.h(qVar, "replacementType");
                List<Pair<Long, Long>> pagTemplateInfo$renderlib_release = VLogEffectJNI.INSTANCE.getPagTemplateInfo$renderlib_release(uVar2.ptr, qVar, booleanValue);
                List<Pair<Long, Long>> list = pagTemplateInfo$renderlib_release;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((Long) ((Pair) it.next()).first);
                }
                uVar.RHJ = kotlin.a.j.toLongArray(arrayList);
                List<Pair<Long, Long>> list2 = pagTemplateInfo$renderlib_release;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((Long) ((Pair) it2.next()).second);
                }
                uVar.RHK = kotlin.a.j.toLongArray(arrayList2);
            }
        }
        AppMethodBeat.o(199361);
        return uVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ag agVar) {
        AppMethodBeat.i(199362);
        a.b bVar = new a.b();
        a aVar = this.StD.get(agVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(agVar.RHl);
            if (!(adVar instanceof r)) {
                adVar = null;
            }
            r rVar = (r) adVar;
            if (rVar != null) {
                Boolean bool = agVar.RHM;
                p.g(bool, "arg.checkMarker");
                VLogEffectJNI.INSTANCE.setCheckMarker$renderlib_release(rVar.ptr, bool.booleanValue());
            }
        }
        AppMethodBeat.o(199362);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ah ahVar) {
        AppMethodBeat.i(199363);
        a.b bVar = new a.b();
        bVar.BOc = Boolean.FALSE;
        a aVar = this.StD.get(ahVar.RHk);
        if (aVar != null) {
            ad adVar = aVar.Sty.get(ahVar.RHl);
            if (!(adVar instanceof u)) {
                adVar = null;
            }
            u uVar = (u) adVar;
            if (uVar != null) {
                int longValue = (int) ahVar.RIb.longValue();
                String str = ahVar.text;
                p.g(str, "arg.text");
                String str2 = ahVar.fontFamily;
                p.g(str2, "arg.fontFamily");
                Boolean bool = ahVar.RHY;
                p.g(bool, "arg.italic");
                boolean booleanValue = bool.booleanValue();
                Boolean bool2 = ahVar.RHZ;
                p.g(bool2, "arg.bold");
                com.tencent.mm.xeffect.effect.h hVar = new com.tencent.mm.xeffect.effect.h(str, (float) ahVar.RHX.doubleValue(), str2, booleanValue, bool2.booleanValue());
                p.h(hVar, "textInfo");
                VLogEffectJNI.INSTANCE.setPagTemplateText$renderlib_release(uVar.ptr, longValue, hVar);
                bVar.BOc = Boolean.TRUE;
            }
        }
        AppMethodBeat.o(199363);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b hjy() {
        boolean z;
        AppMethodBeat.i(199364);
        a.b bVar = new a.b();
        com.tencent.mm.videocomposition.e fEd = com.tencent.mm.videocomposition.b.RgQ.fEd();
        if (fEd != null) {
            z = fEd.isEnable();
        } else {
            z = false;
        }
        bVar.BOc = Boolean.valueOf(z);
        AppMethodBeat.o(199364);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.o oVar) {
        AppMethodBeat.i(199365);
        a.b bVar = new a.b();
        d dVar = this.StB.get(oVar.RHm);
        if (dVar != null) {
            n nVar = dVar.Gez;
            com.tencent.mm.videocomposition.e fEd = com.tencent.mm.videocomposition.b.RgQ.fEd();
            if (fEd != null && fEd.isEnable()) {
                new StringBuilder("call getCompositionLabel, id:").append(nVar.id);
                fEd.a(nVar, new e(dVar, nVar, this));
            }
        }
        AppMethodBeat.o(199365);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.aj ajVar) {
        com.tencent.mm.xeffect.effect.n nVar;
        AppMethodBeat.i(199366);
        a.b bVar = new a.b();
        a aVar = this.StD.get(ajVar.RHk);
        if (!(aVar == null || (nVar = aVar.Stz) == null)) {
            String str = ajVar.MjW;
            p.g(str, "arg.configJson");
            nVar.bpE(str);
        }
        AppMethodBeat.o(199366);
        return bVar;
    }

    @Override // com.tencent.d.a.at
    public final a.b a(a.ak akVar) {
        com.tencent.mm.xeffect.effect.n nVar;
        com.tencent.mm.xeffect.effect.n nVar2 = null;
        AppMethodBeat.i(199367);
        a.b bVar = new a.b();
        a aVar = this.StD.get(akVar.RHk);
        if (aVar != null) {
            Boolean bool = akVar.RHx;
            p.g(bool, "arg.enable");
            if (bool.booleanValue() && aVar.Stz == null) {
                ad a2 = aVar.wet.a(j.ImageEnhanceEffect);
                if (a2 instanceof com.tencent.mm.xeffect.effect.n) {
                    nVar2 = a2;
                }
                com.tencent.mm.xeffect.effect.n nVar3 = nVar2;
                if (nVar3 != null) {
                    aVar.Stz = nVar3;
                    aVar.wet.a(nVar3);
                }
            } else if (!(akVar.RHx.booleanValue() || aVar.Stz == null || (nVar = aVar.Stz) == null)) {
                aVar.wet.Ot(nVar.id);
                aVar.Stz = null;
            }
            d dVar = this.StB.get(akVar.RHm);
            if (dVar != null) {
                n nVar4 = dVar.Gez;
                nVar4.a(new i(nVar4, dVar.Sue, this, akVar));
            }
        }
        AppMethodBeat.o(199367);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r¸\u0006\u000e"}, hxF = {"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setVideoEnhancement$1$3$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$3"})
    public static final class i implements com.tencent.mm.videocomposition.b.e {
        private String GAN = "";
        final /* synthetic */ n GLI;
        final /* synthetic */ b StJ;
        final /* synthetic */ HashMap Sub;
        final /* synthetic */ a.ak Suc;

        i(n nVar, HashMap hashMap, b bVar, a.ak akVar) {
            this.GLI = nVar;
            this.Sub = hashMap;
            this.StJ = bVar;
            this.Suc = akVar;
        }

        @Override // com.tencent.mm.videocomposition.b.e
        public final void KM(long j2) {
            T t;
            String str;
            String str2;
            Integer num;
            String str3;
            boolean z;
            AppMethodBeat.i(199310);
            a aVar = (a) this.StJ.StD.get(this.Suc.RHk);
            if (aVar != null) {
                com.tencent.mm.xeffect.effect.n nVar = aVar.Stz;
                if (nVar != null) {
                    Iterator<T> it = this.GLI.Gzn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        T t2 = next;
                        if (t2.startTimeMs > j2 || t2.endTimeMs <= j2) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    T t3 = t;
                    if (t3 != null) {
                        str = t3.path;
                    } else {
                        str = null;
                    }
                    if (!p.j(str, this.GAN)) {
                        HashMap hashMap = this.Sub;
                        if (t3 != null) {
                            str2 = t3.path;
                        } else {
                            str2 = null;
                        }
                        Pair pair = (Pair) hashMap.get(str2);
                        if (pair != null) {
                            num = (Integer) pair.first;
                        } else {
                            num = null;
                        }
                        if (num != null && com.tencent.mm.videocomposition.a.hfg().contains(num)) {
                            nVar.setScene(num.intValue());
                        }
                        if (t3 == null || (str3 = t3.path) == null) {
                            str3 = "";
                        }
                        this.GAN = str3;
                    }
                    AppMethodBeat.o(199310);
                    return;
                }
                AppMethodBeat.o(199310);
                return;
            }
            AppMethodBeat.o(199310);
        }

        @Override // com.tencent.mm.videocomposition.b.e
        public final void onRelease() {
        }
    }

    @Override // io.flutter.plugin.a.d.c
    public final void a(Object obj, d.a aVar) {
        AppMethodBeat.i(199368);
        new StringBuilder("onListen, arguments:").append(obj);
        this.StF = aVar;
        AppMethodBeat.o(199368);
    }

    @Override // io.flutter.plugin.a.d.c
    public final void sT() {
        this.StF = null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.j.b$b  reason: collision with other inner class name */
    public static final class C0146b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b StJ;
        final /* synthetic */ long StK;
        final /* synthetic */ long StL = 0;
        final /* synthetic */ byte[] StM;
        final /* synthetic */ long uLo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0146b(b bVar, long j2, long j3, byte[] bArr) {
            super(0);
            this.StJ = bVar;
            this.uLo = j2;
            this.StK = j3;
            this.StM = bArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(199291);
            new StringBuilder("callbackFrameData in uiThread time:").append(this.uLo).append(", trackId:").append(this.StK).append(", compositionId:").append(this.StL);
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(this.uLo));
            hashMap.put("data", this.StM);
            hashMap.put("trackId", Long.valueOf(this.StK));
            hashMap.put("id", Long.valueOf(this.StL));
            k kVar = this.StJ.StH;
            if (kVar != null) {
                kVar.a("frameDataReady", hashMap, null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(199291);
            return xVar;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(199311);
        p.h(bVar, "binding");
        Context context2 = bVar.applicationContext;
        p.g(context2, "binding.applicationContext");
        io.flutter.plugin.a.c cVar = bVar.SOH;
        p.g(cVar, "binding.binaryMessenger");
        io.flutter.view.c cVar2 = bVar.StA;
        p.g(cVar2, "binding.textureRegistry");
        this.context = context2;
        this.StA = cVar2;
        this.wJr = new k(cVar, "com.tencent.mm/video_composition");
        this.StE = new io.flutter.plugin.a.d(cVar, "com.tencent.mm/video_composition/export");
        this.StG = new k(cVar, "com.tencent.mm/video_composition/playercallback");
        this.StH = new k(cVar, "com.tencent.mm/video_composition/thumblist");
        io.flutter.plugin.a.d dVar = this.StE;
        if (dVar != null) {
            dVar.a(this);
        }
        this.random.setSeed(SystemClock.elapsedRealtime());
        this.handler = new Handler(Looper.getMainLooper());
        b bVar2 = this;
        new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoCompositionApi.create", new io.flutter.plugin.a.n()).a(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: INVOKE  
              (wrap: io.flutter.plugin.a.b : 0x007a: CONSTRUCTOR  (r0v8 io.flutter.plugin.a.b) = 
              (r1v1 'cVar' io.flutter.plugin.a.c)
              ("dev.flutter.pigeon.VideoCompositionApi.create")
              (wrap: io.flutter.plugin.a.n : 0x0077: CONSTRUCTOR  (r3v1 io.flutter.plugin.a.n) =  call: io.flutter.plugin.a.n.<init>():void type: CONSTRUCTOR)
             call: io.flutter.plugin.a.b.<init>(io.flutter.plugin.a.c, java.lang.String, io.flutter.plugin.a.i):void type: CONSTRUCTOR)
              (wrap: com.tencent.d.a$at$1 : 0x007f: CONSTRUCTOR  (r2v10 com.tencent.d.a$at$1) = (r5v1 'bVar2' com.tencent.j.b) call: com.tencent.d.a.at.1.<init>(com.tencent.d.a$at):void type: CONSTRUCTOR)
             type: VIRTUAL call: io.flutter.plugin.a.b.a(io.flutter.plugin.a.b$b):void in method: com.tencent.j.b.a(io.flutter.embedding.engine.plugins.a$b):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007f: CONSTRUCTOR  (r2v10 com.tencent.d.a$at$1) = (r5v1 'bVar2' com.tencent.j.b) call: com.tencent.d.a.at.1.<init>(com.tencent.d.a$at):void type: CONSTRUCTOR in method: com.tencent.j.b.a(io.flutter.embedding.engine.plugins.a$b):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.d.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 1271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.j.b.a(io.flutter.embedding.engine.plugins.a$b):void");
    }

    public static final /* synthetic */ void a(b bVar, long j2, Bitmap bitmap, long j3) {
        AppMethodBeat.i(199371);
        new StringBuilder("callbackFrameData time:").append(j2).append(", trackId:").append(j3).append(", compositionId:0");
        byte[] bArr = new byte[bitmap.getByteCount()];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        bitmap.copyPixelsToBuffer(order);
        order.position(0);
        com.tencent.mm.videocomposition.c.c.h(new C0146b(bVar, j2, j3, bArr));
        AppMethodBeat.o(199371);
    }
}
