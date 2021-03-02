package com.tencent.mm.plugin.location.ui.impl;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.impl.g;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends b implements i {
    private static int yLT = 11;
    private static int yLU = 12;
    private static int yLV = 13;
    private static int yLW = 14;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass16 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(182065);
            if (!z) {
                if (!c.this.uSu && !d.bcc()) {
                    c.this.uSu = true;
                    h.a((Context) c.this.activity, c.this.activity.getString(R.string.dvi), c.this.activity.getString(R.string.zb), c.this.activity.getString(R.string.e_k), c.this.activity.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass16.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(182064);
                            d.cZ(c.this.activity);
                            AppMethodBeat.o(182064);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                AppMethodBeat.o(182065);
                return false;
            } else if (!c.S(c.this)) {
                AppMethodBeat.o(182065);
                return true;
            } else {
                if (c.this.yLC == -85.0d || c.this.yLD == -1000.0d) {
                    Log.d("MicroMsg.MMPoiMapUI", "init my location.");
                    g.aAh().azQ().set(ar.a.USERINFO_LAST_LOCATION_STRING, ((int) (1000000.0f * f3)) + "," + ((int) (1000000.0f * f2)));
                    c.this.yLC = (double) f3;
                    c.this.yLD = (double) f2;
                    c.this.yLt.m(c.this.yLC, c.this.yLD);
                    c.this.yLu.m(c.this.yLC, c.this.yLD);
                    if (c.T(c.this)) {
                        c.U(c.this);
                        AppMethodBeat.o(182065);
                        return true;
                    }
                    c.this.lat = c.this.yLC;
                    c.this.lng = c.this.yLD;
                    c.this.yLq.l(c.this.lat, c.this.lng);
                    c.this.yJa.getIController().animateTo(c.this.yLC, c.this.yLD, com.tencent.mm.plugin.location.ui.d.ede());
                    if (!c.this.yLE) {
                        c.l(c.this);
                    }
                } else if (!(c.this.yLC == ((double) f3) && c.this.yLD == ((double) f2))) {
                    Log.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
                    g.aAh().azQ().set(ar.a.USERINFO_LAST_LOCATION_STRING, ((int) (1000000.0f * f3)) + "," + ((int) (1000000.0f * f2)));
                    c.this.yLC = (double) f3;
                    c.this.yLD = (double) f2;
                }
                AppMethodBeat.o(182065);
                return true;
            }
        }
    };
    private String jgR = "";
    private double lat = -85.0d;
    private double lng = -1000.0d;
    private boolean uSu;
    private View uvi;
    private String yFJ = "";
    private int yFK = 1;
    PoiPoint.a yIr;
    private LinearLayout yLA;
    private MyPoiPoint yLB;
    private double yLC = -85.0d;
    private double yLD = -1000.0d;
    private boolean yLE = false;
    private int yLF = 0;
    private RelativeLayout yLG;
    private int yLH;
    private int yLI;
    private int yLJ;
    private boolean yLK = true;
    private boolean yLL = false;
    private boolean yLM = false;
    private FrameLayout yLN;
    private int yLO = 0;
    private long yLP = -1;
    private long yLQ = -1;
    private long yLR = -1;
    private int yLS = -1;
    private boolean yLX = false;
    private int[] yLY = {24, 24};
    private int[] yLZ;
    private FrameLayout yLg;
    private PoiHeaderView yLp;
    private PickPoi yLq;
    private MMLoadMoreListView yLr;
    private MMLoadMoreListView yLs;
    private e yLt;
    private e yLu;
    private View yLv;
    private ImageButton yLw;
    private com.tencent.mm.plugin.location.model.i yLx = null;
    private View yLy;
    private TextView yLz;
    private View yMa;
    private int yMb;
    private View yMc;
    private View yMd;
    private EditText yMe;
    private ImageView yMf;
    private View yMg;
    private View.OnTouchListener yMh;
    private PoiPoint yMi;
    private Map<String, PoiPoint> yMj = new HashMap();
    private boolean yMk;
    private f yMl = new f();
    private boolean yMm = false;
    private boolean yMn = false;
    private boolean yMo = false;
    private boolean yMp = false;
    private boolean yMq = false;
    private InputPanelFrameLayout yMr;
    private View ygS;

    /* access modifiers changed from: package-private */
    public interface b {
        void a(f fVar);
    }

    static /* synthetic */ void A(c cVar) {
        AppMethodBeat.i(170178);
        cVar.edS();
        AppMethodBeat.o(170178);
    }

    static /* synthetic */ void F(c cVar) {
        AppMethodBeat.i(170180);
        cVar.edP();
        AppMethodBeat.o(170180);
    }

    static /* synthetic */ void M(c cVar) {
        AppMethodBeat.i(170182);
        cVar.edO();
        AppMethodBeat.o(170182);
    }

    static /* synthetic */ void O(c cVar) {
        AppMethodBeat.i(170183);
        cVar.pN(true);
        AppMethodBeat.o(170183);
    }

    static /* synthetic */ boolean S(c cVar) {
        AppMethodBeat.i(56076);
        boolean z = cVar.yMn;
        AppMethodBeat.o(56076);
        return z;
    }

    static /* synthetic */ boolean T(c cVar) {
        AppMethodBeat.i(170184);
        boolean edL = cVar.edL();
        AppMethodBeat.o(170184);
        return edL;
    }

    static /* synthetic */ void a(c cVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(182072);
        cVar.x(i2, i3, z);
        AppMethodBeat.o(182072);
    }

    static /* synthetic */ void a(c cVar, EnumC1464c cVar2) {
        AppMethodBeat.i(182074);
        cVar.a(cVar2);
        AppMethodBeat.o(182074);
    }

    static /* synthetic */ void b(c cVar, EnumC1464c cVar2) {
        AppMethodBeat.i(170179);
        cVar.b(cVar2);
        AppMethodBeat.o(170179);
    }

    static /* synthetic */ void d(c cVar, boolean z) {
        AppMethodBeat.i(56067);
        cVar.qK(z);
        AppMethodBeat.o(56067);
    }

    static /* synthetic */ void y(c cVar) {
        AppMethodBeat.i(56069);
        cVar.edM();
        AppMethodBeat.o(56069);
    }

    public c(Activity activity) {
        super(activity);
        AppMethodBeat.i(56033);
        AppMethodBeat.o(56033);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b, com.tencent.mm.plugin.k.a
    public final void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(56034);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            window.setStatusBarColor(0);
        }
        g.azz().a(457, this);
        this.yLS = (int) (System.currentTimeMillis() / 1000);
        this.yJa.setCanRotate(false);
        if (ao.isDarkMode()) {
            edI().enableDarkMode();
        } else {
            edI().disableDarkMode();
        }
        this.yLA = (LinearLayout) findViewById(R.id.do1);
        ((TextView) findViewById(R.id.aek)).setText(R.string.sz);
        this.uvi = findViewById(R.id.ipw);
        this.uvi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(56013);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.c.yNm.a(g.a.QUIT);
                c.a(c.this, c.yLU, c.this.yLt.va, false);
                c.c(c.this);
                c.this.activity.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56013);
            }
        });
        this.uvi.setVisibility(0);
        this.ygS = findViewById(R.id.ipx);
        this.yLy = findViewById(R.id.af9);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(R.id.af9)).setText(R.string.el1);
                break;
            case 3:
                ((TextView) findViewById(R.id.af9)).setText(R.string.x5);
                break;
            case 8:
                ((TextView) findViewById(R.id.af9)).setText(R.string.vl);
                break;
        }
        this.ygS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(56018);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.c.yNm.a(g.a.SUCC);
                c.d(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56018);
            }
        });
        this.ygS.setVisibility(0);
        qK(false);
        this.yLG = (RelativeLayout) findViewById(R.id.eqf);
        this.yLr = (MMLoadMoreListView) this.activity.findViewById(R.id.gdw);
        this.yLs = (MMLoadMoreListView) this.activity.findViewById(R.id.hei);
        this.yLv = findViewById(R.id.ep6);
        this.yLz = (TextView) findViewById(R.id.hdz);
        this.yLp = (PoiHeaderView) findViewById(R.id.gdp);
        this.yLN = (FrameLayout) findViewById(R.id.f_x);
        this.yLw = (ImageButton) findViewById(R.id.eq5);
        this.yLw.setSelected(true);
        this.yLw.setContentDescription(this.activity.getString(R.string.eke));
        this.yLw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(182066);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", Double.valueOf(c.this.yLC), Double.valueOf(c.this.yLD));
                if (c.this.yLC == -85.0d || c.this.yLD == -1000.0d) {
                    Log.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182066);
                    return;
                }
                if (c.this.yLE) {
                    c.this.yJa.getIController().animateTo(c.this.yLC, c.this.yLD);
                    c.this.yLw.setSelected(true);
                    c.a(c.this, EnumC1464c.COLLAPSED);
                } else {
                    c.this.yJa.getIController().animateTo(c.this.yLC, c.this.yLD);
                    c.this.lat = c.this.yLC;
                    c.this.lng = c.this.yLD;
                    c.this.yLq.l(c.this.lat, c.this.lng);
                    c.this.yLw.setSelected(true);
                    c.this.yLX = false;
                    c.this.yLt.va = 0;
                    c.this.yLr.setSelection(0);
                    g.c.yNm.yNa = 0;
                    g.c.yNm.a(g.b.DIRECT);
                    c.l(c.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182066);
            }
        });
        this.yJa.setBuiltInZoomControls(false);
        this.yLg = (FrameLayout) findViewById(R.id.bfr);
        this.yLB = new MyPoiPoint(this.activity, this.yJa);
        this.yLq = new PickPoi(this.activity);
        this.yLq.setOnCurPoiGet(new b() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass19 */

            @Override // com.tencent.mm.plugin.location.ui.impl.c.b
            public final void a(f fVar) {
                AppMethodBeat.i(182067);
                c.this.yLq.setOnCurPoiGet(null);
                if (fVar != null) {
                    c.this.yMl.c(fVar.yMX);
                    if (c.this.yLt != null) {
                        c.this.yLt.iy(c.this.yMl.yMR, c.this.yMl.yMS);
                        c.this.yLu.iy(c.this.yMl.yMR, c.this.yMl.yMS);
                    }
                }
                AppMethodBeat.o(182067);
            }
        });
        this.yLg.addView(this.yLq);
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_LAST_LOCATION_STRING, "");
        if (!Util.isNullOrNil(str) && (this.yLC == -85.0d || this.yLD == -1000.0d)) {
            String[] split = str.split(",");
            Log.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(str)));
            if (split.length == 2) {
                this.yJa.getIController().animateTo((double) ((float) ((((double) Util.safeParseInt(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) Util.safeParseInt(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.yMh = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass20 */
            private float yMv;
            private short yMw = 0;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(182068);
                if (c.this.yLE) {
                    c.c(c.this);
                }
                if (!c.this.yLK) {
                    AppMethodBeat.o(182068);
                    return true;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        Log.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", Float.valueOf(motionEvent.getRawY()));
                        this.yMv = motionEvent.getRawY();
                        c.this.yLL = false;
                        break;
                    case 1:
                        Log.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                        c.this.yLL = false;
                        break;
                    case 2:
                        Log.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", Float.valueOf(motionEvent.getRawY()));
                        if (c.this.yLL) {
                            Log.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                            c.this.yLr.setSelection(0);
                        }
                        float rawY = this.yMv - motionEvent.getRawY();
                        if (Math.abs(rawY) < ((float) BackwardSupportUtil.BitmapFactory.fromDPToPix(c.this.activity, 20.0f))) {
                            this.yMw = 0;
                        } else if (rawY > 0.0f) {
                            this.yMw = 1;
                        } else {
                            this.yMw = -1;
                        }
                        if ((c.q(c.this) && this.yMw == 1) || ((c.r(c.this) && this.yMw == -1) || (c.q(c.this) && !c.s(c.this).getScroll2Top() && this.yMw == -1))) {
                            AppMethodBeat.o(182068);
                            return false;
                        } else if (!c.this.yLK || this.yMw == 0) {
                            AppMethodBeat.o(182068);
                            return true;
                        } else {
                            Log.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", Short.valueOf(this.yMw));
                            if (this.yMw == 1) {
                                c.this.yMp = true;
                                c.a(c.this, EnumC1464c.OPENED);
                                AppMethodBeat.o(182068);
                                return false;
                            }
                            c.a(c.this, EnumC1464c.COLLAPSED);
                            AppMethodBeat.o(182068);
                            return false;
                        }
                }
                AppMethodBeat.o(182068);
                return false;
            }
        };
        this.yLr.setOnTouchListener(this.yMh);
        this.yLr.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass21 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(182069);
                c.t(c.this);
                AppMethodBeat.o(182069);
            }
        });
        this.yLr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass22 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(182070);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", Integer.valueOf(i2));
                if (i2 < 0 || i2 >= c.this.yLt.getCount()) {
                    Log.i("MicroMsg.MMPoiMapUI", "wrong position");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(182070);
                    return;
                }
                f Pz = c.this.yLt.Pz(i2);
                if (Pz.type == 0) {
                    c.this.yLw.setSelected(false);
                } else {
                    c.this.yLw.setSelected(true);
                }
                c.this.lat = Pz.cik;
                c.this.lng = Pz.cil;
                c.this.yJa.getIController().animateTo(Pz.cik, Pz.cil);
                c.this.yLt.va = i2;
                c.this.yLt.notifyDataSetChanged();
                c.this.yLX = false;
                g.c.yNm.yNa = i2 + 1;
                g.c.yNm.a(g.b.LIST);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(182070);
            }
        });
        this.yLt = new e(this.activity);
        this.yLr.setAdapter((ListAdapter) this.yLt);
        this.yLq.setAdapter(this.yLt);
        this.yIr = new PoiPoint.a() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass23 */

            @Override // com.tencent.mm.plugin.location.ui.PoiPoint.a
            public final void a(PoiPoint.b bVar, PoiPoint poiPoint) {
                AppMethodBeat.i(182071);
                if (PoiPoint.b.SIT == bVar) {
                    if (-1 == c.this.yLu.va) {
                        c.d(c.this, true);
                    }
                    if (c.this.yMi != null) {
                        c.this.yMi.edi();
                    }
                    c.this.yJa.getIController().animateTo(poiPoint.getLat(), poiPoint.getLng());
                    c.this.yMi = poiPoint;
                    poiPoint.edj();
                    c.a(c.this, poiPoint.getPosition());
                    c.this.yLu.va = poiPoint.getPosition();
                    c.this.yLu.notifyDataSetChanged();
                    g.c.yNm.yNa = poiPoint.getPosition() + 1;
                    g.c.yNm.a(g.b.SEARCH_MAP);
                    AppMethodBeat.o(182071);
                    return;
                }
                PoiPoint.b bVar2 = PoiPoint.b.STAND;
                AppMethodBeat.o(182071);
            }
        };
        this.yLu = new e(this.activity);
        this.yLu.khr = true;
        this.yLu.va = -1;
        this.yLs.setAdapter((ListAdapter) this.yLu);
        this.yLs.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(182051);
                c.t(c.this);
                AppMethodBeat.o(182051);
            }
        });
        this.yLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                PoiPoint poiPoint;
                AppMethodBeat.i(182052);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (-1 == c.this.yLu.va) {
                    c.d(c.this, true);
                    c.a(c.this, EnumC1464c.COLLAPSED);
                }
                c.this.yLu.va = i2;
                c.this.yLu.notifyDataSetChanged();
                if (i2 >= 0 && i2 < c.this.yLu.getCount()) {
                    c.this.yLX = true;
                    if (c.this.yMi != null) {
                        c.this.yMi.edi();
                    }
                    f Pz = c.this.yLu.Pz(i2);
                    if (Pz.cik == c.this.yLC && Pz.cil == c.this.yLD) {
                        c.this.yLw.setSelected(true);
                    } else {
                        c.this.yLw.setSelected(false);
                    }
                    c.this.yJa.getIController().animateTo(Pz.cik, Pz.cil);
                    PoiPoint poiPoint2 = (PoiPoint) c.this.yMj.get(new StringBuilder().append(Pz.cik).append(Pz.cil).toString());
                    if (poiPoint2 == null) {
                        poiPoint = new PoiPoint(c.this.activity, c.this.yJa);
                        poiPoint.setPosition(i2);
                        poiPoint.setOnPointClick(c.this.yIr);
                        c.this.yMj.put(new StringBuilder().append(Pz.cik).append(Pz.cil).toString(), poiPoint);
                        poiPoint.c(Pz.cik, Pz.cil, true);
                    } else {
                        poiPoint2.edj();
                        poiPoint = poiPoint2;
                    }
                    c.this.yMi = poiPoint;
                    g.c.yNm.yNa = i2 + 1;
                    g.c.yNm.a(g.b.SEARCH_LIST);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(182052);
            }
        });
        this.yLs.setOnTouchListener(this.yMh);
        this.yMc = findViewById(R.id.hk9);
        this.yMd = findViewById(R.id.hka);
        this.yMe = (EditText) findViewById(R.id.hk8);
        this.yMf = (ImageView) findViewById(R.id.hkc);
        this.yMg = findViewById(R.id.hk7);
        this.yMc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(170177);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!c.this.yLE) {
                    c.H(c.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(170177);
            }
        });
        this.yMg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(182059);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, c.yLW, c.this.yLu.va, true);
                c.y(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182059);
            }
        });
        this.yMe.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass11 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(182060);
                if (c.this.yLM) {
                    c.A(c.this);
                } else if (c.this.yLK) {
                    c.a(c.this, EnumC1464c.OPENED);
                }
                AppMethodBeat.o(182060);
                return false;
            }
        });
        this.yLG.setClickable(true);
        this.yMe.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass13 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(182061);
                if (3 == i2) {
                    c.a(c.this, EnumC1464c.COLLAPSED);
                    c.this.yMq = true;
                }
                AppMethodBeat.o(182061);
                return false;
            }
        });
        this.yMe.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass14 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(182062);
                Log.d("MicroMsg.MMPoiMapUI", "searchText: %s.", charSequence);
                c.this.jgR = charSequence.toString();
                c.this.yLs.gKN();
                c.this.yLz.setVisibility(8);
                if (Util.isNullOrNil(c.this.jgR)) {
                    c.this.yMf.setVisibility(8);
                    c.this.yLu.clean();
                    c.this.yLu.notifyDataSetChanged();
                    c.M(c.this);
                    c.d(c.this, false);
                    c.this.yLv.setVisibility(8);
                    AppMethodBeat.o(182062);
                    return;
                }
                c.this.yMf.setVisibility(0);
                c.O(c.this);
                AppMethodBeat.o(182062);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.yMf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(182063);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.yMe.setText("");
                c.A(c.this);
                if (c.this.yLK) {
                    c.a(c.this, EnumC1464c.OPENED);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182063);
            }
        });
        edR();
        this.yMa = findViewById(R.id.hk6);
        this.yMa.post(new Runnable() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(182053);
                Log.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", Integer.valueOf(c.this.yMb));
                c.this.yMb = c.this.yMa.getHeight();
                c.this.yMa.setVisibility(8);
                AppMethodBeat.o(182053);
            }
        });
        findViewById(R.id.hk5).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(182054);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.yLu.getCount() == 0) {
                    c.y(c.this);
                } else {
                    c.a(c.this, EnumC1464c.COLLAPSED);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182054);
            }
        });
        this.yMr = (InputPanelFrameLayout) findViewById(R.id.gdx);
        this.yMr.setExternalListener(new b.a() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.b.a
            public final void f(boolean z, int i2) {
                AppMethodBeat.i(182055);
                Log.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", Boolean.valueOf(z));
                c.this.yMo = z;
                AppMethodBeat.o(182055);
            }
        });
        Point az = ao.az(this.activity);
        int max = Math.max(az.x, az.y);
        this.yLH = max - BackwardSupportUtil.BitmapFactory.fromDPToPix(this.activity, 320.0f);
        this.yLI = (int) (((double) (((float) max) * 0.25f)) + 0.5d);
        this.yLJ = (int) ((((double) (this.yLH - this.yLI)) / 3.0d) + 0.5d);
        Log.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", Integer.valueOf(this.yLH), Integer.valueOf(this.yLI), Integer.valueOf(this.yLJ));
        this.yLZ = new int[]{((this.yLH - this.yLI) - this.yLJ) + 24, 24};
        int identifier = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i2 = this.activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i2 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.yLA.getLayoutParams();
        layoutParams.height += i2 * 2;
        this.yLA.setLayoutParams(layoutParams);
        this.yLA.setPadding(0, i2, 0, i2);
        int aD = au.aA(this.activity) ? au.aD(this.activity) : 0;
        int i3 = (max - this.yLI) - aD;
        Log.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", Integer.valueOf(i3), Integer.valueOf(aD));
        ViewGroup.LayoutParams layoutParams2 = this.yLG.getLayoutParams();
        layoutParams2.height = i3;
        this.yLG.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.yLN.getLayoutParams();
        layoutParams3.height = this.yLH;
        this.yLN.setLayoutParams(layoutParams3);
        b(EnumC1464c.COLLAPSED);
        if (this.type == 0 || this.type == 8) {
            g.c.yNm.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
        } else {
            g.c.yNm.setScene(this.type);
        }
        this.yLq.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(182050);
                c.this.yLq.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                c.this.yLq.play();
                AppMethodBeat.o(182050);
            }
        });
        AppMethodBeat.o(56034);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b
    public final com.tencent.mm.plugin.k.d edI() {
        AppMethodBeat.i(56036);
        com.tencent.mm.plugin.k.d dVar = (com.tencent.mm.plugin.k.d) this.activity.findViewById(R.id.dch);
        AppMethodBeat.o(56036);
        return dVar;
    }

    private void a(final EnumC1464c cVar) {
        a aVar;
        a aVar2;
        ValueAnimator ofInt;
        AppMethodBeat.i(56037);
        if ((EnumC1464c.OPENED != cVar || !this.yLM) && (EnumC1464c.COLLAPSED != cVar || this.yLM)) {
            if (this.yMa.getVisibility() != 0) {
                this.yMa.setVisibility(0);
            }
            this.yLK = false;
            if (EnumC1464c.OPENED == cVar) {
                Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", Integer.valueOf(edQ()), Integer.valueOf(this.yLI));
                int edQ = edQ() - this.yLI;
                Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", Integer.valueOf(edQ));
                aVar = new a((float) (-edQ));
                aVar2 = new a((float) (-this.yLJ));
                ofInt = ValueAnimator.ofInt(0, this.yMb);
            } else {
                Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", Integer.valueOf(edQ()), Integer.valueOf(this.yLH));
                int edQ2 = this.yLH - edQ();
                Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", Integer.valueOf(edQ2));
                aVar = new a((float) edQ2);
                aVar2 = new a((float) this.yLJ);
                ofInt = ValueAnimator.ofInt(this.yMb, 0);
            }
            AnonymousClass7 r3 = new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass7 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(182056);
                    Log.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", Long.valueOf(System.currentTimeMillis()));
                    c.this.yLK = false;
                    c.this.yLL = true;
                    AppMethodBeat.o(182056);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(182057);
                    c.this.yLK = true;
                    if (EnumC1464c.OPENED == cVar) {
                        c.this.yLM = true;
                        if (c.this.yLE) {
                            if (c.this.yMp) {
                                c.this.yMp = false;
                            } else {
                                c.A(c.this);
                            }
                        }
                    } else {
                        c.this.yLM = false;
                        c.c(c.this);
                        if (c.this.yLE) {
                            c.a(c.this, c.this.yLu.va);
                        }
                    }
                    c.b(c.this, cVar);
                    c.this.yLG.clearAnimation();
                    c.this.yLw.clearAnimation();
                    c.this.yLN.clearAnimation();
                    if (c.this.yMq) {
                        c.this.yMq = false;
                        if (!c.this.yLu.qLO.equals(c.this.jgR) || !c.this.yLu.daZ) {
                            c.this.yMk = true;
                            c.l(c.this);
                        } else {
                            c.F(c.this);
                            AppMethodBeat.o(182057);
                            return;
                        }
                    }
                    AppMethodBeat.o(182057);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            };
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.location.ui.impl.c.AnonymousClass8 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(182058);
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = c.this.yMa.getLayoutParams();
                    layoutParams.height = intValue;
                    c.this.yMa.setLayoutParams(layoutParams);
                    AppMethodBeat.o(182058);
                }
            });
            a edV = aVar.edU().edV();
            edV.setAnimationListener(r3);
            edV.en(this.yLG).en(this.yLw).startAnimation();
            aVar2.edU().edV().en(this.yLN).startAnimation();
            ofInt.setDuration(200L).start();
            AppMethodBeat.o(56037);
            return;
        }
        AppMethodBeat.o(56037);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b, com.tencent.mm.plugin.k.a
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(56038);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
            g.c.yNm.a(g.a.QUIT);
            if (this.yLE) {
                edM();
                x(yLW, this.yLu.va, true);
                AppMethodBeat.o(56038);
                return false;
            }
            x(yLU, this.yLt.va, false);
            this.activity.finish();
            AppMethodBeat.o(56038);
            return true;
        }
        AppMethodBeat.o(56038);
        return false;
    }

    private void edM() {
        AppMethodBeat.i(56039);
        this.yLE = false;
        this.yLg.setVisibility(0);
        a(EnumC1464c.COLLAPSED);
        edR();
        this.jgR = "";
        this.yLs.setVisibility(8);
        this.yLt.notifyDataSetChanged();
        this.yLr.setVisibility(0);
        this.yLv.setVisibility(8);
        this.yLz.setVisibility(8);
        edO();
        qK(true);
        this.yLw.setSelected(this.yMm);
        this.yJa.getIController().animateTo(this.lat, this.lng);
        AppMethodBeat.o(56039);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b
    public final void edJ() {
        AppMethodBeat.i(56040);
        a(EnumC1464c.COLLAPSED);
        AppMethodBeat.o(56040);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b
    public final void edK() {
        AppMethodBeat.i(56041);
        if (this.yLw.isSelected()) {
            this.yLw.setSelected(false);
        }
        if (!this.yLE) {
            this.yLq.play();
            this.lat = ((double) this.yJa.getMapCenterX()) / 1000000.0d;
            this.lng = ((double) this.yJa.getMapCenterY()) / 1000000.0d;
            this.yLq.l(this.lat, this.lng);
            this.yLw.setSelected(false);
            if (this.yLM) {
                a(EnumC1464c.COLLAPSED);
            }
            pN(false);
            this.yLX = false;
            g.c.yNm.yNa = 0;
            g.c.yNm.a(g.b.DRAG_MAP);
        }
        AppMethodBeat.o(56041);
    }

    private String a(double d2, String str) {
        AppMethodBeat.i(56042);
        String str2 = ((int) (d2 * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + str;
        AppMethodBeat.o(56042);
        return str2;
    }

    private void edN() {
        AppMethodBeat.i(56043);
        if (this.yLq.yMD) {
            f poi = this.yLq.getPoi();
            e eVar = this.yLt;
            if (eVar.yMH.size() >= 0) {
                eVar.yMH.add(0, poi);
                eVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(56043);
    }

    private void pN(boolean z) {
        AppMethodBeat.i(56044);
        Log.d("MicroMsg.MMPoiMapUI", "stack: %s", Util.getStack());
        this.yFJ = a(this.lat, this.jgR);
        if (this.yFJ.equals(this.yLt.key)) {
            Log.i("MicroMsg.MMPoiMapUI", "same key passed it ", this.yFJ);
            AppMethodBeat.o(56044);
            return;
        }
        byte[] bArr = null;
        boolean z2 = true;
        this.yLv.setVisibility(0);
        if (!this.yLE) {
            this.yLr.gKN();
            this.yLt.clean();
            this.yLt.aDj(this.yFJ);
            this.yLt.notifyDataSetChanged();
            bArr = this.yLt.buffer;
            qK(false);
            edN();
        } else if (this.yFK > 0 && z) {
            this.yLs.gKN();
            this.yLu.edW();
            this.yLu.aDj(this.yFJ);
            this.yLu.qLO = this.jgR;
            this.yLu.daZ = false;
            bArr = this.yLu.buffer;
        } else if (!z) {
            this.yLs.gKN();
            this.yLu.clean();
            this.yLu.aDj(this.yFJ);
            this.yLu.qLO = this.jgR;
            this.yLu.daZ = false;
            bArr = this.yLu.buffer;
            this.yLu.notifyDataSetChanged();
        } else {
            z2 = false;
            this.yLu.daZ = false;
        }
        if (z2) {
            this.yLx = new com.tencent.mm.plugin.location.model.i(bArr, this.lat, this.lng, this.yLF == 0 ? 0 : 1, this.yLE ? 0 : 1, this.yLD, this.yLC, this.yFJ, this.jgR, z);
            com.tencent.mm.kernel.g.azz().a(this.yLx, 0);
            this.yLO++;
            if (this.yLR == -1) {
                this.yLR = System.currentTimeMillis();
            }
            AppMethodBeat.o(56044);
            return;
        }
        Log.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", Integer.valueOf(this.yFK));
        AppMethodBeat.o(56044);
    }

    private void x(int i2, int i3, boolean z) {
        String str;
        String str2;
        String str3;
        int i4;
        AppMethodBeat.i(56045);
        if (this.yLC == -85.0d || this.yLD == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", Double.valueOf(this.yLC), Double.valueOf(this.yLD));
        }
        String str4 = "";
        if (!z) {
            if (i3 >= 0 && i3 < this.yLt.getCount()) {
                str4 = this.yLt.Pz(i3).yMY;
                str2 = this.yLt.Pz(i3).yMO;
            }
            str2 = "";
        } else {
            if (i3 >= 0 && i3 < this.yLu.getCount()) {
                str4 = this.yLu.Pz(i3).yMY;
                str2 = this.yLu.Pz(i3).yMO;
            }
            str2 = "";
        }
        if (i3 == 0 && Util.isNullOrNil(str4) && this.yLt.getCount() > 1) {
            Log.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.yLt.Pz(1).yMY;
        }
        if (this.yLt.getCount() <= 0 || z) {
            str3 = "";
        } else {
            Log.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", Integer.valueOf(i3));
            str3 = this.yLt.Pz(0).dPI;
        }
        if (i3 == 0 && !z && this.yLt.getCount() > 0 && (i4 = this.yLt.Pz(0).yMZ) >= 0) {
            Log.d("MicroMsg.MMPoiMapUI", "change to search index: %s", Integer.valueOf(i4));
            i3 = i4;
        }
        Log.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", Integer.valueOf(i2), Integer.valueOf(i3 + 1), Long.valueOf(this.yLR), Long.valueOf(this.yLQ), Long.valueOf(this.yLP), Integer.valueOf(this.yLO), str, Integer.valueOf(this.yLS), str4, str3);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11135, Integer.valueOf(i2), Integer.valueOf(i3 + 1), Long.valueOf(this.yLR), Long.valueOf(this.yLQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.yLP), Integer.valueOf(this.yLO), str, str2, Integer.valueOf(this.yLS), str4, q.dr(true), 0, 0, 0, "", 0, str3);
        AppMethodBeat.o(56045);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b, com.tencent.mm.plugin.k.a
    public final void onResume() {
        AppMethodBeat.i(56046);
        super.onResume();
        this.yMn = true;
        d.bca().b(this.gmA, true);
        this.yLB.edh();
        AppMethodBeat.o(56046);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b, com.tencent.mm.plugin.k.a
    public final void onPause() {
        AppMethodBeat.i(56047);
        super.onPause();
        this.yMn = false;
        d.bca().c(this.gmA);
        MyPoiPoint myPoiPoint = this.yLB;
        Log.d("MicroMsg.MyPoiPoint", "disableLocation");
        myPoiPoint.yHL.c(myPoiPoint.gmA);
        AppMethodBeat.o(56047);
    }

    private void qK(boolean z) {
        AppMethodBeat.i(56048);
        Log.d("MicroMsg.MMPoiMapUI", "enable send.. %b", Boolean.valueOf(z));
        this.ygS.setEnabled(z);
        this.yLy.setEnabled(z);
        AppMethodBeat.o(56048);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.b, com.tencent.mm.plugin.k.a
    public final void onDestroy() {
        AppMethodBeat.i(56049);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(457, this);
        AppMethodBeat.o(56049);
    }

    private void edO() {
        AppMethodBeat.i(56050);
        for (PoiPoint poiPoint : this.yMj.values()) {
            poiPoint.remove();
        }
        this.yMj.clear();
        this.yMi = null;
        AppMethodBeat.o(56050);
    }

    private void edP() {
        AppMethodBeat.i(56051);
        ArrayList arrayList = new ArrayList(5);
        int i2 = 0;
        while (i2 < 5 && i2 < this.yLu.getCount()) {
            arrayList.add(this.yLu.Pz(i2));
            i2++;
        }
        List<f> fn = fn(arrayList);
        edO();
        for (int i3 = 0; i3 < fn.size(); i3++) {
            f Pz = this.yLu.Pz(i3);
            PoiPoint poiPoint = new PoiPoint(this.activity, this.yJa);
            poiPoint.setPosition(i3);
            poiPoint.setOnPointClick(this.yIr);
            this.yMj.put(new StringBuilder().append(Pz.cik).append(Pz.cil).toString(), poiPoint);
            poiPoint.c(Pz.cik, Pz.cil, false);
        }
        fo(fn);
        AppMethodBeat.o(56051);
    }

    private static List<f> fn(List<f> list) {
        AppMethodBeat.i(56052);
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != 0) {
                f fVar = list.get(i2);
                f fVar2 = (f) arrayList.get(arrayList.size() - 1);
                if (TencentLocationUtils.distanceBetween(fVar.cik, fVar.cil, fVar2.cik, fVar2.cil) > 5000.0d) {
                    break;
                }
                arrayList.add(fVar);
            } else {
                arrayList.add(list.get(0));
            }
        }
        AppMethodBeat.o(56052);
        return arrayList;
    }

    private void fo(List<f> list) {
        AppMethodBeat.i(56053);
        if (list.size() <= 0) {
            AppMethodBeat.o(56053);
        } else if (1 == list.size()) {
            this.yJa.getIController().animateTo(list.get(0).cik, list.get(0).cil);
            AppMethodBeat.o(56053);
        } else {
            ArrayList arrayList = new ArrayList(5);
            for (int i2 = 0; i2 < list.size(); i2++) {
                f fVar = list.get(i2);
                arrayList.add(new LatLng(fVar.cik, fVar.cil));
            }
            LatLngBounds build = LatLngBounds.builder().include(arrayList).build();
            if (Double.isInfinite(build.getNortheast().getLatitude()) || Double.isNaN(build.getNortheast().getLongitude()) || Double.isInfinite(build.getSouthwest().getLatitude()) || Double.isNaN(build.getSouthwest().getLongitude())) {
                AppMethodBeat.o(56053);
                return;
            }
            this.yJa.animateCamera(CameraUpdateFactory.newLatLngBounds(build, 250));
            AppMethodBeat.o(56053);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        Bitmap bitmap;
        AppMethodBeat.i(56054);
        if (qVar.getType() == 457) {
            if (i2 == 0 && i3 == 0) {
                this.yLx = null;
                com.tencent.mm.plugin.location.model.i iVar = (com.tencent.mm.plugin.location.model.i) qVar;
                if (!iVar.yFJ.equals(this.yFJ)) {
                    Log.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.yFJ + " " + iVar.yFJ);
                    AppMethodBeat.o(56054);
                    return;
                }
                Log.i("MicroMsg.MMPoiMapUI", "isEnd: " + iVar.idt + " searchId: " + iVar.hes + " isInSearch: " + this.yLE);
                if (this.yLP == -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.yLQ = currentTimeMillis;
                    this.yLP = currentTimeMillis;
                } else {
                    this.yLQ = System.currentTimeMillis();
                }
                this.yFK = iVar.yFK;
                this.yLv.setVisibility(8);
                if (!this.yLE) {
                    if (this.yLp != null) {
                        brx brx = (brx) iVar.rr.iLL.iLR;
                        PoiHeaderView poiHeaderView = this.yLp;
                        String str2 = brx.KTg;
                        String str3 = brx.LXv;
                        String str4 = brx.Url;
                        String aSY = com.tencent.mm.plugin.image.d.aSY();
                        Log.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", str3, str4);
                        poiHeaderView.yHX = str4;
                        poiHeaderView.yHY = "";
                        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                            poiHeaderView.setVisibility(8);
                            poiHeaderView.gyt.setVisibility(8);
                            poiHeaderView.yHZ.setVisibility(8);
                        } else {
                            poiHeaderView.setVisibility(0);
                            poiHeaderView.gyt.setVisibility(0);
                            poiHeaderView.yHZ.setVisibility(0);
                            poiHeaderView.gyt.setText(str2);
                            SimpleImageView simpleImageView = poiHeaderView.yHZ;
                            simpleImageView.imagePath = aSY;
                            simpleImageView.url = str3;
                            simpleImageView.targetWidth = 0;
                            simpleImageView.targetHeight = 0;
                            if (str3 == null || str3.length() == 0) {
                                simpleImageView.setVisibility(8);
                            } else if (str3.startsWith("http")) {
                                Bitmap decodeFile = MMBitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.b.g.getMessageDigest(str3.getBytes()));
                                if (decodeFile != null) {
                                    if (simpleImageView.targetWidth > 0 && simpleImageView.targetHeight > 0) {
                                        decodeFile = BitmapUtil.extractThumbNail(decodeFile, simpleImageView.targetWidth, simpleImageView.targetHeight, true, false);
                                    }
                                    simpleImageView.setImageBitmap(decodeFile);
                                } else {
                                    ThreadPool.post(new SimpleImageView.a(str3, simpleImageView.handler), "SimpleImageView_download");
                                }
                            } else if (!s.YS(str3)) {
                                simpleImageView.setVisibility(8);
                            } else {
                                if (simpleImageView.targetWidth <= 0 || simpleImageView.targetHeight <= 0) {
                                    bitmap = BitmapUtil.getBitmapNative(str3);
                                } else {
                                    bitmap = BitmapUtil.extractThumbNail(str3, simpleImageView.targetWidth, simpleImageView.targetHeight, true);
                                }
                                if (bitmap == null) {
                                    simpleImageView.setVisibility(8);
                                } else {
                                    simpleImageView.setImageBitmap(bitmap);
                                }
                            }
                        }
                    }
                    qK(true);
                    this.yLt.a(iVar.list, iVar.yFI, iVar.idt, iVar.yFJ);
                    this.yLt.va = 0;
                    this.yLt.notifyDataSetChanged();
                    if (!this.yLt.idt) {
                        this.yLr.gKM();
                        this.yLr.gKO();
                        AppMethodBeat.o(56054);
                        return;
                    }
                    this.yLr.gKN();
                    this.yLr.gKP();
                } else if (Util.isNullOrNil(this.jgR)) {
                    AppMethodBeat.o(56054);
                    return;
                } else {
                    if (iVar.list != null && iVar.list.size() == 0) {
                        this.yLz.setVisibility(0);
                        this.yLs.gKN();
                    }
                    Log.d("MicroMsg.MMPoiMapUI", "search is first: %s", Boolean.valueOf(iVar.isFirst()));
                    if (iVar.isFirst()) {
                        this.yLu.daZ = true;
                        this.yLu.yMH.clear();
                    }
                    this.yLu.a(iVar.list, iVar.yFI, iVar.idt, iVar.yFJ);
                    if (!this.yLu.idt) {
                        this.yLs.gKM();
                        this.yLs.gKO();
                    } else {
                        this.yLs.gKN();
                        this.yLs.gKP();
                    }
                    if (this.yMk) {
                        this.yMk = false;
                        edP();
                        AppMethodBeat.o(56054);
                        return;
                    }
                }
            } else {
                AppMethodBeat.o(56054);
                return;
            }
        }
        AppMethodBeat.o(56054);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.location.ui.impl.c$c  reason: collision with other inner class name */
    public enum EnumC1464c {
        COLLAPSED,
        OPENED;

        public static EnumC1464c valueOf(String str) {
            AppMethodBeat.i(56031);
            EnumC1464c cVar = (EnumC1464c) Enum.valueOf(EnumC1464c.class, str);
            AppMethodBeat.o(56031);
            return cVar;
        }

        static {
            AppMethodBeat.i(56032);
            AppMethodBeat.o(56032);
        }
    }

    private void b(EnumC1464c cVar) {
        AppMethodBeat.i(56055);
        if (EnumC1464c.COLLAPSED == cVar) {
            ((FrameLayout.LayoutParams) this.yLG.getLayoutParams()).topMargin = this.yLH;
            ((RelativeLayout.LayoutParams) this.yLN.getLayoutParams()).topMargin = 0;
            ((FrameLayout.LayoutParams) this.yLw.getLayoutParams()).topMargin = this.yLH - at.fromDPToPix(this.activity, 92);
            this.yJa.setLogoMargin(this.yLY);
        } else if (EnumC1464c.OPENED == cVar) {
            ((FrameLayout.LayoutParams) this.yLG.getLayoutParams()).topMargin = this.yLI;
            ((RelativeLayout.LayoutParams) this.yLN.getLayoutParams()).topMargin = -this.yLJ;
            ((FrameLayout.LayoutParams) this.yLw.getLayoutParams()).topMargin = this.yLI - at.fromDPToPix(this.activity, 92);
            this.yJa.setLogoMargin(this.yLZ);
        }
        this.yLG.requestLayout();
        this.yLw.requestLayout();
        this.yLN.requestLayout();
        AppMethodBeat.o(56055);
    }

    private int edQ() {
        AppMethodBeat.i(56056);
        int i2 = ((ViewGroup.MarginLayoutParams) this.yLG.getLayoutParams()).topMargin;
        AppMethodBeat.o(56056);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public class a extends TranslateAnimation {
        private List<View> yMx = new ArrayList();

        public a(float f2) {
            super(0.0f, 0.0f, 0.0f, f2);
            AppMethodBeat.i(56025);
            AppMethodBeat.o(56025);
        }

        public final a edU() {
            AppMethodBeat.i(56026);
            setDuration(200);
            AppMethodBeat.o(56026);
            return this;
        }

        public final a edV() {
            AppMethodBeat.i(56027);
            setFillEnabled(true);
            setFillAfter(true);
            AppMethodBeat.o(56027);
            return this;
        }

        public final a en(View view) {
            AppMethodBeat.i(56028);
            this.yMx.add(view);
            AppMethodBeat.o(56028);
            return this;
        }

        public final void startAnimation() {
            AppMethodBeat.i(56029);
            for (int i2 = 0; i2 < this.yMx.size(); i2++) {
                this.yMx.get(i2).startAnimation(this);
            }
            AppMethodBeat.o(56029);
        }
    }

    private void edR() {
        AppMethodBeat.i(56057);
        if (this.yLE) {
            this.yMc.setVisibility(8);
            this.yMd.setVisibility(0);
            this.yMg.setVisibility(0);
            AppMethodBeat.o(56057);
            return;
        }
        this.yMc.setVisibility(0);
        this.yMd.setVisibility(8);
        this.yMg.setVisibility(8);
        AppMethodBeat.o(56057);
    }

    private void edS() {
        View currentFocus;
        AppMethodBeat.i(56058);
        if (!this.yMo) {
            this.yMo = true;
            this.yMe.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
            if (!(inputMethodManager == null || (currentFocus = this.activity.getCurrentFocus()) == null || currentFocus.getWindowToken() == null)) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
        AppMethodBeat.o(56058);
    }

    private boolean edL() {
        AppMethodBeat.i(56035);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("KPickPoiLat", -85.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("KPickPoiLong", -85.0d);
        if (doubleExtra == -85.0d || doubleExtra2 == -1000.0d) {
            AppMethodBeat.o(56035);
            return false;
        }
        AppMethodBeat.o(56035);
        return true;
    }

    static /* synthetic */ void c(c cVar) {
        View currentFocus;
        IBinder windowToken;
        AppMethodBeat.i(56061);
        if (cVar.yMo) {
            cVar.yMo = false;
            cVar.yMe.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) cVar.activity.getSystemService("input_method");
            if (!(inputMethodManager == null || (currentFocus = cVar.activity.getCurrentFocus()) == null || (windowToken = currentFocus.getWindowToken()) == null)) {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        }
        AppMethodBeat.o(56061);
    }

    static /* synthetic */ void d(c cVar) {
        f Pz;
        AppMethodBeat.i(182073);
        if (cVar.yLE) {
            int i2 = cVar.yLu.va;
            if (i2 < 0 || i2 >= cVar.yLu.getCount()) {
                AppMethodBeat.o(182073);
                return;
            }
            Pz = cVar.yLu.Pz(i2);
        } else {
            int i3 = cVar.yLt.va;
            if (i3 < 0 || i3 >= cVar.yLt.getCount()) {
                AppMethodBeat.o(182073);
                return;
            }
            Pz = cVar.yLt.Pz(i3);
        }
        Intent intent = new Intent();
        LocationIntent locationIntent = new LocationIntent();
        locationIntent.lat = Pz.cik;
        locationIntent.lng = Pz.cil;
        locationIntent.iVi = Pz.yMX;
        locationIntent.kHV = Pz.mName;
        locationIntent.label = Pz.yMN;
        locationIntent.yFz = Pz.yMO;
        locationIntent.JTs = Pz.type;
        locationIntent.dRt = cVar.yJa.getZoomLevel();
        locationIntent.yFB = Pz.yMO;
        switch (cVar.type) {
            case 0:
                int i4 = yLT;
                int i5 = cVar.yLt.va;
                if (cVar.yLX) {
                    i4 = yLV;
                }
                cVar.x(i4, i5, cVar.yLX);
                break;
        }
        intent.putExtra("KLocationIntent", locationIntent);
        cVar.activity.setResult(-1, intent);
        cVar.activity.finish();
        AppMethodBeat.o(182073);
    }

    static /* synthetic */ void l(c cVar) {
        AppMethodBeat.i(56063);
        cVar.pN(false);
        AppMethodBeat.o(56063);
    }

    static /* synthetic */ boolean q(c cVar) {
        AppMethodBeat.i(56064);
        if (cVar.edQ() <= cVar.yLI) {
            AppMethodBeat.o(56064);
            return true;
        }
        AppMethodBeat.o(56064);
        return false;
    }

    static /* synthetic */ boolean r(c cVar) {
        AppMethodBeat.i(56065);
        if (cVar.edQ() >= cVar.yLH) {
            AppMethodBeat.o(56065);
            return true;
        }
        AppMethodBeat.o(56065);
        return false;
    }

    static /* synthetic */ MMLoadMoreListView s(c cVar) {
        if (cVar.yLE) {
            return cVar.yLs;
        }
        return cVar.yLr;
    }

    static /* synthetic */ void t(c cVar) {
        byte[] bArr;
        AppMethodBeat.i(56066);
        Log.i("MicroMsg.MMPoiMapUI", "loadingMore");
        if (cVar.yLx != null) {
            Log.i("MicroMsg.MMPoiMapUI", "scene is doing");
            AppMethodBeat.o(56066);
            return;
        }
        if (cVar.yLE) {
            if (cVar.yLu.buffer == null) {
                Log.i("MicroMsg.MMPoiMapUI", "buffer is null");
                AppMethodBeat.o(56066);
                return;
            }
            bArr = cVar.yLu.buffer;
        } else if (cVar.yLt.buffer == null) {
            Log.i("MicroMsg.MMPoiMapUI", "buffer is null");
            AppMethodBeat.o(56066);
            return;
        } else {
            bArr = cVar.yLt.buffer;
        }
        int i2 = cVar.yLF == 0 ? 0 : 1;
        if (!cVar.yLE) {
            cVar.yFJ = cVar.yLt.key;
        }
        cVar.yLx = new com.tencent.mm.plugin.location.model.i(bArr, cVar.lat, cVar.lng, i2, cVar.yLE ? 0 : 1, cVar.yLD, cVar.yLC, cVar.yFJ, cVar.jgR, false);
        com.tencent.mm.kernel.g.azz().a(cVar.yLx, 0);
        cVar.yLO++;
        AppMethodBeat.o(56066);
    }

    static /* synthetic */ void a(c cVar, int i2) {
        int i3;
        AppMethodBeat.i(56068);
        View childAt = cVar.yLs.getChildAt(0);
        if (childAt != null) {
            int height = childAt.getHeight();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= cVar.yLs.getChildCount()) {
                    i3 = 0;
                    break;
                }
                i5 = cVar.yLs.getChildAt(i4).getTop();
                if (i5 <= 0 && i5 > (-height)) {
                    i3 = i4 + cVar.yLs.getFirstVisiblePosition();
                    break;
                }
                i4++;
            }
            Log.d("MicroMsg.MMPoiMapUI", "pennqin top: %s, poiOri: %s, poiDes: %s.", Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2));
            int i6 = i2 - i3;
            Log.d("MicroMsg.MMPoiMapUI", "pennqin offset: %s.", Integer.valueOf(i6));
            int i7 = i5 + (height * i6);
            Log.d("MicroMsg.MMPoiMapUI", "pennqin distance: %s.", Integer.valueOf(i7));
            if (i7 == 0) {
                AppMethodBeat.o(56068);
                return;
            }
            cVar.yLs.smoothScrollBy(i7, Math.abs(i6) > 10 ? Math.abs(i6) * 100 : 300);
        }
        AppMethodBeat.o(56068);
    }

    static /* synthetic */ void H(c cVar) {
        AppMethodBeat.i(170181);
        cVar.yLE = true;
        cVar.yLg.setVisibility(8);
        cVar.yMp = false;
        if (cVar.yLM) {
            cVar.edS();
        }
        cVar.a(EnumC1464c.OPENED);
        cVar.edR();
        cVar.yMe.setText("");
        cVar.yMf.setVisibility(8);
        cVar.yLs.gKN();
        cVar.yLu.clean();
        cVar.yLu.notifyDataSetChanged();
        cVar.yLs.setVisibility(0);
        cVar.yLr.setVisibility(8);
        cVar.yLv.setVisibility(8);
        cVar.yLz.setVisibility(8);
        cVar.yLp.setVisibility(8);
        cVar.qK(false);
        cVar.yMm = cVar.yLw.isSelected();
        cVar.yLw.setSelected(false);
        AppMethodBeat.o(170181);
    }

    static /* synthetic */ void U(c cVar) {
        AppMethodBeat.i(177540);
        if (cVar.edL()) {
            double doubleExtra = cVar.activity.getIntent().getDoubleExtra("KPickPoiLat", -85.0d);
            double doubleExtra2 = cVar.activity.getIntent().getDoubleExtra("KPickPoiLong", -85.0d);
            if (!(doubleExtra == -85.0d || doubleExtra2 == -1000.0d)) {
                cVar.lat = doubleExtra;
                cVar.lng = doubleExtra2;
                cVar.yLq.l(cVar.lat, cVar.lng);
                cVar.yJa.getIController().animateTo(doubleExtra, doubleExtra2, com.tencent.mm.plugin.location.ui.d.ede());
                cVar.pN(false);
            }
        }
        AppMethodBeat.o(177540);
    }
}
