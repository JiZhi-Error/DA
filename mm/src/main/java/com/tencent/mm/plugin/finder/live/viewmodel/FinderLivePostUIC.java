package com.tencent.mm.plugin.finder.live.viewmodel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.live.widget.d;
import com.tencent.mm.plugin.finder.live.widget.e;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ó\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\nñ\u0001ò\u0001ó\u0001ô\u0001õ\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010«\u0001\u001a\u00020uH\u0002J\u0007\u0010¬\u0001\u001a\u00020uJ\t\u0010­\u0001\u001a\u00020uH\u0002J\b\u0010®\u0001\u001a\u00030¯\u0001J\n\u0010°\u0001\u001a\u00030¯\u0001H\u0002J\t\u0010±\u0001\u001a\u00020uH\u0002J\u0012\u0010²\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020\bH\u0002J\t\u0010´\u0001\u001a\u00020uH\u0002J\t\u0010µ\u0001\u001a\u00020uH\u0002J\t\u0010¶\u0001\u001a\u00020uH\u0002J\t\u0010·\u0001\u001a\u00020uH\u0002J\t\u0010¸\u0001\u001a\u00020uH\u0002J1\u0010¹\u0001\u001a\u00020u2\b\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\b\u0010½\u0001\u001a\u00030»\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010»\u0001J\t\u0010¿\u0001\u001a\u00020uH\u0002J\t\u0010À\u0001\u001a\u00020uH\u0002J\t\u0010Á\u0001\u001a\u00020uH\u0002J\t\u0010Â\u0001\u001a\u00020uH\u0002J\t\u0010Ã\u0001\u001a\u00020uH\u0002J\t\u0010Ä\u0001\u001a\u00020uH\u0002J\t\u0010Å\u0001\u001a\u00020uH\u0002JE\u0010Æ\u0001\u001a\u00020u2\u0007\u0010Ç\u0001\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010M\u001a\u00020N2!\u0010v\u001a\u001d\u0012\u0013\u0012\u00110w¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020u0pJ\n\u0010È\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010É\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030¯\u0001H\u0002J\t\u0010Ë\u0001\u001a\u00020uH\u0002J'\u0010Ì\u0001\u001a\u00020u2\u0007\u0010Í\u0001\u001a\u00020\b2\u0007\u0010Î\u0001\u001a\u00020\b2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001H\u0016J\n\u0010Ñ\u0001\u001a\u00030¯\u0001H\u0016J\u0014\u0010Ò\u0001\u001a\u00020u2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010%H\u0016J\u0015\u0010Ô\u0001\u001a\u00020u2\n\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0016J\t\u0010×\u0001\u001a\u00020uH\u0016J\u001a\u0010Ø\u0001\u001a\u00020u2\u0007\u0010Ù\u0001\u001a\u00020\b2\b\u0010Ú\u0001\u001a\u00030¯\u0001J\t\u0010Û\u0001\u001a\u00020uH\u0016J3\u0010Ü\u0001\u001a\u00020u2\u0007\u0010Ý\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\b2\n\u0010ß\u0001\u001a\u0005\u0018\u00010»\u00012\n\u0010à\u0001\u001a\u0005\u0018\u00010á\u0001H\u0016J\u0013\u0010â\u0001\u001a\u00020u2\b\u0010ã\u0001\u001a\u00030ä\u0001H\u0002J\t\u0010å\u0001\u001a\u00020uH\u0002J\u001b\u0010æ\u0001\u001a\u00020u2\u0010\u0010ç\u0001\u001a\u000b\u0012\u0005\u0012\u00030»\u0001\u0018\u00010~H\u0002J\u0007\u0010è\u0001\u001a\u00020uJ\u0013\u0010é\u0001\u001a\u00020u2\n\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001J\t\u0010ì\u0001\u001a\u00020uH\u0002J\t\u0010í\u0001\u001a\u00020uH\u0002J\u0013\u0010î\u0001\u001a\u00020u2\b\u0010ï\u0001\u001a\u00030¯\u0001H\u0002J\t\u0010ð\u0001\u001a\u00020uH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001a\u00109\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\\X.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u00020%X.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010'\"\u0004\bc\u0010)R\u000e\u0010d\u001a\u00020eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020%X.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010'\"\u0004\bh\u0010)R\u001a\u0010i\u001a\u00020jX.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR+\u0010o\u001a\u001f\u0012\u0013\u0012\u00110q¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020u\u0018\u00010pX\u000e¢\u0006\u0002\n\u0000R7\u0010v\u001a\u001f\u0012\u0013\u0012\u00110w¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020u\u0018\u00010pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020q0~X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u00020jX.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010l\"\u0005\b\u0001\u0010nR\u001d\u0010\u0001\u001a\u00020%X.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010'\"\u0005\b\u0001\u0010)R\u001d\u0010\u0001\u001a\u00020%X.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010'\"\u0005\b\u0001\u0010)R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R \u0010\u0001\u001a\u00030\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0011X.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0013\"\u0005\b\u0001\u0010\u0015R\u001d\u0010\u0001\u001a\u00020%X.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010'\"\u0005\b\u0001\u0010)R\u001d\u0010\u0001\u001a\u00020%X.¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010'\"\u0005\b¡\u0001\u0010)R\u001d\u0010¢\u0001\u001a\u00020jX.¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010l\"\u0005\b¤\u0001\u0010nR \u0010¥\u0001\u001a\u00030¦\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001¨\u0006ö\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "SHEET_MORE_ACTION_COMMENT", "", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_SENSITIVE_WORD", "SHEET_MORE_ACTION_VISIBILITY_MODE", "STATE_BEAUTY", "STATE_DEFAULT", "STATE_FILTER", "beautyRootView", "Landroid/widget/RelativeLayout;", "getBeautyRootView", "()Landroid/widget/RelativeLayout;", "setBeautyRootView", "(Landroid/widget/RelativeLayout;)V", "beautyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "getBeautyWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "setBeautyWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "cameraOptPanel", "Landroid/support/v7/widget/RecyclerView;", "getCameraOptPanel", "()Landroid/support/v7/widget/RecyclerView;", "setCameraOptPanel", "(Landroid/support/v7/widget/RecyclerView;)V", "contentRoot", "Landroid/view/View;", "getContentRoot", "()Landroid/view/View;", "setContentRoot", "(Landroid/view/View;)V", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "getCoverWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "setCoverWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;)V", "descWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "getDescWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "setDescWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;)V", "filterRootView", "getFilterRootView", "setFilterRootView", "filterWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "getFilterWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "setFilterWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;)V", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "getLicensePanelWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "setLicensePanelWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;)V", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "getLicenseWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "setLicenseWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;)V", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "liveTagView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "getLiveTagView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "setLiveTagView", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;)V", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "getLuckyMoneyWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "setLuckyMoneyWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;)V", "maskView", "getMaskView", "setMaskView", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "noticeLayout", "getNoticeLayout", "setNoticeLayout", "noticeTimeTxt", "Landroid/widget/TextView;", "getNoticeTimeTxt", "()Landroid/widget/TextView;", "setNoticeTimeTxt", "(Landroid/widget/TextView;)V", "onOptionClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "Lkotlin/ParameterName;", "name", "option", "", "onStartLive", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "getOnStartLive", "()Lkotlin/jvm/functions/Function1;", "setOnStartLive", "(Lkotlin/jvm/functions/Function1;)V", "optList", "Ljava/util/ArrayList;", "postBtn", "getPostBtn", "setPostBtn", "postBtnGroup", "getPostBtnGroup", "setPostBtnGroup", "postLayout", "getPostLayout", "setPostLayout", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "state", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "topBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTopBack", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTopBack", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "topContainer", "getTopContainer", "setTopContainer", "topMoreActionBtn", "getTopMoreActionBtn", "setTopMoreActionBtn", "visibilityGroup", "getVisibilityGroup", "setVisibilityGroup", "visibilityTv", "getVisibilityTv", "setVisibilityTv", "widgetListener", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "getWidgetListener", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "setWidgetListener", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "adjustMargin", "beforeLive", "buildConfirmDialog", "checkIsReadyToPost", "", "checkNetwork", "checkState", "checkVisibilityMode", "anchorChooseMode", "clickBeauty", "clickFilter", "clickMirror", "clickShop", "clickSwitch", "continuePost", "coverUrl", "", "thumbUrl", "path", "md5", "disableComment", "disableGift", "disableLinkMic", "enableComment", "enableGift", "enableLinkMic", "getUserprepareInfo", "initPostLayout", "rootView", "isCommentEnable", "isGiftEnable", "isLinkMicEnable", "loadOptions", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyboardHeightChanged", "height", "show", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "refreshGroupVisibility", "refreshLuckyMoneyChatroom", "chatroomList", "refreshPostState", "setLiveNoticeInfo", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setupConfig", "showLinkConfirmDialog", "startPost", "needPrepare", "tryStartPost", "BeforeOptAdapter", "BeforeOptViewHolder", "Companion", "OptionInfo", "WidgetStatusCallback", "plugin-finder_release"})
public final class FinderLivePostUIC extends UIComponent implements View.OnClickListener, com.tencent.mm.ak.i {
    public static final String TAG = TAG;
    public static final c uDb = new c((byte) 0);
    private final int STATE_DEFAULT;
    public View UPQ;
    public com.tencent.mm.plugin.finder.live.widget.u UPR;
    public com.tencent.mm.live.core.core.a.b hOO;
    public com.tencent.mm.live.c.b hOp;
    private com.tencent.mm.ui.widget.a.e hOv;
    public g liveData;
    public View maskView;
    private int state = this.STATE_DEFAULT;
    private final int uCA;
    private final int uCB = 4;
    private final int uCC = 5;
    public View uCD;
    public TextView uCE;
    public com.tencent.mm.plugin.finder.live.widget.k uCF;
    public com.tencent.mm.plugin.finder.live.widget.h uCG;
    public com.tencent.mm.plugin.finder.live.widget.j uCH;
    public com.tencent.mm.plugin.finder.live.widget.g uCI;
    public com.tencent.mm.plugin.finder.live.widget.i uCJ;
    public RelativeLayout uCK;
    public WeImageView uCL;
    public View uCM;
    public TextView uCN;
    public TextView uCO;
    public RecyclerView uCP;
    public View uCQ;
    public View uCR;
    public RelativeLayout uCS;
    public RelativeLayout uCT;
    public View uCU;
    public com.tencent.mm.plugin.finder.live.widget.n uCV;
    private ArrayList<d> uCW = new ArrayList<>();
    public kotlin.g.a.b<? super d, x> uCX;
    public com.tencent.mm.plugin.finder.api.g uCY;
    public kotlin.g.a.b<? super FinderObjectDesc, x> uCZ;
    private final int uCy = 1;
    private final int uCz = 2;
    public e uDa = new t(this);
    private final o.g uhx = new n(this);
    public com.tencent.mm.plugin.finder.live.widget.e umJ;
    public com.tencent.mm.plugin.finder.live.widget.d umK;
    private final int usT = 1;
    private final int usU = 3;
    private bel vOq;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "", "onChange", "", "plugin-finder_release"})
    public interface e {
        void onChange();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<d, x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(FinderLivePostUIC finderLivePostUIC) {
            super(1);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(d dVar) {
            AppMethodBeat.i(247903);
            d dVar2 = dVar;
            kotlin.g.b.p.h(dVar2, LocaleUtil.ITALIAN);
            c cVar = FinderLivePostUIC.uDb;
            Log.i(FinderLivePostUIC.TAG, "onOptionClick " + dVar2.key);
            switch (dVar2.key) {
                case 0:
                    FinderLivePostUIC.e(this.uDc);
                    break;
                case 1:
                    FinderLivePostUIC.f(this.uDc);
                    break;
                case 2:
                    FinderLivePostUIC.g(this.uDc);
                    break;
                case 3:
                    FinderLivePostUIC.h(this.uDc);
                    break;
                case 4:
                    FinderLivePostUIC.i(this.uDc);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247903);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLivePostUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(247927);
        AppMethodBeat.o(247927);
    }

    public static final /* synthetic */ void d(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247929);
        finderLivePostUIC.diQ();
        AppMethodBeat.o(247929);
    }

    public static final /* synthetic */ void l(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247936);
        finderLivePostUIC.diX();
        AppMethodBeat.o(247936);
    }

    public static final /* synthetic */ boolean n(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247937);
        boolean diT = finderLivePostUIC.diT();
        AppMethodBeat.o(247937);
        return diT;
    }

    public static final /* synthetic */ boolean r(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247938);
        boolean diS = finderLivePostUIC.diS();
        AppMethodBeat.o(247938);
        return diS;
    }

    public static final /* synthetic */ void s(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247939);
        finderLivePostUIC.diR();
        AppMethodBeat.o(247939);
    }

    public static final /* synthetic */ boolean v(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247940);
        boolean diV = finderLivePostUIC.diV();
        AppMethodBeat.o(247940);
        return diV;
    }

    public static final /* synthetic */ void w(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247941);
        finderLivePostUIC.diU();
        AppMethodBeat.o(247941);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247928);
        AppMethodBeat.o(247928);
    }

    public final com.tencent.mm.live.c.b diO() {
        AppMethodBeat.i(247912);
        com.tencent.mm.live.c.b bVar = this.hOp;
        if (bVar == null) {
            kotlin.g.b.p.btv("statusMonitor");
        }
        AppMethodBeat.o(247912);
        return bVar;
    }

    public final WeImageView diP() {
        AppMethodBeat.i(247913);
        WeImageView weImageView = this.uCL;
        if (weImageView == null) {
            kotlin.g.b.p.btv("topBack");
        }
        AppMethodBeat.o(247913);
        return weImageView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class n implements o.g {
        final /* synthetic */ FinderLivePostUIC uDc;

        n(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(247904);
            kotlin.g.b.p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.uDc.uCA) {
                if (FinderLivePostUIC.n(this.uDc)) {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.cwu));
                    FinderLivePostUIC.o(this.uDc);
                } else {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.cws));
                    FinderLivePostUIC.p(this.uDc);
                }
                com.tencent.mm.ui.widget.a.e eVar = this.uDc.hOv;
                if (eVar != null) {
                    eVar.bMo();
                    AppMethodBeat.o(247904);
                    return;
                }
                AppMethodBeat.o(247904);
            } else if (itemId == this.uDc.usT) {
                if (FinderLivePostUIC.r(this.uDc)) {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.ctv));
                    FinderLivePostUIC.s(this.uDc);
                    if (this.uDc.diO().getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.q(s.a.LINKMIC_SWITCH.hlf, String.valueOf(s.y.CLOSE.action));
                    }
                } else {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.ctx));
                    FinderLivePostUIC.t(this.uDc);
                    if (this.uDc.diO().getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.q(s.a.LINKMIC_SWITCH.hlf, String.valueOf(s.y.OPEN.action));
                    }
                }
                com.tencent.mm.ui.widget.a.e eVar2 = this.uDc.hOv;
                if (eVar2 != null) {
                    eVar2.bMo();
                    AppMethodBeat.o(247904);
                    return;
                }
                AppMethodBeat.o(247904);
            } else if (itemId == this.uDc.usU) {
                if (FinderLivePostUIC.v(this.uDc)) {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.csp));
                    FinderLivePostUIC.w(this.uDc);
                    if (this.uDc.diO().getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.q(s.a.GIFT_SWITCCH.hlf, String.valueOf(s.t.CLOSE_SEND_GIFT_BY_MORE.action));
                    }
                } else {
                    com.tencent.mm.ui.base.u.cG(this.uDc.getContext(), this.uDc.getContext().getResources().getString(R.string.csr));
                    FinderLivePostUIC.x(this.uDc);
                    if (this.uDc.diO().getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.q(s.a.GIFT_SWITCCH.hlf, String.valueOf(s.t.OPEN_SEND_GIFT_BY_MORE.action));
                    }
                }
                com.tencent.mm.ui.widget.a.e eVar3 = this.uDc.hOv;
                if (eVar3 != null) {
                    eVar3.bMo();
                    AppMethodBeat.o(247904);
                    return;
                }
                AppMethodBeat.o(247904);
            } else {
                int unused = this.uDc.uCB;
                AppMethodBeat.o(247904);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(247914);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(5874, this);
        AppMethodBeat.o(247914);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(261048);
        super.onResume();
        hTS();
        AppMethodBeat.o(261048);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ FinderLivePostUIC uDc;

        public i(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        public final void run() {
            AppMethodBeat.i(247899);
            Rect rect = new Rect();
            this.uDc.diP().getHitRect(rect);
            rect.inset(rect.width() * -2, -rect.width());
            ViewParent parent = this.uDc.diP().getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(247899);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uDc.diP()));
            AppMethodBeat.o(247899);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ FinderLivePostUIC uDc;

        public l(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247902);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initPostLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderLivePostUIC.d(this.uDc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initPostLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247902);
        }
    }

    public final void hTS() {
        AppMethodBeat.i(261049);
        g gVar = this.liveData;
        if (gVar == null || !gVar.uit) {
            com.tencent.mm.kernel.g.azz().a(3761, this);
            com.tencent.mm.kernel.g.azz().b(new cd(10));
        }
        AppMethodBeat.o(261049);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class s implements f.c {
        public static final s uDk = new s();

        static {
            AppMethodBeat.i(247910);
            AppMethodBeat.o(247910);
        }

        s() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(247916);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(5874, this);
        com.tencent.mm.kernel.g.azz().b(3761, this);
        AppMethodBeat.o(247916);
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0495  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        // Method dump skipped, instructions count: 1432
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.onActivityResult(int, int, android.content.Intent):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class o implements u.b {
        public static final o uDj = new o();

        static {
            AppMethodBeat.i(247906);
            AppMethodBeat.o(247906);
        }

        o() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            WeImageView weImageView;
            AppMethodBeat.i(247905);
            if (view != null) {
                view.findViewById(R.id.ird);
            }
            if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                AppMethodBeat.o(247905);
                return;
            }
            weImageView.setImageResource(R.raw.icons_filled_done);
            AppMethodBeat.o(247905);
        }
    }

    public final void hTT() {
        int i2;
        AppMethodBeat.i(261050);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean z = com.tencent.mm.plugin.finder.storage.c.dwl().value().intValue() == 0;
        Log.i(TAG, "prepareMenuItems,showVisibilityEntrance:".concat(String.valueOf(z)));
        if (z) {
            View view = this.UPQ;
            if (view == null) {
                kotlin.g.b.p.btv("visibilityGroup");
            }
            view.setVisibility(0);
            View view2 = this.UPQ;
            if (view2 == null) {
                kotlin.g.b.p.btv("visibilityGroup");
            }
            view2.setOnClickListener(new u(this));
        } else {
            View view3 = this.UPQ;
            if (view3 == null) {
                kotlin.g.b.p.btv("visibilityGroup");
            }
            view3.setVisibility(8);
        }
        g gVar = this.liveData;
        if (gVar != null) {
            i2 = gVar.uFa;
        } else {
            i2 = 0;
        }
        if (com.tencent.mm.ac.d.cW(i2, 7)) {
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cxg);
            kotlin.g.b.p.g(string, "MMApplicationContext.get…e_more_action_visibility)");
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            String string2 = context2.getResources().getString(R.string.d04);
            kotlin.g.b.p.g(string2, "MMApplicationContext.get…ve_visibility_white_list)");
            TextView textView = this.uCN;
            if (textView == null) {
                kotlin.g.b.p.btv("visibilityTv");
            }
            Context context3 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
            textView.setText(context3.getResources().getString(R.string.czz, string, string2));
            AppMethodBeat.o(261050);
            return;
        }
        Context context4 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context4, "MMApplicationContext.getContext()");
        String string3 = context4.getResources().getString(R.string.cxg);
        kotlin.g.b.p.g(string3, "MMApplicationContext.get…e_more_action_visibility)");
        Context context5 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context5, "MMApplicationContext.getContext()");
        String string4 = context5.getResources().getString(R.string.d02);
        kotlin.g.b.p.g(string4, "MMApplicationContext.get…r_live_visibility_public)");
        TextView textView2 = this.uCN;
        if (textView2 == null) {
            kotlin.g.b.p.btv("visibilityTv");
        }
        Context context6 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context6, "MMApplicationContext.getContext()");
        textView2.setText(context6.getResources().getString(R.string.czz, string3, string4));
        AppMethodBeat.o(261050);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class u implements View.OnClickListener {
        final /* synthetic */ FinderLivePostUIC uDc;

        u(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        public final void onClick(View view) {
            List<byte[]> list;
            List<byte[]> list2;
            Integer num;
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Integer num2;
            Integer num3;
            AppMethodBeat.i(261047);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$refreshGroupVisibility$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c cVar = FinderLivePostUIC.uDb;
            Log.i(FinderLivePostUIC.TAG, "visibilityGroup click");
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Activity context = this.uDc.getContext();
            Intent intent = new Intent();
            OccupyFinderUI14.a aVar2 = OccupyFinderUI14.ueB;
            String deH = OccupyFinderUI14.deH();
            g gVar = this.uDc.liveData;
            if (gVar != null) {
                list = gVar.uEY;
            } else {
                list = null;
            }
            if (!(list instanceof Serializable)) {
                list = null;
            }
            intent.putExtra(deH, (Serializable) list);
            OccupyFinderUI14.a aVar3 = OccupyFinderUI14.ueB;
            String deI = OccupyFinderUI14.deI();
            g gVar2 = this.uDc.liveData;
            if (gVar2 != null) {
                list2 = gVar2.uEZ;
            } else {
                list2 = null;
            }
            if (!(list2 instanceof Serializable)) {
                list2 = null;
            }
            intent.putExtra(deI, (Serializable) list2);
            OccupyFinderUI14.a aVar4 = OccupyFinderUI14.ueB;
            String hSR = OccupyFinderUI14.hSR();
            g gVar3 = this.uDc.liveData;
            if (gVar3 != null) {
                num = Integer.valueOf(gVar3.UKn);
            } else {
                num = null;
            }
            intent.putExtra(hSR, num);
            OccupyFinderUI14.a aVar5 = OccupyFinderUI14.ueB;
            String hSP = OccupyFinderUI14.hSP();
            g gVar4 = this.uDc.liveData;
            if (gVar4 != null) {
                arrayList = gVar4.UQf;
            } else {
                arrayList = null;
            }
            intent.putStringArrayListExtra(hSP, arrayList);
            OccupyFinderUI14.a aVar6 = OccupyFinderUI14.ueB;
            String hSQ = OccupyFinderUI14.hSQ();
            g gVar5 = this.uDc.liveData;
            if (gVar5 != null) {
                arrayList2 = gVar5.UQg;
            } else {
                arrayList2 = null;
            }
            intent.putStringArrayListExtra(hSQ, arrayList2);
            OccupyFinderUI14.a aVar7 = OccupyFinderUI14.ueB;
            String deG = OccupyFinderUI14.deG();
            g gVar6 = this.uDc.liveData;
            if (gVar6 != null) {
                num2 = Integer.valueOf(gVar6.uFa);
            } else {
                num2 = null;
            }
            intent.putExtra(deG, num2);
            OccupyFinderUI14.a aVar8 = OccupyFinderUI14.ueB;
            String hSO = OccupyFinderUI14.hSO();
            g gVar7 = this.uDc.liveData;
            if (gVar7 != null) {
                num3 = Integer.valueOf(gVar7.UKm);
            } else {
                num3 = null;
            }
            intent.putExtra(hSO, num3);
            com.tencent.mm.plugin.finder.utils.a.e(context, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$refreshGroupVisibility$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261047);
        }
    }

    public final void bE(ArrayList<String> arrayList) {
        g gVar;
        m mVar;
        LinkedList<String> linkedList;
        m mVar2;
        LinkedList<String> linkedList2;
        AppMethodBeat.i(261051);
        g gVar2 = this.liveData;
        if (!(gVar2 == null || (mVar2 = gVar2.UQm) == null || (linkedList2 = mVar2.Mpi) == null)) {
            linkedList2.clear();
        }
        if (!(arrayList == null || (gVar = this.liveData) == null || (mVar = gVar.UQm) == null || (linkedList = mVar.Mpi) == null)) {
            linkedList.addAll(arrayList);
        }
        com.tencent.mm.plugin.finder.live.widget.u uVar = this.UPR;
        if (uVar == null) {
            kotlin.g.b.p.btv("luckyMoneyWidget");
        }
        uVar.hUm();
        AppMethodBeat.o(261051);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class f implements o.f {
        final /* synthetic */ FinderLivePostUIC uDc;

        f(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(247896);
            com.tencent.mm.ui.widget.a.e eVar = this.uDc.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            FinderLivePostUIC finderLivePostUIC = this.uDc;
            kotlin.g.b.p.g(mVar, "menu");
            FinderLivePostUIC.a(finderLivePostUIC, mVar);
            AppMethodBeat.o(247896);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class g implements e.b {
        final /* synthetic */ FinderLivePostUIC uDc;

        g(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(247897);
            b.C0376b.a(this.uDc.diO(), b.c.hNo);
            this.uDc.hOv = null;
            AppMethodBeat.o(247897);
        }
    }

    public final void diR() {
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) & -65);
        }
    }

    private final boolean diS() {
        AppMethodBeat.i(247918);
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        boolean cW = com.tencent.mm.ac.d.cW((int) (gVar != null ? gVar.field_liveAnchorStatusFlag : 0), 64);
        AppMethodBeat.o(247918);
        return cW;
    }

    private final boolean diT() {
        AppMethodBeat.i(247919);
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        if (!com.tencent.mm.ac.d.cW((int) (gVar != null ? gVar.field_liveAnchorStatusFlag : 0), 8)) {
            AppMethodBeat.o(247919);
            return true;
        }
        AppMethodBeat.o(247919);
        return false;
    }

    public final void diU() {
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) & -129);
        }
    }

    private final boolean diV() {
        AppMethodBeat.i(247920);
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        boolean cW = com.tencent.mm.ac.d.cW((int) (gVar != null ? gVar.field_liveAnchorStatusFlag : 0), 128);
        AppMethodBeat.o(247920);
        return cW;
    }

    public final void diW() {
        AppMethodBeat.i(247921);
        View view = this.uCQ;
        if (view == null) {
            kotlin.g.b.p.btv("postBtnGroup");
        }
        view.setEnabled(true);
        AppMethodBeat.o(247921);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$widgetListener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder_release"})
    public static final class t implements e {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        t(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        @Override // com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.e
        public final void onChange() {
            AppMethodBeat.i(247911);
            this.uDc.diW();
            AppMethodBeat.o(247911);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$startPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class r implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        r(FinderLivePostUIC finderLivePostUIC) {
            this.uDc = finderLivePostUIC;
        }

        @Override // com.tencent.mm.loader.g.f
        public final void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.j jVar) {
            String str;
            AppMethodBeat.i(247909);
            kotlin.g.b.p.h(cVar, "task");
            kotlin.g.b.p.h(jVar, "status");
            if (jVar != com.tencent.mm.loader.g.j.OK || Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m) cVar).resultUrl)) {
                if (this.uDc.diO().getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_NETWORK_ERROR.type));
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.setErrorCode(com.tencent.mm.loader.g.j.Fail.ordinal());
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.b(s.o.LIVE_EXIT_ERROR);
                }
                ae aeVar = ae.vZW;
                String dEa = ae.dEa();
                ae aeVar2 = ae.vZW;
                ae.a(dEa, ae.dDZ(), 0, jVar.toString(), this.uDc.liveData);
                AppMethodBeat.o(247909);
                return;
            }
            FinderLivePostUIC finderLivePostUIC = this.uDc;
            String str2 = ((com.tencent.mm.plugin.finder.upload.m) cVar).resultUrl;
            String str3 = ((com.tencent.mm.plugin.finder.upload.m) cVar).vTf;
            com.tencent.mm.plugin.finder.live.widget.h hVar = this.uDc.uCG;
            if (hVar == null) {
                kotlin.g.b.p.btv("coverWidget");
            }
            String str4 = hVar.uGF;
            com.tencent.mm.i.d dVar = ((com.tencent.mm.plugin.finder.upload.m) cVar).hmq;
            if (dVar != null) {
                str = dVar.field_filemd5;
            } else {
                str = null;
            }
            finderLivePostUIC.n(str2, str3, str4, str);
            AppMethodBeat.o(247909);
        }
    }

    private final void diX() {
        AppMethodBeat.i(247922);
        Log.i(TAG, "checkState state:" + this.state);
        if (this.state == this.STATE_DEFAULT) {
            View view = this.uCR;
            if (view == null) {
                kotlin.g.b.p.btv("contentRoot");
            }
            view.setVisibility(0);
            RelativeLayout relativeLayout = this.uCK;
            if (relativeLayout == null) {
                kotlin.g.b.p.btv("topContainer");
            }
            relativeLayout.setVisibility(0);
            AppMethodBeat.o(247922);
            return;
        }
        View view2 = this.uCR;
        if (view2 == null) {
            kotlin.g.b.p.btv("contentRoot");
        }
        view2.setVisibility(4);
        RelativeLayout relativeLayout2 = this.uCK;
        if (relativeLayout2 == null) {
            kotlin.g.b.p.btv("topContainer");
        }
        relativeLayout2.setVisibility(4);
        AppMethodBeat.o(247922);
    }

    public final void diY() {
        Boolean bool = null;
        AppMethodBeat.i(247923);
        String str = TAG;
        StringBuilder sb = new StringBuilder("loadOptions bindShop:");
        g gVar = this.liveData;
        StringBuilder append = sb.append(gVar != null ? Boolean.valueOf(gVar.uit) : null).append(", exptFilterEnable:");
        g gVar2 = this.liveData;
        StringBuilder append2 = append.append(gVar2 != null ? Boolean.valueOf(gVar2.uEW) : null).append(", exptBeautyEnable:");
        g gVar3 = this.liveData;
        if (gVar3 != null) {
            bool = Boolean.valueOf(gVar3.uEV);
        }
        Log.i(str, append2.append(bool).toString());
        for (int i2 = 0; i2 <= 5; i2++) {
            if (i2 == 4) {
                this.uCW.add(new d(i2));
            } else if (i2 == 3) {
                g gVar4 = this.liveData;
                if (gVar4 != null && gVar4.uEW) {
                    this.uCW.add(new d(i2));
                }
            } else if (i2 == 2) {
                g gVar5 = this.liveData;
                if (gVar5 != null && gVar5.uEV) {
                    this.uCW.add(new d(i2));
                }
            } else {
                this.uCW.add(new d(i2));
            }
        }
        AppMethodBeat.o(247923);
    }

    public final void n(String str, String str2, String str3, String str4) {
        Point djK;
        String str5;
        String str6;
        Long l2;
        long j2;
        long j3 = 0;
        Long l3 = null;
        AppMethodBeat.i(247924);
        kotlin.g.b.p.h(str, "coverUrl");
        kotlin.g.b.p.h(str2, "thumbUrl");
        kotlin.g.b.p.h(str3, "path");
        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
        com.tencent.mm.plugin.finder.live.widget.i iVar = this.uCJ;
        if (iVar == null) {
            kotlin.g.b.p.btv("descWidget");
        }
        finderObjectDesc.description = iVar.uGP.getText().toString();
        finderObjectDesc.mediaType = 9;
        com.tencent.mm.plugin.finder.live.widget.k kVar = this.uCF;
        if (kVar == null) {
            kotlin.g.b.p.btv("locationWidget");
        }
        finderObjectDesc.location = kVar.getLocation();
        finderObjectDesc.extReading = new aqp();
        FinderMedia finderMedia = new FinderMedia();
        finderMedia.url = str;
        finderMedia.mediaType = 9;
        finderMedia.thumbUrl = str2;
        finderMedia.videoDuration = 0;
        if (!Util.isNullOrNil(str3)) {
            y yVar = y.vXH;
            djK = y.awm(str3);
        } else {
            if (this.uCG == null) {
                kotlin.g.b.p.btv("coverWidget");
            }
            djK = com.tencent.mm.plugin.finder.live.widget.h.djK();
        }
        finderMedia.width = (float) djK.x;
        finderMedia.height = (float) djK.y;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        finderMedia.md5sum = str5;
        finderMedia.coverUrl = "";
        finderObjectDesc.media.add(finderMedia);
        String str7 = TAG;
        StringBuilder sb = new StringBuilder("desc coverUrl:");
        LinkedList<FinderMedia> linkedList = finderObjectDesc.media;
        kotlin.g.b.p.g(linkedList, "objectDesc.media");
        FinderMedia first = linkedList.getFirst();
        if (first != null) {
            str6 = first.coverUrl;
        } else {
            str6 = null;
        }
        StringBuilder append = sb.append(str6).append(",thumbUrl:");
        LinkedList<FinderMedia> linkedList2 = finderObjectDesc.media;
        kotlin.g.b.p.g(linkedList2, "objectDesc.media");
        FinderMedia first2 = linkedList2.getFirst();
        StringBuilder append2 = append.append(first2 != null ? first2.thumbUrl : null).append(",md5:").append(str4).append(", selfContact.anchorFlag:");
        com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
        if (gVar != null) {
            l2 = Long.valueOf(gVar.field_liveAnchorStatusFlag);
        } else {
            l2 = null;
        }
        StringBuilder append3 = append2.append(l2).append(", selfContact.switchFlag:");
        com.tencent.mm.plugin.finder.api.g gVar2 = this.uCY;
        if (gVar2 != null) {
            l3 = Long.valueOf(gVar2.field_liveSwitchFlag);
        }
        StringBuilder append4 = append3.append(l3).append(", linkMic:").append(diS()).append(", gift:").append(diV()).append(", comment:").append(diT()).append(",location:");
        Object obj = finderObjectDesc.location;
        if (obj == null) {
            obj = "";
        }
        Log.i(str7, append4.append(com.tencent.mm.ac.g.bN(obj)).toString());
        com.tencent.mm.plugin.finder.api.g gVar3 = this.uCY;
        if (gVar3 != null) {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            c.a.c(gVar3);
            if (this.liveData != null) {
                com.tencent.mm.plugin.finder.api.g gVar4 = this.uCY;
                if (gVar4 != null) {
                    j2 = gVar4.field_liveAnchorStatusFlag;
                } else {
                    j2 = 0;
                }
                g.EP(j2);
            }
            if (this.liveData != null) {
                com.tencent.mm.plugin.finder.api.g gVar5 = this.uCY;
                if (gVar5 != null) {
                    j3 = gVar5.field_liveSwitchFlag;
                }
                g.EQ(j3);
            }
        }
        com.tencent.mm.plugin.finder.live.widget.j jVar = this.uCH;
        if (jVar == null) {
            kotlin.g.b.p.btv("licenseWidget");
        }
        if (jVar != null) {
            jVar.djL();
        }
        kotlin.g.a.b<? super FinderObjectDesc, x> bVar = this.uCZ;
        if (bVar != null) {
            bVar.invoke(finderObjectDesc);
            AppMethodBeat.o(247924);
            return;
        }
        AppMethodBeat.o(247924);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(247925);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cx1) {
            com.tencent.mm.live.c.b bVar2 = this.hOp;
            if (bVar2 == null) {
                kotlin.g.b.p.btv("statusMonitor");
            }
            if (bVar2 != null) {
                b.C0376b.a(bVar2, b.c.hLD);
            }
            com.tencent.mm.live.c.b bVar3 = this.hOp;
            if (bVar3 == null) {
                kotlin.g.b.p.btv("statusMonitor");
            }
            if (bVar3.getLiveRole() == 1) {
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_OUT.hlf, "");
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(com.tencent.mm.plugin.finder.report.live.k.dpj());
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cwy) {
            if (this.state != this.STATE_DEFAULT) {
                onBackPressed();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cx6) {
            if (this.hOv == null) {
                this.hOv = new com.tencent.mm.ui.widget.a.e((Context) getContext(), 0, true);
                com.tencent.mm.ui.widget.a.e eVar = this.hOv;
                if (eVar != null) {
                    eVar.hbs();
                }
            }
            com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
            if (eVar2 != null) {
                eVar2.hbr();
            }
            com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
            if (eVar3 != null) {
                eVar3.Dp(false);
            }
            com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
            if (eVar4 != null) {
                eVar4.a(new f(this));
            }
            com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
            if (eVar5 != null) {
                eVar5.a(this.uhx);
            }
            com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
            if (eVar6 != null) {
                eVar6.b(new g(this));
            }
            com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
            if (eVar7 != null) {
                eVar7.dGm();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247925);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(261052);
        Integer valueOf = qVar != null ? Integer.valueOf(qVar.getType()) : null;
        if (valueOf == null) {
            AppMethodBeat.o(261052);
            return;
        }
        if (valueOf.intValue() == 3761 && i2 == 0 && i3 == 0) {
            com.tencent.mm.kernel.g.azz().b(3761, this);
            if (qVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                AppMethodBeat.o(261052);
                throw tVar;
            }
            bed cZc = ((cd) qVar).cZc();
            if (cZc != null) {
                this.vOq = cZc.LNT;
                g gVar = this.liveData;
                if (gVar != null) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    gVar.FA(com.tencent.mm.plugin.finder.utils.m.dBN());
                }
                g gVar2 = this.liveData;
                if (gVar2 != null) {
                    if (gVar2.uit) {
                        com.tencent.mm.live.c.b bVar = this.hOp;
                        if (bVar == null) {
                            kotlin.g.b.p.btv("statusMonitor");
                        }
                        b.C0376b.a(bVar, b.c.vBP);
                    }
                    AppMethodBeat.o(261052);
                    return;
                }
                AppMethodBeat.o(261052);
                return;
            }
        }
        AppMethodBeat.o(261052);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        boolean z;
        AppMethodBeat.i(247926);
        com.tencent.mm.plugin.finder.live.widget.g gVar = this.uCI;
        if (gVar == null) {
            kotlin.g.b.p.btv("licensePanelWidget");
        }
        if (gVar.uGC.getVisibility() == 0) {
            gVar.hRy.hide();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(247926);
            return true;
        }
        int i2 = this.state;
        if (i2 == this.uCy) {
            this.state = this.STATE_DEFAULT;
            com.tencent.mm.plugin.finder.live.widget.e eVar = this.umJ;
            if (eVar == null) {
                kotlin.g.b.p.btv("filterWidget");
            }
            com.tencent.mm.ac.d.h(new e.c(eVar, new p(this)));
            AppMethodBeat.o(247926);
            return true;
        } else if (i2 == this.uCz) {
            this.state = this.STATE_DEFAULT;
            com.tencent.mm.plugin.finder.live.widget.d dVar = this.umK;
            if (dVar == null) {
                kotlin.g.b.p.btv("beautyWidget");
            }
            com.tencent.mm.ac.d.h(new d.C1206d(dVar, new q(this)));
            AppMethodBeat.o(247926);
            return true;
        } else {
            boolean onBackPressed = super.onBackPressed();
            AppMethodBeat.o(247926);
            return onBackPressed;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "", "key", "", "(I)V", "getKey", "()I", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class d {
        final int key;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof d) && this.key == ((d) obj).key);
        }

        public final int hashCode() {
            return this.key;
        }

        public final String toString() {
            AppMethodBeat.i(247895);
            String str = "OptionInfo(key=" + this.key + ")";
            AppMethodBeat.o(247895);
            return str;
        }

        public d(int i2) {
            this.key = i2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
    public final class a extends RecyclerView.a<b> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(247891);
            kotlin.g.b.p.h(viewGroup, "parent");
            FinderLivePostUIC finderLivePostUIC = FinderLivePostUIC.this;
            View inflate = View.inflate(viewGroup.getContext(), R.layout.ad8, null);
            kotlin.g.b.p.g(inflate, "View.inflate(parent.cont…re_camera_opt_item, null)");
            b bVar = new b(finderLivePostUIC, inflate);
            AppMethodBeat.o(247891);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            com.tencent.mm.live.core.core.b.f fVar;
            com.tencent.mm.live.core.core.b.d dVar;
            com.tencent.mm.live.core.core.b.f fVar2;
            com.tencent.mm.live.core.core.b.d dVar2;
            AppMethodBeat.i(247893);
            b bVar2 = bVar;
            kotlin.g.b.p.h(bVar2, "holder");
            Object obj = FinderLivePostUIC.this.uCW.get(i2);
            kotlin.g.b.p.g(obj, "optList[position]");
            WeImageView weImageView = bVar2.uDh;
            kotlin.g.b.p.g(weImageView, "holder.optIcon");
            weImageView.setRotationY(0.0f);
            switch (((d) obj).key) {
                case 0:
                    WeImageView weImageView2 = bVar2.uDh;
                    WeImageView weImageView3 = bVar2.uDh;
                    kotlin.g.b.p.g(weImageView3, "holder.optIcon");
                    Context context = weImageView3.getContext();
                    kotlin.g.b.p.g(context, "holder.optIcon.context");
                    weImageView2.setImageDrawable(context.getResources().getDrawable(R.raw.icons_filled_camera_switch));
                    TextView textView = bVar2.uDi;
                    kotlin.g.b.p.g(textView, "holder.optTv");
                    TextView textView2 = bVar2.uDi;
                    kotlin.g.b.p.g(textView2, "holder.optTv");
                    Context context2 = textView2.getContext();
                    kotlin.g.b.p.g(context2, "holder.optTv.context");
                    textView.setText(context2.getResources().getString(R.string.cwm));
                    break;
                case 1:
                    g gVar = FinderLivePostUIC.this.liveData;
                    if (!(gVar == null || (fVar2 = gVar.hIy) == null || (dVar2 = fVar2.hzt) == null || dVar2.hzk)) {
                        WeImageView weImageView4 = bVar2.uDh;
                        kotlin.g.b.p.g(weImageView4, "holder.optIcon");
                        weImageView4.setRotationY(180.0f);
                    }
                    WeImageView weImageView5 = bVar2.uDh;
                    WeImageView weImageView6 = bVar2.uDh;
                    kotlin.g.b.p.g(weImageView6, "holder.optIcon");
                    Context context3 = weImageView6.getContext();
                    kotlin.g.b.p.g(context3, "holder.optIcon.context");
                    weImageView5.setImageDrawable(context3.getResources().getDrawable(R.raw.finder_live_mirror_icon));
                    TextView textView3 = bVar2.uDi;
                    kotlin.g.b.p.g(textView3, "holder.optTv");
                    TextView textView4 = bVar2.uDi;
                    kotlin.g.b.p.g(textView4, "holder.optTv");
                    Context context4 = textView4.getContext();
                    kotlin.g.b.p.g(context4, "holder.optTv.context");
                    textView3.setText(context4.getResources().getString(R.string.cwk));
                    g gVar2 = FinderLivePostUIC.this.liveData;
                    if (gVar2 != null && (fVar = gVar2.hIy) != null && (dVar = fVar.hzt) != null && dVar.hzh) {
                        WeImageView weImageView7 = bVar2.uDh;
                        WeImageView weImageView8 = bVar2.uDh;
                        kotlin.g.b.p.g(weImageView8, "holder.optIcon");
                        Context context5 = weImageView8.getContext();
                        kotlin.g.b.p.g(context5, "holder.optIcon.context");
                        weImageView7.setIconColor(context5.getResources().getColor(R.color.ag2));
                        TextView textView5 = bVar2.uDi;
                        TextView textView6 = bVar2.uDi;
                        kotlin.g.b.p.g(textView6, "holder.optTv");
                        Context context6 = textView6.getContext();
                        kotlin.g.b.p.g(context6, "holder.optTv.context");
                        textView5.setTextColor(context6.getResources().getColor(R.color.ag2));
                        break;
                    } else {
                        WeImageView weImageView9 = bVar2.uDh;
                        WeImageView weImageView10 = bVar2.uDh;
                        kotlin.g.b.p.g(weImageView10, "holder.optIcon");
                        Context context7 = weImageView10.getContext();
                        kotlin.g.b.p.g(context7, "holder.optIcon.context");
                        weImageView9.setIconColor(context7.getResources().getColor(R.color.BW_100_Alpha_0_3));
                        TextView textView7 = bVar2.uDi;
                        TextView textView8 = bVar2.uDi;
                        kotlin.g.b.p.g(textView8, "holder.optTv");
                        Context context8 = textView8.getContext();
                        kotlin.g.b.p.g(context8, "holder.optTv.context");
                        textView7.setTextColor(context8.getResources().getColor(R.color.BW_100_Alpha_0_3));
                        break;
                    }
                    break;
                case 2:
                    WeImageView weImageView11 = bVar2.uDh;
                    WeImageView weImageView12 = bVar2.uDh;
                    kotlin.g.b.p.g(weImageView12, "holder.optIcon");
                    Context context9 = weImageView12.getContext();
                    kotlin.g.b.p.g(context9, "holder.optIcon.context");
                    weImageView11.setImageDrawable(context9.getResources().getDrawable(R.raw.finder_live_beauty_icon));
                    TextView textView9 = bVar2.uDi;
                    kotlin.g.b.p.g(textView9, "holder.optTv");
                    TextView textView10 = bVar2.uDi;
                    kotlin.g.b.p.g(textView10, "holder.optTv");
                    Context context10 = textView10.getContext();
                    kotlin.g.b.p.g(context10, "holder.optTv.context");
                    textView9.setText(context10.getResources().getString(R.string.cwi));
                    break;
                case 3:
                    WeImageView weImageView13 = bVar2.uDh;
                    WeImageView weImageView14 = bVar2.uDh;
                    kotlin.g.b.p.g(weImageView14, "holder.optIcon");
                    Context context11 = weImageView14.getContext();
                    kotlin.g.b.p.g(context11, "holder.optIcon.context");
                    weImageView13.setImageDrawable(context11.getResources().getDrawable(R.raw.finder_live_filter_icon));
                    TextView textView11 = bVar2.uDi;
                    kotlin.g.b.p.g(textView11, "holder.optTv");
                    TextView textView12 = bVar2.uDi;
                    kotlin.g.b.p.g(textView12, "holder.optTv");
                    Context context12 = textView12.getContext();
                    kotlin.g.b.p.g(context12, "holder.optTv.context");
                    textView11.setText(context12.getResources().getString(R.string.cwj));
                    break;
                case 4:
                    WeImageView weImageView15 = bVar2.uDh;
                    WeImageView weImageView16 = bVar2.uDh;
                    kotlin.g.b.p.g(weImageView16, "holder.optIcon");
                    Context context13 = weImageView16.getContext();
                    kotlin.g.b.p.g(context13, "holder.optIcon.context");
                    weImageView15.setImageDrawable(context13.getResources().getDrawable(R.raw.icons_filled_shop));
                    TextView textView13 = bVar2.uDi;
                    kotlin.g.b.p.g(textView13, "holder.optTv");
                    TextView textView14 = bVar2.uDi;
                    kotlin.g.b.p.g(textView14, "holder.optTv");
                    Context context14 = textView14.getContext();
                    kotlin.g.b.p.g(context14, "holder.optTv.context");
                    textView13.setText(context14.getResources().getString(R.string.cwl));
                    break;
            }
            bVar2.aus.setOnClickListener(new View$OnClickListenerC1202a(this, i2, bVar2));
            AppMethodBeat.o(247893);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(247892);
            int size = FinderLivePostUIC.this.uCW.size();
            AppMethodBeat.o(247892);
            return size;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1202a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ a uDd;
            final /* synthetic */ b uDe;

            View$OnClickListenerC1202a(a aVar, int i2, b bVar) {
                this.uDd = aVar;
                this.gUj = i2;
                this.uDe = bVar;
            }

            public final void onClick(View view) {
                com.tencent.mm.live.core.core.b.f fVar;
                com.tencent.mm.live.core.core.b.d dVar;
                com.tencent.mm.live.core.core.b.f fVar2;
                com.tencent.mm.live.core.core.b.d dVar2;
                AppMethodBeat.i(247890);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar3 = (d) kotlin.a.j.L(FinderLivePostUIC.this.uCW, this.gUj);
                if (dVar3 != null) {
                    if (dVar3.key == 1) {
                        g gVar = FinderLivePostUIC.this.liveData;
                        if (gVar == null || (fVar = gVar.hIy) == null || (dVar = fVar.hzt) == null || !dVar.hzh) {
                            c cVar = FinderLivePostUIC.uDb;
                            Log.i(FinderLivePostUIC.TAG, "clickMirror while using front camera, skip!");
                            View view2 = this.uDe.aus;
                            kotlin.g.b.p.g(view2, "holder.itemView");
                            Context context = view2.getContext();
                            View view3 = this.uDe.aus;
                            kotlin.g.b.p.g(view3, "holder.itemView");
                            Context context2 = view3.getContext();
                            kotlin.g.b.p.g(context2, "holder.itemView.context");
                            com.tencent.mm.ui.base.u.makeText(context, context2.getResources().getString(R.string.cwq), 0).show();
                        } else {
                            g gVar2 = FinderLivePostUIC.this.liveData;
                            this.uDe.uDh.animate().rotationY((gVar2 == null || (fVar2 = gVar2.hIy) == null || (dVar2 = fVar2.hzt) == null || !dVar2.hzk) ? 0.0f : 180.0f).setListener(new C1203a(this, dVar3)).setDuration(200).start();
                        }
                    }
                    kotlin.g.a.b bVar2 = FinderLivePostUIC.this.uCX;
                    if (bVar2 != null) {
                        bVar2.invoke(dVar3);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247890);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC$a$a$a  reason: collision with other inner class name */
            public static final class C1203a extends AnimatorListenerAdapter {
                final /* synthetic */ View$OnClickListenerC1202a uDf;
                final /* synthetic */ d uDg;

                C1203a(View$OnClickListenerC1202a aVar, d dVar) {
                    this.uDf = aVar;
                    this.uDg = dVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(247889);
                    this.uDf.uDe.aus.invalidate();
                    AppMethodBeat.o(247889);
                }
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;Landroid/view/View;)V", "optIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getOptIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "optTv", "Landroid/widget/TextView;", "getOptTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        final /* synthetic */ FinderLivePostUIC uDc;
        final WeImageView uDh;
        final TextView uDi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderLivePostUIC finderLivePostUIC, View view) {
            super(view);
            kotlin.g.b.p.h(view, "itemView");
            this.uDc = finderLivePostUIC;
            AppMethodBeat.i(247894);
            this.uDh = (WeImageView) view.findViewById(R.id.f3096com);
            this.uDi = (TextView) view.findViewById(R.id.coo);
            AppMethodBeat.o(247894);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(FinderLivePostUIC finderLivePostUIC) {
            super(0);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247898);
            com.tencent.mm.plugin.finder.live.widget.j jVar = this.uDc.uCH;
            if (jVar == null) {
                kotlin.g.b.p.btv("licenseWidget");
            }
            jVar.jxm.performClick();
            FinderLivePostUIC.d(this.uDc);
            x xVar = x.SXb;
            AppMethodBeat.o(247898);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(FinderLivePostUIC finderLivePostUIC) {
            super(0);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247900);
            this.uDc.onBackPressed();
            x xVar = x.SXb;
            AppMethodBeat.o(247900);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(FinderLivePostUIC finderLivePostUIC) {
            super(0);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247901);
            this.uDc.onBackPressed();
            x xVar = x.SXb;
            AppMethodBeat.o(247901);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderLivePostUIC finderLivePostUIC) {
            super(0);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247907);
            FinderLivePostUIC.l(this.uDc);
            x xVar = x.SXb;
            AppMethodBeat.o(247907);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLivePostUIC uDc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderLivePostUIC finderLivePostUIC) {
            super(0);
            this.uDc = finderLivePostUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247908);
            FinderLivePostUIC.l(this.uDc);
            x xVar = x.SXb;
            AppMethodBeat.o(247908);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void diQ() {
        /*
        // Method dump skipped, instructions count: 495
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.diQ():void");
    }

    public static final /* synthetic */ void e(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.live.core.core.b.f fVar;
        com.tencent.mm.live.core.core.b.d dVar;
        boolean z;
        boolean z2;
        com.tencent.mm.live.core.core.b.f fVar2;
        com.tencent.mm.live.core.core.b.d dVar2;
        int i2 = 1;
        AppMethodBeat.i(247930);
        g gVar = finderLivePostUIC.liveData;
        if (!(gVar == null || (fVar = gVar.hIy) == null || (dVar = fVar.hzt) == null)) {
            g gVar2 = finderLivePostUIC.liveData;
            if (gVar2 == null || (fVar2 = gVar2.hIy) == null || (dVar2 = fVar2.hzt) == null) {
                z = true;
            } else {
                z = dVar2.hzh;
            }
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            dVar.hzh = z2;
        }
        com.tencent.mm.live.c.b bVar = finderLivePostUIC.hOp;
        if (bVar == null) {
            kotlin.g.b.p.btv("statusMonitor");
        }
        if (bVar != null) {
            bVar.statusChange(b.c.hLE, new Bundle());
        }
        RecyclerView recyclerView = finderLivePostUIC.uCP;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("cameraOptPanel");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.ci(1);
        }
        com.tencent.mm.live.c.b bVar2 = finderLivePostUIC.hOp;
        if (bVar2 == null) {
            kotlin.g.b.p.btv("statusMonitor");
        }
        if (bVar2.getLiveRole() == 1) {
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
            if (aDC.aDG().hBp == 0) {
                i2 = 2;
            }
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_EXCHANGE_CAMERA.hlf, String.valueOf(i2));
        }
        AppMethodBeat.o(247930);
    }

    public static final /* synthetic */ void f(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.live.core.core.b.f fVar;
        com.tencent.mm.live.core.core.b.d dVar;
        boolean z;
        com.tencent.mm.live.core.core.b.f fVar2;
        com.tencent.mm.live.core.core.b.d dVar2;
        boolean z2 = true;
        AppMethodBeat.i(247931);
        Log.i(TAG, "clickMirror");
        g gVar = finderLivePostUIC.liveData;
        if (!(gVar == null || (fVar = gVar.hIy) == null || (dVar = fVar.hzt) == null)) {
            g gVar2 = finderLivePostUIC.liveData;
            if (gVar2 == null || (fVar2 = gVar2.hIy) == null || (dVar2 = fVar2.hzt) == null) {
                z = true;
            } else {
                z = dVar2.hzk;
            }
            if (z) {
                z2 = false;
            }
            dVar.hzk = z2;
        }
        com.tencent.mm.live.c.b bVar = finderLivePostUIC.hOp;
        if (bVar == null) {
            kotlin.g.b.p.btv("statusMonitor");
        }
        bVar.statusChange(b.c.hMF, new Bundle());
        AppMethodBeat.o(247931);
    }

    public static final /* synthetic */ void g(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247932);
        Log.i(TAG, "clickBeauty");
        finderLivePostUIC.state = finderLivePostUIC.uCz;
        finderLivePostUIC.diX();
        com.tencent.mm.plugin.finder.live.widget.d dVar = finderLivePostUIC.umK;
        if (dVar == null) {
            kotlin.g.b.p.btv("beautyWidget");
        }
        dVar.djz();
        AppMethodBeat.o(247932);
    }

    public static final /* synthetic */ void h(FinderLivePostUIC finderLivePostUIC) {
        AppMethodBeat.i(247933);
        Log.i(TAG, "clickFilter");
        finderLivePostUIC.state = finderLivePostUIC.uCy;
        finderLivePostUIC.diX();
        com.tencent.mm.plugin.finder.live.widget.e eVar = finderLivePostUIC.umJ;
        if (eVar == null) {
            kotlin.g.b.p.btv("filterWidget");
        }
        eVar.djB();
        AppMethodBeat.o(247933);
    }

    public static final /* synthetic */ void i(FinderLivePostUIC finderLivePostUIC) {
        Boolean bool;
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(247934);
        g gVar = finderLivePostUIC.liveData;
        if (gVar != null) {
            bool = Boolean.valueOf(gVar.uit);
        } else {
            bool = null;
        }
        Log.i(TAG, "clickShop:hasBindShop:".concat(String.valueOf(bool)));
        if (kotlin.g.b.p.j(bool, Boolean.TRUE)) {
            com.tencent.mm.live.c.b bVar = finderLivePostUIC.hOp;
            if (bVar == null) {
                kotlin.g.b.p.btv("statusMonitor");
            }
            b.C0376b.a(bVar, b.c.hMZ);
            AppMethodBeat.o(247934);
            return;
        }
        if (finderLivePostUIC.vOq != null) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("enter shop:");
            bel bel = finderLivePostUIC.vOq;
            StringBuilder append = sb.append(bel != null ? bel.appId : null).append(',');
            bel bel2 = finderLivePostUIC.vOq;
            if (bel2 != null) {
                str3 = bel2.LOg;
            }
            Log.i(str4, append.append(str3).toString());
            String str5 = "livePost:0" + z.aUg() + ":0:" + Util.getUuidRandom();
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Activity context = finderLivePostUIC.getContext();
            bel bel3 = finderLivePostUIC.vOq;
            if (bel3 == null || (str = bel3.appId) == null) {
                str = "";
            }
            bel bel4 = finderLivePostUIC.vOq;
            if (bel4 == null || (str2 = bel4.LOg) == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.finder.utils.a.a(context, str, str2, 1176, str5);
        }
        AppMethodBeat.o(247934);
    }

    public static final /* synthetic */ void a(FinderLivePostUIC finderLivePostUIC, com.tencent.mm.ui.base.m mVar) {
        String string;
        int i2;
        long j2;
        String string2;
        int i3;
        String string3;
        int i4;
        long j3 = 0;
        AppMethodBeat.i(247935);
        if (finderLivePostUIC.diT()) {
            string = finderLivePostUIC.getContext().getResources().getString(R.string.cwt);
            kotlin.g.b.p.g(string, "context.resources.getStr…_more_action_ban_comment)");
            i2 = R.raw.icon_outlined_close_comment;
        } else {
            string = finderLivePostUIC.getContext().getResources().getString(R.string.cwr);
            kotlin.g.b.p.g(string, "context.resources.getStr…ore_action_allow_comment)");
            i2 = R.raw.icons_outlined_comment;
        }
        mVar.a(finderLivePostUIC.uCA, string, i2, Color.parseColor("#CCFFFFFF"));
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (gVar != null) {
            j2 = gVar.field_liveSwitchFlag;
        } else {
            j2 = 0;
        }
        if (com.tencent.mm.plugin.finder.utils.m.Gc(j2)) {
            if (finderLivePostUIC.diS()) {
                string3 = finderLivePostUIC.getContext().getResources().getString(R.string.cwx);
                kotlin.g.b.p.g(string3, "context.resources.getStr…_action_disable_link_mic)");
                i4 = R.raw.finder_live_unmic;
            } else {
                string3 = finderLivePostUIC.getContext().getResources().getString(R.string.cwz);
                kotlin.g.b.p.g(string3, "context.resources.getStr…e_action_enable_link_mic)");
                i4 = R.raw.finder_icons_request_link_mic;
            }
            mVar.a(finderLivePostUIC.usT, string3, i4, Color.parseColor("#CCFFFFFF"));
        }
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.api.g gVar2 = finderLivePostUIC.uCY;
        if (gVar2 != null) {
            j3 = gVar2.field_liveSwitchFlag;
        }
        if (com.tencent.mm.plugin.finder.utils.m.Gd(j3)) {
            if (finderLivePostUIC.diV()) {
                string2 = finderLivePostUIC.getContext().getResources().getString(R.string.cww);
                kotlin.g.b.p.g(string2, "context.resources.getStr…more_action_disable_gift)");
                i3 = R.raw.finder_live_ungift;
            } else {
                string2 = finderLivePostUIC.getContext().getResources().getString(R.string.cwy);
                kotlin.g.b.p.g(string2, "context.resources.getStr…_more_action_enable_gift)");
                i3 = R.raw.finder_live_gift;
            }
            mVar.a(finderLivePostUIC.usU, string2, i3, Color.parseColor("#CCFFFFFF"));
        }
        AppMethodBeat.o(247935);
    }

    public static final /* synthetic */ void o(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) | 8);
        }
    }

    public static final /* synthetic */ void p(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) & -9);
        }
    }

    public static final /* synthetic */ void t(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) | 64);
        }
    }

    public static final /* synthetic */ void x(FinderLivePostUIC finderLivePostUIC) {
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (gVar != null) {
            gVar.field_liveAnchorStatusFlag = (long) (((int) gVar.field_liveAnchorStatusFlag) | 128);
        }
    }
}
