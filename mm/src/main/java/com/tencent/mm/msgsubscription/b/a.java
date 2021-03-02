package com.tencent.mm.msgsubscription.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.b.c;
import com.tencent.mm.msgsubscription.e.i;
import com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000eH\u0002J,\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010!\u001a\u0004\u0018\u00010\u0003J8\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&2\u0006\u0010'\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010(\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J8\u0010(\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&2\u0006\u0010'\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010)\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0*2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010+\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0016J\u0018\u0010/\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0002J2\u00104\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u00108\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u00109\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J6\u0010:\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020 0*2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001eH\u0016J \u0010?\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u001eH\u0016J\u0010\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mSubscribeStatusManager", "Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "callbackWrapper", "", "templateId", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", ch.COL_USERNAME, "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", IssueStorage.COLUMN_EXT_INFO, "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdatedWrapper", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", AppMeasurement.Param.TIMESTAMP, "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public class a implements ISubscribeMsgService {
    private static final HashMap<String, HashMap<String, ISubscribeMsgService.b>> jzy = new HashMap<>();
    public static final C0464a jzz = new C0464a((byte) 0);
    public final com.tencent.mm.msgsubscription.d.a jzv;
    private final com.tencent.mm.msgsubscription.d.b jzw;
    private final c jzx = new c(this);

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<ISubscribeMsgService.b, x> {
        public static final d jzD = new d();

        static {
            AppMethodBeat.i(223246);
            AppMethodBeat.o(223246);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ISubscribeMsgService.b bVar) {
            AppMethodBeat.i(223245);
            ISubscribeMsgService.b bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.onError();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(223245);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<ISubscribeMsgService.b, x> {
        final /* synthetic */ String jzC;
        final /* synthetic */ ISubscribeMsgService.c jzE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, ISubscribeMsgService.c cVar) {
            super(1);
            this.jzC = str;
            this.jzE = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ISubscribeMsgService.b bVar) {
            AppMethodBeat.i(223247);
            ISubscribeMsgService.b bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.a(this.jzC, this.jzE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(223247);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000Rb\u0010\u0005\u001aV\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b0\u0006j*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$Companion;", "", "()V", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.b.a$a  reason: collision with other inner class name */
    public static final class C0464a {
        private C0464a() {
        }

        public /* synthetic */ C0464a(byte b2) {
            this();
        }

        public static void a(String str, String str2, ISubscribeMsgService.b bVar) {
            HashMap hashMap;
            AppMethodBeat.i(223237);
            p.h(str, "templateId");
            p.h(str2, "viewKey");
            p.h(bVar, "callback");
            HashMap hashMap2 = (HashMap) a.jzy.get(str);
            if (hashMap2 == null) {
                hashMap = new HashMap();
            } else {
                hashMap = hashMap2;
            }
            hashMap.put(str2, bVar);
            a.jzy.put(str, hashMap);
            Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", str, Integer.valueOf(hashMap.size()));
            AppMethodBeat.o(223237);
        }

        public static void bH(String str, String str2) {
            AppMethodBeat.i(223238);
            p.h(str, "templateId");
            p.h(str2, "viewKey");
            HashMap hashMap = (HashMap) a.jzy.get(str);
            if (hashMap != null) {
                hashMap.remove(str2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = hashMap != null ? Integer.valueOf(hashMap.size()) : null;
            Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", objArr);
            AppMethodBeat.o(223238);
        }
    }

    static {
        AppMethodBeat.i(223268);
        AppMethodBeat.o(223268);
    }

    public a(com.tencent.mm.msgsubscription.d.a aVar) {
        AppMethodBeat.i(223267);
        this.jzv = aVar;
        this.jzw = new com.tencent.mm.msgsubscription.d.b(aVar);
        AppMethodBeat.o(223267);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/msgsubscription/model/SubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
    public static final class c implements ISubscribeMsgService.b {
        final /* synthetic */ a jzB;
        final /* synthetic */ String jzC;

        c(a aVar, String str) {
            this.jzB = aVar;
            this.jzC = str;
        }

        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
        public final void a(String str, ISubscribeMsgService.c cVar) {
            AppMethodBeat.i(223243);
            p.h(str, "templateId");
            p.h(cVar, "result");
            a.b(str, cVar);
            AppMethodBeat.o(223243);
        }

        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
        public final void onError() {
            AppMethodBeat.i(223244);
            a.Rw(this.jzC);
            AppMethodBeat.o(223244);
        }
    }

    public void bG(String str, String str2) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(223250);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        c cVar = this.jzx;
        c cVar2 = new c(this, str2);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        ISubscribeMsgService iSubscribeMsgService = cVar.jzJ;
        T t = iSubscribeMsgService != null ? (T) iSubscribeMsgService.bF(str, str2) : null;
        z.f fVar = new z.f();
        fVar.SYG = t;
        ISubscribeMsgService iSubscribeMsgService2 = cVar.jzJ;
        if (iSubscribeMsgService2 != null) {
            z = iSubscribeMsgService2.Rt(str);
        } else {
            z = false;
        }
        if (t != null) {
            Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from cache: %d", Integer.valueOf(t.jyB));
            if (t.jyB == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            cVar2.a(str2, new ISubscribeMsgService.c(z2, z));
            T t2 = fVar.SYG;
            T t3 = fVar.SYG;
            if (t3 != null) {
                i2 = t3.jyB;
            } else {
                i2 = -1;
            }
            b bVar = new b(str, str2, i2);
            bVar.jzA = cVar2;
            cVar.a(t2, bVar);
            AppMethodBeat.o(223250);
            return;
        }
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from local");
        ISubscribeMsgService iSubscribeMsgService3 = cVar.jzJ;
        if (iSubscribeMsgService3 != null) {
            iSubscribeMsgService3.b(str, new c.C0468c(cVar, str2, cVar2, fVar));
            AppMethodBeat.o(223250);
            return;
        }
        AppMethodBeat.o(223250);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/msgsubscription/model/SubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
    public static final class f implements ISubscribeMsgService.b {
        final /* synthetic */ a jzB;
        final /* synthetic */ SubscribeMsgTmpItem jzF;
        final /* synthetic */ ISubscribeMsgService.b jzG;

        f(a aVar, SubscribeMsgTmpItem subscribeMsgTmpItem, ISubscribeMsgService.b bVar) {
            this.jzB = aVar;
            this.jzF = subscribeMsgTmpItem;
            this.jzG = bVar;
        }

        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
        public final void a(String str, ISubscribeMsgService.c cVar) {
            AppMethodBeat.i(223248);
            p.h(str, "templateId");
            p.h(cVar, "result");
            a.b(this.jzF.ixM, cVar);
            ISubscribeMsgService.b bVar = this.jzG;
            if (bVar != null) {
                bVar.a(this.jzF.ixM, cVar);
                AppMethodBeat.o(223248);
                return;
            }
            AppMethodBeat.o(223248);
        }

        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
        public final void onError() {
            AppMethodBeat.i(223249);
            a.Rw(this.jzF.ixM);
            ISubscribeMsgService.b bVar = this.jzG;
            if (bVar != null) {
                bVar.onError();
                AppMethodBeat.o(223249);
                return;
            }
            AppMethodBeat.o(223249);
        }
    }

    public void a(String str, SubscribeMsgTmpItem subscribeMsgTmpItem, ISubscribeMsgService.b bVar) {
        AppMethodBeat.i(223251);
        p.h(str, "bizUsername");
        p.h(subscribeMsgTmpItem, "tmpItem");
        c cVar = this.jzx;
        f fVar = new f(this, subscribeMsgTmpItem, bVar);
        p.h(str, "bizUsername");
        p.h(subscribeMsgTmpItem, "tmpItem");
        p.h(fVar, "callback");
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus templateId: %s, settingStatus: %d, switchOpened: %b", subscribeMsgTmpItem.ixM, Integer.valueOf(subscribeMsgTmpItem.jyB), Boolean.valueOf(subscribeMsgTmpItem.VC));
        ArrayList ac = j.ac(subscribeMsgTmpItem);
        ISubscribeMsgService iSubscribeMsgService = cVar.jzJ;
        if (iSubscribeMsgService != null) {
            ISubscribeMsgService.a.a(iSubscribeMsgService, str, ac);
        }
        com.tencent.mm.msgsubscription.api.c cVar2 = new com.tencent.mm.msgsubscription.api.c();
        cVar2.setUsername(str);
        cVar2.jyV.addAll(ac);
        cVar2.jzb = subscribeMsgTmpItem.VC;
        cVar2.jze = new c.d(cVar, subscribeMsgTmpItem, fVar, str);
        ISubscribeMsgService iSubscribeMsgService2 = cVar.jzJ;
        if (iSubscribeMsgService2 != null) {
            iSubscribeMsgService2.a(cVar2);
            AppMethodBeat.o(223251);
            return;
        }
        AppMethodBeat.o(223251);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final SubscribeMsgTmpItem bF(String str, String str2) {
        AppMethodBeat.i(223252);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        com.tencent.mm.msgsubscription.d.a aVar = bVar.jAB;
        if (aVar != null) {
            SubscribeMsgTmpItem bI = aVar.bI(str, str2);
            AppMethodBeat.o(223252);
            return bI;
        }
        AppMethodBeat.o(223252);
        return null;
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final boolean Rt(String str) {
        AppMethodBeat.i(223253);
        p.h(str, "bizUsername");
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, "bizUsername");
        com.tencent.mm.msgsubscription.d.a aVar = bVar.jAB;
        if (aVar != null) {
            boolean Rz = aVar.Rz(str);
            AppMethodBeat.o(223253);
            return Rz;
        }
        AppMethodBeat.o(223253);
        return false;
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void b(String str, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223254);
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, ch.COL_USERNAME);
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getLocalSubscribeList username: %s", str);
        if (bVar.jAB == null) {
            AppMethodBeat.o(223254);
            return;
        }
        com.tencent.mm.msgsubscription.d.d dVar = com.tencent.mm.msgsubscription.d.d.jAR;
        com.tencent.mm.msgsubscription.d.d.a(bVar.jAB, new com.tencent.mm.msgsubscription.e.c(str, bVar.jAB, aVar));
        AppMethodBeat.o(223254);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public void a(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(223255);
        p.h(str, "bizUsername");
        p.h(list, "subscribeMsgList");
        this.jzw.a(str, list, z, z2, z3);
        AppMethodBeat.o(223255);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void g(String str, String str2, long j2) {
        AppMethodBeat.i(223256);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        if (bVar.jAB == null) {
            AppMethodBeat.o(223256);
            return;
        }
        com.tencent.mm.msgsubscription.d.d dVar = com.tencent.mm.msgsubscription.d.d.jAR;
        com.tencent.mm.msgsubscription.d.a aVar = bVar.jAB;
        ArrayList arrayList = new ArrayList();
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateGetSubscribeMsgUiStatusTimestamp timestamp: %s", Long.valueOf(j2));
        arrayList.add(new SubscribeMsgTmpItem(str2, j2));
        com.tencent.mm.msgsubscription.d.d.a(aVar, new i(str, arrayList, bVar.jAB, (byte) 0));
        AppMethodBeat.o(223256);
    }

    public void Z(String str, boolean z) {
        AppMethodBeat.i(223257);
        p.h(str, "bizUsername");
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", str, Boolean.valueOf(z));
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, ch.COL_USERNAME);
        bVar.a(str, new ArrayList(), z, true, false);
        AppMethodBeat.o(223257);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(String str, List<String> list, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223258);
        p.h(str, ch.COL_USERNAME);
        p.h(list, "templateIdList");
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, ch.COL_USERNAME);
        p.h(list, "templateIdList");
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeStatus username: %s, template size: %d", str, Integer.valueOf(list.size()));
        if (bVar.jAB == null) {
            AppMethodBeat.o(223258);
            return;
        }
        com.tencent.mm.msgsubscription.d.d dVar = com.tencent.mm.msgsubscription.d.d.jAR;
        com.tencent.mm.msgsubscription.d.d.a(bVar.jAB, new com.tencent.mm.msgsubscription.e.e(str, list, bVar.jAB, aVar));
        AppMethodBeat.o(223258);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(String str, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223259);
        p.h(str, ch.COL_USERNAME);
        this.jzw.a(str, aVar);
        AppMethodBeat.o(223259);
    }

    public final void a(String str, String str2, List<String> list, String str3, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223260);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "subscribeUrl");
        p.h(list, "templateIdList");
        p.h(str3, IssueStorage.COLUMN_EXT_INFO);
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "subscribeUrl");
        p.h(list, "templateIdList");
        p.h(str3, IssueStorage.COLUMN_EXT_INFO);
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByUsername username: %s, url: %s, templateIdList size: %s", str, str2, Integer.valueOf(list.size()));
        if (bVar.jAB == null) {
            AppMethodBeat.o(223260);
            return;
        }
        com.tencent.mm.msgsubscription.d.d dVar = com.tencent.mm.msgsubscription.d.d.jAR;
        com.tencent.mm.msgsubscription.d.d.a(bVar.jAB, new com.tencent.mm.msgsubscription.e.d(str, "", str2, list, str3, bVar.jAB, aVar));
        AppMethodBeat.o(223260);
    }

    public final void b(String str, String str2, List<String> list, String str3, com.tencent.mm.msgsubscription.api.a aVar) {
        AppMethodBeat.i(223261);
        p.h(str, "appId");
        p.h(str2, "subscribeUrl");
        p.h(list, "templateIdList");
        p.h(str3, IssueStorage.COLUMN_EXT_INFO);
        com.tencent.mm.msgsubscription.d.b bVar = this.jzw;
        p.h(str, "appId");
        p.h(str2, "subscribeUrl");
        p.h(list, "templateIdList");
        p.h(str3, IssueStorage.COLUMN_EXT_INFO);
        Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByAppId appId: %s, url: %s, templateIdList size: %s", str, str2, Integer.valueOf(list.size()));
        if (bVar.jAB == null) {
            AppMethodBeat.o(223261);
            return;
        }
        com.tencent.mm.msgsubscription.d.d dVar = com.tencent.mm.msgsubscription.d.d.jAR;
        com.tencent.mm.msgsubscription.d.d.a(bVar.jAB, new com.tencent.mm.msgsubscription.e.d("", str, str2, list, str3, bVar.jAB, aVar));
        AppMethodBeat.o(223261);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public final void a(com.tencent.mm.msgsubscription.api.c cVar) {
        AppMethodBeat.i(223262);
        p.h(cVar, "updateRequest");
        this.jzw.a(cVar);
        AppMethodBeat.o(223262);
    }

    public void a(Context context, int i2, String str, String str2) {
        AppMethodBeat.i(223263);
        p.h(context, "context");
        p.h(str, "bizUsername");
        p.h(str2, "nickname");
        AppMethodBeat.o(223263);
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public void a(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(223264);
        p.h(context, "context");
        p.h(bundle, "extra");
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s", str, str2);
        if (str == null) {
            AppMethodBeat.o(223264);
        } else if (str2 == null) {
            AppMethodBeat.o(223264);
        } else {
            Intent intent = new Intent(context, SubscribeMsgRequestProxyUI.class);
            intent.putExtra("key_biz_username", str);
            intent.putExtra("key_scene", 1);
            intent.putExtra("key_subscribe_url", str2);
            intent.putExtra("key_action", 3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", 4);
            intent.putExtra("key_extra_info", jSONObject.toString());
            intent.putExtras(bundle);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(223264);
        }
    }

    @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService
    public void a(Context context, int i2, int i3, String str, Bundle bundle) {
        AppMethodBeat.i(223265);
        p.h(context, "context");
        p.h(str, "bizAppId");
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult scene: %d, bizAppId: %s, requestCode: %s", Integer.valueOf(i2), str, Integer.valueOf(i3));
        Intent intent = new Intent(context, SubscribeMsgRequestProxyUI.class);
        intent.putExtra("key_need_result", true);
        intent.putExtra("key_biz_app_id", str);
        intent.putExtra("key_scene", i2);
        intent.putExtra("key_action", 3);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
            AppMethodBeat.o(223265);
            return;
        }
        Log.e("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult context is not activity");
        AppMethodBeat.o(223265);
    }

    private static void b(String str, kotlin.g.a.b<? super ISubscribeMsgService.b, x> bVar) {
        Set<String> set;
        Integer num = null;
        AppMethodBeat.i(223266);
        HashMap<String, ISubscribeMsgService.b> hashMap = jzy.get(str);
        if (hashMap != null) {
            set = hashMap.keySet();
        } else {
            set = null;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (set != null) {
            num = Integer.valueOf(set.size());
        }
        objArr[1] = num;
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo callbackWrapper templateId: %s, callback size: %s", objArr);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                bVar.invoke(hashMap.get(it.next()));
            }
            AppMethodBeat.o(223266);
            return;
        }
        AppMethodBeat.o(223266);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;)V", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-comm_release"})
    public static final class b {
        private final int dTD;
        final String dVu;
        final String ixM;
        ISubscribeMsgService.b jzA;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.dTD == r4.dTD) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 223242(0x3680a, float:3.12829E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.msgsubscription.b.a.b
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.msgsubscription.b.a$b r4 = (com.tencent.mm.msgsubscription.b.a.b) r4
                java.lang.String r0 = r3.dVu
                java.lang.String r1 = r4.dVu
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.ixM
                java.lang.String r1 = r4.ixM
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                int r0 = r3.dTD
                int r1 = r4.dTD
                if (r0 != r1) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.msgsubscription.b.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(223241);
            String str = this.dVu;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.ixM;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = ((hashCode + i2) * 31) + this.dTD;
            AppMethodBeat.o(223241);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(223240);
            String str = "UpdateSubscribeStatusTask(bizUsername=" + this.dVu + ", templateId=" + this.ixM + ", uiStatus=" + this.dTD + ")";
            AppMethodBeat.o(223240);
            return str;
        }

        public b(String str, String str2, int i2) {
            p.h(str, "bizUsername");
            p.h(str2, "templateId");
            AppMethodBeat.i(223239);
            this.dVu = str;
            this.ixM = str2;
            this.dTD = i2;
            AppMethodBeat.o(223239);
        }
    }

    public static final /* synthetic */ void b(String str, ISubscribeMsgService.c cVar) {
        AppMethodBeat.i(223269);
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo onUpdatedWrapper templateId: %s, isSubscribed: %b, switchOpen: %b", str, Boolean.valueOf(cVar.jyX), Boolean.valueOf(cVar.jyY));
        b(str, new e(str, cVar));
        AppMethodBeat.o(223269);
    }

    public static final /* synthetic */ void Rw(String str) {
        AppMethodBeat.i(223270);
        b(str, d.jzD);
        AppMethodBeat.o(223270);
    }
}
