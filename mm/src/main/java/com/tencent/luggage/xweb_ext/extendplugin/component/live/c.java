package com.tencent.luggage.xweb_ext.extendplugin.component.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static Bundle g(JSONObject jSONObject) {
        AppMethodBeat.i(138811);
        new StringBuilder("LivePlayer params:").append(jSONObject != null ? jSONObject.toString() : "");
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
            }
        } catch (JSONException e2) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "playUrl", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "mode", e3.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "autoplay", e4.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e5) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "muted", e5.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muteAudio")) {
                bundle.putBoolean("muteAudio", jSONObject.getBoolean("muteAudio"));
            }
        } catch (JSONException e6) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "muteAudio", e6.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muteVideo")) {
                bundle.putBoolean("muteVideo", jSONObject.getBoolean("muteVideo"));
            }
        } catch (JSONException e7) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "muteVideo", e7.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e8) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "orientation", e8.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e9) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "objectFit", e9.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e10) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "backgroundMute", e10.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.getDouble("minCache")).floatValue());
            }
        } catch (JSONException e11) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "minCache", e11.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxCache")) {
                bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.getDouble("maxCache")).floatValue());
            }
        } catch (JSONException e12) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "maxCache", e12.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableRecvMessage")) {
                bundle.putBoolean("enableRecvMessage", jSONObject.getBoolean("enableRecvMessage"));
            }
        } catch (JSONException e13) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "enableRecvMessage", e13.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e14) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "needEvent", e14.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needAudioVolume")) {
                bundle.putBoolean("needAudioVolume", jSONObject.getBoolean("needAudioVolume"));
            }
        } catch (JSONException e15) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "needAudioVolume", e15.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e16) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "debug", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
            }
        } catch (JSONException e17) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "soundMode", e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                bundle.putBoolean("autoPauseIfNavigate", jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e18) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "autoPauseIfNavigate", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                bundle.putBoolean("autoPauseIfOpenNative", jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e19) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "autoPauseIfOpenNative", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("referrer")) {
                bundle.putString("referrer", jSONObject.getString("referrer"));
            }
        } catch (JSONException e20) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "referrer", e20.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("canStartPlay")) {
                bundle.putBoolean("canStartPlay", jSONObject.getBoolean("canStartPlay"));
            }
        } catch (JSONException e21) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "canStartPlay", e21.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("isVoip")) {
                bundle.putBoolean("isVoip", jSONObject.getBoolean("isVoip"));
            }
        } catch (JSONException e22) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", "isVoip", e22.getLocalizedMessage());
        }
        AppMethodBeat.o(138811);
        return bundle;
    }

    public static Bundle h(JSONObject jSONObject) {
        AppMethodBeat.i(138812);
        new StringBuilder("LivePusher params:").append(jSONObject != null ? jSONObject.toString() : "");
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("pushUrl")) {
                bundle.putString("pushUrl", jSONObject.getString("pushUrl"));
            }
        } catch (JSONException e2) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "pushUrl", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "mode", e3.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autopush")) {
                bundle.putBoolean("autopush", jSONObject.getBoolean("autopush"));
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "autopush", e4.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioQuality")) {
                bundle.putString("audioQuality", jSONObject.getString("audioQuality"));
            }
        } catch (JSONException e5) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "audioQuality", e5.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e6) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "muted", e6.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableCamera")) {
                bundle.putBoolean("enableCamera", jSONObject.getBoolean("enableCamera"));
            }
        } catch (JSONException e7) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "enableCamera", e7.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableMic")) {
                bundle.putBoolean("enableMic", jSONObject.getBoolean("enableMic"));
            }
        } catch (JSONException e8) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "enableMic", e8.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableAGC")) {
                bundle.putBoolean("enableAGC", jSONObject.getBoolean("enableAGC"));
            }
        } catch (JSONException e9) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "enableAGC", e9.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableANS")) {
                bundle.putBoolean("enableANS", jSONObject.getBoolean("enableANS"));
            }
        } catch (JSONException e10) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "enableANS", e10.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableEarMonitor")) {
                bundle.putBoolean("enableEarMonitor", jSONObject.getBoolean("enableEarMonitor"));
            }
        } catch (JSONException e11) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "enableEarMonitor", e11.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioVolumeType")) {
                bundle.putString("audioVolumeType", jSONObject.getString("audioVolumeType"));
            }
        } catch (JSONException e12) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "audioVolumeType", e12.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioReverbType")) {
                bundle.putInt("audioReverbType", jSONObject.getInt("audioReverbType"));
            }
        } catch (JSONException e13) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "audioReverbType", e13.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("videoWidth")) {
                bundle.putInt("videoWidth", jSONObject.getInt("videoWidth"));
            }
        } catch (JSONException e14) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "videoWidth", e14.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("videoHeight")) {
                bundle.putInt("videoHeight", jSONObject.getInt("videoHeight"));
            }
        } catch (JSONException e15) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "videoHeight", e15.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("focusMode")) {
                bundle.putInt("focusMode", jSONObject.getInt("focusMode"));
            }
        } catch (JSONException e16) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "focusMode", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e17) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "orientation", e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("beauty")) {
                bundle.putInt("beauty", jSONObject.getInt("beauty"));
            }
        } catch (JSONException e18) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "beauty", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("beautyStyle")) {
                bundle.putString("beautyStyle", jSONObject.getString("beautyStyle"));
            }
        } catch (JSONException e19) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "beautyStyle", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("filterImage")) {
                bundle.putString("filterImage", jSONObject.getString("filterImage"));
            }
        } catch (JSONException e20) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "filterImage", e20.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("filterImageMd5")) {
                bundle.putString("filterImageMd5", jSONObject.getString("filterImageMd5"));
            }
        } catch (JSONException e21) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "filterImageMd5", e21.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("whiteness")) {
                bundle.putInt("whiteness", jSONObject.getInt("whiteness"));
            }
        } catch (JSONException e22) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "whiteness", e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("aspect")) {
                bundle.putInt("aspect", jSONObject.getInt("aspect"));
            }
        } catch (JSONException e23) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "aspect", e23.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minBitrate")) {
                bundle.putInt("minBitrate", jSONObject.getInt("minBitrate"));
            }
        } catch (JSONException e24) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "minBitrate", e24.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxBitrate")) {
                bundle.putInt("maxBitrate", jSONObject.getInt("maxBitrate"));
            }
        } catch (JSONException e25) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "maxBitrate", e25.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e26) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "backgroundMute", e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("zoom")) {
                bundle.putBoolean("zoom", jSONObject.getBoolean("zoom"));
            }
        } catch (JSONException e27) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "zoom", e27.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e28) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "needEvent", e28.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e29) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "debug", e29.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mirror")) {
                bundle.putBoolean("mirror", jSONObject.getBoolean("mirror"));
            }
        } catch (JSONException e30) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "mirror", e30.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("remoteMirror")) {
                bundle.putBoolean("remoteMirror", jSONObject.getBoolean("remoteMirror"));
            }
        } catch (JSONException e31) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "remoteMirror", e31.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("localMirror")) {
                bundle.putString("localMirror", jSONObject.getString("localMirror"));
            }
        } catch (JSONException e32) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "localMirror", e32.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkLeft")) {
                bundle.putFloat("watermarkLeft", BigDecimal.valueOf(jSONObject.getDouble("watermarkLeft")).floatValue());
            }
        } catch (JSONException e33) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "watermarkLeft", e33.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkTop")) {
                bundle.putFloat("watermarkTop", BigDecimal.valueOf(jSONObject.getDouble("watermarkTop")).floatValue());
            }
        } catch (JSONException e34) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "watermarkTop", e34.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkWidth")) {
                bundle.putFloat("watermarkWidth", BigDecimal.valueOf(jSONObject.getDouble("watermarkWidth")).floatValue());
            }
        } catch (JSONException e35) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "watermarkWidth", e35.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("devicePosition")) {
                bundle.putString("devicePosition", jSONObject.getString("devicePosition"));
            }
        } catch (JSONException e36) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "devicePosition", e36.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needBGMEvent")) {
                bundle.putBoolean("needBGMEvent", jSONObject.getBoolean("needBGMEvent"));
            }
        } catch (JSONException e37) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "needBGMEvent", e37.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needAudioVolume")) {
                bundle.putBoolean("needAudioVolume", jSONObject.getBoolean("needAudioVolume"));
            }
        } catch (JSONException e38) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "needAudioVolume", e38.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("customEffect")) {
                bundle.putBoolean("customEffect", jSONObject.getBoolean("customEffect"));
            }
        } catch (JSONException e39) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "customEffect", e39.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("skinWhiteness")) {
                bundle.putFloat("skinWhiteness", BigDecimal.valueOf(jSONObject.getDouble("skinWhiteness")).floatValue());
            }
        } catch (JSONException e40) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "skinWhiteness", e40.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("skinSmoothness")) {
                bundle.putFloat("skinSmoothness", BigDecimal.valueOf(jSONObject.getDouble("skinSmoothness")).floatValue());
            }
        } catch (JSONException e41) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "skinSmoothness", e41.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("faceThinness")) {
                bundle.putFloat("faceThinness", BigDecimal.valueOf(jSONObject.getDouble("faceThinness")).floatValue());
            }
        } catch (JSONException e42) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "faceThinness", e42.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("eyeBigness")) {
                bundle.putFloat("eyeBigness", BigDecimal.valueOf(jSONObject.getDouble("eyeBigness")).floatValue());
            }
        } catch (JSONException e43) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "eyeBigness", e43.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("isVoip")) {
                bundle.putBoolean("isVoip", jSONObject.getBoolean("isVoip"));
            }
        } catch (JSONException e44) {
            Log.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", "isVoip", e44.getLocalizedMessage());
        }
        AppMethodBeat.o(138812);
        return bundle;
    }
}
