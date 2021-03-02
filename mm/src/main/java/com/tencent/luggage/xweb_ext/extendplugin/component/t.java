package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.f;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.ref.WeakReference;

public class t implements h<View> {
    private static d cDX = new d() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.t.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.d
        public final boolean PB() {
            return false;
        }
    };
    private static WeakReference<byte[]> cEs = null;
    protected final String cDW = ("MicroMsg.AppBrand.XWebVideoContainerChannel4AudioPlay#" + hashCode());
    private final i cEt;

    static {
        AppMethodBeat.i(215565);
        AppMethodBeat.o(215565);
    }

    public t(i iVar) {
        AppMethodBeat.i(215560);
        this.cEt = iVar;
        AppMethodBeat.o(215560);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public View aS(Context context) {
        AppMethodBeat.i(215561);
        AnonymousClass2 r0 = new a(context) {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.t.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t.a
            public final Space aT(Context context) {
                AppMethodBeat.i(215558);
                Space space = new Space(context);
                space.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 19.0f));
                AppMethodBeat.o(215558);
                return space;
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t.a
            public final View aU(Context context) {
                byte[] bArr;
                AppMethodBeat.i(215559);
                b bVar = (b) e.M(b.class);
                if (bVar == null) {
                    Log.w(t.this.cDW, "createAudioPlayView, gifCoverViewFactory is null");
                    AppMethodBeat.o(215559);
                    return null;
                }
                com.tencent.mm.plugin.appbrand.widget.b.a ed = bVar.ed(context);
                if (t.cEs == null || t.cEs.get() == null) {
                    bArr = com.tencent.mm.plugin.appbrand.ac.d.H(context.getResources().openRawResource(R.raw.video_background_play_audio));
                    WeakReference unused = t.cEs = new WeakReference(bArr);
                } else {
                    bArr = (byte[]) t.cEs.get();
                }
                ed.setImageByteArray(bArr);
                View view = ed.getView();
                view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 6.0f));
                AppMethodBeat.o(215559);
                return view;
            }
        };
        AppMethodBeat.o(215561);
        return r0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public void cf(View view) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public d Pz() {
        return cDX;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public void d(View view, Runnable runnable) {
        AppMethodBeat.i(215562);
        Log.i(this.cDW, "transferTo, view: ".concat(String.valueOf(view)));
        if (runnable != null) {
            Log.i(this.cDW, "transferTo, run afterTransferToTask");
            runnable.run();
        }
        AppMethodBeat.o(215562);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public void e(View view, Runnable runnable) {
        AppMethodBeat.i(215563);
        Log.i(this.cDW, "transferFrom, view: ".concat(String.valueOf(view)));
        if (runnable != null) {
            Log.i(this.cDW, "transferFrom, run afterTransferFromTask");
            runnable.run();
        }
        AppMethodBeat.o(215563);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public void cg(View view) {
        AppMethodBeat.i(215564);
        Log.i(this.cDW, "onPlayEndWorkaround, view: ".concat(String.valueOf(view)));
        AppMethodBeat.o(215564);
    }

    abstract class a extends LinearLayout implements f {
        private final Space cEv;
        private final View cEw;
        private final Space cEx;

        /* access modifiers changed from: protected */
        public abstract Space aT(Context context);

        /* access modifiers changed from: protected */
        public abstract View aU(Context context);

        public a(Context context) {
            super(context);
            boolean z;
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setOrientation(0);
            ColorDrawable colorDrawable = new ColorDrawable(Color.argb((int) TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 0, 0, 0));
            k kVar = (k) t.this.cEt.X(k.class);
            if (kVar == null) {
                Log.w(t.this.cDW, "setBackground4AudioPlayViewContainer, videoPlayerAddOnGetSnapshot is null");
                z = false;
            } else {
                Bitmap PD = kVar.PD();
                if (PD == null) {
                    Log.w(t.this.cDW, "setBackground4AudioPlayViewContainer, bitmap is null");
                    z = false;
                } else {
                    Log.i(t.this.cDW, "setBackground4AudioPlayViewContainer, real set");
                    setBackground(new LayerDrawable(new Drawable[]{new BitmapDrawable(getResources(), BitmapUtil.fastblur(PD, 50)), colorDrawable}));
                    z = true;
                }
            }
            if (!z) {
                setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(Color.parseColor("#F7F7F7")), colorDrawable}));
            }
            setGravity(16);
            this.cEv = aT(context);
            addView(this.cEv);
            this.cEw = aU(context);
            if (this.cEw == null) {
                Log.w(t.this.cDW, "createVideoContainerView, audioPlayView is null");
            } else {
                addView(this.cEw);
            }
            this.cEx = aT(context);
            addView(this.cEx);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.f
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.s.e eVar) {
            Log.i(t.this.cDW, "onModeConfirmed, mode: ".concat(String.valueOf(eVar)));
            if (com.tencent.mm.plugin.appbrand.jsapi.s.e.PORTRAIT == eVar) {
                ((LinearLayout.LayoutParams) this.cEv.getLayoutParams()).weight = 75.0f;
                ((LinearLayout.LayoutParams) this.cEx.getLayoutParams()).weight = 75.0f;
                ((LinearLayout.LayoutParams) this.cEw.getLayoutParams()).weight = 48.0f;
            }
        }
    }
}
