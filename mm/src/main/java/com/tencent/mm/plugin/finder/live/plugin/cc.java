package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.widget.v;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0012H\u0002J6\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0'H\u0002J\u0012\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J$\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u001a\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u000100H\u0016J\b\u0010?\u001a\u00020\u001eH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "SHEET_KICK_MEMBERR", "", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_BLACK_LIST", "SHEET_MORE_ACTION_RECOVER_COMMENT", "SHEET_MORE_ACTION_REPORT", "TAG", "", "disableComment", "", "kickMemberBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "moreActionBottomSheet", "moreActionItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "needNotifyClosed", "profileWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "sourceType", ch.COL_USERNAME, "backToMemberList", "", "banComment", "enableComment", "buildConfirmDialog", "title", "item", "titleColor", "itemColor", "click", "Lkotlin/Function0;", "goToFinderProfile", "finderUsername", "kickMember", "moreAction", "mount", "onBackPress", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "", "prepareMenuItems", "menuItem", "Lcom/tencent/mm/ui/base/MMMenu;", "showMemberProfile", "liveCustomerContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder_release"})
public final class cc extends d {
    private static final String ULy = ULy;
    public static final a UMU = new a((byte) 0);
    private static final String uuf = uuf;
    private final String TAG = "FinderLiveNewMemberProfilePlugin";
    private final int UMR = 1;
    private v UMS;
    private boolean UMT;
    private final com.tencent.mm.live.c.b hOp;
    private boolean hRz;
    private int sourceType;
    private final int urZ = 10;
    private final int usa = 11;
    private final int usb = 12;
    private final int usc = 13;
    private String username;
    private com.tencent.mm.ui.widget.a.e usp;
    private com.tencent.mm.ui.widget.a.e usq;
    private o.g usr;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "success", "", "enable", "invoke"})
    public static final class b extends q implements m<Boolean, Boolean, x> {
        final /* synthetic */ cc UMV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(cc ccVar) {
            super(2);
            this.UMV = ccVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
            String string;
            String string2;
            AppMethodBeat.i(260694);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            if (booleanValue) {
                if (this.UMV.hRz) {
                    b.C0376b.a(this.UMV.hOp, b.c.hMU);
                }
                if (booleanValue2) {
                    Context context = this.UMV.hwr.getContext();
                    p.g(context, "root.context");
                    string2 = context.getResources().getString(R.string.cyq);
                } else {
                    Context context2 = this.UMV.hwr.getContext();
                    p.g(context2, "root.context");
                    string2 = context2.getResources().getString(R.string.cyo);
                }
                p.g(string2, "if (enable) root.context…action_comment_forbidden)");
                u.makeText(this.UMV.hwr.getContext(), string2, 0).show();
            } else {
                Context context3 = this.UMV.hwr.getContext();
                p.g(context3, "root.context");
                String string3 = context3.getResources().getString(R.string.cyi);
                p.g(string3, "root.context.resources.g…ofile_action_fail_prefix)");
                if (booleanValue2) {
                    Context context4 = this.UMV.hwr.getContext();
                    p.g(context4, "root.context");
                    string = context4.getResources().getString(R.string.cyl);
                } else {
                    Context context5 = this.UMV.hwr.getContext();
                    p.g(context5, "root.context");
                    string = context5.getResources().getString(R.string.cyp);
                }
                p.g(string, "if (enable) root.context…e_action_recover_comment)");
                u.makeText(this.UMV.hwr.getContext(), string3 + string, 0).show();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260694);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
    public static final class g extends q implements m<ayt, apg, x> {
        final /* synthetic */ cc UMV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(cc ccVar) {
            super(2);
            this.UMV = ccVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(ayt ayt, apg apg) {
            AppMethodBeat.i(260699);
            apg apg2 = apg;
            p.h(ayt, "req");
            p.h(apg2, "ret");
            if (apg2.retCode == 0) {
                b.C0376b.a(this.UMV.hOp, b.c.hMU);
                Context context = this.UMV.hwr.getContext();
                Context context2 = this.UMV.hwr.getContext();
                p.g(context2, "root.context");
                u.makeText(context, context2.getResources().getString(R.string.cyj), 0).show();
                Log.i(this.UMV.TAG, "kicked member succ" + this.UMV.username);
            } else {
                Context context3 = this.UMV.hwr.getContext();
                Context context4 = this.UMV.hwr.getContext();
                p.g(context4, "root.context");
                u.makeText(context3, context4.getResources().getString(R.string.cyk), 0).show();
                Log.i(this.UMV.TAG, "kicked member failed:" + apg2.retCode);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260699);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cc(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, bbn bbn) {
        super(viewGroup, bVar, bbn);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260710);
        this.hOp = bVar;
        this.UMS = new v(viewGroup);
        this.UMS.URo = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.cc.AnonymousClass1 */
            final /* synthetic */ cc UMV;

            {
                this.UMV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260689);
                this.UMV.rg(8);
                x xVar = x.SXb;
                AppMethodBeat.o(260689);
                return xVar;
            }
        };
        this.UMS.URn = AnonymousClass2.UMW;
        this.UMS.URp = new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.cc.AnonymousClass3 */
            final /* synthetic */ cc UMV;

            {
                this.UMV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(260691);
                cc.a(this.UMV, str);
                x xVar = x.SXb;
                AppMethodBeat.o(260691);
                return xVar;
            }
        };
        this.UMS.URq = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.cc.AnonymousClass4 */
            final /* synthetic */ cc UMV;

            {
                this.UMV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260692);
                cc.k(this.UMV);
                x xVar = x.SXb;
                AppMethodBeat.o(260692);
                return xVar;
            }
        };
        this.usr = new j(this, viewGroup);
        AppMethodBeat.o(260710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", cc.ULy, "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "SOURCE_TYPE_COMMENT", "", "SOURCE_TYPE_MEMBERLIST", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260711);
        AppMethodBeat.o(260711);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(260705);
        super.mount();
        v vVar = this.UMS;
        if (vVar != null) {
            vVar.hUn();
            AppMethodBeat.o(260705);
            return;
        }
        AppMethodBeat.o(260705);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(260706);
        super.unMount();
        v vVar = this.UMS;
        if (vVar != null) {
            vVar.hUo();
            AppMethodBeat.o(260706);
            return;
        }
        AppMethodBeat.o(260706);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        int i2;
        String str;
        boolean z2;
        T t;
        boolean z3;
        cc ccVar;
        String str2;
        String str3;
        T t2;
        avn avn = null;
        boolean z4 = true;
        AppMethodBeat.i(260708);
        p.h(cVar, "status");
        switch (cd.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE");
                } else {
                    z = false;
                }
                this.hRz = z;
                if (bundle != null) {
                    i2 = bundle.getInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE");
                } else {
                    i2 = 0;
                }
                this.sourceType = i2;
                if (bundle != null) {
                    str = bundle.getString("PARAM_MEMBERS_PROFILE_USERNAME");
                } else {
                    str = null;
                }
                this.username = str;
                String str4 = this.username;
                if (str4 == null || str4.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                        if (this.sourceType == 2) {
                            List<t> list = getLiveData().uDs;
                            p.g(list, "liveData.msgList");
                            Iterator<T> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    T next = it.next();
                                    if (p.j(next.csW(), this.username)) {
                                        t2 = next;
                                    }
                                } else {
                                    t2 = null;
                                }
                            }
                            T t3 = t2;
                            if (t3 != null) {
                                avn = t3.dfs();
                            }
                            Boolean bool = getLiveData().uDX.get(this.username);
                            if (bool == null) {
                                Log.i(this.TAG, "LIVE_STATUS_OPEN_MEMBER_PROFILE SOURCE_TYPE_COMMENT disableCommentCacheMap:" + this.username + " is empty!");
                                bool = Boolean.valueOf(avn != null && avn.LGh == 1);
                            } else if (avn != null) {
                                avn.LGh = bool.booleanValue() ? 1 : 0;
                            }
                            z3 = bool.booleanValue();
                            ccVar = this;
                        } else {
                            Iterator<T> it2 = getLiveData().uDn.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    T next2 = it2.next();
                                    FinderContact finderContact = next2.contact;
                                    if (finderContact != null) {
                                        str2 = finderContact.username;
                                    } else {
                                        str2 = null;
                                    }
                                    if (p.j(str2, this.username)) {
                                        t = next2;
                                    }
                                } else {
                                    t = null;
                                }
                            }
                            T t4 = t;
                            if (t4 == null || t4.LGh != 1) {
                                z3 = false;
                                ccVar = this;
                                avn = t4;
                            } else {
                                z3 = true;
                                ccVar = this;
                                avn = t4;
                            }
                        }
                        ccVar.UMT = z3;
                        if (avn != null) {
                            rg(0);
                            v vVar = this.UMS;
                            if (vVar != null) {
                                vVar.a(avn, this.sourceType, this.reportObj);
                            }
                            if (this.hOp.getLiveRole() == 1) {
                                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                com.tencent.mm.plugin.finder.report.live.k.dpl().vmm = true;
                                JSONObject jSONObject = new JSONObject();
                                String valueOf = String.valueOf(s.ac.LIVE_PERSONAL_VIEW_SHOW.action);
                                FinderContact finderContact2 = avn.contact;
                                if (finderContact2 == null || (str3 = finderContact2.username) == null) {
                                    str3 = "";
                                }
                                jSONObject.put(valueOf, str3);
                                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_AUDIENCE, jSONObject.toString());
                            }
                        } else {
                            Log.i(this.TAG, "show profile fail,contact is null!");
                        }
                        String str5 = this.TAG;
                        StringBuilder append = new StringBuilder("LIVE_STATUS_OPEN_MEMBER_PROFILE sourceType:").append(this.sourceType).append(",disableComment:").append(this.UMT).append(",liveCustomerContact is empty:");
                        if (avn != null) {
                            z4 = false;
                        }
                        Log.i(str5, append.append(z4).append('!').toString());
                        break;
                    }
                } else {
                    Log.i(this.TAG, "LIVE_STATUS_OPEN_MEMBER_PROFILE sourceType:" + this.sourceType + ", username:" + this.username + " is empty!");
                    AppMethodBeat.o(260708);
                    return;
                }
                break;
        }
        AppMethodBeat.o(260708);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260709);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, uuf)) {
            com.tencent.mm.ac.d.a(j2, new k(this, bundle, obj, j2));
        }
        AppMethodBeat.o(260709);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ Bundle ULG;
        final /* synthetic */ Object ULH;
        final /* synthetic */ cc UMV;
        final /* synthetic */ long utG;

        k(cc ccVar, Bundle bundle, Object obj, long j2) {
            this.UMV = ccVar;
            this.ULG = bundle;
            this.ULH = obj;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(260704);
            if (!this.UMV.isFinished()) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    Object obj = this.ULH;
                    a aVar = cc.UMU;
                    finderLiveAssistant.k(obj, cc.ULy);
                    AppMethodBeat.o(260704);
                    return;
                }
                AppMethodBeat.o(260704);
                return;
            }
            Log.i(this.UMV.TAG, "goToFinderProfileImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(260704);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class h implements o.f {
        final /* synthetic */ cc UMV;

        h(cc ccVar) {
            this.UMV = ccVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(260700);
            mVar.clear();
            cc ccVar = this.UMV;
            p.g(mVar, LocaleUtil.ITALIAN);
            cc.a(ccVar, mVar);
            AppMethodBeat.o(260700);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class i implements e.b {
        final /* synthetic */ cc UMV;

        i(cc ccVar) {
            this.UMV = ccVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260701);
            this.UMV.usp = null;
            cc.d(this.UMV);
            AppMethodBeat.o(260701);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class c implements e.b {
        final /* synthetic */ cc UMV;

        c(cc ccVar) {
            this.UMV = ccVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260695);
            cc.d(this.UMV);
            AppMethodBeat.o(260695);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ cc UMV;
        final /* synthetic */ int hRB = R.color.xq;
        final /* synthetic */ int hRC = R.string.cym;

        d(cc ccVar) {
            this.UMV = ccVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(260696);
            mVar.clear();
            if (this.hRB == 0) {
                int i2 = this.UMV.UMR;
                Context context = this.UMV.hwr.getContext();
                p.g(context, "root.context");
                mVar.d(i2, context.getResources().getString(this.hRC));
                AppMethodBeat.o(260696);
                return;
            }
            int i3 = this.UMV.UMR;
            Context context2 = this.UMV.hwr.getContext();
            p.g(context2, "root.context");
            int color = context2.getResources().getColor(this.hRB);
            Context context3 = this.UMV.hwr.getContext();
            p.g(context3, "root.context");
            mVar.a(i3, color, context3.getResources().getString(this.hRC));
            AppMethodBeat.o(260696);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ cc UMV;
        final /* synthetic */ kotlin.g.a.a hRD;

        e(cc ccVar, kotlin.g.a.a aVar) {
            this.UMV = ccVar;
            this.hRD = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(260697);
            p.h(menuItem, "menuItem");
            if (menuItem.getItemId() == this.UMV.UMR) {
                this.hRD.invoke();
                com.tencent.mm.ui.widget.a.e eVar = this.UMV.usq;
                if (eVar != null) {
                    eVar.bMo();
                }
                if (this.UMV.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtz++;
                    JSONObject jSONObject = new JSONObject();
                    String valueOf = String.valueOf(s.ac.LIVE_PERSONAL_KICK_OUT.action);
                    String str = this.UMV.username;
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put(valueOf, str);
                    s.c cVar = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                        cVar = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(cVar, jSONObject.toString());
                    AppMethodBeat.o(260697);
                    return;
                }
            } else {
                com.tencent.mm.ui.widget.a.e eVar2 = this.UMV.usq;
                if (eVar2 != null) {
                    eVar2.bMo();
                }
                cc.d(this.UMV);
            }
            AppMethodBeat.o(260697);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class f implements e.b {
        final /* synthetic */ cc UMV;

        f(cc ccVar) {
            this.UMV = ccVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260698);
            this.UMV.usq = null;
            AppMethodBeat.o(260698);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class j implements o.g {
        final /* synthetic */ cc UMV;
        final /* synthetic */ ViewGroup hOA;

        j(cc ccVar, ViewGroup viewGroup) {
            this.UMV = ccVar;
            this.hOA = viewGroup;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(260703);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i3 = this.UMV.urZ;
            if (valueOf != null && valueOf.intValue() == i3) {
                cc.a(this.UMV, false);
                cc.d(this.UMV);
                if (this.UMV.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.ak.CLICK_FORBITTEN_USER);
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtx++;
                    JSONObject jSONObject = new JSONObject();
                    String valueOf2 = String.valueOf(s.ac.LIVE_PERSONAL_COMMENT_CLOSE.action);
                    String str = this.UMV.username;
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put(valueOf2, str);
                    s.c cVar = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                        cVar = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(cVar, jSONObject.toString());
                    AppMethodBeat.o(260703);
                    return;
                }
            } else {
                int i4 = this.UMV.usa;
                if (valueOf != null && valueOf.intValue() == i4) {
                    cc.a(this.UMV, true);
                    cc.d(this.UMV);
                    if (this.UMV.hOp.getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vty++;
                        JSONObject jSONObject2 = new JSONObject();
                        String valueOf3 = String.valueOf(s.ac.LIVE_PERSONAL_COMMENT_OPEN.action);
                        String str2 = this.UMV.username;
                        if (str2 == null) {
                            str2 = "";
                        }
                        jSONObject2.put(valueOf3, str2);
                        s.c cVar2 = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                        com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                            cVar2 = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                        }
                        com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.a(cVar2, jSONObject2.toString());
                        AppMethodBeat.o(260703);
                        return;
                    }
                } else {
                    int i5 = this.UMV.usb;
                    if (valueOf != null && valueOf.intValue() == i5) {
                        com.tencent.mm.plugin.finder.report.live.k kVar8 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.a(s.ak.CLICK_BLACK_USER);
                        cc.a(this.UMV, new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.cc.j.AnonymousClass1 */
                            final /* synthetic */ j UMX;

                            {
                                this.UMX = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(260702);
                                cc.o(this.UMX.UMV);
                                x xVar = x.SXb;
                                AppMethodBeat.o(260702);
                                return xVar;
                            }
                        });
                        com.tencent.mm.ui.widget.a.e eVar = this.UMV.usq;
                        if (eVar != null) {
                            eVar.dGm();
                            AppMethodBeat.o(260703);
                            return;
                        }
                        AppMethodBeat.o(260703);
                        return;
                    }
                    int i6 = this.UMV.usc;
                    if (valueOf != null && valueOf.intValue() == i6) {
                        String str3 = this.UMV.username;
                        if (str3 != null) {
                            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                            if (finderLiveAssistant != null) {
                                Context context = this.hOA.getContext();
                                p.g(context, "root.context");
                                finderLiveAssistant.a(context, this.UMV.getLiveData().liveInfo.liveId, str3, (Long) null);
                            }
                        }
                        if (this.UMV.hOp.getLiveRole() == 1) {
                            com.tencent.mm.plugin.finder.report.live.k kVar9 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.a(s.ak.CLICK_COMPLAIN_USER);
                            com.tencent.mm.plugin.finder.report.live.k kVar10 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtu++;
                            JSONObject jSONObject3 = new JSONObject();
                            String valueOf4 = String.valueOf(s.ac.LIVE_PERSONAL_COMPLAIN.action);
                            String str4 = this.UMV.username;
                            if (str4 == null) {
                                str4 = "";
                            }
                            jSONObject3.put(valueOf4, str4);
                            s.c cVar3 = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                            com.tencent.mm.plugin.finder.report.live.k kVar11 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                                cVar3 = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                            }
                            com.tencent.mm.plugin.finder.report.live.k kVar12 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.a(cVar3, jSONObject3.toString());
                            AppMethodBeat.o(260703);
                            return;
                        }
                    } else {
                        com.tencent.mm.ui.widget.a.e eVar2 = this.UMV.usp;
                        if (eVar2 != null) {
                            eVar2.bMo();
                        }
                        cc.d(this.UMV);
                    }
                }
            }
            AppMethodBeat.o(260703);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(260707);
        if (this.hwr.getVisibility() == 0) {
            this.UMS.hRy.hide();
            AppMethodBeat.o(260707);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(260707);
        return onBackPress;
    }

    public static final /* synthetic */ void a(cc ccVar, com.tencent.mm.ui.base.m mVar) {
        AppMethodBeat.i(260712);
        if (ccVar.UMT) {
            int i2 = ccVar.usa;
            Context context = ccVar.hwr.getContext();
            p.g(context, "root.context");
            mVar.d(i2, context.getResources().getString(R.string.cyp));
        } else {
            int i3 = ccVar.urZ;
            Context context2 = ccVar.hwr.getContext();
            p.g(context2, "root.context");
            mVar.d(i3, context2.getResources().getString(R.string.cyl));
        }
        int i4 = ccVar.usb;
        Context context3 = ccVar.hwr.getContext();
        p.g(context3, "root.context");
        mVar.d(i4, context3.getResources().getString(R.string.cym));
        int i5 = ccVar.usc;
        Context context4 = ccVar.hwr.getContext();
        p.g(context4, "root.context");
        mVar.d(i5, context4.getResources().getString(R.string.cx_));
        AppMethodBeat.o(260712);
    }

    public static final /* synthetic */ void d(cc ccVar) {
        AppMethodBeat.i(260713);
        if (ccVar.hRz) {
            com.tencent.mm.live.c.b bVar = ccVar.hOp;
            b.c cVar = b.c.hMU;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_MEMBER_SKIP_LOADING", true);
            bVar.statusChange(cVar, bundle);
        }
        AppMethodBeat.o(260713);
    }

    public static final /* synthetic */ void a(cc ccVar, String str) {
        AppMethodBeat.i(260714);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            boolean isLandscape = ccVar.isLandscape();
            Log.i(ccVar.TAG, "goToFinderProfile finderUsername:" + str + ",isLandscape:" + isLandscape);
            if (isLandscape) {
                Bundle bundle = new Bundle();
                bundle.putString(ULy, str);
                d.a(ccVar, uuf, bundle, 0, 4);
                AppMethodBeat.o(260714);
                return;
            }
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                s.a.a(finderLiveAssistant, false, str);
                AppMethodBeat.o(260714);
                return;
            }
        }
        AppMethodBeat.o(260714);
    }

    public static final /* synthetic */ void k(cc ccVar) {
        AppMethodBeat.i(260715);
        if (ccVar.usp == null) {
            ccVar.usp = new com.tencent.mm.ui.widget.a.e(ccVar.hwr.getContext(), 1, false);
        }
        com.tencent.mm.ui.widget.a.e eVar = ccVar.usp;
        if (eVar != null) {
            eVar.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar2 = ccVar.usp;
        if (eVar2 != null) {
            eVar2.a(new h(ccVar));
        }
        com.tencent.mm.ui.widget.a.e eVar3 = ccVar.usp;
        if (eVar3 != null) {
            eVar3.a(ccVar.usr);
        }
        com.tencent.mm.ui.widget.a.e eVar4 = ccVar.usp;
        if (eVar4 != null) {
            eVar4.b(new i(ccVar));
        }
        com.tencent.mm.ui.widget.a.e eVar5 = ccVar.usp;
        if (eVar5 != null) {
            eVar5.dGm();
            AppMethodBeat.o(260715);
            return;
        }
        AppMethodBeat.o(260715);
    }

    public static final /* synthetic */ void a(cc ccVar, boolean z) {
        AppMethodBeat.i(260716);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.a(ccVar.username, z, new b(ccVar));
            AppMethodBeat.o(260716);
            return;
        }
        AppMethodBeat.o(260716);
    }

    public static final /* synthetic */ void a(cc ccVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(260717);
        if (ccVar.usq == null) {
            ccVar.usq = new com.tencent.mm.ui.widget.a.e(ccVar.hwr.getContext(), 1, true);
            com.tencent.mm.ui.widget.a.e eVar = ccVar.usq;
            if (eVar != null) {
                eVar.hbs();
            }
            View inflate = View.inflate(ccVar.hwr.getContext(), R.layout.b0l, null);
            TextView textView = (TextView) inflate.findViewById(R.id.eg6);
            p.g(textView, "bottomSheetTitleTv");
            textView.setText(ccVar.hwr.getContext().getString(R.string.cyn));
            com.tencent.mm.ui.widget.a.e eVar2 = ccVar.usq;
            if (eVar2 != null) {
                eVar2.setTitleView(inflate);
            }
            com.tencent.mm.ui.widget.a.e eVar3 = ccVar.usq;
            if (eVar3 != null) {
                eVar3.b(new c(ccVar));
            }
        }
        com.tencent.mm.ui.widget.a.e eVar4 = ccVar.usq;
        if (eVar4 != null) {
            eVar4.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar5 = ccVar.usq;
        if (eVar5 != null) {
            eVar5.setFooterView(null);
        }
        com.tencent.mm.ui.widget.a.e eVar6 = ccVar.usq;
        if (eVar6 != null) {
            eVar6.a(new d(ccVar));
        }
        com.tencent.mm.ui.widget.a.e eVar7 = ccVar.usq;
        if (eVar7 != null) {
            eVar7.a(new e(ccVar, aVar));
        }
        com.tencent.mm.ui.widget.a.e eVar8 = ccVar.usq;
        if (eVar8 != null) {
            eVar8.b(new f(ccVar));
            AppMethodBeat.o(260717);
            return;
        }
        AppMethodBeat.o(260717);
    }

    public static final /* synthetic */ void o(cc ccVar) {
        AppMethodBeat.i(260718);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.c(ccVar.username, new g(ccVar));
            AppMethodBeat.o(260718);
            return;
        }
        AppMethodBeat.o(260718);
    }
}
