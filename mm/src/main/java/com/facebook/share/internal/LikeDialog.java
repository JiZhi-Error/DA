package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LikeDialog extends FacebookDialogBase<LikeContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
    private static final String TAG = "LikeDialog";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    @Deprecated
    public /* bridge */ /* synthetic */ void show(LikeContent likeContent) {
        AppMethodBeat.i(8139);
        show(likeContent);
        AppMethodBeat.o(8139);
    }

    static /* synthetic */ Bundle access$200(LikeContent likeContent) {
        AppMethodBeat.i(8140);
        Bundle createParameters = createParameters(likeContent);
        AppMethodBeat.o(8140);
        return createParameters;
    }

    static /* synthetic */ DialogFeature access$300() {
        AppMethodBeat.i(8141);
        DialogFeature feature = getFeature();
        AppMethodBeat.o(8141);
        return feature;
    }

    static {
        AppMethodBeat.i(8142);
        AppMethodBeat.o(8142);
    }

    @Deprecated
    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle2) {
            this.bundle = bundle2;
        }

        public final Bundle getData() {
            return this.bundle;
        }
    }

    @Deprecated
    public static boolean canShowNativeDialog() {
        return false;
    }

    @Deprecated
    public static boolean canShowWebFallback() {
        return false;
    }

    @Deprecated
    public LikeDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public LikeDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(8133);
        AppMethodBeat.o(8133);
    }

    @Deprecated
    public LikeDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(8134);
        AppMethodBeat.o(8134);
    }

    @Deprecated
    public LikeDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public void show(LikeContent likeContent) {
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        AppMethodBeat.i(8135);
        AppCall appCall = new AppCall(getRequestCode());
        AppMethodBeat.o(8135);
        return appCall;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<LikeContent, Result>.ModeHandler> getOrderedModeHandlers() {
        AppMethodBeat.i(8136);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new WebFallbackHandler());
        AppMethodBeat.o(8136);
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.i(8137);
        final AnonymousClass1 r0 = facebookCallback == null ? null : new ResultProcessor(facebookCallback) {
            /* class com.facebook.share.internal.LikeDialog.AnonymousClass1 */

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                AppMethodBeat.i(8123);
                facebookCallback.onSuccess(new Result(bundle));
                AppMethodBeat.o(8123);
            }
        };
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.share.internal.LikeDialog.AnonymousClass2 */

            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i2, Intent intent) {
                AppMethodBeat.i(8124);
                boolean handleActivityResult = ShareInternalUtility.handleActivityResult(LikeDialog.this.getRequestCode(), i2, intent, r0);
                AppMethodBeat.o(8124);
                return handleActivityResult;
            }
        });
        AppMethodBeat.o(8137);
    }

    class NativeHandler extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        private NativeHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8129);
            boolean canShow = canShow((LikeContent) obj, z);
            AppMethodBeat.o(8129);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8128);
            AppCall createAppCall = createAppCall((LikeContent) obj);
            AppMethodBeat.o(8128);
            return createAppCall;
        }

        public boolean canShow(LikeContent likeContent, boolean z) {
            return false;
        }

        public AppCall createAppCall(final LikeContent likeContent) {
            AppMethodBeat.i(8127);
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() {
                /* class com.facebook.share.internal.LikeDialog.NativeHandler.AnonymousClass1 */

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    AppMethodBeat.i(8125);
                    Bundle access$200 = LikeDialog.access$200(likeContent);
                    AppMethodBeat.o(8125);
                    return access$200;
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    AppMethodBeat.i(8126);
                    Bundle bundle = new Bundle();
                    AppMethodBeat.o(8126);
                    return bundle;
                }
            }, LikeDialog.access$300());
            AppMethodBeat.o(8127);
            return createBaseAppCall;
        }
    }

    class WebFallbackHandler extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        private WebFallbackHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppMethodBeat.i(8132);
            boolean canShow = canShow((LikeContent) obj, z);
            AppMethodBeat.o(8132);
            return canShow;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ AppCall createAppCall(Object obj) {
            AppMethodBeat.i(8131);
            AppCall createAppCall = createAppCall((LikeContent) obj);
            AppMethodBeat.o(8131);
            return createAppCall;
        }

        public boolean canShow(LikeContent likeContent, boolean z) {
            return false;
        }

        public AppCall createAppCall(LikeContent likeContent) {
            AppMethodBeat.i(8130);
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, LikeDialog.access$200(likeContent), LikeDialog.access$300());
            AppMethodBeat.o(8130);
            return createBaseAppCall;
        }
    }

    private static DialogFeature getFeature() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    private static Bundle createParameters(LikeContent likeContent) {
        AppMethodBeat.i(8138);
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.getObjectId());
        bundle.putString("object_type", likeContent.getObjectType());
        AppMethodBeat.o(8138);
        return bundle;
    }
}
