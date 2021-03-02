package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;

public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    protected static final Object BASE_AUTOMATIC_MODE = new Object();
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private final FragmentWrapper fragmentWrapper;
    private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCode;

    /* access modifiers changed from: protected */
    public abstract AppCall createBaseAppCall();

    /* access modifiers changed from: protected */
    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    /* access modifiers changed from: protected */
    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    protected FacebookDialogBase(Activity activity2, int i2) {
        Validate.notNull(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        this.activity = activity2;
        this.fragmentWrapper = null;
        this.requestCode = i2;
    }

    protected FacebookDialogBase(FragmentWrapper fragmentWrapper2, int i2) {
        Validate.notNull(fragmentWrapper2, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper2;
        this.activity = null;
        this.requestCode = i2;
        if (fragmentWrapper2.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    @Override // com.facebook.FacebookDialog
    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        registerCallbackImpl((CallbackManagerImpl) callbackManager, facebookCallback);
    }

    @Override // com.facebook.FacebookDialog
    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback, int i2) {
        setRequestCode(i2);
        registerCallback(callbackManager, facebookCallback);
    }

    /* access modifiers changed from: protected */
    public void setRequestCode(int i2) {
        if (FacebookSdk.isFacebookRequestCode(i2)) {
            throw new IllegalArgumentException("Request code " + i2 + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.requestCode = i2;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public boolean canShowImpl(CONTENT content, Object obj) {
        boolean z = obj == BASE_AUTOMATIC_MODE;
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : cachedModeHandlers()) {
            if ((z || Utility.areObjectsEqual(modeHandler.getMode(), obj)) && modeHandler.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public void showImpl(CONTENT content, Object obj) {
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode != null) {
            if (this.fragmentWrapper != null) {
                DialogPresenter.present(createAppCallForMode, this.fragmentWrapper);
            } else {
                DialogPresenter.present(createAppCallForMode, this.activity);
            }
        } else if (FacebookSdk.isDebugEnabled()) {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
    }

    public Activity getActivityContext() {
        if (this.activity != null) {
            return this.activity;
        }
        if (this.fragmentWrapper != null) {
            return this.fragmentWrapper.getActivity();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void startActivityForResult(Intent intent, int i2) {
        String str = null;
        if (this.activity != null) {
            this.activity.startActivityForResult(intent, i2);
        } else if (this.fragmentWrapper == null) {
            str = "Failed to find Activity or Fragment to startActivityForResult ";
        } else if (this.fragmentWrapper.getNativeFragment() != null) {
            this.fragmentWrapper.getNativeFragment().startActivityForResult(intent, i2);
        } else if (this.fragmentWrapper.getSupportFragment() != null) {
            this.fragmentWrapper.getSupportFragment().startActivityForResult(intent, i2);
        } else {
            str = "Failed to find Activity or Fragment to startActivityForResult ";
        }
        if (str != null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, getClass().getName(), str);
        }
    }

    private AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z;
        AppCall appCall;
        if (obj == BASE_AUTOMATIC_MODE) {
            z = true;
        } else {
            z = false;
        }
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                appCall = null;
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
            if ((z || Utility.areObjectsEqual(next.getMode(), obj)) && next.canShow(content, true)) {
                try {
                    appCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e2) {
                    appCall = createBaseAppCall();
                    DialogPresenter.setupAppCallForValidationError(appCall, e2);
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        AppCall createBaseAppCall = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall);
        return createBaseAppCall;
    }

    private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        return this.modeHandlers;
    }

    public abstract class ModeHandler {
        public abstract boolean canShow(CONTENT content, boolean z);

        public abstract AppCall createAppCall(CONTENT content);

        protected ModeHandler() {
        }

        public Object getMode() {
            return FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
    }
}
