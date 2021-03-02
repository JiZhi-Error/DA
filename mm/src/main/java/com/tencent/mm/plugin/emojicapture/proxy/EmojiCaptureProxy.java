package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.game.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.d.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.ae;
import com.tencent.mm.plugin.appbrand.jsapi.p.w;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0007J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001f\u001a\u00020\u0006H\u0007J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0006H\u0007J\u0006\u0010#\u001a\u00020\nJ\b\u0010$\u001a\u00020\nH\u0007J\b\u0010%\u001a\u0004\u0018\u00010\u0006J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\fJ\b\u0010*\u001a\u00020\fH\u0007J\u0006\u0010+\u001a\u00020\u001cJ\b\u0010,\u001a\u00020\u001cH\u0007J\u0006\u0010-\u001a\u00020\nJ\b\u0010.\u001a\u00020\nH\u0007J!\u0010/\u001a\u00020\u00112\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a01\"\u00020\u001aH\u0014¢\u0006\u0002\u00102J \u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\nH\u0016J\u0016\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006J\u0018\u0010:\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0007J\u0006\u0010;\u001a\u00020\fJ\b\u0010<\u001a\u00020\fH\u0007J\u000e\u0010=\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010>\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010?\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkUseCPUCrop", "", "createEmojiInfo", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getLensList", "getLensListRemote", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", NativeProtocol.WEB_DIALOG_PARAMS, "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureProxy extends com.tencent.mm.remoteservice.a {
    private static int gVP;
    private static boolean gVQ = true;
    private static EmojiCaptureProxy rrE = new EmojiCaptureProxy(new d(MMApplicationContext.getContext()));
    public static final a rrF = new a((byte) 0);
    private final String RESULT_KEY = "result_key";
    private final d gVN;

    public EmojiCaptureProxy(d dVar) {
        super(dVar);
        this.gVN = dVar;
    }

    public final d getServerProxy() {
        return this.gVN;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void cJA() {
            AppMethodBeat.i(381);
            EmojiCaptureProxy.gVP++;
            if (EmojiCaptureProxy.gVQ) {
                EmojiCaptureProxy.gVQ = false;
                EmojiCaptureProxy emojiCaptureProxy = new EmojiCaptureProxy(new d(MMApplicationContext.getContext()));
                p.h(emojiCaptureProxy, "<set-?>");
                EmojiCaptureProxy.rrE = emojiCaptureProxy;
            }
            AppMethodBeat.o(381);
        }

        public static void cJB() {
            AppMethodBeat.i(382);
            EmojiCaptureProxy.gVP--;
            if (EmojiCaptureProxy.gVP <= 0) {
                EmojiCaptureProxy.gVQ = true;
                d serverProxy = EmojiCaptureProxy.rrE.getServerProxy();
                if (serverProxy != null) {
                    serverProxy.release();
                    AppMethodBeat.o(382);
                    return;
                }
            }
            AppMethodBeat.o(382);
        }
    }

    static {
        AppMethodBeat.i(414);
        AppMethodBeat.o(414);
    }

    public final void createEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(384);
        p.h(emojiInfo, "emojiInfo");
        Log.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + emojiInfo.getMd5());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("createEmojiInfoRemote", bundle);
        AppMethodBeat.o(384);
    }

    public final String getDynamicConfig(String str) {
        AppMethodBeat.i(385);
        p.h(str, "key");
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", str);
        Log.i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", str, REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(385);
            return "";
        }
        String str2 = (String) REMOTE_CALL;
        AppMethodBeat.o(385);
        return str2;
    }

    public final boolean getEnableAutoRotate() {
        AppMethodBeat.i(386);
        boolean j2 = p.j(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.o(386);
        return j2;
    }

    public final int getInt(ar.a aVar, int i2) {
        AppMethodBeat.i(387);
        p.h(aVar, "key");
        Log.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", aVar, Integer.valueOf(i2));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Integer.valueOf(i2));
        Log.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", aVar, Integer.valueOf(i2), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(387);
            return i2;
        }
        int i3 = Util.getInt(REMOTE_CALL.toString(), i2);
        AppMethodBeat.o(387);
        return i3;
    }

    public final String getForbidLensId() {
        AppMethodBeat.i(w.CTRL_INDEX);
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", "EmotionSpringFestivalPendantBlockedIdList");
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.o(w.CTRL_INDEX);
            return str;
        }
        AppMethodBeat.o(w.CTRL_INDEX);
        return null;
    }

    public final boolean isSpringFestivalEnable() {
        AppMethodBeat.i(ae.CTRL_INDEX);
        boolean j2 = p.j(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.o(ae.CTRL_INDEX);
        return j2;
    }

    public final String getDeviceInfoConfig() {
        AppMethodBeat.i(390);
        Object REMOTE_CALL = REMOTE_CALL("getDeviceInfoConfigRemote", new Object[0]);
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.o(390);
            return str;
        }
        AppMethodBeat.o(390);
        return null;
    }

    public final int getUseGpuSegment() {
        AppMethodBeat.i(391);
        Object REMOTE_CALL = REMOTE_CALL("getUseGpuSegmentRemote", new Object[0]);
        if (REMOTE_CALL instanceof Integer) {
            int intValue = ((Number) REMOTE_CALL).intValue();
            AppMethodBeat.o(391);
            return intValue;
        }
        AppMethodBeat.o(391);
        return 0;
    }

    @f
    public final void createEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.i(392);
        p.h(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        Log.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.getMd5() : null));
        if (emojiInfo != null) {
            com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().l(emojiInfo.getMd5(), 0, EmojiInfo.VkY, emojiInfo.field_size);
            com.tencent.mm.kernel.b.a ah2 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah2).getEmojiMgr().updateEmojiInfo(emojiInfo);
            com.tencent.mm.kernel.b.a ah3 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah3, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah3).getEmojiMgr().t(emojiInfo);
            AppMethodBeat.o(392);
            return;
        }
        EmojiCaptureReporter.Gi(31);
        e eVar = e.roB;
        e.cJj();
        AppMethodBeat.o(392);
    }

    public final void deleteEmojiInfoByMd5(String str) {
        AppMethodBeat.i(393);
        p.h(str, "md5");
        Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(str)));
        REMOTE_CALL("deleteEmojiInfoByMd5Remote", str);
        AppMethodBeat.o(393);
    }

    @f
    public final void deleteEmojiInfoByMd5Remote(String str) {
        AppMethodBeat.i(394);
        p.h(str, "md5");
        Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(str)));
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        bj emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiStorageMgr();
        p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.cgN().bll(str);
        AppMethodBeat.o(394);
    }

    public final void deleteEmojiInfoByEnterTime(long j2) {
        AppMethodBeat.i(c.CTRL_INDEX);
        Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(j2)));
        REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", Long.valueOf(j2));
        AppMethodBeat.o(c.CTRL_INDEX);
    }

    @f
    public final void deleteEmojiInfoByEnterTimeRemote(long j2) {
        AppMethodBeat.i(396);
        Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(j2)));
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        bj emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiStorageMgr();
        p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.cgN().Nm(j2);
        AppMethodBeat.o(396);
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(397);
        p.h(emojiInfo, "emojiInfo");
        Log.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + emojiInfo.getMd5());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("updateEmojiInfoRemote", bundle);
        AppMethodBeat.o(397);
    }

    @f
    public final void updateEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.i(398);
        p.h(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        Log.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.getMd5() : null));
        if (emojiInfo != null) {
            com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.o(398);
            return;
        }
        EmojiCaptureReporter.Gi(31);
        e eVar = e.roB;
        e.cJj();
        AppMethodBeat.o(398);
    }

    public final void postUploadTask(String str, String str2) {
        AppMethodBeat.i(399);
        p.h(str, "filePath");
        p.h(str2, "mixingMd5");
        Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + str + ", " + str2);
        REMOTE_CALL("postUploadTaskRemote", str, str2);
        AppMethodBeat.o(399);
    }

    @f
    public final void postUploadTaskRemote(String str, String str2) {
        AppMethodBeat.i(400);
        p.h(str, "filePath");
        p.h(str2, "mixingMd5");
        Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + str + ", " + str2);
        int boW = (int) s.boW(str);
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().aml(str2);
        if (aml == null) {
            AppMethodBeat.o(400);
        } else if (boW <= 0) {
            aml.a(EmojiInfo.b.ERR_MIX_OUTPUT_EMPTY);
            aml.a(EmojiInfo.a.STATUS_MIX_FAIL);
            com.tencent.mm.kernel.b.a ah2 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah2).getEmojiMgr().updateEmojiInfo(aml);
            EmojiCaptureReporter.g(aml.field_captureEnterTime, 4, aml.field_captureScene);
            AppMethodBeat.o(400);
        } else {
            String bhK = s.bhK(str);
            String str3 = EmojiInfo.hYz() + bhK;
            s.nx(str, str3);
            Log.i("MicroMsg.EmojiCaptureProxy", "upload file " + str3 + " length is " + boW);
            com.tencent.mm.kernel.b.a ah3 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah3, "MMKernel.plugin(IPluginEmoji::class.java)");
            bj emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) ah3).getEmojiStorageMgr();
            p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.cgN().bll(aml.getMd5());
            aml.setMd5(bhK);
            aml.a(EmojiInfo.a.STATUS_UPLOADING);
            aml.setSize((int) s.boW(str3));
            if (ImgUtil.isWXGF(str3)) {
                aml.field_wxamMd5 = bhK;
                aml.field_externMd5 = bhK;
            }
            com.tencent.mm.kernel.b.a ah4 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah4, "MMKernel.plugin(IPluginEmoji::class.java)");
            bj emojiStorageMgr2 = ((com.tencent.mm.plugin.emoji.b.d) ah4).getEmojiStorageMgr();
            p.g(emojiStorageMgr2, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr2.cgN().J(aml);
            i iVar = i.hdO;
            i.o(aml);
            AppMethodBeat.o(400);
        }
    }

    public final boolean useCPUCrop() {
        AppMethodBeat.i(401);
        Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
        Object REMOTE_CALL = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
        if (REMOTE_CALL == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(401);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(401);
        return booleanValue;
    }

    @f
    public final boolean checkUseCPUCrop() {
        AppMethodBeat.i(402);
        Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
        boolean z = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO;
        AppMethodBeat.o(402);
        return z;
    }

    public final void showImitateDialog() {
        AppMethodBeat.i(403);
        REMOTE_CALL("showImitateDialogRemote", new Object[0]);
        AppMethodBeat.o(403);
    }

    @f
    public final void showImitateDialogRemote() {
        AppMethodBeat.i(404);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = context.getResources().getString(R.string.bmn);
        p.g(string, "MMApplicationContext.get…g_first_open_imitate_msg)");
        new f.a(MMApplicationContext.getContext()).bow(string).apa(R.string.bmm).b(b.rrG).show();
        AppMethodBeat.o(404);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b implements f.c {
        public static final b rrG = new b();

        static {
            AppMethodBeat.i(383);
            AppMethodBeat.o(383);
        }

        b() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    @com.tencent.mm.remoteservice.f
    public final String getDynamicConfigInMM(String str) {
        AppMethodBeat.i(405);
        p.h(str, "key");
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue(str);
        AppMethodBeat.o(405);
        return value;
    }

    @com.tencent.mm.remoteservice.f
    public final boolean isSpringFestivalEnableRemote() {
        AppMethodBeat.i(406);
        boolean isSpringFestivalEnable = n.isSpringFestivalEnable();
        AppMethodBeat.o(406);
        return isSpringFestivalEnable;
    }

    @com.tencent.mm.remoteservice.f
    public final boolean getEnableAutoRotateRemote() {
        return com.tencent.mm.compatible.deviceinfo.ae.gKt.gGm;
    }

    @com.tencent.mm.remoteservice.f
    public final String getDeviceInfoConfigRemote() {
        AppMethodBeat.i(407);
        String gEu = g.aAh().azR().gEu();
        p.g(gEu, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
        AppMethodBeat.o(407);
        return gEu;
    }

    @com.tencent.mm.remoteservice.f
    public final Object getConfigStorage(int i2, Object obj) {
        AppMethodBeat.i(408);
        p.h(obj, "defval");
        ar.a[] aVarArr = (ar.a[]) ar.a.class.getEnumConstants();
        ar.a aVar = aVarArr != null ? aVarArr[i2] : null;
        Log.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", aVar, obj);
        Object obj2 = g.aAh().azQ().get(aVar, obj);
        AppMethodBeat.o(408);
        return obj2;
    }

    @com.tencent.mm.remoteservice.f
    public final int getUseGpuSegmentRemote() {
        int i2;
        AppMethodBeat.i(409);
        try {
            i2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_segment_gpu, 1);
        } catch (Exception e2) {
            i2 = 1;
        }
        AppMethodBeat.o(409);
        return i2;
    }

    public final void getLensList() {
        AppMethodBeat.i(410);
        REMOTE_CALL("getLensListRemote", new Object[0]);
        AppMethodBeat.o(410);
    }

    @com.tencent.mm.remoteservice.f
    public final void getLensListRemote() {
        AppMethodBeat.i(411);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(new com.tencent.mm.sticker.b.b());
        AppMethodBeat.o(411);
    }

    @Override // com.tencent.mm.remoteservice.a
    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(412);
        p.h(objArr, NativeProtocol.WEB_DIALOG_PARAMS);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (objArr[i2] instanceof Bundle) {
                String valueOf = String.valueOf(i2);
                Object obj = objArr[i2];
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type android.os.Bundle");
                    AppMethodBeat.o(412);
                    throw tVar;
                }
                bundle.putBundle(valueOf, (Bundle) obj);
            } else if (objArr[i2] instanceof Parcelable) {
                String valueOf2 = String.valueOf(i2);
                Object obj2 = objArr[i2];
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.os.Parcelable");
                    AppMethodBeat.o(412);
                    throw tVar2;
                }
                bundle.putParcelable(valueOf2, (Parcelable) obj2);
            } else if (objArr[i2] instanceof ar.a) {
                Object[] objArr2 = new Object[1];
                Object obj3 = objArr[i2];
                if (obj3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.o(412);
                    throw tVar3;
                }
                objArr2[0] = Integer.valueOf(((ar.a) obj3).ordinal());
                Log.i("MicroMsg.EmojiCaptureProxy", "objectsToBundle: %s", objArr2);
                String valueOf3 = String.valueOf(i2);
                Object obj4 = objArr[i2];
                if (obj4 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.o(412);
                    throw tVar4;
                }
                bundle.putInt(valueOf3, ((ar.a) obj4).ordinal());
            } else {
                String valueOf4 = String.valueOf(i2);
                Object obj5 = objArr[i2];
                if (obj5 == null) {
                    t tVar5 = new t("null cannot be cast to non-null type java.io.Serializable");
                    AppMethodBeat.o(412);
                    throw tVar5;
                }
                bundle.putSerializable(valueOf4, (Serializable) obj5);
            }
        }
        AppMethodBeat.o(412);
        return bundle;
    }

    @Override // com.tencent.mm.remoteservice.a, com.tencent.mm.remoteservice.b
    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(413);
        p.h(str, "methodName");
        p.h(bundle, "data");
        Log.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            Method[] methods = getClass().getMethods();
            p.g(methods, "this.javaClass.methods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                p.g(method2, "mth");
                if (kotlin.n.n.I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : com.tencent.mm.remoteservice.f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if (!p.j(method.getReturnType(), Void.TYPE)) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(this.RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.o(413);
                            return;
                        }
                        if (p.j("getConfigStorage", str)) {
                            Log.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable(this.RESULT_KEY, (Serializable) invoke);
                        AppMethodBeat.o(413);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.EmojiCaptureProxy", "exception:%s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(413);
    }
}
