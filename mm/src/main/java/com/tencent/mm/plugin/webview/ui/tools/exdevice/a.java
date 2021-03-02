package com.tencent.mm.plugin.webview.ui.tools.exdevice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements y.a {
    private static a JmC;
    private static String ics = "lan";
    public byte[] ISs = null;
    public boolean ISu = false;
    public C1984a JmB;
    private int JmD = -1;
    public String brandName;
    public boolean hasInit = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.exdevice.a$a  reason: collision with other inner class name */
    public static class C1984a {
        private f ISw = null;
        public IListener ISz = new IListener<ep>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.exdevice.a.C1984a.AnonymousClass1 */

            {
                AppMethodBeat.i(160450);
                this.__eventId = ep.class.getName().hashCode();
                AppMethodBeat.o(160450);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ep epVar) {
                AppMethodBeat.i(80479);
                boolean h2 = C1984a.this.h(epVar);
                AppMethodBeat.o(80479);
                return h2;
            }
        };
        public IListener JmE = new IListener<ej>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.exdevice.a.C1984a.AnonymousClass2 */

            {
                AppMethodBeat.i(160451);
                this.__eventId = ej.class.getName().hashCode();
                AppMethodBeat.o(160451);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ej ejVar) {
                AppMethodBeat.i(80480);
                boolean h2 = C1984a.this.h(ejVar);
                AppMethodBeat.o(80480);
                return h2;
            }
        };
        public IListener JmF = new IListener<ek>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.exdevice.a.C1984a.AnonymousClass3 */

            {
                AppMethodBeat.i(160452);
                this.__eventId = ek.class.getName().hashCode();
                AppMethodBeat.o(160452);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ek ekVar) {
                AppMethodBeat.i(80481);
                boolean h2 = C1984a.this.h(ekVar);
                AppMethodBeat.o(80481);
                return h2;
            }
        };
        public IListener JmG = new IListener<el>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.exdevice.a.C1984a.AnonymousClass4 */

            {
                AppMethodBeat.i(160453);
                this.__eventId = el.class.getName().hashCode();
                AppMethodBeat.o(160453);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(el elVar) {
                AppMethodBeat.i(80482);
                boolean h2 = C1984a.this.h(elVar);
                AppMethodBeat.o(80482);
                return h2;
            }
        };
        public IListener JmH = new IListener<em>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.exdevice.a.C1984a.AnonymousClass5 */

            {
                AppMethodBeat.i(160454);
                this.__eventId = em.class.getName().hashCode();
                AppMethodBeat.o(160454);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(em emVar) {
                AppMethodBeat.i(80483);
                boolean h2 = C1984a.this.h(emVar);
                AppMethodBeat.o(80483);
                return h2;
            }
        };
        private String brandName = "";

        public C1984a(f fVar, String str) {
            AppMethodBeat.i(80484);
            this.ISw = fVar;
            this.brandName = str;
            AppMethodBeat.o(80484);
        }

        /* access modifiers changed from: package-private */
        public final boolean h(IEvent iEvent) {
            AppMethodBeat.i(80485);
            if (iEvent == null) {
                AppMethodBeat.o(80485);
                return false;
            } else if (this.ISw == null) {
                Log.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                AppMethodBeat.o(80485);
                return false;
            } else {
                try {
                    if (iEvent instanceof ep) {
                        Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        ep epVar = (ep) iEvent;
                        if (Util.isNullOrNil(epVar.dHX.dGL)) {
                            AppMethodBeat.o(80485);
                            return true;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("exdevice_device_id", epVar.dHX.dGL);
                        bundle.putBoolean("exdevice_is_bound", epVar.dHX.dGT);
                        this.ISw.f(17, bundle);
                    } else if (iEvent instanceof ej) {
                        Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                        ej ejVar = (ej) iEvent;
                        if (Util.isNullOrNil(ejVar.dHN.dGL) || !this.brandName.equals(ejVar.dHN.brandName)) {
                            AppMethodBeat.o(80485);
                            return true;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("exdevice_device_id", ejVar.dHN.dGL);
                        bundle2.putInt("exdevice_on_state_change_state", ejVar.dHN.dHO);
                        bundle2.putString("exdevice_device_type", a.ics);
                        this.ISw.f(1004, bundle2);
                    } else if (iEvent instanceof ek) {
                        Log.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                        ek ekVar = (ek) iEvent;
                        if (Util.isNullOrNil(ekVar.dHP.dGL) || Util.isNullOrNil(ekVar.dHP.brandName) || ekVar.dHP.data == null) {
                            AppMethodBeat.o(80485);
                            return true;
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("exdevice_device_id", ekVar.dHP.dGL);
                        bundle3.putByteArray("exdevice_data", ekVar.dHP.data);
                        bundle3.putString("exdevice_brand_name", ekVar.dHP.brandName);
                        bundle3.putString("exdevice_device_type", a.ics);
                        this.ISw.f(16, bundle3);
                    } else if (iEvent instanceof el) {
                        Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                        el elVar = (el) iEvent;
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("exdevice_device_id", elVar.dHQ.dGL);
                        bundle4.putByteArray("exdevice_broadcast_data", elVar.dHQ.dHR);
                        bundle4.putBoolean("exdevice_is_complete", elVar.dHQ.brW);
                        bundle4.putBoolean("exdevice_is_lan_device", true);
                        bundle4.putString("exdevice_device_type", a.ics);
                        this.ISw.f(15, bundle4);
                    } else if (iEvent instanceof em) {
                        Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                        Bundle bundle5 = new Bundle();
                        if (((em) iEvent).dHS.dHT) {
                            bundle5.putBoolean("exdevice_lan_state", true);
                        } else {
                            bundle5.putBoolean("exdevice_lan_state", false);
                        }
                        this.ISw.f(47, bundle5);
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", e2.getMessage());
                }
                AppMethodBeat.o(80485);
                return true;
            }
        }
    }

    private a() {
    }

    public static a ggx() {
        AppMethodBeat.i(80486);
        if (JmC == null) {
            JmC = new a();
        }
        a aVar = JmC;
        AppMethodBeat.o(80486);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbt() {
        AppMethodBeat.i(80487);
        Log.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.ISu));
        if (this.ISu) {
            fk fkVar = new fk();
            fkVar.dIK.dGW = false;
            EventCenter.instance.publish(fkVar);
            this.ISu = false;
        }
        this.hasInit = false;
        if (this.JmB != null) {
            EventCenter.instance.removeListener(this.JmB.ISz);
            EventCenter.instance.removeListener(this.JmB.JmE);
            EventCenter.instance.removeListener(this.JmB.JmG);
            EventCenter.instance.removeListener(this.JmB.JmF);
            EventCenter.instance.removeListener(this.JmB.JmH);
            this.JmB = null;
        }
        this.ISs = null;
        et etVar = new et();
        etVar.dIb.dGW = false;
        EventCenter.instance.publish(etVar);
        AppMethodBeat.o(80487);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void hU(Context context) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbu() {
    }
}
