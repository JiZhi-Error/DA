package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.e;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends k {
    private static final String yNM = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1b) + "/tencentMapTouch/app/download/apkForWXAndroidConf.json");
    private Map<String, String> lXj;
    private NewMyLocationButton yNF;
    private e yNG;
    private View yNH;
    private com.tencent.mm.ui.widget.a.e yNI;
    private int yNJ;
    private com.tencent.mm.plugin.location.model.j yNK;
    private View yNL;
    private HashMap<String, Integer> yNN = new HashMap<>();
    private k yNq;
    private com.tencent.mm.plugin.location.ui.j yNs;

    static /* synthetic */ int i(j jVar) {
        int i2 = jVar.yNJ;
        jVar.yNJ = i2 + 1;
        return i2;
    }

    public j(Activity activity) {
        super(activity);
        AppMethodBeat.i(56168);
        g.azz().a(1913, this);
        this.yNK = new com.tencent.mm.plugin.location.model.j();
        g.azz().a(this.yNK, 0);
        AppMethodBeat.o(56168);
    }

    static {
        AppMethodBeat.i(201733);
        AppMethodBeat.o(201733);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(56169);
        super.onCreate(bundle);
        this.yNJ = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_TENCENT_MAP_COUNT_INT, (Object) 0)).intValue();
        Log.i("MicroMsg.TrackMapUI", "count: %s", Integer.valueOf(this.yNJ));
        this.lXk.yFB = this.activity.getIntent().getStringExtra("kPoiid");
        setActionbarColor(MMApplicationContext.getResources().getColor(R.color.a2r));
        AppMethodBeat.o(56169);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k
    public final void edG() {
        AppMethodBeat.i(56170);
        super.edG();
        ((TextView) findViewById(R.id.ff4)).setText(R.string.ekn);
        findViewById(R.id.iqw).setVisibility(8);
        ViewStub viewStub = (ViewStub) findViewById(R.id.eqd);
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass1 */

            public final void onInflate(ViewStub viewStub, View view) {
                AppMethodBeat.i(56147);
                view.findViewById(R.id.eqb).setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass1.AnonymousClass1 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                AppMethodBeat.o(56147);
            }
        });
        this.yNH = viewStub.inflate();
        findViewById(R.id.eq5).setVisibility(8);
        this.activity.getWindow().getDecorView().post(new Runnable() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(56149);
                FrameLayout frameLayout = (FrameLayout) j.this.findViewById(R.id.f_w);
                RelativeLayout relativeLayout = (RelativeLayout) j.this.yNH.findViewById(R.id.eqb);
                if (frameLayout == null) {
                    Log.w("MicroMsg.TrackMapUI", "mapcontent is null!");
                    AppMethodBeat.o(56149);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                layoutParams.height = frameLayout.getHeight() - relativeLayout.getHeight();
                frameLayout.setLayoutParams(layoutParams);
                AppMethodBeat.o(56149);
            }
        });
        this.yNq = new k(this.activity, this.yKV.yHR, false);
        this.yNq.yKi = false;
        this.yNq.yKj = false;
        k kVar = this.yNq;
        kVar.yKg = true;
        if (kVar.yJZ != null) {
            kVar.yJZ.setOnAvatarOnClickListener(null);
            kVar.yJZ.setOnLocationOnClickListener(null);
            kVar.yJZ.eee();
        }
        this.yNq.yKd = false;
        this.yNs = new com.tencent.mm.plugin.location.ui.j(this.activity, new j.a() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.location.ui.j.a
            public final void edx() {
            }

            @Override // com.tencent.mm.plugin.location.ui.j.a
            public final void Py(int i2) {
            }

            @Override // com.tencent.mm.plugin.location.ui.j.a
            public final void edy() {
            }
        });
        findViewById(R.id.i4q).setVisibility(8);
        this.yKV.hNZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(56151);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                j.this.edF();
                j.this.hideVKB();
                j.this.activity.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56151);
            }
        });
        this.yNF = (NewMyLocationButton) this.yNH.findViewById(R.id.fx9);
        k kVar2 = this.yNq;
        AnonymousClass7 r1 = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(56152);
                j.this.yNF.setSelected(false);
                AppMethodBeat.o(56152);
                return false;
            }
        };
        if (kVar2.yHG != null) {
            kVar2.yHG.setMapViewOnTouchListener(r1);
        }
        this.yNF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(56153);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                j.this.yNq.a(j.this.yKV.yHR);
                j.this.yNF.setSelected(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56153);
            }
        });
        final String stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
        if (Util.isNullOrNil(stringExtra)) {
            this.yKV.sLV.setVisibility(8);
        } else {
            this.yKV.sLV.setVisibility(0);
            this.yKV.sLV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(56154);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.setClass(j.this.activity, e.p.class);
                    Log.d("MicroMsg.TrackMapUI", "click url %s", stringExtra);
                    intent.putExtra("rawUrl", stringExtra);
                    intent.putExtra("showShare", false);
                    c.f(j.this.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(56154);
                }
            });
        }
        this.yOl.yKM.setImageResource(R.drawable.cb0);
        this.yNG = new com.tencent.mm.plugin.location.ui.e(this.yKV.yHR, this.activity);
        if (this.lXk.ecI()) {
            if (this.kHV != null && !this.kHV.equals("")) {
                this.yNG.kHV = this.kHV;
            }
            this.yNG.setText(this.yOl.getPreText() + this.lXk.yFx);
        }
        AnonymousClass4 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(56150);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                j.this.dKf = 0;
                j.this.edZ();
                j.this.eel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56150);
            }
        };
        com.tencent.mm.plugin.location.ui.e eVar = this.yNG;
        eVar.yHU.setOnClickListener(r0);
        eVar.yHU.setVisibility(0);
        this.yNL = findViewById(R.id.bu3);
        AppMethodBeat.o(56170);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(56171);
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(56171);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.k
    public final void edY() {
        AppMethodBeat.i(56172);
        super.edY();
        AppMethodBeat.o(56172);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.k
    public final void eeb() {
        AppMethodBeat.i(56173);
        super.eeb();
        Log.i("MicroMsg.TrackMapUI", "onDown");
        AppMethodBeat.o(56173);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.location.ui.impl.k
    public final void eec() {
        AppMethodBeat.i(56174);
        l eem = l.eem();
        final ArrayList arrayList = new ArrayList(8);
        arrayList.addAll(eem.yFL);
        this.yNI = new com.tencent.mm.ui.widget.a.e((Context) this.activity, 1, false);
        this.yNI.HLX = new o.f() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(56160);
                StringBuilder sb = new StringBuilder();
                if (!Util.isNullOrNil(arrayList)) {
                    View inflate = LayoutInflater.from(j.this.activity).inflate(R.layout.c1y, (ViewGroup) new FrameLayout(j.this.activity), false);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.jk5);
                    int fromDPToPix = at.fromDPToPix(j.this.activity, 24);
                    int fromDPToPix2 = at.fromDPToPix(j.this.activity, 2);
                    c.a aVar = new c.a();
                    aVar.iaT = true;
                    aVar.hZz = fromDPToPix;
                    aVar.hZA = fromDPToPix;
                    com.tencent.mm.av.a.a.c bdv = aVar.bdv();
                    for (se seVar : arrayList) {
                        ImageView imageView = new ImageView(j.this.activity);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
                        layoutParams.leftMargin = fromDPToPix2;
                        layoutParams.rightMargin = fromDPToPix2;
                        linearLayout.addView(imageView, layoutParams);
                        q.bcV().a(seVar.yPH, imageView, bdv);
                        sb.append("weapp_id_").append(seVar.dNI).append("|");
                    }
                    if (1 == arrayList.size()) {
                        TextView textView = new TextView(j.this.activity);
                        textView.setTextColor(j.this.activity.getResources().getColor(R.color.a2x));
                        textView.setTextSize(17.0f);
                        textView.setGravity(17);
                        textView.setText(((se) arrayList.get(0)).nickname);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.leftMargin = fromDPToPix2 * 3;
                        linearLayout.addView(textView, layoutParams2);
                    }
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(56159);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (1 == arrayList.size()) {
                                Log.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
                                se seVar = (se) arrayList.get(0);
                                Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", seVar.dNI, seVar.KZQ, seVar.username, Integer.valueOf(seVar.version), Integer.valueOf(seVar.KXC));
                                h.INSTANCE.a(12809, 4, "weapp_id_".concat(seVar.dNI));
                                if (g.af(r.class) != null) {
                                    com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                    gVar.appId = seVar.dNI;
                                    gVar.username = seVar.username;
                                    gVar.iOo = seVar.KXC;
                                    gVar.version = seVar.version;
                                    gVar.kHw = seVar.KZQ;
                                    gVar.scene = 1146;
                                    com.tencent.mm.plugin.appbrand.api.h hVar = new com.tencent.mm.plugin.appbrand.api.h();
                                    hVar.latitude = (float) j.this.lXk.yFu;
                                    hVar.dTj = (float) j.this.lXk.yFv;
                                    hVar.kHV = j.this.lXk.dWi;
                                    Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", hVar.bua());
                                    gVar.kHx = hVar;
                                    ((r) g.af(r.class)).a(j.this.activity, gVar);
                                    j.this.yNI.bMo();
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(56159);
                                return;
                            }
                            final com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) j.this.activity, 1, true);
                            eVar.QOr = true;
                            eVar.HMg = true;
                            eVar.HLX = new o.f() {
                                /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.base.o.f
                                public final void onCreateMMMenu(final m mVar) {
                                    AppMethodBeat.i(56157);
                                    eVar.V(View.inflate(j.this.activity, R.layout.c1z, null), false);
                                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                        se seVar = (se) arrayList.get(i2);
                                        Bitmap a2 = u.a(new i(seVar.yPH));
                                        u.a(new u.a() {
                                            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.platformtools.u.a
                                            public final void k(final String str, final Bitmap bitmap) {
                                                AppMethodBeat.i(56156);
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final void run() {
                                                        AppMethodBeat.i(56155);
                                                        if (j.this.yNN.containsKey(str) && bitmap != null && !bitmap.isRecycled()) {
                                                            int intValue = ((Integer) j.this.yNN.remove(str)).intValue();
                                                            if (mVar.getItem(intValue) != null) {
                                                                mVar.getItem(intValue).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) / 2.0f, false), j.this.activity.getResources().getDimensionPixelOffset(R.dimen.u1), j.this.activity.getResources().getDimensionPixelOffset(R.dimen.u1), true, false)));
                                                                eVar.fPw();
                                                            }
                                                        }
                                                        AppMethodBeat.o(56155);
                                                    }
                                                });
                                                AppMethodBeat.o(56156);
                                            }
                                        });
                                        BitmapDrawable bitmapDrawable = a2 != null ? new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap(a2, false, ((float) a2.getWidth()) / 2.0f, false), j.this.activity.getResources().getDimensionPixelOffset(R.dimen.u1), j.this.activity.getResources().getDimensionPixelOffset(R.dimen.u1), true, false)) : null;
                                        if (bitmapDrawable == null) {
                                            j.this.yNN.put(seVar.yPH, Integer.valueOf(i2));
                                        }
                                        String str = seVar.nickname;
                                        n nVar = new n(mVar.mContext, i2, 0);
                                        nVar.setTitle(str);
                                        nVar.setIcon(bitmapDrawable);
                                        nVar.f(bitmapDrawable, 0);
                                        mVar.ORD.add(nVar);
                                    }
                                    AppMethodBeat.o(56157);
                                }
                            };
                            eVar.HLY = new o.g() {
                                /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass10.AnonymousClass1.AnonymousClass2 */

                                @Override // com.tencent.mm.ui.base.o.g
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                    AppMethodBeat.i(56158);
                                    Log.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", Integer.valueOf(i2), Integer.valueOf(menuItem.getItemId()));
                                    se seVar = (se) arrayList.get(i2);
                                    Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", seVar.dNI, seVar.KZQ, seVar.username, Integer.valueOf(seVar.version), Integer.valueOf(seVar.KXC));
                                    h.INSTANCE.a(12809, 4, "weapp_id_".concat(seVar.dNI));
                                    if (g.af(r.class) != null) {
                                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                        gVar.appId = seVar.dNI;
                                        gVar.username = seVar.username;
                                        gVar.iOo = seVar.KXC;
                                        gVar.version = seVar.version;
                                        gVar.kHw = seVar.KZQ;
                                        gVar.scene = 1146;
                                        com.tencent.mm.plugin.appbrand.api.h hVar = new com.tencent.mm.plugin.appbrand.api.h();
                                        hVar.latitude = (float) j.this.lXk.yFu;
                                        hVar.dTj = (float) j.this.lXk.yFv;
                                        hVar.kHV = j.this.lXk.dWi;
                                        Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", hVar.bua());
                                        gVar.kHx = hVar;
                                        ((r) g.af(r.class)).a(j.this.activity, gVar);
                                    }
                                    AppMethodBeat.o(56158);
                                }
                            };
                            j.this.yNI.bMo();
                            eVar.dGm();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(56159);
                        }
                    });
                    j.this.yNI.setFooterView(inflate);
                }
                StringBuilder sb2 = new StringBuilder();
                j.this.lXj = j.this.lXm.b(j.this.lXk);
                boolean z = !ChannelUtil.isGPVersion() && j.this.yNJ < ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_tencent_map_show_max_limit, 99);
                if (!z && j.g(j.this)) {
                    z = true;
                }
                if (z) {
                    sb2.append("com.tencent.map|");
                    mVar.aS(2, R.string.hmx, 0);
                }
                int i2 = 3;
                for (Map.Entry entry : j.this.lXj.entrySet()) {
                    if (!((String) entry.getKey()).equals("com.tencent.map")) {
                        sb2.append((String) entry.getKey()).append("|");
                        mVar.b(i2, (CharSequence) entry.getValue(), 0);
                    }
                    i2++;
                }
                h.INSTANCE.a(12809, 3, sb2.toString(), sb.toString());
                AppMethodBeat.o(56160);
            }
        };
        this.yNI.HLY = new o.g() {
            /* class com.tencent.mm.plugin.location.ui.impl.j.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(56148);
                switch (menuItem.getItemId()) {
                    case 2:
                        Log.i("MicroMsg.TrackMapUI", "click tencent map: %s", Boolean.valueOf(j.this.lXj.containsKey("com.tencent.map")));
                        if (j.g(j.this)) {
                            j.this.lXm.a(j.this.lXk, j.this.lXl, "com.tencent.map", false);
                            h.INSTANCE.a(12809, 4, "com.tencent.map");
                            AppMethodBeat.o(56148);
                            return;
                        }
                        if (j.this.yNJ < ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_tencent_map_show_max_limit, 99)) {
                            j.i(j.this);
                            g.aAh().azQ().set(ar.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(j.this.yNJ));
                        }
                        if (1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_tencent_map_download_page_direct, 0)) {
                            new a(j.this.activity, j.this.yNL).execute(j.yNM);
                            AppMethodBeat.o(56148);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1t) + "/?key=wx&referer=wx1&channel=00008");
                        com.tencent.mm.br.c.b(j.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                        h.INSTANCE.a(12809, 5);
                        AppMethodBeat.o(56148);
                        return;
                    default:
                        if (j.this.lXj != null) {
                            for (Map.Entry entry : j.this.lXj.entrySet()) {
                                if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                                    j.this.lXm.a(j.this.lXk, j.this.lXl, (String) entry.getKey(), false);
                                    h.INSTANCE.a(12809, 4, entry.getKey());
                                    AppMethodBeat.o(56148);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(56148);
                        return;
                }
            }
        };
        this.yNI.dGm();
        AppMethodBeat.o(56174);
    }

    static class a extends AsyncTask<String, Integer, String> {
        private static final String yOb = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1b) + "/tencentMapTouch/app/download/wx_android_download_ico.png");
        private final WeakReference<Context> yNZ;
        private final WeakReference<View> yOa;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ String doInBackground(String[] strArr) {
            String str;
            AppMethodBeat.i(56167);
            String[] strArr2 = strArr;
            final Context context = this.yNZ.get();
            if (context != null) {
                if (!NetStatusUtil.isNetworkConnected(context)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.location.ui.impl.j.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(56161);
                            Toast.makeText(context, context.getString(R.string.hmu), 0).show();
                            AppMethodBeat.o(56161);
                        }
                    });
                    Log.e("MicroMsg.TrackMapUI", "fail, network not ready");
                    str = "";
                } else if (!com.tencent.mm.compatible.util.e.apn()) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.location.ui.impl.j.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(56162);
                            Toast.makeText(context, context.getString(R.string.hmw), 0).show();
                            AppMethodBeat.o(56162);
                        }
                    });
                    Log.e("MicroMsg.TrackMapUI", "fail, sdcard not ready");
                    str = "";
                } else if (strArr2.length == 1) {
                    str = aDl(strArr2[0]);
                }
                AppMethodBeat.o(56167);
                return str;
            }
            str = "";
            AppMethodBeat.o(56167);
            return str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(String str) {
            AppMethodBeat.i(56166);
            String str2 = str;
            View view = this.yOa.get();
            if (view != null) {
                view.setVisibility(8);
            }
            Context context = this.yNZ.get();
            if (context == null) {
                AppMethodBeat.o(56166);
                return;
            }
            Log.d("MicroMsg.TrackMapUI", "json string: ".concat(String.valueOf(str2)));
            try {
                if (!Util.isNullOrNil(str2)) {
                    JSONArray optJSONArray = new JSONObject(str2).optJSONArray("apkInfos");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        Intent intent = new Intent();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject == null) {
                                Log.d("MicroMsg.TrackMapUI", "get json item failure, index: ".concat(String.valueOf(i2)));
                            } else if (optJSONObject.optString("cid").equals("00008")) {
                                String optString = optJSONObject.optString("apkPath");
                                long j2 = 0;
                                String optString2 = optJSONObject.optString("size");
                                if (TextUtils.isDigitsOnly(optString2)) {
                                    j2 = Long.valueOf(optString2).longValue();
                                }
                                String optString3 = optJSONObject.optString("md5");
                                Log.d("MicroMsg.TrackMapUI", "url: %s, md5: %s, size: %s", optString, optString3, Long.valueOf(j2));
                                if (j2 > 0 && !com.tencent.mm.compatible.util.e.yV(j2)) {
                                    Toast.makeText(context, context.getString(R.string.hmv), 0).show();
                                    Log.e("MicroMsg.TrackMapUI", "fail, not enough space, require size = ".concat(String.valueOf(j2)));
                                    AppMethodBeat.o(56166);
                                    return;
                                } else if (Util.isNullOrNil(optString)) {
                                    Log.e("MicroMsg.TrackMapUI", "doAddDownloadTask fail, url is null");
                                    AppMethodBeat.o(56166);
                                    return;
                                } else {
                                    intent.putExtra("task_name", "TencentMap");
                                    intent.putExtra("task_url", optString);
                                    intent.putExtra("task_size", j2);
                                    intent.putExtra("file_md5", optString3);
                                    intent.putExtra("thumb_url", yOb);
                                    intent.putExtra("title", "腾讯地图");
                                    intent.addFlags(268435456);
                                    com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
                                    AppMethodBeat.o(56166);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(56166);
                        return;
                    }
                    Log.d("MicroMsg.TrackMapUI", "get json array failure, key=%s.", "apkInfos");
                    Toast.makeText(context, context.getString(R.string.hmt), 0).show();
                }
                AppMethodBeat.o(56166);
            } catch (Exception e2) {
                Log.e("MicroMsg.TrackMapUI", "deal json string failure, msg: %s.", e2.getMessage());
                Toast.makeText(context, context.getString(R.string.hmt), 0).show();
                AppMethodBeat.o(56166);
            }
        }

        static {
            AppMethodBeat.i(201732);
            AppMethodBeat.o(201732);
        }

        a(Context context, View view) {
            AppMethodBeat.i(56163);
            this.yNZ = new WeakReference<>(context);
            this.yOa = new WeakReference<>(view);
            AppMethodBeat.o(56163);
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(56164);
            View view = this.yOa.get();
            if (view != null) {
                view.setVisibility(0);
            }
            AppMethodBeat.o(56164);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0066 A[SYNTHETIC, Splitter:B:19:0x0066] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String aDl(java.lang.String r10) {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.ui.impl.j.a.aDl(java.lang.String):java.lang.String");
        }
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onDestroy() {
        AppMethodBeat.i(56175);
        super.onDestroy();
        if (this.yNq != null) {
            this.yNq.destroy();
        }
        if (this.yNK != null) {
            g.azz().a(this.yNK);
        }
        g.azz().b(1913, this);
        AppMethodBeat.o(56175);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onResume() {
        AppMethodBeat.i(56176);
        super.onResume();
        if (this.yNq != null) {
            this.yNq.onResume();
        }
        if (this.type == 2) {
            hb hbVar = new hb();
            hbVar.dLm.dFW = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            hbVar.dLm.type = 4;
            EventCenter.instance.publish(hbVar);
            if (hbVar.dLn.bzh != null) {
                if (this.yLa == null) {
                    this.yLa = new ArrayList();
                } else {
                    this.yLa.clear();
                }
                this.yLa.addAll(hbVar.dLn.bzh);
                edC();
            }
        }
        AppMethodBeat.o(56176);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onPause() {
        AppMethodBeat.i(56177);
        super.onPause();
        if (this.yNq != null) {
            this.yNq.onPause();
        }
        AppMethodBeat.o(56177);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.location.ui.impl.k
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(56178);
        Log.i("MicroMsg.TrackMapUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (1913 == qVar.getType()) {
                l eem = l.eem();
                ArrayList arrayList = new ArrayList(8);
                arrayList.addAll(((com.tencent.mm.plugin.location.model.j) qVar).yFL);
                ArrayList arrayList2 = new ArrayList(8);
                arrayList2.addAll(arrayList);
                eem.yFL = arrayList2;
            }
            AppMethodBeat.o(56178);
            return;
        }
        AppMethodBeat.o(56178);
    }

    static /* synthetic */ boolean g(j jVar) {
        AppMethodBeat.i(56179);
        boolean containsKey = jVar.lXj.containsKey("com.tencent.map");
        Log.i("MicroMsg.TrackMapUI", "install tencent map: %s.", Boolean.valueOf(containsKey));
        AppMethodBeat.o(56179);
        return containsKey;
    }
}
