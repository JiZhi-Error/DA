package com.facebook.login.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoginButton extends FacebookButtonBase {
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;
    private boolean confirmLogout;
    private String loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    private LoginButtonProperties properties = new LoginButtonProperties();
    private boolean toolTipChecked;
    private long toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle = ToolTipPopup.Style.BLUE;

    static /* synthetic */ void access$000(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        AppMethodBeat.i(40448);
        loginButton.showToolTipPerSettings(fetchedAppSettings);
        AppMethodBeat.o(40448);
    }

    static /* synthetic */ Activity access$100(LoginButton loginButton) {
        AppMethodBeat.i(40449);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.o(40449);
        return activity;
    }

    static /* synthetic */ void access$200(LoginButton loginButton) {
        AppMethodBeat.i(40450);
        loginButton.setButtonText();
        AppMethodBeat.o(40450);
    }

    static /* synthetic */ void access$300(LoginButton loginButton, View view) {
        AppMethodBeat.i(40451);
        loginButton.callExternalOnClickListener(view);
        AppMethodBeat.o(40451);
    }

    static /* synthetic */ Activity access$800(LoginButton loginButton) {
        AppMethodBeat.i(40452);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.o(40452);
        return activity;
    }

    static /* synthetic */ Activity access$900(LoginButton loginButton) {
        AppMethodBeat.i(40453);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.o(40453);
        return activity;
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode DEFAULT = AUTOMATIC;
        private int intValue;
        private String stringValue;

        public static ToolTipMode valueOf(String str) {
            AppMethodBeat.i(40411);
            ToolTipMode toolTipMode = (ToolTipMode) Enum.valueOf(ToolTipMode.class, str);
            AppMethodBeat.o(40411);
            return toolTipMode;
        }

        static {
            AppMethodBeat.i(40413);
            AppMethodBeat.o(40413);
        }

        public static ToolTipMode fromInt(int i2) {
            AppMethodBeat.i(40412);
            ToolTipMode[] values = values();
            for (ToolTipMode toolTipMode : values) {
                if (toolTipMode.getValue() == i2) {
                    AppMethodBeat.o(40412);
                    return toolTipMode;
                }
            }
            AppMethodBeat.o(40412);
            return null;
        }

        private ToolTipMode(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    static {
        AppMethodBeat.i(40454);
        AppMethodBeat.o(40454);
    }

    /* access modifiers changed from: package-private */
    public static class LoginButtonProperties {
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private LoginAuthorizationType authorizationType = null;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private List<String> permissions = Collections.emptyList();

        LoginButtonProperties() {
            AppMethodBeat.i(40402);
            AppMethodBeat.o(40402);
        }

        public void setDefaultAudience(DefaultAudience defaultAudience2) {
            this.defaultAudience = defaultAudience2;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public void setReadPermissions(List<String> list) {
            AppMethodBeat.i(40403);
            if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
                AppMethodBeat.o(40403);
                throw unsupportedOperationException;
            }
            this.permissions = list;
            this.authorizationType = LoginAuthorizationType.READ;
            AppMethodBeat.o(40403);
        }

        public void setPublishPermissions(List<String> list) {
            AppMethodBeat.i(40404);
            if (LoginAuthorizationType.READ.equals(this.authorizationType)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
                AppMethodBeat.o(40404);
                throw unsupportedOperationException;
            } else if (Utility.isNullOrEmpty(list)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
                AppMethodBeat.o(40404);
                throw illegalArgumentException;
            } else {
                this.permissions = list;
                this.authorizationType = LoginAuthorizationType.PUBLISH;
                AppMethodBeat.o(40404);
            }
        }

        /* access modifiers changed from: package-private */
        public List<String> getPermissions() {
            return this.permissions;
        }

        public void clearPermissions() {
            this.permissions = null;
            this.authorizationType = null;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior2) {
            this.loginBehavior = loginBehavior2;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public String getAuthType() {
            return this.authType;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.i(40414);
        AppMethodBeat.o(40414);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.i(40415);
        AppMethodBeat.o(40415);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.i(40416);
        AppMethodBeat.o(40416);
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        AppMethodBeat.i(40417);
        this.properties.setDefaultAudience(defaultAudience);
        AppMethodBeat.o(40417);
    }

    public DefaultAudience getDefaultAudience() {
        AppMethodBeat.i(40418);
        DefaultAudience defaultAudience = this.properties.getDefaultAudience();
        AppMethodBeat.o(40418);
        return defaultAudience;
    }

    public void setReadPermissions(List<String> list) {
        AppMethodBeat.i(40419);
        this.properties.setReadPermissions(list);
        AppMethodBeat.o(40419);
    }

    public void setReadPermissions(String... strArr) {
        AppMethodBeat.i(40420);
        this.properties.setReadPermissions(Arrays.asList(strArr));
        AppMethodBeat.o(40420);
    }

    public void setPublishPermissions(List<String> list) {
        AppMethodBeat.i(40421);
        this.properties.setPublishPermissions(list);
        AppMethodBeat.o(40421);
    }

    public void setPublishPermissions(String... strArr) {
        AppMethodBeat.i(40422);
        this.properties.setPublishPermissions(Arrays.asList(strArr));
        AppMethodBeat.o(40422);
    }

    public void clearPermissions() {
        AppMethodBeat.i(40423);
        this.properties.clearPermissions();
        AppMethodBeat.o(40423);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        AppMethodBeat.i(40424);
        this.properties.setLoginBehavior(loginBehavior);
        AppMethodBeat.o(40424);
    }

    public LoginBehavior getLoginBehavior() {
        AppMethodBeat.i(40425);
        LoginBehavior loginBehavior = this.properties.getLoginBehavior();
        AppMethodBeat.o(40425);
        return loginBehavior;
    }

    public String getAuthType() {
        AppMethodBeat.i(40426);
        String authType = this.properties.getAuthType();
        AppMethodBeat.o(40426);
        return authType;
    }

    public void setAuthType(String str) {
        AppMethodBeat.i(40427);
        this.properties.setAuthType(str);
        AppMethodBeat.o(40427);
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode2) {
        this.toolTipMode = toolTipMode2;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void setToolTipDisplayTime(long j2) {
        this.toolTipDisplayTime = j2;
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public void dismissToolTip() {
        AppMethodBeat.i(40428);
        if (this.toolTipPopup != null) {
            this.toolTipPopup.dismiss();
            this.toolTipPopup = null;
        }
        AppMethodBeat.o(40428);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.i(40429);
        getLoginManager().registerCallback(callbackManager, facebookCallback);
        AppMethodBeat.o(40429);
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        AppMethodBeat.i(40430);
        getLoginManager().unregisterCallback(callbackManager);
        AppMethodBeat.o(40430);
    }

    @Override // com.facebook.FacebookButtonBase
    public void onAttachedToWindow() {
        AppMethodBeat.i(40431);
        super.onAttachedToWindow();
        if (this.accessTokenTracker != null && !this.accessTokenTracker.isTracking()) {
            this.accessTokenTracker.startTracking();
            setButtonText();
        }
        AppMethodBeat.o(40431);
    }

    @Override // com.facebook.FacebookButtonBase
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(40432);
        super.onDraw(canvas);
        if (!this.toolTipChecked && !isInEditMode()) {
            this.toolTipChecked = true;
            checkToolTipSettings();
        }
        AppMethodBeat.o(40432);
    }

    private void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        AppMethodBeat.i(40433);
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayToolTip(fetchedAppSettings.getNuxContent());
        }
        AppMethodBeat.o(40433);
    }

    private void displayToolTip(String str) {
        AppMethodBeat.i(40434);
        this.toolTipPopup = new ToolTipPopup(str, this);
        this.toolTipPopup.setStyle(this.toolTipStyle);
        this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
        this.toolTipPopup.show();
        AppMethodBeat.o(40434);
    }

    private void checkToolTipSettings() {
        AppMethodBeat.i(40435);
        switch (this.toolTipMode) {
            case AUTOMATIC:
                final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                FacebookSdk.getExecutor().execute(new Runnable() {
                    /* class com.facebook.login.widget.LoginButton.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(40399);
                        final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                        LoginButton.access$100(LoginButton.this).runOnUiThread(new Runnable() {
                            /* class com.facebook.login.widget.LoginButton.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(40398);
                                LoginButton.access$000(LoginButton.this, queryAppSettings);
                                AppMethodBeat.o(40398);
                            }
                        });
                        AppMethodBeat.o(40399);
                    }
                });
                AppMethodBeat.o(40435);
                return;
            case DISPLAY_ALWAYS:
                displayToolTip(getResources().getString(R.string.b8j));
                break;
        }
        AppMethodBeat.o(40435);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(40436);
        super.onLayout(z, i2, i3, i4, i5);
        setButtonText();
        AppMethodBeat.o(40436);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(40437);
        super.onDetachedFromWindow();
        if (this.accessTokenTracker != null) {
            this.accessTokenTracker.stopTracking();
        }
        dismissToolTip();
        AppMethodBeat.o(40437);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(40438);
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            dismissToolTip();
        }
        AppMethodBeat.o(40438);
    }

    /* access modifiers changed from: package-private */
    public List<String> getPermissions() {
        AppMethodBeat.i(40439);
        List<String> permissions = this.properties.getPermissions();
        AppMethodBeat.o(40439);
        return permissions;
    }

    /* access modifiers changed from: package-private */
    public void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        AppMethodBeat.i(40440);
        super.configureButton(context, attributeSet, i2, i3);
        setInternalOnClickListener(getNewLoginClickListener());
        parseLoginButtonAttributes(context, attributeSet, i2, i3);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(R.color.jr));
            this.loginText = "Continue with Facebook";
        } else {
            this.accessTokenTracker = new AccessTokenTracker() {
                /* class com.facebook.login.widget.LoginButton.AnonymousClass2 */

                @Override // com.facebook.AccessTokenTracker
                public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                    AppMethodBeat.i(40400);
                    LoginButton.access$200(LoginButton.this);
                    AppMethodBeat.o(40400);
                }
            };
        }
        setButtonText();
        setCompoundDrawablesWithIntrinsicBounds(a.l(getContext(), R.drawable.q7), (Drawable) null, (Drawable) null, (Drawable) null);
        AppMethodBeat.o(40440);
    }

    /* access modifiers changed from: protected */
    public LoginClickListener getNewLoginClickListener() {
        AppMethodBeat.i(40441);
        LoginClickListener loginClickListener = new LoginClickListener();
        AppMethodBeat.o(40441);
        return loginClickListener;
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.a5h;
    }

    private void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i2, int i3) {
        AppMethodBeat.i(40442);
        this.toolTipMode = ToolTipMode.DEFAULT;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.facebook.login.R.styleable.com_facebook_login_view, i2, i3);
        try {
            this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
            this.loginText = obtainStyledAttributes.getString(1);
            this.logoutText = obtainStyledAttributes.getString(2);
            this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(3, ToolTipMode.DEFAULT.getValue()));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(40442);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(40443);
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingBottom = getCompoundPaddingBottom() + ((int) Math.ceil((double) (Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top)))) + getCompoundPaddingTop();
        Resources resources = getResources();
        String str = this.loginText;
        if (str == null) {
            str = resources.getString(R.string.b87);
            int measureButtonWidth = measureButtonWidth(str);
            if (resolveSize(measureButtonWidth, i2) < measureButtonWidth) {
                str = resources.getString(R.string.b86);
            }
        }
        int measureButtonWidth2 = measureButtonWidth(str);
        String str2 = this.logoutText;
        if (str2 == null) {
            str2 = resources.getString(R.string.b8_);
        }
        setMeasuredDimension(resolveSize(Math.max(measureButtonWidth2, measureButtonWidth(str2)), i2), compoundPaddingBottom);
        AppMethodBeat.o(40443);
    }

    private int measureButtonWidth(String str) {
        AppMethodBeat.i(40444);
        int measureTextWidth = measureTextWidth(str) + getCompoundPaddingLeft() + getCompoundDrawablePadding() + getCompoundPaddingRight();
        AppMethodBeat.o(40444);
        return measureTextWidth;
    }

    private void setButtonText() {
        String string;
        AppMethodBeat.i(40445);
        Resources resources = getResources();
        if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
            if (this.logoutText != null) {
                string = this.logoutText;
            } else {
                string = resources.getString(R.string.b8_);
            }
            setText(string);
            AppMethodBeat.o(40445);
        } else if (this.loginText != null) {
            setText(this.loginText);
            AppMethodBeat.o(40445);
        } else {
            String string2 = resources.getString(R.string.b87);
            int width = getWidth();
            if (width != 0 && measureButtonWidth(string2) > width) {
                string2 = resources.getString(R.string.b86);
            }
            setText(string2);
            AppMethodBeat.o(40445);
        }
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        AppMethodBeat.i(40446);
        int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        AppMethodBeat.o(40446);
        return requestCode;
    }

    /* access modifiers changed from: package-private */
    public LoginManager getLoginManager() {
        AppMethodBeat.i(40447);
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        LoginManager loginManager2 = this.loginManager;
        AppMethodBeat.o(40447);
        return loginManager2;
    }

    /* access modifiers changed from: package-private */
    public void setLoginManager(LoginManager loginManager2) {
        this.loginManager = loginManager2;
    }

    /* access modifiers changed from: protected */
    public class LoginClickListener implements View.OnClickListener {
        protected LoginClickListener() {
        }

        public void onClick(View view) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(40406);
            LoginButton.access$300(LoginButton.this, view);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (AccessToken.isCurrentAccessTokenActive()) {
                performLogout(LoginButton.this.getContext());
            } else {
                performLogin();
            }
            AppEventsLogger newLogger = AppEventsLogger.newLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            if (currentAccessToken != null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            bundle.putInt("logging_in", i2);
            if (!AccessToken.isCurrentAccessTokenActive()) {
                i3 = 0;
            }
            bundle.putInt("access_token_expired", i3);
            newLogger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, bundle);
            AppMethodBeat.o(40406);
        }

        /* access modifiers changed from: protected */
        public void performLogin() {
            AppMethodBeat.i(40407);
            LoginManager loginManager = getLoginManager();
            if (LoginAuthorizationType.PUBLISH.equals(LoginButton.this.properties.authorizationType)) {
                if (LoginButton.this.getFragment() != null) {
                    loginManager.logInWithPublishPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.permissions);
                    AppMethodBeat.o(40407);
                } else if (LoginButton.this.getNativeFragment() != null) {
                    loginManager.logInWithPublishPermissions(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions);
                    AppMethodBeat.o(40407);
                } else {
                    loginManager.logInWithPublishPermissions(LoginButton.access$800(LoginButton.this), LoginButton.this.properties.permissions);
                    AppMethodBeat.o(40407);
                }
            } else if (LoginButton.this.getFragment() != null) {
                loginManager.logInWithReadPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.permissions);
                AppMethodBeat.o(40407);
            } else if (LoginButton.this.getNativeFragment() != null) {
                loginManager.logInWithReadPermissions(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions);
                AppMethodBeat.o(40407);
            } else {
                loginManager.logInWithReadPermissions(LoginButton.access$900(LoginButton.this), LoginButton.this.properties.permissions);
                AppMethodBeat.o(40407);
            }
        }

        /* access modifiers changed from: protected */
        public void performLogout(Context context) {
            String string;
            AppMethodBeat.i(40408);
            final LoginManager loginManager = getLoginManager();
            if (LoginButton.this.confirmLogout) {
                String string2 = LoginButton.this.getResources().getString(R.string.b89);
                String string3 = LoginButton.this.getResources().getString(R.string.b85);
                Profile currentProfile = Profile.getCurrentProfile();
                if (currentProfile == null || currentProfile.getName() == null) {
                    string = LoginButton.this.getResources().getString(R.string.b8b);
                } else {
                    string = String.format(LoginButton.this.getResources().getString(R.string.b8a), currentProfile.getName());
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new DialogInterface.OnClickListener() {
                    /* class com.facebook.login.widget.LoginButton.LoginClickListener.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(40405);
                        loginManager.logOut();
                        AppMethodBeat.o(40405);
                    }
                }).setNegativeButton(string3, (DialogInterface.OnClickListener) null);
                builder.create().show();
                AppMethodBeat.o(40408);
                return;
            }
            loginManager.logOut();
            AppMethodBeat.o(40408);
        }

        /* access modifiers changed from: protected */
        public LoginManager getLoginManager() {
            AppMethodBeat.i(40409);
            LoginManager instance = LoginManager.getInstance();
            instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
            instance.setAuthType(LoginButton.this.getAuthType());
            AppMethodBeat.o(40409);
            return instance;
        }
    }
}
