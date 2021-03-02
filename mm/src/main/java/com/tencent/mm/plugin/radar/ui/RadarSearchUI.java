package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.radar.b.d;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.ui.RadarTipsView;
import com.tencent.mm.plugin.radar.ui.RadarViewController;
import com.tencent.mm.plugin.radar.ui.b;
import com.tencent.mm.plugin.radar.ui.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.ugc.TXRecordCommon;
import java.util.Arrays;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(19)
@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J+\u0010\"\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI extends MMBaseActivity {
    public static final a BzV = new a((byte) 0);
    private static final String TAG = TAG;
    private final f BzT = g.a(k.NONE, new i.a(this));
    private final int BzU = 30764;
    private boolean kgv = true;

    private final RadarViewController eHr() {
        AppMethodBeat.i(138638);
        RadarViewController radarViewController = (RadarViewController) this.BzT.getValue();
        AppMethodBeat.o(138638);
        return radarViewController;
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RadarSearchUI() {
        AppMethodBeat.i(138649);
        p.h(this, "$this$bind");
        AppMethodBeat.o(138649);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(138639);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView(R.layout.bkf);
        RadarViewController eHr = eHr();
        View findViewById = eHr.findViewById(R.id.gq2);
        p.g(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(138639);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = eHr.getContext();
        if (context == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(138639);
            throw tVar2;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        p.g(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView radarTips = eHr.getRadarTips();
        radarTips.getNoviceEducationTips().setOnClickListener(new RadarTipsView.c(radarTips));
        RadarTipsView radarTips2 = eHr.getRadarTips();
        radarTips2.BAP = RadarTipsView.BAS;
        d dVar = d.BzS;
        int eHq = d.eHq();
        radarTips2.BAH.sendEmptyMessageDelayed(radarTips2.BAE, (long) eHq);
        radarTips2.BAH.sendEmptyMessageDelayed(radarTips2.BAD, (long) (eHq + TXRecordCommon.AUDIO_SAMPLERATE_8000));
        eHr.getRadarTips().setPressingDown(true);
        eHr.getQuitBtn().setOnClickListener(eHr.BBm);
        ViewGroup.LayoutParams layoutParams3 = eHr.getQuitBtn().getLayoutParams();
        if (layoutParams3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(138639);
            throw tVar3;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int i2 = layoutParams4.topMargin;
        if (ao.aQ(eHr.getContext())) {
            i2 += ao.aP(eHr.getContext());
        }
        layoutParams4.setMargins(layoutParams4.leftMargin, i2, layoutParams4.rightMargin, layoutParams4.bottomMargin);
        eHr.getQuitBtn().setLayoutParams(layoutParams4);
        RadarWaveView waveView = eHr.getWaveView();
        waveView.BBM = waveView.findViewById(R.id.gqf);
        waveView.BBN = AnimationUtils.loadAnimation(waveView.getContext(), R.anim.e0);
        Animation animation = waveView.BBN;
        if (animation == null) {
            p.hyc();
        }
        animation.setInterpolator(new LinearInterpolator());
        b.a aVar = b.a.Bzu;
        View findViewById2 = eHr.findViewById(R.id.hjr);
        p.g(findViewById2, "findViewById(R.id.self_round_avatar)");
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        b.a.c((ImageView) findViewById2, aTY);
        eHr.getMemberDetailView().setListener(new RadarViewController.e(eHr));
        RadarSpecialGridView grid = eHr.getGrid();
        Context context2 = eHr.getContext();
        p.g(context2, "context");
        eHr.BBj = new RadarViewController.c(eHr, grid, context2);
        eHr.getGrid().setOnItemClickListener(new RadarViewController.h(eHr));
        RadarViewController eHr2 = eHr();
        com.tencent.mm.plugin.radar.b.c cVar = eHr2.BBi;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().add(cVar);
        EventCenter.instance.addListener(cVar.Byh);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah, "plugin(IPluginMessengerFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().a("addcontact", (cj.a) cVar.Byi, true);
        e eVar = eHr2.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        com.tencent.mm.kernel.g.azz().a(425, eVar);
        com.tencent.mm.kernel.g.azz().a(602, eVar);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(229377, (Object) 0);
        if (obj == null) {
            t tVar4 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(138639);
            throw tVar4;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(229377, Integer.valueOf(((Integer) obj).intValue() + 1));
        AppMethodBeat.o(138639);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onResume() {
        AppMethodBeat.i(138640);
        super.onResume();
        if (this.kgv) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(274436);
            if (!(obj instanceof String)) {
                obj = null;
            }
            if (!com.tencent.mm.aw.b.Pi((String) obj)) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, (String) null, (String) null);
                Log.i(TAG, "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    AppMethodBeat.o(138640);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                Object obj2 = aAh2.azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(138640);
                    throw tVar;
                } else if (!((Boolean) obj2).booleanValue()) {
                    com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.el_, new Object[]{LocaleUtil.getApplicationLanguage()}), this.BzU, true);
                    AppMethodBeat.o(138640);
                    return;
                } else {
                    com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
                    AppMethodBeat.o(138640);
                    return;
                }
            }
            eHs();
        }
        AppMethodBeat.o(138640);
    }

    private final void eHs() {
        AppMethodBeat.i(138641);
        sW(true);
        d dVar = d.ByH;
        d.eHg();
        d dVar2 = d.ByH;
        d.eHh();
        if (eHr().getRadarStatus() == e.EnumC1621e.SEARCHING || eHr().getRadarStatus() == e.EnumC1621e.SEARCH_RETRUN) {
            eHr().onResume();
            eHr().eHj();
            eHr().getWaveView().eHD();
        }
        AppMethodBeat.o(138641);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(138642);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (iArr.length <= 0) {
            String str = TAG;
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i(str, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(currentThread.getId()));
            AppMethodBeat.o(138642);
            return;
        }
        String str2 = TAG;
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i(str2, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(currentThread2.getId()));
        switch (i2) {
            case 64:
                if (iArr[0] != 0) {
                    this.kgv = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.fl1), false, (DialogInterface.OnClickListener) new b(this), (DialogInterface.OnClickListener) new c(this));
                    break;
                } else {
                    eHs();
                    AppMethodBeat.o(138642);
                    return;
                }
        }
        AppMethodBeat.o(138642);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarSearchUI BzW;

        b(RadarSearchUI radarSearchUI) {
            this.BzW = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(138635);
            RadarSearchUI radarSearchUI = this.BzW;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(radarSearchUI, bl.axQ(), "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            radarSearchUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(radarSearchUI, "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.BzW.kgv = true;
            this.BzW.finish();
            AppMethodBeat.o(138635);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarSearchUI BzW;

        c(RadarSearchUI radarSearchUI) {
            this.BzW = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(138636);
            this.BzW.kgv = true;
            this.BzW.finish();
            AppMethodBeat.o(138636);
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onPause() {
        boolean z;
        AppMethodBeat.i(138643);
        super.onPause();
        sW(false);
        d dVar = d.ByH;
        if (d.ByD != 0) {
            long eHi = d.eHi() - d.ByD;
            d dVar2 = d.BzS;
            if (!d.HO(eHi)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i2 = d.dRN;
                Log.d(d.TAG, "FoundFriendsCnt %d", Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                ae aeVar = ae.SYK;
                String format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                hVar.kvStat(10679, format);
                d.ByA++;
                d.ByB = eHi + d.ByB;
                d.ByD = 0;
            }
        }
        d dVar3 = d.ByH;
        if (d.ByC != 0) {
            long currentTimeMillis = System.currentTimeMillis() - d.ByC;
            int i3 = d.ByA;
            float f2 = (((float) d.ByB) * 1.0f) / 1000.0f;
            int i4 = d.ByE;
            float f3 = (((float) currentTimeMillis) * 1.0f) / 1000.0f;
            Log.d(d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", 1, Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Float.valueOf(f3));
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            ae aeVar2 = ae.SYK;
            String format2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{1, Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Float.valueOf(f3)}, 5));
            p.g(format2, "java.lang.String.format(format, *args)");
            hVar2.kvStat(10676, format2);
        }
        if (eHr().getRadarStatus() == e.EnumC1621e.SEARCHING || eHr().getRadarStatus() == e.EnumC1621e.SEARCH_RETRUN) {
            e eVar = eHr().BBh;
            if (eVar == null) {
                p.btv("radarManager");
            }
            eVar.eHk();
            e eVar2 = eHr().BBh;
            if (eVar2 == null) {
                p.btv("radarManager");
            }
            com.tencent.mm.modelgeo.d dVar4 = eVar2.iOv;
            if (dVar4 != null) {
                dVar4.c(eVar2.gmA);
            }
            eHr().getWaveView().eHE();
        }
        AppMethodBeat.o(138643);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onDestroy() {
        AppMethodBeat.i(138644);
        RadarViewController eHr = eHr();
        com.tencent.mm.plugin.radar.b.c cVar = eHr.BBi;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().remove(cVar);
        EventCenter.instance.removeListener(cVar.Byh);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(s.class);
        p.g(ah, "plugin(IPluginMessengerFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().b("addcontact", cVar.Byi, true);
        e eVar = eHr.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        com.tencent.mm.kernel.g.azz().b(425, eVar);
        com.tencent.mm.kernel.g.azz().b(602, eVar);
        eVar.stop();
        com.tencent.mm.modelgeo.d dVar = eVar.iOv;
        if (dVar != null) {
            dVar.c(eVar.gmA);
        }
        RadarWaveView waveView = eHr.getWaveView();
        try {
            MediaPlayer mediaPlayer = waveView.BBL;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            waveView.BBL = null;
        } catch (Exception e2) {
            Log.printErrStackTrace(RadarWaveView.TAG, e2, "", new Object[0]);
            Log.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            waveView.BBL = null;
        }
        super.onDestroy();
        AppMethodBeat.o(138644);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(138645);
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.BzU) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    this.kgv = true;
                    finish();
                    AppMethodBeat.o(138645);
                    return;
                }
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
                this.kgv = false;
                AppMethodBeat.o(138645);
                return;
            }
            this.kgv = true;
            finish();
        }
        AppMethodBeat.o(138645);
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(138646);
        p.h(keyEvent, "event");
        boolean onKeyDown = eHr().onKeyDown(i2, keyEvent);
        if (onKeyDown) {
            AppMethodBeat.o(138646);
            return onKeyDown;
        }
        boolean onKeyDown2 = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(138646);
        return onKeyDown2;
    }

    private static void sW(boolean z) {
        AppMethodBeat.i(138647);
        xs xsVar = new xs();
        xsVar.edZ.eea = z;
        EventCenter.instance.publish(xsVar);
        AppMethodBeat.o(138647);
    }

    @Override // android.content.Context, com.tencent.mm.ui.MMBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public final Object getSystemService(String str) {
        AppMethodBeat.i(138648);
        p.h(str, "name");
        Object systemService = super.getSystemService(str);
        if (systemService == null || !p.j("layout_inflater", str)) {
            AppMethodBeat.o(138648);
            return systemService;
        }
        LayoutInflater b2 = aa.b((LayoutInflater) systemService);
        AppMethodBeat.o(138648);
        return b2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138637);
        AppMethodBeat.o(138637);
    }
}
