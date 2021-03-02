package com.tencent.mm.plugin.profile.ui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.c;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.profile.ui.tab.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c implements i {
    private static long Bjx = 0;
    private String Bdj;
    private com.tencent.mm.api.c Bdk;
    private boolean Bdx;
    private int Bfb = 0;
    private SnsAdClick Bfh = null;
    private String Bfi;
    private ph BiU;
    private boolean BiX = false;
    private boolean Bjy = false;
    private Button BlT;
    private Button BlU;
    private ImageButton BlV;
    private MMNeat7extView BlW;
    private View BlX;
    private View BlY;
    private TextView BlZ;
    private b Bma;
    private a Bmb;
    private int Bmc = 0;
    private as contact;
    private String dhE;
    private c.b dhv;
    private long enterTime;
    private MMActivity gte;
    private ImageView gyr;
    private ImageView hXw;
    private int kgm;
    private View lJI;
    private String pHz = "";
    private MMNeat7extView pIP;
    private LabelsView ptA;
    private q tipDialog;
    private TextView titleTv;
    private View vun;
    private String wZz;
    private AppBarLayout xkh;

    public interface a {
        void eFF();
    }

    public interface b {
    }

    static /* synthetic */ LinkedList a(c cVar, ph phVar) {
        AppMethodBeat.i(232003);
        LinkedList<qf> c2 = cVar.c(phVar);
        AppMethodBeat.o(232003);
        return c2;
    }

    static /* synthetic */ void u(c cVar) {
        AppMethodBeat.i(232006);
        cVar.eEr();
        AppMethodBeat.o(232006);
    }

    public c(MMActivity mMActivity, View view) {
        AppMethodBeat.i(231985);
        this.lJI = view;
        this.gte = mMActivity;
        this.gyr = (ImageView) this.lJI.findViewById(R.id.a_c);
        this.titleTv = (TextView) this.lJI.findViewById(R.id.a_g);
        this.pIP = (MMNeat7extView) this.lJI.findViewById(R.id.a_d);
        this.hXw = (ImageView) this.lJI.findViewById(R.id.e49);
        this.BlT = (Button) this.lJI.findViewById(R.id.a5i);
        this.BlU = (Button) this.lJI.findViewById(R.id.a5h);
        this.BlV = (ImageButton) this.lJI.findViewById(R.id.a5j);
        this.BlW = (MMNeat7extView) this.lJI.findViewById(R.id.a5m);
        this.ptA = (LabelsView) this.lJI.findViewById(R.id.a5o);
        this.vun = this.lJI.findViewById(R.id.a5l);
        this.BlX = this.lJI.findViewById(R.id.a5n);
        this.xkh = (AppBarLayout) this.lJI.findViewById(R.id.a5s);
        this.BlY = this.lJI.findViewById(R.id.a5q);
        this.BlZ = (TextView) this.lJI.findViewById(R.id.a5p);
        o.hq(this.BlY);
        this.xkh.a(new AppBarLayout.b() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass1 */

            @Override // android.support.design.widget.AppBarLayout.a, android.support.design.widget.AppBarLayout.b
            public final void c(AppBarLayout appBarLayout, int i2) {
                AppMethodBeat.i(231967);
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int abs = Math.abs(i2);
                if (abs >= c.this.titleTv.getBottom()) {
                    c.this.gte.setMMTitleColor(c.this.gte.getResources().getColor(R.color.FG_0));
                } else {
                    c.this.gte.setMMTitleColor(0);
                }
                if (c.this.Bmc >= totalScrollRange && abs < c.this.Bmc && c.this.Bmb != null) {
                    c.this.Bmb.eFF();
                }
                c.this.Bmc = abs;
                Log.v("MicroMsg.ContactWidgetTabBizHeaderController", "callback i:%d, Y:%f", Integer.valueOf(i2), Float.valueOf(c.this.titleTv.getY()));
                AppMethodBeat.o(231967);
            }
        });
        this.BlU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(231976);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.BiX) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(c.this.gte);
                    if (!(c.this.contact == null || c.this.contact.field_username == null)) {
                        ((com.tencent.mm.api.q) g.af(com.tencent.mm.api.q.class)).d(7, c.this.contact.field_username, c.this.contact.field_nickname);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(231976);
                    return;
                }
                c.g(c.this);
                if (c.this.Bfb != 0) {
                    h.INSTANCE.a(11263, Integer.valueOf(c.this.Bfb), c.this.contact.field_username);
                }
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.this.contact.field_username, 200, c.this.kgm, c.this.enterTime);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231976);
            }
        });
        this.BlT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(231977);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.Bfh != null) {
                    rr rrVar = new rr();
                    c.this.Bfh.jkU = 5;
                    rrVar.dYk.dYl = c.this.Bfh;
                    EventCenter.instance.publish(rrVar);
                }
                c.l(c.this);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.this.contact.field_username, 300, c.this.kgm, c.this.enterTime);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231977);
            }
        });
        this.BlV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(231979);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((m) g.af(m.class)).a(c.this.Bdk, c.this.gte, c.this.contact, true, new Runnable() {
                    /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(231978);
                        if (c.this.gte.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                            Intent intent = new Intent();
                            intent.addFlags(67108864);
                            com.tencent.mm.br.c.b(c.this.gte, "shake", ".ui.ShakeReportUI", intent);
                        }
                        AppMethodBeat.o(231978);
                    }
                });
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.this.contact.field_username, 1000, c.this.kgm, c.this.enterTime);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231979);
            }
        });
        o.hq(this.BlX);
        this.BlX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(231980);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.ptA.setMaxLines(0);
                c.this.BlX.setVisibility(8);
                com.tencent.mm.plugin.profile.ui.tab.data.b bVar2 = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
                com.tencent.mm.plugin.profile.ui.tab.data.b.ac(c.this.contact);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231980);
            }
        });
        this.ptA.setOnLabelClickListener(new LabelsView.b() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass14 */

            @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.b
            public final void j(Object obj, int i2) {
                AppMethodBeat.i(231981);
                qf qfVar = (qf) obj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", qfVar.KXf);
                intent.putExtra("geta8key_scene", 3);
                com.tencent.mm.br.c.b(c.this.gte, "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.plugin.profile.ui.tab.data.b bVar = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
                com.tencent.mm.plugin.profile.ui.tab.data.b.a(c.this.contact, qfVar);
                AppMethodBeat.o(231981);
            }
        });
        this.Bfh = (SnsAdClick) this.gte.getIntent().getParcelableExtra("KSnsAdTag");
        this.Bfi = this.gte.getIntent().getStringExtra("key_add_contact_report_info");
        this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.enterTime = System.currentTimeMillis();
        AppMethodBeat.o(231985);
    }

    public final void a(a aVar) {
        this.Bmb = aVar;
    }

    public final void a(as asVar, String str, com.tencent.mm.api.c cVar, ph phVar, int i2, boolean z) {
        AppMethodBeat.i(231986);
        this.Bdj = str;
        this.Bdk = cVar;
        this.contact = asVar;
        this.BiU = phVar;
        this.kgm = i2;
        this.Bdx = z;
        if (cVar != null) {
            this.dhv = cVar.cG(false);
        }
        if (!(this.dhv == null || this.dhv.US() == null || this.dhv.US().length() <= 0)) {
            this.dhE = this.dhv.US();
        }
        updateView();
        AppMethodBeat.o(231986);
    }

    public final void a(ph phVar, com.tencent.mm.api.c cVar, String str) {
        AppMethodBeat.i(231987);
        this.BiU = phVar;
        this.Bdk = cVar;
        this.wZz = str;
        if (phVar != null) {
            if ((phVar.KTf & 2) != 0) {
                this.Bjy = true;
            }
            if (eFb()) {
                this.vun.setVisibility(8);
            } else {
                this.vun.setVisibility(0);
            }
        }
        updateView();
        AppMethodBeat.o(231987);
    }

    private void updateView() {
        AppMethodBeat.i(231988);
        if (this.contact == null) {
            Log.w("MicroMsg.ContactWidgetTabBizHeaderController", "initView contact is null, return");
            AppMethodBeat.o(231988);
            return;
        }
        if (this.Bdk == null) {
            this.Bdk = com.tencent.mm.al.g.fJ(this.contact.field_username);
        }
        if (this.Bdk != null) {
            this.Bdj = this.Bdk.field_brandIconURL;
        }
        eFz();
        eFA();
        eFB();
        eFC();
        eFD();
        eFE();
        this.lJI.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass15 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(231982);
                c.this.lJI.getViewTreeObserver().removeOnPreDrawListener(this);
                LinkedList a2 = c.a(c.this, c.this.BiU);
                if (c.this.ptA.getLineCount() <= 1 || a2 == null || a2.isEmpty()) {
                    c.this.BlX.setVisibility(8);
                } else {
                    c.this.BlX.setVisibility(0);
                }
                if (c.this.titleTv.getLineCount() >= 3) {
                    c.this.titleTv.setTextSize(0, (float) com.tencent.mm.cb.a.aH(c.this.gte, R.dimen.k8));
                }
                AppMethodBeat.o(231982);
                return true;
            }
        });
        LinkedList<qf> c2 = c(this.BiU);
        if (c2 == null || c2.isEmpty()) {
            this.ptA.setVisibility(8);
            this.BlX.setVisibility(8);
            AppMethodBeat.o(231988);
            return;
        }
        this.ptA.setVisibility(0);
        if (this.ptA.getLineCount() > 1) {
            this.BlX.setVisibility(0);
        } else {
            this.BlX.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList(c2);
        final int jn = (com.tencent.mm.cb.a.jn(this.gte) - ((int) (com.tencent.mm.cb.a.getDensity(this.gte) * 40.0f))) / 2;
        this.ptA.a(arrayList, new LabelsView.a<qf>() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass16 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
            @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
            public final /* synthetic */ CharSequence a(TextView textView, int i2, qf qfVar) {
                AppMethodBeat.i(231983);
                o.hq(textView);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setMaxWidth(jn);
                String str = qfVar.KXd;
                AppMethodBeat.o(231983);
                return str;
            }
        });
        AppMethodBeat.o(231988);
    }

    private LinkedList<qf> c(ph phVar) {
        LinkedList<qf> linkedList = null;
        synchronized (this) {
            if (phVar != null) {
                qg qgVar = phVar.KWo;
                if (qgVar != null) {
                    linkedList = qgVar.KXh;
                }
            }
        }
        return linkedList;
    }

    private void eFz() {
        AppMethodBeat.i(231989);
        boolean z = ab.clc() && com.tencent.mm.contact.c.oR(this.contact.field_type) && this.contact.arE() && com.tencent.mm.al.g.Nd(this.contact.field_username);
        boolean gBN = this.contact.gBN();
        String nullAsNil = z ? Util.nullAsNil(this.contact.field_nickname) + "*" : Util.nullAsNil(this.contact.field_nickname);
        if (gBN) {
            nullAsNil = nullAsNil + "*";
        }
        SpannableString b2 = l.b(this.gte, nullAsNil, this.titleTv.getTextSize());
        int length = b2.length() - 1;
        if (gBN) {
            if (z) {
                length--;
            }
            Drawable drawable = this.gte.getResources().getDrawable(R.drawable.c_q);
            int i2 = (int) ((this.gte.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 18);
            drawable.setBounds(i2, 0, fromDPToPix + i2, fromDPToPix);
            b2.setSpan(new com.tencent.mm.ui.widget.a(drawable, 1), length, length + 1, 17);
        }
        if (z) {
            Drawable drawable2 = this.gte.getResources().getDrawable(R.drawable.c0a);
            int i3 = (int) ((this.gte.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
            int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 18);
            drawable2.setBounds(i3, 0, fromDPToPix2 + i3, fromDPToPix2);
            b2.setSpan(new com.tencent.mm.ui.widget.a(drawable2, 1), b2.length() - 1, b2.length(), 17);
        }
        this.titleTv.setText(b2);
        AppMethodBeat.o(231989);
    }

    private void eFA() {
        boolean z = true;
        AppMethodBeat.i(231990);
        this.gyr.setVisibility(0);
        boolean z2 = System.currentTimeMillis() - Bjx < 2000;
        ImageView imageView = this.gyr;
        as asVar = this.contact;
        String str = this.Bjy ? "" : this.Bdj;
        if (this.Bjy || !z2) {
            z = false;
        }
        d.a(imageView, asVar, str, z);
        if (this.Bjy) {
            this.gyr.setClickable(false);
            AppMethodBeat.o(231990);
            return;
        }
        this.gyr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(231984);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = c.this.contact.field_username;
                Intent intent = new Intent(c.this.gte, ProfileHdHeadImg.class);
                intent.putExtra(ch.COL_USERNAME, str);
                intent.putExtra("brand_icon_url", c.this.Bdj);
                MMActivity mMActivity = c.this.gte;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231984);
            }
        });
        AppMethodBeat.o(231990);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void eFB() {
        AppMethodBeat.i(231991);
        String str = this.contact.signature;
        b.a aVar = b.BlS;
        if (b.a.aKA(str)) {
            str = this.gte.getString(R.string.b_f);
        }
        this.pIP.aw(l.c(this.gte, str));
        this.pIP.setVisibility(0);
        if (this.Bdk == null || this.Bdk.cG(false) == null || this.Bdk.cG(false).Vb() == null || Util.isNullOrNil(this.Bdk.cG(false).Vb().diD)) {
            Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
            this.hXw.setVisibility(8);
        } else {
            this.hXw.setVisibility(0);
        }
        this.pIP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(this.pIP, new com.tencent.mm.pluginsdk.ui.span.o()) {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass2 */

            @Override // com.tencent.neattextview.textview.view.b, com.tencent.mm.pluginsdk.ui.span.h
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // com.tencent.neattextview.textview.view.b, com.tencent.mm.pluginsdk.ui.span.h
            @SuppressLint({"ResourceType"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(231968);
                c.a(c.this, motionEvent);
                boolean onTouch = super.onTouch(view, motionEvent);
                AppMethodBeat.o(231968);
                return onTouch;
            }
        });
        this.hXw.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass3 */

            @SuppressLint({"ResourceType"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(231969);
                c.a(c.this, motionEvent);
                AppMethodBeat.o(231969);
                return false;
            }
        });
        this.pIP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(231970);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.t(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231970);
            }
        });
        this.hXw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(231971);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.t(c.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231971);
            }
        });
        AppMethodBeat.o(231991);
    }

    private void eFC() {
        boolean z = true;
        AppMethodBeat.i(231992);
        if (this.contact == null) {
            this.BlU.setVisibility(8);
            this.BlV.setVisibility(8);
            this.BlT.setVisibility(8);
            AppMethodBeat.o(231992);
            return;
        }
        boolean z2 = this.gte.getIntent() != null && this.gte.getIntent().getBooleanExtra("KIsHardDevice", false);
        if (z2) {
            Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "Hard device biz...");
            boolean eEs = eEs();
            Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "contact.isContact()(%b), isHarDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(eEs));
            if (!com.tencent.mm.contact.c.oR(this.contact.field_type) || !eEs) {
                if (eEs) {
                    this.BlU.setText(R.string.b9y);
                } else {
                    this.BlU.setText(R.string.b_5);
                }
            }
        }
        if (!z2 || eEs()) {
            z = false;
        }
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type) || z) {
            this.BlV.setVisibility(8);
            this.BlT.setVisibility(8);
            this.BlU.setVisibility(0);
            AppMethodBeat.o(231992);
            return;
        }
        this.BlV.setVisibility(0);
        this.BlT.setVisibility(0);
        this.BlU.setVisibility(8);
        AppMethodBeat.o(231992);
    }

    private void eFD() {
        int i2 = 0;
        AppMethodBeat.i(231993);
        String sM = sM(false);
        if (!Util.isNullOrNil(sM)) {
            this.BlW.setVisibility(0);
            this.BlW.aw(sM);
            int i3 = this.BiU.KWf.KSY;
            int i4 = this.BiU.KWf.KSZ;
            if (i3 > 0 && i4 > 0) {
                com.tencent.neattextview.textview.layout.a mq = this.BlW.mq(com.tencent.mm.cb.a.jn(this.gte) - ((int) (com.tencent.mm.cb.a.getDensity(this.gte) * 32.0f)), Integer.MAX_VALUE);
                if (mq != null) {
                    i2 = mq.hiG();
                }
                if (i2 > 1) {
                    this.BlW.aw(sM(true));
                }
            }
            AppMethodBeat.o(231993);
            return;
        }
        this.BlW.setVisibility(8);
        AppMethodBeat.o(231993);
    }

    private void eFE() {
        AppMethodBeat.i(231994);
        if (this.BiU == null || this.BiU.KWp == null) {
            AppMethodBeat.o(231994);
            return;
        }
        qj qjVar = this.BiU.KWp;
        final String a2 = z.a(qjVar.KXl);
        final String a3 = z.a(qjVar.KXm);
        if (Util.isNullOrNil(a3) || Util.isNullOrNil(a2)) {
            this.BlY.setVisibility(8);
            AppMethodBeat.o(231994);
            return;
        }
        this.BlZ.setText(Util.safeFormatString(this.gte.getString(R.string.b_8), a3));
        this.BlY.setVisibility(0);
        this.BlY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(231972);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(22118, Long.valueOf(c.this.enterTime), c.this.contact.field_username, 2, a2, a3);
                Intent intent = new Intent();
                intent.putExtra("key_enter_profile_type", 12);
                intent.putExtra("finder_username", a2);
                ((aj) g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231972);
            }
        });
        AppMethodBeat.o(231994);
    }

    private String sM(boolean z) {
        AppMethodBeat.i(231995);
        StringBuilder sb = new StringBuilder();
        if (this.BiU.KWf != null) {
            String str = this.BiU.KWf.KTb;
            String str2 = this.BiU.KWf.KTc;
            if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
                sb.append(str);
                if (z) {
                    sb.append("\n");
                } else {
                    sb.append("  ");
                }
                sb.append(str2);
                String sb2 = sb.toString();
                AppMethodBeat.o(231995);
                return sb2;
            } else if (!Util.isNullOrNil(str)) {
                sb.append(str);
                String sb3 = sb.toString();
                AppMethodBeat.o(231995);
                return sb3;
            } else if (!Util.isNullOrNil(str2)) {
                sb.append(str2);
                String sb4 = sb.toString();
                AppMethodBeat.o(231995);
                return sb4;
            }
        }
        AppMethodBeat.o(231995);
        return "";
    }

    private boolean eFb() {
        boolean z = true;
        AppMethodBeat.i(231996);
        try {
            String UV = this.dhv.UV();
            if (Util.isNullOrNil(UV)) {
                AppMethodBeat.o(231996);
                return false;
            }
            long j2 = Util.getLong(UV, 0);
            if (j2 <= 0 || j2 - (System.currentTimeMillis() / 1000) >= 0) {
                z = false;
            }
            Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "isBizAccountTimeExpired:%b", Boolean.valueOf(z));
            AppMethodBeat.o(231996);
            return z;
        } catch (Exception e2) {
            AppMethodBeat.o(231996);
            return false;
        }
    }

    private boolean eEs() {
        AppMethodBeat.i(231997);
        if (this.gte.getIntent() == null) {
            AppMethodBeat.o(231997);
            return false;
        }
        String stringExtra = this.gte.getIntent().getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID);
        String stringExtra2 = this.gte.getIntent().getStringExtra("device_type");
        dv dvVar = new dv();
        dvVar.dGR.dGL = stringExtra;
        dvVar.dGR.dGP = stringExtra2;
        EventCenter.instance.publish(dvVar);
        boolean z = dvVar.dGS.dGT;
        AppMethodBeat.o(231997);
        return z;
    }

    private void eEr() {
        AppMethodBeat.i(231998);
        if (this.gte.getIntent() != null && this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.gte.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (Util.isNullOrNil(stringExtra)) {
                Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!eEs()) {
                Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "IsHardDevice, bindTicket = %s", stringExtra);
                bg.azz().a(536, this);
                dr drVar = new dr();
                drVar.dGF.dGH = stringExtra;
                drVar.dGF.opType = 1;
                EventCenter.instance.publish(drVar);
                final com.tencent.mm.ak.q qVar = drVar.dGG.dGJ;
                MMActivity mMActivity = this.gte;
                this.gte.getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, this.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass8 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(231974);
                        bg.azz().b(536, c.this);
                        dr drVar = new dr();
                        drVar.dGF.opType = 2;
                        drVar.dGF.dGJ = qVar;
                        EventCenter.instance.publish(drVar);
                        AppMethodBeat.o(231974);
                    }
                });
                AppMethodBeat.o(231998);
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.gte, new a.AbstractC2025a() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass9 */

            /* JADX WARNING: Code restructure failed: missing block: B:64:0x0248, code lost:
                if (r2 == false) goto L_0x013a;
             */
            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(boolean r9, boolean r10, java.lang.String r11, java.lang.String r12) {
                /*
                // Method dump skipped, instructions count: 588
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass9.a(boolean, boolean, java.lang.String, java.lang.String):void");
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(Integer.valueOf(this.kgm));
        if (this.dhE != null) {
            aVar.wHV = this.dhE;
        }
        if (!Util.isNullOrNil(this.wZz)) {
            aVar.wZz = this.wZz;
        }
        aVar.Keg = true;
        String stringExtra2 = this.gte.getIntent().getStringExtra("url");
        aVar.Keh = stringExtra2;
        aVar.pHw = e.a.akL(this.gte.getIntent().getIntExtra("qbarScene", -1));
        eqb eqb = new eqb();
        eqb.KJS = this.gte.getIntent().getIntExtra("Contact_Sub_Scene", 0);
        eqb.Lru = this.gte.getIntent().getStringExtra("Contact_Scene_Note");
        if (!Util.isNullOrNil(stringExtra2)) {
            if (Util.isNullOrNil(eqb.Lru)) {
                eqb.Lru = stringExtra2;
            }
            if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(stringExtra2)) {
                eqb.NnE = aKw(stringExtra2);
            }
        }
        aVar.Kei = eqb;
        aVar.a(this.contact.field_username, linkedList, this.Bfi);
        AppMethodBeat.o(231998);
    }

    private static int aKw(String str) {
        int i2 = 10000;
        AppMethodBeat.i(231999);
        if (!Util.isNullOrNil(str)) {
            try {
                i2 = Util.getInt(Uri.parse(str).getQueryParameter("scene"), 10000);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(231999);
        return i2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(232000);
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (qVar == null) {
            Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene == null");
            AppMethodBeat.o(232000);
            return;
        }
        bg.azz().b(qVar.getType(), this);
        if (i2 == 0 && i3 == 0) {
            Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            if (qVar.getType() == 536) {
                bg.azz().b(536, this);
                updateView();
            }
            AppMethodBeat.o(232000);
            return;
        }
        Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
        AppMethodBeat.o(232000);
    }

    static /* synthetic */ void g(c cVar) {
        AppMethodBeat.i(232001);
        if (!com.tencent.mm.model.gdpr.c.aXj()) {
            cVar.eEr();
            AppMethodBeat.o(232001);
            return;
        }
        com.tencent.mm.model.gdpr.c.a(cVar.gte, com.tencent.mm.model.gdpr.a.BIZ, cVar.contact.field_username, new com.tencent.mm.model.gdpr.b() {
            /* class com.tencent.mm.plugin.profile.ui.tab.c.AnonymousClass7 */

            @Override // com.tencent.mm.model.gdpr.b
            public final void sx(int i2) {
                AppMethodBeat.i(231973);
                if (i2 == 0) {
                    c.u(c.this);
                }
                AppMethodBeat.o(231973);
            }
        });
        AppMethodBeat.o(232001);
    }

    static /* synthetic */ void l(c cVar) {
        AppMethodBeat.i(232002);
        Intent intent = new Intent();
        if (cVar.gte.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("chat_from_scene", cVar.gte.getIntent().getIntExtra("chat_from_scene", 0));
        intent.putExtra("KOpenArticleSceneFromScene", 126);
        intent.putExtra("specific_chat_from_scene", 5);
        if (cVar.Bdx) {
            intent.putExtra("Chat_User", cVar.contact.field_username);
            intent.putExtra("Chat_Mode", 1);
            cVar.gte.setResult(-1, intent);
            AppMethodBeat.o(232002);
            return;
        }
        intent.putExtra("Chat_User", cVar.contact.field_username);
        intent.putExtra("Chat_Mode", 1);
        intent.putExtra("finish_direct", true);
        com.tencent.mm.plugin.profile.b.jRt.d(intent, cVar.gte);
        AppMethodBeat.o(232002);
    }

    static /* synthetic */ void a(c cVar, MotionEvent motionEvent) {
        AppMethodBeat.i(232004);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            cVar.pIP.setTextColor(cVar.gte.getResources().getColor(R.color.BW_0_Alpha_0_9));
            AppMethodBeat.o(232004);
            return;
        }
        if (motionEvent.getAction() == 0) {
            cVar.pIP.setTextColor(cVar.gte.getResources().getColor(R.color.BW_0_Alpha_0_5));
        }
        AppMethodBeat.o(232004);
    }

    static /* synthetic */ void t(c cVar) {
        AppMethodBeat.i(232005);
        if (cVar.Bdk == null || cVar.Bdk.cG(false) == null || cVar.Bdk.cG(false).Vb() == null) {
            Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "registerSource is null, return");
            AppMethodBeat.o(232005);
            return;
        }
        String str = cVar.Bdk.cG(false).Vb().diD;
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bizInfo aboutBizUrl is null, will not jump webView");
            AppMethodBeat.o(232005);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_scene", 3);
        intent.putExtra("customize_status_bar_color", cVar.gte.getResources().getColor(R.color.afl));
        com.tencent.mm.br.c.b(cVar.gte, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(232005);
    }
}
