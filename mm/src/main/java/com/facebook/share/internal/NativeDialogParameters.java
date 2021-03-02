package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeDialogParameters {
    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        AppMethodBeat.i(8171);
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        Bundle bundle = null;
        if (shareContent instanceof ShareLinkContent) {
            bundle = create((ShareLinkContent) shareContent, z);
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            bundle = create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            bundle = create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                bundle = create(shareOpenGraphContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e2) {
                FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
                AppMethodBeat.o(8171);
                throw facebookException;
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            bundle = create(shareMediaContent, ShareInternalUtility.getMediaInfos(shareMediaContent, uuid), z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            bundle = create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid), z);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            bundle = create((ShareMessengerGenericTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            bundle = create((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            bundle = create((ShareMessengerMediaTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareStoryContent) {
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            bundle = create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid), ShareInternalUtility.getStickerUrl(shareStoryContent, uuid), z);
        }
        AppMethodBeat.o(8171);
        return bundle;
    }

    private static Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        AppMethodBeat.i(8172);
        Bundle createBaseParameters = createBaseParameters(shareCameraEffectContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            createBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            JSONObject convertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (convertToJSON != null) {
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ARGS, convertToJSON.toString());
            }
            AppMethodBeat.o(8172);
            return createBaseParameters;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e2.getMessage());
            AppMethodBeat.o(8172);
            throw facebookException;
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        AppMethodBeat.i(8173);
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(createBaseParameters, ShareConstants.IMAGE_URL, shareLinkContent.getImageUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(createBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(createBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        AppMethodBeat.o(8173);
        return createBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        AppMethodBeat.i(8174);
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList<>(list));
        AppMethodBeat.o(8174);
        return createBaseParameters;
    }

    private static Bundle create(ShareVideoContent shareVideoContent, String str, boolean z) {
        AppMethodBeat.i(8175);
        Bundle createBaseParameters = createBaseParameters(shareVideoContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.VIDEO_URL, str);
        AppMethodBeat.o(8175);
        return createBaseParameters;
    }

    private static Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        AppMethodBeat.i(8176);
        Bundle createBaseParameters = createBaseParameters(shareMediaContent, z);
        createBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList<>(list));
        AppMethodBeat.o(8176);
        return createBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(8177);
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.PREVIEW_PROPERTY_NAME, (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(shareOpenGraphContent.getPreviewPropertyName()).second);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION, jSONObject.toString());
        AppMethodBeat.o(8177);
        return createBaseParameters;
    }

    private static Bundle create(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z) {
        AppMethodBeat.i(8178);
        Bundle createBaseParameters = createBaseParameters(shareMessengerGenericTemplateContent, z);
        try {
            MessengerShareContentUtility.addGenericTemplateContent(createBaseParameters, shareMessengerGenericTemplateContent);
            AppMethodBeat.o(8178);
            return createBaseParameters;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e2.getMessage());
            AppMethodBeat.o(8178);
            throw facebookException;
        }
    }

    private static Bundle create(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z) {
        AppMethodBeat.i(8179);
        Bundle createBaseParameters = createBaseParameters(shareMessengerOpenGraphMusicTemplateContent, z);
        try {
            MessengerShareContentUtility.addOpenGraphMusicTemplateContent(createBaseParameters, shareMessengerOpenGraphMusicTemplateContent);
            AppMethodBeat.o(8179);
            return createBaseParameters;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e2.getMessage());
            AppMethodBeat.o(8179);
            throw facebookException;
        }
    }

    private static Bundle create(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z) {
        AppMethodBeat.i(8180);
        Bundle createBaseParameters = createBaseParameters(shareMessengerMediaTemplateContent, z);
        try {
            MessengerShareContentUtility.addMediaTemplateContent(createBaseParameters, shareMessengerMediaTemplateContent);
            AppMethodBeat.o(8180);
            return createBaseParameters;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e2.getMessage());
            AppMethodBeat.o(8180);
            throw facebookException;
        }
    }

    private static Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z) {
        AppMethodBeat.i(8181);
        Bundle createBaseParameters = createBaseParameters(shareStoryContent, z);
        if (bundle != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (!Utility.isNullOrEmpty(backgroundColorList)) {
            createBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList<>(backgroundColorList));
        }
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        AppMethodBeat.o(8181);
        return createBaseParameters;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z) {
        AppMethodBeat.i(8182);
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList<>(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag.getHashtag());
        }
        AppMethodBeat.o(8182);
        return bundle;
    }
}
