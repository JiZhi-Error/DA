package com.tencent.mm.plugin.appbrand.shortlink;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager;", "", "()V", "IMAGE_WIDTH", "", "KEY_DATA", "", "KEY_DATA_MMKV_KEY", "KEY_LINK_URL", "QUALITY", "", "TAG", "uploadScreenshotToCdn", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "shortLink", "plugin-appbrand-integration_release"})
public final class e {
    public static final e nNT = new e();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/shortlink/UploadResult;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class a<T> implements d<ResultType> {
        final /* synthetic */ q kAi;
        final /* synthetic */ ag lbw;
        final /* synthetic */ String nNU;

        a(q qVar, ag agVar, String str) {
            this.kAi = qVar;
            this.lbw = agVar;
            this.nNU = str;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            int i2;
            AppMethodBeat.i(229361);
            UploadResult uploadResult = (UploadResult) obj;
            if (uploadResult.dFE) {
                q qVar = this.kAi;
                p.g(qVar, "runtime");
                switch (qVar.brf()) {
                    case 0:
                        i2 = 1;
                        break;
                    case 1:
                        i2 = 2;
                        break;
                    case 2:
                        i2 = 3;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                h hVar = h.INSTANCE;
                q qVar2 = this.kAi;
                p.g(qVar2, "runtime");
                hVar.a(21830, true, true, true, this.lbw.getAppId(), Integer.valueOf(qVar2.OJ()), Integer.valueOf(i2), this.nNU, uploadResult.fileUrl, this.lbw.bRm(), this.lbw.bDn());
            }
            AppMethodBeat.o(229361);
        }
    }

    static {
        AppMethodBeat.i(229363);
        AppMethodBeat.o(229363);
    }

    private e() {
    }

    public static void b(ag agVar, String str) {
        AppMethodBeat.i(229362);
        p.h(agVar, "pageView");
        p.h(str, "shortLink");
        Bitmap bRB = agVar.bRB();
        Matrix matrix = new Matrix();
        p.g(bRB, "screenshot");
        matrix.setScale(720.0f / ((float) bRB.getWidth()), 720.0f / ((float) bRB.getWidth()));
        Bitmap createBitmap = Bitmap.createBitmap(bRB, 0, 0, bRB.getWidth(), bRB.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Log.i("MicroMsg.WxaShortLinkRiskManager", "data size %dBYTE", Integer.valueOf(byteArray.length));
        Bundle bundle = new Bundle();
        com.tencent.mm.plugin.appbrand.ipc.a.a aVar = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
        p.g(byteArray, "data");
        o<Boolean, String> aH = com.tencent.mm.plugin.appbrand.ipc.a.a.aH(byteArray);
        if (aH.first.booleanValue()) {
            bundle.putString("data_mmkv_key", aH.second);
            Log.i("MicroMsg.WxaShortLinkRiskManager", "transfer data with mmkv");
        } else {
            bundle.putByteArray("data", byteArray);
        }
        bundle.putString("linkUrl", str);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, c.class, new a(agVar.getRuntime(), agVar, str));
        AppMethodBeat.o(229362);
    }
}
