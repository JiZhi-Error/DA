package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.nu;
import com.tencent.mm.g.b.a.nv;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.a;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements m {
    TextView CkP;
    AbstractC1942b IIB;
    View IIF;
    LinearLayout IIG;
    d IIH;
    String III;
    String IIJ;
    View IIK;
    private com.tencent.mm.plugin.websearch.widget.view.footer.a IIL;
    LinearLayout IIM;
    MoreFooter IIN;
    float[] IIO = new float[2];
    int IIP;
    g IIQ;
    a IIR;
    WidgetData IIS;
    private WidgetData IIT;
    ThreeDotsLoadingView IIU;
    View IIV;
    View IIW;
    private a.AbstractC1943a IIX = new a.AbstractC1943a() {
        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final void fZk() {
            AppMethodBeat.i(116689);
            List<af> fZb = b.this.IIR.fZb();
            if (fZb == null || fZb.isEmpty() || fZb.size() == 1) {
                AppMethodBeat.o(116689);
                return;
            }
            f.a(1, b.this.IIS, null);
            b.this.IIP = ((com.tencent.mm.plugin.websearch.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(b.this.activity, MMApplicationContext.getContext().getString(R.string.gkv), "", fZb, new ae() {
                /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.websearch.api.ae
                public final void ka(int i2, int i3) {
                    if (i3 != b.this.IIP) {
                    }
                }
            });
            AppMethodBeat.o(116689);
        }

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final void fZl() {
            AppMethodBeat.i(116690);
            b.this.IIQ.fXH();
            AppMethodBeat.o(116690);
        }

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final void fZm() {
            AppMethodBeat.i(116691);
            b.this.IIQ.fXI();
            AppMethodBeat.o(116691);
        }

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final boolean hasNext() {
            AppMethodBeat.i(116692);
            boolean hasNext = b.this.IIR.hasNext();
            AppMethodBeat.o(116692);
            return hasNext;
        }

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final boolean hasPrevious() {
            AppMethodBeat.i(116693);
            boolean fZc = b.this.IIR.fZc();
            AppMethodBeat.o(116693);
            return fZc;
        }

        @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a.AbstractC1943a
        public final int getItemCount() {
            AppMethodBeat.i(116694);
            int fZa = b.this.IIR.fZa();
            AppMethodBeat.o(116694);
            return fZa;
        }
    };
    View.OnClickListener IIY = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(116695);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (b.this.IIS.IFF != null) {
                b.this.am(b.this.IIS.IFF.IFQ, b.this.IIS.IFF.IFP, b.this.IIS.IFG.nbf);
                b.this.qA(true);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(116695);
        }
    };
    e IIy;
    MMActivity activity;
    volatile boolean isLoading;
    boolean isRetry;
    boolean isSelected;
    ViewGroup parent;
    View uGQ;
    View view;
    boolean xEm;

    public interface a {
        int fZa();

        List<af> fZb();

        boolean fZc();

        boolean hasNext();
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$b  reason: collision with other inner class name */
    public interface AbstractC1942b {
    }

    public b() {
        AppMethodBeat.i(116713);
        AppMethodBeat.o(116713);
    }

    /* access modifiers changed from: package-private */
    public final void am(String str, String str2, int i2) {
        String str3;
        int i3;
        AppMethodBeat.i(116714);
        if (this.IIS == null) {
            AppMethodBeat.o(116714);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && !path.endsWith(".html")) {
                str = parse.buildUpon().path(path + ".html").build().toString();
            }
        }
        u.i("WidgetView", "open app with path %s", str);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1108;
        appBrandStatObject.dCw = this.IIS.dWw + "::" + this.IIS.IFG.hes + ":" + this.IIS.IFG.wWb + ":1:" + String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", "", Long.valueOf(System.currentTimeMillis()), this.IIS.IFG.IFM, "isWidget=1", this.III, this.IIS.IFG.iIA, Integer.valueOf(this.IIS.IFG.serviceType), 0);
        String str4 = TextUtils.isEmpty(str) ? this.IIS.IFG.dCx : str;
        if (TextUtils.isEmpty(str2)) {
            str3 = this.IIS.IFG.userName;
        } else {
            str3 = str2;
        }
        r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
        Context context = MMApplicationContext.getContext();
        if (i2 == -1) {
            i3 = this.IIS.IFG.nbf;
        } else {
            i3 = i2;
        }
        rVar.a(context, str3, (String) null, i3, this.IIS.IFG.version, str4, appBrandStatObject);
        WidgetData widgetData = this.IIS;
        fr frVar = new fr();
        frVar.eGU = 1;
        fr sF = frVar.sI(str4).sH(widgetData.query).agD().sF(widgetData.IFG.hes);
        sF.eGX = (long) widgetData.IFG.serviceType;
        fr sG = sF.sG(widgetData.dWw);
        sG.eGW = sG.x("WeappUsrname", str3, true);
        sG.bfK();
        AppMethodBeat.o(116714);
    }

    /* access modifiers changed from: package-private */
    public final void fZd() {
        AppMethodBeat.i(116715);
        if (this.view == null) {
            AppMethodBeat.o(116715);
            return;
        }
        boolean z = this.xEm;
        if (this.view.getVisibility() != 0) {
            this.xEm = false;
            AppMethodBeat.o(116715);
            return;
        }
        this.view.getLocationOnScreen(new int[2]);
        if (this.IIy == null || !this.IIy.fXG()) {
            this.xEm = false;
        } else {
            this.xEm = true;
        }
        if (z != this.xEm && this.xEm) {
            fZj();
        }
        AppMethodBeat.o(116715);
    }

    /* access modifiers changed from: package-private */
    public final void fZe() {
        AppMethodBeat.i(116716);
        if (this.parent == null || this.IIT == this.IIS) {
            Log.v("WidgetView", "%s same widgetData", toString());
            AppMethodBeat.o(116716);
            return;
        }
        this.IIF.setVisibility(8);
        this.IIG.setVisibility(0);
        e(this.IIS);
        AppMethodBeat.o(116716);
    }

    private void e(WidgetData widgetData) {
        AppMethodBeat.i(116717);
        if (widgetData != null) {
            this.isLoading = true;
            this.IIV.setVisibility(8);
            this.IIU.gZi();
            this.IIG.removeView(this.IIU);
            this.IIT = widgetData;
            this.IIF.setVisibility(8);
            this.IIG.setVisibility(0);
            this.IIH.aWZ(this.III);
            this.IIS = widgetData;
            this.III = "widgetid_" + System.currentTimeMillis();
            this.IIH.a(widgetData, this.III, ((j) com.tencent.mm.kernel.g.af(j.class)).fXx(), 47);
            updateView();
            Log.v("WidgetView", "%s, last %s, cur %s", toString(), this.IIT.toString(), this.IIS.toString());
        }
        AppMethodBeat.o(116717);
    }

    /* access modifiers changed from: package-private */
    public final void updateView() {
        AppMethodBeat.i(116718);
        if (this.IIS == null) {
            AppMethodBeat.o(116718);
            return;
        }
        if (this.IIS.IFG.wkz) {
            this.IIK.setVisibility(0);
            this.uGQ.setVisibility(0);
            eWo();
        } else {
            this.IIK.setVisibility(8);
            this.uGQ.setVisibility(8);
        }
        this.CkP.setText(fZh());
        AppMethodBeat.o(116718);
    }

    private void eWo() {
        AppMethodBeat.i(116719);
        switch (this.IIS.IFI) {
            case 1:
                this.IIN.setVisibility(8);
                this.IIM.setVisibility(0);
                fZg();
                AppMethodBeat.o(116719);
                return;
            case 2:
                this.IIM.setVisibility(8);
                this.IIN.setVisibility(0);
                fZf();
                AppMethodBeat.o(116719);
                return;
            default:
                Log.w("WidgetView", "unknown footer type %d", Integer.valueOf(this.IIS.IFI));
                AppMethodBeat.o(116719);
                return;
        }
    }

    private void fZf() {
        AppMethodBeat.i(116720);
        if (this.IIS.IFF != null) {
            this.IIN.setTitle(this.IIS.IFF.title);
            AppMethodBeat.o(116720);
            return;
        }
        this.IIN.setVisibility(8);
        Log.e("WidgetView", "more footer has empty title");
        AppMethodBeat.o(116720);
    }

    private String fZh() {
        AppMethodBeat.i(116722);
        if (!TextUtils.isEmpty(this.IIS.IFG.IFO)) {
            String str = this.IIS.IFG.IFO;
            AppMethodBeat.o(116722);
            return str;
        }
        String string = MMApplicationContext.getContext().getString(R.string.gky);
        AppMethodBeat.o(116722);
        return string;
    }

    private String fZi() {
        AppMethodBeat.i(116723);
        if (!TextUtils.isEmpty(this.IIS.IFG.footerWording)) {
            String str = this.IIS.IFG.footerWording;
            AppMethodBeat.o(116723);
            return str;
        }
        String string = MMApplicationContext.getContext().getString(R.string.gkw, this.IIS.IFG.nickName);
        AppMethodBeat.o(116723);
        return string;
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.i(116724);
        Log.v("WidgetView", "%s selected %b", toString(), Boolean.valueOf(z));
        this.isSelected = z;
        if (this.isSelected) {
            fZe();
            fZd();
            AppMethodBeat.o(116724);
            return;
        }
        this.xEm = false;
        AppMethodBeat.o(116724);
    }

    private void fZj() {
        AppMethodBeat.i(116725);
        Log.i("WidgetView", "exposure");
        String format = String.format("262144:%s:%d:%s;", this.IIS.IFG.wWb, Long.valueOf(System.currentTimeMillis() / 1000), this.IIS.IFG.IFM);
        String str = this.IIS.IFG.serviceType + ";";
        String str2 = "262144:" + this.IIS.IFG.serviceType + ";";
        HashMap hashMap = new HashMap();
        hashMap.put("isexpose", "1");
        hashMap.put("content", format);
        hashMap.put("searchid", this.IIS.IFG.hes);
        hashMap.put("scene", "47");
        hashMap.put(SearchIntents.EXTRA_QUERY, this.IIS.query);
        hashMap.put("sessionid", this.IIS.dWw);
        hashMap.put("resulttype", str2);
        hashMap.put("resultsubtypelist", str);
        hashMap.put("ishomepage", "1");
        hashMap.put("height", this.IIG.getHeight() + ";");
        hashMap.put("requestid", new StringBuilder().append(System.currentTimeMillis()).toString());
        bi(hashMap);
        new nv().AU(format).AX(this.IIS.query).AZ(str).AY(str2).AV(this.IIS.IFG.hes).AW(this.IIS.dWw).ajr().bfK();
        AppMethodBeat.o(116725);
    }

    private static void bi(Map<String, String> map) {
        AppMethodBeat.i(116726);
        doc doc = new doc();
        doc.MRe = bj(map);
        aa.a(new ad(doc).iUB, null);
        AppMethodBeat.o(116726);
    }

    private static String bj(Map<String, String> map) {
        AppMethodBeat.i(116727);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue())).append("&");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(116727);
        return sb2;
    }

    public final void qA(boolean z) {
        AppMethodBeat.i(116728);
        Log.i("WidgetView", "report click");
        HashMap hashMap = new HashMap();
        hashMap.put("content", String.format("262144:%s:%d:%s", this.IIS.IFG.wWb, Long.valueOf(System.currentTimeMillis() / 1000), this.IIS.IFG.IFM));
        hashMap.put("searchid", this.IIS.IFG.hes);
        hashMap.put("scene", "47");
        hashMap.put(SearchIntents.EXTRA_QUERY, this.IIS.query);
        hashMap.put("sessionid", this.IIS.dWw);
        hashMap.put("docid", this.IIS.IFG.wWb);
        hashMap.put(AppMeasurement.Param.TIMESTAMP, new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
        hashMap.put("jumpurl", this.IIS.IFG.dCx);
        Object[] objArr = new Object[3];
        objArr[0] = this.IIS.IFG.IFM;
        objArr[1] = new StringBuilder().append(System.currentTimeMillis()).toString();
        objArr[2] = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        hashMap.put("expand2", String.format("{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}", objArr));
        hashMap.put("businesstype", "262144");
        hashMap.put("h5version", new StringBuilder().append(ai.aft(0)).toString());
        hashMap.put("resulttype", "262144");
        hashMap.put("resultsubtype", new StringBuilder().append(this.IIS.IFG.serviceType).toString());
        bi(hashMap);
        nu nuVar = new nu();
        nuVar.fiy = (long) Util.safeParseInt((String) hashMap.get("businesstype"));
        nuVar.fiz = nuVar.x("docid", (String) hashMap.get("docid"), true);
        nuVar.fiB = nuVar.x("expand2", (String) hashMap.get("expand2"), true);
        nuVar.eBQ = nuVar.x(SearchIntents.EXTRA_QUERY, (String) hashMap.get(SearchIntents.EXTRA_QUERY), true);
        nuVar.fiC = (long) Util.safeParseInt((String) hashMap.get("resultsubtype"));
        nuVar.fiA = System.currentTimeMillis();
        nuVar.fix = nuVar.x("searchid", this.IIS.IFG.hes, true);
        nuVar.els = nuVar.x("sessionid", this.IIS.dWw, true);
        nuVar.erw = 47;
        nuVar.bfK();
        AppMethodBeat.o(116728);
    }

    private void fZg() {
        AppMethodBeat.i(116721);
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a.C0356a.hnM;
        c Fu = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100443");
        if (Fu == null) {
            Log.i("WidgetView", "openSearchPreload item is null");
            AppMethodBeat.o(116721);
            return;
        }
        int i2 = 3;
        if (Fu.isValid()) {
            i2 = Util.safeParseInt(Fu.gzz().get("switchType"));
        }
        switch (i2) {
            case 1:
                if (!(this.IIL instanceof BtnSwitchFooter)) {
                    this.IIM.removeView((View) this.IIL);
                    this.IIL = new BtnSwitchFooter(this.IIM.getContext());
                    this.IIM.addView((View) this.IIL);
                    break;
                }
                break;
            case 2:
                if (!(this.IIL instanceof DirectionSwitchFooter)) {
                    this.IIM.removeView((View) this.IIL);
                    this.IIL = new DirectionSwitchFooter(this.IIM.getContext());
                    this.IIM.addView((View) this.IIL);
                    break;
                }
                break;
            default:
                if (!(this.IIL instanceof DownArrowSwitchFooter)) {
                    this.IIM.removeView((View) this.IIL);
                    this.IIL = new DownArrowSwitchFooter(this.IIM.getContext());
                    this.IIM.addView((View) this.IIL);
                    break;
                }
                break;
        }
        this.IIL.setCallback(this.IIX);
        this.IIL.setTitle(fZi());
        this.IIL.setIcon(this.IIS.IFG.iconUrl);
        AppMethodBeat.o(116721);
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(116729);
        Log.i("WidgetView", "handle tap event %s", bVar.IIJ);
        bVar.am(bVar.IIS.IFG.dCx, "", -1);
        AppMethodBeat.o(116729);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(116730);
        if (!(!bVar.isSelected || bVar.view == null || bVar.IIS == null)) {
            Log.i("WidgetView", "reload widget");
            bVar.IIT = null;
            bVar.fZe();
        }
        AppMethodBeat.o(116730);
    }
}
