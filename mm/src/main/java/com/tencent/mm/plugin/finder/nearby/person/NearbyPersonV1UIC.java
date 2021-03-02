package com.tencent.mm.plugin.finder.nearby.person;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0003stuB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000206H\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u00020$H\u0016J\n\u0010=\u001a\u0004\u0018\u00010*H\u0002J\n\u0010>\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0018\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u0010H\u0002J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020$H\u0002J*\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u00020JH\u0002J\u0018\u0010K\u001a\u0002062\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J*\u0010L\u001a\u0002062\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u000209H\u0002J*\u0010M\u001a\u0002062\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u00020JH\u0002J\u0018\u0010N\u001a\u0002062\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J\b\u0010O\u001a\u000206H\u0002J\b\u0010P\u001a\u000206H\u0002J\b\u0010Q\u001a\u000206H\u0002J\b\u0010R\u001a\u000206H\u0002J\b\u0010S\u001a\u000206H\u0002J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u0017H\u0002J\u0010\u0010V\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u0017H\u0002J\b\u0010W\u001a\u000206H\u0002J\u0006\u0010X\u001a\u000206J\u0006\u0010Y\u001a\u000206J\u0012\u0010Z\u001a\u0002062\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u000206H\u0016J\u0006\u0010^\u001a\u000206J\b\u0010_\u001a\u000206H\u0016J\b\u0010`\u001a\u000206H\u0016J*\u0010a\u001a\u0002062\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u00020JH\u0016J\b\u0010b\u001a\u000206H\u0016J\b\u0010c\u001a\u000206H\u0016J\b\u0010d\u001a\u000206H\u0002J$\u0010e\u001a\u0002062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002060g2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002060gH\u0002J\u0018\u0010i\u001a\u00020\u00192\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020$H\u0002J\b\u0010l\u001a\u000206H\u0002J\u0006\u0010m\u001a\u000206J\b\u0010n\u001a\u000206H\u0002J\b\u0010o\u001a\u000206H\u0002J\b\u0010p\u001a\u000206H\u0002J\b\u0010q\u001a\u000206H\u0002J\b\u0010r\u001a\u000206H\u0002R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0006\u0012\u0002\b\u00030,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010*X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "bindMobileHeader", "Lcom/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView;", "exitModeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "exposePerson", "", "", "findItems", "", "[Ljava/lang/String;", "friendLV", "Landroid/widget/ListView;", "friendList", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "hasHeaderView", "", "hasLoadData", "hasLoadedData", "hasLocated", "hasShowGpsAlert", "hasShowLBSOpenDialog", "iGetLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "isCancel", "isRequested", "lbsFindType", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "sayHiLayout", "Landroid/view/View;", "sayHiListener", "Lcom/tencent/mm/sdk/event/IListener;", "showBannerType", "showBindMobileHeaderFlag", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vgHeaderContainer", "Landroid/view/ViewGroup;", "viewBtnSayHi", "viewLbsRoomEntry", "checkIfShowLbsRoom", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "scene", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "dismissLoadingDialog", "dismissTipDialog", "getLayoutId", "getLvHeaderContainer", "getSayHiLayout", "gotoContactInfoUI", "info", "gotoLbsRoom", "lbsRoom", "roomNickname", "handleItemClick", "position", "handleJoinRoomRequest", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleLbsClearLocation", "handleLbsError", "handleLbsFind", "handleLbsFindFriends", "hideLbsRoomEntryView", "hideLiveBottomSheet", "initADData", "initConfig", "initContentView", "isShowFinderFlag", "contactInfo", "isShowSnsFlag", "mergeADItemList", "onActionbarClick", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onResume", "onSceneEnd", "onUserVisibleFocused", "onUserVisibleUnFocused", "showClearLocationDialog", "showLBSOpenDialog", "okCallback", "Lkotlin/Function0;", "cancelCallback", "showLbsRoomEntry", "groupName", "memberCount", "showLbsTips", "showLiveBottomSheet", "showLoadingDialog", "sortFriendList", "startJoinLbsRoomRequest", "startLoadData", "updateSayHiLayout", "NearbyFriendAdapter", "PoiItemConverter", "ViewHolder", "plugin-finder_release"})
public final class NearbyPersonV1UIC extends NearbyPersonUIC {
    private com.tencent.mm.modelgeo.d gmt;
    private boolean ifz;
    ListView khv;
    private final b.a qgt = new j(this);
    private List<chi> sNv = new LinkedList();
    private com.tencent.mm.ui.base.q tipDialog;
    private ViewGroup uSh;
    private List<String> uSi = new LinkedList();
    private View uSj;
    private final View uSk;
    private a uSl;
    private boolean uSm;
    private int uSn;
    private boolean uSo;
    private int uSp = 1;
    private boolean uSq;
    private boolean uSr;
    private int uSs;
    private NearbyPersonUIC.c uSt;
    private boolean uSu;
    private boolean uSv;
    private boolean uSw;
    com.tencent.mm.ui.widget.a.e uSx;
    private final IListener<?> uSy = new n(this);
    private View uSz;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$ViewHolder;", "", "()V", "adIconImg1", "Landroid/widget/ImageView;", "getAdIconImg1", "()Landroid/widget/ImageView;", "setAdIconImg1", "(Landroid/widget/ImageView;)V", "adIconImg2", "getAdIconImg2", "setAdIconImg2", "adIconImg3", "getAdIconImg3", "setAdIconImg3", "addState", "Landroid/widget/TextView;", "getAddState", "()Landroid/widget/TextView;", "setAddState", "(Landroid/widget/TextView;)V", "avatar", "getAvatar", "setAvatar", "closeBtn", "getCloseBtn", "setCloseBtn", "displayName", "getDisplayName", "setDisplayName", "distance", "getDistance", "setDistance", "finderFlagIv", "Landroid/view/View;", "getFinderFlagIv", "()Landroid/view/View;", "setFinderFlagIv", "(Landroid/view/View;)V", "sex", "getSex", "setSex", "sign", "getSign", "setSign", "snsFlagIv", "getSnsFlagIv", "setSnsFlagIv", "vuserinfoIv", "getVuserinfoIv", "setVuserinfoIv", "plugin-finder_release"})
    public static final class c {
        ImageView hTd;
        TextView kcS;
        ImageView keC;
        TextView keD;
        TextView uSG;
        TextView uSH;
        ImageView uSI;
        ImageView uSJ;
        View uSK;
        ImageView uSL;
        ImageView uSM;
        ImageView uSN;
        ImageView uSO;
    }

    public static final /* synthetic */ void B(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249330);
        nearbyPersonV1UIC.dlv();
        AppMethodBeat.o(249330);
    }

    public static final /* synthetic */ void c(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249322);
        nearbyPersonV1UIC.dlx();
        AppMethodBeat.o(249322);
    }

    public static final /* synthetic */ boolean c(chi chi) {
        AppMethodBeat.i(249323);
        boolean b2 = b(chi);
        AppMethodBeat.o(249323);
        return b2;
    }

    public static final /* synthetic */ void v(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249329);
        nearbyPersonV1UIC.dlu();
        AppMethodBeat.o(249329);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "maccuracy", "altitude", "onGetLocation"})
    static final class j implements b.a {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        j(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            boolean z2;
            AppMethodBeat.i(249287);
            if (this.uSA.uSr) {
                AppMethodBeat.o(249287);
                return false;
            }
            this.uSA.uSr = true;
            if (this.uSA.ifz) {
                NearbyPersonV1UIC.v(this.uSA);
                com.tencent.mm.plugin.report.service.g.Wn(11);
                AppMethodBeat.o(249287);
                return false;
            }
            if (z) {
                if (this.uSA.tipDialog != null) {
                    com.tencent.mm.ui.base.q qVar = this.uSA.tipDialog;
                    if (qVar == null) {
                        kotlin.g.b.p.hyc();
                    }
                    qVar.setMessage(this.uSA.getString(R.string.f_u));
                }
                this.uSA.uSt = new NearbyPersonUIC.c(f3, f2, (int) d3);
                com.tencent.mm.modelstat.e bge = com.tencent.mm.modelstat.e.bge();
                boolean z3 = i2 != 0;
                com.tencent.mm.modelgeo.d dVar = this.uSA.gmt;
                if (dVar != null) {
                    z2 = dVar.bcb();
                } else {
                    z2 = false;
                }
                bge.a(2001, z3, z2, f2, f3, (int) d3);
                NearbyPersonV1UIC nearbyPersonV1UIC = this.uSA;
                int i3 = this.uSA.uSp;
                NearbyPersonUIC.c cVar = this.uSA.uSt;
                if (cVar == null) {
                    kotlin.g.b.p.hyc();
                }
                float f4 = cVar.iUZ;
                NearbyPersonUIC.c cVar2 = this.uSA.uSt;
                if (cVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f5 = cVar2.iUY;
                NearbyPersonUIC.c cVar3 = this.uSA.uSt;
                if (cVar3 == null) {
                    kotlin.g.b.p.hyc();
                }
                nearbyPersonV1UIC.uRV = new com.tencent.mm.plugin.nearby.a.c(i3, f4, f5, cVar3.accuracy, i2, "", "");
                com.tencent.mm.kernel.g.azz().b(this.uSA.uRV);
                Log.i("NearbyPersonUIC", "onGetLocation doScene");
            } else {
                com.tencent.mm.plugin.report.service.g.Wn(11);
                NearbyPersonV1UIC.v(this.uSA);
                this.uSA.getRootView().findViewById(R.id.fu7).setVisibility(0);
                ListView listView = this.uSA.khv;
                if (listView == null) {
                    kotlin.g.b.p.hyc();
                }
                listView.setVisibility(8);
                this.uSA.uSq = true;
                if (!this.uSA.uSu && !com.tencent.mm.modelgeo.d.bcc()) {
                    this.uSA.uSu = true;
                    com.tencent.mm.ui.base.h.a((Context) this.uSA.getActivity(), this.uSA.getString(R.string.dvi), this.uSA.getString(R.string.zb), this.uSA.getString(R.string.e_k), this.uSA.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.j.AnonymousClass1 */
                        final /* synthetic */ j uSR;

                        {
                            this.uSR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(249286);
                            com.tencent.mm.modelgeo.d.cZ(this.uSR.uSA.getActivity());
                            AppMethodBeat.o(249286);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
            }
            AppMethodBeat.o(249287);
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyPersonV1UIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249320);
        AppMethodBeat.o(249320);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyPersonV1UIC(Fragment fragment) {
        super(fragment);
        kotlin.g.b.p.h(fragment, "fragment");
        AppMethodBeat.i(249321);
        AppMethodBeat.o(249321);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.bfi;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        NearbyPersonV1UIC nearbyPersonV1UIC;
        int i2;
        AppMethodBeat.i(249306);
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.Wl(11);
        String value = com.tencent.mm.n.h.aqJ().getValue("LBSShowBindPhone");
        if (value != null) {
            if (value.length() > 0) {
                try {
                    Integer valueOf = Integer.valueOf(value);
                    kotlin.g.b.p.g(valueOf, "Integer.valueOf(flag)");
                    i2 = valueOf.intValue();
                    nearbyPersonV1UIC = this;
                } catch (Exception e2) {
                    nearbyPersonV1UIC = this;
                    i2 = 0;
                }
                nearbyPersonV1UIC.uSn = i2;
            }
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().get(6);
        if (str != null) {
            if (str.length() > 0) {
                this.uSn = 0;
            }
        }
        this.uSs = 0;
        if (com.tencent.mm.model.a.g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            String value2 = com.tencent.mm.model.a.g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).getValue();
            l.a bnZ = com.tencent.mm.plugin.account.friend.a.l.bnZ();
            if (kotlin.g.b.p.j(value2, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.uSs = 0;
            } else if (kotlin.g.b.p.j(value2, "2")) {
                if (bnZ == l.a.SUCC_UNLOAD) {
                    this.uSs = 2;
                }
            } else if (kotlin.g.b.p.j(value2, "1") && bnZ == l.a.NO_INIT) {
                this.uSs = 2;
            }
        }
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        this.uSp = Util.nullAs((Integer) aAh2.azQ().get(16386), 1);
        this.uSl = new a(this, getActivity());
        this.khv = (ListView) getRootView().findViewById(R.id.fu8);
        ListView listView = this.khv;
        if (listView != null) {
            if (this.uSh == null) {
                this.uSh = new LinearLayout(getActivity());
                ViewGroup viewGroup = this.uSh;
                if (viewGroup != null) {
                    viewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                }
                ViewGroup viewGroup2 = this.uSh;
                if (viewGroup2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout");
                    AppMethodBeat.o(249306);
                    throw tVar;
                }
                ((LinearLayout) viewGroup2).setGravity(17);
            }
            this.uSm = true;
            listView.addHeaderView(this.uSh);
        }
        ListView listView2 = this.khv;
        if (listView2 != null) {
            listView2.setAdapter((ListAdapter) this.uSl);
        }
        ListView listView3 = this.khv;
        if (listView3 != null) {
            listView3.setOnItemClickListener(new h(this));
        }
        ListView listView4 = this.khv;
        if (listView4 != null) {
            listView4.setOnTouchListener(new i(this));
        }
        Log.i("NearbyPersonUIC", "onCreate");
        AppMethodBeat.o(249306);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249307);
        super.onUserVisibleFocused();
        m mVar = new m(this);
        l lVar = new l(this);
        if (!this.uSw) {
            View inflate = View.inflate(getActivity(), R.layout.azk, null);
            View findViewById = inflate != null ? inflate.findViewById(R.id.e_r) : null;
            if (findViewById == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(249307);
                throw tVar;
            }
            findViewById.setVisibility(4);
            com.tencent.mm.ui.base.h.a(getActivity(), inflate, new p(mVar), new q(lVar)).show();
            this.uSw = true;
        }
        i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        i.a.c(3, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
        Log.i("NearbyPersonUIC", "onUserVisibleFocused");
        AppMethodBeat.o(249307);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249308);
        super.onUserVisibleUnFocused();
        Log.i("NearbyPersonUIC", "onUserVisibleUnFocused");
        AppMethodBeat.o(249308);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(249309);
        Log.i("NearbyPersonUIC", "onResume");
        dlv();
        a aVar = this.uSl;
        if (aVar == null) {
            kotlin.g.b.p.hyc();
        }
        aVar.notifyDataSetChanged();
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.g eiv = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiv();
        kotlin.g.b.p.g(eiv, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
        if (eiv.ctM() == 0) {
            ListView listView = this.khv;
            if (listView == null) {
                kotlin.g.b.p.hyc();
            }
            listView.removeHeaderView(this.uSk);
        }
        EventCenter.instance.addListener(this.uSy);
        this.ifz = false;
        AppMethodBeat.o(249309);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(249310);
        Log.i("NearbyPersonUIC", "onPause");
        com.tencent.mm.modelgeo.d dVar = this.gmt;
        if (dVar != null) {
            dVar.c(this.qgt);
        }
        EventCenter.instance.removeListener(this.uSy);
        this.ifz = true;
        AppMethodBeat.o(249310);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(249311);
        super.onDestroy();
        if (this.uSs > 0) {
            com.tencent.mm.model.a.f.KW(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        com.tencent.mm.plugin.report.service.g.Wn(11);
        com.tencent.mm.kernel.g.azz().b(148, this);
        com.tencent.mm.kernel.g.azz().b(376, this);
        com.tencent.mm.kernel.g.azz().b(1087, this);
        dlu();
        com.tencent.mm.modelgeo.d dVar = this.gmt;
        if (dVar != null) {
            dVar.c(this.qgt);
        }
        com.tencent.mm.aj.p.aYD().cancel();
        a aVar = this.uSl;
        if (!(aVar == null || aVar.kex == null)) {
            com.tencent.mm.ui.applet.b bVar = aVar.kex;
            if (bVar == null) {
                kotlin.g.b.p.hyc();
            }
            bVar.detach();
            aVar.kex = null;
        }
        if (this.sNv.size() > 0) {
            String str = "";
            for (NearbyPersonUIC.a aVar2 : this.uRY.values()) {
                StringBuilder append = new StringBuilder().append(str).append("|").append(aVar2.id).append(":").append(aVar2.uSe).append(":");
                aVar2.qdp++;
                str = append.append(aVar2.qdp).toString();
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_NEAR_BY_AD_STRING_SYNC, str);
        }
        AppMethodBeat.o(249311);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"})
    static final class h implements AdapterView.OnItemClickListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        h(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(249284);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$initContentView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            NearbyPersonV1UIC.b(this.uSA, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$initContentView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(249284);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class i implements View.OnTouchListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        i(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            a aVar;
            AppMethodBeat.i(249285);
            if (!(this.uSA.uSl == null || (aVar = this.uSA.uSl) == null || aVar.kex == null)) {
                com.tencent.mm.ui.applet.b bVar = aVar.kex;
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(249285);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class s implements o.f {
        public static final s uSV = new s();

        static {
            AppMethodBeat.i(249298);
            AppMethodBeat.o(249298);
        }

        s() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(249297);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1, R.string.faw);
                mVar.kV(2, R.string.fax);
                mVar.kV(3, R.string.fat);
                mVar.kV(4, R.string.fay);
                mVar.kV(5, R.string.fav);
            }
            Log.i("NearbyPersonUIC", "showLiveBottomSheet create menu.");
            AppMethodBeat.o(249297);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class t implements o.g {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        t(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(249299);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    this.uSA.uSp = 4;
                    this.uSA.uSo = false;
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(16386, Integer.valueOf(this.uSA.uSp));
                    NearbyPersonV1UIC.f(this.uSA);
                    break;
                case 2:
                    this.uSA.uSp = 3;
                    this.uSA.uSo = false;
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(16386, Integer.valueOf(this.uSA.uSp));
                    NearbyPersonV1UIC.f(this.uSA);
                    break;
                case 3:
                    this.uSA.uSp = 1;
                    this.uSA.uSo = false;
                    com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(16386, Integer.valueOf(this.uSA.uSp));
                    NearbyPersonV1UIC.f(this.uSA);
                    break;
                case 4:
                    Intent intent = new Intent(this.uSA.getActivity(), NearbySayHiListUI.class);
                    intent.putExtra("k_say_hi_type", 2);
                    this.uSA.getActivity().startActivityForResult(intent, 2009);
                    i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    i.a.c(2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(FinderReporterUIC.class)).dIx());
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                    ((aj) ah).getRedDotManager().asV("NearbyPeopleBubble");
                    break;
                case 5:
                    this.uSA.uRW = new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", "");
                    com.tencent.mm.kernel.g.azz().b(this.uSA.uRW);
                    NearbyPersonV1UIC.k(this.uSA);
                    break;
            }
            com.tencent.mm.plugin.finder.nearby.report.b bVar = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
            com.tencent.mm.plugin.finder.nearby.report.b.JE(menuItem.getItemId());
            AppMethodBeat.o(249299);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    static final class u implements e.a {
        public static final u uSW = new u();

        static {
            AppMethodBeat.i(249301);
            AppMethodBeat.o(249301);
        }

        u() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.a
        public final void onClick() {
            AppMethodBeat.i(249300);
            com.tencent.mm.plugin.finder.nearby.report.b bVar = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
            com.tencent.mm.plugin.finder.nearby.report.b.JE(6);
            AppMethodBeat.o(249300);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class v implements e.b {
        public static final v uSX = new v();

        static {
            AppMethodBeat.i(249303);
            AppMethodBeat.o(249303);
        }

        v() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(249302);
            Log.i("NearbyPersonUIC", "showLiveBottomSheet dismiss");
            AppMethodBeat.o(249302);
        }
    }

    private final void dlt() {
        AppMethodBeat.i(249312);
        Log.i("NearbyPersonUIC", "showLbsTips");
        com.tencent.mm.plugin.nearby.a.jRt.bY(getActivity());
        AppMethodBeat.o(249312);
    }

    private final void dlu() {
        AppMethodBeat.i(249313);
        Log.i("NearbyPersonUIC", "dismissTipDialog");
        cGW();
        AppMethodBeat.o(249313);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class w implements DialogInterface.OnCancelListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        w(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(249304);
            this.uSA.ifz = true;
            com.tencent.mm.plugin.report.service.g.Wn(11);
            if (this.uSA.uRV != null) {
                com.tencent.mm.kernel.g.azz().a(this.uSA.uRV);
            }
            Log.i("NearbyPersonUIC", "showLoadingDialog  [loading cancel] cancel in loading");
            if (!this.uSA.uSq) {
                Log.i("NearbyPersonUIC", "showLoadingDialog [loading cancel] cancel in first loading");
            }
            AppMethodBeat.o(249304);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class o implements DialogInterface.OnCancelListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        o(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(249293);
            com.tencent.mm.kernel.g.azz().a(this.uSA.uRW);
            AppMethodBeat.o(249293);
        }
    }

    private final void cGW() {
        AppMethodBeat.i(249314);
        com.tencent.mm.ui.base.q qVar = this.tipDialog;
        if (qVar != null) {
            qVar.dismiss();
        }
        this.tipDialog = null;
        AppMethodBeat.o(249314);
    }

    private static boolean b(chi chi) {
        return chi.MmQ != null && (chi.MmQ.kej & 1) > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x03e4  */
    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.nearby.person.NearbyPersonUIC
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r15, int r16, java.lang.String r17, com.tencent.mm.ak.q r18) {
        /*
        // Method dump skipped, instructions count: 1212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        public static final g uSQ = new g();

        static {
            AppMethodBeat.i(249283);
            AppMethodBeat.o(249283);
        }

        g() {
        }

        public final void run() {
            AppMethodBeat.i(249282);
            com.tencent.mm.plugin.report.service.g.Wm(11);
            AppMethodBeat.o(249282);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        f(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(249281);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(NearbyHomeUIC.class)).Jz(1001);
            AppMethodBeat.o(249281);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$sayHiListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LbsSayHiEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class n extends IListener<ls> {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ls lsVar) {
            AppMethodBeat.i(249292);
            if (lsVar != null) {
                MMHandlerThread.postToMainThread(new a(this));
            }
            AppMethodBeat.o(249292);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ n uSS;

            a(n nVar) {
                this.uSS = nVar;
            }

            public final void run() {
                AppMethodBeat.i(249291);
                NearbyPersonV1UIC.B(this.uSS.uSA);
                AppMethodBeat.o(249291);
            }
        }
    }

    private final void dlv() {
        AppMethodBeat.i(249316);
        if (com.tencent.mm.bp.a.glC() || com.tencent.mm.bp.a.glB()) {
            if (this.uSj != null) {
                ListView listView = this.khv;
                if (listView == null) {
                    kotlin.g.b.p.hyc();
                }
                listView.removeHeaderView(this.uSj);
                this.uSj = null;
            }
            this.uSj = dlw();
            if (this.uSj != null) {
                ListView listView2 = this.khv;
                if (listView2 == null) {
                    kotlin.g.b.p.hyc();
                }
                listView2.addHeaderView(this.uSj);
            }
        }
        AppMethodBeat.o(249316);
    }

    private final View dlw() {
        AppMethodBeat.i(249317);
        View inflate = View.inflate(getActivity(), R.layout.bf4, null);
        View findViewById = inflate.findViewById(R.id.h_k);
        if (findViewById == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(249317);
            throw tVar;
        }
        TextView textView = (TextView) findViewById;
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.g eiv = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiv();
        kotlin.g.b.p.g(eiv, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
        int ctM = eiv.ctM();
        if (ctM == 0) {
            kotlin.g.b.p.g(inflate, "viewToList");
            inflate.setVisibility(8);
            AppMethodBeat.o(249317);
            return null;
        }
        kotlin.g.b.p.g(inflate, "viewToList");
        inflate.setVisibility(0);
        textView.setText(getActivity().getResources().getQuantityString(R.plurals.a3, ctM, Integer.valueOf(ctM)));
        View findViewById2 = inflate.findViewById(R.id.faz);
        if (findViewById2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(249317);
            throw tVar2;
        }
        ImageView imageView = (ImageView) findViewById2;
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.g eiv2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).eiv();
        kotlin.g.b.p.g(eiv2, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
        bx eiG = eiv2.eiG();
        if (eiG != null) {
            a.b.c(imageView, eiG.field_sayhiuser);
        }
        inflate.setOnClickListener(new d(this));
        AppMethodBeat.o(249317);
        return inflate;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        d(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(249279);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ListView listView = this.uSA.khv;
            if (listView == null) {
                kotlin.g.b.p.hyc();
            }
            listView.removeHeaderView(this.uSA.uSj);
            this.uSA.uSj = null;
            Intent intent = new Intent(this.uSA.getActivity(), NearbySayHiListUI.class);
            intent.putExtra("k_say_hi_type", 2);
            intent.putExtra("show_clear_header", true);
            this.uSA.getActivity().startActivityForResult(intent, 2009);
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            i.a.c(2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(FinderReporterUIC.class)).dIx());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            ((aj) ah).getRedDotManager().asV("NearbyPeopleBubble");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249279);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class r implements View.OnClickListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        r(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(249296);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            NearbyPersonV1UIC.s(this.uSA);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249296);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class x implements DialogInterface.OnCancelListener {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        x(NearbyPersonV1UIC nearbyPersonV1UIC) {
            this.uSA = nearbyPersonV1UIC;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(249305);
            com.tencent.mm.kernel.g.azz().a(this.uSA.uRX);
            AppMethodBeat.o(249305);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class e implements DialogInterface.OnClickListener {
        public static final e uSP = new e();

        static {
            AppMethodBeat.i(249280);
            AppMethodBeat.o(249280);
        }

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private final void dlx() {
        int i2;
        int i3;
        AppMethodBeat.i(249318);
        LinkedList linkedList = new LinkedList();
        int size = this.sNv.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = b.uSF;
            if (!b.JD(this.sNv.get(i4).kdY)) {
                linkedList.add(this.sNv.get(i4));
            }
        }
        this.sNv.clear();
        this.sNv = linkedList;
        Log.i("NearbyPersonUIC", "mergeADItemList friendList size:" + this.sNv.size());
        boolean z = !this.sNv.isEmpty();
        int i5 = 0;
        for (String str : this.uRY.keySet()) {
            if (z) {
                NearbyPersonUIC.a aVar = this.uRY.get(str);
                if (aVar == null) {
                    kotlin.g.b.p.hyc();
                }
                if (!aVar.oBV && ((aVar.uSa <= 0 || aVar.uSe < aVar.uSa) && aVar.qdp < aVar.uSb)) {
                    List<chi> list = this.sNv;
                    if (aVar.pos < 0 || aVar.pos > this.sNv.size()) {
                        i3 = this.sNv.size();
                    } else {
                        i3 = aVar.pos + i5;
                    }
                    b bVar2 = b.uSF;
                    list.add(i3, b.h(aVar.id, aVar.icon, aVar.name, aVar.desc, aVar.uSd));
                    i2 = i5 + 1;
                    i5 = i2;
                }
            }
            i2 = i5;
            i5 = i2;
        }
        AppMethodBeat.o(249318);
    }

    private final void dly() {
        AppMethodBeat.i(249319);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        for (chi chi : this.sNv) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            if (((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjG(chi.UserName)) {
                linkedList.add(i2, chi);
                i2++;
            } else if (!Util.isNullOrNil(chi.UserName) && !Util.isNullOrNil(chi.MmJ)) {
                linkedList.add(chi);
            }
        }
        this.sNv.clear();
        this.sNv = linkedList;
        AppMethodBeat.o(249319);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/content/Context;)V", "earlyGetHeadImg", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg;", "getter", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "detach", "", "getCount", "", "getItem", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImgBmp", "img", "Landroid/widget/ImageView;", "url", "", "plugin-finder_release"})
    public final class a extends BaseAdapter {
        private final Context context;
        com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(C1245a.uSB);
        private b.AbstractC2078b kez;
        final /* synthetic */ NearbyPersonV1UIC uSA;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "userName", "", "getHeadImg"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC$a$a  reason: collision with other inner class name */
        static final class C1245a implements b.a {
            public static final C1245a uSB = new C1245a();

            static {
                AppMethodBeat.i(249266);
                AppMethodBeat.o(249266);
            }

            C1245a() {
            }

            @Override // com.tencent.mm.ui.applet.b.a
            public final Bitmap Ta(String str) {
                AppMethodBeat.i(249265);
                Bitmap Mc = com.tencent.mm.aj.c.Mc(str);
                AppMethodBeat.o(249265);
                return Mc;
            }
        }

        public a(NearbyPersonV1UIC nearbyPersonV1UIC, Context context2) {
            kotlin.g.b.p.h(context2, "context");
            this.uSA = nearbyPersonV1UIC;
            AppMethodBeat.i(249276);
            this.context = context2;
            AppMethodBeat.o(249276);
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(249274);
            chi JC = JC(i2);
            AppMethodBeat.o(249274);
            return JC;
        }

        public final int getCount() {
            AppMethodBeat.i(249271);
            int size = this.uSA.sNv.size();
            AppMethodBeat.o(249271);
            return size;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$1", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "getMaxPos", "", "getUsername", "", "pos", "plugin-finder_release"})
        public static final class b implements b.AbstractC2078b {
            final /* synthetic */ a uSC;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(a aVar) {
                this.uSC = aVar;
            }

            @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
            public final String vg(int i2) {
                AppMethodBeat.i(249267);
                if (i2 < 0 || i2 >= this.uSC.getCount()) {
                    Log.e("NearbyPersonUIC", "pos is invalid");
                    AppMethodBeat.o(249267);
                    return null;
                }
                chi JC = this.uSC.JC(i2);
                if (JC != null) {
                    String str = JC.UserName;
                    AppMethodBeat.o(249267);
                    return str;
                }
                AppMethodBeat.o(249267);
                return null;
            }

            @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
            public final int bnW() {
                AppMethodBeat.i(249268);
                int count = this.uSC.getCount();
                AppMethodBeat.o(249268);
                return count;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:217:0x0469  */
        /* JADX WARNING: Removed duplicated region for block: B:222:0x0477  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0489  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x04d7  */
        /* JADX WARNING: Removed duplicated region for block: B:246:0x04ff  */
        /* JADX WARNING: Removed duplicated region for block: B:249:0x050a  */
        /* JADX WARNING: Removed duplicated region for block: B:258:0x0529  */
        @android.annotation.SuppressLint({"ResourceType"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
            /*
            // Method dump skipped, instructions count: 1502
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class c implements View.OnClickListener {
            final /* synthetic */ a uSC;
            final /* synthetic */ chi uSD;

            c(a aVar, chi chi) {
                this.uSC = aVar;
                this.uSD = chi;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(249269);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NearbyPersonUIC.a aVar = this.uSC.uSA.uRY.get(this.uSD.UserName);
                if (aVar != null) {
                    aVar.uSe++;
                    aVar.oBV = true;
                    aVar.uSf |= 2;
                }
                NearbyPersonV1UIC.c(this.uSC.uSA);
                this.uSC.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(249269);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ a uSC;
            final /* synthetic */ chi uSD;

            d(a aVar, chi chi) {
                this.uSC = aVar;
                this.uSD = chi;
            }

            public final void run() {
                AppMethodBeat.i(249270);
                com.tencent.mm.plugin.finder.nearby.report.b bVar = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
                String str = this.uSD.UserName;
                if (str == null) {
                    str = "";
                }
                String str2 = this.uSD.MmJ;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = this.uSD.keh;
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = this.uSD.kea;
                if (str4 == null) {
                    str4 = "";
                }
                boolean c2 = NearbyPersonV1UIC.c(this.uSD);
                kotlin.g.b.p.h(str, "userName");
                kotlin.g.b.p.h(str2, "district");
                kotlin.g.b.p.h(str3, UserDataStore.COUNTRY);
                kotlin.g.b.p.h(str4, "city");
                com.tencent.mm.plugin.finder.nearby.report.b.a(str, str2, str3, str4, c2, 1);
                AppMethodBeat.o(249270);
            }
        }

        public final chi JC(int i2) {
            AppMethodBeat.i(249273);
            chi chi = (chi) this.uSA.sNv.get(i2);
            AppMethodBeat.o(249273);
            return chi;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        private static void f(ImageView imageView, String str) {
            AppMethodBeat.i(249275);
            if (TextUtils.isEmpty(str)) {
                Log.e("NearbyPersonUIC", "setImgBmp url is empty");
                AppMethodBeat.o(249275);
                return;
            }
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            c.a aVar = new c.a();
            aVar.OT(com.tencent.mm.plugin.image.d.aSY());
            aVar.bdp();
            aVar.bds();
            com.tencent.mm.av.q.bcV().a(str, imageView, aVar.bdv());
            AppMethodBeat.o(249275);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$PoiItemConverter;", "", "()V", "SEX_FOR_POI_ITEM", "", "convertToLbsContactInfo", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "id", "", "icon", "name", "desc", "value", "getPoiLink", "info", "isSexForPoiItem", "", "sexVal", "plugin-finder_release"})
    public static final class b {
        private static int uSE = 10000;
        public static final b uSF = new b();

        static {
            AppMethodBeat.i(249278);
            AppMethodBeat.o(249278);
        }

        private b() {
        }

        public static chi h(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(249277);
            com.tencent.mm.plugin.nearby.a.a aVar = new com.tencent.mm.plugin.nearby.a.a();
            aVar.kdY = uSE;
            aVar.UserName = str;
            aVar.Lis = str2;
            aVar.MmJ = str4;
            aVar.oUJ = str3;
            aVar.kdZ = str5;
            com.tencent.mm.plugin.nearby.a.a aVar2 = aVar;
            AppMethodBeat.o(249277);
            return aVar2;
        }

        public static boolean JD(int i2) {
            return i2 == uSE;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(NearbyPersonV1UIC nearbyPersonV1UIC) {
            super(0);
            this.uSA = nearbyPersonV1UIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249290);
            if (!this.uSA.uSv) {
                NearbyPersonV1UIC.f(this.uSA);
                if (LocaleUtil.isSimplifiedChineseAppLang()) {
                    NearbyPersonV1UIC.g(this.uSA);
                }
                this.uSA.uSv = true;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249290);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(NearbyPersonV1UIC nearbyPersonV1UIC) {
            super(0);
            this.uSA = nearbyPersonV1UIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249289);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(NearbyHomeUIC.class)).Jz(1001);
            this.uSA.uSw = false;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249289);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class p implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.a uST;

        p(kotlin.g.a.a aVar) {
            this.uST = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(249294);
            this.uST.invoke();
            AppMethodBeat.o(249294);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class q implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.a uSU;

        q(kotlin.g.a.a aVar) {
            this.uSU = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(249295);
            this.uSU.invoke();
            AppMethodBeat.o(249295);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ NearbyPersonV1UIC uSA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(NearbyPersonV1UIC nearbyPersonV1UIC) {
            super(0);
            this.uSA = nearbyPersonV1UIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249288);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(NearbyActionBarUIC.class);
            NearbyActionBarUIC.dlg();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249288);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean d(chi chi) {
        return (chi.MmS & 1) > 0;
    }

    public static final /* synthetic */ void f(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249324);
        com.tencent.mm.kernel.g.azz().a(148, nearbyPersonV1UIC);
        com.tencent.mm.kernel.g.azz().a(376, nearbyPersonV1UIC);
        com.tencent.mm.kernel.g.azz().a(1087, nearbyPersonV1UIC);
        nearbyPersonV1UIC.getString(R.string.zb);
        nearbyPersonV1UIC.tipDialog = com.tencent.mm.ui.base.h.a((Context) nearbyPersonV1UIC.getActivity(), nearbyPersonV1UIC.getString(R.string.fa3), true, (DialogInterface.OnCancelListener) new w(nearbyPersonV1UIC));
        nearbyPersonV1UIC.uSr = false;
        nearbyPersonV1UIC.ifz = false;
        nearbyPersonV1UIC.gmt = com.tencent.mm.modelgeo.d.bca();
        com.tencent.mm.modelgeo.d dVar = nearbyPersonV1UIC.gmt;
        if (dVar != null) {
            dVar.b(nearbyPersonV1UIC.qgt);
            AppMethodBeat.o(249324);
            return;
        }
        AppMethodBeat.o(249324);
    }

    public static final /* synthetic */ void g(NearbyPersonV1UIC nearbyPersonV1UIC) {
        NearbyPersonUIC.a aVar;
        AppMethodBeat.i(249325);
        Map<String, String> parseXml = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_nearby_ad, ""), "lbsads", null);
        if (parseXml == null) {
            AppMethodBeat.o(249325);
            return;
        }
        int i2 = Util.getInt(parseXml.get(".lbsads.$count"), 0);
        if (i2 > 0) {
            int i3 = 0;
            while (i3 < i2) {
                String str = ".lbsads.lbsad" + (i3 == 0 ? "" : Integer.valueOf(i3));
                NearbyPersonUIC.a aVar2 = new NearbyPersonUIC.a();
                aVar2.id = parseXml.get(str + ".$id");
                aVar2.pos = Util.getInt(parseXml.get(str + ".$pos"), 0);
                aVar2.uSa = Util.getInt(parseXml.get(str + ".$close_times"), 0);
                aVar2.uSb = Util.getInt(parseXml.get(str + ".$show_times"), Integer.MAX_VALUE);
                aVar2.name = parseXml.get(str + ".name");
                aVar2.desc = parseXml.get(str + ".desc");
                aVar2.icon = parseXml.get(str + ".icon");
                aVar2.uSc = Util.getInt(parseXml.get(str + ".jump.$type"), 0);
                aVar2.uSd = parseXml.get(str + ".jump");
                Map<String, NearbyPersonUIC.a> map = nearbyPersonV1UIC.uRY;
                String str2 = aVar2.id;
                if (str2 == null) {
                    kotlin.g.b.p.hyc();
                }
                map.put(str2, aVar2);
                i3++;
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            String str3 = (String) aAh.azQ().i(ar.a.USERINFO_NEAR_BY_AD_STRING_SYNC);
            if (str3 != null) {
                Object[] array = kotlin.n.n.b(str3, new String[]{"\\|"}).toArray(new String[0]);
                if (array == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(249325);
                    throw tVar;
                }
                for (String str4 : (String[]) array) {
                    Object[] array2 = kotlin.n.n.b(str4, new String[]{":"}).toArray(new String[0]);
                    if (array2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(249325);
                        throw tVar2;
                    }
                    String[] strArr = (String[]) array2;
                    if (strArr.length == 3 && (aVar = nearbyPersonV1UIC.uRY.get(strArr[0])) != null) {
                        aVar.uSe = Util.getInt(strArr[1], 0);
                        aVar.qdp = Util.getInt(strArr[2], 0);
                    }
                }
                AppMethodBeat.o(249325);
                return;
            }
        }
        AppMethodBeat.o(249325);
    }

    public static final /* synthetic */ void b(NearbyPersonV1UIC nearbyPersonV1UIC, int i2) {
        boolean z = false;
        AppMethodBeat.i(249326);
        if ((com.tencent.mm.bp.a.glC() || com.tencent.mm.bp.a.glB()) && nearbyPersonV1UIC.uSj != null) {
            i2--;
        }
        if (nearbyPersonV1UIC.uSm) {
            i2--;
        }
        if (i2 < 0 || i2 >= nearbyPersonV1UIC.sNv.size()) {
            AppMethodBeat.o(249326);
            return;
        }
        chi chi = nearbyPersonV1UIC.sNv.get(i2);
        b bVar = b.uSF;
        if (b.JD(chi.kdY)) {
            NearbyPersonUIC.a aVar = nearbyPersonV1UIC.uRY.get(chi.UserName);
            if (aVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("invalid type".toString());
                AppMethodBeat.o(249326);
                throw illegalStateException;
            }
            aVar.uSf |= 1;
            if (aVar.uSc == 1) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1134;
                ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(nearbyPersonV1UIC.getActivity(), aVar.uSd, "", 0, 0, "", appBrandStatObject);
                AppMethodBeat.o(249326);
                return;
            }
            if (aVar.uSc == 2) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", aVar.uSd);
                intent.putExtra("geta8key_scene", 25);
                intent.putExtra("stastic_scene", 12);
                com.tencent.mm.br.c.b(nearbyPersonV1UIC.getActivity(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(249326);
            return;
        }
        String str = chi.UserName;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        kotlin.g.b.p.g(Kn, "contact");
        if (Kn.arv()) {
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", str);
            intent2.putExtra("Contact_Scene", 18);
            intent2.putExtra("Sns_from_Scene", 18);
            intent2.putExtra("lbs_ticket", chi.LRO);
            intent2.putExtra("Contact_IsLbsGotoChatting", true);
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                }
                if (z) {
                    uj ujVar = new uj();
                    ujVar.eaI.intent = intent2;
                    ujVar.eaI.username = str;
                    EventCenter.instance.publish(ujVar);
                    intent2.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                    com.tencent.mm.plugin.nearby.a.jRt.c(intent2, nearbyPersonV1UIC.getActivity());
                }
            }
        } else {
            Intent intent3 = new Intent();
            intent3.putExtra("Contact_User", chi.UserName);
            intent3.putExtra("Contact_Alias", chi.ked);
            intent3.putExtra("Contact_Nick", chi.oUJ);
            intent3.putExtra("Contact_Distance", chi.MmJ);
            intent3.putExtra("Contact_Signature", chi.keb);
            intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(chi.keh, chi.kdZ, chi.kea));
            intent3.putExtra("Contact_Sex", chi.kdY);
            intent3.putExtra("Contact_IsLBSFriend", true);
            intent3.putExtra("Contact_Scene", 18);
            intent3.putExtra("Contact_VUser_Info", chi.MmL);
            intent3.putExtra("Contact_VUser_Info_Flag", chi.MmK);
            intent3.putExtra("Contact_KWeibo_flag", chi.MmO);
            intent3.putExtra("Contact_KWeibo", chi.MmM);
            intent3.putExtra("Contact_KWeiboNick", chi.MmN);
            intent3.putExtra("Contact_KSnsIFlag", chi.MmQ.kej);
            intent3.putExtra("Contact_KSnsBgId", chi.MmQ.kel);
            intent3.putExtra("Contact_KSnsBgUrl", chi.MmQ.kek);
            intent3.putExtra("lbs_ticket", chi.LRO);
            intent3.putExtra("Contact_IsLbsGotoChatting", true);
            if (chi.kei != null) {
                com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                cVar.field_brandList = chi.kei;
                cVar.field_brandFlag = chi.MmR.kem;
                cVar.field_brandIconURL = chi.MmR.kep;
                cVar.field_extInfo = chi.MmR.ken;
                cVar.field_brandInfo = chi.MmR.keo;
                intent3.putExtra("KBrandInfo_item", new MCacheItem(cVar));
            }
            intent3.putExtra("Sns_from_Scene", 18);
            intent3.putExtra("CONTACT_INFO_UI_SOURCE", 5);
            com.tencent.mm.plugin.nearby.a.jRt.c(intent3, nearbyPersonV1UIC.getActivity());
        }
        com.tencent.mm.plugin.finder.nearby.report.b bVar2 = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
        String str2 = chi.UserName;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = chi.MmJ;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = chi.keh;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = chi.kea;
        if (str5 == null) {
            str5 = "";
        }
        boolean b2 = b(chi);
        kotlin.g.b.p.h(str2, "userName");
        kotlin.g.b.p.h(str3, "district");
        kotlin.g.b.p.h(str4, UserDataStore.COUNTRY);
        kotlin.g.b.p.h(str5, "city");
        com.tencent.mm.plugin.finder.nearby.report.b.a(str2, str3, str4, str5, b2, 2);
        AppMethodBeat.o(249326);
    }

    public static final /* synthetic */ void k(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249327);
        nearbyPersonV1UIC.getString(R.string.zb);
        nearbyPersonV1UIC.tipDialog = com.tencent.mm.ui.base.h.a((Context) nearbyPersonV1UIC.getActivity(), nearbyPersonV1UIC.getString(R.string.f_s), true, (DialogInterface.OnCancelListener) new o(nearbyPersonV1UIC));
        AppMethodBeat.o(249327);
    }

    public static final /* synthetic */ void s(NearbyPersonV1UIC nearbyPersonV1UIC) {
        AppMethodBeat.i(249328);
        if (nearbyPersonV1UIC.uSt != null) {
            NearbyPersonUIC.c cVar = nearbyPersonV1UIC.uSt;
            if (cVar == null) {
                kotlin.g.b.p.hyc();
            }
            float f2 = cVar.iUZ;
            NearbyPersonUIC.c cVar2 = nearbyPersonV1UIC.uSt;
            if (cVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            float f3 = cVar2.iUY;
            NearbyPersonUIC.c cVar3 = nearbyPersonV1UIC.uSt;
            if (cVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            nearbyPersonV1UIC.uRX = new com.tencent.mm.plugin.nearby.a.d(f2, f3, cVar3.accuracy, "", "");
            nearbyPersonV1UIC.getString(R.string.zb);
            nearbyPersonV1UIC.tipDialog = com.tencent.mm.ui.base.h.a((Context) nearbyPersonV1UIC.getActivity(), nearbyPersonV1UIC.getString(R.string.fag), true, (DialogInterface.OnCancelListener) new x(nearbyPersonV1UIC));
            com.tencent.mm.plugin.nearby.a.b.Ts(3);
            com.tencent.mm.kernel.g.azz().b(nearbyPersonV1UIC.uRX);
        }
        AppMethodBeat.o(249328);
    }
}
