package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u0003567B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010 \u001a\u00020\u001dJ\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0016\u0010+\u001a\u00020\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0017H\u0016J(\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0016J(\u00104\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", FirebaseAnalytics.b.INDEX, "touchX", "touchY", "showPopWindow", "Companion", "DeleteUserTask", "WxaUserInfoEventListener", "plugin-appbrand-integration_release"})
public final class b implements a {
    public static final a lHU = new a((byte) 0);
    final Context context;
    final ArrayList<i.a> lHN = new ArrayList<>();
    final AtomicInteger lHO = new AtomicInteger(this.lHS.lHH);
    final int lHP = com.tencent.luggage.sdk.g.a.aK(this);
    public a.AbstractC0630a lHQ;
    public com.tencent.mm.ui.widget.b.a lHR;
    private final MMUserAvatarInfo lHS;
    private final c lHT;
    private final String scope;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J`\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u000fH&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "appId", "plugin-appbrand-integration_release"})
    public interface c {
        void a(boolean z, boolean z2, String str, String str2, m<? super Activity, ? super String, x> mVar);

        void bz(List<i.a> list);
    }

    static {
        AppMethodBeat.i(180472);
        AppMethodBeat.o(180472);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class e<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ a.AbstractC0630a lHX;
        final /* synthetic */ b lHY;
        final /* synthetic */ int lHZ;
        final /* synthetic */ ArrayList lIa;

        e(b bVar, int i2, ArrayList arrayList, a.AbstractC0630a aVar) {
            this.lHY = bVar;
            this.lHZ = i2;
            this.lIa = arrayList;
            this.lHX = aVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(180460);
            final IPCBoolean iPCBoolean = (IPCBoolean) obj;
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.e.AnonymousClass1 */
                final /* synthetic */ e lIb;

                {
                    this.lIb = r1;
                }

                public final void run() {
                    AppMethodBeat.i(180459);
                    IPCBoolean iPCBoolean = iPCBoolean;
                    if (!(iPCBoolean != null ? iPCBoolean.value : false)) {
                        b.a(this.lIb.lHY, this.lIb.lHY.lHN);
                        Log.i("WxaUserInfoListOperationController", "delete avatar failed, revert delete item. index:" + this.lIb.lHZ, Integer.valueOf(this.lIb.lHZ));
                    } else {
                        this.lIb.lHY.lHN.clear();
                        this.lIb.lHY.lHN.addAll(this.lIb.lIa);
                        Log.i("WxaUserInfoListOperationController", "delete avatar success.index:" + this.lIb.lHZ + "  current szie=" + this.lIb.lHY.lHN.size());
                    }
                    a.AbstractC0630a aVar = this.lIb.lHX;
                    if (aVar != null) {
                        aVar.bES();
                        AppMethodBeat.o(180459);
                        return;
                    }
                    AppMethodBeat.o(180459);
                }
            });
            AppMethodBeat.o(180460);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "appId", "", "invoke"})
    public static final class h extends q implements m<Activity, String, x> {
        final /* synthetic */ b lHY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar) {
            super(2);
            this.lHY = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Activity activity, String str) {
            AppMethodBeat.i(180463);
            Activity activity2 = activity;
            String str2 = str;
            p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(str2, "appId");
            b bVar = this.lHY;
            p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(str2, "appId");
            Intent intent = new Intent();
            intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, str2);
            intent.putExtra("extra_call_by_appbrand", true);
            if (activity2 instanceof MMActivity) {
                com.tencent.mm.br.c.a((MMActivity) activity2, ".plugin.webview.ui.tools.CreateAvatarUI", intent, bVar.lHP, new f(bVar));
            } else if (activity2 instanceof AppBrandUI) {
                com.tencent.luggage.h.f.aK(activity2).b(new g(bVar));
                com.tencent.mm.br.c.c(activity2, ".plugin.webview.ui.tools.CreateAvatarUI", intent, bVar.lHP);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(180463);
            return xVar;
        }
    }

    public b(Context context2, MMUserAvatarInfo mMUserAvatarInfo, String str, c cVar) {
        p.h(context2, "context");
        p.h(mMUserAvatarInfo, "mUserAvatarInfo");
        p.h(str, "scope");
        p.h(cVar, "mListener");
        AppMethodBeat.i(180471);
        this.context = context2;
        this.lHS = mMUserAvatarInfo;
        this.scope = str;
        this.lHT = cVar;
        this.lHN.addAll(a(this.scope, this.lHS));
        B(this.lHN);
        AppMethodBeat.o(180471);
    }

    public static final /* synthetic */ void a(b bVar, ArrayList arrayList) {
        AppMethodBeat.i(180473);
        bVar.B(arrayList);
        AppMethodBeat.o(180473);
    }

    /* access modifiers changed from: package-private */
    public final void B(ArrayList<i.a> arrayList) {
        AppMethodBeat.i(180466);
        this.lHT.bz(arrayList);
        c cVar = this.lHT;
        boolean z = this.lHS.lHF;
        boolean z2 = this.lHS.lHG <= arrayList.size();
        String str = this.lHS.lHL;
        if (str == null) {
            str = "";
        }
        String str2 = this.lHS.lHK;
        if (str2 == null) {
            str2 = "";
        }
        cVar.a(z, z2, str, str2, new h(this));
        AppMethodBeat.o(180466);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ a.AbstractC0630a lHX;

        d(a.AbstractC0630a aVar) {
            this.lHX = aVar;
        }

        public final void run() {
            AppMethodBeat.i(180458);
            a.AbstractC0630a aVar = this.lHX;
            if (aVar != null) {
                aVar.onStart();
                AppMethodBeat.o(180458);
                return;
            }
            AppMethodBeat.o(180458);
        }
    }

    public final void a(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(180467);
        p.h(view, "view");
        b(view, i2, i3, i4);
        AppMethodBeat.o(180467);
    }

    public final void b(i.a aVar) {
        AppMethodBeat.i(228323);
        p.h(aVar, "item");
        this.lHO.set(aVar.lGW);
        AppMethodBeat.o(228323);
    }

    private final void b(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(180469);
        this.lHR = new com.tencent.mm.ui.widget.b.a(view.getContext());
        if (i2 == 0) {
            AppMethodBeat.o(180469);
            return;
        }
        com.tencent.mm.ui.widget.b.a aVar = this.lHR;
        if (aVar == null) {
            p.hyc();
        }
        aVar.a(view, i2, 0, new i(view), new j(this, i2), i3, i4);
        AppMethodBeat.o(180469);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class i implements View.OnCreateContextMenuListener {
        final /* synthetic */ View hCI;

        i(View view) {
            this.hCI = view;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(180464);
            Context context = this.hCI.getContext();
            p.g(context, "view.context");
            contextMenu.add(0, 1, 0, context.getResources().getString(R.string.a0k));
            AppMethodBeat.o(180464);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class j implements o.g {
        final /* synthetic */ b lHY;
        final /* synthetic */ int lHZ;

        j(b bVar, int i2) {
            this.lHY = bVar;
            this.lHZ = i2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(180465);
            b bVar = this.lHY;
            int i3 = this.lHZ;
            a.AbstractC0630a aVar = this.lHY.lHQ;
            Log.i("WxaUserInfoListOperationController", "[deleteUser] index=".concat(String.valueOf(i3)));
            if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                u.makeText(bVar.context, bVar.context.getResources().getString(R.string.a3c), 1).show();
                if (aVar != null) {
                    aVar.onStart();
                }
                if (aVar != null) {
                    aVar.bES();
                    AppMethodBeat.o(180465);
                    return;
                }
                AppMethodBeat.o(180465);
                return;
            }
            ArrayList<i.a> arrayList = new ArrayList<>(bVar.lHN);
            arrayList.remove(i3);
            i.a aVar2 = bVar.lHN.get(i3);
            p.g(aVar2, "mCurrentItems[itemIndex]");
            i.a aVar3 = aVar2;
            if (aVar3.lGW == bVar.lHO.get()) {
                arrayList.get(0).jCx = true;
            }
            aVar3.jCx = false;
            bVar.B(arrayList);
            MMHandlerThread.postToMainThread(new d(aVar));
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCInteger(aVar3.lGW), C0631b.class, new e(bVar, i3, arrayList, aVar));
            AppMethodBeat.o(180465);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$goAddUserPage$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
    public static final class f implements MMActivity.a {
        final /* synthetic */ b lHY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(b bVar) {
            this.lHY = bVar;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(180461);
            if (this.lHY.lHP == i2) {
                b.a(this.lHY, intent);
            }
            AppMethodBeat.o(180461);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class g implements f.c {
        final /* synthetic */ b lHY;

        g(b bVar) {
            this.lHY = bVar;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            AppMethodBeat.i(180462);
            if (this.lHY.lHP == i2) {
                b.a(this.lHY, intent);
                AppMethodBeat.o(180462);
                return true;
            }
            AppMethodBeat.o(180462);
            return false;
        }
    }

    private static List<i.a> a(String str, MMUserAvatarInfo mMUserAvatarInfo) {
        AppMethodBeat.i(180470);
        ArrayList arrayList = new ArrayList();
        ArrayList<MMUserAvatarInfo.MMUserAvatarItem> arrayList2 = mMUserAvatarInfo.lHE;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            MMUserAvatarInfo.MMUserAvatarItem mMUserAvatarItem = arrayList2.get(i2);
            p.g(mMUserAvatarItem, "avatar_list[i]");
            MMUserAvatarInfo.MMUserAvatarItem mMUserAvatarItem2 = mMUserAvatarItem;
            arrayList.add(new i.a(mMUserAvatarItem2.nickname, mMUserAvatarItem2.desc, str, mMUserAvatarInfo.lHH == mMUserAvatarItem2.id, mMUserAvatarItem2.lHM, mMUserAvatarItem2.id));
        }
        ArrayList arrayList3 = arrayList;
        AppMethodBeat.o(180470);
        return arrayList3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b$b  reason: collision with other inner class name */
    static final class C0631b implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCBoolean> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCInteger iPCInteger, com.tencent.mm.ipcinvoker.d<IPCBoolean> dVar) {
            AppMethodBeat.i(180457);
            IPCInteger iPCInteger2 = iPCInteger;
            Log.i("WxaUserInfoListOperationController", "[DeleteUserTask#invoke]");
            if (iPCInteger2 != null) {
                com.tencent.mm.modelsimple.h hVar = new com.tencent.mm.modelsimple.h(iPCInteger2.value);
                com.tencent.mm.kernel.g.azz().a(hVar.getType(), new a(dVar, hVar));
                com.tencent.mm.kernel.g.azz().b(hVar);
                AppMethodBeat.o(180457);
            } else if (dVar != null) {
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(180457);
            } else {
                AppMethodBeat.o(180457);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask$invoke$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b$b$a */
        public static final class a implements com.tencent.mm.ak.i {
            final /* synthetic */ com.tencent.mm.ipcinvoker.d kFf;
            final /* synthetic */ com.tencent.mm.modelsimple.h lHV;

            a(com.tencent.mm.ipcinvoker.d dVar, com.tencent.mm.modelsimple.h hVar) {
                this.kFf = dVar;
                this.lHV = hVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b$b$a$a  reason: collision with other inner class name */
            static final class RunnableC0632a implements Runnable {
                final /* synthetic */ int $errCode;
                final /* synthetic */ int $errType;
                final /* synthetic */ a lHW;

                RunnableC0632a(a aVar, int i2, int i3) {
                    this.lHW = aVar;
                    this.$errType = i2;
                    this.$errCode = i3;
                }

                public final void run() {
                    AppMethodBeat.i(180455);
                    com.tencent.mm.ipcinvoker.d dVar = this.lHW.kFf;
                    if (dVar != null) {
                        dVar.bn(new IPCBoolean(this.$errType == 0 && this.$errCode == 0));
                        AppMethodBeat.o(180455);
                        return;
                    }
                    AppMethodBeat.o(180455);
                }
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(180456);
                MMHandlerThread.postToMainThread(new RunnableC0632a(this, i2, i3));
                com.tencent.mm.kernel.g.azz().b(this.lHV.getType(), this);
                AppMethodBeat.o(180456);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(b bVar, Intent intent) {
        AppMethodBeat.i(180474);
        if (intent != null) {
            int intExtra = intent.getIntExtra("id", -1);
            String stringExtra = intent.getStringExtra("nickname");
            String stringExtra2 = intent.getStringExtra("avatarurl");
            Iterator<i.a> it = bVar.lHN.iterator();
            while (it.hasNext()) {
                it.next().jCx = false;
            }
            ArrayList<i.a> arrayList = bVar.lHN;
            String str = bVar.scope;
            p.g(stringExtra2, "avatarurl");
            arrayList.add(new i.a(0, stringExtra, "", str, null, true, stringExtra2, intExtra));
            bVar.B(bVar.lHN);
            Log.i("WxaUserInfoListOperationController", "mmOnActivityResult nickname=" + stringExtra + " avatarurl=" + stringExtra2);
        }
        AppMethodBeat.o(180474);
    }
}
