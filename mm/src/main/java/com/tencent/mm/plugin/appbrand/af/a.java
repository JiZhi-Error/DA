package com.tencent.mm.plugin.appbrand.af;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.e.d;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends ContextWrapper implements g {
    private FrameLayout cIL;
    private IListener<f> lEE = new IListener<f>() {
        /* class com.tencent.mm.plugin.appbrand.af.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160621);
            this.__eventId = f.class.getName().hashCode();
            AppMethodBeat.o(160621);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(f fVar) {
            AppMethodBeat.i(49319);
            if (fVar != null) {
                Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "[weishi] video play, close launch proxy ui");
                a.this.finish();
            }
            AppMethodBeat.o(49319);
            return false;
        }
    };
    private int lvW = 0;
    private ImageView ojE;
    private d ojF;

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(49333);
        aVar.eO(str, null);
        AppMethodBeat.o(49333);
    }

    public a(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        super(appBrandLaunchProxyUI);
        AppMethodBeat.i(49323);
        AppMethodBeat.o(49323);
    }

    public final AppBrandLaunchProxyUI bZP() {
        AppMethodBeat.i(49324);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.o(49324);
        return appBrandLaunchProxyUI;
    }

    private void eO(String str, final String str2) {
        AppMethodBeat.i(49327);
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", str);
        b.aXY().a(new b.k() {
            /* class com.tencent.mm.plugin.appbrand.af.a.AnonymousClass3 */

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void aYg() {
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void I(Bitmap bitmap) {
                AppMethodBeat.i(49321);
                Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
                a.a(a.this, bitmap);
                AppMethodBeat.o(49321);
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void oD() {
                AppMethodBeat.i(49322);
                Log.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
                if (str2 != null) {
                    a.a(a.this, str2);
                }
                AppMethodBeat.o(49322);
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
            public final String Lb() {
                return "AppBrandThumbFromMMProxyUI#THUMB";
            }
        }, str, (b.h) null, (b.f) null);
        AppMethodBeat.o(49327);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final boolean bOi() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onResume() {
        AppMethodBeat.i(49328);
        this.lvW++;
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, resume count:%d", Integer.valueOf(this.lvW));
        if (this.lvW > 1) {
            Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onResume, finish when resume again");
            finish();
        }
        AppMethodBeat.o(49328);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onPause() {
        AppMethodBeat.i(49329);
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onPause");
        AppMethodBeat.o(49329);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onDestroy() {
        AppMethodBeat.i(49330);
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onDestroy");
        if (this.lEE != null) {
            this.lEE.dead();
        }
        if (this.ojF != null) {
            this.ojF.bOc();
        }
        AppMethodBeat.o(49330);
    }

    public final void finish() {
        AppMethodBeat.i(49325);
        if (((AppBrandLaunchProxyUI) super.getBaseContext()) != null) {
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.af.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(49320);
                    AppBrandLaunchProxyUI bZP = a.this.bZP();
                    if (bZP != null && !bZP.isFinishing() && !bZP.isDestroyed()) {
                        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, baseContext:%s", bZP.getClass().getSimpleName());
                        if (a.this.cIL != null) {
                            Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, make decorView invisible");
                            a.this.cIL.removeAllViews();
                            a.this.cIL.setBackgroundColor(0);
                        }
                        bZP.finish();
                    }
                    AppMethodBeat.o(49320);
                }
            });
            AppMethodBeat.o(49325);
            return;
        }
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "finish, no baseContext");
        AppMethodBeat.o(49325);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void H(Intent intent) {
        AppMethodBeat.i(49326);
        y.a(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true, false);
        d acl = d.acl(intent.getStringExtra("extra_entry_token"));
        if (acl == null) {
            finish();
            AppMethodBeat.o(49326);
            return;
        }
        acl.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        this.ojF = acl;
        View inflate = ((AppBrandLaunchProxyUI) super.getBaseContext()).getLayoutInflater().inflate(R.layout.e6, (ViewGroup) null);
        this.cIL = (FrameLayout) inflate.findViewById(R.id.be9);
        this.ojE = (ImageView) inflate.findViewById(R.id.im6);
        ((AppBrandLaunchProxyUI) super.getBaseContext()).setContentView(inflate);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_launch_thumb_url");
            String stringExtra2 = intent.getStringExtra("extra_launch_thumb_path");
            Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", stringExtra, stringExtra2);
            if (!Util.isNullOrNil(stringExtra)) {
                eO(stringExtra, "file://".concat(String.valueOf(stringExtra2)));
            } else if (!Util.isNullOrNil(stringExtra2)) {
                eO("file://".concat(String.valueOf(stringExtra2)), null);
            }
        }
        this.lEE.alive();
        Log.i("MicroMsg.AppBrandThumbFromMMProxyUI", "AppBrandThumbFromMMProxyUI onCreate");
        AppMethodBeat.o(49326);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.i(49331);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.o(49331);
        return appBrandLaunchProxyUI;
    }

    static /* synthetic */ void a(a aVar, Bitmap bitmap) {
        AppMethodBeat.i(49332);
        if (!(aVar.ojE == null || bitmap == null || bitmap.isRecycled())) {
            aVar.ojE.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(49332);
    }
}
