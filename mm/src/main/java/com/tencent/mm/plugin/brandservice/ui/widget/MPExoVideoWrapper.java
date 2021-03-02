package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.Arrays;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\be\u0018\u0000 õ\u00012\u00020\u00012\u00020\u0002:\u0002õ\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0007\u0010\u0001\u001a\u00020PJ\u0007\u0010\u0001\u001a\u00020RJ\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0004J\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020\u0011J\u0007\u0010\u0001\u001a\u00020\u0011J\u0007\u0010 \u0001\u001a\u00020\u0011J\n\u0010¡\u0001\u001a\u00030\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010¥\u0001\u001a\u00020\u0011J\u001c\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\tH\u0002J\u0013\u0010©\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\tH\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\u001b\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\tH\u0002J\n\u0010­\u0001\u001a\u00030\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010¯\u0001\u001a\u00030\u00012\u0007\u0010°\u0001\u001a\u00020\t2\u0007\u0010±\u0001\u001a\u00020\tH\u0002J\n\u0010²\u0001\u001a\u00030\u0001H\u0002J\n\u0010³\u0001\u001a\u00030\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010´\u0001\u001a\u00030\u00012\b\u0010|\u001a\u0004\u0018\u00010jJ\n\u0010µ\u0001\u001a\u00030\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030\u0001H\u0002J\b\u0010·\u0001\u001a\u00030\u0001J\b\u0010¸\u0001\u001a\u00030\u0001J\b\u0010¹\u0001\u001a\u00030\u0001J#\u0010º\u0001\u001a\u00030\u00012\u0007\u0010°\u0001\u001a\u00020\t2\u0007\u0010±\u0001\u001a\u00020\t2\u0007\u0010»\u0001\u001a\u00020\tJ\b\u0010¼\u0001\u001a\u00030\u0001J\b\u0010½\u0001\u001a\u00030\u0001J\u0013\u0010¾\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\tH\u0002J\b\u0010¿\u0001\u001a\u00030\u0001J\b\u0010À\u0001\u001a\u00030\u0001J\u0007\u0010Á\u0001\u001a\u00020\u0011J\n\u0010Â\u0001\u001a\u00030\u0001H\u0002J\b\u0010Ã\u0001\u001a\u00030\u0001J\n\u0010Ä\u0001\u001a\u00030\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u0001H\u0002J\n\u0010Æ\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030\u0001H\u0002J\b\u0010È\u0001\u001a\u00030\u0001J\n\u0010É\u0001\u001a\u00030\u0001H\u0002J\u001a\u0010Ê\u0001\u001a\u00030\u00012\u0007\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\u0011J\n\u0010Í\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010Î\u0001\u001a\u00030\u00012\u0007\u0010Ï\u0001\u001a\u00020\t2\t\b\u0002\u0010Ð\u0001\u001a\u00020\u0011J\u0015\u0010Ñ\u0001\u001a\u00030\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010jH\u0002J8\u0010Ó\u0001\u001a\u00030\u00012\u0006\u0010t\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010v\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010u\u001a\u00020\t2\u0006\u0010r\u001a\u00020\tJ\u0011\u0010Ô\u0001\u001a\u00030\u00012\u0007\u0010Õ\u0001\u001a\u00020\u001fJ\u0013\u0010Ö\u0001\u001a\u00030\u00012\u0007\u0010×\u0001\u001a\u00020\u0011H\u0016J\u0011\u0010Ø\u0001\u001a\u00030\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0011J\b\u0010Ú\u0001\u001a\u00030\u0001J\u0011\u0010Û\u0001\u001a\u00030\u00012\u0007\u0010Ü\u0001\u001a\u000204J#\u0010Ý\u0001\u001a\u00030\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00112\u0007\u0010ß\u0001\u001a\u00020j2\u0007\u0010à\u0001\u001a\u00020\tJ\u0011\u0010á\u0001\u001a\u00030\u00012\u0007\u0010â\u0001\u001a\u00020\tJ\u0013\u0010ã\u0001\u001a\u00030\u00012\u0007\u0010ä\u0001\u001a\u00020\tH\u0002J\b\u0010å\u0001\u001a\u00030\u0001J\n\u0010æ\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010ç\u0001\u001a\u00030\u00012\u0007\u0010è\u0001\u001a\u00020RH\u0004J\u0007\u0010é\u0001\u001a\u00020\u0011J\n\u0010ê\u0001\u001a\u00030\u0001H\u0004J\n\u0010ë\u0001\u001a\u00030\u0001H\u0004J\u0007\u0010ì\u0001\u001a\u00020\u0011J\n\u0010í\u0001\u001a\u00030\u0001H\u0004J\n\u0010î\u0001\u001a\u00030\u0001H\u0002J\b\u0010ï\u0001\u001a\u00030\u0001J\n\u0010ð\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010ñ\u0001\u001a\u00030\u00012\u0007\u0010ò\u0001\u001a\u00020\tH\u0004J\u0013\u0010ó\u0001\u001a\u00030\u00012\u0007\u0010ô\u0001\u001a\u00020\u0011H\u0002R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b'\u0010\u000bR\u0011\u0010(\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u000e\u0010*\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001a\u0010/\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u00109R\u001a\u0010=\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u00109R\u0011\u0010?\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b?\u0010\u0013R\u001a\u0010@\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u00109R\u001a\u0010B\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u00109R\u000e\u0010D\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u000b\"\u0004\bn\u00102R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0013\"\u0004\bz\u00109R\u000e\u0010{\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020~X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u00020!X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010#\"\u0005\b\u0001\u0010%R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0013\u0010\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000bR\u0013\u0010\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000bR\u0013\u0010\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000bR\u0013\u0010\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000b¨\u0006ö\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "Lkotlin/Lazy;", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "inBackGround", "isControllerBarShowing", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", AssetExtension.SCENE_PLAY, "retryWhenError", "seekTo", LocaleUtil.MALAY, "afterPlay", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", com.tencent.mm.plugin.appbrand.jsapi.z.p.NAME, "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper extends RelativeLayout implements d.a {
    public static final String TAG = TAG;
    private static final int pNA = 0;
    public static final a pNB = new a((byte) 0);
    private static final int pNz = 500;
    private int bDU;
    private float bDY;
    private int bFM;
    boolean bzP;
    private boolean cJd;
    private boolean cJe;
    private boolean cJf;
    private boolean cJi;
    public boolean cJj;
    private boolean cJk;
    private final boolean cJl;
    private int cJn;
    private int cJo;
    private String cJp;
    private boolean cJr;
    MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private boolean isb;
    boolean kGg;
    private int mCn;
    private int mCo;
    private int mCp;
    private int mCq;
    public boolean mEI;
    private MTimerHandler mEP;
    private MTimerHandler mER;
    private final Runnable mEU;
    private int mEd;
    private boolean mEn;
    public boolean mEw;
    public ProgressBar mEz;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private ImageView mvU;
    private int mwI;
    private int mwp;
    private final int pMZ = 5000;
    private final int pNa = 200;
    private final int pNb = 5;
    private LinearLayout pNc;
    ImageView pNd;
    TextView pNe;
    private com.tencent.mm.pluginsdk.ui.h pNf;
    String pNg;
    MPExoVideoTextureView pNh;
    public com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f pNi;
    private i.b pNj;
    public final com.tencent.mm.model.d pNk;
    private String pNl;
    public boolean pNm;
    private int pNn;
    public boolean pNo;
    private boolean pNp;
    private int pNq;
    private boolean pNr;
    private long pNs;
    private boolean pNt;
    boolean pNu;
    boolean pNv;
    boolean pNw;
    private MTimerHandler pNx;
    private final kotlin.f pNy;

    private final boolean getAbTestVideoPreload() {
        AppMethodBeat.i(196018);
        boolean booleanValue = ((Boolean) this.pNy.getValue()).booleanValue();
        AppMethodBeat.o(196018);
        return booleanValue;
    }

    public static final /* synthetic */ void b(MPExoVideoWrapper mPExoVideoWrapper, int i2, int i3) {
        AppMethodBeat.i(7474);
        mPExoVideoWrapper.onError(i2, i3);
        AppMethodBeat.o(7474);
    }

    public static final /* synthetic */ void b(MPExoVideoWrapper mPExoVideoWrapper, boolean z2) {
        AppMethodBeat.i(7481);
        mPExoVideoWrapper.hP(z2);
        AppMethodBeat.o(7481);
    }

    public static final /* synthetic */ void c(MPExoVideoWrapper mPExoVideoWrapper, boolean z2) {
        AppMethodBeat.i(7482);
        super.setKeepScreenOn(z2);
        AppMethodBeat.o(7482);
    }

    public static final /* synthetic */ void f(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7468);
        mPExoVideoWrapper.Qu();
        AppMethodBeat.o(7468);
    }

    public static final /* synthetic */ j.a g(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(196020);
        j.a bizVideoProfiler = mPExoVideoWrapper.getBizVideoProfiler();
        AppMethodBeat.o(196020);
        return bizVideoProfiler;
    }

    public static final /* synthetic */ void k(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7469);
        mPExoVideoWrapper.prepareAsync();
        AppMethodBeat.o(7469);
    }

    public static final /* synthetic */ void p(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7472);
        mPExoVideoWrapper.crq();
        AppMethodBeat.o(7472);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPExoVideoWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(7466);
        com.tencent.mm.model.d aTu = com.tencent.mm.model.d.aTu();
        kotlin.g.b.p.g(aTu, "AudioHelperTool.createTool()");
        this.pNk = aTu;
        this.mwp = pNA;
        this.mEw = true;
        this.bDU = 800000;
        this.bDY = 0.75f;
        this.mCn = 10000;
        this.mCo = 25000;
        this.mCp = 15000;
        this.mCq = CommonUtils.MAX_TIMEOUT_MS;
        this.mEP = new MTimerHandler(new d(this), true);
        LayoutInflater.from(getContext()).inflate(R.layout.bbw, this);
        this.pNh = (MPExoVideoTextureView) findViewById(R.id.fly);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        this.pNc = (LinearLayout) findViewById(R.id.j4y);
        this.mvU = (ImageView) findViewById(R.id.flr);
        this.pNd = (ImageView) findViewById(R.id.flx);
        this.pNe = (TextView) findViewById(R.id.ifh);
        MPExoVideoTextureView mPExoVideoTextureView = this.pNh;
        if (mPExoVideoTextureView == null) {
            kotlin.g.b.p.hyc();
        }
        mPExoVideoTextureView.setSurfaceTextureListener(new n(this));
        this.mEU = new ab(this);
        this.pNx = new MTimerHandler(new ac(this), false);
        this.mER = new MTimerHandler(new l(this), true);
        this.pNy = kotlin.g.ah(b.pNC);
        AppMethodBeat.o(7466);
    }

    /* access modifiers changed from: protected */
    public final int getERROR_CHECK_TIME() {
        return this.pMZ;
    }

    /* access modifiers changed from: protected */
    public final int getERROR_TRY_AGAIN_DELAY_TIME() {
        return this.pNa;
    }

    /* access modifiers changed from: protected */
    public final int getERROR_TRY_MAX_TIME() {
        return this.pNb;
    }

    /* access modifiers changed from: protected */
    public final MMHandler getUiHandler() {
        return this.hAk;
    }

    /* access modifiers changed from: protected */
    public final void setUiHandler(MMHandler mMHandler) {
        AppMethodBeat.i(7420);
        kotlin.g.b.p.h(mMHandler, "<set-?>");
        this.hAk = mMHandler;
        AppMethodBeat.o(7420);
    }

    /* access modifiers changed from: protected */
    public final ProgressBar getLoading() {
        return this.mEz;
    }

    /* access modifiers changed from: protected */
    public final void setLoading(ProgressBar progressBar) {
        this.mEz = progressBar;
    }

    public final void setLive(boolean z2) {
        this.bzP = z2;
    }

    /* access modifiers changed from: protected */
    public final int getMVideoSource() {
        return this.mwp;
    }

    /* access modifiers changed from: protected */
    public final void setMVideoSource(int i2) {
        this.mwp = i2;
    }

    /* access modifiers changed from: protected */
    public final void setUIAvailable(boolean z2) {
        this.mEw = z2;
    }

    /* access modifiers changed from: protected */
    public final void setPlayOnUiPause(boolean z2) {
        this.mEI = z2;
    }

    private final j.a getBizVideoProfiler() {
        AppMethodBeat.i(196017);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        j.a aiP = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiP(getContext().toString());
        AppMethodBeat.o(196017);
        return aiP;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class d implements MTimerHandler.CallBack {
        final /* synthetic */ MPExoVideoWrapper pND;

        d(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(7388);
            this.pND.isPlaying();
            if (this.pND.mEI) {
                Log.d(MPExoVideoWrapper.TAG, "checkTimer onVideoPlay");
                this.pND.onVideoPlay();
                this.pND.setPlayOnUiPause(false);
            } else {
                this.pND.xI(this.pND.getCurrPosSec());
                MPExoVideoWrapper.b(this.pND, this.pND.isPlaying());
                MPExoVideoWrapper.B(this.pND);
            }
            AppMethodBeat.o(7388);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final MTimerHandler getCheckTimer() {
        return this.mEP;
    }

    /* access modifiers changed from: protected */
    public final void setCheckTimer(MTimerHandler mTimerHandler) {
        AppMethodBeat.i(7421);
        kotlin.g.b.p.h(mTimerHandler, "<set-?>");
        this.mEP = mTimerHandler;
        AppMethodBeat.o(7421);
    }

    public final int getVideoDurationSec() {
        AppMethodBeat.i(7422);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int duration = fVar.getDuration() / 1000;
            AppMethodBeat.o(7422);
            return duration;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(7422);
        return i2;
    }

    public final int getVideoDurationMs() {
        AppMethodBeat.i(7423);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int duration = fVar.getDuration();
            AppMethodBeat.o(7423);
            return duration;
        }
        int i2 = this.mwI * 1000;
        AppMethodBeat.o(7423);
        return i2;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.i(7424);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int currentPosition = fVar.getCurrentPosition();
            AppMethodBeat.o(7424);
            return currentPosition;
        }
        AppMethodBeat.o(7424);
        return 0;
    }

    public final int getCurrPosSec() {
        AppMethodBeat.i(7425);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int currentPosition = fVar.getCurrentPosition() / 1000;
            AppMethodBeat.o(7425);
            return currentPosition;
        }
        AppMethodBeat.o(7425);
        return 0;
    }

    public final int getCacheTimeSec() {
        AppMethodBeat.i(179023);
        if (getVideoDurationSec() > 0) {
            int videoDurationSec = (this.mEd * getVideoDurationSec()) / 100;
            AppMethodBeat.o(179023);
            return videoDurationSec;
        }
        AppMethodBeat.o(179023);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(7426);
        if (this.pNi == null || !this.cJj) {
            AppMethodBeat.o(7426);
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
        if (fVar == null) {
            kotlin.g.b.p.hyc();
        }
        boolean isPlaying = fVar.isPlaying();
        AppMethodBeat.o(7426);
        return isPlaying;
    }

    public final int getVideoWidth() {
        AppMethodBeat.i(7427);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int videoWidth = fVar.getVideoWidth();
            AppMethodBeat.o(7427);
            return videoWidth;
        }
        AppMethodBeat.o(7427);
        return 0;
    }

    public final int getVideoHeight() {
        AppMethodBeat.i(7428);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            int videoHeight = fVar.getVideoHeight();
            AppMethodBeat.o(7428);
            return videoHeight;
        }
        AppMethodBeat.o(7428);
        return 0;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
    public static final class n implements TextureView.SurfaceTextureListener {
        final /* synthetic */ MPExoVideoWrapper pND;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(7399);
            kotlin.g.b.p.h(surfaceTexture, "surface");
            if (this.pND.getLoading() != null) {
                ProgressBar loading = this.pND.getLoading();
                if (loading == null) {
                    kotlin.g.b.p.hyc();
                }
                if (loading.getVisibility() == 0) {
                    this.pND.hideLoading();
                }
            }
            if (this.pND.mvU != null) {
                ImageView imageView = this.pND.mvU;
                if (imageView == null) {
                    kotlin.g.b.p.hyc();
                }
                if (imageView.getVisibility() == 0 && (this.pND.isPlaying() || this.pND.getCurrPosSec() != 0)) {
                    this.pND.getUiHandler().post(new a(this));
                }
            }
            AppMethodBeat.o(7399);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ n pNE;

            a(n nVar) {
                this.pNE = nVar;
            }

            public final void run() {
                AppMethodBeat.i(7398);
                Log.d(MPExoVideoWrapper.TAG, "hide cover onSurfaceTextureUpdated");
                this.pNE.pND.crs();
                AppMethodBeat.o(7398);
            }
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(7400);
            kotlin.g.b.p.h(surfaceTexture, "surface");
            AppMethodBeat.o(7400);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(7401);
            kotlin.g.b.p.h(surfaceTexture, "surface");
            Log.i(MPExoVideoWrapper.TAG, "on surface texture destroyed");
            this.pND.mSurface = null;
            if (this.pND.pNi == null || !this.pND.cJj) {
                MPExoVideoWrapper.f(this.pND);
                this.pND.mEn = false;
            } else if (this.pND.isPlaying()) {
                this.pND.mEn = true;
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pND.pNi;
                if (fVar != null) {
                    fVar.pause();
                }
            }
            AppMethodBeat.o(7401);
            return false;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ff aiR;
            ff aiR2;
            AppMethodBeat.i(7402);
            kotlin.g.b.p.h(surfaceTexture, "surface");
            Log.i(MPExoVideoWrapper.TAG, "on surface texture available, width %d height %d switching %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.pND.pNv));
            j.a g2 = MPExoVideoWrapper.g(this.pND);
            if (!(g2 == null || (aiR2 = g2.aiR("9")) == null)) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, "PlayerType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                if (aiR2 != null) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR2, MPExoVideoWrapper.g(this.pND));
                }
            }
            this.pND.startTimer();
            MPExoVideoTextureView mPExoVideoTextureView = this.pND.pNh;
            if (mPExoVideoTextureView != null) {
                mPExoVideoTextureView.gLi();
            }
            MPExoVideoTextureView mPExoVideoTextureView2 = this.pND.pNh;
            if (mPExoVideoTextureView2 != null) {
                mPExoVideoTextureView2.h(this.pND.mSurface);
            }
            this.pND.mSurface = new Surface(surfaceTexture);
            if (this.pND.pNi != null && this.pND.cJj) {
                Log.i(MPExoVideoWrapper.TAG, "init, setSurface");
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pND.pNi;
                if (fVar == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar.setSurface(this.pND.mSurface);
                if (this.pND.mEn) {
                    j.a g3 = MPExoVideoWrapper.g(this.pND);
                    if (!(g3 == null || (aiR = g3.aiR("15")) == null)) {
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, MPExoVideoWrapper.g(this.pND));
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pND.pNi;
                    if (fVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    fVar2.start();
                }
                this.pND.mEn = false;
            } else if (this.pND.pNv) {
                this.pND.ab(this.pND.pNq, this.pND.pNr);
            } else {
                this.pND.crt();
                MPExoVideoWrapper.k(this.pND);
            }
            if (!this.pND.kGg && this.pND.pNv) {
                MPExoVideoWrapper.m(this.pND);
            }
            AppMethodBeat.o(7402);
        }
    }

    public final void ab(int i2, boolean z2) {
        AppMethodBeat.i(7429);
        Log.i(TAG, "prepare async");
        crt();
        prepareAsync();
        ac(i2, z2);
        if (z2) {
            start();
        }
        AppMethodBeat.o(7429);
    }

    public final ImageView getCoverIv() {
        AppMethodBeat.i(7430);
        ImageView imageView = this.mvU;
        if (imageView == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(7430);
        return imageView;
    }

    /* access modifiers changed from: package-private */
    public final void crp() {
        AppMethodBeat.i(7431);
        ImageView imageView = this.pNd;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (!this.pNw) {
            TextView textView = this.pNe;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.pNu = false;
            AppMethodBeat.o(7431);
            return;
        }
        this.pNu = true;
        AppMethodBeat.o(7431);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class r implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        r(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7405);
            MPExoVideoWrapper.n(this.pND);
            AppMethodBeat.o(7405);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class q implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        q(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(196016);
            if (this.pND.pNv) {
                MPExoVideoWrapper.n(this.pND);
            }
            AppMethodBeat.o(196016);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class s implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        s(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7406);
            ImageView imageView = this.pND.pNd;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            MPExoVideoWrapper.p(this.pND);
            AppMethodBeat.o(7406);
        }
    }

    /* access modifiers changed from: package-private */
    public final void crq() {
        AppMethodBeat.i(7432);
        if (this.pNg != null) {
            TextView textView = this.pNe;
            if (textView != null) {
                textView.setText(getContext().getString(R.string.f3x, this.pNg));
            }
            this.hAk.postDelayed(new t(this), 1500);
            AppMethodBeat.o(7432);
            return;
        }
        Log.w(TAG, "resolutionStr is null");
        TextView textView2 = this.pNe;
        if (textView2 != null) {
            textView2.setVisibility(8);
            AppMethodBeat.o(7432);
            return;
        }
        AppMethodBeat.o(7432);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class t implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        t(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7407);
            TextView textView = this.pND.pNe;
            if (textView != null) {
                textView.setVisibility(8);
                AppMethodBeat.o(7407);
                return;
            }
            AppMethodBeat.o(7407);
        }
    }

    public final boolean getNeedShowSwitchTitleTextView() {
        return this.pNu;
    }

    public final void setNeedShowSwitchTitleTextView(boolean z2) {
        this.pNu = z2;
    }

    public final void setSwitchingResolution(boolean z2) {
        this.pNv = z2;
    }

    public final void setControllerBarShowing(boolean z2) {
        this.pNw = z2;
    }

    public final void crr() {
        AppMethodBeat.i(7433);
        Log.d(TAG, "show cover");
        ImageView imageView = this.mvU;
        if (imageView == null) {
            kotlin.g.b.p.hyc();
        }
        imageView.setVisibility(0);
        AppMethodBeat.o(7433);
    }

    public final void crs() {
        AppMethodBeat.i(7434);
        Log.d(TAG, "hide cover");
        ImageView imageView = this.mvU;
        if (imageView == null) {
            kotlin.g.b.p.hyc();
        }
        imageView.setVisibility(8);
        AppMethodBeat.o(7434);
    }

    private final synchronized void Qu() {
        AppMethodBeat.i(7435);
        if (this.pNi != null) {
            Log.i(TAG, "releaseMediaPlayer");
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            fVar.a((c.f) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
            if (fVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar2.a((c.e) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar3 = this.pNi;
            if (fVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar3.a((c.g) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar4 = this.pNi;
            if (fVar4 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar4.a((c.b) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar5 = this.pNi;
            if (fVar5 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar5.a((c.h) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar6 = this.pNi;
            if (fVar6 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar6.a((c.i) null);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar7 = this.pNi;
            if (fVar7 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar7.stop();
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar8 = this.pNi;
            if (fVar8 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar8.reset();
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar9 = this.pNi;
            if (fVar9 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar9.release();
        }
        this.pNi = null;
        this.cJk = false;
        AppMethodBeat.o(7435);
    }

    private final void cro() {
        MPExoVideoTextureView mPExoVideoTextureView;
        AppMethodBeat.i(7436);
        if (this.mSurface == null || !this.cJj || (mPExoVideoTextureView = this.pNh) == null) {
            AppMethodBeat.o(7436);
            return;
        }
        mPExoVideoTextureView.cro();
        AppMethodBeat.o(7436);
    }

    private final void reset() {
        this.cJd = false;
        this.cJe = false;
        this.cJf = false;
    }

    public final void a(int i2, float f2, int i3, int i4, int i5, int i6) {
        boolean z2;
        AppMethodBeat.i(175547);
        this.bDU = i2;
        this.bDY = f2;
        this.mCn = i3;
        this.mCo = i4;
        this.mCp = i5;
        this.mCq = i6;
        if (this.bDU == 0 || this.bDY == 0.0f || this.mCn == 0 || this.mCo == 0 || this.mCp == 0 || this.mCq == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.pNt = z2;
        Log.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.pNt);
        AppMethodBeat.o(175547);
    }

    public final void crt() {
        AppMethodBeat.i(7437);
        reset();
        Qu();
        cru();
        Qw();
        AppMethodBeat.o(7437);
    }

    private final void Qw() {
        AppMethodBeat.i(7438);
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            fVar.setMute(this.isb);
            if (this.mSurface != null) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
                if (fVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar2.setSurface(this.mSurface);
            }
        }
        AppMethodBeat.o(7438);
    }

    private final void cru() {
        float f2;
        boolean z2;
        AppMethodBeat.i(7439);
        if (this.pNi != null) {
            AppMethodBeat.o(7439);
            return;
        }
        Log.i(TAG, "createMediaPlayer");
        this.mEd = 0;
        this.pNi = this.pNt ? new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f(this.bDU, this.bDY, this.mCn, this.mCo, this.mCp, this.mCq) : new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f();
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
        if (fVar == null) {
            kotlin.g.b.p.hyc();
        }
        fVar.setLooping(this.cJl);
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
        if (fVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        c cVar = c.pNP;
        c.a cry = c.cry();
        if (cry != null) {
            f2 = cry.pNW;
        } else {
            f2 = 1.0f;
        }
        fVar2.aP(f2);
        if (this.pNi != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.cJk = z2;
        if (!this.cJk) {
            Log.e(TAG, "createMediaPlayer, create media player fail");
            AppMethodBeat.o(7439);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar3 = this.pNi;
        if (fVar3 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar3.a(new e(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar4 = this.pNi;
        if (fVar4 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar4.a(new f(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar5 = this.pNi;
        if (fVar5 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar5.a(new g(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar6 = this.pNi;
        if (fVar6 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar6.a(new h(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar7 = this.pNi;
        if (fVar7 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar7.a(new i(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar8 = this.pNi;
        if (fVar8 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar8.a(new j(this));
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar9 = this.pNi;
        if (fVar9 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar9.a(new k(this));
        if (!Util.isNullOrNil(this.cJp)) {
            if (Util.isNullOrNil(this.pNl)) {
                com.tencent.mm.plugin.appbrand.jsapi.video.j bJE = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
                kotlin.g.b.p.g(bJE, "VideoCore.getInstance()");
                if (bJE.bJG()) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.j bJE2 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
                    kotlin.g.b.p.g(bJE2, "VideoCore.getInstance()");
                    if (bJE2.bJF()) {
                        this.pNl = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(this.cJp);
                    }
                }
            }
            if (!Util.isNullOrNil(this.pNl)) {
                setDataSourceWithCustomKey(this.pNl);
                AppMethodBeat.o(7439);
                return;
            }
            setDataSourceWithCustomKey(this.cJp);
        }
        AppMethodBeat.o(7439);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
    public static final class e implements c.f {
        final /* synthetic */ MPExoVideoWrapper pND;

        e(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f
        public final boolean cb(int i2, int i3) {
            AppMethodBeat.i(196009);
            boolean a2 = MPExoVideoWrapper.a(this.pND, i2, i3);
            AppMethodBeat.o(196009);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
    public static final class f implements c.e {
        final /* synthetic */ MPExoVideoWrapper pND;

        f(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e
        public final boolean cc(int i2, int i3) {
            AppMethodBeat.i(196010);
            MPExoVideoWrapper.b(this.pND, i2, i3);
            AppMethodBeat.o(196010);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
    public static final class g implements c.g {
        final /* synthetic */ MPExoVideoWrapper pND;

        g(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
            AppMethodBeat.i(196011);
            MPExoVideoWrapper.r(this.pND);
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.dH("", "");
            }
            AppMethodBeat.o(196011);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
    public static final class h implements c.b {
        final /* synthetic */ MPExoVideoWrapper pND;

        h(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
        public final void QA() {
            AppMethodBeat.i(196012);
            MPExoVideoWrapper.t(this.pND);
            AppMethodBeat.o(196012);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
    public static final class i implements c.h {
        final /* synthetic */ MPExoVideoWrapper pND;

        i(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
        public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
            AppMethodBeat.i(196013);
            MPExoVideoWrapper.u(this.pND);
            AppMethodBeat.o(196013);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
    public static final class j implements c.i {
        final /* synthetic */ MPExoVideoWrapper pND;

        j(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, int i2, int i3) {
            AppMethodBeat.i(196014);
            MPExoVideoWrapper.c(this.pND, i2, i3);
            AppMethodBeat.o(196014);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_MP, "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
    public static final class k implements c.a {
        final /* synthetic */ MPExoVideoWrapper pND;

        k(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
        public final void id(int i2) {
            AppMethodBeat.i(196015);
            MPExoVideoWrapper.b(this.pND, i2);
            AppMethodBeat.o(196015);
        }
    }

    public final long getFirstRenderTime() {
        AppMethodBeat.i(177797);
        if (this.pNs != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.pNs;
            AppMethodBeat.o(177797);
            return currentTimeMillis;
        }
        AppMethodBeat.o(177797);
        return 0;
    }

    public final void cM(String str, int i2) {
        AppMethodBeat.i(7440);
        kotlin.g.b.p.h(str, "_url");
        this.cJp = str;
        this.mwI = i2;
        this.bzP = false;
        Log.i(TAG, "setVideoPath, media player prepare async");
        prepareAsync();
        com.tencent.f.h.RTc.b(new z(this), "AppBrandVideo_checkVideoUrl");
        AppMethodBeat.o(7440);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class z implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        z(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7413);
            MPExoVideoWrapper.v(this.pND);
            AppMethodBeat.o(7413);
        }
    }

    public final void setVideoSource(int i2) {
        this.mwp = i2;
    }

    public final void setIMMVideoViewCallback(i.b bVar) {
        AppMethodBeat.i(7441);
        kotlin.g.b.p.h(bVar, "_callback");
        this.pNj = bVar;
        AppMethodBeat.o(7441);
    }

    public final void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h hVar) {
        AppMethodBeat.i(7442);
        kotlin.g.b.p.h(hVar, "_footerView");
        this.pNf = hVar;
        LinearLayout linearLayout = this.pNc;
        if (linearLayout == null) {
            kotlin.g.b.p.hyc();
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.pNc;
        if (linearLayout2 == null) {
            kotlin.g.b.p.hyc();
        }
        linearLayout2.addView((View) this.pNf);
        AppMethodBeat.o(7442);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ae implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;
        final /* synthetic */ int pNK;

        ae(MPExoVideoWrapper mPExoVideoWrapper, int i2) {
            this.pND = mPExoVideoWrapper;
            this.pNK = i2;
        }

        public final void run() {
            AppMethodBeat.i(7418);
            com.tencent.mm.pluginsdk.ui.h hVar = this.pND.pNf;
            if (hVar == null) {
                kotlin.g.b.p.hyc();
            }
            hVar.xv(this.pNK);
            AppMethodBeat.o(7418);
        }
    }

    /* access modifiers changed from: protected */
    public final void xI(int i2) {
        AppMethodBeat.i(7443);
        this.hAk.post(new ae(this, i2));
        AppMethodBeat.o(7443);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class af implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;
        final /* synthetic */ boolean pNL;

        af(MPExoVideoWrapper mPExoVideoWrapper, boolean z) {
            this.pND = mPExoVideoWrapper;
            this.pNL = z;
        }

        public final void run() {
            AppMethodBeat.i(7419);
            com.tencent.mm.pluginsdk.ui.h hVar = this.pND.pNf;
            if (hVar == null) {
                kotlin.g.b.p.hyc();
            }
            hVar.hP(this.pNL);
            AppMethodBeat.o(7419);
        }
    }

    private final void hP(boolean z2) {
        AppMethodBeat.i(7444);
        this.hAk.post(new af(this, z2));
        AppMethodBeat.o(7444);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class aa implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;
        final /* synthetic */ int pNJ;

        aa(MPExoVideoWrapper mPExoVideoWrapper, int i2) {
            this.pND = mPExoVideoWrapper;
            this.pNJ = i2;
        }

        public final void run() {
            AppMethodBeat.i(7414);
            if (this.pND.pNf != null) {
                com.tencent.mm.pluginsdk.ui.h hVar = this.pND.pNf;
                if (hVar == null) {
                    kotlin.g.b.p.hyc();
                }
                if (hVar.getVideoTotalTime() != this.pNJ) {
                    com.tencent.mm.pluginsdk.ui.h hVar2 = this.pND.pNf;
                    if (hVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    hVar2.setVideoTotalTime(this.pNJ);
                }
            }
            AppMethodBeat.o(7414);
        }
    }

    private final void setVideoTotalTime(int i2) {
        AppMethodBeat.i(7445);
        this.hAk.post(new aa(this, i2));
        AppMethodBeat.o(7445);
    }

    /* access modifiers changed from: protected */
    public final void startTimer() {
        AppMethodBeat.i(7446);
        Log.d(TAG, "start timer");
        if (!this.mEP.stopped()) {
            stopTimer();
        }
        this.mEP.startTimer((long) pNz);
        AppMethodBeat.o(7446);
    }

    private final void stopTimer() {
        AppMethodBeat.i(7447);
        Log.d(TAG, "stop timer");
        this.mEP.stopTimer();
        AppMethodBeat.o(7447);
    }

    public static /* synthetic */ void a(MPExoVideoWrapper mPExoVideoWrapper, int i2) {
        AppMethodBeat.i(7449);
        mPExoVideoWrapper.ac(i2, mPExoVideoWrapper.isPlaying());
        AppMethodBeat.o(7449);
    }

    public final void ac(int i2, boolean z2) {
        AppMethodBeat.i(7448);
        this.pNr = z2;
        int videoDurationMs = getVideoDurationMs();
        if (videoDurationMs > 100 && i2 > videoDurationMs) {
            i2 = videoDurationMs;
        }
        if (!this.cJj || this.pNi == null) {
            this.pNn = i2;
            AppMethodBeat.o(7448);
            return;
        }
        this.cJe = crv();
        Log.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", Boolean.valueOf(this.cJe), Boolean.valueOf(z2), Integer.valueOf(i2));
        if (!z2) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            fVar.pause();
        } else {
            startTimer();
        }
        if (videoDurationMs != i2 && i2 > 0) {
            this.cJr = false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
        if (fVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar2.k((long) i2, z2);
        this.pNq = i2;
        BT(500);
        xI(i2 / 1000);
        AppMethodBeat.o(7448);
    }

    public final boolean crv() {
        AppMethodBeat.i(7450);
        if (this.pNp || isPlaying() || this.cJe || this.cJd) {
            AppMethodBeat.o(7450);
            return true;
        }
        AppMethodBeat.o(7450);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ab implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        ab(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7415);
            if (this.pND.getLoading() != null) {
                ProgressBar loading = this.pND.getLoading();
                if (loading == null) {
                    kotlin.g.b.p.hyc();
                }
                if (loading.getVisibility() != 0) {
                    Log.i(MPExoVideoWrapper.TAG, "show loading");
                    ProgressBar loading2 = this.pND.getLoading();
                    if (loading2 != null) {
                        loading2.setVisibility(0);
                    }
                    MPExoVideoWrapper mPExoVideoWrapper = this.pND;
                    mPExoVideoWrapper.hAk.post(new w(mPExoVideoWrapper));
                }
            }
            AppMethodBeat.o(7415);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class ac implements MTimerHandler.CallBack {
        final /* synthetic */ MPExoVideoWrapper pND;

        ac(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(7416);
            this.pND.getUiHandler().post(this.pND.mEU);
            AppMethodBeat.o(7416);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final MTimerHandler getShowLoadingTimer() {
        return this.pNx;
    }

    /* access modifiers changed from: protected */
    public final void setShowLoadingTimer(MTimerHandler mTimerHandler) {
        AppMethodBeat.i(7451);
        kotlin.g.b.p.h(mTimerHandler, "<set-?>");
        this.pNx = mTimerHandler;
        AppMethodBeat.o(7451);
    }

    /* access modifiers changed from: package-private */
    public final void BT(long j2) {
        AppMethodBeat.i(7452);
        this.pNx.stopTimer();
        this.pNx.startTimer(j2);
        AppMethodBeat.o(7452);
    }

    /* access modifiers changed from: protected */
    public final void hideLoading() {
        AppMethodBeat.i(7453);
        Log.d(TAG, "hide loading %s", Util.getStack());
        this.pNx.stopTimer();
        this.hAk.post(new m(this));
        AppMethodBeat.o(7453);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class m implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        m(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7397);
            if (this.pND.getLoading() != null) {
                ProgressBar loading = this.pND.getLoading();
                if (loading == null) {
                    kotlin.g.b.p.hyc();
                }
                if (loading.getVisibility() != 8) {
                    Log.i(MPExoVideoWrapper.TAG, "hide loading");
                    ProgressBar loading2 = this.pND.getLoading();
                    if (loading2 != null) {
                        loading2.setVisibility(8);
                    }
                    MPExoVideoWrapper mPExoVideoWrapper = this.pND;
                    mPExoVideoWrapper.hAk.postDelayed(new x(mPExoVideoWrapper), 500);
                }
            }
            AppMethodBeat.o(7397);
        }
    }

    private final void prepareAsync() {
        ff aiR;
        AppMethodBeat.i(7454);
        if (this.pNi != null && !Util.isNullOrNil(this.cJp)) {
            if (Util.isNullOrNil(this.pNl)) {
                com.tencent.mm.plugin.appbrand.jsapi.video.j bJE = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
                kotlin.g.b.p.g(bJE, "VideoCore.getInstance()");
                if (bJE.bJG()) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.j bJE2 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
                    kotlin.g.b.p.g(bJE2, "VideoCore.getInstance()");
                    if (bJE2.bJF()) {
                        this.pNl = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(this.cJp);
                    }
                }
            }
            if (!Util.isNullOrNil(this.pNl)) {
                setDataSourceWithCustomKey(this.pNl);
            } else {
                setDataSourceWithCustomKey(this.cJp);
            }
            Log.i(TAG, "video prepare async");
            BT(500);
            this.cJj = false;
            this.pNs = System.currentTimeMillis();
            if (this.pNi != null) {
                j.a bizVideoProfiler = getBizVideoProfiler();
                if (!(bizVideoProfiler == null || (aiR = bizVideoProfiler.aiR(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT)) == null)) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, getBizVideoProfiler());
                }
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
                if (fVar == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar.prepareAsync();
            }
        }
        AppMethodBeat.o(7454);
    }

    public final boolean start() {
        ff aiR;
        AppMethodBeat.i(7455);
        if (!this.mEw) {
            Log.w(TAG, "ui on pause now, why u call me to play? [%s]", Util.getStack());
            AppMethodBeat.o(7455);
            return false;
        } else if (this.mSurface == null) {
            Log.w(TAG, "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.mEn = true;
            this.cJi = true;
            AppMethodBeat.o(7455);
            return false;
        } else {
            this.pNp = true;
            if (this.pNi == null) {
                crt();
                prepareAsync();
            }
            if (this.pNi != null) {
                setKeepScreenOn(true);
                this.pNk.a(this);
                if (this.cJj) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
                    if (fVar == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (fVar.isPlaying()) {
                        Log.i(TAG, "video play, video is playing");
                        onVideoPlay();
                        AppMethodBeat.o(7455);
                        return true;
                    }
                }
                if (this.pNi == null || this.cJj) {
                    if (this.pNi != null) {
                        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
                        if (fVar2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        if (fVar2.getState() == 5) {
                            Log.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
                            this.cJi = true;
                            Log.i(TAG, "video play, media player prepare async");
                            prepareAsync();
                            AppMethodBeat.o(7455);
                            return true;
                        }
                    }
                    if (this.cJr) {
                        Log.i(TAG, "video play, video has ended playing, clear surface and start again");
                        this.cJr = false;
                        cro();
                        crt();
                        prepareAsync();
                        if (this.pNi != null) {
                            this.cJi = true;
                            String str = TAG;
                            Object[] objArr = new Object[1];
                            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar3 = this.pNi;
                            if (fVar3 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            objArr[0] = Integer.valueOf(fVar3.getState());
                            Log.i(str, "video play, media player state:%s", objArr);
                            prepareAsync();
                        }
                        AppMethodBeat.o(7455);
                        return true;
                    }
                    if (this.pNi != null) {
                        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar4 = this.pNi;
                        if (fVar4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        fVar4.start();
                        j.a bizVideoProfiler = getBizVideoProfiler();
                        if (!(bizVideoProfiler == null || (aiR = bizVideoProfiler.aiR("15")) == null)) {
                            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
                            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, getBizVideoProfiler());
                        }
                        onVideoPlay();
                    }
                    AppMethodBeat.o(7455);
                    return true;
                }
                Log.i(TAG, "video play, video not prepared yet, start until prepared");
                this.cJi = true;
                AppMethodBeat.o(7455);
                return true;
            }
            AppMethodBeat.o(7455);
            return false;
        }
    }

    public final boolean pause() {
        AppMethodBeat.i(7456);
        this.pNp = false;
        hP(false);
        stopTimer();
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (!fVar.isPlaying()) {
                Log.i(TAG, "video pause, video is not playing");
                this.cJi = false;
                AppMethodBeat.o(7456);
                return true;
            } else if (!this.cJj) {
                Log.i(TAG, "video pause, video not prepared yet, pause video when prepared");
                this.cJi = false;
                AppMethodBeat.o(7456);
                return true;
            } else {
                Log.i(TAG, "video pause");
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
                if (fVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar2.pause();
                onVideoPause();
                AppMethodBeat.o(7456);
                return true;
            }
        } else {
            AppMethodBeat.o(7456);
            return false;
        }
    }

    public final boolean Qt() {
        AppMethodBeat.i(7457);
        this.pNp = false;
        stopTimer();
        MPExoVideoTextureView mPExoVideoTextureView = this.pNh;
        if (mPExoVideoTextureView != null) {
            mPExoVideoTextureView.stop();
        }
        this.mEd = 0;
        if (this.pNi != null) {
            this.hAk.post(new ad(this));
            AppMethodBeat.o(7457);
            return true;
        }
        AppMethodBeat.o(7457);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ad implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        ad(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7417);
            Log.i(MPExoVideoWrapper.TAG, "video stop");
            this.pND.xI(0);
            MPExoVideoWrapper.b(this.pND, false);
            MPExoVideoWrapper.f(this.pND);
            this.pND.onVideoPause();
            AppMethodBeat.o(7417);
        }
    }

    public final void setMute(boolean z2) {
        AppMethodBeat.i(7458);
        this.isb = z2;
        if (this.pNi != null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            fVar.setMute(this.isb);
        }
        AppMethodBeat.o(7458);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(7459);
        this.pNk.apm();
        setKeepScreenOn(false);
        Qu();
        pause();
        if (this.mSurface != null) {
            Surface surface = this.mSurface;
            if (surface == null) {
                kotlin.g.b.p.hyc();
            }
            surface.release();
            this.mSurface = null;
        }
        stopTimer();
        this.mER.stopTimer();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(7459);
    }

    public final void onVideoPause() {
        AppMethodBeat.i(7460);
        Log.d(TAG, "%d onVideoPause", Integer.valueOf(hashCode()));
        this.hAk.post(new u(this));
        AppMethodBeat.o(7460);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class u implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        u(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7408);
            this.pND.setKeepScreenOn(false);
            this.pND.pNk.apm();
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.dJ("", "");
            }
            AppMethodBeat.o(7408);
        }
    }

    public final void onVideoPlay() {
        AppMethodBeat.i(7461);
        this.pNp = true;
        this.mEI = false;
        Log.d(TAG, "%d onVideoPlay", Integer.valueOf(hashCode()));
        this.hAk.post(new v(this));
        AppMethodBeat.o(7461);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class v implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        v(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7409);
            this.pND.setKeepScreenOn(true);
            this.pND.pNk.a(this.pND);
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.dK("", "");
            }
            MPExoVideoWrapper.b(this.pND, true);
            this.pND.startTimer();
            AppMethodBeat.o(7409);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        w(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7410);
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.dL("", "");
            }
            AppMethodBeat.o(7410);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class x implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        x(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7411);
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.dM("", "");
            }
            AppMethodBeat.o(7411);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class y implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;
        final /* synthetic */ boolean pNI;

        y(MPExoVideoWrapper mPExoVideoWrapper, boolean z) {
            this.pND = mPExoVideoWrapper;
            this.pNI = z;
        }

        public final void run() {
            AppMethodBeat.i(7412);
            MPExoVideoWrapper.c(this.pND, this.pNI);
            AppMethodBeat.o(7412);
        }
    }

    public final void setKeepScreenOn(boolean z2) {
        AppMethodBeat.i(7462);
        Log.d(TAG, "set keep screen on[%b]", Boolean.valueOf(z2));
        this.hAk.post(new y(this, z2));
        AppMethodBeat.o(7462);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        c(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7387);
            MPExoVideoTextureView mPExoVideoTextureView = this.pND.pNh;
            if (mPExoVideoTextureView != null) {
                mPExoVideoTextureView.setVideoSize(this.pND.mVideoWidth, this.pND.mVideoHeight);
            }
            MPExoVideoTextureView mPExoVideoTextureView2 = this.pND.pNh;
            if (mPExoVideoTextureView2 != null) {
                mPExoVideoTextureView2.crn();
            }
            MPExoVideoTextureView mPExoVideoTextureView3 = this.pND.pNh;
            if (mPExoVideoTextureView3 != null) {
                mPExoVideoTextureView3.setScaleType(i.e.CONTAIN);
                AppMethodBeat.o(7387);
                return;
            }
            AppMethodBeat.o(7387);
        }
    }

    private final void crw() {
        AppMethodBeat.i(7463);
        this.hAk.post(new c(this));
        AppMethodBeat.o(7463);
    }

    private final void onError(int i2, int i3) {
        AppMethodBeat.i(7464);
        kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
        String format = String.format("PlayError %s/%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
        Log.w(TAG, "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), format, Integer.valueOf(i2), Integer.valueOf(i3));
        this.bFM++;
        if (this.bFM > this.pNb) {
            this.hAk.post(new o(this, format, i2, i3));
            AppMethodBeat.o(7464);
            return;
        }
        this.hAk.postDelayed(new p(this), (long) this.pNa);
        AppMethodBeat.o(7464);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;
        final /* synthetic */ String pNF;
        final /* synthetic */ int pNG;
        final /* synthetic */ int pNH;

        o(MPExoVideoWrapper mPExoVideoWrapper, String str, int i2, int i3) {
            this.pND = mPExoVideoWrapper;
            this.pNF = str;
            this.pNG = i2;
            this.pNH = i3;
        }

        public final void run() {
            AppMethodBeat.i(7403);
            this.pND.Qt();
            this.pND.hideLoading();
            if (this.pND.pNj != null) {
                i.b bVar = this.pND.pNj;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.c("", "", this.pNF, this.pNG, this.pNH);
            }
            AppMethodBeat.o(7403);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class p implements Runnable {
        final /* synthetic */ MPExoVideoWrapper pND;

        p(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        public final void run() {
            AppMethodBeat.i(7404);
            this.pND.BT(500);
            this.pND.xI(this.pND.getCurrPosSec());
            MPExoVideoWrapper.A(this.pND);
            AppMethodBeat.o(7404);
        }
    }

    /* access modifiers changed from: protected */
    public final int getErrorCount() {
        return this.bFM;
    }

    /* access modifiers changed from: protected */
    public final void setErrorCount(int i2) {
        this.bFM = i2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class l implements MTimerHandler.CallBack {
        final /* synthetic */ MPExoVideoWrapper pND;

        l(MPExoVideoWrapper mPExoVideoWrapper) {
            this.pND = mPExoVideoWrapper;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(7396);
            if (this.pND.getErrorCount() <= 0) {
                AppMethodBeat.o(7396);
                return false;
            } else if (this.pND.isPlaying()) {
                MPExoVideoWrapper.D(this.pND);
                AppMethodBeat.o(7396);
                return false;
            } else {
                AppMethodBeat.o(7396);
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final MTimerHandler getErrorCheckTimer() {
        return this.mER;
    }

    /* access modifiers changed from: protected */
    public final void setErrorCheckTimer(MTimerHandler mTimerHandler) {
        AppMethodBeat.i(7465);
        kotlin.g.b.p.h(mTimerHandler, "<set-?>");
        this.mER = mTimerHandler;
        AppMethodBeat.o(7465);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$Companion;", "", "()V", "SOURCE_TRY_DEFAULT", "", "getSOURCE_TRY_DEFAULT", "()I", "TAG", "", "TIMER_CHECK_TIME", "getTIMER_CHECK_TIME", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(7467);
        AppMethodBeat.o(7467);
    }

    private final void setDataSourceWithCustomKey(String str) {
        AppMethodBeat.i(196019);
        if (getAbTestVideoPreload()) {
            String aaV = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(str);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = this.pNi;
            if (fVar == null) {
                kotlin.g.b.p.hyc();
            }
            fVar.dV(str, aaV);
            AppMethodBeat.o(196019);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = this.pNi;
        if (fVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        fVar2.setDataSource(str);
        AppMethodBeat.o(196019);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final b pNC = new b();

        static {
            AppMethodBeat.i(196008);
            AppMethodBeat.o(196008);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(196007);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if ((bVar == null || bVar.a(b.a.clicfg_open_timeline_video_preload, 0) != 1) && !BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG && !WeChatEnvironment.hasDebugger()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(196007);
            return valueOf;
        }
    }

    public static final /* synthetic */ void m(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7470);
        Log.d(TAG, "resetResolutionStatus");
        mPExoVideoWrapper.pNv = false;
        mPExoVideoWrapper.pNu = false;
        TextView textView = mPExoVideoWrapper.pNe;
        if (!(textView == null || textView.getVisibility() == 8)) {
            textView.setVisibility(8);
        }
        ImageView imageView = mPExoVideoWrapper.pNd;
        if (imageView != null) {
            if (imageView.getVisibility() != 8) {
                imageView.setVisibility(8);
            }
            AppMethodBeat.o(7470);
            return;
        }
        AppMethodBeat.o(7470);
    }

    public static final /* synthetic */ void n(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7471);
        mPExoVideoWrapper.pNv = false;
        ImageView imageView = mPExoVideoWrapper.pNd;
        if (imageView != null) {
            if (imageView.getVisibility() == 0) {
                mPExoVideoWrapper.hAk.post(new s(mPExoVideoWrapper));
            }
            AppMethodBeat.o(7471);
            return;
        }
        AppMethodBeat.o(7471);
    }

    public static final /* synthetic */ boolean a(MPExoVideoWrapper mPExoVideoWrapper, int i2, int i3) {
        boolean z2;
        AppMethodBeat.i(7473);
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerInfo, mp released");
        } else {
            Log.i(TAG, "onInfo, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 701) {
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = mPExoVideoWrapper.pNi;
                if (fVar != null) {
                    mPExoVideoWrapper.cJf = fVar.isPlaying();
                }
                Log.i(TAG, "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(mPExoVideoWrapper.cJf));
                mPExoVideoWrapper.BT(500);
            } else if (i2 == 702) {
                if (mPExoVideoWrapper.pNi != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = mPExoVideoWrapper.pNi;
                    if (fVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    z2 = fVar2.isPlaying();
                } else {
                    z2 = false;
                }
                Log.i(TAG, "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", Boolean.valueOf(mPExoVideoWrapper.cJf), Boolean.valueOf(z2));
                if (mPExoVideoWrapper.cJf) {
                    mPExoVideoWrapper.cJf = false;
                    if (z2) {
                        Log.i(TAG, "onInfo, buffering end, notify video play");
                        mPExoVideoWrapper.onVideoPlay();
                    }
                } else if (!z2) {
                    Log.i(TAG, "onInfo, buffering end, notify video pause");
                    mPExoVideoWrapper.onVideoPause();
                }
                mPExoVideoWrapper.hideLoading();
            } else if (i3 == -1004) {
                Log.i(TAG, "onInfo, special error, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                mPExoVideoWrapper.onError(i2, i3);
            }
        }
        AppMethodBeat.o(7473);
        return false;
    }

    public static final /* synthetic */ void r(MPExoVideoWrapper mPExoVideoWrapper) {
        ff aiR;
        AppMethodBeat.i(7475);
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerPrepared, mp released");
            AppMethodBeat.o(7475);
            return;
        }
        if (mPExoVideoWrapper.bFM > 0) {
            Log.d(TAG, "start error check timer");
            mPExoVideoWrapper.mER.startTimer((long) mPExoVideoWrapper.pMZ);
        }
        Log.i(TAG, "onPrepared");
        mPExoVideoWrapper.cJj = true;
        mPExoVideoWrapper.crw();
        mPExoVideoWrapper.setVideoTotalTime(mPExoVideoWrapper.getVideoDurationSec());
        mPExoVideoWrapper.hideLoading();
        if (mPExoVideoWrapper.pNs != 0) {
            Log.i(TAG, "onPrepared, costTime:%s", Long.valueOf(System.currentTimeMillis() - mPExoVideoWrapper.pNs));
        }
        j.a bizVideoProfiler = mPExoVideoWrapper.getBizVideoProfiler();
        if (!(bizVideoProfiler == null || (aiR = bizVideoProfiler.aiR("14")) == null)) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j jVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(aiR, mPExoVideoWrapper.getBizVideoProfiler());
        }
        int i2 = mPExoVideoWrapper.pNn;
        if (i2 > 0) {
            Log.i(TAG, "onPrepared, seekToPosition ".concat(String.valueOf(i2)));
            mPExoVideoWrapper.ac(i2, mPExoVideoWrapper.pNr);
            mPExoVideoWrapper.pNn = 0;
        }
        if (mPExoVideoWrapper.pNo) {
            Log.i(TAG, "onPrepared, stop video auto play when webview in background");
            mPExoVideoWrapper.pNm = mPExoVideoWrapper.cJi;
            AppMethodBeat.o(7475);
        } else if (mPExoVideoWrapper.cJi) {
            Log.i(TAG, "onPrepared, start play when prepared");
            mPExoVideoWrapper.start();
            AppMethodBeat.o(7475);
        } else {
            Log.i(TAG, "onPrepared, not set start play when prepared");
            AppMethodBeat.o(7475);
        }
    }

    public static final /* synthetic */ void t(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7476);
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerCompletion, mp released");
            AppMethodBeat.o(7476);
            return;
        }
        Log.i(TAG, "onCompletion");
        if (mPExoVideoWrapper.pNj != null) {
            i.b bVar = mPExoVideoWrapper.pNj;
            if (bVar == null) {
                kotlin.g.b.p.hyc();
            }
            bVar.dI("", "");
        }
        if (mPExoVideoWrapper.cJl) {
            Log.i(TAG, "onCompletion, video loop playing");
            mPExoVideoWrapper.cJd = true;
            mPExoVideoWrapper.ac(0, true);
            AppMethodBeat.o(7476);
            return;
        }
        Log.i(TAG, "onCompletion, video end playing");
        mPExoVideoWrapper.pNp = false;
        mPExoVideoWrapper.cJr = true;
        mPExoVideoWrapper.hP(false);
        mPExoVideoWrapper.stopTimer();
        mPExoVideoWrapper.ac(0, false);
        AppMethodBeat.o(7476);
    }

    public static final /* synthetic */ void u(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7477);
        mPExoVideoWrapper.hAk.post(new r(mPExoVideoWrapper));
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerSeekComplete, mp released");
            AppMethodBeat.o(7477);
            return;
        }
        Log.i(TAG, "onSeekComplete");
        mPExoVideoWrapper.hideLoading();
        mPExoVideoWrapper.hP(mPExoVideoWrapper.cJd || mPExoVideoWrapper.cJe);
        mPExoVideoWrapper.xI(mPExoVideoWrapper.getCurrPosSec());
        if (mPExoVideoWrapper.cJd) {
            Log.i(TAG, "onSeekComplete, start when seek complete");
            mPExoVideoWrapper.cJd = false;
            mPExoVideoWrapper.startTimer();
            mPExoVideoWrapper.start();
            AppMethodBeat.o(7477);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar = mPExoVideoWrapper.pNi;
        if (fVar == null) {
            kotlin.g.b.p.hyc();
        }
        boolean isPlaying = fVar.isPlaying();
        if (mPExoVideoWrapper.cJe) {
            String str = TAG;
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(isPlaying);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar2 = mPExoVideoWrapper.pNi;
            if (fVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            objArr[1] = Integer.valueOf(fVar2.getCurrentPosition());
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar3 = mPExoVideoWrapper.pNi;
            if (fVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            objArr[2] = Integer.valueOf(fVar3.getDuration());
            Log.i(str, "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", objArr);
            mPExoVideoWrapper.cJe = false;
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar4 = mPExoVideoWrapper.pNi;
            if (fVar4 == null) {
                kotlin.g.b.p.hyc();
            }
            int currentPosition = fVar4.getCurrentPosition() / 1000;
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar5 = mPExoVideoWrapper.pNi;
            if (fVar5 == null) {
                kotlin.g.b.p.hyc();
            }
            if (currentPosition < fVar5.getDuration() / 1000) {
                Log.i(TAG, "onSeekComplete, video not end");
                if (isPlaying) {
                    Log.i(TAG, "onSeekComplete, dispatch play again");
                    mPExoVideoWrapper.onVideoPlay();
                    AppMethodBeat.o(7477);
                    return;
                }
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar6 = mPExoVideoWrapper.pNi;
                if (fVar6 == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar6.start();
                AppMethodBeat.o(7477);
                return;
            }
            Log.i(TAG, "onSeekComplete, video ends");
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar7 = mPExoVideoWrapper.pNi;
            if (fVar7 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar7.pause();
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f fVar8 = mPExoVideoWrapper.pNi;
            if (fVar8 == null) {
                kotlin.g.b.p.hyc();
            }
            fVar8.start();
            AppMethodBeat.o(7477);
            return;
        }
        Log.i(TAG, "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
        if (!isPlaying) {
            Log.i(TAG, "onSeekComplete, dispatch pause again");
            mPExoVideoWrapper.onVideoPause();
        }
        AppMethodBeat.o(7477);
    }

    public static final /* synthetic */ void c(MPExoVideoWrapper mPExoVideoWrapper, int i2, int i3) {
        AppMethodBeat.i(7478);
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerVideoSizeChanged, mp released");
            AppMethodBeat.o(7478);
            return;
        }
        Log.i(TAG, "onVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        int videoDurationSec = mPExoVideoWrapper.getVideoDurationSec();
        i.b bVar = mPExoVideoWrapper.pNj;
        if (bVar != null) {
            bVar.d("", "", i2, i3);
        }
        mPExoVideoWrapper.mVideoWidth = i2;
        mPExoVideoWrapper.mVideoHeight = i3;
        mPExoVideoWrapper.cJn = videoDurationSec;
        mPExoVideoWrapper.crw();
        AppMethodBeat.o(7478);
    }

    public static final /* synthetic */ void b(MPExoVideoWrapper mPExoVideoWrapper, int i2) {
        AppMethodBeat.i(7479);
        if (!mPExoVideoWrapper.cJk) {
            Log.i(TAG, "onMediaPlayerBufferingUpdate, mp released");
            AppMethodBeat.o(7479);
            return;
        }
        if (i2 != mPExoVideoWrapper.cJo) {
            mPExoVideoWrapper.cJo = i2;
            Log.i(TAG, "onBufferingUpdate, percent:%s", Integer.valueOf(i2));
        }
        if (mPExoVideoWrapper.cJj) {
            mPExoVideoWrapper.mEd = i2;
        }
        AppMethodBeat.o(7479);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void v(com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper r9) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.v(com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper):void");
    }

    public static final /* synthetic */ void A(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7483);
        if (mPExoVideoWrapper.pNi != null) {
            if (mPExoVideoWrapper.cJj) {
                int currPosMs = mPExoVideoWrapper.getCurrPosMs();
                Log.i(TAG, "retry when error, video has prepared currentPosition=" + currPosMs + " isPlaying:" + mPExoVideoWrapper.isPlaying());
                mPExoVideoWrapper.pause();
                mPExoVideoWrapper.cJd = true;
                mPExoVideoWrapper.ac(currPosMs, true);
                AppMethodBeat.o(7483);
                return;
            }
            Log.i(TAG, "retry when error, video has not prepared");
            mPExoVideoWrapper.prepareAsync();
        }
        AppMethodBeat.o(7483);
    }

    public static final /* synthetic */ void B(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(196021);
        if (mPExoVideoWrapper.pNv) {
            mPExoVideoWrapper.hAk.postDelayed(new q(mPExoVideoWrapper), 3000);
        }
        AppMethodBeat.o(196021);
    }

    public static final /* synthetic */ void D(MPExoVideoWrapper mPExoVideoWrapper) {
        AppMethodBeat.i(7484);
        Log.i(TAG, "reset error count ");
        mPExoVideoWrapper.bFM = 0;
        AppMethodBeat.o(7484);
    }
}
