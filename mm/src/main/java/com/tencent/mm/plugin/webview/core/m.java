package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.i.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class m {
    private static final Map<String, LinkedList<a>> INb = new HashMap();
    public static final m INc = new m();
    private static final int MAX = 3;
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(225084);
        AppMethodBeat.o(225084);
    }

    private m() {
    }

    public static final /* synthetic */ LinkedList aZ(Class cls) {
        AppMethodBeat.i(225085);
        LinkedList<a> aY = aY(cls);
        AppMethodBeat.o(225085);
        return aY;
    }

    private static LinkedList<a> aY(Class<? extends Service> cls) {
        AppMethodBeat.i(225082);
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            p.hyc();
        }
        p.g(canonicalName, "stubService.canonicalName!!");
        LinkedList<a> linkedList = INb.get(canonicalName);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            INb.put(canonicalName, linkedList);
        }
        AppMethodBeat.o(225082);
        return linkedList;
    }

    public static void a(boolean z, Class<? extends Service> cls, d dVar) {
        a aVar;
        AppMethodBeat.i(225083);
        p.h(cls, "stubService");
        p.h(dVar, "binder");
        if (z) {
            if (!aY(cls).isEmpty()) {
                a pop = aY(cls).pop();
                b.gdS();
                Log.i(TAG, "reuse service");
                aVar = pop;
                p.h(dVar, "binder");
                aVar.INd = dVar;
                aVar.bDD();
                Log.i(TAG, "attach service");
                AppMethodBeat.o(225083);
            }
        }
        a aVar2 = new a(z, cls);
        Context context = MMApplicationContext.getContext();
        context.bindService(new Intent(context, cls), aVar2, 1);
        if (z) {
            b.gdR();
        }
        Log.i(TAG, "bind new service");
        aVar = aVar2;
        p.h(dVar, "binder");
        aVar.INd = dVar;
        aVar.bDD();
        Log.i(TAG, "attach service");
        AppMethodBeat.o(225083);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0017J\u001c\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
    public static final class a implements ServiceConnection {
        final boolean CVS;
        final Class<? extends Service> IBu;
        d INd;
        e mHh;

        public a(boolean z, Class<? extends Service> cls) {
            p.h(cls, "stubService");
            AppMethodBeat.i(225081);
            this.CVS = z;
            this.IBu = cls;
            AppMethodBeat.o(225081);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(225078);
            m mVar = m.INc;
            Log.i(m.TAG, "disconnected:".concat(String.valueOf(componentName)));
            this.mHh = null;
            d dVar = this.INd;
            if (dVar != null && dVar.fXa()) {
                m mVar2 = m.INc;
                m.a(this.CVS, this.IBu, dVar);
            }
            this.INd = null;
            m mVar3 = m.INc;
            m.aZ(this.IBu).remove(this);
            AppMethodBeat.o(225078);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(225079);
            m mVar = m.INc;
            Log.i(m.TAG, "connected:".concat(String.valueOf(componentName)));
            this.mHh = e.a.H(iBinder);
            bDD();
            AppMethodBeat.o(225079);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.webview.core.m$a$a  reason: collision with other inner class name */
        public static final class C1947a implements c {
            final /* synthetic */ a INe;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1947a(a aVar) {
                this.INe = aVar;
            }

            @Override // com.tencent.mm.plugin.webview.core.c
            public final e fZs() {
                AppMethodBeat.i(225076);
                e eVar = this.INe.mHh;
                if (eVar == null) {
                    p.hyc();
                }
                AppMethodBeat.o(225076);
                return eVar;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                AppMethodBeat.i(225077);
                a aVar = this.INe;
                aVar.INd = null;
                if (aVar.CVS) {
                    m mVar = m.INc;
                    int size = m.aZ(aVar.IBu).size();
                    m mVar2 = m.INc;
                    if (size < m.MAX) {
                        m mVar3 = m.INc;
                        m.aZ(aVar.IBu).add(aVar);
                        m mVar4 = m.INc;
                        Log.i(m.TAG, "detach with reuse service");
                        AppMethodBeat.o(225077);
                        return;
                    }
                }
                MMApplicationContext.getContext().unbindService(aVar);
                m mVar5 = m.INc;
                Log.i(m.TAG, "detach unbind service");
                AppMethodBeat.o(225077);
            }
        }

        /* access modifiers changed from: package-private */
        public final void bDD() {
            d dVar;
            AppMethodBeat.i(225080);
            if (this.mHh == null || (dVar = this.INd) == null) {
                AppMethodBeat.o(225080);
                return;
            }
            dVar.a(new C1947a(this));
            AppMethodBeat.o(225080);
        }
    }
}
