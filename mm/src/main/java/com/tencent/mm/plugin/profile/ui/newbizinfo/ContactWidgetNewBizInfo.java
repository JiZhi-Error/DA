package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

public class ContactWidgetNewBizInfo implements LifecycleObserver, i, com.tencent.mm.pluginsdk.b.b {
    private static final String Bff = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?username=%s&from=1#wechat_redirect");
    private static String Bjc = "crashFlag";
    private static boolean Bjd = false;
    private String BdC;
    c Bdk;
    boolean Bdx;
    private List<WxaAttributes.WxaEntryInfo> BeW;
    private aeq BeX;
    private int Bfb;
    private Bundle Bfg;
    SnsAdClick Bfh;
    private String Bfi;
    ContactInfoUI BiT;
    private ph BiU;
    private com.tencent.mm.plugin.profile.ui.newbizinfo.b.c BiV;
    private boolean BiW;
    private boolean BiX;
    private int BiY;
    private boolean BiZ;
    private boolean Bja;
    private Parcelable Bjb;
    as contact;
    private String dhE;
    private List<c.a> dhu;
    private c.b dhv;
    private long endTime;
    long enterTime;
    private boolean isLoading;
    int kgm;
    private IListener lEl;
    private String pHz;
    private WeakReference<ContactWidgetNewBizInfo> peA;
    private IListener pti;
    private f screen;
    private q tipDialog;
    private String wZz;

    static /* synthetic */ void a(ContactWidgetNewBizInfo contactWidgetNewBizInfo, int i2) {
        AppMethodBeat.i(161416);
        contactWidgetNewBizInfo.US(i2);
        AppMethodBeat.o(161416);
    }

    static /* synthetic */ void a(ContactWidgetNewBizInfo contactWidgetNewBizInfo, ph phVar) {
        AppMethodBeat.i(169759);
        contactWidgetNewBizInfo.a(phVar);
        AppMethodBeat.o(169759);
    }

    static /* synthetic */ void m(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(27474);
        contactWidgetNewBizInfo.initActionBar();
        AppMethodBeat.o(27474);
    }

    static /* synthetic */ void n(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(161418);
        contactWidgetNewBizInfo.eEp();
        AppMethodBeat.o(161418);
    }

    static /* synthetic */ void q(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(161421);
        contactWidgetNewBizInfo.eEr();
        AppMethodBeat.o(161421);
    }

    static class b extends IListener<mx> {
        private WeakReference<ContactWidgetNewBizInfo> Bjm;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(231951);
            mx mxVar2 = mxVar;
            switch (mxVar2.dSE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    ContactWidgetNewBizInfo contactWidgetNewBizInfo = this.Bjm != null ? this.Bjm.get() : null;
                    if (!(contactWidgetNewBizInfo == null || contactWidgetNewBizInfo.BiV == null)) {
                        com.tencent.mm.plugin.profile.ui.newbizinfo.b.c cVar = contactWidgetNewBizInfo.BiV;
                        p.h(mxVar2, "event");
                        String str = mxVar2.dSE.dSF;
                        if (str == null) {
                            str = "none";
                        }
                        cVar.Bkv = str;
                        cVar.BkC.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.o(231951);
            return false;
        }

        public b(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
            AppMethodBeat.i(231950);
            this.Bjm = new WeakReference<>(contactWidgetNewBizInfo);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(231950);
        }
    }

    static class a extends IListener<w> {
        private WeakReference<ContactWidgetNewBizInfo> Bjm;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(w wVar) {
            AppMethodBeat.i(231949);
            Log.i("MicroMsg.ContactWidgetNewBizInfo", "AppMsgRelatedInfoUpdateEvent scene %d", Integer.valueOf(wVar.dCO.scene));
            if (this.Bjm == null || this.Bjm.get() == null) {
                AppMethodBeat.o(231949);
            } else {
                ContactInfoUI contactInfoUI = this.Bjm.get().BiT;
                if (!(contactInfoUI == null || contactInfoUI.isFinishing() || contactInfoUI.getListView() == null || contactInfoUI.getListView().getAdapter() == null)) {
                    ((BaseAdapter) contactInfoUI.getListView().getAdapter()).notifyDataSetChanged();
                }
                AppMethodBeat.o(231949);
            }
            return false;
        }

        public a(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
            AppMethodBeat.i(231948);
            this.Bjm = new WeakReference<>(contactWidgetNewBizInfo);
            this.__eventId = w.class.getName().hashCode();
            AppMethodBeat.o(231948);
        }
    }

    public ContactWidgetNewBizInfo(final ContactInfoUI contactInfoUI, String str, aeq aeq, long j2) {
        AppMethodBeat.i(231952);
        this.Bfb = 0;
        this.Bfh = null;
        this.Bfi = null;
        this.BiV = null;
        this.peA = null;
        this.pHz = "";
        this.BiW = false;
        this.BiX = false;
        this.lEl = new b(this);
        this.pti = new a(this);
        this.BiY = 0;
        this.BiZ = true;
        this.isLoading = false;
        this.Bja = false;
        this.tipDialog = null;
        this.peA = new WeakReference<>(this);
        this.BiT = contactInfoUI;
        this.BdC = str;
        this.BeX = aeq;
        this.enterTime = j2;
        final ListView listView = contactInfoUI.getListView();
        eEY();
        final int statusBarHeight = au.getStatusBarHeight(contactInfoUI);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(231935);
                if (i2 == 0 && ContactWidgetNewBizInfo.this.BiV != null) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c cVar = ContactWidgetNewBizInfo.this.BiV;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    int lastVisiblePosition = listView.getLastVisiblePosition();
                    if (cVar.eFj().CR(16)) {
                        int eFi = cVar.eFi() - cVar.Bkw;
                        ArrayList arrayList = new ArrayList();
                        if (firstVisiblePosition <= lastVisiblePosition) {
                            while (true) {
                                if (cVar.UY(firstVisiblePosition)) {
                                    int i3 = firstVisiblePosition + eFi;
                                    if (cVar.Bku.UU(i3) == a.b.Message) {
                                        Object item = cVar.Bku.getItem(i3);
                                        if (item == null) {
                                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                                            AppMethodBeat.o(231935);
                                            throw tVar;
                                        }
                                        ou ouVar = (ou) item;
                                        as asVar = cVar.BkB.contact;
                                        p.g(asVar, "widget.contact");
                                        String str = asVar.field_username;
                                        long j2 = cVar.BkB.enterTime;
                                        int i4 = cVar.BkB.kgm;
                                        int i5 = i3 / 2;
                                        if (ouVar.KVq.xKb == 49) {
                                            LinkedList<nh> linkedList = ouVar.KVv.KSK;
                                            p.g(linkedList, "bizMessage.AppMsg.DetailInfo");
                                            LinkedList<nh> linkedList2 = linkedList;
                                            ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
                                            for (T t : linkedList2) {
                                                arrayList2.add(j.listOf((Object[]) new String[]{t.KSj, String.valueOf(t.iAb)}));
                                            }
                                            arrayList.addAll(arrayList2);
                                            LinkedList<nh> linkedList3 = ouVar.KVv.KSK;
                                            p.g(linkedList3, "bizMessage.AppMsg.DetailInfo");
                                            for (T t2 : linkedList3) {
                                                d dVar = d.BlR;
                                                p.g(str, "userName");
                                                d.a(str, j2, ouVar.KVv.KSJ.KSf, t2.KSi, t2.iAb, i5, ouVar.KVv.KSJ.CreateTime, i4);
                                            }
                                        } else {
                                            d dVar2 = d.BlR;
                                            p.g(str, "userName");
                                            d.a(str, j2, ouVar.KVq.Brl, 0, -1, i5, ouVar.KVq.LmE, i4);
                                        }
                                    }
                                }
                                if (firstVisiblePosition == lastVisiblePosition) {
                                    break;
                                }
                                firstVisiblePosition++;
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            cVar.eFj().j(arrayList, 126);
                        }
                    }
                }
                AppMethodBeat.o(231935);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                NewBizInfoHeaderPreference newBizInfoHeaderPreference;
                int i5;
                boolean isAttachedToWindow;
                AppMethodBeat.i(231936);
                if (!(ContactWidgetNewBizInfo.this.screen == null || (newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) ContactWidgetNewBizInfo.this.screen.bmg("contact_info_header_newbizinfo")) == null)) {
                    int[] iArr = new int[2];
                    if (newBizInfoHeaderPreference.Bju == null) {
                        i5 = 0;
                    } else {
                        newBizInfoHeaderPreference.Bju.getLocationInWindow(iArr);
                        i5 = iArr[1];
                    }
                    if (i5 < 0) {
                        int measuredHeight = newBizInfoHeaderPreference.Bjw.getMeasuredHeight();
                        contactInfoUI.setMMTitleColor(contactInfoUI.getResources().getColor(R.color.FG_0));
                        contactInfoUI.setTitleAlpha(1.0f - (((float) ((i5 + measuredHeight) - statusBarHeight)) / ((float) measuredHeight)));
                        AppMethodBeat.o(231936);
                        return;
                    }
                    if (i5 == 0) {
                        if (newBizInfoHeaderPreference.Bju == null) {
                            isAttachedToWindow = false;
                        } else {
                            isAttachedToWindow = newBizInfoHeaderPreference.Bju.isAttachedToWindow();
                        }
                        if (!isAttachedToWindow) {
                            contactInfoUI.setMMTitleColor(contactInfoUI.getResources().getColor(R.color.FG_0));
                            AppMethodBeat.o(231936);
                            return;
                        }
                    }
                    contactInfoUI.setMMTitleColor(0);
                }
                AppMethodBeat.o(231936);
            }
        });
        AppMethodBeat.o(231952);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        ListView listView;
        boolean z5;
        AppMethodBeat.i(27443);
        if (this.BiT.isFinishing()) {
            AppMethodBeat.o(27443);
        } else {
            if (asVar != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            if (Util.nullAsNil(asVar.field_username).length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.assertTrue(z3);
            if (fVar != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assert.assertTrue(z4);
            ab(asVar);
            this.screen = fVar;
            this.contact = asVar;
            this.Bdx = z;
            this.kgm = i2;
            this.Bfh = (SnsAdClick) this.BiT.getIntent().getParcelableExtra("KSnsAdTag");
            this.Bfi = this.BiT.getIntent().getStringExtra("key_add_contact_report_info");
            this.Bfb = this.BiT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
            this.Bfg = this.BiT.getIntent().getBundleExtra("Contact_Ext_Args");
            this.pHz = this.BiT.getIntent().getStringExtra("key_channel_session_id");
            if (this.kgm == 78 || this.kgm == 79) {
                this.BiX = false;
                Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", Integer.valueOf(this.kgm));
            } else {
                boolean Vu = ((com.tencent.mm.api.q) g.af(com.tencent.mm.api.q.class)).Vu();
                if (!Vu) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.BiX = z5;
                Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", Integer.valueOf(this.kgm), Boolean.valueOf(this.BiX), Boolean.valueOf(Vu));
            }
            if (this.BiZ) {
                this.BiZ = false;
                initActionBar();
                this.BiU = a.aKy(this.contact.field_username);
                eEp();
                b(asVar.field_username, null);
                String stringExtra = this.BiT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
                if (!Util.isNullOrNil(stringExtra)) {
                    this.BiT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
                    h.a(this.BiT, stringExtra, "", this.BiT.getString(R.string.x_), (DialogInterface.OnClickListener) null);
                }
                if (asVar != null) {
                    ag.bau().MN(asVar.field_username);
                }
            }
            if (!(this.Bjb == null || (listView = this.BiT.getListView()) == null)) {
                listView.onRestoreInstanceState(this.Bjb);
            }
            if (this.BiT instanceof FragmentActivity) {
                this.BiT.getLifecycle().removeObserver(this);
                this.BiT.getLifecycle().addObserver(this);
            }
            AppMethodBeat.o(27443);
        }
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        AppMethodBeat.i(27444);
        Log.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
        cCs();
        AppMethodBeat.o(27444);
    }

    private void initActionBar() {
        AppMethodBeat.i(27445);
        this.BiT.setMMTitle(Util.nullAsNil(this.contact.field_nickname));
        this.BiT.setMMTitleColor(0);
        this.BiT.setTitleDividerVis(false);
        this.BiT.setIsDarkActionbarBg(false);
        this.BiT.setActionbarColor(this.BiT.getResources().getColor(R.color.f3045c));
        this.BiT.hideActionbarLine();
        this.BiT.setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass3 */

            {
                AppMethodBeat.i(161412);
                AppMethodBeat.o(161412);
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(231938);
                ContactWidgetNewBizInfo.this.BiT.onBackPressed();
                AppMethodBeat.o(231938);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.BiT.removeAllOptionMenu();
        this.BiT.addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(231939);
                ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
                AppMethodBeat.o(231939);
                return true;
            }
        });
        this.BiT.addIconOptionMenu(0, "", R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27434);
                e eVar = new e((Context) ContactWidgetNewBizInfo.this.BiT, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(231941);
                        if (com.tencent.mm.contact.c.oR(ContactWidgetNewBizInfo.this.contact.field_type)) {
                            if (ContactWidgetNewBizInfo.this.contact.arE()) {
                                if (!ab.clc() || !com.tencent.mm.al.g.Nd(ContactWidgetNewBizInfo.this.contact.field_username)) {
                                    mVar.kV(5, R.string.euv);
                                } else {
                                    mVar.kV(5, R.string.b_l);
                                }
                            } else if (!ab.clc() || !com.tencent.mm.al.g.Nd(ContactWidgetNewBizInfo.this.contact.field_username)) {
                                mVar.kV(4, R.string.bh2);
                            } else {
                                mVar.kV(4, R.string.b_h);
                            }
                        } else if (((int) ContactWidgetNewBizInfo.this.contact.gMZ) <= 0) {
                            ay.a.iDq.a(ContactWidgetNewBizInfo.this.contact.field_username, "", new ay.b.a() {
                                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.model.ay.b.a
                                public final void p(String str, boolean z) {
                                    AppMethodBeat.i(231940);
                                    Log.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", str, Boolean.valueOf(z));
                                    AppMethodBeat.o(231940);
                                }
                            });
                        }
                        mVar.kV(2, R.string.bf6);
                        mVar.kV(6, R.string.ay8);
                        if (com.tencent.mm.contact.c.oR(ContactWidgetNewBizInfo.this.contact.field_type)) {
                            mVar.kV(3, R.string.b_w);
                        }
                        AppMethodBeat.o(231941);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass5.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(231942);
                        switch (menuItem.getItemId()) {
                            case 2:
                                ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                                AppMethodBeat.o(231942);
                                return;
                            case 3:
                                ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this);
                                AppMethodBeat.o(231942);
                                return;
                            case 4:
                                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.this.contact.field_username, 903, ContactWidgetNewBizInfo.this.kgm, ContactWidgetNewBizInfo.this.enterTime);
                                com.tencent.mm.model.j.HO(ContactWidgetNewBizInfo.this.contact.field_username);
                                ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
                                if (!ab.clc() || com.tencent.mm.al.g.Nb(ContactWidgetNewBizInfo.this.contact.field_username)) {
                                    h.cD(ContactWidgetNewBizInfo.this.BiT, ContactWidgetNewBizInfo.this.BiT.getString(R.string.euw));
                                    AppMethodBeat.o(231942);
                                    return;
                                }
                            case 5:
                                com.tencent.mm.model.ab.F(ContactWidgetNewBizInfo.this.contact.field_username, true);
                                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.this.contact.field_username, 904, ContactWidgetNewBizInfo.this.kgm, ContactWidgetNewBizInfo.this.enterTime);
                                ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
                                if (!ab.clc() || com.tencent.mm.al.g.Nb(ContactWidgetNewBizInfo.this.contact.field_username)) {
                                    h.cD(ContactWidgetNewBizInfo.this.BiT, ContactWidgetNewBizInfo.this.BiT.getString(R.string.aj0));
                                    AppMethodBeat.o(231942);
                                    return;
                                }
                            case 6:
                                ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this);
                                AppMethodBeat.o(231942);
                                return;
                            default:
                                Log.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
                                break;
                        }
                        AppMethodBeat.o(231942);
                    }
                };
                eVar.dGm();
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.this.contact.field_username, 600, ContactWidgetNewBizInfo.this.kgm, ContactWidgetNewBizInfo.this.enterTime);
                AppMethodBeat.o(27434);
                return false;
            }
        });
        AppMethodBeat.o(27445);
    }

    static {
        AppMethodBeat.i(231954);
        AppMethodBeat.o(231954);
    }

    private void eEY() {
        AppMethodBeat.i(27446);
        if (this.BiV != null) {
            AppMethodBeat.o(27446);
            return;
        }
        com.tencent.mm.ui.base.preference.h hVar = (com.tencent.mm.ui.base.preference.h) this.BiT.getListView().getAdapter();
        if (hVar == null) {
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
            AppMethodBeat.o(27446);
            return;
        }
        this.BiV = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.BiT, this, hVar, new String[]{"contact_info_biz_err_msg", "contact_info_footer_space"});
        hVar.OYY = this.BiV;
        AppMethodBeat.o(27446);
    }

    private void a(ph phVar) {
        AppMethodBeat.i(169758);
        if (phVar == null) {
            AppMethodBeat.o(169758);
            return;
        }
        if (phVar.KWm != null) {
            com.tencent.mm.plugin.brandservice.b.c.E(phVar.KWm.LYA, true);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(phVar.KWm.LYA);
            objArr[1] = Integer.valueOf(phVar.KWm.MJY != null ? phVar.KWm.MJY.size() : -1);
            Log.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", objArr);
        } else {
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
        }
        if (phVar.KWg != null) {
            eEY();
            if (this.BiV != null) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.b.c cVar = this.BiV;
                ov ovVar = phVar.KWg;
                dey dey = phVar.KWm;
                p.h(ovVar, "msgList");
                cVar.Bku.b(ovVar);
                cVar.Bku.a(dey);
                cVar.BkC.notifyDataSetChanged();
            }
        }
        if (!this.BiW && phVar.KWm != null && phVar.KWm.MJY != null && phVar.KWm.MJY.size() > 0 && com.tencent.mm.plugin.brandservice.b.c.clv()) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1401, this.kgm, this.enterTime);
            this.BiW = true;
        }
        AppMethodBeat.o(169758);
    }

    private void eEZ() {
        AppMethodBeat.i(27448);
        c fJ = com.tencent.mm.al.g.fJ(this.contact.field_username);
        this.dhu = null;
        this.dhv = null;
        this.BeW = null;
        if ((fJ == null || fJ.cG(false) == null) && this.BeX != null) {
            fJ = new c();
            fJ.field_username = this.contact.field_username;
            fJ.field_brandFlag = this.BeX.kem;
            fJ.field_brandIconURL = this.BeX.kep;
            fJ.field_brandInfo = this.BeX.keo;
            fJ.field_extInfo = this.BeX.ken;
            fJ.field_type = fJ.cG(false).getServiceType();
        }
        if (fJ != null && fJ.field_brandInfo == null && fJ.field_extInfo == null && this.BeX != null) {
            fJ.field_username = this.contact.field_username;
            fJ.field_brandFlag = this.BeX.kem;
            fJ.field_brandIconURL = this.BeX.kep;
            fJ.field_brandInfo = this.BeX.keo;
            fJ.field_extInfo = this.BeX.ken;
            fJ.field_type = fJ.cG(false).getServiceType();
        }
        if (fJ != null) {
            this.Bdk = fJ;
            this.dhu = fJ.UO();
            this.dhv = fJ.cG(false);
            this.BeW = this.dhv.getWxaEntryInfoList();
            if (this.dhv.US() != null && this.dhv.US().length() > 0) {
                this.dhE = this.dhv.US();
            }
        }
        AppMethodBeat.o(27448);
    }

    public final void cJk() {
        AppMethodBeat.i(27449);
        if (this.Bja && this.BiU.KWg != null && this.BiU.KWg.KVx != null && this.BiU.KWg.KVx.KWa == 0) {
            b(this.contact.field_username, this.BiU.KWg.KVx.KVZ);
        }
        AppMethodBeat.o(27449);
    }

    public final as eFa() {
        return this.contact;
    }

    private void b(String str, final com.tencent.mm.bw.b bVar) {
        ContactInfoUI contactInfoUI;
        AppMethodBeat.i(27450);
        if (this.isLoading) {
            Log.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
            AppMethodBeat.o(27450);
            return;
        }
        this.isLoading = true;
        d.a aVar = new d.a();
        aVar.funcId = 2656;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        pg pgVar = new pg();
        pgVar.KSV = str;
        if (bVar != null) {
            pgVar.KWb = 1;
            pgVar.KVZ = bVar;
            pgVar.KWc = 20;
        } else {
            pgVar.KWb = 0;
            pgVar.KWc = 5;
        }
        pgVar.Scene = this.kgm;
        pgVar.KWd = ab.getSessionId();
        aVar.iLN = pgVar;
        aVar.iLO = new ph();
        com.tencent.mm.ak.d aXF = aVar.aXF();
        AnonymousClass7 r2 = new aa.a() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass7 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                String d2;
                String d3;
                AppMethodBeat.i(231944);
                Log.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                ph phVar = (ph) dVar.iLL.iLR;
                if (i2 == 0 && i3 == 0 && phVar != null) {
                    a aVar = a.BjZ;
                    a.a(phVar.KWg);
                    if (bVar == null) {
                        try {
                            ContactWidgetNewBizInfo.this.BiU.parseFrom(phVar.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", e2, "profileInfo.parseFrom", new Object[0]);
                        }
                    } else if (!bVar.equals(ContactWidgetNewBizInfo.this.BiU.KWg.KVx.KVZ) || phVar.KWg == null) {
                        Log.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
                    } else {
                        ContactWidgetNewBizInfo.this.BiU.KWg.KVw.addAll(phVar.KWg.KVw);
                        ContactWidgetNewBizInfo.this.BiU.KWg.KVx = phVar.KWg.KVx;
                    }
                    if (bVar == null) {
                        a.b(ContactWidgetNewBizInfo.this.BiU);
                        ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
                        ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
                    } else if (!(ContactWidgetNewBizInfo.this.BiU == null || ContactWidgetNewBizInfo.this.BiU.KWg == null)) {
                        ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.this.BiU);
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.this.contact.field_username, 106, ContactWidgetNewBizInfo.this.kgm, ContactWidgetNewBizInfo.this.enterTime);
                    }
                    if ((phVar.KTf & 4) != 0 && (d3 = ContactWidgetNewBizInfo.d(4, phVar.KWk)) != null) {
                        ContactWidgetNewBizInfo.this.screen.m38do("contact_info_biz_err_msg", false);
                        ((NewBizInfoErrMsgPreference) ContactWidgetNewBizInfo.this.screen.bmg("contact_info_biz_err_msg")).setErrMsg(d3);
                    } else if ((phVar.KTf & 8) == 0 || (d2 = ContactWidgetNewBizInfo.d(8, phVar.KWk)) == null) {
                        ContactWidgetNewBizInfo.this.screen.m38do("contact_info_biz_err_msg", true);
                    } else {
                        ContactWidgetNewBizInfo.this.screen.m38do("contact_info_biz_err_msg", false);
                        ((NewBizInfoErrMsgPreference) ContactWidgetNewBizInfo.this.screen.bmg("contact_info_biz_err_msg")).setErrMsg(d2);
                    }
                    if ((phVar.KTf & 2) != 0) {
                        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) ContactWidgetNewBizInfo.this.screen.bmg("contact_info_header_newbizinfo");
                        newBizInfoHeaderPreference.Bjy = true;
                        if (newBizInfoHeaderPreference.gyr != null) {
                            com.tencent.mm.plugin.brandservice.b.d.a(newBizInfoHeaderPreference.gyr, newBizInfoHeaderPreference.contact, "", true);
                            newBizInfoHeaderPreference.gyr.setClickable(false);
                        }
                    }
                    ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
                }
                ContactWidgetNewBizInfo.this.isLoading = false;
                AppMethodBeat.o(231944);
                return 0;
            }
        };
        if (this.BiT instanceof com.tencent.mm.vending.e.b) {
            contactInfoUI = this.BiT;
        } else {
            contactInfoUI = null;
        }
        aa.a(aXF, r2, false, contactInfoUI);
        AppMethodBeat.o(27450);
    }

    private void eEp() {
        AppMethodBeat.i(27451);
        cCs();
        eEZ();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.a7);
        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.screen.bmg("contact_info_header_newbizinfo");
        if (newBizInfoHeaderPreference == null || Util.isNullOrNil(this.contact.field_username)) {
            Log.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
            this.screen.m38do("contact_info_header_bizinfo", true);
        } else {
            newBizInfoHeaderPreference.a(this.contact, this.BdC, this.Bdk, this.BiU);
            this.Bja = true;
        }
        if (this.BiU == null) {
            this.screen.m38do("contact_info_biz_add", true);
            this.screen.m38do("contact_info_biz_go_chatting", true);
            this.screen.m38do("contact_info_biz_space", false);
        } else if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.screen.m38do("contact_info_biz_add", true);
            this.screen.m38do("contact_info_biz_go_chatting", false);
            ((NewBizInfoFollowPreference) this.screen.bmg("contact_info_biz_go_chatting")).Bdv = this;
        } else {
            this.screen.m38do("contact_info_biz_add", false);
            this.screen.m38do("contact_info_biz_go_chatting", true);
        }
        if (!(this.BiU == null || this.BiU.KWe == null || this.BiU.KWg == null || this.BiU.KWg.KVx == null)) {
            a(this.BiU);
        }
        if (this.BiU != null && !csM() && !com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.BiT.showOptionMenu(false);
        }
        if (this.BiU == null || this.BiU.KWj == null) {
            this.screen.m38do("contact_info_biz_menu_newbizinfo", true);
        } else {
            this.screen.m38do("contact_info_biz_menu_newbizinfo", false);
            if (this.BiU != null) {
                ((NewBizInfoMenuPreference) this.screen.bmg("contact_info_biz_menu_newbizinfo")).a(this.BiU.KWj, this.contact, this.kgm, this.enterTime);
            }
        }
        this.screen.m38do("contact_info_biz_err_msg", true);
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false)));
        if (this.BiT.getIntent() == null || !this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (eFb()) {
                this.screen.m38do("contact_info_biz_loading", false);
                this.screen.m38do("contact_info_biz_add", true);
                this.screen.m38do("contact_info_biz_go_chatting", true);
                this.screen.m38do("contact_info_message_newbizinfo", true);
            }
            AppMethodBeat.o(27451);
            return;
        }
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
        boolean eEs = eEs();
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(eEs));
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type) || !eEs) {
            Log.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", this.contact.field_username);
            eEq();
            NewBizInfoNotFollowPreference newBizInfoNotFollowPreference = (NewBizInfoNotFollowPreference) this.screen.bmg("contact_info_biz_add");
            this.screen.m38do("contact_info_biz_add", false);
            if (newBizInfoNotFollowPreference != null) {
                if (eEs) {
                    newBizInfoNotFollowPreference.setTitle(this.BiT.getString(R.string.b_j));
                    AppMethodBeat.o(27451);
                    return;
                }
                newBizInfoNotFollowPreference.setTitle(this.BiT.getString(R.string.b_5));
            }
        }
        AppMethodBeat.o(27451);
    }

    private boolean csM() {
        AppMethodBeat.i(27452);
        if (this.BiU == null || this.BiU.KWe == null || this.BiU.KWe.KQU != 0 || eFb()) {
            AppMethodBeat.o(27452);
            return false;
        }
        AppMethodBeat.o(27452);
        return true;
    }

    private boolean eFb() {
        boolean z = true;
        AppMethodBeat.i(27453);
        try {
            String UV = this.dhv.UV();
            if (Util.isNullOrNil(UV)) {
                AppMethodBeat.o(27453);
                return false;
            }
            long j2 = Util.getLong(UV, 0);
            if (j2 <= 0 || j2 - (System.currentTimeMillis() / 1000) >= 0) {
                z = false;
            }
            Log.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", Boolean.valueOf(z));
            AppMethodBeat.o(27453);
            return z;
        } catch (Exception e2) {
            AppMethodBeat.o(27453);
            return false;
        }
    }

    private void eEq() {
        AppMethodBeat.i(27454);
        if (this.contact == null || ((!com.tencent.mm.model.ab.JA(this.contact.field_username) && !com.tencent.mm.model.ab.JM(this.contact.field_username)) || !com.tencent.mm.contact.c.oR(this.contact.field_type))) {
            this.screen.m38do("contact_info_biz_go_chatting", true);
            AppMethodBeat.o(27454);
            return;
        }
        this.screen.m38do("contact_info_biz_go_chatting", false);
        AppMethodBeat.o(27454);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27455);
        if (this.screen == null) {
            AppMethodBeat.o(27455);
        } else {
            NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.screen.bmg("contact_info_header_newbizinfo");
            if (newBizInfoHeaderPreference != null) {
                newBizInfoHeaderPreference.onDetach();
            }
            ListView listView = this.BiT.getListView();
            if (listView != null) {
                this.Bjb = listView.onSaveInstanceState();
            }
            AppMethodBeat.o(27455);
        }
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27456);
        if (this.BiT == null) {
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
            AppMethodBeat.o(27456);
            return;
        }
        Log.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 != -1 || intent == null) {
                    AppMethodBeat.o(27456);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                com.tencent.mm.plugin.messenger.a.g.eir().s(stringExtra, stringExtra2, booleanExtra);
                com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra3, stringExtra2);
                com.tencent.mm.ui.widget.snackbar.b.r(this.BiT, this.BiT.getString(R.string.dc_));
                AppMethodBeat.o(27456);
                return;
            default:
                AppMethodBeat.o(27456);
                return;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27457);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
            AppMethodBeat.o(27457);
            return false;
        }
        Log.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s, blockAddContact: %b", str, Boolean.valueOf(this.BiX));
        if (!"contact_info_biz_add".endsWith(str)) {
            AppMethodBeat.o(27457);
            return true;
        } else if (this.BiX) {
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.BiT);
            if (!(this.contact == null || this.contact.field_username == null)) {
                ((com.tencent.mm.api.q) g.af(com.tencent.mm.api.q.class)).d(7, this.contact.field_username, this.contact.field_nickname);
            }
            AppMethodBeat.o(27457);
            return true;
        } else {
            if (!com.tencent.mm.model.gdpr.c.aXj()) {
                eEr();
            } else {
                com.tencent.mm.model.gdpr.c.a(this.BiT, com.tencent.mm.model.gdpr.a.BIZ, this.contact.field_username, new com.tencent.mm.model.gdpr.b() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass8 */

                    @Override // com.tencent.mm.model.gdpr.b
                    public final void sx(int i2) {
                        AppMethodBeat.i(231945);
                        if (i2 == 0) {
                            ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
                        }
                        AppMethodBeat.o(231945);
                    }
                });
            }
            if (this.Bfb != 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11263, Integer.valueOf(this.Bfb), this.contact.field_username);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 200, this.kgm, this.enterTime);
            AppMethodBeat.o(27457);
            return true;
        }
    }

    private void eEr() {
        AppMethodBeat.i(27458);
        if (((NewBizInfoHeaderPreference) this.screen.bmg("contact_info_header_newbizinfo")) != null) {
            NewBizInfoHeaderPreference.HN(System.currentTimeMillis());
        }
        if (this.BiT.getIntent() != null && this.BiT.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.BiT.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (Util.isNullOrNil(stringExtra)) {
                Log.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!eEs()) {
                Log.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                bg.azz().a(536, this);
                dr drVar = new dr();
                drVar.dGF.dGH = stringExtra;
                drVar.dGF.opType = 1;
                EventCenter.instance.publish(drVar);
                final com.tencent.mm.ak.q qVar = drVar.dGG.dGJ;
                ContactInfoUI contactInfoUI = this.BiT;
                this.BiT.getString(R.string.zb);
                this.tipDialog = h.a((Context) contactInfoUI, this.BiT.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass9 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(231946);
                        bg.azz().b(536, ContactWidgetNewBizInfo.this);
                        dr drVar = new dr();
                        drVar.dGF.opType = 2;
                        drVar.dGF.dGJ = qVar;
                        EventCenter.instance.publish(drVar);
                        AppMethodBeat.o(231946);
                    }
                });
                AppMethodBeat.o(27458);
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.BiT, new a.AbstractC2025a() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass10 */

            /* JADX WARNING: Code restructure failed: missing block: B:62:0x024d, code lost:
                if (r2 == false) goto L_0x0139;
             */
            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(boolean r9, boolean r10, java.lang.String r11, java.lang.String r12) {
                /*
                // Method dump skipped, instructions count: 593
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass10.a(boolean, boolean, java.lang.String, java.lang.String):void");
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(Integer.valueOf(this.kgm));
        if (this.dhE != null) {
            aVar.wHV = this.dhE;
        }
        if (!Util.isNullOrNil(this.wZz)) {
            aVar.wZz = this.wZz;
        }
        aVar.Keg = true;
        String stringExtra2 = this.BiT.getIntent().getStringExtra("url");
        aVar.Keh = stringExtra2;
        aVar.pHw = e.a.akL(this.BiT.getIntent().getIntExtra("qbarScene", -1));
        eqb eqb = new eqb();
        eqb.KJS = this.BiT.getIntent().getIntExtra("Contact_Sub_Scene", 0);
        eqb.Lru = this.BiT.getIntent().getStringExtra("Contact_Scene_Note");
        if (!Util.isNullOrNil(stringExtra2)) {
            if (Util.isNullOrNil(eqb.Lru)) {
                eqb.Lru = stringExtra2;
            }
            if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(stringExtra2)) {
                eqb.NnE = aKw(stringExtra2);
            }
        }
        aVar.Kei = eqb;
        aVar.a(this.contact.field_username, linkedList, this.Bfi);
        eFc();
        AppMethodBeat.o(27458);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eFc() {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.eFc():void");
    }

    private static int aKw(String str) {
        int i2 = 10000;
        AppMethodBeat.i(27460);
        if (!Util.isNullOrNil(str)) {
            try {
                i2 = Util.getInt(Uri.parse(str).getQueryParameter("scene"), 10000);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(27460);
        return i2;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(27461);
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (qVar == null) {
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
            AppMethodBeat.o(27461);
            return;
        }
        bg.azz().b(qVar.getType(), this);
        if (i2 == 0 && i3 == 0) {
            Log.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            if (qVar.getType() == 536) {
                bg.azz().b(536, this);
                eEp();
            }
            AppMethodBeat.o(27461);
            return;
        }
        Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
        AppMethodBeat.o(27461);
    }

    private boolean eEs() {
        AppMethodBeat.i(27462);
        if (this.BiT.getIntent() == null) {
            AppMethodBeat.o(27462);
            return false;
        }
        String stringExtra = this.BiT.getIntent().getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID);
        String stringExtra2 = this.BiT.getIntent().getStringExtra("device_type");
        dv dvVar = new dv();
        dvVar.dGR.dGL = stringExtra;
        dvVar.dGR.dGP = stringExtra2;
        EventCenter.instance.publish(dvVar);
        boolean z = dvVar.dGS.dGT;
        AppMethodBeat.o(27462);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void US(int i2) {
        int i3;
        String str;
        AppMethodBeat.i(27463);
        if (this.Bfg == null || !(this.kgm == 39 || this.kgm == 56 || this.kgm == 35 || this.kgm == 87 || this.kgm == 88 || this.kgm == 89 || this.kgm == 85)) {
            Log.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(27463);
        } else if (this.contact == null) {
            Log.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
            AppMethodBeat.o(27463);
        } else {
            String string = this.Bfg.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Args_Query_String"));
            int i4 = this.Bfg.getInt("Contact_Ext_Args_Index");
            switch (this.kgm) {
                case 35:
                    i3 = 1;
                    break;
                case s.CTRL_INDEX:
                    i3 = 5;
                    break;
                case 87:
                    i3 = 2;
                    break;
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                    i3 = 3;
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            String nullAsNil2 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Extra_Params"));
            String str2 = nullAsNil + "," + i2 + "," + Util.nullAsNil(this.contact.field_username) + "," + i4 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i3;
            if (!Util.isNullOrNil((String) null)) {
                str = str2 + "," + ((String) null) + "," + nullAsNil2;
            } else {
                str = str2 + ",," + nullAsNil2;
            }
            Log.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10866, str);
            AppMethodBeat.o(27463);
        }
    }

    public final long ahy() {
        return this.enterTime;
    }

    public final int eFd() {
        return this.kgm;
    }

    private synchronized void ab(as asVar) {
        AppMethodBeat.i(231953);
        if (asVar == null || Bjd) {
            AppMethodBeat.o(231953);
        } else {
            Bjd = true;
            final MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
            if (singleMMKV.decodeBool(Bjc, false)) {
                Log.i("MicroMsg.ContactWidgetNewBizInfo", "checkCrash clear data with crash flag");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1378, 0, 1, false);
                a.clear(asVar.field_username);
            }
            singleMMKV.encode(Bjc, true);
            Log.i("MicroMsg.ContactWidgetNewBizInfo", "checkCrash add crash flag");
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) && singleMMKV.decodeInt("testCrash", 0) == 1) {
                Assert.assertTrue("checkCrash testCrash", false);
            }
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(231937);
                    Log.i("MicroMsg.ContactWidgetNewBizInfo", "checkCrash clear crash flag");
                    singleMMKV.encode(ContactWidgetNewBizInfo.Bjc, false);
                    boolean unused = ContactWidgetNewBizInfo.Bjd = false;
                    AppMethodBeat.o(231937);
                }
            }, 1000);
            AppMethodBeat.o(231953);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.b
    public final boolean onCreate() {
        AppMethodBeat.i(27464);
        Log.v("MicroMsg.ContactWidgetNewBizInfo", "alvinluo ContactWidgetNewBizInfo onCreate");
        if (this.contact == null || this.Bdk == null) {
            Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
        } else {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.contact.field_username, this.kgm, this.Bdk.field_type, this.enterTime, com.tencent.mm.contact.c.oR(this.contact.field_type) ? 1 : 0, this.pHz);
        }
        this.pti.alive();
        this.lEl.alive();
        AppMethodBeat.o(27464);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.b
    public final boolean axa() {
        AppMethodBeat.i(27465);
        if (this.contact == null || this.Bdk == null || this.BiU == null || this.BiU.KWf == null || this.BiU.KWe == null) {
            Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
        } else {
            this.endTime = System.currentTimeMillis();
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.contact.field_username, this.kgm, this.Bdk.field_type, this.enterTime, this.endTime, com.tencent.mm.contact.c.oR(this.contact.field_type) ? 1 : 0, this.BiU.KWf.KSY, this.BiU.KWf.KSZ, this.BeW != null ? this.BeW.size() : 0, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(this.BiU.KWg), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.BiU.KWj), this.BiU.KWe.UserName);
        }
        this.pti.dead();
        this.lEl.dead();
        AppMethodBeat.o(27465);
        return false;
    }

    static /* synthetic */ void d(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(27466);
        String str = contactWidgetNewBizInfo.contact.field_username;
        Intent fXX = ai.fXX();
        fXX.putExtra("ftsneedkeyboard", true);
        fXX.putExtra("ftsbizscene", 19);
        fXX.putExtra("ftsType", 2);
        Map<String, String> h2 = ai.h(19, false, 2);
        h2.put("userName", str);
        if (!Util.isNullOrNil(contactWidgetNewBizInfo.BiU.KWn)) {
            h2.put("thirdExtParam", contactWidgetNewBizInfo.BiU.KWn);
        }
        fXX.putExtra("rawUrl", ai.bd(h2));
        fXX.putExtra("key_load_js_without_delay", true);
        fXX.putExtra("ftsbizusername", str);
        fXX.putExtra(e.p.OzF, 13307);
        fXX.putStringArrayListExtra(e.p.OzG, com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.fd(str, contactWidgetNewBizInfo.kgm));
        fXX.addFlags(67108864);
        com.tencent.mm.br.c.b(contactWidgetNewBizInfo.BiT, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(str, 1301, contactWidgetNewBizInfo.enterTime);
        AppMethodBeat.o(27466);
    }

    static /* synthetic */ void f(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(27467);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", contactWidgetNewBizInfo.contact.field_username);
        intent.putExtra("Select_block_List", contactWidgetNewBizInfo.contact.field_username);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.jRt.a(intent, 1, contactWidgetNewBizInfo.BiT);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(contactWidgetNewBizInfo.contact.field_username, 800, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
        AppMethodBeat.o(27467);
    }

    static /* synthetic */ void g(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(27468);
        Intent intent = new Intent();
        intent.setClass(contactWidgetNewBizInfo.BiT, NewBizInfoSettingUI.class);
        intent.putExtra("Contact_User", contactWidgetNewBizInfo.contact.field_username);
        intent.putExtra("key_start_biz_profile_setting_from_scene", 2);
        intent.putExtra("key_profile_enter_timestamp", contactWidgetNewBizInfo.enterTime);
        if (contactWidgetNewBizInfo.BiT.getIntent() != null) {
            intent.putExtras(contactWidgetNewBizInfo.BiT.getIntent());
        }
        ContactInfoUI contactInfoUI = contactWidgetNewBizInfo.BiT;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        contactInfoUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, "com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo", "jumpToSettingUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(27468);
    }

    static /* synthetic */ void j(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(27470);
        ao aoVar = new ao();
        aoVar.dDs.userName = contactWidgetNewBizInfo.contact.field_username;
        EventCenter.instance.publish(aoVar);
        AppMethodBeat.o(27470);
    }

    static /* synthetic */ void k(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(161415);
        if (contactWidgetNewBizInfo.contact == null || Util.isNullOrNil(contactWidgetNewBizInfo.contact.field_username)) {
            AppMethodBeat.o(161415);
            return;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(contactWidgetNewBizInfo.contact.field_username, 601, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format(Bff, contactWidgetNewBizInfo.contact.field_username));
        intent.putExtra("key_menu_hide_expose", true);
        com.tencent.mm.br.c.b(contactWidgetNewBizInfo.BiT, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(161415);
    }

    static /* synthetic */ String d(int i2, LinkedList linkedList) {
        AppMethodBeat.i(161419);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bfu bfu = (bfu) it.next();
            if (bfu.KTf == i2) {
                String str = bfu.xJH;
                AppMethodBeat.o(161419);
                return str;
            }
        }
        AppMethodBeat.o(161419);
        return null;
    }

    static /* synthetic */ void o(ContactWidgetNewBizInfo contactWidgetNewBizInfo) {
        AppMethodBeat.i(161420);
        if (contactWidgetNewBizInfo.contact == null || contactWidgetNewBizInfo.Bdk == null || contactWidgetNewBizInfo.BiU == null || contactWidgetNewBizInfo.BiU.KWf == null || contactWidgetNewBizInfo.BiU.KWe == null) {
            Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
            AppMethodBeat.o(161420);
            return;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(contactWidgetNewBizInfo.contact.field_username, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.Bdk.field_type, contactWidgetNewBizInfo.enterTime, com.tencent.mm.contact.c.oR(contactWidgetNewBizInfo.contact.field_type) ? 1 : 0, contactWidgetNewBizInfo.BiU.KWf.KSY, contactWidgetNewBizInfo.BiU.KWf.KSZ, contactWidgetNewBizInfo.BeW != null ? contactWidgetNewBizInfo.BeW.size() : 0, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(contactWidgetNewBizInfo.BiU.KWg), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(contactWidgetNewBizInfo.BiU.KWj), contactWidgetNewBizInfo.BiU.KWe.UserName);
        if (!(contactWidgetNewBizInfo.BiU == null || contactWidgetNewBizInfo.BiU.KWj == null)) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(contactWidgetNewBizInfo.contact.field_username, 104, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
        }
        if (contactWidgetNewBizInfo.BiU != null) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(contactWidgetNewBizInfo.contact.field_username, 101, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
        }
        if (contactWidgetNewBizInfo.BiU != null && contactWidgetNewBizInfo.csM() && contactWidgetNewBizInfo.BeW != null && contactWidgetNewBizInfo.BeW.size() > 0) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(contactWidgetNewBizInfo.contact.field_username, 105, contactWidgetNewBizInfo.kgm, contactWidgetNewBizInfo.enterTime);
        }
        AppMethodBeat.o(161420);
    }
}
