package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Locale;

public class ShareContentValidation {
    private static Validator ApiValidator;
    private static Validator DefaultValidator;
    private static Validator StoryValidator;
    private static Validator WebShareValidator;

    static /* synthetic */ void access$1000(ShareMediaContent shareMediaContent, Validator validator) {
        AppMethodBeat.i(8253);
        validateMediaContent(shareMediaContent, validator);
        AppMethodBeat.o(8253);
    }

    static /* synthetic */ void access$1100(ShareCameraEffectContent shareCameraEffectContent, Validator validator) {
        AppMethodBeat.i(8254);
        validateCameraEffectContent(shareCameraEffectContent, validator);
        AppMethodBeat.o(8254);
    }

    static /* synthetic */ void access$1200(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        AppMethodBeat.i(8255);
        validateOpenGraphContent(shareOpenGraphContent, validator);
        AppMethodBeat.o(8255);
    }

    static /* synthetic */ void access$1300(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        AppMethodBeat.i(8256);
        validateOpenGraphAction(shareOpenGraphAction, validator);
        AppMethodBeat.o(8256);
    }

    static /* synthetic */ void access$1400(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        AppMethodBeat.i(8257);
        validateOpenGraphObject(shareOpenGraphObject, validator);
        AppMethodBeat.o(8257);
    }

    static /* synthetic */ void access$1500(ShareOpenGraphValueContainer shareOpenGraphValueContainer, Validator validator, boolean z) {
        AppMethodBeat.i(8258);
        validateOpenGraphValueContainer(shareOpenGraphValueContainer, validator, z);
        AppMethodBeat.o(8258);
    }

    static /* synthetic */ void access$1600(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8259);
        validatePhotoForNativeDialog(sharePhoto, validator);
        AppMethodBeat.o(8259);
    }

    static /* synthetic */ void access$1700(ShareVideo shareVideo, Validator validator) {
        AppMethodBeat.i(8260);
        validateVideo(shareVideo, validator);
        AppMethodBeat.o(8260);
    }

    static /* synthetic */ void access$1800(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8261);
        validateMessengerOpenGraphMusicTemplate(shareMessengerOpenGraphMusicTemplateContent);
        AppMethodBeat.o(8261);
    }

    static /* synthetic */ void access$1900(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.i(8262);
        validateShareMessengerGenericTemplateContent(shareMessengerGenericTemplateContent);
        AppMethodBeat.o(8262);
    }

    static /* synthetic */ void access$2000(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8263);
        validateShareMessengerMediaTemplateContent(shareMessengerMediaTemplateContent);
        AppMethodBeat.o(8263);
    }

    static /* synthetic */ void access$400(ShareStoryContent shareStoryContent, Validator validator) {
        AppMethodBeat.i(8247);
        validateStoryContent(shareStoryContent, validator);
        AppMethodBeat.o(8247);
    }

    static /* synthetic */ void access$500(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8248);
        validatePhotoForWebDialog(sharePhoto, validator);
        AppMethodBeat.o(8248);
    }

    static /* synthetic */ void access$600(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8249);
        validatePhotoForApi(sharePhoto, validator);
        AppMethodBeat.o(8249);
    }

    static /* synthetic */ void access$700(ShareLinkContent shareLinkContent, Validator validator) {
        AppMethodBeat.i(8250);
        validateLinkContent(shareLinkContent, validator);
        AppMethodBeat.o(8250);
    }

    static /* synthetic */ void access$800(SharePhotoContent sharePhotoContent, Validator validator) {
        AppMethodBeat.i(8251);
        validatePhotoContent(sharePhotoContent, validator);
        AppMethodBeat.o(8251);
    }

    static /* synthetic */ void access$900(ShareVideoContent shareVideoContent, Validator validator) {
        AppMethodBeat.i(8252);
        validateVideoContent(shareVideoContent, validator);
        AppMethodBeat.o(8252);
    }

    public static void validateForMessage(ShareContent shareContent) {
        AppMethodBeat.i(8214);
        validate(shareContent, getDefaultValidator());
        AppMethodBeat.o(8214);
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        AppMethodBeat.i(8215);
        validate(shareContent, getDefaultValidator());
        AppMethodBeat.o(8215);
    }

    public static void validateForWebShare(ShareContent shareContent) {
        AppMethodBeat.i(8216);
        validate(shareContent, getWebShareValidator());
        AppMethodBeat.o(8216);
    }

    public static void validateForApiShare(ShareContent shareContent) {
        AppMethodBeat.i(8217);
        validate(shareContent, getApiValidator());
        AppMethodBeat.o(8217);
    }

    public static void validateForStoryShare(ShareContent shareContent) {
        AppMethodBeat.i(8218);
        validate(shareContent, getStoryValidator());
        AppMethodBeat.o(8218);
    }

    private static Validator getStoryValidator() {
        AppMethodBeat.i(8219);
        if (StoryValidator == null) {
            StoryValidator = new StoryShareValidator();
        }
        Validator validator = StoryValidator;
        AppMethodBeat.o(8219);
        return validator;
    }

    private static Validator getDefaultValidator() {
        AppMethodBeat.i(8220);
        if (DefaultValidator == null) {
            DefaultValidator = new Validator();
        }
        Validator validator = DefaultValidator;
        AppMethodBeat.o(8220);
        return validator;
    }

    private static Validator getApiValidator() {
        AppMethodBeat.i(8221);
        if (ApiValidator == null) {
            ApiValidator = new ApiValidator();
        }
        Validator validator = ApiValidator;
        AppMethodBeat.o(8221);
        return validator;
    }

    private static Validator getWebShareValidator() {
        AppMethodBeat.i(8222);
        if (WebShareValidator == null) {
            WebShareValidator = new WebShareValidator();
        }
        Validator validator = WebShareValidator;
        AppMethodBeat.o(8222);
        return validator;
    }

    private static void validate(ShareContent shareContent, Validator validator) {
        AppMethodBeat.i(8223);
        if (shareContent == null) {
            FacebookException facebookException = new FacebookException("Must provide non-null content to share");
            AppMethodBeat.o(8223);
            throw facebookException;
        } else if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            validator.validate((ShareOpenGraphContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            validator.validate((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            validator.validate((ShareMessengerMediaTemplateContent) shareContent);
            AppMethodBeat.o(8223);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            validator.validate((ShareMessengerGenericTemplateContent) shareContent);
            AppMethodBeat.o(8223);
        } else {
            if (shareContent instanceof ShareStoryContent) {
                validator.validate((ShareStoryContent) shareContent);
            }
            AppMethodBeat.o(8223);
        }
    }

    private static void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        AppMethodBeat.i(8224);
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            FacebookException facebookException = new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
            AppMethodBeat.o(8224);
            throw facebookException;
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
        AppMethodBeat.o(8224);
    }

    private static void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        AppMethodBeat.i(8225);
        Uri imageUrl = shareLinkContent.getImageUrl();
        if (imageUrl == null || Utility.isWebUri(imageUrl)) {
            AppMethodBeat.o(8225);
            return;
        }
        FacebookException facebookException = new FacebookException("Image Url must be an http:// or https:// url");
        AppMethodBeat.o(8225);
        throw facebookException;
    }

    private static void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        AppMethodBeat.i(8226);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            FacebookException facebookException = new FacebookException("Must specify at least one Photo in SharePhotoContent.");
            AppMethodBeat.o(8226);
            throw facebookException;
        } else if (photos.size() > 6) {
            FacebookException facebookException2 = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
            AppMethodBeat.o(8226);
            throw facebookException2;
        } else {
            for (SharePhoto sharePhoto : photos) {
                validator.validate(sharePhoto);
            }
            AppMethodBeat.o(8226);
        }
    }

    private static void validatePhoto(SharePhoto sharePhoto) {
        AppMethodBeat.i(8227);
        if (sharePhoto == null) {
            FacebookException facebookException = new FacebookException("Cannot share a null SharePhoto");
            AppMethodBeat.o(8227);
            throw facebookException;
        }
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            FacebookException facebookException2 = new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            AppMethodBeat.o(8227);
            throw facebookException2;
        }
        AppMethodBeat.o(8227);
    }

    private static void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8228);
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap != null || !Utility.isWebUri(imageUrl) || validator.isOpenGraphContent()) {
            AppMethodBeat.o(8228);
            return;
        }
        FacebookException facebookException = new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        AppMethodBeat.o(8228);
        throw facebookException;
    }

    private static void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8229);
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() != null || !Utility.isWebUri(sharePhoto.getImageUrl())) {
            Validate.hasContentProvider(FacebookSdk.getApplicationContext());
        }
        AppMethodBeat.o(8229);
    }

    private static void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.i(8230);
        validatePhoto(sharePhoto);
        AppMethodBeat.o(8230);
    }

    private static void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        AppMethodBeat.i(8231);
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
        AppMethodBeat.o(8231);
    }

    private static void validateVideo(ShareVideo shareVideo, Validator validator) {
        AppMethodBeat.i(8232);
        if (shareVideo == null) {
            FacebookException facebookException = new FacebookException("Cannot share a null ShareVideo");
            AppMethodBeat.o(8232);
            throw facebookException;
        }
        Uri localUrl = shareVideo.getLocalUrl();
        if (localUrl == null) {
            FacebookException facebookException2 = new FacebookException("ShareVideo does not have a LocalUrl specified");
            AppMethodBeat.o(8232);
            throw facebookException2;
        } else if (Utility.isContentUri(localUrl) || Utility.isFileUri(localUrl)) {
            AppMethodBeat.o(8232);
        } else {
            FacebookException facebookException3 = new FacebookException("ShareVideo must reference a video that is on the device");
            AppMethodBeat.o(8232);
            throw facebookException3;
        }
    }

    private static void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        AppMethodBeat.i(8233);
        List<ShareMedia> media = shareMediaContent.getMedia();
        if (media == null || media.isEmpty()) {
            FacebookException facebookException = new FacebookException("Must specify at least one medium in ShareMediaContent.");
            AppMethodBeat.o(8233);
            throw facebookException;
        } else if (media.size() > 6) {
            FacebookException facebookException2 = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
            AppMethodBeat.o(8233);
            throw facebookException2;
        } else {
            for (ShareMedia shareMedia : media) {
                validator.validate(shareMedia);
            }
            AppMethodBeat.o(8233);
        }
    }

    public static void validateMedium(ShareMedia shareMedia, Validator validator) {
        AppMethodBeat.i(8234);
        if (shareMedia instanceof SharePhoto) {
            validator.validate((SharePhoto) shareMedia);
            AppMethodBeat.o(8234);
        } else if (shareMedia instanceof ShareVideo) {
            validator.validate((ShareVideo) shareMedia);
            AppMethodBeat.o(8234);
        } else {
            FacebookException facebookException = new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
            AppMethodBeat.o(8234);
            throw facebookException;
        }
    }

    private static void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent, Validator validator) {
        AppMethodBeat.i(8235);
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId())) {
            FacebookException facebookException = new FacebookException("Must specify a non-empty effectId");
            AppMethodBeat.o(8235);
            throw facebookException;
        }
        AppMethodBeat.o(8235);
    }

    private static void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        AppMethodBeat.i(8236);
        validator.validate(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        if (Utility.isNullOrEmpty(previewPropertyName)) {
            FacebookException facebookException = new FacebookException("Must specify a previewPropertyName.");
            AppMethodBeat.o(8236);
            throw facebookException;
        } else if (shareOpenGraphContent.getAction().get(previewPropertyName) == null) {
            FacebookException facebookException2 = new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. The name of the preview property must match the name of an action property.");
            AppMethodBeat.o(8236);
            throw facebookException2;
        } else {
            AppMethodBeat.o(8236);
        }
    }

    private static void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        AppMethodBeat.i(8237);
        if (shareOpenGraphAction == null) {
            FacebookException facebookException = new FacebookException("Must specify a non-null ShareOpenGraphAction");
            AppMethodBeat.o(8237);
            throw facebookException;
        } else if (Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
            FacebookException facebookException2 = new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
            AppMethodBeat.o(8237);
            throw facebookException2;
        } else {
            validator.validate(shareOpenGraphAction, false);
            AppMethodBeat.o(8237);
        }
    }

    private static void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        AppMethodBeat.i(8238);
        if (shareOpenGraphObject == null) {
            FacebookException facebookException = new FacebookException("Cannot share a null ShareOpenGraphObject");
            AppMethodBeat.o(8238);
            throw facebookException;
        }
        validator.validate(shareOpenGraphObject, true);
        AppMethodBeat.o(8238);
    }

    private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer shareOpenGraphValueContainer, Validator validator, boolean z) {
        AppMethodBeat.i(8239);
        for (String str : shareOpenGraphValueContainer.keySet()) {
            validateOpenGraphKey(str, z);
            Object obj = shareOpenGraphValueContainer.get(str);
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 == null) {
                        FacebookException facebookException = new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                        AppMethodBeat.o(8239);
                        throw facebookException;
                    }
                    validateOpenGraphValueContainerObject(obj2, validator);
                }
                continue;
            } else {
                validateOpenGraphValueContainerObject(obj, validator);
            }
        }
        AppMethodBeat.o(8239);
    }

    private static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8240);
        if (Utility.isNullOrEmpty(shareMessengerOpenGraphMusicTemplateContent.getPageId())) {
            FacebookException facebookException = new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
            AppMethodBeat.o(8240);
            throw facebookException;
        } else if (shareMessengerOpenGraphMusicTemplateContent.getUrl() == null) {
            FacebookException facebookException2 = new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
            AppMethodBeat.o(8240);
            throw facebookException2;
        } else {
            validateShareMessengerActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
            AppMethodBeat.o(8240);
        }
    }

    private static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.i(8241);
        if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getPageId())) {
            FacebookException facebookException = new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
            AppMethodBeat.o(8241);
            throw facebookException;
        } else if (shareMessengerGenericTemplateContent.getGenericTemplateElement() == null) {
            FacebookException facebookException2 = new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
            AppMethodBeat.o(8241);
            throw facebookException2;
        } else if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle())) {
            FacebookException facebookException3 = new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
            AppMethodBeat.o(8241);
            throw facebookException3;
        } else {
            validateShareMessengerActionButton(shareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
            AppMethodBeat.o(8241);
        }
    }

    private static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8242);
        if (Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getPageId())) {
            FacebookException facebookException = new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
            AppMethodBeat.o(8242);
            throw facebookException;
        } else if (shareMessengerMediaTemplateContent.getMediaUrl() != null || !Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getAttachmentId())) {
            validateShareMessengerActionButton(shareMessengerMediaTemplateContent.getButton());
            AppMethodBeat.o(8242);
        } else {
            FacebookException facebookException2 = new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            AppMethodBeat.o(8242);
            throw facebookException2;
        }
    }

    private static void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        AppMethodBeat.i(8243);
        if (shareMessengerActionButton == null) {
            AppMethodBeat.o(8243);
        } else if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            FacebookException facebookException = new FacebookException("Must specify title for ShareMessengerActionButton");
            AppMethodBeat.o(8243);
            throw facebookException;
        } else {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
            }
            AppMethodBeat.o(8243);
        }
    }

    private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        AppMethodBeat.i(8244);
        if (shareMessengerURLActionButton.getUrl() == null) {
            FacebookException facebookException = new FacebookException("Must specify url for ShareMessengerURLActionButton");
            AppMethodBeat.o(8244);
            throw facebookException;
        }
        AppMethodBeat.o(8244);
    }

    private static void validateOpenGraphKey(String str, boolean z) {
        AppMethodBeat.i(8245);
        if (!z) {
            AppMethodBeat.o(8245);
            return;
        }
        String[] split = str.split(":");
        if (split.length < 2) {
            FacebookException facebookException = new FacebookException("Open Graph keys must be namespaced: %s", str);
            AppMethodBeat.o(8245);
            throw facebookException;
        }
        for (String str2 : split) {
            if (str2.isEmpty()) {
                FacebookException facebookException2 = new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                AppMethodBeat.o(8245);
                throw facebookException2;
            }
        }
        AppMethodBeat.o(8245);
    }

    private static void validateOpenGraphValueContainerObject(Object obj, Validator validator) {
        AppMethodBeat.i(8246);
        if (obj instanceof ShareOpenGraphObject) {
            validator.validate((ShareOpenGraphObject) obj);
            AppMethodBeat.o(8246);
            return;
        }
        if (obj instanceof SharePhoto) {
            validator.validate((SharePhoto) obj);
        }
        AppMethodBeat.o(8246);
    }

    /* access modifiers changed from: package-private */
    public static class StoryShareValidator extends Validator {
        private StoryShareValidator() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareStoryContent shareStoryContent) {
            AppMethodBeat.i(8194);
            ShareContentValidation.access$400(shareStoryContent, this);
            AppMethodBeat.o(8194);
        }
    }

    /* access modifiers changed from: package-private */
    public static class WebShareValidator extends Validator {
        private WebShareValidator() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.i(8211);
            FacebookException facebookException = new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
            AppMethodBeat.o(8211);
            throw facebookException;
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(8212);
            FacebookException facebookException = new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
            AppMethodBeat.o(8212);
            throw facebookException;
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.i(8213);
            ShareContentValidation.access$500(sharePhoto, this);
            AppMethodBeat.o(8213);
        }
    }

    /* access modifiers changed from: package-private */
    public static class ApiValidator extends Validator {
        private ApiValidator() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.i(8190);
            ShareContentValidation.access$600(sharePhoto, this);
            AppMethodBeat.o(8190);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.i(8191);
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                FacebookException facebookException = new FacebookException("Cannot share video content with place IDs using the share api");
                AppMethodBeat.o(8191);
                throw facebookException;
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                FacebookException facebookException2 = new FacebookException("Cannot share video content with people IDs using the share api");
                AppMethodBeat.o(8191);
                throw facebookException2;
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                FacebookException facebookException3 = new FacebookException("Cannot share video content with referrer URL using the share api");
                AppMethodBeat.o(8191);
                throw facebookException3;
            } else {
                AppMethodBeat.o(8191);
            }
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(8192);
            FacebookException facebookException = new FacebookException("Cannot share ShareMediaContent using the share api");
            AppMethodBeat.o(8192);
            throw facebookException;
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(ShareLinkContent shareLinkContent) {
            AppMethodBeat.i(8193);
            if (!Utility.isNullOrEmpty(shareLinkContent.getQuote())) {
                FacebookException facebookException = new FacebookException("Cannot share link content with quote using the share api");
                AppMethodBeat.o(8193);
                throw facebookException;
            }
            AppMethodBeat.o(8193);
        }
    }

    /* access modifiers changed from: package-private */
    public static class Validator {
        private boolean isOpenGraphContent;

        private Validator() {
            this.isOpenGraphContent = false;
        }

        public void validate(ShareLinkContent shareLinkContent) {
            AppMethodBeat.i(8195);
            ShareContentValidation.access$700(shareLinkContent, this);
            AppMethodBeat.o(8195);
        }

        public void validate(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.i(8196);
            ShareContentValidation.access$800(sharePhotoContent, this);
            AppMethodBeat.o(8196);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.i(8197);
            ShareContentValidation.access$900(shareVideoContent, this);
            AppMethodBeat.o(8197);
        }

        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(8198);
            ShareContentValidation.access$1000(shareMediaContent, this);
            AppMethodBeat.o(8198);
        }

        public void validate(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.i(8199);
            ShareContentValidation.access$1100(shareCameraEffectContent, this);
            AppMethodBeat.o(8199);
        }

        public void validate(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.i(8200);
            this.isOpenGraphContent = true;
            ShareContentValidation.access$1200(shareOpenGraphContent, this);
            AppMethodBeat.o(8200);
        }

        public void validate(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.i(8201);
            ShareContentValidation.access$1300(shareOpenGraphAction, this);
            AppMethodBeat.o(8201);
        }

        public void validate(ShareOpenGraphObject shareOpenGraphObject) {
            AppMethodBeat.i(8202);
            ShareContentValidation.access$1400(shareOpenGraphObject, this);
            AppMethodBeat.o(8202);
        }

        public void validate(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            AppMethodBeat.i(8203);
            ShareContentValidation.access$1500(shareOpenGraphValueContainer, this, z);
            AppMethodBeat.o(8203);
        }

        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.i(8204);
            ShareContentValidation.access$1600(sharePhoto, this);
            AppMethodBeat.o(8204);
        }

        public void validate(ShareVideo shareVideo) {
            AppMethodBeat.i(8205);
            ShareContentValidation.access$1700(shareVideo, this);
            AppMethodBeat.o(8205);
        }

        public void validate(ShareMedia shareMedia) {
            AppMethodBeat.i(8206);
            ShareContentValidation.validateMedium(shareMedia, this);
            AppMethodBeat.o(8206);
        }

        public void validate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            AppMethodBeat.i(8207);
            ShareContentValidation.access$1800(shareMessengerOpenGraphMusicTemplateContent);
            AppMethodBeat.o(8207);
        }

        public void validate(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.i(8208);
            ShareContentValidation.access$1900(shareMessengerGenericTemplateContent);
            AppMethodBeat.o(8208);
        }

        public void validate(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            AppMethodBeat.i(8209);
            ShareContentValidation.access$2000(shareMessengerMediaTemplateContent);
            AppMethodBeat.o(8209);
        }

        public void validate(ShareStoryContent shareStoryContent) {
            AppMethodBeat.i(8210);
            ShareContentValidation.access$400(shareStoryContent, this);
            AppMethodBeat.o(8210);
        }

        public boolean isOpenGraphContent() {
            return this.isOpenGraphContent;
        }
    }
}
