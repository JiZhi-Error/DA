package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ï\u00012\u00020\u0001:\u0006ï\u0001ð\u0001ñ\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010r\u001a\u00020\"H\u0002J\b\u0010s\u001a\u00020\"H\u0002J\u0006\u0010t\u001a\u00020uJ\u000e\u0010v\u001a\u00020\"2\u0006\u0010w\u001a\u00020xJ\u000e\u0010y\u001a\u00020u2\u0006\u0010z\u001a\u00020<J\u000e\u0010{\u001a\u00020u2\u0006\u0010|\u001a\u00020\"J\u0006\u0010}\u001a\u00020\"J\u0006\u0010~\u001a\u00020\"J\u0006\u0010\u001a\u00020\"J\u0012\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\t\u0010\u0001\u001a\u00020uH\u0002J\u0007\u0010\u0001\u001a\u00020uJ\u0011\u0010\u0001\u001a\u00020u2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0007\u0010\u0001\u001a\u00020uJ\t\u0010\u0001\u001a\u00020uH\u0002J\t\u0010\u0001\u001a\u00020uH\u0002J\t\u0010\u0001\u001a\u00020uH\u0002J\u0007\u0010\u0001\u001a\u00020\"J\u0007\u0010\u0001\u001a\u00020\"J\u0012\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u0007\u0010\u0001\u001a\u00020uJ\u0011\u0010\u0001\u001a\u00020\"2\u0006\u0010w\u001a\u00020xH\u0016J\u0007\u0010\u0001\u001a\u00020uJ\u0007\u0010\u0001\u001a\u00020uJ\u0007\u0010\u0001\u001a\u00020uJ\u0019\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020uJ\u001d\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0001\u001a\u00020\"H\u0007J\u0010\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\"J\u001a\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020<J\u0010\u0010\u0001\u001a\u00020u2\u0007\u0010 \u0001\u001a\u00020\"J9\u0010¡\u0001\u001a\u00020u2\t\u0010¢\u0001\u001a\u0004\u0018\u00010+2\t\u0010£\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001J.\u0010¡\u0001\u001a\u00020u2\t\u0010£\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010¦\u0001\u001a\u00020u2\u0007\u0010§\u0001\u001a\u00020\"J>\u0010¨\u0001\u001a\u00020u2\u0007\u0010©\u0001\u001a\u00020\t2\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010­\u0001\u001a\u00020\t2\u0007\u0010®\u0001\u001a\u00020\t2\u0007\u0010¯\u0001\u001a\u00020\tJ\u0010\u0010°\u0001\u001a\u00020u2\u0007\u0010±\u0001\u001a\u00020BJ\u0010\u0010²\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\tJ\u0010\u0010³\u0001\u001a\u00020u2\u0007\u0010´\u0001\u001a\u00020\tJ\u0010\u0010µ\u0001\u001a\u00020u2\u0007\u0010¶\u0001\u001a\u00020\"J\u0010\u0010·\u0001\u001a\u00020u2\u0007\u0010¸\u0001\u001a\u00020\"J\u0010\u0010¹\u0001\u001a\u00020u2\u0007\u0010±\u0001\u001a\u00020LJ\u0010\u0010º\u0001\u001a\u00020u2\u0007\u0010»\u0001\u001a\u00020\"J\u0007\u0010¼\u0001\u001a\u00020uJ\u0010\u0010½\u0001\u001a\u00020u2\u0007\u0010¾\u0001\u001a\u00020\"J\u0010\u0010¿\u0001\u001a\u00020u2\u0007\u0010À\u0001\u001a\u00020\"J\u0011\u0010Á\u0001\u001a\u00020u2\b\u0010Â\u0001\u001a\u00030Ã\u0001J\u0010\u0010Ä\u0001\u001a\u00020u2\u0007\u0010Å\u0001\u001a\u00020<J\u0019\u0010Æ\u0001\u001a\u00020u2\u0006\u0010l\u001a\u00020<2\u0006\u0010z\u001a\u00020<H\u0002J\u0010\u0010Ç\u0001\u001a\u00020u2\u0007\u0010È\u0001\u001a\u00020\"J\u0010\u0010É\u0001\u001a\u00020u2\u0007\u0010Ê\u0001\u001a\u00020\"J\u0010\u0010Ë\u0001\u001a\u00020u2\u0007\u0010Ì\u0001\u001a\u00020\"J\u0010\u0010Í\u0001\u001a\u00020u2\u0007\u0010Î\u0001\u001a\u00020\"J\u0010\u0010Ï\u0001\u001a\u00020u2\u0007\u0010Ð\u0001\u001a\u00020\"J\u0010\u0010Ñ\u0001\u001a\u00020u2\u0007\u0010Ò\u0001\u001a\u00020\"J\u0012\u0010Ó\u0001\u001a\u00020u2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010<J \u0010Õ\u0001\u001a\u00020u2\u0006\u0010l\u001a\u00020<2\u0006\u0010'\u001a\u00020\"2\u0007\u0010Ö\u0001\u001a\u00020\tJ\u0010\u0010×\u0001\u001a\u00020u2\u0007\u0010Ø\u0001\u001a\u00020\tJ\"\u0010Ù\u0001\u001a\u00020u2\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ü\u00010Û\u00012\b\u0010Ý\u0001\u001a\u00030Ü\u0001J\t\u0010Þ\u0001\u001a\u00020\"H\u0002J\u0019\u0010ß\u0001\u001a\u00020\"2\u0007\u0010à\u0001\u001a\u0002082\u0007\u0010á\u0001\u001a\u00020xJ\t\u0010â\u0001\u001a\u00020uH\u0002J\u0007\u0010ã\u0001\u001a\u00020uJ\u0007\u0010ä\u0001\u001a\u00020uJ\u0007\u0010å\u0001\u001a\u00020uJ\u0007\u0010æ\u0001\u001a\u00020uJ\u0007\u0010ç\u0001\u001a\u00020uJ\t\u0010è\u0001\u001a\u00020uH\u0002J\u0018\u0010é\u0001\u001a\u00020u2\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030ë\u00010Û\u0001J\u0011\u0010ì\u0001\u001a\u00020u2\u0006\u0010'\u001a\u00020\"H\u0002J\u0007\u0010í\u0001\u001a\u00020uJ\t\u0010î\u0001\u001a\u00020uH\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010%\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u001eR\u001c\u0010b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u000e\"\u0004\bd\u0010\u0010R\u0011\u0010e\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010\u001eR\"\u0010l\u001a\u0004\u0018\u00010<2\b\u0010k\u001a\u0004\u0018\u00010<@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0013\"\u0004\bq\u0010\u001e¨\u0006ò\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", TencentLocation.EXTRA_DIRECTION, "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView extends RelativeLayout {
    public static final String TAG = TAG;
    private static final int pOo = -1;
    private static final int pOp = 8;
    public static final a pOq = new a((byte) 0);
    private int add = pOo;
    private int atU;
    private boolean cEZ;
    private int jpW;
    private boolean mIsMute;
    private boolean mLoop;
    private TextView mvK;
    private View mvN;
    private View mvO;
    private TextView mvP;
    private LinearLayout mvQ;
    private AppBrandDotPercentIndicator mvR;
    private TextView mvS;
    private ImageView mvT;
    private ImageView mvV;
    private ImageView mvW;
    private FrameLayout mvX;
    private boolean mwb;
    private boolean mwd;
    private boolean mwe;
    private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a mwf;
    private boolean mwh;
    private String mwj;
    private boolean mwk;
    private boolean mwl;
    private boolean mwm;
    private boolean mwo;
    private int mwp;
    private boolean mwr;
    private boolean mws;
    public boolean mwt;
    public MPExoVideoWrapper pNZ;
    public MPVideoViewControlBar pOa;
    private FrameLayout pOb;
    private FrameLayout pOc;
    private FrameLayout pOd;
    private boolean pOe;
    private boolean pOf;
    private b pOg;
    private c pOh;
    private int pOi;
    private long pOj;
    private long pOk;
    private boolean pOl;
    public boolean pOm;
    public boolean pOn;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", TencentLocation.EXTRA_DIRECTION, "", "quitFullScreen", "plugin-brandservice_release"})
    public interface b {
        void bGL();

        boolean isFullScreen();

        void xd(int i2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\"\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u001c\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)H&¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
    public interface c {
        void BL(long j2);

        void a(int i2, int i3, gh ghVar);

        void a(c.a aVar, c.a aVar2);

        void aJq();

        void aiG(String str);

        void bJl();

        void cqC();

        void cqD();

        void cqE();

        void cqF();

        void cqG();

        void cqH();

        void cqI();

        void kq(boolean z);

        void onVideoEnded();

        void onVideoPause();

        void onVideoPlay();

        void onVideoWaiting();
    }

    public static final /* synthetic */ String DZ(int i2) {
        AppMethodBeat.i(7594);
        String xs = xs(i2);
        AppMethodBeat.o(7594);
        return xs;
    }

    public static final /* synthetic */ void f(MPVideoView mPVideoView) {
        AppMethodBeat.i(7588);
        mPVideoView.bIZ();
        AppMethodBeat.o(7588);
    }

    public static final /* synthetic */ boolean i(MPVideoView mPVideoView) {
        AppMethodBeat.i(7589);
        boolean bJd = mPVideoView.bJd();
        AppMethodBeat.o(7589);
        return bJd;
    }

    public static final /* synthetic */ boolean r(MPVideoView mPVideoView) {
        AppMethodBeat.i(7591);
        boolean bJe = mPVideoView.bJe();
        AppMethodBeat.o(7591);
        return bJe;
    }

    public static final /* synthetic */ boolean u(MPVideoView mPVideoView) {
        AppMethodBeat.i(7593);
        boolean isLive = mPVideoView.isLive();
        AppMethodBeat.o(7593);
        return isLive;
    }

    public final FrameLayout getPlayerAdContainerLayout() {
        return this.pOb;
    }

    public final void setPlayerAdContainerLayout(FrameLayout frameLayout) {
        this.pOb = frameLayout;
    }

    public final FrameLayout getDotContainerLayout() {
        return this.pOc;
    }

    public final void setDotContainerLayout(FrameLayout frameLayout) {
        this.pOc = frameLayout;
    }

    public final FrameLayout getBackgroudContainerLayout() {
        return this.pOd;
    }

    public final void setBackgroudContainerLayout(FrameLayout frameLayout) {
        this.pOd = frameLayout;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setVideoWidth(int i2) {
        this.videoWidth = i2;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final void setVideoHeight(int i2) {
        this.videoHeight = i2;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final int getPlayStatus() {
        return this.jpW;
    }

    public final void setPlayStatus(int i2) {
        this.jpW = i2;
    }

    public final long getRealPlayTime() {
        AppMethodBeat.i(7529);
        if (this.pOl || this.pOk == 0 || !isPlaying()) {
            long j2 = this.pOj;
            AppMethodBeat.o(7529);
            return j2;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.pOk;
        AppMethodBeat.o(7529);
        return currentTimeMillis;
    }

    public final int getEndPlayTime() {
        AppMethodBeat.i(7530);
        if (getCurrPosMs() != 0 || this.jpW == 0) {
            int currPosMs = getCurrPosMs();
            AppMethodBeat.o(7530);
            return currPosMs;
        }
        int duration = getDuration() * 1000;
        AppMethodBeat.o(7530);
        return duration;
    }

    public final int getDuration() {
        AppMethodBeat.i(7531);
        if (this.atU > 0) {
            int i2 = this.atU;
            AppMethodBeat.o(7531);
            return i2;
        }
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        int videoDurationSec = mPExoVideoWrapper.getVideoDurationSec();
        AppMethodBeat.o(7531);
        return videoDurationSec;
    }

    public final void setDuration(int i2) {
        AppMethodBeat.i(7532);
        if (i2 <= 0) {
            Log.i(TAG, "setDuration error duration=%d", Integer.valueOf(i2));
            AppMethodBeat.o(7532);
            return;
        }
        TextView textView = this.mvP;
        if (textView == null) {
            kotlin.g.b.p.hyc();
        }
        textView.setText(xs(i2));
        this.atU = i2;
        AppMethodBeat.o(7532);
    }

    public final int getCurrPosSec() {
        AppMethodBeat.i(7533);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        int currPosSec = mPExoVideoWrapper.getCurrPosSec();
        AppMethodBeat.o(7533);
        return currPosSec;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.i(7534);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        int currPosMs = mPExoVideoWrapper.getCurrPosMs();
        AppMethodBeat.o(7534);
        return currPosMs;
    }

    public final int getCacheTimeSec() {
        AppMethodBeat.i(7535);
        if (this.pNZ != null) {
            MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int cacheTimeSec = mPExoVideoWrapper.getCacheTimeSec();
            AppMethodBeat.o(7535);
            return cacheTimeSec;
        }
        AppMethodBeat.o(7535);
        return 0;
    }

    public final boolean bJb() {
        AppMethodBeat.i(7536);
        if (this.pOg == null) {
            Log.w(TAG, "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(7536);
            return false;
        }
        b bVar = this.pOg;
        if (bVar == null) {
            kotlin.g.b.p.hyc();
        }
        boolean isFullScreen = bVar.isFullScreen();
        AppMethodBeat.o(7536);
        return isFullScreen;
    }

    private final boolean isLive() {
        AppMethodBeat.i(7537);
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mwh);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        objArr[1] = Boolean.valueOf(mPExoVideoWrapper.bzP);
        Log.i(str, "isLive %b %b", objArr);
        if (!this.mwh) {
            MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
            if (mPExoVideoWrapper2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (!mPExoVideoWrapper2.bzP) {
                AppMethodBeat.o(7537);
                return false;
            }
        }
        AppMethodBeat.o(7537);
        return true;
    }

    private final boolean bJf() {
        AppMethodBeat.i(7538);
        View view = this.mvN;
        if (view == null) {
            kotlin.g.b.p.hyc();
        }
        if (view.getVisibility() == 0) {
            AppMethodBeat.o(7538);
            return true;
        }
        AppMethodBeat.o(7538);
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoView(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(7584);
        init(context);
        AppMethodBeat.o(7584);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(7585);
        init(context);
        AppMethodBeat.o(7585);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(7586);
        init(context);
        AppMethodBeat.o(7586);
    }

    private final void init(Context context) {
        AppMethodBeat.i(7539);
        LayoutInflater.from(context).inflate(R.layout.bbx, this);
        this.pNZ = (MPExoVideoWrapper) findViewById(R.id.j6y);
        View findViewById = findViewById(R.id.gl7);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(7539);
            throw tVar;
        }
        this.mvK = (TextView) findViewById;
        this.mvN = findViewById(R.id.bgx);
        this.mvO = findViewById(R.id.bha);
        View findViewById2 = findViewById(R.id.bhe);
        if (findViewById2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(7539);
            throw tVar2;
        }
        this.mvP = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.i1);
        if (findViewById3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.LinearLayout");
            AppMethodBeat.o(7539);
            throw tVar3;
        }
        this.mvQ = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.i2);
        if (findViewById4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
            AppMethodBeat.o(7539);
            throw tVar4;
        }
        this.mvR = (AppBrandDotPercentIndicator) findViewById4;
        View findViewById5 = findViewById(R.id.hy);
        if (findViewById5 == null) {
            t tVar5 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(7539);
            throw tVar5;
        }
        this.mvS = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i0);
        if (findViewById6 == null) {
            t tVar6 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(7539);
            throw tVar6;
        }
        this.mvT = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.gcs);
        if (findViewById7 == null) {
            t tVar7 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(7539);
            throw tVar7;
        }
        this.mvV = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.gcr);
        if (findViewById8 == null) {
            t tVar8 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(7539);
            throw tVar8;
        }
        this.mvW = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.gct);
        if (findViewById9 == null) {
            t tVar9 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(7539);
            throw tVar9;
        }
        this.mvX = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.gco);
        if (findViewById10 == null) {
            t tVar10 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(7539);
            throw tVar10;
        }
        this.pOb = (FrameLayout) findViewById10;
        View findViewById11 = findViewById(R.id.gcu);
        if (findViewById11 == null) {
            t tVar11 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(7539);
            throw tVar11;
        }
        this.pOc = (FrameLayout) findViewById11;
        View findViewById12 = findViewById(R.id.gcp);
        if (findViewById12 == null) {
            t tVar12 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(7539);
            throw tVar12;
        }
        this.pOd = (FrameLayout) findViewById12;
        AppBrandDotPercentIndicator appBrandDotPercentIndicator = this.mvR;
        if (appBrandDotPercentIndicator == null) {
            kotlin.g.b.p.hyc();
        }
        appBrandDotPercentIndicator.setDotsNum(pOp);
        View findViewById13 = findViewById(R.id.bh_);
        if (findViewById13 == null) {
            t tVar13 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(7539);
            throw tVar13;
        }
        ((ImageView) findViewById13).setOnClickListener(new d(this));
        this.mwf = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new o(this));
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.setIMMVideoViewCallback(new p(this));
        this.pOa = new MPVideoViewControlBar(getContext());
        MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
        if (mPExoVideoWrapper2 == null) {
            kotlin.g.b.p.hyc();
        }
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper2.setVideoFooterView(mPVideoViewControlBar);
        MPVideoViewControlBar mPVideoViewControlBar2 = this.pOa;
        if (mPVideoViewControlBar2 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar2.hide();
        MPVideoViewControlBar mPVideoViewControlBar3 = this.pOa;
        if (mPVideoViewControlBar3 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar3.setFullScreenBtnOnClickListener(new e(this));
        MPVideoViewControlBar mPVideoViewControlBar4 = this.pOa;
        if (mPVideoViewControlBar4 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar4.setIplaySeekCallback(new g(this));
        MPVideoViewControlBar mPVideoViewControlBar5 = this.pOa;
        if (mPVideoViewControlBar5 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar5.setOnPlayButtonClickListener(new h(this));
        MPVideoViewControlBar mPVideoViewControlBar6 = this.pOa;
        if (mPVideoViewControlBar6 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar6.setStatePorter(new i(this));
        MPVideoViewControlBar mPVideoViewControlBar7 = this.pOa;
        if (mPVideoViewControlBar7 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar7.setMuteBtnOnClickListener(new j(this));
        MPVideoViewControlBar mPVideoViewControlBar8 = this.pOa;
        if (mPVideoViewControlBar8 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar8.setExitFullScreenBtnOnClickListener(new k(this));
        MPVideoViewControlBar mPVideoViewControlBar9 = this.pOa;
        if (mPVideoViewControlBar9 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar9.a(new l(this));
        MPVideoViewControlBar mPVideoViewControlBar10 = this.pOa;
        if (mPVideoViewControlBar10 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar10.setOnUpdateProgressLenListener(new m(this));
        MPVideoViewControlBar mPVideoViewControlBar11 = this.pOa;
        if (mPVideoViewControlBar11 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar11.setSwitchResolutionListener(new n(this));
        MPVideoViewControlBar mPVideoViewControlBar12 = this.pOa;
        if (mPVideoViewControlBar12 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar12.setSwitchSpeedListener(new f(this));
        MPExoVideoWrapper mPExoVideoWrapper3 = this.pNZ;
        if (mPExoVideoWrapper3 == null) {
            kotlin.g.b.p.hyc();
        }
        ImageView coverIv = mPExoVideoWrapper3.getCoverIv();
        if (coverIv == null) {
            kotlin.g.b.p.hyc();
        }
        coverIv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setShowProgress(true);
        setShowControlProgress(true);
        setPageGesture(false);
        setPageGestureInFullscreen(true);
        setEnablePlayGesture(true);
        setShowMuteBtn(true);
        setShowFullScreenBtn(true);
        setShowPlayBtn(true);
        setShowCenterPlayBtn(false);
        Log.i(TAG, "enableProgressGesture %b", Boolean.TRUE);
        this.mwl = true;
        setVideoSource(0);
        setConsumeTouchEvent(false);
        setIsShowBasicControls(true);
        AppMethodBeat.o(7539);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ MPVideoView pOr;

        d(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7486);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pOr.start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7486);
        }
    }

    public final void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.i(7540);
        Log.i(TAG, "setConsumeTouchEvent value=%s", Boolean.valueOf(z));
        this.mwk = z;
        AppMethodBeat.o(7540);
    }

    public final void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(7541);
        Log.i(TAG, "showMuteBtn %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.setShowMuteBtn(z);
        AppMethodBeat.o(7541);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(7542);
        Log.i(TAG, "setTitle %s", str);
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.setTitle(str);
        AppMethodBeat.o(7542);
    }

    public final void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(7543);
        Log.i(TAG, "setShowControlProgress %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowControlProgress(z2);
        AppMethodBeat.o(7543);
    }

    public final void setPlayBtnPosition(String str) {
        AppMethodBeat.i(7545);
        kotlin.g.b.p.h(str, "playBtnPosition");
        Log.i(TAG, "setPlayBtnPosition: %s", str);
        if (Util.isNullOrNil(str) || !kotlin.n.n.I(str, "center", true)) {
            MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
            if (mPVideoViewControlBar == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar.setPlayBtnInCenterPosition(false);
            AppMethodBeat.o(7545);
            return;
        }
        MPVideoViewControlBar mPVideoViewControlBar2 = this.pOa;
        if (mPVideoViewControlBar2 == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar2.setPlayBtnInCenterPosition(true);
        AppMethodBeat.o(7545);
    }

    public final void setEnablePlayGesture(boolean z) {
        AppMethodBeat.i(7546);
        Log.i(TAG, "setEnablePlayGesture: %b", Boolean.valueOf(z));
        this.mws = z;
        AppMethodBeat.o(7546);
    }

    public final void setAutoPlay(boolean z) {
        AppMethodBeat.i(7547);
        Log.i(TAG, "setAutoPlay =%b", Boolean.valueOf(z));
        this.cEZ = z;
        if (this.cEZ && this.jpW == 0) {
            this.jpW = 1;
        }
        AppMethodBeat.o(7547);
    }

    public final boolean getAutoPlay() {
        return this.cEZ;
    }

    public final void setVideoSource(int i2) {
        AppMethodBeat.i(7548);
        Log.i(TAG, "setVideoSource =%d", Integer.valueOf(i2));
        this.mwp = i2;
        AppMethodBeat.o(7548);
    }

    public final void setLoop(boolean z) {
        AppMethodBeat.i(7549);
        Log.i(TAG, "setLoop loop=%b", Boolean.valueOf(z));
        this.mLoop = z;
        AppMethodBeat.o(7549);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(7550);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        boolean isPlaying = mPExoVideoWrapper.isPlaying();
        AppMethodBeat.o(7550);
        return isPlaying;
    }

    public final boolean getPlayStart() {
        return this.pOe;
    }

    public final boolean getPlayStarted() {
        return this.pOf;
    }

    public final void start() {
        AppMethodBeat.i(7551);
        String str = TAG;
        StringBuilder sb = new StringBuilder("start isPlaying=");
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        Log.i(str, sb.append(mPExoVideoWrapper.isPlaying()).toString());
        MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
        if (mPExoVideoWrapper2 == null) {
            kotlin.g.b.p.hyc();
        }
        if (mPExoVideoWrapper2.isPlaying()) {
            AppMethodBeat.o(7551);
            return;
        }
        this.pOe = true;
        if (this.mwb) {
            MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
            if (mPVideoViewControlBar == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar.bJz();
        }
        View view = this.mvN;
        if (view == null) {
            kotlin.g.b.p.hyc();
        }
        view.setVisibility(8);
        MPExoVideoWrapper mPExoVideoWrapper3 = this.pNZ;
        if (mPExoVideoWrapper3 == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper3.start();
        crs();
        AppMethodBeat.o(7551);
    }

    public final void pause() {
        AppMethodBeat.i(7552);
        Log.i(TAG, "pause");
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        if (!mPExoVideoWrapper.isPlaying()) {
            AppMethodBeat.o(7552);
            return;
        }
        MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
        if (mPExoVideoWrapper2 == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper2.pause();
        AppMethodBeat.o(7552);
    }

    public final void stop() {
        AppMethodBeat.i(7553);
        Log.i(TAG, "stop");
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        if (!mPExoVideoWrapper.isPlaying()) {
            AppMethodBeat.o(7553);
            return;
        }
        MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
        if (mPExoVideoWrapper2 == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper2.Qt();
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.bJA();
        crr();
        AppMethodBeat.o(7553);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(7554);
        Log.i(TAG, "onUIDestroy");
        clean();
        AppMethodBeat.o(7554);
    }

    private void clean() {
        AppMethodBeat.i(7555);
        Log.i(TAG, "clean");
        stop();
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.onUIDestroy();
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.onDestroy();
        AppMethodBeat.o(7555);
    }

    public final void a(int i2, float f2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(175550);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.a(i2, f2, i3, i4, i5, i6);
        AppMethodBeat.o(175550);
    }

    public final void cN(String str, int i2) {
        AppMethodBeat.i(7556);
        kotlin.g.b.p.h(str, "videoPath");
        Log.i(TAG, "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
        if (Util.isNullOrNil(str)) {
            Log.v(TAG, "setVideoPath videoPath empty");
            AppMethodBeat.o(7556);
            return;
        }
        this.videoPath = str;
        stop();
        this.mwh = false;
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.setVideoSource(this.mwp);
        MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
        if (mPExoVideoWrapper2 == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper2.cM(str, i2);
        if (this.pOi > 0) {
            MPExoVideoWrapper mPExoVideoWrapper3 = this.pNZ;
            if (mPExoVideoWrapper3 == null) {
                kotlin.g.b.p.hyc();
            }
            mPExoVideoWrapper3.ac(this.pOi, this.cEZ);
        }
        if (this.cEZ) {
            Log.i(TAG, "setVideoPath autoPlay");
            start();
        }
        setMute(this.mIsMute);
        AppMethodBeat.o(7556);
    }

    public final void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(7558);
        Log.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.mwb = z;
        if (this.pOa != null) {
            if (this.mwb) {
                MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
                if (mPVideoViewControlBar == null) {
                    kotlin.g.b.p.hyc();
                }
                mPVideoViewControlBar.bJv();
                AppMethodBeat.o(7558);
                return;
            }
            MPVideoViewControlBar mPVideoViewControlBar2 = this.pOa;
            if (mPVideoViewControlBar2 == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar2.hide();
        }
        AppMethodBeat.o(7558);
    }

    public final void a(ImageView imageView, String str, int i2, int i3, x xVar) {
        AppMethodBeat.i(7559);
        kotlin.g.b.p.h(xVar, "msgInfo");
        Log.i(TAG, "setCover coverUrl=%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(7559);
            return;
        }
        this.mwj = str;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l lVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.pLy;
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(imageView, str, i2, i3, xVar);
        AppMethodBeat.o(7559);
    }

    public final void crr() {
        AppMethodBeat.i(7561);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.crr();
        AppMethodBeat.o(7561);
    }

    public final void crs() {
        AppMethodBeat.i(7562);
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.crs();
        AppMethodBeat.o(7562);
    }

    public final void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(7563);
        Log.i(TAG, "setShowProgress %b", Boolean.valueOf(z));
        this.mwm = z;
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowProgress(z2);
        AppMethodBeat.o(7563);
    }

    public final void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(7564);
        Log.i(TAG, "setShowFullScreenBtn %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.setShowFullScreenBtn(z);
        AppMethodBeat.o(7564);
    }

    public final void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(7565);
        Log.i(TAG, "setShowPlayBtn %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.setShowPlayBtn(z);
        AppMethodBeat.o(7565);
    }

    public final void setShowCenterPlayBtn(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(7566);
        Log.i(TAG, "setPlayBtnInCenterPosition %b", Boolean.valueOf(z));
        this.mwo = z;
        View view = this.mvN;
        if (view == null) {
            kotlin.g.b.p.hyc();
        }
        view.setVisibility(z ? 0 : 8);
        View view2 = this.mvO;
        if (view2 == null) {
            kotlin.g.b.p.hyc();
        }
        if (!z) {
            i2 = 8;
        }
        view2.setVisibility(i2);
        if (this.mwo && this.pOa != null) {
            MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
            if (mPVideoViewControlBar == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar.hide();
        }
        AppMethodBeat.o(7566);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(7567);
        Log.i(TAG, "setMute isMute=%b", Boolean.valueOf(z));
        this.mIsMute = z;
        MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoWrapper.setMute(z);
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.setMuteBtnState(z);
        AppMethodBeat.o(7567);
    }

    public final void setFullScreenDirection(int i2) {
        AppMethodBeat.i(7568);
        Log.i(TAG, "setFullScreenDirection %d", Integer.valueOf(i2));
        this.add = i2;
        AppMethodBeat.o(7568);
    }

    public final void setPageGesture(boolean z) {
        AppMethodBeat.i(7569);
        Log.i(TAG, "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.mwd = z;
        AppMethodBeat.o(7569);
    }

    public final void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.i(7570);
        Log.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", Boolean.valueOf(z));
        this.mwe = z;
        AppMethodBeat.o(7570);
    }

    public final void setInitialTime(int i2) {
        AppMethodBeat.i(7571);
        Log.i(TAG, "setInitialTime initialTime=%s", Integer.valueOf(i2));
        this.pOi = i2;
        AppMethodBeat.o(7571);
    }

    public final void a(LinkedList<gh> linkedList, gh ghVar) {
        AppMethodBeat.i(175551);
        kotlin.g.b.p.h(linkedList, "urlInfoList");
        kotlin.g.b.p.h(ghVar, "currentInfo");
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.a(linkedList, ghVar);
        AppMethodBeat.o(175551);
    }

    public final void setFullScreenDelegate(b bVar) {
        AppMethodBeat.i(7572);
        kotlin.g.b.p.h(bVar, "delegate");
        this.pOg = bVar;
        AppMethodBeat.o(7572);
    }

    public final void setMPVideoViewCallBack(c cVar) {
        AppMethodBeat.i(7573);
        kotlin.g.b.p.h(cVar, "delegate");
        this.pOh = cVar;
        AppMethodBeat.o(7573);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016¨\u0006\u001a"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
    public static final class o implements a.b {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void bJj() {
            AppMethodBeat.i(7500);
            Log.d(MPVideoView.TAG, "onSingleTap");
            if (this.pOr.mwb && !this.pOr.mwo) {
                MPVideoViewControlBar mPVideoViewControlBar = this.pOr.pOa;
                if (mPVideoViewControlBar == null) {
                    kotlin.g.b.p.hyc();
                }
                mPVideoViewControlBar.bJu();
            }
            View view = this.pOr.mvN;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            if (view.getVisibility() != 0 && this.pOr.mwr) {
                MPVideoView.f(this.pOr);
            }
            AppMethodBeat.o(7500);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void bJk() {
            AppMethodBeat.i(7501);
            Log.d(MPVideoView.TAG, "onDoubleTap");
            if (this.pOr.mws) {
                MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
                if (mPExoVideoWrapper == null) {
                    kotlin.g.b.p.hyc();
                }
                if (mPExoVideoWrapper.isPlaying()) {
                    this.pOr.pause();
                    m.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
                    m.a.DR(35);
                    AppMethodBeat.o(7501);
                    return;
                }
                this.pOr.start();
                m.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
                m.a.DR(36);
            }
            AppMethodBeat.o(7501);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void bJl() {
            AppMethodBeat.i(7502);
            if (!MPVideoView.i(this.pOr)) {
                AppMethodBeat.o(7502);
                return;
            }
            TextView textView = this.pOr.mvK;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            textView.setVisibility(0);
            MPVideoView.f(this.pOr);
            if (this.pOr.isPlaying()) {
                this.pOr.crA();
            }
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.bJl();
                AppMethodBeat.o(7502);
                return;
            }
            AppMethodBeat.o(7502);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final int k(int i2, float f2) {
            AppMethodBeat.i(7503);
            if (!MPVideoView.i(this.pOr)) {
                AppMethodBeat.o(7503);
                return 0;
            }
            Log.i(MPVideoView.TAG, "onDragProgress:" + i2 + '/' + f2);
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int videoDurationSec = mPExoVideoWrapper.getVideoDurationSec();
            int c2 = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(f2, (float) this.pOr.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
            String AF = com.tencent.mm.plugin.appbrand.jsapi.video.l.AF(((long) videoDurationSec) * 1000);
            TextView textView = this.pOr.mvK;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            textView.setText(com.tencent.mm.plugin.appbrand.jsapi.video.l.AF(((long) c2) * 1000) + FilePathGenerator.ANDROID_DIR_SEP + AF);
            MPVideoViewControlBar mPVideoViewControlBar = this.pOr.pOa;
            if (mPVideoViewControlBar == null) {
                kotlin.g.b.p.hyc();
            }
            mPVideoViewControlBar.seek(c2);
            MPVideoViewControlBar mPVideoViewControlBar2 = this.pOr.pOa;
            if (mPVideoViewControlBar2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (mPVideoViewControlBar2.bJw()) {
                MPVideoViewControlBar mPVideoViewControlBar3 = this.pOr.pOa;
                if (mPVideoViewControlBar3 == null) {
                    kotlin.g.b.p.hyc();
                }
                mPVideoViewControlBar3.bJB();
            }
            AppMethodBeat.o(7503);
            return c2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void l(int i2, float f2) {
            AppMethodBeat.i(7504);
            if (!MPVideoView.i(this.pOr)) {
                AppMethodBeat.o(7504);
                return;
            }
            TextView textView = this.pOr.mvK;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            textView.setVisibility(8);
            MPVideoView.l(this.pOr);
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int currPosSec = mPExoVideoWrapper.getCurrPosSec();
            Log.i(MPVideoView.TAG, "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i2), Integer.valueOf(currPosSec), Float.valueOf(f2));
            MPVideoView.a(this.pOr, i2 * 1000);
            MPVideoView.m(this.pOr);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqD();
                AppMethodBeat.o(7504);
                return;
            }
            AppMethodBeat.o(7504);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final int getCurrentPosition() {
            AppMethodBeat.i(7505);
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int currPosSec = mPExoVideoWrapper.getCurrPosSec();
            AppMethodBeat.o(7505);
            return currPosSec;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final boolean bJo() {
            AppMethodBeat.i(259603);
            boolean r = MPVideoView.r(this.pOr);
            AppMethodBeat.o(259603);
            return r;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final boolean bJp() {
            AppMethodBeat.i(259604);
            boolean r = MPVideoView.r(this.pOr);
            AppMethodBeat.o(259604);
            return r;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final boolean bJq() {
            AppMethodBeat.i(7512);
            boolean i2 = MPVideoView.i(this.pOr);
            AppMethodBeat.o(7512);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void aM(float f2) {
            AppMethodBeat.i(7506);
            if (!MPVideoView.r(this.pOr)) {
                AppMethodBeat.o(7506);
                return;
            }
            Log.d(MPVideoView.TAG, "onAdjustVolume:".concat(String.valueOf(f2)));
            AppBrandDotPercentIndicator appBrandDotPercentIndicator = this.pOr.mvR;
            if (appBrandDotPercentIndicator == null) {
                kotlin.g.b.p.hyc();
            }
            appBrandDotPercentIndicator.setPercent(f2);
            TextView textView = this.pOr.mvS;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            textView.setText(R.string.et6);
            ImageView imageView = this.pOr.mvT;
            if (imageView == null) {
                kotlin.g.b.p.hyc();
            }
            imageView.setImageResource(R.drawable.brp);
            LinearLayout linearLayout = this.pOr.mvQ;
            if (linearLayout == null) {
                kotlin.g.b.p.hyc();
            }
            linearLayout.setVisibility(0);
            MPVideoView.f(this.pOr);
            AppMethodBeat.o(7506);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void aN(float f2) {
            AppMethodBeat.i(7507);
            if (!MPVideoView.r(this.pOr)) {
                AppMethodBeat.o(7507);
                return;
            }
            Log.d(MPVideoView.TAG, "onAdjustBrightness:".concat(String.valueOf(f2)));
            AppBrandDotPercentIndicator appBrandDotPercentIndicator = this.pOr.mvR;
            if (appBrandDotPercentIndicator == null) {
                kotlin.g.b.p.hyc();
            }
            appBrandDotPercentIndicator.setPercent(f2);
            TextView textView = this.pOr.mvS;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            textView.setText(R.string.et5);
            ImageView imageView = this.pOr.mvT;
            if (imageView == null) {
                kotlin.g.b.p.hyc();
            }
            imageView.setImageResource(R.drawable.brn);
            LinearLayout linearLayout = this.pOr.mvQ;
            if (linearLayout == null) {
                kotlin.g.b.p.hyc();
            }
            linearLayout.setVisibility(0);
            MPVideoView.f(this.pOr);
            AppMethodBeat.o(7507);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void bJm() {
            AppMethodBeat.i(7508);
            if (!MPVideoView.r(this.pOr)) {
                AppMethodBeat.o(7508);
                return;
            }
            LinearLayout linearLayout = this.pOr.mvQ;
            if (linearLayout == null) {
                kotlin.g.b.p.hyc();
            }
            linearLayout.setVisibility(8);
            MPVideoView.l(this.pOr);
            m.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
            m.a.DR(41);
            AppMethodBeat.o(7508);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
        public final void bJn() {
            AppMethodBeat.i(7509);
            if (!MPVideoView.r(this.pOr)) {
                AppMethodBeat.o(7509);
                return;
            }
            LinearLayout linearLayout = this.pOr.mvQ;
            if (linearLayout == null) {
                kotlin.g.b.p.hyc();
            }
            linearLayout.setVisibility(8);
            MPVideoView.l(this.pOr);
            m.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
            m.a.DR(39);
            AppMethodBeat.o(7509);
        }
    }

    private final void bIZ() {
        AppMethodBeat.i(7574);
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.bIZ();
        AppMethodBeat.o(7574);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
    public static final class p implements i.b {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void c(String str, String str2, String str3, int i2, int i3) {
            AppMethodBeat.i(7521);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            kotlin.g.b.p.h(str3, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
            Log.i(MPVideoView.TAG, "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
            MMHandlerThread.postToMainThread(new a(this, str3, i2));
            AppMethodBeat.o(7521);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int pNG;
            final /* synthetic */ p pOs;
            final /* synthetic */ String pOt;

            a(p pVar, String str, int i2) {
                this.pOs = pVar;
                this.pOt = str;
                this.pNG = i2;
            }

            public final void run() {
                AppMethodBeat.i(7513);
                this.pOs.pOr.crA();
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    cVar.aiG(this.pOt);
                }
                this.pOs.pOr.setPlayStatus(4);
                AppMethodBeat.o(7513);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dH(String str, String str2) {
            AppMethodBeat.i(7522);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            Log.i(MPVideoView.TAG, "onPrepared");
            MMHandlerThread.postToMainThread(new c(this));
            AppMethodBeat.o(7522);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ p pOs;

            c(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7515);
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    MPExoVideoWrapper mPExoVideoWrapper = this.pOs.pOr.pNZ;
                    cVar.BL(mPExoVideoWrapper != null ? mPExoVideoWrapper.getFirstRenderTime() : 0);
                }
                com.tencent.mm.plugin.appbrand.jsapi.video.ui.a aVar = this.pOs.pOr.mwf;
                if (aVar == null) {
                    kotlin.g.b.p.hyc();
                }
                aVar.bKZ();
                AppMethodBeat.o(7515);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dI(String str, String str2) {
            AppMethodBeat.i(7523);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            Log.i(MPVideoView.TAG, "onVideoEnded");
            MMHandlerThread.postToMainThread(new d(this));
            AppMethodBeat.o(7523);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ p pOs;

            d(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7516);
                this.pOs.pOr.crA();
                TextView textView = this.pOs.pOr.mvK;
                if (textView == null) {
                    kotlin.g.b.p.hyc();
                }
                textView.setVisibility(8);
                if (this.pOs.pOr.mwo) {
                    View view = this.pOs.pOr.mvN;
                    if (view == null) {
                        kotlin.g.b.p.hyc();
                    }
                    view.setVisibility(0);
                    MPVideoViewControlBar mPVideoViewControlBar = this.pOs.pOr.pOa;
                    if (mPVideoViewControlBar == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (mPVideoViewControlBar.bJw()) {
                        MPVideoViewControlBar mPVideoViewControlBar2 = this.pOs.pOr.pOa;
                        if (mPVideoViewControlBar2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        mPVideoViewControlBar2.hide();
                    }
                } else {
                    MPVideoViewControlBar mPVideoViewControlBar3 = this.pOs.pOr.pOa;
                    if (mPVideoViewControlBar3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    mPVideoViewControlBar3.crH();
                    MPVideoViewControlBar mPVideoViewControlBar4 = this.pOs.pOr.pOa;
                    if (mPVideoViewControlBar4 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    mPVideoViewControlBar4.show();
                }
                FrameLayout frameLayout = this.pOs.pOr.mvX;
                if (frameLayout == null) {
                    kotlin.g.b.p.hyc();
                }
                if (frameLayout.getVisibility() == 0) {
                    FrameLayout frameLayout2 = this.pOs.pOr.mvX;
                    if (frameLayout2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    frameLayout2.setVisibility(8);
                }
                if (MPVideoView.u(this.pOs.pOr) || !this.pOs.pOr.mwo) {
                    View view2 = this.pOs.pOr.mvO;
                    if (view2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    view2.setVisibility(8);
                } else {
                    if (this.pOs.pOr.atU <= 0) {
                        TextView textView2 = this.pOs.pOr.mvP;
                        if (textView2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        MPExoVideoWrapper mPExoVideoWrapper = this.pOs.pOr.pNZ;
                        if (mPExoVideoWrapper == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView2.setText(MPVideoView.DZ(mPExoVideoWrapper.getVideoDurationSec()));
                    }
                    View view3 = this.pOs.pOr.mvO;
                    if (view3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    view3.setVisibility(0);
                }
                this.pOs.pOr.crr();
                this.pOs.pOr.setPlayStatus(4);
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    cVar.onVideoEnded();
                    AppMethodBeat.o(7516);
                    return;
                }
                AppMethodBeat.o(7516);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void d(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(7524);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            this.pOr.setVideoWidth(i2);
            this.pOr.setVideoHeight(i3);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqC();
            }
            MMHandlerThread.postToMainThread(new b(this, i2, i3));
            AppMethodBeat.o(7524);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ p pOs;

            b(p pVar, int i2, int i3) {
                this.pOs = pVar;
                this.cKE = i2;
                this.cKF = i3;
            }

            public final void run() {
                AppMethodBeat.i(7514);
                int i2 = this.pOs.pOr.add;
                a aVar = MPVideoView.pOq;
                if (i2 == MPVideoView.pOo) {
                    this.pOs.pOr.add = this.cKE < this.cKF ? 0 : 90;
                    Log.i(MPVideoView.TAG, "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(this.pOs.pOr.add));
                }
                AppMethodBeat.o(7514);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dJ(String str, String str2) {
            boolean z;
            AppMethodBeat.i(7525);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            Log.i(MPVideoView.TAG, "onVideoPause");
            this.pOr.crA();
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.onVideoPause();
            }
            if (this.pOr.getPlayStatus() != 4) {
                this.pOr.setPlayStatus(3);
            }
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            TextView textView = mPExoVideoWrapper.pNe;
            if (textView == null) {
                kotlin.g.b.p.hyc();
            }
            if (textView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                MMHandlerThread.postToMainThreadDelayed(new e(this), 1000);
                AppMethodBeat.o(7525);
                return;
            }
            this.pOr.crC();
            AppMethodBeat.o(7525);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class e implements Runnable {
            final /* synthetic */ p pOs;

            e(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7517);
                this.pOs.pOr.crC();
                AppMethodBeat.o(7517);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class f implements Runnable {
            final /* synthetic */ p pOs;

            f(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7518);
                Log.i(MPVideoView.TAG, "onVideoPlay, isLive:%b", Boolean.valueOf(MPVideoView.u(this.pOs.pOr)));
                this.pOs.pOr.pOf = true;
                this.pOs.pOr.crs();
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    cVar.onVideoPlay();
                }
                if (this.pOs.pOr.atU <= 0 && !MPVideoView.u(this.pOs.pOr)) {
                    TextView textView = this.pOs.pOr.mvP;
                    if (textView == null) {
                        kotlin.g.b.p.hyc();
                    }
                    MPExoVideoWrapper mPExoVideoWrapper = this.pOs.pOr.pNZ;
                    if (mPExoVideoWrapper == null) {
                        kotlin.g.b.p.hyc();
                    }
                    textView.setText(MPVideoView.DZ(mPExoVideoWrapper.getVideoDurationSec()));
                }
                MPVideoView.b(this.pOs.pOr, MPVideoView.u(this.pOs.pOr));
                if (this.pOs.pOr.mwb) {
                    MPVideoView.A(this.pOs.pOr);
                }
                MPVideoView.m(this.pOs.pOr);
                this.pOs.pOr.setPlayStatus(2);
                MPVideoViewControlBar mPVideoViewControlBar = this.pOs.pOr.pOa;
                if (mPVideoViewControlBar == null) {
                    kotlin.g.b.p.hyc();
                }
                if (mPVideoViewControlBar.bJw()) {
                    MPVideoViewControlBar mPVideoViewControlBar2 = this.pOs.pOr.pOa;
                    if (mPVideoViewControlBar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    mPVideoViewControlBar2.bJB();
                }
                AppMethodBeat.o(7518);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dK(String str, String str2) {
            AppMethodBeat.i(7526);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            MMHandlerThread.postToMainThread(new f(this));
            AppMethodBeat.o(7526);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dL(String str, String str2) {
            AppMethodBeat.i(7527);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            Log.i(MPVideoView.TAG, "onVideoWaiting");
            MMHandlerThread.postToMainThread(new g(this));
            AppMethodBeat.o(7527);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class g implements Runnable {
            final /* synthetic */ p pOs;

            g(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7519);
                this.pOs.pOr.mwr = true;
                MPVideoView.f(this.pOs.pOr);
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    cVar.onVideoWaiting();
                    AppMethodBeat.o(7519);
                    return;
                }
                AppMethodBeat.o(7519);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class h implements Runnable {
            final /* synthetic */ p pOs;

            h(p pVar) {
                this.pOs = pVar;
            }

            public final void run() {
                AppMethodBeat.i(7520);
                this.pOs.pOr.mwr = false;
                MPVideoView.l(this.pOs.pOr);
                c cVar = this.pOs.pOr.pOh;
                if (cVar != null) {
                    cVar.cqF();
                    AppMethodBeat.o(7520);
                    return;
                }
                AppMethodBeat.o(7520);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dM(String str, String str2) {
            AppMethodBeat.i(7528);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            MMHandlerThread.postToMainThread(new h(this));
            AppMethodBeat.o(7528);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void fo(String str, String str2) {
            AppMethodBeat.i(196025);
            kotlin.g.b.p.h(str, "sessionId");
            kotlin.g.b.p.h(str2, "mediaId");
            AppMethodBeat.o(196025);
        }
    }

    public final void crA() {
        long j2 = 0;
        AppMethodBeat.i(196026);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.pOj;
        if (this.pOk != 0) {
            j2 = currentTimeMillis - this.pOk;
        }
        this.pOj = j2 + j3;
        this.pOk = currentTimeMillis;
        this.pOl = true;
        AppMethodBeat.o(196026);
    }

    public final boolean getNeedHandleTouchEvent() {
        return this.pOm;
    }

    public final void setNeedHandleTouchEvent(boolean z) {
        this.pOm = z;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(7575);
        kotlin.g.b.p.h(motionEvent, "event");
        if (!bJb()) {
            AppMethodBeat.o(7575);
            return false;
        }
        boolean Q = Q(motionEvent);
        AppMethodBeat.o(7575);
        return Q;
    }

    public final boolean Q(MotionEvent motionEvent) {
        AppMethodBeat.i(175552);
        kotlin.g.b.p.h(motionEvent, "event");
        if (crB()) {
            com.tencent.mm.plugin.appbrand.jsapi.video.ui.a aVar = this.mwf;
            if (aVar != null) {
                aVar.A(motionEvent);
            }
            AppMethodBeat.o(175552);
            return true;
        }
        if (motionEvent.getAction() == 0) {
            if (this.mwb && !this.mwo) {
                MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
                if (mPVideoViewControlBar == null) {
                    kotlin.g.b.p.hyc();
                }
                mPVideoViewControlBar.bJu();
            }
            View view = this.mvN;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            if (view.getVisibility() != 0 && this.mwr) {
                bIZ();
            }
        }
        boolean z = this.mwk;
        AppMethodBeat.o(175552);
        return z;
    }

    private final boolean crB() {
        AppMethodBeat.i(175553);
        if (this.mws) {
            AppMethodBeat.o(175553);
            return true;
        }
        boolean bJd = bJd();
        if (!bJe()) {
            AppMethodBeat.o(175553);
            return false;
        }
        AppMethodBeat.o(175553);
        return bJd;
    }

    public final void p(boolean z, int i2) {
        int i3;
        AppMethodBeat.i(7576);
        Log.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (this.pOg == null) {
            Log.w(TAG, "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(7576);
        } else if (z == bJb()) {
            Log.i(TAG, "operateFullScreen current same");
            AppMethodBeat.o(7576);
        } else {
            if (i2 == pOo) {
                i3 = this.add == pOo ? 90 : this.add;
                Log.i(TAG, "operateFullScreen target direction:%d", Integer.valueOf(i3));
            } else {
                i3 = i2;
            }
            if (z) {
                b bVar = this.pOg;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.xd(i3);
                MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
                if (mPVideoViewControlBar != null) {
                    mPVideoViewControlBar.setDirection(i3);
                }
                MPVideoViewControlBar mPVideoViewControlBar2 = this.pOa;
                if (mPVideoViewControlBar2 != null) {
                    mPVideoViewControlBar2.KD();
                }
                MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
                if (mPExoVideoWrapper != null) {
                    mPExoVideoWrapper.kGg = true;
                    AppMethodBeat.o(7576);
                    return;
                }
                AppMethodBeat.o(7576);
                return;
            }
            b bVar2 = this.pOg;
            if (bVar2 != null) {
                bVar2.bGL();
            }
            MPVideoViewControlBar mPVideoViewControlBar3 = this.pOa;
            if (mPVideoViewControlBar3 != null) {
                mPVideoViewControlBar3.bGL();
            }
            MPExoVideoWrapper mPExoVideoWrapper2 = this.pNZ;
            if (mPExoVideoWrapper2 != null) {
                mPExoVideoWrapper2.kGg = false;
                AppMethodBeat.o(7576);
                return;
            }
            AppMethodBeat.o(7576);
        }
    }

    public final void setPlayBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(7577);
        kotlin.g.b.p.h(onClickListener, "click");
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar != null) {
            mPVideoViewControlBar.setPlayBtnOnClickListener(onClickListener);
            AppMethodBeat.o(7577);
            return;
        }
        AppMethodBeat.o(7577);
    }

    public final void crC() {
        AppMethodBeat.i(7578);
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar != null) {
            mPVideoViewControlBar.crH();
        }
        MPVideoViewControlBar mPVideoViewControlBar2 = this.pOa;
        if (mPVideoViewControlBar2 != null) {
            mPVideoViewControlBar2.show();
            AppMethodBeat.o(7578);
            return;
        }
        AppMethodBeat.o(7578);
    }

    public final boolean crD() {
        AppMethodBeat.i(7579);
        MPVideoViewControlBar mPVideoViewControlBar = this.pOa;
        if (mPVideoViewControlBar != null) {
            boolean bJw = mPVideoViewControlBar.bJw();
            AppMethodBeat.o(7579);
            return bJw;
        }
        AppMethodBeat.o(7579);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ MPVideoView pOr;

        e(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7487);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean z = !this.pOr.bJb();
            MPVideoView mPVideoView = this.pOr;
            mPVideoView.p(z, mPVideoView.add);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7487);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
    public static final class g implements e.d {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
        public final void aJq() {
            AppMethodBeat.i(7488);
            Log.i(MPVideoView.TAG, "onSeekPre");
            if (this.pOr.isPlaying()) {
                this.pOr.crA();
            }
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.aJq();
                AppMethodBeat.o(7488);
                return;
            }
            AppMethodBeat.o(7488);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
        public final void rk(int i2) {
            AppMethodBeat.i(7489);
            MPVideoView.a(this.pOr, i2 * 1000);
            MPVideoView.m(this.pOr);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqE();
                AppMethodBeat.o(7489);
                return;
            }
            AppMethodBeat.o(7489);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ MPVideoView pOr;

        h(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7490);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            if (mPExoVideoWrapper.isPlaying()) {
                this.pOr.pause();
            } else {
                this.pOr.start();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7490);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
    public static final class i implements e.i {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.i
        public final int bJh() {
            AppMethodBeat.i(7491);
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int cacheTimeSec = mPExoVideoWrapper.getCacheTimeSec();
            AppMethodBeat.o(7491);
            return cacheTimeSec;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.i
        public final int bJi() {
            AppMethodBeat.i(7492);
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            int videoDurationSec = mPExoVideoWrapper.getVideoDurationSec();
            AppMethodBeat.o(7492);
            return videoDurationSec;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ MPVideoView pOr;

        j(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7493);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pOr.setMute(!this.pOr.mIsMute);
            m.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
            m.a.DR(34);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7493);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ MPVideoView pOr;

        k(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7494);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pOr.p(false, this.pOr.add);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7494);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "visible", "", "onVisibilityChanged"})
    public static final class l implements e.f {
        final /* synthetic */ MPVideoView pOr;

        l(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
            if (r1.getVisibility() == 0) goto L_0x0039;
         */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onVisibilityChanged(boolean r8) {
            /*
            // Method dump skipped, instructions count: 174
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.l.onVisibilityChanged(boolean):void");
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
    public static final class m implements e.AbstractC0717e {
        final /* synthetic */ MPVideoView pOr;

        m(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.AbstractC0717e
        public final void onProgressChanged(int i2, int i3) {
            int i4;
            AppMethodBeat.i(7496);
            if (i3 <= 0) {
                AppMethodBeat.o(7496);
                return;
            }
            if (i2 < 0) {
                i4 = 0;
            } else {
                i4 = i2;
            }
            if (i4 > i3) {
                i4 = i3;
            }
            ImageView imageView = this.pOr.mvW;
            if (imageView == null) {
                kotlin.g.b.p.hyc();
            }
            int width = (i4 * imageView.getWidth()) / i3;
            ImageView imageView2 = this.pOr.mvV;
            if (imageView2 == null) {
                kotlin.g.b.p.hyc();
            }
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(7496);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = width;
            ImageView imageView3 = this.pOr.mvV;
            if (imageView3 == null) {
                kotlin.g.b.p.hyc();
            }
            imageView3.setLayoutParams(layoutParams2);
            ImageView imageView4 = this.pOr.mvV;
            if (imageView4 == null) {
                kotlin.g.b.p.hyc();
            }
            imageView4.requestLayout();
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqG();
                AppMethodBeat.o(7496);
                return;
            }
            AppMethodBeat.o(7496);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
    public static final class n implements MPVideoViewControlBar.a {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.a
        public final void cqI() {
            AppMethodBeat.i(7497);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqI();
                AppMethodBeat.o(7497);
                return;
            }
            AppMethodBeat.o(7497);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.a
        public final void a(gh ghVar, int i2, int i3) {
            AppMethodBeat.i(7498);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.a(i2, i3, ghVar);
            }
            this.pOr.setAutoPlay(this.pOr.isPlaying());
            int currPosMs = this.pOr.getCurrPosMs();
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            if (ghVar == null) {
                kotlin.g.b.p.hyc();
            }
            String str = ghVar.KKh;
            Log.i(MPExoVideoWrapper.TAG, "onSetResolution %b", Boolean.valueOf(mPExoVideoWrapper.pNw));
            mPExoVideoWrapper.pNv = true;
            mPExoVideoWrapper.pNg = str;
            MPExoVideoTextureView mPExoVideoTextureView = mPExoVideoWrapper.pNh;
            Bitmap bitmap = mPExoVideoTextureView != null ? mPExoVideoTextureView.getBitmap() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                ImageView imageView = mPExoVideoWrapper.pNd;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.aij);
                }
            } else {
                ImageView imageView2 = mPExoVideoWrapper.pNd;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(bitmap);
                }
            }
            TextView textView = mPExoVideoWrapper.pNe;
            if (textView != null) {
                textView.setText(mPExoVideoWrapper.getContext().getString(R.string.f3y, str));
            }
            mPExoVideoWrapper.crp();
            mPExoVideoWrapper.BT(0);
            MPExoVideoWrapper mPExoVideoWrapper2 = this.pOr.pNZ;
            if (mPExoVideoWrapper2 == null) {
                kotlin.g.b.p.hyc();
            }
            mPExoVideoWrapper2.crt();
            this.pOr.setInitialTime(currPosMs == 0 ? 1 : currPosMs);
            MPVideoView mPVideoView = this.pOr;
            String str2 = ghVar.url;
            kotlin.g.b.p.g(str2, "info!!.url");
            mPVideoView.cN(str2, this.pOr.getDuration());
            if (!this.pOr.cEZ) {
                MPExoVideoWrapper mPExoVideoWrapper3 = this.pOr.pNZ;
                if (mPExoVideoWrapper3 == null) {
                    kotlin.g.b.p.hyc();
                }
                mPExoVideoWrapper3.pause();
            }
            MPVideoViewControlBar mPVideoViewControlBar = this.pOr.pOa;
            if (mPVideoViewControlBar != null) {
                mPVideoViewControlBar.hide();
                AppMethodBeat.o(7498);
                return;
            }
            AppMethodBeat.o(7498);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.a
        public final void cqH() {
            AppMethodBeat.i(7499);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.cqH();
                AppMethodBeat.o(7499);
                return;
            }
            AppMethodBeat.o(7499);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
    public static final class f implements MPVideoViewControlBar.b {
        final /* synthetic */ MPVideoView pOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MPVideoView mPVideoView) {
            this.pOr = mPVideoView;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.b
        public final void a(gh ghVar, c.a aVar, c.a aVar2) {
            AppMethodBeat.i(196022);
            c cVar = this.pOr.pOh;
            if (cVar != null) {
                cVar.a(aVar, aVar2);
            }
            this.pOr.setAutoPlay(this.pOr.isPlaying());
            int currPosMs = this.pOr.getCurrPosMs();
            MPExoVideoWrapper mPExoVideoWrapper = this.pOr.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            MPExoVideoTextureView mPExoVideoTextureView = mPExoVideoWrapper.pNh;
            Bitmap bitmap = mPExoVideoTextureView != null ? mPExoVideoTextureView.getBitmap() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                ImageView imageView = mPExoVideoWrapper.pNd;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.aij);
                }
            } else {
                ImageView imageView2 = mPExoVideoWrapper.pNd;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(bitmap);
                }
            }
            ImageView imageView3 = mPExoVideoWrapper.pNd;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            mPExoVideoWrapper.BT(0);
            MPExoVideoWrapper mPExoVideoWrapper2 = this.pOr.pNZ;
            if (mPExoVideoWrapper2 == null) {
                kotlin.g.b.p.hyc();
            }
            mPExoVideoWrapper2.crt();
            MPVideoView mPVideoView = this.pOr;
            if (currPosMs == 0) {
                currPosMs = 1;
            }
            mPVideoView.setInitialTime(currPosMs);
            MPVideoView mPVideoView2 = this.pOr;
            if (ghVar == null) {
                kotlin.g.b.p.hyc();
            }
            String str = ghVar.url;
            kotlin.g.b.p.g(str, "info!!.url");
            mPVideoView2.cN(str, this.pOr.getDuration());
            if (!this.pOr.cEZ) {
                MPExoVideoWrapper mPExoVideoWrapper3 = this.pOr.pNZ;
                if (mPExoVideoWrapper3 == null) {
                    kotlin.g.b.p.hyc();
                }
                mPExoVideoWrapper3.pause();
            }
            MPVideoViewControlBar mPVideoViewControlBar = this.pOr.pOa;
            if (mPVideoViewControlBar != null) {
                mPVideoViewControlBar.hide();
                AppMethodBeat.o(196022);
                return;
            }
            AppMethodBeat.o(196022);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.b
        public final void crF() {
            AppMethodBeat.i(179030);
            c unused = this.pOr.pOh;
            AppMethodBeat.o(179030);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.b
        public final void crG() {
            AppMethodBeat.i(179031);
            c unused = this.pOr.pOh;
            AppMethodBeat.o(179031);
        }
    }

    private static String xs(int i2) {
        AppMethodBeat.i(7580);
        String str = xt(i2 / 60) + ":" + xt(i2 % 60);
        AppMethodBeat.o(7580);
        return str;
    }

    private static String xt(int i2) {
        AppMethodBeat.i(7581);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(7581);
            return concat;
        }
        String str = String.valueOf(i2);
        AppMethodBeat.o(7581);
        return str;
    }

    private final boolean bJd() {
        AppMethodBeat.i(7582);
        if (this.mwl) {
            MPExoVideoWrapper mPExoVideoWrapper = this.pNZ;
            if (mPExoVideoWrapper == null) {
                kotlin.g.b.p.hyc();
            }
            if (!mPExoVideoWrapper.bzP && !bJf()) {
                AppMethodBeat.o(7582);
                return true;
            }
        }
        AppMethodBeat.o(7582);
        return false;
    }

    private final boolean bJe() {
        AppMethodBeat.i(7583);
        if (bJf() || ((bJb() || !this.mwd) && (!bJb() || !this.mwe))) {
            AppMethodBeat.o(7583);
            return false;
        }
        AppMethodBeat.o(7583);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$Companion;", "", "()V", "FULLSCREEN_DIRECTION_UNKNOWN", "", "getFULLSCREEN_DIRECTION_UNKNOWN", "()I", "TAG", "", "VOLUME_BRIGHTNESS_NUM_STARS", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(7587);
        AppMethodBeat.o(7587);
    }

    public static /* synthetic */ void a(MPVideoView mPVideoView, int i2) {
        AppMethodBeat.i(7557);
        MPExoVideoWrapper mPExoVideoWrapper = mPVideoView.pNZ;
        if (mPExoVideoWrapper == null) {
            kotlin.g.b.p.hyc();
        }
        int currPosSec = mPExoVideoWrapper.getCurrPosSec();
        Log.i(TAG, "seek to position=%s current=%d isLive=%b", Integer.valueOf(i2), Integer.valueOf(currPosSec), Boolean.valueOf(mPVideoView.mwh));
        if (!mPVideoView.isLive()) {
            View view = mPVideoView.mvN;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            view.setVisibility(8);
            MPExoVideoWrapper mPExoVideoWrapper2 = mPVideoView.pNZ;
            if (mPExoVideoWrapper2 == null) {
                kotlin.g.b.p.hyc();
            }
            MPExoVideoWrapper.a(mPExoVideoWrapper2, i2);
        }
        AppMethodBeat.o(7557);
    }

    public static final /* synthetic */ void l(MPVideoView mPVideoView) {
        AppMethodBeat.i(7590);
        MPVideoViewControlBar mPVideoViewControlBar = mPVideoView.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        mPVideoViewControlBar.bJC();
        AppMethodBeat.o(7590);
    }

    public static final /* synthetic */ void m(MPVideoView mPVideoView) {
        AppMethodBeat.i(196027);
        mPVideoView.pOk = System.currentTimeMillis();
        AppMethodBeat.o(196027);
    }

    public static final /* synthetic */ void b(MPVideoView mPVideoView, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(7595);
        Log.i(TAG, "updateLiveUI isLive:%b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = mPVideoView.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        if (!mPVideoView.mwm || z) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowProgress(z2);
        AppMethodBeat.o(7595);
    }

    public static final /* synthetic */ void A(MPVideoView mPVideoView) {
        AppMethodBeat.i(7596);
        MPVideoViewControlBar mPVideoViewControlBar = mPVideoView.pOa;
        if (mPVideoViewControlBar == null) {
            kotlin.g.b.p.hyc();
        }
        boolean bJD = mPVideoViewControlBar.bJD();
        if (!mPVideoView.mwb || !mPVideoView.mwm || bJD || mPVideoView.isLive() || mPVideoView.bJf() || mPVideoView.bJb()) {
            FrameLayout frameLayout = mPVideoView.mvX;
            if (frameLayout == null) {
                kotlin.g.b.p.hyc();
            }
            frameLayout.setVisibility(8);
            AppMethodBeat.o(7596);
            return;
        }
        FrameLayout frameLayout2 = mPVideoView.mvX;
        if (frameLayout2 == null) {
            kotlin.g.b.p.hyc();
        }
        frameLayout2.setVisibility(0);
        AppMethodBeat.o(7596);
    }
}
