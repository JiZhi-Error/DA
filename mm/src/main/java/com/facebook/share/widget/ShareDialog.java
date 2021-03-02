package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog extends FacebookDialogBase<ShareContent, Sharer.Result> implements Sharer {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    private static final String FEED_DIALOG = "feed";
    private static final String TAG = ShareDialog.class.getSimpleName();
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private boolean shouldFailOnDataError;

    static /* synthetic */ Activity access$1000(ShareDialog shareDialog) {
        AppMethodBeat.i(8758);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.o(8758);
        return activityContext;
    }

    static /* synthetic */ Activity access$1100(ShareDialog shareDialog) {
        AppMethodBeat.i(8759);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.o(8759);
        return activityContext;
    }

    static /* synthetic */ boolean access$500(Class cls) {
        AppMethodBeat.i(8753);
        boolean canShowNative = canShowNative(cls);
        AppMethodBeat.o(8753);
        return canShowNative;
    }

    static /* synthetic */ Activity access$600(ShareDialog shareDialog) {
        AppMethodBeat.i(8754);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.o(8754);
        return activityContext;
    }

    static /* synthetic */ void access$700(ShareDialog shareDialog, Context context, ShareContent shareContent, Mode mode) {
        AppMethodBeat.i(8755);
        shareDialog.logDialogShare(context, shareContent, mode);
        AppMethodBeat.o(8755);
    }

    static /* synthetic */ DialogFeature access$800(Class cls) {
        AppMethodBeat.i(8756);
        DialogFeature feature = getFeature(cls);
        AppMethodBeat.o(8756);
        return feature;
    }

    static /* synthetic */ boolean access$900(ShareContent shareContent) {
        AppMethodBeat.i(8757);
        boolean canShowWebCheck = canShowWebCheck(shareContent);
        AppMethodBeat.o(8757);
        return canShowWebCheck;
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED;

        public static Mode valueOf(String str) {
            AppMethodBeat.i(8711);
            Mode mode = (Mode) Enum.valueOf(Mode.class, str);
            AppMethodBeat.o(8711);
            return mode;
        }

        static {
            AppMethodBeat.i(8712);
            AppMethodBeat.o(8712);
        }
    }

    static {
        AppMethodBeat.i(8760);
        AppMethodBeat.o(8760);
    }

    public static void show(Activity activity, ShareContent shareContent) {
        AppMethodBeat.i(8730);
        new ShareDialog(activity).show(shareContent);
        AppMethodBeat.o(8730);
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        AppMethodBeat.i(8731);
        show(new FragmentWrapper(fragment), shareContent);
        AppMethodBeat.o(8731);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        AppMethodBeat.i(8732);
        show(new FragmentWrapper(fragment), shareContent);
        AppMethodBeat.o(8732);
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        AppMethodBeat.i(8733);
        new ShareDialog(fragmentWrapper).show(shareContent);
        AppMethodBeat.o(8733);
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        AppMethodBeat.i(8734);
        if (canShowWebTypeCheck(cls) || canShowNative(cls)) {
            AppMethodBeat.o(8734);
            return true;
        }
        AppMethodBeat.o(8734);
        return false;
    }

    private static boolean canShowNative(Class<? extends ShareContent> cls) {
        AppMethodBeat.i(8735);
        DialogFeature feature = getFeature(cls);
        if (feature == null || !DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
            AppMethodBeat.o(8735);
            return false;
        }
        AppMethodBeat.o(8735);
        return true;
    }

    private static boolean canShowWebTypeCheck(Class<? extends ShareContent> cls) {
        AppMethodBeat.i(8736);
        if (ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.isCurrentAccessTokenActive())) {
            AppMethodBeat.o(8736);
            return true;
        }
        AppMethodBeat.o(8736);
        return false;
    }

    private static boolean canShowWebCheck(ShareContent shareContent) {
        AppMethodBeat.i(8737);
        if (!canShowWebTypeCheck(shareContent.getClass())) {
            AppMethodBeat.o(8737);
            return false;
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            try {
                ShareInternalUtility.toJSONObjectForWeb((ShareOpenGraphContent) shareContent);
            } catch (Exception e2) {
                Utility.logd(TAG, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e2);
                AppMethodBeat.o(8737);
                return false;
            }
        }
        AppMethodBeat.o(8737);
        return true;
    }

    public ShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        AppMethodBeat.i(8738);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
        AppMethodBeat.o(8738);
    }

    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(8739);
        AppMethodBeat.o(8739);
    }

    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(8740);
        AppMethodBeat.o(8740);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
        AppMethodBeat.i(8741);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
        AppMethodBeat.o(8741);
    }

    ShareDialog(Activity activity, int i2) {
        super(activity, i2);
        AppMethodBeat.i(8742);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i2);
        AppMethodBeat.o(8742);
    }

    ShareDialog(Fragment fragment, int i2) {
        this(new FragmentWrapper(fragment), i2);
        AppMethodBeat.i(8743);
        AppMethodBeat.o(8743);
    }

    ShareDialog(android.app.Fragment fragment, int i2) {
        this(new FragmentWrapper(fragment), i2);
        AppMethodBeat.i(8744);
        AppMethodBeat.o(8744);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper, int i2) {
        super(fragmentWrapper, i2);
        AppMethodBeat.i(8745);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i2);
        AppMethodBeat.o(8745);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public final void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer.Result> facebookCallback) {
        AppMethodBeat.i(8746);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
        AppMethodBeat.o(8746);
    }

    @Override // com.facebook.share.Sharer
    public final boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    @Override // com.facebook.share.Sharer
    public final void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public final boolean canShow(ShareContent shareContent, Mode mode) {
        AppMethodBeat.i(8747);
        Mode mode2 = mode;
        if (mode == Mode.AUTOMATIC) {
            mode2 = BASE_AUTOMATIC_MODE;
        }
        boolean canShowImpl = canShowImpl(shareContent, mode2);
        AppMethodBeat.o(8747);
        return canShowImpl;
    }

    public final void show(ShareContent shareContent, Mode mode) {
        AppMethodBeat.i(8748);
        this.isAutomaticMode = mode == Mode.AUTOMATIC;
        Mode mode2 = mode;
        if (this.isAutomaticMode) {
            mode2 = BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, mode2);
        AppMethodBeat.o(8748);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public final AppCall createBaseAppCall() {
        AppMethodBeat.i(8749);
        AppCall appCall = new AppCall(getRequestCode());
        AppMethodBeat.o(8749);
        return appCall;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public final List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        AppMethodBeat.i(8750);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new FeedHandler());
        arrayList.add(new WebShareHandler());
        arrayList.add(new CameraEffectHandler());
        arrayList.add(new ShareStoryHandler());
        AppMethodBeat.o(8750);
        return arrayList;
    }

    class NativeHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        private NativeHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8718);
            boolean canShow = canShow((ShareContent) obj, z);
            AppMethodBeat.o(8718);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8717);
            AppCall createAppCall = createAppCall((ShareContent) obj);
            AppMethodBeat.o(8717);
            return createAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            boolean z2;
            AppMethodBeat.i(8715);
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                AppMethodBeat.o(8715);
                return false;
            }
            if (!z) {
                if (shareContent.getShareHashtag() != null) {
                    z2 = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
                } else {
                    z2 = true;
                }
                if ((shareContent instanceof ShareLinkContent) && !Utility.isNullOrEmpty(((ShareLinkContent) shareContent).getQuote())) {
                    z2 &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            } else {
                z2 = true;
            }
            if (!z2 || !ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.o(8715);
                return false;
            }
            AppMethodBeat.o(8715);
            return true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.i(8716);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$600(ShareDialog.this), shareContent, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                /* class com.facebook.share.widget.ShareDialog.NativeHandler.AnonymousClass1 */

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    AppMethodBeat.i(8713);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8713);
                    return create;
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    AppMethodBeat.i(8714);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8714);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.o(8716);
            return createBaseAppCall;
        }
    }

    class WebShareHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        private WebShareHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8729);
            boolean canShow = canShow((ShareContent) obj, z);
            AppMethodBeat.o(8729);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8728);
            AppCall createAppCall = createAppCall((ShareContent) obj);
            AppMethodBeat.o(8728);
            return createAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.WEB;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.i(8725);
            if (shareContent == null || !ShareDialog.access$900(shareContent)) {
                AppMethodBeat.o(8725);
                return false;
            }
            AppMethodBeat.o(8725);
            return true;
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle create;
            AppMethodBeat.i(8726);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1000(ShareDialog.this), shareContent, Mode.WEB);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                create = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                create = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId()));
            } else {
                create = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), create);
            AppMethodBeat.o(8726);
            return createBaseAppCall;
        }

        private String getActionName(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return ShareDialog.WEB_OG_SHARE_DIALOG;
            }
            return null;
        }

        private SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            AppMethodBeat.i(8727);
            SharePhotoContent.Builder readFrom = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < sharePhotoContent.getPhotos().size(); i2++) {
                SharePhoto sharePhoto = sharePhotoContent.getPhotos().get(i2);
                Bitmap bitmap = sharePhoto.getBitmap();
                if (bitmap != null) {
                    NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                    sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                    arrayList2.add(createAttachment);
                }
                arrayList.add(sharePhoto);
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            SharePhotoContent build = readFrom.build();
            AppMethodBeat.o(8727);
            return build;
        }
    }

    class FeedHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        private FeedHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8709);
            boolean canShow = canShow((ShareContent) obj, z);
            AppMethodBeat.o(8709);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8708);
            AppCall createAppCall = createAppCall((ShareContent) obj);
            AppMethodBeat.o(8708);
            return createAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.FEED;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle createForFeed;
            AppMethodBeat.i(8707);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1100(ShareDialog.this), shareContent, Mode.FEED);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.validateForWebShare(shareLinkContent);
                createForFeed = WebDialogParameters.createForFeed(shareLinkContent);
            } else {
                createForFeed = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, ShareDialog.FEED_DIALOG, createForFeed);
            AppMethodBeat.o(8707);
            return createBaseAppCall;
        }
    }

    class CameraEffectHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        private CameraEffectHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8706);
            boolean canShow = canShow((ShareContent) obj, z);
            AppMethodBeat.o(8706);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8705);
            AppCall createAppCall = createAppCall((ShareContent) obj);
            AppMethodBeat.o(8705);
            return createAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.i(8703);
            if (!(shareContent instanceof ShareCameraEffectContent) || !ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.o(8703);
                return false;
            }
            AppMethodBeat.o(8703);
            return true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.i(8704);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                /* class com.facebook.share.widget.ShareDialog.CameraEffectHandler.AnonymousClass1 */

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    AppMethodBeat.i(8701);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8701);
                    return create;
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    AppMethodBeat.i(8702);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8702);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.o(8704);
            return createBaseAppCall;
        }
    }

    class ShareStoryHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
        private ShareStoryHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8724);
            boolean canShow = canShow((ShareContent) obj, z);
            AppMethodBeat.o(8724);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8723);
            AppCall createAppCall = createAppCall((ShareContent) obj);
            AppMethodBeat.o(8723);
            return createAppCall;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.i(8721);
            if (!(shareContent instanceof ShareStoryContent) || !ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.o(8721);
                return false;
            }
            AppMethodBeat.o(8721);
            return true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.i(8722);
            ShareContentValidation.validateForStoryShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                /* class com.facebook.share.widget.ShareDialog.ShareStoryHandler.AnonymousClass1 */

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    AppMethodBeat.i(8719);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8719);
                    return create;
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    AppMethodBeat.i(8720);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.o(8720);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.o(8722);
            return createBaseAppCall;
        }
    }

    private static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        AppMethodBeat.i(8751);
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            ShareDialogFeature shareDialogFeature = ShareDialogFeature.SHARE_DIALOG;
            AppMethodBeat.o(8751);
            return shareDialogFeature;
        } else if (SharePhotoContent.class.isAssignableFrom(cls)) {
            ShareDialogFeature shareDialogFeature2 = ShareDialogFeature.PHOTOS;
            AppMethodBeat.o(8751);
            return shareDialogFeature2;
        } else if (ShareVideoContent.class.isAssignableFrom(cls)) {
            ShareDialogFeature shareDialogFeature3 = ShareDialogFeature.VIDEO;
            AppMethodBeat.o(8751);
            return shareDialogFeature3;
        } else if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            OpenGraphActionDialogFeature openGraphActionDialogFeature = OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
            AppMethodBeat.o(8751);
            return openGraphActionDialogFeature;
        } else if (ShareMediaContent.class.isAssignableFrom(cls)) {
            ShareDialogFeature shareDialogFeature4 = ShareDialogFeature.MULTIMEDIA;
            AppMethodBeat.o(8751);
            return shareDialogFeature4;
        } else if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            CameraEffectFeature cameraEffectFeature = CameraEffectFeature.SHARE_CAMERA_EFFECT;
            AppMethodBeat.o(8751);
            return cameraEffectFeature;
        } else if (ShareStoryContent.class.isAssignableFrom(cls)) {
            ShareStoryFeature shareStoryFeature = ShareStoryFeature.SHARE_STORY_ASSET;
            AppMethodBeat.o(8751);
            return shareStoryFeature;
        } else {
            AppMethodBeat.o(8751);
            return null;
        }
    }

    private void logDialogShare(Context context, ShareContent shareContent, Mode mode) {
        String str;
        String str2;
        AppMethodBeat.i(8752);
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        switch (mode) {
            case AUTOMATIC:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
                break;
            case WEB:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
                break;
            case NATIVE:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
                break;
            default:
                str = "unknown";
                break;
        }
        DialogFeature feature = getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str2 = "status";
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str2 = "photo";
        } else if (feature == ShareDialogFeature.VIDEO) {
            str2 = "video";
        } else if (feature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str2 = "open_graph";
        } else {
            str2 = "unknown";
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str2);
        newLogger.logSdkEvent("fb_share_dialog_show", null, bundle);
        AppMethodBeat.o(8752);
    }
}
