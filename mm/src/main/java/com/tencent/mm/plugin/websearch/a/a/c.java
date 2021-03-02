package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.av.r;
import com.tencent.mm.g.b.a.li;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.dsa;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\"\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\nJ\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\nJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\nJ\"\u0010*\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\nJ\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0005R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;)V", "TAG", "", "dialogView", "Landroid/view/View;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "moreTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "moreTabShow", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "initContentView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", SearchIntents.EXTRA_QUERY, "onSharedEnd", "onStartSearchShareCgi", "id", "share", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class c extends android.support.v7.app.e {
    private boolean IGd;
    private d IGe;
    private e IGf;
    egj IGg;
    final a IGh;
    private final String TAG = "MicroMsg.WebSearch.TagSearchDialog";
    private q gut;
    private View jBV;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, egj egj, a aVar) {
        super(context, R.style.us);
        p.h(context, "context");
        p.h(egj, "homeContext");
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AppMethodBeat.i(197968);
        this.IGg = egj;
        this.IGh = aVar;
        AppMethodBeat.o(197968);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(197963);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(67108864);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setDimAmount(0.5f);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(R.style.fs);
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.c1e, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(cont…arch_dialog, null, false)");
        setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        inflate.findViewById(R.id.c2j).setOnTouchListener(new a(this));
        inflate.findViewById(R.id.b46).setOnClickListener(new b(this));
        this.IGe = new d(this, this.IGg, this.IGh, inflate);
        setOnDismissListener(new DialogInterface$OnDismissListenerC1939c(this));
        setCancelable(true);
        this.jBV = inflate;
        AppMethodBeat.o(197963);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class a implements View.OnTouchListener {
        final /* synthetic */ c IGi;

        a(c cVar) {
            this.IGi = cVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(197956);
            this.IGi.dismiss();
            AppMethodBeat.o(197956);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ c IGi;

        b(c cVar) {
            this.IGi = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(197957);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.IGi.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(197957);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.websearch.a.a.c$c  reason: collision with other inner class name */
    static final class DialogInterface$OnDismissListenerC1939c implements DialogInterface.OnDismissListener {
        final /* synthetic */ c IGi;

        DialogInterface$OnDismissListenerC1939c(c cVar) {
            this.IGi = cVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(197958);
            d dVar = this.IGi.IGe;
            if (dVar != null) {
                Log.i(dVar.TAG, "dismiss dialog");
                dVar.IGg.dDv = dVar.IGp.getInEditTextQuery();
                dVar.IGh.onDismiss();
                dVar.IGr.destroy();
                dVar.IGs.removeJavascriptInterface("tagWebSearchJSApi");
                dVar.IGs.destroy();
            }
            e eVar = this.IGi.IGf;
            if (eVar != null) {
                eVar.IGr.destroy();
                eVar.IGs.removeJavascriptInterface("tagWebSearchJSApi");
                eVar.IGs.destroy();
                AppMethodBeat.o(197958);
                return;
            }
            AppMethodBeat.o(197958);
        }
    }

    public final void aXn(String str) {
        AppMethodBeat.i(197964);
        p.h(str, "id");
        if (this.gut == null) {
            this.gut = q.a(getContext(), getContext().getString(R.string.ekc), true, 0, new e(this));
        }
        q qVar = this.gut;
        if (qVar != null) {
            if (!qVar.isShowing()) {
                qVar.show();
            }
            AppMethodBeat.o(197964);
            return;
        }
        AppMethodBeat.o(197964);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class e implements DialogInterface.OnCancelListener {
        final /* synthetic */ c IGi;

        e(c cVar) {
            this.IGi = cVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            com.tencent.mm.plugin.websearch.a.d dVar;
            com.tencent.mm.plugin.websearch.a.d dVar2;
            AppMethodBeat.i(197960);
            d dVar3 = this.IGi.IGe;
            if (!(dVar3 == null || (dVar2 = dVar3.IGr) == null)) {
                dVar2.fYF();
            }
            e eVar = this.IGi.IGf;
            if (eVar == null || (dVar = eVar.IGr) == null) {
                AppMethodBeat.o(197960);
                return;
            }
            dVar.fYF();
            AppMethodBeat.o(197960);
        }
    }

    public final void a(buv buv, Bitmap bitmap, String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(197965);
        p.h(buv, "shareContent");
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("onSearchShare BusinessType:").append(buv.Mbc.xMB).append(" SubType:").append(buv.Mbc.MJT).append(' ').append("BrandFeed:").append(buv.Mbd != null).append(" WeappFeed:").append(buv.Mbf != null).append(" WeappProfile:").append(buv.Mbg != null).append(' ').append("BrandProfile:");
        if (buv.Mbe != null) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder append2 = append.append(z).append(" FinderFeed:").append(buv.Mbi != null).append(" FinderProfile:").append(buv.Mbh != null).append(' ').append("Emoticon:");
        if (buv.Mbj == null) {
            z2 = false;
        }
        Log.i(str2, append2.append(z2).toString());
        com.tencent.mm.ac.d.h(new d(this, buv, bitmap, str));
        AppMethodBeat.o(197965);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
    static final class f implements r.a {
        final /* synthetic */ String IFW;
        final /* synthetic */ c IGi;
        final /* synthetic */ buv IGj;
        final /* synthetic */ k.b IGl;
        final /* synthetic */ dsu IGm;

        f(c cVar, k.b bVar, dsu dsu, buv buv, String str) {
            this.IGi = cVar;
            this.IGl = bVar;
            this.IGm = dsu;
            this.IGj = buv;
            this.IFW = str;
        }

        @Override // com.tencent.mm.av.r.a
        public final void a(String str, Bitmap bitmap, String str2) {
            AppMethodBeat.i(197961);
            w.a.aSz().a(this.IGl, this.IGm.hik, "", this.IGi.IGg.talker, "", BitmapUtil.Bitmap2Bytes(bitmap));
            this.IGi.a(this.IGj, this.IFW);
            AppMethodBeat.o(197961);
        }
    }

    public final void a(buv buv, String str) {
        long j2 = 2;
        AppMethodBeat.i(197966);
        p.h(buv, "shareContent");
        q qVar = this.gut;
        if (qVar != null) {
            qVar.dismiss();
        }
        this.IGh.a(buv);
        dismiss();
        li liVar = new li();
        liVar.uN((long) cl.aWB());
        liVar.uM(2);
        liVar.aiA();
        if (str == null) {
            str = "";
        }
        liVar.yx(str);
        if (!ab.Eq(this.IGg.talker)) {
            j2 = 1;
        }
        liVar.uO(j2);
        liVar.yy(this.IGg.talker);
        String str2 = buv.Mbc.SessionId;
        if (str2 == null) {
            str2 = "";
        }
        liVar.yz(str2);
        String str3 = buv.Mbc.Mbb;
        if (str3 == null) {
            str3 = "";
        }
        liVar.yA(str3);
        String str4 = buv.Mbc.Mba;
        if (str4 == null) {
            str4 = "";
        }
        liVar.yB(str4);
        String str5 = buv.Mbc.MUT;
        if (str5 == null) {
            str5 = "";
        }
        liVar.yC(str5);
        liVar.uQ((long) buv.Mbc.MJT);
        liVar.uP((long) buv.Mbc.xMB);
        liVar.bfK();
        ar.a(liVar);
        AppMethodBeat.o(197966);
    }

    public final void onBackPressed() {
        View findViewById;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator rotation;
        ViewPropertyAnimator duration;
        TextView textView;
        AppMethodBeat.i(197967);
        if (this.IGd) {
            View view = this.jBV;
            if (!(view == null || (textView = (TextView) view.findViewById(R.id.ir3)) == null)) {
                textView.setText(R.string.hk9);
            }
            View view2 = this.jBV;
            if (!(view2 == null || (findViewById = view2.findViewById(R.id.b46)) == null || (animate = findViewById.animate()) == null || (rotation = animate.rotation(90.0f)) == null || (duration = rotation.setDuration(200)) == null)) {
                duration.start();
            }
            e eVar = this.IGf;
            if (eVar != null) {
                eVar.IGv.animate().translationX((float) com.tencent.mm.cb.a.jn(eVar.getActivityContext())).setDuration(300).start();
            }
            this.IGd = false;
            AppMethodBeat.o(197967);
            return;
        }
        dismiss();
        AppMethodBeat.o(197967);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c IGi;
        final /* synthetic */ egj IGn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar, egj egj) {
            super(0);
            this.IGi = cVar;
            this.IGn = egj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(197962);
            View view = this.IGi.jBV;
            if (view != null) {
                View findViewById = view.findViewById(R.id.ir3);
                p.g(findViewById, "it.findViewById<TextView>(R.id.title_tv)");
                ((TextView) findViewById).setText(this.IGn.dDv);
                view.findViewById(R.id.b46).animate().rotation(180.0f).setDuration(200).start();
                if (this.IGi.IGf == null) {
                    this.IGi.IGf = new e(this.IGi, this.IGn, this.IGi.IGh, view);
                } else {
                    e eVar = this.IGi.IGf;
                    if (eVar != null) {
                        egj egj = this.IGn;
                        p.h(egj, "<set-?>");
                        eVar.IGg = egj;
                    }
                }
                this.IGi.IGd = true;
                e eVar2 = this.IGi.IGf;
                if (eVar2 != null) {
                    eVar2.a(this.IGn);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(197962);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String IFW;
        final /* synthetic */ c IGi;
        final /* synthetic */ buv IGj;
        final /* synthetic */ Bitmap IGk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, buv buv, Bitmap bitmap, String str) {
            super(0);
            this.IGi = cVar;
            this.IGj = buv;
            this.IGk = bitmap;
            this.IFW = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(197959);
            c cVar = this.IGi;
            buv buv = this.IGj;
            Bitmap bitmap = this.IGk;
            String str = this.IFW;
            p.h(buv, "shareContent");
            if (buv.Mbi != null) {
                k.b bVar = new k.b();
                com.tencent.mm.plugin.i.a.f fVar = new com.tencent.mm.plugin.i.a.f();
                dsa dsa = buv.Mbi;
                bcj bcj = new bcj();
                bcj.objectId = dsa.KCM;
                bcj.objectNonceId = dsa.MUG;
                bcj.vXJ = dsa.MUE;
                bcj.uNR = dsa.MUF;
                bcj.nickname = dsa.oUJ;
                bcj.desc = dsa.Title;
                bcj.dJl = dsa.xuZ.size();
                LinkedList<bch> linkedList = bcj.mediaList;
                LinkedList<dsb> linkedList2 = dsa.xuZ;
                p.g(linkedList2, "feedObject.MediaList");
                LinkedList<dsb> linkedList3 = linkedList2;
                ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
                for (T t : linkedList3) {
                    bch bch = new bch();
                    bch.mediaType = t.xuT;
                    bch.url = String.valueOf(t.Url);
                    bch.thumbUrl = t.ThumbUrl;
                    bch.width = (float) t.Width;
                    bch.height = (float) t.Height;
                    bch.LLv = t.MUI;
                    arrayList.add(bch);
                }
                linkedList.addAll(arrayList);
                fVar.a(bcj);
                bVar.a(fVar);
                bVar.type = 51;
                bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
                bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
                w.a.aSz().a(bVar, "", "", cVar.IGg.talker, "", null);
                cVar.a(buv, str);
            } else if (buv.Mbh != null) {
                k.b bVar2 = new k.b();
                com.tencent.mm.plugin.i.a.e eVar = new com.tencent.mm.plugin.i.a.e();
                String str2 = buv.Mbh.UserName;
                if (str2 == null) {
                    str2 = "";
                }
                eVar.setUsername(str2);
                String str3 = buv.Mbh.oUJ;
                if (str3 == null) {
                    str3 = "";
                }
                eVar.setNickname(str3);
                String str4 = buv.Mbh.MUD;
                if (str4 == null) {
                    str4 = "";
                }
                eVar.axb(str4);
                String str5 = buv.Mbh.MUC;
                if (str5 == null) {
                    str5 = "";
                }
                eVar.axa(str5);
                String str6 = buv.Mbh.HeadUrl;
                if (str6 == null) {
                    str6 = "";
                }
                eVar.setAvatar(str6);
                bVar2.a(eVar);
                bVar2.type = 50;
                bVar2.title = MMApplicationContext.getContext().getString(R.string.enf);
                bVar2.url = MMApplicationContext.getContext().getString(R.string.eng);
                w.a.aSz().a(bVar2, "", "", cVar.IGg.talker, "", null);
                cVar.a(buv, str);
            } else if (buv.Mbd != null) {
                k.b bVar3 = new k.b();
                bVar3.title = buv.Mbd.Title;
                bVar3.thumburl = buv.Mbd.ThumbUrl;
                bVar3.url = buv.Mbd.AAN;
                bVar3.description = buv.Mbd.Desc;
                bVar3.action = "view";
                bVar3.iwL = 3;
                bVar3.eag = buv.Mbd.MUg;
                bVar3.eah = buv.Mbd.MUh;
                bVar3.type = 5;
                com.tencent.mm.ag.e eVar2 = new com.tencent.mm.ag.e();
                eVar2.iwc = 0;
                bVar3.a(eVar2);
                w.a.aSz().a(bVar3, "", "", cVar.IGg.talker, "", null);
                cVar.a(buv, str);
            } else if (buv.Mbe != null) {
                drn drn = buv.Mbe;
                ae aeVar = ae.SYK;
                String format = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", Arrays.copyOf(new Object[]{Util.escapeStringForXml(drn.Username), Util.escapeStringForXml(drn.oUJ), Util.escapeStringForXml(drn.MUc), Util.escapeStringForXml(drn.MUb), Util.escapeStringForXml(""), 0, Util.escapeStringForXml(drn.kdZ), Util.escapeStringForXml(drn.kea), Util.escapeStringForXml(drn.keb), 0, Integer.valueOf(drn.kdY), Integer.valueOf(drn.MmK), "", drn.xJE, Util.escapeStringForXml(drn.keh)}, 15));
                p.g(format, "java.lang.String.format(format, *args)");
                com.tencent.mm.plugin.messenger.a.g.eir().e(buv.Mbe.Username, cVar.IGg.talker, format, ab.Eq(cVar.IGg.talker));
                cVar.a(buv, str);
            } else if (buv.Mbf != null) {
                dsu dsu = buv.Mbf;
                k.b bVar4 = new k.b();
                bVar4.title = dsu.Desc;
                bVar4.izi = dsu.UserName;
                bVar4.izh = dsu.xut;
                bVar4.izj = dsu.hik;
                bVar4.izz = 0;
                bVar4.izA = dsu.Version;
                bVar4.izk = 2;
                bVar4.url = ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).Ur(dsu.hik);
                bVar4.izB = dsu.MUV;
                bVar4.eam = "wxapp_" + dsu.hik + dsu.xut;
                bVar4.eag = dsu.UserName;
                bVar4.eah = dsu.Title;
                bVar4.a(new com.tencent.mm.ag.a());
                bVar4.type = 33;
                if (!TextUtils.isEmpty(dsu.ThumbUrl)) {
                    com.tencent.mm.av.q.bcU().a(dsu.ThumbUrl, new f(cVar, bVar4, dsu, buv, str));
                } else {
                    w.a.aSz().a(bVar4, dsu.hik, "", cVar.IGg.talker, "", BitmapUtil.Bitmap2Bytes(bitmap));
                    cVar.a(buv, str);
                }
            } else if (buv.Mbg != null) {
                k.b bVar5 = new k.b();
                bVar5.title = buv.Mbg.MUh;
                bVar5.type = 33;
                bVar5.izi = buv.Mbg.UserName;
                bVar5.izj = buv.Mbg.hik;
                bVar5.izk = 1;
                bVar5.eam = "wxapp_" + buv.Mbg.hik;
                bVar5.thumburl = buv.Mbg.ThumbUrl;
                ae aeVar2 = ae.SYK;
                Locale locale = Locale.US;
                p.g(locale, "Locale.US");
                String format2 = String.format(locale, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", Arrays.copyOf(new Object[]{buv.Mbg.hik, 3}, 2));
                p.g(format2, "java.lang.String.format(locale, format, *args)");
                bVar5.url = format2;
                bVar5.eag = buv.Mbg.UserName;
                bVar5.eah = buv.Mbg.MUh;
                com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
                aVar.ivc = buv.Mbg.MUW;
                bVar5.a(aVar);
                w.a.aSz().a(bVar5, buv.Mbg.hik, buv.Mbg.MUh, cVar.IGg.talker, null, null);
                cVar.a(buv, str);
            } else if (buv.Mbj != null) {
                cVar.getContext();
                ((com.tencent.mm.pluginsdk.j) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class)).G(cVar.IGg.talker, buv.Mbj.MUu, buv.Mbj.MUy, buv.Mbj.MUx);
                cVar.a(buv, str);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(197959);
            return xVar;
        }
    }
}
