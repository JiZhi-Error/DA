package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Constants;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWifiTipsView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p;
import com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.z;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020kH\u0002J\u0016\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0016\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0019\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020\u0005J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010 \u0001\u001a\u00030\u0001H\u0016J\u0015\u0010¡\u0001\u001a\u00030\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010£\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010¤\u0001\u001a\u00020\u0013H\u0014J\u0011\u0010¥\u0001\u001a\u00030\u00012\u0007\u0010¦\u0001\u001a\u00020\u0013J\u0007\u0010§\u0001\u001a\u00020kJ\t\u0010¨\u0001\u001a\u00020kH\u0016J\t\u0010©\u0001\u001a\u00020kH\u0014J\t\u0010ª\u0001\u001a\u00020NH\u0002J\t\u0010«\u0001\u001a\u00020\u0005H\u0002J\u0016\u0010¬\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001c\u0010­\u0001\u001a\u00020k2\b\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020kH\u0002J\t\u0010±\u0001\u001a\u00020kH\u0002J\n\u0010²\u0001\u001a\u00030\u0001H\u0002J\n\u0010³\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010´\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010¶\u0001\u001a\u00030\u00012\b\u0010·\u0001\u001a\u00030\u0001H\u0002J\b\u0010¸\u0001\u001a\u00030\u0001J\b\u0010¹\u0001\u001a\u00030\u0001J\n\u0010º\u0001\u001a\u00030\u0001H\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010¼\u0001\u001a\u00030\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u0001H\u0002J\n\u0010À\u0001\u001a\u00030\u0001H\u0002J\n\u0010Á\u0001\u001a\u00030\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030\u0001H\u0014J\u0015\u0010Ä\u0001\u001a\u00030\u00012\t\u0010Å\u0001\u001a\u0004\u0018\u00010\rH\u0002J!\u0010Æ\u0001\u001a\u00030\u00012\u0015\u0010Ç\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030É\u00010È\u0001H\u0016J(\u0010Ê\u0001\u001a\u00030\u00012\u0007\u0010Ë\u0001\u001a\u00020k2\u0007\u0010Ì\u0001\u001a\u00020k2\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001H\u0014J\u0015\u0010Ï\u0001\u001a\u00030\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010$H\u0016J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ñ\u0001\u001a\u00030\u0001H\u0014J\b\u0010Ò\u0001\u001a\u00030\u0001J\u001c\u0010Ó\u0001\u001a\u00020\u00132\u0007\u0010Ô\u0001\u001a\u00020k2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0016J\u001c\u0010×\u0001\u001a\u00030\u00012\u0007\u0010Ø\u0001\u001a\u00020\u00052\u0007\u0010Ù\u0001\u001a\u00020\u0005H\u0002J!\u0010Ú\u0001\u001a\u00030\u00012\n\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0005H\u0014J\n\u0010Ý\u0001\u001a\u00030\u0001H\u0014J\n\u0010Þ\u0001\u001a\u00030\u0001H\u0014J\n\u0010ß\u0001\u001a\u00030\u0001H\u0014J\n\u0010à\u0001\u001a\u00030\u0001H\u0014J\n\u0010á\u0001\u001a\u00030\u0001H\u0014J\n\u0010â\u0001\u001a\u00030\u0001H\u0014J\n\u0010ã\u0001\u001a\u00030\u0001H\u0002J\n\u0010ä\u0001\u001a\u00030\u0001H\u0002J\n\u0010å\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010æ\u0001\u001a\u00030\u00012\u0007\u0010ç\u0001\u001a\u00020kH\u0016J\u0016\u0010è\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\n\u0010é\u0001\u001a\u00030\u0001H\u0016J\u0016\u0010ê\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0016\u0010ë\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\n\u0010ì\u0001\u001a\u00030\u0001H\u0002J\u001b\u0010í\u0001\u001a\u00020\u00132\u0007\u0010î\u0001\u001a\u00020k2\u0007\u0010ï\u0001\u001a\u00020\u0013H\u0002J\n\u0010ð\u0001\u001a\u00030\u0001H\u0002J\n\u0010ñ\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010ò\u0001\u001a\u00030\u00012\u0007\u0010ï\u0001\u001a\u00020\u0013H\u0002J\n\u0010ó\u0001\u001a\u00030\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010l\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\b\u0010õ\u0001\u001a\u00030\u0001J\u001e\u0010ö\u0001\u001a\u00030\u00012\t\u0010÷\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010ø\u0001\u001a\u00020kH\u0002J\n\u0010ù\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010ù\u0001\u001a\u00030\u00012\b\u0010÷\u0001\u001a\u00030ú\u0001H\u0002J\n\u0010û\u0001\u001a\u00030\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010ü\u0001\u001a\u00030\u00012\u0007\u0010Û\u0001\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n \u001a*\u0004\u0018\u00010\u001f0\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001d\u0010,\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b-\u0010\tR\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001d\u0010D\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bE\u0010\tR\u001c\u0010G\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u001a\u0010J\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010\u0017R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0015\"\u0004\bS\u0010\u0017R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0015\"\u0004\bX\u0010\u0017R\u000e\u0010Y\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u000e\u0010g\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0015\"\u0004\bn\u0010\u0017R\u001a\u0010o\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0015\"\u0004\bq\u0010\u0017R\u000e\u0010r\u001a\u00020kX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020kX\u000e¢\u0006\u0002\n\u0000R#\u0010t\u001a\n \u001a*\u0004\u0018\u00010\u001f0\u001f8BX\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bu\u0010!R#\u0010w\u001a\n \u001a*\u0004\u0018\u00010x0x8BX\u0002¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\by\u0010zR\u000e\u0010|\u001a\u00020kX\u000e¢\u0006\u0002\n\u0000R%\u0010}\u001a\n \u001a*\u0004\u0018\u00010~0~8BX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\u000b\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u00020\u00078BX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\tR)\u0010\u0001\u001a\f \u001a*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\u000b\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006ý\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", Constants.PARAM_DENSITY, "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", OpenSDKTool4Assistant.EXTRA_UIN, "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI extends TmplShareWebViewToolUI implements com.tencent.mm.plugin.webview.h.a.a {
    static final /* synthetic */ kotlin.l.k[] cLI = {kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;"))};
    private final String TAG = "MicroMsg.BizVideoDetailUI";
    private HashMap _$_findViewCache;
    private float density;
    private String fQR;
    private boolean kGg;
    private final IPCRunCgi.a lma;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHG = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new b(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHH = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new c(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHI = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new ad(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHJ = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new a(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHK = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new j(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHL = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new d(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHM = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new ac(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHN = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new af(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHO = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new ab(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHP = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new aa(this));
    private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHQ = com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.a(this.pGZ, new ae(this));
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h pHR;
    private com.tencent.mm.plugin.brandservice.ui.widget.a pHS;
    private int pHT;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i pHU = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i();
    MMWebViewWithJsApi pHV;
    MMWebViewWithJsApi pHW;
    private boolean pHX;
    private boolean pHY;
    boolean pHZ;
    boolean pIa;
    boolean pIb;
    boolean pIc;
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c pId;
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b pIe = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    private boolean pIf;
    private final j.a pIg;
    private String pIh;
    private boolean pIi;
    private boolean pIj;
    private ft pIk;
    private Animation pIl;
    private Animation pIm;
    private com.tencent.mm.plugin.brandservice.ui.widget.b pIn;
    private long pIo;
    private int pIp;
    private int pIq;
    private BroadcastReceiver pIr;
    private boolean pIs;
    private boolean pIt;
    private int uin;

    static {
        AppMethodBeat.i(7140);
        AppMethodBeat.o(7140);
    }

    private final View cpY() {
        AppMethodBeat.i(7143);
        View view = (View) this.pHH.a(cLI[1]);
        AppMethodBeat.o(7143);
        return view;
    }

    private final MPVideoView cpZ() {
        AppMethodBeat.i(7145);
        MPVideoView mPVideoView = (MPVideoView) this.pHI.a(cLI[2]);
        AppMethodBeat.o(7145);
        return mPVideoView;
    }

    private final FrameLayout cqa() {
        AppMethodBeat.i(7146);
        FrameLayout frameLayout = (FrameLayout) this.pHJ.a(cLI[3]);
        AppMethodBeat.o(7146);
        return frameLayout;
    }

    private final FrameLayout cqb() {
        AppMethodBeat.i(7147);
        FrameLayout frameLayout = (FrameLayout) this.pHK.a(cLI[4]);
        AppMethodBeat.o(7147);
        return frameLayout;
    }

    private final FrameLayout cqc() {
        AppMethodBeat.i(7148);
        FrameLayout frameLayout = (FrameLayout) this.pHL.a(cLI[5]);
        AppMethodBeat.o(7148);
        return frameLayout;
    }

    private final MPVideoErrorView cqd() {
        AppMethodBeat.i(7149);
        MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) this.pHM.a(cLI[6]);
        AppMethodBeat.o(7149);
        return mPVideoErrorView;
    }

    private final MPVideoWifiTipsView cqe() {
        AppMethodBeat.i(7150);
        MPVideoWifiTipsView mPVideoWifiTipsView = (MPVideoWifiTipsView) this.pHN.a(cLI[7]);
        AppMethodBeat.o(7150);
        return mPVideoWifiTipsView;
    }

    private final LinearLayout cqf() {
        AppMethodBeat.i(7151);
        LinearLayout linearLayout = (LinearLayout) this.pHO.a(cLI[8]);
        AppMethodBeat.o(7151);
        return linearLayout;
    }

    private final FrameLayout cqg() {
        AppMethodBeat.i(7152);
        FrameLayout frameLayout = (FrameLayout) this.pHQ.a(cLI[10]);
        AppMethodBeat.o(7152);
        return frameLayout;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195896);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195896);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195895);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195895);
        return view;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "posInfo", "", "webviewId", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.m<String, Integer, kotlin.x> {
        public static final f pIv = new f();

        static {
            AppMethodBeat.i(7089);
            AppMethodBeat.o(7089);
        }

        f() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(String str, Integer num) {
            AppMethodBeat.i(175499);
            num.intValue();
            kotlin.g.b.p.h(str, "posInfo");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(175499);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "posInfo", "", "webvieId", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.m<String, Integer, kotlin.x> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(BizVideoDetailUI bizVideoDetailUI) {
            super(2);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(String str, Integer num) {
            AppMethodBeat.i(175500);
            String str2 = str;
            int intValue = num.intValue();
            kotlin.g.b.p.h(str2, "posInfo");
            BizVideoDetailUI.a(this.pIu, str2, intValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(175500);
            return xVar;
        }
    }

    public BizVideoDetailUI() {
        AppMethodBeat.i(7216);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        this.pIg = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiP(toString());
        this.pIh = "";
        this.fQR = "";
        this.pIn = new k(this);
        this.pIp = -1;
        this.pIq = -1;
        this.lma = new e(this);
        this.pIs = true;
        AppMethodBeat.o(7216);
    }

    public static final /* synthetic */ void a(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7217);
        bizVideoDetailUI.gfR();
        AppMethodBeat.o(7217);
    }

    public static final /* synthetic */ void a(BizVideoDetailUI bizVideoDetailUI, int i2, int i3) {
        AppMethodBeat.i(195894);
        bizVideoDetailUI.fe(i2, i3);
        AppMethodBeat.o(195894);
    }

    public static final /* synthetic */ void a(BizVideoDetailUI bizVideoDetailUI, long j2) {
        AppMethodBeat.i(175522);
        bizVideoDetailUI.BK(j2);
        AppMethodBeat.o(175522);
    }

    public static final /* synthetic */ void a(BizVideoDetailUI bizVideoDetailUI, String str, String str2) {
        AppMethodBeat.i(7227);
        bizVideoDetailUI.fm(str, str2);
        AppMethodBeat.o(7227);
    }

    public static final /* synthetic */ void b(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(175520);
        bizVideoDetailUI.cqj();
        AppMethodBeat.o(175520);
    }

    public static final /* synthetic */ void b(BizVideoDetailUI bizVideoDetailUI, boolean z2) {
        AppMethodBeat.i(7234);
        bizVideoDetailUI.kp(z2);
        AppMethodBeat.o(7234);
    }

    public static final /* synthetic */ boolean b(BizVideoDetailUI bizVideoDetailUI, int i2) {
        AppMethodBeat.i(175524);
        boolean Z = bizVideoDetailUI.Z(i2, true);
        AppMethodBeat.o(175524);
        return Z;
    }

    public static final /* synthetic */ void cqB() {
    }

    public static final /* synthetic */ FrameLayout e(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7220);
        FrameLayout cqg = bizVideoDetailUI.cqg();
        AppMethodBeat.o(7220);
        return cqg;
    }

    public static final /* synthetic */ MPVideoView f(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7221);
        MPVideoView cpZ = bizVideoDetailUI.cpZ();
        AppMethodBeat.o(7221);
        return cpZ;
    }

    public static final /* synthetic */ FrameLayout h(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7223);
        FrameLayout cqa = bizVideoDetailUI.cqa();
        AppMethodBeat.o(7223);
        return cqa;
    }

    public static final /* synthetic */ MPVideoWifiTipsView i(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7224);
        MPVideoWifiTipsView cqe = bizVideoDetailUI.cqe();
        AppMethodBeat.o(7224);
        return cqe;
    }

    public static final /* synthetic */ LinearLayout j(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7225);
        LinearLayout cqf = bizVideoDetailUI.cqf();
        AppMethodBeat.o(7225);
        return cqf;
    }

    public static final /* synthetic */ void l(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7226);
        bizVideoDetailUI.cqu();
        AppMethodBeat.o(7226);
    }

    public static final /* synthetic */ void n(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(175521);
        bizVideoDetailUI.cqq();
        AppMethodBeat.o(175521);
    }

    public static final /* synthetic */ MPVideoErrorView p(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7230);
        MPVideoErrorView cqd = bizVideoDetailUI.cqd();
        AppMethodBeat.o(7230);
        return cqd;
    }

    public static final /* synthetic */ void q(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7231);
        bizVideoDetailUI.cqs();
        AppMethodBeat.o(7231);
    }

    public static final /* synthetic */ void r(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7232);
        bizVideoDetailUI.cqv();
        AppMethodBeat.o(7232);
    }

    public static final /* synthetic */ void s(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7233);
        bizVideoDetailUI.cqr();
        AppMethodBeat.o(7233);
    }

    public static final /* synthetic */ View t(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7219);
        View cpY = bizVideoDetailUI.cpY();
        AppMethodBeat.o(7219);
        return cpY;
    }

    public static final /* synthetic */ FrameLayout u(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7237);
        FrameLayout cqb = bizVideoDetailUI.cqb();
        AppMethodBeat.o(7237);
        return cqb;
    }

    public static final /* synthetic */ int y(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(175523);
        int cqi = bizVideoDetailUI.cqi();
        AppMethodBeat.o(175523);
        return cqi;
    }

    public static final /* synthetic */ View z(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(7240);
        View cpt = bizVideoDetailUI.cpt();
        AppMethodBeat.o(7240);
        return cpt;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void cqh() {
        AppMethodBeat.i(7153);
        this.pIg.cra();
        super.cqh();
        if (!this.pIf) {
            this.pIf = true;
            com.tencent.mm.pluginsdk.h.q(this);
            com.tencent.mm.plugin.webview.i.a.agn(0);
        }
        getIntent().putExtra("vertical_scroll", false);
        AppMethodBeat.o(7153);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public final void cpA() {
        boolean z2;
        AppMethodBeat.i(7154);
        super.cpA();
        setBackBtn(new m(this), R.raw.actionbar_icon_dark_close);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        ff aiR = this.pIg.aiR("1");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        MpWebViewController mpWebViewController = this.pHc;
        if (mpWebViewController != null) {
            z2 = mpWebViewController.cph();
        } else {
            z2 = false;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "MiaoKai", z2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIg);
        AppMethodBeat.o(7154);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(7155);
        super.initView();
        if (cpu().iAi == null) {
            finish();
            Log.w(this.TAG, "onCreate msgInfo.item is null");
            AppMethodBeat.o(7155);
            return;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("onCreate rawUrl is ");
        com.tencent.mm.ag.v vVar = cpu().iAi;
        if (vVar == null) {
            kotlin.g.b.p.hyc();
        }
        Log.i(str, sb.append(vVar.url).toString());
        j.a aVar = this.pIg;
        com.tencent.mm.ag.v vVar2 = cpu().iAi;
        if (vVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        String str2 = vVar2.url;
        if (str2 == null) {
            str2 = "";
        }
        aVar.pLp = str2;
        this.pIg.pLn = String.valueOf(cpx());
        this.pIg.pLo = String.valueOf(System.currentTimeMillis() / 1000);
        b bVar = this.pGx;
        IPCRunCgi.a aVar2 = this.lma;
        kotlin.g.b.p.h(aVar2, "callback");
        bVar.lma = aVar2;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p pVar = this.pGy;
        BizVideoDetailUI bizVideoDetailUI = this;
        com.tencent.mm.ag.x cpu = cpu();
        b bVar2 = this.pGx;
        kotlin.g.b.p.h(bizVideoDetailUI, "ui");
        kotlin.g.b.p.h(cpu, "msgInfo");
        kotlin.g.b.p.h(bVar2, "controller");
        pVar.nhy = new WeakReference<>(bizVideoDetailUI);
        pVar.pHv = cpu;
        pVar.pIL = bVar2;
        this.pGx.pHx = ((Number) this.pGF.a(TmplShareWebViewToolUI.cLI[8])).intValue();
        this.pGx.pHC.pKJ = new WeakReference<>(cpZ());
        b bVar3 = this.pGx;
        BizVideoDetailUI bizVideoDetailUI2 = this;
        int scene = getScene();
        int subScene = getSubScene();
        com.tencent.mm.ag.v vVar3 = cpu().iAi;
        if (vVar3 == null) {
            kotlin.g.b.p.hyc();
        }
        com.tencent.mm.ag.x cpu2 = cpu();
        int cpx = cpx();
        kotlin.g.b.p.h(bizVideoDetailUI2, "ui");
        kotlin.g.b.p.h(vVar3, "readerItem");
        kotlin.g.b.p.h(cpu2, "msgInfo");
        bVar3.nhy = new WeakReference<>(bizVideoDetailUI2);
        bVar3.scene = scene;
        bVar3.pHw = subScene;
        bVar3.aiF(vVar3.url);
        bVar3.ptH = vVar3;
        bVar3.pHv = cpu2;
        bVar3.iwc = vVar3.type;
        bVar3.pHu = cpx;
        bVar3.dHc = cpu2.dHc;
        bVar3.pHo = cpu2.iAg;
        bVar3.vid = cpu2.iAi.vid;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n nVar = bVar3.pHq;
        kotlin.g.b.p.h(bVar3, "controller");
        nVar.pIL = bVar3;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m mVar = bVar3.pHC;
        kotlin.g.b.p.h(bVar3, "controller");
        mVar.pIL = bVar3;
        mVar.pLF = true;
        mVar.pLD = "";
        try {
            Uri parse = Uri.parse(cpu2.iAi.url);
            bVar3.iAQ = Util.getLong(parse.getQueryParameter("mid"), 0);
            bVar3.idx = Util.getInt(parse.getQueryParameter("idx"), 0);
        } catch (UnsupportedOperationException e2) {
            Log.w(bVar3.TAG, "init parse url exp %s", e2.getMessage());
        } catch (Exception e3) {
            Log.w(bVar3.TAG, "init parse url exp %s", e3.getMessage());
        }
        Log.i(bVar3.TAG, "init vid=" + bVar3.vid);
        b bVar4 = this.pGx;
        String stringExtra = getIntent().getStringExtra("biz_video_channel_session_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        kotlin.g.b.p.h(stringExtra, "<set-?>");
        bVar4.pHz = stringExtra;
        com.tencent.mm.plugin.webview.i.a.agn(1);
        this.pIe.reset();
        this.JjI.setMMOverScrollOffsetListener(new x(this));
        this.JjI.geV();
        this.JjI.geW();
        this.pIi = false;
        this.pIj = false;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(Integer.MAX_VALUE);
        if (this.pIr == null) {
            this.pIr = new BizVideoDetailUI$startMonitorNetWorkChange$1(this);
        }
        getContext().registerReceiver(this.pIr, intentFilter);
        AppMethodBeat.o(7155);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void bXg() {
        com.tencent.mm.plugin.webview.ui.tools.multitask.a gff;
        AppMethodBeat.i(7156);
        super.bXg();
        if (this.mHh != null) {
            try {
                this.pGx.pHC.pLE = this.mHh.IS(cpu().ajO());
                this.pGx.pHC.er(1, 0);
                com.tencent.mm.plugin.webview.stub.e eVar = this.mHh;
                kotlin.g.b.p.g(eVar, "invoker");
                this.uin = eVar.gec();
            } catch (Exception e2) {
                Log.w(this.TAG, "invoker ex :" + e2.getMessage());
            }
        }
        this.pGx.pHy = cqi();
        this.pIb = false;
        this.pGx.cpT();
        this.pIg.aiR("5");
        if (Util.isNullOrNil(cpu().iAi.title) || (gff = gff()) == null) {
            AppMethodBeat.o(7156);
            return;
        }
        gff.aCM(cpu().iAi.title);
        AppMethodBeat.o(7156);
    }

    private final int cqi() {
        AppMethodBeat.i(175507);
        if (this.mHh == null) {
            int i2 = this.pHT;
            AppMethodBeat.o(175507);
            return i2;
        }
        try {
            Bundle j2 = this.mHh.j(110, new Bundle());
            if (j2 != null) {
                this.pHT = j2.getInt("sim_card_type", 0);
            }
        } catch (Exception e2) {
            Log.w(this.TAG, "invoker ex :" + e2.getMessage());
        }
        int i3 = this.pHT;
        AppMethodBeat.o(175507);
        return i3;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class m implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        m(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(7101);
            this.pIu.hideVKB();
            BizVideoDetailUI.a(this.pIu);
            AppMethodBeat.o(7101);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
    public final void DG(int i2) {
        boolean z2;
        AppMethodBeat.i(175508);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i iVar = this.pHU;
        w wVar = new w(this);
        kotlin.g.b.p.h(wVar, "onUpdateView");
        if (iVar.width <= 0 || iVar.height <= 0) {
            Log.w("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged invalid params x=" + iVar.x + ", y=" + iVar.y + ", width=" + iVar.width + ", height=" + iVar.height);
            z2 = false;
        } else {
            int i3 = iVar.pLa;
            iVar.pLa = iVar.y - i2;
            if (iVar.pLa < i3) {
                if (iVar.pLa > 0) {
                    iVar.DN(iVar.pLa);
                } else if (iVar.pKW == 1 || iVar.pKS == iVar.mEX) {
                    z2 = iVar.DO(Math.abs(iVar.pLa));
                } else {
                    Log.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + iVar.pKS + ", screenWidth=" + iVar.mEX);
                    iVar.pKW = 1;
                    iVar.b(true, new i.c(wVar));
                    z2 = false;
                }
            } else if (iVar.pLa <= i3) {
                z2 = false;
            } else if (iVar.pLa < 0) {
                z2 = iVar.DO(Math.abs(iVar.pLa));
            } else if (iVar.pKW == 2 || iVar.pKS == iVar.width) {
                iVar.DN(iVar.pLa);
            } else {
                iVar.pKW = 2;
                iVar.b(false, new i.d(wVar));
                z2 = false;
            }
            z2 = true;
        }
        if (!z2) {
            AppMethodBeat.o(175508);
            return;
        }
        cqj();
        AppMethodBeat.o(175508);
    }

    private final void cqj() {
        AppMethodBeat.i(175509);
        View cpY = cpY();
        kotlin.g.b.p.g(cpY, "animationLayout");
        if (cpY.getVisibility() == 0) {
            View cpY2 = cpY();
            kotlin.g.b.p.g(cpY2, "animationLayout");
            dy(cpY2);
        }
        dy(cpw());
        cqu();
        AppMethodBeat.o(175509);
    }

    private final void dy(View view) {
        AppMethodBeat.i(175510);
        this.pHU.dy(view);
        AppMethodBeat.o(175510);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u001c\u0010\u0002\u001a\u00020\u00038VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", TencentLocation.EXTRA_DIRECTION, "", "quitFullScreen", "plugin-brandservice_release"})
    public static final class o implements MPVideoView.b {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b
        public final boolean isFullScreen() {
            AppMethodBeat.i(7105);
            boolean z = this.pIu.kGg;
            AppMethodBeat.o(7105);
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x009b, code lost:
            if (r0.getVisibility() == 0) goto L_0x009d;
         */
        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void xd(int r7) {
            /*
            // Method dump skipped, instructions count: 203
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.o.xd(int):void");
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b
        public final void bGL() {
            AppMethodBeat.i(7107);
            BizVideoDetailUI.a(this.pIu, "exitFullScreen", "");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIu.pIg.aiR("18");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "FullScreenSwitch", "2");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIu.pIg);
            com.tencent.mm.plugin.ball.f.f.cji();
            BizVideoDetailUI.g(this.pIu).btC();
            this.pIu.setRequestedOrientation(1);
            this.pIu.pGx.pHC.er(6, 0);
            LinearLayout j2 = BizVideoDetailUI.j(this.pIu);
            kotlin.g.b.p.g(j2, "videoAdTitleBar");
            j2.setVisibility(8);
            BizVideoDetailUI.l(this.pIu);
            AppMethodBeat.o(7107);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\u0018\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020\u001eH\u0016J\b\u00103\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0003H\u0016J\b\u00107\u001a\u00020\u001eH\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\b\u00109\u001a\u00020\u001eH\u0016J\b\u0010:\u001a\u00020\u001eH\u0016J\"\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001c\u0010@\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007¨\u0006D"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
    public static final class p implements MPVideoView.c {
        private long iJF = -1;
        private long pIA = -1;
        private boolean pIB;
        private boolean pIC;
        final /* synthetic */ BizVideoDetailUI pIu;
        private long pIx = -1;
        private boolean pIy;
        private long pIz = -1;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void BL(long j2) {
            AppMethodBeat.i(177795);
            this.pIu.pGx.pHC.er(32, (int) j2);
            Log.v(this.pIu.TAG, "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(j2)));
            AppMethodBeat.o(177795);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void onVideoPlay() {
            MPVideoView mPVideoView;
            AppMethodBeat.i(7110);
            this.pIu.pIc = false;
            b unused = this.pIu.pGx;
            this.pIu.pGx.pHC.er(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.DQ(BizVideoDetailUI.f(this.pIu).getPlayStatus()), 0);
            BizVideoDetailUI.n(this.pIu);
            BizVideoDetailUI.a(this.pIu, AssetExtension.SCENE_PLAY, "");
            if (this.iJF < 0) {
                com.tencent.mm.plugin.webview.i.a.agn(6);
                if (this.pIu.pIa) {
                    com.tencent.mm.plugin.webview.i.a.agn(19);
                }
                this.iJF = System.currentTimeMillis();
            }
            if (this.pIu.pHZ && !this.pIu.pIc && (!BizVideoDetailUI.f(this.pIu).crD() || !BizVideoDetailUI.f(this.pIu).bJb())) {
                BizVideoDetailUI.b(this.pIu, BizVideoDetailUI.f(this.pIu).getCurrPosSec() > 1);
            }
            MMHandlerThread.postToMainThreadDelayed(new a(this), 300);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i iVar = this.pIu.pHU;
            b bVar = new b(this);
            kotlin.g.b.p.h(bVar, "onUpdateView");
            if (iVar.pKU != 0 && iVar.pLa <= 0 && iVar.pKS == iVar.mEX && iVar.pKR <= iVar.pKV && !iVar.cqY() && (mPVideoView = iVar.pKX) != null && mPVideoView.isPlaying()) {
                iVar.pKT = iVar.bEm;
                ValueAnimator valueAnimator = iVar.pLb;
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                }
                iVar.pLb = ValueAnimator.ofInt(iVar.pKR, iVar.pKU);
                ValueAnimator valueAnimator2 = iVar.pLb;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(new i.f(iVar, bVar));
                }
                ValueAnimator valueAnimator3 = iVar.pLb;
                if (valueAnimator3 != null) {
                    valueAnimator3.setDuration(200L);
                }
                ValueAnimator valueAnimator4 = iVar.pLb;
                if (valueAnimator4 != null) {
                    valueAnimator4.start();
                }
            }
            this.pIu.pIg.aiS("22");
            this.pIu.pIg.aiR("21");
            AppMethodBeat.o(7110);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ p pID;

            a(p pVar) {
                this.pID = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7108);
                BizVideoDetailUI.cqB();
                AppMethodBeat.o(7108);
            }
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void onVideoPause() {
            AppMethodBeat.i(7111);
            if (BizVideoDetailUI.f(this.pIu).getPlayStatus() == 2) {
                this.pIu.pGx.pHC.er(8, 0);
            }
            BizVideoDetailUI.a(this.pIu, "pause", "");
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiR("22");
            AppMethodBeat.o(7111);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void onVideoEnded() {
            AppMethodBeat.i(7112);
            this.pIu.pGx.pHC.er(7, 0);
            BizVideoDetailUI.a(this.pIu, "ended", "");
            this.pIu.cqo();
            BizVideoDetailUI.o(this.pIu);
            if (!this.pIy) {
                this.pIy = true;
                com.tencent.mm.plugin.webview.i.a.agn(27);
            }
            AppMethodBeat.o(7112);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqC() {
            AppMethodBeat.i(175502);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i iVar = this.pIu.pHU;
            MPVideoView f2 = BizVideoDetailUI.f(this.pIu);
            kotlin.g.b.p.h(f2, "videoVideo");
            iVar.pKX = f2;
            if (!f2.bJb()) {
                iVar.cqZ();
            }
            AppMethodBeat.o(175502);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void bJl() {
            AppMethodBeat.i(195888);
            BizVideoDetailUI.a(this.pIu, "seekBegin", "");
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIu.pIg.aiR("20"), this.pIu.pIg);
            AppMethodBeat.o(195888);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqD() {
            AppMethodBeat.i(7113);
            this.pIu.pGx.pHC.er(12, 0);
            this.pIz = System.currentTimeMillis();
            BizVideoDetailUI.a(this.pIu, "seekEnd", "");
            AppMethodBeat.o(7113);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void aJq() {
            AppMethodBeat.i(195889);
            BizVideoDetailUI.a(this.pIu, "seekBegin", "");
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIu.pIg.aiR("20"), this.pIu.pIg);
            AppMethodBeat.o(195889);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqE() {
            AppMethodBeat.i(7114);
            this.pIu.pGx.pHC.er(13, 0);
            this.pIz = System.currentTimeMillis();
            BizVideoDetailUI.a(this.pIu, "seekEnd", "");
            AppMethodBeat.o(7114);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void onVideoWaiting() {
            AppMethodBeat.i(7115);
            if (this.iJF > 0) {
                BizVideoDetailUI.n(this.pIu);
            }
            this.pIx = System.currentTimeMillis();
            BizVideoDetailUI.a(this.pIu, "waiting", "");
            if (this.pIA != -1 && ((long) ((int) (System.currentTimeMillis() - this.pIA))) < 1000) {
                this.pIC = true;
            } else if (this.pIz != -1 && ((long) ((int) (System.currentTimeMillis() - this.pIz))) < 1000) {
                this.pIB = true;
            }
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            this.pIu.pIg.aiR("17");
            AppMethodBeat.o(7115);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqF() {
            String str;
            AppMethodBeat.i(7116);
            if (this.pIC) {
                this.pIu.pGx.pHC.ff((int) (System.currentTimeMillis() - this.pIx), 31);
                str = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
            } else if (this.pIB) {
                this.pIu.pGx.pHC.ff((int) (System.currentTimeMillis() - this.pIx), 30);
                str = "2";
            } else {
                this.pIu.pGx.pHC.ff((int) (System.currentTimeMillis() - this.pIx), 29);
                str = "1";
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIu.pIg.aiR("17");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "BufferReason", str);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIu.pIg, String.valueOf(System.currentTimeMillis() - 500));
            this.pIA = -1;
            this.pIz = -1;
            this.pIC = false;
            this.pIB = false;
            if (BizVideoDetailUI.f(this.pIu).isPlaying()) {
                BizVideoDetailUI.a(this.pIu, AssetExtension.SCENE_PLAY, "");
                AppMethodBeat.o(7116);
                return;
            }
            BizVideoDetailUI.a(this.pIu, "pause", "");
            AppMethodBeat.o(7116);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void aiG(String str) {
            AppMethodBeat.i(7117);
            kotlin.g.b.p.h(str, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
            this.pIu.pGx.pHC.pLD = str;
            this.pIu.pGx.pHC.er(11, 0);
            BizVideoDetailUI.p(this.pIu).setPlayError$505cff1c(str);
            BizVideoDetailUI.q(this.pIu);
            BizVideoDetailUI.a(this.pIu, "error", str);
            if (BizVideoDetailUI.f(this.pIu).getPlayStarted()) {
                com.tencent.mm.plugin.webview.i.a.agn(25);
            } else {
                com.tencent.mm.plugin.webview.i.a.agn(24);
            }
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIu.pIg.aiR("16");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "PlayErrReason", str);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIu.pIg);
            AppMethodBeat.o(7117);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void kq(boolean z) {
            boolean z2 = true;
            AppMethodBeat.i(7118);
            BizVideoDetailUI.r(this.pIu);
            if (z) {
                BizVideoDetailUI.a(this.pIu, 0L);
                AppMethodBeat.o(7118);
                return;
            }
            if (this.pIu.pHZ) {
                BizVideoDetailUI bizVideoDetailUI = this.pIu;
                if (BizVideoDetailUI.f(this.pIu).getCurrPosSec() <= 1) {
                    z2 = false;
                }
                BizVideoDetailUI.b(bizVideoDetailUI, z2);
            }
            AppMethodBeat.o(7118);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqG() {
            AppMethodBeat.i(7119);
            BizVideoDetailUI.s(this.pIu);
            this.pIu.cqz();
            AppMethodBeat.o(7119);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void a(int i2, int i3, gh ghVar) {
            Integer num = null;
            AppMethodBeat.i(175503);
            this.pIu.pIc = true;
            this.pIu.pGx.pHC.pLH = i2;
            this.pIu.pGx.pHC.pLG = i3;
            this.pIu.pGx.pHC.er(22, 0);
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIu.pIg.aiR("4");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "DefinitionBefore", String.valueOf(i2));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "DefinitionAfter", String.valueOf(i3));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar4 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "WidthBefore", String.valueOf(this.pIu.pGx.pHC.width));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar5 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "HeightBefore", String.valueOf(this.pIu.pGx.pHC.height));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar6 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "WidthAfter", String.valueOf(ghVar != null ? Integer.valueOf(ghVar.width) : null));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar7 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            if (ghVar != null) {
                num = Integer.valueOf(ghVar.height);
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "HeightAfter", String.valueOf(num));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIu.pIg);
            com.tencent.mm.plugin.webview.i.a.agn(81);
            this.pIA = System.currentTimeMillis();
            if (ghVar != null) {
                this.pIu.pGx.pHr = ghVar.pHr;
                this.pIu.pGx.pHs = ghVar.KKi;
                this.pIu.pGx.pHC.width = ghVar.width;
                this.pIu.pGx.pHC.height = ghVar.height;
            }
            BizVideoDetailUI.a(this.pIu, "switchVideo", "");
            AppMethodBeat.o(175503);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqH() {
            AppMethodBeat.i(7121);
            this.pIu.pGx.pHC.er(21, 0);
            this.pIu.pIc = true;
            this.pIu.cqo();
            com.tencent.mm.plugin.webview.i.a.agn(80);
            BizVideoDetailUI.a(this.pIu, 0L);
            AppMethodBeat.o(7121);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void cqI() {
            boolean z = true;
            AppMethodBeat.i(175504);
            this.pIu.pIc = false;
            if (this.pIu.pHZ && BizVideoDetailUI.f(this.pIu).isPlaying()) {
                BizVideoDetailUI bizVideoDetailUI = this.pIu;
                if (BizVideoDetailUI.f(this.pIu).getCurrPosSec() <= 1) {
                    z = false;
                }
                BizVideoDetailUI.b(bizVideoDetailUI, z);
            }
            AppMethodBeat.o(175504);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c
        public final void a(c.a aVar, c.a aVar2) {
            String str;
            String str2;
            AppMethodBeat.i(195890);
            this.pIu.pIg.aiS("21");
            this.pIu.pIg.aiS("22");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIu.pIg.aiR("19");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            if (aVar == null || (str = String.valueOf(aVar.pNW)) == null) {
                str = "";
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "SpeedBefore", str);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            if (aVar2 == null || (str2 = String.valueOf(aVar2.pNW)) == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "SpeedAfter", str2);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIu.pIg);
            AppMethodBeat.o(195890);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ p pID;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(p pVar) {
                super(0);
                this.pID = pVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(195887);
                BizVideoDetailUI.b(this.pID.pIu);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(195887);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        q(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7122);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            BizVideoDetailUI.f(this.pIu).p(false, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7122);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
    static final class r implements View.OnTouchListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        r(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            AppMethodBeat.i(7123);
            MPVideoView f2 = BizVideoDetailUI.f(this.pIu);
            RelativeLayout cpw = this.pIu.cpw();
            kotlin.g.b.p.g(motionEvent, "e");
            kotlin.g.b.p.h(cpw, "v");
            kotlin.g.b.p.h(motionEvent, "e");
            switch (motionEvent.getAction()) {
                case 0:
                case 2:
                    if (!f2.pOn && motionEvent.getY() >= cpw.getY() && motionEvent.getY() <= cpw.getY() + ((float) f2.getHeight()) && motionEvent.getX() >= cpw.getX() && motionEvent.getX() <= cpw.getX() + ((float) f2.getWidth())) {
                        f2.pOm = true;
                    }
                    f2.pOn = true;
                    z = f2.pOm;
                    break;
                case 1:
                case 3:
                    z = f2.pOm;
                    f2.pOm = false;
                    f2.pOn = false;
                    break;
                default:
                    z = f2.pOm;
                    break;
            }
            if (z) {
                BizVideoDetailUI.f(this.pIu).Q(motionEvent);
                if (motionEvent.getAction() == 1) {
                    motionEvent.setAction(3);
                }
            }
            AppMethodBeat.o(7123);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class s implements View.OnClickListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        s(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7124);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (BizVideoDetailUI.f(this.pIu).isPlaying()) {
                BizVideoDetailUI.f(this.pIu).pause();
                m.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
                m.a.DR(37);
            } else {
                BizVideoDetailUI.f(this.pIu).start();
                m.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
                m.a.DR(38);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7124);
        }
    }

    public final void ko(boolean z2) {
        AppMethodBeat.i(7166);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h hVar = this.pHR;
        if (hVar != null) {
            Log.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(z2)));
            if (hVar.aQs()) {
                if (z2) {
                    hVar.pKM.enable();
                    if (hVar.mSensorManager == null) {
                        Object systemService = MMApplicationContext.getContext().getSystemService("sensor");
                        if (systemService == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.hardware.SensorManager");
                            AppMethodBeat.o(7166);
                            throw tVar;
                        }
                        hVar.mSensorManager = (SensorManager) systemService;
                        SensorManager sensorManager = hVar.mSensorManager;
                        hVar.pKK = sensorManager != null ? sensorManager.getDefaultSensor(1) : null;
                        SensorManager sensorManager2 = hVar.mSensorManager;
                        if (sensorManager2 != null) {
                            sensorManager2.registerListener(hVar, hVar.pKK, 3);
                            AppMethodBeat.o(7166);
                            return;
                        }
                        AppMethodBeat.o(7166);
                        return;
                    }
                } else {
                    hVar.pKM.disable();
                    Context context = hVar.lAM.get();
                    if (context == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(7166);
                        throw tVar2;
                    }
                    ((MMActivity) context).setRequestedOrientation(1);
                    hVar.iqr = 0;
                }
            }
            AppMethodBeat.o(7166);
            return;
        }
        AppMethodBeat.o(7166);
    }

    private final void fe(int i2, int i3) {
        AppMethodBeat.i(7167);
        if (i2 > i3) {
            if (this.pHR != null) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h hVar = this.pHR;
                if (hVar != null) {
                    AppCompatActivity context = getContext();
                    kotlin.g.b.p.g(context, "context");
                    AppCompatActivity appCompatActivity = context;
                    MPVideoView cpZ = cpZ();
                    kotlin.g.b.p.h(appCompatActivity, "ctx");
                    kotlin.g.b.p.h(cpZ, "video");
                    hVar.lAM = new WeakReference<>(appCompatActivity);
                    hVar.pKJ = new WeakReference<>(cpZ);
                }
            } else {
                AppCompatActivity context2 = getContext();
                kotlin.g.b.p.g(context2, "context");
                this.pHR = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h(context2, cpZ());
            }
            ko(true);
            AppMethodBeat.o(7167);
            return;
        }
        ko(false);
        AppMethodBeat.o(7167);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void cqk() {
        AppMethodBeat.i(7169);
        com.tencent.mm.plugin.webview.ui.tools.widget.n gfh = gfh();
        gfh.setMinHeaderHeight(this.pHU.height);
        gfh.setUrl(this.fQR);
        gfh.giy();
        gfh.a(this.pGx.scene, this.pGx.pHw, this.pGx.iwc, this.pGx.pHu, this.pGx.url, cpu().iAi.title);
        gfh.setCallback(new n(this));
        gfh.setTimeLineSessionId(gfh.getTimeLineSessionId());
        AppMethodBeat.o(7169);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
    public static final class n implements n.c {
        final /* synthetic */ BizVideoDetailUI pIu;

        n(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.n.c
        public final void onHide() {
            AppMethodBeat.i(7103);
            BizVideoDetailUI.a(this.pIu, this.pIu.pHU.width, this.pIu.pHU.height);
            AppMethodBeat.o(7103);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.n.c
        public final void onShow() {
            AppMethodBeat.i(7104);
            this.pIu.ko(false);
            AppMethodBeat.o(7104);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
    public static final class x implements LogoWebViewWrapper.b {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        x(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b
        public final void aa(int i2, boolean z) {
            AppMethodBeat.i(7129);
            RelativeLayout cpw = this.pIu.cpw();
            ViewGroup.LayoutParams layoutParams = this.pIu.cpw().getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(7129);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = this.pIu.pHU.y - i2;
            cpw.setLayoutParams(layoutParams2);
            View t = BizVideoDetailUI.t(this.pIu);
            kotlin.g.b.p.g(t, "animationLayout");
            if (t.getVisibility() == 0) {
                View t2 = BizVideoDetailUI.t(this.pIu);
                kotlin.g.b.p.g(t2, "animationLayout");
                View t3 = BizVideoDetailUI.t(this.pIu);
                kotlin.g.b.p.g(t3, "animationLayout");
                ViewGroup.LayoutParams layoutParams3 = t3.getLayoutParams();
                if (layoutParams3 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    AppMethodBeat.o(7129);
                    throw tVar2;
                }
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.topMargin = this.pIu.pHU.y - i2;
                t2.setLayoutParams(layoutParams4);
            }
            AppMethodBeat.o(7129);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(7170);
        super.onResume();
        MPVideoView cpZ = cpZ();
        Log.i(MPVideoView.TAG, "onUIResume");
        if (cpZ.mwt) {
            Log.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
            cpZ.mwt = false;
            AppMethodBeat.o(7170);
            return;
        }
        MPExoVideoWrapper mPExoVideoWrapper = cpZ.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.pNo = false;
        mPExoVideoWrapper.mEw = true;
        if (mPExoVideoWrapper.pNi != null && mPExoVideoWrapper.cJj && (mPExoVideoWrapper.mEI || mPExoVideoWrapper.pNm)) {
            Log.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + mPExoVideoWrapper.mEI + ", mPlayingWhenBackground " + mPExoVideoWrapper.pNm);
            mPExoVideoWrapper.start();
        }
        AppMethodBeat.o(7170);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(7171);
        super.onStart();
        if (cpu().iAi == null) {
            finish();
            Log.w(this.TAG, "onStart msgInfo.item is null");
            AppMethodBeat.o(7171);
            return;
        }
        Log.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", cpu().iAi.iAo);
        cpt().bringToFront();
        cpZ().crr();
        AppMethodBeat.o(7171);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public final boolean cpz() {
        return true;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void Y(Bundle bundle) {
        AppMethodBeat.i(7172);
        if (this.kGg) {
            cpZ().p(false, 0);
        }
        this.pIg.aiS("21");
        this.pIg.aiS("22");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL), this.pIg);
        cqn();
        cqo();
        ko(false);
        super.Y(bundle);
        com.tencent.mm.plugin.webview.i.a.agn(18);
        this.pIa = true;
        AppMethodBeat.o(7172);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(7173);
        super.b(webView, str);
        AppMethodBeat.o(7173);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(7174);
        super.onPause();
        MPVideoView cpZ = cpZ();
        Log.i(MPVideoView.TAG, "onUIPause");
        MPExoVideoWrapper mPExoVideoWrapper = cpZ.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.pNo = true;
        mPExoVideoWrapper.pNk.apm();
        mPExoVideoWrapper.setKeepScreenOn(false);
        mPExoVideoWrapper.mEI = mPExoVideoWrapper.isPlaying();
        mPExoVideoWrapper.pause();
        mPExoVideoWrapper.mEw = false;
        AppMethodBeat.o(7174);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(7177);
        if (this.kGg) {
            int requestedOrientation = getRequestedOrientation();
            AppMethodBeat.o(7177);
            return requestedOrientation;
        }
        AppMethodBeat.o(7177);
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(7179);
        this.pIg.aiS("21");
        this.pIg.aiS("22");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR("2"), this.pIg);
        cqm();
        super.onDestroy();
        com.tencent.mm.plugin.brandservice.ui.widget.a aVar = this.pHS;
        if (aVar != null) {
            aVar.b(this.pIn);
        }
        cpB();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiQ(toString());
        AppMethodBeat.o(7179);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public final void onReset() {
        AppMethodBeat.i(7180);
        cqm();
        cpB();
        super.onReset();
        AppMethodBeat.o(7180);
    }

    @Override // com.tencent.mm.plugin.webview.h.a.a
    public final int cql() {
        AppMethodBeat.i(7181);
        MPVideoView cpZ = cpZ();
        int intValue = (cpZ != null ? Integer.valueOf(cpZ.getCurrPosSec()) : null).intValue();
        MPVideoView cpZ2 = cpZ();
        if (cpZ2 != null && intValue == cpZ2.getDuration()) {
            intValue = 0;
        }
        AppMethodBeat.o(7181);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.webview.h.a.a
    public final void ac(Map<String, Object> map) {
        com.tencent.mm.plugin.webview.k.j jVar;
        boolean z2;
        ImageView imageView;
        AppMethodBeat.i(175512);
        kotlin.g.b.p.h(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.i(this.TAG, "insertVideoNativeView");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR("8"), this.pIg);
        j.a aVar = this.pIg;
        MpWebViewController mpWebViewController = this.pHc;
        if (mpWebViewController != null) {
            jVar = mpWebViewController.IKa;
        } else {
            jVar = null;
        }
        com.tencent.mm.plugin.webview.k.j jVar3 = jVar;
        if (jVar3 != null) {
            j.a.C0896a aVar2 = j.a.C0896a.pLu;
            long bdg = jVar3.bdg("getA8KeyStart");
            long bdg2 = jVar3.bdg("getA8KeyEnd");
            long bdg3 = jVar3.bdg("onPageStarted");
            long bdg4 = jVar3.bdg("onPageFinished");
            long bdg5 = jVar3.bdg("firstScreenTimestamp");
            long bdg6 = jVar3.bdg("firstScreenTime");
            if (!(bdg5 == 0 || bdg6 == 0)) {
                bdg4 = bdg5;
            }
            if (!(bdg5 == 0 || bdg6 == 0)) {
                bdg3 = bdg5 - bdg6;
            }
            ff ffVar = new ff();
            ffVar.type = 5;
            LinkedList<fi> linkedList = ffVar.KEQ;
            fi fiVar = new fi();
            fiVar.key = "EventType";
            fiVar.iFF = "6";
            linkedList.add(fiVar);
            LinkedList<fi> linkedList2 = ffVar.KEQ;
            fi fiVar2 = new fi();
            fiVar2.key = "StartTime";
            fiVar2.iFF = (String) aVar2.invoke(Long.valueOf(bdg));
            linkedList2.add(fiVar2);
            LinkedList<fi> linkedList3 = ffVar.KEQ;
            fi fiVar3 = new fi();
            fiVar3.key = "EndTime";
            fiVar3.iFF = (String) aVar2.invoke(Long.valueOf(bdg2));
            linkedList3.add(fiVar3);
            aVar.pLt.add(ffVar);
            ff ffVar2 = new ff();
            ffVar2.type = 5;
            LinkedList<fi> linkedList4 = ffVar2.KEQ;
            fi fiVar4 = new fi();
            fiVar4.key = "EventType";
            fiVar4.iFF = "7";
            linkedList4.add(fiVar4);
            LinkedList<fi> linkedList5 = ffVar2.KEQ;
            fi fiVar5 = new fi();
            fiVar5.key = "StartTime";
            fiVar5.iFF = (String) aVar2.invoke(Long.valueOf(bdg3));
            linkedList5.add(fiVar5);
            LinkedList<fi> linkedList6 = ffVar2.KEQ;
            fi fiVar6 = new fi();
            fiVar6.key = "EndTime";
            fiVar6.iFF = (String) aVar2.invoke(Long.valueOf(bdg4));
            linkedList6.add(fiVar6);
            aVar.pLt.add(ffVar2);
        }
        d(this.pGj);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i iVar = this.pHU;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        AppCompatActivity appCompatActivity = context;
        float f2 = this.density;
        kotlin.g.b.p.h(appCompatActivity, "context");
        kotlin.g.b.p.h(map, NativeProtocol.WEB_DIALOG_PARAMS);
        iVar.x = ((int) (((float) Util.getInt((String) map.get("x"), 0)) * f2)) - 2;
        iVar.y = ((int) (((float) Util.getInt((String) map.get("y"), 0)) * f2)) - 2;
        iVar.width = ((int) (((float) Util.getInt((String) map.get("width"), 0)) * f2)) + 4;
        iVar.height = ((int) (((float) Util.getInt((String) map.get("height"), 0)) * f2)) + 4;
        iVar.pKZ = (String) map.get("reportParams");
        float f3 = Util.getFloat((String) map.get("playerMinRatioWhenPlaying"), 1.7777778f);
        float f4 = Util.getFloat((String) map.get("playerMinRatioWhenNotPlaying"), 1.7777778f);
        if (f3 <= 0.0f || f3 >= 4.0f) {
            f3 = 1.7777778f;
        }
        if (f4 <= 0.0f || f3 >= 4.0f) {
            f4 = 1.7777778f;
        }
        if (iVar.width <= 0 || iVar.height <= 0) {
            Log.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + iVar.x + ", y=" + iVar.y + ", width=" + iVar.width + ", height=" + iVar.height);
            z2 = false;
        } else {
            iVar.mEX = com.tencent.mm.cb.a.jn(appCompatActivity);
            if (iVar.x <= 0 && Math.abs(iVar.mEX - iVar.width) < 10) {
                iVar.x = 0;
                iVar.width = iVar.mEX;
            }
            iVar.pKP = iVar.x;
            iVar.pKQ = iVar.y;
            iVar.pKR = iVar.height;
            iVar.pKS = iVar.width;
            iVar.bEm = (int) (((((float) iVar.mEX) * 1.0f) / ((float) iVar.width)) * ((float) iVar.height));
            iVar.pKT = iVar.bEm;
            iVar.pKU = kotlin.k.j.na((int) ((((float) iVar.mEX) * 1.0f) / f3), iVar.bEm);
            iVar.pKV = kotlin.k.j.na((int) ((((float) iVar.mEX) * 1.0f) / f4), iVar.bEm);
            if (iVar.pKU == iVar.pKV && Math.abs(iVar.pKV - iVar.bEm) < 10) {
                iVar.pKU = iVar.bEm;
                iVar.pKV = iVar.bEm;
            }
            Log.i("MicroMsg.BizVideoPosHelper", "init x=" + iVar.x + ", y=" + iVar.y + ", width=" + iVar.width + ", height=" + iVar.height + ", screenWidth=" + iVar.mEX + ", minVideoHeightWhenPlay = " + iVar.pKU + ", minVideoHeightWhenPause = " + iVar.pKV);
            z2 = true;
        }
        this.pIj = z2;
        this.pGx.pHA = Util.getInt((String) map.get("landingType"), 0);
        if (this.pIj) {
            cpw().addView(cqg());
            if (this.pHU.width > 0 && this.pHU.height > 0) {
                fe(this.pHU.width, this.pHU.height);
            }
            cpZ().a((ImageView) this.pHG.a(cLI[0]), cpu().iAi.iAo, this.pHU.width, this.pHU.pKR, cpu());
            MPVideoView cpZ = cpZ();
            String str = cpu().iAi.iAo;
            int i2 = this.pHU.width;
            int i3 = this.pHU.pKR;
            com.tencent.mm.ag.x cpu = cpu();
            kotlin.g.b.p.h(cpu, "msgInfo");
            MPExoVideoWrapper mPExoVideoWrapper = cpZ.pNZ;
            if (mPExoVideoWrapper != null) {
                imageView = mPExoVideoWrapper.getCoverIv();
            } else {
                imageView = null;
            }
            cpZ.a(imageView, str, i2, i3, cpu);
            dy(cpw());
            View cpY = cpY();
            kotlin.g.b.p.g(cpY, "animationLayout");
            dy(cpY);
            this.pHU.a(0, cpZ());
            Log.i(this.TAG, "initVideoParam minVideoHeight " + this.pHU.pKR + " maxVideoHeight " + this.pHU.bEm);
            View cpY2 = cpY();
            kotlin.g.b.p.g(cpY2, "animationLayout");
            cpY2.setVisibility(0);
            cpt().bringToFront();
            cpZ().setFullScreenDelegate(new o(this));
            cpZ().setMPVideoViewCallBack(new p(this));
            ((View) this.pHP.a(cLI[9])).setOnClickListener(new q(this));
            getWebView().setOnCustomTouchListener(new r(this));
            cpZ().setTitle(cpu().iAi.title);
            cpZ().setPlayBtnOnClickListener(new s(this));
            MPVideoErrorView cqd = cqd();
            b bVar = this.pGx;
            kotlin.g.b.p.h(bVar, "controller");
            cqd.gvQ.setOnClickListener(new MPVideoErrorView.a(cqd, bVar));
            b(this.pIk);
        }
        AppMethodBeat.o(175512);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
    public final void cpB() {
        AppMethodBeat.i(175513);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h hVar = this.pHR;
        if (hVar != null) {
            hVar.release();
        }
        cqA();
        this.pIe.reset();
        gfj();
        this.pGy.onDestroy();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.cL(cqp(), cql());
        this.pGx.onDestroy();
        cqn();
        cqo();
        cpZ().onUIDestroy();
        AppMethodBeat.o(175513);
    }

    private void cqm() {
        AppMethodBeat.i(195892);
        if (cpZ().isPlaying()) {
            cpZ().crA();
        }
        fm("leavePage", "");
        this.pIg.report();
        this.pGx.pHC.pLB = cpZ().getEndPlayTime();
        if (this.pGz != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.nqe = (currentTimeMillis - this.pGA) + this.nqe;
            this.pGx.pHC.pLC = (int) (this.nqe / 1000);
        }
        this.pGx.pHC.pLA = (int) cpZ().getRealPlayTime();
        this.pGx.pHC.er(2, 0);
        if (!this.pIb) {
            com.tencent.mm.plugin.webview.i.a.agn(22);
            AppMethodBeat.o(195892);
            return;
        }
        if (cpZ().getPlayStart() && !cpZ().getPlayStarted()) {
            com.tencent.mm.plugin.webview.i.a.agn(26);
        }
        AppMethodBeat.o(195892);
    }

    private void cqn() {
        com.tencent.xweb.ac acVar;
        com.tencent.xweb.ac acVar2;
        AppMethodBeat.i(7183);
        if (this.pHV == null) {
            AppMethodBeat.o(7183);
            return;
        }
        com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
        if (hVar != null) {
            hVar.aYd("disappear");
        }
        com.tencent.mm.plugin.webview.d.h hVar2 = this.IBw;
        if (hVar2 != null) {
            hVar2.aYd("destroy");
        }
        FrameLayout cqa = cqa();
        if (cqa != null) {
            cqa.setVisibility(8);
        }
        FrameLayout cqa2 = cqa();
        if (cqa2 != null) {
            cqa2.removeView(this.pHV);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi = this.pHV;
        if (mMWebViewWithJsApi != null) {
            acVar = mMWebViewWithJsApi.getCurWebviewClient();
        } else {
            acVar = null;
        }
        if (acVar instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k) {
            MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHV;
            if (mMWebViewWithJsApi2 != null) {
                acVar2 = mMWebViewWithJsApi2.getCurWebviewClient();
            } else {
                acVar2 = null;
            }
            if (acVar2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
                AppMethodBeat.o(7183);
                throw tVar;
            }
            ((com.tencent.mm.plugin.webview.ui.tools.widget.k) acVar2).cleanup();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHV;
        if (mMWebViewWithJsApi3 != null) {
            mMWebViewWithJsApi3.destroy();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi4 = this.pHV;
        if (mMWebViewWithJsApi4 != null) {
            mMWebViewWithJsApi4.setWebChromeClient(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi5 = this.pHV;
        if (mMWebViewWithJsApi5 != null) {
            mMWebViewWithJsApi5.setWebViewClient(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi6 = this.pHV;
        if (mMWebViewWithJsApi6 != null) {
            mMWebViewWithJsApi6.setOnTouchListener(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi7 = this.pHV;
        if (mMWebViewWithJsApi7 != null) {
            mMWebViewWithJsApi7.setOnLongClickListener(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi8 = this.pHV;
        if (mMWebViewWithJsApi8 != null) {
            mMWebViewWithJsApi8.setVisibility(8);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi9 = this.pHV;
        if (mMWebViewWithJsApi9 != null) {
            mMWebViewWithJsApi9.removeAllViews();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi10 = this.pHV;
        if (mMWebViewWithJsApi10 != null) {
            mMWebViewWithJsApi10.clearView();
        }
        this.pHV = null;
        this.pHX = false;
        cqt();
        AppMethodBeat.o(7183);
    }

    public final void cqo() {
        com.tencent.xweb.ac acVar;
        com.tencent.xweb.ac acVar2;
        AppMethodBeat.i(7184);
        if (this.pHW == null) {
            AppMethodBeat.o(7184);
            return;
        }
        com.tencent.mm.plugin.webview.i.a.agn(61);
        if (!this.pHY) {
            com.tencent.mm.plugin.webview.i.a.agn(62);
        }
        com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
        if (hVar != null) {
            int cqy = cqy();
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
            if (mMWebViewWithJsApi == null) {
                kotlin.g.b.p.hyc();
            }
            hVar.P(cqy, mMWebViewWithJsApi.hashCode(), "disappear");
        }
        com.tencent.mm.plugin.webview.d.h hVar2 = this.IBw;
        if (hVar2 != null) {
            int cqy2 = cqy();
            MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
            if (mMWebViewWithJsApi2 == null) {
                kotlin.g.b.p.hyc();
            }
            hVar2.P(cqy2, mMWebViewWithJsApi2.hashCode(), "destroy");
        }
        FrameLayout cqb = cqb();
        if (cqb != null) {
            cqb.setVisibility(8);
        }
        FrameLayout cqb2 = cqb();
        if (cqb2 != null) {
            cqb2.removeView(this.pHW);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHW;
        if (mMWebViewWithJsApi3 != null) {
            acVar = mMWebViewWithJsApi3.getCurWebviewClient();
        } else {
            acVar = null;
        }
        if (acVar instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k) {
            MMWebViewWithJsApi mMWebViewWithJsApi4 = this.pHW;
            if (mMWebViewWithJsApi4 != null) {
                acVar2 = mMWebViewWithJsApi4.getCurWebviewClient();
            } else {
                acVar2 = null;
            }
            if (acVar2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
                AppMethodBeat.o(7184);
                throw tVar;
            }
            ((com.tencent.mm.plugin.webview.ui.tools.widget.k) acVar2).cleanup();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi5 = this.pHW;
        if (mMWebViewWithJsApi5 != null) {
            mMWebViewWithJsApi5.destroy();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi6 = this.pHW;
        if (mMWebViewWithJsApi6 != null) {
            mMWebViewWithJsApi6.setWebChromeClient(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi7 = this.pHW;
        if (mMWebViewWithJsApi7 != null) {
            mMWebViewWithJsApi7.setWebViewClient(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi8 = this.pHW;
        if (mMWebViewWithJsApi8 != null) {
            mMWebViewWithJsApi8.setOnTouchListener(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi9 = this.pHW;
        if (mMWebViewWithJsApi9 != null) {
            mMWebViewWithJsApi9.setOnLongClickListener(null);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi10 = this.pHW;
        if (mMWebViewWithJsApi10 != null) {
            mMWebViewWithJsApi10.setVisibility(8);
        }
        MMWebViewWithJsApi mMWebViewWithJsApi11 = this.pHW;
        if (mMWebViewWithJsApi11 != null) {
            mMWebViewWithJsApi11.removeAllViews();
        }
        MMWebViewWithJsApi mMWebViewWithJsApi12 = this.pHW;
        if (mMWebViewWithJsApi12 != null) {
            mMWebViewWithJsApi12.clearView();
        }
        this.pHW = null;
        this.pHY = false;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
        if (cVar != null) {
            cVar.dvh = false;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar2 = this.pId;
        if (cVar2 != null) {
            cVar2.pKq = false;
        }
        this.pId = null;
        AppMethodBeat.o(7184);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        boolean z2 = true;
        AppMethodBeat.i(7185);
        if (this.kGg) {
            cpZ().p(false, 0);
            AppMethodBeat.o(7185);
            return;
        }
        com.tencent.mm.plugin.webview.ui.tools.widget.n gfh = gfh();
        if (gfh.getSayFooter().giw() && gfh.bJw()) {
            gfh.getSayFooter().fjJ();
        } else if (gfh.JjT == -3 || !gfh.bJw()) {
            z2 = false;
        } else {
            gfh.hide();
        }
        if (!z2) {
            super.onBackPressed();
        }
        AppMethodBeat.o(7185);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(7186);
        kotlin.g.b.p.h(keyEvent, "event");
        Log.i(this.TAG, "onKeyDown keyCode %d", Integer.valueOf(i2));
        if (i2 != 4 || !this.kGg) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(7186);
            return onKeyDown;
        }
        cpZ().p(false, 0);
        AppMethodBeat.o(7186);
        return true;
    }

    public final void a(ft ftVar) {
        Throwable th;
        byte[] bArr;
        int i2 = -1;
        Integer num = null;
        Throwable th2 = null;
        AppMethodBeat.i(7187);
        if (ftVar == null) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR = this.pIg.aiR("5");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, "IfSuccess", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, this.pIg);
            AppMethodBeat.o(7187);
            return;
        }
        int i3 = ftVar.KJz;
        b bVar = this.pGx;
        bVar.iwg = i3;
        if (bVar.cpW()) {
            com.tencent.mm.ag.x xVar = bVar.pHv;
            if (xVar == null) {
                kotlin.g.b.p.btv("msgInfo");
            }
            com.tencent.mm.ag.x xVar2 = bVar.pHv;
            if (xVar2 == null) {
                kotlin.g.b.p.btv("msgInfo");
            }
            xVar.iwg = xVar2.iwg | 1;
        }
        this.pGy.ani();
        com.tencent.mm.plugin.webview.d.h hVar = ((TmplShareWebViewToolUI) this).IBw;
        if (hVar != null) {
            if (i3 != -1) {
                Object[] objArr = (i3 & 8) == 0 ? 1 : null;
                Object[] objArr2 = (i3 & 16) == 0 ? 1 : null;
                i2 = objArr != null ? 1 : 0;
                if (objArr2 != null) {
                    i2 |= 2;
                }
                Log.i(((TmplShareWebViewToolUI) this).TAG, "convertFuncFlag %d", Integer.valueOf(i2));
            }
            hVar.gi("setFuncFlag", i2);
        }
        if (ftVar.KJD != null && this.pGx.cpW()) {
            this.pGx.pHB = ftVar.KJD;
        }
        this.pGx.vid = ftVar.vid;
        j.a aVar = this.pIg;
        String str = ftVar.vid;
        if (str == null) {
            str = "";
        }
        aVar.pLq = str;
        this.pIg.pLr = String.valueOf(getScene());
        this.pIg.pLs = String.valueOf(getSubScene());
        String str2 = ftVar.KJC;
        if (str2 != null) {
            this.pGx.pHp = str2;
        }
        this.pGx.aiF(ftVar.url);
        String str3 = ftVar.url;
        if (str3 != null) {
            this.fQR = str3;
        }
        if (ftVar.KJB == null || ftVar.KJB.dOK == 0) {
            cqr();
            LinkedList<ckn> linkedList = ftVar.KJH;
            if (linkedList != null) {
                LinkedList<ckn> linkedList2 = linkedList;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
                for (T t2 : linkedList2) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.pKk;
                    String str4 = t2.url;
                    String str5 = t2.MpY;
                    if (Util.isNullOrNil(str4) || Util.isNullOrNil(str5)) {
                        Log.v(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.TAG, "save null");
                    } else if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.cqV()) {
                        Log.v(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.TAG, "isProxyOpen false");
                    } else {
                        StringBuilder append = new StringBuilder().append(((com.tencent.mm.vfs.o) com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.pKj.getSlot()).getPath()).append('/');
                        Uri parse = Uri.parse(str4);
                        kotlin.g.b.p.g(parse, "Uri.parse(url)");
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(append.append(parse.getLastPathSegment()).toString());
                        if (!oVar.exists()) {
                            String parent = oVar.getParent();
                            if (parent == null) {
                                kotlin.g.b.p.hyc();
                            }
                            new com.tencent.mm.vfs.o(parent).mkdirs();
                            oVar.createNewFile();
                        }
                        OutputStream ap = com.tencent.mm.vfs.s.ap(oVar);
                        try {
                            OutputStream outputStream = ap;
                            if (str5 != null) {
                                Charset charset = kotlin.n.d.UTF_8;
                                if (str5 == null) {
                                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(7187);
                                    throw tVar;
                                }
                                bArr = str5.getBytes(charset);
                                kotlin.g.b.p.g(bArr, "(this as java.lang.String).getBytes(charset)");
                            } else {
                                bArr = null;
                            }
                            outputStream.write(bArr);
                            Log.v(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.TAG, "save content = ".concat(String.valueOf(str5)));
                            kotlin.x xVar3 = kotlin.x.SXb;
                            kotlin.f.b.a(ap, null);
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            kotlin.f.b.a(ap, th2);
                            AppMethodBeat.o(7187);
                            throw th;
                        }
                    }
                    arrayList.add(kotlin.x.SXb);
                }
            }
            if (Util.isNullOrNil(ftVar.KJu)) {
                Log.w(this.TAG, "url_info is null");
                com.tencent.mm.plugin.webview.i.a.agn(4);
                AppMethodBeat.o(7187);
                return;
            }
            MPVideoView cpZ = cpZ();
            com.tencent.mm.ag.x cpu = cpu();
            String str6 = ftVar.KJI;
            if (str6 == null) {
                str6 = "";
            }
            kotlin.g.b.p.h(cpu, "msgInfo");
            kotlin.g.b.p.h(str6, "iconUrl");
            MPVideoViewControlBar mPVideoViewControlBar = cpZ.pOa;
            if (mPVideoViewControlBar == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar.T(cpu.iAg, cpu.ajO(), str6);
            this.pIi = true;
            LinkedList<gh> linkedList3 = ftVar.KJu;
            kotlin.g.b.p.g(linkedList3, "resp.url_info");
            gh K = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.K(linkedList3);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            ff aiR2 = this.pIg.aiR("5");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar4 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "AutoPlay", "1");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar5 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "SpeedAfter", "1");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar6 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "DefinitionAfter", String.valueOf(K != null ? Integer.valueOf(K.KKg) : null));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar7 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "WidthAfter", String.valueOf(K != null ? Integer.valueOf(K.width) : null));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar8 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            if (K != null) {
                num = Integer.valueOf(K.height);
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "HeigthAfter", String.valueOf(num));
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar9 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "IfSuccess", "1");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, this.pIg);
            b(ftVar);
            AppMethodBeat.o(7187);
            return;
        }
        Log.i(this.TAG, "play_error_info msg:" + ftVar.KJB.dOL + " errCode:" + ftVar.KJB.dOK);
        cqd().setPlayError$505cff1c(ftVar.KJB.dOL);
        cqs();
        com.tencent.mm.plugin.webview.i.a.agn(32);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar10 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        ff aiR3 = this.pIg.aiR("5");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar11 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR3, "IfSuccess", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR3, this.pIg);
        AppMethodBeat.o(7187);
    }

    private final String cqp() {
        AppMethodBeat.i(7188);
        String str = cpu().ajO() + '_' + this.uin + '_' + this.pGx.vid;
        AppMethodBeat.o(7188);
        return str;
    }

    private final void b(ft ftVar) {
        int aiT;
        int i2 = 0;
        AppMethodBeat.i(175514);
        if (ftVar == null) {
            AppMethodBeat.o(175514);
            return;
        }
        com.tencent.mm.plugin.brandservice.ui.widget.c cVar = com.tencent.mm.plugin.brandservice.ui.widget.c.pNP;
        com.tencent.mm.plugin.brandservice.ui.widget.c.crz();
        this.pIk = ftVar;
        Log.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.pIi + ", insertVideoDone: " + this.pIj);
        if (!this.pIi || !this.pIj) {
            AppMethodBeat.o(175514);
            return;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m mVar = this.pGx.pHC;
        LinkedList<gh> linkedList = ftVar.KJu;
        kotlin.g.b.p.g(linkedList, "resp.url_info");
        mVar.L(linkedList);
        com.tencent.mm.plugin.webview.i.a.agn(23);
        LinkedList<gh> linkedList2 = ftVar.KJu;
        kotlin.g.b.p.g(linkedList2, "resp.url_info");
        gh K = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.K(linkedList2);
        if (K == null) {
            AppMethodBeat.o(175514);
            return;
        }
        this.pGx.pHC.pLG = K.KKg;
        this.pGx.pHr = K.pHr;
        this.pGx.pHs = K.KKi;
        Log.i(this.TAG, "doPlayVideo filesize=" + this.pGx.pHr + " wifiTipsFlag=" + this.pGx.pHs);
        boolean z2 = (ftVar.KJy & 1) != 0;
        if (gff() == null || !gff().eqW()) {
            aiT = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.aiT(cqp());
        } else {
            com.tencent.mm.plugin.webview.ui.tools.multitask.a gff = gff();
            kotlin.g.b.p.g(gff, "webMultiTaskHelper");
            aiT = gff.ghY();
        }
        cpZ().setInitialTime(aiT * 1000);
        eb ebVar = ftVar.KJG;
        if (ebVar != null) {
            cpZ().a(ebVar.bDU, ebVar.bDY, ebVar.KHY, ebVar.KHZ, ebVar.mCp, ebVar.mCq);
            Log.i(this.TAG, "maxInitBitrate = " + ebVar.bDU + ", bandFraction = " + ebVar.bDY + ", minDur = " + ebVar.KHY + ", maxDur = " + ebVar.KHZ + ", minBuffer = " + ebVar.mCp + ", maxBuffer = " + ebVar.mCq);
        }
        this.pHZ = false;
        if (!Z(K.KKd / 1000, false)) {
            BK(0);
        } else if (z2) {
            kp(false);
        } else {
            this.pHZ = true;
        }
        cpZ().setAutoPlay(z2);
        if (!z2) {
            cqq();
        }
        this.pGx.pHC.width = K.width;
        this.pGx.pHC.height = K.height;
        MPVideoView cpZ = cpZ();
        String str = K.url;
        kotlin.g.b.p.g(str, "urlInfo.url");
        cpZ.cN(str, K.KKd / 1000);
        MPVideoView cpZ2 = cpZ();
        if (K.width > K.height) {
            i2 = 90;
        }
        cpZ2.setFullScreenDirection(i2);
        fe(K.width, K.height);
        if (K.width > 0 && K.height > 0 && cpu().iAi.videoWidth <= 0 && cpu().iAi.videoHeight <= 0) {
            cpu().iAi.videoWidth = K.width;
            cpu().iAi.videoHeight = K.height;
        }
        MPVideoView cpZ3 = cpZ();
        LinkedList<gh> linkedList3 = ftVar.KJu;
        kotlin.g.b.p.g(linkedList3, "resp.url_info");
        cpZ3.a(linkedList3, K);
        AppMethodBeat.o(175514);
    }

    private final void cqq() {
        AppMethodBeat.i(175515);
        View cpY = cpY();
        kotlin.g.b.p.g(cpY, "animationLayout");
        cpY.setVisibility(8);
        AppMethodBeat.o(175515);
    }

    private final void cqr() {
        AppMethodBeat.i(7189);
        MPVideoErrorView cqd = cqd();
        kotlin.g.b.p.g(cqd, "videoErrView");
        if (cqd.getVisibility() == 0) {
            MPVideoErrorView cqd2 = cqd();
            kotlin.g.b.p.g(cqd2, "videoErrView");
            cqd2.setVisibility(8);
            fe(this.pHU.width, this.pHU.height);
        }
        AppMethodBeat.o(7189);
    }

    private final void cqs() {
        AppMethodBeat.i(7190);
        MPVideoErrorView cqd = cqd();
        kotlin.g.b.p.g(cqd, "videoErrView");
        cqd.setVisibility(0);
        ko(false);
        AppMethodBeat.o(7190);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void kp(boolean r8) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.kp(boolean):void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class y implements Runnable {
        final /* synthetic */ BizVideoDetailUI pIu;

        y(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void run() {
            AppMethodBeat.i(175506);
            BizVideoDetailUI.a(this.pIu, 300L);
            AppMethodBeat.o(175506);
        }
    }

    private final void BK(long j2) {
        AppMethodBeat.i(175516);
        MPVideoWifiTipsView cqe = cqe();
        kotlin.g.b.p.g(cqe, "videoWifiTipsView");
        if (cqe.getVisibility() != 8) {
            if (j2 > 0) {
                if (this.pIm == null) {
                    this.pIm = AnimationUtils.loadAnimation(getContext(), R.anim.dr);
                    Animation animation = this.pIm;
                    if (animation != null) {
                        animation.setDuration(j2);
                    }
                }
                cqe().clearAnimation();
                cqe().startAnimation(this.pIm);
            }
            MMHandlerThread.postToMainThreadDelayed(new l(this), j2);
        }
        AppMethodBeat.o(175516);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ BizVideoDetailUI pIu;

        l(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void run() {
            AppMethodBeat.i(175501);
            MPVideoWifiTipsView i2 = BizVideoDetailUI.i(this.pIu);
            kotlin.g.b.p.g(i2, "videoWifiTipsView");
            i2.setVisibility(8);
            AppMethodBeat.o(175501);
        }
    }

    private final void cqt() {
        AppMethodBeat.i(7193);
        FrameLayout cqa = cqa();
        if (cqa != null) {
            if (cqa.getVisibility() == 8) {
                MPVideoWifiTipsView cqe = cqe();
                kotlin.g.b.p.g(cqe, "videoWifiTipsView");
                if (cqe.getVisibility() == 8) {
                    LinearLayout cqf = cqf();
                    kotlin.g.b.p.g(cqf, "videoAdTitleBar");
                    cqf.setVisibility(8);
                }
            }
            AppMethodBeat.o(7193);
            return;
        }
        AppMethodBeat.o(7193);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
    public static final class k extends com.tencent.mm.plugin.brandservice.ui.widget.b {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.b
        public final void Na() {
            AppMethodBeat.i(7099);
            this.pIu.kGg = false;
            if (BizVideoDetailUI.f(this.pIu).getParent() == null) {
                BizVideoDetailUI.e(this.pIu).addView(BizVideoDetailUI.f(this.pIu), 0);
            }
            AppMethodBeat.o(7099);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final boolean Z(Bundle bundle) {
        AppMethodBeat.i(7195);
        if (isFinishing()) {
            AppMethodBeat.o(7195);
            return false;
        } else if (bundle == null || !bundle.containsKey("adUrl")) {
            Log.w(this.TAG, "createAdWebview url not found");
            AppMethodBeat.o(7195);
            return false;
        } else if (this.pHV != null) {
            Log.w(this.TAG, "createAdWebview adWebView existed!");
            AppMethodBeat.o(7195);
            return false;
        } else {
            com.tencent.mm.plugin.webview.i.a.agn(28);
            String string = bundle.getString("adUrl");
            Log.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(string)));
            this.pHX = false;
            a aVar = a.pHf;
            MMWebViewWithJsApi hY = MMWebViewWithJsApi.a.hY(getContext());
            kotlin.g.b.p.g(hY, "MMWebViewWithJsApi.Factory.create(this.context)");
            this.pHV = a.a(hY, cpv(), f.pIv, g.pIw, aXI(cpu().ajO()));
            a(this.pHV);
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHV;
            if (mMWebViewWithJsApi != null) {
                mMWebViewWithJsApi.loadUrl(string);
            }
            FrameLayout cqa = cqa();
            if (cqa != null) {
                cqa.removeAllViews();
            }
            FrameLayout cqc = cqc();
            if (cqc != null) {
                cqc.addView(this.pHV);
            }
            MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHV;
            if (mMWebViewWithJsApi2 != null) {
                mMWebViewWithJsApi2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(7195);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(7083);
            ImageView imageView = (ImageView) BizVideoDetailUI.z(this.pIu).findViewById(R.id.a9l);
            AppMethodBeat.o(7083);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(7084);
            View findViewById = BizVideoDetailUI.z(this.pIu).findViewById(R.id.a9k);
            AppMethodBeat.o(7084);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<MPVideoView> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MPVideoView invoke() {
            AppMethodBeat.i(7137);
            AppCompatActivity context = this.pIu.getContext();
            kotlin.g.b.p.g(context, "this.context");
            MPVideoView mPVideoView = new MPVideoView(context);
            AppMethodBeat.o(7137);
            return mPVideoView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(7082);
            FrameLayout playerAdContainerLayout = BizVideoDetailUI.f(this.pIu).getPlayerAdContainerLayout();
            AppMethodBeat.o(7082);
            return playerAdContainerLayout;
        }
    }

    private static void a(MMWebViewWithJsApi mMWebViewWithJsApi) {
        com.tencent.xweb.z settings;
        com.tencent.xweb.z settings2;
        com.tencent.xweb.z settings3;
        com.tencent.xweb.z settings4;
        com.tencent.xweb.z settings5;
        com.tencent.xweb.z settings6;
        AppMethodBeat.i(7196);
        if (mMWebViewWithJsApi != null) {
            mMWebViewWithJsApi.setCleanOnDetached(false);
        }
        if (!(mMWebViewWithJsApi == null || (settings6 = mMWebViewWithJsApi.getSettings()) == null)) {
            settings6.hsT();
        }
        if (!(mMWebViewWithJsApi == null || (settings5 = mMWebViewWithJsApi.getSettings()) == null)) {
            settings5.setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
        }
        if (!(mMWebViewWithJsApi == null || (settings4 = mMWebViewWithJsApi.getSettings()) == null)) {
            settings4.hsW();
        }
        if (!(mMWebViewWithJsApi == null || (settings3 = mMWebViewWithJsApi.getSettings()) == null)) {
            settings3.hsU();
        }
        if (!(mMWebViewWithJsApi == null || (settings2 = mMWebViewWithJsApi.getSettings()) == null)) {
            settings2.hsS();
        }
        if (!(mMWebViewWithJsApi == null || (settings = mMWebViewWithJsApi.getSettings()) == null)) {
            settings.hsR();
        }
        if (mMWebViewWithJsApi != null) {
            mMWebViewWithJsApi.setOnLongClickListener(t.pIE);
            AppMethodBeat.o(7196);
            return;
        }
        AppMethodBeat.o(7196);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(7098);
            FrameLayout dotContainerLayout = BizVideoDetailUI.f(this.pIu).getDotContainerLayout();
            AppMethodBeat.o(7098);
            return dotContainerLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(7086);
            FrameLayout backgroudContainerLayout = BizVideoDetailUI.f(this.pIu).getBackgroudContainerLayout();
            AppMethodBeat.o(7086);
            return backgroudContainerLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<MPVideoErrorView> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MPVideoErrorView invoke() {
            AppMethodBeat.i(7136);
            MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) BizVideoDetailUI.f(this.pIu).findViewById(R.id.fls);
            AppMethodBeat.o(7136);
            return mPVideoErrorView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<MPVideoWifiTipsView> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MPVideoWifiTipsView invoke() {
            AppMethodBeat.i(7139);
            MPVideoWifiTipsView mPVideoWifiTipsView = (MPVideoWifiTipsView) BizVideoDetailUI.f(this.pIu).findViewById(R.id.fm2);
            AppMethodBeat.o(7139);
            return mPVideoWifiTipsView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(7135);
            LinearLayout linearLayout = (LinearLayout) BizVideoDetailUI.f(this.pIu).findViewById(R.id.dca);
            AppMethodBeat.o(7135);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(7134);
            View findViewById = BizVideoDetailUI.f(this.pIu).findViewById(R.id.fi);
            AppMethodBeat.o(7134);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class t implements View.OnLongClickListener {
        public static final t pIE = new t();

        static {
            AppMethodBeat.i(7125);
            AppMethodBeat.o(7125);
        }

        t() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195891);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initWebviewSetting$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initWebviewSetting$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195891);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(7138);
            FrameLayout frameLayout = new FrameLayout(this.pIu.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(BizVideoDetailUI.f(this.pIu));
            AppMethodBeat.o(7138);
            return frameLayout;
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void cpF() {
        AppMethodBeat.i(7197);
        cqn();
        AppMethodBeat.o(7197);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
    public final void cpG() {
        AppMethodBeat.i(7198);
        Log.i(this.TAG, "adWebviewReady");
        this.pHX = true;
        AppMethodBeat.o(7198);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final Bundle cpH() {
        AppMethodBeat.i(7199);
        Bundle bundle = new Bundle();
        bundle.putInt("currentTime", cpZ().getCurrPosSec());
        bundle.putInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, cpZ().getDuration());
        bundle.putString("state", this.pIh);
        bundle.putLong("playedTotalTime", cpZ().getRealPlayTime() / 1000);
        bundle.putString("vid", this.pGx.vid);
        AppMethodBeat.o(7199);
        return bundle;
    }

    private final void fm(String str, String str2) {
        com.tencent.mm.plugin.webview.d.h jsapi;
        AppMethodBeat.i(195893);
        if (Util.isEqual(this.pIh, str)) {
            AppMethodBeat.o(195893);
            return;
        }
        Log.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
        if (hVar != null) {
            hVar.j(str, this.pGx.vid, str2, String.valueOf(cpZ().getCurrPosSec()), String.valueOf(cpZ().getRealPlayTime() / 1000));
        }
        MMWebViewWithJsApi mMWebViewWithJsApi = this.pHV;
        if (!(mMWebViewWithJsApi == null || (jsapi = mMWebViewWithJsApi.getJsapi()) == null)) {
            jsapi.j(str, this.pGx.vid, str2, String.valueOf(cpZ().getCurrPosSec()), String.valueOf(cpZ().getRealPlayTime() / 1000));
        }
        this.pIh = str;
        AppMethodBeat.o(195893);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.a, com.tencent.mm.plugin.webview.h.a.c
    public final void aa(Bundle bundle) {
        int i2;
        com.tencent.mm.plugin.webview.d.h jsapi;
        int i3;
        com.tencent.mm.plugin.webview.d.h jsapi2;
        AppMethodBeat.i(7200);
        if (bundle == null || !bundle.containsKey("data")) {
            AppMethodBeat.o(7200);
            return;
        }
        String string = bundle.getString("data", "");
        String string2 = bundle.getString("sendTo", "adWeb");
        int i4 = bundle.getInt("webviewId", 0);
        Log.i(this.TAG, "sendMPPageData %s, webviewId = %d", string2, Integer.valueOf(i4));
        if (kotlin.g.b.p.j("adWeb", string2)) {
            if (this.pHV == null) {
                AppMethodBeat.o(7200);
                return;
            }
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHV;
            if (mMWebViewWithJsApi == null || (jsapi2 = mMWebViewWithJsApi.getJsapi()) == null) {
                AppMethodBeat.o(7200);
                return;
            }
            jsapi2.aYc(string);
            AppMethodBeat.o(7200);
        } else if (!kotlin.g.b.p.j("dot", string2)) {
            com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
            if (hVar != null) {
                hVar.aYc(string);
                AppMethodBeat.o(7200);
                return;
            }
            AppMethodBeat.o(7200);
        } else if (this.pHW == null) {
            AppMethodBeat.o(7200);
        } else {
            MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
            if (mMWebViewWithJsApi2 != null) {
                i2 = mMWebViewWithJsApi2.hashCode();
            } else {
                i2 = 0;
            }
            if (i4 != i2) {
                String str = this.TAG;
                Object[] objArr = new Object[2];
                MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHW;
                if (mMWebViewWithJsApi3 != null) {
                    i3 = mMWebViewWithJsApi3.hashCode();
                } else {
                    i3 = 0;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Integer.valueOf(i4);
                Log.i(str, "sendMPPageData id not match %d/%d", objArr);
                AppMethodBeat.o(7200);
                return;
            }
            MMWebViewWithJsApi mMWebViewWithJsApi4 = this.pHW;
            if (mMWebViewWithJsApi4 == null || (jsapi = mMWebViewWithJsApi4.getJsapi()) == null) {
                AppMethodBeat.o(7200);
                return;
            }
            jsapi.aYc(string);
            AppMethodBeat.o(7200);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void af(Bundle bundle) {
        AppMethodBeat.i(7201);
        if (bundle == null || !bundle.containsKey("opType")) {
            AppMethodBeat.o(7201);
            return;
        }
        String string = bundle.getString("opType");
        Log.i(this.TAG, "opPlayer opType= ".concat(String.valueOf(string)));
        if (string == null) {
            AppMethodBeat.o(7201);
            return;
        }
        switch (string.hashCode()) {
            case 3443508:
                if (string.equals(AssetExtension.SCENE_PLAY)) {
                    cpZ().start();
                    AppMethodBeat.o(7201);
                    return;
                }
                break;
            case 3540994:
                if (string.equals("stop")) {
                    cpZ().stop();
                    break;
                }
                break;
            case 106440182:
                if (string.equals("pause")) {
                    cpZ().pause();
                    AppMethodBeat.o(7201);
                    return;
                }
                break;
        }
        AppMethodBeat.o(7201);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
    public static final class u implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        u(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void onGlobalLayout() {
            com.tencent.mm.plugin.webview.d.h jsapi;
            ViewTreeObserver viewTreeObserver;
            AppMethodBeat.i(7126);
            FrameLayout h2 = BizVideoDetailUI.h(this.pIu);
            if (!(h2 == null || (viewTreeObserver = h2.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            com.tencent.mm.plugin.webview.d.h hVar = this.pIu.IBw;
            if (hVar != null) {
                hVar.aYd("appear");
            }
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pIu.pHV;
            if (mMWebViewWithJsApi == null || (jsapi = mMWebViewWithJsApi.getJsapi()) == null) {
                AppMethodBeat.o(7126);
                return;
            }
            jsapi.aYd("appear");
            AppMethodBeat.o(7126);
        }
    }

    private boolean aK(int i2, String str) {
        AppMethodBeat.i(7202);
        kotlin.g.b.p.h(str, "url");
        if (isFinishing()) {
            AppMethodBeat.o(7202);
            return false;
        } else if (this.pHW != null) {
            Log.w(this.TAG, "createDotWebview dotWebView existed!");
            AppMethodBeat.o(7202);
            return false;
        } else {
            com.tencent.mm.plugin.webview.i.a.agn(57);
            this.pHY = false;
            a aVar = a.pHf;
            MMWebViewWithJsApi hY = MMWebViewWithJsApi.a.hY(getContext());
            kotlin.g.b.p.g(hY, "MMWebViewWithJsApi.Factory.create(this.context)");
            this.pHW = a.a(hY, cpv(), new h(this), new i(this), aXI(cpu().ajO()));
            d(this.pHW);
            a(this.pHW);
            FrameLayout cqb = cqb();
            if (cqb != null) {
                cqb.removeAllViews();
            }
            FrameLayout cqc = cqc();
            if (cqc != null) {
                cqc.addView(this.pHW);
            }
            cqw();
            int i3 = (this.pHU.height - this.pIp) - this.pIq;
            String appendUrlParam = UrlExKt.appendUrlParam(str, "dotId", String.valueOf(i2));
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
            if (mMWebViewWithJsApi == null) {
                kotlin.g.b.p.hyc();
            }
            String appendUrlParam2 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(appendUrlParam, "dotWebviewId", String.valueOf(mMWebViewWithJsApi.hashCode())), "dotMinShowHeight", String.valueOf(i3));
            Log.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(appendUrlParam2)));
            MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
            if (mMWebViewWithJsApi2 != null) {
                mMWebViewWithJsApi2.loadUrl(appendUrlParam2);
            }
            MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHW;
            if (mMWebViewWithJsApi3 != null) {
                mMWebViewWithJsApi3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(7202);
            return true;
        }
    }

    private final void d(MMWebView mMWebView) {
        float f2 = 0.0f;
        AppMethodBeat.i(175517);
        if (this.density > 0.0f) {
            AppMethodBeat.o(175517);
            return;
        }
        if (mMWebView != null) {
            f2 = mMWebView.getMMDensity();
        }
        this.density = f2;
        AppMethodBeat.o(175517);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(BizVideoDetailUI bizVideoDetailUI) {
            super(0);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(175505);
            BizVideoDetailUI.b(this.pIu);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(175505);
            return xVar;
        }
    }

    private final void cqu() {
        AppMethodBeat.i(7203);
        if (this.pId != null) {
            FrameLayout cqb = cqb();
            if (cqb == null) {
                AppMethodBeat.o(7203);
                return;
            } else if (cqb.getVisibility() == 0) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
                if (cVar == null) {
                    kotlin.g.b.p.hyc();
                }
                a(cVar.pKs);
            }
        }
        AppMethodBeat.o(7203);
    }

    private final void a(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d dVar) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(7204);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
        if (cVar == null) {
            kotlin.g.b.p.hyc();
        }
        if (!cVar.pKs.htU) {
            AppMethodBeat.o(7204);
            return;
        }
        cqw();
        FrameLayout cqb = cqb();
        if (cqb != null) {
            FrameLayout cqb2 = cqb();
            ViewGroup.LayoutParams layoutParams = cqb2 != null ? cqb2.getLayoutParams() : null;
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(7204);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = (int) (((float) dVar.width) * this.density);
            layoutParams2.height = (int) (((float) dVar.height) * this.density);
            if (this.kGg) {
                i2 = com.tencent.mm.cb.a.jn(getContext());
            } else {
                i2 = this.pHU.pKS;
            }
            if (this.kGg) {
                i3 = com.tencent.mm.cb.a.jo(getContext());
            } else {
                i3 = this.pHU.pKR;
            }
            int i5 = (i3 - this.pIq) - this.pIp;
            if (!this.kGg) {
                if (!cpZ().crD()) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar2 = this.pId;
                    if (cVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    cVar2.pKo = false;
                    i5 += this.pIp;
                } else {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar3 = this.pId;
                    if (cVar3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    cVar3.pKo = true;
                }
            }
            int a2 = a(dVar.pKz, i5);
            if (a2 < this.pIp) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar4 = this.pId;
                if (cVar4 == null) {
                    kotlin.g.b.p.hyc();
                }
                cVar4.pKp = true;
            }
            layoutParams2.leftMargin = a(dVar.pKw, i2);
            layoutParams2.topMargin = a(dVar.pKx, i5) + this.pIq;
            layoutParams2.rightMargin = a(dVar.pKy, i2);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar5 = this.pId;
            if (cVar5 == null) {
                kotlin.g.b.p.hyc();
            }
            if (cVar5.pKo || this.kGg) {
                i4 = this.pIp;
            } else {
                i4 = 0;
            }
            layoutParams2.bottomMargin = i4 + a2;
            if (dVar.pKC) {
                layoutParams2.addRule(9, -1);
            } else {
                layoutParams2.removeRule(9);
            }
            if (dVar.pKE) {
                layoutParams2.addRule(11, -1);
            } else {
                layoutParams2.removeRule(11);
            }
            if (dVar.pKD) {
                layoutParams2.addRule(10, -1);
            } else {
                layoutParams2.removeRule(10);
            }
            if (dVar.pKF) {
                layoutParams2.addRule(12, -1);
            } else {
                layoutParams2.removeRule(12);
            }
            if (dVar.pKA) {
                layoutParams2.addRule(15, -1);
            } else {
                layoutParams2.removeRule(15);
            }
            if (dVar.pKB) {
                layoutParams2.addRule(14, -1);
            } else {
                layoutParams2.removeRule(14);
            }
            cqb.setLayoutParams(layoutParams2);
            AppMethodBeat.o(7204);
            return;
        }
        AppMethodBeat.o(7204);
    }

    private final void cqv() {
        AppMethodBeat.i(7205);
        if (!(cqb() == null || this.pId == null)) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
            if (cVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (cVar.pKp) {
                Log.i(this.TAG, "updateDotPosIfNeed");
                if (!this.kGg) {
                    FrameLayout cqb = cqb();
                    ViewGroup.LayoutParams layoutParams = cqb != null ? cqb.getLayoutParams() : null;
                    if (layoutParams == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(7205);
                        throw tVar;
                    }
                    int i2 = ((RelativeLayout.LayoutParams) layoutParams).bottomMargin;
                    z.d dVar = new z.d();
                    dVar.SYE = i2;
                    if (cpZ().crD()) {
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar2 = this.pId;
                        if (cVar2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        if (!cVar2.pKo) {
                            dVar.SYE += this.pIp;
                            ValueAnimator ofInt = ValueAnimator.ofInt(i2, dVar.SYE);
                            ofInt.addUpdateListener(new z(this, dVar));
                            kotlin.g.b.p.g(ofInt, "va");
                            ofInt.setDuration(200L);
                            ofInt.start();
                        }
                    }
                    if (!cpZ().crD()) {
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar3 = this.pId;
                        if (cVar3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        if (cVar3.pKo) {
                            dVar.SYE -= this.pIp;
                            ValueAnimator ofInt2 = ValueAnimator.ofInt(i2, dVar.SYE);
                            ofInt2.addUpdateListener(new z(this, dVar));
                            kotlin.g.b.p.g(ofInt2, "va");
                            ofInt2.setDuration(200L);
                            ofInt2.start();
                        }
                    }
                    AppMethodBeat.o(7205);
                    return;
                }
                AppMethodBeat.o(7205);
                return;
            }
        }
        AppMethodBeat.o(7205);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class z implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ z.d pIF;
        final /* synthetic */ BizVideoDetailUI pIu;

        z(BizVideoDetailUI bizVideoDetailUI, z.d dVar) {
            this.pIu = bizVideoDetailUI;
            this.pIF = dVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(7133);
            if (BizVideoDetailUI.u(this.pIu) != null) {
                FrameLayout u = BizVideoDetailUI.u(this.pIu);
                if (u == null) {
                    kotlin.g.b.p.hyc();
                }
                if (u.getVisibility() != 8) {
                    kotlin.g.b.p.g(valueAnimator, "valueAnimator");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(7133);
                        throw tVar;
                    }
                    int intValue = ((Integer) animatedValue).intValue();
                    FrameLayout u2 = BizVideoDetailUI.u(this.pIu);
                    if (u2 != null) {
                        FrameLayout u3 = BizVideoDetailUI.u(this.pIu);
                        ViewGroup.LayoutParams layoutParams = u3 != null ? u3.getLayoutParams() : null;
                        if (layoutParams == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                            AppMethodBeat.o(7133);
                            throw tVar2;
                        }
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.bottomMargin = intValue;
                        u2.setLayoutParams(layoutParams2);
                    }
                    if (intValue == this.pIF.SYE) {
                        BizVideoDetailUI.l(this.pIu);
                    }
                    AppMethodBeat.o(7133);
                    return;
                }
            }
            AppMethodBeat.o(7133);
        }
    }

    private final void cqw() {
        AppMethodBeat.i(7206);
        if (this.pIp < 0) {
            this.pIp = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ad_);
            this.pIq = au.eu(getContext());
        }
        AppMethodBeat.o(7206);
    }

    private final int a(double d2, int i2) {
        if (d2 < 0.0d) {
            return 0;
        }
        if (d2 < 1.0d) {
            return (int) (((double) i2) * d2);
        }
        return (int) (((double) this.density) * d2);
    }

    private final void cqx() {
        ViewTreeObserver viewTreeObserver;
        AppMethodBeat.i(7207);
        Log.i(this.TAG, "onShowDot ready: " + this.pHY + ", hasWebView: " + (this.pHW != null));
        if (!this.pHY || this.pHW == null) {
            AppMethodBeat.o(7207);
            return;
        }
        com.tencent.mm.plugin.webview.i.a.agn(60);
        FrameLayout cqb = cqb();
        if (cqb != null) {
            cqb.setVisibility(0);
        }
        FrameLayout cqc = cqc();
        if (cqc != null) {
            cqc.removeView(this.pHW);
        }
        FrameLayout cqb2 = cqb();
        if (cqb2 != null) {
            cqb2.removeAllViews();
        }
        FrameLayout cqb3 = cqb();
        if (cqb3 != null) {
            cqb3.addView(this.pHW);
        }
        FrameLayout cqb4 = cqb();
        if (!(cqb4 == null || (viewTreeObserver = cqb4.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new v(this));
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
        if (cVar != null) {
            cVar.pKn = true;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar2 = this.pId;
        if (cVar2 != null) {
            cVar2.pKq = true;
        }
        cqv();
        AppMethodBeat.o(7207);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
    public static final class v implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        v(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        public final void onGlobalLayout() {
            com.tencent.mm.plugin.webview.d.h jsapi;
            ViewTreeObserver viewTreeObserver;
            AppMethodBeat.i(7127);
            FrameLayout u = BizVideoDetailUI.u(this.pIu);
            if (!(u == null || (viewTreeObserver = u.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            if (this.pIu.pHW != null) {
                Log.i(this.pIu.TAG, "onShowDot appear");
                com.tencent.mm.plugin.webview.d.h hVar = this.pIu.IBw;
                if (hVar != null) {
                    int cqy = this.pIu.cqy();
                    MMWebViewWithJsApi mMWebViewWithJsApi = this.pIu.pHW;
                    if (mMWebViewWithJsApi == null) {
                        kotlin.g.b.p.hyc();
                    }
                    hVar.P(cqy, mMWebViewWithJsApi.hashCode(), "appear");
                }
                MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pIu.pHW;
                if (!(mMWebViewWithJsApi2 == null || (jsapi = mMWebViewWithJsApi2.getJsapi()) == null)) {
                    int cqy2 = this.pIu.cqy();
                    MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pIu.pHW;
                    if (mMWebViewWithJsApi3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    jsapi.P(cqy2, mMWebViewWithJsApi3.hashCode(), "appear");
                    AppMethodBeat.o(7127);
                    return;
                }
            }
            AppMethodBeat.o(7127);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void ab(Bundle bundle) {
        int i2;
        int i3;
        AppMethodBeat.i(7208);
        if (this.pHW == null) {
            AppMethodBeat.o(7208);
            return;
        }
        if (bundle == null) {
            kotlin.g.b.p.hyc();
        }
        int i4 = bundle.getInt("webviewId", 0);
        if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW()) {
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
            if (mMWebViewWithJsApi != null) {
                i2 = mMWebViewWithJsApi.hashCode();
            } else {
                i2 = 0;
            }
            if (i4 != i2) {
                String str = this.TAG;
                Object[] objArr = new Object[2];
                MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
                if (mMWebViewWithJsApi2 != null) {
                    i3 = mMWebViewWithJsApi2.hashCode();
                } else {
                    i3 = 0;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Integer.valueOf(i4);
                Log.i(str, "closeDotWebview id not match %d/%d", objArr);
                AppMethodBeat.o(7208);
                return;
            }
        }
        Log.i(this.TAG, "closeDotWebview");
        cqo();
        AppMethodBeat.o(7208);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void ac(Bundle bundle) {
        com.tencent.mm.plugin.webview.d.h jsapi;
        int i2;
        int i3;
        AppMethodBeat.i(7209);
        if (this.pHW == null) {
            AppMethodBeat.o(7209);
            return;
        }
        if (bundle == null) {
            kotlin.g.b.p.hyc();
        }
        int i4 = bundle.getInt("webviewId", 0);
        if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW()) {
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
            if (mMWebViewWithJsApi != null) {
                i2 = mMWebViewWithJsApi.hashCode();
            } else {
                i2 = 0;
            }
            if (i4 != i2) {
                String str = this.TAG;
                Object[] objArr = new Object[2];
                MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
                if (mMWebViewWithJsApi2 != null) {
                    i3 = mMWebViewWithJsApi2.hashCode();
                } else {
                    i3 = 0;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Integer.valueOf(i4);
                Log.i(str, "hideDotWebview id not match %d/%d", objArr);
                AppMethodBeat.o(7209);
                return;
            }
        }
        Log.i(this.TAG, "hideDotWebview");
        FrameLayout cqb = cqb();
        if (cqb == null || cqb.getVisibility() != 0) {
            Log.i(this.TAG, "dotView not show");
            AppMethodBeat.o(7209);
            return;
        }
        FrameLayout cqb2 = cqb();
        if (cqb2 != null) {
            cqb2.setVisibility(8);
        }
        com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
        if (hVar != null) {
            int cqy = cqy();
            MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHW;
            if (mMWebViewWithJsApi3 == null) {
                kotlin.g.b.p.hyc();
            }
            hVar.P(cqy, mMWebViewWithJsApi3.hashCode(), "disappear");
        }
        MMWebViewWithJsApi mMWebViewWithJsApi4 = this.pHW;
        if (mMWebViewWithJsApi4 == null || (jsapi = mMWebViewWithJsApi4.getJsapi()) == null) {
            AppMethodBeat.o(7209);
            return;
        }
        int cqy2 = cqy();
        MMWebViewWithJsApi mMWebViewWithJsApi5 = this.pHW;
        if (mMWebViewWithJsApi5 == null) {
            kotlin.g.b.p.hyc();
        }
        jsapi.P(cqy2, mMWebViewWithJsApi5.hashCode(), "disappear");
        AppMethodBeat.o(7209);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
    public final void ad(Bundle bundle) {
        int i2;
        int i3;
        AppMethodBeat.i(7210);
        if (this.pHW == null) {
            AppMethodBeat.o(7210);
            return;
        }
        if (bundle == null) {
            kotlin.g.b.p.hyc();
        }
        int i4 = bundle.getInt("webviewId", 0);
        if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW()) {
            MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
            if (mMWebViewWithJsApi != null) {
                i2 = mMWebViewWithJsApi.hashCode();
            } else {
                i2 = 0;
            }
            if (i4 != i2) {
                String str = this.TAG;
                Object[] objArr = new Object[2];
                MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
                if (mMWebViewWithJsApi2 != null) {
                    i3 = mMWebViewWithJsApi2.hashCode();
                } else {
                    i3 = 0;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Integer.valueOf(i4);
                Log.i(str, "dotWebviewReady id not match %d/%d", objArr);
                AppMethodBeat.o(7210);
                return;
            }
        }
        Log.i(this.TAG, "dotWebViewReady %d", Integer.valueOf(i4));
        this.pHY = true;
        com.tencent.mm.plugin.webview.i.a.agn(59);
        AppMethodBeat.o(7210);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI, com.tencent.mm.plugin.webview.h.a.c
    public final void ae(Bundle bundle) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(7211);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b bVar = this.pIe;
        int duration = cpZ().getDuration();
        if (bundle == null || !bundle.containsKey("data")) {
            Log.i(bVar.TAG, "setDotScriptData data invalid");
        } else {
            synchronized (bVar) {
                try {
                    bVar.pKl.clear();
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(7211);
                }
            }
            String string = bundle.getString("data", "");
            Log.d(bVar.TAG, "setDotScriptData data=".concat(String.valueOf(string)));
            try {
                JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
                if (optJSONArray == null) {
                    Log.w(bVar.TAG, "itemList null");
                } else {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = optJSONArray.get(i2);
                        if (obj == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.json.JSONObject");
                            AppMethodBeat.o(7211);
                            throw tVar;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        int optInt = jSONObject.optInt("id");
                        double optDouble = jSONObject.optDouble("startTime");
                        double optDouble2 = jSONObject.optDouble("endTime");
                        double optDouble3 = jSONObject.optDouble("minShowTime");
                        String optString = jSONObject.optString("url");
                        int optInt2 = jSONObject.optInt("hasShow");
                        kotlin.g.b.p.g(optString, "url");
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c(optInt, optDouble, optDouble2, optDouble3, optString);
                        if (optInt2 == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        cVar.pKn = z2;
                        if (cVar.pKt >= cVar.pKu || cVar.pKt < 0.0d || cVar.pKu > ((double) duration)) {
                            Log.i(bVar.TAG, "dotInfo invalid, startTime = " + cVar.pKt + ", endTime=" + cVar.pKu + ", duration=" + duration);
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            Log.i(bVar.TAG, "dotInfo invalid");
                        } else {
                            synchronized (bVar) {
                                try {
                                    bVar.pKl.add(cVar);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                    Log.i(bVar.TAG, "setDotScriptData end %d", Integer.valueOf(bVar.pKl.size()));
                }
            } catch (Exception e2) {
                Log.e(bVar.TAG, "setDotScriptData ex %s", e2.getMessage());
            }
        }
        cqz();
        MPVideoView cpZ = cpZ();
        LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> linkedList = new LinkedList<>(this.pIe.pKl);
        kotlin.g.b.p.h(linkedList, "list");
        MPVideoViewControlBar mPVideoViewControlBar = cpZ.pOa;
        if (mPVideoViewControlBar != null) {
            mPVideoViewControlBar.N(linkedList);
        }
        cqu();
        AppMethodBeat.o(7211);
    }

    public final int cqy() {
        AppMethodBeat.i(7212);
        if (this.pId == null) {
            AppMethodBeat.o(7212);
            return -1;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
        if (cVar == null) {
            kotlin.g.b.p.hyc();
        }
        int i2 = cVar.id;
        AppMethodBeat.o(7212);
        return i2;
    }

    public final void cqz() {
        FrameLayout cqb;
        com.tencent.mm.plugin.webview.d.h jsapi;
        AppMethodBeat.i(7213);
        if (this.pIc || cpZ().getCurrPosSec() <= 0) {
            AppMethodBeat.o(7213);
            return;
        }
        float currPosMs = ((float) cpZ().getCurrPosMs()) / 1000.0f;
        if (this.pHW != null && this.pIe.b(currPosMs, this.pId)) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar = this.pId;
            if (cVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (cVar.dvh) {
                if (BuildInfo.DEBUG) {
                    Log.d(this.TAG, "dot end, wait h5 to close");
                }
                if (System.currentTimeMillis() - this.pIo >= 1000) {
                    Log.i(this.TAG, "dot end, time out to close");
                    cqo();
                }
                AppMethodBeat.o(7213);
                return;
            }
            Log.i(this.TAG, "destroyDotWebView");
            FrameLayout cqb2 = cqb();
            if (cqb2 != null && cqb2.getVisibility() == 0) {
                MMWebViewWithJsApi mMWebViewWithJsApi = this.pHW;
                if ((mMWebViewWithJsApi != null ? mMWebViewWithJsApi.getJsapi() : null) != null) {
                    MMWebViewWithJsApi mMWebViewWithJsApi2 = this.pHW;
                    if (mMWebViewWithJsApi2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    com.tencent.mm.plugin.webview.d.h jsapi2 = mMWebViewWithJsApi2.getJsapi();
                    if (jsapi2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (jsapi2.isReady()) {
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar2 = this.pId;
                        if (cVar2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        cVar2.dvh = true;
                        this.pIo = System.currentTimeMillis();
                        MMWebViewWithJsApi mMWebViewWithJsApi3 = this.pHW;
                        if (mMWebViewWithJsApi3 == null || (jsapi = mMWebViewWithJsApi3.getJsapi()) == null) {
                            AppMethodBeat.o(7213);
                            return;
                        }
                        int cqy = cqy();
                        MMWebViewWithJsApi mMWebViewWithJsApi4 = this.pHW;
                        if (mMWebViewWithJsApi4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        jsapi.P(cqy, mMWebViewWithJsApi4.hashCode(), "end");
                        AppMethodBeat.o(7213);
                        return;
                    }
                }
            }
            cqo();
        }
        if (this.pId != null) {
            if (this.pHY && (((cqb = cqb()) == null || cqb.getVisibility() != 0) && com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(currPosMs, this.pId))) {
                cqx();
            }
            AppMethodBeat.o(7213);
            return;
        }
        this.pId = this.pIe.bb(currPosMs);
        if (this.pId != null) {
            int cqy2 = cqy();
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c cVar3 = this.pId;
            if (cVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            aK(cqy2, cVar3.url);
        }
        AppMethodBeat.o(7213);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class e implements IPCRunCgi.a {
        final /* synthetic */ BizVideoDetailUI pIu;

        e(BizVideoDetailUI bizVideoDetailUI) {
            this.pIu = bizVideoDetailUI;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            int i4;
            AppMethodBeat.i(7087);
            this.pIu.pGx.cpU();
            if (dVar == null) {
                AppMethodBeat.o(7087);
                return;
            }
            Log.i(this.pIu.TAG, "onSceneEnd errType " + i2 + ", errCode " + i3 + ", errMsg " + str + ", type: " + dVar.getType());
            com.tencent.mm.bw.a aYJ = dVar.aYJ();
            if (((aYJ instanceof fs) && ((fs) aYJ).KIK != this.pIu.pGx.pHu) || ((aYJ instanceof fr) && ((fr) aYJ).KIK != this.pIu.pGx.pHu)) {
                AppMethodBeat.o(7087);
            } else if (dVar.getType() == 1179) {
                this.pIu.pIb = true;
                if (i2 == 0 && i3 == 0) {
                    BizVideoDetailUI.s(this.pIu);
                    com.tencent.mm.bw.a aYK = dVar.aYK();
                    if (aYK == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
                        AppMethodBeat.o(7087);
                        throw tVar;
                    }
                    ft ftVar = (ft) aYK;
                    String str2 = this.pIu.TAG;
                    StringBuilder sb = new StringBuilder("url_info size is ");
                    if (ftVar.KJu != null) {
                        LinkedList<gh> linkedList = ftVar.KJu;
                        if (linkedList == null) {
                            kotlin.g.b.p.hyc();
                        }
                        i4 = linkedList.size();
                    } else {
                        i4 = 0;
                    }
                    Log.i(str2, sb.append(i4).toString());
                    if (ftVar.KJv == 0 || Util.isNullOrNil(ftVar.KJw)) {
                        this.pIu.a(ftVar);
                        AppMethodBeat.o(7087);
                        return;
                    }
                    Log.i(this.pIu.TAG, "onSceneEnd redirect %s", ftVar.KJw);
                    BizVideoDetailUI bizVideoDetailUI = this.pIu;
                    String str3 = ftVar.KJw;
                    kotlin.g.b.p.g(str3, "resp.redirect_url");
                    bizVideoDetailUI.aiE(str3);
                    AppMethodBeat.o(7087);
                    return;
                }
                this.pIu.a((ft) null);
                BizVideoDetailUI.q(this.pIu);
                MPVideoErrorView p = BizVideoDetailUI.p(this.pIu);
                p.pIH.setBackgroundResource(R.drawable.c0j);
                if (!Util.isNullOrNil(str)) {
                    p.pIG.setText(p.getContext().getString(R.string.f3r) + ' ' + str);
                } else {
                    p.pIG.setText(p.getContext().getString(R.string.f3r));
                }
                p.gvQ.setClickable(true);
                if (i2 == 2) {
                    com.tencent.mm.plugin.webview.i.a.agn(2);
                    AppMethodBeat.o(7087);
                    return;
                }
                com.tencent.mm.plugin.webview.i.a.agn(3);
                AppMethodBeat.o(7087);
            } else {
                AppMethodBeat.o(7087);
            }
        }
    }

    private final void cqA() {
        AppMethodBeat.i(175518);
        if (this.pIr != null) {
            getContext().unregisterReceiver(this.pIr);
            this.pIr = null;
        }
        AppMethodBeat.o(175518);
    }

    private final boolean Z(int i2, boolean z2) {
        AppMethodBeat.i(175519);
        if (BuildInfo.DEBUG && this.pIt) {
            AppMethodBeat.o(175519);
            return true;
        } else if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
            AppMethodBeat.o(175519);
            return false;
        } else if (cpZ().getPlayStatus() == 4) {
            Log.i(this.TAG, "not show WifiTips, play end!");
            AppMethodBeat.o(175519);
            return false;
        } else if (i2 > 0 && cpZ().getCacheTimeSec() >= i2) {
            Log.i(this.TAG, "not show WifiTips, video cached! " + cpZ().getCacheTimeSec() + '/' + cpZ().getDuration());
            AppMethodBeat.o(175519);
            return false;
        } else if (this.pGx.pHt) {
            Log.i(this.TAG, "not show WifiTips, has show!");
            AppMethodBeat.o(175519);
            return false;
        } else {
            if (z2) {
                MPVideoWifiTipsView.a aVar = MPVideoWifiTipsView.pJW;
                if (!MPVideoWifiTipsView.a.DM(this.pGx.pHs)) {
                    AppMethodBeat.o(175519);
                    return false;
                }
            } else {
                MPVideoWifiTipsView.a aVar2 = MPVideoWifiTipsView.pJW;
                if (!MPVideoWifiTipsView.a.DK(this.pGx.pHs)) {
                    MPVideoWifiTipsView.a aVar3 = MPVideoWifiTipsView.pJW;
                    if (!MPVideoWifiTipsView.a.DL(this.pGx.pHs)) {
                        AppMethodBeat.o(175519);
                        return false;
                    }
                }
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l lVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.pLy;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.A(NetStatusUtil.isWifi(MMApplicationContext.getContext()), this.pHT)) {
                AppMethodBeat.o(175519);
                return true;
            }
            AppMethodBeat.o(175519);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.m<WebView, String, kotlin.x> {
        public static final g pIw = new g();

        static {
            AppMethodBeat.i(7091);
            AppMethodBeat.o(7091);
        }

        g() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(WebView webView, String str) {
            AppMethodBeat.i(7090);
            com.tencent.mm.plugin.webview.i.a.agn(29);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(7090);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.m<WebView, String, kotlin.x> {
        final /* synthetic */ BizVideoDetailUI pIu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(BizVideoDetailUI bizVideoDetailUI) {
            super(2);
            this.pIu = bizVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(WebView webView, String str) {
            AppMethodBeat.i(7095);
            Log.d(this.pIu.TAG, "dotWebView load finish");
            com.tencent.mm.plugin.webview.i.a.agn(58);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(7095);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z2;
        String str = null;
        AppMethodBeat.i(7194);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p pVar = this.pGy;
        if (i2 == 1) {
            if (i3 == -1) {
                TmplShareWebViewToolUI cpV = pVar.cpV();
                TmplShareWebViewToolUI cpV2 = pVar.cpV();
                if (cpV2 != null) {
                    str = cpV2.getString(R.string.ajk);
                }
                com.tencent.mm.ui.base.h.cA(cpV, str);
                int i4 = pVar.pMd ? 11 : 2;
                b bVar = pVar.pIL;
                if (bVar == null) {
                    kotlin.g.b.p.btv("controller");
                }
                bVar.pHq.aL(i4, pVar.pMf);
            }
            z2 = true;
        } else if (i2 == 2) {
            if (i3 == -1) {
                String stringExtra = intent != null ? intent.getStringExtra("Select_Conv_User") : null;
                if (intent != null) {
                    str = intent.getStringExtra("custom_send_text");
                }
                if (stringExtra != null) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g gVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.pKI;
                    com.tencent.mm.ag.x xVar = pVar.pHv;
                    if (xVar == null) {
                        kotlin.g.b.p.btv("msgInfo");
                    }
                    b bVar2 = pVar.pIL;
                    if (bVar2 == null) {
                        kotlin.g.b.p.btv("controller");
                    }
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.a(stringExtra, xVar, str, bVar2, new p.a(pVar));
                }
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(7194);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(7194);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.brandservice.ui.widget.a g(BizVideoDetailUI bizVideoDetailUI) {
        com.tencent.mm.plugin.brandservice.ui.widget.a aVar;
        AppMethodBeat.i(7222);
        if (bizVideoDetailUI.pHS != null) {
            aVar = bizVideoDetailUI.pHS;
            if (aVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.o(7222);
                throw tVar;
            }
            AppMethodBeat.o(7222);
        } else {
            bizVideoDetailUI.pHS = new com.tencent.mm.plugin.brandservice.ui.widget.a(bizVideoDetailUI.getContext());
            com.tencent.mm.plugin.brandservice.ui.widget.a aVar2 = bizVideoDetailUI.pHS;
            if (aVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            aVar2.a(bizVideoDetailUI.pIn);
            aVar = bizVideoDetailUI.pHS;
            if (aVar == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.o(7222);
                throw tVar2;
            }
            AppMethodBeat.o(7222);
        }
        return aVar;
    }

    public static final /* synthetic */ void o(BizVideoDetailUI bizVideoDetailUI) {
        ViewTreeObserver viewTreeObserver;
        Integer num = null;
        AppMethodBeat.i(7229);
        Log.i(bizVideoDetailUI.TAG, "onShowAd adWebViewReady: " + bizVideoDetailUI.pHX + ", hasAdWebView: " + (bizVideoDetailUI.pHV != null));
        if (!bizVideoDetailUI.pHX || bizVideoDetailUI.pHV == null) {
            if (bizVideoDetailUI.pHV != null) {
                com.tencent.mm.plugin.webview.i.a.agn(31);
            }
            AppMethodBeat.o(7229);
            return;
        }
        com.tencent.mm.plugin.webview.i.a.agn(30);
        FrameLayout cqc = bizVideoDetailUI.cqc();
        if (cqc != null) {
            cqc.removeView(bizVideoDetailUI.pHV);
        }
        FrameLayout cqa = bizVideoDetailUI.cqa();
        if (cqa != null) {
            cqa.removeAllViews();
        }
        FrameLayout cqa2 = bizVideoDetailUI.cqa();
        if (cqa2 != null) {
            cqa2.addView(bizVideoDetailUI.pHV);
        }
        FrameLayout cqa3 = bizVideoDetailUI.cqa();
        if (cqa3 != null) {
            cqa3.setVisibility(0);
        }
        String str = bizVideoDetailUI.TAG;
        Object[] objArr = new Object[2];
        MMWebViewWithJsApi mMWebViewWithJsApi = bizVideoDetailUI.pHV;
        objArr[0] = mMWebViewWithJsApi != null ? Integer.valueOf(mMWebViewWithJsApi.getWidth()) : null;
        MMWebViewWithJsApi mMWebViewWithJsApi2 = bizVideoDetailUI.pHV;
        if (mMWebViewWithJsApi2 != null) {
            num = Integer.valueOf(mMWebViewWithJsApi2.getHeight());
        }
        objArr[1] = num;
        Log.i(str, "onShowAd %d/%d", objArr);
        FrameLayout cqa4 = bizVideoDetailUI.cqa();
        if (!(cqa4 == null || (viewTreeObserver = cqa4.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new u(bizVideoDetailUI));
        }
        if (bizVideoDetailUI.kGg) {
            LinearLayout cqf = bizVideoDetailUI.cqf();
            kotlin.g.b.p.g(cqf, "videoAdTitleBar");
            cqf.setVisibility(0);
        }
        AppMethodBeat.o(7229);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r15 != r2.hashCode()) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI r13, java.lang.String r14, int r15) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.a(com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI, java.lang.String, int):void");
    }
}
