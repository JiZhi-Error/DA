package com.tencent.mm.plugin.appbrand.openmaterial.a;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.i;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/FakeOpenMaterialDataSource;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "()V", "fakeFetchOpenMaterialsByCGI", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterials", "", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsInner", "fetchOpenMaterialsQuickly", "prefetchOpenMaterialsOnLaunchAppBrand", "plugin-appbrand-integration_release"})
public final class a implements b {
    public static final a nln = new a();

    static {
        AppMethodBeat.i(229140);
        AppMethodBeat.o(229140);
    }

    private a() {
    }

    public static final /* synthetic */ AppBrandOpenMaterialCollection f(MaterialModel materialModel) {
        AppMethodBeat.i(229141);
        AppBrandOpenMaterialCollection d2 = d(materialModel);
        AppMethodBeat.o(229141);
        return d2;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final void c(MaterialModel materialModel) {
        AppMethodBeat.i(229135);
        p.h(materialModel, "materialModel");
        AppMethodBeat.o(229135);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final void a(MaterialModel materialModel, i iVar) {
        AppMethodBeat.i(229136);
        p.h(materialModel, "materialModel");
        p.h(iVar, "fetchOpenMaterialsCallback");
        if (p.j(Looper.getMainLooper(), Looper.myLooper())) {
            iVar.a(true, d(materialModel));
            AppMethodBeat.o(229136);
            return;
        }
        h.RTc.aV(new RunnableC0757a(iVar, materialModel));
        AppMethodBeat.o(229136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.a.a$a  reason: collision with other inner class name */
    static final class RunnableC0757a implements Runnable {
        final /* synthetic */ i nlo;
        final /* synthetic */ MaterialModel nlp;

        RunnableC0757a(i iVar, MaterialModel materialModel) {
            this.nlo = iVar;
            this.nlp = materialModel;
        }

        public final void run() {
            AppMethodBeat.i(229134);
            i iVar = this.nlo;
            a aVar = a.nln;
            iVar.a(true, a.f(this.nlp));
            AppMethodBeat.o(229134);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final AppBrandOpenMaterialCollection a(MaterialModel materialModel) {
        AppMethodBeat.i(229137);
        p.h(materialModel, "materialModel");
        AppBrandOpenMaterialCollection d2 = d(materialModel);
        AppMethodBeat.o(229137);
        return d2;
    }

    private static AppBrandOpenMaterialCollection d(MaterialModel materialModel) {
        AppMethodBeat.i(229138);
        Log.d("MicroMsg.AppBrand.FakeOpenMaterialDataSource", "fetchOpenMaterialsInner");
        AppBrandOpenMaterialCollection e2 = e(materialModel);
        AppMethodBeat.o(229138);
        return e2;
    }

    private static AppBrandOpenMaterialCollection e(MaterialModel materialModel) {
        AppMethodBeat.i(229139);
        Log.d("MicroMsg.AppBrand.FakeOpenMaterialDataSource", "fakeFetchOpenMaterialsByCGI");
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = new AppBrandOpenMaterialDetailModel("wxda97763422d9a0ca", 1, "/pages/index/index.html", "http://mmbiz.qpic.cn/mmbiz_png/4XQzbXAGErjY4jReHjaVey8nFTn79HfdFDpiaUK6CywZ5HMaCUcqDufIJ2LkaQTvdPcoMHCSOy5oEeWCOg4CKzg/640?wx_fmt=png&wxfrom=200", "用有BUG啦打开", j.listOf("测试"), 0.0f, "无敌的小程序");
        appBrandOpenMaterialDetailModel.appName = "有BUG啦";
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel2 = new AppBrandOpenMaterialDetailModel("wxd45c635d754dbf59", 0, "/pages/importFile/importFile.html", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6cPEzjibMPv4KFl21AkI9SBl4ODic7Kb1mkGl4T9aL3Img/96", "用腾讯文档打开", j.listOf("笔记"), 4.6f, "多人协作在线文档");
        appBrandOpenMaterialDetailModel2.appName = "腾讯文档";
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel3 = new AppBrandOpenMaterialDetailModel("wx5b97b0686831c076", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5SKdZHeibnv7SAvE0d7lLW0jjeQAlCA5QhUrvAibneU49w/96", "用金山文档编辑", j.listOf("办公、笔记"), 4.6f, "多人实时协作的在线Office");
        appBrandOpenMaterialDetailModel3.appName = "金山文档";
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel4 = new AppBrandOpenMaterialDetailModel("wx75425a38a3ed6402", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5qedyLib8wW0GzEAZOBs6xRFMBHoa2M0kFlmiaxrxTr85g/96", "用印象笔记记录", j.listOf("办公、笔记"), 4.6f, "随时记录, 支持分享");
        appBrandOpenMaterialDetailModel4.appName = "印象笔记";
        AppBrandOpenMaterialModel appBrandOpenMaterialModel = new AppBrandOpenMaterialModel("wxa9cee04ddf631e72", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6pjqW5bhHPuXibzcoJsAZOmvJXp0CaRAdicXiclUaBWfnaw/96", "用石墨文档档档档档档打开");
        appBrandOpenMaterialModel.appName = "石墨文档档档档档档";
        AppBrandOpenMaterialModel appBrandOpenMaterialModel2 = new AppBrandOpenMaterialModel("wxd574de764a7b7c7f", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM43gt1wQekxSo9icCPWoOtnMe2okSubKHrefmwCNa5W77Q/96", "保存到微云");
        appBrandOpenMaterialModel2.appName = "微云";
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel5 = new AppBrandOpenMaterialDetailModel("wx5b3bd5898fba8574", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM4TsQdnFQxcSwfgMqtpMDjTmdgF2gCzsrSBUWr5wkeXUg/96", "用文章截图打开", j.listOf("图片"), 4.7f, "截长图小程序");
        appBrandOpenMaterialDetailModel5.appName = "文章截图";
        AppBrandOpenMaterialModel appBrandOpenMaterialModel3 = new AppBrandOpenMaterialModel("wxb315b84b1622f225", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fqS4upaNjFwXDYHDhRRZibsn13dINnbVUrYg9rAS4l9w/96", "用文件打印打开");
        appBrandOpenMaterialModel3.appName = "文件打印";
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection = new AppBrandOpenMaterialCollection(materialModel, j.listOf((Object[]) new AppBrandOpenMaterialModel[]{appBrandOpenMaterialDetailModel, appBrandOpenMaterialModel, appBrandOpenMaterialModel2, appBrandOpenMaterialModel3}), j.listOf((Object[]) new AppBrandOpenMaterialDetailModel[]{appBrandOpenMaterialDetailModel, appBrandOpenMaterialDetailModel2, appBrandOpenMaterialDetailModel3, appBrandOpenMaterialDetailModel4, appBrandOpenMaterialDetailModel5}));
        AppMethodBeat.o(229139);
        return appBrandOpenMaterialCollection;
    }
}
