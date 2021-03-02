package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyNativeDialogParameters {
    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        AppMethodBeat.i(7999);
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        Bundle bundle = null;
        if (shareContent instanceof ShareLinkContent) {
            bundle = create((ShareLinkContent) shareContent, z);
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            bundle = create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            bundle = create((ShareVideoContent) shareContent, z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                bundle = create(shareOpenGraphContent, ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), z);
            } catch (JSONException e2) {
                FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
                AppMethodBeat.o(7999);
                throw facebookException;
            }
        }
        AppMethodBeat.o(7999);
        return bundle;
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(createBaseParameters, ShareConstants.LEGACY_IMAGE, shareLinkContent.getImageUrl());
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        return createBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        AppMethodBeat.i(TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC);
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList<>(list));
        AppMethodBeat.o(TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC);
        return createBaseParameters;
    }

    private static Bundle create(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(TXLiteAVCode.EVT_ROOM_CONNECT_SUCC);
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_PREVIEW_PROPERTY_NAME, shareOpenGraphContent.getPreviewPropertyName());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION, jSONObject.toString());
        AppMethodBeat.o(TXLiteAVCode.EVT_ROOM_CONNECT_SUCC);
        return createBaseParameters;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z) {
        AppMethodBeat.i(TXLiteAVCode.EVT_ROOM_REQUEST_AVSEAT_SUCC);
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList<>(peopleIds));
        }
        AppMethodBeat.o(TXLiteAVCode.EVT_ROOM_REQUEST_AVSEAT_SUCC);
        return bundle;
    }
}
