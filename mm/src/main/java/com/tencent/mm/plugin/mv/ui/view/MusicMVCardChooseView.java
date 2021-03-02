package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.mv.ui.adapter.b;
import com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0004\u001c\u001f<V\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\b¾\u0001¿\u0001À\u0001Á\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010b\u001a\u00020c2\u0006\u0010&\u001a\u00020'J\b\u0010d\u001a\u00020cH\u0002J\u0006\u0010e\u001a\u00020cJ\u0012\u0010f\u001a\u00020\u00152\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0006\u0010i\u001a\u00020cJ\u0016\u0010j\u001a\u00020c2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020m0lH\u0002J\b\u0010n\u001a\u000200H\u0002J\b\u0010o\u001a\u00020cH\u0002J&\u0010p\u001a\u00020c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\fJ\b\u0010q\u001a\u00020cH\u0002J\b\u0010r\u001a\u00020cH\u0002J\b\u0010s\u001a\u00020cH\u0002J\b\u0010t\u001a\u00020cH\u0002J\b\u0010u\u001a\u00020cH\u0002J\b\u0010v\u001a\u00020cH\u0002J\b\u0010w\u001a\u00020cH\u0002J\b\u0010x\u001a\u00020cH\u0002J\b\u0010y\u001a\u00020cH\u0002J\b\u0010z\u001a\u00020cH\u0002J\u0012\u0010{\u001a\u00020c2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0012\u0010~\u001a\u00020c2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0012\u0010\u001a\u00020c2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0007\u0010\u0001\u001a\u00020cJ=\u0010\u0001\u001a\u00020c2\t\u0010\u0001\u001a\u0004\u0018\u00010^2\t\u0010\u0001\u001a\u0004\u0018\u00010^2\u0010\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010l2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J&\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\f2\t\u0010\u0001\u001a\u0004\u0018\u00010}2\u0007\u0010\u0001\u001a\u00020\fH\u0002J&\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\f2\t\u0010\u0001\u001a\u0004\u0018\u00010}2\u0007\u0010\u0001\u001a\u00020\fH\u0002JS\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u00152+\b\u0002\u0010\u0001\u001a$\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020c\u0018\u00010\u00012\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020c\u0018\u00010\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020cJ,\u0010\u0001\u001a\u00020c2\u000f\u0010k\u001a\u000b\u0012\u0004\u0012\u00020m\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u0002002\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J6\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\f2\u0012\u0010 \u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010^\u0018\u00010¡\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001¢\u0006\u0003\u0010¤\u0001J\u0007\u0010¥\u0001\u001a\u00020cJ\t\u0010¦\u0001\u001a\u00020\u0015H\u0016J\u001e\u0010§\u0001\u001a\u00020c2\u0007\u0010¨\u0001\u001a\u00020\f2\n\u0010©\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0007\u0010ª\u0001\u001a\u00020cJ\t\u0010«\u0001\u001a\u00020cH\u0002J\t\u0010¬\u0001\u001a\u00020cH\u0002J\t\u0010­\u0001\u001a\u00020cH\u0002J\t\u0010®\u0001\u001a\u00020cH\u0002J\u0012\u0010¯\u0001\u001a\u00020c2\u0007\u0010¨\u0001\u001a\u00020\fH\u0002J\t\u0010°\u0001\u001a\u00020cH\u0002J\t\u0010±\u0001\u001a\u00020cH\u0002J\u001e\u0010²\u0001\u001a\u00020c2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u00012\u0007\u0010µ\u0001\u001a\u00020^H\u0002J\u0012\u0010¶\u0001\u001a\u00020c2\u0007\u0010¨\u0001\u001a\u00020\fH\u0002J\u0010\u0010·\u0001\u001a\u00020c2\u0007\u0010¸\u0001\u001a\u00020\fJg\u0010¹\u0001\u001a\u00020c2\u0007\u0010º\u0001\u001a\u00020\f2\u0007\u0010»\u0001\u001a\u00020\f2\t\b\u0002\u0010¼\u0001\u001a\u00020\u00152+\b\u0002\u0010\u0001\u001a$\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020c\u0018\u00010\u00012\u0012\b\u0002\u0010½\u0001\u001a\u000b\u0012\u0004\u0012\u00020c\u0018\u00010\u0001H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0004¢\u0006\u0004\n\u0002\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020VX\u0004¢\u0006\u0004\n\u0002\u0010WR\u0010\u0010X\u001a\u0004\u0018\u00010YX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020^0]j\b\u0012\u0004\u0012\u00020^`_X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "adapter", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter;", "albumChooseRV", "Landroid/support/v7/widget/RecyclerView;", "checkMediaStorage", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "finderChooseRL", "finderMainView", "firstVisibleItem", "fragmentItemClickedListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1;", "fragmentResultListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1;", "isChangingMode", "isEnableTouch", "isMinMode", "jumpToRecordNew", "lastVisibleItem", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "loadingState", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$LoadingState;", "loadingView", "Landroid/widget/LinearLayout;", "mOnCameraOpen", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "mQueryTicket", "", "maxHeight", "minHeight", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "myFavLL", "myIntroduceLL", "myLikeLL", "myPostLL", "noResultView", "Landroid/widget/TextView;", "onFlingListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1;", "pagerFragmentFav", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "pagerFragmentLike", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment;", "pagerFragmentMachine", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment;", "pagerFragmentPost", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment;", "querySource", "queryType", "reportClickCamera", "root", "screenWidth", "searchBar", "searchPanel", "searchResultPanel", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "searchView", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "selectLimit", "startPerformance", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "tabSelectedListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1;", "tipDialog", "Landroid/app/ProgressDialog;", "titleTabLayout", "Landroid/support/design/widget/TabLayout;", "titles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoMaxDuration", "videoMinDuration", "addChoosePanelActionListener", "", "clearEditFocus", "disableTouch", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableTouch", "filterNonExistMedia", "mediaItems", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "generateOneQueryTicket", "hideSearchResultPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initAlbumChooseArea", "initContentView", "initEditView", "initFinderBtnArea", "initFinderChooseArea", "initQueryInfo", "initSearchPanel", "initSearchView", "initTitleArea", "initView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onHeaderClick", "position", "itemView", "itemViewType", "onMediaClick", "onModeChanged", "change2Min", "onAnimationUpdate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "afterModeChanged", "Lkotlin/Function0;", "onPause", "onQueryMediaFinished", "Ljava/util/LinkedList;", "ticket", "isFirstNotify", "onRequestPermissionsResult", "requestCode", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSearchKeyDown", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "onTakePhotoFinished", "queryMedia", "queryMediaIncrement", "queryVideo", "refreshSearchView", "showPagerFragment", "showSearchResultPanel", "showVKB", "startSearch", "fragment", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", SearchIntents.EXTRA_QUERY, "updateTextColor", "updateVideoMinDuration", "minDuration", "updateViewHeight", "fromHeight", "toHeight", "withAnimation", "onAnimationEnd", "Companion", "IChoosePanelActionListener", "LoadingState", "NotifyMediaItemsChanged", "plugin-mv_release"})
public final class MusicMVCardChooseView extends RelativeLayout implements i.c, FTSSearchNoActionBarView.b, FTSEditTextView.a {
    public static int Axc;
    public static final a Axd = new a((byte) 0);
    private static long start;
    public com.tencent.mm.plugin.music.model.e.a AkC;
    private boolean Anw;
    public final b.d ArL;
    public TabLayout AwB;
    public RecyclerView AwC;
    public com.tencent.mm.plugin.mv.ui.adapter.b AwD;
    public RelativeLayout AwE;
    public RelativeLayout AwF;
    public WeImageView AwG;
    public LinearLayout AwH;
    public FTSSearchNoActionBarView AwI;
    public MusicMvTabSearchFragment AwJ;
    public LinearLayout AwK;
    public LinearLayout AwL;
    public LinearLayout AwM;
    public LinearLayout AwN;
    public LinearLayout AwO;
    public MusicMvTabMachineFragment AwP;
    public MusicMvTabMyPostFragment AwQ;
    public MusicMvTabMyFavFragment AwR;
    public MusicMvTabMyLikeFragment AwS;
    public boolean AwT;
    public final q AwU;
    public b AwV;
    private final ArrayList<String> AwW;
    public final w AwX;
    public final e AwY;
    public final f AwZ;
    public volatile c Axa;
    private boolean Axb;
    private HashMap _$_findViewCache;
    public MMActivity activity;
    private int gsi;
    public ProgressDialog gtM;
    private WeImageView hPb;
    public final int het;
    private int kyt;
    public int mEX;
    public int maxHeight;
    public int minHeight;
    private int oEo;
    public boolean qUd;
    public TextView vtJ;
    private int wnd;
    private p.c xoD;
    private int xoE;
    public boolean xoh;
    private int xoj;
    private int xoo;
    public final int xos;
    public boolean xot;
    public volatile long xov;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "", "onAlbumItemClicked", "", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onFeederItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onHeaderCameraClicked", "minDuration", "", "onSearchBarClicked", "plugin-mv_release"})
    public interface b {
        void Tk(int i2);

        void a(GalleryItem.VideoMediaItem videoMediaItem, com.tencent.mm.plugin.mv.a.f fVar);

        void a(MusicMvTabFragment.f fVar, com.tencent.mm.plugin.mv.a.f fVar2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$LoadingState;", "", "(Ljava/lang/String;I)V", "CREATE", "SKIP", "plugin-mv_release"})
    public enum c {
        CREATE,
        SKIP;

        static {
            AppMethodBeat.i(257404);
            AppMethodBeat.o(257404);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(257406);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(257406);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(257456);
        AppMethodBeat.o(257456);
    }

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(257465);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(257465);
        return view;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "progress", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.b<Float, kotlin.x> {
        final /* synthetic */ MusicMVCardChooseView Axh;
        final /* synthetic */ z.d Axi;
        final /* synthetic */ z.d Axj;
        final /* synthetic */ boolean Axn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(MusicMVCardChooseView musicMVCardChooseView, boolean z, z.d dVar, z.d dVar2) {
            super(1);
            this.Axh = musicMVCardChooseView;
            this.Axn = z;
            this.Axi = dVar;
            this.Axj = dVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Float f2) {
            AppMethodBeat.i(257426);
            float floatValue = f2.floatValue();
            if (!this.Axn) {
                int i2 = (int) (floatValue * ((float) this.Axi.SYE));
                int i3 = i2 - this.Axj.SYE;
                this.Axj.SYE = i2;
                RecyclerView recyclerView = this.Axh.AwC;
                if (recyclerView == null) {
                    kotlin.g.b.p.hyc();
                }
                recyclerView.scrollBy(0, i3);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257426);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$Companion;", "", "()V", "ANIMATE_DURATION", "", "SPAN_COUNT", "", "TAG", "", "curVideoMinDurationMs", "start", "filterEditMediaItem", "", "mMediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(MusicMVCardChooseView musicMVCardChooseView, kotlin.g.a.b bVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(257462);
        musicMVCardChooseView.a(true, (kotlin.g.a.b<? super Float, kotlin.x>) bVar, (kotlin.g.a.a<kotlin.x>) aVar);
        AppMethodBeat.o(257462);
    }

    public static final /* synthetic */ void g(MusicMVCardChooseView musicMVCardChooseView) {
        AppMethodBeat.i(257457);
        musicMVCardChooseView.ewn();
        AppMethodBeat.o(257457);
    }

    public static final /* synthetic */ void r(MusicMVCardChooseView musicMVCardChooseView) {
        AppMethodBeat.i(257461);
        musicMVCardChooseView.ewm();
        AppMethodBeat.o(257461);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1", "Landroid/support/v7/widget/RecyclerView$OnFlingListener;", "onFling", "", "velocityX", "", "velocityY", "plugin-mv_release"})
    public static final class q extends RecyclerView.j {
        final /* synthetic */ MusicMVCardChooseView Axh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        q(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        @Override // android.support.v7.widget.RecyclerView.j
        public final boolean av(int i2, int i3) {
            AppMethodBeat.i(257425);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onFling velocityY:".concat(String.valueOf(i3)));
            if (!this.Axh.Anw) {
                if (i3 > 8000 && this.Axh.Axb) {
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onFling velocityY:" + i3 + ", changeTo maxMode");
                    MusicMVCardChooseView.a(this.Axh, false, (kotlin.g.a.a) null, 6);
                } else if (i3 < -8000 && !this.Axh.Axb) {
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onFling velocityY:" + i3 + ", changeTo minMode");
                    MusicMVCardChooseView.a(this.Axh, true, (kotlin.g.a.a) null, 6);
                }
            }
            AppMethodBeat.o(257425);
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMVCardChooseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(257454);
        AppMethodBeat.o(257454);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMVCardChooseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(257455);
        this.AwT = true;
        this.AwU = new q(this);
        this.AwW = kotlin.a.j.ac(getContext().getString(R.string.f87), getContext().getString(R.string.f88));
        this.AwX = new w(this);
        this.AwY = new e(this);
        this.AwZ = new f(this);
        this.ArL = new o(this);
        this.xoE = -1;
        this.oEo = -1;
        this.xoD = p.c.IDLE;
        this.het = 27;
        this.xos = 2;
        this.xov = -1;
        this.Axb = true;
        AppMethodBeat.o(257455);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "p0", "onTabSelected", "tab", "onTabUnselected", "plugin-mv_release"})
    public static final class w implements TabLayout.b<TabLayout.f> {
        final /* synthetic */ MusicMVCardChooseView Axh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        w(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void k(TabLayout.f fVar) {
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void j(TabLayout.f fVar) {
            View view;
            AppMethodBeat.i(257431);
            if (fVar != null) {
                TabLayout tabLayout = this.Axh.AwB;
                if (tabLayout != null) {
                    view = tabLayout.getChildAt(0);
                } else {
                    view = null;
                }
                if (!(view instanceof ViewGroup)) {
                    view = null;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                View childAt = viewGroup != null ? viewGroup.getChildAt(fVar.getPosition()) : null;
                if (!(childAt instanceof ViewGroup)) {
                    childAt = null;
                }
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                View childAt2 = viewGroup2 != null ? viewGroup2.getChildAt(1) : null;
                if (!(childAt2 instanceof TextView)) {
                    childAt2 = null;
                }
                TextView textView = (TextView) childAt2;
                if (textView != null) {
                    textView.setTypeface(Typeface.DEFAULT);
                    AppMethodBeat.o(257431);
                    return;
                }
            }
            AppMethodBeat.o(257431);
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void i(TabLayout.f fVar) {
            FTSEditTextView ftsEditText;
            FTSEditTextView ftsEditText2;
            AppMethodBeat.i(257432);
            if (fVar != null) {
                TabLayout tabLayout = this.Axh.AwB;
                View childAt = tabLayout != null ? tabLayout.getChildAt(0) : null;
                if (!(childAt instanceof ViewGroup)) {
                    childAt = null;
                }
                ViewGroup viewGroup = (ViewGroup) childAt;
                View childAt2 = viewGroup != null ? viewGroup.getChildAt(fVar.getPosition()) : null;
                if (!(childAt2 instanceof ViewGroup)) {
                    childAt2 = null;
                }
                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                View childAt3 = viewGroup2 != null ? viewGroup2.getChildAt(1) : null;
                if (!(childAt3 instanceof TextView)) {
                    childAt3 = null;
                }
                TextView textView = (TextView) childAt3;
                if (textView != null) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                }
                int position = fVar.getPosition();
                Log.i("MicroMsg.Mv.MusicMVCardChooseView", "setCurrentPage:".concat(String.valueOf(position)));
                if (position == -1) {
                    position = 0;
                }
                FTSSearchNoActionBarView fTSSearchNoActionBarView = this.Axh.AwI;
                if (!(fTSSearchNoActionBarView == null || (ftsEditText2 = fTSSearchNoActionBarView.getFtsEditText()) == null)) {
                    ftsEditText2.gUA();
                }
                FTSSearchNoActionBarView fTSSearchNoActionBarView2 = this.Axh.AwI;
                if (!(fTSSearchNoActionBarView2 == null || (ftsEditText = fTSSearchNoActionBarView2.getFtsEditText()) == null)) {
                    ftsEditText.hideVKB();
                }
                switch (position) {
                    case 0:
                        RecyclerView recyclerView = this.Axh.AwC;
                        if (recyclerView != null) {
                            recyclerView.setVisibility(0);
                        }
                        RelativeLayout relativeLayout = this.Axh.AwE;
                        if (relativeLayout != null) {
                            relativeLayout.setVisibility(4);
                            break;
                        }
                        break;
                    case 1:
                        RecyclerView recyclerView2 = this.Axh.AwC;
                        if (recyclerView2 != null) {
                            recyclerView2.setVisibility(4);
                        }
                        RelativeLayout relativeLayout2 = this.Axh.AwE;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(0);
                            break;
                        }
                        break;
                }
                MusicMVCardChooseView.r(this.Axh);
                AppMethodBeat.o(257432);
                return;
            }
            AppMethodBeat.o(257432);
        }
    }

    public final void ewl() {
        TabLayout.f ab;
        TabLayout.f cW;
        TabLayout tabLayout;
        AppMethodBeat.i(257437);
        this.hPb = (WeImageView) findViewById(R.id.b46);
        WeImageView weImageView = this.hPb;
        if (weImageView != null) {
            weImageView.setVisibility(8);
        }
        WeImageView weImageView2 = this.hPb;
        if (weImageView2 != null) {
            weImageView2.setOnClickListener(new n(this));
        }
        this.AwB = (TabLayout) findViewById(R.id.iqx);
        TabLayout tabLayout2 = this.AwB;
        if (tabLayout2 != null) {
            tabLayout2.a(this.AwX);
        }
        int size = this.AwW.size();
        for (int i2 = 0; i2 < size; i2++) {
            TabLayout tabLayout3 = this.AwB;
            if (!(tabLayout3 == null || (cW = tabLayout3.cW()) == null || (tabLayout = this.AwB) == null)) {
                tabLayout.a(cW);
            }
            TabLayout tabLayout4 = this.AwB;
            if (!(tabLayout4 == null || (ab = tabLayout4.ab(i2)) == null)) {
                ab.d(this.AwW.get(i2));
            }
        }
        AppMethodBeat.o(257437);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        n(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257422);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initTitleArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMVCardChooseView.a(this.Axh, true, (kotlin.g.a.a) null, 6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initTitleArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257422);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-mv_release"})
    public static final class g extends RecyclerView.l {
        final /* synthetic */ MusicMVCardChooseView Axh;
        final /* synthetic */ FirstRowLayoutManager Axl;

        public g(MusicMVCardChooseView musicMVCardChooseView, FirstRowLayoutManager firstRowLayoutManager) {
            this.Axh = musicMVCardChooseView;
            this.Axl = firstRowLayoutManager;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int i3;
            AppMethodBeat.i(257413);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "scroll state[%d]", Integer.valueOf(i2));
            if (1 == i2) {
                com.tencent.mm.plugin.gallery.model.e.dQJ().dQE();
            } else if (i2 == 0) {
                this.Axh.xoE = this.Axl.ks();
                this.Axh.oEo = this.Axl.ku();
                Log.d("MicroMsg.Mv.MusicMVCardChooseView", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", Integer.valueOf(this.Axh.xoE), Integer.valueOf(this.Axh.oEo));
                com.tencent.mm.plugin.mv.ui.adapter.b bVar2 = this.Axh.AwD;
                if (bVar2 != null) {
                    int size = bVar2.ArI.size();
                    p.a aVar = com.tencent.mm.plugin.gallery.model.p.xjw;
                    com.tencent.mm.plugin.gallery.model.p.xjv.a(p.c.IDLE, this.Axh.xoE, this.Axh.oEo, size);
                }
            } else if (2 == i2) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.Axh.gsi);
                MusicMVCardChooseView musicMVCardChooseView = this.Axh;
                boolean z = WXHardCoderJNI.hcAlbumScrollEnable;
                int i4 = WXHardCoderJNI.hcAlbumScrollDelay;
                int i5 = WXHardCoderJNI.hcAlbumScrollCPU;
                int i6 = WXHardCoderJNI.hcAlbumScrollIO;
                if (WXHardCoderJNI.hcAlbumScrollThr) {
                    i3 = Process.myTid();
                } else {
                    i3 = 0;
                }
                musicMVCardChooseView.gsi = WXHardCoderJNI.startPerformance(z, i4, i5, i6, i3, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.Mv.MusicMVCardChooseView");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(257413);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            GalleryItem.MediaItem mediaItem;
            AppMethodBeat.i(257414);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            int ks = this.Axl.ks();
            int ku = this.Axl.ku();
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "pennqin, onScrolled, %s %s %s %s.", Integer.valueOf(ks), Integer.valueOf(ku), Integer.valueOf(this.Axh.xoE), Integer.valueOf(this.Axh.oEo));
            if (!(this.Axh.xoE == ks && this.Axh.oEo == ku)) {
                this.Axh.xoE = ks;
                this.Axh.oEo = ku;
                ArrayList arrayList = new ArrayList();
                int i4 = this.Axh.xoE;
                int i5 = this.Axh.oEo;
                if (i4 <= i5) {
                    while (true) {
                        com.tencent.mm.plugin.mv.ui.adapter.b bVar2 = this.Axh.AwD;
                        if (bVar2 != null) {
                            mediaItem = bVar2.NK(i4);
                        } else {
                            mediaItem = null;
                        }
                        if (mediaItem != null && !Util.isNullOrNil(mediaItem.aQn())) {
                            arrayList.add(com.tencent.mm.plugin.gallery.a.d.a(mediaItem.aQn(), (s.e) null, -1));
                        }
                        if (i4 == i5) {
                            break;
                        }
                        i4++;
                    }
                }
                Log.d("MicroMsg.Mv.MusicMVCardChooseView", "cancelTask, legalPaths size: %s.", Integer.valueOf(arrayList.size()));
                com.tencent.mm.plugin.gallery.model.e.dQJ().eT(arrayList);
                if (i3 != 0) {
                    if (i3 < 0) {
                        this.Axh.xoD = p.c.UP;
                    } else {
                        this.Axh.xoD = p.c.DOWN;
                    }
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onScrolled, dy: %s state: %s.", Integer.valueOf(i3), this.Axh.xoD);
                    com.tencent.mm.plugin.mv.ui.adapter.b bVar3 = this.Axh.AwD;
                    if (bVar3 != null) {
                        int size = bVar3.ArI.size();
                        p.a aVar = com.tencent.mm.plugin.gallery.model.p.xjw;
                        com.tencent.mm.plugin.gallery.model.p.xjv.a(this.Axh.xoD, this.Axh.xoE, this.Axh.oEo, size);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(257414);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class i implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public i(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257417);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initEditView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b unused = this.Axh.AwV;
            MusicMVCardChooseView.g(this.Axh);
            MusicMVCardChooseView.a(this.Axh, false, (kotlin.g.a.a) new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.i.AnonymousClass1 */
                final /* synthetic */ i Axm;

                {
                    this.Axm = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(257416);
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "afterModeChanged, onModeChanged:false, showVKB");
                    MusicMVCardChooseView.h(this.Axm.Axh);
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(257416);
                    return xVar;
                }
            }, 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initEditView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257417);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "onItemClicked", "", "errType", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
    public static final class e implements MusicMvTabFragment.b {
        final /* synthetic */ MusicMVCardChooseView Axh;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "progress", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Float, kotlin.x> {
            final /* synthetic */ z.d Axi;
            final /* synthetic */ z.d Axj;
            final /* synthetic */ RecyclerView tDJ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(z.d dVar, z.d dVar2, RecyclerView recyclerView) {
                super(1);
                this.Axi = dVar;
                this.Axj = dVar2;
                this.tDJ = recyclerView;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(Float f2) {
                AppMethodBeat.i(257409);
                int floatValue = (int) (f2.floatValue() * ((float) this.Axi.SYE));
                int i2 = floatValue - this.Axj.SYE;
                this.Axj.SYE = floatValue;
                this.tDJ.scrollBy(0, i2);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(257409);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.b
        public final void a(MusicMvTabFragment.f fVar, View view, RecyclerView recyclerView) {
            AppMethodBeat.i(257411);
            kotlin.g.b.p.h(fVar, "data");
            kotlin.g.b.p.h(view, "itemView");
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            boolean z = this.Axh.Axb;
            z.d dVar = new z.d();
            dVar.SYE = 0;
            z.d dVar2 = new z.d();
            dVar2.SYE = 0;
            if (!z) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(layoutManager, "recyclerView.layoutManager!!");
                int decoratedTop = layoutManager.getDecoratedTop(view);
                int paddingTop = layoutManager.getPaddingTop();
                int i2 = decoratedTop - paddingTop;
                Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] viewTop: " + decoratedTop + ", boxTop:" + paddingTop + ", offsetOfMoveToFirstRow:" + i2);
                int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int height = recyclerView.getHeight();
                int height2 = view.getHeight();
                int i3 = ((computeVerticalScrollRange - computeVerticalScrollOffset) - height) + (this.Axh.maxHeight - this.Axh.minHeight);
                Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] totalHeight: " + computeVerticalScrollRange + ", scrollY:" + computeVerticalScrollOffset + ", albumRvHeight:" + height + ", itemHeight:" + height2 + ", availableSpace:" + i3);
                dVar.SYE = Math.max(0, Math.min(i2, i3));
            }
            MusicMVCardChooseView.a(this.Axh, new a(dVar, dVar2, recyclerView), new b(this, view, fVar));
            AppMethodBeat.o(257411);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ MusicMvTabFragment.f Aro;
            final /* synthetic */ e Axk;
            final /* synthetic */ View rsM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar, View view, MusicMvTabFragment.f fVar) {
                super(0);
                this.Axk = eVar;
                this.rsM = view;
                this.Aro = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                com.tencent.mm.plugin.mv.a.f fVar;
                AppMethodBeat.i(257410);
                try {
                    ImageView imageView = (ImageView) this.rsM.findViewById(R.id.j6n);
                    kotlin.g.b.p.g(imageView, "thumbIv");
                    fVar = com.tencent.mm.plugin.mv.a.g.eC(imageView);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Mv.MusicMVCardChooseView", "generate animation info fail:" + e2.getLocalizedMessage());
                    fVar = null;
                }
                b bVar = this.Axk.Axh.AwV;
                if (bVar != null) {
                    bVar.a(this.Aro, fVar);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(257410);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public j(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257418);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMVCardChooseView.e(this.Axh, 0);
            MusicMVCardChooseView.f(this.Axh, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257418);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public k(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257419);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMVCardChooseView.e(this.Axh, 1);
            MusicMVCardChooseView.f(this.Axh, 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257419);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public l(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257420);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMVCardChooseView.e(this.Axh, 2);
            MusicMVCardChooseView.f(this.Axh, 2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257420);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public m(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257421);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMVCardChooseView.e(this.Axh, 3);
            MusicMVCardChooseView.f(this.Axh, 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initFinderBtnArea$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257421);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"})
    public static final class f implements MusicMvTabFragment.c {
        final /* synthetic */ MusicMVCardChooseView Axh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.c
        public final void hx(int i2, int i3) {
            AppMethodBeat.i(257412);
            if (i2 == 4) {
                if (i3 > 0) {
                    TextView textView = this.Axh.vtJ;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    LinearLayout linearLayout = this.Axh.AwK;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    MusicMvTabSearchFragment musicMvTabSearchFragment = this.Axh.AwJ;
                    if (musicMvTabSearchFragment != null) {
                        musicMvTabSearchFragment.setResultView(0);
                        AppMethodBeat.o(257412);
                        return;
                    }
                    AppMethodBeat.o(257412);
                    return;
                }
                TextView textView2 = this.Axh.vtJ;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.Axh.AwK;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                MusicMvTabSearchFragment musicMvTabSearchFragment2 = this.Axh.AwJ;
                if (musicMvTabSearchFragment2 != null) {
                    musicMvTabSearchFragment2.setResultView(8);
                    AppMethodBeat.o(257412);
                    return;
                }
            }
            AppMethodBeat.o(257412);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$mOnItemClickListener$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"})
    public static final class o implements b.d {
        final /* synthetic */ MusicMVCardChooseView Axh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        @Override // com.tencent.mm.plugin.mv.ui.adapter.b.d
        public final void a(int i2, View view, int i3) {
            AppMethodBeat.i(257423);
            switch (i3) {
                case 2:
                    MusicMVCardChooseView.x(this.Axh);
                    AppMethodBeat.o(257423);
                    return;
                case 1:
                    MusicMVCardChooseView.a(this.Axh, i2, view);
                    break;
            }
            AppMethodBeat.o(257423);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public h(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257415);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Axh.Axb) {
                MusicMVCardChooseView.a(this.Axh, false, (kotlin.g.a.a) null, 6);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257415);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean awE() {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.awE():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r0 == null) goto L_0x0022;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4, java.lang.String r5, java.util.List<com.tencent.mm.ui.search.a.c> r6, com.tencent.mm.ui.search.FTSEditTextView.b r7) {
        /*
            r3 = this;
            r2 = 257439(0x3ed9f, float:3.60749E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r4 == 0) goto L_0x0022
            if (r4 != 0) goto L_0x0016
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0016:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r0 = kotlin.n.n.trim(r4)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0025
        L_0x0022:
            java.lang.String r0 = ""
        L_0x0025:
            java.lang.String r1 = "MicroMsg.Mv.MusicMVCardChooseView"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(257440);
        if (z) {
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onEditTextFocusChange, hasFocus:" + z + ", showSearchResultPanel");
            ewn();
            a(this, false, (kotlin.g.a.a) new p(this), 2);
        }
        AppMethodBeat.o(257440);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(257441);
        MusicMvTabSearchFragment musicMvTabSearchFragment = this.AwJ;
        if (musicMvTabSearchFragment != null) {
            musicMvTabSearchFragment.clear();
            AppMethodBeat.o(257441);
            return;
        }
        AppMethodBeat.o(257441);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    private final void ewm() {
        LinearLayout linearLayout;
        AppMethodBeat.i(257442);
        RelativeLayout relativeLayout = this.AwE;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0 || (linearLayout = this.AwH) == null || linearLayout.getVisibility() != 8) {
            WeImageView weImageView = this.AwG;
            if (weImageView != null) {
                weImageView.setVisibility(4);
                AppMethodBeat.o(257442);
                return;
            }
            AppMethodBeat.o(257442);
            return;
        }
        WeImageView weImageView2 = this.AwG;
        if (weImageView2 != null) {
            weImageView2.setVisibility(0);
            AppMethodBeat.o(257442);
            return;
        }
        AppMethodBeat.o(257442);
    }

    private final void ewn() {
        FTSEditTextView ftsEditText;
        AppMethodBeat.i(257443);
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "showSearchResultPanel");
        FTSSearchNoActionBarView fTSSearchNoActionBarView = this.AwI;
        if (!(fTSSearchNoActionBarView == null || (ftsEditText = fTSSearchNoActionBarView.getFtsEditText()) == null)) {
            ftsEditText.clearText();
        }
        MusicMvTabSearchFragment musicMvTabSearchFragment = this.AwJ;
        if (musicMvTabSearchFragment != null) {
            musicMvTabSearchFragment.clear();
        }
        LinearLayout linearLayout = this.AwH;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.AwF;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ewm();
        AppMethodBeat.o(257443);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView.b
    public final void ewk() {
        FTSEditTextView ftsEditText;
        FTSEditTextView ftsEditText2;
        FTSEditTextView ftsEditText3;
        AppMethodBeat.i(257444);
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onClickBackBtn, hideSearchResultPanel");
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "hideSearchResultPanel");
        FTSSearchNoActionBarView fTSSearchNoActionBarView = this.AwI;
        if (!(fTSSearchNoActionBarView == null || (ftsEditText3 = fTSSearchNoActionBarView.getFtsEditText()) == null)) {
            ftsEditText3.clearText();
        }
        FTSSearchNoActionBarView fTSSearchNoActionBarView2 = this.AwI;
        if (!(fTSSearchNoActionBarView2 == null || (ftsEditText2 = fTSSearchNoActionBarView2.getFtsEditText()) == null)) {
            ftsEditText2.gUA();
        }
        FTSSearchNoActionBarView fTSSearchNoActionBarView3 = this.AwI;
        if (!(fTSSearchNoActionBarView3 == null || (ftsEditText = fTSSearchNoActionBarView3.getFtsEditText()) == null)) {
            ftsEditText.hideVKB();
        }
        MusicMvTabSearchFragment musicMvTabSearchFragment = this.AwJ;
        if (musicMvTabSearchFragment != null) {
            musicMvTabSearchFragment.clear();
        }
        LinearLayout linearLayout = this.AwH;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.AwF;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ewm();
        AppMethodBeat.o(257444);
    }

    public final void initView() {
        AppMethodBeat.i(257445);
        MMActivity mMActivity = this.activity;
        if (mMActivity != null) {
            Intent intent = mMActivity.getIntent();
            kotlin.g.b.p.g(intent, "it.intent");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "key=%s | value=%s", str, extras.get(str));
                }
            } else {
                Log.e("MicroMsg.Mv.MusicMVCardChooseView", "initView, oops! no extras data!");
            }
            this.kyt = mMActivity.getIntent().getIntExtra("album_video_max_duration", 10);
            this.xoo = mMActivity.getIntent().getIntExtra("album_video_min_duration", 0);
            this.wnd = mMActivity.getIntent().getIntExtra("max_select_count", 9);
            AppMethodBeat.o(257445);
            return;
        }
        AppMethodBeat.o(257445);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class v implements Runnable {
        final /* synthetic */ MusicMVCardChooseView Axh;

        public v(MusicMVCardChooseView musicMVCardChooseView) {
            this.Axh = musicMVCardChooseView;
        }

        public final void run() {
            ProgressDialog progressDialog;
            AppMethodBeat.i(257430);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onCreate, post delay, dialog show.");
            if (c.SKIP == this.Axh.Axa || (progressDialog = this.Axh.gtM) == null) {
                AppMethodBeat.o(257430);
                return;
            }
            progressDialog.show();
            AppMethodBeat.o(257430);
        }
    }

    public static long ewo() {
        AppMethodBeat.i(257446);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(257446);
        return currentTimeMillis;
    }

    @Override // com.tencent.mm.plugin.gallery.model.i.c
    public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
        boolean z2;
        AppMethodBeat.i(257447);
        if (j2 != this.xov) {
            Log.w("MicroMsg.Mv.MusicMVCardChooseView", "%s %s, not my query, ignore.", Long.valueOf(j2), Long.valueOf(this.xov));
            Log.w("MicroMsg.Mv.MusicMVCardChooseView", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            AppMethodBeat.o(257447);
        } else if (linkedList == null) {
            Log.e("MicroMsg.Mv.MusicMVCardChooseView", "onQueryMediaFinished, null == mediaItems");
            AppMethodBeat.o(257447);
        } else {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.plugin.mv.ui.adapter.b bVar = this.AwD;
            objArr[1] = bVar != null ? Integer.valueOf(bVar.ArI.size()) : null;
            objArr[2] = Integer.valueOf(linkedList.size());
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onQueryMediaFinished: %s %s %s.", objArr);
            com.tencent.mm.plugin.mv.ui.adapter.b bVar2 = this.AwD;
            if (bVar2 != null) {
                if (z || bVar2.ArI.size() > linkedList.size()) {
                    eY(linkedList);
                } else {
                    List<GalleryItem.MediaItem> subList = linkedList.subList(bVar2.ArI.size(), linkedList.size());
                    kotlin.g.b.p.g(subList, "mediaItems.subList(it.mediaCount, mediaItems.size)");
                    eY(subList);
                }
                LinkedList<GalleryItem.MediaItem> linkedList2 = new LinkedList<>(linkedList);
                Object[] objArr2 = new Object[2];
                if (this.AwD == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                objArr2[1] = Util.getStack().toString();
                Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[onQueryMediaFinished] adapter is null?:%s %s", objArr2);
                if (this.AwD != null) {
                    d dVar = new d();
                    dVar.xoS = new WeakReference<>(this.AwD);
                    dVar.xoT = new WeakReference<>(this.gtM);
                    dVar.xoV = new WeakReference<>(this.AwC);
                    dVar.xoW = linkedList2;
                    dVar.xoY = z;
                    if (c.CREATE == this.Axa) {
                        this.Axa = c.SKIP;
                    }
                    com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(dVar);
                }
                AppMethodBeat.o(257447);
                return;
            }
            AppMethodBeat.o(257447);
        }
    }

    private static void eY(List<GalleryItem.MediaItem> list) {
        AppMethodBeat.i(257448);
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "filterNonExistMedia size: %s.", Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList();
        for (GalleryItem.MediaItem mediaItem : list) {
            if (!com.tencent.mm.vfs.s.YS(mediaItem.dRh())) {
                Log.w("MicroMsg.Mv.MusicMVCardChooseView", "filter non exist media: %s.", mediaItem.dRh());
                linkedList.add(mediaItem);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            list.remove((GalleryItem.MediaItem) it.next());
        }
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "filterNonExistMedia cost: %s.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(257448);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged;", "Ljava/lang/Runnable;", "()V", "adapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter;", "getAdapterRef", "()Ljava/lang/ref/WeakReference;", "setAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "dialogRef", "Landroid/app/ProgressDialog;", "getDialogRef", "setDialogRef", "galleryRef", "Landroid/support/v7/widget/RecyclerView;", "getGalleryRef", "setGalleryRef", "isSwitchAlbum", "", "()Z", "setSwitchAlbum", "(Z)V", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getMediaItems", "()Ljava/util/LinkedList;", "setMediaItems", "(Ljava/util/LinkedList;)V", "run", "", "toString", "", "plugin-mv_release"})
    static final class d implements Runnable {
        WeakReference<com.tencent.mm.plugin.mv.ui.adapter.b> xoS;
        WeakReference<ProgressDialog> xoT;
        WeakReference<RecyclerView> xoV;
        LinkedList<GalleryItem.MediaItem> xoW;
        boolean xoY;

        public final void run() {
            int valueOf;
            GalleryItem.MediaItem next;
            int indexOf;
            com.tencent.mm.plugin.mv.ui.adapter.b bVar;
            RecyclerView recyclerView;
            ProgressDialog progressDialog;
            int size;
            AppMethodBeat.i(257407);
            Object[] objArr = new Object[1];
            if (this.xoW == null) {
                valueOf = -1;
            } else {
                LinkedList<GalleryItem.MediaItem> linkedList = this.xoW;
                valueOf = linkedList != null ? Integer.valueOf(linkedList.size()) : null;
            }
            objArr[0] = valueOf;
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "on NotifyMediaItemsChanged, size %d", objArr);
            a aVar = MusicMVCardChooseView.Axd;
            LinkedList<GalleryItem.MediaItem> linkedList2 = this.xoW;
            if (linkedList2 == null) {
                Log.e("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] mMediaItems is null!");
            } else {
                HashSet<GalleryItem.MediaItem> dQN = com.tencent.mm.plugin.gallery.model.e.dQN();
                if (dQN == null || dQN.isEmpty()) {
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "editedMediaSet is invalid.");
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] size:%s", Integer.valueOf(linkedList2.size()));
                    Iterator<GalleryItem.MediaItem> it = dQN.iterator();
                    while (it.hasNext() && -1 != (indexOf = linkedList2.indexOf((next = it.next())))) {
                        GalleryItem.MediaItem mediaItem = linkedList2.get(indexOf);
                        kotlin.g.b.p.g(mediaItem, "mMediaItems[i]");
                        GalleryItem.MediaItem mediaItem2 = mediaItem;
                        if (mediaItem2 != null && kotlin.g.b.p.j(next.mMimeType, "edit") && (!kotlin.g.b.p.j(mediaItem2.mMimeType, "edit"))) {
                            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "item:%s, editItem:%s", mediaItem2, next);
                            linkedList2.set(indexOf, next);
                        }
                    }
                    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
            if (this.xoS == null) {
                Log.w("MicroMsg.Mv.MusicMVCardChooseView", "null == adapterRef");
                AppMethodBeat.o(257407);
                return;
            }
            WeakReference<com.tencent.mm.plugin.mv.ui.adapter.b> weakReference = this.xoS;
            if (weakReference != null) {
                bVar = weakReference.get();
            } else {
                bVar = null;
            }
            if (bVar == null) {
                Log.w("MicroMsg.Mv.MusicMVCardChooseView", "null == adapter");
                AppMethodBeat.o(257407);
            } else if (this.xoV == null) {
                AppMethodBeat.o(257407);
            } else {
                WeakReference<RecyclerView> weakReference2 = this.xoV;
                if (weakReference2 == null || (recyclerView = weakReference2.get()) == null) {
                    AppMethodBeat.o(257407);
                    return;
                }
                kotlin.g.b.p.g(recyclerView, "galleryRef?.get() ?: return");
                Log.d("MicroMsg.Mv.MusicMVCardChooseView", "isSwitchAlbum: %s.", Boolean.valueOf(this.xoY));
                if (this.xoT == null) {
                    AppMethodBeat.o(257407);
                    return;
                }
                LinkedList<GalleryItem.MediaItem> linkedList3 = this.xoW;
                if (linkedList3 != null) {
                    p.a aVar2 = com.tencent.mm.plugin.gallery.model.p.xjw;
                    com.tencent.mm.plugin.gallery.model.p.xjv.eU(linkedList3);
                    if (this.xoY) {
                        this.xoY = false;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                        kotlin.g.b.p.h(linkedList3, "mediaItems");
                        bVar.ArI.clear();
                        bVar.ArI.addAll(linkedList3);
                        bVar.notifyDataSetChanged();
                        p.a aVar3 = com.tencent.mm.plugin.gallery.model.p.xjw;
                        com.tencent.mm.plugin.gallery.model.p pVar = com.tencent.mm.plugin.gallery.model.p.xjv;
                        p.c cVar = p.c.IDLE;
                        if (linkedList3.size() > 32) {
                            size = 32;
                        } else {
                            size = linkedList3.size();
                        }
                        pVar.a(cVar, 0, size, bVar.ArI.size());
                    } else {
                        bVar.aN(linkedList3);
                    }
                }
                WeakReference<ProgressDialog> weakReference3 = this.xoT;
                if (weakReference3 != null) {
                    progressDialog = weakReference3.get();
                } else {
                    progressDialog = null;
                }
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[NotifyMediaItemsChanged] cost:%s", Long.valueOf(System.currentTimeMillis() - MusicMVCardChooseView.start));
                }
                AppMethodBeat.o(257407);
            }
        }

        public final String toString() {
            AppMethodBeat.i(257408);
            String str = super.toString() + "|NotifyMediaItemsChanged";
            AppMethodBeat.o(257408);
            return str;
        }
    }

    public static /* synthetic */ void a(MusicMVCardChooseView musicMVCardChooseView, int i2) {
        AppMethodBeat.i(257450);
        musicMVCardChooseView.a(0, i2, false, null, null);
        AppMethodBeat.o(257450);
    }

    private final void a(int i2, int i3, boolean z, kotlin.g.a.b<? super Float, kotlin.x> bVar, kotlin.g.a.a<kotlin.x> aVar) {
        AppMethodBeat.i(257449);
        View findViewById = findViewById(R.id.bqs);
        if (findViewById == null) {
            AppMethodBeat.o(257449);
        } else if (!z) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i3;
            findViewById.setLayoutParams(layoutParams);
            if (bVar != null) {
                bVar.invoke(Float.valueOf(1.0f));
            }
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(257449);
                return;
            }
            AppMethodBeat.o(257449);
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
            ofInt.addUpdateListener(new x(findViewById, z, i3, bVar, aVar, i2));
            ofInt.addListener(new y(z, i3, bVar, aVar, i2));
            kotlin.g.b.p.g(ofInt, "heightAnim");
            ofInt.setDuration(300L);
            ofInt.start();
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim start");
            AppMethodBeat.o(257449);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$updateViewHeight$1$2"})
    public static final class x implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View Axq;
        final /* synthetic */ boolean Axr;
        final /* synthetic */ int Axs;
        final /* synthetic */ kotlin.g.a.b Axt;
        final /* synthetic */ kotlin.g.a.a Axu;
        final /* synthetic */ int Axv;

        x(View view, boolean z, int i2, kotlin.g.a.b bVar, kotlin.g.a.a aVar, int i3) {
            this.Axq = view;
            this.Axr = z;
            this.Axs = i2;
            this.Axt = bVar;
            this.Axu = aVar;
            this.Axv = i3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(257433);
            kotlin.g.b.p.g(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(257433);
                throw tVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            View view = this.Axq;
            ViewGroup.LayoutParams layoutParams = this.Axq.getLayoutParams();
            layoutParams.height = intValue;
            view.setLayoutParams(layoutParams);
            kotlin.g.a.b bVar = this.Axt;
            if (bVar != null) {
                bVar.invoke(Float.valueOf(((float) (intValue - this.Axv)) / ((float) (this.Axs - this.Axv))));
                AppMethodBeat.o(257433);
                return;
            }
            AppMethodBeat.o(257433);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$updateViewHeight$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "plugin-mv_release"})
    public static final class y extends AnimatorListenerAdapter {
        final /* synthetic */ boolean Axr;
        final /* synthetic */ int Axs;
        final /* synthetic */ kotlin.g.a.b Axt;
        final /* synthetic */ kotlin.g.a.a Axu;
        final /* synthetic */ int Axv;

        y(boolean z, int i2, kotlin.g.a.b bVar, kotlin.g.a.a aVar, int i3) {
            this.Axr = z;
            this.Axs = i2;
            this.Axt = bVar;
            this.Axu = aVar;
            this.Axv = i3;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(257434);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationEnd");
            kotlin.g.a.a aVar = this.Axu;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(257434);
                return;
            }
            AppMethodBeat.o(257434);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(257435);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationPause");
            AppMethodBeat.o(257435);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(257436);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationCancel");
            AppMethodBeat.o(257436);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(MusicMVCardChooseView musicMVCardChooseView, boolean z, kotlin.g.a.a aVar, int i2) {
        AppMethodBeat.i(257452);
        if ((i2 & 4) != 0) {
            aVar = null;
        }
        musicMVCardChooseView.a(z, (kotlin.g.a.b<? super Float, kotlin.x>) null, aVar);
        AppMethodBeat.o(257452);
    }

    private final void a(boolean z, kotlin.g.a.b<? super Float, kotlin.x> bVar, kotlin.g.a.a<kotlin.x> aVar) {
        FTSEditTextView ftsEditText;
        FTSEditTextView ftsEditText2;
        AppMethodBeat.i(257451);
        if (!this.Axb && z) {
            this.Anw = true;
            Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, change2Min:true, hideSearchResultPanel");
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "hideSearchResultPanel");
            FTSSearchNoActionBarView fTSSearchNoActionBarView = this.AwI;
            if (!(fTSSearchNoActionBarView == null || (ftsEditText2 = fTSSearchNoActionBarView.getFtsEditText()) == null)) {
                ftsEditText2.gUA();
            }
            FTSSearchNoActionBarView fTSSearchNoActionBarView2 = this.AwI;
            if (!(fTSSearchNoActionBarView2 == null || (ftsEditText = fTSSearchNoActionBarView2.getFtsEditText()) == null)) {
                ftsEditText.hideVKB();
            }
            WeImageView weImageView = this.hPb;
            if (weImageView != null) {
                weImageView.setVisibility(8);
            }
            TabLayout tabLayout = this.AwB;
            if (tabLayout != null) {
                tabLayout.animate().translationX(0.0f).setDuration(300).start();
            }
            a(this.maxHeight, this.minHeight, true, bVar, new t(this, aVar));
        } else if (!this.Axb || z) {
            Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, else");
            if (aVar != null) {
                aVar.invoke();
            }
        } else {
            this.Anw = true;
            Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, change2Min:false");
            int fromDPToPix = (this.mEX / 2) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
            WeImageView weImageView2 = this.hPb;
            if (weImageView2 != null) {
                weImageView2.setVisibility(0);
            }
            TabLayout tabLayout2 = this.AwB;
            if (tabLayout2 != null) {
                tabLayout2.animate().translationX(((float) (fromDPToPix - (tabLayout2.getWidth() / 2))) * 1.0f).setDuration(300).start();
            }
            a(this.minHeight, this.maxHeight, true, bVar, new u(this, aVar));
        }
        this.Axb = z;
        AppMethodBeat.o(257451);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(257453);
        if (this.AwT) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(257453);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(257453);
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MusicMVCardChooseView Axh;
        final /* synthetic */ GalleryItem.MediaItem Axo;
        final /* synthetic */ View rsM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(MusicMVCardChooseView musicMVCardChooseView, View view, GalleryItem.MediaItem mediaItem) {
            super(0);
            this.Axh = musicMVCardChooseView;
            this.rsM = view;
            this.Axo = mediaItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257427);
            com.tencent.mm.plugin.mv.a.f fVar = null;
            if (this.rsM != null) {
                try {
                    ImageView imageView = (ImageView) this.rsM.findViewById(R.id.fc1);
                    kotlin.g.b.p.g(imageView, "thumbIv");
                    fVar = com.tencent.mm.plugin.mv.a.g.eC(imageView);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Mv.MusicMVCardChooseView", "generate animation info fail:" + e2.getLocalizedMessage());
                }
            }
            com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
            com.tencent.mm.plugin.mv.a.l.axc(2);
            b bVar = this.Axh.AwV;
            if (bVar != null) {
                GalleryItem.MediaItem mediaItem = this.Axo;
                if (mediaItem == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
                    AppMethodBeat.o(257427);
                    throw tVar;
                }
                bVar.a((GalleryItem.VideoMediaItem) mediaItem, fVar);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257427);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MusicMVCardChooseView Axh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(MusicMVCardChooseView musicMVCardChooseView) {
            super(0);
            this.Axh = musicMVCardChooseView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257424);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "afterModeChanged, onModeChanged:false, showVKB");
            MusicMVCardChooseView.h(this.Axh);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257424);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MusicMVCardChooseView Axh;
        final /* synthetic */ kotlin.g.a.a Axp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(MusicMVCardChooseView musicMVCardChooseView, kotlin.g.a.a aVar) {
            super(0);
            this.Axh = musicMVCardChooseView;
            this.Axp = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257428);
            kotlin.g.a.a aVar = this.Axp;
            if (aVar != null) {
                aVar.invoke();
            }
            this.Axh.Anw = false;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257428);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MusicMVCardChooseView Axh;
        final /* synthetic */ kotlin.g.a.a Axp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(MusicMVCardChooseView musicMVCardChooseView, kotlin.g.a.a aVar) {
            super(0);
            this.Axh = musicMVCardChooseView;
            this.Axp = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(257429);
            kotlin.g.a.a aVar = this.Axp;
            if (aVar != null) {
                aVar.invoke();
            }
            this.Axh.Anw = false;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(257429);
            return xVar;
        }
    }

    public static final /* synthetic */ void h(MusicMVCardChooseView musicMVCardChooseView) {
        FTSEditTextView ftsEditText;
        FTSEditTextView ftsEditText2;
        AppMethodBeat.i(257458);
        FTSSearchNoActionBarView fTSSearchNoActionBarView = musicMVCardChooseView.AwI;
        if (!(fTSSearchNoActionBarView == null || (ftsEditText2 = fTSSearchNoActionBarView.getFtsEditText()) == null)) {
            ftsEditText2.awD();
        }
        FTSSearchNoActionBarView fTSSearchNoActionBarView2 = musicMVCardChooseView.AwI;
        if (fTSSearchNoActionBarView2 == null || (ftsEditText = fTSSearchNoActionBarView2.getFtsEditText()) == null) {
            AppMethodBeat.o(257458);
            return;
        }
        ftsEditText.showVKB();
        AppMethodBeat.o(257458);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void e(MusicMVCardChooseView musicMVCardChooseView, int i2) {
        AppMethodBeat.i(257459);
        TextView textView = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fsp);
        if (textView != null) {
            Context context = musicMVCardChooseView.getContext();
            kotlin.g.b.p.g(context, "context");
            textView.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        TextView textView2 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fss);
        if (textView2 != null) {
            Context context2 = musicMVCardChooseView.getContext();
            kotlin.g.b.p.g(context2, "context");
            textView2.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        TextView textView3 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fso);
        if (textView3 != null) {
            Context context3 = musicMVCardChooseView.getContext();
            kotlin.g.b.p.g(context3, "context");
            textView3.setTextColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        TextView textView4 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fsq);
        if (textView4 != null) {
            Context context4 = musicMVCardChooseView.getContext();
            kotlin.g.b.p.g(context4, "context");
            textView4.setTextColor(context4.getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        switch (i2) {
            case 0:
                TextView textView5 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fsp);
                if (textView5 != null) {
                    Context context5 = musicMVCardChooseView.getContext();
                    kotlin.g.b.p.g(context5, "context");
                    textView5.setTextColor(context5.getResources().getColor(R.color.BW_100_Alpha_0_9));
                    AppMethodBeat.o(257459);
                    return;
                }
                AppMethodBeat.o(257459);
                return;
            case 1:
                TextView textView6 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fss);
                if (textView6 != null) {
                    Context context6 = musicMVCardChooseView.getContext();
                    kotlin.g.b.p.g(context6, "context");
                    textView6.setTextColor(context6.getResources().getColor(R.color.BW_100_Alpha_0_9));
                    AppMethodBeat.o(257459);
                    return;
                }
                AppMethodBeat.o(257459);
                return;
            case 2:
                TextView textView7 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fso);
                if (textView7 != null) {
                    Context context7 = musicMVCardChooseView.getContext();
                    kotlin.g.b.p.g(context7, "context");
                    textView7.setTextColor(context7.getResources().getColor(R.color.BW_100_Alpha_0_9));
                    AppMethodBeat.o(257459);
                    return;
                }
                AppMethodBeat.o(257459);
                return;
            case 3:
                TextView textView8 = (TextView) musicMVCardChooseView._$_findCachedViewById(R.id.fsq);
                if (textView8 != null) {
                    Context context8 = musicMVCardChooseView.getContext();
                    kotlin.g.b.p.g(context8, "context");
                    textView8.setTextColor(context8.getResources().getColor(R.color.BW_100_Alpha_0_9));
                    AppMethodBeat.o(257459);
                    return;
                }
                break;
        }
        AppMethodBeat.o(257459);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void f(MusicMVCardChooseView musicMVCardChooseView, int i2) {
        AppMethodBeat.i(257460);
        MusicMvTabMachineFragment musicMvTabMachineFragment = musicMVCardChooseView.AwP;
        if (musicMvTabMachineFragment != null) {
            musicMvTabMachineFragment.setVisibility(8);
        }
        MusicMvTabMyPostFragment musicMvTabMyPostFragment = musicMVCardChooseView.AwQ;
        if (musicMvTabMyPostFragment != null) {
            musicMvTabMyPostFragment.setVisibility(8);
        }
        MusicMvTabMyFavFragment musicMvTabMyFavFragment = musicMVCardChooseView.AwR;
        if (musicMvTabMyFavFragment != null) {
            musicMvTabMyFavFragment.setVisibility(8);
        }
        MusicMvTabMyLikeFragment musicMvTabMyLikeFragment = musicMVCardChooseView.AwS;
        if (musicMvTabMyLikeFragment != null) {
            musicMvTabMyLikeFragment.setVisibility(8);
        }
        switch (i2) {
            case 0:
                MusicMvTabMachineFragment musicMvTabMachineFragment2 = musicMVCardChooseView.AwP;
                if (musicMvTabMachineFragment2 != null) {
                    musicMvTabMachineFragment2.setVisibility(0);
                    AppMethodBeat.o(257460);
                    return;
                }
                AppMethodBeat.o(257460);
                return;
            case 1:
                MusicMvTabMyPostFragment musicMvTabMyPostFragment2 = musicMVCardChooseView.AwQ;
                if (musicMvTabMyPostFragment2 != null) {
                    musicMvTabMyPostFragment2.setVisibility(0);
                    AppMethodBeat.o(257460);
                    return;
                }
                AppMethodBeat.o(257460);
                return;
            case 2:
                MusicMvTabMyFavFragment musicMvTabMyFavFragment2 = musicMVCardChooseView.AwR;
                if (musicMvTabMyFavFragment2 != null) {
                    musicMvTabMyFavFragment2.setVisibility(0);
                    AppMethodBeat.o(257460);
                    return;
                }
                AppMethodBeat.o(257460);
                return;
            case 3:
                MusicMvTabMyLikeFragment musicMvTabMyLikeFragment2 = musicMVCardChooseView.AwS;
                if (musicMvTabMyLikeFragment2 != null) {
                    musicMvTabMyLikeFragment2.setVisibility(0);
                    AppMethodBeat.o(257460);
                    return;
                }
                break;
        }
        AppMethodBeat.o(257460);
    }

    public static final /* synthetic */ void x(MusicMVCardChooseView musicMVCardChooseView) {
        AppMethodBeat.i(257463);
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "on click open camera, valid click times[%d]", Integer.valueOf(musicMVCardChooseView.xoj));
        if (musicMVCardChooseView.xoh) {
            Log.w("MicroMsg.Mv.MusicMVCardChooseView", "click open camera, but camera is opening");
            AppMethodBeat.o(257463);
            return;
        }
        musicMVCardChooseView.xoj++;
        musicMVCardChooseView.xoh = true;
        b bVar = musicMVCardChooseView.AwV;
        if (bVar != null) {
            bVar.Tk((com.tencent.mm.plugin.mv.ui.a.e.Tl(Axc) * 1000) + 500);
            AppMethodBeat.o(257463);
            return;
        }
        AppMethodBeat.o(257463);
    }

    public static final /* synthetic */ void a(MusicMVCardChooseView musicMVCardChooseView, int i2, View view) {
        AppMethodBeat.i(257464);
        com.tencent.mm.plugin.mv.ui.adapter.b bVar = musicMVCardChooseView.AwD;
        GalleryItem.MediaItem NK = bVar != null ? bVar.NK(i2) : null;
        if (NK == null || Util.isNullOrNil(NK.dRh())) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(NK == null);
            Log.w("MicroMsg.Mv.MusicMVCardChooseView", "item is null %s, item original path is null", objArr);
            AppMethodBeat.o(257464);
            return;
        }
        if (NK instanceof GalleryItem.VideoMediaItem) {
            int i3 = ((GalleryItem.VideoMediaItem) NK).jkS;
            if (com.tencent.mm.plugin.mv.ui.a.e.Tm(i3) < com.tencent.mm.plugin.mv.ui.a.e.Tl(Axc)) {
                Log.w("MicroMsg.Mv.MusicMVCardChooseView", "durationMs:" + i3 + " is not in range of choose to mv ");
                com.tencent.mm.ui.base.u.cE(musicMVCardChooseView.getContext(), musicMVCardChooseView.getContext().getString(R.string.dnb, Integer.valueOf(com.tencent.mm.plugin.mv.ui.a.e.Tl(Axc))));
                AppMethodBeat.o(257464);
                return;
            }
        }
        boolean z = musicMVCardChooseView.Axb;
        z.d dVar = new z.d();
        dVar.SYE = 0;
        z.d dVar2 = new z.d();
        dVar2.SYE = 0;
        if (!z) {
            RecyclerView recyclerView = musicMVCardChooseView.AwC;
            if (recyclerView == null) {
                kotlin.g.b.p.hyc();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(layoutManager, "albumChooseRV!!.layoutManager!!");
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            int decoratedTop = layoutManager.getDecoratedTop(view);
            int paddingTop = layoutManager.getPaddingTop();
            int i4 = decoratedTop - paddingTop;
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] viewTop: " + decoratedTop + ", boxTop:" + paddingTop + ", offsetOfMoveToFirstRow:" + i4);
            RecyclerView recyclerView2 = musicMVCardChooseView.AwC;
            if (recyclerView2 == null) {
                kotlin.g.b.p.hyc();
            }
            int computeVerticalScrollRange = recyclerView2.computeVerticalScrollRange();
            RecyclerView recyclerView3 = musicMVCardChooseView.AwC;
            if (recyclerView3 == null) {
                kotlin.g.b.p.hyc();
            }
            int computeVerticalScrollOffset = recyclerView3.computeVerticalScrollOffset();
            RecyclerView recyclerView4 = musicMVCardChooseView.AwC;
            if (recyclerView4 == null) {
                kotlin.g.b.p.hyc();
            }
            int height = recyclerView4.getHeight();
            int height2 = view.getHeight();
            int i5 = ((computeVerticalScrollRange - computeVerticalScrollOffset) - height) + (musicMVCardChooseView.maxHeight - musicMVCardChooseView.minHeight);
            Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] totalHeight: " + computeVerticalScrollRange + ", scrollY:" + computeVerticalScrollOffset + ", albumRvHeight:" + height + ", itemHeight:" + height2 + ", availableSpace:" + i5);
            dVar.SYE = Math.max(0, Math.min(i4, i5));
        }
        musicMVCardChooseView.a(true, (kotlin.g.a.b<? super Float, kotlin.x>) new r(musicMVCardChooseView, z, dVar, dVar2), (kotlin.g.a.a<kotlin.x>) new s(musicMVCardChooseView, view, NK));
        AppMethodBeat.o(257464);
    }
}
