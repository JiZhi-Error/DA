package com.tencent.mm.plugin.profile.ui.tab;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI;
import com.tencent.mm.plugin.profile.ui.tab.c;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileErrorFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabMsgFragment;
import com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileExtraOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver;
import com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0002}~B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010U\u001a\u00020V2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001c\u0010W\u001a\u00020V2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010Z\u001a\u00020VH\u0002J\b\u0010[\u001a\u00020VH\u0002J\b\u0010\\\u001a\u00020VH\u0002J\u0012\u0010]\u001a\u00020\u001b2\b\u0010^\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010_\u001a\u00020\u001b2\b\u0010`\u001a\u0004\u0018\u00010%2\b\u0010a\u001a\u0004\u0018\u00010%H\u0002J\b\u0010b\u001a\u00020VH\u0002J\b\u0010c\u001a\u00020VH\u0002J\b\u0010d\u001a\u00020VH\u0002J\b\u0010e\u001a\u00020VH\u0002J\b\u0010f\u001a\u00020VH\u0002J\b\u0010g\u001a\u00020VH\u0002J\b\u0010h\u001a\u00020VH\u0002J\"\u0010i\u001a\u00020V2\u0006\u0010j\u001a\u00020\r2\u0006\u0010k\u001a\u00020\r2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J,\u0010n\u001a\u00020\u001b2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0012\u0010o\u001a\u00020V2\b\u0010p\u001a\u0004\u0018\u00010MH\u0002J\b\u0010q\u001a\u00020\u001bH\u0016J\b\u0010r\u001a\u00020\u001bH\u0016J\b\u0010s\u001a\u00020\u001bH\u0016J\b\u0010t\u001a\u00020VH\u0002J\b\u0010u\u001a\u00020VH\u0002J\b\u0010v\u001a\u00020VH\u0002J\b\u0010w\u001a\u00020VH\u0002J\b\u0010x\u001a\u00020VH\u0002J\b\u0010y\u001a\u00020VH\u0002J\u0012\u0010z\u001a\u00020V2\b\u0010p\u001a\u0004\u0018\u00010MH\u0002J\u0012\u0010{\u001a\u00020V2\b\b\u0002\u0010|\u001a\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX.¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D09X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0002¢\u0006\f\n\u0004\bK\u00100\u001a\u0004\bI\u0010JR\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001fR\u000e\u0010S\u001a\u00020TX.¢\u0006\u0002\n\u0000¨\u0006"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidgetEx;", "Landroid/arch/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;", "brandIconUrl", "", "customizedInfo", "Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "enterTime", "", "(Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;J)V", "AT_SELECT_BIZ_CARD", "", "BIZ_REPORT_URL", "CRASH_FLAG", "MENU_ID_ADD_STAR", "MENU_ID_COMPLAIN", "MENU_ID_MORE", "MENU_ID_REMOVE_STAR", "MENU_ID_SEND", "MENU_ID_SETTING", "addContactScene", "addFriendSearchScene", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "blockAddContact", "", "getBrandIconUrl", "()Ljava/lang/String;", "setBrandIconUrl", "(Ljava/lang/String;)V", "brandInfoList", "", "Lcom/tencent/mm/api/BizInfo$BrandInfo;", "channelSessionId", "contact", "Lcom/tencent/mm/storage/Contact;", "contentView", "Landroid/view/View;", "getCustomizedInfo", "()Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;", "setCustomizedInfo", "(Lcom/tencent/mm/protocal/protobuf/CustomizedInfo;)V", "defaultTabSelectType", "getDefaultTabSelectType", "()I", "defaultTabSelectType$delegate", "Lkotlin/Lazy;", "getEnterTime", "()J", "setEnterTime", "(J)V", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/api/BizInfo$ExtInfo;", "followStatus", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "headerController", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController;", "isChecking", "isFirstTime", "menuDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "menuTabLayout", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "operationObservers", "Lcom/tencent/mm/plugin/profile/ui/tab/observer/IBizProfileOperateObserver;", "pagerAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "profileDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getProfileDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "profileDataFetcher$delegate", "profileInfo", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "readonly", "verifyPromptTitle", "verifyTicket", "getVerifyTicket", "setVerifyTicket", "viewPager", "Landroid/support/v4/view/ViewPager;", "checkCrash", "", "checkParamsLegal", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "dealBizExpose", "dealSendCardEvent", "doSearchHistory", "handleEvent", "key", "hasFollowStateChanged", "originContact", "currentContact", "hideOriginContentView", "initActionBar", "initBizInfo", "initProfile", "initView", "jumpToSettingUI", "loadProfile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBizProfileUpdate", "bizProfile", "onCreate", "onDestroy", "onDetach", "onPlaceTopChange", "reportEnd", "reportStart", "reportUpdate", "showMenuDialog", "updateBizTeenModeStatus", "updateFragments", "updateTabLayout", "needReport", "BizProfilePagerAdapter", "Companion", "app_release"})
public final class ContactWidgetTabBizInfo implements LifecycleObserver, com.tencent.mm.pluginsdk.b.b {
    public static final b Bmv = new b((byte) 0);
    public String BdC;
    private com.tencent.mm.api.c Bdk;
    private boolean Bdx;
    public aeq BeX;
    private int Bfb;
    private final String Bff;
    private final ContactInfoUI BiT;
    private ph BiU;
    private boolean BiX;
    private boolean BiZ = true;
    private final String Bjc = "crashFlag";
    private boolean Bjd;
    private List<IBizProfileOperateObserver> Bmi = new ArrayList();
    private c Bmj;
    private a Bmk;
    private BizProfileTabLayout Bml;
    private boolean Bmm = true;
    private final kotlin.f Bmn = kotlin.g.ah(new l(this));
    private final kotlin.f Bmo = kotlin.g.ah(new d(this));
    private com.tencent.mm.ui.widget.a.g Bmp;
    private final int Bmq;
    private final int Bmr;
    private final int Bms;
    private final int Bmt;
    private final int Bmu;
    private as contact;
    private View contentView;
    private String dhE;
    private List<? extends c.a> dhu;
    private c.b dhv;
    public long enterTime;
    private final List<BaseBizProfileFragment> fragments = new ArrayList();
    private int kgm;
    private String pHz = "";
    private final int tqu;
    private ViewPager uO;
    private final int uct;
    public String wZz;

    static {
        AppMethodBeat.i(230697);
        AppMethodBeat.o(230697);
    }

    private final BizProfileDataFetcher eFG() {
        AppMethodBeat.i(230685);
        BizProfileDataFetcher bizProfileDataFetcher = (BizProfileDataFetcher) this.Bmn.getValue();
        AppMethodBeat.o(230685);
        return bizProfileDataFetcher;
    }

    private final int eFH() {
        AppMethodBeat.i(230686);
        int intValue = ((Number) this.Bmo.getValue()).intValue();
        AppMethodBeat.o(230686);
        return intValue;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "position", "", "invoke"})
    static final class i extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(1);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(230679);
            int intValue = num.intValue();
            if (intValue < this.Bmw.fragments.size()) {
                ContactWidgetTabBizInfo.c(this.Bmw).setCurrentItem(intValue, false);
                com.tencent.mm.plugin.profile.ui.tab.data.b bVar = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
                com.tencent.mm.plugin.profile.ui.tab.data.b.b(this.Bmw.contact, intValue, this.Bmw.kgm);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230679);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
    static final class k<T> implements Observer<ph> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        k(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ph phVar) {
            AppMethodBeat.i(230681);
            ContactWidgetTabBizInfo.a(this.Bmw, phVar);
            ContactWidgetTabBizInfo.a(this.Bmw);
            AppMethodBeat.o(230681);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "serviceInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "position", "", FirebaseAnalytics.b.INDEX, "invoke"})
    public static final class n extends q implements kotlin.g.a.q<qa, Integer, Integer, x> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(3);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(qa qaVar, Integer num, Integer num2) {
            AppMethodBeat.i(230684);
            qa qaVar2 = qaVar;
            int intValue = num.intValue();
            num2.intValue();
            p.h(qaVar2, "serviceInfo");
            as asVar = this.Bmw.contact;
            if (asVar == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.getUsername(), 1100, this.Bmw.kgm, this.Bmw.enterTime);
            Log.i("MicroMsg.ContactWidgetTabBizInfo", "onClick serviceInfo.type:%d", Integer.valueOf(qaVar2.type));
            switch (qaVar2.type) {
                case 2:
                    ContactInfoUI contactInfoUI = this.Bmw.BiT;
                    as asVar2 = this.Bmw.contact;
                    if (asVar2 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b.g.a(qaVar2, contactInfoUI, asVar2.getUsername());
                    as asVar3 = this.Bmw.contact;
                    if (asVar3 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(asVar3.getUsername(), String.valueOf(qaVar2.id), qaVar2.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar2.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(intValue, -1), qaVar2.HWM);
                    break;
                case 5:
                    ContactInfoUI contactInfoUI2 = this.Bmw.BiT;
                    as asVar4 = this.Bmw.contact;
                    if (asVar4 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b.g.b(qaVar2, contactInfoUI2, asVar4.getUsername());
                    as asVar5 = this.Bmw.contact;
                    if (asVar5 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(asVar5.getUsername(), String.valueOf(qaVar2.id), qaVar2.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar2.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(intValue, -1), qaVar2.value);
                    break;
                case 6:
                    ContactInfoUI contactInfoUI3 = this.Bmw.BiT;
                    as asVar6 = this.Bmw.contact;
                    if (asVar6 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b.g.c(qaVar2, contactInfoUI3, asVar6.getUsername());
                    as asVar7 = this.Bmw.contact;
                    if (asVar7 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(asVar7.getUsername(), String.valueOf(qaVar2.id), qaVar2.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar2.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(intValue, -1), qaVar2.value);
                    break;
            }
            com.tencent.mm.ui.widget.a.g gVar = this.Bmw.Bmp;
            if (gVar != null) {
                gVar.bMo();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230684);
            return xVar;
        }
    }

    public ContactWidgetTabBizInfo(ContactInfoUI contactInfoUI, String str, aeq aeq, long j2) {
        p.h(contactInfoUI, "context");
        AppMethodBeat.i(230696);
        this.BiT = contactInfoUI;
        this.BdC = str;
        this.BeX = aeq;
        this.enterTime = j2;
        this.Bmi.add(new BizProfileExtraOperateObserver());
        this.Bmi.add(new BizProfileWidgetOperateObserver(this.BiT));
        this.tqu = 1;
        this.Bmq = 2;
        this.uct = 3;
        this.Bmr = 4;
        this.Bms = 5;
        this.Bmt = 6;
        this.Bmu = 1;
        this.Bff = "https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect";
        AppMethodBeat.o(230696);
    }

    public static final /* synthetic */ ViewPager c(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        AppMethodBeat.i(230700);
        ViewPager viewPager = contactWidgetTabBizInfo.uO;
        if (viewPager == null) {
            p.btv("viewPager");
        }
        AppMethodBeat.o(230700);
        return viewPager;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$Companion;", "", "()V", "TAB_SELECT_TYPE_MSG", "", "TAB_SELECT_TYPE_VIDEO", "TAG", "", "app_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01af, code lost:
        if (r0 == true) goto L_0x01b1;
     */
    @Override // com.tencent.mm.pluginsdk.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.ui.base.preference.f r12, com.tencent.mm.storage.as r13, boolean r14, int r15) {
        /*
        // Method dump skipped, instructions count: 979
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.a(com.tencent.mm.ui.base.preference.f, com.tencent.mm.storage.as, boolean, int):boolean");
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(230689);
        Log.i("MicroMsg.ContactWidgetTabBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != this.Bmu) {
            AppMethodBeat.o(230689);
        } else if (i3 != -1 || intent == null) {
            AppMethodBeat.o(230689);
        } else {
            String stringExtra = intent.getStringExtra("be_send_card_name");
            String stringExtra2 = intent.getStringExtra("received_card_name");
            boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("custom_send_text");
            o.a.eir().s(stringExtra, stringExtra2, booleanExtra);
            o.a.eir().iF(stringExtra3, stringExtra2);
            com.tencent.mm.ui.widget.snackbar.b.r(this.BiT, this.BiT.getString(R.string.dc_));
            AppMethodBeat.o(230689);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onExpand", "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initView$3$1"})
    static final class h implements c.a {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        h(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            this.Bmw = contactWidgetTabBizInfo;
        }

        @Override // com.tencent.mm.plugin.profile.ui.tab.c.a
        public final void eFF() {
            AppMethodBeat.i(230678);
            int currentItem = ContactWidgetTabBizInfo.c(this.Bmw).getCurrentItem();
            if (ContactWidgetTabBizInfo.c(this.Bmw).getCurrentItem() > this.Bmw.fragments.size() - 1) {
                AppMethodBeat.o(230678);
                return;
            }
            ArrayList<BaseBizProfileFragment> arrayList = new ArrayList();
            for (Object obj : this.Bmw.fragments) {
                if (!p.j((BaseBizProfileFragment) obj, (BaseBizProfileFragment) this.Bmw.fragments.get(currentItem))) {
                    arrayList.add(obj);
                }
            }
            for (BaseBizProfileFragment baseBizProfileFragment : arrayList) {
                baseBizProfileFragment.eFM();
            }
            AppMethodBeat.o(230678);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "Landroid/support/v4/app/FragmentStatePagerAdapter;", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Ljava/util/List;Landroid/support/v4/app/FragmentManager;)V", "getFragments", "()Ljava/util/List;", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "i", "app_release"})
    public static final class a extends android.support.v4.app.j {
        private final List<BaseBizProfileFragment> fragments;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(List<? extends BaseBizProfileFragment> list, android.support.v4.app.g gVar) {
            super(gVar);
            p.h(list, "fragments");
            p.h(gVar, "fm");
            AppMethodBeat.i(230668);
            this.fragments = list;
            AppMethodBeat.o(230668);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(230666);
            int size = this.fragments.size();
            AppMethodBeat.o(230666);
            return size;
        }

        @Override // android.support.v4.app.j
        public final Fragment getItem(int i2) {
            AppMethodBeat.i(230667);
            BaseBizProfileFragment baseBizProfileFragment = this.fragments.get(i2);
            AppMethodBeat.o(230667);
            return baseBizProfileFragment;
        }
    }

    private final void eEZ() {
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        String str7;
        String str8;
        boolean z = false;
        String str9 = null;
        AppMethodBeat.i(230691);
        as asVar = this.contact;
        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(asVar != null ? asVar.getUsername() : null);
        this.dhu = null;
        this.dhv = null;
        if (fJ == null) {
            AppMethodBeat.o(230691);
            return;
        }
        if (fJ.Uw() == null && this.BeX != null) {
            com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
            as asVar2 = this.contact;
            cVar.field_username = asVar2 != null ? asVar2.getUsername() : null;
            aeq aeq = this.BeX;
            if (aeq != null) {
                i3 = aeq.kem;
            } else {
                i3 = 0;
            }
            cVar.field_brandFlag = i3;
            aeq aeq2 = this.BeX;
            if (aeq2 != null) {
                str6 = aeq2.kep;
            } else {
                str6 = null;
            }
            cVar.field_brandIconURL = str6;
            aeq aeq3 = this.BeX;
            if (aeq3 != null) {
                str7 = aeq3.keo;
            } else {
                str7 = null;
            }
            cVar.field_brandInfo = str7;
            aeq aeq4 = this.BeX;
            if (aeq4 != null) {
                str8 = aeq4.ken;
            } else {
                str8 = null;
            }
            cVar.field_extInfo = str8;
            c.b Uw = cVar.Uw();
            p.g(Uw, "bi.extInfo");
            cVar.field_type = Uw.getServiceType();
            fJ = cVar;
        }
        if (fJ.field_brandInfo == null && fJ.field_extInfo == null && this.BeX != null) {
            as asVar3 = this.contact;
            if (asVar3 != null) {
                str2 = asVar3.getUsername();
            } else {
                str2 = null;
            }
            fJ.field_username = str2;
            aeq aeq5 = this.BeX;
            if (aeq5 != null) {
                i2 = aeq5.kem;
            } else {
                i2 = 0;
            }
            fJ.field_brandFlag = i2;
            aeq aeq6 = this.BeX;
            if (aeq6 != null) {
                str3 = aeq6.kep;
            } else {
                str3 = null;
            }
            fJ.field_brandIconURL = str3;
            aeq aeq7 = this.BeX;
            if (aeq7 != null) {
                str4 = aeq7.keo;
            } else {
                str4 = null;
            }
            fJ.field_brandInfo = str4;
            aeq aeq8 = this.BeX;
            if (aeq8 != null) {
                str5 = aeq8.ken;
            } else {
                str5 = null;
            }
            fJ.field_extInfo = str5;
            c.b Uw2 = fJ.Uw();
            p.g(Uw2, "bi.extInfo");
            fJ.field_type = Uw2.getServiceType();
        }
        this.Bdk = fJ;
        this.dhu = fJ.UO();
        this.dhv = fJ.Uw();
        c.b bVar = this.dhv;
        if (bVar != null) {
            str = bVar.US();
        } else {
            str = null;
        }
        if (str != null) {
            c.b bVar2 = this.dhv;
            String US = bVar2 != null ? bVar2.US() : null;
            if (US == null || US.length() == 0) {
                z = true;
            }
            if (z) {
                c.b bVar3 = this.dhv;
                if (bVar3 != null) {
                    str9 = bVar3.US();
                }
                this.dhE = str9;
            }
        }
        AppMethodBeat.o(230691);
    }

    private final void eEp() {
        AppMethodBeat.i(230692);
        cCs();
        if (this.contact == null) {
            AppMethodBeat.o(230692);
            return;
        }
        eEZ();
        AppMethodBeat.o(230692);
    }

    private final synchronized void d(ph phVar) {
        ov ovVar;
        LinkedList<ou> linkedList;
        ov ovVar2;
        LinkedList<ou> linkedList2;
        AppMethodBeat.i(230693);
        int size = this.fragments.size();
        ArrayList arrayList = new ArrayList();
        for (T t : this.fragments) {
            if (t instanceof BizProfileTabMsgFragment) {
                arrayList.add(t);
            }
        }
        BizProfileTabMsgFragment bizProfileTabMsgFragment = (BizProfileTabMsgFragment) kotlin.a.j.kt(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : this.fragments) {
            if (t2 instanceof BizProfileTabVideoFragment) {
                arrayList2.add(t2);
            }
        }
        BizProfileTabVideoFragment bizProfileTabVideoFragment = (BizProfileTabVideoFragment) kotlin.a.j.kt(arrayList2);
        if (!(phVar == null || (ovVar2 = phVar.KWg) == null)) {
            if (bizProfileTabMsgFragment == null && (linkedList2 = ovVar2.KVw) != null) {
                if (!linkedList2.isEmpty()) {
                    BizProfileTabMsgFragment bizProfileTabMsgFragment2 = new BizProfileTabMsgFragment();
                    ph phVar2 = this.BiU;
                    if (phVar2 == null) {
                        phVar2 = new ph();
                    }
                    bizProfileTabMsgFragment2.f(phVar2);
                    Bundle bundle = new Bundle();
                    as asVar = this.contact;
                    if (asVar == null) {
                        p.hyc();
                    }
                    String username = asVar.getUsername();
                    p.g(username, "contact!!.username");
                    com.tencent.mm.plugin.handoff.c.b.a(bundle, "contact", username);
                    bizProfileTabMsgFragment2.setArguments(bundle);
                    bizProfileTabMsgFragment2.e(eFG());
                    this.fragments.add(0, bizProfileTabMsgFragment2);
                }
            }
            LinkedList<ou> linkedList3 = ovVar2.KVw;
            if (linkedList3 != null) {
                LinkedList<ou> linkedList4 = linkedList3;
                if ((linkedList4 == null || linkedList4.isEmpty()) && bizProfileTabMsgFragment != null) {
                    List<BaseBizProfileFragment> list = this.fragments;
                    if (bizProfileTabMsgFragment == null) {
                        p.hyc();
                    }
                    list.remove(bizProfileTabMsgFragment);
                }
            }
        }
        if (!(phVar == null || (ovVar = phVar.KWi) == null)) {
            if (bizProfileTabVideoFragment == null && (linkedList = ovVar.KVw) != null) {
                if (!linkedList.isEmpty()) {
                    bizProfileTabVideoFragment = new BizProfileTabVideoFragment();
                    ph phVar3 = this.BiU;
                    if (phVar3 == null) {
                        phVar3 = new ph();
                    }
                    bizProfileTabVideoFragment.f(phVar3);
                    Bundle bundle2 = new Bundle();
                    as asVar2 = this.contact;
                    if (asVar2 == null) {
                        p.hyc();
                    }
                    String username2 = asVar2.getUsername();
                    p.g(username2, "contact!!.username");
                    com.tencent.mm.plugin.handoff.c.b.a(bundle2, "contact", username2);
                    bizProfileTabVideoFragment.setArguments(bundle2);
                    bizProfileTabVideoFragment.e(eFG());
                    this.fragments.add(bizProfileTabVideoFragment);
                }
            }
            LinkedList<ou> linkedList5 = ovVar.KVw;
            if (linkedList5 != null) {
                LinkedList<ou> linkedList6 = linkedList5;
                if ((linkedList6 == null || linkedList6.isEmpty()) && bizProfileTabVideoFragment != null) {
                    List<BaseBizProfileFragment> list2 = this.fragments;
                    if (bizProfileTabVideoFragment == null) {
                        p.hyc();
                    }
                    list2.remove(bizProfileTabVideoFragment);
                }
            }
        }
        if (size != this.fragments.size()) {
            a aVar = this.Bmk;
            if (aVar == null) {
                p.btv("pagerAdapter");
            }
            aVar.notifyDataSetChanged();
        }
        if (bizProfileTabVideoFragment != null && eFH() == 1) {
            List<BaseBizProfileFragment> list3 = this.fragments;
            if (bizProfileTabVideoFragment == null) {
                p.hyc();
            }
            int indexOf = list3.indexOf(bizProfileTabVideoFragment);
            if (indexOf >= 0) {
                ViewPager viewPager = this.uO;
                if (viewPager == null) {
                    p.btv("viewPager");
                }
                viewPager.setCurrentItem(indexOf, false);
            }
        }
        AppMethodBeat.o(230693);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sO(boolean r10) {
        /*
        // Method dump skipped, instructions count: 344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.sO(boolean):void");
    }

    private final synchronized void ab(as asVar) {
        AppMethodBeat.i(230695);
        if (asVar == null || this.Bjd) {
            AppMethodBeat.o(230695);
        } else {
            this.Bjd = true;
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
            if (singleMMKV.decodeBool(this.Bjc, false)) {
                Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash clear data with crash flag");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1378, 0, 1, false);
                String username = asVar.getUsername();
                p.g(username, "contact.username");
                com.tencent.mm.plugin.profile.ui.newbizinfo.a.clear(username);
            }
            singleMMKV.encode(this.Bjc, true);
            Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash add crash flag");
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) && singleMMKV.decodeInt("testCrash", 0) == 1) {
                Assert.assertTrue("checkCrash testCrash", false);
            }
            com.tencent.f.h.RTc.o(new c(this, singleMMKV), 1000);
            AppMethodBeat.o(230695);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;
        final /* synthetic */ MultiProcessMMKV gUu;

        c(ContactWidgetTabBizInfo contactWidgetTabBizInfo, MultiProcessMMKV multiProcessMMKV) {
            this.Bmw = contactWidgetTabBizInfo;
            this.gUu = multiProcessMMKV;
        }

        public final void run() {
            AppMethodBeat.i(230669);
            Log.i("MicroMsg.ContactWidgetTabBizInfo", "checkCrash clear crash flag");
            this.gUu.encode(this.Bmw.Bjc, false);
            this.Bmw.Bjd = false;
            AppMethodBeat.o(230669);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        e(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            this.Bmw = contactWidgetTabBizInfo;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(230671);
            this.Bmw.BiT.onBackPressed();
            AppMethodBeat.o(230671);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        f(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            this.Bmw = contactWidgetTabBizInfo;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(230672);
            ContactWidgetTabBizInfo.k(this.Bmw);
            AppMethodBeat.o(230672);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        g(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            this.Bmw = contactWidgetTabBizInfo;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            String str;
            AppMethodBeat.i(230677);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.Bmw.BiT, 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.g.AnonymousClass1 */
                final /* synthetic */ g Bmx;

                {
                    this.Bmx = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    Integer num;
                    String str;
                    String str2 = null;
                    AppMethodBeat.i(230675);
                    as asVar = this.Bmx.Bmw.contact;
                    if (asVar == null || !asVar.arv()) {
                        as asVar2 = this.Bmx.Bmw.contact;
                        if (asVar2 != null) {
                            num = Integer.valueOf(asVar2.arH());
                        } else {
                            num = null;
                        }
                        if (num == null) {
                            p.hyc();
                        }
                        if (num.intValue() <= 0) {
                            ay.b aVo = ay.a.aVo();
                            as asVar3 = this.Bmx.Bmw.contact;
                            if (asVar3 != null) {
                                str = asVar3.getUsername();
                            } else {
                                str = null;
                            }
                            aVo.a(str, "", AnonymousClass1.Bmy);
                        }
                    } else {
                        as asVar4 = this.Bmx.Bmw.contact;
                        if (asVar4 == null || !asVar4.arE()) {
                            if (ab.clc()) {
                                as asVar5 = this.Bmx.Bmw.contact;
                                if (asVar5 != null) {
                                    str2 = asVar5.getUsername();
                                }
                                if (com.tencent.mm.al.g.Nd(str2)) {
                                    mVar.kV(this.Bmx.Bmw.Bmr, R.string.b_h);
                                }
                            }
                            mVar.kV(this.Bmx.Bmw.Bmr, R.string.bh2);
                        } else {
                            if (ab.clc()) {
                                as asVar6 = this.Bmx.Bmw.contact;
                                if (asVar6 != null) {
                                    str2 = asVar6.getUsername();
                                }
                                if (com.tencent.mm.al.g.Nd(str2)) {
                                    mVar.kV(this.Bmx.Bmw.Bms, R.string.b_l);
                                }
                            }
                            mVar.kV(this.Bmx.Bmw.Bms, R.string.euv);
                        }
                    }
                    mVar.kV(this.Bmx.Bmw.Bmq, R.string.bf6);
                    mVar.kV(this.Bmx.Bmw.Bmt, R.string.ay8);
                    as asVar7 = this.Bmx.Bmw.contact;
                    if (asVar7 != null) {
                        if (asVar7.arv()) {
                            mVar.kV(this.Bmx.Bmw.uct, R.string.b_w);
                        }
                        AppMethodBeat.o(230675);
                        return;
                    }
                    AppMethodBeat.o(230675);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.g.AnonymousClass2 */
                final /* synthetic */ g Bmx;

                {
                    this.Bmx = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
                    if (com.tencent.mm.al.g.Nb(r1) != false) goto L_0x0098;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x0119, code lost:
                    if (com.tencent.mm.al.g.Nb(r1) != false) goto L_0x011b;
                 */
                @Override // com.tencent.mm.ui.base.o.g
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onMMMenuItemSelected(android.view.MenuItem r8, int r9) {
                    /*
                    // Method dump skipped, instructions count: 356
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.g.AnonymousClass2.onMMMenuItemSelected(android.view.MenuItem, int):void");
                }
            });
            eVar.dGm();
            as asVar = this.Bmw.contact;
            if (asVar != null) {
                str = asVar.getUsername();
            } else {
                str = null;
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(str, 600, this.Bmw.kgm, this.Bmw.enterTime);
            AppMethodBeat.o(230677);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "invoke"})
    static final class l extends q implements kotlin.g.a.a<BizProfileDataFetcher> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(0);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ BizProfileDataFetcher invoke() {
            String username;
            AppMethodBeat.i(230682);
            int i2 = this.Bmw.kgm;
            as asVar = this.Bmw.contact;
            BizProfileDataFetcher bizProfileDataFetcher = new BizProfileDataFetcher(i2, (asVar == null || (username = asVar.getUsername()) == null) ? "" : username, this.Bmw.BiT);
            AppMethodBeat.o(230682);
            return bizProfileDataFetcher;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(0);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2 = 0;
            AppMethodBeat.i(230670);
            int intExtra = this.Bmw.BiT.getIntent().getIntExtra("biz_profile_tab_type", 0);
            if (intExtra <= 1) {
                i2 = intExtra;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(230670);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(0);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230680);
            ContactWidgetTabBizInfo.f(this.Bmw);
            com.tencent.mm.plugin.profile.ui.tab.data.b bVar = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
            com.tencent.mm.plugin.profile.ui.tab.data.b.b(this.Bmw.contact, 2, this.Bmw.kgm);
            x xVar = x.SXb;
            AppMethodBeat.o(230680);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ContactWidgetTabBizInfo Bmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
            super(0);
            this.Bmw = contactWidgetTabBizInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230683);
            com.tencent.mm.ui.widget.a.g gVar = this.Bmw.Bmp;
            if (gVar != null) {
                gVar.bMo();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230683);
            return xVar;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.b
    public final boolean onCreate() {
        AppMethodBeat.i(230687);
        if (this.contact == null || this.Bdk == null) {
            Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportStart fail, err");
        } else {
            as asVar = this.contact;
            if (asVar == null) {
                p.hyc();
            }
            String username = asVar.getUsername();
            int i2 = this.kgm;
            com.tencent.mm.api.c cVar = this.Bdk;
            if (cVar == null) {
                p.hyc();
            }
            int i3 = cVar.field_type;
            long j2 = this.enterTime;
            as asVar2 = this.contact;
            if (asVar2 == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(username, i2, i3, j2, asVar2.arv() ? 1 : 0, this.pHz);
        }
        AppMethodBeat.o(230687);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b  */
    @Override // com.tencent.mm.pluginsdk.b.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean axa() {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.axa():boolean");
    }

    public static final /* synthetic */ void a(ContactWidgetTabBizInfo contactWidgetTabBizInfo, ph phVar) {
        String str;
        boolean z;
        AppMethodBeat.i(230698);
        contactWidgetTabBizInfo.BiU = phVar;
        contactWidgetTabBizInfo.eEp();
        c cVar = contactWidgetTabBizInfo.Bmj;
        if (cVar != null) {
            cVar.a(contactWidgetTabBizInfo.BiU, contactWidgetTabBizInfo.Bdk, contactWidgetTabBizInfo.wZz);
        }
        if (phVar != null) {
            str = a.a(4, phVar);
        } else {
            str = null;
        }
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ViewPager viewPager = contactWidgetTabBizInfo.uO;
                if (viewPager == null) {
                    p.btv("viewPager");
                }
                viewPager.setVisibility(0);
                BizProfileTabLayout bizProfileTabLayout = contactWidgetTabBizInfo.Bml;
                if (bizProfileTabLayout == null) {
                    p.btv("menuTabLayout");
                }
                bizProfileTabLayout.setVisibility(8);
                BizProfileTabLayout bizProfileTabLayout2 = contactWidgetTabBizInfo.Bml;
                if (bizProfileTabLayout2 == null) {
                    p.btv("menuTabLayout");
                }
                bizProfileTabLayout2.eFP();
                BizProfileErrorFragment bizProfileErrorFragment = new BizProfileErrorFragment();
                p.h(str, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                bizProfileErrorFragment.errorMsg = str;
                contactWidgetTabBizInfo.fragments.clear();
                contactWidgetTabBizInfo.fragments.add(bizProfileErrorFragment);
                a aVar = contactWidgetTabBizInfo.Bmk;
                if (aVar == null) {
                    p.btv("pagerAdapter");
                }
                aVar.notifyDataSetChanged();
                AppMethodBeat.o(230698);
                return;
            }
        }
        contactWidgetTabBizInfo.d(phVar);
        contactWidgetTabBizInfo.sO(true);
        AppMethodBeat.o(230698);
    }

    public static final /* synthetic */ void a(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        AppMethodBeat.i(230699);
        if (!(contactWidgetTabBizInfo.contact == null || contactWidgetTabBizInfo.Bdk == null || contactWidgetTabBizInfo.BiU == null)) {
            ph phVar = contactWidgetTabBizInfo.BiU;
            if (phVar == null) {
                p.hyc();
            }
            if (phVar.KWf != null) {
                ph phVar2 = contactWidgetTabBizInfo.BiU;
                if (phVar2 == null) {
                    p.hyc();
                }
                if (phVar2.KWe != null) {
                    as asVar = contactWidgetTabBizInfo.contact;
                    if (asVar == null) {
                        p.hyc();
                    }
                    String username = asVar.getUsername();
                    int i2 = contactWidgetTabBizInfo.kgm;
                    com.tencent.mm.api.c cVar = contactWidgetTabBizInfo.Bdk;
                    if (cVar == null) {
                        p.hyc();
                    }
                    int i3 = cVar.field_type;
                    long j2 = contactWidgetTabBizInfo.enterTime;
                    as asVar2 = contactWidgetTabBizInfo.contact;
                    if (asVar2 == null) {
                        p.hyc();
                    }
                    int i4 = asVar2.arv() ? 1 : 0;
                    ph phVar3 = contactWidgetTabBizInfo.BiU;
                    if (phVar3 == null) {
                        p.hyc();
                    }
                    np npVar = phVar3.KWf;
                    int i5 = npVar != null ? npVar.KSY : 0;
                    ph phVar4 = contactWidgetTabBizInfo.BiU;
                    if (phVar4 == null) {
                        p.hyc();
                    }
                    np npVar2 = phVar4.KWf;
                    int i6 = npVar2 != null ? npVar2.KSZ : 0;
                    ph phVar5 = contactWidgetTabBizInfo.BiU;
                    if (phVar5 == null) {
                        p.hyc();
                    }
                    String c2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(phVar5.KWg);
                    ph phVar6 = contactWidgetTabBizInfo.BiU;
                    if (phVar6 == null) {
                        p.hyc();
                    }
                    String a2 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(phVar6.KWj);
                    ph phVar7 = contactWidgetTabBizInfo.BiU;
                    if (phVar7 == null) {
                        p.hyc();
                    }
                    mq mqVar = phVar7.KWe;
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(username, i2, i3, j2, i4, i5, i6, 0, c2, a2, mqVar != null ? mqVar.UserName : null);
                    if (contactWidgetTabBizInfo.BiU != null) {
                        ph phVar8 = contactWidgetTabBizInfo.BiU;
                        if (phVar8 == null) {
                            p.hyc();
                        }
                        if (phVar8.KWj != null) {
                            as asVar3 = contactWidgetTabBizInfo.contact;
                            if (asVar3 == null) {
                                p.hyc();
                            }
                            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar3.getUsername(), 104, contactWidgetTabBizInfo.kgm, contactWidgetTabBizInfo.enterTime);
                        }
                    }
                    if (contactWidgetTabBizInfo.BiU != null) {
                        as asVar4 = contactWidgetTabBizInfo.contact;
                        if (asVar4 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar4.getUsername(), 101, contactWidgetTabBizInfo.kgm, contactWidgetTabBizInfo.enterTime);
                    }
                    AppMethodBeat.o(230699);
                    return;
                }
            }
        }
        Log.w("MicroMsg.ContactWidgetTabBizInfo", "reportUpdate fail, err");
        AppMethodBeat.o(230699);
    }

    public static final /* synthetic */ void f(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        String str;
        py pyVar;
        pz pzVar;
        LinkedList<qa> linkedList;
        boolean z;
        AppMethodBeat.i(230701);
        ph phVar = contactWidgetTabBizInfo.BiU;
        if (!(phVar == null || (pyVar = phVar.KWj) == null || (pzVar = pyVar.KWP) == null || (linkedList = pzVar.KWS) == null)) {
            LinkedList<qa> linkedList2 = linkedList;
            if (linkedList2 == null || linkedList2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(230701);
                return;
            }
        }
        com.tencent.mm.ui.widget.a.g gVar = contactWidgetTabBizInfo.Bmp;
        if (gVar == null || !gVar.isShowing()) {
            ph phVar2 = contactWidgetTabBizInfo.BiU;
            if (phVar2 == null) {
                p.hyc();
            }
            pz pzVar2 = phVar2.KWj.KWP;
            p.g(pzVar2, "profileInfo!!.ServiceInfo.MenuInfo");
            List<qa> a2 = com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(pzVar2);
            contactWidgetTabBizInfo.Bmp = new com.tencent.mm.ui.widget.a.g(contactWidgetTabBizInfo.BiT, 0, 0);
            View inflate = LayoutInflater.from(contactWidgetTabBizInfo.BiT).inflate(R.layout.wh, (ViewGroup) null, false);
            as asVar = contactWidgetTabBizInfo.contact;
            if (!(asVar == null || asVar.getNickname() == null)) {
                TextView textView = (TextView) inflate.findViewById(R.id.a6a);
                p.g(textView, "titleView");
                String string = contactWidgetTabBizInfo.BiT.getResources().getString(R.string.ahm);
                Object[] objArr = new Object[1];
                as asVar2 = contactWidgetTabBizInfo.contact;
                if (asVar2 == null || (str = asVar2.getNickname()) == null) {
                    str = contactWidgetTabBizInfo.BiT.getResources().getString(R.string.bfw);
                }
                objArr[0] = str;
                textView.setText(Util.safeFormatString(string, objArr));
            }
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.a64);
            com.tencent.mm.plugin.profile.ui.tab.a.a aVar = new com.tencent.mm.plugin.profile.ui.tab.a.a(a2);
            aVar.BnH = new m(contactWidgetTabBizInfo);
            aVar.BnG = new n(contactWidgetTabBizInfo);
            p.g(recyclerView, "menuRecyclerView");
            recyclerView.setAdapter(aVar);
            recyclerView.setLayoutManager(new LinearLayoutManager());
            com.tencent.mm.ui.widget.a.g gVar2 = contactWidgetTabBizInfo.Bmp;
            if (gVar2 != null) {
                gVar2.setCustomView(inflate);
            }
            p.g(inflate, "menuDialogContentView");
            ViewParent parent = inflate.getParent();
            if (!(parent instanceof View)) {
                parent = null;
            }
            View view = (View) parent;
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
            }
            com.tencent.mm.ui.widget.a.g gVar3 = contactWidgetTabBizInfo.Bmp;
            if (gVar3 != null) {
                gVar3.dGm();
                AppMethodBeat.o(230701);
                return;
            }
            AppMethodBeat.o(230701);
            return;
        }
        AppMethodBeat.o(230701);
    }

    public static final /* synthetic */ void k(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        String str;
        String str2 = null;
        AppMethodBeat.i(230702);
        as asVar = contactWidgetTabBizInfo.contact;
        String username = asVar != null ? asVar.getUsername() : null;
        Intent fXX = ai.fXX();
        fXX.putExtra("ftsneedkeyboard", true);
        fXX.putExtra("ftsbizscene", 19);
        fXX.putExtra("ftsType", 2);
        Map<String, String> h2 = ai.h(19, false, 2);
        p.g(h2, NativeProtocol.WEB_DIALOG_PARAMS);
        h2.put("userName", username);
        ph phVar = contactWidgetTabBizInfo.BiU;
        if (phVar != null) {
            str = phVar.KWn;
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            ph phVar2 = contactWidgetTabBizInfo.BiU;
            if (phVar2 != null) {
                str2 = phVar2.KWn;
            }
            h2.put("thirdExtParam", str2);
        }
        fXX.putExtra("rawUrl", ai.bd(h2));
        fXX.putExtra("key_load_js_without_delay", true);
        fXX.putExtra("ftsbizusername", username);
        fXX.putExtra(e.p.OzF, 13307);
        fXX.putStringArrayListExtra(e.p.OzG, com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.fd(username, contactWidgetTabBizInfo.kgm));
        fXX.addFlags(67108864);
        com.tencent.mm.br.c.b(contactWidgetTabBizInfo.BiT, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(username, 1301, contactWidgetTabBizInfo.enterTime);
        AppMethodBeat.o(230702);
    }

    public static final /* synthetic */ void q(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        String str;
        String str2 = null;
        AppMethodBeat.i(230703);
        Intent intent = new Intent();
        as asVar = contactWidgetTabBizInfo.contact;
        intent.putExtra("Select_Talker_Name", asVar != null ? asVar.getUsername() : null);
        as asVar2 = contactWidgetTabBizInfo.contact;
        if (asVar2 != null) {
            str = asVar2.getUsername();
        } else {
            str = null;
        }
        intent.putExtra("Select_block_List", str);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.jRt.a(intent, contactWidgetTabBizInfo.Bmu, contactWidgetTabBizInfo.BiT);
        as asVar3 = contactWidgetTabBizInfo.contact;
        if (asVar3 != null) {
            str2 = asVar3.getUsername();
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(str2, 800, contactWidgetTabBizInfo.kgm, contactWidgetTabBizInfo.enterTime);
        AppMethodBeat.o(230703);
    }

    public static final /* synthetic */ void r(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        AppMethodBeat.i(230704);
        Intent intent = new Intent();
        intent.setClass(contactWidgetTabBizInfo.BiT, NewBizInfoSettingUI.class);
        as asVar = contactWidgetTabBizInfo.contact;
        intent.putExtra("Contact_User", asVar != null ? asVar.getUsername() : null);
        intent.putExtra("key_start_biz_profile_setting_from_scene", 2);
        intent.putExtra("key_profile_enter_timestamp", contactWidgetTabBizInfo.enterTime);
        if (contactWidgetTabBizInfo.BiT.getIntent() != null) {
            intent.putExtras(contactWidgetTabBizInfo.BiT.getIntent());
        }
        ContactInfoUI contactInfoUI = contactWidgetTabBizInfo.BiT;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        contactInfoUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(230704);
    }

    public static final /* synthetic */ void s(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        AppMethodBeat.i(230705);
        ao aoVar = new ao();
        ao.a aVar = aoVar.dDs;
        as asVar = contactWidgetTabBizInfo.contact;
        aVar.userName = asVar != null ? asVar.getUsername() : null;
        EventCenter.instance.publish(aoVar);
        AppMethodBeat.o(230705);
    }

    public static final /* synthetic */ void t(ContactWidgetTabBizInfo contactWidgetTabBizInfo) {
        String str;
        String str2 = null;
        AppMethodBeat.i(230706);
        if (contactWidgetTabBizInfo.contact != null) {
            as asVar = contactWidgetTabBizInfo.contact;
            if (asVar != null) {
                str = asVar.getUsername();
            } else {
                str = null;
            }
            if (!Util.isNullOrNil(str)) {
                as asVar2 = contactWidgetTabBizInfo.contact;
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar2 != null ? asVar2.getUsername() : null, 601, contactWidgetTabBizInfo.kgm, contactWidgetTabBizInfo.enterTime);
                Intent intent = new Intent();
                ae aeVar = ae.SYK;
                String str3 = contactWidgetTabBizInfo.Bff;
                Object[] objArr = new Object[1];
                as asVar3 = contactWidgetTabBizInfo.contact;
                if (asVar3 != null) {
                    str2 = asVar3.getUsername();
                }
                objArr[0] = str2;
                String format = String.format(str3, Arrays.copyOf(objArr, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                intent.putExtra("rawUrl", format);
                intent.putExtra("key_menu_hide_expose", true);
                com.tencent.mm.br.c.b(contactWidgetTabBizInfo.BiT, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(230706);
                return;
            }
        }
        AppMethodBeat.o(230706);
    }
}
