package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.g.b.p;
import kotlin.x;

public final class w implements t {
    public static final a BRE = new a((byte) 0);
    private Future<?> BRA;
    public boolean BRB = true;
    public int BRC = R.string.fw6;
    private String BRD = "";
    private final View BRr;
    public int BRs = 10000;
    public int BRt = this.BRs;
    private boolean BRu;
    private final int BRv = 500;
    private long BRw = -1;
    private boolean BRx;
    public boolean BRy;
    public kotlin.g.a.b<? super ArrayList<Float>, x> BRz;
    private int gLS;
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    public final TextView rsX;
    private final Runnable rtb = new c(this);
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private RelativeLayout yIR;
    public MMSightRecordButton zCQ;

    static {
        AppMethodBeat.i(237340);
        AppMethodBeat.o(237340);
    }

    public w(RelativeLayout relativeLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(relativeLayout, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(75629);
        this.yIR = relativeLayout;
        this.wgr = dVar;
        View findViewById = this.yIR.findViewById(R.id.gwh);
        p.g(findViewById, "layout.findViewById(R.id.record_button)");
        this.zCQ = (MMSightRecordButton) findViewById;
        View findViewById2 = this.yIR.findViewById(R.id.aje);
        p.g(findViewById2, "layout.findViewById(R.id.capture_hint)");
        this.rsX = (TextView) findViewById2;
        View findViewById3 = this.yIR.findViewById(R.id.ajf);
        p.g(findViewById3, "layout.findViewById(R.id.capture_permission_jump)");
        this.BRr = findViewById3;
        this.zCQ.setSimpleTapCallback(new MMSightRecordButton.d(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.w.AnonymousClass1 */
            final /* synthetic */ w BRF;

            {
                this.BRF = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d
            public final void cJK() {
                AppMethodBeat.i(75613);
                w.a(this.BRF);
                AppMethodBeat.o(75613);
            }
        });
        AppMethodBeat.o(75629);
    }

    public static final /* synthetic */ void b(w wVar, boolean z) {
        AppMethodBeat.i(237342);
        wVar.te(z);
        AppMethodBeat.o(237342);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237341);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237341);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ w BRF;

        c(w wVar) {
            this.BRF = wVar;
        }

        public final void run() {
            AppMethodBeat.i(75615);
            this.BRF.rsX.animate().alpha(0.0f).withEndAction(new Runnable(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.w.c.AnonymousClass1 */
                final /* synthetic */ c BRG;

                {
                    this.BRG = r1;
                }

                public final void run() {
                    AppMethodBeat.i(75614);
                    this.BRG.BRF.rsX.setVisibility(4);
                    AppMethodBeat.o(75614);
                }
            }).start();
            AppMethodBeat.o(75615);
        }
    }

    public final void td(boolean z) {
        AppMethodBeat.i(237318);
        this.BRu = z;
        if (this.BRu) {
            this.rsX.setText(R.string.f0y);
            this.zCQ.setSimpleTapCallback(new b(this));
            AppMethodBeat.o(237318);
            return;
        }
        this.rsX.setText(R.string.f0z);
        this.zCQ.setSimpleTapCallback(null);
        AppMethodBeat.o(237318);
    }

    public static final class b implements MMSightRecordButton.d {
        final /* synthetic */ w BRF;

        b(w wVar) {
            this.BRF = wVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d
        public final void cJK() {
            AppMethodBeat.i(237304);
            if (this.BRF.BRw == -1 || Util.ticksToNow(this.BRF.BRw) > ((long) this.BRF.BRv)) {
                Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", Util.getStack().toString());
                d.b.a(this.BRF.wgr, d.c.BUD);
                this.BRF.BRw = Util.currentTicks();
                AppMethodBeat.o(237304);
                return;
            }
            Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", Util.getStack().toString());
            AppMethodBeat.o(237304);
        }
    }

    private final void c(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(237319);
        Boolean bool = recordConfigProvider.BOr;
        p.g(bool, "config.enablePicture");
        this.BRu = bool.booleanValue();
        Boolean bool2 = recordConfigProvider.BOr;
        p.g(bool2, "config.enablePicture");
        if (bool2.booleanValue()) {
            this.rsX.setText(R.string.f0y);
            this.zCQ.setSimpleTapCallback(new f(this));
        }
        Boolean bool3 = recordConfigProvider.BOs;
        p.g(bool3, "config.enableVideo");
        if (bool3.booleanValue()) {
            this.rsX.setText(R.string.f0z);
            this.zCQ.setLongPressCallback(new g(this));
            this.zCQ.setLongPressScrollCallback(new h(this));
        }
        Boolean bool4 = recordConfigProvider.BOr;
        p.g(bool4, "config.enablePicture");
        if (bool4.booleanValue()) {
            Boolean bool5 = recordConfigProvider.BOs;
            p.g(bool5, "config.enableVideo");
            if (bool5.booleanValue()) {
                this.rsX.setText(R.string.f0x);
            }
        }
        AppMethodBeat.o(237319);
    }

    public static final class f implements MMSightRecordButton.d {
        final /* synthetic */ w BRF;

        f(w wVar) {
            this.BRF = wVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d
        public final void cJK() {
            AppMethodBeat.i(237306);
            if (this.BRF.BRw == -1 || Util.ticksToNow(this.BRF.BRw) > ((long) this.BRF.BRv)) {
                Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", Util.getStack().toString());
                d.b.a(this.BRF.wgr, d.c.BUD);
                this.BRF.BRw = Util.currentTicks();
                AppMethodBeat.o(237306);
                return;
            }
            Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", Util.getStack().toString());
            AppMethodBeat.o(237306);
        }
    }

    public static final class g implements MMSightRecordButton.b {
        final /* synthetic */ w BRF;

        g(w wVar) {
            this.BRF = wVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
        public final void cJJ() {
            AppMethodBeat.i(237308);
            Future future = this.BRF.BRA;
            if (future != null) {
                future.cancel(true);
            }
            this.BRF.BRr.setVisibility(4);
            int[] iArr = new int[2];
            this.BRF.zCQ.getLocationOnScreen(iArr);
            Bundle bundle = new Bundle();
            bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", iArr[1]);
            this.BRF.wgr.a(d.c.BUr, bundle);
            this.BRF.rsX.animate().alpha(0.0f).withEndAction(new a(this)).start();
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.VI(2);
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.VH(2);
            com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.eKY().ahL();
            AppMethodBeat.o(237308);
        }

        static final class a implements Runnable {
            final /* synthetic */ g BRH;

            a(g gVar) {
                this.BRH = gVar;
            }

            public final void run() {
                AppMethodBeat.i(237307);
                this.BRH.BRF.rsX.setVisibility(4);
                AppMethodBeat.o(237307);
            }
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
        public final void jK() {
            AppMethodBeat.i(237309);
            this.BRF.BRx = true;
            if (!this.BRF.BRy || !this.BRF.zCQ.ekI()) {
                this.BRF.bFT();
                AppMethodBeat.o(237309);
                return;
            }
            d.b.a(this.BRF.wgr, d.c.BUN);
            AppMethodBeat.o(237309);
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
        public final void cJI() {
            AppMethodBeat.i(237310);
            Log.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
            if (this.BRF.BRx) {
                this.BRF.BRx = false;
                d.b.a(this.BRF.wgr, d.c.BUO);
                AppMethodBeat.o(237310);
                return;
            }
            w.c(this.BRF);
            AppMethodBeat.o(237310);
        }
    }

    public static final class h implements MMSightRecordButton.c {
        final /* synthetic */ w BRF;

        h(w wVar) {
            this.BRF = wVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
        public final void Gt(int i2) {
            AppMethodBeat.i(237311);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
            bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", i2);
            this.BRF.wgr.a(d.c.BUs, bundle);
            AppMethodBeat.o(237311);
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
        public final void Gu(int i2) {
            AppMethodBeat.i(237312);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
            bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", i2);
            this.BRF.wgr.a(d.c.BUs, bundle);
            AppMethodBeat.o(237312);
        }
    }

    public final void bFT() {
        int i2;
        AppMethodBeat.i(237320);
        if (!this.BRx) {
            AppMethodBeat.o(237320);
            return;
        }
        this.BRx = false;
        d.b.a(this.wgr, d.c.BUv);
        if (this.gLS == 0) {
            Context context = this.yIR.getContext();
            p.g(context, "layout.context");
            i2 = context.getResources().getColor(R.color.afp);
        } else {
            i2 = this.gLS;
        }
        this.zCQ.a(this.BRs, i2, new k(this));
        AppMethodBeat.o(237320);
    }

    public static final class k implements MMSightCircularProgressBar.a {
        final /* synthetic */ w BRF;

        k(w wVar) {
            this.BRF = wVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
        public final void Z(ArrayList<Float> arrayList) {
            AppMethodBeat.i(237316);
            p.h(arrayList, "subProgress");
            kotlin.g.a.b<? super ArrayList<Float>, x> bVar = this.BRF.BRz;
            if (bVar != null) {
                bVar.invoke(arrayList);
                AppMethodBeat.o(237316);
                return;
            }
            AppMethodBeat.o(237316);
        }

        @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
        public final void lK(boolean z) {
            AppMethodBeat.i(237317);
            Log.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
            w.b(this.BRF, z);
            AppMethodBeat.o(237317);
        }
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(237321);
        p.h(recordConfigProvider, "config");
        this.BRt = recordConfigProvider.BOv;
        this.BRs = recordConfigProvider.BOv + 250;
        UICustomParam uICustomParam = recordConfigProvider.BOn;
        this.gLS = uICustomParam != null ? uICustomParam.gLS : 0;
        c(recordConfigProvider);
        AppMethodBeat.o(237321);
    }

    private void eKE() {
        AppMethodBeat.i(237322);
        this.rsX.setText(R.string.fx1);
        AppMethodBeat.o(237322);
    }

    private void eKF() {
        AppMethodBeat.i(237323);
        this.rsX.setText(R.string.f0x);
        AppMethodBeat.o(237323);
    }

    public final void c(View.OnClickListener onClickListener) {
        AppMethodBeat.i(237324);
        p.h(onClickListener, "clickListener");
        if (this.rsX.getVisibility() == 0) {
            Future<?> future = this.BRA;
            if (future != null) {
                future.cancel(true);
            }
            this.BRA = com.tencent.f.h.RTc.n(new i(this), 2000);
        } else {
            this.BRr.setVisibility(0);
        }
        this.BRr.setOnClickListener(onClickListener);
        AppMethodBeat.o(237324);
    }

    public static final class i implements Runnable {
        final /* synthetic */ w BRF;

        i(w wVar) {
            this.BRF = wVar;
        }

        public final void run() {
            AppMethodBeat.i(237313);
            this.BRF.rsX.setVisibility(4);
            this.BRF.BRr.setVisibility(0);
            AppMethodBeat.o(237313);
        }
    }

    public final void eKG() {
        AppMethodBeat.i(237325);
        Future<?> future = this.BRA;
        if (future != null) {
            future.cancel(true);
        }
        this.BRr.setVisibility(4);
        AppMethodBeat.o(237325);
    }

    public final void eKH() {
        AppMethodBeat.i(237326);
        if (this.BRu) {
            d.b.a(this.wgr, d.c.BUD);
            AppMethodBeat.o(237326);
            return;
        }
        b(this);
        AppMethodBeat.o(237326);
    }

    public static final class j implements DialogInterface.OnClickListener {
        public static final j BRI = new j();

        static {
            AppMethodBeat.i(237315);
            AppMethodBeat.o(237315);
        }

        j() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(237314);
            dialogInterface.dismiss();
            AppMethodBeat.o(237314);
        }
    }

    public final void ae(boolean z, boolean z2) {
        AppMethodBeat.i(237327);
        this.zCQ.rk(z);
        if (z) {
            eKE();
        } else {
            eKF();
        }
        if (z && z2) {
            this.zCQ.ekG();
        }
        AppMethodBeat.o(237327);
    }

    public final void QS(int i2) {
        AppMethodBeat.i(237328);
        this.zCQ.QS(i2);
        AppMethodBeat.o(237328);
    }

    public final List<Float> getSubProgress() {
        AppMethodBeat.i(237329);
        List<Float> subProgress = this.zCQ.getSubProgress();
        p.g(subProgress, "recordButton.subProgress");
        AppMethodBeat.o(237329);
        return subProgress;
    }

    public final void rl(boolean z) {
        AppMethodBeat.i(237330);
        this.zCQ.rl(z);
        AppMethodBeat.o(237330);
    }

    public static /* synthetic */ void a(w wVar) {
        AppMethodBeat.i(237332);
        wVar.eKI();
        AppMethodBeat.o(237332);
    }

    public final void eKI() {
        AppMethodBeat.i(237331);
        if (this.BRD.length() > 0) {
            bY(this.BRD, true);
            AppMethodBeat.o(237331);
            return;
        }
        aL(this.BRC, true);
        AppMethodBeat.o(237331);
    }

    public static /* synthetic */ void b(w wVar) {
        AppMethodBeat.i(237334);
        wVar.aL(R.string.fw8, true);
        AppMethodBeat.o(237334);
    }

    private final void aL(int i2, boolean z) {
        AppMethodBeat.i(237333);
        String string = this.yIR.getContext().getString(i2);
        p.g(string, "layout.context.getString(strRes)");
        bY(string, true);
        AppMethodBeat.o(237333);
    }

    private final void bY(String str, boolean z) {
        AppMethodBeat.i(237335);
        if (this.BRr.getVisibility() == 0) {
            AppMethodBeat.o(237335);
            return;
        }
        this.yIR.removeCallbacks(this.rtb);
        this.rsX.setText(str);
        this.rsX.setVisibility(0);
        this.rsX.animate().alpha(1.0f).start();
        if (z) {
            this.yIR.postDelayed(this.rtb, 3000);
        }
        AppMethodBeat.o(237335);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(237336);
        this.zCQ.stopRecord();
        AppMethodBeat.o(237336);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75626);
        this.zCQ.ekF();
        this.zCQ.setTouchEnable(true);
        this.hAk.removeCallbacksAndMessages(null);
        if (!com.tencent.mm.pluginsdk.permission.b.e(this.zCQ.getContext(), "android.permission.RECORD_AUDIO")) {
            c(new e(this));
        }
        AppMethodBeat.o(75626);
    }

    public static final class e implements View.OnClickListener {
        final /* synthetic */ w BRF;

        e(w wVar) {
            this.BRF = wVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237305);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.BRF.zCQ.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(237305);
                throw tVar;
            }
            Activity activity = (Activity) context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237305);
        }
    }

    static /* synthetic */ void c(w wVar) {
        AppMethodBeat.i(237338);
        wVar.te(false);
        AppMethodBeat.o(237338);
    }

    private final void te(boolean z) {
        AppMethodBeat.i(237337);
        this.zCQ.setTouchEnable(false);
        this.hAk.postDelayed(new d(this), 1500);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_1_BOOLEAN", z);
        this.wgr.a(d.c.BUw, bundle);
        AppMethodBeat.o(237337);
    }

    public static final class d implements Runnable {
        final /* synthetic */ w BRF;

        d(w wVar) {
            this.BRF = wVar;
        }

        public final void run() {
            AppMethodBeat.i(75616);
            this.BRF.zCQ.showLoading();
            AppMethodBeat.o(75616);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
        AppMethodBeat.i(75627);
        this.yIR.setVisibility(0);
        AppMethodBeat.o(75627);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(75628);
        this.yIR.setVisibility(4);
        AppMethodBeat.o(75628);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(237339);
        this.zCQ.setVisibility(i2);
        if (this.BRB) {
            this.yIR.bringToFront();
        }
        AppMethodBeat.o(237339);
    }
}
