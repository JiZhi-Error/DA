package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

public final class g implements ITPMediaDRMAsset {
    private Map<String, String> RYY = new HashMap();
    private int mDrmType;
    private String mPlayUrl;

    public g(int i2, String str) {
        AppMethodBeat.i(189139);
        this.mPlayUrl = str;
        this.mDrmType = i2;
        AppMethodBeat.o(189139);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final void setDrmProperty(String str, String str2) {
        AppMethodBeat.i(189140);
        this.RYY.put(str, str2);
        AppMethodBeat.o(189140);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final String getDrmProperty(String str, String str2) {
        AppMethodBeat.i(189141);
        if (this.RYY == null || this.RYY.isEmpty()) {
            AppMethodBeat.o(189141);
            return str2;
        }
        String str3 = this.RYY.get(str);
        if (str3 == null) {
            AppMethodBeat.o(189141);
            return str2;
        }
        AppMethodBeat.o(189141);
        return str3;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final Map<String, String> getDrmAllProperties() {
        return this.RYY;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final void setDrmPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final String getDrmPlayUrl() {
        return this.mPlayUrl;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final void setDrmType(int i2) {
        this.mDrmType = i2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public final int getDrmType() {
        return this.mDrmType;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final String getUrl() {
        int i2 = 0;
        AppMethodBeat.i(189142);
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
            newSerializer.startTag("", "assets");
            newSerializer.startTag("", "av_tracks");
            newSerializer.startTag("", "av_track");
            newSerializer.startTag("", "track_clip");
            newSerializer.startTag("", "clip_id");
            newSerializer.text(Integer.toString(0));
            newSerializer.endTag("", "clip_id");
            newSerializer.startTag("", "clip_placeHolder");
            newSerializer.text(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            newSerializer.endTag("", "clip_placeHolder");
            newSerializer.startTag("", "clip_path");
            newSerializer.text(getDrmPlayUrl());
            newSerializer.endTag("", "clip_path");
            newSerializer.startTag("", "clip_drmType");
            int drmType = getDrmType();
            if (drmType != 0) {
                if (1 == drmType) {
                    i2 = 1;
                } else if (2 == drmType) {
                    i2 = 2;
                } else if (3 == drmType) {
                    i2 = 3;
                } else {
                    i2 = drmType;
                }
            }
            newSerializer.text(String.valueOf(i2));
            newSerializer.endTag("", "clip_drmType");
            newSerializer.startTag("", "clip_drmProvisionUrl");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PROVISION_URL, ""));
            newSerializer.endTag("", "clip_drmProvisionUrl");
            newSerializer.startTag("", "clip_drmLicenseUrl");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, ""));
            newSerializer.endTag("", "clip_drmLicenseUrl");
            newSerializer.startTag("", "clip_drmUseL1");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_DRM_USEL1, "1"));
            newSerializer.endTag("", "clip_drmUseL1");
            newSerializer.startTag("", "clip_drmSavePath");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_SAVE_PATH, ""));
            newSerializer.endTag("", "clip_drmSavePath");
            newSerializer.startTag("", "clip_drmGuid");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_GUID, ""));
            newSerializer.endTag("", "clip_drmGuid");
            newSerializer.startTag("", "clip_drmPlatform");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PLATFORM, ""));
            newSerializer.endTag("", "clip_drmPlatform");
            newSerializer.startTag("", "clip_drmAppVersion");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_APPVER, ""));
            newSerializer.endTag("", "clip_drmAppVersion");
            newSerializer.startTag("", "clip_drmCookie");
            newSerializer.text(getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_COOKIE, ""));
            newSerializer.endTag("", "clip_drmCookie");
            newSerializer.endTag("", "track_clip");
            newSerializer.endTag("", "av_track");
            newSerializer.endTag("", "av_tracks");
            newSerializer.endTag("", "assets");
            newSerializer.endDocument();
            String stringWriter2 = stringWriter.toString();
            AppMethodBeat.o(189142);
            return stringWriter2;
        } catch (IOException e2) {
            com.tencent.thumbplayer.utils.g.e("TPMediaDRMAsset", e2);
            AppMethodBeat.o(189142);
            return "";
        }
    }
}
