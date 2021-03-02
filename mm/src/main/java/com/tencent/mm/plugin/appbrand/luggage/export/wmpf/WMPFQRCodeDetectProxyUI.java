package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFAccessibleProvider;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J$\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activityStarted", "", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "startActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "options", "Companion", "plugin-appbrand-integration_release"})
public final class WMPFQRCodeDetectProxyUI extends MMActivity {
    public static final a ncG = new a((byte) 0);
    private HashMap _$_findViewCache;
    private boolean ncF;

    static {
        AppMethodBeat.i(229048);
        AppMethodBeat.o(229048);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229050);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229050);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229049);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229049);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion;", "", "()V", "KEY_QRCODE_PATH", "", "TAG", "waitFor", "", "context", "Landroid/content/Context;", "qrcodePath", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(229040);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onCreate " + hashCode());
        super.onCreate(bundle);
        WMPFAccessibleProvider.a aVar = WMPFAccessibleProvider.ncC;
        if (!WMPFAccessibleProvider.bOP()) {
            finish();
            AppMethodBeat.o(229040);
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("KEY_QRCODE_PATH") : null;
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || !s.YS(stringExtra)) {
            finish();
            AppMethodBeat.o(229040);
            return;
        }
        h.a((Context) this, "", false, (DialogInterface.OnCancelListener) c.ncJ);
        qx qxVar = new qx();
        EventCenter.instance.add(new b(this, stringExtra));
        qxVar.dXu.dDZ = System.currentTimeMillis();
        qxVar.dXu.filePath = stringExtra;
        qxVar.dXu.dXv = new HashSet();
        EventCenter.instance.publish(qxVar);
        AppMethodBeat.o(229040);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class c implements DialogInterface.OnCancelListener {
        public static final c ncJ = new c();

        static {
            AppMethodBeat.i(229039);
            AppMethodBeat.o(229039);
        }

        c() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$onCreate$2$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class b extends IListener<qz> {
        final /* synthetic */ WMPFQRCodeDetectProxyUI ncH;
        final /* synthetic */ String ncI;

        b(WMPFQRCodeDetectProxyUI wMPFQRCodeDetectProxyUI, String str) {
            this.ncH = wMPFQRCodeDetectProxyUI;
            this.ncI = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            qz.a aVar;
            AppMethodBeat.i(229038);
            qz qzVar2 = qzVar;
            if (p.j(this.ncI, (qzVar2 == null || (aVar = qzVar2.dXz) == null) ? null : aVar.filePath)) {
                int i2 = qzVar2.dXz.dFL;
                String str = qzVar2.dXz.result;
                int i3 = qzVar2.dXz.dFM;
                cr crVar = new cr();
                crVar.dFK.activity = this.ncH;
                crVar.dFK.dDX = str;
                crVar.dFK.dFL = i2;
                crVar.dFK.dFM = i3;
                crVar.dFK.scene = 4;
                EventCenter.instance.publish(crVar);
                AppMethodBeat.o(229038);
                return true;
            }
            AppMethodBeat.o(229038);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(229041);
        super.startActivityForResult(intent, i2, bundle);
        this.ncF = true;
        AppMethodBeat.o(229041);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(229042);
        super.startActivityForResult(intent, i2);
        this.ncF = true;
        AppMethodBeat.o(229042);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(229043);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onResume() " + hashCode());
        super.onResume();
        if (this.ncF) {
            moveTaskToBack(true);
            finish();
        }
        AppMethodBeat.o(229043);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(229044);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onStart() " + hashCode());
        super.onStart();
        if (this.ncF) {
            moveTaskToBack(true);
            finish();
        }
        AppMethodBeat.o(229044);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(229045);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onPause() " + hashCode());
        super.onPause();
        AppMethodBeat.o(229045);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(229046);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onDestroy() " + hashCode());
        super.onDestroy();
        AppMethodBeat.o(229046);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(229047);
        Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "finish() " + hashCode() + ' ' + android.util.Log.getStackTraceString(new Throwable()));
        super.finish();
        AppMethodBeat.o(229047);
    }
}
