package com.tencent.mm.plugin.webview.d.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.or;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements y.a {
    private static a ISr;
    private static final byte[] rAD = {-2, 1, 1};
    public C1949a ISq;
    public byte[] ISs = null;
    public int ISt = -1;
    public boolean ISu = false;
    public boolean ISv = false;
    public String brandName;
    public boolean hasInit = false;

    /* renamed from: com.tencent.mm.plugin.webview.d.a.a$a  reason: collision with other inner class name */
    public static class C1949a {
        public IListener Dlh = new IListener<eo>() {
            /* class com.tencent.mm.plugin.webview.d.a.a.C1949a.AnonymousClass5 */

            {
                AppMethodBeat.i(224447);
                this.__eventId = eo.class.getName().hashCode();
                AppMethodBeat.o(224447);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(eo eoVar) {
                AppMethodBeat.i(224448);
                boolean h2 = C1949a.this.h(eoVar);
                AppMethodBeat.o(224448);
                return h2;
            }
        };
        public IListener ISA = new IListener<or>() {
            /* class com.tencent.mm.plugin.webview.d.a.a.C1949a.AnonymousClass4 */

            {
                AppMethodBeat.i(224445);
                this.__eventId = or.class.getName().hashCode();
                AppMethodBeat.o(224445);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(or orVar) {
                AppMethodBeat.i(224446);
                boolean h2 = C1949a.this.h(orVar);
                AppMethodBeat.o(224446);
                return h2;
            }
        };
        private f ISw = null;
        public IListener ISx = new IListener<er>() {
            /* class com.tencent.mm.plugin.webview.d.a.a.C1949a.AnonymousClass1 */

            {
                AppMethodBeat.i(224439);
                this.__eventId = er.class.getName().hashCode();
                AppMethodBeat.o(224439);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(er erVar) {
                AppMethodBeat.i(224440);
                boolean h2 = C1949a.this.h(erVar);
                AppMethodBeat.o(224440);
                return h2;
            }
        };
        public IListener ISy = new IListener<eq>() {
            /* class com.tencent.mm.plugin.webview.d.a.a.C1949a.AnonymousClass2 */

            {
                AppMethodBeat.i(224441);
                this.__eventId = eq.class.getName().hashCode();
                AppMethodBeat.o(224441);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(eq eqVar) {
                AppMethodBeat.i(224442);
                boolean h2 = C1949a.this.h(eqVar);
                AppMethodBeat.o(224442);
                return h2;
            }
        };
        public IListener ISz = new IListener<ep>() {
            /* class com.tencent.mm.plugin.webview.d.a.a.C1949a.AnonymousClass3 */

            {
                AppMethodBeat.i(224443);
                this.__eventId = ep.class.getName().hashCode();
                AppMethodBeat.o(224443);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ep epVar) {
                AppMethodBeat.i(224444);
                boolean h2 = C1949a.this.h(epVar);
                AppMethodBeat.o(224444);
                return h2;
            }
        };
        private String brandName = "";

        public C1949a(f fVar, String str) {
            AppMethodBeat.i(224449);
            this.ISw = fVar;
            this.brandName = str;
            AppMethodBeat.o(224449);
        }

        /* access modifiers changed from: package-private */
        public final boolean h(IEvent iEvent) {
            AppMethodBeat.i(224450);
            if (iEvent == null) {
                AppMethodBeat.o(224450);
                return false;
            } else if (this.ISw == null) {
                Log.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                AppMethodBeat.o(224450);
                return false;
            } else {
                try {
                    if (iEvent instanceof er) {
                        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                        er erVar = (er) iEvent;
                        Bundle bundle = new Bundle();
                        bundle.putString("exdevice_device_id", erVar.dHZ.dGL);
                        bundle.putByteArray("exdevice_broadcast_data", erVar.dHZ.dHR);
                        bundle.putBoolean("exdevice_is_complete", erVar.dHZ.brW);
                        this.ISw.f(15, bundle);
                    } else if (iEvent instanceof eq) {
                        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                        eq eqVar = (eq) iEvent;
                        if (Util.isNullOrNil(eqVar.dHY.dGL) || Util.isNullOrNil(eqVar.dHY.brandName) || eqVar.dHY.data == null) {
                            AppMethodBeat.o(224450);
                            return true;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("exdevice_device_id", eqVar.dHY.dGL);
                        bundle2.putByteArray("exdevice_data", eqVar.dHY.data);
                        bundle2.putString("exdevice_brand_name", eqVar.dHY.brandName);
                        this.ISw.f(16, bundle2);
                    } else if (iEvent instanceof ep) {
                        Log.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        ep epVar = (ep) iEvent;
                        if (Util.isNullOrNil(epVar.dHX.dGL)) {
                            AppMethodBeat.o(224450);
                            return true;
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("exdevice_device_id", epVar.dHX.dGL);
                        bundle3.putBoolean("exdevice_is_bound", epVar.dHX.dGT);
                        this.ISw.f(17, bundle3);
                    } else if (iEvent instanceof or) {
                        or orVar = (or) iEvent;
                        if (orVar.dUI.op != 2) {
                            AppMethodBeat.o(224450);
                            return true;
                        } else if (Util.isNullOrNil(orVar.dUI.dRD) || !this.brandName.equals(orVar.dUI.dRD)) {
                            AppMethodBeat.o(224450);
                            return true;
                        } else {
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("exdevice_device_id", orVar.dUI.dGL);
                            bundle4.putInt("exdevice_on_state_change_state", orVar.dUI.dHO);
                            this.ISw.f(1004, bundle4);
                        }
                    } else if (iEvent instanceof eo) {
                        Bundle bundle5 = new Bundle();
                        if (((eo) iEvent).dHV.dHW == 12) {
                            bundle5.putBoolean("exdevice_bt_state", true);
                        } else {
                            bundle5.putBoolean("exdevice_bt_state", false);
                        }
                        this.ISw.f(18, bundle5);
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", e2.getMessage());
                }
                AppMethodBeat.o(224450);
                return true;
            }
        }
    }

    private a() {
    }

    public static a gbs() {
        AppMethodBeat.i(224451);
        if (ISr == null) {
            ISr = new a();
        }
        a aVar = ISr;
        AppMethodBeat.o(224451);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbt() {
        AppMethodBeat.i(224452);
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.ISu));
        if (this.ISu) {
            eu euVar = new eu();
            euVar.dIc.dGW = false;
            euVar.dIc.brandName = this.brandName;
            EventCenter.instance.publish(euVar);
            if (!euVar.dId.dGX) {
                Log.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.ISu = false;
        }
        this.hasInit = false;
        if (this.ISq != null) {
            EventCenter.instance.removeListener(this.ISq.ISx);
            EventCenter.instance.removeListener(this.ISq.ISy);
            EventCenter.instance.removeListener(this.ISq.ISA);
            EventCenter.instance.removeListener(this.ISq.ISz);
            EventCenter.instance.removeListener(this.ISq.Dlh);
            this.ISq = null;
        }
        this.ISs = null;
        fa faVar = new fa();
        faVar.dIs.dGL = "";
        faVar.dIs.direction = 0;
        faVar.dIs.clear = true;
        EventCenter.instance.publish(faVar);
        Log.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", Boolean.valueOf(faVar.dIt.dGX));
        AppMethodBeat.o(224452);
    }

    public static boolean cz(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == 1 && bArr[bArr.length - 8] == 1 && bArr[bArr.length - 9] == -2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void hU(Context context) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbu() {
    }
}
