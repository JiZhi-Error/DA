package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J*\u0010\u0017\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "copyText", "", "text", "getLayoutId", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reboot", "testAd", "testFastLoad", "testPrefetch", "testRec", "testWebView", "videoChannel", "showBottomSheet", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function0;", "TestItem", "plugin-brandservice_release"})
public final class BizTestUI extends MMActivity {
    private final String TAG = "MicroMsg.BizTestUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195213);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195213);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195212);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195212);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final c pqO = new c();

        static {
            AppMethodBeat.i(195173);
            AppMethodBeat.o(195173);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ kotlin.x invoke() {
            return kotlin.x.SXb;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(195207);
        super.onCreate(bundle);
        setMMTitle(R.string.f0_);
        setBackBtn(new b(this));
        AppMethodBeat.o(195207);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ BizTestUI pqN;

        b(BizTestUI bizTestUI) {
            this.pqN = bizTestUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(195172);
            this.pqN.finish();
            AppMethodBeat.o(195172);
            return true;
        }
    }

    public final void onClick(View view) {
        String str;
        AppMethodBeat.i(195208);
        kotlin.g.b.p.h(view, "view");
        int id = view.getId();
        if (id == R.id.gc2) {
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this);
            dVar.setTitle("Pkg Info");
            String str2 = "";
            if (MultiProcessMMKV.getMMKV("WebCanvasStorage").decodeInt("BizTimeLineAdPreviewMode", 0) != 1) {
                com.tencent.mm.plugin.webcanvas.m mVar = com.tencent.mm.plugin.webcanvas.m.IAG;
                tu aWJ = com.tencent.mm.plugin.webcanvas.m.aWJ("wxfedb0854e2b1820d");
                String str3 = aWJ != null ? str2 + "BasePkg:md5=" + aWJ.md5 + "\tversion=" + aWJ.version + '\n' : str2;
                com.tencent.mm.plugin.webcanvas.m mVar2 = com.tencent.mm.plugin.webcanvas.m.IAG;
                tu aWJ2 = com.tencent.mm.plugin.webcanvas.m.aWJ("wxf337cbaa27790d8e");
                if (aWJ2 != null) {
                    str3 = str3 + "BizPkg:md5=" + aWJ2.md5 + " \tversion=" + aWJ2.version + '\n';
                }
                com.tencent.mm.plugin.webcanvas.m mVar3 = com.tencent.mm.plugin.webcanvas.m.IAG;
                tu aWJ3 = com.tencent.mm.plugin.webcanvas.m.aWJ("wx97b7aebac2183fd2");
                str = aWJ3 != null ? str3 + "PrefetchBasePkg:md5=" + aWJ3.md5 + " \tversion=" + aWJ3.version + '\n' : str3;
                com.tencent.mm.plugin.webcanvas.m mVar4 = com.tencent.mm.plugin.webcanvas.m.IAG;
                for (T t2 : com.tencent.mm.plugin.webcanvas.m.fWI()) {
                    com.tencent.mm.plugin.webcanvas.m mVar5 = com.tencent.mm.plugin.webcanvas.m.IAG;
                    tu aWJ4 = com.tencent.mm.plugin.webcanvas.m.aWJ(t2);
                    if (aWJ4 != null) {
                        str = str + "PrefetchBizPkg:appId = " + ((String) t2) + ", md5=" + aWJ4.md5 + " \tversion=" + aWJ4.version + '\n';
                    }
                }
            } else {
                bd H = ((com.tencent.mm.plugin.appbrand.service.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H("wxfedb0854e2b1820d", 2, 0);
                if (H != null) {
                    str2 = str2 + "BasePkg:md5=" + H.field_versionMd5 + "\tversion=" + H.field_version + '\n';
                }
                bd H2 = ((com.tencent.mm.plugin.appbrand.service.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H("wxf337cbaa27790d8e", 2, 0);
                if (H2 != null) {
                    str2 = str2 + "BizPkg:md5=" + H2.field_versionMd5 + " \tversion=" + H2.field_version + '\n';
                }
                bd H3 = ((com.tencent.mm.plugin.appbrand.service.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H("wx97b7aebac2183fd2", 2, 0);
                if (H3 != null) {
                    str2 = str2 + "PrefetchBasePkg:md5=" + H3.field_versionMd5 + " \tversion=" + H3.field_version + '\n';
                }
                com.tencent.mm.plugin.webcanvas.m mVar6 = com.tencent.mm.plugin.webcanvas.m.IAG;
                String str4 = str2;
                for (T t3 : com.tencent.mm.plugin.webcanvas.m.fWI()) {
                    bd H4 = ((com.tencent.mm.plugin.appbrand.service.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H(t3, 2, 0);
                    if (H4 != null) {
                        str4 = str4 + "PrefetchBizPkg:appId = " + ((String) t3) + ", md5=" + H4.field_versionMd5 + " \tversion=" + H4.field_version + '\n';
                    }
                }
                str = str4;
            }
            dVar.setMessage(str);
            dVar.aoN(3);
            dVar.aoM(3);
            dVar.a(getString(R.string.e2u), true, null);
            dVar.show();
            ClipboardHelper.setText(getContext(), null, str);
            AppMethodBeat.o(195208);
        } else if (id == R.id.j40) {
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            a(kotlin.a.j.listOf((Object[]) new a[]{new a("开启频道入口动态化", new ac(singleMMKV)), new a("关闭频道入口动态化", new ad(singleMMKV)), new a("使用后台开关", new ae(singleMMKV))}), this, new af(this, singleMMKV));
            AppMethodBeat.o(195208);
        } else if (id == R.id.g2) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(getContext(), BizTestCanvasUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(195208);
        } else if (id == R.id.cb1) {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
            a(kotlin.a.j.listOf((Object[]) new a[]{new a("清理模板", new q(this)), new a("清理数据", new r(this)), new a("检查模板更新", new s(this, mmkv)), new a("关闭超时跳转", new t(this, mmkv)), new a("恢复超时跳转", new u(this, mmkv))}), this);
            AppMethodBeat.o(195208);
        } else if (id == R.id.ff) {
            MultiProcessMMKV singleMMKV2 = MultiProcessMMKV.getSingleMMKV("brandService");
            a(kotlin.a.j.listOf((Object[]) new a[]{new a("预览状态", f.pqQ), new a("发布状态-忽略频控", i.pqS), new a("发布状态", j.pqT), new a("打开广告", new k(singleMMKV2)), new a("关闭广告", new l(singleMMKV2)), new a("正常模式", new m(singleMMKV2)), new a("测试模式", new n(singleMMKV2)), new a("Mock视频模式", new o(singleMMKV2)), new a("Mock图片模式", new p(singleMMKV2)), new a("清理广告曝光", new g(MultiProcessMMKV.getSingleMMKV("biz_timeline_ad")))}), this, new h(this));
            AppMethodBeat.o(195208);
        } else if (id == R.id.gtu) {
            a(kotlin.a.j.listOf((Object[]) new a[]{new a("插入推荐卡片", z.pqV), new a("打开推荐流", new aa(this)), new a("关闭推荐流", new ab(this))}), this);
            AppMethodBeat.o(195208);
        } else if (id == R.id.b8d) {
            a(kotlin.a.j.listOf((Object[]) new a[]{new a("打开大秒开使用pkg", new v(this)), new a("关闭大秒开使用pkg", new w(this)), new a("打开大秒开测试", new x(this)), new a("关闭大秒开测试", new y(this))}), this);
            AppMethodBeat.o(195208);
        } else {
            if (id == R.id.k3i) {
                a(kotlin.a.j.listOf((Object[]) new a[]{new a("打开url传参指定渲染方式", new ag(this)), new a("关闭url传参指定渲染方式", new ah(this))}), this);
            }
            AppMethodBeat.o(195208);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.jo;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "", "name", "", "execute", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExecute", "()Lkotlin/jvm/functions/Function0;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-brandservice_release"})
    static final class a {
        final String name;
        final kotlin.g.a.a<kotlin.x> pqM;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.pqM, r4.pqM) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 195171(0x2fa63, float:2.73493E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI.a
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI$a r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI.a) r4
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                kotlin.g.a.a<kotlin.x> r0 = r3.pqM
                kotlin.g.a.a<kotlin.x> r1 = r4.pqM
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(195170);
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            kotlin.g.a.a<kotlin.x> aVar = this.pqM;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(195170);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(195169);
            String str = "TestItem(name=" + this.name + ", execute=" + this.pqM + ")";
            AppMethodBeat.o(195169);
            return str;
        }

        public a(String str, kotlin.g.a.a<kotlin.x> aVar) {
            kotlin.g.b.p.h(str, "name");
            kotlin.g.b.p.h(aVar, "execute");
            AppMethodBeat.i(195168);
            this.name = str;
            this.pqM = aVar;
            AppMethodBeat.o(195168);
        }
    }

    private static /* synthetic */ void a(List list, Context context) {
        AppMethodBeat.i(195210);
        a(list, context, c.pqO);
        AppMethodBeat.o(195210);
    }

    private static void a(List<a> list, Context context, kotlin.g.a.a<kotlin.x> aVar) {
        AppMethodBeat.i(195209);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 1, false);
        eVar.a(new d(list));
        eVar.a(new e(list, aVar));
        eVar.o(" ", 1);
        eVar.Do(true);
        eVar.dGm();
        AppMethodBeat.o(195209);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ List pqP;

        d(List list) {
            this.pqP = list;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(195174);
            int i2 = 0;
            for (Object obj : this.pqP) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                mVar.c(i2, ((a) obj).name);
                i2 = i3;
            }
            AppMethodBeat.o(195174);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ List pqP;

        e(List list, kotlin.g.a.a aVar) {
            this.pqP = list;
            this.hvp = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(195175);
            ((a) this.pqP.get(i2)).pqM.invoke();
            this.hvp.invoke();
            AppMethodBeat.o(195175);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final f pqQ = new f();

        static {
            AppMethodBeat.i(195177);
            AppMethodBeat.o(195177);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195176);
            MultiProcessMMKV.getMMKV("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195176);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final i pqS = new i();

        static {
            AppMethodBeat.i(195181);
            AppMethodBeat.o(195181);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195180);
            MultiProcessMMKV.getMMKV("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195180);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final j pqT = new j();

        static {
            AppMethodBeat.i(195183);
            AppMethodBeat.o(195183);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195182);
            MultiProcessMMKV.getMMKV("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195182);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195184);
            this.gUu.encode("BizTimeLineAdOpen", 1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195184);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195185);
            this.gUu.encode("BizTimeLineAdOpen", 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195185);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195186);
            this.gUu.encode("BizTimeLineAdTestMode", 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195186);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195187);
            this.gUu.encode("BizTimeLineAdTestMode", 2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195187);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195188);
            this.gUu.encode("BizTimeLineAdTestMode", 1);
            this.gUu.encode("BizTimeLineAdMockType", 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195188);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195189);
            this.gUu.encode("BizTimeLineAdTestMode", 1);
            this.gUu.encode("BizTimeLineAdMockType", 1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195189);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV pqR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.pqR = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195178);
            this.pqR.encode("BizLastExposeAdTime", 0L);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195178);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195179);
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195179);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final z pqV = new z();

        static {
            AppMethodBeat.i(195200);
            AppMethodBeat.o(195200);
        }

        z() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195199);
            com.tencent.mm.storage.af.akc(1001);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195199);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195201);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            singleMMKV.encode("BizTimeLineOpenStatus", 1);
            singleMMKV.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195201);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195202);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            singleMMKV.encode("BizTimeLineOpenStatus", 0);
            singleMMKV.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195202);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195195);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("prefetchUsePkg", 1);
            mmkv.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195195);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195196);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("prefetchUsePkg", 0);
            mmkv.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195196);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195197);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("prefetchTestMode", 1);
            mmkv.apply();
            MultiProcessMMKV.getMMKV("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 2);
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195197);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195198);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("prefetchTestMode", 0);
            mmkv.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195198);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ag(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(259586);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("ImmersiveStyleFromUrl", true);
            mmkv.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(259586);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(259587);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
            mmkv.encode("ImmersiveStyleFromUrl", false);
            mmkv.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(259587);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195190);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
            com.tencent.mm.ui.base.h.cA(this.pqN, "clear all tmpl info");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195190);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(BizTestUI bizTestUI) {
            super(0);
            this.pqN = bizTestUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195191);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.cnv();
            com.tencent.mm.ui.base.h.cA(this.pqN, "clear all cached data");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195191);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;
        final /* synthetic */ MultiProcessMMKV pqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(BizTestUI bizTestUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.pqN = bizTestUI;
            this.pqU = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195192);
            this.pqU.putBoolean("preload_tmpl_always_check_tmpl_ver", true);
            com.tencent.mm.ui.base.h.cA(this.pqN, "enable tmpl always check");
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(90);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195192);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;
        final /* synthetic */ MultiProcessMMKV pqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(BizTestUI bizTestUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.pqN = bizTestUI;
            this.pqU = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195193);
            this.pqU.putBoolean("preload_tmpl_test_noredir", true);
            com.tencent.mm.ui.base.h.cA(this.pqN, "disable re-direct");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195193);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BizTestUI pqN;
        final /* synthetic */ MultiProcessMMKV pqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(BizTestUI bizTestUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.pqN = bizTestUI;
            this.pqU = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195194);
            this.pqU.remove("preload_tmpl_test_noredir");
            com.tencent.mm.ui.base.h.cA(this.pqN, "enable re-direct");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195194);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195203);
            this.gUu.encode("BizTimeLineChannelCanvasOpen", 1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195203);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195204);
            this.gUu.encode("BizTimeLineChannelCanvasOpen", 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195204);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195205);
            this.gUu.encode("BizTimeLineChannelCanvasOpen", -1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195205);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiProcessMMKV gUu;
        final /* synthetic */ BizTestUI pqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(BizTestUI bizTestUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.pqN = bizTestUI;
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195206);
            this.gUu.apply();
            BizTestUI.a(this.pqN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195206);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(BizTestUI bizTestUI) {
        AppMethodBeat.i(195211);
        a.C0860a aVar = com.tencent.mm.plugin.brandservice.a.pma;
        a.C0860a.onSuccess();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 0);
        com.tencent.mm.br.c.f(bizTestUI, ".ui.LauncherUI", intent);
        AppMethodBeat.o(195211);
    }
}
