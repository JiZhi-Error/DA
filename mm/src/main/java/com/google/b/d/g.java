package com.google.b.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.wxmm.v2helper;

public final class g extends n {
    private static final char[] cea = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final int[] ceb;
    private static final int cen;

    static {
        AppMethodBeat.i(12286);
        int[] iArr = {276, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, aq.CTRL_INDEX, TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02, 296, l.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, 336, a.C0693a.CTRL_INDEX, 266, v2helper.EMethodSetSpkEnhance, v2helper.EMethodSetPlayerPreCorrectCofOn, 418, 404, 402, 394, v2helper.VOIP_ENC_HEIGHT_LV1, 356, f.CTRL_INDEX, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL, 282, 344, TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE, TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL, 300, 278, i.CTRL_INDEX, 434, v2helper.EMethodSetIosMicAbCheckOn, v2helper.EMethodOutputVolumeGainEnable, 406, 410, 364, d.CTRL_INDEX, TPNativePlayerInitConfig.INT_PIXEL_FORMAT, 314, 302, a.C0672a.CTRL_INDEX, bg.CTRL_INDEX, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, ADXml.AD_TURN_CARD_ANIMATION_TIME, 430, 294, JsApiAddDownloadTask.CTRL_INDEX, 470, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 350};
        ceb = iArr;
        cen = iArr[47];
        AppMethodBeat.o(12286);
    }
}
