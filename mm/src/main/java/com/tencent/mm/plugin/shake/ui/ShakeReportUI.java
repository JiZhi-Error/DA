package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.n;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.c.b.a;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShakeReportUI extends MMActivity implements bc, u.a, l.a, f.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    private static List<h.a> gmy = new CopyOnWriteArrayList();
    private boolean DjV = false;
    private boolean DjW = false;
    private boolean DjX;
    private boolean DjY = false;
    private boolean DjZ = false;
    private Dialog DkA;
    private ImageView DkB = null;
    private d DkC = null;
    private ImageView DkD;
    private ImageView DkE;
    private ImageView DkF;
    private ImageView DkG;
    private ImageView DkH;
    private ImageView DkI;
    private TextView DkJ;
    private int DkK = 1;
    private int DkL = 0;
    private View DkM;
    private ImageView DkN;
    private ImageView DkO;
    private ImageView DkP;
    private ImageView DkQ;
    private View DkR;
    private View DkS;
    private View DkT;
    private View DkU;
    private int DkV = 0;
    private com.tencent.mm.plugin.shake.c.b.a DkW;
    private boolean DkX = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> DkY = new HashMap();
    private boolean DkZ = false;
    private boolean Dka = false;
    private boolean Dkb = false;
    private int Dkc = 22;
    private c Dkd;
    private l Dke = new l();
    private g Dkf;
    private View Dkg;
    private View Dkh;
    private TextView Dki;
    private TextView Dkj;
    private TextView Dkk;
    private View Dkl;
    private View Dkm;
    private View Dkn;
    private View Dko;
    private Animation Dkp;
    private Animation Dkq;
    private Animation Dkr;
    private Animation Dks;
    private View Dkt = null;
    private View Dku = null;
    private MMImageView Dkv = null;
    private TextView Dkw = null;
    private ImageView Dkx = null;
    private String Dky = "";
    private Bitmap Dkz = null;
    private boolean Dla = false;
    private boolean Dlb = false;
    private boolean Dlc = false;
    private int Dld = 1;
    private long Dle = 0;
    private boolean Dlf = false;
    private IListener Dlg = new IListener<ei>() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass24 */

        {
            AppMethodBeat.i(161436);
            this.__eventId = ei.class.getName().hashCode();
            AppMethodBeat.o(161436);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ei eiVar) {
            AppMethodBeat.i(28474);
            ei eiVar2 = eiVar;
            String str = eiVar2.dHG.dHE;
            int i2 = eiVar2.dHG.dHH;
            int i3 = eiVar2.dHG.dHI;
            String str2 = eiVar2.dHG.dHL;
            double d2 = eiVar2.dHG.dHK;
            int i4 = eiVar2.dHG.dHM;
            if (!ShakeReportUI.this.gmx.containsKey(str + "," + i2 + "," + i3)) {
                h.a aVar = new h.a();
                aVar.uuid = str;
                aVar.jiP = eiVar2.dHG.dHJ;
                aVar.major = i2;
                aVar.minor = i3;
                aVar.DiU = str2;
                aVar.DiV = d2;
                aVar.DiW = i4;
                ShakeReportUI.this.gmx.put(str + "," + i2 + "," + i3, aVar);
                if (eiVar2.dHG.dHJ >= 0.0d && ShakeReportUI.gmy.size() > 0) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= ShakeReportUI.gmy.size()) {
                            break;
                        }
                        h.a aVar2 = (h.a) ShakeReportUI.gmy.get(i5);
                        if (eiVar2.dHG.dHJ >= aVar2.jiP) {
                            if (i5 == ShakeReportUI.gmy.size() - 1 && eiVar2.dHG.dHJ > aVar2.jiP) {
                                ShakeReportUI.gmy.add(aVar);
                                break;
                            }
                            i5++;
                        } else {
                            ShakeReportUI.gmy.add(i5, aVar);
                            break;
                        }
                    }
                } else {
                    ShakeReportUI.gmy.add(aVar);
                }
                if (ShakeReportUI.this.gmx.size() == 1 && !ShakeReportUI.this.Dlf) {
                    ShakeReportUI.this.Dle = System.currentTimeMillis() - ShakeReportUI.this.Dle;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11497, String.valueOf((int) (((double) (ShakeReportUI.this.Dle / 1000)) + 0.5d)), 0, Integer.valueOf((int) ShakeReportUI.this.Dle));
                    ShakeReportUI.this.Dle = 0;
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass24.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(28473);
                            ShakeReportUI.j(ShakeReportUI.this);
                            AppMethodBeat.o(28473);
                        }
                    });
                }
            }
            Log.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", str + "," + i2 + "," + i3, Integer.valueOf(ShakeReportUI.this.gmx.size()));
            AppMethodBeat.o(28474);
            return false;
        }
    };
    private IListener Dlh = new IListener<eo>() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass25 */

        {
            AppMethodBeat.i(161437);
            this.__eventId = eo.class.getName().hashCode();
            AppMethodBeat.o(161437);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(eo eoVar) {
            int i2;
            AppMethodBeat.i(28476);
            eo eoVar2 = eoVar;
            Log.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(eoVar2.dHV.dHW));
            boolean hasSystemFeature = ShakeReportUI.this.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (eoVar2.dHV.dHW == 10 && Build.VERSION.SDK_INT >= 18 && hasSystemFeature) {
                ShakeReportUI.k(ShakeReportUI.this);
            } else if (eoVar2.dHV.dHW == 12) {
                if (Build.VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    ShakeReportUI.this.Dld = 1;
                } else {
                    ShakeReportUI.l(ShakeReportUI.this);
                    ShakeReportUI.this.Dld = 0;
                }
                bz aWj = bz.aWj();
                String nullAsNil = Util.nullAsNil(aWj.provinceCode);
                String nullAsNil2 = Util.nullAsNil(aWj.cityCode);
                if (hasSystemFeature) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (ShakeReportUI.this.Dla) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13139, nullAsNil, nullAsNil2, 1, Integer.valueOf(ShakeReportUI.this.Dld), 1, Integer.valueOf(i2));
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13139, nullAsNil, nullAsNil2, 0, Integer.valueOf(ShakeReportUI.this.Dld), 1, Integer.valueOf(i2));
                }
                if (ShakeReportUI.this.Dlb && ShakeReportUI.this.Dla && !ShakeReportUI.this.Dlf && ShakeReportUI.this.DkL < 4) {
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass25.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(28475);
                            ShakeReportUI.j(ShakeReportUI.this);
                            AppMethodBeat.o(28475);
                        }
                    });
                }
            }
            AppMethodBeat.o(28476);
            return false;
        }
    };
    private View.OnClickListener Dli = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass18 */
        public long DjA = 0;

        public final void onClick(View view) {
            AppMethodBeat.i(28467);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (Util.isNullOrNil((String) ShakeReportUI.this.Dkg.getTag())) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28467);
            } else if (ShakeReportUI.this.DkC == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28467);
            } else {
                d dVar = ShakeReportUI.this.DkC;
                String str = dVar.field_username;
                if (11 == dVar.field_type) {
                    if (System.currentTimeMillis() - this.DjA > 3000) {
                        this.DjA = System.currentTimeMillis();
                        if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", dVar.getCity());
                            intent.putExtra("scene", 27);
                            intent.putExtra("stastic_scene", 5);
                            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            String[] split = dVar.field_reserved3.split(",");
                            wq wqVar = new wq();
                            wqVar.ecI.userName = split[0];
                            wqVar.ecI.ecK = Util.nullAs(split[1], "");
                            wqVar.ecI.ecL = Util.getInt(split[2], 0);
                            wqVar.ecI.scene = 1077;
                            EventCenter.instance.publish(wqVar);
                        }
                        l.b bVar2 = ShakeReportUI.this.Dke.DgW;
                        if (bVar2 != null && (bVar2 instanceof h)) {
                            h.a(dVar);
                            h.b(dVar);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(28467);
                    return;
                }
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (Kn.gBM()) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, str + "," + ShakeReportUI.this.Dkc);
                            intent2.putExtra("Contact_Scene", ShakeReportUI.this.Dkc);
                        }
                        com.tencent.mm.plugin.shake.a.jRt.c(intent2, ShakeReportUI.this);
                    }
                } else {
                    if ((dVar.field_reserved1 & 8) > 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, dVar.field_username + "," + ShakeReportUI.this.Dkc);
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("Contact_User", dVar.field_username);
                    intent3.putExtra("Contact_Nick", dVar.field_nickname);
                    intent3.putExtra("Contact_Distance", dVar.field_distance);
                    intent3.putExtra("Contact_Signature", dVar.field_signature);
                    intent3.putExtra("Contact_Province", dVar.getProvince());
                    intent3.putExtra("Contact_City", dVar.getCity());
                    intent3.putExtra("Contact_Sex", dVar.field_sex);
                    intent3.putExtra("Contact_IsLBSFriend", true);
                    intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                    intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                    intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                    intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                    intent3.putExtra("Contact_Scene", ShakeReportUI.this.Dkc);
                    intent3.putExtra("Sns_from_Scene", 22);
                    com.tencent.mm.plugin.shake.a.jRt.c(intent3, ShakeReportUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28467);
            }
        }
    };
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(28446);
            if (z) {
                Log.d("MicroMsg.ShakeReportUI", "on location get ok");
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_LATITUDE_STRING, String.valueOf(f3));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, String.valueOf(f2));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_ACCURACY_STRING, String.valueOf(d3));
                ShakeReportUI.this.gmw = true;
                if (ShakeReportUI.this.gmt != null) {
                    ShakeReportUI.this.gmt.c(ShakeReportUI.this.gmA);
                }
            } else {
                if (!ShakeReportUI.this.uSu && !com.tencent.mm.modelgeo.d.bcc()) {
                    ShakeReportUI.this.uSu = true;
                    com.tencent.mm.ui.base.h.a((Context) ShakeReportUI.this, ShakeReportUI.this.getString(R.string.dvi), ShakeReportUI.this.getString(R.string.zb), ShakeReportUI.this.getString(R.string.e_k), ShakeReportUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(28445);
                            com.tencent.mm.modelgeo.d.cZ(ShakeReportUI.this);
                            AppMethodBeat.o(28445);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                Log.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            AppMethodBeat.o(28446);
            return false;
        }
    };
    private com.tencent.mm.modelgeo.d gmt;
    private boolean gmw = false;
    private Map<String, h.a> gmx = new ConcurrentHashMap();
    private ImageView gyr;
    private com.tencent.mm.av.a.a jaq = null;
    private boolean kgv = true;
    private com.tencent.mm.pluginsdk.l.d shakeSensor;
    private boolean uSu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeReportUI() {
        AppMethodBeat.i(28483);
        AppMethodBeat.o(28483);
    }

    static /* synthetic */ void B(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(28536);
        shakeReportUI.eVi();
        AppMethodBeat.o(28536);
    }

    static /* synthetic */ void D(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(28537);
        shakeReportUI.eUY();
        AppMethodBeat.o(28537);
    }

    static /* synthetic */ void J(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(28538);
        shakeReportUI.XD(1);
        AppMethodBeat.o(28538);
    }

    static /* synthetic */ void K(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(28539);
        shakeReportUI.uB(false);
        AppMethodBeat.o(28539);
    }

    static /* synthetic */ void a(ShakeReportUI shakeReportUI, View view) {
        AppMethodBeat.i(28531);
        shakeReportUI.eW(view);
        AppMethodBeat.o(28531);
    }

    static /* synthetic */ void a(ShakeReportUI shakeReportUI, e eVar) {
        AppMethodBeat.i(28540);
        shakeReportUI.a(eVar);
        AppMethodBeat.o(28540);
    }

    static /* synthetic */ void d(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.i(28532);
        shakeReportUI.uC(z);
        AppMethodBeat.o(28532);
    }

    static /* synthetic */ void f(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.i(28535);
        shakeReportUI.uy(z);
        AppMethodBeat.o(28535);
    }

    static /* synthetic */ void w(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(28533);
        shakeReportUI.eVc();
        AppMethodBeat.o(28533);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brt;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28484);
        super.onCreate(bundle);
        setMMTitle(R.string.gzg);
        setActionbarColor(getResources().getColor(R.color.z));
        setNavigationbarColor(getResources().getColor(R.color.z));
        hideActionbarLine();
        this.gmt = com.tencent.mm.modelgeo.d.bca();
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_LATITUDE_STRING, "");
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, "");
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SHAKE_TV_ACCURACY_STRING, "");
        f eUr = m.eUr();
        if (eUr.pQG == null) {
            eUr.pQG = new ArrayList();
        }
        eUr.pQG.add(new WeakReference<>(this));
        initView();
        this.Dkd = new c(getBodyView());
        this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
        if (!this.shakeSensor.gom()) {
            com.tencent.mm.ui.base.h.a(this, (int) R.string.gz8, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(28461);
                    ShakeReportUI.this.finish();
                    AppMethodBeat.o(28461);
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.jRu != null) {
            com.tencent.mm.plugin.shake.a.jRu.WZ();
        }
        u.b(this);
        Log.i("MicroMsg.ShakeReportUI", "%s", getResources().getDisplayMetrics().toString());
        int ctM = m.eUn().ctM();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11317, Integer.valueOf(ctM), e.eVk());
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11710, 1);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 0, 1);
        AppMethodBeat.o(28484);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(28485);
        super.onResume();
        if (this.kgv) {
            if (!com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null))) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
                Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
                if (!a2) {
                    AppMethodBeat.o(28485);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
                if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.el_, new Object[]{LocaleUtil.getApplicationLanguage()}), 30764, true);
                    AppMethodBeat.o(28485);
                    return;
                }
                com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
                AppMethodBeat.o(28485);
                return;
            }
        }
        eHs();
        AppMethodBeat.o(28485);
    }

    private void eHs() {
        AppMethodBeat.i(28486);
        eUW();
        bg.aVF();
        com.tencent.mm.model.c.a(this);
        bg.aVF();
        com.tencent.mm.model.c.azQ().add(this);
        m.eUm().add(this);
        if (this.Dke.DgW != null) {
            this.Dke.DgW.resume();
        }
        eUX();
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(28471);
                if (ShakeReportUI.this.shakeSensor != null) {
                    ShakeReportUI.this.shakeSensor.gol();
                }
                AppMethodBeat.o(28471);
            }
        }, 1000);
        if (this.shakeSensor != null) {
            this.shakeSensor.gol();
        }
        uB(false);
        uC(false);
        eUZ();
        bg.aVF();
        String str = (String) com.tencent.mm.model.c.azQ().get(327696, "1");
        if (k.eUk()) {
            if (this.DkK == 4) {
                ux(true);
            }
            if (str.equals("4")) {
                eW(findViewById(R.id.hol));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            eW(findViewById(R.id.hoi));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.eUL()) {
            eW(findViewById(R.id.ho9));
        }
        boolean cP = com.tencent.mm.y.c.axV().cP(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.ay.e.bek() && this.Dke.DgV != 3) {
            getIntent().putExtra("shake_music", false);
            this.DkK = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.Dke.DgV != 4 && k.eUk()) {
            getIntent().putExtra("shake_tv", false);
            this.DkK = 4;
        } else if (this.Dke.DgV != 6 && com.tencent.mm.plugin.shake.c.c.a.eUL() && (cP || getIntent().getBooleanExtra("shake_card", false))) {
            this.DkV = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            Log.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.DkK = 6;
        }
        eUY();
        uy(true);
        Log.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", Boolean.valueOf(ac.jOs));
        if (ac.jOs) {
            bg.azz().a(new n(7), 0);
        }
        eVi();
        eVf();
        AppMethodBeat.o(28486);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(28487);
        bg.aVF();
        com.tencent.mm.model.c.b(this);
        bg.aVF();
        com.tencent.mm.model.c.azQ().remove(this);
        m.eUm().remove(this);
        if (this.Dke.DgW != null) {
            this.Dke.DgW.pause();
        }
        this.Dka = false;
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
        }
        this.Dkd.eUS();
        if (this.DkK != 5) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(327696, new StringBuilder().append(this.DkK).toString());
        }
        if (this.DkK == 4) {
            ux(false);
        }
        super.onPause();
        AppMethodBeat.o(28487);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        f.a aVar;
        int i2 = 0;
        AppMethodBeat.i(28488);
        if (this.Dkz != null && !this.Dkz.isRecycled()) {
            this.Dkz.recycle();
        }
        if (this.DkA != null && this.DkA.isShowing()) {
            this.DkA.dismiss();
            this.DkA = null;
        }
        if (this.Dke.DgW != null) {
            this.Dke.DgW.eTQ();
        }
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
            this.shakeSensor = null;
        }
        j a2 = j.a((l.a) null);
        if (j.iCs) {
            j.iCs = false;
            if (!a2.DiX.eUN()) {
                Log.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        j.DiY = null;
        u.c(this);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.FALSE);
        if (com.tencent.mm.plugin.shake.c.c.a.eUL()) {
            com.tencent.mm.y.c.axV().B(262154, false);
        }
        eVc();
        f eUr = m.eUr();
        if (eUr.pQG != null) {
            while (true) {
                if (i2 < eUr.pQG.size()) {
                    WeakReference<f.a> weakReference = eUr.pQG.get(i2);
                    if (weakReference != null && (aVar = weakReference.get()) != null && aVar.equals(this)) {
                        eUr.pQG.remove(weakReference);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.d eUs = m.eUs();
        eUs.gmu = -85.0f;
        eUs.gmv = -1000.0f;
        if (this.gmt != null) {
            this.gmt.c(this.gmA);
        }
        super.onDestroy();
        AppMethodBeat.o(28488);
    }

    static {
        AppMethodBeat.i(28541);
        AppMethodBeat.o(28541);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28491);
        com.tencent.mm.plugin.shake.c.c.a.eUg();
        this.DkY.put(1, Boolean.TRUE);
        this.DkY.put(3, Boolean.FALSE);
        this.DkY.put(4, Boolean.FALSE);
        this.DkY.put(5, Boolean.FALSE);
        this.DkY.put(6, Boolean.FALSE);
        this.jaq = new com.tencent.mm.av.a.a(this);
        this.Dki = (TextView) findViewById(R.id.ho7);
        this.Dkh = findViewById(R.id.hom);
        this.Dkj = (TextView) findViewById(R.id.ho2);
        this.Dkk = (TextView) findViewById(R.id.ho6);
        this.DkM = findViewById(R.id.hp0);
        this.DkN = (ImageView) findViewById(R.id.hoo);
        this.DkO = (ImageView) findViewById(R.id.hoq);
        this.DkP = (ImageView) findViewById(R.id.hos);
        this.DkQ = (ImageView) findViewById(R.id.hou);
        this.DkR = findViewById(R.id.hop);
        this.DkS = findViewById(R.id.hor);
        this.DkT = findViewById(R.id.hot);
        this.DkU = findViewById(R.id.hov);
        this.Dkg = findViewById(R.id.ho5);
        this.Dkg.setOnClickListener(this.Dli);
        this.gyr = (ImageView) this.Dkg.findViewById(R.id.hnr);
        this.gyr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass26 */

            public final void onClick(View view) {
                AppMethodBeat.i(28477);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ShakeReportUI.this.DkK != 5) {
                    Intent intent = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
                    intent.putExtra(ch.COL_USERNAME, (String) ShakeReportUI.this.Dkg.getTag());
                    ShakeReportUI shakeReportUI = ShakeReportUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    shakeReportUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28477);
            }
        });
        eUW();
        View inflate = View.inflate(getContext(), R.layout.brp, null);
        this.DkA = new i(getContext(), R.style.a66);
        this.DkA.setContentView(inflate);
        this.DkA.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28450);
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass4.AnonymousClass1 */

                    public final boolean queueIdle() {
                        AppMethodBeat.i(28449);
                        com.tencent.mm.ui.base.u.q(ShakeReportUI.this, ShakeReportUI.this.getString(R.string.gzp));
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(4117, Boolean.TRUE);
                        AppMethodBeat.o(28449);
                        return false;
                    }
                });
                AppMethodBeat.o(28450);
            }
        });
        ((Button) inflate.findViewById(R.id.hnh)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(28451);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ShakeReportUI.this.DkA.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28451);
            }
        });
        bg.aVF();
        boolean nullAsFalse = Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(4108, (Object) null));
        bg.aVF();
        boolean nullAsFalse2 = Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(4117, (Object) null));
        if (!nullAsFalse) {
            inflate.setVisibility(0);
            this.DkA.show();
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(4108, Boolean.TRUE);
        } else if (!nullAsFalse2) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass6 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(28452);
                    com.tencent.mm.ui.base.u.q(ShakeReportUI.this, ShakeReportUI.this.getString(R.string.gzp));
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(4117, Boolean.TRUE);
                    AppMethodBeat.o(28452);
                    return false;
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass27 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28478);
                ShakeReportUI.this.DjY = false;
                ShakeReportUI.this.finish();
                AppMethodBeat.o(28478);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.d0, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass28 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28479);
                ShakeReportUI.this.DjY = false;
                Intent intent = new Intent();
                intent.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
                ShakeReportUI.this.startActivityForResult(intent, 3);
                AppMethodBeat.o(28479);
                return true;
            }
        });
        AnonymousClass29 r1 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass29 */

            public final void onClick(View view) {
                AppMethodBeat.i(28480);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ShakeReportUI.a(ShakeReportUI.this, view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28480);
            }
        };
        if (this.Dlc || this.Dla) {
            this.DkB = (ImageView) findViewById(R.id.hof);
        } else {
            this.DkB = (ImageView) findViewById(R.id.hoe);
        }
        this.DkD = (ImageView) findViewById(R.id.hob);
        this.DkE = (ImageView) findViewById(R.id.hoh);
        this.DkF = (ImageView) findViewById(R.id.hok);
        this.DkG = (ImageView) findViewById(R.id.ho8);
        this.DkJ = (TextView) findViewById(R.id.hoa);
        this.DkI = (ImageView) findViewById(R.id.ho_);
        this.DkH = (ImageView) findViewById(R.id.hoj);
        eVe();
        findViewById(R.id.hog).setOnClickListener(r1);
        findViewById(R.id.hoc).setOnClickListener(r1);
        findViewById(R.id.hoi).setOnClickListener(r1);
        findViewById(R.id.hol).setOnClickListener(r1);
        findViewById(R.id.ho9).setOnClickListener(r1);
        eVa();
        eVd();
        eVi();
        AppMethodBeat.o(28491);
    }

    private void eUV() {
        AppMethodBeat.i(28492);
        if (com.tencent.mm.ay.e.bel()) {
            bg.aVF();
            if (com.tencent.mm.model.c.azQ().getInt(4118, 0) == 0) {
                d.a aVar = new d.a(getContext());
                aVar.aoO(R.string.zb);
                aVar.aoS(R.string.gyj);
                aVar.aoV(R.string.gyi).c(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(28447);
                        if (ShakeReportUI.this.DkA != null) {
                            ShakeReportUI.this.DkA.cancel();
                        }
                        AppMethodBeat.o(28447);
                    }
                });
                aVar.Dk(true);
                aVar.f(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(28448);
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().setInt(4118, 1);
                        ShakeReportUI.this.DkH.setVisibility(8);
                        AppMethodBeat.o(28448);
                    }
                });
                this.DkA = aVar.hbn();
                this.DkA.show();
            }
        }
        AppMethodBeat.o(28492);
    }

    private void eUW() {
        BitmapDrawable bitmapDrawable;
        AppMethodBeat.i(28493);
        bg.aVF();
        int nullAs = Util.nullAs((Integer) com.tencent.mm.model.c.azQ().get(12290, (Object) null), 0);
        ImageView imageView = (ImageView) findViewById(R.id.ho3);
        if (this.Dkz != null && !this.Dkz.isRecycled()) {
            this.Dkz.recycle();
        }
        bg.aVF();
        if (Util.nullAsTrue((Boolean) com.tencent.mm.model.c.azQ().get(4110, (Object) null))) {
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            String sb2 = sb.append(com.tencent.mm.model.c.aSY()).append("default_shake_img_filename.jpg").toString();
            if (s.YS(sb2)) {
                this.Dkz = u.Sq(sb2);
                imageView.setImageDrawable(new BitmapDrawable(this.Dkz));
            } else {
                try {
                    bitmapDrawable = new BitmapDrawable(BackwardSupportUtil.BitmapFactory.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e2) {
                    Log.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e2.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            bg.aVF();
            this.Dkz = u.Sq((String) com.tencent.mm.model.c.azQ().get(4111, (Object) null));
            imageView.setImageDrawable(new BitmapDrawable(this.Dkz));
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.hnp);
        ImageView imageView3 = (ImageView) findViewById(R.id.hno);
        imageView2.setImageResource(nullAs == 2 ? R.drawable.cne : R.drawable.cnf);
        imageView3.setImageResource(nullAs == 2 ? R.drawable.cnd : R.drawable.cnc);
        AnonymousClass7 r2 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(28455);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!ShakeReportUI.this.DjW) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(28455);
                    return;
                }
                ShakeReportUI.this.Dka = false;
                ShakeReportUI.this.DjV = true;
                ShakeReportUI.d(ShakeReportUI.this, false);
                AppCompatActivity context = ShakeReportUI.this.getContext();
                String[] strArr = {ShakeReportUI.this.getString(R.string.gyn)};
                AnonymousClass1 r4 = new h.d() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass7.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(28453);
                        ShakeReportUI.this.Dka = true;
                        switch (i2) {
                            case 0:
                                com.tencent.mm.pluginsdk.ui.tools.s.c(ShakeReportUI.this, 1, null);
                                break;
                        }
                        AppMethodBeat.o(28453);
                    }
                };
                new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass7.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(28454);
                        ShakeReportUI.this.Dka = true;
                        AppMethodBeat.o(28454);
                    }
                };
                com.tencent.mm.ui.base.h.c(context, null, strArr, "", r4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28455);
            }
        };
        imageView2.setOnClickListener(r2);
        imageView3.setOnClickListener(r2);
        if (this.Dkn == null) {
            this.Dkn = findViewById(R.id.hnl);
        }
        this.Dkn.setOnClickListener(r2);
        if (this.Dko == null) {
            this.Dko = findViewById(R.id.hnm);
        }
        this.Dko.setOnClickListener(r2);
        AppMethodBeat.o(28493);
    }

    private void eUX() {
        AppMethodBeat.i(28494);
        this.Dka = true;
        if (this.DkW != null && this.DkW.isShowing() && !this.DkW.Did) {
            this.Dka = false;
        }
        Log.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (this.shakeSensor != null && !this.shakeSensor.gok()) {
            this.shakeSensor.a(new a(this));
            if (!this.shakeSensor.gom() || this.Dki == null) {
                this.Dki.setText(getString(R.string.gz8));
            } else {
                this.Dki.setText(getString(R.string.gxj));
                AppMethodBeat.o(28494);
                return;
            }
        }
        AppMethodBeat.o(28494);
    }

    private void ux(boolean z) {
        AppMethodBeat.i(28495);
        String format = String.format("%1$s-shaketype-%2$d", getClass().getName(), 4);
        Log.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        aa.d(z, new Intent().putExtra("classname", format));
        AppMethodBeat.o(28495);
    }

    /* access modifiers changed from: package-private */
    public static class a extends d.a {
        WeakReference<ShakeReportUI> Dlq;
        private final long[] VIRBRATOR_PATTERN = {300, 200, 300, 200};
        private long lastShakeTime = Util.currentTicks();
        private Vibrator paT;

        public a(ShakeReportUI shakeReportUI) {
            AppMethodBeat.i(28481);
            this.Dlq = new WeakReference<>(shakeReportUI);
            AppMethodBeat.o(28481);
        }

        @Override // com.tencent.mm.pluginsdk.l.d.a
        public final void onShake(boolean z) {
            AppMethodBeat.i(28482);
            ShakeReportUI shakeReportUI = this.Dlq.get();
            if (shakeReportUI == null) {
                AppMethodBeat.o(28482);
            } else if (shakeReportUI.isFinishing()) {
                Log.e("MicroMsg.ShakeReportUI", "ui finished");
                AppMethodBeat.o(28482);
            } else if (!shakeReportUI.Dka) {
                Log.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                AppMethodBeat.o(28482);
            } else {
                ShakeReportUI.w(shakeReportUI);
                long ticksToNow = Util.ticksToNow(this.lastShakeTime);
                if (ticksToNow < 1200) {
                    Log.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(ticksToNow)));
                    AppMethodBeat.o(28482);
                    return;
                }
                Log.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(ticksToNow)));
                this.lastShakeTime = Util.currentTicks();
                if (shakeReportUI.Dkd != null) {
                    c cVar = shakeReportUI.Dkd;
                    if (cVar.view != null) {
                        cVar.view.setKeepScreenOn(true);
                    }
                    cVar.timer.startTimer(30000);
                }
                if (shakeReportUI.Dkf != null) {
                    g gVar = shakeReportUI.Dkf;
                    if (gVar.KbY != null) {
                        gVar.KbY.dismiss();
                    }
                }
                if (shakeReportUI.DjX) {
                    ShakeReportUI shakeReportUI2 = this.Dlq.get();
                    if (shakeReportUI2 != null) {
                        PlaySound.play(shakeReportUI2, R.string.gzt);
                    }
                } else {
                    ShakeReportUI shakeReportUI3 = this.Dlq.get();
                    if (shakeReportUI3 != null) {
                        if (this.paT == null) {
                            this.paT = (Vibrator) shakeReportUI3.getSystemService("vibrator");
                        }
                        if (this.paT != null) {
                            this.paT.vibrate(this.VIRBRATOR_PATTERN, -1);
                        }
                    }
                }
                reset();
                ShakeReportUI.A(shakeReportUI);
                AppMethodBeat.o(28482);
            }
        }

        @Override // com.tencent.mm.pluginsdk.l.d.a
        public final void onRelease() {
        }
    }

    private void eUY() {
        AppMethodBeat.i(28496);
        if (this.DkK == 3 && com.tencent.mm.ay.e.bek()) {
            this.DkK = 3;
            this.Dkk.setText(R.string.gzn);
            this.DkB.setBackgroundResource(R.drawable.cn9);
            this.DkD.setBackgroundResource(R.drawable.bn4);
            this.DkE.setBackgroundResource(R.drawable.bn3);
            this.DkF.setBackgroundResource(R.drawable.bn6);
            this.DkG.setBackgroundResource(R.drawable.cn6);
            findViewById(R.id.ho4).setVisibility(0);
            setMMTitle(R.string.gzj);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11720, 2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 2, 1);
        } else if (this.DkK == 4 && k.eUk()) {
            this.DkK = 4;
            this.Dkk.setText(R.string.gzo);
            this.DkB.setBackgroundResource(R.drawable.cn9);
            this.DkD.setBackgroundResource(R.drawable.bn4);
            this.DkE.setBackgroundResource(R.drawable.bn2);
            this.DkF.setBackgroundResource(R.drawable.bn7);
            this.DkG.setBackgroundResource(R.drawable.cn6);
            findViewById(R.id.ho4).setVisibility(0);
            setMMTitle(R.string.gzk);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11720, 3);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 3, 1);
        } else if (this.DkK == 5 && eVg()) {
            this.DkK = 5;
            this.Dkk.setText(R.string.gzm);
            this.DkB.setBackgroundResource(R.drawable.cn_);
            this.DkD.setBackgroundResource(R.drawable.bn4);
            this.DkE.setBackgroundResource(R.drawable.bn2);
            this.DkF.setBackgroundResource(R.drawable.bn6);
            this.DkG.setBackgroundResource(R.drawable.cn6);
            findViewById(R.id.ho4).setVisibility(0);
            setMMTitle(R.string.gzi);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11720, 4);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 4, 1);
        } else if (this.DkK != 6 || !com.tencent.mm.plugin.shake.c.c.a.eUL()) {
            this.DkK = 1;
            this.Dkk.setText(R.string.gy3);
            this.DkB.setBackgroundResource(R.drawable.cn9);
            this.DkD.setBackgroundResource(R.drawable.bn5);
            this.DkE.setBackgroundResource(R.drawable.bn2);
            this.DkF.setBackgroundResource(R.drawable.bn6);
            this.DkG.setBackgroundResource(R.drawable.cn6);
            if (com.tencent.mm.ay.e.bek()) {
                findViewById(R.id.ho4).setVisibility(0);
            }
            setMMTitle(R.string.gzg);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11720, 1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 1, 1);
        } else {
            this.DkK = 6;
            this.Dkk.setText(R.string.gzl);
            this.DkB.setBackgroundResource(R.drawable.cn9);
            this.DkD.setBackgroundResource(R.drawable.bn4);
            this.DkE.setBackgroundResource(R.drawable.bn2);
            this.DkF.setBackgroundResource(R.drawable.bn6);
            this.DkG.setBackgroundResource(R.drawable.cn7);
            findViewById(R.id.ho4).setVisibility(0);
            setMMTitle(R.string.gzh);
            eVb();
            eVe();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11720, 5);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(834, 5, 1);
        }
        l.b a2 = this.Dke.a(this, this.DkK, this);
        if (!this.DjY) {
            uC(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.eUL() && (a2 instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            ((com.tencent.mm.plugin.shake.c.a.g) a2).setFromScene(this.DkV);
            if (this.DkV == 3) {
                Log.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                ((com.tencent.mm.plugin.shake.c.a.g) a2).Rv(getIntent().getStringExtra("key_shake_card_ext_info"));
            }
        }
        AppMethodBeat.o(28496);
    }

    private void eUZ() {
        AppMethodBeat.i(28497);
        bg.aVF();
        this.DjX = Util.nullAsTrue((Boolean) com.tencent.mm.model.c.azQ().get(4112, (Object) null));
        if (this.DjX) {
            setTitleMuteIconVisibility(8);
            AppMethodBeat.o(28497);
            return;
        }
        setTitleMuteIconVisibility(0);
        AppMethodBeat.o(28497);
    }

    private void uy(boolean z) {
        AppMethodBeat.i(28498);
        uz(z);
        uA(z);
        AppMethodBeat.o(28498);
    }

    private void uz(boolean z) {
        AppMethodBeat.i(28499);
        if (this.Dkt == null) {
            this.Dkt = findViewById(R.id.dkq);
        }
        if (this.Dke.DgV == 3 || this.Dke.DgV == 4 || this.Dke.DgV == 5 || this.Dke.DgV == 6 || !z) {
            this.Dkt.setVisibility(8);
            AppMethodBeat.o(28499);
            return;
        }
        int ctM = com.tencent.mm.bj.d.bgP().ctM();
        if (ctM <= 0) {
            this.Dkt.setVisibility(8);
            AppMethodBeat.o(28499);
            return;
        }
        this.Dkt.setVisibility(0);
        ((TextView) this.Dkt.findViewById(R.id.h_k)).setText(getResources().getQuantityString(R.plurals.a3, ctM, Integer.valueOf(ctM)));
        this.Dkt.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(28456);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                ShakeReportUI shakeReportUI = ShakeReportUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                shakeReportUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28456);
            }
        });
        if (this.Dkx == null) {
            this.Dkx = (ImageView) findViewById(R.id.faz);
        }
        cl gEx = com.tencent.mm.bj.d.bgP().gEx();
        if (gEx != null) {
            this.Dky = gEx.field_sayhiuser;
            a.b.c(this.Dkx, this.Dky);
        }
        AppMethodBeat.o(28499);
    }

    private void uA(boolean z) {
        AppMethodBeat.i(28500);
        if (this.Dku == null) {
            this.Dku = findViewById(R.id.dkr);
        }
        if (!z) {
            this.Dku.setVisibility(8);
            AppMethodBeat.o(28500);
            return;
        }
        int ctM = m.eUn().ctM();
        if (ctM <= 0) {
            this.Dku.setVisibility(8);
            AppMethodBeat.o(28500);
            return;
        }
        if (this.Dkw == null) {
            this.Dkw = (TextView) this.Dku.findViewById(R.id.hnv);
        }
        this.Dkw.setText(getString(R.string.gz1, new Object[]{Integer.valueOf(ctM)}));
        this.Dku.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(28457);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
                intent.putExtra("shake_msg_from", 1);
                intent.putExtra("shake_msg_list_title", ShakeReportUI.this.getString(R.string.h0b));
                ShakeReportUI shakeReportUI = ShakeReportUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                shakeReportUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28457);
            }
        });
        if (this.Dkv == null) {
            this.Dkv = (MMImageView) findViewById(R.id.ho1);
        }
        com.tencent.mm.plugin.shake.b.f eUd = m.eUn().eUd();
        if (eUd != null) {
            String str = eUd.field_thumburl;
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.shake.e.b bVar = new com.tencent.mm.plugin.shake.e.b(str);
                Bitmap a2 = u.a(bVar);
                this.Dkv.setTag(bVar.blC());
                if (a2 == null || a2.isRecycled()) {
                    this.Dkv.setImageResource(R.raw.app_attach_file_icon_webpage);
                } else {
                    this.Dkv.setImageBitmap(a2);
                }
            } else {
                this.Dkv.setImageResource(R.raw.app_attach_file_icon_webpage);
            }
        }
        this.Dku.setVisibility(0);
        AppMethodBeat.o(28500);
    }

    private void uB(boolean z) {
        AppMethodBeat.i(28501);
        if (this.Dkj != null) {
            if (z) {
                this.Dkj.setVisibility(0);
                AppMethodBeat.o(28501);
                return;
            }
            this.Dkj.setVisibility(8);
            this.Dkj.cancelLongPress();
        }
        AppMethodBeat.o(28501);
    }

    private void uC(boolean z) {
        AppMethodBeat.i(28502);
        if (this.Dkh != null) {
            if (z) {
                this.Dkh.setVisibility(0);
                AppMethodBeat.o(28502);
                return;
            }
            this.Dkh.setVisibility(4);
        }
        AppMethodBeat.o(28502);
    }

    private void XD(int i2) {
        AppMethodBeat.i(28503);
        uC(i2 == 1);
        if (i2 == 2) {
            uB(true);
            AppMethodBeat.o(28503);
            return;
        }
        uB(false);
        AppMethodBeat.o(28503);
    }

    @Override // com.tencent.mm.model.bc
    public final void aVw() {
        AppMethodBeat.i(28504);
        eUY();
        AppMethodBeat.o(28504);
    }

    private void aNt(String str) {
        AppMethodBeat.i(28505);
        this.DjY = false;
        if (this.DjX) {
            PlaySound.play(getContext(), R.string.gz7);
        }
        if (this.Dks == null) {
            this.Dks = AnimationUtils.loadAnimation(getContext(), R.anim.bi);
        }
        XD(2);
        if (str == null || str.length() <= 1) {
            this.Dkj.setText(R.string.gy_);
        } else {
            this.Dkj.setText(str);
        }
        this.Dkj.startAnimation(this.Dks);
        this.Dkb = true;
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(28463);
                ShakeReportUI.K(ShakeReportUI.this);
                ShakeReportUI.d(ShakeReportUI.this, false);
                AppMethodBeat.o(28463);
            }
        }, this.Dks.getDuration());
        AppMethodBeat.o(28505);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.a
    public final void f(List<com.tencent.mm.plugin.shake.b.d> list, long j2) {
        String str;
        AppMethodBeat.i(28506);
        eVi();
        if (list == null || !this.DjY || j2 == 6) {
            this.DkC = null;
            if (j2 == 6) {
                aNt(getString(R.string.gyh));
                AppMethodBeat.o(28506);
            } else if (j2 == 7) {
                aNt(getString(R.string.gyf));
                AppMethodBeat.o(28506);
            } else if (j2 == 8) {
                aNt(getString(R.string.gyd));
                AppMethodBeat.o(28506);
            } else if (j2 == 9) {
                aNt(getString(R.string.gyc));
                AppMethodBeat.o(28506);
            } else if (j2 == 10) {
                aNt(getString(R.string.gyg));
                AppMethodBeat.o(28506);
            } else {
                aNt(null);
                AppMethodBeat.o(28506);
            }
        } else {
            this.DjY = false;
            if (list.size() > 0) {
                this.DkC = list.get(0);
            }
            if (this.Dke.DgV == 1) {
                if (list.size() <= 0 || list.get(0).field_type == 0) {
                    this.Dkc = list.get(0).scene;
                    int size = list.size();
                    if (size == 0) {
                        aNt(null);
                        AppMethodBeat.o(28506);
                    } else if (size == 1) {
                        Log.i("MicroMsg.ShakeReportUI", "1 u:" + list.get(0).field_username + " n:" + list.get(0).field_nickname + " d:" + list.get(0).field_distance);
                        if (this.DjX) {
                            PlaySound.play(getContext(), R.string.gyz);
                        }
                        XD(3);
                        com.tencent.mm.plugin.shake.b.d dVar = list.get(0);
                        if (!Util.isNullOrNil(dVar.field_username)) {
                            this.Dkg.setTag(dVar.field_username);
                            this.Dkg.setVisibility(0);
                            bg.aVF();
                            as Kn = com.tencent.mm.model.c.aSN().Kn(dVar.field_username);
                            StringBuilder append = new StringBuilder().append(dVar.field_nickname);
                            if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                str = getString(R.string.gz0);
                            } else {
                                str = "";
                            }
                            String sb = append.append(str).toString();
                            if (dVar.field_sex == 1) {
                                this.Dkg.setContentDescription(sb + dVar.field_distance + getContext().getString(R.string.gzs));
                            } else if (dVar.field_sex == 2) {
                                this.Dkg.setContentDescription(sb + dVar.field_distance + getContext().getString(R.string.gzr));
                            } else {
                                this.Dkg.setContentDescription(sb + dVar.field_distance);
                            }
                            TextView textView = (TextView) this.Dkg.findViewById(R.id.hns);
                            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), dVar.field_nickname + (com.tencent.mm.contact.c.oR(Kn.field_type) ? getString(R.string.gz0) : ""), textView.getTextSize()));
                            if (this.gyr != null) {
                                if (!Util.isNullOrNil(sb)) {
                                    this.gyr.setContentDescription(String.format(getString(R.string.gxs), sb));
                                } else {
                                    this.gyr.setContentDescription(getString(R.string.gxt));
                                }
                            }
                            ((TextView) this.Dkg.findViewById(R.id.hnq)).setText(dVar.field_distance);
                            a.b.c((ImageView) this.Dkg.findViewById(R.id.hnr), dVar.field_username);
                            ImageView imageView = (ImageView) this.Dkg.findViewById(R.id.hnu);
                            if (dVar.field_reserved1 != 0) {
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(dVar.field_reserved1), 2.0f));
                            } else {
                                imageView.setVisibility(8);
                            }
                            if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                                this.Dkg.findViewById(R.id.hnt).setVisibility(8);
                            } else {
                                Drawable l = com.tencent.mm.cb.a.l(this, dVar.field_sex == 1 ? R.raw.ic_sex_male : R.raw.ic_sex_female);
                                this.Dkg.findViewById(R.id.hnt).setVisibility(0);
                                ((ImageView) this.Dkg.findViewById(R.id.hnt)).setImageDrawable(l);
                            }
                            if (dVar.getProvince() == null) {
                                Log.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                                dVar.field_province = "";
                            }
                            if (dVar.getCity() == null) {
                                Log.e("MicroMsg.ShakeReportUI", "CITY NULL");
                                dVar.field_city = "";
                            }
                            this.Dkg.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ea));
                        }
                        AppMethodBeat.o(28506);
                    } else {
                        if (this.DjX) {
                            PlaySound.play(getContext(), R.string.gyz);
                        }
                        XD(3);
                        uz(false);
                        Intent intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -1);
                        intent.putExtra("_key_title_", getString(R.string.gyu));
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(28506);
                    }
                } else {
                    aNt(null);
                    AppMethodBeat.o(28506);
                }
            } else if (this.Dke.DgV == 3) {
                int size2 = list.size();
                if (size2 == 0) {
                    aNt(getString(R.string.gz6));
                    AppMethodBeat.o(28506);
                    return;
                }
                if (size2 == 1) {
                    if (this.DjX) {
                        PlaySound.play(getContext(), R.string.gyz);
                    }
                    XD(3);
                    if (list.get(0).field_type == 4) {
                        com.tencent.mm.ay.f e2 = com.tencent.mm.plugin.shake.d.a.i.e(list.get(0).field_lvbuffer, j2);
                        com.tencent.mm.ay.a.d(e2);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_mode", 1);
                        intent2.putExtra("key_offset", e2.jeW);
                        intent2.putExtra("music_player_beg_time", e2.jfo);
                        intent2.putExtra("key_scene", 3);
                        if (com.tencent.mm.ay.e.bel()) {
                            intent2.putExtra("KGlobalShakeMusic", true);
                        }
                        c.b(this, "music", ".ui.MusicMainUI", intent2);
                        AppMethodBeat.o(28506);
                        return;
                    }
                    Log.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
                }
                AppMethodBeat.o(28506);
            } else if (this.Dke.DgV == 4) {
                eVi();
                int size3 = list.size();
                if (size3 == 0) {
                    aNt(getString(R.string.h0c));
                    AppMethodBeat.o(28506);
                    return;
                }
                if (size3 == 1) {
                    if (this.DjX) {
                        PlaySound.play(getContext(), R.string.gyz);
                    }
                    XD(3);
                    new MMHandler().postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x045e: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0454: CONSTRUCTOR  (r1v26 com.tencent.mm.sdk.platformtools.MMHandler) =  call: com.tencent.mm.sdk.platformtools.MMHandler.<init>():void type: CONSTRUCTOR)
                          (wrap: com.tencent.mm.plugin.shake.d.a.k$1 : 0x0459: CONSTRUCTOR  (r2v15 com.tencent.mm.plugin.shake.d.a.k$1) = 
                          (wrap: com.tencent.mm.plugin.shake.b.d : 0x044c: INVOKE  (r0v63 com.tencent.mm.plugin.shake.b.d) = (r13v0 'list' java.util.List<com.tencent.mm.plugin.shake.b.d>), (0 int) type: INTERFACE call: java.util.List.get(int):java.lang.Object)
                          (r12v0 'this' com.tencent.mm.plugin.shake.ui.ShakeReportUI A[IMMUTABLE_TYPE, THIS])
                         call: com.tencent.mm.plugin.shake.d.a.k.1.<init>(com.tencent.mm.plugin.shake.b.d, android.content.Context):void type: CONSTRUCTOR)
                          (100 long)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postDelayed(java.lang.Runnable, long):boolean in method: com.tencent.mm.plugin.shake.ui.ShakeReportUI.f(java.util.List<com.tencent.mm.plugin.shake.b.d>, long):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0459: CONSTRUCTOR  (r2v15 com.tencent.mm.plugin.shake.d.a.k$1) = 
                          (wrap: com.tencent.mm.plugin.shake.b.d : 0x044c: INVOKE  (r0v63 com.tencent.mm.plugin.shake.b.d) = (r13v0 'list' java.util.List<com.tencent.mm.plugin.shake.b.d>), (0 int) type: INTERFACE call: java.util.List.get(int):java.lang.Object)
                          (r12v0 'this' com.tencent.mm.plugin.shake.ui.ShakeReportUI A[IMMUTABLE_TYPE, THIS])
                         call: com.tencent.mm.plugin.shake.d.a.k.1.<init>(com.tencent.mm.plugin.shake.b.d, android.content.Context):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.shake.ui.ShakeReportUI.f(java.util.List<com.tencent.mm.plugin.shake.b.d>, long):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 37 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.shake.d.a.k, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 43 more
                        */
                    /*
                    // Method dump skipped, instructions count: 1468
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.ui.ShakeReportUI.f(java.util.List, long):void");
                }

                @Override // com.tencent.mm.plugin.shake.b.l.a
                public final void a(int i2, final e eVar, long j2) {
                    l.b bVar;
                    AppMethodBeat.i(28507);
                    this.DkX = true;
                    if (i2 != 1251) {
                        if (i2 == 1250) {
                            if (eVar != null) {
                                if ((eVar != null && !this.DjY) || this.DjY) {
                                    this.DjY = false;
                                    Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                                    if (this.Dke.DgV == 6 && (bVar = this.Dke.DgW) != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                                        switch ((int) j2) {
                                            case 1:
                                                Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                                if (gVar.pTI == 3) {
                                                    Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                                    if (eVar == null || TextUtils.isEmpty(eVar.Dhy)) {
                                                        aNt(getString(R.string.gxz));
                                                        AppMethodBeat.o(28507);
                                                        return;
                                                    }
                                                    aNt(eVar.Dhy);
                                                    AppMethodBeat.o(28507);
                                                    return;
                                                }
                                                Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.pTI);
                                                XD(3);
                                                if (eVar.pTI == 1) {
                                                    this.Dka = false;
                                                }
                                                if (this.DkW != null && this.DkW.isShowing()) {
                                                    AppMethodBeat.o(28507);
                                                    return;
                                                } else if (eVar.DhA) {
                                                    ViewStub viewStub = (ViewStub) findViewById(R.id.j7v);
                                                    if (viewStub != null) {
                                                        viewStub.inflate();
                                                    }
                                                    ((ShakeEggAnimFrame) findViewById(R.id.arw)).aE(this);
                                                    new MMHandler().postDelayed(new Runnable() {
                                                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass15 */

                                                        public final void run() {
                                                            AppMethodBeat.i(28464);
                                                            ShakeReportUI.a(ShakeReportUI.this, eVar);
                                                            AppMethodBeat.o(28464);
                                                        }
                                                    }, 1000);
                                                    AppMethodBeat.o(28507);
                                                    return;
                                                } else {
                                                    a(eVar);
                                                    AppMethodBeat.o(28507);
                                                    return;
                                                }
                                            case 2:
                                                Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                                aNt(getString(R.string.gxz));
                                                break;
                                        }
                                    }
                                } else {
                                    this.DkC = null;
                                    aNt(null);
                                    AppMethodBeat.o(28507);
                                    return;
                                }
                            } else {
                                this.DkC = null;
                                aNt(null);
                                AppMethodBeat.o(28507);
                                return;
                            }
                        }
                        AppMethodBeat.o(28507);
                    } else if (eVar == null) {
                        AppMethodBeat.o(28507);
                    } else {
                        Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                        com.tencent.mm.plugin.shake.c.c.a.eUg();
                        eVf();
                        eVa();
                        eVd();
                        this.DkV = 4;
                        m.eUs().putValue("key_shake_card_item", eVar);
                        AppMethodBeat.o(28507);
                    }
                }

                private void a(e eVar) {
                    AppMethodBeat.i(28508);
                    this.DkW = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass16 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(28465);
                            dialogInterface.dismiss();
                            ShakeReportUI.this.Dka = true;
                            ShakeReportUI.this.DkW = null;
                            ShakeReportUI.this.Dkk.setText("");
                            AppMethodBeat.o(28465);
                        }
                    }, new a.b() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass17 */

                        @Override // com.tencent.mm.plugin.shake.c.b.a.b
                        public final void exp() {
                            AppMethodBeat.i(28466);
                            ShakeReportUI.this.Dka = true;
                            ShakeReportUI.this.Dkk.setText("");
                            AppMethodBeat.o(28466);
                        }
                    });
                    AppMethodBeat.o(28508);
                }

                private void eW(View view) {
                    boolean z;
                    AppMethodBeat.i(28509);
                    if (view == null) {
                        AppMethodBeat.o(28509);
                        return;
                    }
                    boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
                    Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
                    if (!a2) {
                        AppMethodBeat.o(28509);
                        return;
                    }
                    cb("", false);
                    if (view.getId() == R.id.hoc) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11722, 1);
                        if (this.DkK != 1) {
                            if (this.DkK == 4) {
                                ux(false);
                            }
                            this.DkK = 1;
                            eUY();
                            uz(false);
                            if (this.Dkg != null) {
                                this.Dkg.setVisibility(8);
                            }
                        }
                    } else if (view.getId() == R.id.hoi) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11722, 2);
                        if (!this.gmw && this.gmt != null) {
                            this.gmt.a(this.gmA, true);
                        }
                        if (!com.tencent.mm.q.a.cC(this) && !com.tencent.mm.q.a.cA(this) && !com.tencent.mm.q.a.cE(this) && this.DkK != 3) {
                            if (this.DkK == 4) {
                                ux(false);
                            }
                            this.DkK = 3;
                            eUY();
                            uz(false);
                            if (this.Dkg != null) {
                                this.Dkg.setVisibility(8);
                            }
                        }
                        eUV();
                    } else if (view.getId() == R.id.hol) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11722, 3);
                        if (!this.gmw && this.gmt != null) {
                            this.gmt.a(this.gmA, true);
                        }
                        if (!com.tencent.mm.q.a.cC(this) && !com.tencent.mm.q.a.cA(this) && !com.tencent.mm.q.a.cE(this) && this.DkK != 4) {
                            ux(true);
                            this.DkK = 4;
                            eUY();
                            uz(false);
                            if (this.Dkg != null) {
                                this.Dkg.setVisibility(8);
                            }
                        }
                    } else if (view.getId() == R.id.hog || view.getId() == R.id.hod) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11722, 4);
                        if (this.DkK != 5) {
                            this.DkK = 5;
                            eUY();
                            uz(false);
                            if (this.Dkg != null) {
                                this.Dkg.setVisibility(8);
                            }
                            if (!Build.VERSION.RELEASE.equals("6.0") && !Build.VERSION.RELEASE.equals("6.0.0") && Build.VERSION.SDK_INT >= 23) {
                                LocationManager locationManager = (LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
                                if (locationManager != null) {
                                    z = locationManager.isProviderEnabled("gps");
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    aNt(getString(R.string.gyd));
                                }
                            }
                            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                            if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                                aNt(getString(R.string.gyc));
                            } else if (defaultAdapter == null) {
                                aNt(getString(R.string.gyg));
                            }
                        }
                    } else if (view.getId() == R.id.ho9) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11722, 5);
                        if (this.DkK != 6) {
                            if (this.DkK == 4) {
                                ux(false);
                            }
                            this.DkK = 6;
                            eUY();
                            uz(false);
                            if (this.Dkg != null) {
                                this.Dkg.setVisibility(8);
                            }
                            com.tencent.mm.y.c.axV().B(262155, false);
                            this.DkI.setVisibility(8);
                        }
                    }
                    uy(true);
                    uC(false);
                    eVi();
                    AppMethodBeat.o(28509);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(28510);
                    super.onActivityResult(i2, i3, intent);
                    switch (i2) {
                        case 1:
                            if (intent == null) {
                                AppMethodBeat.o(28510);
                                return;
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("CropImageMode", 4);
                            intent2.putExtra("CropImage_Filter", true);
                            intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                            StringBuilder sb = new StringBuilder();
                            bg.aVF();
                            intent2.putExtra("CropImage_OutputPath", sb.append(com.tencent.mm.model.c.aSY()).append("custom_shake_img_filename.jpg").toString());
                            com.tencent.mm.plugin.shake.a.jRt.a(intent2, 2, this, intent);
                            AppMethodBeat.o(28510);
                            return;
                        case 2:
                            if (intent == null) {
                                AppMethodBeat.o(28510);
                                return;
                            }
                            String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(4110, Boolean.FALSE);
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(4111, stringExtra);
                            eUW();
                            AppMethodBeat.o(28510);
                            return;
                        case 30764:
                            if (intent != null) {
                                Bundle bundleExtra = intent.getBundleExtra("result_data");
                                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                                    this.kgv = true;
                                    finish();
                                    AppMethodBeat.o(28510);
                                    return;
                                }
                                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                                com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
                                this.kgv = false;
                                AppMethodBeat.o(28510);
                                return;
                            }
                            this.kgv = true;
                            finish();
                            AppMethodBeat.o(28510);
                            return;
                        default:
                            AppMethodBeat.o(28510);
                            return;
                    }
                }

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(28511);
                    eUZ();
                    if (!this.DjZ) {
                        uy(true);
                    }
                    AppMethodBeat.o(28511);
                }

                @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
                public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
                    AppMethodBeat.i(28512);
                    onNotifyChange("", null);
                    AppMethodBeat.o(28512);
                }

                @Override // com.tencent.mm.platformtools.u.a
                public final void k(String str, Bitmap bitmap) {
                    AppMethodBeat.i(28515);
                    if (str == null || bitmap == null || bitmap.isRecycled()) {
                        AppMethodBeat.o(28515);
                        return;
                    }
                    if (!(this.Dkv == null || this.Dkv.getTag() == null || !str.equals((String) this.Dkv.getTag()))) {
                        this.Dkv.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(28515);
                }

                @Override // com.tencent.mm.plugin.shake.c.a.f.a
                public final void eUv() {
                    AppMethodBeat.i(28516);
                    com.tencent.mm.plugin.shake.c.c.a.eUg();
                    eVa();
                    eVb();
                    eVe();
                    eVf();
                    eVd();
                    AppMethodBeat.o(28516);
                }

                private void eVa() {
                    AppMethodBeat.i(28517);
                    if (com.tencent.mm.plugin.shake.c.c.a.eUL()) {
                        if (com.tencent.mm.y.c.axV().cP(262155, 266259)) {
                            this.DkI.setVisibility(0);
                            AppMethodBeat.o(28517);
                            return;
                        }
                        this.DkI.setVisibility(8);
                    }
                    AppMethodBeat.o(28517);
                }

                private void eVb() {
                    AppMethodBeat.i(28518);
                    if (this.DkK == 6 && com.tencent.mm.plugin.shake.c.c.a.eUL()) {
                        boolean cP = com.tencent.mm.y.c.axV().cP(262154, 266258);
                        boolean cP2 = com.tencent.mm.y.c.axV().cP(262155, 266259);
                        if (cP) {
                            cb(com.tencent.mm.plugin.shake.c.c.a.eUG(), true);
                            AppMethodBeat.o(28518);
                            return;
                        } else if (cP2) {
                            cb(com.tencent.mm.plugin.shake.c.c.a.eUI(), true);
                            AppMethodBeat.o(28518);
                            return;
                        } else if (!this.DkX) {
                            if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.eUE())) {
                                cb(com.tencent.mm.plugin.shake.c.c.a.eUE(), true);
                                AppMethodBeat.o(28518);
                                return;
                            }
                            cb(getString(R.string.gy0), true);
                        }
                    }
                    AppMethodBeat.o(28518);
                }

                private void cb(String str, boolean z) {
                    AppMethodBeat.i(28519);
                    this.DjY = false;
                    if (this.Dks == null) {
                        this.Dks = AnimationUtils.loadAnimation(getContext(), R.anim.bi);
                    }
                    XD(2);
                    uB(true);
                    if (str != null && str.length() > 1) {
                        this.Dkj.setText(str);
                    } else if (z) {
                        this.Dkj.setText(R.string.gy0);
                    } else {
                        this.Dkj.setText("");
                        uB(false);
                    }
                    this.Dkb = true;
                    AppMethodBeat.o(28519);
                }

                private void eVc() {
                    AppMethodBeat.i(28520);
                    if (this.DkW != null && this.DkW.isShowing()) {
                        this.DkW.dismiss();
                    }
                    this.DkW = null;
                    AppMethodBeat.o(28520);
                }

                private void eVd() {
                    int i2;
                    int i3;
                    int i4;
                    int i5 = 1;
                    AppMethodBeat.i(28521);
                    boolean eUh = com.tencent.mm.plugin.shake.c.c.a.eUh();
                    boolean cP = com.tencent.mm.y.c.axV().cP(262154, 266258);
                    boolean cP2 = com.tencent.mm.y.c.axV().cP(262155, 266259);
                    if (getIntent().getBooleanExtra("shake_card", false)) {
                        i2 = getIntent().getIntExtra("shake_card", 0);
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr = new Object[6];
                    objArr[0] = 1;
                    objArr[1] = Integer.valueOf(i2);
                    if (cP) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    objArr[2] = Integer.valueOf(i3);
                    objArr[3] = Integer.valueOf(eUh ? 1 : 0);
                    objArr[4] = com.tencent.mm.plugin.shake.c.c.a.eUH();
                    objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.eUD());
                    hVar.a(11668, objArr);
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr2 = new Object[6];
                    objArr2[0] = 2;
                    objArr2[1] = Integer.valueOf(i2);
                    if (cP2) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    objArr2[2] = Integer.valueOf(i4);
                    if (!eUh) {
                        i5 = 0;
                    }
                    objArr2[3] = Integer.valueOf(i5);
                    objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.eUH();
                    objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.eUD());
                    hVar2.a(11668, objArr2);
                    AppMethodBeat.o(28521);
                }

                private void eVe() {
                    AppMethodBeat.i(28522);
                    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.eUF())) {
                        this.DkJ.setText(com.tencent.mm.plugin.shake.c.c.a.eUF());
                    }
                    AppMethodBeat.o(28522);
                }

                private void eVf() {
                    int i2;
                    AppMethodBeat.i(28523);
                    if (com.tencent.mm.ay.e.bek()) {
                        Log.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
                        this.DkY.put(3, Boolean.TRUE);
                        findViewById(R.id.hoi).setVisibility(0);
                        if (com.tencent.mm.ay.e.bel()) {
                            bg.aVF();
                            if (com.tencent.mm.model.c.azQ().getInt(4118, 0) == 0) {
                                this.DkH.setVisibility(0);
                            } else {
                                this.DkH.setVisibility(8);
                            }
                        }
                    } else {
                        this.DkY.put(3, Boolean.FALSE);
                        findViewById(R.id.hoi).setVisibility(8);
                        Log.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
                    }
                    if (k.eUk()) {
                        this.DkY.put(4, Boolean.TRUE);
                        findViewById(R.id.hol).setVisibility(0);
                        Log.i("MicroMsg.ShakeReportUI", "show shake tv tab");
                    } else {
                        this.DkY.put(4, Boolean.FALSE);
                        findViewById(R.id.hol).setVisibility(8);
                        Log.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
                    }
                    if (com.tencent.mm.plugin.shake.c.c.a.eUL()) {
                        this.DkY.put(6, Boolean.TRUE);
                        findViewById(R.id.ho9).setVisibility(0);
                        Log.i("MicroMsg.ShakeReportUI", "show shake card tab");
                    } else {
                        findViewById(R.id.ho9).setVisibility(8);
                        this.DkY.put(6, Boolean.FALSE);
                        Log.i("MicroMsg.ShakeReportUI", "hide shake card tab");
                    }
                    int i3 = 0;
                    for (Boolean bool : this.DkY.values()) {
                        if (bool.booleanValue()) {
                            i2 = i3 + 1;
                        } else {
                            i2 = i3;
                        }
                        i3 = i2;
                    }
                    this.DkL = i3;
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ho4);
                    if (i3 == 1) {
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                    }
                    if (i3 <= 4 || !this.Dlf) {
                        if (i3 > 4 && !this.Dlf) {
                            this.DkZ = false;
                            this.DkL--;
                            Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
                        }
                        AppMethodBeat.o(28523);
                        return;
                    }
                    findViewById(R.id.hol).setVisibility(8);
                    Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
                    this.DkL--;
                    AppMethodBeat.o(28523);
                }

                private boolean eVg() {
                    AppMethodBeat.i(28524);
                    Log.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + LocaleUtil.isChineseAppLang() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + LocaleUtil.getApplicationLanguage());
                    if (!this.DkZ || !eVh()) {
                        AppMethodBeat.o(28524);
                        return false;
                    }
                    AppMethodBeat.o(28524);
                    return true;
                }

                private static boolean eVh() {
                    AppMethodBeat.i(28525);
                    if (LocaleUtil.isChineseAppLang() || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.JAPANESE)) {
                        AppMethodBeat.o(28525);
                        return true;
                    }
                    AppMethodBeat.o(28525);
                    return false;
                }

                private void eVi() {
                    AppMethodBeat.i(28526);
                    this.DkM.setVisibility(8);
                    AppMethodBeat.o(28526);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
                public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(28527);
                    if (iArr == null || iArr.length <= 0) {
                        Log.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
                        AppMethodBeat.o(28527);
                        return;
                    }
                    Log.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
                    switch (i2) {
                        case 64:
                            if (iArr[0] != 0) {
                                this.kgv = false;
                                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass21 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(28470);
                                        ShakeReportUI shakeReportUI = ShakeReportUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        shakeReportUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        ShakeReportUI.this.kgv = true;
                                        ShakeReportUI.this.finish();
                                        AppMethodBeat.o(28470);
                                    }
                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass23 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(28472);
                                        ShakeReportUI.this.kgv = true;
                                        ShakeReportUI.this.finish();
                                        AppMethodBeat.o(28472);
                                    }
                                });
                                break;
                            } else {
                                eHs();
                                AppMethodBeat.o(28527);
                                return;
                            }
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                            if (iArr[0] != 0) {
                                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass19 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(28468);
                                        dialogInterface.dismiss();
                                        ShakeReportUI shakeReportUI = ShakeReportUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        shakeReportUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(shakeReportUI, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(28468);
                                    }
                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass20 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(28469);
                                        dialogInterface.dismiss();
                                        AppMethodBeat.o(28469);
                                    }
                                });
                                AppMethodBeat.o(28527);
                                return;
                            }
                            break;
                    }
                    AppMethodBeat.o(28527);
                }

                static /* synthetic */ void j(ShakeReportUI shakeReportUI) {
                    ViewGroup viewGroup;
                    AppMethodBeat.i(28528);
                    if (eVh() && (viewGroup = (ViewGroup) shakeReportUI.findViewById(R.id.ho4)) != null) {
                        int childCount = viewGroup.getChildCount();
                        ArrayList arrayList = new ArrayList();
                        int i2 = 0;
                        for (int i3 = 0; i3 < childCount; i3++) {
                            if (viewGroup.getChildAt(i3).getVisibility() == 0) {
                                i2++;
                                arrayList.add(viewGroup.getChildAt(i3));
                            }
                        }
                        if (!shakeReportUI.DkZ && (shakeReportUI.Dla || shakeReportUI.Dlc)) {
                            int width = viewGroup.getWidth() / (i2 + 1);
                            int width2 = viewGroup.getWidth() / i2;
                            AnimationSet animationSet = new AnimationSet(false);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(600);
                            TranslateAnimation translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - width), 0.0f, 0.0f);
                            animationSet.addAnimation(alphaAnimation);
                            translateAnimation.setDuration(600);
                            animationSet.addAnimation(translateAnimation);
                            shakeReportUI.findViewById(R.id.hog).setAnimation(animationSet);
                            if (i2 < 4) {
                                for (int i4 = 0; i4 < i2; i4++) {
                                    TranslateAnimation translateAnimation2 = new TranslateAnimation((float) (((i4 * width2) + (width2 / 2)) - ((i4 * width) + (width / 2))), 0.0f, 0.0f, 0.0f);
                                    translateAnimation2.setDuration(600);
                                    ((View) arrayList.get(i4)).setAnimation(translateAnimation2);
                                }
                            }
                        } else if (!shakeReportUI.DkZ && !shakeReportUI.Dla && !shakeReportUI.Dlc) {
                            int width3 = viewGroup.getWidth() / (i2 + 1);
                            int width4 = viewGroup.getWidth() / i2;
                            AnimationSet animationSet2 = new AnimationSet(false);
                            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation2.setDuration(1200);
                            TranslateAnimation translateAnimation3 = new TranslateAnimation((float) ((-width3) / 2), 0.0f, 0.0f, 0.0f);
                            animationSet2.addAnimation(alphaAnimation2);
                            translateAnimation3.setDuration(600);
                            animationSet2.addAnimation(translateAnimation3);
                            shakeReportUI.findViewById(R.id.hod).setAnimation(animationSet2);
                            for (int i5 = 1; i5 < i2 + 1; i5++) {
                                TranslateAnimation translateAnimation4 = new TranslateAnimation((float) (-(((i5 * width3) + (width3 / 2)) - (((i5 - 1) * width4) + (width4 / 2)))), 0.0f, 0.0f, 0.0f);
                                translateAnimation4.setDuration(600);
                                ((View) arrayList.get(i5 - 1)).setAnimation(translateAnimation4);
                            }
                        }
                        shakeReportUI.DkZ = true;
                        shakeReportUI.DkK = 5;
                        shakeReportUI.Dlf = true;
                        shakeReportUI.eVf();
                        shakeReportUI.eUY();
                        shakeReportUI.uz(false);
                    }
                    AppMethodBeat.o(28528);
                }

                static /* synthetic */ void k(ShakeReportUI shakeReportUI) {
                    List<String> aqA;
                    AppMethodBeat.i(28529);
                    bg.aVF();
                    if (!Util.nullAs((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, (Object) null), false)) {
                        shakeReportUI.gmx.clear();
                        gmy = new CopyOnWriteArrayList();
                    }
                    if (Build.VERSION.SDK_INT >= 18 && (aqA = com.tencent.mm.n.h.aqK().aqA()) != null) {
                        for (String str : aqA) {
                            eh ehVar = new eh();
                            Log.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", str);
                            ehVar.dHC.dHE = str;
                            ehVar.dHC.dHB = false;
                            EventCenter.instance.publish(ehVar);
                        }
                    }
                    AppMethodBeat.o(28529);
                }

                static /* synthetic */ void l(ShakeReportUI shakeReportUI) {
                    List<String> aqA;
                    AppMethodBeat.i(28530);
                    if (!(!eVh() || BluetoothAdapter.getDefaultAdapter() == null || (aqA = com.tencent.mm.n.h.aqK().aqA()) == null)) {
                        shakeReportUI.Dle = System.currentTimeMillis();
                        for (String str : aqA) {
                            Log.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", str);
                            eh ehVar = new eh();
                            ehVar.dHC.dHE = str;
                            ehVar.dHC.dHB = true;
                            EventCenter.instance.publish(ehVar);
                        }
                    }
                    AppMethodBeat.o(28530);
                }

                static /* synthetic */ void A(ShakeReportUI shakeReportUI) {
                    AppMethodBeat.i(28534);
                    if (shakeReportUI.Dkl == null) {
                        shakeReportUI.Dkl = shakeReportUI.findViewById(R.id.hp1);
                    }
                    if (shakeReportUI.Dkm == null) {
                        shakeReportUI.Dkm = shakeReportUI.findViewById(R.id.hnd);
                    }
                    if (shakeReportUI.Dkn == null) {
                        shakeReportUI.Dkn = shakeReportUI.findViewById(R.id.hnl);
                    }
                    if (shakeReportUI.Dko == null) {
                        shakeReportUI.Dko = shakeReportUI.findViewById(R.id.hnm);
                    }
                    if (shakeReportUI.Dkp == null) {
                        shakeReportUI.Dkp = AnimationUtils.loadAnimation(shakeReportUI.getContext(), R.anim.fd);
                        shakeReportUI.Dkp.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass10 */

                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(28458);
                                ShakeReportUI.this.DjV = false;
                                ShakeReportUI.this.DjW = true;
                                ShakeReportUI.f(ShakeReportUI.this, false);
                                ShakeReportUI.this.DjZ = true;
                                ShakeReportUI.B(ShakeReportUI.this);
                                AppMethodBeat.o(28458);
                            }

                            public final void onAnimationEnd(Animation animation) {
                                l.b bVar;
                                AppMethodBeat.i(28459);
                                ShakeReportUI.f(ShakeReportUI.this, true);
                                ShakeReportUI.this.DjZ = false;
                                if (!ShakeReportUI.this.DjV) {
                                    ShakeReportUI.this.DjY = true;
                                    ShakeReportUI.d(ShakeReportUI.this, true);
                                    ShakeReportUI.D(ShakeReportUI.this);
                                    if (ShakeReportUI.this.Dke.DgV == 3) {
                                        com.tencent.mm.ay.a.bea();
                                    } else if (ShakeReportUI.this.Dke.DgV == 5 && (bVar = ShakeReportUI.this.Dke.DgW) != null && (bVar instanceof com.tencent.mm.plugin.shake.d.a.h)) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.addAll(ShakeReportUI.gmy);
                                        ((com.tencent.mm.plugin.shake.d.a.h) bVar).DiO = arrayList;
                                    }
                                    ShakeReportUI.this.Dke.DgW.start();
                                }
                                ShakeReportUI.this.DjW = false;
                                AppMethodBeat.o(28459);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                    }
                    if (shakeReportUI.Dkq == null) {
                        shakeReportUI.Dkq = AnimationUtils.loadAnimation(shakeReportUI.getContext(), R.anim.fb);
                    }
                    if (shakeReportUI.Dkr == null) {
                        shakeReportUI.Dkr = AnimationUtils.loadAnimation(shakeReportUI.getContext(), R.anim.e8);
                    }
                    if (!(shakeReportUI.Dks == null || shakeReportUI.Dkj == null)) {
                        BackwardSupportUtil.AnimationHelper.cancelAnimation(shakeReportUI.Dkj, shakeReportUI.Dks);
                    }
                    shakeReportUI.XD(3);
                    shakeReportUI.Dkn.startAnimation(shakeReportUI.Dkr);
                    shakeReportUI.Dko.startAnimation(shakeReportUI.Dkr);
                    shakeReportUI.Dkn.setVisibility(0);
                    shakeReportUI.Dko.setVisibility(0);
                    shakeReportUI.Dki.setVisibility(4);
                    shakeReportUI.Dkl.startAnimation(shakeReportUI.Dkp);
                    shakeReportUI.Dkm.startAnimation(shakeReportUI.Dkq);
                    if (shakeReportUI.Dkg != null && shakeReportUI.Dkg.getVisibility() == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.getContext(), R.anim.eb);
                        loadAnimation.setFillAfter(true);
                        shakeReportUI.Dkg.startAnimation(loadAnimation);
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass11 */

                            public final void run() {
                                AppMethodBeat.i(28460);
                                if (ShakeReportUI.this.Dkg != null) {
                                    ShakeReportUI.this.Dkg.setVisibility(8);
                                }
                                AppMethodBeat.o(28460);
                            }
                        }, loadAnimation.getDuration());
                    }
                    shakeReportUI.Dkb = false;
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.shake.ui.ShakeReportUI.AnonymousClass13 */

                        public final void run() {
                            AppMethodBeat.i(28462);
                            if (ShakeReportUI.this.Dkn != null) {
                                ShakeReportUI.this.Dkn.setVisibility(8);
                            }
                            if (ShakeReportUI.this.Dko != null) {
                                ShakeReportUI.this.Dko.setVisibility(8);
                            }
                            if (ShakeReportUI.this.Dki != null) {
                                ShakeReportUI.this.Dki.setVisibility(0);
                            }
                            if (!ShakeReportUI.this.Dkb && !ShakeReportUI.this.DjV) {
                                ShakeReportUI.J(ShakeReportUI.this);
                            }
                            AppMethodBeat.o(28462);
                        }
                    }, 1200);
                    AppMethodBeat.o(28534);
                }
            }
