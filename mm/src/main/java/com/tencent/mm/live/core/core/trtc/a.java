package com.tencent.mm.live.core.core.trtc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.live.core.b.d;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.core.trtc.a.b.c;
import com.tencent.mm.live.core.core.trtc.a.c;
import com.tencent.mm.live.core.core.trtc.a.d;
import com.tencent.mm.live.core.core.trtc.b;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.a;
import com.tencent.mm.live.core.mini.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b&\u0018\u0000 æ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002æ\u0001B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010l\u001a\u00020\u0013J\u0010\u0010m\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u001dH\u0016J\u0010\u0010o\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u001dH\u0016J\u0012\u0010p\u001a\u00020\u00132\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J0\u0010s\u001a\u0002042\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u0002042\u0006\u0010y\u001a\u000204H\u0016J\u001e\u0010z\u001a\u00020\u00132\u0016\u0010n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\b\u0010{\u001a\u0004\u0018\u00010EJ\b\u0010|\u001a\u00020=H\u0016J\b\u0010}\u001a\u000204H\u0016J\u001f\u0010~\u001a\u0004\u0018\u000102\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u000204H\u0016J\t\u0010\u0001\u001a\u000204H\u0016J\u001b\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020\u0007H\u0016J\u0011\u0010\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0001\u001a\u000204H\u0016J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\u001b\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u000204H\u0016J\u0012\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010\u0001\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001H\u0016J*\u0010\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u0002042\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001e\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u0002042\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001H\u0016J*\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u0002042\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0012\u0010¢\u0001\u001a\u00020\u00132\u0007\u0010£\u0001\u001a\u000204H\u0016J0\u0010¤\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¥\u0001\u001a\u0002042\u0007\u0010¦\u0001\u001a\u0002042\u0007\u0010§\u0001\u001a\u000204H\u0016J\u0012\u0010¨\u0001\u001a\u00020\u00132\u0007\u0010©\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010ª\u0001\u001a\u00020\u00132\u0007\u0010©\u0001\u001a\u00020\u0007H\u0016J(\u0010«\u0001\u001a\u00020\u00132\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u00012\u0011\u0010®\u0001\u001a\f\u0012\u0005\u0012\u00030­\u0001\u0018\u00010¯\u0001H\u0016J3\u0010°\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010±\u0001\u001a\u0002042\u0007\u0010²\u0001\u001a\u0002042\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0016J!\u0010µ\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010´\u0001H\u0016J\u0015\u0010·\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001e\u0010¸\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010£\u0001\u001a\u000204H\u0016J\u001e\u0010¹\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010º\u0001\u001a\u00020\u00132\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u001e\u0010½\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0016J\u001e\u0010¿\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0016J\u001e\u0010À\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0016J%\u0010Á\u0001\u001a\u00020\u00132\u0011\u0010Â\u0001\u001a\f\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010¯\u00012\u0007\u0010Ä\u0001\u001a\u000204H\u0016J*\u0010Å\u0001\u001a\u00020\u00132\u0007\u0010Æ\u0001\u001a\u0002042\n\u0010Ç\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\t\u0010È\u0001\u001a\u00020\u0013H\u0016J\t\u0010É\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ê\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ë\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010Ì\u0001\u001a\u00020\u00132\b\u0010n\u001a\u0004\u0018\u00010\u001dH\u0016J\u0011\u0010Í\u0001\u001a\u0002042\u0006\u0010D\u001a\u00020EH\u0016J'\u0010Î\u0001\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0011\u0010Ï\u0001\u001a\u0002042\b\u0010Ð\u0001\u001a\u00030Ñ\u0001J\u0011\u0010Ò\u0001\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010KJ\t\u0010Ó\u0001\u001a\u000204H\u0016J\t\u0010Ô\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010Õ\u0001\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010Ö\u0001\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0013\u0010×\u0001\u001a\u00020\u00132\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0016J\u0012\u0010Ú\u0001\u001a\u00020\u00132\u0007\u0010Û\u0001\u001a\u000204H\u0016J\u001d\u0010Ü\u0001\u001a\u00020\u00132\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030Þ\u0001H\u0016J\u0013\u0010à\u0001\u001a\u00020\u00132\b\u0010á\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010â\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010ã\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010ä\u0001\u001a\u00020\u00132\u0007\u0010å\u0001\u001a\u000204H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010/\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010/\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u000e\u0010<\u001a\u00020=X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020iX\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010k¨\u0006ç\u0001"}, hxF = {"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "isAnchor", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "isPushing", "setPushing", "lastCameraFps", "", "getLastCameraFps", "()I", "setLastCameraFps", "(I)V", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkMirror", "enterRoom", "callback", "exitRoom", "fillMiniView", "miniView", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRecordScene", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "getResolutionLimit", "initCamera", "useCamera2", "frontCamera", "initCameraConfig", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "isInLinkMic", "isInLive", "liveId", "", "justRemoveMiniWindow", "liveScene", "normalMode", "onAudioEffectFinished", "effectId", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "onAudioVolumeEvaluationChange", "enable", "onCloseLive", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "onWarning", "warningCode", "warningMsg", "refreshCamera", "release", "removeMiniWindow", "resetMixtureParams", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateBeautyConfig", "updateFilterConfig", "updateLiveMiniState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "updateMirrorMode", "mirrorMode", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "updateRemoteOutputSurface", "updateSdkParam", "updateVisitoreRenderMode", "renderMode", "Companion", "plugin-core_release"})
public abstract class a implements com.tencent.mm.live.core.core.b, c.a, c.a, d, com.tencent.mm.media.widget.camerarecordview.d.b {
    public static final C0384a hAC = new C0384a((byte) 0);
    private boolean dMz;
    protected boolean hAA;
    public int hAB;
    public final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    public TRTCCloud hAl;
    public com.tencent.mm.live.core.core.trtc.a.b.c hAm;
    protected com.tencent.mm.live.core.core.trtc.a.c hAn;
    private final TRTCCloudDef.TRTCVideoFrame hAo;
    private final TRTCCloudDef.TRTCTexture hAp;
    public com.tencent.mm.live.core.mini.b hAq;
    public com.tencent.mm.live.core.b.d hAr;
    protected LivePreviewView hAs;
    protected com.tencent.mm.media.widget.a.d hAt;
    private com.tencent.mm.media.widget.a.b hAu;
    protected com.tencent.mm.live.core.core.c hAv;
    protected com.tencent.mm.live.core.core.c hAw;
    public com.tencent.mm.live.core.core.c hAx;
    public com.tencent.mm.live.core.core.b.f hAy;
    public com.tencent.mm.live.core.core.b.g hAz;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
    public static final class b extends q implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(3);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(com.tencent.mm.live.core.b.l lVar, Integer num, Integer num2) {
            AppMethodBeat.i(196494);
            final com.tencent.mm.live.core.b.l lVar2 = lVar;
            num.intValue();
            num2.intValue();
            p.h(lVar2, "surface");
            lVar2.hEC = new kotlin.g.a.a(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.b.AnonymousClass1 */
                final /* synthetic */ b hAF;

                {
                    this.hAF = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(196492);
                    lVar2.hEC = null;
                    this.hAF.hAE.hAr.bO(lVar2.beb);
                    AppMethodBeat.o(196492);
                    return null;
                }
            };
            lVar2.hED = new m(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.b.AnonymousClass2 */
                final /* synthetic */ b hAF;

                {
                    this.hAF = r2;
                }

                @Override // kotlin.g.a.m
                public final /* synthetic */ Object invoke(Object obj, Object obj2) {
                    AppMethodBeat.i(196493);
                    this.hAF.hAE.hAr.cX(((Number) obj).intValue(), ((Number) obj2).intValue());
                    ac aEA = this.hAF.hAE.hAr.aEA();
                    com.tencent.mm.live.core.c.a.qE(aEA.width);
                    com.tencent.mm.live.core.c.a.qD(aEA.height);
                    AppMethodBeat.o(196493);
                    return null;
                }
            };
            x xVar = x.SXb;
            AppMethodBeat.o(196494);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196497);
            final SurfaceTexture surfaceTexture2 = surfaceTexture;
            this.hAE.hAk.post(new Runnable(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.c.AnonymousClass1 */
                final /* synthetic */ c hAG;

                {
                    this.hAG = r1;
                }

                public final void run() {
                    int aCQ;
                    boolean z;
                    int i2;
                    com.tencent.mm.live.core.core.b.d dVar;
                    com.tencent.mm.live.core.core.b.d dVar2;
                    int i3 = 0;
                    AppMethodBeat.i(196496);
                    com.tencent.mm.media.widget.a.d dVar3 = this.hAG.hAE.hAt;
                    if (dVar3 != null) {
                        SurfaceTexture surfaceTexture = surfaceTexture2;
                        com.tencent.mm.live.core.core.b.f fVar = this.hAG.hAE.hAy;
                        if (fVar == null || (dVar2 = fVar.hzt) == null) {
                            z = false;
                        } else {
                            z = dVar2.hzi;
                        }
                        com.tencent.mm.live.core.core.b.f fVar2 = this.hAG.hAE.hAy;
                        if (fVar2 == null || (dVar = fVar2.hzt) == null) {
                            i2 = 1080;
                        } else {
                            i2 = dVar.hzj;
                        }
                        dVar3.a(surfaceTexture, z, i2);
                    }
                    com.tencent.mm.media.widget.a.d dVar4 = this.hAG.hAE.hAt;
                    if (dVar4 == null || !dVar4.aPc()) {
                        Log.i("MicroMsg.LiveCore", "start preview fail");
                        AppMethodBeat.o(196496);
                        return;
                    }
                    StringBuilder sb = new StringBuilder("start preview success, mirrorMode:");
                    com.tencent.mm.live.core.b.g gVar = this.hAG.hAE.hAr.hDw;
                    if (gVar != null) {
                        aCQ = gVar.hEb;
                    } else {
                        e.g gVar2 = e.g.hxV;
                        aCQ = e.g.aCQ();
                    }
                    Log.i("MicroMsg.LiveCore", sb.append(aCQ).toString());
                    com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                    p.g(aDC, "ConfigHelper.getInstance()");
                    com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC.aDG();
                    com.tencent.mm.media.widget.a.d dVar5 = this.hAG.hAE.hAt;
                    if (dVar5 != null) {
                        i3 = dVar5.aPu();
                    }
                    aDG.hBp = i3;
                    com.tencent.mm.live.core.b.d dVar6 = this.hAG.hAE.hAr;
                    com.tencent.mm.media.widget.a.d dVar7 = this.hAG.hAE.hAt;
                    com.tencent.mm.media.widget.a.b aPr = dVar7 != null ? dVar7.aPr() : null;
                    if (aPr == null) {
                        p.hyc();
                    }
                    dVar6.a(aPr);
                    this.hAG.hAE.hAr.setOnDrawListener(new kotlin.g.a.b<com.tencent.mm.media.g.d, x>(this) {
                        /* class com.tencent.mm.live.core.core.trtc.a.c.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 hAI;

                        {
                            this.hAI = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(com.tencent.mm.media.g.d dVar) {
                            AppMethodBeat.i(196495);
                            com.tencent.mm.media.g.d dVar2 = dVar;
                            if (this.hAI.hAG.hAE.hAA && dVar2 != null) {
                                this.hAI.hAG.hAE.hAp.eglContext14 = this.hAI.hAG.hAE.hAr.getEGLContext();
                                this.hAI.hAG.hAE.hAp.textureId = dVar2.igv;
                                this.hAI.hAG.hAE.hAo.texture = this.hAI.hAG.hAE.hAp;
                                this.hAI.hAG.hAE.hAo.width = dVar2.width;
                                this.hAI.hAG.hAE.hAo.height = dVar2.height;
                                this.hAI.hAG.hAE.hAo.pixelFormat = 2;
                                this.hAI.hAG.hAE.hAo.bufferType = 3;
                                this.hAI.hAG.hAE.hAl.sendCustomVideoData(this.hAI.hAG.hAE.hAo);
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(196495);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(196496);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(196497);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "width", "", "height", "invoke"})
    static final class e extends q implements m {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(2);
            this.hAE = aVar;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            AppMethodBeat.i(196499);
            this.hAE.hAr.cX(((Number) obj).intValue(), ((Number) obj2).intValue());
            ac aEA = this.hAE.hAr.aEA();
            com.tencent.mm.live.core.c.c.qG(aEA.width);
            com.tencent.mm.live.core.c.c.qH(aEA.height);
            AppMethodBeat.o(196499);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(1);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196501);
            final SurfaceTexture surfaceTexture2 = surfaceTexture;
            this.hAE.hAk.post(new Runnable(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.f.AnonymousClass1 */
                final /* synthetic */ f hAK;

                {
                    this.hAK = r1;
                }

                public final void run() {
                    boolean z;
                    int i2;
                    com.tencent.mm.live.core.core.b.d dVar;
                    com.tencent.mm.live.core.core.b.d dVar2;
                    int i3 = 0;
                    AppMethodBeat.i(196500);
                    com.tencent.mm.media.widget.a.d dVar3 = this.hAK.hAE.hAt;
                    if (dVar3 != null) {
                        SurfaceTexture surfaceTexture = surfaceTexture2;
                        com.tencent.mm.live.core.core.b.f fVar = this.hAK.hAE.hAy;
                        if (fVar == null || (dVar2 = fVar.hzt) == null) {
                            z = false;
                        } else {
                            z = dVar2.hzi;
                        }
                        com.tencent.mm.live.core.core.b.f fVar2 = this.hAK.hAE.hAy;
                        if (fVar2 == null || (dVar = fVar2.hzt) == null) {
                            i2 = 1080;
                        } else {
                            i2 = dVar.hzj;
                        }
                        dVar3.a(surfaceTexture, z, i2);
                    }
                    com.tencent.mm.media.widget.a.d dVar4 = this.hAK.hAE.hAt;
                    if (dVar4 == null || !dVar4.aPc()) {
                        Log.i("MicroMsg.LiveCore", "start preview fail");
                        AppMethodBeat.o(196500);
                        return;
                    }
                    Log.i("MicroMsg.LiveCore", "start preview success");
                    com.tencent.mm.live.core.b.d dVar5 = this.hAK.hAE.hAr;
                    com.tencent.mm.media.widget.a.d dVar6 = this.hAK.hAE.hAt;
                    com.tencent.mm.media.widget.a.b aPr = dVar6 != null ? dVar6.aPr() : null;
                    if (aPr == null) {
                        p.hyc();
                    }
                    dVar5.a(aPr);
                    com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                    p.g(aDC, "ConfigHelper.getInstance()");
                    com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC.aDG();
                    com.tencent.mm.media.widget.a.d dVar7 = this.hAK.hAE.hAt;
                    if (dVar7 != null) {
                        i3 = dVar7.aPu();
                    }
                    aDG.hBp = i3;
                    AppMethodBeat.o(196500);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(196501);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
    public static final class g extends q implements kotlin.g.a.b<com.tencent.mm.media.g.d, x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(1);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.g.d dVar) {
            AppMethodBeat.i(196502);
            com.tencent.mm.media.g.d dVar2 = dVar;
            if (this.hAE.hAA && dVar2 != null) {
                this.hAE.hAp.eglContext14 = this.hAE.hAr.getEGLContext();
                this.hAE.hAp.textureId = dVar2.igv;
                this.hAE.hAo.texture = this.hAE.hAp;
                this.hAE.hAo.width = dVar2.width;
                this.hAE.hAo.height = dVar2.height;
                this.hAE.hAo.pixelFormat = 2;
                this.hAE.hAo.bufferType = 3;
                this.hAE.hAl.sendCustomVideoData(this.hAE.hAo);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196502);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
    public static final class h extends q implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar) {
            super(3);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(com.tencent.mm.live.core.b.l lVar, Integer num, Integer num2) {
            AppMethodBeat.i(196505);
            final com.tencent.mm.live.core.b.l lVar2 = lVar;
            final int intValue = num.intValue();
            final int intValue2 = num2.intValue();
            p.h(lVar2, "surface");
            lVar2.hEC = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.h.AnonymousClass1 */
                final /* synthetic */ h hAL;

                {
                    this.hAL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(196503);
                    Log.i("MicroMsg.LiveCore", "surface is %s and other ow is %s, oh is height %s", lVar2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                    lVar2.hEC = null;
                    this.hAL.hAE.hAr.bO(lVar2.beb);
                    x xVar = x.SXb;
                    AppMethodBeat.o(196503);
                    return xVar;
                }
            };
            lVar2.hED = new m<Integer, Integer, x>(this) {
                /* class com.tencent.mm.live.core.core.trtc.a.h.AnonymousClass2 */
                final /* synthetic */ h hAL;

                {
                    this.hAL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Integer num2) {
                    AppMethodBeat.i(196504);
                    int intValue = num.intValue();
                    int intValue2 = num2.intValue();
                    Log.i("MicroMsg.LiveCore", "surface is %s and width is %s, height is %s and other ow is %s, oh is height %s", lVar2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue), Integer.valueOf(intValue2));
                    this.hAL.hAE.hAr.cX(intValue, intValue2);
                    x xVar = x.SXb;
                    AppMethodBeat.o(196504);
                    return xVar;
                }
            };
            x xVar = x.SXb;
            AppMethodBeat.o(196505);
            return xVar;
        }
    }

    public a(boolean z) {
        this.dMz = z;
        b.a aVar = b.hAP;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        p.h(context, "var0");
        if (b.aDB() == null) {
            b.a(new b(context));
        }
        b aDB = b.aDB();
        if (aDB == null) {
            p.hyc();
        }
        this.hAl = aDB;
        this.hAm = new com.tencent.mm.live.core.core.trtc.a.b.c(this.hAl, this);
        this.hAo = new TRTCCloudDef.TRTCVideoFrame();
        this.hAp = new TRTCCloudDef.TRTCTexture();
        this.hAq = new com.tencent.mm.live.core.mini.b();
        this.hAr = new com.tencent.mm.live.core.b.d();
        this.hAz = new com.tencent.mm.live.core.core.b.g();
        this.hAB = 15;
        Log.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
        TXLiveBase.setListener(AnonymousClass1.hAD);
        if (this.hAz.isDebugMode) {
            TRTCCloud.setLogLevel(0);
            TRTCCloud.setConsoleEnabled(true);
            return;
        }
        TRTCCloud.setLogLevel(4);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.core.trtc.a$a  reason: collision with other inner class name */
    public static final class C0384a {
        private C0384a() {
        }

        public /* synthetic */ C0384a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int a(com.tencent.mm.live.core.core.b.f fVar) {
        com.tencent.mm.live.core.core.b.d dVar;
        boolean z;
        p.h(fVar, "model");
        Log.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(fVar)));
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("model:".concat(String.valueOf(fVar)));
        this.hAy = fVar;
        com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
        if (!(fVar2 == null || (dVar = fVar2.hzt) == null)) {
            if (this.hAu != null) {
                z = com.tencent.mm.media.widget.a.b.aPn();
            } else {
                z = true;
            }
            dVar.hzh = z;
        }
        com.tencent.mm.live.core.b.d dVar2 = this.hAr;
        p.h(fVar, "model");
        dVar2.hAy = fVar;
        this.hAz.hzJ = fVar.hzu.userId;
        com.tencent.mm.live.core.mini.b bVar = this.hAq;
        String str = fVar.hzv.name;
        p.h(str, "activityName");
        bVar.intent.setClass(MMApplicationContext.getContext(), Class.forName(str));
        bVar.intent.addFlags(268435456);
        bVar.hCQ = str;
        this.hAn = new com.tencent.mm.live.core.core.trtc.a.c(this.hAl, fVar.hzu);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.a((c.a) this);
        }
        com.tencent.mm.live.core.core.trtc.a.c cVar2 = this.hAn;
        if (cVar2 != null) {
            cVar2.a((d) this);
        }
        com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
        if (cVar3 != null) {
            cVar3.aDI();
        }
        this.hAm.Gs(fVar.hzu.userId);
        this.hAz.hzG = fVar.hwP.hzm;
        this.hAm.y(fVar.hwP.appId, fVar.hwP.hzn);
        Log.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", Long.valueOf(fVar.hwP.appId), Long.valueOf(fVar.hwP.hzn));
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int a(LivePreviewView livePreviewView, com.tencent.mm.live.core.b.a aVar, com.tencent.mm.live.core.b.b bVar) {
        boolean z;
        boolean z2;
        int i2;
        com.tencent.mm.live.core.core.b.d dVar;
        com.tencent.mm.media.widget.a.d dVar2;
        com.tencent.mm.live.core.core.b.d dVar3;
        com.tencent.mm.live.core.core.b.d dVar4;
        if (livePreviewView == null) {
            Log.e("MicroMsg.LiveCore", "startPreview preiewView is null");
            return -3;
        }
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("startPreview ".concat(String.valueOf(livePreviewView)));
        this.hAs = livePreviewView;
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (dVar4 = fVar.hzt) == null) {
            z = false;
        } else {
            z = dVar4.hzg;
        }
        com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
        if (fVar2 == null || (dVar3 = fVar2.hzt) == null) {
            z2 = this.hAu == null || com.tencent.mm.media.widget.a.b.aPn();
        } else {
            z2 = dVar3.hzh;
        }
        k(z, z2);
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
        p.g(aDD, "ConfigHelper.getInstance().videoConfig");
        this.hAB = aDD.aDR();
        com.tencent.mm.live.core.core.b.f fVar3 = this.hAy;
        if (!(fVar3 == null || (dVar = fVar3.hzt) == null || !dVar.hzi || (dVar2 = this.hAt) == null)) {
            dVar2.a(this.hAr.getFrameDataCallback());
        }
        com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC2, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC2.aDE();
        p.g(aDE, "ConfigHelper.getInstance().audioConfig");
        aDE.ez(true);
        com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC3, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC3.aDD();
        p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
        aDD2.eC(true);
        com.tencent.mm.live.core.core.trtc.a.a aDC4 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC4, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC4.aDG();
        com.tencent.mm.media.widget.a.d dVar5 = this.hAt;
        if (dVar5 != null) {
            i2 = dVar5.aPu();
        } else {
            i2 = 0;
        }
        aDG.hBp = i2;
        livePreviewView.a(new b(this));
        this.hAr.a(aVar);
        this.hAr.a(bVar);
        this.hAr.d(new c(this));
        return 0;
    }

    public final int a(com.tencent.mm.live.core.b.l lVar) {
        boolean z;
        boolean z2;
        com.tencent.mm.live.core.core.b.d dVar;
        com.tencent.mm.media.widget.a.d dVar2;
        com.tencent.mm.live.core.core.b.d dVar3;
        com.tencent.mm.live.core.core.b.d dVar4;
        p.h(lVar, "surfaceHolder");
        this.hAr.aEz();
        lVar.hEC = new d(this, lVar);
        lVar.hED = new e(this);
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("startPreview " + lVar + ' ');
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (dVar4 = fVar.hzt) == null) {
            z = false;
        } else {
            z = dVar4.hzg;
        }
        com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
        if (fVar2 == null || (dVar3 = fVar2.hzt) == null) {
            z2 = true;
        } else {
            z2 = dVar3.hzh;
        }
        k(z, z2);
        com.tencent.mm.live.core.core.b.f fVar3 = this.hAy;
        if (!(fVar3 == null || (dVar = fVar3.hzt) == null || !dVar.hzi || (dVar2 = this.hAt) == null)) {
            dVar2.a(this.hAr.getFrameDataCallback());
        }
        this.hAr.d(new f(this));
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void switchCamera() {
        com.tencent.mm.media.widget.a.d dVar;
        int i2;
        com.tencent.mm.media.widget.a.b aPr;
        try {
            com.tencent.mm.media.widget.a.d dVar2 = this.hAt;
            if (dVar2 != null && dVar2.aPc()) {
                com.tencent.mm.media.widget.a.d dVar3 = this.hAt;
                if (dVar3 != null) {
                    dVar3.aPb();
                }
                this.hAr.aEy();
                if (this.hAs != null && (dVar = this.hAt) != null && dVar.aPc()) {
                    com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                    p.g(aDC, "ConfigHelper.getInstance()");
                    com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC.aDG();
                    com.tencent.mm.media.widget.a.d dVar4 = this.hAt;
                    if (dVar4 != null) {
                        i2 = dVar4.aPu();
                    } else {
                        i2 = 0;
                    }
                    aDG.hBp = i2;
                    com.tencent.mm.media.widget.a.d dVar5 = this.hAt;
                    if (dVar5 != null && (aPr = dVar5.aPr()) != null) {
                        this.hAu = aPr;
                        this.hAr.a(aPr);
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LiveCoreError", e2, "switch camera error:" + e2.getMessage(), new Object[0]);
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void aBT() {
        com.tencent.mm.media.widget.a.b aPr;
        int i2;
        com.tencent.mm.media.widget.a.d dVar = this.hAt;
        if (dVar != null && (aPr = dVar.aPr()) != null) {
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC.aDG();
            com.tencent.mm.media.widget.a.d dVar2 = this.hAt;
            if (dVar2 != null) {
                i2 = dVar2.aPu();
            } else {
                i2 = 0;
            }
            aDG.hBp = i2;
            this.hAr.a(aPr);
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int aBS() {
        try {
            Log.i("MicroMsg.LiveCore", "release");
            this.hAr.j(new i(this));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LiveCoreError", e2, "camera release error:" + e2.getMessage(), new Object[0]);
        }
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void c(com.tencent.mm.live.core.core.c cVar) {
        this.hAx = cVar;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final com.tencent.mm.live.core.core.b.g aBV() {
        return this.hAz;
    }

    @Override // com.tencent.mm.live.core.core.b
    public void a(com.tencent.mm.live.core.core.c cVar) {
        boolean z;
        com.tencent.mm.live.core.core.b.e eVar;
        p.h(cVar, "callback");
        if (this.hAz.hzA == g.c.LIVE_JOIN_ROOM) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.LiveCore", "entering room or already room");
            this.hAv = cVar;
            return;
        }
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("start create room");
        com.tencent.mm.live.core.core.b.g gVar = this.hAz;
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (gVar.b((fVar == null || (eVar = fVar.hwP) == null) ? null : Long.valueOf(eVar.liveId))) {
            com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GA("enter room and already in room");
            c.a.a(cVar, 0);
            return;
        }
        this.hAv = cVar;
        com.tencent.mm.live.core.core.b.g gVar2 = this.hAz;
        g.c cVar2 = g.c.LIVE_JOIN_ROOM;
        p.h(cVar2, "status");
        gVar2.hzA = cVar2;
        com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
        if (cVar3 != null) {
            cVar3.aDJ();
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void b(com.tencent.mm.live.core.core.c cVar) {
        com.tencent.mm.live.core.core.b.e eVar;
        p.h(cVar, "callback");
        com.tencent.mm.live.core.mini.c cVar2 = com.tencent.mm.live.core.mini.c.hCU;
        com.tencent.mm.live.core.core.b.g gVar = this.hAz;
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (!gVar.b((fVar == null || (eVar = fVar.hwP) == null) ? null : Long.valueOf(eVar.liveId))) {
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GA("already exit room");
            c.a.a(cVar, 0);
            return;
        }
        aBS();
        this.hAw = cVar;
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("start exit room");
        com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
        if (cVar3 != null) {
            cVar3.exitRoom();
        }
        com.tencent.mm.live.core.core.b.g gVar2 = this.hAz;
        gVar2.hzA = g.c.LIVE_OUT_ROOM;
        gVar2.hzF = -1;
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public void onEnterRoom(long j2) {
        long j3;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder append = new StringBuilder("create room ret:").append(j2).append('(');
        com.tencent.mm.live.core.a.a aVar2 = com.tencent.mm.live.core.a.a.hCB;
        com.tencent.mm.live.core.debug.a.GA(append.append(com.tencent.mm.live.core.a.a.qw((int) j2)).append(')').toString());
        com.tencent.mm.live.core.core.c cVar = this.hAv;
        if (cVar != null) {
            c.a.a(cVar, (int) j2);
        }
        this.hAv = null;
        com.tencent.mm.live.core.core.b.g gVar = this.hAz;
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (eVar = fVar.hwP) == null) {
            j3 = -1;
        } else {
            j3 = eVar.liveId;
        }
        gVar.hzA = g.c.LIVE_IN_ROOM;
        gVar.hzF = j3;
        if (j2 >= 0 && this.dMz) {
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
            p.g(aDD, "ConfigHelper.getInstance().videoConfig");
            if (aDD.bqa()) {
                this.hAm.aDU();
            }
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onExitRoom(int i2) {
        com.tencent.mm.live.core.core.c cVar;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder append = new StringBuilder("[").append(i2).append("]end exit room.(");
        com.tencent.mm.live.core.a.a aVar2 = com.tencent.mm.live.core.a.a.hCB;
        com.tencent.mm.live.core.debug.a.GA(append.append(com.tencent.mm.live.core.a.a.qw(i2)).append(')').toString());
        com.tencent.mm.live.core.core.c cVar2 = this.hAw;
        if (cVar2 != null) {
            c.a.a(cVar2, i2);
        }
        if (!(i2 == 0 || (cVar = this.hAx) == null)) {
            e.d dVar = e.d.hxF;
            c.a.a(cVar, e.d.aCu());
        }
        this.hAw = null;
    }

    @Override // com.tencent.mm.live.core.core.b
    public int a(Context context, boolean z, boolean z2, int i2, int i3) {
        Point point;
        int aCO;
        long j2;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        p.h(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        if (resources.getConfiguration().orientation == 1) {
            int i4 = au.az(context).x / 4;
            point = new Point(i4, (int) ((((float) au.az(context).y) / ((float) au.az(context).x)) * ((float) i4)));
        } else {
            int i5 = au.az(context).y / 4;
            point = new Point((int) ((((float) au.az(context).x) / ((float) au.az(context).y)) * ((float) i5)), i5);
        }
        this.hAr.cX(point.x, point.y);
        Log.i("MicroMsg.LiveCore", "floatMode context:".concat(String.valueOf(context)));
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (eVar2 = fVar.hwP) == null) {
            e.f fVar2 = e.f.hxS;
            aCO = e.f.aCO();
        } else {
            aCO = eVar2.hzo;
        }
        if (z) {
            boolean isTaskRoot = ((Activity) context).isTaskRoot();
            if (z2) {
                Log.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + ((Activity) context).moveTaskToBack(isTaskRoot) + ", isTaskRoot:" + isTaskRoot + " scene:" + aCO);
            } else {
                e.f fVar3 = e.f.hxS;
                if (aCO == e.f.aCP()) {
                    ((Activity) context).finish();
                } else {
                    ((Activity) context).finishAndRemoveTask();
                }
                Log.i("MicroMsg.LiveCore", "floatMode finishAndRemoveTask, isTaskRoot:" + isTaskRoot + " scene:" + aCO);
            }
        }
        com.tencent.mm.live.core.mini.b bVar = this.hAq;
        com.tencent.mm.live.core.core.b.f fVar4 = this.hAy;
        if (fVar4 == null || (eVar = fVar4.hwP) == null) {
            j2 = 0;
        } else {
            j2 = eVar.liveId;
        }
        boolean z3 = this.dMz;
        p.h(point, "size");
        boolean z4 = bVar.gqx;
        AbsLiveMiniView absLiveMiniView = bVar.hCO;
        com.tencent.mm.live.core.mini.f fVar5 = new com.tencent.mm.live.core.mini.f(z4, j2, z3, i2, absLiveMiniView != null ? absLiveMiniView.aEg() : 0, i3);
        a.C0388a aVar = com.tencent.mm.live.core.mini.a.hCD;
        a.b bVar2 = a.b.hCF;
        com.tencent.mm.live.core.mini.a aEi = a.b.aEi();
        AbsLiveMiniView absLiveMiniView2 = bVar.hCO;
        p.h(fVar5, "reportDataInfo");
        p.h(point, "size");
        if (absLiveMiniView2 != null) {
            int aH = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
            absLiveMiniView2.setPadding(aH, aH, aH, aH);
            boolean z5 = fVar5.gqx;
            if (!aEi.ciq()) {
                a.c cVar = new a.c(aEi, absLiveMiniView2, z5, fVar5, point);
                long nowMilliSecond = (aEi.hCC + 200) - Util.nowMilliSecond();
                if (nowMilliSecond <= 0) {
                    cVar.run();
                } else {
                    Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, add delayed:%s", Long.valueOf(nowMilliSecond));
                    MMHandlerThread.postToMainThreadDelayed(cVar, nowMilliSecond);
                }
            } else if (aEi.oWE.vk != absLiveMiniView2) {
                Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", 4, absLiveMiniView2, aEi.oWE.vk);
                aEi.oWE.oWr = true;
                aEi.oWE.state = 4;
                aEi.oWE.vk = absLiveMiniView2;
                aEi.oWE.nno = false;
                aEi.oWE.oWq = true;
                aEi.oWE.gqx = z5;
                aEi.a(fVar5);
                aEi.aEh();
                aEi.cis();
            } else {
                Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", 4, absLiveMiniView2);
            }
        }
        bVar.gqx = true;
        this.hAz.hzE = g.d.FLOAT_MODE;
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public void aBU() {
        this.hAz.hzE = g.d.NORMAL_MODE;
    }

    public final void a(com.tencent.mm.live.core.mini.d dVar) {
        p.h(dVar, "state");
        com.tencent.mm.live.core.mini.b bVar = this.hAq;
        p.h(dVar, "state");
        com.tencent.mm.ac.d.h(new b.C0389b(bVar, dVar));
    }

    public void release() {
        this.hAr.release();
        this.hAl.setListener(null);
        com.tencent.mm.live.core.mini.b bVar = this.hAq;
        if (bVar.hCN.isHeld()) {
            bVar.hCN.release();
        }
        b.a aVar = b.hAP;
        b aDB = b.aDB();
        if (aDB != null) {
            aDB.destroy();
        }
        b aDB2 = b.aDB();
        if (aDB2 != null) {
            b.a(aDB2, b.a.RunnableC0386a.hAQ);
        }
        b.a(null);
    }

    private final int k(boolean z, boolean z2) {
        com.tencent.mm.media.widget.a.c cVar;
        boolean z3;
        StringBuilder append = new StringBuilder("useCamera2:").append(z).append(", frontCamera:").append(z2).append(" fps:");
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
        p.g(aDD, "ConfigHelper.getInstance().videoConfig");
        Log.i("MicroMsg.LiveCore", append.append(aDD.aDR()).toString());
        if (z) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            cVar = new com.tencent.mm.media.widget.b.c(context);
        } else {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            cVar = new com.tencent.mm.media.widget.a.c(context2);
        }
        this.hAt = cVar;
        aDz();
        com.tencent.mm.media.widget.a.d dVar = this.hAt;
        if (dVar != null) {
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            if (!z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (dVar.v(context3, z3)) {
                return 0;
            }
        }
        Log.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        return -1;
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.c.a
    public final void ex(boolean z) {
        Log.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(z)));
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public void onError(int i2, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("live_err_code", i2);
        com.tencent.mm.live.core.core.c cVar = this.hAx;
        if (cVar != null) {
            e.d dVar = e.d.hxF;
            cVar.callback(e.d.aCs(), bundle2);
        }
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder append = new StringBuilder("[").append(i2).append("]msg:").append(str).append('(');
        com.tencent.mm.live.core.a.a aVar2 = com.tencent.mm.live.core.a.a.hCB;
        com.tencent.mm.live.core.debug.a.GA(append.append(com.tencent.mm.live.core.a.a.qw(i2)).append(')').toString());
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onWarning(int i2, String str, Bundle bundle) {
        boolean z = true;
        if (i2 == 1104) {
            if (bundle != null) {
                bundle.getString(TXLiveConstants.EVT_DESCRIPTION);
            }
            int i3 = bundle != null ? bundle.getInt("type") : 0;
            if (i3 != 1) {
                z = false;
            }
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GB("TRTC codec change! type:[1104], enctype:" + i3 + ", msg:" + str);
            if (this.dMz) {
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                boolean bqa = aDD.bqa();
                if (bqa && z != bqa) {
                    com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                    p.g(aDC2, "ConfigHelper.getInstance()");
                    com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                    p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                    aDD2.jb(z);
                    aDy();
                    this.hAm.aDU();
                }
            }
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public void onRemoteUserLeaveRoom(String str, int i2) {
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("[sdk]onRemoteUserLeaveRoom:" + str + " reason:" + i2);
        Bundle bundle = new Bundle();
        bundle.putString("live_user_id", str);
        bundle.putInt("live_user_exit_reason", i2);
        com.tencent.mm.live.core.core.c cVar = this.hAx;
        if (cVar != null) {
            e.d dVar = e.d.hxF;
            cVar.callback(e.d.aCp(), bundle);
        }
        this.hAm.Gx(str);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onUserSubStreamAvailable(String str, boolean z) {
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("onUserSubStreamAvailable:" + str + ", available:" + z);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onUserAudioAvailable(String str, boolean z) {
        com.tencent.mm.live.core.core.b.e eVar;
        LivePreviewView livePreviewView;
        com.tencent.mm.live.core.core.b.e eVar2;
        com.tencent.mm.live.core.core.b.e eVar3;
        com.tencent.mm.live.core.core.b.e eVar4;
        com.tencent.mm.live.core.core.b.e eVar5;
        LivePreviewView livePreviewView2;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + str + ", available:" + z + ", isAnchor:" + this.dMz);
        if (!z) {
            com.tencent.mm.live.core.core.b.f fVar = this.hAy;
            if (!(fVar == null || (eVar = fVar.hwP) == null)) {
                int i2 = eVar.hzo;
                e.f fVar2 = e.f.hxS;
                if (i2 == e.f.aCP() && (livePreviewView = this.hAs) != null) {
                    livePreviewView.GH(str);
                }
            }
            com.tencent.mm.live.core.core.trtc.a.b.c.bxj(str);
        } else if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.live.core.core.b.f fVar3 = this.hAy;
            if (!(fVar3 == null || (eVar5 = fVar3.hwP) == null)) {
                int i3 = eVar5.hzo;
                e.f fVar4 = e.f.hxS;
                if (i3 == e.f.aCP() && (livePreviewView2 = this.hAs) != null) {
                    livePreviewView2.X(str, 0);
                }
            }
            com.tencent.mm.live.core.core.trtc.a.b.c.Gw(str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("live_user_id", str);
        bundle.putBoolean("live_media_enable", z);
        com.tencent.mm.live.core.core.c cVar = this.hAx;
        if (cVar != null) {
            e.d dVar = e.d.hxF;
            cVar.callback(e.d.aCq(), bundle);
        }
        if (this.dMz) {
            com.tencent.mm.live.core.core.b.f fVar5 = this.hAy;
            if (!(fVar5 == null || (eVar4 = fVar5.hwP) == null)) {
                int i4 = eVar4.hzo;
                e.f fVar6 = e.f.hxS;
                if (i4 == e.f.aCO()) {
                    this.hAm.aDU();
                    return;
                }
            }
            com.tencent.mm.live.core.core.b.f fVar7 = this.hAy;
            if (!(fVar7 == null || (eVar3 = fVar7.hwP) == null)) {
                int i5 = eVar3.hzo;
                e.f fVar8 = e.f.hxS;
                if (i5 == e.f.aCP()) {
                    this.hAm.jh(false);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("invalid live scene: ");
            com.tencent.mm.live.core.core.b.f fVar9 = this.hAy;
            Log.w("MicroMsg.LiveCore", sb.append((fVar9 == null || (eVar2 = fVar9.hwP) == null) ? null : Integer.valueOf(eVar2.hzo)).toString());
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public void onFirstVideoFrame(String str, int i2, int i3, int i4) {
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("[sdk]onFirstVideoFrame uid:" + str + " ,streamType:" + i2 + " width:" + i3 + " height:" + i4);
        Bundle bundle = new Bundle();
        bundle.putString("live_user_id", str);
        bundle.putInt("live_stream_type", i2);
        bundle.putInt("live_stream_type", i2);
        bundle.putInt("live_first_frame_width", i3);
        bundle.putInt("live_first_frame_height", i4);
        com.tencent.mm.live.core.core.c cVar = this.hAx;
        if (cVar != null) {
            e.d dVar = e.d.hxF;
            cVar.callback(e.d.aCv(), bundle);
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onStatistics(TRTCStatistics tRTCStatistics) {
        long j2;
        long j3;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j4;
        ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList;
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics;
        ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList2;
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics2;
        ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList3;
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics3;
        ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList4;
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics4;
        ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList5;
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics5;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        long j5 = 0;
        int i9 = 0;
        Log.i("MicroMsg.LiveCore", "onStatistics, statics:".concat(String.valueOf(tRTCStatistics)));
        Bundle bundle = new Bundle();
        e.j jVar = e.j.hyq;
        String aDj = e.j.aDj();
        com.tencent.mm.live.core.d.b bVar = com.tencent.mm.live.core.d.b.hEQ;
        bundle.putString(aDj, com.tencent.mm.live.core.d.b.a(tRTCStatistics));
        e.j jVar2 = e.j.hyq;
        String aCY = e.j.aCY();
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (eVar2 = fVar.hwP) == null) {
            j2 = 0;
        } else {
            j2 = eVar2.liveId;
        }
        bundle.putLong(aCY, j2);
        e.j jVar3 = e.j.hyq;
        String aCZ = e.j.aCZ();
        e.i iVar = e.i.hyd;
        bundle.putInt(aCZ, e.i.aCW());
        e.j jVar4 = e.j.hyq;
        String aDa = e.j.aDa();
        e.a aVar = e.a.hxc;
        bundle.putInt(aDa, e.a.aCe());
        e.j jVar5 = e.j.hyq;
        bundle.putLong(e.j.aDb(), System.currentTimeMillis());
        e.j jVar6 = e.j.hyq;
        String aDc = e.j.aDc();
        com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
        if (fVar2 == null || (eVar = fVar2.hwP) == null) {
            j3 = 0;
        } else {
            j3 = eVar.startTime;
        }
        bundle.putLong(aDc, j3);
        if (tRTCStatistics == null || (str = String.valueOf(tRTCStatistics.appCpu)) == null) {
            str = "";
        }
        bundle.putString(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        if (tRTCStatistics == null || (arrayList5 = tRTCStatistics.localArray) == null || (tRTCLocalStatistics5 = (TRTCStatistics.TRTCLocalStatistics) j.kt(arrayList5)) == null) {
            i2 = 0;
        } else {
            i2 = tRTCLocalStatistics5.width;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, i2);
        if (tRTCStatistics == null || (arrayList4 = tRTCStatistics.localArray) == null || (tRTCLocalStatistics4 = (TRTCStatistics.TRTCLocalStatistics) j.kt(arrayList4)) == null) {
            i3 = 0;
        } else {
            i3 = tRTCLocalStatistics4.height;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, i3);
        if (tRTCStatistics == null || (arrayList3 = tRTCStatistics.localArray) == null || (tRTCLocalStatistics3 = (TRTCStatistics.TRTCLocalStatistics) j.kt(arrayList3)) == null) {
            i4 = 0;
        } else {
            i4 = tRTCLocalStatistics3.videoBitrate;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, i4);
        if (tRTCStatistics == null || (arrayList2 = tRTCStatistics.localArray) == null || (tRTCLocalStatistics2 = (TRTCStatistics.TRTCLocalStatistics) j.kt(arrayList2)) == null) {
            i5 = 0;
        } else {
            i5 = tRTCLocalStatistics2.audioBitrate;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, i5);
        if (tRTCStatistics == null || (arrayList = tRTCStatistics.localArray) == null || (tRTCLocalStatistics = (TRTCStatistics.TRTCLocalStatistics) j.kt(arrayList)) == null) {
            i6 = 0;
        } else {
            i6 = tRTCLocalStatistics.frameRate;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i6);
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, CdnLogic.getRecentAverageSpeed(2));
        e.j jVar7 = e.j.hyq;
        String aDd = e.j.aDd();
        if (tRTCStatistics != null) {
            i7 = tRTCStatistics.rtt;
        } else {
            i7 = 0;
        }
        bundle.putInt(aDd, i7);
        e.j jVar8 = e.j.hyq;
        String aDe = e.j.aDe();
        if (tRTCStatistics != null) {
            i8 = tRTCStatistics.upLoss;
        } else {
            i8 = 0;
        }
        bundle.putInt(aDe, i8);
        e.j jVar9 = e.j.hyq;
        String aDf = e.j.aDf();
        if (tRTCStatistics != null) {
            i9 = tRTCStatistics.downLoss;
        }
        bundle.putInt(aDf, i9);
        e.j jVar10 = e.j.hyq;
        String aDg = e.j.aDg();
        if (tRTCStatistics != null) {
            j4 = tRTCStatistics.sendBytes;
        } else {
            j4 = 0;
        }
        bundle.putLong(aDg, j4);
        e.j jVar11 = e.j.hyq;
        String aDh = e.j.aDh();
        if (tRTCStatistics != null) {
            j5 = tRTCStatistics.receiveBytes;
        }
        bundle.putLong(aDh, j5);
        e.j jVar12 = e.j.hyq;
        bundle.putInt(e.j.aDi(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
        com.tencent.mm.live.core.core.c cVar = this.hAx;
        if (cVar != null) {
            e.d dVar = e.d.hxF;
            cVar.callback(e.d.aCz(), bundle);
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onConnectOtherRoom(String str, int i2, String str2) {
        Log.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + str + ", err:" + i2 + ", errMsg:$" + str2);
        if (i2 == 0) {
            Bundle bundle = new Bundle();
            e.b bVar = e.b.hxe;
            bundle.putString(e.b.aCg(), str);
            com.tencent.mm.live.core.core.c cVar = this.hAx;
            if (cVar != null) {
                e.d dVar = e.d.hxF;
                cVar.callback(e.d.aCw(), bundle);
            }
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onDisConnectOtherRoom(int i2, String str) {
        Log.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + i2 + ", errMsg:" + str);
        if (i2 == 0) {
            Bundle bundle = new Bundle();
            com.tencent.mm.live.core.core.c cVar = this.hAx;
            if (cVar != null) {
                e.d dVar = e.d.hxF;
                cVar.callback(e.d.aCx(), bundle);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mm.live.core.core.trtc.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.trtc.TRTCCloudDef.TRTCQuality r4) {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.core.trtc.a.a(com.tencent.trtc.TRTCCloudDef$TRTCQuality):void");
    }

    public final TXCloudVideoView W(String str, int i2) {
        LivePreviewView livePreviewView = this.hAs;
        if (livePreviewView != null) {
            return livePreviewView.X(str, i2);
        }
        return null;
    }

    @Override // com.tencent.mm.live.core.core.trtc.a.d
    public final void onUserVideoAvailable(String str, boolean z) {
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        com.tencent.mm.live.core.core.b.e eVar3;
        LivePreviewView livePreviewView;
        Integer num = null;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("onUserVideoAvailable uid:" + str + " available:" + z + ", isAnchor:" + this.dMz);
        if (!z || TextUtils.isEmpty(str)) {
            LivePreviewView livePreviewView2 = this.hAs;
            if (livePreviewView2 != null) {
                livePreviewView2.GH(str);
            }
            this.hAm.Gv(str);
            Bundle bundle = new Bundle();
            bundle.putString("live_user_id", str);
            com.tencent.mm.live.core.core.c cVar = this.hAx;
            if (cVar != null) {
                e.d dVar = e.d.hxF;
                cVar.callback(e.d.aCt(), bundle);
            }
        } else {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar2 = this.hAm;
            LivePreviewView livePreviewView3 = this.hAs;
            cVar2.a(str, livePreviewView3 != null ? livePreviewView3.X(str, 0) : null);
            if (!this.dMz && Util.isEqual(this.hAz.hzG, str) && (livePreviewView = this.hAs) != null) {
                livePreviewView.GE(str);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("live_user_id", str);
            com.tencent.mm.live.core.core.c cVar3 = this.hAx;
            if (cVar3 != null) {
                e.d dVar2 = e.d.hxF;
                cVar3.callback(e.d.aCo(), bundle2);
            }
        }
        if (!this.dMz && !Util.isEqual(this.hAz.hzG, str)) {
            this.hAz.hzI = str;
        }
        if (this.dMz) {
            com.tencent.mm.live.core.core.b.f fVar = this.hAy;
            if (!(fVar == null || (eVar3 = fVar.hwP) == null)) {
                int i2 = eVar3.hzo;
                e.f fVar2 = e.f.hxS;
                if (i2 == e.f.aCO()) {
                    this.hAm.aDU();
                    return;
                }
            }
            com.tencent.mm.live.core.core.b.f fVar3 = this.hAy;
            if (!(fVar3 == null || (eVar2 = fVar3.hwP) == null)) {
                int i3 = eVar2.hzo;
                e.f fVar4 = e.f.hxS;
                if (i3 == e.f.aCP()) {
                    this.hAm.jh(false);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("invalid live scene: ");
            com.tencent.mm.live.core.core.b.f fVar5 = this.hAy;
            if (!(fVar5 == null || (eVar = fVar5.hwP) == null)) {
                num = Integer.valueOf(eVar.hzo);
            }
            Log.w("MicroMsg.LiveCore", sb.append(num).toString());
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void A(float f2, float f3) {
        if (this.dMz) {
            this.hAm.B(f2, f3);
        }
    }

    public boolean aDx() {
        return false;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void a(AbsLiveMiniView absLiveMiniView) {
        com.tencent.mm.live.core.mini.b bVar = this.hAq;
        com.tencent.mm.live.core.mini.e eVar = new com.tencent.mm.live.core.mini.e((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8));
        bVar.hCO = absLiveMiniView;
        AbsLiveMiniView absLiveMiniView2 = bVar.hCO;
        if (absLiveMiniView2 != null) {
            absLiveMiniView2.setClipToOutline(true);
        }
        AbsLiveMiniView absLiveMiniView3 = bVar.hCO;
        if (absLiveMiniView3 != null) {
            absLiveMiniView3.setOutlineProvider(eVar);
        }
        bVar.hCP.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bVar.hCP.setClipToOutline(true);
        bVar.hCP.setOutlineProvider(eVar);
        if (bVar.hCP.getParent() != null && (bVar.hCP.getParent() instanceof ViewGroup)) {
            ViewParent parent = bVar.hCP.getParent();
            if (parent == null) {
                throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(bVar.hCP);
            }
        }
        AbsLiveMiniView absLiveMiniView4 = bVar.hCO;
        if (absLiveMiniView4 != null) {
            absLiveMiniView4.addView(bVar.hCP, 0);
        }
    }

    public final void aDy() {
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.aDK();
        }
    }

    public final void a(com.tencent.mm.live.core.b.b bVar) {
        this.hAr.a(bVar);
    }

    public final void Gp(String str) {
        Log.i("MicroMsg.LiveCore", "updateRemoteOutputSurface userId:".concat(String.valueOf(str)));
        if (str != null) {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar = this.hAm;
            LivePreviewView livePreviewView = this.hAs;
            cVar.a(str, livePreviewView != null ? livePreviewView.X(str, 0) : null);
        }
    }

    public final void qs(int i2) {
        com.tencent.mm.live.core.b.d dVar = this.hAr;
        dVar.j(new d.j(dVar, i2));
    }

    public void Go(String str) {
        p.h(str, "privateMapKey");
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
            iVar.h("privateMapKey", str);
            com.tencent.mm.ab.i iVar2 = new com.tencent.mm.ab.i();
            iVar2.h(ProviderConstants.API_PATH, "updatePrivateMapKey");
            iVar2.h(NativeProtocol.WEB_DIALOG_PARAMS, iVar);
            Log.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + iVar2 + ' ');
            this.hAl.callExperimentalAPI(iVar2.toString());
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public int getRecordScene() {
        return 13;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public int getResolutionLimit() {
        com.tencent.mm.live.core.core.b.d dVar;
        com.tencent.mm.live.core.core.b.f fVar = this.hAy;
        if (fVar == null || (dVar = fVar.hzt) == null) {
            return 1080;
        }
        return dVar.hzj;
    }

    private void aDz() {
        b.a.C0435a aVar = new b.a.C0435a();
        com.tencent.mm.compatible.c.a aVar2 = com.tencent.mm.compatible.c.a.gDs;
        int anJ = com.tencent.mm.compatible.c.a.anJ();
        if (anJ >= 0) {
            int i2 = 0;
            while (true) {
                b.a.c cVar = new b.a.c();
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                cVar.irh = Integer.valueOf(aDD.aDR());
                com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC2, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                cVar.irg = Integer.valueOf(aDD2.aDR());
                com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC3, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD3 = aDC3.aDD();
                p.g(aDD3, "ConfigHelper.getInstance().videoConfig");
                cVar.iri = Integer.valueOf(aDD3.aDR());
                aVar.b(new o<>(Integer.valueOf(i2), cVar));
                if (i2 == anJ) {
                    break;
                }
                i2++;
            }
        }
        aVar.scene = 13;
        b.a aQz = aVar.aQz();
        com.tencent.mm.media.widget.a.d dVar = this.hAt;
        if (dVar != null) {
            dVar.a(aQz);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a {
        final /* synthetic */ a hAE;
        final /* synthetic */ com.tencent.mm.live.core.b.l hAJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, com.tencent.mm.live.core.b.l lVar) {
            super(0);
            this.hAE = aVar;
            this.hAJ = lVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            Surface surface;
            AppMethodBeat.i(196498);
            this.hAJ.hEC = null;
            com.tencent.mm.live.core.b.d dVar = this.hAE.hAr;
            SurfaceHolder surfaceHolder = this.hAJ.beb;
            if (surfaceHolder != null) {
                surface = surfaceHolder.getSurface();
            } else {
                surface = null;
            }
            dVar.bO(surface);
            AppMethodBeat.o(196498);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a hAE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.hAE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196506);
            com.tencent.mm.media.widget.a.d dVar = this.hAE.hAt;
            if (dVar != null) {
                dVar.onDestroy();
            }
            com.tencent.mm.media.widget.a.d dVar2 = this.hAE.hAt;
            if (dVar2 != null) {
                dVar2.release();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196506);
            return xVar;
        }
    }

    @Override // com.tencent.mm.live.core.core.b
    public final void aBW() {
        this.hAz.hzE = g.d.NORMAL_MODE;
        this.hAq.aEj();
    }
}
