package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.m;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c extends com.tencent.mm.loader.g.c {
    final String TAG = "MicroMsg.EmojiCaptureUploadTask";
    final EmojiInfo gWm;
    long hdA;
    final boolean hdB = this.gWm.hYo();
    final long hdz = this.gWm.field_captureEnterTime;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ c hdC;
        final /* synthetic */ String hdE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, String str) {
            super(1);
            this.hdC = cVar;
            this.hdE = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(105773);
            bool.booleanValue();
            com.tencent.mm.emoji.loader.f.c cVar = com.tencent.mm.emoji.loader.f.c.gWT;
            com.tencent.mm.emoji.loader.f.c.k(this.hdC.gWm);
            this.hdC.a(j.OK);
            b bVar = b.hdv;
            b.b(this.hdC.hdz, true, this.hdE);
            x xVar = x.SXb;
            AppMethodBeat.o(105773);
            return xVar;
        }
    }

    public c(EmojiInfo emojiInfo) {
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105776);
        this.gWm = emojiInfo;
        AppMethodBeat.o(105776);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    public static final class a implements m.b {
        final /* synthetic */ c hdC;
        final /* synthetic */ long hdD;

        a(c cVar, long j2) {
            this.hdC = cVar;
            this.hdD = j2;
        }

        @Override // com.tencent.mm.emoji.b.m.b
        public final void z(int i2, String str) {
            AppMethodBeat.i(105772);
            Log.i(this.hdC.TAG, "uploadCallback: " + i2 + ", " + str);
            this.hdC.hdA = Util.milliSecondsToNow(this.hdD);
            if (i2 == 0) {
                c cVar = this.hdC;
                EmojiCaptureReporter.f(cVar.hdz, cVar.hdA, cVar.gWm.field_captureScene);
                h.INSTANCE.a(10431, 7, cVar.gWm.getMd5(), cVar.gWm.field_designerID, cVar.gWm.avy(), 0, 0, Integer.valueOf(cVar.gWm.getSize()), z.aTY(), cVar.gWm.field_activityid);
                if (!cVar.hdB || n.avd()) {
                    cVar.a(j.OK);
                    b bVar = b.hdv;
                    b.b(cVar.hdz, true, str);
                    AppMethodBeat.o(105772);
                    return;
                }
                Log.w(cVar.TAG, "upload wxam but not decode, load gif");
                com.tencent.mm.emoji.loader.c.h hVar = com.tencent.mm.emoji.loader.c.h.gWs;
                com.tencent.mm.emoji.loader.c.h.d(cVar.gWm, new b(cVar, str));
                AppMethodBeat.o(105772);
                return;
            }
            c cVar2 = this.hdC;
            cVar2.gWm.a(EmojiInfo.a.STATUS_UPLOAD_FAIL);
            int i3 = cVar2.gWm.field_captureScene;
            switch (i2) {
                case 2:
                    EmojiCaptureReporter.f(cVar2.hdz, 2, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_OVER_SIZE);
                    break;
                case 3:
                    EmojiCaptureReporter.f(cVar2.hdz, 1, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_OVER_LIMIT);
                    break;
                case 4:
                    EmojiCaptureReporter.f(cVar2.hdz, 5, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_NOT_COMPLETED);
                    break;
                case 5:
                    EmojiCaptureReporter.f(cVar2.hdz, 7, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_NON_NETWORK);
                    break;
                case 6:
                    EmojiCaptureReporter.f(cVar2.hdz, 8, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_WIFI_NETWORK);
                    break;
                case 7:
                    EmojiCaptureReporter.f(cVar2.hdz, 9, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_MOBILE_NETWORK);
                    break;
                case 8:
                    EmojiCaptureReporter.f(cVar2.hdz, 6, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_SPAM);
                    break;
                case 9:
                    EmojiCaptureReporter.f(cVar2.hdz, 10, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_OVER_UPLOAD_TIME);
                    break;
                case 10:
                    EmojiCaptureReporter.f(cVar2.hdz, 4, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_LOCAL_FILE);
                    break;
                case 11:
                    EmojiCaptureReporter.f(cVar2.hdz, 3, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_OVER_UPLOAD_TIME);
                    break;
                default:
                    EmojiCaptureReporter.f(cVar2.hdz, 3, i3);
                    cVar2.gWm.a(EmojiInfo.b.ERR_OTHERS);
                    break;
            }
            com.tencent.mm.kernel.b.a ah = g.ah(d.class);
            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
            bj emojiStorageMgr = ((d) ah).getEmojiStorageMgr();
            p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.cgN().L(cVar2.gWm);
            b bVar2 = b.hdv;
            b.b(cVar2.hdz, false, null);
            cVar2.a(j.Fail);
            AppMethodBeat.o(105772);
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(105774);
        new m(this.gWm, new a(this, Util.nowMilliSecond()));
        AppMethodBeat.o(105774);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(105775);
        String valueOf = String.valueOf(this.hdz);
        AppMethodBeat.o(105775);
        return valueOf;
    }
}
