package com.tencent.mm.plugin.appbrand.shortlink;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/plugin/appbrand/shortlink/UploadResult;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
public final class c implements b<Bundle, UploadResult> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<UploadResult> dVar) {
        byte[] Za;
        AppMethodBeat.i(229346);
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            String string = bundle2.getString("linkUrl");
            if (TextUtils.isEmpty(bundle2.getString("data_mmkv_key", ""))) {
                Za = bundle2.getByteArray("data");
            } else {
                com.tencent.mm.plugin.appbrand.ipc.a.a aVar = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
                String string2 = bundle2.getString("data_mmkv_key");
                if (string2 == null) {
                    p.hyc();
                }
                p.g(string2, "bundle.getString(KEY_DATA_MMKV_KEY)!!");
                Za = com.tencent.mm.plugin.appbrand.ipc.a.a.Za(string2);
            }
            g gVar = new g();
            gVar.taskName = "task_WxaMpShortLinkScreenshot";
            gVar.field_fileType = com.tencent.mm.i.a.gpW;
            gVar.field_bzScene = 2;
            gVar.field_appType = 302;
            StringBuilder sb = new StringBuilder();
            p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            gVar.field_mediaId = sb.append(new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue()).append('_').append(System.currentTimeMillis()).append('_').append(MD5Util.getMD5String(string)).toString();
            gVar.fileBuffer = Za;
            gVar.field_needStorage = false;
            gVar.snsVersion = 0;
            gVar.gqy = new a(dVar);
            if (!f.baQ().f(gVar)) {
                if (dVar != null) {
                    dVar.bn(new UploadResult());
                }
                Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload add task fail");
            }
            AppMethodBeat.o(229346);
        } else if (dVar != null) {
            dVar.bn(new UploadResult());
            AppMethodBeat.o(229346);
        } else {
            AppMethodBeat.o(229346);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/appbrand/shortlink/Task$invoke$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "p2", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "p4", "", "decodePrepareResponse", "", "p0", "p1", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "plugin-appbrand-integration_release"})
    public static final class a implements g.a {
        final /* synthetic */ d kFf;

        a(d dVar) {
            this.kFf = dVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(229345);
            if (dVar == null) {
                d dVar2 = this.kFf;
                if (dVar2 != null) {
                    dVar2.bn(new UploadResult());
                }
                AppMethodBeat.o(229345);
            } else if (i2 != 0) {
                d dVar3 = this.kFf;
                if (dVar3 != null) {
                    dVar3.bn(new UploadResult());
                }
                Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, startRet : %d", Integer.valueOf(i2));
                AppMethodBeat.o(229345);
            } else {
                if (dVar.field_retCode != 0) {
                    Log.e("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, retCode:%d sceneResult[%s]", Integer.valueOf(dVar.field_retCode), dVar);
                    d dVar4 = this.kFf;
                    if (dVar4 != null) {
                        dVar4.bn(new UploadResult());
                    }
                } else {
                    Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload success, media id : %s  file url=%s   thumb url=%s", str, dVar.field_fileUrl, dVar.field_thumbUrl);
                    d dVar5 = this.kFf;
                    if (dVar5 != null) {
                        String str2 = dVar.field_fileUrl;
                        p.g(str2, "sceneResult.field_fileUrl");
                        dVar5.bn(new UploadResult(true, str2));
                    }
                }
                AppMethodBeat.o(229345);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    }
}
