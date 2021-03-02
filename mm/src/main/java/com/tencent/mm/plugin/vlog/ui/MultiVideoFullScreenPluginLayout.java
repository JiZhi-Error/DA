package com.tencent.mm.plugin.vlog.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.plugin.ab;
import com.tencent.mm.plugin.vlog.ui.plugin.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.ae;
import com.tencent.mm.plugin.vlog.ui.plugin.af;
import com.tencent.mm.plugin.vlog.ui.plugin.ah;
import com.tencent.mm.plugin.vlog.ui.plugin.ai;
import com.tencent.mm.plugin.vlog.ui.plugin.aj;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.plugin.q;
import com.tencent.mm.plugin.vlog.ui.plugin.r;
import com.tencent.mm.plugin.vlog.ui.plugin.s;
import com.tencent.mm.plugin.vlog.ui.plugin.t;
import com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer;
import com.tencent.mm.plugin.vlog.ui.plugin.x;
import com.tencent.mm.plugin.vlog.ui.plugin.y;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Å\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001w\b\u0016\u0018\u0000 Ô\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Ô\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJP\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010#29\u0010\u0001\u001a4\u0012\u0004\u0012\u00020+\u0012\u0007\u0012\u0005\u0018\u00010\u0001\u0012\u0019\u0012\u0017\u0018\u00010\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u00030\u00010\u0001H\u0002Js\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010#0\u00012\u0017\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0Xj\b\u0012\u0004\u0012\u00020#`Z2\u0019\u0010\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00010Xj\t\u0012\u0005\u0012\u00030\u0001`Z2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020-H\u0002¢\u0006\u0003\u0010¡\u0001J\n\u0010¢\u0001\u001a\u00030\u0001H\u0002J\u001a\u0010£\u0001\u001a\u00030\u00012\u0006\u0010d\u001a\u00020e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010¤\u0001\u001a\u00030\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010¦\u0001\u001a\u00030\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010¨\u0001\u001a\u00030\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u0001H\u0002J(\u0010ª\u0001\u001a\u00030\u00012\u0007\u0010«\u0001\u001a\u00020-2\u0007\u0010¬\u0001\u001a\u00020-2\n\u0010­\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J\t\u0010¯\u0001\u001a\u00020+H\u0016J\n\u0010°\u0001\u001a\u00030\u0001H\u0016J\n\u0010±\u0001\u001a\u00030\u0001H\u0002J)\u0010²\u0001\u001a\u00030\u00012\u0007\u0010³\u0001\u001a\u00020+2\t\b\u0002\u0010´\u0001\u001a\u00020+2\t\b\u0002\u0010µ\u0001\u001a\u00020VH\u0002J\n\u0010¶\u0001\u001a\u00030\u0001H\u0016J\n\u0010·\u0001\u001a\u00030\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¹\u0001\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020VH\u0002J\u0013\u0010»\u0001\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020VH\u0002J\u0013\u0010¼\u0001\u001a\u00030\u00012\u0007\u0010½\u0001\u001a\u00020+H\u0002J\n\u0010¾\u0001\u001a\u00030\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030\u0001H\u0002J+\u0010À\u0001\u001a\u00030\u00012\t\b\u0002\u0010Á\u0001\u001a\u00020+2\t\b\u0002\u0010´\u0001\u001a\u00020+2\t\b\u0002\u0010µ\u0001\u001a\u00020VH\u0002J\u0015\u0010Â\u0001\u001a\u00030\u00012\t\b\u0002\u0010Ã\u0001\u001a\u00020+H\u0016J\n\u0010Ä\u0001\u001a\u00030Å\u0001H\u0002J\n\u0010Æ\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010Ç\u0001\u001a\u00030\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u0001H\u0002J \u0010Ï\u0001\u001a\u00030\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010W\u001a\u0012\u0012\u0004\u0012\u00020Y0Xj\b\u0012\u0004\u0012\u00020Y`ZX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010^\u001a\u00020_X.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0010\u0010d\u001a\u0004\u0018\u00010eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX.¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020wX\u0004¢\u0006\u0004\n\u0002\u0010xR\u000e\u0010y\u001a\u00020zX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020~X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Õ\u0001"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bottomFuncFullscreenViewStub", "Landroid/view/ViewStub;", "bottomFuncViewStub", "bottomView", "Landroid/view/View;", "calculatePlugin", "Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "captionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "compositionEditPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropVideoPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "currentPath", "", "currentStyle", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "getCurrentStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setCurrentStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "disableImageAddMusic", "", "editBackgroundColor", "", "editCropPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin;", "editId", "editMagicPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin;", "editMenuPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "editReport19904", "Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "editStatus", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditStatus;", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "edited", "enableEditTime", "footRecyclerViewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "hasInit", "headView", "imageAddMusicPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin;", "imageCompressQuality", "imageMaxHeight", "imageMaxWidth", "imageOutputDir", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "isFollowMusic", "isInImageEdit", "isInTemplateEdit", "isInVideoEdit", "isMediaMute", "isVideoEnhancementEnable", "isVideoPause", "lastMusicPosition", "maxCropVideoDurationMs", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "mediaSourceFrom", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiPreviewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "getMultiPreviewPlugin", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "setMultiPreviewPlugin", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;)V", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "normalModeContainer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/NormalModeContainerPlugin;", "pagEditTextPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PagEditTextPlugin;", "pagItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "photoEditItemContainer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "playRatePlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin;", ShareConstants.RESULT_POST_ID, "postPreviewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin;", "readPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "rootLayout", "sortCallback", "com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$sortCallback$1;", "templateModeContainer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer;", "templateNormalModeSelectPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "thumbLoadingPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/ThumbLoadingPlugin;", "vLogMode", "vLogThumbPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "vLogTimeEditPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "vLogTrackEditPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "videoEditItemContainer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/MultiEditItemContainerPlugin;", "videoEnhancementPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin;", "videoPlayStatusPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "exportVideo", "", "musicPath", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "thumb", "generateCropImage", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "resultImage", "", "halfImageList", "halfRectList", "Landroid/graphics/Rect;", "outputModel", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", FirebaseAnalytics.b.INDEX, "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;[Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;I)V", "hideOperation", "initLogic", "initSafeArea", "lazyInit", "loadCurrentPage", "model", "loadMediaList", "loadRes", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onDetach", "pauseVideo", "recreateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "release", "reportEdit19904", "reportEdit20741Cancel", "reportEdit20741Image", NativeProtocol.WEB_DIALOG_ACTION, "reportEdit20741Video", "reportPreview21640", "isPreviewHalf", "reset", "resumeCurrentEditTrack", "resumeVideo", "recreate", "setupImageEditPlugins", "selectFirst", "setupMediaData", "Lkotlinx/coroutines/Job;", "setupNormalVideoPlugins", "setupTemplateVideoPlugins", MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "showImageEditPlugins", "showOperation", "showTemplateEditPlugins", "showVideoEditPlugins", "startMux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public class MultiVideoFullScreenPluginLayout extends BasePluginLayout implements com.tencent.mm.plugin.recordvideo.plugin.parent.d, e.b {
    public static final a GEI = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    private com.tencent.mm.plugin.recordvideo.plugin.a BTN;
    private com.tencent.mm.plugin.recordvideo.plugin.c BTQ;
    private final com.tencent.mm.plugin.recordvideo.plugin.e BTW;
    private final com.tencent.mm.plugin.recordvideo.plugin.g BUb;
    private boolean FHg;
    private View GDE;
    private long GDF = Util.MILLSECONDS_OF_MINUTE;
    private int GDG = 1080;
    private int GDH = 1080;
    private int GDI = 90;
    private String GDJ = "";
    private final com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a GDK;
    private final t GDL;
    private af GDM;
    private a GDN;
    private com.tencent.mm.plugin.vlog.ui.plugin.caption.b GDO;
    private com.tencent.mm.plugin.vlog.ui.plugin.n GDP;
    private final ad GDQ;
    private final com.tencent.mm.plugin.vlog.ui.plugin.read.a GDR;
    private boolean GDS = true;
    private v GDT = new v();
    private boolean GDU;
    private boolean GDV;
    protected com.tencent.mm.plugin.vlog.ui.plugin.e GDW;
    private com.tencent.mm.plugin.vlog.ui.plugin.c GDX;
    private r GDY;
    private ah GDZ;
    private boolean GEA;
    private boolean GEB;
    private int GEC;
    private b GED = b.GLOBAL_EDIT;
    private final int GEE = Color.parseColor("#232323");
    private boolean GEF;
    private final k GEG = new k(this);
    private com.tencent.mm.emoji.panel.a.n GEH;
    private final ai GEa;
    private final com.tencent.mm.plugin.vlog.ui.plugin.a GEb;
    private final com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a GEc;
    private com.tencent.mm.plugin.recordvideo.e.f GEd = new com.tencent.mm.plugin.recordvideo.e.f();
    private com.tencent.mm.plugin.vlog.ui.plugin.m GEe;
    private com.tencent.mm.plugin.vlog.ui.plugin.o GEf;
    private final q GEg;
    private final ae GEh;
    private final com.tencent.mm.plugin.vlog.ui.plugin.transition.a GEi;
    private final y GEj;
    private final ac GEk;
    private final ab GEl;
    private final x GEm;
    private final aj GEn;
    private final com.tencent.mm.plugin.vlog.ui.plugin.v GEo;
    private final com.tencent.mm.plugin.vlog.ui.plugin.d GEp;
    private final s GEq;
    private View GEr;
    private final ViewStub GEs;
    private final ViewStub GEt;
    private boolean GEu;
    private boolean GEv;
    private boolean GEw;
    private boolean GEx;
    private WxCropOperationLayout.j GEy = WxCropOperationLayout.j.RECT_ADJUST;
    private com.tencent.mm.plugin.recordvideo.d.b GEz = new com.tencent.mm.plugin.recordvideo.d.b();
    private String editId = "";
    private boolean hasInit;
    private String msl = "";
    private String postId = "";
    private ArrayList<GalleryItem.MediaItem> tGk = new ArrayList<>();
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;
    private final View zyV;

    static {
        AppMethodBeat.i(191021);
        AppMethodBeat.o(191021);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "ret", "", "path", "", "edited", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.q<Boolean, String, Boolean, kotlin.x> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        final /* synthetic */ z.f GEX;
        final /* synthetic */ b.e GEY;
        final /* synthetic */ String[] GEZ;
        final /* synthetic */ ArrayList GFa;
        final /* synthetic */ ArrayList GFb;
        final /* synthetic */ CaptureDataManager.CaptureVideoNormalModel GFc;
        final /* synthetic */ int puW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, z.f fVar, int i2, b.e eVar, String[] strArr, ArrayList arrayList, ArrayList arrayList2, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
            super(3);
            this.GEJ = multiVideoFullScreenPluginLayout;
            this.GEX = fVar;
            this.puW = i2;
            this.GEY = eVar;
            this.GEZ = strArr;
            this.GFa = arrayList;
            this.GFb = arrayList2;
            this.GFc = captureVideoNormalModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(Boolean bool, String str, Boolean bool2) {
            String str2;
            AppMethodBeat.i(190953);
            boolean booleanValue = bool.booleanValue();
            String str3 = str;
            boolean booleanValue2 = bool2.booleanValue();
            Log.i("MicroMsg.MultiVideoPluginLayout", "photoEditItemContainer source:" + ((String) this.GEX.SYG) + " ret:" + booleanValue + " result:" + str3 + " index:" + this.puW + ' ');
            if (booleanValue && str3 != null) {
                com.tencent.mm.plugin.vlog.ui.plugin.e multiPreviewPlugin = this.GEJ.getMultiPreviewPlugin();
                String str4 = this.GEJ.GDT.Gyv.get(this.puW);
                p.g(str4, "multiMedia.pathList[index]");
                com.tencent.mm.plugin.vlog.model.j aUk = multiPreviewPlugin.aUk(str4);
                Rect rect = new Rect();
                this.GEJ.getMultiPreviewPlugin().GyG.round(rect);
                Rect rect2 = new Rect(aUk.rwL);
                rect2.offset(0, rect.top);
                b.f a2 = this.GEY.a(str3, new Matrix(aUk.gT), new Rect(rect), rect2, new Rect(aUk.viewRect));
                Bitmap bitmapNative = BitmapUtil.getBitmapNative(a2.xli);
                com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a aVar = this.GEJ.GDK;
                String str5 = this.GEJ.GDT.Gyv.get(this.puW);
                p.g(str5, "multiMedia.pathList[index]");
                Bitmap fT = aVar.fT(str5, com.tencent.mm.cb.a.jn(this.GEJ.getContext()));
                if (fT != null) {
                    bitmapNative = BitmapUtil.blendBitmap(bitmapNative, fT, this.GEJ.getMultiPreviewPlugin().GyG);
                }
                com.tencent.mm.plugin.vlog.util.a aVar2 = com.tencent.mm.plugin.vlog.util.a.GQC;
                int i2 = this.GEJ.GDI;
                p.g(bitmapNative, "blendBitmap");
                com.tencent.mm.plugin.vlog.util.a.a(i2, bitmapNative, a2.xli);
                com.tencent.mm.plugin.vlog.util.a aVar3 = com.tencent.mm.plugin.vlog.util.a.GQC;
                com.tencent.mm.plugin.vlog.util.a.lm(str3, a2.xli);
                this.GEZ[this.puW] = com.tencent.mm.vfs.s.k(a2.xli, false);
                if (booleanValue2 || fT != null) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.aLK(a2.xli);
                }
                com.tencent.mm.plugin.vlog.ui.plugin.e multiPreviewPlugin2 = this.GEJ.getMultiPreviewPlugin();
                Rect rect3 = new Rect();
                multiPreviewPlugin2.GHe.getVisibilityRect().round(rect3);
                rect3.offset(-rect.left, -rect.top);
                float width = ((float) bitmapNative.getWidth()) / ((float) rect.width());
                float height = ((float) bitmapNative.getHeight()) / ((float) rect.height());
                Rect rect4 = new Rect((int) (((float) rect3.left) * width), (int) (((float) rect3.top) * height), (int) (width * ((float) rect3.right)), (int) (((float) rect3.bottom) * height));
                Bitmap cropBitmap = BitmapUtil.cropBitmap(bitmapNative, rect4.left, rect4.top, rect4.width(), rect4.height(), true);
                String str6 = a2.xli + "_half";
                if (cropBitmap != null) {
                    com.tencent.mm.plugin.vlog.util.a aVar4 = com.tencent.mm.plugin.vlog.util.a.GQC;
                    com.tencent.mm.plugin.vlog.util.a.a(this.GEJ.GDI, cropBitmap, str6);
                    com.tencent.mm.plugin.vlog.util.a aVar5 = com.tencent.mm.plugin.vlog.util.a.GQC;
                    com.tencent.mm.plugin.vlog.util.a.lm(str3, str6);
                    ArrayList arrayList = this.GFa;
                    String k = com.tencent.mm.vfs.s.k(str6, false);
                    if (k == null) {
                        k = "";
                    }
                    arrayList.add(k);
                    this.GFb.add(rect4);
                    if (this.GEJ.GEq.GHR) {
                        this.GEZ[this.puW] = (String) this.GFa.get(this.puW);
                        ((Rect) this.GFb.get(this.puW)).set(0, 0, cropBitmap.getWidth(), cropBitmap.getHeight());
                    }
                }
            }
            if (this.puW >= this.GEJ.GDT.Gyv.size() - 1) {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.GEJ.BQt;
                if (bVar != null && bVar.iqf) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.GEJ.BQt;
                    if (bVar2 != null) {
                        str2 = bVar2.iql;
                    } else {
                        str2 = null;
                    }
                    com.tencent.mm.plugin.recordvideo.e.c.aHD(str2);
                }
                this.GFc.gf(kotlin.a.e.W(this.GEZ));
                CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                p.g(captureDataManager, "CaptureDataManager.INSTANCE");
                captureDataManager.getExtData().putStringArrayList("KEY_POST_HALF_IMAGE_LIST", this.GFa);
                CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
                captureDataManager2.getExtData().putParcelableArrayList("KEY_POST_HALF_RECT_LIST", this.GFb);
                CaptureDataManager.BOb.a(this.GEJ.getContext(), this.GFc);
            } else {
                ArtistCacheManager.alA().Do(this.GEX.SYG);
                MultiVideoFullScreenPluginLayout.a(this.GEJ, this.GEY, this.GEZ, this.GFa, this.GFb, this.GFc, this.puW + 1);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(190953);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, String, kotlin.x> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        final /* synthetic */ kotlin.g.a.q GFm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, kotlin.g.a.q qVar) {
            super(2);
            this.GEJ = multiVideoFullScreenPluginLayout;
            this.GFm = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, String str) {
            AppMethodBeat.i(190981);
            String str2 = str;
            if (!bool.booleanValue()) {
                Log.e("MicroMsg.MultiVideoPluginLayout", "download music failed");
            } else {
                Log.i("MicroMsg.MultiVideoPluginLayout", "download music success, ".concat(String.valueOf(str2)));
                MultiVideoFullScreenPluginLayout.a(this.GEJ, str2, this.GFm);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(190981);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "success", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "thumb", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.q<Boolean, acn, Bitmap, kotlin.x> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        final /* synthetic */ String GEM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, String str) {
            super(3);
            this.GEJ = multiVideoFullScreenPluginLayout;
            this.GEM = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(Boolean bool, acn acn, Bitmap bitmap) {
            int i2;
            boolean z = false;
            AppMethodBeat.i(190983);
            boolean booleanValue = bool.booleanValue();
            acn acn2 = acn;
            Bitmap bitmap2 = bitmap;
            this.GEJ.GDQ.hideLoading();
            MultiVideoFullScreenPluginLayout.E(this.GEJ);
            if (booleanValue) {
                if (acn2 == null) {
                    SightVideoJNI.optimizeMP4VFS(this.GEM);
                    String str = this.GEM + "_thumb";
                    com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    String str2 = this.GEM;
                    p.g(str2, "outPath");
                    com.tencent.mm.plugin.recordvideo.e.c.jG(str2, str);
                    com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                    String str3 = this.GEM;
                    p.g(str3, "outPath");
                    d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(str3);
                    Log.i("MicroMsg.MultiVideoPluginLayout", "vlog video output path:" + this.GEM + " info:" + aLQ);
                    Boolean valueOf = Boolean.valueOf(booleanValue);
                    String str4 = this.GEM;
                    if (aLQ != null) {
                        i2 = aLQ.duration;
                    } else {
                        i2 = 0;
                    }
                    Long valueOf2 = Long.valueOf((long) i2);
                    Boolean bool2 = Boolean.FALSE;
                    com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    CaptureDataManager.BOb.a(this.GEJ.getContext(), new CaptureDataManager.CaptureVideoNormalModel(valueOf, str4, str, valueOf2, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
                    com.tencent.mm.plugin.recordvideo.e.c cVar3 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.c(this.GEJ.BQt);
                    if (this.GEJ.GEB) {
                        com.tencent.mm.plugin.recordvideo.e.c cVar4 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                        com.tencent.mm.plugin.recordvideo.e.c.aLJ(this.GEM);
                    }
                } else {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    RecordConfigProvider recordConfigProvider = this.GEJ.wdm;
                    if (recordConfigProvider == null) {
                        p.hyc();
                    }
                    BitmapUtil.saveBitmapToImage(bitmap2, 60, compressFormat, recordConfigProvider.thumbPath, true);
                    Boolean bool3 = Boolean.TRUE;
                    RecordConfigProvider recordConfigProvider2 = this.GEJ.wdm;
                    if (recordConfigProvider2 == null) {
                        p.hyc();
                    }
                    String str5 = recordConfigProvider2.thumbPath;
                    Boolean bool4 = Boolean.FALSE;
                    com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = new CaptureDataManager.CaptureVideoNormalModel(bool3, "", str5, -1L, bool4, com.tencent.mm.plugin.recordvideo.d.c.eKW());
                    acm acm = acn2.Gxx;
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.GEJ.BQt;
                    if (bVar != null) {
                        z = bVar.iqf;
                    }
                    acm.Lnb = z;
                    CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                    p.g(captureDataManager, "CaptureDataManager.INSTANCE");
                    captureDataManager.getExtData().putByteArray("video_composition", acn2.toByteArray());
                    CaptureDataManager.BOb.a(this.GEJ.getContext(), captureVideoNormalModel);
                }
                CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                captureDataManager2.d(com.tencent.mm.plugin.recordvideo.d.c.eKW());
            } else {
                Log.i("MicroMsg.MultiVideoPluginLayout", " export failed");
                MultiVideoFullScreenPluginLayout.a(this.GEJ, false, false, 0, 7);
                MultiVideoFullScreenPluginLayout.c(this.GEJ).onResume();
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.m.AnonymousClass1 */
                    final /* synthetic */ m GFn;

                    {
                        this.GFn = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(190982);
                        Toast.makeText(this.GFn.GEJ.getContext(), (int) R.string.hw_, 0).show();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(190982);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(190983);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiVideoFullScreenPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(191020);
        View findViewById = ((Activity) context).findViewById(R.id.gxr);
        p.g(findViewById, "(context as Activity).fi…oup>(R.id.record_ui_root)");
        if (((ViewGroup) findViewById).getChildCount() == 0) {
            Window window = ((Activity) context).getWindow();
            p.g(window, "context.window");
            View findViewById2 = window.getDecorView().findViewById(16908290);
            p.g(findViewById2, "context.window.decorView…up>(android.R.id.content)");
            ((ViewGroup) findViewById2).setAlpha(0.0f);
        }
        com.tencent.mm.plugin.recordvideo.res.e.BYn.bbA();
        com.tencent.mm.plugin.recordvideo.res.f.BYo.bbA();
        com.tencent.mm.plugin.recordvideo.res.g.BYp.bbA();
        com.tencent.mm.plugin.recordvideo.res.e.BYn.eLo();
        com.tencent.mm.plugin.recordvideo.res.f.BYo.eLo();
        com.tencent.mm.plugin.recordvideo.res.g.BYp.eLo();
        Log.i("MicroMsg.MultiVideoPluginLayout", "init MultiVideoPluginLayout");
        View inflate = LayoutInflater.from(context).inflate(R.layout.bcf, (ViewGroup) this, true);
        p.g(inflate, "LayoutInflater.from(cont…lugin_layout, this, true)");
        this.GDE = inflate;
        View findViewById3 = this.GDE.findViewById(R.id.fo3);
        p.g(findViewById3, "rootLayout.findViewById(…_edit_bottom_func_layout)");
        this.GEs = (ViewStub) findViewById3;
        View findViewById4 = this.GDE.findViewById(R.id.fo2);
        p.g(findViewById4, "rootLayout.findViewById(…m_func_fullscreen_layout)");
        this.GEt = (ViewStub) findViewById4;
        ((Activity) context).getWindow().setSoftInputMode(48);
        com.tencent.mm.plugin.vlog.model.local.a.GAD.init();
        View findViewById5 = findViewById(R.id.fne);
        p.g(findViewById5, "findViewById(R.id.multi_crop_layout)");
        View findViewById6 = findViewById(R.id.big);
        p.g(findViewById6, "findViewById(R.id.crop_ope_layout)");
        this.GDW = new com.tencent.mm.plugin.vlog.ui.plugin.e((MultiEditCropLayout) findViewById5, (MultiEditCropOperationLayout) findViewById6, this);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.GDT = this.GDT;
        View findViewById7 = findViewById(R.id.j4q);
        p.g(findViewById7, "findViewById(R.id.video_editor_item_container)");
        this.GDK = new com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a((TimeEditorItemContainer) findViewById7, this);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
        if (eVar2 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar2.a(this.GDK.GMG);
        View findViewById8 = findViewById(R.id.gb9);
        p.g(findViewById8, "findViewById(R.id.photo_editor_item_container)");
        this.GDL = new t((FrameLayout) findViewById8, this);
        View findViewById9 = findViewById(R.id.ar2);
        p.g(findViewById9, "findViewById(R.id.change_text_root)");
        this.BUb = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView) findViewById9);
        this.BUb.BPY.setEnableClickOutsideConfirm(false);
        View findViewById10 = findViewById(R.id.bx1);
        p.g(findViewById10, "findViewById(R.id.editor_close)");
        this.BTW = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView) findViewById10, this);
        View findViewById11 = findViewById(R.id.d8p);
        p.g(findViewById11, "findViewById(R.id.footer_preview)");
        this.GDX = new com.tencent.mm.plugin.vlog.ui.plugin.c((RecyclerView) findViewById11, this);
        View findViewById12 = findViewById(R.id.ggu);
        p.g(findViewById12, "findViewById(R.id.preview_thumb)");
        this.GDQ = new ad((ImageView) findViewById12, this);
        View findViewById13 = findViewById(R.id.bxv);
        p.g(findViewById13, "findViewById(R.id.editor_tts_panel)");
        this.GDR = new com.tencent.mm.plugin.vlog.ui.plugin.read.a((ViewGroup) findViewById13, this);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
        if (eVar3 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar3.a(this.GDR);
        this.GDZ = new ah(this, this);
        this.GDZ.GJj = this.GEG;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar4 = this.GDW;
        if (eVar4 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar4.a(this.GDZ);
        this.GEb = new com.tencent.mm.plugin.vlog.ui.plugin.a(this, this);
        View findViewById14 = findViewById(R.id.bxs);
        p.g(findViewById14, "findViewById(R.id.editor_track_edit_panel)");
        this.GEa = new ai((EditorPanelHolder) findViewById14, this);
        View findViewById15 = findViewById(R.id.bxr);
        p.g(findViewById15, "findViewById(R.id.editor_time_edit_panel)");
        this.GEc = new com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a((EditorPanelHolder) findViewById15, this);
        EditorPanelHolder editorPanelHolder = new EditorPanelHolder(context);
        addView(editorPanelHolder, -1, -1);
        editorPanelHolder.setVisibility(8);
        this.GEh = new ae(editorPanelHolder, this);
        this.GEg = new q(this, this);
        this.GEi = new com.tencent.mm.plugin.vlog.ui.plugin.transition.a(this, this);
        this.GEg.a(this.GEi);
        this.GEj = new y(this, this);
        this.GEo = new com.tencent.mm.plugin.vlog.ui.plugin.v(this, this);
        this.GEo.a(this.GDK);
        this.GEo.a(this.GEb);
        this.GEk = new ac(this, this);
        this.GEl = new ab(this, this);
        this.GEm = new x(this, this);
        this.GEn = new aj(this, this, this.GDT);
        this.GEp = new com.tencent.mm.plugin.vlog.ui.plugin.d(this, this);
        this.GEq = new s(this, this);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar5 = this.GDW;
        if (eVar5 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar5.a(this.GEq);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar6 = this.GDW;
        if (eVar6 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar6.a(this.GEb);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar7 = this.GDW;
        if (eVar7 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar7.a(this.GEa);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar8 = this.GDW;
        if (eVar8 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar8.a(this.GEc);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar9 = this.GDW;
        if (eVar9 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar9.GHe.setOutsideTouckListener(new kotlin.g.a.a<kotlin.x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.AnonymousClass1 */
            final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;

            {
                this.GEJ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(190946);
                this.GEJ.GDK.fEn();
                d.b.a(this.GEJ, d.c.BWv);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(190946);
                return xVar;
            }
        });
        View findViewById16 = findViewById(R.id.fo3);
        p.g(findViewById16, "findViewById(R.id.multi_…_edit_bottom_func_layout)");
        this.GEr = findViewById16;
        View findViewById17 = findViewById(R.id.fo4);
        p.g(findViewById17, "findViewById(R.id.multi_video_edit_head)");
        this.zyV = findViewById17;
        getPluginList().add(this.GEb);
        getPluginList().add(this.GEa);
        getPluginList().add(this.GEc);
        getPluginList().add(this.GDK);
        getPluginList().add(this.GDL);
        getPluginList().add(this.BTW);
        getPluginList().add(this.GDZ);
        ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList = getPluginList();
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar10 = this.GDW;
        if (eVar10 == null) {
            p.btv("multiPreviewPlugin");
        }
        pluginList.add(eVar10);
        getPluginList().add(this.GDX);
        getPluginList().add(this.GEd);
        getPluginList().add(this.GDQ);
        getPluginList().add(this.GEh);
        getPluginList().add(this.GEj);
        getPluginList().add(this.GDR);
        getPluginList().add(this.GEk);
        getPluginList().add(this.GEl);
        getPluginList().add(this.GEm);
        getPluginList().add(this.GEn);
        getPluginList().add(this.GEo);
        getPluginList().add(this.GEq);
        com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        int displayHeight = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
        com.tencent.mm.plugin.recordvideo.model.a aVar2 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        int eJO = com.tencent.mm.plugin.recordvideo.model.a.eJO();
        float f2 = ((float) displayHeight) / ((float) eJO);
        float f3 = ((float) displayHeight) / 2.18f;
        float f4 = (((float) eJO) - f3) / 2.0f;
        float f5 = (float) displayHeight;
        float f6 = (((float) displayHeight) - f5) / 2.0f;
        Log.i("MicroMsg.MultiVideoPluginLayout", "initSafeArea, displaySize:[" + eJO + ", " + displayHeight + "], scale:" + f2 + ", safeAreaWidth:" + f3 + ", safeAreaFrameWidth:" + f4 + ", safeAreaHeight:" + f5 + ", safeAreaFrameHeight:" + f6);
        if (f2 <= 1.78f) {
            this.BUb.bL(f4);
            TimeEditorItemContainer.ac(f3, f4);
            AppMethodBeat.o(191020);
        } else if (f2 >= 2.18f) {
            this.BUb.bM(f4);
            TimeEditorItemContainer.ad(f5, f6);
            AppMethodBeat.o(191020);
        } else {
            this.BUb.bL(f4);
            this.BUb.bM(f4);
            TimeEditorItemContainer.ac(f3, f4);
            TimeEditorItemContainer.ad(f5, f6);
            AppMethodBeat.o(191020);
        }
    }

    public static final /* synthetic */ void E(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191026);
        multiVideoFullScreenPluginLayout.fCE();
        AppMethodBeat.o(191026);
    }

    public static final /* synthetic */ void I(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191029);
        multiVideoFullScreenPluginLayout.cEa();
        AppMethodBeat.o(191029);
    }

    public static final /* synthetic */ void L(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191030);
        multiVideoFullScreenPluginLayout.KZ(1);
        AppMethodBeat.o(191030);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.vlog.ui.plugin.o M(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191031);
        com.tencent.mm.plugin.vlog.ui.plugin.o oVar = multiVideoFullScreenPluginLayout.GEf;
        if (oVar == null) {
            p.btv("editMagicPlugin");
        }
        AppMethodBeat.o(191031);
        return oVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.a a(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191022);
        com.tencent.mm.plugin.recordvideo.plugin.a aVar = multiVideoFullScreenPluginLayout.BTN;
        if (aVar == null) {
            p.btv("addEmojiPlugin");
        }
        AppMethodBeat.o(191022);
        return aVar;
    }

    public static final /* synthetic */ void a(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, b.e eVar, String[] strArr, ArrayList arrayList, ArrayList arrayList2, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, int i2) {
        AppMethodBeat.i(191028);
        multiVideoFullScreenPluginLayout.a(eVar, strArr, arrayList, arrayList2, captureVideoNormalModel, i2);
        AppMethodBeat.o(191028);
    }

    public static final /* synthetic */ void a(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, String str, kotlin.g.a.q qVar) {
        AppMethodBeat.i(191027);
        multiVideoFullScreenPluginLayout.b(str, qVar);
        AppMethodBeat.o(191027);
    }

    public static final /* synthetic */ a c(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191023);
        a aVar = multiVideoFullScreenPluginLayout.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        AppMethodBeat.o(191023);
        return aVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.vlog.ui.plugin.caption.b q(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191024);
        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar = multiVideoFullScreenPluginLayout.GDO;
        if (bVar == null) {
            p.btv("captionPlugin");
        }
        AppMethodBeat.o(191024);
        return bVar;
    }

    public static final /* synthetic */ void v(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191025);
        multiVideoFullScreenPluginLayout.fCG();
        AppMethodBeat.o(191025);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$Companion;", "", "()V", "FILTER_SETTINT_REQUEST_CODE", "", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.vlog.ui.plugin.e getMultiPreviewPlugin() {
        AppMethodBeat.i(190988);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        AppMethodBeat.o(190988);
        return eVar;
    }

    /* access modifiers changed from: protected */
    public final void setMultiPreviewPlugin(com.tencent.mm.plugin.vlog.ui.plugin.e eVar) {
        AppMethodBeat.i(190989);
        p.h(eVar, "<set-?>");
        this.GDW = eVar;
        AppMethodBeat.o(190989);
    }

    /* access modifiers changed from: protected */
    public final WxCropOperationLayout.j getCurrentStyle() {
        return this.GEy;
    }

    /* access modifiers changed from: protected */
    public final void setCurrentStyle(WxCropOperationLayout.j jVar) {
        AppMethodBeat.i(190990);
        p.h(jVar, "<set-?>");
        this.GEy = jVar;
        AppMethodBeat.o(190990);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "onMove", "", "fromPosition", "", "toPosition", "onSortEnd", "plugin-vlog_release"})
    public static final class k implements ah.b {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.ah.b
        public final void fJ(int i2, int i3) {
            AppMethodBeat.i(190979);
            this.GEJ.GDT.js(i2, i3);
            AppMethodBeat.o(190979);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.ah.b
        public final void fCJ() {
            AppMethodBeat.i(190980);
            this.GEJ.GDT.fBo();
            this.GEJ.getMultiPreviewPlugin().wE(false);
            AppMethodBeat.o(190980);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$lazyInit$2", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "plugin-vlog_release"})
    public static final class f implements com.tencent.mm.emoji.panel.a.n {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // com.tencent.mm.emoji.panel.a.n
        public final void a(View view, Context context, int i2, com.tencent.mm.emoji.b.b.ac acVar) {
            com.tencent.mm.emoji.b.b.ac acVar2;
            AppMethodBeat.i(190958);
            p.h(context, "context");
            if (!(acVar instanceof com.tencent.mm.plugin.vlog.model.panel.e)) {
                acVar2 = null;
            } else {
                acVar2 = acVar;
            }
            if (((com.tencent.mm.plugin.vlog.model.panel.e) acVar2) != null) {
                Bundle bundle = new Bundle();
                bundle.putString("EDIT_PAG_STICKER_PATH", ((com.tencent.mm.plugin.vlog.model.panel.e) acVar).Cga);
                this.GEJ.a(d.c.BWG, bundle);
            }
            MultiVideoFullScreenPluginLayout.a(this.GEJ).efU();
            AppMethodBeat.o(190958);
        }

        @Override // com.tencent.mm.emoji.panel.a.n
        public final void a(View view, Context context, int i2) {
            AppMethodBeat.i(190959);
            p.h(context, "context");
            AppMethodBeat.o(190959);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(190991);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1024 && i3 == -1) {
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
            if (eVar == null) {
                p.btv("multiPreviewPlugin");
            }
            eVar.bLe();
            if (this.GDT.Gyy) {
                com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                com.tencent.mm.plugin.vlog.model.local.a.hP(this.GDT.Gyv);
                this.GDX.select(this.GDX.fCS());
            }
        }
        AppMethodBeat.o(190991);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        int i2;
        Map<String, Boolean> map;
        Boolean bool;
        int intValue;
        Integer num = null;
        AppMethodBeat.i(190992);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        Log.i("MicroMsg.MultiVideoPluginLayout", "initLogic ,configProvider:".concat(String.valueOf(recordConfigProvider)));
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        Bundle bundle = recordConfigProvider.jkf;
        if (bundle != null) {
            bundle.setClassLoader(GalleryItem.MediaItem.class.getClassLoader());
        }
        if (!this.hasInit) {
            this.hasInit = true;
            this.GEr = this.GEt;
            this.GEt.setVisibility(0);
            View findViewById = findViewById(R.id.bxh);
            p.g(findViewById, "findViewById(R.id.editor_mix_fullscreen)");
            this.GDP = new com.tencent.mm.plugin.vlog.ui.plugin.n(findViewById, this);
            View findViewById2 = findViewById(R.id.bxg);
            p.g(findViewById2, "findViewById<View>(R.id.editor_mix)");
            findViewById2.setVisibility(8);
            View findViewById3 = findViewById(R.id.bvy);
            p.g(findViewById3, LocaleUtil.ITALIAN);
            ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(190992);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 68);
            findViewById3.setLayoutParams(marginLayoutParams);
            findViewById(R.id.g0h).requestLayout();
            this.GEq.wF(true);
            View findViewById4 = findViewById(R.id.bwl);
            p.g(findViewById4, "findViewById(R.id.editor_add_emoji)");
            this.BTN = new com.tencent.mm.plugin.recordvideo.plugin.a(this, (ImageView) findViewById4, this);
            if (w.fBr()) {
                View findViewById5 = findViewById(R.id.bx3);
                p.g(findViewById5, "findViewById<LinearLayou…tor_control_icons_layout)");
                ((LinearLayout) findViewById5).setWeightSum(6.0f);
                com.tencent.mm.plugin.recordvideo.plugin.a aVar2 = this.BTN;
                if (aVar2 == null) {
                    p.btv("addEmojiPlugin");
                }
                aVar2.a(new com.tencent.mm.plugin.vlog.model.panel.a());
            }
            this.GEH = new f(this);
            com.tencent.mm.emoji.b.b.q qVar = com.tencent.mm.emoji.b.b.q.gYK;
            com.tencent.mm.emoji.panel.a.n nVar = this.GEH;
            if (nVar == null) {
                p.btv("pagItemClickListener");
            }
            com.tencent.mm.emoji.b.b.q.a(new com.tencent.mm.plugin.vlog.model.panel.h(nVar));
            com.tencent.mm.emoji.b.b.q qVar2 = com.tencent.mm.emoji.b.b.q.gYK;
            com.tencent.mm.emoji.b.b.q.a(new com.tencent.mm.plugin.vlog.model.panel.d());
            this.BTQ = new com.tencent.mm.plugin.recordvideo.plugin.c(this, this, this.BUb.BPY);
            this.GDY = new r(this, this);
            this.GDN = new a(this, this);
            a aVar3 = this.GDN;
            if (aVar3 == null) {
                p.btv("addMusicPlugin");
            }
            aVar3.fCx();
            a aVar4 = this.GDN;
            if (aVar4 == null) {
                p.btv("addMusicPlugin");
            }
            aVar4.wgJ.add(this.GEp);
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
            if (eVar == null) {
                p.btv("multiPreviewPlugin");
            }
            a aVar5 = this.GDN;
            if (aVar5 == null) {
                p.btv("addMusicPlugin");
            }
            eVar.a(aVar5);
            this.GEe = new com.tencent.mm.plugin.vlog.ui.plugin.m(this, this);
            this.GDM = new af(this, this);
            View findViewById6 = findViewById(R.id.bwj);
            p.g(findViewById6, "findViewById(R.id.editor_add_caption_group)");
            View findViewById7 = findViewById(R.id.bx0);
            p.g(findViewById7, "findViewById(R.id.editor_caption_preview_panel)");
            View findViewById8 = findViewById(R.id.bwz);
            p.g(findViewById8, "findViewById(R.id.editor_caption_edit_panel)");
            this.GDO = new com.tencent.mm.plugin.vlog.ui.plugin.caption.b((ViewGroup) findViewById6, (EditorPanelHolder) findViewById7, (EditorPanelHolder) findViewById8, this);
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
            if (eVar2 == null) {
                p.btv("multiPreviewPlugin");
            }
            com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar = this.GDO;
            if (bVar == null) {
                p.btv("captionPlugin");
            }
            eVar2.a(bVar);
            MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout = this;
            MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout2 = this;
            v vVar = this.GDT;
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
            if (eVar3 == null) {
                p.btv("multiPreviewPlugin");
            }
            this.GEf = new com.tencent.mm.plugin.vlog.ui.plugin.o(multiVideoFullScreenPluginLayout, multiVideoFullScreenPluginLayout2, vVar, eVar3);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList = getPluginList();
            com.tencent.mm.plugin.recordvideo.plugin.a aVar6 = this.BTN;
            if (aVar6 == null) {
                p.btv("addEmojiPlugin");
            }
            pluginList.add(aVar6);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList2 = getPluginList();
            com.tencent.mm.plugin.recordvideo.plugin.c cVar = this.BTQ;
            if (cVar == null) {
                p.btv("addTextPlugin");
            }
            pluginList2.add(cVar);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList3 = getPluginList();
            r rVar = this.GDY;
            if (rVar == null) {
                p.btv("editPencilPlugin");
            }
            pluginList3.add(rVar);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList4 = getPluginList();
            a aVar7 = this.GDN;
            if (aVar7 == null) {
                p.btv("addMusicPlugin");
            }
            pluginList4.add(aVar7);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList5 = getPluginList();
            com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar2 = this.GDO;
            if (bVar2 == null) {
                p.btv("captionPlugin");
            }
            pluginList5.add(bVar2);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList6 = getPluginList();
            af afVar = this.GDM;
            if (afVar == null) {
                p.btv("cropVideoPlugin");
            }
            pluginList6.add(afVar);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList7 = getPluginList();
            com.tencent.mm.plugin.vlog.ui.plugin.m mVar = this.GEe;
            if (mVar == null) {
                p.btv("editCropPlugin");
            }
            pluginList7.add(mVar);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList8 = getPluginList();
            com.tencent.mm.plugin.vlog.ui.plugin.o oVar = this.GEf;
            if (oVar == null) {
                p.btv("editMagicPlugin");
            }
            pluginList8.add(oVar);
            ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList9 = getPluginList();
            com.tencent.mm.plugin.vlog.ui.plugin.n nVar2 = this.GDP;
            if (nVar2 == null) {
                p.btv("editFinishPlugin");
            }
            pluginList9.add(nVar2);
        }
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar4 = this.GDW;
        if (eVar4 == null) {
            p.btv("multiPreviewPlugin");
        }
        VideoTransPara videoTransPara = recordConfigProvider.BOm;
        if (videoTransPara != null) {
            i2 = videoTransPara.fps;
        } else {
            i2 = -1;
        }
        eVar4.GHa = i2;
        com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.e(recordConfigProvider);
        this.GDK.a(recordConfigProvider);
        af afVar2 = this.GDM;
        if (afVar2 == null) {
            p.btv("cropVideoPlugin");
        }
        afVar2.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.n nVar3 = this.GDP;
        if (nVar3 == null) {
            p.btv("editFinishPlugin");
        }
        UICustomParam uICustomParam = recordConfigProvider.BOn;
        Integer valueOf = uICustomParam != null ? Integer.valueOf(uICustomParam.gLM) : null;
        UICustomParam uICustomParam2 = recordConfigProvider.BOn;
        Integer valueOf2 = uICustomParam2 != null ? Integer.valueOf(uICustomParam2.gLN) : null;
        UICustomParam uICustomParam3 = recordConfigProvider.BOn;
        String str = uICustomParam3 != null ? uICustomParam3.text : null;
        UICustomParam uICustomParam4 = recordConfigProvider.BOn;
        Integer valueOf3 = uICustomParam4 != null ? Integer.valueOf(uICustomParam4.gLO) : null;
        Log.i(nVar3.TAG, str + ' ' + valueOf3);
        View view = nVar3.view;
        if (!(valueOf == null || valueOf.intValue() == 0)) {
            view.setBackgroundResource(valueOf.intValue());
        }
        if (valueOf3 != null && (intValue = valueOf3.intValue()) > 0) {
            nVar3.view.getLayoutParams().height = intValue;
        }
        if (!(valueOf2 == null || valueOf2.intValue() == 0 || !(view instanceof TextView))) {
            ((TextView) view).setTextColor(android.support.v4.content.b.n(((TextView) view).getContext(), valueOf2.intValue()));
        }
        String str2 = str;
        if (!(str2 == null || str2.length() == 0) && (view instanceof TextView)) {
            ((TextView) view).setText(str);
        }
        a aVar8 = this.GDN;
        if (aVar8 == null) {
            p.btv("addMusicPlugin");
        }
        UICustomParam uICustomParam5 = recordConfigProvider.BOn;
        Integer valueOf4 = uICustomParam5 != null ? Integer.valueOf(uICustomParam5.gLM) : null;
        UICustomParam uICustomParam6 = recordConfigProvider.BOn;
        aVar8.b(valueOf4, uICustomParam6 != null ? Integer.valueOf(uICustomParam6.gLN) : null);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar3 = this.BTQ;
        if (cVar3 == null) {
            p.btv("addTextPlugin");
        }
        UICustomParam uICustomParam7 = recordConfigProvider.BOn;
        Integer valueOf5 = uICustomParam7 != null ? Integer.valueOf(uICustomParam7.gLM) : null;
        UICustomParam uICustomParam8 = recordConfigProvider.BOn;
        if (uICustomParam8 != null) {
            num = Integer.valueOf(uICustomParam8.gLN);
        }
        cVar3.a(valueOf5, num);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar4 = this.BTQ;
        if (cVar4 == null) {
            p.btv("addTextPlugin");
        }
        cVar4.eKo();
        int n2 = com.tencent.mm.cb.a.n(getContext(), R.color.am);
        com.tencent.mm.plugin.recordvideo.plugin.a aVar9 = this.BTN;
        if (aVar9 == null) {
            p.btv("addEmojiPlugin");
        }
        aVar9.VC(n2);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar5 = this.BTQ;
        if (cVar5 == null) {
            p.btv("addTextPlugin");
        }
        cVar5.VC(n2);
        com.tencent.mm.plugin.vlog.ui.plugin.m mVar2 = this.GEe;
        if (mVar2 == null) {
            p.btv("editCropPlugin");
        }
        mVar2.VC(n2);
        a aVar10 = this.GDN;
        if (aVar10 == null) {
            p.btv("addMusicPlugin");
        }
        aVar10.VC(n2);
        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar3 = this.GDO;
        if (bVar3 == null) {
            p.btv("captionPlugin");
        }
        bVar3.VC(n2);
        r rVar2 = this.GDY;
        if (rVar2 == null) {
            p.btv("editPencilPlugin");
        }
        rVar2.VC(n2);
        this.BTW.VC(n2);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar5 = this.GDW;
        if (eVar5 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar5.GGN = new d(this);
        for (T t : getPluginList()) {
            UICustomParam uICustomParam9 = recordConfigProvider.BOn;
            t.setVisibility(!((uICustomParam9 == null || (map = uICustomParam9.gLL) == null || (bool = map.get(t.name())) == null) ? false : bool.booleanValue()) ? 0 : 8);
        }
        e eVar6 = new e(this);
        this.GDZ.GGU = eVar6;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar7 = this.GDW;
        if (eVar7 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar7.GGU = eVar6;
        ai aiVar = this.GEa;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar8 = this.GDW;
        if (eVar8 == null) {
            p.btv("multiPreviewPlugin");
        }
        aiVar.a(eVar8.GGT, eVar6);
        if (this.GDW == null) {
            p.btv("multiPreviewPlugin");
        }
        this.GDZ.GJn = false;
        AppMethodBeat.o(190992);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$initLogic$2", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-vlog_release"})
    public static final class d implements CropLayout.c {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.c
        public final void onChange() {
            AppMethodBeat.i(190954);
            RectF rectF = this.GEJ.getMultiPreviewPlugin().GyG;
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            com.tencent.mm.plugin.recordvideo.background.e.eIS().set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a aVar = this.GEJ.GDK;
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            aVar.r(com.tencent.mm.plugin.recordvideo.background.e.eIS());
            AppMethodBeat.o(190954);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$initLogic$audioSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
    public static final class e implements e.AbstractC1868e {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void Lb(long j2) {
            AppMethodBeat.i(190955);
            MultiVideoFullScreenPluginLayout.c(this.GEJ).seekTo(j2);
            AppMethodBeat.o(190955);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void pause() {
            AppMethodBeat.i(190956);
            MultiVideoFullScreenPluginLayout.c(this.GEJ).onPause();
            AppMethodBeat.o(190956);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void resume() {
            AppMethodBeat.i(190957);
            if (MultiVideoFullScreenPluginLayout.c(this.GEJ).wgG != null) {
                MultiVideoFullScreenPluginLayout.c(this.GEJ).bdZ();
            }
            AppMethodBeat.o(190957);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(190993);
        Log.i("MicroMsg.MultiVideoPluginLayout", "loadCurrentPage time:" + System.currentTimeMillis() + " model:" + bVar);
        super.a(bVar);
        this.GEd.aLR("start");
        this.BQt = bVar;
        fCA();
        kotlinx.coroutines.f.b(bn.TUK, ba.hMV(), new h(this, null), 2);
        if (bVar != null) {
            t tVar = this.GDL;
            RecordConfigProvider recordConfigProvider = this.wdm;
            if (recordConfigProvider == null) {
                p.hyc();
            }
            tVar.b(recordConfigProvider, bVar);
        }
        long nowMilliSecond = Util.nowMilliSecond();
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(nowMilliSecond));
        StringBuilder sb = new StringBuilder();
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        this.editId = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(nowMilliSecond).toString();
        this.GEz.BXx.to(this.editId);
        this.GDZ.GJi = 0;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.GGO = 0;
        AppMethodBeat.o(190993);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fCA() {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.fCA():void");
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        String str;
        String str2;
        com.tencent.mm.xeffect.effect.v vVar;
        long j2;
        com.tencent.mm.xeffect.effect.v vVar2;
        Size size;
        com.tencent.mm.xeffect.effect.v vVar3;
        Size size2;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar;
        long j3;
        long j4;
        com.tencent.mm.xeffect.effect.ad adVar;
        com.tencent.mm.xeffect.effect.ad adVar2;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
        GalleryItem.MediaItem mediaItem;
        int i2;
        long j5;
        EmojiInfo emojiInfo;
        AppMethodBeat.i(190995);
        p.h(cVar, "status");
        d.c cVar2 = d.c.BVq;
        Log.i("MicroMsg.MultiVideoPluginLayout", "statusChange " + cVar + "  param:" + bundle);
        switch (c.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (cVar == d.c.BUU) {
                    cWX();
                }
                cEa();
                AppMethodBeat.o(190995);
                return;
            case 4:
                cWX();
                cEa();
                AppMethodBeat.o(190995);
                return;
            case 5:
                if (bundle != null && !bundle.getBoolean("PARAM_VIDEO_NEED_CROP")) {
                    a aVar = this.GDN;
                    if (aVar == null) {
                        p.btv("addMusicPlugin");
                    }
                    aVar.eKP();
                }
                this.GDQ.hideLoading();
                Context context = getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(190995);
                    throw tVar;
                }
                Window window = ((Activity) context).getWindow();
                p.g(window, "(context as Activity).window");
                View findViewById = window.getDecorView().findViewById(16908290);
                p.g(findViewById, "(context as Activity).wi…up>(android.R.id.content)");
                ((ViewGroup) findViewById).setAlpha(1.0f);
                if (!this.GEa.isShowing()) {
                    fCE();
                }
                this.GEk.wI(true);
                if (!this.GEk.fDO()) {
                    aj.a(this.GEn, true);
                }
                this.GEq.fDy();
                com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
                com.tencent.mm.plugin.vlog.model.m.fBb();
                AppMethodBeat.o(190995);
                return;
            case 6:
                fCE();
                this.GDK.fEm();
                AppMethodBeat.o(190995);
                return;
            case 7:
                if (bundle == null || (emojiInfo = (EmojiInfo) bundle.getParcelable("PARAM_EDIT_EMOJI_INFO")) == null) {
                    AppMethodBeat.o(190995);
                    return;
                }
                com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a aVar2 = this.GDK;
                com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e(emojiInfo);
                eVar.Cew = this.GDS;
                kotlin.x xVar = kotlin.x.SXb;
                com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a(aVar2, eVar, this.GDT.GyN, this.msl);
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(190995);
                return;
            case 8:
                com.tencent.mm.plugin.recordvideo.plugin.c cVar3 = this.BTQ;
                if (cVar3 == null) {
                    p.btv("addTextPlugin");
                }
                cVar3.eKp();
                AppMethodBeat.o(190995);
                return;
            case 9:
                com.tencent.mm.plugin.recordvideo.plugin.a aVar3 = this.BTN;
                if (aVar3 == null) {
                    p.btv("addEmojiPlugin");
                }
                aVar3.eKm();
                AppMethodBeat.o(190995);
                return;
            case 10:
                if (bundle != null) {
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar4 = this.GDK.GMF;
                    CharSequence charSequence = bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    int i3 = bundle.getInt("PARAM_EDIT_TEXT_COLOR");
                    int i4 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                    String string = bundle.getString("PARAM_EDIT_TEXT_FONT");
                    if (string == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.q qVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(charSequence, i3, i4, string);
                    qVar.Cew = this.GDS;
                    kotlin.x xVar3 = kotlin.x.SXb;
                    com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a aVar5 = this.GDK;
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.q qVar2 = qVar;
                    com.tencent.mm.plugin.vlog.model.ad adVar3 = this.GDT.GyN;
                    String str3 = this.msl;
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
                    if (eVar2 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    aVar5.a(qVar2, adVar3, str3, eVar2.fCU().getPosition());
                    if (this.GDS) {
                        if (aVar4 == null) {
                            this.GDK.b(qVar);
                        } else {
                            a(this, false, false, 0, 7);
                        }
                    }
                    kotlin.x xVar4 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 11:
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
                if (eVar3 == null) {
                    p.btv("multiPreviewPlugin");
                }
                com.tencent.mm.plugin.vlog.model.ad adVar4 = (com.tencent.mm.plugin.vlog.model.ad) kotlin.a.j.L(this.GDT.GxA.Gzn, this.GEi.GNx);
                if (adVar4 != null) {
                    j5 = adVar4.GzA.startTimeMs;
                } else {
                    j5 = 0;
                }
                eVar3.GGV = j5;
                this.GDT.acx(this.GEi.GNx);
                ae aeVar = this.GEh;
                com.tencent.mm.plugin.vlog.model.ad adVar5 = this.GDT.GyN;
                if (adVar5 == null) {
                    p.hyc();
                }
                aeVar.ch(adVar5.GzA.mwH);
                this.GEh.wji.setShow(true);
                AppMethodBeat.o(190995);
                return;
            case 12:
                if (bundle != null) {
                    cWX();
                    CharSequence charSequence2 = bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    int i5 = bundle.getInt("PARAM_EDIT_TEXT_COLOR");
                    int i6 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                    String string2 = bundle.getString("PARAM_EDIT_TEXT_FONT");
                    com.tencent.mm.plugin.recordvideo.plugin.c cVar4 = this.BTQ;
                    if (cVar4 == null) {
                        p.btv("addTextPlugin");
                    }
                    cVar4.a(charSequence2, i5, i6, string2);
                    kotlin.x xVar5 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 13:
                cEa();
                if (this.GDT.Gyx.size() == 1) {
                    this.GDT.acx(0);
                    ai aiVar = this.GEa;
                    com.tencent.mm.plugin.vlog.model.ad adVar6 = this.GDT.GyN;
                    if (adVar6 == null) {
                        p.hyc();
                    }
                    ai.a(aiVar, adVar6, false, 0, 6);
                } else {
                    this.GDT.acx(-1);
                    this.GDT.a(this.GEb.c(this.GDT.GxA), false);
                    this.GEb.b(this.GDT.GxA, this.GDF);
                }
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar4 = this.GDW;
                if (eVar4 == null) {
                    p.btv("multiPreviewPlugin");
                }
                a aVar6 = this.GDN;
                if (aVar6 == null) {
                    p.btv("addMusicPlugin");
                }
                eVar4.wE(aVar6.wgL.getMuteOrigin());
                this.GEo.fDE();
                AppMethodBeat.o(190995);
                return;
            case 14:
                cWX();
                AppMethodBeat.o(190995);
                return;
            case 15:
                boolean z = bundle != null ? bundle.getBoolean("PARAM_1_BOOLEAN", false) : false;
                if (z || (!z && this.GEo.GIb)) {
                    a(this, false, false, 0, 7);
                    AppMethodBeat.o(190995);
                    return;
                }
            case 16:
                if (bundle != null) {
                    int i7 = bundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar5 = this.GDW;
                    if (eVar5 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar5.seek((long) i7);
                    kotlin.x xVar6 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 17:
                if (bundle != null) {
                    long j6 = bundle.getLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG");
                    long j7 = bundle.getLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG");
                    long j8 = bundle.getLong("EDIT_CROP_VLOG_SEEKTIME_LONG");
                    if (bundle.getBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN")) {
                        a(this, true, true, 0, 4);
                    } else {
                        cWX();
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar6 = this.GDW;
                        if (eVar6 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        eVar6.seek(j8);
                    }
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar7 = this.GDW;
                    if (eVar7 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar7.at(j6, j7);
                    kotlin.x xVar7 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 18:
                cEa();
                this.GDX.setVisibility(4);
                AppMethodBeat.o(190995);
                return;
            case 19:
                com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
                if (bVar != null) {
                    RecordConfigProvider recordConfigProvider = this.wdm;
                    if (recordConfigProvider != null) {
                        i2 = recordConfigProvider.BOv;
                    } else {
                        i2 = 10000;
                    }
                    if (bVar.iqg - bVar.dvv > i2 + 250) {
                        Context context2 = getContext();
                        if (context2 == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(190995);
                            throw tVar2;
                        }
                        ((Activity) context2).setResult(3000);
                        Context context3 = getContext();
                        if (context3 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(190995);
                            throw tVar3;
                        }
                        ((Activity) context3).finish();
                        AppMethodBeat.o(190995);
                        return;
                    }
                    this.GDK.eKt();
                    com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                    kotlin.x xVar8 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 20:
                a aVar7 = this.GDN;
                if (aVar7 == null) {
                    p.btv("addMusicPlugin");
                }
                aVar7.eKP();
                this.GDK.eKt();
                com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(190995);
                return;
            case 21:
                onBackPress();
                AppMethodBeat.o(190995);
                return;
            case 22:
                if (bundle != null) {
                    int i8 = bundle.getInt("PARAM_DELETE_VIEW_TYPE_INT");
                    if (i8 == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.EditItemTypeLyrics.ordinal()) {
                        a aVar8 = this.GDN;
                        if (aVar8 == null) {
                            p.btv("addMusicPlugin");
                        }
                        aVar8.fCy();
                    } else if (i8 == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.EditItemTypeCaption.ordinal()) {
                        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar2 = this.GDO;
                        if (bVar2 == null) {
                            p.btv("captionPlugin");
                        }
                        bVar2.acF(0);
                    } else if (i8 == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.EditItemTypeRecordCaption.ordinal()) {
                        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar3 = this.GDO;
                        if (bVar3 == null) {
                            p.btv("captionPlugin");
                        }
                        bVar3.acF(1);
                    }
                    kotlin.x xVar9 = kotlin.x.SXb;
                }
                a(this, true, false, 0, 6);
                AppMethodBeat.o(190995);
                return;
            case 23:
                if (bundle != null) {
                    switch (bundle.getInt("PARAM_1_INT")) {
                        case 1:
                            this.GEm.setVisibility(0);
                            this.GEn.setVisibility(0);
                            com.tencent.mm.plugin.vlog.ui.plugin.e eVar8 = this.GDW;
                            if (eVar8 == null) {
                                p.btv("multiPreviewPlugin");
                            }
                            eVar8.GGS = false;
                            eVar8.GHe.setVisibility(8);
                            this.GEq.wF(true);
                            this.GEq.GHR = false;
                            break;
                        case 2:
                            this.GEm.setVisibility(4);
                            this.GEn.setVisibility(4);
                            com.tencent.mm.plugin.vlog.ui.plugin.e eVar9 = this.GDW;
                            if (eVar9 == null) {
                                p.btv("multiPreviewPlugin");
                            }
                            eVar9.GGS = true;
                            eVar9.GHe.setVisibility(0);
                            fCI();
                            break;
                        case 3:
                            this.GEq.wF(false);
                            this.GEq.GHR = false;
                            break;
                        case 4:
                            this.GEq.wF(false);
                            this.GEq.GHR = true;
                            break;
                    }
                    kotlin.x xVar10 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 24:
                if (this.GEq.GGS) {
                    this.GEq.wG(false);
                    AppMethodBeat.o(190995);
                    return;
                }
                fCB();
                AppMethodBeat.o(190995);
                return;
            case 25:
                fCB();
                AppMethodBeat.o(190995);
                return;
            case 26:
                a aVar9 = this.GDN;
                if (aVar9 == null) {
                    p.btv("addMusicPlugin");
                }
                aVar9.fCz();
                AppMethodBeat.o(190995);
                return;
            case 27:
                com.tencent.mm.plugin.vlog.ui.plugin.d dVar3 = this.GEp;
                a aVar10 = this.GDN;
                if (aVar10 == null) {
                    p.btv("addMusicPlugin");
                }
                dVar3.f(aVar10.wgG);
                AppMethodBeat.o(190995);
                return;
            case 28:
                if (bundle != null) {
                    bundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
                    a(this, true, true, 0, 4);
                    kotlin.x xVar11 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 29:
                cEa();
                this.GDZ.setVisibility(4);
                AppMethodBeat.o(190995);
                return;
            case 30:
                AppMethodBeat.o(190995);
                return;
            case 31:
                if (bundle == null || (mediaItem = (GalleryItem.MediaItem) bundle.getParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE")) == null) {
                    AppMethodBeat.o(190995);
                    return;
                }
                this.GEd.jH("start", "select first image");
                r rVar = this.GDY;
                if (rVar == null) {
                    p.btv("editPencilPlugin");
                }
                rVar.reset();
                this.GDL.reset();
                this.GDL.U(new n(mediaItem, this));
                kotlin.x xVar12 = kotlin.x.SXb;
                AppMethodBeat.o(190995);
                return;
            case 32:
                if (bundle != null) {
                    bundle.getInt("EDIT_FILTER_INDEX_INT", -1);
                    bundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT", 0.0f);
                    String string3 = bundle.getString("EDIT_FILTER_COLOR_PATH_STRING");
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar10 = this.GDW;
                    if (eVar10 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    if (eVar10.GxA != null) {
                        if (string3 == null) {
                            string3 = "";
                        }
                        com.tencent.mm.plugin.vlog.model.ac.aUa(string3);
                        kotlin.x xVar13 = kotlin.x.SXb;
                    }
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 33:
                fCE();
                this.GDX.setVisibility(0);
                this.GDL.reset();
                AppMethodBeat.o(190995);
                return;
            case 34:
                this.GDL.fDA();
                AppMethodBeat.o(190995);
                return;
            case 35:
                this.GDL.fDB();
                AppMethodBeat.o(190995);
                return;
            case 36:
                this.GDL.reset();
                if (bundle != null) {
                    this.GDL.acD(bundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT"));
                    kotlin.x xVar14 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 37:
                this.GDL.fDz();
                AppMethodBeat.o(190995);
                return;
            case 38:
                cEa();
                this.GEc.setEnableLengthEdit(!this.GDT.fBq());
                this.GEc.GMA = this.GDK.GMF;
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar11 = this.GDK.GMF;
                if (!(aVar11 == null || (dVar2 = aVar11.Cev) == null)) {
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar11 = this.GDW;
                    if (eVar11 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar11.at(dVar2.getStart(), dVar2.getEnd());
                    kotlin.x xVar15 = kotlin.x.SXb;
                }
                this.GEc.setTrack(this.GDT.GxA);
                a(this, false, false, 0, 7);
                AppMethodBeat.o(190995);
                return;
            case 39:
                fCE();
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar12 = this.GDK.GMF;
                if (!(aVar12 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.o)) {
                    aVar12 = null;
                }
                com.tencent.mm.plugin.recordvideo.ui.editor.item.o oVar = (com.tencent.mm.plugin.recordvideo.ui.editor.item.o) aVar12;
                if (oVar != null) {
                    com.tencent.mm.plugin.vlog.model.local.a aVar13 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                    if (fBP == null) {
                        p.hyc();
                    }
                    com.tencent.mm.xeffect.effect.ad Os = fBP.Os(oVar.wKD);
                    if (Os != null) {
                        Os.aH(oVar.Cev.getStart(), oVar.Cev.getEnd());
                        kotlin.x xVar16 = kotlin.x.SXb;
                    }
                    if (!(Os instanceof com.tencent.mm.xeffect.effect.t)) {
                        adVar = null;
                    } else {
                        adVar = Os;
                    }
                    com.tencent.mm.xeffect.effect.t tVar4 = (com.tencent.mm.xeffect.effect.t) adVar;
                    if (tVar4 != null) {
                        tVar4.a(new com.tencent.mm.xeffect.effect.f((int) oVar.centerX, (int) oVar.centerY, oVar.scale, oVar.mat));
                        kotlin.x xVar17 = kotlin.x.SXb;
                    }
                    if (!(Os instanceof com.tencent.mm.xeffect.effect.v)) {
                        adVar2 = null;
                    } else {
                        adVar2 = Os;
                    }
                    com.tencent.mm.xeffect.effect.v vVar4 = (com.tencent.mm.xeffect.effect.v) adVar2;
                    if (vVar4 != null) {
                        vVar4.a(new com.tencent.mm.xeffect.effect.h(oVar.text, null, 30));
                        kotlin.x xVar18 = kotlin.x.SXb;
                    }
                }
                this.GDK.fEn();
                if (bundle != null) {
                    a(this, true, false, bundle.getLong("PARAM_1_LONG"), 2);
                    kotlin.x xVar19 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 40:
                this.GED = b.GLOBAL_EDIT;
                fCE();
                if (!this.GDT.Gyy || this.GEw) {
                    com.tencent.mm.plugin.vlog.model.ac acVar = this.GDT.GxA;
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar12 = this.GDW;
                    if (eVar12 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar12.at(acVar.Gez.getPlayStart(), acVar.fBz());
                    if (this.GEo.GIb) {
                        a(this, false, false, 0, 7);
                    }
                    this.GDT.GyN = null;
                    this.GDZ.q(-1, 0, 0);
                    this.GEg.GyM = -1;
                    this.GEg.setVisibility(4);
                    this.GEi.GNx = -1;
                    this.GEi.setVisibility(0);
                    AppMethodBeat.o(190995);
                    return;
                }
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                if (bundle != null) {
                    int i9 = bundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
                    com.tencent.mm.plugin.vlog.model.ad adVar7 = (com.tencent.mm.plugin.vlog.model.ad) kotlin.a.j.L(this.GDT.GxA.fBD(), i9);
                    if (adVar7 != null) {
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar13 = this.GDW;
                        if (eVar13 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        eVar13.GGV = adVar7.GzA.startTimeMs;
                        this.GDZ.setVisibility(4);
                        this.GDK.setSegmentOffset(adVar7.GzA.startTimeMs);
                        long j9 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                        long longValue = this.GDT.GxA.fBA().second.longValue();
                        if (longValue != -1) {
                            j9 = ((long) (((float) (longValue - adVar7.GzA.startTimeMs)) * adVar7.GzA.mwH)) + adVar7.GzA.GGz;
                        }
                        this.GDT.acx(i9);
                        this.GEa.setEnableLengthEdit(!this.GDT.fBq());
                        ai aiVar2 = this.GEa;
                        com.tencent.mm.plugin.vlog.model.ad adVar8 = this.GDT.GyN;
                        if (adVar8 == null) {
                            p.hyc();
                        }
                        ai.a(aiVar2, adVar8, false, j9, 2);
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar14 = this.GDW;
                        if (eVar14 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        a aVar14 = this.GDN;
                        if (aVar14 == null) {
                            p.btv("addMusicPlugin");
                        }
                        eVar14.wE(aVar14.wgL.getMuteOrigin());
                        this.GEo.fDE();
                        kotlin.x xVar20 = kotlin.x.SXb;
                        AppMethodBeat.o(190995);
                        return;
                    }
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 42:
                if (bundle != null) {
                    int i10 = bundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
                    if (i10 >= 0) {
                        this.GED = b.SINGLE_EDIT;
                        com.tencent.mm.plugin.vlog.model.ad adVar9 = (com.tencent.mm.plugin.vlog.model.ad) kotlin.a.j.L(this.GDT.GxA.fBD(), i10);
                        if (adVar9 != null) {
                            if (this.GEg.GyM != i10) {
                                cEa();
                                this.GDT.GyN = adVar9;
                                long max = Math.max(this.GDT.GxA.Gez.getPlayStart(), adVar9.GzA.startTimeMs);
                                long min = Math.min(this.GDT.GxA.fBz(), adVar9.GzA.endTimeMs);
                                com.tencent.mm.plugin.vlog.ui.plugin.e eVar15 = this.GDW;
                                if (eVar15 == null) {
                                    p.btv("multiPreviewPlugin");
                                }
                                eVar15.at(max, min);
                                com.tencent.mm.plugin.vlog.ui.plugin.e eVar16 = this.GDW;
                                if (eVar16 == null) {
                                    p.btv("multiPreviewPlugin");
                                }
                                eVar16.seek(max);
                                this.GEg.GyM = i10;
                                this.GEg.setVisibility(0);
                                this.GEi.GNx = i10;
                            }
                            kotlin.x xVar21 = kotlin.x.SXb;
                        }
                    }
                    kotlin.x xVar22 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 43:
                this.GDS = true;
                if (bundle != null) {
                    if (bundle.getBoolean("EDIT_VLOG_TRACK_CROP_CHANGE")) {
                        this.GDT.aw(bundle.getLong("EDIT_VLOG_TRACK_CROP_START"), bundle.getLong("EDIT_VLOG_TRAKC_CROP_END"));
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar17 = this.GDW;
                        if (eVar17 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        a aVar15 = this.GDN;
                        if (aVar15 == null) {
                            p.btv("addMusicPlugin");
                        }
                        eVar17.wE(aVar15.wgL.getMuteOrigin());
                    } else {
                        fCE();
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar18 = this.GDW;
                        if (eVar18 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        eVar18.GGV = 0;
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar19 = this.GDW;
                        if (eVar19 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        eVar19.GGW = 0;
                        boolean z2 = bundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM");
                        int i11 = bundle.getInt("EDIT_TRACK_DURATION_CUT_COUNT");
                        int i12 = bundle.getInt("EDIT_TRACK_DURATION_SCROLL_COUNT");
                        long j10 = bundle.getLong("EDIT_VLOG_TRACK_CROP_START");
                        long j11 = bundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
                        com.tencent.mm.plugin.vlog.model.ad adVar10 = this.GDT.GyN;
                        long j12 = adVar10 != null ? adVar10.GzA.startTimeMs : 0;
                        this.GDT.a(z2, j10, j11, i11, i12, this.GED == b.GLOBAL_EDIT);
                        this.GDK.setSegmentOffset(0);
                        a(this, true, false, j12, 2);
                        if (this.GED == b.SINGLE_EDIT) {
                            fCF();
                        }
                    }
                    kotlin.x xVar23 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 44:
                if (bundle != null) {
                    this.GDZ.setVisibility(4);
                    this.GDT.cf(bundle.getFloat("EDIT_TRACK_DURATION_SCALE", 1.0f));
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar20 = this.GDW;
                    if (eVar20 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    a aVar16 = this.GDN;
                    if (aVar16 == null) {
                        p.btv("addMusicPlugin");
                    }
                    eVar20.wE(aVar16.wgL.getMuteOrigin());
                    kotlin.x xVar24 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 45:
                if (bundle != null) {
                    this.GDT.cf(bundle.getFloat("EDIT_TRACK_DURATION_SCALE", 1.0f));
                    fCE();
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar21 = this.GDW;
                    if (eVar21 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar21.GGV = 0;
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar22 = this.GDW;
                    if (eVar22 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar22.GGW = 0;
                    com.tencent.mm.plugin.vlog.model.ad adVar11 = this.GDT.GyN;
                    if (adVar11 != null) {
                        j4 = adVar11.GzA.startTimeMs;
                    } else {
                        j4 = 0;
                    }
                    v.a(this.GDT);
                    a(this, true, false, j4, 2);
                    fCF();
                    kotlin.x xVar25 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 46:
                if (bundle != null) {
                    fCE();
                    if (bundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM")) {
                        this.GDT.a(this.GEb.c(this.GDT.GxA, false), true);
                    } else {
                        this.GDT.a(this.GEb.c(this.GDT.GxA, true), false);
                    }
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar23 = this.GDW;
                    if (eVar23 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    a aVar17 = this.GDN;
                    if (aVar17 == null) {
                        p.btv("addMusicPlugin");
                    }
                    eVar23.wE(aVar17.wgL.getMuteOrigin());
                    this.GEo.fDE();
                    this.GEo.fDG();
                    kotlin.x xVar26 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (bundle != null) {
                    int i13 = bundle.getInt("EDIT_COMPOSITION_TRACK_INDEX");
                    boolean z3 = bundle.getBoolean("EDIT_COMPOSITION_LEFT");
                    this.GDT.p(i13, bundle.getLong("EDIT_VLOG_TRACK_CROP_START"), bundle.getLong("EDIT_VLOG_TRAKC_CROP_END"));
                    com.tencent.mm.plugin.vlog.model.ad adVar12 = this.GDT.GxA.Gzn.get(i13);
                    if (z3) {
                        j3 = adVar12.GzA.startTimeMs;
                    } else {
                        j3 = adVar12.GzA.endTimeMs;
                    }
                    c(false, false, j3);
                    kotlin.x xVar27 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 49:
                if (bundle != null) {
                    if (bundle.getByteArray("PARAM_1_BYTEARRAY") != null) {
                        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar4 = this.GDO;
                        if (bVar4 == null) {
                            p.btv("captionPlugin");
                        }
                        bVar4.fDT();
                        cWX();
                        int i14 = bundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
                        int i15 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                        String string4 = bundle.getString("PARAM_EDIT_TEXT_FONT");
                        com.tencent.mm.plugin.recordvideo.plugin.c cVar7 = this.BTQ;
                        if (cVar7 == null) {
                            p.btv("addTextPlugin");
                        }
                        byte[] byteArray = bundle.getByteArray("PARAM_1_BYTEARRAY");
                        if (byteArray == null) {
                            p.hyc();
                        }
                        p.g(byteArray, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                        cVar7.a(byteArray, i14, i15, string4);
                    }
                    kotlin.x xVar28 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 50:
                if (bundle != null) {
                    if (bundle.getByteArray("PARAM_1_BYTEARRAY") != null) {
                        cWX();
                        cEa();
                        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar5 = this.GDO;
                        if (bVar5 == null) {
                            p.btv("captionPlugin");
                        }
                        byte[] byteArray2 = bundle.getByteArray("PARAM_1_BYTEARRAY");
                        if (byteArray2 == null) {
                            p.hyc();
                        }
                        p.g(byteArray2, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                        bVar5.ce(byteArray2);
                    }
                    kotlin.x xVar29 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 51:
                if (bundle != null) {
                    if (bundle.getInt("PARAM_1_INT") == 0) {
                        dVar = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION;
                    } else {
                        dVar = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION;
                    }
                    byte[] byteArray3 = bundle.getByteArray("PARAM_1_BYTEARRAY");
                    if (byteArray3 == null) {
                        p.hyc();
                    }
                    p.g(byteArray3, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                    com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a(this.GDK, new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(dVar, byteArray3), this.GDT.GyN, this.msl);
                    kotlin.x xVar30 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 52:
                a(this, false, false, 0, 7);
                this.GDK.fEj();
                AppMethodBeat.o(190995);
                return;
            case 53:
                if (bundle != null) {
                    if (bundle.getByteArray("PARAM_1_BYTEARRAY") != null) {
                        int i16 = bundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
                        int i17 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                        String string5 = bundle.getString("PARAM_EDIT_TEXT_FONT");
                        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar6 = this.GDO;
                        if (bVar6 == null) {
                            p.btv("captionPlugin");
                        }
                        byte[] byteArray4 = bundle.getByteArray("PARAM_1_BYTEARRAY");
                        if (byteArray4 == null) {
                            p.hyc();
                        }
                        p.g(byteArray4, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                        bVar6.a(byteArray4, i16, i17, string5);
                    }
                    if (bundle.getLong("PARAM_1_LONG", -1) >= 0) {
                        a(this, false, false, bundle.getLong("PARAM_1_LONG"), 3);
                    }
                    kotlin.x xVar31 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 54:
                if (bundle != null) {
                    this.GDK.c(bundle.getInt("PARAM_1_INT") == 1 ? com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION : com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION);
                    kotlin.x xVar32 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 55:
                this.GDZ.wJ(true);
                AppMethodBeat.o(190995);
                return;
            case 56:
                this.GDZ.wJ(false);
                AppMethodBeat.o(190995);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.pay.n.CTRL_INDEX:
                if (bundle != null) {
                    int i18 = bundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
                    com.tencent.mm.plugin.vlog.model.ac acVar2 = this.GDT.GxA;
                    ArrayList<com.tencent.mm.plugin.vlog.model.ad> arrayList = acVar2.Gzn;
                    com.tencent.mm.plugin.vlog.model.ad adVar13 = arrayList.get(i18 + 1);
                    long j13 = arrayList.get(i18).GzA.endTimeMs - (adVar13.GzA.Rhc.duration / 2);
                    long max2 = Math.max(0L, j13 - 1000);
                    long min2 = Math.min(acVar2.getDurationMs(), j13 + 1000);
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar24 = this.GDW;
                    if (eVar24 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar24.at(max2, min2);
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar25 = this.GDW;
                    if (eVar25 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar25.seek(max2);
                    this.GEi.GNy = max2;
                    this.GEi.jx(i18, adVar13.Gzy);
                    kotlin.x xVar33 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 58:
                com.tencent.mm.plugin.vlog.model.ac acVar3 = this.GDT.GxA;
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar26 = this.GDW;
                if (eVar26 == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar26.at(acVar3.Gez.getPlayStart(), acVar3.fBz());
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar27 = this.GDW;
                if (eVar27 == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar27.seek(this.GEi.GNy);
                fCF();
                AppMethodBeat.o(190995);
                return;
            case bv.CTRL_INDEX:
                if (bundle != null) {
                    int i19 = bundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
                    int i20 = bundle.getInt("EDIT_TRANSITION_EFFECT_ID");
                    com.tencent.mm.plugin.vlog.model.ac acVar4 = this.GDT.GxA;
                    ArrayList<com.tencent.mm.plugin.vlog.model.ad> arrayList2 = acVar4.Gzn;
                    com.tencent.mm.plugin.vlog.model.ad adVar14 = arrayList2.get(i19 + 1);
                    com.tencent.mm.plugin.vlog.model.local.a aVar18 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    com.tencent.mm.plugin.vlog.model.local.a.a(adVar14, i20);
                    long j14 = arrayList2.get(i19).GzA.endTimeMs - (adVar14.GzA.Rhc.duration / 2);
                    long max3 = Math.max(0L, j14 - 1000);
                    long min3 = Math.min(acVar4.getDurationMs(), j14 + 1000);
                    a(this, true, false, max3, 2);
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar28 = this.GDW;
                    if (eVar28 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar28.at(max3, min3);
                    kotlin.x xVar34 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 60:
                if (bundle != null) {
                    int i21 = bundle.getInt("EDIT_TRANSITION_EFFECT_ID");
                    com.tencent.mm.plugin.vlog.model.ac acVar5 = this.GDT.GxA;
                    com.tencent.mm.plugin.vlog.model.local.a aVar19 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    com.tencent.mm.plugin.vlog.model.local.a.D(acVar5.Gzn, i21);
                    int i22 = bundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
                    ArrayList<com.tencent.mm.plugin.vlog.model.ad> arrayList3 = acVar5.Gzn;
                    a(this, true, false, Math.max(0L, (arrayList3.get(i22).GzA.endTimeMs - (arrayList3.get(i22 + 1).GzA.Rhc.duration / 2)) - 1000), 2);
                    kotlin.x xVar35 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                fCE();
                ArrayList<com.tencent.mm.plugin.vlog.model.ad> arrayList4 = this.GDT.GxA.Gzn;
                ah ahVar = this.GDZ;
                List<com.tencent.mm.plugin.vlog.model.ad> N = kotlin.a.j.N(arrayList4, arrayList4.size() - 1);
                ArrayList arrayList5 = new ArrayList(kotlin.a.j.a(N, 10));
                for (com.tencent.mm.plugin.vlog.model.ad adVar15 : N) {
                    arrayList5.add(Boolean.valueOf(adVar15.fBG()));
                }
                ahVar.hS(arrayList5);
                AppMethodBeat.o(190995);
                return;
            case 62:
                if (bundle != null) {
                    long j15 = bundle.getLong("PARAM_1_LONG");
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar29 = this.GDW;
                    if (eVar29 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar29.setMuteOrigin(true);
                    cWX();
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar30 = this.GDW;
                    if (eVar30 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar30.seek(j15);
                    kotlin.x xVar36 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 63:
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar31 = this.GDW;
                if (eVar31 == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar31.setMuteOrigin(false);
                a(this, false, false, 0, 3);
                AppMethodBeat.o(190995);
                return;
            case 64:
                a aVar20 = this.GDN;
                if (aVar20 == null) {
                    p.btv("addMusicPlugin");
                }
                List<kotlin.r<String, Long, Long>> recordResult = aVar20.wgL.getRecordResult();
                com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar7 = this.GDO;
                if (bVar7 == null) {
                    p.btv("captionPlugin");
                }
                bVar7.hT(recordResult);
                a(this, true, false, 0, 6);
                AppMethodBeat.o(190995);
                return;
            case 65:
                if (bundle != null) {
                    if (bundle.getBoolean("EDIT_FILTER_SHOW")) {
                        cEa();
                    } else {
                        fCE();
                    }
                    kotlin.x xVar37 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case 66:
            case 67:
            case 68:
                cEa();
                AppMethodBeat.o(190995);
                return;
            case 69:
                fCE();
                AppMethodBeat.o(190995);
                return;
            case 70:
                AppMethodBeat.o(190995);
                return;
            case 71:
                AppMethodBeat.o(190995);
                return;
            case 72:
                if (bundle != null) {
                    String string6 = bundle.getString("EDIT_PAG_STICKER_PATH");
                    if (string6 != null) {
                        com.tencent.mm.plugin.vlog.model.local.a aVar21 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        EffectManager fBP2 = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                        if (fBP2 != null) {
                            com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGTextEffect;
                            Context context4 = getContext();
                            p.g(context4, "context");
                            AssetManager assets = context4.getAssets();
                            p.g(assets, "context.assets");
                            vVar = fBP2.a(jVar, assets, string6);
                        } else {
                            vVar = null;
                        }
                        com.tencent.mm.plugin.vlog.model.local.a aVar22 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        EffectManager fBP3 = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                        if (fBP3 != null) {
                            fBP3.a(vVar);
                        }
                        if (vVar != null) {
                            j2 = vVar.id;
                        } else {
                            j2 = 0;
                        }
                        if (!(vVar instanceof com.tencent.mm.xeffect.effect.r)) {
                            vVar2 = null;
                        } else {
                            vVar2 = vVar;
                        }
                        com.tencent.mm.xeffect.effect.v vVar5 = vVar2;
                        if (vVar5 == null || (size2 = vVar5.ApT) == null) {
                            size = new Size(0, 0);
                        } else {
                            size = size2;
                        }
                        String string7 = getContext().getString(R.string.bq3);
                        p.g(string7, "context.getString(R.string.edit_pag_text_default)");
                        if (!(vVar instanceof com.tencent.mm.xeffect.effect.v)) {
                            vVar3 = null;
                        } else {
                            vVar3 = vVar;
                        }
                        com.tencent.mm.xeffect.effect.v vVar6 = vVar3;
                        if (vVar6 != null) {
                            vVar6.a(new com.tencent.mm.xeffect.effect.h(string7, null, 30));
                            kotlin.x xVar38 = kotlin.x.SXb;
                        }
                        com.tencent.mm.plugin.recordvideo.ui.editor.item.o oVar2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.o(string6);
                        oVar2.wKD = j2;
                        oVar2.setText(string7);
                        oVar2.Cew = this.GDS;
                        oVar2.width = size.getWidth();
                        oVar2.height = size.getHeight();
                        RectF rectF = oVar2.Cgb;
                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar32 = this.GDW;
                        if (eVar32 == null) {
                            p.btv("multiPreviewPlugin");
                        }
                        rectF.set(eVar32.GyG);
                        float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 160);
                        oVar2.scale = Math.min(Math.min(fromDPToPix / ((float) size.getWidth()), fromDPToPix / ((float) size.getHeight())), 1.0f);
                        oVar2.Cgd = new o(j2, oVar2, this);
                        com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a(this.GDK, oVar2, this.GDT.GyN, this.msl);
                    }
                    kotlin.x xVar39 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX:
                if (bundle != null) {
                    cWX();
                    cEa();
                    CharSequence charSequence3 = bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    y yVar = this.GEj;
                    if (charSequence3 == null || (str2 = charSequence3.toString()) == null) {
                        str2 = "";
                    }
                    yVar.aUm(str2);
                    kotlin.x xVar40 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 74:
                if (bundle != null) {
                    String string8 = bundle.getString("EDIT_PAG_CHANGE_TEXT");
                    if (string8 == null) {
                        str = "";
                    } else {
                        str = string8;
                    }
                    p.g(str, "param.getString(IRecordS…IT_PAG_CHANGE_TEXT) ?: \"\"");
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar23 = this.GDK.GMF;
                    if (!(aVar23 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.o)) {
                        aVar23 = null;
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.o oVar3 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.o) aVar23;
                    if (oVar3 != null) {
                        oVar3.setText(str);
                        com.tencent.mm.plugin.vlog.model.local.a aVar24 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        EffectManager fBP4 = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                        if (fBP4 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.xeffect.effect.ad Os2 = fBP4.Os(oVar3.wKD);
                        if (!(Os2 instanceof com.tencent.mm.xeffect.effect.v)) {
                            Os2 = null;
                        }
                        com.tencent.mm.xeffect.effect.v vVar7 = (com.tencent.mm.xeffect.effect.v) Os2;
                        if (vVar7 != null) {
                            vVar7.a(new com.tencent.mm.xeffect.effect.h(oVar3.text, null, 30));
                            kotlin.x xVar41 = kotlin.x.SXb;
                        }
                    }
                    a(this, false, false, 0, 7);
                    kotlin.x xVar42 = kotlin.x.SXb;
                }
                AppMethodBeat.o(190995);
                return;
            case 75:
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar25 = this.GDK.GMF;
                if (aVar25 != null) {
                    cWX();
                    this.GDR.a(aVar25);
                    kotlin.x xVar43 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                if (bundle != null) {
                    long j16 = bundle.getLong("PARAM_1_LONG");
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar26 = this.GDK.GMF;
                    if (!(aVar26 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.o)) {
                        aVar26 = null;
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.o oVar4 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.o) aVar26;
                    if (oVar4 != null) {
                        com.tencent.mm.plugin.vlog.model.local.a aVar27 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        EffectManager fBP5 = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                        if (fBP5 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.xeffect.effect.ad Os3 = fBP5.Os(oVar4.wKD);
                        if (Os3 != null) {
                            Os3.aH(oVar4.Cev.getStart(), oVar4.Cev.getEnd());
                            kotlin.x xVar44 = kotlin.x.SXb;
                        }
                    }
                    this.GDK.GMG.fEq();
                    this.GDK.fEn();
                    a(this, true, false, j16, 2);
                    kotlin.x xVar45 = kotlin.x.SXb;
                    AppMethodBeat.o(190995);
                    return;
                }
                AppMethodBeat.o(190995);
                return;
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                this.GDK.fEn();
                a(this, false, false, 0, 7);
                AppMethodBeat.o(190995);
                return;
            case h.a.CTRL_INDEX:
                this.GDK.GMG.fEq();
                this.GDK.fEn();
                a(this, true, true, 0, 4);
                AppMethodBeat.o(190995);
                return;
            case 79:
                this.GEA = false;
                if (this.GDT.Gyy) {
                    setupImageEditPlugins(false);
                    this.GDK.fEk();
                    AppMethodBeat.o(190995);
                    return;
                }
                fCG();
                AppMethodBeat.o(190995);
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                this.GEA = false;
                setupTemplateVideoPlugins(this.GEl.GIr.fDN());
                AppMethodBeat.o(190995);
                return;
            case 81:
                this.GEA = false;
                setupTemplateVideoPlugins(this.GEl.GIr.fDN());
                AppMethodBeat.o(190995);
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                boolean z4 = bundle != null ? bundle.getBoolean("PARAM_1_BOOLEAN", false) : false;
                this.GEF = z4;
                com.tencent.mm.plugin.vlog.model.local.a aVar28 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                com.tencent.mm.plugin.vlog.model.local.a.b(this.GDT.GxA, z4);
                if (z4) {
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar33 = this.GDW;
                    if (eVar33 == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar33.fCZ();
                }
                if (this.GDT.Gyy && !this.GEw) {
                    this.GDX.select(this.GDX.fCS());
                }
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar34 = this.GDW;
                if (eVar34 == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar34.bLe();
                AppMethodBeat.o(190995);
                return;
            default:
                Log.i("MicroMsg.MultiVideoPluginLayout", "unknown key ".concat(String.valueOf(cVar)));
                break;
        }
        AppMethodBeat.o(190995);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout$setupMediaData$1", f = "MultiVideoFullScreenPluginLayout.kt", hxM = {559}, m = "invokeSuspend")
    public static final class h extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        Object L$0;
        int label;
        private kotlinx.coroutines.ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        Object pEG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, kotlin.d.d dVar) {
            super(2, dVar);
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(190965);
            p.h(dVar, "completion");
            h hVar = new h(this.GEJ, dVar);
            hVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(190965);
            return hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(190966);
            Object invokeSuspend = ((h) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(190966);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$setupMediaData$1$1$2"})
        public static final class a extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object> {
            final /* synthetic */ List GFe;
            final /* synthetic */ List GFf;
            final /* synthetic */ Integer[] GFg;
            final /* synthetic */ h GFh;
            Object L$0;
            int label;
            private kotlinx.coroutines.ai p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(List list, List list2, Integer[] numArr, kotlin.d.d dVar, h hVar) {
                super(2, dVar);
                this.GFe = list;
                this.GFf = list2;
                this.GFg = numArr;
                this.GFh = hVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(190962);
                p.h(dVar, "completion");
                a aVar = new a(this.GFe, this.GFf, this.GFg, dVar, this.GFh);
                aVar.p$ = (kotlinx.coroutines.ai) obj;
                AppMethodBeat.o(190962);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
                AppMethodBeat.i(190963);
                Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
                AppMethodBeat.o(190963);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(190961);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.ai aiVar = this.p$;
                        v vVar = this.GFh.GEJ.GDT;
                        List<String> list = this.GFe;
                        List<Integer> list2 = this.GFf;
                        List<Integer> W = kotlin.a.e.W(this.GFg);
                        this.L$0 = aiVar;
                        this.label = 1;
                        obj = vVar.a(list, list2, W, this);
                        if (obj == aVar) {
                            AppMethodBeat.o(190961);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(190961);
                        throw illegalStateException;
                }
                AppMethodBeat.o(190961);
                return obj;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:127:0x04e7  */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x04dc A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0196  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x01e0  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x02b5  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
            // Method dump skipped, instructions count: 1316
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$statusChange$34$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "onBringToFront", "", "onDelete", "onUpdateMatrix", "centerX", "", "centerY", "scale", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "plugin-vlog_release"})
    public static final class o implements com.tencent.mm.plugin.recordvideo.ui.editor.item.j {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        final /* synthetic */ long GFp;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.ui.editor.item.o GFq;

        o(long j2, com.tencent.mm.plugin.recordvideo.ui.editor.item.o oVar, MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            this.GFp = j2;
            this.GFq = oVar;
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.j
        public final void eMr() {
            AppMethodBeat.i(190985);
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
            if (fBP == null) {
                p.hyc();
            }
            fBP.Ou(this.GFp);
            AppMethodBeat.o(190985);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.j
        public final void q(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(190986);
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
            if (fBP == null) {
                p.hyc();
            }
            com.tencent.mm.xeffect.effect.ad Os = fBP.Os(this.GFq.wKD);
            if (!(Os instanceof com.tencent.mm.xeffect.effect.t)) {
                Os = null;
            }
            com.tencent.mm.xeffect.effect.t tVar = (com.tencent.mm.xeffect.effect.t) Os;
            if (tVar != null) {
                tVar.a(new com.tencent.mm.xeffect.effect.f((int) f2, (int) f3, f4, f5));
            }
            this.GEJ.getMultiPreviewPlugin().bLe();
            AppMethodBeat.o(190986);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.j
        public final void eMs() {
            AppMethodBeat.i(190987);
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
            if (fBP == null) {
                p.hyc();
            }
            fBP.Ot(this.GFp);
            AppMethodBeat.o(190987);
        }
    }

    private final void fCB() {
        String str;
        Bundle bundle;
        String str2;
        byte[] bArr;
        boolean z;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        Bundle bundle5;
        boolean z2 = true;
        AppMethodBeat.i(190996);
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        com.tencent.mm.plugin.vlog.model.m.fBc();
        ad.a(this.GDQ);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null) {
            p.hyc();
        }
        String str3 = recordConfigProvider.BOA;
        this.GEz.BXx.pO(2);
        fCH();
        m mVar2 = new m(this, str3);
        CaptureDataManager captureDataManager = CaptureDataManager.BOb;
        p.g(captureDataManager, "CaptureDataManager.INSTANCE");
        captureDataManager.getExtData().putInt("SOUND_TRACK_TYPE", 0);
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        AudioCacheInfo audioCacheInfo = aVar.wgG;
        if (audioCacheInfo != null) {
            if (audioCacheInfo.BPb) {
                CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
                Bundle extData = captureDataManager2.getExtData();
                RecordConfigProvider recordConfigProvider2 = this.wdm;
                extData.putString("ORIGIN_MUSIC_ID", (recordConfigProvider2 == null || (bundle5 = recordConfigProvider2.jkf) == null) ? null : bundle5.getString("KEY_ORIGIN_MUSIC_ID"));
                CaptureDataManager captureDataManager3 = CaptureDataManager.BOb;
                p.g(captureDataManager3, "CaptureDataManager.INSTANCE");
                Bundle extData2 = captureDataManager3.getExtData();
                RecordConfigProvider recordConfigProvider3 = this.wdm;
                if (recordConfigProvider3 == null || (bundle4 = recordConfigProvider3.jkf) == null) {
                    str2 = null;
                } else {
                    str2 = bundle4.getString("KEY_ORIGIN_MUSIC_PATH");
                }
                extData2.putString("ORIGIN_MUSIC_PATH", str2);
                CaptureDataManager captureDataManager4 = CaptureDataManager.BOb;
                p.g(captureDataManager4, "CaptureDataManager.INSTANCE");
                Bundle extData3 = captureDataManager4.getExtData();
                RecordConfigProvider recordConfigProvider4 = this.wdm;
                if (recordConfigProvider4 == null || (bundle3 = recordConfigProvider4.jkf) == null) {
                    bArr = null;
                } else {
                    bArr = bundle3.getByteArray("KEY_ORIGIN_MUSIC_INFO");
                }
                extData3.putByteArray("ORIGIN_MUSIC_INFO", bArr);
                RecordConfigProvider recordConfigProvider5 = this.wdm;
                if (recordConfigProvider5 == null || (bundle2 = recordConfigProvider5.jkf) == null) {
                    z = false;
                } else {
                    z = bundle2.getBoolean("KEY_BGM_IF_ORIGIN");
                }
                CaptureDataManager captureDataManager5 = CaptureDataManager.BOb;
                p.g(captureDataManager5, "CaptureDataManager.INSTANCE");
                captureDataManager5.getExtData().putInt("SOUND_TRACK_TYPE", z ? 1 : 2);
            } else {
                byte[] byteArray = audioCacheInfo.BOW.toByteArray();
                CaptureDataManager captureDataManager6 = CaptureDataManager.BOb;
                p.g(captureDataManager6, "CaptureDataManager.INSTANCE");
                captureDataManager6.getExtData().putByteArray("MEDIA_EXTRA_MUSIC", byteArray);
                CaptureDataManager captureDataManager7 = CaptureDataManager.BOb;
                p.g(captureDataManager7, "CaptureDataManager.INSTANCE");
                Bundle extData4 = captureDataManager7.getExtData();
                int i2 = audioCacheInfo.source;
                AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
                extData4.putInt("SOUND_TRACK_TYPE", i2 == AudioCacheInfo.BPn ? 4 : 3);
            }
        }
        CaptureDataManager captureDataManager8 = CaptureDataManager.BOb;
        p.g(captureDataManager8, "CaptureDataManager.INSTANCE");
        Bundle extData5 = captureDataManager8.getExtData();
        RecordConfigProvider recordConfigProvider6 = this.wdm;
        if (recordConfigProvider6 == null || (bundle = recordConfigProvider6.jkf) == null) {
            str = null;
        } else {
            str = bundle.getString("KEY_ORIGIN_BGM_URL");
        }
        extData5.putString("ORIGIN_BGM_URL", str);
        CaptureDataManager captureDataManager9 = CaptureDataManager.BOb;
        p.g(captureDataManager9, "CaptureDataManager.INSTANCE");
        Bundle extData6 = captureDataManager9.getExtData();
        a aVar3 = this.GDN;
        if (aVar3 == null) {
            p.btv("addMusicPlugin");
        }
        if (!aVar3.wgL.getMuteOrigin() && !this.GDU) {
            z2 = false;
        }
        extData6.putBoolean("MEDIA_IS_MUTE", z2);
        CaptureDataManager captureDataManager10 = CaptureDataManager.BOb;
        p.g(captureDataManager10, "CaptureDataManager.INSTANCE");
        Bundle extData7 = captureDataManager10.getExtData();
        a aVar4 = this.GDN;
        if (aVar4 == null) {
            p.btv("addMusicPlugin");
        }
        extData7.putBoolean("MUSIC_IS_MUTE", aVar4.fCv());
        if (!this.GDT.Gyy || this.GEk.fDO()) {
            cWX();
            a aVar5 = this.GDN;
            if (aVar5 == null) {
                p.btv("addMusicPlugin");
            }
            if (aVar5.wgG != null) {
                i.a aVar6 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
                com.tencent.mm.plugin.recordvideo.model.audio.i iVar = com.tencent.mm.plugin.recordvideo.model.audio.i.BPK;
                a aVar7 = this.GDN;
                if (aVar7 == null) {
                    p.btv("addMusicPlugin");
                }
                AudioCacheInfo audioCacheInfo2 = aVar7.wgG;
                if (audioCacheInfo2 == null) {
                    p.hyc();
                }
                iVar.a(audioCacheInfo2, new l(this, mVar2));
                AppMethodBeat.o(190996);
                return;
            }
            b((String) null, mVar2);
            AppMethodBeat.o(190996);
            return;
        }
        b.C1388b bVar = new b.C1388b();
        bVar.ayU(this.GDJ);
        bVar.maxHeight = this.GDH;
        bVar.maxWidth = this.GDG;
        bVar.xkY = 100;
        b.e eVar = new b.e(bVar);
        String[] strArr = new String[this.GDT.Gyv.size()];
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Rect> arrayList2 = new ArrayList<>();
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.TRUE;
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = new CaptureDataManager.CaptureVideoNormalModel(bool, str3, "", 0L, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW());
        CaptureDataManager captureDataManager11 = CaptureDataManager.BOb;
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        captureDataManager11.d(com.tencent.mm.plugin.recordvideo.d.c.eKW());
        La(1);
        a(eVar, strArr, arrayList, arrayList2, captureVideoNormalModel, 0);
        AppMethodBeat.o(190996);
    }

    private final void a(b.e eVar, String[] strArr, ArrayList<String> arrayList, ArrayList<Rect> arrayList2, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, int i2) {
        AppMethodBeat.i(190997);
        z.f fVar = new z.f();
        String str = this.GDT.Gyv.get(i2);
        p.g(str, "multiMedia.pathList[index]");
        fVar.SYG = (T) str;
        if (this.GEF) {
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            if (com.tencent.mm.plugin.vlog.model.local.a.fBR().containsKey(fVar.SYG)) {
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                T t = (T) com.tencent.mm.plugin.vlog.model.local.a.fBR().get(fVar.SYG);
                if (t == null) {
                    t = (T) "";
                }
                p.g(t, "LocalEffectManager.Image…PathMap[sourcePath] ?: \"\"");
                if (com.tencent.mm.vfs.s.YS(t)) {
                    Log.i("MicroMsg.MultiVideoPluginLayout", "generateCropImage enable enhancement, use enhancement result image path:".concat(String.valueOf(t)));
                    fVar.SYG = t;
                }
            }
        }
        this.GDL.c(fVar.SYG, new c(this, fVar, i2, eVar, strArr, arrayList, arrayList2, captureVideoNormalModel));
        AppMethodBeat.o(190997);
    }

    private final void fCC() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(190998);
        Log.i("MicroMsg.MultiVideoPluginLayout", "showImageEditPlugins");
        this.GDX.setVisibility(0);
        r rVar = this.GDY;
        if (rVar == null) {
            p.btv("editPencilPlugin");
        }
        rVar.setVisibility(0);
        this.GDL.setVisibility(0);
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
        if (!(bVar == null || (arrayList = bVar.iqm) == null)) {
            GalleryItem.MediaItem mediaItem = this.tGk.get(0);
            p.g(mediaItem, "mediaList[0]");
            arrayList.add(mediaItem.dRh());
        }
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        aVar.setVisibility(8);
        af afVar = this.GDM;
        if (afVar == null) {
            p.btv("cropVideoPlugin");
        }
        afVar.setVisibility(8);
        this.GDZ.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.m mVar = this.GEe;
        if (mVar == null) {
            p.btv("editCropPlugin");
        }
        mVar.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.o oVar = this.GEf;
        if (oVar == null) {
            p.btv("editMagicPlugin");
        }
        oVar.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar2 = this.GDO;
        if (bVar2 == null) {
            p.btv("captionPlugin");
        }
        bVar2.setVisibility(8);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar = this.BTQ;
        if (cVar == null) {
            p.btv("addTextPlugin");
        }
        cVar.setVisibility(0);
        com.tencent.mm.plugin.recordvideo.plugin.a aVar2 = this.BTN;
        if (aVar2 == null) {
            p.btv("addEmojiPlugin");
        }
        aVar2.setVisibility(0);
        this.GEn.setVisibility(0);
        if (!w.fBt() || this.GDV) {
            this.GEp.setVisibility(8);
            AppMethodBeat.o(190998);
            return;
        }
        this.GEp.setVisibility(0);
        AppMethodBeat.o(190998);
    }

    public static /* synthetic */ void setupImageEditPlugins$default$698160b6(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
        AppMethodBeat.i(191000);
        multiVideoFullScreenPluginLayout.setupImageEditPlugins(true);
        AppMethodBeat.o(191000);
    }

    public void setupImageEditPlugins(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(190999);
        Log.i("MicroMsg.MultiVideoPluginLayout", "setupImageEditPlugins, selectFirst:".concat(String.valueOf(z)));
        this.GEm.setVisibility(0);
        this.GEl.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.stopPreview();
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
        if (eVar2 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar2.fCW();
        this.GDK.GMG.setVisibility(0);
        this.GEv = false;
        this.GEw = false;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
        if (eVar3 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar3.GHe.setStyle(WxCropOperationLayout.j.RECT_ADJUST);
        this.GEy = WxCropOperationLayout.j.RECT_ADJUST;
        fCC();
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
        if (bVar == null) {
            p.hyc();
        }
        a.a(aVar, bVar, this.wdm, !this.GDU);
        if (!z) {
            i2 = this.GDX.fCS();
        }
        this.GDX.select(i2);
        this.GEu = true;
        AppMethodBeat.o(190999);
    }

    private final void fCD() {
        AppMethodBeat.i(191001);
        Log.i("MicroMsg.MultiVideoPluginLayout", "showVideoEditPlugins");
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        aVar.setVisibility(0);
        af afVar = this.GDM;
        if (afVar == null) {
            p.btv("cropVideoPlugin");
        }
        afVar.setVisibility(0);
        this.GDZ.setVisibility(0);
        com.tencent.mm.plugin.vlog.ui.plugin.m mVar = this.GEe;
        if (mVar == null) {
            p.btv("editCropPlugin");
        }
        mVar.setVisibility(0);
        com.tencent.mm.plugin.vlog.ui.plugin.o oVar = this.GEf;
        if (oVar == null) {
            p.btv("editMagicPlugin");
        }
        oVar.setVisibility(0);
        this.GDX.setVisibility(8);
        r rVar = this.GDY;
        if (rVar == null) {
            p.btv("editPencilPlugin");
        }
        rVar.setVisibility(8);
        this.GDL.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar = this.GDO;
        if (bVar == null) {
            p.btv("captionPlugin");
        }
        bVar.setVisibility(0);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar = this.BTQ;
        if (cVar == null) {
            p.btv("addTextPlugin");
        }
        cVar.setVisibility(0);
        com.tencent.mm.plugin.recordvideo.plugin.a aVar2 = this.BTN;
        if (aVar2 == null) {
            p.btv("addEmojiPlugin");
        }
        aVar2.setVisibility(0);
        this.GEn.setVisibility(0);
        this.GEp.setVisibility(8);
        AppMethodBeat.o(191001);
    }

    private final void cEa() {
        AppMethodBeat.i(191002);
        this.GEk.setVisibility(4);
        this.GEn.setVisibility(4);
        this.GEr.setVisibility(4);
        this.zyV.setVisibility(4);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.GHe.setStyle(WxCropOperationLayout.j.RECT_HARD);
        this.GDX.setVisibility(4);
        switch (c.haE[this.GED.ordinal()]) {
            case 1:
                this.GEg.setVisibility(4);
                this.GEi.setVisibility(0);
                break;
        }
        this.GEp.setVisibility(4);
        AppMethodBeat.o(191002);
    }

    private final void fCE() {
        AppMethodBeat.i(191003);
        if (this.GDT.Gyy && !this.GEw) {
            this.GDX.setVisibility(0);
        }
        if (!this.GDT.Gyy) {
            this.GDZ.setVisibility(0);
        } else if (w.fBt() && !this.GDV) {
            this.GEp.setVisibility(0);
        }
        switch (c.uqL[this.GED.ordinal()]) {
            case 1:
                this.GEg.setVisibility(0);
                this.GDZ.setVisibility(0);
                AppMethodBeat.o(191003);
                return;
            default:
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
                if (eVar == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar.GHe.setStyle(this.GEy);
                this.zyV.setVisibility(0);
                this.GEr.setVisibility(0);
                if (!this.GEw) {
                    this.GEn.setVisibility(0);
                }
                AppMethodBeat.o(191003);
                return;
        }
    }

    private final void fCF() {
        AppMethodBeat.i(191004);
        com.tencent.mm.plugin.vlog.model.ad adVar = this.GDT.GyN;
        if (adVar != null) {
            this.GDZ.q(this.GEg.GyM, adVar.GzA.startTimeMs, adVar.GzA.endTimeMs);
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
            if (eVar == null) {
                p.btv("multiPreviewPlugin");
            }
            eVar.at(adVar.GzA.startTimeMs, adVar.GzA.endTimeMs);
            com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
            if (eVar2 == null) {
                p.btv("multiPreviewPlugin");
            }
            eVar2.seek(adVar.GzA.startTimeMs);
            AppMethodBeat.o(191004);
            return;
        }
        AppMethodBeat.o(191004);
    }

    private final void cWX() {
        AppMethodBeat.i(191005);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.fDd();
        this.GDZ.hak.kQ();
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
        if (eVar2 == null) {
            p.btv("multiPreviewPlugin");
        }
        e.AbstractC1868e eVar3 = eVar2.GGU;
        if (eVar3 != null) {
            eVar3.pause();
        }
        this.GEo.fDF();
        this.FHg = true;
        AppMethodBeat.o(191005);
    }

    static /* synthetic */ void a(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, boolean z, boolean z2, long j2, int i2) {
        AppMethodBeat.i(191007);
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            j2 = -1;
        }
        multiVideoFullScreenPluginLayout.b(z, z2, j2);
        AppMethodBeat.o(191007);
    }

    private final void b(boolean z, boolean z2, long j2) {
        AppMethodBeat.i(191006);
        if (!this.GDT.Gyy || this.GEw) {
            if (z) {
                c(true, z2, j2);
            } else {
                if (j2 != -1) {
                    com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
                    if (eVar == null) {
                        p.btv("multiPreviewPlugin");
                    }
                    eVar.seek(j2);
                }
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
                if (eVar2 == null) {
                    p.btv("multiPreviewPlugin");
                }
                eVar2.fDc();
                com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
                if (eVar3 == null) {
                    p.btv("multiPreviewPlugin");
                }
                e.AbstractC1868e eVar4 = eVar3.GGU;
                if (eVar4 != null) {
                    eVar4.resume();
                }
            }
        }
        this.GEo.fDE();
        this.FHg = false;
        AppMethodBeat.o(191006);
    }

    private final void c(boolean z, boolean z2, long j2) {
        AppMethodBeat.i(191008);
        kotlin.o<Long, Long> fBA = this.GDT.GxA.fBA();
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        this.GDT.e(this.GDT.GxA.fBD(), aVar.wgL.getRecordResult(), this.GDK.GMG.getAllTTSData());
        if (!(fBA.first.longValue() == -1 || fBA.second.longValue() == -1)) {
            this.GDT.GxA.at(fBA.first.longValue(), Math.min(fBA.second.longValue(), this.GDT.GxA.Gez.getDurationMs()));
        }
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        a aVar2 = this.GDN;
        if (aVar2 == null) {
            p.btv("addMusicPlugin");
        }
        eVar.a(aVar2.wgL.getMuteOrigin(), z, z2, j2);
        if (z) {
            this.GEo.fDE();
        } else {
            this.GEo.fDF();
        }
        this.FHg = !z;
        AppMethodBeat.o(191008);
    }

    private final void fCG() {
        AppMethodBeat.i(191009);
        Log.i("MicroMsg.MultiVideoPluginLayout", "setupNormalVideoPlugins");
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.h(this.GDT.GyF);
        this.GEm.setVisibility(0);
        this.GEl.setVisibility(8);
        fCD();
        this.GDK.GMG.setVisibility(0);
        this.GDK.fEl();
        this.GDZ.GJn = false;
        this.GEv = true;
        this.GEu = false;
        this.GEw = false;
        this.GDT.Gfd = this.GDF;
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new i(this, null), 2);
        AppMethodBeat.o(191009);
    }

    private final void setupTemplateVideoPlugins(a.c cVar) {
        AppMethodBeat.i(191010);
        Log.i("MicroMsg.MultiVideoPluginLayout", "setupTemplateVideoPlugins, template:".concat(String.valueOf(cVar)));
        this.GEm.setVisibility(4);
        this.GEl.setVisibility(0);
        this.GDX.setVisibility(8);
        this.GEg.setVisibility(8);
        a aVar = this.GDN;
        if (aVar == null) {
            p.btv("addMusicPlugin");
        }
        aVar.onPause();
        Log.i("MicroMsg.MultiVideoPluginLayout", "showTemplateEditPlugins");
        a aVar2 = this.GDN;
        if (aVar2 == null) {
            p.btv("addMusicPlugin");
        }
        aVar2.setVisibility(8);
        af afVar = this.GDM;
        if (afVar == null) {
            p.btv("cropVideoPlugin");
        }
        afVar.setVisibility(8);
        this.GDZ.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.m mVar = this.GEe;
        if (mVar == null) {
            p.btv("editCropPlugin");
        }
        mVar.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.o oVar = this.GEf;
        if (oVar == null) {
            p.btv("editMagicPlugin");
        }
        oVar.setVisibility(8);
        this.GDX.setVisibility(8);
        r rVar = this.GDY;
        if (rVar == null) {
            p.btv("editPencilPlugin");
        }
        rVar.setVisibility(8);
        this.GDL.setVisibility(8);
        com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar = this.GDO;
        if (bVar == null) {
            p.btv("captionPlugin");
        }
        bVar.setVisibility(8);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar2 = this.BTQ;
        if (cVar2 == null) {
            p.btv("addTextPlugin");
        }
        cVar2.setVisibility(8);
        com.tencent.mm.plugin.recordvideo.plugin.a aVar3 = this.BTN;
        if (aVar3 == null) {
            p.btv("addEmojiPlugin");
        }
        aVar3.setVisibility(8);
        this.GEn.setVisibility(0);
        this.GEp.setVisibility(8);
        this.GDK.GMG.setVisibility(4);
        this.GDK.fEl();
        boolean z = this.GEw;
        this.GEv = false;
        this.GEu = false;
        this.GEw = true;
        setBackgroundColor(this.GEE);
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
        if (eVar == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar.GHe.setStyle(WxCropOperationLayout.j.RECT_LINE_HARD);
        this.GEy = WxCropOperationLayout.j.RECT_LINE_HARD;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar2 = this.GDW;
        if (eVar2 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar2.fCX();
        this.GDT.Gfd = this.GDF;
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar3 = this.GDW;
        if (eVar3 == null) {
            p.btv("multiPreviewPlugin");
        }
        RectF rectF = eVar3.GyG;
        com.tencent.mm.plugin.recordvideo.background.e eVar4 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        rectF.round(com.tencent.mm.plugin.recordvideo.background.e.eIS());
        com.tencent.mm.plugin.vlog.ui.plugin.e eVar5 = this.GDW;
        if (eVar5 == null) {
            p.btv("multiPreviewPlugin");
        }
        eVar5.h(rectF);
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new j(this, cVar, z, null), 2);
        AppMethodBeat.o(191010);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/ui/MultiVideoFullScreenPluginLayout$statusChange$10$1"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        final /* synthetic */ GalleryItem.MediaItem GFo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(GalleryItem.MediaItem mediaItem, MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout) {
            super(0);
            this.GFo = mediaItem;
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(190984);
            MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout = this.GEJ;
            String dRh = this.GFo.dRh();
            p.g(dRh, "originalPath");
            multiVideoFullScreenPluginLayout.msl = dRh;
            String str = this.GEJ.msl;
            if (this.GEJ.GEF) {
                com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                if (com.tencent.mm.plugin.vlog.model.local.a.fBR().containsKey(this.GFo.dRh())) {
                    StringBuilder sb = new StringBuilder("update select image path to image enhancement result path: ");
                    com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    Log.i("MicroMsg.MultiVideoPluginLayout", sb.append(com.tencent.mm.plugin.vlog.model.local.a.fBR().get(this.GFo.dRh())).toString());
                    com.tencent.mm.plugin.vlog.model.local.a aVar3 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    str = com.tencent.mm.plugin.vlog.model.local.a.fBR().get(this.GFo.dRh());
                    if (str == null) {
                        str = this.GFo.dRh();
                        p.g(str, "originalPath");
                    }
                }
            }
            com.tencent.mm.view.m aUl = this.GEJ.GDL.aUl(str);
            this.GEJ.GEd.jH("start", "get photo view");
            com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a aVar4 = this.GEJ.GDK;
            String dRh2 = this.GFo.dRh();
            p.g(dRh2, "originalPath");
            aVar4.aUo(dRh2);
            com.tencent.mm.plugin.vlog.ui.plugin.e multiPreviewPlugin = this.GEJ.getMultiPreviewPlugin();
            GalleryItem.MediaItem mediaItem = this.GFo;
            p.g(mediaItem, "this");
            String dRh3 = mediaItem.dRh();
            p.g(dRh3, "this.originalPath");
            multiPreviewPlugin.a(aUl, dRh3);
            s sVar = this.GEJ.GEq;
            GalleryItem.MediaItem mediaItem2 = this.GFo;
            p.g(mediaItem2, "this");
            String dRh4 = mediaItem2.dRh();
            p.g(dRh4, "this.originalPath");
            p.h(dRh4, "thumbPath");
            sVar.thumbPath = dRh4;
            Context context = this.GEJ.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(190984);
                throw tVar;
            }
            Window window = ((Activity) context).getWindow();
            p.g(window, "(context as Activity).window");
            View findViewById = window.getDecorView().findViewById(16908290);
            p.g(findViewById, "(context as Activity).wi…up>(android.R.id.content)");
            ((ViewGroup) findViewById).setAlpha(1.0f);
            this.GEJ.GDQ.hideLoading();
            MultiVideoFullScreenPluginLayout.E(this.GEJ);
            this.GEJ.setBackgroundColor(this.GEJ.GEE);
            this.GEJ.setCurrentStyle(this.GEJ.getMultiPreviewPlugin().GHe.getStyle());
            this.GEJ.GEd.jH("start", "load first image");
            this.GEJ.GEk.wI(true);
            this.GEJ.GEq.fDy();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(190984);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011e, code lost:
        if (r0.iqf != true) goto L_0x0123;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(java.lang.String r14, kotlin.g.a.q<? super java.lang.Boolean, ? super com.tencent.mm.protocal.protobuf.acn, ? super android.graphics.Bitmap, kotlin.x> r15) {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.b(java.lang.String, kotlin.g.a.q):void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout$setupNormalVideoPlugins$1", f = "MultiVideoFullScreenPluginLayout.kt", hxM = {1974}, m = "invokeSuspend")
    public static final class i extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
        Object L$0;
        int label;
        private kotlinx.coroutines.ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, kotlin.d.d dVar) {
            super(2, dVar);
            this.GEJ = multiVideoFullScreenPluginLayout;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(190971);
            p.h(dVar, "completion");
            i iVar = new i(this.GEJ, dVar);
            iVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(190971);
            return iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(190972);
            Object invokeSuspend = ((i) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(190972);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(190970);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.ai aiVar = this.p$;
                    this.GEJ.GDT.fBp();
                    w.fBs();
                    MultiVideoFullScreenPluginLayout.c(this.GEJ).fCw();
                    if (this.GEJ.GEn.fDS()) {
                        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        com.tencent.mm.plugin.vlog.model.local.a.b(this.GEJ.GDT.GxA, true);
                    }
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (kotlinx.coroutines.g.a(ba.hMV(), new kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object>(this, null) {
                        /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.i.AnonymousClass1 */
                        final /* synthetic */ i GFi;
                        int label;
                        private kotlinx.coroutines.ai p$;

                        {
                            this.GFi = r2;
                        }

                        @Override // kotlin.d.b.a.a
                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                            AppMethodBeat.i(190968);
                            p.h(dVar, "completion");
                            AnonymousClass1 r0 = 

                            /* access modifiers changed from: package-private */
                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
                            @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout$setupTemplateVideoPlugins$1", f = "MultiVideoFullScreenPluginLayout.kt", hxM = {2032}, m = "invokeSuspend")
                            public static final class j extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object> {
                                final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
                                final /* synthetic */ a.c GFj;
                                final /* synthetic */ boolean GFk;
                                Object L$0;
                                int label;
                                private kotlinx.coroutines.ai p$;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                j(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, a.c cVar, boolean z, kotlin.d.d dVar) {
                                    super(2, dVar);
                                    this.GEJ = multiVideoFullScreenPluginLayout;
                                    this.GFj = cVar;
                                    this.GFk = z;
                                }

                                @Override // kotlin.d.b.a.a
                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                    AppMethodBeat.i(190977);
                                    p.h(dVar, "completion");
                                    j jVar = new j(this.GEJ, this.GFj, this.GFk, dVar);
                                    jVar.p$ = (kotlinx.coroutines.ai) obj;
                                    AppMethodBeat.o(190977);
                                    return jVar;
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                                @Override // kotlin.g.a.m
                                public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
                                    AppMethodBeat.i(190978);
                                    Object invokeSuspend = ((j) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
                                    AppMethodBeat.o(190978);
                                    return invokeSuspend;
                                }

                                @Override // kotlin.d.b.a.a
                                public final Object invokeSuspend(Object obj) {
                                    AppMethodBeat.i(190976);
                                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure(obj);
                                            kotlinx.coroutines.ai aiVar = this.p$;
                                            this.GEJ.getMultiPreviewPlugin().fCV();
                                            this.GEJ.GDT.c(this.GFj);
                                            this.GEJ.GDT.acx(-1);
                                            com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                                            com.tencent.mm.plugin.vlog.model.local.a.a(this.GFj, new long[0]);
                                            this.L$0 = aiVar;
                                            this.label = 1;
                                            if (kotlinx.coroutines.g.a(ba.hMV(), new kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object>(this, null) {
                                                /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.j.AnonymousClass1 */
                                                final /* synthetic */ j GFl;
                                                int label;
                                                private kotlinx.coroutines.ai p$;

                                                {
                                                    this.GFl = r2;
                                                }

                                                @Override // kotlin.d.b.a.a
                                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                    AppMethodBeat.i(190974);
                                                    p.h(dVar, "completion");
                                                    AnonymousClass1 r0 = 

                                                    private final void fCH() {
                                                        int i2;
                                                        int i3;
                                                        int i4 = 0;
                                                        AppMethodBeat.i(191012);
                                                        this.GEz.BXx.pM((long) this.GDZ.GJi);
                                                        gd gdVar = this.GEz.BXx;
                                                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
                                                        if (eVar == null) {
                                                            p.btv("multiPreviewPlugin");
                                                        }
                                                        gdVar.pL((long) eVar.GGO);
                                                        this.GEz.BXx.pN(this.GDT.GxA.Gez.getSourceDuration() > Util.MILLSECONDS_OF_MINUTE ? 1 : 0);
                                                        this.GEz.BXx.tC(this.GDK.u(this.GDT.GxA.fBD(), this.GDT.Gyy));
                                                        this.GEz.BXx.tD(this.GDK.v(this.GDT.GxA.fBD(), this.GDT.Gyy));
                                                        if (!this.GDT.Gyy) {
                                                            gd gdVar2 = this.GEz.BXx;
                                                            com.tencent.mm.plugin.vlog.ui.plugin.caption.b bVar = this.GDO;
                                                            if (bVar == null) {
                                                                p.btv("captionPlugin");
                                                            }
                                                            gdVar2.tB(bVar.fDU());
                                                            this.GEz.BXx.tE(this.GDT.GxA.fBE());
                                                            this.GEz.BXx.tF(this.GDT.GxA.fBF());
                                                        }
                                                        com.tencent.mm.plugin.recordvideo.d.b bVar2 = this.GEz;
                                                        LinkedList<com.tencent.mm.plugin.vlog.model.ad> linkedList = this.GDT.Gyx;
                                                        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
                                                        Iterator<T> it = linkedList.iterator();
                                                        while (it.hasNext()) {
                                                            arrayList.add(it.next().Gzz);
                                                        }
                                                        bVar2.l(arrayList, this.GDT.Gyy);
                                                        StringBuilder append = new StringBuilder("reportEdit19904, isVideoEnhancementEnable:").append(this.GEF).append(", VideoTrackLabel:");
                                                        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                                                        Log.i("MicroMsg.MultiVideoPluginLayout", append.append(com.tencent.mm.plugin.vlog.model.local.a.fBS()).toString());
                                                        com.tencent.mm.plugin.recordvideo.d.b bVar3 = this.GEz;
                                                        boolean z = this.GEF;
                                                        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                                                        bVar3.a(z, com.tencent.mm.plugin.vlog.model.local.a.fBS());
                                                        this.GEz.report();
                                                        this.GEz.reset();
                                                        if (this.GDT.Gyx.size() == 1) {
                                                            i2 = 0;
                                                        } else if (this.GDT.Gyz) {
                                                            i2 = 2;
                                                        } else if (this.GDT.Gyy && this.GDT.fBq()) {
                                                            i2 = 1;
                                                        } else if (this.GDT.Gyy) {
                                                            i2 = 0;
                                                        } else {
                                                            i2 = 3;
                                                        }
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(this.GDK.eKu()));
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(this.GDK.eKv()));
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        a aVar3 = this.GDN;
                                                        if (aVar3 == null) {
                                                            p.btv("addMusicPlugin");
                                                        }
                                                        if (aVar3.wgG == null) {
                                                            i3 = 0;
                                                        } else {
                                                            i3 = 1;
                                                        }
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(i3));
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        a aVar4 = this.GDN;
                                                        if (aVar4 == null) {
                                                            p.btv("addMusicPlugin");
                                                        }
                                                        if (!aVar4.wgL.getMuteOrigin()) {
                                                            i4 = 1;
                                                        }
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i4));
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", 1);
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MULTI_MEDIA_POST_ID_STRING", this.postId);
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MULTI_MEDIA_EDIT_ID_STRING", this.editId);
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(i2));
                                                        AppMethodBeat.o(191012);
                                                    }

                                                    private final void KZ(long j2) {
                                                        AppMethodBeat.i(191013);
                                                        com.tencent.mm.ac.d.b("MultiVideoPluginLayout_report", new g(this, j2));
                                                        AppMethodBeat.o(191013);
                                                    }

                                                    private final void La(long j2) {
                                                        long j3;
                                                        long j4 = 1;
                                                        AppMethodBeat.i(191014);
                                                        Log.i("MicroMsg.MultiVideoPluginLayout", "reportEdit20741Image, isVideoEnhancementEnable:" + this.GEF);
                                                        if (this.GEx) {
                                                            j3 = 1;
                                                        } else {
                                                            j3 = 4;
                                                        }
                                                        com.tencent.mm.plugin.vlog.model.report.d dVar = new com.tencent.mm.plugin.vlog.model.report.d();
                                                        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> editorDataList = this.GDK.GMG.getEditorDataList();
                                                        dVar.GBi.tH(this.editId);
                                                        dVar.GBi.pW((long) NetStatusUtil.getIOSNetType(getContext()));
                                                        dVar.GBi.ln(2);
                                                        dVar.GBi.pQ((long) this.GDT.Gyv.size());
                                                        dVar.KU(j3);
                                                        dVar.hR(editorDataList);
                                                        dVar.KT(j2);
                                                        ge geVar = dVar.GBi;
                                                        if (!this.GEF) {
                                                            j4 = 0;
                                                        }
                                                        geVar.pV(j4);
                                                        dVar.report();
                                                        AppMethodBeat.o(191014);
                                                    }

                                                    private final void fCI() {
                                                        long j2;
                                                        dj djVar;
                                                        int i2;
                                                        long j3 = 0;
                                                        int i3 = 0;
                                                        AppMethodBeat.i(191015);
                                                        com.tencent.mm.plugin.vlog.report.a aVar = com.tencent.mm.plugin.vlog.report.a.GDl;
                                                        dj fCt = com.tencent.mm.plugin.vlog.report.a.fCt();
                                                        fCt.oI(this.postId);
                                                        fCt.oJ(this.editId);
                                                        fCt.jB((long) this.GEC);
                                                        if (this.GDT.Gyy) {
                                                            ArrayList<GalleryItem.MediaItem> arrayList = this.tGk;
                                                            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                                                                Iterator<T> it = arrayList.iterator();
                                                                int i4 = 0;
                                                                while (it.hasNext()) {
                                                                    if (it.next() instanceof GalleryItem.ImageMediaItem) {
                                                                        i2 = i4 + 1;
                                                                        if (i2 < 0) {
                                                                            kotlin.a.j.hxI();
                                                                        }
                                                                    } else {
                                                                        i2 = i4;
                                                                    }
                                                                    i4 = i2;
                                                                }
                                                                i3 = i4;
                                                            }
                                                            j2 = (long) i3;
                                                            djVar = fCt;
                                                        } else {
                                                            j2 = 0;
                                                            djVar = fCt;
                                                        }
                                                        djVar.jC(j2);
                                                        if (!this.GDT.Gyy) {
                                                            j3 = this.GDT.GxA.Gez.getDurationMs();
                                                        }
                                                        fCt.jD(j3);
                                                        fCt.jE(2);
                                                        fCt.jF(1);
                                                        fCt.bfK();
                                                        AppMethodBeat.o(191015);
                                                    }

                                                    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
                                                    public final void reset() {
                                                        AppMethodBeat.i(191016);
                                                        super.reset();
                                                        this.GEy = WxCropOperationLayout.j.RECT_ADJUST;
                                                        setBackgroundColor(0);
                                                        com.tencent.mm.plugin.vlog.model.local.a.GAD.reset();
                                                        AppMethodBeat.o(191016);
                                                    }

                                                    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
                                                    public final boolean onBackPress() {
                                                        AppMethodBeat.i(191017);
                                                        if (!super.onBackPress()) {
                                                            com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
                                                            if (eVar == null) {
                                                                p.btv("multiPreviewPlugin");
                                                            }
                                                            eVar.stopPreview();
                                                            com.tencent.mm.plugin.recordvideo.activity.a aVar = this.wdl;
                                                            if (aVar != null) {
                                                                a.C1633a.a(aVar);
                                                            }
                                                        }
                                                        this.GEz.BXx.pO(1);
                                                        fCH();
                                                        if (!this.GDT.Gyy || this.GEk.fDO()) {
                                                            KZ(0);
                                                        } else {
                                                            La(0);
                                                        }
                                                        CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                                                        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                                                        captureDataManager.d(com.tencent.mm.plugin.recordvideo.d.c.eKW());
                                                        AppMethodBeat.o(191017);
                                                        return true;
                                                    }

                                                    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
                                                    public final void release() {
                                                        AppMethodBeat.i(191018);
                                                        super.release();
                                                        Log.i("MicroMsg.MultiVideoPluginLayout", "release");
                                                        this.GDT.dead();
                                                        com.tencent.mm.plugin.vlog.model.local.a.GAD.unInit();
                                                        com.tencent.mm.emoji.b.b.q qVar = com.tencent.mm.emoji.b.b.q.gYK;
                                                        com.tencent.mm.emoji.b.b.q.pj(com.tencent.mm.plugin.vlog.model.panel.b.fCc());
                                                        com.tencent.mm.videocomposition.i.Rhj.clear();
                                                        AppMethodBeat.o(191018);
                                                    }

                                                    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
                                                    public final void onDetach() {
                                                        AppMethodBeat.i(191019);
                                                        super.onDetach();
                                                        Log.i("MicroMsg.MultiVideoPluginLayout", "onDetach");
                                                        com.tencent.mm.plugin.vlog.ui.plugin.e eVar = this.GDW;
                                                        if (eVar == null) {
                                                            p.btv("multiPreviewPlugin");
                                                        }
                                                        eVar.fDe();
                                                        this.GDE.setVisibility(4);
                                                        com.tencent.mm.plugin.vlog.model.local.a.GAD.reset();
                                                        this.GEn.GJN.cancel();
                                                        AppMethodBeat.o(191019);
                                                    }

                                                    /* access modifiers changed from: package-private */
                                                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                                                    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
                                                        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
                                                        final /* synthetic */ ArrayList GEK;
                                                        final /* synthetic */ com.tencent.mm.plugin.vlog.model.g GEL;
                                                        final /* synthetic */ String GEM;
                                                        final /* synthetic */ Size GEN;
                                                        final /* synthetic */ Rect GEO;
                                                        final /* synthetic */ Rect GEP;
                                                        final /* synthetic */ z.f GEQ;
                                                        final /* synthetic */ boolean GER;
                                                        final /* synthetic */ com.tencent.mm.plugin.vlog.model.ac Gxp;
                                                        final /* synthetic */ kotlin.g.a.q pDc;

                                                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                                        b(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, ArrayList arrayList, com.tencent.mm.plugin.vlog.model.ac acVar, com.tencent.mm.plugin.vlog.model.g gVar, String str, Size size, Rect rect, Rect rect2, z.f fVar, boolean z, kotlin.g.a.q qVar) {
                                                            super(0);
                                                            this.GEJ = multiVideoFullScreenPluginLayout;
                                                            this.GEK = arrayList;
                                                            this.Gxp = acVar;
                                                            this.GEL = gVar;
                                                            this.GEM = str;
                                                            this.GEN = size;
                                                            this.GEO = rect;
                                                            this.GEP = rect2;
                                                            this.GEQ = fVar;
                                                            this.GER = z;
                                                            this.pDc = qVar;
                                                        }

                                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                                        @Override // kotlin.g.a.a
                                                        public final /* synthetic */ kotlin.x invoke() {
                                                            boolean z = true;
                                                            AppMethodBeat.i(190952);
                                                            MultiVideoFullScreenPluginLayout.L(this.GEJ);
                                                            com.tencent.mm.plugin.vlog.model.report.a aVar = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                                                            com.tencent.mm.plugin.vlog.model.report.a.hQ(this.GEK);
                                                            com.tencent.mm.plugin.vlog.model.report.a aVar2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                                                            com.tencent.mm.plugin.vlog.model.report.a.a(this.Gxp);
                                                            if (this.GEJ.GEx) {
                                                                com.tencent.mm.plugin.vlog.model.report.a aVar3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                                                                com.tencent.mm.plugin.vlog.model.report.a.report(116);
                                                                AudioCacheInfo audioCacheInfo = MultiVideoFullScreenPluginLayout.c(this.GEJ).wgG;
                                                                if (audioCacheInfo != null && audioCacheInfo.BPb) {
                                                                    com.tencent.mm.plugin.vlog.model.report.a aVar4 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                                                                    com.tencent.mm.plugin.vlog.model.report.a.report(117);
                                                                }
                                                            }
                                                            com.tencent.mm.plugin.vlog.model.g gVar = this.GEL;
                                                            String str = this.GEM;
                                                            p.g(str, "outPath");
                                                            RecordConfigProvider recordConfigProvider = this.GEJ.wdm;
                                                            if (recordConfigProvider == null) {
                                                                p.hyc();
                                                            }
                                                            VideoTransPara videoTransPara = recordConfigProvider.BOm;
                                                            p.g(videoTransPara, "configProvider!!.videoParam");
                                                            Size size = this.GEN;
                                                            Rect rect = this.GEO;
                                                            if (this.GEJ.GEq.GHR) {
                                                                z = false;
                                                            }
                                                            com.tencent.mm.plugin.vlog.model.g.a(gVar, str, videoTransPara, size, rect, z, 16);
                                                            this.GEL.a(this.GEP, (float[]) this.GEQ.SYG, this.GEK);
                                                            this.GEL.hM(MultiVideoFullScreenPluginLayout.M(this.GEJ).GHB.GAo);
                                                            if (this.GEJ.GEw) {
                                                                this.GEL.a(this.GEJ.GEl.GIr.fDN());
                                                            }
                                                            final acn fAQ = this.GEL.fAQ();
                                                            fAQ.editId = this.GEJ.editId;
                                                            com.tencent.mm.plugin.vlog.ui.plugin.e multiPreviewPlugin = this.GEJ.getMultiPreviewPlugin();
                                                            fAQ.Lnk = !p.j(multiPreviewPlugin.fDa(), multiPreviewPlugin.GGR);
                                                            if (this.GER) {
                                                                if (this.GEJ.GEq.GHR) {
                                                                    Rect rect2 = new Rect();
                                                                    dlh dlh = fAQ.Gxw.Lnm;
                                                                    p.g(dlh, "compositionInfo.outputConfig.originRect");
                                                                    com.tencent.mm.plugin.vlog.model.i.a(dlh, rect2);
                                                                    this.Gxp.q(rect2);
                                                                }
                                                                final com.tencent.mm.plugin.recordvideo.ui.editor.b.c d2 = com.tencent.mm.plugin.vlog.model.i.d(fAQ);
                                                                d2.start();
                                                                this.Gxp.O(d2);
                                                                this.Gxp.c(fAQ.Gxw.targetWidth, new kotlin.g.a.b<Bitmap, kotlin.x>(this) {
                                                                    /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.b.AnonymousClass1 */
                                                                    final /* synthetic */ b GES;

                                                                    {
                                                                        this.GES = r2;
                                                                    }

                                                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                                    @Override // kotlin.g.a.b
                                                                    public final /* synthetic */ kotlin.x invoke(Bitmap bitmap) {
                                                                        AppMethodBeat.i(190949);
                                                                        final Bitmap bitmap2 = bitmap;
                                                                        d2.destroy();
                                                                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                                                                            /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.b.AnonymousClass1.AnonymousClass1 */
                                                                            final /* synthetic */ AnonymousClass1 GEU;

                                                                            {
                                                                                this.GEU = r2;
                                                                            }

                                                                            /* Return type fixed from 'java.lang.Object' to match base method */
                                                                            @Override // kotlin.g.a.a
                                                                            public final /* synthetic */ kotlin.x invoke() {
                                                                                AppMethodBeat.i(190948);
                                                                                this.GEU.GES.pDc.d(Boolean.TRUE, fAQ, bitmap2);
                                                                                kotlin.x xVar = kotlin.x.SXb;
                                                                                AppMethodBeat.o(190948);
                                                                                return xVar;
                                                                            }
                                                                        });
                                                                        kotlin.x xVar = kotlin.x.SXb;
                                                                        AppMethodBeat.o(190949);
                                                                        return xVar;
                                                                    }
                                                                });
                                                            } else {
                                                                com.tencent.mm.plugin.vlog.model.f fVar = new com.tencent.mm.plugin.vlog.model.f();
                                                                fVar.Gxj = false;
                                                                RecordConfigProvider recordConfigProvider2 = this.GEJ.wdm;
                                                                if (recordConfigProvider2 == null) {
                                                                    p.hyc();
                                                                }
                                                                VideoTransPara videoTransPara2 = recordConfigProvider2.BOm;
                                                                p.g(videoTransPara2, "configProvider!!.videoParam");
                                                                fVar.r(videoTransPara2);
                                                                fVar.a(fAQ, new kotlin.g.a.b<Boolean, kotlin.x>(this) {
                                                                    /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.b.AnonymousClass2 */
                                                                    final /* synthetic */ b GES;

                                                                    {
                                                                        this.GES = r2;
                                                                    }

                                                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                                    @Override // kotlin.g.a.b
                                                                    public final /* synthetic */ kotlin.x invoke(Boolean bool) {
                                                                        AppMethodBeat.i(190951);
                                                                        final boolean booleanValue = bool.booleanValue();
                                                                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                                                                            /* class com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout.b.AnonymousClass2.AnonymousClass1 */
                                                                            final /* synthetic */ AnonymousClass2 GEV;

                                                                            {
                                                                                this.GEV = r2;
                                                                            }

                                                                            /* Return type fixed from 'java.lang.Object' to match base method */
                                                                            @Override // kotlin.g.a.a
                                                                            public final /* synthetic */ kotlin.x invoke() {
                                                                                AppMethodBeat.i(190950);
                                                                                this.GEV.GES.pDc.d(Boolean.valueOf(booleanValue), null, null);
                                                                                kotlin.x xVar = kotlin.x.SXb;
                                                                                AppMethodBeat.o(190950);
                                                                                return xVar;
                                                                            }
                                                                        });
                                                                        kotlin.x xVar = kotlin.x.SXb;
                                                                        AppMethodBeat.o(190951);
                                                                        return xVar;
                                                                    }
                                                                });
                                                            }
                                                            kotlin.x xVar = kotlin.x.SXb;
                                                            AppMethodBeat.o(190952);
                                                            return xVar;
                                                        }
                                                    }

                                                    /* access modifiers changed from: package-private */
                                                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                                                    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
                                                        final /* synthetic */ MultiVideoFullScreenPluginLayout GEJ;
                                                        final /* synthetic */ long GFd;

                                                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                                        g(MultiVideoFullScreenPluginLayout multiVideoFullScreenPluginLayout, long j2) {
                                                            super(0);
                                                            this.GEJ = multiVideoFullScreenPluginLayout;
                                                            this.GFd = j2;
                                                        }

                                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                                        @Override // kotlin.g.a.a
                                                        public final /* synthetic */ kotlin.x invoke() {
                                                            long j2 = 1;
                                                            AppMethodBeat.i(190960);
                                                            long j3 = this.GEJ.GEx ? 1 : 4;
                                                            com.tencent.mm.plugin.vlog.model.report.d dVar = new com.tencent.mm.plugin.vlog.model.report.d();
                                                            ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> editorDataList = this.GEJ.GDK.GMG.getEditorDataList();
                                                            com.tencent.mm.plugin.vlog.model.ac acVar = this.GEJ.GDT.GxA;
                                                            dVar.GBi.tH(this.GEJ.editId);
                                                            dVar.GBi.pW((long) NetStatusUtil.getIOSNetType(this.GEJ.getContext()));
                                                            dVar.KU(j3);
                                                            dVar.hR(editorDataList);
                                                            dVar.b(acVar);
                                                            ge geVar = dVar.GBi;
                                                            if (MultiVideoFullScreenPluginLayout.c(this.GEJ).wgG == null) {
                                                                j2 = 0;
                                                            }
                                                            geVar.pS(j2);
                                                            com.tencent.mm.plugin.vlog.ui.report.a aVar = this.GEJ.getMultiPreviewPlugin().GGM;
                                                            dVar.GBi.tJ(aVar.agM());
                                                            dVar.GBi.tK(aVar.fEt());
                                                            StringBuilder sb = new StringBuilder();
                                                            if (!TextUtils.isEmpty(dVar.GBi.agM())) {
                                                                for (T t : acVar.Gzn) {
                                                                    if (t.type == 2) {
                                                                        StringBuilder sb2 = new StringBuilder();
                                                                        com.tencent.mm.plugin.vlog.util.a aVar2 = com.tencent.mm.plugin.vlog.util.a.GQC;
                                                                        sb.append(sb2.append(com.tencent.mm.plugin.vlog.util.a.aUr(t.path)).append('#').toString());
                                                                    }
                                                                }
                                                            }
                                                            dVar.GBi.tL(sb.toString());
                                                            dVar.KT(this.GFd);
                                                            dVar.report();
                                                            kotlin.x xVar = kotlin.x.SXb;
                                                            AppMethodBeat.o(190960);
                                                            return xVar;
                                                        }
                                                    }
                                                }
