package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class WebDialogParameters {
    public static Bundle create(AppGroupCreationContent appGroupCreationContent) {
        AppMethodBeat.i(8337);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        if (appGroupPrivacy != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, appGroupPrivacy.toString().toLowerCase(Locale.ENGLISH));
        }
        AppMethodBeat.o(8337);
        return bundle;
    }

    public static Bundle create(GameRequestContent gameRequestContent) {
        AppMethodBeat.i(8338);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        if (gameRequestContent.getActionType() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, gameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        if (gameRequestContent.getFilters() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_FILTERS, gameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        AppMethodBeat.o(8338);
        return bundle;
    }

    public static Bundle create(ShareLinkContent shareLinkContent) {
        AppMethodBeat.i(8339);
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility.putUri(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_HREF, shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        AppMethodBeat.o(8339);
        return createBaseParameters;
    }

    public static Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
        AppMethodBeat.i(8340);
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        try {
            JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent), false);
            if (removeNamespacesFromOGJsonObject != null) {
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_ACTION_PROPERTIES, removeNamespacesFromOGJsonObject.toString());
            }
            AppMethodBeat.o(8340);
            return createBaseParameters;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e2);
            AppMethodBeat.o(8340);
            throw facebookException;
        }
    }

    public static Bundle create(SharePhotoContent sharePhotoContent) {
        AppMethodBeat.i(8341);
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        String[] strArr = new String[sharePhotoContent.getPhotos().size()];
        Utility.map(sharePhotoContent.getPhotos(), new Utility.Mapper<SharePhoto, String>() {
            /* class com.facebook.share.internal.WebDialogParameters.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ String apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8336);
                String apply = apply(sharePhoto);
                AppMethodBeat.o(8336);
                return apply;
            }

            public final String apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8335);
                String uri = sharePhoto.getImageUrl().toString();
                AppMethodBeat.o(8335);
                return uri;
            }
        }).toArray(strArr);
        createBaseParameters.putStringArray("media", strArr);
        AppMethodBeat.o(8341);
        return createBaseParameters;
    }

    public static Bundle createBaseParameters(ShareContent shareContent) {
        AppMethodBeat.i(8342);
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag.getHashtag());
        }
        AppMethodBeat.o(8342);
        return bundle;
    }

    public static Bundle createForFeed(ShareLinkContent shareLinkContent) {
        AppMethodBeat.i(8343);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundle, "description", shareLinkContent.getContentDescription());
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, "picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        if (shareLinkContent.getShareHashtag() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareLinkContent.getShareHashtag().getHashtag());
        }
        AppMethodBeat.o(8343);
        return bundle;
    }

    public static Bundle createForFeed(ShareFeedContent shareFeedContent) {
        AppMethodBeat.i(8344);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        AppMethodBeat.o(8344);
        return bundle;
    }
}
