package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.j;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0001\u0018\u0000 ã\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002ã\u0001B\u0005¢\u0006\u0002\u0010\u0005J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010dH\u0002J\t\u0010\u0001\u001a\u00020\u0015H\u0014J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\u00152\b\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u0001H\u0002J\t\u0010¥\u0001\u001a\u00020\"H\u0016J\t\u0010¦\u0001\u001a\u00020\"H\u0014J\u0013\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010©\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010ª\u0001\u001a\u00020\u0002H\u0016J\t\u0010«\u0001\u001a\u00020\u0004H\u0016J\t\u0010¬\u0001\u001a\u00020\"H\u0016J-\u0010­\u0001\u001a\u00020P2\u0007\u0010®\u0001\u001a\u00020P2\u0007\u0010¯\u0001\u001a\u00020\"2\u0007\u0010°\u0001\u001a\u00020\"2\u0007\u0010±\u0001\u001a\u00020\"H\u0002J\u0012\u0010²\u0001\u001a\u00020\"2\u0007\u0010³\u0001\u001a\u00020dH\u0002J\t\u0010´\u0001\u001a\u00020\u0003H\u0016J\n\u0010µ\u0001\u001a\u00030\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010·\u0001\u001a\u0015\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030º\u00010¹\u0001\u0018\u00010¸\u0001H\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0014J\b\u0010¼\u0001\u001a\u00030\u0001J\n\u0010½\u0001\u001a\u00030\u0001H\u0002J\n\u0010¾\u0001\u001a\u00030\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030\u0001H\u0002J\t\u0010À\u0001\u001a\u00020\u0015H\u0002J\u0015\u0010\u0001\u001a\u00020\u00152\n\u0010Á\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010Â\u0001\u001a\u00020\u0015H\u0016J\t\u0010Ã\u0001\u001a\u00020\u0015H\u0016J\t\u0010Ä\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010³\u0001\u001a\u00020dH\u0002J\n\u0010Æ\u0001\u001a\u00030\u0001H\u0016J\u0016\u0010Ç\u0001\u001a\u00030\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001H\u0016J\n\u0010Ê\u0001\u001a\u00030\u0001H\u0014J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0014J\n\u0010Ì\u0001\u001a\u00030\u0001H\u0014J\n\u0010Í\u0001\u001a\u00030\u0001H\u0014J\n\u0010Î\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Ï\u0001\u001a\u00030\u00012\u0007\u0010Ð\u0001\u001a\u00020\u0015H\u0002J1\u0010Ñ\u0001\u001a\u00030\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020d2\u0007\u0010Õ\u0001\u001a\u00020d2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010HH\u0002J/\u0010×\u0001\u001a\u00030\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020d2\u0007\u0010Õ\u0001\u001a\u00020d2\u0007\u0010Ö\u0001\u001a\u00020HH\u0002J\u0013\u0010Ø\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0016\u0010Ù\u0001\u001a\u00030\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010Ù\u0001\u001a\u00030\u00012\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0007H\u0002J\u0015\u0010Û\u0001\u001a\u00020\u00152\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0002J\u0016\u0010Þ\u0001\u001a\u00030\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0011\u0010ß\u0001\u001a\u00030\u00012\u0007\u0010à\u0001\u001a\u00020\u0015J\u0011\u0010á\u0001\u001a\u00030\u00012\u0007\u0010à\u0001\u001a\u00020\u0015J\n\u0010â\u0001\u001a\u00030\u0001H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b'\u0010$R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u00101R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\u001f\u001a\u0004\b=\u0010>R\u0010\u0010@\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u00101R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0017\"\u0004\bK\u0010\u0019R\u000e\u0010L\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00108\"\u0004\bX\u0010:R\u000e\u0010Y\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Z\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b\\\u0010\u001f\u001a\u0004\b[\u0010$R\u000e\u0010]\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0017\"\u0004\bb\u0010\u0019R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010$\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010$\"\u0004\bl\u0010iR\u001a\u0010m\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010$\"\u0004\bo\u0010iR\u001a\u0010p\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010$\"\u0004\br\u0010iR\u001c\u0010s\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\t\"\u0004\bu\u00101R\u001a\u0010v\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0017\"\u0004\bx\u0010\u0019R\u000e\u0010y\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010z\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0017\"\u0004\b|\u0010\u0019R\u001a\u0010}\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0017\"\u0004\b\u0010\u0019R\u001d\u0010\u0001\u001a\u00020\u0015X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0017\"\u0005\b\u0001\u0010\u0019R\u001e\u0010\u0001\u001a\u00020\"8FX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\u001f\u001a\u0005\b\u0001\u0010$R\u000f\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020dX.¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\"XD¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010iR\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006ä\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCoverImage", "Lcom/tencent/mm/view/NinePatchCropImageView;", "animCoverLayout", "Landroid/widget/FrameLayout;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "checkExposeTaskAdded", "", "getCheckExposeTaskAdded", "()Z", "setCheckExposeTaskAdded", "(Z)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "contentUI", "defaultCommentScene", "", "getDefaultCommentScene", "()I", "defaultCommentScene$delegate", "detailCommentScene", "getDetailCommentScene", "detailCommentScene$delegate", "dismissPopupTipsRunnable", "Ljava/lang/Runnable;", "distance", "doShowAfterEnter", "enableAnimation", "encryptedFeedId", "getEncryptedFeedId", "setEncryptedFeedId", "(Ljava/lang/String;)V", "feedContactChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "followChangeEvent", "followStatus", "fromAnimateKey", "fromImageUrl", "fromUser", "getFromUser", "setFromUser", "fromViewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "isFromAd", "isPostingScene", "setPostingScene", "isShareClickReport", "isTipsFirstShown", "isTitleShowed", "lastY", "", "getLastY", "()F", "setLastY", "(F)V", "loader", "localFeedId", "getLocalFeedId", "setLocalFeedId", "ninePatchId", "parentBottom", "getParentBottom", "parentBottom$delegate", "playingEnterAnimation", "playingExitAnimation", "playingShowAnimation", "popupTipsExposed", "getPopupTipsExposed", "setPopupTipsExposed", "popupTipsLayout", "Landroid/view/View;", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "reportUiType", "getReportUiType", "setReportUiType", "requestScene", "getRequestScene", "setRequestScene", "scene", "getScene", "setScene", "sessionID", "getSessionID", "setSessionID", "shareVideoFinish", "getShareVideoFinish", "setShareVideoFinish", "showFinderEntry", "showRelatedList", "getShowRelatedList", "setShowRelatedList", "staticTipsExposed", "getStaticTipsExposed", "setStaticTipsExposed", "staticTipsShowing", "getStaticTipsShowing", "setStaticTipsShowing", "tabType", "getTabType", "tabType$delegate", "tipsFirstShownCount", "tipsLayout", "tipsShownLimit", "tipsWording", "touchSlop", "uiType", "getUiType", "setUiType", "userContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "videoFinishListener", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1;", "viewCallback", "changeFollow", "", "changeFollowState", "isFollowed", "changeFollowView", "checkMoreTips", "checkPopupTipsInit", "checkStaticTipsExposed", "staticTipsTv", "convertActivityFromTranslucent", "dismissPopupTipsLayout", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "finish", "fixActionBarStatus", "followUser", "getCommentScene", "getLayoutId", "getMenuStyle", "Lcom/tencent/mm/ui/MMActivityController$OptionMenuStyle;", "getMenuText", "getModel", "getPresenter", "getReportType", "getShareAnimationLayoutTop", TencentLocationListener.RADIO, "screenWidth", "screenHeight", "mediaH", "getViewBottomInWindow", "view", "getViewCallback", "handleFollowStateChange", "hideCoverAnimation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActivityCloseAnimation", "initData", "initFollow", "initOnCreate", "initSimilarTipsShownCount", "isAllowShowTips", "contact", "isHideStatusBar", "isOtherEnableFullScreenEnjoy", "isSupportNavigationSwipeBack", "isViewExposed", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "overlayStatusBar", "popupTips", "isFullScreen", "runEnterAnimation", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "galleryBg", "root", "thumbRect", "runExitAnimation", "setFollowStatus", "setTitleWithNickName", "nickName", "shouldPopupTips", "shareVideoHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "showFollowView", "showProgress", "ifShow", "showRetryTips", "unFollowUser", "Companion", "plugin-finder_release"})
public final class FinderShareFeedRelUI extends FinderLoaderFeedUI<FinderFeedShareRelativeListLoader, j.b, k> {
    private static final int vPC = 1;
    private static final int vPD = 0;
    private static final int vPE = 1;
    private static final int vPF = 2;
    public static final a vPG = new a((byte) 0);
    final String TAG = "Finder.FinderShareFeedRelUI";
    private Runnable UUU;
    private HashMap _$_findViewCache;
    private float aTE = -1.0f;
    String dRL = "";
    long feedId;
    private final int rZ = ViewConfiguration.getTouchSlop();
    int sQn;
    private int scene = 2;
    private boolean tNP;
    private final kotlin.f tRX = kotlin.g.ah(new c(this));
    private final kotlin.f tRY = kotlin.g.ah(new f(this));
    private boolean tVm;
    private String tipsWording = "";
    private String tuI = "";
    private int tvu;
    private View uNf;
    private boolean vOG = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    private boolean vOJ;
    private k vOO;
    private j.b vOP;
    private FinderFeedShareRelativeListLoader vOQ;
    private int vOR;
    int vOS = 2;
    private final kotlin.f vOT = kotlin.g.ah(new d(this));
    private final kotlin.f vOU = kotlin.g.ah(new e(this));
    private final int vOV = 3;
    private boolean vOW = true;
    private int vOX;
    private BaseFinderFeed vOY;
    private boolean vOZ = true;
    private boolean vPA;
    private final ac vPB = new ac(this);
    private String vPa = "";
    private long vPb;
    private final kotlin.f vPc = kotlin.g.ah(new ab(this));
    boolean vPd;
    private boolean vPe;
    private boolean vPf;
    private boolean vPg;
    private View vPh;
    private boolean vPi;
    private int vPj = vPD;
    private hf vPk;
    private FinderContact vPl;
    private IListener<hf> vPm;
    private final kotlin.f vPn = kotlin.g.ah(new u(this));
    private int vPo;
    private boolean vPp;
    private FrameLayout vPq;
    private FrameLayout vPr;
    private NinePatchCropImageView vPs;
    private int vPt;
    private long vPu;
    private ViewAnimHelper.ViewInfo vPv;
    private String vPw = "";
    private boolean vPx;
    private boolean vPy;
    private boolean vPz;

    private final int dAh() {
        AppMethodBeat.i(252744);
        int intValue = ((Number) this.vOT.getValue()).intValue();
        AppMethodBeat.o(252744);
        return intValue;
    }

    private final int dAi() {
        AppMethodBeat.i(252745);
        int intValue = ((Number) this.vOU.getValue()).intValue();
        AppMethodBeat.o(252745);
        return intValue;
    }

    private final int dAj() {
        AppMethodBeat.i(252747);
        int intValue = ((Number) this.vPn.getValue()).intValue();
        AppMethodBeat.o(252747);
        return intValue;
    }

    private com.tencent.mm.plugin.finder.feed.model.f dcX() {
        AppMethodBeat.i(252743);
        com.tencent.mm.plugin.finder.feed.model.f fVar = (com.tencent.mm.plugin.finder.feed.model.f) this.tRY.getValue();
        AppMethodBeat.o(252743);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252795);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252795);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252794);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252794);
        return view;
    }

    public final com.tencent.mm.plugin.finder.feed.model.d dcW() {
        AppMethodBeat.i(252742);
        com.tencent.mm.plugin.finder.feed.model.d dVar = (com.tencent.mm.plugin.finder.feed.model.d) this.tRX.getValue();
        AppMethodBeat.o(252742);
        return dVar;
    }

    public final int getTabType() {
        AppMethodBeat.i(252746);
        int intValue = ((Number) this.vPc.getValue()).intValue();
        AppMethodBeat.o(252746);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$1"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.m<Integer, String, kotlin.x> {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ k vPK;
        final /* synthetic */ z.f vPL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(k kVar, FinderShareFeedRelUI finderShareFeedRelUI, z.f fVar) {
            super(2);
            this.vPK = kVar;
            this.vPI = finderShareFeedRelUI;
            this.vPL = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Integer num, String str) {
            RecyclerView recyclerView;
            boolean z = true;
            AppMethodBeat.i(252711);
            int intValue = num.intValue();
            String str2 = str;
            this.vPI.nK(false);
            b.AbstractC1134b bVar = this.vPK.tLN;
            if (!(bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(8);
            }
            TextView textView = (TextView) FinderShareFeedRelUI.a(this.vPI).findViewById(R.id.bml);
            if (this.vPK.dca() && textView != null) {
                textView.setTextColor(-1);
            }
            switch (intValue) {
                case -4036:
                    FinderShareFeedRelUI.a(this.vPI).setVisibility(0);
                    if (str2 != null) {
                        if (!(str2.length() == 0)) {
                            kotlin.g.b.p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.d94);
                    break;
                case -4033:
                    FinderShareFeedRelUI.a(this.vPI).setVisibility(0);
                    if (str2 != null) {
                        if (str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            kotlin.g.b.p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.cny);
                    break;
                case -4011:
                    FinderShareFeedRelUI.a(this.vPI).setVisibility(0);
                    if (str2 != null) {
                        if (str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            kotlin.g.b.p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.cmw);
                    break;
                default:
                    this.vPI.oD(true);
                    break;
            }
            FinderShareFeedRelUI.b(this.vPI);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(252711);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$5$2"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.b<FinderObject, kotlin.x> {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ k vPK;
        final /* synthetic */ z.f vPL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(k kVar, FinderShareFeedRelUI finderShareFeedRelUI, z.f fVar) {
            super(1);
            this.vPK = kVar;
            this.vPI = finderShareFeedRelUI;
            this.vPL = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(FinderObject finderObject) {
            String str;
            RecyclerView recyclerView;
            bbn bbn = null;
            boolean z = true;
            AppMethodBeat.i(252712);
            FinderObject finderObject2 = finderObject;
            kotlin.g.b.p.h(finderObject2, LocaleUtil.ITALIAN);
            this.vPI.nK(false);
            this.vPI.oD(false);
            this.vPI.vPl = finderObject2.contact;
            FinderFeedShareRelativeListLoader d2 = FinderShareFeedRelUI.d(this.vPI);
            FinderContact finderContact = finderObject2.contact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            kotlin.g.b.p.h(str, "<set-?>");
            d2.sBN = str;
            if (this.vPI.tVm || this.vPK.gte.getIntent().hasExtra("key_extra_info")) {
                this.vPK.hFK = finderObject2.id;
                this.vPI.feedId = finderObject2.id;
                FinderShareFeedRelUI.d(this.vPI).feedId = finderObject2.id;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vPK.gte);
                if (fH != null) {
                    long j2 = this.vPI.feedId;
                    FinderContact finderContact2 = finderObject2.contact;
                    fH.s(j2, finderContact2 != null ? finderContact2.username : null);
                }
                FinderFeedShareRelativeListLoader d3 = FinderShareFeedRelUI.d(this.vPI);
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.vPK.gte);
                if (fH2 != null) {
                    bbn = fH2.dIx();
                }
                d3.setContextObj(bbn);
            }
            FinderShareFeedRelUI.b(this.vPI, finderObject2.contact);
            FinderShareFeedRelUI.c(this.vPI, finderObject2.contact);
            b.AbstractC1134b bVar = this.vPK.tLN;
            if (!(bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            if (this.vPI.sQn != 0 && !this.vPI.vOJ) {
                if (this.vPI.tVm) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    long j3 = this.vPK.hFK;
                    int i2 = this.vPI.sQn;
                    String str2 = this.vPI.dRL;
                    if (str2 == null) {
                        str2 = "";
                    }
                    com.tencent.mm.plugin.finder.report.k.a(j3, i2, 4L, str2, 1, this.vPI.vOS);
                } else {
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    long j4 = this.vPK.hFK;
                    int i3 = this.vPI.sQn;
                    String str3 = this.vPI.dRL;
                    if (str3 == null) {
                        str3 = "";
                    }
                    kVar2.a(j4, i3, str3, 1, this.vPI.vOS);
                }
                this.vPI.vOJ = true;
            }
            com.tencent.mm.plugin.finder.feed.model.d dcW = this.vPI.dcW();
            long j5 = finderObject2.id;
            String str4 = finderObject2.objectNonceId;
            int i4 = this.vPK.tCE;
            if (finderObject2.secondaryShowFlag == 1) {
                z = false;
            }
            String str5 = finderObject2.username;
            if (str5 == null) {
                str5 = "";
            }
            dcW.a(j5, str4, i4, z, str5);
            FinderShareFeedRelUI.b(this.vPI);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(252712);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$1"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, kotlin.x> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(1);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(252713);
            IResponse<bo> iResponse2 = iResponse;
            kotlin.g.b.p.h(iResponse2, LocaleUtil.ITALIAN);
            FinderShareFeedRelUI.h(this.vPI).tLS.setEnableLoadMore(!FinderShareFeedRelUI.d(this.vPI).tVj);
            if (!iResponse2.getHasMore()) {
                View loadMoreFooter = FinderShareFeedRelUI.h(this.vPI).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                View loadMoreFooter2 = FinderShareFeedRelUI.h(this.vPI).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.vPI.getResources().getColor(R.color.FG_2));
                }
                View loadMoreFooter3 = FinderShareFeedRelUI.h(this.vPI).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter4 = FinderShareFeedRelUI.h(this.vPI).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(252713);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6$2"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, kotlin.x> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(1);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(252714);
            IResponse<bo> iResponse2 = iResponse;
            kotlin.g.b.p.h(iResponse2, LocaleUtil.ITALIAN);
            if (iResponse2.getPullType() != 2 && (iResponse2 instanceof FinderFeedShareRelativeListLoader.b) && !Util.isNullOrNil(((FinderFeedShareRelativeListLoader.b) iResponse2).tipsWording)) {
                this.vPI.tipsWording = ((FinderFeedShareRelativeListLoader.b) iResponse2).tipsWording;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(252714);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(1);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(View view) {
            TextView textView;
            int i2;
            AppMethodBeat.i(252722);
            View view2 = view;
            kotlin.g.b.p.h(view2, "itemView");
            if (Util.isNullOrNil(this.vPI.tipsWording)) {
                FinderShareFeedRelUI finderShareFeedRelUI = this.vPI;
                FinderShareFeedRelUI finderShareFeedRelUI2 = this.vPI;
                if (this.vPI.tVm) {
                    i2 = R.string.cnf;
                } else {
                    i2 = R.string.cnc;
                }
                String string = finderShareFeedRelUI2.getString(i2);
                kotlin.g.b.p.g(string, "getString(if (isFromAd) …_feed_more_similar_feed2)");
                finderShareFeedRelUI.tipsWording = string;
            }
            TextView textView2 = (TextView) view2.findViewById(R.id.d3q);
            if (textView2 != null) {
                textView2.setText(this.vPI.tipsWording);
            }
            View view3 = this.vPI.vPh;
            if (!(view3 == null || (textView = (TextView) view3.findViewById(R.id.d3q)) == null)) {
                textView.setText(this.vPI.tipsWording);
            }
            View view4 = this.vPI.vPh;
            if (view4 == null || view4.getVisibility() != 0) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(4);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(252722);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.b<Integer, bo> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(1);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bo invoke(Integer num) {
            BaseFinderFeed baseFinderFeed;
            FinderItem finderItem;
            AppMethodBeat.i(252724);
            int intValue = num.intValue();
            if (intValue < 0) {
                AppMethodBeat.o(252724);
                return null;
            }
            bo boVar = (bo) FinderShareFeedRelUI.d(this.vPI).get(intValue);
            if (!(boVar instanceof BaseFinderFeed) || ((finderItem = ((BaseFinderFeed) boVar).feedObject) != null && finderItem.getMediaType() == 10001)) {
                baseFinderFeed = null;
            } else {
                baseFinderFeed = (BaseFinderFeed) boVar;
            }
            BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
            AppMethodBeat.o(252724);
            return baseFinderFeed2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(2);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
            Integer num3;
            FinderFeedShareRelativeListLoader d2;
            DataBuffer dataListJustForAdapter;
            List a2;
            DataBuffer dataListJustForAdapter2;
            AppMethodBeat.i(252725);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue >= 0) {
                FinderFeedShareRelativeListLoader d3 = FinderShareFeedRelUI.d(this.vPI);
                if (d3 == null || (dataListJustForAdapter2 = d3.getDataListJustForAdapter()) == null) {
                    num3 = null;
                } else {
                    num3 = Integer.valueOf(dataListJustForAdapter2.size());
                }
                if (!(intValue2 >= num3.intValue() || (d2 = FinderShareFeedRelUI.d(this.vPI)) == null || (dataListJustForAdapter = d2.getDataListJustForAdapter()) == null || (a2 = kotlin.a.j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                    LinkedList linkedList = new LinkedList(a2);
                    AppMethodBeat.o(252725);
                    return linkedList;
                }
            }
            AppMethodBeat.o(252725);
            return null;
        }
    }

    public FinderShareFeedRelUI() {
        AppMethodBeat.i(252779);
        AppMethodBeat.o(252779);
    }

    public static final /* synthetic */ View a(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252781);
        View view = finderShareFeedRelUI.uNf;
        if (view == null) {
            kotlin.g.b.p.btv("tipsLayout");
        }
        AppMethodBeat.o(252781);
        return view;
    }

    public static final /* synthetic */ void b(FinderShareFeedRelUI finderShareFeedRelUI, FinderContact finderContact) {
        AppMethodBeat.i(252784);
        finderShareFeedRelUI.c(finderContact);
        AppMethodBeat.o(252784);
    }

    public static final /* synthetic */ FinderFeedShareRelativeListLoader d(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252783);
        FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = finderShareFeedRelUI.vOQ;
        if (finderFeedShareRelativeListLoader == null) {
            kotlin.g.b.p.btv("loader");
        }
        AppMethodBeat.o(252783);
        return finderFeedShareRelativeListLoader;
    }

    public static final /* synthetic */ int ef(View view) {
        AppMethodBeat.i(252793);
        int ee = ee(view);
        AppMethodBeat.o(252793);
        return ee;
    }

    public static final /* synthetic */ j.b h(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252786);
        j.b bVar = finderShareFeedRelUI.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        AppMethodBeat.o(252786);
        return bVar;
    }

    public static final /* synthetic */ int j(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252787);
        int dAh = finderShareFeedRelUI.dAh();
        AppMethodBeat.o(252787);
        return dAh;
    }

    public static final /* synthetic */ k m(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252789);
        k kVar = finderShareFeedRelUI.vOO;
        if (kVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        AppMethodBeat.o(252789);
        return kVar;
    }

    public static final /* synthetic */ FrameLayout o(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252790);
        FrameLayout frameLayout = finderShareFeedRelUI.vPq;
        if (frameLayout == null) {
            kotlin.g.b.p.btv("contentUI");
        }
        AppMethodBeat.o(252790);
        return frameLayout;
    }

    public static final /* synthetic */ NinePatchCropImageView q(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252791);
        NinePatchCropImageView ninePatchCropImageView = finderShareFeedRelUI.vPs;
        if (ninePatchCropImageView == null) {
            kotlin.g.b.p.btv("animCoverImage");
        }
        AppMethodBeat.o(252791);
        return ninePatchCropImageView;
    }

    public static final /* synthetic */ FrameLayout r(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(252792);
        FrameLayout frameLayout = finderShareFeedRelUI.vPr;
        if (frameLayout == null) {
            kotlin.g.b.p.btv("animCoverLayout");
        }
        AppMethodBeat.o(252792);
        return frameLayout;
    }

    public static final /* synthetic */ void t(FinderShareFeedRelUI finderShareFeedRelUI) {
        AppMethodBeat.i(261412);
        finderShareFeedRelUI.hVp();
        AppMethodBeat.o(261412);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ k ddK() {
        AppMethodBeat.i(252771);
        k dAm = dAm();
        AppMethodBeat.o(252771);
        return dAm;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$Companion;", "", "()V", "FOLLOWED", "", "getFOLLOWED", "()I", "FOLLOW_MENU_ID", "getFOLLOW_MENU_ID", "INIT_FOLLOW", "getINIT_FOLLOW", "UNFOLLOWED", "getUNFOLLOWED", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252780);
        AppMethodBeat.o(252780);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$videoFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class ac extends IListener<hj> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ac(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hj hjVar) {
            AppMethodBeat.i(252741);
            hj hjVar2 = hjVar;
            kotlin.g.b.p.h(hjVar2, "event");
            if (!this.vPI.vPd) {
                RecyclerView recyclerView = FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView();
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                if (((LinearLayoutManager) layoutManager) != null) {
                    RecyclerView.v cg = recyclerView.cg(0);
                    if (!(cg instanceof com.tencent.mm.view.recyclerview.h)) {
                        cg = null;
                    }
                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) cg;
                    if (hVar != null) {
                        Object hgv = hVar.hgv();
                        if (!(hgv instanceof com.tencent.mm.plugin.finder.model.ad)) {
                            hgv = null;
                        }
                        com.tencent.mm.plugin.finder.model.ad adVar = (com.tencent.mm.plugin.finder.model.ad) hgv;
                        if (adVar != null && adVar.feedObject.isPostFinish() && (adVar.feedObject.getExpectId() == hjVar2.dLP.feedId || (hjVar2.dLP.dLQ && adVar.feedObject.getLocalId() == hjVar2.dLP.feedId))) {
                            if (hjVar2.dLP.dLR) {
                                Log.i(this.vPI.TAG, "share video is completed");
                                this.vPI.vPd = true;
                                this.vPI.dAl();
                            } else {
                                AppMethodBeat.o(252741);
                                return true;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(252741);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final boolean isOtherEnableFullScreenEnjoy() {
        AppMethodBeat.i(252748);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean gr = com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh());
        AppMethodBeat.o(252748);
        return gr;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252749);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
            Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderFullFeedGuideUIC.class, FinderHorizontalVideoPreviewUIC.class, FinderLikeGuideUIC.class});
            AppMethodBeat.o(252749);
            return of;
        }
        AppMethodBeat.o(252749);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252750);
        this.vPv = (ViewAnimHelper.ViewInfo) getIntent().getParcelableExtra("key_view_info");
        String stringExtra = getIntent().getStringExtra("key_image_url");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.vPw = stringExtra;
        this.vPt = getIntent().getIntExtra("key_nine_patch_id", 0);
        this.vPu = getIntent().getLongExtra("key_animate_id", 0);
        if (dAh() == 38) {
            this.vOR = 2;
        }
        if (this.vPv != null && !Util.isNullOrNil(this.vPw)) {
            this.vPp = true;
        }
        super.onCreate(bundle);
        AppMethodBeat.o(252750);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(252751);
        super.onCreateBeforeSetContentView();
        if (this.vPp) {
            if (ao.isDarkMode()) {
                setTheme(R.style.pm);
                AppMethodBeat.o(252751);
                return;
            }
            setTheme(R.style.pn);
        }
        AppMethodBeat.o(252751);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252752);
        super.onResume();
        this.vPB.alive();
        if (this.tVm) {
            IListener<hf> iListener = this.vPm;
            if (iListener != null) {
                iListener.dead();
            }
            boolean d2 = d(this.vPl);
            Log.i(this.TAG, "isFollowed: " + d2 + " followStatus:" + this.vPj);
            if (this.vPk != null) {
                int i2 = this.vPj;
                if (i2 == vPE) {
                    if (d2) {
                        oz(false);
                    }
                } else if (i2 == vPF && !d2) {
                    oz(true);
                }
                this.vPk = null;
            }
            if (this.vPj == vPD) {
                c(this.vPl);
            }
        }
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Km(getTabType());
        switch (getCommentScene()) {
            case 25:
            case 38:
                c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEv = true;
                break;
            case 39:
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEv = false;
                break;
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        j.b bVar = this.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        com.tencent.mm.plugin.finder.report.live.k.b(bVar.tLS.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(252752);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        IListener<hf> iListener;
        AppMethodBeat.i(252753);
        super.onPause();
        this.vPB.dead();
        if (this.tVm && (iListener = this.vPm) != null) {
            iListener.alive();
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        j.b bVar = this.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        com.tencent.mm.plugin.finder.report.live.k.b(bVar.tLS.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, String.valueOf(getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(252753);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        l(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252715);
            this.vPI.onBackPressed();
            AppMethodBeat.o(252715);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        public static final m vPM = new m();

        static {
            AppMethodBeat.i(252717);
            AppMethodBeat.o(252717);
        }

        m() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252716);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252716);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        n(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        public final void run() {
            AppMethodBeat.i(252718);
            FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().setItemAnimator(new com.tencent.mm.plugin.finder.view.animation.d());
            AppMethodBeat.o(252718);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "visibleRect", "Landroid/graphics/Rect;", "getVisibleRect", "()Landroid/graphics/Rect;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class o extends RecyclerView.l {
        private float offset = 100.0f;
        final /* synthetic */ FinderShareFeedRelUI vPI;
        private final Rect vPN = new Rect();

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(252721);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(252721);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
            AppMethodBeat.i(252720);
            AppMethodBeat.o(252720);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            View view;
            ViewPropertyAnimator animate;
            ViewPropertyAnimator translationYBy;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator animate2;
            ViewPropertyAnimator translationYBy2;
            ViewPropertyAnimator duration2;
            View view2;
            View view3;
            View view4;
            View view5 = null;
            AppMethodBeat.i(252719);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            if (FinderShareFeedRelUI.d(this.vPI).getDataListJustForAdapter().size() >= 2) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.gr(this.vPI.getTabType(), FinderShareFeedRelUI.j(this.vPI))) {
                    RecyclerView.v ch = FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().ch(1);
                    View view6 = ch != null ? ch.aus : null;
                    if (view6 != null) {
                        view4 = view6.findViewById(R.id.d3q);
                    } else {
                        view4 = null;
                    }
                    int[] iArr = new int[2];
                    if (view4 != null) {
                        view4.getLocationOnScreen(iArr);
                    }
                    View view7 = this.vPI.vPh;
                    if (view7 != null) {
                        view5 = view7.findViewById(R.id.d3q);
                    }
                    int[] iArr2 = new int[2];
                    if (view5 != null) {
                        view5.getLocationOnScreen(iArr2);
                    }
                    View view8 = this.vPI.vPh;
                    if (!(view8 == null || view8.getVisibility() != 0 || view4 == null || view5 == null || iArr[1] > iArr2[1])) {
                        View view9 = this.vPI.vPh;
                        if (view9 != null) {
                            view9.setVisibility(8);
                        }
                        view6.setVisibility(0);
                    }
                    this.vPI.dAl();
                } else {
                    View view10 = this.vPI.vPh;
                    if (!(view10 == null || view10.getVisibility() != 0 || (view = this.vPI.vPh) == null)) {
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.vPI.getContext(), 112);
                        RecyclerView.v ch2 = FinderShareFeedRelUI.h(this.vPI).tLS.getRecyclerView().ch(0);
                        View findViewById = (ch2 == null || (view3 = ch2.aus) == null) ? null : view3.findViewById(R.id.clr);
                        if (!(ch2 == null || (view2 = ch2.aus) == null)) {
                            view5 = view2.findViewById(R.id.d33);
                        }
                        this.offset -= ((float) i3) / 5.0f;
                        this.offset = android.support.v4.b.a.p(this.offset, 0.0f, 100.0f);
                        view.setAlpha(this.offset / 100.0f);
                        if (view.getVisibility() == 0 && this.offset <= 0.0f) {
                            view.setVisibility(4);
                            if (!(findViewById == null || (animate2 = findViewById.animate()) == null || (translationYBy2 = animate2.translationYBy((float) fromDPToPix)) == null || (duration2 = translationYBy2.setDuration(260)) == null)) {
                                duration2.start();
                            }
                            if (!(view5 == null || (animate = view5.animate()) == null || (translationYBy = animate.translationYBy((float) fromDPToPix)) == null || (duration = translationYBy.setDuration(260)) == null)) {
                                duration.start();
                            }
                        }
                    }
                }
            }
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, String.valueOf(this.vPI.getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(252719);
        }
    }

    private final void dAk() {
        View contentView;
        View view;
        WeImageView weImageView;
        View view2;
        TextPaint textPaint;
        AppMethodBeat.i(252754);
        if (this.vPh == null) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            boolean gr = com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh());
            if (gr) {
                FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = this.vOQ;
                if (finderFeedShareRelativeListLoader == null) {
                    kotlin.g.b.p.btv("loader");
                }
                if (finderFeedShareRelativeListLoader.getDataListJustForAdapter().size() < 2) {
                    AppMethodBeat.o(252754);
                    return;
                }
            }
            if (gr) {
                j.b bVar = this.vOP;
                if (bVar == null) {
                    kotlin.g.b.p.btv("viewCallback");
                }
                RecyclerView.v ch = bVar.tLS.getRecyclerView().ch(0);
                if (ch != null) {
                    contentView = ch.aus;
                } else {
                    contentView = null;
                }
            } else {
                contentView = getContentView();
            }
            if (contentView == null) {
                AppMethodBeat.o(252754);
                return;
            }
            View findViewById = contentView.findViewById(R.id.fkv);
            if (findViewById == null) {
                findViewById = ((ViewStub) contentView.findViewById(R.id.fku)).inflate();
            }
            this.vPh = findViewById;
            View view3 = this.vPh;
            TextView textView = view3 != null ? (TextView) view3.findViewById(R.id.d3q) : null;
            View view4 = this.vPh;
            if (view4 != null) {
                view = view4.findViewById(R.id.fks);
            } else {
                view = null;
            }
            View view5 = this.vPh;
            if (view5 != null) {
                weImageView = (WeImageView) view5.findViewById(R.id.d3p);
            } else {
                weImageView = null;
            }
            View view6 = this.vPh;
            if (view6 != null) {
                view2 = view6.findViewById(R.id.fkt);
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.setOnClickListener(b.vPH);
            }
            View view7 = this.vPh;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            if (textView != null) {
                textPaint = textView.getPaint();
            } else {
                textPaint = null;
            }
            ao.a(textPaint, 0.8f);
            if (gr) {
                if (textView != null) {
                    textView.setTextColor(getResources().getColor(R.color.am));
                }
                if (weImageView != null) {
                    weImageView.setIconColor(getResources().getColor(R.color.am));
                }
            }
            if (gr) {
                if (view != null) {
                    view.setBackgroundResource(R.color.ac_);
                }
                if (view2 != null) {
                    view2.setBackgroundResource(R.color.ac_);
                }
            } else if (ao.isDarkMode()) {
                if (view != null) {
                    view.setBackgroundResource(R.drawable.a28);
                }
            } else if (view != null) {
                view.setBackgroundResource(R.drawable.a27);
            }
            this.vPo = com.tencent.mm.cb.a.fromDPToPix((Context) this, 104);
        }
        AppMethodBeat.o(252754);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        public static final b vPH = new b();

        static {
            AppMethodBeat.i(252705);
            AppMethodBeat.o(252705);
        }

        b() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252704);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252704);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        AppMethodBeat.i(261410);
        kotlin.g.b.p.h(motionEvent, "event");
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh()) && (view = this.vPh) != null && view.getVisibility() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.aTE = motionEvent.getY();
                    break;
                case 1:
                    float y2 = motionEvent.getY() - this.aTE;
                    View view2 = this.vPh;
                    if (view2 != null && view2.getVisibility() == 0 && y2 > 0.0f && y2 > ((float) this.rZ)) {
                        hVp();
                        break;
                    }
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(261410);
        return dispatchTouchEvent;
    }

    private final void hVp() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationYBy;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator translationYBy2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator translationYBy3;
        ViewPropertyAnimator duration3;
        ViewPropertyAnimator listener;
        View view;
        View view2;
        View view3 = null;
        AppMethodBeat.i(261411);
        View view4 = this.vPh;
        if (view4 != null) {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 112);
            j.b bVar = this.vOP;
            if (bVar == null) {
                kotlin.g.b.p.btv("viewCallback");
            }
            RecyclerView.v ch = bVar.tLS.getRecyclerView().ch(0);
            View findViewById = (ch == null || (view2 = ch.aus) == null) ? null : view2.findViewById(R.id.clr);
            if (!(ch == null || (view = ch.aus) == null)) {
                view3 = view.findViewById(R.id.d33);
            }
            ViewPropertyAnimator animate3 = view4.animate();
            if (!(animate3 == null || (alpha = animate3.alpha(0.0f)) == null || (translationYBy3 = alpha.translationYBy((float) fromDPToPix)) == null || (duration3 = translationYBy3.setDuration(260)) == null || (listener = duration3.setListener(new ad(view4))) == null)) {
                listener.start();
            }
            if (!(findViewById == null || (animate2 = findViewById.animate()) == null || (translationYBy2 = animate2.translationYBy((float) fromDPToPix)) == null || (duration2 = translationYBy2.setDuration(260)) == null)) {
                duration2.start();
            }
            if (view3 == null || (animate = view3.animate()) == null || (translationYBy = animate.translationYBy((float) fromDPToPix)) == null || (duration = translationYBy.setDuration(260)) == null) {
                AppMethodBeat.o(261411);
                return;
            }
            duration.start();
            AppMethodBeat.o(261411);
            return;
        }
        AppMethodBeat.o(261411);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$dismissPopupTipsLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class ad extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View tzy;

        ad(View view) {
            this.tzy = view;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261408);
            this.tzy.setVisibility(4);
            AppMethodBeat.o(261408);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initFollow$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class q extends IListener<hf> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        q(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            String str;
            String str2;
            hf.a aVar;
            AppMethodBeat.i(252723);
            hf hfVar2 = hfVar;
            FinderContact finderContact = this.vPI.vPl;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "userContact?.username ?: \"\"");
            if (!Util.isNullOrNil(str)) {
                if (hfVar2 == null || (aVar = hfVar2.dLI) == null || (str2 = aVar.username) == null) {
                    str2 = "";
                }
                if (Util.isEqual(str, str2)) {
                    this.vPI.vPk = hfVar2;
                }
            }
            AppMethodBeat.o(252723);
            return false;
        }
    }

    private final void c(FinderContact finderContact) {
        AppMethodBeat.i(252755);
        if (!this.tVm || finderContact == null || Util.isEqual(finderContact.username, com.tencent.mm.model.z.aUg()) || !((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry()) {
            AppMethodBeat.o(252755);
            return;
        }
        boolean d2 = d(finderContact);
        addTextOptionMenu(vPC, oB(d2), new z(this, finderContact), null, oC(d2));
        oA(d2);
        AppMethodBeat.o(252755);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showFollowView$1$1", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "plugin-finder_release"})
    public static final class z implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ FinderContact vwt;

        z(FinderShareFeedRelUI finderShareFeedRelUI, FinderContact finderContact) {
            this.vPI = finderShareFeedRelUI;
            this.vwt = finderContact;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252738);
            FinderShareFeedRelUI.l(this.vPI);
            AppMethodBeat.o(252738);
            return true;
        }
    }

    private final void oz(boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(252756);
        if (!z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        oA(z3);
        int i2 = vPC;
        if (!z2) {
            z4 = true;
        } else {
            z4 = false;
        }
        updateOptionMenuText(i2, oB(z4));
        int i3 = vPC;
        if (z2) {
            z5 = false;
        }
        updateOptionMenuStyle(i3, oC(z5));
        AppMethodBeat.o(252756);
    }

    private final void oA(boolean z2) {
        this.vPj = z2 ? vPF : vPE;
    }

    private static boolean d(FinderContact finderContact) {
        String str;
        AppMethodBeat.i(252757);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        if (finderContact == null || (str = finderContact.username) == null) {
            str = "";
        }
        boolean asJ = c.a.asJ(str);
        AppMethodBeat.o(252757);
        return asJ;
    }

    private final String oB(boolean z2) {
        AppMethodBeat.i(252758);
        if (z2) {
            String string = getContext().getString(R.string.cou);
            kotlin.g.b.p.g(string, "context.getString(R.string.finder_followed)");
            AppMethodBeat.o(252758);
            return string;
        }
        String string2 = getContext().getString(R.string.co_);
        kotlin.g.b.p.g(string2, "context.getString(R.string.finder_follow)");
        AppMethodBeat.o(252758);
        return string2;
    }

    private static t.b oC(boolean z2) {
        if (z2) {
            return t.b.FEED_UNFOLLOW;
        }
        return t.b.FEED_FOLLOW;
    }

    public final void oD(boolean z2) {
        AppMethodBeat.i(252759);
        z.f fVar = new z.f();
        fVar.SYG = (T) findViewById(R.id.h5w);
        if (fVar.SYG != null) {
            if (z2) {
                fVar.SYG.setVisibility(0);
                fVar.SYG.setOnClickListener(new aa(this, z2, fVar));
                AppMethodBeat.o(252759);
                return;
            }
            fVar.SYG.setVisibility(8);
        }
        AppMethodBeat.o(252759);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
    public static final class aa implements View.OnClickListener {
        final /* synthetic */ boolean uNm;
        final /* synthetic */ z.f uNn;
        final /* synthetic */ FinderShareFeedRelUI vPI;

        aa(FinderShareFeedRelUI finderShareFeedRelUI, boolean z, z.f fVar) {
            this.vPI = finderShareFeedRelUI;
            this.uNm = z;
            this.uNn = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252739);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vPI.nK(true);
            this.uNn.SYG.setVisibility(8);
            FinderShareFeedRelUI.m(this.vPI).requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252739);
        }
    }

    public final void nK(boolean z2) {
        AppMethodBeat.i(252760);
        if (findViewById(R.id.hpe) != null) {
            if (z2) {
                View findViewById = findViewById(R.id.hpe);
                kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.share_feed_progress)");
                findViewById.setVisibility(0);
                AppMethodBeat.o(252760);
                return;
            }
            View findViewById2 = findViewById(R.id.hpe);
            kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.share_feed_progress)");
            findViewById2.setVisibility(8);
        }
        AppMethodBeat.o(252760);
    }

    public final void dAl() {
        View view;
        View view2;
        View view3;
        RecyclerView.v vVar = null;
        r0 = null;
        View view4 = null;
        AppMethodBeat.i(252761);
        FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = this.vOQ;
        if (finderFeedShareRelativeListLoader == null) {
            kotlin.g.b.p.btv("loader");
        }
        if (finderFeedShareRelativeListLoader.getDataListJustForAdapter().size() < 2) {
            AppMethodBeat.o(252761);
            return;
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean gr = com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh());
        j.b bVar = this.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        RecyclerView.v ch = bVar.tLS.getRecyclerView().ch(0);
        if (!gr) {
            j.b bVar2 = this.vOP;
            if (bVar2 == null) {
                kotlin.g.b.p.btv("viewCallback");
            }
            RecyclerView.v ch2 = bVar2.tLS.getRecyclerView().ch(1);
            if (!(ch2 == null || (view3 = ch2.aus) == null)) {
                view4 = view3.findViewById(R.id.d3q);
            }
            ec(view4);
            vVar = ch2;
        }
        if (ch != null && W(ch)) {
            oE(gr);
            if (vVar == null || (view2 = vVar.aus) == null) {
                AppMethodBeat.o(252761);
                return;
            }
            view2.setVisibility(4);
            AppMethodBeat.o(252761);
        } else if (vVar == null || (view = vVar.aus) == null) {
            AppMethodBeat.o(252761);
        } else {
            view.setVisibility(0);
            AppMethodBeat.o(252761);
        }
    }

    private final void oE(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationYBy;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator translationYBy2;
        ViewPropertyAnimator duration2;
        View view3;
        View view4;
        AppMethodBeat.i(252762);
        dAk();
        View view5 = this.vPh;
        if (view5 != null) {
            if (Util.isNullOrNil(this.tipsWording)) {
                String string = getString(this.tVm ? R.string.cnf : R.string.cnc);
                kotlin.g.b.p.g(string, "getString(if (isFromAd) …_feed_more_similar_feed2)");
                this.tipsWording = string;
            }
            TextView textView = (TextView) view5.findViewById(R.id.d3q);
            if (textView != null) {
                textView.setText(this.tipsWording);
            }
            view5.setVisibility(0);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 112);
            if (z2) {
                j.b bVar = this.vOP;
                if (bVar == null) {
                    kotlin.g.b.p.btv("viewCallback");
                }
                RecyclerView.v ch = bVar.tLS.getRecyclerView().ch(0);
                if (ch == null || (view4 = ch.aus) == null) {
                    view = null;
                } else {
                    view = view4.findViewById(R.id.clr);
                }
                if (ch == null || (view3 = ch.aus) == null) {
                    view2 = null;
                } else {
                    view2 = view3.findViewById(R.id.d33);
                }
                if (view != null) {
                    view.setTranslationY(view.getTranslationY() + ((float) fromDPToPix));
                    ViewPropertyAnimator animate2 = view.animate();
                    if (!(animate2 == null || (translationYBy2 = animate2.translationYBy(-((float) fromDPToPix))) == null || (duration2 = translationYBy2.setDuration(260)) == null)) {
                        duration2.start();
                    }
                }
                if (!(view2 == null || (animate = view2.animate()) == null || (translationYBy = animate.translationYBy(-((float) fromDPToPix))) == null || (duration = translationYBy.setDuration(260)) == null)) {
                    duration.start();
                }
            } else {
                view5.setTranslationY(view5.getTranslationY() + ((float) fromDPToPix));
                view5.animate().translationYBy(-((float) fromDPToPix)).setDuration(260).start();
            }
            this.vPe = true;
            m.a aVar = com.tencent.mm.plugin.finder.report.m.vfD;
            com.tencent.mm.plugin.finder.report.m unused = com.tencent.mm.plugin.finder.report.m.vfC;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.report.m.a(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), 1, System.currentTimeMillis());
            view5.removeCallbacks(this.UUU);
            this.UUU = new ae(this, z2);
            view5.postDelayed(this.UUU, 3000);
            AppMethodBeat.o(252762);
            return;
        }
        AppMethodBeat.o(252762);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$popupTips$1$2"})
    public static final class ae implements Runnable {
        final /* synthetic */ boolean UUV;
        final /* synthetic */ FinderShareFeedRelUI vPI;

        ae(FinderShareFeedRelUI finderShareFeedRelUI, boolean z) {
            this.vPI = finderShareFeedRelUI;
            this.UUV = z;
        }

        public final void run() {
            AppMethodBeat.i(261409);
            FinderShareFeedRelUI.t(this.vPI);
            AppMethodBeat.o(261409);
        }
    }

    private final boolean W(RecyclerView.v vVar) {
        AppMethodBeat.i(252763);
        if (vVar == null) {
            AppMethodBeat.o(252763);
            return false;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwy().value().intValue() == 1) {
            AppMethodBeat.o(252763);
            return false;
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvL().value().intValue() == 1) {
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hUW().value().intValue() == 1 && this.vPd && !this.vPe) {
                    AppMethodBeat.o(252763);
                    return true;
                }
            }
            AppMethodBeat.o(252763);
            return false;
        }
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvL().value().intValue() == 1) {
            com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hUV().value().intValue() == 1 && this.vPd && !this.vPf && !this.vPe && dAj() > 0) {
                int dAj = dAj();
                View view = vVar.aus;
                kotlin.g.b.p.g(view, "shareVideoHolder.itemView");
                if (dAj - ee(view) < this.vPo) {
                    AppMethodBeat.o(252763);
                    return true;
                }
            }
        }
        AppMethodBeat.o(252763);
        return false;
    }

    private final void ec(View view) {
        AppMethodBeat.i(252764);
        if (view == null) {
            AppMethodBeat.o(252764);
            return;
        }
        boolean ed = ed(view);
        if (this.vPg || !ed) {
            if (!ed) {
                this.vPg = false;
            }
            AppMethodBeat.o(252764);
            return;
        }
        this.vPf = true;
        this.vPg = true;
        m.a aVar = com.tencent.mm.plugin.finder.report.m.vfD;
        com.tencent.mm.plugin.finder.report.m unused = com.tencent.mm.plugin.finder.report.m.vfC;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.report.m.a(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), 2, System.currentTimeMillis());
        AppMethodBeat.o(252764);
    }

    private static boolean ed(View view) {
        AppMethodBeat.i(252765);
        if (!view.isShown() || view.getAlpha() <= 0.0f || !view.getGlobalVisibleRect(new Rect())) {
            AppMethodBeat.o(252765);
            return false;
        }
        AppMethodBeat.o(252765);
        return true;
    }

    private static int ee(View view) {
        AppMethodBeat.i(252766);
        if (view.getHeight() <= 0) {
            AppMethodBeat.o(252766);
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int height = iArr[1] + view.getHeight();
        AppMethodBeat.o(252766);
        return height;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class t implements View.OnClickListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        t(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252726);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vPI.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252726);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        AppMethodBeat.i(252769);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean gr = com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh());
        AppMethodBeat.o(252769);
        return gr;
    }

    private k dAm() {
        AppMethodBeat.i(252770);
        k kVar = this.vOO;
        if (kVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        AppMethodBeat.o(252770);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajx;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        com.tencent.mm.plugin.finder.event.base.c a2;
        com.tencent.mm.plugin.finder.event.base.c a3;
        AppMethodBeat.i(252773);
        if (this.sQn != 0 && !this.vOJ) {
            if (this.tVm) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                long j2 = this.feedId;
                int i2 = this.sQn;
                String str = this.dRL;
                if (str == null) {
                    str = "";
                }
                com.tencent.mm.plugin.finder.report.k.a(j2, i2, 4L, str, 0, 2);
            } else {
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                long j3 = this.feedId;
                int i3 = this.sQn;
                String str2 = this.dRL;
                if (str2 == null) {
                    str2 = "";
                }
                kVar2.a(j3, i3, str2, 0, 2);
            }
            this.vOJ = true;
        }
        dcW().onDetach();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
            a3.b(dcW());
        }
        dcX().onDetach();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        AppCompatActivity context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
            a2.b(dcX());
        }
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        int tabType = getTabType();
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this);
        com.tencent.mm.plugin.finder.report.h.e(tabType, fH3 != null ? fH3.dIx() : null);
        IListener<hf> iListener = this.vPm;
        if (iListener != null) {
            iListener.dead();
        }
        super.onDestroy();
        AppMethodBeat.o(252773);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(252774);
        if (dAi() != 0) {
            int dAi = dAi();
            AppMethodBeat.o(252774);
            return dAi;
        }
        int dAh = dAh();
        AppMethodBeat.o(252774);
        return dAh;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class v implements Animator.AnimatorListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ View vPJ;

        v(FinderShareFeedRelUI finderShareFeedRelUI, View view) {
            this.vPI = finderShareFeedRelUI;
            this.vPJ = view;
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(252728);
            Log.i(this.vPI.TAG, "runEnterAnimation start");
            AppMethodBeat.o(252728);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(252729);
            this.vPI.vPx = false;
            FinderShareFeedRelUI.o(this.vPI).setVisibility(0);
            if (this.vPI.vPA) {
                FinderShareFeedRelUI.b(this.vPI);
            }
            Log.i(this.vPI.TAG, "runEnterAnimation end " + this.vPI.vPA);
            AppMethodBeat.o(252729);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(252730);
            this.vPJ.setVisibility(0);
            AppMethodBeat.o(252730);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.d invoke() {
            AppMethodBeat.i(252706);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.d dVar = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.vPI).get(FinderCommentPreloaderUIC.class)).tLy;
            AppMethodBeat.o(252706);
            return dVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.f invoke() {
            AppMethodBeat.i(252709);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.f fVar = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(this.vPI).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(252709);
            return fVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(252707);
            Integer valueOf = Integer.valueOf(this.vPI.getIntent().getIntExtra("key_comment_scene", 25));
            AppMethodBeat.o(252707);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(252708);
            Integer valueOf = Integer.valueOf(this.vPI.getIntent().getIntExtra("key_detail_comment_scene", 0));
            AppMethodBeat.o(252708);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class w implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        w(FinderShareFeedRelUI finderShareFeedRelUI) {
            this.vPI = finderShareFeedRelUI;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(252731);
            kotlin.g.b.p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(252731);
                throw tVar;
            }
            if (((Float) animatedValue).floatValue() > 0.1f && FinderShareFeedRelUI.q(this.vPI).getAlpha() < 0.9f) {
                FinderShareFeedRelUI.q(this.vPI).setAlpha(1.0f);
            }
            AppMethodBeat.o(252731);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(252740);
            Integer valueOf = Integer.valueOf(this.vPI.getIntent().getIntExtra("tab_type", 0));
            AppMethodBeat.o(252740);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class x implements Animator.AnimatorListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ View vPO;

        x(FinderShareFeedRelUI finderShareFeedRelUI, View view) {
            this.vPI = finderShareFeedRelUI;
            this.vPO = view;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(252733);
            kotlin.g.b.p.h(animator, "animation");
            View view = this.vPO;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            Log.i(this.vPI.TAG, "runExitAnimation start");
            AppMethodBeat.o(252733);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ x vPP;

            a(x xVar) {
                this.vPP = xVar;
            }

            public final void run() {
                AppMethodBeat.i(252732);
                this.vPP.vPI.finish();
                AppMethodBeat.o(252732);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(252734);
            kotlin.g.b.p.h(animator, "animation");
            FinderShareFeedRelUI.q(this.vPI).postDelayed(new a(this), 220);
            this.vPI.overridePendingTransition(R.anim.s, R.anim.s);
            Log.i(this.vPI.TAG, "runExitAnimation end");
            AppMethodBeat.o(252734);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(252735);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(252735);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(252736);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(252736);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderShareFeedRelUI vPI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(FinderShareFeedRelUI finderShareFeedRelUI) {
            super(0);
            this.vPI = finderShareFeedRelUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(252727);
            View view = this.vPI.vPh;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            ViewParent parent = view.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(252727);
                throw tVar;
            }
            Integer valueOf = Integer.valueOf(FinderShareFeedRelUI.ef((View) parent));
            AppMethodBeat.o(252727);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class y implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ AnimationLayout vPQ;

        y(FinderShareFeedRelUI finderShareFeedRelUI, AnimationLayout animationLayout) {
            this.vPI = finderShareFeedRelUI;
            this.vPQ = animationLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(252737);
            kotlin.g.b.p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(252737);
                throw tVar;
            }
            ((Float) animatedValue).floatValue();
            FinderShareFeedRelUI.q(this.vPI).m(this.vPQ.GPe);
            FinderShareFeedRelUI.q(this.vPI).invalidate();
            AppMethodBeat.o(252737);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$hideCoverAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class g implements Animator.AnimatorListener {
        final /* synthetic */ FinderShareFeedRelUI vPI;
        final /* synthetic */ View vPJ;

        g(FinderShareFeedRelUI finderShareFeedRelUI, View view) {
            this.vPI = finderShareFeedRelUI;
            this.vPJ = view;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(252710);
            FinderShareFeedRelUI.r(this.vPI).setVisibility(8);
            this.vPJ.setAlpha(1.0f);
            this.vPI.vPz = false;
            AppMethodBeat.o(252710);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final void initActivityCloseAnimation() {
        AppMethodBeat.i(252775);
        if (this.vPp) {
            AppMethodBeat.o(252775);
            return;
        }
        super.initActivityCloseAnimation();
        AppMethodBeat.o(252775);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean convertActivityFromTranslucent() {
        return !this.vPp;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isSupportNavigationSwipeBack() {
        AppMethodBeat.i(252776);
        if (this.vPp) {
            AppMethodBeat.o(252776);
            return false;
        }
        boolean isSupportNavigationSwipeBack = super.isSupportNavigationSwipeBack();
        AppMethodBeat.o(252776);
        return isSupportNavigationSwipeBack;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(252777);
        super.finish();
        if (this.vPp) {
            overridePendingTransition(R.anim.s, R.anim.s);
        }
        AppMethodBeat.o(252777);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(252778);
        if (this.vPx || this.vPy) {
            AppMethodBeat.o(252778);
            return;
        }
        View findViewById = findViewById(R.id.h5w);
        ViewAnimHelper.ViewInfo viewInfo = this.vPv;
        if (this.vPp) {
            View view = this.uNf;
            if (view == null) {
                kotlin.g.b.p.btv("tipsLayout");
            }
            if (view.getVisibility() != 0) {
                kotlin.g.b.p.g(findViewById, "retryView");
                if (!(findViewById.getVisibility() == 0 || viewInfo == null)) {
                    if (!dAm().dAp()) {
                        FrameLayout frameLayout = this.vPq;
                        if (frameLayout == null) {
                            kotlin.g.b.p.btv("contentUI");
                        }
                        frameLayout.setVisibility(8);
                        FrameLayout frameLayout2 = this.vPr;
                        if (frameLayout2 == null) {
                            kotlin.g.b.p.btv("animCoverLayout");
                        }
                        frameLayout2.setVisibility(0);
                        if (this.vPt != 0) {
                            NinePatchCropImageView ninePatchCropImageView = this.vPs;
                            if (ninePatchCropImageView == null) {
                                kotlin.g.b.p.btv("animCoverImage");
                            }
                            ninePatchCropImageView.setBackground(null);
                            NinePatchCropImageView ninePatchCropImageView2 = this.vPs;
                            if (ninePatchCropImageView2 == null) {
                                kotlin.g.b.p.btv("animCoverImage");
                            }
                            ninePatchCropImageView2.setNinePatchId(this.vPt);
                            NinePatchCropImageView ninePatchCropImageView3 = this.vPs;
                            if (ninePatchCropImageView3 == null) {
                                kotlin.g.b.p.btv("animCoverImage");
                            }
                            ninePatchCropImageView3.setAlpha(1.0f);
                            NinePatchCropImageView ninePatchCropImageView4 = this.vPs;
                            if (ninePatchCropImageView4 == null) {
                                kotlin.g.b.p.btv("animCoverImage");
                            }
                            ninePatchCropImageView4.lZ(viewInfo.QMg.width(), viewInfo.QMg.height());
                        }
                        View findViewById2 = findViewById(R.id.hp5);
                        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.share_animation_layout)");
                        AnimationLayout animationLayout = (AnimationLayout) findViewById2;
                        View findViewById3 = findViewById(R.id.dcj);
                        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.gallery_bg)");
                        Window window = getWindow();
                        kotlin.g.b.p.g(window, "window");
                        View decorView = window.getDecorView();
                        kotlin.g.b.p.g(decorView, "window.decorView");
                        Log.i(this.TAG, "runExitAnimation " + this.vPx + ", " + this.vPy);
                        if (this.vPx || this.vPy) {
                            AppMethodBeat.o(252778);
                            return;
                        }
                        this.vPy = true;
                        findViewById3.setVisibility(8);
                        animationLayout.a(findViewById3, decorView, viewInfo, new x(this, findViewById(R.id.c_)), new y(this, animationLayout));
                        EventCenter eventCenter = EventCenter.instance;
                        ic icVar = new ic();
                        icVar.dMI.key = this.vPu;
                        eventCenter.publish(icVar);
                        AppMethodBeat.o(252778);
                        return;
                    }
                    AppMethodBeat.o(252778);
                }
            }
        }
        if (!dAm().dAp()) {
            finish();
        }
        AppMethodBeat.o(252778);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderFeedShareRelativeListLoader ddM() {
        AppMethodBeat.i(252767);
        FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = this.vOQ;
        if (finderFeedShareRelativeListLoader == null) {
            kotlin.g.b.p.btv("loader");
        }
        FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader2 = finderFeedShareRelativeListLoader;
        AppMethodBeat.o(252767);
        return finderFeedShareRelativeListLoader2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        boolean z2;
        int i2;
        com.tencent.mm.plugin.finder.event.base.c a2;
        com.tencent.mm.plugin.finder.event.base.c a3;
        float f2;
        float dimension;
        AppMethodBeat.i(252768);
        this.feedId = getIntent().getLongExtra("feed_object_id", 0);
        String stringExtra = getIntent().getStringExtra("feed_encrypted_object_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.tuI = stringExtra;
        z.f fVar = new z.f();
        T t2 = (T) getIntent().getStringExtra("feed_object_nonceId");
        if (t2 == null) {
            t2 = (T) "";
        }
        fVar.SYG = t2;
        this.sQn = getIntent().getIntExtra("report_scene", 0);
        this.tvu = getIntent().getIntExtra("key_reuqest_scene", -1);
        this.dRL = getIntent().getStringExtra("from_user");
        this.vOS = getIntent().getIntExtra("report_uitype", 2);
        this.tVm = getIntent().getBooleanExtra("is_from_ad", false);
        this.vOZ = getIntent().getBooleanExtra("key_need_related_list", true);
        this.vPa = getIntent().getStringExtra("key_session_id");
        this.vPb = getIntent().getLongExtra("feed_local_id", 0);
        this.tNP = getIntent().getBooleanExtra("key_posting_scene", false);
        if (this.feedId == 0) {
            if ((this.tuI.length() == 0) && this.vPb == 0) {
                Log.w(this.TAG, "objectId 0 and encryptedObjectId null . finish");
                finish();
            }
        }
        View findViewById = findViewById(R.id.hpd);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.share_feed_detail_tips_layout)");
        this.uNf = findViewById;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
            dAk();
        }
        if (this.tVm) {
            this.vPm = new q(this);
        }
        View findViewById2 = findViewById(R.id.hq0);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.share_ui_content)");
        this.vPq = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.hp3);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.share_anim_cover_layout)");
        this.vPr = (FrameLayout) findViewById3;
        View findViewById4 = findViewById(R.id.hp4);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.share_anim_image)");
        this.vPs = (NinePatchCropImageView) findViewById4;
        if (this.vPp) {
            setBackBtn(new l(this), R.raw.actionbar_icon_dark_close);
            float doubleExtra = (float) getIntent().getDoubleExtra("key_image_height_radio", 1.1666666269302368d);
            float floatExtra = getIntent().getFloatExtra("key_image_height", 0.0f);
            float floatExtra2 = getIntent().getFloatExtra("key_image_width", 0.0f);
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
                com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                f2 = com.tencent.mm.plugin.finder.utils.y.bj(doubleExtra);
            } else {
                f2 = doubleExtra;
            }
            aj ajVar = (aj) com.tencent.mm.kernel.g.ah(aj.class);
            String str = this.vPw;
            NinePatchCropImageView ninePatchCropImageView = this.vPs;
            if (ninePatchCropImageView == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ajVar.loadImage(str, ninePatchCropImageView);
            Point az = au.az(getContext());
            int i3 = az.x;
            int i4 = az.y;
            NinePatchCropImageView ninePatchCropImageView2 = this.vPs;
            if (ninePatchCropImageView2 == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ViewGroup.LayoutParams layoutParams = ninePatchCropImageView2.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (int) (((float) i3) * f2);
            NinePatchCropImageView ninePatchCropImageView3 = this.vPs;
            if (ninePatchCropImageView3 == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ninePatchCropImageView3.setLayoutParams(layoutParams);
            NinePatchCropImageView ninePatchCropImageView4 = this.vPs;
            if (ninePatchCropImageView4 == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ninePatchCropImageView4.setAlpha(0.0f);
            int i5 = layoutParams.height;
            com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
                com.tencent.mm.plugin.finder.utils.y yVar5 = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.bl(f2)) {
                    AppCompatActivity context = getContext();
                    kotlin.g.b.p.g(context, "context");
                    int dimension2 = (int) context.getResources().getDimension(R.dimen.bw);
                    if (((float) i3) * f2 <= ((float) (i4 - (dimension2 * 2)))) {
                        dimension = ((((float) i4) / 2.0f) - (((float) i5) / 2.0f)) - ((float) (dimension2 / 2));
                    } else {
                        dimension = (((float) i4) / 2.0f) - (((float) i5) / 2.0f);
                    }
                } else {
                    dimension = (((float) i4) / 2.0f) - (((float) i5) / 2.0f);
                }
            } else {
                AppCompatActivity context2 = getContext();
                kotlin.g.b.p.g(context2, "context");
                dimension = context2.getResources().getDimension(R.dimen.cq);
            }
            Log.i(this.TAG, "[initData] enableAnimation heightRatio=" + f2 + " height=" + floatExtra + " width=" + floatExtra2 + " animationLayoutTop=" + dimension);
            View findViewById5 = findViewById(R.id.hp5);
            kotlin.g.b.p.g(findViewById5, "coverImageLayout");
            ViewGroup.LayoutParams layoutParams2 = findViewById5.getLayoutParams();
            if (layoutParams2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(252768);
                throw tVar;
            }
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = (int) dimension;
            com.tencent.mm.plugin.finder.utils.y yVar6 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.bk(f2)) {
                ViewGroup.LayoutParams layoutParams3 = findViewById5.getLayoutParams();
                if (layoutParams3 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    AppMethodBeat.o(252768);
                    throw tVar2;
                }
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.topMargin = 0;
                findViewById5.setLayoutParams(layoutParams4);
            }
            FrameLayout frameLayout = this.vPq;
            if (frameLayout == null) {
                kotlin.g.b.p.btv("contentUI");
            }
            frameLayout.setVisibility(8);
            FrameLayout frameLayout2 = this.vPr;
            if (frameLayout2 == null) {
                kotlin.g.b.p.btv("animCoverLayout");
            }
            frameLayout2.setVisibility(0);
            FrameLayout frameLayout3 = this.vPr;
            if (frameLayout3 == null) {
                kotlin.g.b.p.btv("animCoverLayout");
            }
            frameLayout3.setOnClickListener(m.vPM);
            View findViewById6 = findViewById(R.id.hpe);
            kotlin.g.b.p.g(findViewById6, "progressView");
            ViewGroup.LayoutParams layoutParams5 = findViewById6.getLayoutParams();
            if (layoutParams5 == null) {
                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(252768);
                throw tVar3;
            }
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
            layoutParams6.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 18);
            findViewById6.setLayoutParams(layoutParams6);
            View findViewById7 = findViewById(R.id.hp5);
            kotlin.g.b.p.g(findViewById7, "findViewById(R.id.share_animation_layout)");
            AnimationLayout animationLayout = (AnimationLayout) findViewById7;
            View findViewById8 = findViewById(R.id.dcj);
            kotlin.g.b.p.g(findViewById8, "findViewById(R.id.gallery_bg)");
            Window window = getWindow();
            kotlin.g.b.p.g(window, "window");
            View decorView = window.getDecorView();
            kotlin.g.b.p.g(decorView, "window.decorView");
            ViewAnimHelper.ViewInfo viewInfo = this.vPv;
            Log.i(this.TAG, "runEnterAnimation " + viewInfo + ", " + this.vPx);
            if (viewInfo != null && !this.vPx) {
                this.vPx = true;
                Log.i(this.TAG, "runEnterAnimation");
                animationLayout.b(findViewById8, decorView, viewInfo, new v(this, findViewById8), new w(this));
            }
        }
        if (this.feedId != 0) {
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            FinderItem Fy = e.a.Fy(this.feedId);
            if (Fy != null) {
                Log.i(this.TAG, "use cache cacheTime=" + com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, Fy.getTimestamps() / 1000) + ", cacheTime=" + Fy.getTimestamps() + ' ' + "current=" + com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, cl.aWA() / 1000) + ", urlValidDuration=" + Fy.getFeedObject().urlValidDuration + 's');
                if (Fy.getTimestamps() <= 0 || cl.aWA() < Fy.getTimestamps() + (((long) Fy.getFeedObject().urlValidDuration) * 1000)) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    this.vOY = c.a.s(Fy);
                }
                kotlin.x xVar = kotlin.x.SXb;
            }
        } else if (this.vPb != 0 && this.tNP) {
            c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            FinderItem FS = c.a.FS(this.vPb);
            if (FS != null) {
                c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                this.vOY = c.a.s(FS);
                kotlin.x xVar2 = kotlin.x.SXb;
            }
        }
        if (this.vOY == null) {
            Log.d(this.TAG, "cache null.show progress");
            nK(true);
        }
        int i6 = this.scene;
        FinderShareFeedRelUI finderShareFeedRelUI = this;
        if (!this.vOG) {
            z2 = true;
        } else {
            z2 = false;
        }
        k kVar = new k(i6, finderShareFeedRelUI, z2, getTabType());
        kVar.hFK = this.feedId;
        T t3 = fVar.SYG;
        kotlin.g.b.p.h(t3, "<set-?>");
        kVar.objectNonceId = t3;
        kVar.tNO = this.vOY;
        String str2 = this.tuI;
        kotlin.g.b.p.h(str2, "<set-?>");
        kVar.tNK = str2;
        kVar.tNL = this.vOZ;
        kVar.tNP = this.tNP;
        kVar.tNM = new h(kVar, this, fVar);
        kVar.tNN = new i(kVar, this, fVar);
        kotlin.x xVar3 = kotlin.x.SXb;
        this.vOO = kVar;
        FinderShareFeedRelUI finderShareFeedRelUI2 = this;
        k kVar2 = this.vOO;
        if (kVar2 == null) {
            kotlin.g.b.p.btv("presenter");
        }
        this.vOP = new j.b(finderShareFeedRelUI2, kVar2, this.scene, getCommentScene());
        if (this.sQn == 15) {
            i2 = 6;
        } else if (this.tvu < 0) {
            i2 = 3;
        } else {
            i2 = this.tvu;
        }
        this.tvu = i2;
        int tabType = getTabType();
        boolean z3 = this.tVm;
        int i7 = this.tvu;
        String str3 = this.vPa;
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        FinderFeedShareRelativeListLoader finderFeedShareRelativeListLoader = new FinderFeedShareRelativeListLoader(this.feedId, this.tuI, fVar.SYG, tabType, z3, i7, str3, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), this.tNP);
        String stringExtra2 = getIntent().getStringExtra("key_from_user_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        kotlin.g.b.p.h(stringExtra2, "<set-?>");
        finderFeedShareRelativeListLoader.dYs = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("key_to_user_name");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        kotlin.g.b.p.h(stringExtra3, "<set-?>");
        finderFeedShareRelativeListLoader.dJw = stringExtra3;
        Log.i(finderFeedShareRelativeListLoader.getTAG(), "fromUserName=" + finderFeedShareRelativeListLoader.dYs + ",toUserName=" + finderFeedShareRelativeListLoader.dJw);
        finderFeedShareRelativeListLoader.fetchEndCallback = new j(this);
        finderFeedShareRelativeListLoader.tVk = new k(this);
        kotlin.x xVar4 = kotlin.x.SXb;
        this.vOQ = finderFeedShareRelativeListLoader;
        if (this.sQn != 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 14, 1, false);
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.vOX = aAh.azQ().getInt(ar.a.USERINFO_FINDER_SIMILAR_TIPS_SHOWN_INT_SYNC, 0);
        Log.d(this.TAG, "tips first shown count by each feed: " + this.vOX);
        j.b bVar = this.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        bVar.tLS.getRecyclerView().post(new n(this));
        j.b bVar2 = this.vOP;
        if (bVar2 == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        bVar2.tLS.getRecyclerView().a(new o(this));
        k kVar3 = this.vOO;
        if (kVar3 == null) {
            kotlin.g.b.p.btv("presenter");
        }
        kVar3.vQl = new p(this);
        dcW().a(this.scene, getCommentScene(), new r(this));
        FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
        AppCompatActivity context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
        if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
            a3.a(dcW());
        }
        dcX().e(new s(this));
        FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
        AppCompatActivity context4 = getContext();
        kotlin.g.b.p.g(context4, "context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context4);
        if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
            a2.a(dcX());
        }
        com.tencent.mm.plugin.finder.utils.y yVar7 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.gr(getTabType(), dAh())) {
            FrameLayout frameLayout4 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout4, "full_actionbar");
            frameLayout4.setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.xu)).setOnClickListener(new t(this));
            TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
            kotlin.g.b.p.g(textView, "full_action_bar_title");
            textView.setVisibility(0);
            if (getTabType() == 10) {
                ((TextView) _$_findCachedViewById(R.id.dbg)).setText(R.string.d_t);
            }
            Window window2 = getWindow();
            kotlin.g.b.p.g(window2, "window");
            View decorView2 = window2.getDecorView();
            kotlin.g.b.p.g(decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1024 | 256);
            Window window3 = getWindow();
            kotlin.g.b.p.g(window3, "window");
            window3.setStatusBarColor(0);
            getController().p(this, getResources().getColor(R.color.ac_));
            com.tencent.mm.ui.b.e(this, false);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
                supportActionBar.hide();
            }
            int statusBarHeight = au.getStatusBarHeight(this);
            FrameLayout frameLayout5 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout5, "full_actionbar");
            ViewGroup.LayoutParams layoutParams7 = frameLayout5.getLayoutParams();
            layoutParams7.height += statusBarHeight;
            FrameLayout frameLayout6 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout6, "full_actionbar");
            frameLayout6.setLayoutParams(layoutParams7);
            ((FrameLayout) _$_findCachedViewById(R.id.dbh)).setPadding(0, statusBarHeight, 0, 0);
            getController().updataStatusBarIcon(true);
            setNavigationbarColor(WebView.NIGHT_MODE_COLOR);
            ((ImageView) _$_findCachedViewById(R.id.dcj)).setBackgroundColor(getResources().getColor(R.color.rv));
            View findViewById9 = findViewById(R.id.hpr);
            if (findViewById9 != null) {
                findViewById9.setBackgroundColor(getResources().getColor(R.color.rv));
                AppMethodBeat.o(252768);
                return;
            }
            AppMethodBeat.o(252768);
            return;
        }
        if (!this.tVm) {
            setMMTitle(R.string.da9);
        }
        AppMethodBeat.o(252768);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ j.b ddL() {
        AppMethodBeat.i(252772);
        j.b bVar = this.vOP;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        j.b bVar2 = bVar;
        AppMethodBeat.o(252772);
        return bVar2;
    }

    public static final /* synthetic */ void b(FinderShareFeedRelUI finderShareFeedRelUI) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        AppMethodBeat.i(252782);
        Log.i(finderShareFeedRelUI.TAG, "hideCoverAnimation " + finderShareFeedRelUI.vPx + ", " + finderShareFeedRelUI.vPz);
        if (finderShareFeedRelUI.vPx) {
            finderShareFeedRelUI.vPA = true;
            AppMethodBeat.o(252782);
            return;
        }
        if (!finderShareFeedRelUI.vPz) {
            FrameLayout frameLayout = finderShareFeedRelUI.vPq;
            if (frameLayout == null) {
                kotlin.g.b.p.btv("contentUI");
            }
            frameLayout.setVisibility(0);
            finderShareFeedRelUI.vPz = true;
            View findViewById = finderShareFeedRelUI.findViewById(R.id.dcj);
            if (!(findViewById == null || (animate = findViewById.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(160)) == null || (listener = duration.setListener(new g(finderShareFeedRelUI, findViewById))) == null)) {
                listener.start();
            }
            NinePatchCropImageView ninePatchCropImageView = finderShareFeedRelUI.vPs;
            if (ninePatchCropImageView == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ninePatchCropImageView.animate().cancel();
            NinePatchCropImageView ninePatchCropImageView2 = finderShareFeedRelUI.vPs;
            if (ninePatchCropImageView2 == null) {
                kotlin.g.b.p.btv("animCoverImage");
            }
            ninePatchCropImageView2.animate().alpha(0.0f).setStartDelay(80).setDuration(120).start();
        }
        AppMethodBeat.o(252782);
    }

    public static final /* synthetic */ void c(FinderShareFeedRelUI finderShareFeedRelUI, FinderContact finderContact) {
        AppMethodBeat.i(252785);
        if (finderContact != null) {
            String str = finderContact.nickname;
            if (!finderShareFeedRelUI.tVm || finderShareFeedRelUI.vPi) {
                AppMethodBeat.o(252785);
                return;
            } else if (!Util.isNullOrNil(str)) {
                finderShareFeedRelUI.setMMTitle(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), str));
                finderShareFeedRelUI.vPi = true;
            }
        }
        AppMethodBeat.o(252785);
    }

    public static final /* synthetic */ void l(FinderShareFeedRelUI finderShareFeedRelUI) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(252788);
        boolean d2 = d(finderShareFeedRelUI.vPl);
        finderShareFeedRelUI.oz(d2);
        if (d2) {
            FinderContact finderContact = finderShareFeedRelUI.vPl;
            if (finderContact == null || (str5 = finderContact.username) == null) {
                str4 = "";
            } else {
                str4 = str5;
            }
            kotlin.g.b.p.g(str4, "userContact?.username ?: \"\"");
            ag agVar = ag.uOs;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(finderShareFeedRelUI).get(FinderReporterUIC.class)).dIx();
            bb.a aVar2 = bb.tve;
            com.tencent.mm.kernel.g.azz().b(ag.a(dIx, str4, bb.tvc));
            c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
            g.a aVar4 = com.tencent.mm.plugin.finder.api.g.tsD;
            c.a.du(str4, com.tencent.mm.plugin.finder.api.g.tsC);
            AppMethodBeat.o(252788);
            return;
        }
        FinderContact finderContact2 = finderShareFeedRelUI.vPl;
        if (finderContact2 == null || (str3 = finderContact2.username) == null) {
            str = "";
        } else {
            str = str3;
        }
        kotlin.g.b.p.g(str, "userContact?.username ?: \"\"");
        ag agVar2 = ag.uOs;
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(finderShareFeedRelUI).get(FinderReporterUIC.class)).dIx();
        FinderContact finderContact3 = finderShareFeedRelUI.vPl;
        if (finderContact3 == null || (str2 = finderContact3.username) == null) {
            str2 = "";
        }
        bb.a aVar6 = bb.tve;
        com.tencent.mm.kernel.g.azz().b(ag.a(dIx2, str2, bb.tvb));
        c.a aVar7 = com.tencent.mm.plugin.finder.api.c.tsp;
        g.a aVar8 = com.tencent.mm.plugin.finder.api.g.tsD;
        c.a.du(str, com.tencent.mm.plugin.finder.api.g.tsB);
        AppMethodBeat.o(252788);
    }
}
